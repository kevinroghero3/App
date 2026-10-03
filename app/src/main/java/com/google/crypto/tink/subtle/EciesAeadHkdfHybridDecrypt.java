package com.google.crypto.tink.subtle;

import com.google.crypto.tink.HybridDecrypt;
import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.hybrid.EciesPrivateKey;
import com.google.crypto.tink.hybrid.internal.EciesDemHelper;
import com.google.crypto.tink.internal.BigIntegerEncoding;
import com.google.crypto.tink.internal.Util;
import java.security.GeneralSecurityException;
import java.security.interfaces.ECPrivateKey;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class EciesAeadHkdfHybridDecrypt implements HybridDecrypt {
    private final EciesDemHelper.Dem dem;
    private final EllipticCurves.PointFormatType ecPointFormat;
    private final String hkdfHmacAlgo;
    private final byte[] hkdfSalt;
    private final byte[] outputPrefix;
    private final EciesHkdfRecipientKem recipientKem;
    private final ECPrivateKey recipientPrivateKey;

    private EciesAeadHkdfHybridDecrypt(ECPrivateKey eCPrivateKey, byte[] bArr, String str, EllipticCurves.PointFormatType pointFormatType, EciesDemHelper.Dem dem, byte[] bArr2) {
        this.recipientPrivateKey = eCPrivateKey;
        this.recipientKem = new EciesHkdfRecipientKem(eCPrivateKey);
        this.hkdfSalt = bArr;
        this.hkdfHmacAlgo = str;
        this.ecPointFormat = pointFormatType;
        this.dem = dem;
        this.outputPrefix = bArr2;
    }

    public static HybridDecrypt create(EciesPrivateKey eciesPrivateKey) throws GeneralSecurityException {
        ECPrivateKey ecPrivateKey = EllipticCurves.getEcPrivateKey((EllipticCurves.CurveType) EciesAeadHkdfHybridEncrypt.CURVE_TYPE_CONVERTER.toProtoEnum(eciesPrivateKey.getParameters().getCurveType()), BigIntegerEncoding.toBigEndianBytes(eciesPrivateKey.getNistPrivateKeyValue().getBigInteger(InsecureSecretKeyAccess.get())));
        byte[] byteArray = new byte[0];
        if (eciesPrivateKey.getParameters().getSalt() != null) {
            byteArray = eciesPrivateKey.getParameters().getSalt().toByteArray();
        }
        return new EciesAeadHkdfHybridDecrypt(ecPrivateKey, byteArray, EciesAeadHkdfHybridEncrypt.toHmacAlgo(eciesPrivateKey.getParameters().getHashType()), (EllipticCurves.PointFormatType) EciesAeadHkdfHybridEncrypt.POINT_FORMAT_TYPE_CONVERTER.toProtoEnum(eciesPrivateKey.getParameters().getNistCurvePointFormat()), EciesDemHelper.getDem(eciesPrivateKey.getParameters()), eciesPrivateKey.getOutputPrefix().toByteArray());
    }

    @Override // com.google.crypto.tink.HybridDecrypt
    public byte[] decrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (!Util.isPrefix(this.outputPrefix, bArr)) {
            throw new GeneralSecurityException("Invalid ciphertext (output prefix mismatch)");
        }
        int length = this.outputPrefix.length;
        int iEncodingSizeInBytes = EllipticCurves.encodingSizeInBytes(this.recipientPrivateKey.getParams().getCurve(), this.ecPointFormat) + length;
        if (bArr.length < iEncodingSizeInBytes) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        return this.dem.decrypt(this.recipientKem.generateKey(Arrays.copyOfRange(bArr, length, iEncodingSizeInBytes), this.hkdfHmacAlgo, this.hkdfSalt, bArr2, this.dem.getSymmetricKeySizeInBytes(), this.ecPointFormat), bArr, iEncodingSizeInBytes);
    }
}
