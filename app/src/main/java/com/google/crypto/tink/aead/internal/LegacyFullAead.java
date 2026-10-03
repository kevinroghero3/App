package com.google.crypto.tink.aead.internal;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.internal.KeyManagerRegistry;
import com.google.crypto.tink.internal.LegacyProtoKey;
import com.google.crypto.tink.internal.OutputPrefixUtil;
import com.google.crypto.tink.internal.ProtoKeySerialization;
import com.google.crypto.tink.internal.Util;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.util.Bytes;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class LegacyFullAead implements Aead {
    private final byte[] identifier;
    private final Aead rawAead;

    public static Aead create(LegacyProtoKey legacyProtoKey) throws GeneralSecurityException {
        byte[] byteArray;
        ProtoKeySerialization serialization = legacyProtoKey.getSerialization(InsecureSecretKeyAccess.get());
        Aead aead = (Aead) KeyManagerRegistry.globalInstance().getKeyManager(serialization.getTypeUrl(), Aead.class).getPrimitive(serialization.getValue());
        OutputPrefixType outputPrefixType = serialization.getOutputPrefixType();
        int i = AnonymousClass1.$SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[outputPrefixType.ordinal()];
        if (i == 1) {
            byteArray = OutputPrefixUtil.EMPTY_PREFIX.toByteArray();
        } else if (i == 2 || i == 3) {
            byteArray = OutputPrefixUtil.getLegacyOutputPrefix(legacyProtoKey.getIdRequirementOrNull().intValue()).toByteArray();
        } else if (i == 4) {
            byteArray = OutputPrefixUtil.getTinkOutputPrefix(legacyProtoKey.getIdRequirementOrNull().intValue()).toByteArray();
        } else {
            throw new GeneralSecurityException("unknown output prefix type " + outputPrefixType);
        }
        return new LegacyFullAead(aead, byteArray);
    }

    /* JADX INFO: renamed from: com.google.crypto.tink.aead.internal.LegacyFullAead$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType;

        static {
            int[] iArr = new int[OutputPrefixType.values().length];
            $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType = iArr;
            try {
                iArr[OutputPrefixType.RAW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[OutputPrefixType.LEGACY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[OutputPrefixType.CRUNCHY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[OutputPrefixType.TINK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static Aead create(Aead aead, Bytes bytes) {
        return new LegacyFullAead(aead, bytes.toByteArray());
    }

    private LegacyFullAead(Aead aead, byte[] bArr) {
        this.rawAead = aead;
        if (bArr.length != 0 && bArr.length != 5) {
            throw new IllegalArgumentException("identifier has an invalid length");
        }
        this.identifier = bArr;
    }

    @Override // com.google.crypto.tink.Aead
    public byte[] encrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.identifier;
        if (bArr3.length == 0) {
            return this.rawAead.encrypt(bArr, bArr2);
        }
        return com.google.crypto.tink.subtle.Bytes.concat(bArr3, this.rawAead.encrypt(bArr, bArr2));
    }

    @Override // com.google.crypto.tink.Aead
    public byte[] decrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.identifier;
        if (bArr3.length == 0) {
            return this.rawAead.decrypt(bArr, bArr2);
        }
        if (!Util.isPrefix(bArr3, bArr)) {
            throw new GeneralSecurityException("wrong prefix");
        }
        return this.rawAead.decrypt(Arrays.copyOfRange(bArr, 5, bArr.length), bArr2);
    }
}
