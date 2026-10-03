package kotlin.coroutines.jvm.internal;

/* JADX INFO: loaded from: classes3.dex */
public interface CoroutineStackFrame {
    CoroutineStackFrame getCallerFrame();

    StackTraceElement getStackTraceElement();
}
