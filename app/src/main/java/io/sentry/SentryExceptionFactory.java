package io.sentry;

import io.sentry.exception.ExceptionMechanismException;
import io.sentry.protocol.Mechanism;
import io.sentry.protocol.SentryException;
import io.sentry.protocol.SentryStackFrame;
import io.sentry.protocol.SentryStackTrace;
import io.sentry.protocol.SentryThread;
import io.sentry.util.Objects;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class SentryExceptionFactory {
    private final SentryStackTraceFactory sentryStackTraceFactory;

    public SentryExceptionFactory(@NotNull SentryStackTraceFactory sentryStackTraceFactory) {
        this.sentryStackTraceFactory = (SentryStackTraceFactory) Objects.requireNonNull(sentryStackTraceFactory, "The SentryStackTraceFactory is required.");
    }

    public List<SentryException> getSentryExceptionsFromThread(@NotNull SentryThread sentryThread, @NotNull Mechanism mechanism, @NotNull Throwable th) {
        SentryStackTrace stacktrace = sentryThread.getStacktrace();
        if (stacktrace == null) {
            return new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(getSentryException(th, mechanism, sentryThread.getId(), stacktrace.getFrames(), true));
        return arrayList;
    }

    public List<SentryException> getSentryExceptions(@NotNull Throwable th) {
        return getSentryExceptions(extractExceptionQueue(th));
    }

    private List<SentryException> getSentryExceptions(@NotNull Deque<SentryException> deque) {
        return new ArrayList(deque);
    }

    private SentryException getSentryException(@NotNull Throwable th, @Nullable Mechanism mechanism, @Nullable Long l, @Nullable List<SentryStackFrame> list, boolean z) {
        Package r0 = th.getClass().getPackage();
        String name = th.getClass().getName();
        SentryException sentryException = new SentryException();
        String message = th.getMessage();
        if (r0 != null) {
            name = name.replace(r0.getName() + ".", "");
        }
        String name2 = r0 != null ? r0.getName() : null;
        if (list != null && !list.isEmpty()) {
            SentryStackTrace sentryStackTrace = new SentryStackTrace(list);
            if (z) {
                sentryStackTrace.setSnapshot(Boolean.TRUE);
            }
            sentryException.setStacktrace(sentryStackTrace);
        }
        sentryException.setThreadId(l);
        sentryException.setType(name);
        sentryException.setMechanism(mechanism);
        sentryException.setModule(name2);
        sentryException.setValue(message);
        return sentryException;
    }

    Deque<SentryException> extractExceptionQueue(@NotNull Throwable th) {
        return extractExceptionQueueInternal(th, new AtomicInteger(-1), new HashSet<>(), new ArrayDeque(), null);
    }

    Deque<SentryException> extractExceptionQueueInternal(@NotNull Throwable th, @NotNull AtomicInteger atomicInteger, @NotNull HashSet<Throwable> hashSet, @NotNull Deque<SentryException> deque, @Nullable String str) {
        Mechanism mechanism;
        boolean zIsSnapshot;
        Throwable th2;
        Thread threadCurrentThread;
        String str2 = str;
        int i = atomicInteger.get();
        Throwable cause = th;
        while (cause != null && hashSet.add(cause)) {
            if (str2 == null) {
                str2 = "chained";
            }
            if (cause instanceof ExceptionMechanismException) {
                ExceptionMechanismException exceptionMechanismException = (ExceptionMechanismException) cause;
                mechanism = exceptionMechanismException.getExceptionMechanism();
                Throwable throwable = exceptionMechanismException.getThrowable();
                Thread thread = exceptionMechanismException.getThread();
                zIsSnapshot = exceptionMechanismException.isSnapshot();
                threadCurrentThread = thread;
                th2 = throwable;
            } else {
                mechanism = new Mechanism();
                zIsSnapshot = false;
                th2 = cause;
                threadCurrentThread = Thread.currentThread();
            }
            deque.addFirst(getSentryException(th2, mechanism, Long.valueOf(threadCurrentThread.getId()), this.sentryStackTraceFactory.getStackFrames(th2.getStackTrace(), Boolean.FALSE.equals(mechanism.isHandled())), zIsSnapshot));
            if (mechanism.getType() == null) {
                mechanism.setType(str2);
            }
            if (atomicInteger.get() >= 0) {
                mechanism.setParentId(Integer.valueOf(i));
            }
            int iIncrementAndGet = atomicInteger.incrementAndGet();
            mechanism.setExceptionId(Integer.valueOf(iIncrementAndGet));
            Throwable[] suppressed = th2.getSuppressed();
            if (suppressed != null && suppressed.length > 0) {
                for (Throwable th3 : suppressed) {
                    extractExceptionQueueInternal(th3, atomicInteger, hashSet, deque, "suppressed");
                }
            }
            cause = th2.getCause();
            str2 = null;
            i = iIncrementAndGet;
        }
        return deque;
    }
}
