package com.google.crypto.tink.hybrid;

import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.Key;
import com.google.crypto.tink.internal.EllipticCurvesUtil;
import com.google.crypto.tink.subtle.EllipticCurves;
import com.google.crypto.tink.subtle.X25519;
import com.google.crypto.tink.util.SecretBigInteger;
import com.google.crypto.tink.util.SecretBytes;
import com.google.errorprone.annotations.Immutable;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.util.Arrays;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Immutable
public final class EciesPrivateKey extends HybridPrivateKey {

    @Nullable
    private final SecretBigInteger nistPrivateKeyValue;
    private final EciesPublicKey publicKey;

    @Nullable
    private final SecretBytes x25519PrivateKeyBytes;

    private EciesPrivateKey(EciesPublicKey eciesPublicKey, @Nullable SecretBigInteger secretBigInteger, @Nullable SecretBytes secretBytes) {
        this.publicKey = eciesPublicKey;
        this.nistPrivateKeyValue = secretBigInteger;
        this.x25519PrivateKeyBytes = secretBytes;
    }

    private static ECParameterSpec toParameterSpecNistCurve(EciesParameters.CurveType curveType) {
        if (curveType == EciesParameters.CurveType.NIST_P256) {
            return EllipticCurves.getNistP256Params();
        }
        if (curveType == EciesParameters.CurveType.NIST_P384) {
            return EllipticCurves.getNistP384Params();
        }
        if (curveType == EciesParameters.CurveType.NIST_P521) {
            return EllipticCurves.getNistP521Params();
        }
        throw new IllegalArgumentException("Unable to determine NIST curve type for " + curveType);
    }

    private static void validateNistPrivateKeyValue(BigInteger bigInteger, ECPoint eCPoint, EciesParameters.CurveType curveType) throws GeneralSecurityException {
        BigInteger order = toParameterSpecNistCurve(curveType).getOrder();
        if (bigInteger.signum() <= 0 || bigInteger.compareTo(order) >= 0) {
            throw new GeneralSecurityException("Invalid private value");
        }
        if (!EllipticCurvesUtil.multiplyByGenerator(bigInteger, toParameterSpecNistCurve(curveType)).equals(eCPoint)) {
            throw new GeneralSecurityException("Invalid private value");
        }
    }

    private static void validateX25519PrivateKeyBytes(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length != 32) {
            throw new GeneralSecurityException("Private key bytes length for X25519 curve must be 32");
        }
        if (!Arrays.equals(X25519.publicFromPrivate(bArr), bArr2)) {
            throw new GeneralSecurityException("Invalid private key for public key.");
        }
    }

    public static EciesPrivateKey createForCurveX25519(EciesPublicKey eciesPublicKey, SecretBytes secretBytes) throws GeneralSecurityException {
        if (eciesPublicKey == null) {
            throw new GeneralSecurityException("ECIES private key cannot be constructed without an ECIES public key");
        }
        if (eciesPublicKey.getX25519CurvePointBytes() == null) {
            throw new GeneralSecurityException("ECIES private key for X25519 curve cannot be constructed with NIST-curve public key");
        }
        if (secretBytes == null) {
            throw new GeneralSecurityException("ECIES private key cannot be constructed without secret");
        }
        validateX25519PrivateKeyBytes(secretBytes.toByteArray(InsecureSecretKeyAccess.get()), eciesPublicKey.getX25519CurvePointBytes().toByteArray());
        return new EciesPrivateKey(eciesPublicKey, null, secretBytes);
    }

    public static EciesPrivateKey createForNistCurve(EciesPublicKey eciesPublicKey, SecretBigInteger secretBigInteger) throws GeneralSecurityException {
        if (eciesPublicKey == null) {
            throw new GeneralSecurityException("ECIES private key cannot be constructed without an ECIES public key");
        }
        if (eciesPublicKey.getNistCurvePoint() == null) {
            throw new GeneralSecurityException("ECIES private key for NIST curve cannot be constructed with X25519-curve public key");
        }
        if (secretBigInteger == null) {
            throw new GeneralSecurityException("ECIES private key cannot be constructed without secret");
        }
        validateNistPrivateKeyValue(secretBigInteger.getBigInteger(InsecureSecretKeyAccess.get()), eciesPublicKey.getNistCurvePoint(), eciesPublicKey.getParameters().getCurveType());
        return new EciesPrivateKey(eciesPublicKey, secretBigInteger, null);
    }

    @Nullable
    public SecretBytes getX25519PrivateKeyBytes() {
        return this.x25519PrivateKeyBytes;
    }

    @Nullable
    public SecretBigInteger getNistPrivateKeyValue() {
        return this.nistPrivateKeyValue;
    }

    @Override // com.google.crypto.tink.hybrid.HybridPrivateKey, com.google.crypto.tink.Key
    public EciesParameters getParameters() {
        return this.publicKey.getParameters();
    }

    @Override // com.google.crypto.tink.hybrid.HybridPrivateKey, com.google.crypto.tink.PrivateKey
    public EciesPublicKey getPublicKey() {
        return this.publicKey;
    }

    @Override // com.google.crypto.tink.Key
    public boolean equalsKey(Key key) {
        if (!(key instanceof EciesPrivateKey)) {
            return false;
        }
        EciesPrivateKey eciesPrivateKey = (EciesPrivateKey) key;
        if (!this.publicKey.equalsKey(eciesPrivateKey.publicKey)) {
            return false;
        }
        SecretBytes secretBytes = this.x25519PrivateKeyBytes;
        if (secretBytes == null && eciesPrivateKey.x25519PrivateKeyBytes == null) {
            return this.nistPrivateKeyValue.equalsSecretBigInteger(eciesPrivateKey.nistPrivateKeyValue);
        }
        return secretBytes.equalsSecretBytes(eciesPrivateKey.x25519PrivateKeyBytes);
    }
}
