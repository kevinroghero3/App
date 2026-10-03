package com.google.crypto.tink;

import com.google.crypto.tink.internal.JsonParser;
import com.google.crypto.tink.proto.EncryptedKeyset;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KeyStatusType;
import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.proto.KeysetInfo;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.subtle.Base64;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import io.sentry.instrumentation.file.SentryFileInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.Path;
import org.apache.commons.lang3.CharEncoding;

/* JADX INFO: loaded from: classes5.dex */
public final class JsonKeysetReader implements KeysetReader {
    private static final long MAX_KEY_ID = 4294967295L;
    private static final long MIN_KEY_ID = -2147483648L;
    private static final Charset UTF_8 = Charset.forName(CharEncoding.UTF_8);
    private final InputStream inputStream;
    private boolean urlSafeBase64 = false;

    private JsonKeysetReader(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public static JsonKeysetReader withInputStream(InputStream inputStream) throws IOException {
        return new JsonKeysetReader(inputStream);
    }

    @Deprecated
    public static JsonKeysetReader withJsonObject(Object obj) {
        return withString(obj.toString());
    }

    public static JsonKeysetReader withString(String str) {
        return new JsonKeysetReader(new ByteArrayInputStream(str.getBytes(UTF_8)));
    }

    @Deprecated
    public static JsonKeysetReader withBytes(byte[] bArr) {
        return new JsonKeysetReader(new ByteArrayInputStream(bArr));
    }

    @Deprecated
    public static JsonKeysetReader withFile(File file) throws IOException {
        return withInputStream(SentryFileInputStream.Factory.create(new FileInputStream(file), file));
    }

    @Deprecated
    public static JsonKeysetReader withPath(String str) throws IOException {
        File file = new File(str);
        return withInputStream(SentryFileInputStream.Factory.create(new FileInputStream(file), file));
    }

    @Deprecated
    public static JsonKeysetReader withPath(Path path) throws IOException {
        File file = path.toFile();
        return withInputStream(SentryFileInputStream.Factory.create(new FileInputStream(file), file));
    }

    public JsonKeysetReader withUrlSafeBase64() {
        this.urlSafeBase64 = true;
        return this;
    }

    @Override // com.google.crypto.tink.KeysetReader
    public Keyset read() throws IOException {
        try {
            try {
                Keyset keysetKeysetFromJson = keysetFromJson(JsonParser.parse(new String(Util.readAll(this.inputStream), UTF_8)).getAsJsonObject());
                InputStream inputStream = this.inputStream;
                if (inputStream != null) {
                    inputStream.close();
                }
                return keysetKeysetFromJson;
            } catch (JsonParseException | IllegalStateException e) {
                throw new IOException(e);
            }
        } catch (Throwable th) {
            InputStream inputStream2 = this.inputStream;
            if (inputStream2 != null) {
                inputStream2.close();
            }
            throw th;
        }
    }

    @Override // com.google.crypto.tink.KeysetReader
    public EncryptedKeyset readEncrypted() throws IOException {
        try {
            try {
                EncryptedKeyset encryptedKeysetEncryptedKeysetFromJson = encryptedKeysetFromJson(JsonParser.parse(new String(Util.readAll(this.inputStream), UTF_8)).getAsJsonObject());
                InputStream inputStream = this.inputStream;
                if (inputStream != null) {
                    inputStream.close();
                }
                return encryptedKeysetEncryptedKeysetFromJson;
            } catch (JsonParseException | IllegalStateException e) {
                throw new IOException(e);
            }
        } catch (Throwable th) {
            InputStream inputStream2 = this.inputStream;
            if (inputStream2 != null) {
                inputStream2.close();
            }
            throw th;
        }
    }

    private static int getKeyId(JsonElement jsonElement) throws IOException {
        if (!jsonElement.isJsonPrimitive()) {
            throw new IOException("invalid key id: not a JSON primitive");
        }
        if (!jsonElement.getAsJsonPrimitive().isNumber()) {
            throw new IOException("invalid key id: not a JSON number");
        }
        try {
            long parsedNumberAsLongOrThrow = JsonParser.getParsedNumberAsLongOrThrow(jsonElement.getAsJsonPrimitive().getAsNumber());
            if (parsedNumberAsLongOrThrow > MAX_KEY_ID || parsedNumberAsLongOrThrow < MIN_KEY_ID) {
                throw new IOException("invalid key id");
            }
            return (int) parsedNumberAsLongOrThrow;
        } catch (NumberFormatException e) {
            throw new IOException(e);
        }
    }

    private Keyset keysetFromJson(JsonObject jsonObject) throws IOException {
        if (!jsonObject.has("key")) {
            throw new JsonParseException("invalid keyset: no key");
        }
        JsonElement jsonElement = jsonObject.get("key");
        if (!jsonElement.isJsonArray()) {
            throw new JsonParseException("invalid keyset: key must be an array");
        }
        JsonArray asJsonArray = jsonElement.getAsJsonArray();
        if (asJsonArray.size() == 0) {
            throw new JsonParseException("invalid keyset: key is empty");
        }
        Keyset.Builder builderNewBuilder = Keyset.newBuilder();
        if (jsonObject.has("primaryKeyId")) {
            builderNewBuilder.setPrimaryKeyId(getKeyId(jsonObject.get("primaryKeyId")));
        }
        for (int i = 0; i < asJsonArray.size(); i++) {
            builderNewBuilder.addKey(keyFromJson(asJsonArray.get(i).getAsJsonObject()));
        }
        return builderNewBuilder.build();
    }

    private EncryptedKeyset encryptedKeysetFromJson(JsonObject jsonObject) throws IOException {
        byte[] bArrDecode;
        validateEncryptedKeyset(jsonObject);
        if (this.urlSafeBase64) {
            bArrDecode = Base64.urlSafeDecode(jsonObject.get("encryptedKeyset").getAsString());
        } else {
            bArrDecode = Base64.decode(jsonObject.get("encryptedKeyset").getAsString());
        }
        if (jsonObject.has("keysetInfo")) {
            return EncryptedKeyset.newBuilder().setEncryptedKeyset(ByteString.copyFrom(bArrDecode)).setKeysetInfo(keysetInfoFromJson(jsonObject.getAsJsonObject("keysetInfo"))).build();
        }
        return EncryptedKeyset.newBuilder().setEncryptedKeyset(ByteString.copyFrom(bArrDecode)).build();
    }

    private Keyset.Key keyFromJson(JsonObject jsonObject) throws IOException {
        if (!jsonObject.has("keyData") || !jsonObject.has("status") || !jsonObject.has("keyId") || !jsonObject.has("outputPrefixType")) {
            throw new JsonParseException("invalid key");
        }
        JsonElement jsonElement = jsonObject.get("keyData");
        if (!jsonElement.isJsonObject()) {
            throw new JsonParseException("invalid key: keyData must be an object");
        }
        return Keyset.Key.newBuilder().setStatus(getStatus(jsonObject.get("status").getAsString())).setKeyId(getKeyId(jsonObject.get("keyId"))).setOutputPrefixType(getOutputPrefixType(jsonObject.get("outputPrefixType").getAsString())).setKeyData(keyDataFromJson(jsonElement.getAsJsonObject())).build();
    }

    private static KeysetInfo keysetInfoFromJson(JsonObject jsonObject) throws IOException {
        KeysetInfo.Builder builderNewBuilder = KeysetInfo.newBuilder();
        if (jsonObject.has("primaryKeyId")) {
            builderNewBuilder.setPrimaryKeyId(getKeyId(jsonObject.get("primaryKeyId")));
        }
        if (jsonObject.has("keyInfo")) {
            JsonArray asJsonArray = jsonObject.getAsJsonArray("keyInfo");
            for (int i = 0; i < asJsonArray.size(); i++) {
                builderNewBuilder.addKeyInfo(keyInfoFromJson(asJsonArray.get(i).getAsJsonObject()));
            }
        }
        return builderNewBuilder.build();
    }

    private static KeysetInfo.KeyInfo keyInfoFromJson(JsonObject jsonObject) throws IOException {
        return KeysetInfo.KeyInfo.newBuilder().setStatus(getStatus(jsonObject.get("status").getAsString())).setKeyId(getKeyId(jsonObject.get("keyId"))).setOutputPrefixType(getOutputPrefixType(jsonObject.get("outputPrefixType").getAsString())).setTypeUrl(jsonObject.get("typeUrl").getAsString()).build();
    }

    private KeyData keyDataFromJson(JsonObject jsonObject) {
        byte[] bArrDecode;
        if (!jsonObject.has("typeUrl") || !jsonObject.has("value") || !jsonObject.has("keyMaterialType")) {
            throw new JsonParseException("invalid keyData");
        }
        if (this.urlSafeBase64) {
            bArrDecode = Base64.urlSafeDecode(jsonObject.get("value").getAsString());
        } else {
            bArrDecode = Base64.decode(jsonObject.get("value").getAsString());
        }
        return KeyData.newBuilder().setTypeUrl(jsonObject.get("typeUrl").getAsString()).setValue(ByteString.copyFrom(bArrDecode)).setKeyMaterialType(getKeyMaterialType(jsonObject.get("keyMaterialType").getAsString())).build();
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0037  */
    private static KeyStatusType getStatus(String str) {
        byte b;
        str.hashCode();
        int iHashCode = str.hashCode();
        if (iHashCode != -891611359) {
            if (iHashCode != 478389753) {
                if (iHashCode == 1053567612 && str.equals("DISABLED")) {
                    b = 2;
                } else {
                    b = -1;
                }
            } else if (str.equals("DESTROYED")) {
                b = 1;
            } else {
                b = -1;
            }
        } else if (str.equals("ENABLED")) {
            b = 0;
        } else {
            b = -1;
        }
        if (b == 0) {
            return KeyStatusType.ENABLED;
        }
        if (b == 1) {
            return KeyStatusType.DESTROYED;
        }
        if (b == 2) {
            return KeyStatusType.DISABLED;
        }
        throw new JsonParseException("unknown status: " + str);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:21:0x003a  */
    private static OutputPrefixType getOutputPrefixType(String str) {
        byte b;
        str.hashCode();
        switch (str) {
            case "LEGACY":
                b = 0;
                break;
            case "RAW":
                b = 1;
                break;
            case "TINK":
                b = 2;
                break;
            case "CRUNCHY":
                b = 3;
                break;
            default:
                b = -1;
                break;
        }
        if (b == 0) {
            return OutputPrefixType.LEGACY;
        }
        if (b == 1) {
            return OutputPrefixType.RAW;
        }
        if (b == 2) {
            return OutputPrefixType.TINK;
        }
        if (b == 3) {
            return OutputPrefixType.CRUNCHY;
        }
        throw new JsonParseException("unknown output prefix type: " + str);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:21:0x003a  */
    private static KeyData.KeyMaterialType getKeyMaterialType(String str) {
        byte b;
        str.hashCode();
        switch (str) {
            case "REMOTE":
                b = 0;
                break;
            case "SYMMETRIC":
                b = 1;
                break;
            case "ASYMMETRIC_PRIVATE":
                b = 2;
                break;
            case "ASYMMETRIC_PUBLIC":
                b = 3;
                break;
            default:
                b = -1;
                break;
        }
        if (b == 0) {
            return KeyData.KeyMaterialType.REMOTE;
        }
        if (b == 1) {
            return KeyData.KeyMaterialType.SYMMETRIC;
        }
        if (b == 2) {
            return KeyData.KeyMaterialType.ASYMMETRIC_PRIVATE;
        }
        if (b == 3) {
            return KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC;
        }
        throw new JsonParseException("unknown key material type: " + str);
    }

    private static void validateEncryptedKeyset(JsonObject jsonObject) {
        if (!jsonObject.has("encryptedKeyset")) {
            throw new JsonParseException("invalid encrypted keyset");
        }
    }
}
