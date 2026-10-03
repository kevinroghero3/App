package com.google.crypto.tink;

import com.google.crypto.tink.proto.KeysetInfo;
import java.io.IOException;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes2.dex */
public final class LegacyKeysetSerialization {
    public static KeysetHandle parseKeysetWithoutSecret(KeysetReader keysetReader) throws GeneralSecurityException, IOException {
        return KeysetHandle.readNoSecret(keysetReader);
    }

    public static KeysetHandle parseKeyset(KeysetReader keysetReader, SecretKeyAccess secretKeyAccess) throws GeneralSecurityException, IOException {
        if (secretKeyAccess == null) {
            throw new NullPointerException("SecretKeyAccess cannot be null");
        }
        return CleartextKeysetHandle.read(keysetReader);
    }

    public static KeysetHandle parseEncryptedKeyset(KeysetReader keysetReader, Aead aead, byte[] bArr) throws GeneralSecurityException, IOException {
        return KeysetHandle.readWithAssociatedData(keysetReader, aead, bArr);
    }

    public static void serializeKeysetWithoutSecret(KeysetHandle keysetHandle, KeysetWriter keysetWriter) throws GeneralSecurityException, IOException {
        keysetHandle.writeNoSecret(keysetWriter);
    }

    public static void serializeKeyset(KeysetHandle keysetHandle, KeysetWriter keysetWriter, SecretKeyAccess secretKeyAccess) throws IOException {
        if (secretKeyAccess == null) {
            throw new NullPointerException("SecretKeyAccess cannot be null");
        }
        CleartextKeysetHandle.write(keysetHandle, keysetWriter);
    }

    public static void serializeEncryptedKeyset(KeysetHandle keysetHandle, KeysetWriter keysetWriter, Aead aead, byte[] bArr) throws GeneralSecurityException, IOException {
        keysetHandle.writeWithAssociatedData(keysetWriter, aead, bArr);
    }

    public static KeysetInfo getKeysetInfo(KeysetHandle keysetHandle) {
        return keysetHandle.getKeysetInfo();
    }

    private LegacyKeysetSerialization() {
    }
}
