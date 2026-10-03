package it.aep_italia.vts.sdk.core;

import android.content.Context;
import it.aep_italia.vts.sdk.VtsSdkConfiguration;
import it.aep_italia.vts.sdk.dto.server.server_info.VtsServerInfoDTO;
import it.aep_italia.vts.sdk.errors.VtsError;
import it.aep_italia.vts.sdk.errors.VtsException;
import it.aep_italia.vts.sdk.internal.VtsFileLogger;
import it.aep_italia.vts.sdk.internal.VtsWellKnownStrings;
import it.aep_italia.vts.sdk.utils.ValidationUtils;
import java.util.Locale;
import timber.log.Timber;

/* JADX INFO: loaded from: classes6.dex */
public final class VtsLog {
    private static boolean a = false;
    private static boolean b = true;
    private static int c = Level.TRACE.value;

    public enum Level {
        TRACE(6),
        VERBOSE(5),
        DEBUG(4),
        INFO(3),
        WARN(2),
        ERROR(1),
        NONE(0);

        private int value;

        Level(int i) {
            this.value = i;
        }
    }

    private static void a(Context context, VtsSdkConfiguration vtsSdkConfiguration, VtsServerInfoDTO vtsServerInfoDTO) throws VtsException {
        VtsError vtsError = VtsError.INVALID_PARAMETER;
        boolean z = false;
        ValidationUtils.assertNonNull(context, vtsError, "Context cannot be null", new Object[0]);
        ValidationUtils.assertNonNull(vtsSdkConfiguration, vtsError, "Configuration cannot be null", new Object[0]);
        ValidationUtils.assertNonNull(vtsServerInfoDTO, vtsError, "Server configuration cannot be null", new Object[0]);
        if (a) {
            return;
        }
        a = true;
        boolean z2 = (context.getApplicationInfo().flags & 2) != 0;
        if ((!z2 && vtsSdkConfiguration.loggingNonDebug()) || (z2 && vtsServerInfoDTO.getBooleanParameter(VtsWellKnownStrings.PARAM_LOGS_ENABLED, true))) {
            z = true;
        }
        b = z;
        if (z) {
            Timber.plant(new Timber.DebugTree());
            Timber.plant(new VtsFileLogger(context, vtsSdkConfiguration));
        }
        try {
            c = Level.valueOf(vtsSdkConfiguration.getLoggingMinlevel()).value;
            i("Logging level is set to %s.", vtsSdkConfiguration.getLoggingMinlevel().toUpperCase(Locale.ITALY));
        } catch (Exception unused) {
            w("Unrecognized logging level %s, defaulting to VERBOSE.", vtsSdkConfiguration.getLoggingMinlevel());
        }
    }

    public static void d(String str, Object... objArr) {
        if (isEnabled(Level.DEBUG)) {
            Timber.d(str, objArr);
        }
    }

    public static void dt(String str, String str2, Object... objArr) {
        if (isEnabled(Level.DEBUG)) {
            Timber.tag(str).d(str2, objArr);
        }
    }

    public static void e(String str, Object... objArr) {
        if (isEnabled(Level.ERROR)) {
            Timber.e(str, objArr);
        }
    }

    public static void e(Throwable th, String str, Object... objArr) {
        if (isEnabled(Level.ERROR)) {
            Timber.e(th, str, objArr);
        }
    }

    public static void et(String str, String str2, Object... objArr) {
        if (isEnabled(Level.ERROR)) {
            Timber.tag(str).e(str2, objArr);
        }
    }

    public static void et(String str, Throwable th, String str2, Object... objArr) {
        if (isEnabled(Level.ERROR)) {
            Timber.tag(str).e(th, str2, objArr);
        }
    }

    public static void i(String str, Object... objArr) {
        if (isEnabled(Level.INFO)) {
            Timber.i(str, objArr);
        }
    }

    public static void init(VtsSdk vtsSdk) throws VtsException {
        ValidationUtils.assertNonNull(vtsSdk, VtsError.INVALID_PARAMETER, "SDK instance cannot be null", new Object[0]);
        a(vtsSdk.getContext(), vtsSdk.getSdkConfiguration(), vtsSdk.c());
    }

    public static boolean isEnabled(Level level) {
        return level != null && b && c >= level.value;
    }

    public static boolean isInitialized() {
        return a;
    }

    public static void it(String str, String str2, Object... objArr) {
        if (isEnabled(Level.INFO)) {
            Timber.tag(str).i(str2, objArr);
        }
    }

    public static void t(String str, Object... objArr) {
        if (isEnabled(Level.TRACE)) {
            Timber.v(str, objArr);
        }
    }

    public static void tt(String str, String str2, Object... objArr) {
        if (isEnabled(Level.TRACE)) {
            Timber.tag(str).v(str2, objArr);
        }
    }

    public static void v(String str, Object... objArr) {
        if (isEnabled(Level.VERBOSE)) {
            Timber.v(str, objArr);
        }
    }

    public static void vt(String str, String str2, Object... objArr) {
        if (isEnabled(Level.VERBOSE)) {
            Timber.tag(str).v(str2, objArr);
        }
    }

    public static void w(String str, Object... objArr) {
        if (isEnabled(Level.WARN)) {
            Timber.w(str, objArr);
        }
    }

    public static void wt(String str, String str2, Object... objArr) {
        if (isEnabled(Level.WARN)) {
            Timber.tag(str).w(str2, objArr);
        }
    }
}
