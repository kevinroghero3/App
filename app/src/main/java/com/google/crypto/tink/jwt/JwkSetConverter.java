package com.google.crypto.tink.jwt;

import ch.qos.logback.core.rolling.helper.DateTokenConverter;
import com.facebook.common.callercontext.ContextChain;
import com.google.crypto.tink.Key;
import com.google.crypto.tink.KeyStatus;
import com.google.crypto.tink.KeysetHandle;
import com.google.crypto.tink.internal.BigIntegerEncoding;
import com.google.crypto.tink.internal.JsonParser;
import com.google.crypto.tink.jwt.internal.JwtNames;
import com.google.crypto.tink.subtle.Base64;
import com.google.crypto.tink.tinkkey.KeyAccess;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.spec.ECPoint;
import java.util.Iterator;
import java.util.Optional;

/* JADX INFO: loaded from: classes5.dex */
public final class JwkSetConverter {
    public static String fromPublicKeysetHandle(KeysetHandle keysetHandle) throws GeneralSecurityException, IOException {
        KeysetHandle keysetHandleBuild = KeysetHandle.newBuilder(keysetHandle).build();
        JsonArray jsonArray = new JsonArray();
        for (int i = 0; i < keysetHandleBuild.size(); i++) {
            KeysetHandle.Entry at = keysetHandleBuild.getAt(i);
            if (at.getStatus() == KeyStatus.ENABLED) {
                Key key = at.getKey();
                if (key instanceof JwtEcdsaPublicKey) {
                    jsonArray.add(convertJwtEcdsaKey((JwtEcdsaPublicKey) key));
                } else if (key instanceof JwtRsaSsaPkcs1PublicKey) {
                    jsonArray.add(convertJwtRsaSsaPkcs1Key((JwtRsaSsaPkcs1PublicKey) key));
                } else {
                    if (!(key instanceof JwtRsaSsaPssPublicKey)) {
                        throw new GeneralSecurityException("unsupported key with parameters " + key.getParameters());
                    }
                    jsonArray.add(convertJwtRsaSsaPssKey((JwtRsaSsaPssPublicKey) key));
                }
            }
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("keys", jsonArray);
        return jsonObject.toString();
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0069  */
    public static KeysetHandle toPublicKeysetHandle(String str) throws GeneralSecurityException, IOException {
        try {
            JsonObject asJsonObject = JsonParser.parse(str).getAsJsonObject();
            KeysetHandle.Builder builderNewBuilder = KeysetHandle.newBuilder();
            Iterator<JsonElement> it2 = asJsonObject.get("keys").getAsJsonArray().iterator();
            while (true) {
                byte b = 0;
                if (it2.hasNext()) {
                    JsonObject asJsonObject2 = it2.next().getAsJsonObject();
                    String strSubstring = getStringItem(asJsonObject2, JwtNames.HEADER_ALGORITHM).substring(0, 2);
                    strSubstring.hashCode();
                    int iHashCode = strSubstring.hashCode();
                    if (iHashCode != 2222) {
                        if (iHashCode != 2563) {
                            if (iHashCode == 2625 && strSubstring.equals("RS")) {
                                b = 2;
                            } else {
                                b = -1;
                            }
                        } else if (strSubstring.equals("PS")) {
                            b = 1;
                        } else {
                            b = -1;
                        }
                    } else if (!strSubstring.equals("ES")) {
                        b = -1;
                    }
                    if (b == 0) {
                        builderNewBuilder.addEntry(KeysetHandle.importKey(convertToEcdsaKey(asJsonObject2)).withRandomId());
                    } else if (b == 1) {
                        builderNewBuilder.addEntry(KeysetHandle.importKey(convertToRsaSsaPssKey(asJsonObject2)).withRandomId());
                    } else if (b == 2) {
                        builderNewBuilder.addEntry(KeysetHandle.importKey(convertToRsaSsaPkcs1Key(asJsonObject2)).withRandomId());
                    } else {
                        throw new GeneralSecurityException("unexpected alg value: " + getStringItem(asJsonObject2, JwtNames.HEADER_ALGORITHM));
                    }
                } else {
                    if (builderNewBuilder.size() <= 0) {
                        throw new GeneralSecurityException("empty keyset");
                    }
                    builderNewBuilder.getAt(0).makePrimary();
                    return builderNewBuilder.build();
                }
            }
        } catch (IOException | IllegalStateException e) {
            throw new GeneralSecurityException("JWK set is invalid JSON", e);
        }
    }

    private static JsonObject convertJwtEcdsaKey(JwtEcdsaPublicKey jwtEcdsaPublicKey) throws GeneralSecurityException {
        String str;
        String str2;
        int i;
        JwtEcdsaParameters.Algorithm algorithm = jwtEcdsaPublicKey.getParameters().getAlgorithm();
        if (algorithm.equals(JwtEcdsaParameters.Algorithm.ES256)) {
            str = "ES256";
            str2 = "P-256";
            i = 32;
        } else if (algorithm.equals(JwtEcdsaParameters.Algorithm.ES384)) {
            str = "ES384";
            str2 = "P-384";
            i = 48;
        } else if (algorithm.equals(JwtEcdsaParameters.Algorithm.ES512)) {
            str = "ES512";
            str2 = "P-521";
            i = 66;
        } else {
            throw new GeneralSecurityException("unknown algorithm");
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("kty", "EC");
        jsonObject.addProperty("crv", str2);
        BigInteger affineX = jwtEcdsaPublicKey.getPublicPoint().getAffineX();
        BigInteger affineY = jwtEcdsaPublicKey.getPublicPoint().getAffineY();
        jsonObject.addProperty("x", Base64.urlSafeEncode(BigIntegerEncoding.toBigEndianBytesOfFixedLength(affineX, i)));
        jsonObject.addProperty("y", Base64.urlSafeEncode(BigIntegerEncoding.toBigEndianBytesOfFixedLength(affineY, i)));
        jsonObject.addProperty("use", "sig");
        jsonObject.addProperty(JwtNames.HEADER_ALGORITHM, str);
        JsonArray jsonArray = new JsonArray();
        jsonArray.add("verify");
        jsonObject.add("key_ops", jsonArray);
        Optional<String> kid = jwtEcdsaPublicKey.getKid();
        if (kid.isPresent()) {
            jsonObject.addProperty(JwtNames.HEADER_KEY_ID, kid.get());
        }
        return jsonObject;
    }

    private static byte[] base64urlUInt(BigInteger bigInteger) {
        if (bigInteger.equals(BigInteger.ZERO)) {
            return new byte[]{0};
        }
        return BigIntegerEncoding.toUnsignedBigEndianBytes(bigInteger);
    }

    private static JsonObject convertJwtRsaSsaPkcs1Key(JwtRsaSsaPkcs1PublicKey jwtRsaSsaPkcs1PublicKey) throws GeneralSecurityException {
        String standardName = jwtRsaSsaPkcs1PublicKey.getParameters().getAlgorithm().getStandardName();
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("kty", "RSA");
        jsonObject.addProperty("n", Base64.urlSafeEncode(base64urlUInt(jwtRsaSsaPkcs1PublicKey.getModulus())));
        jsonObject.addProperty("e", Base64.urlSafeEncode(base64urlUInt(jwtRsaSsaPkcs1PublicKey.getParameters().getPublicExponent())));
        jsonObject.addProperty("use", "sig");
        jsonObject.addProperty(JwtNames.HEADER_ALGORITHM, standardName);
        JsonArray jsonArray = new JsonArray();
        jsonArray.add("verify");
        jsonObject.add("key_ops", jsonArray);
        Optional<String> kid = jwtRsaSsaPkcs1PublicKey.getKid();
        if (kid.isPresent()) {
            jsonObject.addProperty(JwtNames.HEADER_KEY_ID, kid.get());
        }
        return jsonObject;
    }

    private static JsonObject convertJwtRsaSsaPssKey(JwtRsaSsaPssPublicKey jwtRsaSsaPssPublicKey) throws GeneralSecurityException {
        String standardName = jwtRsaSsaPssPublicKey.getParameters().getAlgorithm().getStandardName();
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("kty", "RSA");
        jsonObject.addProperty("n", Base64.urlSafeEncode(base64urlUInt(jwtRsaSsaPssPublicKey.getModulus())));
        jsonObject.addProperty("e", Base64.urlSafeEncode(base64urlUInt(jwtRsaSsaPssPublicKey.getParameters().getPublicExponent())));
        jsonObject.addProperty("use", "sig");
        jsonObject.addProperty(JwtNames.HEADER_ALGORITHM, standardName);
        JsonArray jsonArray = new JsonArray();
        jsonArray.add("verify");
        jsonObject.add("key_ops", jsonArray);
        Optional<String> kid = jwtRsaSsaPssPublicKey.getKid();
        if (kid.isPresent()) {
            jsonObject.addProperty(JwtNames.HEADER_KEY_ID, kid.get());
        }
        return jsonObject;
    }

    private static String getStringItem(JsonObject jsonObject, String str) throws GeneralSecurityException {
        if (!jsonObject.has(str)) {
            throw new GeneralSecurityException(str + " not found");
        }
        if (!jsonObject.get(str).isJsonPrimitive() || !jsonObject.get(str).getAsJsonPrimitive().isString()) {
            throw new GeneralSecurityException(str + " is not a string");
        }
        return jsonObject.get(str).getAsString();
    }

    private static void expectStringItem(JsonObject jsonObject, String str, String str2) throws GeneralSecurityException {
        String stringItem = getStringItem(jsonObject, str);
        if (stringItem.equals(str2)) {
            return;
        }
        throw new GeneralSecurityException("unexpected " + str + " value: " + stringItem);
    }

    private static void validateUseIsSig(JsonObject jsonObject) throws GeneralSecurityException {
        if (jsonObject.has("use")) {
            expectStringItem(jsonObject, "use", "sig");
        }
    }

    private static void validateKeyOpsIsVerify(JsonObject jsonObject) throws GeneralSecurityException {
        if (jsonObject.has("key_ops")) {
            if (!jsonObject.get("key_ops").isJsonArray()) {
                throw new GeneralSecurityException("key_ops is not an array");
            }
            JsonArray asJsonArray = jsonObject.get("key_ops").getAsJsonArray();
            if (asJsonArray.size() != 1) {
                throw new GeneralSecurityException("key_ops must contain exactly one element");
            }
            if (!asJsonArray.get(0).isJsonPrimitive() || !asJsonArray.get(0).getAsJsonPrimitive().isString()) {
                throw new GeneralSecurityException("key_ops is not a string");
            }
            if (asJsonArray.get(0).getAsString().equals("verify")) {
                return;
            }
            throw new GeneralSecurityException("unexpected keyOps value: " + asJsonArray.get(0).getAsString());
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x003d  */
    private static JwtRsaSsaPkcs1PublicKey convertToRsaSsaPkcs1Key(JsonObject jsonObject) throws GeneralSecurityException {
        byte b;
        JwtRsaSsaPkcs1Parameters.Algorithm algorithm;
        String stringItem = getStringItem(jsonObject, JwtNames.HEADER_ALGORITHM);
        stringItem.hashCode();
        int iHashCode = stringItem.hashCode();
        if (iHashCode != 78251122) {
            if (iHashCode != 78252174) {
                if (iHashCode == 78253877 && stringItem.equals("RS512")) {
                    b = 2;
                } else {
                    b = -1;
                }
            } else if (stringItem.equals("RS384")) {
                b = 1;
            } else {
                b = -1;
            }
        } else if (stringItem.equals("RS256")) {
            b = 0;
        } else {
            b = -1;
        }
        if (b == 0) {
            algorithm = JwtRsaSsaPkcs1Parameters.Algorithm.RS256;
        } else if (b == 1) {
            algorithm = JwtRsaSsaPkcs1Parameters.Algorithm.RS384;
        } else if (b == 2) {
            algorithm = JwtRsaSsaPkcs1Parameters.Algorithm.RS512;
        } else {
            throw new GeneralSecurityException("Unknown Rsa Algorithm: " + getStringItem(jsonObject, JwtNames.HEADER_ALGORITHM));
        }
        if (jsonObject.has(ContextChain.TAG_PRODUCT) || jsonObject.has("q") || jsonObject.has("dp") || jsonObject.has("dq") || jsonObject.has(DateTokenConverter.CONVERTER_KEY) || jsonObject.has("qi")) {
            throw new UnsupportedOperationException("importing RSA private keys is not implemented");
        }
        expectStringItem(jsonObject, "kty", "RSA");
        validateUseIsSig(jsonObject);
        validateKeyOpsIsVerify(jsonObject);
        BigInteger bigInteger = new BigInteger(1, Base64.urlSafeDecode(getStringItem(jsonObject, "e")));
        BigInteger bigInteger2 = new BigInteger(1, Base64.urlSafeDecode(getStringItem(jsonObject, "n")));
        if (jsonObject.has(JwtNames.HEADER_KEY_ID)) {
            return JwtRsaSsaPkcs1PublicKey.builder().setParameters(JwtRsaSsaPkcs1Parameters.builder().setModulusSizeBits(bigInteger2.bitLength()).setPublicExponent(bigInteger).setAlgorithm(algorithm).setKidStrategy(JwtRsaSsaPkcs1Parameters.KidStrategy.CUSTOM).build()).setModulus(bigInteger2).setCustomKid(getStringItem(jsonObject, JwtNames.HEADER_KEY_ID)).build();
        }
        return JwtRsaSsaPkcs1PublicKey.builder().setParameters(JwtRsaSsaPkcs1Parameters.builder().setModulusSizeBits(bigInteger2.bitLength()).setPublicExponent(bigInteger).setAlgorithm(algorithm).setKidStrategy(JwtRsaSsaPkcs1Parameters.KidStrategy.IGNORED).build()).setModulus(bigInteger2).build();
    }

    /* JADX WARN: Code duplicated, block: B:19:0x003d  */
    private static JwtRsaSsaPssPublicKey convertToRsaSsaPssKey(JsonObject jsonObject) throws GeneralSecurityException {
        byte b;
        JwtRsaSsaPssParameters.Algorithm algorithm;
        String stringItem = getStringItem(jsonObject, JwtNames.HEADER_ALGORITHM);
        stringItem.hashCode();
        int iHashCode = stringItem.hashCode();
        if (iHashCode != 76404080) {
            if (iHashCode != 76405132) {
                if (iHashCode == 76406835 && stringItem.equals("PS512")) {
                    b = 2;
                } else {
                    b = -1;
                }
            } else if (stringItem.equals("PS384")) {
                b = 1;
            } else {
                b = -1;
            }
        } else if (stringItem.equals("PS256")) {
            b = 0;
        } else {
            b = -1;
        }
        if (b == 0) {
            algorithm = JwtRsaSsaPssParameters.Algorithm.PS256;
        } else if (b == 1) {
            algorithm = JwtRsaSsaPssParameters.Algorithm.PS384;
        } else if (b == 2) {
            algorithm = JwtRsaSsaPssParameters.Algorithm.PS512;
        } else {
            throw new GeneralSecurityException("Unknown Rsa Algorithm: " + getStringItem(jsonObject, JwtNames.HEADER_ALGORITHM));
        }
        if (jsonObject.has(ContextChain.TAG_PRODUCT) || jsonObject.has("q") || jsonObject.has("dq") || jsonObject.has("dq") || jsonObject.has(DateTokenConverter.CONVERTER_KEY) || jsonObject.has("qi")) {
            throw new UnsupportedOperationException("importing RSA private keys is not implemented");
        }
        expectStringItem(jsonObject, "kty", "RSA");
        validateUseIsSig(jsonObject);
        validateKeyOpsIsVerify(jsonObject);
        BigInteger bigInteger = new BigInteger(1, Base64.urlSafeDecode(getStringItem(jsonObject, "e")));
        BigInteger bigInteger2 = new BigInteger(1, Base64.urlSafeDecode(getStringItem(jsonObject, "n")));
        if (jsonObject.has(JwtNames.HEADER_KEY_ID)) {
            return JwtRsaSsaPssPublicKey.builder().setParameters(JwtRsaSsaPssParameters.builder().setModulusSizeBits(bigInteger2.bitLength()).setPublicExponent(bigInteger).setAlgorithm(algorithm).setKidStrategy(JwtRsaSsaPssParameters.KidStrategy.CUSTOM).build()).setModulus(bigInteger2).setCustomKid(getStringItem(jsonObject, JwtNames.HEADER_KEY_ID)).build();
        }
        return JwtRsaSsaPssPublicKey.builder().setParameters(JwtRsaSsaPssParameters.builder().setModulusSizeBits(bigInteger2.bitLength()).setPublicExponent(bigInteger).setAlgorithm(algorithm).setKidStrategy(JwtRsaSsaPssParameters.KidStrategy.IGNORED).build()).setModulus(bigInteger2).build();
    }

    /* JADX WARN: Code duplicated, block: B:19:0x003d  */
    private static JwtEcdsaPublicKey convertToEcdsaKey(JsonObject jsonObject) throws GeneralSecurityException {
        byte b;
        JwtEcdsaParameters.Algorithm algorithm;
        String stringItem = getStringItem(jsonObject, JwtNames.HEADER_ALGORITHM);
        stringItem.hashCode();
        int iHashCode = stringItem.hashCode();
        if (iHashCode != 66245349) {
            if (iHashCode != 66246401) {
                if (iHashCode == 66248104 && stringItem.equals("ES512")) {
                    b = 2;
                } else {
                    b = -1;
                }
            } else if (stringItem.equals("ES384")) {
                b = 1;
            } else {
                b = -1;
            }
        } else if (stringItem.equals("ES256")) {
            b = 0;
        } else {
            b = -1;
        }
        if (b == 0) {
            expectStringItem(jsonObject, "crv", "P-256");
            algorithm = JwtEcdsaParameters.Algorithm.ES256;
        } else if (b == 1) {
            expectStringItem(jsonObject, "crv", "P-384");
            algorithm = JwtEcdsaParameters.Algorithm.ES384;
        } else if (b == 2) {
            expectStringItem(jsonObject, "crv", "P-521");
            algorithm = JwtEcdsaParameters.Algorithm.ES512;
        } else {
            throw new GeneralSecurityException("Unknown Ecdsa Algorithm: " + getStringItem(jsonObject, JwtNames.HEADER_ALGORITHM));
        }
        if (jsonObject.has(DateTokenConverter.CONVERTER_KEY)) {
            throw new UnsupportedOperationException("importing ECDSA private keys is not implemented");
        }
        expectStringItem(jsonObject, "kty", "EC");
        validateUseIsSig(jsonObject);
        validateKeyOpsIsVerify(jsonObject);
        ECPoint eCPoint = new ECPoint(new BigInteger(1, Base64.urlSafeDecode(getStringItem(jsonObject, "x"))), new BigInteger(1, Base64.urlSafeDecode(getStringItem(jsonObject, "y"))));
        if (jsonObject.has(JwtNames.HEADER_KEY_ID)) {
            return JwtEcdsaPublicKey.builder().setParameters(JwtEcdsaParameters.builder().setKidStrategy(JwtEcdsaParameters.KidStrategy.CUSTOM).setAlgorithm(algorithm).build()).setPublicPoint(eCPoint).setCustomKid(getStringItem(jsonObject, JwtNames.HEADER_KEY_ID)).build();
        }
        return JwtEcdsaPublicKey.builder().setParameters(JwtEcdsaParameters.builder().setKidStrategy(JwtEcdsaParameters.KidStrategy.IGNORED).setAlgorithm(algorithm).build()).setPublicPoint(eCPoint).build();
    }

    @Deprecated
    public static String fromKeysetHandle(KeysetHandle keysetHandle, KeyAccess keyAccess) throws GeneralSecurityException, IOException {
        return fromPublicKeysetHandle(keysetHandle);
    }

    @Deprecated
    public static KeysetHandle toKeysetHandle(String str, KeyAccess keyAccess) throws GeneralSecurityException, IOException {
        return toPublicKeysetHandle(str);
    }

    private JwkSetConverter() {
    }
}
