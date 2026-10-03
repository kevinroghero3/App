package net.openid.appauth;

import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.Process;
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
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.imageutils.JfifUtil;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.common.base.Ascii;
import com.google.common.collect.CompactHashMap;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import o.ArtificialStackFrames;
import o.asBinder;
import org.apache.commons.lang3.CharEncoding;

/* JADX INFO: loaded from: classes6.dex */
public class RedirectUriReceiverActivity extends AppCompatActivity {
    private static final byte[] $$a;
    private static final int $$b;
    private static final byte[] $$d;
    private static final int $$e;
    private static int artificialFrame;
    private static long extraCommand;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME;
    private static final byte[] $$c = {81, -123, 100, Ascii.RS};
    private static final int $$f = 32;
    private static int $10 = 0;
    private static int $11 = 1;

    /* JADX WARN: Code duplicated, block: B:10:0x0029  */
    /* JADX WARN: Code duplicated, block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0029 -> B:11:0x002e). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0029
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$g(byte r6, byte r7, byte r8) {
        /*
            byte[] r0 = net.openid.appauth.RedirectUriReceiverActivity.$$c
            int r8 = r8 * 2
            int r8 = 4 - r8
            int r7 = r7 * 3
            int r1 = 1 - r7
            int r6 = r6 * 3
            int r6 = 118 - r6
            byte[] r1 = new byte[r1]
            r2 = 0
            int r7 = 0 - r7
            if (r0 != 0) goto L18
            r3 = r8
            r4 = r2
            goto L2e
        L18:
            r3 = r2
            r5 = r8
            r8 = r6
            r6 = r5
        L1c:
            byte r4 = (byte) r8
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r7) goto L29
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            return r6
        L29:
            r3 = r0[r6]
            r5 = r3
            r3 = r6
            r6 = r5
        L2e:
            int r8 = r8 + r6
            int r6 = r3 + 1
            r3 = r4
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: net.openid.appauth.RedirectUriReceiverActivity.$$g(byte, byte, byte):java.lang.String");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0023  */
    /* JADX WARN: Code duplicated, block: B:8:0x001b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x0028). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0023
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void b(short r7, byte r8, byte r9, java.lang.Object[] r10) {
        /*
            byte[] r0 = net.openid.appauth.RedirectUriReceiverActivity.$$a
            int r9 = r9 + 4
            int r7 = r7 + 65
            int r8 = 21 - r8
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L11
            r3 = r8
            r7 = r9
            r4 = r2
            goto L28
        L11:
            r3 = r2
        L12:
            int r9 = r9 + 1
            int r4 = r3 + 1
            byte r5 = (byte) r7
            r1[r3] = r5
            if (r4 != r8) goto L23
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L23:
            r3 = r0[r9]
            r6 = r9
            r9 = r7
            r7 = r6
        L28:
            int r9 = r9 + r3
            r3 = r4
            r6 = r9
            r9 = r7
            r7 = r6
            goto L12
        */
        throw new UnsupportedOperationException("Method not decompiled: net.openid.appauth.RedirectUriReceiverActivity.b(short, byte, byte, java.lang.Object[]):void");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0022  */
    /* JADX WARN: Code duplicated, block: B:8:0x001a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0022 -> B:11:0x0027). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0022
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void c(short r7, int r8, int r9, java.lang.Object[] r10) {
        /*
            int r8 = 82 - r8
            byte[] r0 = net.openid.appauth.RedirectUriReceiverActivity.$$d
            int r7 = 111 - r7
            int r9 = r9 + 4
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L10
            r3 = r9
            r4 = r2
            goto L27
        L10:
            r3 = r2
        L11:
            int r4 = r3 + 1
            byte r5 = (byte) r7
            r1[r3] = r5
            int r9 = r9 + 1
            if (r4 != r8) goto L22
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L22:
            r3 = r0[r9]
            r6 = r3
            r3 = r9
            r9 = r6
        L27:
            int r7 = r7 + r9
            int r7 = r7 + (-4)
            r9 = r3
            r3 = r4
            goto L11
        */
        throw new UnsupportedOperationException("Method not decompiled: net.openid.appauth.RedirectUriReceiverActivity.c(short, int, int, java.lang.Object[]):void");
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        startActivity(AuthorizationManagementActivity.createResponseHandlingIntent(this, getIntent().getData()));
        finish();
    }

    private static void a(int i, char[] cArr, Object[] objArr) throws Throwable {
        int i2 = 2 % 2;
        asBinder asbinder = new asBinder();
        asbinder.c = i;
        int length = cArr.length;
        long[] jArr = new long[length];
        asbinder.d = 0;
        while (asbinder.d < cArr.length) {
            int i3 = asbinder.d;
            try {
                Object[] objArr2 = {Integer.valueOf(cArr[asbinder.d]), asbinder, asbinder};
                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1562553046);
                if (objAccessartificialFrame == null) {
                    byte b = (byte) 0;
                    byte b2 = b;
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(11 - (ViewConfiguration.getFadingEdgeLength() >> 16), (char) Color.blue(0), 1407 - TextUtils.getOffsetAfter("", 0), 1035473698, false, $$g(b, b2, b2), new Class[]{Integer.TYPE, Object.class, Object.class});
                }
                jArr[i3] = ((Long) ((Method) objAccessartificialFrame).invoke(null, objArr2)).longValue() ^ (extraCommand ^ (-2360974883025274865L));
                Object[] objArr3 = {asbinder, asbinder};
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1981632360);
                if (objAccessartificialFrame2 == null) {
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(View.resolveSizeAndState(0, 0, 0) + 8, (char) (ViewConfiguration.getScrollDefaultDelay() >> 16), (-16776967) - Color.rgb(0, 0, 0), 378009232, false, "w", new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame2).invoke(null, objArr3);
                int i4 = $11 + 83;
                $10 = i4 % 128;
                if (i4 % 2 != 0) {
                    int i5 = 2 / 5;
                }
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }
        char[] cArr2 = new char[length];
        asbinder.d = 0;
        int i6 = $11 + 125;
        $10 = i6 % 128;
        int i7 = i6 % 2;
        while (asbinder.d < cArr.length) {
            cArr2[asbinder.d] = (char) jArr[asbinder.d];
            Object[] objArr4 = {asbinder, asbinder};
            Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1981632360);
            if (objAccessartificialFrame3 == null) {
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(8 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), (char) KeyEvent.normalizeMetaState(0), (ViewConfiguration.getTapTimeout() >> 16) + 249, 378009232, false, "w", new Class[]{Object.class, Object.class});
            }
            ((Method) objAccessartificialFrame3).invoke(null, objArr4);
        }
        objArr[0] = new String(cArr2);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x01e0  */
    /* JADX WARN: Code duplicated, block: B:140:0x1014  */
    /* JADX WARN: Code duplicated, block: B:141:0x1098  */
    /* JADX WARN: Code duplicated, block: B:146:0x117c  */
    /* JADX WARN: Code duplicated, block: B:149:0x11cc  */
    /* JADX WARN: Code duplicated, block: B:151:0x11eb  */
    /* JADX WARN: Code duplicated, block: B:153:0x11f4  */
    /* JADX WARN: Code duplicated, block: B:155:0x12ad  */
    /* JADX WARN: Code duplicated, block: B:156:0x12af  */
    /* JADX WARN: Code duplicated, block: B:159:0x12b6  */
    /* JADX WARN: Code duplicated, block: B:15:0x01e6  */
    /* JADX WARN: Code duplicated, block: B:161:0x1343  */
    /* JADX WARN: Code duplicated, block: B:167:0x1355  */
    /* JADX WARN: Code duplicated, block: B:172:0x145f  */
    /* JADX WARN: Code duplicated, block: B:174:0x146b  */
    /* JADX WARN: Code duplicated, block: B:176:0x1474  */
    /* JADX WARN: Code duplicated, block: B:17:0x024a  */
    /* JADX WARN: Code duplicated, block: B:181:0x14de  */
    /* JADX WARN: Code duplicated, block: B:182:0x1513  */
    /* JADX WARN: Code duplicated, block: B:184:0x151c  */
    /* JADX WARN: Code duplicated, block: B:189:0x1585  */
    /* JADX WARN: Code duplicated, block: B:197:0x15e2  */
    /* JADX WARN: Code duplicated, block: B:198:0x164c  */
    /* JADX WARN: Code duplicated, block: B:200:0x1658  */
    /* JADX WARN: Code duplicated, block: B:203:0x165c A[LOOP:1: B:201:0x1659->B:203:0x165c, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:209:0x1770  */
    /* JADX WARN: Code duplicated, block: B:212:0x17bc  */
    /* JADX WARN: Code duplicated, block: B:214:0x17e5  */
    /* JADX WARN: Code duplicated, block: B:216:0x17f8  */
    /* JADX WARN: Code duplicated, block: B:219:0x18a5  */
    /* JADX WARN: Code duplicated, block: B:222:0x18d8 A[Catch: all -> 0x258c, TryCatch #10 {all -> 0x258c, blocks: (B:328:0x23d9, B:330:0x23e6, B:331:0x2415, B:333:0x241f, B:335:0x242c, B:336:0x2461, B:220:0x18c3, B:222:0x18d8, B:223:0x190a, B:122:0x0e55, B:124:0x0e5b, B:125:0x0e88, B:127:0x0eb2, B:128:0x0f3e, B:84:0x0a96, B:86:0x0ab8, B:87:0x0b07), top: B:387:0x0a96 }] */
    /* JADX WARN: Code duplicated, block: B:226:0x1921  */
    /* JADX WARN: Code duplicated, block: B:231:0x1990  */
    /* JADX WARN: Code duplicated, block: B:235:0x19ee  */
    /* JADX WARN: Code duplicated, block: B:236:0x1a6d  */
    /* JADX WARN: Code duplicated, block: B:238:0x1a78  */
    /* JADX WARN: Code duplicated, block: B:23:0x025a  */
    /* JADX WARN: Code duplicated, block: B:241:0x1a7c A[LOOP:0: B:239:0x1a79->B:241:0x1a7c, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:247:0x1b6f  */
    /* JADX WARN: Code duplicated, block: B:250:0x1bc3  */
    /* JADX WARN: Code duplicated, block: B:252:0x1be2  */
    /* JADX WARN: Code duplicated, block: B:254:0x1beb  */
    /* JADX WARN: Code duplicated, block: B:257:0x1cc3  */
    /* JADX WARN: Code duplicated, block: B:258:0x1cc5  */
    /* JADX WARN: Code duplicated, block: B:261:0x1ccc  */
    /* JADX WARN: Code duplicated, block: B:263:0x1d4f  */
    /* JADX WARN: Code duplicated, block: B:265:0x1d53  */
    /* JADX WARN: Code duplicated, block: B:268:0x1d67  */
    /* JADX WARN: Code duplicated, block: B:269:0x1d69  */
    /* JADX WARN: Code duplicated, block: B:273:0x1df6  */
    /* JADX WARN: Code duplicated, block: B:275:0x1dff  */
    /* JADX WARN: Code duplicated, block: B:27:0x02ef  */
    /* JADX WARN: Code duplicated, block: B:280:0x1e6a  */
    /* JADX WARN: Code duplicated, block: B:286:0x1ecf  */
    /* JADX WARN: Code duplicated, block: B:287:0x1f65  */
    /* JADX WARN: Code duplicated, block: B:292:0x2047  */
    /* JADX WARN: Code duplicated, block: B:295:0x2098  */
    /* JADX WARN: Code duplicated, block: B:29:0x02f8  */
    /* JADX WARN: Code duplicated, block: B:302:0x2192  */
    /* JADX WARN: Code duplicated, block: B:304:0x2198  */
    /* JADX WARN: Code duplicated, block: B:306:0x21de  */
    /* JADX WARN: Code duplicated, block: B:308:0x21e2  */
    /* JADX WARN: Code duplicated, block: B:312:0x21ee  */
    /* JADX WARN: Code duplicated, block: B:317:0x2290  */
    /* JADX WARN: Code duplicated, block: B:322:0x22fd  */
    /* JADX WARN: Code duplicated, block: B:326:0x2361  */
    /* JADX WARN: Code duplicated, block: B:327:0x23d4  */
    /* JADX WARN: Code duplicated, block: B:330:0x23e6 A[Catch: all -> 0x258c, TryCatch #10 {all -> 0x258c, blocks: (B:328:0x23d9, B:330:0x23e6, B:331:0x2415, B:333:0x241f, B:335:0x242c, B:336:0x2461, B:220:0x18c3, B:222:0x18d8, B:223:0x190a, B:122:0x0e55, B:124:0x0e5b, B:125:0x0e88, B:127:0x0eb2, B:128:0x0f3e, B:84:0x0a96, B:86:0x0ab8, B:87:0x0b07), top: B:387:0x0a96 }] */
    /* JADX WARN: Code duplicated, block: B:335:0x242c A[Catch: all -> 0x258c, TryCatch #10 {all -> 0x258c, blocks: (B:328:0x23d9, B:330:0x23e6, B:331:0x2415, B:333:0x241f, B:335:0x242c, B:336:0x2461, B:220:0x18c3, B:222:0x18d8, B:223:0x190a, B:122:0x0e55, B:124:0x0e5b, B:125:0x0e88, B:127:0x0eb2, B:128:0x0f3e, B:84:0x0a96, B:86:0x0ab8, B:87:0x0b07), top: B:387:0x0a96 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x036b  */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onStart() throws Throwable {
        Context baseContext;
        Object[] objArr;
        Object objAccessartificialFrame;
        Object objAccessartificialFrame2;
        int i;
        Object[] objArr2;
        Object[] objArr3;
        int i2;
        int i3;
        Object[] objArr4;
        Object obj;
        int i4;
        Object obj2;
        int i5;
        int i6;
        Object objAccessartificialFrame3;
        long j;
        int i7;
        Context baseContext2;
        Object[] objArr5;
        char c;
        int i8;
        Object objAccessartificialFrame4;
        Long lValueOf;
        Object objAccessartificialFrame5;
        int iAxisFromString;
        char packedPositionType;
        int touchSlop;
        int i9;
        boolean z;
        Object obj3;
        Object objAccessartificialFrame6;
        int i10;
        int i11;
        ArrayList arrayList;
        String[] strArr;
        int i12;
        int i13;
        Object objAccessartificialFrame7;
        long j2;
        Object objAccessartificialFrame8;
        Object[] objArrAccessartificialFrame$78cbbd35;
        Object objAccessartificialFrame9;
        Object objAccessartificialFrame10;
        int i14;
        int i15;
        ArrayList arrayList2;
        String[] strArr2;
        int i16;
        int i17;
        Object objAccessartificialFrame11;
        long j3;
        int i18;
        Context baseContext3;
        Object[] objArr6;
        Object objAccessartificialFrame12;
        Object objAccessartificialFrame13;
        int i19;
        int i20;
        int i21;
        Object objAccessartificialFrame14;
        long j4;
        Context baseContext4;
        Object[] objArr7;
        Object objAccessartificialFrame15;
        Object objAccessartificialFrame16;
        int i22;
        int i23;
        Object objAccessartificialFrame17;
        Object objAccessartificialFrame18;
        Object objAccessartificialFrame19;
        Object objAccessartificialFrame20;
        Object objAccessartificialFrame21;
        int i24 = 2 % 2;
        Object[] objArr8 = new Object[1];
        a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(19) + 35768, new char[]{55918, 22086, 49701, 32264, 60156, 26277, 37505, 3888, 47960, 14115, 41895, 57329, 19362, 51079, 28761, 60451, 6162, 38107, 221, 48261, 10592, 42327}, objArr8);
        String str = (String) objArr8[0];
        Object[] objArr9 = new Object[1];
        a((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 50340, new char[]{55914, 7878, 21284, 38800, 51432, 3411, 16821, 47838, 65346, 13219, 29713, 43372, 60890, 9731, 7020}, objArr9);
        String str2 = (String) objArr9[0];
        Object[] objArr10 = new Object[1];
        a(57329 - View.resolveSize(0, 0), new char[]{55909, 1439, 26011, 17853, 42469, 34262, 58824, 50678, 9696, 1368, 25910, 17709, 42288, 34118, 58692, 50557}, objArr10);
        String str3 = (String) objArr10[0];
        Object[] objArr11 = new Object[1];
        a(16184 - (android.os.SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (android.os.SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), new char[]{55910, 58716, 41988, 26564, 9895, 58997, 41265, 24823, 9215, 57985, 41562, 27962, 11480, 61355, 44905, 28243}, objArr11);
        String str4 = (String) objArr11[0];
        Object objAccessartificialFrame22 = ArtificialStackFrames.accessartificialFrame(-1283093189);
        if (objAccessartificialFrame22 == null) {
            int deadChar = 30 - KeyEvent.getDeadChar(0, 0);
            char keyRepeatDelay = (char) (49362 - (ViewConfiguration.getKeyRepeatDelay() >> 16));
            int i25 = (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 685;
            byte[] bArr = $$a;
            Object[] objArr12 = new Object[1];
            b((byte) (bArr[96] + 1), bArr[17], bArr[12], objArr12);
            objAccessartificialFrame22 = ArtificialStackFrames.coroutineCreation(deadChar, keyRepeatDelay, i25, 752929587, false, (String) objArr12[0], null);
        }
        long j5 = ((Field) objAccessartificialFrame22).getLong(null);
        if (j5 != -1) {
            int i26 = getARTIFICIAL_FRAME_PACKAGE_NAME + 3;
            artificialFrame = i26 % 128;
            int i27 = i26 % 2;
            if (j5 + 2043 >= ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                int i28 = artificialFrame + 93;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i28 % 128;
                int i29 = i28 % 2;
                Object objAccessartificialFrame23 = ArtificialStackFrames.accessartificialFrame(-326560385);
                if (objAccessartificialFrame23 == null) {
                    int edgeSlop = 30 - (ViewConfiguration.getEdgeSlop() >> 16);
                    char pressedStateDuration = (char) ((ViewConfiguration.getPressedStateDuration() >> 16) + 49362);
                    int i30 = (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 684;
                    byte[] bArr2 = $$a;
                    Object[] objArr13 = new Object[1];
                    b((byte) (bArr2[65] - 1), bArr2[17], bArr2[100], objArr13);
                    objAccessartificialFrame23 = ArtificialStackFrames.coroutineCreation(edgeSlop, pressedStateDuration, i30, 1944867703, false, (String) objArr13[0], null);
                }
                Object[] objArr14 = (Object[]) ((Field) objAccessartificialFrame23).get(null);
                objArr = new Object[]{new int[]{((int[]) objArr14[0])[0]}, new int[]{((int[]) objArr14[1])[0]}, new int[1], (String) objArr14[3]};
                int iIdentityHashCode = System.identityHashCode(this);
                int i31 = 909541582 + (((~((-574709724) | iIdentityHashCode)) | 574636696 | (~(403914051 | iIdentityHashCode))) * (-754));
                int i32 = ~((-574636697) | iIdentityHashCode);
                int i33 = ~iIdentityHashCode;
                int i34 = ((i31 + ((i32 | (~(978550747 | i33))) * (-754))) + ((i33 | (-574709724)) * 754)) - 2000822766;
                int i35 = (i34 << 13) ^ i34;
                int i36 = i35 ^ (i35 >>> 17);
                ((int[]) objArr[2])[0] = i36 ^ (i36 << 5);
            } else {
                baseContext = getBaseContext();
                if (baseContext == null) {
                    Object[] objArr15 = new Object[1];
                    a(27763 - Drawable.resolveOpacity(0, 0), new char[]{55918, 46610, 653, 40740, 27564, 50265, 20697, 11524, 47606, 2676, 58881, 29392, 53034, 23483, 13361, 32987, 7497, 59845, 31341, 55039, 41639, 16136, 35743, 25663, 61606, 19792}, objArr15);
                    Class<?> cls = Class.forName((String) objArr15[0]);
                    Object[] objArr16 = new Object[1];
                    a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(0) + 53404, new char[]{55916, 2747, 31743, 43070, 39278, 51620, 16125, 28425, 23671, 36022, 65001, 8749, 4960, 17315, 45301, 57641, 54896, 1712}, objArr16);
                    baseContext = (Context) cls.getMethod((String) objArr16[0], new Class[0]).invoke(null, null);
                }
                if (baseContext != null) {
                    if ((baseContext instanceof ContextWrapper) || ((ContextWrapper) baseContext).getBaseContext() != null) {
                        baseContext = baseContext.getApplicationContext();
                    } else {
                        baseContext = null;
                    }
                }
                try {
                    Object[] objArr17 = {baseContext, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, -2000822766};
                    byte[] bArr3 = $$d;
                    Object[] objArr18 = new Object[1];
                    c(bArr3[172], bArr3[13], bArr3[8], objArr18);
                    Class<?> cls2 = Class.forName((String) objArr18[0]);
                    byte b = (byte) (bArr3[99] - 1);
                    Object[] objArr19 = new Object[1];
                    c(b, (byte) (b | Ascii.DC2), (short) (-bArr3[500]), objArr19);
                    objArr = (Object[]) cls2.getMethod((String) objArr19[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr17);
                    if (baseContext != null) {
                        objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-326560385);
                        if (objAccessartificialFrame == null) {
                            int threadPriority = ((Process.getThreadPriority(0) + 20) >> 6) + 30;
                            char modifierMetaStateMask = (char) (49361 - ((byte) KeyEvent.getModifierMetaStateMask()));
                            int i37 = (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 683;
                            byte[] bArr4 = $$a;
                            Object[] objArr20 = new Object[1];
                            b((byte) (bArr4[65] - 1), bArr4[17], bArr4[100], objArr20);
                            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(threadPriority, modifierMetaStateMask, i37, 1944867703, false, (String) objArr20[0], null);
                        }
                        ((Field) objAccessartificialFrame).set(null, objArr);
                        try {
                            Long lValueOf2 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1283093189);
                            if (objAccessartificialFrame2 == null) {
                                int iIndexOf = TextUtils.indexOf("", "") + 30;
                                char capsMode = (char) (49362 - TextUtils.getCapsMode("", 0, 0));
                                int i38 = (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 685;
                                byte[] bArr5 = $$a;
                                Object[] objArr21 = new Object[1];
                                b((byte) (bArr5[96] + 1), bArr5[17], bArr5[12], objArr21);
                                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iIndexOf, capsMode, i38, 752929587, false, (String) objArr21[0], null);
                            }
                            ((Field) objAccessartificialFrame2).set(null, lValueOf2);
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
            }
        } else {
            baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr110 = new Object[1];
                a(27763 - Drawable.resolveOpacity(0, 0), new char[]{55918, 46610, 653, 40740, 27564, 50265, 20697, 11524, 47606, 2676, 58881, 29392, 53034, 23483, 13361, 32987, 7497, 59845, 31341, 55039, 41639, 16136, 35743, 25663, 61606, 19792}, objArr110);
                Class<?> cls3 = Class.forName((String) objArr110[0]);
                Object[] objArr111 = new Object[1];
                a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(0) + 53404, new char[]{55916, 2747, 31743, 43070, 39278, 51620, 16125, 28425, 23671, 36022, 65001, 8749, 4960, 17315, 45301, 57641, 54896, 1712}, objArr111);
                baseContext = (Context) cls3.getMethod((String) objArr111[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                if (baseContext instanceof ContextWrapper) {
                    baseContext = baseContext.getApplicationContext();
                } else {
                    baseContext = baseContext.getApplicationContext();
                }
            }
            Object[] objArr112 = {baseContext, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, -2000822766};
            byte[] bArr6 = $$d;
            Object[] objArr113 = new Object[1];
            c(bArr6[172], bArr6[13], bArr6[8], objArr113);
            Class<?> cls4 = Class.forName((String) objArr113[0]);
            byte b2 = (byte) (bArr6[99] - 1);
            Object[] objArr114 = new Object[1];
            c(b2, (byte) (b2 | Ascii.DC2), (short) (-bArr6[500]), objArr114);
            objArr = (Object[]) cls4.getMethod((String) objArr114[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr112);
            if (baseContext != null) {
                objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-326560385);
                if (objAccessartificialFrame == null) {
                    int threadPriority2 = ((Process.getThreadPriority(0) + 20) >> 6) + 30;
                    char modifierMetaStateMask2 = (char) (49361 - ((byte) KeyEvent.getModifierMetaStateMask()));
                    int i39 = (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 683;
                    byte[] bArr7 = $$a;
                    Object[] objArr22 = new Object[1];
                    b((byte) (bArr7[65] - 1), bArr7[17], bArr7[100], objArr22);
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(threadPriority2, modifierMetaStateMask2, i39, 1944867703, false, (String) objArr22[0], null);
                }
                ((Field) objAccessartificialFrame).set(null, objArr);
                Long lValueOf3 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1283093189);
                if (objAccessartificialFrame2 == null) {
                    int iIndexOf2 = TextUtils.indexOf("", "") + 30;
                    char capsMode2 = (char) (49362 - TextUtils.getCapsMode("", 0, 0));
                    int i310 = (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 685;
                    byte[] bArr8 = $$a;
                    Object[] objArr23 = new Object[1];
                    b((byte) (bArr8[96] + 1), bArr8[17], bArr8[12], objArr23);
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iIndexOf2, capsMode2, i310, 752929587, false, (String) objArr23[0], null);
                }
                ((Field) objAccessartificialFrame2).set(null, lValueOf3);
            }
        }
        int i40 = ((int[]) objArr[1])[0];
        int i41 = ((int[]) objArr[0])[0];
        if (i41 == i40) {
            int i42 = ((int[]) objArr[2])[0];
            Object[] objArr24 = {new int[]{((int[]) objArr[0])[0]}, new int[]{((int[]) objArr[1])[0]}, new int[1], (String) objArr[3]};
            int i43 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().keyboard;
            int i44 = (-490557490) + ((~(i43 | 545563328)) * JfifUtil.MARKER_SOI);
            int i45 = ~i43;
            int i46 = i42 + i44 + (((-424368159) | i45) * (-216)) + (((~(i45 | 545563328)) | 433060446) * JfifUtil.MARKER_SOI);
            int i47 = (i46 << 13) ^ i46;
            int i48 = i47 ^ (i47 >>> 17);
            i = 0;
            ((int[]) objArr24[2])[0] = i48 ^ (i48 << 5);
        } else {
            Object[] objArr25 = objArr;
            try {
                Object[] objArr26 = {Long.valueOf(((long) (i40 ^ i41)) ^ (((long) (-960648344)) << 32)), Long.valueOf(-960648340)};
                byte[] bArr9 = $$d;
                byte b3 = bArr9[172];
                byte b4 = bArr9[64];
                Object[] objArr27 = new Object[1];
                c(b3, b4, (short) (b4 | 80), objArr27);
                Class<?> cls5 = Class.forName((String) objArr27[0]);
                byte b5 = bArr9[118];
                Object[] objArr28 = new Object[1];
                c(b5, (byte) (b5 + 4), (short) ($$e + 5), objArr28);
                cls5.getMethod((String) objArr28[0], Long.TYPE, Long.TYPE).invoke(null, objArr26);
                int i49 = ((int[]) objArr25[2])[0];
                Object[] objArr29 = {new int[]{((int[]) objArr25[0])[0]}, new int[]{((int[]) objArr25[1])[0]}, new int[1], (String) objArr25[3]};
                int iIdentityHashCode2 = System.identityHashCode(this);
                int i50 = ~iIdentityHashCode2;
                int i51 = 1975318494 + (((~((-6955300) | i50)) | (~(820652347 | iIdentityHashCode2))) * 520);
                int i52 = ~((-820652348) | i50);
                int i53 = ~(iIdentityHashCode2 | 157971427);
                int i54 = i49 + i51 + ((i52 | i53) * (-1040)) + ((i53 | (~(i50 | (-157971428))) | 813697048) * 520);
                int i55 = (i54 << 13) ^ i54;
                int i56 = i55 ^ (i55 >>> 17);
                i = 0;
                ((int[]) objArr29[2])[0] = i56 ^ (i56 << 5);
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 == null) {
                    throw th2;
                }
                throw cause2;
            }
        }
        Object objAccessartificialFrame24 = ArtificialStackFrames.accessartificialFrame(1056123296);
        if (objAccessartificialFrame24 == null) {
            int packedPositionType2 = ExpandableListView.getPackedPositionType(0L) + 30;
            char size = (char) (49362 - View.MeasureSpec.getSize(i));
            int bitsPerPixel = ImageFormat.getBitsPerPixel(i) + 685;
            byte[] bArr10 = $$a;
            Object[] objArr30 = new Object[1];
            b((byte) (bArr10[65] - 1), bArr10[94], bArr10[116], objArr30);
            objAccessartificialFrame24 = ArtificialStackFrames.coroutineCreation(packedPositionType2, size, bitsPerPixel, -1583976536, false, (String) objArr30[0], null);
        }
        long j6 = ((Field) objAccessartificialFrame24).getLong(null);
        if (j6 == -1 || j6 + 1999 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Object[] objArr31 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 887647891};
            byte[] bArr11 = $$d;
            Object[] objArr32 = new Object[1];
            c(bArr11[172], bArr11[129], (short) 163, objArr32);
            Class<?> cls6 = Class.forName((String) objArr32[0]);
            Object[] objArr33 = new Object[1];
            c(bArr11[172], bArr11[167], (short) JfifUtil.MARKER_SOS, objArr33);
            objArr2 = (Object[]) cls6.getMethod((String) objArr33[0], Integer.TYPE, Integer.TYPE).invoke(null, objArr31);
            Object objAccessartificialFrame25 = ArtificialStackFrames.accessartificialFrame(910856866);
            if (objAccessartificialFrame25 == null) {
                int minimumFlingVelocity = 30 - (ViewConfiguration.getMinimumFlingVelocity() >> 16);
                char c2 = (char) ((android.os.SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (android.os.SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 49361);
                int i57 = (android.os.SystemClock.elapsedRealtime() > 0L ? 1 : (android.os.SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 683;
                Object[] objArr34 = new Object[1];
                b((byte) ($$b << 1), $$a[98], (byte) 41, objArr34);
                objAccessartificialFrame25 = ArtificialStackFrames.coroutineCreation(minimumFlingVelocity, c2, i57, -1456483158, false, (String) objArr34[0], null);
            }
            ((Field) objAccessartificialFrame25).set(null, objArr2);
            try {
                Long lValueOf4 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame26 = ArtificialStackFrames.accessartificialFrame(1056123296);
                if (objAccessartificialFrame26 == null) {
                    int iKeyCodeFromString = KeyEvent.keyCodeFromString("") + 30;
                    char mirror = (char) (AndroidCharacter.getMirror('0') + 49314);
                    int i58 = (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 684;
                    byte[] bArr12 = $$a;
                    Object[] objArr35 = new Object[1];
                    b((byte) (bArr12[65] - 1), bArr12[94], bArr12[116], objArr35);
                    objAccessartificialFrame26 = ArtificialStackFrames.coroutineCreation(iKeyCodeFromString, mirror, i58, -1583976536, false, (String) objArr35[0], null);
                }
                ((Field) objAccessartificialFrame26).set(null, lValueOf4);
            } catch (Exception unused2) {
                throw new RuntimeException();
            }
        } else {
            Object objAccessartificialFrame27 = ArtificialStackFrames.accessartificialFrame(910856866);
            if (objAccessartificialFrame27 == null) {
                int maxKeyCode = (KeyEvent.getMaxKeyCode() >> 16) + 30;
                char touchSlop2 = (char) ((ViewConfiguration.getTouchSlop() >> 8) + 49362);
                int keyRepeatDelay2 = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 684;
                Object[] objArr36 = new Object[1];
                b((byte) ($$b << 1), $$a[98], (byte) 41, objArr36);
                objAccessartificialFrame27 = ArtificialStackFrames.coroutineCreation(maxKeyCode, touchSlop2, keyRepeatDelay2, -1456483158, false, (String) objArr36[0], null);
            }
            Object[] objArr37 = (Object[]) ((Field) objAccessartificialFrame27).get(null);
            objArr2 = new Object[]{new int[]{((int[]) objArr37[0])[0]}, new int[]{((int[]) objArr37[1])[0]}, new int[1], (String) objArr37[3]};
            int i59 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().mnc;
            int i60 = ~i59;
            int i61 = 1622390030 + (((-671828097) | i59) * (-676)) + (((~(296006237 | i60)) | 671828096) * 676) + (((~(i59 | 967834333)) | (~(i60 | (-682617538))) | 10789441) * 676) + 887647891;
            int i62 = (i61 << 13) ^ i61;
            int i63 = i62 ^ (i62 >>> 17);
            ((int[]) objArr2[2])[0] = i63 ^ (i63 << 5);
        }
        int i64 = ((int[]) objArr2[1])[0];
        int i65 = ((int[]) objArr2[0])[0];
        if (i65 == i64) {
            int i66 = ((int[]) objArr2[2])[0];
            Object[] objArr38 = {new int[]{((int[]) objArr2[0])[0]}, new int[]{((int[]) objArr2[1])[0]}, new int[1], (String) objArr2[3]};
            int iIdentityHashCode3 = System.identityHashCode(this);
            int i67 = ~iIdentityHashCode3;
            int i68 = i66 + 1072657367 + (((~((-314905374) | iIdentityHashCode3)) | (~((-663718402) | i67))) * JfifUtil.MARKER_EOI) + (((~(iIdentityHashCode3 | (-663718402))) | 42271233) * JfifUtil.MARKER_EOI) + (((~((-314905374) | i67)) | 663718401) * JfifUtil.MARKER_EOI);
            int i69 = (i68 << 13) ^ i68;
            int i70 = i69 ^ (i69 >>> 17);
            ((int[]) objArr38[2])[0] = i70 ^ (i70 << 5);
        } else {
            new ArrayList().add((String) objArr2[3]);
            Object[] objArr39 = {Long.valueOf(((long) (i64 ^ i65)) ^ (((long) 637574341) << 32)), Long.valueOf(637574357)};
            byte[] bArr13 = $$d;
            Object[] objArr40 = new Object[1];
            c(bArr13[172], bArr13[128], (short) 234, objArr40);
            Class<?> cls7 = Class.forName((String) objArr40[0]);
            byte b6 = bArr13[118];
            Object[] objArr41 = new Object[1];
            c(b6, (byte) (b6 + 4), (short) ($$e + 5), objArr41);
            cls7.getMethod((String) objArr41[0], Long.TYPE, Long.TYPE).invoke(null, objArr39);
            int i71 = ((int[]) objArr2[2])[0];
            Object[] objArr42 = {new int[]{((int[]) objArr2[0])[0]}, new int[]{((int[]) objArr2[1])[0]}, new int[1], (String) objArr2[3]};
            int iIdentityHashCode4 = System.identityHashCode(this);
            int i72 = ~((-40173700) | iIdentityHashCode4);
            int i73 = ~iIdentityHashCode4;
            int i74 = i71 + (-1707083442) + ((i72 | (~((-880841753) | i73))) * 920) + ((40173699 | (~((-57608324) | i73))) * 920) + (((~(iIdentityHashCode4 | (-880841753))) | (~((-40173700) | i73)) | (~((-17434625) | iIdentityHashCode4))) * 920);
            int i75 = (i74 << 13) ^ i74;
            int i76 = i75 ^ (i75 >>> 17);
            ((int[]) objArr42[2])[0] = i76 ^ (i76 << 5);
        }
        Object objAccessartificialFrame28 = ArtificialStackFrames.accessartificialFrame(-1268268649);
        if (objAccessartificialFrame28 == null) {
            int doubleTapTimeout = (ViewConfiguration.getDoubleTapTimeout() >> 16) + 25;
            char fadingEdgeLength = (char) (30068 - (ViewConfiguration.getFadingEdgeLength() >> 16));
            int absoluteGravity = 816 - Gravity.getAbsoluteGravity(0, 0);
            byte[] bArr14 = $$a;
            Object[] objArr43 = new Object[1];
            b((byte) 47, bArr14[98], bArr14[81], objArr43);
            objAccessartificialFrame28 = ArtificialStackFrames.coroutineCreation(doubleTapTimeout, fadingEdgeLength, absoluteGravity, 721586079, false, (String) objArr43[0], null);
        }
        long j7 = ((Field) objAccessartificialFrame28).getLong(null);
        if (j7 == -1 || j7 + 2030 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            try {
                Object[] objArr44 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, -1957696735};
                Object objAccessartificialFrame29 = ArtificialStackFrames.accessartificialFrame(1327366003);
                if (objAccessartificialFrame29 == null) {
                    int trimmedLength = TextUtils.getTrimmedLength("") + 25;
                    char capsMode3 = (char) (30068 - TextUtils.getCapsMode("", 0, 0));
                    int iIndexOf3 = TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 817;
                    byte[] bArr15 = $$a;
                    Object[] objArr45 = new Object[1];
                    b(bArr15[10], bArr15[26], (byte) 65, objArr45);
                    objAccessartificialFrame29 = ArtificialStackFrames.coroutineCreation(trimmedLength, capsMode3, iIndexOf3, -797394565, false, (String) objArr45[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                }
                objArr3 = (Object[]) ((Method) objAccessartificialFrame29).invoke(null, objArr44);
                Object objAccessartificialFrame30 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame30 == null) {
                    int pressedStateDuration2 = (ViewConfiguration.getPressedStateDuration() >> 16) + 25;
                    char cIndexOf = (char) (TextUtils.indexOf("", "") + 30068);
                    int iRed = 816 - Color.red(0);
                    Object[] objArr46 = new Object[1];
                    b((byte) 47, $$a[98], (byte) 57, objArr46);
                    objAccessartificialFrame30 = ArtificialStackFrames.coroutineCreation(pressedStateDuration2, cIndexOf, iRed, 891606461, false, (String) objArr46[0], null);
                }
                ((Field) objAccessartificialFrame30).set(null, objArr3);
                try {
                    Long lValueOf5 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame31 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                    if (objAccessartificialFrame31 == null) {
                        int iIndexOf4 = TextUtils.indexOf("", "", 0) + 25;
                        char offsetBefore = (char) (TextUtils.getOffsetBefore("", 0) + 30068);
                        int packedPositionChild = ExpandableListView.getPackedPositionChild(0L) + 817;
                        byte[] bArr16 = $$a;
                        Object[] objArr47 = new Object[1];
                        b((byte) 47, bArr16[98], bArr16[81], objArr47);
                        objAccessartificialFrame31 = ArtificialStackFrames.coroutineCreation(iIndexOf4, offsetBefore, packedPositionChild, 721586079, false, (String) objArr47[0], null);
                    }
                    ((Field) objAccessartificialFrame31).set(null, lValueOf5);
                } catch (Exception unused3) {
                    throw new RuntimeException();
                }
            } catch (Throwable th3) {
                Throwable cause3 = th3.getCause();
                if (cause3 == null) {
                    throw th3;
                }
                throw cause3;
            }
        } else {
            Object objAccessartificialFrame32 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame32 == null) {
                int iResolveOpacity = Drawable.resolveOpacity(0, 0) + 25;
                char minimumFlingVelocity2 = (char) (30068 - (ViewConfiguration.getMinimumFlingVelocity() >> 16));
                int deadChar2 = KeyEvent.getDeadChar(0, 0) + 816;
                Object[] objArr48 = new Object[1];
                b((byte) 47, $$a[98], (byte) 57, objArr48);
                objAccessartificialFrame32 = ArtificialStackFrames.coroutineCreation(iResolveOpacity, minimumFlingVelocity2, deadChar2, 891606461, false, (String) objArr48[0], null);
            }
            Object[] objArr49 = (Object[]) ((Field) objAccessartificialFrame32).get(null);
            objArr3 = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i77 = ((int[]) objArr49[0])[0];
            int i78 = ((int[]) objArr49[1])[0];
            String[] strArr3 = (String[]) objArr49[2];
            int i79 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().keyboardHidden;
            int i80 = (((155389405 + (((~((-24791) | (~i79))) | (~(198147575 | i79))) * (-272))) + (((~((-193749464) | i79)) | 193724673) * (-272))) + (((~(i79 | 193749463)) | 4422902) * 272)) - 1957696735;
            int i81 = (i80 << 13) ^ i80;
            int i82 = i81 ^ (i81 >>> 17);
            ((int[]) objArr3[3])[0] = i82 ^ (i82 << 5);
        }
        int i83 = ((int[]) objArr3[1])[0];
        int i84 = ((int[]) objArr3[0])[0];
        if (i84 == i83) {
            Object[] objArr50 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i85 = ((int[]) objArr3[3])[0];
            int i86 = ((int[]) objArr3[0])[0];
            int i87 = ((int[]) objArr3[1])[0];
            String[] strArr4 = (String[]) objArr3[2];
            int iIdentityHashCode5 = System.identityHashCode(this);
            int i88 = i85 + (((~((~iIdentityHashCode5) | 251588575)) * 130) - 1648109317) + (((~(iIdentityHashCode5 | 251588575)) | 34523273) * 130);
            int i89 = (i88 << 13) ^ i88;
            int i90 = i89 ^ (i89 >>> 17);
            i2 = 0;
            ((int[]) objArr50[3])[0] = i90 ^ (i90 << 5);
        } else {
            ArrayList arrayList3 = new ArrayList();
            String[] strArr5 = (String[]) objArr3[2];
            if (strArr5 != null) {
                for (String str5 : strArr5) {
                    arrayList3.add(str5);
                }
            }
            long j8 = ((long) (i83 ^ i84)) ^ (((long) 1774464365) << 32);
            long j9 = 1774464364;
            int i91 = getARTIFICIAL_FRAME_PACKAGE_NAME + 27;
            artificialFrame = i91 % 128;
            int i92 = i91 % 2;
            Object[] objArr51 = {Long.valueOf(j8), Long.valueOf(j9)};
            byte[] bArr17 = $$d;
            byte b7 = bArr17[172];
            byte b8 = bArr17[14];
            Object[] objArr52 = new Object[1];
            c(b7, b8, (short) (b8 | Ascii.FF), objArr52);
            Class<?> cls8 = Class.forName((String) objArr52[0]);
            byte b9 = bArr17[118];
            Object[] objArr53 = new Object[1];
            c(b9, (byte) (b9 + 4), (short) ($$e + 5), objArr53);
            cls8.getMethod((String) objArr53[0], Long.TYPE, Long.TYPE).invoke(null, objArr51);
            Object[] objArr54 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i93 = ((int[]) objArr3[3])[0];
            int i94 = ((int[]) objArr3[0])[0];
            int i95 = ((int[]) objArr3[1])[0];
            String[] strArr6 = (String[]) objArr3[2];
            int i96 = (int) Runtime.getRuntime().totalMemory();
            int i97 = (-1274958501) + (((-879763795) | i96) * 614);
            int i98 = ~i96;
            int i99 = i93 + i97 + (((~((-723944502) | i98)) | 184976421 | (~((-525772136) | i98))) * (-1228)) + (((~(i98 | (-340795715))) | (~((-538968081) | i98))) * 614);
            int i100 = (i99 << 13) ^ i99;
            int i101 = i100 ^ (i100 >>> 17);
            i2 = 0;
            ((int[]) objArr54[3])[0] = i101 ^ (i101 << 5);
        }
        Object objAccessartificialFrame33 = ArtificialStackFrames.accessartificialFrame(-1168947751);
        if (objAccessartificialFrame33 == null) {
            int pressedStateDuration3 = (ViewConfiguration.getPressedStateDuration() >> 16) + 36;
            char bitsPerPixel2 = (char) (ImageFormat.getBitsPerPixel(i2) + 1);
            int iMakeMeasureSpec = 540 - View.MeasureSpec.makeMeasureSpec(i2, i2);
            byte[] bArr18 = $$a;
            Object[] objArr55 = new Object[1];
            b((byte) 47, bArr18[98], bArr18[81], objArr55);
            objAccessartificialFrame33 = ArtificialStackFrames.coroutineCreation(pressedStateDuration3, bitsPerPixel2, iMakeMeasureSpec, 624296913, false, (String) objArr55[0], null);
        }
        long j10 = ((Field) objAccessartificialFrame33).getLong(null);
        try {
            if (j10 != -1) {
                i3 = 0;
                if (j10 + 1860 >= ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                    Object objAccessartificialFrame34 = ArtificialStackFrames.accessartificialFrame(-1339222025);
                    if (objAccessartificialFrame34 == null) {
                        int size2 = 36 - View.MeasureSpec.getSize(0);
                        char packedPositionGroup = (char) ExpandableListView.getPackedPositionGroup(0L);
                        int iResolveSize = View.resolveSize(0, 0) + 540;
                        Object[] objArr56 = new Object[1];
                        b((byte) 47, $$a[98], (byte) 57, objArr56);
                        objAccessartificialFrame34 = ArtificialStackFrames.coroutineCreation(size2, packedPositionGroup, iResolveSize, 793268735, false, (String) objArr56[0], null);
                    }
                    Object[] objArr57 = (Object[]) ((Field) objAccessartificialFrame34).get(null);
                    objArr4 = new Object[]{new int[1], new int[1], new int[1]};
                    int i102 = ((int[]) objArr57[2])[0];
                    int i103 = ((int[]) objArr57[1])[0];
                    ((int[]) objArr4[2])[0] = i102;
                    ((int[]) objArr4[1])[0] = i103;
                    int iIdentityHashCode6 = System.identityHashCode(this);
                    int i104 = (((-176256865) + (((~((~iIdentityHashCode6) | (-306052950))) | 303045888) * 446)) + (((~(iIdentityHashCode6 | (-3007062))) | 742522912) * 446)) - 1116396815;
                    int i105 = (i104 << 13) ^ i104;
                    int i106 = i105 ^ (i105 >>> 17);
                    ((int[]) objArr4[0])[0] = i106 ^ (i106 << 5);
                }
                obj = objArr4[1];
                i4 = ((int[]) obj)[0];
                obj2 = objArr4[2];
                i5 = ((int[]) obj2)[0];
                if (i5 == i4) {
                    Object[] objArr58 = {new int[1], new int[1], new int[1]};
                    int i107 = ((int[]) objArr4[0])[0];
                    int i108 = ((int[]) obj2)[0];
                    int i109 = ((int[]) obj)[0];
                    ((int[]) objArr58[2])[0] = i108;
                    ((int[]) objArr58[1])[0] = i109;
                    int length = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 1730311089;
                    int i110 = 1918586679 + ((length | 466732159) * (-50));
                    int i111 = ~((-277890167) | length);
                    int i112 = ~length;
                    int i113 = i107 + i110 + ((i111 | (~((-606999425) | i112))) * 50) + (((~(i112 | 466732159)) | (~((-884889591) | i112)) | 606999424) * 50);
                    int i114 = (i113 << 13) ^ i113;
                    int i115 = i114 ^ (i114 >>> 17);
                    ((int[]) objArr58[0])[0] = i115 ^ (i115 << 5);
                    i6 = 0;
                } else {
                    Object[] objArr59 = {Long.valueOf((((long) (-1510256497)) << 32) ^ ((long) (i4 ^ i5))), Long.valueOf(-1510260593)};
                    byte[] bArr19 = $$d;
                    byte b10 = bArr19[172];
                    byte b11 = bArr19[64];
                    Object[] objArr60 = new Object[1];
                    c(b10, b11, (short) (b11 | 80), objArr60);
                    Class<?> cls9 = Class.forName((String) objArr60[0]);
                    byte b12 = bArr19[118];
                    Object[] objArr61 = new Object[1];
                    c(b12, (byte) (b12 + 4), (short) ($$e + 5), objArr61);
                    cls9.getMethod((String) objArr61[0], Long.TYPE, Long.TYPE).invoke(null, objArr59);
                    Object[] objArr62 = {new int[1], new int[1], new int[1]};
                    int i116 = ((int[]) objArr4[0])[0];
                    int i117 = ((int[]) objArr4[2])[0];
                    int i118 = ((int[]) objArr4[1])[0];
                    ((int[]) objArr62[2])[0] = i117;
                    ((int[]) objArr62[1])[0] = i118;
                    int i119 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getDisplayMetrics().densityDpi;
                    int i120 = i116 + (-828352127) + (((~(i119 | 1266002740)) | 85619009) * 191) + (((~((~i119) | 1266002740)) | 67784769) * 191);
                    int i121 = (i120 << 13) ^ i120;
                    int i122 = i121 ^ (i121 >>> 17);
                    i6 = 0;
                    ((int[]) objArr62[0])[0] = i122 ^ (i122 << 5);
                }
                objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(1313006081);
                if (objAccessartificialFrame3 == null) {
                    int keyRepeatDelay3 = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 21;
                    char cGreen = (char) Color.green(i6);
                    int threadPriority3 = ((Process.getThreadPriority(i6) + 20) >> 6) + 465;
                    byte[] bArr20 = $$a;
                    Object[] objArr63 = new Object[1];
                    b((byte) 47, bArr20[98], bArr20[81], objArr63);
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(keyRepeatDelay3, cGreen, threadPriority3, -785931255, false, (String) objArr63[0], null);
                }
                j = ((Field) objAccessartificialFrame3).getLong(null);
                if (j != -1) {
                    if (j + 1855 >= ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                        objAccessartificialFrame21 = ArtificialStackFrames.accessartificialFrame(1142731807);
                        if (objAccessartificialFrame21 == null) {
                            int iLastIndexOf = TextUtils.lastIndexOf("", '0', 0, 0) + 22;
                            char cAxisFromString = (char) ((-1) - MotionEvent.axisFromString(""));
                            int gidForName = Process.getGidForName("") + 466;
                            Object[] objArr64 = new Object[1];
                            b((byte) 47, $$a[98], (byte) 57, objArr64);
                            objAccessartificialFrame21 = ArtificialStackFrames.coroutineCreation(iLastIndexOf, cAxisFromString, gidForName, -612765161, false, (String) objArr64[0], null);
                        }
                        Object[] objArr65 = (Object[]) ((Field) objAccessartificialFrame21).get(null);
                        objArr5 = new Object[]{new int[]{i}, strArr, new int[1], new int[]{i}};
                        int i123 = ((int[]) objArr65[3])[0];
                        int i124 = ((int[]) objArr65[0])[0];
                        String[] strArr7 = (String[]) objArr65[1];
                        int startElapsedRealtime = (int) Process.getStartElapsedRealtime();
                        int i125 = ~startElapsedRealtime;
                        int i126 = 767584996 + (((~(i125 | 38373607)) | 121976118) * (-1042)) + ((38373607 | startElapsedRealtime) * 521) + (((~(startElapsedRealtime | (-121976119))) | 37814310 | (~(i125 | 122535415))) * 521) + 367240422;
                        int i127 = (i126 << 13) ^ i126;
                        int i128 = i127 ^ (i127 >>> 17);
                        ((int[]) objArr5[2])[0] = i128 ^ (i128 << 5);
                        c = 0;
                    } else {
                        i7 = 0;
                    }
                    i10 = ((int[]) objArr5[c])[c];
                    i11 = ((int[]) objArr5[3])[c];
                    if (i11 == i10) {
                        Object[] objArr66 = new Object[4];
                        int[] iArr = new int[1];
                        objArr66[c] = iArr;
                        objArr66[2] = new int[1];
                        int[] iArr2 = new int[1];
                        objArr66[3] = iArr2;
                        int i129 = ((int[]) objArr5[2])[c];
                        int i130 = ((int[]) objArr5[3])[c];
                        int i131 = ((int[]) objArr5[c])[c];
                        String[] strArr8 = (String[]) objArr5[1];
                        iArr2[c] = i130;
                        iArr[c] = i131;
                        int iNextInt = new Random().nextInt();
                        int i132 = i129 + ((((~(882342990 | iNextInt)) | (-179389987)) * 262) - 1884806911) + (((~((~iNextInt) | 882342990)) | (-179389987)) * 262);
                        int i133 = (i132 << 13) ^ i132;
                        int i134 = i133 ^ (i133 >>> 17);
                        ((int[]) objArr66[2])[0] = i134 ^ (i134 << 5);
                        objArr66[1] = strArr8;
                        i12 = 0;
                    } else {
                        arrayList = new ArrayList();
                        strArr = (String[]) objArr5[1];
                        if (strArr != null) {
                            for (String str6 : strArr) {
                                arrayList.add(str6);
                            }
                        }
                        Object[] objArr67 = {Long.valueOf(((long) (i10 ^ i11)) ^ (((long) 2070308745) << 32)), Long.valueOf(2070308809)};
                        byte[] bArr21 = $$d;
                        Object[] objArr68 = new Object[1];
                        c(bArr21[172], (byte) (-bArr21[663]), (short) TypedValues.CycleType.TYPE_WAVE_PHASE, objArr68);
                        Class<?> cls10 = Class.forName((String) objArr68[0]);
                        byte b13 = bArr21[118];
                        Object[] objArr69 = new Object[1];
                        c(b13, (byte) (b13 + 4), (short) ($$e + 5), objArr69);
                        cls10.getMethod((String) objArr69[0], Long.TYPE, Long.TYPE).invoke(null, objArr67);
                        Object[] objArr70 = {new int[]{i}, strArr, new int[1], new int[]{i}};
                        int i135 = ((int[]) objArr5[2])[0];
                        int i136 = ((int[]) objArr5[3])[0];
                        int i137 = ((int[]) objArr5[0])[0];
                        String[] strArr9 = (String[]) objArr5[1];
                        int iCodePointAt = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(4) - 1538211145;
                        int i138 = ~iCodePointAt;
                        int i139 = i135 + (-1159620387) + (((~((-170065955) | i138)) | (~((-558374914) | iCodePointAt)) | (~(738157095 | iCodePointAt))) * 765) + ((170065954 | (~((-728440868) | i138))) * 1530) + (((~(iCodePointAt | (-728440868))) | (~(i138 | 738157095))) * 765);
                        int i140 = (i139 << 13) ^ i139;
                        int i141 = i140 ^ (i140 >>> 17);
                        i12 = 0;
                        ((int[]) objArr70[2])[0] = i141 ^ (i141 << 5);
                    }
                    objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-444530678);
                    if (objAccessartificialFrame7 == null) {
                        int mode = 26 - View.MeasureSpec.getMode(i12);
                        char cBlue = (char) Color.blue(i12);
                        int i142 = 1042 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1));
                        byte[] bArr22 = $$a;
                        Object[] objArr71 = new Object[1];
                        b((byte) 47, bArr22[98], bArr22[81], objArr71);
                        objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(mode, cBlue, i142, 2061780482, false, (String) objArr71[0], null);
                    }
                    j2 = ((Field) objAccessartificialFrame7).getLong(null);
                    if (j2 != -1) {
                        int i143 = artificialFrame + 43;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i143 % 128;
                        int i144 = i143 % 2;
                        if (j2 + 1911 >= ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                            int i145 = artificialFrame + 123;
                            getARTIFICIAL_FRAME_PACKAGE_NAME = i145 % 128;
                            int i146 = i145 % 2;
                            objAccessartificialFrame20 = ArtificialStackFrames.accessartificialFrame(-614804952);
                            if (objAccessartificialFrame20 == null) {
                                int i147 = (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + 26;
                                char bitsPerPixel3 = (char) ((-1) - ImageFormat.getBitsPerPixel(0));
                                int i148 = 1041 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                                Object[] objArr72 = new Object[1];
                                b((byte) 47, $$a[98], (byte) 57, objArr72);
                                objAccessartificialFrame20 = ArtificialStackFrames.coroutineCreation(i147, bitsPerPixel3, i148, 1145017376, false, (String) objArr72[0], null);
                            }
                            Object[] objArr73 = (Object[]) ((Field) objAccessartificialFrame20).get(null);
                            objArrAccessartificialFrame$78cbbd35 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
                            int i149 = ((int[]) objArr73[3])[0];
                            int i150 = ((int[]) objArr73[2])[0];
                            String[] strArr10 = (String[]) objArr73[0];
                            int i151 = ~((~Process.myPid()) | 1040324035);
                            int i152 = ((((939659456 | i151) * (-374)) + 329575196) + ((i151 | 100664579) * 374)) - 2112554579;
                            int i153 = (i152 << 13) ^ i152;
                            int i154 = i153 ^ (i153 >>> 17);
                            ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0] = i154 ^ (i154 << 5);
                        } else {
                            int iIntValue = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
                            Object[] objArr74 = {716904988};
                            objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-1648942878);
                            if (objAccessartificialFrame8 == null) {
                                objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 8, (char) (22252 - (android.os.SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (android.os.SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1))), 1033 - View.getDefaultSize(0, 0), 47343338, false, null, new Class[]{Integer.TYPE});
                            }
                            objArrAccessartificialFrame$78cbbd35 = CompactHashMap.Itr.accessartificialFrame$78cbbd35(iIntValue, 0, ((Constructor) objAccessartificialFrame8).newInstance(objArr74), -2112554579, false);
                            objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(-614804952);
                            if (objAccessartificialFrame9 == null) {
                                int threadPriority4 = 26 - ((Process.getThreadPriority(0) + 20) >> 6);
                                char doubleTapTimeout2 = (char) (ViewConfiguration.getDoubleTapTimeout() >> 16);
                                int i155 = 1042 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1));
                                Object[] objArr75 = new Object[1];
                                b((byte) 47, $$a[98], (byte) 57, objArr75);
                                objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(threadPriority4, doubleTapTimeout2, i155, 1145017376, false, (String) objArr75[0], null);
                            }
                            ((Field) objAccessartificialFrame9).set(null, objArrAccessartificialFrame$78cbbd35);
                            try {
                                Long lValueOf6 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                                objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-444530678);
                                if (objAccessartificialFrame10 == null) {
                                    int bitsPerPixel4 = 25 - ImageFormat.getBitsPerPixel(0);
                                    char c3 = (char) (1 - (android.os.SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (android.os.SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)));
                                    int iIndexOf5 = TextUtils.indexOf((CharSequence) "", '0') + 1042;
                                    byte[] bArr23 = $$a;
                                    Object[] objArr76 = new Object[1];
                                    b((byte) 47, bArr23[98], bArr23[81], objArr76);
                                    objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(bitsPerPixel4, c3, iIndexOf5, 2061780482, false, (String) objArr76[0], null);
                                }
                                ((Field) objAccessartificialFrame10).set(null, lValueOf6);
                            } catch (Exception unused4) {
                                throw new RuntimeException();
                            }
                        }
                    } else {
                        int iIntValue2 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
                        Object[] objArr77 = {716904988};
                        objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-1648942878);
                        if (objAccessartificialFrame8 == null) {
                            objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 8, (char) (22252 - (android.os.SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (android.os.SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1))), 1033 - View.getDefaultSize(0, 0), 47343338, false, null, new Class[]{Integer.TYPE});
                        }
                        objArrAccessartificialFrame$78cbbd35 = CompactHashMap.Itr.accessartificialFrame$78cbbd35(iIntValue2, 0, ((Constructor) objAccessartificialFrame8).newInstance(objArr77), -2112554579, false);
                        objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(-614804952);
                        if (objAccessartificialFrame9 == null) {
                            int threadPriority5 = 26 - ((Process.getThreadPriority(0) + 20) >> 6);
                            char doubleTapTimeout3 = (char) (ViewConfiguration.getDoubleTapTimeout() >> 16);
                            int i156 = 1042 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1));
                            Object[] objArr78 = new Object[1];
                            b((byte) 47, $$a[98], (byte) 57, objArr78);
                            objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(threadPriority5, doubleTapTimeout3, i156, 1145017376, false, (String) objArr78[0], null);
                        }
                        ((Field) objAccessartificialFrame9).set(null, objArrAccessartificialFrame$78cbbd35);
                        Long lValueOf7 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-444530678);
                        if (objAccessartificialFrame10 == null) {
                            int bitsPerPixel5 = 25 - ImageFormat.getBitsPerPixel(0);
                            char c4 = (char) (1 - (android.os.SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (android.os.SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)));
                            int iIndexOf6 = TextUtils.indexOf((CharSequence) "", '0') + 1042;
                            byte[] bArr24 = $$a;
                            Object[] objArr79 = new Object[1];
                            b((byte) 47, bArr24[98], bArr24[81], objArr79);
                            objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(bitsPerPixel5, c4, iIndexOf6, 2061780482, false, (String) objArr79[0], null);
                        }
                        ((Field) objAccessartificialFrame10).set(null, lValueOf7);
                    }
                    i14 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
                    i15 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
                    if (i15 == i14) {
                        Object[] objArr80 = {strArr, new int[1], new int[]{i}, new int[]{i}};
                        int i157 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
                        int i158 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
                        int i159 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
                        String[] strArr11 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
                        int iCodePointAt2 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(8) - 710381406;
                        int i160 = i157 + (((~((-809797162) | iCodePointAt2)) | 537165864) * (-283)) + 1772187958 + ((~(iCodePointAt2 | (-272631298))) * 283);
                        int i161 = (i160 << 13) ^ i160;
                        int i162 = i161 ^ (i161 >>> 17);
                        ((int[]) objArr80[1])[0] = i162 ^ (i162 << 5);
                        i16 = 0;
                    } else {
                        arrayList2 = new ArrayList();
                        strArr2 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
                        if (strArr2 != null) {
                            for (String str7 : strArr2) {
                                arrayList2.add(str7);
                            }
                        }
                        long j11 = (((long) 936109884) << 32) ^ ((long) (i14 ^ i15));
                        long j12 = 936109886;
                        int i163 = artificialFrame + 3;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i163 % 128;
                        int i164 = i163 % 2;
                        Object[] objArr81 = {Long.valueOf(j11), Long.valueOf(j12)};
                        byte[] bArr25 = $$d;
                        Object[] objArr82 = new Object[1];
                        c(bArr25[14], bArr25[631], (short) 463, objArr82);
                        Class<?> cls11 = Class.forName((String) objArr82[0]);
                        byte b14 = bArr25[118];
                        Object[] objArr83 = new Object[1];
                        c(b14, (byte) (b14 + 4), (short) ($$e + 5), objArr83);
                        cls11.getMethod((String) objArr83[0], Long.TYPE, Long.TYPE).invoke(null, objArr81);
                        Object[] objArr84 = {strArr, new int[1], new int[]{i}, new int[]{i}};
                        int i165 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
                        int i166 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
                        int i167 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
                        String[] strArr12 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
                        int iMyPid = Process.myPid();
                        int i168 = ~iMyPid;
                        int i169 = i165 + (-1549488194) + (((~(i168 | 490861389)) | (~(412757582 | i168)) | (-500957008)) * 464) + (((-88199426) | iMyPid) * (-464)) + (((~(iMyPid | 490861389)) | (-500957008)) * 464);
                        int i170 = (i169 << 13) ^ i169;
                        int i171 = i170 ^ (i170 >>> 17);
                        i16 = 0;
                        ((int[]) objArr84[1])[0] = i171 ^ (i171 << 5);
                    }
                    super.onStart();
                    objAccessartificialFrame11 = ArtificialStackFrames.accessartificialFrame(-2127922582);
                    if (objAccessartificialFrame11 == null) {
                        int packedPositionType3 = ExpandableListView.getPackedPositionType(0L) + 30;
                        char cAlpha = (char) (49362 - Color.alpha(i16));
                        int threadPriority6 = ((Process.getThreadPriority(i16) + 20) >> 6) + 684;
                        byte[] bArr26 = $$a;
                        Object[] objArr85 = new Object[1];
                        b((byte) (bArr26[96] + 1), bArr26[94], (byte) 96, objArr85);
                        objAccessartificialFrame11 = ArtificialStackFrames.coroutineCreation(packedPositionType3, cAlpha, threadPriority6, 508509282, false, (String) objArr85[0], null);
                    }
                    j3 = ((Field) objAccessartificialFrame11).getLong(null);
                    if (j3 != -1) {
                        if (j3 + 1952 >= ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                            objAccessartificialFrame19 = ArtificialStackFrames.accessartificialFrame(777251007);
                            if (objAccessartificialFrame19 == null) {
                                int offsetAfter = TextUtils.getOffsetAfter("", 0) + 30;
                                char cAlpha2 = (char) (Color.alpha(0) + 49362);
                                int i172 = 685 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1));
                                byte[] bArr27 = $$a;
                                Object[] objArr86 = new Object[1];
                                b(bArr27[65], bArr27[23], (byte) AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, objArr86);
                                objAccessartificialFrame19 = ArtificialStackFrames.coroutineCreation(offsetAfter, cAlpha2, i172, -1321816393, false, (String) objArr86[0], null);
                            }
                            Object[] objArr87 = (Object[]) ((Field) objAccessartificialFrame19).get(null);
                            objArr6 = new Object[]{new int[]{((int[]) objArr87[0])[0]}, new int[]{((int[]) objArr87[1])[0]}, new int[1], (String) objArr87[3]};
                            int i173 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 31408613;
                            int i174 = ~i173;
                            int i175 = ((((-596835844) + (((~((-61749173) | i174)) | 33690768) * (-108))) + (((~(i174 | 1040372947)) | ((~((-1040372948) | i173)) | (-1068431352))) * 54)) + ((i173 | (-1068431352)) * 54)) - 1026999532;
                            int i176 = (i175 << 13) ^ i175;
                            int i177 = i176 ^ (i176 >>> 17);
                            ((int[]) objArr6[2])[0] = i177 ^ (i177 << 5);
                        } else {
                            i18 = 0;
                        }
                        i19 = ((int[]) objArr6[1])[0];
                        i20 = ((int[]) objArr6[0])[0];
                        if (i20 == i19) {
                            int i178 = getARTIFICIAL_FRAME_PACKAGE_NAME + 37;
                            artificialFrame = i178 % 128;
                            int i179 = i178 % 2;
                            int i180 = ((int[]) objArr6[2])[0];
                            Object[] objArr88 = {new int[]{((int[]) objArr6[0])[0]}, new int[]{((int[]) objArr6[1])[0]}, new int[1], (String) objArr6[3]};
                            int mode2 = ((AudioManager) ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getSystemService("audio")).getMode();
                            int i181 = ~mode2;
                            int i182 = ~((-255395344) | i181);
                            int i183 = ~((-723228432) | mode2);
                            int i184 = i180 + 910669500 + ((i182 | i183) * 1150) + (((~(723228431 | i181)) | i183) * (-575)) + (((~(mode2 | (-255395344))) | (~(i181 | 255395343))) * 575);
                            int i185 = (i184 << 13) ^ i184;
                            int i186 = i185 ^ (i185 >>> 17);
                            ((int[]) objArr88[2])[0] = i186 ^ (i186 << 5);
                            i21 = 0;
                        } else {
                            Object[] objArr89 = {Long.valueOf(((long) (i19 ^ i20)) ^ (((long) (-1295343820)) << 32)), Long.valueOf(-1295344332)};
                            byte[] bArr28 = $$d;
                            byte b15 = bArr28[172];
                            byte b16 = bArr28[64];
                            Object[] objArr90 = new Object[1];
                            c(b15, b16, (short) (b16 | 80), objArr90);
                            Class<?> cls12 = Class.forName((String) objArr90[0]);
                            byte b17 = bArr28[118];
                            Object[] objArr91 = new Object[1];
                            c(b17, (byte) (b17 + 4), (short) ($$e + 5), objArr91);
                            cls12.getMethod((String) objArr91[0], Long.TYPE, Long.TYPE).invoke(null, objArr89);
                            int i187 = ((int[]) objArr6[2])[0];
                            Object[] objArr92 = {new int[]{((int[]) objArr6[0])[0]}, new int[]{((int[]) objArr6[1])[0]}, new int[1], (String) objArr6[3]};
                            int iNextInt2 = new Random().nextInt(373309157);
                            int i188 = i187 + (-452072299) + (((~(iNextInt2 | 797858843)) | (-180764932)) * (-465)) + ((797858843 | (~((-180764932) | iNextInt2))) * 930) + ((iNextInt2 | (-4194561)) * 465);
                            int i189 = (i188 << 13) ^ i188;
                            int i190 = i189 ^ (i189 >>> 17);
                            i21 = 0;
                            ((int[]) objArr92[2])[0] = i190 ^ (i190 << 5);
                        }
                        objAccessartificialFrame14 = ArtificialStackFrames.accessartificialFrame(1745676544);
                        if (objAccessartificialFrame14 == null) {
                            int iResolveSizeAndState = 17 - View.resolveSizeAndState(i21, i21, i21);
                            char windowTouchSlop = (char) (ViewConfiguration.getWindowTouchSlop() >> 8);
                            int i191 = 748 - (android.os.SystemClock.uptimeMillis() > 0L ? 1 : (android.os.SystemClock.uptimeMillis() == 0L ? 0 : -1));
                            byte[] bArr29 = $$a;
                            Object[] objArr93 = new Object[1];
                            b((byte) 47, bArr29[98], bArr29[81], objArr93);
                            objAccessartificialFrame14 = ArtificialStackFrames.coroutineCreation(iResolveSizeAndState, windowTouchSlop, i191, -144068856, false, (String) objArr93[0], null);
                        }
                        j4 = ((Field) objAccessartificialFrame14).getLong(null);
                        if (j4 != -1 || j4 + 2027 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                            baseContext4 = getBaseContext();
                            if (baseContext4 == null) {
                                Object[] objArr94 = new Object[1];
                                a(27764 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), new char[]{55918, 46610, 653, 40740, 27564, 50265, 20697, 11524, 47606, 2676, 58881, 29392, 53034, 23483, 13361, 32987, 7497, 59845, 31341, 55039, 41639, 16136, 35743, 25663, 61606, 19792}, objArr94);
                                Class<?> cls13 = Class.forName((String) objArr94[0]);
                                Object[] objArr95 = new Object[1];
                                a(TextUtils.indexOf("", "") + 53441, new char[]{55916, 2747, 31743, 43070, 39278, 51620, 16125, 28425, 23671, 36022, 65001, 8749, 4960, 17315, 45301, 57641, 54896, 1712}, objArr95);
                                baseContext4 = (Context) cls13.getMethod((String) objArr95[0], new Class[0]).invoke(null, null);
                            }
                            if (baseContext4 != null) {
                                if ((baseContext4 instanceof ContextWrapper) || ((ContextWrapper) baseContext4).getBaseContext() != null) {
                                    baseContext4 = baseContext4.getApplicationContext();
                                } else {
                                    baseContext4 = null;
                                }
                            }
                            Object[] objArr96 = {baseContext4, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 1378671210};
                            byte[] bArr30 = $$d;
                            Object[] objArr97 = new Object[1];
                            c(bArr30[172], bArr30[530], (short) 540, objArr97);
                            Class<?> cls14 = Class.forName((String) objArr97[0]);
                            byte b18 = (byte) (bArr30[99] - 1);
                            Object[] objArr98 = new Object[1];
                            c(b18, (byte) (b18 | Ascii.DC2), (short) (-bArr30[500]), objArr98);
                            objArr7 = (Object[]) cls14.getMethod((String) objArr98[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr96);
                            objAccessartificialFrame15 = ArtificialStackFrames.accessartificialFrame(1575402270);
                            if (objAccessartificialFrame15 == null) {
                                int threadPriority7 = 17 - ((Process.getThreadPriority(0) + 20) >> 6);
                                char cIndexOf2 = (char) TextUtils.indexOf("", "", 0);
                                int iIndexOf7 = 746 - TextUtils.indexOf((CharSequence) "", '0');
                                Object[] objArr99 = new Object[1];
                                b((byte) 47, $$a[98], (byte) 57, objArr99);
                                objAccessartificialFrame15 = ArtificialStackFrames.coroutineCreation(threadPriority7, cIndexOf2, iIndexOf7, -1031537386, false, (String) objArr99[0], null);
                            }
                            ((Field) objAccessartificialFrame15).set(null, objArr7);
                            try {
                                Long lValueOf8 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                                objAccessartificialFrame16 = ArtificialStackFrames.accessartificialFrame(1745676544);
                                if (objAccessartificialFrame16 == null) {
                                    int i192 = 17 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                                    char c5 = (char) (1 - (android.os.SystemClock.elapsedRealtime() > 0L ? 1 : (android.os.SystemClock.elapsedRealtime() == 0L ? 0 : -1)));
                                    int i193 = (android.os.SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (android.os.SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 746;
                                    byte[] bArr31 = $$a;
                                    Object[] objArr100 = new Object[1];
                                    b((byte) 47, bArr31[98], bArr31[81], objArr100);
                                    objAccessartificialFrame16 = ArtificialStackFrames.coroutineCreation(i192, c5, i193, -144068856, false, (String) objArr100[0], null);
                                }
                                ((Field) objAccessartificialFrame16).set(null, lValueOf8);
                            } catch (Exception unused5) {
                                throw new RuntimeException();
                            }
                        } else {
                            Object objAccessartificialFrame35 = ArtificialStackFrames.accessartificialFrame(1575402270);
                            if (objAccessartificialFrame35 == null) {
                                int offsetBefore2 = 17 - TextUtils.getOffsetBefore("", 0);
                                char c6 = (char) ((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) - 1);
                                int i194 = (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 747;
                                Object[] objArr101 = new Object[1];
                                b((byte) 47, $$a[98], (byte) 57, objArr101);
                                objAccessartificialFrame35 = ArtificialStackFrames.coroutineCreation(offsetBefore2, c6, i194, -1031537386, false, (String) objArr101[0], null);
                            }
                            Object[] objArr102 = (Object[]) ((Field) objAccessartificialFrame35).get(null);
                            objArr7 = new Object[]{list, new int[1], list, new int[]{i}, new int[]{i}};
                            int i195 = ((int[]) objArr102[3])[0];
                            int i196 = ((int[]) objArr102[4])[0];
                            List list = (List) objArr102[0];
                            List list2 = (List) objArr102[2];
                            int i197 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().screenHeightDp;
                            int i198 = 1558326695 + (((~i197) | 606777102) * 1444) + (((~(i197 | (-324756243))) | (~(930204700 | i197)) | 664322) * (-1444)) + 1372267036;
                            int i199 = (i198 << 13) ^ i198;
                            int i200 = i199 ^ (i199 >>> 17);
                            ((int[]) objArr7[1])[0] = i200 ^ (i200 << 5);
                        }
                        i22 = ((int[]) objArr7[4])[0];
                        i23 = ((int[]) objArr7[3])[0];
                        if (i23 == i22) {
                            int i201 = artificialFrame + 123;
                            getARTIFICIAL_FRAME_PACKAGE_NAME = i201 % 128;
                            int i202 = i201 % 2;
                            Object[] objArr103 = {list, new int[1], list, new int[]{i}, new int[]{i}};
                            int i203 = ((int[]) objArr7[1])[0];
                            int i204 = ((int[]) objArr7[3])[0];
                            int i205 = ((int[]) objArr7[4])[0];
                            List list3 = (List) objArr7[0];
                            List list4 = (List) objArr7[2];
                            int i206 = ~((~Process.myUid()) | 96621351);
                            int i207 = i203 + (((25313797 | i206) * (-970)) - 1058822873) + ((i206 | 71307554) * 970);
                            int i208 = (i207 << 13) ^ i207;
                            int i209 = i208 ^ (i208 >>> 17);
                            ((int[]) objArr103[1])[0] = i209 ^ (i209 << 5);
                            return;
                        }
                        ArrayList arrayList4 = new ArrayList();
                        Object[] objArr104 = {objArr7};
                        objAccessartificialFrame17 = ArtificialStackFrames.accessartificialFrame(1804664566);
                        if (objAccessartificialFrame17 == null) {
                            objAccessartificialFrame17 = ArtificialStackFrames.coroutineCreation(40 - MotionEvent.axisFromString(""), (char) ((Process.myTid() >> 22) + 12468), View.getDefaultSize(0, 0) + 3642, -185222914, false, "coroutineCreation", new Class[]{Object[].class});
                        }
                        arrayList4.add(((Method) objAccessartificialFrame17).invoke(null, objArr104));
                        Object[] objArr105 = {objArr7};
                        objAccessartificialFrame18 = ArtificialStackFrames.accessartificialFrame(-1243809191);
                        if (objAccessartificialFrame18 == null) {
                            objAccessartificialFrame18 = ArtificialStackFrames.coroutineCreation(42 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 12467), TextUtils.indexOf((CharSequence) "", '0', 0) + 3643, 716815441, false, "ArtificialStackFrames", new Class[]{Object[].class});
                        }
                        arrayList4.add(((Method) objAccessartificialFrame18).invoke(null, objArr105));
                        Object[] objArr106 = {Long.valueOf((((long) (-1097680825)) << 32) ^ ((long) (i22 ^ i23))), Long.valueOf(-1097680817)};
                        byte[] bArr32 = $$d;
                        byte b19 = bArr32[172];
                        byte b20 = bArr32[87];
                        Object[] objArr107 = new Object[1];
                        c(b19, b20, (short) (b20 | 578), objArr107);
                        Class<?> cls15 = Class.forName((String) objArr107[0]);
                        byte b21 = bArr32[118];
                        Object[] objArr108 = new Object[1];
                        c(b21, (byte) (b21 + 4), (short) ($$e + 5), objArr108);
                        cls15.getMethod((String) objArr108[0], Long.TYPE, Long.TYPE).invoke(null, objArr106);
                        Object[] objArr109 = {list, new int[1], list, new int[]{i}, new int[]{i}};
                        int i210 = ((int[]) objArr7[1])[0];
                        int i211 = ((int[]) objArr7[3])[0];
                        int i212 = ((int[]) objArr7[4])[0];
                        List list5 = (List) objArr7[0];
                        List list6 = (List) objArr7[2];
                        int length2 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 682201691;
                        int i213 = ~length2;
                        int i214 = i210 + (((~(41798803 | i213)) | (~((-647247262) | length2)) | (~(i213 | 647247261))) * 959) + 1742647508 + (((~(length2 | 647247261)) | (~(i213 | (-647247262))) | (~(41798803 | length2))) * 959);
                        int i215 = (i214 << 13) ^ i214;
                        int i216 = i215 ^ (i215 >>> 17);
                        ((int[]) objArr109[1])[0] = i216 ^ (i216 << 5);
                        return;
                    }
                    i18 = 0;
                    baseContext3 = getBaseContext();
                    if (baseContext3 == null) {
                        Object[] objArr115 = new Object[1];
                        a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[i18]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(i18, 4).codePointAt(3) + 27648, new char[]{55918, 46610, 653, 40740, 27564, 50265, 20697, 11524, 47606, 2676, 58881, 29392, 53034, 23483, 13361, 32987, 7497, 59845, 31341, 55039, 41639, 16136, 35743, 25663, 61606, 19792}, objArr115);
                        Class<?> cls16 = Class.forName((String) objArr115[i18]);
                        Object[] objArr116 = new Object[1];
                        a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[i18]).invoke(null, null)).getApplicationContext().getPackageName().length() + 53420, new char[]{55916, 2747, 31743, 43070, 39278, 51620, 16125, 28425, 23671, 36022, 65001, 8749, 4960, 17315, 45301, 57641, 54896, 1712}, objArr116);
                        baseContext3 = (Context) cls16.getMethod((String) objArr116[0], new Class[0]).invoke(null, null);
                    }
                    if (baseContext3 != null) {
                        if (baseContext3 instanceof ContextWrapper) {
                            int i217 = artificialFrame + 51;
                            getARTIFICIAL_FRAME_PACKAGE_NAME = i217 % 128;
                            int i218 = i217 % 2;
                            if (((ContextWrapper) baseContext3).getBaseContext() != null) {
                                baseContext3 = baseContext3.getApplicationContext();
                            } else {
                                baseContext3 = null;
                            }
                        } else {
                            baseContext3 = baseContext3.getApplicationContext();
                        }
                    }
                    Object[] objArr117 = {baseContext3, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), -1026999532};
                    byte[] bArr33 = $$d;
                    Object[] objArr118 = new Object[1];
                    c(bArr33[9], bArr33[128], (short) TypedValues.PositionType.TYPE_PERCENT_X, objArr118);
                    Class<?> cls17 = Class.forName((String) objArr118[0]);
                    Object[] objArr119 = new Object[1];
                    c(bArr33[218], bArr33[171], (short) 405, objArr119);
                    objArr6 = (Object[]) cls17.getMethod((String) objArr119[0], Context.class, Integer.TYPE, Integer.TYPE).invoke(null, objArr117);
                    if (baseContext3 != null) {
                        objAccessartificialFrame12 = ArtificialStackFrames.accessartificialFrame(777251007);
                        if (objAccessartificialFrame12 == null) {
                            int iRed2 = 30 - Color.red(0);
                            char deadChar3 = (char) (KeyEvent.getDeadChar(0, 0) + 49362);
                            int iArgb = Color.argb(0, 0, 0, 0) + 684;
                            byte[] bArr34 = $$a;
                            Object[] objArr120 = new Object[1];
                            b(bArr34[65], bArr34[23], (byte) AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, objArr120);
                            objAccessartificialFrame12 = ArtificialStackFrames.coroutineCreation(iRed2, deadChar3, iArgb, -1321816393, false, (String) objArr120[0], null);
                        }
                        ((Field) objAccessartificialFrame12).set(null, objArr6);
                        try {
                            Long lValueOf9 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                            objAccessartificialFrame13 = ArtificialStackFrames.accessartificialFrame(-2127922582);
                            if (objAccessartificialFrame13 == null) {
                                int i219 = (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 29;
                                char c7 = (char) (49361 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)));
                                int iRed3 = 684 - Color.red(0);
                                byte[] bArr35 = $$a;
                                Object[] objArr121 = new Object[1];
                                b((byte) (bArr35[96] + 1), bArr35[94], (byte) 96, objArr121);
                                objAccessartificialFrame13 = ArtificialStackFrames.coroutineCreation(i219, c7, iRed3, 508509282, false, (String) objArr121[0], null);
                            }
                            ((Field) objAccessartificialFrame13).set(null, lValueOf9);
                        } catch (Exception unused6) {
                            throw new RuntimeException();
                        }
                    }
                    i19 = ((int[]) objArr6[1])[0];
                    i20 = ((int[]) objArr6[0])[0];
                    if (i20 == i19) {
                        int i1710 = getARTIFICIAL_FRAME_PACKAGE_NAME + 37;
                        artificialFrame = i1710 % 128;
                        int i1711 = i1710 % 2;
                        int i1810 = ((int[]) objArr6[2])[0];
                        Object[] objArr810 = {new int[]{((int[]) objArr6[0])[0]}, new int[]{((int[]) objArr6[1])[0]}, new int[1], (String) objArr6[3]};
                        int mode3 = ((AudioManager) ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getSystemService("audio")).getMode();
                        int i1811 = ~mode3;
                        int i1812 = ~((-255395344) | i1811);
                        int i1813 = ~((-723228432) | mode3);
                        int i1814 = i1810 + 910669500 + ((i1812 | i1813) * 1150) + (((~(723228431 | i1811)) | i1813) * (-575)) + (((~(mode3 | (-255395344))) | (~(i1811 | 255395343))) * 575);
                        int i1815 = (i1814 << 13) ^ i1814;
                        int i1816 = i1815 ^ (i1815 >>> 17);
                        ((int[]) objArr810[2])[0] = i1816 ^ (i1816 << 5);
                        i21 = 0;
                    } else {
                        Object[] objArr811 = {Long.valueOf(((long) (i19 ^ i20)) ^ (((long) (-1295343820)) << 32)), Long.valueOf(-1295344332)};
                        byte[] bArr210 = $$d;
                        byte b110 = bArr210[172];
                        byte b111 = bArr210[64];
                        Object[] objArr910 = new Object[1];
                        c(b110, b111, (short) (b111 | 80), objArr910);
                        Class<?> cls18 = Class.forName((String) objArr910[0]);
                        byte b112 = bArr210[118];
                        Object[] objArr911 = new Object[1];
                        c(b112, (byte) (b112 + 4), (short) ($$e + 5), objArr911);
                        cls18.getMethod((String) objArr911[0], Long.TYPE, Long.TYPE).invoke(null, objArr811);
                        int i1817 = ((int[]) objArr6[2])[0];
                        Object[] objArr912 = {new int[]{((int[]) objArr6[0])[0]}, new int[]{((int[]) objArr6[1])[0]}, new int[1], (String) objArr6[3]};
                        int iNextInt3 = new Random().nextInt(373309157);
                        int i1818 = i1817 + (-452072299) + (((~(iNextInt3 | 797858843)) | (-180764932)) * (-465)) + ((797858843 | (~((-180764932) | iNextInt3))) * 930) + ((iNextInt3 | (-4194561)) * 465);
                        int i1819 = (i1818 << 13) ^ i1818;
                        int i1910 = i1819 ^ (i1819 >>> 17);
                        i21 = 0;
                        ((int[]) objArr912[2])[0] = i1910 ^ (i1910 << 5);
                    }
                    objAccessartificialFrame14 = ArtificialStackFrames.accessartificialFrame(1745676544);
                    if (objAccessartificialFrame14 == null) {
                        int iResolveSizeAndState2 = 17 - View.resolveSizeAndState(i21, i21, i21);
                        char windowTouchSlop2 = (char) (ViewConfiguration.getWindowTouchSlop() >> 8);
                        int i1911 = 748 - (android.os.SystemClock.uptimeMillis() > 0L ? 1 : (android.os.SystemClock.uptimeMillis() == 0L ? 0 : -1));
                        byte[] bArr211 = $$a;
                        Object[] objArr913 = new Object[1];
                        b((byte) 47, bArr211[98], bArr211[81], objArr913);
                        objAccessartificialFrame14 = ArtificialStackFrames.coroutineCreation(iResolveSizeAndState2, windowTouchSlop2, i1911, -144068856, false, (String) objArr913[0], null);
                    }
                    j4 = ((Field) objAccessartificialFrame14).getLong(null);
                    if (j4 != -1) {
                        baseContext4 = getBaseContext();
                        if (baseContext4 == null) {
                            Object[] objArr914 = new Object[1];
                            a(27764 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), new char[]{55918, 46610, 653, 40740, 27564, 50265, 20697, 11524, 47606, 2676, 58881, 29392, 53034, 23483, 13361, 32987, 7497, 59845, 31341, 55039, 41639, 16136, 35743, 25663, 61606, 19792}, objArr914);
                            Class<?> cls19 = Class.forName((String) objArr914[0]);
                            Object[] objArr915 = new Object[1];
                            a(TextUtils.indexOf("", "") + 53441, new char[]{55916, 2747, 31743, 43070, 39278, 51620, 16125, 28425, 23671, 36022, 65001, 8749, 4960, 17315, 45301, 57641, 54896, 1712}, objArr915);
                            baseContext4 = (Context) cls19.getMethod((String) objArr915[0], new Class[0]).invoke(null, null);
                        }
                        if (baseContext4 != null) {
                            if (baseContext4 instanceof ContextWrapper) {
                                baseContext4 = baseContext4.getApplicationContext();
                            } else {
                                baseContext4 = baseContext4.getApplicationContext();
                            }
                        }
                        Object[] objArr916 = {baseContext4, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 1378671210};
                        byte[] bArr36 = $$d;
                        Object[] objArr917 = new Object[1];
                        c(bArr36[172], bArr36[530], (short) 540, objArr917);
                        Class<?> cls110 = Class.forName((String) objArr917[0]);
                        byte b113 = (byte) (bArr36[99] - 1);
                        Object[] objArr918 = new Object[1];
                        c(b113, (byte) (b113 | Ascii.DC2), (short) (-bArr36[500]), objArr918);
                        objArr7 = (Object[]) cls110.getMethod((String) objArr918[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr916);
                        objAccessartificialFrame15 = ArtificialStackFrames.accessartificialFrame(1575402270);
                        if (objAccessartificialFrame15 == null) {
                            int threadPriority8 = 17 - ((Process.getThreadPriority(0) + 20) >> 6);
                            char cIndexOf3 = (char) TextUtils.indexOf("", "", 0);
                            int iIndexOf8 = 746 - TextUtils.indexOf((CharSequence) "", '0');
                            Object[] objArr919 = new Object[1];
                            b((byte) 47, $$a[98], (byte) 57, objArr919);
                            objAccessartificialFrame15 = ArtificialStackFrames.coroutineCreation(threadPriority8, cIndexOf3, iIndexOf8, -1031537386, false, (String) objArr919[0], null);
                        }
                        ((Field) objAccessartificialFrame15).set(null, objArr7);
                        Long lValueOf10 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame16 = ArtificialStackFrames.accessartificialFrame(1745676544);
                        if (objAccessartificialFrame16 == null) {
                            int i1912 = 17 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                            char c8 = (char) (1 - (android.os.SystemClock.elapsedRealtime() > 0L ? 1 : (android.os.SystemClock.elapsedRealtime() == 0L ? 0 : -1)));
                            int i1913 = (android.os.SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (android.os.SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 746;
                            byte[] bArr37 = $$a;
                            Object[] objArr1010 = new Object[1];
                            b((byte) 47, bArr37[98], bArr37[81], objArr1010);
                            objAccessartificialFrame16 = ArtificialStackFrames.coroutineCreation(i1912, c8, i1913, -144068856, false, (String) objArr1010[0], null);
                        }
                        ((Field) objAccessartificialFrame16).set(null, lValueOf10);
                    } else {
                        baseContext4 = getBaseContext();
                        if (baseContext4 == null) {
                            Object[] objArr9110 = new Object[1];
                            a(27764 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), new char[]{55918, 46610, 653, 40740, 27564, 50265, 20697, 11524, 47606, 2676, 58881, 29392, 53034, 23483, 13361, 32987, 7497, 59845, 31341, 55039, 41639, 16136, 35743, 25663, 61606, 19792}, objArr9110);
                            Class<?> cls111 = Class.forName((String) objArr9110[0]);
                            Object[] objArr9111 = new Object[1];
                            a(TextUtils.indexOf("", "") + 53441, new char[]{55916, 2747, 31743, 43070, 39278, 51620, 16125, 28425, 23671, 36022, 65001, 8749, 4960, 17315, 45301, 57641, 54896, 1712}, objArr9111);
                            baseContext4 = (Context) cls111.getMethod((String) objArr9111[0], new Class[0]).invoke(null, null);
                        }
                        if (baseContext4 != null) {
                            if (baseContext4 instanceof ContextWrapper) {
                                baseContext4 = baseContext4.getApplicationContext();
                            } else {
                                baseContext4 = baseContext4.getApplicationContext();
                            }
                        }
                        Object[] objArr9112 = {baseContext4, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 1378671210};
                        byte[] bArr38 = $$d;
                        Object[] objArr9113 = new Object[1];
                        c(bArr38[172], bArr38[530], (short) 540, objArr9113);
                        Class<?> cls112 = Class.forName((String) objArr9113[0]);
                        byte b114 = (byte) (bArr38[99] - 1);
                        Object[] objArr9114 = new Object[1];
                        c(b114, (byte) (b114 | Ascii.DC2), (short) (-bArr38[500]), objArr9114);
                        objArr7 = (Object[]) cls112.getMethod((String) objArr9114[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr9112);
                        objAccessartificialFrame15 = ArtificialStackFrames.accessartificialFrame(1575402270);
                        if (objAccessartificialFrame15 == null) {
                            int threadPriority9 = 17 - ((Process.getThreadPriority(0) + 20) >> 6);
                            char cIndexOf4 = (char) TextUtils.indexOf("", "", 0);
                            int iIndexOf9 = 746 - TextUtils.indexOf((CharSequence) "", '0');
                            Object[] objArr9115 = new Object[1];
                            b((byte) 47, $$a[98], (byte) 57, objArr9115);
                            objAccessartificialFrame15 = ArtificialStackFrames.coroutineCreation(threadPriority9, cIndexOf4, iIndexOf9, -1031537386, false, (String) objArr9115[0], null);
                        }
                        ((Field) objAccessartificialFrame15).set(null, objArr7);
                        Long lValueOf11 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame16 = ArtificialStackFrames.accessartificialFrame(1745676544);
                        if (objAccessartificialFrame16 == null) {
                            int i1914 = 17 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                            char c9 = (char) (1 - (android.os.SystemClock.elapsedRealtime() > 0L ? 1 : (android.os.SystemClock.elapsedRealtime() == 0L ? 0 : -1)));
                            int i1915 = (android.os.SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (android.os.SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 746;
                            byte[] bArr39 = $$a;
                            Object[] objArr1011 = new Object[1];
                            b((byte) 47, bArr39[98], bArr39[81], objArr1011);
                            objAccessartificialFrame16 = ArtificialStackFrames.coroutineCreation(i1914, c9, i1915, -144068856, false, (String) objArr1011[0], null);
                        }
                        ((Field) objAccessartificialFrame16).set(null, lValueOf11);
                    }
                    i22 = ((int[]) objArr7[4])[0];
                    i23 = ((int[]) objArr7[3])[0];
                    if (i23 == i22) {
                        int i2010 = artificialFrame + 123;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i2010 % 128;
                        int i2011 = i2010 % 2;
                        Object[] objArr1012 = {list3, new int[1], list4, new int[]{i204}, new int[]{i205}};
                        int i2012 = ((int[]) objArr7[1])[0];
                        int i2013 = ((int[]) objArr7[3])[0];
                        int i2014 = ((int[]) objArr7[4])[0];
                        List list7 = (List) objArr7[0];
                        List list8 = (List) objArr7[2];
                        int i2015 = ~((~Process.myUid()) | 96621351);
                        int i2016 = i2012 + (((25313797 | i2015) * (-970)) - 1058822873) + ((i2015 | 71307554) * 970);
                        int i2017 = (i2016 << 13) ^ i2016;
                        int i2018 = i2017 ^ (i2017 >>> 17);
                        ((int[]) objArr1012[1])[0] = i2018 ^ (i2018 << 5);
                        return;
                    }
                    ArrayList arrayList5 = new ArrayList();
                    Object[] objArr1013 = {objArr7};
                    objAccessartificialFrame17 = ArtificialStackFrames.accessartificialFrame(1804664566);
                    if (objAccessartificialFrame17 == null) {
                        objAccessartificialFrame17 = ArtificialStackFrames.coroutineCreation(40 - MotionEvent.axisFromString(""), (char) ((Process.myTid() >> 22) + 12468), View.getDefaultSize(0, 0) + 3642, -185222914, false, "coroutineCreation", new Class[]{Object[].class});
                    }
                    arrayList5.add(((Method) objAccessartificialFrame17).invoke(null, objArr1013));
                    Object[] objArr1014 = {objArr7};
                    objAccessartificialFrame18 = ArtificialStackFrames.accessartificialFrame(-1243809191);
                    if (objAccessartificialFrame18 == null) {
                        objAccessartificialFrame18 = ArtificialStackFrames.coroutineCreation(42 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 12467), TextUtils.indexOf((CharSequence) "", '0', 0) + 3643, 716815441, false, "ArtificialStackFrames", new Class[]{Object[].class});
                    }
                    arrayList5.add(((Method) objAccessartificialFrame18).invoke(null, objArr1014));
                    Object[] objArr1015 = {Long.valueOf((((long) (-1097680825)) << 32) ^ ((long) (i22 ^ i23))), Long.valueOf(-1097680817)};
                    byte[] bArr310 = $$d;
                    byte b115 = bArr310[172];
                    byte b22 = bArr310[87];
                    Object[] objArr1016 = new Object[1];
                    c(b115, b22, (short) (b22 | 578), objArr1016);
                    Class<?> cls113 = Class.forName((String) objArr1016[0]);
                    byte b23 = bArr310[118];
                    Object[] objArr1017 = new Object[1];
                    c(b23, (byte) (b23 + 4), (short) ($$e + 5), objArr1017);
                    cls113.getMethod((String) objArr1017[0], Long.TYPE, Long.TYPE).invoke(null, objArr1015);
                    Object[] objArr1018 = {list5, new int[1], list6, new int[]{i211}, new int[]{i212}};
                    int i2110 = ((int[]) objArr7[1])[0];
                    int i2111 = ((int[]) objArr7[3])[0];
                    int i2112 = ((int[]) objArr7[4])[0];
                    List list9 = (List) objArr7[0];
                    List list10 = (List) objArr7[2];
                    int length3 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 682201691;
                    int i2113 = ~length3;
                    int i2114 = i2110 + (((~(41798803 | i2113)) | (~((-647247262) | length3)) | (~(i2113 | 647247261))) * 959) + 1742647508 + (((~(length3 | 647247261)) | (~(i2113 | (-647247262))) | (~(41798803 | length3))) * 959);
                    int i2115 = (i2114 << 13) ^ i2114;
                    int i2116 = i2115 ^ (i2115 >>> 17);
                    ((int[]) objArr1018[1])[0] = i2116 ^ (i2116 << 5);
                    return;
                }
                i7 = 0;
                baseContext2 = getBaseContext();
                if (baseContext2 == null) {
                    Object[] objArr122 = new Object[1];
                    a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[i7]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(i7, 4).codePointAt(i7) + 27726, new char[]{55918, 46610, 653, 40740, 27564, 50265, 20697, 11524, 47606, 2676, 58881, 29392, 53034, 23483, 13361, 32987, 7497, 59845, 31341, 55039, 41639, 16136, 35743, 25663, 61606, 19792}, objArr122);
                    Class<?> cls20 = Class.forName((String) objArr122[i7]);
                    Object[] objArr123 = new Object[1];
                    a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[i7]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(i7, 4).codePointAt(1) + 53392, new char[]{55916, 2747, 31743, 43070, 39278, 51620, 16125, 28425, 23671, 36022, 65001, 8749, 4960, 17315, 45301, 57641, 54896, 1712}, objArr123);
                    baseContext2 = (Context) cls20.getMethod((String) objArr123[i7], new Class[i7]).invoke(null, null);
                }
                if (baseContext2 != null) {
                    if ((!(baseContext2 instanceof ContextWrapper)) && ((ContextWrapper) baseContext2).getBaseContext() == null) {
                        baseContext2 = null;
                    } else {
                        baseContext2 = baseContext2.getApplicationContext();
                    }
                }
                int iIntValue3 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
                Object[] objArr124 = new Object[1];
                a((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 8221, new char[]{55913, 64035, 39426, 47722, 23112, 31483, 6855, 15091, 55940, 64307, 39704, 47953, 23395, 31552, 7073, 15322, 56250, 64390, 38963, 47133, 22654, 30807, 6217, 14578, 55424, 63675, 39118, 47408, 22855, 31102, 6412, 14826, 55753, 63879, 39392, 47516, 24099, 32344, 7800, 15874, 57015, 65225, 40619, 48869, 24267, 32546, 8026, 16236, 57113, 65507, 40900, 49151, 24530, 31802, 7207, 15445, 56423, 64537, 40188, 48325, 23796, 31877, 7533, 15647}, objArr124);
                String str8 = (String) objArr124[0];
                Object[] objArr125 = new Object[1];
                a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 22279, new char[]{55866, 36147, 29820, 57163, 34374, 26974, 53373, 47990, 25190, 54613, 48212, 26388, 52925, 45491, 6385, 50067, 43660, 7554, 50424, 44987, 5810, 63886, 41160, 2963, 62270, 23080, 3367, 62484, 24415, 1541, 59687, 20584, 15194, 57943, 21835, 15548, 59318, 20217, 12744, 39063, 17294, 11006, 40436, 17636, 12248, 38608, 31170, 8504, 34856, 29479, 55880, 36184, 29777, 57133, 34411, 26980, 53253, 47901, 25161, 54709, 48299, 26609, 52931, 45535}, objArr125);
                Object[] objArr126 = {baseContext2, new String[]{str8, (String) objArr125[0]}, Integer.valueOf(iIntValue3), 1, 367240422};
                byte[] bArr40 = $$d;
                byte b24 = bArr40[172];
                byte b25 = bArr40[75];
                Object[] objArr127 = new Object[1];
                c(b24, b25, (short) (b25 | 324), objArr127);
                Class<?> cls21 = Class.forName((String) objArr127[0]);
                Object[] objArr128 = new Object[1];
                c(bArr40[218], bArr40[171], (short) 405, objArr128);
                objArr5 = (Object[]) cls21.getMethod((String) objArr128[0], Context.class, String[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr126);
                int i220 = ((int[]) objArr5[0])[0];
                int i221 = ((int[]) objArr5[3])[0];
                if (baseContext2 != null) {
                    i8 = getARTIFICIAL_FRAME_PACKAGE_NAME + 35;
                    artificialFrame = i8 % 128;
                    try {
                        if (i8 % 2 == 0) {
                            objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(1142731807);
                            if (objAccessartificialFrame6 == null) {
                                int mode4 = View.MeasureSpec.getMode(0) + 21;
                                char fadingEdgeLength2 = (char) (ViewConfiguration.getFadingEdgeLength() >> 16);
                                int fadingEdgeLength3 = 465 - (ViewConfiguration.getFadingEdgeLength() >> 16);
                                Object[] objArr129 = new Object[1];
                                b((byte) 47, $$a[98], (byte) 57, objArr129);
                                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(mode4, fadingEdgeLength2, fadingEdgeLength3, -612765161, false, (String) objArr129[0], null);
                            }
                            ((Field) objAccessartificialFrame6).set(null, objArr5);
                            lValueOf = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[1])).longValue());
                            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(1313006081);
                            if (objAccessartificialFrame5 == null) {
                                iAxisFromString = Color.green(0) + 21;
                                packedPositionType = (char) Color.red(0);
                                touchSlop = 466 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1));
                                i9 = -785931255;
                                z = false;
                                byte[] bArr41 = $$a;
                                Object[] objArr130 = new Object[1];
                                b((byte) 47, bArr41[98], bArr41[81], objArr130);
                                obj3 = objArr130[0];
                                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(iAxisFromString, packedPositionType, touchSlop, i9, z, (String) obj3, null);
                            }
                        } else {
                            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1142731807);
                            if (objAccessartificialFrame4 == null) {
                                int iMyPid2 = (Process.myPid() >> 22) + 21;
                                char cResolveSizeAndState = (char) View.resolveSizeAndState(0, 0, 0);
                                int packedPositionType4 = 465 - ExpandableListView.getPackedPositionType(0L);
                                Object[] objArr131 = new Object[1];
                                b((byte) 47, $$a[98], (byte) 57, objArr131);
                                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(iMyPid2, cResolveSizeAndState, packedPositionType4, -612765161, false, (String) objArr131[0], null);
                            }
                            ((Field) objAccessartificialFrame4).set(null, objArr5);
                            lValueOf = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(1313006081);
                            if (objAccessartificialFrame5 == null) {
                                iAxisFromString = 20 - MotionEvent.axisFromString("");
                                packedPositionType = (char) ExpandableListView.getPackedPositionType(0L);
                                touchSlop = (ViewConfiguration.getTouchSlop() >> 8) + 465;
                                i9 = -785931255;
                                z = false;
                                byte[] bArr42 = $$a;
                                Object[] objArr132 = new Object[1];
                                b((byte) 47, bArr42[98], bArr42[81], objArr132);
                                obj3 = objArr132[0];
                                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(iAxisFromString, packedPositionType, touchSlop, i9, z, (String) obj3, null);
                            }
                        }
                        ((Field) objAccessartificialFrame5).set(null, lValueOf);
                    } catch (Exception unused7) {
                        throw new RuntimeException();
                    }
                }
                c = 0;
                i10 = ((int[]) objArr5[c])[c];
                i11 = ((int[]) objArr5[3])[c];
                if (i11 == i10) {
                    Object[] objArr610 = new Object[4];
                    int[] iArr3 = new int[1];
                    objArr610[c] = iArr3;
                    objArr610[2] = new int[1];
                    int[] iArr4 = new int[1];
                    objArr610[3] = iArr4;
                    int i1210 = ((int[]) objArr5[2])[c];
                    int i1310 = ((int[]) objArr5[3])[c];
                    int i1311 = ((int[]) objArr5[c])[c];
                    String[] strArr13 = (String[]) objArr5[1];
                    iArr4[c] = i1310;
                    iArr3[c] = i1311;
                    int iNextInt4 = new Random().nextInt();
                    int i1312 = i1210 + ((((~(882342990 | iNextInt4)) | (-179389987)) * 262) - 1884806911) + (((~((~iNextInt4) | 882342990)) | (-179389987)) * 262);
                    int i1313 = (i1312 << 13) ^ i1312;
                    int i1314 = i1313 ^ (i1313 >>> 17);
                    ((int[]) objArr610[2])[0] = i1314 ^ (i1314 << 5);
                    objArr610[1] = strArr13;
                    i12 = 0;
                } else {
                    arrayList = new ArrayList();
                    strArr = (String[]) objArr5[1];
                    if (strArr != null) {
                        while (i13 < strArr.length) {
                            arrayList.add(str6);
                        }
                    }
                    Object[] objArr611 = {Long.valueOf(((long) (i10 ^ i11)) ^ (((long) 2070308745) << 32)), Long.valueOf(2070308809)};
                    byte[] bArr212 = $$d;
                    Object[] objArr612 = new Object[1];
                    c(bArr212[172], (byte) (-bArr212[663]), (short) TypedValues.CycleType.TYPE_WAVE_PHASE, objArr612);
                    Class<?> cls114 = Class.forName((String) objArr612[0]);
                    byte b116 = bArr212[118];
                    Object[] objArr613 = new Object[1];
                    c(b116, (byte) (b116 + 4), (short) ($$e + 5), objArr613);
                    cls114.getMethod((String) objArr613[0], Long.TYPE, Long.TYPE).invoke(null, objArr611);
                    Object[] objArr710 = {new int[]{i137}, strArr9, new int[1], new int[]{i136}};
                    int i1315 = ((int[]) objArr5[2])[0];
                    int i1316 = ((int[]) objArr5[3])[0];
                    int i1317 = ((int[]) objArr5[0])[0];
                    String[] strArr14 = (String[]) objArr5[1];
                    int iCodePointAt3 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(4) - 1538211145;
                    int i1318 = ~iCodePointAt3;
                    int i1319 = i1315 + (-1159620387) + (((~((-170065955) | i1318)) | (~((-558374914) | iCodePointAt3)) | (~(738157095 | iCodePointAt3))) * 765) + ((170065954 | (~((-728440868) | i1318))) * 1530) + (((~(iCodePointAt3 | (-728440868))) | (~(i1318 | 738157095))) * 765);
                    int i1410 = (i1319 << 13) ^ i1319;
                    int i1411 = i1410 ^ (i1410 >>> 17);
                    i12 = 0;
                    ((int[]) objArr710[2])[0] = i1411 ^ (i1411 << 5);
                }
                objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-444530678);
                if (objAccessartificialFrame7 == null) {
                    int mode5 = 26 - View.MeasureSpec.getMode(i12);
                    char cBlue2 = (char) Color.blue(i12);
                    int i1412 = 1042 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1));
                    byte[] bArr213 = $$a;
                    Object[] objArr711 = new Object[1];
                    b((byte) 47, bArr213[98], bArr213[81], objArr711);
                    objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(mode5, cBlue2, i1412, 2061780482, false, (String) objArr711[0], null);
                }
                j2 = ((Field) objAccessartificialFrame7).getLong(null);
                if (j2 != -1) {
                    int i1413 = artificialFrame + 43;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i1413 % 128;
                    int i1414 = i1413 % 2;
                    if (j2 + 1911 >= ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                        int i1415 = artificialFrame + 123;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i1415 % 128;
                        int i1416 = i1415 % 2;
                        objAccessartificialFrame20 = ArtificialStackFrames.accessartificialFrame(-614804952);
                        if (objAccessartificialFrame20 == null) {
                            int i1417 = (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + 26;
                            char bitsPerPixel6 = (char) ((-1) - ImageFormat.getBitsPerPixel(0));
                            int i1418 = 1041 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                            Object[] objArr712 = new Object[1];
                            b((byte) 47, $$a[98], (byte) 57, objArr712);
                            objAccessartificialFrame20 = ArtificialStackFrames.coroutineCreation(i1417, bitsPerPixel6, i1418, 1145017376, false, (String) objArr712[0], null);
                        }
                        Object[] objArr713 = (Object[]) ((Field) objAccessartificialFrame20).get(null);
                        objArrAccessartificialFrame$78cbbd35 = new Object[]{strArr10, new int[1], new int[]{i150}, new int[]{i149}};
                        int i1419 = ((int[]) objArr713[3])[0];
                        int i1510 = ((int[]) objArr713[2])[0];
                        String[] strArr15 = (String[]) objArr713[0];
                        int i1511 = ~((~Process.myPid()) | 1040324035);
                        int i1512 = ((((939659456 | i1511) * (-374)) + 329575196) + ((i1511 | 100664579) * 374)) - 2112554579;
                        int i1513 = (i1512 << 13) ^ i1512;
                        int i1514 = i1513 ^ (i1513 >>> 17);
                        ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0] = i1514 ^ (i1514 << 5);
                    } else {
                        int iIntValue4 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
                        Object[] objArr714 = {716904988};
                        objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-1648942878);
                        if (objAccessartificialFrame8 == null) {
                            objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 8, (char) (22252 - (android.os.SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (android.os.SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1))), 1033 - View.getDefaultSize(0, 0), 47343338, false, null, new Class[]{Integer.TYPE});
                        }
                        objArrAccessartificialFrame$78cbbd35 = CompactHashMap.Itr.accessartificialFrame$78cbbd35(iIntValue4, 0, ((Constructor) objAccessartificialFrame8).newInstance(objArr714), -2112554579, false);
                        objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(-614804952);
                        if (objAccessartificialFrame9 == null) {
                            int threadPriority10 = 26 - ((Process.getThreadPriority(0) + 20) >> 6);
                            char doubleTapTimeout4 = (char) (ViewConfiguration.getDoubleTapTimeout() >> 16);
                            int i1515 = 1042 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1));
                            Object[] objArr715 = new Object[1];
                            b((byte) 47, $$a[98], (byte) 57, objArr715);
                            objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(threadPriority10, doubleTapTimeout4, i1515, 1145017376, false, (String) objArr715[0], null);
                        }
                        ((Field) objAccessartificialFrame9).set(null, objArrAccessartificialFrame$78cbbd35);
                        Long lValueOf12 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-444530678);
                        if (objAccessartificialFrame10 == null) {
                            int bitsPerPixel7 = 25 - ImageFormat.getBitsPerPixel(0);
                            char c10 = (char) (1 - (android.os.SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (android.os.SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)));
                            int iIndexOf10 = TextUtils.indexOf((CharSequence) "", '0') + 1042;
                            byte[] bArr214 = $$a;
                            Object[] objArr716 = new Object[1];
                            b((byte) 47, bArr214[98], bArr214[81], objArr716);
                            objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(bitsPerPixel7, c10, iIndexOf10, 2061780482, false, (String) objArr716[0], null);
                        }
                        ((Field) objAccessartificialFrame10).set(null, lValueOf12);
                    }
                } else {
                    int iIntValue5 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
                    Object[] objArr717 = {716904988};
                    objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-1648942878);
                    if (objAccessartificialFrame8 == null) {
                        objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 8, (char) (22252 - (android.os.SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (android.os.SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1))), 1033 - View.getDefaultSize(0, 0), 47343338, false, null, new Class[]{Integer.TYPE});
                    }
                    objArrAccessartificialFrame$78cbbd35 = CompactHashMap.Itr.accessartificialFrame$78cbbd35(iIntValue5, 0, ((Constructor) objAccessartificialFrame8).newInstance(objArr717), -2112554579, false);
                    objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(-614804952);
                    if (objAccessartificialFrame9 == null) {
                        int threadPriority11 = 26 - ((Process.getThreadPriority(0) + 20) >> 6);
                        char doubleTapTimeout5 = (char) (ViewConfiguration.getDoubleTapTimeout() >> 16);
                        int i1516 = 1042 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1));
                        Object[] objArr718 = new Object[1];
                        b((byte) 47, $$a[98], (byte) 57, objArr718);
                        objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(threadPriority11, doubleTapTimeout5, i1516, 1145017376, false, (String) objArr718[0], null);
                    }
                    ((Field) objAccessartificialFrame9).set(null, objArrAccessartificialFrame$78cbbd35);
                    Long lValueOf13 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-444530678);
                    if (objAccessartificialFrame10 == null) {
                        int bitsPerPixel8 = 25 - ImageFormat.getBitsPerPixel(0);
                        char c11 = (char) (1 - (android.os.SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (android.os.SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)));
                        int iIndexOf11 = TextUtils.indexOf((CharSequence) "", '0') + 1042;
                        byte[] bArr215 = $$a;
                        Object[] objArr719 = new Object[1];
                        b((byte) 47, bArr215[98], bArr215[81], objArr719);
                        objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(bitsPerPixel8, c11, iIndexOf11, 2061780482, false, (String) objArr719[0], null);
                    }
                    ((Field) objAccessartificialFrame10).set(null, lValueOf13);
                }
                i14 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
                i15 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
                if (i15 == i14) {
                    Object[] objArr812 = {strArr11, new int[1], new int[]{i159}, new int[]{i158}};
                    int i1517 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
                    int i1518 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
                    int i1519 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
                    String[] strArr16 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
                    int iCodePointAt4 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(8) - 710381406;
                    int i1610 = i1517 + (((~((-809797162) | iCodePointAt4)) | 537165864) * (-283)) + 1772187958 + ((~(iCodePointAt4 | (-272631298))) * 283);
                    int i1611 = (i1610 << 13) ^ i1610;
                    int i1612 = i1611 ^ (i1611 >>> 17);
                    ((int[]) objArr812[1])[0] = i1612 ^ (i1612 << 5);
                    i16 = 0;
                } else {
                    arrayList2 = new ArrayList();
                    strArr2 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
                    if (strArr2 != null) {
                        while (i17 < strArr2.length) {
                            arrayList2.add(str7);
                        }
                    }
                    long j13 = (((long) 936109884) << 32) ^ ((long) (i14 ^ i15));
                    long j14 = 936109886;
                    int i1613 = artificialFrame + 3;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i1613 % 128;
                    int i1614 = i1613 % 2;
                    Object[] objArr813 = {Long.valueOf(j13), Long.valueOf(j14)};
                    byte[] bArr216 = $$d;
                    Object[] objArr814 = new Object[1];
                    c(bArr216[14], bArr216[631], (short) 463, objArr814);
                    Class<?> cls115 = Class.forName((String) objArr814[0]);
                    byte b117 = bArr216[118];
                    Object[] objArr815 = new Object[1];
                    c(b117, (byte) (b117 + 4), (short) ($$e + 5), objArr815);
                    cls115.getMethod((String) objArr815[0], Long.TYPE, Long.TYPE).invoke(null, objArr813);
                    Object[] objArr816 = {strArr12, new int[1], new int[]{i167}, new int[]{i166}};
                    int i1615 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
                    int i1616 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
                    int i1617 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
                    String[] strArr17 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
                    int iMyPid3 = Process.myPid();
                    int i1618 = ~iMyPid3;
                    int i1619 = i1615 + (-1549488194) + (((~(i1618 | 490861389)) | (~(412757582 | i1618)) | (-500957008)) * 464) + (((-88199426) | iMyPid3) * (-464)) + (((~(iMyPid3 | 490861389)) | (-500957008)) * 464);
                    int i1712 = (i1619 << 13) ^ i1619;
                    int i1713 = i1712 ^ (i1712 >>> 17);
                    i16 = 0;
                    ((int[]) objArr816[1])[0] = i1713 ^ (i1713 << 5);
                }
                super.onStart();
                objAccessartificialFrame11 = ArtificialStackFrames.accessartificialFrame(-2127922582);
                if (objAccessartificialFrame11 == null) {
                    int packedPositionType5 = ExpandableListView.getPackedPositionType(0L) + 30;
                    char cAlpha3 = (char) (49362 - Color.alpha(i16));
                    int threadPriority12 = ((Process.getThreadPriority(i16) + 20) >> 6) + 684;
                    byte[] bArr217 = $$a;
                    Object[] objArr817 = new Object[1];
                    b((byte) (bArr217[96] + 1), bArr217[94], (byte) 96, objArr817);
                    objAccessartificialFrame11 = ArtificialStackFrames.coroutineCreation(packedPositionType5, cAlpha3, threadPriority12, 508509282, false, (String) objArr817[0], null);
                }
                j3 = ((Field) objAccessartificialFrame11).getLong(null);
                if (j3 != -1) {
                    if (j3 + 1952 >= ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                        objAccessartificialFrame19 = ArtificialStackFrames.accessartificialFrame(777251007);
                        if (objAccessartificialFrame19 == null) {
                            int offsetAfter2 = TextUtils.getOffsetAfter("", 0) + 30;
                            char cAlpha4 = (char) (Color.alpha(0) + 49362);
                            int i1714 = 685 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1));
                            byte[] bArr218 = $$a;
                            Object[] objArr818 = new Object[1];
                            b(bArr218[65], bArr218[23], (byte) AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, objArr818);
                            objAccessartificialFrame19 = ArtificialStackFrames.coroutineCreation(offsetAfter2, cAlpha4, i1714, -1321816393, false, (String) objArr818[0], null);
                        }
                        Object[] objArr819 = (Object[]) ((Field) objAccessartificialFrame19).get(null);
                        objArr6 = new Object[]{new int[]{((int[]) objArr819[0])[0]}, new int[]{((int[]) objArr819[1])[0]}, new int[1], (String) objArr819[3]};
                        int i1715 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 31408613;
                        int i1716 = ~i1715;
                        int i1717 = ((((-596835844) + (((~((-61749173) | i1716)) | 33690768) * (-108))) + (((~(i1716 | 1040372947)) | ((~((-1040372948) | i1715)) | (-1068431352))) * 54)) + ((i1715 | (-1068431352)) * 54)) - 1026999532;
                        int i1718 = (i1717 << 13) ^ i1717;
                        int i1719 = i1718 ^ (i1718 >>> 17);
                        ((int[]) objArr6[2])[0] = i1719 ^ (i1719 << 5);
                    } else {
                        i18 = 0;
                    }
                    i19 = ((int[]) objArr6[1])[0];
                    i20 = ((int[]) objArr6[0])[0];
                    if (i20 == i19) {
                        int i17110 = getARTIFICIAL_FRAME_PACKAGE_NAME + 37;
                        artificialFrame = i17110 % 128;
                        int i17111 = i17110 % 2;
                        int i18110 = ((int[]) objArr6[2])[0];
                        Object[] objArr8110 = {new int[]{((int[]) objArr6[0])[0]}, new int[]{((int[]) objArr6[1])[0]}, new int[1], (String) objArr6[3]};
                        int mode6 = ((AudioManager) ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getSystemService("audio")).getMode();
                        int i18111 = ~mode6;
                        int i18112 = ~((-255395344) | i18111);
                        int i18113 = ~((-723228432) | mode6);
                        int i18114 = i18110 + 910669500 + ((i18112 | i18113) * 1150) + (((~(723228431 | i18111)) | i18113) * (-575)) + (((~(mode6 | (-255395344))) | (~(i18111 | 255395343))) * 575);
                        int i18115 = (i18114 << 13) ^ i18114;
                        int i18116 = i18115 ^ (i18115 >>> 17);
                        ((int[]) objArr8110[2])[0] = i18116 ^ (i18116 << 5);
                        i21 = 0;
                    } else {
                        Object[] objArr8111 = {Long.valueOf(((long) (i19 ^ i20)) ^ (((long) (-1295343820)) << 32)), Long.valueOf(-1295344332)};
                        byte[] bArr219 = $$d;
                        byte b118 = bArr219[172];
                        byte b119 = bArr219[64];
                        Object[] objArr9116 = new Object[1];
                        c(b118, b119, (short) (b119 | 80), objArr9116);
                        Class<?> cls116 = Class.forName((String) objArr9116[0]);
                        byte b1110 = bArr219[118];
                        Object[] objArr9117 = new Object[1];
                        c(b1110, (byte) (b1110 + 4), (short) ($$e + 5), objArr9117);
                        cls116.getMethod((String) objArr9117[0], Long.TYPE, Long.TYPE).invoke(null, objArr8111);
                        int i18117 = ((int[]) objArr6[2])[0];
                        Object[] objArr9118 = {new int[]{((int[]) objArr6[0])[0]}, new int[]{((int[]) objArr6[1])[0]}, new int[1], (String) objArr6[3]};
                        int iNextInt5 = new Random().nextInt(373309157);
                        int i18118 = i18117 + (-452072299) + (((~(iNextInt5 | 797858843)) | (-180764932)) * (-465)) + ((797858843 | (~((-180764932) | iNextInt5))) * 930) + ((iNextInt5 | (-4194561)) * 465);
                        int i18119 = (i18118 << 13) ^ i18118;
                        int i1916 = i18119 ^ (i18119 >>> 17);
                        i21 = 0;
                        ((int[]) objArr9118[2])[0] = i1916 ^ (i1916 << 5);
                    }
                    objAccessartificialFrame14 = ArtificialStackFrames.accessartificialFrame(1745676544);
                    if (objAccessartificialFrame14 == null) {
                        int iResolveSizeAndState3 = 17 - View.resolveSizeAndState(i21, i21, i21);
                        char windowTouchSlop3 = (char) (ViewConfiguration.getWindowTouchSlop() >> 8);
                        int i1917 = 748 - (android.os.SystemClock.uptimeMillis() > 0L ? 1 : (android.os.SystemClock.uptimeMillis() == 0L ? 0 : -1));
                        byte[] bArr2110 = $$a;
                        Object[] objArr9119 = new Object[1];
                        b((byte) 47, bArr2110[98], bArr2110[81], objArr9119);
                        objAccessartificialFrame14 = ArtificialStackFrames.coroutineCreation(iResolveSizeAndState3, windowTouchSlop3, i1917, -144068856, false, (String) objArr9119[0], null);
                    }
                    j4 = ((Field) objAccessartificialFrame14).getLong(null);
                    if (j4 != -1) {
                        baseContext4 = getBaseContext();
                        if (baseContext4 == null) {
                            Object[] objArr91110 = new Object[1];
                            a(27764 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), new char[]{55918, 46610, 653, 40740, 27564, 50265, 20697, 11524, 47606, 2676, 58881, 29392, 53034, 23483, 13361, 32987, 7497, 59845, 31341, 55039, 41639, 16136, 35743, 25663, 61606, 19792}, objArr91110);
                            Class<?> cls117 = Class.forName((String) objArr91110[0]);
                            Object[] objArr91111 = new Object[1];
                            a(TextUtils.indexOf("", "") + 53441, new char[]{55916, 2747, 31743, 43070, 39278, 51620, 16125, 28425, 23671, 36022, 65001, 8749, 4960, 17315, 45301, 57641, 54896, 1712}, objArr91111);
                            baseContext4 = (Context) cls117.getMethod((String) objArr91111[0], new Class[0]).invoke(null, null);
                        }
                        if (baseContext4 != null) {
                            if (baseContext4 instanceof ContextWrapper) {
                                baseContext4 = baseContext4.getApplicationContext();
                            } else {
                                baseContext4 = baseContext4.getApplicationContext();
                            }
                        }
                        Object[] objArr91112 = {baseContext4, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 1378671210};
                        byte[] bArr311 = $$d;
                        Object[] objArr91113 = new Object[1];
                        c(bArr311[172], bArr311[530], (short) 540, objArr91113);
                        Class<?> cls118 = Class.forName((String) objArr91113[0]);
                        byte b1111 = (byte) (bArr311[99] - 1);
                        Object[] objArr91114 = new Object[1];
                        c(b1111, (byte) (b1111 | Ascii.DC2), (short) (-bArr311[500]), objArr91114);
                        objArr7 = (Object[]) cls118.getMethod((String) objArr91114[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr91112);
                        objAccessartificialFrame15 = ArtificialStackFrames.accessartificialFrame(1575402270);
                        if (objAccessartificialFrame15 == null) {
                            int threadPriority13 = 17 - ((Process.getThreadPriority(0) + 20) >> 6);
                            char cIndexOf5 = (char) TextUtils.indexOf("", "", 0);
                            int iIndexOf12 = 746 - TextUtils.indexOf((CharSequence) "", '0');
                            Object[] objArr91115 = new Object[1];
                            b((byte) 47, $$a[98], (byte) 57, objArr91115);
                            objAccessartificialFrame15 = ArtificialStackFrames.coroutineCreation(threadPriority13, cIndexOf5, iIndexOf12, -1031537386, false, (String) objArr91115[0], null);
                        }
                        ((Field) objAccessartificialFrame15).set(null, objArr7);
                        Long lValueOf14 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame16 = ArtificialStackFrames.accessartificialFrame(1745676544);
                        if (objAccessartificialFrame16 == null) {
                            int i1918 = 17 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                            char c12 = (char) (1 - (android.os.SystemClock.elapsedRealtime() > 0L ? 1 : (android.os.SystemClock.elapsedRealtime() == 0L ? 0 : -1)));
                            int i1919 = (android.os.SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (android.os.SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 746;
                            byte[] bArr312 = $$a;
                            Object[] objArr1019 = new Object[1];
                            b((byte) 47, bArr312[98], bArr312[81], objArr1019);
                            objAccessartificialFrame16 = ArtificialStackFrames.coroutineCreation(i1918, c12, i1919, -144068856, false, (String) objArr1019[0], null);
                        }
                        ((Field) objAccessartificialFrame16).set(null, lValueOf14);
                    } else {
                        baseContext4 = getBaseContext();
                        if (baseContext4 == null) {
                            Object[] objArr91116 = new Object[1];
                            a(27764 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), new char[]{55918, 46610, 653, 40740, 27564, 50265, 20697, 11524, 47606, 2676, 58881, 29392, 53034, 23483, 13361, 32987, 7497, 59845, 31341, 55039, 41639, 16136, 35743, 25663, 61606, 19792}, objArr91116);
                            Class<?> cls119 = Class.forName((String) objArr91116[0]);
                            Object[] objArr91117 = new Object[1];
                            a(TextUtils.indexOf("", "") + 53441, new char[]{55916, 2747, 31743, 43070, 39278, 51620, 16125, 28425, 23671, 36022, 65001, 8749, 4960, 17315, 45301, 57641, 54896, 1712}, objArr91117);
                            baseContext4 = (Context) cls119.getMethod((String) objArr91117[0], new Class[0]).invoke(null, null);
                        }
                        if (baseContext4 != null) {
                            if (baseContext4 instanceof ContextWrapper) {
                                baseContext4 = baseContext4.getApplicationContext();
                            } else {
                                baseContext4 = baseContext4.getApplicationContext();
                            }
                        }
                        Object[] objArr91118 = {baseContext4, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 1378671210};
                        byte[] bArr313 = $$d;
                        Object[] objArr91119 = new Object[1];
                        c(bArr313[172], bArr313[530], (short) 540, objArr91119);
                        Class<?> cls1110 = Class.forName((String) objArr91119[0]);
                        byte b1112 = (byte) (bArr313[99] - 1);
                        Object[] objArr911110 = new Object[1];
                        c(b1112, (byte) (b1112 | Ascii.DC2), (short) (-bArr313[500]), objArr911110);
                        objArr7 = (Object[]) cls1110.getMethod((String) objArr911110[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr91118);
                        objAccessartificialFrame15 = ArtificialStackFrames.accessartificialFrame(1575402270);
                        if (objAccessartificialFrame15 == null) {
                            int threadPriority14 = 17 - ((Process.getThreadPriority(0) + 20) >> 6);
                            char cIndexOf6 = (char) TextUtils.indexOf("", "", 0);
                            int iIndexOf13 = 746 - TextUtils.indexOf((CharSequence) "", '0');
                            Object[] objArr911111 = new Object[1];
                            b((byte) 47, $$a[98], (byte) 57, objArr911111);
                            objAccessartificialFrame15 = ArtificialStackFrames.coroutineCreation(threadPriority14, cIndexOf6, iIndexOf13, -1031537386, false, (String) objArr911111[0], null);
                        }
                        ((Field) objAccessartificialFrame15).set(null, objArr7);
                        Long lValueOf15 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame16 = ArtificialStackFrames.accessartificialFrame(1745676544);
                        if (objAccessartificialFrame16 == null) {
                            int i19110 = 17 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                            char c13 = (char) (1 - (android.os.SystemClock.elapsedRealtime() > 0L ? 1 : (android.os.SystemClock.elapsedRealtime() == 0L ? 0 : -1)));
                            int i19111 = (android.os.SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (android.os.SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 746;
                            byte[] bArr314 = $$a;
                            Object[] objArr10110 = new Object[1];
                            b((byte) 47, bArr314[98], bArr314[81], objArr10110);
                            objAccessartificialFrame16 = ArtificialStackFrames.coroutineCreation(i19110, c13, i19111, -144068856, false, (String) objArr10110[0], null);
                        }
                        ((Field) objAccessartificialFrame16).set(null, lValueOf15);
                    }
                    i22 = ((int[]) objArr7[4])[0];
                    i23 = ((int[]) objArr7[3])[0];
                    if (i23 == i22) {
                        int i2019 = artificialFrame + 123;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i2019 % 128;
                        int i20110 = i2019 % 2;
                        Object[] objArr10111 = {list7, new int[1], list8, new int[]{i2013}, new int[]{i2014}};
                        int i20111 = ((int[]) objArr7[1])[0];
                        int i20112 = ((int[]) objArr7[3])[0];
                        int i20113 = ((int[]) objArr7[4])[0];
                        List list11 = (List) objArr7[0];
                        List list12 = (List) objArr7[2];
                        int i20114 = ~((~Process.myUid()) | 96621351);
                        int i20115 = i20111 + (((25313797 | i20114) * (-970)) - 1058822873) + ((i20114 | 71307554) * 970);
                        int i20116 = (i20115 << 13) ^ i20115;
                        int i20117 = i20116 ^ (i20116 >>> 17);
                        ((int[]) objArr10111[1])[0] = i20117 ^ (i20117 << 5);
                        return;
                    }
                    ArrayList arrayList6 = new ArrayList();
                    Object[] objArr10112 = {objArr7};
                    objAccessartificialFrame17 = ArtificialStackFrames.accessartificialFrame(1804664566);
                    if (objAccessartificialFrame17 == null) {
                        objAccessartificialFrame17 = ArtificialStackFrames.coroutineCreation(40 - MotionEvent.axisFromString(""), (char) ((Process.myTid() >> 22) + 12468), View.getDefaultSize(0, 0) + 3642, -185222914, false, "coroutineCreation", new Class[]{Object[].class});
                    }
                    arrayList6.add(((Method) objAccessartificialFrame17).invoke(null, objArr10112));
                    Object[] objArr10113 = {objArr7};
                    objAccessartificialFrame18 = ArtificialStackFrames.accessartificialFrame(-1243809191);
                    if (objAccessartificialFrame18 == null) {
                        objAccessartificialFrame18 = ArtificialStackFrames.coroutineCreation(42 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 12467), TextUtils.indexOf((CharSequence) "", '0', 0) + 3643, 716815441, false, "ArtificialStackFrames", new Class[]{Object[].class});
                    }
                    arrayList6.add(((Method) objAccessartificialFrame18).invoke(null, objArr10113));
                    Object[] objArr10114 = {Long.valueOf((((long) (-1097680825)) << 32) ^ ((long) (i22 ^ i23))), Long.valueOf(-1097680817)};
                    byte[] bArr315 = $$d;
                    byte b1113 = bArr315[172];
                    byte b26 = bArr315[87];
                    Object[] objArr10115 = new Object[1];
                    c(b1113, b26, (short) (b26 | 578), objArr10115);
                    Class<?> cls1111 = Class.forName((String) objArr10115[0]);
                    byte b27 = bArr315[118];
                    Object[] objArr10116 = new Object[1];
                    c(b27, (byte) (b27 + 4), (short) ($$e + 5), objArr10116);
                    cls1111.getMethod((String) objArr10116[0], Long.TYPE, Long.TYPE).invoke(null, objArr10114);
                    Object[] objArr10117 = {list9, new int[1], list10, new int[]{i2111}, new int[]{i2112}};
                    int i2117 = ((int[]) objArr7[1])[0];
                    int i2118 = ((int[]) objArr7[3])[0];
                    int i2119 = ((int[]) objArr7[4])[0];
                    List list13 = (List) objArr7[0];
                    List list14 = (List) objArr7[2];
                    int length4 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 682201691;
                    int i21110 = ~length4;
                    int i21111 = i2117 + (((~(41798803 | i21110)) | (~((-647247262) | length4)) | (~(i21110 | 647247261))) * 959) + 1742647508 + (((~(length4 | 647247261)) | (~(i21110 | (-647247262))) | (~(41798803 | length4))) * 959);
                    int i21112 = (i21111 << 13) ^ i21111;
                    int i21113 = i21112 ^ (i21112 >>> 17);
                    ((int[]) objArr10117[1])[0] = i21113 ^ (i21113 << 5);
                    return;
                }
                i18 = 0;
                baseContext3 = getBaseContext();
                if (baseContext3 == null) {
                    Object[] objArr1110 = new Object[1];
                    a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[i18]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(i18, 4).codePointAt(3) + 27648, new char[]{55918, 46610, 653, 40740, 27564, 50265, 20697, 11524, 47606, 2676, 58881, 29392, 53034, 23483, 13361, 32987, 7497, 59845, 31341, 55039, 41639, 16136, 35743, 25663, 61606, 19792}, objArr1110);
                    Class<?> cls120 = Class.forName((String) objArr1110[i18]);
                    Object[] objArr1111 = new Object[1];
                    a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[i18]).invoke(null, null)).getApplicationContext().getPackageName().length() + 53420, new char[]{55916, 2747, 31743, 43070, 39278, 51620, 16125, 28425, 23671, 36022, 65001, 8749, 4960, 17315, 45301, 57641, 54896, 1712}, objArr1111);
                    baseContext3 = (Context) cls120.getMethod((String) objArr1111[0], new Class[0]).invoke(null, null);
                }
                if (baseContext3 != null) {
                    if (baseContext3 instanceof ContextWrapper) {
                        int i2120 = artificialFrame + 51;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i2120 % 128;
                        int i2121 = i2120 % 2;
                        if (((ContextWrapper) baseContext3).getBaseContext() != null) {
                            baseContext3 = baseContext3.getApplicationContext();
                        } else {
                            baseContext3 = null;
                        }
                    } else {
                        baseContext3 = baseContext3.getApplicationContext();
                    }
                }
                Object[] objArr1112 = {baseContext3, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), -1026999532};
                byte[] bArr316 = $$d;
                Object[] objArr1113 = new Object[1];
                c(bArr316[9], bArr316[128], (short) TypedValues.PositionType.TYPE_PERCENT_X, objArr1113);
                Class<?> cls121 = Class.forName((String) objArr1113[0]);
                Object[] objArr1114 = new Object[1];
                c(bArr316[218], bArr316[171], (short) 405, objArr1114);
                objArr6 = (Object[]) cls121.getMethod((String) objArr1114[0], Context.class, Integer.TYPE, Integer.TYPE).invoke(null, objArr1112);
                if (baseContext3 != null) {
                    objAccessartificialFrame12 = ArtificialStackFrames.accessartificialFrame(777251007);
                    if (objAccessartificialFrame12 == null) {
                        int iRed4 = 30 - Color.red(0);
                        char deadChar4 = (char) (KeyEvent.getDeadChar(0, 0) + 49362);
                        int iArgb2 = Color.argb(0, 0, 0, 0) + 684;
                        byte[] bArr317 = $$a;
                        Object[] objArr1210 = new Object[1];
                        b(bArr317[65], bArr317[23], (byte) AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, objArr1210);
                        objAccessartificialFrame12 = ArtificialStackFrames.coroutineCreation(iRed4, deadChar4, iArgb2, -1321816393, false, (String) objArr1210[0], null);
                    }
                    ((Field) objAccessartificialFrame12).set(null, objArr6);
                    Long lValueOf16 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame13 = ArtificialStackFrames.accessartificialFrame(-2127922582);
                    if (objAccessartificialFrame13 == null) {
                        int i2122 = (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 29;
                        char c14 = (char) (49361 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)));
                        int iRed5 = 684 - Color.red(0);
                        byte[] bArr318 = $$a;
                        Object[] objArr1211 = new Object[1];
                        b((byte) (bArr318[96] + 1), bArr318[94], (byte) 96, objArr1211);
                        objAccessartificialFrame13 = ArtificialStackFrames.coroutineCreation(i2122, c14, iRed5, 508509282, false, (String) objArr1211[0], null);
                    }
                    ((Field) objAccessartificialFrame13).set(null, lValueOf16);
                }
                i19 = ((int[]) objArr6[1])[0];
                i20 = ((int[]) objArr6[0])[0];
                if (i20 == i19) {
                    int i17112 = getARTIFICIAL_FRAME_PACKAGE_NAME + 37;
                    artificialFrame = i17112 % 128;
                    int i17113 = i17112 % 2;
                    int i181110 = ((int[]) objArr6[2])[0];
                    Object[] objArr8112 = {new int[]{((int[]) objArr6[0])[0]}, new int[]{((int[]) objArr6[1])[0]}, new int[1], (String) objArr6[3]};
                    int mode7 = ((AudioManager) ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getSystemService("audio")).getMode();
                    int i181111 = ~mode7;
                    int i181112 = ~((-255395344) | i181111);
                    int i181113 = ~((-723228432) | mode7);
                    int i181114 = i181110 + 910669500 + ((i181112 | i181113) * 1150) + (((~(723228431 | i181111)) | i181113) * (-575)) + (((~(mode7 | (-255395344))) | (~(i181111 | 255395343))) * 575);
                    int i181115 = (i181114 << 13) ^ i181114;
                    int i181116 = i181115 ^ (i181115 >>> 17);
                    ((int[]) objArr8112[2])[0] = i181116 ^ (i181116 << 5);
                    i21 = 0;
                } else {
                    Object[] objArr8113 = {Long.valueOf(((long) (i19 ^ i20)) ^ (((long) (-1295343820)) << 32)), Long.valueOf(-1295344332)};
                    byte[] bArr2111 = $$d;
                    byte b1114 = bArr2111[172];
                    byte b1115 = bArr2111[64];
                    Object[] objArr91120 = new Object[1];
                    c(b1114, b1115, (short) (b1115 | 80), objArr91120);
                    Class<?> cls1112 = Class.forName((String) objArr91120[0]);
                    byte b1116 = bArr2111[118];
                    Object[] objArr91121 = new Object[1];
                    c(b1116, (byte) (b1116 + 4), (short) ($$e + 5), objArr91121);
                    cls1112.getMethod((String) objArr91121[0], Long.TYPE, Long.TYPE).invoke(null, objArr8113);
                    int i181117 = ((int[]) objArr6[2])[0];
                    Object[] objArr91122 = {new int[]{((int[]) objArr6[0])[0]}, new int[]{((int[]) objArr6[1])[0]}, new int[1], (String) objArr6[3]};
                    int iNextInt6 = new Random().nextInt(373309157);
                    int i181118 = i181117 + (-452072299) + (((~(iNextInt6 | 797858843)) | (-180764932)) * (-465)) + ((797858843 | (~((-180764932) | iNextInt6))) * 930) + ((iNextInt6 | (-4194561)) * 465);
                    int i181119 = (i181118 << 13) ^ i181118;
                    int i19112 = i181119 ^ (i181119 >>> 17);
                    i21 = 0;
                    ((int[]) objArr91122[2])[0] = i19112 ^ (i19112 << 5);
                }
                objAccessartificialFrame14 = ArtificialStackFrames.accessartificialFrame(1745676544);
                if (objAccessartificialFrame14 == null) {
                    int iResolveSizeAndState4 = 17 - View.resolveSizeAndState(i21, i21, i21);
                    char windowTouchSlop4 = (char) (ViewConfiguration.getWindowTouchSlop() >> 8);
                    int i19113 = 748 - (android.os.SystemClock.uptimeMillis() > 0L ? 1 : (android.os.SystemClock.uptimeMillis() == 0L ? 0 : -1));
                    byte[] bArr2112 = $$a;
                    Object[] objArr91123 = new Object[1];
                    b((byte) 47, bArr2112[98], bArr2112[81], objArr91123);
                    objAccessartificialFrame14 = ArtificialStackFrames.coroutineCreation(iResolveSizeAndState4, windowTouchSlop4, i19113, -144068856, false, (String) objArr91123[0], null);
                }
                j4 = ((Field) objAccessartificialFrame14).getLong(null);
                if (j4 != -1) {
                    baseContext4 = getBaseContext();
                    if (baseContext4 == null) {
                        Object[] objArr911112 = new Object[1];
                        a(27764 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), new char[]{55918, 46610, 653, 40740, 27564, 50265, 20697, 11524, 47606, 2676, 58881, 29392, 53034, 23483, 13361, 32987, 7497, 59845, 31341, 55039, 41639, 16136, 35743, 25663, 61606, 19792}, objArr911112);
                        Class<?> cls1113 = Class.forName((String) objArr911112[0]);
                        Object[] objArr911113 = new Object[1];
                        a(TextUtils.indexOf("", "") + 53441, new char[]{55916, 2747, 31743, 43070, 39278, 51620, 16125, 28425, 23671, 36022, 65001, 8749, 4960, 17315, 45301, 57641, 54896, 1712}, objArr911113);
                        baseContext4 = (Context) cls1113.getMethod((String) objArr911113[0], new Class[0]).invoke(null, null);
                    }
                    if (baseContext4 != null) {
                        if (baseContext4 instanceof ContextWrapper) {
                            baseContext4 = baseContext4.getApplicationContext();
                        } else {
                            baseContext4 = baseContext4.getApplicationContext();
                        }
                    }
                    Object[] objArr911114 = {baseContext4, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 1378671210};
                    byte[] bArr319 = $$d;
                    Object[] objArr911115 = new Object[1];
                    c(bArr319[172], bArr319[530], (short) 540, objArr911115);
                    Class<?> cls1114 = Class.forName((String) objArr911115[0]);
                    byte b1117 = (byte) (bArr319[99] - 1);
                    Object[] objArr911116 = new Object[1];
                    c(b1117, (byte) (b1117 | Ascii.DC2), (short) (-bArr319[500]), objArr911116);
                    objArr7 = (Object[]) cls1114.getMethod((String) objArr911116[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr911114);
                    objAccessartificialFrame15 = ArtificialStackFrames.accessartificialFrame(1575402270);
                    if (objAccessartificialFrame15 == null) {
                        int threadPriority15 = 17 - ((Process.getThreadPriority(0) + 20) >> 6);
                        char cIndexOf7 = (char) TextUtils.indexOf("", "", 0);
                        int iIndexOf14 = 746 - TextUtils.indexOf((CharSequence) "", '0');
                        Object[] objArr911117 = new Object[1];
                        b((byte) 47, $$a[98], (byte) 57, objArr911117);
                        objAccessartificialFrame15 = ArtificialStackFrames.coroutineCreation(threadPriority15, cIndexOf7, iIndexOf14, -1031537386, false, (String) objArr911117[0], null);
                    }
                    ((Field) objAccessartificialFrame15).set(null, objArr7);
                    Long lValueOf17 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame16 = ArtificialStackFrames.accessartificialFrame(1745676544);
                    if (objAccessartificialFrame16 == null) {
                        int i19114 = 17 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                        char c15 = (char) (1 - (android.os.SystemClock.elapsedRealtime() > 0L ? 1 : (android.os.SystemClock.elapsedRealtime() == 0L ? 0 : -1)));
                        int i19115 = (android.os.SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (android.os.SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 746;
                        byte[] bArr3110 = $$a;
                        Object[] objArr10118 = new Object[1];
                        b((byte) 47, bArr3110[98], bArr3110[81], objArr10118);
                        objAccessartificialFrame16 = ArtificialStackFrames.coroutineCreation(i19114, c15, i19115, -144068856, false, (String) objArr10118[0], null);
                    }
                    ((Field) objAccessartificialFrame16).set(null, lValueOf17);
                } else {
                    baseContext4 = getBaseContext();
                    if (baseContext4 == null) {
                        Object[] objArr911118 = new Object[1];
                        a(27764 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), new char[]{55918, 46610, 653, 40740, 27564, 50265, 20697, 11524, 47606, 2676, 58881, 29392, 53034, 23483, 13361, 32987, 7497, 59845, 31341, 55039, 41639, 16136, 35743, 25663, 61606, 19792}, objArr911118);
                        Class<?> cls1115 = Class.forName((String) objArr911118[0]);
                        Object[] objArr911119 = new Object[1];
                        a(TextUtils.indexOf("", "") + 53441, new char[]{55916, 2747, 31743, 43070, 39278, 51620, 16125, 28425, 23671, 36022, 65001, 8749, 4960, 17315, 45301, 57641, 54896, 1712}, objArr911119);
                        baseContext4 = (Context) cls1115.getMethod((String) objArr911119[0], new Class[0]).invoke(null, null);
                    }
                    if (baseContext4 != null) {
                        if (baseContext4 instanceof ContextWrapper) {
                            baseContext4 = baseContext4.getApplicationContext();
                        } else {
                            baseContext4 = baseContext4.getApplicationContext();
                        }
                    }
                    Object[] objArr9111110 = {baseContext4, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 1378671210};
                    byte[] bArr3111 = $$d;
                    Object[] objArr9111111 = new Object[1];
                    c(bArr3111[172], bArr3111[530], (short) 540, objArr9111111);
                    Class<?> cls1116 = Class.forName((String) objArr9111111[0]);
                    byte b1118 = (byte) (bArr3111[99] - 1);
                    Object[] objArr9111112 = new Object[1];
                    c(b1118, (byte) (b1118 | Ascii.DC2), (short) (-bArr3111[500]), objArr9111112);
                    objArr7 = (Object[]) cls1116.getMethod((String) objArr9111112[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr9111110);
                    objAccessartificialFrame15 = ArtificialStackFrames.accessartificialFrame(1575402270);
                    if (objAccessartificialFrame15 == null) {
                        int threadPriority16 = 17 - ((Process.getThreadPriority(0) + 20) >> 6);
                        char cIndexOf8 = (char) TextUtils.indexOf("", "", 0);
                        int iIndexOf15 = 746 - TextUtils.indexOf((CharSequence) "", '0');
                        Object[] objArr9111113 = new Object[1];
                        b((byte) 47, $$a[98], (byte) 57, objArr9111113);
                        objAccessartificialFrame15 = ArtificialStackFrames.coroutineCreation(threadPriority16, cIndexOf8, iIndexOf15, -1031537386, false, (String) objArr9111113[0], null);
                    }
                    ((Field) objAccessartificialFrame15).set(null, objArr7);
                    Long lValueOf18 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame16 = ArtificialStackFrames.accessartificialFrame(1745676544);
                    if (objAccessartificialFrame16 == null) {
                        int i19116 = 17 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                        char c16 = (char) (1 - (android.os.SystemClock.elapsedRealtime() > 0L ? 1 : (android.os.SystemClock.elapsedRealtime() == 0L ? 0 : -1)));
                        int i19117 = (android.os.SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (android.os.SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 746;
                        byte[] bArr3112 = $$a;
                        Object[] objArr10119 = new Object[1];
                        b((byte) 47, bArr3112[98], bArr3112[81], objArr10119);
                        objAccessartificialFrame16 = ArtificialStackFrames.coroutineCreation(i19116, c16, i19117, -144068856, false, (String) objArr10119[0], null);
                    }
                    ((Field) objAccessartificialFrame16).set(null, lValueOf18);
                }
                i22 = ((int[]) objArr7[4])[0];
                i23 = ((int[]) objArr7[3])[0];
                if (i23 == i22) {
                    int i20118 = artificialFrame + 123;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i20118 % 128;
                    int i20119 = i20118 % 2;
                    Object[] objArr101110 = {list11, new int[1], list12, new int[]{i20112}, new int[]{i20113}};
                    int i201110 = ((int[]) objArr7[1])[0];
                    int i201111 = ((int[]) objArr7[3])[0];
                    int i201112 = ((int[]) objArr7[4])[0];
                    List list15 = (List) objArr7[0];
                    List list16 = (List) objArr7[2];
                    int i201113 = ~((~Process.myUid()) | 96621351);
                    int i201114 = i201110 + (((25313797 | i201113) * (-970)) - 1058822873) + ((i201113 | 71307554) * 970);
                    int i201115 = (i201114 << 13) ^ i201114;
                    int i201116 = i201115 ^ (i201115 >>> 17);
                    ((int[]) objArr101110[1])[0] = i201116 ^ (i201116 << 5);
                    return;
                }
                ArrayList arrayList7 = new ArrayList();
                Object[] objArr101111 = {objArr7};
                objAccessartificialFrame17 = ArtificialStackFrames.accessartificialFrame(1804664566);
                if (objAccessartificialFrame17 == null) {
                    objAccessartificialFrame17 = ArtificialStackFrames.coroutineCreation(40 - MotionEvent.axisFromString(""), (char) ((Process.myTid() >> 22) + 12468), View.getDefaultSize(0, 0) + 3642, -185222914, false, "coroutineCreation", new Class[]{Object[].class});
                }
                arrayList7.add(((Method) objAccessartificialFrame17).invoke(null, objArr101111));
                Object[] objArr101112 = {objArr7};
                objAccessartificialFrame18 = ArtificialStackFrames.accessartificialFrame(-1243809191);
                if (objAccessartificialFrame18 == null) {
                    objAccessartificialFrame18 = ArtificialStackFrames.coroutineCreation(42 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 12467), TextUtils.indexOf((CharSequence) "", '0', 0) + 3643, 716815441, false, "ArtificialStackFrames", new Class[]{Object[].class});
                }
                arrayList7.add(((Method) objAccessartificialFrame18).invoke(null, objArr101112));
                Object[] objArr101113 = {Long.valueOf((((long) (-1097680825)) << 32) ^ ((long) (i22 ^ i23))), Long.valueOf(-1097680817)};
                byte[] bArr3113 = $$d;
                byte b1119 = bArr3113[172];
                byte b28 = bArr3113[87];
                Object[] objArr101114 = new Object[1];
                c(b1119, b28, (short) (b28 | 578), objArr101114);
                Class<?> cls1117 = Class.forName((String) objArr101114[0]);
                byte b29 = bArr3113[118];
                Object[] objArr101115 = new Object[1];
                c(b29, (byte) (b29 + 4), (short) ($$e + 5), objArr101115);
                cls1117.getMethod((String) objArr101115[0], Long.TYPE, Long.TYPE).invoke(null, objArr101113);
                Object[] objArr101116 = {list13, new int[1], list14, new int[]{i2118}, new int[]{i2119}};
                int i21114 = ((int[]) objArr7[1])[0];
                int i21115 = ((int[]) objArr7[3])[0];
                int i21116 = ((int[]) objArr7[4])[0];
                List list17 = (List) objArr7[0];
                List list18 = (List) objArr7[2];
                int length5 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 682201691;
                int i21117 = ~length5;
                int i21118 = i21114 + (((~(41798803 | i21117)) | (~((-647247262) | length5)) | (~(i21117 | 647247261))) * 959) + 1742647508 + (((~(length5 | 647247261)) | (~(i21117 | (-647247262))) | (~(41798803 | length5))) * 959);
                int i21119 = (i21118 << 13) ^ i21118;
                int i211110 = i21119 ^ (i21119 >>> 17);
                ((int[]) objArr101116[1])[0] = i211110 ^ (i211110 << 5);
                return;
            }
            i3 = 0;
            Long lValueOf19 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
            Object objAccessartificialFrame36 = ArtificialStackFrames.accessartificialFrame(-1168947751);
            if (objAccessartificialFrame36 == null) {
                int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0) + 36;
                char c17 = (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1));
                int scrollBarFadeDuration = 540 - (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                byte[] bArr43 = $$a;
                Object[] objArr133 = new Object[1];
                b((byte) 47, bArr43[98], bArr43[81], objArr133);
                objAccessartificialFrame36 = ArtificialStackFrames.coroutineCreation(iMakeMeasureSpec2, c17, scrollBarFadeDuration, 624296913, false, (String) objArr133[0], null);
            }
            ((Field) objAccessartificialFrame36).set(null, lValueOf19);
            obj = objArr4[1];
            i4 = ((int[]) obj)[0];
            obj2 = objArr4[2];
            i5 = ((int[]) obj2)[0];
            if (i5 == i4) {
                Object[] objArr510 = {new int[1], new int[1], new int[1]};
                int i1010 = ((int[]) objArr4[0])[0];
                int i1011 = ((int[]) obj2)[0];
                int i1012 = ((int[]) obj)[0];
                ((int[]) objArr510[2])[0] = i1011;
                ((int[]) objArr510[1])[0] = i1012;
                int length6 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 1730311089;
                int i1110 = 1918586679 + ((length6 | 466732159) * (-50));
                int i1111 = ~((-277890167) | length6);
                int i1112 = ~length6;
                int i1113 = i1010 + i1110 + ((i1111 | (~((-606999425) | i1112))) * 50) + (((~(i1112 | 466732159)) | (~((-884889591) | i1112)) | 606999424) * 50);
                int i1114 = (i1113 << 13) ^ i1113;
                int i1115 = i1114 ^ (i1114 >>> 17);
                ((int[]) objArr510[0])[0] = i1115 ^ (i1115 << 5);
                i6 = 0;
            } else {
                Object[] objArr511 = {Long.valueOf((((long) (-1510256497)) << 32) ^ ((long) (i4 ^ i5))), Long.valueOf(-1510260593)};
                byte[] bArr110 = $$d;
                byte b120 = bArr110[172];
                byte b121 = bArr110[64];
                Object[] objArr614 = new Object[1];
                c(b120, b121, (short) (b121 | 80), objArr614);
                Class<?> cls22 = Class.forName((String) objArr614[0]);
                byte b122 = bArr110[118];
                Object[] objArr615 = new Object[1];
                c(b122, (byte) (b122 + 4), (short) ($$e + 5), objArr615);
                cls22.getMethod((String) objArr615[0], Long.TYPE, Long.TYPE).invoke(null, objArr511);
                Object[] objArr616 = {new int[1], new int[1], new int[1]};
                int i1116 = ((int[]) objArr4[0])[0];
                int i1117 = ((int[]) objArr4[2])[0];
                int i1118 = ((int[]) objArr4[1])[0];
                ((int[]) objArr616[2])[0] = i1117;
                ((int[]) objArr616[1])[0] = i1118;
                int i1119 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getDisplayMetrics().densityDpi;
                int i1211 = i1116 + (-828352127) + (((~(i1119 | 1266002740)) | 85619009) * 191) + (((~((~i1119) | 1266002740)) | 67784769) * 191);
                int i1212 = (i1211 << 13) ^ i1211;
                int i1213 = i1212 ^ (i1212 >>> 17);
                i6 = 0;
                ((int[]) objArr616[0])[0] = i1213 ^ (i1213 << 5);
            }
            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(1313006081);
            if (objAccessartificialFrame3 == null) {
                int keyRepeatDelay4 = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 21;
                char cGreen2 = (char) Color.green(i6);
                int threadPriority17 = ((Process.getThreadPriority(i6) + 20) >> 6) + 465;
                byte[] bArr220 = $$a;
                Object[] objArr617 = new Object[1];
                b((byte) 47, bArr220[98], bArr220[81], objArr617);
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(keyRepeatDelay4, cGreen2, threadPriority17, -785931255, false, (String) objArr617[0], null);
            }
            j = ((Field) objAccessartificialFrame3).getLong(null);
            if (j != -1) {
                if (j + 1855 >= ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                    objAccessartificialFrame21 = ArtificialStackFrames.accessartificialFrame(1142731807);
                    if (objAccessartificialFrame21 == null) {
                        int iLastIndexOf2 = TextUtils.lastIndexOf("", '0', 0, 0) + 22;
                        char cAxisFromString2 = (char) ((-1) - MotionEvent.axisFromString(""));
                        int gidForName2 = Process.getGidForName("") + 466;
                        Object[] objArr618 = new Object[1];
                        b((byte) 47, $$a[98], (byte) 57, objArr618);
                        objAccessartificialFrame21 = ArtificialStackFrames.coroutineCreation(iLastIndexOf2, cAxisFromString2, gidForName2, -612765161, false, (String) objArr618[0], null);
                    }
                    Object[] objArr619 = (Object[]) ((Field) objAccessartificialFrame21).get(null);
                    objArr5 = new Object[]{new int[]{i124}, strArr7, new int[1], new int[]{i123}};
                    int i1214 = ((int[]) objArr619[3])[0];
                    int i1215 = ((int[]) objArr619[0])[0];
                    String[] strArr18 = (String[]) objArr619[1];
                    int startElapsedRealtime2 = (int) Process.getStartElapsedRealtime();
                    int i1216 = ~startElapsedRealtime2;
                    int i1217 = 767584996 + (((~(i1216 | 38373607)) | 121976118) * (-1042)) + ((38373607 | startElapsedRealtime2) * 521) + (((~(startElapsedRealtime2 | (-121976119))) | 37814310 | (~(i1216 | 122535415))) * 521) + 367240422;
                    int i1218 = (i1217 << 13) ^ i1217;
                    int i1219 = i1218 ^ (i1218 >>> 17);
                    ((int[]) objArr5[2])[0] = i1219 ^ (i1219 << 5);
                    c = 0;
                } else {
                    i7 = 0;
                }
                i10 = ((int[]) objArr5[c])[c];
                i11 = ((int[]) objArr5[3])[c];
                if (i11 == i10) {
                    Object[] objArr6110 = new Object[4];
                    int[] iArr5 = new int[1];
                    objArr6110[c] = iArr5;
                    objArr6110[2] = new int[1];
                    int[] iArr6 = new int[1];
                    objArr6110[3] = iArr6;
                    int i12110 = ((int[]) objArr5[2])[c];
                    int i13110 = ((int[]) objArr5[3])[c];
                    int i13111 = ((int[]) objArr5[c])[c];
                    String[] strArr19 = (String[]) objArr5[1];
                    iArr6[c] = i13110;
                    iArr5[c] = i13111;
                    int iNextInt7 = new Random().nextInt();
                    int i13112 = i12110 + ((((~(882342990 | iNextInt7)) | (-179389987)) * 262) - 1884806911) + (((~((~iNextInt7) | 882342990)) | (-179389987)) * 262);
                    int i13113 = (i13112 << 13) ^ i13112;
                    int i13114 = i13113 ^ (i13113 >>> 17);
                    ((int[]) objArr6110[2])[0] = i13114 ^ (i13114 << 5);
                    objArr6110[1] = strArr19;
                    i12 = 0;
                } else {
                    arrayList = new ArrayList();
                    strArr = (String[]) objArr5[1];
                    if (strArr != null) {
                        while (i13 < strArr.length) {
                            arrayList.add(str6);
                        }
                    }
                    Object[] objArr6111 = {Long.valueOf(((long) (i10 ^ i11)) ^ (((long) 2070308745) << 32)), Long.valueOf(2070308809)};
                    byte[] bArr2113 = $$d;
                    Object[] objArr6112 = new Object[1];
                    c(bArr2113[172], (byte) (-bArr2113[663]), (short) TypedValues.CycleType.TYPE_WAVE_PHASE, objArr6112);
                    Class<?> cls1118 = Class.forName((String) objArr6112[0]);
                    byte b1120 = bArr2113[118];
                    Object[] objArr6113 = new Object[1];
                    c(b1120, (byte) (b1120 + 4), (short) ($$e + 5), objArr6113);
                    cls1118.getMethod((String) objArr6113[0], Long.TYPE, Long.TYPE).invoke(null, objArr6111);
                    Object[] objArr7110 = {new int[]{i1317}, strArr14, new int[1], new int[]{i1316}};
                    int i13115 = ((int[]) objArr5[2])[0];
                    int i13116 = ((int[]) objArr5[3])[0];
                    int i13117 = ((int[]) objArr5[0])[0];
                    String[] strArr110 = (String[]) objArr5[1];
                    int iCodePointAt5 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(4) - 1538211145;
                    int i13118 = ~iCodePointAt5;
                    int i13119 = i13115 + (-1159620387) + (((~((-170065955) | i13118)) | (~((-558374914) | iCodePointAt5)) | (~(738157095 | iCodePointAt5))) * 765) + ((170065954 | (~((-728440868) | i13118))) * 1530) + (((~(iCodePointAt5 | (-728440868))) | (~(i13118 | 738157095))) * 765);
                    int i14110 = (i13119 << 13) ^ i13119;
                    int i14111 = i14110 ^ (i14110 >>> 17);
                    i12 = 0;
                    ((int[]) objArr7110[2])[0] = i14111 ^ (i14111 << 5);
                }
                objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-444530678);
                if (objAccessartificialFrame7 == null) {
                    int mode8 = 26 - View.MeasureSpec.getMode(i12);
                    char cBlue3 = (char) Color.blue(i12);
                    int i14112 = 1042 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1));
                    byte[] bArr2114 = $$a;
                    Object[] objArr7111 = new Object[1];
                    b((byte) 47, bArr2114[98], bArr2114[81], objArr7111);
                    objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(mode8, cBlue3, i14112, 2061780482, false, (String) objArr7111[0], null);
                }
                j2 = ((Field) objAccessartificialFrame7).getLong(null);
                if (j2 != -1) {
                    int i14113 = artificialFrame + 43;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i14113 % 128;
                    int i14114 = i14113 % 2;
                    if (j2 + 1911 >= ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                        int i14115 = artificialFrame + 123;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i14115 % 128;
                        int i14116 = i14115 % 2;
                        objAccessartificialFrame20 = ArtificialStackFrames.accessartificialFrame(-614804952);
                        if (objAccessartificialFrame20 == null) {
                            int i14117 = (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + 26;
                            char bitsPerPixel9 = (char) ((-1) - ImageFormat.getBitsPerPixel(0));
                            int i14118 = 1041 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                            Object[] objArr7112 = new Object[1];
                            b((byte) 47, $$a[98], (byte) 57, objArr7112);
                            objAccessartificialFrame20 = ArtificialStackFrames.coroutineCreation(i14117, bitsPerPixel9, i14118, 1145017376, false, (String) objArr7112[0], null);
                        }
                        Object[] objArr7113 = (Object[]) ((Field) objAccessartificialFrame20).get(null);
                        objArrAccessartificialFrame$78cbbd35 = new Object[]{strArr15, new int[1], new int[]{i1510}, new int[]{i1419}};
                        int i14119 = ((int[]) objArr7113[3])[0];
                        int i15110 = ((int[]) objArr7113[2])[0];
                        String[] strArr111 = (String[]) objArr7113[0];
                        int i15111 = ~((~Process.myPid()) | 1040324035);
                        int i15112 = ((((939659456 | i15111) * (-374)) + 329575196) + ((i15111 | 100664579) * 374)) - 2112554579;
                        int i15113 = (i15112 << 13) ^ i15112;
                        int i15114 = i15113 ^ (i15113 >>> 17);
                        ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0] = i15114 ^ (i15114 << 5);
                    } else {
                        int iIntValue6 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
                        Object[] objArr7114 = {716904988};
                        objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-1648942878);
                        if (objAccessartificialFrame8 == null) {
                            objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 8, (char) (22252 - (android.os.SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (android.os.SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1))), 1033 - View.getDefaultSize(0, 0), 47343338, false, null, new Class[]{Integer.TYPE});
                        }
                        objArrAccessartificialFrame$78cbbd35 = CompactHashMap.Itr.accessartificialFrame$78cbbd35(iIntValue6, 0, ((Constructor) objAccessartificialFrame8).newInstance(objArr7114), -2112554579, false);
                        objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(-614804952);
                        if (objAccessartificialFrame9 == null) {
                            int threadPriority18 = 26 - ((Process.getThreadPriority(0) + 20) >> 6);
                            char doubleTapTimeout6 = (char) (ViewConfiguration.getDoubleTapTimeout() >> 16);
                            int i15115 = 1042 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1));
                            Object[] objArr7115 = new Object[1];
                            b((byte) 47, $$a[98], (byte) 57, objArr7115);
                            objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(threadPriority18, doubleTapTimeout6, i15115, 1145017376, false, (String) objArr7115[0], null);
                        }
                        ((Field) objAccessartificialFrame9).set(null, objArrAccessartificialFrame$78cbbd35);
                        Long lValueOf110 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-444530678);
                        if (objAccessartificialFrame10 == null) {
                            int bitsPerPixel10 = 25 - ImageFormat.getBitsPerPixel(0);
                            char c18 = (char) (1 - (android.os.SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (android.os.SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)));
                            int iIndexOf16 = TextUtils.indexOf((CharSequence) "", '0') + 1042;
                            byte[] bArr2115 = $$a;
                            Object[] objArr7116 = new Object[1];
                            b((byte) 47, bArr2115[98], bArr2115[81], objArr7116);
                            objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(bitsPerPixel10, c18, iIndexOf16, 2061780482, false, (String) objArr7116[0], null);
                        }
                        ((Field) objAccessartificialFrame10).set(null, lValueOf110);
                    }
                } else {
                    int iIntValue7 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
                    Object[] objArr7117 = {716904988};
                    objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-1648942878);
                    if (objAccessartificialFrame8 == null) {
                        objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 8, (char) (22252 - (android.os.SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (android.os.SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1))), 1033 - View.getDefaultSize(0, 0), 47343338, false, null, new Class[]{Integer.TYPE});
                    }
                    objArrAccessartificialFrame$78cbbd35 = CompactHashMap.Itr.accessartificialFrame$78cbbd35(iIntValue7, 0, ((Constructor) objAccessartificialFrame8).newInstance(objArr7117), -2112554579, false);
                    objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(-614804952);
                    if (objAccessartificialFrame9 == null) {
                        int threadPriority19 = 26 - ((Process.getThreadPriority(0) + 20) >> 6);
                        char doubleTapTimeout7 = (char) (ViewConfiguration.getDoubleTapTimeout() >> 16);
                        int i15116 = 1042 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1));
                        Object[] objArr7118 = new Object[1];
                        b((byte) 47, $$a[98], (byte) 57, objArr7118);
                        objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(threadPriority19, doubleTapTimeout7, i15116, 1145017376, false, (String) objArr7118[0], null);
                    }
                    ((Field) objAccessartificialFrame9).set(null, objArrAccessartificialFrame$78cbbd35);
                    Long lValueOf111 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-444530678);
                    if (objAccessartificialFrame10 == null) {
                        int bitsPerPixel11 = 25 - ImageFormat.getBitsPerPixel(0);
                        char c19 = (char) (1 - (android.os.SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (android.os.SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)));
                        int iIndexOf17 = TextUtils.indexOf((CharSequence) "", '0') + 1042;
                        byte[] bArr2116 = $$a;
                        Object[] objArr7119 = new Object[1];
                        b((byte) 47, bArr2116[98], bArr2116[81], objArr7119);
                        objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(bitsPerPixel11, c19, iIndexOf17, 2061780482, false, (String) objArr7119[0], null);
                    }
                    ((Field) objAccessartificialFrame10).set(null, lValueOf111);
                }
                i14 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
                i15 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
                if (i15 == i14) {
                    Object[] objArr8114 = {strArr16, new int[1], new int[]{i1519}, new int[]{i1518}};
                    int i15117 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
                    int i15118 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
                    int i15119 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
                    String[] strArr112 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
                    int iCodePointAt6 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(8) - 710381406;
                    int i16110 = i15117 + (((~((-809797162) | iCodePointAt6)) | 537165864) * (-283)) + 1772187958 + ((~(iCodePointAt6 | (-272631298))) * 283);
                    int i16111 = (i16110 << 13) ^ i16110;
                    int i16112 = i16111 ^ (i16111 >>> 17);
                    ((int[]) objArr8114[1])[0] = i16112 ^ (i16112 << 5);
                    i16 = 0;
                } else {
                    arrayList2 = new ArrayList();
                    strArr2 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
                    if (strArr2 != null) {
                        while (i17 < strArr2.length) {
                            arrayList2.add(str7);
                        }
                    }
                    long j15 = (((long) 936109884) << 32) ^ ((long) (i14 ^ i15));
                    long j16 = 936109886;
                    int i16113 = artificialFrame + 3;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i16113 % 128;
                    int i16114 = i16113 % 2;
                    Object[] objArr8115 = {Long.valueOf(j15), Long.valueOf(j16)};
                    byte[] bArr2117 = $$d;
                    Object[] objArr8116 = new Object[1];
                    c(bArr2117[14], bArr2117[631], (short) 463, objArr8116);
                    Class<?> cls1119 = Class.forName((String) objArr8116[0]);
                    byte b1121 = bArr2117[118];
                    Object[] objArr8117 = new Object[1];
                    c(b1121, (byte) (b1121 + 4), (short) ($$e + 5), objArr8117);
                    cls1119.getMethod((String) objArr8117[0], Long.TYPE, Long.TYPE).invoke(null, objArr8115);
                    Object[] objArr8118 = {strArr17, new int[1], new int[]{i1617}, new int[]{i1616}};
                    int i16115 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
                    int i16116 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
                    int i16117 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
                    String[] strArr113 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
                    int iMyPid4 = Process.myPid();
                    int i16118 = ~iMyPid4;
                    int i16119 = i16115 + (-1549488194) + (((~(i16118 | 490861389)) | (~(412757582 | i16118)) | (-500957008)) * 464) + (((-88199426) | iMyPid4) * (-464)) + (((~(iMyPid4 | 490861389)) | (-500957008)) * 464);
                    int i17114 = (i16119 << 13) ^ i16119;
                    int i17115 = i17114 ^ (i17114 >>> 17);
                    i16 = 0;
                    ((int[]) objArr8118[1])[0] = i17115 ^ (i17115 << 5);
                }
                super.onStart();
                objAccessartificialFrame11 = ArtificialStackFrames.accessartificialFrame(-2127922582);
                if (objAccessartificialFrame11 == null) {
                    int packedPositionType6 = ExpandableListView.getPackedPositionType(0L) + 30;
                    char cAlpha5 = (char) (49362 - Color.alpha(i16));
                    int threadPriority110 = ((Process.getThreadPriority(i16) + 20) >> 6) + 684;
                    byte[] bArr2118 = $$a;
                    Object[] objArr8119 = new Object[1];
                    b((byte) (bArr2118[96] + 1), bArr2118[94], (byte) 96, objArr8119);
                    objAccessartificialFrame11 = ArtificialStackFrames.coroutineCreation(packedPositionType6, cAlpha5, threadPriority110, 508509282, false, (String) objArr8119[0], null);
                }
                j3 = ((Field) objAccessartificialFrame11).getLong(null);
                if (j3 != -1) {
                    if (j3 + 1952 >= ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                        objAccessartificialFrame19 = ArtificialStackFrames.accessartificialFrame(777251007);
                        if (objAccessartificialFrame19 == null) {
                            int offsetAfter3 = TextUtils.getOffsetAfter("", 0) + 30;
                            char cAlpha6 = (char) (Color.alpha(0) + 49362);
                            int i17116 = 685 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1));
                            byte[] bArr2119 = $$a;
                            Object[] objArr8120 = new Object[1];
                            b(bArr2119[65], bArr2119[23], (byte) AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, objArr8120);
                            objAccessartificialFrame19 = ArtificialStackFrames.coroutineCreation(offsetAfter3, cAlpha6, i17116, -1321816393, false, (String) objArr8120[0], null);
                        }
                        Object[] objArr8121 = (Object[]) ((Field) objAccessartificialFrame19).get(null);
                        objArr6 = new Object[]{new int[]{((int[]) objArr8121[0])[0]}, new int[]{((int[]) objArr8121[1])[0]}, new int[1], (String) objArr8121[3]};
                        int i17117 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 31408613;
                        int i17118 = ~i17117;
                        int i17119 = ((((-596835844) + (((~((-61749173) | i17118)) | 33690768) * (-108))) + (((~(i17118 | 1040372947)) | ((~((-1040372948) | i17117)) | (-1068431352))) * 54)) + ((i17117 | (-1068431352)) * 54)) - 1026999532;
                        int i17120 = (i17119 << 13) ^ i17119;
                        int i17121 = i17120 ^ (i17120 >>> 17);
                        ((int[]) objArr6[2])[0] = i17121 ^ (i17121 << 5);
                    } else {
                        i18 = 0;
                    }
                    i19 = ((int[]) objArr6[1])[0];
                    i20 = ((int[]) objArr6[0])[0];
                    if (i20 == i19) {
                        int i171110 = getARTIFICIAL_FRAME_PACKAGE_NAME + 37;
                        artificialFrame = i171110 % 128;
                        int i171111 = i171110 % 2;
                        int i1811110 = ((int[]) objArr6[2])[0];
                        Object[] objArr81110 = {new int[]{((int[]) objArr6[0])[0]}, new int[]{((int[]) objArr6[1])[0]}, new int[1], (String) objArr6[3]};
                        int mode9 = ((AudioManager) ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getSystemService("audio")).getMode();
                        int i1811111 = ~mode9;
                        int i1811112 = ~((-255395344) | i1811111);
                        int i1811113 = ~((-723228432) | mode9);
                        int i1811114 = i1811110 + 910669500 + ((i1811112 | i1811113) * 1150) + (((~(723228431 | i1811111)) | i1811113) * (-575)) + (((~(mode9 | (-255395344))) | (~(i1811111 | 255395343))) * 575);
                        int i1811115 = (i1811114 << 13) ^ i1811114;
                        int i1811116 = i1811115 ^ (i1811115 >>> 17);
                        ((int[]) objArr81110[2])[0] = i1811116 ^ (i1811116 << 5);
                        i21 = 0;
                    } else {
                        Object[] objArr81111 = {Long.valueOf(((long) (i19 ^ i20)) ^ (((long) (-1295343820)) << 32)), Long.valueOf(-1295344332)};
                        byte[] bArr21110 = $$d;
                        byte b11110 = bArr21110[172];
                        byte b11111 = bArr21110[64];
                        Object[] objArr91124 = new Object[1];
                        c(b11110, b11111, (short) (b11111 | 80), objArr91124);
                        Class<?> cls11110 = Class.forName((String) objArr91124[0]);
                        byte b11112 = bArr21110[118];
                        Object[] objArr91125 = new Object[1];
                        c(b11112, (byte) (b11112 + 4), (short) ($$e + 5), objArr91125);
                        cls11110.getMethod((String) objArr91125[0], Long.TYPE, Long.TYPE).invoke(null, objArr81111);
                        int i1811117 = ((int[]) objArr6[2])[0];
                        Object[] objArr91126 = {new int[]{((int[]) objArr6[0])[0]}, new int[]{((int[]) objArr6[1])[0]}, new int[1], (String) objArr6[3]};
                        int iNextInt8 = new Random().nextInt(373309157);
                        int i1811118 = i1811117 + (-452072299) + (((~(iNextInt8 | 797858843)) | (-180764932)) * (-465)) + ((797858843 | (~((-180764932) | iNextInt8))) * 930) + ((iNextInt8 | (-4194561)) * 465);
                        int i1811119 = (i1811118 << 13) ^ i1811118;
                        int i19118 = i1811119 ^ (i1811119 >>> 17);
                        i21 = 0;
                        ((int[]) objArr91126[2])[0] = i19118 ^ (i19118 << 5);
                    }
                    objAccessartificialFrame14 = ArtificialStackFrames.accessartificialFrame(1745676544);
                    if (objAccessartificialFrame14 == null) {
                        int iResolveSizeAndState5 = 17 - View.resolveSizeAndState(i21, i21, i21);
                        char windowTouchSlop5 = (char) (ViewConfiguration.getWindowTouchSlop() >> 8);
                        int i19119 = 748 - (android.os.SystemClock.uptimeMillis() > 0L ? 1 : (android.os.SystemClock.uptimeMillis() == 0L ? 0 : -1));
                        byte[] bArr21111 = $$a;
                        Object[] objArr91127 = new Object[1];
                        b((byte) 47, bArr21111[98], bArr21111[81], objArr91127);
                        objAccessartificialFrame14 = ArtificialStackFrames.coroutineCreation(iResolveSizeAndState5, windowTouchSlop5, i19119, -144068856, false, (String) objArr91127[0], null);
                    }
                    j4 = ((Field) objAccessartificialFrame14).getLong(null);
                    if (j4 != -1) {
                        baseContext4 = getBaseContext();
                        if (baseContext4 == null) {
                            Object[] objArr9111114 = new Object[1];
                            a(27764 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), new char[]{55918, 46610, 653, 40740, 27564, 50265, 20697, 11524, 47606, 2676, 58881, 29392, 53034, 23483, 13361, 32987, 7497, 59845, 31341, 55039, 41639, 16136, 35743, 25663, 61606, 19792}, objArr9111114);
                            Class<?> cls11111 = Class.forName((String) objArr9111114[0]);
                            Object[] objArr9111115 = new Object[1];
                            a(TextUtils.indexOf("", "") + 53441, new char[]{55916, 2747, 31743, 43070, 39278, 51620, 16125, 28425, 23671, 36022, 65001, 8749, 4960, 17315, 45301, 57641, 54896, 1712}, objArr9111115);
                            baseContext4 = (Context) cls11111.getMethod((String) objArr9111115[0], new Class[0]).invoke(null, null);
                        }
                        if (baseContext4 != null) {
                            if (baseContext4 instanceof ContextWrapper) {
                                baseContext4 = baseContext4.getApplicationContext();
                            } else {
                                baseContext4 = baseContext4.getApplicationContext();
                            }
                        }
                        Object[] objArr9111116 = {baseContext4, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 1378671210};
                        byte[] bArr3114 = $$d;
                        Object[] objArr9111117 = new Object[1];
                        c(bArr3114[172], bArr3114[530], (short) 540, objArr9111117);
                        Class<?> cls11112 = Class.forName((String) objArr9111117[0]);
                        byte b11113 = (byte) (bArr3114[99] - 1);
                        Object[] objArr9111118 = new Object[1];
                        c(b11113, (byte) (b11113 | Ascii.DC2), (short) (-bArr3114[500]), objArr9111118);
                        objArr7 = (Object[]) cls11112.getMethod((String) objArr9111118[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr9111116);
                        objAccessartificialFrame15 = ArtificialStackFrames.accessartificialFrame(1575402270);
                        if (objAccessartificialFrame15 == null) {
                            int threadPriority111 = 17 - ((Process.getThreadPriority(0) + 20) >> 6);
                            char cIndexOf9 = (char) TextUtils.indexOf("", "", 0);
                            int iIndexOf18 = 746 - TextUtils.indexOf((CharSequence) "", '0');
                            Object[] objArr9111119 = new Object[1];
                            b((byte) 47, $$a[98], (byte) 57, objArr9111119);
                            objAccessartificialFrame15 = ArtificialStackFrames.coroutineCreation(threadPriority111, cIndexOf9, iIndexOf18, -1031537386, false, (String) objArr9111119[0], null);
                        }
                        ((Field) objAccessartificialFrame15).set(null, objArr7);
                        Long lValueOf112 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame16 = ArtificialStackFrames.accessartificialFrame(1745676544);
                        if (objAccessartificialFrame16 == null) {
                            int i191110 = 17 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                            char c110 = (char) (1 - (android.os.SystemClock.elapsedRealtime() > 0L ? 1 : (android.os.SystemClock.elapsedRealtime() == 0L ? 0 : -1)));
                            int i191111 = (android.os.SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (android.os.SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 746;
                            byte[] bArr3115 = $$a;
                            Object[] objArr101117 = new Object[1];
                            b((byte) 47, bArr3115[98], bArr3115[81], objArr101117);
                            objAccessartificialFrame16 = ArtificialStackFrames.coroutineCreation(i191110, c110, i191111, -144068856, false, (String) objArr101117[0], null);
                        }
                        ((Field) objAccessartificialFrame16).set(null, lValueOf112);
                    } else {
                        baseContext4 = getBaseContext();
                        if (baseContext4 == null) {
                            Object[] objArr91111110 = new Object[1];
                            a(27764 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), new char[]{55918, 46610, 653, 40740, 27564, 50265, 20697, 11524, 47606, 2676, 58881, 29392, 53034, 23483, 13361, 32987, 7497, 59845, 31341, 55039, 41639, 16136, 35743, 25663, 61606, 19792}, objArr91111110);
                            Class<?> cls11113 = Class.forName((String) objArr91111110[0]);
                            Object[] objArr91111111 = new Object[1];
                            a(TextUtils.indexOf("", "") + 53441, new char[]{55916, 2747, 31743, 43070, 39278, 51620, 16125, 28425, 23671, 36022, 65001, 8749, 4960, 17315, 45301, 57641, 54896, 1712}, objArr91111111);
                            baseContext4 = (Context) cls11113.getMethod((String) objArr91111111[0], new Class[0]).invoke(null, null);
                        }
                        if (baseContext4 != null) {
                            if (baseContext4 instanceof ContextWrapper) {
                                baseContext4 = baseContext4.getApplicationContext();
                            } else {
                                baseContext4 = baseContext4.getApplicationContext();
                            }
                        }
                        Object[] objArr91111112 = {baseContext4, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 1378671210};
                        byte[] bArr3116 = $$d;
                        Object[] objArr91111113 = new Object[1];
                        c(bArr3116[172], bArr3116[530], (short) 540, objArr91111113);
                        Class<?> cls11114 = Class.forName((String) objArr91111113[0]);
                        byte b11114 = (byte) (bArr3116[99] - 1);
                        Object[] objArr91111114 = new Object[1];
                        c(b11114, (byte) (b11114 | Ascii.DC2), (short) (-bArr3116[500]), objArr91111114);
                        objArr7 = (Object[]) cls11114.getMethod((String) objArr91111114[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr91111112);
                        objAccessartificialFrame15 = ArtificialStackFrames.accessartificialFrame(1575402270);
                        if (objAccessartificialFrame15 == null) {
                            int threadPriority112 = 17 - ((Process.getThreadPriority(0) + 20) >> 6);
                            char cIndexOf10 = (char) TextUtils.indexOf("", "", 0);
                            int iIndexOf19 = 746 - TextUtils.indexOf((CharSequence) "", '0');
                            Object[] objArr91111115 = new Object[1];
                            b((byte) 47, $$a[98], (byte) 57, objArr91111115);
                            objAccessartificialFrame15 = ArtificialStackFrames.coroutineCreation(threadPriority112, cIndexOf10, iIndexOf19, -1031537386, false, (String) objArr91111115[0], null);
                        }
                        ((Field) objAccessartificialFrame15).set(null, objArr7);
                        Long lValueOf113 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame16 = ArtificialStackFrames.accessartificialFrame(1745676544);
                        if (objAccessartificialFrame16 == null) {
                            int i191112 = 17 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                            char c111 = (char) (1 - (android.os.SystemClock.elapsedRealtime() > 0L ? 1 : (android.os.SystemClock.elapsedRealtime() == 0L ? 0 : -1)));
                            int i191113 = (android.os.SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (android.os.SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 746;
                            byte[] bArr3117 = $$a;
                            Object[] objArr101118 = new Object[1];
                            b((byte) 47, bArr3117[98], bArr3117[81], objArr101118);
                            objAccessartificialFrame16 = ArtificialStackFrames.coroutineCreation(i191112, c111, i191113, -144068856, false, (String) objArr101118[0], null);
                        }
                        ((Field) objAccessartificialFrame16).set(null, lValueOf113);
                    }
                    i22 = ((int[]) objArr7[4])[0];
                    i23 = ((int[]) objArr7[3])[0];
                    if (i23 == i22) {
                        int i201117 = artificialFrame + 123;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i201117 % 128;
                        int i201118 = i201117 % 2;
                        Object[] objArr101119 = {list15, new int[1], list16, new int[]{i201111}, new int[]{i201112}};
                        int i201119 = ((int[]) objArr7[1])[0];
                        int i2011110 = ((int[]) objArr7[3])[0];
                        int i2011111 = ((int[]) objArr7[4])[0];
                        List list19 = (List) objArr7[0];
                        List list110 = (List) objArr7[2];
                        int i2011112 = ~((~Process.myUid()) | 96621351);
                        int i2011113 = i201119 + (((25313797 | i2011112) * (-970)) - 1058822873) + ((i2011112 | 71307554) * 970);
                        int i2011114 = (i2011113 << 13) ^ i2011113;
                        int i2011115 = i2011114 ^ (i2011114 >>> 17);
                        ((int[]) objArr101119[1])[0] = i2011115 ^ (i2011115 << 5);
                        return;
                    }
                    ArrayList arrayList8 = new ArrayList();
                    Object[] objArr1011110 = {objArr7};
                    objAccessartificialFrame17 = ArtificialStackFrames.accessartificialFrame(1804664566);
                    if (objAccessartificialFrame17 == null) {
                        objAccessartificialFrame17 = ArtificialStackFrames.coroutineCreation(40 - MotionEvent.axisFromString(""), (char) ((Process.myTid() >> 22) + 12468), View.getDefaultSize(0, 0) + 3642, -185222914, false, "coroutineCreation", new Class[]{Object[].class});
                    }
                    arrayList8.add(((Method) objAccessartificialFrame17).invoke(null, objArr1011110));
                    Object[] objArr1011111 = {objArr7};
                    objAccessartificialFrame18 = ArtificialStackFrames.accessartificialFrame(-1243809191);
                    if (objAccessartificialFrame18 == null) {
                        objAccessartificialFrame18 = ArtificialStackFrames.coroutineCreation(42 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 12467), TextUtils.indexOf((CharSequence) "", '0', 0) + 3643, 716815441, false, "ArtificialStackFrames", new Class[]{Object[].class});
                    }
                    arrayList8.add(((Method) objAccessartificialFrame18).invoke(null, objArr1011111));
                    Object[] objArr1011112 = {Long.valueOf((((long) (-1097680825)) << 32) ^ ((long) (i22 ^ i23))), Long.valueOf(-1097680817)};
                    byte[] bArr3118 = $$d;
                    byte b11115 = bArr3118[172];
                    byte b210 = bArr3118[87];
                    Object[] objArr1011113 = new Object[1];
                    c(b11115, b210, (short) (b210 | 578), objArr1011113);
                    Class<?> cls11115 = Class.forName((String) objArr1011113[0]);
                    byte b211 = bArr3118[118];
                    Object[] objArr1011114 = new Object[1];
                    c(b211, (byte) (b211 + 4), (short) ($$e + 5), objArr1011114);
                    cls11115.getMethod((String) objArr1011114[0], Long.TYPE, Long.TYPE).invoke(null, objArr1011112);
                    Object[] objArr1011115 = {list17, new int[1], list18, new int[]{i21115}, new int[]{i21116}};
                    int i211111 = ((int[]) objArr7[1])[0];
                    int i211112 = ((int[]) objArr7[3])[0];
                    int i211113 = ((int[]) objArr7[4])[0];
                    List list111 = (List) objArr7[0];
                    List list112 = (List) objArr7[2];
                    int length7 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 682201691;
                    int i211114 = ~length7;
                    int i211115 = i211111 + (((~(41798803 | i211114)) | (~((-647247262) | length7)) | (~(i211114 | 647247261))) * 959) + 1742647508 + (((~(length7 | 647247261)) | (~(i211114 | (-647247262))) | (~(41798803 | length7))) * 959);
                    int i211116 = (i211115 << 13) ^ i211115;
                    int i211117 = i211116 ^ (i211116 >>> 17);
                    ((int[]) objArr1011115[1])[0] = i211117 ^ (i211117 << 5);
                    return;
                }
                i18 = 0;
                baseContext3 = getBaseContext();
                if (baseContext3 == null) {
                    Object[] objArr1115 = new Object[1];
                    a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[i18]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(i18, 4).codePointAt(3) + 27648, new char[]{55918, 46610, 653, 40740, 27564, 50265, 20697, 11524, 47606, 2676, 58881, 29392, 53034, 23483, 13361, 32987, 7497, 59845, 31341, 55039, 41639, 16136, 35743, 25663, 61606, 19792}, objArr1115);
                    Class<?> cls122 = Class.forName((String) objArr1115[i18]);
                    Object[] objArr1116 = new Object[1];
                    a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[i18]).invoke(null, null)).getApplicationContext().getPackageName().length() + 53420, new char[]{55916, 2747, 31743, 43070, 39278, 51620, 16125, 28425, 23671, 36022, 65001, 8749, 4960, 17315, 45301, 57641, 54896, 1712}, objArr1116);
                    baseContext3 = (Context) cls122.getMethod((String) objArr1116[0], new Class[0]).invoke(null, null);
                }
                if (baseContext3 != null) {
                    if (baseContext3 instanceof ContextWrapper) {
                        int i2123 = artificialFrame + 51;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i2123 % 128;
                        int i2124 = i2123 % 2;
                        if (((ContextWrapper) baseContext3).getBaseContext() != null) {
                            baseContext3 = baseContext3.getApplicationContext();
                        } else {
                            baseContext3 = null;
                        }
                    } else {
                        baseContext3 = baseContext3.getApplicationContext();
                    }
                }
                Object[] objArr1117 = {baseContext3, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), -1026999532};
                byte[] bArr3119 = $$d;
                Object[] objArr1118 = new Object[1];
                c(bArr3119[9], bArr3119[128], (short) TypedValues.PositionType.TYPE_PERCENT_X, objArr1118);
                Class<?> cls123 = Class.forName((String) objArr1118[0]);
                Object[] objArr1119 = new Object[1];
                c(bArr3119[218], bArr3119[171], (short) 405, objArr1119);
                objArr6 = (Object[]) cls123.getMethod((String) objArr1119[0], Context.class, Integer.TYPE, Integer.TYPE).invoke(null, objArr1117);
                if (baseContext3 != null) {
                    objAccessartificialFrame12 = ArtificialStackFrames.accessartificialFrame(777251007);
                    if (objAccessartificialFrame12 == null) {
                        int iRed6 = 30 - Color.red(0);
                        char deadChar5 = (char) (KeyEvent.getDeadChar(0, 0) + 49362);
                        int iArgb3 = Color.argb(0, 0, 0, 0) + 684;
                        byte[] bArr3120 = $$a;
                        Object[] objArr1212 = new Object[1];
                        b(bArr3120[65], bArr3120[23], (byte) AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, objArr1212);
                        objAccessartificialFrame12 = ArtificialStackFrames.coroutineCreation(iRed6, deadChar5, iArgb3, -1321816393, false, (String) objArr1212[0], null);
                    }
                    ((Field) objAccessartificialFrame12).set(null, objArr6);
                    Long lValueOf114 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame13 = ArtificialStackFrames.accessartificialFrame(-2127922582);
                    if (objAccessartificialFrame13 == null) {
                        int i2125 = (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 29;
                        char c112 = (char) (49361 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)));
                        int iRed7 = 684 - Color.red(0);
                        byte[] bArr3121 = $$a;
                        Object[] objArr1213 = new Object[1];
                        b((byte) (bArr3121[96] + 1), bArr3121[94], (byte) 96, objArr1213);
                        objAccessartificialFrame13 = ArtificialStackFrames.coroutineCreation(i2125, c112, iRed7, 508509282, false, (String) objArr1213[0], null);
                    }
                    ((Field) objAccessartificialFrame13).set(null, lValueOf114);
                }
                i19 = ((int[]) objArr6[1])[0];
                i20 = ((int[]) objArr6[0])[0];
                if (i20 == i19) {
                    int i171112 = getARTIFICIAL_FRAME_PACKAGE_NAME + 37;
                    artificialFrame = i171112 % 128;
                    int i171113 = i171112 % 2;
                    int i18111110 = ((int[]) objArr6[2])[0];
                    Object[] objArr81112 = {new int[]{((int[]) objArr6[0])[0]}, new int[]{((int[]) objArr6[1])[0]}, new int[1], (String) objArr6[3]};
                    int mode10 = ((AudioManager) ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getSystemService("audio")).getMode();
                    int i18111111 = ~mode10;
                    int i18111112 = ~((-255395344) | i18111111);
                    int i18111113 = ~((-723228432) | mode10);
                    int i18111114 = i18111110 + 910669500 + ((i18111112 | i18111113) * 1150) + (((~(723228431 | i18111111)) | i18111113) * (-575)) + (((~(mode10 | (-255395344))) | (~(i18111111 | 255395343))) * 575);
                    int i18111115 = (i18111114 << 13) ^ i18111114;
                    int i18111116 = i18111115 ^ (i18111115 >>> 17);
                    ((int[]) objArr81112[2])[0] = i18111116 ^ (i18111116 << 5);
                    i21 = 0;
                } else {
                    Object[] objArr81113 = {Long.valueOf(((long) (i19 ^ i20)) ^ (((long) (-1295343820)) << 32)), Long.valueOf(-1295344332)};
                    byte[] bArr21112 = $$d;
                    byte b11116 = bArr21112[172];
                    byte b11117 = bArr21112[64];
                    Object[] objArr91128 = new Object[1];
                    c(b11116, b11117, (short) (b11117 | 80), objArr91128);
                    Class<?> cls11116 = Class.forName((String) objArr91128[0]);
                    byte b11118 = bArr21112[118];
                    Object[] objArr91129 = new Object[1];
                    c(b11118, (byte) (b11118 + 4), (short) ($$e + 5), objArr91129);
                    cls11116.getMethod((String) objArr91129[0], Long.TYPE, Long.TYPE).invoke(null, objArr81113);
                    int i18111117 = ((int[]) objArr6[2])[0];
                    Object[] objArr911210 = {new int[]{((int[]) objArr6[0])[0]}, new int[]{((int[]) objArr6[1])[0]}, new int[1], (String) objArr6[3]};
                    int iNextInt9 = new Random().nextInt(373309157);
                    int i18111118 = i18111117 + (-452072299) + (((~(iNextInt9 | 797858843)) | (-180764932)) * (-465)) + ((797858843 | (~((-180764932) | iNextInt9))) * 930) + ((iNextInt9 | (-4194561)) * 465);
                    int i18111119 = (i18111118 << 13) ^ i18111118;
                    int i191114 = i18111119 ^ (i18111119 >>> 17);
                    i21 = 0;
                    ((int[]) objArr911210[2])[0] = i191114 ^ (i191114 << 5);
                }
                objAccessartificialFrame14 = ArtificialStackFrames.accessartificialFrame(1745676544);
                if (objAccessartificialFrame14 == null) {
                    int iResolveSizeAndState6 = 17 - View.resolveSizeAndState(i21, i21, i21);
                    char windowTouchSlop6 = (char) (ViewConfiguration.getWindowTouchSlop() >> 8);
                    int i191115 = 748 - (android.os.SystemClock.uptimeMillis() > 0L ? 1 : (android.os.SystemClock.uptimeMillis() == 0L ? 0 : -1));
                    byte[] bArr21113 = $$a;
                    Object[] objArr911211 = new Object[1];
                    b((byte) 47, bArr21113[98], bArr21113[81], objArr911211);
                    objAccessartificialFrame14 = ArtificialStackFrames.coroutineCreation(iResolveSizeAndState6, windowTouchSlop6, i191115, -144068856, false, (String) objArr911211[0], null);
                }
                j4 = ((Field) objAccessartificialFrame14).getLong(null);
                if (j4 != -1) {
                    baseContext4 = getBaseContext();
                    if (baseContext4 == null) {
                        Object[] objArr91111116 = new Object[1];
                        a(27764 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), new char[]{55918, 46610, 653, 40740, 27564, 50265, 20697, 11524, 47606, 2676, 58881, 29392, 53034, 23483, 13361, 32987, 7497, 59845, 31341, 55039, 41639, 16136, 35743, 25663, 61606, 19792}, objArr91111116);
                        Class<?> cls11117 = Class.forName((String) objArr91111116[0]);
                        Object[] objArr91111117 = new Object[1];
                        a(TextUtils.indexOf("", "") + 53441, new char[]{55916, 2747, 31743, 43070, 39278, 51620, 16125, 28425, 23671, 36022, 65001, 8749, 4960, 17315, 45301, 57641, 54896, 1712}, objArr91111117);
                        baseContext4 = (Context) cls11117.getMethod((String) objArr91111117[0], new Class[0]).invoke(null, null);
                    }
                    if (baseContext4 != null) {
                        if (baseContext4 instanceof ContextWrapper) {
                            baseContext4 = baseContext4.getApplicationContext();
                        } else {
                            baseContext4 = baseContext4.getApplicationContext();
                        }
                    }
                    Object[] objArr91111118 = {baseContext4, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 1378671210};
                    byte[] bArr31110 = $$d;
                    Object[] objArr91111119 = new Object[1];
                    c(bArr31110[172], bArr31110[530], (short) 540, objArr91111119);
                    Class<?> cls11118 = Class.forName((String) objArr91111119[0]);
                    byte b11119 = (byte) (bArr31110[99] - 1);
                    Object[] objArr911111110 = new Object[1];
                    c(b11119, (byte) (b11119 | Ascii.DC2), (short) (-bArr31110[500]), objArr911111110);
                    objArr7 = (Object[]) cls11118.getMethod((String) objArr911111110[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr91111118);
                    objAccessartificialFrame15 = ArtificialStackFrames.accessartificialFrame(1575402270);
                    if (objAccessartificialFrame15 == null) {
                        int threadPriority113 = 17 - ((Process.getThreadPriority(0) + 20) >> 6);
                        char cIndexOf11 = (char) TextUtils.indexOf("", "", 0);
                        int iIndexOf110 = 746 - TextUtils.indexOf((CharSequence) "", '0');
                        Object[] objArr911111111 = new Object[1];
                        b((byte) 47, $$a[98], (byte) 57, objArr911111111);
                        objAccessartificialFrame15 = ArtificialStackFrames.coroutineCreation(threadPriority113, cIndexOf11, iIndexOf110, -1031537386, false, (String) objArr911111111[0], null);
                    }
                    ((Field) objAccessartificialFrame15).set(null, objArr7);
                    Long lValueOf115 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame16 = ArtificialStackFrames.accessartificialFrame(1745676544);
                    if (objAccessartificialFrame16 == null) {
                        int i191116 = 17 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                        char c113 = (char) (1 - (android.os.SystemClock.elapsedRealtime() > 0L ? 1 : (android.os.SystemClock.elapsedRealtime() == 0L ? 0 : -1)));
                        int i191117 = (android.os.SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (android.os.SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 746;
                        byte[] bArr31111 = $$a;
                        Object[] objArr1011116 = new Object[1];
                        b((byte) 47, bArr31111[98], bArr31111[81], objArr1011116);
                        objAccessartificialFrame16 = ArtificialStackFrames.coroutineCreation(i191116, c113, i191117, -144068856, false, (String) objArr1011116[0], null);
                    }
                    ((Field) objAccessartificialFrame16).set(null, lValueOf115);
                } else {
                    baseContext4 = getBaseContext();
                    if (baseContext4 == null) {
                        Object[] objArr911111112 = new Object[1];
                        a(27764 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), new char[]{55918, 46610, 653, 40740, 27564, 50265, 20697, 11524, 47606, 2676, 58881, 29392, 53034, 23483, 13361, 32987, 7497, 59845, 31341, 55039, 41639, 16136, 35743, 25663, 61606, 19792}, objArr911111112);
                        Class<?> cls11119 = Class.forName((String) objArr911111112[0]);
                        Object[] objArr911111113 = new Object[1];
                        a(TextUtils.indexOf("", "") + 53441, new char[]{55916, 2747, 31743, 43070, 39278, 51620, 16125, 28425, 23671, 36022, 65001, 8749, 4960, 17315, 45301, 57641, 54896, 1712}, objArr911111113);
                        baseContext4 = (Context) cls11119.getMethod((String) objArr911111113[0], new Class[0]).invoke(null, null);
                    }
                    if (baseContext4 != null) {
                        if (baseContext4 instanceof ContextWrapper) {
                            baseContext4 = baseContext4.getApplicationContext();
                        } else {
                            baseContext4 = baseContext4.getApplicationContext();
                        }
                    }
                    Object[] objArr911111114 = {baseContext4, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 1378671210};
                    byte[] bArr31112 = $$d;
                    Object[] objArr911111115 = new Object[1];
                    c(bArr31112[172], bArr31112[530], (short) 540, objArr911111115);
                    Class<?> cls111110 = Class.forName((String) objArr911111115[0]);
                    byte b111110 = (byte) (bArr31112[99] - 1);
                    Object[] objArr911111116 = new Object[1];
                    c(b111110, (byte) (b111110 | Ascii.DC2), (short) (-bArr31112[500]), objArr911111116);
                    objArr7 = (Object[]) cls111110.getMethod((String) objArr911111116[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr911111114);
                    objAccessartificialFrame15 = ArtificialStackFrames.accessartificialFrame(1575402270);
                    if (objAccessartificialFrame15 == null) {
                        int threadPriority114 = 17 - ((Process.getThreadPriority(0) + 20) >> 6);
                        char cIndexOf12 = (char) TextUtils.indexOf("", "", 0);
                        int iIndexOf111 = 746 - TextUtils.indexOf((CharSequence) "", '0');
                        Object[] objArr911111117 = new Object[1];
                        b((byte) 47, $$a[98], (byte) 57, objArr911111117);
                        objAccessartificialFrame15 = ArtificialStackFrames.coroutineCreation(threadPriority114, cIndexOf12, iIndexOf111, -1031537386, false, (String) objArr911111117[0], null);
                    }
                    ((Field) objAccessartificialFrame15).set(null, objArr7);
                    Long lValueOf116 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame16 = ArtificialStackFrames.accessartificialFrame(1745676544);
                    if (objAccessartificialFrame16 == null) {
                        int i191118 = 17 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                        char c114 = (char) (1 - (android.os.SystemClock.elapsedRealtime() > 0L ? 1 : (android.os.SystemClock.elapsedRealtime() == 0L ? 0 : -1)));
                        int i191119 = (android.os.SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (android.os.SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 746;
                        byte[] bArr31113 = $$a;
                        Object[] objArr1011117 = new Object[1];
                        b((byte) 47, bArr31113[98], bArr31113[81], objArr1011117);
                        objAccessartificialFrame16 = ArtificialStackFrames.coroutineCreation(i191118, c114, i191119, -144068856, false, (String) objArr1011117[0], null);
                    }
                    ((Field) objAccessartificialFrame16).set(null, lValueOf116);
                }
                i22 = ((int[]) objArr7[4])[0];
                i23 = ((int[]) objArr7[3])[0];
                if (i23 == i22) {
                    int i2011116 = artificialFrame + 123;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i2011116 % 128;
                    int i2011117 = i2011116 % 2;
                    Object[] objArr1011118 = {list19, new int[1], list110, new int[]{i2011110}, new int[]{i2011111}};
                    int i2011118 = ((int[]) objArr7[1])[0];
                    int i2011119 = ((int[]) objArr7[3])[0];
                    int i20111110 = ((int[]) objArr7[4])[0];
                    List list113 = (List) objArr7[0];
                    List list114 = (List) objArr7[2];
                    int i20111111 = ~((~Process.myUid()) | 96621351);
                    int i20111112 = i2011118 + (((25313797 | i20111111) * (-970)) - 1058822873) + ((i20111111 | 71307554) * 970);
                    int i20111113 = (i20111112 << 13) ^ i20111112;
                    int i20111114 = i20111113 ^ (i20111113 >>> 17);
                    ((int[]) objArr1011118[1])[0] = i20111114 ^ (i20111114 << 5);
                    return;
                }
                ArrayList arrayList9 = new ArrayList();
                Object[] objArr1011119 = {objArr7};
                objAccessartificialFrame17 = ArtificialStackFrames.accessartificialFrame(1804664566);
                if (objAccessartificialFrame17 == null) {
                    objAccessartificialFrame17 = ArtificialStackFrames.coroutineCreation(40 - MotionEvent.axisFromString(""), (char) ((Process.myTid() >> 22) + 12468), View.getDefaultSize(0, 0) + 3642, -185222914, false, "coroutineCreation", new Class[]{Object[].class});
                }
                arrayList9.add(((Method) objAccessartificialFrame17).invoke(null, objArr1011119));
                Object[] objArr10111110 = {objArr7};
                objAccessartificialFrame18 = ArtificialStackFrames.accessartificialFrame(-1243809191);
                if (objAccessartificialFrame18 == null) {
                    objAccessartificialFrame18 = ArtificialStackFrames.coroutineCreation(42 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 12467), TextUtils.indexOf((CharSequence) "", '0', 0) + 3643, 716815441, false, "ArtificialStackFrames", new Class[]{Object[].class});
                }
                arrayList9.add(((Method) objAccessartificialFrame18).invoke(null, objArr10111110));
                Object[] objArr10111111 = {Long.valueOf((((long) (-1097680825)) << 32) ^ ((long) (i22 ^ i23))), Long.valueOf(-1097680817)};
                byte[] bArr31114 = $$d;
                byte b111111 = bArr31114[172];
                byte b212 = bArr31114[87];
                Object[] objArr10111112 = new Object[1];
                c(b111111, b212, (short) (b212 | 578), objArr10111112);
                Class<?> cls111111 = Class.forName((String) objArr10111112[0]);
                byte b213 = bArr31114[118];
                Object[] objArr10111113 = new Object[1];
                c(b213, (byte) (b213 + 4), (short) ($$e + 5), objArr10111113);
                cls111111.getMethod((String) objArr10111113[0], Long.TYPE, Long.TYPE).invoke(null, objArr10111111);
                Object[] objArr10111114 = {list111, new int[1], list112, new int[]{i211112}, new int[]{i211113}};
                int i211118 = ((int[]) objArr7[1])[0];
                int i211119 = ((int[]) objArr7[3])[0];
                int i2111110 = ((int[]) objArr7[4])[0];
                List list115 = (List) objArr7[0];
                List list116 = (List) objArr7[2];
                int length8 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 682201691;
                int i2111111 = ~length8;
                int i2111112 = i211118 + (((~(41798803 | i2111111)) | (~((-647247262) | length8)) | (~(i2111111 | 647247261))) * 959) + 1742647508 + (((~(length8 | 647247261)) | (~(i2111111 | (-647247262))) | (~(41798803 | length8))) * 959);
                int i2111113 = (i2111112 << 13) ^ i2111112;
                int i2111114 = i2111113 ^ (i2111113 >>> 17);
                ((int[]) objArr10111114[1])[0] = i2111114 ^ (i2111114 << 5);
                return;
            }
            i7 = 0;
            baseContext2 = getBaseContext();
            if (baseContext2 == null) {
                Object[] objArr1214 = new Object[1];
                a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[i7]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(i7, 4).codePointAt(i7) + 27726, new char[]{55918, 46610, 653, 40740, 27564, 50265, 20697, 11524, 47606, 2676, 58881, 29392, 53034, 23483, 13361, 32987, 7497, 59845, 31341, 55039, 41639, 16136, 35743, 25663, 61606, 19792}, objArr1214);
                Class<?> cls23 = Class.forName((String) objArr1214[i7]);
                Object[] objArr1215 = new Object[1];
                a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[i7]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(i7, 4).codePointAt(1) + 53392, new char[]{55916, 2747, 31743, 43070, 39278, 51620, 16125, 28425, 23671, 36022, 65001, 8749, 4960, 17315, 45301, 57641, 54896, 1712}, objArr1215);
                baseContext2 = (Context) cls23.getMethod((String) objArr1215[i7], new Class[i7]).invoke(null, null);
            }
            if (baseContext2 != null) {
                if (!(baseContext2 instanceof ContextWrapper)) {
                    baseContext2 = baseContext2.getApplicationContext();
                } else {
                    baseContext2 = baseContext2.getApplicationContext();
                }
            }
            int iIntValue8 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
            Object[] objArr1216 = new Object[1];
            a((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 8221, new char[]{55913, 64035, 39426, 47722, 23112, 31483, 6855, 15091, 55940, 64307, 39704, 47953, 23395, 31552, 7073, 15322, 56250, 64390, 38963, 47133, 22654, 30807, 6217, 14578, 55424, 63675, 39118, 47408, 22855, 31102, 6412, 14826, 55753, 63879, 39392, 47516, 24099, 32344, 7800, 15874, 57015, 65225, 40619, 48869, 24267, 32546, 8026, 16236, 57113, 65507, 40900, 49151, 24530, 31802, 7207, 15445, 56423, 64537, 40188, 48325, 23796, 31877, 7533, 15647}, objArr1216);
            String str9 = (String) objArr1216[0];
            Object[] objArr1217 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 22279, new char[]{55866, 36147, 29820, 57163, 34374, 26974, 53373, 47990, 25190, 54613, 48212, 26388, 52925, 45491, 6385, 50067, 43660, 7554, 50424, 44987, 5810, 63886, 41160, 2963, 62270, 23080, 3367, 62484, 24415, 1541, 59687, 20584, 15194, 57943, 21835, 15548, 59318, 20217, 12744, 39063, 17294, 11006, 40436, 17636, 12248, 38608, 31170, 8504, 34856, 29479, 55880, 36184, 29777, 57133, 34411, 26980, 53253, 47901, 25161, 54709, 48299, 26609, 52931, 45535}, objArr1217);
            Object[] objArr1218 = {baseContext2, new String[]{str9, (String) objArr1217[0]}, Integer.valueOf(iIntValue8), 1, 367240422};
            byte[] bArr44 = $$d;
            byte b214 = bArr44[172];
            byte b215 = bArr44[75];
            Object[] objArr1219 = new Object[1];
            c(b214, b215, (short) (b215 | 324), objArr1219);
            Class<?> cls24 = Class.forName((String) objArr1219[0]);
            Object[] objArr1220 = new Object[1];
            c(bArr44[218], bArr44[171], (short) 405, objArr1220);
            objArr5 = (Object[]) cls24.getMethod((String) objArr1220[0], Context.class, String[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr1218);
            int i222 = ((int[]) objArr5[0])[0];
            int i223 = ((int[]) objArr5[3])[0];
            if (baseContext2 != null) {
                i8 = getARTIFICIAL_FRAME_PACKAGE_NAME + 35;
                artificialFrame = i8 % 128;
                if (i8 % 2 == 0) {
                    objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(1142731807);
                    if (objAccessartificialFrame6 == null) {
                        int mode11 = View.MeasureSpec.getMode(0) + 21;
                        char fadingEdgeLength4 = (char) (ViewConfiguration.getFadingEdgeLength() >> 16);
                        int fadingEdgeLength5 = 465 - (ViewConfiguration.getFadingEdgeLength() >> 16);
                        Object[] objArr1221 = new Object[1];
                        b((byte) 47, $$a[98], (byte) 57, objArr1221);
                        objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(mode11, fadingEdgeLength4, fadingEdgeLength5, -612765161, false, (String) objArr1221[0], null);
                    }
                    ((Field) objAccessartificialFrame6).set(null, objArr5);
                    lValueOf = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[1])).longValue());
                    objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(1313006081);
                    if (objAccessartificialFrame5 == null) {
                        iAxisFromString = Color.green(0) + 21;
                        packedPositionType = (char) Color.red(0);
                        touchSlop = 466 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1));
                        i9 = -785931255;
                        z = false;
                        byte[] bArr45 = $$a;
                        Object[] objArr134 = new Object[1];
                        b((byte) 47, bArr45[98], bArr45[81], objArr134);
                        obj3 = objArr134[0];
                        objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(iAxisFromString, packedPositionType, touchSlop, i9, z, (String) obj3, null);
                    }
                } else {
                    objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1142731807);
                    if (objAccessartificialFrame4 == null) {
                        int iMyPid5 = (Process.myPid() >> 22) + 21;
                        char cResolveSizeAndState2 = (char) View.resolveSizeAndState(0, 0, 0);
                        int packedPositionType7 = 465 - ExpandableListView.getPackedPositionType(0L);
                        Object[] objArr135 = new Object[1];
                        b((byte) 47, $$a[98], (byte) 57, objArr135);
                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(iMyPid5, cResolveSizeAndState2, packedPositionType7, -612765161, false, (String) objArr135[0], null);
                    }
                    ((Field) objAccessartificialFrame4).set(null, objArr5);
                    lValueOf = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(1313006081);
                    if (objAccessartificialFrame5 == null) {
                        iAxisFromString = 20 - MotionEvent.axisFromString("");
                        packedPositionType = (char) ExpandableListView.getPackedPositionType(0L);
                        touchSlop = (ViewConfiguration.getTouchSlop() >> 8) + 465;
                        i9 = -785931255;
                        z = false;
                        byte[] bArr46 = $$a;
                        Object[] objArr136 = new Object[1];
                        b((byte) 47, bArr46[98], bArr46[81], objArr136);
                        obj3 = objArr136[0];
                        objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(iAxisFromString, packedPositionType, touchSlop, i9, z, (String) obj3, null);
                    }
                }
                ((Field) objAccessartificialFrame5).set(null, lValueOf);
            }
            c = 0;
            i10 = ((int[]) objArr5[c])[c];
            i11 = ((int[]) objArr5[3])[c];
            if (i11 == i10) {
                Object[] objArr6114 = new Object[4];
                int[] iArr7 = new int[1];
                objArr6114[c] = iArr7;
                objArr6114[2] = new int[1];
                int[] iArr8 = new int[1];
                objArr6114[3] = iArr8;
                int i12111 = ((int[]) objArr5[2])[c];
                int i131110 = ((int[]) objArr5[3])[c];
                int i131111 = ((int[]) objArr5[c])[c];
                String[] strArr114 = (String[]) objArr5[1];
                iArr8[c] = i131110;
                iArr7[c] = i131111;
                int iNextInt10 = new Random().nextInt();
                int i131112 = i12111 + ((((~(882342990 | iNextInt10)) | (-179389987)) * 262) - 1884806911) + (((~((~iNextInt10) | 882342990)) | (-179389987)) * 262);
                int i131113 = (i131112 << 13) ^ i131112;
                int i131114 = i131113 ^ (i131113 >>> 17);
                ((int[]) objArr6114[2])[0] = i131114 ^ (i131114 << 5);
                objArr6114[1] = strArr114;
                i12 = 0;
            } else {
                arrayList = new ArrayList();
                strArr = (String[]) objArr5[1];
                if (strArr != null) {
                    while (i13 < strArr.length) {
                        arrayList.add(str6);
                    }
                }
                Object[] objArr6115 = {Long.valueOf(((long) (i10 ^ i11)) ^ (((long) 2070308745) << 32)), Long.valueOf(2070308809)};
                byte[] bArr21114 = $$d;
                Object[] objArr6116 = new Object[1];
                c(bArr21114[172], (byte) (-bArr21114[663]), (short) TypedValues.CycleType.TYPE_WAVE_PHASE, objArr6116);
                Class<?> cls11120 = Class.forName((String) objArr6116[0]);
                byte b1122 = bArr21114[118];
                Object[] objArr6117 = new Object[1];
                c(b1122, (byte) (b1122 + 4), (short) ($$e + 5), objArr6117);
                cls11120.getMethod((String) objArr6117[0], Long.TYPE, Long.TYPE).invoke(null, objArr6115);
                Object[] objArr71110 = {new int[]{i13117}, strArr110, new int[1], new int[]{i13116}};
                int i131115 = ((int[]) objArr5[2])[0];
                int i131116 = ((int[]) objArr5[3])[0];
                int i131117 = ((int[]) objArr5[0])[0];
                String[] strArr115 = (String[]) objArr5[1];
                int iCodePointAt7 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(4) - 1538211145;
                int i131118 = ~iCodePointAt7;
                int i131119 = i131115 + (-1159620387) + (((~((-170065955) | i131118)) | (~((-558374914) | iCodePointAt7)) | (~(738157095 | iCodePointAt7))) * 765) + ((170065954 | (~((-728440868) | i131118))) * 1530) + (((~(iCodePointAt7 | (-728440868))) | (~(i131118 | 738157095))) * 765);
                int i141110 = (i131119 << 13) ^ i131119;
                int i141111 = i141110 ^ (i141110 >>> 17);
                i12 = 0;
                ((int[]) objArr71110[2])[0] = i141111 ^ (i141111 << 5);
            }
            objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-444530678);
            if (objAccessartificialFrame7 == null) {
                int mode12 = 26 - View.MeasureSpec.getMode(i12);
                char cBlue4 = (char) Color.blue(i12);
                int i141112 = 1042 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1));
                byte[] bArr21115 = $$a;
                Object[] objArr71111 = new Object[1];
                b((byte) 47, bArr21115[98], bArr21115[81], objArr71111);
                objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(mode12, cBlue4, i141112, 2061780482, false, (String) objArr71111[0], null);
            }
            j2 = ((Field) objAccessartificialFrame7).getLong(null);
            if (j2 != -1) {
                int i141113 = artificialFrame + 43;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i141113 % 128;
                int i141114 = i141113 % 2;
                if (j2 + 1911 >= ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                    int i141115 = artificialFrame + 123;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i141115 % 128;
                    int i141116 = i141115 % 2;
                    objAccessartificialFrame20 = ArtificialStackFrames.accessartificialFrame(-614804952);
                    if (objAccessartificialFrame20 == null) {
                        int i141117 = (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + 26;
                        char bitsPerPixel12 = (char) ((-1) - ImageFormat.getBitsPerPixel(0));
                        int i141118 = 1041 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                        Object[] objArr71112 = new Object[1];
                        b((byte) 47, $$a[98], (byte) 57, objArr71112);
                        objAccessartificialFrame20 = ArtificialStackFrames.coroutineCreation(i141117, bitsPerPixel12, i141118, 1145017376, false, (String) objArr71112[0], null);
                    }
                    Object[] objArr71113 = (Object[]) ((Field) objAccessartificialFrame20).get(null);
                    objArrAccessartificialFrame$78cbbd35 = new Object[]{strArr111, new int[1], new int[]{i15110}, new int[]{i14119}};
                    int i141119 = ((int[]) objArr71113[3])[0];
                    int i151110 = ((int[]) objArr71113[2])[0];
                    String[] strArr116 = (String[]) objArr71113[0];
                    int i151111 = ~((~Process.myPid()) | 1040324035);
                    int i151112 = ((((939659456 | i151111) * (-374)) + 329575196) + ((i151111 | 100664579) * 374)) - 2112554579;
                    int i151113 = (i151112 << 13) ^ i151112;
                    int i151114 = i151113 ^ (i151113 >>> 17);
                    ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0] = i151114 ^ (i151114 << 5);
                } else {
                    int iIntValue9 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
                    Object[] objArr71114 = {716904988};
                    objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-1648942878);
                    if (objAccessartificialFrame8 == null) {
                        objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 8, (char) (22252 - (android.os.SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (android.os.SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1))), 1033 - View.getDefaultSize(0, 0), 47343338, false, null, new Class[]{Integer.TYPE});
                    }
                    objArrAccessartificialFrame$78cbbd35 = CompactHashMap.Itr.accessartificialFrame$78cbbd35(iIntValue9, 0, ((Constructor) objAccessartificialFrame8).newInstance(objArr71114), -2112554579, false);
                    objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(-614804952);
                    if (objAccessartificialFrame9 == null) {
                        int threadPriority115 = 26 - ((Process.getThreadPriority(0) + 20) >> 6);
                        char doubleTapTimeout8 = (char) (ViewConfiguration.getDoubleTapTimeout() >> 16);
                        int i151115 = 1042 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1));
                        Object[] objArr71115 = new Object[1];
                        b((byte) 47, $$a[98], (byte) 57, objArr71115);
                        objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(threadPriority115, doubleTapTimeout8, i151115, 1145017376, false, (String) objArr71115[0], null);
                    }
                    ((Field) objAccessartificialFrame9).set(null, objArrAccessartificialFrame$78cbbd35);
                    Long lValueOf117 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-444530678);
                    if (objAccessartificialFrame10 == null) {
                        int bitsPerPixel13 = 25 - ImageFormat.getBitsPerPixel(0);
                        char c115 = (char) (1 - (android.os.SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (android.os.SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)));
                        int iIndexOf112 = TextUtils.indexOf((CharSequence) "", '0') + 1042;
                        byte[] bArr21116 = $$a;
                        Object[] objArr71116 = new Object[1];
                        b((byte) 47, bArr21116[98], bArr21116[81], objArr71116);
                        objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(bitsPerPixel13, c115, iIndexOf112, 2061780482, false, (String) objArr71116[0], null);
                    }
                    ((Field) objAccessartificialFrame10).set(null, lValueOf117);
                }
            } else {
                int iIntValue10 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
                Object[] objArr71117 = {716904988};
                objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-1648942878);
                if (objAccessartificialFrame8 == null) {
                    objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 8, (char) (22252 - (android.os.SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (android.os.SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1))), 1033 - View.getDefaultSize(0, 0), 47343338, false, null, new Class[]{Integer.TYPE});
                }
                objArrAccessartificialFrame$78cbbd35 = CompactHashMap.Itr.accessartificialFrame$78cbbd35(iIntValue10, 0, ((Constructor) objAccessartificialFrame8).newInstance(objArr71117), -2112554579, false);
                objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame9 == null) {
                    int threadPriority116 = 26 - ((Process.getThreadPriority(0) + 20) >> 6);
                    char doubleTapTimeout9 = (char) (ViewConfiguration.getDoubleTapTimeout() >> 16);
                    int i151116 = 1042 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1));
                    Object[] objArr71118 = new Object[1];
                    b((byte) 47, $$a[98], (byte) 57, objArr71118);
                    objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(threadPriority116, doubleTapTimeout9, i151116, 1145017376, false, (String) objArr71118[0], null);
                }
                ((Field) objAccessartificialFrame9).set(null, objArrAccessartificialFrame$78cbbd35);
                Long lValueOf118 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-444530678);
                if (objAccessartificialFrame10 == null) {
                    int bitsPerPixel14 = 25 - ImageFormat.getBitsPerPixel(0);
                    char c116 = (char) (1 - (android.os.SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (android.os.SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)));
                    int iIndexOf113 = TextUtils.indexOf((CharSequence) "", '0') + 1042;
                    byte[] bArr21117 = $$a;
                    Object[] objArr71119 = new Object[1];
                    b((byte) 47, bArr21117[98], bArr21117[81], objArr71119);
                    objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(bitsPerPixel14, c116, iIndexOf113, 2061780482, false, (String) objArr71119[0], null);
                }
                ((Field) objAccessartificialFrame10).set(null, lValueOf118);
            }
            i14 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            i15 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            if (i15 == i14) {
                Object[] objArr81114 = {strArr112, new int[1], new int[]{i15119}, new int[]{i15118}};
                int i151117 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
                int i151118 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
                int i151119 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
                String[] strArr117 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
                int iCodePointAt8 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(8) - 710381406;
                int i161110 = i151117 + (((~((-809797162) | iCodePointAt8)) | 537165864) * (-283)) + 1772187958 + ((~(iCodePointAt8 | (-272631298))) * 283);
                int i161111 = (i161110 << 13) ^ i161110;
                int i161112 = i161111 ^ (i161111 >>> 17);
                ((int[]) objArr81114[1])[0] = i161112 ^ (i161112 << 5);
                i16 = 0;
            } else {
                arrayList2 = new ArrayList();
                strArr2 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
                if (strArr2 != null) {
                    while (i17 < strArr2.length) {
                        arrayList2.add(str7);
                    }
                }
                long j17 = (((long) 936109884) << 32) ^ ((long) (i14 ^ i15));
                long j18 = 936109886;
                int i161113 = artificialFrame + 3;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i161113 % 128;
                int i161114 = i161113 % 2;
                Object[] objArr81115 = {Long.valueOf(j17), Long.valueOf(j18)};
                byte[] bArr21118 = $$d;
                Object[] objArr81116 = new Object[1];
                c(bArr21118[14], bArr21118[631], (short) 463, objArr81116);
                Class<?> cls11121 = Class.forName((String) objArr81116[0]);
                byte b1123 = bArr21118[118];
                Object[] objArr81117 = new Object[1];
                c(b1123, (byte) (b1123 + 4), (short) ($$e + 5), objArr81117);
                cls11121.getMethod((String) objArr81117[0], Long.TYPE, Long.TYPE).invoke(null, objArr81115);
                Object[] objArr81118 = {strArr113, new int[1], new int[]{i16117}, new int[]{i16116}};
                int i161115 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
                int i161116 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
                int i161117 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
                String[] strArr118 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
                int iMyPid6 = Process.myPid();
                int i161118 = ~iMyPid6;
                int i161119 = i161115 + (-1549488194) + (((~(i161118 | 490861389)) | (~(412757582 | i161118)) | (-500957008)) * 464) + (((-88199426) | iMyPid6) * (-464)) + (((~(iMyPid6 | 490861389)) | (-500957008)) * 464);
                int i171114 = (i161119 << 13) ^ i161119;
                int i171115 = i171114 ^ (i171114 >>> 17);
                i16 = 0;
                ((int[]) objArr81118[1])[0] = i171115 ^ (i171115 << 5);
            }
            super.onStart();
            objAccessartificialFrame11 = ArtificialStackFrames.accessartificialFrame(-2127922582);
            if (objAccessartificialFrame11 == null) {
                int packedPositionType8 = ExpandableListView.getPackedPositionType(0L) + 30;
                char cAlpha7 = (char) (49362 - Color.alpha(i16));
                int threadPriority117 = ((Process.getThreadPriority(i16) + 20) >> 6) + 684;
                byte[] bArr21119 = $$a;
                Object[] objArr81119 = new Object[1];
                b((byte) (bArr21119[96] + 1), bArr21119[94], (byte) 96, objArr81119);
                objAccessartificialFrame11 = ArtificialStackFrames.coroutineCreation(packedPositionType8, cAlpha7, threadPriority117, 508509282, false, (String) objArr81119[0], null);
            }
            j3 = ((Field) objAccessartificialFrame11).getLong(null);
            if (j3 != -1) {
                if (j3 + 1952 >= ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                    objAccessartificialFrame19 = ArtificialStackFrames.accessartificialFrame(777251007);
                    if (objAccessartificialFrame19 == null) {
                        int offsetAfter4 = TextUtils.getOffsetAfter("", 0) + 30;
                        char cAlpha8 = (char) (Color.alpha(0) + 49362);
                        int i171116 = 685 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1));
                        byte[] bArr21120 = $$a;
                        Object[] objArr8122 = new Object[1];
                        b(bArr21120[65], bArr21120[23], (byte) AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, objArr8122);
                        objAccessartificialFrame19 = ArtificialStackFrames.coroutineCreation(offsetAfter4, cAlpha8, i171116, -1321816393, false, (String) objArr8122[0], null);
                    }
                    Object[] objArr8123 = (Object[]) ((Field) objAccessartificialFrame19).get(null);
                    objArr6 = new Object[]{new int[]{((int[]) objArr8123[0])[0]}, new int[]{((int[]) objArr8123[1])[0]}, new int[1], (String) objArr8123[3]};
                    int i171117 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 31408613;
                    int i171118 = ~i171117;
                    int i171119 = ((((-596835844) + (((~((-61749173) | i171118)) | 33690768) * (-108))) + (((~(i171118 | 1040372947)) | ((~((-1040372948) | i171117)) | (-1068431352))) * 54)) + ((i171117 | (-1068431352)) * 54)) - 1026999532;
                    int i17122 = (i171119 << 13) ^ i171119;
                    int i17123 = i17122 ^ (i17122 >>> 17);
                    ((int[]) objArr6[2])[0] = i17123 ^ (i17123 << 5);
                } else {
                    i18 = 0;
                }
                i19 = ((int[]) objArr6[1])[0];
                i20 = ((int[]) objArr6[0])[0];
                if (i20 == i19) {
                    int i1711110 = getARTIFICIAL_FRAME_PACKAGE_NAME + 37;
                    artificialFrame = i1711110 % 128;
                    int i1711111 = i1711110 % 2;
                    int i181111110 = ((int[]) objArr6[2])[0];
                    Object[] objArr811110 = {new int[]{((int[]) objArr6[0])[0]}, new int[]{((int[]) objArr6[1])[0]}, new int[1], (String) objArr6[3]};
                    int mode13 = ((AudioManager) ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getSystemService("audio")).getMode();
                    int i181111111 = ~mode13;
                    int i181111112 = ~((-255395344) | i181111111);
                    int i181111113 = ~((-723228432) | mode13);
                    int i181111114 = i181111110 + 910669500 + ((i181111112 | i181111113) * 1150) + (((~(723228431 | i181111111)) | i181111113) * (-575)) + (((~(mode13 | (-255395344))) | (~(i181111111 | 255395343))) * 575);
                    int i181111115 = (i181111114 << 13) ^ i181111114;
                    int i181111116 = i181111115 ^ (i181111115 >>> 17);
                    ((int[]) objArr811110[2])[0] = i181111116 ^ (i181111116 << 5);
                    i21 = 0;
                } else {
                    Object[] objArr811111 = {Long.valueOf(((long) (i19 ^ i20)) ^ (((long) (-1295343820)) << 32)), Long.valueOf(-1295344332)};
                    byte[] bArr211110 = $$d;
                    byte b111112 = bArr211110[172];
                    byte b111113 = bArr211110[64];
                    Object[] objArr911212 = new Object[1];
                    c(b111112, b111113, (short) (b111113 | 80), objArr911212);
                    Class<?> cls111112 = Class.forName((String) objArr911212[0]);
                    byte b111114 = bArr211110[118];
                    Object[] objArr911213 = new Object[1];
                    c(b111114, (byte) (b111114 + 4), (short) ($$e + 5), objArr911213);
                    cls111112.getMethod((String) objArr911213[0], Long.TYPE, Long.TYPE).invoke(null, objArr811111);
                    int i181111117 = ((int[]) objArr6[2])[0];
                    Object[] objArr911214 = {new int[]{((int[]) objArr6[0])[0]}, new int[]{((int[]) objArr6[1])[0]}, new int[1], (String) objArr6[3]};
                    int iNextInt11 = new Random().nextInt(373309157);
                    int i181111118 = i181111117 + (-452072299) + (((~(iNextInt11 | 797858843)) | (-180764932)) * (-465)) + ((797858843 | (~((-180764932) | iNextInt11))) * 930) + ((iNextInt11 | (-4194561)) * 465);
                    int i181111119 = (i181111118 << 13) ^ i181111118;
                    int i1911110 = i181111119 ^ (i181111119 >>> 17);
                    i21 = 0;
                    ((int[]) objArr911214[2])[0] = i1911110 ^ (i1911110 << 5);
                }
                objAccessartificialFrame14 = ArtificialStackFrames.accessartificialFrame(1745676544);
                if (objAccessartificialFrame14 == null) {
                    int iResolveSizeAndState7 = 17 - View.resolveSizeAndState(i21, i21, i21);
                    char windowTouchSlop7 = (char) (ViewConfiguration.getWindowTouchSlop() >> 8);
                    int i1911111 = 748 - (android.os.SystemClock.uptimeMillis() > 0L ? 1 : (android.os.SystemClock.uptimeMillis() == 0L ? 0 : -1));
                    byte[] bArr211111 = $$a;
                    Object[] objArr911215 = new Object[1];
                    b((byte) 47, bArr211111[98], bArr211111[81], objArr911215);
                    objAccessartificialFrame14 = ArtificialStackFrames.coroutineCreation(iResolveSizeAndState7, windowTouchSlop7, i1911111, -144068856, false, (String) objArr911215[0], null);
                }
                j4 = ((Field) objAccessartificialFrame14).getLong(null);
                if (j4 != -1) {
                    baseContext4 = getBaseContext();
                    if (baseContext4 == null) {
                        Object[] objArr911111118 = new Object[1];
                        a(27764 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), new char[]{55918, 46610, 653, 40740, 27564, 50265, 20697, 11524, 47606, 2676, 58881, 29392, 53034, 23483, 13361, 32987, 7497, 59845, 31341, 55039, 41639, 16136, 35743, 25663, 61606, 19792}, objArr911111118);
                        Class<?> cls111113 = Class.forName((String) objArr911111118[0]);
                        Object[] objArr911111119 = new Object[1];
                        a(TextUtils.indexOf("", "") + 53441, new char[]{55916, 2747, 31743, 43070, 39278, 51620, 16125, 28425, 23671, 36022, 65001, 8749, 4960, 17315, 45301, 57641, 54896, 1712}, objArr911111119);
                        baseContext4 = (Context) cls111113.getMethod((String) objArr911111119[0], new Class[0]).invoke(null, null);
                    }
                    if (baseContext4 != null) {
                        if (baseContext4 instanceof ContextWrapper) {
                            baseContext4 = baseContext4.getApplicationContext();
                        } else {
                            baseContext4 = baseContext4.getApplicationContext();
                        }
                    }
                    Object[] objArr9111111110 = {baseContext4, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 1378671210};
                    byte[] bArr31115 = $$d;
                    Object[] objArr9111111111 = new Object[1];
                    c(bArr31115[172], bArr31115[530], (short) 540, objArr9111111111);
                    Class<?> cls111114 = Class.forName((String) objArr9111111111[0]);
                    byte b111115 = (byte) (bArr31115[99] - 1);
                    Object[] objArr9111111112 = new Object[1];
                    c(b111115, (byte) (b111115 | Ascii.DC2), (short) (-bArr31115[500]), objArr9111111112);
                    objArr7 = (Object[]) cls111114.getMethod((String) objArr9111111112[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr9111111110);
                    objAccessartificialFrame15 = ArtificialStackFrames.accessartificialFrame(1575402270);
                    if (objAccessartificialFrame15 == null) {
                        int threadPriority118 = 17 - ((Process.getThreadPriority(0) + 20) >> 6);
                        char cIndexOf13 = (char) TextUtils.indexOf("", "", 0);
                        int iIndexOf114 = 746 - TextUtils.indexOf((CharSequence) "", '0');
                        Object[] objArr9111111113 = new Object[1];
                        b((byte) 47, $$a[98], (byte) 57, objArr9111111113);
                        objAccessartificialFrame15 = ArtificialStackFrames.coroutineCreation(threadPriority118, cIndexOf13, iIndexOf114, -1031537386, false, (String) objArr9111111113[0], null);
                    }
                    ((Field) objAccessartificialFrame15).set(null, objArr7);
                    Long lValueOf119 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame16 = ArtificialStackFrames.accessartificialFrame(1745676544);
                    if (objAccessartificialFrame16 == null) {
                        int i1911112 = 17 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                        char c117 = (char) (1 - (android.os.SystemClock.elapsedRealtime() > 0L ? 1 : (android.os.SystemClock.elapsedRealtime() == 0L ? 0 : -1)));
                        int i1911113 = (android.os.SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (android.os.SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 746;
                        byte[] bArr31116 = $$a;
                        Object[] objArr10111115 = new Object[1];
                        b((byte) 47, bArr31116[98], bArr31116[81], objArr10111115);
                        objAccessartificialFrame16 = ArtificialStackFrames.coroutineCreation(i1911112, c117, i1911113, -144068856, false, (String) objArr10111115[0], null);
                    }
                    ((Field) objAccessartificialFrame16).set(null, lValueOf119);
                } else {
                    baseContext4 = getBaseContext();
                    if (baseContext4 == null) {
                        Object[] objArr9111111114 = new Object[1];
                        a(27764 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), new char[]{55918, 46610, 653, 40740, 27564, 50265, 20697, 11524, 47606, 2676, 58881, 29392, 53034, 23483, 13361, 32987, 7497, 59845, 31341, 55039, 41639, 16136, 35743, 25663, 61606, 19792}, objArr9111111114);
                        Class<?> cls111115 = Class.forName((String) objArr9111111114[0]);
                        Object[] objArr9111111115 = new Object[1];
                        a(TextUtils.indexOf("", "") + 53441, new char[]{55916, 2747, 31743, 43070, 39278, 51620, 16125, 28425, 23671, 36022, 65001, 8749, 4960, 17315, 45301, 57641, 54896, 1712}, objArr9111111115);
                        baseContext4 = (Context) cls111115.getMethod((String) objArr9111111115[0], new Class[0]).invoke(null, null);
                    }
                    if (baseContext4 != null) {
                        if (baseContext4 instanceof ContextWrapper) {
                            baseContext4 = baseContext4.getApplicationContext();
                        } else {
                            baseContext4 = baseContext4.getApplicationContext();
                        }
                    }
                    Object[] objArr9111111116 = {baseContext4, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 1378671210};
                    byte[] bArr31117 = $$d;
                    Object[] objArr9111111117 = new Object[1];
                    c(bArr31117[172], bArr31117[530], (short) 540, objArr9111111117);
                    Class<?> cls111116 = Class.forName((String) objArr9111111117[0]);
                    byte b111116 = (byte) (bArr31117[99] - 1);
                    Object[] objArr9111111118 = new Object[1];
                    c(b111116, (byte) (b111116 | Ascii.DC2), (short) (-bArr31117[500]), objArr9111111118);
                    objArr7 = (Object[]) cls111116.getMethod((String) objArr9111111118[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr9111111116);
                    objAccessartificialFrame15 = ArtificialStackFrames.accessartificialFrame(1575402270);
                    if (objAccessartificialFrame15 == null) {
                        int threadPriority119 = 17 - ((Process.getThreadPriority(0) + 20) >> 6);
                        char cIndexOf14 = (char) TextUtils.indexOf("", "", 0);
                        int iIndexOf115 = 746 - TextUtils.indexOf((CharSequence) "", '0');
                        Object[] objArr9111111119 = new Object[1];
                        b((byte) 47, $$a[98], (byte) 57, objArr9111111119);
                        objAccessartificialFrame15 = ArtificialStackFrames.coroutineCreation(threadPriority119, cIndexOf14, iIndexOf115, -1031537386, false, (String) objArr9111111119[0], null);
                    }
                    ((Field) objAccessartificialFrame15).set(null, objArr7);
                    Long lValueOf1110 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame16 = ArtificialStackFrames.accessartificialFrame(1745676544);
                    if (objAccessartificialFrame16 == null) {
                        int i1911114 = 17 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                        char c118 = (char) (1 - (android.os.SystemClock.elapsedRealtime() > 0L ? 1 : (android.os.SystemClock.elapsedRealtime() == 0L ? 0 : -1)));
                        int i1911115 = (android.os.SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (android.os.SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 746;
                        byte[] bArr31118 = $$a;
                        Object[] objArr10111116 = new Object[1];
                        b((byte) 47, bArr31118[98], bArr31118[81], objArr10111116);
                        objAccessartificialFrame16 = ArtificialStackFrames.coroutineCreation(i1911114, c118, i1911115, -144068856, false, (String) objArr10111116[0], null);
                    }
                    ((Field) objAccessartificialFrame16).set(null, lValueOf1110);
                }
                i22 = ((int[]) objArr7[4])[0];
                i23 = ((int[]) objArr7[3])[0];
                if (i23 == i22) {
                    int i20111115 = artificialFrame + 123;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i20111115 % 128;
                    int i20111116 = i20111115 % 2;
                    Object[] objArr10111117 = {list113, new int[1], list114, new int[]{i2011119}, new int[]{i20111110}};
                    int i20111117 = ((int[]) objArr7[1])[0];
                    int i20111118 = ((int[]) objArr7[3])[0];
                    int i20111119 = ((int[]) objArr7[4])[0];
                    List list117 = (List) objArr7[0];
                    List list118 = (List) objArr7[2];
                    int i201111110 = ~((~Process.myUid()) | 96621351);
                    int i201111111 = i20111117 + (((25313797 | i201111110) * (-970)) - 1058822873) + ((i201111110 | 71307554) * 970);
                    int i201111112 = (i201111111 << 13) ^ i201111111;
                    int i201111113 = i201111112 ^ (i201111112 >>> 17);
                    ((int[]) objArr10111117[1])[0] = i201111113 ^ (i201111113 << 5);
                    return;
                }
                ArrayList arrayList10 = new ArrayList();
                Object[] objArr10111118 = {objArr7};
                objAccessartificialFrame17 = ArtificialStackFrames.accessartificialFrame(1804664566);
                if (objAccessartificialFrame17 == null) {
                    objAccessartificialFrame17 = ArtificialStackFrames.coroutineCreation(40 - MotionEvent.axisFromString(""), (char) ((Process.myTid() >> 22) + 12468), View.getDefaultSize(0, 0) + 3642, -185222914, false, "coroutineCreation", new Class[]{Object[].class});
                }
                arrayList10.add(((Method) objAccessartificialFrame17).invoke(null, objArr10111118));
                Object[] objArr10111119 = {objArr7};
                objAccessartificialFrame18 = ArtificialStackFrames.accessartificialFrame(-1243809191);
                if (objAccessartificialFrame18 == null) {
                    objAccessartificialFrame18 = ArtificialStackFrames.coroutineCreation(42 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 12467), TextUtils.indexOf((CharSequence) "", '0', 0) + 3643, 716815441, false, "ArtificialStackFrames", new Class[]{Object[].class});
                }
                arrayList10.add(((Method) objAccessartificialFrame18).invoke(null, objArr10111119));
                Object[] objArr101111110 = {Long.valueOf((((long) (-1097680825)) << 32) ^ ((long) (i22 ^ i23))), Long.valueOf(-1097680817)};
                byte[] bArr31119 = $$d;
                byte b111117 = bArr31119[172];
                byte b216 = bArr31119[87];
                Object[] objArr101111111 = new Object[1];
                c(b111117, b216, (short) (b216 | 578), objArr101111111);
                Class<?> cls111117 = Class.forName((String) objArr101111111[0]);
                byte b217 = bArr31119[118];
                Object[] objArr101111112 = new Object[1];
                c(b217, (byte) (b217 + 4), (short) ($$e + 5), objArr101111112);
                cls111117.getMethod((String) objArr101111112[0], Long.TYPE, Long.TYPE).invoke(null, objArr101111110);
                Object[] objArr101111113 = {list115, new int[1], list116, new int[]{i211119}, new int[]{i2111110}};
                int i2111115 = ((int[]) objArr7[1])[0];
                int i2111116 = ((int[]) objArr7[3])[0];
                int i2111117 = ((int[]) objArr7[4])[0];
                List list119 = (List) objArr7[0];
                List list1110 = (List) objArr7[2];
                int length9 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 682201691;
                int i2111118 = ~length9;
                int i2111119 = i2111115 + (((~(41798803 | i2111118)) | (~((-647247262) | length9)) | (~(i2111118 | 647247261))) * 959) + 1742647508 + (((~(length9 | 647247261)) | (~(i2111118 | (-647247262))) | (~(41798803 | length9))) * 959);
                int i21111110 = (i2111119 << 13) ^ i2111119;
                int i21111111 = i21111110 ^ (i21111110 >>> 17);
                ((int[]) objArr101111113[1])[0] = i21111111 ^ (i21111111 << 5);
                return;
            }
            i18 = 0;
            baseContext3 = getBaseContext();
            if (baseContext3 == null) {
                Object[] objArr11110 = new Object[1];
                a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[i18]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(i18, 4).codePointAt(3) + 27648, new char[]{55918, 46610, 653, 40740, 27564, 50265, 20697, 11524, 47606, 2676, 58881, 29392, 53034, 23483, 13361, 32987, 7497, 59845, 31341, 55039, 41639, 16136, 35743, 25663, 61606, 19792}, objArr11110);
                Class<?> cls124 = Class.forName((String) objArr11110[i18]);
                Object[] objArr11111 = new Object[1];
                a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[i18]).invoke(null, null)).getApplicationContext().getPackageName().length() + 53420, new char[]{55916, 2747, 31743, 43070, 39278, 51620, 16125, 28425, 23671, 36022, 65001, 8749, 4960, 17315, 45301, 57641, 54896, 1712}, objArr11111);
                baseContext3 = (Context) cls124.getMethod((String) objArr11111[0], new Class[0]).invoke(null, null);
            }
            if (baseContext3 != null) {
                if (baseContext3 instanceof ContextWrapper) {
                    int i2126 = artificialFrame + 51;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i2126 % 128;
                    int i2127 = i2126 % 2;
                    if (((ContextWrapper) baseContext3).getBaseContext() != null) {
                        baseContext3 = baseContext3.getApplicationContext();
                    } else {
                        baseContext3 = null;
                    }
                } else {
                    baseContext3 = baseContext3.getApplicationContext();
                }
            }
            Object[] objArr11112 = {baseContext3, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), -1026999532};
            byte[] bArr31120 = $$d;
            Object[] objArr11113 = new Object[1];
            c(bArr31120[9], bArr31120[128], (short) TypedValues.PositionType.TYPE_PERCENT_X, objArr11113);
            Class<?> cls125 = Class.forName((String) objArr11113[0]);
            Object[] objArr11114 = new Object[1];
            c(bArr31120[218], bArr31120[171], (short) 405, objArr11114);
            objArr6 = (Object[]) cls125.getMethod((String) objArr11114[0], Context.class, Integer.TYPE, Integer.TYPE).invoke(null, objArr11112);
            if (baseContext3 != null) {
                objAccessartificialFrame12 = ArtificialStackFrames.accessartificialFrame(777251007);
                if (objAccessartificialFrame12 == null) {
                    int iRed8 = 30 - Color.red(0);
                    char deadChar6 = (char) (KeyEvent.getDeadChar(0, 0) + 49362);
                    int iArgb4 = Color.argb(0, 0, 0, 0) + 684;
                    byte[] bArr3122 = $$a;
                    Object[] objArr12110 = new Object[1];
                    b(bArr3122[65], bArr3122[23], (byte) AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, objArr12110);
                    objAccessartificialFrame12 = ArtificialStackFrames.coroutineCreation(iRed8, deadChar6, iArgb4, -1321816393, false, (String) objArr12110[0], null);
                }
                ((Field) objAccessartificialFrame12).set(null, objArr6);
                Long lValueOf1111 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                objAccessartificialFrame13 = ArtificialStackFrames.accessartificialFrame(-2127922582);
                if (objAccessartificialFrame13 == null) {
                    int i2128 = (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 29;
                    char c119 = (char) (49361 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)));
                    int iRed9 = 684 - Color.red(0);
                    byte[] bArr3123 = $$a;
                    Object[] objArr12111 = new Object[1];
                    b((byte) (bArr3123[96] + 1), bArr3123[94], (byte) 96, objArr12111);
                    objAccessartificialFrame13 = ArtificialStackFrames.coroutineCreation(i2128, c119, iRed9, 508509282, false, (String) objArr12111[0], null);
                }
                ((Field) objAccessartificialFrame13).set(null, lValueOf1111);
            }
            i19 = ((int[]) objArr6[1])[0];
            i20 = ((int[]) objArr6[0])[0];
            if (i20 == i19) {
                int i1711112 = getARTIFICIAL_FRAME_PACKAGE_NAME + 37;
                artificialFrame = i1711112 % 128;
                int i1711113 = i1711112 % 2;
                int i1811111110 = ((int[]) objArr6[2])[0];
                Object[] objArr811112 = {new int[]{((int[]) objArr6[0])[0]}, new int[]{((int[]) objArr6[1])[0]}, new int[1], (String) objArr6[3]};
                int mode14 = ((AudioManager) ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getSystemService("audio")).getMode();
                int i1811111111 = ~mode14;
                int i1811111112 = ~((-255395344) | i1811111111);
                int i1811111113 = ~((-723228432) | mode14);
                int i1811111114 = i1811111110 + 910669500 + ((i1811111112 | i1811111113) * 1150) + (((~(723228431 | i1811111111)) | i1811111113) * (-575)) + (((~(mode14 | (-255395344))) | (~(i1811111111 | 255395343))) * 575);
                int i1811111115 = (i1811111114 << 13) ^ i1811111114;
                int i1811111116 = i1811111115 ^ (i1811111115 >>> 17);
                ((int[]) objArr811112[2])[0] = i1811111116 ^ (i1811111116 << 5);
                i21 = 0;
            } else {
                Object[] objArr811113 = {Long.valueOf(((long) (i19 ^ i20)) ^ (((long) (-1295343820)) << 32)), Long.valueOf(-1295344332)};
                byte[] bArr211112 = $$d;
                byte b111118 = bArr211112[172];
                byte b111119 = bArr211112[64];
                Object[] objArr911216 = new Object[1];
                c(b111118, b111119, (short) (b111119 | 80), objArr911216);
                Class<?> cls111118 = Class.forName((String) objArr911216[0]);
                byte b1111110 = bArr211112[118];
                Object[] objArr911217 = new Object[1];
                c(b1111110, (byte) (b1111110 + 4), (short) ($$e + 5), objArr911217);
                cls111118.getMethod((String) objArr911217[0], Long.TYPE, Long.TYPE).invoke(null, objArr811113);
                int i1811111117 = ((int[]) objArr6[2])[0];
                Object[] objArr911218 = {new int[]{((int[]) objArr6[0])[0]}, new int[]{((int[]) objArr6[1])[0]}, new int[1], (String) objArr6[3]};
                int iNextInt12 = new Random().nextInt(373309157);
                int i1811111118 = i1811111117 + (-452072299) + (((~(iNextInt12 | 797858843)) | (-180764932)) * (-465)) + ((797858843 | (~((-180764932) | iNextInt12))) * 930) + ((iNextInt12 | (-4194561)) * 465);
                int i1811111119 = (i1811111118 << 13) ^ i1811111118;
                int i1911116 = i1811111119 ^ (i1811111119 >>> 17);
                i21 = 0;
                ((int[]) objArr911218[2])[0] = i1911116 ^ (i1911116 << 5);
            }
            objAccessartificialFrame14 = ArtificialStackFrames.accessartificialFrame(1745676544);
            if (objAccessartificialFrame14 == null) {
                int iResolveSizeAndState8 = 17 - View.resolveSizeAndState(i21, i21, i21);
                char windowTouchSlop8 = (char) (ViewConfiguration.getWindowTouchSlop() >> 8);
                int i1911117 = 748 - (android.os.SystemClock.uptimeMillis() > 0L ? 1 : (android.os.SystemClock.uptimeMillis() == 0L ? 0 : -1));
                byte[] bArr211113 = $$a;
                Object[] objArr911219 = new Object[1];
                b((byte) 47, bArr211113[98], bArr211113[81], objArr911219);
                objAccessartificialFrame14 = ArtificialStackFrames.coroutineCreation(iResolveSizeAndState8, windowTouchSlop8, i1911117, -144068856, false, (String) objArr911219[0], null);
            }
            j4 = ((Field) objAccessartificialFrame14).getLong(null);
            if (j4 != -1) {
                baseContext4 = getBaseContext();
                if (baseContext4 == null) {
                    Object[] objArr91111111110 = new Object[1];
                    a(27764 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), new char[]{55918, 46610, 653, 40740, 27564, 50265, 20697, 11524, 47606, 2676, 58881, 29392, 53034, 23483, 13361, 32987, 7497, 59845, 31341, 55039, 41639, 16136, 35743, 25663, 61606, 19792}, objArr91111111110);
                    Class<?> cls111119 = Class.forName((String) objArr91111111110[0]);
                    Object[] objArr91111111111 = new Object[1];
                    a(TextUtils.indexOf("", "") + 53441, new char[]{55916, 2747, 31743, 43070, 39278, 51620, 16125, 28425, 23671, 36022, 65001, 8749, 4960, 17315, 45301, 57641, 54896, 1712}, objArr91111111111);
                    baseContext4 = (Context) cls111119.getMethod((String) objArr91111111111[0], new Class[0]).invoke(null, null);
                }
                if (baseContext4 != null) {
                    if (baseContext4 instanceof ContextWrapper) {
                        baseContext4 = baseContext4.getApplicationContext();
                    } else {
                        baseContext4 = baseContext4.getApplicationContext();
                    }
                }
                Object[] objArr91111111112 = {baseContext4, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 1378671210};
                byte[] bArr311110 = $$d;
                Object[] objArr91111111113 = new Object[1];
                c(bArr311110[172], bArr311110[530], (short) 540, objArr91111111113);
                Class<?> cls1111110 = Class.forName((String) objArr91111111113[0]);
                byte b1111111 = (byte) (bArr311110[99] - 1);
                Object[] objArr91111111114 = new Object[1];
                c(b1111111, (byte) (b1111111 | Ascii.DC2), (short) (-bArr311110[500]), objArr91111111114);
                objArr7 = (Object[]) cls1111110.getMethod((String) objArr91111111114[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr91111111112);
                objAccessartificialFrame15 = ArtificialStackFrames.accessartificialFrame(1575402270);
                if (objAccessartificialFrame15 == null) {
                    int threadPriority1110 = 17 - ((Process.getThreadPriority(0) + 20) >> 6);
                    char cIndexOf15 = (char) TextUtils.indexOf("", "", 0);
                    int iIndexOf116 = 746 - TextUtils.indexOf((CharSequence) "", '0');
                    Object[] objArr91111111115 = new Object[1];
                    b((byte) 47, $$a[98], (byte) 57, objArr91111111115);
                    objAccessartificialFrame15 = ArtificialStackFrames.coroutineCreation(threadPriority1110, cIndexOf15, iIndexOf116, -1031537386, false, (String) objArr91111111115[0], null);
                }
                ((Field) objAccessartificialFrame15).set(null, objArr7);
                Long lValueOf1112 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                objAccessartificialFrame16 = ArtificialStackFrames.accessartificialFrame(1745676544);
                if (objAccessartificialFrame16 == null) {
                    int i1911118 = 17 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                    char c1110 = (char) (1 - (android.os.SystemClock.elapsedRealtime() > 0L ? 1 : (android.os.SystemClock.elapsedRealtime() == 0L ? 0 : -1)));
                    int i1911119 = (android.os.SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (android.os.SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 746;
                    byte[] bArr311111 = $$a;
                    Object[] objArr101111114 = new Object[1];
                    b((byte) 47, bArr311111[98], bArr311111[81], objArr101111114);
                    objAccessartificialFrame16 = ArtificialStackFrames.coroutineCreation(i1911118, c1110, i1911119, -144068856, false, (String) objArr101111114[0], null);
                }
                ((Field) objAccessartificialFrame16).set(null, lValueOf1112);
            } else {
                baseContext4 = getBaseContext();
                if (baseContext4 == null) {
                    Object[] objArr91111111116 = new Object[1];
                    a(27764 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), new char[]{55918, 46610, 653, 40740, 27564, 50265, 20697, 11524, 47606, 2676, 58881, 29392, 53034, 23483, 13361, 32987, 7497, 59845, 31341, 55039, 41639, 16136, 35743, 25663, 61606, 19792}, objArr91111111116);
                    Class<?> cls1111111 = Class.forName((String) objArr91111111116[0]);
                    Object[] objArr91111111117 = new Object[1];
                    a(TextUtils.indexOf("", "") + 53441, new char[]{55916, 2747, 31743, 43070, 39278, 51620, 16125, 28425, 23671, 36022, 65001, 8749, 4960, 17315, 45301, 57641, 54896, 1712}, objArr91111111117);
                    baseContext4 = (Context) cls1111111.getMethod((String) objArr91111111117[0], new Class[0]).invoke(null, null);
                }
                if (baseContext4 != null) {
                    if (baseContext4 instanceof ContextWrapper) {
                        baseContext4 = baseContext4.getApplicationContext();
                    } else {
                        baseContext4 = baseContext4.getApplicationContext();
                    }
                }
                Object[] objArr91111111118 = {baseContext4, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 1378671210};
                byte[] bArr311112 = $$d;
                Object[] objArr91111111119 = new Object[1];
                c(bArr311112[172], bArr311112[530], (short) 540, objArr91111111119);
                Class<?> cls1111112 = Class.forName((String) objArr91111111119[0]);
                byte b1111112 = (byte) (bArr311112[99] - 1);
                Object[] objArr911111111110 = new Object[1];
                c(b1111112, (byte) (b1111112 | Ascii.DC2), (short) (-bArr311112[500]), objArr911111111110);
                objArr7 = (Object[]) cls1111112.getMethod((String) objArr911111111110[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr91111111118);
                objAccessartificialFrame15 = ArtificialStackFrames.accessartificialFrame(1575402270);
                if (objAccessartificialFrame15 == null) {
                    int threadPriority1111 = 17 - ((Process.getThreadPriority(0) + 20) >> 6);
                    char cIndexOf16 = (char) TextUtils.indexOf("", "", 0);
                    int iIndexOf117 = 746 - TextUtils.indexOf((CharSequence) "", '0');
                    Object[] objArr911111111111 = new Object[1];
                    b((byte) 47, $$a[98], (byte) 57, objArr911111111111);
                    objAccessartificialFrame15 = ArtificialStackFrames.coroutineCreation(threadPriority1111, cIndexOf16, iIndexOf117, -1031537386, false, (String) objArr911111111111[0], null);
                }
                ((Field) objAccessartificialFrame15).set(null, objArr7);
                Long lValueOf1113 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                objAccessartificialFrame16 = ArtificialStackFrames.accessartificialFrame(1745676544);
                if (objAccessartificialFrame16 == null) {
                    int i19111110 = 17 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                    char c1111 = (char) (1 - (android.os.SystemClock.elapsedRealtime() > 0L ? 1 : (android.os.SystemClock.elapsedRealtime() == 0L ? 0 : -1)));
                    int i19111111 = (android.os.SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (android.os.SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 746;
                    byte[] bArr311113 = $$a;
                    Object[] objArr101111115 = new Object[1];
                    b((byte) 47, bArr311113[98], bArr311113[81], objArr101111115);
                    objAccessartificialFrame16 = ArtificialStackFrames.coroutineCreation(i19111110, c1111, i19111111, -144068856, false, (String) objArr101111115[0], null);
                }
                ((Field) objAccessartificialFrame16).set(null, lValueOf1113);
            }
            i22 = ((int[]) objArr7[4])[0];
            i23 = ((int[]) objArr7[3])[0];
            if (i23 == i22) {
                int i201111114 = artificialFrame + 123;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i201111114 % 128;
                int i201111115 = i201111114 % 2;
                Object[] objArr101111116 = {list117, new int[1], list118, new int[]{i20111118}, new int[]{i20111119}};
                int i201111116 = ((int[]) objArr7[1])[0];
                int i201111117 = ((int[]) objArr7[3])[0];
                int i201111118 = ((int[]) objArr7[4])[0];
                List list1111 = (List) objArr7[0];
                List list1112 = (List) objArr7[2];
                int i201111119 = ~((~Process.myUid()) | 96621351);
                int i2011111110 = i201111116 + (((25313797 | i201111119) * (-970)) - 1058822873) + ((i201111119 | 71307554) * 970);
                int i2011111111 = (i2011111110 << 13) ^ i2011111110;
                int i2011111112 = i2011111111 ^ (i2011111111 >>> 17);
                ((int[]) objArr101111116[1])[0] = i2011111112 ^ (i2011111112 << 5);
                return;
            }
            ArrayList arrayList11 = new ArrayList();
            Object[] objArr101111117 = {objArr7};
            objAccessartificialFrame17 = ArtificialStackFrames.accessartificialFrame(1804664566);
            if (objAccessartificialFrame17 == null) {
                objAccessartificialFrame17 = ArtificialStackFrames.coroutineCreation(40 - MotionEvent.axisFromString(""), (char) ((Process.myTid() >> 22) + 12468), View.getDefaultSize(0, 0) + 3642, -185222914, false, "coroutineCreation", new Class[]{Object[].class});
            }
            arrayList11.add(((Method) objAccessartificialFrame17).invoke(null, objArr101111117));
            Object[] objArr101111118 = {objArr7};
            objAccessartificialFrame18 = ArtificialStackFrames.accessartificialFrame(-1243809191);
            if (objAccessartificialFrame18 == null) {
                objAccessartificialFrame18 = ArtificialStackFrames.coroutineCreation(42 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 12467), TextUtils.indexOf((CharSequence) "", '0', 0) + 3643, 716815441, false, "ArtificialStackFrames", new Class[]{Object[].class});
            }
            arrayList11.add(((Method) objAccessartificialFrame18).invoke(null, objArr101111118));
            Object[] objArr101111119 = {Long.valueOf((((long) (-1097680825)) << 32) ^ ((long) (i22 ^ i23))), Long.valueOf(-1097680817)};
            byte[] bArr311114 = $$d;
            byte b1111113 = bArr311114[172];
            byte b218 = bArr311114[87];
            Object[] objArr1011111110 = new Object[1];
            c(b1111113, b218, (short) (b218 | 578), objArr1011111110);
            Class<?> cls1111113 = Class.forName((String) objArr1011111110[0]);
            byte b219 = bArr311114[118];
            Object[] objArr1011111111 = new Object[1];
            c(b219, (byte) (b219 + 4), (short) ($$e + 5), objArr1011111111);
            cls1111113.getMethod((String) objArr1011111111[0], Long.TYPE, Long.TYPE).invoke(null, objArr101111119);
            Object[] objArr1011111112 = {list119, new int[1], list1110, new int[]{i2111116}, new int[]{i2111117}};
            int i21111112 = ((int[]) objArr7[1])[0];
            int i21111113 = ((int[]) objArr7[3])[0];
            int i21111114 = ((int[]) objArr7[4])[0];
            List list1113 = (List) objArr7[0];
            List list1114 = (List) objArr7[2];
            int length10 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 682201691;
            int i21111115 = ~length10;
            int i21111116 = i21111112 + (((~(41798803 | i21111115)) | (~((-647247262) | length10)) | (~(i21111115 | 647247261))) * 959) + 1742647508 + (((~(length10 | 647247261)) | (~(i21111115 | (-647247262))) | (~(41798803 | length10))) * 959);
            int i21111117 = (i21111116 << 13) ^ i21111116;
            int i21111118 = i21111117 ^ (i21111117 >>> 17);
            ((int[]) objArr1011111112[1])[0] = i21111118 ^ (i21111118 << 5);
            return;
        } catch (Exception unused8) {
            throw new RuntimeException();
        }
        Object objAccessartificialFrame37 = ArtificialStackFrames.accessartificialFrame(-1717965552);
        if (objAccessartificialFrame37 == null) {
            objAccessartificialFrame37 = ArtificialStackFrames.coroutineCreation(20 - View.combineMeasuredStates(i3, i3), (char) (Process.getGidForName("") + 39517), (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 981, 117222168, false, null, new Class[0]);
        }
        Object[] objArr137 = {null, ((Constructor) objAccessartificialFrame37).newInstance(null), 1164090609, 0};
        Object objAccessartificialFrame38 = ArtificialStackFrames.accessartificialFrame(-501205803);
        if (objAccessartificialFrame38 == null) {
            int size3 = View.MeasureSpec.getSize(0) + 36;
            char packedPositionChild2 = (char) (ExpandableListView.getPackedPositionChild(0L) + 1);
            int i224 = (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 539;
            byte b30 = (byte) ($$a[71] - 1);
            byte b31 = b30;
            Object[] objArr138 = new Object[1];
            b(b30, b31, (byte) (b31 | 76), objArr138);
            objAccessartificialFrame38 = ArtificialStackFrames.coroutineCreation(size3, packedPositionChild2, i224, 2101703389, false, (String) objArr138[0], new Class[]{(Class) ArtificialStackFrames.coroutineCreation((ViewConfiguration.getKeyRepeatDelay() >> 16) + 54, (char) (881 - AndroidCharacter.getMirror('0')), Color.alpha(0) + 576), (Class) ArtificialStackFrames.coroutineCreation(54 - (ViewConfiguration.getTapTimeout() >> 16), (char) (ViewConfiguration.getScrollBarSize() >> 8), 631 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))), Integer.TYPE, Integer.TYPE});
        }
        objArr4 = (Object[]) ((Method) objAccessartificialFrame38).invoke(null, objArr137);
        Object objAccessartificialFrame39 = ArtificialStackFrames.accessartificialFrame(-1339222025);
        if (objAccessartificialFrame39 == null) {
            int i225 = (android.os.SystemClock.elapsedRealtime() > 0L ? 1 : (android.os.SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 35;
            char cIndexOf17 = (char) TextUtils.indexOf("", "", 0, 0);
            int iRgb = (-16776676) - Color.rgb(0, 0, 0);
            Object[] objArr139 = new Object[1];
            b((byte) 47, $$a[98], (byte) 57, objArr139);
            objAccessartificialFrame39 = ArtificialStackFrames.coroutineCreation(i225, cIndexOf17, iRgb, 793268735, false, (String) objArr139[0], null);
        }
        ((Field) objAccessartificialFrame39).set(null, objArr4);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onResume() throws Throwable {
        int i = 2 % 2;
        int i2 = artificialFrame + 69;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i2 % 128;
        try {
            if (i2 % 2 != 0) {
                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(949068051);
                if (objAccessartificialFrame == null) {
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(30 - KeyEvent.getDeadChar(0, 0), (char) ((android.os.SystemClock.uptimeMillis() > 0L ? 1 : (android.os.SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 49992), KeyEvent.normalizeMetaState(0) + 74, -1477122277, false, "MediaDescriptionCompatApi23Builder", null);
                }
                Object obj = ((Field) objAccessartificialFrame).get(null);
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1579113874);
                if (objAccessartificialFrame2 == null) {
                    int packedPositionGroup = 30 - ExpandableListView.getPackedPositionGroup(0L);
                    char c = (char) (49993 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)));
                    int minimumFlingVelocity = (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 74;
                    byte[] bArr = $$d;
                    Object[] objArr = new Object[1];
                    c(bArr[22], (byte) (-bArr[700]), (short) 659, objArr);
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(packedPositionGroup, c, minimumFlingVelocity, -1048962150, false, (String) objArr[0], new Class[0]);
                }
                ((Method) objAccessartificialFrame2).invoke(obj, null);
                super.onResume();
                int i3 = 79 / 0;
                return;
            }
            Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(949068051);
            if (objAccessartificialFrame3 == null) {
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation((KeyEvent.getMaxKeyCode() >> 16) + 30, (char) (TextUtils.getTrimmedLength("") + 49993), 74 - TextUtils.getOffsetBefore("", 0), -1477122277, false, "MediaDescriptionCompatApi23Builder", null);
            }
            Object obj2 = ((Field) objAccessartificialFrame3).get(null);
            Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1579113874);
            if (objAccessartificialFrame4 == null) {
                int iLastIndexOf = TextUtils.lastIndexOf("", '0', 0) + 31;
                char cResolveSizeAndState = (char) (View.resolveSizeAndState(0, 0, 0) + 49993);
                int iIndexOf = 74 - TextUtils.indexOf("", "");
                byte[] bArr2 = $$d;
                Object[] objArr2 = new Object[1];
                c(bArr2[22], (byte) (-bArr2[700]), (short) 659, objArr2);
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(iLastIndexOf, cResolveSizeAndState, iIndexOf, -1048962150, false, (String) objArr2[0], new Class[0]);
            }
            ((Method) objAccessartificialFrame4).invoke(obj2, null);
            super.onResume();
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onPause() throws Throwable {
        int i = 2 % 2;
        int i2 = artificialFrame + 75;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i2 % 128;
        try {
            if (i2 % 2 != 0) {
                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(949068051);
                if (objAccessartificialFrame == null) {
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(30 - View.combineMeasuredStates(0, 0), (char) (ImageFormat.getBitsPerPixel(0) + 49994), View.MeasureSpec.getMode(0) + 74, -1477122277, false, "MediaDescriptionCompatApi23Builder", null);
                }
                Object obj = ((Field) objAccessartificialFrame).get(null);
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1579114835);
                if (objAccessartificialFrame2 == null) {
                    int iCombineMeasuredStates = View.combineMeasuredStates(0, 0) + 30;
                    char cLastIndexOf = (char) (TextUtils.lastIndexOf("", '0') + 49994);
                    int scrollDefaultDelay = 74 - (ViewConfiguration.getScrollDefaultDelay() >> 16);
                    byte[] bArr = $$d;
                    Object[] objArr = new Object[1];
                    c(bArr[172], (byte) (-bArr[700]), (short) 659, objArr);
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iCombineMeasuredStates, cLastIndexOf, scrollDefaultDelay, -1048959141, false, (String) objArr[0], new Class[0]);
                }
                ((Method) objAccessartificialFrame2).invoke(obj, null);
                super.onPause();
                throw null;
            }
            Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(949068051);
            if (objAccessartificialFrame3 == null) {
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getMinimumFlingVelocity() >> 16) + 30, (char) ((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 49992), Color.green(0) + 74, -1477122277, false, "MediaDescriptionCompatApi23Builder", null);
            }
            Object obj2 = ((Field) objAccessartificialFrame3).get(null);
            Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1579114835);
            if (objAccessartificialFrame4 == null) {
                int mode = View.MeasureSpec.getMode(0) + 30;
                char cResolveSize = (char) (49993 - View.resolveSize(0, 0));
                int iIndexOf = TextUtils.indexOf((CharSequence) "", '0') + 75;
                byte[] bArr2 = $$d;
                Object[] objArr2 = new Object[1];
                c(bArr2[172], (byte) (-bArr2[700]), (short) 659, objArr2);
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(mode, cResolveSize, iIndexOf, -1048959141, false, (String) objArr2[0], new Class[0]);
            }
            ((Method) objAccessartificialFrame4).invoke(obj2, null);
            super.onPause();
            int i3 = getARTIFICIAL_FRAME_PACKAGE_NAME + 105;
            artificialFrame = i3 % 128;
            int i4 = i3 % 2;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:16:0x020d A[Catch: all -> 0x09cd, TryCatch #2 {all -> 0x09cd, blocks: (B:51:0x0701, B:53:0x0715, B:54:0x073f, B:14:0x01ed, B:16:0x020d, B:17:0x025c), top: B:95:0x01ed }] */
    /* JADX WARN: Code duplicated, block: B:20:0x026e  */
    /* JADX WARN: Code duplicated, block: B:25:0x0302  */
    /* JADX WARN: Code duplicated, block: B:50:0x0678  */
    /* JADX WARN: Code duplicated, block: B:53:0x0715 A[Catch: all -> 0x09cd, TryCatch #2 {all -> 0x09cd, blocks: (B:51:0x0701, B:53:0x0715, B:54:0x073f, B:14:0x01ed, B:16:0x020d, B:17:0x025c), top: B:95:0x01ed }] */
    /* JADX WARN: Code duplicated, block: B:57:0x0755  */
    /* JADX WARN: Code duplicated, block: B:62:0x0806  */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) throws Throwable {
        Object objAccessartificialFrame;
        Object[] objArr;
        Object objAccessartificialFrame2;
        Object objAccessartificialFrame3;
        Object objAccessartificialFrame4;
        Object objAccessartificialFrame5;
        Object objAccessartificialFrame6;
        Object[] objArr2;
        int i = 2 % 2;
        super.attachBaseContext(context);
        Object objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-1268268649);
        if (objAccessartificialFrame7 == null) {
            int iNormalizeMetaState = 25 - KeyEvent.normalizeMetaState(0);
            char c = (char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 30067);
            int maxKeyCode = (KeyEvent.getMaxKeyCode() >> 16) + 816;
            byte[] bArr = $$a;
            Object[] objArr3 = new Object[1];
            b((byte) 47, bArr[98], bArr[81], objArr3);
            objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(iNormalizeMetaState, c, maxKeyCode, 721586079, false, (String) objArr3[0], null);
        }
        long j = ((Field) objAccessartificialFrame7).getLong(null);
        if (j != -1) {
            int i2 = artificialFrame + 97;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i2 % 128;
            int i3 = i2 % 2;
            long j2 = j + 1933;
            Object[] objArr4 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 35875, new char[]{55918, 22086, 49701, 32264, 60156, 26277, 37505, 3888, 47960, 14115, 41895, 57329, 19362, 51079, 28761, 60451, 6162, 38107, 221, 48261, 10592, 42327}, objArr4);
            Class<?> cls = Class.forName((String) objArr4[0]);
            Object[] objArr5 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(7) + 50226, new char[]{55914, 7878, 21284, 38800, 51432, 3411, 16821, 47838, 65346, 13219, 29713, 43372, 60890, 9731, 7020}, objArr5);
            if (j2 >= ((Long) cls.getDeclaredMethod((String) objArr5[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                int i4 = getARTIFICIAL_FRAME_PACKAGE_NAME + 27;
                artificialFrame = i4 % 128;
                int i5 = i4 % 2;
                Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame8 == null) {
                    int iIndexOf = 25 - TextUtils.indexOf("", "", 0);
                    char cIndexOf = (char) (TextUtils.indexOf("", "") + 30068);
                    int iNormalizeMetaState2 = 816 - KeyEvent.normalizeMetaState(0);
                    Object[] objArr6 = new Object[1];
                    b((byte) 47, $$a[98], (byte) 57, objArr6);
                    objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(iIndexOf, cIndexOf, iNormalizeMetaState2, 891606461, false, (String) objArr6[0], null);
                }
                Object[] objArr7 = (Object[]) ((Field) objAccessartificialFrame8).get(null);
                objArr = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i6 = ((int[]) objArr7[0])[0];
                int i7 = ((int[]) objArr7[1])[0];
                String[] strArr = (String[]) objArr7[2];
                int i8 = ~System.identityHashCode(this);
                int i9 = ((1693804780 + (((~((-870956321) | i8)) | 672783954) * (-933))) + (((~(i8 | 672783954)) | (-1006239603)) * 933)) - 1201481960;
                int i10 = (i9 << 13) ^ i9;
                int i11 = i10 ^ (i10 >>> 17);
                ((int[]) objArr[3])[0] = i11 ^ (i11 << 5);
            } else {
                Object[] objArr8 = new Object[1];
                a((ViewConfiguration.getWindowTouchSlop() >> 8) + 57329, new char[]{55909, 1439, 26011, 17853, 42469, 34262, 58824, 50678, 9696, 1368, 25910, 17709, 42288, 34118, 58692, 50557}, objArr8);
                Class<?> cls2 = Class.forName((String) objArr8[0]);
                Object[] objArr9 = new Object[1];
                a(View.MeasureSpec.makeMeasureSpec(0, 0) + 16183, new char[]{55910, 58716, 41988, 26564, 9895, 58997, 41265, 24823, 9215, 57985, 41562, 27962, 11480, 61355, 44905, 28243}, objArr9);
                try {
                    Object[] objArr10 = {Integer.valueOf(((Integer) cls2.getMethod((String) objArr9[0], Object.class).invoke(null, this)).intValue()), 0, 1428234814};
                    objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(1327366003);
                    if (objAccessartificialFrame == null) {
                        int modifierMetaStateMask = 24 - ((byte) KeyEvent.getModifierMetaStateMask());
                        char cRed = (char) (30068 - Color.red(0));
                        int scrollDefaultDelay = 816 - (ViewConfiguration.getScrollDefaultDelay() >> 16);
                        byte[] bArr2 = $$a;
                        Object[] objArr11 = new Object[1];
                        b(bArr2[10], bArr2[26], (byte) 65, objArr11);
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(modifierMetaStateMask, cRed, scrollDefaultDelay, -797394565, false, (String) objArr11[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                    }
                    objArr = (Object[]) ((Method) objAccessartificialFrame).invoke(null, objArr10);
                    objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                    if (objAccessartificialFrame2 == null) {
                        int iIndexOf2 = 24 - TextUtils.indexOf((CharSequence) "", '0');
                        char cCombineMeasuredStates = (char) (View.combineMeasuredStates(0, 0) + 30068);
                        int i12 = (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 816;
                        Object[] objArr12 = new Object[1];
                        b((byte) 47, $$a[98], (byte) 57, objArr12);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iIndexOf2, cCombineMeasuredStates, i12, 891606461, false, (String) objArr12[0], null);
                    }
                    ((Field) objAccessartificialFrame2).set(null, objArr);
                    try {
                        Object[] objArr13 = new Object[1];
                        a(35879 - View.MeasureSpec.getSize(0), new char[]{55918, 22086, 49701, 32264, 60156, 26277, 37505, 3888, 47960, 14115, 41895, 57329, 19362, 51079, 28761, 60451, 6162, 38107, 221, 48261, 10592, 42327}, objArr13);
                        Class<?> cls3 = Class.forName((String) objArr13[0]);
                        Object[] objArr14 = new Object[1];
                        a(50341 - View.MeasureSpec.makeMeasureSpec(0, 0), new char[]{55914, 7878, 21284, 38800, 51432, 3411, 16821, 47838, 65346, 13219, 29713, 43372, 60890, 9731, 7020}, objArr14);
                        Long lValueOf = Long.valueOf(((Long) cls3.getDeclaredMethod((String) objArr14[0], new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                        if (objAccessartificialFrame3 == null) {
                            int iResolveSize = 25 - View.resolveSize(0, 0);
                            char cResolveOpacity = (char) (30068 - Drawable.resolveOpacity(0, 0));
                            int iMyPid = 816 - (Process.myPid() >> 22);
                            byte[] bArr3 = $$a;
                            Object[] objArr15 = new Object[1];
                            b((byte) 47, bArr3[98], bArr3[81], objArr15);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(iResolveSize, cResolveOpacity, iMyPid, 721586079, false, (String) objArr15[0], null);
                        }
                        ((Field) objAccessartificialFrame3).set(null, lValueOf);
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
            Object[] objArr16 = new Object[1];
            a((ViewConfiguration.getWindowTouchSlop() >> 8) + 57329, new char[]{55909, 1439, 26011, 17853, 42469, 34262, 58824, 50678, 9696, 1368, 25910, 17709, 42288, 34118, 58692, 50557}, objArr16);
            Class<?> cls4 = Class.forName((String) objArr16[0]);
            Object[] objArr17 = new Object[1];
            a(View.MeasureSpec.makeMeasureSpec(0, 0) + 16183, new char[]{55910, 58716, 41988, 26564, 9895, 58997, 41265, 24823, 9215, 57985, 41562, 27962, 11480, 61355, 44905, 28243}, objArr17);
            Object[] objArr18 = {Integer.valueOf(((Integer) cls4.getMethod((String) objArr17[0], Object.class).invoke(null, this)).intValue()), 0, 1428234814};
            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(1327366003);
            if (objAccessartificialFrame == null) {
                int modifierMetaStateMask2 = 24 - ((byte) KeyEvent.getModifierMetaStateMask());
                char cRed2 = (char) (30068 - Color.red(0));
                int scrollDefaultDelay2 = 816 - (ViewConfiguration.getScrollDefaultDelay() >> 16);
                byte[] bArr4 = $$a;
                Object[] objArr19 = new Object[1];
                b(bArr4[10], bArr4[26], (byte) 65, objArr19);
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(modifierMetaStateMask2, cRed2, scrollDefaultDelay2, -797394565, false, (String) objArr19[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            }
            objArr = (Object[]) ((Method) objAccessartificialFrame).invoke(null, objArr18);
            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame2 == null) {
                int iIndexOf3 = 24 - TextUtils.indexOf((CharSequence) "", '0');
                char cCombineMeasuredStates2 = (char) (View.combineMeasuredStates(0, 0) + 30068);
                int i13 = (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 816;
                Object[] objArr110 = new Object[1];
                b((byte) 47, $$a[98], (byte) 57, objArr110);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iIndexOf3, cCombineMeasuredStates2, i13, 891606461, false, (String) objArr110[0], null);
            }
            ((Field) objAccessartificialFrame2).set(null, objArr);
            Object[] objArr111 = new Object[1];
            a(35879 - View.MeasureSpec.getSize(0), new char[]{55918, 22086, 49701, 32264, 60156, 26277, 37505, 3888, 47960, 14115, 41895, 57329, 19362, 51079, 28761, 60451, 6162, 38107, 221, 48261, 10592, 42327}, objArr111);
            Class<?> cls5 = Class.forName((String) objArr111[0]);
            Object[] objArr112 = new Object[1];
            a(50341 - View.MeasureSpec.makeMeasureSpec(0, 0), new char[]{55914, 7878, 21284, 38800, 51432, 3411, 16821, 47838, 65346, 13219, 29713, 43372, 60890, 9731, 7020}, objArr112);
            Long lValueOf2 = Long.valueOf(((Long) cls5.getDeclaredMethod((String) objArr112[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1268268649);
            if (objAccessartificialFrame3 == null) {
                int iResolveSize2 = 25 - View.resolveSize(0, 0);
                char cResolveOpacity2 = (char) (30068 - Drawable.resolveOpacity(0, 0));
                int iMyPid2 = 816 - (Process.myPid() >> 22);
                byte[] bArr5 = $$a;
                Object[] objArr113 = new Object[1];
                b((byte) 47, bArr5[98], bArr5[81], objArr113);
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(iResolveSize2, cResolveOpacity2, iMyPid2, 721586079, false, (String) objArr113[0], null);
            }
            ((Field) objAccessartificialFrame3).set(null, lValueOf2);
        }
        int i14 = ((int[]) objArr[1])[0];
        int i15 = ((int[]) objArr[0])[0];
        if (i15 == i14) {
            Object[] objArr20 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i16 = ((int[]) objArr[3])[0];
            int i17 = ((int[]) objArr[0])[0];
            int i18 = ((int[]) objArr[1])[0];
            String[] strArr2 = (String[]) objArr[2];
            int iIdentityHashCode = System.identityHashCode(this);
            int i19 = ~iIdentityHashCode;
            int i20 = i16 + 912806697 + (((~(815327940 | i19)) | (-1022946263)) * 98) + (((~(i19 | (-1013500307))) | 815327940 | (~(1013500306 | iIdentityHashCode))) * (-49)) + (((~(iIdentityHashCode | 815327940)) | 9445956) * 49);
            int i21 = (i20 << 13) ^ i20;
            int i22 = i21 ^ (i21 >>> 17);
            ((int[]) objArr20[3])[0] = i22 ^ (i22 << 5);
        } else {
            ArrayList arrayList = new ArrayList();
            String[] strArr3 = (String[]) objArr[2];
            if (strArr3 != null) {
                for (String str : strArr3) {
                    arrayList.add(str);
                }
            }
            long j3 = ((long) (i14 ^ i15)) ^ (((long) 2089186038) << 32);
            long j4 = 2089186039;
            int i23 = getARTIFICIAL_FRAME_PACKAGE_NAME + 89;
            artificialFrame = i23 % 128;
            int i24 = i23 % 2;
            try {
                Object[] objArr21 = {Long.valueOf(j3), Long.valueOf(j4)};
                byte[] bArr6 = $$d;
                Object[] objArr22 = new Object[1];
                c(bArr6[172], (byte) (-bArr6[663]), (short) 659, objArr22);
                Class<?> cls6 = Class.forName((String) objArr22[0]);
                byte b = bArr6[118];
                Object[] objArr23 = new Object[1];
                c(b, (byte) (b + 4), (short) ($$e + 5), objArr23);
                cls6.getMethod((String) objArr23[0], Long.TYPE, Long.TYPE).invoke(null, objArr21);
                Object[] objArr24 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i25 = ((int[]) objArr[3])[0];
                int i26 = ((int[]) objArr[0])[0];
                int i27 = ((int[]) objArr[1])[0];
                String[] strArr4 = (String[]) objArr[2];
                int i28 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getDisplayMetrics().densityDpi;
                int i29 = ~i28;
                int i30 = i25 + (-363386162) + (((~(4620345 | i29)) | (~((-4227129) | i28))) * (-831)) + ((~(207019839 | i28)) * (-1662)) + (((~(i28 | (-4620346))) | (~(i29 | (-202792712))) | (~(202792711 | i28))) * 831);
                int i31 = (i30 << 13) ^ i30;
                int i32 = i31 ^ (i31 >>> 17);
                ((int[]) objArr24[3])[0] = i32 ^ (i32 << 5);
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 == null) {
                    throw th2;
                }
                throw cause2;
            }
        }
        Object objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(-444530678);
        if (objAccessartificialFrame9 == null) {
            int keyRepeatDelay = 26 - (ViewConfiguration.getKeyRepeatDelay() >> 16);
            char offsetBefore = (char) TextUtils.getOffsetBefore("", 0);
            int maximumFlingVelocity = (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 1041;
            byte[] bArr7 = $$a;
            Object[] objArr25 = new Object[1];
            b((byte) 47, bArr7[98], bArr7[81], objArr25);
            objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(keyRepeatDelay, offsetBefore, maximumFlingVelocity, 2061780482, false, (String) objArr25[0], null);
        }
        long j5 = ((Field) objAccessartificialFrame9).getLong(null);
        if (j5 != -1) {
            int i33 = artificialFrame + 49;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i33 % 128;
            int i34 = i33 % 2;
            long j6 = j5 + 1945;
            Object[] objArr26 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 35875, new char[]{55918, 22086, 49701, 32264, 60156, 26277, 37505, 3888, 47960, 14115, 41895, 57329, 19362, 51079, 28761, 60451, 6162, 38107, 221, 48261, 10592, 42327}, objArr26);
            Class<?> cls7 = Class.forName((String) objArr26[0]);
            Object[] objArr27 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(11) + 50236, new char[]{55914, 7878, 21284, 38800, 51432, 3411, 16821, 47838, 65346, 13219, 29713, 43372, 60890, 9731, 7020}, objArr27);
            if (j6 >= ((Long) cls7.getDeclaredMethod((String) objArr27[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                int i35 = artificialFrame + 77;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i35 % 128;
                int i36 = i35 % 2;
                Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame10 == null) {
                    int iIndexOf4 = TextUtils.indexOf("", "", 0) + 26;
                    char c2 = (char) ((-1) - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)));
                    int iLastIndexOf = 1040 - TextUtils.lastIndexOf("", '0');
                    Object[] objArr28 = new Object[1];
                    b((byte) 47, $$a[98], (byte) 57, objArr28);
                    objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(iIndexOf4, c2, iLastIndexOf, 1145017376, false, (String) objArr28[0], null);
                }
                Object[] objArr29 = (Object[]) ((Field) objAccessartificialFrame10).get(null);
                objArr2 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
                int i37 = ((int[]) objArr29[3])[0];
                int i38 = ((int[]) objArr29[2])[0];
                String[] strArr5 = (String[]) objArr29[0];
                int iIdentityHashCode2 = System.identityHashCode(this);
                int i39 = (((41828030 + (((~((~iIdentityHashCode2) | (-36993))) | (~((-209731601) | iIdentityHashCode2))) * (-302))) + ((~((-36993) | iIdentityHashCode2)) * (-604))) + (((~(iIdentityHashCode2 | (-209768593))) | (-497604000)) * 302)) - 1695689202;
                int i40 = (i39 << 13) ^ i39;
                int i41 = i40 ^ (i40 >>> 17);
                ((int[]) objArr2[1])[0] = i41 ^ (i41 << 5);
            } else {
                Object[] objArr30 = new Object[1];
                a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(1) + 57228, new char[]{55909, 1439, 26011, 17853, 42469, 34262, 58824, 50678, 9696, 1368, 25910, 17709, 42288, 34118, 58692, 50557}, objArr30);
                Class<?> cls8 = Class.forName((String) objArr30[0]);
                Object[] objArr31 = new Object[1];
                a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) + 16147, new char[]{55910, 58716, 41988, 26564, 9895, 58997, 41265, 24823, 9215, 57985, 41562, 27962, 11480, 61355, 44905, 28243}, objArr31);
                int iIntValue = ((Integer) cls8.getMethod((String) objArr31[0], Object.class).invoke(null, this)).intValue();
                Object[] objArr32 = {-810956802};
                objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1648942878);
                if (objAccessartificialFrame4 == null) {
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(8 - Color.red(0), (char) (22251 - TextUtils.indexOf("", "", 0, 0)), TextUtils.getTrimmedLength("") + 1033, 47343338, false, null, new Class[]{Integer.TYPE});
                }
                Object[] objArrAccessartificialFrame$78cbbd35 = DynamiteModule.LoadingException.accessartificialFrame$78cbbd35(iIntValue, 0, ((Constructor) objAccessartificialFrame4).newInstance(objArr32), -1695689202, false);
                objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame5 == null) {
                    int i42 = 26 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                    char cBlue = (char) Color.blue(0);
                    int i43 = (android.os.SystemClock.elapsedRealtime() > 0L ? 1 : (android.os.SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 1040;
                    Object[] objArr33 = new Object[1];
                    b((byte) 47, $$a[98], (byte) 57, objArr33);
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(i42, cBlue, i43, 1145017376, false, (String) objArr33[0], null);
                }
                ((Field) objAccessartificialFrame5).set(null, objArrAccessartificialFrame$78cbbd35);
                try {
                    Object[] objArr34 = new Object[1];
                    a(KeyEvent.normalizeMetaState(0) + 35879, new char[]{55918, 22086, 49701, 32264, 60156, 26277, 37505, 3888, 47960, 14115, 41895, 57329, 19362, 51079, 28761, 60451, 6162, 38107, 221, 48261, 10592, 42327}, objArr34);
                    Class<?> cls9 = Class.forName((String) objArr34[0]);
                    Object[] objArr35 = new Object[1];
                    a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 50306, new char[]{55914, 7878, 21284, 38800, 51432, 3411, 16821, 47838, 65346, 13219, 29713, 43372, 60890, 9731, 7020}, objArr35);
                    Long lValueOf3 = Long.valueOf(((Long) cls9.getDeclaredMethod((String) objArr35[0], new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-444530678);
                    if (objAccessartificialFrame6 == null) {
                        int i44 = 27 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                        char keyRepeatDelay2 = (char) (ViewConfiguration.getKeyRepeatDelay() >> 16);
                        int i45 = (android.os.SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (android.os.SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 1040;
                        byte[] bArr8 = $$a;
                        Object[] objArr36 = new Object[1];
                        b((byte) 47, bArr8[98], bArr8[81], objArr36);
                        objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(i44, keyRepeatDelay2, i45, 2061780482, false, (String) objArr36[0], null);
                    }
                    ((Field) objAccessartificialFrame6).set(null, lValueOf3);
                    objArr2 = objArrAccessartificialFrame$78cbbd35;
                } catch (Exception unused2) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object[] objArr37 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(1) + 57228, new char[]{55909, 1439, 26011, 17853, 42469, 34262, 58824, 50678, 9696, 1368, 25910, 17709, 42288, 34118, 58692, 50557}, objArr37);
            Class<?> cls10 = Class.forName((String) objArr37[0]);
            Object[] objArr38 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) + 16147, new char[]{55910, 58716, 41988, 26564, 9895, 58997, 41265, 24823, 9215, 57985, 41562, 27962, 11480, 61355, 44905, 28243}, objArr38);
            int iIntValue2 = ((Integer) cls10.getMethod((String) objArr38[0], Object.class).invoke(null, this)).intValue();
            Object[] objArr39 = {-810956802};
            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame4 == null) {
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(8 - Color.red(0), (char) (22251 - TextUtils.indexOf("", "", 0, 0)), TextUtils.getTrimmedLength("") + 1033, 47343338, false, null, new Class[]{Integer.TYPE});
            }
            Object[] objArrAccessartificialFrame$78cbbd36 = DynamiteModule.LoadingException.accessartificialFrame$78cbbd35(iIntValue2, 0, ((Constructor) objAccessartificialFrame4).newInstance(objArr39), -1695689202, false);
            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame5 == null) {
                int i46 = 26 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                char cBlue2 = (char) Color.blue(0);
                int i47 = (android.os.SystemClock.elapsedRealtime() > 0L ? 1 : (android.os.SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 1040;
                Object[] objArr310 = new Object[1];
                b((byte) 47, $$a[98], (byte) 57, objArr310);
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(i46, cBlue2, i47, 1145017376, false, (String) objArr310[0], null);
            }
            ((Field) objAccessartificialFrame5).set(null, objArrAccessartificialFrame$78cbbd36);
            Object[] objArr311 = new Object[1];
            a(KeyEvent.normalizeMetaState(0) + 35879, new char[]{55918, 22086, 49701, 32264, 60156, 26277, 37505, 3888, 47960, 14115, 41895, 57329, 19362, 51079, 28761, 60451, 6162, 38107, 221, 48261, 10592, 42327}, objArr311);
            Class<?> cls11 = Class.forName((String) objArr311[0]);
            Object[] objArr312 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 50306, new char[]{55914, 7878, 21284, 38800, 51432, 3411, 16821, 47838, 65346, 13219, 29713, 43372, 60890, 9731, 7020}, objArr312);
            Long lValueOf4 = Long.valueOf(((Long) cls11.getDeclaredMethod((String) objArr312[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-444530678);
            if (objAccessartificialFrame6 == null) {
                int i48 = 27 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                char keyRepeatDelay3 = (char) (ViewConfiguration.getKeyRepeatDelay() >> 16);
                int i49 = (android.os.SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (android.os.SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 1040;
                byte[] bArr9 = $$a;
                Object[] objArr313 = new Object[1];
                b((byte) 47, bArr9[98], bArr9[81], objArr313);
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(i48, keyRepeatDelay3, i49, 2061780482, false, (String) objArr313[0], null);
            }
            ((Field) objAccessartificialFrame6).set(null, lValueOf4);
            objArr2 = objArrAccessartificialFrame$78cbbd36;
        }
        int i50 = ((int[]) objArr2[2])[0];
        int i51 = ((int[]) objArr2[3])[0];
        if (i51 == i50) {
            int i52 = getARTIFICIAL_FRAME_PACKAGE_NAME + 7;
            artificialFrame = i52 % 128;
            int i53 = i52 % 2;
            Object[] objArr40 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i54 = ((int[]) objArr2[1])[0];
            int i55 = ((int[]) objArr2[3])[0];
            int i56 = ((int[]) objArr2[2])[0];
            String[] strArr6 = (String[]) objArr2[0];
            int iIdentityHashCode3 = System.identityHashCode(this);
            int i57 = i54 + ((((~(iIdentityHashCode3 | 787392858)) | (-709289052)) * 56) - 1716938) + (((~((~iIdentityHashCode3) | (-709289052))) | 787392858) * 56);
            int i58 = (i57 << 13) ^ i57;
            int i59 = i58 ^ (i58 >>> 17);
            ((int[]) objArr40[1])[0] = i59 ^ (i59 << 5);
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        String[] strArr7 = (String[]) objArr2[0];
        if (strArr7 != null) {
            for (String str2 : strArr7) {
                arrayList2.add(str2);
            }
        }
        Object[] objArr41 = {Long.valueOf(((long) (i50 ^ i51)) ^ (((long) 1398186745) << 32)), Long.valueOf(1398186747)};
        byte[] bArr10 = $$d;
        Object[] objArr42 = new Object[1];
        c(bArr10[172], bArr10[36], (short) 697, objArr42);
        Class<?> cls12 = Class.forName((String) objArr42[0]);
        byte b2 = bArr10[118];
        Object[] objArr43 = new Object[1];
        c(b2, (byte) (b2 + 4), (short) ($$e + 5), objArr43);
        cls12.getMethod((String) objArr43[0], Long.TYPE, Long.TYPE).invoke(null, objArr41);
        Object[] objArr44 = {strArr, new int[1], new int[]{i}, new int[]{i}};
        int i60 = ((int[]) objArr2[1])[0];
        int i61 = ((int[]) objArr2[3])[0];
        int i62 = ((int[]) objArr2[2])[0];
        String[] strArr8 = (String[]) objArr2[0];
        int i63 = ~((~(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(13) - 1232453164)) | 463367173);
        int i64 = i60 + (((311829508 | i63) * (-374)) - 102289056) + ((i63 | 151537665) * 374);
        int i65 = (i64 << 13) ^ i64;
        int i66 = i65 ^ (i65 >>> 17);
        ((int[]) objArr44[1])[0] = i66 ^ (i66 << 5);
    }

    static {
        byte[] bArr = new byte[744];
        System.arraycopy("!®çT\u0010\u0002Å<ÿ\u0006\u0006\u0001\u0011\u0004\u0000Ç7\u0013\u0004ù\u0015ó\r\n\u0003¿\u00173\u0004Ù5ó\r\n\u0003Ý'ü\u0004\u0002\u0011Û(\u0007\u0000¼#0\u0002\u0007õ\u0011ÿ\n\u0003º\u0004%7\u0000õ\u0011\u0000÷\u000fë*ù\nø\u0001\u0013ùþí\u0019\u0010ù\u0006\u0001Ó0\u0007\u0001\n\u0003ù\tûã%\u0001\u0017ö\u0004\u0006\týè-\u0010\u0002Å<ÿ\u0006\u0006\u0001\u0011\u0004\u0000ÇH÷\u0000\u0006\u0015¾Kø\bø\u0011÷\n\u0002\u0011À/\u001aüþñ%ù\u0005ï#\u0004\u0001¼\u0004%7\u0000õ\u0011\u0000÷\u000fë*ù\nø\u0001\u0013ùþí\u0019\u0010ù\u0006\u0001Ó\u0004A\u0010\u0002Å=\f\u0004ü\týÍ<\u0007\r÷\u0001\u0003\u0016öÍCü\u0012\u0004ò\n\u0006\týË\u001c'\r÷\u0001\u0003\u0016öì\u001c\u0012\u0004ò\n\u0006\týï\u0017\u0006\u0006\u000e\u0005\u0002ó\u0015\u0010\u0007\u0001\n\u0003ù\tûâ3÷\u0000\u0017ù\n\u0003\u0010\u0002Å<ÿ\u0006\u0006\u0001\u0011\u0004\u0000Ç7\u0013\u0004\u0000\u0001\t\u0001\f¿\u00173\u0004à!\t\u0001Ý!\u0017ñÇ\u0011\u0010\u0002Å=\f\u0004ü\týÍ7\u0011ú\u0012\u0001þÿÎCø\u0017õ\u0011ûü\u000fÆ9\u0010\u0001\u0007\u0007ÀK\u0003ù\u0007\u0001\u000fù\u0000\u0012¿\u001a9ù÷\u0010\u0000þä0\u0001\u0007\u0007¶\u0004%7\u0000õ\u0011\u0000÷\u000fë*ù\nø\u0001\u0013ùþí\u0019\u0010ù\u0006\u0001Ó\u0010\u0002Å=\f\u0004ü\týÍ7\u0011ú\u0012\u0001þÿÎ=\n\n¿?\t\nõ\u0011\u0000÷\u000fÆC\u0003\u0003\u0002\u000fï\u001b÷\u000eú\n\u0003õ\u0007\u0003\u0015õ\u0010ù\u0005ÍP\u0004ì\u001c\u0006\u0004\u0006\u0012\u0004ò\u0015\u0006ù\u0001\u0007þ\nü\u000fÞ0ó\u0010ü\u0010\u0002Å=\f\u0004ü\týÍC\u0003\u0003\u0002\u000f¾9\u0010\u0002\u0004\u0006\u0003ÄIõ\u000b\u0002\t\nõ\u0011\u0000÷\u000fÆP\u0004û\u0000\u0001\u0010\u0004\u0000Çÿ?\t\nõ\u0011\u0000÷\u000fÆM\u0000¿(\u0017\u0000\u000fï\u0012\u0001õ ø\fþ\u0013´7\u001fû\u000fõ\u0011æ\u0011\u0016ü\nÃIö\r\n\u0002\u000b¹F\u0006\u0001\tÿø\u0010\u0001Æ\u001d\"\u000e¹$%\u0012ö\u0011ûü\u000f\u0001\u0015ï\u0011\u0010\u0002Å=\f\u0004ü\týÍ7\u0011ú\u0012\u0001þÿÎ=\n\n¿?\t\nõ\u0011\u0000÷\u000fÆCü\u0000\u0016\u0006\u0001÷\fü\r\n¾P\u0004í\b\u0010\u0002Å=\f\u0004ü\týÍ<\u0007\r÷\u0001\u0003\u0016öÍ9\u0010\u0002\u0007\u0003\u0003û\r\n\u0003¿%%\bù\n\u0003÷\u000fè&\u0001\u000b÷ÿ\u0005\u0011¶\u0004%7\u0000õ\u0011\u0000÷\u000fë*ù\nø\u0001\u0013ùþí\u0019\u0010ù\u0006\u0001Õ\u0010\u0002Å=\f\u0004ü\týÍ9\u0013\u000bû\bÿÃJù\t\u0001Ç7\b\u0000\u0007Î\u0017(\u0012Ö \u001b×\u001e\u0018¯\u0011\tÊG\u0002\b¿B\u0007üÿ\u0003\u0006\fÇ9\u0010\u0007÷ÍI\u0001ýÉ\u0019:î\r\u0001þã7õ\u0004\u0003\u0011æ\"ó\u0006\fþ\u0011".getBytes(CharEncoding.ISO_8859_1), 0, bArr, 0, 744);
        $$d = bArr;
        $$e = 156;
        $$a = new byte[]{73, -128, -106, 120, -9, Ascii.DC2, -34, Ascii.EM, 4, -17, 19, -15, -1, -18, Ascii.SI, 19, -11, 5, -7, -2, Ascii.SI, -36, Ascii.NAK, Ascii.CR, -15, 2, 9, 6, -34, Ascii.SI, 19, -11, 5, -7, -2, Ascii.SI, -33, 33, -19, 17, -32, Ascii.SI, 19, -11, 5, -7, 10, -31, Ascii.DC4, Ascii.CR, -8, -11, -13, Ascii.ESC, 5, -1, -33, 33, -2, -9, 5, -7, 5, -1, -50, 39, Ascii.VT, -7, -12, Ascii.SI, Ascii.ESC, 1, -7, -6, -33, 51, -12, 3, -8, 1, Ascii.CR, 49, 2, -11, -3, 3, -6, 6, -8, Ascii.VT, -25, 33, -19, 2, 8, -37, 44, -17, Ascii.FF, -8, Ascii.SO, -9, Ascii.DC2, -36, 33, -19, 17, -32, Ascii.SI, 19, -11, 5, -7, -7, Ascii.DC2, -43, Ascii.GS, -4, 17, 2};
        $$b = 20;
        getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
        artificialFrame = 1;
        extraCommand = 7295013497129755136L;
    }
}
