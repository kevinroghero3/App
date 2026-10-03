package com.google.crypto.tink.hybrid.internal;

import com.google.crypto.tink.HybridDecrypt;
import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.internal.KeyManagerRegistry;
import com.google.crypto.tink.internal.LegacyProtoKey;
import com.google.crypto.tink.internal.OutputPrefixUtil;
import com.google.crypto.tink.internal.ProtoKeySerialization;
import com.google.crypto.tink.internal.Util;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
@Immutable
public final class LegacyFullHybridDecrypt implements HybridDecrypt {
    private final byte[] outputPrefix;
    private final HybridDecrypt rawHybridDecrypt;

    public static HybridDecrypt create(LegacyProtoKey legacyProtoKey) throws GeneralSecurityException {
        byte[] byteArray;
        ProtoKeySerialization serialization = legacyProtoKey.getSerialization(InsecureSecretKeyAccess.get());
        HybridDecrypt hybridDecrypt = (HybridDecrypt) KeyManagerRegistry.globalInstance().getKeyManager(serialization.getTypeUrl(), HybridDecrypt.class).getPrimitive(serialization.getValue());
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
        return new LegacyFullHybridDecrypt(hybridDecrypt, byteArray);
    }

    /* JADX INFO: renamed from: com.google.crypto.tink.hybrid.internal.LegacyFullHybridDecrypt$1, reason: invalid class name */
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

    private LegacyFullHybridDecrypt(HybridDecrypt hybridDecrypt, byte[] bArr) {
        this.rawHybridDecrypt = hybridDecrypt;
        this.outputPrefix = bArr;
    }

    @Override // com.google.crypto.tink.HybridDecrypt
    public byte[] decrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.outputPrefix;
        if (bArr3.length == 0) {
            return this.rawHybridDecrypt.decrypt(bArr, bArr2);
        }
        if (!Util.isPrefix(bArr3, bArr)) {
            throw new GeneralSecurityException("Invalid ciphertext (output prefix mismatch)");
        }
        return this.rawHybridDecrypt.decrypt(Arrays.copyOfRange(bArr, this.outputPrefix.length, bArr.length), bArr2);
    }
}
