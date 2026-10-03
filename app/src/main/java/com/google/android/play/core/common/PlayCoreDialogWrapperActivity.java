package com.google.android.play.core.common;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.Process;
import android.os.ResultReceiver;
import android.os.SystemClock;
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
import ch.qos.logback.core.net.SyslogConstants;
import com.facebook.imageutils.JfifUtil;
import com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager$$ExternalSyntheticLambda5;
import com.google.common.base.Ascii;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.pluservice.unicoc.R;
import o.ArtificialStackFrames;
import o.build;
import org.apache.commons.lang3.CharEncoding;

/* JADX INFO: loaded from: classes5.dex */
public class PlayCoreDialogWrapperActivity extends Activity {
    private static final byte[] $$a;
    private static final int $$b;
    private static final byte[] $$d;
    private static final int $$e;
    private static char ICustomTabsCallback;
    private static char TopicBuilder;
    private static int artificialFrame;
    private static char extraCallbackWithResult;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME;
    private static char onMessageChannelReady;
    private ResultReceiver zza;
    private static final byte[] $$c = {Ascii.SYN, -75, -19, -49};
    private static final int $$f = 239;
    private static int $10 = 0;
    private static int $11 = 1;

    private static String $$g(int i, byte b, byte b2) {
        int i2 = i * 3;
        byte[] bArr = $$c;
        int i3 = (b2 * 2) + AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR;
        int i4 = b + 4;
        byte[] bArr2 = new byte[1 - i2];
        int i5 = 0 - i2;
        int i6 = -1;
        if (bArr == null) {
            i3 = i4 + i3;
            i4 = i4;
        }
        while (true) {
            i6++;
            bArr2[i6] = (byte) i3;
            int i7 = i4 + 1;
            if (i6 == i5) {
                return new String(bArr2, 0);
            }
            i3 += bArr[i7];
            i4 = i7;
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0021  */
    /* JADX WARN: Code duplicated, block: B:8:0x0019  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0021 -> B:11:0x0026). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0021
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void b(int r7, byte r8, short r9, java.lang.Object[] r10) {
        /*
            int r9 = r9 + 65
            int r8 = 21 - r8
            int r7 = r7 + 4
            byte[] r0 = com.google.android.play.core.common.PlayCoreDialogWrapperActivity.$$a
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L11
            r3 = r9
            r4 = r2
            r9 = r7
            goto L26
        L11:
            r3 = r2
        L12:
            int r4 = r3 + 1
            byte r5 = (byte) r9
            r1[r3] = r5
            if (r4 != r8) goto L21
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L21:
            r3 = r0[r7]
            r6 = r9
            r9 = r7
            r7 = r6
        L26:
            int r3 = -r3
            int r7 = r7 + r3
            int r9 = r9 + 1
            r3 = r4
            r6 = r9
            r9 = r7
            r7 = r6
            goto L12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.common.PlayCoreDialogWrapperActivity.b(int, byte, short, java.lang.Object[]):void");
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
    private static void c(int r6, short r7, short r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = com.google.android.play.core.common.PlayCoreDialogWrapperActivity.$$d
            int r6 = 111 - r6
            int r8 = 590 - r8
            int r7 = r7 + 1
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L11
            r3 = r6
            r6 = r7
            r4 = r2
            goto L23
        L11:
            r3 = r2
        L12:
            int r4 = r3 + 1
            byte r5 = (byte) r6
            r1[r3] = r5
            if (r4 != r7) goto L21
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L21:
            r3 = r0[r8]
        L23:
            int r6 = r6 + r3
            int r8 = r8 + 1
            int r6 = r6 + (-4)
            r3 = r4
            goto L12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.common.PlayCoreDialogWrapperActivity.c(int, short, short, java.lang.Object[]):void");
    }

    private final void zza() {
        ResultReceiver resultReceiver = this.zza;
        if (resultReceiver != null) {
            resultReceiver.send(3, new Bundle());
        }
    }

    @Override // android.app.Activity
    protected final void onActivityResult(int i, int i2, Intent intent) {
        ResultReceiver resultReceiver;
        super.onActivityResult(i, i2, intent);
        if (i == 0 && (resultReceiver = this.zza) != null) {
            if (i2 == -1) {
                resultReceiver.send(1, new Bundle());
            } else if (i2 == 0) {
                resultReceiver.send(2, new Bundle());
            }
        }
        finish();
    }

    @Override // android.app.Activity
    protected final void onCreate(Bundle bundle) {
        Intent intent;
        int intExtra = getIntent().getIntExtra("window_flags", 0);
        if (intExtra != 0) {
            getWindow().getDecorView().setSystemUiVisibility(intExtra);
            intent = new Intent();
            intent.putExtra("window_flags", intExtra);
        } else {
            intent = null;
        }
        Intent intent2 = intent;
        super.onCreate(bundle);
        if (bundle != null) {
            this.zza = (ResultReceiver) bundle.getParcelable("result_receiver");
            return;
        }
        this.zza = (ResultReceiver) getIntent().getParcelableExtra("result_receiver");
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            zza();
            finish();
        }
        try {
            startIntentSenderForResult(((PendingIntent) extras.get("confirmation_intent")).getIntentSender(), 0, intent2, 0, 0, 0);
        } catch (IntentSender.SendIntentException unused) {
            zza();
            finish();
        }
    }

    @Override // android.app.Activity
    protected final void onSaveInstanceState(Bundle bundle) {
        bundle.putParcelable("result_receiver", this.zza);
    }

    private static void a(int i, char[] cArr, Object[] objArr) throws Throwable {
        int i2;
        int i3 = 2 % 2;
        build buildVar = new build();
        char[] cArr2 = new char[cArr.length];
        int i4 = 0;
        buildVar.c = 0;
        char[] cArr3 = new char[2];
        while (buildVar.c < cArr.length) {
            int i5 = $10 + 11;
            $11 = i5 % 128;
            int i6 = 58224;
            if (i5 % 2 == 0) {
                cArr3[1] = cArr[buildVar.c];
                int i7 = buildVar.c;
                cArr3[1] = cArr[i4];
                i2 = 1;
            } else {
                cArr3[i4] = cArr[buildVar.c];
                cArr3[1] = cArr[buildVar.c + 1];
                i2 = i4;
            }
            while (i2 < 16) {
                char c = cArr3[1];
                char c2 = cArr3[i4];
                int i8 = (c2 + i6) ^ ((c2 << 4) + ((char) (((long) extraCallbackWithResult) ^ (-4408183324873663413L))));
                int i9 = c2 >>> 5;
                try {
                    Object[] objArr2 = new Object[4];
                    objArr2[3] = Integer.valueOf(onMessageChannelReady);
                    objArr2[2] = Integer.valueOf(i9);
                    objArr2[1] = Integer.valueOf(i8);
                    objArr2[i4] = Integer.valueOf(c);
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1585798252);
                    if (objAccessartificialFrame == null) {
                        int i10 = (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 27;
                        char trimmedLength = (char) (17263 - TextUtils.getTrimmedLength(""));
                        int maximumFlingVelocity = (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 1067;
                        byte b = (byte) i4;
                        byte b2 = (byte) (b - 1);
                        String str$$g = $$g(b, b2, (byte) (b2 + 1));
                        Class[] clsArr = new Class[4];
                        clsArr[i4] = Integer.TYPE;
                        clsArr[1] = Integer.TYPE;
                        clsArr[2] = Integer.TYPE;
                        clsArr[3] = Integer.TYPE;
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(i10, trimmedLength, maximumFlingVelocity, 1042277788, false, str$$g, clsArr);
                    }
                    char cCharValue = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                    cArr3[1] = cCharValue;
                    char[] cArr4 = cArr3;
                    Object[] objArr3 = {Integer.valueOf(cArr3[i4]), Integer.valueOf((cCharValue + i6) ^ ((cCharValue << 4) + ((char) (((long) TopicBuilder) ^ (-4408183324873663413L))))), Integer.valueOf(cCharValue >>> 5), Integer.valueOf(ICustomTabsCallback)};
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1585798252);
                    if (objAccessartificialFrame2 == null) {
                        byte b3 = (byte) 0;
                        byte b4 = (byte) (b3 - 1);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(AndroidCharacter.getMirror('0') - 20, (char) (TextUtils.indexOf("", "") + 17263), (ViewConfiguration.getScrollDefaultDelay() >> 16) + 1067, 1042277788, false, $$g(b3, b4, (byte) (b4 + 1)), new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE});
                    }
                    cArr4[0] = ((Character) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).charValue();
                    i6 -= 40503;
                    i2++;
                    cArr3 = cArr4;
                    i4 = 0;
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
            char[] cArr5 = cArr3;
            cArr2[buildVar.c] = cArr5[0];
            cArr2[buildVar.c + 1] = cArr5[1];
            Object[] objArr4 = {buildVar, buildVar};
            Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1010141908);
            if (objAccessartificialFrame3 == null) {
                byte b5 = (byte) 0;
                byte b6 = (byte) (b5 - 1);
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(25 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) (TextUtils.indexOf((CharSequence) "", '0') + 63929), (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 486, 1554985764, false, $$g(b5, b6, (byte) (-b6)), new Class[]{Object.class, Object.class});
            }
            ((Method) objAccessartificialFrame3).invoke(null, objArr4);
            cArr3 = cArr5;
            i4 = 0;
        }
        String str = new String(cArr2, 0, i);
        int i11 = $11 + 121;
        $10 = i11 % 128;
        int i12 = i11 % 2;
        objArr[0] = str;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0a2e  */
    /* JADX WARN: Code duplicated, block: B:102:0x0a3a  */
    /* JADX WARN: Code duplicated, block: B:105:0x0a3e A[LOOP:2: B:103:0x0a3b->B:105:0x0a3e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:111:0x0b3b  */
    /* JADX WARN: Code duplicated, block: B:121:0x0c55  */
    /* JADX WARN: Code duplicated, block: B:124:0x0c5f A[Catch: all -> 0x252c, TryCatch #9 {all -> 0x252c, blocks: (B:321:0x224e, B:323:0x2271, B:324:0x22bc, B:209:0x15df, B:211:0x15f4, B:212:0x1629, B:184:0x1306, B:186:0x1313, B:187:0x1348, B:189:0x1352, B:191:0x135f, B:192:0x1391, B:122:0x0c59, B:124:0x0c5f, B:125:0x0c8a, B:127:0x0cb5, B:128:0x0d43), top: B:391:0x0c59 }] */
    /* JADX WARN: Code duplicated, block: B:127:0x0cb5 A[Catch: all -> 0x252c, TryCatch #9 {all -> 0x252c, blocks: (B:321:0x224e, B:323:0x2271, B:324:0x22bc, B:209:0x15df, B:211:0x15f4, B:212:0x1629, B:184:0x1306, B:186:0x1313, B:187:0x1348, B:189:0x1352, B:191:0x135f, B:192:0x1391, B:122:0x0c59, B:124:0x0c5f, B:125:0x0c8a, B:127:0x0cb5, B:128:0x0d43), top: B:391:0x0c59 }] */
    /* JADX WARN: Code duplicated, block: B:131:0x0d56  */
    /* JADX WARN: Code duplicated, block: B:136:0x0dc8  */
    /* JADX WARN: Code duplicated, block: B:137:0x0e0a  */
    /* JADX WARN: Code duplicated, block: B:141:0x0e28  */
    /* JADX WARN: Code duplicated, block: B:142:0x0e7c  */
    /* JADX WARN: Code duplicated, block: B:147:0x0f49  */
    /* JADX WARN: Code duplicated, block: B:157:0x1086  */
    /* JADX WARN: Code duplicated, block: B:159:0x108d  */
    /* JADX WARN: Code duplicated, block: B:161:0x1100  */
    /* JADX WARN: Code duplicated, block: B:163:0x1104  */
    /* JADX WARN: Code duplicated, block: B:167:0x1110  */
    /* JADX WARN: Code duplicated, block: B:172:0x11b1  */
    /* JADX WARN: Code duplicated, block: B:177:0x121e  */
    /* JADX WARN: Code duplicated, block: B:178:0x1264  */
    /* JADX WARN: Code duplicated, block: B:182:0x1280  */
    /* JADX WARN: Code duplicated, block: B:183:0x1301  */
    /* JADX WARN: Code duplicated, block: B:186:0x1313 A[Catch: all -> 0x252c, TryCatch #9 {all -> 0x252c, blocks: (B:321:0x224e, B:323:0x2271, B:324:0x22bc, B:209:0x15df, B:211:0x15f4, B:212:0x1629, B:184:0x1306, B:186:0x1313, B:187:0x1348, B:189:0x1352, B:191:0x135f, B:192:0x1391, B:122:0x0c59, B:124:0x0c5f, B:125:0x0c8a, B:127:0x0cb5, B:128:0x0d43), top: B:391:0x0c59 }] */
    /* JADX WARN: Code duplicated, block: B:191:0x135f A[Catch: all -> 0x252c, TryCatch #9 {all -> 0x252c, blocks: (B:321:0x224e, B:323:0x2271, B:324:0x22bc, B:209:0x15df, B:211:0x15f4, B:212:0x1629, B:184:0x1306, B:186:0x1313, B:187:0x1348, B:189:0x1352, B:191:0x135f, B:192:0x1391, B:122:0x0c59, B:124:0x0c5f, B:125:0x0c8a, B:127:0x0cb5, B:128:0x0d43), top: B:391:0x0c59 }] */
    /* JADX WARN: Code duplicated, block: B:198:0x1487  */
    /* JADX WARN: Code duplicated, block: B:208:0x15c1  */
    /* JADX WARN: Code duplicated, block: B:211:0x15f4 A[Catch: all -> 0x252c, TryCatch #9 {all -> 0x252c, blocks: (B:321:0x224e, B:323:0x2271, B:324:0x22bc, B:209:0x15df, B:211:0x15f4, B:212:0x1629, B:184:0x1306, B:186:0x1313, B:187:0x1348, B:189:0x1352, B:191:0x135f, B:192:0x1391, B:122:0x0c59, B:124:0x0c5f, B:125:0x0c8a, B:127:0x0cb5, B:128:0x0d43), top: B:391:0x0c59 }] */
    /* JADX WARN: Code duplicated, block: B:215:0x1640  */
    /* JADX WARN: Code duplicated, block: B:220:0x16ac  */
    /* JADX WARN: Code duplicated, block: B:221:0x16f5  */
    /* JADX WARN: Code duplicated, block: B:225:0x1711  */
    /* JADX WARN: Code duplicated, block: B:226:0x1785  */
    /* JADX WARN: Code duplicated, block: B:228:0x1790  */
    /* JADX WARN: Code duplicated, block: B:231:0x1794 A[LOOP:1: B:229:0x1791->B:231:0x1794, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:237:0x188f  */
    /* JADX WARN: Code duplicated, block: B:240:0x18dd  */
    /* JADX WARN: Code duplicated, block: B:242:0x1906  */
    /* JADX WARN: Code duplicated, block: B:244:0x190f  */
    /* JADX WARN: Code duplicated, block: B:247:0x19ec  */
    /* JADX WARN: Code duplicated, block: B:250:0x19f3  */
    /* JADX WARN: Code duplicated, block: B:252:0x1a4e  */
    /* JADX WARN: Code duplicated, block: B:258:0x1a5e  */
    /* JADX WARN: Code duplicated, block: B:262:0x1af8  */
    /* JADX WARN: Code duplicated, block: B:264:0x1b0b  */
    /* JADX WARN: Code duplicated, block: B:269:0x1b81  */
    /* JADX WARN: Code duplicated, block: B:275:0x1be3  */
    /* JADX WARN: Code duplicated, block: B:276:0x1c42  */
    /* JADX WARN: Code duplicated, block: B:281:0x1d20  */
    /* JADX WARN: Code duplicated, block: B:284:0x1d78  */
    /* JADX WARN: Code duplicated, block: B:291:0x1e4d  */
    /* JADX WARN: Code duplicated, block: B:295:0x1edd  */
    /* JADX WARN: Code duplicated, block: B:300:0x1f4d  */
    /* JADX WARN: Code duplicated, block: B:304:0x1fac  */
    /* JADX WARN: Code duplicated, block: B:305:0x200f  */
    /* JADX WARN: Code duplicated, block: B:310:0x2118  */
    /* JADX WARN: Code duplicated, block: B:313:0x2166  */
    /* JADX WARN: Code duplicated, block: B:320:0x2230  */
    /* JADX WARN: Code duplicated, block: B:323:0x2271 A[Catch: all -> 0x252c, TryCatch #9 {all -> 0x252c, blocks: (B:321:0x224e, B:323:0x2271, B:324:0x22bc, B:209:0x15df, B:211:0x15f4, B:212:0x1629, B:184:0x1306, B:186:0x1313, B:187:0x1348, B:189:0x1352, B:191:0x135f, B:192:0x1391, B:122:0x0c59, B:124:0x0c5f, B:125:0x0c8a, B:127:0x0cb5, B:128:0x0d43), top: B:391:0x0c59 }] */
    /* JADX WARN: Code duplicated, block: B:327:0x22cf  */
    /* JADX WARN: Code duplicated, block: B:332:0x2334  */
    /* JADX WARN: Code duplicated, block: B:336:0x2387  */
    /* JADX WARN: Code duplicated, block: B:337:0x23f9  */
    /* JADX WARN: Code duplicated, block: B:339:0x2405  */
    /* JADX WARN: Code duplicated, block: B:342:0x2409 A[LOOP:0: B:340:0x2406->B:342:0x2409, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:53:0x04b0  */
    /* JADX WARN: Code duplicated, block: B:54:0x0517  */
    /* JADX WARN: Code duplicated, block: B:59:0x060e  */
    /* JADX WARN: Code duplicated, block: B:68:0x075f  */
    /* JADX WARN: Code duplicated, block: B:70:0x0765  */
    /* JADX WARN: Code duplicated, block: B:72:0x07e4  */
    /* JADX WARN: Code duplicated, block: B:74:0x07e8  */
    /* JADX WARN: Code duplicated, block: B:78:0x07f4  */
    /* JADX WARN: Code duplicated, block: B:83:0x08ed  */
    /* JADX WARN: Code duplicated, block: B:85:0x08f6  */
    /* JADX WARN: Code duplicated, block: B:90:0x095d  */
    /* JADX WARN: Code duplicated, block: B:91:0x09a1  */
    /* JADX WARN: Code duplicated, block: B:95:0x09b0  */
    /* JADX WARN: Code duplicated, block: B:99:0x09c3  */
    @Override // android.app.Activity
    public void onStart() throws Throwable {
        Object[] objArr;
        String str;
        Long lValueOf;
        Object objAccessartificialFrame;
        int absoluteGravity;
        int i;
        boolean z;
        String str2;
        Class[] clsArr;
        char c;
        int i2;
        int i3;
        int i4;
        Object objAccessartificialFrame2;
        long j;
        Context baseContext;
        String str3;
        Object[] objArr2;
        Object[] objArr3;
        Object objAccessartificialFrame3;
        Object objAccessartificialFrame4;
        int i5;
        int i6;
        ArrayList arrayList;
        String[] strArr;
        int i7;
        Object objAccessartificialFrame5;
        long j2;
        Object objAccessartificialFrame6;
        Object objAccessartificialFrame7;
        Object objAccessartificialFrame8;
        Object objAccessartificialFrame9;
        Object[] objArr4;
        Object obj;
        int i8;
        Object obj2;
        int i9;
        int i10;
        Object objAccessartificialFrame10;
        long j3;
        Context baseContext2;
        Object objAccessartificialFrame11;
        Object objAccessartificialFrame12;
        Object[] objArr5;
        int i11;
        int i12;
        Object objAccessartificialFrame13;
        Object objAccessartificialFrame14;
        int i13;
        Object objAccessartificialFrame15;
        long j4;
        Object objAccessartificialFrame16;
        Object objAccessartificialFrame17;
        Object objAccessartificialFrame18;
        Object[] objArr6;
        int i14;
        int i15;
        ArrayList arrayList2;
        String[] strArr2;
        int i16;
        Object objAccessartificialFrame19;
        long j5;
        int i17;
        Context baseContext3;
        Object[] objArr7;
        Object objAccessartificialFrame20;
        Object objAccessartificialFrame21;
        int i18;
        int i19;
        Object objAccessartificialFrame22;
        long j6;
        Object[] objArr8;
        Object objAccessartificialFrame23;
        Object objAccessartificialFrame24;
        int i20;
        int i21;
        Object objAccessartificialFrame25;
        long j7;
        Object objAccessartificialFrame26;
        Object[] objArr9;
        Object objAccessartificialFrame27;
        Object objAccessartificialFrame28;
        int i22;
        int i23;
        ArrayList arrayList3;
        String[] strArr3;
        int i24;
        Object objAccessartificialFrame29;
        int i25 = 2 % 2;
        int i26 = 0;
        Object[] objArr10 = new Object[1];
        a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(9) - 92, new char[]{62893, 22787, 4744, 22145, 39232, 29426, 40333, 'v', 2813, 41244, 17347, 9541, 36577, 22902, 33572, 2441, 48048, 40197, 16413, 52585, 62544, 42067}, objArr10);
        String str4 = (String) objArr10[0];
        Object[] objArr11 = new Object[1];
        a(Color.green(0) + 15, new char[]{1969, 29222, 35150, 13180, 24714, 12898, 25738, 25013, 39435, 38293, 1745, 1597, 6446, 48017, 49848, 15482}, objArr11);
        String str5 = (String) objArr11[0];
        Object[] objArr12 = new Object[1];
        a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 19, new char[]{5635, 2765, 56321, 3827, 50996, 45626, 62893, 22787, 56130, 2369, 8779, 52186, 24815, 35845, 6016, 1829}, objArr12);
        String str6 = (String) objArr12[0];
        Object[] objArr13 = new Object[1];
        a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(7) - 99, new char[]{37176, 46068, 46585, 59274, 60555, 17380, 61769, 58069, 7029, 51068, 13060, 33868, 62261, 61669, 52338, 2144}, objArr13);
        String str7 = (String) objArr13[0];
        Object objAccessartificialFrame30 = ArtificialStackFrames.accessartificialFrame(-2127922582);
        if (objAccessartificialFrame30 == null) {
            int keyRepeatTimeout = 30 - (ViewConfiguration.getKeyRepeatTimeout() >> 16);
            char pressedStateDuration = (char) (49362 - (ViewConfiguration.getPressedStateDuration() >> 16));
            int doubleTapTimeout = (ViewConfiguration.getDoubleTapTimeout() >> 16) + 684;
            byte[] bArr = $$a;
            byte b = (byte) (bArr[24] - 1);
            byte b2 = bArr[46];
            Object[] objArr14 = new Object[1];
            b(b, b2, (byte) (b2 | 37), objArr14);
            objAccessartificialFrame30 = ArtificialStackFrames.coroutineCreation(keyRepeatTimeout, pressedStateDuration, doubleTapTimeout, 508509282, false, (String) objArr14[0], null);
        }
        long j8 = ((Field) objAccessartificialFrame30).getLong(null);
        if (j8 == -1 || j8 + 1913 < ((Long) Class.forName(str4).getDeclaredMethod(str5, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Context baseContext4 = getBaseContext();
            if (baseContext4 == null) {
                Object[] objArr15 = new Object[1];
                a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(0) - 11, new char[]{62893, 22787, 4744, 22145, 39232, 29426, 40333, 'v', 35150, 13180, 13629, 65086, 9816, 58417, 60555, 17380, 4331, 65217, 61769, 58069, 4112, 47537, 61656, 59108, 14618, 6023}, objArr15);
                Class<?> cls = Class.forName((String) objArr15[0]);
                Object[] objArr16 = new Object[1];
                a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 14, new char[]{7990, 25361, 25627, 56441, 46585, 59274, 3557, 22833, 28112, 57992, 9620, 6486, 1632, 52928, 60555, 17380, 48584, 55263}, objArr16);
                baseContext4 = (Context) cls.getMethod((String) objArr16[0], new Class[0]).invoke(null, null);
            }
            if (baseContext4 != null) {
                baseContext4 = ((baseContext4 instanceof ContextWrapper) && ((ContextWrapper) baseContext4).getBaseContext() == null) ? null : baseContext4.getApplicationContext();
            }
            try {
                Object[] objArr17 = {baseContext4, Integer.valueOf(((Integer) Class.forName(str6).getMethod(str7, Object.class).invoke(null, this)).intValue()), 1713277000};
                byte[] bArr2 = $$d;
                Object[] objArr18 = new Object[1];
                c(bArr2[8], bArr2[51], (short) 586, objArr18);
                Class<?> cls2 = Class.forName((String) objArr18[0]);
                Object[] objArr19 = new Object[1];
                c(bArr2[45], (byte) (bArr2[49] - 1), (short) 531, objArr19);
                objArr = (Object[]) cls2.getMethod((String) objArr19[0], Context.class, Integer.TYPE, Integer.TYPE).invoke(null, objArr17);
                if (baseContext4 != null) {
                    int i27 = artificialFrame + 71;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i27 % 128;
                    try {
                        if (i27 % 2 != 0) {
                            Object objAccessartificialFrame31 = ArtificialStackFrames.accessartificialFrame(777251007);
                            if (objAccessartificialFrame31 == null) {
                                int iLastIndexOf = 29 - TextUtils.lastIndexOf("", '0');
                                char cLastIndexOf = (char) (TextUtils.lastIndexOf("", '0') + 49363);
                                int bitsPerPixel = ImageFormat.getBitsPerPixel(0) + 685;
                                byte[] bArr3 = $$a;
                                Object[] objArr20 = new Object[1];
                                b(bArr3[37], bArr3[107], (byte) (-bArr3[34]), objArr20);
                                objAccessartificialFrame31 = ArtificialStackFrames.coroutineCreation(iLastIndexOf, cLastIndexOf, bitsPerPixel, -1321816393, false, (String) objArr20[0], null);
                            }
                            ((Field) objAccessartificialFrame31).set(null, objArr);
                            lValueOf = Long.valueOf(((Long) Class.forName(str4).getDeclaredMethod(str5, new Class[0]).invoke(null, new Object[1])).longValue());
                            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-2127922582);
                            if (objAccessartificialFrame == null) {
                                absoluteGravity = 30 - Gravity.getAbsoluteGravity(0, 0);
                                char cLastIndexOf2 = (char) (TextUtils.lastIndexOf("", '0', 0, 0) + 49363);
                                int keyRepeatTimeout2 = (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 684;
                                i = 508509282;
                                z = false;
                                byte[] bArr4 = $$a;
                                byte b3 = (byte) (bArr4[24] - 1);
                                byte b4 = bArr4[46];
                                str = str7;
                                Object[] objArr21 = new Object[1];
                                b(b3, b4, (byte) (b4 | 37), objArr21);
                                str2 = (String) objArr21[0];
                                clsArr = null;
                                c = cLastIndexOf2;
                                i2 = keyRepeatTimeout2;
                                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(absoluteGravity, c, i2, i, z, str2, clsArr);
                            } else {
                                str = str7;
                            }
                        } else {
                            str = str7;
                            Object objAccessartificialFrame32 = ArtificialStackFrames.accessartificialFrame(777251007);
                            if (objAccessartificialFrame32 == null) {
                                int iIndexOf = 29 - TextUtils.indexOf((CharSequence) "", '0');
                                char scrollBarFadeDuration = (char) (49362 - (ViewConfiguration.getScrollBarFadeDuration() >> 16));
                                int edgeSlop = (ViewConfiguration.getEdgeSlop() >> 16) + 684;
                                byte[] bArr5 = $$a;
                                Object[] objArr22 = new Object[1];
                                b(bArr5[37], bArr5[107], (byte) (-bArr5[34]), objArr22);
                                objAccessartificialFrame32 = ArtificialStackFrames.coroutineCreation(iIndexOf, scrollBarFadeDuration, edgeSlop, -1321816393, false, (String) objArr22[0], null);
                            }
                            ((Field) objAccessartificialFrame32).set(null, objArr);
                            lValueOf = Long.valueOf(((Long) Class.forName(str4).getDeclaredMethod(str5, new Class[0]).invoke(null, new Object[0])).longValue());
                            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-2127922582);
                            if (objAccessartificialFrame == null) {
                                absoluteGravity = (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 30;
                                char cLastIndexOf3 = (char) (TextUtils.lastIndexOf("", '0') + 49363);
                                int iIndexOf2 = 684 - TextUtils.indexOf("", "");
                                i = 508509282;
                                z = false;
                                byte[] bArr6 = $$a;
                                byte b5 = (byte) (bArr6[24] - 1);
                                byte b6 = bArr6[46];
                                Object[] objArr23 = new Object[1];
                                b(b5, b6, (byte) (b6 | 37), objArr23);
                                str2 = (String) objArr23[0];
                                clsArr = null;
                                c = cLastIndexOf3;
                                i2 = iIndexOf2;
                                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(absoluteGravity, c, i2, i, z, str2, clsArr);
                            }
                        }
                        ((Field) objAccessartificialFrame).set(null, lValueOf);
                    } catch (Exception unused) {
                        throw new RuntimeException();
                    }
                }
                i3 = ((int[]) objArr[1])[0];
                i4 = ((int[]) objArr[0])[0];
                if (i4 == i3) {
                    int i28 = ((int[]) objArr[2])[0];
                    Object[] objArr24 = {new int[]{((int[]) objArr[0])[0]}, new int[]{((int[]) objArr[1])[0]}, new int[1], (String) objArr[3]};
                    int iMaxMemory = (int) Runtime.getRuntime().maxMemory();
                    int i29 = i28 + ((~((~iMaxMemory) | (-541725193))) * 130) + 1251113838 + (((~(iMaxMemory | (-541725193))) | 83904720) * 130);
                    int i30 = (i29 << 13) ^ i29;
                    int i31 = i30 ^ (i30 >>> 17);
                    ((int[]) objArr24[2])[0] = i31 ^ (i31 << 5);
                } else {
                    try {
                        Object[] objArr25 = {Long.valueOf(((long) (i3 ^ i4)) ^ (((long) (-1248174732)) << 32)), Long.valueOf(-1248174220)};
                        byte[] bArr7 = $$d;
                        byte b7 = bArr7[8];
                        byte b8 = bArr7[346];
                        Object[] objArr26 = new Object[1];
                        c(b7, b8, (short) (b8 | 445), objArr26);
                        Class<?> cls3 = Class.forName((String) objArr26[0]);
                        Object[] objArr27 = new Object[1];
                        c(bArr7[97], bArr7[0], (short) 445, objArr27);
                        cls3.getMethod((String) objArr27[0], Long.TYPE, Long.TYPE).invoke(null, objArr25);
                        int i32 = ((int[]) objArr[2])[0];
                        Object[] objArr28 = {new int[]{((int[]) objArr[0])[0]}, new int[]{((int[]) objArr[1])[0]}, new int[1], (String) objArr[3]};
                        int iCodePointAt = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(17) + 1679106015;
                        int i33 = ~iCodePointAt;
                        int i34 = i32 + (((~(i33 | 245747311)) | (~((-732876464) | i33)) | (~((-245747312) | iCodePointAt))) * 959) + 1525956300 + (((~(iCodePointAt | 245747311)) | (~(i33 | (-245747312))) | (~((-732876464) | iCodePointAt))) * 959);
                        int i35 = (i34 << 13) ^ i34;
                        int i36 = i35 ^ (i35 >>> 17);
                        ((int[]) objArr28[2])[0] = i36 ^ (i36 << 5);
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause == null) {
                            throw th;
                        }
                        throw cause;
                    }
                }
                objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1313006081);
                if (objAccessartificialFrame2 == null) {
                    int iIndexOf3 = TextUtils.indexOf((CharSequence) "", '0') + 22;
                    char c2 = (char) (1 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)));
                    int gidForName = Process.getGidForName("") + 466;
                    byte[] bArr8 = $$a;
                    Object[] objArr29 = new Object[1];
                    b(bArr8[8], bArr8[37], bArr8[0], objArr29);
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iIndexOf3, c2, gidForName, -785931255, false, (String) objArr29[0], null);
                }
                j = ((Field) objAccessartificialFrame2).getLong(null);
                if (j != -1 || j + 1975 < ((Long) Class.forName(str4).getDeclaredMethod(str5, new Class[0]).invoke(null, new Object[0])).longValue()) {
                    baseContext = getBaseContext();
                    if (baseContext == null) {
                        Object[] objArr30 = new Object[1];
                        a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(1) - 23, new char[]{62893, 22787, 4744, 22145, 39232, 29426, 40333, 'v', 35150, 13180, 13629, 65086, 9816, 58417, 60555, 17380, 4331, 65217, 61769, 58069, 4112, 47537, 61656, 59108, 14618, 6023}, objArr30);
                        Class<?> cls4 = Class.forName((String) objArr30[0]);
                        Object[] objArr31 = new Object[1];
                        a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 3, new char[]{7990, 25361, 25627, 56441, 46585, 59274, 3557, 22833, 28112, 57992, 9620, 6486, 1632, 52928, 60555, 17380, 48584, 55263}, objArr31);
                        baseContext = (Context) cls4.getMethod((String) objArr31[0], new Class[0]).invoke(null, null);
                    }
                    if (baseContext != null) {
                        if ((baseContext instanceof ContextWrapper) || ((ContextWrapper) baseContext).getBaseContext() != null) {
                            baseContext = baseContext.getApplicationContext();
                        } else {
                            baseContext = null;
                        }
                    }
                    str3 = str;
                    int iIntValue = ((Integer) Class.forName(str6).getMethod(str3, Object.class).invoke(null, this)).intValue();
                    Object[] objArr32 = new Object[1];
                    a(AndroidCharacter.getMirror('0') + 16, new char[]{45449, 5312, 24732, 9522, 50892, 47744, 56311, 23020, 36658, 26522, 47076, 7487, 14365, 35694, 34447, 7290, 47130, 64522, 19573, 56030, 60151, 35938, 34447, 7290, 52210, 19639, 17398, 27519, 45436, 1039, 60973, 31834, 288, 5284, 35921, 54951, 34447, 7290, 63792, 3498, 8826, 54630, 288, 5284, 24809, 33407, 64539, 40566, 46052, 54920, 32843, 62463, 24783, 32787, 64678, 26513, 8826, 54630, 15901, 31583, 4291, 46401, 55028, 36782}, objArr32);
                    String str8 = (String) objArr32[0];
                    Object[] objArr33 = new Object[1];
                    a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 29, new char[]{4105, 11591, 8065, 53458, 60973, 31834, 8049, 16285, 12674, 47602, 41468, 6261, 10076, 47780, 36143, 39377, 53438, 48055, 2806, 64062, 63433, 13419, 47076, 7487, 24783, 32787, 31950, 30079, 2435, 39006, 10266, 7541, 32844, 39592, 52026, 59282, 47076, 7487, 59867, 53557, 19806, 55833, 30497, 3784, 17398, 27519, 24732, 9522, 8363, 5410, 63433, 13419, 13146, 22382, 25055, 43329, 38272, 37923, 28178, 4396, 63764, 58406, 45127, 56283}, objArr33);
                    Object[] objArr34 = {baseContext, new String[]{str8, (String) objArr33[0]}, Integer.valueOf(iIntValue), 1, 1310855002};
                    byte[] bArr9 = $$d;
                    Object[] objArr35 = new Object[1];
                    c(bArr9[43], bArr9[429], (short) 443, objArr35);
                    Class<?> cls5 = Class.forName((String) objArr35[0]);
                    Object[] objArr36 = new Object[1];
                    c(bArr9[45], (byte) (bArr9[49] - 1), (short) 531, objArr36);
                    objArr2 = (Object[]) cls5.getMethod((String) objArr36[0], Context.class, String[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr34);
                    int i37 = ((int[]) objArr2[0])[0];
                    int i38 = ((int[]) objArr2[3])[0];
                    if (baseContext != null) {
                        objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(1142731807);
                        if (objAccessartificialFrame3 == null) {
                            int bitsPerPixel2 = 20 - ImageFormat.getBitsPerPixel(0);
                            char cIndexOf = (char) TextUtils.indexOf("", "", 0);
                            int packedPositionType = ExpandableListView.getPackedPositionType(0L) + 465;
                            byte[] bArr10 = $$a;
                            Object[] objArr37 = new Object[1];
                            b((byte) (-bArr10[108]), bArr10[37], bArr10[0], objArr37);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(bitsPerPixel2, cIndexOf, packedPositionType, -612765161, false, (String) objArr37[0], null);
                        }
                        ((Field) objAccessartificialFrame3).set(null, objArr2);
                        try {
                            Long lValueOf2 = Long.valueOf(((Long) Class.forName(str4).getDeclaredMethod(str5, new Class[0]).invoke(null, new Object[0])).longValue());
                            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1313006081);
                            if (objAccessartificialFrame4 == null) {
                                int iIndexOf4 = TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 22;
                                char cResolveSizeAndState = (char) View.resolveSizeAndState(0, 0, 0);
                                int i39 = 466 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                                byte[] bArr11 = $$a;
                                Object[] objArr38 = new Object[1];
                                b(bArr11[8], bArr11[37], bArr11[0], objArr38);
                                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(iIndexOf4, cResolveSizeAndState, i39, -785931255, false, (String) objArr38[0], null);
                            }
                            ((Field) objAccessartificialFrame4).set(null, lValueOf2);
                        } catch (Exception unused2) {
                            throw new RuntimeException();
                        }
                    } else {
                        objArr2 = objArr2;
                    }
                    objArr3 = objArr2;
                } else {
                    int i40 = getARTIFICIAL_FRAME_PACKAGE_NAME + 97;
                    artificialFrame = i40 % 128;
                    int i41 = i40 % 2;
                    Object objAccessartificialFrame33 = ArtificialStackFrames.accessartificialFrame(1142731807);
                    if (objAccessartificialFrame33 == null) {
                        int iAxisFromString = 20 - MotionEvent.axisFromString("");
                        char edgeSlop2 = (char) (ViewConfiguration.getEdgeSlop() >> 16);
                        int packedPositionChild = 464 - ExpandableListView.getPackedPositionChild(0L);
                        byte[] bArr12 = $$a;
                        Object[] objArr39 = new Object[1];
                        b((byte) (-bArr12[108]), bArr12[37], bArr12[0], objArr39);
                        objAccessartificialFrame33 = ArtificialStackFrames.coroutineCreation(iAxisFromString, edgeSlop2, packedPositionChild, -612765161, false, (String) objArr39[0], null);
                    }
                    Object[] objArr40 = (Object[]) ((Field) objAccessartificialFrame33).get(null);
                    objArr3 = new Object[]{new int[]{i}, strArr, new int[1], new int[]{i}};
                    int i42 = ((int[]) objArr40[3])[0];
                    int i43 = ((int[]) objArr40[0])[0];
                    String[] strArr4 = (String[]) objArr40[1];
                    int i44 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().keyboard;
                    int i45 = ~(732887862 | i44);
                    int i46 = ~i44;
                    int i47 = 1378380203 + ((i45 | (~((-176308771) | i46))) * (-406)) + ((~(1069546358 | i46)) * (-406)) + (((~(i44 | (-893237589))) | (~((-732887863) | i46))) * 406) + 1310855002;
                    int i48 = (i47 << 13) ^ i47;
                    int i49 = i48 ^ (i48 >>> 17);
                    ((int[]) objArr3[2])[0] = i49 ^ (i49 << 5);
                    str3 = str;
                }
                i5 = ((int[]) objArr3[0])[0];
                i6 = ((int[]) objArr3[3])[0];
                if (i6 == i5) {
                    int i50 = artificialFrame + 113;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i50 % 128;
                    int i51 = i50 % 2;
                    Object[] objArr41 = {new int[]{i}, strArr, new int[1], new int[]{i}};
                    int i52 = ((int[]) objArr3[2])[0];
                    int i53 = ((int[]) objArr3[3])[0];
                    int i54 = ((int[]) objArr3[0])[0];
                    String[] strArr5 = (String[]) objArr3[1];
                    int i55 = ~System.identityHashCode(this);
                    int i56 = i52 + (-2088359324) + ((~((-640459017) | i55)) * (-783)) + (((~(i55 | (-774759723))) | (-935109449)) * 783);
                    int i57 = (i56 << 13) ^ i56;
                    int i58 = i57 ^ (i57 >>> 17);
                    ((int[]) objArr41[2])[0] = i58 ^ (i58 << 5);
                } else {
                    arrayList = new ArrayList();
                    strArr = (String[]) objArr3[1];
                    if (strArr != null) {
                        for (String str9 : strArr) {
                            arrayList.add(str9);
                        }
                    }
                    Object[] objArr42 = {Long.valueOf((((long) 1121676644) << 32) ^ ((long) (i5 ^ i6))), Long.valueOf(1121676580)};
                    byte[] bArr13 = $$d;
                    Object[] objArr43 = new Object[1];
                    c(bArr13[8], bArr13[130], (short) 404, objArr43);
                    Class<?> cls6 = Class.forName((String) objArr43[0]);
                    Object[] objArr44 = new Object[1];
                    c(bArr13[97], bArr13[0], (short) 445, objArr44);
                    cls6.getMethod((String) objArr44[0], Long.TYPE, Long.TYPE).invoke(null, objArr42);
                    Object[] objArr45 = {new int[]{i}, strArr, new int[1], new int[]{i}};
                    int i59 = ((int[]) objArr3[2])[0];
                    int i60 = ((int[]) objArr3[3])[0];
                    int i61 = ((int[]) objArr3[0])[0];
                    String[] strArr6 = (String[]) objArr3[1];
                    int i62 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().screenWidthDp;
                    int i63 = ~i62;
                    int i64 = i59 + (((~((-56659033) | i62)) | (~((-103690694) | i63)) | (~(i63 | 56659032))) * 959) + 330158620 + (((~(i62 | 56659032)) | (~(i63 | (-56659033))) | (~((-103690694) | i62))) * 959);
                    int i65 = (i64 << 13) ^ i64;
                    int i66 = i65 ^ (i65 >>> 17);
                    i26 = 0;
                    ((int[]) objArr45[2])[0] = i66 ^ (i66 << 5);
                }
                objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1168947751);
                if (objAccessartificialFrame5 == null) {
                    int scrollDefaultDelay = (ViewConfiguration.getScrollDefaultDelay() >> 16) + 36;
                    char cResolveSize = (char) View.resolveSize(i26, i26);
                    int iIndexOf5 = TextUtils.indexOf((CharSequence) "", '0', i26, i26) + 541;
                    byte[] bArr14 = $$a;
                    Object[] objArr46 = new Object[1];
                    b(bArr14[8], bArr14[37], bArr14[i26], objArr46);
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(scrollDefaultDelay, cResolveSize, iIndexOf5, 624296913, false, (String) objArr46[i26], null);
                }
                j2 = ((Field) objAccessartificialFrame5).getLong(null);
                if (j2 != -1 || j2 + 1920 < ((Long) Class.forName(str4).getDeclaredMethod(str5, new Class[0]).invoke(null, new Object[0])).longValue()) {
                    try {
                        objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1717965552);
                        if (objAccessartificialFrame6 == null) {
                            objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(20 - View.combineMeasuredStates(0, 0), (char) (KeyEvent.normalizeMetaState(0) + 39516), (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 982, 117222168, false, null, new Class[0]);
                        }
                        Object[] objArr47 = {null, ((Constructor) objAccessartificialFrame6).newInstance(null), 1460681364, 0};
                        objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-501205803);
                        if (objAccessartificialFrame7 == null) {
                            int iResolveSize = 36 - View.resolveSize(0, 0);
                            char cAxisFromString = (char) (MotionEvent.axisFromString("") + 1);
                            int defaultSize = View.getDefaultSize(0, 0) + 540;
                            byte[] bArr15 = $$a;
                            byte b9 = (byte) (bArr15[6] - 1);
                            byte b10 = (byte) (bArr15[24] - 1);
                            Object[] objArr48 = new Object[1];
                            b(b9, b10, b10, objArr48);
                            objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(iResolveSize, cAxisFromString, defaultSize, 2101703389, false, (String) objArr48[0], new Class[]{(Class) ArtificialStackFrames.coroutineCreation(54 - (ViewConfiguration.getTapTimeout() >> 16), (char) (((Process.getThreadPriority(0) + 20) >> 6) + 833), 576 - (ViewConfiguration.getKeyRepeatTimeout() >> 16)), (Class) ArtificialStackFrames.coroutineCreation(TextUtils.getCapsMode("", 0, 0) + 54, (char) View.MeasureSpec.getMode(0), 631 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))), Integer.TYPE, Integer.TYPE});
                        }
                        Object[] objArr49 = (Object[]) ((Method) objAccessartificialFrame7).invoke(null, objArr47);
                        objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-1339222025);
                        if (objAccessartificialFrame8 == null) {
                            int i67 = (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 35;
                            char c3 = (char) (1 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)));
                            int iLastIndexOf2 = 539 - TextUtils.lastIndexOf("", '0', 0, 0);
                            byte[] bArr16 = $$a;
                            Object[] objArr50 = new Object[1];
                            b((byte) (-bArr16[108]), bArr16[37], bArr16[0], objArr50);
                            objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(i67, c3, iLastIndexOf2, 793268735, false, (String) objArr50[0], null);
                        }
                        ((Field) objAccessartificialFrame8).set(null, objArr49);
                        try {
                            Long lValueOf3 = Long.valueOf(((Long) Class.forName(str4).getDeclaredMethod(str5, new Class[0]).invoke(null, new Object[0])).longValue());
                            objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(-1168947751);
                            if (objAccessartificialFrame9 == null) {
                                int trimmedLength = TextUtils.getTrimmedLength("") + 36;
                                char edgeSlop3 = (char) (ViewConfiguration.getEdgeSlop() >> 16);
                                int iRed = Color.red(0) + 540;
                                byte[] bArr17 = $$a;
                                Object[] objArr51 = new Object[1];
                                b(bArr17[8], bArr17[37], bArr17[0], objArr51);
                                objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(trimmedLength, edgeSlop3, iRed, 624296913, false, (String) objArr51[0], null);
                            }
                            ((Field) objAccessartificialFrame9).set(null, lValueOf3);
                            objArr4 = objArr49;
                        } catch (Exception unused3) {
                            throw new RuntimeException();
                        }
                    } catch (Throwable th2) {
                        Throwable cause2 = th2.getCause();
                        if (cause2 == null) {
                            throw th2;
                        }
                        throw cause2;
                    }
                } else {
                    Object objAccessartificialFrame34 = ArtificialStackFrames.accessartificialFrame(-1339222025);
                    if (objAccessartificialFrame34 == null) {
                        int fadingEdgeLength = (ViewConfiguration.getFadingEdgeLength() >> 16) + 36;
                        char c4 = (char) (1 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)));
                        int maximumFlingVelocity = 540 - (ViewConfiguration.getMaximumFlingVelocity() >> 16);
                        byte[] bArr18 = $$a;
                        Object[] objArr52 = new Object[1];
                        b((byte) (-bArr18[108]), bArr18[37], bArr18[0], objArr52);
                        objAccessartificialFrame34 = ArtificialStackFrames.coroutineCreation(fadingEdgeLength, c4, maximumFlingVelocity, 793268735, false, (String) objArr52[0], null);
                    }
                    Object[] objArr53 = (Object[]) ((Field) objAccessartificialFrame34).get(null);
                    objArr4 = new Object[]{new int[1], new int[1], new int[1]};
                    int i68 = ((int[]) objArr53[2])[0];
                    int i69 = ((int[]) objArr53[1])[0];
                    ((int[]) objArr4[2])[0] = i68;
                    ((int[]) objArr4[1])[0] = i69;
                    int iIdentityHashCode = System.identityHashCode(this);
                    int i70 = (-1171741263) + (((~(1342177085 | iIdentityHashCode)) | 9444664) * (-756)) + (((~iIdentityHashCode) | 1342177085) * 756) + 1460681364;
                    int i71 = (i70 << 13) ^ i70;
                    int i72 = i71 ^ (i71 >>> 17);
                    ((int[]) objArr4[0])[0] = i72 ^ (i72 << 5);
                }
                obj = objArr4[1];
                i8 = ((int[]) obj)[0];
                obj2 = objArr4[2];
                i9 = ((int[]) obj2)[0];
                if (i9 == i8) {
                    Object[] objArr54 = {new int[1], new int[1], new int[1]};
                    int i73 = ((int[]) objArr4[0])[0];
                    int i74 = ((int[]) obj2)[0];
                    int i75 = ((int[]) obj)[0];
                    ((int[]) objArr54[2])[0] = i74;
                    ((int[]) objArr54[1])[0] = i75;
                    int i76 = ~((~System.identityHashCode(this)) | 810225743);
                    int i77 = i73 + (((269094985 | i76) * (-374)) - 1605509545) + ((i76 | 541130758) * 374);
                    int i78 = (i77 << 13) ^ i77;
                    int i79 = i78 ^ (i78 >>> 17);
                    i10 = 0;
                    ((int[]) objArr54[0])[0] = i79 ^ (i79 << 5);
                } else {
                    Object[] objArr55 = {Long.valueOf(((long) (i8 ^ i9)) ^ (((long) (-1609972590)) << 32)), Long.valueOf(-1609968494)};
                    byte[] bArr19 = $$d;
                    byte b11 = bArr19[8];
                    byte b12 = bArr19[346];
                    Object[] objArr56 = new Object[1];
                    c(b11, b12, (short) (b12 | 445), objArr56);
                    Class<?> cls7 = Class.forName((String) objArr56[0]);
                    Object[] objArr57 = new Object[1];
                    c(bArr19[97], bArr19[0], (short) 445, objArr57);
                    cls7.getMethod((String) objArr57[0], Long.TYPE, Long.TYPE).invoke(null, objArr55);
                    Object[] objArr58 = {new int[1], new int[1], new int[1]};
                    int i80 = ((int[]) objArr4[0])[0];
                    int i81 = ((int[]) objArr4[2])[0];
                    int i82 = ((int[]) objArr4[1])[0];
                    ((int[]) objArr58[2])[0] = i81;
                    ((int[]) objArr58[1])[0] = i82;
                    int iIdentityHashCode2 = System.identityHashCode(this);
                    int i83 = i80 + (-1421697095) + (((~(iIdentityHashCode2 | 851450308)) | (-500171442)) * (-668)) + ((851450308 | (~((-500171442) | iIdentityHashCode2))) * 1336) + ((iIdentityHashCode2 | (-219152946)) * 668);
                    int i84 = (i83 << 13) ^ i83;
                    int i85 = i84 ^ (i84 >>> 17);
                    i10 = 0;
                    ((int[]) objArr58[0])[0] = i85 ^ (i85 << 5);
                }
                objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(1745676544);
                if (objAccessartificialFrame10 == null) {
                    int iIndexOf6 = 16 - TextUtils.indexOf((CharSequence) "", '0', i10, i10);
                    char keyRepeatTimeout3 = (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16);
                    int i86 = (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 747;
                    byte[] bArr20 = $$a;
                    Object[] objArr59 = new Object[1];
                    b(bArr20[8], bArr20[37], bArr20[0], objArr59);
                    objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(iIndexOf6, keyRepeatTimeout3, i86, -144068856, false, (String) objArr59[0], null);
                }
                j3 = ((Field) objAccessartificialFrame10).getLong(null);
                if (j3 != -1 || j3 + 4611686018427387867L < ((Long) Class.forName(str4).getDeclaredMethod(str5, new Class[0]).invoke(null, new Object[0])).longValue()) {
                    baseContext2 = getBaseContext();
                    if (baseContext2 == null) {
                        Object[] objArr60 = new Object[1];
                        a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 9, new char[]{62893, 22787, 4744, 22145, 39232, 29426, 40333, 'v', 35150, 13180, 13629, 65086, 9816, 58417, 60555, 17380, 4331, 65217, 61769, 58069, 4112, 47537, 61656, 59108, 14618, 6023}, objArr60);
                        Class<?> cls8 = Class.forName((String) objArr60[0]);
                        Object[] objArr61 = new Object[1];
                        a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 3, new char[]{7990, 25361, 25627, 56441, 46585, 59274, 3557, 22833, 28112, 57992, 9620, 6486, 1632, 52928, 60555, 17380, 48584, 55263}, objArr61);
                        baseContext2 = (Context) cls8.getMethod((String) objArr61[0], new Class[0]).invoke(null, null);
                    }
                    if (baseContext2 != null) {
                        if ((baseContext2 instanceof ContextWrapper) || ((ContextWrapper) baseContext2).getBaseContext() != null) {
                            baseContext2 = baseContext2.getApplicationContext();
                        } else {
                            baseContext2 = null;
                        }
                    }
                    Object[] objArr62 = {baseContext2, Integer.valueOf(((Integer) Class.forName(str6).getMethod(str3, Object.class).invoke(null, this)).intValue()), 0, -1417497953};
                    byte[] bArr21 = $$d;
                    Object[] objArr63 = new Object[1];
                    c(bArr21[9], bArr21[543], (short) 362, objArr63);
                    Class<?> cls9 = Class.forName((String) objArr63[0]);
                    Object[] objArr64 = new Object[1];
                    c((byte) (bArr21[276] - 1), bArr21[135], (short) 332, objArr64);
                    Object[] objArr65 = (Object[]) cls9.getMethod((String) objArr64[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr62);
                    objAccessartificialFrame11 = ArtificialStackFrames.accessartificialFrame(1575402270);
                    if (objAccessartificialFrame11 == null) {
                        int windowTouchSlop = (ViewConfiguration.getWindowTouchSlop() >> 8) + 17;
                        char windowTouchSlop2 = (char) (ViewConfiguration.getWindowTouchSlop() >> 8);
                        int mode = 747 - View.MeasureSpec.getMode(0);
                        byte[] bArr22 = $$a;
                        Object[] objArr66 = new Object[1];
                        b((byte) (-bArr22[108]), bArr22[37], bArr22[0], objArr66);
                        objAccessartificialFrame11 = ArtificialStackFrames.coroutineCreation(windowTouchSlop, windowTouchSlop2, mode, -1031537386, false, (String) objArr66[0], null);
                    }
                    ((Field) objAccessartificialFrame11).set(null, objArr65);
                    try {
                        Long lValueOf4 = Long.valueOf(((Long) Class.forName(str4).getDeclaredMethod(str5, new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame12 = ArtificialStackFrames.accessartificialFrame(1745676544);
                        if (objAccessartificialFrame12 == null) {
                            int modifierMetaStateMask = ((byte) KeyEvent.getModifierMetaStateMask()) + Ascii.DC2;
                            char c5 = (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                            int edgeSlop4 = 747 - (ViewConfiguration.getEdgeSlop() >> 16);
                            byte[] bArr23 = $$a;
                            Object[] objArr67 = new Object[1];
                            b(bArr23[8], bArr23[37], bArr23[0], objArr67);
                            objAccessartificialFrame12 = ArtificialStackFrames.coroutineCreation(modifierMetaStateMask, c5, edgeSlop4, -144068856, false, (String) objArr67[0], null);
                        }
                        ((Field) objAccessartificialFrame12).set(null, lValueOf4);
                        objArr5 = objArr65;
                    } catch (Exception unused4) {
                        throw new RuntimeException();
                    }
                } else {
                    int i87 = getARTIFICIAL_FRAME_PACKAGE_NAME + 95;
                    artificialFrame = i87 % 128;
                    int i88 = i87 % 2;
                    Object objAccessartificialFrame35 = ArtificialStackFrames.accessartificialFrame(1575402270);
                    if (objAccessartificialFrame35 == null) {
                        int doubleTapTimeout2 = (ViewConfiguration.getDoubleTapTimeout() >> 16) + 17;
                        char maxKeyCode = (char) (KeyEvent.getMaxKeyCode() >> 16);
                        int bitsPerPixel3 = ImageFormat.getBitsPerPixel(0) + 748;
                        byte[] bArr24 = $$a;
                        Object[] objArr68 = new Object[1];
                        b((byte) (-bArr24[108]), bArr24[37], bArr24[0], objArr68);
                        objAccessartificialFrame35 = ArtificialStackFrames.coroutineCreation(doubleTapTimeout2, maxKeyCode, bitsPerPixel3, -1031537386, false, (String) objArr68[0], null);
                    }
                    Object[] objArr69 = (Object[]) ((Field) objAccessartificialFrame35).get(null);
                    objArr5 = new Object[]{list, new int[1], list, new int[]{i}, new int[]{i}};
                    int i89 = ((int[]) objArr69[3])[0];
                    int i90 = ((int[]) objArr69[4])[0];
                    List list = (List) objArr69[0];
                    List list2 = (List) objArr69[2];
                    int iIdentityHashCode3 = System.identityHashCode(this);
                    int i91 = ~iIdentityHashCode3;
                    int i92 = ((1012787965 + (((~((-843820196) | i91)) | (~(iIdentityHashCode3 | (-238371738)))) * 333)) + (((~(iIdentityHashCode3 | (-843820196))) | (~(i91 | (-238371738)))) * 333)) - 1417497953;
                    int i93 = (i92 << 13) ^ i92;
                    int i94 = i93 ^ (i93 >>> 17);
                    ((int[]) objArr5[1])[0] = i94 ^ (i94 << 5);
                }
                i11 = ((int[]) objArr5[4])[0];
                i12 = ((int[]) objArr5[3])[0];
                if (i12 == i11) {
                    int i95 = artificialFrame + 53;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i95 % 128;
                    int i96 = i95 % 2;
                    Object[] objArr70 = {list, new int[1], list, new int[]{i}, new int[]{i}};
                    int i97 = ((int[]) objArr5[1])[0];
                    int i98 = ((int[]) objArr5[3])[0];
                    int i99 = ((int[]) objArr5[4])[0];
                    List list3 = (List) objArr5[0];
                    List list4 = (List) objArr5[2];
                    int startElapsedRealtime = (int) Process.getStartElapsedRealtime();
                    int i100 = i97 + (-2030458348) + (((-272650306) | startElapsedRealtime) * (-627)) + (((~(273838169 | startElapsedRealtime)) | 879286627) * (-627)) + (((~(startElapsedRealtime | 879286627)) | (~((~startElapsedRealtime) | (-273838170)))) * 627);
                    int i101 = (i100 << 13) ^ i100;
                    int i102 = i101 ^ (i101 >>> 17);
                    ((int[]) objArr70[1])[0] = i102 ^ (i102 << 5);
                    i13 = 0;
                } else {
                    ArrayList arrayList4 = new ArrayList();
                    Object[] objArr71 = {objArr5};
                    objAccessartificialFrame13 = ArtificialStackFrames.accessartificialFrame(1804664566);
                    if (objAccessartificialFrame13 == null) {
                        objAccessartificialFrame13 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getKeyRepeatDelay() >> 16) + 41, (char) (12468 - Gravity.getAbsoluteGravity(0, 0)), (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 3641, -185222914, false, "coroutineCreation", new Class[]{Object[].class});
                    }
                    arrayList4.add(((Method) objAccessartificialFrame13).invoke(null, objArr71));
                    Object[] objArr72 = {objArr5};
                    objAccessartificialFrame14 = ArtificialStackFrames.accessartificialFrame(-1243809191);
                    if (objAccessartificialFrame14 == null) {
                        objAccessartificialFrame14 = ArtificialStackFrames.coroutineCreation(40 - ((byte) KeyEvent.getModifierMetaStateMask()), (char) (12468 - (ViewConfiguration.getLongPressTimeout() >> 16)), TextUtils.getOffsetBefore("", 0) + 3642, 716815441, false, "ArtificialStackFrames", new Class[]{Object[].class});
                    }
                    arrayList4.add(((Method) objAccessartificialFrame14).invoke(null, objArr72));
                    Object[] objArr73 = {Long.valueOf(((long) (i11 ^ i12)) ^ (((long) (-507235928)) << 32)), Long.valueOf(-507235936)};
                    byte[] bArr25 = $$d;
                    Object[] objArr74 = new Object[1];
                    c(bArr25[8], bArr25[149], (short) 313, objArr74);
                    Class<?> cls10 = Class.forName((String) objArr74[0]);
                    Object[] objArr75 = new Object[1];
                    c(bArr25[97], bArr25[0], (short) 445, objArr75);
                    cls10.getMethod((String) objArr75[0], Long.TYPE, Long.TYPE).invoke(null, objArr73);
                    Object[] objArr76 = {list, new int[1], list, new int[]{i}, new int[]{i}};
                    int i103 = ((int[]) objArr5[1])[0];
                    int i104 = ((int[]) objArr5[3])[0];
                    int i105 = ((int[]) objArr5[4])[0];
                    List list5 = (List) objArr5[0];
                    List list6 = (List) objArr5[2];
                    int i106 = (int) Runtime.getRuntime().totalMemory();
                    int i107 = ~i106;
                    int i108 = i103 + 2080825246 + (((~((-64925940) | i107)) | 540522518) * (-90)) + (((~((-64925940) | i106)) | (-603961592)) * (-45)) + (((~(i106 | (-540522519))) | (-64925940) | (~(i107 | 540522518))) * 45);
                    int i109 = (i108 << 13) ^ i108;
                    int i110 = i109 ^ (i109 >>> 17);
                    i13 = 0;
                    ((int[]) objArr76[1])[0] = i110 ^ (i110 << 5);
                }
                objAccessartificialFrame15 = ArtificialStackFrames.accessartificialFrame(-444530678);
                if (objAccessartificialFrame15 == null) {
                    int iKeyCodeFromString = KeyEvent.keyCodeFromString("") + 26;
                    char cMakeMeasureSpec = (char) View.MeasureSpec.makeMeasureSpec(i13, i13);
                    int i111 = (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 1040;
                    byte[] bArr26 = $$a;
                    Object[] objArr77 = new Object[1];
                    b(bArr26[8], bArr26[37], bArr26[0], objArr77);
                    objAccessartificialFrame15 = ArtificialStackFrames.coroutineCreation(iKeyCodeFromString, cMakeMeasureSpec, i111, 2061780482, false, (String) objArr77[0], null);
                }
                j4 = ((Field) objAccessartificialFrame15).getLong(null);
                if (j4 != -1 || j4 + 4611686018427387872L < ((Long) Class.forName(str4).getDeclaredMethod(str5, new Class[0]).invoke(null, new Object[0])).longValue()) {
                    int iIntValue2 = ((Integer) Class.forName(str6).getMethod(str3, Object.class).invoke(null, this)).intValue();
                    Object[] objArr78 = {-1589130824};
                    objAccessartificialFrame16 = ArtificialStackFrames.accessartificialFrame(-1648942878);
                    if (objAccessartificialFrame16 == null) {
                        objAccessartificialFrame16 = ArtificialStackFrames.coroutineCreation(8 - KeyEvent.normalizeMetaState(0), (char) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 22250), 1033 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), 47343338, false, null, new Class[]{Integer.TYPE});
                    }
                    Object[] objArrAccessartificialFrame$78cbbd35 = SchemaManager$$ExternalSyntheticLambda5.accessartificialFrame$78cbbd35(iIntValue2, 0, ((Constructor) objAccessartificialFrame16).newInstance(objArr78), -987693152, false);
                    objAccessartificialFrame17 = ArtificialStackFrames.accessartificialFrame(-614804952);
                    if (objAccessartificialFrame17 == null) {
                        int scrollBarFadeDuration2 = 26 - (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                        char deadChar = (char) KeyEvent.getDeadChar(0, 0);
                        int packedPositionChild2 = 1040 - ExpandableListView.getPackedPositionChild(0L);
                        byte[] bArr27 = $$a;
                        Object[] objArr79 = new Object[1];
                        b((byte) (-bArr27[108]), bArr27[37], bArr27[0], objArr79);
                        objAccessartificialFrame17 = ArtificialStackFrames.coroutineCreation(scrollBarFadeDuration2, deadChar, packedPositionChild2, 1145017376, false, (String) objArr79[0], null);
                    }
                    ((Field) objAccessartificialFrame17).set(null, objArrAccessartificialFrame$78cbbd35);
                    try {
                        Long lValueOf5 = Long.valueOf(((Long) Class.forName(str4).getDeclaredMethod(str5, new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame18 = ArtificialStackFrames.accessartificialFrame(-444530678);
                        if (objAccessartificialFrame18 == null) {
                            int iIndexOf7 = TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 27;
                            char c6 = (char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) - 1);
                            int i112 = 1042 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                            byte[] bArr28 = $$a;
                            Object[] objArr80 = new Object[1];
                            b(bArr28[8], bArr28[37], bArr28[0], objArr80);
                            objAccessartificialFrame18 = ArtificialStackFrames.coroutineCreation(iIndexOf7, c6, i112, 2061780482, false, (String) objArr80[0], null);
                        }
                        ((Field) objAccessartificialFrame18).set(null, lValueOf5);
                        objArr6 = objArrAccessartificialFrame$78cbbd35;
                    } catch (Exception unused5) {
                        throw new RuntimeException();
                    }
                } else {
                    Object objAccessartificialFrame36 = ArtificialStackFrames.accessartificialFrame(-614804952);
                    if (objAccessartificialFrame36 == null) {
                        int maximumFlingVelocity2 = (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 26;
                        char cIndexOf2 = (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0));
                        int iRed2 = Color.red(0) + 1041;
                        byte[] bArr29 = $$a;
                        Object[] objArr81 = new Object[1];
                        b((byte) (-bArr29[108]), bArr29[37], bArr29[0], objArr81);
                        objAccessartificialFrame36 = ArtificialStackFrames.coroutineCreation(maximumFlingVelocity2, cIndexOf2, iRed2, 1145017376, false, (String) objArr81[0], null);
                    }
                    Object[] objArr82 = (Object[]) ((Field) objAccessartificialFrame36).get(null);
                    objArr6 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
                    int i113 = ((int[]) objArr82[3])[0];
                    int i114 = ((int[]) objArr82[2])[0];
                    String[] strArr7 = (String[]) objArr82[0];
                    int iIdentityHashCode4 = System.identityHashCode(this);
                    int i115 = ~(382711059 | iIdentityHashCode4);
                    int i116 = ~iIdentityHashCode4;
                    int i117 = i115 | (~(460814866 | i116));
                    int i118 = ~((-382711060) | i116);
                    int i119 = ((((-1389577114) + ((i117 | i118) * (-516))) + (((~(iIdentityHashCode4 | (-154159617))) | (~((-306655251) | i116))) * 516)) + ((306655250 | i118) * 516)) - 987693152;
                    int i120 = (i119 << 13) ^ i119;
                    int i121 = i120 ^ (i120 >>> 17);
                    ((int[]) objArr6[1])[0] = i121 ^ (i121 << 5);
                }
                i14 = ((int[]) objArr6[2])[0];
                i15 = ((int[]) objArr6[3])[0];
                if (i15 == i14) {
                    Object[] objArr83 = {strArr, new int[1], new int[]{i}, new int[]{i}};
                    int i122 = ((int[]) objArr6[1])[0];
                    int i123 = ((int[]) objArr6[3])[0];
                    int i124 = ((int[]) objArr6[2])[0];
                    String[] strArr8 = (String[]) objArr6[0];
                    int iNextInt = new Random().nextInt(1294961144);
                    int i125 = ~((-36161025) | iNextInt);
                    int i126 = ~iNextInt;
                    int i127 = i122 + 707377632 + ((i125 | (~((-1579033) | i126))) * 497) + (((~(iNextInt | (-1579033))) | (~((-40363751) | i126)) | 4202726) * 497);
                    int i128 = (i127 << 13) ^ i127;
                    int i129 = i128 ^ (i128 >>> 17);
                    ((int[]) objArr83[1])[0] = i129 ^ (i129 << 5);
                } else {
                    arrayList2 = new ArrayList();
                    strArr2 = (String[]) objArr6[0];
                    if (strArr2 != null) {
                        for (String str10 : strArr2) {
                            arrayList2.add(str10);
                        }
                    }
                    long j9 = (((long) (-1114126466)) << 32) ^ ((long) (i14 ^ i15));
                    long j10 = -1114126468;
                    int i130 = artificialFrame + 93;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i130 % 128;
                    int i131 = i130 % 2;
                    Object[] objArr84 = {Long.valueOf(j9), Long.valueOf(j10)};
                    byte[] bArr30 = $$d;
                    byte b13 = bArr30[8];
                    byte b14 = bArr30[130];
                    Object[] objArr85 = new Object[1];
                    c(b13, b14, (short) (b14 | 208), objArr85);
                    Class<?> cls11 = Class.forName((String) objArr85[0]);
                    Object[] objArr86 = new Object[1];
                    c(bArr30[97], bArr30[0], (short) 445, objArr86);
                    cls11.getMethod((String) objArr86[0], Long.TYPE, Long.TYPE).invoke(null, objArr84);
                    Object[] objArr87 = {strArr, new int[1], new int[]{i}, new int[]{i}};
                    int i132 = ((int[]) objArr6[1])[0];
                    int i133 = ((int[]) objArr6[3])[0];
                    int i134 = ((int[]) objArr6[2])[0];
                    String[] strArr9 = (String[]) objArr6[0];
                    int iNextInt2 = new Random().nextInt();
                    int i135 = i132 + (-526179202) + (((~((-134760708) | (~iNextInt2))) | (~((-56656901) | iNextInt2))) * (-272)) + (((~((-480070076) | iNextInt2)) | 345309368) * (-272)) + (((~(iNextInt2 | 480070075)) | (-401966269)) * 272);
                    int i136 = (i135 << 13) ^ i135;
                    int i137 = i136 ^ (i136 >>> 17);
                    ((int[]) objArr87[1])[0] = i137 ^ (i137 << 5);
                }
                super.onStart();
                objAccessartificialFrame19 = ArtificialStackFrames.accessartificialFrame(-1283093189);
                if (objAccessartificialFrame19 == null) {
                    int gidForName2 = 29 - Process.getGidForName("");
                    char cLastIndexOf4 = (char) (49361 - TextUtils.lastIndexOf("", '0'));
                    int iIndexOf8 = 684 - TextUtils.indexOf("", "");
                    byte b15 = (byte) (-$$a[14]);
                    Object[] objArr88 = new Object[1];
                    b((byte) 55, b15, (byte) (b15 | 40), objArr88);
                    objAccessartificialFrame19 = ArtificialStackFrames.coroutineCreation(gidForName2, cLastIndexOf4, iIndexOf8, 752929587, false, (String) objArr88[0], null);
                }
                j5 = ((Field) objAccessartificialFrame19).getLong(null);
                if (j5 != -1) {
                    int i138 = getARTIFICIAL_FRAME_PACKAGE_NAME + 81;
                    artificialFrame = i138 % 128;
                    int i139 = i138 % 2;
                    i17 = 0;
                    if (j5 + 2007 >= ((Long) Class.forName(str4).getDeclaredMethod(str5, new Class[0]).invoke(null, new Object[0])).longValue()) {
                        objAccessartificialFrame29 = ArtificialStackFrames.accessartificialFrame(-326560385);
                        if (objAccessartificialFrame29 == null) {
                            int offsetAfter = TextUtils.getOffsetAfter("", 0) + 30;
                            char windowTouchSlop3 = (char) (49362 - (ViewConfiguration.getWindowTouchSlop() >> 8));
                            int doubleTapTimeout3 = 684 - (ViewConfiguration.getDoubleTapTimeout() >> 16);
                            byte b16 = (byte) ($$b + 2);
                            byte[] bArr31 = $$a;
                            Object[] objArr89 = new Object[1];
                            b(b16, (byte) (-bArr31[14]), (byte) (bArr31[53] + 1), objArr89);
                            objAccessartificialFrame29 = ArtificialStackFrames.coroutineCreation(offsetAfter, windowTouchSlop3, doubleTapTimeout3, 1944867703, false, (String) objArr89[0], null);
                        }
                        Object[] objArr90 = (Object[]) ((Field) objAccessartificialFrame29).get(null);
                        objArr7 = new Object[]{new int[]{((int[]) objArr90[0])[0]}, new int[]{((int[]) objArr90[1])[0]}, new int[1], (String) objArr90[3]};
                        int i140 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 1151037849;
                        int i141 = ~i140;
                        int i142 = (((962704210 + (((~(538403344 | i141)) | 438835470) * (-108))) + (((~(i141 | 440220430)) | ((~((-440220431) | i140)) | 537018384)) * 54)) + ((i140 | 537018384) * 54)) - 636245279;
                        int i143 = (i142 << 13) ^ i142;
                        int i144 = i143 ^ (i143 >>> 17);
                        ((int[]) objArr7[2])[0] = i144 ^ (i144 << 5);
                    }
                    i18 = ((int[]) objArr7[1])[0];
                    i19 = ((int[]) objArr7[0])[0];
                    if (i19 == i18) {
                        int i145 = ((int[]) objArr7[2])[0];
                        Object[] objArr91 = {new int[]{((int[]) objArr7[0])[0]}, new int[]{((int[]) objArr7[1])[0]}, new int[1], (String) objArr7[3]};
                        int iMyPid = Process.myPid();
                        int i146 = i145 + (((~((-6448357) | iMyPid)) | 17604) * (-283)) + 983605706 + ((~(iMyPid | (-6430753))) * 283);
                        int i147 = (i146 << 13) ^ i146;
                        int i148 = i147 ^ (i147 >>> 17);
                        ((int[]) objArr91[2])[0] = i148 ^ (i148 << 5);
                    } else {
                        Object[] objArr92 = {Long.valueOf(((long) (i18 ^ i19)) ^ (((long) (-1690506437)) << 32)), Long.valueOf(-1690506433)};
                        byte[] bArr32 = $$d;
                        Object[] objArr93 = new Object[1];
                        c(bArr32[8], bArr32[544], (short) 175, objArr93);
                        Class<?> cls12 = Class.forName((String) objArr93[0]);
                        Object[] objArr94 = new Object[1];
                        c(bArr32[97], bArr32[0], (short) 445, objArr94);
                        cls12.getMethod((String) objArr94[0], Long.TYPE, Long.TYPE).invoke(null, objArr92);
                        int i149 = ((int[]) objArr7[2])[0];
                        Object[] objArr95 = {new int[]{((int[]) objArr7[0])[0]}, new int[]{((int[]) objArr7[1])[0]}, new int[1], (String) objArr7[3]};
                        int iIdentityHashCode5 = System.identityHashCode(this);
                        int i150 = ~iIdentityHashCode5;
                        int i151 = i149 + (-101946199) + (((~((-762241958) | i150)) | 216381817) * (-602)) + (((~(iIdentityHashCode5 | (-762241958))) | 207921441 | (~(770702333 | i150))) * (-301)) + ((~(i150 | 216381817)) * 301);
                        int i152 = (i151 << 13) ^ i151;
                        int i153 = i152 ^ (i152 >>> 17);
                        ((int[]) objArr95[2])[0] = i153 ^ (i153 << 5);
                    }
                    objAccessartificialFrame22 = ArtificialStackFrames.accessartificialFrame(1056123296);
                    if (objAccessartificialFrame22 == null) {
                        int i154 = (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 29;
                        char windowTouchSlop4 = (char) ((ViewConfiguration.getWindowTouchSlop() >> 8) + 49362);
                        int gidForName3 = Process.getGidForName("") + 685;
                        byte b17 = (byte) ($$b | 17);
                        byte[] bArr33 = $$a;
                        Object[] objArr96 = new Object[1];
                        b(b17, bArr33[46], (byte) (bArr33[53] + 1), objArr96);
                        objAccessartificialFrame22 = ArtificialStackFrames.coroutineCreation(i154, windowTouchSlop4, gidForName3, -1583976536, false, (String) objArr96[0], null);
                    }
                    j6 = ((Field) objAccessartificialFrame22).getLong(null);
                    if (j6 != -1 || j6 + 2017 < ((Long) Class.forName(str4).getDeclaredMethod(str5, new Class[0]).invoke(null, new Object[0])).longValue()) {
                        int iIntValue3 = ((Integer) Class.forName(str6).getMethod(str3, Object.class).invoke(null, this)).intValue();
                        int i155 = getARTIFICIAL_FRAME_PACKAGE_NAME + 117;
                        artificialFrame = i155 % 128;
                        int i156 = i155 % 2;
                        Object[] objArr97 = {Integer.valueOf(iIntValue3), -846915731};
                        byte[] bArr34 = $$d;
                        Object[] objArr98 = new Object[1];
                        c(bArr34[8], (byte) (-bArr34[3]), (short) 151, objArr98);
                        Class<?> cls13 = Class.forName((String) objArr98[0]);
                        Object[] objArr99 = new Object[1];
                        c(bArr34[8], bArr34[4], (short) 97, objArr99);
                        objArr8 = (Object[]) cls13.getMethod((String) objArr99[0], Integer.TYPE, Integer.TYPE).invoke(null, objArr97);
                        objAccessartificialFrame23 = ArtificialStackFrames.accessartificialFrame(910856866);
                        if (objAccessartificialFrame23 == null) {
                            int i157 = 30 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                            char c7 = (char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 49361);
                            int windowTouchSlop5 = 684 - (ViewConfiguration.getWindowTouchSlop() >> 8);
                            Object[] objArr100 = new Object[1];
                            b((byte) 97, $$a[37], (byte) 40, objArr100);
                            objAccessartificialFrame23 = ArtificialStackFrames.coroutineCreation(i157, c7, windowTouchSlop5, -1456483158, false, (String) objArr100[0], null);
                        }
                        ((Field) objAccessartificialFrame23).set(null, objArr8);
                        try {
                            Long lValueOf6 = Long.valueOf(((Long) Class.forName(str4).getDeclaredMethod(str5, new Class[0]).invoke(null, new Object[0])).longValue());
                            objAccessartificialFrame24 = ArtificialStackFrames.accessartificialFrame(1056123296);
                            if (objAccessartificialFrame24 == null) {
                                int absoluteGravity2 = 30 - Gravity.getAbsoluteGravity(0, 0);
                                char tapTimeout = (char) ((ViewConfiguration.getTapTimeout() >> 16) + 49362);
                                int iResolveSize2 = View.resolveSize(0, 0) + 684;
                                byte b18 = (byte) ($$b | 17);
                                byte[] bArr35 = $$a;
                                Object[] objArr101 = new Object[1];
                                b(b18, bArr35[46], (byte) (bArr35[53] + 1), objArr101);
                                objAccessartificialFrame24 = ArtificialStackFrames.coroutineCreation(absoluteGravity2, tapTimeout, iResolveSize2, -1583976536, false, (String) objArr101[0], null);
                            }
                            ((Field) objAccessartificialFrame24).set(null, lValueOf6);
                        } catch (Exception unused6) {
                            throw new RuntimeException();
                        }
                    } else {
                        Object objAccessartificialFrame37 = ArtificialStackFrames.accessartificialFrame(910856866);
                        if (objAccessartificialFrame37 == null) {
                            int minimumFlingVelocity = 30 - (ViewConfiguration.getMinimumFlingVelocity() >> 16);
                            char trimmedLength2 = (char) (TextUtils.getTrimmedLength("") + 49362);
                            int i158 = 684 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                            Object[] objArr102 = new Object[1];
                            b((byte) 97, $$a[37], (byte) 40, objArr102);
                            objAccessartificialFrame37 = ArtificialStackFrames.coroutineCreation(minimumFlingVelocity, trimmedLength2, i158, -1456483158, false, (String) objArr102[0], null);
                        }
                        Object[] objArr103 = (Object[]) ((Field) objAccessartificialFrame37).get(null);
                        objArr8 = new Object[]{new int[]{((int[]) objArr103[0])[0]}, new int[]{((int[]) objArr103[1])[0]}, new int[1], (String) objArr103[3]};
                        int i159 = ~((~System.identityHashCode(this)) | 626165849);
                        int i160 = ((((542148632 | i159) * (-374)) + 521081144) + ((i159 | 84017217) * 374)) - 846915731;
                        int i161 = (i160 << 13) ^ i160;
                        int i162 = i161 ^ (i161 >>> 17);
                        ((int[]) objArr8[2])[0] = i162 ^ (i162 << 5);
                    }
                    i20 = ((int[]) objArr8[1])[0];
                    i21 = ((int[]) objArr8[0])[0];
                    if (i21 == i20) {
                        int i163 = ((int[]) objArr8[2])[0];
                        Object[] objArr104 = {new int[]{((int[]) objArr8[0])[0]}, new int[]{((int[]) objArr8[1])[0]}, new int[1], (String) objArr8[3]};
                        int i164 = ~System.identityHashCode(this);
                        int i165 = i163 + 1957293886 + (((~(i164 | 14280421)) | (-972814078)) * (-160)) + (((~(i164 | (-964343354))) | 14280421) * SyslogConstants.LOG_LOCAL4);
                        int i166 = (i165 << 13) ^ i165;
                        int i167 = i166 ^ (i166 >>> 17);
                        ((int[]) objArr104[2])[0] = i167 ^ (i167 << 5);
                    } else {
                        new ArrayList().add((String) objArr8[3]);
                        Object[] objArr105 = {Long.valueOf(((long) (i20 ^ i21)) ^ (((long) (-1927871676)) << 32)), Long.valueOf(-1927871660)};
                        byte[] bArr36 = $$d;
                        Object[] objArr106 = new Object[1];
                        c(bArr36[8], bArr36[544], (short) 175, objArr106);
                        Class<?> cls14 = Class.forName((String) objArr106[0]);
                        Object[] objArr107 = new Object[1];
                        c(bArr36[97], bArr36[0], (short) 445, objArr107);
                        cls14.getMethod((String) objArr107[0], Long.TYPE, Long.TYPE).invoke(null, objArr105);
                        int i168 = ((int[]) objArr8[2])[0];
                        Object[] objArr108 = {new int[]{((int[]) objArr8[0])[0]}, new int[]{((int[]) objArr8[1])[0]}, new int[1], (String) objArr8[3]};
                        int i169 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().orientation;
                        int i170 = ~((-906507842) | i169);
                        int i171 = ~i169;
                        int i172 = i170 | (~(72115933 | i171));
                        int i173 = ~(906507841 | i171);
                        int i174 = i168 + 2028118702 + ((i172 | i173) * (-516)) + (((~(i169 | (-67642946))) | (~((-4472989) | i171))) * 516) + ((4472988 | i173) * 516);
                        int i175 = (i174 << 13) ^ i174;
                        int i176 = i175 ^ (i175 >>> 17);
                        ((int[]) objArr108[2])[0] = i176 ^ (i176 << 5);
                    }
                    objAccessartificialFrame25 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                    if (objAccessartificialFrame25 == null) {
                        int iAxisFromString2 = MotionEvent.axisFromString("") + 26;
                        char cKeyCodeFromString = (char) (KeyEvent.keyCodeFromString("") + 30068);
                        int edgeSlop5 = (ViewConfiguration.getEdgeSlop() >> 16) + 816;
                        byte[] bArr37 = $$a;
                        Object[] objArr109 = new Object[1];
                        b(bArr37[8], bArr37[37], bArr37[0], objArr109);
                        objAccessartificialFrame25 = ArtificialStackFrames.coroutineCreation(iAxisFromString2, cKeyCodeFromString, edgeSlop5, 721586079, false, (String) objArr109[0], null);
                    }
                    j7 = ((Field) objAccessartificialFrame25).getLong(null);
                    if (j7 != -1 || j7 + 1879 < ((Long) Class.forName(str4).getDeclaredMethod(str5, new Class[0]).invoke(null, new Object[0])).longValue()) {
                        Object[] objArr110 = {Integer.valueOf(((Integer) Class.forName(str6).getMethod(str3, Object.class).invoke(null, this)).intValue()), 0, 130081871};
                        objAccessartificialFrame26 = ArtificialStackFrames.accessartificialFrame(1327366003);
                        if (objAccessartificialFrame26 == null) {
                            int keyRepeatTimeout4 = (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 25;
                            char fadingEdgeLength2 = (char) (30068 - (ViewConfiguration.getFadingEdgeLength() >> 16));
                            int iResolveOpacity = 816 - Drawable.resolveOpacity(0, 0);
                            byte[] bArr38 = $$a;
                            Object[] objArr111 = new Object[1];
                            b((byte) 105, bArr38[4], bArr38[8], objArr111);
                            objAccessartificialFrame26 = ArtificialStackFrames.coroutineCreation(keyRepeatTimeout4, fadingEdgeLength2, iResolveOpacity, -797394565, false, (String) objArr111[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                        }
                        objArr9 = (Object[]) ((Method) objAccessartificialFrame26).invoke(null, objArr110);
                        objAccessartificialFrame27 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                        if (objAccessartificialFrame27 == null) {
                            int offsetAfter2 = TextUtils.getOffsetAfter("", 0) + 25;
                            char packedPositionChild3 = (char) (30067 - ExpandableListView.getPackedPositionChild(0L));
                            int iCombineMeasuredStates = View.combineMeasuredStates(0, 0) + 816;
                            byte[] bArr39 = $$a;
                            Object[] objArr112 = new Object[1];
                            b((byte) (-bArr39[108]), bArr39[37], bArr39[0], objArr112);
                            objAccessartificialFrame27 = ArtificialStackFrames.coroutineCreation(offsetAfter2, packedPositionChild3, iCombineMeasuredStates, 891606461, false, (String) objArr112[0], null);
                        }
                        ((Field) objAccessartificialFrame27).set(null, objArr9);
                        try {
                            Long lValueOf7 = Long.valueOf(((Long) Class.forName(str4).getDeclaredMethod(str5, new Class[0]).invoke(null, new Object[0])).longValue());
                            objAccessartificialFrame28 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                            if (objAccessartificialFrame28 == null) {
                                int iKeyCodeFromString2 = 25 - KeyEvent.keyCodeFromString("");
                                char packedPositionGroup = (char) (ExpandableListView.getPackedPositionGroup(0L) + 30068);
                                int keyRepeatDelay = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 816;
                                byte[] bArr40 = $$a;
                                Object[] objArr113 = new Object[1];
                                b(bArr40[8], bArr40[37], bArr40[0], objArr113);
                                objAccessartificialFrame28 = ArtificialStackFrames.coroutineCreation(iKeyCodeFromString2, packedPositionGroup, keyRepeatDelay, 721586079, false, (String) objArr113[0], null);
                            }
                            ((Field) objAccessartificialFrame28).set(null, lValueOf7);
                        } catch (Exception unused7) {
                            throw new RuntimeException();
                        }
                    } else {
                        Object objAccessartificialFrame38 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                        if (objAccessartificialFrame38 == null) {
                            int jumpTapTimeout = (ViewConfiguration.getJumpTapTimeout() >> 16) + 25;
                            char scrollBarFadeDuration3 = (char) ((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 30068);
                            int packedPositionGroup2 = ExpandableListView.getPackedPositionGroup(0L) + 816;
                            byte[] bArr41 = $$a;
                            Object[] objArr114 = new Object[1];
                            b((byte) (-bArr41[108]), bArr41[37], bArr41[0], objArr114);
                            objAccessartificialFrame38 = ArtificialStackFrames.coroutineCreation(jumpTapTimeout, scrollBarFadeDuration3, packedPositionGroup2, 891606461, false, (String) objArr114[0], null);
                        }
                        Object[] objArr115 = (Object[]) ((Field) objAccessartificialFrame38).get(null);
                        objArr9 = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
                        int i177 = ((int[]) objArr115[0])[0];
                        int i178 = ((int[]) objArr115[1])[0];
                        String[] strArr10 = (String[]) objArr115[2];
                        int i179 = (~System.identityHashCode(this)) | 832084648;
                        int i180 = (-52452644) + (i179 * 495) + (((~i179) | 269484064) * 495) + 130081871;
                        int i181 = (i180 << 13) ^ i180;
                        int i182 = i181 ^ (i181 >>> 17);
                        ((int[]) objArr9[3])[0] = i182 ^ (i182 << 5);
                    }
                    i22 = ((int[]) objArr9[1])[0];
                    i23 = ((int[]) objArr9[0])[0];
                    if (i23 == i22) {
                        Object[] objArr116 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
                        int i183 = ((int[]) objArr9[3])[0];
                        int i184 = ((int[]) objArr9[0])[0];
                        int i185 = ((int[]) objArr9[1])[0];
                        String[] strArr11 = (String[]) objArr9[2];
                        int iIdentityHashCode6 = System.identityHashCode(this);
                        int i186 = ~iIdentityHashCode6;
                        int i187 = i183 + 2139009251 + (((~(239320162 | i186)) | (-508804979)) * 98) + (((~(i186 | (-437492529))) | 239320162 | (~(437492528 | iIdentityHashCode6))) * (-49)) + (((~(iIdentityHashCode6 | 239320162)) | 71312450) * 49);
                        int i188 = (i187 << 13) ^ i187;
                        int i189 = i188 ^ (i188 >>> 17);
                        ((int[]) objArr116[3])[0] = i189 ^ (i189 << 5);
                        return;
                    }
                    arrayList3 = new ArrayList();
                    strArr3 = (String[]) objArr9[2];
                    if (strArr3 != null) {
                        for (String str11 : strArr3) {
                            arrayList3.add(str11);
                        }
                    }
                    long j11 = (((long) 1773973861) << 32) ^ ((long) (i22 ^ i23));
                    long j12 = 1773973860;
                    int i190 = getARTIFICIAL_FRAME_PACKAGE_NAME + 45;
                    artificialFrame = i190 % 128;
                    int i191 = i190 % 2;
                    Object[] objArr117 = {Long.valueOf(j11), Long.valueOf(j12)};
                    byte[] bArr42 = $$d;
                    Object[] objArr118 = new Object[1];
                    c(bArr42[8], bArr42[435], (short) (-bArr42[545]), objArr118);
                    Class<?> cls15 = Class.forName((String) objArr118[0]);
                    Object[] objArr119 = new Object[1];
                    c(bArr42[97], bArr42[0], (short) 445, objArr119);
                    cls15.getMethod((String) objArr119[0], Long.TYPE, Long.TYPE).invoke(null, objArr117);
                    Object[] objArr120 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
                    int i192 = ((int[]) objArr9[3])[0];
                    int i193 = ((int[]) objArr9[0])[0];
                    int i194 = ((int[]) objArr9[1])[0];
                    String[] strArr12 = (String[]) objArr9[2];
                    int i195 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().screenWidthDp;
                    int i196 = ~i195;
                    int i197 = i192 + 1789800286 + (((~(441466843 | i196)) | (-1047543804)) * 98) + (((~(i196 | (-639639210))) | 441466843 | (~(639639209 | i195))) * (-49)) + (((~(i195 | 441466843)) | 407904594) * 49);
                    int i198 = (i197 << 13) ^ i197;
                    int i199 = i198 ^ (i198 >>> 17);
                    ((int[]) objArr120[3])[0] = i199 ^ (i199 << 5);
                }
                i17 = 0;
                baseContext3 = getBaseContext();
                if (baseContext3 == null) {
                    Object[] objArr121 = new Object[1];
                    a(TextUtils.indexOf((CharSequence) "", '0', i17) + 27, new char[]{62893, 22787, 4744, 22145, 39232, 29426, 40333, 'v', 35150, 13180, 13629, 65086, 9816, 58417, 60555, 17380, 4331, 65217, 61769, 58069, 4112, 47537, 61656, 59108, 14618, 6023}, objArr121);
                    Class<?> cls16 = Class.forName((String) objArr121[i17]);
                    Object[] objArr122 = new Object[1];
                    a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[i17]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 17, new char[]{7990, 25361, 25627, 56441, 46585, 59274, 3557, 22833, 28112, 57992, 9620, 6486, 1632, 52928, 60555, 17380, 48584, 55263}, objArr122);
                    baseContext3 = (Context) cls16.getMethod((String) objArr122[0], new Class[0]).invoke(null, null);
                }
                if (baseContext3 != null) {
                    if ((baseContext3 instanceof ContextWrapper) || ((ContextWrapper) baseContext3).getBaseContext() != null) {
                        baseContext3 = baseContext3.getApplicationContext();
                    } else {
                        baseContext3 = null;
                    }
                }
                Object[] objArr123 = {baseContext3, Integer.valueOf(((Integer) Class.forName(str6).getMethod(str3, Object.class).invoke(null, this)).intValue()), 0, -636245279};
                byte[] bArr43 = $$d;
                Object[] objArr124 = new Object[1];
                c(bArr43[8], (byte) (-bArr43[2]), (short) JfifUtil.MARKER_RST0, objArr124);
                Class<?> cls17 = Class.forName((String) objArr124[0]);
                Object[] objArr125 = new Object[1];
                c((byte) (bArr43[276] - 1), bArr43[135], (short) 332, objArr125);
                objArr7 = (Object[]) cls17.getMethod((String) objArr125[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr123);
                if (baseContext3 != null) {
                    int i200 = getARTIFICIAL_FRAME_PACKAGE_NAME + 25;
                    artificialFrame = i200 % 128;
                    int i201 = i200 % 2;
                    objAccessartificialFrame20 = ArtificialStackFrames.accessartificialFrame(-326560385);
                    if (objAccessartificialFrame20 == null) {
                        int jumpTapTimeout2 = (ViewConfiguration.getJumpTapTimeout() >> 16) + 30;
                        char cLastIndexOf5 = (char) (49361 - TextUtils.lastIndexOf("", '0', 0, 0));
                        int packedPositionType2 = 684 - ExpandableListView.getPackedPositionType(0L);
                        byte b19 = (byte) ($$b + 2);
                        byte[] bArr44 = $$a;
                        Object[] objArr126 = new Object[1];
                        b(b19, (byte) (-bArr44[14]), (byte) (bArr44[53] + 1), objArr126);
                        objAccessartificialFrame20 = ArtificialStackFrames.coroutineCreation(jumpTapTimeout2, cLastIndexOf5, packedPositionType2, 1944867703, false, (String) objArr126[0], null);
                    }
                    ((Field) objAccessartificialFrame20).set(null, objArr7);
                    try {
                        Long lValueOf8 = Long.valueOf(((Long) Class.forName(str4).getDeclaredMethod(str5, new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame21 = ArtificialStackFrames.accessartificialFrame(-1283093189);
                        if (objAccessartificialFrame21 == null) {
                            int gidForName4 = 29 - Process.getGidForName("");
                            char c8 = (char) ((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 49362);
                            int longPressTimeout = (ViewConfiguration.getLongPressTimeout() >> 16) + 684;
                            byte b20 = (byte) (-$$a[14]);
                            Object[] objArr127 = new Object[1];
                            b((byte) 55, b20, (byte) (b20 | 40), objArr127);
                            objAccessartificialFrame21 = ArtificialStackFrames.coroutineCreation(gidForName4, c8, longPressTimeout, 752929587, false, (String) objArr127[0], null);
                        }
                        ((Field) objAccessartificialFrame21).set(null, lValueOf8);
                    } catch (Exception unused8) {
                        throw new RuntimeException();
                    }
                }
                i18 = ((int[]) objArr7[1])[0];
                i19 = ((int[]) objArr7[0])[0];
                if (i19 == i18) {
                    int i1410 = ((int[]) objArr7[2])[0];
                    Object[] objArr910 = {new int[]{((int[]) objArr7[0])[0]}, new int[]{((int[]) objArr7[1])[0]}, new int[1], (String) objArr7[3]};
                    int iMyPid2 = Process.myPid();
                    int i1411 = i1410 + (((~((-6448357) | iMyPid2)) | 17604) * (-283)) + 983605706 + ((~(iMyPid2 | (-6430753))) * 283);
                    int i1412 = (i1411 << 13) ^ i1411;
                    int i1413 = i1412 ^ (i1412 >>> 17);
                    ((int[]) objArr910[2])[0] = i1413 ^ (i1413 << 5);
                } else {
                    Object[] objArr911 = {Long.valueOf(((long) (i18 ^ i19)) ^ (((long) (-1690506437)) << 32)), Long.valueOf(-1690506433)};
                    byte[] bArr310 = $$d;
                    Object[] objArr912 = new Object[1];
                    c(bArr310[8], bArr310[544], (short) 175, objArr912);
                    Class<?> cls18 = Class.forName((String) objArr912[0]);
                    Object[] objArr913 = new Object[1];
                    c(bArr310[97], bArr310[0], (short) 445, objArr913);
                    cls18.getMethod((String) objArr913[0], Long.TYPE, Long.TYPE).invoke(null, objArr911);
                    int i1414 = ((int[]) objArr7[2])[0];
                    Object[] objArr914 = {new int[]{((int[]) objArr7[0])[0]}, new int[]{((int[]) objArr7[1])[0]}, new int[1], (String) objArr7[3]};
                    int iIdentityHashCode7 = System.identityHashCode(this);
                    int i1510 = ~iIdentityHashCode7;
                    int i1511 = i1414 + (-101946199) + (((~((-762241958) | i1510)) | 216381817) * (-602)) + (((~(iIdentityHashCode7 | (-762241958))) | 207921441 | (~(770702333 | i1510))) * (-301)) + ((~(i1510 | 216381817)) * 301);
                    int i1512 = (i1511 << 13) ^ i1511;
                    int i1513 = i1512 ^ (i1512 >>> 17);
                    ((int[]) objArr914[2])[0] = i1513 ^ (i1513 << 5);
                }
                objAccessartificialFrame22 = ArtificialStackFrames.accessartificialFrame(1056123296);
                if (objAccessartificialFrame22 == null) {
                    int i1514 = (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 29;
                    char windowTouchSlop6 = (char) ((ViewConfiguration.getWindowTouchSlop() >> 8) + 49362);
                    int gidForName5 = Process.getGidForName("") + 685;
                    byte b110 = (byte) ($$b | 17);
                    byte[] bArr311 = $$a;
                    Object[] objArr915 = new Object[1];
                    b(b110, bArr311[46], (byte) (bArr311[53] + 1), objArr915);
                    objAccessartificialFrame22 = ArtificialStackFrames.coroutineCreation(i1514, windowTouchSlop6, gidForName5, -1583976536, false, (String) objArr915[0], null);
                }
                j6 = ((Field) objAccessartificialFrame22).getLong(null);
                if (j6 != -1) {
                    int iIntValue4 = ((Integer) Class.forName(str6).getMethod(str3, Object.class).invoke(null, this)).intValue();
                    int i1515 = getARTIFICIAL_FRAME_PACKAGE_NAME + 117;
                    artificialFrame = i1515 % 128;
                    int i1516 = i1515 % 2;
                    Object[] objArr916 = {Integer.valueOf(iIntValue4), -846915731};
                    byte[] bArr312 = $$d;
                    Object[] objArr917 = new Object[1];
                    c(bArr312[8], (byte) (-bArr312[3]), (short) 151, objArr917);
                    Class<?> cls19 = Class.forName((String) objArr917[0]);
                    Object[] objArr918 = new Object[1];
                    c(bArr312[8], bArr312[4], (short) 97, objArr918);
                    objArr8 = (Object[]) cls19.getMethod((String) objArr918[0], Integer.TYPE, Integer.TYPE).invoke(null, objArr916);
                    objAccessartificialFrame23 = ArtificialStackFrames.accessartificialFrame(910856866);
                    if (objAccessartificialFrame23 == null) {
                        int i1517 = 30 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                        char c9 = (char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 49361);
                        int windowTouchSlop7 = 684 - (ViewConfiguration.getWindowTouchSlop() >> 8);
                        Object[] objArr1010 = new Object[1];
                        b((byte) 97, $$a[37], (byte) 40, objArr1010);
                        objAccessartificialFrame23 = ArtificialStackFrames.coroutineCreation(i1517, c9, windowTouchSlop7, -1456483158, false, (String) objArr1010[0], null);
                    }
                    ((Field) objAccessartificialFrame23).set(null, objArr8);
                    Long lValueOf9 = Long.valueOf(((Long) Class.forName(str4).getDeclaredMethod(str5, new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame24 = ArtificialStackFrames.accessartificialFrame(1056123296);
                    if (objAccessartificialFrame24 == null) {
                        int absoluteGravity3 = 30 - Gravity.getAbsoluteGravity(0, 0);
                        char tapTimeout2 = (char) ((ViewConfiguration.getTapTimeout() >> 16) + 49362);
                        int iResolveSize3 = View.resolveSize(0, 0) + 684;
                        byte b111 = (byte) ($$b | 17);
                        byte[] bArr313 = $$a;
                        Object[] objArr1011 = new Object[1];
                        b(b111, bArr313[46], (byte) (bArr313[53] + 1), objArr1011);
                        objAccessartificialFrame24 = ArtificialStackFrames.coroutineCreation(absoluteGravity3, tapTimeout2, iResolveSize3, -1583976536, false, (String) objArr1011[0], null);
                    }
                    ((Field) objAccessartificialFrame24).set(null, lValueOf9);
                } else {
                    int iIntValue5 = ((Integer) Class.forName(str6).getMethod(str3, Object.class).invoke(null, this)).intValue();
                    int i1518 = getARTIFICIAL_FRAME_PACKAGE_NAME + 117;
                    artificialFrame = i1518 % 128;
                    int i1519 = i1518 % 2;
                    Object[] objArr919 = {Integer.valueOf(iIntValue5), -846915731};
                    byte[] bArr314 = $$d;
                    Object[] objArr9110 = new Object[1];
                    c(bArr314[8], (byte) (-bArr314[3]), (short) 151, objArr9110);
                    Class<?> cls110 = Class.forName((String) objArr9110[0]);
                    Object[] objArr9111 = new Object[1];
                    c(bArr314[8], bArr314[4], (short) 97, objArr9111);
                    objArr8 = (Object[]) cls110.getMethod((String) objArr9111[0], Integer.TYPE, Integer.TYPE).invoke(null, objArr919);
                    objAccessartificialFrame23 = ArtificialStackFrames.accessartificialFrame(910856866);
                    if (objAccessartificialFrame23 == null) {
                        int i15110 = 30 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                        char c10 = (char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 49361);
                        int windowTouchSlop8 = 684 - (ViewConfiguration.getWindowTouchSlop() >> 8);
                        Object[] objArr1012 = new Object[1];
                        b((byte) 97, $$a[37], (byte) 40, objArr1012);
                        objAccessartificialFrame23 = ArtificialStackFrames.coroutineCreation(i15110, c10, windowTouchSlop8, -1456483158, false, (String) objArr1012[0], null);
                    }
                    ((Field) objAccessartificialFrame23).set(null, objArr8);
                    Long lValueOf10 = Long.valueOf(((Long) Class.forName(str4).getDeclaredMethod(str5, new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame24 = ArtificialStackFrames.accessartificialFrame(1056123296);
                    if (objAccessartificialFrame24 == null) {
                        int absoluteGravity4 = 30 - Gravity.getAbsoluteGravity(0, 0);
                        char tapTimeout3 = (char) ((ViewConfiguration.getTapTimeout() >> 16) + 49362);
                        int iResolveSize4 = View.resolveSize(0, 0) + 684;
                        byte b112 = (byte) ($$b | 17);
                        byte[] bArr315 = $$a;
                        Object[] objArr1013 = new Object[1];
                        b(b112, bArr315[46], (byte) (bArr315[53] + 1), objArr1013);
                        objAccessartificialFrame24 = ArtificialStackFrames.coroutineCreation(absoluteGravity4, tapTimeout3, iResolveSize4, -1583976536, false, (String) objArr1013[0], null);
                    }
                    ((Field) objAccessartificialFrame24).set(null, lValueOf10);
                }
                i20 = ((int[]) objArr8[1])[0];
                i21 = ((int[]) objArr8[0])[0];
                if (i21 == i20) {
                    int i1610 = ((int[]) objArr8[2])[0];
                    Object[] objArr1014 = {new int[]{((int[]) objArr8[0])[0]}, new int[]{((int[]) objArr8[1])[0]}, new int[1], (String) objArr8[3]};
                    int i1611 = ~System.identityHashCode(this);
                    int i1612 = i1610 + 1957293886 + (((~(i1611 | 14280421)) | (-972814078)) * (-160)) + (((~(i1611 | (-964343354))) | 14280421) * SyslogConstants.LOG_LOCAL4);
                    int i1613 = (i1612 << 13) ^ i1612;
                    int i1614 = i1613 ^ (i1613 >>> 17);
                    ((int[]) objArr1014[2])[0] = i1614 ^ (i1614 << 5);
                } else {
                    new ArrayList().add((String) objArr8[3]);
                    Object[] objArr1015 = {Long.valueOf(((long) (i20 ^ i21)) ^ (((long) (-1927871676)) << 32)), Long.valueOf(-1927871660)};
                    byte[] bArr316 = $$d;
                    Object[] objArr1016 = new Object[1];
                    c(bArr316[8], bArr316[544], (short) 175, objArr1016);
                    Class<?> cls111 = Class.forName((String) objArr1016[0]);
                    Object[] objArr1017 = new Object[1];
                    c(bArr316[97], bArr316[0], (short) 445, objArr1017);
                    cls111.getMethod((String) objArr1017[0], Long.TYPE, Long.TYPE).invoke(null, objArr1015);
                    int i1615 = ((int[]) objArr8[2])[0];
                    Object[] objArr1018 = {new int[]{((int[]) objArr8[0])[0]}, new int[]{((int[]) objArr8[1])[0]}, new int[1], (String) objArr8[3]};
                    int i1616 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().orientation;
                    int i1710 = ~((-906507842) | i1616);
                    int i1711 = ~i1616;
                    int i1712 = i1710 | (~(72115933 | i1711));
                    int i1713 = ~(906507841 | i1711);
                    int i1714 = i1615 + 2028118702 + ((i1712 | i1713) * (-516)) + (((~(i1616 | (-67642946))) | (~((-4472989) | i1711))) * 516) + ((4472988 | i1713) * 516);
                    int i1715 = (i1714 << 13) ^ i1714;
                    int i1716 = i1715 ^ (i1715 >>> 17);
                    ((int[]) objArr1018[2])[0] = i1716 ^ (i1716 << 5);
                }
                objAccessartificialFrame25 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                if (objAccessartificialFrame25 == null) {
                    int iAxisFromString3 = MotionEvent.axisFromString("") + 26;
                    char cKeyCodeFromString2 = (char) (KeyEvent.keyCodeFromString("") + 30068);
                    int edgeSlop6 = (ViewConfiguration.getEdgeSlop() >> 16) + 816;
                    byte[] bArr317 = $$a;
                    Object[] objArr1019 = new Object[1];
                    b(bArr317[8], bArr317[37], bArr317[0], objArr1019);
                    objAccessartificialFrame25 = ArtificialStackFrames.coroutineCreation(iAxisFromString3, cKeyCodeFromString2, edgeSlop6, 721586079, false, (String) objArr1019[0], null);
                }
                j7 = ((Field) objAccessartificialFrame25).getLong(null);
                if (j7 != -1) {
                    Object[] objArr1110 = {Integer.valueOf(((Integer) Class.forName(str6).getMethod(str3, Object.class).invoke(null, this)).intValue()), 0, 130081871};
                    objAccessartificialFrame26 = ArtificialStackFrames.accessartificialFrame(1327366003);
                    if (objAccessartificialFrame26 == null) {
                        int keyRepeatTimeout5 = (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 25;
                        char fadingEdgeLength3 = (char) (30068 - (ViewConfiguration.getFadingEdgeLength() >> 16));
                        int iResolveOpacity2 = 816 - Drawable.resolveOpacity(0, 0);
                        byte[] bArr318 = $$a;
                        Object[] objArr1111 = new Object[1];
                        b((byte) 105, bArr318[4], bArr318[8], objArr1111);
                        objAccessartificialFrame26 = ArtificialStackFrames.coroutineCreation(keyRepeatTimeout5, fadingEdgeLength3, iResolveOpacity2, -797394565, false, (String) objArr1111[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                    }
                    objArr9 = (Object[]) ((Method) objAccessartificialFrame26).invoke(null, objArr1110);
                    objAccessartificialFrame27 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                    if (objAccessartificialFrame27 == null) {
                        int offsetAfter3 = TextUtils.getOffsetAfter("", 0) + 25;
                        char packedPositionChild4 = (char) (30067 - ExpandableListView.getPackedPositionChild(0L));
                        int iCombineMeasuredStates2 = View.combineMeasuredStates(0, 0) + 816;
                        byte[] bArr319 = $$a;
                        Object[] objArr1112 = new Object[1];
                        b((byte) (-bArr319[108]), bArr319[37], bArr319[0], objArr1112);
                        objAccessartificialFrame27 = ArtificialStackFrames.coroutineCreation(offsetAfter3, packedPositionChild4, iCombineMeasuredStates2, 891606461, false, (String) objArr1112[0], null);
                    }
                    ((Field) objAccessartificialFrame27).set(null, objArr9);
                    Long lValueOf11 = Long.valueOf(((Long) Class.forName(str4).getDeclaredMethod(str5, new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame28 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                    if (objAccessartificialFrame28 == null) {
                        int iKeyCodeFromString3 = 25 - KeyEvent.keyCodeFromString("");
                        char packedPositionGroup3 = (char) (ExpandableListView.getPackedPositionGroup(0L) + 30068);
                        int keyRepeatDelay2 = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 816;
                        byte[] bArr45 = $$a;
                        Object[] objArr1113 = new Object[1];
                        b(bArr45[8], bArr45[37], bArr45[0], objArr1113);
                        objAccessartificialFrame28 = ArtificialStackFrames.coroutineCreation(iKeyCodeFromString3, packedPositionGroup3, keyRepeatDelay2, 721586079, false, (String) objArr1113[0], null);
                    }
                    ((Field) objAccessartificialFrame28).set(null, lValueOf11);
                } else {
                    Object[] objArr1114 = {Integer.valueOf(((Integer) Class.forName(str6).getMethod(str3, Object.class).invoke(null, this)).intValue()), 0, 130081871};
                    objAccessartificialFrame26 = ArtificialStackFrames.accessartificialFrame(1327366003);
                    if (objAccessartificialFrame26 == null) {
                        int keyRepeatTimeout6 = (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 25;
                        char fadingEdgeLength4 = (char) (30068 - (ViewConfiguration.getFadingEdgeLength() >> 16));
                        int iResolveOpacity3 = 816 - Drawable.resolveOpacity(0, 0);
                        byte[] bArr3110 = $$a;
                        Object[] objArr1115 = new Object[1];
                        b((byte) 105, bArr3110[4], bArr3110[8], objArr1115);
                        objAccessartificialFrame26 = ArtificialStackFrames.coroutineCreation(keyRepeatTimeout6, fadingEdgeLength4, iResolveOpacity3, -797394565, false, (String) objArr1115[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                    }
                    objArr9 = (Object[]) ((Method) objAccessartificialFrame26).invoke(null, objArr1114);
                    objAccessartificialFrame27 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                    if (objAccessartificialFrame27 == null) {
                        int offsetAfter4 = TextUtils.getOffsetAfter("", 0) + 25;
                        char packedPositionChild5 = (char) (30067 - ExpandableListView.getPackedPositionChild(0L));
                        int iCombineMeasuredStates3 = View.combineMeasuredStates(0, 0) + 816;
                        byte[] bArr3111 = $$a;
                        Object[] objArr1116 = new Object[1];
                        b((byte) (-bArr3111[108]), bArr3111[37], bArr3111[0], objArr1116);
                        objAccessartificialFrame27 = ArtificialStackFrames.coroutineCreation(offsetAfter4, packedPositionChild5, iCombineMeasuredStates3, 891606461, false, (String) objArr1116[0], null);
                    }
                    ((Field) objAccessartificialFrame27).set(null, objArr9);
                    Long lValueOf12 = Long.valueOf(((Long) Class.forName(str4).getDeclaredMethod(str5, new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame28 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                    if (objAccessartificialFrame28 == null) {
                        int iKeyCodeFromString4 = 25 - KeyEvent.keyCodeFromString("");
                        char packedPositionGroup4 = (char) (ExpandableListView.getPackedPositionGroup(0L) + 30068);
                        int keyRepeatDelay3 = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 816;
                        byte[] bArr46 = $$a;
                        Object[] objArr1117 = new Object[1];
                        b(bArr46[8], bArr46[37], bArr46[0], objArr1117);
                        objAccessartificialFrame28 = ArtificialStackFrames.coroutineCreation(iKeyCodeFromString4, packedPositionGroup4, keyRepeatDelay3, 721586079, false, (String) objArr1117[0], null);
                    }
                    ((Field) objAccessartificialFrame28).set(null, lValueOf12);
                }
                i22 = ((int[]) objArr9[1])[0];
                i23 = ((int[]) objArr9[0])[0];
                if (i23 == i22) {
                    Object[] objArr1118 = {new int[]{i184}, new int[]{i185}, strArr11, new int[1]};
                    int i1810 = ((int[]) objArr9[3])[0];
                    int i1811 = ((int[]) objArr9[0])[0];
                    int i1812 = ((int[]) objArr9[1])[0];
                    String[] strArr13 = (String[]) objArr9[2];
                    int iIdentityHashCode8 = System.identityHashCode(this);
                    int i1813 = ~iIdentityHashCode8;
                    int i1814 = i1810 + 2139009251 + (((~(239320162 | i1813)) | (-508804979)) * 98) + (((~(i1813 | (-437492529))) | 239320162 | (~(437492528 | iIdentityHashCode8))) * (-49)) + (((~(iIdentityHashCode8 | 239320162)) | 71312450) * 49);
                    int i1815 = (i1814 << 13) ^ i1814;
                    int i1816 = i1815 ^ (i1815 >>> 17);
                    ((int[]) objArr1118[3])[0] = i1816 ^ (i1816 << 5);
                    return;
                }
                arrayList3 = new ArrayList();
                strArr3 = (String[]) objArr9[2];
                if (strArr3 != null) {
                    while (i24 < strArr3.length) {
                        arrayList3.add(str11);
                    }
                }
                long j13 = (((long) 1773973861) << 32) ^ ((long) (i22 ^ i23));
                long j14 = 1773973860;
                int i1910 = getARTIFICIAL_FRAME_PACKAGE_NAME + 45;
                artificialFrame = i1910 % 128;
                int i1911 = i1910 % 2;
                Object[] objArr1119 = {Long.valueOf(j13), Long.valueOf(j14)};
                byte[] bArr47 = $$d;
                Object[] objArr1120 = new Object[1];
                c(bArr47[8], bArr47[435], (short) (-bArr47[545]), objArr1120);
                Class<?> cls112 = Class.forName((String) objArr1120[0]);
                Object[] objArr1121 = new Object[1];
                c(bArr47[97], bArr47[0], (short) 445, objArr1121);
                cls112.getMethod((String) objArr1121[0], Long.TYPE, Long.TYPE).invoke(null, objArr1119);
                Object[] objArr128 = {new int[]{i193}, new int[]{i194}, strArr12, new int[1]};
                int i1912 = ((int[]) objArr9[3])[0];
                int i1913 = ((int[]) objArr9[0])[0];
                int i1914 = ((int[]) objArr9[1])[0];
                String[] strArr14 = (String[]) objArr9[2];
                int i1915 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().screenWidthDp;
                int i1916 = ~i1915;
                int i1917 = i1912 + 1789800286 + (((~(441466843 | i1916)) | (-1047543804)) * 98) + (((~(i1916 | (-639639210))) | 441466843 | (~(639639209 | i1915))) * (-49)) + (((~(i1915 | 441466843)) | 407904594) * 49);
                int i1918 = (i1917 << 13) ^ i1917;
                int i1919 = i1918 ^ (i1918 >>> 17);
                ((int[]) objArr128[3])[0] = i1919 ^ (i1919 << 5);
            } catch (Throwable th3) {
                Throwable cause3 = th3.getCause();
                if (cause3 == null) {
                    throw th3;
                }
                throw cause3;
            }
        }
        Object objAccessartificialFrame39 = ArtificialStackFrames.accessartificialFrame(777251007);
        if (objAccessartificialFrame39 == null) {
            int longPressTimeout2 = (ViewConfiguration.getLongPressTimeout() >> 16) + 30;
            char cArgb = (char) (Color.argb(0, 0, 0, 0) + 49362);
            int bitsPerPixel4 = ImageFormat.getBitsPerPixel(0) + 685;
            byte[] bArr48 = $$a;
            Object[] objArr129 = new Object[1];
            b(bArr48[37], bArr48[107], (byte) (-bArr48[34]), objArr129);
            objAccessartificialFrame39 = ArtificialStackFrames.coroutineCreation(longPressTimeout2, cArgb, bitsPerPixel4, -1321816393, false, (String) objArr129[0], null);
        }
        Object[] objArr130 = (Object[]) ((Field) objAccessartificialFrame39).get(null);
        objArr = new Object[]{new int[]{((int[]) objArr130[0])[0]}, new int[]{((int[]) objArr130[1])[0]}, new int[1], (String) objArr130[3]};
        int iNextInt3 = new Random().nextInt(1360891157);
        int i202 = (-1267991058) + (((~(771748413 | iNextInt3)) | (-771750654) | (~(206875361 | iNextInt3))) * (-744)) + (((~iNextInt3) | 206873121) * 744) + ((iNextInt3 | 771750653) * 744) + 1713277000;
        int i203 = (i202 << 13) ^ i202;
        int i204 = i203 ^ (i203 >>> 17);
        ((int[]) objArr[2])[0] = i204 ^ (i204 << 5);
        str = str7;
        i3 = ((int[]) objArr[1])[0];
        i4 = ((int[]) objArr[0])[0];
        if (i4 == i3) {
            int i210 = ((int[]) objArr[2])[0];
            Object[] objArr210 = {new int[]{((int[]) objArr[0])[0]}, new int[]{((int[]) objArr[1])[0]}, new int[1], (String) objArr[3]};
            int iMaxMemory2 = (int) Runtime.getRuntime().maxMemory();
            int i211 = i210 + ((~((~iMaxMemory2) | (-541725193))) * 130) + 1251113838 + (((~(iMaxMemory2 | (-541725193))) | 83904720) * 130);
            int i310 = (i211 << 13) ^ i211;
            int i311 = i310 ^ (i310 >>> 17);
            ((int[]) objArr210[2])[0] = i311 ^ (i311 << 5);
        } else {
            Object[] objArr211 = {Long.valueOf(((long) (i3 ^ i4)) ^ (((long) (-1248174732)) << 32)), Long.valueOf(-1248174220)};
            byte[] bArr49 = $$d;
            byte b21 = bArr49[8];
            byte b22 = bArr49[346];
            Object[] objArr212 = new Object[1];
            c(b21, b22, (short) (b22 | 445), objArr212);
            Class<?> cls20 = Class.forName((String) objArr212[0]);
            Object[] objArr213 = new Object[1];
            c(bArr49[97], bArr49[0], (short) 445, objArr213);
            cls20.getMethod((String) objArr213[0], Long.TYPE, Long.TYPE).invoke(null, objArr211);
            int i312 = ((int[]) objArr[2])[0];
            Object[] objArr214 = {new int[]{((int[]) objArr[0])[0]}, new int[]{((int[]) objArr[1])[0]}, new int[1], (String) objArr[3]};
            int iCodePointAt2 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(17) + 1679106015;
            int i313 = ~iCodePointAt2;
            int i314 = i312 + (((~(i313 | 245747311)) | (~((-732876464) | i313)) | (~((-245747312) | iCodePointAt2))) * 959) + 1525956300 + (((~(iCodePointAt2 | 245747311)) | (~(i313 | (-245747312))) | (~((-732876464) | iCodePointAt2))) * 959);
            int i315 = (i314 << 13) ^ i314;
            int i316 = i315 ^ (i315 >>> 17);
            ((int[]) objArr214[2])[0] = i316 ^ (i316 << 5);
        }
        objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1313006081);
        if (objAccessartificialFrame2 == null) {
            int iIndexOf9 = TextUtils.indexOf((CharSequence) "", '0') + 22;
            char c11 = (char) (1 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)));
            int gidForName6 = Process.getGidForName("") + 466;
            byte[] bArr50 = $$a;
            Object[] objArr215 = new Object[1];
            b(bArr50[8], bArr50[37], bArr50[0], objArr215);
            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iIndexOf9, c11, gidForName6, -785931255, false, (String) objArr215[0], null);
        }
        j = ((Field) objAccessartificialFrame2).getLong(null);
        if (j != -1) {
            baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr310 = new Object[1];
                a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(1) - 23, new char[]{62893, 22787, 4744, 22145, 39232, 29426, 40333, 'v', 35150, 13180, 13629, 65086, 9816, 58417, 60555, 17380, 4331, 65217, 61769, 58069, 4112, 47537, 61656, 59108, 14618, 6023}, objArr310);
                Class<?> cls21 = Class.forName((String) objArr310[0]);
                Object[] objArr311 = new Object[1];
                a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 3, new char[]{7990, 25361, 25627, 56441, 46585, 59274, 3557, 22833, 28112, 57992, 9620, 6486, 1632, 52928, 60555, 17380, 48584, 55263}, objArr311);
                baseContext = (Context) cls21.getMethod((String) objArr311[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                if (baseContext instanceof ContextWrapper) {
                    baseContext = baseContext.getApplicationContext();
                } else {
                    baseContext = baseContext.getApplicationContext();
                }
            }
            str3 = str;
            int iIntValue6 = ((Integer) Class.forName(str6).getMethod(str3, Object.class).invoke(null, this)).intValue();
            Object[] objArr312 = new Object[1];
            a(AndroidCharacter.getMirror('0') + 16, new char[]{45449, 5312, 24732, 9522, 50892, 47744, 56311, 23020, 36658, 26522, 47076, 7487, 14365, 35694, 34447, 7290, 47130, 64522, 19573, 56030, 60151, 35938, 34447, 7290, 52210, 19639, 17398, 27519, 45436, 1039, 60973, 31834, 288, 5284, 35921, 54951, 34447, 7290, 63792, 3498, 8826, 54630, 288, 5284, 24809, 33407, 64539, 40566, 46052, 54920, 32843, 62463, 24783, 32787, 64678, 26513, 8826, 54630, 15901, 31583, 4291, 46401, 55028, 36782}, objArr312);
            String str12 = (String) objArr312[0];
            Object[] objArr313 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 29, new char[]{4105, 11591, 8065, 53458, 60973, 31834, 8049, 16285, 12674, 47602, 41468, 6261, 10076, 47780, 36143, 39377, 53438, 48055, 2806, 64062, 63433, 13419, 47076, 7487, 24783, 32787, 31950, 30079, 2435, 39006, 10266, 7541, 32844, 39592, 52026, 59282, 47076, 7487, 59867, 53557, 19806, 55833, 30497, 3784, 17398, 27519, 24732, 9522, 8363, 5410, 63433, 13419, 13146, 22382, 25055, 43329, 38272, 37923, 28178, 4396, 63764, 58406, 45127, 56283}, objArr313);
            Object[] objArr314 = {baseContext, new String[]{str12, (String) objArr313[0]}, Integer.valueOf(iIntValue6), 1, 1310855002};
            byte[] bArr51 = $$d;
            Object[] objArr315 = new Object[1];
            c(bArr51[43], bArr51[429], (short) 443, objArr315);
            Class<?> cls22 = Class.forName((String) objArr315[0]);
            Object[] objArr316 = new Object[1];
            c(bArr51[45], (byte) (bArr51[49] - 1), (short) 531, objArr316);
            objArr2 = (Object[]) cls22.getMethod((String) objArr316[0], Context.class, String[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr314);
            int i317 = ((int[]) objArr2[0])[0];
            int i318 = ((int[]) objArr2[3])[0];
            if (baseContext != null) {
                objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(1142731807);
                if (objAccessartificialFrame3 == null) {
                    int bitsPerPixel5 = 20 - ImageFormat.getBitsPerPixel(0);
                    char cIndexOf3 = (char) TextUtils.indexOf("", "", 0);
                    int packedPositionType3 = ExpandableListView.getPackedPositionType(0L) + 465;
                    byte[] bArr110 = $$a;
                    Object[] objArr317 = new Object[1];
                    b((byte) (-bArr110[108]), bArr110[37], bArr110[0], objArr317);
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(bitsPerPixel5, cIndexOf3, packedPositionType3, -612765161, false, (String) objArr317[0], null);
                }
                ((Field) objAccessartificialFrame3).set(null, objArr2);
                Long lValueOf13 = Long.valueOf(((Long) Class.forName(str4).getDeclaredMethod(str5, new Class[0]).invoke(null, new Object[0])).longValue());
                objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1313006081);
                if (objAccessartificialFrame4 == null) {
                    int iIndexOf10 = TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 22;
                    char cResolveSizeAndState2 = (char) View.resolveSizeAndState(0, 0, 0);
                    int i319 = 466 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                    byte[] bArr111 = $$a;
                    Object[] objArr318 = new Object[1];
                    b(bArr111[8], bArr111[37], bArr111[0], objArr318);
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(iIndexOf10, cResolveSizeAndState2, i319, -785931255, false, (String) objArr318[0], null);
                }
                ((Field) objAccessartificialFrame4).set(null, lValueOf13);
            } else {
                objArr2 = objArr2;
            }
            objArr3 = objArr2;
        } else {
            baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr319 = new Object[1];
                a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(1) - 23, new char[]{62893, 22787, 4744, 22145, 39232, 29426, 40333, 'v', 35150, 13180, 13629, 65086, 9816, 58417, 60555, 17380, 4331, 65217, 61769, 58069, 4112, 47537, 61656, 59108, 14618, 6023}, objArr319);
                Class<?> cls23 = Class.forName((String) objArr319[0]);
                Object[] objArr3110 = new Object[1];
                a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 3, new char[]{7990, 25361, 25627, 56441, 46585, 59274, 3557, 22833, 28112, 57992, 9620, 6486, 1632, 52928, 60555, 17380, 48584, 55263}, objArr3110);
                baseContext = (Context) cls23.getMethod((String) objArr3110[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                if (baseContext instanceof ContextWrapper) {
                    baseContext = baseContext.getApplicationContext();
                } else {
                    baseContext = baseContext.getApplicationContext();
                }
            }
            str3 = str;
            int iIntValue7 = ((Integer) Class.forName(str6).getMethod(str3, Object.class).invoke(null, this)).intValue();
            Object[] objArr3111 = new Object[1];
            a(AndroidCharacter.getMirror('0') + 16, new char[]{45449, 5312, 24732, 9522, 50892, 47744, 56311, 23020, 36658, 26522, 47076, 7487, 14365, 35694, 34447, 7290, 47130, 64522, 19573, 56030, 60151, 35938, 34447, 7290, 52210, 19639, 17398, 27519, 45436, 1039, 60973, 31834, 288, 5284, 35921, 54951, 34447, 7290, 63792, 3498, 8826, 54630, 288, 5284, 24809, 33407, 64539, 40566, 46052, 54920, 32843, 62463, 24783, 32787, 64678, 26513, 8826, 54630, 15901, 31583, 4291, 46401, 55028, 36782}, objArr3111);
            String str13 = (String) objArr3111[0];
            Object[] objArr3112 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 29, new char[]{4105, 11591, 8065, 53458, 60973, 31834, 8049, 16285, 12674, 47602, 41468, 6261, 10076, 47780, 36143, 39377, 53438, 48055, 2806, 64062, 63433, 13419, 47076, 7487, 24783, 32787, 31950, 30079, 2435, 39006, 10266, 7541, 32844, 39592, 52026, 59282, 47076, 7487, 59867, 53557, 19806, 55833, 30497, 3784, 17398, 27519, 24732, 9522, 8363, 5410, 63433, 13419, 13146, 22382, 25055, 43329, 38272, 37923, 28178, 4396, 63764, 58406, 45127, 56283}, objArr3112);
            Object[] objArr3113 = {baseContext, new String[]{str13, (String) objArr3112[0]}, Integer.valueOf(iIntValue7), 1, 1310855002};
            byte[] bArr52 = $$d;
            Object[] objArr3114 = new Object[1];
            c(bArr52[43], bArr52[429], (short) 443, objArr3114);
            Class<?> cls24 = Class.forName((String) objArr3114[0]);
            Object[] objArr3115 = new Object[1];
            c(bArr52[45], (byte) (bArr52[49] - 1), (short) 531, objArr3115);
            objArr2 = (Object[]) cls24.getMethod((String) objArr3115[0], Context.class, String[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr3113);
            int i3110 = ((int[]) objArr2[0])[0];
            int i3111 = ((int[]) objArr2[3])[0];
            if (baseContext != null) {
                objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(1142731807);
                if (objAccessartificialFrame3 == null) {
                    int bitsPerPixel6 = 20 - ImageFormat.getBitsPerPixel(0);
                    char cIndexOf4 = (char) TextUtils.indexOf("", "", 0);
                    int packedPositionType4 = ExpandableListView.getPackedPositionType(0L) + 465;
                    byte[] bArr112 = $$a;
                    Object[] objArr3116 = new Object[1];
                    b((byte) (-bArr112[108]), bArr112[37], bArr112[0], objArr3116);
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(bitsPerPixel6, cIndexOf4, packedPositionType4, -612765161, false, (String) objArr3116[0], null);
                }
                ((Field) objAccessartificialFrame3).set(null, objArr2);
                Long lValueOf14 = Long.valueOf(((Long) Class.forName(str4).getDeclaredMethod(str5, new Class[0]).invoke(null, new Object[0])).longValue());
                objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1313006081);
                if (objAccessartificialFrame4 == null) {
                    int iIndexOf11 = TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 22;
                    char cResolveSizeAndState3 = (char) View.resolveSizeAndState(0, 0, 0);
                    int i3112 = 466 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                    byte[] bArr113 = $$a;
                    Object[] objArr3117 = new Object[1];
                    b(bArr113[8], bArr113[37], bArr113[0], objArr3117);
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(iIndexOf11, cResolveSizeAndState3, i3112, -785931255, false, (String) objArr3117[0], null);
                }
                ((Field) objAccessartificialFrame4).set(null, lValueOf14);
            } else {
                objArr2 = objArr2;
            }
            objArr3 = objArr2;
        }
        i5 = ((int[]) objArr3[0])[0];
        i6 = ((int[]) objArr3[3])[0];
        if (i6 == i5) {
            int i510 = artificialFrame + 113;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i510 % 128;
            int i511 = i510 % 2;
            Object[] objArr410 = {new int[]{i54}, strArr5, new int[1], new int[]{i53}};
            int i512 = ((int[]) objArr3[2])[0];
            int i513 = ((int[]) objArr3[3])[0];
            int i514 = ((int[]) objArr3[0])[0];
            String[] strArr15 = (String[]) objArr3[1];
            int i515 = ~System.identityHashCode(this);
            int i516 = i512 + (-2088359324) + ((~((-640459017) | i515)) * (-783)) + (((~(i515 | (-774759723))) | (-935109449)) * 783);
            int i517 = (i516 << 13) ^ i516;
            int i518 = i517 ^ (i517 >>> 17);
            ((int[]) objArr410[2])[0] = i518 ^ (i518 << 5);
        } else {
            arrayList = new ArrayList();
            strArr = (String[]) objArr3[1];
            if (strArr != null) {
                while (i7 < strArr.length) {
                    arrayList.add(str9);
                }
            }
            Object[] objArr411 = {Long.valueOf((((long) 1121676644) << 32) ^ ((long) (i5 ^ i6))), Long.valueOf(1121676580)};
            byte[] bArr114 = $$d;
            Object[] objArr412 = new Object[1];
            c(bArr114[8], bArr114[130], (short) 404, objArr412);
            Class<?> cls25 = Class.forName((String) objArr412[0]);
            Object[] objArr413 = new Object[1];
            c(bArr114[97], bArr114[0], (short) 445, objArr413);
            cls25.getMethod((String) objArr413[0], Long.TYPE, Long.TYPE).invoke(null, objArr411);
            Object[] objArr414 = {new int[]{i61}, strArr6, new int[1], new int[]{i60}};
            int i519 = ((int[]) objArr3[2])[0];
            int i610 = ((int[]) objArr3[3])[0];
            int i611 = ((int[]) objArr3[0])[0];
            String[] strArr16 = (String[]) objArr3[1];
            int i612 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().screenWidthDp;
            int i613 = ~i612;
            int i614 = i519 + (((~((-56659033) | i612)) | (~((-103690694) | i613)) | (~(i613 | 56659032))) * 959) + 330158620 + (((~(i612 | 56659032)) | (~(i613 | (-56659033))) | (~((-103690694) | i612))) * 959);
            int i615 = (i614 << 13) ^ i614;
            int i616 = i615 ^ (i615 >>> 17);
            i26 = 0;
            ((int[]) objArr414[2])[0] = i616 ^ (i616 << 5);
        }
        objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1168947751);
        if (objAccessartificialFrame5 == null) {
            int scrollDefaultDelay2 = (ViewConfiguration.getScrollDefaultDelay() >> 16) + 36;
            char cResolveSize2 = (char) View.resolveSize(i26, i26);
            int iIndexOf12 = TextUtils.indexOf((CharSequence) "", '0', i26, i26) + 541;
            byte[] bArr115 = $$a;
            Object[] objArr415 = new Object[1];
            b(bArr115[8], bArr115[37], bArr115[i26], objArr415);
            objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(scrollDefaultDelay2, cResolveSize2, iIndexOf12, 624296913, false, (String) objArr415[i26], null);
        }
        j2 = ((Field) objAccessartificialFrame5).getLong(null);
        if (j2 != -1) {
            objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1717965552);
            if (objAccessartificialFrame6 == null) {
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(20 - View.combineMeasuredStates(0, 0), (char) (KeyEvent.normalizeMetaState(0) + 39516), (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 982, 117222168, false, null, new Class[0]);
            }
            Object[] objArr416 = {null, ((Constructor) objAccessartificialFrame6).newInstance(null), 1460681364, 0};
            objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-501205803);
            if (objAccessartificialFrame7 == null) {
                int iResolveSize5 = 36 - View.resolveSize(0, 0);
                char cAxisFromString2 = (char) (MotionEvent.axisFromString("") + 1);
                int defaultSize2 = View.getDefaultSize(0, 0) + 540;
                byte[] bArr116 = $$a;
                byte b23 = (byte) (bArr116[6] - 1);
                byte b113 = (byte) (bArr116[24] - 1);
                Object[] objArr417 = new Object[1];
                b(b23, b113, b113, objArr417);
                objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(iResolveSize5, cAxisFromString2, defaultSize2, 2101703389, false, (String) objArr417[0], new Class[]{(Class) ArtificialStackFrames.coroutineCreation(54 - (ViewConfiguration.getTapTimeout() >> 16), (char) (((Process.getThreadPriority(0) + 20) >> 6) + 833), 576 - (ViewConfiguration.getKeyRepeatTimeout() >> 16)), (Class) ArtificialStackFrames.coroutineCreation(TextUtils.getCapsMode("", 0, 0) + 54, (char) View.MeasureSpec.getMode(0), 631 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))), Integer.TYPE, Integer.TYPE});
            }
            Object[] objArr418 = (Object[]) ((Method) objAccessartificialFrame7).invoke(null, objArr416);
            objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-1339222025);
            if (objAccessartificialFrame8 == null) {
                int i617 = (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 35;
                char c12 = (char) (1 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)));
                int iLastIndexOf3 = 539 - TextUtils.lastIndexOf("", '0', 0, 0);
                byte[] bArr117 = $$a;
                Object[] objArr510 = new Object[1];
                b((byte) (-bArr117[108]), bArr117[37], bArr117[0], objArr510);
                objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(i617, c12, iLastIndexOf3, 793268735, false, (String) objArr510[0], null);
            }
            ((Field) objAccessartificialFrame8).set(null, objArr418);
            Long lValueOf15 = Long.valueOf(((Long) Class.forName(str4).getDeclaredMethod(str5, new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(-1168947751);
            if (objAccessartificialFrame9 == null) {
                int trimmedLength3 = TextUtils.getTrimmedLength("") + 36;
                char edgeSlop7 = (char) (ViewConfiguration.getEdgeSlop() >> 16);
                int iRed3 = Color.red(0) + 540;
                byte[] bArr118 = $$a;
                Object[] objArr511 = new Object[1];
                b(bArr118[8], bArr118[37], bArr118[0], objArr511);
                objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(trimmedLength3, edgeSlop7, iRed3, 624296913, false, (String) objArr511[0], null);
            }
            ((Field) objAccessartificialFrame9).set(null, lValueOf15);
            objArr4 = objArr418;
        } else {
            objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1717965552);
            if (objAccessartificialFrame6 == null) {
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(20 - View.combineMeasuredStates(0, 0), (char) (KeyEvent.normalizeMetaState(0) + 39516), (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 982, 117222168, false, null, new Class[0]);
            }
            Object[] objArr419 = {null, ((Constructor) objAccessartificialFrame6).newInstance(null), 1460681364, 0};
            objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-501205803);
            if (objAccessartificialFrame7 == null) {
                int iResolveSize6 = 36 - View.resolveSize(0, 0);
                char cAxisFromString3 = (char) (MotionEvent.axisFromString("") + 1);
                int defaultSize3 = View.getDefaultSize(0, 0) + 540;
                byte[] bArr119 = $$a;
                byte b24 = (byte) (bArr119[6] - 1);
                byte b114 = (byte) (bArr119[24] - 1);
                Object[] objArr4110 = new Object[1];
                b(b24, b114, b114, objArr4110);
                objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(iResolveSize6, cAxisFromString3, defaultSize3, 2101703389, false, (String) objArr4110[0], new Class[]{(Class) ArtificialStackFrames.coroutineCreation(54 - (ViewConfiguration.getTapTimeout() >> 16), (char) (((Process.getThreadPriority(0) + 20) >> 6) + 833), 576 - (ViewConfiguration.getKeyRepeatTimeout() >> 16)), (Class) ArtificialStackFrames.coroutineCreation(TextUtils.getCapsMode("", 0, 0) + 54, (char) View.MeasureSpec.getMode(0), 631 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))), Integer.TYPE, Integer.TYPE});
            }
            Object[] objArr4111 = (Object[]) ((Method) objAccessartificialFrame7).invoke(null, objArr419);
            objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-1339222025);
            if (objAccessartificialFrame8 == null) {
                int i618 = (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 35;
                char c13 = (char) (1 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)));
                int iLastIndexOf4 = 539 - TextUtils.lastIndexOf("", '0', 0, 0);
                byte[] bArr1110 = $$a;
                Object[] objArr512 = new Object[1];
                b((byte) (-bArr1110[108]), bArr1110[37], bArr1110[0], objArr512);
                objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(i618, c13, iLastIndexOf4, 793268735, false, (String) objArr512[0], null);
            }
            ((Field) objAccessartificialFrame8).set(null, objArr4111);
            Long lValueOf16 = Long.valueOf(((Long) Class.forName(str4).getDeclaredMethod(str5, new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(-1168947751);
            if (objAccessartificialFrame9 == null) {
                int trimmedLength4 = TextUtils.getTrimmedLength("") + 36;
                char edgeSlop8 = (char) (ViewConfiguration.getEdgeSlop() >> 16);
                int iRed4 = Color.red(0) + 540;
                byte[] bArr1111 = $$a;
                Object[] objArr513 = new Object[1];
                b(bArr1111[8], bArr1111[37], bArr1111[0], objArr513);
                objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(trimmedLength4, edgeSlop8, iRed4, 624296913, false, (String) objArr513[0], null);
            }
            ((Field) objAccessartificialFrame9).set(null, lValueOf16);
            objArr4 = objArr4111;
        }
        obj = objArr4[1];
        i8 = ((int[]) obj)[0];
        obj2 = objArr4[2];
        i9 = ((int[]) obj2)[0];
        if (i9 == i8) {
            Object[] objArr514 = {new int[1], new int[1], new int[1]};
            int i710 = ((int[]) objArr4[0])[0];
            int i711 = ((int[]) obj2)[0];
            int i712 = ((int[]) obj)[0];
            ((int[]) objArr514[2])[0] = i711;
            ((int[]) objArr514[1])[0] = i712;
            int i713 = ~((~System.identityHashCode(this)) | 810225743);
            int i714 = i710 + (((269094985 | i713) * (-374)) - 1605509545) + ((i713 | 541130758) * 374);
            int i715 = (i714 << 13) ^ i714;
            int i716 = i715 ^ (i715 >>> 17);
            i10 = 0;
            ((int[]) objArr514[0])[0] = i716 ^ (i716 << 5);
        } else {
            Object[] objArr515 = {Long.valueOf(((long) (i8 ^ i9)) ^ (((long) (-1609972590)) << 32)), Long.valueOf(-1609968494)};
            byte[] bArr120 = $$d;
            byte b115 = bArr120[8];
            byte b116 = bArr120[346];
            Object[] objArr516 = new Object[1];
            c(b115, b116, (short) (b116 | 445), objArr516);
            Class<?> cls26 = Class.forName((String) objArr516[0]);
            Object[] objArr517 = new Object[1];
            c(bArr120[97], bArr120[0], (short) 445, objArr517);
            cls26.getMethod((String) objArr517[0], Long.TYPE, Long.TYPE).invoke(null, objArr515);
            Object[] objArr518 = {new int[1], new int[1], new int[1]};
            int i810 = ((int[]) objArr4[0])[0];
            int i811 = ((int[]) objArr4[2])[0];
            int i812 = ((int[]) objArr4[1])[0];
            ((int[]) objArr518[2])[0] = i811;
            ((int[]) objArr518[1])[0] = i812;
            int iIdentityHashCode9 = System.identityHashCode(this);
            int i813 = i810 + (-1421697095) + (((~(iIdentityHashCode9 | 851450308)) | (-500171442)) * (-668)) + ((851450308 | (~((-500171442) | iIdentityHashCode9))) * 1336) + ((iIdentityHashCode9 | (-219152946)) * 668);
            int i814 = (i813 << 13) ^ i813;
            int i815 = i814 ^ (i814 >>> 17);
            i10 = 0;
            ((int[]) objArr518[0])[0] = i815 ^ (i815 << 5);
        }
        objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(1745676544);
        if (objAccessartificialFrame10 == null) {
            int iIndexOf13 = 16 - TextUtils.indexOf((CharSequence) "", '0', i10, i10);
            char keyRepeatTimeout7 = (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16);
            int i816 = (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 747;
            byte[] bArr210 = $$a;
            Object[] objArr519 = new Object[1];
            b(bArr210[8], bArr210[37], bArr210[0], objArr519);
            objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(iIndexOf13, keyRepeatTimeout7, i816, -144068856, false, (String) objArr519[0], null);
        }
        j3 = ((Field) objAccessartificialFrame10).getLong(null);
        if (j3 != -1) {
            baseContext2 = getBaseContext();
            if (baseContext2 == null) {
                Object[] objArr610 = new Object[1];
                a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 9, new char[]{62893, 22787, 4744, 22145, 39232, 29426, 40333, 'v', 35150, 13180, 13629, 65086, 9816, 58417, 60555, 17380, 4331, 65217, 61769, 58069, 4112, 47537, 61656, 59108, 14618, 6023}, objArr610);
                Class<?> cls27 = Class.forName((String) objArr610[0]);
                Object[] objArr611 = new Object[1];
                a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 3, new char[]{7990, 25361, 25627, 56441, 46585, 59274, 3557, 22833, 28112, 57992, 9620, 6486, 1632, 52928, 60555, 17380, 48584, 55263}, objArr611);
                baseContext2 = (Context) cls27.getMethod((String) objArr611[0], new Class[0]).invoke(null, null);
            }
            if (baseContext2 != null) {
                if (baseContext2 instanceof ContextWrapper) {
                    baseContext2 = baseContext2.getApplicationContext();
                } else {
                    baseContext2 = baseContext2.getApplicationContext();
                }
            }
            Object[] objArr612 = {baseContext2, Integer.valueOf(((Integer) Class.forName(str6).getMethod(str3, Object.class).invoke(null, this)).intValue()), 0, -1417497953};
            byte[] bArr211 = $$d;
            Object[] objArr613 = new Object[1];
            c(bArr211[9], bArr211[543], (short) 362, objArr613);
            Class<?> cls28 = Class.forName((String) objArr613[0]);
            Object[] objArr614 = new Object[1];
            c((byte) (bArr211[276] - 1), bArr211[135], (short) 332, objArr614);
            Object[] objArr615 = (Object[]) cls28.getMethod((String) objArr614[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr612);
            objAccessartificialFrame11 = ArtificialStackFrames.accessartificialFrame(1575402270);
            if (objAccessartificialFrame11 == null) {
                int windowTouchSlop9 = (ViewConfiguration.getWindowTouchSlop() >> 8) + 17;
                char windowTouchSlop10 = (char) (ViewConfiguration.getWindowTouchSlop() >> 8);
                int mode2 = 747 - View.MeasureSpec.getMode(0);
                byte[] bArr212 = $$a;
                Object[] objArr616 = new Object[1];
                b((byte) (-bArr212[108]), bArr212[37], bArr212[0], objArr616);
                objAccessartificialFrame11 = ArtificialStackFrames.coroutineCreation(windowTouchSlop9, windowTouchSlop10, mode2, -1031537386, false, (String) objArr616[0], null);
            }
            ((Field) objAccessartificialFrame11).set(null, objArr615);
            Long lValueOf17 = Long.valueOf(((Long) Class.forName(str4).getDeclaredMethod(str5, new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame12 = ArtificialStackFrames.accessartificialFrame(1745676544);
            if (objAccessartificialFrame12 == null) {
                int modifierMetaStateMask2 = ((byte) KeyEvent.getModifierMetaStateMask()) + Ascii.DC2;
                char c14 = (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                int edgeSlop9 = 747 - (ViewConfiguration.getEdgeSlop() >> 16);
                byte[] bArr213 = $$a;
                Object[] objArr617 = new Object[1];
                b(bArr213[8], bArr213[37], bArr213[0], objArr617);
                objAccessartificialFrame12 = ArtificialStackFrames.coroutineCreation(modifierMetaStateMask2, c14, edgeSlop9, -144068856, false, (String) objArr617[0], null);
            }
            ((Field) objAccessartificialFrame12).set(null, lValueOf17);
            objArr5 = objArr615;
        } else {
            baseContext2 = getBaseContext();
            if (baseContext2 == null) {
                Object[] objArr618 = new Object[1];
                a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 9, new char[]{62893, 22787, 4744, 22145, 39232, 29426, 40333, 'v', 35150, 13180, 13629, 65086, 9816, 58417, 60555, 17380, 4331, 65217, 61769, 58069, 4112, 47537, 61656, 59108, 14618, 6023}, objArr618);
                Class<?> cls29 = Class.forName((String) objArr618[0]);
                Object[] objArr619 = new Object[1];
                a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 3, new char[]{7990, 25361, 25627, 56441, 46585, 59274, 3557, 22833, 28112, 57992, 9620, 6486, 1632, 52928, 60555, 17380, 48584, 55263}, objArr619);
                baseContext2 = (Context) cls29.getMethod((String) objArr619[0], new Class[0]).invoke(null, null);
            }
            if (baseContext2 != null) {
                if (baseContext2 instanceof ContextWrapper) {
                    baseContext2 = baseContext2.getApplicationContext();
                } else {
                    baseContext2 = baseContext2.getApplicationContext();
                }
            }
            Object[] objArr6110 = {baseContext2, Integer.valueOf(((Integer) Class.forName(str6).getMethod(str3, Object.class).invoke(null, this)).intValue()), 0, -1417497953};
            byte[] bArr214 = $$d;
            Object[] objArr6111 = new Object[1];
            c(bArr214[9], bArr214[543], (short) 362, objArr6111);
            Class<?> cls210 = Class.forName((String) objArr6111[0]);
            Object[] objArr6112 = new Object[1];
            c((byte) (bArr214[276] - 1), bArr214[135], (short) 332, objArr6112);
            Object[] objArr6113 = (Object[]) cls210.getMethod((String) objArr6112[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr6110);
            objAccessartificialFrame11 = ArtificialStackFrames.accessartificialFrame(1575402270);
            if (objAccessartificialFrame11 == null) {
                int windowTouchSlop11 = (ViewConfiguration.getWindowTouchSlop() >> 8) + 17;
                char windowTouchSlop12 = (char) (ViewConfiguration.getWindowTouchSlop() >> 8);
                int mode3 = 747 - View.MeasureSpec.getMode(0);
                byte[] bArr215 = $$a;
                Object[] objArr6114 = new Object[1];
                b((byte) (-bArr215[108]), bArr215[37], bArr215[0], objArr6114);
                objAccessartificialFrame11 = ArtificialStackFrames.coroutineCreation(windowTouchSlop11, windowTouchSlop12, mode3, -1031537386, false, (String) objArr6114[0], null);
            }
            ((Field) objAccessartificialFrame11).set(null, objArr6113);
            Long lValueOf18 = Long.valueOf(((Long) Class.forName(str4).getDeclaredMethod(str5, new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame12 = ArtificialStackFrames.accessartificialFrame(1745676544);
            if (objAccessartificialFrame12 == null) {
                int modifierMetaStateMask3 = ((byte) KeyEvent.getModifierMetaStateMask()) + Ascii.DC2;
                char c15 = (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                int edgeSlop10 = 747 - (ViewConfiguration.getEdgeSlop() >> 16);
                byte[] bArr216 = $$a;
                Object[] objArr6115 = new Object[1];
                b(bArr216[8], bArr216[37], bArr216[0], objArr6115);
                objAccessartificialFrame12 = ArtificialStackFrames.coroutineCreation(modifierMetaStateMask3, c15, edgeSlop10, -144068856, false, (String) objArr6115[0], null);
            }
            ((Field) objAccessartificialFrame12).set(null, lValueOf18);
            objArr5 = objArr6113;
        }
        i11 = ((int[]) objArr5[4])[0];
        i12 = ((int[]) objArr5[3])[0];
        if (i12 == i11) {
            int i910 = artificialFrame + 53;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i910 % 128;
            int i911 = i910 % 2;
            Object[] objArr710 = {list3, new int[1], list4, new int[]{i98}, new int[]{i99}};
            int i912 = ((int[]) objArr5[1])[0];
            int i913 = ((int[]) objArr5[3])[0];
            int i914 = ((int[]) objArr5[4])[0];
            List list7 = (List) objArr5[0];
            List list8 = (List) objArr5[2];
            int startElapsedRealtime2 = (int) Process.getStartElapsedRealtime();
            int i1010 = i912 + (-2030458348) + (((-272650306) | startElapsedRealtime2) * (-627)) + (((~(273838169 | startElapsedRealtime2)) | 879286627) * (-627)) + (((~(startElapsedRealtime2 | 879286627)) | (~((~startElapsedRealtime2) | (-273838170)))) * 627);
            int i1011 = (i1010 << 13) ^ i1010;
            int i1012 = i1011 ^ (i1011 >>> 17);
            ((int[]) objArr710[1])[0] = i1012 ^ (i1012 << 5);
            i13 = 0;
        } else {
            ArrayList arrayList5 = new ArrayList();
            Object[] objArr711 = {objArr5};
            objAccessartificialFrame13 = ArtificialStackFrames.accessartificialFrame(1804664566);
            if (objAccessartificialFrame13 == null) {
                objAccessartificialFrame13 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getKeyRepeatDelay() >> 16) + 41, (char) (12468 - Gravity.getAbsoluteGravity(0, 0)), (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 3641, -185222914, false, "coroutineCreation", new Class[]{Object[].class});
            }
            arrayList5.add(((Method) objAccessartificialFrame13).invoke(null, objArr711));
            Object[] objArr712 = {objArr5};
            objAccessartificialFrame14 = ArtificialStackFrames.accessartificialFrame(-1243809191);
            if (objAccessartificialFrame14 == null) {
                objAccessartificialFrame14 = ArtificialStackFrames.coroutineCreation(40 - ((byte) KeyEvent.getModifierMetaStateMask()), (char) (12468 - (ViewConfiguration.getLongPressTimeout() >> 16)), TextUtils.getOffsetBefore("", 0) + 3642, 716815441, false, "ArtificialStackFrames", new Class[]{Object[].class});
            }
            arrayList5.add(((Method) objAccessartificialFrame14).invoke(null, objArr712));
            Object[] objArr713 = {Long.valueOf(((long) (i11 ^ i12)) ^ (((long) (-507235928)) << 32)), Long.valueOf(-507235936)};
            byte[] bArr217 = $$d;
            Object[] objArr714 = new Object[1];
            c(bArr217[8], bArr217[149], (short) 313, objArr714);
            Class<?> cls113 = Class.forName((String) objArr714[0]);
            Object[] objArr715 = new Object[1];
            c(bArr217[97], bArr217[0], (short) 445, objArr715);
            cls113.getMethod((String) objArr715[0], Long.TYPE, Long.TYPE).invoke(null, objArr713);
            Object[] objArr716 = {list5, new int[1], list6, new int[]{i104}, new int[]{i105}};
            int i1013 = ((int[]) objArr5[1])[0];
            int i1014 = ((int[]) objArr5[3])[0];
            int i1015 = ((int[]) objArr5[4])[0];
            List list9 = (List) objArr5[0];
            List list10 = (List) objArr5[2];
            int i1016 = (int) Runtime.getRuntime().totalMemory();
            int i1017 = ~i1016;
            int i1018 = i1013 + 2080825246 + (((~((-64925940) | i1017)) | 540522518) * (-90)) + (((~((-64925940) | i1016)) | (-603961592)) * (-45)) + (((~(i1016 | (-540522519))) | (-64925940) | (~(i1017 | 540522518))) * 45);
            int i1019 = (i1018 << 13) ^ i1018;
            int i1110 = i1019 ^ (i1019 >>> 17);
            i13 = 0;
            ((int[]) objArr716[1])[0] = i1110 ^ (i1110 << 5);
        }
        objAccessartificialFrame15 = ArtificialStackFrames.accessartificialFrame(-444530678);
        if (objAccessartificialFrame15 == null) {
            int iKeyCodeFromString5 = KeyEvent.keyCodeFromString("") + 26;
            char cMakeMeasureSpec2 = (char) View.MeasureSpec.makeMeasureSpec(i13, i13);
            int i1111 = (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 1040;
            byte[] bArr218 = $$a;
            Object[] objArr717 = new Object[1];
            b(bArr218[8], bArr218[37], bArr218[0], objArr717);
            objAccessartificialFrame15 = ArtificialStackFrames.coroutineCreation(iKeyCodeFromString5, cMakeMeasureSpec2, i1111, 2061780482, false, (String) objArr717[0], null);
        }
        j4 = ((Field) objAccessartificialFrame15).getLong(null);
        if (j4 != -1) {
            int iIntValue8 = ((Integer) Class.forName(str6).getMethod(str3, Object.class).invoke(null, this)).intValue();
            Object[] objArr718 = {-1589130824};
            objAccessartificialFrame16 = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame16 == null) {
                objAccessartificialFrame16 = ArtificialStackFrames.coroutineCreation(8 - KeyEvent.normalizeMetaState(0), (char) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 22250), 1033 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), 47343338, false, null, new Class[]{Integer.TYPE});
            }
            Object[] objArrAccessartificialFrame$78cbbd36 = SchemaManager$$ExternalSyntheticLambda5.accessartificialFrame$78cbbd35(iIntValue8, 0, ((Constructor) objAccessartificialFrame16).newInstance(objArr718), -987693152, false);
            objAccessartificialFrame17 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame17 == null) {
                int scrollBarFadeDuration4 = 26 - (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                char deadChar2 = (char) KeyEvent.getDeadChar(0, 0);
                int packedPositionChild6 = 1040 - ExpandableListView.getPackedPositionChild(0L);
                byte[] bArr219 = $$a;
                Object[] objArr719 = new Object[1];
                b((byte) (-bArr219[108]), bArr219[37], bArr219[0], objArr719);
                objAccessartificialFrame17 = ArtificialStackFrames.coroutineCreation(scrollBarFadeDuration4, deadChar2, packedPositionChild6, 1145017376, false, (String) objArr719[0], null);
            }
            ((Field) objAccessartificialFrame17).set(null, objArrAccessartificialFrame$78cbbd36);
            Long lValueOf19 = Long.valueOf(((Long) Class.forName(str4).getDeclaredMethod(str5, new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame18 = ArtificialStackFrames.accessartificialFrame(-444530678);
            if (objAccessartificialFrame18 == null) {
                int iIndexOf14 = TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 27;
                char c16 = (char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) - 1);
                int i1112 = 1042 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                byte[] bArr220 = $$a;
                Object[] objArr810 = new Object[1];
                b(bArr220[8], bArr220[37], bArr220[0], objArr810);
                objAccessartificialFrame18 = ArtificialStackFrames.coroutineCreation(iIndexOf14, c16, i1112, 2061780482, false, (String) objArr810[0], null);
            }
            ((Field) objAccessartificialFrame18).set(null, lValueOf19);
            objArr6 = objArrAccessartificialFrame$78cbbd36;
        } else {
            int iIntValue9 = ((Integer) Class.forName(str6).getMethod(str3, Object.class).invoke(null, this)).intValue();
            Object[] objArr7110 = {-1589130824};
            objAccessartificialFrame16 = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame16 == null) {
                objAccessartificialFrame16 = ArtificialStackFrames.coroutineCreation(8 - KeyEvent.normalizeMetaState(0), (char) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 22250), 1033 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), 47343338, false, null, new Class[]{Integer.TYPE});
            }
            Object[] objArrAccessartificialFrame$78cbbd37 = SchemaManager$$ExternalSyntheticLambda5.accessartificialFrame$78cbbd35(iIntValue9, 0, ((Constructor) objAccessartificialFrame16).newInstance(objArr7110), -987693152, false);
            objAccessartificialFrame17 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame17 == null) {
                int scrollBarFadeDuration5 = 26 - (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                char deadChar3 = (char) KeyEvent.getDeadChar(0, 0);
                int packedPositionChild7 = 1040 - ExpandableListView.getPackedPositionChild(0L);
                byte[] bArr2110 = $$a;
                Object[] objArr7111 = new Object[1];
                b((byte) (-bArr2110[108]), bArr2110[37], bArr2110[0], objArr7111);
                objAccessartificialFrame17 = ArtificialStackFrames.coroutineCreation(scrollBarFadeDuration5, deadChar3, packedPositionChild7, 1145017376, false, (String) objArr7111[0], null);
            }
            ((Field) objAccessartificialFrame17).set(null, objArrAccessartificialFrame$78cbbd37);
            Long lValueOf110 = Long.valueOf(((Long) Class.forName(str4).getDeclaredMethod(str5, new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame18 = ArtificialStackFrames.accessartificialFrame(-444530678);
            if (objAccessartificialFrame18 == null) {
                int iIndexOf15 = TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 27;
                char c17 = (char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) - 1);
                int i1113 = 1042 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                byte[] bArr221 = $$a;
                Object[] objArr811 = new Object[1];
                b(bArr221[8], bArr221[37], bArr221[0], objArr811);
                objAccessartificialFrame18 = ArtificialStackFrames.coroutineCreation(iIndexOf15, c17, i1113, 2061780482, false, (String) objArr811[0], null);
            }
            ((Field) objAccessartificialFrame18).set(null, lValueOf110);
            objArr6 = objArrAccessartificialFrame$78cbbd37;
        }
        i14 = ((int[]) objArr6[2])[0];
        i15 = ((int[]) objArr6[3])[0];
        if (i15 == i14) {
            Object[] objArr812 = {strArr8, new int[1], new int[]{i124}, new int[]{i123}};
            int i1210 = ((int[]) objArr6[1])[0];
            int i1211 = ((int[]) objArr6[3])[0];
            int i1212 = ((int[]) objArr6[2])[0];
            String[] strArr17 = (String[]) objArr6[0];
            int iNextInt4 = new Random().nextInt(1294961144);
            int i1213 = ~((-36161025) | iNextInt4);
            int i1214 = ~iNextInt4;
            int i1215 = i1210 + 707377632 + ((i1213 | (~((-1579033) | i1214))) * 497) + (((~(iNextInt4 | (-1579033))) | (~((-40363751) | i1214)) | 4202726) * 497);
            int i1216 = (i1215 << 13) ^ i1215;
            int i1217 = i1216 ^ (i1216 >>> 17);
            ((int[]) objArr812[1])[0] = i1217 ^ (i1217 << 5);
        } else {
            arrayList2 = new ArrayList();
            strArr2 = (String[]) objArr6[0];
            if (strArr2 != null) {
                while (i16 < strArr2.length) {
                    arrayList2.add(str10);
                }
            }
            long j15 = (((long) (-1114126466)) << 32) ^ ((long) (i14 ^ i15));
            long j16 = -1114126468;
            int i1310 = artificialFrame + 93;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i1310 % 128;
            int i1311 = i1310 % 2;
            Object[] objArr813 = {Long.valueOf(j15), Long.valueOf(j16)};
            byte[] bArr320 = $$d;
            byte b117 = bArr320[8];
            byte b118 = bArr320[130];
            Object[] objArr814 = new Object[1];
            c(b117, b118, (short) (b118 | 208), objArr814);
            Class<?> cls114 = Class.forName((String) objArr814[0]);
            Object[] objArr815 = new Object[1];
            c(bArr320[97], bArr320[0], (short) 445, objArr815);
            cls114.getMethod((String) objArr815[0], Long.TYPE, Long.TYPE).invoke(null, objArr813);
            Object[] objArr816 = {strArr9, new int[1], new int[]{i134}, new int[]{i133}};
            int i1312 = ((int[]) objArr6[1])[0];
            int i1313 = ((int[]) objArr6[3])[0];
            int i1314 = ((int[]) objArr6[2])[0];
            String[] strArr18 = (String[]) objArr6[0];
            int iNextInt5 = new Random().nextInt();
            int i1315 = i1312 + (-526179202) + (((~((-134760708) | (~iNextInt5))) | (~((-56656901) | iNextInt5))) * (-272)) + (((~((-480070076) | iNextInt5)) | 345309368) * (-272)) + (((~(iNextInt5 | 480070075)) | (-401966269)) * 272);
            int i1316 = (i1315 << 13) ^ i1315;
            int i1317 = i1316 ^ (i1316 >>> 17);
            ((int[]) objArr816[1])[0] = i1317 ^ (i1317 << 5);
        }
        super.onStart();
        objAccessartificialFrame19 = ArtificialStackFrames.accessartificialFrame(-1283093189);
        if (objAccessartificialFrame19 == null) {
            int gidForName7 = 29 - Process.getGidForName("");
            char cLastIndexOf6 = (char) (49361 - TextUtils.lastIndexOf("", '0'));
            int iIndexOf16 = 684 - TextUtils.indexOf("", "");
            byte b119 = (byte) (-$$a[14]);
            Object[] objArr817 = new Object[1];
            b((byte) 55, b119, (byte) (b119 | 40), objArr817);
            objAccessartificialFrame19 = ArtificialStackFrames.coroutineCreation(gidForName7, cLastIndexOf6, iIndexOf16, 752929587, false, (String) objArr817[0], null);
        }
        j5 = ((Field) objAccessartificialFrame19).getLong(null);
        if (j5 != -1) {
            int i1318 = getARTIFICIAL_FRAME_PACKAGE_NAME + 81;
            artificialFrame = i1318 % 128;
            int i1319 = i1318 % 2;
            i17 = 0;
            if (j5 + 2007 >= ((Long) Class.forName(str4).getDeclaredMethod(str5, new Class[0]).invoke(null, new Object[0])).longValue()) {
                objAccessartificialFrame29 = ArtificialStackFrames.accessartificialFrame(-326560385);
                if (objAccessartificialFrame29 == null) {
                    int offsetAfter5 = TextUtils.getOffsetAfter("", 0) + 30;
                    char windowTouchSlop13 = (char) (49362 - (ViewConfiguration.getWindowTouchSlop() >> 8));
                    int doubleTapTimeout4 = 684 - (ViewConfiguration.getDoubleTapTimeout() >> 16);
                    byte b120 = (byte) ($$b + 2);
                    byte[] bArr321 = $$a;
                    Object[] objArr818 = new Object[1];
                    b(b120, (byte) (-bArr321[14]), (byte) (bArr321[53] + 1), objArr818);
                    objAccessartificialFrame29 = ArtificialStackFrames.coroutineCreation(offsetAfter5, windowTouchSlop13, doubleTapTimeout4, 1944867703, false, (String) objArr818[0], null);
                }
                Object[] objArr920 = (Object[]) ((Field) objAccessartificialFrame29).get(null);
                objArr7 = new Object[]{new int[]{((int[]) objArr920[0])[0]}, new int[]{((int[]) objArr920[1])[0]}, new int[1], (String) objArr920[3]};
                int i1415 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 1151037849;
                int i1416 = ~i1415;
                int i1417 = (((962704210 + (((~(538403344 | i1416)) | 438835470) * (-108))) + (((~(i1416 | 440220430)) | ((~((-440220431) | i1415)) | 537018384)) * 54)) + ((i1415 | 537018384) * 54)) - 636245279;
                int i1418 = (i1417 << 13) ^ i1417;
                int i1419 = i1418 ^ (i1418 >>> 17);
                ((int[]) objArr7[2])[0] = i1419 ^ (i1419 << 5);
            }
            i18 = ((int[]) objArr7[1])[0];
            i19 = ((int[]) objArr7[0])[0];
            if (i19 == i18) {
                int i14110 = ((int[]) objArr7[2])[0];
                Object[] objArr9112 = {new int[]{((int[]) objArr7[0])[0]}, new int[]{((int[]) objArr7[1])[0]}, new int[1], (String) objArr7[3]};
                int iMyPid3 = Process.myPid();
                int i14111 = i14110 + (((~((-6448357) | iMyPid3)) | 17604) * (-283)) + 983605706 + ((~(iMyPid3 | (-6430753))) * 283);
                int i14112 = (i14111 << 13) ^ i14111;
                int i14113 = i14112 ^ (i14112 >>> 17);
                ((int[]) objArr9112[2])[0] = i14113 ^ (i14113 << 5);
            } else {
                Object[] objArr9113 = {Long.valueOf(((long) (i18 ^ i19)) ^ (((long) (-1690506437)) << 32)), Long.valueOf(-1690506433)};
                byte[] bArr3112 = $$d;
                Object[] objArr9114 = new Object[1];
                c(bArr3112[8], bArr3112[544], (short) 175, objArr9114);
                Class<?> cls115 = Class.forName((String) objArr9114[0]);
                Object[] objArr9115 = new Object[1];
                c(bArr3112[97], bArr3112[0], (short) 445, objArr9115);
                cls115.getMethod((String) objArr9115[0], Long.TYPE, Long.TYPE).invoke(null, objArr9113);
                int i14114 = ((int[]) objArr7[2])[0];
                Object[] objArr9116 = {new int[]{((int[]) objArr7[0])[0]}, new int[]{((int[]) objArr7[1])[0]}, new int[1], (String) objArr7[3]};
                int iIdentityHashCode10 = System.identityHashCode(this);
                int i15111 = ~iIdentityHashCode10;
                int i15112 = i14114 + (-101946199) + (((~((-762241958) | i15111)) | 216381817) * (-602)) + (((~(iIdentityHashCode10 | (-762241958))) | 207921441 | (~(770702333 | i15111))) * (-301)) + ((~(i15111 | 216381817)) * 301);
                int i15113 = (i15112 << 13) ^ i15112;
                int i15114 = i15113 ^ (i15113 >>> 17);
                ((int[]) objArr9116[2])[0] = i15114 ^ (i15114 << 5);
            }
            objAccessartificialFrame22 = ArtificialStackFrames.accessartificialFrame(1056123296);
            if (objAccessartificialFrame22 == null) {
                int i15115 = (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 29;
                char windowTouchSlop14 = (char) ((ViewConfiguration.getWindowTouchSlop() >> 8) + 49362);
                int gidForName8 = Process.getGidForName("") + 685;
                byte b1110 = (byte) ($$b | 17);
                byte[] bArr3113 = $$a;
                Object[] objArr9117 = new Object[1];
                b(b1110, bArr3113[46], (byte) (bArr3113[53] + 1), objArr9117);
                objAccessartificialFrame22 = ArtificialStackFrames.coroutineCreation(i15115, windowTouchSlop14, gidForName8, -1583976536, false, (String) objArr9117[0], null);
            }
            j6 = ((Field) objAccessartificialFrame22).getLong(null);
            if (j6 != -1) {
                int iIntValue10 = ((Integer) Class.forName(str6).getMethod(str3, Object.class).invoke(null, this)).intValue();
                int i15116 = getARTIFICIAL_FRAME_PACKAGE_NAME + 117;
                artificialFrame = i15116 % 128;
                int i15117 = i15116 % 2;
                Object[] objArr9118 = {Integer.valueOf(iIntValue10), -846915731};
                byte[] bArr3114 = $$d;
                Object[] objArr9119 = new Object[1];
                c(bArr3114[8], (byte) (-bArr3114[3]), (short) 151, objArr9119);
                Class<?> cls116 = Class.forName((String) objArr9119[0]);
                Object[] objArr91110 = new Object[1];
                c(bArr3114[8], bArr3114[4], (short) 97, objArr91110);
                objArr8 = (Object[]) cls116.getMethod((String) objArr91110[0], Integer.TYPE, Integer.TYPE).invoke(null, objArr9118);
                objAccessartificialFrame23 = ArtificialStackFrames.accessartificialFrame(910856866);
                if (objAccessartificialFrame23 == null) {
                    int i15118 = 30 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                    char c18 = (char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 49361);
                    int windowTouchSlop15 = 684 - (ViewConfiguration.getWindowTouchSlop() >> 8);
                    Object[] objArr10110 = new Object[1];
                    b((byte) 97, $$a[37], (byte) 40, objArr10110);
                    objAccessartificialFrame23 = ArtificialStackFrames.coroutineCreation(i15118, c18, windowTouchSlop15, -1456483158, false, (String) objArr10110[0], null);
                }
                ((Field) objAccessartificialFrame23).set(null, objArr8);
                Long lValueOf111 = Long.valueOf(((Long) Class.forName(str4).getDeclaredMethod(str5, new Class[0]).invoke(null, new Object[0])).longValue());
                objAccessartificialFrame24 = ArtificialStackFrames.accessartificialFrame(1056123296);
                if (objAccessartificialFrame24 == null) {
                    int absoluteGravity5 = 30 - Gravity.getAbsoluteGravity(0, 0);
                    char tapTimeout4 = (char) ((ViewConfiguration.getTapTimeout() >> 16) + 49362);
                    int iResolveSize7 = View.resolveSize(0, 0) + 684;
                    byte b1111 = (byte) ($$b | 17);
                    byte[] bArr3115 = $$a;
                    Object[] objArr10111 = new Object[1];
                    b(b1111, bArr3115[46], (byte) (bArr3115[53] + 1), objArr10111);
                    objAccessartificialFrame24 = ArtificialStackFrames.coroutineCreation(absoluteGravity5, tapTimeout4, iResolveSize7, -1583976536, false, (String) objArr10111[0], null);
                }
                ((Field) objAccessartificialFrame24).set(null, lValueOf111);
            } else {
                int iIntValue11 = ((Integer) Class.forName(str6).getMethod(str3, Object.class).invoke(null, this)).intValue();
                int i15119 = getARTIFICIAL_FRAME_PACKAGE_NAME + 117;
                artificialFrame = i15119 % 128;
                int i151110 = i15119 % 2;
                Object[] objArr91111 = {Integer.valueOf(iIntValue11), -846915731};
                byte[] bArr3116 = $$d;
                Object[] objArr91112 = new Object[1];
                c(bArr3116[8], (byte) (-bArr3116[3]), (short) 151, objArr91112);
                Class<?> cls117 = Class.forName((String) objArr91112[0]);
                Object[] objArr91113 = new Object[1];
                c(bArr3116[8], bArr3116[4], (short) 97, objArr91113);
                objArr8 = (Object[]) cls117.getMethod((String) objArr91113[0], Integer.TYPE, Integer.TYPE).invoke(null, objArr91111);
                objAccessartificialFrame23 = ArtificialStackFrames.accessartificialFrame(910856866);
                if (objAccessartificialFrame23 == null) {
                    int i151111 = 30 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                    char c19 = (char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 49361);
                    int windowTouchSlop16 = 684 - (ViewConfiguration.getWindowTouchSlop() >> 8);
                    Object[] objArr10112 = new Object[1];
                    b((byte) 97, $$a[37], (byte) 40, objArr10112);
                    objAccessartificialFrame23 = ArtificialStackFrames.coroutineCreation(i151111, c19, windowTouchSlop16, -1456483158, false, (String) objArr10112[0], null);
                }
                ((Field) objAccessartificialFrame23).set(null, objArr8);
                Long lValueOf112 = Long.valueOf(((Long) Class.forName(str4).getDeclaredMethod(str5, new Class[0]).invoke(null, new Object[0])).longValue());
                objAccessartificialFrame24 = ArtificialStackFrames.accessartificialFrame(1056123296);
                if (objAccessartificialFrame24 == null) {
                    int absoluteGravity6 = 30 - Gravity.getAbsoluteGravity(0, 0);
                    char tapTimeout5 = (char) ((ViewConfiguration.getTapTimeout() >> 16) + 49362);
                    int iResolveSize8 = View.resolveSize(0, 0) + 684;
                    byte b1112 = (byte) ($$b | 17);
                    byte[] bArr3117 = $$a;
                    Object[] objArr10113 = new Object[1];
                    b(b1112, bArr3117[46], (byte) (bArr3117[53] + 1), objArr10113);
                    objAccessartificialFrame24 = ArtificialStackFrames.coroutineCreation(absoluteGravity6, tapTimeout5, iResolveSize8, -1583976536, false, (String) objArr10113[0], null);
                }
                ((Field) objAccessartificialFrame24).set(null, lValueOf112);
            }
            i20 = ((int[]) objArr8[1])[0];
            i21 = ((int[]) objArr8[0])[0];
            if (i21 == i20) {
                int i1617 = ((int[]) objArr8[2])[0];
                Object[] objArr10114 = {new int[]{((int[]) objArr8[0])[0]}, new int[]{((int[]) objArr8[1])[0]}, new int[1], (String) objArr8[3]};
                int i1618 = ~System.identityHashCode(this);
                int i1619 = i1617 + 1957293886 + (((~(i1618 | 14280421)) | (-972814078)) * (-160)) + (((~(i1618 | (-964343354))) | 14280421) * SyslogConstants.LOG_LOCAL4);
                int i16110 = (i1619 << 13) ^ i1619;
                int i16111 = i16110 ^ (i16110 >>> 17);
                ((int[]) objArr10114[2])[0] = i16111 ^ (i16111 << 5);
            } else {
                new ArrayList().add((String) objArr8[3]);
                Object[] objArr10115 = {Long.valueOf(((long) (i20 ^ i21)) ^ (((long) (-1927871676)) << 32)), Long.valueOf(-1927871660)};
                byte[] bArr3118 = $$d;
                Object[] objArr10116 = new Object[1];
                c(bArr3118[8], bArr3118[544], (short) 175, objArr10116);
                Class<?> cls118 = Class.forName((String) objArr10116[0]);
                Object[] objArr10117 = new Object[1];
                c(bArr3118[97], bArr3118[0], (short) 445, objArr10117);
                cls118.getMethod((String) objArr10117[0], Long.TYPE, Long.TYPE).invoke(null, objArr10115);
                int i16112 = ((int[]) objArr8[2])[0];
                Object[] objArr10118 = {new int[]{((int[]) objArr8[0])[0]}, new int[]{((int[]) objArr8[1])[0]}, new int[1], (String) objArr8[3]};
                int i16113 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().orientation;
                int i1717 = ~((-906507842) | i16113);
                int i1718 = ~i16113;
                int i1719 = i1717 | (~(72115933 | i1718));
                int i17110 = ~(906507841 | i1718);
                int i17111 = i16112 + 2028118702 + ((i1719 | i17110) * (-516)) + (((~(i16113 | (-67642946))) | (~((-4472989) | i1718))) * 516) + ((4472988 | i17110) * 516);
                int i17112 = (i17111 << 13) ^ i17111;
                int i17113 = i17112 ^ (i17112 >>> 17);
                ((int[]) objArr10118[2])[0] = i17113 ^ (i17113 << 5);
            }
            objAccessartificialFrame25 = ArtificialStackFrames.accessartificialFrame(-1268268649);
            if (objAccessartificialFrame25 == null) {
                int iAxisFromString4 = MotionEvent.axisFromString("") + 26;
                char cKeyCodeFromString3 = (char) (KeyEvent.keyCodeFromString("") + 30068);
                int edgeSlop11 = (ViewConfiguration.getEdgeSlop() >> 16) + 816;
                byte[] bArr3119 = $$a;
                Object[] objArr10119 = new Object[1];
                b(bArr3119[8], bArr3119[37], bArr3119[0], objArr10119);
                objAccessartificialFrame25 = ArtificialStackFrames.coroutineCreation(iAxisFromString4, cKeyCodeFromString3, edgeSlop11, 721586079, false, (String) objArr10119[0], null);
            }
            j7 = ((Field) objAccessartificialFrame25).getLong(null);
            if (j7 != -1) {
                Object[] objArr11110 = {Integer.valueOf(((Integer) Class.forName(str6).getMethod(str3, Object.class).invoke(null, this)).intValue()), 0, 130081871};
                objAccessartificialFrame26 = ArtificialStackFrames.accessartificialFrame(1327366003);
                if (objAccessartificialFrame26 == null) {
                    int keyRepeatTimeout8 = (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 25;
                    char fadingEdgeLength5 = (char) (30068 - (ViewConfiguration.getFadingEdgeLength() >> 16));
                    int iResolveOpacity4 = 816 - Drawable.resolveOpacity(0, 0);
                    byte[] bArr31110 = $$a;
                    Object[] objArr11111 = new Object[1];
                    b((byte) 105, bArr31110[4], bArr31110[8], objArr11111);
                    objAccessartificialFrame26 = ArtificialStackFrames.coroutineCreation(keyRepeatTimeout8, fadingEdgeLength5, iResolveOpacity4, -797394565, false, (String) objArr11111[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                }
                objArr9 = (Object[]) ((Method) objAccessartificialFrame26).invoke(null, objArr11110);
                objAccessartificialFrame27 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame27 == null) {
                    int offsetAfter6 = TextUtils.getOffsetAfter("", 0) + 25;
                    char packedPositionChild8 = (char) (30067 - ExpandableListView.getPackedPositionChild(0L));
                    int iCombineMeasuredStates4 = View.combineMeasuredStates(0, 0) + 816;
                    byte[] bArr31111 = $$a;
                    Object[] objArr11112 = new Object[1];
                    b((byte) (-bArr31111[108]), bArr31111[37], bArr31111[0], objArr11112);
                    objAccessartificialFrame27 = ArtificialStackFrames.coroutineCreation(offsetAfter6, packedPositionChild8, iCombineMeasuredStates4, 891606461, false, (String) objArr11112[0], null);
                }
                ((Field) objAccessartificialFrame27).set(null, objArr9);
                Long lValueOf113 = Long.valueOf(((Long) Class.forName(str4).getDeclaredMethod(str5, new Class[0]).invoke(null, new Object[0])).longValue());
                objAccessartificialFrame28 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                if (objAccessartificialFrame28 == null) {
                    int iKeyCodeFromString6 = 25 - KeyEvent.keyCodeFromString("");
                    char packedPositionGroup5 = (char) (ExpandableListView.getPackedPositionGroup(0L) + 30068);
                    int keyRepeatDelay4 = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 816;
                    byte[] bArr410 = $$a;
                    Object[] objArr11113 = new Object[1];
                    b(bArr410[8], bArr410[37], bArr410[0], objArr11113);
                    objAccessartificialFrame28 = ArtificialStackFrames.coroutineCreation(iKeyCodeFromString6, packedPositionGroup5, keyRepeatDelay4, 721586079, false, (String) objArr11113[0], null);
                }
                ((Field) objAccessartificialFrame28).set(null, lValueOf113);
            } else {
                Object[] objArr11114 = {Integer.valueOf(((Integer) Class.forName(str6).getMethod(str3, Object.class).invoke(null, this)).intValue()), 0, 130081871};
                objAccessartificialFrame26 = ArtificialStackFrames.accessartificialFrame(1327366003);
                if (objAccessartificialFrame26 == null) {
                    int keyRepeatTimeout9 = (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 25;
                    char fadingEdgeLength6 = (char) (30068 - (ViewConfiguration.getFadingEdgeLength() >> 16));
                    int iResolveOpacity5 = 816 - Drawable.resolveOpacity(0, 0);
                    byte[] bArr31112 = $$a;
                    Object[] objArr11115 = new Object[1];
                    b((byte) 105, bArr31112[4], bArr31112[8], objArr11115);
                    objAccessartificialFrame26 = ArtificialStackFrames.coroutineCreation(keyRepeatTimeout9, fadingEdgeLength6, iResolveOpacity5, -797394565, false, (String) objArr11115[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                }
                objArr9 = (Object[]) ((Method) objAccessartificialFrame26).invoke(null, objArr11114);
                objAccessartificialFrame27 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame27 == null) {
                    int offsetAfter7 = TextUtils.getOffsetAfter("", 0) + 25;
                    char packedPositionChild9 = (char) (30067 - ExpandableListView.getPackedPositionChild(0L));
                    int iCombineMeasuredStates5 = View.combineMeasuredStates(0, 0) + 816;
                    byte[] bArr31113 = $$a;
                    Object[] objArr11116 = new Object[1];
                    b((byte) (-bArr31113[108]), bArr31113[37], bArr31113[0], objArr11116);
                    objAccessartificialFrame27 = ArtificialStackFrames.coroutineCreation(offsetAfter7, packedPositionChild9, iCombineMeasuredStates5, 891606461, false, (String) objArr11116[0], null);
                }
                ((Field) objAccessartificialFrame27).set(null, objArr9);
                Long lValueOf114 = Long.valueOf(((Long) Class.forName(str4).getDeclaredMethod(str5, new Class[0]).invoke(null, new Object[0])).longValue());
                objAccessartificialFrame28 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                if (objAccessartificialFrame28 == null) {
                    int iKeyCodeFromString7 = 25 - KeyEvent.keyCodeFromString("");
                    char packedPositionGroup6 = (char) (ExpandableListView.getPackedPositionGroup(0L) + 30068);
                    int keyRepeatDelay5 = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 816;
                    byte[] bArr411 = $$a;
                    Object[] objArr11117 = new Object[1];
                    b(bArr411[8], bArr411[37], bArr411[0], objArr11117);
                    objAccessartificialFrame28 = ArtificialStackFrames.coroutineCreation(iKeyCodeFromString7, packedPositionGroup6, keyRepeatDelay5, 721586079, false, (String) objArr11117[0], null);
                }
                ((Field) objAccessartificialFrame28).set(null, lValueOf114);
            }
            i22 = ((int[]) objArr9[1])[0];
            i23 = ((int[]) objArr9[0])[0];
            if (i23 == i22) {
                Object[] objArr11118 = {new int[]{i1811}, new int[]{i1812}, strArr13, new int[1]};
                int i1817 = ((int[]) objArr9[3])[0];
                int i1818 = ((int[]) objArr9[0])[0];
                int i1819 = ((int[]) objArr9[1])[0];
                String[] strArr19 = (String[]) objArr9[2];
                int iIdentityHashCode11 = System.identityHashCode(this);
                int i18110 = ~iIdentityHashCode11;
                int i18111 = i1817 + 2139009251 + (((~(239320162 | i18110)) | (-508804979)) * 98) + (((~(i18110 | (-437492529))) | 239320162 | (~(437492528 | iIdentityHashCode11))) * (-49)) + (((~(iIdentityHashCode11 | 239320162)) | 71312450) * 49);
                int i18112 = (i18111 << 13) ^ i18111;
                int i18113 = i18112 ^ (i18112 >>> 17);
                ((int[]) objArr11118[3])[0] = i18113 ^ (i18113 << 5);
                return;
            }
            arrayList3 = new ArrayList();
            strArr3 = (String[]) objArr9[2];
            if (strArr3 != null) {
                while (i24 < strArr3.length) {
                    arrayList3.add(str11);
                }
            }
            long j17 = (((long) 1773973861) << 32) ^ ((long) (i22 ^ i23));
            long j18 = 1773973860;
            int i19110 = getARTIFICIAL_FRAME_PACKAGE_NAME + 45;
            artificialFrame = i19110 % 128;
            int i19111 = i19110 % 2;
            Object[] objArr11119 = {Long.valueOf(j17), Long.valueOf(j18)};
            byte[] bArr412 = $$d;
            Object[] objArr1122 = new Object[1];
            c(bArr412[8], bArr412[435], (short) (-bArr412[545]), objArr1122);
            Class<?> cls119 = Class.forName((String) objArr1122[0]);
            Object[] objArr1123 = new Object[1];
            c(bArr412[97], bArr412[0], (short) 445, objArr1123);
            cls119.getMethod((String) objArr1123[0], Long.TYPE, Long.TYPE).invoke(null, objArr11119);
            Object[] objArr1210 = {new int[]{i1913}, new int[]{i1914}, strArr14, new int[1]};
            int i19112 = ((int[]) objArr9[3])[0];
            int i19113 = ((int[]) objArr9[0])[0];
            int i19114 = ((int[]) objArr9[1])[0];
            String[] strArr110 = (String[]) objArr9[2];
            int i19115 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().screenWidthDp;
            int i19116 = ~i19115;
            int i19117 = i19112 + 1789800286 + (((~(441466843 | i19116)) | (-1047543804)) * 98) + (((~(i19116 | (-639639210))) | 441466843 | (~(639639209 | i19115))) * (-49)) + (((~(i19115 | 441466843)) | 407904594) * 49);
            int i19118 = (i19117 << 13) ^ i19117;
            int i19119 = i19118 ^ (i19118 >>> 17);
            ((int[]) objArr1210[3])[0] = i19119 ^ (i19119 << 5);
        }
        i17 = 0;
        baseContext3 = getBaseContext();
        if (baseContext3 == null) {
            Object[] objArr1211 = new Object[1];
            a(TextUtils.indexOf((CharSequence) "", '0', i17) + 27, new char[]{62893, 22787, 4744, 22145, 39232, 29426, 40333, 'v', 35150, 13180, 13629, 65086, 9816, 58417, 60555, 17380, 4331, 65217, 61769, 58069, 4112, 47537, 61656, 59108, 14618, 6023}, objArr1211);
            Class<?> cls120 = Class.forName((String) objArr1211[i17]);
            Object[] objArr1212 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[i17]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 17, new char[]{7990, 25361, 25627, 56441, 46585, 59274, 3557, 22833, 28112, 57992, 9620, 6486, 1632, 52928, 60555, 17380, 48584, 55263}, objArr1212);
            baseContext3 = (Context) cls120.getMethod((String) objArr1212[0], new Class[0]).invoke(null, null);
        }
        if (baseContext3 != null) {
            if (baseContext3 instanceof ContextWrapper) {
                baseContext3 = baseContext3.getApplicationContext();
            } else {
                baseContext3 = baseContext3.getApplicationContext();
            }
        }
        Object[] objArr1213 = {baseContext3, Integer.valueOf(((Integer) Class.forName(str6).getMethod(str3, Object.class).invoke(null, this)).intValue()), 0, -636245279};
        byte[] bArr413 = $$d;
        Object[] objArr1214 = new Object[1];
        c(bArr413[8], (byte) (-bArr413[2]), (short) JfifUtil.MARKER_RST0, objArr1214);
        Class<?> cls121 = Class.forName((String) objArr1214[0]);
        Object[] objArr1215 = new Object[1];
        c((byte) (bArr413[276] - 1), bArr413[135], (short) 332, objArr1215);
        objArr7 = (Object[]) cls121.getMethod((String) objArr1215[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr1213);
        if (baseContext3 != null) {
            int i205 = getARTIFICIAL_FRAME_PACKAGE_NAME + 25;
            artificialFrame = i205 % 128;
            int i206 = i205 % 2;
            objAccessartificialFrame20 = ArtificialStackFrames.accessartificialFrame(-326560385);
            if (objAccessartificialFrame20 == null) {
                int jumpTapTimeout3 = (ViewConfiguration.getJumpTapTimeout() >> 16) + 30;
                char cLastIndexOf7 = (char) (49361 - TextUtils.lastIndexOf("", '0', 0, 0));
                int packedPositionType5 = 684 - ExpandableListView.getPackedPositionType(0L);
                byte b121 = (byte) ($$b + 2);
                byte[] bArr414 = $$a;
                Object[] objArr1216 = new Object[1];
                b(b121, (byte) (-bArr414[14]), (byte) (bArr414[53] + 1), objArr1216);
                objAccessartificialFrame20 = ArtificialStackFrames.coroutineCreation(jumpTapTimeout3, cLastIndexOf7, packedPositionType5, 1944867703, false, (String) objArr1216[0], null);
            }
            ((Field) objAccessartificialFrame20).set(null, objArr7);
            Long lValueOf20 = Long.valueOf(((Long) Class.forName(str4).getDeclaredMethod(str5, new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame21 = ArtificialStackFrames.accessartificialFrame(-1283093189);
            if (objAccessartificialFrame21 == null) {
                int gidForName9 = 29 - Process.getGidForName("");
                char c20 = (char) ((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 49362);
                int longPressTimeout3 = (ViewConfiguration.getLongPressTimeout() >> 16) + 684;
                byte b25 = (byte) (-$$a[14]);
                Object[] objArr1217 = new Object[1];
                b((byte) 55, b25, (byte) (b25 | 40), objArr1217);
                objAccessartificialFrame21 = ArtificialStackFrames.coroutineCreation(gidForName9, c20, longPressTimeout3, 752929587, false, (String) objArr1217[0], null);
            }
            ((Field) objAccessartificialFrame21).set(null, lValueOf20);
        }
        i18 = ((int[]) objArr7[1])[0];
        i19 = ((int[]) objArr7[0])[0];
        if (i19 == i18) {
            int i14115 = ((int[]) objArr7[2])[0];
            Object[] objArr91114 = {new int[]{((int[]) objArr7[0])[0]}, new int[]{((int[]) objArr7[1])[0]}, new int[1], (String) objArr7[3]};
            int iMyPid4 = Process.myPid();
            int i14116 = i14115 + (((~((-6448357) | iMyPid4)) | 17604) * (-283)) + 983605706 + ((~(iMyPid4 | (-6430753))) * 283);
            int i14117 = (i14116 << 13) ^ i14116;
            int i14118 = i14117 ^ (i14117 >>> 17);
            ((int[]) objArr91114[2])[0] = i14118 ^ (i14118 << 5);
        } else {
            Object[] objArr91115 = {Long.valueOf(((long) (i18 ^ i19)) ^ (((long) (-1690506437)) << 32)), Long.valueOf(-1690506433)};
            byte[] bArr31114 = $$d;
            Object[] objArr91116 = new Object[1];
            c(bArr31114[8], bArr31114[544], (short) 175, objArr91116);
            Class<?> cls1110 = Class.forName((String) objArr91116[0]);
            Object[] objArr91117 = new Object[1];
            c(bArr31114[97], bArr31114[0], (short) 445, objArr91117);
            cls1110.getMethod((String) objArr91117[0], Long.TYPE, Long.TYPE).invoke(null, objArr91115);
            int i14119 = ((int[]) objArr7[2])[0];
            Object[] objArr91118 = {new int[]{((int[]) objArr7[0])[0]}, new int[]{((int[]) objArr7[1])[0]}, new int[1], (String) objArr7[3]};
            int iIdentityHashCode12 = System.identityHashCode(this);
            int i151112 = ~iIdentityHashCode12;
            int i151113 = i14119 + (-101946199) + (((~((-762241958) | i151112)) | 216381817) * (-602)) + (((~(iIdentityHashCode12 | (-762241958))) | 207921441 | (~(770702333 | i151112))) * (-301)) + ((~(i151112 | 216381817)) * 301);
            int i151114 = (i151113 << 13) ^ i151113;
            int i151115 = i151114 ^ (i151114 >>> 17);
            ((int[]) objArr91118[2])[0] = i151115 ^ (i151115 << 5);
        }
        objAccessartificialFrame22 = ArtificialStackFrames.accessartificialFrame(1056123296);
        if (objAccessartificialFrame22 == null) {
            int i151116 = (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 29;
            char windowTouchSlop17 = (char) ((ViewConfiguration.getWindowTouchSlop() >> 8) + 49362);
            int gidForName10 = Process.getGidForName("") + 685;
            byte b1113 = (byte) ($$b | 17);
            byte[] bArr31115 = $$a;
            Object[] objArr91119 = new Object[1];
            b(b1113, bArr31115[46], (byte) (bArr31115[53] + 1), objArr91119);
            objAccessartificialFrame22 = ArtificialStackFrames.coroutineCreation(i151116, windowTouchSlop17, gidForName10, -1583976536, false, (String) objArr91119[0], null);
        }
        j6 = ((Field) objAccessartificialFrame22).getLong(null);
        if (j6 != -1) {
            int iIntValue12 = ((Integer) Class.forName(str6).getMethod(str3, Object.class).invoke(null, this)).intValue();
            int i151117 = getARTIFICIAL_FRAME_PACKAGE_NAME + 117;
            artificialFrame = i151117 % 128;
            int i151118 = i151117 % 2;
            Object[] objArr911110 = {Integer.valueOf(iIntValue12), -846915731};
            byte[] bArr31116 = $$d;
            Object[] objArr911111 = new Object[1];
            c(bArr31116[8], (byte) (-bArr31116[3]), (short) 151, objArr911111);
            Class<?> cls1111 = Class.forName((String) objArr911111[0]);
            Object[] objArr911112 = new Object[1];
            c(bArr31116[8], bArr31116[4], (short) 97, objArr911112);
            objArr8 = (Object[]) cls1111.getMethod((String) objArr911112[0], Integer.TYPE, Integer.TYPE).invoke(null, objArr911110);
            objAccessartificialFrame23 = ArtificialStackFrames.accessartificialFrame(910856866);
            if (objAccessartificialFrame23 == null) {
                int i151119 = 30 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                char c110 = (char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 49361);
                int windowTouchSlop18 = 684 - (ViewConfiguration.getWindowTouchSlop() >> 8);
                Object[] objArr101110 = new Object[1];
                b((byte) 97, $$a[37], (byte) 40, objArr101110);
                objAccessartificialFrame23 = ArtificialStackFrames.coroutineCreation(i151119, c110, windowTouchSlop18, -1456483158, false, (String) objArr101110[0], null);
            }
            ((Field) objAccessartificialFrame23).set(null, objArr8);
            Long lValueOf115 = Long.valueOf(((Long) Class.forName(str4).getDeclaredMethod(str5, new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame24 = ArtificialStackFrames.accessartificialFrame(1056123296);
            if (objAccessartificialFrame24 == null) {
                int absoluteGravity7 = 30 - Gravity.getAbsoluteGravity(0, 0);
                char tapTimeout6 = (char) ((ViewConfiguration.getTapTimeout() >> 16) + 49362);
                int iResolveSize9 = View.resolveSize(0, 0) + 684;
                byte b1114 = (byte) ($$b | 17);
                byte[] bArr31117 = $$a;
                Object[] objArr101111 = new Object[1];
                b(b1114, bArr31117[46], (byte) (bArr31117[53] + 1), objArr101111);
                objAccessartificialFrame24 = ArtificialStackFrames.coroutineCreation(absoluteGravity7, tapTimeout6, iResolveSize9, -1583976536, false, (String) objArr101111[0], null);
            }
            ((Field) objAccessartificialFrame24).set(null, lValueOf115);
        } else {
            int iIntValue13 = ((Integer) Class.forName(str6).getMethod(str3, Object.class).invoke(null, this)).intValue();
            int i1511110 = getARTIFICIAL_FRAME_PACKAGE_NAME + 117;
            artificialFrame = i1511110 % 128;
            int i1511111 = i1511110 % 2;
            Object[] objArr911113 = {Integer.valueOf(iIntValue13), -846915731};
            byte[] bArr31118 = $$d;
            Object[] objArr911114 = new Object[1];
            c(bArr31118[8], (byte) (-bArr31118[3]), (short) 151, objArr911114);
            Class<?> cls1112 = Class.forName((String) objArr911114[0]);
            Object[] objArr911115 = new Object[1];
            c(bArr31118[8], bArr31118[4], (short) 97, objArr911115);
            objArr8 = (Object[]) cls1112.getMethod((String) objArr911115[0], Integer.TYPE, Integer.TYPE).invoke(null, objArr911113);
            objAccessartificialFrame23 = ArtificialStackFrames.accessartificialFrame(910856866);
            if (objAccessartificialFrame23 == null) {
                int i1511112 = 30 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                char c111 = (char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 49361);
                int windowTouchSlop19 = 684 - (ViewConfiguration.getWindowTouchSlop() >> 8);
                Object[] objArr101112 = new Object[1];
                b((byte) 97, $$a[37], (byte) 40, objArr101112);
                objAccessartificialFrame23 = ArtificialStackFrames.coroutineCreation(i1511112, c111, windowTouchSlop19, -1456483158, false, (String) objArr101112[0], null);
            }
            ((Field) objAccessartificialFrame23).set(null, objArr8);
            Long lValueOf116 = Long.valueOf(((Long) Class.forName(str4).getDeclaredMethod(str5, new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame24 = ArtificialStackFrames.accessartificialFrame(1056123296);
            if (objAccessartificialFrame24 == null) {
                int absoluteGravity8 = 30 - Gravity.getAbsoluteGravity(0, 0);
                char tapTimeout7 = (char) ((ViewConfiguration.getTapTimeout() >> 16) + 49362);
                int iResolveSize10 = View.resolveSize(0, 0) + 684;
                byte b1115 = (byte) ($$b | 17);
                byte[] bArr31119 = $$a;
                Object[] objArr101113 = new Object[1];
                b(b1115, bArr31119[46], (byte) (bArr31119[53] + 1), objArr101113);
                objAccessartificialFrame24 = ArtificialStackFrames.coroutineCreation(absoluteGravity8, tapTimeout7, iResolveSize10, -1583976536, false, (String) objArr101113[0], null);
            }
            ((Field) objAccessartificialFrame24).set(null, lValueOf116);
        }
        i20 = ((int[]) objArr8[1])[0];
        i21 = ((int[]) objArr8[0])[0];
        if (i21 == i20) {
            int i16114 = ((int[]) objArr8[2])[0];
            Object[] objArr101114 = {new int[]{((int[]) objArr8[0])[0]}, new int[]{((int[]) objArr8[1])[0]}, new int[1], (String) objArr8[3]};
            int i16115 = ~System.identityHashCode(this);
            int i16116 = i16114 + 1957293886 + (((~(i16115 | 14280421)) | (-972814078)) * (-160)) + (((~(i16115 | (-964343354))) | 14280421) * SyslogConstants.LOG_LOCAL4);
            int i16117 = (i16116 << 13) ^ i16116;
            int i16118 = i16117 ^ (i16117 >>> 17);
            ((int[]) objArr101114[2])[0] = i16118 ^ (i16118 << 5);
        } else {
            new ArrayList().add((String) objArr8[3]);
            Object[] objArr101115 = {Long.valueOf(((long) (i20 ^ i21)) ^ (((long) (-1927871676)) << 32)), Long.valueOf(-1927871660)};
            byte[] bArr31120 = $$d;
            Object[] objArr101116 = new Object[1];
            c(bArr31120[8], bArr31120[544], (short) 175, objArr101116);
            Class<?> cls1113 = Class.forName((String) objArr101116[0]);
            Object[] objArr101117 = new Object[1];
            c(bArr31120[97], bArr31120[0], (short) 445, objArr101117);
            cls1113.getMethod((String) objArr101117[0], Long.TYPE, Long.TYPE).invoke(null, objArr101115);
            int i16119 = ((int[]) objArr8[2])[0];
            Object[] objArr101118 = {new int[]{((int[]) objArr8[0])[0]}, new int[]{((int[]) objArr8[1])[0]}, new int[1], (String) objArr8[3]};
            int i161110 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().orientation;
            int i17114 = ~((-906507842) | i161110);
            int i17115 = ~i161110;
            int i17116 = i17114 | (~(72115933 | i17115));
            int i17117 = ~(906507841 | i17115);
            int i17118 = i16119 + 2028118702 + ((i17116 | i17117) * (-516)) + (((~(i161110 | (-67642946))) | (~((-4472989) | i17115))) * 516) + ((4472988 | i17117) * 516);
            int i17119 = (i17118 << 13) ^ i17118;
            int i171110 = i17119 ^ (i17119 >>> 17);
            ((int[]) objArr101118[2])[0] = i171110 ^ (i171110 << 5);
        }
        objAccessartificialFrame25 = ArtificialStackFrames.accessartificialFrame(-1268268649);
        if (objAccessartificialFrame25 == null) {
            int iAxisFromString5 = MotionEvent.axisFromString("") + 26;
            char cKeyCodeFromString4 = (char) (KeyEvent.keyCodeFromString("") + 30068);
            int edgeSlop12 = (ViewConfiguration.getEdgeSlop() >> 16) + 816;
            byte[] bArr31121 = $$a;
            Object[] objArr101119 = new Object[1];
            b(bArr31121[8], bArr31121[37], bArr31121[0], objArr101119);
            objAccessartificialFrame25 = ArtificialStackFrames.coroutineCreation(iAxisFromString5, cKeyCodeFromString4, edgeSlop12, 721586079, false, (String) objArr101119[0], null);
        }
        j7 = ((Field) objAccessartificialFrame25).getLong(null);
        if (j7 != -1) {
            Object[] objArr111110 = {Integer.valueOf(((Integer) Class.forName(str6).getMethod(str3, Object.class).invoke(null, this)).intValue()), 0, 130081871};
            objAccessartificialFrame26 = ArtificialStackFrames.accessartificialFrame(1327366003);
            if (objAccessartificialFrame26 == null) {
                int keyRepeatTimeout10 = (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 25;
                char fadingEdgeLength7 = (char) (30068 - (ViewConfiguration.getFadingEdgeLength() >> 16));
                int iResolveOpacity6 = 816 - Drawable.resolveOpacity(0, 0);
                byte[] bArr311110 = $$a;
                Object[] objArr111111 = new Object[1];
                b((byte) 105, bArr311110[4], bArr311110[8], objArr111111);
                objAccessartificialFrame26 = ArtificialStackFrames.coroutineCreation(keyRepeatTimeout10, fadingEdgeLength7, iResolveOpacity6, -797394565, false, (String) objArr111111[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            }
            objArr9 = (Object[]) ((Method) objAccessartificialFrame26).invoke(null, objArr111110);
            objAccessartificialFrame27 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame27 == null) {
                int offsetAfter8 = TextUtils.getOffsetAfter("", 0) + 25;
                char packedPositionChild10 = (char) (30067 - ExpandableListView.getPackedPositionChild(0L));
                int iCombineMeasuredStates6 = View.combineMeasuredStates(0, 0) + 816;
                byte[] bArr311111 = $$a;
                Object[] objArr111112 = new Object[1];
                b((byte) (-bArr311111[108]), bArr311111[37], bArr311111[0], objArr111112);
                objAccessartificialFrame27 = ArtificialStackFrames.coroutineCreation(offsetAfter8, packedPositionChild10, iCombineMeasuredStates6, 891606461, false, (String) objArr111112[0], null);
            }
            ((Field) objAccessartificialFrame27).set(null, objArr9);
            Long lValueOf117 = Long.valueOf(((Long) Class.forName(str4).getDeclaredMethod(str5, new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame28 = ArtificialStackFrames.accessartificialFrame(-1268268649);
            if (objAccessartificialFrame28 == null) {
                int iKeyCodeFromString8 = 25 - KeyEvent.keyCodeFromString("");
                char packedPositionGroup7 = (char) (ExpandableListView.getPackedPositionGroup(0L) + 30068);
                int keyRepeatDelay6 = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 816;
                byte[] bArr415 = $$a;
                Object[] objArr111113 = new Object[1];
                b(bArr415[8], bArr415[37], bArr415[0], objArr111113);
                objAccessartificialFrame28 = ArtificialStackFrames.coroutineCreation(iKeyCodeFromString8, packedPositionGroup7, keyRepeatDelay6, 721586079, false, (String) objArr111113[0], null);
            }
            ((Field) objAccessartificialFrame28).set(null, lValueOf117);
        } else {
            Object[] objArr111114 = {Integer.valueOf(((Integer) Class.forName(str6).getMethod(str3, Object.class).invoke(null, this)).intValue()), 0, 130081871};
            objAccessartificialFrame26 = ArtificialStackFrames.accessartificialFrame(1327366003);
            if (objAccessartificialFrame26 == null) {
                int keyRepeatTimeout11 = (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 25;
                char fadingEdgeLength8 = (char) (30068 - (ViewConfiguration.getFadingEdgeLength() >> 16));
                int iResolveOpacity7 = 816 - Drawable.resolveOpacity(0, 0);
                byte[] bArr311112 = $$a;
                Object[] objArr111115 = new Object[1];
                b((byte) 105, bArr311112[4], bArr311112[8], objArr111115);
                objAccessartificialFrame26 = ArtificialStackFrames.coroutineCreation(keyRepeatTimeout11, fadingEdgeLength8, iResolveOpacity7, -797394565, false, (String) objArr111115[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            }
            objArr9 = (Object[]) ((Method) objAccessartificialFrame26).invoke(null, objArr111114);
            objAccessartificialFrame27 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame27 == null) {
                int offsetAfter9 = TextUtils.getOffsetAfter("", 0) + 25;
                char packedPositionChild11 = (char) (30067 - ExpandableListView.getPackedPositionChild(0L));
                int iCombineMeasuredStates7 = View.combineMeasuredStates(0, 0) + 816;
                byte[] bArr311113 = $$a;
                Object[] objArr111116 = new Object[1];
                b((byte) (-bArr311113[108]), bArr311113[37], bArr311113[0], objArr111116);
                objAccessartificialFrame27 = ArtificialStackFrames.coroutineCreation(offsetAfter9, packedPositionChild11, iCombineMeasuredStates7, 891606461, false, (String) objArr111116[0], null);
            }
            ((Field) objAccessartificialFrame27).set(null, objArr9);
            Long lValueOf118 = Long.valueOf(((Long) Class.forName(str4).getDeclaredMethod(str5, new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame28 = ArtificialStackFrames.accessartificialFrame(-1268268649);
            if (objAccessartificialFrame28 == null) {
                int iKeyCodeFromString9 = 25 - KeyEvent.keyCodeFromString("");
                char packedPositionGroup8 = (char) (ExpandableListView.getPackedPositionGroup(0L) + 30068);
                int keyRepeatDelay7 = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 816;
                byte[] bArr416 = $$a;
                Object[] objArr111117 = new Object[1];
                b(bArr416[8], bArr416[37], bArr416[0], objArr111117);
                objAccessartificialFrame28 = ArtificialStackFrames.coroutineCreation(iKeyCodeFromString9, packedPositionGroup8, keyRepeatDelay7, 721586079, false, (String) objArr111117[0], null);
            }
            ((Field) objAccessartificialFrame28).set(null, lValueOf118);
        }
        i22 = ((int[]) objArr9[1])[0];
        i23 = ((int[]) objArr9[0])[0];
        if (i23 == i22) {
            Object[] objArr111118 = {new int[]{i1818}, new int[]{i1819}, strArr19, new int[1]};
            int i18114 = ((int[]) objArr9[3])[0];
            int i18115 = ((int[]) objArr9[0])[0];
            int i18116 = ((int[]) objArr9[1])[0];
            String[] strArr111 = (String[]) objArr9[2];
            int iIdentityHashCode13 = System.identityHashCode(this);
            int i18117 = ~iIdentityHashCode13;
            int i18118 = i18114 + 2139009251 + (((~(239320162 | i18117)) | (-508804979)) * 98) + (((~(i18117 | (-437492529))) | 239320162 | (~(437492528 | iIdentityHashCode13))) * (-49)) + (((~(iIdentityHashCode13 | 239320162)) | 71312450) * 49);
            int i18119 = (i18118 << 13) ^ i18118;
            int i181110 = i18119 ^ (i18119 >>> 17);
            ((int[]) objArr111118[3])[0] = i181110 ^ (i181110 << 5);
            return;
        }
        arrayList3 = new ArrayList();
        strArr3 = (String[]) objArr9[2];
        if (strArr3 != null) {
            while (i24 < strArr3.length) {
                arrayList3.add(str11);
            }
        }
        long j19 = (((long) 1773973861) << 32) ^ ((long) (i22 ^ i23));
        long j110 = 1773973860;
        int i191110 = getARTIFICIAL_FRAME_PACKAGE_NAME + 45;
        artificialFrame = i191110 % 128;
        int i191111 = i191110 % 2;
        Object[] objArr111119 = {Long.valueOf(j19), Long.valueOf(j110)};
        byte[] bArr417 = $$d;
        Object[] objArr1124 = new Object[1];
        c(bArr417[8], bArr417[435], (short) (-bArr417[545]), objArr1124);
        Class<?> cls1114 = Class.forName((String) objArr1124[0]);
        Object[] objArr1125 = new Object[1];
        c(bArr417[97], bArr417[0], (short) 445, objArr1125);
        cls1114.getMethod((String) objArr1125[0], Long.TYPE, Long.TYPE).invoke(null, objArr111119);
        Object[] objArr1218 = {new int[]{i19113}, new int[]{i19114}, strArr110, new int[1]};
        int i191112 = ((int[]) objArr9[3])[0];
        int i191113 = ((int[]) objArr9[0])[0];
        int i191114 = ((int[]) objArr9[1])[0];
        String[] strArr112 = (String[]) objArr9[2];
        int i191115 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().screenWidthDp;
        int i191116 = ~i191115;
        int i191117 = i191112 + 1789800286 + (((~(441466843 | i191116)) | (-1047543804)) * 98) + (((~(i191116 | (-639639210))) | 441466843 | (~(639639209 | i191115))) * (-49)) + (((~(i191115 | 441466843)) | 407904594) * 49);
        int i191118 = (i191117 << 13) ^ i191117;
        int i191119 = i191118 ^ (i191118 >>> 17);
        ((int[]) objArr1218[3])[0] = i191119 ^ (i191119 << 5);
    }

    @Override // android.app.Activity
    protected void onResume() throws Throwable {
        int i = 2 % 2;
        int i2 = artificialFrame + 45;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i2 % 128;
        int i3 = i2 % 2;
        Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(949068051);
        if (objAccessartificialFrame == null) {
            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(30 - (ViewConfiguration.getEdgeSlop() >> 16), (char) ((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 49993), Color.blue(0) + 74, -1477122277, false, "MediaDescriptionCompatApi23Builder", null);
        }
        Object obj = ((Field) objAccessartificialFrame).get(null);
        try {
            Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1579113874);
            if (objAccessartificialFrame2 == null) {
                int mirror = AndroidCharacter.getMirror('0') - 18;
                char edgeSlop = (char) ((ViewConfiguration.getEdgeSlop() >> 16) + 49993);
                int iKeyCodeFromString = KeyEvent.keyCodeFromString("") + 74;
                byte[] bArr = $$d;
                byte b = bArr[16];
                byte b2 = bArr[89];
                Object[] objArr = new Object[1];
                c(b, b2, (short) (b2 | 43), objArr);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(mirror, edgeSlop, iKeyCodeFromString, -1048962150, false, (String) objArr[0], new Class[0]);
            }
            ((Method) objAccessartificialFrame2).invoke(obj, null);
            super.onResume();
            int i4 = artificialFrame + 13;
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
        int i2 = artificialFrame + 125;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i2 % 128;
        int i3 = i2 % 2;
        Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(949068051);
        if (objAccessartificialFrame == null) {
            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(View.resolveSizeAndState(0, 0, 0) + 30, (char) (TextUtils.getOffsetAfter("", 0) + 49993), 75 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), -1477122277, false, "MediaDescriptionCompatApi23Builder", null);
        }
        Object obj = null;
        Object obj2 = ((Field) objAccessartificialFrame).get(null);
        try {
            Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1579114835);
            if (objAccessartificialFrame2 == null) {
                int i4 = (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 30;
                char c = (char) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 49992);
                int i5 = (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 74;
                byte[] bArr = $$d;
                byte b = bArr[8];
                byte b2 = bArr[89];
                Object[] objArr = new Object[1];
                c(b, b2, (short) (b2 | 43), objArr);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(i4, c, i5, -1048959141, false, (String) objArr[0], new Class[0]);
            }
            ((Method) objAccessartificialFrame2).invoke(obj2, null);
            super.onPause();
            int i6 = getARTIFICIAL_FRAME_PACKAGE_NAME + 53;
            artificialFrame = i6 % 128;
            if (i6 % 2 != 0) {
                return;
            }
            obj.hashCode();
            throw null;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x01b5  */
    /* JADX WARN: Code duplicated, block: B:16:0x022c A[Catch: all -> 0x09f0, TryCatch #0 {all -> 0x09f0, blocks: (B:51:0x06f1, B:53:0x0712, B:54:0x0760, B:14:0x0218, B:16:0x022c, B:17:0x0258), top: B:91:0x0218 }] */
    /* JADX WARN: Code duplicated, block: B:20:0x026e  */
    /* JADX WARN: Code duplicated, block: B:25:0x033d  */
    /* JADX WARN: Code duplicated, block: B:50:0x066c  */
    /* JADX WARN: Code duplicated, block: B:53:0x0712 A[Catch: all -> 0x09f0, TryCatch #0 {all -> 0x09f0, blocks: (B:51:0x06f1, B:53:0x0712, B:54:0x0760, B:14:0x0218, B:16:0x022c, B:17:0x0258), top: B:91:0x0218 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x0772  */
    /* JADX WARN: Code duplicated, block: B:62:0x083a  */
    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) throws Throwable {
        Object objAccessartificialFrame;
        Object[] objArrAccessartificialFrame$78cbbd35;
        Object objAccessartificialFrame2;
        Object objAccessartificialFrame3;
        Object objAccessartificialFrame4;
        Object[] objArr;
        Object objAccessartificialFrame5;
        Object objAccessartificialFrame6;
        char c = 2;
        int i = 2 % 2;
        super.attachBaseContext(context);
        Object objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-444530678);
        if (objAccessartificialFrame7 == null) {
            int deadChar = KeyEvent.getDeadChar(0, 0) + 26;
            char cResolveOpacity = (char) Drawable.resolveOpacity(0, 0);
            int i2 = (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 1041;
            byte[] bArr = $$a;
            Object[] objArr2 = new Object[1];
            b(bArr[8], bArr[37], bArr[0], objArr2);
            objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(deadChar, cResolveOpacity, i2, 2061780482, false, (String) objArr2[0], null);
        }
        long j = ((Field) objAccessartificialFrame7).getLong(null);
        if (j != -1) {
            long j2 = j + 4611686018427387822L;
            Object[] objArr3 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 18, new char[]{62893, 22787, 4744, 22145, 39232, 29426, 40333, 'v', 2813, 41244, 17347, 9541, 36577, 22902, 33572, 2441, 48048, 40197, 16413, 52585, 62544, 42067}, objArr3);
            Class<?> cls = Class.forName((String) objArr3[0]);
            Object[] objArr4 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(0) - 22, new char[]{1969, 29222, 35150, 13180, 24714, 12898, 25738, 25013, 39435, 38293, 1745, 1597, 6446, 48017, 49848, 15482}, objArr4);
            if (j2 >= ((Long) cls.getDeclaredMethod((String) objArr4[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame8 == null) {
                    int trimmedLength = 26 - TextUtils.getTrimmedLength("");
                    char windowTouchSlop = (char) (ViewConfiguration.getWindowTouchSlop() >> 8);
                    int offsetAfter = TextUtils.getOffsetAfter("", 0) + 1041;
                    byte[] bArr2 = $$a;
                    Object[] objArr5 = new Object[1];
                    b((byte) (-bArr2[108]), bArr2[37], bArr2[0], objArr5);
                    objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(trimmedLength, windowTouchSlop, offsetAfter, 1145017376, false, (String) objArr5[0], null);
                }
                Object[] objArr6 = (Object[]) ((Field) objAccessartificialFrame8).get(null);
                objArrAccessartificialFrame$78cbbd35 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
                int i3 = ((int[]) objArr6[3])[0];
                int i4 = ((int[]) objArr6[2])[0];
                String[] strArr = (String[]) objArr6[0];
                int i5 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().screenLayout;
                int i6 = ~i5;
                int i7 = (~((-378418847) | i6)) | 277229726;
                int i8 = ~(i5 | 401504159);
                int i9 = (-1315939924) + ((i7 | i8) * (-713)) + (i8 * 1426) + ((~(300315039 | i6)) * 713) + 1379782824;
                int i10 = (i9 << 13) ^ i9;
                int i11 = i10 ^ (i10 >>> 17);
                ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0] = i11 ^ (i11 << 5);
            } else {
                Object[] objArr7 = new Object[1];
                a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(9) - 98, new char[]{5635, 2765, 56321, 3827, 50996, 45626, 62893, 22787, 56130, 2369, 8779, 52186, 24815, 35845, 6016, 1829}, objArr7);
                Class<?> cls2 = Class.forName((String) objArr7[0]);
                Object[] objArr8 = new Object[1];
                a(16 - TextUtils.indexOf("", "", 0, 0), new char[]{37176, 46068, 46585, 59274, 60555, 17380, 61769, 58069, 7029, 51068, 13060, 33868, 62261, 61669, 52338, 2144}, objArr8);
                int iIntValue = ((Integer) cls2.getMethod((String) objArr8[0], Object.class).invoke(null, this)).intValue();
                try {
                    Object[] objArr9 = {709326762};
                    objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1648942878);
                    if (objAccessartificialFrame == null) {
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(TextUtils.getCapsMode("", 0, 0) + 8, (char) (22250 - TextUtils.lastIndexOf("", '0', 0)), View.MeasureSpec.makeMeasureSpec(0, 0) + 1033, 47343338, false, null, new Class[]{Integer.TYPE});
                    }
                    objArrAccessartificialFrame$78cbbd35 = com.facebook.core.R.string.accessartificialFrame$78cbbd35(iIntValue, 0, ((Constructor) objAccessartificialFrame).newInstance(objArr9), 1379782824, false);
                    objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-614804952);
                    if (objAccessartificialFrame2 == null) {
                        int size = 26 - View.MeasureSpec.getSize(0);
                        char touchSlop = (char) (ViewConfiguration.getTouchSlop() >> 8);
                        int iLastIndexOf = 1040 - TextUtils.lastIndexOf("", '0');
                        byte[] bArr3 = $$a;
                        Object[] objArr10 = new Object[1];
                        b((byte) (-bArr3[108]), bArr3[37], bArr3[0], objArr10);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(size, touchSlop, iLastIndexOf, 1145017376, false, (String) objArr10[0], null);
                    }
                    ((Field) objAccessartificialFrame2).set(null, objArrAccessartificialFrame$78cbbd35);
                    try {
                        Object[] objArr11 = new Object[1];
                        a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 18, new char[]{62893, 22787, 4744, 22145, 39232, 29426, 40333, 'v', 2813, 41244, 17347, 9541, 36577, 22902, 33572, 2441, 48048, 40197, 16413, 52585, 62544, 42067}, objArr11);
                        Class<?> cls3 = Class.forName((String) objArr11[0]);
                        Object[] objArr12 = new Object[1];
                        a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 20, new char[]{1969, 29222, 35150, 13180, 24714, 12898, 25738, 25013, 39435, 38293, 1745, 1597, 6446, 48017, 49848, 15482}, objArr12);
                        Long lValueOf = Long.valueOf(((Long) cls3.getDeclaredMethod((String) objArr12[0], new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-444530678);
                        if (objAccessartificialFrame3 == null) {
                            int bitsPerPixel = ImageFormat.getBitsPerPixel(0) + 27;
                            char cCombineMeasuredStates = (char) View.combineMeasuredStates(0, 0);
                            int longPressTimeout = 1041 - (ViewConfiguration.getLongPressTimeout() >> 16);
                            byte[] bArr4 = $$a;
                            Object[] objArr13 = new Object[1];
                            b(bArr4[8], bArr4[37], bArr4[0], objArr13);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(bitsPerPixel, cCombineMeasuredStates, longPressTimeout, 2061780482, false, (String) objArr13[0], null);
                        }
                        ((Field) objAccessartificialFrame3).set(null, lValueOf);
                        c = 2;
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
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(9) - 98, new char[]{5635, 2765, 56321, 3827, 50996, 45626, 62893, 22787, 56130, 2369, 8779, 52186, 24815, 35845, 6016, 1829}, objArr14);
            Class<?> cls4 = Class.forName((String) objArr14[0]);
            Object[] objArr15 = new Object[1];
            a(16 - TextUtils.indexOf("", "", 0, 0), new char[]{37176, 46068, 46585, 59274, 60555, 17380, 61769, 58069, 7029, 51068, 13060, 33868, 62261, 61669, 52338, 2144}, objArr15);
            int iIntValue2 = ((Integer) cls4.getMethod((String) objArr15[0], Object.class).invoke(null, this)).intValue();
            Object[] objArr16 = {709326762};
            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame == null) {
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(TextUtils.getCapsMode("", 0, 0) + 8, (char) (22250 - TextUtils.lastIndexOf("", '0', 0)), View.MeasureSpec.makeMeasureSpec(0, 0) + 1033, 47343338, false, null, new Class[]{Integer.TYPE});
            }
            objArrAccessartificialFrame$78cbbd35 = com.facebook.core.R.string.accessartificialFrame$78cbbd35(iIntValue2, 0, ((Constructor) objAccessartificialFrame).newInstance(objArr16), 1379782824, false);
            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame2 == null) {
                int size2 = 26 - View.MeasureSpec.getSize(0);
                char touchSlop2 = (char) (ViewConfiguration.getTouchSlop() >> 8);
                int iLastIndexOf2 = 1040 - TextUtils.lastIndexOf("", '0');
                byte[] bArr5 = $$a;
                Object[] objArr17 = new Object[1];
                b((byte) (-bArr5[108]), bArr5[37], bArr5[0], objArr17);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(size2, touchSlop2, iLastIndexOf2, 1145017376, false, (String) objArr17[0], null);
            }
            ((Field) objAccessartificialFrame2).set(null, objArrAccessartificialFrame$78cbbd35);
            Object[] objArr18 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 18, new char[]{62893, 22787, 4744, 22145, 39232, 29426, 40333, 'v', 2813, 41244, 17347, 9541, 36577, 22902, 33572, 2441, 48048, 40197, 16413, 52585, 62544, 42067}, objArr18);
            Class<?> cls5 = Class.forName((String) objArr18[0]);
            Object[] objArr19 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 20, new char[]{1969, 29222, 35150, 13180, 24714, 12898, 25738, 25013, 39435, 38293, 1745, 1597, 6446, 48017, 49848, 15482}, objArr19);
            Long lValueOf2 = Long.valueOf(((Long) cls5.getDeclaredMethod((String) objArr19[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-444530678);
            if (objAccessartificialFrame3 == null) {
                int bitsPerPixel2 = ImageFormat.getBitsPerPixel(0) + 27;
                char cCombineMeasuredStates2 = (char) View.combineMeasuredStates(0, 0);
                int longPressTimeout2 = 1041 - (ViewConfiguration.getLongPressTimeout() >> 16);
                byte[] bArr6 = $$a;
                Object[] objArr110 = new Object[1];
                b(bArr6[8], bArr6[37], bArr6[0], objArr110);
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(bitsPerPixel2, cCombineMeasuredStates2, longPressTimeout2, 2061780482, false, (String) objArr110[0], null);
            }
            ((Field) objAccessartificialFrame3).set(null, lValueOf2);
            c = 2;
        }
        int i12 = ((int[]) objArrAccessartificialFrame$78cbbd35[c])[0];
        int i13 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
        if (i13 == i12) {
            Object[] objArr20 = new Object[4];
            objArr20[1] = new int[1];
            objArr20[c] = new int[]{i};
            objArr20[3] = new int[]{i};
            int i14 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i15 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i16 = ((int[]) objArrAccessartificialFrame$78cbbd35[c])[0];
            objArr20[0] = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int iElapsedRealtime = (int) SystemClock.elapsedRealtime();
            int i17 = ~iElapsedRealtime;
            int i18 = i14 + (-133870808) + (((~(i17 | (-72034606))) | 150138412) * (-1042)) + (((-72034606) | iElapsedRealtime) * 521) + (((~(iElapsedRealtime | (-150138413))) | 145802752 | (~(i17 | (-67698946)))) * 521);
            int i19 = (i18 << 13) ^ i18;
            int i20 = i19 ^ (i19 >>> 17);
            ((int[]) objArr20[1])[0] = i20 ^ (i20 << 5);
        } else {
            ArrayList arrayList = new ArrayList();
            String[] strArr2 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            if (strArr2 != null) {
                for (String str : strArr2) {
                    arrayList.add(str);
                }
            }
            long j3 = ((long) (i12 ^ i13)) ^ (((long) 703011764) << 32);
            long j4 = 703011766;
            int i21 = getARTIFICIAL_FRAME_PACKAGE_NAME + 125;
            int i22 = i21 % 128;
            artificialFrame = i22;
            int i23 = i21 % 2;
            int i24 = i22 + 21;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i24 % 128;
            int i25 = i24 % 2;
            try {
                Object[] objArr21 = {Long.valueOf(j3), Long.valueOf(j4)};
                byte[] bArr7 = $$d;
                byte b = bArr7[89];
                byte b2 = (byte) (b | 43);
                Object[] objArr22 = new Object[1];
                c(b, b2, b2, objArr22);
                Class<?> cls6 = Class.forName((String) objArr22[0]);
                Object[] objArr23 = new Object[1];
                c(bArr7[97], bArr7[0], (short) 445, objArr23);
                cls6.getMethod((String) objArr23[0], Long.TYPE, Long.TYPE).invoke(null, objArr21);
                Object[] objArr24 = {strArr, new int[1], new int[]{i}, new int[]{i}};
                int i26 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
                int i27 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
                int i28 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
                String[] strArr3 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
                int iIdentityHashCode = System.identityHashCode(this);
                int i29 = i26 + 1675647596 + (((~(819317234 | iIdentityHashCode)) | 897421041) * (-366)) + (((~(iIdentityHashCode | 905826291)) | 810911984) * 366);
                int i30 = (i29 << 13) ^ i29;
                int i31 = i30 ^ (i30 >>> 17);
                ((int[]) objArr24[1])[0] = i31 ^ (i31 << 5);
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
            int longPressTimeout3 = (ViewConfiguration.getLongPressTimeout() >> 16) + 25;
            char edgeSlop = (char) (30068 - (ViewConfiguration.getEdgeSlop() >> 16));
            int packedPositionChild = 815 - ExpandableListView.getPackedPositionChild(0L);
            byte[] bArr8 = $$a;
            Object[] objArr25 = new Object[1];
            b(bArr8[8], bArr8[37], bArr8[0], objArr25);
            objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(longPressTimeout3, edgeSlop, packedPositionChild, 721586079, false, (String) objArr25[0], null);
        }
        long j5 = ((Field) objAccessartificialFrame9).getLong(null);
        if (j5 != -1) {
            long j6 = j5 + 1897;
            Object[] objArr26 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 13, new char[]{62893, 22787, 4744, 22145, 39232, 29426, 40333, 'v', 2813, 41244, 17347, 9541, 36577, 22902, 33572, 2441, 48048, 40197, 16413, 52585, 62544, 42067}, objArr26);
            Class<?> cls7 = Class.forName((String) objArr26[0]);
            Object[] objArr27 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 11, new char[]{1969, 29222, 35150, 13180, 24714, 12898, 25738, 25013, 39435, 38293, 1745, 1597, 6446, 48017, 49848, 15482}, objArr27);
            if (j6 >= ((Long) cls7.getDeclaredMethod((String) objArr27[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame10 == null) {
                    int iResolveOpacity = 25 - Drawable.resolveOpacity(0, 0);
                    char modifierMetaStateMask = (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 30069);
                    int maxKeyCode = (KeyEvent.getMaxKeyCode() >> 16) + 816;
                    byte[] bArr9 = $$a;
                    Object[] objArr28 = new Object[1];
                    b((byte) (-bArr9[108]), bArr9[37], bArr9[0], objArr28);
                    objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(iResolveOpacity, modifierMetaStateMask, maxKeyCode, 891606461, false, (String) objArr28[0], null);
                }
                Object[] objArr29 = (Object[]) ((Field) objAccessartificialFrame10).get(null);
                objArr = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i32 = ((int[]) objArr29[0])[0];
                int i33 = ((int[]) objArr29[1])[0];
                String[] strArr4 = (String[]) objArr29[2];
                int iIdentityHashCode2 = System.identityHashCode(this);
                int i34 = (-353673509) + (((~((-479860480) | iIdentityHashCode2)) | 134747341) * (-140)) + ((~((-345113139) | iIdentityHashCode2)) * 70) + (((~(iIdentityHashCode2 | 678032845)) | (-888398643)) * 70) + 832001764;
                int i35 = (i34 << 13) ^ i34;
                int i36 = i35 ^ (i35 >>> 17);
                ((int[]) objArr[3])[0] = i36 ^ (i36 << 5);
            } else {
                Object[] objArr30 = new Object[1];
                a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 19, new char[]{5635, 2765, 56321, 3827, 50996, 45626, 62893, 22787, 56130, 2369, 8779, 52186, 24815, 35845, 6016, 1829}, objArr30);
                Class<?> cls8 = Class.forName((String) objArr30[0]);
                Object[] objArr31 = new Object[1];
                a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 12, new char[]{37176, 46068, 46585, 59274, 60555, 17380, 61769, 58069, 7029, 51068, 13060, 33868, 62261, 61669, 52338, 2144}, objArr31);
                Object[] objArr32 = {Integer.valueOf(((Integer) cls8.getMethod((String) objArr31[0], Object.class).invoke(null, this)).intValue()), 0, 832001764};
                objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1327366003);
                if (objAccessartificialFrame4 == null) {
                    int tapTimeout = (ViewConfiguration.getTapTimeout() >> 16) + 25;
                    char cMyTid = (char) (30068 - (Process.myTid() >> 22));
                    int trimmedLength2 = TextUtils.getTrimmedLength("") + 816;
                    byte[] bArr10 = $$a;
                    Object[] objArr33 = new Object[1];
                    b((byte) 105, bArr10[4], bArr10[8], objArr33);
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(tapTimeout, cMyTid, trimmedLength2, -797394565, false, (String) objArr33[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                }
                objArr = (Object[]) ((Method) objAccessartificialFrame4).invoke(null, objArr32);
                objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame5 == null) {
                    int scrollBarFadeDuration = (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 25;
                    char gidForName = (char) (Process.getGidForName("") + 30069);
                    int iNormalizeMetaState = 816 - KeyEvent.normalizeMetaState(0);
                    byte[] bArr11 = $$a;
                    Object[] objArr34 = new Object[1];
                    b((byte) (-bArr11[108]), bArr11[37], bArr11[0], objArr34);
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(scrollBarFadeDuration, gidForName, iNormalizeMetaState, 891606461, false, (String) objArr34[0], null);
                }
                ((Field) objAccessartificialFrame5).set(null, objArr);
                try {
                    Object[] objArr35 = new Object[1];
                    a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 13, new char[]{62893, 22787, 4744, 22145, 39232, 29426, 40333, 'v', 2813, 41244, 17347, 9541, 36577, 22902, 33572, 2441, 48048, 40197, 16413, 52585, 62544, 42067}, objArr35);
                    Class<?> cls9 = Class.forName((String) objArr35[0]);
                    Object[] objArr36 = new Object[1];
                    a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 6, new char[]{1969, 29222, 35150, 13180, 24714, 12898, 25738, 25013, 39435, 38293, 1745, 1597, 6446, 48017, 49848, 15482}, objArr36);
                    Long lValueOf3 = Long.valueOf(((Long) cls9.getDeclaredMethod((String) objArr36[0], new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                    if (objAccessartificialFrame6 == null) {
                        int packedPositionChild2 = 24 - ExpandableListView.getPackedPositionChild(0L);
                        char c2 = (char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 30067);
                        int i37 = 817 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1));
                        byte[] bArr12 = $$a;
                        Object[] objArr37 = new Object[1];
                        b(bArr12[8], bArr12[37], bArr12[0], objArr37);
                        objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(packedPositionChild2, c2, i37, 721586079, false, (String) objArr37[0], null);
                    }
                    ((Field) objAccessartificialFrame6).set(null, lValueOf3);
                    int i38 = artificialFrame + 31;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i38 % 128;
                    int i39 = i38 % 2;
                } catch (Exception unused2) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object[] objArr38 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 19, new char[]{5635, 2765, 56321, 3827, 50996, 45626, 62893, 22787, 56130, 2369, 8779, 52186, 24815, 35845, 6016, 1829}, objArr38);
            Class<?> cls10 = Class.forName((String) objArr38[0]);
            Object[] objArr39 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 12, new char[]{37176, 46068, 46585, 59274, 60555, 17380, 61769, 58069, 7029, 51068, 13060, 33868, 62261, 61669, 52338, 2144}, objArr39);
            Object[] objArr310 = {Integer.valueOf(((Integer) cls10.getMethod((String) objArr39[0], Object.class).invoke(null, this)).intValue()), 0, 832001764};
            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1327366003);
            if (objAccessartificialFrame4 == null) {
                int tapTimeout2 = (ViewConfiguration.getTapTimeout() >> 16) + 25;
                char cMyTid2 = (char) (30068 - (Process.myTid() >> 22));
                int trimmedLength3 = TextUtils.getTrimmedLength("") + 816;
                byte[] bArr13 = $$a;
                Object[] objArr311 = new Object[1];
                b((byte) 105, bArr13[4], bArr13[8], objArr311);
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(tapTimeout2, cMyTid2, trimmedLength3, -797394565, false, (String) objArr311[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            }
            objArr = (Object[]) ((Method) objAccessartificialFrame4).invoke(null, objArr310);
            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame5 == null) {
                int scrollBarFadeDuration2 = (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 25;
                char gidForName2 = (char) (Process.getGidForName("") + 30069);
                int iNormalizeMetaState2 = 816 - KeyEvent.normalizeMetaState(0);
                byte[] bArr14 = $$a;
                Object[] objArr312 = new Object[1];
                b((byte) (-bArr14[108]), bArr14[37], bArr14[0], objArr312);
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(scrollBarFadeDuration2, gidForName2, iNormalizeMetaState2, 891606461, false, (String) objArr312[0], null);
            }
            ((Field) objAccessartificialFrame5).set(null, objArr);
            Object[] objArr313 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 13, new char[]{62893, 22787, 4744, 22145, 39232, 29426, 40333, 'v', 2813, 41244, 17347, 9541, 36577, 22902, 33572, 2441, 48048, 40197, 16413, 52585, 62544, 42067}, objArr313);
            Class<?> cls11 = Class.forName((String) objArr313[0]);
            Object[] objArr314 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 6, new char[]{1969, 29222, 35150, 13180, 24714, 12898, 25738, 25013, 39435, 38293, 1745, 1597, 6446, 48017, 49848, 15482}, objArr314);
            Long lValueOf4 = Long.valueOf(((Long) cls11.getDeclaredMethod((String) objArr314[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1268268649);
            if (objAccessartificialFrame6 == null) {
                int packedPositionChild3 = 24 - ExpandableListView.getPackedPositionChild(0L);
                char c3 = (char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 30067);
                int i310 = 817 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1));
                byte[] bArr15 = $$a;
                Object[] objArr315 = new Object[1];
                b(bArr15[8], bArr15[37], bArr15[0], objArr315);
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(packedPositionChild3, c3, i310, 721586079, false, (String) objArr315[0], null);
            }
            ((Field) objAccessartificialFrame6).set(null, lValueOf4);
            int i311 = artificialFrame + 31;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i311 % 128;
            int i312 = i311 % 2;
        }
        int i40 = ((int[]) objArr[1])[0];
        int i41 = ((int[]) objArr[0])[0];
        if (i41 == i40) {
            Object[] objArr40 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i42 = ((int[]) objArr[3])[0];
            int i43 = ((int[]) objArr[0])[0];
            int i44 = ((int[]) objArr[1])[0];
            String[] strArr5 = (String[]) objArr[2];
            int elapsedCpuTime = (int) Process.getElapsedCpuTime();
            int i45 = i42 + 870567018 + ((~((~elapsedCpuTime) | (-336560769))) * 433) + (((~(336577474 | elapsedCpuTime)) | (-534749841)) * (-433)) + (((~(elapsedCpuTime | (-534749841))) | 16706) * 433);
            int i46 = (i45 << 13) ^ i45;
            int i47 = i46 ^ (i46 >>> 17);
            ((int[]) objArr40[3])[0] = i47 ^ (i47 << 5);
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        String[] strArr6 = (String[]) objArr[2];
        if (strArr6 != null) {
            for (String str2 : strArr6) {
                arrayList2.add(str2);
            }
        }
        Object[] objArr41 = {Long.valueOf(((long) (i40 ^ i41)) ^ (((long) 510914185) << 32)), Long.valueOf(510914184)};
        byte[] bArr16 = $$d;
        Object[] objArr42 = new Object[1];
        c(bArr16[8], (byte) (-bArr16[545]), bArr16[89], objArr42);
        Class<?> cls12 = Class.forName((String) objArr42[0]);
        Object[] objArr43 = new Object[1];
        c(bArr16[97], bArr16[0], (short) 445, objArr43);
        cls12.getMethod((String) objArr43[0], Long.TYPE, Long.TYPE).invoke(null, objArr41);
        Object[] objArr44 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
        int i48 = ((int[]) objArr[3])[0];
        int i49 = ((int[]) objArr[0])[0];
        int i50 = ((int[]) objArr[1])[0];
        String[] strArr7 = (String[]) objArr[2];
        int iMyPid = Process.myPid();
        int i51 = (-1890089672) + (((~((~iMyPid) | (-112354903))) | 44172800) * (-245));
        int i52 = ~(iMyPid | (-112354903));
        int i53 = i48 + i51 + (i52 * (-245)) + ((i52 | 85817463) * 245);
        int i54 = (i53 << 13) ^ i53;
        int i55 = i54 ^ (i54 >>> 17);
        ((int[]) objArr44[3])[0] = i55 ^ (i55 << 5);
    }

    static {
        byte[] bArr = new byte[671];
        System.arraycopy("\u0002§ßÊ\u0010\u0002Å=\f\u0004ü\týÍ<\u0007\r÷\u0001\u0003\u0016öÍ9\u0010\u0002\u0007\u0003\u0003û\r\n\u0003¿\u001f)\fï\u000f\u0001ÿò\u0017\u0006\u0006\u000e\u0005\u0002ó\u0015×7ï\u0006\u000f\bù\n\u0003\u0006\u0004\u0006\u0012\u0004ò\u0015\u0006ù\u0001\u0007þ\nü\u000fÞ0ó\u0010ü\u0010\u0002Å<ÿ\u0006\u0006\u0001\u0011\u0004\u0000ÇH÷\u0000\u0006\u0015¾Kø\bø\u0011÷\n\u0002\u0011À/\u001aüþñ%ù\u0005ï#\u0004\u0001¼\u0004%7\u0000õ\u0011\u0000÷\u000fë*ù\nø\u0001\u0013ùþí\u0019\u0010ù\u0006\u0001Ó\u0004A\nÃ?\t\fó\u0011\u0006ñ\u0016öÍD\u0005\tù\u0001\u0003\u0004Í$%\tù\u0001\u0003\u0004ñ\u0017\u0000\u0006\u0015å#ù\u0007\u000bµ\u0012\u0010\u0002Å>\u0005\u000fñ\u0006\t\u0005ü\u0013\u0004Â;\u0017ï\u0006\u000f\bù\n\u0003\t¿#0Î*þ\u0006\u0011\u0001Ú7ï\u0006\u000f\bù\n\u0003\b\tü\u0001\tÄ?\nÃ(\u0017\u0000\u0007á)\u0012õ\u0011×\u000eû\u00037ï\u0006\u000f\bù\n\u00030\u0007\u0001\n\u0003ù\tûã%\u0001\u0017ö\u0004\u0006\týè-\u0010\u0002Å=\f\u0004ü\týÍ7\u0011ú\u0012\u0001þÿÎ=\n\n¿?\t\nõ\u0011\u0000÷\u000fÆC\u0003\u0003\u0002\u000fï\u001b÷\u000eú\n\u0003õ\u0007\u0003\u0015õ\u0010ù\u0005þ\u0007\u0017ýú\fý\u0003ÎP\u0004ï\tÊG\u0002\b¿B\u0007üÿ\u0003\u0006\fÇ9\u0010\u0007÷ÍI\u0001ýÉ\u0019:î\r\u0001þã7õ\u0004\u0003\u0011æ\"ó\u0006\fþ\u0011\u0010\u0002Å=\f\u0004ü\týÍP\u0002õ\týËE\u0003û\u0003ÎH\u0005\u0004¿(\u0005\u0004\u0006#ù\u0007\u000b\u0010\u0002Å=\f\u0004ü\týÍ7\u0013ýÉ'(þ\tñó&\u0001\tÿ\u0010\u0002Å<ÿ\u0006\u0006\u0001\u0011\u0004\u0000Ç<\u0010÷\u0012ô\u0010ÃKøÉ9\u0010\u0002\u0004\u0006\u0003Ä\u001f(ø\n\u0002ë'ö\u0007ó%ñ\u0017\u0005\u0002µ#0\u0002\u0007õ\u0011ÿ\n\u0003\u0010\u0007\u0001\n\u0003ù\tûâ3÷\u0000\u0017ù\n\u0003\u0010\u0002Å=\f\u0004ü\týÍ9\u0013\u000bû\bÿÃJù\t\u0001Ç7\b\u0000\u0007Î\u0017(\u0012Ö \u001b×\u001e\u0018¯\u0011\u0000\u0001\u0010\u0004\u0000Çÿ?\t\nõ\u0011\u0000÷\u000fÆM\u0000¿(\u0017\u0000\u000fï\u0012\u0001õ ø\fþ\u0013´7\u001fû\u000fõ\u0011æ\u0011\u0016ü\u0010\u0002Å=\f\u0004ü\týÍ7\u0011ú\u0012\u0001þÿÎCø\u0017õ\u0011ûü\u000fÆ9\u0010\u0001\u0007\u0007ÀK\u0003ù\u0007\u0001\u000fù\u0000\u0012¿\u001a9ù÷\u0010\u0000þä0\u0001\u0007\u0007¶\u0004%7\u0000õ\u0011\u0000÷\u000fë*ù\nø\u0001\u0013ùþí\u0019\u0010ù\u0006\u0001Ó".getBytes(CharEncoding.ISO_8859_1), 0, bArr, 0, 671);
        $$d = bArr;
        $$e = 90;
        $$a = new byte[]{47, 75, -118, 7, 9, -18, 36, -33, 19, -17, 32, -15, -19, Ascii.VT, -5, 7, 7, -18, 43, -29, 4, -17, -2, -5, 1, 33, -33, 2, 9, -5, 7, -5, 1, 50, -39, -11, 7, Ascii.FF, -15, -49, -2, Ascii.VT, 3, -3, 6, -6, 8, -11, Ascii.EM, -33, 19, -2, -8, 37, -44, 17, -12, 8, -14, 9, -18, 34, -25, -4, 17, -19, Ascii.SI, 1, Ascii.DC2, -15, -19, Ascii.VT, -5, 7, 2, -15, 36, -21, -13, Ascii.SI, -2, -9, -6, 34, -15, -19, Ascii.VT, -5, 7, 2, -15, 33, -33, 19, -17, 32, -15, -19, Ascii.VT, -5, 7, -10, Ascii.US, -20, -13, 8, Ascii.VT, Ascii.CR, -27, -27, -1, 7, 6, 33, -51, Ascii.FF, -3, 8, -1, -13};
        $$b = 68;
        getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
        artificialFrame = 1;
        TopicBuilder = (char) 10221;
        ICustomTabsCallback = (char) 34153;
        extraCallbackWithResult = (char) 30555;
        onMessageChannelReady = (char) 44352;
    }
}
