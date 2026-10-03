package com.google.crypto.tink.prf.internal;

import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.mac.internal.AesUtil;
import com.google.crypto.tink.prf.AesCmacPrfKey;
import com.google.crypto.tink.prf.Prf;
import com.google.crypto.tink.subtle.Bytes;
import com.google.crypto.tink.subtle.EngineFactory;
import com.google.crypto.tink.subtle.Validators;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes2.dex */
@Immutable
public final class PrfAesCmac implements Prf {
    public static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_NOT_FIPS;
    private static final ThreadLocal<Cipher> localAesCipher = new ThreadLocal<Cipher>() { // from class: com.google.crypto.tink.prf.internal.PrfAesCmac.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public Cipher initialValue() {
            try {
                return EngineFactory.CIPHER.getInstance("AES/ECB/NoPadding");
            } catch (GeneralSecurityException e) {
                throw new IllegalStateException(e);
            }
        }
    };
    private final SecretKey keySpec;
    private byte[] subKey1;
    private byte[] subKey2;

    private static Cipher instance() throws GeneralSecurityException {
        if (!FIPS.isCompatible()) {
            throw new GeneralSecurityException("Can not use AES-CMAC in FIPS-mode.");
        }
        return localAesCipher.get();
    }

    private PrfAesCmac(byte[] bArr) throws GeneralSecurityException {
        Validators.validateAesKeySize(bArr.length);
        this.keySpec = new SecretKeySpec(bArr, "AES");
        generateSubKeys();
    }

    public static Prf create(AesCmacPrfKey aesCmacPrfKey) throws GeneralSecurityException {
        return new PrfAesCmac(aesCmacPrfKey.getKeyBytes().toByteArray(InsecureSecretKeyAccess.get()));
    }

    static int calcN(int i) {
        if (i == 0) {
            return 1;
        }
        return ((i - 1) / 16) + 1;
    }

    private static void xorBlock(byte[] bArr, byte[] bArr2, int i, byte[] bArr3) {
        for (int i2 = 0; i2 < 16; i2++) {
            bArr3[i2] = (byte) (bArr[i2] ^ bArr2[i2 + i]);
        }
    }

    @Override // com.google.crypto.tink.prf.Prf
    public byte[] compute(byte[] bArr, int i) throws GeneralSecurityException {
        byte[] bArrXor;
        if (i > 16) {
            throw new InvalidAlgorithmParameterException("outputLength too large, max is 16 bytes");
        }
        Cipher cipherInstance = instance();
        cipherInstance.init(1, this.keySpec);
        int iCalcN = calcN(bArr.length);
        if (iCalcN * 16 == bArr.length) {
            bArrXor = Bytes.xor(bArr, (iCalcN - 1) * 16, this.subKey1, 0, 16);
        } else {
            bArrXor = Bytes.xor(AesUtil.cmacPad(Arrays.copyOfRange(bArr, (iCalcN - 1) * 16, bArr.length)), this.subKey2);
        }
        byte[] bArr2 = new byte[16];
        byte[] bArr3 = new byte[16];
        for (int i2 = 0; i2 < iCalcN - 1; i2++) {
            xorBlock(bArr2, bArr, i2 * 16, bArr3);
            if (cipherInstance.doFinal(bArr3, 0, 16, bArr2) != 16) {
                throw new IllegalStateException("Cipher didn't write full block");
            }
        }
        xorBlock(bArr2, bArrXor, 0, bArr3);
        if (cipherInstance.doFinal(bArr3, 0, 16, bArr2) == 16) {
            return 16 == i ? bArr2 : Arrays.copyOf(bArr2, i);
        }
        throw new IllegalStateException("Cipher didn't write full block");
    }

    private void generateSubKeys() throws GeneralSecurityException {
        Cipher cipherInstance = instance();
        cipherInstance.init(1, this.keySpec);
        byte[] bArrDbl = AesUtil.dbl(cipherInstance.doFinal(new byte[16]));
        this.subKey1 = bArrDbl;
        this.subKey2 = AesUtil.dbl(bArrDbl);
    }
}
