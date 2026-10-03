package com.google.firebase.remoteconfig.internal;

import android.util.Log;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.remoteconfig.ConfigUpdate;
import com.google.firebase.remoteconfig.ConfigUpdateListener;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigClientException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigServerException;
import io.sentry.android.core.SentryLogcatAdapter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class ConfigAutoFetch {
    private static final int MAXIMUM_FETCH_ATTEMPTS = 3;
    private static final String REALTIME_DISABLED_KEY = "featureDisabled";
    private static final String TEMPLATE_VERSION_KEY = "latestTemplateVersionNumber";
    private final ConfigCacheClient activatedCache;
    private final ConfigFetchHandler configFetchHandler;
    private final Set<ConfigUpdateListener> eventListeners;
    private final HttpURLConnection httpURLConnection;
    private final Random random = new Random();
    private final ConfigUpdateListener retryCallback;
    private final ScheduledExecutorService scheduledExecutorService;

    public ConfigAutoFetch(HttpURLConnection httpURLConnection, ConfigFetchHandler configFetchHandler, ConfigCacheClient configCacheClient, Set<ConfigUpdateListener> set, ConfigUpdateListener configUpdateListener, ScheduledExecutorService scheduledExecutorService) {
        this.httpURLConnection = httpURLConnection;
        this.configFetchHandler = configFetchHandler;
        this.activatedCache = configCacheClient;
        this.eventListeners = set;
        this.retryCallback = configUpdateListener;
        this.scheduledExecutorService = scheduledExecutorService;
    }

    private void propagateErrors(FirebaseRemoteConfigException firebaseRemoteConfigException) {
        synchronized (this) {
            Iterator<ConfigUpdateListener> it2 = this.eventListeners.iterator();
            while (it2.hasNext()) {
                it2.next().onError(firebaseRemoteConfigException);
            }
        }
    }

    private void executeAllListenerCallbacks(ConfigUpdate configUpdate) {
        synchronized (this) {
            Iterator<ConfigUpdateListener> it2 = this.eventListeners.iterator();
            while (it2.hasNext()) {
                it2.next().onUpdate(configUpdate);
            }
        }
    }

    private boolean isEventListenersEmpty() {
        boolean zIsEmpty;
        synchronized (this) {
            zIsEmpty = this.eventListeners.isEmpty();
        }
        return zIsEmpty;
    }

    private String parseAndValidateConfigUpdateMessage(String str) {
        int iIndexOf = str.indexOf(123);
        int iLastIndexOf = str.lastIndexOf(125);
        return (iIndexOf < 0 || iLastIndexOf < 0 || iIndexOf >= iLastIndexOf) ? "" : str.substring(iIndexOf, iLastIndexOf + 1);
    }

    public void listenForNotifications() {
        HttpURLConnection httpURLConnection = this.httpURLConnection;
        try {
            if (httpURLConnection == null) {
                return;
            }
            try {
                InputStream inputStream = httpURLConnection.getInputStream();
                handleNotifications(inputStream);
                inputStream.close();
            } catch (IOException e) {
                Log.d(FirebaseRemoteConfig.TAG, "Stream was cancelled due to an exception. Retrying the connection...", e);
            }
        } finally {
            this.httpURLConnection.disconnect();
        }
    }

    private void handleNotifications(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
        loop0: while (true) {
            String andValidateConfigUpdateMessage = "";
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break loop0;
                }
                andValidateConfigUpdateMessage = andValidateConfigUpdateMessage + line;
                if (line.contains("}")) {
                    andValidateConfigUpdateMessage = parseAndValidateConfigUpdateMessage(andValidateConfigUpdateMessage);
                    if (andValidateConfigUpdateMessage.isEmpty()) {
                    }
                }
            }
            try {
                JSONObject jSONObject = new JSONObject(andValidateConfigUpdateMessage);
                if (jSONObject.has(REALTIME_DISABLED_KEY) && jSONObject.getBoolean(REALTIME_DISABLED_KEY)) {
                    this.retryCallback.onError(new FirebaseRemoteConfigServerException("The server is temporarily unavailable. Try again in a few minutes.", FirebaseRemoteConfigException.Code.CONFIG_UPDATE_UNAVAILABLE));
                    break;
                } else {
                    if (isEventListenersEmpty()) {
                        break;
                    }
                    if (jSONObject.has(TEMPLATE_VERSION_KEY)) {
                        long templateVersionNumber = this.configFetchHandler.getTemplateVersionNumber();
                        long j = jSONObject.getLong(TEMPLATE_VERSION_KEY);
                        if (j > templateVersionNumber) {
                            autoFetch(3, j);
                        }
                    }
                }
            } catch (JSONException e) {
                propagateErrors(new FirebaseRemoteConfigClientException("Unable to parse config update message.", e.getCause(), FirebaseRemoteConfigException.Code.CONFIG_UPDATE_MESSAGE_INVALID));
                SentryLogcatAdapter.e(FirebaseRemoteConfig.TAG, "Unable to parse latest config update message.", e);
            }
        }
        bufferedReader.close();
        inputStream.close();
    }

    private void autoFetch(final int i, final long j) {
        if (i == 0) {
            propagateErrors(new FirebaseRemoteConfigServerException("Unable to fetch the latest version of the template.", FirebaseRemoteConfigException.Code.CONFIG_UPDATE_NOT_FETCHED));
        } else {
            this.scheduledExecutorService.schedule(new Runnable() { // from class: com.google.firebase.remoteconfig.internal.ConfigAutoFetch.1
                @Override // java.lang.Runnable
                public void run() {
                    ConfigAutoFetch.this.fetchLatestConfig(i, j);
                }
            }, this.random.nextInt(4), TimeUnit.SECONDS);
        }
    }

    public Task<Void> fetchLatestConfig(int i, final long j) {
        Task taskContinueWithTask;
        synchronized (this) {
            final int i2 = i - 1;
            final Task<ConfigFetchHandler.FetchResponse> taskFetchNowWithTypeAndAttemptNumber = this.configFetchHandler.fetchNowWithTypeAndAttemptNumber(ConfigFetchHandler.FetchType.REALTIME, 3 - i2);
            final Task<ConfigContainer> task = this.activatedCache.get();
            taskContinueWithTask = Tasks.whenAllComplete((Task<?>[]) new Task[]{taskFetchNowWithTypeAndAttemptNumber, task}).continueWithTask(this.scheduledExecutorService, new Continuation() { // from class: com.google.firebase.remoteconfig.internal.ConfigAutoFetch$$ExternalSyntheticLambda0
                @Override // com.google.android.gms.tasks.Continuation
                public final Object then(Task task2) {
                    return this.f$0.lambda$fetchLatestConfig$0(taskFetchNowWithTypeAndAttemptNumber, task, j, i2, task2);
                }
            });
        }
        return taskContinueWithTask;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Task lambda$fetchLatestConfig$0(Task task, Task task2, long j, int i, Task task3) throws Exception {
        if (!task.isSuccessful()) {
            return Tasks.forException(new FirebaseRemoteConfigClientException("Failed to auto-fetch config update.", task.getException()));
        }
        if (!task2.isSuccessful()) {
            return Tasks.forException(new FirebaseRemoteConfigClientException("Failed to get activated config for auto-fetch", task2.getException()));
        }
        ConfigFetchHandler.FetchResponse fetchResponse = (ConfigFetchHandler.FetchResponse) task.getResult();
        ConfigContainer configContainerBuild = (ConfigContainer) task2.getResult();
        if (!fetchResponseIsUpToDate(fetchResponse, j).booleanValue()) {
            Log.d(FirebaseRemoteConfig.TAG, "Fetched template version is the same as SDK's current version. Retrying fetch.");
            autoFetch(i, j);
            return Tasks.forResult(null);
        }
        if (fetchResponse.getFetchedConfigs() == null) {
            Log.d(FirebaseRemoteConfig.TAG, "The fetch succeeded, but the backend had no updates.");
            return Tasks.forResult(null);
        }
        if (configContainerBuild == null) {
            configContainerBuild = ConfigContainer.newBuilder().build();
        }
        Set<String> changedParams = configContainerBuild.getChangedParams(fetchResponse.getFetchedConfigs());
        if (changedParams.isEmpty()) {
            Log.d(FirebaseRemoteConfig.TAG, "Config was fetched, but no params changed.");
            return Tasks.forResult(null);
        }
        executeAllListenerCallbacks(ConfigUpdate.create(changedParams));
        return Tasks.forResult(null);
    }

    private static Boolean fetchResponseIsUpToDate(ConfigFetchHandler.FetchResponse fetchResponse, long j) {
        if (fetchResponse.getFetchedConfigs() != null) {
            return Boolean.valueOf(fetchResponse.getFetchedConfigs().getTemplateVersionNumber() >= j);
        }
        return Boolean.valueOf(fetchResponse.getStatus() == 1);
    }
}
