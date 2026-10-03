package com.google.crypto.tink.subtle;

import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.StreamingAead;
import com.google.crypto.tink.streamingaead.AesGcmHkdfStreamingKey;
import com.google.crypto.tink.streamingaead.AesGcmHkdfStreamingParameters;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes3.dex */
public final class AesGcmHkdfStreaming extends NonceBasedStreamingAead {
    private static final int NONCE_PREFIX_IN_BYTES = 7;
    private static final int NONCE_SIZE_IN_BYTES = 12;
    private static final int TAG_SIZE_IN_BYTES = 16;
    private final int ciphertextSegmentSize;
    private final int firstSegmentOffset;
    private final String hkdfAlg;
    private final byte[] ikm;
    private final int keySizeInBytes;
    private final int plaintextSegmentSize;

    /* JADX INFO: Access modifiers changed from: private */
    public static Buffer toBuffer(ByteBuffer byteBuffer) {
        return byteBuffer;
    }

    @Override // com.google.crypto.tink.subtle.NonceBasedStreamingAead
    public int getCiphertextOverhead() {
        return 16;
    }

    @Override // com.google.crypto.tink.subtle.NonceBasedStreamingAead, com.google.crypto.tink.StreamingAead
    public /* bridge */ /* synthetic */ ReadableByteChannel newDecryptingChannel(ReadableByteChannel readableByteChannel, byte[] bArr) throws GeneralSecurityException, IOException {
        return super.newDecryptingChannel(readableByteChannel, bArr);
    }

    @Override // com.google.crypto.tink.subtle.NonceBasedStreamingAead, com.google.crypto.tink.StreamingAead
    public /* bridge */ /* synthetic */ InputStream newDecryptingStream(InputStream inputStream, byte[] bArr) throws GeneralSecurityException, IOException {
        return super.newDecryptingStream(inputStream, bArr);
    }

    @Override // com.google.crypto.tink.subtle.NonceBasedStreamingAead, com.google.crypto.tink.StreamingAead
    public /* bridge */ /* synthetic */ WritableByteChannel newEncryptingChannel(WritableByteChannel writableByteChannel, byte[] bArr) throws GeneralSecurityException, IOException {
        return super.newEncryptingChannel(writableByteChannel, bArr);
    }

    @Override // com.google.crypto.tink.subtle.NonceBasedStreamingAead, com.google.crypto.tink.StreamingAead
    public /* bridge */ /* synthetic */ OutputStream newEncryptingStream(OutputStream outputStream, byte[] bArr) throws GeneralSecurityException, IOException {
        return super.newEncryptingStream(outputStream, bArr);
    }

    @Override // com.google.crypto.tink.subtle.NonceBasedStreamingAead, com.google.crypto.tink.StreamingAead
    public /* bridge */ /* synthetic */ SeekableByteChannel newSeekableDecryptingChannel(SeekableByteChannel seekableByteChannel, byte[] bArr) throws GeneralSecurityException, IOException {
        return super.newSeekableDecryptingChannel(seekableByteChannel, bArr);
    }

    public AesGcmHkdfStreaming(byte[] bArr, String str, int i, int i2, int i3) throws InvalidAlgorithmParameterException {
        if (bArr.length < 16 || bArr.length < i) {
            throw new InvalidAlgorithmParameterException("ikm too short, must be >= " + Math.max(16, i));
        }
        Validators.validateAesKeySize(i);
        if (i2 <= getHeaderLength() + i3 + 16) {
            throw new InvalidAlgorithmParameterException("ciphertextSegmentSize too small");
        }
        this.ikm = Arrays.copyOf(bArr, bArr.length);
        this.hkdfAlg = str;
        this.keySizeInBytes = i;
        this.ciphertextSegmentSize = i2;
        this.firstSegmentOffset = i3;
        this.plaintextSegmentSize = i2 - 16;
    }

