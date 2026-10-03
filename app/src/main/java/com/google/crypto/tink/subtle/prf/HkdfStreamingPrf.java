package com.google.crypto.tink.subtle.prf;

import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.internal.EnumTypeProtoConverter;
import com.google.crypto.tink.prf.HkdfPrfKey;
import com.google.crypto.tink.prf.HkdfPrfParameters;
import com.google.crypto.tink.subtle.EngineFactory;
import com.google.crypto.tink.subtle.Enums;
import com.google.crypto.tink.util.Bytes;
import com.google.errorprone.annotations.Immutable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes3.dex */
@Immutable
public class HkdfStreamingPrf implements StreamingPrf {
    private static final EnumTypeProtoConverter<Enums.HashType, HkdfPrfParameters.HashType> HASH_TYPE_CONVERTER = EnumTypeProtoConverter.builder().add(Enums.HashType.SHA1, HkdfPrfParameters.HashType.SHA1).add(Enums.HashType.SHA224, HkdfPrfParameters.HashType.SHA224).add(Enums.HashType.SHA256, HkdfPrfParameters.HashType.SHA256).add(Enums.HashType.SHA384, HkdfPrfParameters.HashType.SHA384).add(Enums.HashType.SHA512, HkdfPrfParameters.HashType.SHA512).build();
    private final Enums.HashType hashType;
    private final byte[] ikm;
    private final byte[] salt;

    /* JADX INFO: Access modifiers changed from: private */
    public static Buffer toBuffer(ByteBuffer byteBuffer) {
        return byteBuffer;
    }

    /* JADX INFO: renamed from: com.google.crypto.tink.subtle.prf.HkdfStreamingPrf$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType;

        static {
            int[] iArr = new int[Enums.HashType.values().length];
            $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType = iArr;
            try {
                iArr[Enums.HashType.SHA1.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType[Enums.HashType.SHA256.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType[Enums.HashType.SHA384.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType[Enums.HashType.SHA512.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getJavaxHmacName(Enums.HashType hashType) throws GeneralSecurityException {
        int i = AnonymousClass1.$SwitchMap$com$google$crypto$tink$subtle$Enums$HashType[hashType.ordinal()];
        if (i == 1) {
            return "HmacSha1";
        }
        if (i == 2) {
            return "HmacSha256";
        }
        if (i == 3) {
            return "HmacSha384";
        }
        if (i == 4) {
            return "HmacSha512";
        }
        throw new GeneralSecurityException("No getJavaxHmacName for given hash " + hashType + " known");
    }

    public HkdfStreamingPrf(Enums.HashType hashType, byte[] bArr, byte[] bArr2) {
        this.hashType = hashType;
        this.ikm = Arrays.copyOf(bArr, bArr.length);
        this.salt = Arrays.copyOf(bArr2, bArr2.length);
    }

    public static StreamingPrf create(HkdfPrfKey hkdfPrfKey) throws GeneralSecurityException {
        Bytes salt = hkdfPrfKey.getParameters().getSalt();
        return new HkdfStreamingPrf((Enums.HashType) HASH_TYPE_CONVERTER.toProtoEnum(hkdfPrfKey.getParameters().getHashType()), hkdfPrfKey.getKeyBytes().toByteArray(InsecureSecretKeyAccess.get()), salt == null ? new byte[0] : salt.toByteArray());
    }

    class HkdfInputStream extends InputStream {
        private ByteBuffer buffer;
        private int ctr = -1;
        private final byte[] input;
        private Mac mac;
        private byte[] prk;

        public HkdfInputStream(byte[] bArr) {
            this.input = Arrays.copyOf(bArr, bArr.length);
        }

        private void initialize() throws GeneralSecurityException, IOException {
            try {
                this.mac = EngineFactory.MAC.getInstance(HkdfStreamingPrf.getJavaxHmacName(HkdfStreamingPrf.this.hashType));
                if (HkdfStreamingPrf.this.salt == null || HkdfStreamingPrf.this.salt.length == 0) {
                    this.mac.init(new SecretKeySpec(new byte[this.mac.getMacLength()], HkdfStreamingPrf.getJavaxHmacName(HkdfStreamingPrf.this.hashType)));
                } else {
                    this.mac.init(new SecretKeySpec(HkdfStreamingPrf.this.salt, HkdfStreamingPrf.getJavaxHmacName(HkdfStreamingPrf.this.hashType)));
                }
                this.mac.update(HkdfStreamingPrf.this.ikm);
                this.prk = this.mac.doFinal();
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(0);
                this.buffer = byteBufferAllocate;
                HkdfStreamingPrf.toBuffer(byteBufferAllocate).mark();
                this.ctr = 0;
            } catch (GeneralSecurityException e) {
                throw new IOException("Creating HMac failed", e);
            }
        }

        private void updateBuffer() throws GeneralSecurityException, IOException {
            this.mac.init(new SecretKeySpec(this.prk, HkdfStreamingPrf.getJavaxHmacName(HkdfStreamingPrf.this.hashType)));
            HkdfStreamingPrf.toBuffer(this.buffer).reset();
            this.mac.update(this.buffer);
            this.mac.update(this.input);
            int i = this.ctr + 1;
            this.ctr = i;
            this.mac.update((byte) i);
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(this.mac.doFinal());
            this.buffer = byteBufferWrap;
            HkdfStreamingPrf.toBuffer(byteBufferWrap).mark();
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            byte[] bArr = new byte[1];
            int i = read(bArr, 0, 1);
            if (i == 1) {
                return bArr[0] & 255;
            }
            if (i == -1) {
                return i;
            }
            throw new IOException("Reading failed");
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr) throws IOException {
            return read(bArr, 0, bArr.length);
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            try {
                if (this.ctr == -1) {
                    initialize();
                }
                int i3 = 0;
                while (i3 < i2) {
                    if (!this.buffer.hasRemaining()) {
                        if (this.ctr == 255) {
                            return i3;
                        }
                        updateBuffer();
                    }
                    int iMin = Math.min(i2 - i3, this.buffer.remaining());
                    this.buffer.get(bArr, i, iMin);
                    i += iMin;
                    i3 += iMin;
                }
                return i3;
            } catch (GeneralSecurityException e) {
                this.mac = null;
                throw new IOException("HkdfInputStream failed", e);
            }
        }
    }

    @Override // com.google.crypto.tink.subtle.prf.StreamingPrf
    public InputStream computePrf(byte[] bArr) {
        return new HkdfInputStream(bArr);
    }
}
