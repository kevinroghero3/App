package com.google.crypto.tink.subtle;

import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import ch.qos.logback.core.net.SyslogConstants;
import com.facebook.hermes.intl.PlatformCollatorAndroid;
import com.facebook.imageutils.JfifUtil;
import com.google.common.base.Ascii;
import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.StreamingAead;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.streamingaead.AesCtrHmacStreamingKey;
import com.google.crypto.tink.streamingaead.AesCtrHmacStreamingParameters;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
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
import javax.crypto.Mac;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import o.ArtificialStackFrames;
import o.asBinder;

/* JADX INFO: loaded from: classes3.dex */
public final class AesCtrHmacStreaming extends NonceBasedStreamingAead {
    public static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_NOT_FIPS;
    private static final int HMAC_KEY_SIZE_IN_BYTES = 32;
    private static final int NONCE_PREFIX_IN_BYTES = 7;
    private static final int NONCE_SIZE_IN_BYTES = 16;
    private final int ciphertextSegmentSize;
    private final int firstSegmentOffset;
    private final String hkdfAlgo;
    private final byte[] ikm;
    private final int keySizeInBytes;
    private final int plaintextSegmentSize;
    private final String tagAlgo;
    private final int tagSizeInBytes;

    /* JADX INFO: Access modifiers changed from: private */
    public static Buffer toBuffer(ByteBuffer byteBuffer) {
        return byteBuffer;
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

    /* JADX INFO: loaded from: classes5.dex */
    public class AesCtrHmacStreamEncrypter implements StreamSegmentEncrypter {
        private final Cipher cipher = AesCtrHmacStreaming.cipherInstance();
        private long encryptedSegments;
        private ByteBuffer header;
        private final SecretKeySpec hmacKeySpec;
        private final SecretKeySpec keySpec;
        private final Mac mac;
        private final byte[] noncePrefix;
        private static final byte[] $$c = {Ascii.DC2, -20, 124, 53};
        private static final int $$d = 25;
        private static int $10 = 0;
        private static int $11 = 1;
        private static final byte[] $$a = {55, -4, -8, -76, -11, -2, Ascii.FF};
        private static final int $$b = 90;
        private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
        private static int artificialFrame = 1;
        private static long extraCommand = -4118298814177494056L;

        /* JADX WARN: Code duplicated, block: B:10:0x0027  */
        /* JADX WARN: Code duplicated, block: B:8:0x0021  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x002c). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0027
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        private static java.lang.String $$e(short r6, int r7, short r8) {
            /*
                int r7 = r7 * 3
                int r7 = r7 + 118
                int r8 = r8 * 4
                int r8 = 1 - r8
                int r6 = r6 * 2
                int r6 = 3 - r6
                byte[] r0 = com.google.crypto.tink.subtle.AesCtrHmacStreaming.AesCtrHmacStreamEncrypter.$$c
                byte[] r1 = new byte[r8]
                r2 = 0
                if (r0 != 0) goto L17
                r7 = r6
                r4 = r8
                r3 = r2
                goto L2c
            L17:
                r3 = r2
            L18:
                byte r4 = (byte) r7
                r1[r3] = r4
                int r3 = r3 + 1
                int r6 = r6 + 1
                if (r3 != r8) goto L27
                java.lang.String r6 = new java.lang.String
                r6.<init>(r1, r2)
                return r6
            L27:
                r4 = r0[r6]
                r5 = r7
                r7 = r6
                r6 = r5
            L2c:
                int r4 = -r4
                int r6 = r6 + r4
                r5 = r7
                r7 = r6
                r6 = r5
                goto L18
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.subtle.AesCtrHmacStreaming.AesCtrHmacStreamEncrypter.$$e(short, int, short):java.lang.String");
        }

        /* JADX WARN: Code duplicated, block: B:10:0x002a  */
        /* JADX WARN: Code duplicated, block: B:8:0x0022  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x002f). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x002a
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        private static void b(byte r6, int r7, short r8, java.lang.Object[] r9) {
            /*
                int r6 = r6 * 4
                int r0 = 4 - r6
                int r7 = r7 * 3
                int r7 = r7 + 109
                byte[] r1 = com.google.crypto.tink.subtle.AesCtrHmacStreaming.AesCtrHmacStreamEncrypter.$$a
                int r8 = r8 * 2
                int r8 = 3 - r8
                byte[] r0 = new byte[r0]
                int r6 = 3 - r6
                r2 = 0
                if (r1 != 0) goto L18
                r3 = r8
                r4 = r2
                goto L2f
            L18:
                r3 = r2
            L19:
                int r8 = r8 + 1
                byte r4 = (byte) r7
                r0[r3] = r4
                int r4 = r3 + 1
                if (r3 != r6) goto L2a
                java.lang.String r6 = new java.lang.String
                r6.<init>(r0, r2)
                r9[r2] = r6
                return
            L2a:
                r3 = r1[r8]
                r5 = r3
                r3 = r8
                r8 = r5
            L2f:
                int r8 = -r8
                int r7 = r7 + r8
                int r7 = r7 + (-3)
                r8 = r3
                r3 = r4
                goto L19
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.subtle.AesCtrHmacStreaming.AesCtrHmacStreamEncrypter.b(byte, int, short, java.lang.Object[]):void");
        }

        private static void a(int i, char[] cArr, Object[] objArr) throws Throwable {
            int i2 = 2 % 2;
            asBinder asbinder = new asBinder();
            asbinder.c = i;
            int length = cArr.length;
            long[] jArr = new long[length];
            asbinder.d = 0;
            while (asbinder.d < cArr.length) {
                int i3 = $10 + 99;
                $11 = i3 % 128;
                if (i3 % 2 == 0) {
                    int i4 = asbinder.d;
                    try {
                        Object[] objArr2 = {Integer.valueOf(cArr[asbinder.d]), asbinder, asbinder};
                        Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1562553046);
                        if (objAccessartificialFrame == null) {
                            byte b = (byte) 0;
                            byte b2 = b;
                            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(11 - View.resolveSize(0, 0), (char) ((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) - 1), (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 1407, 1035473698, false, $$e(b, b2, b2), new Class[]{Integer.TYPE, Object.class, Object.class});
                        }
                        jArr[i4] = ((Long) ((Method) objAccessartificialFrame).invoke(null, objArr2)).longValue() % (extraCommand - (-2360974883025274865L));
                        Object[] objArr3 = {asbinder, asbinder};
                        Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1981632360);
                        if (objAccessartificialFrame2 == null) {
                            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(Color.green(0) + 8, (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), TextUtils.getOffsetBefore("", 0) + 249, 378009232, false, "w", new Class[]{Object.class, Object.class});
                        }
                        ((Method) objAccessartificialFrame2).invoke(null, objArr3);
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause == null) {
                            throw th;
                        }
                        throw cause;
                    }
                } else {
                    int i5 = asbinder.d;
                    try {
                        Object[] objArr4 = {Integer.valueOf(cArr[asbinder.d]), asbinder, asbinder};
                        Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1562553046);
                        if (objAccessartificialFrame3 == null) {
                            byte b3 = (byte) 0;
                            byte b4 = b3;
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(TextUtils.getOffsetAfter("", 0) + 11, (char) View.getDefaultSize(0, 0), 1407 - TextUtils.indexOf("", "", 0), 1035473698, false, $$e(b3, b4, b4), new Class[]{Integer.TYPE, Object.class, Object.class});
                        }
                        jArr[i5] = ((Long) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).longValue() ^ (extraCommand ^ (-2360974883025274865L));
                        try {
                            Object[] objArr5 = {asbinder, asbinder};
                            Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1981632360);
                            if (objAccessartificialFrame4 == null) {
                                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(8 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) View.MeasureSpec.getMode(0), 249 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), 378009232, false, "w", new Class[]{Object.class, Object.class});
                            }
                            ((Method) objAccessartificialFrame4).invoke(null, objArr5);
                        } catch (Throwable th2) {
                            Throwable cause2 = th2.getCause();
                            if (cause2 == null) {
                                throw th2;
                            }
                            throw cause2;
                        }
                    } catch (Throwable th3) {
                        Throwable cause3 = th3.getCause();
                        if (cause3 == null) {
                            throw th3;
                        }
                        throw cause3;
                    }
                }
            }
            char[] cArr2 = new char[length];
            asbinder.d = 0;
            int i6 = $10 + 125;
            $11 = i6 % 128;
            int i7 = i6 % 2;
            while (asbinder.d < cArr.length) {
                cArr2[asbinder.d] = (char) jArr[asbinder.d];
                Object[] objArr6 = {asbinder, asbinder};
                Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1981632360);
                if (objAccessartificialFrame5 == null) {
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 8, (char) TextUtils.indexOf("", "", 0), (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 248, 378009232, false, "w", new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame5).invoke(null, objArr6);
            }
            objArr[0] = new String(cArr2);
        }

        public AesCtrHmacStreamEncrypter(byte[] bArr) throws GeneralSecurityException {
            this.encryptedSegments = 0L;
            this.mac = AesCtrHmacStreaming.this.macInstance();
            this.encryptedSegments = 0L;
            byte[] bArrRandomSalt = AesCtrHmacStreaming.this.randomSalt();
            byte[] bArrRandomNonce = AesCtrHmacStreaming.this.randomNonce();
            this.noncePrefix = bArrRandomNonce;
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(AesCtrHmacStreaming.this.getHeaderLength());
            this.header = byteBufferAllocate;
            byteBufferAllocate.put((byte) AesCtrHmacStreaming.this.getHeaderLength());
            this.header.put(bArrRandomSalt);
            this.header.put(bArrRandomNonce);
            AesCtrHmacStreaming.toBuffer(this.header).flip();
            byte[] bArrDeriveKeyMaterial = AesCtrHmacStreaming.this.deriveKeyMaterial(bArrRandomSalt, bArr);
            this.keySpec = AesCtrHmacStreaming.this.deriveKeySpec(bArrDeriveKeyMaterial);
            this.hmacKeySpec = AesCtrHmacStreaming.this.deriveHmacKeySpec(bArrDeriveKeyMaterial);
        }

        @Override // com.google.crypto.tink.subtle.StreamSegmentEncrypter
        public ByteBuffer getHeader() {
            return this.header.asReadOnlyBuffer();
        }

        @Override // com.google.crypto.tink.subtle.StreamSegmentEncrypter
        public void encryptSegment(ByteBuffer byteBuffer, boolean z, ByteBuffer byteBuffer2) throws GeneralSecurityException {
            synchronized (this) {
                int iPosition = AesCtrHmacStreaming.toBuffer(byteBuffer2).position();
                byte[] bArrNonceForSegment = AesCtrHmacStreaming.this.nonceForSegment(this.noncePrefix, this.encryptedSegments, z);
                this.cipher.init(1, this.keySpec, new IvParameterSpec(bArrNonceForSegment));
                this.encryptedSegments++;
                this.cipher.doFinal(byteBuffer, byteBuffer2);
                ByteBuffer byteBufferDuplicate = byteBuffer2.duplicate();
                AesCtrHmacStreaming.toBuffer(byteBufferDuplicate).flip();
                AesCtrHmacStreaming.toBuffer(byteBufferDuplicate).position(iPosition);
                this.mac.init(this.hmacKeySpec);
                this.mac.update(bArrNonceForSegment);
                this.mac.update(byteBufferDuplicate);
                byteBuffer2.put(this.mac.doFinal(), 0, AesCtrHmacStreaming.this.tagSizeInBytes);
            }
        }

        @Override // com.google.crypto.tink.subtle.StreamSegmentEncrypter
        public void encryptSegment(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, boolean z, ByteBuffer byteBuffer3) throws GeneralSecurityException {
            synchronized (this) {
                int iPosition = AesCtrHmacStreaming.toBuffer(byteBuffer3).position();
                byte[] bArrNonceForSegment = AesCtrHmacStreaming.this.nonceForSegment(this.noncePrefix, this.encryptedSegments, z);
                this.cipher.init(1, this.keySpec, new IvParameterSpec(bArrNonceForSegment));
                this.encryptedSegments++;
                this.cipher.update(byteBuffer, byteBuffer3);
                this.cipher.doFinal(byteBuffer2, byteBuffer3);
                ByteBuffer byteBufferDuplicate = byteBuffer3.duplicate();
                AesCtrHmacStreaming.toBuffer(byteBufferDuplicate).flip();
                AesCtrHmacStreaming.toBuffer(byteBufferDuplicate).position(iPosition);
                this.mac.init(this.hmacKeySpec);
                this.mac.update(bArrNonceForSegment);
                this.mac.update(byteBufferDuplicate);
                byteBuffer3.put(this.mac.doFinal(), 0, AesCtrHmacStreaming.this.tagSizeInBytes);
            }
        }

        public static Object[] coroutineCreation(int i, int i2) throws Throwable {
            Object[] objArr;
            long j;
            int i3;
            char c;
            Object[] objArr2;
            int i4;
            String line;
            char c2;
            int i5;
            int i6;
            int i7;
            int i8;
            int[] iArr;
            char c3;
            int i9;
            int i10;
            int i11 = 2 % 2;
            int i12 = getARTIFICIAL_FRAME_PACKAGE_NAME;
            int i13 = ((i12 | 57) << 1) - (i12 ^ 57);
            artificialFrame = i13 % 128;
            int i14 = i13 % 2;
            int i15 = 4;
            Object[] objArr3 = null;
            try {
                int i16 = -(ViewConfiguration.getTapTimeout() >> 16);
                int iExtraCallback = PlatformCollatorAndroid.extraCallback();
                int i17 = i16 * 471;
                int i18 = (i17 & 929283) + (i17 | 929283);
                int i19 = ((i16 & 1973) | (i16 ^ 1973)) * (-470);
                int i20 = (i18 & i19) + (i18 | i19);
                int i21 = ~((~i16) | (-1974));
                int i22 = ~(((-1974) ^ iExtraCallback) | ((-1974) & iExtraCallback));
                int i23 = (i21 ^ i22) | (i21 & i22);
                int i24 = ~((~iExtraCallback) | i16 | 1973);
                int i25 = ((i23 ^ i24) | (i23 & i24)) * (-470);
                int i26 = ((i20 | i25) << 1) - (i25 ^ i20);
                int i27 = ((-1974) ^ i16) | ((-1974) & i16);
                int i28 = ~((i27 & iExtraCallback) | (i27 ^ iExtraCallback));
                int i29 = (~iExtraCallback) | i16;
                int i30 = ~((i29 & 1973) | (i29 ^ 1973));
                int i31 = -(-(((i28 & i30) | (i28 ^ i30)) * 470));
                Object[] objArr4 = new Object[1];
                a((i26 ^ i31) + ((i31 & i26) << 1), new char[]{958, 1041, 3321, 5293, 7521, 9515, 11662, 13891, 15898, 18168, 20102, 22399, 24517, 26504, 26708, 28719, 30963, 32951, 35081}, objArr4);
                Object[] objArr5 = new Object[1];
                a(59722 - (~(-(-TextUtils.indexOf("", "")))), new char[]{928, 60157, 53544, 47170, 42642, 36302, 29810, 25244, 18912, 12294, 8061, 1419, 60465, 56173, 49578, 43221, 38658, 32350}, objArr5);
                String[] strArr = {(String) objArr4[0], (String) objArr5[0]};
                int i32 = artificialFrame + 17;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i32 % 128;
                int i33 = i32 % 2;
                int i34 = 0;
                while (true) {
                    if (i34 >= 2) {
                        Object[] objArr6 = new Object[i15];
                        objArr6[0] = new int[]{i};
                        objArr6[1] = new int[]{i};
                        objArr6[2] = new int[1];
                        objArr6[3] = null;
                        int i35 = ~i;
                        int i36 = (-460716322) + (((-873070611) | i35) * 494) + (((~(i35 | 53844876)) | (-875207199)) * 494);
                        int iExtraCallback2 = PlatformCollatorAndroid.extraCallback();
                        int i37 = i36 * (-987);
                        int i38 = ~i36;
                        int i39 = ~iExtraCallback2;
                        int i40 = ~((i38 ^ i39) | (i38 & i39));
                        int i41 = ~((i36 ^ iExtraCallback2) | (i36 & iExtraCallback2));
                        int i42 = ((i40 & i41) | (i40 ^ i41)) * 988;
                        int i43 = (i37 ^ i42) + ((i37 & i42) << 1);
                        int i44 = ~i36;
                        int i45 = i43 + (i44 * (-988));
                        int i46 = ~(i44 | ((-1) ^ i44));
                        int i47 = ~((iExtraCallback2 & i38) | (i38 ^ iExtraCallback2));
                        int i48 = (i47 & i46) | (i46 ^ i47);
                        int i49 = ~((i39 ^ i36) | (i36 & i39));
                        int i50 = ((i48 & i49) | (i48 ^ i49)) * 988;
                        int i51 = (i2 - (~((i45 & i50) + (i50 | i45)))) - 1;
                        int i52 = i51 << 13;
                        int i53 = ((~i51) & i52) | ((~i52) & i51);
                        int i54 = i53 ^ (i53 >>> 17);
                        int i55 = i54 << 5;
                        ((int[]) objArr6[2])[0] = ((~i54) & i55) | ((~i55) & i54);
                        objArr = objArr6;
                        break;
                    }
                    int i56 = getARTIFICIAL_FRAME_PACKAGE_NAME + 35;
                    artificialFrame = i56 % 128;
                    int i57 = i56 % 2;
                    String str = strArr[i34];
                    Object[] objArr7 = new Object[1];
                    a(16822 - (~View.resolveSizeAndState(0, 0, 0)), new char[]{950, 16910, 32989, 50816, 1380, 19245, 35321, 53240, 3584, 19659, 37599, 53582, 5926, 22014, 39840, 55817}, objArr7);
                    Class<?> cls = Class.forName((String) objArr7[0]);
                    if (((Boolean) cls.getMethod(str, new Class[0]).invoke(cls, objArr3)).booleanValue()) {
                        int i58 = artificialFrame + 61;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i58 % 128;
                        if (i58 % 2 != 0) {
                            i8 = (~(i & 1)) & (i | 1);
                            objArr = new Object[i15];
                            objArr[0] = new int[0];
                            iArr = new int[1];
                            c3 = 0;
                        } else {
                            i8 = (~(i & 1)) & (i | 1);
                            objArr = new Object[i15];
                            objArr[0] = new int[1];
                            iArr = new int[1];
                            c3 = 1;
                        }
                        objArr[c3] = iArr;
                        objArr[2] = new int[1];
                        ((int[]) objArr[0])[0] = i;
                        ((int[]) objArr[1])[0] = i8;
                        objArr[3] = objArr3;
                        int iUptimeMillis = (int) SystemClock.uptimeMillis();
                        int i59 = 481815869 + (((~(iUptimeMillis | (-7724045))) | (-986347820)) * (-465)) + (((-7724045) | (~((-986347820) | iUptimeMillis))) * 930) + ((iUptimeMillis | (-4216841)) * 465);
                        int iExtraCallback3 = PlatformCollatorAndroid.extraCallback();
                        int i60 = -(-(i59 * (-107)));
                        int i61 = (880 & i60) + (i60 | 880);
                        int i62 = ~(((-17) ^ i59) | ((-17) & i59));
                        int i63 = ~iExtraCallback3;
                        int i64 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                        int i65 = i64 + 63;
                        artificialFrame = i65 % 128;
                        int i66 = i65 % 2;
                        int i67 = ~((i63 ^ i59) | (i63 & i59));
                        if (i66 == 0) {
                            i9 = i61 * ((-108) - ((i62 & i67) | (i62 ^ i67)));
                            int i68 = ~(((-17) ^ iExtraCallback3) | ((-17) & iExtraCallback3));
                            int i69 = ~((~i59) | 16);
                            i10 = (i68 & i69) | (i68 ^ i69);
                        } else {
                            i9 = (i61 - (~(((i62 & i67) | (i62 ^ i67)) * (-108)))) - 1;
                            int i70 = ~(((-17) ^ iExtraCallback3) | ((-17) & iExtraCallback3));
                            int i71 = ~i59;
                            i10 = i70 | (~((i71 & 16) | (i71 ^ 16)));
                        }
                        int i72 = ~((i63 ^ 16) | (i63 & 16));
                        int i73 = -(-(54 * ((i10 & i72) | (i10 ^ i72))));
                        int i74 = ((i9 | i73) << 1) - (i73 ^ i9);
                        int i75 = ~i59;
                        int i76 = (iExtraCallback3 | (~((i75 & 16) | (i75 ^ 16)))) * 54;
                        int i77 = i2 + (i74 ^ i76) + ((i76 & i74) << 1);
                        int i78 = i77 << 13;
                        int i79 = ((~i77) & i78) | ((~i78) & i77);
                        int i80 = i64 + 117;
                        artificialFrame = i80 % 128;
                        int i81 = i80 % 2;
                        int i82 = i79 >>> 17;
                        int i83 = (i79 | i82) & (~(i79 & i82));
                        int i84 = i83 << 5;
                        ((int[]) objArr[2])[0] = ((~i83) & i84) | ((~i84) & i83);
                        break;
                    }
                    i34++;
                    int i85 = artificialFrame;
                    int i86 = (i85 ^ 31) + ((i85 & 31) << 1);
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i86 % 128;
                    int i87 = i86 % 2;
                    i15 = 4;
                    objArr3 = null;
                }
            } catch (Exception unused) {
                Object[] objArr8 = {new int[]{i}, new int[]{(~(i & 2)) & (i | 2)}, new int[1], null};
                int iMaxMemory = (int) Runtime.getRuntime().maxMemory();
                int i88 = ~iMaxMemory;
                int i89 = (-1001025590) + (((~((-635432580) | i88)) | (~((-343191196) | iMaxMemory))) * 1900) + (((~(i88 | 343191195)) | (~(iMaxMemory | 635432579))) * (-950)) + (((~(iMaxMemory | 343191195)) | (~(i88 | 635432579))) * 950) + 16;
                int i90 = i89 * (-183);
                int i91 = i2 * 185;
                int i92 = (i90 ^ i91) + ((i90 & i91) << 1);
                int i93 = ~i89;
                int i94 = -(-(((i93 & i2) | (i2 ^ i93)) * (-368)));
                int i95 = (i92 & i94) + (i94 | i92);
                int i96 = ~i2;
                int i97 = i89 | i96;
                int i98 = ~i;
                int i99 = (i95 - (~(-(-(((i97 & i98) | (i97 ^ i98)) * SyslogConstants.LOG_LOCAL7))))) - 1;
                int i100 = ~(i96 | (~i89));
                int i101 = ~((~i) | i89);
                int i102 = -(-(((i100 & i101) | (i100 ^ i101) | (~(i89 | i2))) * SyslogConstants.LOG_LOCAL7));
                int i103 = ((i99 | i102) << 1) - (i102 ^ i99);
                int i104 = i103 << 13;
                int i105 = (i104 & (~i103)) | ((~i104) & i103);
                int i106 = i105 >>> 17;
                int i107 = ((~i105) & i106) | ((~i106) & i105);
                int i108 = i107 << 5;
                ((int[]) objArr8[2])[0] = ((~i107) & i108) | ((~i108) & i107);
                objArr = objArr8;
            }
            if (i != ((int[]) objArr[1])[0]) {
                return objArr;
            }
            try {
                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(590025679);
                if (objAccessartificialFrame == null) {
                    int keyRepeatTimeout = (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 9;
                    char cIndexOf = (char) (TextUtils.indexOf("", "", 0) + 64610);
                    int jumpTapTimeout = (ViewConfiguration.getJumpTapTimeout() >> 16) + 1806;
                    byte b = (byte) 0;
                    byte b2 = b;
                    Object[] objArr9 = new Object[1];
                    b(b, b2, b2, objArr9);
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(keyRepeatTimeout, cIndexOf, jumpTapTimeout, -1135716921, false, (String) objArr9[0], new Class[0]);
                }
                long jLongValue = ((Long) ((Method) objAccessartificialFrame).invoke(null, null)).longValue();
                int i109 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                int i110 = ((i109 | 13) << 1) - (i109 ^ 13);
                artificialFrame = i110 % 128;
                if (i110 % 2 == 0) {
                    long j2 = -1093977886;
                    long j3 = 140;
                    long j4 = i;
                    long j5 = -1;
                    long j6 = (j2 ^ j5) | jLongValue;
                    long j7 = j4 ^ j5;
                    j = (((long) 141) * j2) + (((long) (-279)) * jLongValue) + ((jLongValue | j4) * j3) + (((long) (-280)) * ((j6 ^ j5) | ((j7 | jLongValue) ^ j5))) + (j3 * ((j5 ^ (j6 | j4)) | (((jLongValue ^ j5) | j2) ^ j5) | ((j7 | j2) ^ j5))) + ((long) 1434185920);
                    int i111 = 91 / 0;
                } else {
                    long j8 = -1528083359;
                    long j9 = (((long) 980) * j8) + (((long) (-978)) * jLongValue);
                    long j10 = 979;
                    long j11 = -1;
                    long j12 = jLongValue ^ j11;
                    long j13 = i;
                    long j14 = j13 ^ j11;
                    j = j9 + (((j12 | j14) ^ j11) * j10) + (((long) (-979)) * (j8 | j13)) + (j10 * (((j14 | j8) ^ j11) | ((j12 | j13) ^ j11))) + ((long) 1868291393);
                }
                int iMyUid = Process.myUid();
                int i112 = (~(333813396 | iMyUid)) | 1745512491;
                int i113 = ~iMyUid;
                int i114 = ((int) (j >> 32)) & ((-495402644) + ((i112 | (~((-308286081) | i113))) * 886) + (((~(i113 | (-333813397))) | 1771039807) * (-1772)) + ((~(i113 | 1771039807)) * 886));
                int iFreeMemory = (int) Runtime.getRuntime().freeMemory();
                int i115 = ~iFreeMemory;
                int i116 = ((int) j) & (145590169 + (((-4465057) | iFreeMemory) * (-676)) + (((~((-1651407265) | i115)) | 4465056) * 676) + (((~(iFreeMemory | (-1646942209))) | (~(i115 | (-214180855))) | 209715798) * 676));
                int i117 = (i114 & i116) | (i114 ^ i116);
                int i118 = artificialFrame;
                int i119 = ((i118 | 67) << 1) - (i118 ^ 67);
                int i120 = i119 % 128;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i120;
                int i121 = i119 % 2;
                if (i117 == 1) {
                    int i122 = (i120 ^ 15) + ((i120 & 15) << 1);
                    artificialFrame = i122 % 128;
                    int i123 = i122 % 2;
                    Object[] objArr10 = {new int[]{i}, new int[]{(~(i & 10)) & (i | 10)}, new int[1], null};
                    int i124 = ~i;
                    int i125 = 768446414 + (((~((-75809313) | i124)) | (~(96781050 | i))) * 520);
                    int i126 = ~((-96781051) | i124);
                    int i127 = ~(881842724 | i);
                    int i128 = i125 + ((i126 | i127) * (-1040)) + (((~((-881842725) | i124)) | 20971738 | i127) * 520);
                    int i129 = -(-(i128 * (-115)));
                    int i130 = ((((-1840) | i129) << 1) - (i129 ^ (-1840))) + ((~(i124 | 16 | i128)) * (-116)) + (((i ^ 16) | (i & 16)) * 116);
                    int i131 = ~i128;
                    int i132 = ~(((-17) ^ i131) | ((-17) & i131));
                    int i133 = ~((i131 & i) | (i131 ^ i));
                    int i134 = i130 + (((i133 & i132) | (i132 ^ i133)) * 116);
                    int iExtraCallback4 = PlatformCollatorAndroid.extraCallback();
                    i3 = i2;
                    int i135 = (i134 * 934) + (i3 * (-932));
                    int i136 = ~i3;
                    int i137 = ~i134;
                    int i138 = ~iExtraCallback4;
                    int i139 = ~((i137 & i138) | (i137 ^ i138));
                    int i140 = -(-(((i136 & i139) | (i136 ^ i139)) * (-933)));
                    int i141 = (i135 ^ i140) + ((i135 & i140) << 1);
                    int i142 = ~i3;
                    int i143 = ~((i138 & i142) | (i142 ^ i138));
                    int i144 = ~((i142 & i134) | (i142 ^ i134));
                    int i145 = (i141 - (~(-(-(((i143 & i144) | (i143 ^ i144)) * 933))))) - 1;
                    int i146 = -(-((~((i134 ^ i3) | (i134 & i3))) * 933));
                    int i147 = (i145 ^ i146) + ((i146 & i145) << 1);
                    int i148 = i147 << 13;
                    int i149 = (i148 & (~i147)) | ((~i148) & i147);
                    int i150 = i149 >>> 17;
                    int i151 = (i149 | i150) & (~(i149 & i150));
                    int i152 = i151 << 5;
                    ((int[]) objArr10[2])[0] = ((~i151) & i152) | ((~i152) & i151);
                    objArr2 = objArr10;
                    c = 0;
                } else {
                    i3 = i2;
                    Object[] objArr11 = {new int[]{i}, new int[]{i}, new int[1], null};
                    int i153 = ~((int) Runtime.getRuntime().freeMemory());
                    int i154 = -(-((((~((-663769303) | i153)) | 41959488) * (-241)) + 1157744086 + (((~(i153 | (-621809815))) | 272894984) * 241)));
                    int i155 = (i3 & i154) + (i154 | i3);
                    int i156 = i155 << 13;
                    int i157 = (i156 & (~i155)) | ((~i156) & i155);
                    int i158 = i157 ^ (i157 >>> 17);
                    int i159 = i158 << 5;
                    int i160 = (i158 | i159) & (~(i158 & i159));
                    c = 0;
                    ((int[]) objArr11[2])[0] = i160;
                    objArr2 = objArr11;
                }
                if (i != ((int[]) objArr2[1])[c]) {
                    int i161 = artificialFrame + 119;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i161 % 128;
                    int i162 = i161 % 2;
                    return objArr2;
                }
                try {
                    int i163 = -Drawable.resolveOpacity(0, 0);
                    Object[] objArr12 = new Object[1];
                    a(((i163 | 17467) << 1) - (i163 ^ 17467), new char[]{1016, 18335, 35800, 53013, 4884, 22171, 39632, 56888, 8801, 26017, 43509, 60785, 12663, 30029, 47247, 64727, 16384, 33811, 53125, 5060, 22314, 39779, 57004, 8948, 26168, 43579, 61002, 12699, 30161, 47370, 64856, 16540, 33987, 51219, 3189, 22452, 39930, 57139, 9072, 26456}, objArr12);
                    File file = new File((String) objArr12[0]);
                    if (file.canRead()) {
                        FileReader fileReader = new FileReader(file);
                        BufferedReader bufferedReader = new BufferedReader(fileReader);
                        try {
                            line = bufferedReader.readLine();
                            int i164 = -(ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1));
                            Object[] objArr13 = new Object[1];
                            a((i164 & 26670) + (i164 | 26670), new char[]{953, 27541, 54269}, objArr13);
                            if (line.equals((String) objArr13[0])) {
                                fileReader.close();
                                bufferedReader.close();
                                int i165 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                int i166 = (i165 & 125) + (i165 | 125);
                                artificialFrame = i166 % 128;
                                int i167 = i166 % 2;
                                i4 = getARTIFICIAL_FRAME_PACKAGE_NAME + 57;
                                artificialFrame = i4 % 128;
                                int i168 = i4 % 2;
                                line = null;
                            } else {
                                fileReader.close();
                                bufferedReader.close();
                            }
                        } catch (Throwable th) {
                            fileReader.close();
                            bufferedReader.close();
                            throw th;
                        }
                    } else {
                        i4 = artificialFrame + 95;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i4 % 128;
                        int i169 = i4 % 2;
                        line = null;
                    }
                } catch (Exception unused2) {
                }
                try {
                    Object[] objArr14 = new Object[1];
                    a(33807 - (~(-(ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)))), new char[]{1016, 34742, 2951, 36747, 5104, 38829, 7106, 40921, 9004, 42849, 11030, 44809, 13161, 46948, 15196, 48964, 17128, 50832, 19089, 52966, 21218, 54993, 23236, 56847, 25130, 58896, 27148, 61054, 29287, 63071, 31309}, objArr14);
                    File file2 = new File((String) objArr14[0]);
                    if (file2.canRead()) {
                        FileReader fileReader2 = new FileReader(file2);
                        BufferedReader bufferedReader2 = new BufferedReader(fileReader2);
                        try {
                            String line2 = bufferedReader2.readLine();
                            int i170 = -(Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1));
                            int i171 = i170 * 141;
                            int i172 = (i171 & (-6732882)) + (i171 | (-6732882));
                            int i173 = ~i170;
                            int i174 = ~((i173 ^ 48438) | (i173 & 48438));
                            int i175 = ~((i173 ^ i) | (i173 & i));
                            int i176 = ((i174 & i175) | (i174 ^ i175)) * (-280);
                            int i177 = (i172 ^ i176) + ((i172 & i176) << 1);
                            int i178 = ~((i173 ^ i) | (i173 & i));
                            int i179 = ~((-48439) | i);
                            int i180 = (i177 - (~(((i178 & i179) | (i178 ^ i179)) * 140))) - 1;
                            int i181 = (i173 & (-48439)) | (i173 ^ (-48439));
                            int i182 = ~((i181 & i) | (i181 ^ i));
                            int i183 = ~i170;
                            int i184 = ~i;
                            int i185 = ~(48438 | (i183 & i184) | (i183 ^ i184));
                            int i186 = (i182 & i185) | (i182 ^ i185);
                            int i187 = ((-48439) & i184) | ((-48439) ^ i184);
                            int i188 = ((~((i170 & i187) | (i187 ^ i170))) | i186) * 140;
                            Object[] objArr15 = new Object[1];
                            a((i180 & i188) + (i188 | i180), new char[]{998}, objArr15);
                            boolean zEquals = line2.equals((String) objArr15[0]);
                            fileReader2.close();
                            bufferedReader2.close();
                            if (zEquals) {
                                int offsetBefore = TextUtils.getOffsetBefore("", 0);
                                Object[] objArr16 = new Object[1];
                                a((offsetBefore & 51169) + (51169 | offsetBefore), new char[]{1016, 50245, 35948, 21511, 7292, 58585, 44276, 29826, 15537, 1371, 52593, 38227, 23871, 9695, 60923, 46477, 32160, 17929, 3697, 54806, 40482, 26305, 12008, 63118, 48808, 34561, 20345, 5918, 57130, 42953, 28640, 14214, 65424, 51081, 34906, 20602}, objArr16);
                                File file3 = new File((String) objArr16[0]);
                                if (!file3.canRead()) {
                                    int i189 = artificialFrame;
                                    int i190 = ((i189 | 53) << 1) - (i189 ^ 53);
                                    int i191 = i190 % 128;
                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i191;
                                    int i192 = i190 % 2;
                                    int i193 = i191 + 7;
                                    artificialFrame = i193 % 128;
                                    int i194 = i193 % 2;
                                } else {
                                    FileReader fileReader3 = new FileReader(file3);
                                    BufferedReader bufferedReader3 = new BufferedReader(fileReader3);
                                    try {
                                        String line3 = bufferedReader3.readLine();
                                        int i195 = -(Process.myPid() >> 22);
                                        int i196 = (i195 * (-167)) - 8088979;
                                        int i197 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                        int i198 = (i197 & 67) + (i197 | 67);
                                        artificialFrame = i198 % 128;
                                        if (i198 % 2 == 0) {
                                            i6 = ~((~i195) | (-48438));
                                            i7 = (~i) | (-48438);
                                        } else {
                                            int i199 = ~i195;
                                            i6 = ~((i199 & (-48438)) | (i199 ^ (-48438)));
                                            int i200 = ~i;
                                            i7 = (i200 & (-48438)) | ((-48438) ^ i200);
                                        }
                                        int i201 = ~i7;
                                        int i202 = -(-(((i6 & i201) | (i6 ^ i201)) * 168));
                                        int i203 = (i196 & i202) + (i196 | i202);
                                        int i204 = ~i195;
                                        int i205 = (i204 ^ (-48438)) | (i204 & (-48438));
                                        int i206 = -(-((~((i205 & i) | (i205 ^ i))) * 168));
                                        int i207 = (i203 & i206) + (i206 | i203);
                                        int i208 = ~i195;
                                        int i209 = ~i;
                                        int i210 = ~((i208 & i209) | (i208 ^ i209));
                                        int i211 = ~(i204 | 48437);
                                        int i212 = (i211 & i210) | (i210 ^ i211);
                                        int i213 = ((i197 | 119) << 1) - (i197 ^ 119);
                                        artificialFrame = i213 % 128;
                                        int i214 = i213 % 2;
                                        int i215 = i195 | (-48438);
                                        int i216 = ~((i215 & i) | (i215 ^ i));
                                        int i217 = -(-(168 * ((i216 & i212) | (i212 ^ i216))));
                                        Object[] objArr17 = new Object[1];
                                        a((i207 ^ i217) + ((i217 & i207) << 1), new char[]{998}, objArr17);
                                        boolean zEquals2 = line3.equals((String) objArr17[0]);
                                        fileReader3.close();
                                        bufferedReader3.close();
                                        if (zEquals2) {
                                            int i218 = artificialFrame + 113;
                                            getARTIFICIAL_FRAME_PACKAGE_NAME = i218 % 128;
                                            int i219 = i218 % 2;
                                            if (line != null) {
                                                int i220 = ~i;
                                                Object[] objArr18 = {new int[]{i}, new int[]{(i & (-21)) | (i220 & 20)}, new int[1], line};
                                                int i221 = (-7974034) + (((-553668757) | i) * (-676)) + (((~(250325833 | i220)) | 553668756) * 676) + (((~((-728297942) | i220)) | 174629185 | (~(803994589 | i))) * 676);
                                                int iExtraCallback5 = PlatformCollatorAndroid.extraCallback();
                                                int i222 = i221 * JfifUtil.MARKER_SOFn;
                                                int i223 = ((-6096) & i222) + (i222 | (-6096)) + 3247;
                                                int i224 = ~((i221 ^ iExtraCallback5) | (i221 & iExtraCallback5));
                                                int i225 = (i223 - (~(-(-(((i224 & 16) | (i224 ^ 16)) * 191))))) - 1;
                                                int i226 = ~(((-17) & i221) | ((-17) ^ i221));
                                                int i227 = ~iExtraCallback5;
                                                int i228 = ~((i227 & i221) | (i227 ^ i221));
                                                int i229 = ((i228 & i226) | (i226 ^ i228)) * 191;
                                                int i230 = (i225 ^ i229) + ((i229 & i225) << 1);
                                                int i231 = i230 * (-209);
                                                int i232 = i3 * (-209);
                                                int i233 = ((i231 | i232) << 1) - (i231 ^ i232);
                                                int i234 = ~i230;
                                                int i235 = ~i3;
                                                int i236 = (~((i234 ^ i235) | (i234 & i235))) * 210;
                                                int i237 = (((i233 & i236) + (i236 | i233)) - (~(((~(i235 | (~i))) | (~((i234 ^ i) | (i234 & i)))) * 210))) - 1;
                                                int i238 = i234 | i220;
                                                int i239 = ~((i238 & i3) | (i238 ^ i3));
                                                int i240 = ~i3;
                                                int i241 = (i240 & i230) | (i240 ^ i230);
                                                int i242 = i237 + ((i239 | (~((i & i241) | (i241 ^ i)))) * 210);
                                                int i243 = (i242 << 13) ^ i242;
                                                int i244 = i243 ^ (i243 >>> 17);
                                                int i245 = i244 << 5;
                                                ((int[]) objArr18[2])[0] = ((~i244) & i245) | ((~i245) & i244);
                                                return objArr18;
                                            }
                                        }
                                    } catch (Throwable th2) {
                                        fileReader3.close();
                                        bufferedReader3.close();
                                        throw th2;
                                    }
                                }
                            }
                        } catch (Throwable th3) {
                            fileReader2.close();
                            bufferedReader2.close();
                            throw th3;
                        }
                    }
                } catch (Exception unused3) {
                }
                Object[] objArr19 = new Object[4];
                int[] iArr2 = new int[1];
                objArr19[0] = iArr2;
                int[] iArr3 = new int[1];
                objArr19[1] = iArr3;
                int i246 = artificialFrame + 67;
                int i247 = i246 % 128;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i247;
                if (i246 % 2 != 0) {
                    c2 = 0;
                    objArr19[2] = new int[0];
                } else {
                    c2 = 0;
                    objArr19[2] = new int[1];
                }
                iArr2[c2] = i;
                iArr3[c2] = i;
                objArr19[3] = null;
                int i248 = ~i;
                int i249 = (~((-335335640) | i248)) | 39108679;
                int i250 = ~(939515095 | i);
                int i251 = (((i249 | i250) * (-252)) - 2050891006) + ((i250 | (~((-296226961) | i248))) * 252);
                int i252 = i247 + 81;
                artificialFrame = i252 % 128;
                if (i252 % 2 == 0) {
                    i251 %= 0;
                    i5 = (-964) >> ((-963) / i251);
                } else {
                    int i253 = i251 * (-963);
                    i5 = (i253 | (-964)) + (i253 & (-964));
                }
                int i254 = (i5 - (~(965 * i3))) - 1;
                int i255 = ~i251;
                int i256 = ~i3;
                int i257 = ((~((i & i256) | (i256 ^ i))) | i255) * (-964);
                int i258 = (i254 ^ i257) + ((i257 & i254) << 1);
                int i259 = ~((i248 & i256) | (i256 ^ i248));
                int i260 = ~((i256 ^ i251) | (i251 & i256));
                int i261 = -(-(((i259 & i260) | (i259 ^ i260)) * (-964)));
                int i262 = (i258 & i261) + (i261 | i258);
                int i263 = i262 << 13;
                int i264 = (i263 & (~i262)) | ((~i263) & i262);
                int i265 = i264 ^ (i264 >>> 17);
                int i266 = i265 << 5;
                ((int[]) objArr19[2])[0] = ((~i265) & i266) | ((~i266) & i265);
                return objArr19;
            } catch (Throwable th4) {
                Throwable cause = th4.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th4;
            }
        }
    }

    public AesCtrHmacStreaming(byte[] bArr, String str, int i, String str2, int i2, int i3, int i4) throws GeneralSecurityException {
        if (!FIPS.isCompatible()) {
            throw new GeneralSecurityException("Can not use AES-CTR-HMAC streaming in FIPS-mode.");
        }
        validateParameters(bArr.length, i, str2, i2, i3, i4);
        this.ikm = Arrays.copyOf(bArr, bArr.length);
        this.hkdfAlgo = str;
        this.keySizeInBytes = i;
        this.tagAlgo = str2;
        this.tagSizeInBytes = i2;
        this.ciphertextSegmentSize = i3;
        this.firstSegmentOffset = i4;
        this.plaintextSegmentSize = i3 - i2;
    }

    private AesCtrHmacStreaming(AesCtrHmacStreamingKey aesCtrHmacStreamingKey) throws GeneralSecurityException {
        String str;
        if (!FIPS.isCompatible()) {
            throw new GeneralSecurityException("Can not use AES-CTR-HMAC streaming in FIPS-mode.");
        }
        this.ikm = aesCtrHmacStreamingKey.getInitialKeyMaterial().toByteArray(InsecureSecretKeyAccess.get());
        AesCtrHmacStreamingParameters.HashType hkdfHashType = aesCtrHmacStreamingKey.getParameters().getHkdfHashType();
        AesCtrHmacStreamingParameters.HashType hashType = AesCtrHmacStreamingParameters.HashType.SHA1;
        String str2 = "";
        if (hkdfHashType.equals(hashType)) {
            str = "HmacSha1";
        } else if (aesCtrHmacStreamingKey.getParameters().getHkdfHashType().equals(AesCtrHmacStreamingParameters.HashType.SHA256)) {
            str = "HmacSha256";
        } else {
            str = aesCtrHmacStreamingKey.getParameters().getHkdfHashType().equals(AesCtrHmacStreamingParameters.HashType.SHA512) ? "HmacSha512" : "";
        }
        this.hkdfAlgo = str;
        this.keySizeInBytes = aesCtrHmacStreamingKey.getParameters().getDerivedKeySizeBytes();
        if (aesCtrHmacStreamingKey.getParameters().getHmacHashType().equals(hashType)) {
            str2 = "HmacSha1";
        } else if (aesCtrHmacStreamingKey.getParameters().getHmacHashType().equals(AesCtrHmacStreamingParameters.HashType.SHA256)) {
            str2 = "HmacSha256";
        } else if (aesCtrHmacStreamingKey.getParameters().getHmacHashType().equals(AesCtrHmacStreamingParameters.HashType.SHA512)) {
            str2 = "HmacSha512";
        }
        this.tagAlgo = str2;
        int hmacTagSizeBytes = aesCtrHmacStreamingKey.getParameters().getHmacTagSizeBytes();
        this.tagSizeInBytes = hmacTagSizeBytes;
        int ciphertextSegmentSizeBytes = aesCtrHmacStreamingKey.getParameters().getCiphertextSegmentSizeBytes();
        this.ciphertextSegmentSize = ciphertextSegmentSizeBytes;
        this.firstSegmentOffset = 0;
        this.plaintextSegmentSize = ciphertextSegmentSizeBytes - hmacTagSizeBytes;
    }

    public static StreamingAead create(AesCtrHmacStreamingKey aesCtrHmacStreamingKey) throws GeneralSecurityException {
        return new AesCtrHmacStreaming(aesCtrHmacStreamingKey);
    }

    private static void validateParameters(int i, int i2, String str, int i3, int i4, int i5) throws InvalidAlgorithmParameterException {
        if (i < 16 || i < i2) {
            throw new InvalidAlgorithmParameterException("ikm too short, must be >= " + Math.max(16, i2));
        }
        if (i5 < 0) {
            throw new InvalidAlgorithmParameterException("firstSegmentOffset must not be negative");
        }
        Validators.validateAesKeySize(i2);
        if (i3 < 10) {
            throw new InvalidAlgorithmParameterException("tag size too small " + i3);
        }
        if ((str.equals("HmacSha1") && i3 > 20) || ((str.equals("HmacSha256") && i3 > 32) || (str.equals("HmacSha512") && i3 > 64))) {
            throw new InvalidAlgorithmParameterException("tag size too big");
        }
        if ((((i4 - i5) - i3) - i2) - 8 <= 0) {
            throw new InvalidAlgorithmParameterException("ciphertextSegmentSize too small");
        }
    }

    @Override // com.google.crypto.tink.subtle.NonceBasedStreamingAead
    public AesCtrHmacStreamEncrypter newStreamSegmentEncrypter(byte[] bArr) throws GeneralSecurityException {
        return new AesCtrHmacStreamEncrypter(bArr);
    }

    @Override // com.google.crypto.tink.subtle.NonceBasedStreamingAead
    public AesCtrHmacStreamDecrypter newStreamSegmentDecrypter() throws GeneralSecurityException {
        return new AesCtrHmacStreamDecrypter();
    }

    @Override // com.google.crypto.tink.subtle.NonceBasedStreamingAead
    public int getCiphertextSegmentSize() {
        return this.ciphertextSegmentSize;
    }

    @Override // com.google.crypto.tink.subtle.NonceBasedStreamingAead
    public int getPlaintextSegmentSize() {
        return this.plaintextSegmentSize;
    }

    @Override // com.google.crypto.tink.subtle.NonceBasedStreamingAead
    public int getHeaderLength() {
        return this.keySizeInBytes + 8;
    }

    @Override // com.google.crypto.tink.subtle.NonceBasedStreamingAead
    public int getCiphertextOffset() {
        return getHeaderLength() + this.firstSegmentOffset;
    }

    @Override // com.google.crypto.tink.subtle.NonceBasedStreamingAead
    public int getCiphertextOverhead() {
        return this.tagSizeInBytes;
    }

    public int getFirstSegmentOffset() {
        return this.firstSegmentOffset;
    }

    public long expectedCiphertextSize(long j) {
        long ciphertextOffset = j + ((long) getCiphertextOffset());
        long j2 = this.plaintextSegmentSize;
        long j3 = (ciphertextOffset / j2) * ((long) this.ciphertextSegmentSize);
        long j4 = ciphertextOffset % j2;
        return j4 > 0 ? j3 + j4 + ((long) this.tagSizeInBytes) : j3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Cipher cipherInstance() throws GeneralSecurityException {
        return EngineFactory.CIPHER.getInstance("AES/CTR/NoPadding");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Mac macInstance() throws GeneralSecurityException {
        return EngineFactory.MAC.getInstance(this.tagAlgo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] randomSalt() {
        return Random.randBytes(this.keySizeInBytes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] nonceForSegment(byte[] bArr, long j, boolean z) throws GeneralSecurityException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(16);
        byteBufferAllocate.order(ByteOrder.BIG_ENDIAN);
        byteBufferAllocate.put(bArr);
        SubtleUtil.putAsUnsigedInt(byteBufferAllocate, j);
        byteBufferAllocate.put(z ? (byte) 1 : (byte) 0);
        byteBufferAllocate.putInt(0);
        return byteBufferAllocate.array();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] randomNonce() {
        return Random.randBytes(7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] deriveKeyMaterial(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        return Hkdf.computeHkdf(this.hkdfAlgo, this.ikm, bArr, bArr2, this.keySizeInBytes + 32);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SecretKeySpec deriveKeySpec(byte[] bArr) throws GeneralSecurityException {
        return new SecretKeySpec(bArr, 0, this.keySizeInBytes, "AES");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SecretKeySpec deriveHmacKeySpec(byte[] bArr) throws GeneralSecurityException {
        return new SecretKeySpec(bArr, this.keySizeInBytes, 32, this.tagAlgo);
    }

    /* JADX INFO: loaded from: classes5.dex */
    class AesCtrHmacStreamDecrypter implements StreamSegmentDecrypter {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private Cipher cipher;
        private SecretKeySpec hmacKeySpec;
        private SecretKeySpec keySpec;
        private Mac mac;
        private byte[] noncePrefix;

        AesCtrHmacStreamDecrypter() {
        }

        @Override // com.google.crypto.tink.subtle.StreamSegmentDecrypter
        public void init(ByteBuffer byteBuffer, byte[] bArr) throws GeneralSecurityException {
            synchronized (this) {
                if (byteBuffer.remaining() != AesCtrHmacStreaming.this.getHeaderLength()) {
                    throw new InvalidAlgorithmParameterException("Invalid header length");
                }
                if (byteBuffer.get() != AesCtrHmacStreaming.this.getHeaderLength()) {
                    throw new GeneralSecurityException("Invalid ciphertext");
                }
                this.noncePrefix = new byte[7];
                byte[] bArr2 = new byte[AesCtrHmacStreaming.this.keySizeInBytes];
                byteBuffer.get(bArr2);
                byteBuffer.get(this.noncePrefix);
                byte[] bArrDeriveKeyMaterial = AesCtrHmacStreaming.this.deriveKeyMaterial(bArr2, bArr);
                this.keySpec = AesCtrHmacStreaming.this.deriveKeySpec(bArrDeriveKeyMaterial);
                this.hmacKeySpec = AesCtrHmacStreaming.this.deriveHmacKeySpec(bArrDeriveKeyMaterial);
                this.cipher = AesCtrHmacStreaming.cipherInstance();
                this.mac = AesCtrHmacStreaming.this.macInstance();
            }
        }

        @Override // com.google.crypto.tink.subtle.StreamSegmentDecrypter
        public void decryptSegment(ByteBuffer byteBuffer, int i, boolean z, ByteBuffer byteBuffer2) throws GeneralSecurityException {
            synchronized (this) {
                int iPosition = AesCtrHmacStreaming.toBuffer(byteBuffer).position();
                byte[] bArrNonceForSegment = AesCtrHmacStreaming.this.nonceForSegment(this.noncePrefix, i, z);
                int iRemaining = byteBuffer.remaining();
                if (iRemaining >= AesCtrHmacStreaming.this.tagSizeInBytes) {
                    int i2 = iPosition + (iRemaining - AesCtrHmacStreaming.this.tagSizeInBytes);
                    ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
                    AesCtrHmacStreaming.toBuffer(byteBufferDuplicate).limit(i2);
                    ByteBuffer byteBufferDuplicate2 = byteBuffer.duplicate();
                    AesCtrHmacStreaming.toBuffer(byteBufferDuplicate2).position(i2);
                    this.mac.init(this.hmacKeySpec);
                    this.mac.update(bArrNonceForSegment);
                    this.mac.update(byteBufferDuplicate);
                    byte[] bArrCopyOf = Arrays.copyOf(this.mac.doFinal(), AesCtrHmacStreaming.this.tagSizeInBytes);
                    byte[] bArr = new byte[AesCtrHmacStreaming.this.tagSizeInBytes];
                    byteBufferDuplicate2.get(bArr);
                    if (Bytes.equal(bArr, bArrCopyOf)) {
                        AesCtrHmacStreaming.toBuffer(byteBuffer).limit(i2);
                        this.cipher.init(1, this.keySpec, new IvParameterSpec(bArrNonceForSegment));
                        this.cipher.doFinal(byteBuffer, byteBuffer2);
                    } else {
                        throw new GeneralSecurityException("Tag mismatch");
                    }
                } else {
                    throw new GeneralSecurityException("Ciphertext too short");
                }
            }
        }
    }
}
