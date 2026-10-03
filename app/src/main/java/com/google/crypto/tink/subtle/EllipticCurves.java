package com.google.crypto.tink.subtle;

import com.google.crypto.tink.internal.BigIntegerEncoding;
import com.google.crypto.tink.internal.EllipticCurvesUtil;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPrivateKeySpec;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.EllipticCurve;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import javax.crypto.KeyAgreement;

/* JADX INFO: loaded from: classes3.dex */
public final class EllipticCurves {

    public enum CurveType {
        NIST_P256,
        NIST_P384,
        NIST_P521
    }

    public enum EcdsaEncoding {
        IEEE_P1363,
        DER
    }

    public enum PointFormatType {
        UNCOMPRESSED,
        COMPRESSED,
        DO_NOT_USE_CRUNCHY_UNCOMPRESSED
    }

    public static ECParameterSpec getNistP256Params() {
        return EllipticCurvesUtil.NIST_P256_PARAMS;
    }

    public static ECParameterSpec getNistP384Params() {
        return EllipticCurvesUtil.NIST_P384_PARAMS;
    }

    public static ECParameterSpec getNistP521Params() {
        return EllipticCurvesUtil.NIST_P521_PARAMS;
    }

    static void checkPublicKey(ECPublicKey eCPublicKey) throws GeneralSecurityException {
        EllipticCurvesUtil.checkPointOnCurve(eCPublicKey.getW(), eCPublicKey.getParams().getCurve());
    }

    public static boolean isNistEcParameterSpec(ECParameterSpec eCParameterSpec) {
        return EllipticCurvesUtil.isNistEcParameterSpec(eCParameterSpec);
    }

    public static boolean isSameEcParameterSpec(ECParameterSpec eCParameterSpec, ECParameterSpec eCParameterSpec2) {
        return EllipticCurvesUtil.isSameEcParameterSpec(eCParameterSpec, eCParameterSpec2);
    }

    public static void validatePublicKey(ECPublicKey eCPublicKey, ECPrivateKey eCPrivateKey) throws GeneralSecurityException {
        validatePublicKeySpec(eCPublicKey, eCPrivateKey);
        EllipticCurvesUtil.checkPointOnCurve(eCPublicKey.getW(), eCPrivateKey.getParams().getCurve());
    }

    static void validatePublicKeySpec(ECPublicKey eCPublicKey, ECPrivateKey eCPrivateKey) throws GeneralSecurityException {
        try {
            if (isSameEcParameterSpec(eCPublicKey.getParams(), eCPrivateKey.getParams())) {
            } else {
                throw new GeneralSecurityException("invalid public key spec");
            }
        } catch (IllegalArgumentException | NullPointerException e) {
            throw new GeneralSecurityException(e);
        }
    }

    public static BigInteger getModulus(EllipticCurve ellipticCurve) throws GeneralSecurityException {
        return EllipticCurvesUtil.getModulus(ellipticCurve);
    }

    public static int fieldSizeInBits(EllipticCurve ellipticCurve) throws GeneralSecurityException {
        return getModulus(ellipticCurve).subtract(BigInteger.ONE).bitLength();
    }

    public static int fieldSizeInBytes(EllipticCurve ellipticCurve) throws GeneralSecurityException {
        return (fieldSizeInBits(ellipticCurve) + 7) / 8;
    }

