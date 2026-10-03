package com.google.crypto.tink.hybrid.internal;

import com.google.crypto.tink.subtle.EngineFactory;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes2.dex */
@Immutable
final class HkdfHpkeKdf implements HpkeKdf {
    private final String macAlgorithm;

    HkdfHpkeKdf(String str) {
        this.macAlgorithm = str;
    }

    private byte[] extract(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        Mac engineFactory = EngineFactory.MAC.getInstance(this.macAlgorithm);
        if (bArr2 == null || bArr2.length == 0) {
            engineFactory.init(new SecretKeySpec(new byte[engineFactory.getMacLength()], this.macAlgorithm));
        } else {
            engineFactory.init(new SecretKeySpec(bArr2, this.macAlgorithm));
        }
        return engineFactory.doFinal(bArr);
    }

    private byte[] expand(byte[] bArr, byte[] bArr2, int i) throws GeneralSecurityException {
        Mac engineFactory = EngineFactory.MAC.getInstance(this.macAlgorithm);
        if (i > engineFactory.getMacLength() * 255) {
            throw new GeneralSecurityException("size too large");
        }
        byte[] bArr3 = new byte[i];
        engineFactory.init(new SecretKeySpec(bArr, this.macAlgorithm));
        byte[] bArrDoFinal = new byte[0];
        int i2 = 1;
        int length = 0;
        while (true) {
            engineFactory.update(bArrDoFinal);
            engineFactory.update(bArr2);
            engineFactory.update((byte) i2);
            bArrDoFinal = engineFactory.doFinal();
            if (bArrDoFinal.length + length < i) {
                System.arraycopy(bArrDoFinal, 0, bArr3, length, bArrDoFinal.length);
                length += bArrDoFinal.length;
                i2++;
            } else {
                System.arraycopy(bArrDoFinal, 0, bArr3, length, i - length);
                return bArr3;
            }
        }
    }

    @Override // com.google.crypto.tink.hybrid.internal.HpkeKdf
    public byte[] labeledExtract(byte[] bArr, byte[] bArr2, String str, byte[] bArr3) throws GeneralSecurityException {
        return extract(HpkeUtil.labelIkm(str, bArr2, bArr3), bArr);
    }

    @Override // com.google.crypto.tink.hybrid.internal.HpkeKdf
    public byte[] labeledExpand(byte[] bArr, byte[] bArr2, String str, byte[] bArr3, int i) throws GeneralSecurityException {
        return expand(bArr, HpkeUtil.labelInfo(str, bArr2, bArr3, i), i);
    }

    @Override // com.google.crypto.tink.hybrid.internal.HpkeKdf
    public byte[] extractAndExpand(byte[] bArr, byte[] bArr2, String str, byte[] bArr3, String str2, byte[] bArr4, int i) throws GeneralSecurityException {
        return expand(extract(HpkeUtil.labelIkm(str, bArr2, bArr4), bArr), HpkeUtil.labelInfo(str2, bArr3, bArr4, i), i);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0039  */
    @Override // com.google.crypto.tink.hybrid.internal.HpkeKdf
    public byte[] getKdfId() throws GeneralSecurityException {
        byte b;
        String str = this.macAlgorithm;
        str.hashCode();
        int iHashCode = str.hashCode();
        if (iHashCode != 984523022) {
            if (iHashCode != 984524074) {
                if (iHashCode == 984525777 && str.equals("HmacSha512")) {
                    b = 2;
                } else {
                    b = -1;
                }
            } else if (str.equals("HmacSha384")) {
                b = 1;
            } else {
                b = -1;
            }
        } else if (str.equals("HmacSha256")) {
            b = 0;
        } else {
            b = -1;
        }
        if (b == 0) {
            return HpkeUtil.HKDF_SHA256_KDF_ID;
        }
        if (b == 1) {
            return HpkeUtil.HKDF_SHA384_KDF_ID;
        }
        if (b == 2) {
            return HpkeUtil.HKDF_SHA512_KDF_ID;
        }
        throw new GeneralSecurityException("Could not determine HPKE KDF ID");
    }

    int getMacLength() throws GeneralSecurityException {
        return Mac.getInstance(this.macAlgorithm).getMacLength();
    }
}
