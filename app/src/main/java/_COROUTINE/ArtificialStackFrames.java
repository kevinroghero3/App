package _COROUTINE;

/* JADX INFO: loaded from: classes3.dex */
public final class ArtificialStackFrames {
    public final StackTraceElement coroutineCreation() {
        return CoroutineDebuggingKt.artificialFrame(new Exception(), _CREATION.class.getSimpleName());
    }

    public final StackTraceElement coroutineBoundary() {
        return CoroutineDebuggingKt.artificialFrame(new Exception(), _BOUNDARY.class.getSimpleName());
    }
}
