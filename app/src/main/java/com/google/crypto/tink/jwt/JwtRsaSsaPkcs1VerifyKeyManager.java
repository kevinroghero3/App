package com.google.crypto.tink.jwt;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.PublicKeyVerify;
import com.google.crypto.tink.internal.PrimitiveConstructor;
import com.google.crypto.tink.jwt.internal.JsonUtil;
import com.google.crypto.tink.jwt.internal.JwtFormat;
import com.google.crypto.tink.signature.RsaSsaPkcs1PublicKey;
import com.google.crypto.tink.subtle.RsaSsaPkcs1VerifyJce;
import com.google.gson.JsonObject;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes5.dex */
final class JwtRsaSsaPkcs1VerifyKeyManager {
    static final PrimitiveConstructor<JwtRsaSsaPkcs1PublicKey, JwtPublicKeyVerify> PRIMITIVE_CONSTRUCTOR = PrimitiveConstructor.create(new PrimitiveConstructor.PrimitiveConstructionFunction() { // from class: com.google.crypto.tink.jwt.JwtRsaSsaPkcs1VerifyKeyManager$$ExternalSyntheticLambda0
        @Override // com.google.crypto.tink.internal.PrimitiveConstructor.PrimitiveConstructionFunction
        public final Object constructPrimitive(Key key) {
            return JwtRsaSsaPkcs1VerifyKeyManager.createFullPrimitive((JwtRsaSsaPkcs1PublicKey) key);
        }
    }, JwtRsaSsaPkcs1PublicKey.class, JwtPublicKeyVerify.class);

    static RsaSsaPkcs1PublicKey toRsaSsaPkcs1PublicKey(JwtRsaSsaPkcs1PublicKey jwtRsaSsaPkcs1PublicKey) {
        return jwtRsaSsaPkcs1PublicKey.getRsaSsaPkcs1PublicKey();
    }

    static JwtPublicKeyVerify createFullPrimitive(final JwtRsaSsaPkcs1PublicKey jwtRsaSsaPkcs1PublicKey) throws GeneralSecurityException {
        final PublicKeyVerify publicKeyVerifyCreate = RsaSsaPkcs1VerifyJce.create(toRsaSsaPkcs1PublicKey(jwtRsaSsaPkcs1PublicKey));
        return new JwtPublicKeyVerify() { // from class: com.google.crypto.tink.jwt.JwtRsaSsaPkcs1VerifyKeyManager.1
            @Override // com.google.crypto.tink.jwt.JwtPublicKeyVerify
            public VerifiedJwt verifyAndDecode(String str, JwtValidator jwtValidator) throws GeneralSecurityException {
                JwtFormat.Parts partsSplitSignedCompact = JwtFormat.splitSignedCompact(str);
                publicKeyVerifyCreate.verify(partsSplitSignedCompact.signatureOrMac, partsSplitSignedCompact.unsignedCompact.getBytes(StandardCharsets.US_ASCII));
                JsonObject json = JsonUtil.parseJson(partsSplitSignedCompact.header);
                JwtFormat.validateHeader(json, jwtRsaSsaPkcs1PublicKey.getParameters().getAlgorithm().getStandardName(), jwtRsaSsaPkcs1PublicKey.getKid(), jwtRsaSsaPkcs1PublicKey.getParameters().allowKidAbsent());
                return jwtValidator.validate(RawJwt.fromJsonPayload(JwtFormat.getTypeHeader(json), partsSplitSignedCompact.payload));
            }
        };
    }

    static String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.JwtRsaSsaPkcs1PublicKey";
    }

    private JwtRsaSsaPkcs1VerifyKeyManager() {
    }
}
