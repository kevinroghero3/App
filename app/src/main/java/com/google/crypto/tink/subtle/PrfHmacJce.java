package com.google.crypto.tink.subtle;

import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.prf.HmacPrfKey;
import com.google.crypto.tink.prf.Prf;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes3.dex */
@Immutable
public final class PrfHmacJce implements Prf {
    public static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_REQUIRES_BORINGCRYPTO;
    static final int MIN_KEY_SIZE_IN_BYTES = 16;
    private final String algorithm;
    private final Key key;
    private final ThreadLocal<Mac> localMac;
    private final int maxOutputLength;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:29:0x0065  */
    public PrfHmacJce(String str, Key key) throws GeneralSecurityException {
        byte b;
        ThreadLocal<Mac> threadLocal = new ThreadLocal<Mac>() { // from class: com.google.crypto.tink.subtle.PrfHmacJce.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // java.lang.ThreadLocal
            public Mac initialValue() {
                try {
                    Mac engineFactory = EngineFactory.MAC.getInstance(PrfHmacJce.this.algorithm);
                    engineFactory.init(PrfHmacJce.this.key);
                    return engineFactory;
                } catch (GeneralSecurityException e) {
                    throw new IllegalStateException(e);
                }
            }
        };
        this.localMac = threadLocal;
        if (!FIPS.isCompatible()) {
            throw new GeneralSecurityException("Can not use HMAC in FIPS-mode, as BoringCrypto module is not available.");
        }
        this.algorithm = str;
        this.key = key;
        if (key.getEncoded().length < 16) {
            throw new InvalidAlgorithmParameterException("key size too small, need at least 16 bytes");
        }
        str.hashCode();
        switch (str) {
            case "HMACSHA1":
                b = 0;
                break;
            case "HMACSHA224":
                b = 1;
                break;
            case "HMACSHA256":
                b = 2;
                break;
            case "HMACSHA384":
                b = 3;
                break;
            case "HMACSHA512":
                b = 4;
                break;
            default:
                b = -1;
                break;
        }
        if (b == 0) {
            this.maxOutputLength = 20;
        } else if (b == 1) {
            this.maxOutputLength = 28;
        } else if (b == 2) {
            this.maxOutputLength = 32;
        } else if (b == 3) {
            this.maxOutputLength = 48;
        } else if (b == 4) {
            this.maxOutputLength = 64;
        } else {
            throw new NoSuchAlgorithmException("unknown Hmac algorithm: " + str);
        }
        threadLocal.get();
    }

    public static Prf create(HmacPrfKey hmacPrfKey) throws GeneralSecurityException {
        return new PrfHmacJce("HMAC" + hmacPrfKey.getParameters().getHashType(), new SecretKeySpec(hmacPrfKey.getKeyBytes().toByteArray(InsecureSecretKeyAccess.get()), "HMAC"));
    }

    @Override // com.google.crypto.tink.prf.Prf
    public byte[] compute(byte[] bArr, int i) throws GeneralSecurityException {
        if (i > this.maxOutputLength) {
            throw new InvalidAlgorithmParameterException("tag size too big");
        }
        this.localMac.get().update(bArr);
        return Arrays.copyOf(this.localMac.get().doFinal(), i);
    }

    public int getMaxOutputLength() {
        return this.maxOutputLength;
    }
}
