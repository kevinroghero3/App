package app.notifee.core;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.provider.Settings;
import android.support.v4.os.IResultReceiver2;
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
import androidx.constraintlayout.core.motion.utils.TypedValues;
import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.net.SyslogConstants;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.google.maps.android.ui.AnimationUtil;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import kotlin.text.Typography;
import n.o.t.i.f.e.e.k;
import o.ArtificialStackFrames;
import o.extraCallback;
import okhttp3.internal.ws.WebSocketProtocol;
import org.apache.commons.lang3.CharEncoding;
import org.apache.commons.lang3.CharUtils;

/* JADX INFO: loaded from: classes4.dex */
public class NotificationReceiverActivity extends Activity {
    private static final byte[] $$a;
    private static final int $$b;
    private static final byte[] $$d;
    private static final int $$e;
    private static char[] ArtificialStackFrames;
    private static int artificialFrame;
    private static char coroutineCreation;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME;
    private static final byte[] $$c = {Ascii.SYN, 117, 37, -99};
    private static final int $$f = SyslogConstants.LOG_LOCAL3;
    private static int $10 = 0;
    private static int $11 = 1;

    /* JADX WARN: Code duplicated, block: B:10:0x0028  */
    /* JADX WARN: Code duplicated, block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0028 -> B:11:0x002a). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0028
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$g(short r6, int r7, int r8) {
        /*
            int r6 = r6 * 2
            int r6 = 4 - r6
            int r8 = r8 * 2
            int r0 = 1 - r8
            byte[] r1 = app.notifee.core.NotificationReceiverActivity.$$c
            int r7 = r7 + 97
            byte[] r0 = new byte[r0]
            r2 = 0
            int r8 = 0 - r8
            if (r1 != 0) goto L17
            r7 = r6
            r3 = r8
            r4 = r2
            goto L2a
        L17:
            r3 = r2
            r5 = r7
            r7 = r6
            r6 = r5
        L1b:
            byte r4 = (byte) r6
            r0[r3] = r4
            int r4 = r3 + 1
            if (r3 != r8) goto L28
            java.lang.String r6 = new java.lang.String
            r6.<init>(r0, r2)
            return r6
        L28:
            r3 = r1[r7]
        L2a:
            int r3 = -r3
            int r6 = r6 + r3
            int r7 = r7 + 1
            r3 = r4
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: app.notifee.core.NotificationReceiverActivity.$$g(short, int, int):java.lang.String");
    }

    private static void b(int i, int i2, int i3, Object[] objArr) {
        int i4 = i3 + 4;
        byte[] bArr = $$a;
        int i5 = i + 65;
        byte[] bArr2 = new byte[21 - i2];
        int i6 = 20 - i2;
        int i7 = -1;
        if (bArr == null) {
            i5 += i6;
        }
        while (true) {
            i7++;
            bArr2[i7] = (byte) i5;
            i4++;
            if (i7 == i6) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            i5 += bArr[i4];
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0020  */
    /* JADX WARN: Code duplicated, block: B:8:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0020 -> B:11:0x002b). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0020
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void c(int r6, short r7, short r8, java.lang.Object[] r9) {
        /*
            int r6 = 111 - r6
            byte[] r0 = app.notifee.core.NotificationReceiverActivity.$$d
            int r8 = r8 + 4
            int r1 = 82 - r7
            byte[] r1 = new byte[r1]
            int r7 = 81 - r7
            r2 = 0
            if (r0 != 0) goto L12
            r3 = r8
            r4 = r2
            goto L2b
        L12:
            r3 = r2
        L13:
            byte r4 = (byte) r6
            r1[r3] = r4
            if (r3 != r7) goto L20
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L20:
            int r8 = r8 + 1
            r4 = r0[r8]
            int r3 = r3 + 1
            r5 = r8
            r8 = r6
            r6 = r4
            r4 = r3
            r3 = r5
        L2b:
            int r6 = -r6
            int r8 = r8 + r6
            int r6 = r8 + (-4)
            r8 = r3
            r3 = r4
            goto L13
        */
        throw new UnsupportedOperationException("Method not decompiled: app.notifee.core.NotificationReceiverActivity.c(int, short, short, java.lang.Object[]):void");
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        k.a(this, getIntent());
        finish();
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        k.a(this, intent);
        finish();
    }

    private static void a(int i, char[] cArr, byte b, Object[] objArr) throws Throwable {
        int i2;
        Object obj;
        char c;
        int i3 = 2 % 2;
        extraCallback extracallback = new extraCallback();
        char[] cArr2 = ArtificialStackFrames;
        int i4 = -1819279892;
        long j = 0;
        Object obj2 = null;
        if (cArr2 != null) {
            int i5 = $11 + 69;
            $10 = i5 % 128;
            int i6 = i5 % 2;
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            int i7 = 0;
            while (i7 < length) {
                try {
                    Object[] objArr2 = {Integer.valueOf(cArr2[i7])};
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(i4);
                    if (objAccessartificialFrame == null) {
                        int iResolveOpacity = 15 - Drawable.resolveOpacity(0, 0);
                        char cMyPid = (char) (20488 - (Process.myPid() >> 22));
                        int i8 = 2147 - (ExpandableListView.getPackedPositionForChild(0, 0) > j ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == j ? 0 : -1));
                        byte b2 = (byte) 0;
                        byte b3 = b2;
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(iResolveOpacity, cMyPid, i8, 216710116, false, $$g(b2, b3, b3), new Class[]{Integer.TYPE});
                    }
                    cArr3[i7] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                    i7++;
                    i4 = -1819279892;
                    j = 0;
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
            cArr2 = cArr3;
        }
        try {
            Object[] objArr3 = {Integer.valueOf(coroutineCreation)};
            Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1819279892);
            if (objAccessartificialFrame2 == null) {
                byte b4 = (byte) 0;
                byte b5 = b4;
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(Process.getGidForName("") + 16, (char) (20488 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1))), 2149 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), 216710116, false, $$g(b4, b5, b5), new Class[]{Integer.TYPE});
            }
            char cCharValue = ((Character) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).charValue();
            char[] cArr4 = new char[i];
            char c2 = 11;
            if (i % 2 != 0) {
                int i9 = $11 + 11;
                $10 = i9 % 128;
                int i10 = i9 % 2;
                i2 = i - 1;
                cArr4[i2] = (char) (cArr[i2] - b);
            } else {
                i2 = i;
            }
            if (i2 > 1) {
                extracallback.a = 0;
                while (extracallback.a < i2) {
                    extracallback.createBrowser = cArr[extracallback.a];
                    extracallback.c = cArr[extracallback.a + 1];
                    if (extracallback.createBrowser == extracallback.c) {
                        int i11 = $10 + 71;
                        $11 = i11 % 128;
                        int i12 = i11 % 2;
                        cArr4[extracallback.a] = (char) (extracallback.createBrowser - b);
                        cArr4[extracallback.a + 1] = (char) (extracallback.c - b);
                        obj = obj2;
                        c = c2;
                    } else {
                        Object[] objArr4 = new Object[13];
                        objArr4[12] = extracallback;
                        objArr4[c2] = Integer.valueOf(cCharValue);
                        objArr4[10] = extracallback;
                        objArr4[9] = extracallback;
                        objArr4[8] = Integer.valueOf(cCharValue);
                        objArr4[7] = extracallback;
                        objArr4[6] = extracallback;
                        objArr4[5] = Integer.valueOf(cCharValue);
                        objArr4[4] = extracallback;
                        objArr4[3] = extracallback;
                        objArr4[2] = Integer.valueOf(cCharValue);
                        objArr4[1] = extracallback;
                        objArr4[0] = extracallback;
                        Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1894223152);
                        if (objAccessartificialFrame3 == null) {
                            byte b6 = (byte) 0;
                            byte b7 = (byte) (b6 + 5);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(45 - TextUtils.indexOf((CharSequence) "", '0', 0), (char) (View.getDefaultSize(0, 0) + 58859), 2464 - View.combineMeasuredStates(0, 0), 276640984, false, $$g(b6, b7, (byte) (b7 - 5)), new Class[]{Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class});
                        }
                        if (((Integer) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).intValue() == extracallback.g) {
                            int i13 = $11 + 45;
                            $10 = i13 % 128;
                            int i14 = i13 % 2;
                            Object[] objArr5 = {extracallback, extracallback, Integer.valueOf(cCharValue), Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), Integer.valueOf(cCharValue), extracallback, Integer.valueOf(cCharValue), extracallback};
                            Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1361113423);
                            if (objAccessartificialFrame4 == null) {
                                int iMyTid = (Process.myTid() >> 22) + 24;
                                char maximumFlingVelocity = (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16);
                                int i15 = (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 792;
                                byte b8 = (byte) 0;
                                String str$$g = $$g(b8, (byte) (b8 | 8), b8);
                                c = 11;
                                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(iMyTid, maximumFlingVelocity, i15, -834291897, false, str$$g, new Class[]{Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Integer.TYPE, Object.class});
                            } else {
                                c = 11;
                            }
                            obj = null;
                            int iIntValue = ((Integer) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).intValue();
                            int i16 = (extracallback.d * cCharValue) + extracallback.g;
                            cArr4[extracallback.a] = cArr2[iIntValue];
                            cArr4[extracallback.a + 1] = cArr2[i16];
                            int i17 = $11 + 47;
                            $10 = i17 % 128;
                            int i18 = i17 % 2;
                        } else {
                            obj = null;
                            c = 11;
                            if (extracallback.b == extracallback.d) {
                                int i19 = $11 + 79;
                                $10 = i19 % 128;
                                int i20 = i19 % 2;
                                extracallback.j = ((extracallback.j + cCharValue) - 1) % cCharValue;
                                extracallback.g = ((extracallback.g + cCharValue) - 1) % cCharValue;
                                int i21 = (extracallback.b * cCharValue) + extracallback.j;
                                int i22 = (extracallback.d * cCharValue) + extracallback.g;
                                cArr4[extracallback.a] = cArr2[i21];
                                cArr4[extracallback.a + 1] = cArr2[i22];
                            } else {
                                int i23 = (extracallback.b * cCharValue) + extracallback.g;
                                int i24 = (extracallback.d * cCharValue) + extracallback.j;
                                cArr4[extracallback.a] = cArr2[i23];
                                cArr4[extracallback.a + 1] = cArr2[i24];
                            }
                        }
                    }
                    extracallback.a += 2;
                    obj2 = obj;
                    c2 = c;
                }
            }
            for (int i25 = 0; i25 < i; i25++) {
                cArr4[i25] = (char) (cArr4[i25] ^ 13722);
            }
            objArr[0] = new String(cArr4);
        } catch (Throwable th2) {
            Throwable cause2 = th2.getCause();
            if (cause2 == null) {
                throw th2;
            }
            throw cause2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0b50  */
    /* JADX WARN: Code duplicated, block: B:105:0x0c36  */
    /* JADX WARN: Code duplicated, block: B:108:0x0c80  */
    /* JADX WARN: Code duplicated, block: B:110:0x0caa  */
    /* JADX WARN: Code duplicated, block: B:112:0x0cb3  */
    /* JADX WARN: Code duplicated, block: B:114:0x0d46  */
    /* JADX WARN: Code duplicated, block: B:117:0x0d50 A[Catch: all -> 0x273a, TryCatch #5 {all -> 0x273a, blocks: (B:322:0x2438, B:324:0x245b, B:325:0x24b0, B:201:0x16ec, B:203:0x1701, B:204:0x1738, B:176:0x1424, B:178:0x1431, B:179:0x1460, B:181:0x146a, B:183:0x1477, B:184:0x14aa, B:115:0x0d4a, B:117:0x0d50, B:118:0x0d7c, B:120:0x0da6, B:121:0x0e2e), top: B:383:0x0d4a }] */
    /* JADX WARN: Code duplicated, block: B:120:0x0da6 A[Catch: all -> 0x273a, TryCatch #5 {all -> 0x273a, blocks: (B:322:0x2438, B:324:0x245b, B:325:0x24b0, B:201:0x16ec, B:203:0x1701, B:204:0x1738, B:176:0x1424, B:178:0x1431, B:179:0x1460, B:181:0x146a, B:183:0x1477, B:184:0x14aa, B:115:0x0d4a, B:117:0x0d50, B:118:0x0d7c, B:120:0x0da6, B:121:0x0e2e), top: B:383:0x0d4a }] */
    /* JADX WARN: Code duplicated, block: B:124:0x0e41  */
    /* JADX WARN: Code duplicated, block: B:129:0x0eaa  */
    /* JADX WARN: Code duplicated, block: B:133:0x0f01  */
    /* JADX WARN: Code duplicated, block: B:134:0x0f81  */
    /* JADX WARN: Code duplicated, block: B:139:0x106d  */
    /* JADX WARN: Code duplicated, block: B:142:0x10be  */
    /* JADX WARN: Code duplicated, block: B:144:0x10dd  */
    /* JADX WARN: Code duplicated, block: B:146:0x10e6  */
    /* JADX WARN: Code duplicated, block: B:149:0x11a2  */
    /* JADX WARN: Code duplicated, block: B:152:0x11a9  */
    /* JADX WARN: Code duplicated, block: B:154:0x1236  */
    /* JADX WARN: Code duplicated, block: B:160:0x1246  */
    /* JADX WARN: Code duplicated, block: B:165:0x12e2  */
    /* JADX WARN: Code duplicated, block: B:170:0x134c  */
    /* JADX WARN: Code duplicated, block: B:174:0x13a3  */
    /* JADX WARN: Code duplicated, block: B:175:0x141f  */
    /* JADX WARN: Code duplicated, block: B:178:0x1431 A[Catch: all -> 0x273a, TryCatch #5 {all -> 0x273a, blocks: (B:322:0x2438, B:324:0x245b, B:325:0x24b0, B:201:0x16ec, B:203:0x1701, B:204:0x1738, B:176:0x1424, B:178:0x1431, B:179:0x1460, B:181:0x146a, B:183:0x1477, B:184:0x14aa, B:115:0x0d4a, B:117:0x0d50, B:118:0x0d7c, B:120:0x0da6, B:121:0x0e2e), top: B:383:0x0d4a }] */
    /* JADX WARN: Code duplicated, block: B:183:0x1477 A[Catch: all -> 0x273a, TryCatch #5 {all -> 0x273a, blocks: (B:322:0x2438, B:324:0x245b, B:325:0x24b0, B:201:0x16ec, B:203:0x1701, B:204:0x1738, B:176:0x1424, B:178:0x1431, B:179:0x1460, B:181:0x146a, B:183:0x1477, B:184:0x14aa, B:115:0x0d4a, B:117:0x0d50, B:118:0x0d7c, B:120:0x0da6, B:121:0x0e2e), top: B:383:0x0d4a }] */
    /* JADX WARN: Code duplicated, block: B:190:0x15b0  */
    /* JADX WARN: Code duplicated, block: B:193:0x15fa  */
    /* JADX WARN: Code duplicated, block: B:200:0x16cf  */
    /* JADX WARN: Code duplicated, block: B:203:0x1701 A[Catch: all -> 0x273a, TryCatch #5 {all -> 0x273a, blocks: (B:322:0x2438, B:324:0x245b, B:325:0x24b0, B:201:0x16ec, B:203:0x1701, B:204:0x1738, B:176:0x1424, B:178:0x1431, B:179:0x1460, B:181:0x146a, B:183:0x1477, B:184:0x14aa, B:115:0x0d4a, B:117:0x0d50, B:118:0x0d7c, B:120:0x0da6, B:121:0x0e2e), top: B:383:0x0d4a }] */
    /* JADX WARN: Code duplicated, block: B:207:0x174f  */
    /* JADX WARN: Code duplicated, block: B:212:0x17ba  */
    /* JADX WARN: Code duplicated, block: B:216:0x1812  */
    /* JADX WARN: Code duplicated, block: B:217:0x1887  */
    /* JADX WARN: Code duplicated, block: B:219:0x1892  */
    /* JADX WARN: Code duplicated, block: B:222:0x1896  */
    /* JADX WARN: Code duplicated, block: B:231:0x19aa  */
    /* JADX WARN: Code duplicated, block: B:234:0x19f9  */
    /* JADX WARN: Code duplicated, block: B:241:0x1ad4  */
    /* JADX WARN: Code duplicated, block: B:245:0x1b5c  */
    /* JADX WARN: Code duplicated, block: B:250:0x1bd2  */
    /* JADX WARN: Code duplicated, block: B:251:0x1c18  */
    /* JADX WARN: Code duplicated, block: B:255:0x1c33  */
    /* JADX WARN: Code duplicated, block: B:256:0x1cb8  */
    /* JADX WARN: Code duplicated, block: B:261:0x1d9b  */
    /* JADX WARN: Code duplicated, block: B:264:0x1de5  */
    /* JADX WARN: Code duplicated, block: B:270:0x1ebb  */
    /* JADX WARN: Code duplicated, block: B:272:0x1ec2  */
    /* JADX WARN: Code duplicated, block: B:274:0x1f2b  */
    /* JADX WARN: Code duplicated, block: B:276:0x1f2f  */
    /* JADX WARN: Code duplicated, block: B:280:0x1f3b  */
    /* JADX WARN: Code duplicated, block: B:285:0x20a9  */
    /* JADX WARN: Code duplicated, block: B:287:0x20b2  */
    /* JADX WARN: Code duplicated, block: B:292:0x211b  */
    /* JADX WARN: Code duplicated, block: B:299:0x2178  */
    /* JADX WARN: Code duplicated, block: B:300:0x21e4  */
    /* JADX WARN: Code duplicated, block: B:302:0x21f0  */
    /* JADX WARN: Code duplicated, block: B:305:0x21f4 A[LOOP:1: B:303:0x21f1->B:305:0x21f4, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:311:0x22df  */
    /* JADX WARN: Code duplicated, block: B:314:0x232c  */
    /* JADX WARN: Code duplicated, block: B:321:0x241a  */
    /* JADX WARN: Code duplicated, block: B:324:0x245b A[Catch: all -> 0x273a, TryCatch #5 {all -> 0x273a, blocks: (B:322:0x2438, B:324:0x245b, B:325:0x24b0, B:201:0x16ec, B:203:0x1701, B:204:0x1738, B:176:0x1424, B:178:0x1431, B:179:0x1460, B:181:0x146a, B:183:0x1477, B:184:0x14aa, B:115:0x0d4a, B:117:0x0d50, B:118:0x0d7c, B:120:0x0da6, B:121:0x0e2e), top: B:383:0x0d4a }] */
    /* JADX WARN: Code duplicated, block: B:328:0x24c3  */
    /* JADX WARN: Code duplicated, block: B:333:0x252e  */
    /* JADX WARN: Code duplicated, block: B:337:0x2588  */
    /* JADX WARN: Code duplicated, block: B:338:0x2622  */
    /* JADX WARN: Code duplicated, block: B:340:0x262e  */
    /* JADX WARN: Code duplicated, block: B:343:0x2632 A[LOOP:0: B:341:0x262f->B:343:0x2632, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:399:0x18aa A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:400:0x18a2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:99:0x0aea  */
    @Override // android.app.Activity
    public void onStart() throws Throwable {
        Object[] objArr;
        String str;
        int i;
        int i2;
        Object[] objArr2;
        Long lValueOf;
        Object objAccessartificialFrame;
        int iIndexOf;
        char deadChar;
        int scrollBarFadeDuration;
        int i3;
        boolean z;
        Object obj;
        int i4;
        int i5;
        Object objAccessartificialFrame2;
        long j;
        Object objAccessartificialFrame3;
        Object objAccessartificialFrame4;
        Object[] objArr3;
        Object objAccessartificialFrame5;
        Object objAccessartificialFrame6;
        Object obj2;
        int i6;
        Object obj3;
        int i7;
        int i8;
        Object objAccessartificialFrame7;
        long j2;
        int i9;
        Context baseContext;
        Object[] objArr4;
        Object objAccessartificialFrame8;
        Object objAccessartificialFrame9;
        int i10;
        int i11;
        Object objAccessartificialFrame10;
        Object objAccessartificialFrame11;
        int i12;
        Object objAccessartificialFrame12;
        long j3;
        Object objAccessartificialFrame13;
        Object[] objArrAccessartificialFrame$78cbbd35;
        Object objAccessartificialFrame14;
        Object objAccessartificialFrame15;
        int i13;
        int i14;
        ArrayList arrayList;
        String[] strArr;
        int i15;
        int i16;
        int i17;
        Object objAccessartificialFrame16;
        long j4;
        Object objAccessartificialFrame17;
        Object objAccessartificialFrame18;
        Object[] objArr5;
        int i18;
        int i19;
        int i20;
        Object objAccessartificialFrame19;
        long j5;
        Context baseContext2;
        Object[] objArr6;
        char c;
        Object objAccessartificialFrame20;
        Object objAccessartificialFrame21;
        int i21;
        int i22;
        ArrayList arrayList2;
        String[] strArr2;
        int i23;
        int i24;
        Object objAccessartificialFrame22;
        long j6;
        Object objAccessartificialFrame23;
        Object[] objArr7;
        Object objAccessartificialFrame24;
        Object objAccessartificialFrame25;
        int i25;
        int i26;
        ArrayList arrayList3;
        String[] strArr3;
        int i27;
        Object objAccessartificialFrame26;
        Object objAccessartificialFrame27;
        int i28 = 2 % 2;
        Object[] objArr8 = new Object[1];
        a(22 - (ViewConfiguration.getJumpTapTimeout() >> 16), new char[]{CharUtils.CR, CoreConstants.SINGLE_QUOTE_CHAR, 21, CoreConstants.DASH_CHAR, CoreConstants.RIGHT_PARENTHESIS_CHAR, 19, 22, 3, '/', '!', 2, 1, 5, 24, '/', 3, '$', 31, '\f', CoreConstants.RIGHT_PARENTHESIS_CHAR, '\b', '\t'}, (byte) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 29), objArr8);
        String str2 = (String) objArr8[0];
        Object[] objArr9 = new Object[1];
        a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 11, new char[]{6, '\f', '\n', ' ', '!', '\f', 25, 3, 4, '\f', '\n', '0', 17, CoreConstants.RIGHT_PARENTHESIS_CHAR, 13877}, (byte) (55 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1))), objArr9);
        String str3 = (String) objArr9[0];
        Object[] objArr10 = new Object[1];
        a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) - 20, new char[]{25, 7, ' ', CharUtils.CR, 6, '\b', CharUtils.CR, CoreConstants.SINGLE_QUOTE_CHAR, 22, 6, 1, 4, 24, '/', 3, CoreConstants.LEFT_PARENTHESIS_CHAR}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) - 5), objArr10);
        String str4 = (String) objArr10[0];
        Object[] objArr11 = new Object[1];
        a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 19, new char[]{17, 27, 6, CoreConstants.LEFT_PARENTHESIS_CHAR, '0', 17, 3, '\n', '.', 18, 21, 19, '!', '$', 26, 3}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 90), objArr11);
        String str5 = (String) objArr11[0];
        Object objAccessartificialFrame28 = ArtificialStackFrames.accessartificialFrame(-1283093189);
        if (objAccessartificialFrame28 == null) {
            int i29 = (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 29;
            char mode = (char) (49362 - View.MeasureSpec.getMode(0));
            int iIndexOf2 = 684 - TextUtils.indexOf("", "");
            byte[] bArr = $$a;
            Object[] objArr12 = new Object[1];
            b((byte) (bArr[84] + 1), bArr[17], bArr[12], objArr12);
            objAccessartificialFrame28 = ArtificialStackFrames.coroutineCreation(i29, mode, iIndexOf2, 752929587, false, (String) objArr12[0], null);
        }
        long j7 = ((Field) objAccessartificialFrame28).getLong(null);
        if (j7 == -1 || j7 + 2033 < ((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Context baseContext3 = getBaseContext();
            if (baseContext3 == null) {
                int i30 = artificialFrame + 79;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i30 % 128;
                int i31 = i30 % 2;
                Object[] objArr13 = new Object[1];
                a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(3) - 89, new char[]{CharUtils.CR, CoreConstants.SINGLE_QUOTE_CHAR, 21, CoreConstants.DASH_CHAR, CoreConstants.RIGHT_PARENTHESIS_CHAR, 19, 22, 3, '\n', ' ', 29, 3, '\n', '\b', '0', 17, CoreConstants.RIGHT_PARENTHESIS_CHAR, 27, 3, '\n', '#', 15, '/', 0, '\n', 25}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 14), objArr13);
                Class<?> cls = Class.forName((String) objArr13[0]);
                Object[] objArr14 = new Object[1];
                a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 3, new char[]{'\b', '*', 13860, 13860, 6, CoreConstants.LEFT_PARENTHESIS_CHAR, CoreConstants.COMMA_CHAR, '\n', 13862, 13862, 20, 27, '\b', '\f', '0', 17, CoreConstants.RIGHT_PARENTHESIS_CHAR, '#'}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) + 24), objArr14);
                baseContext3 = (Context) cls.getMethod((String) objArr14[0], new Class[0]).invoke(null, null);
            }
            if (baseContext3 != null) {
                baseContext3 = ((baseContext3 instanceof ContextWrapper) && ((ContextWrapper) baseContext3).getBaseContext() == null) ? null : baseContext3.getApplicationContext();
            }
            try {
                Object[] objArr15 = {baseContext3, Integer.valueOf(((Integer) Class.forName(str4).getMethod(str5, Object.class).invoke(null, this)).intValue()), 0, -2031159690};
                byte[] bArr2 = $$d;
                Object[] objArr16 = new Object[1];
                c(bArr2[57], bArr2[72], bArr2[18], objArr16);
                Class<?> cls2 = Class.forName((String) objArr16[0]);
                byte b = bArr2[492];
                Object[] objArr17 = new Object[1];
                c(b, (byte) (b | Ascii.DC2), (short) (-bArr2[108]), objArr17);
                objArr = (Object[]) cls2.getMethod((String) objArr17[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr15);
                if (baseContext3 != null) {
                    Object objAccessartificialFrame29 = ArtificialStackFrames.accessartificialFrame(-326560385);
                    if (objAccessartificialFrame29 == null) {
                        int fadingEdgeLength = 30 - (ViewConfiguration.getFadingEdgeLength() >> 16);
                        char mode2 = (char) (49362 - View.MeasureSpec.getMode(0));
                        int keyRepeatDelay = 684 - (ViewConfiguration.getKeyRepeatDelay() >> 16);
                        byte[] bArr3 = $$a;
                        Object[] objArr18 = new Object[1];
                        b(bArr3[0], bArr3[17], bArr3[88], objArr18);
                        objAccessartificialFrame29 = ArtificialStackFrames.coroutineCreation(fadingEdgeLength, mode2, keyRepeatDelay, 1944867703, false, (String) objArr18[0], null);
                    }
                    ((Field) objAccessartificialFrame29).set(null, objArr);
                    try {
                        Long lValueOf2 = Long.valueOf(((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue());
                        Object objAccessartificialFrame30 = ArtificialStackFrames.accessartificialFrame(-1283093189);
                        if (objAccessartificialFrame30 == null) {
                            int iLastIndexOf = TextUtils.lastIndexOf("", '0', 0) + 31;
                            char c2 = (char) (49363 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)));
                            int maximumFlingVelocity = 684 - (ViewConfiguration.getMaximumFlingVelocity() >> 16);
                            byte[] bArr4 = $$a;
                            Object[] objArr19 = new Object[1];
                            b((byte) (bArr4[84] + 1), bArr4[17], bArr4[12], objArr19);
                            objAccessartificialFrame30 = ArtificialStackFrames.coroutineCreation(iLastIndexOf, c2, maximumFlingVelocity, 752929587, false, (String) objArr19[0], null);
                        }
                        ((Field) objAccessartificialFrame30).set(null, lValueOf2);
                    } catch (Exception unused) {
                        throw new RuntimeException();
                    }
                }
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        } else {
            Object objAccessartificialFrame31 = ArtificialStackFrames.accessartificialFrame(-326560385);
            if (objAccessartificialFrame31 == null) {
                int iAlpha = Color.alpha(0) + 30;
                char cGreen = (char) (49362 - Color.green(0));
                int iIndexOf3 = 683 - TextUtils.indexOf((CharSequence) "", '0', 0, 0);
                byte[] bArr5 = $$a;
                Object[] objArr20 = new Object[1];
                b(bArr5[0], bArr5[17], bArr5[88], objArr20);
                objAccessartificialFrame31 = ArtificialStackFrames.coroutineCreation(iAlpha, cGreen, iIndexOf3, 1944867703, false, (String) objArr20[0], null);
            }
            Object[] objArr21 = (Object[]) ((Field) objAccessartificialFrame31).get(null);
            objArr = new Object[]{new int[]{((int[]) objArr21[0])[0]}, new int[]{((int[]) objArr21[1])[0]}, new int[1], (String) objArr21[3]};
            int length = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 923194935;
            int i32 = 1225698534 + ((940728476 | length) * 614);
            int i33 = ~length;
            int i34 = ((i32 + ((((~((-555966166) | i33)) | 537018516) | (~(422657609 | i33))) * (-1228))) + (((~(i33 | 959676125)) | (~((-18947650) | i33))) * 614)) - 2031159690;
            int i35 = (i34 << 13) ^ i34;
            int i36 = i35 ^ (i35 >>> 17);
            ((int[]) objArr[2])[0] = i36 ^ (i36 << 5);
        }
        int i37 = ((int[]) objArr[1])[0];
        int i38 = ((int[]) objArr[0])[0];
        if (i38 == i37) {
            int i39 = ((int[]) objArr[2])[0];
            Object[] objArr22 = {new int[]{((int[]) objArr[0])[0]}, new int[]{((int[]) objArr[1])[0]}, new int[1], (String) objArr[3]};
            int layoutDirection = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().getLayoutDirection();
            int i40 = ~layoutDirection;
            int i41 = 171141950 + (((~((-39920162) | i40)) | (~(401810161 | layoutDirection))) * 520);
            int i42 = ~((-401810162) | i40);
            int i43 = ~(layoutDirection | 576813613);
            int i44 = i39 + i41 + ((i42 | i43) * (-1040)) + ((i43 | (~(i40 | (-576813614))) | 361890000) * 520);
            int i45 = (i44 << 13) ^ i44;
            int i46 = i45 ^ (i45 >>> 17);
            i = 0;
            ((int[]) objArr22[2])[0] = i46 ^ (i46 << 5);
            str = "currentApplication";
        } else {
            str = "currentApplication";
            try {
                Object[] objArr23 = {Long.valueOf(((long) (i37 ^ i38)) ^ (((long) (-2028482408)) << 32)), Long.valueOf(-2028482404)};
                byte[] bArr6 = $$d;
                Object[] objArr24 = new Object[1];
                c(bArr6[57], bArr6[25], (short) 91, objArr24);
                Class<?> cls3 = Class.forName((String) objArr24[0]);
                byte b2 = (byte) (-bArr6[1]);
                Object[] objArr25 = new Object[1];
                c(b2, (byte) (b2 + 4), (short) 157, objArr25);
                cls3.getMethod((String) objArr25[0], Long.TYPE, Long.TYPE).invoke(null, objArr23);
                int i47 = ((int[]) objArr[2])[0];
                Object[] objArr26 = {new int[]{((int[]) objArr[0])[0]}, new int[]{((int[]) objArr[1])[0]}, new int[1], (String) objArr[3]};
                int i48 = Settings.System.getInt(((Context) Class.forName("android.app.ActivityThread").getMethod(str, new Class[0]).invoke(null, null)).getContentResolver(), "screen_brightness", -1);
                int i49 = ~i48;
                int i50 = i47 + (-1796132172) + (((~(3358715 | i49)) | (~((-3154658) | i48))) * (-831)) + ((~(985137147 | i48)) * (-1662)) + (((~(i48 | (-3358716))) | (~(i49 | (-981982491))) | (~(981982490 | i48))) * 831);
                int i51 = (i50 << 13) ^ i50;
                int i52 = i51 ^ (i51 >>> 17);
                i = 0;
                ((int[]) objArr26[2])[0] = i52 ^ (i52 << 5);
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 == null) {
                    throw th2;
                }
                throw cause2;
            }
        }
        Object objAccessartificialFrame32 = ArtificialStackFrames.accessartificialFrame(-2127922582);
        if (objAccessartificialFrame32 == null) {
            int absoluteGravity = 30 - Gravity.getAbsoluteGravity(i, i);
            char maximumFlingVelocity2 = (char) ((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 49362);
            int packedPositionChild = 683 - ExpandableListView.getPackedPositionChild(0L);
            byte[] bArr7 = $$a;
            Object[] objArr27 = new Object[1];
            b((byte) (bArr7[84] + 1), bArr7[82], bArr7[49], objArr27);
            objAccessartificialFrame32 = ArtificialStackFrames.coroutineCreation(absoluteGravity, maximumFlingVelocity2, packedPositionChild, 508509282, false, (String) objArr27[0], null);
        }
        long j8 = ((Field) objAccessartificialFrame32).getLong(null);
        try {
            if (j8 != -1) {
                if (j8 + 1863 >= ((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue()) {
                    Object objAccessartificialFrame33 = ArtificialStackFrames.accessartificialFrame(777251007);
                    if (objAccessartificialFrame33 == null) {
                        int iIndexOf4 = TextUtils.indexOf("", "", 0) + 30;
                        char keyRepeatDelay2 = (char) ((ViewConfiguration.getKeyRepeatDelay() >> 16) + 49362);
                        int iMyTid = 684 - (Process.myTid() >> 22);
                        byte[] bArr8 = $$a;
                        Object[] objArr28 = new Object[1];
                        b(bArr8[64], bArr8[23], (byte) ($$b & 127), objArr28);
                        objAccessartificialFrame33 = ArtificialStackFrames.coroutineCreation(iIndexOf4, keyRepeatDelay2, iMyTid, -1321816393, false, (String) objArr28[0], null);
                    }
                    Object[] objArr29 = (Object[]) ((Field) objAccessartificialFrame33).get(null);
                    objArr2 = new Object[]{new int[]{((int[]) objArr29[0])[0]}, new int[]{((int[]) objArr29[1])[0]}, new int[1], (String) objArr29[3]};
                    int i53 = ((Context) Class.forName("android.app.ActivityThread").getMethod(str, new Class[0]).invoke(null, null)).getResources().getConfiguration().screenHeightDp;
                    int i54 = ~i53;
                    int i55 = 1445820358 + (((~((-66916018) | i54)) | 38865552) * (-1188));
                    int i56 = (~(i53 | 66916017)) | 38865552;
                    int i57 = ~(1045539792 | i54);
                    int i58 = i55 + ((i56 | i57) * 594) + (((~(66916017 | i54)) | (-1073590258) | i57) * 594) + 833468785;
                    int i59 = (i58 << 13) ^ i58;
                    int i60 = i59 ^ (i59 >>> 17);
                    ((int[]) objArr2[2])[0] = i60 ^ (i60 << 5);
                } else {
                    i2 = 0;
                }
                i4 = ((int[]) objArr2[1])[0];
                i5 = ((int[]) objArr2[0])[0];
                if (i5 == i4) {
                    int i61 = ((int[]) objArr2[2])[0];
                    Object[] objArr30 = {new int[]{((int[]) objArr2[0])[0]}, new int[]{((int[]) objArr2[1])[0]}, new int[1], (String) objArr2[3]};
                    int iIdentityHashCode = System.identityHashCode(this);
                    int i62 = (-598424452) + (((~((~iIdentityHashCode) | (-757815843))) | 537008130) * (-245));
                    int i63 = ~(iIdentityHashCode | (-757815843));
                    int i64 = i61 + i62 + (i63 * (-245)) + ((i63 | 220807932) * 245);
                    int i65 = (i64 << 13) ^ i64;
                    int i66 = i65 ^ (i65 >>> 17);
                    ((int[]) objArr30[2])[0] = i66 ^ (i66 << 5);
                } else {
                    Object[] objArr31 = {Long.valueOf(((long) (i4 ^ i5)) ^ (((long) (-1445372791)) << 32)), Long.valueOf(-1445372279)};
                    byte[] bArr9 = $$d;
                    Object[] objArr32 = new Object[1];
                    c(bArr9[57], bArr9[25], (short) 91, objArr32);
                    Class<?> cls4 = Class.forName((String) objArr32[0]);
                    byte b3 = (byte) (-bArr9[1]);
                    Object[] objArr33 = new Object[1];
                    c(b3, (byte) (b3 + 4), (short) 157, objArr33);
                    cls4.getMethod((String) objArr33[0], Long.TYPE, Long.TYPE).invoke(null, objArr31);
                    int i67 = ((int[]) objArr2[2])[0];
                    Object[] objArr34 = {new int[]{((int[]) objArr2[0])[0]}, new int[]{((int[]) objArr2[1])[0]}, new int[1], (String) objArr2[3]};
                    int iIdentityHashCode2 = System.identityHashCode(this);
                    int i68 = ~iIdentityHashCode2;
                    int i69 = i67 + 896895918 + (((~((-579710280) | i68)) | (~(936374231 | iIdentityHashCode2))) * (-831)) + ((~((-537460737) | iIdentityHashCode2)) * (-1662)) + (((~(iIdentityHashCode2 | 579710279)) | (~(i68 | (-398913496))) | (~(398913495 | iIdentityHashCode2))) * 831);
                    int i70 = (i69 << 13) ^ i69;
                    int i71 = i70 ^ (i70 >>> 17);
                    ((int[]) objArr34[2])[0] = i71 ^ (i71 << 5);
                }
                objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1168947751);
                if (objAccessartificialFrame2 == null) {
                    int i72 = (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 35;
                    char jumpTapTimeout = (char) (ViewConfiguration.getJumpTapTimeout() >> 16);
                    int iBlue = Color.blue(0) + 540;
                    byte b4 = $$a[86];
                    Object[] objArr35 = new Object[1];
                    b((byte) 47, b4, (byte) (b4 << 2), objArr35);
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(i72, jumpTapTimeout, iBlue, 624296913, false, (String) objArr35[0], null);
                }
                j = ((Field) objAccessartificialFrame2).getLong(null);
                if (j != -1) {
                    int i73 = artificialFrame + 55;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i73 % 128;
                    int i74 = i73 % 2;
                    if (j + 1855 >= ((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue()) {
                        objAccessartificialFrame27 = ArtificialStackFrames.accessartificialFrame(-1339222025);
                        if (objAccessartificialFrame27 == null) {
                            int trimmedLength = TextUtils.getTrimmedLength("") + 36;
                            char cIndexOf = (char) TextUtils.indexOf("", "", 0, 0);
                            int i75 = (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 540;
                            Object[] objArr36 = new Object[1];
                            b((byte) 47, $$a[86], (byte) 56, objArr36);
                            objAccessartificialFrame27 = ArtificialStackFrames.coroutineCreation(trimmedLength, cIndexOf, i75, 793268735, false, (String) objArr36[0], null);
                        }
                        Object[] objArr37 = (Object[]) ((Field) objAccessartificialFrame27).get(null);
                        objArr3 = new Object[]{new int[1], new int[1], new int[1]};
                        int i76 = ((int[]) objArr37[2])[0];
                        int i77 = ((int[]) objArr37[1])[0];
                        ((int[]) objArr3[2])[0] = i76;
                        ((int[]) objArr3[1])[0] = i77;
                        int i78 = (~System.identityHashCode(this)) | 756703374;
                        int i79 = 1650539338 + (i78 * 495) + (((~i78) | 554705030) * 495) + 477873935;
                        int i80 = (i79 << 13) ^ i79;
                        int i81 = i80 ^ (i80 >>> 17);
                        ((int[]) objArr3[0])[0] = i81 ^ (i81 << 5);
                    } else {
                        try {
                            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1717965552);
                            if (objAccessartificialFrame3 == null) {
                                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(View.MeasureSpec.getSize(0) + 20, (char) ((-16737700) - Color.rgb(0, 0, 0)), 982 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), 117222168, false, null, new Class[0]);
                            }
                            Object[] objArr38 = {null, ((Constructor) objAccessartificialFrame3).newInstance(null), 477873935, 0};
                            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-501205803);
                            if (objAccessartificialFrame4 == null) {
                                int mirror = 'T' - AndroidCharacter.getMirror('0');
                                char cBlue = (char) Color.blue(0);
                                int trimmedLength2 = TextUtils.getTrimmedLength("") + 540;
                                byte b5 = (byte) ($$a[110] - 1);
                                byte b6 = b5;
                                Object[] objArr39 = new Object[1];
                                b(b5, b6, (byte) (b6 | SignedBytes.MAX_POWER_OF_TWO), objArr39);
                                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(mirror, cBlue, trimmedLength2, 2101703389, false, (String) objArr39[0], new Class[]{(Class) ArtificialStackFrames.coroutineCreation(KeyEvent.getDeadChar(0, 0) + 54, (char) (834 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1))), TextUtils.getCapsMode("", 0, 0) + 576), (Class) ArtificialStackFrames.coroutineCreation('f' - AndroidCharacter.getMirror('0'), (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) - 1), 630 - TextUtils.getOffsetAfter("", 0)), Integer.TYPE, Integer.TYPE});
                            }
                            objArr3 = (Object[]) ((Method) objAccessartificialFrame4).invoke(null, objArr38);
                            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1339222025);
                            if (objAccessartificialFrame5 == null) {
                                int scrollBarFadeDuration2 = 36 - (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                                char size = (char) View.MeasureSpec.getSize(0);
                                int iLastIndexOf2 = 539 - TextUtils.lastIndexOf("", '0', 0);
                                Object[] objArr40 = new Object[1];
                                b((byte) 47, $$a[86], (byte) 56, objArr40);
                                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(scrollBarFadeDuration2, size, iLastIndexOf2, 793268735, false, (String) objArr40[0], null);
                            }
                            ((Field) objAccessartificialFrame5).set(null, objArr3);
                            try {
                                Long lValueOf3 = Long.valueOf(((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue());
                                objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1168947751);
                                if (objAccessartificialFrame6 == null) {
                                    int packedPositionType = 36 - ExpandableListView.getPackedPositionType(0L);
                                    char mirror2 = (char) ('0' - AndroidCharacter.getMirror('0'));
                                    int iLastIndexOf3 = 539 - TextUtils.lastIndexOf("", '0');
                                    byte b7 = $$a[86];
                                    Object[] objArr41 = new Object[1];
                                    b((byte) 47, b7, (byte) (b7 << 2), objArr41);
                                    objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(packedPositionType, mirror2, iLastIndexOf3, 624296913, false, (String) objArr41[0], null);
                                }
                                ((Field) objAccessartificialFrame6).set(null, lValueOf3);
                            } catch (Exception unused2) {
                                throw new RuntimeException();
                            }
                        } catch (Throwable th3) {
                            Throwable cause3 = th3.getCause();
                            if (cause3 == null) {
                                throw th3;
                            }
                            throw cause3;
                        }
                    }
                } else {
                    objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1717965552);
                    if (objAccessartificialFrame3 == null) {
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(View.MeasureSpec.getSize(0) + 20, (char) ((-16737700) - Color.rgb(0, 0, 0)), 982 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), 117222168, false, null, new Class[0]);
                    }
                    Object[] objArr310 = {null, ((Constructor) objAccessartificialFrame3).newInstance(null), 477873935, 0};
                    objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-501205803);
                    if (objAccessartificialFrame4 == null) {
                        int mirror3 = 'T' - AndroidCharacter.getMirror('0');
                        char cBlue2 = (char) Color.blue(0);
                        int trimmedLength3 = TextUtils.getTrimmedLength("") + 540;
                        byte b8 = (byte) ($$a[110] - 1);
                        byte b9 = b8;
                        Object[] objArr311 = new Object[1];
                        b(b8, b9, (byte) (b9 | SignedBytes.MAX_POWER_OF_TWO), objArr311);
                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(mirror3, cBlue2, trimmedLength3, 2101703389, false, (String) objArr311[0], new Class[]{(Class) ArtificialStackFrames.coroutineCreation(KeyEvent.getDeadChar(0, 0) + 54, (char) (834 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1))), TextUtils.getCapsMode("", 0, 0) + 576), (Class) ArtificialStackFrames.coroutineCreation('f' - AndroidCharacter.getMirror('0'), (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) - 1), 630 - TextUtils.getOffsetAfter("", 0)), Integer.TYPE, Integer.TYPE});
                    }
                    objArr3 = (Object[]) ((Method) objAccessartificialFrame4).invoke(null, objArr310);
                    objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1339222025);
                    if (objAccessartificialFrame5 == null) {
                        int scrollBarFadeDuration3 = 36 - (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                        char size2 = (char) View.MeasureSpec.getSize(0);
                        int iLastIndexOf4 = 539 - TextUtils.lastIndexOf("", '0', 0);
                        Object[] objArr42 = new Object[1];
                        b((byte) 47, $$a[86], (byte) 56, objArr42);
                        objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(scrollBarFadeDuration3, size2, iLastIndexOf4, 793268735, false, (String) objArr42[0], null);
                    }
                    ((Field) objAccessartificialFrame5).set(null, objArr3);
                    Long lValueOf4 = Long.valueOf(((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1168947751);
                    if (objAccessartificialFrame6 == null) {
                        int packedPositionType2 = 36 - ExpandableListView.getPackedPositionType(0L);
                        char mirror4 = (char) ('0' - AndroidCharacter.getMirror('0'));
                        int iLastIndexOf5 = 539 - TextUtils.lastIndexOf("", '0');
                        byte b10 = $$a[86];
                        Object[] objArr43 = new Object[1];
                        b((byte) 47, b10, (byte) (b10 << 2), objArr43);
                        objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(packedPositionType2, mirror4, iLastIndexOf5, 624296913, false, (String) objArr43[0], null);
                    }
                    ((Field) objAccessartificialFrame6).set(null, lValueOf4);
                }
                obj2 = objArr3[1];
                i6 = ((int[]) obj2)[0];
                obj3 = objArr3[2];
                i7 = ((int[]) obj3)[0];
                if (i7 == i6) {
                    Object[] objArr44 = {new int[1], new int[1], new int[1]};
                    int i82 = ((int[]) objArr3[0])[0];
                    int i83 = ((int[]) obj3)[0];
                    int i84 = ((int[]) obj2)[0];
                    ((int[]) objArr44[2])[0] = i83;
                    ((int[]) objArr44[1])[0] = i84;
                    int i85 = ((Context) Class.forName("android.app.ActivityThread").getMethod(str, new Class[0]).invoke(null, null)).getResources().getConfiguration().navigationHidden;
                    int i86 = ~i85;
                    int i87 = 1389202733 + (((~((-605045255) | i86)) | (~(741923430 | i85))) * 520);
                    int i88 = ~((-741923431) | i86);
                    int i89 = ~(i85 | 609698319);
                    int i90 = i82 + i87 + ((i88 | i89) * (-1040)) + ((i89 | (~(i86 | (-609698320))) | 136878176) * 520);
                    int i91 = (i90 << 13) ^ i90;
                    int i92 = i91 ^ (i91 >>> 17);
                    i8 = 0;
                    ((int[]) objArr44[0])[0] = i92 ^ (i92 << 5);
                } else {
                    Object[] objArr45 = {Long.valueOf(((long) (i6 ^ i7)) ^ (((long) 1203920566) << 32)), Long.valueOf(1203916470)};
                    byte[] bArr10 = $$d;
                    Object[] objArr46 = new Object[1];
                    c(bArr10[57], bArr10[25], (short) 91, objArr46);
                    Class<?> cls5 = Class.forName((String) objArr46[0]);
                    byte b11 = (byte) (-bArr10[1]);
                    Object[] objArr47 = new Object[1];
                    c(b11, (byte) (b11 + 4), (short) 157, objArr47);
                    cls5.getMethod((String) objArr47[0], Long.TYPE, Long.TYPE).invoke(null, objArr45);
                    Object[] objArr48 = {new int[1], new int[1], new int[1]};
                    int i93 = ((int[]) objArr3[0])[0];
                    int i94 = ((int[]) objArr3[2])[0];
                    int i95 = ((int[]) objArr3[1])[0];
                    ((int[]) objArr48[2])[0] = i94;
                    ((int[]) objArr48[1])[0] = i95;
                    int i96 = ~((Context) Class.forName("android.app.ActivityThread").getMethod(str, new Class[0]).invoke(null, null)).getResources().getConfiguration().keyboard;
                    int i97 = i93 + (-129589575) + ((~(1318055797 | i96)) * 52) + (((~(235777904 | i96)) | (~((-1115843846) | i96)) | 1082277893) * (-52)) + (((~(i96 | (-235777905))) | 202211952) * 52);
                    int i98 = (i97 << 13) ^ i97;
                    int i99 = i98 ^ (i98 >>> 17);
                    i8 = 0;
                    ((int[]) objArr48[0])[0] = i99 ^ (i99 << 5);
                }
                objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(1745676544);
                if (objAccessartificialFrame7 == null) {
                    int iIndexOf5 = 17 - TextUtils.indexOf("", "", i8);
                    char scrollBarSize = (char) (ViewConfiguration.getScrollBarSize() >> 8);
                    int i100 = (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 746;
                    byte b12 = $$a[86];
                    Object[] objArr49 = new Object[1];
                    b((byte) 47, b12, (byte) (b12 << 2), objArr49);
                    objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(iIndexOf5, scrollBarSize, i100, -144068856, false, (String) objArr49[0], null);
                }
                j2 = ((Field) objAccessartificialFrame7).getLong(null);
                if (j2 != -1) {
                    i9 = 0;
                    if (j2 + 1998 >= ((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue()) {
                        objAccessartificialFrame26 = ArtificialStackFrames.accessartificialFrame(1575402270);
                        if (objAccessartificialFrame26 == null) {
                            int iRed = Color.red(0) + 17;
                            char keyRepeatTimeout = (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16);
                            int capsMode = 747 - TextUtils.getCapsMode("", 0, 0);
                            Object[] objArr50 = new Object[1];
                            b((byte) 47, $$a[86], (byte) 56, objArr50);
                            objAccessartificialFrame26 = ArtificialStackFrames.coroutineCreation(iRed, keyRepeatTimeout, capsMode, -1031537386, false, (String) objArr50[0], null);
                        }
                        Object[] objArr51 = (Object[]) ((Field) objAccessartificialFrame26).get(null);
                        objArr4 = new Object[]{list, new int[1], list, new int[]{i}, new int[]{i}};
                        int i101 = ((int[]) objArr51[3])[0];
                        int i102 = ((int[]) objArr51[4])[0];
                        List list = (List) objArr51[0];
                        List list2 = (List) objArr51[2];
                        int iNextInt = new Random().nextInt(1023618577);
                        int i103 = (~((-284313307) | iNextInt)) | 270533130;
                        int i104 = ~((~iNextInt) | 334915327);
                        int i105 = (-1092999323) + ((i103 | i104) * (-470)) + (((~(iNextInt | (-13780177))) | i104) * 470) + 379948054;
                        int i106 = (i105 << 13) ^ i105;
                        int i107 = i106 ^ (i106 >>> 17);
                        ((int[]) objArr4[1])[0] = i107 ^ (i107 << 5);
                    }
                    i10 = ((int[]) objArr4[4])[0];
                    i11 = ((int[]) objArr4[3])[0];
                    if (i11 == i10) {
                        int i108 = getARTIFICIAL_FRAME_PACKAGE_NAME + 55;
                        artificialFrame = i108 % 128;
                        int i109 = i108 % 2;
                        Object[] objArr52 = {list, new int[1], list, new int[]{i}, new int[]{i}};
                        int i110 = ((int[]) objArr4[1])[0];
                        int i111 = ((int[]) objArr4[3])[0];
                        int i112 = ((int[]) objArr4[4])[0];
                        List list3 = (List) objArr4[0];
                        List list4 = (List) objArr4[2];
                        int iMaxMemory = (int) Runtime.getRuntime().maxMemory();
                        int i113 = 46644816 + (((~((~iMaxMemory) | (-3565675))) | 1468512) * (-245));
                        int i114 = ~(iMaxMemory | (-3565675));
                        int i115 = i110 + i113 + (i114 * (-245)) + ((i114 | 601882783) * 245);
                        int i116 = (i115 << 13) ^ i115;
                        int i117 = i116 ^ (i116 >>> 17);
                        i12 = 0;
                        ((int[]) objArr52[1])[0] = i117 ^ (i117 << 5);
                    } else {
                        ArrayList arrayList4 = new ArrayList();
                        Object[] objArr53 = {objArr4};
                        objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(1804664566);
                        if (objAccessartificialFrame10 == null) {
                            objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(((byte) KeyEvent.getModifierMetaStateMask()) + 42, (char) (TextUtils.getCapsMode("", 0, 0) + 12468), (-16773574) - Color.rgb(0, 0, 0), -185222914, false, "coroutineCreation", new Class[]{Object[].class});
                        }
                        arrayList4.add(((Method) objAccessartificialFrame10).invoke(null, objArr53));
                        Object[] objArr54 = {objArr4};
                        objAccessartificialFrame11 = ArtificialStackFrames.accessartificialFrame(-1243809191);
                        if (objAccessartificialFrame11 == null) {
                            objAccessartificialFrame11 = ArtificialStackFrames.coroutineCreation(AndroidCharacter.getMirror('0') - 7, (char) (12468 - ExpandableListView.getPackedPositionType(0L)), (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 3642, 716815441, false, "ArtificialStackFrames", new Class[]{Object[].class});
                        }
                        arrayList4.add(((Method) objAccessartificialFrame11).invoke(null, objArr54));
                        Object[] objArr55 = {Long.valueOf(((long) (i10 ^ i11)) ^ (((long) 783305454) << 32)), Long.valueOf(783305446)};
                        byte[] bArr11 = $$d;
                        Object[] objArr56 = new Object[1];
                        c(bArr11[57], bArr11[46], (short) 282, objArr56);
                        Class<?> cls6 = Class.forName((String) objArr56[0]);
                        byte b13 = (byte) (-bArr11[1]);
                        Object[] objArr57 = new Object[1];
                        c(b13, (byte) (b13 + 4), (short) 157, objArr57);
                        cls6.getMethod((String) objArr57[0], Long.TYPE, Long.TYPE).invoke(null, objArr55);
                        Object[] objArr58 = {list, new int[1], list, new int[]{i}, new int[]{i}};
                        int i118 = ((int[]) objArr4[1])[0];
                        int i119 = ((int[]) objArr4[3])[0];
                        int i120 = ((int[]) objArr4[4])[0];
                        List list5 = (List) objArr4[0];
                        List list6 = (List) objArr4[2];
                        int i121 = ~(((Context) Class.forName("android.app.ActivityThread").getMethod(str, new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) - 197842764);
                        int i122 = i118 + 920553229 + ((~((-42991794) | i121)) * (-783)) + (((~(i121 | 424032078)) | (-181416380)) * 783);
                        int i123 = (i122 << 13) ^ i122;
                        int i124 = i123 ^ (i123 >>> 17);
                        i12 = 0;
                        ((int[]) objArr58[1])[0] = i124 ^ (i124 << 5);
                    }
                    objAccessartificialFrame12 = ArtificialStackFrames.accessartificialFrame(-444530678);
                    if (objAccessartificialFrame12 == null) {
                        int iGreen = Color.green(i12) + 26;
                        char cMakeMeasureSpec = (char) View.MeasureSpec.makeMeasureSpec(i12, i12);
                        int iMyTid2 = (Process.myTid() >> 22) + 1041;
                        byte b14 = $$a[86];
                        Object[] objArr59 = new Object[1];
                        b((byte) 47, b14, (byte) (b14 << 2), objArr59);
                        objAccessartificialFrame12 = ArtificialStackFrames.coroutineCreation(iGreen, cMakeMeasureSpec, iMyTid2, 2061780482, false, (String) objArr59[0], null);
                    }
                    j3 = ((Field) objAccessartificialFrame12).getLong(null);
                    if (j3 != -1 || j3 + 1996 < ((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue()) {
                        int iIntValue = ((Integer) Class.forName(str4).getMethod(str5, Object.class).invoke(null, this)).intValue();
                        Object[] objArr60 = {-1569097084};
                        objAccessartificialFrame13 = ArtificialStackFrames.accessartificialFrame(-1648942878);
                        if (objAccessartificialFrame13 == null) {
                            objAccessartificialFrame13 = ArtificialStackFrames.coroutineCreation(9 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), (char) ((ViewConfiguration.getTapTimeout() >> 16) + 22251), 1033 - ((Process.getThreadPriority(0) + 20) >> 6), 47343338, false, null, new Class[]{Integer.TYPE});
                        }
                        objArrAccessartificialFrame$78cbbd35 = IResultReceiver2._Parcel.accessartificialFrame$78cbbd35(iIntValue, 0, ((Constructor) objAccessartificialFrame13).newInstance(objArr60), 252827598, false);
                        objAccessartificialFrame14 = ArtificialStackFrames.accessartificialFrame(-614804952);
                        if (objAccessartificialFrame14 == null) {
                            int iCombineMeasuredStates = View.combineMeasuredStates(0, 0) + 26;
                            char c3 = (char) (1 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)));
                            int iAlpha2 = 1041 - Color.alpha(0);
                            Object[] objArr61 = new Object[1];
                            b((byte) 47, $$a[86], (byte) 56, objArr61);
                            objAccessartificialFrame14 = ArtificialStackFrames.coroutineCreation(iCombineMeasuredStates, c3, iAlpha2, 1145017376, false, (String) objArr61[0], null);
                        }
                        ((Field) objAccessartificialFrame14).set(null, objArrAccessartificialFrame$78cbbd35);
                        try {
                            Long lValueOf5 = Long.valueOf(((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue());
                            objAccessartificialFrame15 = ArtificialStackFrames.accessartificialFrame(-444530678);
                            if (objAccessartificialFrame15 == null) {
                                int trimmedLength4 = 26 - TextUtils.getTrimmedLength("");
                                char c4 = (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                                int capsMode2 = TextUtils.getCapsMode("", 0, 0) + 1041;
                                byte b15 = $$a[86];
                                Object[] objArr62 = new Object[1];
                                b((byte) 47, b15, (byte) (b15 << 2), objArr62);
                                objAccessartificialFrame15 = ArtificialStackFrames.coroutineCreation(trimmedLength4, c4, capsMode2, 2061780482, false, (String) objArr62[0], null);
                            }
                            ((Field) objAccessartificialFrame15).set(null, lValueOf5);
                        } catch (Exception unused3) {
                            throw new RuntimeException();
                        }
                    } else {
                        Object objAccessartificialFrame34 = ArtificialStackFrames.accessartificialFrame(-614804952);
                        if (objAccessartificialFrame34 == null) {
                            int offsetBefore = TextUtils.getOffsetBefore("", 0) + 26;
                            char cCombineMeasuredStates = (char) View.combineMeasuredStates(0, 0);
                            int size3 = 1041 - View.MeasureSpec.getSize(0);
                            Object[] objArr63 = new Object[1];
                            b((byte) 47, $$a[86], (byte) 56, objArr63);
                            objAccessartificialFrame34 = ArtificialStackFrames.coroutineCreation(offsetBefore, cCombineMeasuredStates, size3, 1145017376, false, (String) objArr63[0], null);
                        }
                        Object[] objArr64 = (Object[]) ((Field) objAccessartificialFrame34).get(null);
                        objArrAccessartificialFrame$78cbbd35 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
                        int i125 = ((int[]) objArr64[3])[0];
                        int i126 = ((int[]) objArr64[2])[0];
                        String[] strArr4 = (String[]) objArr64[0];
                        int iIdentityHashCode3 = System.identityHashCode(this);
                        int i127 = ~iIdentityHashCode3;
                        int i128 = (-1320128514) + (((~((-201343777) | i127)) | 279447583) * 220) + (((~(i127 | (-201802529))) | 279906335) * (-440)) + ((iIdentityHashCode3 | (-201343777)) * 220) + 252827598;
                        int i129 = (i128 << 13) ^ i128;
                        int i130 = i129 ^ (i129 >>> 17);
                        ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0] = i130 ^ (i130 << 5);
                    }
                    i13 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
                    i14 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
                    if (i14 == i13) {
                        Object[] objArr65 = {strArr, new int[1], new int[]{i}, new int[]{i}};
                        int i131 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
                        int i132 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
                        int i133 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
                        String[] strArr5 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
                        int iIdentityHashCode4 = System.identityHashCode(this);
                        int i134 = ~iIdentityHashCode4;
                        int i135 = i131 + 831945840 + (((~(76784249 | i134)) | (~((-75530242) | iIdentityHashCode4))) * (-831)) + ((~(230418297 | iIdentityHashCode4)) * (-1662)) + (((~(iIdentityHashCode4 | (-76784250))) | (~(i134 | (-154888057))) | (~(154888056 | iIdentityHashCode4))) * 831);
                        int i136 = (i135 << 13) ^ i135;
                        int i137 = i136 ^ (i136 >>> 17);
                        ((int[]) objArr65[1])[0] = i137 ^ (i137 << 5);
                        i15 = 0;
                    } else {
                        arrayList = new ArrayList();
                        strArr = (String[]) objArrAccessartificialFrame$78cbbd35[0];
                        if (strArr != null) {
                            i16 = 0;
                            while (i16 < strArr.length) {
                                i17 = getARTIFICIAL_FRAME_PACKAGE_NAME + 91;
                                artificialFrame = i17 % 128;
                                if (i17 % 2 == 0) {
                                    arrayList.add(strArr[i16]);
                                    i16 += 88;
                                } else {
                                    arrayList.add(strArr[i16]);
                                    i16++;
                                }
                            }
                        }
                        Object[] objArr66 = objArrAccessartificialFrame$78cbbd35;
                        Object[] objArr67 = {Long.valueOf(((long) (i13 ^ i14)) ^ (((long) (-1600638879)) << 32)), Long.valueOf(-1600638877)};
                        byte[] bArr12 = $$d;
                        Object[] objArr68 = new Object[1];
                        c(bArr12[45], bArr12[452], (short) 354, objArr68);
                        Class<?> cls7 = Class.forName((String) objArr68[0]);
                        byte b16 = (byte) (-bArr12[1]);
                        Object[] objArr69 = new Object[1];
                        c(b16, (byte) (b16 + 4), (short) 157, objArr69);
                        cls7.getMethod((String) objArr69[0], Long.TYPE, Long.TYPE).invoke(null, objArr67);
                        Object[] objArr70 = {strArr, new int[1], new int[]{i}, new int[]{i}};
                        int i138 = ((int[]) objArr66[1])[0];
                        int i139 = ((int[]) objArr66[3])[0];
                        int i140 = ((int[]) objArr66[2])[0];
                        String[] strArr6 = (String[]) objArr66[0];
                        int i141 = ((Context) Class.forName("android.app.ActivityThread").getMethod(str, new Class[0]).invoke(null, null)).getResources().getConfiguration().touchscreen;
                        int i142 = ~i141;
                        int i143 = i138 + 1069043538 + (((~(243663665 | i142)) | (-531614514)) * 98) + (((~(i142 | (-321767473))) | 243663665 | (~(321767472 | i141))) * (-49)) + (((~(i141 | 243663665)) | 209847041) * 49);
                        int i144 = (i143 << 13) ^ i143;
                        int i145 = i144 ^ (i144 >>> 17);
                        i15 = 0;
                        ((int[]) objArr70[1])[0] = i145 ^ (i145 << 5);
                    }
                    objAccessartificialFrame16 = ArtificialStackFrames.accessartificialFrame(1056123296);
                    if (objAccessartificialFrame16 == null) {
                        int iAlpha3 = 30 - Color.alpha(i15);
                        char cNormalizeMetaState = (char) (49362 - KeyEvent.normalizeMetaState(i15));
                        int i146 = (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 683;
                        byte[] bArr13 = $$a;
                        Object[] objArr71 = new Object[1];
                        b(bArr13[i15], bArr13[82], (byte) ($$b >>> 1), objArr71);
                        objAccessartificialFrame16 = ArtificialStackFrames.coroutineCreation(iAlpha3, cNormalizeMetaState, i146, -1583976536, false, (String) objArr71[i15], null);
                    }
                    j4 = ((Field) objAccessartificialFrame16).getLong(null);
                    if (j4 != -1 || j4 + 1927 < ((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue()) {
                        Object[] objArr72 = {Integer.valueOf(((Integer) Class.forName(str4).getMethod(str5, Object.class).invoke(null, this)).intValue()), 1109377758};
                        byte[] bArr14 = $$d;
                        byte b17 = bArr14[57];
                        byte b18 = bArr14[45];
                        Object[] objArr73 = new Object[1];
                        c(b17, b18, (short) (b18 | 408), objArr73);
                        Class<?> cls8 = Class.forName((String) objArr73[0]);
                        byte b19 = bArr14[57];
                        byte b20 = bArr14[185];
                        Object[] objArr74 = new Object[1];
                        c(b19, b20, (short) (b20 | 424), objArr74);
                        Object[] objArr75 = (Object[]) cls8.getMethod((String) objArr74[0], Integer.TYPE, Integer.TYPE).invoke(null, objArr72);
                        objAccessartificialFrame17 = ArtificialStackFrames.accessartificialFrame(910856866);
                        if (objAccessartificialFrame17 == null) {
                            int doubleTapTimeout = 30 - (ViewConfiguration.getDoubleTapTimeout() >> 16);
                            char c5 = (char) (49362 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)));
                            int threadPriority = ((Process.getThreadPriority(0) + 20) >> 6) + 684;
                            Object[] objArr76 = new Object[1];
                            b((byte) ($$b & WebSocketProtocol.PAYLOAD_SHORT), $$a[86], (byte) 96, objArr76);
                            objAccessartificialFrame17 = ArtificialStackFrames.coroutineCreation(doubleTapTimeout, c5, threadPriority, -1456483158, false, (String) objArr76[0], null);
                        }
                        ((Field) objAccessartificialFrame17).set(null, objArr75);
                        try {
                            Long lValueOf6 = Long.valueOf(((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue());
                            objAccessartificialFrame18 = ArtificialStackFrames.accessartificialFrame(1056123296);
                            if (objAccessartificialFrame18 == null) {
                                int iResolveSize = 30 - View.resolveSize(0, 0);
                                char offsetAfter = (char) (49362 - TextUtils.getOffsetAfter("", 0));
                                int i147 = (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 683;
                                byte[] bArr15 = $$a;
                                Object[] objArr77 = new Object[1];
                                b(bArr15[0], bArr15[82], (byte) ($$b >>> 1), objArr77);
                                objAccessartificialFrame18 = ArtificialStackFrames.coroutineCreation(iResolveSize, offsetAfter, i147, -1583976536, false, (String) objArr77[0], null);
                            }
                            ((Field) objAccessartificialFrame18).set(null, lValueOf6);
                            objArr5 = objArr75;
                        } catch (Exception unused4) {
                            throw new RuntimeException();
                        }
                    } else {
                        Object objAccessartificialFrame35 = ArtificialStackFrames.accessartificialFrame(910856866);
                        if (objAccessartificialFrame35 == null) {
                            int iRgb = (-16777186) - Color.rgb(0, 0, 0);
                            char scrollBarSize2 = (char) ((ViewConfiguration.getScrollBarSize() >> 8) + 49362);
                            int i148 = (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 684;
                            Object[] objArr78 = new Object[1];
                            b((byte) ($$b & WebSocketProtocol.PAYLOAD_SHORT), $$a[86], (byte) 96, objArr78);
                            objAccessartificialFrame35 = ArtificialStackFrames.coroutineCreation(iRgb, scrollBarSize2, i148, -1456483158, false, (String) objArr78[0], null);
                        }
                        Object[] objArr79 = (Object[]) ((Field) objAccessartificialFrame35).get(null);
                        objArr5 = new Object[]{new int[]{((int[]) objArr79[0])[0]}, new int[]{((int[]) objArr79[1])[0]}, new int[1], (String) objArr79[3]};
                        int i149 = ~((int) SystemClock.uptimeMillis());
                        int i150 = ((494716416 + (((~((-431510125) | i149)) | (-547113651)) * (-933))) + (((~(i149 | (-547113651))) | 537135250) * 933)) - 693624957;
                        int i151 = (i150 << 13) ^ i150;
                        int i152 = i151 ^ (i151 >>> 17);
                        ((int[]) objArr5[2])[0] = i152 ^ (i152 << 5);
                    }
                    i18 = ((int[]) objArr5[1])[0];
                    i19 = ((int[]) objArr5[0])[0];
                    if (i19 == i18) {
                        int i153 = getARTIFICIAL_FRAME_PACKAGE_NAME + 71;
                        artificialFrame = i153 % 128;
                        int i154 = i153 % 2;
                        int i155 = ((int[]) objArr5[2])[0];
                        Object[] objArr80 = {new int[]{((int[]) objArr5[0])[0]}, new int[]{((int[]) objArr5[1])[0]}, new int[1], (String) objArr5[3]};
                        int i156 = (int) Runtime.getRuntime().totalMemory();
                        int i157 = (-558569362) + (((~((-61450044) | i156)) | (-917173732)) * (-318));
                        int i158 = ~((-917173732) | i156);
                        int i159 = ~i156;
                        int i160 = i155 + i157 + ((i158 | (~(934017019 | i159))) * TypedValues.AttributesType.TYPE_PIVOT_TARGET) + (((~(i156 | 934017019)) | (~((-872566977) | i159))) * TypedValues.AttributesType.TYPE_PIVOT_TARGET);
                        int i161 = (i160 << 13) ^ i160;
                        int i162 = i161 ^ (i161 >>> 17);
                        ((int[]) objArr80[2])[0] = i162 ^ (i162 << 5);
                        i20 = 0;
                    } else {
                        new ArrayList().add((String) objArr5[3]);
                        Object[] objArr81 = {Long.valueOf(((long) (i18 ^ i19)) ^ (((long) 183072593) << 32)), Long.valueOf(183072577)};
                        byte[] bArr16 = $$d;
                        Object[] objArr82 = new Object[1];
                        c(bArr16[57], bArr16[25], (short) 91, objArr82);
                        Class<?> cls9 = Class.forName((String) objArr82[0]);
                        byte b21 = (byte) (-bArr16[1]);
                        Object[] objArr83 = new Object[1];
                        c(b21, (byte) (b21 + 4), (short) 157, objArr83);
                        cls9.getMethod((String) objArr83[0], Long.TYPE, Long.TYPE).invoke(null, objArr81);
                        int i163 = ((int[]) objArr5[2])[0];
                        Object[] objArr84 = {new int[]{((int[]) objArr5[0])[0]}, new int[]{((int[]) objArr5[1])[0]}, new int[1], (String) objArr5[3]};
                        int iIdentityHashCode5 = System.identityHashCode(this);
                        int i164 = i163 + (-11707142) + (((~(iIdentityHashCode5 | (-15899194))) | (-994522969)) * (-465)) + (((-15899194) | (~((-994522969) | iIdentityHashCode5))) * 930) + ((iIdentityHashCode5 | (-4330009)) * 465);
                        int i165 = (i164 << 13) ^ i164;
                        int i166 = i165 ^ (i165 >>> 17);
                        i20 = 0;
                        ((int[]) objArr84[2])[0] = i166 ^ (i166 << 5);
                    }
                    objAccessartificialFrame19 = ArtificialStackFrames.accessartificialFrame(1313006081);
                    if (objAccessartificialFrame19 == null) {
                        int offsetBefore2 = 21 - TextUtils.getOffsetBefore("", i20);
                        char cKeyCodeFromString = (char) KeyEvent.keyCodeFromString("");
                        int minimumFlingVelocity = (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 465;
                        byte b22 = $$a[86];
                        Object[] objArr85 = new Object[1];
                        b((byte) 47, b22, (byte) (b22 << 2), objArr85);
                        objAccessartificialFrame19 = ArtificialStackFrames.coroutineCreation(offsetBefore2, cKeyCodeFromString, minimumFlingVelocity, -785931255, false, (String) objArr85[0], null);
                    }
                    j5 = ((Field) objAccessartificialFrame19).getLong(null);
                    if (j5 != -1 || j5 + 2050 < ((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue()) {
                        baseContext2 = getBaseContext();
                        if (baseContext2 == null) {
                            Object[] objArr86 = new Object[1];
                            a(TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 27, new char[]{CharUtils.CR, CoreConstants.SINGLE_QUOTE_CHAR, 21, CoreConstants.DASH_CHAR, CoreConstants.RIGHT_PARENTHESIS_CHAR, 19, 22, 3, '\n', ' ', 29, 3, '\n', '\b', '0', 17, CoreConstants.RIGHT_PARENTHESIS_CHAR, 27, 3, '\n', '#', 15, '/', 0, '\n', 25}, (byte) ((Context) Class.forName("android.app.ActivityThread").getMethod(str, new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion, objArr86);
                            Class<?> cls10 = Class.forName((String) objArr86[0]);
                            Object[] objArr87 = new Object[1];
                            a(18 - (ViewConfiguration.getLongPressTimeout() >> 16), new char[]{'\b', '*', 13860, 13860, 6, CoreConstants.LEFT_PARENTHESIS_CHAR, CoreConstants.COMMA_CHAR, '\n', 13862, 13862, 20, 27, '\b', '\f', '0', 17, CoreConstants.RIGHT_PARENTHESIS_CHAR, '#'}, (byte) (60 - View.MeasureSpec.getSize(0)), objArr87);
                            baseContext2 = (Context) cls10.getMethod((String) objArr87[0], new Class[0]).invoke(null, null);
                        }
                        if (baseContext2 != null) {
                            if ((baseContext2 instanceof ContextWrapper) || ((ContextWrapper) baseContext2).getBaseContext() != null) {
                                baseContext2 = baseContext2.getApplicationContext();
                            } else {
                                baseContext2 = null;
                            }
                        }
                        int iIntValue2 = ((Integer) Class.forName(str4).getMethod(str5, Object.class).invoke(null, this)).intValue();
                        Object[] objArr88 = new Object[1];
                        a(((Context) Class.forName("android.app.ActivityThread").getMethod(str, new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 43, new char[]{29, '!', 24, '\b', '/', 4, 29, 21, '\t', 0, ' ', '\f', CoreConstants.COMMA_CHAR, CoreConstants.PERCENT_CHAR, 14, 29, 3, 26, 31, '\"', 30, 5, 14, 29, 25, '\b', CoreConstants.COMMA_CHAR, CoreConstants.SINGLE_QUOTE_CHAR, 22, 17, 0, '!', 29, '\"', 31, 26, 14, 29, 0, 30, '#', '\t', 29, '\"', 16, 17, '\t', '#', ' ', 7, '\b', 25, '\t', 23, ' ', '\t', '#', '\t', '\f', 4, 21, '\b', 25, CoreConstants.DASH_CHAR}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod(str, new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 56), objArr88);
                        String str6 = (String) objArr88[0];
                        Object[] objArr89 = new Object[1];
                        a(((Context) Class.forName("android.app.ActivityThread").getMethod(str, new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(0) + 27, new char[]{29, 26, 13857, 13857, 0, '!', CoreConstants.COMMA_CHAR, 23, 30, 4, 28, CoreConstants.LEFT_PARENTHESIS_CHAR, ' ', CoreConstants.COMMA_CHAR, 23, 3, CoreConstants.COMMA_CHAR, ' ', '!', 4, 7, ' ', ' ', '\f', '\t', 23, 31, '\t', 26, 31, Typography.amp, 7, ' ', '/', 13770, 13770, ' ', '\f', '\f', CoreConstants.LEFT_PARENTHESIS_CHAR, 3, '\t', 31, '\f', CoreConstants.COMMA_CHAR, CoreConstants.SINGLE_QUOTE_CHAR, 24, '\b', 25, '+', 7, ' ', CoreConstants.LEFT_PARENTHESIS_CHAR, 0, 13774, 13774, CoreConstants.SINGLE_QUOTE_CHAR, 7, 18, '+', CoreConstants.SINGLE_QUOTE_CHAR, '\t', '!', 0}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod(str, new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) - 2), objArr89);
                        Object[] objArr90 = {baseContext2, new String[]{str6, (String) objArr89[0]}, Integer.valueOf(iIntValue2), 1, 1550163612};
                        byte[] bArr17 = $$d;
                        byte b23 = bArr17[57];
                        byte b24 = bArr17[94];
                        Object[] objArr91 = new Object[1];
                        c(b23, b24, (short) (b24 | 481), objArr91);
                        Class<?> cls11 = Class.forName((String) objArr91[0]);
                        Object[] objArr92 = new Object[1];
                        c(bArr17[224], bArr17[555], (short) 214, objArr92);
                        objArr6 = (Object[]) cls11.getMethod((String) objArr92[0], Context.class, String[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr90);
                        int i167 = ((int[]) objArr6[0])[0];
                        int i168 = ((int[]) objArr6[3])[0];
                        if (baseContext2 != null) {
                            objAccessartificialFrame20 = ArtificialStackFrames.accessartificialFrame(1142731807);
                            if (objAccessartificialFrame20 == null) {
                                int trimmedLength5 = 21 - TextUtils.getTrimmedLength("");
                                char scrollDefaultDelay = (char) (ViewConfiguration.getScrollDefaultDelay() >> 16);
                                int scrollBarSize3 = 465 - (ViewConfiguration.getScrollBarSize() >> 8);
                                Object[] objArr93 = new Object[1];
                                b((byte) 47, $$a[86], (byte) 56, objArr93);
                                objAccessartificialFrame20 = ArtificialStackFrames.coroutineCreation(trimmedLength5, scrollDefaultDelay, scrollBarSize3, -612765161, false, (String) objArr93[0], null);
                            }
                            ((Field) objAccessartificialFrame20).set(null, objArr6);
                            try {
                                Long lValueOf7 = Long.valueOf(((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue());
                                objAccessartificialFrame21 = ArtificialStackFrames.accessartificialFrame(1313006081);
                                if (objAccessartificialFrame21 == null) {
                                    int touchSlop = 21 - (ViewConfiguration.getTouchSlop() >> 8);
                                    char offsetAfter2 = (char) TextUtils.getOffsetAfter("", 0);
                                    int pressedStateDuration = (ViewConfiguration.getPressedStateDuration() >> 16) + 465;
                                    byte b25 = $$a[86];
                                    Object[] objArr94 = new Object[1];
                                    b((byte) 47, b25, (byte) (b25 << 2), objArr94);
                                    objAccessartificialFrame21 = ArtificialStackFrames.coroutineCreation(touchSlop, offsetAfter2, pressedStateDuration, -785931255, false, (String) objArr94[0], null);
                                }
                                ((Field) objAccessartificialFrame21).set(null, lValueOf7);
                            } catch (Exception unused5) {
                                throw new RuntimeException();
                            }
                        }
                        c = 0;
                    } else {
                        Object objAccessartificialFrame36 = ArtificialStackFrames.accessartificialFrame(1142731807);
                        if (objAccessartificialFrame36 == null) {
                            int maximumFlingVelocity3 = (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 21;
                            char cIndexOf2 = (char) (TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 1);
                            int i169 = (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 465;
                            Object[] objArr95 = new Object[1];
                            b((byte) 47, $$a[86], (byte) 56, objArr95);
                            objAccessartificialFrame36 = ArtificialStackFrames.coroutineCreation(maximumFlingVelocity3, cIndexOf2, i169, -612765161, false, (String) objArr95[0], null);
                        }
                        Object[] objArr96 = (Object[]) ((Field) objAccessartificialFrame36).get(null);
                        objArr6 = new Object[]{new int[]{i}, strArr, new int[1], new int[]{i}};
                        int i170 = ((int[]) objArr96[3])[0];
                        int i171 = ((int[]) objArr96[0])[0];
                        String[] strArr7 = (String[]) objArr96[1];
                        int i172 = ~(System.identityHashCode(this) | (-474310432));
                        int i173 = ((((-1037395776) | i172) * (-196)) - 1337187) + ((i172 | 563085344) * 196) + 1550163612;
                        int i174 = (i173 << 13) ^ i173;
                        int i175 = i174 ^ (i174 >>> 17);
                        ((int[]) objArr6[2])[0] = i175 ^ (i175 << 5);
                        c = 0;
                    }
                    i21 = ((int[]) objArr6[c])[c];
                    i22 = ((int[]) objArr6[3])[c];
                    if (i22 == i21) {
                        Object[] objArr97 = new Object[4];
                        int[] iArr = new int[1];
                        objArr97[c] = iArr;
                        objArr97[2] = new int[1];
                        int[] iArr2 = new int[1];
                        objArr97[3] = iArr2;
                        int i176 = ((int[]) objArr6[2])[c];
                        int i177 = ((int[]) objArr6[3])[c];
                        int i178 = ((int[]) objArr6[c])[c];
                        String[] strArr8 = (String[]) objArr6[1];
                        iArr2[c] = i177;
                        iArr[c] = i178;
                        int iIdentityHashCode6 = System.identityHashCode(this);
                        int i179 = ~iIdentityHashCode6;
                        int i180 = i176 + 1757838936 + (((~((-140681629) | i179)) | (-19668098)) * (-865)) + ((~(iIdentityHashCode6 | 140681628)) * 865) + (((~((-19668098) | i179)) | (~(i179 | 140681628))) * 865);
                        int i181 = (i180 << 13) ^ i180;
                        int i182 = i181 ^ (i181 >>> 17);
                        ((int[]) objArr97[2])[0] = i182 ^ (i182 << 5);
                        objArr97[1] = strArr8;
                        i23 = 0;
                    } else {
                        arrayList2 = new ArrayList();
                        strArr2 = (String[]) objArr6[1];
                        if (strArr2 != null) {
                            for (String str7 : strArr2) {
                                arrayList2.add(str7);
                            }
                        }
                        Object[] objArr98 = {Long.valueOf(((long) (i21 ^ i22)) ^ (((long) 1235250365) << 32)), Long.valueOf(1235250429)};
                        byte[] bArr18 = $$d;
                        Object[] objArr99 = new Object[1];
                        c(bArr18[57], bArr18[358], (short) 562, objArr99);
                        Class<?> cls12 = Class.forName((String) objArr99[0]);
                        byte b26 = (byte) (-bArr18[1]);
                        Object[] objArr100 = new Object[1];
                        c(b26, (byte) (b26 + 4), (short) 157, objArr100);
                        cls12.getMethod((String) objArr100[0], Long.TYPE, Long.TYPE).invoke(null, objArr98);
                        Object[] objArr101 = {new int[]{i}, strArr, new int[1], new int[]{i}};
                        int i183 = ((int[]) objArr6[2])[0];
                        int i184 = ((int[]) objArr6[3])[0];
                        int i185 = ((int[]) objArr6[0])[0];
                        String[] strArr9 = (String[]) objArr6[1];
                        int i186 = ~Process.myPid();
                        int i187 = i183 + 720771397 + (((~(i186 | 519831146)) | (~((-702537) | i186))) * (-184)) + ((339739168 | (~((-340441705) | i186)) | (~(180091978 | i186))) * SyslogConstants.LOG_LOCAL7) + 1352080856;
                        int i188 = (i187 << 13) ^ i187;
                        int i189 = i188 ^ (i188 >>> 17);
                        i23 = 0;
                        ((int[]) objArr101[2])[0] = i189 ^ (i189 << 5);
                    }
                    super.onStart();
                    objAccessartificialFrame22 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                    if (objAccessartificialFrame22 == null) {
                        int defaultSize = View.getDefaultSize(i23, i23) + 25;
                        char cRgb = (char) (Color.rgb(i23, i23, i23) + 16807284);
                        int mode3 = 816 - View.MeasureSpec.getMode(i23);
                        byte b27 = $$a[86];
                        Object[] objArr102 = new Object[1];
                        b((byte) 47, b27, (byte) (b27 << 2), objArr102);
                        objAccessartificialFrame22 = ArtificialStackFrames.coroutineCreation(defaultSize, cRgb, mode3, 721586079, false, (String) objArr102[0], null);
                    }
                    j6 = ((Field) objAccessartificialFrame22).getLong(null);
                    if (j6 != -1 || j6 + 1962 < ((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue()) {
                        Object[] objArr103 = {Integer.valueOf(((Integer) Class.forName(str4).getMethod(str5, Object.class).invoke(null, this)).intValue()), 0, 1771123361};
                        objAccessartificialFrame23 = ArtificialStackFrames.accessartificialFrame(1327366003);
                        if (objAccessartificialFrame23 == null) {
                            int i190 = 26 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                            char cCombineMeasuredStates2 = (char) (30068 - View.combineMeasuredStates(0, 0));
                            int trimmedLength6 = 816 - TextUtils.getTrimmedLength("");
                            byte[] bArr19 = $$a;
                            Object[] objArr104 = new Object[1];
                            b(bArr19[10], bArr19[26], (byte) 104, objArr104);
                            objAccessartificialFrame23 = ArtificialStackFrames.coroutineCreation(i190, cCombineMeasuredStates2, trimmedLength6, -797394565, false, (String) objArr104[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                        }
                        objArr7 = (Object[]) ((Method) objAccessartificialFrame23).invoke(null, objArr103);
                        objAccessartificialFrame24 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                        if (objAccessartificialFrame24 == null) {
                            int scrollBarSize4 = 25 - (ViewConfiguration.getScrollBarSize() >> 8);
                            char offsetAfter3 = (char) (30068 - TextUtils.getOffsetAfter("", 0));
                            int absoluteGravity2 = Gravity.getAbsoluteGravity(0, 0) + 816;
                            Object[] objArr105 = new Object[1];
                            b((byte) 47, $$a[86], (byte) 56, objArr105);
                            objAccessartificialFrame24 = ArtificialStackFrames.coroutineCreation(scrollBarSize4, offsetAfter3, absoluteGravity2, 891606461, false, (String) objArr105[0], null);
                        }
                        ((Field) objAccessartificialFrame24).set(null, objArr7);
                        try {
                            Long lValueOf8 = Long.valueOf(((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue());
                            objAccessartificialFrame25 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                            if (objAccessartificialFrame25 == null) {
                                int edgeSlop = (ViewConfiguration.getEdgeSlop() >> 16) + 25;
                                char longPressTimeout = (char) (30068 - (ViewConfiguration.getLongPressTimeout() >> 16));
                                int size4 = 816 - View.MeasureSpec.getSize(0);
                                byte b28 = $$a[86];
                                Object[] objArr106 = new Object[1];
                                b((byte) 47, b28, (byte) (b28 << 2), objArr106);
                                objAccessartificialFrame25 = ArtificialStackFrames.coroutineCreation(edgeSlop, longPressTimeout, size4, 721586079, false, (String) objArr106[0], null);
                            }
                            ((Field) objAccessartificialFrame25).set(null, lValueOf8);
                        } catch (Exception unused6) {
                            throw new RuntimeException();
                        }
                    } else {
                        int i191 = artificialFrame + 7;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i191 % 128;
                        int i192 = i191 % 2;
                        Object objAccessartificialFrame37 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                        if (objAccessartificialFrame37 == null) {
                            int i193 = 26 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1));
                            char cRed = (char) (30068 - Color.red(0));
                            int keyRepeatDelay3 = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 816;
                            Object[] objArr107 = new Object[1];
                            b((byte) 47, $$a[86], (byte) 56, objArr107);
                            objAccessartificialFrame37 = ArtificialStackFrames.coroutineCreation(i193, cRed, keyRepeatDelay3, 891606461, false, (String) objArr107[0], null);
                        }
                        Object[] objArr108 = (Object[]) ((Field) objAccessartificialFrame37).get(null);
                        objArr7 = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
                        int i194 = ((int[]) objArr108[0])[0];
                        int i195 = ((int[]) objArr108[1])[0];
                        String[] strArr10 = (String[]) objArr108[2];
                        int iMaxMemory2 = (int) Runtime.getRuntime().maxMemory();
                        int i196 = ~iMaxMemory2;
                        int i197 = ((507503383 + (((~(871406170 | i196)) | (~((-1069578537) | iMaxMemory2))) * (-370))) + ((((~(iMaxMemory2 | 871406170)) | (~(i196 | (-1069578537)))) | 3179090) * (-370))) - 1347580635;
                        int i198 = (i197 << 13) ^ i197;
                        int i199 = i198 ^ (i198 >>> 17);
                        ((int[]) objArr7[3])[0] = i199 ^ (i199 << 5);
                    }
                    i25 = ((int[]) objArr7[1])[0];
                    i26 = ((int[]) objArr7[0])[0];
                    if (i26 == i25) {
                        int i200 = getARTIFICIAL_FRAME_PACKAGE_NAME + 119;
                        artificialFrame = i200 % 128;
                        int i201 = i200 % 2;
                        Object[] objArr109 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
                        int i202 = ((int[]) objArr7[3])[0];
                        int i203 = ((int[]) objArr7[0])[0];
                        int i204 = ((int[]) objArr7[1])[0];
                        String[] strArr11 = (String[]) objArr7[2];
                        int iCodePointAt = ((Context) Class.forName("android.app.ActivityThread").getMethod(str, new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(10) - 1036900927;
                        int i205 = ~iCodePointAt;
                        int i206 = i202 + (-99377353) + (((~((-515372982) | i205)) | 176674433) * (-108)) + (((~(i205 | 713545347)) | (~((-713545348) | iCodePointAt)) | (-1052243896)) * 54) + ((iCodePointAt | (-1052243896)) * 54);
                        int i207 = (i206 << 13) ^ i206;
                        int i208 = i207 ^ (i207 >>> 17);
                        ((int[]) objArr109[3])[0] = i208 ^ (i208 << 5);
                        return;
                    }
                    arrayList3 = new ArrayList();
                    strArr3 = (String[]) objArr7[2];
                    if (strArr3 != null) {
                        for (String str8 : strArr3) {
                            arrayList3.add(str8);
                        }
                    }
                    long j9 = ((long) (i25 ^ i26)) ^ (((long) 1508793583) << 32);
                    long j10 = 1508793582;
                    int i209 = artificialFrame + 27;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i209 % 128;
                    int i210 = i209 % 2;
                    Object[] objArr110 = {Long.valueOf(j9), Long.valueOf(j10)};
                    byte[] bArr20 = $$d;
                    Object[] objArr111 = new Object[1];
                    c(bArr20[57], bArr20[62], (short) 600, objArr111);
                    Class<?> cls13 = Class.forName((String) objArr111[0]);
                    byte b29 = (byte) (-bArr20[1]);
                    Object[] objArr112 = new Object[1];
                    c(b29, (byte) (b29 + 4), (short) 157, objArr112);
                    cls13.getMethod((String) objArr112[0], Long.TYPE, Long.TYPE).invoke(null, objArr110);
                    Object[] objArr113 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
                    int i211 = ((int[]) objArr7[3])[0];
                    int i212 = ((int[]) objArr7[0])[0];
                    int i213 = ((int[]) objArr7[1])[0];
                    String[] strArr12 = (String[]) objArr7[2];
                    int iMyPid = Process.myPid();
                    int i214 = ~iMyPid;
                    int i215 = i211 + (-512236415) + (((~(iMyPid | (-306238568))) | (~((-202384145) | i214)) | 4211778) * (-68)) + ((~((-302026790) | i214)) * (-68)) + (((~(306238567 | i214)) | (-504410934)) * 68);
                    int i216 = (i215 << 13) ^ i215;
                    int i217 = i216 ^ (i216 >>> 17);
                    ((int[]) objArr113[3])[0] = i217 ^ (i217 << 5);
                    return;
                }
                i9 = 0;
                baseContext = getBaseContext();
                if (baseContext == null) {
                    int iResolveOpacity = Drawable.resolveOpacity(i9, i9) + 26;
                    char[] cArr = {CharUtils.CR, CoreConstants.SINGLE_QUOTE_CHAR, 21, CoreConstants.DASH_CHAR, CoreConstants.RIGHT_PARENTHESIS_CHAR, 19, 22, 3, '\n', ' ', 29, 3, '\n', '\b', '0', 17, CoreConstants.RIGHT_PARENTHESIS_CHAR, 27, 3, '\n', '#', 15, '/', 0, '\n', 25};
                    byte bCodePointAt = (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod(str, new Class[i9]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(11) - 70);
                    Object[] objArr114 = new Object[1];
                    a(iResolveOpacity, cArr, bCodePointAt, objArr114);
                    Class<?> cls14 = Class.forName((String) objArr114[0]);
                    Object[] objArr115 = new Object[1];
                    a(((Context) Class.forName("android.app.ActivityThread").getMethod(str, new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 14, new char[]{'\b', '*', 13860, 13860, 6, CoreConstants.LEFT_PARENTHESIS_CHAR, CoreConstants.COMMA_CHAR, '\n', 13862, 13862, 20, 27, '\b', '\f', '0', 17, CoreConstants.RIGHT_PARENTHESIS_CHAR, '#'}, (byte) (60 - View.MeasureSpec.makeMeasureSpec(0, 0)), objArr115);
                    baseContext = (Context) cls14.getMethod((String) objArr115[0], new Class[0]).invoke(null, null);
                }
                if (baseContext != null) {
                    if ((baseContext instanceof ContextWrapper) || ((ContextWrapper) baseContext).getBaseContext() != null) {
                        baseContext = baseContext.getApplicationContext();
                    } else {
                        baseContext = null;
                    }
                }
                Object[] objArr116 = {baseContext, Integer.valueOf(((Integer) Class.forName(str4).getMethod(str5, Object.class).invoke(null, this)).intValue()), 0, 379948054};
                byte[] bArr21 = $$d;
                Object[] objArr117 = new Object[1];
                c(bArr21[10], (byte) (-bArr21[270]), (short) 234, objArr117);
                Class<?> cls15 = Class.forName((String) objArr117[0]);
                byte b30 = bArr21[492];
                Object[] objArr118 = new Object[1];
                c(b30, (byte) (b30 | Ascii.DC2), (short) (-bArr21[108]), objArr118);
                objArr4 = (Object[]) cls15.getMethod((String) objArr118[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr116);
                objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(1575402270);
                if (objAccessartificialFrame8 == null) {
                    int iBlue2 = Color.blue(0) + 17;
                    char cAxisFromString = (char) (MotionEvent.axisFromString("") + 1);
                    int longPressTimeout2 = 747 - (ViewConfiguration.getLongPressTimeout() >> 16);
                    Object[] objArr119 = new Object[1];
                    b((byte) 47, $$a[86], (byte) 56, objArr119);
                    objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(iBlue2, cAxisFromString, longPressTimeout2, -1031537386, false, (String) objArr119[0], null);
                }
                ((Field) objAccessartificialFrame8).set(null, objArr4);
                Long lValueOf9 = Long.valueOf(((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue());
                objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(1745676544);
                if (objAccessartificialFrame9 == null) {
                    int mode4 = 17 - View.MeasureSpec.getMode(0);
                    char scrollBarFadeDuration4 = (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                    int iArgb = 747 - Color.argb(0, 0, 0, 0);
                    byte b31 = $$a[86];
                    Object[] objArr120 = new Object[1];
                    b((byte) 47, b31, (byte) (b31 << 2), objArr120);
                    objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(mode4, scrollBarFadeDuration4, iArgb, -144068856, false, (String) objArr120[0], null);
                }
                ((Field) objAccessartificialFrame9).set(null, lValueOf9);
                i10 = ((int[]) objArr4[4])[0];
                i11 = ((int[]) objArr4[3])[0];
                if (i11 == i10) {
                    int i1010 = getARTIFICIAL_FRAME_PACKAGE_NAME + 55;
                    artificialFrame = i1010 % 128;
                    int i1011 = i1010 % 2;
                    Object[] objArr510 = {list3, new int[1], list4, new int[]{i111}, new int[]{i112}};
                    int i1110 = ((int[]) objArr4[1])[0];
                    int i1111 = ((int[]) objArr4[3])[0];
                    int i1112 = ((int[]) objArr4[4])[0];
                    List list7 = (List) objArr4[0];
                    List list8 = (List) objArr4[2];
                    int iMaxMemory3 = (int) Runtime.getRuntime().maxMemory();
                    int i1113 = 46644816 + (((~((~iMaxMemory3) | (-3565675))) | 1468512) * (-245));
                    int i1114 = ~(iMaxMemory3 | (-3565675));
                    int i1115 = i1110 + i1113 + (i1114 * (-245)) + ((i1114 | 601882783) * 245);
                    int i1116 = (i1115 << 13) ^ i1115;
                    int i1117 = i1116 ^ (i1116 >>> 17);
                    i12 = 0;
                    ((int[]) objArr510[1])[0] = i1117 ^ (i1117 << 5);
                } else {
                    ArrayList arrayList5 = new ArrayList();
                    Object[] objArr511 = {objArr4};
                    objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(1804664566);
                    if (objAccessartificialFrame10 == null) {
                        objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(((byte) KeyEvent.getModifierMetaStateMask()) + 42, (char) (TextUtils.getCapsMode("", 0, 0) + 12468), (-16773574) - Color.rgb(0, 0, 0), -185222914, false, "coroutineCreation", new Class[]{Object[].class});
                    }
                    arrayList5.add(((Method) objAccessartificialFrame10).invoke(null, objArr511));
                    Object[] objArr512 = {objArr4};
                    objAccessartificialFrame11 = ArtificialStackFrames.accessartificialFrame(-1243809191);
                    if (objAccessartificialFrame11 == null) {
                        objAccessartificialFrame11 = ArtificialStackFrames.coroutineCreation(AndroidCharacter.getMirror('0') - 7, (char) (12468 - ExpandableListView.getPackedPositionType(0L)), (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 3642, 716815441, false, "ArtificialStackFrames", new Class[]{Object[].class});
                    }
                    arrayList5.add(((Method) objAccessartificialFrame11).invoke(null, objArr512));
                    Object[] objArr513 = {Long.valueOf(((long) (i10 ^ i11)) ^ (((long) 783305454) << 32)), Long.valueOf(783305446)};
                    byte[] bArr110 = $$d;
                    Object[] objArr514 = new Object[1];
                    c(bArr110[57], bArr110[46], (short) 282, objArr514);
                    Class<?> cls16 = Class.forName((String) objArr514[0]);
                    byte b110 = (byte) (-bArr110[1]);
                    Object[] objArr515 = new Object[1];
                    c(b110, (byte) (b110 + 4), (short) 157, objArr515);
                    cls16.getMethod((String) objArr515[0], Long.TYPE, Long.TYPE).invoke(null, objArr513);
                    Object[] objArr516 = {list5, new int[1], list6, new int[]{i119}, new int[]{i120}};
                    int i1118 = ((int[]) objArr4[1])[0];
                    int i1119 = ((int[]) objArr4[3])[0];
                    int i1210 = ((int[]) objArr4[4])[0];
                    List list9 = (List) objArr4[0];
                    List list10 = (List) objArr4[2];
                    int i1211 = ~(((Context) Class.forName("android.app.ActivityThread").getMethod(str, new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) - 197842764);
                    int i1212 = i1118 + 920553229 + ((~((-42991794) | i1211)) * (-783)) + (((~(i1211 | 424032078)) | (-181416380)) * 783);
                    int i1213 = (i1212 << 13) ^ i1212;
                    int i1214 = i1213 ^ (i1213 >>> 17);
                    i12 = 0;
                    ((int[]) objArr516[1])[0] = i1214 ^ (i1214 << 5);
                }
                objAccessartificialFrame12 = ArtificialStackFrames.accessartificialFrame(-444530678);
                if (objAccessartificialFrame12 == null) {
                    int iGreen2 = Color.green(i12) + 26;
                    char cMakeMeasureSpec2 = (char) View.MeasureSpec.makeMeasureSpec(i12, i12);
                    int iMyTid3 = (Process.myTid() >> 22) + 1041;
                    byte b111 = $$a[86];
                    Object[] objArr517 = new Object[1];
                    b((byte) 47, b111, (byte) (b111 << 2), objArr517);
                    objAccessartificialFrame12 = ArtificialStackFrames.coroutineCreation(iGreen2, cMakeMeasureSpec2, iMyTid3, 2061780482, false, (String) objArr517[0], null);
                }
                j3 = ((Field) objAccessartificialFrame12).getLong(null);
                if (j3 != -1) {
                    int iIntValue3 = ((Integer) Class.forName(str4).getMethod(str5, Object.class).invoke(null, this)).intValue();
                    Object[] objArr610 = {-1569097084};
                    objAccessartificialFrame13 = ArtificialStackFrames.accessartificialFrame(-1648942878);
                    if (objAccessartificialFrame13 == null) {
                        objAccessartificialFrame13 = ArtificialStackFrames.coroutineCreation(9 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), (char) ((ViewConfiguration.getTapTimeout() >> 16) + 22251), 1033 - ((Process.getThreadPriority(0) + 20) >> 6), 47343338, false, null, new Class[]{Integer.TYPE});
                    }
                    objArrAccessartificialFrame$78cbbd35 = IResultReceiver2._Parcel.accessartificialFrame$78cbbd35(iIntValue3, 0, ((Constructor) objAccessartificialFrame13).newInstance(objArr610), 252827598, false);
                    objAccessartificialFrame14 = ArtificialStackFrames.accessartificialFrame(-614804952);
                    if (objAccessartificialFrame14 == null) {
                        int iCombineMeasuredStates2 = View.combineMeasuredStates(0, 0) + 26;
                        char c6 = (char) (1 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)));
                        int iAlpha4 = 1041 - Color.alpha(0);
                        Object[] objArr611 = new Object[1];
                        b((byte) 47, $$a[86], (byte) 56, objArr611);
                        objAccessartificialFrame14 = ArtificialStackFrames.coroutineCreation(iCombineMeasuredStates2, c6, iAlpha4, 1145017376, false, (String) objArr611[0], null);
                    }
                    ((Field) objAccessartificialFrame14).set(null, objArrAccessartificialFrame$78cbbd35);
                    Long lValueOf10 = Long.valueOf(((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame15 = ArtificialStackFrames.accessartificialFrame(-444530678);
                    if (objAccessartificialFrame15 == null) {
                        int trimmedLength7 = 26 - TextUtils.getTrimmedLength("");
                        char c7 = (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                        int capsMode3 = TextUtils.getCapsMode("", 0, 0) + 1041;
                        byte b112 = $$a[86];
                        Object[] objArr612 = new Object[1];
                        b((byte) 47, b112, (byte) (b112 << 2), objArr612);
                        objAccessartificialFrame15 = ArtificialStackFrames.coroutineCreation(trimmedLength7, c7, capsMode3, 2061780482, false, (String) objArr612[0], null);
                    }
                    ((Field) objAccessartificialFrame15).set(null, lValueOf10);
                } else {
                    int iIntValue4 = ((Integer) Class.forName(str4).getMethod(str5, Object.class).invoke(null, this)).intValue();
                    Object[] objArr613 = {-1569097084};
                    objAccessartificialFrame13 = ArtificialStackFrames.accessartificialFrame(-1648942878);
                    if (objAccessartificialFrame13 == null) {
                        objAccessartificialFrame13 = ArtificialStackFrames.coroutineCreation(9 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), (char) ((ViewConfiguration.getTapTimeout() >> 16) + 22251), 1033 - ((Process.getThreadPriority(0) + 20) >> 6), 47343338, false, null, new Class[]{Integer.TYPE});
                    }
                    objArrAccessartificialFrame$78cbbd35 = IResultReceiver2._Parcel.accessartificialFrame$78cbbd35(iIntValue4, 0, ((Constructor) objAccessartificialFrame13).newInstance(objArr613), 252827598, false);
                    objAccessartificialFrame14 = ArtificialStackFrames.accessartificialFrame(-614804952);
                    if (objAccessartificialFrame14 == null) {
                        int iCombineMeasuredStates3 = View.combineMeasuredStates(0, 0) + 26;
                        char c8 = (char) (1 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)));
                        int iAlpha5 = 1041 - Color.alpha(0);
                        Object[] objArr614 = new Object[1];
                        b((byte) 47, $$a[86], (byte) 56, objArr614);
                        objAccessartificialFrame14 = ArtificialStackFrames.coroutineCreation(iCombineMeasuredStates3, c8, iAlpha5, 1145017376, false, (String) objArr614[0], null);
                    }
                    ((Field) objAccessartificialFrame14).set(null, objArrAccessartificialFrame$78cbbd35);
                    Long lValueOf11 = Long.valueOf(((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame15 = ArtificialStackFrames.accessartificialFrame(-444530678);
                    if (objAccessartificialFrame15 == null) {
                        int trimmedLength8 = 26 - TextUtils.getTrimmedLength("");
                        char c9 = (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                        int capsMode4 = TextUtils.getCapsMode("", 0, 0) + 1041;
                        byte b113 = $$a[86];
                        Object[] objArr615 = new Object[1];
                        b((byte) 47, b113, (byte) (b113 << 2), objArr615);
                        objAccessartificialFrame15 = ArtificialStackFrames.coroutineCreation(trimmedLength8, c9, capsMode4, 2061780482, false, (String) objArr615[0], null);
                    }
                    ((Field) objAccessartificialFrame15).set(null, lValueOf11);
                }
                i13 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
                i14 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
                if (i14 == i13) {
                    Object[] objArr616 = {strArr5, new int[1], new int[]{i133}, new int[]{i132}};
                    int i1310 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
                    int i1311 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
                    int i1312 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
                    String[] strArr13 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
                    int iIdentityHashCode7 = System.identityHashCode(this);
                    int i1313 = ~iIdentityHashCode7;
                    int i1314 = i1310 + 831945840 + (((~(76784249 | i1313)) | (~((-75530242) | iIdentityHashCode7))) * (-831)) + ((~(230418297 | iIdentityHashCode7)) * (-1662)) + (((~(iIdentityHashCode7 | (-76784250))) | (~(i1313 | (-154888057))) | (~(154888056 | iIdentityHashCode7))) * 831);
                    int i1315 = (i1314 << 13) ^ i1314;
                    int i1316 = i1315 ^ (i1315 >>> 17);
                    ((int[]) objArr616[1])[0] = i1316 ^ (i1316 << 5);
                    i15 = 0;
                } else {
                    arrayList = new ArrayList();
                    strArr = (String[]) objArrAccessartificialFrame$78cbbd35[0];
                    if (strArr != null) {
                        i16 = 0;
                        while (i16 < strArr.length) {
                            i17 = getARTIFICIAL_FRAME_PACKAGE_NAME + 91;
                            artificialFrame = i17 % 128;
                            if (i17 % 2 == 0) {
                                arrayList.add(strArr[i16]);
                                i16 += 88;
                            } else {
                                arrayList.add(strArr[i16]);
                                i16++;
                            }
                        }
                    }
                    Object[] objArr617 = objArrAccessartificialFrame$78cbbd35;
                    Object[] objArr618 = {Long.valueOf(((long) (i13 ^ i14)) ^ (((long) (-1600638879)) << 32)), Long.valueOf(-1600638877)};
                    byte[] bArr111 = $$d;
                    Object[] objArr619 = new Object[1];
                    c(bArr111[45], bArr111[452], (short) 354, objArr619);
                    Class<?> cls17 = Class.forName((String) objArr619[0]);
                    byte b114 = (byte) (-bArr111[1]);
                    Object[] objArr620 = new Object[1];
                    c(b114, (byte) (b114 + 4), (short) 157, objArr620);
                    cls17.getMethod((String) objArr620[0], Long.TYPE, Long.TYPE).invoke(null, objArr618);
                    Object[] objArr710 = {strArr6, new int[1], new int[]{i140}, new int[]{i139}};
                    int i1317 = ((int[]) objArr617[1])[0];
                    int i1318 = ((int[]) objArr617[3])[0];
                    int i1410 = ((int[]) objArr617[2])[0];
                    String[] strArr14 = (String[]) objArr617[0];
                    int i1411 = ((Context) Class.forName("android.app.ActivityThread").getMethod(str, new Class[0]).invoke(null, null)).getResources().getConfiguration().touchscreen;
                    int i1412 = ~i1411;
                    int i1413 = i1317 + 1069043538 + (((~(243663665 | i1412)) | (-531614514)) * 98) + (((~(i1412 | (-321767473))) | 243663665 | (~(321767472 | i1411))) * (-49)) + (((~(i1411 | 243663665)) | 209847041) * 49);
                    int i1414 = (i1413 << 13) ^ i1413;
                    int i1415 = i1414 ^ (i1414 >>> 17);
                    i15 = 0;
                    ((int[]) objArr710[1])[0] = i1415 ^ (i1415 << 5);
                }
                objAccessartificialFrame16 = ArtificialStackFrames.accessartificialFrame(1056123296);
                if (objAccessartificialFrame16 == null) {
                    int iAlpha6 = 30 - Color.alpha(i15);
                    char cNormalizeMetaState2 = (char) (49362 - KeyEvent.normalizeMetaState(i15));
                    int i1416 = (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 683;
                    byte[] bArr112 = $$a;
                    Object[] objArr711 = new Object[1];
                    b(bArr112[i15], bArr112[82], (byte) ($$b >>> 1), objArr711);
                    objAccessartificialFrame16 = ArtificialStackFrames.coroutineCreation(iAlpha6, cNormalizeMetaState2, i1416, -1583976536, false, (String) objArr711[i15], null);
                }
                j4 = ((Field) objAccessartificialFrame16).getLong(null);
                if (j4 != -1) {
                    Object[] objArr712 = {Integer.valueOf(((Integer) Class.forName(str4).getMethod(str5, Object.class).invoke(null, this)).intValue()), 1109377758};
                    byte[] bArr113 = $$d;
                    byte b115 = bArr113[57];
                    byte b116 = bArr113[45];
                    Object[] objArr713 = new Object[1];
                    c(b115, b116, (short) (b116 | 408), objArr713);
                    Class<?> cls18 = Class.forName((String) objArr713[0]);
                    byte b117 = bArr113[57];
                    byte b210 = bArr113[185];
                    Object[] objArr714 = new Object[1];
                    c(b117, b210, (short) (b210 | 424), objArr714);
                    Object[] objArr715 = (Object[]) cls18.getMethod((String) objArr714[0], Integer.TYPE, Integer.TYPE).invoke(null, objArr712);
                    objAccessartificialFrame17 = ArtificialStackFrames.accessartificialFrame(910856866);
                    if (objAccessartificialFrame17 == null) {
                        int doubleTapTimeout2 = 30 - (ViewConfiguration.getDoubleTapTimeout() >> 16);
                        char c10 = (char) (49362 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)));
                        int threadPriority2 = ((Process.getThreadPriority(0) + 20) >> 6) + 684;
                        Object[] objArr716 = new Object[1];
                        b((byte) ($$b & WebSocketProtocol.PAYLOAD_SHORT), $$a[86], (byte) 96, objArr716);
                        objAccessartificialFrame17 = ArtificialStackFrames.coroutineCreation(doubleTapTimeout2, c10, threadPriority2, -1456483158, false, (String) objArr716[0], null);
                    }
                    ((Field) objAccessartificialFrame17).set(null, objArr715);
                    Long lValueOf12 = Long.valueOf(((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame18 = ArtificialStackFrames.accessartificialFrame(1056123296);
                    if (objAccessartificialFrame18 == null) {
                        int iResolveSize2 = 30 - View.resolveSize(0, 0);
                        char offsetAfter4 = (char) (49362 - TextUtils.getOffsetAfter("", 0));
                        int i1417 = (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 683;
                        byte[] bArr114 = $$a;
                        Object[] objArr717 = new Object[1];
                        b(bArr114[0], bArr114[82], (byte) ($$b >>> 1), objArr717);
                        objAccessartificialFrame18 = ArtificialStackFrames.coroutineCreation(iResolveSize2, offsetAfter4, i1417, -1583976536, false, (String) objArr717[0], null);
                    }
                    ((Field) objAccessartificialFrame18).set(null, lValueOf12);
                    objArr5 = objArr715;
                } else {
                    Object[] objArr718 = {Integer.valueOf(((Integer) Class.forName(str4).getMethod(str5, Object.class).invoke(null, this)).intValue()), 1109377758};
                    byte[] bArr115 = $$d;
                    byte b118 = bArr115[57];
                    byte b119 = bArr115[45];
                    Object[] objArr719 = new Object[1];
                    c(b118, b119, (short) (b119 | 408), objArr719);
                    Class<?> cls19 = Class.forName((String) objArr719[0]);
                    byte b1110 = bArr115[57];
                    byte b211 = bArr115[185];
                    Object[] objArr7110 = new Object[1];
                    c(b1110, b211, (short) (b211 | 424), objArr7110);
                    Object[] objArr7111 = (Object[]) cls19.getMethod((String) objArr7110[0], Integer.TYPE, Integer.TYPE).invoke(null, objArr718);
                    objAccessartificialFrame17 = ArtificialStackFrames.accessartificialFrame(910856866);
                    if (objAccessartificialFrame17 == null) {
                        int doubleTapTimeout3 = 30 - (ViewConfiguration.getDoubleTapTimeout() >> 16);
                        char c11 = (char) (49362 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)));
                        int threadPriority3 = ((Process.getThreadPriority(0) + 20) >> 6) + 684;
                        Object[] objArr7112 = new Object[1];
                        b((byte) ($$b & WebSocketProtocol.PAYLOAD_SHORT), $$a[86], (byte) 96, objArr7112);
                        objAccessartificialFrame17 = ArtificialStackFrames.coroutineCreation(doubleTapTimeout3, c11, threadPriority3, -1456483158, false, (String) objArr7112[0], null);
                    }
                    ((Field) objAccessartificialFrame17).set(null, objArr7111);
                    Long lValueOf13 = Long.valueOf(((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame18 = ArtificialStackFrames.accessartificialFrame(1056123296);
                    if (objAccessartificialFrame18 == null) {
                        int iResolveSize3 = 30 - View.resolveSize(0, 0);
                        char offsetAfter5 = (char) (49362 - TextUtils.getOffsetAfter("", 0));
                        int i1418 = (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 683;
                        byte[] bArr116 = $$a;
                        Object[] objArr7113 = new Object[1];
                        b(bArr116[0], bArr116[82], (byte) ($$b >>> 1), objArr7113);
                        objAccessartificialFrame18 = ArtificialStackFrames.coroutineCreation(iResolveSize3, offsetAfter5, i1418, -1583976536, false, (String) objArr7113[0], null);
                    }
                    ((Field) objAccessartificialFrame18).set(null, lValueOf13);
                    objArr5 = objArr7111;
                }
                i18 = ((int[]) objArr5[1])[0];
                i19 = ((int[]) objArr5[0])[0];
                if (i19 == i18) {
                    int i1510 = getARTIFICIAL_FRAME_PACKAGE_NAME + 71;
                    artificialFrame = i1510 % 128;
                    int i1511 = i1510 % 2;
                    int i1512 = ((int[]) objArr5[2])[0];
                    Object[] objArr810 = {new int[]{((int[]) objArr5[0])[0]}, new int[]{((int[]) objArr5[1])[0]}, new int[1], (String) objArr5[3]};
                    int i1513 = (int) Runtime.getRuntime().totalMemory();
                    int i1514 = (-558569362) + (((~((-61450044) | i1513)) | (-917173732)) * (-318));
                    int i1515 = ~((-917173732) | i1513);
                    int i1516 = ~i1513;
                    int i1610 = i1512 + i1514 + ((i1515 | (~(934017019 | i1516))) * TypedValues.AttributesType.TYPE_PIVOT_TARGET) + (((~(i1513 | 934017019)) | (~((-872566977) | i1516))) * TypedValues.AttributesType.TYPE_PIVOT_TARGET);
                    int i1611 = (i1610 << 13) ^ i1610;
                    int i1612 = i1611 ^ (i1611 >>> 17);
                    ((int[]) objArr810[2])[0] = i1612 ^ (i1612 << 5);
                    i20 = 0;
                } else {
                    new ArrayList().add((String) objArr5[3]);
                    Object[] objArr811 = {Long.valueOf(((long) (i18 ^ i19)) ^ (((long) 183072593) << 32)), Long.valueOf(183072577)};
                    byte[] bArr117 = $$d;
                    Object[] objArr812 = new Object[1];
                    c(bArr117[57], bArr117[25], (short) 91, objArr812);
                    Class<?> cls20 = Class.forName((String) objArr812[0]);
                    byte b212 = (byte) (-bArr117[1]);
                    Object[] objArr813 = new Object[1];
                    c(b212, (byte) (b212 + 4), (short) 157, objArr813);
                    cls20.getMethod((String) objArr813[0], Long.TYPE, Long.TYPE).invoke(null, objArr811);
                    int i1613 = ((int[]) objArr5[2])[0];
                    Object[] objArr814 = {new int[]{((int[]) objArr5[0])[0]}, new int[]{((int[]) objArr5[1])[0]}, new int[1], (String) objArr5[3]};
                    int iIdentityHashCode8 = System.identityHashCode(this);
                    int i1614 = i1613 + (-11707142) + (((~(iIdentityHashCode8 | (-15899194))) | (-994522969)) * (-465)) + (((-15899194) | (~((-994522969) | iIdentityHashCode8))) * 930) + ((iIdentityHashCode8 | (-4330009)) * 465);
                    int i1615 = (i1614 << 13) ^ i1614;
                    int i1616 = i1615 ^ (i1615 >>> 17);
                    i20 = 0;
                    ((int[]) objArr814[2])[0] = i1616 ^ (i1616 << 5);
                }
                objAccessartificialFrame19 = ArtificialStackFrames.accessartificialFrame(1313006081);
                if (objAccessartificialFrame19 == null) {
                    int offsetBefore3 = 21 - TextUtils.getOffsetBefore("", i20);
                    char cKeyCodeFromString2 = (char) KeyEvent.keyCodeFromString("");
                    int minimumFlingVelocity2 = (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 465;
                    byte b213 = $$a[86];
                    Object[] objArr815 = new Object[1];
                    b((byte) 47, b213, (byte) (b213 << 2), objArr815);
                    objAccessartificialFrame19 = ArtificialStackFrames.coroutineCreation(offsetBefore3, cKeyCodeFromString2, minimumFlingVelocity2, -785931255, false, (String) objArr815[0], null);
                }
                j5 = ((Field) objAccessartificialFrame19).getLong(null);
                if (j5 != -1) {
                    baseContext2 = getBaseContext();
                    if (baseContext2 == null) {
                        Object[] objArr816 = new Object[1];
                        a(TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 27, new char[]{CharUtils.CR, CoreConstants.SINGLE_QUOTE_CHAR, 21, CoreConstants.DASH_CHAR, CoreConstants.RIGHT_PARENTHESIS_CHAR, 19, 22, 3, '\n', ' ', 29, 3, '\n', '\b', '0', 17, CoreConstants.RIGHT_PARENTHESIS_CHAR, 27, 3, '\n', '#', 15, '/', 0, '\n', 25}, (byte) ((Context) Class.forName("android.app.ActivityThread").getMethod(str, new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion, objArr816);
                        Class<?> cls110 = Class.forName((String) objArr816[0]);
                        Object[] objArr817 = new Object[1];
                        a(18 - (ViewConfiguration.getLongPressTimeout() >> 16), new char[]{'\b', '*', 13860, 13860, 6, CoreConstants.LEFT_PARENTHESIS_CHAR, CoreConstants.COMMA_CHAR, '\n', 13862, 13862, 20, 27, '\b', '\f', '0', 17, CoreConstants.RIGHT_PARENTHESIS_CHAR, '#'}, (byte) (60 - View.MeasureSpec.getSize(0)), objArr817);
                        baseContext2 = (Context) cls110.getMethod((String) objArr817[0], new Class[0]).invoke(null, null);
                    }
                    if (baseContext2 != null) {
                        if (baseContext2 instanceof ContextWrapper) {
                            baseContext2 = baseContext2.getApplicationContext();
                        } else {
                            baseContext2 = baseContext2.getApplicationContext();
                        }
                    }
                    int iIntValue5 = ((Integer) Class.forName(str4).getMethod(str5, Object.class).invoke(null, this)).intValue();
                    Object[] objArr818 = new Object[1];
                    a(((Context) Class.forName("android.app.ActivityThread").getMethod(str, new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 43, new char[]{29, '!', 24, '\b', '/', 4, 29, 21, '\t', 0, ' ', '\f', CoreConstants.COMMA_CHAR, CoreConstants.PERCENT_CHAR, 14, 29, 3, 26, 31, '\"', 30, 5, 14, 29, 25, '\b', CoreConstants.COMMA_CHAR, CoreConstants.SINGLE_QUOTE_CHAR, 22, 17, 0, '!', 29, '\"', 31, 26, 14, 29, 0, 30, '#', '\t', 29, '\"', 16, 17, '\t', '#', ' ', 7, '\b', 25, '\t', 23, ' ', '\t', '#', '\t', '\f', 4, 21, '\b', 25, CoreConstants.DASH_CHAR}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod(str, new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 56), objArr818);
                    String str9 = (String) objArr818[0];
                    Object[] objArr819 = new Object[1];
                    a(((Context) Class.forName("android.app.ActivityThread").getMethod(str, new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(0) + 27, new char[]{29, 26, 13857, 13857, 0, '!', CoreConstants.COMMA_CHAR, 23, 30, 4, 28, CoreConstants.LEFT_PARENTHESIS_CHAR, ' ', CoreConstants.COMMA_CHAR, 23, 3, CoreConstants.COMMA_CHAR, ' ', '!', 4, 7, ' ', ' ', '\f', '\t', 23, 31, '\t', 26, 31, Typography.amp, 7, ' ', '/', 13770, 13770, ' ', '\f', '\f', CoreConstants.LEFT_PARENTHESIS_CHAR, 3, '\t', 31, '\f', CoreConstants.COMMA_CHAR, CoreConstants.SINGLE_QUOTE_CHAR, 24, '\b', 25, '+', 7, ' ', CoreConstants.LEFT_PARENTHESIS_CHAR, 0, 13774, 13774, CoreConstants.SINGLE_QUOTE_CHAR, 7, 18, '+', CoreConstants.SINGLE_QUOTE_CHAR, '\t', '!', 0}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod(str, new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) - 2), objArr819);
                    Object[] objArr910 = {baseContext2, new String[]{str9, (String) objArr819[0]}, Integer.valueOf(iIntValue5), 1, 1550163612};
                    byte[] bArr118 = $$d;
                    byte b214 = bArr118[57];
                    byte b215 = bArr118[94];
                    Object[] objArr911 = new Object[1];
                    c(b214, b215, (short) (b215 | 481), objArr911);
                    Class<?> cls111 = Class.forName((String) objArr911[0]);
                    Object[] objArr912 = new Object[1];
                    c(bArr118[224], bArr118[555], (short) 214, objArr912);
                    objArr6 = (Object[]) cls111.getMethod((String) objArr912[0], Context.class, String[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr910);
                    int i1617 = ((int[]) objArr6[0])[0];
                    int i1618 = ((int[]) objArr6[3])[0];
                    if (baseContext2 != null) {
                        objAccessartificialFrame20 = ArtificialStackFrames.accessartificialFrame(1142731807);
                        if (objAccessartificialFrame20 == null) {
                            int trimmedLength9 = 21 - TextUtils.getTrimmedLength("");
                            char scrollDefaultDelay2 = (char) (ViewConfiguration.getScrollDefaultDelay() >> 16);
                            int scrollBarSize5 = 465 - (ViewConfiguration.getScrollBarSize() >> 8);
                            Object[] objArr913 = new Object[1];
                            b((byte) 47, $$a[86], (byte) 56, objArr913);
                            objAccessartificialFrame20 = ArtificialStackFrames.coroutineCreation(trimmedLength9, scrollDefaultDelay2, scrollBarSize5, -612765161, false, (String) objArr913[0], null);
                        }
                        ((Field) objAccessartificialFrame20).set(null, objArr6);
                        Long lValueOf14 = Long.valueOf(((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame21 = ArtificialStackFrames.accessartificialFrame(1313006081);
                        if (objAccessartificialFrame21 == null) {
                            int touchSlop2 = 21 - (ViewConfiguration.getTouchSlop() >> 8);
                            char offsetAfter6 = (char) TextUtils.getOffsetAfter("", 0);
                            int pressedStateDuration2 = (ViewConfiguration.getPressedStateDuration() >> 16) + 465;
                            byte b216 = $$a[86];
                            Object[] objArr914 = new Object[1];
                            b((byte) 47, b216, (byte) (b216 << 2), objArr914);
                            objAccessartificialFrame21 = ArtificialStackFrames.coroutineCreation(touchSlop2, offsetAfter6, pressedStateDuration2, -785931255, false, (String) objArr914[0], null);
                        }
                        ((Field) objAccessartificialFrame21).set(null, lValueOf14);
                    }
                    c = 0;
                } else {
                    baseContext2 = getBaseContext();
                    if (baseContext2 == null) {
                        Object[] objArr8110 = new Object[1];
                        a(TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 27, new char[]{CharUtils.CR, CoreConstants.SINGLE_QUOTE_CHAR, 21, CoreConstants.DASH_CHAR, CoreConstants.RIGHT_PARENTHESIS_CHAR, 19, 22, 3, '\n', ' ', 29, 3, '\n', '\b', '0', 17, CoreConstants.RIGHT_PARENTHESIS_CHAR, 27, 3, '\n', '#', 15, '/', 0, '\n', 25}, (byte) ((Context) Class.forName("android.app.ActivityThread").getMethod(str, new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion, objArr8110);
                        Class<?> cls112 = Class.forName((String) objArr8110[0]);
                        Object[] objArr8111 = new Object[1];
                        a(18 - (ViewConfiguration.getLongPressTimeout() >> 16), new char[]{'\b', '*', 13860, 13860, 6, CoreConstants.LEFT_PARENTHESIS_CHAR, CoreConstants.COMMA_CHAR, '\n', 13862, 13862, 20, 27, '\b', '\f', '0', 17, CoreConstants.RIGHT_PARENTHESIS_CHAR, '#'}, (byte) (60 - View.MeasureSpec.getSize(0)), objArr8111);
                        baseContext2 = (Context) cls112.getMethod((String) objArr8111[0], new Class[0]).invoke(null, null);
                    }
                    if (baseContext2 != null) {
                        if (baseContext2 instanceof ContextWrapper) {
                            baseContext2 = baseContext2.getApplicationContext();
                        } else {
                            baseContext2 = baseContext2.getApplicationContext();
                        }
                    }
                    int iIntValue6 = ((Integer) Class.forName(str4).getMethod(str5, Object.class).invoke(null, this)).intValue();
                    Object[] objArr8112 = new Object[1];
                    a(((Context) Class.forName("android.app.ActivityThread").getMethod(str, new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 43, new char[]{29, '!', 24, '\b', '/', 4, 29, 21, '\t', 0, ' ', '\f', CoreConstants.COMMA_CHAR, CoreConstants.PERCENT_CHAR, 14, 29, 3, 26, 31, '\"', 30, 5, 14, 29, 25, '\b', CoreConstants.COMMA_CHAR, CoreConstants.SINGLE_QUOTE_CHAR, 22, 17, 0, '!', 29, '\"', 31, 26, 14, 29, 0, 30, '#', '\t', 29, '\"', 16, 17, '\t', '#', ' ', 7, '\b', 25, '\t', 23, ' ', '\t', '#', '\t', '\f', 4, 21, '\b', 25, CoreConstants.DASH_CHAR}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod(str, new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 56), objArr8112);
                    String str10 = (String) objArr8112[0];
                    Object[] objArr8113 = new Object[1];
                    a(((Context) Class.forName("android.app.ActivityThread").getMethod(str, new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(0) + 27, new char[]{29, 26, 13857, 13857, 0, '!', CoreConstants.COMMA_CHAR, 23, 30, 4, 28, CoreConstants.LEFT_PARENTHESIS_CHAR, ' ', CoreConstants.COMMA_CHAR, 23, 3, CoreConstants.COMMA_CHAR, ' ', '!', 4, 7, ' ', ' ', '\f', '\t', 23, 31, '\t', 26, 31, Typography.amp, 7, ' ', '/', 13770, 13770, ' ', '\f', '\f', CoreConstants.LEFT_PARENTHESIS_CHAR, 3, '\t', 31, '\f', CoreConstants.COMMA_CHAR, CoreConstants.SINGLE_QUOTE_CHAR, 24, '\b', 25, '+', 7, ' ', CoreConstants.LEFT_PARENTHESIS_CHAR, 0, 13774, 13774, CoreConstants.SINGLE_QUOTE_CHAR, 7, 18, '+', CoreConstants.SINGLE_QUOTE_CHAR, '\t', '!', 0}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod(str, new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) - 2), objArr8113);
                    Object[] objArr915 = {baseContext2, new String[]{str10, (String) objArr8113[0]}, Integer.valueOf(iIntValue6), 1, 1550163612};
                    byte[] bArr119 = $$d;
                    byte b217 = bArr119[57];
                    byte b218 = bArr119[94];
                    Object[] objArr916 = new Object[1];
                    c(b217, b218, (short) (b218 | 481), objArr916);
                    Class<?> cls113 = Class.forName((String) objArr916[0]);
                    Object[] objArr917 = new Object[1];
                    c(bArr119[224], bArr119[555], (short) 214, objArr917);
                    objArr6 = (Object[]) cls113.getMethod((String) objArr917[0], Context.class, String[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr915);
                    int i1619 = ((int[]) objArr6[0])[0];
                    int i16110 = ((int[]) objArr6[3])[0];
                    if (baseContext2 != null) {
                        objAccessartificialFrame20 = ArtificialStackFrames.accessartificialFrame(1142731807);
                        if (objAccessartificialFrame20 == null) {
                            int trimmedLength10 = 21 - TextUtils.getTrimmedLength("");
                            char scrollDefaultDelay3 = (char) (ViewConfiguration.getScrollDefaultDelay() >> 16);
                            int scrollBarSize6 = 465 - (ViewConfiguration.getScrollBarSize() >> 8);
                            Object[] objArr918 = new Object[1];
                            b((byte) 47, $$a[86], (byte) 56, objArr918);
                            objAccessartificialFrame20 = ArtificialStackFrames.coroutineCreation(trimmedLength10, scrollDefaultDelay3, scrollBarSize6, -612765161, false, (String) objArr918[0], null);
                        }
                        ((Field) objAccessartificialFrame20).set(null, objArr6);
                        Long lValueOf15 = Long.valueOf(((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame21 = ArtificialStackFrames.accessartificialFrame(1313006081);
                        if (objAccessartificialFrame21 == null) {
                            int touchSlop3 = 21 - (ViewConfiguration.getTouchSlop() >> 8);
                            char offsetAfter7 = (char) TextUtils.getOffsetAfter("", 0);
                            int pressedStateDuration3 = (ViewConfiguration.getPressedStateDuration() >> 16) + 465;
                            byte b219 = $$a[86];
                            Object[] objArr919 = new Object[1];
                            b((byte) 47, b219, (byte) (b219 << 2), objArr919);
                            objAccessartificialFrame21 = ArtificialStackFrames.coroutineCreation(touchSlop3, offsetAfter7, pressedStateDuration3, -785931255, false, (String) objArr919[0], null);
                        }
                        ((Field) objAccessartificialFrame21).set(null, lValueOf15);
                    }
                    c = 0;
                }
                i21 = ((int[]) objArr6[c])[c];
                i22 = ((int[]) objArr6[3])[c];
                if (i22 == i21) {
                    Object[] objArr920 = new Object[4];
                    int[] iArr3 = new int[1];
                    objArr920[c] = iArr3;
                    objArr920[2] = new int[1];
                    int[] iArr4 = new int[1];
                    objArr920[3] = iArr4;
                    int i1710 = ((int[]) objArr6[2])[c];
                    int i1711 = ((int[]) objArr6[3])[c];
                    int i1712 = ((int[]) objArr6[c])[c];
                    String[] strArr15 = (String[]) objArr6[1];
                    iArr4[c] = i1711;
                    iArr3[c] = i1712;
                    int iIdentityHashCode9 = System.identityHashCode(this);
                    int i1713 = ~iIdentityHashCode9;
                    int i1810 = i1710 + 1757838936 + (((~((-140681629) | i1713)) | (-19668098)) * (-865)) + ((~(iIdentityHashCode9 | 140681628)) * 865) + (((~((-19668098) | i1713)) | (~(i1713 | 140681628))) * 865);
                    int i1811 = (i1810 << 13) ^ i1810;
                    int i1812 = i1811 ^ (i1811 >>> 17);
                    ((int[]) objArr920[2])[0] = i1812 ^ (i1812 << 5);
                    objArr920[1] = strArr15;
                    i23 = 0;
                } else {
                    arrayList2 = new ArrayList();
                    strArr2 = (String[]) objArr6[1];
                    if (strArr2 != null) {
                        while (i24 < strArr2.length) {
                            arrayList2.add(str7);
                        }
                    }
                    Object[] objArr921 = {Long.valueOf(((long) (i21 ^ i22)) ^ (((long) 1235250365) << 32)), Long.valueOf(1235250429)};
                    byte[] bArr120 = $$d;
                    Object[] objArr922 = new Object[1];
                    c(bArr120[57], bArr120[358], (short) 562, objArr922);
                    Class<?> cls114 = Class.forName((String) objArr922[0]);
                    byte b220 = (byte) (-bArr120[1]);
                    Object[] objArr1010 = new Object[1];
                    c(b220, (byte) (b220 + 4), (short) 157, objArr1010);
                    cls114.getMethod((String) objArr1010[0], Long.TYPE, Long.TYPE).invoke(null, objArr921);
                    Object[] objArr1011 = {new int[]{i185}, strArr9, new int[1], new int[]{i184}};
                    int i1813 = ((int[]) objArr6[2])[0];
                    int i1814 = ((int[]) objArr6[3])[0];
                    int i1815 = ((int[]) objArr6[0])[0];
                    String[] strArr16 = (String[]) objArr6[1];
                    int i1816 = ~Process.myPid();
                    int i1817 = i1813 + 720771397 + (((~(i1816 | 519831146)) | (~((-702537) | i1816))) * (-184)) + ((339739168 | (~((-340441705) | i1816)) | (~(180091978 | i1816))) * SyslogConstants.LOG_LOCAL7) + 1352080856;
                    int i1818 = (i1817 << 13) ^ i1817;
                    int i1819 = i1818 ^ (i1818 >>> 17);
                    i23 = 0;
                    ((int[]) objArr1011[2])[0] = i1819 ^ (i1819 << 5);
                }
                super.onStart();
                objAccessartificialFrame22 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                if (objAccessartificialFrame22 == null) {
                    int defaultSize2 = View.getDefaultSize(i23, i23) + 25;
                    char cRgb2 = (char) (Color.rgb(i23, i23, i23) + 16807284);
                    int mode5 = 816 - View.MeasureSpec.getMode(i23);
                    byte b221 = $$a[86];
                    Object[] objArr1012 = new Object[1];
                    b((byte) 47, b221, (byte) (b221 << 2), objArr1012);
                    objAccessartificialFrame22 = ArtificialStackFrames.coroutineCreation(defaultSize2, cRgb2, mode5, 721586079, false, (String) objArr1012[0], null);
                }
                j6 = ((Field) objAccessartificialFrame22).getLong(null);
                if (j6 != -1) {
                    Object[] objArr1013 = {Integer.valueOf(((Integer) Class.forName(str4).getMethod(str5, Object.class).invoke(null, this)).intValue()), 0, 1771123361};
                    objAccessartificialFrame23 = ArtificialStackFrames.accessartificialFrame(1327366003);
                    if (objAccessartificialFrame23 == null) {
                        int i1910 = 26 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                        char cCombineMeasuredStates3 = (char) (30068 - View.combineMeasuredStates(0, 0));
                        int trimmedLength11 = 816 - TextUtils.getTrimmedLength("");
                        byte[] bArr121 = $$a;
                        Object[] objArr1014 = new Object[1];
                        b(bArr121[10], bArr121[26], (byte) 104, objArr1014);
                        objAccessartificialFrame23 = ArtificialStackFrames.coroutineCreation(i1910, cCombineMeasuredStates3, trimmedLength11, -797394565, false, (String) objArr1014[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                    }
                    objArr7 = (Object[]) ((Method) objAccessartificialFrame23).invoke(null, objArr1013);
                    objAccessartificialFrame24 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                    if (objAccessartificialFrame24 == null) {
                        int scrollBarSize7 = 25 - (ViewConfiguration.getScrollBarSize() >> 8);
                        char offsetAfter8 = (char) (30068 - TextUtils.getOffsetAfter("", 0));
                        int absoluteGravity3 = Gravity.getAbsoluteGravity(0, 0) + 816;
                        Object[] objArr1015 = new Object[1];
                        b((byte) 47, $$a[86], (byte) 56, objArr1015);
                        objAccessartificialFrame24 = ArtificialStackFrames.coroutineCreation(scrollBarSize7, offsetAfter8, absoluteGravity3, 891606461, false, (String) objArr1015[0], null);
                    }
                    ((Field) objAccessartificialFrame24).set(null, objArr7);
                    Long lValueOf16 = Long.valueOf(((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame25 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                    if (objAccessartificialFrame25 == null) {
                        int edgeSlop2 = (ViewConfiguration.getEdgeSlop() >> 16) + 25;
                        char longPressTimeout3 = (char) (30068 - (ViewConfiguration.getLongPressTimeout() >> 16));
                        int size5 = 816 - View.MeasureSpec.getSize(0);
                        byte b222 = $$a[86];
                        Object[] objArr1016 = new Object[1];
                        b((byte) 47, b222, (byte) (b222 << 2), objArr1016);
                        objAccessartificialFrame25 = ArtificialStackFrames.coroutineCreation(edgeSlop2, longPressTimeout3, size5, 721586079, false, (String) objArr1016[0], null);
                    }
                    ((Field) objAccessartificialFrame25).set(null, lValueOf16);
                } else {
                    Object[] objArr1017 = {Integer.valueOf(((Integer) Class.forName(str4).getMethod(str5, Object.class).invoke(null, this)).intValue()), 0, 1771123361};
                    objAccessartificialFrame23 = ArtificialStackFrames.accessartificialFrame(1327366003);
                    if (objAccessartificialFrame23 == null) {
                        int i1911 = 26 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                        char cCombineMeasuredStates4 = (char) (30068 - View.combineMeasuredStates(0, 0));
                        int trimmedLength12 = 816 - TextUtils.getTrimmedLength("");
                        byte[] bArr122 = $$a;
                        Object[] objArr1018 = new Object[1];
                        b(bArr122[10], bArr122[26], (byte) 104, objArr1018);
                        objAccessartificialFrame23 = ArtificialStackFrames.coroutineCreation(i1911, cCombineMeasuredStates4, trimmedLength12, -797394565, false, (String) objArr1018[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                    }
                    objArr7 = (Object[]) ((Method) objAccessartificialFrame23).invoke(null, objArr1017);
                    objAccessartificialFrame24 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                    if (objAccessartificialFrame24 == null) {
                        int scrollBarSize8 = 25 - (ViewConfiguration.getScrollBarSize() >> 8);
                        char offsetAfter9 = (char) (30068 - TextUtils.getOffsetAfter("", 0));
                        int absoluteGravity4 = Gravity.getAbsoluteGravity(0, 0) + 816;
                        Object[] objArr1019 = new Object[1];
                        b((byte) 47, $$a[86], (byte) 56, objArr1019);
                        objAccessartificialFrame24 = ArtificialStackFrames.coroutineCreation(scrollBarSize8, offsetAfter9, absoluteGravity4, 891606461, false, (String) objArr1019[0], null);
                    }
                    ((Field) objAccessartificialFrame24).set(null, objArr7);
                    Long lValueOf17 = Long.valueOf(((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame25 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                    if (objAccessartificialFrame25 == null) {
                        int edgeSlop3 = (ViewConfiguration.getEdgeSlop() >> 16) + 25;
                        char longPressTimeout4 = (char) (30068 - (ViewConfiguration.getLongPressTimeout() >> 16));
                        int size6 = 816 - View.MeasureSpec.getSize(0);
                        byte b223 = $$a[86];
                        Object[] objArr10110 = new Object[1];
                        b((byte) 47, b223, (byte) (b223 << 2), objArr10110);
                        objAccessartificialFrame25 = ArtificialStackFrames.coroutineCreation(edgeSlop3, longPressTimeout4, size6, 721586079, false, (String) objArr10110[0], null);
                    }
                    ((Field) objAccessartificialFrame25).set(null, lValueOf17);
                }
                i25 = ((int[]) objArr7[1])[0];
                i26 = ((int[]) objArr7[0])[0];
                if (i26 == i25) {
                    int i2010 = getARTIFICIAL_FRAME_PACKAGE_NAME + 119;
                    artificialFrame = i2010 % 128;
                    int i2011 = i2010 % 2;
                    Object[] objArr1020 = {new int[]{i203}, new int[]{i204}, strArr11, new int[1]};
                    int i2012 = ((int[]) objArr7[3])[0];
                    int i2013 = ((int[]) objArr7[0])[0];
                    int i2014 = ((int[]) objArr7[1])[0];
                    String[] strArr17 = (String[]) objArr7[2];
                    int iCodePointAt2 = ((Context) Class.forName("android.app.ActivityThread").getMethod(str, new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(10) - 1036900927;
                    int i2015 = ~iCodePointAt2;
                    int i2016 = i2012 + (-99377353) + (((~((-515372982) | i2015)) | 176674433) * (-108)) + (((~(i2015 | 713545347)) | (~((-713545348) | iCodePointAt2)) | (-1052243896)) * 54) + ((iCodePointAt2 | (-1052243896)) * 54);
                    int i2017 = (i2016 << 13) ^ i2016;
                    int i2018 = i2017 ^ (i2017 >>> 17);
                    ((int[]) objArr1020[3])[0] = i2018 ^ (i2018 << 5);
                    return;
                }
                arrayList3 = new ArrayList();
                strArr3 = (String[]) objArr7[2];
                if (strArr3 != null) {
                    while (i27 < strArr3.length) {
                        arrayList3.add(str8);
                    }
                }
                long j11 = ((long) (i25 ^ i26)) ^ (((long) 1508793583) << 32);
                long j12 = 1508793582;
                int i2019 = artificialFrame + 27;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i2019 % 128;
                int i218 = i2019 % 2;
                Object[] objArr1110 = {Long.valueOf(j11), Long.valueOf(j12)};
                byte[] bArr22 = $$d;
                Object[] objArr1111 = new Object[1];
                c(bArr22[57], bArr22[62], (short) 600, objArr1111);
                Class<?> cls115 = Class.forName((String) objArr1111[0]);
                byte b224 = (byte) (-bArr22[1]);
                Object[] objArr1112 = new Object[1];
                c(b224, (byte) (b224 + 4), (short) 157, objArr1112);
                cls115.getMethod((String) objArr1112[0], Long.TYPE, Long.TYPE).invoke(null, objArr1110);
                Object[] objArr1113 = {new int[]{i212}, new int[]{i213}, strArr12, new int[1]};
                int i219 = ((int[]) objArr7[3])[0];
                int i2110 = ((int[]) objArr7[0])[0];
                int i2111 = ((int[]) objArr7[1])[0];
                String[] strArr18 = (String[]) objArr7[2];
                int iMyPid2 = Process.myPid();
                int i2112 = ~iMyPid2;
                int i2113 = i219 + (-512236415) + (((~(iMyPid2 | (-306238568))) | (~((-202384145) | i2112)) | 4211778) * (-68)) + ((~((-302026790) | i2112)) * (-68)) + (((~(306238567 | i2112)) | (-504410934)) * 68);
                int i2114 = (i2113 << 13) ^ i2113;
                int i2115 = i2114 ^ (i2114 >>> 17);
                ((int[]) objArr1113[3])[0] = i2115 ^ (i2115 << 5);
                return;
            }
            i2 = 0;
            if (j2 != -1) {
                i9 = 0;
                if (j2 + 1998 >= ((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue()) {
                    objAccessartificialFrame26 = ArtificialStackFrames.accessartificialFrame(1575402270);
                    if (objAccessartificialFrame26 == null) {
                        int iRed2 = Color.red(0) + 17;
                        char keyRepeatTimeout2 = (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16);
                        int capsMode5 = 747 - TextUtils.getCapsMode("", 0, 0);
                        Object[] objArr518 = new Object[1];
                        b((byte) 47, $$a[86], (byte) 56, objArr518);
                        objAccessartificialFrame26 = ArtificialStackFrames.coroutineCreation(iRed2, keyRepeatTimeout2, capsMode5, -1031537386, false, (String) objArr518[0], null);
                    }
                    Object[] objArr519 = (Object[]) ((Field) objAccessartificialFrame26).get(null);
                    objArr4 = new Object[]{list, new int[1], list2, new int[]{i101}, new int[]{i102}};
                    int i1012 = ((int[]) objArr519[3])[0];
                    int i1013 = ((int[]) objArr519[4])[0];
                    List list11 = (List) objArr519[0];
                    List list12 = (List) objArr519[2];
                    int iNextInt2 = new Random().nextInt(1023618577);
                    int i1014 = (~((-284313307) | iNextInt2)) | 270533130;
                    int i1015 = ~((~iNextInt2) | 334915327);
                    int i1016 = (-1092999323) + ((i1014 | i1015) * (-470)) + (((~(iNextInt2 | (-13780177))) | i1015) * 470) + 379948054;
                    int i1017 = (i1016 << 13) ^ i1016;
                    int i1018 = i1017 ^ (i1017 >>> 17);
                    ((int[]) objArr4[1])[0] = i1018 ^ (i1018 << 5);
                }
                i10 = ((int[]) objArr4[4])[0];
                i11 = ((int[]) objArr4[3])[0];
                if (i11 == i10) {
                    int i1019 = getARTIFICIAL_FRAME_PACKAGE_NAME + 55;
                    artificialFrame = i1019 % 128;
                    int i10110 = i1019 % 2;
                    Object[] objArr5110 = {list7, new int[1], list8, new int[]{i1111}, new int[]{i1112}};
                    int i11110 = ((int[]) objArr4[1])[0];
                    int i11111 = ((int[]) objArr4[3])[0];
                    int i11112 = ((int[]) objArr4[4])[0];
                    List list13 = (List) objArr4[0];
                    List list14 = (List) objArr4[2];
                    int iMaxMemory4 = (int) Runtime.getRuntime().maxMemory();
                    int i11113 = 46644816 + (((~((~iMaxMemory4) | (-3565675))) | 1468512) * (-245));
                    int i11114 = ~(iMaxMemory4 | (-3565675));
                    int i11115 = i11110 + i11113 + (i11114 * (-245)) + ((i11114 | 601882783) * 245);
                    int i11116 = (i11115 << 13) ^ i11115;
                    int i11117 = i11116 ^ (i11116 >>> 17);
                    i12 = 0;
                    ((int[]) objArr5110[1])[0] = i11117 ^ (i11117 << 5);
                } else {
                    ArrayList arrayList6 = new ArrayList();
                    Object[] objArr5111 = {objArr4};
                    objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(1804664566);
                    if (objAccessartificialFrame10 == null) {
                        objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(((byte) KeyEvent.getModifierMetaStateMask()) + 42, (char) (TextUtils.getCapsMode("", 0, 0) + 12468), (-16773574) - Color.rgb(0, 0, 0), -185222914, false, "coroutineCreation", new Class[]{Object[].class});
                    }
                    arrayList6.add(((Method) objAccessartificialFrame10).invoke(null, objArr5111));
                    Object[] objArr5112 = {objArr4};
                    objAccessartificialFrame11 = ArtificialStackFrames.accessartificialFrame(-1243809191);
                    if (objAccessartificialFrame11 == null) {
                        objAccessartificialFrame11 = ArtificialStackFrames.coroutineCreation(AndroidCharacter.getMirror('0') - 7, (char) (12468 - ExpandableListView.getPackedPositionType(0L)), (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 3642, 716815441, false, "ArtificialStackFrames", new Class[]{Object[].class});
                    }
                    arrayList6.add(((Method) objAccessartificialFrame11).invoke(null, objArr5112));
                    Object[] objArr5113 = {Long.valueOf(((long) (i10 ^ i11)) ^ (((long) 783305454) << 32)), Long.valueOf(783305446)};
                    byte[] bArr1110 = $$d;
                    Object[] objArr5114 = new Object[1];
                    c(bArr1110[57], bArr1110[46], (short) 282, objArr5114);
                    Class<?> cls116 = Class.forName((String) objArr5114[0]);
                    byte b1111 = (byte) (-bArr1110[1]);
                    Object[] objArr5115 = new Object[1];
                    c(b1111, (byte) (b1111 + 4), (short) 157, objArr5115);
                    cls116.getMethod((String) objArr5115[0], Long.TYPE, Long.TYPE).invoke(null, objArr5113);
                    Object[] objArr5116 = {list9, new int[1], list10, new int[]{i1119}, new int[]{i1210}};
                    int i11118 = ((int[]) objArr4[1])[0];
                    int i11119 = ((int[]) objArr4[3])[0];
                    int i1215 = ((int[]) objArr4[4])[0];
                    List list15 = (List) objArr4[0];
                    List list16 = (List) objArr4[2];
                    int i1216 = ~(((Context) Class.forName("android.app.ActivityThread").getMethod(str, new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) - 197842764);
                    int i1217 = i11118 + 920553229 + ((~((-42991794) | i1216)) * (-783)) + (((~(i1216 | 424032078)) | (-181416380)) * 783);
                    int i1218 = (i1217 << 13) ^ i1217;
                    int i1219 = i1218 ^ (i1218 >>> 17);
                    i12 = 0;
                    ((int[]) objArr5116[1])[0] = i1219 ^ (i1219 << 5);
                }
                objAccessartificialFrame12 = ArtificialStackFrames.accessartificialFrame(-444530678);
                if (objAccessartificialFrame12 == null) {
                    int iGreen3 = Color.green(i12) + 26;
                    char cMakeMeasureSpec3 = (char) View.MeasureSpec.makeMeasureSpec(i12, i12);
                    int iMyTid4 = (Process.myTid() >> 22) + 1041;
                    byte b1112 = $$a[86];
                    Object[] objArr5117 = new Object[1];
                    b((byte) 47, b1112, (byte) (b1112 << 2), objArr5117);
                    objAccessartificialFrame12 = ArtificialStackFrames.coroutineCreation(iGreen3, cMakeMeasureSpec3, iMyTid4, 2061780482, false, (String) objArr5117[0], null);
                }
                j3 = ((Field) objAccessartificialFrame12).getLong(null);
                if (j3 != -1) {
                    int iIntValue7 = ((Integer) Class.forName(str4).getMethod(str5, Object.class).invoke(null, this)).intValue();
                    Object[] objArr6110 = {-1569097084};
                    objAccessartificialFrame13 = ArtificialStackFrames.accessartificialFrame(-1648942878);
                    if (objAccessartificialFrame13 == null) {
                        objAccessartificialFrame13 = ArtificialStackFrames.coroutineCreation(9 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), (char) ((ViewConfiguration.getTapTimeout() >> 16) + 22251), 1033 - ((Process.getThreadPriority(0) + 20) >> 6), 47343338, false, null, new Class[]{Integer.TYPE});
                    }
                    objArrAccessartificialFrame$78cbbd35 = IResultReceiver2._Parcel.accessartificialFrame$78cbbd35(iIntValue7, 0, ((Constructor) objAccessartificialFrame13).newInstance(objArr6110), 252827598, false);
                    objAccessartificialFrame14 = ArtificialStackFrames.accessartificialFrame(-614804952);
                    if (objAccessartificialFrame14 == null) {
                        int iCombineMeasuredStates4 = View.combineMeasuredStates(0, 0) + 26;
                        char c12 = (char) (1 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)));
                        int iAlpha7 = 1041 - Color.alpha(0);
                        Object[] objArr6111 = new Object[1];
                        b((byte) 47, $$a[86], (byte) 56, objArr6111);
                        objAccessartificialFrame14 = ArtificialStackFrames.coroutineCreation(iCombineMeasuredStates4, c12, iAlpha7, 1145017376, false, (String) objArr6111[0], null);
                    }
                    ((Field) objAccessartificialFrame14).set(null, objArrAccessartificialFrame$78cbbd35);
                    Long lValueOf18 = Long.valueOf(((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame15 = ArtificialStackFrames.accessartificialFrame(-444530678);
                    if (objAccessartificialFrame15 == null) {
                        int trimmedLength13 = 26 - TextUtils.getTrimmedLength("");
                        char c13 = (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                        int capsMode6 = TextUtils.getCapsMode("", 0, 0) + 1041;
                        byte b1113 = $$a[86];
                        Object[] objArr6112 = new Object[1];
                        b((byte) 47, b1113, (byte) (b1113 << 2), objArr6112);
                        objAccessartificialFrame15 = ArtificialStackFrames.coroutineCreation(trimmedLength13, c13, capsMode6, 2061780482, false, (String) objArr6112[0], null);
                    }
                    ((Field) objAccessartificialFrame15).set(null, lValueOf18);
                } else {
                    int iIntValue8 = ((Integer) Class.forName(str4).getMethod(str5, Object.class).invoke(null, this)).intValue();
                    Object[] objArr6113 = {-1569097084};
                    objAccessartificialFrame13 = ArtificialStackFrames.accessartificialFrame(-1648942878);
                    if (objAccessartificialFrame13 == null) {
                        objAccessartificialFrame13 = ArtificialStackFrames.coroutineCreation(9 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), (char) ((ViewConfiguration.getTapTimeout() >> 16) + 22251), 1033 - ((Process.getThreadPriority(0) + 20) >> 6), 47343338, false, null, new Class[]{Integer.TYPE});
                    }
                    objArrAccessartificialFrame$78cbbd35 = IResultReceiver2._Parcel.accessartificialFrame$78cbbd35(iIntValue8, 0, ((Constructor) objAccessartificialFrame13).newInstance(objArr6113), 252827598, false);
                    objAccessartificialFrame14 = ArtificialStackFrames.accessartificialFrame(-614804952);
                    if (objAccessartificialFrame14 == null) {
                        int iCombineMeasuredStates5 = View.combineMeasuredStates(0, 0) + 26;
                        char c14 = (char) (1 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)));
                        int iAlpha8 = 1041 - Color.alpha(0);
                        Object[] objArr6114 = new Object[1];
                        b((byte) 47, $$a[86], (byte) 56, objArr6114);
                        objAccessartificialFrame14 = ArtificialStackFrames.coroutineCreation(iCombineMeasuredStates5, c14, iAlpha8, 1145017376, false, (String) objArr6114[0], null);
                    }
                    ((Field) objAccessartificialFrame14).set(null, objArrAccessartificialFrame$78cbbd35);
                    Long lValueOf19 = Long.valueOf(((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame15 = ArtificialStackFrames.accessartificialFrame(-444530678);
                    if (objAccessartificialFrame15 == null) {
                        int trimmedLength14 = 26 - TextUtils.getTrimmedLength("");
                        char c15 = (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                        int capsMode7 = TextUtils.getCapsMode("", 0, 0) + 1041;
                        byte b1114 = $$a[86];
                        Object[] objArr6115 = new Object[1];
                        b((byte) 47, b1114, (byte) (b1114 << 2), objArr6115);
                        objAccessartificialFrame15 = ArtificialStackFrames.coroutineCreation(trimmedLength14, c15, capsMode7, 2061780482, false, (String) objArr6115[0], null);
                    }
                    ((Field) objAccessartificialFrame15).set(null, lValueOf19);
                }
                i13 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
                i14 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
                if (i14 == i13) {
                    Object[] objArr6116 = {strArr13, new int[1], new int[]{i1312}, new int[]{i1311}};
                    int i1319 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
                    int i13110 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
                    int i13111 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
                    String[] strArr19 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
                    int iIdentityHashCode10 = System.identityHashCode(this);
                    int i13112 = ~iIdentityHashCode10;
                    int i13113 = i1319 + 831945840 + (((~(76784249 | i13112)) | (~((-75530242) | iIdentityHashCode10))) * (-831)) + ((~(230418297 | iIdentityHashCode10)) * (-1662)) + (((~(iIdentityHashCode10 | (-76784250))) | (~(i13112 | (-154888057))) | (~(154888056 | iIdentityHashCode10))) * 831);
                    int i13114 = (i13113 << 13) ^ i13113;
                    int i13115 = i13114 ^ (i13114 >>> 17);
                    ((int[]) objArr6116[1])[0] = i13115 ^ (i13115 << 5);
                    i15 = 0;
                } else {
                    arrayList = new ArrayList();
                    strArr = (String[]) objArrAccessartificialFrame$78cbbd35[0];
                    if (strArr != null) {
                        i16 = 0;
                        while (i16 < strArr.length) {
                            i17 = getARTIFICIAL_FRAME_PACKAGE_NAME + 91;
                            artificialFrame = i17 % 128;
                            if (i17 % 2 == 0) {
                                arrayList.add(strArr[i16]);
                                i16 += 88;
                            } else {
                                arrayList.add(strArr[i16]);
                                i16++;
                            }
                        }
                    }
                    Object[] objArr6117 = objArrAccessartificialFrame$78cbbd35;
                    Object[] objArr6118 = {Long.valueOf(((long) (i13 ^ i14)) ^ (((long) (-1600638879)) << 32)), Long.valueOf(-1600638877)};
                    byte[] bArr1111 = $$d;
                    Object[] objArr6119 = new Object[1];
                    c(bArr1111[45], bArr1111[452], (short) 354, objArr6119);
                    Class<?> cls117 = Class.forName((String) objArr6119[0]);
                    byte b1115 = (byte) (-bArr1111[1]);
                    Object[] objArr621 = new Object[1];
                    c(b1115, (byte) (b1115 + 4), (short) 157, objArr621);
                    cls117.getMethod((String) objArr621[0], Long.TYPE, Long.TYPE).invoke(null, objArr6118);
                    Object[] objArr7114 = {strArr14, new int[1], new int[]{i1410}, new int[]{i1318}};
                    int i13116 = ((int[]) objArr6117[1])[0];
                    int i13117 = ((int[]) objArr6117[3])[0];
                    int i1419 = ((int[]) objArr6117[2])[0];
                    String[] strArr110 = (String[]) objArr6117[0];
                    int i14110 = ((Context) Class.forName("android.app.ActivityThread").getMethod(str, new Class[0]).invoke(null, null)).getResources().getConfiguration().touchscreen;
                    int i14111 = ~i14110;
                    int i14112 = i13116 + 1069043538 + (((~(243663665 | i14111)) | (-531614514)) * 98) + (((~(i14111 | (-321767473))) | 243663665 | (~(321767472 | i14110))) * (-49)) + (((~(i14110 | 243663665)) | 209847041) * 49);
                    int i14113 = (i14112 << 13) ^ i14112;
                    int i14114 = i14113 ^ (i14113 >>> 17);
                    i15 = 0;
                    ((int[]) objArr7114[1])[0] = i14114 ^ (i14114 << 5);
                }
                objAccessartificialFrame16 = ArtificialStackFrames.accessartificialFrame(1056123296);
                if (objAccessartificialFrame16 == null) {
                    int iAlpha9 = 30 - Color.alpha(i15);
                    char cNormalizeMetaState3 = (char) (49362 - KeyEvent.normalizeMetaState(i15));
                    int i14115 = (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 683;
                    byte[] bArr1112 = $$a;
                    Object[] objArr7115 = new Object[1];
                    b(bArr1112[i15], bArr1112[82], (byte) ($$b >>> 1), objArr7115);
                    objAccessartificialFrame16 = ArtificialStackFrames.coroutineCreation(iAlpha9, cNormalizeMetaState3, i14115, -1583976536, false, (String) objArr7115[i15], null);
                }
                j4 = ((Field) objAccessartificialFrame16).getLong(null);
                if (j4 != -1) {
                    Object[] objArr7116 = {Integer.valueOf(((Integer) Class.forName(str4).getMethod(str5, Object.class).invoke(null, this)).intValue()), 1109377758};
                    byte[] bArr1113 = $$d;
                    byte b1116 = bArr1113[57];
                    byte b1117 = bArr1113[45];
                    Object[] objArr7117 = new Object[1];
                    c(b1116, b1117, (short) (b1117 | 408), objArr7117);
                    Class<?> cls118 = Class.forName((String) objArr7117[0]);
                    byte b1118 = bArr1113[57];
                    byte b2110 = bArr1113[185];
                    Object[] objArr7118 = new Object[1];
                    c(b1118, b2110, (short) (b2110 | 424), objArr7118);
                    Object[] objArr7119 = (Object[]) cls118.getMethod((String) objArr7118[0], Integer.TYPE, Integer.TYPE).invoke(null, objArr7116);
                    objAccessartificialFrame17 = ArtificialStackFrames.accessartificialFrame(910856866);
                    if (objAccessartificialFrame17 == null) {
                        int doubleTapTimeout4 = 30 - (ViewConfiguration.getDoubleTapTimeout() >> 16);
                        char c16 = (char) (49362 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)));
                        int threadPriority4 = ((Process.getThreadPriority(0) + 20) >> 6) + 684;
                        Object[] objArr71110 = new Object[1];
                        b((byte) ($$b & WebSocketProtocol.PAYLOAD_SHORT), $$a[86], (byte) 96, objArr71110);
                        objAccessartificialFrame17 = ArtificialStackFrames.coroutineCreation(doubleTapTimeout4, c16, threadPriority4, -1456483158, false, (String) objArr71110[0], null);
                    }
                    ((Field) objAccessartificialFrame17).set(null, objArr7119);
                    Long lValueOf110 = Long.valueOf(((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame18 = ArtificialStackFrames.accessartificialFrame(1056123296);
                    if (objAccessartificialFrame18 == null) {
                        int iResolveSize4 = 30 - View.resolveSize(0, 0);
                        char offsetAfter10 = (char) (49362 - TextUtils.getOffsetAfter("", 0));
                        int i14116 = (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 683;
                        byte[] bArr1114 = $$a;
                        Object[] objArr71111 = new Object[1];
                        b(bArr1114[0], bArr1114[82], (byte) ($$b >>> 1), objArr71111);
                        objAccessartificialFrame18 = ArtificialStackFrames.coroutineCreation(iResolveSize4, offsetAfter10, i14116, -1583976536, false, (String) objArr71111[0], null);
                    }
                    ((Field) objAccessartificialFrame18).set(null, lValueOf110);
                    objArr5 = objArr7119;
                } else {
                    Object[] objArr71112 = {Integer.valueOf(((Integer) Class.forName(str4).getMethod(str5, Object.class).invoke(null, this)).intValue()), 1109377758};
                    byte[] bArr1115 = $$d;
                    byte b1119 = bArr1115[57];
                    byte b11110 = bArr1115[45];
                    Object[] objArr71113 = new Object[1];
                    c(b1119, b11110, (short) (b11110 | 408), objArr71113);
                    Class<?> cls119 = Class.forName((String) objArr71113[0]);
                    byte b11111 = bArr1115[57];
                    byte b2111 = bArr1115[185];
                    Object[] objArr71114 = new Object[1];
                    c(b11111, b2111, (short) (b2111 | 424), objArr71114);
                    Object[] objArr71115 = (Object[]) cls119.getMethod((String) objArr71114[0], Integer.TYPE, Integer.TYPE).invoke(null, objArr71112);
                    objAccessartificialFrame17 = ArtificialStackFrames.accessartificialFrame(910856866);
                    if (objAccessartificialFrame17 == null) {
                        int doubleTapTimeout5 = 30 - (ViewConfiguration.getDoubleTapTimeout() >> 16);
                        char c17 = (char) (49362 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)));
                        int threadPriority5 = ((Process.getThreadPriority(0) + 20) >> 6) + 684;
                        Object[] objArr71116 = new Object[1];
                        b((byte) ($$b & WebSocketProtocol.PAYLOAD_SHORT), $$a[86], (byte) 96, objArr71116);
                        objAccessartificialFrame17 = ArtificialStackFrames.coroutineCreation(doubleTapTimeout5, c17, threadPriority5, -1456483158, false, (String) objArr71116[0], null);
                    }
                    ((Field) objAccessartificialFrame17).set(null, objArr71115);
                    Long lValueOf111 = Long.valueOf(((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame18 = ArtificialStackFrames.accessartificialFrame(1056123296);
                    if (objAccessartificialFrame18 == null) {
                        int iResolveSize5 = 30 - View.resolveSize(0, 0);
                        char offsetAfter11 = (char) (49362 - TextUtils.getOffsetAfter("", 0));
                        int i14117 = (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 683;
                        byte[] bArr1116 = $$a;
                        Object[] objArr71117 = new Object[1];
                        b(bArr1116[0], bArr1116[82], (byte) ($$b >>> 1), objArr71117);
                        objAccessartificialFrame18 = ArtificialStackFrames.coroutineCreation(iResolveSize5, offsetAfter11, i14117, -1583976536, false, (String) objArr71117[0], null);
                    }
                    ((Field) objAccessartificialFrame18).set(null, lValueOf111);
                    objArr5 = objArr71115;
                }
                i18 = ((int[]) objArr5[1])[0];
                i19 = ((int[]) objArr5[0])[0];
                if (i19 == i18) {
                    int i1517 = getARTIFICIAL_FRAME_PACKAGE_NAME + 71;
                    artificialFrame = i1517 % 128;
                    int i1518 = i1517 % 2;
                    int i1519 = ((int[]) objArr5[2])[0];
                    Object[] objArr8114 = {new int[]{((int[]) objArr5[0])[0]}, new int[]{((int[]) objArr5[1])[0]}, new int[1], (String) objArr5[3]};
                    int i15110 = (int) Runtime.getRuntime().totalMemory();
                    int i15111 = (-558569362) + (((~((-61450044) | i15110)) | (-917173732)) * (-318));
                    int i15112 = ~((-917173732) | i15110);
                    int i15113 = ~i15110;
                    int i16111 = i1519 + i15111 + ((i15112 | (~(934017019 | i15113))) * TypedValues.AttributesType.TYPE_PIVOT_TARGET) + (((~(i15110 | 934017019)) | (~((-872566977) | i15113))) * TypedValues.AttributesType.TYPE_PIVOT_TARGET);
                    int i16112 = (i16111 << 13) ^ i16111;
                    int i16113 = i16112 ^ (i16112 >>> 17);
                    ((int[]) objArr8114[2])[0] = i16113 ^ (i16113 << 5);
                    i20 = 0;
                } else {
                    new ArrayList().add((String) objArr5[3]);
                    Object[] objArr8115 = {Long.valueOf(((long) (i18 ^ i19)) ^ (((long) 183072593) << 32)), Long.valueOf(183072577)};
                    byte[] bArr1117 = $$d;
                    Object[] objArr8116 = new Object[1];
                    c(bArr1117[57], bArr1117[25], (short) 91, objArr8116);
                    Class<?> cls21 = Class.forName((String) objArr8116[0]);
                    byte b2112 = (byte) (-bArr1117[1]);
                    Object[] objArr8117 = new Object[1];
                    c(b2112, (byte) (b2112 + 4), (short) 157, objArr8117);
                    cls21.getMethod((String) objArr8117[0], Long.TYPE, Long.TYPE).invoke(null, objArr8115);
                    int i16114 = ((int[]) objArr5[2])[0];
                    Object[] objArr8118 = {new int[]{((int[]) objArr5[0])[0]}, new int[]{((int[]) objArr5[1])[0]}, new int[1], (String) objArr5[3]};
                    int iIdentityHashCode11 = System.identityHashCode(this);
                    int i16115 = i16114 + (-11707142) + (((~(iIdentityHashCode11 | (-15899194))) | (-994522969)) * (-465)) + (((-15899194) | (~((-994522969) | iIdentityHashCode11))) * 930) + ((iIdentityHashCode11 | (-4330009)) * 465);
                    int i16116 = (i16115 << 13) ^ i16115;
                    int i16117 = i16116 ^ (i16116 >>> 17);
                    i20 = 0;
                    ((int[]) objArr8118[2])[0] = i16117 ^ (i16117 << 5);
                }
                objAccessartificialFrame19 = ArtificialStackFrames.accessartificialFrame(1313006081);
                if (objAccessartificialFrame19 == null) {
                    int offsetBefore4 = 21 - TextUtils.getOffsetBefore("", i20);
                    char cKeyCodeFromString3 = (char) KeyEvent.keyCodeFromString("");
                    int minimumFlingVelocity3 = (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 465;
                    byte b2113 = $$a[86];
                    Object[] objArr8119 = new Object[1];
                    b((byte) 47, b2113, (byte) (b2113 << 2), objArr8119);
                    objAccessartificialFrame19 = ArtificialStackFrames.coroutineCreation(offsetBefore4, cKeyCodeFromString3, minimumFlingVelocity3, -785931255, false, (String) objArr8119[0], null);
                }
                j5 = ((Field) objAccessartificialFrame19).getLong(null);
                if (j5 != -1) {
                    baseContext2 = getBaseContext();
                    if (baseContext2 == null) {
                        Object[] objArr81110 = new Object[1];
                        a(TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 27, new char[]{CharUtils.CR, CoreConstants.SINGLE_QUOTE_CHAR, 21, CoreConstants.DASH_CHAR, CoreConstants.RIGHT_PARENTHESIS_CHAR, 19, 22, 3, '\n', ' ', 29, 3, '\n', '\b', '0', 17, CoreConstants.RIGHT_PARENTHESIS_CHAR, 27, 3, '\n', '#', 15, '/', 0, '\n', 25}, (byte) ((Context) Class.forName("android.app.ActivityThread").getMethod(str, new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion, objArr81110);
                        Class<?> cls1110 = Class.forName((String) objArr81110[0]);
                        Object[] objArr81111 = new Object[1];
                        a(18 - (ViewConfiguration.getLongPressTimeout() >> 16), new char[]{'\b', '*', 13860, 13860, 6, CoreConstants.LEFT_PARENTHESIS_CHAR, CoreConstants.COMMA_CHAR, '\n', 13862, 13862, 20, 27, '\b', '\f', '0', 17, CoreConstants.RIGHT_PARENTHESIS_CHAR, '#'}, (byte) (60 - View.MeasureSpec.getSize(0)), objArr81111);
                        baseContext2 = (Context) cls1110.getMethod((String) objArr81111[0], new Class[0]).invoke(null, null);
                    }
                    if (baseContext2 != null) {
                        if (baseContext2 instanceof ContextWrapper) {
                            baseContext2 = baseContext2.getApplicationContext();
                        } else {
                            baseContext2 = baseContext2.getApplicationContext();
                        }
                    }
                    int iIntValue9 = ((Integer) Class.forName(str4).getMethod(str5, Object.class).invoke(null, this)).intValue();
                    Object[] objArr81112 = new Object[1];
                    a(((Context) Class.forName("android.app.ActivityThread").getMethod(str, new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 43, new char[]{29, '!', 24, '\b', '/', 4, 29, 21, '\t', 0, ' ', '\f', CoreConstants.COMMA_CHAR, CoreConstants.PERCENT_CHAR, 14, 29, 3, 26, 31, '\"', 30, 5, 14, 29, 25, '\b', CoreConstants.COMMA_CHAR, CoreConstants.SINGLE_QUOTE_CHAR, 22, 17, 0, '!', 29, '\"', 31, 26, 14, 29, 0, 30, '#', '\t', 29, '\"', 16, 17, '\t', '#', ' ', 7, '\b', 25, '\t', 23, ' ', '\t', '#', '\t', '\f', 4, 21, '\b', 25, CoreConstants.DASH_CHAR}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod(str, new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 56), objArr81112);
                    String str11 = (String) objArr81112[0];
                    Object[] objArr81113 = new Object[1];
                    a(((Context) Class.forName("android.app.ActivityThread").getMethod(str, new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(0) + 27, new char[]{29, 26, 13857, 13857, 0, '!', CoreConstants.COMMA_CHAR, 23, 30, 4, 28, CoreConstants.LEFT_PARENTHESIS_CHAR, ' ', CoreConstants.COMMA_CHAR, 23, 3, CoreConstants.COMMA_CHAR, ' ', '!', 4, 7, ' ', ' ', '\f', '\t', 23, 31, '\t', 26, 31, Typography.amp, 7, ' ', '/', 13770, 13770, ' ', '\f', '\f', CoreConstants.LEFT_PARENTHESIS_CHAR, 3, '\t', 31, '\f', CoreConstants.COMMA_CHAR, CoreConstants.SINGLE_QUOTE_CHAR, 24, '\b', 25, '+', 7, ' ', CoreConstants.LEFT_PARENTHESIS_CHAR, 0, 13774, 13774, CoreConstants.SINGLE_QUOTE_CHAR, 7, 18, '+', CoreConstants.SINGLE_QUOTE_CHAR, '\t', '!', 0}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod(str, new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) - 2), objArr81113);
                    Object[] objArr9110 = {baseContext2, new String[]{str11, (String) objArr81113[0]}, Integer.valueOf(iIntValue9), 1, 1550163612};
                    byte[] bArr1118 = $$d;
                    byte b2114 = bArr1118[57];
                    byte b2115 = bArr1118[94];
                    Object[] objArr9111 = new Object[1];
                    c(b2114, b2115, (short) (b2115 | 481), objArr9111);
                    Class<?> cls1111 = Class.forName((String) objArr9111[0]);
                    Object[] objArr9112 = new Object[1];
                    c(bArr1118[224], bArr1118[555], (short) 214, objArr9112);
                    objArr6 = (Object[]) cls1111.getMethod((String) objArr9112[0], Context.class, String[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr9110);
                    int i16118 = ((int[]) objArr6[0])[0];
                    int i16119 = ((int[]) objArr6[3])[0];
                    if (baseContext2 != null) {
                        objAccessartificialFrame20 = ArtificialStackFrames.accessartificialFrame(1142731807);
                        if (objAccessartificialFrame20 == null) {
                            int trimmedLength15 = 21 - TextUtils.getTrimmedLength("");
                            char scrollDefaultDelay4 = (char) (ViewConfiguration.getScrollDefaultDelay() >> 16);
                            int scrollBarSize9 = 465 - (ViewConfiguration.getScrollBarSize() >> 8);
                            Object[] objArr9113 = new Object[1];
                            b((byte) 47, $$a[86], (byte) 56, objArr9113);
                            objAccessartificialFrame20 = ArtificialStackFrames.coroutineCreation(trimmedLength15, scrollDefaultDelay4, scrollBarSize9, -612765161, false, (String) objArr9113[0], null);
                        }
                        ((Field) objAccessartificialFrame20).set(null, objArr6);
                        Long lValueOf112 = Long.valueOf(((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame21 = ArtificialStackFrames.accessartificialFrame(1313006081);
                        if (objAccessartificialFrame21 == null) {
                            int touchSlop4 = 21 - (ViewConfiguration.getTouchSlop() >> 8);
                            char offsetAfter12 = (char) TextUtils.getOffsetAfter("", 0);
                            int pressedStateDuration4 = (ViewConfiguration.getPressedStateDuration() >> 16) + 465;
                            byte b2116 = $$a[86];
                            Object[] objArr9114 = new Object[1];
                            b((byte) 47, b2116, (byte) (b2116 << 2), objArr9114);
                            objAccessartificialFrame21 = ArtificialStackFrames.coroutineCreation(touchSlop4, offsetAfter12, pressedStateDuration4, -785931255, false, (String) objArr9114[0], null);
                        }
                        ((Field) objAccessartificialFrame21).set(null, lValueOf112);
                    }
                    c = 0;
                } else {
                    baseContext2 = getBaseContext();
                    if (baseContext2 == null) {
                        Object[] objArr81114 = new Object[1];
                        a(TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 27, new char[]{CharUtils.CR, CoreConstants.SINGLE_QUOTE_CHAR, 21, CoreConstants.DASH_CHAR, CoreConstants.RIGHT_PARENTHESIS_CHAR, 19, 22, 3, '\n', ' ', 29, 3, '\n', '\b', '0', 17, CoreConstants.RIGHT_PARENTHESIS_CHAR, 27, 3, '\n', '#', 15, '/', 0, '\n', 25}, (byte) ((Context) Class.forName("android.app.ActivityThread").getMethod(str, new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion, objArr81114);
                        Class<?> cls1112 = Class.forName((String) objArr81114[0]);
                        Object[] objArr81115 = new Object[1];
                        a(18 - (ViewConfiguration.getLongPressTimeout() >> 16), new char[]{'\b', '*', 13860, 13860, 6, CoreConstants.LEFT_PARENTHESIS_CHAR, CoreConstants.COMMA_CHAR, '\n', 13862, 13862, 20, 27, '\b', '\f', '0', 17, CoreConstants.RIGHT_PARENTHESIS_CHAR, '#'}, (byte) (60 - View.MeasureSpec.getSize(0)), objArr81115);
                        baseContext2 = (Context) cls1112.getMethod((String) objArr81115[0], new Class[0]).invoke(null, null);
                    }
                    if (baseContext2 != null) {
                        if (baseContext2 instanceof ContextWrapper) {
                            baseContext2 = baseContext2.getApplicationContext();
                        } else {
                            baseContext2 = baseContext2.getApplicationContext();
                        }
                    }
                    int iIntValue10 = ((Integer) Class.forName(str4).getMethod(str5, Object.class).invoke(null, this)).intValue();
                    Object[] objArr81116 = new Object[1];
                    a(((Context) Class.forName("android.app.ActivityThread").getMethod(str, new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 43, new char[]{29, '!', 24, '\b', '/', 4, 29, 21, '\t', 0, ' ', '\f', CoreConstants.COMMA_CHAR, CoreConstants.PERCENT_CHAR, 14, 29, 3, 26, 31, '\"', 30, 5, 14, 29, 25, '\b', CoreConstants.COMMA_CHAR, CoreConstants.SINGLE_QUOTE_CHAR, 22, 17, 0, '!', 29, '\"', 31, 26, 14, 29, 0, 30, '#', '\t', 29, '\"', 16, 17, '\t', '#', ' ', 7, '\b', 25, '\t', 23, ' ', '\t', '#', '\t', '\f', 4, 21, '\b', 25, CoreConstants.DASH_CHAR}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod(str, new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 56), objArr81116);
                    String str12 = (String) objArr81116[0];
                    Object[] objArr81117 = new Object[1];
                    a(((Context) Class.forName("android.app.ActivityThread").getMethod(str, new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(0) + 27, new char[]{29, 26, 13857, 13857, 0, '!', CoreConstants.COMMA_CHAR, 23, 30, 4, 28, CoreConstants.LEFT_PARENTHESIS_CHAR, ' ', CoreConstants.COMMA_CHAR, 23, 3, CoreConstants.COMMA_CHAR, ' ', '!', 4, 7, ' ', ' ', '\f', '\t', 23, 31, '\t', 26, 31, Typography.amp, 7, ' ', '/', 13770, 13770, ' ', '\f', '\f', CoreConstants.LEFT_PARENTHESIS_CHAR, 3, '\t', 31, '\f', CoreConstants.COMMA_CHAR, CoreConstants.SINGLE_QUOTE_CHAR, 24, '\b', 25, '+', 7, ' ', CoreConstants.LEFT_PARENTHESIS_CHAR, 0, 13774, 13774, CoreConstants.SINGLE_QUOTE_CHAR, 7, 18, '+', CoreConstants.SINGLE_QUOTE_CHAR, '\t', '!', 0}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod(str, new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) - 2), objArr81117);
                    Object[] objArr9115 = {baseContext2, new String[]{str12, (String) objArr81117[0]}, Integer.valueOf(iIntValue10), 1, 1550163612};
                    byte[] bArr1119 = $$d;
                    byte b2117 = bArr1119[57];
                    byte b2118 = bArr1119[94];
                    Object[] objArr9116 = new Object[1];
                    c(b2117, b2118, (short) (b2118 | 481), objArr9116);
                    Class<?> cls1113 = Class.forName((String) objArr9116[0]);
                    Object[] objArr9117 = new Object[1];
                    c(bArr1119[224], bArr1119[555], (short) 214, objArr9117);
                    objArr6 = (Object[]) cls1113.getMethod((String) objArr9117[0], Context.class, String[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr9115);
                    int i161110 = ((int[]) objArr6[0])[0];
                    int i161111 = ((int[]) objArr6[3])[0];
                    if (baseContext2 != null) {
                        objAccessartificialFrame20 = ArtificialStackFrames.accessartificialFrame(1142731807);
                        if (objAccessartificialFrame20 == null) {
                            int trimmedLength16 = 21 - TextUtils.getTrimmedLength("");
                            char scrollDefaultDelay5 = (char) (ViewConfiguration.getScrollDefaultDelay() >> 16);
                            int scrollBarSize10 = 465 - (ViewConfiguration.getScrollBarSize() >> 8);
                            Object[] objArr9118 = new Object[1];
                            b((byte) 47, $$a[86], (byte) 56, objArr9118);
                            objAccessartificialFrame20 = ArtificialStackFrames.coroutineCreation(trimmedLength16, scrollDefaultDelay5, scrollBarSize10, -612765161, false, (String) objArr9118[0], null);
                        }
                        ((Field) objAccessartificialFrame20).set(null, objArr6);
                        Long lValueOf113 = Long.valueOf(((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame21 = ArtificialStackFrames.accessartificialFrame(1313006081);
                        if (objAccessartificialFrame21 == null) {
                            int touchSlop5 = 21 - (ViewConfiguration.getTouchSlop() >> 8);
                            char offsetAfter13 = (char) TextUtils.getOffsetAfter("", 0);
                            int pressedStateDuration5 = (ViewConfiguration.getPressedStateDuration() >> 16) + 465;
                            byte b2119 = $$a[86];
                            Object[] objArr9119 = new Object[1];
                            b((byte) 47, b2119, (byte) (b2119 << 2), objArr9119);
                            objAccessartificialFrame21 = ArtificialStackFrames.coroutineCreation(touchSlop5, offsetAfter13, pressedStateDuration5, -785931255, false, (String) objArr9119[0], null);
                        }
                        ((Field) objAccessartificialFrame21).set(null, lValueOf113);
                    }
                    c = 0;
                }
                i21 = ((int[]) objArr6[c])[c];
                i22 = ((int[]) objArr6[3])[c];
                if (i22 == i21) {
                    Object[] objArr923 = new Object[4];
                    int[] iArr5 = new int[1];
                    objArr923[c] = iArr5;
                    objArr923[2] = new int[1];
                    int[] iArr6 = new int[1];
                    objArr923[3] = iArr6;
                    int i1714 = ((int[]) objArr6[2])[c];
                    int i1715 = ((int[]) objArr6[3])[c];
                    int i1716 = ((int[]) objArr6[c])[c];
                    String[] strArr111 = (String[]) objArr6[1];
                    iArr6[c] = i1715;
                    iArr5[c] = i1716;
                    int iIdentityHashCode12 = System.identityHashCode(this);
                    int i1717 = ~iIdentityHashCode12;
                    int i18110 = i1714 + 1757838936 + (((~((-140681629) | i1717)) | (-19668098)) * (-865)) + ((~(iIdentityHashCode12 | 140681628)) * 865) + (((~((-19668098) | i1717)) | (~(i1717 | 140681628))) * 865);
                    int i18111 = (i18110 << 13) ^ i18110;
                    int i18112 = i18111 ^ (i18111 >>> 17);
                    ((int[]) objArr923[2])[0] = i18112 ^ (i18112 << 5);
                    objArr923[1] = strArr111;
                    i23 = 0;
                } else {
                    arrayList2 = new ArrayList();
                    strArr2 = (String[]) objArr6[1];
                    if (strArr2 != null) {
                        while (i24 < strArr2.length) {
                            arrayList2.add(str7);
                        }
                    }
                    Object[] objArr924 = {Long.valueOf(((long) (i21 ^ i22)) ^ (((long) 1235250365) << 32)), Long.valueOf(1235250429)};
                    byte[] bArr123 = $$d;
                    Object[] objArr925 = new Object[1];
                    c(bArr123[57], bArr123[358], (short) 562, objArr925);
                    Class<?> cls1114 = Class.forName((String) objArr925[0]);
                    byte b225 = (byte) (-bArr123[1]);
                    Object[] objArr10111 = new Object[1];
                    c(b225, (byte) (b225 + 4), (short) 157, objArr10111);
                    cls1114.getMethod((String) objArr10111[0], Long.TYPE, Long.TYPE).invoke(null, objArr924);
                    Object[] objArr10112 = {new int[]{i1815}, strArr16, new int[1], new int[]{i1814}};
                    int i18113 = ((int[]) objArr6[2])[0];
                    int i18114 = ((int[]) objArr6[3])[0];
                    int i18115 = ((int[]) objArr6[0])[0];
                    String[] strArr112 = (String[]) objArr6[1];
                    int i18116 = ~Process.myPid();
                    int i18117 = i18113 + 720771397 + (((~(i18116 | 519831146)) | (~((-702537) | i18116))) * (-184)) + ((339739168 | (~((-340441705) | i18116)) | (~(180091978 | i18116))) * SyslogConstants.LOG_LOCAL7) + 1352080856;
                    int i18118 = (i18117 << 13) ^ i18117;
                    int i18119 = i18118 ^ (i18118 >>> 17);
                    i23 = 0;
                    ((int[]) objArr10112[2])[0] = i18119 ^ (i18119 << 5);
                }
                super.onStart();
                objAccessartificialFrame22 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                if (objAccessartificialFrame22 == null) {
                    int defaultSize3 = View.getDefaultSize(i23, i23) + 25;
                    char cRgb3 = (char) (Color.rgb(i23, i23, i23) + 16807284);
                    int mode6 = 816 - View.MeasureSpec.getMode(i23);
                    byte b226 = $$a[86];
                    Object[] objArr10113 = new Object[1];
                    b((byte) 47, b226, (byte) (b226 << 2), objArr10113);
                    objAccessartificialFrame22 = ArtificialStackFrames.coroutineCreation(defaultSize3, cRgb3, mode6, 721586079, false, (String) objArr10113[0], null);
                }
                j6 = ((Field) objAccessartificialFrame22).getLong(null);
                if (j6 != -1) {
                    Object[] objArr10114 = {Integer.valueOf(((Integer) Class.forName(str4).getMethod(str5, Object.class).invoke(null, this)).intValue()), 0, 1771123361};
                    objAccessartificialFrame23 = ArtificialStackFrames.accessartificialFrame(1327366003);
                    if (objAccessartificialFrame23 == null) {
                        int i1912 = 26 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                        char cCombineMeasuredStates5 = (char) (30068 - View.combineMeasuredStates(0, 0));
                        int trimmedLength17 = 816 - TextUtils.getTrimmedLength("");
                        byte[] bArr124 = $$a;
                        Object[] objArr10115 = new Object[1];
                        b(bArr124[10], bArr124[26], (byte) 104, objArr10115);
                        objAccessartificialFrame23 = ArtificialStackFrames.coroutineCreation(i1912, cCombineMeasuredStates5, trimmedLength17, -797394565, false, (String) objArr10115[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                    }
                    objArr7 = (Object[]) ((Method) objAccessartificialFrame23).invoke(null, objArr10114);
                    objAccessartificialFrame24 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                    if (objAccessartificialFrame24 == null) {
                        int scrollBarSize11 = 25 - (ViewConfiguration.getScrollBarSize() >> 8);
                        char offsetAfter14 = (char) (30068 - TextUtils.getOffsetAfter("", 0));
                        int absoluteGravity5 = Gravity.getAbsoluteGravity(0, 0) + 816;
                        Object[] objArr10116 = new Object[1];
                        b((byte) 47, $$a[86], (byte) 56, objArr10116);
                        objAccessartificialFrame24 = ArtificialStackFrames.coroutineCreation(scrollBarSize11, offsetAfter14, absoluteGravity5, 891606461, false, (String) objArr10116[0], null);
                    }
                    ((Field) objAccessartificialFrame24).set(null, objArr7);
                    Long lValueOf114 = Long.valueOf(((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame25 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                    if (objAccessartificialFrame25 == null) {
                        int edgeSlop4 = (ViewConfiguration.getEdgeSlop() >> 16) + 25;
                        char longPressTimeout5 = (char) (30068 - (ViewConfiguration.getLongPressTimeout() >> 16));
                        int size7 = 816 - View.MeasureSpec.getSize(0);
                        byte b227 = $$a[86];
                        Object[] objArr10117 = new Object[1];
                        b((byte) 47, b227, (byte) (b227 << 2), objArr10117);
                        objAccessartificialFrame25 = ArtificialStackFrames.coroutineCreation(edgeSlop4, longPressTimeout5, size7, 721586079, false, (String) objArr10117[0], null);
                    }
                    ((Field) objAccessartificialFrame25).set(null, lValueOf114);
                } else {
                    Object[] objArr10118 = {Integer.valueOf(((Integer) Class.forName(str4).getMethod(str5, Object.class).invoke(null, this)).intValue()), 0, 1771123361};
                    objAccessartificialFrame23 = ArtificialStackFrames.accessartificialFrame(1327366003);
                    if (objAccessartificialFrame23 == null) {
                        int i1913 = 26 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                        char cCombineMeasuredStates6 = (char) (30068 - View.combineMeasuredStates(0, 0));
                        int trimmedLength18 = 816 - TextUtils.getTrimmedLength("");
                        byte[] bArr125 = $$a;
                        Object[] objArr10119 = new Object[1];
                        b(bArr125[10], bArr125[26], (byte) 104, objArr10119);
                        objAccessartificialFrame23 = ArtificialStackFrames.coroutineCreation(i1913, cCombineMeasuredStates6, trimmedLength18, -797394565, false, (String) objArr10119[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                    }
                    objArr7 = (Object[]) ((Method) objAccessartificialFrame23).invoke(null, objArr10118);
                    objAccessartificialFrame24 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                    if (objAccessartificialFrame24 == null) {
                        int scrollBarSize12 = 25 - (ViewConfiguration.getScrollBarSize() >> 8);
                        char offsetAfter15 = (char) (30068 - TextUtils.getOffsetAfter("", 0));
                        int absoluteGravity6 = Gravity.getAbsoluteGravity(0, 0) + 816;
                        Object[] objArr101110 = new Object[1];
                        b((byte) 47, $$a[86], (byte) 56, objArr101110);
                        objAccessartificialFrame24 = ArtificialStackFrames.coroutineCreation(scrollBarSize12, offsetAfter15, absoluteGravity6, 891606461, false, (String) objArr101110[0], null);
                    }
                    ((Field) objAccessartificialFrame24).set(null, objArr7);
                    Long lValueOf115 = Long.valueOf(((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame25 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                    if (objAccessartificialFrame25 == null) {
                        int edgeSlop5 = (ViewConfiguration.getEdgeSlop() >> 16) + 25;
                        char longPressTimeout6 = (char) (30068 - (ViewConfiguration.getLongPressTimeout() >> 16));
                        int size8 = 816 - View.MeasureSpec.getSize(0);
                        byte b228 = $$a[86];
                        Object[] objArr101111 = new Object[1];
                        b((byte) 47, b228, (byte) (b228 << 2), objArr101111);
                        objAccessartificialFrame25 = ArtificialStackFrames.coroutineCreation(edgeSlop5, longPressTimeout6, size8, 721586079, false, (String) objArr101111[0], null);
                    }
                    ((Field) objAccessartificialFrame25).set(null, lValueOf115);
                }
                i25 = ((int[]) objArr7[1])[0];
                i26 = ((int[]) objArr7[0])[0];
                if (i26 == i25) {
                    int i20110 = getARTIFICIAL_FRAME_PACKAGE_NAME + 119;
                    artificialFrame = i20110 % 128;
                    int i20111 = i20110 % 2;
                    Object[] objArr1021 = {new int[]{i2013}, new int[]{i2014}, strArr17, new int[1]};
                    int i20112 = ((int[]) objArr7[3])[0];
                    int i20113 = ((int[]) objArr7[0])[0];
                    int i20114 = ((int[]) objArr7[1])[0];
                    String[] strArr113 = (String[]) objArr7[2];
                    int iCodePointAt3 = ((Context) Class.forName("android.app.ActivityThread").getMethod(str, new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(10) - 1036900927;
                    int i20115 = ~iCodePointAt3;
                    int i20116 = i20112 + (-99377353) + (((~((-515372982) | i20115)) | 176674433) * (-108)) + (((~(i20115 | 713545347)) | (~((-713545348) | iCodePointAt3)) | (-1052243896)) * 54) + ((iCodePointAt3 | (-1052243896)) * 54);
                    int i20117 = (i20116 << 13) ^ i20116;
                    int i20118 = i20117 ^ (i20117 >>> 17);
                    ((int[]) objArr1021[3])[0] = i20118 ^ (i20118 << 5);
                    return;
                }
                arrayList3 = new ArrayList();
                strArr3 = (String[]) objArr7[2];
                if (strArr3 != null) {
                    while (i27 < strArr3.length) {
                        arrayList3.add(str8);
                    }
                }
                long j13 = ((long) (i25 ^ i26)) ^ (((long) 1508793583) << 32);
                long j14 = 1508793582;
                int i20119 = artificialFrame + 27;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i20119 % 128;
                int i2116 = i20119 % 2;
                Object[] objArr1114 = {Long.valueOf(j13), Long.valueOf(j14)};
                byte[] bArr23 = $$d;
                Object[] objArr1115 = new Object[1];
                c(bArr23[57], bArr23[62], (short) 600, objArr1115);
                Class<?> cls1115 = Class.forName((String) objArr1115[0]);
                byte b229 = (byte) (-bArr23[1]);
                Object[] objArr1116 = new Object[1];
                c(b229, (byte) (b229 + 4), (short) 157, objArr1116);
                cls1115.getMethod((String) objArr1116[0], Long.TYPE, Long.TYPE).invoke(null, objArr1114);
                Object[] objArr1117 = {new int[]{i2110}, new int[]{i2111}, strArr18, new int[1]};
                int i2117 = ((int[]) objArr7[3])[0];
                int i2118 = ((int[]) objArr7[0])[0];
                int i2119 = ((int[]) objArr7[1])[0];
                String[] strArr114 = (String[]) objArr7[2];
                int iMyPid3 = Process.myPid();
                int i21110 = ~iMyPid3;
                int i21111 = i2117 + (-512236415) + (((~(iMyPid3 | (-306238568))) | (~((-202384145) | i21110)) | 4211778) * (-68)) + ((~((-302026790) | i21110)) * (-68)) + (((~(306238567 | i21110)) | (-504410934)) * 68);
                int i21112 = (i21111 << 13) ^ i21111;
                int i21113 = i21112 ^ (i21112 >>> 17);
                ((int[]) objArr1117[3])[0] = i21113 ^ (i21113 << 5);
                return;
            }
            i9 = 0;
            Long lValueOf20 = Long.valueOf(((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(1745676544);
            if (objAccessartificialFrame9 == null) {
                int mode7 = 17 - View.MeasureSpec.getMode(0);
                char scrollBarFadeDuration5 = (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                int iArgb2 = 747 - Color.argb(0, 0, 0, 0);
                byte b32 = $$a[86];
                Object[] objArr121 = new Object[1];
                b((byte) 47, b32, (byte) (b32 << 2), objArr121);
                objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(mode7, scrollBarFadeDuration5, iArgb2, -144068856, false, (String) objArr121[0], null);
            }
            ((Field) objAccessartificialFrame9).set(null, lValueOf20);
            i10 = ((int[]) objArr4[4])[0];
            i11 = ((int[]) objArr4[3])[0];
            if (i11 == i10) {
                int i10111 = getARTIFICIAL_FRAME_PACKAGE_NAME + 55;
                artificialFrame = i10111 % 128;
                int i10112 = i10111 % 2;
                Object[] objArr5118 = {list13, new int[1], list14, new int[]{i11111}, new int[]{i11112}};
                int i111110 = ((int[]) objArr4[1])[0];
                int i111111 = ((int[]) objArr4[3])[0];
                int i111112 = ((int[]) objArr4[4])[0];
                List list17 = (List) objArr4[0];
                List list18 = (List) objArr4[2];
                int iMaxMemory5 = (int) Runtime.getRuntime().maxMemory();
                int i111113 = 46644816 + (((~((~iMaxMemory5) | (-3565675))) | 1468512) * (-245));
                int i111114 = ~(iMaxMemory5 | (-3565675));
                int i111115 = i111110 + i111113 + (i111114 * (-245)) + ((i111114 | 601882783) * 245);
                int i111116 = (i111115 << 13) ^ i111115;
                int i111117 = i111116 ^ (i111116 >>> 17);
                i12 = 0;
                ((int[]) objArr5118[1])[0] = i111117 ^ (i111117 << 5);
            } else {
                ArrayList arrayList7 = new ArrayList();
                Object[] objArr5119 = {objArr4};
                objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(1804664566);
                if (objAccessartificialFrame10 == null) {
                    objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(((byte) KeyEvent.getModifierMetaStateMask()) + 42, (char) (TextUtils.getCapsMode("", 0, 0) + 12468), (-16773574) - Color.rgb(0, 0, 0), -185222914, false, "coroutineCreation", new Class[]{Object[].class});
                }
                arrayList7.add(((Method) objAccessartificialFrame10).invoke(null, objArr5119));
                Object[] objArr51110 = {objArr4};
                objAccessartificialFrame11 = ArtificialStackFrames.accessartificialFrame(-1243809191);
                if (objAccessartificialFrame11 == null) {
                    objAccessartificialFrame11 = ArtificialStackFrames.coroutineCreation(AndroidCharacter.getMirror('0') - 7, (char) (12468 - ExpandableListView.getPackedPositionType(0L)), (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 3642, 716815441, false, "ArtificialStackFrames", new Class[]{Object[].class});
                }
                arrayList7.add(((Method) objAccessartificialFrame11).invoke(null, objArr51110));
                Object[] objArr51111 = {Long.valueOf(((long) (i10 ^ i11)) ^ (((long) 783305454) << 32)), Long.valueOf(783305446)};
                byte[] bArr11110 = $$d;
                Object[] objArr51112 = new Object[1];
                c(bArr11110[57], bArr11110[46], (short) 282, objArr51112);
                Class<?> cls1116 = Class.forName((String) objArr51112[0]);
                byte b11112 = (byte) (-bArr11110[1]);
                Object[] objArr51113 = new Object[1];
                c(b11112, (byte) (b11112 + 4), (short) 157, objArr51113);
                cls1116.getMethod((String) objArr51113[0], Long.TYPE, Long.TYPE).invoke(null, objArr51111);
                Object[] objArr51114 = {list15, new int[1], list16, new int[]{i11119}, new int[]{i1215}};
                int i111118 = ((int[]) objArr4[1])[0];
                int i111119 = ((int[]) objArr4[3])[0];
                int i12110 = ((int[]) objArr4[4])[0];
                List list19 = (List) objArr4[0];
                List list110 = (List) objArr4[2];
                int i12111 = ~(((Context) Class.forName("android.app.ActivityThread").getMethod(str, new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) - 197842764);
                int i12112 = i111118 + 920553229 + ((~((-42991794) | i12111)) * (-783)) + (((~(i12111 | 424032078)) | (-181416380)) * 783);
                int i12113 = (i12112 << 13) ^ i12112;
                int i12114 = i12113 ^ (i12113 >>> 17);
                i12 = 0;
                ((int[]) objArr51114[1])[0] = i12114 ^ (i12114 << 5);
            }
            objAccessartificialFrame12 = ArtificialStackFrames.accessartificialFrame(-444530678);
            if (objAccessartificialFrame12 == null) {
                int iGreen4 = Color.green(i12) + 26;
                char cMakeMeasureSpec4 = (char) View.MeasureSpec.makeMeasureSpec(i12, i12);
                int iMyTid5 = (Process.myTid() >> 22) + 1041;
                byte b11113 = $$a[86];
                Object[] objArr51115 = new Object[1];
                b((byte) 47, b11113, (byte) (b11113 << 2), objArr51115);
                objAccessartificialFrame12 = ArtificialStackFrames.coroutineCreation(iGreen4, cMakeMeasureSpec4, iMyTid5, 2061780482, false, (String) objArr51115[0], null);
            }
            j3 = ((Field) objAccessartificialFrame12).getLong(null);
            if (j3 != -1) {
                int iIntValue11 = ((Integer) Class.forName(str4).getMethod(str5, Object.class).invoke(null, this)).intValue();
                Object[] objArr61110 = {-1569097084};
                objAccessartificialFrame13 = ArtificialStackFrames.accessartificialFrame(-1648942878);
                if (objAccessartificialFrame13 == null) {
                    objAccessartificialFrame13 = ArtificialStackFrames.coroutineCreation(9 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), (char) ((ViewConfiguration.getTapTimeout() >> 16) + 22251), 1033 - ((Process.getThreadPriority(0) + 20) >> 6), 47343338, false, null, new Class[]{Integer.TYPE});
                }
                objArrAccessartificialFrame$78cbbd35 = IResultReceiver2._Parcel.accessartificialFrame$78cbbd35(iIntValue11, 0, ((Constructor) objAccessartificialFrame13).newInstance(objArr61110), 252827598, false);
                objAccessartificialFrame14 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame14 == null) {
                    int iCombineMeasuredStates6 = View.combineMeasuredStates(0, 0) + 26;
                    char c18 = (char) (1 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)));
                    int iAlpha10 = 1041 - Color.alpha(0);
                    Object[] objArr61111 = new Object[1];
                    b((byte) 47, $$a[86], (byte) 56, objArr61111);
                    objAccessartificialFrame14 = ArtificialStackFrames.coroutineCreation(iCombineMeasuredStates6, c18, iAlpha10, 1145017376, false, (String) objArr61111[0], null);
                }
                ((Field) objAccessartificialFrame14).set(null, objArrAccessartificialFrame$78cbbd35);
                Long lValueOf116 = Long.valueOf(((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue());
                objAccessartificialFrame15 = ArtificialStackFrames.accessartificialFrame(-444530678);
                if (objAccessartificialFrame15 == null) {
                    int trimmedLength19 = 26 - TextUtils.getTrimmedLength("");
                    char c19 = (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                    int capsMode8 = TextUtils.getCapsMode("", 0, 0) + 1041;
                    byte b11114 = $$a[86];
                    Object[] objArr61112 = new Object[1];
                    b((byte) 47, b11114, (byte) (b11114 << 2), objArr61112);
                    objAccessartificialFrame15 = ArtificialStackFrames.coroutineCreation(trimmedLength19, c19, capsMode8, 2061780482, false, (String) objArr61112[0], null);
                }
                ((Field) objAccessartificialFrame15).set(null, lValueOf116);
            } else {
                int iIntValue12 = ((Integer) Class.forName(str4).getMethod(str5, Object.class).invoke(null, this)).intValue();
                Object[] objArr61113 = {-1569097084};
                objAccessartificialFrame13 = ArtificialStackFrames.accessartificialFrame(-1648942878);
                if (objAccessartificialFrame13 == null) {
                    objAccessartificialFrame13 = ArtificialStackFrames.coroutineCreation(9 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), (char) ((ViewConfiguration.getTapTimeout() >> 16) + 22251), 1033 - ((Process.getThreadPriority(0) + 20) >> 6), 47343338, false, null, new Class[]{Integer.TYPE});
                }
                objArrAccessartificialFrame$78cbbd35 = IResultReceiver2._Parcel.accessartificialFrame$78cbbd35(iIntValue12, 0, ((Constructor) objAccessartificialFrame13).newInstance(objArr61113), 252827598, false);
                objAccessartificialFrame14 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame14 == null) {
                    int iCombineMeasuredStates7 = View.combineMeasuredStates(0, 0) + 26;
                    char c110 = (char) (1 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)));
                    int iAlpha11 = 1041 - Color.alpha(0);
                    Object[] objArr61114 = new Object[1];
                    b((byte) 47, $$a[86], (byte) 56, objArr61114);
                    objAccessartificialFrame14 = ArtificialStackFrames.coroutineCreation(iCombineMeasuredStates7, c110, iAlpha11, 1145017376, false, (String) objArr61114[0], null);
                }
                ((Field) objAccessartificialFrame14).set(null, objArrAccessartificialFrame$78cbbd35);
                Long lValueOf117 = Long.valueOf(((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue());
                objAccessartificialFrame15 = ArtificialStackFrames.accessartificialFrame(-444530678);
                if (objAccessartificialFrame15 == null) {
                    int trimmedLength110 = 26 - TextUtils.getTrimmedLength("");
                    char c111 = (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                    int capsMode9 = TextUtils.getCapsMode("", 0, 0) + 1041;
                    byte b11115 = $$a[86];
                    Object[] objArr61115 = new Object[1];
                    b((byte) 47, b11115, (byte) (b11115 << 2), objArr61115);
                    objAccessartificialFrame15 = ArtificialStackFrames.coroutineCreation(trimmedLength110, c111, capsMode9, 2061780482, false, (String) objArr61115[0], null);
                }
                ((Field) objAccessartificialFrame15).set(null, lValueOf117);
            }
            i13 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            i14 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            if (i14 == i13) {
                Object[] objArr61116 = {strArr19, new int[1], new int[]{i13111}, new int[]{i13110}};
                int i13118 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
                int i13119 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
                int i131110 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
                String[] strArr115 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
                int iIdentityHashCode13 = System.identityHashCode(this);
                int i131111 = ~iIdentityHashCode13;
                int i131112 = i13118 + 831945840 + (((~(76784249 | i131111)) | (~((-75530242) | iIdentityHashCode13))) * (-831)) + ((~(230418297 | iIdentityHashCode13)) * (-1662)) + (((~(iIdentityHashCode13 | (-76784250))) | (~(i131111 | (-154888057))) | (~(154888056 | iIdentityHashCode13))) * 831);
                int i131113 = (i131112 << 13) ^ i131112;
                int i131114 = i131113 ^ (i131113 >>> 17);
                ((int[]) objArr61116[1])[0] = i131114 ^ (i131114 << 5);
                i15 = 0;
            } else {
                arrayList = new ArrayList();
                strArr = (String[]) objArrAccessartificialFrame$78cbbd35[0];
                if (strArr != null) {
                    i16 = 0;
                    while (i16 < strArr.length) {
                        i17 = getARTIFICIAL_FRAME_PACKAGE_NAME + 91;
                        artificialFrame = i17 % 128;
                        if (i17 % 2 == 0) {
                            arrayList.add(strArr[i16]);
                            i16 += 88;
                        } else {
                            arrayList.add(strArr[i16]);
                            i16++;
                        }
                    }
                }
                Object[] objArr61117 = objArrAccessartificialFrame$78cbbd35;
                Object[] objArr61118 = {Long.valueOf(((long) (i13 ^ i14)) ^ (((long) (-1600638879)) << 32)), Long.valueOf(-1600638877)};
                byte[] bArr11111 = $$d;
                Object[] objArr61119 = new Object[1];
                c(bArr11111[45], bArr11111[452], (short) 354, objArr61119);
                Class<?> cls1117 = Class.forName((String) objArr61119[0]);
                byte b11116 = (byte) (-bArr11111[1]);
                Object[] objArr622 = new Object[1];
                c(b11116, (byte) (b11116 + 4), (short) 157, objArr622);
                cls1117.getMethod((String) objArr622[0], Long.TYPE, Long.TYPE).invoke(null, objArr61118);
                Object[] objArr71118 = {strArr110, new int[1], new int[]{i1419}, new int[]{i13117}};
                int i131115 = ((int[]) objArr61117[1])[0];
                int i131116 = ((int[]) objArr61117[3])[0];
                int i14118 = ((int[]) objArr61117[2])[0];
                String[] strArr116 = (String[]) objArr61117[0];
                int i14119 = ((Context) Class.forName("android.app.ActivityThread").getMethod(str, new Class[0]).invoke(null, null)).getResources().getConfiguration().touchscreen;
                int i141110 = ~i14119;
                int i141111 = i131115 + 1069043538 + (((~(243663665 | i141110)) | (-531614514)) * 98) + (((~(i141110 | (-321767473))) | 243663665 | (~(321767472 | i14119))) * (-49)) + (((~(i14119 | 243663665)) | 209847041) * 49);
                int i141112 = (i141111 << 13) ^ i141111;
                int i141113 = i141112 ^ (i141112 >>> 17);
                i15 = 0;
                ((int[]) objArr71118[1])[0] = i141113 ^ (i141113 << 5);
            }
            objAccessartificialFrame16 = ArtificialStackFrames.accessartificialFrame(1056123296);
            if (objAccessartificialFrame16 == null) {
                int iAlpha12 = 30 - Color.alpha(i15);
                char cNormalizeMetaState4 = (char) (49362 - KeyEvent.normalizeMetaState(i15));
                int i141114 = (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 683;
                byte[] bArr11112 = $$a;
                Object[] objArr71119 = new Object[1];
                b(bArr11112[i15], bArr11112[82], (byte) ($$b >>> 1), objArr71119);
                objAccessartificialFrame16 = ArtificialStackFrames.coroutineCreation(iAlpha12, cNormalizeMetaState4, i141114, -1583976536, false, (String) objArr71119[i15], null);
            }
            j4 = ((Field) objAccessartificialFrame16).getLong(null);
            if (j4 != -1) {
                Object[] objArr711110 = {Integer.valueOf(((Integer) Class.forName(str4).getMethod(str5, Object.class).invoke(null, this)).intValue()), 1109377758};
                byte[] bArr11113 = $$d;
                byte b11117 = bArr11113[57];
                byte b11118 = bArr11113[45];
                Object[] objArr711111 = new Object[1];
                c(b11117, b11118, (short) (b11118 | 408), objArr711111);
                Class<?> cls1118 = Class.forName((String) objArr711111[0]);
                byte b11119 = bArr11113[57];
                byte b21110 = bArr11113[185];
                Object[] objArr711112 = new Object[1];
                c(b11119, b21110, (short) (b21110 | 424), objArr711112);
                Object[] objArr711113 = (Object[]) cls1118.getMethod((String) objArr711112[0], Integer.TYPE, Integer.TYPE).invoke(null, objArr711110);
                objAccessartificialFrame17 = ArtificialStackFrames.accessartificialFrame(910856866);
                if (objAccessartificialFrame17 == null) {
                    int doubleTapTimeout6 = 30 - (ViewConfiguration.getDoubleTapTimeout() >> 16);
                    char c112 = (char) (49362 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)));
                    int threadPriority6 = ((Process.getThreadPriority(0) + 20) >> 6) + 684;
                    Object[] objArr711114 = new Object[1];
                    b((byte) ($$b & WebSocketProtocol.PAYLOAD_SHORT), $$a[86], (byte) 96, objArr711114);
                    objAccessartificialFrame17 = ArtificialStackFrames.coroutineCreation(doubleTapTimeout6, c112, threadPriority6, -1456483158, false, (String) objArr711114[0], null);
                }
                ((Field) objAccessartificialFrame17).set(null, objArr711113);
                Long lValueOf118 = Long.valueOf(((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue());
                objAccessartificialFrame18 = ArtificialStackFrames.accessartificialFrame(1056123296);
                if (objAccessartificialFrame18 == null) {
                    int iResolveSize6 = 30 - View.resolveSize(0, 0);
                    char offsetAfter16 = (char) (49362 - TextUtils.getOffsetAfter("", 0));
                    int i141115 = (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 683;
                    byte[] bArr11114 = $$a;
                    Object[] objArr711115 = new Object[1];
                    b(bArr11114[0], bArr11114[82], (byte) ($$b >>> 1), objArr711115);
                    objAccessartificialFrame18 = ArtificialStackFrames.coroutineCreation(iResolveSize6, offsetAfter16, i141115, -1583976536, false, (String) objArr711115[0], null);
                }
                ((Field) objAccessartificialFrame18).set(null, lValueOf118);
                objArr5 = objArr711113;
            } else {
                Object[] objArr711116 = {Integer.valueOf(((Integer) Class.forName(str4).getMethod(str5, Object.class).invoke(null, this)).intValue()), 1109377758};
                byte[] bArr11115 = $$d;
                byte b111110 = bArr11115[57];
                byte b111111 = bArr11115[45];
                Object[] objArr711117 = new Object[1];
                c(b111110, b111111, (short) (b111111 | 408), objArr711117);
                Class<?> cls1119 = Class.forName((String) objArr711117[0]);
                byte b111112 = bArr11115[57];
                byte b21111 = bArr11115[185];
                Object[] objArr711118 = new Object[1];
                c(b111112, b21111, (short) (b21111 | 424), objArr711118);
                Object[] objArr711119 = (Object[]) cls1119.getMethod((String) objArr711118[0], Integer.TYPE, Integer.TYPE).invoke(null, objArr711116);
                objAccessartificialFrame17 = ArtificialStackFrames.accessartificialFrame(910856866);
                if (objAccessartificialFrame17 == null) {
                    int doubleTapTimeout7 = 30 - (ViewConfiguration.getDoubleTapTimeout() >> 16);
                    char c113 = (char) (49362 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)));
                    int threadPriority7 = ((Process.getThreadPriority(0) + 20) >> 6) + 684;
                    Object[] objArr7111110 = new Object[1];
                    b((byte) ($$b & WebSocketProtocol.PAYLOAD_SHORT), $$a[86], (byte) 96, objArr7111110);
                    objAccessartificialFrame17 = ArtificialStackFrames.coroutineCreation(doubleTapTimeout7, c113, threadPriority7, -1456483158, false, (String) objArr7111110[0], null);
                }
                ((Field) objAccessartificialFrame17).set(null, objArr711119);
                Long lValueOf119 = Long.valueOf(((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue());
                objAccessartificialFrame18 = ArtificialStackFrames.accessartificialFrame(1056123296);
                if (objAccessartificialFrame18 == null) {
                    int iResolveSize7 = 30 - View.resolveSize(0, 0);
                    char offsetAfter17 = (char) (49362 - TextUtils.getOffsetAfter("", 0));
                    int i141116 = (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 683;
                    byte[] bArr11116 = $$a;
                    Object[] objArr7111111 = new Object[1];
                    b(bArr11116[0], bArr11116[82], (byte) ($$b >>> 1), objArr7111111);
                    objAccessartificialFrame18 = ArtificialStackFrames.coroutineCreation(iResolveSize7, offsetAfter17, i141116, -1583976536, false, (String) objArr7111111[0], null);
                }
                ((Field) objAccessartificialFrame18).set(null, lValueOf119);
                objArr5 = objArr711119;
            }
            i18 = ((int[]) objArr5[1])[0];
            i19 = ((int[]) objArr5[0])[0];
            if (i19 == i18) {
                int i15114 = getARTIFICIAL_FRAME_PACKAGE_NAME + 71;
                artificialFrame = i15114 % 128;
                int i15115 = i15114 % 2;
                int i15116 = ((int[]) objArr5[2])[0];
                Object[] objArr81118 = {new int[]{((int[]) objArr5[0])[0]}, new int[]{((int[]) objArr5[1])[0]}, new int[1], (String) objArr5[3]};
                int i15117 = (int) Runtime.getRuntime().totalMemory();
                int i15118 = (-558569362) + (((~((-61450044) | i15117)) | (-917173732)) * (-318));
                int i15119 = ~((-917173732) | i15117);
                int i151110 = ~i15117;
                int i161112 = i15116 + i15118 + ((i15119 | (~(934017019 | i151110))) * TypedValues.AttributesType.TYPE_PIVOT_TARGET) + (((~(i15117 | 934017019)) | (~((-872566977) | i151110))) * TypedValues.AttributesType.TYPE_PIVOT_TARGET);
                int i161113 = (i161112 << 13) ^ i161112;
                int i161114 = i161113 ^ (i161113 >>> 17);
                ((int[]) objArr81118[2])[0] = i161114 ^ (i161114 << 5);
                i20 = 0;
            } else {
                new ArrayList().add((String) objArr5[3]);
                Object[] objArr81119 = {Long.valueOf(((long) (i18 ^ i19)) ^ (((long) 183072593) << 32)), Long.valueOf(183072577)};
                byte[] bArr11117 = $$d;
                Object[] objArr81120 = new Object[1];
                c(bArr11117[57], bArr11117[25], (short) 91, objArr81120);
                Class<?> cls22 = Class.forName((String) objArr81120[0]);
                byte b21112 = (byte) (-bArr11117[1]);
                Object[] objArr81121 = new Object[1];
                c(b21112, (byte) (b21112 + 4), (short) 157, objArr81121);
                cls22.getMethod((String) objArr81121[0], Long.TYPE, Long.TYPE).invoke(null, objArr81119);
                int i161115 = ((int[]) objArr5[2])[0];
                Object[] objArr81122 = {new int[]{((int[]) objArr5[0])[0]}, new int[]{((int[]) objArr5[1])[0]}, new int[1], (String) objArr5[3]};
                int iIdentityHashCode14 = System.identityHashCode(this);
                int i161116 = i161115 + (-11707142) + (((~(iIdentityHashCode14 | (-15899194))) | (-994522969)) * (-465)) + (((-15899194) | (~((-994522969) | iIdentityHashCode14))) * 930) + ((iIdentityHashCode14 | (-4330009)) * 465);
                int i161117 = (i161116 << 13) ^ i161116;
                int i161118 = i161117 ^ (i161117 >>> 17);
                i20 = 0;
                ((int[]) objArr81122[2])[0] = i161118 ^ (i161118 << 5);
            }
            objAccessartificialFrame19 = ArtificialStackFrames.accessartificialFrame(1313006081);
            if (objAccessartificialFrame19 == null) {
                int offsetBefore5 = 21 - TextUtils.getOffsetBefore("", i20);
                char cKeyCodeFromString4 = (char) KeyEvent.keyCodeFromString("");
                int minimumFlingVelocity4 = (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 465;
                byte b21113 = $$a[86];
                Object[] objArr81123 = new Object[1];
                b((byte) 47, b21113, (byte) (b21113 << 2), objArr81123);
                objAccessartificialFrame19 = ArtificialStackFrames.coroutineCreation(offsetBefore5, cKeyCodeFromString4, minimumFlingVelocity4, -785931255, false, (String) objArr81123[0], null);
            }
            j5 = ((Field) objAccessartificialFrame19).getLong(null);
            if (j5 != -1) {
                baseContext2 = getBaseContext();
                if (baseContext2 == null) {
                    Object[] objArr811110 = new Object[1];
                    a(TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 27, new char[]{CharUtils.CR, CoreConstants.SINGLE_QUOTE_CHAR, 21, CoreConstants.DASH_CHAR, CoreConstants.RIGHT_PARENTHESIS_CHAR, 19, 22, 3, '\n', ' ', 29, 3, '\n', '\b', '0', 17, CoreConstants.RIGHT_PARENTHESIS_CHAR, 27, 3, '\n', '#', 15, '/', 0, '\n', 25}, (byte) ((Context) Class.forName("android.app.ActivityThread").getMethod(str, new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion, objArr811110);
                    Class<?> cls11110 = Class.forName((String) objArr811110[0]);
                    Object[] objArr811111 = new Object[1];
                    a(18 - (ViewConfiguration.getLongPressTimeout() >> 16), new char[]{'\b', '*', 13860, 13860, 6, CoreConstants.LEFT_PARENTHESIS_CHAR, CoreConstants.COMMA_CHAR, '\n', 13862, 13862, 20, 27, '\b', '\f', '0', 17, CoreConstants.RIGHT_PARENTHESIS_CHAR, '#'}, (byte) (60 - View.MeasureSpec.getSize(0)), objArr811111);
                    baseContext2 = (Context) cls11110.getMethod((String) objArr811111[0], new Class[0]).invoke(null, null);
                }
                if (baseContext2 != null) {
                    if (baseContext2 instanceof ContextWrapper) {
                        baseContext2 = baseContext2.getApplicationContext();
                    } else {
                        baseContext2 = baseContext2.getApplicationContext();
                    }
                }
                int iIntValue13 = ((Integer) Class.forName(str4).getMethod(str5, Object.class).invoke(null, this)).intValue();
                Object[] objArr811112 = new Object[1];
                a(((Context) Class.forName("android.app.ActivityThread").getMethod(str, new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 43, new char[]{29, '!', 24, '\b', '/', 4, 29, 21, '\t', 0, ' ', '\f', CoreConstants.COMMA_CHAR, CoreConstants.PERCENT_CHAR, 14, 29, 3, 26, 31, '\"', 30, 5, 14, 29, 25, '\b', CoreConstants.COMMA_CHAR, CoreConstants.SINGLE_QUOTE_CHAR, 22, 17, 0, '!', 29, '\"', 31, 26, 14, 29, 0, 30, '#', '\t', 29, '\"', 16, 17, '\t', '#', ' ', 7, '\b', 25, '\t', 23, ' ', '\t', '#', '\t', '\f', 4, 21, '\b', 25, CoreConstants.DASH_CHAR}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod(str, new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 56), objArr811112);
                String str13 = (String) objArr811112[0];
                Object[] objArr811113 = new Object[1];
                a(((Context) Class.forName("android.app.ActivityThread").getMethod(str, new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(0) + 27, new char[]{29, 26, 13857, 13857, 0, '!', CoreConstants.COMMA_CHAR, 23, 30, 4, 28, CoreConstants.LEFT_PARENTHESIS_CHAR, ' ', CoreConstants.COMMA_CHAR, 23, 3, CoreConstants.COMMA_CHAR, ' ', '!', 4, 7, ' ', ' ', '\f', '\t', 23, 31, '\t', 26, 31, Typography.amp, 7, ' ', '/', 13770, 13770, ' ', '\f', '\f', CoreConstants.LEFT_PARENTHESIS_CHAR, 3, '\t', 31, '\f', CoreConstants.COMMA_CHAR, CoreConstants.SINGLE_QUOTE_CHAR, 24, '\b', 25, '+', 7, ' ', CoreConstants.LEFT_PARENTHESIS_CHAR, 0, 13774, 13774, CoreConstants.SINGLE_QUOTE_CHAR, 7, 18, '+', CoreConstants.SINGLE_QUOTE_CHAR, '\t', '!', 0}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod(str, new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) - 2), objArr811113);
                Object[] objArr91110 = {baseContext2, new String[]{str13, (String) objArr811113[0]}, Integer.valueOf(iIntValue13), 1, 1550163612};
                byte[] bArr11118 = $$d;
                byte b21114 = bArr11118[57];
                byte b21115 = bArr11118[94];
                Object[] objArr91111 = new Object[1];
                c(b21114, b21115, (short) (b21115 | 481), objArr91111);
                Class<?> cls11111 = Class.forName((String) objArr91111[0]);
                Object[] objArr91112 = new Object[1];
                c(bArr11118[224], bArr11118[555], (short) 214, objArr91112);
                objArr6 = (Object[]) cls11111.getMethod((String) objArr91112[0], Context.class, String[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr91110);
                int i161119 = ((int[]) objArr6[0])[0];
                int i1611110 = ((int[]) objArr6[3])[0];
                if (baseContext2 != null) {
                    objAccessartificialFrame20 = ArtificialStackFrames.accessartificialFrame(1142731807);
                    if (objAccessartificialFrame20 == null) {
                        int trimmedLength111 = 21 - TextUtils.getTrimmedLength("");
                        char scrollDefaultDelay6 = (char) (ViewConfiguration.getScrollDefaultDelay() >> 16);
                        int scrollBarSize13 = 465 - (ViewConfiguration.getScrollBarSize() >> 8);
                        Object[] objArr91113 = new Object[1];
                        b((byte) 47, $$a[86], (byte) 56, objArr91113);
                        objAccessartificialFrame20 = ArtificialStackFrames.coroutineCreation(trimmedLength111, scrollDefaultDelay6, scrollBarSize13, -612765161, false, (String) objArr91113[0], null);
                    }
                    ((Field) objAccessartificialFrame20).set(null, objArr6);
                    Long lValueOf1110 = Long.valueOf(((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame21 = ArtificialStackFrames.accessartificialFrame(1313006081);
                    if (objAccessartificialFrame21 == null) {
                        int touchSlop6 = 21 - (ViewConfiguration.getTouchSlop() >> 8);
                        char offsetAfter18 = (char) TextUtils.getOffsetAfter("", 0);
                        int pressedStateDuration6 = (ViewConfiguration.getPressedStateDuration() >> 16) + 465;
                        byte b21116 = $$a[86];
                        Object[] objArr91114 = new Object[1];
                        b((byte) 47, b21116, (byte) (b21116 << 2), objArr91114);
                        objAccessartificialFrame21 = ArtificialStackFrames.coroutineCreation(touchSlop6, offsetAfter18, pressedStateDuration6, -785931255, false, (String) objArr91114[0], null);
                    }
                    ((Field) objAccessartificialFrame21).set(null, lValueOf1110);
                }
                c = 0;
            } else {
                baseContext2 = getBaseContext();
                if (baseContext2 == null) {
                    Object[] objArr811114 = new Object[1];
                    a(TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 27, new char[]{CharUtils.CR, CoreConstants.SINGLE_QUOTE_CHAR, 21, CoreConstants.DASH_CHAR, CoreConstants.RIGHT_PARENTHESIS_CHAR, 19, 22, 3, '\n', ' ', 29, 3, '\n', '\b', '0', 17, CoreConstants.RIGHT_PARENTHESIS_CHAR, 27, 3, '\n', '#', 15, '/', 0, '\n', 25}, (byte) ((Context) Class.forName("android.app.ActivityThread").getMethod(str, new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion, objArr811114);
                    Class<?> cls11112 = Class.forName((String) objArr811114[0]);
                    Object[] objArr811115 = new Object[1];
                    a(18 - (ViewConfiguration.getLongPressTimeout() >> 16), new char[]{'\b', '*', 13860, 13860, 6, CoreConstants.LEFT_PARENTHESIS_CHAR, CoreConstants.COMMA_CHAR, '\n', 13862, 13862, 20, 27, '\b', '\f', '0', 17, CoreConstants.RIGHT_PARENTHESIS_CHAR, '#'}, (byte) (60 - View.MeasureSpec.getSize(0)), objArr811115);
                    baseContext2 = (Context) cls11112.getMethod((String) objArr811115[0], new Class[0]).invoke(null, null);
                }
                if (baseContext2 != null) {
                    if (baseContext2 instanceof ContextWrapper) {
                        baseContext2 = baseContext2.getApplicationContext();
                    } else {
                        baseContext2 = baseContext2.getApplicationContext();
                    }
                }
                int iIntValue14 = ((Integer) Class.forName(str4).getMethod(str5, Object.class).invoke(null, this)).intValue();
                Object[] objArr811116 = new Object[1];
                a(((Context) Class.forName("android.app.ActivityThread").getMethod(str, new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 43, new char[]{29, '!', 24, '\b', '/', 4, 29, 21, '\t', 0, ' ', '\f', CoreConstants.COMMA_CHAR, CoreConstants.PERCENT_CHAR, 14, 29, 3, 26, 31, '\"', 30, 5, 14, 29, 25, '\b', CoreConstants.COMMA_CHAR, CoreConstants.SINGLE_QUOTE_CHAR, 22, 17, 0, '!', 29, '\"', 31, 26, 14, 29, 0, 30, '#', '\t', 29, '\"', 16, 17, '\t', '#', ' ', 7, '\b', 25, '\t', 23, ' ', '\t', '#', '\t', '\f', 4, 21, '\b', 25, CoreConstants.DASH_CHAR}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod(str, new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 56), objArr811116);
                String str14 = (String) objArr811116[0];
                Object[] objArr811117 = new Object[1];
                a(((Context) Class.forName("android.app.ActivityThread").getMethod(str, new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(0) + 27, new char[]{29, 26, 13857, 13857, 0, '!', CoreConstants.COMMA_CHAR, 23, 30, 4, 28, CoreConstants.LEFT_PARENTHESIS_CHAR, ' ', CoreConstants.COMMA_CHAR, 23, 3, CoreConstants.COMMA_CHAR, ' ', '!', 4, 7, ' ', ' ', '\f', '\t', 23, 31, '\t', 26, 31, Typography.amp, 7, ' ', '/', 13770, 13770, ' ', '\f', '\f', CoreConstants.LEFT_PARENTHESIS_CHAR, 3, '\t', 31, '\f', CoreConstants.COMMA_CHAR, CoreConstants.SINGLE_QUOTE_CHAR, 24, '\b', 25, '+', 7, ' ', CoreConstants.LEFT_PARENTHESIS_CHAR, 0, 13774, 13774, CoreConstants.SINGLE_QUOTE_CHAR, 7, 18, '+', CoreConstants.SINGLE_QUOTE_CHAR, '\t', '!', 0}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod(str, new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) - 2), objArr811117);
                Object[] objArr91115 = {baseContext2, new String[]{str14, (String) objArr811117[0]}, Integer.valueOf(iIntValue14), 1, 1550163612};
                byte[] bArr11119 = $$d;
                byte b21117 = bArr11119[57];
                byte b21118 = bArr11119[94];
                Object[] objArr91116 = new Object[1];
                c(b21117, b21118, (short) (b21118 | 481), objArr91116);
                Class<?> cls11113 = Class.forName((String) objArr91116[0]);
                Object[] objArr91117 = new Object[1];
                c(bArr11119[224], bArr11119[555], (short) 214, objArr91117);
                objArr6 = (Object[]) cls11113.getMethod((String) objArr91117[0], Context.class, String[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr91115);
                int i1611111 = ((int[]) objArr6[0])[0];
                int i1611112 = ((int[]) objArr6[3])[0];
                if (baseContext2 != null) {
                    objAccessartificialFrame20 = ArtificialStackFrames.accessartificialFrame(1142731807);
                    if (objAccessartificialFrame20 == null) {
                        int trimmedLength112 = 21 - TextUtils.getTrimmedLength("");
                        char scrollDefaultDelay7 = (char) (ViewConfiguration.getScrollDefaultDelay() >> 16);
                        int scrollBarSize14 = 465 - (ViewConfiguration.getScrollBarSize() >> 8);
                        Object[] objArr91118 = new Object[1];
                        b((byte) 47, $$a[86], (byte) 56, objArr91118);
                        objAccessartificialFrame20 = ArtificialStackFrames.coroutineCreation(trimmedLength112, scrollDefaultDelay7, scrollBarSize14, -612765161, false, (String) objArr91118[0], null);
                    }
                    ((Field) objAccessartificialFrame20).set(null, objArr6);
                    Long lValueOf1111 = Long.valueOf(((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame21 = ArtificialStackFrames.accessartificialFrame(1313006081);
                    if (objAccessartificialFrame21 == null) {
                        int touchSlop7 = 21 - (ViewConfiguration.getTouchSlop() >> 8);
                        char offsetAfter19 = (char) TextUtils.getOffsetAfter("", 0);
                        int pressedStateDuration7 = (ViewConfiguration.getPressedStateDuration() >> 16) + 465;
                        byte b21119 = $$a[86];
                        Object[] objArr91119 = new Object[1];
                        b((byte) 47, b21119, (byte) (b21119 << 2), objArr91119);
                        objAccessartificialFrame21 = ArtificialStackFrames.coroutineCreation(touchSlop7, offsetAfter19, pressedStateDuration7, -785931255, false, (String) objArr91119[0], null);
                    }
                    ((Field) objAccessartificialFrame21).set(null, lValueOf1111);
                }
                c = 0;
            }
            i21 = ((int[]) objArr6[c])[c];
            i22 = ((int[]) objArr6[3])[c];
            if (i22 == i21) {
                Object[] objArr926 = new Object[4];
                int[] iArr7 = new int[1];
                objArr926[c] = iArr7;
                objArr926[2] = new int[1];
                int[] iArr8 = new int[1];
                objArr926[3] = iArr8;
                int i1718 = ((int[]) objArr6[2])[c];
                int i1719 = ((int[]) objArr6[3])[c];
                int i17110 = ((int[]) objArr6[c])[c];
                String[] strArr117 = (String[]) objArr6[1];
                iArr8[c] = i1719;
                iArr7[c] = i17110;
                int iIdentityHashCode15 = System.identityHashCode(this);
                int i17111 = ~iIdentityHashCode15;
                int i181110 = i1718 + 1757838936 + (((~((-140681629) | i17111)) | (-19668098)) * (-865)) + ((~(iIdentityHashCode15 | 140681628)) * 865) + (((~((-19668098) | i17111)) | (~(i17111 | 140681628))) * 865);
                int i181111 = (i181110 << 13) ^ i181110;
                int i181112 = i181111 ^ (i181111 >>> 17);
                ((int[]) objArr926[2])[0] = i181112 ^ (i181112 << 5);
                objArr926[1] = strArr117;
                i23 = 0;
            } else {
                arrayList2 = new ArrayList();
                strArr2 = (String[]) objArr6[1];
                if (strArr2 != null) {
                    while (i24 < strArr2.length) {
                        arrayList2.add(str7);
                    }
                }
                Object[] objArr927 = {Long.valueOf(((long) (i21 ^ i22)) ^ (((long) 1235250365) << 32)), Long.valueOf(1235250429)};
                byte[] bArr126 = $$d;
                Object[] objArr928 = new Object[1];
                c(bArr126[57], bArr126[358], (short) 562, objArr928);
                Class<?> cls11114 = Class.forName((String) objArr928[0]);
                byte b2210 = (byte) (-bArr126[1]);
                Object[] objArr101112 = new Object[1];
                c(b2210, (byte) (b2210 + 4), (short) 157, objArr101112);
                cls11114.getMethod((String) objArr101112[0], Long.TYPE, Long.TYPE).invoke(null, objArr927);
                Object[] objArr101113 = {new int[]{i18115}, strArr112, new int[1], new int[]{i18114}};
                int i181113 = ((int[]) objArr6[2])[0];
                int i181114 = ((int[]) objArr6[3])[0];
                int i181115 = ((int[]) objArr6[0])[0];
                String[] strArr118 = (String[]) objArr6[1];
                int i181116 = ~Process.myPid();
                int i181117 = i181113 + 720771397 + (((~(i181116 | 519831146)) | (~((-702537) | i181116))) * (-184)) + ((339739168 | (~((-340441705) | i181116)) | (~(180091978 | i181116))) * SyslogConstants.LOG_LOCAL7) + 1352080856;
                int i181118 = (i181117 << 13) ^ i181117;
                int i181119 = i181118 ^ (i181118 >>> 17);
                i23 = 0;
                ((int[]) objArr101113[2])[0] = i181119 ^ (i181119 << 5);
            }
            super.onStart();
            objAccessartificialFrame22 = ArtificialStackFrames.accessartificialFrame(-1268268649);
            if (objAccessartificialFrame22 == null) {
                int defaultSize4 = View.getDefaultSize(i23, i23) + 25;
                char cRgb4 = (char) (Color.rgb(i23, i23, i23) + 16807284);
                int mode8 = 816 - View.MeasureSpec.getMode(i23);
                byte b2211 = $$a[86];
                Object[] objArr101114 = new Object[1];
                b((byte) 47, b2211, (byte) (b2211 << 2), objArr101114);
                objAccessartificialFrame22 = ArtificialStackFrames.coroutineCreation(defaultSize4, cRgb4, mode8, 721586079, false, (String) objArr101114[0], null);
            }
            j6 = ((Field) objAccessartificialFrame22).getLong(null);
            if (j6 != -1) {
                Object[] objArr101115 = {Integer.valueOf(((Integer) Class.forName(str4).getMethod(str5, Object.class).invoke(null, this)).intValue()), 0, 1771123361};
                objAccessartificialFrame23 = ArtificialStackFrames.accessartificialFrame(1327366003);
                if (objAccessartificialFrame23 == null) {
                    int i1914 = 26 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                    char cCombineMeasuredStates7 = (char) (30068 - View.combineMeasuredStates(0, 0));
                    int trimmedLength113 = 816 - TextUtils.getTrimmedLength("");
                    byte[] bArr127 = $$a;
                    Object[] objArr101116 = new Object[1];
                    b(bArr127[10], bArr127[26], (byte) 104, objArr101116);
                    objAccessartificialFrame23 = ArtificialStackFrames.coroutineCreation(i1914, cCombineMeasuredStates7, trimmedLength113, -797394565, false, (String) objArr101116[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                }
                objArr7 = (Object[]) ((Method) objAccessartificialFrame23).invoke(null, objArr101115);
                objAccessartificialFrame24 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame24 == null) {
                    int scrollBarSize15 = 25 - (ViewConfiguration.getScrollBarSize() >> 8);
                    char offsetAfter110 = (char) (30068 - TextUtils.getOffsetAfter("", 0));
                    int absoluteGravity7 = Gravity.getAbsoluteGravity(0, 0) + 816;
                    Object[] objArr101117 = new Object[1];
                    b((byte) 47, $$a[86], (byte) 56, objArr101117);
                    objAccessartificialFrame24 = ArtificialStackFrames.coroutineCreation(scrollBarSize15, offsetAfter110, absoluteGravity7, 891606461, false, (String) objArr101117[0], null);
                }
                ((Field) objAccessartificialFrame24).set(null, objArr7);
                Long lValueOf1112 = Long.valueOf(((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue());
                objAccessartificialFrame25 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                if (objAccessartificialFrame25 == null) {
                    int edgeSlop6 = (ViewConfiguration.getEdgeSlop() >> 16) + 25;
                    char longPressTimeout7 = (char) (30068 - (ViewConfiguration.getLongPressTimeout() >> 16));
                    int size9 = 816 - View.MeasureSpec.getSize(0);
                    byte b2212 = $$a[86];
                    Object[] objArr101118 = new Object[1];
                    b((byte) 47, b2212, (byte) (b2212 << 2), objArr101118);
                    objAccessartificialFrame25 = ArtificialStackFrames.coroutineCreation(edgeSlop6, longPressTimeout7, size9, 721586079, false, (String) objArr101118[0], null);
                }
                ((Field) objAccessartificialFrame25).set(null, lValueOf1112);
            } else {
                Object[] objArr101119 = {Integer.valueOf(((Integer) Class.forName(str4).getMethod(str5, Object.class).invoke(null, this)).intValue()), 0, 1771123361};
                objAccessartificialFrame23 = ArtificialStackFrames.accessartificialFrame(1327366003);
                if (objAccessartificialFrame23 == null) {
                    int i1915 = 26 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                    char cCombineMeasuredStates8 = (char) (30068 - View.combineMeasuredStates(0, 0));
                    int trimmedLength114 = 816 - TextUtils.getTrimmedLength("");
                    byte[] bArr128 = $$a;
                    Object[] objArr1011110 = new Object[1];
                    b(bArr128[10], bArr128[26], (byte) 104, objArr1011110);
                    objAccessartificialFrame23 = ArtificialStackFrames.coroutineCreation(i1915, cCombineMeasuredStates8, trimmedLength114, -797394565, false, (String) objArr1011110[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                }
                objArr7 = (Object[]) ((Method) objAccessartificialFrame23).invoke(null, objArr101119);
                objAccessartificialFrame24 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame24 == null) {
                    int scrollBarSize16 = 25 - (ViewConfiguration.getScrollBarSize() >> 8);
                    char offsetAfter111 = (char) (30068 - TextUtils.getOffsetAfter("", 0));
                    int absoluteGravity8 = Gravity.getAbsoluteGravity(0, 0) + 816;
                    Object[] objArr1011111 = new Object[1];
                    b((byte) 47, $$a[86], (byte) 56, objArr1011111);
                    objAccessartificialFrame24 = ArtificialStackFrames.coroutineCreation(scrollBarSize16, offsetAfter111, absoluteGravity8, 891606461, false, (String) objArr1011111[0], null);
                }
                ((Field) objAccessartificialFrame24).set(null, objArr7);
                Long lValueOf1113 = Long.valueOf(((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue());
                objAccessartificialFrame25 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                if (objAccessartificialFrame25 == null) {
                    int edgeSlop7 = (ViewConfiguration.getEdgeSlop() >> 16) + 25;
                    char longPressTimeout8 = (char) (30068 - (ViewConfiguration.getLongPressTimeout() >> 16));
                    int size10 = 816 - View.MeasureSpec.getSize(0);
                    byte b2213 = $$a[86];
                    Object[] objArr1011112 = new Object[1];
                    b((byte) 47, b2213, (byte) (b2213 << 2), objArr1011112);
                    objAccessartificialFrame25 = ArtificialStackFrames.coroutineCreation(edgeSlop7, longPressTimeout8, size10, 721586079, false, (String) objArr1011112[0], null);
                }
                ((Field) objAccessartificialFrame25).set(null, lValueOf1113);
            }
            i25 = ((int[]) objArr7[1])[0];
            i26 = ((int[]) objArr7[0])[0];
            if (i26 == i25) {
                int i201110 = getARTIFICIAL_FRAME_PACKAGE_NAME + 119;
                artificialFrame = i201110 % 128;
                int i201111 = i201110 % 2;
                Object[] objArr1022 = {new int[]{i20113}, new int[]{i20114}, strArr113, new int[1]};
                int i201112 = ((int[]) objArr7[3])[0];
                int i201113 = ((int[]) objArr7[0])[0];
                int i201114 = ((int[]) objArr7[1])[0];
                String[] strArr119 = (String[]) objArr7[2];
                int iCodePointAt4 = ((Context) Class.forName("android.app.ActivityThread").getMethod(str, new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(10) - 1036900927;
                int i201115 = ~iCodePointAt4;
                int i201116 = i201112 + (-99377353) + (((~((-515372982) | i201115)) | 176674433) * (-108)) + (((~(i201115 | 713545347)) | (~((-713545348) | iCodePointAt4)) | (-1052243896)) * 54) + ((iCodePointAt4 | (-1052243896)) * 54);
                int i201117 = (i201116 << 13) ^ i201116;
                int i201118 = i201117 ^ (i201117 >>> 17);
                ((int[]) objArr1022[3])[0] = i201118 ^ (i201118 << 5);
                return;
            }
            arrayList3 = new ArrayList();
            strArr3 = (String[]) objArr7[2];
            if (strArr3 != null) {
                while (i27 < strArr3.length) {
                    arrayList3.add(str8);
                }
            }
            long j15 = ((long) (i25 ^ i26)) ^ (((long) 1508793583) << 32);
            long j16 = 1508793582;
            int i201119 = artificialFrame + 27;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i201119 % 128;
            int i21114 = i201119 % 2;
            Object[] objArr1118 = {Long.valueOf(j15), Long.valueOf(j16)};
            byte[] bArr24 = $$d;
            Object[] objArr1119 = new Object[1];
            c(bArr24[57], bArr24[62], (short) 600, objArr1119);
            Class<?> cls11115 = Class.forName((String) objArr1119[0]);
            byte b2214 = (byte) (-bArr24[1]);
            Object[] objArr11110 = new Object[1];
            c(b2214, (byte) (b2214 + 4), (short) 157, objArr11110);
            cls11115.getMethod((String) objArr11110[0], Long.TYPE, Long.TYPE).invoke(null, objArr1118);
            Object[] objArr11111 = {new int[]{i2118}, new int[]{i2119}, strArr114, new int[1]};
            int i21115 = ((int[]) objArr7[3])[0];
            int i21116 = ((int[]) objArr7[0])[0];
            int i21117 = ((int[]) objArr7[1])[0];
            String[] strArr1110 = (String[]) objArr7[2];
            int iMyPid4 = Process.myPid();
            int i21118 = ~iMyPid4;
            int i21119 = i21115 + (-512236415) + (((~(iMyPid4 | (-306238568))) | (~((-202384145) | i21118)) | 4211778) * (-68)) + ((~((-302026790) | i21118)) * (-68)) + (((~(306238567 | i21118)) | (-504410934)) * 68);
            int i211110 = (i21119 << 13) ^ i21119;
            int i211111 = i211110 ^ (i211110 >>> 17);
            ((int[]) objArr11111[3])[0] = i211111 ^ (i211111 << 5);
            return;
        } catch (Exception unused7) {
            throw new RuntimeException();
        }
        Context baseContext4 = getBaseContext();
        if (baseContext4 == null) {
            Object[] objArr122 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod(str, new Class[i2]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(i2, 4).length() + 22, new char[]{CharUtils.CR, CoreConstants.SINGLE_QUOTE_CHAR, 21, CoreConstants.DASH_CHAR, CoreConstants.RIGHT_PARENTHESIS_CHAR, 19, 22, 3, '\n', ' ', 29, 3, '\n', '\b', '0', 17, CoreConstants.RIGHT_PARENTHESIS_CHAR, 27, 3, '\n', '#', 15, '/', 0, '\n', 25}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod(str, new Class[i2]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(i2, 4).codePointAt(3) - 80), objArr122);
            Class<?> cls23 = Class.forName((String) objArr122[i2]);
            Object[] objArr123 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod(str, new Class[i2]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(i2, 4).codePointAt(1) - 31, new char[]{'\b', '*', 13860, 13860, 6, CoreConstants.LEFT_PARENTHESIS_CHAR, CoreConstants.COMMA_CHAR, '\n', 13862, 13862, 20, 27, '\b', '\f', '0', 17, CoreConstants.RIGHT_PARENTHESIS_CHAR, '#'}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod(str, new Class[i2]).invoke(null, null)).getApplicationContext().getPackageName().length() + 39), objArr123);
            baseContext4 = (Context) cls23.getMethod((String) objArr123[0], new Class[0]).invoke(null, null);
        }
        if (baseContext4 != null) {
            int i220 = getARTIFICIAL_FRAME_PACKAGE_NAME + 7;
            artificialFrame = i220 % 128;
            if (i220 % 2 == 0) {
                boolean z2 = baseContext4 instanceof ContextWrapper;
                Object obj4 = null;
                obj4.hashCode();
                throw null;
            }
            baseContext4 = ((baseContext4 instanceof ContextWrapper) && ((ContextWrapper) baseContext4).getBaseContext() == null) ? null : baseContext4.getApplicationContext();
        }
        Object[] objArr124 = {baseContext4, Integer.valueOf(((Integer) Class.forName(str4).getMethod(str5, Object.class).invoke(null, this)).intValue()), 833468785};
        byte[] bArr25 = $$d;
        byte b33 = bArr25[57];
        byte b34 = bArr25[704];
        Object[] objArr125 = new Object[1];
        c(b33, b34, (short) (b34 | 133), objArr125);
        Class<?> cls24 = Class.forName((String) objArr125[0]);
        Object[] objArr126 = new Object[1];
        c(bArr25[224], bArr25[555], (short) 214, objArr126);
        objArr2 = (Object[]) cls24.getMethod((String) objArr126[0], Context.class, Integer.TYPE, Integer.TYPE).invoke(null, objArr124);
        if (baseContext4 != null) {
            int i221 = getARTIFICIAL_FRAME_PACKAGE_NAME + 125;
            artificialFrame = i221 % 128;
            try {
                if (i221 % 2 == 0) {
                    Object objAccessartificialFrame38 = ArtificialStackFrames.accessartificialFrame(777251007);
                    if (objAccessartificialFrame38 == null) {
                        int iNormalizeMetaState = KeyEvent.normalizeMetaState(0) + 30;
                        char cMyPid = (char) (49362 - (Process.myPid() >> 22));
                        int fadingEdgeLength2 = 684 - (ViewConfiguration.getFadingEdgeLength() >> 16);
                        byte[] bArr26 = $$a;
                        Object[] objArr127 = new Object[1];
                        b(bArr26[64], bArr26[23], (byte) ($$b & 127), objArr127);
                        objAccessartificialFrame38 = ArtificialStackFrames.coroutineCreation(iNormalizeMetaState, cMyPid, fadingEdgeLength2, -1321816393, false, (String) objArr127[0], null);
                    }
                    ((Field) objAccessartificialFrame38).set(null, objArr2);
                    lValueOf = Long.valueOf(((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[1])).longValue());
                    objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-2127922582);
                    if (objAccessartificialFrame == null) {
                        iIndexOf = ExpandableListView.getPackedPositionChild(0L) + 31;
                        deadChar = (char) (49362 - KeyEvent.getDeadChar(0, 0));
                        scrollBarFadeDuration = 684 - TextUtils.getTrimmedLength("");
                        i3 = 508509282;
                        z = false;
                        byte[] bArr27 = $$a;
                        Object[] objArr128 = new Object[1];
                        b((byte) (bArr27[84] + 1), bArr27[82], bArr27[49], objArr128);
                        obj = objArr128[0];
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(iIndexOf, deadChar, scrollBarFadeDuration, i3, z, (String) obj, null);
                    }
                } else {
                    Object objAccessartificialFrame39 = ArtificialStackFrames.accessartificialFrame(777251007);
                    if (objAccessartificialFrame39 == null) {
                        int i222 = (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 30;
                        char c20 = (char) (49362 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)));
                        int i223 = 685 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1));
                        byte[] bArr28 = $$a;
                        Object[] objArr129 = new Object[1];
                        b(bArr28[64], bArr28[23], (byte) ($$b & 127), objArr129);
                        objAccessartificialFrame39 = ArtificialStackFrames.coroutineCreation(i222, c20, i223, -1321816393, false, (String) objArr129[0], null);
                    }
                    ((Field) objAccessartificialFrame39).set(null, objArr2);
                    lValueOf = Long.valueOf(((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-2127922582);
                    if (objAccessartificialFrame == null) {
                        iIndexOf = TextUtils.indexOf((CharSequence) "", '0', 0) + 31;
                        deadChar = (char) (49362 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)));
                        scrollBarFadeDuration = (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 684;
                        i3 = 508509282;
                        z = false;
                        byte[] bArr29 = $$a;
                        Object[] objArr130 = new Object[1];
                        b((byte) (bArr29[84] + 1), bArr29[82], bArr29[49], objArr130);
                        obj = objArr130[0];
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(iIndexOf, deadChar, scrollBarFadeDuration, i3, z, (String) obj, null);
                    }
                }
                ((Field) objAccessartificialFrame).set(null, lValueOf);
            } catch (Exception unused8) {
                throw new RuntimeException();
            }
        }
        i4 = ((int[]) objArr2[1])[0];
        i5 = ((int[]) objArr2[0])[0];
        if (i5 == i4) {
            int i610 = ((int[]) objArr2[2])[0];
            Object[] objArr312 = {new int[]{((int[]) objArr2[0])[0]}, new int[]{((int[]) objArr2[1])[0]}, new int[1], (String) objArr2[3]};
            int iIdentityHashCode16 = System.identityHashCode(this);
            int i611 = (-598424452) + (((~((~iIdentityHashCode16) | (-757815843))) | 537008130) * (-245));
            int i612 = ~(iIdentityHashCode16 | (-757815843));
            int i613 = i610 + i611 + (i612 * (-245)) + ((i612 | 220807932) * 245);
            int i614 = (i613 << 13) ^ i613;
            int i615 = i614 ^ (i614 >>> 17);
            ((int[]) objArr312[2])[0] = i615 ^ (i615 << 5);
        } else {
            Object[] objArr313 = {Long.valueOf(((long) (i4 ^ i5)) ^ (((long) (-1445372791)) << 32)), Long.valueOf(-1445372279)};
            byte[] bArr30 = $$d;
            Object[] objArr314 = new Object[1];
            c(bArr30[57], bArr30[25], (short) 91, objArr314);
            Class<?> cls25 = Class.forName((String) objArr314[0]);
            byte b35 = (byte) (-bArr30[1]);
            Object[] objArr315 = new Object[1];
            c(b35, (byte) (b35 + 4), (short) 157, objArr315);
            cls25.getMethod((String) objArr315[0], Long.TYPE, Long.TYPE).invoke(null, objArr313);
            int i616 = ((int[]) objArr2[2])[0];
            Object[] objArr316 = {new int[]{((int[]) objArr2[0])[0]}, new int[]{((int[]) objArr2[1])[0]}, new int[1], (String) objArr2[3]};
            int iIdentityHashCode17 = System.identityHashCode(this);
            int i617 = ~iIdentityHashCode17;
            int i618 = i616 + 896895918 + (((~((-579710280) | i617)) | (~(936374231 | iIdentityHashCode17))) * (-831)) + ((~((-537460737) | iIdentityHashCode17)) * (-1662)) + (((~(iIdentityHashCode17 | 579710279)) | (~(i617 | (-398913496))) | (~(398913495 | iIdentityHashCode17))) * 831);
            int i710 = (i618 << 13) ^ i618;
            int i711 = i710 ^ (i710 >>> 17);
            ((int[]) objArr316[2])[0] = i711 ^ (i711 << 5);
        }
        objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1168947751);
        if (objAccessartificialFrame2 == null) {
            int i712 = (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 35;
            char jumpTapTimeout2 = (char) (ViewConfiguration.getJumpTapTimeout() >> 16);
            int iBlue3 = Color.blue(0) + 540;
            byte b36 = $$a[86];
            Object[] objArr317 = new Object[1];
            b((byte) 47, b36, (byte) (b36 << 2), objArr317);
            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(i712, jumpTapTimeout2, iBlue3, 624296913, false, (String) objArr317[0], null);
        }
        j = ((Field) objAccessartificialFrame2).getLong(null);
        if (j != -1) {
            int i713 = artificialFrame + 55;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i713 % 128;
            int i714 = i713 % 2;
            if (j + 1855 >= ((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue()) {
                objAccessartificialFrame27 = ArtificialStackFrames.accessartificialFrame(-1339222025);
                if (objAccessartificialFrame27 == null) {
                    int trimmedLength20 = TextUtils.getTrimmedLength("") + 36;
                    char cIndexOf3 = (char) TextUtils.indexOf("", "", 0, 0);
                    int i715 = (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 540;
                    Object[] objArr318 = new Object[1];
                    b((byte) 47, $$a[86], (byte) 56, objArr318);
                    objAccessartificialFrame27 = ArtificialStackFrames.coroutineCreation(trimmedLength20, cIndexOf3, i715, 793268735, false, (String) objArr318[0], null);
                }
                Object[] objArr319 = (Object[]) ((Field) objAccessartificialFrame27).get(null);
                objArr3 = new Object[]{new int[1], new int[1], new int[1]};
                int i716 = ((int[]) objArr319[2])[0];
                int i717 = ((int[]) objArr319[1])[0];
                ((int[]) objArr3[2])[0] = i716;
                ((int[]) objArr3[1])[0] = i717;
                int i718 = (~System.identityHashCode(this)) | 756703374;
                int i719 = 1650539338 + (i718 * 495) + (((~i718) | 554705030) * 495) + 477873935;
                int i810 = (i719 << 13) ^ i719;
                int i811 = i810 ^ (i810 >>> 17);
                ((int[]) objArr3[0])[0] = i811 ^ (i811 << 5);
            } else {
                objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1717965552);
                if (objAccessartificialFrame3 == null) {
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(View.MeasureSpec.getSize(0) + 20, (char) ((-16737700) - Color.rgb(0, 0, 0)), 982 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), 117222168, false, null, new Class[0]);
                }
                Object[] objArr3110 = {null, ((Constructor) objAccessartificialFrame3).newInstance(null), 477873935, 0};
                objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-501205803);
                if (objAccessartificialFrame4 == null) {
                    int mirror5 = 'T' - AndroidCharacter.getMirror('0');
                    char cBlue3 = (char) Color.blue(0);
                    int trimmedLength21 = TextUtils.getTrimmedLength("") + 540;
                    byte b37 = (byte) ($$a[110] - 1);
                    byte b38 = b37;
                    Object[] objArr3111 = new Object[1];
                    b(b37, b38, (byte) (b38 | SignedBytes.MAX_POWER_OF_TWO), objArr3111);
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(mirror5, cBlue3, trimmedLength21, 2101703389, false, (String) objArr3111[0], new Class[]{(Class) ArtificialStackFrames.coroutineCreation(KeyEvent.getDeadChar(0, 0) + 54, (char) (834 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1))), TextUtils.getCapsMode("", 0, 0) + 576), (Class) ArtificialStackFrames.coroutineCreation('f' - AndroidCharacter.getMirror('0'), (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) - 1), 630 - TextUtils.getOffsetAfter("", 0)), Integer.TYPE, Integer.TYPE});
                }
                objArr3 = (Object[]) ((Method) objAccessartificialFrame4).invoke(null, objArr3110);
                objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1339222025);
                if (objAccessartificialFrame5 == null) {
                    int scrollBarFadeDuration6 = 36 - (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                    char size11 = (char) View.MeasureSpec.getSize(0);
                    int iLastIndexOf6 = 539 - TextUtils.lastIndexOf("", '0', 0);
                    Object[] objArr410 = new Object[1];
                    b((byte) 47, $$a[86], (byte) 56, objArr410);
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(scrollBarFadeDuration6, size11, iLastIndexOf6, 793268735, false, (String) objArr410[0], null);
                }
                ((Field) objAccessartificialFrame5).set(null, objArr3);
                Long lValueOf21 = Long.valueOf(((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue());
                objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1168947751);
                if (objAccessartificialFrame6 == null) {
                    int packedPositionType3 = 36 - ExpandableListView.getPackedPositionType(0L);
                    char mirror6 = (char) ('0' - AndroidCharacter.getMirror('0'));
                    int iLastIndexOf7 = 539 - TextUtils.lastIndexOf("", '0');
                    byte b120 = $$a[86];
                    Object[] objArr411 = new Object[1];
                    b((byte) 47, b120, (byte) (b120 << 2), objArr411);
                    objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(packedPositionType3, mirror6, iLastIndexOf7, 624296913, false, (String) objArr411[0], null);
                }
                ((Field) objAccessartificialFrame6).set(null, lValueOf21);
            }
        } else {
            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1717965552);
            if (objAccessartificialFrame3 == null) {
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(View.MeasureSpec.getSize(0) + 20, (char) ((-16737700) - Color.rgb(0, 0, 0)), 982 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), 117222168, false, null, new Class[0]);
            }
            Object[] objArr3112 = {null, ((Constructor) objAccessartificialFrame3).newInstance(null), 477873935, 0};
            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-501205803);
            if (objAccessartificialFrame4 == null) {
                int mirror7 = 'T' - AndroidCharacter.getMirror('0');
                char cBlue4 = (char) Color.blue(0);
                int trimmedLength22 = TextUtils.getTrimmedLength("") + 540;
                byte b39 = (byte) ($$a[110] - 1);
                byte b310 = b39;
                Object[] objArr3113 = new Object[1];
                b(b39, b310, (byte) (b310 | SignedBytes.MAX_POWER_OF_TWO), objArr3113);
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(mirror7, cBlue4, trimmedLength22, 2101703389, false, (String) objArr3113[0], new Class[]{(Class) ArtificialStackFrames.coroutineCreation(KeyEvent.getDeadChar(0, 0) + 54, (char) (834 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1))), TextUtils.getCapsMode("", 0, 0) + 576), (Class) ArtificialStackFrames.coroutineCreation('f' - AndroidCharacter.getMirror('0'), (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) - 1), 630 - TextUtils.getOffsetAfter("", 0)), Integer.TYPE, Integer.TYPE});
            }
            objArr3 = (Object[]) ((Method) objAccessartificialFrame4).invoke(null, objArr3112);
            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1339222025);
            if (objAccessartificialFrame5 == null) {
                int scrollBarFadeDuration7 = 36 - (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                char size12 = (char) View.MeasureSpec.getSize(0);
                int iLastIndexOf8 = 539 - TextUtils.lastIndexOf("", '0', 0);
                Object[] objArr412 = new Object[1];
                b((byte) 47, $$a[86], (byte) 56, objArr412);
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(scrollBarFadeDuration7, size12, iLastIndexOf8, 793268735, false, (String) objArr412[0], null);
            }
            ((Field) objAccessartificialFrame5).set(null, objArr3);
            Long lValueOf22 = Long.valueOf(((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1168947751);
            if (objAccessartificialFrame6 == null) {
                int packedPositionType4 = 36 - ExpandableListView.getPackedPositionType(0L);
                char mirror8 = (char) ('0' - AndroidCharacter.getMirror('0'));
                int iLastIndexOf9 = 539 - TextUtils.lastIndexOf("", '0');
                byte b121 = $$a[86];
                Object[] objArr413 = new Object[1];
                b((byte) 47, b121, (byte) (b121 << 2), objArr413);
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(packedPositionType4, mirror8, iLastIndexOf9, 624296913, false, (String) objArr413[0], null);
            }
            ((Field) objAccessartificialFrame6).set(null, lValueOf22);
        }
        obj2 = objArr3[1];
        i6 = ((int[]) obj2)[0];
        obj3 = objArr3[2];
        i7 = ((int[]) obj3)[0];
        if (i7 == i6) {
            Object[] objArr414 = {new int[1], new int[1], new int[1]};
            int i812 = ((int[]) objArr3[0])[0];
            int i813 = ((int[]) obj3)[0];
            int i814 = ((int[]) obj2)[0];
            ((int[]) objArr414[2])[0] = i813;
            ((int[]) objArr414[1])[0] = i814;
            int i815 = ((Context) Class.forName("android.app.ActivityThread").getMethod(str, new Class[0]).invoke(null, null)).getResources().getConfiguration().navigationHidden;
            int i816 = ~i815;
            int i817 = 1389202733 + (((~((-605045255) | i816)) | (~(741923430 | i815))) * 520);
            int i818 = ~((-741923431) | i816);
            int i819 = ~(i815 | 609698319);
            int i910 = i812 + i817 + ((i818 | i819) * (-1040)) + ((i819 | (~(i816 | (-609698320))) | 136878176) * 520);
            int i911 = (i910 << 13) ^ i910;
            int i912 = i911 ^ (i911 >>> 17);
            i8 = 0;
            ((int[]) objArr414[0])[0] = i912 ^ (i912 << 5);
        } else {
            Object[] objArr415 = {Long.valueOf(((long) (i6 ^ i7)) ^ (((long) 1203920566) << 32)), Long.valueOf(1203916470)};
            byte[] bArr129 = $$d;
            Object[] objArr416 = new Object[1];
            c(bArr129[57], bArr129[25], (short) 91, objArr416);
            Class<?> cls26 = Class.forName((String) objArr416[0]);
            byte b122 = (byte) (-bArr129[1]);
            Object[] objArr417 = new Object[1];
            c(b122, (byte) (b122 + 4), (short) 157, objArr417);
            cls26.getMethod((String) objArr417[0], Long.TYPE, Long.TYPE).invoke(null, objArr415);
            Object[] objArr418 = {new int[1], new int[1], new int[1]};
            int i913 = ((int[]) objArr3[0])[0];
            int i914 = ((int[]) objArr3[2])[0];
            int i915 = ((int[]) objArr3[1])[0];
            ((int[]) objArr418[2])[0] = i914;
            ((int[]) objArr418[1])[0] = i915;
            int i916 = ~((Context) Class.forName("android.app.ActivityThread").getMethod(str, new Class[0]).invoke(null, null)).getResources().getConfiguration().keyboard;
            int i917 = i913 + (-129589575) + ((~(1318055797 | i916)) * 52) + (((~(235777904 | i916)) | (~((-1115843846) | i916)) | 1082277893) * (-52)) + (((~(i916 | (-235777905))) | 202211952) * 52);
            int i918 = (i917 << 13) ^ i917;
            int i919 = i918 ^ (i918 >>> 17);
            i8 = 0;
            ((int[]) objArr418[0])[0] = i919 ^ (i919 << 5);
        }
        objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(1745676544);
        if (objAccessartificialFrame7 == null) {
            int iIndexOf6 = 17 - TextUtils.indexOf("", "", i8);
            char scrollBarSize17 = (char) (ViewConfiguration.getScrollBarSize() >> 8);
            int i1020 = (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 746;
            byte b123 = $$a[86];
            Object[] objArr419 = new Object[1];
            b((byte) 47, b123, (byte) (b123 << 2), objArr419);
            objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(iIndexOf6, scrollBarSize17, i1020, -144068856, false, (String) objArr419[0], null);
        }
        j2 = ((Field) objAccessartificialFrame7).getLong(null);
        baseContext = getBaseContext();
        if (baseContext == null) {
            int iResolveOpacity2 = Drawable.resolveOpacity(i9, i9) + 26;
            char[] cArr2 = {CharUtils.CR, CoreConstants.SINGLE_QUOTE_CHAR, 21, CoreConstants.DASH_CHAR, CoreConstants.RIGHT_PARENTHESIS_CHAR, 19, 22, 3, '\n', ' ', 29, 3, '\n', '\b', '0', 17, CoreConstants.RIGHT_PARENTHESIS_CHAR, 27, 3, '\n', '#', 15, '/', 0, '\n', 25};
            byte bCodePointAt2 = (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod(str, new Class[i9]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(11) - 70);
            Object[] objArr1120 = new Object[1];
            a(iResolveOpacity2, cArr2, bCodePointAt2, objArr1120);
            Class<?> cls120 = Class.forName((String) objArr1120[0]);
            Object[] objArr1121 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod(str, new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 14, new char[]{'\b', '*', 13860, 13860, 6, CoreConstants.LEFT_PARENTHESIS_CHAR, CoreConstants.COMMA_CHAR, '\n', 13862, 13862, 20, 27, '\b', '\f', '0', 17, CoreConstants.RIGHT_PARENTHESIS_CHAR, '#'}, (byte) (60 - View.MeasureSpec.makeMeasureSpec(0, 0)), objArr1121);
            baseContext = (Context) cls120.getMethod((String) objArr1121[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            if (baseContext instanceof ContextWrapper) {
                baseContext = baseContext.getApplicationContext();
            } else {
                baseContext = baseContext.getApplicationContext();
            }
        }
        Object[] objArr1122 = {baseContext, Integer.valueOf(((Integer) Class.forName(str4).getMethod(str5, Object.class).invoke(null, this)).intValue()), 0, 379948054};
        byte[] bArr210 = $$d;
        Object[] objArr1123 = new Object[1];
        c(bArr210[10], (byte) (-bArr210[270]), (short) 234, objArr1123);
        Class<?> cls121 = Class.forName((String) objArr1123[0]);
        byte b311 = bArr210[492];
        Object[] objArr1124 = new Object[1];
        c(b311, (byte) (b311 | Ascii.DC2), (short) (-bArr210[108]), objArr1124);
        objArr4 = (Object[]) cls121.getMethod((String) objArr1124[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr1122);
        objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(1575402270);
        if (objAccessartificialFrame8 == null) {
            int iBlue4 = Color.blue(0) + 17;
            char cAxisFromString2 = (char) (MotionEvent.axisFromString("") + 1);
            int longPressTimeout9 = 747 - (ViewConfiguration.getLongPressTimeout() >> 16);
            Object[] objArr1125 = new Object[1];
            b((byte) 47, $$a[86], (byte) 56, objArr1125);
            objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(iBlue4, cAxisFromString2, longPressTimeout9, -1031537386, false, (String) objArr1125[0], null);
        }
        ((Field) objAccessartificialFrame8).set(null, objArr4);
    }

    @Override // android.app.Activity
    protected void onResume() throws Throwable {
        int i = 2 % 2;
        int i2 = artificialFrame + 69;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i2 % 128;
        int i3 = i2 % 2;
        Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(949068051);
        if (objAccessartificialFrame == null) {
            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(View.resolveSize(0, 0) + 30, (char) (49993 - (ViewConfiguration.getLongPressTimeout() >> 16)), 74 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), -1477122277, false, "MediaDescriptionCompatApi23Builder", null);
        }
        Object obj = ((Field) objAccessartificialFrame).get(null);
        try {
            Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1579113874);
            if (objAccessartificialFrame2 == null) {
                int iMakeMeasureSpec = 30 - View.MeasureSpec.makeMeasureSpec(0, 0);
                char longPressTimeout = (char) (49993 - (ViewConfiguration.getLongPressTimeout() >> 16));
                int pressedStateDuration = 74 - (ViewConfiguration.getPressedStateDuration() >> 16);
                byte[] bArr = $$d;
                Object[] objArr = new Object[1];
                c(bArr[28], bArr[467], (short) 664, objArr);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iMakeMeasureSpec, longPressTimeout, pressedStateDuration, -1048962150, false, (String) objArr[0], new Class[0]);
            }
            ((Method) objAccessartificialFrame2).invoke(obj, null);
            super.onResume();
            int i4 = artificialFrame + 25;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i4 % 128;
            int i5 = i4 % 2;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    @Override // android.app.Activity
    protected void onPause() throws Throwable {
        int i = 2 % 2;
        int i2 = artificialFrame + 97;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i2 % 128;
        try {
            if (i2 % 2 != 0) {
                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(949068051);
                if (objAccessartificialFrame == null) {
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(30 - View.MeasureSpec.makeMeasureSpec(0, 0), (char) (49993 - (ViewConfiguration.getTouchSlop() >> 8)), (ViewConfiguration.getEdgeSlop() >> 16) + 74, -1477122277, false, "MediaDescriptionCompatApi23Builder", null);
                }
                Object obj = ((Field) objAccessartificialFrame).get(null);
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1579114835);
                if (objAccessartificialFrame2 == null) {
                    int offsetBefore = 30 - TextUtils.getOffsetBefore("", 0);
                    char minimumFlingVelocity = (char) ((ViewConfiguration.getMinimumFlingVelocity() >> 16) + 49993);
                    int scrollBarFadeDuration = (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 74;
                    byte[] bArr = $$d;
                    Object[] objArr = new Object[1];
                    c(bArr[57], bArr[467], (short) 664, objArr);
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(offsetBefore, minimumFlingVelocity, scrollBarFadeDuration, -1048959141, false, (String) objArr[0], new Class[0]);
                }
                ((Method) objAccessartificialFrame2).invoke(obj, null);
                super.onPause();
                throw null;
            }
            Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(949068051);
            if (objAccessartificialFrame3 == null) {
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(30 - (ViewConfiguration.getScrollDefaultDelay() >> 16), (char) (49993 - View.combineMeasuredStates(0, 0)), 74 - (ViewConfiguration.getFadingEdgeLength() >> 16), -1477122277, false, "MediaDescriptionCompatApi23Builder", null);
            }
            Object obj2 = ((Field) objAccessartificialFrame3).get(null);
            Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1579114835);
            if (objAccessartificialFrame4 == null) {
                int iAlpha = Color.alpha(0) + 30;
                char cResolveSizeAndState = (char) (49993 - View.resolveSizeAndState(0, 0, 0));
                int iMyPid = 74 - (Process.myPid() >> 22);
                byte[] bArr2 = $$d;
                Object[] objArr2 = new Object[1];
                c(bArr2[57], bArr2[467], (short) 664, objArr2);
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(iAlpha, cResolveSizeAndState, iMyPid, -1048959141, false, (String) objArr2[0], new Class[0]);
            }
            ((Method) objAccessartificialFrame4).invoke(obj2, null);
            super.onPause();
            int i3 = artificialFrame + 91;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i3 % 128;
            int i4 = i3 % 2;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:16:0x02b3 A[Catch: all -> 0x0be0, TryCatch #0 {all -> 0x0be0, blocks: (B:53:0x0873, B:55:0x0894, B:56:0x08e2, B:14:0x029f, B:16:0x02b3, B:17:0x02df), top: B:93:0x029f }] */
    /* JADX WARN: Code duplicated, block: B:20:0x02f5  */
    /* JADX WARN: Code duplicated, block: B:25:0x0405  */
    /* JADX WARN: Code duplicated, block: B:52:0x07b0  */
    /* JADX WARN: Code duplicated, block: B:55:0x0894 A[Catch: all -> 0x0be0, TryCatch #0 {all -> 0x0be0, blocks: (B:53:0x0873, B:55:0x0894, B:56:0x08e2, B:14:0x029f, B:16:0x02b3, B:17:0x02df), top: B:93:0x029f }] */
    /* JADX WARN: Code duplicated, block: B:59:0x08f4  */
    /* JADX WARN: Code duplicated, block: B:64:0x0a00  */
    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) throws Throwable {
        Object objAccessartificialFrame;
        Object[] objArrAccessartificialFrame$78cbbd35;
        Object objAccessartificialFrame2;
        Object objAccessartificialFrame3;
        char c;
        Object objAccessartificialFrame4;
        Object[] objArr;
        Object objAccessartificialFrame5;
        Object objAccessartificialFrame6;
        int i = 2 % 2;
        int i2 = getARTIFICIAL_FRAME_PACKAGE_NAME + 97;
        artificialFrame = i2 % 128;
        int i3 = i2 % 2;
        super.attachBaseContext(context);
        Object objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-444530678);
        if (objAccessartificialFrame7 == null) {
            int packedPositionType = ExpandableListView.getPackedPositionType(0L) + 26;
            char mode = (char) View.MeasureSpec.getMode(0);
            int size = 1041 - View.MeasureSpec.getSize(0);
            byte b = $$a[86];
            Object[] objArr2 = new Object[1];
            b((byte) 47, b, (byte) (b << 2), objArr2);
            objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(packedPositionType, mode, size, 2061780482, false, (String) objArr2[0], null);
        }
        long j = ((Field) objAccessartificialFrame7).getLong(null);
        if (j != -1) {
            long j2 = j + 1879;
            Object[] objArr3 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 18, new char[]{CharUtils.CR, CoreConstants.SINGLE_QUOTE_CHAR, 21, CoreConstants.DASH_CHAR, CoreConstants.RIGHT_PARENTHESIS_CHAR, 19, 22, 3, '/', '!', 2, 1, 5, 24, '/', 3, '$', 31, '\f', CoreConstants.RIGHT_PARENTHESIS_CHAR, '\b', '\t'}, (byte) (30 - TextUtils.indexOf("", "")), objArr3);
            Class<?> cls = Class.forName((String) objArr3[0]);
            Object[] objArr4 = new Object[1];
            a((ViewConfiguration.getTapTimeout() >> 16) + 15, new char[]{6, '\f', '\n', ' ', '!', '\f', 25, 3, 4, '\f', '\n', '0', 17, CoreConstants.RIGHT_PARENTHESIS_CHAR, 13877}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(4) - 58), objArr4);
            if (j2 >= ((Long) cls.getDeclaredMethod((String) objArr4[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame8 == null) {
                    int maximumDrawingCacheSize = (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 26;
                    char size2 = (char) View.MeasureSpec.getSize(0);
                    int iIndexOf = TextUtils.indexOf((CharSequence) "", '0', 0) + 1042;
                    Object[] objArr5 = new Object[1];
                    b((byte) 47, $$a[86], (byte) 56, objArr5);
                    objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(maximumDrawingCacheSize, size2, iIndexOf, 1145017376, false, (String) objArr5[0], null);
                }
                Object[] objArr6 = (Object[]) ((Field) objAccessartificialFrame8).get(null);
                objArrAccessartificialFrame$78cbbd35 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
                int i4 = ((int[]) objArr6[3])[0];
                int i5 = ((int[]) objArr6[2])[0];
                String[] strArr = (String[]) objArr6[0];
                int mode2 = ((AudioManager) ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getSystemService("audio")).getMode();
                int i6 = ~mode2;
                int i7 = ((((-730224106) + (((~((-2638850) | i6)) | 80742656) * 220)) + (((~(i6 | (-271472246))) | 349576052) * (-440))) + ((mode2 | (-2638850)) * 220)) - 83472306;
                int i8 = (i7 << 13) ^ i7;
                int i9 = i8 ^ (i8 >>> 17);
                ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0] = i9 ^ (i9 << 5);
                c = 2;
            } else {
                Object[] objArr7 = new Object[1];
                a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(13) - 85, new char[]{25, 7, ' ', CharUtils.CR, 6, '\b', CharUtils.CR, CoreConstants.SINGLE_QUOTE_CHAR, 22, 6, 1, 4, 24, '/', 3, CoreConstants.LEFT_PARENTHESIS_CHAR}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(1) - 5), objArr7);
                Class<?> cls2 = Class.forName((String) objArr7[0]);
                Object[] objArr8 = new Object[1];
                a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 12, new char[]{17, 27, 6, CoreConstants.LEFT_PARENTHESIS_CHAR, '0', 17, 3, '\n', '.', 18, 21, 19, '!', '$', 26, 3}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) + 89), objArr8);
                int iIntValue = ((Integer) cls2.getMethod((String) objArr8[0], Object.class).invoke(null, this)).intValue();
                try {
                    Object[] objArr9 = {-613867578};
                    objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1648942878);
                    if (objAccessartificialFrame == null) {
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(TextUtils.getTrimmedLength("") + 8, (char) (22299 - AndroidCharacter.getMirror('0')), 1033 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), 47343338, false, null, new Class[]{Integer.TYPE});
                    }
                    objArrAccessartificialFrame$78cbbd35 = AnimationUtil.LatLngInterpolator.Linear.accessartificialFrame$78cbbd35(iIntValue, 0, ((Constructor) objAccessartificialFrame).newInstance(objArr9), -83472306, false);
                    objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-614804952);
                    if (objAccessartificialFrame2 == null) {
                        int iLastIndexOf = 25 - TextUtils.lastIndexOf("", '0', 0);
                        char cResolveSizeAndState = (char) View.resolveSizeAndState(0, 0, 0);
                        int iCombineMeasuredStates = View.combineMeasuredStates(0, 0) + 1041;
                        Object[] objArr10 = new Object[1];
                        b((byte) 47, $$a[86], (byte) 56, objArr10);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iLastIndexOf, cResolveSizeAndState, iCombineMeasuredStates, 1145017376, false, (String) objArr10[0], null);
                    }
                    ((Field) objAccessartificialFrame2).set(null, objArrAccessartificialFrame$78cbbd35);
                    try {
                        Object[] objArr11 = new Object[1];
                        a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) - 14, new char[]{CharUtils.CR, CoreConstants.SINGLE_QUOTE_CHAR, 21, CoreConstants.DASH_CHAR, CoreConstants.RIGHT_PARENTHESIS_CHAR, 19, 22, 3, '/', '!', 2, 1, 5, 24, '/', 3, '$', 31, '\f', CoreConstants.RIGHT_PARENTHESIS_CHAR, '\b', '\t'}, (byte) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 29), objArr11);
                        Class<?> cls3 = Class.forName((String) objArr11[0]);
                        Object[] objArr12 = new Object[1];
                        a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) - 21, new char[]{6, '\f', '\n', ' ', '!', '\f', 25, 3, 4, '\f', '\n', '0', 17, CoreConstants.RIGHT_PARENTHESIS_CHAR, 13877}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) + 18), objArr12);
                        Long lValueOf = Long.valueOf(((Long) cls3.getDeclaredMethod((String) objArr12[0], new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-444530678);
                        if (objAccessartificialFrame3 == null) {
                            int i10 = (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 25;
                            char cLastIndexOf = (char) ((-1) - TextUtils.lastIndexOf("", '0'));
                            int size3 = 1041 - View.MeasureSpec.getSize(0);
                            byte b2 = $$a[86];
                            Object[] objArr13 = new Object[1];
                            b((byte) 47, b2, (byte) (b2 << 2), objArr13);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(i10, cLastIndexOf, size3, 2061780482, false, (String) objArr13[0], null);
                        }
                        ((Field) objAccessartificialFrame3).set(null, lValueOf);
                        int i11 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                        int i12 = i11 + 27;
                        artificialFrame = i12 % 128;
                        c = 2;
                        int i13 = i12 % 2;
                        int i14 = i11 + 35;
                        artificialFrame = i14 % 128;
                        int i15 = i14 % 2;
                    } catch (Exception unused) {
                        throw new RuntimeException();
                    }
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
        } else {
            Object[] objArr14 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(13) - 85, new char[]{25, 7, ' ', CharUtils.CR, 6, '\b', CharUtils.CR, CoreConstants.SINGLE_QUOTE_CHAR, 22, 6, 1, 4, 24, '/', 3, CoreConstants.LEFT_PARENTHESIS_CHAR}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(1) - 5), objArr14);
            Class<?> cls4 = Class.forName((String) objArr14[0]);
            Object[] objArr15 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 12, new char[]{17, 27, 6, CoreConstants.LEFT_PARENTHESIS_CHAR, '0', 17, 3, '\n', '.', 18, 21, 19, '!', '$', 26, 3}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) + 89), objArr15);
            int iIntValue2 = ((Integer) cls4.getMethod((String) objArr15[0], Object.class).invoke(null, this)).intValue();
            Object[] objArr16 = {-613867578};
            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame == null) {
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(TextUtils.getTrimmedLength("") + 8, (char) (22299 - AndroidCharacter.getMirror('0')), 1033 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), 47343338, false, null, new Class[]{Integer.TYPE});
            }
            objArrAccessartificialFrame$78cbbd35 = AnimationUtil.LatLngInterpolator.Linear.accessartificialFrame$78cbbd35(iIntValue2, 0, ((Constructor) objAccessartificialFrame).newInstance(objArr16), -83472306, false);
            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame2 == null) {
                int iLastIndexOf2 = 25 - TextUtils.lastIndexOf("", '0', 0);
                char cResolveSizeAndState2 = (char) View.resolveSizeAndState(0, 0, 0);
                int iCombineMeasuredStates2 = View.combineMeasuredStates(0, 0) + 1041;
                Object[] objArr17 = new Object[1];
                b((byte) 47, $$a[86], (byte) 56, objArr17);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iLastIndexOf2, cResolveSizeAndState2, iCombineMeasuredStates2, 1145017376, false, (String) objArr17[0], null);
            }
            ((Field) objAccessartificialFrame2).set(null, objArrAccessartificialFrame$78cbbd35);
            Object[] objArr18 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) - 14, new char[]{CharUtils.CR, CoreConstants.SINGLE_QUOTE_CHAR, 21, CoreConstants.DASH_CHAR, CoreConstants.RIGHT_PARENTHESIS_CHAR, 19, 22, 3, '/', '!', 2, 1, 5, 24, '/', 3, '$', 31, '\f', CoreConstants.RIGHT_PARENTHESIS_CHAR, '\b', '\t'}, (byte) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 29), objArr18);
            Class<?> cls5 = Class.forName((String) objArr18[0]);
            Object[] objArr19 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) - 21, new char[]{6, '\f', '\n', ' ', '!', '\f', 25, 3, 4, '\f', '\n', '0', 17, CoreConstants.RIGHT_PARENTHESIS_CHAR, 13877}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) + 18), objArr19);
            Long lValueOf2 = Long.valueOf(((Long) cls5.getDeclaredMethod((String) objArr19[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-444530678);
            if (objAccessartificialFrame3 == null) {
                int i16 = (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 25;
                char cLastIndexOf2 = (char) ((-1) - TextUtils.lastIndexOf("", '0'));
                int size4 = 1041 - View.MeasureSpec.getSize(0);
                byte b3 = $$a[86];
                Object[] objArr110 = new Object[1];
                b((byte) 47, b3, (byte) (b3 << 2), objArr110);
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(i16, cLastIndexOf2, size4, 2061780482, false, (String) objArr110[0], null);
            }
            ((Field) objAccessartificialFrame3).set(null, lValueOf2);
            int i17 = getARTIFICIAL_FRAME_PACKAGE_NAME;
            int i18 = i17 + 27;
            artificialFrame = i18 % 128;
            c = 2;
            int i19 = i18 % 2;
            int i110 = i17 + 35;
            artificialFrame = i110 % 128;
            int i111 = i110 % 2;
        }
        int i20 = ((int[]) objArrAccessartificialFrame$78cbbd35[c])[0];
        int i21 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
        if (i21 == i20) {
            Object[] objArr20 = new Object[4];
            objArr20[1] = new int[1];
            objArr20[c] = new int[]{i};
            objArr20[3] = new int[]{i};
            int i22 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i23 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i24 = ((int[]) objArrAccessartificialFrame$78cbbd35[c])[0];
            objArr20[0] = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int i25 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().mcc;
            int i26 = ~i25;
            int i27 = i22 + 1715869390 + (((~((-240923947) | i26)) | 319027753) * (-328)) + ((i25 | 319027753) * 164) + (((~(i25 | 240923946)) | 285460993 | (~(i26 | (-207357187)))) * 164);
            int i28 = (i27 << 13) ^ i27;
            int i29 = i28 ^ (i28 >>> 17);
            ((int[]) objArr20[1])[0] = i29 ^ (i29 << 5);
        } else {
            ArrayList arrayList = new ArrayList();
            String[] strArr2 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            if (strArr2 != null) {
                for (String str : strArr2) {
                    int i30 = artificialFrame + 57;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i30 % 128;
                    int i31 = i30 % 2;
                    arrayList.add(str);
                }
            }
            try {
                Object[] objArr21 = {Long.valueOf((((long) (-2137520290)) << 32) ^ ((long) (i20 ^ i21))), Long.valueOf(-2137520292)};
                byte[] bArr = $$d;
                Object[] objArr22 = new Object[1];
                c(bArr[57], (byte) (-bArr[60]), (short) 664, objArr22);
                Class<?> cls6 = Class.forName((String) objArr22[0]);
                byte b4 = (byte) (-bArr[1]);
                Object[] objArr23 = new Object[1];
                c(b4, (byte) (b4 + 4), (short) 157, objArr23);
                cls6.getMethod((String) objArr23[0], Long.TYPE, Long.TYPE).invoke(null, objArr21);
                Object[] objArr24 = {strArr, new int[1], new int[]{i}, new int[]{i}};
                int i32 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
                int i33 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
                int i34 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
                String[] strArr3 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
                int streamVolume = ((AudioManager) ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getSystemService("audio")).getStreamVolume(3);
                int i35 = ~streamVolume;
                int i36 = i32 + (-1365382257) + (((~((-135275010) | i35)) | (~((-276955357) | streamVolume)) | (~(469401567 | streamVolume))) * 765) + (((~((-412230366) | i35)) | 135275009) * 1530) + (((~(streamVolume | (-412230366))) | (~(i35 | 469401567))) * 765);
                int i37 = (i36 << 13) ^ i36;
                int i38 = i37 ^ (i37 >>> 17);
                ((int[]) objArr24[1])[0] = i38 ^ (i38 << 5);
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 == null) {
                    throw th2;
                }
                throw cause2;
            }
        }
        Object objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(-1268268649);
        if (objAccessartificialFrame9 == null) {
            int minimumFlingVelocity = 25 - (ViewConfiguration.getMinimumFlingVelocity() >> 16);
            char c2 = (char) (30068 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)));
            int scrollBarSize = (ViewConfiguration.getScrollBarSize() >> 8) + 816;
            byte b5 = $$a[86];
            Object[] objArr25 = new Object[1];
            b((byte) 47, b5, (byte) (b5 << 2), objArr25);
            objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(minimumFlingVelocity, c2, scrollBarSize, 721586079, false, (String) objArr25[0], null);
        }
        long j3 = ((Field) objAccessartificialFrame9).getLong(null);
        if (j3 != -1) {
            int i39 = artificialFrame + 29;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i39 % 128;
            int i40 = i39 % 2;
            long j4 = j3 + 2033;
            Object[] objArr26 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 13, new char[]{CharUtils.CR, CoreConstants.SINGLE_QUOTE_CHAR, 21, CoreConstants.DASH_CHAR, CoreConstants.RIGHT_PARENTHESIS_CHAR, 19, 22, 3, '/', '!', 2, 1, 5, 24, '/', 3, '$', 31, '\f', CoreConstants.RIGHT_PARENTHESIS_CHAR, '\b', '\t'}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 26), objArr26);
            Class<?> cls7 = Class.forName((String) objArr26[0]);
            Object[] objArr27 = new Object[1];
            a(KeyEvent.keyCodeFromString("") + 15, new char[]{6, '\f', '\n', ' ', '!', '\f', 25, 3, 4, '\f', '\n', '0', 17, CoreConstants.RIGHT_PARENTHESIS_CHAR, 13877}, (byte) ((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 54), objArr27);
            if (j4 >= ((Long) cls7.getDeclaredMethod((String) objArr27[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame10 == null) {
                    int deadChar = KeyEvent.getDeadChar(0, 0) + 25;
                    char offsetAfter = (char) (TextUtils.getOffsetAfter("", 0) + 30068);
                    int iCombineMeasuredStates3 = View.combineMeasuredStates(0, 0) + 816;
                    Object[] objArr28 = new Object[1];
                    b((byte) 47, $$a[86], (byte) 56, objArr28);
                    objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(deadChar, offsetAfter, iCombineMeasuredStates3, 891606461, false, (String) objArr28[0], null);
                }
                Object[] objArr29 = (Object[]) ((Field) objAccessartificialFrame10).get(null);
                objArr = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i41 = ((int[]) objArr29[0])[0];
                int i42 = ((int[]) objArr29[1])[0];
                String[] strArr4 = (String[]) objArr29[2];
                int iFreeMemory = (int) Runtime.getRuntime().freeMemory();
                int i43 = ~iFreeMemory;
                int i44 = 1987376355 + (((~(850271059 | i43)) | (~((-1048443426) | iFreeMemory))) * 210) + (((~(iFreeMemory | 1056963443)) | (~(i43 | (-841751042)))) * 210) + 187039134;
                int i45 = (i44 << 13) ^ i44;
                int i46 = i45 ^ (i45 >>> 17);
                ((int[]) objArr[3])[0] = i46 ^ (i46 << 5);
                int i47 = getARTIFICIAL_FRAME_PACKAGE_NAME + 107;
                artificialFrame = i47 % 128;
                if (i47 % 2 == 0) {
                    int i48 = 3 % 3;
                }
            } else {
                Object[] objArr30 = new Object[1];
                a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(18) - 83, new char[]{25, 7, ' ', CharUtils.CR, 6, '\b', CharUtils.CR, CoreConstants.SINGLE_QUOTE_CHAR, 22, 6, 1, 4, 24, '/', 3, CoreConstants.LEFT_PARENTHESIS_CHAR}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 40), objArr30);
                Class<?> cls8 = Class.forName((String) objArr30[0]);
                Object[] objArr31 = new Object[1];
                a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 19, new char[]{17, 27, 6, CoreConstants.LEFT_PARENTHESIS_CHAR, '0', 17, 3, '\n', '.', 18, 21, 19, '!', '$', 26, 3}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 90), objArr31);
                Object[] objArr32 = {Integer.valueOf(((Integer) cls8.getMethod((String) objArr31[0], Object.class).invoke(null, this)).intValue()), 0, 187039134};
                objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1327366003);
                if (objAccessartificialFrame4 == null) {
                    int longPressTimeout = 25 - (ViewConfiguration.getLongPressTimeout() >> 16);
                    char gidForName = (char) (30067 - Process.getGidForName(""));
                    int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0) + 816;
                    byte[] bArr2 = $$a;
                    Object[] objArr33 = new Object[1];
                    b(bArr2[10], bArr2[26], (byte) 104, objArr33);
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(longPressTimeout, gidForName, iMakeMeasureSpec, -797394565, false, (String) objArr33[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                }
                objArr = (Object[]) ((Method) objAccessartificialFrame4).invoke(null, objArr32);
                objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame5 == null) {
                    int iBlue = Color.blue(0) + 25;
                    char cMyPid = (char) (30068 - (Process.myPid() >> 22));
                    int i49 = (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 815;
                    Object[] objArr34 = new Object[1];
                    b((byte) 47, $$a[86], (byte) 56, objArr34);
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(iBlue, cMyPid, i49, 891606461, false, (String) objArr34[0], null);
                }
                ((Field) objAccessartificialFrame5).set(null, objArr);
                try {
                    Object[] objArr35 = new Object[1];
                    a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(1) - 27, new char[]{CharUtils.CR, CoreConstants.SINGLE_QUOTE_CHAR, 21, CoreConstants.DASH_CHAR, CoreConstants.RIGHT_PARENTHESIS_CHAR, 19, 22, 3, '/', '!', 2, 1, 5, 24, '/', 3, '$', 31, '\f', CoreConstants.RIGHT_PARENTHESIS_CHAR, '\b', '\t'}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 9), objArr35);
                    Class<?> cls9 = Class.forName((String) objArr35[0]);
                    Object[] objArr36 = new Object[1];
                    a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 11, new char[]{6, '\f', '\n', ' ', '!', '\f', 25, 3, 4, '\f', '\n', '0', 17, CoreConstants.RIGHT_PARENTHESIS_CHAR, 13877}, (byte) (55 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1))), objArr36);
                    Long lValueOf3 = Long.valueOf(((Long) cls9.getDeclaredMethod((String) objArr36[0], new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                    if (objAccessartificialFrame6 == null) {
                        int pressedStateDuration = (ViewConfiguration.getPressedStateDuration() >> 16) + 25;
                        char cResolveSizeAndState3 = (char) (30068 - View.resolveSizeAndState(0, 0, 0));
                        int iLastIndexOf3 = 815 - TextUtils.lastIndexOf("", '0', 0, 0);
                        byte b6 = $$a[86];
                        Object[] objArr37 = new Object[1];
                        b((byte) 47, b6, (byte) (b6 << 2), objArr37);
                        objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(pressedStateDuration, cResolveSizeAndState3, iLastIndexOf3, 721586079, false, (String) objArr37[0], null);
                    }
                    ((Field) objAccessartificialFrame6).set(null, lValueOf3);
                } catch (Exception unused2) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object[] objArr38 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(18) - 83, new char[]{25, 7, ' ', CharUtils.CR, 6, '\b', CharUtils.CR, CoreConstants.SINGLE_QUOTE_CHAR, 22, 6, 1, 4, 24, '/', 3, CoreConstants.LEFT_PARENTHESIS_CHAR}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 40), objArr38);
            Class<?> cls10 = Class.forName((String) objArr38[0]);
            Object[] objArr39 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 19, new char[]{17, 27, 6, CoreConstants.LEFT_PARENTHESIS_CHAR, '0', 17, 3, '\n', '.', 18, 21, 19, '!', '$', 26, 3}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 90), objArr39);
            Object[] objArr310 = {Integer.valueOf(((Integer) cls10.getMethod((String) objArr39[0], Object.class).invoke(null, this)).intValue()), 0, 187039134};
            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1327366003);
            if (objAccessartificialFrame4 == null) {
                int longPressTimeout2 = 25 - (ViewConfiguration.getLongPressTimeout() >> 16);
                char gidForName2 = (char) (30067 - Process.getGidForName(""));
                int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0) + 816;
                byte[] bArr3 = $$a;
                Object[] objArr311 = new Object[1];
                b(bArr3[10], bArr3[26], (byte) 104, objArr311);
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(longPressTimeout2, gidForName2, iMakeMeasureSpec2, -797394565, false, (String) objArr311[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            }
            objArr = (Object[]) ((Method) objAccessartificialFrame4).invoke(null, objArr310);
            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame5 == null) {
                int iBlue2 = Color.blue(0) + 25;
                char cMyPid2 = (char) (30068 - (Process.myPid() >> 22));
                int i410 = (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 815;
                Object[] objArr312 = new Object[1];
                b((byte) 47, $$a[86], (byte) 56, objArr312);
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(iBlue2, cMyPid2, i410, 891606461, false, (String) objArr312[0], null);
            }
            ((Field) objAccessartificialFrame5).set(null, objArr);
            Object[] objArr313 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(1) - 27, new char[]{CharUtils.CR, CoreConstants.SINGLE_QUOTE_CHAR, 21, CoreConstants.DASH_CHAR, CoreConstants.RIGHT_PARENTHESIS_CHAR, 19, 22, 3, '/', '!', 2, 1, 5, 24, '/', 3, '$', 31, '\f', CoreConstants.RIGHT_PARENTHESIS_CHAR, '\b', '\t'}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 9), objArr313);
            Class<?> cls11 = Class.forName((String) objArr313[0]);
            Object[] objArr314 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 11, new char[]{6, '\f', '\n', ' ', '!', '\f', 25, 3, 4, '\f', '\n', '0', 17, CoreConstants.RIGHT_PARENTHESIS_CHAR, 13877}, (byte) (55 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1))), objArr314);
            Long lValueOf4 = Long.valueOf(((Long) cls11.getDeclaredMethod((String) objArr314[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1268268649);
            if (objAccessartificialFrame6 == null) {
                int pressedStateDuration2 = (ViewConfiguration.getPressedStateDuration() >> 16) + 25;
                char cResolveSizeAndState4 = (char) (30068 - View.resolveSizeAndState(0, 0, 0));
                int iLastIndexOf4 = 815 - TextUtils.lastIndexOf("", '0', 0, 0);
                byte b7 = $$a[86];
                Object[] objArr315 = new Object[1];
                b((byte) 47, b7, (byte) (b7 << 2), objArr315);
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(pressedStateDuration2, cResolveSizeAndState4, iLastIndexOf4, 721586079, false, (String) objArr315[0], null);
            }
            ((Field) objAccessartificialFrame6).set(null, lValueOf4);
        }
        int i50 = ((int[]) objArr[1])[0];
        int i51 = ((int[]) objArr[0])[0];
        if (i51 == i50) {
            int i52 = getARTIFICIAL_FRAME_PACKAGE_NAME + 61;
            artificialFrame = i52 % 128;
            int i53 = i52 % 2;
            Object[] objArr40 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i54 = ((int[]) objArr[3])[0];
            int i55 = ((int[]) objArr[0])[0];
            int i56 = ((int[]) objArr[1])[0];
            String[] strArr5 = (String[]) objArr[2];
            int iMyTid = Process.myTid();
            int i57 = i54 + 499324583 + (((~((-206569825) | iMyTid)) | (~((~iMyTid) | (-8397459)))) * (-318)) + (((~(1064305005 | iMyTid)) | (-1072702464)) * (-318)) + (((~(iMyTid | (-1064305006))) | 866132639) * TypedValues.AttributesType.TYPE_PIVOT_TARGET);
            int i58 = (i57 << 13) ^ i57;
            int i59 = i58 ^ (i58 >>> 17);
            ((int[]) objArr40[3])[0] = i59 ^ (i59 << 5);
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        String[] strArr6 = (String[]) objArr[2];
        if (strArr6 != null) {
            int i60 = getARTIFICIAL_FRAME_PACKAGE_NAME + 35;
            artificialFrame = i60 % 128;
            int i61 = i60 % 2;
            for (String str2 : strArr6) {
                arrayList2.add(str2);
            }
        }
        long j5 = (((long) (-667268686)) << 32) ^ ((long) (i50 ^ i51));
        long j6 = -667268685;
        int i62 = artificialFrame + 95;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i62 % 128;
        int i63 = i62 % 2;
        Object[] objArr41 = {Long.valueOf(j5), Long.valueOf(j6)};
        byte[] bArr4 = $$d;
        Object[] objArr42 = new Object[1];
        c(bArr4[57], bArr4[62], (short) 600, objArr42);
        Class<?> cls12 = Class.forName((String) objArr42[0]);
        byte b8 = (byte) (-bArr4[1]);
        Object[] objArr43 = new Object[1];
        c(b8, (byte) (b8 + 4), (short) 157, objArr43);
        cls12.getMethod((String) objArr43[0], Long.TYPE, Long.TYPE).invoke(null, objArr41);
        Object[] objArr44 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
        int i64 = ((int[]) objArr[3])[0];
        int i65 = ((int[]) objArr[0])[0];
        int i66 = ((int[]) objArr[1])[0];
        String[] strArr7 = (String[]) objArr[2];
        int mode3 = ((AudioManager) ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getSystemService("audio")).getMode();
        int i67 = i64 + (((~((-269222158) | mode3)) | (-501084160)) * TypedValues.PositionType.TYPE_TRANSITION_EASING) + 396918876 + ((~((~mode3) | (-269222158))) * TypedValues.PositionType.TYPE_TRANSITION_EASING);
        int i68 = (i67 << 13) ^ i67;
        int i69 = i68 ^ (i68 >>> 17);
        ((int[]) objArr44[3])[0] = i69 ^ (i69 << 5);
    }

    static {
        byte[] bArr = new byte[711];
        System.arraycopy("\u0016µíÏðþ;Ãôü\u0004÷\u00033Éï\u0006îÿ\u0002\u00012Æÿé\u000féþ\rï÷ÿýùúBÇüëBÁ÷ö\u000bï\u0000\tñ:éÈý\u0001\u0015ññó\f\u0002\u000fÙ\u0004\u0011éðø\fîûLÞÉ\bù\u0004ûïÐùÿöý\u0007÷\u0005\u001dÛÿé\nüú÷\u0003\u0018Óðþ;Ä\u0001úúÿïü\u00009¸\t\u0000úëBµ\bø\bï\töþï@Ñæ\u0004\u0002\u000fÛ\u0007û\u0011ÝüÿDüÛÉ\u0000\u000bï\u0000\tñ\u0015Ö\u0007ö\bÿí\u0007\u0002\u0013çð\u0007úÿ-ü¿ðþ;Ãôü\u0004÷\u00033Éï\u0006îÿ\u0002\u00012ÃööAÁ÷ö\u000bï\u0000\tñ:½ýýþñ\u0011å\tò\u0006öý\u000bøðþüúý<°ü\ríúüúîü\u000eëú\u0007ÿù\u0002ö\u0004ñ\"Ð\rð\u0004ø÷\u0004ÿ÷òF·\nï\u0005\u0004ñÿë\u0015é\u0007öý<Á÷ö\u000bï\u0000\tñ:Þßòû$ßú\u0002\u001dÛî\fí\u0005õø\u0001ùðþ;Ãôü\u0004÷\u00033Äùó\tÿýê\n3Çðþùýý\u0005óöýAÛÛø\u0007öý\tñ\u0018Úÿõ\t\u0001ûïJüÛÉ\u0000\u000bï\u0000\tñ\u0015Ö\u0007ö\bÿí\u0007\u0002\u0013çð\u0007úÿ+\u0000ÿðü\u00009\u0001Á÷ö\u000bï\u0000\tñ:º\u0000\u0007é\nóù\u0001;Éï\u0006îÿ\u0002\u00012æÛûýïü\tý\rà\bô\u0002í/Ùÿíø\u000bïðþ;Ä\u0001úúÿïü\u00009Áø\böþñ\u0003õ\u0007õÿ÷\u00053Çðù\t3ÚÚÿ\u0007ë\u000eúï\u001bêðø\fó\u0007ú\u001báúë\u0001ùõQüÛÉ\u0000\u000bï\u0000\tñ\u0015Ö\u0007ö\bÿí\u0007\u0002\u0013çð\u0007úÿ,øðùÿöý\u0007÷\u0005\u001eÍ\t\u0000é\u0007öýðþ;Ãôü\u0004÷\u00033½ýýþñB´\tò\u0006öý<Èýë\u000bð\u0007û3Çðþüúý<èÝë\u000bð\u0007û=Ëß\u0002&Ïü\u0000ú\bë\u0003ðþ;Ãôü\u0004÷\u00033½ýýþñBÇðþüúý<·\u000bõþ÷ö\u000bï\u0000\tñ:°ü\u0005ðþ;Ä\u0001úúÿïü\u00009Áø\böþñ\u0003õ\u0007õÿ÷\u00053Çðù\t3ÚÚÿ\u0007ë\u000eúï\u001bêðø\fó\u0007ú\u001báúë\u0001ùõQÝÐþù\u000bï\u0001öý÷6¹þøA¾ù\u0004\u0001ýúô9Çðù\t3·ÿ\u00037çÆ\u0012óÿ\u0002\u001dÉ\u000büýï\u001aÞ\rúô\u0002ï".getBytes(CharEncoding.ISO_8859_1), 0, bArr, 0, 711);
        $$d = bArr;
        $$e = 175;
        $$a = new byte[]{38, -81, -30, 49, -9, Ascii.DC2, -34, Ascii.EM, 4, -17, 19, -15, -1, -18, Ascii.SI, 19, -11, 5, -7, -2, Ascii.SI, -36, Ascii.NAK, Ascii.CR, -15, 2, 9, 6, -34, Ascii.SI, 19, -11, 5, -7, -9, Ascii.DC2, -36, 33, -19, 17, -32, Ascii.SI, 19, -11, 5, -7, -7, Ascii.DC2, -43, Ascii.GS, -4, 17, 2, 5, -1, -33, 33, -2, -9, 5, -7, 5, -1, -50, 39, Ascii.VT, -7, -12, Ascii.SI, 49, 2, -11, -3, 3, -6, 6, -8, Ascii.VT, -25, 33, -19, 2, 8, -37, 44, -17, Ascii.FF, -8, Ascii.SO, -2, Ascii.SI, -33, 33, -19, 17, -32, Ascii.SI, 19, -11, 5, -7, 10, -31, Ascii.DC4, Ascii.CR, -8, -11, -13, Ascii.ESC, Ascii.ESC, 1, -7, -6, -33, 51, -12, 3, -8, 1, Ascii.CR};
        $$b = 169;
        getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
        artificialFrame = 1;
        ArtificialStackFrames = new char[]{44371, 44334, 44345, 44409, 44370, 44389, 44373, 44387, 44395, 44353, 44338, 44385, 44367, 44396, 44392, 44344, 44340, 44362, 44366, 44368, 44393, 44394, 44343, 44375, 44388, 44374, 44403, 44391, 44390, 44355, 44342, 44400, 44337, 44341, 44406, 44386, 44372, 44336, 44397, 44360, 44399, 44398, 44402, 44405, 44363, 44404, 44339, 44369, 44361};
        coroutineCreation = (char) 39069;
    }
}
