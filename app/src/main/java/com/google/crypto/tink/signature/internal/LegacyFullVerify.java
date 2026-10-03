package com.google.crypto.tink.signature.internal;

import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.PublicKeyVerify;
import com.google.crypto.tink.internal.KeyManagerRegistry;
import com.google.crypto.tink.internal.LegacyProtoKey;
import com.google.crypto.tink.internal.OutputPrefixUtil;
import com.google.crypto.tink.internal.ProtoKeySerialization;
import com.google.crypto.tink.internal.Util;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.subtle.Bytes;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
@Immutable
public final class LegacyFullVerify implements PublicKeyVerify {
    private final byte[] messageSuffix;
    private final byte[] outputPrefix;
    private final PublicKeyVerify rawVerifier;

    public static PublicKeyVerify create(LegacyProtoKey legacyProtoKey) throws GeneralSecurityException {
        ProtoKeySerialization serialization = legacyProtoKey.getSerialization(InsecureSecretKeyAccess.get());
        return new LegacyFullVerify((PublicKeyVerify) KeyManagerRegistry.globalInstance().getKeyManager(serialization.getTypeUrl(), PublicKeyVerify.class).getPrimitive(serialization.getValue()), getOutputPrefix(serialization), getMessageSuffix(serialization));
    }

    /* JADX INFO: renamed from: com.google.crypto.tink.signature.internal.LegacyFullVerify$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType;

        static {
            int[] iArr = new int[OutputPrefixType.values().length];
            $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType = iArr;
            try {
                iArr[OutputPrefixType.LEGACY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[OutputPrefixType.CRUNCHY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[OutputPrefixType.TINK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[OutputPrefixType.RAW.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static byte[] getOutputPrefix(ProtoKeySerialization protoKeySerialization) throws GeneralSecurityException {
        int i = AnonymousClass1.$SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[protoKeySerialization.getOutputPrefixType().ordinal()];
        if (i == 1 || i == 2) {
            return OutputPrefixUtil.getLegacyOutputPrefix(protoKeySerialization.getIdRequirementOrNull().intValue()).toByteArray();
        }
        if (i == 3) {
            return OutputPrefixUtil.getTinkOutputPrefix(protoKeySerialization.getIdRequirementOrNull().intValue()).toByteArray();
        }
        if (i == 4) {
            return OutputPrefixUtil.EMPTY_PREFIX.toByteArray();
        }
        throw new GeneralSecurityException("unknown output prefix type");
    }

    static byte[] getMessageSuffix(ProtoKeySerialization protoKeySerialization) {
        if (protoKeySerialization.getOutputPrefixType().equals(OutputPrefixType.LEGACY)) {
            return new byte[]{0};
        }
        return new byte[0];
    }

    private LegacyFullVerify(PublicKeyVerify publicKeyVerify, byte[] bArr, byte[] bArr2) {
        this.rawVerifier = publicKeyVerify;
        this.outputPrefix = bArr;
        this.messageSuffix = bArr2;
    }

    @Override // com.google.crypto.tink.PublicKeyVerify
    public void verify(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.outputPrefix;
        if (bArr3.length == 0 && this.messageSuffix.length == 0) {
            this.rawVerifier.verify(bArr, bArr2);
            return;
        }
        if (!Util.isPrefix(bArr3, bArr)) {
            throw new GeneralSecurityException("Invalid signature (output prefix mismatch)");
        }
        byte[] bArr4 = this.messageSuffix;
        if (bArr4.length != 0) {
            bArr2 = Bytes.concat(bArr2, bArr4);
        }
        this.rawVerifier.verify(Arrays.copyOfRange(bArr, this.outputPrefix.length, bArr.length), bArr2);
    }
}
