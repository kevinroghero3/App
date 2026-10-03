package com.google.crypto.tink.subtle;

import android.os.Process;
import com.google.crypto.tink.PublicKeyVerify;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.internal.Ed25519;
import com.google.crypto.tink.internal.Util;
import com.google.crypto.tink.signature.Ed25519Parameters;
import com.google.crypto.tink.signature.Ed25519PublicKey;
import com.google.crypto.tink.signature.internal.Ed25519VerifyJce;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
@Immutable
public final class Ed25519Verify implements PublicKeyVerify {
    public static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_NOT_FIPS;
    public static final int PUBLIC_KEY_LEN = 32;
    public static final int SIGNATURE_LEN = 64;
    private final PublicKeyVerify impl;

    public static PublicKeyVerify create(Ed25519PublicKey ed25519PublicKey) throws GeneralSecurityException {
        byte[] bArr;
        if (!FIPS.isCompatible()) {
            throw new GeneralSecurityException("Can not use Ed25519 in FIPS-mode.");
        }
        try {
            return Ed25519VerifyJce.create(ed25519PublicKey);
        } catch (GeneralSecurityException unused) {
            byte[] byteArray = ed25519PublicKey.getPublicKeyBytes().toByteArray();
            byte[] byteArray2 = ed25519PublicKey.getOutputPrefix().toByteArray();
            if (ed25519PublicKey.getParameters().getVariant().equals(Ed25519Parameters.Variant.LEGACY)) {
                bArr = new byte[]{0};
            } else {
                bArr = new byte[0];
            }
            return new PureJavaImpl(byteArray, byteArray2, bArr, null);
        }
    }

    public Ed25519Verify(byte[] bArr) {
        this.impl = new PureJavaImpl(bArr, new byte[0], new byte[0], null);
    }

    @Override // com.google.crypto.tink.PublicKeyVerify
    public void verify(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        this.impl.verify(bArr, bArr2);
    }

    @Immutable
    static final class PureJavaImpl implements PublicKeyVerify {
        private final byte[] messageSuffix;
        private final byte[] outputPrefix;
        private final byte[] publicKey;

        /* synthetic */ PureJavaImpl(byte[] bArr, byte[] bArr2, byte[] bArr3, AnonymousClass1 anonymousClass1) {
            this(bArr, bArr2, bArr3);
        }

        private PureJavaImpl(byte[] bArr, byte[] bArr2, byte[] bArr3) {
            if (!Ed25519Verify.FIPS.isCompatible()) {
                throw new IllegalStateException(new GeneralSecurityException("Can not use Ed25519 in FIPS-mode."));
            }
            if (bArr.length != 32) {
                throw new IllegalArgumentException(String.format("Given public key's length is not %s.", 32));
            }
            this.publicKey = (byte[]) bArr.clone();
            this.outputPrefix = bArr2;
            this.messageSuffix = bArr3;
            Ed25519.init();
        }

        private void noPrefixVerify(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
            if (bArr.length != 64) {
                throw new GeneralSecurityException(String.format("The length of the signature is not %s.", 64));
            }
            if (!Ed25519.verify(bArr2, bArr, this.publicKey)) {
                throw new GeneralSecurityException("Signature check failed.");
            }
        }

        @Override // com.google.crypto.tink.PublicKeyVerify
        public void verify(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
            byte[] bArr3 = this.outputPrefix;
            if (bArr3.length == 0 && this.messageSuffix.length == 0) {
                noPrefixVerify(bArr, bArr2);
            } else {
                if (!Util.isPrefix(bArr3, bArr)) {
                    throw new GeneralSecurityException("Invalid signature (output prefix mismatch)");
                }
                byte[] bArr4 = this.messageSuffix;
                if (bArr4.length != 0) {
                    bArr2 = Bytes.concat(bArr2, bArr4);
                }
                noPrefixVerify(Arrays.copyOfRange(bArr, this.outputPrefix.length, bArr.length), bArr2);
            }
        }
    }

    /* JADX INFO: renamed from: com.google.crypto.tink.subtle.Ed25519Verify$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static int MediaBrowserCompatMediaBrowserImplApi211;
        public static int MediaBrowserCompatMediaBrowserImplApi213;

        public static int cancelNotification() {
            int i = MediaBrowserCompatMediaBrowserImplApi213;
            int i2 = i % 5149284;
            MediaBrowserCompatMediaBrowserImplApi213 = i + 1;
            if (i2 != 0) {
                return MediaBrowserCompatMediaBrowserImplApi211;
            }
            int iMyUid = Process.myUid();
            MediaBrowserCompatMediaBrowserImplApi211 = iMyUid;
            return iMyUid;
        }
    }
}
