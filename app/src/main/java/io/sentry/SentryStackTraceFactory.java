package io.sentry;

import io.sentry.protocol.SentryStackFrame;
import io.sentry.util.CollectionUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class SentryStackTraceFactory {
    private static final int STACKTRACE_FRAME_LIMIT = 100;
    private final SentryOptions options;

    public SentryStackTraceFactory(@NotNull SentryOptions sentryOptions) {
        this.options = sentryOptions;
    }

    public List<SentryStackFrame> getStackFrames(@Nullable StackTraceElement[] stackTraceElementArr, boolean z) {
        if (stackTraceElementArr == null || stackTraceElementArr.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            if (stackTraceElement != null) {
                String className = stackTraceElement.getClassName();
                if (z || !className.startsWith("io.sentry.") || className.startsWith("io.sentry.samples.") || className.startsWith("io.sentry.mobile.")) {
                    SentryStackFrame sentryStackFrame = new SentryStackFrame();
                    sentryStackFrame.setInApp(isInApp(className));
                    sentryStackFrame.setModule(className);
                    sentryStackFrame.setFunction(stackTraceElement.getMethodName());
                    sentryStackFrame.setFilename(stackTraceElement.getFileName());
                    if (stackTraceElement.getLineNumber() >= 0) {
                        sentryStackFrame.setLineno(Integer.valueOf(stackTraceElement.getLineNumber()));
                    }
                    sentryStackFrame.setNative(Boolean.valueOf(stackTraceElement.isNativeMethod()));
                    arrayList.add(sentryStackFrame);
                    if (arrayList.size() >= 100) {
                        break;
                    }
                }
            }
        }
        Collections.reverse(arrayList);
        return arrayList;
    }

    public Boolean isInApp(@Nullable String str) {
        if (str == null || str.isEmpty()) {
            return Boolean.TRUE;
        }
        Iterator<String> it2 = this.options.getInAppIncludes().iterator();
        while (it2.hasNext()) {
            if (str.startsWith(it2.next())) {
                return Boolean.TRUE;
            }
        }
        Iterator<String> it3 = this.options.getInAppExcludes().iterator();
        while (it3.hasNext()) {
            if (str.startsWith(it3.next())) {
                return Boolean.FALSE;
            }
        }
        return null;
    }

    List<SentryStackFrame> getInAppCallStack(@NotNull Throwable th) {
        List<SentryStackFrame> stackFrames = getStackFrames(th.getStackTrace(), false);
        if (stackFrames == null) {
            return Collections.emptyList();
        }
        List<SentryStackFrame> listFilterListEntries = CollectionUtils.filterListEntries(stackFrames, new CollectionUtils.Predicate() { // from class: io.sentry.SentryStackTraceFactory$$ExternalSyntheticLambda0
            @Override // io.sentry.util.CollectionUtils.Predicate
            public final boolean test(Object obj) {
                return SentryStackTraceFactory.lambda$getInAppCallStack$0((SentryStackFrame) obj);
            }
        });
        return !listFilterListEntries.isEmpty() ? listFilterListEntries : CollectionUtils.filterListEntries(stackFrames, new CollectionUtils.Predicate() { // from class: io.sentry.SentryStackTraceFactory$$ExternalSyntheticLambda1
            @Override // io.sentry.util.CollectionUtils.Predicate
            public final boolean test(Object obj) {
                return SentryStackTraceFactory.lambda$getInAppCallStack$1((SentryStackFrame) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getInAppCallStack$0(SentryStackFrame sentryStackFrame) {
        return Boolean.TRUE.equals(sentryStackFrame.isInApp());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getInAppCallStack$1(SentryStackFrame sentryStackFrame) {
        String module = sentryStackFrame.getModule();
        return !(module != null && (module.startsWith("sun.") || module.startsWith("java.") || module.startsWith("android.") || module.startsWith("com.android.")));
    }

    public List<SentryStackFrame> getInAppCallStack() {
        return getInAppCallStack(new Exception());
    }
}
