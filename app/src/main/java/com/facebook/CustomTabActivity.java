package com.facebook;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.ViewCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import ch.qos.logback.core.net.SyslogConstants;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.android.material.color.utilities.QuantizerCelebi;
import com.google.common.base.Ascii;
import com.reactnativekeyboardcontroller.listeners.FocusedInputObserver;
import com.salesforce.marketingcloud.analytics.stats.b;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o.ArtificialStackFrames;
import o.onNavigationEvent;
import org.apache.commons.lang3.CharEncoding;
import org.apache.commons.lang3.CharUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class CustomTabActivity extends Activity {
    private static final byte[] $$a;
    private static final int $$b;
    private static final byte[] $$d;
    private static final int $$e;
    public static final String CUSTOM_TAB_REDIRECT_ACTION;
    private static final int CUSTOM_TAB_REDIRECT_REQUEST_CODE = 2;
    public static final Companion Companion;
    public static final String DESTROY_ACTION;
    private static int artificialFrame;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME;
    private static int setDefaultImpl;
    private BroadcastReceiver closeReceiver;
    private static final byte[] $$c = {68, -56, -99, -125};
    private static final int $$f = RotationOptions.ROTATE_180;
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
    private static java.lang.String $$g(int r7, short r8, short r9) {
        /*
            int r8 = r8 + 4
            int r7 = r7 * 2
            int r7 = r7 + 114
            int r9 = r9 * 2
            int r9 = 1 - r9
            byte[] r0 = com.facebook.CustomTabActivity.$$c
            byte[] r1 = new byte[r9]
            r2 = 0
            if (r0 != 0) goto L15
            r3 = r8
            r7 = r9
            r4 = r2
            goto L2a
        L15:
            r3 = r2
        L16:
            int r4 = r3 + 1
            byte r5 = (byte) r7
            int r8 = r8 + 1
            r1[r3] = r5
            if (r4 != r9) goto L25
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            return r7
        L25:
            r3 = r0[r8]
            r6 = r3
            r3 = r8
            r8 = r6
        L2a:
            int r8 = -r8
            int r7 = r7 + r8
            r8 = r3
            r3 = r4
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.CustomTabActivity.$$g(int, short, short):java.lang.String");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0021  */
    /* JADX WARN: Code duplicated, block: B:8:0x0019  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0021 -> B:11:0x002a). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0021
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void b(short r6, byte r7, short r8, java.lang.Object[] r9) {
        /*
            int r6 = 109 - r6
            int r7 = 112 - r7
            int r0 = 21 - r8
            byte[] r1 = com.facebook.CustomTabActivity.$$a
            byte[] r0 = new byte[r0]
            int r8 = 20 - r8
            r2 = 0
            if (r1 != 0) goto L13
            r3 = r7
            r4 = r2
            r7 = r6
            goto L2a
        L13:
            r3 = r2
        L14:
            byte r4 = (byte) r7
            r0[r3] = r4
            if (r3 != r8) goto L21
            java.lang.String r6 = new java.lang.String
            r6.<init>(r0, r2)
            r9[r2] = r6
            return
        L21:
            r4 = r1[r6]
            int r3 = r3 + 1
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
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.CustomTabActivity.b(short, byte, short, java.lang.Object[]):void");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0021  */
    /* JADX WARN: Code duplicated, block: B:8:0x0019  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0021 -> B:11:0x0023). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0021
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void c(int r5, int r6, int r7, java.lang.Object[] r8) {
        /*
            byte[] r0 = com.facebook.CustomTabActivity.$$d
            int r5 = 616 - r5
            int r6 = r6 + 1
            int r7 = 111 - r7
            byte[] r1 = new byte[r6]
            r2 = 0
            if (r0 != 0) goto L11
            r4 = r7
            r3 = r2
            r7 = r6
            goto L23
        L11:
            r3 = r2
        L12:
            byte r4 = (byte) r7
            r1[r3] = r4
            int r3 = r3 + 1
            if (r3 != r6) goto L21
            java.lang.String r5 = new java.lang.String
            r5.<init>(r1, r2)
            r8[r2] = r5
            return
        L21:
            r4 = r0[r5]
        L23:
            int r7 = r7 + r4
            int r7 = r7 + (-5)
            int r5 = r5 + 1
            goto L12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.CustomTabActivity.c(int, int, int, java.lang.Object[]):void");
    }

    @Override // android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = new Intent(this, (Class<?>) CustomTabMainActivity.class);
        intent.setAction(CUSTOM_TAB_REDIRECT_ACTION);
        intent.putExtra(CustomTabMainActivity.EXTRA_URL, getIntent().getDataString());
        intent.addFlags(603979776);
        startActivityForResult(intent, 2);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == 0) {
            Intent intent2 = new Intent(CUSTOM_TAB_REDIRECT_ACTION);
            intent2.putExtra(CustomTabMainActivity.EXTRA_URL, getIntent().getDataString());
            LocalBroadcastManager.getInstance(this).sendBroadcast(intent2);
            BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.facebook.CustomTabActivity$onActivityResult$closeReceiver$1
                @Override // android.content.BroadcastReceiver
                public void onReceive(@NotNull Context context, @NotNull Intent intent3) {
                    Intrinsics.checkNotNullParameter(context, "context");
                    Intrinsics.checkNotNullParameter(intent3, "intent");
                    this.this$0.finish();
                }
            };
            LocalBroadcastManager.getInstance(this).registerReceiver(broadcastReceiver, new IntentFilter(DESTROY_ACTION));
            this.closeReceiver = broadcastReceiver;
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        BroadcastReceiver broadcastReceiver = this.closeReceiver;
        if (broadcastReceiver != null) {
            LocalBroadcastManager.getInstance(this).unregisterReceiver(broadcastReceiver);
        }
        super.onDestroy();
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        byte[] bArr = new byte[670];
        System.arraycopy("m\u0097¯\u009a\u000bÄ@\n\rô\u0012\u0007ò\u0017÷Î=\b\u000eø\u0002\u0004\u0017÷Î:\u0011\u0003\u0005\u0007\u0004Å*\u001aþ\u0016ø\u0004ö$ú\b\f¶\u0005&8\u0001ö\u0012\u0001ø\u0010ì+ú\u000bù\u0002\u0014úÿã4þé'ú\u0006\fè+\u0004ý\u0002\nüÑ1\b\u0002\u000b\u0004ú\nüä&\u0002\u0018÷\u0005\u0007\nþé.\u0011\u0003Æ>\r\u0005ý\nþÎ8\u0014þÊ()ÿ\nòô'\u0002\n\u0000\u0005B\u0011\u0003Æ>\r\u0005ý\nþÎ:\u0014\fü\t\u0000ÄKú\n\u0002ÈA\u0012\u0002¿!2\u0002Ö#\u0006\u0014óô\u0016\u0016ô\u0011ý\u0014ö\u0012\u0006¶#8ù\bý\u0006\u0012\u0011\u0003Æ>\r\u0005ý\nþÎ=\b\u000eø\u0002\u0004\u0017÷Î:\u0011\u0003\b\u0004\u0004ü\u000e\u000b\u0004À&&\tú\u000b\u0004ø\u0010é'\u0002\fø\u0000\u0006\u0012·\u0005&8\u0001ö\u0012\u0001ø\u0010ì+ú\u000bù\u0002\u0014úÿî\u001a\u0011ú\u0007\u0002Ö\u0001\u0002\u0011\u0005\u0001È\u0000@\n\u000bö\u0012\u0001ø\u0010ÇN\u0001À)\u0018\u0001\u0010ð\u0013\u0002ö!ù\rÿ\u0014µ8 ü\u0010ö\u0012ç\u0012\u0017ý\u0011\u0003ÆPí\u0010ú\u0012\u000bú\u000fÀLó\u0014\u0002\u0006ÃD\u0007ú\u0006\fÇ\u001c8ö\u0002è*ý\u000e\u0011\b\u0002\u000b\u0004ú\nüã4ø\u0001\u0018ú\u000b\u0004\u000bÄJ÷\u000e\u000b\u0003\fº&+\u0004ó\u0012\u000eà\u0017\u000eû\u0006\u0012·\u0005&8\u0001ö\u0012\u0001ø\u0010ì+ú\u000bù\u0002\u0014úÿî\u001a\u0011ú\u0007\u0002Ô\u0007\u0005\u0007\u0013\u0005ó\u0016\u0007ú\u0002\bÿ\u000bý\u0010ß1ô\u0011ý\u0011\u0003Æ=\u0000\u0007\u0007\u0002\u0012\u0005\u0001È9\u0012\u0002\r\u0004À\u00182û\u0013\u0002ÿ\u0000æ8ò\u0003\u0017\u0004\u0000\b\u0006¶$1\u0003\bö\u0012\u0000\u000b\u0004\u0011\u0003Æ>\r\u0005ý\nþÎ:\u0011\u0003\u0005\u0007\u0004Å:\u0011\u0002\u0005þ\u0003\u0016¿$\u0019\u0014â\u0019\u000fÿ\u0012Ü*\u000bö\u0012\u0001ø\u0010æ\u0019\u0014¹\"&\u0016\u0006\u0003ô\u0007\u0016è\u0013\u0001\u000få\u001f\u0019Ñ.\u000b\u0003\f\u0011\u0003Æ=\u0000\u0007\u0007\u0002\u0012\u0005\u0001È@\tù\u000b\u0003\u0010þ\fú\f\u0002\nüÎ:\u0011\bøÎ''\u0002ú\u0016ó\u0007\u0012æ\u0017\u0011\tõ\u000eú\u0007æ \u0007\u0016\u0000\b\f°$1\u0003\bö\u0012\u0000\u000b\u0004\u0011\u0003Æ>\r\u0005ý\nþÎ:\u0014\fü\t\u0000ÄKú\n\u0002È8\t\u0001\bÏ\u0018)\u0013×!\u001cØ\u001f\u0019°\u0012\u0001\u0002\u0011\u0005\u0001È\u0000@\n\u000bö\u0012\u0001ø\u0010ÇG\u0001ú\u0018÷\u000e\b\u0000Æ8\u0012û\u0013\u0002ÿ\u0000Ï\u001b&\u0006\u0004\u0012\u0005ø\u0004ô!ù\rÿ\u0014Ò(\u0002\u0014\tö\u0012".getBytes(CharEncoding.ISO_8859_1), 0, bArr, 0, 670);
        $$d = bArr;
        $$e = 212;
        $$a = new byte[]{98, -94, 86, -118, 9, -18, 34, -25, -4, 17, -19, Ascii.SI, 1, Ascii.DC2, -15, -19, Ascii.VT, -5, 7, 2, -15, 36, -21, -13, Ascii.SI, -2, -9, -6, 34, -15, -19, Ascii.VT, -5, 7, -5, 1, 33, -33, 2, 9, -5, 7, -5, 1, 50, -39, -11, 7, Ascii.FF, -15, 2, -15, 33, -33, 19, -17, 32, -15, -19, Ascii.VT, -5, 7, -10, Ascii.US, -20, -13, 8, Ascii.VT, Ascii.CR, -27, 9, -18, 36, -33, 19, -17, 32, -15, -19, Ascii.VT, -5, 7, 7, -18, 43, -29, 4, -17, -2, -49, -2, Ascii.VT, 3, -3, 6, -6, 8, -11, Ascii.EM, -33, 19, -2, -8, 37, -44, 17, -12, 8, -14, -27, -1, 7, 6, 33, -51, Ascii.FF, -3, 8, -1, -13};
        $$b = 165;
        getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
        artificialFrame = 1;
        accessartificialFrame();
        Companion = new Companion(null);
        CUSTOM_TAB_REDIRECT_ACTION = CustomTabActivity.class.getSimpleName() + ".action_customTabRedirect";
        DESTROY_ACTION = CustomTabActivity.class.getSimpleName() + ".action_destroy";
    }

    private static void a(boolean z, int i, int i2, int i3, char[] cArr, Object[] objArr) throws Throwable {
        char[] cArr2;
        int i4 = 2 % 2;
        onNavigationEvent onnavigationevent = new onNavigationEvent();
        char[] cArr3 = new char[i3];
        onnavigationevent.d = 0;
        while (onnavigationevent.d < i3) {
            int i5 = $10 + 125;
            $11 = i5 % 128;
            int i6 = i5 % 2;
            onnavigationevent.c = cArr[onnavigationevent.d];
            cArr3[onnavigationevent.d] = (char) (i2 + onnavigationevent.c);
            int i7 = onnavigationevent.d;
            try {
                Object[] objArr2 = {Integer.valueOf(cArr3[i7]), Integer.valueOf(setDefaultImpl)};
                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(465886069);
                if (objAccessartificialFrame == null) {
                    byte b = (byte) 0;
                    byte b2 = (byte) (b - 1);
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getPressedStateDuration() >> 16) + 22, (char) TextUtils.getOffsetBefore("", 0), 1775 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)), -2069783171, false, $$g(b, b2, (byte) (b2 + 1)), new Class[]{Integer.TYPE, Integer.TYPE});
                }
                cArr3[i7] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                Object[] objArr3 = {onnavigationevent, onnavigationevent};
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1257606387);
                if (objAccessartificialFrame2 == null) {
                    byte b3 = (byte) 1;
                    byte b4 = (byte) (-b3);
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(37 - TextUtils.indexOf("", "", 0, 0), (char) ((ViewConfiguration.getTapTimeout() >> 16) + 56277), (ViewConfiguration.getWindowTouchSlop() >> 8) + 1259, 711931141, false, $$g(b3, b4, (byte) (b4 + 1)), new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame2).invoke(null, objArr3);
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }
        if (i > 0) {
            int i8 = $10 + 97;
            $11 = i8 % 128;
            int i9 = i8 % 2;
            onnavigationevent.b = i;
            char[] cArr4 = new char[i3];
            System.arraycopy(cArr3, 0, cArr4, 0, i3);
            System.arraycopy(cArr4, 0, cArr3, i3 - onnavigationevent.b, onnavigationevent.b);
            System.arraycopy(cArr4, onnavigationevent.b, cArr3, 0, i3 - onnavigationevent.b);
        }
        if (z) {
            int i10 = $10 + 57;
            $11 = i10 % 128;
            if (i10 % 2 == 0) {
                cArr2 = new char[i3];
                onnavigationevent.d = 1;
            } else {
                cArr2 = new char[i3];
                onnavigationevent.d = 0;
            }
            while (onnavigationevent.d < i3) {
                int i11 = $11 + 99;
                $10 = i11 % 128;
                if (i11 % 2 != 0) {
                    cArr2[onnavigationevent.d] = cArr3[i3 >> onnavigationevent.d];
                    Object[] objArr4 = {onnavigationevent, onnavigationevent};
                    Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1257606387);
                    if (objAccessartificialFrame3 == null) {
                        byte b5 = (byte) 1;
                        byte b6 = (byte) (-b5);
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getDoubleTapTimeout() >> 16) + 37, (char) (56276 - ((byte) KeyEvent.getModifierMetaStateMask())), TextUtils.getCapsMode("", 0, 0) + 1259, 711931141, false, $$g(b5, b6, (byte) (b6 + 1)), new Class[]{Object.class, Object.class});
                    }
                    ((Method) objAccessartificialFrame3).invoke(null, objArr4);
                } else {
                    cArr2[onnavigationevent.d] = cArr3[(i3 - onnavigationevent.d) - 1];
                    Object[] objArr5 = {onnavigationevent, onnavigationevent};
                    Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1257606387);
                    if (objAccessartificialFrame4 == null) {
                        byte b7 = (byte) 1;
                        byte b8 = (byte) (-b7);
                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(AndroidCharacter.getMirror('0') - 11, (char) (56277 - View.MeasureSpec.getMode(0)), ExpandableListView.getPackedPositionGroup(0L) + 1259, 711931141, false, $$g(b7, b8, (byte) (b8 + 1)), new Class[]{Object.class, Object.class});
                    }
                    ((Method) objAccessartificialFrame4).invoke(null, objArr5);
                }
            }
            cArr3 = cArr2;
        }
        objArr[0] = new String(cArr3);
    }

    /* JADX WARN: Code duplicated, block: B:152:0x1093  */
    /* JADX WARN: Code duplicated, block: B:156:0x1124  */
    /* JADX WARN: Code duplicated, block: B:161:0x1193  */
    /* JADX WARN: Code duplicated, block: B:191:0x159b  */
    /* JADX WARN: Code duplicated, block: B:259:0x1d85 A[PHI: r12
  0x1d85: PHI (r12v242 int) = (r12v241 int), (r12v256 int) binds: [B:258:0x1d83, B:255:0x1d63] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:261:0x1d8e  */
    /* JADX WARN: Code duplicated, block: B:263:0x1e5f A[PHI: r12
  0x1e5f: PHI (r12v255 int) = (r12v241 int), (r12v256 int) binds: [B:258:0x1d83, B:255:0x1d63] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:298:0x223e  */
    /* JADX WARN: Code duplicated, block: B:299:0x22c0  */
    /* JADX WARN: Code duplicated, block: B:301:0x22cc  */
    /* JADX WARN: Code duplicated, block: B:304:0x22d0 A[LOOP:1: B:302:0x22cd->B:304:0x22d0, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:310:0x23bc  */
    /* JADX WARN: Code duplicated, block: B:320:0x24f8  */
    /* JADX WARN: Code duplicated, block: B:323:0x2539 A[Catch: all -> 0x27fc, TryCatch #9 {all -> 0x27fc, blocks: (B:321:0x2516, B:323:0x2539, B:324:0x258f, B:225:0x199f, B:227:0x19a5, B:228:0x19cf, B:230:0x19fa, B:231:0x1a8f, B:115:0x0ccf, B:117:0x0ce4, B:118:0x0d15, B:90:0x09f3, B:92:0x0a00, B:93:0x0a31, B:95:0x0a3b, B:97:0x0a48, B:98:0x0a7b), top: B:390:0x09f3 }] */
    /* JADX WARN: Code duplicated, block: B:327:0x25a1  */
    /* JADX WARN: Code duplicated, block: B:332:0x2612  */
    /* JADX WARN: Code duplicated, block: B:336:0x266e  */
    /* JADX WARN: Code duplicated, block: B:337:0x26ed  */
    /* JADX WARN: Code duplicated, block: B:339:0x26f9  */
    /* JADX WARN: Code duplicated, block: B:342:0x26fd A[LOOP:0: B:340:0x26fa->B:342:0x26fd, LOOP_END] */
    @Override // android.app.Activity
    public void onStart() throws Throwable {
        Object[] objArr;
        Object obj;
        Object[] objArr2;
        Object[] objArrAccessartificialFrame$78cbbd35;
        int i;
        Object[] objArr3;
        Object objAccessartificialFrame;
        Object objAccessartificialFrame2;
        Object[] objArr4;
        int i2;
        Object[] objArr5;
        int i3;
        Object[] objArr6;
        char c;
        int i4;
        int i5;
        ArrayList arrayList;
        String[] strArr;
        int i6;
        int i7;
        Object objAccessartificialFrame3;
        long j;
        Object objAccessartificialFrame4;
        Object objAccessartificialFrame5;
        Object objAccessartificialFrame6;
        Object[] objArr7;
        int i8;
        int i9;
        ArrayList arrayList2;
        String[] strArr2;
        int i10;
        int i11;
        Object objAccessartificialFrame7;
        int i12 = 2 % 2;
        Object[] objArr8 = new Object[1];
        a(true, 22 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), 182 - Drawable.resolveOpacity(0, 0), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 13, new char[]{0, '\f', '\t', 65504, '\n', 2, 17, 16, 22, 65520, 65483, 16, '\f', 65483, 1, 6, '\f', 15, 1, 11, 65534, '\b'}, objArr8);
        String str = (String) objArr8[0];
        Object[] objArr9 = new Object[1];
        a(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(0) - 24, 186 - View.resolveSizeAndState(0, 0, 0), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 20, new char[]{2, CharUtils.CR, 5, 65530, 65534, 65515, 65533, 65534, '\f', '\t', 65530, 5, 65534, 65534, 6}, objArr9);
        String str2 = (String) objArr9[0];
        Object[] objArr10 = new Object[1];
        a(true, ExpandableListView.getPackedPositionChild(0L) + 17, Drawable.resolveOpacity(0, 0) + 181, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(14) - 30, new char[]{11, 3, 18, 17, 23, 65521, 65484, 5, '\f', 65535, '\n', 65484, 65535, 20, 65535, '\b'}, objArr10);
        String str3 = (String) objArr10[0];
        Object[] objArr11 = new Object[1];
        a(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 9, 184 - ExpandableListView.getPackedPositionChild(0L), ExpandableListView.getPackedPositionChild(0L) + 17, new char[]{65501, 2, CharUtils.CR, 65531, 65506, 19, 14, 3, 14, '\b', 65535, 65534, 3, 65535, 65534, '\t'}, objArr11);
        String str4 = (String) objArr11[0];
        Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-1283093189);
        if (objAccessartificialFrame8 == null) {
            int iBlue = 30 - Color.blue(0);
            char cRgb = (char) ((-16727854) - Color.rgb(0, 0, 0));
            int size = View.MeasureSpec.getSize(0) + 684;
            byte[] bArr = $$a;
            byte b = bArr[19];
            byte b2 = (byte) (-bArr[17]);
            Object[] objArr12 = new Object[1];
            b((byte) 105, b, b2, objArr12);
            objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(iBlue, cRgb, size, 752929587, false, (String) objArr12[0], null);
        }
        long j2 = ((Field) objAccessartificialFrame8).getLong(null);
        if (j2 == -1 || j2 + 1931 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                int i13 = getARTIFICIAL_FRAME_PACKAGE_NAME + AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
                artificialFrame = i13 % 128;
                int i14 = i13 % 2;
                Object[] objArr13 = new Object[1];
                a(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 15, View.combineMeasuredStates(0, 0) + 182, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 9, new char[]{22, 17, 6, 19, 6, 17, 0, 65502, 65483, CharUtils.CR, CharUtils.CR, 65534, 65483, 1, 6, '\f', 15, 1, 11, 65534, 1, 65534, 2, 15, 5, 65521}, objArr13);
                Class<?> cls = Class.forName((String) objArr13[0]);
                Object[] objArr14 = new Object[1];
                a(false, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(9) - 107, Color.alpha(0) + 189, (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 17, new char[]{65535, 65529, 65527, '\n', 65535, 5, 4, 65529, 11, '\b', '\b', 65531, 4, '\n', 65495, 6, 6, 2}, objArr14);
                baseContext = (Context) cls.getMethod((String) objArr14[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                baseContext = ((baseContext instanceof ContextWrapper) && ((ContextWrapper) baseContext).getBaseContext() == null) ? null : baseContext.getApplicationContext();
            }
            try {
                Object[] objArr15 = {baseContext, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 455969498};
                short s = (short) TypedValues.MotionType.TYPE_QUANTIZE_INTERPOLATOR_ID;
                byte[] bArr2 = $$d;
                Object[] objArr16 = new Object[1];
                c(s, bArr2[340], bArr2[68], objArr16);
                Class<?> cls2 = Class.forName((String) objArr16[0]);
                Object[] objArr17 = new Object[1];
                c((short) 538, bArr2[271], (byte) (-bArr2[384]), objArr17);
                Object[] objArr18 = (Object[]) cls2.getMethod((String) objArr17[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr15);
                if (baseContext != null) {
                    Object objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(-326560385);
                    if (objAccessartificialFrame9 == null) {
                        int iMyPid = 30 - (Process.myPid() >> 22);
                        char cArgb = (char) (Color.argb(0, 0, 0, 0) + 49362);
                        int scrollBarFadeDuration = 684 - (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                        byte[] bArr3 = $$a;
                        Object[] objArr19 = new Object[1];
                        b((byte) 90, bArr3[4], (byte) (-bArr3[17]), objArr19);
                        objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(iMyPid, cArgb, scrollBarFadeDuration, 1944867703, false, (String) objArr19[0], null);
                    }
                    ((Field) objAccessartificialFrame9).set(null, objArr18);
                    try {
                        Long lValueOf = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                        Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-1283093189);
                        if (objAccessartificialFrame10 == null) {
                            int iIndexOf = 30 - TextUtils.indexOf("", "", 0);
                            char cResolveSize = (char) (View.resolveSize(0, 0) + 49362);
                            int i15 = (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 683;
                            byte[] bArr4 = $$a;
                            Object[] objArr20 = new Object[1];
                            b((byte) 105, bArr4[19], (byte) (-bArr4[17]), objArr20);
                            objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(iIndexOf, cResolveSize, i15, 752929587, false, (String) objArr20[0], null);
                        }
                        ((Field) objAccessartificialFrame10).set(null, lValueOf);
                    } catch (Exception unused) {
                        throw new RuntimeException();
                    }
                } else {
                    objArr18 = objArr18;
                }
                objArr = objArr18;
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        } else {
            Object objAccessartificialFrame11 = ArtificialStackFrames.accessartificialFrame(-326560385);
            if (objAccessartificialFrame11 == null) {
                int i16 = 30 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                char c2 = (char) (49363 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)));
                int i17 = (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 684;
                byte[] bArr5 = $$a;
                Object[] objArr21 = new Object[1];
                b((byte) 90, bArr5[4], (byte) (-bArr5[17]), objArr21);
                objAccessartificialFrame11 = ArtificialStackFrames.coroutineCreation(i16, c2, i17, 1944867703, false, (String) objArr21[0], null);
            }
            Object[] objArr22 = (Object[]) ((Field) objAccessartificialFrame11).get(null);
            objArr = new Object[]{new int[]{((int[]) objArr22[0])[0]}, new int[]{((int[]) objArr22[1])[0]}, new int[1], (String) objArr22[3]};
            int iIdentityHashCode = System.identityHashCode(this);
            int i18 = ~(264613857 | iIdentityHashCode);
            int i19 = (-1124430933) + ((537542684 | i18) * (-814)) + ((i18 | (~((~iIdentityHashCode) | (-714009918))) | 88146624) * 407) + (((~(iIdentityHashCode | 714009917)) | (~((-264613858) | iIdentityHashCode)) | 88146624) * 407) + 455969498;
            int i20 = (i19 << 13) ^ i19;
            int i21 = i20 ^ (i20 >>> 17);
            ((int[]) objArr[2])[0] = i21 ^ (i21 << 5);
        }
        int i22 = ((int[]) objArr[1])[0];
        int i23 = ((int[]) objArr[0])[0];
        if (i23 == i22) {
            int i24 = ((int[]) objArr[2])[0];
            Object[] objArr23 = {new int[]{((int[]) objArr[0])[0]}, new int[]{((int[]) objArr[1])[0]}, new int[1], (String) objArr[3]};
            int i25 = ~((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getDisplayMetrics().heightPixels;
            int i26 = i24 + 1623535278 + (((-557881369) | i25) * SyslogConstants.LOG_LOCAL7) + (((~(i25 | 411698373)) | (-960535709)) * SyslogConstants.LOG_LOCAL7);
            int i27 = (i26 << 13) ^ i26;
            int i28 = i27 ^ (i27 >>> 17);
            ((int[]) objArr23[2])[0] = i28 ^ (i28 << 5);
        } else {
            try {
                Object[] objArr24 = {Long.valueOf(((long) (i22 ^ i23)) ^ (((long) 1428392781) << 32)), Long.valueOf(1428392777)};
                byte[] bArr6 = $$d;
                Object[] objArr25 = new Object[1];
                c((short) 519, bArr6[89], bArr6[42], objArr25);
                Class<?> cls3 = Class.forName((String) objArr25[0]);
                Object[] objArr26 = new Object[1];
                c((short) 495, bArr6[20], bArr6[140], objArr26);
                cls3.getMethod((String) objArr26[0], Long.TYPE, Long.TYPE).invoke(null, objArr24);
                int i29 = ((int[]) objArr[2])[0];
                Object[] objArr27 = {new int[]{((int[]) objArr[0])[0]}, new int[]{((int[]) objArr[1])[0]}, new int[1], (String) objArr[3]};
                int iIdentityHashCode2 = System.identityHashCode(this);
                int i30 = i29 + (-4145050) + (((~(27689859 | iIdentityHashCode2)) | (-1006313635)) * (-948)) + ((~((~iIdentityHashCode2) | (-978919457))) * (-948)) + 782890908;
                int i31 = (i30 << 13) ^ i30;
                int i32 = i31 ^ (i31 >>> 17);
                ((int[]) objArr27[2])[0] = i32 ^ (i32 << 5);
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 == null) {
                    throw th2;
                }
                throw cause2;
            }
        }
        Object objAccessartificialFrame12 = ArtificialStackFrames.accessartificialFrame(1745676544);
        if (objAccessartificialFrame12 == null) {
            int iGreen = Color.green(0) + 17;
            char threadPriority = (char) ((Process.getThreadPriority(0) + 20) >> 6);
            int iIndexOf2 = TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 748;
            byte[] bArr7 = $$a;
            Object[] objArr28 = new Object[1];
            b((byte) 75, (byte) (bArr7[12] - 1), bArr7[48], objArr28);
            objAccessartificialFrame12 = ArtificialStackFrames.coroutineCreation(iGreen, threadPriority, iIndexOf2, -144068856, false, (String) objArr28[0], null);
        }
        long j3 = ((Field) objAccessartificialFrame12).getLong(null);
        if (j3 == -1 || j3 + 1863 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Context baseContext2 = getBaseContext();
            if (baseContext2 == null) {
                Object[] objArr29 = new Object[1];
                a(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 1, Process.getGidForName("") + 183, 25 - ImageFormat.getBitsPerPixel(0), new char[]{22, 17, 6, 19, 6, 17, 0, 65502, 65483, CharUtils.CR, CharUtils.CR, 65534, 65483, 1, 6, '\f', 15, 1, 11, 65534, 1, 65534, 2, 15, 5, 65521}, objArr29);
                Class<?> cls4 = Class.forName((String) objArr29[0]);
                Object[] objArr30 = new Object[1];
                a(false, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 14, (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 188, 18 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), new char[]{65535, 65529, 65527, '\n', 65535, 5, 4, 65529, 11, '\b', '\b', 65531, 4, '\n', 65495, 6, 6, 2}, objArr30);
                baseContext2 = (Context) cls4.getMethod((String) objArr30[0], new Class[0]).invoke(null, null);
            }
            if (baseContext2 == null) {
                obj = null;
            } else {
                if (baseContext2 instanceof ContextWrapper) {
                    int i33 = artificialFrame + 77;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i33 % 128;
                    if (i33 % 2 != 0) {
                        ((ContextWrapper) baseContext2).getBaseContext();
                        Object obj2 = null;
                        obj2.hashCode();
                        throw null;
                    }
                    if (((ContextWrapper) baseContext2).getBaseContext() == null) {
                        baseContext2 = null;
                        obj = null;
                    }
                }
                obj = null;
                baseContext2 = baseContext2.getApplicationContext();
            }
            Object[] objArr31 = {baseContext2, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(obj, this)).intValue()), 0, 1007228643};
            short s2 = (short) FacebookRequestErrorClassification.ESC_APP_INACTIVE;
            byte[] bArr8 = $$d;
            Object[] objArr32 = new Object[1];
            c(s2, bArr8[63], bArr8[42], objArr32);
            Class<?> cls5 = Class.forName((String) objArr32[0]);
            Object[] objArr33 = new Object[1];
            c((short) 538, bArr8[271], (byte) (-bArr8[384]), objArr33);
            objArr2 = (Object[]) cls5.getMethod((String) objArr33[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr31);
            Object objAccessartificialFrame13 = ArtificialStackFrames.accessartificialFrame(1575402270);
            if (objAccessartificialFrame13 == null) {
                int absoluteGravity = 17 - Gravity.getAbsoluteGravity(0, 0);
                char c3 = (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) - 1);
                int pressedStateDuration = (ViewConfiguration.getPressedStateDuration() >> 16) + 747;
                byte[] bArr9 = $$a;
                Object[] objArr34 = new Object[1];
                b((byte) 67, (byte) (bArr9[12] - 1), bArr9[48], objArr34);
                objAccessartificialFrame13 = ArtificialStackFrames.coroutineCreation(absoluteGravity, c3, pressedStateDuration, -1031537386, false, (String) objArr34[0], null);
            }
            ((Field) objAccessartificialFrame13).set(null, objArr2);
            try {
                Long lValueOf2 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame14 = ArtificialStackFrames.accessartificialFrame(1745676544);
                if (objAccessartificialFrame14 == null) {
                    int iRgb = (-16777199) - Color.rgb(0, 0, 0);
                    char cIndexOf = (char) (TextUtils.indexOf((CharSequence) "", '0') + 1);
                    int iLastIndexOf = 746 - TextUtils.lastIndexOf("", '0', 0);
                    byte[] bArr10 = $$a;
                    byte b3 = (byte) (bArr10[12] - 1);
                    byte b4 = bArr10[48];
                    Object[] objArr35 = new Object[1];
                    b((byte) 75, b3, b4, objArr35);
                    objAccessartificialFrame14 = ArtificialStackFrames.coroutineCreation(iRgb, cIndexOf, iLastIndexOf, -144068856, false, (String) objArr35[0], null);
                }
                ((Field) objAccessartificialFrame14).set(null, lValueOf2);
            } catch (Exception unused2) {
                throw new RuntimeException();
            }
        } else {
            Object objAccessartificialFrame15 = ArtificialStackFrames.accessartificialFrame(1575402270);
            if (objAccessartificialFrame15 == null) {
                int absoluteGravity2 = 17 - Gravity.getAbsoluteGravity(0, 0);
                char packedPositionChild = (char) (ExpandableListView.getPackedPositionChild(0L) + 1);
                int capsMode = 747 - TextUtils.getCapsMode("", 0, 0);
                byte[] bArr11 = $$a;
                Object[] objArr36 = new Object[1];
                b((byte) 67, (byte) (bArr11[12] - 1), bArr11[48], objArr36);
                objAccessartificialFrame15 = ArtificialStackFrames.coroutineCreation(absoluteGravity2, packedPositionChild, capsMode, -1031537386, false, (String) objArr36[0], null);
            }
            Object[] objArr37 = (Object[]) ((Field) objAccessartificialFrame15).get(null);
            objArr2 = new Object[]{list, new int[1], list, new int[]{i}, new int[]{i}};
            int i34 = ((int[]) objArr37[3])[0];
            int i35 = ((int[]) objArr37[4])[0];
            List list = (List) objArr37[0];
            List list2 = (List) objArr37[2];
            int iNextInt = new Random().nextInt();
            int i36 = 1184844678 + ((~(536701181 | iNextInt)) * (-301)) + (((~((-232341710) | iNextInt)) | (~((~iNextInt) | 373106748))) * (-301)) + (((~(iNextInt | (-373106749))) | (-232341710)) * 301) + 1007228643;
            int i37 = (i36 << 13) ^ i36;
            int i38 = i37 ^ (i37 >>> 17);
            ((int[]) objArr2[1])[0] = i38 ^ (i38 << 5);
        }
        int i39 = ((int[]) objArr2[4])[0];
        int i40 = ((int[]) objArr2[3])[0];
        if (i40 == i39) {
            Object[] objArr38 = {list, new int[1], list, new int[]{i}, new int[]{i}};
            int i41 = ((int[]) objArr2[1])[0];
            int i42 = ((int[]) objArr2[3])[0];
            int i43 = ((int[]) objArr2[4])[0];
            List list3 = (List) objArr2[0];
            List list4 = (List) objArr2[2];
            int layoutDirection = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().getLayoutDirection();
            int i44 = i41 + ((((-240511799) + (((~((-33747848) | layoutDirection)) | 33714562) * 576)) + (((~((~layoutDirection) | (-33286))) | 537986048) * 576)) - 2055248768);
            int i45 = (i44 << 13) ^ i44;
            int i46 = i45 ^ (i45 >>> 17);
            ((int[]) objArr38[1])[0] = i46 ^ (i46 << 5);
        } else {
            ArrayList arrayList3 = new ArrayList();
            try {
                Object[] objArr39 = {objArr2};
                Object objAccessartificialFrame16 = ArtificialStackFrames.accessartificialFrame(1804664566);
                if (objAccessartificialFrame16 == null) {
                    objAccessartificialFrame16 = ArtificialStackFrames.coroutineCreation(41 - (ViewConfiguration.getScrollDefaultDelay() >> 16), (char) ((KeyEvent.getMaxKeyCode() >> 16) + 12468), (ViewConfiguration.getEdgeSlop() >> 16) + 3642, -185222914, false, "coroutineCreation", new Class[]{Object[].class});
                }
                arrayList3.add(((Method) objAccessartificialFrame16).invoke(null, objArr39));
                Object[] objArr40 = {objArr2};
                Object objAccessartificialFrame17 = ArtificialStackFrames.accessartificialFrame(-1243809191);
                if (objAccessartificialFrame17 == null) {
                    objAccessartificialFrame17 = ArtificialStackFrames.coroutineCreation(TextUtils.lastIndexOf("", '0', 0, 0) + 42, (char) (((Process.getThreadPriority(0) + 20) >> 6) + 12468), 3642 - Color.argb(0, 0, 0, 0), 716815441, false, "ArtificialStackFrames", new Class[]{Object[].class});
                }
                arrayList3.add(((Method) objAccessartificialFrame17).invoke(null, objArr40));
                Object[] objArr41 = {Long.valueOf(((long) (i39 ^ i40)) ^ (((long) (-1114095830)) << 32)), Long.valueOf(-1114095838)};
                byte[] bArr12 = $$d;
                Object[] objArr42 = new Object[1];
                c((short) 441, (byte) (bArr12[632] + 1), bArr12[42], objArr42);
                Class<?> cls6 = Class.forName((String) objArr42[0]);
                Object[] objArr43 = new Object[1];
                c((short) 495, bArr12[20], bArr12[140], objArr43);
                cls6.getMethod((String) objArr43[0], Long.TYPE, Long.TYPE).invoke(null, objArr41);
                Object[] objArr44 = {list, new int[1], list, new int[]{i}, new int[]{i}};
                int i47 = ((int[]) objArr2[1])[0];
                int i48 = ((int[]) objArr2[3])[0];
                int i49 = ((int[]) objArr2[4])[0];
                List list5 = (List) objArr2[0];
                List list6 = (List) objArr2[2];
                int iIdentityHashCode3 = System.identityHashCode(this);
                int i50 = i47 + ((((-769471549) + (((~iIdentityHashCode3) | 605585952) * 1324)) + (((~(iIdentityHashCode3 | (-467877208))) | (~(1073325665 | iIdentityHashCode3))) * (-1324))) - 1556963386);
                int i51 = (i50 << 13) ^ i50;
                int i52 = i51 ^ (i51 >>> 17);
                ((int[]) objArr44[1])[0] = i52 ^ (i52 << 5);
            } catch (Throwable th3) {
                Throwable cause3 = th3.getCause();
                if (cause3 == null) {
                    throw th3;
                }
                throw cause3;
            }
        }
        Object objAccessartificialFrame18 = ArtificialStackFrames.accessartificialFrame(-444530678);
        if (objAccessartificialFrame18 == null) {
            int i53 = (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 26;
            char c4 = (char) (1 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)));
            int capsMode2 = 1041 - TextUtils.getCapsMode("", 0, 0);
            byte[] bArr13 = $$a;
            Object[] objArr45 = new Object[1];
            b((byte) 75, (byte) (bArr13[12] - 1), bArr13[48], objArr45);
            objAccessartificialFrame18 = ArtificialStackFrames.coroutineCreation(i53, c4, capsMode2, 2061780482, false, (String) objArr45[0], null);
        }
        long j4 = ((Field) objAccessartificialFrame18).getLong(null);
        if (j4 == -1 || j4 + 1935 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            int iIntValue = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
            Object[] objArr46 = {-1309773205};
            Object objAccessartificialFrame19 = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame19 == null) {
                objAccessartificialFrame19 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 8, (char) (ExpandableListView.getPackedPositionType(0L) + 22251), View.MeasureSpec.makeMeasureSpec(0, 0) + 1033, 47343338, false, null, new Class[]{Integer.TYPE});
            }
            objArrAccessartificialFrame$78cbbd35 = QuantizerCelebi.accessartificialFrame$78cbbd35(iIntValue, 0, ((Constructor) objAccessartificialFrame19).newInstance(objArr46), -401709428, false);
            Object objAccessartificialFrame20 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame20 == null) {
                int deadChar = KeyEvent.getDeadChar(0, 0) + 26;
                char c5 = (char) (1 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)));
                int iIndexOf3 = TextUtils.indexOf("", "", 0, 0) + 1041;
                byte[] bArr14 = $$a;
                Object[] objArr47 = new Object[1];
                b((byte) 67, (byte) (bArr14[12] - 1), bArr14[48], objArr47);
                objAccessartificialFrame20 = ArtificialStackFrames.coroutineCreation(deadChar, c5, iIndexOf3, 1145017376, false, (String) objArr47[0], null);
            }
            ((Field) objAccessartificialFrame20).set(null, objArrAccessartificialFrame$78cbbd35);
            try {
                Long lValueOf3 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame21 = ArtificialStackFrames.accessartificialFrame(-444530678);
                if (objAccessartificialFrame21 == null) {
                    int iIndexOf4 = 26 - TextUtils.indexOf("", "", 0, 0);
                    char cLastIndexOf = (char) ((-1) - TextUtils.lastIndexOf("", '0', 0, 0));
                    int jumpTapTimeout = (ViewConfiguration.getJumpTapTimeout() >> 16) + 1041;
                    byte[] bArr15 = $$a;
                    Object[] objArr48 = new Object[1];
                    b((byte) 75, (byte) (bArr15[12] - 1), bArr15[48], objArr48);
                    objAccessartificialFrame21 = ArtificialStackFrames.coroutineCreation(iIndexOf4, cLastIndexOf, jumpTapTimeout, 2061780482, false, (String) objArr48[0], null);
                }
                ((Field) objAccessartificialFrame21).set(null, lValueOf3);
            } catch (Exception unused3) {
                throw new RuntimeException();
            }
        } else {
            Object objAccessartificialFrame22 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame22 == null) {
                int iMakeMeasureSpec = 26 - View.MeasureSpec.makeMeasureSpec(0, 0);
                char c6 = (char) ((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 1);
                int iIndexOf5 = 1041 - TextUtils.indexOf("", "", 0, 0);
                byte[] bArr16 = $$a;
                Object[] objArr49 = new Object[1];
                b((byte) 67, (byte) (bArr16[12] - 1), bArr16[48], objArr49);
                objAccessartificialFrame22 = ArtificialStackFrames.coroutineCreation(iMakeMeasureSpec, c6, iIndexOf5, 1145017376, false, (String) objArr49[0], null);
            }
            Object[] objArr50 = (Object[]) ((Field) objAccessartificialFrame22).get(null);
            objArrAccessartificialFrame$78cbbd35 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
            int i54 = ((int[]) objArr50[3])[0];
            int i55 = ((int[]) objArr50[2])[0];
            String[] strArr3 = (String[]) objArr50[0];
            int i56 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().screenLayout;
            int i57 = ~i56;
            int i58 = (((-1088259046) + (((~(334597647 | i57)) | (~((-412701455) | i56))) * (-370))) + ((((~(i56 | 334597647)) | (~(i57 | (-412701455)))) | 56658945) * (-370))) - 912736258;
            int i59 = (i58 << 13) ^ i58;
            int i60 = i59 ^ (i59 >>> 17);
            ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0] = i60 ^ (i60 << 5);
        }
        int i61 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
        int i62 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
        if (i62 == i61) {
            Object[] objArr51 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i63 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i64 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i65 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr4 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int iIdentityHashCode4 = System.identityHashCode(this);
            int i66 = i63 + (-1404341614) + (((~(iIdentityHashCode4 | 586363375)) | 508259568) * (-668)) + ((586363375 | (~(508259568 | iIdentityHashCode4))) * 1336) + ((iIdentityHashCode4 | 1056669183) * 668);
            int i67 = (i66 << 13) ^ i66;
            int i68 = i67 ^ (i67 >>> 17);
            ((int[]) objArr51[1])[0] = i68 ^ (i68 << 5);
            i = 0;
        } else {
            ArrayList arrayList4 = new ArrayList();
            String[] strArr5 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            if (strArr5 != null) {
                for (String str5 : strArr5) {
                    arrayList4.add(str5);
                }
            }
            Object[] objArr52 = {Long.valueOf((((long) (-2113934121)) << 32) ^ ((long) (i61 ^ i62))), Long.valueOf(-2113934123)};
            byte[] bArr17 = $$d;
            Object[] objArr53 = new Object[1];
            c((short) 369, bArr17[54], bArr17[120], objArr53);
            Class<?> cls7 = Class.forName((String) objArr53[0]);
            Object[] objArr54 = new Object[1];
            c((short) 495, bArr17[20], bArr17[140], objArr54);
            cls7.getMethod((String) objArr54[0], Long.TYPE, Long.TYPE).invoke(null, objArr52);
            Object[] objArr55 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i69 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i70 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i71 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr6 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int i72 = (int) Runtime.getRuntime().totalMemory();
            int i73 = 2023935934 + (((~(984036734 | i72)) | (-905932928)) * 672);
            int i74 = ~i72;
            int i75 = i69 + i73 + (((~(i72 | (-905932928))) | (~((-984036735) | i74))) * (-672)) + (((~(905932927 | i74)) | (-1073706368)) * 672);
            int i76 = (i75 << 13) ^ i75;
            int i77 = i76 ^ (i76 >>> 17);
            i = 0;
            ((int[]) objArr55[1])[0] = i77 ^ (i77 << 5);
        }
        Object objAccessartificialFrame23 = ArtificialStackFrames.accessartificialFrame(1056123296);
        if (objAccessartificialFrame23 == null) {
            int threadPriority2 = 30 - ((Process.getThreadPriority(i) + 20) >> 6);
            char cResolveSize2 = (char) (49362 - View.resolveSize(i, i));
            int iIndexOf6 = TextUtils.indexOf((CharSequence) "", '0', i, i) + 685;
            byte[] bArr18 = $$a;
            Object[] objArr56 = new Object[1];
            b((byte) 59, bArr18[4], bArr18[66], objArr56);
            objAccessartificialFrame23 = ArtificialStackFrames.coroutineCreation(threadPriority2, cResolveSize2, iIndexOf6, -1583976536, false, (String) objArr56[0], null);
        }
        long j5 = ((Field) objAccessartificialFrame23).getLong(null);
        if (j5 != -1) {
            int i78 = getARTIFICIAL_FRAME_PACKAGE_NAME + 117;
            artificialFrame = i78 % 128;
            int i79 = i78 % 2;
            if (j5 + 1860 >= ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame24 = ArtificialStackFrames.accessartificialFrame(910856866);
                if (objAccessartificialFrame24 == null) {
                    int iKeyCodeFromString = 30 - KeyEvent.keyCodeFromString("");
                    char pressedStateDuration2 = (char) (49362 - (ViewConfiguration.getPressedStateDuration() >> 16));
                    int i80 = 685 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1));
                    byte[] bArr19 = $$a;
                    Object[] objArr57 = new Object[1];
                    b((byte) 47, bArr19[18], bArr19[48], objArr57);
                    objAccessartificialFrame24 = ArtificialStackFrames.coroutineCreation(iKeyCodeFromString, pressedStateDuration2, i80, -1456483158, false, (String) objArr57[0], null);
                }
                Object[] objArr58 = (Object[]) ((Field) objAccessartificialFrame24).get(null);
                objArr3 = new Object[]{new int[]{((int[]) objArr58[0])[0]}, new int[]{((int[]) objArr58[1])[0]}, new int[1], (String) objArr58[3]};
                int i81 = ~(((int) Process.getStartElapsedRealtime()) | 548419983);
                int i82 = (((957635072 | i81) * (-658)) - 1548595938) + ((i81 | 419709440) * 658) + 1844131953;
                int i83 = (i82 << 13) ^ i82;
                int i84 = i83 ^ (i83 >>> 17);
                ((int[]) objArr3[2])[0] = i84 ^ (i84 << 5);
            } else {
                int iIntValue2 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
                int i85 = artificialFrame + 87;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i85 % 128;
                int i86 = i85 % 2;
                Object[] objArr59 = {Integer.valueOf(iIntValue2), 1844131953};
                byte[] bArr20 = $$d;
                Object[] objArr60 = new Object[1];
                c((short) 326, bArr20[281], bArr20[42], objArr60);
                Class<?> cls8 = Class.forName((String) objArr60[0]);
                Object[] objArr61 = new Object[1];
                c((short) 294, bArr20[52], bArr20[42], objArr61);
                objArr3 = (Object[]) cls8.getMethod((String) objArr61[0], Integer.TYPE, Integer.TYPE).invoke(null, objArr59);
                objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(910856866);
                if (objAccessartificialFrame == null) {
                    int fadingEdgeLength = (ViewConfiguration.getFadingEdgeLength() >> 16) + 30;
                    char gidForName = (char) (Process.getGidForName("") + 49363);
                    int scrollBarSize = (ViewConfiguration.getScrollBarSize() >> 8) + 684;
                    byte[] bArr21 = $$a;
                    Object[] objArr62 = new Object[1];
                    b((byte) 47, bArr21[18], bArr21[48], objArr62);
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(fadingEdgeLength, gidForName, scrollBarSize, -1456483158, false, (String) objArr62[0], null);
                }
                ((Field) objAccessartificialFrame).set(null, objArr3);
                try {
                    Long lValueOf4 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1056123296);
                    if (objAccessartificialFrame2 == null) {
                        int iMyTid = 30 - (Process.myTid() >> 22);
                        char packedPositionGroup = (char) (49362 - ExpandableListView.getPackedPositionGroup(0L));
                        int tapTimeout = (ViewConfiguration.getTapTimeout() >> 16) + 684;
                        byte[] bArr22 = $$a;
                        Object[] objArr63 = new Object[1];
                        b((byte) 59, bArr22[4], bArr22[66], objArr63);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iMyTid, packedPositionGroup, tapTimeout, -1583976536, false, (String) objArr63[0], null);
                    }
                    ((Field) objAccessartificialFrame2).set(null, lValueOf4);
                } catch (Exception unused4) {
                    throw new RuntimeException();
                }
            }
        } else {
            int iIntValue3 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
            int i87 = artificialFrame + 87;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i87 % 128;
            int i88 = i87 % 2;
            Object[] objArr510 = {Integer.valueOf(iIntValue3), 1844131953};
            byte[] bArr23 = $$d;
            Object[] objArr64 = new Object[1];
            c((short) 326, bArr23[281], bArr23[42], objArr64);
            Class<?> cls9 = Class.forName((String) objArr64[0]);
            Object[] objArr65 = new Object[1];
            c((short) 294, bArr23[52], bArr23[42], objArr65);
            objArr3 = (Object[]) cls9.getMethod((String) objArr65[0], Integer.TYPE, Integer.TYPE).invoke(null, objArr510);
            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(910856866);
            if (objAccessartificialFrame == null) {
                int fadingEdgeLength2 = (ViewConfiguration.getFadingEdgeLength() >> 16) + 30;
                char gidForName2 = (char) (Process.getGidForName("") + 49363);
                int scrollBarSize2 = (ViewConfiguration.getScrollBarSize() >> 8) + 684;
                byte[] bArr24 = $$a;
                Object[] objArr66 = new Object[1];
                b((byte) 47, bArr24[18], bArr24[48], objArr66);
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(fadingEdgeLength2, gidForName2, scrollBarSize2, -1456483158, false, (String) objArr66[0], null);
            }
            ((Field) objAccessartificialFrame).set(null, objArr3);
            Long lValueOf5 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1056123296);
            if (objAccessartificialFrame2 == null) {
                int iMyTid2 = 30 - (Process.myTid() >> 22);
                char packedPositionGroup2 = (char) (49362 - ExpandableListView.getPackedPositionGroup(0L));
                int tapTimeout2 = (ViewConfiguration.getTapTimeout() >> 16) + 684;
                byte[] bArr25 = $$a;
                Object[] objArr67 = new Object[1];
                b((byte) 59, bArr25[4], bArr25[66], objArr67);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iMyTid2, packedPositionGroup2, tapTimeout2, -1583976536, false, (String) objArr67[0], null);
            }
            ((Field) objAccessartificialFrame2).set(null, lValueOf5);
        }
        int i89 = ((int[]) objArr3[1])[0];
        int i90 = ((int[]) objArr3[0])[0];
        if (i90 == i89) {
            int i91 = getARTIFICIAL_FRAME_PACKAGE_NAME + 25;
            artificialFrame = i91 % 128;
            int i92 = i91 % 2;
            int i93 = ((int[]) objArr3[2])[0];
            Object[] objArr68 = {new int[]{((int[]) objArr3[0])[0]}, new int[]{((int[]) objArr3[1])[0]}, new int[1], (String) objArr3[3]};
            int iFreeMemory = (int) Runtime.getRuntime().freeMemory();
            int i94 = 1018316218 + ((iFreeMemory | 962155214) * (-50));
            int i95 = ~((-5849665) | iFreeMemory);
            int i96 = ~iFreeMemory;
            int i97 = i93 + i94 + ((i95 | (~((-10618897) | i96))) * 50) + (((~(i96 | 962155214)) | (~((-16468561) | i96)) | 10618896) * 50);
            int i98 = (i97 << 13) ^ i97;
            int i99 = i98 ^ (i98 >>> 17);
            ((int[]) objArr68[2])[0] = i99 ^ (i99 << 5);
        } else {
            new ArrayList().add((String) objArr3[3]);
            long j6 = ((long) (i89 ^ i90)) ^ (((long) 416071046) << 32);
            long j7 = 416071062;
            int i100 = artificialFrame + 125;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i100 % 128;
            int i101 = i100 % 2;
            Object[] objArr69 = {Long.valueOf(j6), Long.valueOf(j7)};
            byte[] bArr26 = $$d;
            Object[] objArr70 = new Object[1];
            c((short) 519, bArr26[89], bArr26[42], objArr70);
            Class<?> cls10 = Class.forName((String) objArr70[0]);
            Object[] objArr71 = new Object[1];
            c((short) 495, bArr26[20], bArr26[140], objArr71);
            cls10.getMethod((String) objArr71[0], Long.TYPE, Long.TYPE).invoke(null, objArr69);
            int i102 = ((int[]) objArr3[2])[0];
            Object[] objArr72 = {new int[]{((int[]) objArr3[0])[0]}, new int[]{((int[]) objArr3[1])[0]}, new int[1], (String) objArr3[3]};
            int iCodePointAt = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(3) + 1637909816;
            int i103 = ~iCodePointAt;
            int i104 = i102 + (((~(i103 | 188041963)) | (~((-790581812) | i103)) | 604639248) * (-397)) + 145161974 + ((iCodePointAt | 606738648) * 397);
            int i105 = (i104 << 13) ^ i104;
            int i106 = i105 ^ (i105 >>> 17);
            ((int[]) objArr72[2])[0] = i106 ^ (i106 << 5);
        }
        Object objAccessartificialFrame25 = ArtificialStackFrames.accessartificialFrame(-2127922582);
        if (objAccessartificialFrame25 == null) {
            int jumpTapTimeout2 = 30 - (ViewConfiguration.getJumpTapTimeout() >> 16);
            char cLastIndexOf2 = (char) (TextUtils.lastIndexOf("", '0') + 49363);
            int threadPriority3 = ((Process.getThreadPriority(0) + 20) >> 6) + 684;
            byte[] bArr27 = $$a;
            Object[] objArr73 = new Object[1];
            b((byte) (-bArr27[45]), bArr27[19], bArr27[66], objArr73);
            objAccessartificialFrame25 = ArtificialStackFrames.coroutineCreation(jumpTapTimeout2, cLastIndexOf2, threadPriority3, 508509282, false, (String) objArr73[0], null);
        }
        long j8 = ((Field) objAccessartificialFrame25).getLong(null);
        if (j8 == -1 || j8 + 1913 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Context baseContext3 = getBaseContext();
            if (baseContext3 == null) {
                int i107 = getARTIFICIAL_FRAME_PACKAGE_NAME + 19;
                artificialFrame = i107 % 128;
                int i108 = i107 % 2;
                Object[] objArr74 = new Object[1];
                a(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 16, 182 - KeyEvent.getDeadChar(0, 0), 26 - View.resolveSize(0, 0), new char[]{22, 17, 6, 19, 6, 17, 0, 65502, 65483, CharUtils.CR, CharUtils.CR, 65534, 65483, 1, 6, '\f', 15, 1, 11, 65534, 1, 65534, 2, 15, 5, 65521}, objArr74);
                Class<?> cls11 = Class.forName((String) objArr74[0]);
                Object[] objArr75 = new Object[1];
                a(false, 8 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 185, (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 17, new char[]{65535, 65529, 65527, '\n', 65535, 5, 4, 65529, 11, '\b', '\b', 65531, 4, '\n', 65495, 6, 6, 2}, objArr75);
                baseContext3 = (Context) cls11.getMethod((String) objArr75[0], new Class[0]).invoke(null, null);
            }
            if (baseContext3 != null) {
                if (baseContext3 instanceof ContextWrapper) {
                    int i109 = artificialFrame + 49;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i109 % 128;
                    int i110 = i109 % 2;
                    if (((ContextWrapper) baseContext3).getBaseContext() != null) {
                        baseContext3 = baseContext3.getApplicationContext();
                    } else {
                        baseContext3 = null;
                    }
                } else {
                    baseContext3 = baseContext3.getApplicationContext();
                }
            }
            Object[] objArr76 = {baseContext3, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 1217775777};
            byte[] bArr28 = $$d;
            Object[] objArr77 = new Object[1];
            c((short) 278, (byte) (-bArr28[77]), bArr28[68], objArr77);
            Class<?> cls12 = Class.forName((String) objArr77[0]);
            Object[] objArr78 = new Object[1];
            c((short) 231, bArr28[59], bArr28[18], objArr78);
            objArr4 = (Object[]) cls12.getMethod((String) objArr78[0], Context.class, Integer.TYPE, Integer.TYPE).invoke(null, objArr76);
            if (baseContext3 != null) {
                Object objAccessartificialFrame26 = ArtificialStackFrames.accessartificialFrame(777251007);
                if (objAccessartificialFrame26 == null) {
                    int i111 = (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 29;
                    char c7 = (char) ((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 49362);
                    int iGreen2 = Color.green(0) + 684;
                    byte[] bArr29 = $$a;
                    Object[] objArr79 = new Object[1];
                    b((byte) (-bArr29[69]), bArr29[66], bArr29[68], objArr79);
                    objAccessartificialFrame26 = ArtificialStackFrames.coroutineCreation(i111, c7, iGreen2, -1321816393, false, (String) objArr79[0], null);
                }
                ((Field) objAccessartificialFrame26).set(null, objArr4);
                try {
                    Long lValueOf6 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame27 = ArtificialStackFrames.accessartificialFrame(-2127922582);
                    if (objAccessartificialFrame27 == null) {
                        int deadChar2 = 30 - KeyEvent.getDeadChar(0, 0);
                        char maxKeyCode = (char) (49362 - (KeyEvent.getMaxKeyCode() >> 16));
                        int scrollDefaultDelay = 684 - (ViewConfiguration.getScrollDefaultDelay() >> 16);
                        byte[] bArr30 = $$a;
                        Object[] objArr80 = new Object[1];
                        b((byte) (-bArr30[45]), bArr30[19], bArr30[66], objArr80);
                        objAccessartificialFrame27 = ArtificialStackFrames.coroutineCreation(deadChar2, maxKeyCode, scrollDefaultDelay, 508509282, false, (String) objArr80[0], null);
                    }
                    ((Field) objAccessartificialFrame27).set(null, lValueOf6);
                } catch (Exception unused5) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object objAccessartificialFrame28 = ArtificialStackFrames.accessartificialFrame(777251007);
            if (objAccessartificialFrame28 == null) {
                int iAlpha = Color.alpha(0) + 30;
                char c8 = (char) (49362 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)));
                int iIndexOf7 = 684 - TextUtils.indexOf("", "", 0);
                byte[] bArr31 = $$a;
                Object[] objArr81 = new Object[1];
                b((byte) (-bArr31[69]), bArr31[66], bArr31[68], objArr81);
                objAccessartificialFrame28 = ArtificialStackFrames.coroutineCreation(iAlpha, c8, iIndexOf7, -1321816393, false, (String) objArr81[0], null);
            }
            Object[] objArr82 = (Object[]) ((Field) objAccessartificialFrame28).get(null);
            objArr4 = new Object[]{new int[]{((int[]) objArr82[0])[0]}, new int[]{((int[]) objArr82[1])[0]}, new int[1], (String) objArr82[3]};
            int iIdentityHashCode5 = System.identityHashCode(this);
            int i112 = ((~((-20971525) | iIdentityHashCode5)) * 521) + 1783525776 + (((~((~iIdentityHashCode5) | (-20971525))) | 68164250) * 521) + 1217775777;
            int i113 = (i112 << 13) ^ i112;
            int i114 = i113 ^ (i113 >>> 17);
            ((int[]) objArr4[2])[0] = i114 ^ (i114 << 5);
        }
        int i115 = ((int[]) objArr4[1])[0];
        int i116 = ((int[]) objArr4[0])[0];
        if (i116 == i115) {
            int i117 = ((int[]) objArr4[2])[0];
            Object[] objArr83 = {new int[]{((int[]) objArr4[0])[0]}, new int[]{((int[]) objArr4[1])[0]}, new int[1], (String) objArr4[3]};
            int length = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 1977835304;
            int i118 = ~length;
            int i119 = i117 + (-39077134) + (((~((-899589926) | i118)) | (~(901773309 | length))) * (-831)) + ((~((-822739461) | length)) * (-1662)) + (((~(length | 899589925)) | (~(i118 | (-79033850))) | (~(79033849 | length))) * 831);
            int i120 = (i119 << 13) ^ i119;
            int i121 = i120 ^ (i120 >>> 17);
            i2 = 0;
            ((int[]) objArr83[2])[0] = i121 ^ (i121 << 5);
        } else {
            Object[] objArr84 = {Long.valueOf(((long) (i115 ^ i116)) ^ (((long) (-654927635)) << 32)), Long.valueOf(-654927123)};
            byte[] bArr32 = $$d;
            Object[] objArr85 = new Object[1];
            c((short) 519, bArr32[89], bArr32[42], objArr85);
            Class<?> cls13 = Class.forName((String) objArr85[0]);
            Object[] objArr86 = new Object[1];
            c((short) 495, bArr32[20], bArr32[140], objArr86);
            cls13.getMethod((String) objArr86[0], Long.TYPE, Long.TYPE).invoke(null, objArr84);
            int i122 = ((int[]) objArr4[2])[0];
            Object[] objArr87 = {new int[]{((int[]) objArr4[0])[0]}, new int[]{((int[]) objArr4[1])[0]}, new int[1], (String) objArr4[3]};
            int iMyUid = Process.myUid();
            int i123 = ~iMyUid;
            int i124 = i122 + (-981222786) + (((~(215550761 | i123)) | 555913428) * SyslogConstants.LOG_LOCAL7) + ((iMyUid | 8391176) * (-184)) + ((~((-763073014) | i123)) * SyslogConstants.LOG_LOCAL7);
            int i125 = (i124 << 13) ^ i124;
            int i126 = i125 ^ (i125 >>> 17);
            i2 = 0;
            ((int[]) objArr87[2])[0] = i126 ^ (i126 << 5);
        }
        Object objAccessartificialFrame29 = ArtificialStackFrames.accessartificialFrame(-1168947751);
        if (objAccessartificialFrame29 == null) {
            int i127 = (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 35;
            char trimmedLength = (char) TextUtils.getTrimmedLength("");
            int i128 = 539 - (ExpandableListView.getPackedPositionForChild(i2, i2) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(i2, i2) == 0L ? 0 : -1));
            byte[] bArr33 = $$a;
            Object[] objArr88 = new Object[1];
            b((byte) 75, (byte) (bArr33[12] - 1), bArr33[48], objArr88);
            objAccessartificialFrame29 = ArtificialStackFrames.coroutineCreation(i127, trimmedLength, i128, 624296913, false, (String) objArr88[0], null);
        }
        long j9 = ((Field) objAccessartificialFrame29).getLong(null);
        if (j9 == -1 || j9 + 1949 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Object objAccessartificialFrame30 = ArtificialStackFrames.accessartificialFrame(-1717965552);
            if (objAccessartificialFrame30 == null) {
                objAccessartificialFrame30 = ArtificialStackFrames.coroutineCreation(20 - View.MeasureSpec.makeMeasureSpec(0, 0), (char) (39516 - TextUtils.indexOf("", "", 0, 0)), TextUtils.lastIndexOf("", '0', 0) + 983, 117222168, false, null, new Class[0]);
            }
            Object[] objArr89 = {null, ((Constructor) objAccessartificialFrame30).newInstance(null), 1195045107, 0};
            Object objAccessartificialFrame31 = ArtificialStackFrames.accessartificialFrame(-501205803);
            if (objAccessartificialFrame31 == null) {
                int iLastIndexOf2 = 35 - TextUtils.lastIndexOf("", '0');
                char c9 = (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                int packedPositionGroup3 = ExpandableListView.getPackedPositionGroup(0L) + 540;
                byte[] bArr34 = $$a;
                Object[] objArr90 = new Object[1];
                b((byte) (-bArr34[64]), (byte) 47, (byte) (bArr34[12] - 1), objArr90);
                objAccessartificialFrame31 = ArtificialStackFrames.coroutineCreation(iLastIndexOf2, c9, packedPositionGroup3, 2101703389, false, (String) objArr90[0], new Class[]{(Class) ArtificialStackFrames.coroutineCreation(54 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) (833 - ExpandableListView.getPackedPositionGroup(0L)), (ViewConfiguration.getKeyRepeatDelay() >> 16) + 576), (Class) ArtificialStackFrames.coroutineCreation('f' - AndroidCharacter.getMirror('0'), (char) (TextUtils.indexOf((CharSequence) "", '0') + 1), 630 - TextUtils.getOffsetAfter("", 0)), Integer.TYPE, Integer.TYPE});
            }
            objArr5 = (Object[]) ((Method) objAccessartificialFrame31).invoke(null, objArr89);
            Object objAccessartificialFrame32 = ArtificialStackFrames.accessartificialFrame(-1339222025);
            if (objAccessartificialFrame32 == null) {
                int edgeSlop = (ViewConfiguration.getEdgeSlop() >> 16) + 36;
                char modifierMetaStateMask = (char) ((-1) - ((byte) KeyEvent.getModifierMetaStateMask()));
                int scrollBarFadeDuration2 = (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 540;
                byte[] bArr35 = $$a;
                Object[] objArr91 = new Object[1];
                b((byte) 67, (byte) (bArr35[12] - 1), bArr35[48], objArr91);
                objAccessartificialFrame32 = ArtificialStackFrames.coroutineCreation(edgeSlop, modifierMetaStateMask, scrollBarFadeDuration2, 793268735, false, (String) objArr91[0], null);
            }
            ((Field) objAccessartificialFrame32).set(null, objArr5);
            try {
                Long lValueOf7 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame33 = ArtificialStackFrames.accessartificialFrame(-1168947751);
                if (objAccessartificialFrame33 == null) {
                    int i129 = 36 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                    char scrollBarSize3 = (char) (ViewConfiguration.getScrollBarSize() >> 8);
                    int size2 = 540 - View.MeasureSpec.getSize(0);
                    byte[] bArr36 = $$a;
                    Object[] objArr92 = new Object[1];
                    b((byte) 75, (byte) (bArr36[12] - 1), bArr36[48], objArr92);
                    objAccessartificialFrame33 = ArtificialStackFrames.coroutineCreation(i129, scrollBarSize3, size2, 624296913, false, (String) objArr92[0], null);
                }
                ((Field) objAccessartificialFrame33).set(null, lValueOf7);
            } catch (Exception unused6) {
                throw new RuntimeException();
            }
        } else {
            Object objAccessartificialFrame34 = ArtificialStackFrames.accessartificialFrame(-1339222025);
            if (objAccessartificialFrame34 == null) {
                int i130 = (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 35;
                char c10 = (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1));
                int i131 = 540 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                byte[] bArr37 = $$a;
                Object[] objArr93 = new Object[1];
                b((byte) 67, (byte) (bArr37[12] - 1), bArr37[48], objArr93);
                objAccessartificialFrame34 = ArtificialStackFrames.coroutineCreation(i130, c10, i131, 793268735, false, (String) objArr93[0], null);
            }
            Object[] objArr94 = (Object[]) ((Field) objAccessartificialFrame34).get(null);
            objArr5 = new Object[]{new int[1], new int[1], new int[1]};
            int i132 = ((int[]) objArr94[2])[0];
            int i133 = ((int[]) objArr94[1])[0];
            ((int[]) objArr5[2])[0] = i132;
            ((int[]) objArr5[1])[0] = i133;
            int startUptimeMillis = (int) Process.getStartUptimeMillis();
            int i134 = (-1455651643) + (((~((-888137177) | startUptimeMillis)) | 278930584) * 1504) + ((~(startUptimeMillis | (-609206593))) * (-1504)) + 1102547875;
            int i135 = (i134 << 13) ^ i134;
            int i136 = i135 ^ (i135 >>> 17);
            ((int[]) objArr5[0])[0] = i136 ^ (i136 << 5);
        }
        Object obj3 = objArr5[1];
        int i137 = ((int[]) obj3)[0];
        Object obj4 = objArr5[2];
        int i138 = ((int[]) obj4)[0];
        if (i138 == i137) {
            Object[] objArr95 = {new int[1], new int[1], new int[1]};
            int i139 = ((int[]) objArr5[0])[0];
            int i140 = ((int[]) obj4)[0];
            int i141 = ((int[]) obj3)[0];
            ((int[]) objArr95[2])[0] = i140;
            ((int[]) objArr95[1])[0] = i141;
            int iCodePointAt2 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) - 1410901182;
            int i142 = ~iCodePointAt2;
            int i143 = i139 + (-1281348164) + ((240036128 | i142) * (-757)) + ((~((-1073828438) | iCodePointAt2)) * 1514) + (((~(iCodePointAt2 | 1313864565)) | (~(i142 | (-1111585622))) | 37757184) * 757);
            int i144 = (i143 << 13) ^ i143;
            int i145 = i144 ^ (i144 >>> 17);
            ((int[]) objArr95[0])[0] = i145 ^ (i145 << 5);
        } else {
            Object[] objArr96 = {Long.valueOf((((long) 1079479658) << 32) ^ ((long) (i137 ^ i138))), Long.valueOf(1079483754)};
            byte[] bArr38 = $$d;
            Object[] objArr97 = new Object[1];
            c((short) 519, bArr38[89], bArr38[42], objArr97);
            Class<?> cls14 = Class.forName((String) objArr97[0]);
            Object[] objArr98 = new Object[1];
            c((short) 495, bArr38[20], bArr38[140], objArr98);
            cls14.getMethod((String) objArr98[0], Long.TYPE, Long.TYPE).invoke(null, objArr96);
            Object[] objArr99 = {new int[1], new int[1], new int[1]};
            int i146 = ((int[]) objArr5[0])[0];
            int i147 = ((int[]) objArr5[2])[0];
            int i148 = ((int[]) objArr5[1])[0];
            ((int[]) objArr99[2])[0] = i147;
            ((int[]) objArr99[1])[0] = i148;
            int i149 = ~((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().densityDpi;
            int i150 = i146 + (((787537890 + (((~((-212867408) | i149)) | (-1138754343)) * (-933))) + (((~(i149 | (-1138754343))) | 1128268320) * 933)) - 1444151088);
            int i151 = (i150 << 13) ^ i150;
            int i152 = i151 ^ (i151 >>> 17);
            ((int[]) objArr99[0])[0] = i152 ^ (i152 << 5);
        }
        super.onStart();
        Object objAccessartificialFrame35 = ArtificialStackFrames.accessartificialFrame(1313006081);
        if (objAccessartificialFrame35 == null) {
            int pressedStateDuration3 = 21 - (ViewConfiguration.getPressedStateDuration() >> 16);
            char c11 = (char) (1 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)));
            int i153 = (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 464;
            byte[] bArr39 = $$a;
            Object[] objArr100 = new Object[1];
            b((byte) 75, (byte) (bArr39[12] - 1), bArr39[48], objArr100);
            objAccessartificialFrame35 = ArtificialStackFrames.coroutineCreation(pressedStateDuration3, c11, i153, -785931255, false, (String) objArr100[0], null);
        }
        long j10 = ((Field) objAccessartificialFrame35).getLong(null);
        if (j10 != -1) {
            int i154 = artificialFrame + 19;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i154 % 128;
            if (i154 % 2 != 0) {
                i11 = 0;
                if ((1885 | j10) >= ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[1]).invoke(null, new Object[0])).longValue()) {
                    objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(1142731807);
                    if (objAccessartificialFrame7 == null) {
                        int i155 = (CdmaCellLocation.convertQuartSecToDecDegrees(i11) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(i11) == 0.0d ? 0 : -1)) + 21;
                        char scrollDefaultDelay2 = (char) (ViewConfiguration.getScrollDefaultDelay() >> 16);
                        int i156 = (TypedValue.complexToFraction(i11, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(i11, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 465;
                        byte[] bArr40 = $$a;
                        Object[] objArr101 = new Object[1];
                        b((byte) 67, (byte) (bArr40[12] - 1), bArr40[48], objArr101);
                        objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(i155, scrollDefaultDelay2, i156, -612765161, false, (String) objArr101[0], null);
                    }
                    Object[] objArr102 = (Object[]) ((Field) objAccessartificialFrame7).get(null);
                    objArr6 = new Object[]{new int[]{i}, strArr, new int[1], new int[]{i}};
                    int i157 = ((int[]) objArr102[3])[0];
                    int i158 = ((int[]) objArr102[0])[0];
                    String[] strArr7 = (String[]) objArr102[1];
                    int i159 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().uiMode;
                    int i160 = (~((-197210377) | i159)) | 163643648;
                    int i161 = ((((-2063702547) + (i160 * 992)) + ((i160 | (~((~i159) | (-3293923)))) * (-496))) + ((i159 | (-36860651)) * 496)) - 688811537;
                    int i162 = (i161 << 13) ^ i161;
                    int i163 = i162 ^ (i162 >>> 17);
                    ((int[]) objArr6[2])[0] = i163 ^ (i163 << 5);
                    c = 0;
                } else {
                    i3 = i11;
                }
            } else {
                i11 = 0;
                if (j10 + 1885 >= ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                    objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(1142731807);
                    if (objAccessartificialFrame7 == null) {
                        int i1510 = (CdmaCellLocation.convertQuartSecToDecDegrees(i11) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(i11) == 0.0d ? 0 : -1)) + 21;
                        char scrollDefaultDelay3 = (char) (ViewConfiguration.getScrollDefaultDelay() >> 16);
                        int i1511 = (TypedValue.complexToFraction(i11, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(i11, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 465;
                        byte[] bArr41 = $$a;
                        Object[] objArr103 = new Object[1];
                        b((byte) 67, (byte) (bArr41[12] - 1), bArr41[48], objArr103);
                        objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(i1510, scrollDefaultDelay3, i1511, -612765161, false, (String) objArr103[0], null);
                    }
                    Object[] objArr104 = (Object[]) ((Field) objAccessartificialFrame7).get(null);
                    objArr6 = new Object[]{new int[]{i158}, strArr7, new int[1], new int[]{i157}};
                    int i1512 = ((int[]) objArr104[3])[0];
                    int i1513 = ((int[]) objArr104[0])[0];
                    String[] strArr8 = (String[]) objArr104[1];
                    int i1514 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().uiMode;
                    int i164 = (~((-197210377) | i1514)) | 163643648;
                    int i165 = ((((-2063702547) + (i164 * 992)) + ((i164 | (~((~i1514) | (-3293923)))) * (-496))) + ((i1514 | (-36860651)) * 496)) - 688811537;
                    int i166 = (i165 << 13) ^ i165;
                    int i167 = i166 ^ (i166 >>> 17);
                    ((int[]) objArr6[2])[0] = i167 ^ (i167 << 5);
                    c = 0;
                } else {
                    i3 = i11;
                }
            }
            i4 = ((int[]) objArr6[c])[c];
            i5 = ((int[]) objArr6[3])[c];
            if (i5 == i4) {
                Object[] objArr105 = new Object[4];
                int[] iArr = new int[1];
                objArr105[c] = iArr;
                objArr105[2] = new int[1];
                int[] iArr2 = new int[1];
                objArr105[3] = iArr2;
                int i168 = ((int[]) objArr6[2])[c];
                int i169 = ((int[]) objArr6[3])[c];
                int i170 = ((int[]) objArr6[c])[c];
                String[] strArr9 = (String[]) objArr6[1];
                iArr2[c] = i169;
                iArr[c] = i170;
                int startElapsedRealtime = (int) Process.getStartElapsedRealtime();
                int i171 = ~startElapsedRealtime;
                int i172 = i168 + 1744607828 + (((~(722424607 | i171)) | (~((-882774334) | i171))) * (-867)) + (((~((-882774334) | startElapsedRealtime)) | 344981536 | (~(722424607 | startElapsedRealtime))) * (-1734)) + (((~(startElapsedRealtime | 1067406143)) | (~((-344981537) | i171)) | (~((-537792798) | startElapsedRealtime))) * 867);
                int i173 = (i172 << 13) ^ i172;
                int i174 = i173 ^ (i173 >>> 17);
                ((int[]) objArr105[2])[0] = i174 ^ (i174 << 5);
                objArr105[1] = strArr9;
                i6 = 0;
            } else {
                arrayList = new ArrayList();
                strArr = (String[]) objArr6[1];
                if (strArr != null) {
                    for (String str6 : strArr) {
                        arrayList.add(str6);
                    }
                }
                Object[] objArr106 = {Long.valueOf(((long) (i4 ^ i5)) ^ (((long) 1688639739) << 32)), Long.valueOf(1688639675)};
                byte[] bArr42 = $$d;
                Object[] objArr107 = new Object[1];
                c((short) 167, bArr42[145], bArr42[42], objArr107);
                Class<?> cls15 = Class.forName((String) objArr107[0]);
                Object[] objArr108 = new Object[1];
                c((short) 495, bArr42[20], bArr42[140], objArr108);
                cls15.getMethod((String) objArr108[0], Long.TYPE, Long.TYPE).invoke(null, objArr106);
                Object[] objArr109 = {new int[]{i}, strArr, new int[1], new int[]{i}};
                int i175 = ((int[]) objArr6[2])[0];
                int i176 = ((int[]) objArr6[3])[0];
                int i177 = ((int[]) objArr6[0])[0];
                String[] strArr10 = (String[]) objArr6[1];
                int iNextInt2 = new Random().nextInt(379859508);
                int i178 = (~((-190176229) | iNextInt2)) | 168870432;
                int i179 = i175 + (-2063702547) + (i178 * 992) + ((i178 | (~((~iNextInt2) | (-8520707)))) * (-496)) + ((iNextInt2 | (-29826503)) * 496);
                int i180 = (i179 << 13) ^ i179;
                int i181 = i180 ^ (i180 >>> 17);
                i6 = 0;
                ((int[]) objArr109[2])[0] = i181 ^ (i181 << 5);
            }
            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1268268649);
            if (objAccessartificialFrame3 == null) {
                int gidForName3 = Process.getGidForName("") + 26;
                char cNormalizeMetaState = (char) (KeyEvent.normalizeMetaState(i6) + 30068);
                int i182 = 817 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1));
                byte[] bArr43 = $$a;
                Object[] objArr110 = new Object[1];
                b((byte) 75, (byte) (bArr43[12] - 1), bArr43[48], objArr110);
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(gidForName3, cNormalizeMetaState, i182, 721586079, false, (String) objArr110[0], null);
            }
            j = ((Field) objAccessartificialFrame3).getLong(null);
            if (j != -1 || j + 1910 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object[] objArr111 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, -89787558};
                objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1327366003);
                if (objAccessartificialFrame4 == null) {
                    int i183 = 26 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                    char c12 = (char) ((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 30068);
                    int bitsPerPixel = 815 - ImageFormat.getBitsPerPixel(0);
                    byte[] bArr44 = $$a;
                    byte b5 = (byte) (bArr44[12] - 1);
                    Object[] objArr112 = new Object[1];
                    b(b5, (byte) (b5 | Ascii.FS), bArr44[4], objArr112);
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(i183, c12, bitsPerPixel, -797394565, false, (String) objArr112[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                }
                Object[] objArr113 = (Object[]) ((Method) objAccessartificialFrame4).invoke(null, objArr111);
                objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame5 == null) {
                    int i184 = (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 25;
                    char cKeyCodeFromString = (char) (30068 - KeyEvent.keyCodeFromString(""));
                    int i185 = (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 815;
                    byte[] bArr45 = $$a;
                    Object[] objArr114 = new Object[1];
                    b((byte) 67, (byte) (bArr45[12] - 1), bArr45[48], objArr114);
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(i184, cKeyCodeFromString, i185, 891606461, false, (String) objArr114[0], null);
                }
                ((Field) objAccessartificialFrame5).set(null, objArr113);
                try {
                    Long lValueOf8 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                    if (objAccessartificialFrame6 == null) {
                        int threadPriority4 = 25 - ((Process.getThreadPriority(0) + 20) >> 6);
                        char cIndexOf2 = (char) (30068 - TextUtils.indexOf("", ""));
                        int bitsPerPixel2 = 815 - ImageFormat.getBitsPerPixel(0);
                        byte[] bArr46 = $$a;
                        Object[] objArr115 = new Object[1];
                        b((byte) 75, (byte) (bArr46[12] - 1), bArr46[48], objArr115);
                        objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(threadPriority4, cIndexOf2, bitsPerPixel2, 721586079, false, (String) objArr115[0], null);
                    }
                    ((Field) objAccessartificialFrame6).set(null, lValueOf8);
                    objArr7 = objArr113;
                } catch (Exception unused7) {
                    throw new RuntimeException();
                }
            } else {
                Object objAccessartificialFrame36 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame36 == null) {
                    int iIndexOf8 = 25 - TextUtils.indexOf("", "", 0, 0);
                    char cResolveSizeAndState = (char) (30068 - View.resolveSizeAndState(0, 0, 0));
                    int iRgb2 = (-16776400) - Color.rgb(0, 0, 0);
                    byte[] bArr47 = $$a;
                    Object[] objArr116 = new Object[1];
                    b((byte) 67, (byte) (bArr47[12] - 1), bArr47[48], objArr116);
                    objAccessartificialFrame36 = ArtificialStackFrames.coroutineCreation(iIndexOf8, cResolveSizeAndState, iRgb2, 891606461, false, (String) objArr116[0], null);
                }
                Object[] objArr117 = (Object[]) ((Field) objAccessartificialFrame36).get(null);
                objArr7 = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i186 = ((int[]) objArr117[0])[0];
                int i187 = ((int[]) objArr117[1])[0];
                String[] strArr11 = (String[]) objArr117[2];
                int iNextInt3 = new Random().nextInt(1596073062);
                int i188 = 1137165891 + (((-368059223) | iNextInt3) * 614);
                int i189 = ~iNextInt3;
                int i190 = ((i188 + ((((~((-418126100) | i189)) | 135010305) | (~((-219953734) | i189))) * (-1228))) + (((~(i189 | (-84943429))) | (~((-283115795) | i189))) * 614)) - 89787558;
                int i191 = (i190 << 13) ^ i190;
                int i192 = i191 ^ (i191 >>> 17);
                ((int[]) objArr7[3])[0] = i192 ^ (i192 << 5);
            }
            i8 = ((int[]) objArr7[1])[0];
            i9 = ((int[]) objArr7[0])[0];
            if (i9 == i8) {
                Object[] objArr118 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i193 = ((int[]) objArr7[3])[0];
                int i194 = ((int[]) objArr7[0])[0];
                int i195 = ((int[]) objArr7[1])[0];
                String[] strArr12 = (String[]) objArr7[2];
                int i196 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 742113779;
                int i197 = i193 + (((166053775 + (((-542121985) | (~i196)) * (-490))) + (((~(i196 | 514447799)) | (-1056569784)) * 490)) - 1291530364);
                int i198 = (i197 << 13) ^ i197;
                int i199 = i198 ^ (i198 >>> 17);
                ((int[]) objArr118[3])[0] = i199 ^ (i199 << 5);
                return;
            }
            arrayList2 = new ArrayList();
            strArr2 = (String[]) objArr7[2];
            if (strArr2 != null) {
                for (String str7 : strArr2) {
                    arrayList2.add(str7);
                }
            }
            Object[] objArr119 = {Long.valueOf(((long) (i8 ^ i9)) ^ (((long) (-1381841522)) << 32)), Long.valueOf(-1381841521)};
            byte[] bArr48 = $$d;
            Object[] objArr120 = new Object[1];
            c((short) (-bArr48[3]), bArr48[6], bArr48[42], objArr120);
            Class<?> cls16 = Class.forName((String) objArr120[0]);
            Object[] objArr121 = new Object[1];
            c((short) 495, bArr48[20], bArr48[140], objArr121);
            cls16.getMethod((String) objArr121[0], Long.TYPE, Long.TYPE).invoke(null, objArr119);
            Object[] objArr122 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i200 = ((int[]) objArr7[3])[0];
            int i201 = ((int[]) objArr7[0])[0];
            int i202 = ((int[]) objArr7[1])[0];
            String[] strArr13 = (String[]) objArr7[2];
            int iMyPid2 = Process.myPid();
            int i203 = ~(341841375 | iMyPid2);
            int i204 = i200 + (-1526544867) + (((-485504992) | i203) * (-814)) + ((i203 | (~((~iMyPid2) | 143669009)) | 5393) * 407) + (((~(iMyPid2 | (-143669010))) | (~((-341841376) | iMyPid2)) | 5393) * 407);
            int i205 = (i204 << 13) ^ i204;
            int i206 = i205 ^ (i205 >>> 17);
            ((int[]) objArr122[3])[0] = i206 ^ (i206 << 5);
        }
        i3 = 0;
        Context baseContext4 = getBaseContext();
        if (baseContext4 == null) {
            Object[] objArr123 = new Object[1];
            a(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[i3]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(i3, 4).length() + 16, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[i3]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(i3, 4).length() + 178, 26 - (ViewConfiguration.getPressedStateDuration() >> 16), new char[]{22, 17, 6, 19, 6, 17, 0, 65502, 65483, CharUtils.CR, CharUtils.CR, 65534, 65483, 1, 6, '\f', 15, 1, 11, 65534, 1, 65534, 2, 15, 5, 65521}, objArr123);
            Class<?> cls17 = Class.forName((String) objArr123[0]);
            Object[] objArr124 = new Object[1];
            a(false, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(1) - 42, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 185, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 17, new char[]{65535, 65529, 65527, '\n', 65535, 5, 4, 65529, 11, '\b', '\b', 65531, 4, '\n', 65495, 6, 6, 2}, objArr124);
            baseContext4 = (Context) cls17.getMethod((String) objArr124[0], new Class[0]).invoke(null, null);
        }
        if (baseContext4 != null) {
            int i207 = artificialFrame + 15;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i207 % 128;
            if (i207 % 2 != 0) {
                boolean z = baseContext4 instanceof ContextWrapper;
                Object obj5 = null;
                obj5.hashCode();
                throw null;
            }
            baseContext4 = ((baseContext4 instanceof ContextWrapper) && ((ContextWrapper) baseContext4).getBaseContext() == null) ? null : baseContext4.getApplicationContext();
        }
        int iIntValue4 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
        Object[] objArr125 = new Object[1];
        a(true, (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 62, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(0) + SyslogConstants.LOG_CLOCK, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 60, new char[]{26, 25, 65517, 27, 23, 25, 65510, 23, 65516, 65514, 65519, 65517, 23, 23, 28, 65510, 25, 65514, 65518, 65515, 28, 25, 65510, 28, 65519, 28, 65518, 26, 65515, 65515, 28, 28, 27, 65518, 26, 65510, 65513, 23, 65517, 28, 65518, 65519, 65515, 65515, 65516, 26, 27, 28, 65518, 65516, 65510, 23, 65515, 65519, 25, 65517, 28, 27, 65513, 65512, 65517, 65511, 28, 65513}, objArr125);
        String str8 = (String) objArr125[0];
        Object[] objArr126 = new Object[1];
        a(false, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(0) + 16, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 148, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 43, new char[]{29, 65521, 65518, 31, 65524, 65518, 65521, 65516, ' ', 28, '!', 65520, 28, 65524, 65519, 65521, 65517, 31, 65520, 29, 65517, 65520, 65518, 65517, 65517, 65520, 28, ' ', 65520, 65524, 65517, 65520, 65517, 65518, 65515, 65522, 65517, 65522, 65518, 28, '!', 29, ' ', 65521, 65521, 29, 28, 65523, 65518, 65515, 28, '!', ' ', 65520, 65522, ' ', ' ', ' ', '!', 65515, 65519, 65516, 65524, 65520}, objArr126);
        Object[] objArr127 = {baseContext4, new String[]{str8, (String) objArr126[0]}, Integer.valueOf(iIntValue4), 1, -688811537};
        short s3 = (short) ($$e - 1);
        byte[] bArr49 = $$d;
        Object[] objArr128 = new Object[1];
        c(s3, (byte) (-bArr49[384]), bArr49[42], objArr128);
        Class<?> cls18 = Class.forName((String) objArr128[0]);
        Object[] objArr129 = new Object[1];
        c((short) 231, bArr49[59], bArr49[18], objArr129);
        objArr6 = (Object[]) cls18.getMethod((String) objArr129[0], Context.class, String[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr127);
        int i208 = ((int[]) objArr6[0])[0];
        int i209 = ((int[]) objArr6[3])[0];
        if (baseContext4 != null) {
            Object objAccessartificialFrame37 = ArtificialStackFrames.accessartificialFrame(1142731807);
            if (objAccessartificialFrame37 == null) {
                int iGreen3 = Color.green(0) + 21;
                char packedPositionGroup4 = (char) ExpandableListView.getPackedPositionGroup(0L);
                int iMyTid3 = 465 - (Process.myTid() >> 22);
                byte[] bArr50 = $$a;
                Object[] objArr130 = new Object[1];
                b((byte) 67, (byte) (bArr50[12] - 1), bArr50[48], objArr130);
                objAccessartificialFrame37 = ArtificialStackFrames.coroutineCreation(iGreen3, packedPositionGroup4, iMyTid3, -612765161, false, (String) objArr130[0], null);
            }
            ((Field) objAccessartificialFrame37).set(null, objArr6);
            try {
                Long lValueOf9 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame38 = ArtificialStackFrames.accessartificialFrame(1313006081);
                if (objAccessartificialFrame38 == null) {
                    int i210 = (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 21;
                    char cMyTid = (char) (Process.myTid() >> 22);
                    int i211 = 466 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1));
                    byte[] bArr51 = $$a;
                    Object[] objArr131 = new Object[1];
                    b((byte) 75, (byte) (bArr51[12] - 1), bArr51[48], objArr131);
                    objAccessartificialFrame38 = ArtificialStackFrames.coroutineCreation(i210, cMyTid, i211, -785931255, false, (String) objArr131[0], null);
                }
                ((Field) objAccessartificialFrame38).set(null, lValueOf9);
            } catch (Exception unused8) {
                throw new RuntimeException();
            }
        }
        c = 0;
        i4 = ((int[]) objArr6[c])[c];
        i5 = ((int[]) objArr6[3])[c];
        if (i5 == i4) {
            Object[] objArr1010 = new Object[4];
            int[] iArr3 = new int[1];
            objArr1010[c] = iArr3;
            objArr1010[2] = new int[1];
            int[] iArr4 = new int[1];
            objArr1010[3] = iArr4;
            int i1610 = ((int[]) objArr6[2])[c];
            int i1611 = ((int[]) objArr6[3])[c];
            int i1710 = ((int[]) objArr6[c])[c];
            String[] strArr14 = (String[]) objArr6[1];
            iArr4[c] = i1611;
            iArr3[c] = i1710;
            int startElapsedRealtime2 = (int) Process.getStartElapsedRealtime();
            int i1711 = ~startElapsedRealtime2;
            int i1712 = i1610 + 1744607828 + (((~(722424607 | i1711)) | (~((-882774334) | i1711))) * (-867)) + (((~((-882774334) | startElapsedRealtime2)) | 344981536 | (~(722424607 | startElapsedRealtime2))) * (-1734)) + (((~(startElapsedRealtime2 | 1067406143)) | (~((-344981537) | i1711)) | (~((-537792798) | startElapsedRealtime2))) * 867);
            int i1713 = (i1712 << 13) ^ i1712;
            int i1714 = i1713 ^ (i1713 >>> 17);
            ((int[]) objArr1010[2])[0] = i1714 ^ (i1714 << 5);
            objArr1010[1] = strArr14;
            i6 = 0;
        } else {
            arrayList = new ArrayList();
            strArr = (String[]) objArr6[1];
            if (strArr != null) {
                while (i7 < strArr.length) {
                    arrayList.add(str6);
                }
            }
            Object[] objArr1011 = {Long.valueOf(((long) (i4 ^ i5)) ^ (((long) 1688639739) << 32)), Long.valueOf(1688639675)};
            byte[] bArr410 = $$d;
            Object[] objArr1012 = new Object[1];
            c((short) 167, bArr410[145], bArr410[42], objArr1012);
            Class<?> cls19 = Class.forName((String) objArr1012[0]);
            Object[] objArr1013 = new Object[1];
            c((short) 495, bArr410[20], bArr410[140], objArr1013);
            cls19.getMethod((String) objArr1013[0], Long.TYPE, Long.TYPE).invoke(null, objArr1011);
            Object[] objArr1014 = {new int[]{i177}, strArr10, new int[1], new int[]{i176}};
            int i1715 = ((int[]) objArr6[2])[0];
            int i1716 = ((int[]) objArr6[3])[0];
            int i1717 = ((int[]) objArr6[0])[0];
            String[] strArr15 = (String[]) objArr6[1];
            int iNextInt4 = new Random().nextInt(379859508);
            int i1718 = (~((-190176229) | iNextInt4)) | 168870432;
            int i1719 = i1715 + (-2063702547) + (i1718 * 992) + ((i1718 | (~((~iNextInt4) | (-8520707)))) * (-496)) + ((iNextInt4 | (-29826503)) * 496);
            int i1810 = (i1719 << 13) ^ i1719;
            int i1811 = i1810 ^ (i1810 >>> 17);
            i6 = 0;
            ((int[]) objArr1014[2])[0] = i1811 ^ (i1811 << 5);
        }
        objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1268268649);
        if (objAccessartificialFrame3 == null) {
            int gidForName4 = Process.getGidForName("") + 26;
            char cNormalizeMetaState2 = (char) (KeyEvent.normalizeMetaState(i6) + 30068);
            int i1812 = 817 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1));
            byte[] bArr411 = $$a;
            Object[] objArr1110 = new Object[1];
            b((byte) 75, (byte) (bArr411[12] - 1), bArr411[48], objArr1110);
            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(gidForName4, cNormalizeMetaState2, i1812, 721586079, false, (String) objArr1110[0], null);
        }
        j = ((Field) objAccessartificialFrame3).getLong(null);
        if (j != -1) {
            Object[] objArr1111 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, -89787558};
            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1327366003);
            if (objAccessartificialFrame4 == null) {
                int i1813 = 26 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                char c13 = (char) ((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 30068);
                int bitsPerPixel3 = 815 - ImageFormat.getBitsPerPixel(0);
                byte[] bArr412 = $$a;
                byte b6 = (byte) (bArr412[12] - 1);
                Object[] objArr1112 = new Object[1];
                b(b6, (byte) (b6 | Ascii.FS), bArr412[4], objArr1112);
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(i1813, c13, bitsPerPixel3, -797394565, false, (String) objArr1112[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            }
            Object[] objArr1113 = (Object[]) ((Method) objAccessartificialFrame4).invoke(null, objArr1111);
            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame5 == null) {
                int i1814 = (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 25;
                char cKeyCodeFromString2 = (char) (30068 - KeyEvent.keyCodeFromString(""));
                int i1815 = (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 815;
                byte[] bArr413 = $$a;
                Object[] objArr1114 = new Object[1];
                b((byte) 67, (byte) (bArr413[12] - 1), bArr413[48], objArr1114);
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(i1814, cKeyCodeFromString2, i1815, 891606461, false, (String) objArr1114[0], null);
            }
            ((Field) objAccessartificialFrame5).set(null, objArr1113);
            Long lValueOf10 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1268268649);
            if (objAccessartificialFrame6 == null) {
                int threadPriority5 = 25 - ((Process.getThreadPriority(0) + 20) >> 6);
                char cIndexOf3 = (char) (30068 - TextUtils.indexOf("", ""));
                int bitsPerPixel4 = 815 - ImageFormat.getBitsPerPixel(0);
                byte[] bArr414 = $$a;
                Object[] objArr1115 = new Object[1];
                b((byte) 75, (byte) (bArr414[12] - 1), bArr414[48], objArr1115);
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(threadPriority5, cIndexOf3, bitsPerPixel4, 721586079, false, (String) objArr1115[0], null);
            }
            ((Field) objAccessartificialFrame6).set(null, lValueOf10);
            objArr7 = objArr1113;
        } else {
            Object[] objArr1116 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, -89787558};
            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1327366003);
            if (objAccessartificialFrame4 == null) {
                int i1816 = 26 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                char c14 = (char) ((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 30068);
                int bitsPerPixel5 = 815 - ImageFormat.getBitsPerPixel(0);
                byte[] bArr415 = $$a;
                byte b7 = (byte) (bArr415[12] - 1);
                Object[] objArr1117 = new Object[1];
                b(b7, (byte) (b7 | Ascii.FS), bArr415[4], objArr1117);
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(i1816, c14, bitsPerPixel5, -797394565, false, (String) objArr1117[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            }
            Object[] objArr1118 = (Object[]) ((Method) objAccessartificialFrame4).invoke(null, objArr1116);
            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame5 == null) {
                int i1817 = (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 25;
                char cKeyCodeFromString3 = (char) (30068 - KeyEvent.keyCodeFromString(""));
                int i1818 = (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 815;
                byte[] bArr416 = $$a;
                Object[] objArr1119 = new Object[1];
                b((byte) 67, (byte) (bArr416[12] - 1), bArr416[48], objArr1119);
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(i1817, cKeyCodeFromString3, i1818, 891606461, false, (String) objArr1119[0], null);
            }
            ((Field) objAccessartificialFrame5).set(null, objArr1118);
            Long lValueOf11 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1268268649);
            if (objAccessartificialFrame6 == null) {
                int threadPriority6 = 25 - ((Process.getThreadPriority(0) + 20) >> 6);
                char cIndexOf4 = (char) (30068 - TextUtils.indexOf("", ""));
                int bitsPerPixel6 = 815 - ImageFormat.getBitsPerPixel(0);
                byte[] bArr417 = $$a;
                Object[] objArr11110 = new Object[1];
                b((byte) 75, (byte) (bArr417[12] - 1), bArr417[48], objArr11110);
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(threadPriority6, cIndexOf4, bitsPerPixel6, 721586079, false, (String) objArr11110[0], null);
            }
            ((Field) objAccessartificialFrame6).set(null, lValueOf11);
            objArr7 = objArr1118;
        }
        i8 = ((int[]) objArr7[1])[0];
        i9 = ((int[]) objArr7[0])[0];
        if (i9 == i8) {
            Object[] objArr1120 = {new int[]{i194}, new int[]{i195}, strArr12, new int[1]};
            int i1910 = ((int[]) objArr7[3])[0];
            int i1911 = ((int[]) objArr7[0])[0];
            int i1912 = ((int[]) objArr7[1])[0];
            String[] strArr16 = (String[]) objArr7[2];
            int i1913 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 742113779;
            int i1914 = i1910 + (((166053775 + (((-542121985) | (~i1913)) * (-490))) + (((~(i1913 | 514447799)) | (-1056569784)) * 490)) - 1291530364);
            int i1915 = (i1914 << 13) ^ i1914;
            int i1916 = i1915 ^ (i1915 >>> 17);
            ((int[]) objArr1120[3])[0] = i1916 ^ (i1916 << 5);
            return;
        }
        arrayList2 = new ArrayList();
        strArr2 = (String[]) objArr7[2];
        if (strArr2 != null) {
            while (i10 < strArr2.length) {
                arrayList2.add(str7);
            }
        }
        Object[] objArr1121 = {Long.valueOf(((long) (i8 ^ i9)) ^ (((long) (-1381841522)) << 32)), Long.valueOf(-1381841521)};
        byte[] bArr418 = $$d;
        Object[] objArr1210 = new Object[1];
        c((short) (-bArr418[3]), bArr418[6], bArr418[42], objArr1210);
        Class<?> cls110 = Class.forName((String) objArr1210[0]);
        Object[] objArr1211 = new Object[1];
        c((short) 495, bArr418[20], bArr418[140], objArr1211);
        cls110.getMethod((String) objArr1211[0], Long.TYPE, Long.TYPE).invoke(null, objArr1121);
        Object[] objArr1212 = {new int[]{i201}, new int[]{i202}, strArr13, new int[1]};
        int i2010 = ((int[]) objArr7[3])[0];
        int i2011 = ((int[]) objArr7[0])[0];
        int i2012 = ((int[]) objArr7[1])[0];
        String[] strArr17 = (String[]) objArr7[2];
        int iMyPid3 = Process.myPid();
        int i2013 = ~(341841375 | iMyPid3);
        int i2014 = i2010 + (-1526544867) + (((-485504992) | i2013) * (-814)) + ((i2013 | (~((~iMyPid3) | 143669009)) | 5393) * 407) + (((~(iMyPid3 | (-143669010))) | (~((-341841376) | iMyPid3)) | 5393) * 407);
        int i2015 = (i2014 << 13) ^ i2014;
        int i2016 = i2015 ^ (i2015 >>> 17);
        ((int[]) objArr1212[3])[0] = i2016 ^ (i2016 << 5);
    }

    @Override // android.app.Activity
    protected void onResume() throws Throwable {
        int i = 2 % 2;
        int i2 = getARTIFICIAL_FRAME_PACKAGE_NAME + 29;
        artificialFrame = i2 % 128;
        int i3 = i2 % 2;
        Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(949068051);
        if (objAccessartificialFrame == null) {
            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(30 - (ViewConfiguration.getLongPressTimeout() >> 16), (char) (49992 - ((byte) KeyEvent.getModifierMetaStateMask())), 74 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), -1477122277, false, "MediaDescriptionCompatApi23Builder", null);
        }
        Object obj = ((Field) objAccessartificialFrame).get(null);
        try {
            Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1579113874);
            if (objAccessartificialFrame2 == null) {
                int i4 = 30 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                char packedPositionChild = (char) (ExpandableListView.getPackedPositionChild(0L) + 49994);
                int packedPositionType = ExpandableListView.getPackedPositionType(0L) + 74;
                byte[] bArr = $$d;
                Object[] objArr = new Object[1];
                c(bArr[45], bArr[120], bArr[8], objArr);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(i4, packedPositionChild, packedPositionType, -1048962150, false, (String) objArr[0], new Class[0]);
            }
            ((Method) objAccessartificialFrame2).invoke(obj, null);
            super.onResume();
            int i5 = getARTIFICIAL_FRAME_PACKAGE_NAME + 23;
            artificialFrame = i5 % 128;
            if (i5 % 2 == 0) {
                throw null;
            }
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
        int i2 = getARTIFICIAL_FRAME_PACKAGE_NAME + 45;
        artificialFrame = i2 % 128;
        Object obj = null;
        try {
            if (i2 % 2 == 0) {
                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(949068051);
                if (objAccessartificialFrame == null) {
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(31 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), (char) (49993 - Gravity.getAbsoluteGravity(0, 0)), 74 - (ViewConfiguration.getLongPressTimeout() >> 16), -1477122277, false, "MediaDescriptionCompatApi23Builder", null);
                }
                Object obj2 = ((Field) objAccessartificialFrame).get(null);
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1579114835);
                if (objAccessartificialFrame2 == null) {
                    int tapTimeout = (ViewConfiguration.getTapTimeout() >> 16) + 30;
                    char packedPositionGroup = (char) (ExpandableListView.getPackedPositionGroup(0L) + 49993);
                    int iLastIndexOf = 73 - TextUtils.lastIndexOf("", '0');
                    byte[] bArr = $$d;
                    Object[] objArr = new Object[1];
                    c(bArr[45], bArr[120], bArr[42], objArr);
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(tapTimeout, packedPositionGroup, iLastIndexOf, -1048959141, false, (String) objArr[0], new Class[0]);
                }
                ((Method) objAccessartificialFrame2).invoke(obj2, null);
                super.onPause();
                obj.hashCode();
                throw null;
            }
            Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(949068051);
            if (objAccessartificialFrame3 == null) {
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(30 - (ViewConfiguration.getScrollDefaultDelay() >> 16), (char) (View.MeasureSpec.getSize(0) + 49993), View.resolveSizeAndState(0, 0, 0) + 74, -1477122277, false, "MediaDescriptionCompatApi23Builder", null);
            }
            Object obj3 = ((Field) objAccessartificialFrame3).get(null);
            Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1579114835);
            if (objAccessartificialFrame4 == null) {
                int keyRepeatTimeout = (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 30;
                char tapTimeout2 = (char) ((ViewConfiguration.getTapTimeout() >> 16) + 49993);
                int iLastIndexOf2 = 73 - TextUtils.lastIndexOf("", '0');
                byte[] bArr2 = $$d;
                Object[] objArr2 = new Object[1];
                c(bArr2[45], bArr2[120], bArr2[42], objArr2);
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(keyRepeatTimeout, tapTimeout2, iLastIndexOf2, -1048959141, false, (String) objArr2[0], new Class[0]);
            }
            ((Method) objAccessartificialFrame4).invoke(obj3, null);
            super.onPause();
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    /* JADX WARN: Code duplicated, block: B:116:0x0652 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:117:0x064a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:15:0x00cb A[PHI: r0
  0x00cb: PHI (r0v13 long) = (r0v5 long), (r0v247 long) binds: [B:14:0x00c9, B:8:0x0074] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:17:0x01e4  */
    /* JADX WARN: Code duplicated, block: B:19:0x01ed  */
    /* JADX WARN: Code duplicated, block: B:37:0x05b1  */
    /* JADX WARN: Code duplicated, block: B:38:0x0621  */
    /* JADX WARN: Code duplicated, block: B:40:0x062d  */
    /* JADX WARN: Code duplicated, block: B:42:0x0638  */
    /* JADX WARN: Code duplicated, block: B:43:0x063a  */
    /* JADX WARN: Code duplicated, block: B:46:0x063e  */
    /* JADX WARN: Code duplicated, block: B:55:0x0721  */
    /* JADX WARN: Code duplicated, block: B:58:0x076c  */
    /* JADX WARN: Code duplicated, block: B:60:0x083f  */
    /* JADX WARN: Code duplicated, block: B:62:0x0848  */
    /* JADX WARN: Code duplicated, block: B:65:0x08e5  */
    /* JADX WARN: Code duplicated, block: B:68:0x09f6 A[Catch: all -> 0x0d60, TryCatch #0 {all -> 0x0d60, blocks: (B:22:0x0382, B:24:0x03a3, B:25:0x03f1, B:66:0x09e2, B:68:0x09f6, B:69:0x0a23), top: B:106:0x0382 }] */
    /* JADX WARN: Code duplicated, block: B:72:0x0a39  */
    /* JADX WARN: Code duplicated, block: B:77:0x0b9d  */
    /* JADX WARN: Code duplicated, block: B:81:0x0beb  */
    /* JADX WARN: Code duplicated, block: B:82:0x0c5f  */
    /* JADX WARN: Code duplicated, block: B:84:0x0c6a  */
    /* JADX WARN: Code duplicated, block: B:87:0x0c6e A[LOOP:0: B:85:0x0c6b->B:87:0x0c6e, LOOP_END] */
    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) throws Throwable {
        long j;
        long j2;
        Class<?> cls;
        Object[] objArr;
        Object objAccessartificialFrame;
        Object[] objArr2;
        int i;
        int i2;
        ArrayList arrayList;
        String[] strArr;
        int i3;
        int i4;
        int i5;
        Object objAccessartificialFrame2;
        long j3;
        Object objAccessartificialFrame3;
        Object[] objArrAccessartificialFrame$78cbbd35;
        Object objAccessartificialFrame4;
        Object objAccessartificialFrame5;
        int i6;
        int i7;
        ArrayList arrayList2;
        String[] strArr2;
        int i8;
        long j4;
        Class<?> cls2;
        Object[] objArr3;
        Object objAccessartificialFrame6;
        Class<?> cls3;
        Object[] objArr4;
        int i9 = 2 % 2;
        int i10 = getARTIFICIAL_FRAME_PACKAGE_NAME + 83;
        artificialFrame = i10 % 128;
        try {
            try {
                if (i10 % 2 != 0) {
                    super.attachBaseContext(context);
                    Object objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                    if (objAccessartificialFrame7 == null) {
                        int scrollBarFadeDuration = 25 - (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                        char c = (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 30067);
                        int deadChar = KeyEvent.getDeadChar(0, 0) + 816;
                        byte[] bArr = $$a;
                        Object[] objArr5 = new Object[1];
                        b((byte) 75, (byte) (bArr[12] - 1), bArr[48], objArr5);
                        objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(scrollBarFadeDuration, c, deadChar, 721586079, false, (String) objArr5[0], null);
                    }
                    j = ((Field) objAccessartificialFrame7).getLong(null);
                    if (j != -1) {
                        j2 = j + 2046;
                        Object[] objArr6 = new Object[1];
                        a(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length(), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(3) + 67, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) - 27, new char[]{0, '\f', '\t', 65504, '\n', 2, 17, 16, 22, 65520, 65483, 16, '\f', 65483, 1, 6, '\f', 15, 1, 11, 65534, '\b'}, objArr6);
                        cls = Class.forName((String) objArr6[0]);
                        objArr = new Object[1];
                        a(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) - 23, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 182, ExpandableListView.getPackedPositionType(0L) + 15, new char[]{2, CharUtils.CR, 5, 65530, 65534, 65515, 65533, 65534, '\f', '\t', 65530, 5, 65534, 65534, 6}, objArr);
                        if (j2 >= ((Long) cls.getDeclaredMethod((String) objArr[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1438542923);
                            if (objAccessartificialFrame == null) {
                                int packedPositionType = 25 - ExpandableListView.getPackedPositionType(0L);
                                char c2 = (char) (30068 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)));
                                int scrollDefaultDelay = (ViewConfiguration.getScrollDefaultDelay() >> 16) + 816;
                                byte[] bArr2 = $$a;
                                Object[] objArr7 = new Object[1];
                                b((byte) 67, (byte) (bArr2[12] - 1), bArr2[48], objArr7);
                                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(packedPositionType, c2, scrollDefaultDelay, 891606461, false, (String) objArr7[0], null);
                            }
                            Object[] objArr8 = (Object[]) ((Field) objAccessartificialFrame).get(null);
                            objArr2 = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
                            int i11 = ((int[]) objArr8[0])[0];
                            int i12 = ((int[]) objArr8[1])[0];
                            String[] strArr3 = (String[]) objArr8[2];
                            int i13 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().uiMode;
                            int i14 = ((((-1314985495) + ((~((~i13) | 131063485)) * (-116))) + ((130028216 | i13) * 116)) + (((~(i13 | (-68144150))) | 67108880) * 116)) - 1377568488;
                            int i15 = (i14 << 13) ^ i14;
                            int i16 = i15 ^ (i15 >>> 17);
                            ((int[]) objArr2[3])[0] = i16 ^ (i16 << 5);
                        }
                    }
                    i = ((int[]) objArr2[1])[0];
                    i2 = ((int[]) objArr2[0])[0];
                    if (i2 == i) {
                        Object[] objArr9 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
                        int i17 = ((int[]) objArr2[3])[0];
                        int i18 = ((int[]) objArr2[0])[0];
                        int i19 = ((int[]) objArr2[1])[0];
                        String[] strArr4 = (String[]) objArr2[2];
                        int iMyTid = Process.myTid();
                        int i20 = ~iMyTid;
                        int i21 = i17 + (-405470199) + (((~(324092019 | i20)) | (-522264386) | (~((-324092020) | iMyTid))) * (-564)) + ((~(iMyTid | (-318832706))) * 1128) + (((~((-522264386) | i20)) | 5259314) * 564);
                        int i22 = (i21 << 13) ^ i21;
                        int i23 = i22 ^ (i22 >>> 17);
                        ((int[]) objArr9[3])[0] = i23 ^ (i23 << 5);
                    } else {
                        arrayList = new ArrayList();
                        strArr = (String[]) objArr2[2];
                        if (strArr != null) {
                            i3 = artificialFrame + 107;
                            getARTIFICIAL_FRAME_PACKAGE_NAME = i3 % 128;
                            if (i3 % 2 != 0) {
                                i4 = 1;
                            } else {
                                i4 = 0;
                            }
                            while (i4 < strArr.length) {
                                i5 = artificialFrame + 79;
                                getARTIFICIAL_FRAME_PACKAGE_NAME = i5 % 128;
                                if (i5 % 2 != 0) {
                                    arrayList.add(strArr[i4]);
                                    i4 += 47;
                                } else {
                                    arrayList.add(strArr[i4]);
                                    i4++;
                                }
                            }
                        }
                        Object[] objArr10 = {Long.valueOf(((long) (i ^ i2)) ^ (((long) 1159195888) << 32)), Long.valueOf(1159195889)};
                        byte[] bArr3 = $$d;
                        short s = bArr3[45];
                        Object[] objArr11 = new Object[1];
                        c(s, (byte) s, bArr3[42], objArr11);
                        Class<?> cls4 = Class.forName((String) objArr11[0]);
                        Object[] objArr12 = new Object[1];
                        c((short) 495, bArr3[20], bArr3[140], objArr12);
                        cls4.getMethod((String) objArr12[0], Long.TYPE, Long.TYPE).invoke(null, objArr10);
                        Object[] objArr13 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
                        int i24 = ((int[]) objArr2[3])[0];
                        int i25 = ((int[]) objArr2[0])[0];
                        int i26 = ((int[]) objArr2[1])[0];
                        String[] strArr5 = (String[]) objArr2[2];
                        int elapsedCpuTime = (int) Process.getElapsedCpuTime();
                        int i27 = i24 + ((~((~elapsedCpuTime) | 536410095)) * 130) + 260297963 + (((~(elapsedCpuTime | 536410095)) | 304664737) * 130);
                        int i28 = (i27 << 13) ^ i27;
                        int i29 = i28 ^ (i28 >>> 17);
                        ((int[]) objArr13[3])[0] = i29 ^ (i29 << 5);
                    }
                    objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-444530678);
                    if (objAccessartificialFrame2 == null) {
                        int iIndexOf = TextUtils.indexOf("", "") + 26;
                        char cGreen = (char) Color.green(0);
                        int iKeyCodeFromString = KeyEvent.keyCodeFromString("") + 1041;
                        byte[] bArr4 = $$a;
                        Object[] objArr14 = new Object[1];
                        b((byte) 75, (byte) (bArr4[12] - 1), bArr4[48], objArr14);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iIndexOf, cGreen, iKeyCodeFromString, 2061780482, false, (String) objArr14[0], null);
                    }
                    j3 = ((Field) objAccessartificialFrame2).getLong(null);
                    if (j3 != -1) {
                        int i30 = artificialFrame + 3;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i30 % 128;
                        int i31 = i30 % 2;
                        j4 = j3 + 1888;
                        Object[] objArr15 = new Object[1];
                        a(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(3) - 25, (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 181, 22 - KeyEvent.normalizeMetaState(0), new char[]{0, '\f', '\t', 65504, '\n', 2, 17, 16, 22, 65520, 65483, 16, '\f', 65483, 1, 6, '\f', 15, 1, 11, 65534, '\b'}, objArr15);
                        cls2 = Class.forName((String) objArr15[0]);
                        objArr3 = new Object[1];
                        a(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 8, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 182, KeyEvent.normalizeMetaState(0) + 15, new char[]{2, CharUtils.CR, 5, 65530, 65534, 65515, 65533, 65534, '\f', '\t', 65530, 5, 65534, 65534, 6}, objArr3);
                        if (j4 >= ((Long) cls2.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                            objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-614804952);
                            if (objAccessartificialFrame6 == null) {
                                int i32 = (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 25;
                                char cRgb = (char) (ViewCompat.MEASURED_STATE_MASK - Color.rgb(0, 0, 0));
                                int iIndexOf2 = 1040 - TextUtils.indexOf((CharSequence) "", '0', 0, 0);
                                byte[] bArr5 = $$a;
                                byte b = (byte) (bArr5[12] - 1);
                                byte b2 = bArr5[48];
                                Object[] objArr16 = new Object[1];
                                b((byte) 67, b, b2, objArr16);
                                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(i32, cRgb, iIndexOf2, 1145017376, false, (String) objArr16[0], null);
                            }
                            Object[] objArr17 = (Object[]) ((Field) objAccessartificialFrame6).get(null);
                            objArrAccessartificialFrame$78cbbd35 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
                            int i33 = ((int[]) objArr17[3])[0];
                            int i34 = ((int[]) objArr17[2])[0];
                            String[] strArr6 = (String[]) objArr17[0];
                            int iIdentityHashCode = System.identityHashCode(this);
                            int i35 = (-421906180) + (((-262229) | iIdentityHashCode) * (-381)) + (((~((~iIdentityHashCode) | 60941482)) | (-44303615)) * 381) + 101711641;
                            int i36 = (i35 << 13) ^ i35;
                            int i37 = i36 ^ (i36 >>> 17);
                            ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0] = i37 ^ (i37 << 5);
                        } else {
                            Object[] objArr18 = new Object[1];
                            a(true, (ViewConfiguration.getScrollDefaultDelay() >> 16) + 16, (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + RotationOptions.ROTATE_180, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 19, new char[]{11, 3, 18, 17, 23, 65521, 65484, 5, '\f', 65535, '\n', 65484, 65535, 20, 65535, '\b'}, objArr18);
                            Class<?> cls5 = Class.forName((String) objArr18[0]);
                            Object[] objArr19 = new Object[1];
                            a(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(3) - 102, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) + 149, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) - 20, new char[]{65501, 2, CharUtils.CR, 65531, 65506, 19, 14, 3, 14, '\b', 65535, 65534, 3, 65535, 65534, '\t'}, objArr19);
                            int iIntValue = ((Integer) cls5.getMethod((String) objArr19[0], Object.class).invoke(null, this)).intValue();
                            Object[] objArr20 = {1908628746};
                            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1648942878);
                            if (objAccessartificialFrame3 == null) {
                                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(8 - View.MeasureSpec.getMode(0), (char) (ExpandableListView.getPackedPositionType(0L) + 22251), 1033 - (Process.myTid() >> 22), 47343338, false, null, new Class[]{Integer.TYPE});
                            }
                            objArrAccessartificialFrame$78cbbd35 = FocusedInputObserver.accessartificialFrame$78cbbd35(iIntValue, 0, ((Constructor) objAccessartificialFrame3).newInstance(objArr20), 1802773, false);
                            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-614804952);
                            if (objAccessartificialFrame4 == null) {
                                int iGreen = 26 - Color.green(0);
                                char doubleTapTimeout = (char) (ViewConfiguration.getDoubleTapTimeout() >> 16);
                                int iMyTid2 = 1041 - (Process.myTid() >> 22);
                                byte[] bArr6 = $$a;
                                Object[] objArr21 = new Object[1];
                                b((byte) 67, (byte) (bArr6[12] - 1), bArr6[48], objArr21);
                                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(iGreen, doubleTapTimeout, iMyTid2, 1145017376, false, (String) objArr21[0], null);
                            }
                            ((Field) objAccessartificialFrame4).set(null, objArrAccessartificialFrame$78cbbd35);
                            Object[] objArr22 = new Object[1];
                            a(true, View.getDefaultSize(0, 0) + 21, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 147, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) - 14, new char[]{0, '\f', '\t', 65504, '\n', 2, 17, 16, 22, 65520, 65483, 16, '\f', 65483, 1, 6, '\f', 15, 1, 11, 65534, '\b'}, objArr22);
                            Class<?> cls6 = Class.forName((String) objArr22[0]);
                            Object[] objArr23 = new Object[1];
                            a(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(0) - 24, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 151, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(3) - 100, new char[]{2, CharUtils.CR, 5, 65530, 65534, 65515, 65533, 65534, '\f', '\t', 65530, 5, 65534, 65534, 6}, objArr23);
                            Long lValueOf = Long.valueOf(((Long) cls6.getDeclaredMethod((String) objArr23[0], new Class[0]).invoke(null, new Object[0])).longValue());
                            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-444530678);
                            if (objAccessartificialFrame5 == null) {
                                int iMyPid = 26 - (Process.myPid() >> 22);
                                char cNormalizeMetaState = (char) KeyEvent.normalizeMetaState(0);
                                int scrollBarFadeDuration2 = 1041 - (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                                byte[] bArr7 = $$a;
                                Object[] objArr24 = new Object[1];
                                b((byte) 75, (byte) (bArr7[12] - 1), bArr7[48], objArr24);
                                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(iMyPid, cNormalizeMetaState, scrollBarFadeDuration2, 2061780482, false, (String) objArr24[0], null);
                            }
                            ((Field) objAccessartificialFrame5).set(null, lValueOf);
                        }
                    } else {
                        Object[] objArr110 = new Object[1];
                        a(true, (ViewConfiguration.getScrollDefaultDelay() >> 16) + 16, (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + RotationOptions.ROTATE_180, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 19, new char[]{11, 3, 18, 17, 23, 65521, 65484, 5, '\f', 65535, '\n', 65484, 65535, 20, 65535, '\b'}, objArr110);
                        Class<?> cls7 = Class.forName((String) objArr110[0]);
                        Object[] objArr111 = new Object[1];
                        a(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(3) - 102, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) + 149, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) - 20, new char[]{65501, 2, CharUtils.CR, 65531, 65506, 19, 14, 3, 14, '\b', 65535, 65534, 3, 65535, 65534, '\t'}, objArr111);
                        int iIntValue2 = ((Integer) cls7.getMethod((String) objArr111[0], Object.class).invoke(null, this)).intValue();
                        Object[] objArr25 = {1908628746};
                        objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1648942878);
                        if (objAccessartificialFrame3 == null) {
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(8 - View.MeasureSpec.getMode(0), (char) (ExpandableListView.getPackedPositionType(0L) + 22251), 1033 - (Process.myTid() >> 22), 47343338, false, null, new Class[]{Integer.TYPE});
                        }
                        objArrAccessartificialFrame$78cbbd35 = FocusedInputObserver.accessartificialFrame$78cbbd35(iIntValue2, 0, ((Constructor) objAccessartificialFrame3).newInstance(objArr25), 1802773, false);
                        objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-614804952);
                        if (objAccessartificialFrame4 == null) {
                            int iGreen2 = 26 - Color.green(0);
                            char doubleTapTimeout2 = (char) (ViewConfiguration.getDoubleTapTimeout() >> 16);
                            int iMyTid3 = 1041 - (Process.myTid() >> 22);
                            byte[] bArr8 = $$a;
                            Object[] objArr26 = new Object[1];
                            b((byte) 67, (byte) (bArr8[12] - 1), bArr8[48], objArr26);
                            objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(iGreen2, doubleTapTimeout2, iMyTid3, 1145017376, false, (String) objArr26[0], null);
                        }
                        ((Field) objAccessartificialFrame4).set(null, objArrAccessartificialFrame$78cbbd35);
                        Object[] objArr27 = new Object[1];
                        a(true, View.getDefaultSize(0, 0) + 21, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 147, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) - 14, new char[]{0, '\f', '\t', 65504, '\n', 2, 17, 16, 22, 65520, 65483, 16, '\f', 65483, 1, 6, '\f', 15, 1, 11, 65534, '\b'}, objArr27);
                        Class<?> cls8 = Class.forName((String) objArr27[0]);
                        Object[] objArr28 = new Object[1];
                        a(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(0) - 24, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 151, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(3) - 100, new char[]{2, CharUtils.CR, 5, 65530, 65534, 65515, 65533, 65534, '\f', '\t', 65530, 5, 65534, 65534, 6}, objArr28);
                        Long lValueOf2 = Long.valueOf(((Long) cls8.getDeclaredMethod((String) objArr28[0], new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-444530678);
                        if (objAccessartificialFrame5 == null) {
                            int iMyPid2 = 26 - (Process.myPid() >> 22);
                            char cNormalizeMetaState2 = (char) KeyEvent.normalizeMetaState(0);
                            int scrollBarFadeDuration3 = 1041 - (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                            byte[] bArr9 = $$a;
                            Object[] objArr29 = new Object[1];
                            b((byte) 75, (byte) (bArr9[12] - 1), bArr9[48], objArr29);
                            objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(iMyPid2, cNormalizeMetaState2, scrollBarFadeDuration3, 2061780482, false, (String) objArr29[0], null);
                        }
                        ((Field) objAccessartificialFrame5).set(null, lValueOf2);
                    }
                    i6 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
                    i7 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
                    if (i7 == i6) {
                        int i38 = artificialFrame + 71;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i38 % 128;
                        int i39 = i38 % 2;
                        Object[] objArr30 = {strArr, new int[1], new int[]{i}, new int[]{i}};
                        int i40 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
                        int i41 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
                        int i42 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
                        String[] strArr7 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
                        int iUptimeMillis = (int) SystemClock.uptimeMillis();
                        int i43 = i40 + 775843822 + ((483982599 | iUptimeMillis) * 376) + (((~((~iUptimeMillis) | 870474515)) | 202939396) * (-376)) + (((~(iUptimeMillis | (-870474516))) | (-792370709)) * 376);
                        int i44 = (i43 << 13) ^ i43;
                        int i45 = i44 ^ (i44 >>> 17);
                        ((int[]) objArr30[1])[0] = i45 ^ (i45 << 5);
                        return;
                    }
                    arrayList2 = new ArrayList();
                    strArr2 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
                    if (strArr2 != null) {
                        for (String str : strArr2) {
                            arrayList2.add(str);
                        }
                    }
                    long j5 = ((long) (i6 ^ i7)) ^ (((long) 1306091625) << 32);
                    long j6 = 1306091627;
                    int i46 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                    int i47 = i46 + b.f40o;
                    artificialFrame = i47 % 128;
                    int i48 = i47 % 2;
                    int i49 = i46 + 29;
                    artificialFrame = i49 % 128;
                    int i50 = i49 % 2;
                    Object[] objArr31 = {Long.valueOf(j5), Long.valueOf(j6)};
                    byte[] bArr10 = $$d;
                    byte b3 = bArr10[120];
                    Object[] objArr32 = new Object[1];
                    c(b3, (byte) (-bArr10[110]), b3, objArr32);
                    Class<?> cls9 = Class.forName((String) objArr32[0]);
                    Object[] objArr33 = new Object[1];
                    c((short) 495, bArr10[20], bArr10[140], objArr33);
                    cls9.getMethod((String) objArr33[0], Long.TYPE, Long.TYPE).invoke(null, objArr31);
                    Object[] objArr34 = {strArr, new int[1], new int[]{i}, new int[]{i}};
                    int i51 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
                    int i52 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
                    int i53 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
                    String[] strArr8 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
                    int iFreeMemory = (int) Runtime.getRuntime().freeMemory();
                    int i54 = i51 + (((~(791141755 | iFreeMemory)) | (-484998914)) * 262) + 62451990 + (((~((~iFreeMemory) | 791141755)) | (-484998914)) * 262);
                    int i55 = (i54 << 13) ^ i54;
                    int i56 = i55 ^ (i55 >>> 17);
                    ((int[]) objArr34[1])[0] = i56 ^ (i56 << 5);
                    return;
                }
                super.attachBaseContext(context);
                Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                if (objAccessartificialFrame8 == null) {
                    int modifierMetaStateMask = 24 - ((byte) KeyEvent.getModifierMetaStateMask());
                    char scrollDefaultDelay2 = (char) (30068 - (ViewConfiguration.getScrollDefaultDelay() >> 16));
                    int jumpTapTimeout = 816 - (ViewConfiguration.getJumpTapTimeout() >> 16);
                    byte[] bArr11 = $$a;
                    Object[] objArr35 = new Object[1];
                    b((byte) 75, (byte) (bArr11[12] - 1), bArr11[48], objArr35);
                    objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(modifierMetaStateMask, scrollDefaultDelay2, jumpTapTimeout, 721586079, false, (String) objArr35[0], null);
                }
                j = ((Field) objAccessartificialFrame8).getLong(null);
                int i57 = 66 / 0;
                if (j != -1) {
                    j2 = j + 2046;
                    Object[] objArr36 = new Object[1];
                    a(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length(), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(3) + 67, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) - 27, new char[]{0, '\f', '\t', 65504, '\n', 2, 17, 16, 22, 65520, 65483, 16, '\f', 65483, 1, 6, '\f', 15, 1, 11, 65534, '\b'}, objArr36);
                    cls = Class.forName((String) objArr36[0]);
                    objArr = new Object[1];
                    a(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) - 23, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 182, ExpandableListView.getPackedPositionType(0L) + 15, new char[]{2, CharUtils.CR, 5, 65530, 65534, 65515, 65533, 65534, '\f', '\t', 65530, 5, 65534, 65534, 6}, objArr);
                    if (j2 >= ((Long) cls.getDeclaredMethod((String) objArr[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                        objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1438542923);
                        if (objAccessartificialFrame == null) {
                            int packedPositionType2 = 25 - ExpandableListView.getPackedPositionType(0L);
                            char c3 = (char) (30068 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)));
                            int scrollDefaultDelay3 = (ViewConfiguration.getScrollDefaultDelay() >> 16) + 816;
                            byte[] bArr12 = $$a;
                            Object[] objArr37 = new Object[1];
                            b((byte) 67, (byte) (bArr12[12] - 1), bArr12[48], objArr37);
                            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(packedPositionType2, c3, scrollDefaultDelay3, 891606461, false, (String) objArr37[0], null);
                        }
                        Object[] objArr38 = (Object[]) ((Field) objAccessartificialFrame).get(null);
                        objArr2 = new Object[]{new int[]{i11}, new int[]{i12}, strArr3, new int[1]};
                        int i110 = ((int[]) objArr38[0])[0];
                        int i111 = ((int[]) objArr38[1])[0];
                        String[] strArr9 = (String[]) objArr38[2];
                        int i112 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().uiMode;
                        int i113 = ((((-1314985495) + ((~((~i112) | 131063485)) * (-116))) + ((130028216 | i112) * 116)) + (((~(i112 | (-68144150))) | 67108880) * 116)) - 1377568488;
                        int i114 = (i113 << 13) ^ i113;
                        int i115 = i114 ^ (i114 >>> 17);
                        ((int[]) objArr2[3])[0] = i115 ^ (i115 << 5);
                    }
                }
                i = ((int[]) objArr2[1])[0];
                i2 = ((int[]) objArr2[0])[0];
                if (i2 == i) {
                    Object[] objArr39 = {new int[]{i18}, new int[]{i19}, strArr4, new int[1]};
                    int i116 = ((int[]) objArr2[3])[0];
                    int i117 = ((int[]) objArr2[0])[0];
                    int i118 = ((int[]) objArr2[1])[0];
                    String[] strArr10 = (String[]) objArr2[2];
                    int iMyTid4 = Process.myTid();
                    int i210 = ~iMyTid4;
                    int i211 = i116 + (-405470199) + (((~(324092019 | i210)) | (-522264386) | (~((-324092020) | iMyTid4))) * (-564)) + ((~(iMyTid4 | (-318832706))) * 1128) + (((~((-522264386) | i210)) | 5259314) * 564);
                    int i212 = (i211 << 13) ^ i211;
                    int i213 = i212 ^ (i212 >>> 17);
                    ((int[]) objArr39[3])[0] = i213 ^ (i213 << 5);
                } else {
                    arrayList = new ArrayList();
                    strArr = (String[]) objArr2[2];
                    if (strArr != null) {
                        i3 = artificialFrame + 107;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i3 % 128;
                        if (i3 % 2 != 0) {
                            i4 = 1;
                        } else {
                            i4 = 0;
                        }
                        while (i4 < strArr.length) {
                            i5 = artificialFrame + 79;
                            getARTIFICIAL_FRAME_PACKAGE_NAME = i5 % 128;
                            if (i5 % 2 != 0) {
                                arrayList.add(strArr[i4]);
                                i4 += 47;
                            } else {
                                arrayList.add(strArr[i4]);
                                i4++;
                            }
                        }
                    }
                    try {
                        Object[] objArr112 = {Long.valueOf(((long) (i ^ i2)) ^ (((long) 1159195888) << 32)), Long.valueOf(1159195889)};
                        byte[] bArr13 = $$d;
                        short s2 = bArr13[45];
                        Object[] objArr113 = new Object[1];
                        c(s2, (byte) s2, bArr13[42], objArr113);
                        Class<?> cls10 = Class.forName((String) objArr113[0]);
                        Object[] objArr114 = new Object[1];
                        c((short) 495, bArr13[20], bArr13[140], objArr114);
                        cls10.getMethod((String) objArr114[0], Long.TYPE, Long.TYPE).invoke(null, objArr112);
                        Object[] objArr115 = {new int[]{i25}, new int[]{i26}, strArr5, new int[1]};
                        int i214 = ((int[]) objArr2[3])[0];
                        int i215 = ((int[]) objArr2[0])[0];
                        int i216 = ((int[]) objArr2[1])[0];
                        String[] strArr11 = (String[]) objArr2[2];
                        int elapsedCpuTime2 = (int) Process.getElapsedCpuTime();
                        int i217 = i214 + ((~((~elapsedCpuTime2) | 536410095)) * 130) + 260297963 + (((~(elapsedCpuTime2 | 536410095)) | 304664737) * 130);
                        int i218 = (i217 << 13) ^ i217;
                        int i219 = i218 ^ (i218 >>> 17);
                        ((int[]) objArr115[3])[0] = i219 ^ (i219 << 5);
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause == null) {
                            throw th;
                        }
                        throw cause;
                    }
                }
                objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-444530678);
                if (objAccessartificialFrame2 == null) {
                    int iIndexOf3 = TextUtils.indexOf("", "") + 26;
                    char cGreen2 = (char) Color.green(0);
                    int iKeyCodeFromString2 = KeyEvent.keyCodeFromString("") + 1041;
                    byte[] bArr14 = $$a;
                    Object[] objArr116 = new Object[1];
                    b((byte) 75, (byte) (bArr14[12] - 1), bArr14[48], objArr116);
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iIndexOf3, cGreen2, iKeyCodeFromString2, 2061780482, false, (String) objArr116[0], null);
                }
                j3 = ((Field) objAccessartificialFrame2).getLong(null);
                if (j3 != -1) {
                    int i310 = artificialFrame + 3;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i310 % 128;
                    int i311 = i310 % 2;
                    j4 = j3 + 1888;
                    Object[] objArr117 = new Object[1];
                    a(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(3) - 25, (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 181, 22 - KeyEvent.normalizeMetaState(0), new char[]{0, '\f', '\t', 65504, '\n', 2, 17, 16, 22, 65520, 65483, 16, '\f', 65483, 1, 6, '\f', 15, 1, 11, 65534, '\b'}, objArr117);
                    cls2 = Class.forName((String) objArr117[0]);
                    objArr3 = new Object[1];
                    a(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 8, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 182, KeyEvent.normalizeMetaState(0) + 15, new char[]{2, CharUtils.CR, 5, 65530, 65534, 65515, 65533, 65534, '\f', '\t', 65530, 5, 65534, 65534, 6}, objArr3);
                    if (j4 >= ((Long) cls2.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                        objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-614804952);
                        if (objAccessartificialFrame6 == null) {
                            int i312 = (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 25;
                            char cRgb2 = (char) (ViewCompat.MEASURED_STATE_MASK - Color.rgb(0, 0, 0));
                            int iIndexOf4 = 1040 - TextUtils.indexOf((CharSequence) "", '0', 0, 0);
                            byte[] bArr15 = $$a;
                            byte b4 = (byte) (bArr15[12] - 1);
                            byte b5 = bArr15[48];
                            Object[] objArr118 = new Object[1];
                            b((byte) 67, b4, b5, objArr118);
                            objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(i312, cRgb2, iIndexOf4, 1145017376, false, (String) objArr118[0], null);
                        }
                        Object[] objArr119 = (Object[]) ((Field) objAccessartificialFrame6).get(null);
                        objArrAccessartificialFrame$78cbbd35 = new Object[]{strArr6, new int[1], new int[]{i34}, new int[]{i33}};
                        int i313 = ((int[]) objArr119[3])[0];
                        int i314 = ((int[]) objArr119[2])[0];
                        String[] strArr12 = (String[]) objArr119[0];
                        int iIdentityHashCode2 = System.identityHashCode(this);
                        int i315 = (-421906180) + (((-262229) | iIdentityHashCode2) * (-381)) + (((~((~iIdentityHashCode2) | 60941482)) | (-44303615)) * 381) + 101711641;
                        int i316 = (i315 << 13) ^ i315;
                        int i317 = i316 ^ (i316 >>> 17);
                        ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0] = i317 ^ (i317 << 5);
                    } else {
                        Object[] objArr1110 = new Object[1];
                        a(true, (ViewConfiguration.getScrollDefaultDelay() >> 16) + 16, (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + RotationOptions.ROTATE_180, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 19, new char[]{11, 3, 18, 17, 23, 65521, 65484, 5, '\f', 65535, '\n', 65484, 65535, 20, 65535, '\b'}, objArr1110);
                        Class<?> cls11 = Class.forName((String) objArr1110[0]);
                        Object[] objArr1111 = new Object[1];
                        a(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(3) - 102, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) + 149, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) - 20, new char[]{65501, 2, CharUtils.CR, 65531, 65506, 19, 14, 3, 14, '\b', 65535, 65534, 3, 65535, 65534, '\t'}, objArr1111);
                        int iIntValue3 = ((Integer) cls11.getMethod((String) objArr1111[0], Object.class).invoke(null, this)).intValue();
                        Object[] objArr210 = {1908628746};
                        objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1648942878);
                        if (objAccessartificialFrame3 == null) {
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(8 - View.MeasureSpec.getMode(0), (char) (ExpandableListView.getPackedPositionType(0L) + 22251), 1033 - (Process.myTid() >> 22), 47343338, false, null, new Class[]{Integer.TYPE});
                        }
                        objArrAccessartificialFrame$78cbbd35 = FocusedInputObserver.accessartificialFrame$78cbbd35(iIntValue3, 0, ((Constructor) objAccessartificialFrame3).newInstance(objArr210), 1802773, false);
                        objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-614804952);
                        if (objAccessartificialFrame4 == null) {
                            int iGreen3 = 26 - Color.green(0);
                            char doubleTapTimeout3 = (char) (ViewConfiguration.getDoubleTapTimeout() >> 16);
                            int iMyTid5 = 1041 - (Process.myTid() >> 22);
                            byte[] bArr16 = $$a;
                            Object[] objArr211 = new Object[1];
                            b((byte) 67, (byte) (bArr16[12] - 1), bArr16[48], objArr211);
                            objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(iGreen3, doubleTapTimeout3, iMyTid5, 1145017376, false, (String) objArr211[0], null);
                        }
                        ((Field) objAccessartificialFrame4).set(null, objArrAccessartificialFrame$78cbbd35);
                        try {
                            Object[] objArr212 = new Object[1];
                            a(true, View.getDefaultSize(0, 0) + 21, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 147, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) - 14, new char[]{0, '\f', '\t', 65504, '\n', 2, 17, 16, 22, 65520, 65483, 16, '\f', 65483, 1, 6, '\f', 15, 1, 11, 65534, '\b'}, objArr212);
                            Class<?> cls12 = Class.forName((String) objArr212[0]);
                            Object[] objArr213 = new Object[1];
                            a(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(0) - 24, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 151, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(3) - 100, new char[]{2, CharUtils.CR, 5, 65530, 65534, 65515, 65533, 65534, '\f', '\t', 65530, 5, 65534, 65534, 6}, objArr213);
                            Long lValueOf3 = Long.valueOf(((Long) cls12.getDeclaredMethod((String) objArr213[0], new Class[0]).invoke(null, new Object[0])).longValue());
                            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-444530678);
                            if (objAccessartificialFrame5 == null) {
                                int iMyPid3 = 26 - (Process.myPid() >> 22);
                                char cNormalizeMetaState3 = (char) KeyEvent.normalizeMetaState(0);
                                int scrollBarFadeDuration4 = 1041 - (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                                byte[] bArr17 = $$a;
                                Object[] objArr214 = new Object[1];
                                b((byte) 75, (byte) (bArr17[12] - 1), bArr17[48], objArr214);
                                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(iMyPid3, cNormalizeMetaState3, scrollBarFadeDuration4, 2061780482, false, (String) objArr214[0], null);
                            }
                            ((Field) objAccessartificialFrame5).set(null, lValueOf3);
                        } catch (Exception unused) {
                            throw new RuntimeException();
                        }
                    }
                } else {
                    Object[] objArr1112 = new Object[1];
                    a(true, (ViewConfiguration.getScrollDefaultDelay() >> 16) + 16, (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + RotationOptions.ROTATE_180, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 19, new char[]{11, 3, 18, 17, 23, 65521, 65484, 5, '\f', 65535, '\n', 65484, 65535, 20, 65535, '\b'}, objArr1112);
                    Class<?> cls13 = Class.forName((String) objArr1112[0]);
                    Object[] objArr1113 = new Object[1];
                    a(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(3) - 102, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) + 149, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) - 20, new char[]{65501, 2, CharUtils.CR, 65531, 65506, 19, 14, 3, 14, '\b', 65535, 65534, 3, 65535, 65534, '\t'}, objArr1113);
                    int iIntValue4 = ((Integer) cls13.getMethod((String) objArr1113[0], Object.class).invoke(null, this)).intValue();
                    Object[] objArr215 = {1908628746};
                    objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1648942878);
                    if (objAccessartificialFrame3 == null) {
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(8 - View.MeasureSpec.getMode(0), (char) (ExpandableListView.getPackedPositionType(0L) + 22251), 1033 - (Process.myTid() >> 22), 47343338, false, null, new Class[]{Integer.TYPE});
                    }
                    objArrAccessartificialFrame$78cbbd35 = FocusedInputObserver.accessartificialFrame$78cbbd35(iIntValue4, 0, ((Constructor) objAccessartificialFrame3).newInstance(objArr215), 1802773, false);
                    objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-614804952);
                    if (objAccessartificialFrame4 == null) {
                        int iGreen4 = 26 - Color.green(0);
                        char doubleTapTimeout4 = (char) (ViewConfiguration.getDoubleTapTimeout() >> 16);
                        int iMyTid6 = 1041 - (Process.myTid() >> 22);
                        byte[] bArr18 = $$a;
                        Object[] objArr216 = new Object[1];
                        b((byte) 67, (byte) (bArr18[12] - 1), bArr18[48], objArr216);
                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(iGreen4, doubleTapTimeout4, iMyTid6, 1145017376, false, (String) objArr216[0], null);
                    }
                    ((Field) objAccessartificialFrame4).set(null, objArrAccessartificialFrame$78cbbd35);
                    Object[] objArr217 = new Object[1];
                    a(true, View.getDefaultSize(0, 0) + 21, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 147, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) - 14, new char[]{0, '\f', '\t', 65504, '\n', 2, 17, 16, 22, 65520, 65483, 16, '\f', 65483, 1, 6, '\f', 15, 1, 11, 65534, '\b'}, objArr217);
                    Class<?> cls14 = Class.forName((String) objArr217[0]);
                    Object[] objArr218 = new Object[1];
                    a(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(0) - 24, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 151, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(3) - 100, new char[]{2, CharUtils.CR, 5, 65530, 65534, 65515, 65533, 65534, '\f', '\t', 65530, 5, 65534, 65534, 6}, objArr218);
                    Long lValueOf4 = Long.valueOf(((Long) cls14.getDeclaredMethod((String) objArr218[0], new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-444530678);
                    if (objAccessartificialFrame5 == null) {
                        int iMyPid4 = 26 - (Process.myPid() >> 22);
                        char cNormalizeMetaState4 = (char) KeyEvent.normalizeMetaState(0);
                        int scrollBarFadeDuration5 = 1041 - (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                        byte[] bArr19 = $$a;
                        Object[] objArr219 = new Object[1];
                        b((byte) 75, (byte) (bArr19[12] - 1), bArr19[48], objArr219);
                        objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(iMyPid4, cNormalizeMetaState4, scrollBarFadeDuration5, 2061780482, false, (String) objArr219[0], null);
                    }
                    ((Field) objAccessartificialFrame5).set(null, lValueOf4);
                }
                i6 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
                i7 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
                if (i7 == i6) {
                    int i318 = artificialFrame + 71;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i318 % 128;
                    int i319 = i318 % 2;
                    Object[] objArr310 = {strArr7, new int[1], new int[]{i42}, new int[]{i41}};
                    int i410 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
                    int i411 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
                    int i412 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
                    String[] strArr13 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
                    int iUptimeMillis2 = (int) SystemClock.uptimeMillis();
                    int i413 = i410 + 775843822 + ((483982599 | iUptimeMillis2) * 376) + (((~((~iUptimeMillis2) | 870474515)) | 202939396) * (-376)) + (((~(iUptimeMillis2 | (-870474516))) | (-792370709)) * 376);
                    int i414 = (i413 << 13) ^ i413;
                    int i415 = i414 ^ (i414 >>> 17);
                    ((int[]) objArr310[1])[0] = i415 ^ (i415 << 5);
                    return;
                }
                arrayList2 = new ArrayList();
                strArr2 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
                if (strArr2 != null) {
                    while (i8 < strArr2.length) {
                        arrayList2.add(str);
                    }
                }
                long j7 = ((long) (i6 ^ i7)) ^ (((long) 1306091625) << 32);
                long j8 = 1306091627;
                int i416 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                int i417 = i416 + b.f40o;
                artificialFrame = i417 % 128;
                int i418 = i417 % 2;
                int i419 = i416 + 29;
                artificialFrame = i419 % 128;
                int i58 = i419 % 2;
                Object[] objArr311 = {Long.valueOf(j7), Long.valueOf(j8)};
                byte[] bArr110 = $$d;
                byte b6 = bArr110[120];
                Object[] objArr312 = new Object[1];
                c(b6, (byte) (-bArr110[110]), b6, objArr312);
                Class<?> cls15 = Class.forName((String) objArr312[0]);
                Object[] objArr313 = new Object[1];
                c((short) 495, bArr110[20], bArr110[140], objArr313);
                cls15.getMethod((String) objArr313[0], Long.TYPE, Long.TYPE).invoke(null, objArr311);
                Object[] objArr314 = {strArr8, new int[1], new int[]{i53}, new int[]{i52}};
                int i59 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
                int i510 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
                int i511 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
                String[] strArr14 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
                int iFreeMemory2 = (int) Runtime.getRuntime().freeMemory();
                int i512 = i59 + (((~(791141755 | iFreeMemory2)) | (-484998914)) * 262) + 62451990 + (((~((~iFreeMemory2) | 791141755)) | (-484998914)) * 262);
                int i513 = (i512 << 13) ^ i512;
                int i514 = i513 ^ (i513 >>> 17);
                ((int[]) objArr314[1])[0] = i514 ^ (i514 << 5);
                return;
                Object[] objArr40 = new Object[1];
                a(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 17, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 178, KeyEvent.getDeadChar(0, 0) + 22, new char[]{0, '\f', '\t', 65504, '\n', 2, 17, 16, 22, 65520, 65483, 16, '\f', 65483, 1, 6, '\f', 15, 1, 11, 65534, '\b'}, objArr40);
                Class<?> cls16 = Class.forName((String) objArr40[0]);
                Object[] objArr41 = new Object[1];
                a(true, '=' - AndroidCharacter.getMirror('0'), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) + 137, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) - 21, new char[]{2, CharUtils.CR, 5, 65530, 65534, 65515, 65533, 65534, '\f', '\t', 65530, 5, 65534, 65534, 6}, objArr41);
                Long lValueOf5 = Long.valueOf(((Long) cls16.getDeclaredMethod((String) objArr41[0], new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                if (objAccessartificialFrame9 == null) {
                    int i60 = (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 25;
                    char cRed = (char) (Color.red(0) + 30068);
                    int i61 = (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 815;
                    byte[] bArr20 = $$a;
                    Object[] objArr42 = new Object[1];
                    b((byte) 75, (byte) (bArr20[12] - 1), bArr20[48], objArr42);
                    objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(i60, cRed, i61, 721586079, false, (String) objArr42[0], null);
                }
                ((Field) objAccessartificialFrame9).set(null, lValueOf5);
                i = ((int[]) objArr2[1])[0];
                i2 = ((int[]) objArr2[0])[0];
                if (i2 == i) {
                    Object[] objArr315 = {new int[]{i117}, new int[]{i118}, strArr10, new int[1]};
                    int i119 = ((int[]) objArr2[3])[0];
                    int i1110 = ((int[]) objArr2[0])[0];
                    int i1111 = ((int[]) objArr2[1])[0];
                    String[] strArr15 = (String[]) objArr2[2];
                    int iMyTid7 = Process.myTid();
                    int i2110 = ~iMyTid7;
                    int i2111 = i119 + (-405470199) + (((~(324092019 | i2110)) | (-522264386) | (~((-324092020) | iMyTid7))) * (-564)) + ((~(iMyTid7 | (-318832706))) * 1128) + (((~((-522264386) | i2110)) | 5259314) * 564);
                    int i2112 = (i2111 << 13) ^ i2111;
                    int i2113 = i2112 ^ (i2112 >>> 17);
                    ((int[]) objArr315[3])[0] = i2113 ^ (i2113 << 5);
                } else {
                    arrayList = new ArrayList();
                    strArr = (String[]) objArr2[2];
                    if (strArr != null) {
                        i3 = artificialFrame + 107;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i3 % 128;
                        if (i3 % 2 != 0) {
                            i4 = 1;
                        } else {
                            i4 = 0;
                        }
                        while (i4 < strArr.length) {
                            i5 = artificialFrame + 79;
                            getARTIFICIAL_FRAME_PACKAGE_NAME = i5 % 128;
                            if (i5 % 2 != 0) {
                                arrayList.add(strArr[i4]);
                                i4 += 47;
                            } else {
                                arrayList.add(strArr[i4]);
                                i4++;
                            }
                        }
                    }
                    Object[] objArr1114 = {Long.valueOf(((long) (i ^ i2)) ^ (((long) 1159195888) << 32)), Long.valueOf(1159195889)};
                    byte[] bArr111 = $$d;
                    short s3 = bArr111[45];
                    Object[] objArr1115 = new Object[1];
                    c(s3, (byte) s3, bArr111[42], objArr1115);
                    Class<?> cls17 = Class.forName((String) objArr1115[0]);
                    Object[] objArr1116 = new Object[1];
                    c((short) 495, bArr111[20], bArr111[140], objArr1116);
                    cls17.getMethod((String) objArr1116[0], Long.TYPE, Long.TYPE).invoke(null, objArr1114);
                    Object[] objArr1117 = {new int[]{i215}, new int[]{i216}, strArr11, new int[1]};
                    int i2114 = ((int[]) objArr2[3])[0];
                    int i2115 = ((int[]) objArr2[0])[0];
                    int i2116 = ((int[]) objArr2[1])[0];
                    String[] strArr16 = (String[]) objArr2[2];
                    int elapsedCpuTime3 = (int) Process.getElapsedCpuTime();
                    int i2117 = i2114 + ((~((~elapsedCpuTime3) | 536410095)) * 130) + 260297963 + (((~(elapsedCpuTime3 | 536410095)) | 304664737) * 130);
                    int i2118 = (i2117 << 13) ^ i2117;
                    int i2119 = i2118 ^ (i2118 >>> 17);
                    ((int[]) objArr1117[3])[0] = i2119 ^ (i2119 << 5);
                }
                objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-444530678);
                if (objAccessartificialFrame2 == null) {
                    int iIndexOf5 = TextUtils.indexOf("", "") + 26;
                    char cGreen3 = (char) Color.green(0);
                    int iKeyCodeFromString3 = KeyEvent.keyCodeFromString("") + 1041;
                    byte[] bArr112 = $$a;
                    Object[] objArr1118 = new Object[1];
                    b((byte) 75, (byte) (bArr112[12] - 1), bArr112[48], objArr1118);
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iIndexOf5, cGreen3, iKeyCodeFromString3, 2061780482, false, (String) objArr1118[0], null);
                }
                j3 = ((Field) objAccessartificialFrame2).getLong(null);
                if (j3 != -1) {
                    int i3110 = artificialFrame + 3;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i3110 % 128;
                    int i3111 = i3110 % 2;
                    j4 = j3 + 1888;
                    Object[] objArr1119 = new Object[1];
                    a(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(3) - 25, (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 181, 22 - KeyEvent.normalizeMetaState(0), new char[]{0, '\f', '\t', 65504, '\n', 2, 17, 16, 22, 65520, 65483, 16, '\f', 65483, 1, 6, '\f', 15, 1, 11, 65534, '\b'}, objArr1119);
                    cls2 = Class.forName((String) objArr1119[0]);
                    objArr3 = new Object[1];
                    a(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 8, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 182, KeyEvent.normalizeMetaState(0) + 15, new char[]{2, CharUtils.CR, 5, 65530, 65534, 65515, 65533, 65534, '\f', '\t', 65530, 5, 65534, 65534, 6}, objArr3);
                    if (j4 >= ((Long) cls2.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                        objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-614804952);
                        if (objAccessartificialFrame6 == null) {
                            int i3112 = (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 25;
                            char cRgb3 = (char) (ViewCompat.MEASURED_STATE_MASK - Color.rgb(0, 0, 0));
                            int iIndexOf6 = 1040 - TextUtils.indexOf((CharSequence) "", '0', 0, 0);
                            byte[] bArr113 = $$a;
                            byte b7 = (byte) (bArr113[12] - 1);
                            byte b8 = bArr113[48];
                            Object[] objArr1120 = new Object[1];
                            b((byte) 67, b7, b8, objArr1120);
                            objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(i3112, cRgb3, iIndexOf6, 1145017376, false, (String) objArr1120[0], null);
                        }
                        Object[] objArr1121 = (Object[]) ((Field) objAccessartificialFrame6).get(null);
                        objArrAccessartificialFrame$78cbbd35 = new Object[]{strArr12, new int[1], new int[]{i314}, new int[]{i313}};
                        int i3113 = ((int[]) objArr1121[3])[0];
                        int i3114 = ((int[]) objArr1121[2])[0];
                        String[] strArr17 = (String[]) objArr1121[0];
                        int iIdentityHashCode3 = System.identityHashCode(this);
                        int i3115 = (-421906180) + (((-262229) | iIdentityHashCode3) * (-381)) + (((~((~iIdentityHashCode3) | 60941482)) | (-44303615)) * 381) + 101711641;
                        int i3116 = (i3115 << 13) ^ i3115;
                        int i3117 = i3116 ^ (i3116 >>> 17);
                        ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0] = i3117 ^ (i3117 << 5);
                    } else {
                        Object[] objArr11110 = new Object[1];
                        a(true, (ViewConfiguration.getScrollDefaultDelay() >> 16) + 16, (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + RotationOptions.ROTATE_180, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 19, new char[]{11, 3, 18, 17, 23, 65521, 65484, 5, '\f', 65535, '\n', 65484, 65535, 20, 65535, '\b'}, objArr11110);
                        Class<?> cls18 = Class.forName((String) objArr11110[0]);
                        Object[] objArr11111 = new Object[1];
                        a(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(3) - 102, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) + 149, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) - 20, new char[]{65501, 2, CharUtils.CR, 65531, 65506, 19, 14, 3, 14, '\b', 65535, 65534, 3, 65535, 65534, '\t'}, objArr11111);
                        int iIntValue5 = ((Integer) cls18.getMethod((String) objArr11111[0], Object.class).invoke(null, this)).intValue();
                        Object[] objArr2110 = {1908628746};
                        objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1648942878);
                        if (objAccessartificialFrame3 == null) {
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(8 - View.MeasureSpec.getMode(0), (char) (ExpandableListView.getPackedPositionType(0L) + 22251), 1033 - (Process.myTid() >> 22), 47343338, false, null, new Class[]{Integer.TYPE});
                        }
                        objArrAccessartificialFrame$78cbbd35 = FocusedInputObserver.accessartificialFrame$78cbbd35(iIntValue5, 0, ((Constructor) objAccessartificialFrame3).newInstance(objArr2110), 1802773, false);
                        objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-614804952);
                        if (objAccessartificialFrame4 == null) {
                            int iGreen5 = 26 - Color.green(0);
                            char doubleTapTimeout5 = (char) (ViewConfiguration.getDoubleTapTimeout() >> 16);
                            int iMyTid8 = 1041 - (Process.myTid() >> 22);
                            byte[] bArr114 = $$a;
                            Object[] objArr2111 = new Object[1];
                            b((byte) 67, (byte) (bArr114[12] - 1), bArr114[48], objArr2111);
                            objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(iGreen5, doubleTapTimeout5, iMyTid8, 1145017376, false, (String) objArr2111[0], null);
                        }
                        ((Field) objAccessartificialFrame4).set(null, objArrAccessartificialFrame$78cbbd35);
                        Object[] objArr2112 = new Object[1];
                        a(true, View.getDefaultSize(0, 0) + 21, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 147, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) - 14, new char[]{0, '\f', '\t', 65504, '\n', 2, 17, 16, 22, 65520, 65483, 16, '\f', 65483, 1, 6, '\f', 15, 1, 11, 65534, '\b'}, objArr2112);
                        Class<?> cls19 = Class.forName((String) objArr2112[0]);
                        Object[] objArr2113 = new Object[1];
                        a(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(0) - 24, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 151, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(3) - 100, new char[]{2, CharUtils.CR, 5, 65530, 65534, 65515, 65533, 65534, '\f', '\t', 65530, 5, 65534, 65534, 6}, objArr2113);
                        Long lValueOf6 = Long.valueOf(((Long) cls19.getDeclaredMethod((String) objArr2113[0], new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-444530678);
                        if (objAccessartificialFrame5 == null) {
                            int iMyPid5 = 26 - (Process.myPid() >> 22);
                            char cNormalizeMetaState5 = (char) KeyEvent.normalizeMetaState(0);
                            int scrollBarFadeDuration6 = 1041 - (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                            byte[] bArr115 = $$a;
                            Object[] objArr2114 = new Object[1];
                            b((byte) 75, (byte) (bArr115[12] - 1), bArr115[48], objArr2114);
                            objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(iMyPid5, cNormalizeMetaState5, scrollBarFadeDuration6, 2061780482, false, (String) objArr2114[0], null);
                        }
                        ((Field) objAccessartificialFrame5).set(null, lValueOf6);
                    }
                } else {
                    Object[] objArr11112 = new Object[1];
                    a(true, (ViewConfiguration.getScrollDefaultDelay() >> 16) + 16, (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + RotationOptions.ROTATE_180, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 19, new char[]{11, 3, 18, 17, 23, 65521, 65484, 5, '\f', 65535, '\n', 65484, 65535, 20, 65535, '\b'}, objArr11112);
                    Class<?> cls110 = Class.forName((String) objArr11112[0]);
                    Object[] objArr11113 = new Object[1];
                    a(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(3) - 102, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) + 149, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) - 20, new char[]{65501, 2, CharUtils.CR, 65531, 65506, 19, 14, 3, 14, '\b', 65535, 65534, 3, 65535, 65534, '\t'}, objArr11113);
                    int iIntValue6 = ((Integer) cls110.getMethod((String) objArr11113[0], Object.class).invoke(null, this)).intValue();
                    Object[] objArr2115 = {1908628746};
                    objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1648942878);
                    if (objAccessartificialFrame3 == null) {
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(8 - View.MeasureSpec.getMode(0), (char) (ExpandableListView.getPackedPositionType(0L) + 22251), 1033 - (Process.myTid() >> 22), 47343338, false, null, new Class[]{Integer.TYPE});
                    }
                    objArrAccessartificialFrame$78cbbd35 = FocusedInputObserver.accessartificialFrame$78cbbd35(iIntValue6, 0, ((Constructor) objAccessartificialFrame3).newInstance(objArr2115), 1802773, false);
                    objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-614804952);
                    if (objAccessartificialFrame4 == null) {
                        int iGreen6 = 26 - Color.green(0);
                        char doubleTapTimeout6 = (char) (ViewConfiguration.getDoubleTapTimeout() >> 16);
                        int iMyTid9 = 1041 - (Process.myTid() >> 22);
                        byte[] bArr116 = $$a;
                        Object[] objArr2116 = new Object[1];
                        b((byte) 67, (byte) (bArr116[12] - 1), bArr116[48], objArr2116);
                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(iGreen6, doubleTapTimeout6, iMyTid9, 1145017376, false, (String) objArr2116[0], null);
                    }
                    ((Field) objAccessartificialFrame4).set(null, objArrAccessartificialFrame$78cbbd35);
                    Object[] objArr2117 = new Object[1];
                    a(true, View.getDefaultSize(0, 0) + 21, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 147, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) - 14, new char[]{0, '\f', '\t', 65504, '\n', 2, 17, 16, 22, 65520, 65483, 16, '\f', 65483, 1, 6, '\f', 15, 1, 11, 65534, '\b'}, objArr2117);
                    Class<?> cls111 = Class.forName((String) objArr2117[0]);
                    Object[] objArr2118 = new Object[1];
                    a(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(0) - 24, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 151, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(3) - 100, new char[]{2, CharUtils.CR, 5, 65530, 65534, 65515, 65533, 65534, '\f', '\t', 65530, 5, 65534, 65534, 6}, objArr2118);
                    Long lValueOf7 = Long.valueOf(((Long) cls111.getDeclaredMethod((String) objArr2118[0], new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-444530678);
                    if (objAccessartificialFrame5 == null) {
                        int iMyPid6 = 26 - (Process.myPid() >> 22);
                        char cNormalizeMetaState6 = (char) KeyEvent.normalizeMetaState(0);
                        int scrollBarFadeDuration7 = 1041 - (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                        byte[] bArr117 = $$a;
                        Object[] objArr2119 = new Object[1];
                        b((byte) 75, (byte) (bArr117[12] - 1), bArr117[48], objArr2119);
                        objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(iMyPid6, cNormalizeMetaState6, scrollBarFadeDuration7, 2061780482, false, (String) objArr2119[0], null);
                    }
                    ((Field) objAccessartificialFrame5).set(null, lValueOf7);
                }
                i6 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
                i7 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
                if (i7 == i6) {
                    int i3118 = artificialFrame + 71;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i3118 % 128;
                    int i3119 = i3118 % 2;
                    Object[] objArr316 = {strArr13, new int[1], new int[]{i412}, new int[]{i411}};
                    int i4110 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
                    int i4111 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
                    int i4112 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
                    String[] strArr18 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
                    int iUptimeMillis3 = (int) SystemClock.uptimeMillis();
                    int i4113 = i4110 + 775843822 + ((483982599 | iUptimeMillis3) * 376) + (((~((~iUptimeMillis3) | 870474515)) | 202939396) * (-376)) + (((~(iUptimeMillis3 | (-870474516))) | (-792370709)) * 376);
                    int i4114 = (i4113 << 13) ^ i4113;
                    int i4115 = i4114 ^ (i4114 >>> 17);
                    ((int[]) objArr316[1])[0] = i4115 ^ (i4115 << 5);
                    return;
                }
                arrayList2 = new ArrayList();
                strArr2 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
                if (strArr2 != null) {
                    while (i8 < strArr2.length) {
                        arrayList2.add(str);
                    }
                }
                long j9 = ((long) (i6 ^ i7)) ^ (((long) 1306091625) << 32);
                long j10 = 1306091627;
                int i4116 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                int i4117 = i4116 + b.f40o;
                artificialFrame = i4117 % 128;
                int i4118 = i4117 % 2;
                int i4119 = i4116 + 29;
                artificialFrame = i4119 % 128;
                int i515 = i4119 % 2;
                Object[] objArr317 = {Long.valueOf(j9), Long.valueOf(j10)};
                byte[] bArr118 = $$d;
                byte b9 = bArr118[120];
                Object[] objArr318 = new Object[1];
                c(b9, (byte) (-bArr118[110]), b9, objArr318);
                Class<?> cls112 = Class.forName((String) objArr318[0]);
                Object[] objArr319 = new Object[1];
                c((short) 495, bArr118[20], bArr118[140], objArr319);
                cls112.getMethod((String) objArr319[0], Long.TYPE, Long.TYPE).invoke(null, objArr317);
                Object[] objArr3110 = {strArr14, new int[1], new int[]{i511}, new int[]{i510}};
                int i516 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
                int i517 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
                int i518 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
                String[] strArr19 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
                int iFreeMemory3 = (int) Runtime.getRuntime().freeMemory();
                int i519 = i516 + (((~(791141755 | iFreeMemory3)) | (-484998914)) * 262) + 62451990 + (((~((~iFreeMemory3) | 791141755)) | (-484998914)) * 262);
                int i5110 = (i519 << 13) ^ i519;
                int i5111 = i5110 ^ (i5110 >>> 17);
                ((int[]) objArr3110[1])[0] = i5111 ^ (i5111 << 5);
                return;
            } catch (Exception unused2) {
                throw new RuntimeException();
            }
            Object[] objArr43 = {Integer.valueOf(((Integer) cls3.getMethod((String) objArr4[0], Object.class).invoke(null, this)).intValue()), 0, -1377568488};
            Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(1327366003);
            if (objAccessartificialFrame10 == null) {
                int size = View.MeasureSpec.getSize(0) + 25;
                char mirror = (char) (AndroidCharacter.getMirror('0') + 30020);
                int i62 = 817 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1));
                byte[] bArr21 = $$a;
                byte b10 = (byte) (bArr21[12] - 1);
                Object[] objArr44 = new Object[1];
                b(b10, (byte) (b10 | Ascii.FS), bArr21[4], objArr44);
                objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(size, mirror, i62, -797394565, false, (String) objArr44[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            }
            objArr2 = (Object[]) ((Method) objAccessartificialFrame10).invoke(null, objArr43);
            Object objAccessartificialFrame11 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame11 == null) {
                int offsetBefore = TextUtils.getOffsetBefore("", 0) + 25;
                char fadingEdgeLength = (char) (30068 - (ViewConfiguration.getFadingEdgeLength() >> 16));
                int i63 = 817 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1));
                byte[] bArr22 = $$a;
                Object[] objArr45 = new Object[1];
                b((byte) 67, (byte) (bArr22[12] - 1), bArr22[48], objArr45);
                objAccessartificialFrame11 = ArtificialStackFrames.coroutineCreation(offsetBefore, fadingEdgeLength, i63, 891606461, false, (String) objArr45[0], null);
            }
            ((Field) objAccessartificialFrame11).set(null, objArr2);
        } catch (Throwable th2) {
            Throwable cause2 = th2.getCause();
            if (cause2 == null) {
                throw th2;
            }
            throw cause2;
        }
        Object[] objArr46 = new Object[1];
        a(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 19, TextUtils.lastIndexOf("", '0', 0, 0) + 182, 16 - (Process.myTid() >> 22), new char[]{11, 3, 18, 17, 23, 65521, 65484, 5, '\f', 65535, '\n', 65484, 65535, 20, 65535, '\b'}, objArr46);
        cls3 = Class.forName((String) objArr46[0]);
        objArr4 = new Object[1];
        a(true, (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 13, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 181, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 12, new char[]{65501, 2, CharUtils.CR, 65531, 65506, 19, 14, 3, 14, '\b', 65535, 65534, 3, 65535, 65534, '\t'}, objArr4);
    }

    static void accessartificialFrame() {
        setDefaultImpl = -260894042;
    }
}