    private AesGcmHkdfStreaming(AesGcmHkdfStreamingKey aesGcmHkdfStreamingKey) throws GeneralSecurityException {
        String str;
        this.ikm = aesGcmHkdfStreamingKey.getInitialKeyMaterial().toByteArray(InsecureSecretKeyAccess.get());
        if (aesGcmHkdfStreamingKey.getParameters().getHkdfHashType().equals(AesGcmHkdfStreamingParameters.HashType.SHA1)) {
            str = "HmacSha1";
        } else if (aesGcmHkdfStreamingKey.getParameters().getHkdfHashType().equals(AesGcmHkdfStreamingParameters.HashType.SHA256)) {
            str = "HmacSha256";
        } else if (aesGcmHkdfStreamingKey.getParameters().getHkdfHashType().equals(AesGcmHkdfStreamingParameters.HashType.SHA512)) {
            str = "HmacSha512";
        } else {
            throw new GeneralSecurityException("Unknown HKDF algorithm " + aesGcmHkdfStreamingKey.getParameters().getHkdfHashType());
        }
        this.hkdfAlg = str;
        this.keySizeInBytes = aesGcmHkdfStreamingKey.getParameters().getDerivedAesGcmKeySizeBytes();
        int ciphertextSegmentSizeBytes = aesGcmHkdfStreamingKey.getParameters().getCiphertextSegmentSizeBytes();
        this.ciphertextSegmentSize = ciphertextSegmentSizeBytes;
        this.firstSegmentOffset = 0;
        this.plaintextSegmentSize = ciphertextSegmentSizeBytes - 16;
    }

    public static StreamingAead create(AesGcmHkdfStreamingKey aesGcmHkdfStreamingKey) throws GeneralSecurityException {
        return new AesGcmHkdfStreaming(aesGcmHkdfStreamingKey);
    }

    @Override // com.google.crypto.tink.subtle.NonceBasedStreamingAead
    public AesGcmHkdfStreamEncrypter newStreamSegmentEncrypter(byte[] bArr) throws GeneralSecurityException {
        return new AesGcmHkdfStreamEncrypter(bArr);
    }

    @Override // com.google.crypto.tink.subtle.NonceBasedStreamingAead
    public AesGcmHkdfStreamDecrypter newStreamSegmentDecrypter() throws GeneralSecurityException {
        return new AesGcmHkdfStreamDecrypter();
    }

    @Override // com.google.crypto.tink.subtle.NonceBasedStreamingAead
    public int getPlaintextSegmentSize() {
        return this.plaintextSegmentSize;
    }

    @Override // com.google.crypto.tink.subtle.NonceBasedStreamingAead
    public int getCiphertextSegmentSize() {
        return this.ciphertextSegmentSize;
    }

    @Override // com.google.crypto.tink.subtle.NonceBasedStreamingAead
    public int getHeaderLength() {
        return this.keySizeInBytes + 8;
    }

    @Override // com.google.crypto.tink.subtle.NonceBasedStreamingAead
    public int getCiphertextOffset() {
        return getHeaderLength() + this.firstSegmentOffset;
    }

    public int getFirstSegmentOffset() {
        return this.firstSegmentOffset;
    }

