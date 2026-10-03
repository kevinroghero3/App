package com.salesforce.marketingcloud.messages.iam;

import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.net.Uri;
import android.os.Build;
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
import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.ActivityCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentActivity;
import com.facebook.imageutils.JfifUtil;
import com.google.android.material.carousel.KeylineState;
import com.google.common.base.Ascii;
import com.reactnativekeyboardcontroller.listeners.FocusedInputObserver;
import com.salesforce.marketingcloud.MarketingCloudSdk;
import com.salesforce.marketingcloud.messages.RegionMessageManager;
import com.transistorsoft.rnbackgroundgeolocation.RNBackgroundGeolocationModule;
import io.sentry.protocol.SentryStackFrame;
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

/* JADX INFO: loaded from: classes3.dex */
abstract class f extends FragmentActivity implements View.OnClickListener, SwipeDismissConstraintLayout.SwipeDismissListener {
    private static final byte[] $$g;
    private static final int $$h;
    private static final byte[] $$p;
    private static final int $$q;
    private static final byte[] $$s = {85, -33, -39, -30};
    private static final int $$t = 226;
    private static int $10 = 0;
    private static int $11 = 1;
    private static char ICustomTabsCallback = 0;
    private static char TopicBuilder = 0;
    private static int artificialFrame = 0;
    private static final int d = 123;
    private static final String e = "completedEvent";
    private static char extraCallbackWithResult;
    private static final String f;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME;
    private static char onMessageChannelReady;
    private k a;
    private j b;
    private OnBackPressedCallback c;

    class a extends OnBackPressedCallback {
        a(boolean z) {
            super(z);
        }

        @Override // androidx.activity.OnBackPressedCallback
        public void handleOnBackPressed() {
            f fVar = f.this;
            fVar.b = j.b(fVar.a.k(), f.this.a());
            setEnabled(false);
            f.this.getOnBackPressedDispatcher().onBackPressed();
        }
    }

