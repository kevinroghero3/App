package com.google.android.gms.common;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import ch.qos.logback.core.net.SyslogConstants;
import com.facebook.imageutils.JfifUtil;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager$$ExternalSyntheticLambda5;
import com.google.android.gms.common.internal.Preconditions;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import o.ArtificialStackFrames;
import o.artificialFrame;
import org.apache.commons.lang3.CharEncoding;

/* JADX INFO: loaded from: classes2.dex */
public class ErrorDialogFragment extends DialogFragment {
    private static final byte[] $$a;
    private static final int $$b;
    private static final byte[] $$d;
    private static final int $$e;
    private static int[] ICustomTabsCallbackStub;
    private static int artificialFrame;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME;
    private Dialog zaa;
    private DialogInterface.OnCancelListener zab;
    private Dialog zac;
    private static final byte[] $$c = {106, 50, -99, -104};
    private static final int $$f = 41;
    private static int $10 = 0;
    private static int $11 = 1;

    /* JADX WARN: Code duplicated, block: B:10:0x0025  */
    /* JADX WARN: Code duplicated, block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x002a). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0025
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$g(short r6, short r7, int r8) {
        /*
            int r7 = r7 * 6
            int r7 = 115 - r7
            int r8 = r8 * 3
            int r8 = r8 + 4
            byte[] r0 = com.google.android.gms.common.ErrorDialogFragment.$$c
            int r6 = r6 * 4
            int r1 = r6 + 1
            byte[] r1 = new byte[r1]
            r2 = 0
            if (r0 != 0) goto L17
            r7 = r6
            r3 = r8
            r4 = r2
            goto L2a
        L17:
            r3 = r2
        L18:
            byte r4 = (byte) r7
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r6) goto L25
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            return r6
        L25:
            r3 = r0[r8]
            r5 = r3
            r3 = r8
            r8 = r5
        L2a:
            int r7 = r7 + r8
            int r8 = r3 + 1
            r3 = r4
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.ErrorDialogFragment.$$g(short, short, int):java.lang.String");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0023  */
    /* JADX WARN: Code duplicated, block: B:8:0x001b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x0025). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0023
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void b(int r5, byte r6, int r7, java.lang.Object[] r8) {
        /*
            byte[] r0 = com.google.android.gms.common.ErrorDialogFragment.$$a
            int r7 = r7 + 4
            int r1 = r6 + 8
            int r5 = r5 + 65
            byte[] r1 = new byte[r1]
            int r6 = r6 + 7
            r2 = 0
            if (r0 != 0) goto L13
            r3 = r5
            r5 = r6
            r4 = r2
            goto L25
        L13:
            r3 = r2
        L14:
            byte r4 = (byte) r5
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r6) goto L23
            java.lang.String r5 = new java.lang.String
            r5.<init>(r1, r2)
            r8[r2] = r5
            return
        L23:
            r3 = r0[r7]
        L25:
            int r5 = r5 + r3
            int r7 = r7 + 1
            r3 = r4
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.ErrorDialogFragment.b(int, byte, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0025  */
    /* JADX WARN: Code duplicated, block: B:8:0x001d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x0027). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0025
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void c(int r5, byte r6, int r7, java.lang.Object[] r8) {
        /*
            int r5 = 111 - r5
            int r7 = 528 - r7
            int r0 = 65 - r6
            byte[] r1 = com.google.android.gms.common.ErrorDialogFragment.$$d
            byte[] r0 = new byte[r0]
            int r6 = 64 - r6
            r2 = 0
            if (r1 != 0) goto L13
            r3 = r5
            r5 = r6
            r4 = r2
            goto L27
        L13:
            r3 = r2
        L14:
            int r7 = r7 + 1
            byte r4 = (byte) r5
            r0[r3] = r4
            int r4 = r3 + 1
            if (r3 != r6) goto L25
            java.lang.String r5 = new java.lang.String
            r5.<init>(r0, r2)
            r8[r2] = r5
            return
        L25:
            r3 = r1[r7]
        L27:
            int r5 = r5 + r3
            int r5 = r5 + (-4)
            r3 = r4
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.ErrorDialogFragment.c(int, byte, int, java.lang.Object[]):void");
    }

    public static ErrorDialogFragment newInstance(@NonNull Dialog dialog) {
        return newInstance(dialog, null);
    }

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(@NonNull DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.zab;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    @Override // android.app.DialogFragment
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        Dialog dialog = this.zaa;
        if (dialog != null) {
            return dialog;
        }
        setShowsDialog(false);
        if (this.zac == null) {
            this.zac = new AlertDialog.Builder((Context) Preconditions.checkNotNull(getActivity())).create();
        }
        return this.zac;
    }

    @Override // android.app.DialogFragment
    public void show(@NonNull FragmentManager fragmentManager, @Nullable String str) {
        super.show(fragmentManager, str);
    }

    public static ErrorDialogFragment newInstance(@NonNull Dialog dialog, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        ErrorDialogFragment errorDialogFragment = new ErrorDialogFragment();
        Dialog dialog2 = (Dialog) Preconditions.checkNotNull(dialog, "Cannot display null dialog");
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        errorDialogFragment.zaa = dialog2;
        if (onCancelListener != null) {
            errorDialogFragment.zab = onCancelListener;
        }
        return errorDialogFragment;
    }

    private static void a(int i, int[] iArr, Object[] objArr) throws Throwable {
        int length;
        int[] iArr2;
        int i2 = 2 % 2;
        artificialFrame artificialframe = new artificialFrame();
        char[] cArr = new char[4];
        char[] cArr2 = new char[iArr.length * 2];
        int[] iArr3 = ICustomTabsCallbackStub;
        int i3 = -1780896814;
        int i4 = 1;
        int i5 = 0;
        if (iArr3 != null) {
            int length2 = iArr3.length;
            int[] iArr4 = new int[length2];
            int i6 = 0;
            while (i6 < length2) {
                try {
                    Object[] objArr2 = {Integer.valueOf(iArr3[i6])};
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(i3);
                    if (objAccessartificialFrame == null) {
                        byte b = (byte) 0;
                        byte b2 = (byte) (b + 1);
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 11, (char) View.getDefaultSize(0, 0), 1562 - (ViewConfiguration.getEdgeSlop() >> 16), 180153818, false, $$g(b, b2, (byte) (b2 - 1)), new Class[]{Integer.TYPE});
                    }
                    iArr4[i6] = ((Integer) ((Method) objAccessartificialFrame).invoke(null, objArr2)).intValue();
                    i6++;
                    i3 = -1780896814;
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
            iArr3 = iArr4;
        }
        int length3 = iArr3.length;
        int[] iArr5 = new int[length3];
        int[] iArr6 = ICustomTabsCallbackStub;
        if (iArr6 != null) {
            int i7 = $11 + 83;
            $10 = i7 % 128;
            if (i7 % 2 != 0) {
                length = iArr6.length;
                iArr2 = new int[length];
            } else {
                length = iArr6.length;
                iArr2 = new int[length];
            }
            int i8 = 0;
            while (i8 < length) {
                try {
                    Object[] objArr3 = new Object[i4];
                    objArr3[i5] = Integer.valueOf(iArr6[i8]);
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1780896814);
                    if (objAccessartificialFrame2 == null) {
                        byte b3 = (byte) i5;
                        byte b4 = (byte) (b3 + 1);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(TextUtils.getTrimmedLength("") + 11, (char) ((-1) - ((byte) KeyEvent.getModifierMetaStateMask())), (ViewConfiguration.getLongPressTimeout() >> 16) + 1562, 180153818, false, $$g(b3, b4, (byte) (b4 - 1)), new Class[]{Integer.TYPE});
                    }
                    iArr2[i8] = ((Integer) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).intValue();
                    i8++;
                    iArr6 = iArr6;
                    i4 = 1;
                    i5 = 0;
                } catch (Throwable th2) {
                    Throwable cause2 = th2.getCause();
                    if (cause2 == null) {
                        throw th2;
                    }
                    throw cause2;
                }
            }
            iArr6 = iArr2;
        }
        int i9 = i5;
        System.arraycopy(iArr6, i9, iArr5, i9, length3);
        artificialframe.e = i9;
        while (artificialframe.e < iArr.length) {
            cArr[0] = (char) (iArr[artificialframe.e] >> 16);
            cArr[1] = (char) iArr[artificialframe.e];
            cArr[2] = (char) (iArr[artificialframe.e + 1] >> 16);
            cArr[3] = (char) iArr[artificialframe.e + 1];
            artificialframe.c = (cArr[0] << 16) + cArr[1];
            artificialframe.b = (cArr[2] << 16) + cArr[3];
            artificialFrame.coroutineBoundary(iArr5);
            int i10 = 0;
            for (int i11 = 16; i10 < i11; i11 = 16) {
                int i12 = $10 + 15;
                $11 = i12 % 128;
                int i13 = i12 % 2;
                artificialframe.c ^= iArr5[i10];
                Object[] objArr4 = {artificialframe, Integer.valueOf(artificialFrame.coroutineBoundary(artificialframe.c)), artificialframe, artificialframe};
                Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1540318455);
                if (objAccessartificialFrame3 == null) {
                    byte b5 = (byte) 0;
                    byte b6 = b5;
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(26 - (ViewConfiguration.getLongPressTimeout() >> 16), (char) Color.green(0), 1042 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), 995482881, false, $$g(b5, b6, b6), new Class[]{Object.class, Integer.TYPE, Object.class, Object.class});
                }
                int iIntValue = ((Integer) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).intValue();
                artificialframe.c = artificialframe.b;
                artificialframe.b = iIntValue;
                i10++;
            }
            int i14 = artificialframe.c;
            artificialframe.c = artificialframe.b;
            artificialframe.b = i14;
            artificialframe.b ^= iArr5[16];
            artificialframe.c ^= iArr5[17];
            int i15 = artificialframe.c;
            int i16 = artificialframe.b;
            cArr[0] = (char) (artificialframe.c >>> 16);
            cArr[1] = (char) artificialframe.c;
            cArr[2] = (char) (artificialframe.b >>> 16);
            cArr[3] = (char) artificialframe.b;
            artificialFrame.coroutineBoundary(iArr5);
            cArr2[artificialframe.e * 2] = cArr[0];
            cArr2[(artificialframe.e * 2) + 1] = cArr[1];
            cArr2[(artificialframe.e * 2) + 2] = cArr[2];
            cArr2[(artificialframe.e * 2) + 3] = cArr[3];
            Object[] objArr5 = {artificialframe, artificialframe};
            Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1348396126);
            if (objAccessartificialFrame4 == null) {
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getJumpTapTimeout() >> 16) + 37, (char) (28010 - TextUtils.indexOf("", "")), TextUtils.indexOf((CharSequence) "", '0') + 307, -818175402, false, "q", new Class[]{Object.class, Object.class});
            }
            ((Method) objAccessartificialFrame4).invoke(null, objArr5);
        }
        objArr[0] = new String(cArr2, 0, i);
    }

    /* JADX WARN: Code duplicated, block: B:60:0x05fe  */
    /* JADX WARN: Code duplicated, block: B:62:0x0643  */
    /* JADX WARN: Code duplicated, block: B:68:0x0653  */
    /* JADX WARN: Code duplicated, block: B:72:0x06e0  */
    /* JADX WARN: Code duplicated, block: B:74:0x06ec  */
    /* JADX WARN: Code duplicated, block: B:76:0x06f5  */
    /* JADX WARN: Code duplicated, block: B:81:0x0767  */
    /* JADX WARN: Code duplicated, block: B:82:0x07a7  */
    /* JADX WARN: Code duplicated, block: B:84:0x07b0  */
    /* JADX WARN: Code duplicated, block: B:89:0x081e  */
    @Override // android.app.DialogFragment, android.app.Fragment
    public void onCreate(Bundle bundle) throws Throwable {
        Object[] objArr;
        Context applicationContext;
        Object[] objArr2;
        int i;
        Object objAccessartificialFrame;
        Long lValueOf;
        Object objAccessartificialFrame2;
        int gidForName;
        int i2;
        boolean z;
        String str;
        Class[] clsArr;
        char c;
        int i3;
        Object objAccessartificialFrame3;
        Object[] objArr3;
        Object[] objArr4;
        Long lValueOf2;
        Object objAccessartificialFrame4;
        int minimumFlingVelocity;
        char modifierMetaStateMask;
        int keyRepeatTimeout;
        int i4;
        boolean z2;
        Object obj;
        Object[] objArr5;
        Object[] objArr6;
        Object[] objArr7;
        Object[] objArr8;
        int i5 = 2 % 2;
        Object[] objArr9 = new Object[1];
        a((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 22, new int[]{1716773826, 433105227, 1034725174, -421568069, 1615883490, 501186531, 1354724597, -1407894899, -1419979881, 1893300237, -1880245870, 765806150}, objArr9);
        String str2 = (String) objArr9[0];
        Object[] objArr10 = new Object[1];
        a(15 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), new int[]{116936474, 681198958, 1338084420, 2093544711, -490138422, -574960577, 1378896887, -1905154242}, objArr10);
        String str3 = (String) objArr10[0];
        Object[] objArr11 = new Object[1];
        a(KeyEvent.keyCodeFromString("") + 16, new int[]{-1956562530, -934447243, -642148819, -1382063923, -1211289970, -716865802, 845960091, 666362921}, objArr11);
        String str4 = (String) objArr11[0];
        Object[] objArr12 = new Object[1];
        a(16 - ExpandableListView.getPackedPositionGroup(0L), new int[]{-1154879873, -420053967, -1173545524, 1231184497, -480164013, -1718094256, -962426498, -1912382647}, objArr12);
        String str5 = (String) objArr12[0];
        Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(1313006081);
        if (objAccessartificialFrame5 == null) {
            int pressedStateDuration = (ViewConfiguration.getPressedStateDuration() >> 16) + 21;
            char maximumFlingVelocity = (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16);
            int pressedStateDuration2 = 465 - (ViewConfiguration.getPressedStateDuration() >> 16);
            byte b = $$a[110];
            Object[] objArr13 = new Object[1];
            b((byte) 47, b, (byte) (b - 1), objArr13);
            objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(pressedStateDuration, maximumFlingVelocity, pressedStateDuration2, -785931255, false, (String) objArr13[0], null);
        }
        long j = ((Field) objAccessartificialFrame5).getLong(null);
        if (j == -1 || j + 1958 < ((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Object[] objArr14 = new Object[1];
            a((ViewConfiguration.getScrollBarSize() >> 8) + 26, new int[]{1716773826, 433105227, 1034725174, -421568069, 1752005010, 87422074, -192555714, 1917796967, -687254647, 776778856, 1288976368, -1312853556, 1045960787, 607512870}, objArr14);
            Class<?> cls = Class.forName((String) objArr14[0]);
            Object[] objArr15 = new Object[1];
            a(17 - ((byte) KeyEvent.getModifierMetaStateMask()), new int[]{-348800179, -1445666403, 747779126, -267073938, 2118423133, -1427966926, 238105472, -1309072897, -142701149, 452418040}, objArr15);
            Context applicationContext2 = (Context) cls.getMethod((String) objArr15[0], new Class[0]).invoke(null, null);
            if (applicationContext2 != null) {
                applicationContext2 = ((applicationContext2 instanceof ContextWrapper) && ((ContextWrapper) applicationContext2).getBaseContext() == null) ? null : applicationContext2.getApplicationContext();
            }
            int iIntValue = ((Integer) Class.forName(str4).getMethod(str5, Object.class).invoke(null, this)).intValue();
            Object[] objArr16 = new Object[1];
            a((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 64, new int[]{898212630, -1708091508, -596008016, 996226386, -131286020, -548763689, -264855981, -2027374292, 1558671402, 137187962, 129076199, 1374696929, 276692395, 1347377808, 171387589, -1499795715, -923658348, 758560101, -2095568570, 2059693560, 372804625, -1136003319, 1104855060, -488228558, 1081760157, 729169799, -602849826, 343487302, 306380702, -1217012749, 1188497517, 1998760075}, objArr16);
            String str6 = (String) objArr16[0];
            Object[] objArr17 = new Object[1];
            a(TextUtils.getOffsetBefore("", 0) + 64, new int[]{1547781900, -1715493046, -1021089281, 1721941422, 1184956650, 1050375343, -2071059260, 2056051309, 1113327616, 229378524, -154136166, 1315053140, -541528543, -600987588, -291054248, -1410235300, 93255707, 346461505, 894001238, 29250044, -2107758061, 398540230, -1388958458, 1396599635, -173986035, -537974786, -1906019489, -899234660, 1425283432, 1445488945, 1826374944, -1463278937}, objArr17);
            try {
                Object[] objArr18 = {applicationContext2, new String[]{str6, (String) objArr17[0]}, Integer.valueOf(iIntValue), 1, 905244895};
                byte[] bArr = $$d;
                Object[] objArr19 = new Object[1];
                c(bArr[8], bArr[15], (short) 525, objArr19);
                Class<?> cls2 = Class.forName((String) objArr19[0]);
                Object[] objArr20 = new Object[1];
                c(bArr[441], (byte) (bArr[181] - 1), (short) 478, objArr20);
                objArr = (Object[]) cls2.getMethod((String) objArr20[0], Context.class, String[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr18);
                int i6 = ((int[]) objArr[0])[0];
                int i7 = ((int[]) objArr[3])[0];
                if (applicationContext2 != null) {
                    Object objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(1142731807);
                    if (objAccessartificialFrame6 == null) {
                        int i8 = 22 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                        char threadPriority = (char) ((Process.getThreadPriority(0) + 20) >> 6);
                        int i9 = 466 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                        byte[] bArr2 = $$a;
                        Object[] objArr21 = new Object[1];
                        b((byte) 47, bArr2[110], bArr2[102], objArr21);
                        objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(i8, threadPriority, i9, -612765161, false, (String) objArr21[0], null);
                    }
                    ((Field) objAccessartificialFrame6).set(null, objArr);
                    try {
                        Long lValueOf3 = Long.valueOf(((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue());
                        Object objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(1313006081);
                        if (objAccessartificialFrame7 == null) {
                            int iIndexOf = TextUtils.indexOf("", "", 0) + 21;
                            char cAlpha = (char) Color.alpha(0);
                            int maxKeyCode = (KeyEvent.getMaxKeyCode() >> 16) + 465;
                            byte b2 = $$a[110];
                            Object[] objArr22 = new Object[1];
                            b((byte) 47, b2, (byte) (b2 - 1), objArr22);
                            objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(iIndexOf, cAlpha, maxKeyCode, -785931255, false, (String) objArr22[0], null);
                        }
                        ((Field) objAccessartificialFrame7).set(null, lValueOf3);
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
            Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(1142731807);
            if (objAccessartificialFrame8 == null) {
                int iResolveSize = View.resolveSize(0, 0) + 21;
                char keyRepeatTimeout2 = (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16);
                int i10 = 466 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1));
                byte[] bArr3 = $$a;
                Object[] objArr23 = new Object[1];
                b((byte) 47, bArr3[110], bArr3[102], objArr23);
                objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(iResolveSize, keyRepeatTimeout2, i10, -612765161, false, (String) objArr23[0], null);
            }
            Object[] objArr24 = (Object[]) ((Field) objAccessartificialFrame8).get(null);
            objArr = new Object[]{new int[]{i}, strArr, new int[1], new int[]{i}};
            int i11 = ((int[]) objArr24[3])[0];
            int i12 = ((int[]) objArr24[0])[0];
            String[] strArr = (String[]) objArr24[1];
            int iIdentityHashCode = System.identityHashCode(this);
            int i13 = (-913990612) + (((~((~iIdentityHashCode) | 506522376)) | 8520930) * 529) + (((~(iIdentityHashCode | 506522376)) | 346172650) * 529) + 905244895;
            int i14 = (i13 << 13) ^ i13;
            int i15 = i14 ^ (i14 >>> 17);
            ((int[]) objArr[2])[0] = i15 ^ (i15 << 5);
        }
        int i16 = ((int[]) objArr[0])[0];
        int i17 = ((int[]) objArr[3])[0];
        if (i17 == i16) {
            Object[] objArr25 = {new int[]{i}, strArr, new int[1], new int[]{i}};
            int i18 = ((int[]) objArr[2])[0];
            int i19 = ((int[]) objArr[3])[0];
            int i20 = ((int[]) objArr[0])[0];
            String[] strArr2 = (String[]) objArr[1];
            int iIdentityHashCode2 = System.identityHashCode(this);
            int i21 = i18 + (-77974157) + (((~((-286262878) | iIdentityHashCode2)) | 269485145) * (-140)) + ((~((-16777733) | iIdentityHashCode2)) * 70) + (((~(iIdentityHashCode2 | 446612603)) | (-193905191)) * 70);
            int i22 = (i21 << 13) ^ i21;
            int i23 = i22 ^ (i22 >>> 17);
            ((int[]) objArr25[2])[0] = i23 ^ (i23 << 5);
        } else {
            ArrayList arrayList = new ArrayList();
            String[] strArr3 = (String[]) objArr[1];
            if (strArr3 != null) {
                for (String str7 : strArr3) {
                    arrayList.add(str7);
                }
            }
            long j2 = ((long) (i16 ^ i17)) ^ (((long) 988939964) << 32);
            long j3 = 988940028;
            int i24 = artificialFrame + 121;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i24 % 128;
            int i25 = i24 % 2;
            try {
                Object[] objArr26 = {Long.valueOf(j2), Long.valueOf(j3)};
                byte[] bArr4 = $$d;
                Object[] objArr27 = new Object[1];
                c(bArr4[8], bArr4[29], (short) FacebookRequestErrorClassification.ESC_APP_NOT_INSTALLED, objArr27);
                Class<?> cls3 = Class.forName((String) objArr27[0]);
                Object[] objArr28 = new Object[1];
                c((byte) ($$e & 463), bArr4[74], (short) TypedValues.CycleType.TYPE_PATH_ROTATE, objArr28);
                cls3.getMethod((String) objArr28[0], Long.TYPE, Long.TYPE).invoke(null, objArr26);
                Object[] objArr29 = {new int[]{i}, strArr, new int[1], new int[]{i}};
                int i26 = ((int[]) objArr[2])[0];
                int i27 = ((int[]) objArr[3])[0];
                int i28 = ((int[]) objArr[0])[0];
                String[] strArr4 = (String[]) objArr[1];
                int elapsedCpuTime = (int) Process.getElapsedCpuTime();
                int i29 = i26 + (((1387129615 + (((-304283777) | (~elapsedCpuTime)) * (-490))) + (((~(elapsedCpuTime | 227860331)) | (-532144108)) * 490)) - 1244367396);
                int i30 = (i29 << 13) ^ i29;
                int i31 = i30 ^ (i30 >>> 17);
                ((int[]) objArr29[2])[0] = i31 ^ (i31 << 5);
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 == null) {
                    throw th2;
                }
                throw cause2;
            }
        }
        Object objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(-1283093189);
        if (objAccessartificialFrame9 == null) {
            int keyRepeatDelay = 30 - (ViewConfiguration.getKeyRepeatDelay() >> 16);
            char c2 = (char) ((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 49362);
            int absoluteGravity = Gravity.getAbsoluteGravity(0, 0) + 684;
            byte[] bArr5 = $$a;
            byte b3 = (byte) (bArr5[104] + 1);
            byte b4 = bArr5[102];
            Object[] objArr30 = new Object[1];
            b(b3, b4, (byte) (b4 << 1), objArr30);
            objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(keyRepeatDelay, c2, absoluteGravity, 752929587, false, (String) objArr30[0], null);
        }
        long j4 = ((Field) objAccessartificialFrame9).getLong(null);
        if (j4 != -1) {
            int i32 = getARTIFICIAL_FRAME_PACKAGE_NAME + 17;
            artificialFrame = i32 % 128;
            int i33 = i32 % 2;
            if (j4 + 1896 >= ((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue()) {
                int i34 = artificialFrame + 25;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i34 % 128;
                int i35 = i34 % 2;
                Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-326560385);
                if (objAccessartificialFrame10 == null) {
                    int keyRepeatDelay2 = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 30;
                    char cResolveSizeAndState = (char) (49362 - View.resolveSizeAndState(0, 0, 0));
                    int iIndexOf2 = 683 - TextUtils.indexOf((CharSequence) "", '0');
                    byte[] bArr6 = $$a;
                    Object[] objArr31 = new Object[1];
                    b((byte) (bArr6[15] - 1), bArr6[102], (byte) (-bArr6[63]), objArr31);
                    objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(keyRepeatDelay2, cResolveSizeAndState, iIndexOf2, 1944867703, false, (String) objArr31[0], null);
                }
                Object[] objArr32 = (Object[]) ((Field) objAccessartificialFrame10).get(null);
                objArr2 = new Object[]{new int[]{((int[]) objArr32[0])[0]}, new int[]{((int[]) objArr32[1])[0]}, new int[1], (String) objArr32[3]};
                int i36 = (~System.identityHashCode(this)) | 992658939;
                int i37 = (-696291232) + (i36 * 495) + (((~i36) | 992527651) * 495) + 778444113;
                int i38 = (i37 << 13) ^ i37;
                int i39 = i38 ^ (i38 >>> 17);
                ((int[]) objArr2[2])[0] = i39 ^ (i39 << 5);
            } else {
                Object[] objArr33 = new Object[1];
                a(25 - TextUtils.lastIndexOf("", '0', 0, 0), new int[]{1716773826, 433105227, 1034725174, -421568069, 1752005010, 87422074, -192555714, 1917796967, -687254647, 776778856, 1288976368, -1312853556, 1045960787, 607512870}, objArr33);
                Class<?> cls4 = Class.forName((String) objArr33[0]);
                Object[] objArr34 = new Object[1];
                a((ViewConfiguration.getEdgeSlop() >> 16) + 18, new int[]{-348800179, -1445666403, 747779126, -267073938, 2118423133, -1427966926, 238105472, -1309072897, -142701149, 452418040}, objArr34);
                applicationContext = (Context) cls4.getMethod((String) objArr34[0], new Class[0]).invoke(null, null);
                if (applicationContext != null) {
                    if ((applicationContext instanceof ContextWrapper) || ((ContextWrapper) applicationContext).getBaseContext() != null) {
                        applicationContext = applicationContext.getApplicationContext();
                    } else {
                        applicationContext = null;
                    }
                }
                Object[] objArr35 = {applicationContext, Integer.valueOf(((Integer) Class.forName(str4).getMethod(str5, Object.class).invoke(null, this)).intValue()), 0, 778444113};
                byte[] bArr7 = $$d;
                byte b5 = bArr7[8];
                byte b6 = bArr7[4];
                Object[] objArr36 = new Object[1];
                c(b5, b6, (short) (b6 | 398), objArr36);
                Class<?> cls5 = Class.forName((String) objArr36[0]);
                byte b7 = bArr7[181];
                Object[] objArr37 = new Object[1];
                c((byte) (b7 - 1), b7, (short) 366, objArr37);
                objArr2 = (Object[]) cls5.getMethod((String) objArr37[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr35);
                if (applicationContext != null) {
                    i = getARTIFICIAL_FRAME_PACKAGE_NAME + 87;
                    artificialFrame = i % 128;
                    try {
                        if (i % 2 == 0) {
                            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-326560385);
                            if (objAccessartificialFrame3 == null) {
                                int i40 = 31 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1));
                                char c3 = (char) ((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 49363);
                                int keyRepeatTimeout3 = (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 684;
                                byte[] bArr8 = $$a;
                                Object[] objArr38 = new Object[1];
                                b((byte) (bArr8[15] - 1), bArr8[102], (byte) (-bArr8[63]), objArr38);
                                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(i40, c3, keyRepeatTimeout3, 1944867703, false, (String) objArr38[0], null);
                            }
                            ((Field) objAccessartificialFrame3).set(null, objArr2);
                            lValueOf = Long.valueOf(((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[1])).longValue());
                            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1283093189);
                            if (objAccessartificialFrame2 == null) {
                                gidForName = 30 - (ViewConfiguration.getMaximumFlingVelocity() >> 16);
                                char cIndexOf = (char) (49362 - TextUtils.indexOf("", "", 0));
                                int iAxisFromString = MotionEvent.axisFromString("") + 685;
                                i2 = 752929587;
                                z = false;
                                byte[] bArr9 = $$a;
                                byte b8 = (byte) (bArr9[104] + 1);
                                byte b9 = bArr9[102];
                                Object[] objArr39 = new Object[1];
                                b(b8, b9, (byte) (b9 << 1), objArr39);
                                str = (String) objArr39[0];
                                clsArr = null;
                                c = cIndexOf;
                                i3 = iAxisFromString;
                                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(gidForName, c, i3, i2, z, str, clsArr);
                            }
                        } else {
                            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-326560385);
                            if (objAccessartificialFrame == null) {
                                int scrollBarFadeDuration = 30 - (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                                char gidForName2 = (char) (Process.getGidForName("") + 49363);
                                int iResolveSize2 = 684 - View.resolveSize(0, 0);
                                byte[] bArr10 = $$a;
                                Object[] objArr40 = new Object[1];
                                b((byte) (bArr10[15] - 1), bArr10[102], (byte) (-bArr10[63]), objArr40);
                                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(scrollBarFadeDuration, gidForName2, iResolveSize2, 1944867703, false, (String) objArr40[0], null);
                            }
                            ((Field) objAccessartificialFrame).set(null, objArr2);
                            lValueOf = Long.valueOf(((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue());
                            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1283093189);
                            if (objAccessartificialFrame2 == null) {
                                gidForName = Process.getGidForName("") + 31;
                                char c4 = (char) (49362 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)));
                                int i41 = (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 684;
                                i2 = 752929587;
                                z = false;
                                byte[] bArr11 = $$a;
                                byte b10 = (byte) (bArr11[104] + 1);
                                byte b11 = bArr11[102];
                                Object[] objArr41 = new Object[1];
                                b(b10, b11, (byte) (b11 << 1), objArr41);
                                str = (String) objArr41[0];
                                clsArr = null;
                                c = c4;
                                i3 = i41;
                                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(gidForName, c, i3, i2, z, str, clsArr);
                            }
                        }
                        ((Field) objAccessartificialFrame2).set(null, lValueOf);
                    } catch (Exception unused2) {
                        throw new RuntimeException();
                    }
                }
            }
        } else {
            Object[] objArr310 = new Object[1];
            a(25 - TextUtils.lastIndexOf("", '0', 0, 0), new int[]{1716773826, 433105227, 1034725174, -421568069, 1752005010, 87422074, -192555714, 1917796967, -687254647, 776778856, 1288976368, -1312853556, 1045960787, 607512870}, objArr310);
            Class<?> cls6 = Class.forName((String) objArr310[0]);
            Object[] objArr311 = new Object[1];
            a((ViewConfiguration.getEdgeSlop() >> 16) + 18, new int[]{-348800179, -1445666403, 747779126, -267073938, 2118423133, -1427966926, 238105472, -1309072897, -142701149, 452418040}, objArr311);
            applicationContext = (Context) cls6.getMethod((String) objArr311[0], new Class[0]).invoke(null, null);
            if (applicationContext != null) {
                if (applicationContext instanceof ContextWrapper) {
                    applicationContext = applicationContext.getApplicationContext();
                } else {
                    applicationContext = applicationContext.getApplicationContext();
                }
            }
            Object[] objArr312 = {applicationContext, Integer.valueOf(((Integer) Class.forName(str4).getMethod(str5, Object.class).invoke(null, this)).intValue()), 0, 778444113};
            byte[] bArr12 = $$d;
            byte b12 = bArr12[8];
            byte b13 = bArr12[4];
            Object[] objArr313 = new Object[1];
            c(b12, b13, (short) (b13 | 398), objArr313);
            Class<?> cls7 = Class.forName((String) objArr313[0]);
            byte b14 = bArr12[181];
            Object[] objArr314 = new Object[1];
            c((byte) (b14 - 1), b14, (short) 366, objArr314);
            objArr2 = (Object[]) cls7.getMethod((String) objArr314[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr312);
            if (applicationContext != null) {
                i = getARTIFICIAL_FRAME_PACKAGE_NAME + 87;
                artificialFrame = i % 128;
                if (i % 2 == 0) {
                    objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-326560385);
                    if (objAccessartificialFrame3 == null) {
                        int i42 = 31 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1));
                        char c5 = (char) ((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 49363);
                        int keyRepeatTimeout4 = (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 684;
                        byte[] bArr13 = $$a;
                        Object[] objArr315 = new Object[1];
                        b((byte) (bArr13[15] - 1), bArr13[102], (byte) (-bArr13[63]), objArr315);
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(i42, c5, keyRepeatTimeout4, 1944867703, false, (String) objArr315[0], null);
                    }
                    ((Field) objAccessartificialFrame3).set(null, objArr2);
                    lValueOf = Long.valueOf(((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[1])).longValue());
                    objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1283093189);
                    if (objAccessartificialFrame2 == null) {
                        gidForName = 30 - (ViewConfiguration.getMaximumFlingVelocity() >> 16);
                        char cIndexOf2 = (char) (49362 - TextUtils.indexOf("", "", 0));
                        int iAxisFromString2 = MotionEvent.axisFromString("") + 685;
                        i2 = 752929587;
                        z = false;
                        byte[] bArr14 = $$a;
                        byte b15 = (byte) (bArr14[104] + 1);
                        byte b16 = bArr14[102];
                        Object[] objArr316 = new Object[1];
                        b(b15, b16, (byte) (b16 << 1), objArr316);
                        str = (String) objArr316[0];
                        clsArr = null;
                        c = cIndexOf2;
                        i3 = iAxisFromString2;
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(gidForName, c, i3, i2, z, str, clsArr);
                    }
                } else {
                    objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-326560385);
                    if (objAccessartificialFrame == null) {
                        int scrollBarFadeDuration2 = 30 - (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                        char gidForName3 = (char) (Process.getGidForName("") + 49363);
                        int iResolveSize3 = 684 - View.resolveSize(0, 0);
                        byte[] bArr15 = $$a;
                        Object[] objArr42 = new Object[1];
                        b((byte) (bArr15[15] - 1), bArr15[102], (byte) (-bArr15[63]), objArr42);
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(scrollBarFadeDuration2, gidForName3, iResolveSize3, 1944867703, false, (String) objArr42[0], null);
                    }
                    ((Field) objAccessartificialFrame).set(null, objArr2);
                    lValueOf = Long.valueOf(((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1283093189);
                    if (objAccessartificialFrame2 == null) {
                        gidForName = Process.getGidForName("") + 31;
                        char c6 = (char) (49362 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)));
                        int i43 = (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 684;
                        i2 = 752929587;
                        z = false;
                        byte[] bArr16 = $$a;
                        byte b17 = (byte) (bArr16[104] + 1);
                        byte b18 = bArr16[102];
                        Object[] objArr43 = new Object[1];
                        b(b17, b18, (byte) (b18 << 1), objArr43);
                        str = (String) objArr43[0];
                        clsArr = null;
                        c = c6;
                        i3 = i43;
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(gidForName, c, i3, i2, z, str, clsArr);
                    }
                }
                ((Field) objAccessartificialFrame2).set(null, lValueOf);
            }
        }
        int i44 = ((int[]) objArr2[1])[0];
        int i45 = ((int[]) objArr2[0])[0];
        if (i45 == i44) {
            int i46 = ((int[]) objArr2[2])[0];
            Object[] objArr44 = {new int[]{((int[]) objArr2[0])[0]}, new int[]{((int[]) objArr2[1])[0]}, new int[1], (String) objArr2[3]};
            int elapsedCpuTime2 = (int) Process.getElapsedCpuTime();
            int i47 = i46 + ((((~((-344838770) | elapsedCpuTime2)) | 269029456) * (-566)) - 1369526786) + ((~(elapsedCpuTime2 | (-75809314))) * 566);
            int i48 = (i47 << 13) ^ i47;
            int i49 = i48 ^ (i48 >>> 17);
            ((int[]) objArr44[2])[0] = i49 ^ (i49 << 5);
        } else {
            long j5 = ((long) (i44 ^ i45)) ^ (((long) 46086110) << 32);
            long j6 = 46086106;
            int i50 = getARTIFICIAL_FRAME_PACKAGE_NAME + AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
            artificialFrame = i50 % 128;
            int i51 = i50 % 2;
            Object[] objArr45 = {Long.valueOf(j5), Long.valueOf(j6)};
            byte[] bArr17 = $$d;
            Object[] objArr46 = new Object[1];
            c(bArr17[8], (byte) (-bArr17[264]), (short) 347, objArr46);
            Class<?> cls8 = Class.forName((String) objArr46[0]);
            Object[] objArr47 = new Object[1];
            c((byte) ($$e & 463), bArr17[74], (short) TypedValues.CycleType.TYPE_PATH_ROTATE, objArr47);
            cls8.getMethod((String) objArr47[0], Long.TYPE, Long.TYPE).invoke(null, objArr45);
            int i52 = ((int[]) objArr2[2])[0];
            Object[] objArr48 = {new int[]{((int[]) objArr2[0])[0]}, new int[]{((int[]) objArr2[1])[0]}, new int[1], (String) objArr2[3]};
            int startElapsedRealtime = (int) Process.getStartElapsedRealtime();
            int i53 = ~startElapsedRealtime;
            int i54 = i52 + (-104172642) + ((153732 | i53) * (-192)) + (((~((-775529083) | i53)) | 202940960) * (-384)) + (((~(startElapsedRealtime | 775682814)) | (~(i53 | (-572588123))) | (~((-202940961) | startElapsedRealtime))) * JfifUtil.MARKER_SOFn);
            int i55 = (i54 << 13) ^ i54;
            int i56 = i55 ^ (i55 >>> 17);
            ((int[]) objArr48[2])[0] = i56 ^ (i56 << 5);
        }
        Object objAccessartificialFrame11 = ArtificialStackFrames.accessartificialFrame(1056123296);
        if (objAccessartificialFrame11 == null) {
            int touchSlop = 30 - (ViewConfiguration.getTouchSlop() >> 8);
            char c7 = (char) ((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 49362);
            int iNormalizeMetaState = KeyEvent.normalizeMetaState(0) + 684;
            byte[] bArr18 = $$a;
            Object[] objArr49 = new Object[1];
            b((byte) (bArr18[15] - 1), bArr18[4], (byte) 46, objArr49);
            objAccessartificialFrame11 = ArtificialStackFrames.coroutineCreation(touchSlop, c7, iNormalizeMetaState, -1583976536, false, (String) objArr49[0], null);
        }
        long j7 = ((Field) objAccessartificialFrame11).getLong(null);
        if (j7 == -1 || j7 + 1983 < ((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Object[] objArr50 = {Integer.valueOf(((Integer) Class.forName(str4).getMethod(str5, Object.class).invoke(null, this)).intValue()), 643321328};
            byte[] bArr19 = $$d;
            byte b19 = bArr19[8];
            byte b20 = (byte) (-bArr19[160]);
            Object[] objArr51 = new Object[1];
            c(b19, b20, (short) (b20 | 289), objArr51);
            Class<?> cls9 = Class.forName((String) objArr51[0]);
            Object[] objArr52 = new Object[1];
            c(bArr19[8], bArr19[1], (short) 273, objArr52);
            objArr3 = (Object[]) cls9.getMethod((String) objArr52[0], Integer.TYPE, Integer.TYPE).invoke(null, objArr50);
            Object objAccessartificialFrame12 = ArtificialStackFrames.accessartificialFrame(910856866);
            if (objAccessartificialFrame12 == null) {
                int tapTimeout = (ViewConfiguration.getTapTimeout() >> 16) + 30;
                char jumpTapTimeout = (char) ((ViewConfiguration.getJumpTapTimeout() >> 16) + 49362);
                int touchSlop2 = 684 - (ViewConfiguration.getTouchSlop() >> 8);
                Object[] objArr53 = new Object[1];
                b((byte) ($$b & 124), $$a[110], (byte) 58, objArr53);
                objAccessartificialFrame12 = ArtificialStackFrames.coroutineCreation(tapTimeout, jumpTapTimeout, touchSlop2, -1456483158, false, (String) objArr53[0], null);
            }
            ((Field) objAccessartificialFrame12).set(null, objArr3);
            try {
                Long lValueOf4 = Long.valueOf(((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame13 = ArtificialStackFrames.accessartificialFrame(1056123296);
                if (objAccessartificialFrame13 == null) {
                    int i57 = (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 29;
                    char deadChar = (char) (49362 - KeyEvent.getDeadChar(0, 0));
                    int iRgb = (-16776532) - Color.rgb(0, 0, 0);
                    byte[] bArr20 = $$a;
                    Object[] objArr54 = new Object[1];
                    b((byte) (bArr20[15] - 1), bArr20[4], (byte) 46, objArr54);
                    objAccessartificialFrame13 = ArtificialStackFrames.coroutineCreation(i57, deadChar, iRgb, -1583976536, false, (String) objArr54[0], null);
                }
                ((Field) objAccessartificialFrame13).set(null, lValueOf4);
            } catch (Exception unused3) {
                throw new RuntimeException();
            }
        } else {
            Object objAccessartificialFrame14 = ArtificialStackFrames.accessartificialFrame(910856866);
            if (objAccessartificialFrame14 == null) {
                int doubleTapTimeout = (ViewConfiguration.getDoubleTapTimeout() >> 16) + 30;
                char minimumFlingVelocity2 = (char) (49362 - (ViewConfiguration.getMinimumFlingVelocity() >> 16));
                int jumpTapTimeout2 = 684 - (ViewConfiguration.getJumpTapTimeout() >> 16);
                Object[] objArr55 = new Object[1];
                b((byte) ($$b & 124), $$a[110], (byte) 58, objArr55);
                objAccessartificialFrame14 = ArtificialStackFrames.coroutineCreation(doubleTapTimeout, minimumFlingVelocity2, jumpTapTimeout2, -1456483158, false, (String) objArr55[0], null);
            }
            Object[] objArr56 = (Object[]) ((Field) objAccessartificialFrame14).get(null);
            objArr3 = new Object[]{new int[]{((int[]) objArr56[0])[0]}, new int[]{((int[]) objArr56[1])[0]}, new int[1], (String) objArr56[3]};
            int i58 = ~System.identityHashCode(this);
            int i59 = (-469710298) + (((~(939260894 | i58)) | 39362880) * (-828)) + ((i58 | 939260894) * (-828)) + 324380844;
            int i60 = (i59 << 13) ^ i59;
            int i61 = i60 ^ (i60 >>> 17);
            ((int[]) objArr3[2])[0] = i61 ^ (i61 << 5);
        }
        int i62 = ((int[]) objArr3[1])[0];
        int i63 = ((int[]) objArr3[0])[0];
        if (i63 == i62) {
            int i64 = artificialFrame + 93;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i64 % 128;
            int i65 = i64 % 2;
            int i66 = ((int[]) objArr3[2])[0];
            Object[] objArr57 = {new int[]{((int[]) objArr3[0])[0]}, new int[]{((int[]) objArr3[1])[0]}, new int[1], (String) objArr3[3]};
            int iIdentityHashCode3 = System.identityHashCode(this);
            int i67 = i66 + (-1070453370) + (((~(936639230 | iIdentityHashCode3)) | 41984544) * (-756)) + (((~iIdentityHashCode3) | 936639230) * 756);
            int i68 = (i67 << 13) ^ i67;
            int i69 = i68 ^ (i68 >>> 17);
            ((int[]) objArr57[2])[0] = i69 ^ (i69 << 5);
        } else {
            new ArrayList().add((String) objArr3[3]);
            long j8 = (((long) 1270256036) << 32) ^ ((long) (i62 ^ i63));
            long j9 = 1270256052;
            int i70 = getARTIFICIAL_FRAME_PACKAGE_NAME + 17;
            artificialFrame = i70 % 128;
            int i71 = i70 % 2;
            Object[] objArr58 = {Long.valueOf(j8), Long.valueOf(j9)};
            byte[] bArr21 = $$d;
            Object[] objArr59 = new Object[1];
            c(bArr21[8], bArr21[287], (short) 257, objArr59);
            Class<?> cls10 = Class.forName((String) objArr59[0]);
            Object[] objArr60 = new Object[1];
            c((byte) ($$e & 463), bArr21[74], (short) TypedValues.CycleType.TYPE_PATH_ROTATE, objArr60);
            cls10.getMethod((String) objArr60[0], Long.TYPE, Long.TYPE).invoke(null, objArr58);
            int i72 = ((int[]) objArr3[2])[0];
            Object[] objArr61 = {new int[]{((int[]) objArr3[0])[0]}, new int[]{((int[]) objArr3[1])[0]}, new int[1], (String) objArr3[3]};
            int iIdentityHashCode4 = System.identityHashCode(this);
            int i73 = i72 + ((~(iIdentityHashCode4 | 85165973)) * TypedValues.CycleType.TYPE_EASING) + 1488062354 + (((~((~iIdentityHashCode4) | 85165973)) | 83953025) * TypedValues.CycleType.TYPE_EASING);
            int i74 = (i73 << 13) ^ i73;
            int i75 = i74 ^ (i74 >>> 17);
            ((int[]) objArr61[2])[0] = i75 ^ (i75 << 5);
        }
        Object objAccessartificialFrame15 = ArtificialStackFrames.accessartificialFrame(-2127922582);
        if (objAccessartificialFrame15 == null) {
            int modifierMetaStateMask2 = 29 - ((byte) KeyEvent.getModifierMetaStateMask());
            char cNormalizeMetaState = (char) (KeyEvent.normalizeMetaState(0) + 49362);
            int iCombineMeasuredStates = View.combineMeasuredStates(0, 0) + 684;
            byte[] bArr22 = $$a;
            Object[] objArr62 = new Object[1];
            b((byte) (bArr22[104] + 1), bArr22[4], (byte) 66, objArr62);
            objAccessartificialFrame15 = ArtificialStackFrames.coroutineCreation(modifierMetaStateMask2, cNormalizeMetaState, iCombineMeasuredStates, 508509282, false, (String) objArr62[0], null);
        }
        long j10 = ((Field) objAccessartificialFrame15).getLong(null);
        if (j10 == -1 || j10 + 1894 < ((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Object[] objArr63 = new Object[1];
            a((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 26, new int[]{1716773826, 433105227, 1034725174, -421568069, 1752005010, 87422074, -192555714, 1917796967, -687254647, 776778856, 1288976368, -1312853556, 1045960787, 607512870}, objArr63);
            Class<?> cls11 = Class.forName((String) objArr63[0]);
            Object[] objArr64 = new Object[1];
            a((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 18, new int[]{-348800179, -1445666403, 747779126, -267073938, 2118423133, -1427966926, 238105472, -1309072897, -142701149, 452418040}, objArr64);
            Context applicationContext3 = (Context) cls11.getMethod((String) objArr64[0], new Class[0]).invoke(null, null);
            if (applicationContext3 != null) {
                applicationContext3 = (!((applicationContext3 instanceof ContextWrapper) ^ true) && ((ContextWrapper) applicationContext3).getBaseContext() == null) ? null : applicationContext3.getApplicationContext();
            }
            Object[] objArr65 = {applicationContext3, Integer.valueOf(((Integer) Class.forName(str4).getMethod(str5, Object.class).invoke(null, this)).intValue()), -1013744162};
            byte[] bArr23 = $$d;
            Object[] objArr66 = new Object[1];
            c(bArr23[30], bArr23[75], (short) 233, objArr66);
            Class<?> cls12 = Class.forName((String) objArr66[0]);
            Object[] objArr67 = new Object[1];
            c(bArr23[441], (byte) (bArr23[181] - 1), (short) 478, objArr67);
            objArr4 = (Object[]) cls12.getMethod((String) objArr67[0], Context.class, Integer.TYPE, Integer.TYPE).invoke(null, objArr65);
            if (applicationContext3 != null) {
                int i76 = artificialFrame + 49;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i76 % 128;
                try {
                    if (i76 % 2 != 0) {
                        Object objAccessartificialFrame16 = ArtificialStackFrames.accessartificialFrame(777251007);
                        if (objAccessartificialFrame16 == null) {
                            int i77 = 30 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                            char c8 = (char) (49361 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)));
                            int pressedStateDuration3 = (ViewConfiguration.getPressedStateDuration() >> 16) + 684;
                            byte[] bArr24 = $$a;
                            byte b21 = bArr24[15];
                            byte b22 = (byte) (bArr24[110] - 1);
                            Object[] objArr68 = new Object[1];
                            b(b21, b22, (byte) (b22 | 78), objArr68);
                            objAccessartificialFrame16 = ArtificialStackFrames.coroutineCreation(i77, c8, pressedStateDuration3, -1321816393, false, (String) objArr68[0], null);
                        }
                        ((Field) objAccessartificialFrame16).set(null, objArr4);
                        lValueOf2 = Long.valueOf(((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[1]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-2127922582);
                        if (objAccessartificialFrame4 == null) {
                            minimumFlingVelocity = (ViewConfiguration.getJumpTapTimeout() >> 16) + 30;
                            modifierMetaStateMask = (char) (49362 - (ViewConfiguration.getScrollBarSize() >> 8));
                            keyRepeatTimeout = 684 - (KeyEvent.getMaxKeyCode() >> 16);
                            i4 = 508509282;
                            z2 = false;
                            byte[] bArr25 = $$a;
                            Object[] objArr69 = new Object[1];
                            b((byte) (bArr25[104] + 1), bArr25[4], (byte) 66, objArr69);
                            obj = objArr69[0];
                            objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(minimumFlingVelocity, modifierMetaStateMask, keyRepeatTimeout, i4, z2, (String) obj, null);
                        }
                    } else {
                        Object objAccessartificialFrame17 = ArtificialStackFrames.accessartificialFrame(777251007);
                        if (objAccessartificialFrame17 == null) {
                            int i78 = (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 30;
                            char cResolveOpacity = (char) (Drawable.resolveOpacity(0, 0) + 49362);
                            int iIndexOf3 = 683 - TextUtils.indexOf((CharSequence) "", '0', 0);
                            byte[] bArr26 = $$a;
                            byte b23 = bArr26[15];
                            byte b24 = (byte) (bArr26[110] - 1);
                            Object[] objArr70 = new Object[1];
                            b(b23, b24, (byte) (b24 | 78), objArr70);
                            objAccessartificialFrame17 = ArtificialStackFrames.coroutineCreation(i78, cResolveOpacity, iIndexOf3, -1321816393, false, (String) objArr70[0], null);
                        }
                        ((Field) objAccessartificialFrame17).set(null, objArr4);
                        lValueOf2 = Long.valueOf(((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-2127922582);
                        if (objAccessartificialFrame4 == null) {
                            minimumFlingVelocity = 30 - (ViewConfiguration.getMinimumFlingVelocity() >> 16);
                            modifierMetaStateMask = (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 49363);
                            keyRepeatTimeout = (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 684;
                            i4 = 508509282;
                            z2 = false;
                            byte[] bArr27 = $$a;
                            Object[] objArr71 = new Object[1];
                            b((byte) (bArr27[104] + 1), bArr27[4], (byte) 66, objArr71);
                            obj = objArr71[0];
                            objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(minimumFlingVelocity, modifierMetaStateMask, keyRepeatTimeout, i4, z2, (String) obj, null);
                        }
                    }
                    ((Field) objAccessartificialFrame4).set(null, lValueOf2);
                } catch (Exception unused4) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object objAccessartificialFrame18 = ArtificialStackFrames.accessartificialFrame(777251007);
            if (objAccessartificialFrame18 == null) {
                int iIndexOf4 = 30 - TextUtils.indexOf("", "", 0, 0);
                char cResolveOpacity2 = (char) (Drawable.resolveOpacity(0, 0) + 49362);
                int i79 = (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 684;
                byte[] bArr28 = $$a;
                byte b25 = bArr28[15];
                byte b26 = (byte) (bArr28[110] - 1);
                Object[] objArr72 = new Object[1];
                b(b25, b26, (byte) (b26 | 78), objArr72);
                objAccessartificialFrame18 = ArtificialStackFrames.coroutineCreation(iIndexOf4, cResolveOpacity2, i79, -1321816393, false, (String) objArr72[0], null);
            }
            Object[] objArr73 = (Object[]) ((Field) objAccessartificialFrame18).get(null);
            objArr4 = new Object[]{new int[]{((int[]) objArr73[0])[0]}, new int[]{((int[]) objArr73[1])[0]}, new int[1], (String) objArr73[3]};
            int iNextInt = new Random().nextInt(2068786045);
            int i80 = ~iNextInt;
            int i81 = ((((-1683427954) + (((~(890260273 | i80)) | 88363501) * (-328))) + ((iNextInt | 88363501) * 164)) + ((((~(iNextInt | (-890260274))) | 83902753) | (~(i80 | 894721021))) * 164)) - 1013744162;
            int i82 = (i81 << 13) ^ i81;
            int i83 = i82 ^ (i82 >>> 17);
            ((int[]) objArr4[2])[0] = i83 ^ (i83 << 5);
        }
        int i84 = ((int[]) objArr4[1])[0];
        int i85 = ((int[]) objArr4[0])[0];
        if (i85 == i84) {
            int i86 = ((int[]) objArr4[2])[0];
            Object[] objArr74 = {new int[]{((int[]) objArr4[0])[0]}, new int[]{((int[]) objArr4[1])[0]}, new int[1], (String) objArr4[3]};
            int iIdentityHashCode5 = System.identityHashCode(this);
            int i87 = ~((-348769483) | (~iIdentityHashCode5));
            int i88 = i86 + ((((553783316 | i87) | (~(348769482 | iIdentityHashCode5))) * (-338)) - 821176442) + (((~(iIdentityHashCode5 | 902552798)) | i87) * 338);
            int i89 = (i88 << 13) ^ i88;
            int i90 = i89 ^ (i89 >>> 17);
            ((int[]) objArr74[2])[0] = i90 ^ (i90 << 5);
        } else {
            Object[] objArr75 = {Long.valueOf((((long) (-589916692)) << 32) ^ ((long) (i84 ^ i85))), Long.valueOf(-589916180)};
            byte[] bArr29 = $$d;
            Object[] objArr76 = new Object[1];
            c(bArr29[8], bArr29[287], (short) 257, objArr76);
            Class<?> cls13 = Class.forName((String) objArr76[0]);
            Object[] objArr77 = new Object[1];
            c((byte) ($$e & 463), bArr29[74], (short) TypedValues.CycleType.TYPE_PATH_ROTATE, objArr77);
            cls13.getMethod((String) objArr77[0], Long.TYPE, Long.TYPE).invoke(null, objArr75);
            int i91 = ((int[]) objArr4[2])[0];
            Object[] objArr78 = {new int[]{((int[]) objArr4[0])[0]}, new int[]{((int[]) objArr4[1])[0]}, new int[1], (String) objArr4[3]};
            int iFreeMemory = (int) Runtime.getRuntime().freeMemory();
            int i92 = i91 + ((((-834684540) + (((~((-72754721) | iFreeMemory)) | (~(905869054 | iFreeMemory))) * 69)) + (((~(iFreeMemory | 626943608)) | ((~((-351680167) | iFreeMemory)) | 278925446)) * (-69))) - 415672392);
            int i93 = (i92 << 13) ^ i92;
            int i94 = i93 ^ (i93 >>> 17);
            ((int[]) objArr78[2])[0] = i94 ^ (i94 << 5);
        }
        Object objAccessartificialFrame19 = ArtificialStackFrames.accessartificialFrame(-1168947751);
        if (objAccessartificialFrame19 == null) {
            int keyRepeatTimeout5 = (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 36;
            char trimmedLength = (char) TextUtils.getTrimmedLength("");
            int pressedStateDuration4 = (ViewConfiguration.getPressedStateDuration() >> 16) + 540;
            byte b27 = $$a[110];
            Object[] objArr79 = new Object[1];
            b((byte) 47, b27, (byte) (b27 - 1), objArr79);
            objAccessartificialFrame19 = ArtificialStackFrames.coroutineCreation(keyRepeatTimeout5, trimmedLength, pressedStateDuration4, 624296913, false, (String) objArr79[0], null);
        }
        long j11 = ((Field) objAccessartificialFrame19).getLong(null);
        if (j11 == -1 || j11 + 1960 < ((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue()) {
            try {
                Object objAccessartificialFrame20 = ArtificialStackFrames.accessartificialFrame(-1717965552);
                if (objAccessartificialFrame20 == null) {
                    objAccessartificialFrame20 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 20, (char) ((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 39517), 982 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), 117222168, false, null, new Class[0]);
                }
                Object[] objArr80 = {null, ((Constructor) objAccessartificialFrame20).newInstance(null), 1303348585, 0};
                Object objAccessartificialFrame21 = ArtificialStackFrames.accessartificialFrame(-501205803);
                if (objAccessartificialFrame21 == null) {
                    int i95 = (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 35;
                    char cIndexOf3 = (char) (TextUtils.indexOf((CharSequence) "", '0') + 1);
                    int absoluteGravity2 = 540 - Gravity.getAbsoluteGravity(0, 0);
                    byte[] bArr30 = $$a;
                    Object[] objArr81 = new Object[1];
                    b((byte) (bArr30[110] - 1), bArr30[39], (byte) ($$b >>> 1), objArr81);
                    objAccessartificialFrame21 = ArtificialStackFrames.coroutineCreation(i95, cIndexOf3, absoluteGravity2, 2101703389, false, (String) objArr81[0], new Class[]{(Class) ArtificialStackFrames.coroutineCreation(54 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), (char) (TextUtils.indexOf("", "", 0, 0) + 833), (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 575), (Class) ArtificialStackFrames.coroutineCreation(TextUtils.lastIndexOf("", '0', 0) + 55, (char) View.MeasureSpec.getSize(0), 630 - Gravity.getAbsoluteGravity(0, 0)), Integer.TYPE, Integer.TYPE});
                }
                objArr5 = (Object[]) ((Method) objAccessartificialFrame21).invoke(null, objArr80);
                Object objAccessartificialFrame22 = ArtificialStackFrames.accessartificialFrame(-1339222025);
                if (objAccessartificialFrame22 == null) {
                    int edgeSlop = (ViewConfiguration.getEdgeSlop() >> 16) + 36;
                    char c9 = (char) (1 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)));
                    int deadChar2 = 540 - KeyEvent.getDeadChar(0, 0);
                    byte[] bArr31 = $$a;
                    Object[] objArr82 = new Object[1];
                    b((byte) 47, bArr31[110], bArr31[102], objArr82);
                    objAccessartificialFrame22 = ArtificialStackFrames.coroutineCreation(edgeSlop, c9, deadChar2, 793268735, false, (String) objArr82[0], null);
                }
                ((Field) objAccessartificialFrame22).set(null, objArr5);
                try {
                    Long lValueOf5 = Long.valueOf(((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame23 = ArtificialStackFrames.accessartificialFrame(-1168947751);
                    if (objAccessartificialFrame23 == null) {
                        int edgeSlop2 = 36 - (ViewConfiguration.getEdgeSlop() >> 16);
                        char cAlpha2 = (char) Color.alpha(0);
                        int iIndexOf5 = TextUtils.indexOf("", "") + 540;
                        byte b28 = $$a[110];
                        Object[] objArr83 = new Object[1];
                        b((byte) 47, b28, (byte) (b28 - 1), objArr83);
                        objAccessartificialFrame23 = ArtificialStackFrames.coroutineCreation(edgeSlop2, cAlpha2, iIndexOf5, 624296913, false, (String) objArr83[0], null);
                    }
                    ((Field) objAccessartificialFrame23).set(null, lValueOf5);
                } catch (Exception unused5) {
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
            int i96 = artificialFrame + 77;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i96 % 128;
            int i97 = i96 % 2;
            Object objAccessartificialFrame24 = ArtificialStackFrames.accessartificialFrame(-1339222025);
            if (objAccessartificialFrame24 == null) {
                int packedPositionChild = ExpandableListView.getPackedPositionChild(0L) + 37;
                char tapTimeout2 = (char) (ViewConfiguration.getTapTimeout() >> 16);
                int i98 = 541 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
                byte[] bArr32 = $$a;
                Object[] objArr84 = new Object[1];
                b((byte) 47, bArr32[110], bArr32[102], objArr84);
                objAccessartificialFrame24 = ArtificialStackFrames.coroutineCreation(packedPositionChild, tapTimeout2, i98, 793268735, false, (String) objArr84[0], null);
            }
            Object[] objArr85 = (Object[]) ((Field) objAccessartificialFrame24).get(null);
            objArr5 = new Object[]{new int[1], new int[1], new int[1]};
            int i99 = ((int[]) objArr85[2])[0];
            int i100 = ((int[]) objArr85[1])[0];
            ((int[]) objArr5[2])[0] = i99;
            ((int[]) objArr5[1])[0] = i100;
            int iFreeMemory2 = (int) Runtime.getRuntime().freeMemory();
            int i101 = (((~((-362760009) | iFreeMemory2)) | 795841125) * 262) + 1149882249 + (((~((~iFreeMemory2) | (-362760009))) | 795841125) * 262) + 1303348585;
            int i102 = (i101 << 13) ^ i101;
            int i103 = i102 ^ (i102 >>> 17);
            ((int[]) objArr5[0])[0] = i103 ^ (i103 << 5);
        }
        Object obj2 = objArr5[1];
        int i104 = ((int[]) obj2)[0];
        Object obj3 = objArr5[2];
        int i105 = ((int[]) obj3)[0];
        if (i105 == i104) {
            Object[] objArr86 = {new int[1], new int[1], new int[1]};
            int i106 = ((int[]) objArr5[0])[0];
            int i107 = ((int[]) obj3)[0];
            int i108 = ((int[]) obj2)[0];
            ((int[]) objArr86[2])[0] = i107;
            ((int[]) objArr86[1])[0] = i108;
            int iMyPid = Process.myPid();
            int i109 = ~iMyPid;
            int i110 = i106 + 1883840794 + ((1342167919 | i109) * (-369)) + (((~((-110873383) | i109)) | 1240748367) * (-369)) + (((~(iMyPid | 110873382)) | 1231294537 | (~(i109 | (-101419553)))) * 369);
            int i111 = (i110 << 13) ^ i110;
            int i112 = i111 ^ (i111 >>> 17);
            ((int[]) objArr86[0])[0] = i112 ^ (i112 << 5);
        } else {
            Object[] objArr87 = {Long.valueOf(((long) (i104 ^ i105)) ^ (((long) 703631776) << 32)), Long.valueOf(703627680)};
            byte[] bArr33 = $$d;
            Object[] objArr88 = new Object[1];
            c(bArr33[8], bArr33[287], (short) 257, objArr88);
            Class<?> cls14 = Class.forName((String) objArr88[0]);
            Object[] objArr89 = new Object[1];
            c((byte) ($$e & 463), bArr33[74], (short) TypedValues.CycleType.TYPE_PATH_ROTATE, objArr89);
            cls14.getMethod((String) objArr89[0], Long.TYPE, Long.TYPE).invoke(null, objArr87);
            Object[] objArr90 = {new int[1], new int[1], new int[1]};
            int i113 = ((int[]) objArr5[0])[0];
            int i114 = ((int[]) objArr5[2])[0];
            int i115 = ((int[]) objArr5[1])[0];
            ((int[]) objArr90[2])[0] = i114;
            ((int[]) objArr90[1])[0] = i115;
            int i116 = ~((int) SystemClock.uptimeMillis());
            int i117 = ~(547809097 | i116);
            int i118 = i113 + (-894108751) + ((i117 | 803812652) * 764) + (((~(i116 | 803812652)) | 442945) * (-1528)) + ((256889445 | i117) * 764);
            int i119 = (i118 << 13) ^ i118;
            int i120 = i119 ^ (i119 >>> 17);
            ((int[]) objArr90[0])[0] = i120 ^ (i120 << 5);
        }
        Object objAccessartificialFrame25 = ArtificialStackFrames.accessartificialFrame(1745676544);
        if (objAccessartificialFrame25 == null) {
            int iIndexOf6 = TextUtils.indexOf((CharSequence) "", '0') + 18;
            char cArgb = (char) Color.argb(0, 0, 0, 0);
            int maxKeyCode2 = (KeyEvent.getMaxKeyCode() >> 16) + 747;
            byte b29 = $$a[110];
            Object[] objArr91 = new Object[1];
            b((byte) 47, b29, (byte) (b29 - 1), objArr91);
            objAccessartificialFrame25 = ArtificialStackFrames.coroutineCreation(iIndexOf6, cArgb, maxKeyCode2, -144068856, false, (String) objArr91[0], null);
        }
        long j12 = ((Field) objAccessartificialFrame25).getLong(null);
        if (j12 == -1 || j12 + 4611686018427387804L < ((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Object[] objArr92 = new Object[1];
            a(26 - (ViewConfiguration.getFadingEdgeLength() >> 16), new int[]{1716773826, 433105227, 1034725174, -421568069, 1752005010, 87422074, -192555714, 1917796967, -687254647, 776778856, 1288976368, -1312853556, 1045960787, 607512870}, objArr92);
            Class<?> cls15 = Class.forName((String) objArr92[0]);
            Object[] objArr93 = new Object[1];
            a(View.getDefaultSize(0, 0) + 18, new int[]{-348800179, -1445666403, 747779126, -267073938, 2118423133, -1427966926, 238105472, -1309072897, -142701149, 452418040}, objArr93);
            Context applicationContext4 = (Context) cls15.getMethod((String) objArr93[0], new Class[0]).invoke(null, null);
            if (applicationContext4 != null) {
                int i121 = artificialFrame + 29;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i121 % 128;
                int i122 = i121 % 2;
                applicationContext4 = ((applicationContext4 instanceof ContextWrapper) && ((ContextWrapper) applicationContext4).getBaseContext() == null) ? null : applicationContext4.getApplicationContext();
            }
            Object[] objArr94 = {applicationContext4, Integer.valueOf(((Integer) Class.forName(str4).getMethod(str5, Object.class).invoke(null, this)).intValue()), 0, 820080773};
            byte[] bArr34 = $$d;
            Object[] objArr95 = new Object[1];
            c(bArr34[8], bArr34[15], (short) 174, objArr95);
            Class<?> cls16 = Class.forName((String) objArr95[0]);
            byte b30 = bArr34[181];
            Object[] objArr96 = new Object[1];
            c((byte) (b30 - 1), b30, (short) 366, objArr96);
            objArr6 = (Object[]) cls16.getMethod((String) objArr96[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr94);
            Object objAccessartificialFrame26 = ArtificialStackFrames.accessartificialFrame(1575402270);
            if (objAccessartificialFrame26 == null) {
                int threadPriority2 = ((Process.getThreadPriority(0) + 20) >> 6) + 17;
                char size = (char) View.MeasureSpec.getSize(0);
                int maximumFlingVelocity2 = (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 747;
                byte[] bArr35 = $$a;
                Object[] objArr97 = new Object[1];
                b((byte) 47, bArr35[110], bArr35[102], objArr97);
                objAccessartificialFrame26 = ArtificialStackFrames.coroutineCreation(threadPriority2, size, maximumFlingVelocity2, -1031537386, false, (String) objArr97[0], null);
            }
            ((Field) objAccessartificialFrame26).set(null, objArr6);
            try {
                Long lValueOf6 = Long.valueOf(((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame27 = ArtificialStackFrames.accessartificialFrame(1745676544);
                if (objAccessartificialFrame27 == null) {
                    int mode = View.MeasureSpec.getMode(0) + 17;
                    char cKeyCodeFromString = (char) KeyEvent.keyCodeFromString("");
                    int trimmedLength2 = TextUtils.getTrimmedLength("") + 747;
                    byte b31 = $$a[110];
                    Object[] objArr98 = new Object[1];
                    b((byte) 47, b31, (byte) (b31 - 1), objArr98);
                    objAccessartificialFrame27 = ArtificialStackFrames.coroutineCreation(mode, cKeyCodeFromString, trimmedLength2, -144068856, false, (String) objArr98[0], null);
                }
                ((Field) objAccessartificialFrame27).set(null, lValueOf6);
            } catch (Exception unused6) {
                throw new RuntimeException();
            }
        } else {
            Object objAccessartificialFrame28 = ArtificialStackFrames.accessartificialFrame(1575402270);
            if (objAccessartificialFrame28 == null) {
                int pressedStateDuration5 = (ViewConfiguration.getPressedStateDuration() >> 16) + 17;
                char minimumFlingVelocity3 = (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16);
                int iResolveSize4 = View.resolveSize(0, 0) + 747;
                byte[] bArr36 = $$a;
                Object[] objArr99 = new Object[1];
                b((byte) 47, bArr36[110], bArr36[102], objArr99);
                objAccessartificialFrame28 = ArtificialStackFrames.coroutineCreation(pressedStateDuration5, minimumFlingVelocity3, iResolveSize4, -1031537386, false, (String) objArr99[0], null);
            }
            Object[] objArr100 = (Object[]) ((Field) objAccessartificialFrame28).get(null);
            objArr6 = new Object[]{list, new int[1], list, new int[]{i}, new int[]{i}};
            int i123 = ((int[]) objArr100[3])[0];
            int i124 = ((int[]) objArr100[4])[0];
            List list = (List) objArr100[0];
            List list2 = (List) objArr100[2];
            int iIdentityHashCode6 = System.identityHashCode(this);
            int i125 = ~((-137932876) | iIdentityHashCode6);
            int i126 = ~iIdentityHashCode6;
            int i127 = (-61144409) + ((i125 | (~(469612799 | i126))) * (-406)) + ((~((-2097218) | i126)) * (-406)) + (((~(iIdentityHashCode6 | (-467515583))) | (~(137932875 | i126))) * 406) + 820080773;
            int i128 = (i127 << 13) ^ i127;
            int i129 = i128 ^ (i128 >>> 17);
            ((int[]) objArr6[1])[0] = i129 ^ (i129 << 5);
        }
        int i130 = ((int[]) objArr6[4])[0];
        int i131 = ((int[]) objArr6[3])[0];
        if (i131 == i130) {
            Object[] objArr101 = {list, new int[1], list, new int[]{i}, new int[]{i}};
            int i132 = ((int[]) objArr6[1])[0];
            int i133 = ((int[]) objArr6[3])[0];
            int i134 = ((int[]) objArr6[4])[0];
            List list3 = (List) objArr6[0];
            List list4 = (List) objArr6[2];
            int i135 = ~Process.myTid();
            int i136 = i132 + 1830513297 + ((1073741147 | i135) * SyslogConstants.LOG_LOCAL7) + (((~(i135 | 1006318939)) | 740292874) * SyslogConstants.LOG_LOCAL7);
            int i137 = (i136 << 13) ^ i136;
            int i138 = i137 ^ (i137 >>> 17);
            ((int[]) objArr101[1])[0] = i138 ^ (i138 << 5);
        } else {
            ArrayList arrayList2 = new ArrayList();
            Object[] objArr102 = {objArr6};
            Object objAccessartificialFrame29 = ArtificialStackFrames.accessartificialFrame(1804664566);
            if (objAccessartificialFrame29 == null) {
                objAccessartificialFrame29 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getScrollBarSize() >> 8) + 41, (char) (12468 - (ViewConfiguration.getKeyRepeatTimeout() >> 16)), 3642 - TextUtils.indexOf("", ""), -185222914, false, "coroutineCreation", new Class[]{Object[].class});
            }
            arrayList2.add(((Method) objAccessartificialFrame29).invoke(null, objArr102));
            Object[] objArr103 = {objArr6};
            Object objAccessartificialFrame30 = ArtificialStackFrames.accessartificialFrame(-1243809191);
            if (objAccessartificialFrame30 == null) {
                objAccessartificialFrame30 = ArtificialStackFrames.coroutineCreation((CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + 41, (char) (Gravity.getAbsoluteGravity(0, 0) + 12468), View.resolveSizeAndState(0, 0, 0) + 3642, 716815441, false, "ArtificialStackFrames", new Class[]{Object[].class});
            }
            arrayList2.add(((Method) objAccessartificialFrame30).invoke(null, objArr103));
            Object[] objArr104 = {Long.valueOf(((long) (i130 ^ i131)) ^ (((long) (-316148117)) << 32)), Long.valueOf(-316148125)};
            byte[] bArr37 = $$d;
            byte b32 = bArr37[8];
            byte b33 = bArr37[18];
            Object[] objArr105 = new Object[1];
            c(b32, b33, (short) (b33 | 126), objArr105);
            Class<?> cls17 = Class.forName((String) objArr105[0]);
            Object[] objArr106 = new Object[1];
            c((byte) ($$e & 463), bArr37[74], (short) TypedValues.CycleType.TYPE_PATH_ROTATE, objArr106);
            cls17.getMethod((String) objArr106[0], Long.TYPE, Long.TYPE).invoke(null, objArr104);
            Object[] objArr107 = {list, new int[1], list, new int[]{i}, new int[]{i}};
            int i139 = ((int[]) objArr6[1])[0];
            int i140 = ((int[]) objArr6[3])[0];
            int i141 = ((int[]) objArr6[4])[0];
            List list5 = (List) objArr6[0];
            List list6 = (List) objArr6[2];
            int iIdentityHashCode7 = System.identityHashCode(this);
            int i142 = ~iIdentityHashCode7;
            int i143 = i139 + 887435209 + ((268501125 | i142) * (-192)) + (((~(336926861 | i142)) | 673874194) * (-384)) + (((~(iIdentityHashCode7 | (-68425737))) | (~(i142 | 1010801055)) | (~((-673874195) | iIdentityHashCode7))) * JfifUtil.MARKER_SOFn);
            int i144 = (i143 << 13) ^ i143;
            int i145 = i144 ^ (i144 >>> 17);
            ((int[]) objArr107[1])[0] = i145 ^ (i145 << 5);
        }
        Object objAccessartificialFrame31 = ArtificialStackFrames.accessartificialFrame(-1268268649);
        if (objAccessartificialFrame31 == null) {
            int modifierMetaStateMask3 = ((byte) KeyEvent.getModifierMetaStateMask()) + Ascii.SUB;
            char maximumFlingVelocity3 = (char) ((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 30068);
            int capsMode = TextUtils.getCapsMode("", 0, 0) + 816;
            byte b34 = $$a[110];
            Object[] objArr108 = new Object[1];
            b((byte) 47, b34, (byte) (b34 - 1), objArr108);
            objAccessartificialFrame31 = ArtificialStackFrames.coroutineCreation(modifierMetaStateMask3, maximumFlingVelocity3, capsMode, 721586079, false, (String) objArr108[0], null);
        }
        long j13 = ((Field) objAccessartificialFrame31).getLong(null);
        if (j13 == -1 || j13 + 1997 < ((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Object[] objArr109 = {Integer.valueOf(((Integer) Class.forName(str4).getMethod(str5, Object.class).invoke(null, this)).intValue()), 0, 1126482926};
            Object objAccessartificialFrame32 = ArtificialStackFrames.accessartificialFrame(1327366003);
            if (objAccessartificialFrame32 == null) {
                int i146 = 25 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                char cResolveOpacity3 = (char) (30068 - Drawable.resolveOpacity(0, 0));
                int i147 = (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 816;
                byte[] bArr38 = $$a;
                Object[] objArr110 = new Object[1];
                b(bArr38[26], bArr38[24], (byte) 105, objArr110);
                objAccessartificialFrame32 = ArtificialStackFrames.coroutineCreation(i146, cResolveOpacity3, i147, -797394565, false, (String) objArr110[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            }
            objArr7 = (Object[]) ((Method) objAccessartificialFrame32).invoke(null, objArr109);
            Object objAccessartificialFrame33 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame33 == null) {
                int iResolveSize5 = 25 - View.resolveSize(0, 0);
                char cAxisFromString = (char) (MotionEvent.axisFromString("") + 30069);
                int keyRepeatTimeout6 = 816 - (ViewConfiguration.getKeyRepeatTimeout() >> 16);
                byte[] bArr39 = $$a;
                Object[] objArr111 = new Object[1];
                b((byte) 47, bArr39[110], bArr39[102], objArr111);
                objAccessartificialFrame33 = ArtificialStackFrames.coroutineCreation(iResolveSize5, cAxisFromString, keyRepeatTimeout6, 891606461, false, (String) objArr111[0], null);
            }
            ((Field) objAccessartificialFrame33).set(null, objArr7);
            try {
                Long lValueOf7 = Long.valueOf(((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame34 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                if (objAccessartificialFrame34 == null) {
                    int iArgb = 25 - Color.argb(0, 0, 0, 0);
                    char cIndexOf4 = (char) (TextUtils.indexOf("", "") + 30068);
                    int iRgb2 = (-16776400) - Color.rgb(0, 0, 0);
                    byte b35 = $$a[110];
                    Object[] objArr112 = new Object[1];
                    b((byte) 47, b35, (byte) (b35 - 1), objArr112);
                    objAccessartificialFrame34 = ArtificialStackFrames.coroutineCreation(iArgb, cIndexOf4, iRgb2, 721586079, false, (String) objArr112[0], null);
                }
                ((Field) objAccessartificialFrame34).set(null, lValueOf7);
            } catch (Exception unused7) {
                throw new RuntimeException();
            }
        } else {
            Object objAccessartificialFrame35 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame35 == null) {
                int i148 = 26 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1));
                char scrollBarSize = (char) (30068 - (ViewConfiguration.getScrollBarSize() >> 8));
                int scrollDefaultDelay = (ViewConfiguration.getScrollDefaultDelay() >> 16) + 816;
                byte[] bArr40 = $$a;
                Object[] objArr113 = new Object[1];
                b((byte) 47, bArr40[110], bArr40[102], objArr113);
                objAccessartificialFrame35 = ArtificialStackFrames.coroutineCreation(i148, scrollBarSize, scrollDefaultDelay, 891606461, false, (String) objArr113[0], null);
            }
            Object[] objArr114 = (Object[]) ((Field) objAccessartificialFrame35).get(null);
            objArr7 = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i149 = ((int[]) objArr114[0])[0];
            int i150 = ((int[]) objArr114[1])[0];
            String[] strArr5 = (String[]) objArr114[2];
            int iFreeMemory3 = (int) Runtime.getRuntime().freeMemory();
            int i151 = (((~(iFreeMemory3 | 589708251)) | (-391535886)) * 56) + 80232725 + (((~((~iFreeMemory3) | (-391535886))) | 589708251) * 56) + 1126482926;
            int i152 = (i151 << 13) ^ i151;
            int i153 = i152 ^ (i152 >>> 17);
            ((int[]) objArr7[3])[0] = i153 ^ (i153 << 5);
        }
        int i154 = ((int[]) objArr7[1])[0];
        int i155 = ((int[]) objArr7[0])[0];
        if (i155 == i154) {
            Object[] objArr115 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i156 = ((int[]) objArr7[3])[0];
            int i157 = ((int[]) objArr7[0])[0];
            int i158 = ((int[]) objArr7[1])[0];
            String[] strArr6 = (String[]) objArr7[2];
            int startUptimeMillis = (int) Process.getStartUptimeMillis();
            int i159 = i156 + ((~(startUptimeMillis | 178049483)) * TypedValues.CycleType.TYPE_EASING) + 1524001333 + (((~((~startUptimeMillis) | 178049483)) | 1048834) * TypedValues.CycleType.TYPE_EASING);
            int i160 = (i159 << 13) ^ i159;
            int i161 = i160 ^ (i160 >>> 17);
            ((int[]) objArr115[3])[0] = i161 ^ (i161 << 5);
        } else {
            ArrayList arrayList3 = new ArrayList();
            String[] strArr7 = (String[]) objArr7[2];
            if (strArr7 != null) {
                for (String str8 : strArr7) {
                    arrayList3.add(str8);
                }
            }
            Object[] objArr116 = {Long.valueOf((((long) (-15169644)) << 32) ^ ((long) (i154 ^ i155))), Long.valueOf(-15169643)};
            byte[] bArr41 = $$d;
            byte b36 = bArr41[8];
            byte b37 = bArr41[28];
            Object[] objArr117 = new Object[1];
            c(b36, b37, (short) (b37 | SignedBytes.MAX_POWER_OF_TWO), objArr117);
            Class<?> cls18 = Class.forName((String) objArr117[0]);
            Object[] objArr118 = new Object[1];
            c((byte) ($$e & 463), bArr41[74], (short) TypedValues.CycleType.TYPE_PATH_ROTATE, objArr118);
            cls18.getMethod((String) objArr118[0], Long.TYPE, Long.TYPE).invoke(null, objArr116);
            Object[] objArr119 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i162 = ((int[]) objArr7[3])[0];
            int i163 = ((int[]) objArr7[0])[0];
            int i164 = ((int[]) objArr7[1])[0];
            String[] strArr8 = (String[]) objArr7[2];
            int startUptimeMillis2 = (int) Process.getStartUptimeMillis();
            int i165 = ~startUptimeMillis2;
            int i166 = (-335218159) + (((~((-98227038) | i165)) | 97518416 | (~((-99945329) | i165)) | (~(100653949 | startUptimeMillis2))) * (-84));
            int i167 = (~(startUptimeMillis2 | (-99945329))) | 98227037;
            int i168 = ~(i165 | 99945328);
            int i169 = i162 + i166 + ((i167 | i168) * (-84)) + (((-100653950) | i168) * 84);
            int i170 = (i169 << 13) ^ i169;
            int i171 = i170 ^ (i170 >>> 17);
            ((int[]) objArr119[3])[0] = i171 ^ (i171 << 5);
        }
        Object objAccessartificialFrame36 = ArtificialStackFrames.accessartificialFrame(-444530678);
        if (objAccessartificialFrame36 == null) {
            int i172 = 27 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1));
            char c10 = (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
            int offsetAfter = 1041 - TextUtils.getOffsetAfter("", 0);
            byte b38 = $$a[110];
            Object[] objArr120 = new Object[1];
            b((byte) 47, b38, (byte) (b38 - 1), objArr120);
            objAccessartificialFrame36 = ArtificialStackFrames.coroutineCreation(i172, c10, offsetAfter, 2061780482, false, (String) objArr120[0], null);
        }
        long j14 = ((Field) objAccessartificialFrame36).getLong(null);
        if (j14 == -1 || j14 + 4611686018427387788L < ((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue()) {
            int iIntValue2 = ((Integer) Class.forName(str4).getMethod(str5, Object.class).invoke(null, this)).intValue();
            Object[] objArr121 = {-1530916331};
            Object objAccessartificialFrame37 = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame37 == null) {
                objAccessartificialFrame37 = ArtificialStackFrames.coroutineCreation((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 7, (char) (Color.green(0) + 22251), 1033 - TextUtils.getOffsetBefore("", 0), 47343338, false, null, new Class[]{Integer.TYPE});
            }
            Object[] objArrAccessartificialFrame$78cbbd35 = SchemaManager$$ExternalSyntheticLambda5.accessartificialFrame$78cbbd35(iIntValue2, 0, ((Constructor) objAccessartificialFrame37).newInstance(objArr121), 1331125836, false);
            Object objAccessartificialFrame38 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame38 == null) {
                int i173 = (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 26;
                char cIndexOf5 = (char) TextUtils.indexOf("", "", 0);
                int iIndexOf7 = 1040 - TextUtils.indexOf((CharSequence) "", '0', 0);
                byte[] bArr42 = $$a;
                Object[] objArr122 = new Object[1];
                b((byte) 47, bArr42[110], bArr42[102], objArr122);
                objAccessartificialFrame38 = ArtificialStackFrames.coroutineCreation(i173, cIndexOf5, iIndexOf7, 1145017376, false, (String) objArr122[0], null);
            }
            ((Field) objAccessartificialFrame38).set(null, objArrAccessartificialFrame$78cbbd35);
            try {
                Long lValueOf8 = Long.valueOf(((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame39 = ArtificialStackFrames.accessartificialFrame(-444530678);
                if (objAccessartificialFrame39 == null) {
                    int iMyPid2 = (Process.myPid() >> 22) + 26;
                    char cKeyCodeFromString2 = (char) KeyEvent.keyCodeFromString("");
                    int edgeSlop3 = (ViewConfiguration.getEdgeSlop() >> 16) + 1041;
                    byte b39 = $$a[110];
                    Object[] objArr123 = new Object[1];
                    b((byte) 47, b39, (byte) (b39 - 1), objArr123);
                    objAccessartificialFrame39 = ArtificialStackFrames.coroutineCreation(iMyPid2, cKeyCodeFromString2, edgeSlop3, 2061780482, false, (String) objArr123[0], null);
                }
                ((Field) objAccessartificialFrame39).set(null, lValueOf8);
                objArr8 = objArrAccessartificialFrame$78cbbd35;
            } catch (Exception unused8) {
                throw new RuntimeException();
            }
        } else {
            Object objAccessartificialFrame40 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame40 == null) {
                int touchSlop3 = (ViewConfiguration.getTouchSlop() >> 8) + 26;
                char c11 = (char) (1 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)));
                int i174 = 1042 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1));
                byte[] bArr43 = $$a;
                Object[] objArr124 = new Object[1];
                b((byte) 47, bArr43[110], bArr43[102], objArr124);
                objAccessartificialFrame40 = ArtificialStackFrames.coroutineCreation(touchSlop3, c11, i174, 1145017376, false, (String) objArr124[0], null);
            }
            Object[] objArr125 = (Object[]) ((Field) objAccessartificialFrame40).get(null);
            objArr8 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
            int i175 = ((int[]) objArr125[3])[0];
            int i176 = ((int[]) objArr125[2])[0];
            String[] strArr9 = (String[]) objArr125[0];
            int iIdentityHashCode8 = System.identityHashCode(this);
            int i177 = (((~((~iIdentityHashCode8) | 257510277)) * 130) - 1149379582) + (((~(iIdentityHashCode8 | 257510277)) | 167837828) * 130) + 1331125836;
            int i178 = (i177 << 13) ^ i177;
            int i179 = i178 ^ (i178 >>> 17);
            ((int[]) objArr8[1])[0] = i179 ^ (i179 << 5);
        }
        int i180 = ((int[]) objArr8[2])[0];
        int i181 = ((int[]) objArr8[3])[0];
        if (i181 == i180) {
            Object[] objArr126 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i182 = ((int[]) objArr8[1])[0];
            int i183 = ((int[]) objArr8[3])[0];
            int i184 = ((int[]) objArr8[2])[0];
            String[] strArr10 = (String[]) objArr8[0];
            int iIdentityHashCode9 = System.identityHashCode(this);
            int i185 = ~iIdentityHashCode9;
            int i186 = i182 + 280763312 + ((iIdentityHashCode9 | 486666458) * (-859)) + (((~(iIdentityHashCode9 | (-84004865))) | (~(486666458 | i185))) * 859) + (((~(408562651 | i185)) | (-492567516)) * 859);
            int i187 = (i186 << 13) ^ i186;
            int i188 = i187 ^ (i187 >>> 17);
            ((int[]) objArr126[1])[0] = i188 ^ (i188 << 5);
        } else {
            ArrayList arrayList4 = new ArrayList();
            String[] strArr11 = (String[]) objArr8[0];
            if (strArr11 != null) {
                for (String str9 : strArr11) {
                    arrayList4.add(str9);
                }
            }
            Object[] objArr127 = {Long.valueOf(((long) (i180 ^ i181)) ^ (((long) (-1811434083)) << 32)), Long.valueOf(-1811434081)};
            byte[] bArr44 = $$d;
            byte b40 = bArr44[28];
            Object[] objArr128 = new Object[1];
            c(b40, bArr44[57], b40, objArr128);
            Class<?> cls19 = Class.forName((String) objArr128[0]);
            Object[] objArr129 = new Object[1];
            c((byte) ($$e & 463), bArr44[74], (short) TypedValues.CycleType.TYPE_PATH_ROTATE, objArr129);
            cls19.getMethod((String) objArr129[0], Long.TYPE, Long.TYPE).invoke(null, objArr127);
            Object[] objArr130 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i189 = ((int[]) objArr8[1])[0];
            int i190 = ((int[]) objArr8[3])[0];
            int i191 = ((int[]) objArr8[2])[0];
            String[] strArr12 = (String[]) objArr8[0];
            int iIdentityHashCode10 = System.identityHashCode(this);
            int i192 = i189 + (-392003098) + ((~((~iIdentityHashCode10) | (-459293954))) * (-116)) + ((604879480 | iIdentityHashCode10) * 116) + (((~(iIdentityHashCode10 | 526775673)) | 537397760) * 116);
            int i193 = (i192 << 13) ^ i192;
            int i194 = i193 ^ (i193 >>> 17);
            ((int[]) objArr130[1])[0] = i194 ^ (i194 << 5);
        }
        super.onCreate(bundle);
    }

    static {
        byte[] bArr = new byte[572];
        System.arraycopy("n0\u0091§\u0010\u0002Å=\f\u0004ü\týÍ7\u0011ú\u0012\u0001þÿÎ=\n\n¿Cü\u0000\u0016\u0006\u0001÷\fü\r\n¾?\t\nõ\u0011\u0000÷\u000fÆP\u0004ô\u000f\u0006\u0004\u0006\u0012\u0004ò\u0015\u0006ù\u0001\u0007þ\nü\u000fÞ0ó\u0010ü\u0010\u0002Å>\u0005\u000fñ\u0006\t\u0005ü\u0013\u0004Â;\u0017ï\u0006\u000f\bù\n\u0003\t¿#0Î*þ\u0006\u0011\u0001Ú7ï\u0006\u000f\bù\n\u0003\u0004A\u0010\u0002Å=\f\u0004ü\týÍ9\u0013\u000bû\bÿÃJù\t\u0001ÇF\u0006øÌ?\t\nõ\u0011\u0000÷\u000fÆ\"\u001d\u0006þ\u0006\u001aÑ3û\u0004è&ø0\u0007\u0001\n\u0003ù\tûã%\u0001\u0017ö\u0004\u0006\týè-\u0010\u0002Å<ÿ\u0006\u0006\u0001\u0011\u0004\u0000Ç7\u0013\u0004\u0000\u0001\t\u0001\f¿\u00173\u0004à!\t\u0001Ý!\u0017ñÇ\u0011\u0010\u0002Å=\f\u0004ü\týÍ7\u0011ú\u0012\u0001þÿÎ=\n\n¿?\t\nõ\u0011\u0000÷\u000fÆI\u0005ñ\u0017\u0003¿P\u0004ó\u0010\u0007\u0001\n\u0003ù\tûâ3÷\u0000\u0017ù\n\u0003\u0010\u0002Å=\f\u0004ü\týÍ7\u0013ýÉ'(þ\tñó&\u0001\tÿ\nÃIö\r\n\u0002\u000b¹H÷\u0000\u0006\u0015¾(\u0000\t\u0016\r\n\u0002\u000bØ&ù\u0015ûýè(\u0007\u0000¼\u0004%7\u0000õ\u0011\u0000÷\u000fë*ù\nø\u0001\u0013ùþí\u0019\u0010ù\u0006\u0001Ó\u0010\u0002Å=\f\u0004ü\týÍ7\u0011ú\u0012\u0001þÿÎ=\n\n¿?\t\nõ\u0011\u0000÷\u000fÆCü\u0000\u0016\u0006\u0001÷\fü\r\n¾P\u0004õ\u0010\u0010\u0002Å=\f\u0004ü\týÍ7\u0011ú\u0012\u0001þÿÎ=\n\n¿?\t\nõ\u0011\u0000÷\u000fÆC\u0003\u0003\u0002\u000fï\u001b÷\u000eú\n\u0003õ\u0007\u0003\u0015õ\u0010ù\u0005þ\u0007\u0017ýú\fý\u0003ÎP\u0004ï\u0010\u0002Å<ÿ\u0006\u0006\u0001\u0011\u0004\u0000Ç?\bø\n\u0002\u000fý\u000bù\u000b\u0001\tûÍ9\u0010\u0007÷Í&&\u0001ù\u0015ò\u0006\u0011å\u0016\u0010\bô\rù\u0006å\u001f\u0006\u0015ÿ\u0007\u000b¯#0\u0002\u0007õ\u0011ÿ\n\u0003\u0000\u0001\u0010\u0004\u0000Çÿ?\t\nõ\u0011\u0000÷\u000fÆM\u0000¿(\u0017\u0000\u000fï\u0012\u0001õ ø\fþ\u0013´7\u001fû\u000fõ\u0011æ\u0011\u0016ü".getBytes(CharEncoding.ISO_8859_1), 0, bArr, 0, 572);
        $$d = bArr;
        $$e = 123;
        $$a = new byte[]{52, -20, 7, -120, 5, -1, -33, 33, -2, -9, 5, -7, 5, -1, -50, 39, Ascii.VT, -7, -12, Ascii.SI, -9, Ascii.DC2, -34, Ascii.EM, 4, -17, 19, -15, -1, -18, Ascii.SI, 19, -11, 5, -7, -2, Ascii.SI, -36, Ascii.NAK, Ascii.CR, -15, 2, 9, 6, -34, Ascii.SI, 19, -11, 5, -7, -2, Ascii.SI, -33, 33, -19, 17, -32, Ascii.SI, 19, -11, 5, -7, 10, -31, Ascii.DC4, Ascii.CR, -8, -11, -13, Ascii.ESC, -9, Ascii.DC2, -36, 33, -19, 17, -32, Ascii.SI, 19, -11, 5, -7, -7, Ascii.DC2, -43, Ascii.GS, -4, 17, 2, 49, 2, -11, -3, 3, -6, 6, -8, Ascii.VT, -25, 33, -19, 2, 8, -37, 44, -17, Ascii.FF, -8, Ascii.SO, Ascii.ESC, 1, -7, -6, -33, 51, -12, 3, -8, 1, Ascii.CR};
        $$b = 171;
        getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
        artificialFrame = 1;
        ICustomTabsCallbackStub = new int[]{307739785, 454571473, 1932680609, -1779203744, -1790488905, 2092276061, -221101407, 1561322123, -1590018213, 116078334, 1085846645, -1662178406, 423993547, -1182735235, 1120100179, 262000490, 1362190648, -1343429184};
    }
}
