package com.facebook.react.util;

import android.util.JsonWriter;
import com.facebook.react.bridge.JsonWriterHelper;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import java.io.IOException;
import java.io.StringWriter;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class ExceptionDataHelper {
    public static final String EXTRA_DATA_FIELD = "extraData";
    public static final ExceptionDataHelper INSTANCE = new ExceptionDataHelper();

    private ExceptionDataHelper() {
    }

    @JvmStatic
    public static final String getExtraDataAsJson(@Nullable ReadableMap readableMap) {
        if (readableMap == null || readableMap.getType("extraData") == ReadableType.Null) {
            return null;
        }
        try {
            StringWriter stringWriter = new StringWriter();
            JsonWriter jsonWriter = new JsonWriter(stringWriter);
            JsonWriterHelper.value(jsonWriter, readableMap.getDynamic("extraData"));
            jsonWriter.close();
            stringWriter.close();
            return stringWriter.toString();
        } catch (IOException unused) {
            return null;
        }
    }
}
