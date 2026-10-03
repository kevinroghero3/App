package com.transistorsoft.tsbackgroundfetch;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.AudioTrack;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import com.google.common.base.Ascii;
import io.sentry.android.core.SentryLogcatAdapter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import o.ArtificialStackFrames;
import o.extraCallback;
import okio.Utf8;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class BackgroundFetchConfig {
    private static final int DEFAULT_FETCH_INTERVAL = 15;
    static int FETCH_JOB_ID = 999;
    public static final String FIELD_DELAY = "delay";
    public static final String FIELD_FORCE_ALARM_MANAGER = "forceAlarmManager";
    public static final String FIELD_IS_FETCH_TASK = "isFetchTask";
    public static final String FIELD_JOB_SERVICE = "jobService";
    public static final String FIELD_MINIMUM_FETCH_INTERVAL = "minimumFetchInterval";
    public static final String FIELD_PERIODIC = "periodic";
    public static final String FIELD_REQUIRED_NETWORK_TYPE = "requiredNetworkType";
    public static final String FIELD_REQUIRES_BATTERY_NOT_LOW = "requiresBatteryNotLow";
    public static final String FIELD_REQUIRES_CHARGING = "requiresCharging";
    public static final String FIELD_REQUIRES_DEVICE_IDLE = "requiresDeviceIdle";
    public static final String FIELD_REQUIRES_STORAGE_NOT_LOW = "requiresStorageNotLow";
    public static final String FIELD_START_ON_BOOT = "startOnBoot";
    public static final String FIELD_STOP_ON_TERMINATE = "stopOnTerminate";
    public static final String FIELD_TASK_ID = "taskId";
    private static final int MINIMUM_FETCH_INTERVAL = 1;
    private Builder config;

    interface OnLoadCallback {
        void onLoad(List<BackgroundFetchConfig> list);
    }

    public static class Builder {
        private String taskId;
        private int minimumFetchInterval = 15;
        private long delay = -1;
        private boolean periodic = false;
        private boolean forceAlarmManager = false;
        private boolean stopOnTerminate = true;
        private boolean startOnBoot = false;
        private int requiredNetworkType = 0;
        private boolean requiresBatteryNotLow = false;
        private boolean requiresCharging = false;
        private boolean requiresDeviceIdle = false;
        private boolean requiresStorageNotLow = false;
        private boolean isFetchTask = false;
        private String jobService = null;

        public Builder setTaskId(String str) {
            this.taskId = str;
            return this;
        }

        public Builder setIsFetchTask(boolean z) {
            this.isFetchTask = z;
            return this;
        }

        public Builder setMinimumFetchInterval(int i) {
            if (i >= 1) {
                this.minimumFetchInterval = i;
            }
            return this;
        }

        public Builder setStopOnTerminate(boolean z) {
            this.stopOnTerminate = z;
            return this;
        }

        public Builder setStartOnBoot(boolean z) {
            this.startOnBoot = z;
            return this;
        }

        public Builder setRequiredNetworkType(int i) {
            if (i != 1 && i != 4 && i != 0 && i != 3 && i != 2) {
                SentryLogcatAdapter.e(BackgroundFetch.TAG, "[ERROR] Invalid requiredNetworkType: " + i + "; Defaulting to NETWORK_TYPE_NONE");
                i = 0;
            }
            this.requiredNetworkType = i;
            return this;
        }

        public Builder setRequiresBatteryNotLow(boolean z) {
            this.requiresBatteryNotLow = z;
            return this;
        }

        public Builder setRequiresCharging(boolean z) {
            this.requiresCharging = z;
            return this;
        }

        public Builder setRequiresDeviceIdle(boolean z) {
            this.requiresDeviceIdle = z;
            return this;
        }

        public Builder setRequiresStorageNotLow(boolean z) {
            this.requiresStorageNotLow = z;
            return this;
        }

        public Builder setJobService(String str) {
            this.jobService = str;
            return this;
        }

        public Builder setForceAlarmManager(boolean z) {
            this.forceAlarmManager = z;
            return this;
        }

        public Builder setPeriodic(boolean z) {
            this.periodic = z;
            return this;
        }

        public Builder setDelay(long j) {
            this.delay = j;
            return this;
        }

        public BackgroundFetchConfig build() {
            return new BackgroundFetchConfig(this);
        }

        public BackgroundFetchConfig load(Context context, String str) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("TSBackgroundFetch:" + str, 0);
            if (sharedPreferences.contains(BackgroundFetchConfig.FIELD_TASK_ID)) {
                setTaskId(sharedPreferences.getString(BackgroundFetchConfig.FIELD_TASK_ID, str));
            }
            if (sharedPreferences.contains(BackgroundFetchConfig.FIELD_IS_FETCH_TASK)) {
                setIsFetchTask(sharedPreferences.getBoolean(BackgroundFetchConfig.FIELD_IS_FETCH_TASK, this.isFetchTask));
            }
            if (sharedPreferences.contains(BackgroundFetchConfig.FIELD_MINIMUM_FETCH_INTERVAL)) {
                setMinimumFetchInterval(sharedPreferences.getInt(BackgroundFetchConfig.FIELD_MINIMUM_FETCH_INTERVAL, this.minimumFetchInterval));
            }
            if (sharedPreferences.contains(BackgroundFetchConfig.FIELD_STOP_ON_TERMINATE)) {
                setStopOnTerminate(sharedPreferences.getBoolean(BackgroundFetchConfig.FIELD_STOP_ON_TERMINATE, this.stopOnTerminate));
            }
            if (sharedPreferences.contains(BackgroundFetchConfig.FIELD_REQUIRED_NETWORK_TYPE)) {
                setRequiredNetworkType(sharedPreferences.getInt(BackgroundFetchConfig.FIELD_REQUIRED_NETWORK_TYPE, this.requiredNetworkType));
            }
            if (sharedPreferences.contains(BackgroundFetchConfig.FIELD_REQUIRES_BATTERY_NOT_LOW)) {
                setRequiresBatteryNotLow(sharedPreferences.getBoolean(BackgroundFetchConfig.FIELD_REQUIRES_BATTERY_NOT_LOW, this.requiresBatteryNotLow));
            }
            if (sharedPreferences.contains(BackgroundFetchConfig.FIELD_REQUIRES_CHARGING)) {
                setRequiresCharging(sharedPreferences.getBoolean(BackgroundFetchConfig.FIELD_REQUIRES_CHARGING, this.requiresCharging));
            }
            if (sharedPreferences.contains(BackgroundFetchConfig.FIELD_REQUIRES_DEVICE_IDLE)) {
                setRequiresDeviceIdle(sharedPreferences.getBoolean(BackgroundFetchConfig.FIELD_REQUIRES_DEVICE_IDLE, this.requiresDeviceIdle));
            }
            if (sharedPreferences.contains(BackgroundFetchConfig.FIELD_REQUIRES_STORAGE_NOT_LOW)) {
                setRequiresStorageNotLow(sharedPreferences.getBoolean(BackgroundFetchConfig.FIELD_REQUIRES_STORAGE_NOT_LOW, this.requiresStorageNotLow));
            }
            if (sharedPreferences.contains("startOnBoot")) {
                setStartOnBoot(sharedPreferences.getBoolean("startOnBoot", this.startOnBoot));
            }
            if (sharedPreferences.contains(BackgroundFetchConfig.FIELD_JOB_SERVICE)) {
                setJobService(sharedPreferences.getString(BackgroundFetchConfig.FIELD_JOB_SERVICE, null));
            }
            if (sharedPreferences.contains(BackgroundFetchConfig.FIELD_FORCE_ALARM_MANAGER)) {
                setForceAlarmManager(sharedPreferences.getBoolean(BackgroundFetchConfig.FIELD_FORCE_ALARM_MANAGER, this.forceAlarmManager));
            }
            if (sharedPreferences.contains(BackgroundFetchConfig.FIELD_PERIODIC)) {
                setPeriodic(sharedPreferences.getBoolean(BackgroundFetchConfig.FIELD_PERIODIC, this.periodic));
            }
            if (sharedPreferences.contains(BackgroundFetchConfig.FIELD_DELAY)) {
                setDelay(sharedPreferences.getLong(BackgroundFetchConfig.FIELD_DELAY, this.delay));
            }
            return new BackgroundFetchConfig(this);
        }
    }

    private BackgroundFetchConfig(Builder builder) {
        this.config = builder;
        if (builder.jobService == null) {
            if (!this.config.stopOnTerminate) {
                SentryLogcatAdapter.w(BackgroundFetch.TAG, "- Configuration error:  In order to use stopOnTerminate: false, you must set enableHeadless: true");
                this.config.setStopOnTerminate(true);
            }
            if (this.config.startOnBoot) {
                SentryLogcatAdapter.w(BackgroundFetch.TAG, "- Configuration error:  In order to use startOnBoot: true, you must enableHeadless: true");
                this.config.setStartOnBoot(false);
            }
        }
    }

    void save(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(BackgroundFetch.TAG, 0);
        Set<String> stringSet = sharedPreferences.getStringSet("tasks", new HashSet());
        if (stringSet == null) {
            stringSet = new HashSet<>();
        }
        if (!stringSet.contains(this.config.taskId)) {
            HashSet hashSet = new HashSet(stringSet);
            hashSet.add(this.config.taskId);
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putStringSet("tasks", hashSet);
            editorEdit.apply();
        }
        SharedPreferences.Editor editorEdit2 = context.getSharedPreferences("TSBackgroundFetch:" + this.config.taskId, 0).edit();
        editorEdit2.putString(FIELD_TASK_ID, this.config.taskId);
        editorEdit2.putBoolean(FIELD_IS_FETCH_TASK, this.config.isFetchTask);
        editorEdit2.putInt(FIELD_MINIMUM_FETCH_INTERVAL, this.config.minimumFetchInterval);
        editorEdit2.putBoolean(FIELD_STOP_ON_TERMINATE, this.config.stopOnTerminate);
        editorEdit2.putBoolean("startOnBoot", this.config.startOnBoot);
        editorEdit2.putInt(FIELD_REQUIRED_NETWORK_TYPE, this.config.requiredNetworkType);
        editorEdit2.putBoolean(FIELD_REQUIRES_BATTERY_NOT_LOW, this.config.requiresBatteryNotLow);
        editorEdit2.putBoolean(FIELD_REQUIRES_CHARGING, this.config.requiresCharging);
        editorEdit2.putBoolean(FIELD_REQUIRES_DEVICE_IDLE, this.config.requiresDeviceIdle);
        editorEdit2.putBoolean(FIELD_REQUIRES_STORAGE_NOT_LOW, this.config.requiresStorageNotLow);
        editorEdit2.putString(FIELD_JOB_SERVICE, this.config.jobService);
        editorEdit2.putBoolean(FIELD_FORCE_ALARM_MANAGER, this.config.forceAlarmManager);
        editorEdit2.putBoolean(FIELD_PERIODIC, this.config.periodic);
        editorEdit2.putLong(FIELD_DELAY, this.config.delay);
        editorEdit2.apply();
    }

    void destroy(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(BackgroundFetch.TAG, 0);
        Set<String> stringSet = sharedPreferences.getStringSet("tasks", new HashSet());
        if (stringSet == null) {
            stringSet = new HashSet<>();
        }
        if (stringSet.contains(this.config.taskId)) {
            HashSet hashSet = new HashSet(stringSet);
            hashSet.remove(this.config.taskId);
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putStringSet("tasks", hashSet);
            editorEdit.apply();
        }
        if (this.config.isFetchTask) {
            return;
        }
        SharedPreferences.Editor editorEdit2 = context.getSharedPreferences("TSBackgroundFetch:" + this.config.taskId, 0).edit();
        editorEdit2.clear();
        editorEdit2.apply();
    }

    boolean isFetchTask() {
        return this.config.isFetchTask;
    }

    public String getTaskId() {
        return this.config.taskId;
    }

    public int getMinimumFetchInterval() {
        return this.config.minimumFetchInterval;
    }

    public int getRequiredNetworkType() {
        return this.config.requiredNetworkType;
    }

    public boolean getRequiresBatteryNotLow() {
        return this.config.requiresBatteryNotLow;
    }

    public boolean getRequiresCharging() {
        return this.config.requiresCharging;
    }

    public boolean getRequiresDeviceIdle() {
        return this.config.requiresDeviceIdle;
    }

    public boolean getRequiresStorageNotLow() {
        return this.config.requiresStorageNotLow;
    }

    public boolean getStopOnTerminate() {
        return this.config.stopOnTerminate;
    }

    public boolean getStartOnBoot() {
        return this.config.startOnBoot;
    }

    public String getJobService() {
        return this.config.jobService;
    }

    public boolean getForceAlarmManager() {
        return this.config.forceAlarmManager;
    }

    public boolean getPeriodic() {
        return this.config.periodic || isFetchTask();
    }

    public long getDelay() {
        return this.config.delay;
    }

    int getJobId() {
        if (this.config.forceAlarmManager) {
            return 0;
        }
        return isFetchTask() ? FETCH_JOB_ID : this.config.taskId.hashCode();
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(FIELD_TASK_ID, this.config.taskId);
            jSONObject.put(FIELD_IS_FETCH_TASK, this.config.isFetchTask);
            jSONObject.put(FIELD_MINIMUM_FETCH_INTERVAL, this.config.minimumFetchInterval);
            jSONObject.put(FIELD_STOP_ON_TERMINATE, this.config.stopOnTerminate);
            jSONObject.put(FIELD_REQUIRED_NETWORK_TYPE, this.config.requiredNetworkType);
            jSONObject.put(FIELD_REQUIRES_BATTERY_NOT_LOW, this.config.requiresBatteryNotLow);
            jSONObject.put(FIELD_REQUIRES_CHARGING, this.config.requiresCharging);
            jSONObject.put(FIELD_REQUIRES_DEVICE_IDLE, this.config.requiresDeviceIdle);
            jSONObject.put(FIELD_REQUIRES_STORAGE_NOT_LOW, this.config.requiresStorageNotLow);
            jSONObject.put("startOnBoot", this.config.startOnBoot);
            jSONObject.put(FIELD_JOB_SERVICE, this.config.jobService);
            jSONObject.put(FIELD_FORCE_ALARM_MANAGER, this.config.forceAlarmManager);
            jSONObject.put(FIELD_PERIODIC, getPeriodic());
            jSONObject.put(FIELD_DELAY, this.config.delay);
            return jSONObject.toString(2);
        } catch (JSONException e) {
            e.printStackTrace();
            return jSONObject.toString();
        }
    }

    static void load(final Context context, final OnLoadCallback onLoadCallback) {
        BackgroundFetch.getThreadPool().execute(new Runnable() { // from class: com.transistorsoft.tsbackgroundfetch.BackgroundFetchConfig.1
            private static final byte[] $$c = {Utf8.REPLACEMENT_BYTE, -116, -22, -37};
            private static final int $$d = 83;
            private static int $10 = 0;
            private static int $11 = 1;
            private static final byte[] $$a = {91, 80, 41, -1, 9, -20, Ascii.FS, -26, -18, 10, -5, -11, 2, 19, -39, 6, -6, Ascii.ESC, -46, 8, -6, -15, 2, -4, Ascii.CR, -24, -13, -7, -12, Ascii.FF, -4, -31, -17, -4, 38, -49, -3, -8, 10, -24, Ascii.US, -22, -22, 10, -7, -12, -2, -22, Ascii.DLE, -18, 9, -20, 44, -35, -20, -9, 6, -11, -4, 0, -10, 2, Ascii.GS, -46, 8, -6, -15, 2, -4, -50, -14, 50};
            private static final int $$b = 20;
            private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
            private static int artificialFrame = 1;
            private static char[] ArtificialStackFrames = {44387, 44696, 44698, 44388, 44384, 44393, 44402, 44355, 44701, 44699, 44390, 44403, 44397, 44404, 44702, 44408, 44398, 44399, 44361, 44389, 44333, 44396, 44385, 44353, 44690, 44334, 44400, 44405, 44335, 44700, 44395, 44703, 44386, 44391, 44337, 44697};
            private static char coroutineCreation = 39068;

            /* JADX WARN: Code duplicated, block: B:10:0x0021  */
            /* JADX WARN: Code duplicated, block: B:8:0x001b  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0021 -> B:11:0x0028). Please report as a decompilation issue!!! */
            /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0021
                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                */
            private static java.lang.String $$e(int r6, byte r7, byte r8) {
                /*
                    int r8 = 105 - r8
                    int r6 = r6 * 2
                    int r0 = r6 + 1
                    byte[] r1 = com.transistorsoft.tsbackgroundfetch.BackgroundFetchConfig.AnonymousClass1.$$c
                    int r7 = r7 * 2
                    int r7 = 4 - r7
                    byte[] r0 = new byte[r0]
                    r2 = 0
                    if (r1 != 0) goto L15
                    r4 = r6
                    r8 = r7
                    r3 = r2
                    goto L28
                L15:
                    r3 = r2
                L16:
                    byte r4 = (byte) r8
                    r0[r3] = r4
                    if (r3 != r6) goto L21
                    java.lang.String r6 = new java.lang.String
                    r6.<init>(r0, r2)
                    return r6
                L21:
                    int r3 = r3 + 1
                    r4 = r1[r7]
                    r5 = r8
                    r8 = r7
                    r7 = r5
                L28:
                    int r4 = -r4
                    int r7 = r7 + r4
                    int r8 = r8 + 1
                    r5 = r8
                    r8 = r7
                    r7 = r5
                    goto L16
                */
                throw new UnsupportedOperationException("Method not decompiled: com.transistorsoft.tsbackgroundfetch.BackgroundFetchConfig.AnonymousClass1.$$e(int, byte, byte):java.lang.String");
            }

            private static void a(short s, byte b, int i, Object[] objArr) {
                byte[] bArr = $$a;
                int i2 = s + 66;
                int i3 = b + 4;
                byte[] bArr2 = new byte[28 - i];
                int i4 = 27 - i;
                int i5 = -1;
                if (bArr == null) {
                    i2 = (i3 + (-i2)) - 5;
                    i3 = i3;
                    i5 = -1;
                }
                while (true) {
                    int i6 = i3 + 1;
                    int i7 = i5 + 1;
                    bArr2[i7] = (byte) i2;
                    if (i7 == i4) {
                        objArr[0] = new String(bArr2, 0);
                        return;
                    }
                    i2 = (i2 + (-bArr[i6])) - 5;
                    i3 = i6;
                    i5 = i7;
                }
            }

            private static void b(int i, char[] cArr, byte b, Object[] objArr) throws Throwable {
                int i2;
                Object obj;
                int i3 = 2 % 2;
                extraCallback extracallback = new extraCallback();
                char[] cArr2 = ArtificialStackFrames;
                float f = 0.0f;
                int i4 = -1819279892;
                Object obj2 = null;
                if (cArr2 != null) {
                    int length = cArr2.length;
                    char[] cArr3 = new char[length];
                    int i5 = $10 + 101;
                    $11 = i5 % 128;
                    int i6 = i5 % 2;
                    int i7 = 0;
                    while (i7 < length) {
                        try {
                            Object[] objArr2 = {Integer.valueOf(cArr2[i7])};
                            Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(i4);
                            if (objAccessartificialFrame == null) {
                                byte b2 = (byte) 0;
                                byte b3 = b2;
                                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getPressedStateDuration() >> 16) + 15, (char) (20488 - (AudioTrack.getMinVolume() > f ? 1 : (AudioTrack.getMinVolume() == f ? 0 : -1))), 2148 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), 216710116, false, $$e(b2, b3, (byte) (b3 | 8)), new Class[]{Integer.TYPE});
                            }
                            cArr3[i7] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                            i7++;
                            f = 0.0f;
                            i4 = -1819279892;
                        } catch (Throwable th) {
                            Throwable cause = th.getCause();
                            if (cause == null) {
                                throw th;
                            }
                            throw cause;
                        }
                    }
                    cArr2 = cArr3;
                }
                try {
                    Object[] objArr3 = {Integer.valueOf(coroutineCreation)};
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1819279892);
                    if (objAccessartificialFrame2 == null) {
                        byte b4 = (byte) 0;
                        byte b5 = b4;
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(15 - (ViewConfiguration.getKeyRepeatDelay() >> 16), (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 20487), 2149 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), 216710116, false, $$e(b4, b5, (byte) (b5 | 8)), new Class[]{Integer.TYPE});
                    }
                    char cCharValue = ((Character) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).charValue();
                    char[] cArr4 = new char[i];
                    if (i % 2 != 0) {
                        i2 = i - 1;
                        cArr4[i2] = (char) (cArr[i2] - b);
                    } else {
                        i2 = i;
                    }
                    if (i2 > 1) {
                        extracallback.a = 0;
                        while (extracallback.a < i2) {
                            int i8 = $10 + 9;
                            $11 = i8 % 128;
                            int i9 = i8 % 2;
                            extracallback.createBrowser = cArr[extracallback.a];
                            extracallback.c = cArr[extracallback.a + 1];
                            if (extracallback.createBrowser == extracallback.c) {
                                cArr4[extracallback.a] = (char) (extracallback.createBrowser - b);
                                cArr4[extracallback.a + 1] = (char) (extracallback.c - b);
                                obj = obj2;
                            } else {
                                Object[] objArr4 = {extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback};
                                Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1894223152);
                                if (objAccessartificialFrame3 == null) {
                                    byte b6 = (byte) 0;
                                    byte b7 = b6;
                                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 45, (char) (58860 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))), ((byte) KeyEvent.getModifierMetaStateMask()) + 2465, 276640984, false, $$e(b6, b7, (byte) (b7 + 3)), new Class[]{Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class});
                                }
                                if (((Integer) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).intValue() == extracallback.g) {
                                    Object[] objArr5 = {extracallback, extracallback, Integer.valueOf(cCharValue), Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), Integer.valueOf(cCharValue), extracallback, Integer.valueOf(cCharValue), extracallback};
                                    Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1361113423);
                                    if (objAccessartificialFrame4 == null) {
                                        byte b8 = (byte) 0;
                                        byte b9 = b8;
                                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(24 - (ViewConfiguration.getWindowTouchSlop() >> 8), (char) (ViewConfiguration.getLongPressTimeout() >> 16), 793 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), -834291897, false, $$e(b8, b9, b9), new Class[]{Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Integer.TYPE, Object.class});
                                    }
                                    obj = null;
                                    int iIntValue = ((Integer) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).intValue();
                                    int i10 = (extracallback.d * cCharValue) + extracallback.g;
                                    cArr4[extracallback.a] = cArr2[iIntValue];
                                    cArr4[extracallback.a + 1] = cArr2[i10];
                                } else {
                                    obj = null;
                                    if (extracallback.b == extracallback.d) {
                                        extracallback.j = ((extracallback.j + cCharValue) - 1) % cCharValue;
                                        extracallback.g = ((extracallback.g + cCharValue) - 1) % cCharValue;
                                        int i11 = (extracallback.b * cCharValue) + extracallback.j;
                                        int i12 = (extracallback.d * cCharValue) + extracallback.g;
                                        cArr4[extracallback.a] = cArr2[i11];
                                        cArr4[extracallback.a + 1] = cArr2[i12];
                                    } else {
                                        int i13 = (extracallback.b * cCharValue) + extracallback.g;
                                        int i14 = (extracallback.d * cCharValue) + extracallback.j;
                                        cArr4[extracallback.a] = cArr2[i13];
                                        cArr4[extracallback.a + 1] = cArr2[i14];
                                    }
                                }
                            }
                            extracallback.a += 2;
                            obj2 = obj;
                        }
                    }
                    int i15 = 0;
                    while (i15 < i) {
                        cArr4[i15] = (char) (cArr4[i15] ^ 13722);
                        i15++;
                        int i16 = $11 + 115;
                        $10 = i16 % 128;
                        int i17 = i16 % 2;
                    }
                    objArr[0] = new String(cArr4);
                } catch (Throwable th2) {
                    Throwable cause2 = th2.getCause();
                    if (cause2 == null) {
                        throw th2;
                    }
                    throw cause2;
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                final ArrayList arrayList = new ArrayList();
                Set<String> stringSet = context.getSharedPreferences(BackgroundFetch.TAG, 0).getStringSet("tasks", new HashSet());
                if (stringSet != null) {
                    Iterator<String> it2 = stringSet.iterator();
                    while (it2.hasNext()) {
                        arrayList.add(new Builder().load(context, it2.next()));
                    }
                }
                BackgroundFetch.getUiHandler().post(new Runnable() { // from class: com.transistorsoft.tsbackgroundfetch.BackgroundFetchConfig.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        onLoadCallback.onLoad(arrayList);
                    }
                });
            }

            /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
                java.util.NoSuchElementException
                	at java.base/java.util.TreeMap.key(Unknown Source)
                	at java.base/java.util.TreeMap.lastKey(Unknown Source)
                	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
                	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
                	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
                */
            public static java.lang.Object[] CoroutineDebuggingKt(android.content.Context r27, int r28, int r29, int r30) {
                /*
                    Method dump skipped, instruction units count: 2957
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.transistorsoft.tsbackgroundfetch.BackgroundFetchConfig.AnonymousClass1.CoroutineDebuggingKt(android.content.Context, int, int, int):java.lang.Object[]");
            }
        });
    }
}
