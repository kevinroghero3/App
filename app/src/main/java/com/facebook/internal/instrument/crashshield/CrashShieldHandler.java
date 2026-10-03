package com.facebook.internal.instrument.crashshield;

import android.os.Handler;
import android.os.Looper;
import com.facebook.FacebookSdk;
import com.facebook.internal.instrument.ExceptionAnalyzer;
import com.facebook.internal.instrument.InstrumentData;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class CrashShieldHandler {
    public static final CrashShieldHandler INSTANCE = new CrashShieldHandler();
    private static final Set<Object> crashingObjects = Collections.newSetFromMap(new WeakHashMap());
    private static boolean enabled;

    @JvmStatic
    public static final boolean isDebug() {
        return false;
    }

    @JvmStatic
    public static final void methodFinished(@Nullable Object obj) {
    }

    private CrashShieldHandler() {
    }

    @JvmStatic
    public static final void enable() {
        enabled = true;
    }

    @JvmStatic
    public static final void disable() {
        enabled = false;
    }

    @JvmStatic
    public static final void handleThrowable(@Nullable Throwable th, @NotNull Object o2) {
        Intrinsics.checkNotNullParameter(o2, "o");
        if (enabled) {
            crashingObjects.add(o2);
            if (FacebookSdk.getAutoLogAppEventsEnabled()) {
                ExceptionAnalyzer.execute(th);
                InstrumentData.Builder.build(th, InstrumentData.Type.CrashShield).save();
            }
            scheduleCrashInDebug(th);
        }
    }

    @JvmStatic
    public static final boolean isObjectCrashing(@NotNull Object o2) {
        Intrinsics.checkNotNullParameter(o2, "o");
        return crashingObjects.contains(o2);
    }

    @JvmStatic
    public static final void reset() {
        resetCrashingObjects();
    }

    @JvmStatic
    public static final void resetCrashingObjects() {
        crashingObjects.clear();
    }

    @JvmStatic
    public static final void scheduleCrashInDebug(@Nullable final Throwable th) {
        if (isDebug()) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.facebook.internal.instrument.crashshield.CrashShieldHandler.scheduleCrashInDebug.1
                @Override // java.lang.Runnable
                public void run() {
                    throw new RuntimeException(th);
                }
            });
        }
    }
}
