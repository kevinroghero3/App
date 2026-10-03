package com.google.crypto.tink.mac.internal;

import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.internal.Util;
import com.google.crypto.tink.mac.AesCmacKey;
import com.google.crypto.tink.mac.AesCmacParameters;
import com.google.crypto.tink.mac.ChunkedMac;
import com.google.crypto.tink.mac.ChunkedMacComputation;
import com.google.crypto.tink.mac.ChunkedMacVerification;
import com.google.crypto.tink.subtle.Bytes;
import com.google.errorprone.annotations.Immutable;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes2.dex */
@Immutable
public final class ChunkedAesCmacConscrypt implements ChunkedMac {
    private static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_NOT_FIPS;
    private final Provider conscrypt;
    private final byte[] outputPrefix;
    private final AesCmacParameters parameters;
    private final SecretKeySpec secretKeySpec;

    private static SecretKeySpec toSecretKeySpec(AesCmacKey aesCmacKey) {
        return new SecretKeySpec(aesCmacKey.getAesKey().toByteArray(InsecureSecretKeyAccess.get()), "AES");
    }

    private ChunkedAesCmacConscrypt(AesCmacKey aesCmacKey, Provider provider) throws GeneralSecurityException {
        if (provider == null) {
            throw new IllegalArgumentException("conscrypt is null");
        }
        if (!FIPS.isCompatible()) {
            throw new GeneralSecurityException("Cannot use AES-CMAC in FIPS-mode.");
        }
        try {
            Mac.getInstance("AESCMAC", provider);
            this.conscrypt = provider;
            this.outputPrefix = aesCmacKey.getOutputPrefix().toByteArray();
            this.parameters = aesCmacKey.getParameters();
            this.secretKeySpec = toSecretKeySpec(aesCmacKey);
        } catch (NoSuchAlgorithmException e) {
            throw new GeneralSecurityException("AES-CMAC not available.", e);
        }
    }

    /* JADX INFO: loaded from: classes5.dex */
    static final class AesCmacComputation implements ChunkedMacComputation {
        private static final byte[] legacyFormatVersion = {0};
        private final Mac aesCmac;
        private boolean finalized;
        private final byte[] outputPrefix;
        private final AesCmacParameters parameters;

        private AesCmacComputation(SecretKeySpec secretKeySpec, AesCmacParameters aesCmacParameters, byte[] bArr, Provider provider) throws GeneralSecurityException {
            this.finalized = false;
            this.parameters = aesCmacParameters;
            this.outputPrefix = bArr;
            Mac mac = Mac.getInstance("AESCMAC", provider);
            this.aesCmac = mac;
            mac.init(secretKeySpec);
        }

        @Override // com.google.crypto.tink.mac.ChunkedMacComputation
        public void update(ByteBuffer byteBuffer) {
            if (this.finalized) {
                throw new IllegalStateException("Cannot update after computing the MAC tag. Please create a new object.");
            }
            this.aesCmac.update(byteBuffer);
        }

        @Override // com.google.crypto.tink.mac.ChunkedMacComputation
        public byte[] computeMac() throws GeneralSecurityException {
            if (this.finalized) {
                throw new IllegalStateException("Cannot compute after computing the MAC tag. Please create a new object.");
            }
            this.finalized = true;
            if (this.parameters.getVariant() == AesCmacParameters.Variant.LEGACY) {
                this.aesCmac.update(legacyFormatVersion);
            }
            return Bytes.concat(this.outputPrefix, Arrays.copyOf(this.aesCmac.doFinal(), this.parameters.getCryptographicTagSizeBytes()));
        }
    }

    @Override // com.google.crypto.tink.mac.ChunkedMac
    public ChunkedMacComputation createComputation() throws GeneralSecurityException {
        return new AesCmacComputation(this.secretKeySpec, this.parameters, this.outputPrefix, this.conscrypt);
    }

    @Override // com.google.crypto.tink.mac.ChunkedMac
    public ChunkedMacVerification createVerification(byte[] bArr) throws GeneralSecurityException {
        if (!Util.isPrefix(this.outputPrefix, bArr)) {
            throw new GeneralSecurityException("Wrong tag prefix");
        }
        return ChunkedMacVerificationFromComputation.create(createComputation(), bArr);
    }

    public static ChunkedMac create(AesCmacKey aesCmacKey, Provider provider) throws GeneralSecurityException {
        return new ChunkedAesCmacConscrypt(aesCmacKey, provider);
    }
}
