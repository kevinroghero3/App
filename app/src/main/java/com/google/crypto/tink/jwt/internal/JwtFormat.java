package com.google.crypto.tink.jwt.internal;

import com.google.common.base.Ascii;
import com.google.crypto.tink.internal.Util;
import com.google.crypto.tink.jwt.JwtInvalidException;
import com.google.crypto.tink.jwt.RawJwt;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.subtle.Base64;
import com.google.gson.JsonObject;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Optional;

/* JADX INFO: loaded from: classes5.dex */
public final class JwtFormat {
    public static boolean isValidUrlsafeBase64Char(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || ((c >= '0' && c <= '9') || c == '-' || c == '_');
    }

    public static class Parts {
        public String header;
        public String payload;
        public byte[] signatureOrMac;
        public String unsignedCompact;

        public Parts(String str, byte[] bArr, String str2, String str3) {
            this.unsignedCompact = str;
            this.signatureOrMac = bArr;
            this.header = str2;
            this.payload = str3;
        }
    }

    private JwtFormat() {
    }

    public static void validateUtf8(byte[] bArr) throws JwtInvalidException {
        try {
            Util.UTF_8.newDecoder().decode(ByteBuffer.wrap(bArr));
        } catch (CharacterCodingException e) {
            throw new JwtInvalidException(e.getMessage());
        }
    }

