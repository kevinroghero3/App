package com.salesforce.marketingcloud.sfmcsdk.components.logging;

import android.text.TextUtils;
import io.sentry.android.core.SentryLogcatAdapter;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public abstract class Logger {
    public static final Companion Companion = new Companion(null);
    private static final int MAX_TAG_LENGTH = 23;
    private static final String REDACTED_VALUE_REPLACEMENT_TEXT = "[REDACTED]";
    private LogListener listener;
    private List<String> redactedValues = CollectionsKt__CollectionsKt.emptyList();
    private LogLevel logLevel = LogLevel.ERROR;

    public List<String> getRedactedValues() {
        return this.redactedValues;
    }

    public void setRedactedValues(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.redactedValues = list;
    }

    public LogLevel getLogLevel() {
        return this.logLevel;
    }

    public void setLogLevel(@NotNull LogLevel logLevel) {
        Intrinsics.checkNotNullParameter(logLevel, "<set-?>");
        this.logLevel = logLevel;
    }

    public LogListener getListener() {
        return this.listener;
    }

    public void setListener(@Nullable LogListener logListener) {
        this.listener = logListener;
    }

    /* JADX INFO: loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final String createTag(@NotNull KClass<?> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        String simpleName = JvmClassMappingKt.getJavaClass((KClass) clazz).getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
        return createTag(simpleName);
    }

    public final String createTag(@NotNull String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        return formatTag(tag);
    }

    public void d(@NotNull String tag, @NotNull Function0<String> lazyMsg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(lazyMsg, "lazyMsg");
        d(tag, null, lazyMsg);
    }

    public static /* synthetic */ void d$default(Logger logger, String str, Throwable th, Function0 function0, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: d");
        }
        if ((i & 2) != 0) {
            th = null;
        }
        logger.d(str, th, function0);
    }

    public void d(@NotNull String tag, @Nullable Throwable th, @NotNull Function0<String> lazyMsg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(lazyMsg, "lazyMsg");
        log$sfmcsdk_release(LogLevel.DEBUG, tag, th, lazyMsg);
    }

    public void w(@NotNull String tag, @NotNull Function0<String> lazyMsg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(lazyMsg, "lazyMsg");
        w(tag, null, lazyMsg);
    }

    public static /* synthetic */ void w$default(Logger logger, String str, Throwable th, Function0 function0, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: w");
        }
        if ((i & 2) != 0) {
            th = null;
        }
        logger.w(str, th, function0);
    }

    public void w(@NotNull String tag, @Nullable Throwable th, @NotNull Function0<String> lazyMsg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(lazyMsg, "lazyMsg");
        log$sfmcsdk_release(LogLevel.WARN, tag, th, lazyMsg);
    }

    public void e(@NotNull String tag, @NotNull Function0<String> lazyMsg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(lazyMsg, "lazyMsg");
        e(tag, null, lazyMsg);
    }

    public static /* synthetic */ void e$default(Logger logger, String str, Throwable th, Function0 function0, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: e");
        }
        if ((i & 2) != 0) {
            th = null;
        }
        logger.e(str, th, function0);
    }

    public void e(@NotNull String tag, @Nullable Throwable th, @NotNull Function0<String> lazyMsg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(lazyMsg, "lazyMsg");
        log$sfmcsdk_release(LogLevel.ERROR, tag, th, lazyMsg);
    }

    public static /* synthetic */ void log$sfmcsdk_release$default(Logger logger, LogLevel logLevel, String str, Throwable th, Function0 function0, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: log");
        }
        if ((i & 4) != 0) {
            th = null;
        }
        logger.log$sfmcsdk_release(logLevel, str, th, function0);
    }

    public final void log$sfmcsdk_release(@NotNull LogLevel lvl, @NotNull String tag, @Nullable Throwable th, @NotNull Function0<String> lazyMsg) {
        Intrinsics.checkNotNullParameter(lvl, "lvl");
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(lazyMsg, "lazyMsg");
        LogListener listener = getListener();
        if (listener == null || lvl.compareTo(getLogLevel()) < 0) {
            return;
        }
        try {
            listener.out(lvl, formatTag(tag), formatMsg(lazyMsg.invoke()), th);
        } catch (Exception e) {
            SentryLogcatAdapter.e("~$Logger", "Exception was thrown by " + listener.getClass().getName(), e);
        }
    }

    private final String formatTag(String str) {
        return str.length() <= 23 ? str : str.subSequence(0, 23).toString();
    }

    private final String formatMsg(String str) {
        if (TextUtils.getTrimmedLength(str) == 0) {
            return "FORMATTED LOG MESSAGE WAS EMPTY";
        }
        for (String str2 : getRedactedValues()) {
            if (!Intrinsics.areEqual(REDACTED_VALUE_REPLACEMENT_TEXT, str2)) {
                str = StringsKt__StringsJVMKt.replace(str, str2, REDACTED_VALUE_REPLACEMENT_TEXT, true);
            }
        }
        return str;
    }
}
