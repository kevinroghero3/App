package com.proyecto26.inappbrowser;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
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
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.google.common.base.Ascii;
import com.salesforce.marketingcloud.analytics.stats.b;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import kotlin.io.path.ExceptionsCollector$$ExternalSyntheticApiModelOutline6;
import o.ArtificialStackFrames;
import o.onRelationshipValidationResult;
import org.apache.commons.lang3.CharEncoding;
import org.greenrobot.eventbus.EventBus;

/* JADX INFO: loaded from: classes.dex */
public class ChromeTabsManagerActivity extends Activity {
    private static final byte[] $$a;
    private static final int $$b;
    private static final byte[] $$d;
    private static final int $$e;
    static final String BROWSER_RESULT_TYPE = "browserResultType";
    static final String DEFAULT_RESULT_TYPE = "dismiss";
    static final String KEY_BROWSER_INTENT = "browserIntent";
    private static int artificialFrame;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME;
    private static long onPostMessage;
    private static final byte[] $$c = {49, Ascii.SUB, -88, -35};
    private static final int $$f = 163;
    private static int $10 = 0;
    private static int $11 = 1;
    private boolean mOpened = false;
    private String resultType = null;
    private boolean isError = false;

    /* JADX WARN: Code duplicated, block: B:10:0x0024  */
    /* JADX WARN: Code duplicated, block: B:8:0x001e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0024 -> B:11:0x002a). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0024
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$g(byte r5, short r6, int r7) {
        /*
            int r5 = r5 * 3
            int r5 = 111 - r5
            int r7 = r7 * 4
            int r0 = 1 - r7
            int r6 = r6 * 2
            int r6 = 3 - r6
            byte[] r1 = com.proyecto26.inappbrowser.ChromeTabsManagerActivity.$$c
            byte[] r0 = new byte[r0]
            r2 = 0
            int r7 = 0 - r7
            if (r1 != 0) goto L18
            r4 = r7
            r3 = r2
            goto L2a
        L18:
            r3 = r2
        L19:
            byte r4 = (byte) r5
            r0[r3] = r4
            if (r3 != r7) goto L24
            java.lang.String r5 = new java.lang.String
            r5.<init>(r0, r2)
            return r5
        L24:
            int r3 = r3 + 1
            int r6 = r6 + 1
            r4 = r1[r6]
        L2a:
            int r5 = r5 + r4
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: com.proyecto26.inappbrowser.ChromeTabsManagerActivity.$$g(byte, short, int):java.lang.String");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0024  */
    /* JADX WARN: Code duplicated, block: B:8:0x001c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0024 -> B:11:0x0028). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0024
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void b(byte r6, byte r7, short r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = com.proyecto26.inappbrowser.ChromeTabsManagerActivity.$$a
            int r8 = r8 + 4
            int r1 = 21 - r7
            int r6 = 112 - r6
            byte[] r1 = new byte[r1]
            int r7 = 20 - r7
            r2 = 0
            if (r0 != 0) goto L13
            r4 = r7
            r6 = r8
            r3 = r2
            goto L28
        L13:
            r3 = r2
            r5 = r8
            r8 = r6
            r6 = r5
        L17:
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r7) goto L24
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L24:
            r4 = r0[r6]
            int r3 = r3 + 1
        L28:
            int r4 = -r4
            int r8 = r8 + r4
            int r6 = r6 + 1
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: com.proyecto26.inappbrowser.ChromeTabsManagerActivity.b(byte, byte, short, java.lang.Object[]):void");
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
    private static void c(int r6, int r7, short r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = com.proyecto26.inappbrowser.ChromeTabsManagerActivity.$$d
            int r7 = r7 + 36
            int r6 = 595 - r6
            int r1 = r8 + 1
            byte[] r1 = new byte[r1]
            r2 = 0
            if (r0 != 0) goto L11
            r7 = r6
            r3 = r8
            r4 = r2
            goto L26
        L11:
            r3 = r2
        L12:
            byte r4 = (byte) r7
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r8) goto L21
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L21:
            r3 = r0[r6]
            r5 = r7
            r7 = r6
            r6 = r5
        L26:
            int r3 = -r3
            int r6 = r6 + r3
            int r6 = r6 + (-4)
            int r7 = r7 + 1
            r3 = r4
            r5 = r7
            r7 = r6
            r6 = r5
            goto L12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.proyecto26.inappbrowser.ChromeTabsManagerActivity.c(int, int, short, java.lang.Object[]):void");
    }

    public static Intent createStartIntent(Context context, Intent intent) {
        Intent intentCreateBaseIntent = createBaseIntent(context);
        intentCreateBaseIntent.putExtra(KEY_BROWSER_INTENT, intent);
        return intentCreateBaseIntent;
    }

    public static Intent createDismissIntent(Context context) {
        Intent intentCreateBaseIntent = createBaseIntent(context);
        intentCreateBaseIntent.addFlags(AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
        return intentCreateBaseIntent;
    }

    private static Intent createBaseIntent(Context context) {
        return new Intent(context, (Class<?>) ChromeTabsManagerActivity.class);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        try {
            super.onCreate(bundle);
            if (getIntent().hasExtra(KEY_BROWSER_INTENT) && (bundle == null || bundle.getString(BROWSER_RESULT_TYPE) == null)) {
                Intent intent = (Intent) getIntent().getParcelableExtra(KEY_BROWSER_INTENT);
                intent.addFlags(AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
                startActivity(intent);
                this.resultType = DEFAULT_RESULT_TYPE;
                return;
            }
            finish();
        } catch (Exception e) {
            this.isError = true;
            EventBus.getDefault().post(new ChromeTabsDismissedEvent("Unable to open url.", this.resultType, Boolean.valueOf(this.isError)));
            finish();
            e.printStackTrace();
        }
    }

    private static void a(int i, char[] cArr, Object[] objArr) throws Throwable {
        int i2 = 2 % 2;
        onRelationshipValidationResult onrelationshipvalidationresult = new onRelationshipValidationResult();
        char[] cArrAccessartificialFrame = onRelationshipValidationResult.accessartificialFrame(onPostMessage ^ 2573525503365829440L, cArr, i);
        onrelationshipvalidationresult.e = 4;
        while (onrelationshipvalidationresult.e < cArrAccessartificialFrame.length) {
            int i3 = $11 + 37;
            $10 = i3 % 128;
            int i4 = i3 % 2;
            onrelationshipvalidationresult.d = onrelationshipvalidationresult.e - 4;
            int i5 = onrelationshipvalidationresult.e;
            try {
                Object[] objArr2 = {Long.valueOf(cArrAccessartificialFrame[onrelationshipvalidationresult.e] ^ cArrAccessartificialFrame[onrelationshipvalidationresult.e % 4]), Long.valueOf(onrelationshipvalidationresult.d), Long.valueOf(onPostMessage)};
                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(797310229);
                if (objAccessartificialFrame == null) {
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(26 - MotionEvent.axisFromString(""), (char) (30690 - View.getDefaultSize(0, 0)), 189 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), -1327449315, false, "k", new Class[]{Long.TYPE, Long.TYPE, Long.TYPE});
                }
                cArrAccessartificialFrame[i5] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                Object[] objArr3 = {onrelationshipvalidationresult, onrelationshipvalidationresult};
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(321542193);
                if (objAccessartificialFrame2 == null) {
                    byte b = (byte) 0;
                    byte b2 = b;
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(33 - TextUtils.getCapsMode("", 0, 0), (char) TextUtils.getTrimmedLength(""), 1483 - ExpandableListView.getPackedPositionGroup(0L), -1940971975, false, $$g(b, b2, b2), new Class[]{Object.class, Object.class});
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
        String str = new String(cArrAccessartificialFrame, 4, cArrAccessartificialFrame.length - 4);
        int i6 = $10 + 93;
        $11 = i6 % 128;
        if (i6 % 2 != 0) {
            objArr[0] = str;
        } else {
            int i7 = 47 / 0;
            objArr[0] = str;
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (!this.mOpened) {
            this.mOpened = true;
        } else {
            this.resultType = "cancel";
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        String str = this.resultType;
        if (str != null) {
            str.hashCode();
            if (str.equals("cancel")) {
                EventBus.getDefault().post(new ChromeTabsDismissedEvent("chrome tabs activity closed", this.resultType, Boolean.valueOf(this.isError)));
            } else {
                EventBus.getDefault().post(new ChromeTabsDismissedEvent("chrome tabs activity destroyed", DEFAULT_RESULT_TYPE, Boolean.valueOf(this.isError)));
            }
            this.resultType = null;
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.resultType = bundle.getString(BROWSER_RESULT_TYPE);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putString(BROWSER_RESULT_TYPE, DEFAULT_RESULT_TYPE);
        super.onSaveInstanceState(bundle);
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0b21  */
    /* JADX WARN: Code duplicated, block: B:106:0x0ba8  */
    /* JADX WARN: Code duplicated, block: B:111:0x0c17  */
    /* JADX WARN: Code duplicated, block: B:159:0x10f5  */
    /* JADX WARN: Code duplicated, block: B:160:0x1173  */
    /* JADX WARN: Code duplicated, block: B:165:0x1265  */
    /* JADX WARN: Code duplicated, block: B:175:0x138c  */
    /* JADX WARN: Code duplicated, block: B:178:0x13be A[Catch: all -> 0x245e, TryCatch #10 {all -> 0x245e, blocks: (B:321:0x22ca, B:323:0x22d7, B:324:0x2309, B:326:0x2313, B:328:0x2320, B:329:0x234e, B:261:0x1c11, B:263:0x1c17, B:264:0x1c46, B:266:0x1c70, B:267:0x1cfa, B:176:0x13a9, B:178:0x13be, B:179:0x13ec, B:66:0x070a, B:68:0x072c, B:69:0x0783), top: B:380:0x070a }] */
    /* JADX WARN: Code duplicated, block: B:182:0x1403  */
    /* JADX WARN: Code duplicated, block: B:187:0x146a  */
    /* JADX WARN: Code duplicated, block: B:191:0x14c8  */
    /* JADX WARN: Code duplicated, block: B:192:0x1538  */
    /* JADX WARN: Code duplicated, block: B:194:0x1543  */
    /* JADX WARN: Code duplicated, block: B:197:0x1547 A[LOOP:0: B:195:0x1544->B:197:0x1547, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:203:0x161e  */
    /* JADX WARN: Code duplicated, block: B:213:0x175f  */
    /* JADX WARN: Code duplicated, block: B:215:0x1766  */
    /* JADX WARN: Code duplicated, block: B:217:0x17dd  */
    /* JADX WARN: Code duplicated, block: B:219:0x17e1  */
    /* JADX WARN: Code duplicated, block: B:221:0x17ed  */
    /* JADX WARN: Code duplicated, block: B:224:0x17f7  */
    /* JADX WARN: Code duplicated, block: B:225:0x17f9  */
    /* JADX WARN: Code duplicated, block: B:228:0x1808 A[PHI: r0
  0x1808: PHI (r0v282 android.content.Context) = (r0v281 android.content.Context), (r0v302 android.content.Context) binds: [B:216:0x17db, B:224:0x17f7] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:232:0x189d  */
    /* JADX WARN: Code duplicated, block: B:234:0x18a6  */
    /* JADX WARN: Code duplicated, block: B:239:0x1916  */
    /* JADX WARN: Code duplicated, block: B:23:0x027b  */
    /* JADX WARN: Code duplicated, block: B:245:0x197b  */
    /* JADX WARN: Code duplicated, block: B:246:0x19ec  */
    /* JADX WARN: Code duplicated, block: B:251:0x1ac0  */
    /* JADX WARN: Code duplicated, block: B:260:0x1c0e  */
    /* JADX WARN: Code duplicated, block: B:263:0x1c17 A[Catch: all -> 0x245e, TryCatch #10 {all -> 0x245e, blocks: (B:321:0x22ca, B:323:0x22d7, B:324:0x2309, B:326:0x2313, B:328:0x2320, B:329:0x234e, B:261:0x1c11, B:263:0x1c17, B:264:0x1c46, B:266:0x1c70, B:267:0x1cfa, B:176:0x13a9, B:178:0x13be, B:179:0x13ec, B:66:0x070a, B:68:0x072c, B:69:0x0783), top: B:380:0x070a }] */
    /* JADX WARN: Code duplicated, block: B:266:0x1c70 A[Catch: all -> 0x245e, TryCatch #10 {all -> 0x245e, blocks: (B:321:0x22ca, B:323:0x22d7, B:324:0x2309, B:326:0x2313, B:328:0x2320, B:329:0x234e, B:261:0x1c11, B:263:0x1c17, B:264:0x1c46, B:266:0x1c70, B:267:0x1cfa, B:176:0x13a9, B:178:0x13be, B:179:0x13ec, B:66:0x070a, B:68:0x072c, B:69:0x0783), top: B:380:0x070a }] */
    /* JADX WARN: Code duplicated, block: B:270:0x1d0d  */
    /* JADX WARN: Code duplicated, block: B:275:0x1d79  */
    /* JADX WARN: Code duplicated, block: B:279:0x1dd1  */
    /* JADX WARN: Code duplicated, block: B:280:0x1e3f  */
    /* JADX WARN: Code duplicated, block: B:285:0x1f17  */
    /* JADX WARN: Code duplicated, block: B:295:0x2052  */
    /* JADX WARN: Code duplicated, block: B:297:0x2059  */
    /* JADX WARN: Code duplicated, block: B:299:0x20c0  */
    /* JADX WARN: Code duplicated, block: B:301:0x20c4  */
    /* JADX WARN: Code duplicated, block: B:304:0x20d8  */
    /* JADX WARN: Code duplicated, block: B:305:0x20da  */
    /* JADX WARN: Code duplicated, block: B:310:0x2178  */
    /* JADX WARN: Code duplicated, block: B:315:0x21e6  */
    /* JADX WARN: Code duplicated, block: B:319:0x2243  */
    /* JADX WARN: Code duplicated, block: B:320:0x22c5  */
    /* JADX WARN: Code duplicated, block: B:323:0x22d7 A[Catch: all -> 0x245e, TryCatch #10 {all -> 0x245e, blocks: (B:321:0x22ca, B:323:0x22d7, B:324:0x2309, B:326:0x2313, B:328:0x2320, B:329:0x234e, B:261:0x1c11, B:263:0x1c17, B:264:0x1c46, B:266:0x1c70, B:267:0x1cfa, B:176:0x13a9, B:178:0x13be, B:179:0x13ec, B:66:0x070a, B:68:0x072c, B:69:0x0783), top: B:380:0x070a }] */
    /* JADX WARN: Code duplicated, block: B:328:0x2320 A[Catch: all -> 0x245e, TryCatch #10 {all -> 0x245e, blocks: (B:321:0x22ca, B:323:0x22d7, B:324:0x2309, B:326:0x2313, B:328:0x2320, B:329:0x234e, B:261:0x1c11, B:263:0x1c17, B:264:0x1c46, B:266:0x1c70, B:267:0x1cfa, B:176:0x13a9, B:178:0x13be, B:179:0x13ec, B:66:0x070a, B:68:0x072c, B:69:0x0783), top: B:380:0x070a }] */
    @Override // android.app.Activity
    public void onStart() throws Throwable {
        Object[] objArr;
        int i;
        Object[] objArr2;
        int i2;
        Object[] objArr3;
        Object objAccessartificialFrame;
        Object objAccessartificialFrame2;
        int i3;
        Object[] objArr4;
        int i4;
        int i5;
        int i6;
        Object objAccessartificialFrame3;
        long j;
        Object objAccessartificialFrame4;
        Object[] objArrAccessartificialFrame$78cbbd35;
        Object objAccessartificialFrame5;
        Object objAccessartificialFrame6;
        Object[] objArr5;
        int i7;
        int i8;
        ArrayList arrayList;
        String[] strArr;
        int i9;
        int i10;
        Object objAccessartificialFrame7;
        long j2;
        Context baseContext;
        Object obj;
        Object[] objArr6;
        Object objAccessartificialFrame8;
        Object objAccessartificialFrame9;
        int i11;
        Object[] objArr7;
        int i12;
        int i13;
        Object objAccessartificialFrame10;
        long j3;
        Object objAccessartificialFrame11;
        Object objAccessartificialFrame12;
        Object[] objArr8;
        Object objAccessartificialFrame13;
        Object objAccessartificialFrame14;
        Object obj2;
        int i14;
        Object obj3;
        int i15;
        int i16;
        Object objAccessartificialFrame15;
        long j4;
        Context baseContext2;
        Object[] objArr9;
        Object objAccessartificialFrame16;
        Object objAccessartificialFrame17;
        int i17;
        int i18;
        Object objAccessartificialFrame18;
        Object objAccessartificialFrame19;
        int i19 = 2 % 2;
        Object[] objArr10 = new Object[1];
        a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 4, new char[]{11853, 13658, 43204, 18336, 11820, 34820, 53952, 28738, 56034, 33987, 51072, 27614, 51106, 37785, 51978, 26339, 61556, 44633, 61456, 21013, 64800, 42281, 58824, 19807, 59886, 45505}, objArr10);
        String str = (String) objArr10[0];
        Object[] objArr11 = new Object[1];
        a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(19) - 111, new char[]{50696, 63944, 25624, 50150, 50797, 17556, 7705, 62470, 12987, 18525, 2908, 61412, 12269, 24345, 1940, 57986, 6177, 25301, 15581}, objArr11);
        String str2 = (String) objArr11[0];
        Object[] objArr12 = new Object[1];
        a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(10) - 118, new char[]{45557, 13559, 55736, 4420, 45471, 35238, 41902, 9909, 17691, 34155, 46841, 15738, 22546, 37481, 47627, 12333, 28614, 45043, 33149, 1273}, objArr12);
        String str3 = (String) objArr12[0];
        Object[] objArr13 = new Object[1];
        a((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) - 1, new char[]{45825, 47696, 56571, 9311, 45928, 1796, 42750, 5025, 18357, 3017, 45999, 2166, 23241, 7297, 49000, 1319, 27906, 8527, 33855, 12778}, objArr13);
        String str4 = (String) objArr13[0];
        Object objAccessartificialFrame20 = ArtificialStackFrames.accessartificialFrame(1313006081);
        if (objAccessartificialFrame20 == null) {
            int mirror = 'E' - AndroidCharacter.getMirror('0');
            char mirror2 = (char) ('0' - AndroidCharacter.getMirror('0'));
            int iIndexOf = 465 - TextUtils.indexOf("", "");
            byte[] bArr = $$a;
            byte b = bArr[5];
            Object[] objArr14 = new Object[1];
            b((byte) (b - 1), bArr[18], (byte) (b - 1), objArr14);
            objAccessartificialFrame20 = ArtificialStackFrames.coroutineCreation(mirror, mirror2, iIndexOf, -785931255, false, (String) objArr14[0], null);
        }
        long j5 = ((Field) objAccessartificialFrame20).getLong(null);
        if (j5 == -1 || j5 + 2050 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Context baseContext3 = getBaseContext();
            if (baseContext3 == null) {
                Object[] objArr15 = new Object[1];
                a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(13) - 101, new char[]{49248, 9089, 2515, 30328, 49153, 40671, 29655, 16794, 13519, 37400, 26263, 23046, 10625, 34113, 27203, 22342, 7777, 47250, 20743, 25537, 4886, 46040, 17607, 31889, 2036, 42777, 19329, 35149, 31873, 23125}, objArr15);
                Class<?> cls = Class.forName((String) objArr15[0]);
                Object[] objArr16 = new Object[1];
                a(View.getDefaultSize(0, 0), new char[]{37436, 30945, 40643, 39809, 37471, 50596, 58577, 44131, 26265, 51583, 61847, 46992, 31692, 56865, 64847, 47864, 19487, 58352, 50711, 36408, 16723, 59583}, objArr16);
                baseContext3 = (Context) cls.getMethod((String) objArr16[0], new Class[0]).invoke(null, null);
            }
            if (baseContext3 != null) {
                if (baseContext3 instanceof ContextWrapper) {
                    int i20 = getARTIFICIAL_FRAME_PACKAGE_NAME + b.i;
                    artificialFrame = i20 % 128;
                    int i21 = i20 % 2;
                    if (((ContextWrapper) baseContext3).getBaseContext() != null) {
                        baseContext3 = baseContext3.getApplicationContext();
                    } else {
                        baseContext3 = null;
                    }
                } else {
                    baseContext3 = baseContext3.getApplicationContext();
                }
            }
            int iIntValue = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
            Object[] objArr17 = new Object[1];
            a(ViewConfiguration.getMaximumDrawingCacheSize() >> 24, new char[]{13962, 24034, 12038, 2295, 14060, 57571, 21841, 16213, 49785, 60535, 16448, 9360, 57193, 64363, 19667, 10630, 59642, 50852, 30622, 7489, 58863, 52662, 25168, 594, 61823, 55595, 27934, 63425, 35389, 9267, 6613, 64727, 34734, 13226, 1219, 57409, 37100, 16103, 3923, 54531, 44146, 2676, 14879, 56001, 47418, 4401, 9856, 53202, 45810, 7334, 53701, 45847, 20460, 27571, 56327, 47184, 23411, 30502, 50960, 44486, 21562, 16945, 62343, 37506, 25085, 18929, 65218, 34324}, objArr17);
            String str5 = (String) objArr17[0];
            Object[] objArr18 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(17) - 105, new char[]{3573, 48990, 50099, 17929, 3520, 601, 47542, 29180, 63824, 3784, 44195, 27245, 58436, 6615, 41062, 26491, 54147, 9245, 39799, 21472, 57030, 12120, 36578, 19708, 51796, 15304, 33190, 47416, 45388, 50906, 62821, 45611, 48337, 53531, 59505, 44779, 43968, 56413, 58337, 39851, 38656, 59599, 55030, 37996, 33356, 62428, 51814, 33067, 35206, 65054, 15652, 65003, 29890, 35165, 12466, 63231, 24663, 38347, 11173, 58223, 28439, 41103, 8043, 56362, 23173, 43855, 4725, 51388}, objArr18);
            try {
                Object[] objArr19 = {baseContext3, new String[]{str5, (String) objArr18[0]}, Integer.valueOf(iIntValue), 1, -823667838};
                byte[] bArr2 = $$d;
                Object[] objArr20 = new Object[1];
                c((short) 591, (byte) (-bArr2[26]), bArr2[569], objArr20);
                Class<?> cls2 = Class.forName((String) objArr20[0]);
                Object[] objArr21 = new Object[1];
                c((short) 527, bArr2[148], bArr2[436], objArr21);
                Object[] objArr22 = (Object[]) cls2.getMethod((String) objArr21[0], Context.class, String[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr19);
                int i22 = ((int[]) objArr22[0])[0];
                int i23 = ((int[]) objArr22[3])[0];
                if (baseContext3 != null) {
                    Object objAccessartificialFrame21 = ArtificialStackFrames.accessartificialFrame(1142731807);
                    if (objAccessartificialFrame21 == null) {
                        int iLastIndexOf = 20 - TextUtils.lastIndexOf("", '0');
                        char trimmedLength = (char) TextUtils.getTrimmedLength("");
                        int iIndexOf2 = 465 - TextUtils.indexOf("", "");
                        byte[] bArr3 = $$a;
                        Object[] objArr23 = new Object[1];
                        b((byte) (bArr3[5] - 1), bArr3[18], bArr3[28], objArr23);
                        objAccessartificialFrame21 = ArtificialStackFrames.coroutineCreation(iLastIndexOf, trimmedLength, iIndexOf2, -612765161, false, (String) objArr23[0], null);
                    }
                    ((Field) objAccessartificialFrame21).set(null, objArr22);
                    try {
                        Long lValueOf = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                        Object objAccessartificialFrame22 = ArtificialStackFrames.accessartificialFrame(1313006081);
                        if (objAccessartificialFrame22 == null) {
                            int i24 = 22 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
                            char cIndexOf = (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0));
                            int bitsPerPixel = 464 - ImageFormat.getBitsPerPixel(0);
                            byte[] bArr4 = $$a;
                            byte b2 = bArr4[5];
                            Object[] objArr24 = new Object[1];
                            b((byte) (b2 - 1), bArr4[18], (byte) (b2 - 1), objArr24);
                            objAccessartificialFrame22 = ArtificialStackFrames.coroutineCreation(i24, cIndexOf, bitsPerPixel, -785931255, false, (String) objArr24[0], null);
                        }
                        ((Field) objAccessartificialFrame22).set(null, lValueOf);
                    } catch (Exception unused) {
                        throw new RuntimeException();
                    }
                } else {
                    objArr22 = objArr22;
                }
                objArr = objArr22;
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        } else {
            int i25 = getARTIFICIAL_FRAME_PACKAGE_NAME + 125;
            artificialFrame = i25 % 128;
            int i26 = i25 % 2;
            Object objAccessartificialFrame23 = ArtificialStackFrames.accessartificialFrame(1142731807);
            if (objAccessartificialFrame23 == null) {
                int maximumDrawingCacheSize = 21 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                char pressedStateDuration = (char) (ViewConfiguration.getPressedStateDuration() >> 16);
                int iKeyCodeFromString = 465 - KeyEvent.keyCodeFromString("");
                byte[] bArr5 = $$a;
                Object[] objArr25 = new Object[1];
                b((byte) (bArr5[5] - 1), bArr5[18], bArr5[28], objArr25);
                objAccessartificialFrame23 = ArtificialStackFrames.coroutineCreation(maximumDrawingCacheSize, pressedStateDuration, iKeyCodeFromString, -612765161, false, (String) objArr25[0], null);
            }
            Object[] objArr26 = (Object[]) ((Field) objAccessartificialFrame23).get(null);
            objArr = new Object[]{new int[]{i}, strArr, new int[1], new int[]{i}};
            int i27 = ((int[]) objArr26[3])[0];
            int i28 = ((int[]) objArr26[0])[0];
            String[] strArr2 = (String[]) objArr26[1];
            int iIdentityHashCode = System.identityHashCode(this);
            int i29 = ~iIdentityHashCode;
            int i30 = ((((-303828055) + (((~(iIdentityHashCode | (-26849306))) | ((~(26849305 | i29)) | (-187199032))) * (-564))) + ((~((-17309714) | iIdentityHashCode)) * 1128)) + (((~((-187199032) | i29)) | 9539592) * 564)) - 823667838;
            int i31 = (i30 << 13) ^ i30;
            int i32 = i31 ^ (i31 >>> 17);
            ((int[]) objArr[2])[0] = i32 ^ (i32 << 5);
        }
        int i33 = ((int[]) objArr[0])[0];
        int i34 = ((int[]) objArr[3])[0];
        if (i34 == i33) {
            Object[] objArr27 = {new int[]{i}, strArr, new int[1], new int[]{i}};
            int i35 = ((int[]) objArr[2])[0];
            int i36 = ((int[]) objArr[3])[0];
            int i37 = ((int[]) objArr[0])[0];
            String[] strArr3 = (String[]) objArr[1];
            int iUptimeMillis = (int) SystemClock.uptimeMillis();
            int i38 = i35 + 1296720095 + (((~(136863943 | iUptimeMillis)) | 134766594) * (-502)) + ((~((~iUptimeMillis) | 431980263)) * (-502)) + (((~(iUptimeMillis | (-297213670))) | 136863943) * TypedValues.PositionType.TYPE_DRAWPATH);
            int i39 = (i38 << 13) ^ i38;
            int i40 = i39 ^ (i39 >>> 17);
            ((int[]) objArr27[2])[0] = i40 ^ (i40 << 5);
            i = 0;
        } else {
            ArrayList arrayList2 = new ArrayList();
            String[] strArr4 = (String[]) objArr[1];
            if (strArr4 != null) {
                for (String str6 : strArr4) {
                    arrayList2.add(str6);
                }
            }
            try {
                Object[] objArr28 = {Long.valueOf(((long) (i33 ^ i34)) ^ (((long) 222748689) << 32)), Long.valueOf(222748753)};
                short s = (short) ($$e | 306);
                byte[] bArr6 = $$d;
                Object[] objArr29 = new Object[1];
                c(s, (byte) (-bArr6[26]), bArr6[162], objArr29);
                Class<?> cls3 = Class.forName((String) objArr29[0]);
                Object[] objArr30 = new Object[1];
                c((short) 465, bArr6[31], bArr6[19], objArr30);
                cls3.getMethod((String) objArr30[0], Long.TYPE, Long.TYPE).invoke(null, objArr28);
                Object[] objArr31 = {new int[]{i}, strArr, new int[1], new int[]{i}};
                int i41 = ((int[]) objArr[2])[0];
                int i42 = ((int[]) objArr[3])[0];
                int i43 = ((int[]) objArr[0])[0];
                String[] strArr5 = (String[]) objArr[1];
                int i44 = ~(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 2049799550);
                int i45 = i41 + (((1729855504 + (((~((-1061539051) | i44)) | 901189324) * (-933))) + (((~(i44 | 901189324)) | (-1073204975)) * 933)) - 2000594796);
                int i46 = (i45 << 13) ^ i45;
                int i47 = i46 ^ (i46 >>> 17);
                i = 0;
                ((int[]) objArr31[2])[0] = i47 ^ (i47 << 5);
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 == null) {
                    throw th2;
                }
                throw cause2;
            }
        }
        Object objAccessartificialFrame24 = ArtificialStackFrames.accessartificialFrame(-1268268649);
        if (objAccessartificialFrame24 == null) {
            int iAlpha = 25 - Color.alpha(i);
            char modifierMetaStateMask = (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 30069);
            int i48 = (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 815;
            byte[] bArr7 = $$a;
            byte b3 = bArr7[5];
            Object[] objArr32 = new Object[1];
            b((byte) (b3 - 1), bArr7[18], (byte) (b3 - 1), objArr32);
            objAccessartificialFrame24 = ArtificialStackFrames.coroutineCreation(iAlpha, modifierMetaStateMask, i48, 721586079, false, (String) objArr32[0], null);
        }
        long j6 = ((Field) objAccessartificialFrame24).getLong(null);
        if (j6 == -1 || j6 + 1915 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            try {
                Object[] objArr33 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, -483144290};
                Object objAccessartificialFrame25 = ArtificialStackFrames.accessartificialFrame(1327366003);
                if (objAccessartificialFrame25 == null) {
                    int i49 = (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 25;
                    char scrollBarSize = (char) (30068 - (ViewConfiguration.getScrollBarSize() >> 8));
                    int i50 = 816 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                    byte[] bArr8 = $$a;
                    Object[] objArr34 = new Object[1];
                    b((byte) 28, bArr8[9], (byte) (bArr8[75] - 1), objArr34);
                    objAccessartificialFrame25 = ArtificialStackFrames.coroutineCreation(i49, scrollBarSize, i50, -797394565, false, (String) objArr34[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                }
                objArr2 = (Object[]) ((Method) objAccessartificialFrame25).invoke(null, objArr33);
                Object objAccessartificialFrame26 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame26 == null) {
                    int i51 = 26 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1));
                    char jumpTapTimeout = (char) (30068 - (ViewConfiguration.getJumpTapTimeout() >> 16));
                    int i52 = 817 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                    byte[] bArr9 = $$a;
                    Object[] objArr35 = new Object[1];
                    b((byte) (bArr9[5] - 1), bArr9[18], bArr9[28], objArr35);
                    objAccessartificialFrame26 = ArtificialStackFrames.coroutineCreation(i51, jumpTapTimeout, i52, 891606461, false, (String) objArr35[0], null);
                }
                ((Field) objAccessartificialFrame26).set(null, objArr2);
                try {
                    Long lValueOf2 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame27 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                    if (objAccessartificialFrame27 == null) {
                        int i53 = (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 24;
                        char cIndexOf2 = (char) (30068 - TextUtils.indexOf("", "", 0, 0));
                        int iKeyCodeFromString2 = KeyEvent.keyCodeFromString("") + 816;
                        byte[] bArr10 = $$a;
                        byte b4 = bArr10[5];
                        Object[] objArr36 = new Object[1];
                        b((byte) (b4 - 1), bArr10[18], (byte) (b4 - 1), objArr36);
                        objAccessartificialFrame27 = ArtificialStackFrames.coroutineCreation(i53, cIndexOf2, iKeyCodeFromString2, 721586079, false, (String) objArr36[0], null);
                    }
                    ((Field) objAccessartificialFrame27).set(null, lValueOf2);
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
        } else {
            Object objAccessartificialFrame28 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame28 == null) {
                int keyRepeatDelay = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 25;
                char cAxisFromString = (char) (MotionEvent.axisFromString("") + 30069);
                int i54 = 817 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1));
                byte[] bArr11 = $$a;
                Object[] objArr37 = new Object[1];
                b((byte) (bArr11[5] - 1), bArr11[18], bArr11[28], objArr37);
                objAccessartificialFrame28 = ArtificialStackFrames.coroutineCreation(keyRepeatDelay, cAxisFromString, i54, 891606461, false, (String) objArr37[0], null);
            }
            Object[] objArr38 = (Object[]) ((Field) objAccessartificialFrame28).get(null);
            objArr2 = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i55 = ((int[]) objArr38[0])[0];
            int i56 = ((int[]) objArr38[1])[0];
            String[] strArr6 = (String[]) objArr38[2];
            int iIdentityHashCode2 = System.identityHashCode(this);
            int i57 = ~iIdentityHashCode2;
            int i58 = ((1390474682 + (((~((-201326671) | iIdentityHashCode2)) | ((~(i57 | (-830159250))) | 3154304)) * 717)) + (((~(iIdentityHashCode2 | (-830159250))) | ((~((-201326671) | i57)) | 3154304)) * 717)) - 483144290;
            int i59 = (i58 << 13) ^ i58;
            int i60 = i59 ^ (i59 >>> 17);
            ((int[]) objArr2[3])[0] = i60 ^ (i60 << 5);
        }
        int i61 = ((int[]) objArr2[1])[0];
        int i62 = ((int[]) objArr2[0])[0];
        if (i62 == i61) {
            Object[] objArr39 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i63 = ((int[]) objArr2[3])[0];
            int i64 = ((int[]) objArr2[0])[0];
            int i65 = ((int[]) objArr2[1])[0];
            String[] strArr7 = (String[]) objArr2[2];
            int iIdentityHashCode3 = System.identityHashCode(this);
            int i66 = ~iIdentityHashCode3;
            int i67 = i63 + (-1453411098) + (((~(692677701 | i66)) | (~((-138421317) | iIdentityHashCode3))) * (-831)) + ((~(1029271383 | iIdentityHashCode3)) * (-1662)) + (((~(iIdentityHashCode3 | (-692677702))) | (~(i66 | (-890850068))) | (~(890850067 | iIdentityHashCode3))) * 831);
            int i68 = (i67 << 13) ^ i67;
            int i69 = i68 ^ (i68 >>> 17);
            i2 = 0;
            ((int[]) objArr39[3])[0] = i69 ^ (i69 << 5);
        } else {
            ArrayList arrayList3 = new ArrayList();
            String[] strArr8 = (String[]) objArr2[2];
            if (strArr8 != null) {
                for (String str7 : strArr8) {
                    arrayList3.add(str7);
                }
            }
            Object[] objArr40 = {Long.valueOf(((long) (i61 ^ i62)) ^ (((long) (-287478711)) << 32)), Long.valueOf(-287478712)};
            short s2 = (short) ($$e | 262);
            byte[] bArr12 = $$d;
            Object[] objArr41 = new Object[1];
            c(s2, (byte) (-bArr12[26]), bArr12[121], objArr41);
            Class<?> cls4 = Class.forName((String) objArr41[0]);
            Object[] objArr42 = new Object[1];
            c((short) 465, bArr12[31], bArr12[19], objArr42);
            cls4.getMethod((String) objArr42[0], Long.TYPE, Long.TYPE).invoke(null, objArr40);
            Object[] objArr43 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i70 = ((int[]) objArr2[3])[0];
            int i71 = ((int[]) objArr2[0])[0];
            int i72 = ((int[]) objArr2[1])[0];
            String[] strArr9 = (String[]) objArr2[2];
            int iMyTid = Process.myTid();
            int i73 = ~((-134348946) | iMyTid);
            int i74 = i70 + (-127873871) + ((34410528 | i73) * (-476)) + (i73 * 952) + ((~((~iMyTid) | (-134348946))) * 476);
            int i75 = (i74 << 13) ^ i74;
            int i76 = i75 ^ (i75 >>> 17);
            i2 = 0;
            ((int[]) objArr43[3])[0] = i76 ^ (i76 << 5);
        }
        Object objAccessartificialFrame29 = ArtificialStackFrames.accessartificialFrame(1056123296);
        if (objAccessartificialFrame29 == null) {
            int iIndexOf3 = TextUtils.indexOf("", "", i2) + 30;
            char cIndexOf3 = (char) (TextUtils.indexOf("", "", i2) + 49362);
            int trimmedLength2 = TextUtils.getTrimmedLength("") + 684;
            byte[] bArr13 = $$a;
            Object[] objArr44 = new Object[1];
            b(bArr13[9], bArr13[28], (byte) (-bArr13[20]), objArr44);
            objAccessartificialFrame29 = ArtificialStackFrames.coroutineCreation(iIndexOf3, cIndexOf3, trimmedLength2, -1583976536, false, (String) objArr44[0], null);
        }
        long j7 = ((Field) objAccessartificialFrame29).getLong(null);
        if (j7 != -1) {
            int i77 = artificialFrame + 49;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i77 % 128;
            int i78 = i77 % 2;
            if (j7 + 1888 >= ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame30 = ArtificialStackFrames.accessartificialFrame(910856866);
                if (objAccessartificialFrame30 == null) {
                    int windowTouchSlop = 30 - (ViewConfiguration.getWindowTouchSlop() >> 8);
                    char modifierMetaStateMask2 = (char) (49361 - ((byte) KeyEvent.getModifierMetaStateMask()));
                    int bitsPerPixel2 = ImageFormat.getBitsPerPixel(0) + 685;
                    byte[] bArr14 = $$a;
                    Object[] objArr45 = new Object[1];
                    b(bArr14[11], bArr14[18], (byte) (-bArr14[15]), objArr45);
                    objAccessartificialFrame30 = ArtificialStackFrames.coroutineCreation(windowTouchSlop, modifierMetaStateMask2, bitsPerPixel2, -1456483158, false, (String) objArr45[0], null);
                }
                Object[] objArr46 = (Object[]) ((Field) objAccessartificialFrame30).get(null);
                Object[] objArr47 = {new int[]{((int[]) objArr46[0])[0]}, new int[]{((int[]) objArr46[1])[0]}, new int[1], (String) objArr46[3]};
                int i79 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 1999590544;
                int i80 = (-251612554) + (((~((-723368626) | i79)) | (-792722174)) * (-502)) + ((~((~i79) | (-537467025))) * (-502)) + (((~(i79 | (-255255150))) | (-723368626)) * TypedValues.PositionType.TYPE_DRAWPATH) + 1782481319;
                int i81 = (i80 << 13) ^ i80;
                int i82 = i81 ^ (i81 >>> 17);
                ((int[]) objArr47[2])[0] = i82 ^ (i82 << 5);
                objArr3 = objArr47;
            } else {
                Object[] objArr48 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 1782481319};
                short s3 = (short) TypedValues.CycleType.TYPE_WAVE_PHASE;
                byte[] bArr15 = $$d;
                Object[] objArr49 = new Object[1];
                c(s3, (byte) (-bArr15[26]), (byte) (-bArr15[244]), objArr49);
                Class<?> cls5 = Class.forName((String) objArr49[0]);
                Object[] objArr50 = new Object[1];
                c((short) 392, (byte) (-bArr15[26]), (byte) (-bArr15[4]), objArr50);
                objArr3 = (Object[]) cls5.getMethod((String) objArr50[0], Integer.TYPE, Integer.TYPE).invoke(null, objArr48);
                objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(910856866);
                if (objAccessartificialFrame == null) {
                    int iKeyCodeFromString3 = 30 - KeyEvent.keyCodeFromString("");
                    char cIndexOf4 = (char) (49362 - TextUtils.indexOf("", ""));
                    int deadChar = 684 - KeyEvent.getDeadChar(0, 0);
                    byte[] bArr16 = $$a;
                    Object[] objArr51 = new Object[1];
                    b(bArr16[11], bArr16[18], (byte) (-bArr16[15]), objArr51);
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(iKeyCodeFromString3, cIndexOf4, deadChar, -1456483158, false, (String) objArr51[0], null);
                }
                ((Field) objAccessartificialFrame).set(null, objArr3);
                try {
                    Long lValueOf3 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1056123296);
                    if (objAccessartificialFrame2 == null) {
                        int i83 = 31 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
                        char cLastIndexOf = (char) (49361 - TextUtils.lastIndexOf("", '0', 0));
                        int iMyTid2 = 684 - (Process.myTid() >> 22);
                        byte[] bArr17 = $$a;
                        Object[] objArr52 = new Object[1];
                        b(bArr17[9], bArr17[28], (byte) (-bArr17[20]), objArr52);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(i83, cLastIndexOf, iMyTid2, -1583976536, false, (String) objArr52[0], null);
                    }
                    ((Field) objAccessartificialFrame2).set(null, lValueOf3);
                } catch (Exception unused3) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object[] objArr410 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 1782481319};
            short s4 = (short) TypedValues.CycleType.TYPE_WAVE_PHASE;
            byte[] bArr18 = $$d;
            Object[] objArr411 = new Object[1];
            c(s4, (byte) (-bArr18[26]), (byte) (-bArr18[244]), objArr411);
            Class<?> cls6 = Class.forName((String) objArr411[0]);
            Object[] objArr53 = new Object[1];
            c((short) 392, (byte) (-bArr18[26]), (byte) (-bArr18[4]), objArr53);
            objArr3 = (Object[]) cls6.getMethod((String) objArr53[0], Integer.TYPE, Integer.TYPE).invoke(null, objArr410);
            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(910856866);
            if (objAccessartificialFrame == null) {
                int iKeyCodeFromString4 = 30 - KeyEvent.keyCodeFromString("");
                char cIndexOf5 = (char) (49362 - TextUtils.indexOf("", ""));
                int deadChar2 = 684 - KeyEvent.getDeadChar(0, 0);
                byte[] bArr19 = $$a;
                Object[] objArr54 = new Object[1];
                b(bArr19[11], bArr19[18], (byte) (-bArr19[15]), objArr54);
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(iKeyCodeFromString4, cIndexOf5, deadChar2, -1456483158, false, (String) objArr54[0], null);
            }
            ((Field) objAccessartificialFrame).set(null, objArr3);
            Long lValueOf4 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1056123296);
            if (objAccessartificialFrame2 == null) {
                int i84 = 31 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
                char cLastIndexOf2 = (char) (49361 - TextUtils.lastIndexOf("", '0', 0));
                int iMyTid3 = 684 - (Process.myTid() >> 22);
                byte[] bArr110 = $$a;
                Object[] objArr55 = new Object[1];
                b(bArr110[9], bArr110[28], (byte) (-bArr110[20]), objArr55);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(i84, cLastIndexOf2, iMyTid3, -1583976536, false, (String) objArr55[0], null);
            }
            ((Field) objAccessartificialFrame2).set(null, lValueOf4);
        }
        int i85 = ((int[]) objArr3[1])[0];
        int i86 = ((int[]) objArr3[0])[0];
        if (i86 == i85) {
            int i87 = ((int[]) objArr3[2])[0];
            Object[] objArr56 = {new int[]{((int[]) objArr3[0])[0]}, new int[]{((int[]) objArr3[1])[0]}, new int[1], (String) objArr3[3]};
            int iIdentityHashCode4 = System.identityHashCode(this);
            int i88 = i87 + (-67954274) + (((~((-975171651) | iIdentityHashCode4)) | 1351744) * 576) + (((~((~iIdentityHashCode4) | (-973819907))) | 2100380) * 576) + 778604544;
            int i89 = (i88 << 13) ^ i88;
            int i90 = i89 ^ (i89 >>> 17);
            ((int[]) objArr56[2])[0] = i90 ^ (i90 << 5);
        } else {
            new ArrayList().add((String) objArr3[3]);
            Object[] objArr57 = {Long.valueOf(((long) (i85 ^ i86)) ^ (((long) (-920769633)) << 32)), Long.valueOf(-920769649)};
            byte[] bArr20 = $$d;
            Object[] objArr58 = new Object[1];
            c((short) 376, (byte) (-bArr20[26]), bArr20[83], objArr58);
            Class<?> cls7 = Class.forName((String) objArr58[0]);
            Object[] objArr59 = new Object[1];
            c((short) 465, bArr20[31], bArr20[19], objArr59);
            cls7.getMethod((String) objArr59[0], Long.TYPE, Long.TYPE).invoke(null, objArr57);
            int i91 = ((int[]) objArr3[2])[0];
            Object[] objArr60 = {new int[]{((int[]) objArr3[0])[0]}, new int[]{((int[]) objArr3[1])[0]}, new int[1], (String) objArr3[3]};
            int i92 = ~System.identityHashCode(this);
            int i93 = i91 + 1006247262 + (((-555964417) | i92) * 494) + (((~(i92 | 211591934)) | (-556488927)) * 494);
            int i94 = (i93 << 13) ^ i93;
            int i95 = i94 ^ (i94 >>> 17);
            ((int[]) objArr60[2])[0] = i95 ^ (i95 << 5);
        }
        Object objAccessartificialFrame31 = ArtificialStackFrames.accessartificialFrame(-2127922582);
        if (objAccessartificialFrame31 == null) {
            int i96 = 31 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1));
            char cAxisFromString2 = (char) (49361 - MotionEvent.axisFromString(""));
            int iKeyCodeFromString5 = KeyEvent.keyCodeFromString("") + 684;
            byte[] bArr21 = $$a;
            byte b5 = bArr21[8];
            byte b6 = bArr21[28];
            Object[] objArr61 = new Object[1];
            b(b5, b6, (byte) (b6 | 39), objArr61);
            objAccessartificialFrame31 = ArtificialStackFrames.coroutineCreation(i96, cAxisFromString2, iKeyCodeFromString5, 508509282, false, (String) objArr61[0], null);
        }
        long j8 = ((Field) objAccessartificialFrame31).getLong(null);
        if (j8 != -1) {
            if (j8 + 1935 >= ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame32 = ArtificialStackFrames.accessartificialFrame(777251007);
                if (objAccessartificialFrame32 == null) {
                    int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0) + 30;
                    char cIndexOf6 = (char) (TextUtils.indexOf((CharSequence) "", '0', 0) + 49363);
                    int i97 = (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 683;
                    byte[] bArr22 = $$a;
                    Object[] objArr62 = new Object[1];
                    b(bArr22[28], bArr22[49], (byte) 59, objArr62);
                    objAccessartificialFrame32 = ArtificialStackFrames.coroutineCreation(iMakeMeasureSpec, cIndexOf6, i97, -1321816393, false, (String) objArr62[0], null);
                }
                Object[] objArr63 = (Object[]) ((Field) objAccessartificialFrame32).get(null);
                objArr4 = new Object[]{new int[]{((int[]) objArr63[0])[0]}, new int[]{((int[]) objArr63[1])[0]}, new int[1], (String) objArr63[3]};
                int iNextInt = new Random().nextInt(1047808272);
                int i98 = (((~(1139703 | iNextInt)) | (-980902626)) * 398) + 989336534 + (((~((~iNextInt) | 1139703)) | (-980902626)) * 398) + 32780798;
                int i99 = (i98 << 13) ^ i98;
                int i100 = i99 ^ (i99 >>> 17);
                ((int[]) objArr4[2])[0] = i100 ^ (i100 << 5);
            } else {
                i3 = 0;
            }
            i4 = ((int[]) objArr4[1])[0];
            i5 = ((int[]) objArr4[0])[0];
            if (i5 == i4) {
                int i101 = ((int[]) objArr4[2])[0];
                Object[] objArr64 = {new int[]{((int[]) objArr4[0])[0]}, new int[]{((int[]) objArr4[1])[0]}, new int[1], (String) objArr4[3]};
                int length = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 2120592214;
                int i102 = i101 + 549674652 + (((~((-201891105) | (~length))) | (-776732671)) * (-591)) + ((length | (-201891105)) * 591);
                int i103 = (i102 << 13) ^ i102;
                int i104 = i103 ^ (i103 >>> 17);
                i6 = 0;
                ((int[]) objArr64[2])[0] = i104 ^ (i104 << 5);
            } else {
                Object[] objArr65 = {Long.valueOf(((long) (i4 ^ i5)) ^ (((long) (-1035234036)) << 32)), Long.valueOf(-1035233524)};
                byte[] bArr23 = $$d;
                Object[] objArr66 = new Object[1];
                c((short) 288, (byte) (-bArr23[26]), bArr23[479], objArr66);
                Class<?> cls8 = Class.forName((String) objArr66[0]);
                Object[] objArr67 = new Object[1];
                c((short) 465, bArr23[31], bArr23[19], objArr67);
                cls8.getMethod((String) objArr67[0], Long.TYPE, Long.TYPE).invoke(null, objArr65);
                int i105 = ((int[]) objArr4[2])[0];
                Object[] objArr68 = {new int[]{((int[]) objArr4[0])[0]}, new int[]{((int[]) objArr4[1])[0]}, new int[1], (String) objArr4[3]};
                int i106 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getDisplayMetrics().heightPixels;
                int i107 = i105 + 804154022 + (((~(582593113 | i106)) | 352473220) * (-140)) + ((~(935066333 | i106)) * 70) + (((~(i106 | 396030661)) | 891508892) * 70);
                int i108 = (i107 << 13) ^ i107;
                int i109 = i108 ^ (i108 >>> 17);
                i6 = 0;
                ((int[]) objArr68[2])[0] = i109 ^ (i109 << 5);
            }
            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-444530678);
            if (objAccessartificialFrame3 == null) {
                int offsetAfter = TextUtils.getOffsetAfter("", i6) + 26;
                char offsetBefore = (char) TextUtils.getOffsetBefore("", i6);
                int edgeSlop = (ViewConfiguration.getEdgeSlop() >> 16) + 1041;
                byte[] bArr24 = $$a;
                byte b7 = bArr24[5];
                Object[] objArr69 = new Object[1];
                b((byte) (b7 - 1), bArr24[18], (byte) (b7 - 1), objArr69);
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(offsetAfter, offsetBefore, edgeSlop, 2061780482, false, (String) objArr69[0], null);
            }
            j = ((Field) objAccessartificialFrame3).getLong(null);
            if (j != -1 || j + 4611686018427387912L < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                int iIntValue2 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
                Object[] objArr70 = {-1672848637};
                objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1648942878);
                if (objAccessartificialFrame4 == null) {
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 8, (char) (Color.green(0) + 22251), View.MeasureSpec.makeMeasureSpec(0, 0) + 1033, 47343338, false, null, new Class[]{Integer.TYPE});
                }
                objArrAccessartificialFrame$78cbbd35 = com.facebook.core.R.string.accessartificialFrame$78cbbd35(iIntValue2, 0, ((Constructor) objAccessartificialFrame4).newInstance(objArr70), 598731505, false);
                objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame5 == null) {
                    int iAxisFromString = MotionEvent.axisFromString("") + 27;
                    char cAlpha = (char) Color.alpha(0);
                    int offsetAfter2 = TextUtils.getOffsetAfter("", 0) + 1041;
                    byte[] bArr25 = $$a;
                    Object[] objArr71 = new Object[1];
                    b((byte) (bArr25[5] - 1), bArr25[18], bArr25[28], objArr71);
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(iAxisFromString, cAlpha, offsetAfter2, 1145017376, false, (String) objArr71[0], null);
                }
                ((Field) objAccessartificialFrame5).set(null, objArrAccessartificialFrame$78cbbd35);
                try {
                    Long lValueOf5 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-444530678);
                    if (objAccessartificialFrame6 == null) {
                        int scrollBarSize2 = 26 - (ViewConfiguration.getScrollBarSize() >> 8);
                        char c = (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                        int keyRepeatDelay2 = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 1041;
                        byte[] bArr26 = $$a;
                        byte b8 = bArr26[5];
                        Object[] objArr72 = new Object[1];
                        b((byte) (b8 - 1), bArr26[18], (byte) (b8 - 1), objArr72);
                        objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(scrollBarSize2, c, keyRepeatDelay2, 2061780482, false, (String) objArr72[0], null);
                    }
                    ((Field) objAccessartificialFrame6).set(null, lValueOf5);
                } catch (Exception unused4) {
                    throw new RuntimeException();
                }
            } else {
                Object objAccessartificialFrame33 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame33 == null) {
                    int mode = View.MeasureSpec.getMode(0) + 26;
                    char tapTimeout = (char) (ViewConfiguration.getTapTimeout() >> 16);
                    int absoluteGravity = Gravity.getAbsoluteGravity(0, 0) + 1041;
                    byte[] bArr27 = $$a;
                    Object[] objArr73 = new Object[1];
                    b((byte) (bArr27[5] - 1), bArr27[18], bArr27[28], objArr73);
                    objAccessartificialFrame33 = ArtificialStackFrames.coroutineCreation(mode, tapTimeout, absoluteGravity, 1145017376, false, (String) objArr73[0], null);
                }
                Object[] objArr74 = (Object[]) ((Field) objAccessartificialFrame33).get(null);
                objArrAccessartificialFrame$78cbbd35 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
                int i110 = ((int[]) objArr74[3])[0];
                int i111 = ((int[]) objArr74[2])[0];
                String[] strArr10 = (String[]) objArr74[0];
                int i112 = ~((int) Runtime.getRuntime().maxMemory());
                int i113 = (-1436560445) + (((~(649358239 | i112)) | (-727462047)) * (-983)) + (((~(i112 | (-727462047))) | 571744414) * 983) + 598731505;
                int i114 = (i113 << 13) ^ i113;
                int i115 = i114 ^ (i114 >>> 17);
                ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0] = i115 ^ (i115 << 5);
            }
            objArr5 = objArrAccessartificialFrame$78cbbd35;
            i7 = ((int[]) objArr5[2])[0];
            i8 = ((int[]) objArr5[3])[0];
            if (i8 == i7) {
                Object[] objArr75 = {strArr, new int[1], new int[]{i}, new int[]{i}};
                int i116 = ((int[]) objArr5[1])[0];
                int i117 = ((int[]) objArr5[3])[0];
                int i118 = ((int[]) objArr5[2])[0];
                String[] strArr11 = (String[]) objArr5[0];
                int iIdentityHashCode5 = System.identityHashCode(this);
                int i119 = ~iIdentityHashCode5;
                int i120 = i116 + (-1921221026) + ((770277327 | iIdentityHashCode5) * (-676)) + (((~(761872331 | i119)) | (-770277328)) * 676) + (((~(iIdentityHashCode5 | (-8404997))) | (~(i119 | 683768524)) | 86508803) * 676);
                int i121 = (i120 << 13) ^ i120;
                int i122 = i121 ^ (i121 >>> 17);
                ((int[]) objArr75[1])[0] = i122 ^ (i122 << 5);
                i9 = 0;
            } else {
                arrayList = new ArrayList();
                strArr = (String[]) objArr5[0];
                if (strArr != null) {
                    for (String str8 : strArr) {
                        arrayList.add(str8);
                    }
                }
                Object[] objArr76 = {Long.valueOf(((long) (i7 ^ i8)) ^ (((long) 250580967) << 32)), Long.valueOf(250580965)};
                byte[] bArr28 = $$d;
                Object[] objArr77 = new Object[1];
                c((short) 264, (byte) (bArr28[627] - 1), (byte) (bArr28[320] - 1), objArr77);
                Class<?> cls9 = Class.forName((String) objArr77[0]);
                Object[] objArr78 = new Object[1];
                c((short) 465, bArr28[31], bArr28[19], objArr78);
                cls9.getMethod((String) objArr78[0], Long.TYPE, Long.TYPE).invoke(null, objArr76);
                Object[] objArr79 = {strArr, new int[1], new int[]{i}, new int[]{i}};
                int i123 = ((int[]) objArr5[1])[0];
                int i124 = ((int[]) objArr5[3])[0];
                int i125 = ((int[]) objArr5[2])[0];
                String[] strArr12 = (String[]) objArr5[0];
                int i126 = ~(((int) SystemClock.uptimeMillis()) | 971935337);
                int i127 = i123 + ((((-212354820) | i126) * (-658)) - 1410178994) + ((i126 | (-1039060844)) * 658);
                int i128 = (i127 << 13) ^ i127;
                int i129 = i128 ^ (i128 >>> 17);
                int[] iArr = (int[]) objArr79[1];
                i9 = 0;
                iArr[0] = i129 ^ (i129 << 5);
            }
            objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-1283093189);
            if (objAccessartificialFrame7 == null) {
                int iBlue = Color.blue(i9) + 30;
                char c2 = (char) (49362 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)));
                int absoluteGravity2 = 684 - Gravity.getAbsoluteGravity(i9, i9);
                byte[] bArr29 = $$a;
                Object[] objArr80 = new Object[1];
                b(bArr29[8], (byte) (-bArr29[4]), (byte) ($$b - 2), objArr80);
                objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(iBlue, c2, absoluteGravity2, 752929587, false, (String) objArr80[0], null);
            }
            j2 = ((Field) objAccessartificialFrame7).getLong(null);
            if (j2 != -1 || j2 + 2007 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                baseContext = getBaseContext();
                if (baseContext == null) {
                    Object[] objArr81 = new Object[1];
                    a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(19) - 111, new char[]{49248, 9089, 2515, 30328, 49153, 40671, 29655, 16794, 13519, 37400, 26263, 23046, 10625, 34113, 27203, 22342, 7777, 47250, 20743, 25537, 4886, 46040, 17607, 31889, 2036, 42777, 19329, 35149, 31873, 23125}, objArr81);
                    Class<?> cls10 = Class.forName((String) objArr81[0]);
                    Object[] objArr82 = new Object[1];
                    a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(12) - 99, new char[]{37436, 30945, 40643, 39809, 37471, 50596, 58577, 44131, 26265, 51583, 61847, 46992, 31692, 56865, 64847, 47864, 19487, 58352, 50711, 36408, 16723, 59583}, objArr82);
                    baseContext = (Context) cls10.getMethod((String) objArr82[0], new Class[0]).invoke(null, null);
                }
                if (baseContext == null) {
                    obj = null;
                } else {
                    if (baseContext instanceof ContextWrapper) {
                        i11 = artificialFrame + 71;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i11 % 128;
                        if (i11 % 2 != 0) {
                            ((ContextWrapper) baseContext).getBaseContext();
                            throw null;
                        }
                        if (((ContextWrapper) baseContext).getBaseContext() == null) {
                            baseContext = null;
                            obj = null;
                        }
                    }
                    obj = null;
                    baseContext = baseContext.getApplicationContext();
                }
                Object[] objArr83 = {baseContext, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(obj, this)).intValue()), 0, 1737431558};
                byte[] bArr30 = $$d;
                Object[] objArr84 = new Object[1];
                c((short) 210, (byte) (-bArr30[26]), (byte) (-bArr30[611]), objArr84);
                Class<?> cls11 = Class.forName((String) objArr84[0]);
                Object[] objArr85 = new Object[1];
                c((short) 133, bArr30[198], (byte) (-bArr30[99]), objArr85);
                objArr6 = (Object[]) cls11.getMethod((String) objArr85[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr83);
                if (baseContext != null) {
                    objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-326560385);
                    if (objAccessartificialFrame8 == null) {
                        int iIndexOf4 = 30 - TextUtils.indexOf("", "", 0, 0);
                        char tapTimeout2 = (char) ((ViewConfiguration.getTapTimeout() >> 16) + 49362);
                        int iIndexOf5 = 683 - TextUtils.indexOf((CharSequence) "", '0', 0, 0);
                        byte[] bArr31 = $$a;
                        Object[] objArr86 = new Object[1];
                        b(bArr31[9], (byte) (-bArr31[4]), (byte) 81, objArr86);
                        objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(iIndexOf4, tapTimeout2, iIndexOf5, 1944867703, false, (String) objArr86[0], null);
                    }
                    ((Field) objAccessartificialFrame8).set(null, objArr6);
                    try {
                        Long lValueOf6 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(-1283093189);
                        if (objAccessartificialFrame9 == null) {
                            int mode2 = 30 - View.MeasureSpec.getMode(0);
                            char cCombineMeasuredStates = (char) (View.combineMeasuredStates(0, 0) + 49362);
                            int iMyPid = 684 - (Process.myPid() >> 22);
                            byte[] bArr32 = $$a;
                            Object[] objArr87 = new Object[1];
                            b(bArr32[8], (byte) (-bArr32[4]), (byte) ($$b - 2), objArr87);
                            objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(mode2, cCombineMeasuredStates, iMyPid, 752929587, false, (String) objArr87[0], null);
                        }
                        ((Field) objAccessartificialFrame9).set(null, lValueOf6);
                    } catch (Exception unused5) {
                        throw new RuntimeException();
                    }
                }
            } else {
                int i130 = getARTIFICIAL_FRAME_PACKAGE_NAME + 67;
                artificialFrame = i130 % 128;
                int i131 = i130 % 2;
                Object objAccessartificialFrame34 = ArtificialStackFrames.accessartificialFrame(-326560385);
                if (objAccessartificialFrame34 == null) {
                    int iRed = Color.red(0) + 30;
                    char c3 = (char) ((CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + 49362);
                    int touchSlop = (ViewConfiguration.getTouchSlop() >> 8) + 684;
                    byte[] bArr33 = $$a;
                    Object[] objArr88 = new Object[1];
                    b(bArr33[9], (byte) (-bArr33[4]), (byte) 81, objArr88);
                    objAccessartificialFrame34 = ArtificialStackFrames.coroutineCreation(iRed, c3, touchSlop, 1944867703, false, (String) objArr88[0], null);
                }
                Object[] objArr89 = (Object[]) ((Field) objAccessartificialFrame34).get(null);
                objArr6 = new Object[]{new int[]{((int[]) objArr89[0])[0]}, new int[]{((int[]) objArr89[1])[0]}, new int[1], (String) objArr89[3]};
                int iIdentityHashCode6 = System.identityHashCode(this);
                int i132 = (-1911695090) + ((981165927 | iIdentityHashCode6) * 376) + (((~((~iIdentityHashCode6) | 979927619)) | 1271076) * (-376)) + (((~(iIdentityHashCode6 | (-979927620))) | (-1303845)) * 376) + 1737431558;
                int i133 = (i132 << 13) ^ i132;
                int i134 = i133 ^ (i133 >>> 17);
                ((int[]) objArr6[2])[0] = i134 ^ (i134 << 5);
            }
            objArr7 = objArr6;
            i12 = ((int[]) objArr7[1])[0];
            i13 = ((int[]) objArr7[0])[0];
            if (i13 == i12) {
                int i135 = ((int[]) objArr7[2])[0];
                Object[] objArr90 = {new int[]{((int[]) objArr7[0])[0]}, new int[]{((int[]) objArr7[1])[0]}, new int[1], (String) objArr7[3]};
                int iMaxMemory = (int) Runtime.getRuntime().maxMemory();
                int i136 = i135 + 449822958 + (((~((-420339500) | iMaxMemory)) | (-961544188)) * (-502)) + ((~((~iMaxMemory) | (-403259913))) * (-502)) + (((~(iMaxMemory | (-558284276))) | (-420339500)) * TypedValues.PositionType.TYPE_DRAWPATH);
                int i137 = (i136 << 13) ^ i136;
                int i138 = i137 ^ (i137 >>> 17);
                ((int[]) objArr90[2])[0] = i138 ^ (i138 << 5);
            } else {
                Object[] objArr91 = {Long.valueOf(((long) (i12 ^ i13)) ^ (((long) (-1121832718)) << 32)), Long.valueOf(-1121832714)};
                byte[] bArr34 = $$d;
                Object[] objArr92 = new Object[1];
                c((short) 376, (byte) (-bArr34[26]), bArr34[83], objArr92);
                Class<?> cls12 = Class.forName((String) objArr92[0]);
                Object[] objArr93 = new Object[1];
                c((short) 465, bArr34[31], bArr34[19], objArr93);
                cls12.getMethod((String) objArr93[0], Long.TYPE, Long.TYPE).invoke(null, objArr91);
                int i139 = ((int[]) objArr7[2])[0];
                Object[] objArr94 = {new int[]{((int[]) objArr7[0])[0]}, new int[]{((int[]) objArr7[1])[0]}, new int[1], (String) objArr7[3]};
                int iIdentityHashCode7 = System.identityHashCode(this);
                int i140 = ~iIdentityHashCode7;
                int i141 = i139 + (((~(iIdentityHashCode7 | 1069056620)) | (~(90432845 | i140))) * 959) + 532492963 + (((~(iIdentityHashCode7 | 90432845)) | (~(i140 | 1069056620))) * 959);
                int i142 = (i141 << 13) ^ i141;
                int i143 = i142 ^ (i142 >>> 17);
                ((int[]) objArr94[2])[0] = i143 ^ (i143 << 5);
            }
            objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-1168947751);
            if (objAccessartificialFrame10 == null) {
                int doubleTapTimeout = 36 - (ViewConfiguration.getDoubleTapTimeout() >> 16);
                char c4 = (char) (1 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)));
                int pressedStateDuration2 = 540 - (ViewConfiguration.getPressedStateDuration() >> 16);
                byte[] bArr35 = $$a;
                byte b9 = bArr35[5];
                Object[] objArr95 = new Object[1];
                b((byte) (b9 - 1), bArr35[18], (byte) (b9 - 1), objArr95);
                objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(doubleTapTimeout, c4, pressedStateDuration2, 624296913, false, (String) objArr95[0], null);
            }
            j3 = ((Field) objAccessartificialFrame10).getLong(null);
            if (j3 != -1 || j3 + 1906 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                objAccessartificialFrame11 = ArtificialStackFrames.accessartificialFrame(-1717965552);
                if (objAccessartificialFrame11 == null) {
                    objAccessartificialFrame11 = ArtificialStackFrames.coroutineCreation((KeyEvent.getMaxKeyCode() >> 16) + 20, (char) (Gravity.getAbsoluteGravity(0, 0) + 39516), 982 - ((Process.getThreadPriority(0) + 20) >> 6), 117222168, false, null, new Class[0]);
                }
                Object[] objArr96 = {null, ((Constructor) objAccessartificialFrame11).newInstance(null), 1327372054, 0};
                objAccessartificialFrame12 = ArtificialStackFrames.accessartificialFrame(-501205803);
                if (objAccessartificialFrame12 == null) {
                    int keyRepeatTimeout = 36 - (ViewConfiguration.getKeyRepeatTimeout() >> 16);
                    char cIndexOf7 = (char) TextUtils.indexOf("", "", 0, 0);
                    int keyRepeatTimeout2 = 540 - (ViewConfiguration.getKeyRepeatTimeout() >> 16);
                    byte b10 = (byte) ($$a[5] - 1);
                    Object[] objArr97 = new Object[1];
                    b((byte) 47, b10, (byte) (b10 | 96), objArr97);
                    objAccessartificialFrame12 = ArtificialStackFrames.coroutineCreation(keyRepeatTimeout, cIndexOf7, keyRepeatTimeout2, 2101703389, false, (String) objArr97[0], new Class[]{(Class) ArtificialStackFrames.coroutineCreation(54 - KeyEvent.normalizeMetaState(0), (char) ((ViewConfiguration.getJumpTapTimeout() >> 16) + 833), (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 575), (Class) ArtificialStackFrames.coroutineCreation(TextUtils.getOffsetBefore("", 0) + 54, (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), 630 - (ViewConfiguration.getScrollBarSize() >> 8)), Integer.TYPE, Integer.TYPE});
                }
                objArr8 = (Object[]) ((Method) objAccessartificialFrame12).invoke(null, objArr96);
                objAccessartificialFrame13 = ArtificialStackFrames.accessartificialFrame(-1339222025);
                if (objAccessartificialFrame13 == null) {
                    int packedPositionGroup = ExpandableListView.getPackedPositionGroup(0L) + 36;
                    char cRed = (char) Color.red(0);
                    int i144 = (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 539;
                    byte[] bArr36 = $$a;
                    Object[] objArr98 = new Object[1];
                    b((byte) (bArr36[5] - 1), bArr36[18], bArr36[28], objArr98);
                    objAccessartificialFrame13 = ArtificialStackFrames.coroutineCreation(packedPositionGroup, cRed, i144, 793268735, false, (String) objArr98[0], null);
                }
                ((Field) objAccessartificialFrame13).set(null, objArr8);
                try {
                    Long lValueOf7 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame14 = ArtificialStackFrames.accessartificialFrame(-1168947751);
                    if (objAccessartificialFrame14 == null) {
                        int i145 = (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 35;
                        char cArgb = (char) Color.argb(0, 0, 0, 0);
                        int iResolveSizeAndState = 540 - View.resolveSizeAndState(0, 0, 0);
                        byte[] bArr37 = $$a;
                        byte b11 = bArr37[5];
                        Object[] objArr99 = new Object[1];
                        b((byte) (b11 - 1), bArr37[18], (byte) (b11 - 1), objArr99);
                        objAccessartificialFrame14 = ArtificialStackFrames.coroutineCreation(i145, cArgb, iResolveSizeAndState, 624296913, false, (String) objArr99[0], null);
                    }
                    ((Field) objAccessartificialFrame14).set(null, lValueOf7);
                } catch (Exception unused6) {
                    throw new RuntimeException();
                }
            } else {
                int i146 = artificialFrame + 51;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i146 % 128;
                int i147 = i146 % 2;
                Object objAccessartificialFrame35 = ArtificialStackFrames.accessartificialFrame(-1339222025);
                if (objAccessartificialFrame35 == null) {
                    int packedPositionType = ExpandableListView.getPackedPositionType(0L) + 36;
                    char keyRepeatTimeout3 = (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16);
                    int deadChar3 = KeyEvent.getDeadChar(0, 0) + 540;
                    byte[] bArr38 = $$a;
                    Object[] objArr100 = new Object[1];
                    b((byte) (bArr38[5] - 1), bArr38[18], bArr38[28], objArr100);
                    objAccessartificialFrame35 = ArtificialStackFrames.coroutineCreation(packedPositionType, keyRepeatTimeout3, deadChar3, 793268735, false, (String) objArr100[0], null);
                }
                Object[] objArr101 = (Object[]) ((Field) objAccessartificialFrame35).get(null);
                objArr8 = new Object[]{new int[1], new int[1], new int[1]};
                int i148 = ((int[]) objArr101[2])[0];
                int i149 = ((int[]) objArr101[1])[0];
                ((int[]) objArr8[2])[0] = i148;
                ((int[]) objArr8[1])[0] = i149;
                int i150 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getDisplayMetrics().densityDpi;
                int i151 = (~((-945287783) | i150)) | 403710470;
                int i152 = 962132421 + (i151 * 992) + ((i151 | (~((~i150) | 947911279))) * (-496)) + ((i150 | 406333967) * 496) + 1327372054;
                int i153 = (i152 << 13) ^ i152;
                int i154 = i153 ^ (i153 >>> 17);
                ((int[]) objArr8[0])[0] = i154 ^ (i154 << 5);
                int i155 = artificialFrame + 31;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i155 % 128;
                int i156 = i155 % 2;
            }
            obj2 = objArr8[1];
            i14 = ((int[]) obj2)[0];
            obj3 = objArr8[2];
            i15 = ((int[]) obj3)[0];
            if (i15 == i14) {
                int i157 = artificialFrame + 65;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i157 % 128;
                int i158 = i157 % 2;
                Object[] objArr102 = {new int[1], new int[1], new int[1]};
                int i159 = ((int[]) objArr8[0])[0];
                int i160 = ((int[]) obj3)[0];
                int i161 = ((int[]) obj2)[0];
                ((int[]) objArr102[2])[0] = i160;
                ((int[]) objArr102[1])[0] = i161;
                int iIdentityHashCode8 = System.identityHashCode(this);
                int i162 = ~iIdentityHashCode8;
                int i163 = i159 + 668882033 + ((iIdentityHashCode8 | 288548352) * 140) + (((~(288548352 | i162)) | 776802421) * (-280)) + (((~(iIdentityHashCode8 | (-776802422))) | (~(1063073397 | i162)) | 2277376) * 140);
                int i164 = (i163 << 13) ^ i163;
                int i165 = i164 ^ (i164 >>> 17);
                ((int[]) objArr102[0])[0] = i165 ^ (i165 << 5);
                i16 = 0;
            } else {
                Object[] objArr103 = {Long.valueOf((((long) 1283651378) << 32) ^ ((long) (i14 ^ i15))), Long.valueOf(1283647282)};
                byte[] bArr39 = $$d;
                Object[] objArr104 = new Object[1];
                c((short) 288, (byte) (-bArr39[26]), bArr39[479], objArr104);
                Class<?> cls13 = Class.forName((String) objArr104[0]);
                Object[] objArr105 = new Object[1];
                c((short) 465, bArr39[31], bArr39[19], objArr105);
                cls13.getMethod((String) objArr105[0], Long.TYPE, Long.TYPE).invoke(null, objArr103);
                Object[] objArr106 = {new int[1], new int[1], new int[1]};
                int i166 = ((int[]) objArr8[0])[0];
                int i167 = ((int[]) objArr8[2])[0];
                int i168 = ((int[]) objArr8[1])[0];
                ((int[]) objArr106[2])[0] = i167;
                ((int[]) objArr106[1])[0] = i168;
                int iIdentityHashCode9 = System.identityHashCode(this);
                int i169 = 1072819877 + (((~((-89542043) | iIdentityHashCode9)) | 17845402 | (~((-1262079708) | iIdentityHashCode9))) * (-880));
                int i170 = (~((-89542043) | (~iIdentityHashCode9))) | 1262079707;
                int i171 = ~(iIdentityHashCode9 | 89542042);
                int i172 = i166 + i169 + ((i170 | i171) * (-880)) + (i171 * 880);
                int i173 = (i172 << 13) ^ i172;
                int i174 = i173 ^ (i173 >>> 17);
                i16 = 0;
                ((int[]) objArr106[0])[0] = i174 ^ (i174 << 5);
            }
            objAccessartificialFrame15 = ArtificialStackFrames.accessartificialFrame(1745676544);
            if (objAccessartificialFrame15 == null) {
                int i175 = 17 - (TypedValue.complexToFloat(i16) > 0.0f ? 1 : (TypedValue.complexToFloat(i16) == 0.0f ? 0 : -1));
                char absoluteGravity3 = (char) Gravity.getAbsoluteGravity(i16, i16);
                int iRed2 = 747 - Color.red(i16);
                byte[] bArr40 = $$a;
                byte b12 = bArr40[5];
                Object[] objArr107 = new Object[1];
                b((byte) (b12 - 1), bArr40[18], (byte) (b12 - 1), objArr107);
                objAccessartificialFrame15 = ArtificialStackFrames.coroutineCreation(i175, absoluteGravity3, iRed2, -144068856, false, (String) objArr107[0], null);
            }
            j4 = ((Field) objAccessartificialFrame15).getLong(null);
            if (j4 != -1 || j4 + 4611686018427387944L < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                baseContext2 = getBaseContext();
                if (baseContext2 == null) {
                    Object[] objArr108 = new Object[1];
                    a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 4, new char[]{49248, 9089, 2515, 30328, 49153, 40671, 29655, 16794, 13519, 37400, 26263, 23046, 10625, 34113, 27203, 22342, 7777, 47250, 20743, 25537, 4886, 46040, 17607, 31889, 2036, 42777, 19329, 35149, 31873, 23125}, objArr108);
                    Class<?> cls14 = Class.forName((String) objArr108[0]);
                    Object[] objArr109 = new Object[1];
                    a((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 1, new char[]{37436, 30945, 40643, 39809, 37471, 50596, 58577, 44131, 26265, 51583, 61847, 46992, 31692, 56865, 64847, 47864, 19487, 58352, 50711, 36408, 16723, 59583}, objArr109);
                    baseContext2 = (Context) cls14.getMethod((String) objArr109[0], new Class[0]).invoke(null, null);
                }
                if (baseContext2 != null) {
                    if (baseContext2 instanceof ContextWrapper) {
                        int i176 = artificialFrame + 89;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i176 % 128;
                        int i177 = i176 % 2;
                        if (((ContextWrapper) baseContext2).getBaseContext() != null) {
                            baseContext2 = baseContext2.getApplicationContext();
                        } else {
                            baseContext2 = null;
                        }
                    } else {
                        baseContext2 = baseContext2.getApplicationContext();
                    }
                }
                Object[] objArr110 = {baseContext2, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 59556439};
                byte[] bArr41 = $$d;
                Object[] objArr111 = new Object[1];
                c((short) 114, (byte) (-bArr41[26]), bArr41[320], objArr111);
                Class<?> cls15 = Class.forName((String) objArr111[0]);
                Object[] objArr112 = new Object[1];
                c((short) 133, bArr41[198], (byte) (-bArr41[99]), objArr112);
                objArr9 = (Object[]) cls15.getMethod((String) objArr112[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr110);
                objAccessartificialFrame16 = ArtificialStackFrames.accessartificialFrame(1575402270);
                if (objAccessartificialFrame16 == null) {
                    int trimmedLength3 = TextUtils.getTrimmedLength("") + 17;
                    char cIndexOf8 = (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0, 0));
                    int capsMode = 747 - TextUtils.getCapsMode("", 0, 0);
                    byte[] bArr42 = $$a;
                    Object[] objArr113 = new Object[1];
                    b((byte) (bArr42[5] - 1), bArr42[18], bArr42[28], objArr113);
                    objAccessartificialFrame16 = ArtificialStackFrames.coroutineCreation(trimmedLength3, cIndexOf8, capsMode, -1031537386, false, (String) objArr113[0], null);
                }
                ((Field) objAccessartificialFrame16).set(null, objArr9);
                try {
                    Long lValueOf8 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame17 = ArtificialStackFrames.accessartificialFrame(1745676544);
                    if (objAccessartificialFrame17 == null) {
                        int i178 = (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 16;
                        char c5 = (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) - 1);
                        int i179 = (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 746;
                        byte[] bArr43 = $$a;
                        byte b13 = bArr43[5];
                        Object[] objArr114 = new Object[1];
                        b((byte) (b13 - 1), bArr43[18], (byte) (b13 - 1), objArr114);
                        objAccessartificialFrame17 = ArtificialStackFrames.coroutineCreation(i178, c5, i179, -144068856, false, (String) objArr114[0], null);
                    }
                    ((Field) objAccessartificialFrame17).set(null, lValueOf8);
                } catch (Exception unused7) {
                    throw new RuntimeException();
                }
            } else {
                Object objAccessartificialFrame36 = ArtificialStackFrames.accessartificialFrame(1575402270);
                if (objAccessartificialFrame36 == null) {
                    int longPressTimeout = 17 - (ViewConfiguration.getLongPressTimeout() >> 16);
                    char cMyTid = (char) (Process.myTid() >> 22);
                    int i180 = 748 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1));
                    byte[] bArr44 = $$a;
                    Object[] objArr115 = new Object[1];
                    b((byte) (bArr44[5] - 1), bArr44[18], bArr44[28], objArr115);
                    objAccessartificialFrame36 = ArtificialStackFrames.coroutineCreation(longPressTimeout, cMyTid, i180, -1031537386, false, (String) objArr115[0], null);
                }
                Object[] objArr116 = (Object[]) ((Field) objAccessartificialFrame36).get(null);
                objArr9 = new Object[]{list, new int[1], list, new int[]{i}, new int[]{i}};
                int i181 = ((int[]) objArr116[3])[0];
                int i182 = ((int[]) objArr116[4])[0];
                List list = (List) objArr116[0];
                List list2 = (List) objArr116[2];
                int iFreeMemory = (int) Runtime.getRuntime().freeMemory();
                int i183 = (-765451384) + ((~((~iFreeMemory) | (-285230306))) * 433) + (((~((-177152541) | iFreeMemory)) | (-428295918)) * (-433)) + (((~(iFreeMemory | (-428295918))) | (-462382846)) * 433) + 59556439;
                int i184 = (i183 << 13) ^ i183;
                int i185 = i184 ^ (i184 >>> 17);
                ((int[]) objArr9[1])[0] = i185 ^ (i185 << 5);
            }
            i17 = ((int[]) objArr9[4])[0];
            i18 = ((int[]) objArr9[3])[0];
            if (i18 == i17) {
                Object[] objArr117 = {list, new int[1], list, new int[]{i}, new int[]{i}};
                int i186 = ((int[]) objArr9[1])[0];
                int i187 = ((int[]) objArr9[3])[0];
                int i188 = ((int[]) objArr9[4])[0];
                List list3 = (List) objArr9[0];
                List list4 = (List) objArr9[2];
                int i189 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getDisplayMetrics().widthPixels;
                int i190 = i186 + ((((-769471549) + (((~i189) | 1478672) * 1324)) + (((~(i189 | 594989264)) | (~(10459193 | i189))) * (-1324))) - 582841722);
                int i191 = (i190 << 13) ^ i190;
                int i192 = i191 ^ (i191 >>> 17);
                ((int[]) objArr117[1])[0] = i192 ^ (i192 << 5);
            } else {
                ArrayList arrayList4 = new ArrayList();
                Object[] objArr118 = {objArr9};
                objAccessartificialFrame18 = ArtificialStackFrames.accessartificialFrame(1804664566);
                if (objAccessartificialFrame18 == null) {
                    objAccessartificialFrame18 = ArtificialStackFrames.coroutineCreation(TextUtils.indexOf((CharSequence) "", '0', 0) + 42, (char) ((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 12469), View.getDefaultSize(0, 0) + 3642, -185222914, false, "coroutineCreation", new Class[]{Object[].class});
                }
                arrayList4.add(((Method) objAccessartificialFrame18).invoke(null, objArr118));
                Object[] objArr119 = {objArr9};
                objAccessartificialFrame19 = ArtificialStackFrames.accessartificialFrame(-1243809191);
                if (objAccessartificialFrame19 == null) {
                    objAccessartificialFrame19 = ArtificialStackFrames.coroutineCreation(41 - (ViewConfiguration.getEdgeSlop() >> 16), (char) (12468 - Drawable.resolveOpacity(0, 0)), TextUtils.indexOf("", "", 0) + 3642, 716815441, false, "ArtificialStackFrames", new Class[]{Object[].class});
                }
                arrayList4.add(((Method) objAccessartificialFrame19).invoke(null, objArr119));
                Object[] objArr120 = {Long.valueOf((((long) (-1803836028)) << 32) ^ ((long) (i17 ^ i18))), Long.valueOf(-1803836020)};
                byte[] bArr45 = $$d;
                byte b14 = bArr45[6];
                Object[] objArr121 = new Object[1];
                c(b14, (byte) (-bArr45[26]), b14, objArr121);
                Class<?> cls16 = Class.forName((String) objArr121[0]);
                Object[] objArr122 = new Object[1];
                c((short) 465, bArr45[31], bArr45[19], objArr122);
                cls16.getMethod((String) objArr122[0], Long.TYPE, Long.TYPE).invoke(null, objArr120);
                Object[] objArr123 = {list, new int[1], list, new int[]{i}, new int[]{i}};
                int i193 = ((int[]) objArr9[1])[0];
                int i194 = ((int[]) objArr9[3])[0];
                int i195 = ((int[]) objArr9[4])[0];
                List list5 = (List) objArr9[0];
                List list6 = (List) objArr9[2];
                int iIdentityHashCode10 = System.identityHashCode(this);
                int i196 = 824145913 + (((~((-541545908) | iIdentityHashCode10)) | 4657426 | (~((-63902551) | iIdentityHashCode10))) * (-880));
                int i197 = (~((-541545908) | (~iIdentityHashCode10))) | 63902550;
                int i198 = ~(iIdentityHashCode10 | 541545907);
                int i199 = i193 + i196 + ((i197 | i198) * (-880)) + (i198 * 880);
                int i200 = (i199 << 13) ^ i199;
                int i201 = i200 ^ (i200 >>> 17);
                ((int[]) objArr123[1])[0] = i201 ^ (i201 << 5);
                int i202 = getARTIFICIAL_FRAME_PACKAGE_NAME + 15;
                artificialFrame = i202 % 128;
                int i203 = i202 % 2;
            }
            super.onStart();
        }
        i3 = 0;
        Context baseContext4 = getBaseContext();
        if (baseContext4 == null) {
            Object[] objArr124 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[i3]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(18) - 99, new char[]{49248, 9089, 2515, 30328, 49153, 40671, 29655, 16794, 13519, 37400, 26263, 23046, 10625, 34113, 27203, 22342, 7777, 47250, 20743, 25537, 4886, 46040, 17607, 31889, 2036, 42777, 19329, 35149, 31873, 23125}, objArr124);
            Class<?> cls17 = Class.forName((String) objArr124[0]);
            Object[] objArr125 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) - 36, new char[]{37436, 30945, 40643, 39809, 37471, 50596, 58577, 44131, 26265, 51583, 61847, 46992, 31692, 56865, 64847, 47864, 19487, 58352, 50711, 36408, 16723, 59583}, objArr125);
            baseContext4 = (Context) cls17.getMethod((String) objArr125[0], new Class[0]).invoke(null, null);
        }
        if (baseContext4 != null) {
            baseContext4 = ((baseContext4 instanceof ContextWrapper) && ((ContextWrapper) baseContext4).getBaseContext() == null) ? null : baseContext4.getApplicationContext();
        }
        Object[] objArr126 = {baseContext4, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 32780798};
        byte[] bArr46 = $$d;
        Object[] objArr127 = new Object[1];
        c((short) 342, (byte) (-bArr46[26]), bArr46[121], objArr127);
        Class<?> cls18 = Class.forName((String) objArr127[0]);
        Object[] objArr128 = new Object[1];
        c((short) 304, (byte) (-bArr46[26]), (byte) (-bArr46[4]), objArr128);
        objArr4 = (Object[]) cls18.getMethod((String) objArr128[0], Context.class, Integer.TYPE, Integer.TYPE).invoke(null, objArr126);
        if (baseContext4 != null) {
            Object objAccessartificialFrame37 = ArtificialStackFrames.accessartificialFrame(777251007);
            if (objAccessartificialFrame37 == null) {
                int pressedStateDuration3 = (ViewConfiguration.getPressedStateDuration() >> 16) + 30;
                char cAlpha2 = (char) (Color.alpha(0) + 49362);
                int i204 = (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 684;
                byte[] bArr47 = $$a;
                Object[] objArr129 = new Object[1];
                b(bArr47[28], bArr47[49], (byte) 59, objArr129);
                objAccessartificialFrame37 = ArtificialStackFrames.coroutineCreation(pressedStateDuration3, cAlpha2, i204, -1321816393, false, (String) objArr129[0], null);
            }
            ((Field) objAccessartificialFrame37).set(null, objArr4);
            try {
                Long lValueOf9 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame38 = ArtificialStackFrames.accessartificialFrame(-2127922582);
                if (objAccessartificialFrame38 == null) {
                    int defaultSize = 30 - View.getDefaultSize(0, 0);
                    char cAxisFromString3 = (char) (49361 - MotionEvent.axisFromString(""));
                    int i205 = (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 683;
                    byte[] bArr48 = $$a;
                    byte b15 = bArr48[8];
                    byte b16 = bArr48[28];
                    Object[] objArr130 = new Object[1];
                    b(b15, b16, (byte) (b16 | 39), objArr130);
                    objAccessartificialFrame38 = ArtificialStackFrames.coroutineCreation(defaultSize, cAxisFromString3, i205, 508509282, false, (String) objArr130[0], null);
                }
                ((Field) objAccessartificialFrame38).set(null, lValueOf9);
            } catch (Exception unused8) {
                throw new RuntimeException();
            }
        }
        i4 = ((int[]) objArr4[1])[0];
        i5 = ((int[]) objArr4[0])[0];
        if (i5 == i4) {
            int i1010 = ((int[]) objArr4[2])[0];
            Object[] objArr610 = {new int[]{((int[]) objArr4[0])[0]}, new int[]{((int[]) objArr4[1])[0]}, new int[1], (String) objArr4[3]};
            int length2 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 2120592214;
            int i1011 = i1010 + 549674652 + (((~((-201891105) | (~length2))) | (-776732671)) * (-591)) + ((length2 | (-201891105)) * 591);
            int i1012 = (i1011 << 13) ^ i1011;
            int i1013 = i1012 ^ (i1012 >>> 17);
            i6 = 0;
            ((int[]) objArr610[2])[0] = i1013 ^ (i1013 << 5);
        } else {
            Object[] objArr611 = {Long.valueOf(((long) (i4 ^ i5)) ^ (((long) (-1035234036)) << 32)), Long.valueOf(-1035233524)};
            byte[] bArr210 = $$d;
            Object[] objArr612 = new Object[1];
            c((short) 288, (byte) (-bArr210[26]), bArr210[479], objArr612);
            Class<?> cls19 = Class.forName((String) objArr612[0]);
            Object[] objArr613 = new Object[1];
            c((short) 465, bArr210[31], bArr210[19], objArr613);
            cls19.getMethod((String) objArr613[0], Long.TYPE, Long.TYPE).invoke(null, objArr611);
            int i1014 = ((int[]) objArr4[2])[0];
            Object[] objArr614 = {new int[]{((int[]) objArr4[0])[0]}, new int[]{((int[]) objArr4[1])[0]}, new int[1], (String) objArr4[3]};
            int i1015 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getDisplayMetrics().heightPixels;
            int i1016 = i1014 + 804154022 + (((~(582593113 | i1015)) | 352473220) * (-140)) + ((~(935066333 | i1015)) * 70) + (((~(i1015 | 396030661)) | 891508892) * 70);
            int i1017 = (i1016 << 13) ^ i1016;
            int i1018 = i1017 ^ (i1017 >>> 17);
            i6 = 0;
            ((int[]) objArr614[2])[0] = i1018 ^ (i1018 << 5);
        }
        objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-444530678);
        if (objAccessartificialFrame3 == null) {
            int offsetAfter3 = TextUtils.getOffsetAfter("", i6) + 26;
            char offsetBefore2 = (char) TextUtils.getOffsetBefore("", i6);
            int edgeSlop2 = (ViewConfiguration.getEdgeSlop() >> 16) + 1041;
            byte[] bArr211 = $$a;
            byte b17 = bArr211[5];
            Object[] objArr615 = new Object[1];
            b((byte) (b17 - 1), bArr211[18], (byte) (b17 - 1), objArr615);
            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(offsetAfter3, offsetBefore2, edgeSlop2, 2061780482, false, (String) objArr615[0], null);
        }
        j = ((Field) objAccessartificialFrame3).getLong(null);
        if (j != -1) {
            int iIntValue3 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
            Object[] objArr710 = {-1672848637};
            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame4 == null) {
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 8, (char) (Color.green(0) + 22251), View.MeasureSpec.makeMeasureSpec(0, 0) + 1033, 47343338, false, null, new Class[]{Integer.TYPE});
            }
            objArrAccessartificialFrame$78cbbd35 = com.facebook.core.R.string.accessartificialFrame$78cbbd35(iIntValue3, 0, ((Constructor) objAccessartificialFrame4).newInstance(objArr710), 598731505, false);
            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame5 == null) {
                int iAxisFromString2 = MotionEvent.axisFromString("") + 27;
                char cAlpha3 = (char) Color.alpha(0);
                int offsetAfter4 = TextUtils.getOffsetAfter("", 0) + 1041;
                byte[] bArr212 = $$a;
                Object[] objArr711 = new Object[1];
                b((byte) (bArr212[5] - 1), bArr212[18], bArr212[28], objArr711);
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(iAxisFromString2, cAlpha3, offsetAfter4, 1145017376, false, (String) objArr711[0], null);
            }
            ((Field) objAccessartificialFrame5).set(null, objArrAccessartificialFrame$78cbbd35);
            Long lValueOf10 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-444530678);
            if (objAccessartificialFrame6 == null) {
                int scrollBarSize3 = 26 - (ViewConfiguration.getScrollBarSize() >> 8);
                char c6 = (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                int keyRepeatDelay3 = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 1041;
                byte[] bArr213 = $$a;
                byte b18 = bArr213[5];
                Object[] objArr712 = new Object[1];
                b((byte) (b18 - 1), bArr213[18], (byte) (b18 - 1), objArr712);
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(scrollBarSize3, c6, keyRepeatDelay3, 2061780482, false, (String) objArr712[0], null);
            }
            ((Field) objAccessartificialFrame6).set(null, lValueOf10);
        } else {
            int iIntValue4 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
            Object[] objArr713 = {-1672848637};
            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame4 == null) {
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 8, (char) (Color.green(0) + 22251), View.MeasureSpec.makeMeasureSpec(0, 0) + 1033, 47343338, false, null, new Class[]{Integer.TYPE});
            }
            objArrAccessartificialFrame$78cbbd35 = com.facebook.core.R.string.accessartificialFrame$78cbbd35(iIntValue4, 0, ((Constructor) objAccessartificialFrame4).newInstance(objArr713), 598731505, false);
            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame5 == null) {
                int iAxisFromString3 = MotionEvent.axisFromString("") + 27;
                char cAlpha4 = (char) Color.alpha(0);
                int offsetAfter5 = TextUtils.getOffsetAfter("", 0) + 1041;
                byte[] bArr214 = $$a;
                Object[] objArr714 = new Object[1];
                b((byte) (bArr214[5] - 1), bArr214[18], bArr214[28], objArr714);
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(iAxisFromString3, cAlpha4, offsetAfter5, 1145017376, false, (String) objArr714[0], null);
            }
            ((Field) objAccessartificialFrame5).set(null, objArrAccessartificialFrame$78cbbd35);
            Long lValueOf11 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-444530678);
            if (objAccessartificialFrame6 == null) {
                int scrollBarSize4 = 26 - (ViewConfiguration.getScrollBarSize() >> 8);
                char c7 = (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                int keyRepeatDelay4 = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 1041;
                byte[] bArr215 = $$a;
                byte b19 = bArr215[5];
                Object[] objArr715 = new Object[1];
                b((byte) (b19 - 1), bArr215[18], (byte) (b19 - 1), objArr715);
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(scrollBarSize4, c7, keyRepeatDelay4, 2061780482, false, (String) objArr715[0], null);
            }
            ((Field) objAccessartificialFrame6).set(null, lValueOf11);
        }
        objArr5 = objArrAccessartificialFrame$78cbbd35;
        i7 = ((int[]) objArr5[2])[0];
        i8 = ((int[]) objArr5[3])[0];
        if (i8 == i7) {
            Object[] objArr716 = {strArr11, new int[1], new int[]{i118}, new int[]{i117}};
            int i1110 = ((int[]) objArr5[1])[0];
            int i1111 = ((int[]) objArr5[3])[0];
            int i1112 = ((int[]) objArr5[2])[0];
            String[] strArr13 = (String[]) objArr5[0];
            int iIdentityHashCode11 = System.identityHashCode(this);
            int i1113 = ~iIdentityHashCode11;
            int i1210 = i1110 + (-1921221026) + ((770277327 | iIdentityHashCode11) * (-676)) + (((~(761872331 | i1113)) | (-770277328)) * 676) + (((~(iIdentityHashCode11 | (-8404997))) | (~(i1113 | 683768524)) | 86508803) * 676);
            int i1211 = (i1210 << 13) ^ i1210;
            int i1212 = i1211 ^ (i1211 >>> 17);
            ((int[]) objArr716[1])[0] = i1212 ^ (i1212 << 5);
            i9 = 0;
        } else {
            arrayList = new ArrayList();
            strArr = (String[]) objArr5[0];
            if (strArr != null) {
                while (i10 < strArr.length) {
                    arrayList.add(str8);
                }
            }
            Object[] objArr717 = {Long.valueOf(((long) (i7 ^ i8)) ^ (((long) 250580967) << 32)), Long.valueOf(250580965)};
            byte[] bArr216 = $$d;
            Object[] objArr718 = new Object[1];
            c((short) 264, (byte) (bArr216[627] - 1), (byte) (bArr216[320] - 1), objArr718);
            Class<?> cls20 = Class.forName((String) objArr718[0]);
            Object[] objArr719 = new Object[1];
            c((short) 465, bArr216[31], bArr216[19], objArr719);
            cls20.getMethod((String) objArr719[0], Long.TYPE, Long.TYPE).invoke(null, objArr717);
            Object[] objArr720 = {strArr12, new int[1], new int[]{i125}, new int[]{i124}};
            int i1213 = ((int[]) objArr5[1])[0];
            int i1214 = ((int[]) objArr5[3])[0];
            int i1215 = ((int[]) objArr5[2])[0];
            String[] strArr14 = (String[]) objArr5[0];
            int i1216 = ~(((int) SystemClock.uptimeMillis()) | 971935337);
            int i1217 = i1213 + ((((-212354820) | i1216) * (-658)) - 1410178994) + ((i1216 | (-1039060844)) * 658);
            int i1218 = (i1217 << 13) ^ i1217;
            int i1219 = i1218 ^ (i1218 >>> 17);
            int[] iArr2 = (int[]) objArr720[1];
            i9 = 0;
            iArr2[0] = i1219 ^ (i1219 << 5);
        }
        objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-1283093189);
        if (objAccessartificialFrame7 == null) {
            int iBlue2 = Color.blue(i9) + 30;
            char c8 = (char) (49362 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)));
            int absoluteGravity4 = 684 - Gravity.getAbsoluteGravity(i9, i9);
            byte[] bArr217 = $$a;
            Object[] objArr810 = new Object[1];
            b(bArr217[8], (byte) (-bArr217[4]), (byte) ($$b - 2), objArr810);
            objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(iBlue2, c8, absoluteGravity4, 752929587, false, (String) objArr810[0], null);
        }
        j2 = ((Field) objAccessartificialFrame7).getLong(null);
        if (j2 != -1) {
            baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr811 = new Object[1];
                a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(19) - 111, new char[]{49248, 9089, 2515, 30328, 49153, 40671, 29655, 16794, 13519, 37400, 26263, 23046, 10625, 34113, 27203, 22342, 7777, 47250, 20743, 25537, 4886, 46040, 17607, 31889, 2036, 42777, 19329, 35149, 31873, 23125}, objArr811);
                Class<?> cls110 = Class.forName((String) objArr811[0]);
                Object[] objArr812 = new Object[1];
                a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(12) - 99, new char[]{37436, 30945, 40643, 39809, 37471, 50596, 58577, 44131, 26265, 51583, 61847, 46992, 31692, 56865, 64847, 47864, 19487, 58352, 50711, 36408, 16723, 59583}, objArr812);
                baseContext = (Context) cls110.getMethod((String) objArr812[0], new Class[0]).invoke(null, null);
            }
            if (baseContext == null) {
                obj = null;
            } else {
                if (baseContext instanceof ContextWrapper) {
                    i11 = artificialFrame + 71;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i11 % 128;
                    if (i11 % 2 != 0) {
                        ((ContextWrapper) baseContext).getBaseContext();
                        throw null;
                    }
                    if (((ContextWrapper) baseContext).getBaseContext() == null) {
                        baseContext = null;
                        obj = null;
                    }
                }
                obj = null;
                baseContext = baseContext.getApplicationContext();
            }
            Object[] objArr813 = {baseContext, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(obj, this)).intValue()), 0, 1737431558};
            byte[] bArr310 = $$d;
            Object[] objArr814 = new Object[1];
            c((short) 210, (byte) (-bArr310[26]), (byte) (-bArr310[611]), objArr814);
            Class<?> cls111 = Class.forName((String) objArr814[0]);
            Object[] objArr815 = new Object[1];
            c((short) 133, bArr310[198], (byte) (-bArr310[99]), objArr815);
            objArr6 = (Object[]) cls111.getMethod((String) objArr815[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr813);
            if (baseContext != null) {
                objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-326560385);
                if (objAccessartificialFrame8 == null) {
                    int iIndexOf6 = 30 - TextUtils.indexOf("", "", 0, 0);
                    char tapTimeout3 = (char) ((ViewConfiguration.getTapTimeout() >> 16) + 49362);
                    int iIndexOf7 = 683 - TextUtils.indexOf((CharSequence) "", '0', 0, 0);
                    byte[] bArr311 = $$a;
                    Object[] objArr816 = new Object[1];
                    b(bArr311[9], (byte) (-bArr311[4]), (byte) 81, objArr816);
                    objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(iIndexOf6, tapTimeout3, iIndexOf7, 1944867703, false, (String) objArr816[0], null);
                }
                ((Field) objAccessartificialFrame8).set(null, objArr6);
                Long lValueOf12 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(-1283093189);
                if (objAccessartificialFrame9 == null) {
                    int mode3 = 30 - View.MeasureSpec.getMode(0);
                    char cCombineMeasuredStates2 = (char) (View.combineMeasuredStates(0, 0) + 49362);
                    int iMyPid2 = 684 - (Process.myPid() >> 22);
                    byte[] bArr312 = $$a;
                    Object[] objArr817 = new Object[1];
                    b(bArr312[8], (byte) (-bArr312[4]), (byte) ($$b - 2), objArr817);
                    objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(mode3, cCombineMeasuredStates2, iMyPid2, 752929587, false, (String) objArr817[0], null);
                }
                ((Field) objAccessartificialFrame9).set(null, lValueOf12);
            }
        } else {
            baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr818 = new Object[1];
                a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(19) - 111, new char[]{49248, 9089, 2515, 30328, 49153, 40671, 29655, 16794, 13519, 37400, 26263, 23046, 10625, 34113, 27203, 22342, 7777, 47250, 20743, 25537, 4886, 46040, 17607, 31889, 2036, 42777, 19329, 35149, 31873, 23125}, objArr818);
                Class<?> cls112 = Class.forName((String) objArr818[0]);
                Object[] objArr819 = new Object[1];
                a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(12) - 99, new char[]{37436, 30945, 40643, 39809, 37471, 50596, 58577, 44131, 26265, 51583, 61847, 46992, 31692, 56865, 64847, 47864, 19487, 58352, 50711, 36408, 16723, 59583}, objArr819);
                baseContext = (Context) cls112.getMethod((String) objArr819[0], new Class[0]).invoke(null, null);
            }
            if (baseContext == null) {
                obj = null;
            } else {
                if (baseContext instanceof ContextWrapper) {
                    i11 = artificialFrame + 71;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i11 % 128;
                    if (i11 % 2 != 0) {
                        ((ContextWrapper) baseContext).getBaseContext();
                        throw null;
                    }
                    if (((ContextWrapper) baseContext).getBaseContext() == null) {
                        baseContext = null;
                        obj = null;
                    }
                }
                obj = null;
                baseContext = baseContext.getApplicationContext();
            }
            Object[] objArr8110 = {baseContext, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(obj, this)).intValue()), 0, 1737431558};
            byte[] bArr313 = $$d;
            Object[] objArr8111 = new Object[1];
            c((short) 210, (byte) (-bArr313[26]), (byte) (-bArr313[611]), objArr8111);
            Class<?> cls113 = Class.forName((String) objArr8111[0]);
            Object[] objArr8112 = new Object[1];
            c((short) 133, bArr313[198], (byte) (-bArr313[99]), objArr8112);
            objArr6 = (Object[]) cls113.getMethod((String) objArr8112[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr8110);
            if (baseContext != null) {
                objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-326560385);
                if (objAccessartificialFrame8 == null) {
                    int iIndexOf8 = 30 - TextUtils.indexOf("", "", 0, 0);
                    char tapTimeout4 = (char) ((ViewConfiguration.getTapTimeout() >> 16) + 49362);
                    int iIndexOf9 = 683 - TextUtils.indexOf((CharSequence) "", '0', 0, 0);
                    byte[] bArr314 = $$a;
                    Object[] objArr8113 = new Object[1];
                    b(bArr314[9], (byte) (-bArr314[4]), (byte) 81, objArr8113);
                    objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(iIndexOf8, tapTimeout4, iIndexOf9, 1944867703, false, (String) objArr8113[0], null);
                }
                ((Field) objAccessartificialFrame8).set(null, objArr6);
                Long lValueOf13 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(-1283093189);
                if (objAccessartificialFrame9 == null) {
                    int mode4 = 30 - View.MeasureSpec.getMode(0);
                    char cCombineMeasuredStates3 = (char) (View.combineMeasuredStates(0, 0) + 49362);
                    int iMyPid3 = 684 - (Process.myPid() >> 22);
                    byte[] bArr315 = $$a;
                    Object[] objArr8114 = new Object[1];
                    b(bArr315[8], (byte) (-bArr315[4]), (byte) ($$b - 2), objArr8114);
                    objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(mode4, cCombineMeasuredStates3, iMyPid3, 752929587, false, (String) objArr8114[0], null);
                }
                ((Field) objAccessartificialFrame9).set(null, lValueOf13);
            }
        }
        objArr7 = objArr6;
        i12 = ((int[]) objArr7[1])[0];
        i13 = ((int[]) objArr7[0])[0];
        if (i13 == i12) {
            int i1310 = ((int[]) objArr7[2])[0];
            Object[] objArr910 = {new int[]{((int[]) objArr7[0])[0]}, new int[]{((int[]) objArr7[1])[0]}, new int[1], (String) objArr7[3]};
            int iMaxMemory2 = (int) Runtime.getRuntime().maxMemory();
            int i1311 = i1310 + 449822958 + (((~((-420339500) | iMaxMemory2)) | (-961544188)) * (-502)) + ((~((~iMaxMemory2) | (-403259913))) * (-502)) + (((~(iMaxMemory2 | (-558284276))) | (-420339500)) * TypedValues.PositionType.TYPE_DRAWPATH);
            int i1312 = (i1311 << 13) ^ i1311;
            int i1313 = i1312 ^ (i1312 >>> 17);
            ((int[]) objArr910[2])[0] = i1313 ^ (i1313 << 5);
        } else {
            Object[] objArr911 = {Long.valueOf(((long) (i12 ^ i13)) ^ (((long) (-1121832718)) << 32)), Long.valueOf(-1121832714)};
            byte[] bArr316 = $$d;
            Object[] objArr912 = new Object[1];
            c((short) 376, (byte) (-bArr316[26]), bArr316[83], objArr912);
            Class<?> cls114 = Class.forName((String) objArr912[0]);
            Object[] objArr913 = new Object[1];
            c((short) 465, bArr316[31], bArr316[19], objArr913);
            cls114.getMethod((String) objArr913[0], Long.TYPE, Long.TYPE).invoke(null, objArr911);
            int i1314 = ((int[]) objArr7[2])[0];
            Object[] objArr914 = {new int[]{((int[]) objArr7[0])[0]}, new int[]{((int[]) objArr7[1])[0]}, new int[1], (String) objArr7[3]};
            int iIdentityHashCode12 = System.identityHashCode(this);
            int i1410 = ~iIdentityHashCode12;
            int i1411 = i1314 + (((~(iIdentityHashCode12 | 1069056620)) | (~(90432845 | i1410))) * 959) + 532492963 + (((~(iIdentityHashCode12 | 90432845)) | (~(i1410 | 1069056620))) * 959);
            int i1412 = (i1411 << 13) ^ i1411;
            int i1413 = i1412 ^ (i1412 >>> 17);
            ((int[]) objArr914[2])[0] = i1413 ^ (i1413 << 5);
        }
        objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-1168947751);
        if (objAccessartificialFrame10 == null) {
            int doubleTapTimeout2 = 36 - (ViewConfiguration.getDoubleTapTimeout() >> 16);
            char c9 = (char) (1 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)));
            int pressedStateDuration4 = 540 - (ViewConfiguration.getPressedStateDuration() >> 16);
            byte[] bArr317 = $$a;
            byte b20 = bArr317[5];
            Object[] objArr915 = new Object[1];
            b((byte) (b20 - 1), bArr317[18], (byte) (b20 - 1), objArr915);
            objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(doubleTapTimeout2, c9, pressedStateDuration4, 624296913, false, (String) objArr915[0], null);
        }
        j3 = ((Field) objAccessartificialFrame10).getLong(null);
        if (j3 != -1) {
            objAccessartificialFrame11 = ArtificialStackFrames.accessartificialFrame(-1717965552);
            if (objAccessartificialFrame11 == null) {
                objAccessartificialFrame11 = ArtificialStackFrames.coroutineCreation((KeyEvent.getMaxKeyCode() >> 16) + 20, (char) (Gravity.getAbsoluteGravity(0, 0) + 39516), 982 - ((Process.getThreadPriority(0) + 20) >> 6), 117222168, false, null, new Class[0]);
            }
            Object[] objArr916 = {null, ((Constructor) objAccessartificialFrame11).newInstance(null), 1327372054, 0};
            objAccessartificialFrame12 = ArtificialStackFrames.accessartificialFrame(-501205803);
            if (objAccessartificialFrame12 == null) {
                int keyRepeatTimeout4 = 36 - (ViewConfiguration.getKeyRepeatTimeout() >> 16);
                char cIndexOf9 = (char) TextUtils.indexOf("", "", 0, 0);
                int keyRepeatTimeout5 = 540 - (ViewConfiguration.getKeyRepeatTimeout() >> 16);
                byte b110 = (byte) ($$a[5] - 1);
                Object[] objArr917 = new Object[1];
                b((byte) 47, b110, (byte) (b110 | 96), objArr917);
                objAccessartificialFrame12 = ArtificialStackFrames.coroutineCreation(keyRepeatTimeout4, cIndexOf9, keyRepeatTimeout5, 2101703389, false, (String) objArr917[0], new Class[]{(Class) ArtificialStackFrames.coroutineCreation(54 - KeyEvent.normalizeMetaState(0), (char) ((ViewConfiguration.getJumpTapTimeout() >> 16) + 833), (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 575), (Class) ArtificialStackFrames.coroutineCreation(TextUtils.getOffsetBefore("", 0) + 54, (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), 630 - (ViewConfiguration.getScrollBarSize() >> 8)), Integer.TYPE, Integer.TYPE});
            }
            objArr8 = (Object[]) ((Method) objAccessartificialFrame12).invoke(null, objArr916);
            objAccessartificialFrame13 = ArtificialStackFrames.accessartificialFrame(-1339222025);
            if (objAccessartificialFrame13 == null) {
                int packedPositionGroup2 = ExpandableListView.getPackedPositionGroup(0L) + 36;
                char cRed2 = (char) Color.red(0);
                int i1414 = (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 539;
                byte[] bArr318 = $$a;
                Object[] objArr918 = new Object[1];
                b((byte) (bArr318[5] - 1), bArr318[18], bArr318[28], objArr918);
                objAccessartificialFrame13 = ArtificialStackFrames.coroutineCreation(packedPositionGroup2, cRed2, i1414, 793268735, false, (String) objArr918[0], null);
            }
            ((Field) objAccessartificialFrame13).set(null, objArr8);
            Long lValueOf14 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame14 = ArtificialStackFrames.accessartificialFrame(-1168947751);
            if (objAccessartificialFrame14 == null) {
                int i1415 = (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 35;
                char cArgb2 = (char) Color.argb(0, 0, 0, 0);
                int iResolveSizeAndState2 = 540 - View.resolveSizeAndState(0, 0, 0);
                byte[] bArr319 = $$a;
                byte b111 = bArr319[5];
                Object[] objArr919 = new Object[1];
                b((byte) (b111 - 1), bArr319[18], (byte) (b111 - 1), objArr919);
                objAccessartificialFrame14 = ArtificialStackFrames.coroutineCreation(i1415, cArgb2, iResolveSizeAndState2, 624296913, false, (String) objArr919[0], null);
            }
            ((Field) objAccessartificialFrame14).set(null, lValueOf14);
        } else {
            objAccessartificialFrame11 = ArtificialStackFrames.accessartificialFrame(-1717965552);
            if (objAccessartificialFrame11 == null) {
                objAccessartificialFrame11 = ArtificialStackFrames.coroutineCreation((KeyEvent.getMaxKeyCode() >> 16) + 20, (char) (Gravity.getAbsoluteGravity(0, 0) + 39516), 982 - ((Process.getThreadPriority(0) + 20) >> 6), 117222168, false, null, new Class[0]);
            }
            Object[] objArr9110 = {null, ((Constructor) objAccessartificialFrame11).newInstance(null), 1327372054, 0};
            objAccessartificialFrame12 = ArtificialStackFrames.accessartificialFrame(-501205803);
            if (objAccessartificialFrame12 == null) {
                int keyRepeatTimeout6 = 36 - (ViewConfiguration.getKeyRepeatTimeout() >> 16);
                char cIndexOf10 = (char) TextUtils.indexOf("", "", 0, 0);
                int keyRepeatTimeout7 = 540 - (ViewConfiguration.getKeyRepeatTimeout() >> 16);
                byte b112 = (byte) ($$a[5] - 1);
                Object[] objArr9111 = new Object[1];
                b((byte) 47, b112, (byte) (b112 | 96), objArr9111);
                objAccessartificialFrame12 = ArtificialStackFrames.coroutineCreation(keyRepeatTimeout6, cIndexOf10, keyRepeatTimeout7, 2101703389, false, (String) objArr9111[0], new Class[]{(Class) ArtificialStackFrames.coroutineCreation(54 - KeyEvent.normalizeMetaState(0), (char) ((ViewConfiguration.getJumpTapTimeout() >> 16) + 833), (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 575), (Class) ArtificialStackFrames.coroutineCreation(TextUtils.getOffsetBefore("", 0) + 54, (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), 630 - (ViewConfiguration.getScrollBarSize() >> 8)), Integer.TYPE, Integer.TYPE});
            }
            objArr8 = (Object[]) ((Method) objAccessartificialFrame12).invoke(null, objArr9110);
            objAccessartificialFrame13 = ArtificialStackFrames.accessartificialFrame(-1339222025);
            if (objAccessartificialFrame13 == null) {
                int packedPositionGroup3 = ExpandableListView.getPackedPositionGroup(0L) + 36;
                char cRed3 = (char) Color.red(0);
                int i1416 = (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 539;
                byte[] bArr3110 = $$a;
                Object[] objArr9112 = new Object[1];
                b((byte) (bArr3110[5] - 1), bArr3110[18], bArr3110[28], objArr9112);
                objAccessartificialFrame13 = ArtificialStackFrames.coroutineCreation(packedPositionGroup3, cRed3, i1416, 793268735, false, (String) objArr9112[0], null);
            }
            ((Field) objAccessartificialFrame13).set(null, objArr8);
            Long lValueOf15 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame14 = ArtificialStackFrames.accessartificialFrame(-1168947751);
            if (objAccessartificialFrame14 == null) {
                int i1417 = (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 35;
                char cArgb3 = (char) Color.argb(0, 0, 0, 0);
                int iResolveSizeAndState3 = 540 - View.resolveSizeAndState(0, 0, 0);
                byte[] bArr3111 = $$a;
                byte b113 = bArr3111[5];
                Object[] objArr9113 = new Object[1];
                b((byte) (b113 - 1), bArr3111[18], (byte) (b113 - 1), objArr9113);
                objAccessartificialFrame14 = ArtificialStackFrames.coroutineCreation(i1417, cArgb3, iResolveSizeAndState3, 624296913, false, (String) objArr9113[0], null);
            }
            ((Field) objAccessartificialFrame14).set(null, lValueOf15);
        }
        obj2 = objArr8[1];
        i14 = ((int[]) obj2)[0];
        obj3 = objArr8[2];
        i15 = ((int[]) obj3)[0];
        if (i15 == i14) {
            int i1510 = artificialFrame + 65;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i1510 % 128;
            int i1511 = i1510 % 2;
            Object[] objArr1010 = {new int[1], new int[1], new int[1]};
            int i1512 = ((int[]) objArr8[0])[0];
            int i1610 = ((int[]) obj3)[0];
            int i1611 = ((int[]) obj2)[0];
            ((int[]) objArr1010[2])[0] = i1610;
            ((int[]) objArr1010[1])[0] = i1611;
            int iIdentityHashCode13 = System.identityHashCode(this);
            int i1612 = ~iIdentityHashCode13;
            int i1613 = i1512 + 668882033 + ((iIdentityHashCode13 | 288548352) * 140) + (((~(288548352 | i1612)) | 776802421) * (-280)) + (((~(iIdentityHashCode13 | (-776802422))) | (~(1063073397 | i1612)) | 2277376) * 140);
            int i1614 = (i1613 << 13) ^ i1613;
            int i1615 = i1614 ^ (i1614 >>> 17);
            ((int[]) objArr1010[0])[0] = i1615 ^ (i1615 << 5);
            i16 = 0;
        } else {
            Object[] objArr1011 = {Long.valueOf((((long) 1283651378) << 32) ^ ((long) (i14 ^ i15))), Long.valueOf(1283647282)};
            byte[] bArr320 = $$d;
            Object[] objArr1012 = new Object[1];
            c((short) 288, (byte) (-bArr320[26]), bArr320[479], objArr1012);
            Class<?> cls115 = Class.forName((String) objArr1012[0]);
            Object[] objArr1013 = new Object[1];
            c((short) 465, bArr320[31], bArr320[19], objArr1013);
            cls115.getMethod((String) objArr1013[0], Long.TYPE, Long.TYPE).invoke(null, objArr1011);
            Object[] objArr1014 = {new int[1], new int[1], new int[1]};
            int i1616 = ((int[]) objArr8[0])[0];
            int i1617 = ((int[]) objArr8[2])[0];
            int i1618 = ((int[]) objArr8[1])[0];
            ((int[]) objArr1014[2])[0] = i1617;
            ((int[]) objArr1014[1])[0] = i1618;
            int iIdentityHashCode14 = System.identityHashCode(this);
            int i1619 = 1072819877 + (((~((-89542043) | iIdentityHashCode14)) | 17845402 | (~((-1262079708) | iIdentityHashCode14))) * (-880));
            int i1710 = (~((-89542043) | (~iIdentityHashCode14))) | 1262079707;
            int i1711 = ~(iIdentityHashCode14 | 89542042);
            int i1712 = i1616 + i1619 + ((i1710 | i1711) * (-880)) + (i1711 * 880);
            int i1713 = (i1712 << 13) ^ i1712;
            int i1714 = i1713 ^ (i1713 >>> 17);
            i16 = 0;
            ((int[]) objArr1014[0])[0] = i1714 ^ (i1714 << 5);
        }
        objAccessartificialFrame15 = ArtificialStackFrames.accessartificialFrame(1745676544);
        if (objAccessartificialFrame15 == null) {
            int i1715 = 17 - (TypedValue.complexToFloat(i16) > 0.0f ? 1 : (TypedValue.complexToFloat(i16) == 0.0f ? 0 : -1));
            char absoluteGravity5 = (char) Gravity.getAbsoluteGravity(i16, i16);
            int iRed3 = 747 - Color.red(i16);
            byte[] bArr49 = $$a;
            byte b114 = bArr49[5];
            Object[] objArr1015 = new Object[1];
            b((byte) (b114 - 1), bArr49[18], (byte) (b114 - 1), objArr1015);
            objAccessartificialFrame15 = ArtificialStackFrames.coroutineCreation(i1715, absoluteGravity5, iRed3, -144068856, false, (String) objArr1015[0], null);
        }
        j4 = ((Field) objAccessartificialFrame15).getLong(null);
        if (j4 != -1) {
            baseContext2 = getBaseContext();
            if (baseContext2 == null) {
                Object[] objArr1016 = new Object[1];
                a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 4, new char[]{49248, 9089, 2515, 30328, 49153, 40671, 29655, 16794, 13519, 37400, 26263, 23046, 10625, 34113, 27203, 22342, 7777, 47250, 20743, 25537, 4886, 46040, 17607, 31889, 2036, 42777, 19329, 35149, 31873, 23125}, objArr1016);
                Class<?> cls116 = Class.forName((String) objArr1016[0]);
                Object[] objArr1017 = new Object[1];
                a((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 1, new char[]{37436, 30945, 40643, 39809, 37471, 50596, 58577, 44131, 26265, 51583, 61847, 46992, 31692, 56865, 64847, 47864, 19487, 58352, 50711, 36408, 16723, 59583}, objArr1017);
                baseContext2 = (Context) cls116.getMethod((String) objArr1017[0], new Class[0]).invoke(null, null);
            }
            if (baseContext2 != null) {
                if (baseContext2 instanceof ContextWrapper) {
                    int i1716 = artificialFrame + 89;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i1716 % 128;
                    int i1717 = i1716 % 2;
                    if (((ContextWrapper) baseContext2).getBaseContext() != null) {
                        baseContext2 = baseContext2.getApplicationContext();
                    } else {
                        baseContext2 = null;
                    }
                } else {
                    baseContext2 = baseContext2.getApplicationContext();
                }
            }
            Object[] objArr1110 = {baseContext2, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 59556439};
            byte[] bArr410 = $$d;
            Object[] objArr1111 = new Object[1];
            c((short) 114, (byte) (-bArr410[26]), bArr410[320], objArr1111);
            Class<?> cls117 = Class.forName((String) objArr1111[0]);
            Object[] objArr1112 = new Object[1];
            c((short) 133, bArr410[198], (byte) (-bArr410[99]), objArr1112);
            objArr9 = (Object[]) cls117.getMethod((String) objArr1112[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr1110);
            objAccessartificialFrame16 = ArtificialStackFrames.accessartificialFrame(1575402270);
            if (objAccessartificialFrame16 == null) {
                int trimmedLength4 = TextUtils.getTrimmedLength("") + 17;
                char cIndexOf11 = (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0, 0));
                int capsMode2 = 747 - TextUtils.getCapsMode("", 0, 0);
                byte[] bArr411 = $$a;
                Object[] objArr1113 = new Object[1];
                b((byte) (bArr411[5] - 1), bArr411[18], bArr411[28], objArr1113);
                objAccessartificialFrame16 = ArtificialStackFrames.coroutineCreation(trimmedLength4, cIndexOf11, capsMode2, -1031537386, false, (String) objArr1113[0], null);
            }
            ((Field) objAccessartificialFrame16).set(null, objArr9);
            Long lValueOf16 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame17 = ArtificialStackFrames.accessartificialFrame(1745676544);
            if (objAccessartificialFrame17 == null) {
                int i1718 = (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 16;
                char c10 = (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) - 1);
                int i1719 = (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 746;
                byte[] bArr412 = $$a;
                byte b115 = bArr412[5];
                Object[] objArr1114 = new Object[1];
                b((byte) (b115 - 1), bArr412[18], (byte) (b115 - 1), objArr1114);
                objAccessartificialFrame17 = ArtificialStackFrames.coroutineCreation(i1718, c10, i1719, -144068856, false, (String) objArr1114[0], null);
            }
            ((Field) objAccessartificialFrame17).set(null, lValueOf16);
        } else {
            baseContext2 = getBaseContext();
            if (baseContext2 == null) {
                Object[] objArr1018 = new Object[1];
                a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 4, new char[]{49248, 9089, 2515, 30328, 49153, 40671, 29655, 16794, 13519, 37400, 26263, 23046, 10625, 34113, 27203, 22342, 7777, 47250, 20743, 25537, 4886, 46040, 17607, 31889, 2036, 42777, 19329, 35149, 31873, 23125}, objArr1018);
                Class<?> cls118 = Class.forName((String) objArr1018[0]);
                Object[] objArr1019 = new Object[1];
                a((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 1, new char[]{37436, 30945, 40643, 39809, 37471, 50596, 58577, 44131, 26265, 51583, 61847, 46992, 31692, 56865, 64847, 47864, 19487, 58352, 50711, 36408, 16723, 59583}, objArr1019);
                baseContext2 = (Context) cls118.getMethod((String) objArr1019[0], new Class[0]).invoke(null, null);
            }
            if (baseContext2 != null) {
                if (baseContext2 instanceof ContextWrapper) {
                    int i17110 = artificialFrame + 89;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i17110 % 128;
                    int i17111 = i17110 % 2;
                    if (((ContextWrapper) baseContext2).getBaseContext() != null) {
                        baseContext2 = baseContext2.getApplicationContext();
                    } else {
                        baseContext2 = null;
                    }
                } else {
                    baseContext2 = baseContext2.getApplicationContext();
                }
            }
            Object[] objArr1115 = {baseContext2, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 59556439};
            byte[] bArr413 = $$d;
            Object[] objArr1116 = new Object[1];
            c((short) 114, (byte) (-bArr413[26]), bArr413[320], objArr1116);
            Class<?> cls119 = Class.forName((String) objArr1116[0]);
            Object[] objArr1117 = new Object[1];
            c((short) 133, bArr413[198], (byte) (-bArr413[99]), objArr1117);
            objArr9 = (Object[]) cls119.getMethod((String) objArr1117[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr1115);
            objAccessartificialFrame16 = ArtificialStackFrames.accessartificialFrame(1575402270);
            if (objAccessartificialFrame16 == null) {
                int trimmedLength5 = TextUtils.getTrimmedLength("") + 17;
                char cIndexOf12 = (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0, 0));
                int capsMode3 = 747 - TextUtils.getCapsMode("", 0, 0);
                byte[] bArr414 = $$a;
                Object[] objArr1118 = new Object[1];
                b((byte) (bArr414[5] - 1), bArr414[18], bArr414[28], objArr1118);
                objAccessartificialFrame16 = ArtificialStackFrames.coroutineCreation(trimmedLength5, cIndexOf12, capsMode3, -1031537386, false, (String) objArr1118[0], null);
            }
            ((Field) objAccessartificialFrame16).set(null, objArr9);
            Long lValueOf17 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame17 = ArtificialStackFrames.accessartificialFrame(1745676544);
            if (objAccessartificialFrame17 == null) {
                int i17112 = (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 16;
                char c11 = (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) - 1);
                int i17113 = (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 746;
                byte[] bArr415 = $$a;
                byte b116 = bArr415[5];
                Object[] objArr1119 = new Object[1];
                b((byte) (b116 - 1), bArr415[18], (byte) (b116 - 1), objArr1119);
                objAccessartificialFrame17 = ArtificialStackFrames.coroutineCreation(i17112, c11, i17113, -144068856, false, (String) objArr1119[0], null);
            }
            ((Field) objAccessartificialFrame17).set(null, lValueOf17);
        }
        i17 = ((int[]) objArr9[4])[0];
        i18 = ((int[]) objArr9[3])[0];
        if (i18 == i17) {
            Object[] objArr1120 = {list3, new int[1], list4, new int[]{i187}, new int[]{i188}};
            int i1810 = ((int[]) objArr9[1])[0];
            int i1811 = ((int[]) objArr9[3])[0];
            int i1812 = ((int[]) objArr9[4])[0];
            List list7 = (List) objArr9[0];
            List list8 = (List) objArr9[2];
            int i1813 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getDisplayMetrics().widthPixels;
            int i1910 = i1810 + ((((-769471549) + (((~i1813) | 1478672) * 1324)) + (((~(i1813 | 594989264)) | (~(10459193 | i1813))) * (-1324))) - 582841722);
            int i1911 = (i1910 << 13) ^ i1910;
            int i1912 = i1911 ^ (i1911 >>> 17);
            ((int[]) objArr1120[1])[0] = i1912 ^ (i1912 << 5);
        } else {
            ArrayList arrayList5 = new ArrayList();
            Object[] objArr1121 = {objArr9};
            objAccessartificialFrame18 = ArtificialStackFrames.accessartificialFrame(1804664566);
            if (objAccessartificialFrame18 == null) {
                objAccessartificialFrame18 = ArtificialStackFrames.coroutineCreation(TextUtils.indexOf((CharSequence) "", '0', 0) + 42, (char) ((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 12469), View.getDefaultSize(0, 0) + 3642, -185222914, false, "coroutineCreation", new Class[]{Object[].class});
            }
            arrayList5.add(((Method) objAccessartificialFrame18).invoke(null, objArr1121));
            Object[] objArr1122 = {objArr9};
            objAccessartificialFrame19 = ArtificialStackFrames.accessartificialFrame(-1243809191);
            if (objAccessartificialFrame19 == null) {
                objAccessartificialFrame19 = ArtificialStackFrames.coroutineCreation(41 - (ViewConfiguration.getEdgeSlop() >> 16), (char) (12468 - Drawable.resolveOpacity(0, 0)), TextUtils.indexOf("", "", 0) + 3642, 716815441, false, "ArtificialStackFrames", new Class[]{Object[].class});
            }
            arrayList5.add(((Method) objAccessartificialFrame19).invoke(null, objArr1122));
            Object[] objArr1210 = {Long.valueOf((((long) (-1803836028)) << 32) ^ ((long) (i17 ^ i18))), Long.valueOf(-1803836020)};
            byte[] bArr416 = $$d;
            byte b117 = bArr416[6];
            Object[] objArr1211 = new Object[1];
            c(b117, (byte) (-bArr416[26]), b117, objArr1211);
            Class<?> cls120 = Class.forName((String) objArr1211[0]);
            Object[] objArr1212 = new Object[1];
            c((short) 465, bArr416[31], bArr416[19], objArr1212);
            cls120.getMethod((String) objArr1212[0], Long.TYPE, Long.TYPE).invoke(null, objArr1210);
            Object[] objArr1213 = {list5, new int[1], list6, new int[]{i194}, new int[]{i195}};
            int i1913 = ((int[]) objArr9[1])[0];
            int i1914 = ((int[]) objArr9[3])[0];
            int i1915 = ((int[]) objArr9[4])[0];
            List list9 = (List) objArr9[0];
            List list10 = (List) objArr9[2];
            int iIdentityHashCode15 = System.identityHashCode(this);
            int i1916 = 824145913 + (((~((-541545908) | iIdentityHashCode15)) | 4657426 | (~((-63902551) | iIdentityHashCode15))) * (-880));
            int i1917 = (~((-541545908) | (~iIdentityHashCode15))) | 63902550;
            int i1918 = ~(iIdentityHashCode15 | 541545907);
            int i1919 = i1913 + i1916 + ((i1917 | i1918) * (-880)) + (i1918 * 880);
            int i206 = (i1919 << 13) ^ i1919;
            int i207 = i206 ^ (i206 >>> 17);
            ((int[]) objArr1213[1])[0] = i207 ^ (i207 << 5);
            int i208 = getARTIFICIAL_FRAME_PACKAGE_NAME + 15;
            artificialFrame = i208 % 128;
            int i209 = i208 % 2;
        }
        super.onStart();
    }

    @Override // android.app.Activity
    protected void onPause() throws Throwable {
        int i = 2 % 2;
        int i2 = getARTIFICIAL_FRAME_PACKAGE_NAME + 23;
        artificialFrame = i2 % 128;
        int i3 = i2 % 2;
        Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(949068051);
        if (objAccessartificialFrame == null) {
            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(ImageFormat.getBitsPerPixel(0) + 31, (char) (49993 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1))), 73 - ImageFormat.getBitsPerPixel(0), -1477122277, false, "MediaDescriptionCompatApi23Builder", null);
        }
        Object obj = null;
        Object obj2 = ((Field) objAccessartificialFrame).get(null);
        try {
            Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1579114835);
            if (objAccessartificialFrame2 == null) {
                int scrollBarFadeDuration = 30 - (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                char c = (char) ((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 49994);
                int iCombineMeasuredStates = 74 - View.combineMeasuredStates(0, 0);
                byte[] bArr = $$d;
                byte b = bArr[31];
                Object[] objArr = new Object[1];
                c(b, (byte) (-bArr[26]), b, objArr);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(scrollBarFadeDuration, c, iCombineMeasuredStates, -1048959141, false, (String) objArr[0], new Class[0]);
            }
            ((Method) objAccessartificialFrame2).invoke(obj2, null);
            super.onPause();
            int i4 = getARTIFICIAL_FRAME_PACKAGE_NAME + 91;
            artificialFrame = i4 % 128;
            if (i4 % 2 != 0) {
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

    /* JADX WARN: Code duplicated, block: B:13:0x0198  */
    /* JADX WARN: Code duplicated, block: B:16:0x0240 A[Catch: all -> 0x0a28, TryCatch #0 {all -> 0x0a28, blocks: (B:52:0x0735, B:54:0x0749, B:55:0x0779, B:14:0x021f, B:16:0x0240, B:17:0x0291), top: B:95:0x021f }] */
    /* JADX WARN: Code duplicated, block: B:20:0x02a3  */
    /* JADX WARN: Code duplicated, block: B:25:0x0377  */
    /* JADX WARN: Code duplicated, block: B:51:0x06eb  */
    /* JADX WARN: Code duplicated, block: B:54:0x0749 A[Catch: all -> 0x0a28, TryCatch #0 {all -> 0x0a28, blocks: (B:52:0x0735, B:54:0x0749, B:55:0x0779, B:14:0x021f, B:16:0x0240, B:17:0x0291), top: B:95:0x021f }] */
    /* JADX WARN: Code duplicated, block: B:58:0x078f  */
    /* JADX WARN: Code duplicated, block: B:63:0x0841  */
    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
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
            int keyRepeatTimeout = (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 25;
            char cMakeMeasureSpec = (char) (30068 - View.MeasureSpec.makeMeasureSpec(0, 0));
            int iResolveSizeAndState = 816 - View.resolveSizeAndState(0, 0, 0);
            byte[] bArr = $$a;
            byte b = bArr[5];
            Object[] objArr3 = new Object[1];
            b((byte) (b - 1), bArr[18], (byte) (b - 1), objArr3);
            objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(keyRepeatTimeout, cMakeMeasureSpec, iResolveSizeAndState, 721586079, false, (String) objArr3[0], null);
        }
        long j = ((Field) objAccessartificialFrame7).getLong(null);
        if (j != -1) {
            long j2 = j + 2006;
            Object[] objArr4 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 35, new char[]{11853, 13658, 43204, 18336, 11820, 34820, 53952, 28738, 56034, 33987, 51072, 27614, 51106, 37785, 51978, 26339, 61556, 44633, 61456, 21013, 64800, 42281, 58824, 19807, 59886, 45505}, objArr4);
            Class<?> cls = Class.forName((String) objArr4[0]);
            Object[] objArr5 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 35, new char[]{50696, 63944, 25624, 50150, 50797, 17556, 7705, 62470, 12987, 18525, 2908, 61412, 12269, 24345, 1940, 57986, 6177, 25301, 15581}, objArr5);
            if (j2 >= ((Long) cls.getDeclaredMethod((String) objArr5[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame8 == null) {
                    int i2 = 26 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1));
                    char c = (char) (30068 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)));
                    int iArgb = Color.argb(0, 0, 0, 0) + 816;
                    byte[] bArr2 = $$a;
                    Object[] objArr6 = new Object[1];
                    b((byte) (bArr2[5] - 1), bArr2[18], bArr2[28], objArr6);
                    objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(i2, c, iArgb, 891606461, false, (String) objArr6[0], null);
                }
                Object[] objArr7 = (Object[]) ((Field) objAccessartificialFrame8).get(null);
                objArr = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i3 = ((int[]) objArr7[0])[0];
                int i4 = ((int[]) objArr7[1])[0];
                String[] strArr = (String[]) objArr7[2];
                int iNextInt = new Random().nextInt(1905650119);
                int i5 = (((-322574290) + (((~((-551575825) | iNextInt)) | (~((-353403459) | iNextInt))) * 69)) + (((~(iNextInt | (-488476368))) | ((~((-686648734) | iNextInt)) | 135072909)) * (-69))) - 2116624636;
                int i6 = (i5 << 13) ^ i5;
                int i7 = i6 ^ (i6 >>> 17);
                ((int[]) objArr[3])[0] = i7 ^ (i7 << 5);
            } else {
                Object[] objArr8 = new Object[1];
                a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 35, new char[]{45557, 13559, 55736, 4420, 45471, 35238, 41902, 9909, 17691, 34155, 46841, 15738, 22546, 37481, 47627, 12333, 28614, 45043, 33149, 1273}, objArr8);
                Class<?> cls2 = Class.forName((String) objArr8[0]);
                Object[] objArr9 = new Object[1];
                a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) - 36, new char[]{45825, 47696, 56571, 9311, 45928, 1796, 42750, 5025, 18357, 3017, 45999, 2166, 23241, 7297, 49000, 1319, 27906, 8527, 33855, 12778}, objArr9);
                try {
                    Object[] objArr10 = {Integer.valueOf(((Integer) cls2.getMethod((String) objArr9[0], Object.class).invoke(null, this)).intValue()), 0, 927499876};
                    objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(1327366003);
                    if (objAccessartificialFrame == null) {
                        int iRed = 25 - Color.red(0);
                        char c2 = (char) (30068 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)));
                        int i8 = 817 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1));
                        byte[] bArr3 = $$a;
                        Object[] objArr11 = new Object[1];
                        b((byte) 28, bArr3[9], (byte) (bArr3[75] - 1), objArr11);
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(iRed, c2, i8, -797394565, false, (String) objArr11[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                    }
                    objArr = (Object[]) ((Method) objAccessartificialFrame).invoke(null, objArr10);
                    objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                    if (objAccessartificialFrame2 == null) {
                        int i9 = (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 25;
                        char fadingEdgeLength = (char) (30068 - (ViewConfiguration.getFadingEdgeLength() >> 16));
                        int iIndexOf = TextUtils.indexOf((CharSequence) "", '0', 0) + 817;
                        byte[] bArr4 = $$a;
                        Object[] objArr12 = new Object[1];
                        b((byte) (bArr4[5] - 1), bArr4[18], bArr4[28], objArr12);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(i9, fadingEdgeLength, iIndexOf, 891606461, false, (String) objArr12[0], null);
                    }
                    ((Field) objAccessartificialFrame2).set(null, objArr);
                    try {
                        Object[] objArr13 = new Object[1];
                        a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 35, new char[]{11853, 13658, 43204, 18336, 11820, 34820, 53952, 28738, 56034, 33987, 51072, 27614, 51106, 37785, 51978, 26339, 61556, 44633, 61456, 21013, 64800, 42281, 58824, 19807, 59886, 45505}, objArr13);
                        Class<?> cls3 = Class.forName((String) objArr13[0]);
                        Object[] objArr14 = new Object[1];
                        a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) - 36, new char[]{50696, 63944, 25624, 50150, 50797, 17556, 7705, 62470, 12987, 18525, 2908, 61412, 12269, 24345, 1940, 57986, 6177, 25301, 15581}, objArr14);
                        Long lValueOf = Long.valueOf(((Long) cls3.getDeclaredMethod((String) objArr14[0], new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                        if (objAccessartificialFrame3 == null) {
                            int i10 = 25 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                            char cBlue = (char) (30068 - Color.blue(0));
                            int iMyTid = (Process.myTid() >> 22) + 816;
                            byte[] bArr5 = $$a;
                            byte b2 = bArr5[5];
                            Object[] objArr15 = new Object[1];
                            b((byte) (b2 - 1), bArr5[18], (byte) (b2 - 1), objArr15);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(i10, cBlue, iMyTid, 721586079, false, (String) objArr15[0], null);
                        }
                        ((Field) objAccessartificialFrame3).set(null, lValueOf);
                        int i11 = artificialFrame + 101;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i11 % 128;
                        int i12 = i11 % 2;
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
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 35, new char[]{45557, 13559, 55736, 4420, 45471, 35238, 41902, 9909, 17691, 34155, 46841, 15738, 22546, 37481, 47627, 12333, 28614, 45043, 33149, 1273}, objArr16);
            Class<?> cls4 = Class.forName((String) objArr16[0]);
            Object[] objArr17 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) - 36, new char[]{45825, 47696, 56571, 9311, 45928, 1796, 42750, 5025, 18357, 3017, 45999, 2166, 23241, 7297, 49000, 1319, 27906, 8527, 33855, 12778}, objArr17);
            Object[] objArr18 = {Integer.valueOf(((Integer) cls4.getMethod((String) objArr17[0], Object.class).invoke(null, this)).intValue()), 0, 927499876};
            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(1327366003);
            if (objAccessartificialFrame == null) {
                int iRed2 = 25 - Color.red(0);
                char c3 = (char) (30068 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)));
                int i13 = 817 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1));
                byte[] bArr6 = $$a;
                Object[] objArr19 = new Object[1];
                b((byte) 28, bArr6[9], (byte) (bArr6[75] - 1), objArr19);
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(iRed2, c3, i13, -797394565, false, (String) objArr19[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            }
            objArr = (Object[]) ((Method) objAccessartificialFrame).invoke(null, objArr18);
            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame2 == null) {
                int i14 = (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 25;
                char fadingEdgeLength2 = (char) (30068 - (ViewConfiguration.getFadingEdgeLength() >> 16));
                int iIndexOf2 = TextUtils.indexOf((CharSequence) "", '0', 0) + 817;
                byte[] bArr7 = $$a;
                Object[] objArr110 = new Object[1];
                b((byte) (bArr7[5] - 1), bArr7[18], bArr7[28], objArr110);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(i14, fadingEdgeLength2, iIndexOf2, 891606461, false, (String) objArr110[0], null);
            }
            ((Field) objAccessartificialFrame2).set(null, objArr);
            Object[] objArr111 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 35, new char[]{11853, 13658, 43204, 18336, 11820, 34820, 53952, 28738, 56034, 33987, 51072, 27614, 51106, 37785, 51978, 26339, 61556, 44633, 61456, 21013, 64800, 42281, 58824, 19807, 59886, 45505}, objArr111);
            Class<?> cls5 = Class.forName((String) objArr111[0]);
            Object[] objArr112 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) - 36, new char[]{50696, 63944, 25624, 50150, 50797, 17556, 7705, 62470, 12987, 18525, 2908, 61412, 12269, 24345, 1940, 57986, 6177, 25301, 15581}, objArr112);
            Long lValueOf2 = Long.valueOf(((Long) cls5.getDeclaredMethod((String) objArr112[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1268268649);
            if (objAccessartificialFrame3 == null) {
                int i15 = 25 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                char cBlue2 = (char) (30068 - Color.blue(0));
                int iMyTid2 = (Process.myTid() >> 22) + 816;
                byte[] bArr8 = $$a;
                byte b3 = bArr8[5];
                Object[] objArr113 = new Object[1];
                b((byte) (b3 - 1), bArr8[18], (byte) (b3 - 1), objArr113);
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(i15, cBlue2, iMyTid2, 721586079, false, (String) objArr113[0], null);
            }
            ((Field) objAccessartificialFrame3).set(null, lValueOf2);
            int i16 = artificialFrame + 101;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i16 % 128;
            int i17 = i16 % 2;
        }
        int i18 = ((int[]) objArr[1])[0];
        int i19 = ((int[]) objArr[0])[0];
        if (i19 == i18) {
            Object[] objArr20 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i20 = ((int[]) objArr[3])[0];
            int i21 = ((int[]) objArr[0])[0];
            int i22 = ((int[]) objArr[1])[0];
            String[] strArr2 = (String[]) objArr[2];
            int iFreeMemory = (int) Runtime.getRuntime().freeMemory();
            int i23 = i20 + (((~(1048522750 | iFreeMemory)) | 575605772) * 449) + 1335544564 + (((~((~iFreeMemory) | 1048522750)) | 575605772) * 449);
            int i24 = (i23 << 13) ^ i23;
            int i25 = i24 ^ (i24 >>> 17);
            ((int[]) objArr20[3])[0] = i25 ^ (i25 << 5);
        } else {
            ArrayList arrayList = new ArrayList();
            String[] strArr3 = (String[]) objArr[2];
            if (strArr3 != null) {
                for (String str : strArr3) {
                    arrayList.add(str);
                }
            }
            long j3 = ((long) (i18 ^ i19)) ^ (((long) (-1789298993)) << 32);
            long j4 = -1789298994;
            int i26 = artificialFrame + 75;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i26 % 128;
            int i27 = i26 % 2;
            try {
                Object[] objArr21 = {Long.valueOf(j3), Long.valueOf(j4)};
                short s = (short) ($$e | 262);
                byte[] bArr9 = $$d;
                Object[] objArr22 = new Object[1];
                c(s, (byte) (-bArr9[26]), bArr9[121], objArr22);
                Class<?> cls6 = Class.forName((String) objArr22[0]);
                Object[] objArr23 = new Object[1];
                c((short) 465, bArr9[31], bArr9[19], objArr23);
                cls6.getMethod((String) objArr23[0], Long.TYPE, Long.TYPE).invoke(null, objArr21);
                Object[] objArr24 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i28 = ((int[]) objArr[3])[0];
                int i29 = ((int[]) objArr[0])[0];
                int i30 = ((int[]) objArr[1])[0];
                String[] strArr4 = (String[]) objArr[2];
                int i31 = ~(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 656294562);
                int i32 = i28 + (-830475237) + ((~((-34413826) | i31)) * (-783)) + (((~(i31 | 150118652)) | (-48053714)) * 783);
                int i33 = (i32 << 13) ^ i32;
                int i34 = i33 ^ (i33 >>> 17);
                ((int[]) objArr24[3])[0] = i34 ^ (i34 << 5);
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
            int touchSlop = (ViewConfiguration.getTouchSlop() >> 8) + 26;
            char c4 = (char) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) - 1);
            int iArgb2 = 1041 - Color.argb(0, 0, 0, 0);
            byte[] bArr10 = $$a;
            byte b4 = bArr10[5];
            Object[] objArr25 = new Object[1];
            b((byte) (b4 - 1), bArr10[18], (byte) (b4 - 1), objArr25);
            objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(touchSlop, c4, iArgb2, 2061780482, false, (String) objArr25[0], null);
        }
        long j5 = ((Field) objAccessartificialFrame9).getLong(null);
        if (j5 != -1) {
            int i35 = artificialFrame + 63;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i35 % 128;
            int i36 = i35 % 2;
            long j6 = j5 + 4611686018427387756L;
            Object[] objArr26 = new Object[1];
            a(ViewConfiguration.getScrollBarSize() >> 8, new char[]{11853, 13658, 43204, 18336, 11820, 34820, 53952, 28738, 56034, 33987, 51072, 27614, 51106, 37785, 51978, 26339, 61556, 44633, 61456, 21013, 64800, 42281, 58824, 19807, 59886, 45505}, objArr26);
            Class<?> cls7 = Class.forName((String) objArr26[0]);
            Object[] objArr27 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(1) - 49, new char[]{50696, 63944, 25624, 50150, 50797, 17556, 7705, 62470, 12987, 18525, 2908, 61412, 12269, 24345, 1940, 57986, 6177, 25301, 15581}, objArr27);
            if (j6 >= ((Long) cls7.getDeclaredMethod((String) objArr27[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame10 == null) {
                    int scrollBarSize = 26 - (ViewConfiguration.getScrollBarSize() >> 8);
                    char cLastIndexOf = (char) (TextUtils.lastIndexOf("", '0', 0) + 1);
                    int doubleTapTimeout = 1041 - (ViewConfiguration.getDoubleTapTimeout() >> 16);
                    byte[] bArr11 = $$a;
                    Object[] objArr28 = new Object[1];
                    b((byte) (bArr11[5] - 1), bArr11[18], bArr11[28], objArr28);
                    objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(scrollBarSize, cLastIndexOf, doubleTapTimeout, 1145017376, false, (String) objArr28[0], null);
                }
                Object[] objArr29 = (Object[]) ((Field) objAccessartificialFrame10).get(null);
                objArr2 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
                int i37 = ((int[]) objArr29[3])[0];
                int i38 = ((int[]) objArr29[2])[0];
                String[] strArr5 = (String[]) objArr29[0];
                int i39 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().uiMode;
                int i40 = ~i39;
                int i41 = ~((-466653983) | i40);
                int i42 = ~(388550175 | i39);
                int i43 = ((((-1881911684) + ((i41 | i42) * 1150)) + (((~((-388550176) | i40)) | i42) * (-575))) + (((~(i39 | (-466653983))) | (~(i40 | 466653982))) * 575)) - 129759339;
                int i44 = (i43 << 13) ^ i43;
                int i45 = i44 ^ (i44 >>> 17);
                ((int[]) objArr2[1])[0] = i45 ^ (i45 << 5);
            } else {
                Object[] objArr30 = new Object[1];
                a((CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)), new char[]{45557, 13559, 55736, 4420, 45471, 35238, 41902, 9909, 17691, 34155, 46841, 15738, 22546, 37481, 47627, 12333, 28614, 45043, 33149, 1273}, objArr30);
                Class<?> cls8 = Class.forName((String) objArr30[0]);
                Object[] objArr31 = new Object[1];
                a(ViewConfiguration.getEdgeSlop() >> 16, new char[]{45825, 47696, 56571, 9311, 45928, 1796, 42750, 5025, 18357, 3017, 45999, 2166, 23241, 7297, 49000, 1319, 27906, 8527, 33855, 12778}, objArr31);
                int iIntValue = ((Integer) cls8.getMethod((String) objArr31[0], Object.class).invoke(null, this)).intValue();
                Object[] objArr32 = {-1466662673};
                objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1648942878);
                if (objAccessartificialFrame4 == null) {
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(8 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), (char) (22251 - (ViewConfiguration.getKeyRepeatTimeout() >> 16)), TextUtils.lastIndexOf("", '0', 0, 0) + 1034, 47343338, false, null, new Class[]{Integer.TYPE});
                }
                Object[] objArrAccessartificialFrame$78cbbd35 = ExceptionsCollector$$ExternalSyntheticApiModelOutline6.accessartificialFrame$78cbbd35(iIntValue, 0, ((Constructor) objAccessartificialFrame4).newInstance(objArr32), -129759339, false);
                objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame5 == null) {
                    int mirror = 'J' - AndroidCharacter.getMirror('0');
                    char c5 = (char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) - 1);
                    int modifierMetaStateMask = 1040 - ((byte) KeyEvent.getModifierMetaStateMask());
                    byte[] bArr12 = $$a;
                    Object[] objArr33 = new Object[1];
                    b((byte) (bArr12[5] - 1), bArr12[18], bArr12[28], objArr33);
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(mirror, c5, modifierMetaStateMask, 1145017376, false, (String) objArr33[0], null);
                }
                ((Field) objAccessartificialFrame5).set(null, objArrAccessartificialFrame$78cbbd35);
                try {
                    Object[] objArr34 = new Object[1];
                    a((-1) - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), new char[]{11853, 13658, 43204, 18336, 11820, 34820, 53952, 28738, 56034, 33987, 51072, 27614, 51106, 37785, 51978, 26339, 61556, 44633, 61456, 21013, 64800, 42281, 58824, 19807, 59886, 45505}, objArr34);
                    Class<?> cls9 = Class.forName((String) objArr34[0]);
                    Object[] objArr35 = new Object[1];
                    a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 21, new char[]{50696, 63944, 25624, 50150, 50797, 17556, 7705, 62470, 12987, 18525, 2908, 61412, 12269, 24345, 1940, 57986, 6177, 25301, 15581}, objArr35);
                    Long lValueOf3 = Long.valueOf(((Long) cls9.getDeclaredMethod((String) objArr35[0], new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-444530678);
                    if (objAccessartificialFrame6 == null) {
                        int i46 = (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 25;
                        char cIndexOf = (char) TextUtils.indexOf("", "", 0);
                        int i47 = 1041 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                        byte[] bArr13 = $$a;
                        byte b5 = bArr13[5];
                        Object[] objArr36 = new Object[1];
                        b((byte) (b5 - 1), bArr13[18], (byte) (b5 - 1), objArr36);
                        objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(i46, cIndexOf, i47, 2061780482, false, (String) objArr36[0], null);
                    }
                    ((Field) objAccessartificialFrame6).set(null, lValueOf3);
                    objArr2 = objArrAccessartificialFrame$78cbbd35;
                } catch (Exception unused2) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object[] objArr37 = new Object[1];
            a((CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)), new char[]{45557, 13559, 55736, 4420, 45471, 35238, 41902, 9909, 17691, 34155, 46841, 15738, 22546, 37481, 47627, 12333, 28614, 45043, 33149, 1273}, objArr37);
            Class<?> cls10 = Class.forName((String) objArr37[0]);
            Object[] objArr38 = new Object[1];
            a(ViewConfiguration.getEdgeSlop() >> 16, new char[]{45825, 47696, 56571, 9311, 45928, 1796, 42750, 5025, 18357, 3017, 45999, 2166, 23241, 7297, 49000, 1319, 27906, 8527, 33855, 12778}, objArr38);
            int iIntValue2 = ((Integer) cls10.getMethod((String) objArr38[0], Object.class).invoke(null, this)).intValue();
            Object[] objArr39 = {-1466662673};
            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame4 == null) {
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(8 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), (char) (22251 - (ViewConfiguration.getKeyRepeatTimeout() >> 16)), TextUtils.lastIndexOf("", '0', 0, 0) + 1034, 47343338, false, null, new Class[]{Integer.TYPE});
            }
            Object[] objArrAccessartificialFrame$78cbbd36 = ExceptionsCollector$$ExternalSyntheticApiModelOutline6.accessartificialFrame$78cbbd35(iIntValue2, 0, ((Constructor) objAccessartificialFrame4).newInstance(objArr39), -129759339, false);
            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame5 == null) {
                int mirror2 = 'J' - AndroidCharacter.getMirror('0');
                char c6 = (char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) - 1);
                int modifierMetaStateMask2 = 1040 - ((byte) KeyEvent.getModifierMetaStateMask());
                byte[] bArr14 = $$a;
                Object[] objArr310 = new Object[1];
                b((byte) (bArr14[5] - 1), bArr14[18], bArr14[28], objArr310);
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(mirror2, c6, modifierMetaStateMask2, 1145017376, false, (String) objArr310[0], null);
            }
            ((Field) objAccessartificialFrame5).set(null, objArrAccessartificialFrame$78cbbd36);
            Object[] objArr311 = new Object[1];
            a((-1) - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), new char[]{11853, 13658, 43204, 18336, 11820, 34820, 53952, 28738, 56034, 33987, 51072, 27614, 51106, 37785, 51978, 26339, 61556, 44633, 61456, 21013, 64800, 42281, 58824, 19807, 59886, 45505}, objArr311);
            Class<?> cls11 = Class.forName((String) objArr311[0]);
            Object[] objArr312 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 21, new char[]{50696, 63944, 25624, 50150, 50797, 17556, 7705, 62470, 12987, 18525, 2908, 61412, 12269, 24345, 1940, 57986, 6177, 25301, 15581}, objArr312);
            Long lValueOf4 = Long.valueOf(((Long) cls11.getDeclaredMethod((String) objArr312[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-444530678);
            if (objAccessartificialFrame6 == null) {
                int i48 = (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 25;
                char cIndexOf2 = (char) TextUtils.indexOf("", "", 0);
                int i49 = 1041 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                byte[] bArr15 = $$a;
                byte b6 = bArr15[5];
                Object[] objArr313 = new Object[1];
                b((byte) (b6 - 1), bArr15[18], (byte) (b6 - 1), objArr313);
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(i48, cIndexOf2, i49, 2061780482, false, (String) objArr313[0], null);
            }
            ((Field) objAccessartificialFrame6).set(null, lValueOf4);
            objArr2 = objArrAccessartificialFrame$78cbbd36;
        }
        int i50 = ((int[]) objArr2[2])[0];
        int i51 = ((int[]) objArr2[3])[0];
        if (i51 == i50) {
            Object[] objArr40 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i52 = ((int[]) objArr2[1])[0];
            int i53 = ((int[]) objArr2[3])[0];
            int i54 = ((int[]) objArr2[2])[0];
            String[] strArr6 = (String[]) objArr2[0];
            int i55 = ~((~System.identityHashCode(this)) | 537822390);
            int i56 = i52 + ((427190 | i55) * (-374)) + 1115530978 + ((i55 | 537395200) * 374);
            int i57 = (i56 << 13) ^ i56;
            int i58 = i57 ^ (i57 >>> 17);
            ((int[]) objArr40[1])[0] = i58 ^ (i58 << 5);
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        String[] strArr7 = (String[]) objArr2[0];
        if (strArr7 != null) {
            int i59 = artificialFrame + 107;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i59 % 128;
            for (int i60 = i59 % 2 != 0 ? 1 : 0; i60 < strArr7.length; i60++) {
                int i61 = getARTIFICIAL_FRAME_PACKAGE_NAME + 59;
                artificialFrame = i61 % 128;
                int i62 = i61 % 2;
                arrayList2.add(strArr7[i60]);
            }
        }
        long j7 = ((long) (i50 ^ i51)) ^ (((long) (-600275110)) << 32);
        long j8 = -600275112;
        int i63 = getARTIFICIAL_FRAME_PACKAGE_NAME + 1;
        artificialFrame = i63 % 128;
        int i64 = i63 % 2;
        Object[] objArr41 = {Long.valueOf(j7), Long.valueOf(j8)};
        byte[] bArr16 = $$d;
        short s2 = bArr16[31];
        Object[] objArr42 = new Object[1];
        c(s2, (byte) (s2 | 75), (byte) (bArr16[162] + 1), objArr42);
        Class<?> cls12 = Class.forName((String) objArr42[0]);
        Object[] objArr43 = new Object[1];
        c((short) 465, bArr16[31], bArr16[19], objArr43);
        cls12.getMethod((String) objArr43[0], Long.TYPE, Long.TYPE).invoke(null, objArr41);
        Object[] objArr44 = {strArr, new int[1], new int[]{i}, new int[]{i}};
        int i65 = ((int[]) objArr2[1])[0];
        int i66 = ((int[]) objArr2[3])[0];
        int i67 = ((int[]) objArr2[2])[0];
        String[] strArr8 = (String[]) objArr2[0];
        int i68 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 941760413;
        int i69 = ~i68;
        int i70 = ~(908072169 | i69);
        int i71 = i65 + (-456173730) + (((-930635756) | i70) * (-712)) + (((~(i68 | (-22563587))) | (~(i69 | 930635755))) * (-712)) + ((829968362 | i70) * 712);
        int i72 = (i71 << 13) ^ i71;
        int i73 = i72 ^ (i72 >>> 17);
        ((int[]) objArr44[1])[0] = i73 ^ (i73 << 5);
    }

    static {
        byte[] bArr = new byte[638];
        System.arraycopy("jã\u009b\u0089ðþ;Ãôü\u0004÷\u00033Éï\u0006îÿ\u0002\u00012ÃööAÁ÷ö\u000bï\u0000\tñ:½ýýþñ\u0011å\tò\u0006öý\u000bùýë\u000bð\u0007û\u0002ùé\u0003\u0006ô\u0003ý2°ü\f\u0003úüúîü\u000eëú\u0007ÿù\u0002ö\u0004ñ\"Ð\rð\u0004ðþ;Âûñ\u000fú÷û\u0004íü>Åé\u0011úñø\u0007öý÷AÝÐ2Ö\u0002úïÿ&É\u0011úñø\u0007öýü¿ðþ;Ãôü\u0004÷\u00033Çíõ\u0005ø\u0001=¶\u0007÷ÿ9Éø\u0000ù2éØî*àå)âèQïðþ;Ãôü\u0004÷\u00033Çðþüúý<Çðÿü\u0003þëBÝèí\u001fèò\u0002ïðùÿöý\u0007÷\u0005\u001eÍ\t\u0000é\u0007öýðþ;Ä\u0001úúÿïü\u00009Éíü\u0000ÿ÷ÿôAéÍü ß÷ÿ#ßé\u000f9ïðþ;·\u000eñ\u0003î\tóù\u000bú3½\bë\u0003\u0002í\u0007÷\u0003\u0000óùö\r2½\u0004ý÷\u0004/¹I¿ðùÿöý\u0007÷\u0005\u001fÏö\u0003\u0006ÿëõðþ;Ãôü\u0004÷\u00033Éí\u00037ÙØ\u0002÷\u000f\rÚÿ÷\u0001\u0000ÿðü\u00009\u0001Á÷ö\u000bï\u0000\tñ:º\u0000\u0007é\nóù\u0001;Éï\u0006îÿ\u0002\u00012æÛûýïü\tý\rà\bô\u0002í/Ùÿíø\u000bïðþ;Ä\u0001úúÿïü\u00009Áø\böþñ\u0003õ\u0007õÿ÷\u00053ºúÿ\u0007ë\u000eúïûAÖèï\u0004\u0007ð\tôù&Ì\rï\u0007÷\u0014Úÿ\u0007ë\u000eúïJÌèï\u0004\u0007ð\tôù%Ðý÷ú\u0004\u0004ïÐùÿöý\u0007÷\u0005\u001dÛÿé\nüú÷\u0003\u0018Óðþ;Ãôü\u0004÷\u00033Éï\u0006îÿ\u0002\u00012ÃööAÁ÷ö\u000bï\u0000\tñ:½ýýþñ\u0011å\tò\u0006öý\u000bøðþüúý<°ü\u000bîðþ;¶þ\rï÷\u0006òû\u0001ùû\u0000\u0005îB¾ù\bþé\u0007öýý\bï\töþï@¾ù\u0004üþï@Öýüþ\u0001ßñ\u000b Íü\u0007ó\u0006ûïJ½\u0000ÿðü\u00009\u0001Á÷ö\u000bï\u0000\tñ:³\u0000AØé\u0000ñ\u0011îÿ\u000bà\bô\u0002íLÉá\u0005ñ\u000bï\u001aïê\u0004".getBytes(CharEncoding.ISO_8859_1), 0, bArr, 0, 638);
        $$d = bArr;
        $$e = 201;
        $$a = new byte[]{Ascii.EM, 104, 41, -86, -5, 1, 33, -33, 2, 9, -5, 7, -5, 1, 50, -39, -11, 7, Ascii.FF, -15, -27, -1, 7, 6, 33, -51, Ascii.FF, -3, 8, -1, -13, 2, -15, 33, -33, 19, -17, 32, -15, -19, Ascii.VT, -5, 7, -10, Ascii.US, -20, -13, 8, Ascii.VT, Ascii.CR, -27, 9, -18, 36, -33, 19, -17, 32, -15, -19, Ascii.VT, -5, 7, 7, -18, 43, -29, 4, -17, -2, 9, -18, 34, -25, -4, 17, -19, Ascii.SI, 1, Ascii.DC2, -15, -19, Ascii.VT, -5, 7, 2, -15, 36, -21, -13, Ascii.SI, -2, -9, -6, 34, -15, -19, Ascii.VT, -5, 7, -49, -2, Ascii.VT, 3, -3, 6, -6, 8, -11, Ascii.EM, -33, 19, -2, -8, 37, -44, 17, -12, 8, -14};
        $$b = 68;
        getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
        artificialFrame = 1;
        onPostMessage = 5880476608755723888L;
    }
}
