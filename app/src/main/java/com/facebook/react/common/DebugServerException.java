package com.facebook.react.common;

import android.net.Uri;
import com.facebook.common.logging.FLog;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.util.List;
import java.util.ListIterator;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class DebugServerException extends RuntimeException {
    public static final Companion Companion = new Companion(null);
    private static final String GENERIC_ERROR_MESSAGE = "\n\nTry the following to fix the issue:\n\\u2022 Ensure that Metro is running\n\\u2022 Ensure that your device/emulator is connected to your machine and has USB debugging enabled - run 'adb devices' to see a list of connected devices\n\\u2022 Ensure Airplane Mode is disabled\n\\u2022 If you're on a physical device connected to the same machine, run 'adb reverse tcp:<PORT> tcp:<PORT> to forward requests from your device\n\\u2022 If your device is on the same Wi-Fi network, set 'Debug server host & port for device' in 'Dev settings' to your machine's IP address and the port of the local dev server - e.g. 10.0.1.1:<PORT>\n\n";
    private final String originalMessage;

    public /* synthetic */ DebugServerException(String str, String str2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, i, i2);
    }

    @JvmStatic
    public static final DebugServerException makeGeneric(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable Throwable th) {
        return Companion.makeGeneric(str, str2, str3, th);
    }

    @JvmStatic
    public static final DebugServerException makeGeneric(@NotNull String str, @NotNull String str2, @Nullable Throwable th) {
        return Companion.makeGeneric(str, str2, th);
    }

    @JvmStatic
    public static final DebugServerException parse(@Nullable String str, @Nullable String str2) {
        return Companion.parse(str, str2);
    }

    public final String getOriginalMessage() {
        return this.originalMessage;
    }

    private DebugServerException(String str, String str2, int i, int i2) {
        super(str + "\n  at " + str2 + ":" + i + ":" + i2);
        this.originalMessage = str;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DebugServerException(@NotNull String description) {
        super(description);
        Intrinsics.checkNotNullParameter(description, "description");
        this.originalMessage = description;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DebugServerException(@NotNull String detailMessage, @Nullable Throwable th) {
        super(detailMessage, th);
        Intrinsics.checkNotNullParameter(detailMessage, "detailMessage");
        this.originalMessage = detailMessage;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final DebugServerException makeGeneric(@NotNull String url, @NotNull String reason, @Nullable Throwable th) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(reason, "reason");
            return makeGeneric(url, reason, "", th);
        }

        @JvmStatic
        public final DebugServerException makeGeneric(@NotNull String url, @NotNull String reason, @NotNull String extra, @Nullable Throwable th) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(reason, "reason");
            Intrinsics.checkNotNullParameter(extra, "extra");
            return new DebugServerException(reason + StringsKt__StringsJVMKt.replace$default(DebugServerException.GENERIC_ERROR_MESSAGE, "<PORT>", String.valueOf(Uri.parse(url).getPort()), false, 4, (Object) null) + extra, th);
        }

        @JvmStatic
        public final DebugServerException parse(@Nullable String str, @Nullable String str2) {
            if (str2 == null || str2.length() == 0) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str2);
                String string = jSONObject.getString("filename");
                String string2 = jSONObject.getString("message");
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                Intrinsics.checkNotNull(string);
                return new DebugServerException(string2, shortenFileName(string), jSONObject.getInt("lineNumber"), jSONObject.getInt("column"), null);
            } catch (JSONException e) {
                FLog.w(ReactConstants.TAG, "Could not parse DebugServerException from: " + str2, e);
                return null;
            }
        }

        private final String shortenFileName(String str) {
            List listEmptyList;
            List<String> listSplit = new Regex(RemoteSettings.FORWARD_SLASH_STRING).split(str, 0);
            if (!listSplit.isEmpty()) {
                ListIterator<String> listIterator = listSplit.listIterator(listSplit.size());
                while (listIterator.hasPrevious()) {
                    if (listIterator.previous().length() != 0) {
                        listEmptyList = CollectionsKt___CollectionsKt.take(listSplit, listIterator.nextIndex() + 1);
                    }
                }
                listEmptyList = CollectionsKt__CollectionsKt.emptyList();
            } else {
                listEmptyList = CollectionsKt__CollectionsKt.emptyList();
            }
            return (String) ArraysKt___ArraysKt.last((String[]) listEmptyList.toArray(new String[0]));
        }
    }
}
