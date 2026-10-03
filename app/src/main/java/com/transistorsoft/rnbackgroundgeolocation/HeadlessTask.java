package com.transistorsoft.rnbackgroundgeolocation;

import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableNativeMap;
import com.transistorsoft.locationmanager.adapter.BackgroundGeolocation;
import com.transistorsoft.locationmanager.event.FinishHeadlessTaskEvent;
import com.transistorsoft.locationmanager.event.HeadlessEvent;
import com.transistorsoft.locationmanager.logger.TSLog;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class HeadlessTask {
    private static final String HEADLESS_TASK_NAME = "BackgroundGeolocation";
    private static final int TASK_TIMEOUT = 120000;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onHeadlessEvent$0(ReactContext reactContext, HeadlessTaskManager.Task task) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onHeadlessEvent$1(int i) {
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onHeadlessEvent(HeadlessEvent headlessEvent) {
        JSONObject json;
        String name = headlessEvent.getName();
        TSLog.logger.debug("💀  event: " + name);
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putString("name", name);
        if (name.equals(BackgroundGeolocation.EVENT_TERMINATE)) {
            json = headlessEvent.getTerminateEvent();
        } else if (name.equals("location")) {
            try {
                json = headlessEvent.getLocationEvent().toJson();
            } catch (JSONException e) {
                TSLog.logger.error(e.getMessage(), (Throwable) e);
                json = null;
            }
        } else if (name.equals(BackgroundGeolocation.EVENT_MOTIONCHANGE)) {
            json = headlessEvent.getMotionChangeEvent().toJson();
        } else if (name.equals("http")) {
            json = headlessEvent.getHttpEvent().toJson();
        } else if (name.equals(BackgroundGeolocation.EVENT_PROVIDERCHANGE)) {
            json = headlessEvent.getProviderChangeEvent().toJson();
        } else if (name.equals(BackgroundGeolocation.EVENT_ACTIVITYCHANGE)) {
            json = headlessEvent.getActivityChangeEvent().toJson();
        } else if (name.equals("schedule")) {
            json = headlessEvent.getScheduleEvent();
        } else if (name.equals(BackgroundGeolocation.EVENT_BOOT)) {
            json = headlessEvent.getBootEvent();
        } else if (name.equals("geofence")) {
            json = headlessEvent.getGeofenceEvent().toJson();
        } else if (name.equals("geofenceschange")) {
            json = headlessEvent.getGeofencesChangeEvent().toJson();
        } else if (name.equals("heartbeat")) {
            json = headlessEvent.getHeartbeatEvent().toJson();
        } else {
            if (name.equals(BackgroundGeolocation.EVENT_POWERSAVECHANGE)) {
                writableNativeMap.putBoolean("params", headlessEvent.getPowerSaveChangeEvent().isPowerSaveMode().booleanValue());
            } else if (name.equals(BackgroundGeolocation.EVENT_CONNECTIVITYCHANGE)) {
                json = headlessEvent.getConnectivityChangeEvent().toJson();
            } else if (name.equals(BackgroundGeolocation.EVENT_ENABLEDCHANGE)) {
                writableNativeMap.putBoolean("params", headlessEvent.getEnabledChangeEvent().booleanValue());
            } else if (name.equals("notificationaction")) {
                writableNativeMap.putString("params", headlessEvent.getNotificationEvent());
            } else if (name.equals("authorization")) {
                json = headlessEvent.getAuthorizationEvent().toJson();
            } else {
                TSLog.logger.warn(TSLog.warn("Unknown Headless Event: " + name));
                writableNativeMap.putString("error", "Unknown event: " + name);
                writableNativeMap.putNull("params");
            }
            json = null;
        }
        if (json != null) {
            try {
                writableNativeMap.putMap("params", RNBackgroundGeolocationModule.jsonToMap(json));
            } catch (JSONException e2) {
                writableNativeMap.putNull("params");
                writableNativeMap.putString("error", e2.getMessage());
                TSLog.logger.error(TSLog.error(e2.getMessage()), (Throwable) e2);
            }
        }
        try {
            HeadlessTaskManager.getInstance().startTask(headlessEvent.getContext(), new HeadlessTaskManager.Task.Builder().setName(HEADLESS_TASK_NAME).setParams(writableNativeMap).setTimeout(TASK_TIMEOUT).setOnInvokeCallback(new HeadlessTaskManager.OnInvokeCallback() { // from class: com.transistorsoft.rnbackgroundgeolocation.HeadlessTask$$ExternalSyntheticLambda0
                @Override // com.transistorsoft.rnbackgroundgeolocation.HeadlessTaskManager.OnInvokeCallback
                public final void onInvoke(ReactContext reactContext, HeadlessTaskManager.Task task) {
                    HeadlessTask.lambda$onHeadlessEvent$0(reactContext, task);
                }
            }).setOnFinishCallback(new HeadlessTaskManager.OnFinishCallback() { // from class: com.transistorsoft.rnbackgroundgeolocation.HeadlessTask$$ExternalSyntheticLambda1
                @Override // com.transistorsoft.rnbackgroundgeolocation.HeadlessTaskManager.OnFinishCallback
                public final void onFinish(int i) {
                    HeadlessTask.lambda$onHeadlessEvent$1(i);
                }
            }).setOnErrorCallback(new HeadlessTaskManager.OnErrorCallback() { // from class: com.transistorsoft.rnbackgroundgeolocation.HeadlessTask$$ExternalSyntheticLambda2
                @Override // com.transistorsoft.rnbackgroundgeolocation.HeadlessTaskManager.OnErrorCallback
                public final void onError(HeadlessTaskManager.Task task, Exception exc) {
                    HeadlessTask.lambda$onHeadlessEvent$2(task, exc);
                }
            }).build());
        } catch (Exception e3) {
            TSLog.logger.warn(TSLog.warn("Failed invoke HeadlessTask " + name + ".  Task ignored:  " + e3.getMessage()));
            e3.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onHeadlessEvent$2(HeadlessTaskManager.Task task, Exception exc) {
        TSLog.logger.warn("⚠️  HeadlessTaskError: " + exc.getMessage() + ": " + task.toString());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onFinishHeadlessTask(FinishHeadlessTaskEvent finishHeadlessTaskEvent) {
        try {
            HeadlessTaskManager.getInstance().finishTask(finishHeadlessTaskEvent.getContext(), finishHeadlessTaskEvent.getTaskId());
        } catch (Exception e) {
            TSLog.logger.warn(TSLog.warn(e.getMessage()));
        }
    }
}