    static /* synthetic */ class b {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[InAppMessage.Button.ActionType.values().length];
            a = iArr;
            try {
                iArr[InAppMessage.Button.ActionType.url.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[InAppMessage.Button.ActionType.pushSettings.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[InAppMessage.Button.ActionType.locationSettings.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0025  */
    /* JADX WARN: Code duplicated, block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x0027). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0025
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$u(byte r5, short r6, short r7) {
        /*
            int r7 = r7 * 2
            int r0 = r7 + 1
            int r6 = r6 * 3
            int r6 = r6 + 4
            byte[] r1 = com.salesforce.marketingcloud.messages.iam.f.$$s
            int r5 = r5 * 2
            int r5 = r5 + 108
            byte[] r0 = new byte[r0]
            r2 = 0
            if (r1 != 0) goto L17
            r3 = r5
            r5 = r7
            r4 = r2
            goto L27
        L17:
            r3 = r2
        L18:
            byte r4 = (byte) r5
            r0[r3] = r4
            int r4 = r3 + 1
            if (r3 != r7) goto L25
            java.lang.String r5 = new java.lang.String
            r5.<init>(r0, r2)
            return r5
        L25:
            r3 = r1[r6]
        L27:
            int r5 = r5 + r3
            int r6 = r6 + 1
            r3 = r4
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.messages.iam.f.$$u(byte, short, short):java.lang.String");
    }

    static {
        byte[] bArr = new byte[641];
        System.arraycopy("7üø´ù\u00075º\u000bë\u000búõ\u0003ï@ÜÛý\u001aëë\u000búõ\u0016éñýø\u0006ñ\u0001ùõQÓèí\u001cëë\u000búõ\u0007ûò\u0003\u001báúë\u0001ùõÐùÿöý\u0007÷\u0005\u001dÛÿé\nüú÷\u0003\u0018Óðþ;Ä\u0001úúÿïü\u00009Éíü\u0000ÿ÷ÿôAéÍü ß÷ÿ#ßé\u000f9ïü¿ðþ;Ãôü\u0004÷\u00033Äùó\tÿýê\n3¸\tôú÷\u000bþðý\u0004ùþ5Á÷ö\u000bï\u0000\tñ:äÙó\tÿýê\n\u000féôú÷\u000b\u001eÐý\u0004ùþ\u001a×\u0004ó\"Øù\u0000Dïúüúîü\u000eëú\u0007ÿù\u0002ö\u0004ñ\"Ð\rð\u0004ðþ;Ãôü\u0004÷\u00033Éí\u00037ÙØ\u0002÷\u000f\rÚÿ÷\u0001\u0000ÿðü\u00009\u0001Á÷ö\u000bï\u0000\tñ:³\u0000AØé\u0000ñ\u0011îÿ\u000bà\bô\u0002íLÉá\u0005ñ\u000bï\u001aïê\u0004ðþ;Ãôü\u0004÷\u00033Çðþüúý<Çðÿü\u0003þëB×Ö\u0007\u0007÷òÿý\u0001ë\u0011ý<ÍÖ\u0007\u0007÷òÿý\u0001ë\u0011ý\u0012éç\tþ\u0002ûò\u0003\u0014èíðþ;Ãôü\u0004÷\u00033½ýýþñBÇðþüúý<·\u000bõþ÷ö\u000bï\u0000\tñ:°ü\u0005ðþ;Ãôü\u0004÷\u00033Éï\u0006îÿ\u0002\u00012½\bé\u000bï\u0005\u0004ñ:¼\tç\tþ\u0002é\u0007öý<Üéç\tþ\u0002é\u0007öý\u0014é\u0000êOîðþ;Ãôü\u0004÷\u00033Éï\u0006îÿ\u0002\u00012ÃööAÁ÷ö\u000bï\u0000\tñ:½ýýþñ\u0011å\tò\u0006öý\u000bùýë\u000bð\u0007û\u0002ùé\u0003\u0006ô\u0003ý2°ü\u0011ðþ;Ãôü\u0004÷\u00033Çíõ\u0005ø\u0001=¶\u0007÷ÿ9Éø\u0000ù2éØî*àå)âèQïðþ;Ãôü\u0004÷\u00033ºúÿ÷\u0001\té\u000b4Øßû\u0007\u001fÅ\u0001\u000b\u000eÛþ\u0005÷\u0003?Ðã\u0000þú\u0018Ñ\u000bï\ré\u0001ùðùÿöý\u0007÷\u0005\u001eÍ\t\u0000é\u0007öý\u0000ÿðü\u00009\u0001Á÷ö\u000bï\u0000\tñ:º\u0000\u0007é\nóù\u0001;Éï\u0006îÿ\u0002\u00012æÛûýïü\tý\rà\bô\u0002í/Ùÿíø\u000bï".getBytes(CharEncoding.ISO_8859_1), 0, bArr, 0, 641);
        $$p = bArr;
        $$q = 128;
        $$g = new byte[]{122, -14, -75, -84, 9, -18, 34, -25, -4, 17, -19, Ascii.SI, 1, Ascii.DC2, -15, -19, Ascii.VT, -5, 7, 2, -15, 36, -21, -13, Ascii.SI, -2, -9, -6, 34, -15, -19, Ascii.VT, -5, 7, 9, -18, 36, -33, 19, -17, 32, -15, -19, Ascii.VT, -5, 7, 7, -18, 43, -29, 4, -17, -2, -5, 1, 33, -33, 2, 9, -5, 7, -5, 1, 50, -39, -11, 7, Ascii.FF, -15, -49, -2, Ascii.VT, 3, -3, 6, -6, 8, -11, Ascii.EM, -33, 19, -2, -8, 37, -44, 17, -12, 8, -14, -27, -1, 7, 6, 33, -51, Ascii.FF, -3, 8, -1, -13, 2, -15, 33, -33, 19, -17, 32, -15, -19, Ascii.VT, -5, 7, -10, Ascii.US, -20, -13, 8, Ascii.VT, Ascii.CR, -27};
        $$h = 236;
        getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
        artificialFrame = 1;
        accessartificialFrame();
        f = com.salesforce.marketingcloud.g.a("IamBaseActivity");
    }

    f() {
    }

    private void d() {
        if (com.salesforce.marketingcloud.util.f.b(this) && MarketingCloudSdk.isReady()) {
            RegionMessageManager regionMessageManager = MarketingCloudSdk.getInstance().getRegionMessageManager();
            try {
                if (regionMessageManager.enableGeofenceMessaging()) {
                    com.salesforce.marketingcloud.g.a(f, "Geofence messaging enabled from IAM action", new Object[0]);
                }
                if (regionMessageManager.enableProximityMessaging()) {
                    com.salesforce.marketingcloud.g.a(f, "Proximity messaging enabled from IAM action", new Object[0]);
                }
            } catch (Exception e2) {
                com.salesforce.marketingcloud.g.b(f, e2, "Unable to enable region messaging", new Object[0]);
            }
        }
    }

    private void e() {
        if (com.salesforce.marketingcloud.util.f.b(this)) {
            com.salesforce.marketingcloud.g.a(f, "Location permission already allowed.  Skipping action from button click.", new Object[0]);
            d();
            finish();
        } else {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, RNBackgroundGeolocationModule.ACCESS_FINE_LOCATION)) {
                ActivityCompat.requestPermissions(this, com.salesforce.marketingcloud.util.f.a, d);
                return;
            }
            try {
                startActivityForResult(new Intent("android.settings.APPLICATION_DETAILS_SETTINGS").setData(Uri.fromParts(SentryStackFrame.JsonKeys.PACKAGE, getPackageName(), null)), d);
            } catch (ActivityNotFoundException e2) {
                com.salesforce.marketingcloud.g.b(f, e2, "Unable to launch application settings page for location permission request.", new Object[0]);
                finish();
            }
        }
    }

    private void f() {
        Intent intentPutExtra = Build.VERSION.SDK_INT >= 26 ? new Intent("android.settings.APP_NOTIFICATION_SETTINGS").putExtra("android.provider.extra.APP_PACKAGE", getPackageName()) : new Intent("android.settings.APP_NOTIFICATION_SETTINGS").putExtra("app_package", getPackageName()).putExtra("app_uid", getApplicationInfo().uid);
        if (intentPutExtra != null) {
            try {
                startActivity(intentPutExtra);
            } catch (ActivityNotFoundException e2) {
                com.salesforce.marketingcloud.g.b(f, e2, "Unable to handle push settings button action.", new Object[0]);
            }
        } else {
            com.salesforce.marketingcloud.g.a(f, "Unable to launch notification settings for this device.", new Object[0]);
        }
        finish();
    }

    private void g() {
        try {
            int iQ = c().q();
            if (iQ != 0) {
                getWindow().setStatusBarColor(iQ);
            }
        } catch (Exception e2) {
            com.salesforce.marketingcloud.g.a(f, e2, "Failed to find status bar color from meta-data", new Object[0]);
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0025  */
    /* JADX WARN: Code duplicated, block: B:8:0x001d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x002b). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0025
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void q(byte r6, int r7, int r8, java.lang.Object[] r9) {
        /*
            int r0 = r8 + 8
            int r6 = r6 + 4
            byte[] r1 = com.salesforce.marketingcloud.messages.iam.f.$$g
            int r7 = 112 - r7
            byte[] r0 = new byte[r0]
            int r8 = r8 + 7
            r2 = 0
            if (r1 != 0) goto L13
            r7 = r6
            r3 = r8
            r4 = r2
            goto L2b
        L13:
            r3 = r2
        L14:
            byte r4 = (byte) r7
            int r6 = r6 + 1
            r0[r3] = r4
            int r4 = r3 + 1
            if (r3 != r8) goto L25
            java.lang.String r6 = new java.lang.String
            r6.<init>(r0, r2)
            r9[r2] = r6
            return
        L25:
            r3 = r1[r6]
            r5 = r7
            r7 = r6
            r6 = r3
            r3 = r5
        L2b:
            int r6 = -r6
            int r6 = r6 + r3
            r3 = r4
            r5 = r7
            r7 = r6
            r6 = r5
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.messages.iam.f.q(byte, int, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0020  */
    /* JADX WARN: Code duplicated, block: B:8:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0020 -> B:11:0x0026). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0020
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void r(int r5, int r6, short r7, java.lang.Object[] r8) {
        /*
            byte[] r0 = com.salesforce.marketingcloud.messages.iam.f.$$p
            int r7 = 111 - r7
            int r1 = 72 - r6
            int r5 = r5 + 4
            byte[] r1 = new byte[r1]
            int r6 = 71 - r6
            r2 = 0
            if (r0 != 0) goto L12
            r4 = r6
            r3 = r2
            goto L26
        L12:
            r3 = r2
        L13:
            byte r4 = (byte) r7
            r1[r3] = r4
            if (r3 != r6) goto L20
            java.lang.String r5 = new java.lang.String
            r5.<init>(r1, r2)
            r8[r2] = r5
            return
        L20:
            int r5 = r5 + 1
            int r3 = r3 + 1
            r4 = r0[r5]
        L26:
            int r4 = -r4
            int r7 = r7 + r4
            int r7 = r7 + (-4)
            goto L13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.messages.iam.f.r(int, int, short, java.lang.Object[]):void");
    }

    protected void a(j jVar) {
        this.b = jVar;
    }

    protected InAppMessage b() {
        return this.a.l();
    }

    protected k c() {
        return this.a;
    }

    @Override // android.app.Activity
    public void finish() {
        k kVar = this.a;
        if (kVar != null) {
            kVar.a(this.b);
        }
        super.finish();
        overridePendingTransition(0, 0);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == d) {
            d();
        }
        finish();
    }

    public void onClick(View view) {
        if (view.getTag() != null) {
            if (view.getTag() instanceof InAppMessage.Button) {
                b((InAppMessage.Button) view.getTag());
            } else if (view.getTag() instanceof InAppMessage.CloseButton) {
                this.b = j.b(this.a.k(), a());
                finish();
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent() != null) {
            this.a = (k) getIntent().getParcelableExtra("messageHandler");
        }
        k kVar = this.a;
        if (kVar == null || !kVar.h()) {
            finish();
            return;
        }
        g();
        if (bundle != null) {
            this.b = (j) bundle.getParcelable(e);
        }
        this.c = new a(true);
        getOnBackPressedDispatcher().addCallback(this, this.c);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        OnBackPressedCallback onBackPressedCallback = this.c;
        if (onBackPressedCallback != null) {
            onBackPressedCallback.setEnabled(false);
            this.c.remove();
            this.c = null;
        }
        super.onDestroy();
    }

    public void onDismissed() {
        this.b = j.b(this.a.k(), a());
        finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        c().n();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        d();
        finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        c().o();
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable(e, this.b);
    }

    public void onSwipeStarted() {
    }

    public void onViewSettled() {
    }

    protected long a() {
        k kVarC = c();
        kVarC.r();
        return kVarC.j();
    }

    public void b(InAppMessage.Button button) {
        if (button != null) {
            this.b = j.a(this.a.k(), a(), button);
            int i = b.a[button.actionType().ordinal()];
            if (i == 1) {
                a(button);
                return;
            }
            if (i == 2) {
                f();
            } else if (i != 3) {
                finish();
            } else {
                e();
            }
        }
    }

    private void a(InAppMessage.Button button) {
        PendingIntent pendingIntentA = c().a(this, button);
        if (pendingIntentA != null) {
            try {
                pendingIntentA.send();
            } catch (PendingIntent.CanceledException e2) {
                com.salesforce.marketingcloud.g.b(f, e2, "Unable to launch url for button click", new Object[0]);
            }
        } else {
            com.salesforce.marketingcloud.g.a(f, "No PendingIntent returned for button click.", new Object[0]);
        }
        finish();
    }

    private static void p(int i, char[] cArr, Object[] objArr) throws Throwable {
        int i2 = 2 % 2;
        build buildVar = new build();
        char[] cArr2 = new char[cArr.length];
        buildVar.c = 0;
        char[] cArr3 = new char[2];
        while (buildVar.c < cArr.length) {
            cArr3[0] = cArr[buildVar.c];
            cArr3[1] = cArr[buildVar.c + 1];
            int i3 = 58224;
            int i4 = 0;
            while (i4 < 16) {
                char c = cArr3[1];
                char c2 = cArr3[0];
                try {
                    Object[] objArr2 = {Integer.valueOf(c), Integer.valueOf((c2 + i3) ^ ((c2 << 4) + ((char) (((long) extraCallbackWithResult) ^ (-4408183324873663413L))))), Integer.valueOf(c2 >>> 5), Integer.valueOf(onMessageChannelReady)};
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1585798252);
                    if (objAccessartificialFrame == null) {
                        byte b2 = (byte) 0;
                        byte b3 = b2;
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(28 - TextUtils.getOffsetBefore("", 0), (char) ((Process.myPid() >> 22) + 17263), 1066 - TextUtils.indexOf((CharSequence) "", '0'), 1042277788, false, $$u(b2, b3, b3), new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE});
                    }
                    char cCharValue = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                    cArr3[1] = cCharValue;
                    Object[] objArr3 = {Integer.valueOf(cArr3[0]), Integer.valueOf((cCharValue + i3) ^ ((cCharValue << 4) + ((char) (((long) TopicBuilder) ^ (-4408183324873663413L))))), Integer.valueOf(cCharValue >>> 5), Integer.valueOf(ICustomTabsCallback)};
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1585798252);
                    if (objAccessartificialFrame2 == null) {
                        byte b4 = (byte) 0;
                        byte b5 = b4;
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(ExpandableListView.getPackedPositionGroup(0L) + 28, (char) (17263 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1))), 1067 - ExpandableListView.getPackedPositionGroup(0L), 1042277788, false, $$u(b4, b5, b5), new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE});
                    }
                    cArr3[0] = ((Character) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).charValue();
                    i3 -= 40503;
                    i4++;
                    int i5 = $10 + 51;
                    $11 = i5 % 128;
                    int i6 = i5 % 2;
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
            cArr2[buildVar.c] = cArr3[0];
            cArr2[buildVar.c + 1] = cArr3[1];
            Object[] objArr4 = {buildVar, buildVar};
            Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1010141908);
            if (objAccessartificialFrame3 == null) {
                byte b6 = (byte) 1;
                byte b7 = (byte) (b6 - 1);
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation((KeyEvent.getMaxKeyCode() >> 16) + 25, (char) (ImageFormat.getBitsPerPixel(0) + 63929), TextUtils.indexOf("", "", 0) + 486, 1554985764, false, $$u(b6, b7, b7), new Class[]{Object.class, Object.class});
            }
            ((Method) objAccessartificialFrame3).invoke(null, objArr4);
            int i7 = $11 + 47;
            $10 = i7 % 128;
            int i8 = i7 % 2;
        }
        objArr[0] = new String(cArr2, 0, i);
    }

    /* JADX WARN: Code duplicated, block: B:188:0x1449  */
    /* JADX WARN: Code duplicated, block: B:24:0x029b  */
    /* JADX WARN: Code duplicated, block: B:255:0x1ad3  */
    /* JADX WARN: Code duplicated, block: B:256:0x1b6a  */
    /* JADX WARN: Code duplicated, block: B:259:0x1b7d A[Catch: all -> 0x256b, TryCatch #6 {all -> 0x256b, blocks: (B:282:0x1e4c, B:284:0x1e6f, B:285:0x1ec4, B:257:0x1b70, B:259:0x1b7d, B:260:0x1bae, B:262:0x1bb8, B:264:0x1bc5, B:265:0x1bfa, B:142:0x0fe7, B:144:0x0ffc, B:145:0x1032, B:107:0x0b94, B:109:0x0b9a, B:110:0x0bca, B:112:0x0bf4, B:113:0x0c84), top: B:374:0x0b94 }] */
    /* JADX WARN: Code duplicated, block: B:264:0x1bc5 A[Catch: all -> 0x256b, TryCatch #6 {all -> 0x256b, blocks: (B:282:0x1e4c, B:284:0x1e6f, B:285:0x1ec4, B:257:0x1b70, B:259:0x1b7d, B:260:0x1bae, B:262:0x1bb8, B:264:0x1bc5, B:265:0x1bfa, B:142:0x0fe7, B:144:0x0ffc, B:145:0x1032, B:107:0x0b94, B:109:0x0b9a, B:110:0x0bca, B:112:0x0bf4, B:113:0x0c84), top: B:374:0x0b94 }] */
    /* JADX WARN: Code duplicated, block: B:271:0x1d0a  */
    /* JADX WARN: Code duplicated, block: B:281:0x1e2e  */
    /* JADX WARN: Code duplicated, block: B:284:0x1e6f A[Catch: all -> 0x256b, TryCatch #6 {all -> 0x256b, blocks: (B:282:0x1e4c, B:284:0x1e6f, B:285:0x1ec4, B:257:0x1b70, B:259:0x1b7d, B:260:0x1bae, B:262:0x1bb8, B:264:0x1bc5, B:265:0x1bfa, B:142:0x0fe7, B:144:0x0ffc, B:145:0x1032, B:107:0x0b94, B:109:0x0b9a, B:110:0x0bca, B:112:0x0bf4, B:113:0x0c84), top: B:374:0x0b94 }] */
    /* JADX WARN: Code duplicated, block: B:288:0x1ed7  */
    /* JADX WARN: Code duplicated, block: B:293:0x1f43  */
    /* JADX WARN: Code duplicated, block: B:297:0x1f97  */
    /* JADX WARN: Code duplicated, block: B:298:0x2024  */
    /* JADX WARN: Code duplicated, block: B:300:0x2030  */
    /* JADX WARN: Code duplicated, block: B:303:0x2034 A[LOOP:0: B:301:0x2031->B:303:0x2034, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:309:0x2122  */
    /* JADX WARN: Code duplicated, block: B:319:0x2266  */
    /* JADX WARN: Code duplicated, block: B:323:0x22ee  */
    /* JADX WARN: Code duplicated, block: B:328:0x2359  */
    /* JADX WARN: Code duplicated, block: B:332:0x23b0  */
    /* JADX WARN: Code duplicated, block: B:333:0x244a  */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onStart() throws Throwable {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        int i;
        Object[] objArrAccessartificialFrame$78cbbd35;
        Object[] objArr4;
        char c;
        int i2;
        Object[] objArr5;
        int i3;
        int i4;
        Object objAccessartificialFrame;
        Object objAccessartificialFrame2;
        Object objAccessartificialFrame3;
        long j;
        Object objAccessartificialFrame4;
        Object[] objArr6;
        Object objAccessartificialFrame5;
        Object objAccessartificialFrame6;
        int i5;
        int i6;
        ArrayList arrayList;
        String[] strArr;
        int i7;
        Object objAccessartificialFrame7;
        long j2;
        Object[] objArr7;
        Object objAccessartificialFrame8;
        Object objAccessartificialFrame9;
        int i8;
        int i9;
        int i10 = 2 % 2;
        Object[] objArr8 = new Object[1];
        p((ViewConfiguration.getJumpTapTimeout() >> 16) + 22, new char[]{52923, 36312, 44758, 57090, 34074, 44439, 19769, 13899, 20303, 56091, 63382, 36508, 34330, 52027, 15888, 12864, 47849, 44368, 3364, 48424, 65199, 42601}, objArr8);
        String str = (String) objArr8[0];
        Object[] objArr9 = new Object[1];
        p(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(3) - 100, new char[]{48031, 43365, 41576, 14867, 37115, 45563, 22328, 4831, 37063, 11749, 32806, 14496, 43628, 18378, 18183, 5032}, objArr9);
        String str2 = (String) objArr9[0];
        Object[] objArr10 = new Object[1];
        p(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(0) - 21, new char[]{58224, 25437, 36919, 36947, 21724, 32829, 52923, 36312, 57909, 25407, 44793, 11151, 53175, 24598, 7361, 25075}, objArr10);
        String str3 = (String) objArr10[0];
        Object[] objArr11 = new Object[1];
        p(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 12, new char[]{4408, 9642, 26912, 32316, 64863, 47606, 25078, 47908, 8972, 59220, 34161, 62132, 61167, 35585, 45506, 53174}, objArr11);
        String str4 = (String) objArr11[0];
        Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-1283093189);
        if (objAccessartificialFrame10 == null) {
            int tapTimeout = (ViewConfiguration.getTapTimeout() >> 16) + 30;
            char cKeyCodeFromString = (char) (KeyEvent.keyCodeFromString("") + 49362);
            int windowTouchSlop = 684 - (ViewConfiguration.getWindowTouchSlop() >> 8);
            byte[] bArr = $$g;
            Object[] objArr12 = new Object[1];
            q(bArr[90], bArr[19], bArr[76], objArr12);
            objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(tapTimeout, cKeyCodeFromString, windowTouchSlop, 752929587, false, (String) objArr12[0], null);
        }
        long j3 = ((Field) objAccessartificialFrame10).getLong(null);
        if (j3 == -1 || j3 + 1866 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                int i11 = getARTIFICIAL_FRAME_PACKAGE_NAME + 87;
                artificialFrame = i11 % 128;
                int i12 = i11 % 2;
                Object[] objArr13 = new Object[1];
                p(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 9, new char[]{52923, 36312, 44758, 57090, 34074, 44439, 19769, 13899, 41576, 14867, 51088, 7574, 204, 37262, 64863, 47606, 17850, 63805, 25078, 47908, 20970, 8695, 28192, 45786, 40826, 941}, objArr13);
                Class<?> cls = Class.forName((String) objArr13[0]);
                Object[] objArr14 = new Object[1];
                p(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(10) - 100, new char[]{58956, 56488, 21411, 20483, 26912, 32316, 29820, 14604, 18908, 28681, 30210, 25064, 55400, 21233, 64863, 47606, 58441, 7650}, objArr14);
                baseContext = (Context) cls.getMethod((String) objArr14[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                if (baseContext instanceof ContextWrapper) {
                    int i13 = artificialFrame + 125;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i13 % 128;
                    int i14 = i13 % 2;
                    if (((ContextWrapper) baseContext).getBaseContext() != null) {
                        baseContext = baseContext.getApplicationContext();
                    } else {
                        baseContext = null;
                    }
                } else {
                    baseContext = baseContext.getApplicationContext();
                }
            }
            int iIntValue = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
            int i15 = artificialFrame + 99;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i15 % 128;
            int i16 = i15 % 2;
            try {
                Object[] objArr15 = {baseContext, Integer.valueOf(iIntValue), 0, -237938554};
                byte[] bArr2 = $$p;
                Object[] objArr16 = new Object[1];
                r(bArr2[58], (byte) (-bArr2[38]), bArr2[85], objArr16);
                Class<?> cls2 = Class.forName((String) objArr16[0]);
                Object[] objArr17 = new Object[1];
                r(bArr2[120], bArr2[542], (byte) 44, objArr17);
                Object[] objArr18 = (Object[]) cls2.getMethod((String) objArr17[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr15);
                if (baseContext != null) {
                    Object objAccessartificialFrame11 = ArtificialStackFrames.accessartificialFrame(-326560385);
                    if (objAccessartificialFrame11 == null) {
                        int iIndexOf = TextUtils.indexOf("", "", 0, 0) + 30;
                        char c2 = (char) ((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 49363);
                        int iIndexOf2 = 683 - TextUtils.indexOf((CharSequence) "", '0');
                        byte[] bArr3 = $$g;
                        Object[] objArr19 = new Object[1];
                        q((byte) (-bArr3[1]), bArr3[4], bArr3[76], objArr19);
                        objAccessartificialFrame11 = ArtificialStackFrames.coroutineCreation(iIndexOf, c2, iIndexOf2, 1944867703, false, (String) objArr19[0], null);
                    }
                    ((Field) objAccessartificialFrame11).set(null, objArr18);
                    try {
                        Long lValueOf = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                        Object objAccessartificialFrame12 = ArtificialStackFrames.accessartificialFrame(-1283093189);
                        if (objAccessartificialFrame12 == null) {
                            int iMyTid = 30 - (Process.myTid() >> 22);
                            char scrollBarFadeDuration = (char) (49362 - (ViewConfiguration.getScrollBarFadeDuration() >> 16));
                            int bitsPerPixel = 683 - ImageFormat.getBitsPerPixel(0);
                            byte[] bArr4 = $$g;
                            Object[] objArr20 = new Object[1];
                            q(bArr4[90], bArr4[19], bArr4[76], objArr20);
                            objAccessartificialFrame12 = ArtificialStackFrames.coroutineCreation(iMyTid, scrollBarFadeDuration, bitsPerPixel, 752929587, false, (String) objArr20[0], null);
                        }
                        ((Field) objAccessartificialFrame12).set(null, lValueOf);
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
            Object objAccessartificialFrame13 = ArtificialStackFrames.accessartificialFrame(-326560385);
            if (objAccessartificialFrame13 == null) {
                int iLastIndexOf = TextUtils.lastIndexOf("", '0') + 31;
                char cBlue = (char) (49362 - Color.blue(0));
                int i17 = (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 684;
                byte[] bArr5 = $$g;
                Object[] objArr21 = new Object[1];
                q((byte) (-bArr5[1]), bArr5[4], bArr5[76], objArr21);
                objAccessartificialFrame13 = ArtificialStackFrames.coroutineCreation(iLastIndexOf, cBlue, i17, 1944867703, false, (String) objArr21[0], null);
            }
            Object[] objArr22 = (Object[]) ((Field) objAccessartificialFrame13).get(null);
            objArr = new Object[]{new int[]{((int[]) objArr22[0])[0]}, new int[]{((int[]) objArr22[1])[0]}, new int[1], (String) objArr22[3]};
            int i18 = ~new Random().nextInt();
            int i19 = (((-205053474) + (((-8521881) | i18) * 494)) + (((~(i18 | 762155590)) | (-562731167)) * 494)) - 237938554;
            int i20 = (i19 << 13) ^ i19;
            int i21 = i20 ^ (i20 >>> 17);
            ((int[]) objArr[2])[0] = i21 ^ (i21 << 5);
        }
        int i22 = ((int[]) objArr[1])[0];
        int i23 = ((int[]) objArr[0])[0];
        if (i23 == i22) {
            int i24 = ((int[]) objArr[2])[0];
            Object[] objArr23 = {new int[]{((int[]) objArr[0])[0]}, new int[]{((int[]) objArr[1])[0]}, new int[1], (String) objArr[3]};
            int i25 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().mcc;
            int i26 = (-1398612802) + (((~(1028324567 | i25)) | (-49700793)) * 672);
            int i27 = ~i25;
            int i28 = i24 + i26 + (((~(i25 | (-49700793))) | (~((-1028324568) | i27))) * (-672)) + (((~(49700792 | i27)) | (-1073676288)) * 672);
            int i29 = (i28 << 13) ^ i28;
            int i30 = i29 ^ (i29 >>> 17);
            ((int[]) objArr23[2])[0] = i30 ^ (i30 << 5);
        } else {
            try {
                Object[] objArr24 = {Long.valueOf((((long) (-561325690)) << 32) ^ ((long) (i22 ^ i23))), Long.valueOf(-561325694)};
                byte[] bArr6 = $$p;
                Object[] objArr25 = new Object[1];
                r((short) (-bArr6[7]), (byte) (-bArr6[17]), (byte) (-bArr6[94]), objArr25);
                Class<?> cls3 = Class.forName((String) objArr25[0]);
                Object[] objArr26 = new Object[1];
                r((short) 104, (byte) (bArr6[180] + 1), (byte) (bArr6[258] - 1), objArr26);
                cls3.getMethod((String) objArr26[0], Long.TYPE, Long.TYPE).invoke(null, objArr24);
                int i31 = ((int[]) objArr[2])[0];
                Object[] objArr27 = {new int[]{((int[]) objArr[0])[0]}, new int[]{((int[]) objArr[1])[0]}, new int[1], (String) objArr[3]};
                int i32 = (~(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(16) - 1113040417)) | 171373486;
                int i33 = i31 + 309400109 + (i32 * 495) + (((~i32) | 1351968) * 495);
                int i34 = (i33 << 13) ^ i33;
                int i35 = i34 ^ (i34 >>> 17);
                ((int[]) objArr27[2])[0] = i35 ^ (i35 << 5);
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 == null) {
                    throw th2;
                }
                throw cause2;
            }
        }
        Object objAccessartificialFrame14 = ArtificialStackFrames.accessartificialFrame(-2127922582);
        if (objAccessartificialFrame14 == null) {
            int size = View.MeasureSpec.getSize(0) + 30;
            char offsetAfter = (char) (TextUtils.getOffsetAfter("", 0) + 49362);
            int iRgb = Color.rgb(0, 0, 0) + 16777900;
            byte[] bArr7 = $$g;
            Object[] objArr28 = new Object[1];
            q((byte) (-bArr7[49]), bArr7[19], (byte) (-bArr7[17]), objArr28);
            objAccessartificialFrame14 = ArtificialStackFrames.coroutineCreation(size, offsetAfter, iRgb, 508509282, false, (String) objArr28[0], null);
        }
        long j4 = ((Field) objAccessartificialFrame14).getLong(null);
        if (j4 == -1 || j4 + 2006 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Context baseContext2 = getBaseContext();
            if (baseContext2 == null) {
                Object[] objArr29 = new Object[1];
                p(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(3) - 89, new char[]{52923, 36312, 44758, 57090, 34074, 44439, 19769, 13899, 41576, 14867, 51088, 7574, 204, 37262, 64863, 47606, 17850, 63805, 25078, 47908, 20970, 8695, 28192, 45786, 40826, 941}, objArr29);
                Class<?> cls4 = Class.forName((String) objArr29[0]);
                Object[] objArr30 = new Object[1];
                p(TextUtils.lastIndexOf("", '0', 0) + 19, new char[]{58956, 56488, 21411, 20483, 26912, 32316, 29820, 14604, 18908, 28681, 30210, 25064, 55400, 21233, 64863, 47606, 58441, 7650}, objArr30);
                baseContext2 = (Context) cls4.getMethod((String) objArr30[0], new Class[0]).invoke(null, null);
            }
            if (baseContext2 != null) {
                baseContext2 = (!((baseContext2 instanceof ContextWrapper) ^ true) && ((ContextWrapper) baseContext2).getBaseContext() == null) ? null : baseContext2.getApplicationContext();
            }
            int iIntValue2 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
            int i36 = artificialFrame + 121;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i36 % 128;
            int i37 = i36 % 2;
            Object[] objArr31 = {baseContext2, Integer.valueOf(iIntValue2), -1243206480};
            short s = (short) com.salesforce.marketingcloud.analytics.stats.b.l;
            byte[] bArr8 = $$p;
            Object[] objArr32 = new Object[1];
            r(s, bArr8[85], (byte) (-bArr8[94]), objArr32);
            Class<?> cls5 = Class.forName((String) objArr32[0]);
            Object[] objArr33 = new Object[1];
            r((short) ($$q | 49), bArr8[120], bArr8[187], objArr33);
            Object[] objArr34 = (Object[]) cls5.getMethod((String) objArr33[0], Context.class, Integer.TYPE, Integer.TYPE).invoke(null, objArr31);
            if (baseContext2 != null) {
                Object objAccessartificialFrame15 = ArtificialStackFrames.accessartificialFrame(777251007);
                if (objAccessartificialFrame15 == null) {
                    int iNormalizeMetaState = 30 - KeyEvent.normalizeMetaState(0);
                    char cIndexOf = (char) (49361 - TextUtils.indexOf((CharSequence) "", '0'));
                    int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0) + 684;
                    byte[] bArr9 = $$g;
                    Object[] objArr35 = new Object[1];
                    q((byte) 41, bArr9[76], (byte) (bArr9[12] - 1), objArr35);
                    objAccessartificialFrame15 = ArtificialStackFrames.coroutineCreation(iNormalizeMetaState, cIndexOf, iMakeMeasureSpec, -1321816393, false, (String) objArr35[0], null);
                }
                ((Field) objAccessartificialFrame15).set(null, objArr34);
                try {
                    Long lValueOf2 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame16 = ArtificialStackFrames.accessartificialFrame(-2127922582);
                    if (objAccessartificialFrame16 == null) {
                        int maximumDrawingCacheSize = (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 30;
                        char deadChar = (char) (49362 - KeyEvent.getDeadChar(0, 0));
                        int size2 = 684 - View.MeasureSpec.getSize(0);
                        byte[] bArr10 = $$g;
                        Object[] objArr36 = new Object[1];
                        q((byte) (-bArr10[49]), bArr10[19], (byte) (-bArr10[17]), objArr36);
                        objAccessartificialFrame16 = ArtificialStackFrames.coroutineCreation(maximumDrawingCacheSize, deadChar, size2, 508509282, false, (String) objArr36[0], null);
                    }
                    ((Field) objAccessartificialFrame16).set(null, lValueOf2);
                } catch (Exception unused2) {
                    throw new RuntimeException();
                }
            } else {
                objArr34 = objArr34;
            }
            objArr2 = objArr34;
        } else {
            Object objAccessartificialFrame17 = ArtificialStackFrames.accessartificialFrame(777251007);
            if (objAccessartificialFrame17 == null) {
                int bitsPerPixel2 = ImageFormat.getBitsPerPixel(0) + 31;
                char c3 = (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 49361);
                int minimumFlingVelocity = 684 - (ViewConfiguration.getMinimumFlingVelocity() >> 16);
                byte[] bArr11 = $$g;
                Object[] objArr37 = new Object[1];
                q((byte) 41, bArr11[76], (byte) (bArr11[12] - 1), objArr37);
                objAccessartificialFrame17 = ArtificialStackFrames.coroutineCreation(bitsPerPixel2, c3, minimumFlingVelocity, -1321816393, false, (String) objArr37[0], null);
            }
            Object[] objArr38 = (Object[]) ((Field) objAccessartificialFrame17).get(null);
            objArr2 = new Object[]{new int[]{((int[]) objArr38[0])[0]}, new int[]{((int[]) objArr38[1])[0]}, new int[1], (String) objArr38[3]};
            int i38 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().mcc;
            int i39 = (((-1020441538) + (((~((~i38) | 307622806)) | (-939522975)) * 529)) + (((~(i38 | 307622806)) | (-671000969)) * 529)) - 1243206480;
            int i40 = (i39 << 13) ^ i39;
            int i41 = i40 ^ (i40 >>> 17);
            ((int[]) objArr2[2])[0] = i41 ^ (i41 << 5);
        }
        int i42 = ((int[]) objArr2[1])[0];
        int i43 = ((int[]) objArr2[0])[0];
        if (i43 == i42) {
            int i44 = ((int[]) objArr2[2])[0];
            Object[] objArr39 = {new int[]{((int[]) objArr2[0])[0]}, new int[]{((int[]) objArr2[1])[0]}, new int[1], (String) objArr2[3]};
            int iIdentityHashCode = System.identityHashCode(this);
            int i45 = ~iIdentityHashCode;
            int i46 = i44 + (-958088776) + (((~((-256503764) | i45)) | (~((-722120012) | i45))) * (-867)) + (((~((-256503764) | iIdentityHashCode)) | 185118019 | (~((-722120012) | iIdentityHashCode))) * (-1734)) + (((~(iIdentityHashCode | (-537001993))) | (~(i45 | (-185118020))) | (~((-71385745) | iIdentityHashCode))) * 867);
            int i47 = (i46 << 13) ^ i46;
            int i48 = i47 ^ (i47 >>> 17);
            ((int[]) objArr39[2])[0] = i48 ^ (i48 << 5);
        } else {
            Object[] objArr40 = {Long.valueOf((((long) 1298869666) << 32) ^ ((long) (i42 ^ i43))), Long.valueOf(1298870178)};
            short s2 = (short) ($$q | 69);
            byte[] bArr12 = $$p;
            Object[] objArr41 = new Object[1];
            r(s2, bArr12[634], (byte) (-bArr12[94]), objArr41);
            Class<?> cls6 = Class.forName((String) objArr41[0]);
            Object[] objArr42 = new Object[1];
            r((short) 104, (byte) (bArr12[180] + 1), (byte) (bArr12[258] - 1), objArr42);
            cls6.getMethod((String) objArr42[0], Long.TYPE, Long.TYPE).invoke(null, objArr40);
            int i49 = ((int[]) objArr2[2])[0];
            Object[] objArr43 = {new int[]{((int[]) objArr2[0])[0]}, new int[]{((int[]) objArr2[1])[0]}, new int[1], (String) objArr2[3]};
            int iCodePointAt = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(1) + 1124876342;
            int i50 = ~((-324151274) | iCodePointAt);
            int i51 = ~iCodePointAt;
            int i52 = i49 + (-1279022914) + ((i50 | (~(654472501 | i51))) * (-1808)) + (((~((-50472226) | iCodePointAt)) | (~(i51 | 928151549))) * TypedValues.Custom.TYPE_BOOLEAN) + (((~(iCodePointAt | (-654472502))) | 273679048 | (~(324151273 | i51))) * TypedValues.Custom.TYPE_BOOLEAN);
            int i53 = (i52 << 13) ^ i52;
            int i54 = i53 ^ (i53 >>> 17);
            ((int[]) objArr43[2])[0] = i54 ^ (i54 << 5);
        }
        Object objAccessartificialFrame18 = ArtificialStackFrames.accessartificialFrame(-1168947751);
        if (objAccessartificialFrame18 == null) {
            int scrollBarFadeDuration2 = 36 - (ViewConfiguration.getScrollBarFadeDuration() >> 16);
            char edgeSlop = (char) (ViewConfiguration.getEdgeSlop() >> 16);
            int iResolveSizeAndState = 540 - View.resolveSizeAndState(0, 0, 0);
            byte b2 = $$g[12];
            Object[] objArr44 = new Object[1];
            q((byte) 48, (byte) (b2 - 1), b2, objArr44);
            objAccessartificialFrame18 = ArtificialStackFrames.coroutineCreation(scrollBarFadeDuration2, edgeSlop, iResolveSizeAndState, 624296913, false, (String) objArr44[0], null);
        }
        long j5 = ((Field) objAccessartificialFrame18).getLong(null);
        if (j5 == -1 || j5 + 1946 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            try {
                Object objAccessartificialFrame19 = ArtificialStackFrames.accessartificialFrame(-1717965552);
                if (objAccessartificialFrame19 == null) {
                    objAccessartificialFrame19 = ArtificialStackFrames.coroutineCreation(20 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (char) ((Process.myPid() >> 22) + 39516), 983 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), 117222168, false, null, new Class[0]);
                }
                Object[] objArr45 = {null, ((Constructor) objAccessartificialFrame19).newInstance(null), 820943662, 0};
                Object objAccessartificialFrame20 = ArtificialStackFrames.accessartificialFrame(-501205803);
                if (objAccessartificialFrame20 == null) {
                    int iRgb2 = (-16777180) - Color.rgb(0, 0, 0);
                    char cRgb = (char) (ViewCompat.MEASURED_STATE_MASK - Color.rgb(0, 0, 0));
                    int scrollDefaultDelay = 540 - (ViewConfiguration.getScrollDefaultDelay() >> 16);
                    Object[] objArr46 = new Object[1];
                    q((byte) ($$h & 336), (byte) 47, $$g[118], objArr46);
                    objAccessartificialFrame20 = ArtificialStackFrames.coroutineCreation(iRgb2, cRgb, scrollDefaultDelay, 2101703389, false, (String) objArr46[0], new Class[]{(Class) ArtificialStackFrames.coroutineCreation((ViewConfiguration.getScrollDefaultDelay() >> 16) + 54, (char) (832 - ExpandableListView.getPackedPositionChild(0L)), 576 - (ViewConfiguration.getScrollDefaultDelay() >> 16)), (Class) ArtificialStackFrames.coroutineCreation(54 - (ViewConfiguration.getJumpTapTimeout() >> 16), (char) View.resolveSize(0, 0), (ViewConfiguration.getScrollBarSize() >> 8) + 630), Integer.TYPE, Integer.TYPE});
                }
                objArr3 = (Object[]) ((Method) objAccessartificialFrame20).invoke(null, objArr45);
                Object objAccessartificialFrame21 = ArtificialStackFrames.accessartificialFrame(-1339222025);
                if (objAccessartificialFrame21 == null) {
                    int deadChar2 = KeyEvent.getDeadChar(0, 0) + 36;
                    char c4 = (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                    int i55 = (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 539;
                    byte b3 = $$g[12];
                    Object[] objArr47 = new Object[1];
                    q((byte) 56, (byte) (b3 - 1), b3, objArr47);
                    objAccessartificialFrame21 = ArtificialStackFrames.coroutineCreation(deadChar2, c4, i55, 793268735, false, (String) objArr47[0], null);
                }
                ((Field) objAccessartificialFrame21).set(null, objArr3);
                try {
                    Long lValueOf3 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame22 = ArtificialStackFrames.accessartificialFrame(-1168947751);
                    if (objAccessartificialFrame22 == null) {
                        int iArgb = Color.argb(0, 0, 0, 0) + 36;
                        char cMakeMeasureSpec = (char) View.MeasureSpec.makeMeasureSpec(0, 0);
                        int iIndexOf3 = TextUtils.indexOf((CharSequence) "", '0') + 541;
                        byte b4 = $$g[12];
                        Object[] objArr48 = new Object[1];
                        q((byte) 48, (byte) (b4 - 1), b4, objArr48);
                        objAccessartificialFrame22 = ArtificialStackFrames.coroutineCreation(iArgb, cMakeMeasureSpec, iIndexOf3, 624296913, false, (String) objArr48[0], null);
                    }
                    ((Field) objAccessartificialFrame22).set(null, lValueOf3);
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
            int i56 = artificialFrame + 43;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i56 % 128;
            int i57 = i56 % 2;
            Object objAccessartificialFrame23 = ArtificialStackFrames.accessartificialFrame(-1339222025);
            if (objAccessartificialFrame23 == null) {
                int i58 = (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 36;
                char maximumFlingVelocity = (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16);
                int packedPositionGroup = 540 - ExpandableListView.getPackedPositionGroup(0L);
                byte b5 = $$g[12];
                Object[] objArr49 = new Object[1];
                q((byte) 56, (byte) (b5 - 1), b5, objArr49);
                objAccessartificialFrame23 = ArtificialStackFrames.coroutineCreation(i58, maximumFlingVelocity, packedPositionGroup, 793268735, false, (String) objArr49[0], null);
            }
            Object[] objArr50 = (Object[]) ((Field) objAccessartificialFrame23).get(null);
            objArr3 = new Object[]{new int[1], new int[1], new int[1]};
            int i59 = ((int[]) objArr50[2])[0];
            int i60 = ((int[]) objArr50[1])[0];
            ((int[]) objArr3[2])[0] = i59;
            ((int[]) objArr3[1])[0] = i60;
            int iMyPid = Process.myPid();
            int i61 = ~((-750171818) | iMyPid);
            int i62 = 697849169 + ((203854369 | i61) * (-280)) + ((i61 | (~((-601449933) | iMyPid))) * 140);
            int i63 = ~((-546317449) | iMyPid);
            int i64 = ~iMyPid;
            int i65 = i62 + (((~(i64 | (-55132485))) | i63 | (~((-203854370) | i64))) * 140) + 820943662;
            int i66 = (i65 << 13) ^ i65;
            int i67 = i66 ^ (i66 >>> 17);
            ((int[]) objArr3[0])[0] = i67 ^ (i67 << 5);
        }
        Object[] objArr51 = objArr3;
        Object obj = objArr51[1];
        int i68 = ((int[]) obj)[0];
        Object obj2 = objArr51[2];
        int i69 = ((int[]) obj2)[0];
        if (i69 == i68) {
            int i70 = artificialFrame + d;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i70 % 128;
            int i71 = i70 % 2;
            Object[] objArr52 = {new int[1], new int[1], new int[1]};
            int i72 = ((int[]) objArr51[0])[0];
            int i73 = ((int[]) obj2)[0];
            int i74 = ((int[]) obj)[0];
            ((int[]) objArr52[2])[0] = i73;
            ((int[]) objArr52[1])[0] = i74;
            int startUptimeMillis = (int) Process.getStartUptimeMillis();
            int i75 = ~startUptimeMillis;
            int i76 = i72 + (-1059504753) + (((~((-1268933503) | i75)) | (~((-82688248) | startUptimeMillis))) * (-370)) + (((~(startUptimeMillis | (-1268933503))) | (~(i75 | (-82688248))) | (-1341127680)) * (-370)) + 1998964736;
            int i77 = i76 ^ (i76 << 13);
            int i78 = i77 ^ (i77 >>> 17);
            i = 0;
            ((int[]) objArr52[0])[0] = i78 ^ (i78 << 5);
        } else {
            Object[] objArr53 = {Long.valueOf((((long) 1863099559) << 32) ^ ((long) (i68 ^ i69))), Long.valueOf(1863103655)};
            byte[] bArr13 = $$p;
            Object[] objArr54 = new Object[1];
            r((short) (-bArr13[7]), (byte) (-bArr13[17]), (byte) (-bArr13[94]), objArr54);
            Class<?> cls7 = Class.forName((String) objArr54[0]);
            Object[] objArr55 = new Object[1];
            r((short) 104, (byte) (bArr13[180] + 1), (byte) (bArr13[258] - 1), objArr55);
            cls7.getMethod((String) objArr55[0], Long.TYPE, Long.TYPE).invoke(null, objArr53);
            Object[] objArr56 = {new int[1], new int[1], new int[1]};
            int i79 = ((int[]) objArr51[0])[0];
            int i80 = ((int[]) objArr51[2])[0];
            int i81 = ((int[]) objArr51[1])[0];
            ((int[]) objArr56[2])[0] = i80;
            ((int[]) objArr56[1])[0] = i81;
            int iNextInt = new Random().nextInt(1488587464);
            int i82 = ~iNextInt;
            int i83 = i79 + 72374094 + (((~((-459242949) | i82)) | 172974404) * 98) + (((~(i82 | (-892378802))) | (-459242949) | (~(892378801 | iNextInt))) * (-49)) + (((~(iNextInt | (-459242949))) | (-1065353206)) * 49);
            int i84 = (i83 << 13) ^ i83;
            int i85 = i84 ^ (i84 >>> 17);
            i = 0;
            ((int[]) objArr56[0])[0] = i85 ^ (i85 << 5);
        }
        Object objAccessartificialFrame24 = ArtificialStackFrames.accessartificialFrame(-444530678);
        if (objAccessartificialFrame24 == null) {
            int iResolveSize = 26 - View.resolveSize(i, i);
            char cIndexOf2 = (char) TextUtils.indexOf("", "", i);
            int packedPositionChild = 1040 - ExpandableListView.getPackedPositionChild(0L);
            byte b6 = $$g[12];
            Object[] objArr57 = new Object[1];
            q((byte) 48, (byte) (b6 - 1), b6, objArr57);
            objAccessartificialFrame24 = ArtificialStackFrames.coroutineCreation(iResolveSize, cIndexOf2, packedPositionChild, 2061780482, false, (String) objArr57[0], null);
        }
        long j6 = ((Field) objAccessartificialFrame24).getLong(null);
        if (j6 == -1 || j6 + 4611686018427387921L < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            int iIntValue3 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
            Object[] objArr58 = {1563163957};
            Object objAccessartificialFrame25 = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame25 == null) {
                objAccessartificialFrame25 = ArtificialStackFrames.coroutineCreation(9 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (char) ((ViewConfiguration.getScrollBarSize() >> 8) + 22251), 1034 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), 47343338, false, null, new Class[]{Integer.TYPE});
            }
            objArrAccessartificialFrame$78cbbd35 = FocusedInputObserver.accessartificialFrame$78cbbd35(iIntValue3, 0, ((Constructor) objAccessartificialFrame25).newInstance(objArr58), -1052464150, false);
            Object objAccessartificialFrame26 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame26 == null) {
                int keyRepeatDelay = 26 - (ViewConfiguration.getKeyRepeatDelay() >> 16);
                char deadChar3 = (char) KeyEvent.getDeadChar(0, 0);
                int i86 = (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 1040;
                byte b7 = $$g[12];
                Object[] objArr59 = new Object[1];
                q((byte) 56, (byte) (b7 - 1), b7, objArr59);
                objAccessartificialFrame26 = ArtificialStackFrames.coroutineCreation(keyRepeatDelay, deadChar3, i86, 1145017376, false, (String) objArr59[0], null);
            }
            ((Field) objAccessartificialFrame26).set(null, objArrAccessartificialFrame$78cbbd35);
            try {
                Long lValueOf4 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame27 = ArtificialStackFrames.accessartificialFrame(-444530678);
                if (objAccessartificialFrame27 == null) {
                    int modifierMetaStateMask = ((byte) KeyEvent.getModifierMetaStateMask()) + Ascii.ESC;
                    char cLastIndexOf = (char) (TextUtils.lastIndexOf("", '0', 0) + 1);
                    int iIndexOf4 = 1040 - TextUtils.indexOf((CharSequence) "", '0', 0);
                    byte b8 = $$g[12];
                    Object[] objArr60 = new Object[1];
                    q((byte) 48, (byte) (b8 - 1), b8, objArr60);
                    objAccessartificialFrame27 = ArtificialStackFrames.coroutineCreation(modifierMetaStateMask, cLastIndexOf, iIndexOf4, 2061780482, false, (String) objArr60[0], null);
                }
                ((Field) objAccessartificialFrame27).set(null, lValueOf4);
            } catch (Exception unused4) {
                throw new RuntimeException();
            }
        } else {
            Object objAccessartificialFrame28 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame28 == null) {
                int iRgb3 = (-16777190) - Color.rgb(0, 0, 0);
                char scrollDefaultDelay2 = (char) (ViewConfiguration.getScrollDefaultDelay() >> 16);
                int iArgb2 = Color.argb(0, 0, 0, 0) + 1041;
                byte b9 = $$g[12];
                Object[] objArr61 = new Object[1];
                q((byte) 56, (byte) (b9 - 1), b9, objArr61);
                objAccessartificialFrame28 = ArtificialStackFrames.coroutineCreation(iRgb3, scrollDefaultDelay2, iArgb2, 1145017376, false, (String) objArr61[0], null);
            }
            Object[] objArr62 = (Object[]) ((Field) objAccessartificialFrame28).get(null);
            objArrAccessartificialFrame$78cbbd35 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
            int i87 = ((int[]) objArr62[3])[0];
            int i88 = ((int[]) objArr62[2])[0];
            String[] strArr2 = (String[]) objArr62[0];
            int iIdentityHashCode2 = System.identityHashCode(this);
            int i89 = (((((~((-923064870) | iIdentityHashCode2)) | 839127076) * (-566)) - 1717341034) + ((~(iIdentityHashCode2 | (-83937794))) * 566)) - 1052464150;
            int i90 = (i89 << 13) ^ i89;
            int i91 = i90 ^ (i90 >>> 17);
            ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0] = i91 ^ (i91 << 5);
        }
        int i92 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
        int i93 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
        if (i93 == i92) {
            Object[] objArr63 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i94 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i95 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i96 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr3 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int iIdentityHashCode3 = System.identityHashCode(this);
            int i97 = ~(694162856 | iIdentityHashCode3);
            int i98 = i94 + 337291912 + (((-771249578) | i97) * (-814)) + ((i97 | (~((~iIdentityHashCode3) | 616059049)) | 538972328) * 407) + (((~(iIdentityHashCode3 | (-616059050))) | (~((-694162857) | iIdentityHashCode3)) | 538972328) * 407);
            int i99 = (i98 << 13) ^ i98;
            int i100 = i99 ^ (i99 >>> 17);
            ((int[]) objArr63[1])[0] = i100 ^ (i100 << 5);
        } else {
            ArrayList arrayList2 = new ArrayList();
            String[] strArr4 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            if (strArr4 != null) {
                int i101 = artificialFrame + 75;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i101 % 128;
                int i102 = i101 % 2;
                for (String str5 : strArr4) {
                    arrayList2.add(str5);
                }
            }
            Object[] objArr64 = {Long.valueOf(((long) (i92 ^ i93)) ^ (((long) 956912802) << 32)), Long.valueOf(956912800)};
            short s3 = (short) ($$q | 93);
            byte[] bArr14 = $$p;
            Object[] objArr65 = new Object[1];
            r(s3, bArr14[39], bArr14[85], objArr65);
            Class<?> cls8 = Class.forName((String) objArr65[0]);
            Object[] objArr66 = new Object[1];
            r((short) 104, (byte) (bArr14[180] + 1), (byte) (bArr14[258] - 1), objArr66);
            cls8.getMethod((String) objArr66[0], Long.TYPE, Long.TYPE).invoke(null, objArr64);
            Object[] objArr67 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i103 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i104 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i105 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr5 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int iIdentityHashCode4 = System.identityHashCode(this);
            int i106 = i103 + ((((~((-683241039) | iIdentityHashCode4)) | 537995342) * (-566)) - 359210638) + ((~(iIdentityHashCode4 | (-145245697))) * 566);
            int i107 = (i106 << 13) ^ i106;
            int i108 = i107 ^ (i107 >>> 17);
            ((int[]) objArr67[1])[0] = i108 ^ (i108 << 5);
        }
        Object objAccessartificialFrame29 = ArtificialStackFrames.accessartificialFrame(1313006081);
        if (objAccessartificialFrame29 == null) {
            int edgeSlop2 = (ViewConfiguration.getEdgeSlop() >> 16) + 21;
            char modifierMetaStateMask2 = (char) ((-1) - ((byte) KeyEvent.getModifierMetaStateMask()));
            int iLastIndexOf2 = TextUtils.lastIndexOf("", '0', 0) + 466;
            byte b10 = $$g[12];
            Object[] objArr68 = new Object[1];
            q((byte) 48, (byte) (b10 - 1), b10, objArr68);
            objAccessartificialFrame29 = ArtificialStackFrames.coroutineCreation(edgeSlop2, modifierMetaStateMask2, iLastIndexOf2, -785931255, false, (String) objArr68[0], null);
        }
        long j7 = ((Field) objAccessartificialFrame29).getLong(null);
        if (j7 == -1 || j7 + 2010 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Context baseContext3 = getBaseContext();
            if (baseContext3 == null) {
                Object[] objArr69 = new Object[1];
                p(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 22, new char[]{52923, 36312, 44758, 57090, 34074, 44439, 19769, 13899, 41576, 14867, 51088, 7574, 204, 37262, 64863, 47606, 17850, 63805, 25078, 47908, 20970, 8695, 28192, 45786, 40826, 941}, objArr69);
                Class<?> cls9 = Class.forName((String) objArr69[0]);
                Object[] objArr70 = new Object[1];
                p(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 3, new char[]{58956, 56488, 21411, 20483, 26912, 32316, 29820, 14604, 18908, 28681, 30210, 25064, 55400, 21233, 64863, 47606, 58441, 7650}, objArr70);
                baseContext3 = (Context) cls9.getMethod((String) objArr70[0], new Class[0]).invoke(null, null);
            }
            if (baseContext3 != null) {
                int i109 = getARTIFICIAL_FRAME_PACKAGE_NAME + 9;
                int i110 = i109 % 128;
                artificialFrame = i110;
                int i111 = i109 % 2;
                if (baseContext3 instanceof ContextWrapper) {
                    int i112 = i110 + 75;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i112 % 128;
                    int i113 = i112 % 2;
                    if (((ContextWrapper) baseContext3).getBaseContext() != null) {
                        baseContext3 = baseContext3.getApplicationContext();
                    } else {
                        baseContext3 = null;
                    }
                } else {
                    baseContext3 = baseContext3.getApplicationContext();
                }
            }
            int iIntValue4 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
            Object[] objArr71 = new Object[1];
            p(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(3) - 51, new char[]{28974, 30969, 42285, 16950, 34203, 36559, 51435, 8358, 34164, 34561, 12961, 6988, 40409, 12558, 17342, 7790, 2234, 4838, 57200, 22988, 31143, 20313, 17342, 7790, 46367, 61323, 7137, 33869, 53591, 65321, 10700, 41824, 26515, 46534, 12879, 43059, 17342, 7790, 37643, 61489, 41091, 63690, 26515, 46534, 8336, 58131, 14292, 44840, 62174, 60274, 2543, 12918, 34042, 55294, 39569, 21010, 41091, 63690, 12109, 57279, 24767, 15579, 28426, 63854}, objArr71);
            String str6 = (String) objArr71[0];
            Object[] objArr72 = new Object[1];
            p(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) + 28, new char[]{51687, 63293, 8280, 55753, 10700, 41824, 55713, 35603, 47144, 41386, 7503, 51654, 22290, 36057, 18347, 32038, 14950, 25618, 60496, 37046, 61171, 51742, 12961, 6988, 34042, 55294, 40870, 59343, 20335, 43500, 29982, 12232, 49682, 63377, 25419, 16685, 12961, 6988, 37511, 57436, 16243, 2748, 48351, 46431, 7137, 33869, 42285, 16950, 21093, 28596, 61171, 51742, 58460, 27372, 41844, 643, 11775, 50740, 56464, 58059, 35733, 30320, 29979, 26767}, objArr72);
            Object[] objArr73 = {baseContext3, new String[]{str6, (String) objArr72[0]}, Integer.valueOf(iIntValue4), 1, 359433666};
            byte[] bArr15 = $$p;
            Object[] objArr74 = new Object[1];
            r((short) 264, bArr15[124], (byte) (-bArr15[94]), objArr74);
            Class<?> cls10 = Class.forName((String) objArr74[0]);
            Object[] objArr75 = new Object[1];
            r((short) ($$q | 49), bArr15[120], bArr15[187], objArr75);
            objArr4 = (Object[]) cls10.getMethod((String) objArr75[0], Context.class, String[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr73);
            int i114 = ((int[]) objArr4[0])[0];
            int i115 = ((int[]) objArr4[3])[0];
            if (baseContext3 != null) {
                Object objAccessartificialFrame30 = ArtificialStackFrames.accessartificialFrame(1142731807);
                if (objAccessartificialFrame30 == null) {
                    int modifierMetaStateMask3 = 20 - ((byte) KeyEvent.getModifierMetaStateMask());
                    char c5 = (char) ((-1) - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)));
                    int iLastIndexOf3 = TextUtils.lastIndexOf("", '0') + 466;
                    byte b11 = $$g[12];
                    Object[] objArr76 = new Object[1];
                    q((byte) 56, (byte) (b11 - 1), b11, objArr76);
                    objAccessartificialFrame30 = ArtificialStackFrames.coroutineCreation(modifierMetaStateMask3, c5, iLastIndexOf3, -612765161, false, (String) objArr76[0], null);
                }
                ((Field) objAccessartificialFrame30).set(null, objArr4);
                try {
                    Long lValueOf5 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame31 = ArtificialStackFrames.accessartificialFrame(1313006081);
                    if (objAccessartificialFrame31 == null) {
                        int capsMode = TextUtils.getCapsMode("", 0, 0) + 21;
                        char minimumFlingVelocity2 = (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16);
                        int scrollBarFadeDuration3 = 465 - (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                        byte b12 = $$g[12];
                        Object[] objArr77 = new Object[1];
                        q((byte) 48, (byte) (b12 - 1), b12, objArr77);
                        objAccessartificialFrame31 = ArtificialStackFrames.coroutineCreation(capsMode, minimumFlingVelocity2, scrollBarFadeDuration3, -785931255, false, (String) objArr77[0], null);
                    }
                    ((Field) objAccessartificialFrame31).set(null, lValueOf5);
                } catch (Exception unused5) {
                    throw new RuntimeException();
                }
            }
            c = 0;
        } else {
            int i116 = artificialFrame + 75;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i116 % 128;
            int i117 = i116 % 2;
            Object objAccessartificialFrame32 = ArtificialStackFrames.accessartificialFrame(1142731807);
            if (objAccessartificialFrame32 == null) {
                int i118 = (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 21;
                char cRed = (char) Color.red(0);
                int iIndexOf5 = TextUtils.indexOf((CharSequence) "", '0') + 466;
                byte b13 = $$g[12];
                Object[] objArr78 = new Object[1];
                q((byte) 56, (byte) (b13 - 1), b13, objArr78);
                objAccessartificialFrame32 = ArtificialStackFrames.coroutineCreation(i118, cRed, iIndexOf5, -612765161, false, (String) objArr78[0], null);
            }
            Object[] objArr79 = (Object[]) ((Field) objAccessartificialFrame32).get(null);
            objArr4 = new Object[]{new int[]{i}, strArr, new int[1], new int[]{i}};
            int i119 = ((int[]) objArr79[3])[0];
            int i120 = ((int[]) objArr79[0])[0];
            String[] strArr6 = (String[]) objArr79[1];
            int iMyPid2 = Process.myPid();
            int i121 = ((1383014175 + (((~iMyPid2) | 294666496) * 1324)) + (((~(iMyPid2 | (-778412799))) | (~(938762524 | iMyPid2))) * (-1324))) - 159647552;
            int i122 = (i121 << 13) ^ i121;
            int i123 = i122 ^ (i122 >>> 17);
            ((int[]) objArr4[2])[0] = i123 ^ (i123 << 5);
            c = 0;
        }
        int i124 = ((int[]) objArr4[c])[c];
        int i125 = ((int[]) objArr4[3])[c];
        if (i125 == i124) {
            Object[] objArr80 = new Object[4];
            int[] iArr = new int[1];
            objArr80[c] = iArr;
            objArr80[2] = new int[1];
            int[] iArr2 = new int[1];
            objArr80[3] = iArr2;
            int i126 = ((int[]) objArr4[2])[c];
            int i127 = ((int[]) objArr4[3])[c];
            int i128 = ((int[]) objArr4[c])[c];
            String[] strArr7 = (String[]) objArr4[1];
            iArr2[c] = i127;
            iArr[c] = i128;
            int iIdentityHashCode5 = System.identityHashCode(this);
            int i129 = ~iIdentityHashCode5;
            int i130 = i126 + 311934693 + (((~((-530752965) | i129)) | 153100736) * (-108)) + (((~(i129 | 691102690)) | (~((-691102691) | iIdentityHashCode5)) | (-1068754919)) * 54) + ((iIdentityHashCode5 | (-1068754919)) * 54);
            int i131 = (i130 << 13) ^ i130;
            int i132 = i131 ^ (i131 >>> 17);
            ((int[]) objArr80[2])[0] = i132 ^ (i132 << 5);
            objArr80[1] = strArr7;
        } else {
            ArrayList arrayList3 = new ArrayList();
            String[] strArr8 = (String[]) objArr4[1];
            if (strArr8 != null) {
                for (String str7 : strArr8) {
                    arrayList3.add(str7);
                }
            }
            Object[] objArr81 = {Long.valueOf(((long) (i124 ^ i125)) ^ (((long) 1956903759) << 32)), Long.valueOf(1956903695)};
            byte[] bArr16 = $$p;
            Object[] objArr82 = new Object[1];
            r((short) 326, (byte) (-bArr16[100]), (byte) (-bArr16[94]), objArr82);
            Class<?> cls11 = Class.forName((String) objArr82[0]);
            Object[] objArr83 = new Object[1];
            r((short) 104, (byte) (bArr16[180] + 1), (byte) (bArr16[258] - 1), objArr83);
            cls11.getMethod((String) objArr83[0], Long.TYPE, Long.TYPE).invoke(null, objArr81);
            Object[] objArr84 = {new int[]{i}, strArr, new int[1], new int[]{i}};
            int i133 = ((int[]) objArr4[2])[0];
            int i134 = ((int[]) objArr4[3])[0];
            int i135 = ((int[]) objArr4[0])[0];
            String[] strArr9 = (String[]) objArr4[1];
            int ringerMode = ((AudioManager) ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getSystemService("audio")).getRingerMode();
            int i136 = i133 + 778945231 + (((-311902241) | (~ringerMode)) * (-490)) + (((~(ringerMode | 222857115)) | (-534759356)) * 490) + 1207208444;
            int i137 = (i136 << 13) ^ i136;
            int i138 = i137 ^ (i137 >>> 17);
            ((int[]) objArr84[2])[0] = i138 ^ (i138 << 5);
        }
        Object objAccessartificialFrame33 = ArtificialStackFrames.accessartificialFrame(1745676544);
        if (objAccessartificialFrame33 == null) {
            int scrollDefaultDelay3 = 17 - (ViewConfiguration.getScrollDefaultDelay() >> 16);
            char maximumFlingVelocity2 = (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16);
            int iResolveOpacity = Drawable.resolveOpacity(0, 0) + 747;
            byte b14 = $$g[12];
            Object[] objArr85 = new Object[1];
            q((byte) 48, (byte) (b14 - 1), b14, objArr85);
            objAccessartificialFrame33 = ArtificialStackFrames.coroutineCreation(scrollDefaultDelay3, maximumFlingVelocity2, iResolveOpacity, -144068856, false, (String) objArr85[0], null);
        }
        long j8 = ((Field) objAccessartificialFrame33).getLong(null);
        try {
            if (j8 != -1) {
                if (j8 + 4611686018427387861L >= ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                    Object objAccessartificialFrame34 = ArtificialStackFrames.accessartificialFrame(1575402270);
                    if (objAccessartificialFrame34 == null) {
                        int iAlpha = 17 - Color.alpha(0);
                        char c6 = (char) (1 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)));
                        int deadChar4 = KeyEvent.getDeadChar(0, 0) + 747;
                        byte b15 = $$g[12];
                        Object[] objArr86 = new Object[1];
                        q((byte) 56, (byte) (b15 - 1), b15, objArr86);
                        objAccessartificialFrame34 = ArtificialStackFrames.coroutineCreation(iAlpha, c6, deadChar4, -1031537386, false, (String) objArr86[0], null);
                    }
                    Object[] objArr87 = (Object[]) ((Field) objAccessartificialFrame34).get(null);
                    objArr5 = new Object[]{list, new int[1], list, new int[]{i}, new int[]{i}};
                    int i139 = ((int[]) objArr87[3])[0];
                    int i140 = ((int[]) objArr87[4])[0];
                    List list = (List) objArr87[0];
                    List list2 = (List) objArr87[2];
                    int i141 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 356521564;
                    int i142 = ~(1052180427 | i141);
                    int i143 = 1106849589 + ((446697665 | i142) * (-476)) + (i142 * 952) + ((~((~i141) | 1052180427)) * 476) + 1950505940;
                    int i144 = (i143 << 13) ^ i143;
                    int i145 = i144 ^ (i144 >>> 17);
                    ((int[]) objArr5[1])[0] = i145 ^ (i145 << 5);
                } else {
                    i2 = 0;
                }
                i3 = ((int[]) objArr5[4])[0];
                i4 = ((int[]) objArr5[3])[0];
                if (i4 == i3) {
                    Object[] objArr88 = {list, new int[1], list, new int[]{i}, new int[]{i}};
                    int i146 = ((int[]) objArr5[1])[0];
                    int i147 = ((int[]) objArr5[3])[0];
                    int i148 = ((int[]) objArr5[4])[0];
                    List list3 = (List) objArr5[0];
                    List list4 = (List) objArr5[2];
                    int length = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 143879730;
                    int i149 = 1093836807 + ((length | 307608112) * (-50));
                    int i150 = ~((-272673297) | length);
                    int i151 = ~length;
                    int i152 = i146 + i149 + ((i150 | (~((-25167050) | i151))) * 50) + (((~(i151 | 307608112)) | (~((-297840346) | i151)) | 25167049) * 50);
                    int i153 = (i152 << 13) ^ i152;
                    int i154 = i153 ^ (i153 >>> 17);
                    ((int[]) objArr88[1])[0] = i154 ^ (i154 << 5);
                } else {
                    ArrayList arrayList4 = new ArrayList();
                    Object[] objArr89 = {objArr5};
                    objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(1804664566);
                    if (objAccessartificialFrame == null) {
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(Gravity.getAbsoluteGravity(0, 0) + 41, (char) (12468 - (ViewConfiguration.getScrollBarSize() >> 8)), (ViewConfiguration.getWindowTouchSlop() >> 8) + 3642, -185222914, false, "coroutineCreation", new Class[]{Object[].class});
                    }
                    arrayList4.add(((Method) objAccessartificialFrame).invoke(null, objArr89));
                    Object[] objArr90 = {objArr5};
                    objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1243809191);
                    if (objAccessartificialFrame2 == null) {
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(42 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), (char) ((ViewConfiguration.getKeyRepeatDelay() >> 16) + 12468), 3641 - ExpandableListView.getPackedPositionChild(0L), 716815441, false, "ArtificialStackFrames", new Class[]{Object[].class});
                    }
                    arrayList4.add(((Method) objAccessartificialFrame2).invoke(null, objArr90));
                    Object[] objArr91 = {Long.valueOf(((long) (i3 ^ i4)) ^ (((long) (-574910430)) << 32)), Long.valueOf(-574910422)};
                    short s4 = (short) ($$q | 290);
                    byte[] bArr17 = $$p;
                    Object[] objArr92 = new Object[1];
                    r(s4, bArr17[254], (byte) (-bArr17[94]), objArr92);
                    Class<?> cls12 = Class.forName((String) objArr92[0]);
                    Object[] objArr93 = new Object[1];
                    r((short) 104, (byte) (bArr17[180] + 1), (byte) (bArr17[258] - 1), objArr93);
                    cls12.getMethod((String) objArr93[0], Long.TYPE, Long.TYPE).invoke(null, objArr91);
                    Object[] objArr94 = {list, new int[1], list, new int[]{i}, new int[]{i}};
                    int i155 = ((int[]) objArr5[1])[0];
                    int i156 = ((int[]) objArr5[3])[0];
                    int i157 = ((int[]) objArr5[4])[0];
                    List list5 = (List) objArr5[0];
                    List list6 = (List) objArr5[2];
                    int i158 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getDisplayMetrics().densityDpi;
                    int i159 = ~i158;
                    int i160 = i155 + 2025899581 + ((i158 | (-67444802)) * 140) + (((~((-67444802) | i159)) | 65601) * (-280)) + (((~(i158 | (-65602))) | (~(672893259 | i159)) | (-740272460)) * 140);
                    int i161 = (i160 << 13) ^ i160;
                    int i162 = i161 ^ (i161 >>> 17);
                    ((int[]) objArr94[1])[0] = i162 ^ (i162 << 5);
                }
                objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                if (objAccessartificialFrame3 == null) {
                    int tapTimeout2 = (ViewConfiguration.getTapTimeout() >> 16) + 25;
                    char c7 = (char) (30069 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)));
                    int packedPositionGroup2 = 816 - ExpandableListView.getPackedPositionGroup(0L);
                    byte b16 = $$g[12];
                    Object[] objArr95 = new Object[1];
                    q((byte) 48, (byte) (b16 - 1), b16, objArr95);
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(tapTimeout2, c7, packedPositionGroup2, 721586079, false, (String) objArr95[0], null);
                }
                j = ((Field) objAccessartificialFrame3).getLong(null);
                if (j != -1 || j + 1868 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                    Object[] objArr96 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, -554713342};
                    objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1327366003);
                    if (objAccessartificialFrame4 == null) {
                        int i163 = 25 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                        char cIndexOf3 = (char) (30068 - TextUtils.indexOf("", "", 0));
                        int i164 = (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 816;
                        byte[] bArr18 = $$g;
                        Object[] objArr97 = new Object[1];
                        q((byte) (-bArr18[3]), (byte) 28, bArr18[50], objArr97);
                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(i163, cIndexOf3, i164, -797394565, false, (String) objArr97[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                    }
                    objArr6 = (Object[]) ((Method) objAccessartificialFrame4).invoke(null, objArr96);
                    objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                    if (objAccessartificialFrame5 == null) {
                        int pressedStateDuration = 25 - (ViewConfiguration.getPressedStateDuration() >> 16);
                        char cIndexOf4 = (char) (TextUtils.indexOf((CharSequence) "", '0', 0) + 30069);
                        int iIndexOf6 = TextUtils.indexOf((CharSequence) "", '0', 0) + 817;
                        byte b17 = $$g[12];
                        Object[] objArr98 = new Object[1];
                        q((byte) 56, (byte) (b17 - 1), b17, objArr98);
                        objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(pressedStateDuration, cIndexOf4, iIndexOf6, 891606461, false, (String) objArr98[0], null);
                    }
                    ((Field) objAccessartificialFrame5).set(null, objArr6);
                    try {
                        Long lValueOf6 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                        if (objAccessartificialFrame6 == null) {
                            int offsetBefore = TextUtils.getOffsetBefore("", 0) + 25;
                            char cKeyCodeFromString2 = (char) (30068 - KeyEvent.keyCodeFromString(""));
                            int capsMode2 = TextUtils.getCapsMode("", 0, 0) + 816;
                            byte b18 = $$g[12];
                            Object[] objArr99 = new Object[1];
                            q((byte) 48, (byte) (b18 - 1), b18, objArr99);
                            objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(offsetBefore, cKeyCodeFromString2, capsMode2, 721586079, false, (String) objArr99[0], null);
                        }
                        ((Field) objAccessartificialFrame6).set(null, lValueOf6);
                    } catch (Exception unused6) {
                        throw new RuntimeException();
                    }
                } else {
                    Object objAccessartificialFrame35 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                    if (objAccessartificialFrame35 == null) {
                        int iIndexOf7 = 25 - TextUtils.indexOf("", "", 0, 0);
                        char cIndexOf5 = (char) (TextUtils.indexOf((CharSequence) "", '0') + 30069);
                        int iRgb4 = Color.rgb(0, 0, 0) + 16778032;
                        byte b19 = $$g[12];
                        Object[] objArr100 = new Object[1];
                        q((byte) 56, (byte) (b19 - 1), b19, objArr100);
                        objAccessartificialFrame35 = ArtificialStackFrames.coroutineCreation(iIndexOf7, cIndexOf5, iRgb4, 891606461, false, (String) objArr100[0], null);
                    }
                    Object[] objArr101 = (Object[]) ((Field) objAccessartificialFrame35).get(null);
                    objArr6 = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
                    int i165 = ((int[]) objArr101[0])[0];
                    int i166 = ((int[]) objArr101[1])[0];
                    String[] strArr10 = (String[]) objArr101[2];
                    int iIdentityHashCode6 = System.identityHashCode(this);
                    int i167 = (-1303517416) + (((~((~iIdentityHashCode6) | 815563385)) | (-1023206272)) * (-245));
                    int i168 = ~(iIdentityHashCode6 | 815563385);
                    int i169 = ((i167 + (i168 * (-245))) + ((i168 | 1013735751) * 245)) - 554713342;
                    int i170 = (i169 << 13) ^ i169;
                    int i171 = i170 ^ (i170 >>> 17);
                    ((int[]) objArr6[3])[0] = i171 ^ (i171 << 5);
                }
                i5 = ((int[]) objArr6[1])[0];
                i6 = ((int[]) objArr6[0])[0];
                if (i6 == i5) {
                    Object[] objArr102 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
                    int i172 = ((int[]) objArr6[3])[0];
                    int i173 = ((int[]) objArr6[0])[0];
                    int i174 = ((int[]) objArr6[1])[0];
                    String[] strArr11 = (String[]) objArr6[2];
                    int length2 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 1130814250;
                    int i175 = i172 + (((829468108 + (((-595595522) | length2) * (-381))) + (((~((~length2) | (-599003908))) | 204989138) * 381)) - 711373187);
                    int i176 = (i175 << 13) ^ i175;
                    int i177 = i176 ^ (i176 >>> 17);
                    ((int[]) objArr102[3])[0] = i177 ^ (i177 << 5);
                } else {
                    arrayList = new ArrayList();
                    strArr = (String[]) objArr6[2];
                    if (strArr != null) {
                        for (String str8 : strArr) {
                            arrayList.add(str8);
                        }
                    }
                    Object[] objArr103 = {Long.valueOf(((long) (i5 ^ i6)) ^ (((long) 568610759) << 32)), Long.valueOf(568610758)};
                    short s5 = (short) ($$q | 353);
                    byte[] bArr19 = $$p;
                    Object[] objArr104 = new Object[1];
                    r(s5, (byte) (-bArr19[100]), (byte) (-bArr19[94]), objArr104);
                    Class<?> cls13 = Class.forName((String) objArr104[0]);
                    Object[] objArr105 = new Object[1];
                    r((short) 104, (byte) (bArr19[180] + 1), (byte) (bArr19[258] - 1), objArr105);
                    cls13.getMethod((String) objArr105[0], Long.TYPE, Long.TYPE).invoke(null, objArr103);
                    Object[] objArr106 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
                    int i178 = ((int[]) objArr6[3])[0];
                    int i179 = ((int[]) objArr6[0])[0];
                    int i180 = ((int[]) objArr6[1])[0];
                    String[] strArr12 = (String[]) objArr6[2];
                    int iElapsedRealtime = (int) SystemClock.elapsedRealtime();
                    int i181 = i178 + (-1148354397) + (((~iElapsedRealtime) | 342945750) * 1444) + (((~(iElapsedRealtime | (-610244742))) | (~(808417107 | iElapsedRealtime)) | 72386692) * (-1444)) + 1501270946;
                    int i182 = (i181 << 13) ^ i181;
                    int i183 = i182 ^ (i182 >>> 17);
                    ((int[]) objArr106[3])[0] = i183 ^ (i183 << 5);
                }
                super.onStart();
                objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(1056123296);
                if (objAccessartificialFrame7 == null) {
                    int i184 = 31 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1));
                    char fadingEdgeLength = (char) (49362 - (ViewConfiguration.getFadingEdgeLength() >> 16));
                    int scrollBarSize = (ViewConfiguration.getScrollBarSize() >> 8) + 684;
                    byte[] bArr20 = $$g;
                    Object[] objArr107 = new Object[1];
                    q((byte) 95, bArr20[4], (byte) (-bArr20[17]), objArr107);
                    objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(i184, fadingEdgeLength, scrollBarSize, -1583976536, false, (String) objArr107[0], null);
                }
                j2 = ((Field) objAccessartificialFrame7).getLong(null);
                if (j2 != -1 || j2 + 1937 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                    Object[] objArr108 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), -370187485};
                    byte[] bArr21 = $$p;
                    Object[] objArr109 = new Object[1];
                    r((short) 519, bArr21[73], (byte) (-bArr21[94]), objArr109);
                    Class<?> cls14 = Class.forName((String) objArr109[0]);
                    Object[] objArr110 = new Object[1];
                    r((short) 566, bArr21[0], (byte) (-bArr21[94]), objArr110);
                    objArr7 = (Object[]) cls14.getMethod((String) objArr110[0], Integer.TYPE, Integer.TYPE).invoke(null, objArr108);
                    objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(910856866);
                    if (objAccessartificialFrame8 == null) {
                        int iResolveOpacity2 = Drawable.resolveOpacity(0, 0) + 30;
                        char c8 = (char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 49361);
                        int i185 = 685 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                        byte[] bArr22 = $$g;
                        Object[] objArr111 = new Object[1];
                        q((byte) 107, bArr22[18], bArr22[12], objArr111);
                        objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(iResolveOpacity2, c8, i185, -1456483158, false, (String) objArr111[0], null);
                    }
                    ((Field) objAccessartificialFrame8).set(null, objArr7);
                    try {
                        Long lValueOf7 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(1056123296);
                        if (objAccessartificialFrame9 == null) {
                            int iMyTid2 = 30 - (Process.myTid() >> 22);
                            char modifierMetaStateMask4 = (char) (49361 - ((byte) KeyEvent.getModifierMetaStateMask()));
                            int iRgb5 = Color.rgb(0, 0, 0) + 16777900;
                            byte[] bArr23 = $$g;
                            Object[] objArr112 = new Object[1];
                            q((byte) 95, bArr23[4], (byte) (-bArr23[17]), objArr112);
                            objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(iMyTid2, modifierMetaStateMask4, iRgb5, -1583976536, false, (String) objArr112[0], null);
                        }
                        ((Field) objAccessartificialFrame9).set(null, lValueOf7);
                    } catch (Exception unused7) {
                        throw new RuntimeException();
                    }
                } else {
                    Object objAccessartificialFrame36 = ArtificialStackFrames.accessartificialFrame(910856866);
                    if (objAccessartificialFrame36 == null) {
                        int iIndexOf8 = TextUtils.indexOf("", "", 0) + 30;
                        char doubleTapTimeout = (char) ((ViewConfiguration.getDoubleTapTimeout() >> 16) + 49362);
                        int keyRepeatTimeout = 684 - (ViewConfiguration.getKeyRepeatTimeout() >> 16);
                        byte[] bArr24 = $$g;
                        Object[] objArr113 = new Object[1];
                        q((byte) 107, bArr24[18], bArr24[12], objArr113);
                        objAccessartificialFrame36 = ArtificialStackFrames.coroutineCreation(iIndexOf8, doubleTapTimeout, keyRepeatTimeout, -1456483158, false, (String) objArr113[0], null);
                    }
                    Object[] objArr114 = (Object[]) ((Field) objAccessartificialFrame36).get(null);
                    objArr7 = new Object[]{new int[]{((int[]) objArr114[0])[0]}, new int[]{((int[]) objArr114[1])[0]}, new int[1], (String) objArr114[3]};
                    int i186 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 565461192;
                    int i187 = 1801150414 + ((~(i186 | 1008202688)) * JfifUtil.MARKER_SOI);
                    int i188 = ~i186;
                    int i189 = ((i187 + ((1037563873 | i188) * (-216))) + (((~(i188 | 1008202688)) | (-29578914)) * JfifUtil.MARKER_SOI)) - 370187485;
                    int i190 = (i189 << 13) ^ i189;
                    int i191 = i190 ^ (i190 >>> 17);
                    ((int[]) objArr7[2])[0] = i191 ^ (i191 << 5);
                }
                i8 = ((int[]) objArr7[1])[0];
                i9 = ((int[]) objArr7[0])[0];
                if (i9 == i8) {
                    int i192 = ((int[]) objArr7[2])[0];
                    Object[] objArr115 = {new int[]{((int[]) objArr7[0])[0]}, new int[]{((int[]) objArr7[1])[0]}, new int[1], (String) objArr7[3]};
                    int iCodePointAt2 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(20) + 632347556;
                    int i193 = ~((-929496601) | iCodePointAt2);
                    int i194 = ~iCodePointAt2;
                    int i195 = i192 + (-2031332178) + ((i193 | (~(49127174 | i194))) * (-1808)) + (((~((-40148481) | iCodePointAt2)) | (~(i194 | 938475294))) * TypedValues.Custom.TYPE_BOOLEAN) + (((~(iCodePointAt2 | (-49127175))) | 889348120 | (~(929496600 | i194))) * TypedValues.Custom.TYPE_BOOLEAN);
                    int i196 = (i195 << 13) ^ i195;
                    int i197 = i196 ^ (i196 >>> 17);
                    ((int[]) objArr115[2])[0] = i197 ^ (i197 << 5);
                    return;
                }
                new ArrayList().add((String) objArr7[3]);
                Object[] objArr116 = {Long.valueOf(((long) (i8 ^ i9)) ^ (((long) (-88967474)) << 32)), Long.valueOf(-88967458)};
                short s6 = (short) ($$q | 69);
                byte[] bArr25 = $$p;
                Object[] objArr117 = new Object[1];
                r(s6, bArr25[634], (byte) (-bArr25[94]), objArr117);
                Class<?> cls15 = Class.forName((String) objArr117[0]);
                Object[] objArr118 = new Object[1];
                r((short) 104, (byte) (bArr25[180] + 1), (byte) (bArr25[258] - 1), objArr118);
                cls15.getMethod((String) objArr118[0], Long.TYPE, Long.TYPE).invoke(null, objArr116);
                int i198 = ((int[]) objArr7[2])[0];
                Object[] objArr119 = {new int[]{((int[]) objArr7[0])[0]}, new int[]{((int[]) objArr7[1])[0]}, new int[1], (String) objArr7[3]};
                int i199 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().orientation;
                int i200 = ~i199;
                int i201 = ~((-888011851) | i200);
                int i202 = ~((-90611925) | i199);
                int i203 = i198 + 910669500 + ((i201 | i202) * 1150) + (((~(90611924 | i200)) | i202) * (-575)) + (((~(i199 | (-888011851))) | (~(i200 | 888011850))) * 575);
                int i204 = (i203 << 13) ^ i203;
                int i205 = i204 ^ (i204 >>> 17);
                ((int[]) objArr119[2])[0] = i205 ^ (i205 << 5);
                return;
            }
            i2 = 0;
            Long lValueOf8 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
            Object objAccessartificialFrame37 = ArtificialStackFrames.accessartificialFrame(1745676544);
            if (objAccessartificialFrame37 == null) {
                int maximumDrawingCacheSize2 = 17 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                char cResolveSize = (char) View.resolveSize(0, 0);
                int fadingEdgeLength2 = (ViewConfiguration.getFadingEdgeLength() >> 16) + 747;
                byte b20 = $$g[12];
                Object[] objArr120 = new Object[1];
                q((byte) 48, (byte) (b20 - 1), b20, objArr120);
                objAccessartificialFrame37 = ArtificialStackFrames.coroutineCreation(maximumDrawingCacheSize2, cResolveSize, fadingEdgeLength2, -144068856, false, (String) objArr120[0], null);
            }
            ((Field) objAccessartificialFrame37).set(null, lValueOf8);
            i3 = ((int[]) objArr5[4])[0];
            i4 = ((int[]) objArr5[3])[0];
            if (i4 == i3) {
                Object[] objArr810 = {list3, new int[1], list4, new int[]{i147}, new int[]{i148}};
                int i1410 = ((int[]) objArr5[1])[0];
                int i1411 = ((int[]) objArr5[3])[0];
                int i1412 = ((int[]) objArr5[4])[0];
                List list7 = (List) objArr5[0];
                List list8 = (List) objArr5[2];
                int length3 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 143879730;
                int i1413 = 1093836807 + ((length3 | 307608112) * (-50));
                int i1510 = ~((-272673297) | length3);
                int i1511 = ~length3;
                int i1512 = i1410 + i1413 + ((i1510 | (~((-25167050) | i1511))) * 50) + (((~(i1511 | 307608112)) | (~((-297840346) | i1511)) | 25167049) * 50);
                int i1513 = (i1512 << 13) ^ i1512;
                int i1514 = i1513 ^ (i1513 >>> 17);
                ((int[]) objArr810[1])[0] = i1514 ^ (i1514 << 5);
            } else {
                ArrayList arrayList5 = new ArrayList();
                Object[] objArr811 = {objArr5};
                objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(1804664566);
                if (objAccessartificialFrame == null) {
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(Gravity.getAbsoluteGravity(0, 0) + 41, (char) (12468 - (ViewConfiguration.getScrollBarSize() >> 8)), (ViewConfiguration.getWindowTouchSlop() >> 8) + 3642, -185222914, false, "coroutineCreation", new Class[]{Object[].class});
                }
                arrayList5.add(((Method) objAccessartificialFrame).invoke(null, objArr811));
                Object[] objArr910 = {objArr5};
                objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1243809191);
                if (objAccessartificialFrame2 == null) {
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(42 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), (char) ((ViewConfiguration.getKeyRepeatDelay() >> 16) + 12468), 3641 - ExpandableListView.getPackedPositionChild(0L), 716815441, false, "ArtificialStackFrames", new Class[]{Object[].class});
                }
                arrayList5.add(((Method) objAccessartificialFrame2).invoke(null, objArr910));
                Object[] objArr911 = {Long.valueOf(((long) (i3 ^ i4)) ^ (((long) (-574910430)) << 32)), Long.valueOf(-574910422)};
                short s7 = (short) ($$q | 290);
                byte[] bArr110 = $$p;
                Object[] objArr912 = new Object[1];
                r(s7, bArr110[254], (byte) (-bArr110[94]), objArr912);
                Class<?> cls16 = Class.forName((String) objArr912[0]);
                Object[] objArr913 = new Object[1];
                r((short) 104, (byte) (bArr110[180] + 1), (byte) (bArr110[258] - 1), objArr913);
                cls16.getMethod((String) objArr913[0], Long.TYPE, Long.TYPE).invoke(null, objArr911);
                Object[] objArr914 = {list5, new int[1], list6, new int[]{i156}, new int[]{i157}};
                int i1515 = ((int[]) objArr5[1])[0];
                int i1516 = ((int[]) objArr5[3])[0];
                int i1517 = ((int[]) objArr5[4])[0];
                List list9 = (List) objArr5[0];
                List list10 = (List) objArr5[2];
                int i1518 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getDisplayMetrics().densityDpi;
                int i1519 = ~i1518;
                int i1610 = i1515 + 2025899581 + ((i1518 | (-67444802)) * 140) + (((~((-67444802) | i1519)) | 65601) * (-280)) + (((~(i1518 | (-65602))) | (~(672893259 | i1519)) | (-740272460)) * 140);
                int i1611 = (i1610 << 13) ^ i1610;
                int i1612 = i1611 ^ (i1611 >>> 17);
                ((int[]) objArr914[1])[0] = i1612 ^ (i1612 << 5);
            }
            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1268268649);
            if (objAccessartificialFrame3 == null) {
                int tapTimeout3 = (ViewConfiguration.getTapTimeout() >> 16) + 25;
                char c9 = (char) (30069 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)));
                int packedPositionGroup3 = 816 - ExpandableListView.getPackedPositionGroup(0L);
                byte b110 = $$g[12];
                Object[] objArr915 = new Object[1];
                q((byte) 48, (byte) (b110 - 1), b110, objArr915);
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(tapTimeout3, c9, packedPositionGroup3, 721586079, false, (String) objArr915[0], null);
            }
            j = ((Field) objAccessartificialFrame3).getLong(null);
            if (j != -1) {
                Object[] objArr916 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, -554713342};
                objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1327366003);
                if (objAccessartificialFrame4 == null) {
                    int i1613 = 25 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                    char cIndexOf6 = (char) (30068 - TextUtils.indexOf("", "", 0));
                    int i1614 = (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 816;
                    byte[] bArr111 = $$g;
                    Object[] objArr917 = new Object[1];
                    q((byte) (-bArr111[3]), (byte) 28, bArr111[50], objArr917);
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(i1613, cIndexOf6, i1614, -797394565, false, (String) objArr917[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                }
                objArr6 = (Object[]) ((Method) objAccessartificialFrame4).invoke(null, objArr916);
                objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame5 == null) {
                    int pressedStateDuration2 = 25 - (ViewConfiguration.getPressedStateDuration() >> 16);
                    char cIndexOf7 = (char) (TextUtils.indexOf((CharSequence) "", '0', 0) + 30069);
                    int iIndexOf9 = TextUtils.indexOf((CharSequence) "", '0', 0) + 817;
                    byte b111 = $$g[12];
                    Object[] objArr918 = new Object[1];
                    q((byte) 56, (byte) (b111 - 1), b111, objArr918);
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(pressedStateDuration2, cIndexOf7, iIndexOf9, 891606461, false, (String) objArr918[0], null);
                }
                ((Field) objAccessartificialFrame5).set(null, objArr6);
                Long lValueOf9 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                if (objAccessartificialFrame6 == null) {
                    int offsetBefore2 = TextUtils.getOffsetBefore("", 0) + 25;
                    char cKeyCodeFromString3 = (char) (30068 - KeyEvent.keyCodeFromString(""));
                    int capsMode3 = TextUtils.getCapsMode("", 0, 0) + 816;
                    byte b112 = $$g[12];
                    Object[] objArr919 = new Object[1];
                    q((byte) 48, (byte) (b112 - 1), b112, objArr919);
                    objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(offsetBefore2, cKeyCodeFromString3, capsMode3, 721586079, false, (String) objArr919[0], null);
                }
                ((Field) objAccessartificialFrame6).set(null, lValueOf9);
            } else {
                Object[] objArr9110 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, -554713342};
                objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1327366003);
                if (objAccessartificialFrame4 == null) {
                    int i1615 = 25 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                    char cIndexOf8 = (char) (30068 - TextUtils.indexOf("", "", 0));
                    int i1616 = (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 816;
                    byte[] bArr112 = $$g;
                    Object[] objArr9111 = new Object[1];
                    q((byte) (-bArr112[3]), (byte) 28, bArr112[50], objArr9111);
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(i1615, cIndexOf8, i1616, -797394565, false, (String) objArr9111[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                }
                objArr6 = (Object[]) ((Method) objAccessartificialFrame4).invoke(null, objArr9110);
                objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame5 == null) {
                    int pressedStateDuration3 = 25 - (ViewConfiguration.getPressedStateDuration() >> 16);
                    char cIndexOf9 = (char) (TextUtils.indexOf((CharSequence) "", '0', 0) + 30069);
                    int iIndexOf10 = TextUtils.indexOf((CharSequence) "", '0', 0) + 817;
                    byte b113 = $$g[12];
                    Object[] objArr9112 = new Object[1];
                    q((byte) 56, (byte) (b113 - 1), b113, objArr9112);
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(pressedStateDuration3, cIndexOf9, iIndexOf10, 891606461, false, (String) objArr9112[0], null);
                }
                ((Field) objAccessartificialFrame5).set(null, objArr6);
                Long lValueOf10 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                if (objAccessartificialFrame6 == null) {
                    int offsetBefore3 = TextUtils.getOffsetBefore("", 0) + 25;
                    char cKeyCodeFromString4 = (char) (30068 - KeyEvent.keyCodeFromString(""));
                    int capsMode4 = TextUtils.getCapsMode("", 0, 0) + 816;
                    byte b114 = $$g[12];
                    Object[] objArr9113 = new Object[1];
                    q((byte) 48, (byte) (b114 - 1), b114, objArr9113);
                    objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(offsetBefore3, cKeyCodeFromString4, capsMode4, 721586079, false, (String) objArr9113[0], null);
                }
                ((Field) objAccessartificialFrame6).set(null, lValueOf10);
            }
            i5 = ((int[]) objArr6[1])[0];
            i6 = ((int[]) objArr6[0])[0];
            if (i6 == i5) {
                Object[] objArr1010 = {new int[]{i173}, new int[]{i174}, strArr11, new int[1]};
                int i1710 = ((int[]) objArr6[3])[0];
                int i1711 = ((int[]) objArr6[0])[0];
                int i1712 = ((int[]) objArr6[1])[0];
                String[] strArr13 = (String[]) objArr6[2];
                int length4 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 1130814250;
                int i1713 = i1710 + (((829468108 + (((-595595522) | length4) * (-381))) + (((~((~length4) | (-599003908))) | 204989138) * 381)) - 711373187);
                int i1714 = (i1713 << 13) ^ i1713;
                int i1715 = i1714 ^ (i1714 >>> 17);
                ((int[]) objArr1010[3])[0] = i1715 ^ (i1715 << 5);
            } else {
                arrayList = new ArrayList();
                strArr = (String[]) objArr6[2];
                if (strArr != null) {
                    while (i7 < strArr.length) {
                        arrayList.add(str8);
                    }
                }
                Object[] objArr1011 = {Long.valueOf(((long) (i5 ^ i6)) ^ (((long) 568610759) << 32)), Long.valueOf(568610758)};
                short s8 = (short) ($$q | 353);
                byte[] bArr113 = $$p;
                Object[] objArr1012 = new Object[1];
                r(s8, (byte) (-bArr113[100]), (byte) (-bArr113[94]), objArr1012);
                Class<?> cls17 = Class.forName((String) objArr1012[0]);
                Object[] objArr1013 = new Object[1];
                r((short) 104, (byte) (bArr113[180] + 1), (byte) (bArr113[258] - 1), objArr1013);
                cls17.getMethod((String) objArr1013[0], Long.TYPE, Long.TYPE).invoke(null, objArr1011);
                Object[] objArr1014 = {new int[]{i179}, new int[]{i180}, strArr12, new int[1]};
                int i1716 = ((int[]) objArr6[3])[0];
                int i1717 = ((int[]) objArr6[0])[0];
                int i1810 = ((int[]) objArr6[1])[0];
                String[] strArr14 = (String[]) objArr6[2];
                int iElapsedRealtime2 = (int) SystemClock.elapsedRealtime();
                int i1811 = i1716 + (-1148354397) + (((~iElapsedRealtime2) | 342945750) * 1444) + (((~(iElapsedRealtime2 | (-610244742))) | (~(808417107 | iElapsedRealtime2)) | 72386692) * (-1444)) + 1501270946;
                int i1812 = (i1811 << 13) ^ i1811;
                int i1813 = i1812 ^ (i1812 >>> 17);
                ((int[]) objArr1014[3])[0] = i1813 ^ (i1813 << 5);
            }
            super.onStart();
            objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(1056123296);
            if (objAccessartificialFrame7 == null) {
                int i1814 = 31 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1));
                char fadingEdgeLength3 = (char) (49362 - (ViewConfiguration.getFadingEdgeLength() >> 16));
                int scrollBarSize2 = (ViewConfiguration.getScrollBarSize() >> 8) + 684;
                byte[] bArr26 = $$g;
                Object[] objArr1015 = new Object[1];
                q((byte) 95, bArr26[4], (byte) (-bArr26[17]), objArr1015);
                objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(i1814, fadingEdgeLength3, scrollBarSize2, -1583976536, false, (String) objArr1015[0], null);
            }
            j2 = ((Field) objAccessartificialFrame7).getLong(null);
            if (j2 != -1) {
                Object[] objArr1016 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), -370187485};
                byte[] bArr27 = $$p;
                Object[] objArr1017 = new Object[1];
                r((short) 519, bArr27[73], (byte) (-bArr27[94]), objArr1017);
                Class<?> cls18 = Class.forName((String) objArr1017[0]);
                Object[] objArr1110 = new Object[1];
                r((short) 566, bArr27[0], (byte) (-bArr27[94]), objArr1110);
                objArr7 = (Object[]) cls18.getMethod((String) objArr1110[0], Integer.TYPE, Integer.TYPE).invoke(null, objArr1016);
                objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(910856866);
                if (objAccessartificialFrame8 == null) {
                    int iResolveOpacity3 = Drawable.resolveOpacity(0, 0) + 30;
                    char c10 = (char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 49361);
                    int i1815 = 685 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                    byte[] bArr28 = $$g;
                    Object[] objArr1111 = new Object[1];
                    q((byte) 107, bArr28[18], bArr28[12], objArr1111);
                    objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(iResolveOpacity3, c10, i1815, -1456483158, false, (String) objArr1111[0], null);
                }
                ((Field) objAccessartificialFrame8).set(null, objArr7);
                Long lValueOf11 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(1056123296);
                if (objAccessartificialFrame9 == null) {
                    int iMyTid3 = 30 - (Process.myTid() >> 22);
                    char modifierMetaStateMask5 = (char) (49361 - ((byte) KeyEvent.getModifierMetaStateMask()));
                    int iRgb6 = Color.rgb(0, 0, 0) + 16777900;
                    byte[] bArr29 = $$g;
                    Object[] objArr1112 = new Object[1];
                    q((byte) 95, bArr29[4], (byte) (-bArr29[17]), objArr1112);
                    objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(iMyTid3, modifierMetaStateMask5, iRgb6, -1583976536, false, (String) objArr1112[0], null);
                }
                ((Field) objAccessartificialFrame9).set(null, lValueOf11);
            } else {
                Object[] objArr1018 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), -370187485};
                byte[] bArr210 = $$p;
                Object[] objArr1019 = new Object[1];
                r((short) 519, bArr210[73], (byte) (-bArr210[94]), objArr1019);
                Class<?> cls19 = Class.forName((String) objArr1019[0]);
                Object[] objArr1113 = new Object[1];
                r((short) 566, bArr210[0], (byte) (-bArr210[94]), objArr1113);
                objArr7 = (Object[]) cls19.getMethod((String) objArr1113[0], Integer.TYPE, Integer.TYPE).invoke(null, objArr1018);
                objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(910856866);
                if (objAccessartificialFrame8 == null) {
                    int iResolveOpacity4 = Drawable.resolveOpacity(0, 0) + 30;
                    char c11 = (char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 49361);
                    int i1816 = 685 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                    byte[] bArr211 = $$g;
                    Object[] objArr1114 = new Object[1];
                    q((byte) 107, bArr211[18], bArr211[12], objArr1114);
                    objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(iResolveOpacity4, c11, i1816, -1456483158, false, (String) objArr1114[0], null);
                }
                ((Field) objAccessartificialFrame8).set(null, objArr7);
                Long lValueOf12 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(1056123296);
                if (objAccessartificialFrame9 == null) {
                    int iMyTid4 = 30 - (Process.myTid() >> 22);
                    char modifierMetaStateMask6 = (char) (49361 - ((byte) KeyEvent.getModifierMetaStateMask()));
                    int iRgb7 = Color.rgb(0, 0, 0) + 16777900;
                    byte[] bArr212 = $$g;
                    Object[] objArr1115 = new Object[1];
                    q((byte) 95, bArr212[4], (byte) (-bArr212[17]), objArr1115);
                    objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(iMyTid4, modifierMetaStateMask6, iRgb7, -1583976536, false, (String) objArr1115[0], null);
                }
                ((Field) objAccessartificialFrame9).set(null, lValueOf12);
            }
            i8 = ((int[]) objArr7[1])[0];
            i9 = ((int[]) objArr7[0])[0];
            if (i9 == i8) {
                int i1910 = ((int[]) objArr7[2])[0];
                Object[] objArr1116 = {new int[]{((int[]) objArr7[0])[0]}, new int[]{((int[]) objArr7[1])[0]}, new int[1], (String) objArr7[3]};
                int iCodePointAt3 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(20) + 632347556;
                int i1911 = ~((-929496601) | iCodePointAt3);
                int i1912 = ~iCodePointAt3;
                int i1913 = i1910 + (-2031332178) + ((i1911 | (~(49127174 | i1912))) * (-1808)) + (((~((-40148481) | iCodePointAt3)) | (~(i1912 | 938475294))) * TypedValues.Custom.TYPE_BOOLEAN) + (((~(iCodePointAt3 | (-49127175))) | 889348120 | (~(929496600 | i1912))) * TypedValues.Custom.TYPE_BOOLEAN);
                int i1914 = (i1913 << 13) ^ i1913;
                int i1915 = i1914 ^ (i1914 >>> 17);
                ((int[]) objArr1116[2])[0] = i1915 ^ (i1915 << 5);
                return;
            }
            new ArrayList().add((String) objArr7[3]);
            Object[] objArr1117 = {Long.valueOf(((long) (i8 ^ i9)) ^ (((long) (-88967474)) << 32)), Long.valueOf(-88967458)};
            short s9 = (short) ($$q | 69);
            byte[] bArr213 = $$p;
            Object[] objArr1118 = new Object[1];
            r(s9, bArr213[634], (byte) (-bArr213[94]), objArr1118);
            Class<?> cls110 = Class.forName((String) objArr1118[0]);
            Object[] objArr1119 = new Object[1];
            r((short) 104, (byte) (bArr213[180] + 1), (byte) (bArr213[258] - 1), objArr1119);
            cls110.getMethod((String) objArr1119[0], Long.TYPE, Long.TYPE).invoke(null, objArr1117);
            int i1916 = ((int[]) objArr7[2])[0];
            Object[] objArr1120 = {new int[]{((int[]) objArr7[0])[0]}, new int[]{((int[]) objArr7[1])[0]}, new int[1], (String) objArr7[3]};
            int i1917 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().orientation;
            int i206 = ~i1917;
            int i207 = ~((-888011851) | i206);
            int i208 = ~((-90611925) | i1917);
            int i209 = i1916 + 910669500 + ((i207 | i208) * 1150) + (((~(90611924 | i206)) | i208) * (-575)) + (((~(i1917 | (-888011851))) | (~(i206 | 888011850))) * 575);
            int i2010 = (i209 << 13) ^ i209;
            int i2011 = i2010 ^ (i2010 >>> 17);
            ((int[]) objArr1120[2])[0] = i2011 ^ (i2011 << 5);
            return;
        } catch (Exception unused8) {
            throw new RuntimeException();
        }
        Context baseContext4 = getBaseContext();
        if (baseContext4 == null) {
            Object[] objArr121 = new Object[1];
            p((-16777190) - Color.rgb(i2, i2, i2), new char[]{52923, 36312, 44758, 57090, 34074, 44439, 19769, 13899, 41576, 14867, 51088, 7574, 204, 37262, 64863, 47606, 17850, 63805, 25078, 47908, 20970, 8695, 28192, 45786, 40826, 941}, objArr121);
            Class<?> cls20 = Class.forName((String) objArr121[i2]);
            Object[] objArr122 = new Object[1];
            p(18 - View.MeasureSpec.getMode(i2), new char[]{58956, 56488, 21411, 20483, 26912, 32316, 29820, 14604, 18908, 28681, 30210, 25064, 55400, 21233, 64863, 47606, 58441, 7650}, objArr122);
            baseContext4 = (Context) cls20.getMethod((String) objArr122[i2], new Class[i2]).invoke(null, null);
        }
        if (baseContext4 != null) {
            baseContext4 = ((baseContext4 instanceof ContextWrapper) && ((ContextWrapper) baseContext4).getBaseContext() == null) ? null : baseContext4.getApplicationContext();
        }
        Object[] objArr123 = {baseContext4, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 1950505940};
        byte[] bArr30 = $$p;
        Object[] objArr124 = new Object[1];
        r((short) 364, bArr30[249], (byte) (-bArr30[94]), objArr124);
        Class<?> cls21 = Class.forName((String) objArr124[0]);
        Object[] objArr125 = new Object[1];
        r(bArr30[120], bArr30[542], (byte) 44, objArr125);
        objArr5 = (Object[]) cls21.getMethod((String) objArr125[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr123);
        Object objAccessartificialFrame38 = ArtificialStackFrames.accessartificialFrame(1575402270);
        if (objAccessartificialFrame38 == null) {
            int iGreen = Color.green(0) + 17;
            char cIndexOf10 = (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0, 0));
            int pressedStateDuration4 = 747 - (ViewConfiguration.getPressedStateDuration() >> 16);
            byte b21 = $$g[12];
            Object[] objArr126 = new Object[1];
            q((byte) 56, (byte) (b21 - 1), b21, objArr126);
            objAccessartificialFrame38 = ArtificialStackFrames.coroutineCreation(iGreen, cIndexOf10, pressedStateDuration4, -1031537386, false, (String) objArr126[0], null);
        }
        ((Field) objAccessartificialFrame38).set(null, objArr5);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0178  */
    /* JADX WARN: Code duplicated, block: B:16:0x01f4 A[Catch: all -> 0x09ad, TryCatch #2 {all -> 0x09ad, blocks: (B:54:0x06bc, B:56:0x06dd, B:57:0x0729, B:14:0x01e0, B:16:0x01f4, B:17:0x0224), top: B:98:0x01e0 }] */
    /* JADX WARN: Code duplicated, block: B:20:0x023a  */
    /* JADX WARN: Code duplicated, block: B:25:0x0307  */
    /* JADX WARN: Code duplicated, block: B:53:0x064c  */
    /* JADX WARN: Code duplicated, block: B:56:0x06dd A[Catch: all -> 0x09ad, TryCatch #2 {all -> 0x09ad, blocks: (B:54:0x06bc, B:56:0x06dd, B:57:0x0729, B:14:0x01e0, B:16:0x01f4, B:17:0x0224), top: B:98:0x01e0 }] */
    /* JADX WARN: Code duplicated, block: B:60:0x073b  */
    /* JADX WARN: Code duplicated, block: B:65:0x07f5  */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
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
            int mirror = 'J' - AndroidCharacter.getMirror('0');
            char cKeyCodeFromString = (char) KeyEvent.keyCodeFromString("");
            int iMakeMeasureSpec = 1041 - View.MeasureSpec.makeMeasureSpec(0, 0);
            byte b2 = $$g[12];
            Object[] objArr2 = new Object[1];
            q((byte) 48, (byte) (b2 - 1), b2, objArr2);
            objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(mirror, cKeyCodeFromString, iMakeMeasureSpec, 2061780482, false, (String) objArr2[0], null);
        }
        long j = ((Field) objAccessartificialFrame7).getLong(null);
        if (j != -1) {
            long j2 = j + 4611686018427387793L;
            Object[] objArr3 = new Object[1];
            p(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(11) - 83, new char[]{52923, 36312, 44758, 57090, 34074, 44439, 19769, 13899, 20303, 56091, 63382, 36508, 34330, 52027, 15888, 12864, 47849, 44368, 3364, 48424, 65199, 42601}, objArr3);
            Class<?> cls = Class.forName((String) objArr3[0]);
            Object[] objArr4 = new Object[1];
            p(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 20, new char[]{48031, 43365, 41576, 14867, 37115, 45563, 22328, 4831, 37063, 11749, 32806, 14496, 43628, 18378, 18183, 5032}, objArr4);
            if (j2 >= ((Long) cls.getDeclaredMethod((String) objArr4[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame8 == null) {
                    int iResolveSize = View.resolveSize(0, 0) + 26;
                    char maximumFlingVelocity = (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16);
                    int maxKeyCode = (KeyEvent.getMaxKeyCode() >> 16) + 1041;
                    byte b3 = $$g[12];
                    Object[] objArr5 = new Object[1];
                    q((byte) 56, (byte) (b3 - 1), b3, objArr5);
                    objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(iResolveSize, maximumFlingVelocity, maxKeyCode, 1145017376, false, (String) objArr5[0], null);
                }
                Object[] objArr6 = (Object[]) ((Field) objAccessartificialFrame8).get(null);
                objArrAccessartificialFrame$78cbbd35 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
                int i2 = ((int[]) objArr6[3])[0];
                int i3 = ((int[]) objArr6[2])[0];
                String[] strArr = (String[]) objArr6[0];
                int iIdentityHashCode = System.identityHashCode(this);
                int i4 = (-775302330) + (((-83890178) | (~iIdentityHashCode)) * (-490)) + (((~(iIdentityHashCode | 8286090)) | (-92176268)) * 490) + 892226370;
                int i5 = (i4 << 13) ^ i4;
                int i6 = i5 ^ (i5 >>> 17);
                ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0] = i6 ^ (i6 << 5);
            } else {
                Object[] objArr7 = new Object[1];
                p(TextUtils.indexOf("", "", 0) + 16, new char[]{58224, 25437, 36919, 36947, 21724, 32829, 52923, 36312, 57909, 25407, 44793, 11151, 53175, 24598, 7361, 25075}, objArr7);
                Class<?> cls2 = Class.forName((String) objArr7[0]);
                Object[] objArr8 = new Object[1];
                p(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 12, new char[]{4408, 9642, 26912, 32316, 64863, 47606, 25078, 47908, 8972, 59220, 34161, 62132, 61167, 35585, 45506, 53174}, objArr8);
                int iIntValue = ((Integer) cls2.getMethod((String) objArr8[0], Object.class).invoke(null, this)).intValue();
                try {
                    Object[] objArr9 = {-1245118023};
                    objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1648942878);
                    if (objAccessartificialFrame == null) {
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(View.MeasureSpec.getSize(0) + 8, (char) (22252 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))), 1033 - (Process.myPid() >> 22), 47343338, false, null, new Class[]{Integer.TYPE});
                    }
                    objArrAccessartificialFrame$78cbbd35 = KeylineState.Keyline.accessartificialFrame$78cbbd35(iIntValue, 0, ((Constructor) objAccessartificialFrame).newInstance(objArr9), 273603430, false);
                    objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-614804952);
                    if (objAccessartificialFrame2 == null) {
                        int fadingEdgeLength = 26 - (ViewConfiguration.getFadingEdgeLength() >> 16);
                        char minimumFlingVelocity = (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16);
                        int i7 = 1042 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1));
                        byte b4 = $$g[12];
                        Object[] objArr10 = new Object[1];
                        q((byte) 56, (byte) (b4 - 1), b4, objArr10);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(fadingEdgeLength, minimumFlingVelocity, i7, 1145017376, false, (String) objArr10[0], null);
                    }
                    ((Field) objAccessartificialFrame2).set(null, objArrAccessartificialFrame$78cbbd35);
                    try {
                        Object[] objArr11 = new Object[1];
                        p(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 13, new char[]{52923, 36312, 44758, 57090, 34074, 44439, 19769, 13899, 20303, 56091, 63382, 36508, 34330, 52027, 15888, 12864, 47849, 44368, 3364, 48424, 65199, 42601}, objArr11);
                        Class<?> cls3 = Class.forName((String) objArr11[0]);
                        Object[] objArr12 = new Object[1];
                        p(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 11, new char[]{48031, 43365, 41576, 14867, 37115, 45563, 22328, 4831, 37063, 11749, 32806, 14496, 43628, 18378, 18183, 5032}, objArr12);
                        Long lValueOf = Long.valueOf(((Long) cls3.getDeclaredMethod((String) objArr12[0], new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-444530678);
                        if (objAccessartificialFrame3 == null) {
                            int packedPositionType = ExpandableListView.getPackedPositionType(0L) + 26;
                            char cAlpha = (char) Color.alpha(0);
                            int maximumFlingVelocity2 = (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 1041;
                            byte b5 = $$g[12];
                            Object[] objArr13 = new Object[1];
                            q((byte) 48, (byte) (b5 - 1), b5, objArr13);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(packedPositionType, cAlpha, maximumFlingVelocity2, 2061780482, false, (String) objArr13[0], null);
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
            p(TextUtils.indexOf("", "", 0) + 16, new char[]{58224, 25437, 36919, 36947, 21724, 32829, 52923, 36312, 57909, 25407, 44793, 11151, 53175, 24598, 7361, 25075}, objArr14);
            Class<?> cls4 = Class.forName((String) objArr14[0]);
            Object[] objArr15 = new Object[1];
            p(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 12, new char[]{4408, 9642, 26912, 32316, 64863, 47606, 25078, 47908, 8972, 59220, 34161, 62132, 61167, 35585, 45506, 53174}, objArr15);
            int iIntValue2 = ((Integer) cls4.getMethod((String) objArr15[0], Object.class).invoke(null, this)).intValue();
            Object[] objArr16 = {-1245118023};
            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame == null) {
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(View.MeasureSpec.getSize(0) + 8, (char) (22252 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))), 1033 - (Process.myPid() >> 22), 47343338, false, null, new Class[]{Integer.TYPE});
            }
            objArrAccessartificialFrame$78cbbd35 = KeylineState.Keyline.accessartificialFrame$78cbbd35(iIntValue2, 0, ((Constructor) objAccessartificialFrame).newInstance(objArr16), 273603430, false);
            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame2 == null) {
                int fadingEdgeLength2 = 26 - (ViewConfiguration.getFadingEdgeLength() >> 16);
                char minimumFlingVelocity2 = (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16);
                int i8 = 1042 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1));
                byte b6 = $$g[12];
                Object[] objArr17 = new Object[1];
                q((byte) 56, (byte) (b6 - 1), b6, objArr17);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(fadingEdgeLength2, minimumFlingVelocity2, i8, 1145017376, false, (String) objArr17[0], null);
            }
            ((Field) objAccessartificialFrame2).set(null, objArrAccessartificialFrame$78cbbd35);
            Object[] objArr18 = new Object[1];
            p(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 13, new char[]{52923, 36312, 44758, 57090, 34074, 44439, 19769, 13899, 20303, 56091, 63382, 36508, 34330, 52027, 15888, 12864, 47849, 44368, 3364, 48424, 65199, 42601}, objArr18);
            Class<?> cls5 = Class.forName((String) objArr18[0]);
            Object[] objArr19 = new Object[1];
            p(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 11, new char[]{48031, 43365, 41576, 14867, 37115, 45563, 22328, 4831, 37063, 11749, 32806, 14496, 43628, 18378, 18183, 5032}, objArr19);
            Long lValueOf2 = Long.valueOf(((Long) cls5.getDeclaredMethod((String) objArr19[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-444530678);
            if (objAccessartificialFrame3 == null) {
                int packedPositionType2 = ExpandableListView.getPackedPositionType(0L) + 26;
                char cAlpha2 = (char) Color.alpha(0);
                int maximumFlingVelocity3 = (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 1041;
                byte b7 = $$g[12];
                Object[] objArr110 = new Object[1];
                q((byte) 48, (byte) (b7 - 1), b7, objArr110);
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(packedPositionType2, cAlpha2, maximumFlingVelocity3, 2061780482, false, (String) objArr110[0], null);
            }
            ((Field) objAccessartificialFrame3).set(null, lValueOf2);
            c = 2;
        }
        int i9 = ((int[]) objArrAccessartificialFrame$78cbbd35[c])[0];
        int i10 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
        if (i10 != i9) {
            ArrayList arrayList = new ArrayList();
            String[] strArr2 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            if (strArr2 != null) {
                int i11 = 0;
                while (i11 < strArr2.length) {
                    int i12 = getARTIFICIAL_FRAME_PACKAGE_NAME + 97;
                    artificialFrame = i12 % 128;
                    if (i12 % 2 == 0) {
                        arrayList.add(strArr2[i11]);
                        i11 += 69;
                    } else {
                        arrayList.add(strArr2[i11]);
                        i11++;
                    }
                }
            }
            try {
                Object[] objArr20 = {Long.valueOf(((long) (i9 ^ i10)) ^ (((long) (-151638164)) << 32)), Long.valueOf(-151638162)};
                byte[] bArr = $$p;
                Object[] objArr21 = new Object[1];
                r((short) 582, bArr[249], bArr[85], objArr21);
                Class<?> cls6 = Class.forName((String) objArr21[0]);
                Object[] objArr22 = new Object[1];
                r((short) 104, (byte) (bArr[180] + 1), (byte) (bArr[258] - 1), objArr22);
                cls6.getMethod((String) objArr22[0], Long.TYPE, Long.TYPE).invoke(null, objArr20);
                Object[] objArr23 = {strArr, new int[1], new int[]{i}, new int[]{i}};
                int i13 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
                int i14 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
                int i15 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
                String[] strArr3 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
                int i16 = ~(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getDisplayMetrics().densityDpi | (-239032531));
                int i17 = i13 + ((((-970929530) + (((-317136338) | i16) * (-220))) + ((i16 | 202915842) * 220)) - 1693296568);
                int i18 = (i17 << 13) ^ i17;
                int i19 = i18 ^ (i18 >>> 17);
                ((int[]) objArr23[1])[0] = i19 ^ (i19 << 5);
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 != null) {
                    throw cause2;
                }
                throw th2;
            }
        } else {
            int i20 = artificialFrame + 115;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i20 % 128;
            int i21 = i20 % 2;
            Object[] objArr24 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i22 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i23 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i24 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr4 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int iIdentityHashCode2 = System.identityHashCode(this);
            int i25 = ~iIdentityHashCode2;
            int i26 = i22 + (-2105834626) + ((72655088 | i25) * (-192)) + (((~(131391736 | i25)) | 136840455) * (-384)) + (((~(iIdentityHashCode2 | (-58736649))) | (~(i25 | 268232191)) | (~((-136840456) | iIdentityHashCode2))) * JfifUtil.MARKER_SOFn);
            int i27 = (i26 << 13) ^ i26;
            int i28 = i27 ^ (i27 >>> 17);
            ((int[]) objArr24[1])[0] = i28 ^ (i28 << 5);
        }
        Object objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(-1268268649);
        if (objAccessartificialFrame9 == null) {
            int iGreen = 25 - Color.green(0);
            char cResolveSizeAndState = (char) (View.resolveSizeAndState(0, 0, 0) + 30068);
            int iIndexOf = 815 - TextUtils.indexOf((CharSequence) "", '0', 0, 0);
            byte b8 = $$g[12];
            Object[] objArr25 = new Object[1];
            q((byte) 48, (byte) (b8 - 1), b8, objArr25);
            objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(iGreen, cResolveSizeAndState, iIndexOf, 721586079, false, (String) objArr25[0], null);
        }
        long j3 = ((Field) objAccessartificialFrame9).getLong(null);
        if (j3 != -1) {
            long j4 = j3 + 1884;
            Object[] objArr26 = new Object[1];
            p(22 - (ViewConfiguration.getScrollBarSize() >> 8), new char[]{52923, 36312, 44758, 57090, 34074, 44439, 19769, 13899, 20303, 56091, 63382, 36508, 34330, 52027, 15888, 12864, 47849, 44368, 3364, 48424, 65199, 42601}, objArr26);
            Class<?> cls7 = Class.forName((String) objArr26[0]);
            Object[] objArr27 = new Object[1];
            p(TextUtils.indexOf("", "") + 15, new char[]{48031, 43365, 41576, 14867, 37115, 45563, 22328, 4831, 37063, 11749, 32806, 14496, 43628, 18378, 18183, 5032}, objArr27);
            if (j4 >= ((Long) cls7.getDeclaredMethod((String) objArr27[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                int i29 = getARTIFICIAL_FRAME_PACKAGE_NAME + 1;
                artificialFrame = i29 % 128;
                int i30 = i29 % 2;
                Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame10 == null) {
                    int maximumFlingVelocity4 = (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 25;
                    char tapTimeout = (char) ((ViewConfiguration.getTapTimeout() >> 16) + 30068);
                    int jumpTapTimeout = 816 - (ViewConfiguration.getJumpTapTimeout() >> 16);
                    byte b9 = $$g[12];
                    Object[] objArr28 = new Object[1];
                    q((byte) 56, (byte) (b9 - 1), b9, objArr28);
                    objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(maximumFlingVelocity4, tapTimeout, jumpTapTimeout, 891606461, false, (String) objArr28[0], null);
                }
                Object[] objArr29 = (Object[]) ((Field) objAccessartificialFrame10).get(null);
                objArr = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i31 = ((int[]) objArr29[0])[0];
                int i32 = ((int[]) objArr29[1])[0];
                String[] strArr5 = (String[]) objArr29[2];
                int streamMaxVolume = ((AudioManager) ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getSystemService("audio")).getStreamMaxVolume(3);
                int i33 = (~(285263531 | streamMaxVolume)) | 214966608;
                int i34 = ~streamMaxVolume;
                int i35 = 1488508833 + ((i33 | (~((-16794243) | i34))) * 886) + (((~(i34 | (-285263532))) | 483435897) * (-1772)) + ((~(i34 | 483435897)) * 886) + 570115707;
                int i36 = (i35 << 13) ^ i35;
                int i37 = i36 ^ (i36 >>> 17);
                ((int[]) objArr[3])[0] = i37 ^ (i37 << 5);
            } else {
                Object[] objArr30 = new Object[1];
                p(16 - View.resolveSizeAndState(0, 0, 0), new char[]{58224, 25437, 36919, 36947, 21724, 32829, 52923, 36312, 57909, 25407, 44793, 11151, 53175, 24598, 7361, 25075}, objArr30);
                Class<?> cls8 = Class.forName((String) objArr30[0]);
                Object[] objArr31 = new Object[1];
                p(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) - 20, new char[]{4408, 9642, 26912, 32316, 64863, 47606, 25078, 47908, 8972, 59220, 34161, 62132, 61167, 35585, 45506, 53174}, objArr31);
                Object[] objArr32 = {Integer.valueOf(((Integer) cls8.getMethod((String) objArr31[0], Object.class).invoke(null, this)).intValue()), 0, 570115707};
                objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1327366003);
                if (objAccessartificialFrame4 == null) {
                    int defaultSize = 25 - View.getDefaultSize(0, 0);
                    char cGreen = (char) (30068 - Color.green(0));
                    int iIndexOf2 = TextUtils.indexOf("", "") + 816;
                    byte[] bArr2 = $$g;
                    Object[] objArr33 = new Object[1];
                    q((byte) (-bArr2[3]), (byte) 28, bArr2[50], objArr33);
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(defaultSize, cGreen, iIndexOf2, -797394565, false, (String) objArr33[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                }
                objArr = (Object[]) ((Method) objAccessartificialFrame4).invoke(null, objArr32);
                objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame5 == null) {
                    int minimumFlingVelocity3 = 25 - (ViewConfiguration.getMinimumFlingVelocity() >> 16);
                    char cBlue = (char) (Color.blue(0) + 30068);
                    int keyRepeatTimeout = 816 - (ViewConfiguration.getKeyRepeatTimeout() >> 16);
                    byte b10 = $$g[12];
                    Object[] objArr34 = new Object[1];
                    q((byte) 56, (byte) (b10 - 1), b10, objArr34);
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(minimumFlingVelocity3, cBlue, keyRepeatTimeout, 891606461, false, (String) objArr34[0], null);
                }
                ((Field) objAccessartificialFrame5).set(null, objArr);
                try {
                    Object[] objArr35 = new Object[1];
                    p((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 22, new char[]{52923, 36312, 44758, 57090, 34074, 44439, 19769, 13899, 20303, 56091, 63382, 36508, 34330, 52027, 15888, 12864, 47849, 44368, 3364, 48424, 65199, 42601}, objArr35);
                    Class<?> cls9 = Class.forName((String) objArr35[0]);
                    Object[] objArr36 = new Object[1];
                    p(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 11, new char[]{48031, 43365, 41576, 14867, 37115, 45563, 22328, 4831, 37063, 11749, 32806, 14496, 43628, 18378, 18183, 5032}, objArr36);
                    Long lValueOf3 = Long.valueOf(((Long) cls9.getDeclaredMethod((String) objArr36[0], new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                    if (objAccessartificialFrame6 == null) {
                        int iMyTid = (Process.myTid() >> 22) + 25;
                        char doubleTapTimeout = (char) (30068 - (ViewConfiguration.getDoubleTapTimeout() >> 16));
                        int i38 = 817 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1));
                        byte b11 = $$g[12];
                        Object[] objArr37 = new Object[1];
                        q((byte) 48, (byte) (b11 - 1), b11, objArr37);
                        objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(iMyTid, doubleTapTimeout, i38, 721586079, false, (String) objArr37[0], null);
                    }
                    ((Field) objAccessartificialFrame6).set(null, lValueOf3);
                    int i39 = artificialFrame + 93;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i39 % 128;
                    int i40 = i39 % 2;
                } catch (Exception unused2) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object[] objArr38 = new Object[1];
            p(16 - View.resolveSizeAndState(0, 0, 0), new char[]{58224, 25437, 36919, 36947, 21724, 32829, 52923, 36312, 57909, 25407, 44793, 11151, 53175, 24598, 7361, 25075}, objArr38);
            Class<?> cls10 = Class.forName((String) objArr38[0]);
            Object[] objArr39 = new Object[1];
            p(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) - 20, new char[]{4408, 9642, 26912, 32316, 64863, 47606, 25078, 47908, 8972, 59220, 34161, 62132, 61167, 35585, 45506, 53174}, objArr39);
            Object[] objArr310 = {Integer.valueOf(((Integer) cls10.getMethod((String) objArr39[0], Object.class).invoke(null, this)).intValue()), 0, 570115707};
            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1327366003);
            if (objAccessartificialFrame4 == null) {
                int defaultSize2 = 25 - View.getDefaultSize(0, 0);
                char cGreen2 = (char) (30068 - Color.green(0));
                int iIndexOf3 = TextUtils.indexOf("", "") + 816;
                byte[] bArr3 = $$g;
                Object[] objArr311 = new Object[1];
                q((byte) (-bArr3[3]), (byte) 28, bArr3[50], objArr311);
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(defaultSize2, cGreen2, iIndexOf3, -797394565, false, (String) objArr311[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            }
            objArr = (Object[]) ((Method) objAccessartificialFrame4).invoke(null, objArr310);
            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame5 == null) {
                int minimumFlingVelocity4 = 25 - (ViewConfiguration.getMinimumFlingVelocity() >> 16);
                char cBlue2 = (char) (Color.blue(0) + 30068);
                int keyRepeatTimeout2 = 816 - (ViewConfiguration.getKeyRepeatTimeout() >> 16);
                byte b12 = $$g[12];
                Object[] objArr312 = new Object[1];
                q((byte) 56, (byte) (b12 - 1), b12, objArr312);
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(minimumFlingVelocity4, cBlue2, keyRepeatTimeout2, 891606461, false, (String) objArr312[0], null);
            }
            ((Field) objAccessartificialFrame5).set(null, objArr);
            Object[] objArr313 = new Object[1];
            p((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 22, new char[]{52923, 36312, 44758, 57090, 34074, 44439, 19769, 13899, 20303, 56091, 63382, 36508, 34330, 52027, 15888, 12864, 47849, 44368, 3364, 48424, 65199, 42601}, objArr313);
            Class<?> cls11 = Class.forName((String) objArr313[0]);
            Object[] objArr314 = new Object[1];
            p(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 11, new char[]{48031, 43365, 41576, 14867, 37115, 45563, 22328, 4831, 37063, 11749, 32806, 14496, 43628, 18378, 18183, 5032}, objArr314);
            Long lValueOf4 = Long.valueOf(((Long) cls11.getDeclaredMethod((String) objArr314[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1268268649);
            if (objAccessartificialFrame6 == null) {
                int iMyTid2 = (Process.myTid() >> 22) + 25;
                char doubleTapTimeout2 = (char) (30068 - (ViewConfiguration.getDoubleTapTimeout() >> 16));
                int i310 = 817 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1));
                byte b13 = $$g[12];
                Object[] objArr315 = new Object[1];
                q((byte) 48, (byte) (b13 - 1), b13, objArr315);
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(iMyTid2, doubleTapTimeout2, i310, 721586079, false, (String) objArr315[0], null);
            }
            ((Field) objAccessartificialFrame6).set(null, lValueOf4);
            int i311 = artificialFrame + 93;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i311 % 128;
            int i41 = i311 % 2;
        }
        int i42 = ((int[]) objArr[1])[0];
        int i43 = ((int[]) objArr[0])[0];
        if (i43 == i42) {
            Object[] objArr40 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i44 = ((int[]) objArr[3])[0];
            int i45 = ((int[]) objArr[0])[0];
            int i46 = ((int[]) objArr[1])[0];
            String[] strArr6 = (String[]) objArr[2];
            int iNextInt = new Random().nextInt();
            int i47 = ~iNextInt;
            int i48 = i44 + (-697177931) + (((~((-10145956) | i47)) | (~(iNextInt | 188026410))) * 333) + (((~(iNextInt | (-10145956))) | (~(i47 | 188026410))) * 333);
            int i49 = (i48 << 13) ^ i48;
            int i50 = i49 ^ (i49 >>> 17);
            ((int[]) objArr40[3])[0] = i50 ^ (i50 << 5);
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        String[] strArr7 = (String[]) objArr[2];
        if (strArr7 != null) {
            for (String str : strArr7) {
                arrayList2.add(str);
            }
        }
        Object[] objArr41 = {Long.valueOf((((long) (-692081415)) << 32) ^ ((long) (i42 ^ i43))), Long.valueOf(-692081416)};
        short s = (short) ($$q | 353);
        byte[] bArr4 = $$p;
        Object[] objArr42 = new Object[1];
        r(s, (byte) (-bArr4[100]), (byte) (-bArr4[94]), objArr42);
        Class<?> cls12 = Class.forName((String) objArr42[0]);
        Object[] objArr43 = new Object[1];
        r((short) 104, (byte) (bArr4[180] + 1), (byte) (bArr4[258] - 1), objArr43);
        cls12.getMethod((String) objArr43[0], Long.TYPE, Long.TYPE).invoke(null, objArr41);
        Object[] objArr44 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
        int i51 = ((int[]) objArr[3])[0];
        int i52 = ((int[]) objArr[0])[0];
        int i53 = ((int[]) objArr[1])[0];
        String[] strArr8 = (String[]) objArr[2];
        int i54 = ~(Process.myTid() | (-87264372));
        int i55 = i51 + ((((-355725172) | i54) * (-196)) - 1883193859) + ((i54 | 268460800) * 196);
        int i56 = (i55 << 13) ^ i55;
        int i57 = i56 ^ (i56 >>> 17);
        ((int[]) objArr44[3])[0] = i57 ^ (i57 << 5);
    }

    static void accessartificialFrame() {
        TopicBuilder = (char) 56817;
        ICustomTabsCallback = (char) 35217;
        extraCallbackWithResult = (char) 13894;
        onMessageChannelReady = (char) 38949;
    }
}
