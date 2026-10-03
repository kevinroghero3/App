package com.google.crypto.tink.subtle;

import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.Mac;
import com.google.crypto.tink.mac.AesCmacKey;
import com.google.crypto.tink.mac.AesCmacParameters;
import com.google.crypto.tink.mac.HmacKey;
import com.google.crypto.tink.mac.HmacParameters;
import com.google.crypto.tink.prf.AesCmacPrfKey;
import com.google.crypto.tink.prf.AesCmacPrfParameters;
import com.google.crypto.tink.prf.Prf;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes3.dex */
@Immutable
public class PrfMac implements Mac {
    static final int MIN_TAG_SIZE_IN_BYTES = 10;
    private static final byte[] formatVersion = {0};
    private final byte[] outputPrefix;
    private final byte[] plaintextLegacySuffix;
    private final int tagSize;
    private final Prf wrappedPrf;

    public PrfMac(Prf prf, int i) throws GeneralSecurityException {
        this.wrappedPrf = prf;
        this.tagSize = i;
        this.outputPrefix = new byte[0];
        this.plaintextLegacySuffix = new byte[0];
        if (i < 10) {
            throw new InvalidAlgorithmParameterException("tag size too small, need at least 10 bytes");
        }
        prf.compute(new byte[0], i);
    }

    private PrfMac(AesCmacKey aesCmacKey) throws GeneralSecurityException {
        this.wrappedPrf = createPrf(aesCmacKey);
        this.tagSize = aesCmacKey.getParameters().getCryptographicTagSizeBytes();
        this.outputPrefix = aesCmacKey.getOutputPrefix().toByteArray();
        if (aesCmacKey.getParameters().getVariant().equals(AesCmacParameters.Variant.LEGACY)) {
            byte[] bArr = formatVersion;
            this.plaintextLegacySuffix = Arrays.copyOf(bArr, bArr.length);
        } else {
            this.plaintextLegacySuffix = new byte[0];
        }
    }

    private PrfMac(HmacKey hmacKey) throws GeneralSecurityException {
        this.wrappedPrf = new PrfHmacJce("HMAC" + hmacKey.getParameters().getHashType(), new SecretKeySpec(hmacKey.getKeyBytes().toByteArray(InsecureSecretKeyAccess.get()), "HMAC"));
        this.tagSize = hmacKey.getParameters().getCryptographicTagSizeBytes();
        this.outputPrefix = hmacKey.getOutputPrefix().toByteArray();
        if (hmacKey.getParameters().getVariant().equals(HmacParameters.Variant.LEGACY)) {
            byte[] bArr = formatVersion;
            this.plaintextLegacySuffix = Arrays.copyOf(bArr, bArr.length);
        } else {
            this.plaintextLegacySuffix = new byte[0];
        }
    }

    public static Mac create(AesCmacKey aesCmacKey) throws GeneralSecurityException {
        return new PrfMac(aesCmacKey);
    }

    public static Mac create(HmacKey hmacKey) throws GeneralSecurityException {
        return new PrfMac(hmacKey);
    }

    @Override // com.google.crypto.tink.Mac
    public byte[] computeMac(byte[] bArr) throws GeneralSecurityException {
        byte[] bArr2 = this.plaintextLegacySuffix;
        if (bArr2.length > 0) {
            return Bytes.concat(this.outputPrefix, this.wrappedPrf.compute(Bytes.concat(bArr, bArr2), this.tagSize));
        }
        return Bytes.concat(this.outputPrefix, this.wrappedPrf.compute(bArr, this.tagSize));
    }

    @Override // com.google.crypto.tink.Mac
    public void verifyMac(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (!Bytes.equal(computeMac(bArr2), bArr)) {
            throw new GeneralSecurityException("invalid MAC");
        }
    }

    private static Prf createPrf(AesCmacKey aesCmacKey) throws GeneralSecurityException {
        return PrfAesCmac.create(AesCmacPrfKey.create(AesCmacPrfParameters.create(aesCmacKey.getParameters().getKeySizeBytes()), aesCmacKey.getAesKey()));
    }
}