    private static BigInteger modSqrt(BigInteger bigInteger, BigInteger bigInteger2) throws GeneralSecurityException {
        BigInteger bigIntegerModPow;
        if (bigInteger2.signum() != 1) {
            throw new InvalidAlgorithmParameterException("p must be positive");
        }
        BigInteger bigIntegerMod = bigInteger.mod(bigInteger2);
        BigInteger bigInteger3 = BigInteger.ZERO;
        if (bigIntegerMod.equals(bigInteger3)) {
            return bigInteger3;
        }
        int i = 0;
        if (bigInteger2.testBit(0) && bigInteger2.testBit(1)) {
            bigIntegerModPow = bigIntegerMod.modPow(bigInteger2.add(BigInteger.ONE).shiftRight(2), bigInteger2);
        } else if (bigInteger2.testBit(0) && !bigInteger2.testBit(1)) {
            BigInteger bigIntegerAdd = BigInteger.ONE;
            BigInteger bigIntegerShiftRight = bigInteger2.subtract(bigIntegerAdd).shiftRight(1);
            while (true) {
                BigInteger bigIntegerMod2 = bigIntegerAdd.multiply(bigIntegerAdd).subtract(bigIntegerMod).mod(bigInteger2);
                if (bigIntegerMod2.equals(BigInteger.ZERO)) {
                    return bigIntegerAdd;
                }
                BigInteger bigIntegerModPow2 = bigIntegerMod2.modPow(bigIntegerShiftRight, bigInteger2);
                BigInteger bigIntegerMod3 = BigInteger.ONE;
                if (!bigIntegerModPow2.add(bigIntegerMod3).equals(bigInteger2)) {
                    if (!bigIntegerModPow2.equals(bigIntegerMod3)) {
                        throw new InvalidAlgorithmParameterException("p is not prime");
                    }
                    bigIntegerAdd = bigIntegerAdd.add(bigIntegerMod3);
                    i++;
                    if (i == 128 && !bigInteger2.isProbablePrime(80)) {
                        throw new InvalidAlgorithmParameterException("p is not prime");
                    }
                } else {
                    BigInteger bigIntegerShiftRight2 = bigInteger2.add(bigIntegerMod3).shiftRight(1);
                    BigInteger bigIntegerMod4 = bigIntegerAdd;
                    for (int iBitLength = bigIntegerShiftRight2.bitLength() - 2; iBitLength >= 0; iBitLength--) {
                        BigInteger bigIntegerMultiply = bigIntegerMod4.multiply(bigIntegerMod3);
                        bigIntegerMod4 = bigIntegerMod4.multiply(bigIntegerMod4).add(bigIntegerMod3.multiply(bigIntegerMod3).mod(bigInteger2).multiply(bigIntegerMod2)).mod(bigInteger2);
                        BigInteger bigIntegerMod5 = bigIntegerMultiply.add(bigIntegerMultiply).mod(bigInteger2);
                        if (bigIntegerShiftRight2.testBit(iBitLength)) {
                            BigInteger bigIntegerMod6 = bigIntegerMod4.multiply(bigIntegerAdd).add(bigIntegerMod5.multiply(bigIntegerMod2)).mod(bigInteger2);
                            bigIntegerMod3 = bigIntegerAdd.multiply(bigIntegerMod5).add(bigIntegerMod4).mod(bigInteger2);
                            bigIntegerMod4 = bigIntegerMod6;
                        } else {
                            bigIntegerMod3 = bigIntegerMod5;
                        }
                    }
                    bigIntegerModPow = bigIntegerMod4;
                    break;
                }
            }
        } else {
            bigIntegerModPow = null;
        }
        if (bigIntegerModPow == null || bigIntegerModPow.multiply(bigIntegerModPow).mod(bigInteger2).compareTo(bigIntegerMod) == 0) {
            return bigIntegerModPow;
        }
        throw new GeneralSecurityException("Could not find a modular square root");
    }

    private static BigInteger computeY(BigInteger bigInteger, boolean z, EllipticCurve ellipticCurve) throws GeneralSecurityException {
        BigInteger modulus = getModulus(ellipticCurve);
        BigInteger bigIntegerModSqrt = modSqrt(bigInteger.multiply(bigInteger).add(ellipticCurve.getA()).multiply(bigInteger).add(ellipticCurve.getB()).mod(modulus), modulus);
        return z != bigIntegerModSqrt.testBit(0) ? modulus.subtract(bigIntegerModSqrt).mod(modulus) : bigIntegerModSqrt;
    }

    @Deprecated
    public static BigInteger getY(BigInteger bigInteger, boolean z, EllipticCurve ellipticCurve) throws GeneralSecurityException {
        return computeY(bigInteger, z, ellipticCurve);
    }