    public long expectedCiphertextSize(long j) {
        long ciphertextOffset = j + ((long) getCiphertextOffset());
        long j2 = this.plaintextSegmentSize;
        long j3 = (ciphertextOffset / j2) * ((long) this.ciphertextSegmentSize);
        long j4 = ciphertextOffset % j2;
        return j4 > 0 ? j3 + j4 + 16 : j3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Cipher cipherInstance() throws GeneralSecurityException {
        return EngineFactory.CIPHER.getInstance("AES/GCM/NoPadding");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] randomSalt() {
        return Random.randBytes(this.keySizeInBytes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static GCMParameterSpec paramsForSegment(byte[] bArr, long j, boolean z) throws GeneralSecurityException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(12);
        byteBufferAllocate.order(ByteOrder.BIG_ENDIAN);
        byteBufferAllocate.put(bArr);
        SubtleUtil.putAsUnsigedInt(byteBufferAllocate, j);
        byteBufferAllocate.put(z ? (byte) 1 : (byte) 0);
        return new GCMParameterSpec(128, byteBufferAllocate.array());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] randomNonce() {
        return Random.randBytes(7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SecretKeySpec deriveKeySpec(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        return new SecretKeySpec(Hkdf.computeHkdf(this.hkdfAlg, this.ikm, bArr, bArr2, this.keySizeInBytes), "AES");
    }

    /* JADX INFO: loaded from: classes5.dex */
    class AesGcmHkdfStreamEncrypter implements StreamSegmentEncrypter {
        private final Cipher cipher = AesGcmHkdfStreaming.cipherInstance();
        private long encryptedSegments;
        private final ByteBuffer header;
        private final SecretKeySpec keySpec;
        private final byte[] noncePrefix;

        public AesGcmHkdfStreamEncrypter(byte[] bArr) throws GeneralSecurityException {
            this.encryptedSegments = 0L;
            this.encryptedSegments = 0L;
            byte[] bArrRandomSalt = AesGcmHkdfStreaming.this.randomSalt();
            byte[] bArrRandomNonce = AesGcmHkdfStreaming.randomNonce();
            this.noncePrefix = bArrRandomNonce;
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(AesGcmHkdfStreaming.this.getHeaderLength());
            this.header = byteBufferAllocate;
            byteBufferAllocate.put((byte) AesGcmHkdfStreaming.this.getHeaderLength());
            byteBufferAllocate.put(bArrRandomSalt);
            byteBufferAllocate.put(bArrRandomNonce);
            AesGcmHkdfStreaming.toBuffer(byteBufferAllocate).flip();
            this.keySpec = AesGcmHkdfStreaming.this.deriveKeySpec(bArrRandomSalt, bArr);
        }

        @Override // com.google.crypto.tink.subtle.StreamSegmentEncrypter
        public ByteBuffer getHeader() {
            return this.header.asReadOnlyBuffer();
        }

        @Override // com.google.crypto.tink.subtle.StreamSegmentEncrypter
        public void encryptSegment(ByteBuffer byteBuffer, boolean z, ByteBuffer byteBuffer2) throws GeneralSecurityException {
            synchronized (this) {
                this.cipher.init(1, this.keySpec, AesGcmHkdfStreaming.paramsForSegment(this.noncePrefix, this.encryptedSegments, z));
                this.encryptedSegments++;
                this.cipher.doFinal(byteBuffer, byteBuffer2);
            }
        }

        @Override // com.google.crypto.tink.subtle.StreamSegmentEncrypter
        public void encryptSegment(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, boolean z, ByteBuffer byteBuffer3) throws GeneralSecurityException {
            synchronized (this) {
                this.cipher.init(1, this.keySpec, AesGcmHkdfStreaming.paramsForSegment(this.noncePrefix, this.encryptedSegments, z));
                this.encryptedSegments++;
                if (byteBuffer2.hasRemaining()) {
                    this.cipher.update(byteBuffer, byteBuffer3);
                    this.cipher.doFinal(byteBuffer2, byteBuffer3);
                } else {
                    this.cipher.doFinal(byteBuffer, byteBuffer3);
                }
            }
        }
    }

    /* JADX INFO: loaded from: classes5.dex */
    class AesGcmHkdfStreamDecrypter implements StreamSegmentDecrypter {
        private Cipher cipher;
        private SecretKeySpec keySpec;
        private byte[] noncePrefix;

        AesGcmHkdfStreamDecrypter() {
        }

        @Override // com.google.crypto.tink.subtle.StreamSegmentDecrypter
        public void init(ByteBuffer byteBuffer, byte[] bArr) throws GeneralSecurityException {
            synchronized (this) {
                if (byteBuffer.remaining() != AesGcmHkdfStreaming.this.getHeaderLength()) {
                    throw new InvalidAlgorithmParameterException("Invalid header length");
                }
                if (byteBuffer.get() != AesGcmHkdfStreaming.this.getHeaderLength()) {
                    throw new GeneralSecurityException("Invalid ciphertext");
                }
                this.noncePrefix = new byte[7];
                byte[] bArr2 = new byte[AesGcmHkdfStreaming.this.keySizeInBytes];
                byteBuffer.get(bArr2);
                byteBuffer.get(this.noncePrefix);
                this.keySpec = AesGcmHkdfStreaming.this.deriveKeySpec(bArr2, bArr);
                this.cipher = AesGcmHkdfStreaming.cipherInstance();
            }
        }

        @Override // com.google.crypto.tink.subtle.StreamSegmentDecrypter
        public void decryptSegment(ByteBuffer byteBuffer, int i, boolean z, ByteBuffer byteBuffer2) throws GeneralSecurityException {
            synchronized (this) {
                this.cipher.init(2, this.keySpec, AesGcmHkdfStreaming.paramsForSegment(this.noncePrefix, i, z));
                this.cipher.doFinal(byteBuffer, byteBuffer2);
            }
        }
    }
}
