package com.facebook.react.util;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class JSStackTrace {
    public static final String COLUMN_KEY = "column";
    public static final String FILE_KEY = "file";
    public static final String LINE_NUMBER_KEY = "lineNumber";
    public static final String METHOD_NAME_KEY = "methodName";
    public static final JSStackTrace INSTANCE = new JSStackTrace();
    private static final Pattern FILE_ID_PATTERN = Pattern.compile("\\b((?:seg-\\d+(?:_\\d+)?|\\d+)\\.js)");

    private JSStackTrace() {
    }

    @JvmStatic
    public static final String format(@NotNull String message, @NotNull ReadableArray stack) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(stack, "stack");
        StringBuilder sb = new StringBuilder(message);
        sb.append(", stack:\n");
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            ReadableMap map = stack.getMap(i);
            if (map != null) {
                sb.append(map.getString("methodName"));
                sb.append("@");
                sb.append(INSTANCE.parseFileId(map));
                if (map.hasKey("lineNumber") && !map.isNull("lineNumber") && map.getType("lineNumber") == ReadableType.Number) {
                    sb.append(map.getInt("lineNumber"));
                } else {
                    sb.append(-1);
                }
                if (map.hasKey("column") && !map.isNull("column") && map.getType("column") == ReadableType.Number) {
                    sb.append(":");
                    sb.append(map.getInt("column"));
                }
                sb.append("\n");
            }
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    private final String parseFileId(ReadableMap readableMap) {
        String string;
        if (readableMap.hasKey("file") && !readableMap.isNull("file") && readableMap.getType("file") == ReadableType.String && (string = readableMap.getString("file")) != null) {
            Matcher matcher = FILE_ID_PATTERN.matcher(string);
            if (matcher.find()) {
                return matcher.group(1) + ":";
            }
            return "";
        }
        return "";
    }
}