    private static byte[] toMinimalSignedNumber(byte[] bArr) {
        int length = 0;
        while (length < bArr.length && bArr[length] == 0) {
            length++;
        }
        if (length == bArr.length) {
            length = bArr.length - 1;
        }
        int i = (bArr[length] & 128) == 128 ? 1 : 0;
        byte[] bArr2 = new byte[(bArr.length - length) + i];
        System.arraycopy(bArr, length, bArr2, i, bArr.length - length);
        return bArr2;
    }

    public static byte[] ecdsaIeee2Der(byte[] bArr) throws GeneralSecurityException {
        byte[] bArr2;
        int i;
        if (bArr.length % 2 != 0 || bArr.length == 0 || bArr.length > 132) {
            throw new GeneralSecurityException("Invalid IEEE_P1363 encoding");
        }
        byte[] minimalSignedNumber = toMinimalSignedNumber(Arrays.copyOf(bArr, bArr.length / 2));
        byte[] minimalSignedNumber2 = toMinimalSignedNumber(Arrays.copyOfRange(bArr, bArr.length / 2, bArr.length));
        int length = minimalSignedNumber.length + 4 + minimalSignedNumber2.length;
        if (length >= 128) {
            bArr2 = new byte[length + 3];
            bArr2[0] = 48;
            bArr2[1] = -127;
            bArr2[2] = (byte) length;
            i = 3;
        } else {
            bArr2 = new byte[length + 2];
            bArr2[0] = 48;
            bArr2[1] = (byte) length;
            i = 2;
        }
        bArr2[i] = 2;
        int i2 = i + 2;
        bArr2[i + 1] = (byte) minimalSignedNumber.length;
        System.arraycopy(minimalSignedNumber, 0, bArr2, i2, minimalSignedNumber.length);
        int length2 = i2 + minimalSignedNumber.length;
        bArr2[length2] = 2;
        bArr2[length2 + 1] = (byte) minimalSignedNumber2.length;
        System.arraycopy(minimalSignedNumber2, 0, bArr2, length2 + 2, minimalSignedNumber2.length);
        return bArr2;
    }

    public static byte[] ecdsaDer2Ieee(byte[] bArr, int i) throws GeneralSecurityException {
        if (!isValidDerEncoding(bArr)) {
            throw new GeneralSecurityException("Invalid DER encoding");
        }
        byte[] bArr2 = new byte[i];
        int i2 = (bArr[1] & 255) >= 128 ? 3 : 2;
        int i3 = i2 + 2;
        int i4 = bArr[i2 + 1];
        int i5 = bArr[i3] == 0 ? 1 : 0;
        System.arraycopy(bArr, i3 + i5, bArr2, ((i / 2) - i4) + i5, i4 - i5);
        int i6 = i3 + i4 + 1;
        int i7 = i6 + 1;
        int i8 = bArr[i6];
        int i9 = bArr[i7] != 0 ? 0 : 1;
        System.arraycopy(bArr, i7 + i9, bArr2, (i - i8) + i9, i8 - i9);
        return bArr2;
    }

