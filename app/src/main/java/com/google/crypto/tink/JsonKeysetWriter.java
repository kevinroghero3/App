package com.google.crypto.tink;

import com.google.crypto.tink.proto.EncryptedKeyset;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.proto.KeysetInfo;
import com.google.crypto.tink.subtle.Base64;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import io.sentry.instrumentation.file.SentryFileOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.util.Iterator;
import org.apache.commons.lang3.CharEncoding;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public final class JsonKeysetWriter implements KeysetWriter {
    private static final Charset UTF_8 = Charset.forName(CharEncoding.UTF_8);
    private final OutputStream outputStream;

    private long toUnsignedLong(int i) {
        return ((long) i) & 4294967295L;
    }

    private JsonKeysetWriter(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public static KeysetWriter withOutputStream(OutputStream outputStream) {
        return new JsonKeysetWriter(outputStream);
    }

    @Deprecated
    public static KeysetWriter withFile(File file) throws IOException {
        return withOutputStream(SentryFileOutputStream.Factory.create(new FileOutputStream(file), file));
    }

    @Deprecated
    public static KeysetWriter withPath(String str) throws IOException {
        File file = new File(str);
        return withOutputStream(SentryFileOutputStream.Factory.create(new FileOutputStream(file), file));
    }

    @Deprecated
    public static KeysetWriter withPath(Path path) throws IOException {
        File file = path.toFile();
        return withOutputStream(SentryFileOutputStream.Factory.create(new FileOutputStream(file), file));
    }

    @Override // com.google.crypto.tink.KeysetWriter
    public void write(Keyset keyset) throws IOException {
        try {
            try {
                OutputStream outputStream = this.outputStream;
                String string = toJson(keyset).toString();
                Charset charset = UTF_8;
                outputStream.write(string.getBytes(charset));
                this.outputStream.write(System.lineSeparator().getBytes(charset));
                this.outputStream.close();
            } catch (JsonParseException e) {
                throw new IOException(e);
            }
        } catch (Throwable th) {
            this.outputStream.close();
            throw th;
        }
    }

    @Override // com.google.crypto.tink.KeysetWriter
    public void write(EncryptedKeyset encryptedKeyset) throws IOException {
        OutputStream outputStream = this.outputStream;
        String string = toJson(encryptedKeyset).toString();
        Charset charset = UTF_8;
        outputStream.write(string.getBytes(charset));
        this.outputStream.write(System.lineSeparator().getBytes(charset));
        this.outputStream.close();
    }

    private JsonObject toJson(Keyset keyset) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("primaryKeyId", Long.valueOf(toUnsignedLong(keyset.getPrimaryKeyId())));
        JsonArray jsonArray = new JsonArray();
        Iterator<Keyset.Key> it2 = keyset.getKeyList().iterator();
        while (it2.hasNext()) {
            jsonArray.add(toJson(it2.next()));
        }
        jsonObject.add("key", jsonArray);
        return jsonObject;
    }

    private JsonObject toJson(Keyset.Key key) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("keyData", toJson(key.getKeyData()));
        jsonObject.addProperty("status", key.getStatus().name());
        jsonObject.addProperty("keyId", Long.valueOf(toUnsignedLong(key.getKeyId())));
        jsonObject.addProperty("outputPrefixType", key.getOutputPrefixType().name());
        return jsonObject;
    }

    private JsonObject toJson(KeyData keyData) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("typeUrl", keyData.getTypeUrl());
        jsonObject.addProperty("value", Base64.encode(keyData.getValue().toByteArray()));
        jsonObject.addProperty("keyMaterialType", keyData.getKeyMaterialType().name());
        return jsonObject;
    }

    private JsonObject toJson(EncryptedKeyset encryptedKeyset) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("encryptedKeyset", Base64.encode(encryptedKeyset.getEncryptedKeyset().toByteArray()));
        jsonObject.add("keysetInfo", toJson(encryptedKeyset.getKeysetInfo()));
        return jsonObject;
    }

    private JsonObject toJson(KeysetInfo keysetInfo) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("primaryKeyId", Long.valueOf(toUnsignedLong(keysetInfo.getPrimaryKeyId())));
        JsonArray jsonArray = new JsonArray();
        Iterator<KeysetInfo.KeyInfo> it2 = keysetInfo.getKeyInfoList().iterator();
        while (it2.hasNext()) {
            jsonArray.add(toJson(it2.next()));
        }
        jsonObject.add("keyInfo", jsonArray);
        return jsonObject;
    }

    private JsonObject toJson(KeysetInfo.KeyInfo keyInfo) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("typeUrl", keyInfo.getTypeUrl());
        jsonObject.addProperty("status", keyInfo.getStatus().name());
        jsonObject.addProperty("keyId", Long.valueOf(toUnsignedLong(keyInfo.getKeyId())));
        jsonObject.addProperty("outputPrefixType", keyInfo.getOutputPrefixType().name());
        return jsonObject;
    }
}
