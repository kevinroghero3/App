package _COROUTINE;

/* JADX INFO: loaded from: classes3.dex */
public final class CoroutineDebuggingKt {
    private static final String ARTIFICIAL_FRAME_PACKAGE_NAME = "_COROUTINE";

    public static final String getARTIFICIAL_FRAME_PACKAGE_NAME() {
        return ARTIFICIAL_FRAME_PACKAGE_NAME;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StackTraceElement artificialFrame(Throwable th, String str) {
        StackTraceElement stackTraceElement = th.getStackTrace()[0];
        return new StackTraceElement(ARTIFICIAL_FRAME_PACKAGE_NAME + '.' + str, "_", stackTraceElement.getFileName(), stackTraceElement.getLineNumber());
    }
}
