package com.transistorsoft.locationmanager.http;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.common.net.HttpHeaders;
import com.transistorsoft.locationmanager.adapter.BackgroundGeolocation;
import com.transistorsoft.locationmanager.adapter.TSConfig;
import com.transistorsoft.locationmanager.adapter.callback.TSAuthorizationCallback;
import com.transistorsoft.locationmanager.adapter.callback.TSBackgroundTaskCallback;
import com.transistorsoft.locationmanager.adapter.callback.TSSyncCallback;
import com.transistorsoft.locationmanager.config.TSAuthorization;
import com.transistorsoft.locationmanager.config.TransistorAuthorizationToken;
import com.transistorsoft.locationmanager.data.LocationModel;
import com.transistorsoft.locationmanager.data.sqlite.SQLiteLocationDAO;
import com.transistorsoft.locationmanager.event.AuthorizationEvent;
import com.transistorsoft.locationmanager.event.ConfigChangeEvent;
import com.transistorsoft.locationmanager.event.ConnectivityChangeEvent;
import com.transistorsoft.locationmanager.event.HeadlessEvent;
import com.transistorsoft.locationmanager.event.HttpFlushEvent;
import com.transistorsoft.locationmanager.lifecycle.LifecycleManager;
import com.transistorsoft.locationmanager.logger.TSLog;
import com.transistorsoft.locationmanager.provider.TSProviderManager;
import com.transistorsoft.locationmanager.scheduler.TSScheduleManager;
import com.transistorsoft.locationmanager.util.BackgroundTaskManager;
import com.transistorsoft.locationmanager.util.HeadlessEventBroadcaster;
import com.transistorsoft.locationmanager.util.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.apache.commons.lang3.StringUtils;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class HttpService {
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private static HttpService k = null;
    private final Context a;
    private TSSyncCallback d;
    private final AtomicInteger f;
    private final OkHttpClient g;
    private BroadcastReceiver h;
    private ConnectivityManager.NetworkCallback i;
    private final List<TSAuthorizationCallback> j;
    private final List<LocationModel> b = new ArrayList();
    private final AtomicBoolean c = new AtomicBoolean(false);
    private final AtomicInteger e = new AtomicInteger(0);

    class a implements Runnable {
        final /* synthetic */ TSSyncCallback a;

        a(TSSyncCallback tSSyncCallback) {
            this.a = tSSyncCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.onFailure("HTTP_SERVICE_NO_CONNECTION");
        }
    }

    class b implements Runnable {
        final /* synthetic */ TSSyncCallback a;

        b(TSSyncCallback tSSyncCallback) {
            this.a = tSSyncCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.onFailure("HTTP_SERVICE_BUSY");
        }
    }

    class c implements Runnable {
        final /* synthetic */ AuthorizationEvent a;

        c(AuthorizationEvent authorizationEvent) {
            this.a = authorizationEvent;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (LifecycleManager.getInstance().isHeadless()) {
                HeadlessEventBroadcaster.post(new HeadlessEvent(HttpService.this.a, "authorization", this.a));
                return;
            }
            synchronized (HttpService.this.j) {
                Iterator it2 = HttpService.this.j.iterator();
                if (it2.hasNext()) {
                    while (it2.hasNext()) {
                        ((TSAuthorizationCallback) it2.next()).onResponse(this.a);
                    }
                }
            }
        }
    }

    class d extends BroadcastReceiver {
        d() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Bundle extras = intent.getExtras();
            HttpService.this.a((extras == null || extras.containsKey("noConnectivity")) ? false : true);
        }
    }

    class e implements Runnable {

        class a implements TSBackgroundTaskCallback {
            final /* synthetic */ HttpService a;

            a(HttpService httpService) {
                this.a = httpService;
            }

            @Override // com.transistorsoft.locationmanager.adapter.callback.TSBackgroundTaskCallback
            public void onCancel(int i) {
                HttpService.this.a();
            }

            @Override // com.transistorsoft.locationmanager.adapter.callback.TSBackgroundTaskCallback
            public void onStart(int i) {
                if (HttpService.this.e.compareAndSet(0, i)) {
                    BackgroundGeolocation.getThreadPool().execute(e.this);
                    return;
                }
                TSLog.warn(TSLog.warn("A BackgroundTask is already executing a FlushTask.  taskId: " + i + ", backgroundTaskId: " + HttpService.this.e.get()));
            }
        }

        e() {
            BackgroundTaskManager.getInstance().startBackgroundTask(HttpService.this.a, true, new a(HttpService.this));
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TSConfig.getInstance(HttpService.this.a).getBatchSync().booleanValue()) {
                HttpService.this.f();
            } else {
                HttpService.this.g();
            }
        }
    }

    class g extends ConnectivityManager.NetworkCallback {
        g() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            super.onAvailable(network);
            HttpService.this.a(true);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            super.onLost(network);
            HttpService.this.a(false);
        }
    }

    private HttpService(Context context) {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        this.f = atomicInteger;
        this.j = new ArrayList();
        Context applicationContext = context.getApplicationContext();
        this.a = applicationContext;
        final TSConfig tSConfig = TSConfig.getInstance(applicationContext);
        OkHttpClient.Builder builderFollowRedirects = new OkHttpClient.Builder().followRedirects(false);
        long jIntValue = tSConfig.getHttpTimeout().intValue();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        this.g = builderFollowRedirects.callTimeout(jIntValue, timeUnit).connectTimeout(tSConfig.getHttpTimeout().intValue(), timeUnit).build();
        EventBus eventBus = EventBus.getDefault();
        if (!eventBus.isRegistered(this)) {
            eventBus.register(this);
        }
        atomicInteger.set(tSConfig.getAutoSyncThreshold().intValue());
        if (tSConfig.getEnabled().booleanValue()) {
            startMonitoringConnectivityChanges(applicationContext);
        }
        LifecycleManager.getInstance().onStateChange(new LifecycleManager.OnStateChangeCallback() { // from class: com.transistorsoft.locationmanager.http.HttpService$$ExternalSyntheticLambda2
            @Override // com.transistorsoft.locationmanager.lifecycle.LifecycleManager.OnStateChangeCallback
            public final void onChange(boolean z) {
                this.f$0.a(tSConfig, z);
            }
        });
    }

    public static HttpService getInstance(Context context) {
        if (k == null) {
            k = a(context.getApplicationContext());
        }
        return k;
    }

    private void h() {
        if (this.e.get() > 0) {
            BackgroundTaskManager.getInstance().stopBackgroundTask(this.a, this.e.get());
            this.e.set(0);
        }
    }

    public void destroy() {
        EventBus eventBus = EventBus.getDefault();
        if (eventBus.isRegistered(this)) {
            eventBus.unregister(this);
        }
    }

    public void flush(@Nullable TSSyncCallback tSSyncCallback) {
        if (!isNetworkAvailable()) {
            if (tSSyncCallback != null) {
                BackgroundGeolocation.getUiHandler().post(new a(tSSyncCallback));
            }
        } else if (!this.c.get()) {
            this.d = tSSyncCallback;
            flush(true);
        } else {
            TSLog.logger.info(TSLog.info("HttpService is busy"));
            if (tSSyncCallback != null) {
                BackgroundGeolocation.getUiHandler().post(new b(tSSyncCallback));
            }
        }
    }

    public OkHttpClient getClient() {
        return this.g;
    }

    public boolean isBusy() {
        return this.c.get();
    }

    public boolean isConnectedMobile() {
        NetworkCapabilities networkCapabilities;
        ConnectivityManager connectivityManager = (ConnectivityManager) this.a.getSystemService("connectivity");
        return (connectivityManager == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork())) == null || !networkCapabilities.hasTransport(0)) ? false : true;
    }

    public boolean isConnectedWifi() {
        NetworkCapabilities networkCapabilities;
        ConnectivityManager connectivityManager = (ConnectivityManager) this.a.getSystemService("connectivity");
        return (connectivityManager == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork())) == null || !networkCapabilities.hasTransport(1)) ? false : true;
    }

    public boolean isNetworkAvailable() {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) this.a.getSystemService("connectivity");
        return (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected()) ? false : true;
    }

    public void onAuthorization(TSAuthorizationCallback tSAuthorizationCallback) {
        synchronized (this.j) {
            this.j.add(tSAuthorizationCallback);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onConfigChange(ConfigChangeEvent configChangeEvent) {
        TSConfig tSConfig = TSConfig.getInstance(this.a);
        if ((configChangeEvent.isDirty("autoSync") || configChangeEvent.isDirty("url") || configChangeEvent.isDirty("params") || configChangeEvent.isDirty("extras") || configChangeEvent.isDirty("headers")) && tSConfig.hasUrl() && tSConfig.getAutoSync().booleanValue() && isNetworkAvailable()) {
            BackgroundGeolocation.getThreadPool().execute(new Runnable() { // from class: com.transistorsoft.locationmanager.http.HttpService$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.e();
                }
            });
        }
        if (configChangeEvent.isDirty("autoSyncThreshold")) {
            this.f.set(tSConfig.getAutoSyncThreshold().intValue());
        }
    }

    public Object removeListener(String str, Object obj) {
        if (!"authorization".equalsIgnoreCase(str)) {
            return null;
        }
        synchronized (this.j) {
            if (!this.j.contains((TSAuthorizationCallback) obj)) {
                return null;
            }
            return Boolean.valueOf(this.j.remove(obj));
        }
    }

    public void removeListeners() {
        synchronized (this.j) {
            this.j.clear();
        }
    }

    public void startMonitoringConnectivityChanges(Context context) {
        if (!isNetworkAvailable()) {
            EventBus.getDefault().post(new ConnectivityChangeEvent(false));
        }
        TSLog.logger.debug(TSLog.on("Start monitoring connectivity changes"));
        if (this.i == null && this.h == null) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            connectivityManager.isDefaultNetworkActive();
            NetworkRequest networkRequestBuild = new NetworkRequest.Builder().build();
            g gVar = new g();
            this.i = gVar;
            connectivityManager.registerNetworkCallback(networkRequestBuild, gVar);
        }
    }

    public void stopMonitoringConnectivityChanges(Context context) {
        TSLog.logger.debug(TSLog.off("Stop monitoring connectivity changes"));
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        ConnectivityManager.NetworkCallback networkCallback = this.i;
        if (networkCallback != null) {
            try {
                connectivityManager.unregisterNetworkCallback(networkCallback);
            } catch (IllegalArgumentException e2) {
                TSLog.logger.warn(TSLog.warn(e2.getMessage()));
            }
            this.i = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d() {
        flush(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        TSConfig tSConfig = TSConfig.getInstance(this.a);
        List<LocationModel> listAllWithLocking = SQLiteLocationDAO.getInstance(this.a).allWithLocking(tSConfig.getMaxBatchSize());
        if (listAllWithLocking.size() > 0) {
            a(tSConfig.getUrl(), listAllWithLocking);
        } else {
            a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        LocationModel locationModelFirst = SQLiteLocationDAO.getInstance(this.a).first();
        if (locationModelFirst != null) {
            a(TSConfig.getInstance(this.a).getUrl(), locationModelFirst);
        } else {
            a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(HttpResponse httpResponse) {
        TSSyncCallback tSSyncCallback = this.d;
        if (tSSyncCallback != null) {
            try {
                tSSyncCallback.onFailure(httpResponse.responseText);
            } catch (Exception e2) {
                TSLog.logger.warn(TSLog.warn("Caught an Exception trying to reference callback.  It's probably already been called <IGNORE>."), (Throwable) e2);
            }
            this.d = null;
            this.c.set(false);
            return;
        }
        this.c.set(false);
    }

    private void c(HttpResponse httpResponse) {
        String str = httpResponse.responseText;
        if (str == null || str.isEmpty()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(httpResponse.responseText);
            if (jSONObject.has(com.transistorsoft.locationmanager.rpc.a.e)) {
                com.transistorsoft.locationmanager.rpc.a.a(this.a, jSONObject.getJSONArray(com.transistorsoft.locationmanager.rpc.a.e));
            }
        } catch (JSONException unused) {
        }
    }

    class f implements Callback {
        private LocationModel a;
        private List<LocationModel> b;
        private boolean c = false;

        /* JADX INFO: loaded from: classes3.dex */
        class a implements TSBackgroundTaskCallback {
            final /* synthetic */ TSAuthorization a;

            /* JADX INFO: renamed from: com.transistorsoft.locationmanager.http.HttpService$f$a$a, reason: collision with other inner class name */
            class C0125a implements TSAuthorization.Callback {
                final /* synthetic */ int a;

                C0125a(int i) {
                    this.a = i;
                }

                @Override // com.transistorsoft.locationmanager.config.TSAuthorization.Callback
                public void invoke(AuthorizationEvent authorizationEvent) {
                    HttpService.this.a(authorizationEvent);
                    if (authorizationEvent.isSuccessful()) {
                        HttpService.this.flush(true);
                    }
                    BackgroundTaskManager.getInstance().stopBackgroundTask(HttpService.this.a, this.a);
                }
            }

            a(TSAuthorization tSAuthorization) {
                this.a = tSAuthorization;
            }

            @Override // com.transistorsoft.locationmanager.adapter.callback.TSBackgroundTaskCallback
            public void onCancel(int i) {
            }

            @Override // com.transistorsoft.locationmanager.adapter.callback.TSBackgroundTaskCallback
            public void onStart(int i) {
                this.a.refreshAuthorizationToken(HttpService.this.a, new C0125a(i));
            }
        }

        public f(LocationModel locationModel) {
            this.a = locationModel;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            TSLog.logger.warn(TSLog.warn("Response: 0, " + iOException.getMessage()));
            TSConfig tSConfig = TSConfig.getInstance(HttpService.this.a);
            if (tSConfig.getIsMoving().booleanValue() && HttpService.this.isConnectedMobile() && tSConfig.getMaxRecordsToPersist().intValue() < 0) {
                int iCount = SQLiteLocationDAO.getInstance(HttpService.this.a).count();
                int iIntValue = tSConfig.getAutoSyncThreshold().intValue() > 0 ? tSConfig.getAutoSyncThreshold().intValue() : 10;
                HttpService.this.f.set(iCount + iIntValue);
                TSLog.logger.warn(TSLog.warn(call.request().url().host() + " is not responding.  Will try again after " + iIntValue + " records."));
            } else {
                HttpService.this.f.set(tSConfig.getAutoSyncThreshold().intValue());
            }
            HttpResponse httpResponse = new HttpResponse(HttpService.this.a, 0, iOException.getMessage());
            if (this.c) {
                HttpService.this.a(httpResponse, this.b);
            } else {
                HttpService.this.a(httpResponse, this.a);
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(@NonNull Call call, @NonNull Response response) {
            HttpResponse httpResponse;
            String strMessage;
            if (!HttpService.this.a(response)) {
                int iCode = response.code();
                try {
                    strMessage = response.body().string();
                } catch (IOException unused) {
                    strMessage = response.message();
                }
                if (response.isSuccessful()) {
                    HttpService.this.f.set(TSConfig.getInstance(HttpService.this.a).getAutoSyncThreshold().intValue());
                    TSLog.logger.info(TSLog.notice("Response: " + iCode));
                } else {
                    if (iCode == 401) {
                        TSAuthorization authorization = TSConfig.getInstance(HttpService.this.a).getAuthorization();
                        if (authorization.canRefreshAuthorizationToken()) {
                            BackgroundTaskManager.getInstance().startBackgroundTask(HttpService.this.a, new a(authorization));
                        }
                    } else if (iCode == 410) {
                        HttpUrl httpUrlUrl = response.request().url();
                        if (TransistorAuthorizationToken.hasTokenForHost(HttpService.this.a, httpUrlUrl.host())) {
                            TransistorAuthorizationToken.destroyTokenForUrl(HttpService.this.a, httpUrlUrl.toString(), null);
                        }
                    }
                    TSLog.logger.warn(TSLog.warn("Response: " + iCode + ", " + response.message()));
                }
                httpResponse = new HttpResponse(HttpService.this.a, iCode, strMessage);
            } else {
                if (HttpService.this.b(response)) {
                    String strC = HttpService.this.c(response);
                    TSLog.logger.info(TSLog.info("HTTP Redirect: " + response.code() + StringUtils.SPACE + strC));
                    if (this.c) {
                        HttpService.this.a(strC, this.b);
                        return;
                    } else {
                        HttpService.this.a(strC, this.a);
                        return;
                    }
                }
                TSLog.logger.error(TSLog.warn("Response: " + response.code() + " (HTTP 301/302 redirects are not permitted since they strip POST data)"));
                httpResponse = new HttpResponse(HttpService.this.a, response.code(), response.code() + " redirect is not permitted");
            }
            if (this.c) {
                HttpService.this.a(httpResponse, this.b);
            } else {
                HttpService.this.a(httpResponse, this.a);
            }
        }

        public f(List<LocationModel> list) {
            this.b = list;
        }
    }

    private static HttpService a(Context context) {
        HttpService httpService;
        synchronized (HttpService.class) {
            if (k == null) {
                k = new HttpService(context.getApplicationContext());
            }
            httpService = k;
        }
        return httpService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c(Response response) {
        HttpUrl httpUrlUrl = response.request().url();
        String str = httpUrlUrl.scheme() + "://" + httpUrlUrl.host();
        if (httpUrlUrl.port() != 80) {
            str = str + ":" + httpUrlUrl.port();
        }
        return str + response.header(HttpHeaders.LOCATION);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(TSConfig tSConfig, boolean z) {
        if (z && tSConfig.getEnabled().booleanValue() && tSConfig.getAutoSync().booleanValue() && tSConfig.hasUrl() && !tSConfig.getIsMoving().booleanValue()) {
            BackgroundGeolocation.getThreadPool().execute(new Runnable() { // from class: com.transistorsoft.locationmanager.http.HttpService$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.d();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, LocationModel locationModel) {
        Object objMergeJson;
        TSConfig tSConfig = TSConfig.getInstance(this.a);
        TSLog.logger.info(TSLog.notice("HTTP " + tSConfig.getMethod().toUpperCase() + ": " + locationModel.getUUID()));
        try {
            Object json = locationModel.getJson();
            String httpRootProperty = tSConfig.getHttpRootProperty();
            JSONObject params = tSConfig.getParams();
            if (httpRootProperty.equalsIgnoreCase(".")) {
                if (json instanceof JSONObject) {
                    if (params != null) {
                        objMergeJson = Util.mergeJson((JSONObject) json, params);
                    }
                } else if (params != null) {
                    TSLog.logger.warn("Appending #params to an HTTP Request of type {Array} is not yet supported.  Specify an #httpRootProperty and send an {Object} request");
                    objMergeJson = json;
                }
            } else {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(httpRootProperty, json);
                objMergeJson = params != null ? Util.mergeJson(jSONObject, params) : jSONObject;
            }
            this.g.newCall(a(str, objMergeJson.toString())).enqueue(new f(locationModel));
        } catch (IllegalArgumentException | JSONException e2) {
            TSLog.logger.error(TSLog.error(e2.getMessage()));
            a(new HttpResponse(this.a, 0, e2.getMessage()), locationModel);
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(Response response) {
        int iCode = response.code();
        return iCode == 307 || iCode == 308;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c() {
        BackgroundGeolocation.getThreadPool().execute(new Runnable() { // from class: com.transistorsoft.locationmanager.http.HttpService$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.b();
            }
        });
    }

    public void flush(boolean z) {
        if (z) {
            this.f.set(0);
        }
        e();
    }

    /* JADX INFO: renamed from: flush, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public void e() {
        if (isNetworkAvailable()) {
            TSConfig tSConfig = TSConfig.getInstance(this.a);
            if (this.d == null && tSConfig.getDisableAutoSyncOnCellular()) {
                boolean zIsConnectedWifi = isConnectedWifi();
                TSLog.logger.info(TSLog.info("WiFi connected? " + zIsConnectedWifi));
                if (!zIsConnectedWifi) {
                    return;
                }
            }
            if (this.c.compareAndSet(false, true)) {
                int iCount = SQLiteLocationDAO.getInstance(this.a).count();
                TSLog.logger.info(TSLog.header("HTTP Service (count: " + iCount + ")"));
                if (iCount >= 1 && iCount >= this.f.get()) {
                    new e();
                    return;
                } else {
                    a();
                    return;
                }
            }
            TSLog.logger.info(TSLog.info("HttpService is busy"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, List<LocationModel> list) {
        TSConfig tSConfig = TSConfig.getInstance(this.a);
        TSLog.logger.info(TSLog.notice("HTTP " + tSConfig.getMethod().toUpperCase() + " batch (" + list.size() + ")"));
        JSONArray jSONArray = new JSONArray();
        Iterator<LocationModel> it2 = list.iterator();
        while (it2.hasNext()) {
            jSONArray.put(it2.next().getJson());
        }
        try {
            JSONObject params = tSConfig.getParams();
            String httpRootProperty = tSConfig.getHttpRootProperty();
            Object objMergeJson = jSONArray;
            if (!httpRootProperty.equalsIgnoreCase(".")) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(httpRootProperty, jSONArray);
                objMergeJson = params != null ? Util.mergeJson(jSONObject, params) : jSONObject;
            } else if (params != null) {
                TSLog.logger.warn("Appending #params to an HTTP Request of type {Array} is not yet supported.  Specify an #httpRootProperty and send an {Object} request");
                objMergeJson = jSONArray;
            }
            this.g.newCall(a(str, objMergeJson.toString())).enqueue(new f(list));
        } catch (IllegalArgumentException | JSONException e2) {
            TSLog.logger.error(TSLog.error(e2.getMessage()));
            a(new HttpResponse(this.a, 0, e2.getMessage()), list);
            e2.printStackTrace();
        }
    }

    private Request a(String str, String str2) throws JSONException, IllegalArgumentException {
        TSConfig tSConfig = TSConfig.getInstance(this.a);
        Request.Builder builderUrl = new Request.Builder().url(str);
        MediaType mediaType = JSON;
        JSONObject headers = tSConfig.getHeaders();
        if (headers != null) {
            Iterator<String> itKeys = headers.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if (next.equalsIgnoreCase("content-type")) {
                    mediaType = MediaType.parse(headers.getString(next));
                }
                builderUrl.header(next, headers.getString(next));
            }
        }
        tSConfig.getAuthorization().apply(builderUrl);
        builderUrl.method(tSConfig.getMethod(), RequestBody.create(mediaType, str2));
        return builderUrl.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(HttpResponse httpResponse, List<LocationModel> list) {
        EventBus.getDefault().post(httpResponse);
        SQLiteLocationDAO sQLiteLocationDAO = SQLiteLocationDAO.getInstance(this.a);
        if (httpResponse.isSuccess().booleanValue()) {
            synchronized (this.b) {
                this.b.addAll(list);
            }
            sQLiteLocationDAO.destroyAll(list);
            f();
        } else {
            sQLiteLocationDAO.unlock(list);
            a(httpResponse);
        }
        c(httpResponse);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(HttpResponse httpResponse, LocationModel locationModel) {
        EventBus.getDefault().post(httpResponse);
        SQLiteLocationDAO sQLiteLocationDAO = SQLiteLocationDAO.getInstance(this.a);
        if (httpResponse.isSuccess().booleanValue()) {
            synchronized (this.b) {
                this.b.add(locationModel);
            }
            sQLiteLocationDAO.destroy(locationModel);
            g();
        } else {
            sQLiteLocationDAO.unlock(locationModel);
            a(httpResponse);
        }
        c(httpResponse);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        final ArrayList arrayList;
        synchronized (this.b) {
            arrayList = new ArrayList(this.b);
            this.b.clear();
        }
        h();
        if (this.d != null) {
            BackgroundGeolocation.getUiHandler().post(new Runnable() { // from class: com.transistorsoft.locationmanager.http.HttpService$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a(arrayList);
                }
            });
        } else {
            this.c.set(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(List list) {
        try {
            this.d.onSuccess(list);
        } catch (Exception unused) {
        }
        this.d = null;
        this.c.set(false);
    }

    private void a(final HttpResponse httpResponse) {
        h();
        if (httpResponse.getStatus() == 0) {
            TSConfig tSConfig = TSConfig.getInstance(this.a);
            if (tSConfig.getEnabled().booleanValue() && tSConfig.getAutoSync().booleanValue()) {
                TSScheduleManager.getInstance(this.a).oneShot(HttpFlushEvent.ACTION, TimeUnit.MINUTES.toMillis(15L));
            }
        }
        BackgroundGeolocation.getUiHandler().post(new Runnable() { // from class: com.transistorsoft.locationmanager.http.HttpService$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.b(httpResponse);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Response response) {
        int iCode = response.code();
        return iCode == 301 || iCode == 302 || iCode == 307 || iCode == 308;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AuthorizationEvent authorizationEvent) {
        BackgroundGeolocation.getUiHandler().post(new c(authorizationEvent));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        TSProviderManager.getInstance(this.a).onConnectivityChange(this.a, z);
        boolean zIsNetworkAvailable = isNetworkAvailable();
        if (z != zIsNetworkAvailable) {
            return;
        }
        TSLog.logger.debug(TSLog.header("📶  Connectivity change: connected? " + zIsNetworkAvailable));
        TSConfig tSConfig = TSConfig.getInstance(this.a);
        this.f.set(tSConfig.getAutoSyncThreshold().intValue());
        if (zIsNetworkAvailable && tSConfig.getAutoSync().booleanValue() && tSConfig.hasUrl()) {
            BackgroundGeolocation.getUiHandler().postDelayed(new Runnable() { // from class: com.transistorsoft.locationmanager.http.HttpService$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.c();
                }
            }, 1000L);
        }
        EventBus.getDefault().post(new ConnectivityChangeEvent(zIsNetworkAvailable));
    }
}
