package com.google.crypto.tink.mac.internal;

import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.Mac;
import com.google.crypto.tink.internal.KeyManagerRegistry;
import com.google.crypto.tink.internal.LegacyProtoKey;
import com.google.crypto.tink.internal.OutputPrefixUtil;
import com.google.crypto.tink.internal.ProtoKeySerialization;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.subtle.Bytes;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class LegacyFullMac implements Mac {
    static final int MIN_TAG_SIZE_IN_BYTES = 10;
    private static final byte[] formatVersion = {0};
    private final byte[] identifier;
    private final OutputPrefixType outputPrefixType;
    private final Mac rawMac;

    public static Mac create(LegacyProtoKey legacyProtoKey) throws GeneralSecurityException {
        byte[] byteArray;
        ProtoKeySerialization serialization = legacyProtoKey.getSerialization(InsecureSecretKeyAccess.get());
        Mac mac = (Mac) KeyManagerRegistry.globalInstance().getKeyManager(serialization.getTypeUrl(), Mac.class).getPrimitive(serialization.getValue());
        OutputPrefixType outputPrefixType = serialization.getOutputPrefixType();
        int i = AnonymousClass1.$SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[outputPrefixType.ordinal()];
        if (i == 1) {
            byteArray = OutputPrefixUtil.EMPTY_PREFIX.toByteArray();
        } else if (i == 2 || i == 3) {
            byteArray = OutputPrefixUtil.getLegacyOutputPrefix(legacyProtoKey.getIdRequirementOrNull().intValue()).toByteArray();
        } else if (i == 4) {
            byteArray = OutputPrefixUtil.getTinkOutputPrefix(legacyProtoKey.getIdRequirementOrNull().intValue()).toByteArray();
        } else {
            throw new GeneralSecurityException("unknown output prefix type");
        }
        return new LegacyFullMac(mac, outputPrefixType, byteArray);
    }

    /* JADX INFO: renamed from: com.google.crypto.tink.mac.internal.LegacyFullMac$1, reason: invalid class name */
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

    private LegacyFullMac(Mac mac, OutputPrefixType outputPrefixType, byte[] bArr) {
        this.rawMac = mac;
        this.outputPrefixType = outputPrefixType;
        this.identifier = bArr;
    }

    @Override // com.google.crypto.tink.Mac
    public byte[] computeMac(byte[] bArr) throws GeneralSecurityException {
        if (this.outputPrefixType.equals(OutputPrefixType.LEGACY)) {
            bArr = Bytes.concat(bArr, formatVersion);
        }
        return Bytes.concat(this.identifier, this.rawMac.computeMac(bArr));
    }

    @Override // com.google.crypto.tink.Mac
    public void verifyMac(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length < 10) {
            throw new GeneralSecurityException("tag too short");
        }
        if (this.outputPrefixType.equals(OutputPrefixType.LEGACY)) {
            bArr2 = Bytes.concat(bArr2, formatVersion);
        }
        byte[] bArr3 = new byte[0];
        if (!this.outputPrefixType.equals(OutputPrefixType.RAW)) {
            byte[] bArrCopyOf = Arrays.copyOf(bArr, 5);
            bArr = Arrays.copyOfRange(bArr, 5, bArr.length);
            bArr3 = bArrCopyOf;
        }
        if (!Arrays.equals(this.identifier, bArr3)) {
            throw new GeneralSecurityException("wrong prefix");
        }
        this.rawMac.verifyMac(bArr, bArr2);
    }
}
