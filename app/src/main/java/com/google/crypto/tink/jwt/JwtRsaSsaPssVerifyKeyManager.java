package com.google.crypto.tink.jwt;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.PublicKeyVerify;
import com.google.crypto.tink.internal.PrimitiveConstructor;
import com.google.crypto.tink.jwt.internal.JsonUtil;
import com.google.crypto.tink.jwt.internal.JwtFormat;
import com.google.crypto.tink.signature.RsaSsaPssPublicKey;
import com.google.crypto.tink.subtle.RsaSsaPssVerifyJce;
import com.google.gson.JsonObject;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes5.dex */
final class JwtRsaSsaPssVerifyKeyManager {
    static final PrimitiveConstructor<JwtRsaSsaPssPublicKey, JwtPublicKeyVerify> PRIMITIVE_CONSTRUCTOR = PrimitiveConstructor.create(new PrimitiveConstructor.PrimitiveConstructionFunction() { // from class: com.google.crypto.tink.jwt.JwtRsaSsaPssVerifyKeyManager$$ExternalSyntheticLambda0
        @Override // com.google.crypto.tink.internal.PrimitiveConstructor.PrimitiveConstructionFunction
        public final Object constructPrimitive(Key key) {
            return JwtRsaSsaPssVerifyKeyManager.createFullPrimitive((JwtRsaSsaPssPublicKey) key);
        }
    }, JwtRsaSsaPssPublicKey.class, JwtPublicKeyVerify.class);

    static RsaSsaPssPublicKey toRsaSsaPssPublicKey(JwtRsaSsaPssPublicKey jwtRsaSsaPssPublicKey) {
        return jwtRsaSsaPssPublicKey.getRsaSsaPssPublicKey();
    }

    static JwtPublicKeyVerify createFullPrimitive(final JwtRsaSsaPssPublicKey jwtRsaSsaPssPublicKey) throws GeneralSecurityException {
        final PublicKeyVerify publicKeyVerifyCreate = RsaSsaPssVerifyJce.create(toRsaSsaPssPublicKey(jwtRsaSsaPssPublicKey));
        return new JwtPublicKeyVerify() { // from class: com.google.crypto.tink.jwt.JwtRsaSsaPssVerifyKeyManager.1
            @Override // com.google.crypto.tink.jwt.JwtPublicKeyVerify
            public VerifiedJwt verifyAndDecode(String str, JwtValidator jwtValidator) throws GeneralSecurityException {
                JwtFormat.Parts partsSplitSignedCompact = JwtFormat.splitSignedCompact(str);
                publicKeyVerifyCreate.verify(partsSplitSignedCompact.signatureOrMac, partsSplitSignedCompact.unsignedCompact.getBytes(StandardCharsets.US_ASCII));
                JsonObject json = JsonUtil.parseJson(partsSplitSignedCompact.header);
                JwtFormat.validateHeader(json, jwtRsaSsaPssPublicKey.getParameters().getAlgorithm().getStandardName(), jwtRsaSsaPssPublicKey.getKid(), jwtRsaSsaPssPublicKey.getParameters().allowKidAbsent());
                return jwtValidator.validate(RawJwt.fromJsonPayload(JwtFormat.getTypeHeader(json), partsSplitSignedCompact.payload));
            }
        };
    }

    static String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.JwtRsaSsaPssPublicKey";
    }

    private JwtRsaSsaPssVerifyKeyManager() {
    }
}