    public static boolean isValidDerEncoding(byte[] bArr) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        if (bArr.length < 8 || bArr[0] != 48) {
            return false;
        }
        int i6 = bArr[1] & 255;
        if (i6 == 129) {
            i6 = bArr[2] & 255;
            if (i6 < 128) {
                return false;
            }
            i = 2;
        } else {
            if (i6 == 128 || i6 > 129) {
                return false;
            }
            i = 1;
        }
        if (i6 != (bArr.length - 1) - i || bArr[i + 1] != 2 || (i5 = (i4 = (i3 = i + 3) + (i2 = bArr[i + 2] & 255)) + 1) >= bArr.length || i2 == 0) {
            return false;
        }
        byte b = bArr[i3];
        if ((b & 255) >= 128) {
            return false;
        }
        if ((i2 > 1 && b == 0 && (bArr[i + 4] & 255) < 128) || bArr[i4] != 2) {
            return false;
        }
        int i7 = bArr[i5] & 255;
        if (i4 + 2 + i7 != bArr.length || i7 == 0) {
            return false;
        }
        byte b2 = bArr[i + 5 + i2];
        if ((b2 & 255) >= 128) {
            return false;
        }
        return i7 <= 1 || b2 != 0 || (bArr[(i + 6) + i2] & 255) >= 128;
    }

    public static int encodingSizeInBytes(EllipticCurve ellipticCurve, PointFormatType pointFormatType) throws GeneralSecurityException {
        int iFieldSizeInBytes = fieldSizeInBytes(ellipticCurve);
        int iOrdinal = pointFormatType.ordinal();
        if (iOrdinal == 0) {
            return (iFieldSizeInBytes * 2) + 1;
        }
        if (iOrdinal == 1) {
            return iFieldSizeInBytes + 1;
        }
        if (iOrdinal == 2) {
            return iFieldSizeInBytes * 2;
        }
        throw new GeneralSecurityException("unknown EC point format");
    }

    public static ECPoint ecPointDecode(EllipticCurve ellipticCurve, PointFormatType pointFormatType, byte[] bArr) throws GeneralSecurityException {
        return pointDecode(ellipticCurve, pointFormatType, bArr);
    }

    public static ECPoint pointDecode(CurveType curveType, PointFormatType pointFormatType, byte[] bArr) throws GeneralSecurityException {
        return pointDecode(getCurveSpec(curveType).getCurve(), pointFormatType, bArr);
    }

    public static ECPoint pointDecode(EllipticCurve ellipticCurve, PointFormatType pointFormatType, byte[] bArr) throws GeneralSecurityException {
        int iFieldSizeInBytes = fieldSizeInBytes(ellipticCurve);
        int iOrdinal = pointFormatType.ordinal();
        boolean z = false;
        if (iOrdinal == 0) {
            if (bArr.length != (iFieldSizeInBytes * 2) + 1) {
                throw new GeneralSecurityException("invalid point size");
            }
            if (bArr[0] != 4) {
                throw new GeneralSecurityException("invalid point format");
            }
            int i = iFieldSizeInBytes + 1;
            ECPoint eCPoint = new ECPoint(new BigInteger(1, Arrays.copyOfRange(bArr, 1, i)), new BigInteger(1, Arrays.copyOfRange(bArr, i, bArr.length)));
            EllipticCurvesUtil.checkPointOnCurve(eCPoint, ellipticCurve);
            return eCPoint;
        }
        if (iOrdinal != 1) {
            if (iOrdinal == 2) {
                if (bArr.length != iFieldSizeInBytes * 2) {
                    throw new GeneralSecurityException("invalid point size");
                }
                ECPoint eCPoint2 = new ECPoint(new BigInteger(1, Arrays.copyOf(bArr, iFieldSizeInBytes)), new BigInteger(1, Arrays.copyOfRange(bArr, iFieldSizeInBytes, bArr.length)));
                EllipticCurvesUtil.checkPointOnCurve(eCPoint2, ellipticCurve);
                return eCPoint2;
            }
            throw new GeneralSecurityException("invalid format:" + pointFormatType);
        }
        BigInteger modulus = getModulus(ellipticCurve);
        if (bArr.length != iFieldSizeInBytes + 1) {
            throw new GeneralSecurityException("compressed point has wrong length");
        }
        byte b = bArr[0];
        if (b != 2) {
            if (b != 3) {
                throw new GeneralSecurityException("invalid format");
            }
            z = true;
        }
        BigInteger bigInteger = new BigInteger(1, Arrays.copyOfRange(bArr, 1, bArr.length));
        if (bigInteger.signum() == -1 || bigInteger.compareTo(modulus) >= 0) {
            throw new GeneralSecurityException("x is out of range");
        }
        return new ECPoint(bigInteger, computeY(bigInteger, z, ellipticCurve));
    }

    public static byte[] pointEncode(CurveType curveType, PointFormatType pointFormatType, ECPoint eCPoint) throws GeneralSecurityException {
        return pointEncode(getCurveSpec(curveType).getCurve(), pointFormatType, eCPoint);
    }

    public static byte[] pointEncode(EllipticCurve ellipticCurve, PointFormatType pointFormatType, ECPoint eCPoint) throws GeneralSecurityException {
        EllipticCurvesUtil.checkPointOnCurve(eCPoint, ellipticCurve);
        int iFieldSizeInBytes = fieldSizeInBytes(ellipticCurve);
        int iOrdinal = pointFormatType.ordinal();
        if (iOrdinal == 0) {
            int i = (iFieldSizeInBytes * 2) + 1;
            byte[] bArr = new byte[i];
            byte[] bigEndianBytes = BigIntegerEncoding.toBigEndianBytes(eCPoint.getAffineX());
            byte[] bigEndianBytes2 = BigIntegerEncoding.toBigEndianBytes(eCPoint.getAffineY());
            System.arraycopy(bigEndianBytes2, 0, bArr, i - bigEndianBytes2.length, bigEndianBytes2.length);
            System.arraycopy(bigEndianBytes, 0, bArr, (iFieldSizeInBytes + 1) - bigEndianBytes.length, bigEndianBytes.length);
            bArr[0] = 4;
            return bArr;
        }
        if (iOrdinal == 1) {
            int i2 = iFieldSizeInBytes + 1;
            byte[] bArr2 = new byte[i2];
            byte[] bigEndianBytes3 = BigIntegerEncoding.toBigEndianBytes(eCPoint.getAffineX());
            System.arraycopy(bigEndianBytes3, 0, bArr2, i2 - bigEndianBytes3.length, bigEndianBytes3.length);
            bArr2[0] = (byte) (eCPoint.getAffineY().testBit(0) ? 3 : 2);
            return bArr2;
        }
        if (iOrdinal == 2) {
            int i3 = iFieldSizeInBytes * 2;
            byte[] bArr3 = new byte[i3];
            byte[] bigEndianBytes4 = BigIntegerEncoding.toBigEndianBytes(eCPoint.getAffineX());
            if (bigEndianBytes4.length > iFieldSizeInBytes) {
                bigEndianBytes4 = Arrays.copyOfRange(bigEndianBytes4, bigEndianBytes4.length - iFieldSizeInBytes, bigEndianBytes4.length);
            }
            byte[] bigEndianBytes5 = BigIntegerEncoding.toBigEndianBytes(eCPoint.getAffineY());
            if (bigEndianBytes5.length > iFieldSizeInBytes) {
                bigEndianBytes5 = Arrays.copyOfRange(bigEndianBytes5, bigEndianBytes5.length - iFieldSizeInBytes, bigEndianBytes5.length);
            }
            System.arraycopy(bigEndianBytes5, 0, bArr3, i3 - bigEndianBytes5.length, bigEndianBytes5.length);
            System.arraycopy(bigEndianBytes4, 0, bArr3, iFieldSizeInBytes - bigEndianBytes4.length, bigEndianBytes4.length);
            return bArr3;
        }
        throw new GeneralSecurityException("invalid format:" + pointFormatType);
    }

    public static ECParameterSpec getCurveSpec(CurveType curveType) throws NoSuchAlgorithmException {
        int iOrdinal = curveType.ordinal();
        if (iOrdinal == 0) {
            return getNistP256Params();
        }
        if (iOrdinal == 1) {
            return getNistP384Params();
        }
        if (iOrdinal == 2) {
            return getNistP521Params();
        }
        throw new NoSuchAlgorithmException("curve not implemented:" + curveType);
    }

    public static ECPublicKey getEcPublicKey(byte[] bArr) throws GeneralSecurityException {
        return (ECPublicKey) EngineFactory.KEY_FACTORY.getInstance("EC").generatePublic(new X509EncodedKeySpec(bArr));
    }

    public static ECPublicKey getEcPublicKey(CurveType curveType, PointFormatType pointFormatType, byte[] bArr) throws GeneralSecurityException {
        return getEcPublicKey(getCurveSpec(curveType), pointFormatType, bArr);
    }

    public static ECPublicKey getEcPublicKey(ECParameterSpec eCParameterSpec, PointFormatType pointFormatType, byte[] bArr) throws GeneralSecurityException {
        return (ECPublicKey) EngineFactory.KEY_FACTORY.getInstance("EC").generatePublic(new ECPublicKeySpec(pointDecode(eCParameterSpec.getCurve(), pointFormatType, bArr), eCParameterSpec));
    }

    public static ECPublicKey getEcPublicKey(CurveType curveType, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        ECParameterSpec curveSpec = getCurveSpec(curveType);
        ECPoint eCPoint = new ECPoint(new BigInteger(1, bArr), new BigInteger(1, bArr2));
        EllipticCurvesUtil.checkPointOnCurve(eCPoint, curveSpec.getCurve());
        return (ECPublicKey) EngineFactory.KEY_FACTORY.getInstance("EC").generatePublic(new ECPublicKeySpec(eCPoint, curveSpec));
    }

    public static ECPrivateKey getEcPrivateKey(byte[] bArr) throws GeneralSecurityException {
        return (ECPrivateKey) EngineFactory.KEY_FACTORY.getInstance("EC").generatePrivate(new PKCS8EncodedKeySpec(bArr));
    }

    public static ECPrivateKey getEcPrivateKey(CurveType curveType, byte[] bArr) throws GeneralSecurityException {
        return (ECPrivateKey) EngineFactory.KEY_FACTORY.getInstance("EC").generatePrivate(new ECPrivateKeySpec(BigIntegerEncoding.fromUnsignedBigEndianBytes(bArr), getCurveSpec(curveType)));
    }

    public static KeyPair generateKeyPair(CurveType curveType) throws GeneralSecurityException {
        return generateKeyPair(getCurveSpec(curveType));
    }

    public static KeyPair generateKeyPair(ECParameterSpec eCParameterSpec) throws GeneralSecurityException {
        KeyPairGenerator engineFactory = EngineFactory.KEY_PAIR_GENERATOR.getInstance("EC");
        engineFactory.initialize(eCParameterSpec);
        return engineFactory.generateKeyPair();
    }

    static void validateSharedSecret(byte[] bArr, ECPrivateKey eCPrivateKey) throws GeneralSecurityException {
        EllipticCurve curve = eCPrivateKey.getParams().getCurve();
        BigInteger bigInteger = new BigInteger(1, bArr);
        if (bigInteger.signum() == -1 || bigInteger.compareTo(getModulus(curve)) >= 0) {
            throw new GeneralSecurityException("shared secret is out of range");
        }
        computeY(bigInteger, true, curve);
    }

    public static byte[] computeSharedSecret(ECPrivateKey eCPrivateKey, ECPublicKey eCPublicKey) throws GeneralSecurityException {
        validatePublicKeySpec(eCPublicKey, eCPrivateKey);
        return computeSharedSecret(eCPrivateKey, eCPublicKey.getW());
    }

    public static byte[] computeSharedSecret(ECPrivateKey eCPrivateKey, ECPoint eCPoint) throws GeneralSecurityException {
        EllipticCurvesUtil.checkPointOnCurve(eCPoint, eCPrivateKey.getParams().getCurve());
        PublicKey publicKeyGeneratePublic = EngineFactory.KEY_FACTORY.getInstance("EC").generatePublic(new ECPublicKeySpec(eCPoint, eCPrivateKey.getParams()));
        KeyAgreement engineFactory = EngineFactory.KEY_AGREEMENT.getInstance("ECDH");
        engineFactory.init(eCPrivateKey);
        try {
            engineFactory.doPhase(publicKeyGeneratePublic, true);
            byte[] bArrGenerateSecret = engineFactory.generateSecret();
            validateSharedSecret(bArrGenerateSecret, eCPrivateKey);
            return bArrGenerateSecret;
        } catch (IllegalStateException e) {
            throw new GeneralSecurityException(e);
        }
    }

    private EllipticCurves() {
    }
}
