package com.facebook.react.bridge;

import com.facebook.common.logging.FLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public final class ReactSoftExceptionLogger {
    public static final ReactSoftExceptionLogger INSTANCE = new ReactSoftExceptionLogger();
    private static final List<ReactSoftExceptionListener> listeners = new CopyOnWriteArrayList();

    /* JADX INFO: loaded from: classes2.dex */
    public interface ReactSoftExceptionListener {
        void logSoftException(@NotNull String str, @NotNull Throwable th);
    }

    private ReactSoftExceptionLogger() {
    }

    /* JADX INFO: loaded from: classes4.dex */
    public static final class Categories {
        public static final Categories INSTANCE = new Categories();
        public static final String RVG_IS_VIEW_CLIPPED = "ReactViewGroup.isViewClipped";
        public static final String RVG_ON_VIEW_REMOVED = "ReactViewGroup.onViewRemoved";
        public static final String SOFT_ASSERTIONS = "SoftAssertions";

        private Categories() {
        }
    }

    @JvmStatic
    public static final void addListener(@NotNull ReactSoftExceptionListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        List<ReactSoftExceptionListener> list = listeners;
        if (list.contains(listener)) {
            return;
        }
        list.add(listener);
    }

    @JvmStatic
    public static final void removeListener(@NotNull ReactSoftExceptionListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        listeners.remove(listener);
    }

    @JvmStatic
    public static final void clearListeners() {
        listeners.clear();
    }

    @JvmStatic
    public static final void logSoftExceptionVerbose(@NotNull String category, @NotNull Throwable cause) {
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(cause, "cause");
        logSoftException(category + "|" + cause.getClass().getSimpleName() + ":" + cause.getMessage(), cause);
    }

    @JvmStatic
    public static final void logSoftException(@NotNull String category, @NotNull Throwable cause) {
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(cause, "cause");
        List<ReactSoftExceptionListener> list = listeners;
        if (!list.isEmpty()) {
            Iterator<ReactSoftExceptionListener> it2 = list.iterator();
            while (it2.hasNext()) {
                it2.next().logSoftException(category, cause);
            }
            return;
        }
        FLog.e(category, "Unhandled SoftException", cause);
    }

    @JvmStatic
    private static final void logNoThrowSoftExceptionWithMessage(String str, String str2) {
        logSoftException(str, new ReactNoCrashSoftException(str2));
    }
}
