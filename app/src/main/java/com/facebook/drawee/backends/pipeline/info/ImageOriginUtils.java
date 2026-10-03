package com.facebook.drawee.backends.pipeline.info;

import android.content.Context;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.security.keystore.KeyGenParameterSpec;
import android.telephony.cdma.CdmaCellLocation;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import ch.qos.logback.core.net.SyslogConstants;
import com.facebook.imagepipeline.producers.BitmapMemoryCacheGetProducer;
import com.facebook.imagepipeline.producers.BitmapMemoryCacheProducer;
import com.facebook.imagepipeline.producers.DataFetchProducer;
import com.facebook.imagepipeline.producers.DiskCacheReadProducer;
import com.facebook.imagepipeline.producers.EncodedMemoryCacheProducer;
import com.facebook.imagepipeline.producers.LocalAssetFetchProducer;
import com.facebook.imagepipeline.producers.LocalContentUriFetchProducer;
import com.facebook.imagepipeline.producers.LocalContentUriThumbnailFetchProducer;
import com.facebook.imagepipeline.producers.LocalFileFetchProducer;
import com.facebook.imagepipeline.producers.LocalResourceFetchProducer;
import com.facebook.imagepipeline.producers.LocalVideoThumbnailProducer;
import com.facebook.imagepipeline.producers.NetworkFetchProducer;
import com.facebook.imagepipeline.producers.PartialDiskCacheProducer;
import com.facebook.imagepipeline.producers.PostprocessedBitmapMemoryCacheProducer;
import com.facebook.imagepipeline.producers.QualifiedResourceFetchProducer;
import com.facebook.imageutils.JfifUtil;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.common.base.Ascii;
import com.google.common.collect.Lists;
import com.salesforce.marketingcloud.analytics.stats.b;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.LongBuffer;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import o.ArtificialStackFrames;
import o.artificialFrame;
import o.onPostMessage;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes2.dex */
public class ImageOriginUtils {
    private static final byte[] $$c = {44, 60, -60, 113};
    private static final int $$d = 167;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$a = {Ascii.GS, -31, -116, 88, Ascii.FF, 6, -27, Ascii.SYN, Ascii.SUB, -4, Ascii.FF, 0, 8, 2, 8};
    private static final int $$b = WebSocketProtocol.PAYLOAD_SHORT;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static char[] IPostMessageService = {38276, 38356, 38392, 38385, 38356, 38355, 38385, 38274, 38370, 38353, 38357, 38379, 38372, 38354, 38361, 38362, 38356, 38353, 38362, 38373, 38163, 38362, 38183, 38162, 38183, 38174, 38179, 38164, 38183, 38340, 38362, 38172, 38175, 38164, 38237, 38235, 38237, 38239, 38228, 38241, 38222, 38223, 38228, 38265, 38222, 38280, 38354, 38359, 38365, 38350, 38248, 38242, 38234, 38240, 38240, 38237, 38301, 38395, 38397, 38181, 38176, 38196, 38198, 38282, 38360, 38355, 38357, 38365, 38361, 38360, 38360, 38353, 38348, 38356, 38379, 38279, 38382, 38348, 38356, 38363, 38391, 38380, 38345, 38353, 38354, 38348, 38355, 38363, 38355, 38383, 38392, 38356, 38356, 38308, 38283, 38288, 38288, 38288, 38287, 38287, 38284, 38282, 38286, 38286, 38286, 38288, 38288, 38288, 38286, 38286, 38288, 38288, 38285, 38285, 38287, 38287, 38288, 38277, 38348, 38356, 38379, 38273, 38283, 38285, 38393, 38396, 38382, 38348, 38356, 38363, 38391, 38380, 38345, 38353, 38354, 38348, 38355, 38363, 38355, 38383, 38392, 38356, 38356, 38362, 38360, 38355, 38357, 38365, 38361, 38360, 38360, 38350, 38231, 38228, 38237, 38231, 38231, 38267, 38260, 38231, 38230, 38260, 38154, 38245, 38220, 38230, 38255, 38247, 38229, 38236, 38384, 38182, 38185, 38185, 38186, 38284, 38357, 38356, 38354, 38348, 38364, 38362, 38353, 38377, 38372, 38350, 38275, 38345, 38353, 38361, 38365, 38359, 38359, 38365, 38393, 38195, 38189, 38199, 38337, 38199, 38194, 38195, 38197, 38195, 38336, 38338, 38194, 38194, 38197, 38195, 38190, 38165, 38163, 38153, 38153, 38167, 38154, 38151, 38152, 38171, 38158, 38285, 38356, 38348, 38347, 38357, 38360, 38357, 38359, 38369, 38399, 38386, 38353, 38384, 38382, 38350, 38358, 38355, 38350, 38353, 38358, 38391, 38390, 38361, 38355, 38351, 38356, 38358, 38360, 38277, 38348, 38355, 38361, 38359, 38361};
    private static int[] ICustomTabsCallbackStub = {-83747858, 1341756316, -1975762342, -720245297, -372471247, -1779447797, -1358304997, 1931169585, 340179843, -1148555477, 1020326577, -841353491, 1028407450, -537514355, 685476946, 1438166803, -297787263, -847138315};

    /* JADX WARN: Code duplicated, block: B:10:0x0021  */
    /* JADX WARN: Code duplicated, block: B:8:0x001b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0021 -> B:11:0x002a). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0021
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$e(byte r6, byte r7, byte r8) {
        /*
            int r6 = r6 * 2
            int r6 = r6 + 4
            byte[] r0 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.$$c
            int r8 = r8 * 4
            int r1 = r8 + 1
            int r7 = 122 - r7
            byte[] r1 = new byte[r1]
            r2 = 0
            if (r0 != 0) goto L15
            r3 = r7
            r4 = r2
            r7 = r6
            goto L2a
        L15:
            r3 = r2
        L16:
            byte r4 = (byte) r7
            r1[r3] = r4
            if (r3 != r8) goto L21
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            return r6
        L21:
            int r3 = r3 + 1
            r4 = r0[r6]
            r5 = r7
            r7 = r6
            r6 = r4
            r4 = r3
            r3 = r5
        L2a:
            int r6 = -r6
            int r6 = r6 + r3
            int r7 = r7 + 1
            r3 = r4
            r5 = r7
            r7 = r6
            r6 = r5
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.$$e(byte, byte, byte):java.lang.String");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0027  */
    /* JADX WARN: Code duplicated, block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x002b). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0027
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void b(int r5, byte r6, short r7, java.lang.Object[] r8) {
        /*
            int r7 = r7 * 8
            int r7 = r7 + 4
            byte[] r0 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.$$a
            int r6 = r6 * 5
            int r1 = r6 + 4
            int r5 = r5 * 3
            int r5 = 115 - r5
            byte[] r1 = new byte[r1]
            int r6 = r6 + 3
            r2 = 0
            if (r0 != 0) goto L19
            r4 = r5
            r5 = r6
            r3 = r2
            goto L2b
        L19:
            r3 = r2
        L1a:
            byte r4 = (byte) r5
            r1[r3] = r4
            if (r3 != r6) goto L27
            java.lang.String r5 = new java.lang.String
            r5.<init>(r1, r2)
            r8[r2] = r5
            return
        L27:
            int r3 = r3 + 1
            r4 = r0[r7]
        L2b:
            int r5 = r5 + r4
            int r5 = r5 + (-7)
            int r7 = r7 + 1
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.b(int, byte, short, java.lang.Object[]):void");
    }

    public static String toString(int i) {
        switch (i) {
            case 2:
                return "network";
            case 3:
                return "disk";
            case 4:
                return "memory_encoded";
            case 5:
                return "memory_bitmap";
            case 6:
                return "memory_bitmap_shortcut";
            case 7:
                return ImagesContract.LOCAL;
            default:
                return "unknown";
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:65:0x00cd  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static int mapProducerNameToImageOrigin(String str) {
        byte b;
        str.hashCode();
        switch (str.hashCode()) {
            case -1917159454:
                if (!str.equals(QualifiedResourceFetchProducer.PRODUCER_NAME)) {
                    b = -1;
                } else {
                    b = 0;
                }
                break;
            case -1914072202:
                if (!str.equals(BitmapMemoryCacheGetProducer.PRODUCER_NAME)) {
                    b = -1;
                } else {
                    b = 1;
                }
                break;
            case -1683996557:
                if (!str.equals(LocalResourceFetchProducer.PRODUCER_NAME)) {
                    b = -1;
                } else {
                    b = 2;
                }
                break;
            case -1579985851:
                if (!str.equals(LocalFileFetchProducer.PRODUCER_NAME)) {
                    b = -1;
                } else {
                    b = 3;
                }
                break;
            case -1307634203:
                if (!str.equals(EncodedMemoryCacheProducer.PRODUCER_NAME)) {
                    b = -1;
                } else {
                    b = 4;
                }
                break;
            case -1224383234:
                if (!str.equals(NetworkFetchProducer.PRODUCER_NAME)) {
                    b = -1;
                } else {
                    b = 5;
                }
                break;
            case 473552259:
                if (!str.equals(LocalVideoThumbnailProducer.PRODUCER_NAME)) {
                    b = -1;
                } else {
                    b = 6;
                }
                break;
            case 656304759:
                if (!str.equals(DiskCacheReadProducer.PRODUCER_NAME)) {
                    b = -1;
                } else {
                    b = 7;
                }
                break;
            case 957714404:
                if (!str.equals(BitmapMemoryCacheProducer.PRODUCER_NAME)) {
                    b = -1;
                } else {
                    b = 8;
                }
                break;
            case 1019542023:
                if (!str.equals(LocalAssetFetchProducer.PRODUCER_NAME)) {
                    b = -1;
                } else {
                    b = 9;
                }
                break;
            case 1023071510:
                if (!str.equals(PostprocessedBitmapMemoryCacheProducer.PRODUCER_NAME)) {
                    b = -1;
                } else {
                    b = 10;
                }
                break;
            case 1721672898:
                if (!str.equals(DataFetchProducer.PRODUCER_NAME)) {
                    b = -1;
                } else {
                    b = Ascii.VT;
                }
                break;
            case 1793127518:
                if (!str.equals(LocalContentUriThumbnailFetchProducer.PRODUCER_NAME)) {
                    b = -1;
                } else {
                    b = Ascii.FF;
                }
                break;
            case 2109593398:
                if (!str.equals(PartialDiskCacheProducer.PRODUCER_NAME)) {
                    b = -1;
                } else {
                    b = Ascii.CR;
                }
                break;
            case 2113652014:
                if (!str.equals(LocalContentUriFetchProducer.PRODUCER_NAME)) {
                    b = -1;
                } else {
                    b = Ascii.SO;
                }
                break;
            default:
                b = -1;
                break;
        }
        switch (b) {
            case 0:
            case 2:
            case 3:
            case 6:
            case 9:
            case 11:
            case 12:
            case 14:
                return 7;
            case 1:
            case 8:
            case 10:
                return 5;
            case 4:
                return 4;
            case 5:
                return 2;
            case 7:
            case 13:
                return 3;
            default:
                return 1;
        }
    }

    private ImageOriginUtils() {
    }

    private static void c(int i, int[] iArr, Object[] objArr) throws Throwable {
        int i2;
        int i3 = 2 % 2;
        artificialFrame artificialframe = new artificialFrame();
        char[] cArr = new char[4];
        char[] cArr2 = new char[iArr.length * 2];
        int[] iArr2 = ICustomTabsCallbackStub;
        int i4 = -1780896814;
        char c = '0';
        int i5 = 1;
        int i6 = 0;
        if (iArr2 != null) {
            int length = iArr2.length;
            int[] iArr3 = new int[length];
            int i7 = $10 + 3;
            $11 = i7 % 128;
            int i8 = i7 % 2;
            int i9 = 0;
            while (i9 < length) {
                try {
                    Object[] objArr2 = {Integer.valueOf(iArr2[i9])};
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(i4);
                    if (objAccessartificialFrame == null) {
                        byte b = (byte) 0;
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(12 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), (char) ('0' - AndroidCharacter.getMirror(c)), 1562 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), 180153818, false, $$e(b, (byte) (b | Ascii.CR), b), new Class[]{Integer.TYPE});
                    }
                    iArr3[i9] = ((Integer) ((Method) objAccessartificialFrame).invoke(null, objArr2)).intValue();
                    i9++;
                    int i10 = $10 + 1;
                    $11 = i10 % 128;
                    if (i10 % 2 == 0) {
                        int i11 = 3 / 3;
                    }
                    i4 = -1780896814;
                    c = '0';
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
            int i12 = $11 + 123;
            $10 = i12 % 128;
            int i13 = i12 % 2;
            iArr2 = iArr3;
        }
        int length2 = iArr2.length;
        int[] iArr4 = new int[length2];
        int[] iArr5 = ICustomTabsCallbackStub;
        long j = 0;
        if (iArr5 != null) {
            int length3 = iArr5.length;
            int[] iArr6 = new int[length3];
            int i14 = 0;
            while (i14 < length3) {
                try {
                    Object[] objArr3 = new Object[i5];
                    objArr3[i6] = Integer.valueOf(iArr5[i14]);
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1780896814);
                    if (objAccessartificialFrame2 == null) {
                        byte b2 = (byte) i6;
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(TextUtils.indexOf("", "", i6, i6) + 11, (char) ((ViewConfiguration.getZoomControlsTimeout() > j ? 1 : (ViewConfiguration.getZoomControlsTimeout() == j ? 0 : -1)) - 1), TextUtils.indexOf((CharSequence) "", '0', i6, i6) + 1563, 180153818, false, $$e(b2, (byte) (b2 | Ascii.CR), b2), new Class[]{Integer.TYPE});
                    }
                    iArr6[i14] = ((Integer) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).intValue();
                    i14++;
                    j = 0;
                    i5 = 1;
                    i6 = 0;
                } catch (Throwable th2) {
                    Throwable cause2 = th2.getCause();
                    if (cause2 == null) {
                        throw th2;
                    }
                    throw cause2;
                }
            }
            i2 = i6;
            iArr5 = iArr6;
        } else {
            i2 = 0;
        }
        System.arraycopy(iArr5, i2, iArr4, i2, length2);
        artificialframe.e = i2;
        while (artificialframe.e < iArr.length) {
            cArr[i2] = (char) (iArr[artificialframe.e] >> 16);
            cArr[1] = (char) iArr[artificialframe.e];
            cArr[2] = (char) (iArr[artificialframe.e + 1] >> 16);
            cArr[3] = (char) iArr[artificialframe.e + 1];
            artificialframe.c = (cArr[0] << 16) + cArr[1];
            artificialframe.b = (cArr[2] << 16) + cArr[3];
            artificialFrame.coroutineBoundary(iArr4);
            int i15 = 0;
            while (i15 < 16) {
                int i16 = $11 + 113;
                $10 = i16 % 128;
                if (i16 % 2 != 0) {
                    artificialframe.c ^= iArr4[i15];
                    Object[] objArr4 = {artificialframe, Integer.valueOf(artificialFrame.coroutineBoundary(artificialframe.c)), artificialframe, artificialframe};
                    Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1540318455);
                    if (objAccessartificialFrame3 == null) {
                        byte b3 = (byte) 0;
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation((Process.myPid() >> 22) + 26, (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16), 1041 - Color.argb(0, 0, 0, 0), 995482881, false, $$e(b3, (byte) (b3 | 7), b3), new Class[]{Object.class, Integer.TYPE, Object.class, Object.class});
                    }
                    int iIntValue = ((Integer) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).intValue();
                    artificialframe.c = artificialframe.b;
                    artificialframe.b = iIntValue;
                    i15 += 82;
                } else {
                    artificialframe.c ^= iArr4[i15];
                    Object[] objArr5 = {artificialframe, Integer.valueOf(artificialFrame.coroutineBoundary(artificialframe.c)), artificialframe, artificialframe};
                    Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1540318455);
                    if (objAccessartificialFrame4 == null) {
                        byte b4 = (byte) 0;
                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(KeyEvent.keyCodeFromString("") + 26, (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16), (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 1040, 995482881, false, $$e(b4, (byte) (b4 | 7), b4), new Class[]{Object.class, Integer.TYPE, Object.class, Object.class});
                    }
                    int iIntValue2 = ((Integer) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).intValue();
                    artificialframe.c = artificialframe.b;
                    artificialframe.b = iIntValue2;
                    i15++;
                }
            }
            int i17 = artificialframe.c;
            artificialframe.c = artificialframe.b;
            artificialframe.b = i17;
            artificialframe.b ^= iArr4[16];
            artificialframe.c ^= iArr4[17];
            int i18 = artificialframe.c;
            int i19 = artificialframe.b;
            cArr[0] = (char) (artificialframe.c >>> 16);
            cArr[1] = (char) artificialframe.c;
            cArr[2] = (char) (artificialframe.b >>> 16);
            cArr[3] = (char) artificialframe.b;
            artificialFrame.coroutineBoundary(iArr4);
            cArr2[artificialframe.e * 2] = cArr[0];
            cArr2[(artificialframe.e * 2) + 1] = cArr[1];
            cArr2[(artificialframe.e * 2) + 2] = cArr[2];
            cArr2[(artificialframe.e * 2) + 3] = cArr[3];
            Object[] objArr6 = {artificialframe, artificialframe};
            Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(1348396126);
            if (objAccessartificialFrame5 == null) {
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 37, (char) (28010 - (ViewConfiguration.getPressedStateDuration() >> 16)), 307 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), -818175402, false, "q", new Class[]{Object.class, Object.class});
            }
            ((Method) objAccessartificialFrame5).invoke(null, objArr6);
            i2 = 0;
        }
        objArr[0] = new String(cArr2, 0, i);
    }

    private static void a(byte[] bArr, int[] iArr, boolean z, Object[] objArr) throws Throwable {
        int i;
        int length;
        char[] cArr;
        int i2;
        int i3 = 2 % 2;
        onPostMessage onpostmessage = new onPostMessage();
        int i4 = 0;
        int i5 = iArr[0];
        int i6 = iArr[1];
        int i7 = iArr[2];
        int i8 = iArr[3];
        char[] cArr2 = IPostMessageService;
        if (cArr2 != null) {
            int i9 = $10 + 9;
            $11 = i9 % 128;
            if (i9 % 2 == 0) {
                length = cArr2.length;
                cArr = new char[length];
                i2 = 1;
            } else {
                length = cArr2.length;
                cArr = new char[length];
                i2 = 0;
            }
            while (i2 < length) {
                try {
                    Object[] objArr2 = new Object[1];
                    objArr2[i4] = Integer.valueOf(cArr2[i2]);
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1782207618);
                    if (objAccessartificialFrame == null) {
                        byte b = (byte) i4;
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(11 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (char) Drawable.resolveOpacity(i4, i4), (ViewConfiguration.getWindowTouchSlop() >> 8) + 1562, 178318710, false, $$e(b, (byte) (b | 57), b), new Class[]{Integer.TYPE});
                    }
                    cArr[i2] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                    i2++;
                    i4 = 0;
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
            cArr2 = cArr;
        }
        char[] cArr3 = new char[i6];
        System.arraycopy(cArr2, i5, cArr3, 0, i6);
        if (bArr != null) {
            char[] cArr4 = new char[i6];
            onpostmessage.a = 0;
            char c = 0;
            while (onpostmessage.a < i6) {
                if (bArr[onpostmessage.a] == 1) {
                    int i10 = onpostmessage.a;
                    Object[] objArr3 = {Integer.valueOf(cArr3[onpostmessage.a]), Integer.valueOf(c)};
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1378437083);
                    if (objAccessartificialFrame2 == null) {
                        byte b2 = (byte) 0;
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(ExpandableListView.getPackedPositionGroup(0L) + 23, (char) TextUtils.indexOf("", "", 0, 0), (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 2441, -850656813, false, $$e(b2, (byte) (b2 | 54), b2), new Class[]{Integer.TYPE, Integer.TYPE});
                    }
                    cArr4[i10] = ((Character) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).charValue();
                } else {
                    int i11 = onpostmessage.a;
                    Object[] objArr4 = {Integer.valueOf(cArr3[onpostmessage.a]), Integer.valueOf(c)};
                    Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-314759072);
                    if (objAccessartificialFrame3 == null) {
                        byte b3 = (byte) 0;
                        byte b4 = b3;
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(11 - (KeyEvent.getMaxKeyCode() >> 16), (char) TextUtils.getOffsetBefore("", 0), 1563 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), 1918398056, false, $$e(b3, b4, b4), new Class[]{Integer.TYPE, Integer.TYPE});
                    }
                    cArr4[i11] = ((Character) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).charValue();
                }
                c = cArr4[onpostmessage.a];
                Object[] objArr5 = {onpostmessage, onpostmessage};
                Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(898481158);
                if (objAccessartificialFrame4 == null) {
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(22 - ((Process.getThreadPriority(0) + 20) >> 6), (char) (29362 - ImageFormat.getBitsPerPixel(0)), 215 - View.MeasureSpec.getMode(0), -1427572210, false, "F", new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame4).invoke(null, objArr5);
            }
            cArr3 = cArr4;
        }
        if (i8 > 0) {
            char[] cArr5 = new char[i6];
            i = 0;
            System.arraycopy(cArr3, 0, cArr5, 0, i6);
            int i12 = i6 - i8;
            System.arraycopy(cArr5, 0, cArr3, i12, i8);
            System.arraycopy(cArr5, i8, cArr3, 0, i12);
        } else {
            i = 0;
        }
        if (z) {
            char[] cArr6 = new char[i6];
            while (true) {
                onpostmessage.a = i;
                if (onpostmessage.a >= i6) {
                    break;
                }
                cArr6[onpostmessage.a] = cArr3[(i6 - onpostmessage.a) - 1];
                i = onpostmessage.a + 1;
            }
            cArr3 = cArr6;
        }
        if (i7 > 0) {
            int i13 = $11 + 91;
            $10 = i13 % 128;
            int i14 = i13 % 2;
            int i15 = 0;
            while (true) {
                onpostmessage.a = i15;
                if (onpostmessage.a >= i6) {
                    break;
                }
                int i16 = $11 + b.f40o;
                $10 = i16 % 128;
                int i17 = i16 % 2;
                cArr3[onpostmessage.a] = (char) (cArr3[onpostmessage.a] - iArr[2]);
                i15 = onpostmessage.a + 1;
            }
        }
        objArr[0] = new String(cArr3);
    }

    /* JADX WARN: Code duplicated, block: B:1112:0x0b82 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:1118:0x0b77 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:1191:0x3256 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:1193:0x330e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:1194:0x32da A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:1196:0x3233 A[EDGE_INSN: B:1196:0x3233->B:931:0x3233 BREAK  A[LOOP:11: B:897:0x2f4b->B:920:0x320f], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:1206:? A[Catch: Exception -> 0x2014, SYNTHETIC, TRY_ENTER, TRY_LEAVE, TryCatch #38 {Exception -> 0x2014, blocks: (B:214:0x0c1d, B:217:0x0c25, B:219:0x0c2d, B:223:0x0cab, B:266:0x0fc7, B:268:0x0fd3, B:269:0x0ffc, B:271:0x100d, B:272:0x1033, B:314:0x132a, B:316:0x1358, B:317:0x1384, B:319:0x139d, B:320:0x13c2, B:323:0x13d8, B:325:0x13e5, B:326:0x1410, B:327:0x141f, B:330:0x142f, B:332:0x143c, B:333:0x1463, B:335:0x1472, B:336:0x1496, B:338:0x14a0, B:340:0x14a9, B:341:0x14d7, B:343:0x14df, B:345:0x14e8, B:346:0x1516, B:403:0x189a, B:405:0x18a0, B:406:0x18ca, B:408:0x18db, B:409:0x1901, B:455:0x1c11, B:561:0x1d94, B:489:0x1c90, B:491:0x1c92, B:493:0x1c99, B:494:0x1c9a, B:496:0x1c9c, B:498:0x1ca3, B:499:0x1ca4, B:347:0x1520, B:349:0x1529, B:350:0x1551, B:352:0x1560, B:353:0x158a, B:400:0x1893, B:552:0x1d82, B:553:0x1d85, B:555:0x1d87, B:557:0x1d8e, B:558:0x1d8f, B:563:0x1d9c, B:564:0x1da2, B:566:0x1dab, B:567:0x1dd0, B:573:0x1e15, B:574:0x1e24, B:576:0x1e2a, B:578:0x1e37, B:579:0x1e5f, B:581:0x1e70, B:582:0x1e9c, B:585:0x1eb2, B:587:0x1eb9, B:588:0x1eba, B:621:0x1f32, B:623:0x1f34, B:625:0x1f3b, B:626:0x1f3c, B:628:0x1f3e, B:630:0x1f45, B:631:0x1f46, B:664:0x1fc0, B:666:0x1fc2, B:668:0x1fc9, B:669:0x1fca, B:671:0x1fcc, B:673:0x1fd3, B:674:0x1fd4, B:675:0x1fd5, B:677:0x1fe5, B:679:0x1fec, B:680:0x1fed, B:682:0x1fef, B:684:0x1ff6, B:685:0x1ff7, B:108:0x0aa9, B:687:0x1ff9, B:689:0x2000, B:690:0x2001, B:197:0x0b77, B:198:0x0b7a, B:202:0x0b82, B:692:0x2003, B:694:0x200e, B:695:0x200f, B:277:0x10ad, B:279:0x10b3, B:280:0x10dd, B:285:0x1127, B:287:0x112d, B:288:0x1159, B:293:0x11a5, B:295:0x11ab, B:296:0x11d2, B:302:0x122c, B:304:0x1232, B:305:0x125a, B:591:0x1ebd, B:593:0x1ec3, B:594:0x1ec4, B:596:0x1ec6, B:598:0x1ecd, B:599:0x1ece, B:601:0x1ed0, B:603:0x1ed7, B:604:0x1ed8, B:606:0x1eda, B:608:0x1ee1, B:609:0x1ee2, B:611:0x1ee4, B:613:0x1eeb, B:614:0x1eec, B:310:0x12c2, B:312:0x12cf, B:313:0x1324, B:306:0x1260, B:308:0x126d, B:309:0x12bc, B:298:0x11d9, B:300:0x11ee, B:301:0x1226, B:289:0x115f, B:291:0x116c, B:292:0x1199, B:281:0x10e3, B:283:0x10f0, B:284:0x1121, B:569:0x1de0, B:571:0x1de6, B:572:0x1e0e, B:617:0x1eef, B:619:0x1efc, B:620:0x1f2a, B:273:0x1040, B:275:0x104d, B:276:0x10a5, B:660:0x1f7b, B:662:0x1f88, B:663:0x1fb8, B:224:0x0cd6, B:226:0x0ce3, B:227:0x0d3e, B:359:0x15fa, B:361:0x1600, B:362:0x1629, B:368:0x167a, B:370:0x1680, B:371:0x16a7, B:377:0x16fd, B:379:0x1703, B:380:0x172d, B:387:0x1788, B:389:0x178e, B:390:0x17b6, B:502:0x1ca7, B:504:0x1cad, B:505:0x1cae, B:507:0x1cb0, B:509:0x1cb7, B:510:0x1cb8, B:512:0x1cba, B:514:0x1cc1, B:515:0x1cc2, B:517:0x1cc4, B:519:0x1ccb, B:520:0x1ccc, B:522:0x1cce, B:524:0x1cd5, B:525:0x1cd6, B:534:0x1d26, B:546:0x1d77, B:548:0x1d79, B:550:0x1d80, B:551:0x1d81, B:536:0x1d28, B:538:0x1d2f, B:539:0x1d30, B:229:0x0d49, B:231:0x0d4f, B:232:0x0d77, B:237:0x0dbf, B:239:0x0dc5, B:240:0x0ded, B:245:0x0e40, B:247:0x0e46, B:248:0x0e6f, B:254:0x0ec8, B:256:0x0ece, B:257:0x0ef5, B:634:0x1f49, B:636:0x1f4f, B:637:0x1f50, B:639:0x1f52, B:641:0x1f59, B:642:0x1f5a, B:644:0x1f5c, B:646:0x1f63, B:647:0x1f64, B:649:0x1f66, B:651:0x1f6d, B:652:0x1f6e, B:654:0x1f70, B:656:0x1f77, B:657:0x1f78, B:221:0x0c56, B:209:0x0be5, B:211:0x0beb, B:212:0x0c12, B:204:0x0b87, B:206:0x0ba0, B:207:0x0bdc, B:49:0x046d, B:354:0x1590, B:356:0x159d, B:357:0x15ef, B:485:0x1c4a, B:487:0x1c57, B:488:0x1c88, B:415:0x1977, B:417:0x197d, B:418:0x19aa, B:424:0x19ff, B:426:0x1a05, B:427:0x1a2e, B:433:0x1a85, B:435:0x1a8b, B:436:0x1ab5, B:443:0x1b16, B:445:0x1b1c, B:446:0x1b44, B:459:0x1c18, B:461:0x1c1e, B:462:0x1c1f, B:464:0x1c21, B:466:0x1c28, B:467:0x1c29, B:469:0x1c2b, B:471:0x1c32, B:472:0x1c33, B:474:0x1c35, B:476:0x1c3c, B:477:0x1c3d, B:479:0x1c3f, B:481:0x1c46, B:482:0x1c47, B:410:0x190e, B:412:0x191b, B:413:0x196c), top: B:1078:0x03f6, inners: #3, #12, #13, #26, #30, #37, #49, #50, #58, #67, #73, #78, #82, #85, #90, #91 }] */
    /* JADX WARN: Code duplicated, block: B:206:0x0ba0 A[Catch: all -> 0x1ff8, TryCatch #73 {all -> 0x1ff8, blocks: (B:204:0x0b87, B:206:0x0ba0, B:207:0x0bdc), top: B:1133:0x0b87, outer: #38 }] */
    /* JADX WARN: Code duplicated, block: B:211:0x0beb A[Catch: all -> 0x1fee, TryCatch #67 {all -> 0x1fee, blocks: (B:209:0x0be5, B:211:0x0beb, B:212:0x0c12), top: B:1122:0x0be5, outer: #38 }] */
    /* JADX WARN: Code duplicated, block: B:697:0x2014 A[EDGE_INSN: B:697:0x2014->B:698:0x2015 BREAK  A[LOOP:1: B:218:0x0c2b->B:675:0x1fd5], PHI: r8 r11 r23
  0x2014: PHI (r8v167 java.lang.String) = 
  (r8v3 java.lang.String)
  (r8v221 java.lang.String)
  (r8v263 java.lang.String)
  (r8v263 java.lang.String)
  (r8v263 java.lang.String)
 binds: [B:696:0x2010, B:1002:0x2014, B:213:0x0c1b, B:1176:0x2014, B:216:0x0c23] A[DONT_GENERATE, DONT_INLINE]
  0x2014: PHI (r11v6 ??) = (r11v5 ??), (r11v10 ??), (r11v50 ??), (r11v50 ??), (r11v50 ??) binds: [B:696:0x2010, B:1002:0x2014, B:213:0x0c1b, B:1176:0x2014, B:216:0x0c23] A[DONT_GENERATE, DONT_INLINE]
  0x2014: PHI (r23v16 ??) = (r23v15 ??), (r23v21 ??), (r23v40 ??), (r23v40 ??), (r23v40 ??) binds: [B:696:0x2010, B:1002:0x2014, B:213:0x0c1b, B:1176:0x2014, B:216:0x0c23] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:748:0x2333  */
    /* JADX WARN: Code duplicated, block: B:751:0x233a  */
    /* JADX WARN: Code duplicated, block: B:752:0x233c  */
    /* JADX WARN: Code duplicated, block: B:754:0x2344  */
    /* JADX WARN: Code duplicated, block: B:755:0x2350  */
    /* JADX WARN: Code duplicated, block: B:758:0x2420  */
    /* JADX WARN: Code duplicated, block: B:761:0x246a  */
    /* JADX WARN: Code duplicated, block: B:762:0x246d  */
    /* JADX WARN: Code duplicated, block: B:768:0x247d  */
    /* JADX WARN: Code duplicated, block: B:770:0x2484  */
    /* JADX WARN: Code duplicated, block: B:772:0x248d  */
    /* JADX WARN: Code duplicated, block: B:775:0x24e9  */
    /* JADX WARN: Code duplicated, block: B:778:0x253f A[EDGE_INSN: B:778:0x253f->B:8:0x01a8 BREAK  A[LOOP:0: B:10:0x01cf->B:19:0x0326]] */
    /* JADX WARN: Code duplicated, block: B:779:0x25fd  */
    /* JADX WARN: Code duplicated, block: B:782:0x2603  */
    /* JADX WARN: Code duplicated, block: B:784:0x2666 A[Catch: all -> 0x340e, TryCatch #84 {all -> 0x340e, blocks: (B:783:0x2604, B:784:0x2666, B:786:0x266e, B:792:0x26bb, B:800:0x2766, B:802:0x276e, B:803:0x2780, B:810:0x2798, B:805:0x278b, B:807:0x2792, B:808:0x2793, B:812:0x27a1, B:814:0x27a8, B:815:0x27a9, B:819:0x27bd, B:827:0x28a7, B:829:0x2911, B:831:0x291a, B:833:0x2989, B:835:0x2997, B:837:0x29a1, B:839:0x2a04, B:841:0x2a0b, B:844:0x2a6e, B:863:0x2c09, B:865:0x2c14, B:871:0x2c61, B:872:0x2caf, B:874:0x2cd2, B:879:0x2d28, B:909:0x3102, B:913:0x311c, B:920:0x320f, B:922:0x3220, B:924:0x3227, B:925:0x3228, B:927:0x322a, B:929:0x3231, B:930:0x3232, B:938:0x3249, B:940:0x3256, B:933:0x3239, B:935:0x3240, B:936:0x3241, B:947:0x32de, B:949:0x32e4, B:950:0x32e5, B:952:0x32e7, B:954:0x32ee, B:955:0x32ef, B:957:0x32f1, B:959:0x32f8, B:960:0x32f9, B:962:0x32fb, B:964:0x3302, B:965:0x3303, B:967:0x3305, B:969:0x330c, B:970:0x330d, B:971:0x330e, B:972:0x3311, B:973:0x3312, B:873:0x2cb2, B:975:0x3338, B:977:0x333f, B:978:0x3340, B:979:0x3341, B:980:0x337b, B:982:0x3381, B:983:0x3396, B:985:0x33f3, B:987:0x33fa, B:988:0x33fb, B:990:0x33fd, B:992:0x3404, B:993:0x3405, B:994:0x3406, B:996:0x340c, B:997:0x340d, B:846:0x2ae1, B:848:0x2ae8, B:849:0x2ae9, B:788:0x2671, B:917:0x3120, B:867:0x2c17, B:900:0x2f5f, B:902:0x2f74, B:905:0x309a, B:907:0x30f6, B:906:0x30c9, B:901:0x2f6a, B:888:0x2eae, B:890:0x2ec4, B:894:0x2f2e, B:944:0x32db, B:821:0x27d0, B:823:0x27f6, B:825:0x2851, B:886:0x2e68, B:885:0x2ded, B:862:0x2baa, B:882:0x2d62, B:884:0x2d8f, B:860:0x2b61, B:880:0x2d2a, B:793:0x26bf, B:797:0x2727, B:799:0x275b, B:798:0x273a, B:854:0x2afa, B:855:0x2b12, B:859:0x2b38, B:858:0x2b19, B:919:0x317d), top: B:1151:0x2601, inners: #0, #7, #17, #18, #54, #56, #62, #70, #71, #75, #76, #80, #83, #88, #93 }] */
    /* JADX WARN: Code duplicated, block: B:786:0x266e A[Catch: all -> 0x340e, TRY_LEAVE, TryCatch #84 {all -> 0x340e, blocks: (B:783:0x2604, B:784:0x2666, B:786:0x266e, B:792:0x26bb, B:800:0x2766, B:802:0x276e, B:803:0x2780, B:810:0x2798, B:805:0x278b, B:807:0x2792, B:808:0x2793, B:812:0x27a1, B:814:0x27a8, B:815:0x27a9, B:819:0x27bd, B:827:0x28a7, B:829:0x2911, B:831:0x291a, B:833:0x2989, B:835:0x2997, B:837:0x29a1, B:839:0x2a04, B:841:0x2a0b, B:844:0x2a6e, B:863:0x2c09, B:865:0x2c14, B:871:0x2c61, B:872:0x2caf, B:874:0x2cd2, B:879:0x2d28, B:909:0x3102, B:913:0x311c, B:920:0x320f, B:922:0x3220, B:924:0x3227, B:925:0x3228, B:927:0x322a, B:929:0x3231, B:930:0x3232, B:938:0x3249, B:940:0x3256, B:933:0x3239, B:935:0x3240, B:936:0x3241, B:947:0x32de, B:949:0x32e4, B:950:0x32e5, B:952:0x32e7, B:954:0x32ee, B:955:0x32ef, B:957:0x32f1, B:959:0x32f8, B:960:0x32f9, B:962:0x32fb, B:964:0x3302, B:965:0x3303, B:967:0x3305, B:969:0x330c, B:970:0x330d, B:971:0x330e, B:972:0x3311, B:973:0x3312, B:873:0x2cb2, B:975:0x3338, B:977:0x333f, B:978:0x3340, B:979:0x3341, B:980:0x337b, B:982:0x3381, B:983:0x3396, B:985:0x33f3, B:987:0x33fa, B:988:0x33fb, B:990:0x33fd, B:992:0x3404, B:993:0x3405, B:994:0x3406, B:996:0x340c, B:997:0x340d, B:846:0x2ae1, B:848:0x2ae8, B:849:0x2ae9, B:788:0x2671, B:917:0x3120, B:867:0x2c17, B:900:0x2f5f, B:902:0x2f74, B:905:0x309a, B:907:0x30f6, B:906:0x30c9, B:901:0x2f6a, B:888:0x2eae, B:890:0x2ec4, B:894:0x2f2e, B:944:0x32db, B:821:0x27d0, B:823:0x27f6, B:825:0x2851, B:886:0x2e68, B:885:0x2ded, B:862:0x2baa, B:882:0x2d62, B:884:0x2d8f, B:860:0x2b61, B:880:0x2d2a, B:793:0x26bf, B:797:0x2727, B:799:0x275b, B:798:0x273a, B:854:0x2afa, B:855:0x2b12, B:859:0x2b38, B:858:0x2b19, B:919:0x317d), top: B:1151:0x2601, inners: #0, #7, #17, #18, #54, #56, #62, #70, #71, #75, #76, #80, #83, #88, #93 }] */
    /* JADX WARN: Code duplicated, block: B:791:0x26b9  */
    /* JADX WARN: Code duplicated, block: B:796:0x2719  */
    /* JADX WARN: Code duplicated, block: B:798:0x273a A[Catch: all -> 0x278a, TryCatch #83 {all -> 0x278a, blocks: (B:793:0x26bf, B:797:0x2727, B:799:0x275b, B:798:0x273a), top: B:1149:0x26bf, outer: #84 }] */
    /* JADX WARN: Code duplicated, block: B:802:0x276e A[Catch: all -> 0x340e, LOOP:8: B:801:0x276c->B:802:0x276e, LOOP_END, TryCatch #84 {all -> 0x340e, blocks: (B:783:0x2604, B:784:0x2666, B:786:0x266e, B:792:0x26bb, B:800:0x2766, B:802:0x276e, B:803:0x2780, B:810:0x2798, B:805:0x278b, B:807:0x2792, B:808:0x2793, B:812:0x27a1, B:814:0x27a8, B:815:0x27a9, B:819:0x27bd, B:827:0x28a7, B:829:0x2911, B:831:0x291a, B:833:0x2989, B:835:0x2997, B:837:0x29a1, B:839:0x2a04, B:841:0x2a0b, B:844:0x2a6e, B:863:0x2c09, B:865:0x2c14, B:871:0x2c61, B:872:0x2caf, B:874:0x2cd2, B:879:0x2d28, B:909:0x3102, B:913:0x311c, B:920:0x320f, B:922:0x3220, B:924:0x3227, B:925:0x3228, B:927:0x322a, B:929:0x3231, B:930:0x3232, B:938:0x3249, B:940:0x3256, B:933:0x3239, B:935:0x3240, B:936:0x3241, B:947:0x32de, B:949:0x32e4, B:950:0x32e5, B:952:0x32e7, B:954:0x32ee, B:955:0x32ef, B:957:0x32f1, B:959:0x32f8, B:960:0x32f9, B:962:0x32fb, B:964:0x3302, B:965:0x3303, B:967:0x3305, B:969:0x330c, B:970:0x330d, B:971:0x330e, B:972:0x3311, B:973:0x3312, B:873:0x2cb2, B:975:0x3338, B:977:0x333f, B:978:0x3340, B:979:0x3341, B:980:0x337b, B:982:0x3381, B:983:0x3396, B:985:0x33f3, B:987:0x33fa, B:988:0x33fb, B:990:0x33fd, B:992:0x3404, B:993:0x3405, B:994:0x3406, B:996:0x340c, B:997:0x340d, B:846:0x2ae1, B:848:0x2ae8, B:849:0x2ae9, B:788:0x2671, B:917:0x3120, B:867:0x2c17, B:900:0x2f5f, B:902:0x2f74, B:905:0x309a, B:907:0x30f6, B:906:0x30c9, B:901:0x2f6a, B:888:0x2eae, B:890:0x2ec4, B:894:0x2f2e, B:944:0x32db, B:821:0x27d0, B:823:0x27f6, B:825:0x2851, B:886:0x2e68, B:885:0x2ded, B:862:0x2baa, B:882:0x2d62, B:884:0x2d8f, B:860:0x2b61, B:880:0x2d2a, B:793:0x26bf, B:797:0x2727, B:799:0x275b, B:798:0x273a, B:854:0x2afa, B:855:0x2b12, B:859:0x2b38, B:858:0x2b19, B:919:0x317d), top: B:1151:0x2601, inners: #0, #7, #17, #18, #54, #56, #62, #70, #71, #75, #76, #80, #83, #88, #93 }] */
    /* JADX WARN: Code duplicated, block: B:809:0x2794  */
    /* JADX WARN: Code duplicated, block: B:818:0x27ae  */
    /* JADX WARN: Code duplicated, block: B:823:0x27f6 A[Catch: all -> 0x2ae0, TryCatch #56 {all -> 0x2ae0, blocks: (B:821:0x27d0, B:823:0x27f6, B:825:0x2851), top: B:1104:0x27d0, outer: #84 }] */
    /* JADX WARN: Code duplicated, block: B:824:0x284f  */
    /* JADX WARN: Code duplicated, block: B:829:0x2911 A[Catch: all -> 0x340e, TryCatch #84 {all -> 0x340e, blocks: (B:783:0x2604, B:784:0x2666, B:786:0x266e, B:792:0x26bb, B:800:0x2766, B:802:0x276e, B:803:0x2780, B:810:0x2798, B:805:0x278b, B:807:0x2792, B:808:0x2793, B:812:0x27a1, B:814:0x27a8, B:815:0x27a9, B:819:0x27bd, B:827:0x28a7, B:829:0x2911, B:831:0x291a, B:833:0x2989, B:835:0x2997, B:837:0x29a1, B:839:0x2a04, B:841:0x2a0b, B:844:0x2a6e, B:863:0x2c09, B:865:0x2c14, B:871:0x2c61, B:872:0x2caf, B:874:0x2cd2, B:879:0x2d28, B:909:0x3102, B:913:0x311c, B:920:0x320f, B:922:0x3220, B:924:0x3227, B:925:0x3228, B:927:0x322a, B:929:0x3231, B:930:0x3232, B:938:0x3249, B:940:0x3256, B:933:0x3239, B:935:0x3240, B:936:0x3241, B:947:0x32de, B:949:0x32e4, B:950:0x32e5, B:952:0x32e7, B:954:0x32ee, B:955:0x32ef, B:957:0x32f1, B:959:0x32f8, B:960:0x32f9, B:962:0x32fb, B:964:0x3302, B:965:0x3303, B:967:0x3305, B:969:0x330c, B:970:0x330d, B:971:0x330e, B:972:0x3311, B:973:0x3312, B:873:0x2cb2, B:975:0x3338, B:977:0x333f, B:978:0x3340, B:979:0x3341, B:980:0x337b, B:982:0x3381, B:983:0x3396, B:985:0x33f3, B:987:0x33fa, B:988:0x33fb, B:990:0x33fd, B:992:0x3404, B:993:0x3405, B:994:0x3406, B:996:0x340c, B:997:0x340d, B:846:0x2ae1, B:848:0x2ae8, B:849:0x2ae9, B:788:0x2671, B:917:0x3120, B:867:0x2c17, B:900:0x2f5f, B:902:0x2f74, B:905:0x309a, B:907:0x30f6, B:906:0x30c9, B:901:0x2f6a, B:888:0x2eae, B:890:0x2ec4, B:894:0x2f2e, B:944:0x32db, B:821:0x27d0, B:823:0x27f6, B:825:0x2851, B:886:0x2e68, B:885:0x2ded, B:862:0x2baa, B:882:0x2d62, B:884:0x2d8f, B:860:0x2b61, B:880:0x2d2a, B:793:0x26bf, B:797:0x2727, B:799:0x275b, B:798:0x273a, B:854:0x2afa, B:855:0x2b12, B:859:0x2b38, B:858:0x2b19, B:919:0x317d), top: B:1151:0x2601, inners: #0, #7, #17, #18, #54, #56, #62, #70, #71, #75, #76, #80, #83, #88, #93 }] */
    /* JADX WARN: Code duplicated, block: B:837:0x29a1 A[Catch: all -> 0x340e, TryCatch #84 {all -> 0x340e, blocks: (B:783:0x2604, B:784:0x2666, B:786:0x266e, B:792:0x26bb, B:800:0x2766, B:802:0x276e, B:803:0x2780, B:810:0x2798, B:805:0x278b, B:807:0x2792, B:808:0x2793, B:812:0x27a1, B:814:0x27a8, B:815:0x27a9, B:819:0x27bd, B:827:0x28a7, B:829:0x2911, B:831:0x291a, B:833:0x2989, B:835:0x2997, B:837:0x29a1, B:839:0x2a04, B:841:0x2a0b, B:844:0x2a6e, B:863:0x2c09, B:865:0x2c14, B:871:0x2c61, B:872:0x2caf, B:874:0x2cd2, B:879:0x2d28, B:909:0x3102, B:913:0x311c, B:920:0x320f, B:922:0x3220, B:924:0x3227, B:925:0x3228, B:927:0x322a, B:929:0x3231, B:930:0x3232, B:938:0x3249, B:940:0x3256, B:933:0x3239, B:935:0x3240, B:936:0x3241, B:947:0x32de, B:949:0x32e4, B:950:0x32e5, B:952:0x32e7, B:954:0x32ee, B:955:0x32ef, B:957:0x32f1, B:959:0x32f8, B:960:0x32f9, B:962:0x32fb, B:964:0x3302, B:965:0x3303, B:967:0x3305, B:969:0x330c, B:970:0x330d, B:971:0x330e, B:972:0x3311, B:973:0x3312, B:873:0x2cb2, B:975:0x3338, B:977:0x333f, B:978:0x3340, B:979:0x3341, B:980:0x337b, B:982:0x3381, B:983:0x3396, B:985:0x33f3, B:987:0x33fa, B:988:0x33fb, B:990:0x33fd, B:992:0x3404, B:993:0x3405, B:994:0x3406, B:996:0x340c, B:997:0x340d, B:846:0x2ae1, B:848:0x2ae8, B:849:0x2ae9, B:788:0x2671, B:917:0x3120, B:867:0x2c17, B:900:0x2f5f, B:902:0x2f74, B:905:0x309a, B:907:0x30f6, B:906:0x30c9, B:901:0x2f6a, B:888:0x2eae, B:890:0x2ec4, B:894:0x2f2e, B:944:0x32db, B:821:0x27d0, B:823:0x27f6, B:825:0x2851, B:886:0x2e68, B:885:0x2ded, B:862:0x2baa, B:882:0x2d62, B:884:0x2d8f, B:860:0x2b61, B:880:0x2d2a, B:793:0x26bf, B:797:0x2727, B:799:0x275b, B:798:0x273a, B:854:0x2afa, B:855:0x2b12, B:859:0x2b38, B:858:0x2b19, B:919:0x317d), top: B:1151:0x2601, inners: #0, #7, #17, #18, #54, #56, #62, #70, #71, #75, #76, #80, #83, #88, #93 }] */
    /* JADX WARN: Code duplicated, block: B:839:0x2a04 A[Catch: all -> 0x340e, TryCatch #84 {all -> 0x340e, blocks: (B:783:0x2604, B:784:0x2666, B:786:0x266e, B:792:0x26bb, B:800:0x2766, B:802:0x276e, B:803:0x2780, B:810:0x2798, B:805:0x278b, B:807:0x2792, B:808:0x2793, B:812:0x27a1, B:814:0x27a8, B:815:0x27a9, B:819:0x27bd, B:827:0x28a7, B:829:0x2911, B:831:0x291a, B:833:0x2989, B:835:0x2997, B:837:0x29a1, B:839:0x2a04, B:841:0x2a0b, B:844:0x2a6e, B:863:0x2c09, B:865:0x2c14, B:871:0x2c61, B:872:0x2caf, B:874:0x2cd2, B:879:0x2d28, B:909:0x3102, B:913:0x311c, B:920:0x320f, B:922:0x3220, B:924:0x3227, B:925:0x3228, B:927:0x322a, B:929:0x3231, B:930:0x3232, B:938:0x3249, B:940:0x3256, B:933:0x3239, B:935:0x3240, B:936:0x3241, B:947:0x32de, B:949:0x32e4, B:950:0x32e5, B:952:0x32e7, B:954:0x32ee, B:955:0x32ef, B:957:0x32f1, B:959:0x32f8, B:960:0x32f9, B:962:0x32fb, B:964:0x3302, B:965:0x3303, B:967:0x3305, B:969:0x330c, B:970:0x330d, B:971:0x330e, B:972:0x3311, B:973:0x3312, B:873:0x2cb2, B:975:0x3338, B:977:0x333f, B:978:0x3340, B:979:0x3341, B:980:0x337b, B:982:0x3381, B:983:0x3396, B:985:0x33f3, B:987:0x33fa, B:988:0x33fb, B:990:0x33fd, B:992:0x3404, B:993:0x3405, B:994:0x3406, B:996:0x340c, B:997:0x340d, B:846:0x2ae1, B:848:0x2ae8, B:849:0x2ae9, B:788:0x2671, B:917:0x3120, B:867:0x2c17, B:900:0x2f5f, B:902:0x2f74, B:905:0x309a, B:907:0x30f6, B:906:0x30c9, B:901:0x2f6a, B:888:0x2eae, B:890:0x2ec4, B:894:0x2f2e, B:944:0x32db, B:821:0x27d0, B:823:0x27f6, B:825:0x2851, B:886:0x2e68, B:885:0x2ded, B:862:0x2baa, B:882:0x2d62, B:884:0x2d8f, B:860:0x2b61, B:880:0x2d2a, B:793:0x26bf, B:797:0x2727, B:799:0x275b, B:798:0x273a, B:854:0x2afa, B:855:0x2b12, B:859:0x2b38, B:858:0x2b19, B:919:0x317d), top: B:1151:0x2601, inners: #0, #7, #17, #18, #54, #56, #62, #70, #71, #75, #76, #80, #83, #88, #93 }] */
    /* JADX WARN: Code duplicated, block: B:841:0x2a0b A[Catch: all -> 0x340e, EDGE_INSN: B:841:0x2a0b->B:8:0x01a8 BREAK  A[LOOP:0: B:10:0x01cf->B:19:0x0326], TryCatch #84 {all -> 0x340e, blocks: (B:783:0x2604, B:784:0x2666, B:786:0x266e, B:792:0x26bb, B:800:0x2766, B:802:0x276e, B:803:0x2780, B:810:0x2798, B:805:0x278b, B:807:0x2792, B:808:0x2793, B:812:0x27a1, B:814:0x27a8, B:815:0x27a9, B:819:0x27bd, B:827:0x28a7, B:829:0x2911, B:831:0x291a, B:833:0x2989, B:835:0x2997, B:837:0x29a1, B:839:0x2a04, B:841:0x2a0b, B:844:0x2a6e, B:863:0x2c09, B:865:0x2c14, B:871:0x2c61, B:872:0x2caf, B:874:0x2cd2, B:879:0x2d28, B:909:0x3102, B:913:0x311c, B:920:0x320f, B:922:0x3220, B:924:0x3227, B:925:0x3228, B:927:0x322a, B:929:0x3231, B:930:0x3232, B:938:0x3249, B:940:0x3256, B:933:0x3239, B:935:0x3240, B:936:0x3241, B:947:0x32de, B:949:0x32e4, B:950:0x32e5, B:952:0x32e7, B:954:0x32ee, B:955:0x32ef, B:957:0x32f1, B:959:0x32f8, B:960:0x32f9, B:962:0x32fb, B:964:0x3302, B:965:0x3303, B:967:0x3305, B:969:0x330c, B:970:0x330d, B:971:0x330e, B:972:0x3311, B:973:0x3312, B:873:0x2cb2, B:975:0x3338, B:977:0x333f, B:978:0x3340, B:979:0x3341, B:980:0x337b, B:982:0x3381, B:983:0x3396, B:985:0x33f3, B:987:0x33fa, B:988:0x33fb, B:990:0x33fd, B:992:0x3404, B:993:0x3405, B:994:0x3406, B:996:0x340c, B:997:0x340d, B:846:0x2ae1, B:848:0x2ae8, B:849:0x2ae9, B:788:0x2671, B:917:0x3120, B:867:0x2c17, B:900:0x2f5f, B:902:0x2f74, B:905:0x309a, B:907:0x30f6, B:906:0x30c9, B:901:0x2f6a, B:888:0x2eae, B:890:0x2ec4, B:894:0x2f2e, B:944:0x32db, B:821:0x27d0, B:823:0x27f6, B:825:0x2851, B:886:0x2e68, B:885:0x2ded, B:862:0x2baa, B:882:0x2d62, B:884:0x2d8f, B:860:0x2b61, B:880:0x2d2a, B:793:0x26bf, B:797:0x2727, B:799:0x275b, B:798:0x273a, B:854:0x2afa, B:855:0x2b12, B:859:0x2b38, B:858:0x2b19, B:919:0x317d), top: B:1151:0x2601, inners: #0, #7, #17, #18, #54, #56, #62, #70, #71, #75, #76, #80, #83, #88, #93 }] */
    /* JADX WARN: Code duplicated, block: B:842:0x2a6a  */
    /* JADX WARN: Code duplicated, block: B:844:0x2a6e A[Catch: all -> 0x340e, TryCatch #84 {all -> 0x340e, blocks: (B:783:0x2604, B:784:0x2666, B:786:0x266e, B:792:0x26bb, B:800:0x2766, B:802:0x276e, B:803:0x2780, B:810:0x2798, B:805:0x278b, B:807:0x2792, B:808:0x2793, B:812:0x27a1, B:814:0x27a8, B:815:0x27a9, B:819:0x27bd, B:827:0x28a7, B:829:0x2911, B:831:0x291a, B:833:0x2989, B:835:0x2997, B:837:0x29a1, B:839:0x2a04, B:841:0x2a0b, B:844:0x2a6e, B:863:0x2c09, B:865:0x2c14, B:871:0x2c61, B:872:0x2caf, B:874:0x2cd2, B:879:0x2d28, B:909:0x3102, B:913:0x311c, B:920:0x320f, B:922:0x3220, B:924:0x3227, B:925:0x3228, B:927:0x322a, B:929:0x3231, B:930:0x3232, B:938:0x3249, B:940:0x3256, B:933:0x3239, B:935:0x3240, B:936:0x3241, B:947:0x32de, B:949:0x32e4, B:950:0x32e5, B:952:0x32e7, B:954:0x32ee, B:955:0x32ef, B:957:0x32f1, B:959:0x32f8, B:960:0x32f9, B:962:0x32fb, B:964:0x3302, B:965:0x3303, B:967:0x3305, B:969:0x330c, B:970:0x330d, B:971:0x330e, B:972:0x3311, B:973:0x3312, B:873:0x2cb2, B:975:0x3338, B:977:0x333f, B:978:0x3340, B:979:0x3341, B:980:0x337b, B:982:0x3381, B:983:0x3396, B:985:0x33f3, B:987:0x33fa, B:988:0x33fb, B:990:0x33fd, B:992:0x3404, B:993:0x3405, B:994:0x3406, B:996:0x340c, B:997:0x340d, B:846:0x2ae1, B:848:0x2ae8, B:849:0x2ae9, B:788:0x2671, B:917:0x3120, B:867:0x2c17, B:900:0x2f5f, B:902:0x2f74, B:905:0x309a, B:907:0x30f6, B:906:0x30c9, B:901:0x2f6a, B:888:0x2eae, B:890:0x2ec4, B:894:0x2f2e, B:944:0x32db, B:821:0x27d0, B:823:0x27f6, B:825:0x2851, B:886:0x2e68, B:885:0x2ded, B:862:0x2baa, B:882:0x2d62, B:884:0x2d8f, B:860:0x2b61, B:880:0x2d2a, B:793:0x26bf, B:797:0x2727, B:799:0x275b, B:798:0x273a, B:854:0x2afa, B:855:0x2b12, B:859:0x2b38, B:858:0x2b19, B:919:0x317d), top: B:1151:0x2601, inners: #0, #7, #17, #18, #54, #56, #62, #70, #71, #75, #76, #80, #83, #88, #93 }] */
    /* JADX WARN: Code duplicated, block: B:850:0x2aea  */
    /* JADX WARN: Code duplicated, block: B:853:0x2af8  */
    /* JADX WARN: Code duplicated, block: B:858:0x2b19 A[Catch: all -> 0x2b15, TryCatch #88 {all -> 0x2b15, blocks: (B:854:0x2afa, B:855:0x2b12, B:859:0x2b38, B:858:0x2b19), top: B:1158:0x2af6, outer: #84 }] */
    /* JADX WARN: Code duplicated, block: B:865:0x2c14 A[Catch: all -> 0x340e, TRY_LEAVE, TryCatch #84 {all -> 0x340e, blocks: (B:783:0x2604, B:784:0x2666, B:786:0x266e, B:792:0x26bb, B:800:0x2766, B:802:0x276e, B:803:0x2780, B:810:0x2798, B:805:0x278b, B:807:0x2792, B:808:0x2793, B:812:0x27a1, B:814:0x27a8, B:815:0x27a9, B:819:0x27bd, B:827:0x28a7, B:829:0x2911, B:831:0x291a, B:833:0x2989, B:835:0x2997, B:837:0x29a1, B:839:0x2a04, B:841:0x2a0b, B:844:0x2a6e, B:863:0x2c09, B:865:0x2c14, B:871:0x2c61, B:872:0x2caf, B:874:0x2cd2, B:879:0x2d28, B:909:0x3102, B:913:0x311c, B:920:0x320f, B:922:0x3220, B:924:0x3227, B:925:0x3228, B:927:0x322a, B:929:0x3231, B:930:0x3232, B:938:0x3249, B:940:0x3256, B:933:0x3239, B:935:0x3240, B:936:0x3241, B:947:0x32de, B:949:0x32e4, B:950:0x32e5, B:952:0x32e7, B:954:0x32ee, B:955:0x32ef, B:957:0x32f1, B:959:0x32f8, B:960:0x32f9, B:962:0x32fb, B:964:0x3302, B:965:0x3303, B:967:0x3305, B:969:0x330c, B:970:0x330d, B:971:0x330e, B:972:0x3311, B:973:0x3312, B:873:0x2cb2, B:975:0x3338, B:977:0x333f, B:978:0x3340, B:979:0x3341, B:980:0x337b, B:982:0x3381, B:983:0x3396, B:985:0x33f3, B:987:0x33fa, B:988:0x33fb, B:990:0x33fd, B:992:0x3404, B:993:0x3405, B:994:0x3406, B:996:0x340c, B:997:0x340d, B:846:0x2ae1, B:848:0x2ae8, B:849:0x2ae9, B:788:0x2671, B:917:0x3120, B:867:0x2c17, B:900:0x2f5f, B:902:0x2f74, B:905:0x309a, B:907:0x30f6, B:906:0x30c9, B:901:0x2f6a, B:888:0x2eae, B:890:0x2ec4, B:894:0x2f2e, B:944:0x32db, B:821:0x27d0, B:823:0x27f6, B:825:0x2851, B:886:0x2e68, B:885:0x2ded, B:862:0x2baa, B:882:0x2d62, B:884:0x2d8f, B:860:0x2b61, B:880:0x2d2a, B:793:0x26bf, B:797:0x2727, B:799:0x275b, B:798:0x273a, B:854:0x2afa, B:855:0x2b12, B:859:0x2b38, B:858:0x2b19, B:919:0x317d), top: B:1151:0x2601, inners: #0, #7, #17, #18, #54, #56, #62, #70, #71, #75, #76, #80, #83, #88, #93 }] */
    /* JADX WARN: Code duplicated, block: B:870:0x2c60  */
    /* JADX WARN: Code duplicated, block: B:873:0x2cb2 A[Catch: all -> 0x340e, TryCatch #84 {all -> 0x340e, blocks: (B:783:0x2604, B:784:0x2666, B:786:0x266e, B:792:0x26bb, B:800:0x2766, B:802:0x276e, B:803:0x2780, B:810:0x2798, B:805:0x278b, B:807:0x2792, B:808:0x2793, B:812:0x27a1, B:814:0x27a8, B:815:0x27a9, B:819:0x27bd, B:827:0x28a7, B:829:0x2911, B:831:0x291a, B:833:0x2989, B:835:0x2997, B:837:0x29a1, B:839:0x2a04, B:841:0x2a0b, B:844:0x2a6e, B:863:0x2c09, B:865:0x2c14, B:871:0x2c61, B:872:0x2caf, B:874:0x2cd2, B:879:0x2d28, B:909:0x3102, B:913:0x311c, B:920:0x320f, B:922:0x3220, B:924:0x3227, B:925:0x3228, B:927:0x322a, B:929:0x3231, B:930:0x3232, B:938:0x3249, B:940:0x3256, B:933:0x3239, B:935:0x3240, B:936:0x3241, B:947:0x32de, B:949:0x32e4, B:950:0x32e5, B:952:0x32e7, B:954:0x32ee, B:955:0x32ef, B:957:0x32f1, B:959:0x32f8, B:960:0x32f9, B:962:0x32fb, B:964:0x3302, B:965:0x3303, B:967:0x3305, B:969:0x330c, B:970:0x330d, B:971:0x330e, B:972:0x3311, B:973:0x3312, B:873:0x2cb2, B:975:0x3338, B:977:0x333f, B:978:0x3340, B:979:0x3341, B:980:0x337b, B:982:0x3381, B:983:0x3396, B:985:0x33f3, B:987:0x33fa, B:988:0x33fb, B:990:0x33fd, B:992:0x3404, B:993:0x3405, B:994:0x3406, B:996:0x340c, B:997:0x340d, B:846:0x2ae1, B:848:0x2ae8, B:849:0x2ae9, B:788:0x2671, B:917:0x3120, B:867:0x2c17, B:900:0x2f5f, B:902:0x2f74, B:905:0x309a, B:907:0x30f6, B:906:0x30c9, B:901:0x2f6a, B:888:0x2eae, B:890:0x2ec4, B:894:0x2f2e, B:944:0x32db, B:821:0x27d0, B:823:0x27f6, B:825:0x2851, B:886:0x2e68, B:885:0x2ded, B:862:0x2baa, B:882:0x2d62, B:884:0x2d8f, B:860:0x2b61, B:880:0x2d2a, B:793:0x26bf, B:797:0x2727, B:799:0x275b, B:798:0x273a, B:854:0x2afa, B:855:0x2b12, B:859:0x2b38, B:858:0x2b19, B:919:0x317d), top: B:1151:0x2601, inners: #0, #7, #17, #18, #54, #56, #62, #70, #71, #75, #76, #80, #83, #88, #93 }] */
    /* JADX WARN: Code duplicated, block: B:877:0x2d19  */
    /* JADX WARN: Code duplicated, block: B:879:0x2d28 A[Catch: all -> 0x340e, TRY_ENTER, TRY_LEAVE, TryCatch #84 {all -> 0x340e, blocks: (B:783:0x2604, B:784:0x2666, B:786:0x266e, B:792:0x26bb, B:800:0x2766, B:802:0x276e, B:803:0x2780, B:810:0x2798, B:805:0x278b, B:807:0x2792, B:808:0x2793, B:812:0x27a1, B:814:0x27a8, B:815:0x27a9, B:819:0x27bd, B:827:0x28a7, B:829:0x2911, B:831:0x291a, B:833:0x2989, B:835:0x2997, B:837:0x29a1, B:839:0x2a04, B:841:0x2a0b, B:844:0x2a6e, B:863:0x2c09, B:865:0x2c14, B:871:0x2c61, B:872:0x2caf, B:874:0x2cd2, B:879:0x2d28, B:909:0x3102, B:913:0x311c, B:920:0x320f, B:922:0x3220, B:924:0x3227, B:925:0x3228, B:927:0x322a, B:929:0x3231, B:930:0x3232, B:938:0x3249, B:940:0x3256, B:933:0x3239, B:935:0x3240, B:936:0x3241, B:947:0x32de, B:949:0x32e4, B:950:0x32e5, B:952:0x32e7, B:954:0x32ee, B:955:0x32ef, B:957:0x32f1, B:959:0x32f8, B:960:0x32f9, B:962:0x32fb, B:964:0x3302, B:965:0x3303, B:967:0x3305, B:969:0x330c, B:970:0x330d, B:971:0x330e, B:972:0x3311, B:973:0x3312, B:873:0x2cb2, B:975:0x3338, B:977:0x333f, B:978:0x3340, B:979:0x3341, B:980:0x337b, B:982:0x3381, B:983:0x3396, B:985:0x33f3, B:987:0x33fa, B:988:0x33fb, B:990:0x33fd, B:992:0x3404, B:993:0x3405, B:994:0x3406, B:996:0x340c, B:997:0x340d, B:846:0x2ae1, B:848:0x2ae8, B:849:0x2ae9, B:788:0x2671, B:917:0x3120, B:867:0x2c17, B:900:0x2f5f, B:902:0x2f74, B:905:0x309a, B:907:0x30f6, B:906:0x30c9, B:901:0x2f6a, B:888:0x2eae, B:890:0x2ec4, B:894:0x2f2e, B:944:0x32db, B:821:0x27d0, B:823:0x27f6, B:825:0x2851, B:886:0x2e68, B:885:0x2ded, B:862:0x2baa, B:882:0x2d62, B:884:0x2d8f, B:860:0x2b61, B:880:0x2d2a, B:793:0x26bf, B:797:0x2727, B:799:0x275b, B:798:0x273a, B:854:0x2afa, B:855:0x2b12, B:859:0x2b38, B:858:0x2b19, B:919:0x317d), top: B:1151:0x2601, inners: #0, #7, #17, #18, #54, #56, #62, #70, #71, #75, #76, #80, #83, #88, #93 }] */
    /* JADX WARN: Code duplicated, block: B:893:0x2f04  */
    /* JADX WARN: Code duplicated, block: B:896:0x2f48  */
    /* JADX WARN: Code duplicated, block: B:899:0x2f5c  */
    /* JADX WARN: Code duplicated, block: B:901:0x2f6a A[Catch: all -> 0x3238, TryCatch #18 {all -> 0x3238, blocks: (B:900:0x2f5f, B:902:0x2f74, B:905:0x309a, B:907:0x30f6, B:906:0x30c9, B:901:0x2f6a), top: B:1042:0x2f5f, outer: #84 }] */
    /* JADX WARN: Code duplicated, block: B:905:0x309a A[Catch: all -> 0x3238, TRY_ENTER, TryCatch #18 {all -> 0x3238, blocks: (B:900:0x2f5f, B:902:0x2f74, B:905:0x309a, B:907:0x30f6, B:906:0x30c9, B:901:0x2f6a), top: B:1042:0x2f5f, outer: #84 }] */
    /* JADX WARN: Code duplicated, block: B:906:0x30c9 A[Catch: all -> 0x3238, TryCatch #18 {all -> 0x3238, blocks: (B:900:0x2f5f, B:902:0x2f74, B:905:0x309a, B:907:0x30f6, B:906:0x30c9, B:901:0x2f6a), top: B:1042:0x2f5f, outer: #84 }] */
    /* JADX WARN: Code duplicated, block: B:909:0x3102 A[Catch: all -> 0x340e, TRY_ENTER, TRY_LEAVE, TryCatch #84 {all -> 0x340e, blocks: (B:783:0x2604, B:784:0x2666, B:786:0x266e, B:792:0x26bb, B:800:0x2766, B:802:0x276e, B:803:0x2780, B:810:0x2798, B:805:0x278b, B:807:0x2792, B:808:0x2793, B:812:0x27a1, B:814:0x27a8, B:815:0x27a9, B:819:0x27bd, B:827:0x28a7, B:829:0x2911, B:831:0x291a, B:833:0x2989, B:835:0x2997, B:837:0x29a1, B:839:0x2a04, B:841:0x2a0b, B:844:0x2a6e, B:863:0x2c09, B:865:0x2c14, B:871:0x2c61, B:872:0x2caf, B:874:0x2cd2, B:879:0x2d28, B:909:0x3102, B:913:0x311c, B:920:0x320f, B:922:0x3220, B:924:0x3227, B:925:0x3228, B:927:0x322a, B:929:0x3231, B:930:0x3232, B:938:0x3249, B:940:0x3256, B:933:0x3239, B:935:0x3240, B:936:0x3241, B:947:0x32de, B:949:0x32e4, B:950:0x32e5, B:952:0x32e7, B:954:0x32ee, B:955:0x32ef, B:957:0x32f1, B:959:0x32f8, B:960:0x32f9, B:962:0x32fb, B:964:0x3302, B:965:0x3303, B:967:0x3305, B:969:0x330c, B:970:0x330d, B:971:0x330e, B:972:0x3311, B:973:0x3312, B:873:0x2cb2, B:975:0x3338, B:977:0x333f, B:978:0x3340, B:979:0x3341, B:980:0x337b, B:982:0x3381, B:983:0x3396, B:985:0x33f3, B:987:0x33fa, B:988:0x33fb, B:990:0x33fd, B:992:0x3404, B:993:0x3405, B:994:0x3406, B:996:0x340c, B:997:0x340d, B:846:0x2ae1, B:848:0x2ae8, B:849:0x2ae9, B:788:0x2671, B:917:0x3120, B:867:0x2c17, B:900:0x2f5f, B:902:0x2f74, B:905:0x309a, B:907:0x30f6, B:906:0x30c9, B:901:0x2f6a, B:888:0x2eae, B:890:0x2ec4, B:894:0x2f2e, B:944:0x32db, B:821:0x27d0, B:823:0x27f6, B:825:0x2851, B:886:0x2e68, B:885:0x2ded, B:862:0x2baa, B:882:0x2d62, B:884:0x2d8f, B:860:0x2b61, B:880:0x2d2a, B:793:0x26bf, B:797:0x2727, B:799:0x275b, B:798:0x273a, B:854:0x2afa, B:855:0x2b12, B:859:0x2b38, B:858:0x2b19, B:919:0x317d), top: B:1151:0x2601, inners: #0, #7, #17, #18, #54, #56, #62, #70, #71, #75, #76, #80, #83, #88, #93 }] */
    /* JADX WARN: Code duplicated, block: B:912:0x3119  */
    /* JADX WARN: Code duplicated, block: B:915:0x311e  */
    /* JADX WARN: Code duplicated, block: B:937:0x3242  */
    /* JADX WARN: Code duplicated, block: B:942:0x32bb A[LOOP:10: B:876:0x2d17->B:942:0x32bb, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:982:0x3381 A[Catch: all -> 0x340e, LOOP:12: B:980:0x337b->B:982:0x3381, LOOP_END, TryCatch #84 {all -> 0x340e, blocks: (B:783:0x2604, B:784:0x2666, B:786:0x266e, B:792:0x26bb, B:800:0x2766, B:802:0x276e, B:803:0x2780, B:810:0x2798, B:805:0x278b, B:807:0x2792, B:808:0x2793, B:812:0x27a1, B:814:0x27a8, B:815:0x27a9, B:819:0x27bd, B:827:0x28a7, B:829:0x2911, B:831:0x291a, B:833:0x2989, B:835:0x2997, B:837:0x29a1, B:839:0x2a04, B:841:0x2a0b, B:844:0x2a6e, B:863:0x2c09, B:865:0x2c14, B:871:0x2c61, B:872:0x2caf, B:874:0x2cd2, B:879:0x2d28, B:909:0x3102, B:913:0x311c, B:920:0x320f, B:922:0x3220, B:924:0x3227, B:925:0x3228, B:927:0x322a, B:929:0x3231, B:930:0x3232, B:938:0x3249, B:940:0x3256, B:933:0x3239, B:935:0x3240, B:936:0x3241, B:947:0x32de, B:949:0x32e4, B:950:0x32e5, B:952:0x32e7, B:954:0x32ee, B:955:0x32ef, B:957:0x32f1, B:959:0x32f8, B:960:0x32f9, B:962:0x32fb, B:964:0x3302, B:965:0x3303, B:967:0x3305, B:969:0x330c, B:970:0x330d, B:971:0x330e, B:972:0x3311, B:973:0x3312, B:873:0x2cb2, B:975:0x3338, B:977:0x333f, B:978:0x3340, B:979:0x3341, B:980:0x337b, B:982:0x3381, B:983:0x3396, B:985:0x33f3, B:987:0x33fa, B:988:0x33fb, B:990:0x33fd, B:992:0x3404, B:993:0x3405, B:994:0x3406, B:996:0x340c, B:997:0x340d, B:846:0x2ae1, B:848:0x2ae8, B:849:0x2ae9, B:788:0x2671, B:917:0x3120, B:867:0x2c17, B:900:0x2f5f, B:902:0x2f74, B:905:0x309a, B:907:0x30f6, B:906:0x30c9, B:901:0x2f6a, B:888:0x2eae, B:890:0x2ec4, B:894:0x2f2e, B:944:0x32db, B:821:0x27d0, B:823:0x27f6, B:825:0x2851, B:886:0x2e68, B:885:0x2ded, B:862:0x2baa, B:882:0x2d62, B:884:0x2d8f, B:860:0x2b61, B:880:0x2d2a, B:793:0x26bf, B:797:0x2727, B:799:0x275b, B:798:0x273a, B:854:0x2afa, B:855:0x2b12, B:859:0x2b38, B:858:0x2b19, B:919:0x317d), top: B:1151:0x2601, inners: #0, #7, #17, #18, #54, #56, #62, #70, #71, #75, #76, #80, #83, #88, #93 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v90, types: [java.nio.LongBuffer] */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v17 */
    /* JADX WARN: Type inference failed for: r11v18 */
    /* JADX WARN: Type inference failed for: r11v25, types: [int[]] */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4, types: [int] */
    /* JADX WARN: Type inference failed for: r11v49, types: [int] */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v50 */
    /* JADX WARN: Type inference failed for: r11v51 */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r11v81 */
    /* JADX WARN: Type inference failed for: r11v82 */
    /* JADX WARN: Type inference failed for: r11v83 */
    /* JADX WARN: Type inference failed for: r11v84 */
    /* JADX WARN: Type inference failed for: r11v85 */
    /* JADX WARN: Type inference failed for: r11v86 */
    /* JADX WARN: Type inference failed for: r11v87 */
    /* JADX WARN: Type inference failed for: r11v88 */
    /* JADX WARN: Type inference failed for: r11v9, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r13v61 */
    /* JADX WARN: Type inference failed for: r13v64 */
    /* JADX WARN: Type inference failed for: r14v41 */
    /* JADX WARN: Type inference failed for: r15v23 */
    /* JADX WARN: Type inference failed for: r1v308, types: [java.lang.reflect.Method] */
    /* JADX WARN: Type inference failed for: r1v62 */
    /* JADX WARN: Type inference failed for: r23v15 */
    /* JADX WARN: Type inference failed for: r23v16 */
    /* JADX WARN: Type inference failed for: r23v17 */
    /* JADX WARN: Type inference failed for: r23v21 */
    /* JADX WARN: Type inference failed for: r23v26 */
    /* JADX WARN: Type inference failed for: r23v27 */
    /* JADX WARN: Type inference failed for: r23v29 */
    /* JADX WARN: Type inference failed for: r23v39 */
    /* JADX WARN: Type inference failed for: r23v40 */
    /* JADX WARN: Type inference failed for: r23v41 */
    /* JADX WARN: Type inference failed for: r23v44, types: [char] */
    /* JADX WARN: Type inference failed for: r23v45 */
    /* JADX WARN: Type inference failed for: r23v46 */
    /* JADX WARN: Type inference failed for: r23v47 */
    /* JADX WARN: Type inference failed for: r23v48 */
    /* JADX WARN: Type inference failed for: r23v49 */
    /* JADX WARN: Type inference failed for: r23v50 */
    /* JADX WARN: Type inference failed for: r25v0 */
    /* JADX WARN: Type inference failed for: r25v11 */
    /* JADX WARN: Type inference failed for: r25v12 */
    /* JADX WARN: Type inference failed for: r25v14 */
    /* JADX WARN: Type inference failed for: r28v15 */
    /* JADX WARN: Type inference failed for: r29v5 */
    /* JADX WARN: Type inference failed for: r2v104, types: [int[]] */
    /* JADX WARN: Type inference failed for: r2v150, types: [int[]] */
    /* JADX WARN: Type inference failed for: r2v179, types: [java.nio.LongBuffer[]] */
    /* JADX WARN: Type inference failed for: r2v180 */
    /* JADX WARN: Type inference failed for: r2v183 */
    /* JADX WARN: Type inference failed for: r2v184 */
    /* JADX WARN: Type inference failed for: r2v194, types: [java.lang.reflect.Method] */
    /* JADX WARN: Type inference failed for: r2v214 */
    /* JADX WARN: Type inference failed for: r2v471 */
    /* JADX WARN: Type inference failed for: r2v472 */
    /* JADX WARN: Type inference failed for: r2v96 */
    /* JADX WARN: Type inference failed for: r31v4 */
    /* JADX WARN: Type inference failed for: r31v6 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v104, types: [int[]] */
    /* JADX WARN: Type inference failed for: r3v136 */
    /* JADX WARN: Type inference failed for: r3v139 */
    /* JADX WARN: Type inference failed for: r3v26 */
    /* JADX WARN: Type inference failed for: r3v428 */
    /* JADX WARN: Type inference failed for: r3v488 */
    /* JADX WARN: Type inference failed for: r44v0, types: [int] */
    /* JADX WARN: Type inference failed for: r4v100 */
    /* JADX WARN: Type inference failed for: r4v122 */
    /* JADX WARN: Type inference failed for: r4v235 */
    /* JADX WARN: Type inference failed for: r4v269, types: [int[]] */
    /* JADX WARN: Type inference failed for: r4v81, types: [int[]] */
    /* JADX WARN: Type inference failed for: r5v104, types: [int[]] */
    /* JADX WARN: Type inference failed for: r5v152, types: [java.lang.Object, java.nio.LongBuffer] */
    /* JADX WARN: Type inference failed for: r5v155, types: [java.lang.Object, java.nio.LongBuffer] */
    /* JADX WARN: Type inference failed for: r5v184 */
    /* JADX WARN: Type inference failed for: r5v87, types: [java.lang.Object, java.nio.LongBuffer] */
    /* JADX WARN: Type inference failed for: r6v131 */
    /* JADX WARN: Type inference failed for: r6v132 */
    /* JADX WARN: Type inference failed for: r6v133, types: [java.security.KeyStore] */
    /* JADX WARN: Type inference failed for: r6v134, types: [java.security.KeyStore] */
    /* JADX WARN: Type inference failed for: r6v166, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v167 */
    /* JADX WARN: Type inference failed for: r6v171, types: [int] */
    /* JADX WARN: Type inference failed for: r6v221 */
    /* JADX WARN: Type inference failed for: r6v222 */
    /* JADX WARN: Type inference failed for: r6v249 */
    /* JADX WARN: Type inference failed for: r6v471 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v189, types: [int[]] */
    /* JADX WARN: Type inference failed for: r7v196, types: [java.lang.Object, java.nio.LongBuffer] */
    /* JADX WARN: Type inference failed for: r7v26, types: [int[]] */
    /* JADX WARN: Type inference failed for: r7v280 */
    /* JADX WARN: Type inference failed for: r7v41, types: [int[]] */
    /* JADX WARN: Type inference failed for: r7v49, types: [java.lang.reflect.Method] */
    /* JADX WARN: Type inference failed for: r7v525 */
    /* JADX WARN: Type inference failed for: r8v143, types: [int[]] */
    /* JADX WARN: Type inference failed for: r8v161, types: [java.lang.reflect.Method] */
    /* JADX WARN: Type inference failed for: r8v266, types: [int[]] */
    /* JADX WARN: Type inference failed for: r8v94 */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v112 */
    /* JADX WARN: Type inference failed for: r9v113 */
    /* JADX WARN: Type inference failed for: r9v114 */
    /* JADX WARN: Type inference failed for: r9v115 */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v153 */
    /* JADX WARN: Type inference failed for: r9v161 */
    /* JADX WARN: Type inference failed for: r9v387 */
    /* JADX WARN: Type inference failed for: r9v388 */
    /* JADX WARN: Type inference failed for: r9v389 */
    /* JADX WARN: Type inference failed for: r9v390 */
    /* JADX WARN: Type inference failed for: r9v391 */
    /* JADX WARN: Type inference failed for: r9v392 */
    /* JADX WARN: Type inference failed for: r9v393 */
    /* JADX WARN: Type inference failed for: r9v394 */
    /* JADX WARN: Type inference failed for: r9v395 */
    /* JADX WARN: Type inference failed for: r9v42 */
    /* JADX WARN: Type inference failed for: r9v69 */
    /* JADX WARN: Type inference failed for: r9v7, types: [java.nio.LongBuffer[]] */
    /* JADX WARN: Type inference failed for: r9v78 */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9 */
    /* JADX WARN: Type inference failed for: r9v95 */
    public static Object[] accessartificialFrame(Context context, String[] strArr, int i, int i2, int i3) throws Throwable {
        ?? r11;
        int i4;
        char c;
        int i5;
        Object objAccessartificialFrame;
        int i6;
        Object objAccessartificialFrame2;
        Object[] objArr;
        ?? r12;
        ?? r9;
        byte[][] bArr;
        int length;
        int i7;
        int i8;
        ?? r10;
        int i9;
        Object obj;
        Object objInvoke;
        LinkedHashSet linkedHashSet;
        int length2;
        int i10;
        ?? r13;
        ArrayList arrayList;
        String[] strArr2;
        int i11;
        Object[] objArr2;
        ?? r5;
        Class<?> cls;
        Object[] objArr3;
        Object obj2;
        String str;
        Object[] objArr4;
        int length3;
        int i12;
        ?? r14;
        int i13;
        Object obj3;
        int i14;
        String str2;
        String str3;
        int i15;
        Object objInvoke2;
        Class<?> cls2;
        int i16;
        int iIPostMessageService;
        int i17;
        int i18;
        ?? r31;
        int i19;
        int i20;
        Object objInvoke3;
        int i21;
        String str4;
        String string;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        int[] iArr;
        int i27;
        int i28;
        int i29;
        Object[] objArr5;
        Method method;
        int i30;
        int i31;
        String[][] strArr3;
        int i32;
        Object objAccessartificialFrame3;
        int i33;
        int i34;
        Object[] objArr6;
        ?? r7;
        Class<?> cls3;
        Object[] objArr7;
        int longPressTimeout;
        int i35;
        int i36;
        int i37;
        String str5;
        LongBuffer longBuffer;
        long[] jArrArray;
        int length4;
        int i38;
        ?? r15;
        ?? r23;
        List listEmptyList;
        ?? r24;
        ?? r16;
        ?? r17;
        ?? r18;
        String strSubstring;
        int i39;
        char c2;
        int i40;
        Object[] objArr8;
        Object objAccessartificialFrame4;
        ?? r19;
        ?? r2;
        int i41;
        ?? r25;
        String str6;
        String string2;
        int i42;
        Throwable th;
        ?? r6;
        int i43;
        ArrayList arrayList2;
        Object objAccessartificialFrame5;
        Object objNewInstance;
        int i44;
        Object objAccessartificialFrame6;
        List list;
        Object obj4;
        String[] strArr4 = strArr;
        ?? r3 = i;
        int i45 = 2;
        int i46 = 2 % 2;
        int i47 = 1;
        Object[] objArr9 = new Object[1];
        a(null, new int[]{34, 11, 125, 2}, true, objArr9);
        char c3 = 0;
        String str7 = (String) objArr9[0];
        Object[] objArr10 = new Object[1];
        a(new byte[]{0, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0}, new int[]{151, 19, 125, 2}, false, objArr10);
        String str8 = (String) objArr10[0];
        if (context == null) {
            Object[] objArr11 = {new int[]{r3 == true ? 1 : 0}, null, new int[1], new int[]{r3 == true ? 1 : 0}};
            int iMyTid = Process.myTid();
            int i48 = ~iMyTid;
            int i49 = 48190196 + ((1002071964 | i48) * (-757)) + ((~(1002172414 | iMyTid)) * 1514) + (((~(iMyTid | (-100451))) | (~(i48 | 841722238)) | 160450176) * 757);
            int i50 = ~i49;
            int i51 = ~(((-1) ^ i50) | i50);
            int i52 = ~(r3 == true ? 1 : 0);
            int i53 = ~((i50 & i52) | (i50 ^ i52));
            int i54 = (i49 * (-167)) + (((i53 & i51) | (i51 ^ i53)) * 168);
            int i55 = ~i49;
            int i56 = (~(((i55 & (r3 == true ? 1 : 0)) == true ? 1 : 0) | ((i55 ^ (r3 == true ? 1 : 0)) == true ? 1 : 0))) * 168;
            int i57 = (i54 & i56) + (i54 | i56);
            int i58 = i57 * (-391);
            int i59 = -(-(i3 * (-195)));
            int i60 = ((i58 | i59) << 1) - (i58 ^ i59);
            int i61 = ~i3;
            int i62 = ~((i61 ^ i57) | (i61 & i57));
            int i63 = ~(((r3 == true ? 1 : 0) & i3) | ((i3 ^ (r3 == true ? 1 : 0)) == true ? 1 : 0));
            int i64 = (i62 | i63) * (-196);
            int i65 = (((i60 | i64) << 1) - (i64 ^ i60)) + (((i3 & i57) | (i57 ^ i3)) * 392);
            int i66 = ~i57;
            int i67 = ~((i61 & i66) | (i66 ^ i61));
            int i68 = -(-(((i67 & i63) | (i67 ^ i63)) * 196));
            int i69 = ((i65 | i68) << 1) - (i68 ^ i65);
            int i70 = i69 << 13;
            int i71 = (i70 & (~i69)) | ((~i70) & i69);
            int i72 = i71 >>> 17;
            int i73 = ((~i71) & i72) | ((~i72) & i71);
            int i74 = i73 << 5;
            ((int[]) objArr11[2])[0] = ((~i73) & i74) | ((~i74) & i73);
            return objArr11;
        }
        if (strArr4.length == 0) {
            objArr = new Object[]{new int[]{(~((r3 == true ? 1 : 0) & 4)) & ((r3 == true ? 1 : 0) | 4)}, null, new int[1], new int[]{r3 == true ? 1 : 0}};
            int iNextInt = new Random().nextInt();
            int i75 = ~iNextInt;
            int i76 = ((((~((-2625549) | i75)) | (~(92142365 | iNextInt))) * 988) - 260742251) + (((~(iNextInt | (-70832909))) | 68207360 | (~(i75 | 92142365))) * 988) + 16;
            int iIPostMessageService2 = Lists.TransformingRandomAccessList.AnonymousClass1.IPostMessageService();
            int i77 = i76 * (-575);
            int i78 = i3 * (-575);
            int i79 = (i77 ^ i78) + ((i77 & i78) << 1);
            int i80 = ~i76;
            int i81 = ~((~i3) | i80);
            int i82 = ~i3;
            int i83 = ~((i82 ^ iIPostMessageService2) | (i82 & iIPostMessageService2));
            int i84 = (i79 - (~(((i81 & i83) | (i81 ^ i83)) * 576))) - 1;
            int i85 = ~i76;
            int i86 = ~((i3 & i85) | (i85 ^ i3));
            int i87 = ~iIPostMessageService2;
            int i88 = (i87 & i82) | (i82 ^ i87);
            int i89 = ~((i88 & i76) | (i88 ^ i76));
            int i90 = -(-(((i89 & i86) | (i86 ^ i89)) * 576));
            int i91 = (i84 ^ i90) + ((i90 & i84) << 1) + ((~((i80 ^ i82) | (i80 & i82))) * 576);
            int i92 = i91 << 13;
            int i93 = (i92 | i91) & (~(i91 & i92));
            int i94 = i93 >>> 17;
            int i95 = (i93 | i94) & (~(i93 & i94));
            int i96 = i95 << 5;
            ((int[]) objArr[2])[0] = (i95 | i96) & (~(i95 & i96));
        } else {
            int length5 = strArr4.length;
            Object[] objArr12 = new Object[1];
            a(new byte[]{0, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1}, new int[]{0, 19, 0, 17}, false, objArr12);
            ?? r20 = (LongBuffer[]) Array.newInstance(Class.forName((String) objArr12[0]), length5);
            int i97 = 0;
            ?? r4 = r3;
            while (true) {
                String str9 = "";
                if (i97 < strArr4.length) {
                    String lowerCase = strArr4[i97].toLowerCase();
                    byte[] bArr2 = new byte[i47];
                    bArr2[c3] = i47;
                    int i98 = artificialFrame + 97;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i98 % 128;
                    int i99 = i98 % i45;
                    Object[] objArr13 = new Object[i47];
                    a(bArr2, new int[]{19, i47, 123, i47}, i47, objArr13);
                    String strReplaceAll = lowerCase.replaceAll((String) objArr13[0], "");
                    long jLongValue = new BigInteger(strReplaceAll.substring(16, 32), 16).longValue();
                    long jLongValue2 = new BigInteger(strReplaceAll.substring(0, 16), 16).longValue();
                    int length6 = strReplaceAll.length();
                    if (length6 == 32) {
                        r20[i97] = LongBuffer.allocate(2).put(jLongValue2).put(jLongValue);
                    } else {
                        if (length6 != 64) {
                            objArr = new Object[]{new int[]{(~(r4 & 3)) & (r4 | 3)}, null, new int[1], new int[]{r4}};
                            int i100 = ~(((int) Process.getElapsedCpuTime()) | (-518725831));
                            int i101 = ((1546183331 + (((-679075557) | i100) * (-220))) + ((i100 | 377626626) * 220)) - 1932079866;
                            int iIPostMessageService3 = Lists.TransformingRandomAccessList.AnonymousClass1.IPostMessageService();
                            int i102 = i101 * (-958);
                            int i103 = i3 * (-958);
                            int i104 = (i102 & i103) + (i102 | i103);
                            int i105 = ~i3;
                            int i106 = ~iIPostMessageService3;
                            int i107 = ~((i105 ^ i106) | (i105 & i106));
                            int i108 = ~i101;
                            int i109 = i107 | (~((i108 & iIPostMessageService3) | (i108 ^ iIPostMessageService3)));
                            int i110 = ~(i106 | i101);
                            int i111 = i104 + (((i109 & i110) | (i109 ^ i110)) * 959);
                            int i112 = (~((i3 & i101) | (i101 ^ i3))) * (-959);
                            int i113 = ((i111 | i112) << 1) - (i112 ^ i111);
                            int i114 = ~i101;
                            int i115 = ~((i114 & i106) | (i114 ^ i106));
                            int i116 = ~((i105 & iIPostMessageService3) | (i105 ^ iIPostMessageService3));
                            int i117 = (i113 - (~(((~((iIPostMessageService3 & i101) | (i101 ^ iIPostMessageService3))) | ((i116 & i115) | (i115 ^ i116))) * 959))) - 1;
                            int i118 = i117 << 13;
                            int i119 = (i118 | i117) & (~(i117 & i118));
                            int i120 = i119 >>> 17;
                            int i121 = (i119 | i120) & (~(i119 & i120));
                            int i122 = i121 << 5;
                            ((int[]) objArr[2])[0] = ((~i121) & i122) | ((~i122) & i121);
                            break;
                        }
                        r20[i97] = LongBuffer.allocate(4).put(jLongValue2).put(jLongValue).put(new BigInteger(strReplaceAll.substring(32, 48), 16).longValue()).put(new BigInteger(strReplaceAll.substring(48), 16).longValue());
                    }
                    int i123 = (i97 & 10) + (i97 | 10);
                    i97 = ((i123 | (-9)) << 1) - (i123 ^ (-9));
                    strArr4 = strArr;
                    r4 = i;
                    str8 = str8;
                    i45 = 2;
                    c3 = 0;
                    i47 = 1;
                } else {
                    String str10 = str8;
                    boolean z = (i2 & 2) != 0;
                    if (z) {
                        Object objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(682069389);
                        if (objAccessartificialFrame7 == null) {
                            int touchSlop = 21 - (ViewConfiguration.getTouchSlop() >> 8);
                            char c4 = (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                            int iIndexOf = TextUtils.indexOf((CharSequence) "", '0') + 466;
                            byte[] bArr3 = $$a;
                            byte b = (byte) (bArr3[13] - 1);
                            Object[] objArr14 = new Object[1];
                            b(b, b, bArr3[11], objArr14);
                            r23 = c4;
                            objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(touchSlop, r23, iIndexOf, -1211970683, false, (String) objArr14[0], null);
                        }
                        if (((Field) objAccessartificialFrame7).get(null) == null) {
                            try {
                                Object[] objArr15 = new Object[1];
                                a(null, new int[]{20, 14, 55, 6}, true, objArr15);
                                try {
                                    String string3 = Class.forName((String) objArr15[0]).getDeclaredConstructor(null).newInstance(null).toString();
                                    int defaultSize = View.getDefaultSize(0, 0);
                                    r15 = new Object[1];
                                    c(((defaultSize | 5) << 1) - (defaultSize ^ 5), new int[]{1059136902, -533363734, -2144114931, 92026022}, r15);
                                    byte[] bytes = string3.getBytes((String) r15[0]);
                                    try {
                                        if (Build.VERSION.SDK_INT < 24) {
                                            try {
                                                Object[] objArr16 = {0, null, null};
                                                Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(1655552463);
                                                if (objAccessartificialFrame8 == null) {
                                                    objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 41, (char) (19410 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))), 3808 - (ViewConfiguration.getTouchSlop() >> 8), -37158969, false, null, new Class[]{Integer.TYPE, Exception.class, List.class});
                                                }
                                                objNewInstance = ((Constructor) objAccessartificialFrame8).newInstance(objArr16);
                                                r15 = i;
                                                r23 = r20;
                                            } catch (Throwable th2) {
                                                Throwable cause = th2.getCause();
                                                if (cause != null) {
                                                    throw cause;
                                                }
                                                throw th2;
                                            }
                                        } else {
                                            try {
                                                Object[] objArr17 = new Object[1];
                                                r15 = 0;
                                                a(null, new int[]{20, 14, 55, 6}, true, objArr17);
                                                Date date = (Date) Class.forName((String) objArr17[0]).getDeclaredConstructor(null).newInstance(null);
                                                String string4 = UUID.randomUUID().toString();
                                                try {
                                                    try {
                                                        int i124 = -TextUtils.lastIndexOf("", '0', 0);
                                                        int iIPostMessageService4 = Lists.TransformingRandomAccessList.AnonymousClass1.IPostMessageService();
                                                        int i125 = i124 * 1773;
                                                        int i126 = (i125 & (-12390)) + (i125 | (-12390));
                                                        int i127 = ~i124;
                                                        int i128 = ~((i127 & (-15)) | (i127 ^ (-15)));
                                                        int i129 = ~(((-15) ^ iIPostMessageService4) | ((-15) & iIPostMessageService4));
                                                        int i130 = (i128 ^ i129) | (i128 & i129);
                                                        int i131 = ~iIPostMessageService4;
                                                        int i132 = (i131 ^ i124) | (i131 & i124);
                                                        r20 = i132 ^ 14;
                                                        int i133 = ~(r20 | (i132 & 14));
                                                        int i134 = (i126 - (~(((i130 ^ i133) | (i133 & i130)) * 886))) - 1;
                                                        int i135 = ~iIPostMessageService4;
                                                        int i136 = ~((i135 & 14) | (i135 ^ 14));
                                                        int i137 = -(-(((i136 & i124) | (i124 ^ i136)) * (-1772)));
                                                        int i138 = (i134 ^ i137) + ((i137 & i134) << 1);
                                                        int i139 = (~((i131 ^ i124) | (i124 & i131))) * 886;
                                                        int i140 = (i138 ^ i139) + ((i139 & i138) << 1);
                                                        try {
                                                            i = new int[]{1145635377, -808725589, -1606366413, 308943438, -192467301, 1232438083, -2091094806, 384219765};
                                                            Object[] objArr18 = new Object[1];
                                                            c(i140, i, objArr18);
                                                            ?? r8 = (String) objArr18[0];
                                                            try {
                                                                try {
                                                                    try {
                                                                        Object[] objArr19 = new Object[1];
                                                                        c(21 - (~(-(-View.resolveSizeAndState(0, 0, 0)))), new int[]{-1126508594, -1707955208, -1142011696, -607183002, -2037064201, -1876888749, 1775727618, 1483920346, 909707011, 1952648836, -1403841975, -280441118}, objArr19);
                                                                        KeyStore keyStore = (KeyStore) Class.forName((String) objArr19[0]).getMethod(str7, String.class).invoke(null, r8);
                                                                        try {
                                                                            Object[] objArr20 = {null};
                                                                            int i141 = -(ViewConfiguration.getTouchSlop() >> 8);
                                                                            Object[] objArr21 = new Object[1];
                                                                            c((i141 ^ 22) + ((i141 & 22) << 1), new int[]{-1126508594, -1707955208, -1142011696, -607183002, -2037064201, -1876888749, 1775727618, 1483920346, 909707011, 1952648836, -1403841975, -280441118}, objArr21);
                                                                            Class<?> cls4 = Class.forName((String) objArr21[0]);
                                                                            int i142 = artificialFrame + AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
                                                                            getARTIFICIAL_FRAME_PACKAGE_NAME = i142 % 128;
                                                                            int i143 = i142 % 2;
                                                                            Object[] objArr22 = new Object[1];
                                                                            a(new byte[]{1, 1, 0, 1}, new int[]{45, 4, 0, 2}, true, objArr22);
                                                                            cls4.getMethod((String) objArr22[0], KeyStore.LoadStoreParameter.class).invoke(keyStore, objArr20);
                                                                            try {
                                                                                Object[] objArr23 = new Object[1];
                                                                                c(17 - (~(-(ViewConfiguration.getMinimumFlingVelocity() >> 16))), new int[]{-1126508594, -1707955208, 50347826, 1705035752, 1104700023, -1597776050, 280531594, -1959324976, 816123948, -2099430836}, objArr23);
                                                                                Object objInvoke4 = Class.forName((String) objArr23[0]).getMethod(str7, null).invoke(null, null);
                                                                                int i144 = artificialFrame;
                                                                                int i145 = (i144 & 45) + (i144 | 45);
                                                                                getARTIFICIAL_FRAME_PACKAGE_NAME = i145 % 128;
                                                                                int i146 = i145 % 2;
                                                                                try {
                                                                                    Object[] objArr24 = {date};
                                                                                    int i147 = -TextUtils.lastIndexOf("", '0');
                                                                                    int i148 = i147 * 465;
                                                                                    int i149 = (i148 & (-7871)) + (i148 | (-7871));
                                                                                    i = i;
                                                                                    int i150 = ~i;
                                                                                    int i151 = ~(((-18) ^ i150) | ((-18) & i150));
                                                                                    int i152 = ~(((-18) ^ i147) | ((-18) & i147));
                                                                                    int i153 = (i151 ^ i152) | (i152 & i151);
                                                                                    int iIPostMessageService5 = Lists.TransformingRandomAccessList.AnonymousClass1.IPostMessageService();
                                                                                    r20 = r20;
                                                                                    int i154 = ~iIPostMessageService5;
                                                                                    int i155 = (-1005244829) - (~(-(-((((-339760389) ^ i154) | ((-339760389) & i154)) * SyslogConstants.LOG_LOCAL7))));
                                                                                    int i156 = ~((~iIPostMessageService5) | 1266787048);
                                                                                    int i157 = (151003176 ^ i156) | (i156 & 151003176);
                                                                                    int i158 = -(-(((i157 ^ (-1606547437)) | (i157 & (-1606547437))) * SyslogConstants.LOG_LOCAL7));
                                                                                    int i159 = (i155 ^ i158) + ((i155 & i158) << 1);
                                                                                    int i160 = -(-(((-460443665) | i) * 140));
                                                                                    int i161 = ((1686750768 | i160) << 1) - (1686750768 ^ i160);
                                                                                    int i162 = ~i;
                                                                                    int i163 = ~((i162 ^ (-460443665)) | ((-460443665) & i162));
                                                                                    int i164 = ((324009984 ^ i163) | (324009984 & i163)) * (-280);
                                                                                    int i165 = (i161 & i164) + (i161 | i164);
                                                                                    int i166 = ~((i162 ^ 928517773) | (i162 & 928517773));
                                                                                    int i167 = ((-1064951454) ^ i166) | (i166 & (-1064951454));
                                                                                    int i168 = ~(((-324009985) ^ i) | ((-324009985) & i));
                                                                                    int i169 = ((i167 ^ i168) | (i167 & i168)) * 140;
                                                                                    if (i159 <= (i165 & i169) + (i165 | i169)) {
                                                                                        int i170 = ~((i150 ^ i147) | (i150 & i147));
                                                                                        i44 = i149 * (464 >> ((i153 & i170) | (i153 ^ i170)));
                                                                                    } else {
                                                                                        i44 = (i149 - (~((i153 | (~(i150 | i147))) * 464))) - 1;
                                                                                    }
                                                                                    int i171 = ~i147;
                                                                                    try {
                                                                                        Object[] objArr25 = new Object[1];
                                                                                        c((((i44 - (~(-(-((-464) * (((i171 & i) | (i ^ i171)) | (-18))))))) - 1) - (~(((~((-18) | i147)) | (~((i147 ^ i) | ((i147 & i) == true ? 1 : 0)))) * 464))) - 1, new int[]{-1126508594, -1707955208, 50347826, 1705035752, 1104700023, -1597776050, 280531594, -1959324976, 816123948, -2099430836}, objArr25);
                                                                                        Class<?> cls5 = Class.forName((String) objArr25[0]);
                                                                                        Object[] objArr26 = new Object[1];
                                                                                        c(7 - (~(-(-MotionEvent.axisFromString("")))), new int[]{611128946, 1003606089, 1629164623, -136393194}, objArr26);
                                                                                        String str11 = (String) objArr26[0];
                                                                                        Class<?>[] clsArr = new Class[1];
                                                                                        try {
                                                                                            Object[] objArr27 = new Object[1];
                                                                                            a(null, new int[]{20, 14, 55, 6}, true, objArr27);
                                                                                            clsArr[0] = Class.forName((String) objArr27[0]);
                                                                                            cls5.getMethod(str11, clsArr).invoke(objInvoke4, objArr24);
                                                                                            try {
                                                                                                int i172 = -TextUtils.getOffsetAfter("", 0);
                                                                                                Object[] objArr28 = new Object[1];
                                                                                                c((i172 & 18) + (i172 | 18), new int[]{-1126508594, -1707955208, 50347826, 1705035752, 1104700023, -1597776050, 280531594, -1959324976, 816123948, -2099430836}, objArr28);
                                                                                                Class<?> cls6 = Class.forName((String) objArr28[0]);
                                                                                                int offsetAfter = TextUtils.getOffsetAfter("", 0);
                                                                                                Object[] objArr29 = new Object[1];
                                                                                                c((offsetAfter ^ 3) + ((offsetAfter & 3) << 1), new int[]{1624777045, -628715224}, objArr29);
                                                                                                cls6.getMethod((String) objArr29[0], Integer.TYPE, Integer.TYPE).invoke(objInvoke4, 11, 1);
                                                                                                try {
                                                                                                    Object[] objArr30 = new Object[1];
                                                                                                    c(17 - (~(-View.MeasureSpec.getMode(0))), new int[]{-1126508594, -1707955208, 50347826, 1705035752, 1104700023, -1597776050, 280531594, -1959324976, 816123948, -2099430836}, objArr30);
                                                                                                    Class<?> cls7 = Class.forName((String) objArr30[0]);
                                                                                                    Object[] objArr31 = new Object[1];
                                                                                                    a(new byte[]{0, 1, 0, 1, 0, 0, 0}, new int[]{49, 7, 121, 5}, true, objArr31);
                                                                                                    Date date2 = (Date) cls7.getMethod((String) objArr31[0], null).invoke(objInvoke4, null);
                                                                                                    try {
                                                                                                        try {
                                                                                                            KeyGenParameterSpec.Builder builder = new KeyGenParameterSpec.Builder(string4, 12);
                                                                                                            int i173 = -(-Color.argb(0, 0, 0, 0));
                                                                                                            Object[] objArr32 = new Object[1];
                                                                                                            c((i173 ^ 9) + ((i173 & 9) << 1), new int[]{-512310252, -840551880, -1107339716, 1839689377, 302056341, -1241658436}, objArr32);
                                                                                                            try {
                                                                                                                Object[] objArr33 = {(String) objArr32[0]};
                                                                                                                Object[] objArr34 = new Object[1];
                                                                                                                c(36 - (~(-(-(PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1))))), new int[]{-1126508594, -1707955208, -1142011696, -607183002, -2037064201, -1876888749, -123664275, 578299359, 1269237282, -364441640, -1679962856, -824868551, 163826526, -1439452745, 1066062127, 642817478, -297811883, -12986294, 754659449, -1042258750}, objArr34);
                                                                                                                KeyGenParameterSpec.Builder algorithmParameterSpec = builder.setAlgorithmParameterSpec((AlgorithmParameterSpec) Class.forName((String) objArr34[0]).getDeclaredConstructor(String.class).newInstance(objArr33));
                                                                                                                Object[] objArr35 = new Object[1];
                                                                                                                c(7 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), new int[]{1927792283, -663241186, -520769080, -90225899}, objArr35);
                                                                                                                KeyGenParameterSpec.Builder attestationChallenge = algorithmParameterSpec.setDigests((String) objArr35[0]).setKeyValidityStart(date).setKeyValidityEnd(date2).setAttestationChallenge(bytes);
                                                                                                                try {
                                                                                                                    Object[] objArr36 = new Object[1];
                                                                                                                    a(new byte[]{1, 0}, new int[]{56, 2, 0, 0}, false, objArr36);
                                                                                                                    String str12 = (String) objArr36[0];
                                                                                                                    int i174 = -(ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1));
                                                                                                                    Object[] objArr37 = new Object[1];
                                                                                                                    c((i174 & 16) + (i174 | 16), new int[]{1145635377, -808725589, -1606366413, 308943438, -192467301, 1232438083, -2091094806, 384219765}, objArr37);
                                                                                                                    try {
                                                                                                                        Object[] objArr38 = {str12, (String) objArr37[0]};
                                                                                                                        int capsMode = TextUtils.getCapsMode("", 0, 0);
                                                                                                                        int i175 = ~capsMode;
                                                                                                                        int i176 = ((capsMode * 592) - 17700) + ((~((i175 & 30) | (i175 ^ 30))) * (-1182));
                                                                                                                        int i177 = ~capsMode;
                                                                                                                        int i178 = (i177 ^ (-31)) | (i177 & (-31));
                                                                                                                        int i179 = ~((i178 & i150) | (i178 ^ i150));
                                                                                                                        int i180 = ~((capsMode & 30) | (capsMode ^ 30));
                                                                                                                        int i181 = i176 + (((i180 & i179) | (i179 ^ i180)) * (-591));
                                                                                                                        int i182 = ((i ^ i177) | ((i177 & i) == true ? 1 : 0) | (-31)) * 591;
                                                                                                                        Object[] objArr39 = new Object[1];
                                                                                                                        c(((i181 | i182) << 1) - (i181 ^ i182), new int[]{-1126508594, -1707955208, -1142011696, -607183002, -2037064201, -1876888749, 1775727618, 1483920346, 1814579689, 1752949020, -1064295495, 286535240, -1347111285, -1355860539, 605206057, 1357371447}, objArr39);
                                                                                                                        str7 = str7;
                                                                                                                        try {
                                                                                                                            KeyPairGenerator keyPairGenerator = (KeyPairGenerator) Class.forName((String) objArr39[0]).getMethod(str7, String.class, String.class).invoke(null, objArr38);
                                                                                                                            try {
                                                                                                                                keyPairGenerator.initialize(attestationChallenge.build());
                                                                                                                                keyPairGenerator.generateKeyPair();
                                                                                                                                try {
                                                                                                                                    Object[] objArr40 = {string4};
                                                                                                                                    int i183 = -(ViewConfiguration.getJumpTapTimeout() >> 16);
                                                                                                                                    int iIPostMessageService6 = Lists.TransformingRandomAccessList.AnonymousClass1.IPostMessageService();
                                                                                                                                    int i184 = (i183 * (-183)) + 4070 + (((~i183) | 22) * (-368)) + ((i183 | (-23) | (~iIPostMessageService6)) * SyslogConstants.LOG_LOCAL7);
                                                                                                                                    int i185 = ~((~i183) | (-23));
                                                                                                                                    int i186 = ~iIPostMessageService6;
                                                                                                                                    int i187 = ~((i186 & i183) | (i186 ^ i183));
                                                                                                                                    int i188 = (i187 & i185) | (i185 ^ i187);
                                                                                                                                    int i189 = ~((i183 & 22) | (i183 ^ 22));
                                                                                                                                    Object[] objArr41 = new Object[1];
                                                                                                                                    c(i184 + (((i189 & i188) | (i188 ^ i189)) * SyslogConstants.LOG_LOCAL7), new int[]{-1126508594, -1707955208, -1142011696, -607183002, -2037064201, -1876888749, 1775727618, 1483920346, 909707011, 1952648836, -1403841975, -280441118}, objArr41);
                                                                                                                                    Class<?> cls8 = Class.forName((String) objArr41[0]);
                                                                                                                                    int i190 = -(Process.myTid() >> 22);
                                                                                                                                    Object[] objArr42 = new Object[1];
                                                                                                                                    c((i190 & 19) + (i190 | 19), new int[]{-427566903, -232673148, -63970423, -654366693, 990914655, -8104596, 981015315, 535089295, 402486287, -1745968999}, objArr42);
                                                                                                                                    try {
                                                                                                                                        Object[] objArr43 = (Object[]) cls8.getMethod((String) objArr42[0], String.class).invoke(keyStore, objArr40);
                                                                                                                                        arrayList2 = new ArrayList();
                                                                                                                                        Object[] objArr44 = new Object[1];
                                                                                                                                        a(new byte[]{1, 0, 1, 1, 1}, new int[]{58, 5, 87, 2}, true, objArr44);
                                                                                                                                        try {
                                                                                                                                            Object[] objArr45 = {(String) objArr44[0]};
                                                                                                                                            Object[] objArr46 = new Object[1];
                                                                                                                                            c((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 37, new int[]{-1126508594, -1707955208, -1142011696, -607183002, -2037064201, -1876888749, 906221362, 613251054, 1353238393, 2056488286, -63970423, -654366693, 990914655, -8104596, 32100658, 946209195, 1659086212, 1726409843, -1550403436, 572408540}, objArr46);
                                                                                                                                            Object objInvoke5 = Class.forName((String) objArr46[0]).getMethod(str7, String.class).invoke(null, objArr45);
                                                                                                                                            int length7 = objArr43.length;
                                                                                                                                            int i191 = 0;
                                                                                                                                            while (i191 < length7) {
                                                                                                                                                Object obj5 = objArr43[i191];
                                                                                                                                                try {
                                                                                                                                                    Object[] objArr47 = objArr43;
                                                                                                                                                    int i192 = length7;
                                                                                                                                                    Object[] objArr48 = new Object[1];
                                                                                                                                                    a(new byte[]{0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1}, new int[]{63, 30, 0, 1}, true, objArr48);
                                                                                                                                                    Class<?> cls9 = Class.forName((String) objArr48[0]);
                                                                                                                                                    Object[] objArr49 = new Object[1];
                                                                                                                                                    c(Drawable.resolveOpacity(0, 0) + 10, new int[]{1094919268, -466142805, -1802382669, -1101235642, -805922100, -901533879}, objArr49);
                                                                                                                                                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream((byte[]) cls9.getMethod((String) objArr49[0], null).invoke(obj5, null));
                                                                                                                                                    try {
                                                                                                                                                        int maximumFlingVelocity = ViewConfiguration.getMaximumFlingVelocity() >> 16;
                                                                                                                                                        Object[] objArr50 = new Object[1];
                                                                                                                                                        c((maximumFlingVelocity & 37) + (maximumFlingVelocity | 37), new int[]{-1126508594, -1707955208, -1142011696, -607183002, -2037064201, -1876888749, 906221362, 613251054, 1353238393, 2056488286, -63970423, -654366693, 990914655, -8104596, 32100658, 946209195, 1659086212, 1726409843, -1550403436, 572408540}, objArr50);
                                                                                                                                                        Class<?> cls10 = Class.forName((String) objArr50[0]);
                                                                                                                                                        Object[] objArr51 = new Object[1];
                                                                                                                                                        c(View.MeasureSpec.makeMeasureSpec(0, 0) + 19, new int[]{-399321834, 683488651, 1367502043, -1764377967, 851535138, 1896834345, -591822884, 2019010931, 1987289039, -175973819}, objArr51);
                                                                                                                                                        arrayList2.add(cls10.getMethod((String) objArr51[0], InputStream.class).invoke(objInvoke5, byteArrayInputStream));
                                                                                                                                                        byteArrayInputStream.close();
                                                                                                                                                        i191 = (i191 ^ 1) + ((i191 & 1) << 1);
                                                                                                                                                        objArr43 = objArr47;
                                                                                                                                                        length7 = i192;
                                                                                                                                                    } catch (Throwable th3) {
                                                                                                                                                        Throwable cause2 = th3.getCause();
                                                                                                                                                        if (cause2 != null) {
                                                                                                                                                            throw cause2;
                                                                                                                                                        }
                                                                                                                                                        throw th3;
                                                                                                                                                    }
                                                                                                                                                } catch (Throwable th4) {
                                                                                                                                                    Throwable cause3 = th4.getCause();
                                                                                                                                                    if (cause3 != null) {
                                                                                                                                                        throw cause3;
                                                                                                                                                    }
                                                                                                                                                    throw th4;
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                            if (keyStore != null) {
                                                                                                                                                try {
                                                                                                                                                    keyStore.deleteEntry(string4);
                                                                                                                                                } catch (KeyStoreException unused) {
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                            i43 = 3;
                                                                                                                                            r15 = i;
                                                                                                                                            r23 = r20;
                                                                                                                                            try {
                                                                                                                                                Object[] objArr52 = new Object[i43];
                                                                                                                                                objArr52[2] = arrayList2;
                                                                                                                                                objArr52[1] = null;
                                                                                                                                                objArr52[0] = 0;
                                                                                                                                                objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(1655552463);
                                                                                                                                                if (objAccessartificialFrame5 == null) {
                                                                                                                                                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(43 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), (char) (View.resolveSizeAndState(0, 0, 0) + 19409), 3807 - TextUtils.lastIndexOf("", '0'), -37158969, false, null, new Class[]{Integer.TYPE, Exception.class, List.class});
                                                                                                                                                }
                                                                                                                                                objNewInstance = ((Constructor) objAccessartificialFrame5).newInstance(objArr52);
                                                                                                                                                r15 = r15;
                                                                                                                                                r23 = r23;
                                                                                                                                            } catch (Throwable th5) {
                                                                                                                                                Throwable cause4 = th5.getCause();
                                                                                                                                                if (cause4 != null) {
                                                                                                                                                    throw cause4;
                                                                                                                                                }
                                                                                                                                                throw th5;
                                                                                                                                            }
                                                                                                                                        } catch (Throwable th6) {
                                                                                                                                            Throwable cause5 = th6.getCause();
                                                                                                                                            if (cause5 != null) {
                                                                                                                                                throw cause5;
                                                                                                                                            }
                                                                                                                                            throw th6;
                                                                                                                                        }
                                                                                                                                    } catch (Throwable th7) {
                                                                                                                                        th = th7;
                                                                                                                                        Throwable th8 = th;
                                                                                                                                        Throwable cause6 = th8.getCause();
                                                                                                                                        if (cause6 != null) {
                                                                                                                                            throw cause6;
                                                                                                                                        }
                                                                                                                                        throw th8;
                                                                                                                                    }
                                                                                                                                } catch (Throwable th9) {
                                                                                                                                    th = th9;
                                                                                                                                }
                                                                                                                            } catch (Exception e) {
                                                                                                                                e = e;
                                                                                                                                throw e;
                                                                                                                            } catch (Throwable th10) {
                                                                                                                                th = th10;
                                                                                                                                r8 = keyStore;
                                                                                                                                th = th;
                                                                                                                                r6 = r8;
                                                                                                                                if (r6 != 0) {
                                                                                                                                    throw th;
                                                                                                                                }
                                                                                                                                try {
                                                                                                                                    r6.deleteEntry(string4);
                                                                                                                                    throw th;
                                                                                                                                } catch (KeyStoreException unused2) {
                                                                                                                                    throw th;
                                                                                                                                }
                                                                                                                            }
                                                                                                                        } catch (Throwable th11) {
                                                                                                                            th = th11;
                                                                                                                            Throwable th12 = th;
                                                                                                                            try {
                                                                                                                                Throwable cause7 = th12.getCause();
                                                                                                                                if (cause7 != null) {
                                                                                                                                    throw cause7;
                                                                                                                                }
                                                                                                                                throw th12;
                                                                                                                            } catch (Exception e2) {
                                                                                                                                e = e2;
                                                                                                                                throw e;
                                                                                                                            }
                                                                                                                        }
                                                                                                                    } catch (Throwable th13) {
                                                                                                                        th = th13;
                                                                                                                    }
                                                                                                                } catch (Exception e3) {
                                                                                                                    e = e3;
                                                                                                                }
                                                                                                            } catch (Throwable th14) {
                                                                                                                Throwable cause8 = th14.getCause();
                                                                                                                if (cause8 != null) {
                                                                                                                    throw cause8;
                                                                                                                }
                                                                                                                throw th14;
                                                                                                            }
                                                                                                        } catch (Throwable th15) {
                                                                                                            th = th15;
                                                                                                            r8 = keyStore;
                                                                                                        }
                                                                                                    } catch (Exception unused3) {
                                                                                                        r8 = keyStore;
                                                                                                        str7 = str7;
                                                                                                        if (r8 != 0) {
                                                                                                            try {
                                                                                                                r8.deleteEntry(string4);
                                                                                                            } catch (KeyStoreException unused4) {
                                                                                                            }
                                                                                                        }
                                                                                                        i43 = 3;
                                                                                                        arrayList2 = null;
                                                                                                        r15 = i;
                                                                                                        r23 = r20;
                                                                                                    }
                                                                                                } catch (Throwable th16) {
                                                                                                    Throwable cause9 = th16.getCause();
                                                                                                    if (cause9 != null) {
                                                                                                        throw cause9;
                                                                                                    }
                                                                                                    throw th16;
                                                                                                }
                                                                                            } catch (Throwable th17) {
                                                                                                Throwable cause10 = th17.getCause();
                                                                                                if (cause10 != null) {
                                                                                                    throw cause10;
                                                                                                }
                                                                                                throw th17;
                                                                                            }
                                                                                        } catch (Throwable th18) {
                                                                                            th = th18;
                                                                                            Throwable th19 = th;
                                                                                            Throwable cause11 = th19.getCause();
                                                                                            if (cause11 != null) {
                                                                                                throw cause11;
                                                                                            }
                                                                                            throw th19;
                                                                                        }
                                                                                    } catch (Throwable th20) {
                                                                                        th = th20;
                                                                                    }
                                                                                } catch (Throwable th21) {
                                                                                    th = th21;
                                                                                }
                                                                            } catch (Throwable th22) {
                                                                                Throwable cause12 = th22.getCause();
                                                                                if (cause12 != null) {
                                                                                    throw cause12;
                                                                                }
                                                                                throw th22;
                                                                            }
                                                                        } catch (Throwable th23) {
                                                                            Throwable cause13 = th23.getCause();
                                                                            if (cause13 != null) {
                                                                                throw cause13;
                                                                            }
                                                                            throw th23;
                                                                        }
                                                                    } catch (Throwable th24) {
                                                                        try {
                                                                            Throwable cause14 = th24.getCause();
                                                                            if (cause14 != null) {
                                                                                throw cause14;
                                                                            }
                                                                            throw th24;
                                                                        } catch (Exception unused5) {
                                                                            r8 = 0;
                                                                            if (r8 != 0) {
                                                                                r8.deleteEntry(string4);
                                                                            }
                                                                            i43 = 3;
                                                                            arrayList2 = null;
                                                                            r15 = i;
                                                                            r23 = r20;
                                                                            Object[] objArr53 = new Object[i43];
                                                                            objArr53[2] = arrayList2;
                                                                            objArr53[1] = null;
                                                                            objArr53[0] = 0;
                                                                            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(1655552463);
                                                                            if (objAccessartificialFrame5 == null) {
                                                                                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(43 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), (char) (View.resolveSizeAndState(0, 0, 0) + 19409), 3807 - TextUtils.lastIndexOf("", '0'), -37158969, false, null, new Class[]{Integer.TYPE, Exception.class, List.class});
                                                                            }
                                                                            objNewInstance = ((Constructor) objAccessartificialFrame5).newInstance(objArr53);
                                                                            r15 = r15;
                                                                            r23 = r23;
                                                                            objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(1379818893);
                                                                            if (objAccessartificialFrame6 == null) {
                                                                                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(TextUtils.indexOf("", "", 0) + 42, (char) (KeyEvent.normalizeMetaState(0) + 19409), 3808 - Color.red(0), -849667195, false, "onResult", new Class[0]);
                                                                            }
                                                                            list = (List) ((Method) objAccessartificialFrame6).invoke(objNewInstance, null);
                                                                            if (list == null) {
                                                                                listEmptyList = null;
                                                                                r16 = r15;
                                                                                r24 = r23;
                                                                                break;
                                                                            }
                                                                            listEmptyList = null;
                                                                            r16 = r15;
                                                                            r24 = r23;
                                                                            break;
                                                                            if (listEmptyList != null) {
                                                                                r16 = r15;
                                                                                r24 = r23;
                                                                                r16 = r15;
                                                                                r24 = r23;
                                                                                r17 = r24;
                                                                                strSubstring = null;
                                                                                r18 = r17;
                                                                            } else {
                                                                                r16 = r15;
                                                                                r24 = r23;
                                                                                r16 = r15;
                                                                                r24 = r23;
                                                                                r17 = r24;
                                                                                strSubstring = null;
                                                                                r18 = r17;
                                                                            }
                                                                            if (strSubstring == null) {
                                                                                r18 = r19;
                                                                                r18 = r19;
                                                                                i39 = r16 == true ? 1 : 0;
                                                                            } else {
                                                                                r18 = r19;
                                                                                r18 = r19;
                                                                                i39 = ((r16 == true ? 1 : 0) & (-6)) | ((~(r16 == true ? 1 : 0)) & 5);
                                                                            }
                                                                            if (strSubstring == null) {
                                                                                int i193 = artificialFrame + 3;
                                                                                getARTIFICIAL_FRAME_PACKAGE_NAME = i193 % 128;
                                                                                c2 = 2;
                                                                                int i194 = i193 % 2;
                                                                                i40 = 0;
                                                                            } else {
                                                                                c2 = 2;
                                                                                i40 = 16;
                                                                            }
                                                                            objArr8 = new Object[4];
                                                                            objArr8[0] = new int[]{i39};
                                                                            objArr8[c2] = new int[1];
                                                                            objArr8[3] = new int[]{r16 == true ? 1 : 0};
                                                                            int i195 = (-1277967071) + ((1071251135 | (r16 == true ? 1 : 0)) * (-676));
                                                                            int i196 = ~(r16 == true ? 1 : 0);
                                                                            int i197 = i195 + (((~(1054373563 | i196)) | (-1071251136)) * 676) + (((~(i196 | 894023837)) | 177227298 | (~((-16877573) | (r16 == true ? 1 : 0)))) * 676);
                                                                            int iIPostMessageService7 = Lists.TransformingRandomAccessList.AnonymousClass1.IPostMessageService();
                                                                            int i198 = ((i40 * 673) - (~(-(-(i197 * (-1343)))))) - 1;
                                                                            int i199 = ~((i40 ^ iIPostMessageService7) | (i40 & iIPostMessageService7));
                                                                            int i200 = -(-(((i199 & i197) | (i197 ^ i199)) * 672));
                                                                            int i201 = (i198 & i200) + (i198 | i200);
                                                                            int i202 = ~i40;
                                                                            int i203 = ~iIPostMessageService7;
                                                                            int i204 = ~((i202 & i203) | (i202 ^ i203));
                                                                            int i205 = ~(iIPostMessageService7 | i197);
                                                                            int i206 = -(-(((i205 & i204) | (i204 ^ i205)) * (-672)));
                                                                            int i207 = (i201 ^ i206) + ((i206 & i201) << 1);
                                                                            int i208 = ~i197;
                                                                            int i209 = ~((i208 & i203) | (i208 ^ i203));
                                                                            int i210 = ~i197;
                                                                            int i211 = ((~((i40 & i210) | (i210 ^ i40))) | i209) * 672;
                                                                            int i212 = ((i207 | i211) << 1) - (i211 ^ i207);
                                                                            i4 = i3;
                                                                            int i213 = i212 + i4;
                                                                            int i214 = i213 << 13;
                                                                            int i215 = (i213 | i214) & (~(i213 & i214));
                                                                            int i216 = i215 >>> 17;
                                                                            int i217 = ((~i215) & i216) | ((~i216) & i215);
                                                                            int i218 = i217 << 5;
                                                                            int i219 = ((~i217) & i218) | ((~i218) & i217);
                                                                            int[] iArr2 = (int[]) objArr8[2];
                                                                            int i220 = artificialFrame;
                                                                            int i221 = ((i220 | 3) << 1) - (i220 ^ 3);
                                                                            getARTIFICIAL_FRAME_PACKAGE_NAME = i221 % 128;
                                                                            int i222 = i221 % 2;
                                                                            iArr2[0] = i219;
                                                                            objArr8[1] = new String[]{strSubstring};
                                                                            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(682069389);
                                                                            if (objAccessartificialFrame4 == null) {
                                                                                int scrollBarSize = (ViewConfiguration.getScrollBarSize() >> 8) + 21;
                                                                                char keyRepeatDelay = (char) (ViewConfiguration.getKeyRepeatDelay() >> 16);
                                                                                int iIndexOf2 = 465 - TextUtils.indexOf("", "", 0);
                                                                                byte[] bArr4 = $$a;
                                                                                byte b2 = (byte) (bArr4[13] - 1);
                                                                                Object[] objArr54 = new Object[1];
                                                                                b(b2, b2, bArr4[11], objArr54);
                                                                                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(scrollBarSize, keyRepeatDelay, iIndexOf2, -1211970683, false, (String) objArr54[0], null);
                                                                            }
                                                                            ((Field) objAccessartificialFrame4).set(null, objArr8);
                                                                            if (r16 != i39) {
                                                                                return objArr8;
                                                                            }
                                                                            c = 0;
                                                                            i5 = 1;
                                                                            r9 = r18;
                                                                            r12 = r16;
                                                                            if (context == null) {
                                                                                Object[] objArr55 = new Object[4];
                                                                                int[] iArr3 = new int[i5];
                                                                                objArr55[c] = iArr3;
                                                                                objArr55[2] = new int[i5];
                                                                                int[] iArr4 = new int[i5];
                                                                                objArr55[3] = iArr4;
                                                                                iArr4[0] = r12;
                                                                                iArr3[0] = r12;
                                                                                int iMyTid2 = Process.myTid();
                                                                                int i223 = 414996829 + (((~(iMyTid2 | 906581299)) | 746231573) * (-668)) + ((906581299 | (~(746231573 | iMyTid2))) * 1336) + ((iMyTid2 | 1048303415) * 668);
                                                                                int i224 = ((i223 << 1) - i223) + i4;
                                                                                int i225 = i224 << 13;
                                                                                int i226 = (i224 | i225) & (~(i224 & i225));
                                                                                int i227 = i226 >>> 17;
                                                                                int i228 = (i226 | i227) & (~(i226 & i227));
                                                                                int i229 = i228 << 5;
                                                                                ((int[]) objArr55[2])[0] = ((~i228) & i229) | ((~i229) & i228);
                                                                                objArr55[1] = null;
                                                                                return objArr55;
                                                                            }
                                                                            bArr = new byte[r9.length][];
                                                                            length = r9.length;
                                                                            i7 = 0;
                                                                            i8 = 0;
                                                                            while (i7 < length) {
                                                                                r10 = r9;
                                                                                r7 = r10[i7];
                                                                                Object[] objArr56 = new Object[1];
                                                                                c(14 - (~(-View.getDefaultSize(0, 0))), new int[]{-1126508594, -1707955208, -1985443438, 137225525, 1597574327, 2041802794, -1595502793, 1282537579}, objArr56);
                                                                                cls3 = Class.forName((String) objArr56[0]);
                                                                                objArr7 = new Object[1];
                                                                                a(new byte[]{1, 1, 1, 0, 0, 1, 1, 0}, new int[]{186, 8, 0, 0}, true, objArr7);
                                                                                if (((Integer) cls3.getMethod((String) objArr7[0], null).invoke(r7, null)).intValue() == 4) {
                                                                                    ByteBuffer byteBufferAllocate = ByteBuffer.allocate(32);
                                                                                    Class<?> cls11 = Class.forName(str10);
                                                                                    longPressTimeout = ViewConfiguration.getLongPressTimeout() >> 16;
                                                                                    int iIPostMessageService8 = Lists.TransformingRandomAccessList.AnonymousClass1.IPostMessageService();
                                                                                    int i230 = longPressTimeout * (-109);
                                                                                    int i231 = ((i230 | 1332) << 1) - (i230 ^ 1332);
                                                                                    int i232 = ~longPressTimeout;
                                                                                    int i233 = ~((iIPostMessageService8 ^ 12) | (iIPostMessageService8 & 12));
                                                                                    int i234 = -(-(((i232 ^ i233) | (i232 & i233)) * (-220)));
                                                                                    int i235 = ((i231 | i234) << 1) - (i231 ^ i234);
                                                                                    int i236 = ((~((longPressTimeout ^ 12) | (longPressTimeout & 12))) | i233) * 220;
                                                                                    i35 = ((i235 | i236) << 1) - (i235 ^ i236);
                                                                                    i36 = ~((~longPressTimeout) | 12);
                                                                                    i37 = getARTIFICIAL_FRAME_PACKAGE_NAME + 83;
                                                                                    artificialFrame = i37 % 128;
                                                                                    if (i37 % 2 == 0) {
                                                                                        int i237 = ~(((-13) ^ longPressTimeout) | (longPressTimeout & (-13)));
                                                                                        int i238 = i36 ^ i237;
                                                                                        Object[] objArr57 = new Object[1];
                                                                                        c(i35 / (b.f39n << ((i36 & i237) | i238)), new int[]{2143351903, -982766959, -1780750661, -446571346, -967477501, 352953536}, objArr57);
                                                                                        str5 = (String) objArr57[0];
                                                                                    } else {
                                                                                        int i239 = (i36 | (~(((-13) ^ longPressTimeout) | (longPressTimeout & (-13))))) * b.f39n;
                                                                                        Object[] objArr58 = new Object[1];
                                                                                        c(((i35 | i239) << 1) - (i239 ^ i35), new int[]{2143351903, -982766959, -1780750661, -446571346, -967477501, 352953536}, objArr58);
                                                                                        str5 = (String) objArr58[0];
                                                                                    }
                                                                                    longBuffer = (LongBuffer) cls11.getMethod(str5, null).invoke(byteBufferAllocate, null);
                                                                                    jArrArray = r7.array();
                                                                                    length4 = jArrArray.length;
                                                                                    i38 = 0;
                                                                                    while (i38 < length4) {
                                                                                        longBuffer.put(jArrArray[i38]);
                                                                                        int i240 = (i38 ^ (-104)) + ((i38 & (-104)) << 1);
                                                                                        i38 = (i240 & 105) + (i240 | 105);
                                                                                    }
                                                                                    bArr[i8] = byteBufferAllocate.array();
                                                                                    i8++;
                                                                                }
                                                                                i7++;
                                                                                length = length;
                                                                                r10 = r10;
                                                                            }
                                                                            r10 = r9;
                                                                            ?? r26 = r10;
                                                                            if (i8 > 0) {
                                                                                int i241 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                                                                int i242 = ((i241 | 25) << 1) - (i241 ^ 25);
                                                                                artificialFrame = i242 % 128;
                                                                                int i243 = i242 % 2;
                                                                                strArr3 = new String[1][];
                                                                                int iCurrentTimeMillis = ((int) System.currentTimeMillis()) ^ 343337308;
                                                                                int i244 = ~iCurrentTimeMillis;
                                                                                i32 = ~r12;
                                                                                Object[] objArr59 = {Integer.valueOf((r12 & i244) | (iCurrentTimeMillis & i32)), bArr, Integer.valueOf(i8), Integer.valueOf(i2), strArr3};
                                                                                objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1514071993);
                                                                                if (objAccessartificialFrame3 == null) {
                                                                                    int iAxisFromString = MotionEvent.axisFromString("") + 22;
                                                                                    char capsMode2 = (char) TextUtils.getCapsMode("", 0, 0);
                                                                                    int fadingEdgeLength = (ViewConfiguration.getFadingEdgeLength() >> 16) + 465;
                                                                                    byte b3 = $$a[11];
                                                                                    byte b4 = b3;
                                                                                    Object[] objArr60 = new Object[1];
                                                                                    b(b3, b4, (byte) (b4 + 1), objArr60);
                                                                                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(iAxisFromString, capsMode2, fadingEdgeLength, 983850575, false, (String) objArr60[0], new Class[]{Integer.TYPE, byte[][].class, Integer.TYPE, Integer.TYPE, String[][].class});
                                                                                }
                                                                                long jLongValue3 = ((Long) ((Method) objAccessartificialFrame3).invoke(null, objArr59)).longValue();
                                                                                long j = -614106746;
                                                                                long j2 = 371;
                                                                                long j3 = (j2 * j) + (j2 * jLongValue3);
                                                                                long j4 = -370;
                                                                                long j5 = -1;
                                                                                long j6 = jLongValue3 ^ j5;
                                                                                long j7 = (long) r12;
                                                                                long j8 = j7 ^ j5;
                                                                                long j9 = j ^ j5;
                                                                                long j10 = j3 + ((((j6 | j8) ^ j5) | ((j9 | j7) ^ j5)) * j4);
                                                                                long j11 = ((j9 | j8) ^ j5) | ((j6 | j7) ^ j5);
                                                                                long j12 = j5 ^ (jLongValue3 | j);
                                                                                long j13 = j10 + (j4 * (j11 | j12)) + (((long) 370) * j12) + ((long) (-1348107944));
                                                                                int i245 = (int) (j13 >> 32);
                                                                                int iNextInt2 = new Random().nextInt(426611332);
                                                                                int i246 = ~iNextInt2;
                                                                                int i247 = i245 & (1612427114 + (((~(i246 | 1695351675)) | (~(258125264 | i246)) | (-1869590524)) * 464) + (((-1611465260) | iNextInt2) * (-464)) + (((~(iNextInt2 | 1695351675)) | (-1869590524)) * 464));
                                                                                int iElapsedRealtime = (int) SystemClock.elapsedRealtime();
                                                                                int i248 = ((int) j13) & (2088992125 + ((1993845722 | iElapsedRealtime) * 376) + (((~((~iElapsedRealtime) | 415170360)) | 1715536066) * (-376)) + (((~(iElapsedRealtime | (-415170361))) | (-1852396771)) * 376));
                                                                                int i249 = (i248 & i247) | (i247 ^ i248);
                                                                                i33 = ((~i249) & iCurrentTimeMillis) | (i249 & i244);
                                                                                if ((i2 & 1) == 1) {
                                                                                }
                                                                                if (((~((i33 & r12) == true ? 1 : 0)) & ((i33 | r12) == true ? 1 : 0)) != 17) {
                                                                                    i34 = (i33 & i32) | (((~i33) & r12) == true ? 1 : 0);
                                                                                    if (i34 == 0) {
                                                                                        objArr = new Object[]{new int[]{i33}, null, new int[]{(i | i) & (~(i & i))}, new int[]{r12}};
                                                                                        int i250 = (~(215522247 | i32)) | 304562208;
                                                                                        int i251 = ~((-144212483) | r12);
                                                                                        int i252 = -(-((((i250 | i251) * (-252)) - 399385187) + ((i251 | (~(520084455 | i32))) * 252)));
                                                                                        int i253 = ((i3 | i252) << 1) - (i3 ^ i252);
                                                                                        int i254 = i253 << 13;
                                                                                        int i255 = (i254 & (~i253)) | ((~i254) & i253);
                                                                                        int i256 = i255 ^ (i255 >>> 17);
                                                                                        int i257 = i256 << 5;
                                                                                        break;
                                                                                    }
                                                                                    if (i34 == 11) {
                                                                                        objArr6 = new Object[]{new int[]{i33}, strArr3[0], new int[1], new int[]{r12}};
                                                                                        int startElapsedRealtime = (int) Process.getStartElapsedRealtime();
                                                                                        int i258 = 915255893 + ((~(startElapsedRealtime | 280763409)) * JfifUtil.MARKER_SOI);
                                                                                        int i259 = ~startElapsedRealtime;
                                                                                        int i260 = i258 + ((398286323 | i259) * (-216)) + (((~(i259 | 280763409)) | (-120413684)) * JfifUtil.MARKER_SOI);
                                                                                        int i261 = -(-(((i260 | 16) << 1) - (i260 ^ 16)));
                                                                                        int i262 = ((i3 | i261) << 1) - (i3 ^ i261);
                                                                                        int i263 = i262 << 13;
                                                                                        int i264 = (i263 & (~i262)) | ((~i263) & i262);
                                                                                        int i265 = i264 >>> 17;
                                                                                        int i266 = (i264 | i265) & (~(i264 & i265));
                                                                                        int i267 = i266 << 5;
                                                                                        ((int[]) objArr6[2])[0] = (i266 | i267) & (~(i266 & i267));
                                                                                    }
                                                                                    return objArr;
                                                                                }
                                                                                objArr6 = new Object[]{new int[]{i33}, strArr3[0], new int[]{(i | i) & (~(i & i))}, new int[]{r12}};
                                                                                int i268 = (-461147299) + (((~(i32 | 300314338)) | 135368708) * (-160)) + ((300314338 | (~(139964612 | i32))) * SyslogConstants.LOG_LOCAL4);
                                                                                int i269 = (i268 & 16) + (i268 | 16);
                                                                                int i270 = (i3 & i269) + (i3 | i269);
                                                                                int i271 = i270 << 13;
                                                                                int i272 = (i271 | i270) & (~(i270 & i271));
                                                                                int i273 = i272 >>> 17;
                                                                                int i274 = (i272 | i273) & (~(i272 & i273));
                                                                                int i275 = i274 << 5;
                                                                                return objArr6;
                                                                            }
                                                                            str9 = "";
                                                                            i9 = artificialFrame + 75;
                                                                            getARTIFICIAL_FRAME_PACKAGE_NAME = i9 % 128;
                                                                            if (i9 % 2 != 0) {
                                                                                Object[] objArr61 = new Object[1];
                                                                                c(10 >>> ExpandableListView.getPackedPositionGroup(1L), new int[]{-553959009, 1566372400, 2145491739, -1796016629, 1015558550, -1808814313, 600618822, -1854666632, -1584713131, -61496597, 1209812182, 1465344295}, objArr61);
                                                                                obj = objArr61[0];
                                                                            } else {
                                                                                int i276 = -(-ExpandableListView.getPackedPositionGroup(0L));
                                                                                Object[] objArr62 = new Object[1];
                                                                                c((i276 ^ 23) + ((i276 & 23) << 1), new int[]{-553959009, 1566372400, 2145491739, -1796016629, 1015558550, -1808814313, 600618822, -1854666632, -1584713131, -61496597, 1209812182, 1465344295}, objArr62);
                                                                                obj = objArr62[0];
                                                                            }
                                                                            Class<?> cls12 = Class.forName((String) obj);
                                                                            Object[] objArr63 = new Object[1];
                                                                            a(new byte[]{1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1}, new int[]{194, 17, 38, 0}, false, objArr63);
                                                                            Object objInvoke6 = cls12.getMethod((String) objArr63[0], null).invoke(context, null);
                                                                            int i277 = -KeyEvent.keyCodeFromString(str9);
                                                                            Object[] objArr64 = new Object[1];
                                                                            c((i277 ^ 23) + ((i277 & 23) << 1), new int[]{-553959009, 1566372400, 2145491739, -1796016629, 1015558550, -1808814313, 600618822, -1854666632, -1584713131, -61496597, 1209812182, 1465344295}, objArr64);
                                                                            Class<?> cls13 = Class.forName((String) objArr64[0]);
                                                                            int i278 = -(-KeyEvent.getDeadChar(0, 0));
                                                                            Object[] objArr65 = new Object[1];
                                                                            c(((i278 | 14) << 1) - (i278 ^ 14), new int[]{2095174662, 1254976582, 1888163075, 733288094, -1891425884, 636340184, 1854975689, 1879805549}, objArr65);
                                                                            Object[] objArr66 = {cls13.getMethod((String) objArr65[0], null).invoke(context, null), 64};
                                                                            int i279 = -(-(ViewConfiguration.getMaximumDrawingCacheSize() >> 24));
                                                                            Object[] objArr67 = new Object[1];
                                                                            c((i279 ^ 33) + ((i279 & 33) << 1), new int[]{-553959009, 1566372400, 2145491739, -1796016629, 1015558550, -1808814313, 600618822, -1854666632, 1964086842, 560341688, 1888163075, 733288094, -1442994014, 479450140, -1807369700, 802064978, 1132699382, -1559291025}, objArr67);
                                                                            Class<?> cls14 = Class.forName((String) objArr67[0]);
                                                                            Object[] objArr68 = new Object[1];
                                                                            c(Process.getGidForName(str9) + 15, new int[]{2095174662, 1254976582, 1888163075, 733288094, -1833489099, 842928759, -2083258904, -518269280}, objArr68);
                                                                            objInvoke = cls14.getMethod((String) objArr68[0], String.class, Integer.TYPE).invoke(objInvoke6, objArr66);
                                                                            linkedHashSet = new LinkedHashSet();
                                                                            ?? r21 = r26;
                                                                            length2 = r21.length;
                                                                            i10 = 0;
                                                                            r13 = r21;
                                                                            while (i10 < length2) {
                                                                                r5 = r13[i10];
                                                                                Object[] objArr69 = new Object[1];
                                                                                c(((Process.getThreadPriority(0) + 20) >> 6) + 15, new int[]{-1126508594, -1707955208, -1985443438, 137225525, 1597574327, 2041802794, -1595502793, 1282537579}, objArr69);
                                                                                cls = Class.forName((String) objArr69[0]);
                                                                                objArr3 = new Object[1];
                                                                                a(new byte[]{1, 1, 1, 0, 0, 1, 1, 0}, new int[]{186, 8, 0, 0}, true, objArr3);
                                                                                if (((Integer) cls.getMethod((String) objArr3[0], null).invoke(r5, null)).intValue() == 4) {
                                                                                    int iResolveSizeAndState = View.resolveSizeAndState(0, 0, 0);
                                                                                    int iIPostMessageService9 = Lists.TransformingRandomAccessList.AnonymousClass1.IPostMessageService();
                                                                                    int i280 = ~iIPostMessageService9;
                                                                                    int i281 = ~(((-8) & i280) | ((-8) ^ i280));
                                                                                    int i282 = ~((iResolveSizeAndState ^ iIPostMessageService9) | (iResolveSizeAndState & iIPostMessageService9));
                                                                                    int i283 = ((iResolveSizeAndState * 960) - 13419) + (((i281 & i282) | (i281 ^ i282)) * 959) + 7672;
                                                                                    int i284 = ((~((iIPostMessageService9 & (-8)) | ((-8) ^ iIPostMessageService9))) | (~((iResolveSizeAndState & i280) | (i280 ^ iResolveSizeAndState)))) * 959;
                                                                                    Object[] objArr70 = new Object[1];
                                                                                    c(((i283 | i284) << 1) - (i284 ^ i283), new int[]{1927792283, -663241186, -520769080, -90225899}, objArr70);
                                                                                    obj2 = objArr70[0];
                                                                                } else {
                                                                                    int i285 = -View.combineMeasuredStates(0, 0);
                                                                                    Object[] objArr71 = new Object[1];
                                                                                    c(((i285 | 3) << 1) - (i285 ^ 3), new int[]{-2028639001, 1564982371}, objArr71);
                                                                                    obj2 = objArr71[0];
                                                                                }
                                                                                str = (String) obj2;
                                                                                int i286 = -(ViewConfiguration.getKeyRepeatTimeout() >> 16);
                                                                                Object[] objArr72 = new Object[1];
                                                                                c(((i286 | 30) << 1) - (i286 ^ 30), new int[]{-553959009, 1566372400, 2145491739, -1796016629, 1015558550, -1808814313, 600618822, -1854666632, 1964086842, 560341688, 1888163075, 733288094, -1833489099, 842928759, -2083258904, -518269280}, objArr72);
                                                                                Class<?> cls15 = Class.forName((String) objArr72[0]);
                                                                                Object[] objArr73 = new Object[1];
                                                                                a(null, new int[]{211, 10, 67, 3}, true, objArr73);
                                                                                objArr4 = (Object[]) cls15.getField((String) objArr73[0]).get(objInvoke);
                                                                                length3 = objArr4.length;
                                                                                i12 = 0;
                                                                                r14 = r13;
                                                                                while (i12 < length3) {
                                                                                    int i287 = artificialFrame;
                                                                                    i13 = (i287 & 101) + (i287 | 101);
                                                                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i13 % 128;
                                                                                    if (i13 % 2 != 0) {
                                                                                        Object obj6 = objArr4[i12];
                                                                                        throw null;
                                                                                    }
                                                                                    Object obj7 = objArr4[i12];
                                                                                    obj3 = objInvoke;
                                                                                    i14 = length2;
                                                                                    Object[] objArr74 = new Object[1];
                                                                                    c(View.MeasureSpec.getMode(0) + 27, new int[]{-1126508594, -1707955208, -1142011696, -607183002, -2037064201, -1876888749, 1899525521, 1645533664, 762759276, 1112811353, 268823455, 1793814410, -2789657, -403136695}, objArr74);
                                                                                    str2 = str7;
                                                                                    Object objInvoke7 = Class.forName((String) objArr74[0]).getMethod(str2, String.class).invoke(null, str);
                                                                                    Object[] objArr75 = new Object[1];
                                                                                    a(new byte[]{1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1}, new int[]{221, 28, 0, 0}, true, objArr75);
                                                                                    Class<?> cls16 = Class.forName((String) objArr75[0]);
                                                                                    int i288 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                                                                    int i289 = (i288 & 45) + (i288 | 45);
                                                                                    artificialFrame = i289 % 128;
                                                                                    int i290 = i289 % 2;
                                                                                    int i291 = (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                                                                                    int iIPostMessageService10 = Lists.TransformingRandomAccessList.AnonymousClass1.IPostMessageService();
                                                                                    str3 = str;
                                                                                    int i292 = ~i291;
                                                                                    i15 = length3;
                                                                                    int i293 = ~iIPostMessageService10;
                                                                                    int i294 = ((i291 * 866) - 9504) + (((-12) | (~((i292 ^ i293) | (i292 & i293)))) * (-865));
                                                                                    int i295 = (~(i291 | iIPostMessageService10)) * 865;
                                                                                    int i296 = (i294 & i295) + (i295 | i294);
                                                                                    int i297 = ~iIPostMessageService10;
                                                                                    int i298 = ~((i297 & (-12)) | ((-12) ^ i297));
                                                                                    int i299 = ~(i293 | i291);
                                                                                    int i300 = -(-(((i298 & i299) | (i298 ^ i299)) * 865));
                                                                                    Object[] objArr76 = new Object[1];
                                                                                    c((i296 ^ i300) + ((i296 & i300) << 1), new int[]{-385849482, 2145409738, 1740005207, -1640331511, 503494999, 1098140876}, objArr76);
                                                                                    Object[] objArr77 = {cls16.getMethod((String) objArr76[0], null).invoke(obj7, null)};
                                                                                    int i301 = -(ViewConfiguration.getTouchSlop() >> 8);
                                                                                    int iIPostMessageService11 = Lists.TransformingRandomAccessList.AnonymousClass1.IPostMessageService();
                                                                                    int i302 = i301 * (-1965);
                                                                                    int i303 = (((i302 | 26568) << 1) - (i302 ^ 26568)) + (((i301 ^ (-28)) | (i301 & (-28))) * 983);
                                                                                    int i304 = ~i301;
                                                                                    int i305 = ~iIPostMessageService11;
                                                                                    int i306 = ~(((-28) & i305) | ((-28) ^ i305));
                                                                                    int i307 = i303 + (((i306 & i304) | (i304 ^ i306)) * (-983));
                                                                                    int i308 = ((~((~i301) | 27)) | (~((i305 & i304) | (i304 ^ i305)))) * 983;
                                                                                    Object[] objArr78 = new Object[1];
                                                                                    c((i307 & i308) + (i308 | i307), new int[]{-1126508594, -1707955208, -1142011696, -607183002, -2037064201, -1876888749, 1899525521, 1645533664, 762759276, 1112811353, 268823455, 1793814410, -2789657, -403136695}, objArr78);
                                                                                    Class<?> cls17 = Class.forName((String) objArr78[0]);
                                                                                    Object[] objArr79 = new Object[1];
                                                                                    a(new byte[]{0, 1, 0, 0, 0, 1}, new int[]{249, 6, 0, 0}, true, objArr79);
                                                                                    Object[] objArr80 = {cls17.getMethod((String) objArr79[0], byte[].class).invoke(objInvoke7, objArr77)};
                                                                                    Class<?> cls18 = Class.forName(str10);
                                                                                    int i309 = (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
                                                                                    Object[] objArr81 = new Object[1];
                                                                                    c((i309 & 3) + (i309 | 3), new int[]{1799158074, -1917480941}, objArr81);
                                                                                    objInvoke2 = cls18.getMethod((String) objArr81[0], byte[].class).invoke(null, objArr80);
                                                                                    int i310 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                                                                    int i311 = (i310 & 101) + (i310 | 101);
                                                                                    artificialFrame = i311 % 128;
                                                                                    int i312 = i311 % 2;
                                                                                    cls2 = Class.forName(str10);
                                                                                    i16 = (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                                                                                    int i313 = artificialFrame + 93;
                                                                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i313 % 128;
                                                                                    int i314 = i313 % 2;
                                                                                    iIPostMessageService = Lists.TransformingRandomAccessList.AnonymousClass1.IPostMessageService();
                                                                                    int i315 = i16 * 755;
                                                                                    int i316 = (i315 & (-9036)) + (i315 | (-9036));
                                                                                    i17 = ~i16;
                                                                                    int i317 = ~((i17 ^ 12) | (i17 & 12));
                                                                                    i18 = ~i16;
                                                                                    r31 = r14;
                                                                                    int i318 = ~((i18 ^ iIPostMessageService) | (i18 & iIPostMessageService));
                                                                                    int i319 = (i317 ^ i318) | (i318 & i317);
                                                                                    int i320 = ~(iIPostMessageService | 12);
                                                                                    i19 = i316 + (((i319 ^ i320) | (i319 & i320)) * (-754));
                                                                                    int i321 = artificialFrame;
                                                                                    i20 = ((i321 | 85) << 1) - (i321 ^ 85);
                                                                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i20 % 128;
                                                                                    if (i20 % 2 != 0) {
                                                                                        throw null;
                                                                                    }
                                                                                    int i322 = (i17 ^ 12) | (i17 & 12);
                                                                                    int i323 = ~((i322 & iIPostMessageService) | (i322 ^ iIPostMessageService));
                                                                                    int i324 = ~iIPostMessageService;
                                                                                    int i325 = ~((i16 & i324) | (i324 ^ i16) | 12);
                                                                                    int i326 = (i19 - (~((-754) * ((i325 & i323) | (i323 ^ i325))))) - 1;
                                                                                    int i327 = ~iIPostMessageService;
                                                                                    int i328 = ((i327 & i18) | (i18 ^ i327)) * 754;
                                                                                    Object[] objArr82 = new Object[1];
                                                                                    c(((i326 | i328) << 1) - (i328 ^ i326), new int[]{2143351903, -982766959, -1780750661, -446571346, -967477501, 352953536}, objArr82);
                                                                                    objInvoke3 = cls2.getMethod((String) objArr82[0], null).invoke(objInvoke2, null);
                                                                                    if (objInvoke3 != null) {
                                                                                        string = str9;
                                                                                        i22 = 0;
                                                                                        while (true) {
                                                                                            int i329 = artificialFrame;
                                                                                            i23 = (i329 ^ 119) + ((i329 & 119) << 1);
                                                                                            getARTIFICIAL_FRAME_PACKAGE_NAME = i23 % 128;
                                                                                            if (i23 % 2 != 0) {
                                                                                                i24 = (TypedValue.complexToFraction(1, 0.0f, 1.0f) > 2.0f ? 1 : (TypedValue.complexToFraction(1, 0.0f, 1.0f) == 2.0f ? 0 : -1));
                                                                                                i25 = 121;
                                                                                            } else {
                                                                                                i24 = (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                                                                                                i25 = 15;
                                                                                            }
                                                                                            int i330 = i24 * (-515);
                                                                                            int i331 = i25 * 517;
                                                                                            int i332 = ((i330 | i331) << 1) - (i330 ^ i331);
                                                                                            int i333 = ~i25;
                                                                                            int i334 = ~(((i333 & r12) == true ? 1 : 0) | ((i333 ^ r12) == true ? 1 : 0));
                                                                                            int i335 = ~r12;
                                                                                            int i336 = ~(i335 | i24);
                                                                                            int i337 = (i334 ^ i336) | (i336 & i334);
                                                                                            int i338 = ~r12;
                                                                                            int i339 = (i337 | (~(i338 | i25))) * (-516);
                                                                                            int i340 = (i332 & i339) + (i332 | i339);
                                                                                            i21 = i10;
                                                                                            int i341 = ~((((~i25) | (~i24)) | r12) == true ? 1 : 0);
                                                                                            int i342 = ~i24;
                                                                                            int i343 = ~((i342 ^ i338) | (i342 & i338) | i25);
                                                                                            int i344 = (i340 - (~(((i341 ^ i343) | (i341 & i343)) * 516))) - 1;
                                                                                            int i345 = ~((i342 ^ i25) | (i342 & i25));
                                                                                            int i346 = ~((i335 ^ i25) | (i335 & i25));
                                                                                            i26 = i344 + (((i345 & i346) | (i345 ^ i346)) * 516);
                                                                                            iArr = new int[]{-1126508594, -1707955208, -1985443438, 137225525, 1597574327, 2041802794, -1595502793, 1282537579};
                                                                                            int i347 = ~((447519814 & i338) | (447519814 ^ i338));
                                                                                            int i348 = (-133649860) + (((i347 & (-2083834278)) | ((-2083834278) ^ i347)) * (-602));
                                                                                            int i349 = ~((447519814 ^ r12) | (447519814 & r12));
                                                                                            int i350 = ((-2126306792) ^ i349) | ((-2126306792) & i349);
                                                                                            int i351 = (i338 ^ (-447519815)) | (i338 & (-447519815));
                                                                                            int i352 = ~((i351 ^ (-2083834278)) | (i351 & (-2083834278)));
                                                                                            int i353 = ((i350 ^ i352) | (i350 & i352)) * (-301);
                                                                                            int i354 = ((i348 | i353) << 1) - (i353 ^ i348);
                                                                                            int i355 = -(-((~(i335 | (-2083834278))) * 301));
                                                                                            i27 = (i354 ^ i355) + ((i355 & i354) << 1);
                                                                                            int iIPostMessageService12 = Lists.TransformingRandomAccessList.AnonymousClass1.IPostMessageService();
                                                                                            int i356 = ~iIPostMessageService12;
                                                                                            int i357 = ~((1860031814 ^ i356) | (1860031814 & i356));
                                                                                            int i358 = ~iIPostMessageService12;
                                                                                            int i359 = ~((351527308 ^ i358) | (351527308 & i358));
                                                                                            int i360 = -(-(((i357 ^ i359) | (i359 & i357)) * (-867)));
                                                                                            int i361 = ((217061680 | i360) << 1) - (i360 ^ 217061680);
                                                                                            int i362 = ~(1860031814 | iIPostMessageService12);
                                                                                            int i363 = ((-2130703823) ^ i362) | (i362 & (-2130703823));
                                                                                            int i364 = ~((351527308 ^ iIPostMessageService12) | (351527308 & iIPostMessageService12));
                                                                                            i28 = i361 + (((i363 ^ i364) | (i363 & i364)) * (-1734));
                                                                                            int i365 = ~((i356 & 2130703822) | (2130703822 ^ i356));
                                                                                            int i366 = ~(((-270672009) & iIPostMessageService12) | ((-270672009) ^ iIPostMessageService12));
                                                                                            i29 = -(-(((~((iIPostMessageService12 & (-1779176515)) | ((-1779176515) ^ iIPostMessageService12))) | (i365 & i366) | (i365 ^ i366)) * 867));
                                                                                            if (i27 > ((i28 | i29) << 1) - (i28 ^ i29)) {
                                                                                                Object[] objArr83 = new Object[1];
                                                                                                c(i26, iArr, objArr83);
                                                                                                Class<?> cls19 = Class.forName((String) objArr83[0]);
                                                                                                Object[] objArr84 = new Object[1];
                                                                                                a(new byte[]{1, 1, 0, 0, 1}, new int[]{170, 5, 43, 0}, false, objArr84);
                                                                                                method = cls19.getMethod((String) objArr84[0], null);
                                                                                                objArr5 = null;
                                                                                            } else {
                                                                                                Object[] objArr85 = new Object[1];
                                                                                                c(i26, iArr, objArr85);
                                                                                                Class<?> cls20 = Class.forName((String) objArr85[0]);
                                                                                                Object[] objArr86 = new Object[1];
                                                                                                a(new byte[]{1, 1, 0, 0, 1}, new int[]{170, 5, 43, 0}, true, objArr86);
                                                                                                objArr5 = null;
                                                                                                method = cls20.getMethod((String) objArr86[0], null);
                                                                                            }
                                                                                            if (i22 >= ((Integer) method.invoke(objInvoke3, objArr5)).intValue()) {
                                                                                                break;
                                                                                                break;
                                                                                            }
                                                                                            StringBuilder sb = new StringBuilder();
                                                                                            sb.append(string);
                                                                                            int i367 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                                                                            i30 = (i367 & AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY) + (i367 | AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY);
                                                                                            artificialFrame = i30 % 128;
                                                                                            if (i30 % 2 == 0) {
                                                                                                i31 = 0;
                                                                                                int i368 = 21 / 0;
                                                                                            } else {
                                                                                                i31 = 0;
                                                                                            }
                                                                                            Object[] objArr87 = new Object[1];
                                                                                            objArr87[i31] = Integer.valueOf(i22);
                                                                                            Object[] objArr88 = new Object[1];
                                                                                            a(new byte[]{0, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1}, new int[]{i31, 19, i31, 17}, i31, objArr88);
                                                                                            Class<?> cls21 = Class.forName((String) objArr88[i31]);
                                                                                            int i369 = -(-(ViewConfiguration.getDoubleTapTimeout() >> 16));
                                                                                            Object[] objArr89 = new Object[1];
                                                                                            c((i369 & 3) + (i369 | 3), new int[]{1308963368, -547684839}, objArr89);
                                                                                            Object[] objArr90 = {Long.valueOf(((Long) cls21.getMethod((String) objArr89[0], Integer.TYPE).invoke(objInvoke3, objArr87)).longValue())};
                                                                                            String str13 = str9;
                                                                                            int i370 = -TextUtils.indexOf((CharSequence) str13, '0');
                                                                                            int i371 = i370 * 367;
                                                                                            int i372 = (i371 & 4771) + (i371 | 4771);
                                                                                            int i373 = (i370 | 13) * (-366);
                                                                                            int i374 = (((i372 | i373) << 1) - (i373 ^ i372)) + (((~(((-14) & r12) | ((-14) ^ r12))) | i370) * (-366));
                                                                                            int i375 = ~i370;
                                                                                            int i376 = ~((i375 & 13) | (i375 ^ 13));
                                                                                            int i377 = ((-14) ^ i370) | (i370 & (-14));
                                                                                            int i378 = ~((i377 & r12) | ((i377 ^ r12) == true ? 1 : 0));
                                                                                            int i379 = ((i378 & i376) | (i376 ^ i378)) * 366;
                                                                                            Object[] objArr91 = new Object[1];
                                                                                            c((i374 ^ i379) + ((i379 & i374) << 1), new int[]{-1126508594, -1707955208, -856323126, 2122573174, -2076996192, -1835679048, 1552917501, 2030585986}, objArr91);
                                                                                            Class<?> cls22 = Class.forName((String) objArr91[0]);
                                                                                            Object[] objArr92 = new Object[1];
                                                                                            a(new byte[]{1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1}, new int[]{175, 11, 0, 0}, true, objArr92);
                                                                                            sb.append((String) cls22.getMethod((String) objArr92[0], Long.TYPE).invoke(null, objArr90));
                                                                                            string = sb.toString();
                                                                                            i22++;
                                                                                            str9 = str13;
                                                                                            i10 = i21;
                                                                                        }
                                                                                        str4 = str9;
                                                                                    } else {
                                                                                        i21 = i10;
                                                                                        str4 = str9;
                                                                                        string = str4;
                                                                                    }
                                                                                    linkedHashSet.add(string);
                                                                                    if (objInvoke3.equals(r5.rewind())) {
                                                                                        objArr = new Object[]{new int[]{r12}, null, new int[1], new int[]{r12}};
                                                                                        int startElapsedRealtime2 = (int) Process.getStartElapsedRealtime();
                                                                                        int i380 = i3 + (-1260349191) + ((~((~startElapsedRealtime2) | (-419594243))) * (-116)) + ((587038436 | startElapsedRealtime2) * 116) + (((~(startElapsedRealtime2 | 426688710)) | 579943968) * 116);
                                                                                        int i381 = i380 << 13;
                                                                                        int i382 = ((~i380) & i381) | ((~i381) & i380);
                                                                                        int i383 = i382 >>> 17;
                                                                                        int i384 = ((~i382) & i383) | ((~i383) & i382);
                                                                                        int i385 = i384 << 5;
                                                                                        ((int[]) objArr[2])[0] = (i384 | i385) & (~(i384 & i385));
                                                                                        return objArr;
                                                                                    }
                                                                                    int i386 = (i12 ^ 31) + ((i12 & 31) << 1);
                                                                                    i12 = (i386 & (-30)) + (i386 | (-30));
                                                                                    objInvoke = obj3;
                                                                                    str = str3;
                                                                                    str9 = str4;
                                                                                    i10 = i21;
                                                                                    length2 = i14;
                                                                                    length3 = i15;
                                                                                    r14 = r31;
                                                                                    str7 = str2;
                                                                                    objArr = new Object[]{new int[]{(~(r12 & 2)) & (r12 | 2)}, null, new int[]{((~i) & i) | ((~i) & i)}, new int[]{r12}};
                                                                                    int i387 = (-1761203017) + (((~(614751685 | r12)) | 8668164) * (-502)) + ((~((~r12) | 783769575)) * (-502)) + ((614751685 | (~((-775101412) | r12))) * TypedValues.PositionType.TYPE_DRAWPATH);
                                                                                    int i388 = 9071 - (~(i387 * (-565)));
                                                                                    int i389 = ~(((-17) ^ i387) | ((-17) & i387));
                                                                                    int i390 = ~((-17) | r12);
                                                                                    int i391 = i388 + (((i389 & i390) | (i389 ^ i390)) * (-566));
                                                                                    int i392 = ~i387;
                                                                                    int i393 = (~((i392 & 16) | (i392 ^ 16))) * 566;
                                                                                    int i394 = (i391 ^ i393) + ((i391 & i393) << 1);
                                                                                    int i395 = ~i387;
                                                                                    int i396 = (i395 & (-17)) | ((-17) ^ i395);
                                                                                    int i397 = i394 + ((~(((i396 & r12) == true ? 1 : 0) | ((i396 ^ r12) == true ? 1 : 0))) * 566);
                                                                                    int i398 = (i3 ^ i397) + ((i3 & i397) << 1);
                                                                                    int i399 = i398 << 13;
                                                                                    int i400 = (i398 | i399) & (~(i398 & i399));
                                                                                    int i401 = i400 >>> 17;
                                                                                    int i402 = (i400 | i401) & (~(i400 & i401));
                                                                                    int i403 = i402 << 5;
                                                                                    return objArr;
                                                                                }
                                                                                Object obj8 = objInvoke;
                                                                                int i404 = i10;
                                                                                int i405 = ((i404 | WebSocketProtocol.PAYLOAD_SHORT) << 1) - (i404 ^ WebSocketProtocol.PAYLOAD_SHORT);
                                                                                i10 = (i405 ^ (-125)) + ((i405 & (-125)) << 1);
                                                                                objInvoke = obj8;
                                                                                length2 = length2;
                                                                                r13 = r14;
                                                                                str7 = str7;
                                                                            }
                                                                            int i406 = (r12 & (-2)) | ((~r12) & 1);
                                                                            arrayList = new ArrayList(linkedHashSet);
                                                                            int size = arrayList.size();
                                                                            strArr2 = new String[(size & 1) + (size | 1)];
                                                                            Object[] objArr93 = new Object[1];
                                                                            c(4 - (~TextUtils.indexOf((CharSequence) str9, '0', 0, 0)), new int[]{1704931633, 256569062}, objArr93);
                                                                            strArr2[0] = (String) objArr93[0];
                                                                            while (i11 < arrayList.size()) {
                                                                                strArr2[(i11 & 1) + (i11 | 1)] = (String) arrayList.get(i11);
                                                                            }
                                                                            objArr2 = new Object[]{new int[]{i406}, strArr2, new int[]{((~i) & i) | ((~i) & i)}, new int[]{r12}};
                                                                            int i407 = ~(159568742 | r12);
                                                                            int i408 = 447134031 + (((-780984) | i407) * (-220)) + ((i407 | (-160168952)) * 220) + 418830302;
                                                                            int i409 = ((i3 | i408) << 1) - (i3 ^ i408);
                                                                            int i410 = i409 << 13;
                                                                            int i411 = ((~i409) & i410) | ((~i410) & i409);
                                                                            int i412 = i411 >>> 17;
                                                                            int i413 = ((~i411) & i412) | ((~i412) & i411);
                                                                            int i414 = i413 << 5;
                                                                            return objArr2;
                                                                        } catch (Throwable th25) {
                                                                            th = th25;
                                                                            th = th;
                                                                            r6 = 0;
                                                                            if (r6 != 0) {
                                                                                throw th;
                                                                            }
                                                                            r6.deleteEntry(string4);
                                                                            throw th;
                                                                        }
                                                                    }
                                                                } catch (Throwable th26) {
                                                                    th = th26;
                                                                }
                                                            } catch (Exception unused6) {
                                                            }
                                                        } catch (Throwable th27) {
                                                            th = th27;
                                                        }
                                                    } catch (Throwable th28) {
                                                        th = th28;
                                                    }
                                                } catch (Exception unused7) {
                                                }
                                            } catch (Throwable th29) {
                                                Throwable cause15 = th29.getCause();
                                                if (cause15 != null) {
                                                    throw cause15;
                                                }
                                                throw th29;
                                            }
                                        }
                                        try {
                                            objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(1379818893);
                                            if (objAccessartificialFrame6 == null) {
                                                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(TextUtils.indexOf("", "", 0) + 42, (char) (KeyEvent.normalizeMetaState(0) + 19409), 3808 - Color.red(0), -849667195, false, "onResult", new Class[0]);
                                            }
                                            list = (List) ((Method) objAccessartificialFrame6).invoke(objNewInstance, null);
                                            if (list == null || list.isEmpty()) {
                                                listEmptyList = null;
                                                r16 = r15;
                                                r24 = r23;
                                                break;
                                            }
                                            int size2 = list.size() - 1;
                                            while (true) {
                                                if (size2 < 0) {
                                                    listEmptyList = null;
                                                    r16 = r15;
                                                    r24 = r23;
                                                    break;
                                                }
                                                Object obj9 = list.get(size2);
                                                Object[] objArr94 = new Object[1];
                                                a(new byte[]{1, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1}, new int[]{93, 24, 0, 0}, true, objArr94);
                                                String str14 = (String) objArr94[0];
                                                int i415 = artificialFrame;
                                                int i416 = (i415 & 59) + (i415 | 59);
                                                getARTIFICIAL_FRAME_PACKAGE_NAME = i416 % 128;
                                                int i417 = i416 % 2;
                                                try {
                                                    Object[] objArr95 = new Object[1];
                                                    a(new byte[]{0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1}, new int[]{117, 34, 0, 27}, true, objArr95);
                                                    Class<?> cls23 = Class.forName((String) objArr95[0]);
                                                    Object[] objArr96 = new Object[1];
                                                    c(16 - (~(-(ViewConfiguration.getMaximumDrawingCacheSize() >> 24))), new int[]{1094919268, -466142805, 1279567625, 761439201, 741800897, -869790482, -1439696718, -623994806, -595575643, -705836600}, objArr96);
                                                    byte[] bArr5 = (byte[]) cls23.getMethod((String) objArr96[0], String.class).invoke(obj9, str14);
                                                    if (bArr5 != null) {
                                                        Object objNewInstance2 = ((Class) ArtificialStackFrames.coroutineCreation(Color.rgb(0, 0, 0) + 16777263, (char) (31396 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))), ImageFormat.getBitsPerPixel(0) + 2648)).getConstructor(new Class[0]).newInstance(new Object[0]);
                                                        try {
                                                            Object[] objArr97 = {objNewInstance2, bArr5};
                                                            Object objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(1094878374);
                                                            if (objAccessartificialFrame9 == null) {
                                                                objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(24 - ((Process.getThreadPriority(0) + 20) >> 6), (char) TextUtils.getTrimmedLength(""), 387 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), -567819602, false, null, new Class[]{(Class) ArtificialStackFrames.coroutineCreation(24 - (ViewConfiguration.getScrollBarSize() >> 8), (char) (TextUtils.indexOf("", "", 0, 0) + 53250), (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 124), byte[].class});
                                                            }
                                                            InputStream inputStream = (InputStream) ((Constructor) objAccessartificialFrame9).newInstance(objArr97);
                                                            try {
                                                                Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-1239553844);
                                                                if (objAccessartificialFrame10 == null) {
                                                                    objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(24 - TextUtils.indexOf("", ""), (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16), TextUtils.getOffsetAfter("", 0) + 386, 695774916, false, "MediaMetadataCompatBitmapKey", null);
                                                                }
                                                                Object obj10 = ((Field) objAccessartificialFrame10).get(inputStream);
                                                                try {
                                                                    Object[] objArr98 = {inputStream};
                                                                    Object objAccessartificialFrame11 = ArtificialStackFrames.accessartificialFrame(1296960672);
                                                                    if (objAccessartificialFrame11 == null) {
                                                                        objAccessartificialFrame11 = ArtificialStackFrames.coroutineCreation(24 - KeyEvent.keyCodeFromString(""), (char) (53250 - View.MeasureSpec.getMode(0)), 123 - ImageFormat.getBitsPerPixel(0), -768914776, false, "coroutineBoundary", new Class[]{InputStream.class});
                                                                    }
                                                                    Object objInvoke8 = ((Method) objAccessartificialFrame11).invoke(obj10, objArr98);
                                                                    Object objAccessartificialFrame12 = ArtificialStackFrames.accessartificialFrame(-1239553844);
                                                                    if (objAccessartificialFrame12 == null) {
                                                                        objAccessartificialFrame12 = ArtificialStackFrames.coroutineCreation(24 - TextUtils.getOffsetAfter("", 0), (char) (ViewConfiguration.getScrollBarSize() >> 8), 386 - TextUtils.indexOf("", "", 0, 0), 695774916, false, "MediaMetadataCompatBitmapKey", null);
                                                                    }
                                                                    Object obj11 = ((Field) objAccessartificialFrame12).get(inputStream);
                                                                    try {
                                                                        Object[] objArr99 = {inputStream};
                                                                        Object objAccessartificialFrame13 = ArtificialStackFrames.accessartificialFrame(-119044754);
                                                                        if (objAccessartificialFrame13 == null) {
                                                                            objAccessartificialFrame13 = ArtificialStackFrames.coroutineCreation(25 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), (char) (53250 - (ViewConfiguration.getTouchSlop() >> 8)), View.combineMeasuredStates(0, 0) + 124, 1736622950, false, "ArtificialStackFrames", new Class[]{InputStream.class});
                                                                        }
                                                                        int iIntValue = ((Integer) ((Method) objAccessartificialFrame13).invoke(obj11, objArr99)).intValue();
                                                                        Object objAccessartificialFrame14 = ArtificialStackFrames.accessartificialFrame(-1239553844);
                                                                        if (objAccessartificialFrame14 == null) {
                                                                            objAccessartificialFrame14 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 24, (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16), (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 386, 695774916, false, "MediaMetadataCompatBitmapKey", null);
                                                                        }
                                                                        Object obj12 = ((Field) objAccessartificialFrame14).get(inputStream);
                                                                        try {
                                                                            Object[] objArr100 = {Integer.valueOf(iIntValue), inputStream};
                                                                            Object objAccessartificialFrame15 = ArtificialStackFrames.accessartificialFrame(-729892777);
                                                                            if (objAccessartificialFrame15 == null) {
                                                                                objAccessartificialFrame15 = ArtificialStackFrames.coroutineCreation(24 - Color.alpha(0), (char) (53250 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1))), 124 - Color.green(0), 1260125791, false, "ArtificialStackFrames", new Class[]{Integer.TYPE, InputStream.class});
                                                                            }
                                                                            Object objInvoke9 = ((Method) objAccessartificialFrame15).invoke(obj12, objArr100);
                                                                            Object objAccessartificialFrame16 = ArtificialStackFrames.accessartificialFrame(-1239553844);
                                                                            if (objAccessartificialFrame16 == null) {
                                                                                objAccessartificialFrame16 = ArtificialStackFrames.coroutineCreation(Color.red(0) + 24, (char) ExpandableListView.getPackedPositionGroup(0L), TextUtils.getCapsMode("", 0, 0) + 386, 695774916, false, "MediaMetadataCompatBitmapKey", null);
                                                                            }
                                                                            try {
                                                                                Object[] objArr101 = {((Field) objAccessartificialFrame16).get(inputStream)};
                                                                                Object objAccessartificialFrame17 = ArtificialStackFrames.accessartificialFrame(1328317403);
                                                                                if (objAccessartificialFrame17 == null) {
                                                                                    objAccessartificialFrame17 = ArtificialStackFrames.coroutineCreation(14 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)), (char) (ViewConfiguration.getTouchSlop() >> 8), View.MeasureSpec.getMode(0) + 2753, -800471597, false, "ArtificialStackFrames", new Class[]{(Class) ArtificialStackFrames.coroutineCreation(KeyEvent.keyCodeFromString("") + 24, (char) ((ViewConfiguration.getWindowTouchSlop() >> 8) + 53250), (ViewConfiguration.getPressedStateDuration() >> 16) + 124)});
                                                                                }
                                                                                Object objInvoke10 = ((Method) objAccessartificialFrame17).invoke(objInvoke8, objArr101);
                                                                                try {
                                                                                    Object[] objArr102 = {objInvoke8, objInvoke9};
                                                                                    Object objAccessartificialFrame18 = ArtificialStackFrames.accessartificialFrame(1176953419);
                                                                                    if (objAccessartificialFrame18 == null) {
                                                                                        objAccessartificialFrame18 = ArtificialStackFrames.coroutineCreation(15 - (Process.myTid() >> 22), (char) ((-1) - TextUtils.lastIndexOf("", '0', 0, 0)), 343 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), -649878461, false, "accessartificialFrame", new Class[]{(Class) ArtificialStackFrames.coroutineCreation(14 - TextUtils.getTrimmedLength(""), (char) ((-1) - Process.getGidForName("")), 2753 - (ViewConfiguration.getJumpTapTimeout() >> 16)), byte[].class});
                                                                                    }
                                                                                    Object objInvoke11 = ((Method) objAccessartificialFrame18).invoke(objInvoke10, objArr102);
                                                                                    inputStream.close();
                                                                                    Object objAccessartificialFrame19 = ArtificialStackFrames.accessartificialFrame(-2134990334);
                                                                                    if (objAccessartificialFrame19 == null) {
                                                                                        objAccessartificialFrame19 = ArtificialStackFrames.coroutineCreation(AndroidCharacter.getMirror('0') - 26, (char) (Process.myTid() >> 22), 3982 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), 534504458, false, "e", null);
                                                                                    }
                                                                                    byte[] bArr6 = (byte[]) ((Field) objAccessartificialFrame19).get(objInvoke11);
                                                                                    Object objAccessartificialFrame20 = ArtificialStackFrames.accessartificialFrame(-2134990334);
                                                                                    if (objAccessartificialFrame20 == null) {
                                                                                        objAccessartificialFrame20 = ArtificialStackFrames.coroutineCreation(TextUtils.indexOf("", "", 0, 0) + 22, (char) Color.argb(0, 0, 0, 0), 3982 - (ViewConfiguration.getWindowTouchSlop() >> 8), 534504458, false, "e", null);
                                                                                    }
                                                                                    try {
                                                                                        Object[] objArr103 = {objNewInstance2, Arrays.copyOf(bArr6, ((byte[]) ((Field) objAccessartificialFrame20).get(objInvoke11)).length)};
                                                                                        Object objAccessartificialFrame21 = ArtificialStackFrames.accessartificialFrame(1094878374);
                                                                                        if (objAccessartificialFrame21 == null) {
                                                                                            objAccessartificialFrame21 = ArtificialStackFrames.coroutineCreation(24 - Color.alpha(0), (char) (TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 1), (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + 386, -567819602, false, null, new Class[]{(Class) ArtificialStackFrames.coroutineCreation(Color.green(0) + 24, (char) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 53249), 124 - TextUtils.getTrimmedLength("")), byte[].class});
                                                                                        }
                                                                                        InputStream inputStream2 = (InputStream) ((Constructor) objAccessartificialFrame21).newInstance(objArr103);
                                                                                        try {
                                                                                            Object objAccessartificialFrame22 = ArtificialStackFrames.accessartificialFrame(-1239553844);
                                                                                            if (objAccessartificialFrame22 == null) {
                                                                                                objAccessartificialFrame22 = ArtificialStackFrames.coroutineCreation(23 - TextUtils.lastIndexOf("", '0', 0), (char) (MotionEvent.axisFromString("") + 1), 386 - (ViewConfiguration.getJumpTapTimeout() >> 16), 695774916, false, "MediaMetadataCompatBitmapKey", null);
                                                                                            }
                                                                                            Object obj13 = ((Field) objAccessartificialFrame22).get(inputStream2);
                                                                                            try {
                                                                                                Object[] objArr104 = {inputStream2};
                                                                                                Object objAccessartificialFrame23 = ArtificialStackFrames.accessartificialFrame(1296960672);
                                                                                                if (objAccessartificialFrame23 == null) {
                                                                                                    objAccessartificialFrame23 = ArtificialStackFrames.coroutineCreation(24 - TextUtils.getTrimmedLength(""), (char) (53250 - Drawable.resolveOpacity(0, 0)), TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 125, -768914776, false, "coroutineBoundary", new Class[]{InputStream.class});
                                                                                                }
                                                                                                Object objInvoke12 = ((Method) objAccessartificialFrame23).invoke(obj13, objArr104);
                                                                                                Object objAccessartificialFrame24 = ArtificialStackFrames.accessartificialFrame(-1239553844);
                                                                                                if (objAccessartificialFrame24 == null) {
                                                                                                    objAccessartificialFrame24 = ArtificialStackFrames.coroutineCreation(TextUtils.indexOf("", "", 0, 0) + 24, (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), 386 - (ViewConfiguration.getTouchSlop() >> 8), 695774916, false, "MediaMetadataCompatBitmapKey", null);
                                                                                                }
                                                                                                Object obj14 = ((Field) objAccessartificialFrame24).get(inputStream2);
                                                                                                try {
                                                                                                    Object[] objArr105 = {inputStream2};
                                                                                                    Object objAccessartificialFrame25 = ArtificialStackFrames.accessartificialFrame(-119044754);
                                                                                                    if (objAccessartificialFrame25 == null) {
                                                                                                        objAccessartificialFrame25 = ArtificialStackFrames.coroutineCreation(23 - MotionEvent.axisFromString(""), (char) (53250 - TextUtils.getOffsetBefore("", 0)), KeyEvent.keyCodeFromString("") + 124, 1736622950, false, "ArtificialStackFrames", new Class[]{InputStream.class});
                                                                                                    }
                                                                                                    int iIntValue2 = ((Integer) ((Method) objAccessartificialFrame25).invoke(obj14, objArr105)).intValue();
                                                                                                    Object objAccessartificialFrame26 = ArtificialStackFrames.accessartificialFrame(-1239553844);
                                                                                                    if (objAccessartificialFrame26 == null) {
                                                                                                        objAccessartificialFrame26 = ArtificialStackFrames.coroutineCreation(TextUtils.lastIndexOf("", '0', 0, 0) + 25, (char) (Process.myTid() >> 22), Color.green(0) + 386, 695774916, false, "MediaMetadataCompatBitmapKey", null);
                                                                                                    }
                                                                                                    Object obj15 = ((Field) objAccessartificialFrame26).get(inputStream2);
                                                                                                    try {
                                                                                                        Object[] objArr106 = {Integer.valueOf(iIntValue2), inputStream2};
                                                                                                        Object objAccessartificialFrame27 = ArtificialStackFrames.accessartificialFrame(-729892777);
                                                                                                        if (objAccessartificialFrame27 == null) {
                                                                                                            objAccessartificialFrame27 = ArtificialStackFrames.coroutineCreation(24 - (Process.myTid() >> 22), (char) (TextUtils.indexOf((CharSequence) "", '0') + 53251), 123 - TextUtils.lastIndexOf("", '0', 0, 0), 1260125791, false, "ArtificialStackFrames", new Class[]{Integer.TYPE, InputStream.class});
                                                                                                        }
                                                                                                        Object objInvoke13 = ((Method) objAccessartificialFrame27).invoke(obj15, objArr106);
                                                                                                        Object objAccessartificialFrame28 = ArtificialStackFrames.accessartificialFrame(-1239553844);
                                                                                                        if (objAccessartificialFrame28 == null) {
                                                                                                            objAccessartificialFrame28 = ArtificialStackFrames.coroutineCreation(24 - (ViewConfiguration.getScrollBarSize() >> 8), (char) View.MeasureSpec.getSize(0), TextUtils.indexOf("", "") + 386, 695774916, false, "MediaMetadataCompatBitmapKey", null);
                                                                                                        }
                                                                                                        try {
                                                                                                            Object[] objArr107 = {((Field) objAccessartificialFrame28).get(inputStream2)};
                                                                                                            Object objAccessartificialFrame29 = ArtificialStackFrames.accessartificialFrame(1328317403);
                                                                                                            if (objAccessartificialFrame29 == null) {
                                                                                                                objAccessartificialFrame29 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 14, (char) (ViewConfiguration.getJumpTapTimeout() >> 16), (ViewConfiguration.getWindowTouchSlop() >> 8) + 2753, -800471597, false, "ArtificialStackFrames", new Class[]{(Class) ArtificialStackFrames.coroutineCreation(AndroidCharacter.getMirror('0') - 24, (char) (53298 - AndroidCharacter.getMirror('0')), (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 124)});
                                                                                                            }
                                                                                                            Object objInvoke14 = ((Method) objAccessartificialFrame29).invoke(objInvoke12, objArr107);
                                                                                                            try {
                                                                                                                Object[] objArr108 = {objInvoke12, objInvoke13};
                                                                                                                Object objAccessartificialFrame30 = ArtificialStackFrames.accessartificialFrame(1176953419);
                                                                                                                if (objAccessartificialFrame30 == null) {
                                                                                                                    objAccessartificialFrame30 = ArtificialStackFrames.coroutineCreation(15 - (Process.myPid() >> 22), (char) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) - 1), 343 - KeyEvent.getDeadChar(0, 0), -649878461, false, "accessartificialFrame", new Class[]{(Class) ArtificialStackFrames.coroutineCreation(TextUtils.indexOf((CharSequence) "", '0') + 15, (char) (1 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))), TextUtils.lastIndexOf("", '0', 0, 0) + 2754), byte[].class});
                                                                                                                }
                                                                                                                Object objInvoke15 = ((Method) objAccessartificialFrame30).invoke(objInvoke14, objArr108);
                                                                                                                inputStream2.close();
                                                                                                                Object[] objArr109 = (Object[]) Array.newInstance((Class<?>) ArtificialStackFrames.coroutineCreation(20 - KeyEvent.keyCodeFromString(""), (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), ImageFormat.getBitsPerPixel(0) + 3317), 2);
                                                                                                                Object objAccessartificialFrame31 = ArtificialStackFrames.accessartificialFrame(-1944720953);
                                                                                                                if (objAccessartificialFrame31 == null) {
                                                                                                                    objAccessartificialFrame31 = ArtificialStackFrames.coroutineCreation(View.MeasureSpec.makeMeasureSpec(0, 0) + 20, (char) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) - 1), (ViewConfiguration.getLongPressTimeout() >> 16) + 3316, 326152143, false, "b", null);
                                                                                                                }
                                                                                                                objArr109[0] = ((List) ((Field) objAccessartificialFrame31).get(objInvoke15)).get(7);
                                                                                                                Object objAccessartificialFrame32 = ArtificialStackFrames.accessartificialFrame(-1944720953);
                                                                                                                if (objAccessartificialFrame32 == null) {
                                                                                                                    objAccessartificialFrame32 = ArtificialStackFrames.coroutineCreation(20 - TextUtils.getOffsetBefore("", 0), (char) (ViewConfiguration.getDoubleTapTimeout() >> 16), MotionEvent.axisFromString("") + 3317, 326152143, false, "b", null);
                                                                                                                }
                                                                                                                objArr109[1] = ((List) ((Field) objAccessartificialFrame32).get(objInvoke15)).get(6);
                                                                                                                int length8 = objArr109.length;
                                                                                                                Object objInvoke16 = null;
                                                                                                                int i418 = 0;
                                                                                                                while (i418 < 2) {
                                                                                                                    Object obj16 = objArr109[i418];
                                                                                                                    Object objAccessartificialFrame33 = ArtificialStackFrames.accessartificialFrame(-1944720953);
                                                                                                                    if (objAccessartificialFrame33 == null) {
                                                                                                                        objAccessartificialFrame33 = ArtificialStackFrames.coroutineCreation(19 - ImageFormat.getBitsPerPixel(0), (char) ((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) - 1), TextUtils.lastIndexOf("", '0', 0, 0) + 3317, 326152143, false, "b", null);
                                                                                                                    }
                                                                                                                    Iterator it2 = new ArrayList((Collection) ((Field) objAccessartificialFrame33).get(obj16)).iterator();
                                                                                                                    while (true) {
                                                                                                                        if (!it2.hasNext()) {
                                                                                                                            objArr109 = objArr109;
                                                                                                                            break;
                                                                                                                        }
                                                                                                                        int i419 = artificialFrame + 37;
                                                                                                                        getARTIFICIAL_FRAME_PACKAGE_NAME = i419 % 128;
                                                                                                                        int i420 = i419 % 2;
                                                                                                                        Object next = it2.next();
                                                                                                                        Object objAccessartificialFrame34 = ArtificialStackFrames.accessartificialFrame(-1172013915);
                                                                                                                        if (objAccessartificialFrame34 == null) {
                                                                                                                            objAccessartificialFrame34 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getScrollBarSize() >> 8) + 10, (char) Color.red(0), 2694 - (ViewConfiguration.getWindowTouchSlop() >> 8), 625031853, false, "MediaControllerCompatCallbackStubCompat", null);
                                                                                                                        }
                                                                                                                        Object obj17 = ((Field) objAccessartificialFrame34).get(next);
                                                                                                                        Object objAccessartificialFrame35 = ArtificialStackFrames.accessartificialFrame(-1196027417);
                                                                                                                        if (objAccessartificialFrame35 == null) {
                                                                                                                            objAccessartificialFrame35 = ArtificialStackFrames.coroutineCreation(Process.getGidForName("") + 15, (char) TextUtils.indexOf("", ""), 2801 - AndroidCharacter.getMirror('0'), 668162031, false, "MediaControllerCompatMediaControllerImplApi24", null);
                                                                                                                        }
                                                                                                                        if (((Field) objAccessartificialFrame35).getInt(obj17) == 709) {
                                                                                                                            Object objAccessartificialFrame36 = ArtificialStackFrames.accessartificialFrame(-2123799311);
                                                                                                                            if (objAccessartificialFrame36 == null) {
                                                                                                                                objAccessartificialFrame36 = ArtificialStackFrames.coroutineCreation(32 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), (char) (30293 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1))), (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 2987, 504111865, false, "getCurrentVolume", null);
                                                                                                                            }
                                                                                                                            if (((Field) objAccessartificialFrame36).get(next) != null) {
                                                                                                                                Object objAccessartificialFrame37 = ArtificialStackFrames.accessartificialFrame(-2123799311);
                                                                                                                                if (objAccessartificialFrame37 == null) {
                                                                                                                                    objAccessartificialFrame37 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getScrollBarSize() >> 8) + 32, (char) (30292 - (ViewConfiguration.getDoubleTapTimeout() >> 16)), 2987 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), 504111865, false, "getCurrentVolume", null);
                                                                                                                                }
                                                                                                                                obj4 = ((Field) objAccessartificialFrame37).get(next);
                                                                                                                                objArr109 = objArr109;
                                                                                                                            } else {
                                                                                                                                Object objAccessartificialFrame38 = ArtificialStackFrames.accessartificialFrame(318476122);
                                                                                                                                if (objAccessartificialFrame38 == null) {
                                                                                                                                    objAccessartificialFrame38 = ArtificialStackFrames.coroutineCreation(32 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), (char) (Color.green(0) + 30292), 2986 - TextUtils.indexOf("", "", 0, 0), -1918973614, false, "MediaMetadataCompatBuilder", null);
                                                                                                                                }
                                                                                                                                Object obj18 = ((Field) objAccessartificialFrame38).get(next);
                                                                                                                                Object objAccessartificialFrame39 = ArtificialStackFrames.accessartificialFrame(209482075);
                                                                                                                                if (objAccessartificialFrame39 == null) {
                                                                                                                                    objAccessartificialFrame39 = ArtificialStackFrames.coroutineCreation(32 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), (char) (30292 - TextUtils.indexOf("", "")), TextUtils.indexOf("", "", 0, 0) + 2986, -1827063981, false, "a", null);
                                                                                                                                }
                                                                                                                                try {
                                                                                                                                    Object[] objArr110 = {obj18, ((Field) objAccessartificialFrame39).get(next)};
                                                                                                                                    Object objAccessartificialFrame40 = ArtificialStackFrames.accessartificialFrame(1094878374);
                                                                                                                                    if (objAccessartificialFrame40 == null) {
                                                                                                                                        objAccessartificialFrame40 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getTouchSlop() >> 8) + 24, (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 386, -567819602, false, null, new Class[]{(Class) ArtificialStackFrames.coroutineCreation((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 24, (char) (53250 - TextUtils.getTrimmedLength("")), 124 - TextUtils.getOffsetBefore("", 0)), byte[].class});
                                                                                                                                    }
                                                                                                                                    InputStream inputStream3 = (InputStream) ((Constructor) objAccessartificialFrame40).newInstance(objArr110);
                                                                                                                                    try {
                                                                                                                                        try {
                                                                                                                                            Object objAccessartificialFrame41 = ArtificialStackFrames.accessartificialFrame(-1239553844);
                                                                                                                                            if (objAccessartificialFrame41 == null) {
                                                                                                                                                objAccessartificialFrame41 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getMinimumFlingVelocity() >> 16) + 24, (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16), 386 - Gravity.getAbsoluteGravity(0, 0), 695774916, false, "MediaMetadataCompatBitmapKey", null);
                                                                                                                                            }
                                                                                                                                            Object obj19 = ((Field) objAccessartificialFrame41).get(inputStream3);
                                                                                                                                            try {
                                                                                                                                                Object[] objArr111 = {inputStream3};
                                                                                                                                                Object objAccessartificialFrame42 = ArtificialStackFrames.accessartificialFrame(1296960672);
                                                                                                                                                if (objAccessartificialFrame42 == null) {
                                                                                                                                                    objAccessartificialFrame42 = ArtificialStackFrames.coroutineCreation(TextUtils.indexOf("", "", 0, 0) + 24, (char) (53250 - (ViewConfiguration.getWindowTouchSlop() >> 8)), 124 - (ViewConfiguration.getEdgeSlop() >> 16), -768914776, false, "coroutineBoundary", new Class[]{InputStream.class});
                                                                                                                                                }
                                                                                                                                                Object objInvoke17 = ((Method) objAccessartificialFrame42).invoke(obj19, objArr111);
                                                                                                                                                Object objAccessartificialFrame43 = ArtificialStackFrames.accessartificialFrame(-1239553844);
                                                                                                                                                if (objAccessartificialFrame43 == null) {
                                                                                                                                                    objAccessartificialFrame43 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 23, (char) TextUtils.indexOf("", ""), 385 - ImageFormat.getBitsPerPixel(0), 695774916, false, "MediaMetadataCompatBitmapKey", null);
                                                                                                                                                }
                                                                                                                                                Object obj20 = ((Field) objAccessartificialFrame43).get(inputStream3);
                                                                                                                                                try {
                                                                                                                                                    Object[] objArr112 = {inputStream3};
                                                                                                                                                    Object objAccessartificialFrame44 = ArtificialStackFrames.accessartificialFrame(-119044754);
                                                                                                                                                    if (objAccessartificialFrame44 == null) {
                                                                                                                                                        objAccessartificialFrame44 = ArtificialStackFrames.coroutineCreation(((Process.getThreadPriority(0) + 20) >> 6) + 24, (char) (KeyEvent.getDeadChar(0, 0) + 53250), ((byte) KeyEvent.getModifierMetaStateMask()) + 125, 1736622950, false, "ArtificialStackFrames", new Class[]{InputStream.class});
                                                                                                                                                    }
                                                                                                                                                    int iIntValue3 = ((Integer) ((Method) objAccessartificialFrame44).invoke(obj20, objArr112)).intValue();
                                                                                                                                                    Object objAccessartificialFrame45 = ArtificialStackFrames.accessartificialFrame(-1239553844);
                                                                                                                                                    if (objAccessartificialFrame45 == null) {
                                                                                                                                                        objAccessartificialFrame45 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 23, (char) (ExpandableListView.getPackedPositionChild(0L) + 1), 386 - View.MeasureSpec.getMode(0), 695774916, false, "MediaMetadataCompatBitmapKey", null);
                                                                                                                                                    }
                                                                                                                                                    Object obj21 = ((Field) objAccessartificialFrame45).get(inputStream3);
                                                                                                                                                    try {
                                                                                                                                                        Object[] objArr113 = {Integer.valueOf(iIntValue3), inputStream3};
                                                                                                                                                        Object objAccessartificialFrame46 = ArtificialStackFrames.accessartificialFrame(-729892777);
                                                                                                                                                        if (objAccessartificialFrame46 == null) {
                                                                                                                                                            objAccessartificialFrame46 = ArtificialStackFrames.coroutineCreation(24 - TextUtils.getTrimmedLength(""), (char) (53250 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1))), 124 - View.getDefaultSize(0, 0), 1260125791, false, "ArtificialStackFrames", new Class[]{Integer.TYPE, InputStream.class});
                                                                                                                                                        }
                                                                                                                                                        Object objInvoke18 = ((Method) objAccessartificialFrame46).invoke(obj21, objArr113);
                                                                                                                                                        Object objAccessartificialFrame47 = ArtificialStackFrames.accessartificialFrame(-1239553844);
                                                                                                                                                        if (objAccessartificialFrame47 == null) {
                                                                                                                                                            objAccessartificialFrame47 = ArtificialStackFrames.coroutineCreation(TextUtils.getOffsetBefore("", 0) + 24, (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16), MotionEvent.axisFromString("") + 387, 695774916, false, "MediaMetadataCompatBitmapKey", null);
                                                                                                                                                        }
                                                                                                                                                        try {
                                                                                                                                                            Object[] objArr114 = {((Field) objAccessartificialFrame47).get(inputStream3)};
                                                                                                                                                            Object objAccessartificialFrame48 = ArtificialStackFrames.accessartificialFrame(1328317403);
                                                                                                                                                            if (objAccessartificialFrame48 == null) {
                                                                                                                                                                objAccessartificialFrame48 = ArtificialStackFrames.coroutineCreation(TextUtils.indexOf("", "", 0) + 14, (char) TextUtils.getTrimmedLength(""), 2753 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), -800471597, false, "ArtificialStackFrames", new Class[]{(Class) ArtificialStackFrames.coroutineCreation(24 - ((Process.getThreadPriority(0) + 20) >> 6), (char) (53250 - (ViewConfiguration.getFadingEdgeLength() >> 16)), 124 - TextUtils.indexOf("", ""))});
                                                                                                                                                            }
                                                                                                                                                            Object objInvoke19 = ((Method) objAccessartificialFrame48).invoke(objInvoke17, objArr114);
                                                                                                                                                            try {
                                                                                                                                                                Object[] objArr115 = {objInvoke17, objInvoke18};
                                                                                                                                                                Object objAccessartificialFrame49 = ArtificialStackFrames.accessartificialFrame(1176953419);
                                                                                                                                                                if (objAccessartificialFrame49 == null) {
                                                                                                                                                                    objAccessartificialFrame49 = ArtificialStackFrames.coroutineCreation(16 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), (char) (1 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))), 343 - Color.red(0), -649878461, false, "accessartificialFrame", new Class[]{(Class) ArtificialStackFrames.coroutineCreation(14 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), (char) (1 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1))), 2753 - Gravity.getAbsoluteGravity(0, 0)), byte[].class});
                                                                                                                                                                }
                                                                                                                                                                Object objInvoke20 = ((Method) objAccessartificialFrame49).invoke(objInvoke19, objArr115);
                                                                                                                                                                try {
                                                                                                                                                                    inputStream3.close();
                                                                                                                                                                } catch (IOException unused8) {
                                                                                                                                                                }
                                                                                                                                                                obj4 = objInvoke20;
                                                                                                                                                            } catch (Throwable th30) {
                                                                                                                                                                Throwable cause16 = th30.getCause();
                                                                                                                                                                if (cause16 != null) {
                                                                                                                                                                    throw cause16;
                                                                                                                                                                }
                                                                                                                                                                throw th30;
                                                                                                                                                            }
                                                                                                                                                        } catch (Throwable th31) {
                                                                                                                                                            Throwable cause17 = th31.getCause();
                                                                                                                                                            if (cause17 != null) {
                                                                                                                                                                throw cause17;
                                                                                                                                                            }
                                                                                                                                                            throw th31;
                                                                                                                                                        }
                                                                                                                                                    } catch (Throwable th32) {
                                                                                                                                                        Throwable cause18 = th32.getCause();
                                                                                                                                                        if (cause18 != null) {
                                                                                                                                                            throw cause18;
                                                                                                                                                        }
                                                                                                                                                        throw th32;
                                                                                                                                                    }
                                                                                                                                                } catch (Throwable th33) {
                                                                                                                                                    Throwable cause19 = th33.getCause();
                                                                                                                                                    if (cause19 != null) {
                                                                                                                                                        throw cause19;
                                                                                                                                                    }
                                                                                                                                                    throw th33;
                                                                                                                                                }
                                                                                                                                            } catch (Throwable th34) {
                                                                                                                                                Throwable cause20 = th34.getCause();
                                                                                                                                                if (cause20 != null) {
                                                                                                                                                    throw cause20;
                                                                                                                                                }
                                                                                                                                                throw th34;
                                                                                                                                            }
                                                                                                                                        } catch (Throwable th35) {
                                                                                                                                            try {
                                                                                                                                                inputStream3.close();
                                                                                                                                                throw th35;
                                                                                                                                            } catch (IOException unused9) {
                                                                                                                                                throw th35;
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    } catch (Exception e4) {
                                                                                                                                        try {
                                                                                                                                            try {
                                                                                                                                                Object[] objArr116 = {e4};
                                                                                                                                                Object objAccessartificialFrame50 = ArtificialStackFrames.accessartificialFrame(534109792);
                                                                                                                                                if (objAccessartificialFrame50 == null) {
                                                                                                                                                    objAccessartificialFrame50 = ArtificialStackFrames.coroutineCreation(28 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)), (char) (ViewConfiguration.getPressedStateDuration() >> 16), 358 - (Process.myTid() >> 22), -2135910296, false, null, new Class[]{Throwable.class});
                                                                                                                                                }
                                                                                                                                                throw ((Throwable) ((Constructor) objAccessartificialFrame50).newInstance(objArr116));
                                                                                                                                            } catch (Throwable th36) {
                                                                                                                                                Throwable cause21 = th36.getCause();
                                                                                                                                                if (cause21 != null) {
                                                                                                                                                    throw cause21;
                                                                                                                                                }
                                                                                                                                                throw th36;
                                                                                                                                            }
                                                                                                                                        } catch (Exception e5) {
                                                                                                                                            try {
                                                                                                                                                Object[] objArr117 = {e5};
                                                                                                                                                Object objAccessartificialFrame51 = ArtificialStackFrames.accessartificialFrame(534109792);
                                                                                                                                                if (objAccessartificialFrame51 == null) {
                                                                                                                                                    objAccessartificialFrame51 = ArtificialStackFrames.coroutineCreation(28 - (ViewConfiguration.getJumpTapTimeout() >> 16), (char) Drawable.resolveOpacity(0, 0), TextUtils.lastIndexOf("", '0', 0) + 359, -2135910296, false, null, new Class[]{Throwable.class});
                                                                                                                                                }
                                                                                                                                                throw ((Throwable) ((Constructor) objAccessartificialFrame51).newInstance(objArr117));
                                                                                                                                            } catch (Throwable th37) {
                                                                                                                                                Throwable cause22 = th37.getCause();
                                                                                                                                                if (cause22 != null) {
                                                                                                                                                    throw cause22;
                                                                                                                                                }
                                                                                                                                                throw th37;
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                } catch (Throwable th38) {
                                                                                                                                    Throwable cause23 = th38.getCause();
                                                                                                                                    if (cause23 != null) {
                                                                                                                                        throw cause23;
                                                                                                                                    }
                                                                                                                                    throw th38;
                                                                                                                                }
                                                                                                                            }
                                                                                                                            Object objAccessartificialFrame52 = ArtificialStackFrames.accessartificialFrame(-2134990334);
                                                                                                                            if (objAccessartificialFrame52 == null) {
                                                                                                                                objAccessartificialFrame52 = ArtificialStackFrames.coroutineCreation(TextUtils.indexOf((CharSequence) "", '0') + 23, (char) (ViewConfiguration.getLongPressTimeout() >> 16), (ViewConfiguration.getTouchSlop() >> 8) + 3982, 534504458, false, "e", null);
                                                                                                                            }
                                                                                                                            byte[] bArr7 = (byte[]) ((Field) objAccessartificialFrame52).get(obj4);
                                                                                                                            Object objAccessartificialFrame53 = ArtificialStackFrames.accessartificialFrame(-2134990334);
                                                                                                                            if (objAccessartificialFrame53 == null) {
                                                                                                                                objAccessartificialFrame53 = ArtificialStackFrames.coroutineCreation(TextUtils.indexOf("", "", 0) + 22, (char) (ViewConfiguration.getLongPressTimeout() >> 16), 3982 - TextUtils.indexOf("", "", 0), 534504458, false, "e", null);
                                                                                                                            }
                                                                                                                            try {
                                                                                                                                Object[] objArr118 = {objNewInstance2, Arrays.copyOf(bArr7, ((byte[]) ((Field) objAccessartificialFrame53).get(obj4)).length)};
                                                                                                                                Object objAccessartificialFrame54 = ArtificialStackFrames.accessartificialFrame(1094878374);
                                                                                                                                if (objAccessartificialFrame54 == null) {
                                                                                                                                    objAccessartificialFrame54 = ArtificialStackFrames.coroutineCreation(TextUtils.getTrimmedLength("") + 24, (char) Color.blue(0), (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 385, -567819602, false, null, new Class[]{(Class) ArtificialStackFrames.coroutineCreation(View.MeasureSpec.makeMeasureSpec(0, 0) + 24, (char) (TextUtils.lastIndexOf("", '0', 0, 0) + 53251), TextUtils.getCapsMode("", 0, 0) + 124), byte[].class});
                                                                                                                                }
                                                                                                                                InputStream inputStream4 = (InputStream) ((Constructor) objAccessartificialFrame54).newInstance(objArr118);
                                                                                                                                try {
                                                                                                                                    Object objAccessartificialFrame55 = ArtificialStackFrames.accessartificialFrame(-1239553844);
                                                                                                                                    if (objAccessartificialFrame55 == null) {
                                                                                                                                        objAccessartificialFrame55 = ArtificialStackFrames.coroutineCreation((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 23, (char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) - 1), (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 385, 695774916, false, "MediaMetadataCompatBitmapKey", null);
                                                                                                                                    }
                                                                                                                                    Object obj22 = ((Field) objAccessartificialFrame55).get(inputStream4);
                                                                                                                                    try {
                                                                                                                                        Object[] objArr119 = {inputStream4};
                                                                                                                                        Object objAccessartificialFrame56 = ArtificialStackFrames.accessartificialFrame(1296960672);
                                                                                                                                        if (objAccessartificialFrame56 == null) {
                                                                                                                                            objAccessartificialFrame56 = ArtificialStackFrames.coroutineCreation((CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + 24, (char) ((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 53250), (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 123, -768914776, false, "coroutineBoundary", new Class[]{InputStream.class});
                                                                                                                                        }
                                                                                                                                        Object objInvoke21 = ((Method) objAccessartificialFrame56).invoke(obj22, objArr119);
                                                                                                                                        Object objAccessartificialFrame57 = ArtificialStackFrames.accessartificialFrame(-1239553844);
                                                                                                                                        if (objAccessartificialFrame57 == null) {
                                                                                                                                            objAccessartificialFrame57 = ArtificialStackFrames.coroutineCreation(24 - (ViewConfiguration.getDoubleTapTimeout() >> 16), (char) (ViewConfiguration.getKeyRepeatDelay() >> 16), (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 386, 695774916, false, "MediaMetadataCompatBitmapKey", null);
                                                                                                                                        }
                                                                                                                                        Object obj23 = ((Field) objAccessartificialFrame57).get(inputStream4);
                                                                                                                                        try {
                                                                                                                                            Object[] objArr120 = {inputStream4};
                                                                                                                                            Object objAccessartificialFrame58 = ArtificialStackFrames.accessartificialFrame(-119044754);
                                                                                                                                            if (objAccessartificialFrame58 == null) {
                                                                                                                                                objAccessartificialFrame58 = ArtificialStackFrames.coroutineCreation((-16777192) - Color.rgb(0, 0, 0), (char) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 53249), 124 - (Process.myPid() >> 22), 1736622950, false, "ArtificialStackFrames", new Class[]{InputStream.class});
                                                                                                                                            }
                                                                                                                                            int iIntValue4 = ((Integer) ((Method) objAccessartificialFrame58).invoke(obj23, objArr120)).intValue();
                                                                                                                                            Object objAccessartificialFrame59 = ArtificialStackFrames.accessartificialFrame(-1239553844);
                                                                                                                                            if (objAccessartificialFrame59 == null) {
                                                                                                                                                objAccessartificialFrame59 = ArtificialStackFrames.coroutineCreation(24 - ExpandableListView.getPackedPositionGroup(0L), (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16), View.resolveSize(0, 0) + 386, 695774916, false, "MediaMetadataCompatBitmapKey", null);
                                                                                                                                            }
                                                                                                                                            Object obj24 = ((Field) objAccessartificialFrame59).get(inputStream4);
                                                                                                                                            try {
                                                                                                                                                Object[] objArr121 = {Integer.valueOf(iIntValue4), inputStream4};
                                                                                                                                                Object objAccessartificialFrame60 = ArtificialStackFrames.accessartificialFrame(-729892777);
                                                                                                                                                if (objAccessartificialFrame60 == null) {
                                                                                                                                                    objAccessartificialFrame60 = ArtificialStackFrames.coroutineCreation(24 - ((Process.getThreadPriority(0) + 20) >> 6), (char) (53251 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))), (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 124, 1260125791, false, "ArtificialStackFrames", new Class[]{Integer.TYPE, InputStream.class});
                                                                                                                                                }
                                                                                                                                                Object objInvoke22 = ((Method) objAccessartificialFrame60).invoke(obj24, objArr121);
                                                                                                                                                Object objAccessartificialFrame61 = ArtificialStackFrames.accessartificialFrame(-1239553844);
                                                                                                                                                if (objAccessartificialFrame61 == null) {
                                                                                                                                                    objAccessartificialFrame61 = ArtificialStackFrames.coroutineCreation(TextUtils.getOffsetBefore("", 0) + 24, (char) TextUtils.getOffsetBefore("", 0), 386 - (ViewConfiguration.getScrollBarSize() >> 8), 695774916, false, "MediaMetadataCompatBitmapKey", null);
                                                                                                                                                }
                                                                                                                                                try {
                                                                                                                                                    Object[] objArr122 = {((Field) objAccessartificialFrame61).get(inputStream4)};
                                                                                                                                                    Object objAccessartificialFrame62 = ArtificialStackFrames.accessartificialFrame(1328317403);
                                                                                                                                                    if (objAccessartificialFrame62 == null) {
                                                                                                                                                        objAccessartificialFrame62 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 14, (char) View.MeasureSpec.makeMeasureSpec(0, 0), (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 2752, -800471597, false, "ArtificialStackFrames", new Class[]{(Class) ArtificialStackFrames.coroutineCreation(25 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), (char) (53251 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))), (ViewConfiguration.getLongPressTimeout() >> 16) + 124)});
                                                                                                                                                    }
                                                                                                                                                    Object objInvoke23 = ((Method) objAccessartificialFrame62).invoke(objInvoke21, objArr122);
                                                                                                                                                    try {
                                                                                                                                                        Object[] objArr123 = {objInvoke21, objInvoke22};
                                                                                                                                                        Object objAccessartificialFrame63 = ArtificialStackFrames.accessartificialFrame(1176953419);
                                                                                                                                                        if (objAccessartificialFrame63 == null) {
                                                                                                                                                            objAccessartificialFrame63 = ArtificialStackFrames.coroutineCreation(15 - (KeyEvent.getMaxKeyCode() >> 16), (char) (ViewConfiguration.getLongPressTimeout() >> 16), (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 343, -649878461, false, "accessartificialFrame", new Class[]{(Class) ArtificialStackFrames.coroutineCreation(14 - Color.blue(0), (char) Color.argb(0, 0, 0, 0), 2753 - KeyEvent.normalizeMetaState(0)), byte[].class});
                                                                                                                                                        }
                                                                                                                                                        objInvoke16 = ((Method) objAccessartificialFrame63).invoke(objInvoke23, objArr123);
                                                                                                                                                        inputStream4.close();
                                                                                                                                                        break;
                                                                                                                                                    } catch (Throwable th39) {
                                                                                                                                                        Throwable cause24 = th39.getCause();
                                                                                                                                                        if (cause24 != null) {
                                                                                                                                                            throw cause24;
                                                                                                                                                        }
                                                                                                                                                        throw th39;
                                                                                                                                                    }
                                                                                                                                                } catch (Throwable th40) {
                                                                                                                                                    Throwable cause25 = th40.getCause();
                                                                                                                                                    if (cause25 != null) {
                                                                                                                                                        throw cause25;
                                                                                                                                                    }
                                                                                                                                                    throw th40;
                                                                                                                                                }
                                                                                                                                            } catch (Throwable th41) {
                                                                                                                                                Throwable cause26 = th41.getCause();
                                                                                                                                                if (cause26 != null) {
                                                                                                                                                    throw cause26;
                                                                                                                                                }
                                                                                                                                                throw th41;
                                                                                                                                            }
                                                                                                                                        } catch (Throwable th42) {
                                                                                                                                            Throwable cause27 = th42.getCause();
                                                                                                                                            if (cause27 != null) {
                                                                                                                                                throw cause27;
                                                                                                                                            }
                                                                                                                                            throw th42;
                                                                                                                                        }
                                                                                                                                    } catch (Throwable th43) {
                                                                                                                                        Throwable cause28 = th43.getCause();
                                                                                                                                        if (cause28 != null) {
                                                                                                                                            throw cause28;
                                                                                                                                        }
                                                                                                                                        throw th43;
                                                                                                                                    }
                                                                                                                                } catch (Exception e6) {
                                                                                                                                    try {
                                                                                                                                        Object[] objArr124 = {e6};
                                                                                                                                        Object objAccessartificialFrame64 = ArtificialStackFrames.accessartificialFrame(534109792);
                                                                                                                                        if (objAccessartificialFrame64 == null) {
                                                                                                                                            objAccessartificialFrame64 = ArtificialStackFrames.coroutineCreation(Color.argb(0, 0, 0, 0) + 28, (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), 358 - (ViewConfiguration.getTapTimeout() >> 16), -2135910296, false, null, new Class[]{Throwable.class});
                                                                                                                                        }
                                                                                                                                        throw ((Throwable) ((Constructor) objAccessartificialFrame64).newInstance(objArr124));
                                                                                                                                    } catch (Throwable th44) {
                                                                                                                                        Throwable cause29 = th44.getCause();
                                                                                                                                        if (cause29 != null) {
                                                                                                                                            throw cause29;
                                                                                                                                        }
                                                                                                                                        throw th44;
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            } catch (Throwable th45) {
                                                                                                                                Throwable cause30 = th45.getCause();
                                                                                                                                if (cause30 != null) {
                                                                                                                                    throw cause30;
                                                                                                                                }
                                                                                                                                throw th45;
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                    if (objInvoke16 != null) {
                                                                                                                        break;
                                                                                                                    }
                                                                                                                    i418++;
                                                                                                                    objArr109 = objArr109;
                                                                                                                }
                                                                                                                if (objInvoke16 == null) {
                                                                                                                    listEmptyList = Collections.emptyList();
                                                                                                                    break;
                                                                                                                }
                                                                                                                Object objAccessartificialFrame65 = ArtificialStackFrames.accessartificialFrame(-1944720953);
                                                                                                                if (objAccessartificialFrame65 == null) {
                                                                                                                    objAccessartificialFrame65 = ArtificialStackFrames.coroutineCreation(ExpandableListView.getPackedPositionChild(0L) + 21, (char) View.resolveSizeAndState(0, 0, 0), KeyEvent.normalizeMetaState(0) + 3316, 326152143, false, "b", null);
                                                                                                                }
                                                                                                                Object obj25 = ((List) ((Field) objAccessartificialFrame65).get(objInvoke16)).get(1);
                                                                                                                try {
                                                                                                                    Object objAccessartificialFrame66 = ArtificialStackFrames.accessartificialFrame(1548792202);
                                                                                                                    if (objAccessartificialFrame66 == null) {
                                                                                                                        objAccessartificialFrame66 = ArtificialStackFrames.coroutineCreation(TextUtils.getCapsMode("", 0, 0) + 10, (char) (ViewConfiguration.getEdgeSlop() >> 16), 2694 - TextUtils.getOffsetAfter("", 0), -1019873406, false, "sendCustomAction", new Class[0]);
                                                                                                                    }
                                                                                                                    Set set = (Set) ((Method) objAccessartificialFrame66).invoke(obj25, null);
                                                                                                                    ArrayList arrayList3 = new ArrayList(set.size());
                                                                                                                    for (Object obj26 : set) {
                                                                                                                        Object objAccessartificialFrame67 = ArtificialStackFrames.accessartificialFrame(-2134990334);
                                                                                                                        if (objAccessartificialFrame67 == null) {
                                                                                                                            objAccessartificialFrame67 = ArtificialStackFrames.coroutineCreation(KeyEvent.normalizeMetaState(0) + 22, (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16), ExpandableListView.getPackedPositionChild(0L) + 3983, 534504458, false, "e", null);
                                                                                                                        }
                                                                                                                        byte[] bArr8 = (byte[]) ((Field) objAccessartificialFrame67).get(obj26);
                                                                                                                        Object objAccessartificialFrame68 = ArtificialStackFrames.accessartificialFrame(-2134990334);
                                                                                                                        if (objAccessartificialFrame68 == null) {
                                                                                                                            objAccessartificialFrame68 = ArtificialStackFrames.coroutineCreation(23 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), (char) (1 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1))), 3982 - Color.alpha(0), 534504458, false, "e", null);
                                                                                                                        }
                                                                                                                        arrayList3.add(Arrays.copyOf(bArr8, ((byte[]) ((Field) objAccessartificialFrame68).get(obj26)).length));
                                                                                                                    }
                                                                                                                    listEmptyList = arrayList3;
                                                                                                                    r16 = r15;
                                                                                                                    r24 = r23;
                                                                                                                    break;
                                                                                                                } catch (Throwable th46) {
                                                                                                                    Throwable cause31 = th46.getCause();
                                                                                                                    if (cause31 != null) {
                                                                                                                        throw cause31;
                                                                                                                    }
                                                                                                                    throw th46;
                                                                                                                }
                                                                                                            } catch (Throwable th47) {
                                                                                                                Throwable cause32 = th47.getCause();
                                                                                                                if (cause32 != null) {
                                                                                                                    throw cause32;
                                                                                                                }
                                                                                                                throw th47;
                                                                                                            }
                                                                                                        } catch (Throwable th48) {
                                                                                                            Throwable cause33 = th48.getCause();
                                                                                                            if (cause33 != null) {
                                                                                                                throw cause33;
                                                                                                            }
                                                                                                            throw th48;
                                                                                                        }
                                                                                                    } catch (Throwable th49) {
                                                                                                        Throwable cause34 = th49.getCause();
                                                                                                        if (cause34 != null) {
                                                                                                            throw cause34;
                                                                                                        }
                                                                                                        throw th49;
                                                                                                    }
                                                                                                } catch (Throwable th50) {
                                                                                                    Throwable cause35 = th50.getCause();
                                                                                                    if (cause35 != null) {
                                                                                                        throw cause35;
                                                                                                    }
                                                                                                    throw th50;
                                                                                                }
                                                                                            } catch (Throwable th51) {
                                                                                                Throwable cause36 = th51.getCause();
                                                                                                if (cause36 != null) {
                                                                                                    throw cause36;
                                                                                                }
                                                                                                throw th51;
                                                                                            }
                                                                                        } catch (Exception e7) {
                                                                                            try {
                                                                                                Object[] objArr125 = {e7};
                                                                                                Object objAccessartificialFrame69 = ArtificialStackFrames.accessartificialFrame(534109792);
                                                                                                if (objAccessartificialFrame69 == null) {
                                                                                                    objAccessartificialFrame69 = ArtificialStackFrames.coroutineCreation(28 - TextUtils.getOffsetAfter("", 0), (char) View.getDefaultSize(0, 0), (ViewConfiguration.getFadingEdgeLength() >> 16) + 358, -2135910296, false, null, new Class[]{Throwable.class});
                                                                                                }
                                                                                                throw ((Throwable) ((Constructor) objAccessartificialFrame69).newInstance(objArr125));
                                                                                            } catch (Throwable th52) {
                                                                                                Throwable cause37 = th52.getCause();
                                                                                                if (cause37 != null) {
                                                                                                    throw cause37;
                                                                                                }
                                                                                                throw th52;
                                                                                            }
                                                                                        }
                                                                                    } catch (Throwable th53) {
                                                                                        Throwable cause38 = th53.getCause();
                                                                                        if (cause38 != null) {
                                                                                            throw cause38;
                                                                                        }
                                                                                        throw th53;
                                                                                    }
                                                                                } catch (Throwable th54) {
                                                                                    Throwable cause39 = th54.getCause();
                                                                                    if (cause39 != null) {
                                                                                        throw cause39;
                                                                                    }
                                                                                    throw th54;
                                                                                }
                                                                            } catch (Throwable th55) {
                                                                                Throwable cause40 = th55.getCause();
                                                                                if (cause40 != null) {
                                                                                    throw cause40;
                                                                                }
                                                                                throw th55;
                                                                            }
                                                                        } catch (Throwable th56) {
                                                                            Throwable cause41 = th56.getCause();
                                                                            if (cause41 != null) {
                                                                                throw cause41;
                                                                            }
                                                                            throw th56;
                                                                        }
                                                                    } catch (Throwable th57) {
                                                                        Throwable cause42 = th57.getCause();
                                                                        if (cause42 != null) {
                                                                            throw cause42;
                                                                        }
                                                                        throw th57;
                                                                    }
                                                                } catch (Throwable th58) {
                                                                    Throwable cause43 = th58.getCause();
                                                                    if (cause43 != null) {
                                                                        throw cause43;
                                                                    }
                                                                    throw th58;
                                                                }
                                                            } catch (Exception e8) {
                                                                try {
                                                                    Object[] objArr126 = {e8};
                                                                    Object objAccessartificialFrame70 = ArtificialStackFrames.accessartificialFrame(534109792);
                                                                    if (objAccessartificialFrame70 == null) {
                                                                        objAccessartificialFrame70 = ArtificialStackFrames.coroutineCreation(28 - (ViewConfiguration.getPressedStateDuration() >> 16), (char) Color.alpha(0), 358 - ExpandableListView.getPackedPositionGroup(0L), -2135910296, false, null, new Class[]{Throwable.class});
                                                                    }
                                                                    throw ((Throwable) ((Constructor) objAccessartificialFrame70).newInstance(objArr126));
                                                                } catch (Throwable th59) {
                                                                    Throwable cause44 = th59.getCause();
                                                                    if (cause44 != null) {
                                                                        throw cause44;
                                                                    }
                                                                    throw th59;
                                                                }
                                                            }
                                                        } catch (Throwable th60) {
                                                            Throwable cause45 = th60.getCause();
                                                            if (cause45 != null) {
                                                                throw cause45;
                                                            }
                                                            throw th60;
                                                        }
                                                    }
                                                    int i421 = (size2 ^ 5) + ((size2 & 5) << 1);
                                                    size2 = (i421 ^ (-6)) + ((i421 & (-6)) << 1);
                                                } catch (Throwable th61) {
                                                    Throwable cause46 = th61.getCause();
                                                    if (cause46 != null) {
                                                        throw cause46;
                                                    }
                                                    throw th61;
                                                }
                                            }
                                        } catch (Throwable th62) {
                                            Throwable cause47 = th62.getCause();
                                            if (cause47 != null) {
                                                throw cause47;
                                            }
                                            throw th62;
                                        }
                                    } catch (Exception unused10) {
                                        listEmptyList = null;
                                        r16 = r15;
                                        r24 = r23;
                                        break;
                                    }
                                } catch (Exception unused11) {
                                    r15 = i;
                                    r23 = r20;
                                }
                                if (listEmptyList != null || listEmptyList.isEmpty()) {
                                    r16 = r15;
                                    r24 = r23;
                                    r16 = r15;
                                    r24 = r23;
                                    r17 = r24;
                                } else {
                                    r16 = r15;
                                    r24 = r23;
                                    int size3 = listEmptyList.size();
                                    Object[] objArr127 = new Object[1];
                                    a(new byte[]{0, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1}, new int[]{0, 19, 0, 17}, false, objArr127);
                                    ?? r22 = (LongBuffer[]) Array.newInstance(Class.forName((String) objArr127[0]), size3);
                                    int i422 = 0;
                                    while (i422 < listEmptyList.size()) {
                                        Object[] objArr128 = {(byte[]) listEmptyList.get(i422)};
                                        Class<?> cls24 = Class.forName(str10);
                                        int i423 = -(ViewConfiguration.getScrollDefaultDelay() >> 16);
                                        Object[] objArr129 = new Object[1];
                                        c((i423 & 4) + (i423 | 4), new int[]{1799158074, -1917480941}, objArr129);
                                        Object objInvoke24 = cls24.getMethod((String) objArr129[0], byte[].class).invoke(null, objArr128);
                                        Class<?> cls25 = Class.forName(str10);
                                        int i424 = (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1));
                                        Object[] objArr130 = new Object[1];
                                        c((i424 & 12) + (i424 | 12), new int[]{2143351903, -982766959, -1780750661, -446571346, -967477501, 352953536}, objArr130);
                                        r22[i422] = cls25.getMethod((String) objArr130[0], null).invoke(objInvoke24, null);
                                        int i425 = (i422 & b.l) + (i422 | b.l);
                                        i422 = ((i425 | (-105)) << 1) - (i425 ^ (-105));
                                    }
                                    r19 = r24;
                                    boolean z2 = false;
                                    for (?? r27 : r19) {
                                        r27.rewind();
                                        boolean z3 = z2;
                                        for (?? r0 : r22) {
                                            if (!(!r27.equals(r0.rewind()))) {
                                                z3 = true;
                                            }
                                            r27.rewind();
                                            if (!(!z3)) {
                                                break;
                                            }
                                        }
                                        z2 = z3;
                                    }
                                    if (z2) {
                                        r17 = r19;
                                    } else {
                                        int length9 = r22.length;
                                        String string5 = "";
                                        int i426 = 0;
                                        while (i426 < length9) {
                                            ?? r28 = r2[i426];
                                            r28.rewind();
                                            StringBuilder sb2 = new StringBuilder();
                                            sb2.append(string5);
                                            if (r28 != 0) {
                                                r2 = r22;
                                                Lists.TransformingRandomAccessList.AnonymousClass1.IPostMessageService();
                                                Lists.TransformingRandomAccessList.AnonymousClass1.IPostMessageService();
                                                string2 = "";
                                                int i427 = 0;
                                                ?? r29 = r2;
                                                while (true) {
                                                    int i428 = -(SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1));
                                                    Object[] objArr131 = new Object[1];
                                                    c(((i428 | 16) << 1) - (i428 ^ 16), new int[]{-1126508594, -1707955208, -1985443438, 137225525, 1597574327, 2041802794, -1595502793, 1282537579}, objArr131);
                                                    Class<?> cls26 = Class.forName((String) objArr131[0]);
                                                    i41 = length9;
                                                    r25 = r29;
                                                    Object[] objArr132 = new Object[1];
                                                    a(new byte[]{1, 1, 0, 0, 1}, new int[]{170, 5, 43, 0}, true, objArr132);
                                                    if (i427 >= ((Integer) cls26.getMethod((String) objArr132[0], null).invoke(r28, null)).intValue()) {
                                                        break;
                                                    }
                                                    StringBuilder sb3 = new StringBuilder();
                                                    sb3.append(string2);
                                                    Object[] objArr133 = {Integer.valueOf(i427)};
                                                    Object[] objArr134 = new Object[1];
                                                    a(new byte[]{0, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1}, new int[]{0, 19, 0, 17}, false, objArr134);
                                                    String str15 = (String) objArr134[0];
                                                    int i429 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                                    int i430 = (i429 & 67) + (i429 | 67);
                                                    artificialFrame = i430 % 128;
                                                    int i431 = i430 % 2;
                                                    Class<?> cls27 = Class.forName(str15);
                                                    int i432 = -AndroidCharacter.getMirror('0');
                                                    int iIPostMessageService13 = Lists.TransformingRandomAccessList.AnonymousClass1.IPostMessageService();
                                                    int i433 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                                    int i434 = ((i433 | 53) << 1) - (i433 ^ 53);
                                                    int i435 = i434 % 128;
                                                    artificialFrame = i435;
                                                    if (i434 % 2 == 0) {
                                                        i42 = ((-830) >> i432) >>> 42432;
                                                    } else {
                                                        int i436 = i432 * (-830);
                                                        i42 = (i436 ^ 42432) + ((i436 & 42432) << 1);
                                                    }
                                                    int i437 = i42;
                                                    int i438 = ~((-52) | (~iIPostMessageService13));
                                                    int i439 = (i432 ^ 51) | (i432 & 51);
                                                    String str16 = str7;
                                                    int i440 = ~((i439 ^ iIPostMessageService13) | (i439 & iIPostMessageService13));
                                                    int i441 = (-831) * ((i438 ^ i440) | (i440 & i438));
                                                    int i442 = (i437 & i441) + (i437 | i441);
                                                    int i443 = (~((-52) | i432 | iIPostMessageService13)) * (-1662);
                                                    int i444 = (i442 ^ i443) + ((i442 & i443) << 1);
                                                    int i445 = ~i432;
                                                    int i446 = i435 + 51;
                                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i446 % 128;
                                                    int i447 = i446 % 2;
                                                    int i448 = ~iIPostMessageService13;
                                                    int i449 = ~((i445 & i448) | (i445 ^ i448));
                                                    int i450 = ~(i432 | iIPostMessageService13);
                                                    int i451 = (i449 & i450) | (i449 ^ i450);
                                                    int i452 = ~((51 & iIPostMessageService13) | (51 ^ iIPostMessageService13));
                                                    Object[] objArr135 = new Object[1];
                                                    c(i444 + (((i451 & i452) | (i451 ^ i452)) * 831), new int[]{1308963368, -547684839}, objArr135);
                                                    Object[] objArr136 = {Long.valueOf(((Long) cls27.getMethod((String) objArr135[0], Integer.TYPE).invoke(r28, objArr133)).longValue())};
                                                    int i453 = -(-TextUtils.lastIndexOf("", '0', 0));
                                                    Object[] objArr137 = new Object[1];
                                                    c(((i453 | 15) << 1) - (i453 ^ 15), new int[]{-1126508594, -1707955208, -856323126, 2122573174, -2076996192, -1835679048, 1552917501, 2030585986}, objArr137);
                                                    Class<?> cls28 = Class.forName((String) objArr137[0]);
                                                    Object[] objArr138 = new Object[1];
                                                    a(new byte[]{1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1}, new int[]{175, 11, 0, 0}, true, objArr138);
                                                    sb3.append((String) cls28.getMethod((String) objArr138[0], Long.TYPE).invoke(null, objArr136));
                                                    string2 = sb3.toString();
                                                    int i454 = (i427 & AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY) + (i427 | AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY);
                                                    i427 = ((i454 | (-108)) << 1) - (i454 ^ (-108));
                                                    length9 = i41;
                                                    r29 = r25;
                                                    str7 = str16;
                                                }
                                                str6 = str7;
                                            } else {
                                                r2 = r22;
                                                i41 = length9;
                                                r25 = r2;
                                                str6 = str7;
                                                string2 = "";
                                            }
                                            sb2.append(string2);
                                            String string6 = sb2.toString();
                                            StringBuilder sb4 = new StringBuilder();
                                            sb4.append(string6);
                                            Object[] objArr139 = new Object[1];
                                            c(0 - (~(-(-View.resolveSize(0, 0)))), new int[]{-935572927, 1331556816}, objArr139);
                                            sb4.append((String) objArr139[0]);
                                            string5 = sb4.toString();
                                            i426++;
                                            length9 = i41;
                                            r2 = r25;
                                            str7 = str6;
                                        }
                                        r2 = r22;
                                        str7 = str7;
                                        strSubstring = "".equals(string5) ? string5 : string5.substring(0, string5.length() - 1);
                                    }
                                    if (strSubstring == null) {
                                        r18 = r19;
                                        r18 = r19;
                                        i39 = r16 == true ? 1 : 0;
                                    } else {
                                        r18 = r19;
                                        r18 = r19;
                                        i39 = ((r16 == true ? 1 : 0) & (-6)) | ((~(r16 == true ? 1 : 0)) & 5);
                                    }
                                    if (strSubstring == null) {
                                        int i1910 = artificialFrame + 3;
                                        getARTIFICIAL_FRAME_PACKAGE_NAME = i1910 % 128;
                                        c2 = 2;
                                        int i1911 = i1910 % 2;
                                        i40 = 0;
                                    } else {
                                        c2 = 2;
                                        i40 = 16;
                                    }
                                    objArr8 = new Object[4];
                                    objArr8[0] = new int[]{i39};
                                    objArr8[c2] = new int[1];
                                    objArr8[3] = new int[]{r16 == true ? 1 : 0};
                                    int i1912 = (-1277967071) + ((1071251135 | (r16 == true ? 1 : 0)) * (-676));
                                    int i1913 = ~(r16 == true ? 1 : 0);
                                    int i1914 = i1912 + (((~(1054373563 | i1913)) | (-1071251136)) * 676) + (((~(i1913 | 894023837)) | 177227298 | (~((-16877573) | (r16 == true ? 1 : 0)))) * 676);
                                    int iIPostMessageService14 = Lists.TransformingRandomAccessList.AnonymousClass1.IPostMessageService();
                                    int i1915 = ((i40 * 673) - (~(-(-(i1914 * (-1343)))))) - 1;
                                    int i1916 = ~((i40 ^ iIPostMessageService14) | (i40 & iIPostMessageService14));
                                    int i2010 = -(-(((i1916 & i1914) | (i1914 ^ i1916)) * 672));
                                    int i2011 = (i1915 & i2010) + (i1915 | i2010);
                                    int i2012 = ~i40;
                                    int i2013 = ~iIPostMessageService14;
                                    int i2014 = ~((i2012 & i2013) | (i2012 ^ i2013));
                                    int i2015 = ~(iIPostMessageService14 | i1914);
                                    int i2016 = -(-(((i2015 & i2014) | (i2014 ^ i2015)) * (-672)));
                                    int i2017 = (i2011 ^ i2016) + ((i2016 & i2011) << 1);
                                    int i2018 = ~i1914;
                                    int i2019 = ~((i2018 & i2013) | (i2018 ^ i2013));
                                    int i2110 = ~i1914;
                                    int i2111 = ((~((i40 & i2110) | (i2110 ^ i40))) | i2019) * 672;
                                    int i2112 = ((i2017 | i2111) << 1) - (i2111 ^ i2017);
                                    i4 = i3;
                                    int i2113 = i2112 + i4;
                                    int i2114 = i2113 << 13;
                                    int i2115 = (i2113 | i2114) & (~(i2113 & i2114));
                                    int i2116 = i2115 >>> 17;
                                    int i2117 = ((~i2115) & i2116) | ((~i2116) & i2115);
                                    int i2118 = i2117 << 5;
                                    int i2119 = ((~i2117) & i2118) | ((~i2118) & i2117);
                                    int[] iArr5 = (int[]) objArr8[2];
                                    int i2210 = artificialFrame;
                                    int i2211 = ((i2210 | 3) << 1) - (i2210 ^ 3);
                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i2211 % 128;
                                    int i2212 = i2211 % 2;
                                    iArr5[0] = i2119;
                                    objArr8[1] = new String[]{strSubstring};
                                    objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(682069389);
                                    if (objAccessartificialFrame4 == null) {
                                        int scrollBarSize2 = (ViewConfiguration.getScrollBarSize() >> 8) + 21;
                                        char keyRepeatDelay2 = (char) (ViewConfiguration.getKeyRepeatDelay() >> 16);
                                        int iIndexOf3 = 465 - TextUtils.indexOf("", "", 0);
                                        byte[] bArr9 = $$a;
                                        byte b5 = (byte) (bArr9[13] - 1);
                                        Object[] objArr510 = new Object[1];
                                        b(b5, b5, bArr9[11], objArr510);
                                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(scrollBarSize2, keyRepeatDelay2, iIndexOf3, -1211970683, false, (String) objArr510[0], null);
                                    }
                                    ((Field) objAccessartificialFrame4).set(null, objArr8);
                                    if (r16 != i39) {
                                        return objArr8;
                                    }
                                    c = 0;
                                    i5 = 1;
                                    r9 = r18;
                                    r12 = r16;
                                }
                                strSubstring = null;
                                r18 = r17;
                                if (strSubstring == null) {
                                    r18 = r19;
                                    r18 = r19;
                                    i39 = r16 == true ? 1 : 0;
                                } else {
                                    r18 = r19;
                                    r18 = r19;
                                    i39 = ((r16 == true ? 1 : 0) & (-6)) | ((~(r16 == true ? 1 : 0)) & 5);
                                }
                                if (strSubstring == null) {
                                    int i1917 = artificialFrame + 3;
                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i1917 % 128;
                                    c2 = 2;
                                    int i1918 = i1917 % 2;
                                    i40 = 0;
                                } else {
                                    c2 = 2;
                                    i40 = 16;
                                }
                                objArr8 = new Object[4];
                                objArr8[0] = new int[]{i39};
                                objArr8[c2] = new int[1];
                                objArr8[3] = new int[]{r16 == true ? 1 : 0};
                                int i1919 = (-1277967071) + ((1071251135 | (r16 == true ? 1 : 0)) * (-676));
                                int i19110 = ~(r16 == true ? 1 : 0);
                                int i19111 = i1919 + (((~(1054373563 | i19110)) | (-1071251136)) * 676) + (((~(i19110 | 894023837)) | 177227298 | (~((-16877573) | (r16 == true ? 1 : 0)))) * 676);
                                int iIPostMessageService15 = Lists.TransformingRandomAccessList.AnonymousClass1.IPostMessageService();
                                int i19112 = ((i40 * 673) - (~(-(-(i19111 * (-1343)))))) - 1;
                                int i19113 = ~((i40 ^ iIPostMessageService15) | (i40 & iIPostMessageService15));
                                int i20110 = -(-(((i19113 & i19111) | (i19111 ^ i19113)) * 672));
                                int i20111 = (i19112 & i20110) + (i19112 | i20110);
                                int i20112 = ~i40;
                                int i20113 = ~iIPostMessageService15;
                                int i20114 = ~((i20112 & i20113) | (i20112 ^ i20113));
                                int i20115 = ~(iIPostMessageService15 | i19111);
                                int i20116 = -(-(((i20115 & i20114) | (i20114 ^ i20115)) * (-672)));
                                int i20117 = (i20111 ^ i20116) + ((i20116 & i20111) << 1);
                                int i20118 = ~i19111;
                                int i20119 = ~((i20118 & i20113) | (i20118 ^ i20113));
                                int i21110 = ~i19111;
                                int i21111 = ((~((i40 & i21110) | (i21110 ^ i40))) | i20119) * 672;
                                int i21112 = ((i20117 | i21111) << 1) - (i21111 ^ i20117);
                                i4 = i3;
                                int i21113 = i21112 + i4;
                                int i21114 = i21113 << 13;
                                int i21115 = (i21113 | i21114) & (~(i21113 & i21114));
                                int i21116 = i21115 >>> 17;
                                int i21117 = ((~i21115) & i21116) | ((~i21116) & i21115);
                                int i21118 = i21117 << 5;
                                int i21119 = ((~i21117) & i21118) | ((~i21118) & i21117);
                                int[] iArr6 = (int[]) objArr8[2];
                                int i2213 = artificialFrame;
                                int i2214 = ((i2213 | 3) << 1) - (i2213 ^ 3);
                                getARTIFICIAL_FRAME_PACKAGE_NAME = i2214 % 128;
                                int i2215 = i2214 % 2;
                                iArr6[0] = i21119;
                                objArr8[1] = new String[]{strSubstring};
                                objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(682069389);
                                if (objAccessartificialFrame4 == null) {
                                    int scrollBarSize3 = (ViewConfiguration.getScrollBarSize() >> 8) + 21;
                                    char keyRepeatDelay3 = (char) (ViewConfiguration.getKeyRepeatDelay() >> 16);
                                    int iIndexOf4 = 465 - TextUtils.indexOf("", "", 0);
                                    byte[] bArr10 = $$a;
                                    byte b6 = (byte) (bArr10[13] - 1);
                                    Object[] objArr511 = new Object[1];
                                    b(b6, b6, bArr10[11], objArr511);
                                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(scrollBarSize3, keyRepeatDelay3, iIndexOf4, -1211970683, false, (String) objArr511[0], null);
                                }
                                ((Field) objAccessartificialFrame4).set(null, objArr8);
                                if (r16 != i39) {
                                    return objArr8;
                                }
                                c = 0;
                                i5 = 1;
                                r9 = r18;
                                r12 = r16;
                            } catch (Throwable th63) {
                                Throwable cause48 = th63.getCause();
                                if (cause48 != null) {
                                    throw cause48;
                                }
                                throw th63;
                            }
                        } else {
                            r11 = i;
                            i4 = i3;
                            str7 = str7;
                            if (z) {
                                objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(682069389);
                                if (objAccessartificialFrame == null) {
                                    int maximumFlingVelocity2 = (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 21;
                                    char edgeSlop = (char) (ViewConfiguration.getEdgeSlop() >> 16);
                                    int scrollBarSize4 = (ViewConfiguration.getScrollBarSize() >> 8) + 465;
                                    byte[] bArr11 = $$a;
                                    byte b7 = (byte) (bArr11[13] - 1);
                                    Object[] objArr140 = new Object[1];
                                    b(b7, b7, bArr11[11], objArr140);
                                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(maximumFlingVelocity2, edgeSlop, scrollBarSize4, -1211970683, false, (String) objArr140[0], null);
                                }
                                i6 = ((int[]) ((Object[]) ((Field) objAccessartificialFrame).get(null))[3])[0];
                                objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(682069389);
                                if (objAccessartificialFrame2 == null) {
                                    int i455 = 22 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                                    char c5 = (char) (1 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)));
                                    int defaultSize2 = View.getDefaultSize(0, 0) + 465;
                                    byte[] bArr12 = $$a;
                                    byte b8 = (byte) (bArr12[13] - 1);
                                    Object[] objArr141 = new Object[1];
                                    b(b8, b8, bArr12[11], objArr141);
                                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(i455, c5, defaultSize2, -1211970683, false, (String) objArr141[0], null);
                                }
                                c = 0;
                                if (i6 != ((int[]) ((Object[]) ((Field) objAccessartificialFrame2).get(null))[0])[0]) {
                                    objArr = new Object[]{new int[]{(~((r11 == true ? 1 : 0) & 5)) & ((r11 == true ? 1 : 0) | 5)}, null, new int[1], new int[]{r11 == true ? 1 : 0}};
                                    int i456 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                    int i457 = (i456 ^ 61) + ((i456 & 61) << 1);
                                    artificialFrame = i457 % 128;
                                    int i458 = i457 % 2;
                                    int startElapsedRealtime3 = (int) Process.getStartElapsedRealtime();
                                    int i459 = ~startElapsedRealtime3;
                                    int i460 = ~(297002496 | i459);
                                    int i461 = 635444933 + (((-431482851) | i460) * (-712)) + (((~(startElapsedRealtime3 | (-134480355))) | (~(i459 | 431482850))) * (-712)) + ((136652770 | i460) * 712);
                                    int i462 = (i461 & 16) + (16 | i461);
                                    int iIPostMessageService16 = Lists.TransformingRandomAccessList.AnonymousClass1.IPostMessageService();
                                    int i463 = i462 * 829;
                                    int i464 = -(-(i4 * 829));
                                    int i465 = (i463 & i464) + (i463 | i464);
                                    int i466 = ~i462;
                                    int i467 = ~i4;
                                    int i468 = ~((i466 & i467) | (i466 ^ i467));
                                    int i469 = (~iIPostMessageService16) | i462;
                                    int i470 = (i465 - (~(-(-((i468 | (~((i469 & i4) | (i469 ^ i4)))) * (-828)))))) - 1;
                                    int i471 = i462 | i4;
                                    int i472 = ~iIPostMessageService16;
                                    int i473 = ((i470 + (((i472 & i471) | (i471 ^ i472)) * (-828))) - (~(-(-((~((i462 & i4) | (i462 ^ i4))) * 828))))) - 1;
                                    int i474 = i473 << 13;
                                    int i475 = (i474 | i473) & (~(i473 & i474));
                                    int i476 = i475 >>> 17;
                                    int i477 = (i475 | i476) & (~(i475 & i476));
                                    int i478 = i477 << 5;
                                    ((int[]) objArr[2])[0] = (i477 | i478) & (~(i477 & i478));
                                    break;
                                }
                            } else {
                                c = 0;
                            }
                            i5 = 1;
                            r9 = r20;
                            r12 = r11;
                        }
                        if (context == null) {
                            Object[] objArr512 = new Object[4];
                            int[] iArr7 = new int[i5];
                            objArr512[c] = iArr7;
                            objArr512[2] = new int[i5];
                            int[] iArr8 = new int[i5];
                            objArr512[3] = iArr8;
                            iArr8[0] = r12;
                            iArr7[0] = r12;
                            int iMyTid3 = Process.myTid();
                            int i2216 = 414996829 + (((~(iMyTid3 | 906581299)) | 746231573) * (-668)) + ((906581299 | (~(746231573 | iMyTid3))) * 1336) + ((iMyTid3 | 1048303415) * 668);
                            int i2217 = ((i2216 << 1) - i2216) + i4;
                            int i2218 = i2217 << 13;
                            int i2219 = (i2217 | i2218) & (~(i2217 & i2218));
                            int i2220 = i2219 >>> 17;
                            int i2221 = (i2219 | i2220) & (~(i2219 & i2220));
                            int i2222 = i2221 << 5;
                            ((int[]) objArr512[2])[0] = ((~i2221) & i2222) | ((~i2222) & i2221);
                            objArr512[1] = null;
                            return objArr512;
                        }
                        bArr = new byte[r9.length][];
                        length = r9.length;
                        i7 = 0;
                        i8 = 0;
                        while (i7 < length) {
                            r10 = r9;
                            r7 = r10[i7];
                            Object[] objArr513 = new Object[1];
                            c(14 - (~(-View.getDefaultSize(0, 0))), new int[]{-1126508594, -1707955208, -1985443438, 137225525, 1597574327, 2041802794, -1595502793, 1282537579}, objArr513);
                            cls3 = Class.forName((String) objArr513[0]);
                            objArr7 = new Object[1];
                            a(new byte[]{1, 1, 1, 0, 0, 1, 1, 0}, new int[]{186, 8, 0, 0}, true, objArr7);
                            if (((Integer) cls3.getMethod((String) objArr7[0], null).invoke(r7, null)).intValue() == 4) {
                                ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(32);
                                Class<?> cls110 = Class.forName(str10);
                                longPressTimeout = ViewConfiguration.getLongPressTimeout() >> 16;
                                int iIPostMessageService17 = Lists.TransformingRandomAccessList.AnonymousClass1.IPostMessageService();
                                int i2310 = longPressTimeout * (-109);
                                int i2311 = ((i2310 | 1332) << 1) - (i2310 ^ 1332);
                                int i2312 = ~longPressTimeout;
                                int i2313 = ~((iIPostMessageService17 ^ 12) | (iIPostMessageService17 & 12));
                                int i2314 = -(-(((i2312 ^ i2313) | (i2312 & i2313)) * (-220)));
                                int i2315 = ((i2311 | i2314) << 1) - (i2311 ^ i2314);
                                int i2316 = ((~((longPressTimeout ^ 12) | (longPressTimeout & 12))) | i2313) * 220;
                                i35 = ((i2315 | i2316) << 1) - (i2315 ^ i2316);
                                i36 = ~((~longPressTimeout) | 12);
                                i37 = getARTIFICIAL_FRAME_PACKAGE_NAME + 83;
                                artificialFrame = i37 % 128;
                                if (i37 % 2 == 0) {
                                    int i2317 = ~(((-13) ^ longPressTimeout) | (longPressTimeout & (-13)));
                                    int i2318 = i36 ^ i2317;
                                    Object[] objArr514 = new Object[1];
                                    c(i35 / (b.f39n << ((i36 & i2317) | i2318)), new int[]{2143351903, -982766959, -1780750661, -446571346, -967477501, 352953536}, objArr514);
                                    str5 = (String) objArr514[0];
                                } else {
                                    int i2319 = (i36 | (~(((-13) ^ longPressTimeout) | (longPressTimeout & (-13))))) * b.f39n;
                                    Object[] objArr515 = new Object[1];
                                    c(((i35 | i2319) << 1) - (i2319 ^ i35), new int[]{2143351903, -982766959, -1780750661, -446571346, -967477501, 352953536}, objArr515);
                                    str5 = (String) objArr515[0];
                                }
                                longBuffer = (LongBuffer) cls110.getMethod(str5, null).invoke(byteBufferAllocate2, null);
                                jArrArray = r7.array();
                                length4 = jArrArray.length;
                                i38 = 0;
                                while (i38 < length4) {
                                    longBuffer.put(jArrArray[i38]);
                                    int i2410 = (i38 ^ (-104)) + ((i38 & (-104)) << 1);
                                    i38 = (i2410 & 105) + (i2410 | 105);
                                }
                                bArr[i8] = byteBufferAllocate2.array();
                                i8++;
                            }
                            i7++;
                            length = length;
                            r10 = r10;
                        }
                        r10 = r9;
                        ?? r210 = r10;
                        if (i8 > 0) {
                            int i2411 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                            int i2412 = ((i2411 | 25) << 1) - (i2411 ^ 25);
                            artificialFrame = i2412 % 128;
                            int i2413 = i2412 % 2;
                            strArr3 = new String[1][];
                            int iCurrentTimeMillis2 = ((int) System.currentTimeMillis()) ^ 343337308;
                            int i2414 = ~iCurrentTimeMillis2;
                            i32 = ~r12;
                            Object[] objArr516 = {Integer.valueOf((r12 & i2414) | (iCurrentTimeMillis2 & i32)), bArr, Integer.valueOf(i8), Integer.valueOf(i2), strArr3};
                            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1514071993);
                            if (objAccessartificialFrame3 == null) {
                                int iAxisFromString2 = MotionEvent.axisFromString("") + 22;
                                char capsMode3 = (char) TextUtils.getCapsMode("", 0, 0);
                                int fadingEdgeLength2 = (ViewConfiguration.getFadingEdgeLength() >> 16) + 465;
                                byte b9 = $$a[11];
                                byte b10 = b9;
                                Object[] objArr610 = new Object[1];
                                b(b9, b10, (byte) (b10 + 1), objArr610);
                                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(iAxisFromString2, capsMode3, fadingEdgeLength2, 983850575, false, (String) objArr610[0], new Class[]{Integer.TYPE, byte[][].class, Integer.TYPE, Integer.TYPE, String[][].class});
                            }
                            long jLongValue4 = ((Long) ((Method) objAccessartificialFrame3).invoke(null, objArr516)).longValue();
                            long j14 = -614106746;
                            long j15 = 371;
                            long j16 = (j15 * j14) + (j15 * jLongValue4);
                            long j17 = -370;
                            long j18 = -1;
                            long j19 = jLongValue4 ^ j18;
                            long j20 = (long) r12;
                            long j21 = j20 ^ j18;
                            long j22 = j14 ^ j18;
                            long j110 = j16 + ((((j19 | j21) ^ j18) | ((j22 | j20) ^ j18)) * j17);
                            long j111 = ((j22 | j21) ^ j18) | ((j19 | j20) ^ j18);
                            long j112 = j18 ^ (jLongValue4 | j14);
                            long j113 = j110 + (j17 * (j111 | j112)) + (((long) 370) * j112) + ((long) (-1348107944));
                            int i2415 = (int) (j113 >> 32);
                            int iNextInt3 = new Random().nextInt(426611332);
                            int i2416 = ~iNextInt3;
                            int i2417 = i2415 & (1612427114 + (((~(i2416 | 1695351675)) | (~(258125264 | i2416)) | (-1869590524)) * 464) + (((-1611465260) | iNextInt3) * (-464)) + (((~(iNextInt3 | 1695351675)) | (-1869590524)) * 464));
                            int iElapsedRealtime2 = (int) SystemClock.elapsedRealtime();
                            int i2418 = ((int) j113) & (2088992125 + ((1993845722 | iElapsedRealtime2) * 376) + (((~((~iElapsedRealtime2) | 415170360)) | 1715536066) * (-376)) + (((~(iElapsedRealtime2 | (-415170361))) | (-1852396771)) * 376));
                            int i2419 = (i2418 & i2417) | (i2417 ^ i2418);
                            i33 = ((~i2419) & iCurrentTimeMillis2) | (i2419 & i2414);
                            if ((i2 & 1) == 1) {
                            }
                            if (((~((i33 & r12) == true ? 1 : 0)) & ((i33 | r12) == true ? 1 : 0)) != 17) {
                                objArr6 = new Object[]{new int[]{i33}, strArr3[0], new int[]{(i274 | i275) & (~(i274 & i275))}, new int[]{r12}};
                                int i2610 = (-461147299) + (((~(i32 | 300314338)) | 135368708) * (-160)) + ((300314338 | (~(139964612 | i32))) * SyslogConstants.LOG_LOCAL4);
                                int i2611 = (i2610 & 16) + (i2610 | 16);
                                int i2710 = (i3 & i2611) + (i3 | i2611);
                                int i2711 = i2710 << 13;
                                int i2712 = (i2711 | i2710) & (~(i2710 & i2711));
                                int i2713 = i2712 >>> 17;
                                int i2714 = (i2712 | i2713) & (~(i2712 & i2713));
                                int i2715 = i2714 << 5;
                            } else {
                                i34 = (i33 & i32) | (((~i33) & r12) == true ? 1 : 0);
                                if (i34 == 0) {
                                    objArr = new Object[]{new int[]{i33}, null, new int[]{(i256 | i257) & (~(i256 & i257))}, new int[]{r12}};
                                    int i2510 = (~(215522247 | i32)) | 304562208;
                                    int i2511 = ~((-144212483) | r12);
                                    int i2512 = -(-((((i2510 | i2511) * (-252)) - 399385187) + ((i2511 | (~(520084455 | i32))) * 252)));
                                    int i2513 = ((i3 | i2512) << 1) - (i3 ^ i2512);
                                    int i2514 = i2513 << 13;
                                    int i2515 = (i2514 & (~i2513)) | ((~i2514) & i2513);
                                    int i2516 = i2515 ^ (i2515 >>> 17);
                                    int i2517 = i2516 << 5;
                                    break;
                                }
                                if (i34 == 11) {
                                    objArr6 = new Object[]{new int[]{i33}, strArr3[0], new int[1], new int[]{r12}};
                                    int startElapsedRealtime4 = (int) Process.getStartElapsedRealtime();
                                    int i2518 = 915255893 + ((~(startElapsedRealtime4 | 280763409)) * JfifUtil.MARKER_SOI);
                                    int i2519 = ~startElapsedRealtime4;
                                    int i2612 = i2518 + ((398286323 | i2519) * (-216)) + (((~(i2519 | 280763409)) | (-120413684)) * JfifUtil.MARKER_SOI);
                                    int i2613 = -(-(((i2612 | 16) << 1) - (i2612 ^ 16)));
                                    int i2614 = ((i3 | i2613) << 1) - (i3 ^ i2613);
                                    int i2615 = i2614 << 13;
                                    int i2616 = (i2615 & (~i2614)) | ((~i2615) & i2614);
                                    int i2617 = i2616 >>> 17;
                                    int i2618 = (i2616 | i2617) & (~(i2616 & i2617));
                                    int i2619 = i2618 << 5;
                                    ((int[]) objArr6[2])[0] = (i2618 | i2619) & (~(i2618 & i2619));
                                }
                            }
                            return objArr6;
                        }
                        str9 = "";
                        i9 = artificialFrame + 75;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i9 % 128;
                        if (i9 % 2 != 0) {
                            Object[] objArr611 = new Object[1];
                            c(10 >>> ExpandableListView.getPackedPositionGroup(1L), new int[]{-553959009, 1566372400, 2145491739, -1796016629, 1015558550, -1808814313, 600618822, -1854666632, -1584713131, -61496597, 1209812182, 1465344295}, objArr611);
                            obj = objArr611[0];
                        } else {
                            int i2716 = -(-ExpandableListView.getPackedPositionGroup(0L));
                            Object[] objArr612 = new Object[1];
                            c((i2716 ^ 23) + ((i2716 & 23) << 1), new int[]{-553959009, 1566372400, 2145491739, -1796016629, 1015558550, -1808814313, 600618822, -1854666632, -1584713131, -61496597, 1209812182, 1465344295}, objArr612);
                            obj = objArr612[0];
                        }
                        Class<?> cls111 = Class.forName((String) obj);
                        Object[] objArr613 = new Object[1];
                        a(new byte[]{1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1}, new int[]{194, 17, 38, 0}, false, objArr613);
                        Object objInvoke25 = cls111.getMethod((String) objArr613[0], null).invoke(context, null);
                        int i2717 = -KeyEvent.keyCodeFromString(str9);
                        Object[] objArr614 = new Object[1];
                        c((i2717 ^ 23) + ((i2717 & 23) << 1), new int[]{-553959009, 1566372400, 2145491739, -1796016629, 1015558550, -1808814313, 600618822, -1854666632, -1584713131, -61496597, 1209812182, 1465344295}, objArr614);
                        Class<?> cls112 = Class.forName((String) objArr614[0]);
                        int i2718 = -(-KeyEvent.getDeadChar(0, 0));
                        Object[] objArr615 = new Object[1];
                        c(((i2718 | 14) << 1) - (i2718 ^ 14), new int[]{2095174662, 1254976582, 1888163075, 733288094, -1891425884, 636340184, 1854975689, 1879805549}, objArr615);
                        Object[] objArr616 = {cls112.getMethod((String) objArr615[0], null).invoke(context, null), 64};
                        int i2719 = -(-(ViewConfiguration.getMaximumDrawingCacheSize() >> 24));
                        Object[] objArr617 = new Object[1];
                        c((i2719 ^ 33) + ((i2719 & 33) << 1), new int[]{-553959009, 1566372400, 2145491739, -1796016629, 1015558550, -1808814313, 600618822, -1854666632, 1964086842, 560341688, 1888163075, 733288094, -1442994014, 479450140, -1807369700, 802064978, 1132699382, -1559291025}, objArr617);
                        Class<?> cls113 = Class.forName((String) objArr617[0]);
                        Object[] objArr618 = new Object[1];
                        c(Process.getGidForName(str9) + 15, new int[]{2095174662, 1254976582, 1888163075, 733288094, -1833489099, 842928759, -2083258904, -518269280}, objArr618);
                        objInvoke = cls113.getMethod((String) objArr618[0], String.class, Integer.TYPE).invoke(objInvoke25, objArr616);
                        linkedHashSet = new LinkedHashSet();
                        ?? r211 = r210;
                        length2 = r211.length;
                        i10 = 0;
                        r13 = r211;
                        while (i10 < length2) {
                            r5 = r13[i10];
                            Object[] objArr619 = new Object[1];
                            c(((Process.getThreadPriority(0) + 20) >> 6) + 15, new int[]{-1126508594, -1707955208, -1985443438, 137225525, 1597574327, 2041802794, -1595502793, 1282537579}, objArr619);
                            cls = Class.forName((String) objArr619[0]);
                            objArr3 = new Object[1];
                            a(new byte[]{1, 1, 1, 0, 0, 1, 1, 0}, new int[]{186, 8, 0, 0}, true, objArr3);
                            if (((Integer) cls.getMethod((String) objArr3[0], null).invoke(r5, null)).intValue() == 4) {
                                int iResolveSizeAndState2 = View.resolveSizeAndState(0, 0, 0);
                                int iIPostMessageService18 = Lists.TransformingRandomAccessList.AnonymousClass1.IPostMessageService();
                                int i2810 = ~iIPostMessageService18;
                                int i2811 = ~(((-8) & i2810) | ((-8) ^ i2810));
                                int i2812 = ~((iResolveSizeAndState2 ^ iIPostMessageService18) | (iResolveSizeAndState2 & iIPostMessageService18));
                                int i2813 = ((iResolveSizeAndState2 * 960) - 13419) + (((i2811 & i2812) | (i2811 ^ i2812)) * 959) + 7672;
                                int i2814 = ((~((iIPostMessageService18 & (-8)) | ((-8) ^ iIPostMessageService18))) | (~((iResolveSizeAndState2 & i2810) | (i2810 ^ iResolveSizeAndState2)))) * 959;
                                Object[] objArr710 = new Object[1];
                                c(((i2813 | i2814) << 1) - (i2814 ^ i2813), new int[]{1927792283, -663241186, -520769080, -90225899}, objArr710);
                                obj2 = objArr710[0];
                            } else {
                                int i2815 = -View.combineMeasuredStates(0, 0);
                                Object[] objArr711 = new Object[1];
                                c(((i2815 | 3) << 1) - (i2815 ^ 3), new int[]{-2028639001, 1564982371}, objArr711);
                                obj2 = objArr711[0];
                            }
                            str = (String) obj2;
                            int i2816 = -(ViewConfiguration.getKeyRepeatTimeout() >> 16);
                            Object[] objArr712 = new Object[1];
                            c(((i2816 | 30) << 1) - (i2816 ^ 30), new int[]{-553959009, 1566372400, 2145491739, -1796016629, 1015558550, -1808814313, 600618822, -1854666632, 1964086842, 560341688, 1888163075, 733288094, -1833489099, 842928759, -2083258904, -518269280}, objArr712);
                            Class<?> cls114 = Class.forName((String) objArr712[0]);
                            Object[] objArr713 = new Object[1];
                            a(null, new int[]{211, 10, 67, 3}, true, objArr713);
                            objArr4 = (Object[]) cls114.getField((String) objArr713[0]).get(objInvoke);
                            length3 = objArr4.length;
                            i12 = 0;
                            r14 = r13;
                            while (i12 < length3) {
                                int i2817 = artificialFrame;
                                i13 = (i2817 & 101) + (i2817 | 101);
                                getARTIFICIAL_FRAME_PACKAGE_NAME = i13 % 128;
                                if (i13 % 2 != 0) {
                                    Object obj27 = objArr4[i12];
                                    throw null;
                                }
                                Object obj28 = objArr4[i12];
                                obj3 = objInvoke;
                                i14 = length2;
                                Object[] objArr714 = new Object[1];
                                c(View.MeasureSpec.getMode(0) + 27, new int[]{-1126508594, -1707955208, -1142011696, -607183002, -2037064201, -1876888749, 1899525521, 1645533664, 762759276, 1112811353, 268823455, 1793814410, -2789657, -403136695}, objArr714);
                                str2 = str7;
                                Object objInvoke26 = Class.forName((String) objArr714[0]).getMethod(str2, String.class).invoke(null, str);
                                Object[] objArr715 = new Object[1];
                                a(new byte[]{1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1}, new int[]{221, 28, 0, 0}, true, objArr715);
                                Class<?> cls115 = Class.forName((String) objArr715[0]);
                                int i2818 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                int i2819 = (i2818 & 45) + (i2818 | 45);
                                artificialFrame = i2819 % 128;
                                int i2910 = i2819 % 2;
                                int i2911 = (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                                int iIPostMessageService19 = Lists.TransformingRandomAccessList.AnonymousClass1.IPostMessageService();
                                str3 = str;
                                int i2912 = ~i2911;
                                i15 = length3;
                                int i2913 = ~iIPostMessageService19;
                                int i2914 = ((i2911 * 866) - 9504) + (((-12) | (~((i2912 ^ i2913) | (i2912 & i2913)))) * (-865));
                                int i2915 = (~(i2911 | iIPostMessageService19)) * 865;
                                int i2916 = (i2914 & i2915) + (i2915 | i2914);
                                int i2917 = ~iIPostMessageService19;
                                int i2918 = ~((i2917 & (-12)) | ((-12) ^ i2917));
                                int i2919 = ~(i2913 | i2911);
                                int i3010 = -(-(((i2918 & i2919) | (i2918 ^ i2919)) * 865));
                                Object[] objArr716 = new Object[1];
                                c((i2916 ^ i3010) + ((i2916 & i3010) << 1), new int[]{-385849482, 2145409738, 1740005207, -1640331511, 503494999, 1098140876}, objArr716);
                                Object[] objArr717 = {cls115.getMethod((String) objArr716[0], null).invoke(obj28, null)};
                                int i3011 = -(ViewConfiguration.getTouchSlop() >> 8);
                                int iIPostMessageService110 = Lists.TransformingRandomAccessList.AnonymousClass1.IPostMessageService();
                                int i3012 = i3011 * (-1965);
                                int i3013 = (((i3012 | 26568) << 1) - (i3012 ^ 26568)) + (((i3011 ^ (-28)) | (i3011 & (-28))) * 983);
                                int i3014 = ~i3011;
                                int i3015 = ~iIPostMessageService110;
                                int i3016 = ~(((-28) & i3015) | ((-28) ^ i3015));
                                int i3017 = i3013 + (((i3016 & i3014) | (i3014 ^ i3016)) * (-983));
                                int i3018 = ((~((~i3011) | 27)) | (~((i3015 & i3014) | (i3014 ^ i3015)))) * 983;
                                Object[] objArr718 = new Object[1];
                                c((i3017 & i3018) + (i3018 | i3017), new int[]{-1126508594, -1707955208, -1142011696, -607183002, -2037064201, -1876888749, 1899525521, 1645533664, 762759276, 1112811353, 268823455, 1793814410, -2789657, -403136695}, objArr718);
                                Class<?> cls116 = Class.forName((String) objArr718[0]);
                                Object[] objArr719 = new Object[1];
                                a(new byte[]{0, 1, 0, 0, 0, 1}, new int[]{249, 6, 0, 0}, true, objArr719);
                                Object[] objArr810 = {cls116.getMethod((String) objArr719[0], byte[].class).invoke(objInvoke26, objArr717)};
                                Class<?> cls117 = Class.forName(str10);
                                int i3019 = (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
                                Object[] objArr811 = new Object[1];
                                c((i3019 & 3) + (i3019 | 3), new int[]{1799158074, -1917480941}, objArr811);
                                objInvoke2 = cls117.getMethod((String) objArr811[0], byte[].class).invoke(null, objArr810);
                                int i3110 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                int i3111 = (i3110 & 101) + (i3110 | 101);
                                artificialFrame = i3111 % 128;
                                int i3112 = i3111 % 2;
                                cls2 = Class.forName(str10);
                                i16 = (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                                int i3113 = artificialFrame + 93;
                                getARTIFICIAL_FRAME_PACKAGE_NAME = i3113 % 128;
                                int i3114 = i3113 % 2;
                                iIPostMessageService = Lists.TransformingRandomAccessList.AnonymousClass1.IPostMessageService();
                                int i3115 = i16 * 755;
                                int i3116 = (i3115 & (-9036)) + (i3115 | (-9036));
                                i17 = ~i16;
                                int i3117 = ~((i17 ^ 12) | (i17 & 12));
                                i18 = ~i16;
                                r31 = r14;
                                int i3118 = ~((i18 ^ iIPostMessageService) | (i18 & iIPostMessageService));
                                int i3119 = (i3117 ^ i3118) | (i3118 & i3117);
                                int i3210 = ~(iIPostMessageService | 12);
                                i19 = i3116 + (((i3119 ^ i3210) | (i3119 & i3210)) * (-754));
                                int i3211 = artificialFrame;
                                i20 = ((i3211 | 85) << 1) - (i3211 ^ 85);
                                getARTIFICIAL_FRAME_PACKAGE_NAME = i20 % 128;
                                if (i20 % 2 != 0) {
                                    throw null;
                                }
                                int i3212 = (i17 ^ 12) | (i17 & 12);
                                int i3213 = ~((i3212 & iIPostMessageService) | (i3212 ^ iIPostMessageService));
                                int i3214 = ~iIPostMessageService;
                                int i3215 = ~((i16 & i3214) | (i3214 ^ i16) | 12);
                                int i3216 = (i19 - (~((-754) * ((i3215 & i3213) | (i3213 ^ i3215))))) - 1;
                                int i3217 = ~iIPostMessageService;
                                int i3218 = ((i3217 & i18) | (i18 ^ i3217)) * 754;
                                Object[] objArr812 = new Object[1];
                                c(((i3216 | i3218) << 1) - (i3218 ^ i3216), new int[]{2143351903, -982766959, -1780750661, -446571346, -967477501, 352953536}, objArr812);
                                objInvoke3 = cls2.getMethod((String) objArr812[0], null).invoke(objInvoke2, null);
                                if (objInvoke3 != null) {
                                    string = str9;
                                    i22 = 0;
                                    while (true) {
                                        int i3219 = artificialFrame;
                                        i23 = (i3219 ^ 119) + ((i3219 & 119) << 1);
                                        getARTIFICIAL_FRAME_PACKAGE_NAME = i23 % 128;
                                        if (i23 % 2 != 0) {
                                            i24 = (TypedValue.complexToFraction(1, 0.0f, 1.0f) > 2.0f ? 1 : (TypedValue.complexToFraction(1, 0.0f, 1.0f) == 2.0f ? 0 : -1));
                                            i25 = 121;
                                        } else {
                                            i24 = (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                                            i25 = 15;
                                        }
                                        int i3310 = i24 * (-515);
                                        int i3311 = i25 * 517;
                                        int i3312 = ((i3310 | i3311) << 1) - (i3310 ^ i3311);
                                        int i3313 = ~i25;
                                        int i3314 = ~(((i3313 & r12) == true ? 1 : 0) | ((i3313 ^ r12) == true ? 1 : 0));
                                        int i3315 = ~r12;
                                        int i3316 = ~(i3315 | i24);
                                        int i3317 = (i3314 ^ i3316) | (i3316 & i3314);
                                        int i3318 = ~r12;
                                        int i3319 = (i3317 | (~(i3318 | i25))) * (-516);
                                        int i3410 = (i3312 & i3319) + (i3312 | i3319);
                                        i21 = i10;
                                        int i3411 = ~((((~i25) | (~i24)) | r12) == true ? 1 : 0);
                                        int i3412 = ~i24;
                                        int i3413 = ~((i3412 ^ i3318) | (i3412 & i3318) | i25);
                                        int i3414 = (i3410 - (~(((i3411 ^ i3413) | (i3411 & i3413)) * 516))) - 1;
                                        int i3415 = ~((i3412 ^ i25) | (i3412 & i25));
                                        int i3416 = ~((i3315 ^ i25) | (i3315 & i25));
                                        i26 = i3414 + (((i3415 & i3416) | (i3415 ^ i3416)) * 516);
                                        iArr = new int[]{-1126508594, -1707955208, -1985443438, 137225525, 1597574327, 2041802794, -1595502793, 1282537579};
                                        int i3417 = ~((447519814 & i3318) | (447519814 ^ i3318));
                                        int i3418 = (-133649860) + (((i3417 & (-2083834278)) | ((-2083834278) ^ i3417)) * (-602));
                                        int i3419 = ~((447519814 ^ r12) | (447519814 & r12));
                                        int i3510 = ((-2126306792) ^ i3419) | ((-2126306792) & i3419);
                                        int i3511 = (i3318 ^ (-447519815)) | (i3318 & (-447519815));
                                        int i3512 = ~((i3511 ^ (-2083834278)) | (i3511 & (-2083834278)));
                                        int i3513 = ((i3510 ^ i3512) | (i3510 & i3512)) * (-301);
                                        int i3514 = ((i3418 | i3513) << 1) - (i3513 ^ i3418);
                                        int i3515 = -(-((~(i3315 | (-2083834278))) * 301));
                                        i27 = (i3514 ^ i3515) + ((i3515 & i3514) << 1);
                                        int iIPostMessageService111 = Lists.TransformingRandomAccessList.AnonymousClass1.IPostMessageService();
                                        int i3516 = ~iIPostMessageService111;
                                        int i3517 = ~((1860031814 ^ i3516) | (1860031814 & i3516));
                                        int i3518 = ~iIPostMessageService111;
                                        int i3519 = ~((351527308 ^ i3518) | (351527308 & i3518));
                                        int i3610 = -(-(((i3517 ^ i3519) | (i3519 & i3517)) * (-867)));
                                        int i3611 = ((217061680 | i3610) << 1) - (i3610 ^ 217061680);
                                        int i3612 = ~(1860031814 | iIPostMessageService111);
                                        int i3613 = ((-2130703823) ^ i3612) | (i3612 & (-2130703823));
                                        int i3614 = ~((351527308 ^ iIPostMessageService111) | (351527308 & iIPostMessageService111));
                                        i28 = i3611 + (((i3613 ^ i3614) | (i3613 & i3614)) * (-1734));
                                        int i3615 = ~((i3516 & 2130703822) | (2130703822 ^ i3516));
                                        int i3616 = ~(((-270672009) & iIPostMessageService111) | ((-270672009) ^ iIPostMessageService111));
                                        i29 = -(-(((~((iIPostMessageService111 & (-1779176515)) | ((-1779176515) ^ iIPostMessageService111))) | (i3615 & i3616) | (i3615 ^ i3616)) * 867));
                                        if (i27 > ((i28 | i29) << 1) - (i28 ^ i29)) {
                                            Object[] objArr813 = new Object[1];
                                            c(i26, iArr, objArr813);
                                            Class<?> cls118 = Class.forName((String) objArr813[0]);
                                            Object[] objArr814 = new Object[1];
                                            a(new byte[]{1, 1, 0, 0, 1}, new int[]{170, 5, 43, 0}, false, objArr814);
                                            method = cls118.getMethod((String) objArr814[0], null);
                                            objArr5 = null;
                                        } else {
                                            Object[] objArr815 = new Object[1];
                                            c(i26, iArr, objArr815);
                                            Class<?> cls29 = Class.forName((String) objArr815[0]);
                                            Object[] objArr816 = new Object[1];
                                            a(new byte[]{1, 1, 0, 0, 1}, new int[]{170, 5, 43, 0}, true, objArr816);
                                            objArr5 = null;
                                            method = cls29.getMethod((String) objArr816[0], null);
                                        }
                                        if (i22 >= ((Integer) method.invoke(objInvoke3, objArr5)).intValue()) {
                                            break;
                                            break;
                                        }
                                        StringBuilder sb5 = new StringBuilder();
                                        sb5.append(string);
                                        int i3617 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                        i30 = (i3617 & AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY) + (i3617 | AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY);
                                        artificialFrame = i30 % 128;
                                        if (i30 % 2 == 0) {
                                            i31 = 0;
                                            int i3618 = 21 / 0;
                                        } else {
                                            i31 = 0;
                                        }
                                        Object[] objArr817 = new Object[1];
                                        objArr817[i31] = Integer.valueOf(i22);
                                        Object[] objArr818 = new Object[1];
                                        a(new byte[]{0, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1}, new int[]{i31, 19, i31, 17}, i31, objArr818);
                                        Class<?> cls210 = Class.forName((String) objArr818[i31]);
                                        int i3619 = -(-(ViewConfiguration.getDoubleTapTimeout() >> 16));
                                        Object[] objArr819 = new Object[1];
                                        c((i3619 & 3) + (i3619 | 3), new int[]{1308963368, -547684839}, objArr819);
                                        Object[] objArr910 = {Long.valueOf(((Long) cls210.getMethod((String) objArr819[0], Integer.TYPE).invoke(objInvoke3, objArr817)).longValue())};
                                        String str17 = str9;
                                        int i3710 = -TextUtils.indexOf((CharSequence) str17, '0');
                                        int i3711 = i3710 * 367;
                                        int i3712 = (i3711 & 4771) + (i3711 | 4771);
                                        int i3713 = (i3710 | 13) * (-366);
                                        int i3714 = (((i3712 | i3713) << 1) - (i3713 ^ i3712)) + (((~(((-14) & r12) | ((-14) ^ r12))) | i3710) * (-366));
                                        int i3715 = ~i3710;
                                        int i3716 = ~((i3715 & 13) | (i3715 ^ 13));
                                        int i3717 = ((-14) ^ i3710) | (i3710 & (-14));
                                        int i3718 = ~((i3717 & r12) | ((i3717 ^ r12) == true ? 1 : 0));
                                        int i3719 = ((i3718 & i3716) | (i3716 ^ i3718)) * 366;
                                        Object[] objArr911 = new Object[1];
                                        c((i3714 ^ i3719) + ((i3719 & i3714) << 1), new int[]{-1126508594, -1707955208, -856323126, 2122573174, -2076996192, -1835679048, 1552917501, 2030585986}, objArr911);
                                        Class<?> cls211 = Class.forName((String) objArr911[0]);
                                        Object[] objArr912 = new Object[1];
                                        a(new byte[]{1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1}, new int[]{175, 11, 0, 0}, true, objArr912);
                                        sb5.append((String) cls211.getMethod((String) objArr912[0], Long.TYPE).invoke(null, objArr910));
                                        string = sb5.toString();
                                        i22++;
                                        str9 = str17;
                                        i10 = i21;
                                    }
                                    str4 = str9;
                                } else {
                                    i21 = i10;
                                    str4 = str9;
                                    string = str4;
                                }
                                linkedHashSet.add(string);
                                if (objInvoke3.equals(r5.rewind())) {
                                    objArr = new Object[]{new int[]{r12}, null, new int[1], new int[]{r12}};
                                    int startElapsedRealtime5 = (int) Process.getStartElapsedRealtime();
                                    int i3810 = i3 + (-1260349191) + ((~((~startElapsedRealtime5) | (-419594243))) * (-116)) + ((587038436 | startElapsedRealtime5) * 116) + (((~(startElapsedRealtime5 | 426688710)) | 579943968) * 116);
                                    int i3811 = i3810 << 13;
                                    int i3812 = ((~i3810) & i3811) | ((~i3811) & i3810);
                                    int i3813 = i3812 >>> 17;
                                    int i3814 = ((~i3812) & i3813) | ((~i3813) & i3812);
                                    int i3815 = i3814 << 5;
                                    ((int[]) objArr[2])[0] = (i3814 | i3815) & (~(i3814 & i3815));
                                    break;
                                }
                                int i3816 = (i12 ^ 31) + ((i12 & 31) << 1);
                                i12 = (i3816 & (-30)) + (i3816 | (-30));
                                objInvoke = obj3;
                                str = str3;
                                str9 = str4;
                                i10 = i21;
                                length2 = i14;
                                length3 = i15;
                                r14 = r31;
                                str7 = str2;
                                objArr = new Object[]{new int[]{(~(r12 & 2)) & (r12 | 2)}, null, new int[]{((~i402) & i403) | ((~i403) & i402)}, new int[]{r12}};
                                int i3817 = (-1761203017) + (((~(614751685 | r12)) | 8668164) * (-502)) + ((~((~r12) | 783769575)) * (-502)) + ((614751685 | (~((-775101412) | r12))) * TypedValues.PositionType.TYPE_DRAWPATH);
                                int i3818 = 9071 - (~(i3817 * (-565)));
                                int i3819 = ~(((-17) ^ i3817) | ((-17) & i3817));
                                int i3910 = ~((-17) | r12);
                                int i3911 = i3818 + (((i3819 & i3910) | (i3819 ^ i3910)) * (-566));
                                int i3912 = ~i3817;
                                int i3913 = (~((i3912 & 16) | (i3912 ^ 16))) * 566;
                                int i3914 = (i3911 ^ i3913) + ((i3911 & i3913) << 1);
                                int i3915 = ~i3817;
                                int i3916 = (i3915 & (-17)) | ((-17) ^ i3915);
                                int i3917 = i3914 + ((~(((i3916 & r12) == true ? 1 : 0) | ((i3916 ^ r12) == true ? 1 : 0))) * 566);
                                int i3918 = (i3 ^ i3917) + ((i3 & i3917) << 1);
                                int i3919 = i3918 << 13;
                                int i4010 = (i3918 | i3919) & (~(i3918 & i3919));
                                int i4011 = i4010 >>> 17;
                                int i4012 = (i4010 | i4011) & (~(i4010 & i4011));
                                int i4013 = i4012 << 5;
                                break;
                            }
                            Object obj29 = objInvoke;
                            int i4014 = i10;
                            int i4015 = ((i4014 | WebSocketProtocol.PAYLOAD_SHORT) << 1) - (i4014 ^ WebSocketProtocol.PAYLOAD_SHORT);
                            i10 = (i4015 ^ (-125)) + ((i4015 & (-125)) << 1);
                            objInvoke = obj29;
                            length2 = length2;
                            r13 = r14;
                            str7 = str7;
                        }
                        int i4016 = (r12 & (-2)) | ((~r12) & 1);
                        arrayList = new ArrayList(linkedHashSet);
                        int size4 = arrayList.size();
                        strArr2 = new String[(size4 & 1) + (size4 | 1)];
                        Object[] objArr913 = new Object[1];
                        c(4 - (~TextUtils.indexOf((CharSequence) str9, '0', 0, 0)), new int[]{1704931633, 256569062}, objArr913);
                        strArr2[0] = (String) objArr913[0];
                        while (i11 < arrayList.size()) {
                            strArr2[(i11 & 1) + (i11 | 1)] = (String) arrayList.get(i11);
                        }
                        objArr2 = new Object[]{new int[]{i4016}, strArr2, new int[]{((~i413) & i414) | ((~i414) & i413)}, new int[]{r12}};
                        int i4017 = ~(159568742 | r12);
                        int i4018 = 447134031 + (((-780984) | i4017) * (-220)) + ((i4017 | (-160168952)) * 220) + 418830302;
                        int i4019 = ((i3 | i4018) << 1) - (i3 ^ i4018);
                        int i4110 = i4019 << 13;
                        int i4111 = ((~i4019) & i4110) | ((~i4110) & i4019);
                        int i4112 = i4111 >>> 17;
                        int i4113 = ((~i4111) & i4112) | ((~i4112) & i4111);
                        int i4114 = i4113 << 5;
                        return objArr2;
                    }
                    r11 = i;
                    i4 = i3;
                    str7 = str7;
                    if (z) {
                        objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(682069389);
                        if (objAccessartificialFrame == null) {
                            int maximumFlingVelocity3 = (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 21;
                            char edgeSlop2 = (char) (ViewConfiguration.getEdgeSlop() >> 16);
                            int scrollBarSize5 = (ViewConfiguration.getScrollBarSize() >> 8) + 465;
                            byte[] bArr13 = $$a;
                            byte b11 = (byte) (bArr13[13] - 1);
                            Object[] objArr142 = new Object[1];
                            b(b11, b11, bArr13[11], objArr142);
                            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(maximumFlingVelocity3, edgeSlop2, scrollBarSize5, -1211970683, false, (String) objArr142[0], null);
                        }
                        i6 = ((int[]) ((Object[]) ((Field) objAccessartificialFrame).get(null))[3])[0];
                        objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(682069389);
                        if (objAccessartificialFrame2 == null) {
                            int i4510 = 22 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                            char c6 = (char) (1 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)));
                            int defaultSize3 = View.getDefaultSize(0, 0) + 465;
                            byte[] bArr14 = $$a;
                            byte b12 = (byte) (bArr14[13] - 1);
                            Object[] objArr143 = new Object[1];
                            b(b12, b12, bArr14[11], objArr143);
                            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(i4510, c6, defaultSize3, -1211970683, false, (String) objArr143[0], null);
                        }
                        c = 0;
                        if (i6 != ((int[]) ((Object[]) ((Field) objAccessartificialFrame2).get(null))[0])[0]) {
                            objArr = new Object[]{new int[]{(~((r11 == true ? 1 : 0) & 5)) & ((r11 == true ? 1 : 0) | 5)}, null, new int[1], new int[]{r11 == true ? 1 : 0}};
                            int i4511 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                            int i4512 = (i4511 ^ 61) + ((i4511 & 61) << 1);
                            artificialFrame = i4512 % 128;
                            int i4513 = i4512 % 2;
                            int startElapsedRealtime6 = (int) Process.getStartElapsedRealtime();
                            int i4514 = ~startElapsedRealtime6;
                            int i4610 = ~(297002496 | i4514);
                            int i4611 = 635444933 + (((-431482851) | i4610) * (-712)) + (((~(startElapsedRealtime6 | (-134480355))) | (~(i4514 | 431482850))) * (-712)) + ((136652770 | i4610) * 712);
                            int i4612 = (i4611 & 16) + (16 | i4611);
                            int iIPostMessageService112 = Lists.TransformingRandomAccessList.AnonymousClass1.IPostMessageService();
                            int i4613 = i4612 * 829;
                            int i4614 = -(-(i4 * 829));
                            int i4615 = (i4613 & i4614) + (i4613 | i4614);
                            int i4616 = ~i4612;
                            int i4617 = ~i4;
                            int i4618 = ~((i4616 & i4617) | (i4616 ^ i4617));
                            int i4619 = (~iIPostMessageService112) | i4612;
                            int i479 = (i4615 - (~(-(-((i4618 | (~((i4619 & i4) | (i4619 ^ i4)))) * (-828)))))) - 1;
                            int i4710 = i4612 | i4;
                            int i4711 = ~iIPostMessageService112;
                            int i4712 = ((i479 + (((i4711 & i4710) | (i4710 ^ i4711)) * (-828))) - (~(-(-((~((i4612 & i4) | (i4612 ^ i4))) * 828))))) - 1;
                            int i4713 = i4712 << 13;
                            int i4714 = (i4713 | i4712) & (~(i4712 & i4713));
                            int i4715 = i4714 >>> 17;
                            int i4716 = (i4714 | i4715) & (~(i4714 & i4715));
                            int i4717 = i4716 << 5;
                            ((int[]) objArr[2])[0] = (i4716 | i4717) & (~(i4716 & i4717));
                            break;
                        }
                    } else {
                        c = 0;
                    }
                    i5 = 1;
                    r9 = r20;
                    r12 = r11;
                    try {
                        if (context == null) {
                            Object[] objArr517 = new Object[4];
                            int[] iArr9 = new int[i5];
                            objArr517[c] = iArr9;
                            objArr517[2] = new int[i5];
                            int[] iArr10 = new int[i5];
                            objArr517[3] = iArr10;
                            iArr10[0] = r12;
                            iArr9[0] = r12;
                            int iMyTid4 = Process.myTid();
                            int i22110 = 414996829 + (((~(iMyTid4 | 906581299)) | 746231573) * (-668)) + ((906581299 | (~(746231573 | iMyTid4))) * 1336) + ((iMyTid4 | 1048303415) * 668);
                            int i22111 = ((i22110 << 1) - i22110) + i4;
                            int i22112 = i22111 << 13;
                            int i22113 = (i22111 | i22112) & (~(i22111 & i22112));
                            int i2223 = i22113 >>> 17;
                            int i2224 = (i22113 | i2223) & (~(i22113 & i2223));
                            int i2225 = i2224 << 5;
                            ((int[]) objArr517[2])[0] = ((~i2224) & i2225) | ((~i2225) & i2224);
                            objArr517[1] = null;
                            return objArr517;
                        }
                        bArr = new byte[r9.length][];
                        length = r9.length;
                        i7 = 0;
                        i8 = 0;
                        while (i7 < length) {
                            r10 = r9;
                            r7 = r10[i7];
                            try {
                                Object[] objArr518 = new Object[1];
                                c(14 - (~(-View.getDefaultSize(0, 0))), new int[]{-1126508594, -1707955208, -1985443438, 137225525, 1597574327, 2041802794, -1595502793, 1282537579}, objArr518);
                                cls3 = Class.forName((String) objArr518[0]);
                                objArr7 = new Object[1];
                                a(new byte[]{1, 1, 1, 0, 0, 1, 1, 0}, new int[]{186, 8, 0, 0}, true, objArr7);
                                if (((Integer) cls3.getMethod((String) objArr7[0], null).invoke(r7, null)).intValue() == 4) {
                                    ByteBuffer byteBufferAllocate3 = ByteBuffer.allocate(32);
                                    try {
                                        Class<?> cls119 = Class.forName(str10);
                                        longPressTimeout = ViewConfiguration.getLongPressTimeout() >> 16;
                                        int iIPostMessageService113 = Lists.TransformingRandomAccessList.AnonymousClass1.IPostMessageService();
                                        int i23110 = longPressTimeout * (-109);
                                        int i23111 = ((i23110 | 1332) << 1) - (i23110 ^ 1332);
                                        int i23112 = ~longPressTimeout;
                                        int i23113 = ~((iIPostMessageService113 ^ 12) | (iIPostMessageService113 & 12));
                                        int i23114 = -(-(((i23112 ^ i23113) | (i23112 & i23113)) * (-220)));
                                        int i23115 = ((i23111 | i23114) << 1) - (i23111 ^ i23114);
                                        int i23116 = ((~((longPressTimeout ^ 12) | (longPressTimeout & 12))) | i23113) * 220;
                                        i35 = ((i23115 | i23116) << 1) - (i23115 ^ i23116);
                                        i36 = ~((~longPressTimeout) | 12);
                                        i37 = getARTIFICIAL_FRAME_PACKAGE_NAME + 83;
                                        artificialFrame = i37 % 128;
                                        if (i37 % 2 == 0) {
                                            int i23117 = ~(((-13) ^ longPressTimeout) | (longPressTimeout & (-13)));
                                            int i23118 = i36 ^ i23117;
                                            Object[] objArr519 = new Object[1];
                                            c(i35 / (b.f39n << ((i36 & i23117) | i23118)), new int[]{2143351903, -982766959, -1780750661, -446571346, -967477501, 352953536}, objArr519);
                                            str5 = (String) objArr519[0];
                                        } else {
                                            int i23119 = (i36 | (~(((-13) ^ longPressTimeout) | (longPressTimeout & (-13))))) * b.f39n;
                                            Object[] objArr5110 = new Object[1];
                                            c(((i35 | i23119) << 1) - (i23119 ^ i35), new int[]{2143351903, -982766959, -1780750661, -446571346, -967477501, 352953536}, objArr5110);
                                            str5 = (String) objArr5110[0];
                                        }
                                        longBuffer = (LongBuffer) cls119.getMethod(str5, null).invoke(byteBufferAllocate3, null);
                                        jArrArray = r7.array();
                                        length4 = jArrArray.length;
                                        i38 = 0;
                                        while (i38 < length4) {
                                            longBuffer.put(jArrArray[i38]);
                                            int i24110 = (i38 ^ (-104)) + ((i38 & (-104)) << 1);
                                            i38 = (i24110 & 105) + (i24110 | 105);
                                        }
                                        bArr[i8] = byteBufferAllocate3.array();
                                        i8++;
                                    } catch (Throwable th64) {
                                        Throwable cause49 = th64.getCause();
                                        if (cause49 != null) {
                                            throw cause49;
                                        }
                                        throw th64;
                                    }
                                }
                                i7++;
                                length = length;
                                r10 = r10;
                            } catch (Throwable th65) {
                                Throwable cause50 = th65.getCause();
                                if (cause50 != null) {
                                    throw cause50;
                                }
                                throw th65;
                            }
                        }
                        r10 = r9;
                        ?? r212 = r10;
                        try {
                            try {
                                try {
                                    if (i8 > 0) {
                                        int i24111 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                        int i24112 = ((i24111 | 25) << 1) - (i24111 ^ 25);
                                        artificialFrame = i24112 % 128;
                                        int i24113 = i24112 % 2;
                                        strArr3 = new String[1][];
                                        int iCurrentTimeMillis3 = ((int) System.currentTimeMillis()) ^ 343337308;
                                        int i24114 = ~iCurrentTimeMillis3;
                                        i32 = ~r12;
                                        try {
                                            Object[] objArr5111 = {Integer.valueOf((r12 & i24114) | (iCurrentTimeMillis3 & i32)), bArr, Integer.valueOf(i8), Integer.valueOf(i2), strArr3};
                                            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1514071993);
                                            if (objAccessartificialFrame3 == null) {
                                                int iAxisFromString3 = MotionEvent.axisFromString("") + 22;
                                                char capsMode4 = (char) TextUtils.getCapsMode("", 0, 0);
                                                int fadingEdgeLength3 = (ViewConfiguration.getFadingEdgeLength() >> 16) + 465;
                                                byte b13 = $$a[11];
                                                byte b14 = b13;
                                                Object[] objArr6110 = new Object[1];
                                                b(b13, b14, (byte) (b14 + 1), objArr6110);
                                                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(iAxisFromString3, capsMode4, fadingEdgeLength3, 983850575, false, (String) objArr6110[0], new Class[]{Integer.TYPE, byte[][].class, Integer.TYPE, Integer.TYPE, String[][].class});
                                            }
                                            long jLongValue5 = ((Long) ((Method) objAccessartificialFrame3).invoke(null, objArr5111)).longValue();
                                            long j114 = -614106746;
                                            long j115 = 371;
                                            long j116 = (j115 * j114) + (j115 * jLongValue5);
                                            long j117 = -370;
                                            long j118 = -1;
                                            long j119 = jLongValue5 ^ j118;
                                            long j23 = (long) r12;
                                            long j24 = j23 ^ j118;
                                            long j25 = j114 ^ j118;
                                            long j1110 = j116 + ((((j119 | j24) ^ j118) | ((j25 | j23) ^ j118)) * j117);
                                            long j1111 = ((j25 | j24) ^ j118) | ((j119 | j23) ^ j118);
                                            long j1112 = j118 ^ (jLongValue5 | j114);
                                            long j1113 = j1110 + (j117 * (j1111 | j1112)) + (((long) 370) * j1112) + ((long) (-1348107944));
                                            int i24115 = (int) (j1113 >> 32);
                                            int iNextInt4 = new Random().nextInt(426611332);
                                            int i24116 = ~iNextInt4;
                                            int i24117 = i24115 & (1612427114 + (((~(i24116 | 1695351675)) | (~(258125264 | i24116)) | (-1869590524)) * 464) + (((-1611465260) | iNextInt4) * (-464)) + (((~(iNextInt4 | 1695351675)) | (-1869590524)) * 464));
                                            int iElapsedRealtime3 = (int) SystemClock.elapsedRealtime();
                                            int i24118 = ((int) j1113) & (2088992125 + ((1993845722 | iElapsedRealtime3) * 376) + (((~((~iElapsedRealtime3) | 415170360)) | 1715536066) * (-376)) + (((~(iElapsedRealtime3 | (-415170361))) | (-1852396771)) * 376));
                                            int i24119 = (i24118 & i24117) | (i24117 ^ i24118);
                                            i33 = ((~i24119) & iCurrentTimeMillis3) | (i24119 & i24114);
                                            if ((i2 & 1) == 1 || ((i33 & i32) | (((~i33) & r12) == true ? 1 : 0)) != 15) {
                                                if (((~((i33 & r12) == true ? 1 : 0)) & ((i33 | r12) == true ? 1 : 0)) != 17) {
                                                    objArr6 = new Object[]{new int[]{i33}, strArr3[0], new int[]{(i2714 | i2715) & (~(i2714 & i2715))}, new int[]{r12}};
                                                    int i26110 = (-461147299) + (((~(i32 | 300314338)) | 135368708) * (-160)) + ((300314338 | (~(139964612 | i32))) * SyslogConstants.LOG_LOCAL4);
                                                    int i26111 = (i26110 & 16) + (i26110 | 16);
                                                    int i27110 = (i3 & i26111) + (i3 | i26111);
                                                    int i27111 = i27110 << 13;
                                                    int i27112 = (i27111 | i27110) & (~(i27110 & i27111));
                                                    int i27113 = i27112 >>> 17;
                                                    int i27114 = (i27112 | i27113) & (~(i27112 & i27113));
                                                    int i27115 = i27114 << 5;
                                                } else {
                                                    i34 = (i33 & i32) | (((~i33) & r12) == true ? 1 : 0);
                                                    if (i34 == 0) {
                                                        objArr = new Object[]{new int[]{i33}, null, new int[]{(i2516 | i2517) & (~(i2516 & i2517))}, new int[]{r12}};
                                                        int i25110 = (~(215522247 | i32)) | 304562208;
                                                        int i25111 = ~((-144212483) | r12);
                                                        int i25112 = -(-((((i25110 | i25111) * (-252)) - 399385187) + ((i25111 | (~(520084455 | i32))) * 252)));
                                                        int i25113 = ((i3 | i25112) << 1) - (i3 ^ i25112);
                                                        int i25114 = i25113 << 13;
                                                        int i25115 = (i25114 & (~i25113)) | ((~i25114) & i25113);
                                                        int i25116 = i25115 ^ (i25115 >>> 17);
                                                        int i25117 = i25116 << 5;
                                                        break;
                                                    }
                                                    if (i34 == 11) {
                                                        objArr6 = new Object[]{new int[]{i33}, strArr3[0], new int[1], new int[]{r12}};
                                                        int startElapsedRealtime7 = (int) Process.getStartElapsedRealtime();
                                                        int i25118 = 915255893 + ((~(startElapsedRealtime7 | 280763409)) * JfifUtil.MARKER_SOI);
                                                        int i25119 = ~startElapsedRealtime7;
                                                        int i26112 = i25118 + ((398286323 | i25119) * (-216)) + (((~(i25119 | 280763409)) | (-120413684)) * JfifUtil.MARKER_SOI);
                                                        int i26113 = -(-(((i26112 | 16) << 1) - (i26112 ^ 16)));
                                                        int i26114 = ((i3 | i26113) << 1) - (i3 ^ i26113);
                                                        int i26115 = i26114 << 13;
                                                        int i26116 = (i26115 & (~i26114)) | ((~i26115) & i26114);
                                                        int i26117 = i26116 >>> 17;
                                                        int i26118 = (i26116 | i26117) & (~(i26116 & i26117));
                                                        int i26119 = i26118 << 5;
                                                        ((int[]) objArr6[2])[0] = (i26118 | i26119) & (~(i26118 & i26119));
                                                    }
                                                }
                                                return objArr6;
                                            }
                                            objArr2 = new Object[4];
                                            objArr2[0] = new int[]{i33};
                                            objArr2[2] = new int[1];
                                            objArr2[3] = new int[]{r12};
                                            int startElapsedRealtime8 = (int) Process.getStartElapsedRealtime();
                                            int i480 = (-542634236) + ((~(922737655 | startElapsedRealtime8)) * 623) + (((~startElapsedRealtime8) | 537663761) * (-623)) + (((~(startElapsedRealtime8 | 810375571)) | (~(650025845 | startElapsedRealtime8)) | (-922737656)) * 623) + 16;
                                            int i481 = (i3 ^ i480) + ((i3 & i480) << 1);
                                            int i482 = getARTIFICIAL_FRAME_PACKAGE_NAME + 117;
                                            artificialFrame = i482 % 128;
                                            int i483 = i482 % 2;
                                            int i484 = i481 << 13;
                                            int i485 = ((~i481) & i484) | ((~i484) & i481);
                                            int i486 = i485 >>> 17;
                                            int i487 = (i485 | i486) & (~(i485 & i486));
                                            int i488 = i487 << 5;
                                            ((int[]) objArr2[2])[0] = (i487 | i488) & (~(i487 & i488));
                                            objArr2[1] = null;
                                            return objArr2;
                                        } catch (Throwable th66) {
                                            Throwable cause51 = th66.getCause();
                                            if (cause51 != null) {
                                                throw cause51;
                                            }
                                            throw th66;
                                        }
                                    }
                                    str9 = "";
                                    Object[] objArr6111 = {cls112.getMethod((String) objArr615[0], null).invoke(context, null), 64};
                                    int i27116 = -(-(ViewConfiguration.getMaximumDrawingCacheSize() >> 24));
                                    Object[] objArr6112 = new Object[1];
                                    c((i27116 ^ 33) + ((i27116 & 33) << 1), new int[]{-553959009, 1566372400, 2145491739, -1796016629, 1015558550, -1808814313, 600618822, -1854666632, 1964086842, 560341688, 1888163075, 733288094, -1442994014, 479450140, -1807369700, 802064978, 1132699382, -1559291025}, objArr6112);
                                    Class<?> cls1110 = Class.forName((String) objArr6112[0]);
                                    Object[] objArr6113 = new Object[1];
                                    c(Process.getGidForName(str9) + 15, new int[]{2095174662, 1254976582, 1888163075, 733288094, -1833489099, 842928759, -2083258904, -518269280}, objArr6113);
                                    objInvoke = cls1110.getMethod((String) objArr6113[0], String.class, Integer.TYPE).invoke(objInvoke25, objArr6111);
                                    linkedHashSet = new LinkedHashSet();
                                    ?? r213 = r212;
                                    length2 = r213.length;
                                    i10 = 0;
                                    r13 = r213;
                                    while (i10 < length2) {
                                        r5 = r13[i10];
                                        try {
                                            Object[] objArr6114 = new Object[1];
                                            c(((Process.getThreadPriority(0) + 20) >> 6) + 15, new int[]{-1126508594, -1707955208, -1985443438, 137225525, 1597574327, 2041802794, -1595502793, 1282537579}, objArr6114);
                                            cls = Class.forName((String) objArr6114[0]);
                                            objArr3 = new Object[1];
                                            a(new byte[]{1, 1, 1, 0, 0, 1, 1, 0}, new int[]{186, 8, 0, 0}, true, objArr3);
                                            if (((Integer) cls.getMethod((String) objArr3[0], null).invoke(r5, null)).intValue() == 4) {
                                                int iResolveSizeAndState3 = View.resolveSizeAndState(0, 0, 0);
                                                int iIPostMessageService114 = Lists.TransformingRandomAccessList.AnonymousClass1.IPostMessageService();
                                                int i28110 = ~iIPostMessageService114;
                                                int i28111 = ~(((-8) & i28110) | ((-8) ^ i28110));
                                                int i28112 = ~((iResolveSizeAndState3 ^ iIPostMessageService114) | (iResolveSizeAndState3 & iIPostMessageService114));
                                                int i28113 = ((iResolveSizeAndState3 * 960) - 13419) + (((i28111 & i28112) | (i28111 ^ i28112)) * 959) + 7672;
                                                int i28114 = ((~((iIPostMessageService114 & (-8)) | ((-8) ^ iIPostMessageService114))) | (~((iResolveSizeAndState3 & i28110) | (i28110 ^ iResolveSizeAndState3)))) * 959;
                                                Object[] objArr7110 = new Object[1];
                                                c(((i28113 | i28114) << 1) - (i28114 ^ i28113), new int[]{1927792283, -663241186, -520769080, -90225899}, objArr7110);
                                                obj2 = objArr7110[0];
                                            } else {
                                                int i28115 = -View.combineMeasuredStates(0, 0);
                                                Object[] objArr7111 = new Object[1];
                                                c(((i28115 | 3) << 1) - (i28115 ^ 3), new int[]{-2028639001, 1564982371}, objArr7111);
                                                obj2 = objArr7111[0];
                                            }
                                            str = (String) obj2;
                                            int i28116 = -(ViewConfiguration.getKeyRepeatTimeout() >> 16);
                                            Object[] objArr7112 = new Object[1];
                                            c(((i28116 | 30) << 1) - (i28116 ^ 30), new int[]{-553959009, 1566372400, 2145491739, -1796016629, 1015558550, -1808814313, 600618822, -1854666632, 1964086842, 560341688, 1888163075, 733288094, -1833489099, 842928759, -2083258904, -518269280}, objArr7112);
                                            Class<?> cls1111 = Class.forName((String) objArr7112[0]);
                                            Object[] objArr7113 = new Object[1];
                                            a(null, new int[]{211, 10, 67, 3}, true, objArr7113);
                                            objArr4 = (Object[]) cls1111.getField((String) objArr7113[0]).get(objInvoke);
                                            length3 = objArr4.length;
                                            i12 = 0;
                                            r14 = r13;
                                            while (i12 < length3) {
                                                int i28117 = artificialFrame;
                                                i13 = (i28117 & 101) + (i28117 | 101);
                                                getARTIFICIAL_FRAME_PACKAGE_NAME = i13 % 128;
                                                if (i13 % 2 != 0) {
                                                    Object obj210 = objArr4[i12];
                                                    throw null;
                                                }
                                                Object obj211 = objArr4[i12];
                                                try {
                                                    obj3 = objInvoke;
                                                    i14 = length2;
                                                    Object[] objArr7114 = new Object[1];
                                                    c(View.MeasureSpec.getMode(0) + 27, new int[]{-1126508594, -1707955208, -1142011696, -607183002, -2037064201, -1876888749, 1899525521, 1645533664, 762759276, 1112811353, 268823455, 1793814410, -2789657, -403136695}, objArr7114);
                                                    str2 = str7;
                                                    Object objInvoke27 = Class.forName((String) objArr7114[0]).getMethod(str2, String.class).invoke(null, str);
                                                    try {
                                                        Object[] objArr7115 = new Object[1];
                                                        a(new byte[]{1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1}, new int[]{221, 28, 0, 0}, true, objArr7115);
                                                        Class<?> cls1112 = Class.forName((String) objArr7115[0]);
                                                        int i28118 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                                        int i28119 = (i28118 & 45) + (i28118 | 45);
                                                        artificialFrame = i28119 % 128;
                                                        int i29110 = i28119 % 2;
                                                        int i29111 = (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                                                        int iIPostMessageService115 = Lists.TransformingRandomAccessList.AnonymousClass1.IPostMessageService();
                                                        str3 = str;
                                                        int i29112 = ~i29111;
                                                        i15 = length3;
                                                        int i29113 = ~iIPostMessageService115;
                                                        int i29114 = ((i29111 * 866) - 9504) + (((-12) | (~((i29112 ^ i29113) | (i29112 & i29113)))) * (-865));
                                                        int i29115 = (~(i29111 | iIPostMessageService115)) * 865;
                                                        int i29116 = (i29114 & i29115) + (i29115 | i29114);
                                                        int i29117 = ~iIPostMessageService115;
                                                        int i29118 = ~((i29117 & (-12)) | ((-12) ^ i29117));
                                                        int i29119 = ~(i29113 | i29111);
                                                        int i30110 = -(-(((i29118 & i29119) | (i29118 ^ i29119)) * 865));
                                                        Object[] objArr7116 = new Object[1];
                                                        c((i29116 ^ i30110) + ((i29116 & i30110) << 1), new int[]{-385849482, 2145409738, 1740005207, -1640331511, 503494999, 1098140876}, objArr7116);
                                                        try {
                                                            Object[] objArr7117 = {cls1112.getMethod((String) objArr7116[0], null).invoke(obj211, null)};
                                                            int i30111 = -(ViewConfiguration.getTouchSlop() >> 8);
                                                            int iIPostMessageService116 = Lists.TransformingRandomAccessList.AnonymousClass1.IPostMessageService();
                                                            int i30112 = i30111 * (-1965);
                                                            int i30113 = (((i30112 | 26568) << 1) - (i30112 ^ 26568)) + (((i30111 ^ (-28)) | (i30111 & (-28))) * 983);
                                                            int i30114 = ~i30111;
                                                            int i30115 = ~iIPostMessageService116;
                                                            int i30116 = ~(((-28) & i30115) | ((-28) ^ i30115));
                                                            int i30117 = i30113 + (((i30116 & i30114) | (i30114 ^ i30116)) * (-983));
                                                            int i30118 = ((~((~i30111) | 27)) | (~((i30115 & i30114) | (i30114 ^ i30115)))) * 983;
                                                            Object[] objArr7118 = new Object[1];
                                                            c((i30117 & i30118) + (i30118 | i30117), new int[]{-1126508594, -1707955208, -1142011696, -607183002, -2037064201, -1876888749, 1899525521, 1645533664, 762759276, 1112811353, 268823455, 1793814410, -2789657, -403136695}, objArr7118);
                                                            Class<?> cls1113 = Class.forName((String) objArr7118[0]);
                                                            Object[] objArr7119 = new Object[1];
                                                            a(new byte[]{0, 1, 0, 0, 0, 1}, new int[]{249, 6, 0, 0}, true, objArr7119);
                                                            try {
                                                                Object[] objArr8110 = {cls1113.getMethod((String) objArr7119[0], byte[].class).invoke(objInvoke27, objArr7117)};
                                                                Class<?> cls1114 = Class.forName(str10);
                                                                int i30119 = (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
                                                                Object[] objArr8111 = new Object[1];
                                                                c((i30119 & 3) + (i30119 | 3), new int[]{1799158074, -1917480941}, objArr8111);
                                                                objInvoke2 = cls1114.getMethod((String) objArr8111[0], byte[].class).invoke(null, objArr8110);
                                                                int i31110 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                                                int i31111 = (i31110 & 101) + (i31110 | 101);
                                                                artificialFrame = i31111 % 128;
                                                                int i31112 = i31111 % 2;
                                                                try {
                                                                    cls2 = Class.forName(str10);
                                                                    i16 = (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                                                                    int i31113 = artificialFrame + 93;
                                                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i31113 % 128;
                                                                    int i31114 = i31113 % 2;
                                                                    iIPostMessageService = Lists.TransformingRandomAccessList.AnonymousClass1.IPostMessageService();
                                                                    int i31115 = i16 * 755;
                                                                    int i31116 = (i31115 & (-9036)) + (i31115 | (-9036));
                                                                    i17 = ~i16;
                                                                    int i31117 = ~((i17 ^ 12) | (i17 & 12));
                                                                    i18 = ~i16;
                                                                    r31 = r14;
                                                                    int i31118 = ~((i18 ^ iIPostMessageService) | (i18 & iIPostMessageService));
                                                                    int i31119 = (i31117 ^ i31118) | (i31118 & i31117);
                                                                    int i32110 = ~(iIPostMessageService | 12);
                                                                    i19 = i31116 + (((i31119 ^ i32110) | (i31119 & i32110)) * (-754));
                                                                    int i32111 = artificialFrame;
                                                                    i20 = ((i32111 | 85) << 1) - (i32111 ^ 85);
                                                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i20 % 128;
                                                                    if (i20 % 2 != 0) {
                                                                        throw null;
                                                                    }
                                                                    int i32112 = (i17 ^ 12) | (i17 & 12);
                                                                    int i32113 = ~((i32112 & iIPostMessageService) | (i32112 ^ iIPostMessageService));
                                                                    int i32114 = ~iIPostMessageService;
                                                                    int i32115 = ~((i16 & i32114) | (i32114 ^ i16) | 12);
                                                                    int i32116 = (i19 - (~((-754) * ((i32115 & i32113) | (i32113 ^ i32115))))) - 1;
                                                                    int i32117 = ~iIPostMessageService;
                                                                    int i32118 = ((i32117 & i18) | (i18 ^ i32117)) * 754;
                                                                    Object[] objArr8112 = new Object[1];
                                                                    c(((i32116 | i32118) << 1) - (i32118 ^ i32116), new int[]{2143351903, -982766959, -1780750661, -446571346, -967477501, 352953536}, objArr8112);
                                                                    objInvoke3 = cls2.getMethod((String) objArr8112[0], null).invoke(objInvoke2, null);
                                                                    if (objInvoke3 != null) {
                                                                        string = str9;
                                                                        i22 = 0;
                                                                        while (true) {
                                                                            int i32119 = artificialFrame;
                                                                            i23 = (i32119 ^ 119) + ((i32119 & 119) << 1);
                                                                            getARTIFICIAL_FRAME_PACKAGE_NAME = i23 % 128;
                                                                            if (i23 % 2 != 0) {
                                                                                try {
                                                                                    i24 = (TypedValue.complexToFraction(1, 0.0f, 1.0f) > 2.0f ? 1 : (TypedValue.complexToFraction(1, 0.0f, 1.0f) == 2.0f ? 0 : -1));
                                                                                    i25 = 121;
                                                                                } catch (Throwable th67) {
                                                                                    Throwable cause52 = th67.getCause();
                                                                                    if (cause52 != null) {
                                                                                        throw cause52;
                                                                                    }
                                                                                    throw th67;
                                                                                }
                                                                            } else {
                                                                                i24 = (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                                                                                i25 = 15;
                                                                            }
                                                                            int i33110 = i24 * (-515);
                                                                            int i33111 = i25 * 517;
                                                                            int i33112 = ((i33110 | i33111) << 1) - (i33110 ^ i33111);
                                                                            int i33113 = ~i25;
                                                                            int i33114 = ~(((i33113 & r12) == true ? 1 : 0) | ((i33113 ^ r12) == true ? 1 : 0));
                                                                            int i33115 = ~r12;
                                                                            int i33116 = ~(i33115 | i24);
                                                                            int i33117 = (i33114 ^ i33116) | (i33116 & i33114);
                                                                            int i33118 = ~r12;
                                                                            int i33119 = (i33117 | (~(i33118 | i25))) * (-516);
                                                                            int i34110 = (i33112 & i33119) + (i33112 | i33119);
                                                                            i21 = i10;
                                                                            int i34111 = ~((((~i25) | (~i24)) | r12) == true ? 1 : 0);
                                                                            int i34112 = ~i24;
                                                                            int i34113 = ~((i34112 ^ i33118) | (i34112 & i33118) | i25);
                                                                            int i34114 = (i34110 - (~(((i34111 ^ i34113) | (i34111 & i34113)) * 516))) - 1;
                                                                            int i34115 = ~((i34112 ^ i25) | (i34112 & i25));
                                                                            int i34116 = ~((i33115 ^ i25) | (i33115 & i25));
                                                                            i26 = i34114 + (((i34115 & i34116) | (i34115 ^ i34116)) * 516);
                                                                            iArr = new int[]{-1126508594, -1707955208, -1985443438, 137225525, 1597574327, 2041802794, -1595502793, 1282537579};
                                                                            int i34117 = ~((447519814 & i33118) | (447519814 ^ i33118));
                                                                            int i34118 = (-133649860) + (((i34117 & (-2083834278)) | ((-2083834278) ^ i34117)) * (-602));
                                                                            int i34119 = ~((447519814 ^ r12) | (447519814 & r12));
                                                                            int i35110 = ((-2126306792) ^ i34119) | ((-2126306792) & i34119);
                                                                            int i35111 = (i33118 ^ (-447519815)) | (i33118 & (-447519815));
                                                                            int i35112 = ~((i35111 ^ (-2083834278)) | (i35111 & (-2083834278)));
                                                                            int i35113 = ((i35110 ^ i35112) | (i35110 & i35112)) * (-301);
                                                                            int i35114 = ((i34118 | i35113) << 1) - (i35113 ^ i34118);
                                                                            int i35115 = -(-((~(i33115 | (-2083834278))) * 301));
                                                                            i27 = (i35114 ^ i35115) + ((i35115 & i35114) << 1);
                                                                            int iIPostMessageService117 = Lists.TransformingRandomAccessList.AnonymousClass1.IPostMessageService();
                                                                            int i35116 = ~iIPostMessageService117;
                                                                            int i35117 = ~((1860031814 ^ i35116) | (1860031814 & i35116));
                                                                            int i35118 = ~iIPostMessageService117;
                                                                            int i35119 = ~((351527308 ^ i35118) | (351527308 & i35118));
                                                                            int i36110 = -(-(((i35117 ^ i35119) | (i35119 & i35117)) * (-867)));
                                                                            int i36111 = ((217061680 | i36110) << 1) - (i36110 ^ 217061680);
                                                                            int i36112 = ~(1860031814 | iIPostMessageService117);
                                                                            int i36113 = ((-2130703823) ^ i36112) | (i36112 & (-2130703823));
                                                                            int i36114 = ~((351527308 ^ iIPostMessageService117) | (351527308 & iIPostMessageService117));
                                                                            i28 = i36111 + (((i36113 ^ i36114) | (i36113 & i36114)) * (-1734));
                                                                            int i36115 = ~((i35116 & 2130703822) | (2130703822 ^ i35116));
                                                                            int i36116 = ~(((-270672009) & iIPostMessageService117) | ((-270672009) ^ iIPostMessageService117));
                                                                            i29 = -(-(((~((iIPostMessageService117 & (-1779176515)) | ((-1779176515) ^ iIPostMessageService117))) | (i36115 & i36116) | (i36115 ^ i36116)) * 867));
                                                                            if (i27 > ((i28 | i29) << 1) - (i28 ^ i29)) {
                                                                                Object[] objArr8113 = new Object[1];
                                                                                c(i26, iArr, objArr8113);
                                                                                Class<?> cls1115 = Class.forName((String) objArr8113[0]);
                                                                                Object[] objArr8114 = new Object[1];
                                                                                a(new byte[]{1, 1, 0, 0, 1}, new int[]{170, 5, 43, 0}, false, objArr8114);
                                                                                method = cls1115.getMethod((String) objArr8114[0], null);
                                                                                objArr5 = null;
                                                                            } else {
                                                                                Object[] objArr8115 = new Object[1];
                                                                                c(i26, iArr, objArr8115);
                                                                                Class<?> cls212 = Class.forName((String) objArr8115[0]);
                                                                                Object[] objArr8116 = new Object[1];
                                                                                a(new byte[]{1, 1, 0, 0, 1}, new int[]{170, 5, 43, 0}, true, objArr8116);
                                                                                objArr5 = null;
                                                                                method = cls212.getMethod((String) objArr8116[0], null);
                                                                            }
                                                                            if (i22 >= ((Integer) method.invoke(objInvoke3, objArr5)).intValue()) {
                                                                                break;
                                                                            }
                                                                            StringBuilder sb6 = new StringBuilder();
                                                                            sb6.append(string);
                                                                            int i36117 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                                                            i30 = (i36117 & AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY) + (i36117 | AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY);
                                                                            artificialFrame = i30 % 128;
                                                                            if (i30 % 2 == 0) {
                                                                                i31 = 0;
                                                                                int i36118 = 21 / 0;
                                                                            } else {
                                                                                i31 = 0;
                                                                            }
                                                                            try {
                                                                                Object[] objArr8117 = new Object[1];
                                                                                objArr8117[i31] = Integer.valueOf(i22);
                                                                                Object[] objArr8118 = new Object[1];
                                                                                a(new byte[]{0, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1}, new int[]{i31, 19, i31, 17}, i31, objArr8118);
                                                                                Class<?> cls213 = Class.forName((String) objArr8118[i31]);
                                                                                int i36119 = -(-(ViewConfiguration.getDoubleTapTimeout() >> 16));
                                                                                Object[] objArr8119 = new Object[1];
                                                                                c((i36119 & 3) + (i36119 | 3), new int[]{1308963368, -547684839}, objArr8119);
                                                                                try {
                                                                                    Object[] objArr914 = {Long.valueOf(((Long) cls213.getMethod((String) objArr8119[0], Integer.TYPE).invoke(objInvoke3, objArr8117)).longValue())};
                                                                                    String str18 = str9;
                                                                                    int i37110 = -TextUtils.indexOf((CharSequence) str18, '0');
                                                                                    int i37111 = i37110 * 367;
                                                                                    int i37112 = (i37111 & 4771) + (i37111 | 4771);
                                                                                    int i37113 = (i37110 | 13) * (-366);
                                                                                    int i37114 = (((i37112 | i37113) << 1) - (i37113 ^ i37112)) + (((~(((-14) & r12) | ((-14) ^ r12))) | i37110) * (-366));
                                                                                    int i37115 = ~i37110;
                                                                                    int i37116 = ~((i37115 & 13) | (i37115 ^ 13));
                                                                                    int i37117 = ((-14) ^ i37110) | (i37110 & (-14));
                                                                                    int i37118 = ~((i37117 & r12) | ((i37117 ^ r12) == true ? 1 : 0));
                                                                                    int i37119 = ((i37118 & i37116) | (i37116 ^ i37118)) * 366;
                                                                                    Object[] objArr915 = new Object[1];
                                                                                    c((i37114 ^ i37119) + ((i37119 & i37114) << 1), new int[]{-1126508594, -1707955208, -856323126, 2122573174, -2076996192, -1835679048, 1552917501, 2030585986}, objArr915);
                                                                                    Class<?> cls214 = Class.forName((String) objArr915[0]);
                                                                                    Object[] objArr916 = new Object[1];
                                                                                    a(new byte[]{1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1}, new int[]{175, 11, 0, 0}, true, objArr916);
                                                                                    sb6.append((String) cls214.getMethod((String) objArr916[0], Long.TYPE).invoke(null, objArr914));
                                                                                    string = sb6.toString();
                                                                                    i22++;
                                                                                    str9 = str18;
                                                                                    i10 = i21;
                                                                                } catch (Throwable th68) {
                                                                                    Throwable cause53 = th68.getCause();
                                                                                    if (cause53 != null) {
                                                                                        throw cause53;
                                                                                    }
                                                                                    throw th68;
                                                                                }
                                                                            } catch (Throwable th69) {
                                                                                Throwable cause54 = th69.getCause();
                                                                                if (cause54 != null) {
                                                                                    throw cause54;
                                                                                }
                                                                                throw th69;
                                                                            }
                                                                        }
                                                                        str4 = str9;
                                                                    } else {
                                                                        i21 = i10;
                                                                        str4 = str9;
                                                                        string = str4;
                                                                    }
                                                                    linkedHashSet.add(string);
                                                                    if (objInvoke3.equals(r5.rewind())) {
                                                                        objArr = new Object[]{new int[]{r12}, null, new int[1], new int[]{r12}};
                                                                        int startElapsedRealtime9 = (int) Process.getStartElapsedRealtime();
                                                                        int i38110 = i3 + (-1260349191) + ((~((~startElapsedRealtime9) | (-419594243))) * (-116)) + ((587038436 | startElapsedRealtime9) * 116) + (((~(startElapsedRealtime9 | 426688710)) | 579943968) * 116);
                                                                        int i38111 = i38110 << 13;
                                                                        int i38112 = ((~i38110) & i38111) | ((~i38111) & i38110);
                                                                        int i38113 = i38112 >>> 17;
                                                                        int i38114 = ((~i38112) & i38113) | ((~i38113) & i38112);
                                                                        int i38115 = i38114 << 5;
                                                                        ((int[]) objArr[2])[0] = (i38114 | i38115) & (~(i38114 & i38115));
                                                                        break;
                                                                    }
                                                                    int i38116 = (i12 ^ 31) + ((i12 & 31) << 1);
                                                                    i12 = (i38116 & (-30)) + (i38116 | (-30));
                                                                    objInvoke = obj3;
                                                                    str = str3;
                                                                    str9 = str4;
                                                                    i10 = i21;
                                                                    length2 = i14;
                                                                    length3 = i15;
                                                                    r14 = r31;
                                                                    str7 = str2;
                                                                } catch (Throwable th70) {
                                                                    Throwable cause55 = th70.getCause();
                                                                    if (cause55 != null) {
                                                                        throw cause55;
                                                                    }
                                                                    throw th70;
                                                                }
                                                            } catch (Throwable th71) {
                                                                Throwable cause56 = th71.getCause();
                                                                if (cause56 != null) {
                                                                    throw cause56;
                                                                }
                                                                throw th71;
                                                            }
                                                        } catch (Throwable th72) {
                                                            Throwable cause57 = th72.getCause();
                                                            if (cause57 != null) {
                                                                throw cause57;
                                                            }
                                                            throw th72;
                                                        }
                                                    } catch (Throwable th73) {
                                                        Throwable cause58 = th73.getCause();
                                                        if (cause58 != null) {
                                                            throw cause58;
                                                        }
                                                        throw th73;
                                                    }
                                                } catch (Throwable th74) {
                                                    Throwable cause59 = th74.getCause();
                                                    if (cause59 != null) {
                                                        throw cause59;
                                                    }
                                                    throw th74;
                                                }
                                                objArr = new Object[]{new int[]{(~(r12 & 2)) & (r12 | 2)}, null, new int[]{((~i4012) & i4013) | ((~i4013) & i4012)}, new int[]{r12}};
                                                int i38117 = (-1761203017) + (((~(614751685 | r12)) | 8668164) * (-502)) + ((~((~r12) | 783769575)) * (-502)) + ((614751685 | (~((-775101412) | r12))) * TypedValues.PositionType.TYPE_DRAWPATH);
                                                int i38118 = 9071 - (~(i38117 * (-565)));
                                                int i38119 = ~(((-17) ^ i38117) | ((-17) & i38117));
                                                int i39110 = ~((-17) | r12);
                                                int i39111 = i38118 + (((i38119 & i39110) | (i38119 ^ i39110)) * (-566));
                                                int i39112 = ~i38117;
                                                int i39113 = (~((i39112 & 16) | (i39112 ^ 16))) * 566;
                                                int i39114 = (i39111 ^ i39113) + ((i39111 & i39113) << 1);
                                                int i39115 = ~i38117;
                                                int i39116 = (i39115 & (-17)) | ((-17) ^ i39115);
                                                int i39117 = i39114 + ((~(((i39116 & r12) == true ? 1 : 0) | ((i39116 ^ r12) == true ? 1 : 0))) * 566);
                                                int i39118 = (i3 ^ i39117) + ((i3 & i39117) << 1);
                                                int i39119 = i39118 << 13;
                                                int i40110 = (i39118 | i39119) & (~(i39118 & i39119));
                                                int i40111 = i40110 >>> 17;
                                                int i40112 = (i40110 | i40111) & (~(i40110 & i40111));
                                                int i40113 = i40112 << 5;
                                                break;
                                            }
                                            Object obj212 = objInvoke;
                                            int i40114 = i10;
                                            int i40115 = ((i40114 | WebSocketProtocol.PAYLOAD_SHORT) << 1) - (i40114 ^ WebSocketProtocol.PAYLOAD_SHORT);
                                            i10 = (i40115 ^ (-125)) + ((i40115 & (-125)) << 1);
                                            objInvoke = obj212;
                                            length2 = length2;
                                            r13 = r14;
                                            str7 = str7;
                                        } catch (Throwable th75) {
                                            Throwable cause60 = th75.getCause();
                                            if (cause60 != null) {
                                                throw cause60;
                                            }
                                            throw th75;
                                        }
                                    }
                                    int i40116 = (r12 & (-2)) | ((~r12) & 1);
                                    arrayList = new ArrayList(linkedHashSet);
                                    int size5 = arrayList.size();
                                    strArr2 = new String[(size5 & 1) + (size5 | 1)];
                                    Object[] objArr917 = new Object[1];
                                    c(4 - (~TextUtils.indexOf((CharSequence) str9, '0', 0, 0)), new int[]{1704931633, 256569062}, objArr917);
                                    strArr2[0] = (String) objArr917[0];
                                    for (i11 = 0; i11 < arrayList.size(); i11 = ((i11 & 61) + (i11 | 61)) - 60) {
                                        strArr2[(i11 & 1) + (i11 | 1)] = (String) arrayList.get(i11);
                                    }
                                    objArr2 = new Object[]{new int[]{i40116}, strArr2, new int[]{((~i4113) & i4114) | ((~i4114) & i4113)}, new int[]{r12}};
                                    int i40117 = ~(159568742 | r12);
                                    int i40118 = 447134031 + (((-780984) | i40117) * (-220)) + ((i40117 | (-160168952)) * 220) + 418830302;
                                    int i40119 = ((i3 | i40118) << 1) - (i3 ^ i40118);
                                    int i4115 = i40119 << 13;
                                    int i4116 = ((~i40119) & i4115) | ((~i4115) & i40119);
                                    int i4117 = i4116 >>> 17;
                                    int i4118 = ((~i4116) & i4117) | ((~i4117) & i4116);
                                    int i4119 = i4118 << 5;
                                    return objArr2;
                                } catch (Throwable th76) {
                                    Throwable cause61 = th76.getCause();
                                    if (cause61 != null) {
                                        throw cause61;
                                    }
                                    throw th76;
                                }
                                int i27117 = -KeyEvent.keyCodeFromString(str9);
                                Object[] objArr6115 = new Object[1];
                                c((i27117 ^ 23) + ((i27117 & 23) << 1), new int[]{-553959009, 1566372400, 2145491739, -1796016629, 1015558550, -1808814313, 600618822, -1854666632, -1584713131, -61496597, 1209812182, 1465344295}, objArr6115);
                                Class<?> cls1116 = Class.forName((String) objArr6115[0]);
                                int i27118 = -(-KeyEvent.getDeadChar(0, 0));
                                Object[] objArr6116 = new Object[1];
                                c(((i27118 | 14) << 1) - (i27118 ^ 14), new int[]{2095174662, 1254976582, 1888163075, 733288094, -1891425884, 636340184, 1854975689, 1879805549}, objArr6116);
                            } catch (Throwable th77) {
                                Throwable cause62 = th77.getCause();
                                if (cause62 != null) {
                                    throw cause62;
                                }
                                throw th77;
                            }
                            if (i9 % 2 != 0) {
                                Object[] objArr6117 = new Object[1];
                                c(10 >>> ExpandableListView.getPackedPositionGroup(1L), new int[]{-553959009, 1566372400, 2145491739, -1796016629, 1015558550, -1808814313, 600618822, -1854666632, -1584713131, -61496597, 1209812182, 1465344295}, objArr6117);
                                obj = objArr6117[0];
                            } else {
                                int i27119 = -(-ExpandableListView.getPackedPositionGroup(0L));
                                Object[] objArr6118 = new Object[1];
                                c((i27119 ^ 23) + ((i27119 & 23) << 1), new int[]{-553959009, 1566372400, 2145491739, -1796016629, 1015558550, -1808814313, 600618822, -1854666632, -1584713131, -61496597, 1209812182, 1465344295}, objArr6118);
                                obj = objArr6118[0];
                            }
                            Class<?> cls1117 = Class.forName((String) obj);
                            Object[] objArr6119 = new Object[1];
                            a(new byte[]{1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1}, new int[]{194, 17, 38, 0}, false, objArr6119);
                            Object objInvoke28 = cls1117.getMethod((String) objArr6119[0], null).invoke(context, null);
                        } catch (Throwable th78) {
                            Throwable cause63 = th78.getCause();
                            if (cause63 != null) {
                                throw cause63;
                            }
                            throw th78;
                        }
                        i9 = artificialFrame + 75;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i9 % 128;
                    } catch (Throwable unused12) {
                        objArr = new Object[]{new int[]{(~(r12 & 2)) & (r12 | 2)}, null, new int[]{((~i40112) & i40113) | ((~i40113) & i40112)}, new int[]{r12}};
                        int i381110 = (-1761203017) + (((~(614751685 | r12)) | 8668164) * (-502)) + ((~((~r12) | 783769575)) * (-502)) + ((614751685 | (~((-775101412) | r12))) * TypedValues.PositionType.TYPE_DRAWPATH);
                        int i381111 = 9071 - (~(i381110 * (-565)));
                        int i381112 = ~(((-17) ^ i381110) | ((-17) & i381110));
                        int i391110 = ~((-17) | r12);
                        int i391111 = i381111 + (((i381112 & i391110) | (i381112 ^ i391110)) * (-566));
                        int i391112 = ~i381110;
                        int i391113 = (~((i391112 & 16) | (i391112 ^ 16))) * 566;
                        int i391114 = (i391111 ^ i391113) + ((i391111 & i391113) << 1);
                        int i391115 = ~i381110;
                        int i391116 = (i391115 & (-17)) | ((-17) ^ i391115);
                        int i391117 = i391114 + ((~(((i391116 & r12) == true ? 1 : 0) | ((i391116 ^ r12) == true ? 1 : 0))) * 566);
                        int i391118 = (i3 ^ i391117) + ((i3 & i391117) << 1);
                        int i391119 = i391118 << 13;
                        int i401110 = (i391118 | i391119) & (~(i391118 & i391119));
                        int i401111 = i401110 >>> 17;
                        int i401112 = (i401110 | i401111) & (~(i401110 & i401111));
                        int i401113 = i401112 << 5;
                        break;
                    }
                }
            }
        }
        return objArr;
    }
}
