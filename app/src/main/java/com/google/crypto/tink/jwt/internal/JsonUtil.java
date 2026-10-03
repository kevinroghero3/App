package com.google.crypto.tink.jwt.internal;

import com.google.crypto.tink.internal.JsonParser;
import com.google.crypto.tink.jwt.JwtInvalidException;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public final class JsonUtil {
    public static boolean isValidString(String str) {
        return JsonParser.isValidString(str);
    }

    public static JsonObject parseJson(String str) throws JwtInvalidException {
        try {
            return JsonParser.parse(str).getAsJsonObject();
        } catch (JsonParseException | IOException | IllegalStateException e) {
            throw new JwtInvalidException("invalid JSON: " + e);
        }
    }

    public static JsonArray parseJsonArray(String str) throws JwtInvalidException {
        try {
            return JsonParser.parse(str).getAsJsonArray();
        } catch (JsonParseException | IOException | IllegalStateException e) {
            throw new JwtInvalidException("invalid JSON: " + e);
        }
    }

    private JsonUtil() {
    }
}