    public static byte[] strictUrlSafeDecode(String str) throws JwtInvalidException {
        for (int i = 0; i < str.length(); i++) {
            if (!isValidUrlsafeBase64Char(str.charAt(i))) {
                throw new JwtInvalidException("invalid encoding");
            }
        }
        try {
            return Base64.urlSafeDecode(str);
        } catch (IllegalArgumentException e) {
            throw new JwtInvalidException("invalid encoding: " + e);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:53:0x009c  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static void validateAlgorithm(String str) throws InvalidAlgorithmParameterException {
        byte b;
        str.hashCode();
        switch (str.hashCode()) {
            case 66245349:
                if (!str.equals("ES256")) {
                    b = -1;
                } else {
                    b = 0;
                }
                break;
            case 66246401:
                if (!str.equals("ES384")) {
                    b = -1;
                } else {
                    b = 1;
                }
                break;
            case 66248104:
                if (!str.equals("ES512")) {
                    b = -1;
                } else {
                    b = 2;
                }
                break;
            case 69015912:
                if (!str.equals("HS256")) {
                    b = -1;
                } else {
                    b = 3;
                }
                break;
            case 69016964:
                if (!str.equals("HS384")) {
                    b = -1;
                } else {
                    b = 4;
                }
                break;
            case 69018667:
                if (!str.equals("HS512")) {
                    b = -1;
                } else {
                    b = 5;
                }
                break;
            case 76404080:
                if (!str.equals("PS256")) {
                    b = -1;
                } else {
                    b = 6;
                }
                break;
            case 76405132:
                if (!str.equals("PS384")) {
                    b = -1;
                } else {
                    b = 7;
                }
                break;
            case 76406835:
                if (!str.equals("PS512")) {
                    b = -1;
                } else {
                    b = 8;
                }
                break;
            case 78251122:
                if (!str.equals("RS256")) {
                    b = -1;
                } else {
                    b = 9;
                }
                break;
            case 78252174:
                if (!str.equals("RS384")) {
                    b = -1;
                } else {
                    b = 10;
                }
                break;
            case 78253877:
                if (!str.equals("RS512")) {
                    b = -1;
                } else {
                    b = Ascii.VT;
                }
                break;
            default:
                b = -1;
                break;
        }
        switch (b) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                return;
            default:
                throw new InvalidAlgorithmParameterException("invalid algorithm: " + str);
        }
    }

    public static String createHeader(String str, Optional<String> optional, Optional<String> optional2) throws InvalidAlgorithmParameterException {
        validateAlgorithm(str);
        JsonObject jsonObject = new JsonObject();
        if (optional2.isPresent()) {
            jsonObject.addProperty(JwtNames.HEADER_KEY_ID, optional2.get());
        }
        jsonObject.addProperty(JwtNames.HEADER_ALGORITHM, str);
        if (optional.isPresent()) {
            jsonObject.addProperty("typ", optional.get());
        }
        return Base64.urlSafeEncode(jsonObject.toString().getBytes(Util.UTF_8));
    }

    private static void validateKidInHeader(String str, JsonObject jsonObject) throws JwtInvalidException {
        if (!getStringHeader(jsonObject, JwtNames.HEADER_KEY_ID).equals(str)) {
            throw new JwtInvalidException("invalid kid in header");
        }
    }

    public static void validateHeader(JsonObject jsonObject, String str, Optional<String> optional, boolean z) throws GeneralSecurityException {
        String stringHeader = getStringHeader(jsonObject, JwtNames.HEADER_ALGORITHM);
        if (!stringHeader.equals(str)) {
            throw new InvalidAlgorithmParameterException(String.format("invalid algorithm; expected %s, got %s", str, stringHeader));
        }
        if (jsonObject.has(JwtNames.HEADER_CRITICAL)) {
            throw new JwtInvalidException("all tokens with crit headers are rejected");
        }
        boolean zHas = jsonObject.has(JwtNames.HEADER_KEY_ID);
        if (zHas || !z) {
            if (!zHas && !z) {
                throw new JwtInvalidException("missing kid in header");
            }
            if (optional.isPresent() && !getStringHeader(jsonObject, JwtNames.HEADER_KEY_ID).equals(optional.get())) {
                throw new JwtInvalidException("invalid kid in header");
            }
        }
    }

    public static void validateHeader(String str, Optional<String> optional, Optional<String> optional2, JsonObject jsonObject) throws JwtInvalidException, InvalidAlgorithmParameterException {
        validateAlgorithm(str);
        String stringHeader = getStringHeader(jsonObject, JwtNames.HEADER_ALGORITHM);
        if (!stringHeader.equals(str)) {
            throw new InvalidAlgorithmParameterException(String.format("invalid algorithm; expected %s, got %s", str, stringHeader));
        }
        if (jsonObject.has(JwtNames.HEADER_CRITICAL)) {
            throw new JwtInvalidException("all tokens with crit headers are rejected");
        }
        if (optional.isPresent() && optional2.isPresent()) {
            throw new JwtInvalidException("custom_kid can only be set for RAW keys.");
        }
        boolean zHas = jsonObject.has(JwtNames.HEADER_KEY_ID);
        if (optional.isPresent()) {
            if (!zHas) {
                throw new JwtInvalidException("missing kid in header");
            }
            validateKidInHeader(optional.get(), jsonObject);
        }
        if (optional2.isPresent() && zHas) {
            validateKidInHeader(optional2.get(), jsonObject);
        }
    }

    public static Optional<String> getTypeHeader(JsonObject jsonObject) throws JwtInvalidException {
        if (jsonObject.has("typ")) {
            return Optional.of(getStringHeader(jsonObject, "typ"));
        }
        return Optional.empty();
    }

    public static String getStringHeader(JsonObject jsonObject, String str) throws JwtInvalidException {
        if (!jsonObject.has(str)) {
            throw new JwtInvalidException("header " + str + " does not exist");
        }
        if (!jsonObject.get(str).isJsonPrimitive() || !jsonObject.get(str).getAsJsonPrimitive().isString()) {
            throw new JwtInvalidException("header " + str + " is not a string");
        }
        return jsonObject.get(str).getAsString();
    }

    public static String decodeHeader(String str) throws JwtInvalidException {
        byte[] bArrStrictUrlSafeDecode = strictUrlSafeDecode(str);
        validateUtf8(bArrStrictUrlSafeDecode);
        return new String(bArrStrictUrlSafeDecode, Util.UTF_8);
    }

    public static String encodePayload(String str) {
        return Base64.urlSafeEncode(str.getBytes(Util.UTF_8));
    }

    public static String decodePayload(String str) throws JwtInvalidException {
        byte[] bArrStrictUrlSafeDecode = strictUrlSafeDecode(str);
        validateUtf8(bArrStrictUrlSafeDecode);
        return new String(bArrStrictUrlSafeDecode, Util.UTF_8);
    }

    public static String encodeSignature(byte[] bArr) {
        return Base64.urlSafeEncode(bArr);
    }

    public static byte[] decodeSignature(String str) throws JwtInvalidException {
        return strictUrlSafeDecode(str);
    }

    public static Optional<String> getKid(int i, OutputPrefixType outputPrefixType) throws JwtInvalidException {
        if (outputPrefixType == OutputPrefixType.RAW) {
            return Optional.empty();
        }
        if (outputPrefixType == OutputPrefixType.TINK) {
            return Optional.of(Base64.urlSafeEncode(ByteBuffer.allocate(4).putInt(i).array()));
        }
        throw new JwtInvalidException("unsupported output prefix type");
    }

    public static Optional<Integer> getKeyId(String str) {
        byte[] bArrUrlSafeDecode = Base64.urlSafeDecode(str);
        if (bArrUrlSafeDecode.length != 4) {
            return Optional.empty();
        }
        return Optional.of(Integer.valueOf(ByteBuffer.wrap(bArrUrlSafeDecode).getInt()));
    }

    public static Parts splitSignedCompact(String str) throws JwtInvalidException {
        validateASCII(str);
        int iLastIndexOf = str.lastIndexOf(46);
        if (iLastIndexOf < 0) {
            throw new JwtInvalidException("only tokens in JWS compact serialization format are supported");
        }
        String strSubstring = str.substring(0, iLastIndexOf);
        byte[] bArrDecodeSignature = decodeSignature(str.substring(iLastIndexOf + 1));
        int iIndexOf = strSubstring.indexOf(46);
        if (iIndexOf < 0) {
            throw new JwtInvalidException("only tokens in JWS compact serialization format are supported");
        }
        String strSubstring2 = strSubstring.substring(0, iIndexOf);
        String strSubstring3 = strSubstring.substring(iIndexOf + 1);
        if (strSubstring3.indexOf(46) > 0) {
            throw new JwtInvalidException("only tokens in JWS compact serialization format are supported");
        }
        return new Parts(strSubstring, bArrDecodeSignature, decodeHeader(strSubstring2), decodePayload(strSubstring3));
    }

    public static String createUnsignedCompact(String str, Optional<String> optional, RawJwt rawJwt) throws JwtInvalidException, InvalidAlgorithmParameterException {
        String jsonPayload = rawJwt.getJsonPayload();
        return createHeader(str, rawJwt.hasTypeHeader() ? Optional.of(rawJwt.getTypeHeader()) : Optional.empty(), optional) + "." + encodePayload(jsonPayload);
    }

    public static String createSignedCompact(String str, byte[] bArr) {
        return str + "." + encodeSignature(bArr);
    }

    public static void validateASCII(String str) throws JwtInvalidException {
        for (int i = 0; i < str.length(); i++) {
            if ((str.charAt(i) & 128) > 0) {
                throw new JwtInvalidException("Non ascii character");
            }
        }
    }
}
