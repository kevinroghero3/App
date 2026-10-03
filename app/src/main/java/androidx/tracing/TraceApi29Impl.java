package androidx.tracing;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes2.dex */
final class TraceApi29Impl {
    private TraceApi29Impl() {
    }

    public static boolean isEnabled() {
        return android.os.Trace.isEnabled();
    }

    public static void beginAsyncSection(@NonNull String str, int i) {
        android.os.Trace.beginAsyncSection(str, i);
    }

    public static void endAsyncSection(@NonNull String str, int i) {
        android.os.Trace.endAsyncSection(str, i);
    }

    public static void setCounter(@NonNull String str, int i) {
        android.os.Trace.setCounter(str, i);
    }
}
