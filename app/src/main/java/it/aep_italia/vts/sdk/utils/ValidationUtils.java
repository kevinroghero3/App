package it.aep_italia.vts.sdk.utils;

import it.aep_italia.vts.sdk.errors.VtsError;
import it.aep_italia.vts.sdk.errors.VtsException;
import java.util.IllegalFormatException;

/* JADX INFO: loaded from: classes6.dex */
public class ValidationUtils {
    private static String a(String str, Object... objArr) {
        try {
            return String.format(str, objArr);
        } catch (NullPointerException | IllegalFormatException unused) {
            return "Invalid exception message";
        }
    }

    public static void assertISO8601(String str, VtsError vtsError, String str2, Object... objArr) {
        try {
            if (DateUtils.fromISO8601(str) != null) {
            } else {
                throw new VtsException(vtsError, a(str2, objArr), new Object[0]);
            }
        } catch (Exception unused) {
            throw new VtsException(vtsError, a(str2, objArr), new Object[0]);
        }
    }

    public static void assertNonBlank(String str, VtsError vtsError, String str2, Object... objArr) {
        if (StringUtils.isBlank(str)) {
            throw new VtsException(vtsError, a(str2, objArr), new Object[0]);
        }
    }

    public static void assertNonNull(Object obj, VtsError vtsError, String str, Object... objArr) {
        if (obj == null) {
            throw new VtsException(vtsError, a(str, objArr), new Object[0]);
        }
    }

    public static void assertTrue(boolean z, VtsError vtsError, String str, Object... objArr) {
        if (!z) {
            throw new VtsException(vtsError, a(str, objArr), new Object[0]);
        }
    }
}
