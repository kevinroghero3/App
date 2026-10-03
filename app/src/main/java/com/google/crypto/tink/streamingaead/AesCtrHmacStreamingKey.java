package com.google.crypto.tink.streamingaead;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.util.SecretBytes;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes3.dex */
public final class AesCtrHmacStreamingKey extends StreamingAeadKey {
    private final SecretBytes initialKeymaterial;
    private final AesCtrHmacStreamingParameters parameters;

    private AesCtrHmacStreamingKey(AesCtrHmacStreamingParameters aesCtrHmacStreamingParameters, SecretBytes secretBytes) {
        this.parameters = aesCtrHmacStreamingParameters;
        this.initialKeymaterial = secretBytes;
    }

    public static AesCtrHmacStreamingKey create(AesCtrHmacStreamingParameters aesCtrHmacStreamingParameters, SecretBytes secretBytes) throws GeneralSecurityException {
        if (aesCtrHmacStreamingParameters.getKeySizeBytes() != secretBytes.size()) {
            throw new GeneralSecurityException("Key size mismatch");
        }
        return new AesCtrHmacStreamingKey(aesCtrHmacStreamingParameters, secretBytes);
    }

    public SecretBytes getInitialKeyMaterial() {
        return this.initialKeymaterial;
    }

    @Override // com.google.crypto.tink.streamingaead.StreamingAeadKey, com.google.crypto.tink.Key
    public AesCtrHmacStreamingParameters getParameters() {
        return this.parameters;
    }

    @Override // com.google.crypto.tink.Key
    public boolean equalsKey(Key key) {
        if (!(key instanceof AesCtrHmacStreamingKey)) {
            return false;
        }
        AesCtrHmacStreamingKey aesCtrHmacStreamingKey = (AesCtrHmacStreamingKey) key;
        return aesCtrHmacStreamingKey.parameters.equals(this.parameters) && aesCtrHmacStreamingKey.initialKeymaterial.equalsSecretBytes(this.initialKeymaterial);
    }
}
