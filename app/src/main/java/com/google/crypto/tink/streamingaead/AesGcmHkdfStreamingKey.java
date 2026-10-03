package com.google.crypto.tink.streamingaead;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.util.SecretBytes;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes3.dex */
public final class AesGcmHkdfStreamingKey extends StreamingAeadKey {
    private final SecretBytes initialKeymaterial;
    private final AesGcmHkdfStreamingParameters parameters;

    private AesGcmHkdfStreamingKey(AesGcmHkdfStreamingParameters aesGcmHkdfStreamingParameters, SecretBytes secretBytes) {
        this.parameters = aesGcmHkdfStreamingParameters;
        this.initialKeymaterial = secretBytes;
    }

    public static AesGcmHkdfStreamingKey create(AesGcmHkdfStreamingParameters aesGcmHkdfStreamingParameters, SecretBytes secretBytes) throws GeneralSecurityException {
        if (aesGcmHkdfStreamingParameters.getKeySizeBytes() != secretBytes.size()) {
            throw new GeneralSecurityException("Key size mismatch");
        }
        return new AesGcmHkdfStreamingKey(aesGcmHkdfStreamingParameters, secretBytes);
    }

    public SecretBytes getInitialKeyMaterial() {
        return this.initialKeymaterial;
    }

    @Override // com.google.crypto.tink.streamingaead.StreamingAeadKey, com.google.crypto.tink.Key
    public AesGcmHkdfStreamingParameters getParameters() {
        return this.parameters;
    }

    @Override // com.google.crypto.tink.Key
    public boolean equalsKey(Key key) {
        if (!(key instanceof AesGcmHkdfStreamingKey)) {
            return false;
        }
        AesGcmHkdfStreamingKey aesGcmHkdfStreamingKey = (AesGcmHkdfStreamingKey) key;
        return aesGcmHkdfStreamingKey.parameters.equals(this.parameters) && aesGcmHkdfStreamingKey.initialKeymaterial.equalsSecretBytes(this.initialKeymaterial);
    }
}
