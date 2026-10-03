package com.transistorsoft.locationmanager.activity;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
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
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import ch.qos.logback.core.net.SyslogConstants;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsStates;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.color.utilities.QuantizerCelebi;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.salesforce.marketingcloud.analytics.stats.b;
import com.swmansion.gesturehandler.core.NativeViewGestureHandler;
import com.transistorsoft.locationmanager.adapter.BackgroundGeolocation;
import com.transistorsoft.locationmanager.adapter.TSConfig;
import com.transistorsoft.locationmanager.config.TSBackgroundPermissionRationale;
import com.transistorsoft.locationmanager.lifecycle.LifecycleManager;
import com.transistorsoft.locationmanager.location.TSLocationManager;
import com.transistorsoft.locationmanager.logger.TSLog;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.io.encoding.Base64;
import net.pluservice.unicoc.R;
import o.ArtificialStackFrames;
import o.ICustomTabsCallback;
import okio.Utf8;
import org.apache.commons.lang3.CharEncoding;

/* JADX INFO: loaded from: classes.dex */
public class TSLocationManagerActivity extends AppCompatActivity {
    private static final byte[] $$a;
    private static final int $$b;
    private static final byte[] $$d;
    private static final int $$e;
    public static final String ACCESS_BACKGROUND_LOCATION = "android.permission.ACCESS_BACKGROUND_LOCATION";
    public static final String ACTION_ACTIVITY_IS_ACTIVE = "ACTIVITY_IS_ACTIVE";
    public static final String ACTION_LOCATION_SETTINGS = "locationsettings";
    private static byte[] ICustomTabsCallbackStubProxy = null;
    private static short[] ICustomTabsService = null;
    public static final int LOCATION_SETTINGS_REQUEST_CODE = 101;
    private static final AtomicInteger a;
    private static int artificialFrame;
    private static final Set<String> b;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME;
    private static int getInterfaceDescriptor;
    private static int mayLaunchUrl;
    private static int onTransact;
    private static final byte[] $$c = {71, Base64.padSymbol, 39, Base64.padSymbol};
    private static final int $$f = 142;
    private static int $10 = 0;
    private static int $11 = 1;

    /* JADX INFO: loaded from: classes3.dex */
    public interface CompletionHandler {
        void onComplete();
    }

    class a implements CompletionHandler {
        a() {
        }

        @Override // com.transistorsoft.locationmanager.activity.TSLocationManagerActivity.CompletionHandler
        public void onComplete() {
            TSLocationManagerActivity.this.c();
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0027  */
    /* JADX WARN: Code duplicated, block: B:8:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x002c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0027
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$g(byte r6, int r7, short r8) {
        /*
            int r7 = r7 * 4
            int r0 = 1 - r7
            int r6 = r6 * 5
            int r6 = r6 + 112
            byte[] r1 = com.transistorsoft.locationmanager.activity.TSLocationManagerActivity.$$c
            int r8 = r8 + 4
            byte[] r0 = new byte[r0]
            r2 = 0
            int r7 = 0 - r7
            if (r1 != 0) goto L17
            r6 = r7
            r3 = r8
            r4 = r2
            goto L2c
        L17:
            r3 = r2
        L18:
            byte r4 = (byte) r6
            r0[r3] = r4
            int r8 = r8 + 1
            int r4 = r3 + 1
            if (r3 != r7) goto L27
            java.lang.String r6 = new java.lang.String
            r6.<init>(r0, r2)
            return r6
        L27:
            r3 = r1[r8]
            r5 = r3
            r3 = r8
            r8 = r5
        L2c:
            int r6 = r6 + r8
            r8 = r3
            r3 = r4
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transistorsoft.locationmanager.activity.TSLocationManagerActivity.$$g(byte, int, short):java.lang.String");
    }

    static {
        byte[] bArr = new byte[772];
        System.arraycopy("~\u0098\u0092ü÷6¹þøA¾ù\u0004\u0001ýúô9Çðù\t3·ÿ\u00037çÆ\u0012óÿ\u0002\u001dÉ\u000büýï\u001aÞ\rúô\u0002ïü¿ðþ;Ãôü\u0004÷\u00033Éï\u0006îÿ\u0002\u00012ÃööAÁ÷ö\u000bï\u0000\tñ:½ýýþñ\u0011å\tò\u0006öý\u000bùýë\u000bð\u0007û3°ü\u0014äúüúîü\u000eëú\u0007ÿù\u0002ö\u0004ñ\"Ð\rð\u0004ðþ;Ãôü\u0004÷\u00033Çðþüúý<Çðÿü\u0003þëBÝèí\u001fèò\u0002ï%×ö\u000bï\u0000\tñ\u001bèíHßÛëûþ\rúë\u0019î\u0000ò\u001câè0Óöþõðþ;Ãôü\u0004÷\u00033Çíõ\u0005ø\u0001=¶\u0007÷ÿ9Éø\u0000ù2éØî*àå)âèQïðþ;Ãôü\u0004÷\u00033Éï\u0006îÿ\u0002\u00012ÃööAÇðþüúý<Éí\u00037Á÷ö\u000bï\u0000\tñ:°\u0015úéÐùÿöý\u0007÷\u0005\u001dÛÿé\nüú÷\u0003\u0018Óðþ;Ãôü\u0004÷\u00033Éï\u0006îÿ\u0002\u00012ÃööAÁ÷ö\u000bï\u0000\tñ:½ýýþñ\u0011å\tò\u0006öý\u000bùýë\u000bð\u0007û\u0002ùé\u0003\u0006ô\u0003ý2°ü\u0011ðþ;Ãôü\u0004÷\u00033°þ\u000b÷\u00035¹û\u000bð\u0007û3Æûí\u000bþë\u0001ù@äÙ÷\u0006ûï\u001eëéü\u000bï\u0000$Ù÷\u0006ûïJïðùÿöý\u0007÷\u0005\u001eÍ\t\u0000é\u0007öýðþ;Ãôü\u0004÷\u00033Éí\u00037ÙØ\u0002÷\u000f\rÚÿ÷\u0001ðþ;Ä\u0001úúÿïü\u00009Áø\böþñ\u0003õ\u0007õÿ÷\u00053½\u0004ôúùõGèÝê\n\u0011ÝüÿD××ô\u0011ñÿ\u0001\ræë\u0011\u001cÉ\u0011úñø\u0007öýðþ;Ä\u0001úúÿïü\u00009¸\t\u0000úëBµ\bø\bï\töþï@Ñæ\u0004\u0002\u000fÛ\u0007û\u0011ÝüÿDüÛÉ\u0000\u000bï\u0000\tñ\u0015Ö\u0007ö\bÿí\u0007\u0002\u0013çð\u0007úÿ-ðþ;¶þ\rï÷\u0006òû\u0001ùû\u0000\u0005îB¾ù\bþé\u0007öýý\bï\töþï@Éùÿíø\u000bï@èÝúô\u0000ñÿö\u0003\u0006\u0019Þòÿù\bþé\u0007öýF±ðùÿöý\u0007÷\u0005\u001fÏö\u0003\u0006ÿëõðþ;Ä\u0001úúÿïü\u00009Éíü\u0000ÿ÷ÿôAéÍü ß÷ÿ#ßé\u000f9ïðþ;Ãôü\u0004÷\u00033Éï\u0006îÿ\u0002\u00012½\bé\u000bï\u0005\u0004ñ:Çðÿùù@µý\u0007ùÿñ\u0007\u0000îAæÇ\u0007\tð\u0000\u0002\u001cÐÿùùJüÛÉ\u0000\u000bï\u0000\tñ\u0015Ö\u0007ö\bÿí\u0007\u0002\u0013çð\u0007úÿ-".getBytes(CharEncoding.ISO_8859_1), 0, bArr, 0, 772);
        $$d = bArr;
        $$e = 153;
        $$a = new byte[]{87, 9, 66, Ascii.SYN, -5, 1, 33, -33, 2, 9, -5, 7, -5, 1, 50, -39, -11, 7, Ascii.FF, -15, -27, -1, 7, 6, 33, -51, Ascii.FF, -3, 8, -1, -13, 2, -15, 33, -33, 19, -17, 32, -15, -19, Ascii.VT, -5, 7, -10, Ascii.US, -20, -13, 8, Ascii.VT, Ascii.CR, -27, 9, -18, 36, -33, 19, -17, 32, -15, -19, Ascii.VT, -5, 7, 7, -18, 43, -29, 4, -17, -2, -49, -2, Ascii.VT, 3, -3, 6, -6, 8, -11, Ascii.EM, -33, 19, -2, -8, 37, -44, 17, -12, 8, -14, 9, -18, 34, -25, -4, 17, -19, Ascii.SI, 1, Ascii.DC2, -15, -19, Ascii.VT, -5, 7, 2, -15, 36, -21, -13, Ascii.SI, -2, -9, -6, 34, -15, -19, Ascii.VT, -5, 7};
        $$b = 219;
        getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
        artificialFrame = 1;
        accessartificialFrame();
        a = new AtomicInteger(0);
        b = new CopyOnWriteArraySet();
    }

    private void b() {
        TSBackgroundPermissionRationale backgroundPermissionRationale = TSConfig.getInstance(getApplicationContext()).getBackgroundPermissionRationale();
        LifecycleManager.getInstance().pause();
        backgroundPermissionRationale.onStartActivity(this, new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        LifecycleManager.getInstance().resume();
        finish();
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
    private static void e(short r6, byte r7, short r8, java.lang.Object[] r9) {
        /*
            int r0 = 21 - r8
            int r6 = r6 + 65
            int r7 = r7 + 4
            byte[] r1 = com.transistorsoft.locationmanager.activity.TSLocationManagerActivity.$$a
            byte[] r0 = new byte[r0]
            int r8 = 20 - r8
            r2 = 0
            if (r1 != 0) goto L13
            r6 = r7
            r4 = r8
            r3 = r2
            goto L2a
        L13:
            r3 = r2
        L14:
            byte r4 = (byte) r6
            r0[r3] = r4
            if (r3 != r8) goto L21
            java.lang.String r6 = new java.lang.String
            r6.<init>(r0, r2)
            r9[r2] = r6
            return
        L21:
            int r7 = r7 + 1
            int r3 = r3 + 1
            r4 = r1[r7]
            r5 = r7
            r7 = r6
            r6 = r5
        L2a:
            int r4 = -r4
            int r7 = r7 + r4
            r5 = r7
            r7 = r6
            r6 = r5
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transistorsoft.locationmanager.activity.TSLocationManagerActivity.e(short, byte, short, java.lang.Object[]):void");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0021  */
    /* JADX WARN: Code duplicated, block: B:8:0x0019  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0021 -> B:11:0x0025). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0021
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void f(byte r5, int r6, short r7, java.lang.Object[] r8) {
        /*
            int r6 = r6 + 36
            int r0 = 82 - r5
            byte[] r1 = com.transistorsoft.locationmanager.activity.TSLocationManagerActivity.$$d
            int r7 = 691 - r7
            byte[] r0 = new byte[r0]
            int r5 = 81 - r5
            r2 = 0
            if (r1 != 0) goto L13
            r4 = r5
            r6 = r7
            r3 = r2
            goto L25
        L13:
            r3 = r2
        L14:
            byte r4 = (byte) r6
            r0[r3] = r4
            if (r3 != r5) goto L21
            java.lang.String r5 = new java.lang.String
            r5.<init>(r0, r2)
            r8[r2] = r5
            return
        L21:
            int r3 = r3 + 1
            r4 = r1[r7]
        L25:
            int r4 = -r4
            int r7 = r7 + 1
            int r6 = r6 + r4
            int r6 = r6 + (-4)
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transistorsoft.locationmanager.activity.TSLocationManagerActivity.f(byte, int, short, java.lang.Object[]):void");
    }

    public static boolean isActive() {
        return a.get() > 0;
    }

    public static void start(Context context, String str) {
        if (str.equalsIgnoreCase(ACTION_LOCATION_SETTINGS) && TSConfig.getInstance(context).getDisableLocationAuthorizationAlert().booleanValue()) {
            return;
        }
        final Activity activity = BackgroundGeolocation.getInstance(context).getActivity();
        if (activity == null || activity.isDestroyed()) {
            TSLog.logger.warn(TSLog.warn("Failed to initiate TSLocationManagerActivity action: " + str + " (MainActivity is null)"));
            Set<String> set = b;
            synchronized (set) {
                set.clear();
            }
            return;
        }
        Set<String> set2 = b;
        synchronized (set2) {
            if (!set2.contains(str)) {
                set2.add(str);
                final Intent intent = new Intent(context, (Class<?>) TSLocationManagerActivity.class);
                intent.setAction(str);
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.transistorsoft.locationmanager.activity.TSLocationManagerActivity$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        TSLocationManagerActivity.a(intent, activity);
                    }
                }, 200L);
                return;
            }
            TSLog.logger.debug("Action '" + str + "' already pending <IGNORED>");
        }
    }

    public static void startIfEnabled(Context context, String str) {
        TSConfig tSConfig = TSConfig.getInstance(context);
        if (!str.equalsIgnoreCase(ACTION_LOCATION_SETTINGS) || tSConfig.getEnabled().booleanValue()) {
            start(context, str);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        try {
            LocationSettingsStates.fromIntent(intent);
            if (i == 101) {
                if (i2 == -1) {
                    TSLog.logger.debug(TSLog.ok("Location settings resolution: ACCEPTED"));
                } else if (i2 == 0) {
                    TSLog.logger.debug(TSLog.cancel("Location settings resolution: DENIED"));
                }
            }
            c();
        } catch (NullPointerException unused) {
            TSLog.logger.debug(TSLog.ok("Location settings resolution: ACCEPTED"));
            c();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        LifecycleManager.getInstance().pause();
        a(getIntent());
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        TSLog.logger.debug("" + getIntent().getAction());
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        a(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(Intent intent, Activity activity) {
        Set<String> set = b;
        synchronized (set) {
            set.remove(intent.getAction());
        }
        try {
            activity.startActivityForResult(intent, 0);
        } catch (ActivityNotFoundException e) {
            TSLog.logger.error(TSLog.error(e.getMessage()), (Throwable) e);
        }
    }

    private void a(Intent intent) {
        a.incrementAndGet();
        String action = intent.getAction();
        if (action == null) {
            TSLog.logger.warn(TSLog.warn("Unknown action sent to TSLocationManagerActivity -- stopping"));
            c();
            return;
        }
        TSLog.logger.debug(action);
        if (action.equalsIgnoreCase(ACTION_LOCATION_SETTINGS)) {
            a();
        } else if (action.equalsIgnoreCase(ACCESS_BACKGROUND_LOCATION)) {
            b();
        }
    }

    private void a() {
        LocationServices.getSettingsClient((Activity) this).checkLocationSettings(new LocationSettingsRequest.Builder().addLocationRequest(TSLocationManager.getInstance(getApplicationContext()).buildLocationRequest()).build()).addOnCompleteListener(new OnCompleteListener() { // from class: com.transistorsoft.locationmanager.activity.TSLocationManagerActivity$$ExternalSyntheticLambda0
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                this.f$0.a(task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Task task) {
        try {
            c();
        } catch (ApiException e) {
            int statusCode = e.getStatusCode();
            if (statusCode != 6) {
                if (statusCode == 8502) {
                    c();
                    return;
                }
                return;
            }
            TSLog.logger.debug(TSLog.info("Location Settings Resolution: START"));
            try {
                ((ResolvableApiException) e).startResolutionForResult(this, 101);
            } catch (IntentSender.SendIntentException e2) {
                TSLog.logger.warn(TSLog.warn(e2.getMessage()));
                c();
            } catch (ClassCastException e3) {
                TSLog.logger.warn(TSLog.warn(e3.getMessage()));
                c();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0094 A[PHI: r12
  0x0094: PHI (r12v3 byte[] A[IMMUTABLE_TYPE]) = (r12v2 byte[]), (r12v6 byte[]) binds: [B:19:0x0092, B:16:0x008d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:22:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:25:0x00b4 A[Catch: all -> 0x017d, TryCatch #1 {all -> 0x017d, blocks: (B:45:0x01be, B:47:0x01db, B:48:0x0215, B:31:0x010c, B:33:0x0123, B:34:0x015c, B:23:0x00a3, B:25:0x00b4, B:26:0x00ed), top: B:78:0x00a3 }] */
    private static void d(int i, byte b2, int i2, short s, int i3, Object[] objArr) throws Throwable {
        byte[] bArr;
        int length;
        byte[] bArr2;
        int i4;
        Object objAccessartificialFrame;
        long j;
        int i5;
        int i6 = 2 % 2;
        ICustomTabsCallback iCustomTabsCallback = new ICustomTabsCallback();
        StringBuilder sb = new StringBuilder();
        try {
            Object[] objArr2 = {Integer.valueOf(i2), Integer.valueOf(mayLaunchUrl)};
            Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1991297565);
            if (objAccessartificialFrame2 == null) {
                byte b3 = (byte) 0;
                byte b4 = b3;
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(41 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), (char) ((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 36241), View.resolveSize(0, 0) + 2342, 371880939, false, $$g(b3, b4, (byte) (b4 - 1)), new Class[]{Integer.TYPE, Integer.TYPE});
            }
            int iIntValue = ((Integer) ((Method) objAccessartificialFrame2).invoke(null, objArr2)).intValue();
            boolean z = iIntValue == -1;
            if (!z) {
                j = -4629754035390455669L;
            } else {
                int i7 = $11;
                int i8 = i7 + 91;
                $10 = i8 % 128;
                if (i8 % 2 != 0) {
                    bArr = ICustomTabsCallbackStubProxy;
                    int i9 = 92 / 0;
                    if (bArr != null) {
                        int i10 = i7 + 37;
                        $10 = i10 % 128;
                        int i11 = i10 % 2;
                        length = bArr.length;
                        bArr2 = new byte[length];
                        for (i4 = 0; i4 < length; i4++) {
                            try {
                                Object[] objArr3 = {Integer.valueOf(bArr[i4])};
                                objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1557994855);
                                if (objAccessartificialFrame == null) {
                                    byte b5 = (byte) 1;
                                    byte b6 = (byte) (b5 - 1);
                                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getScrollDefaultDelay() >> 16) + 44, (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16), 1216 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), 1011328145, false, $$g(b5, b6, (byte) (b6 - 1)), new Class[]{Integer.TYPE});
                                }
                                bArr2[i4] = ((Byte) ((Method) objAccessartificialFrame).invoke(null, objArr3)).byteValue();
                            } catch (Throwable th) {
                                Throwable cause = th.getCause();
                                if (cause == null) {
                                    throw th;
                                }
                                throw cause;
                            }
                        }
                        bArr = bArr2;
                    }
                } else {
                    bArr = ICustomTabsCallbackStubProxy;
                    if (bArr != null) {
                        int i12 = i7 + 37;
                        $10 = i12 % 128;
                        int i13 = i12 % 2;
                        length = bArr.length;
                        bArr2 = new byte[length];
                        while (i4 < length) {
                            Object[] objArr4 = {Integer.valueOf(bArr[i4])};
                            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1557994855);
                            if (objAccessartificialFrame == null) {
                                byte b7 = (byte) 1;
                                byte b8 = (byte) (b7 - 1);
                                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getScrollDefaultDelay() >> 16) + 44, (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16), 1216 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), 1011328145, false, $$g(b7, b8, (byte) (b8 - 1)), new Class[]{Integer.TYPE});
                            }
                            bArr2[i4] = ((Byte) ((Method) objAccessartificialFrame).invoke(null, objArr4)).byteValue();
                        }
                        bArr = bArr2;
                    }
                }
                if (bArr != null) {
                    byte[] bArr3 = ICustomTabsCallbackStubProxy;
                    Object[] objArr5 = {Integer.valueOf(i3), Integer.valueOf(onTransact)};
                    Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1991297565);
                    if (objAccessartificialFrame3 == null) {
                        byte b9 = (byte) 0;
                        byte b10 = b9;
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(40 - View.resolveSizeAndState(0, 0, 0), (char) (View.getDefaultSize(0, 0) + 36241), Color.rgb(0, 0, 0) + 16779558, 371880939, false, $$g(b9, b10, (byte) (b10 - 1)), new Class[]{Integer.TYPE, Integer.TYPE});
                    }
                    iIntValue = (byte) (((byte) (((long) bArr3[((Integer) ((Method) objAccessartificialFrame3).invoke(null, objArr5)).intValue()]) ^ (-4629754035390455669L))) + ((int) (((long) mayLaunchUrl) ^ (-4629754035390455669L))));
                    j = -4629754035390455669L;
                } else {
                    j = -4629754035390455669L;
                    iIntValue = (short) (((short) (((long) ICustomTabsService[i3 + ((int) (((long) onTransact) ^ (-4629754035390455669L)))]) ^ (-4629754035390455669L))) + ((int) (((long) mayLaunchUrl) ^ (-4629754035390455669L))));
                }
            }
            if (iIntValue > 0) {
                int i14 = ((i3 + iIntValue) - 2) + ((int) (((long) onTransact) ^ j));
                if (!(!z)) {
                    int i15 = $11 + 105;
                    $10 = i15 % 128;
                    int i16 = i15 % 2;
                    i5 = 1;
                } else {
                    i5 = 0;
                }
                iCustomTabsCallback.c = i14 + i5;
                Object[] objArr6 = {iCustomTabsCallback, Integer.valueOf(i), Integer.valueOf(getInterfaceDescriptor), sb};
                Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(216546027);
                if (objAccessartificialFrame4 == null) {
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(40 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (char) (TextUtils.lastIndexOf("", '0', 0, 0) + 1), (ViewConfiguration.getPressedStateDuration() >> 16) + 4066, -1819443997, false, "x", new Class[]{Object.class, Integer.TYPE, Integer.TYPE, Object.class});
                }
                ((StringBuilder) ((Method) objAccessartificialFrame4).invoke(null, objArr6)).append(iCustomTabsCallback.createConnectionCallback);
                iCustomTabsCallback.createBrowser = iCustomTabsCallback.createConnectionCallback;
                byte[] bArr4 = ICustomTabsCallbackStubProxy;
                if (bArr4 != null) {
                    int length2 = bArr4.length;
                    byte[] bArr5 = new byte[length2];
                    for (int i17 = 0; i17 < length2; i17++) {
                        bArr5[i17] = (byte) (((long) bArr4[i17]) ^ (-4629754035390455669L));
                    }
                    bArr4 = bArr5;
                }
                boolean z2 = bArr4 != null;
                iCustomTabsCallback.a = 1;
                while (iCustomTabsCallback.a < iIntValue) {
                    if (z2) {
                        byte[] bArr6 = ICustomTabsCallbackStubProxy;
                        int i18 = iCustomTabsCallback.c;
                        iCustomTabsCallback.c = i18 - 1;
                        iCustomTabsCallback.createConnectionCallback = (char) (iCustomTabsCallback.createBrowser + (((byte) (((byte) (((long) bArr6[i18]) ^ (-4629754035390455669L))) + s)) ^ b2));
                        int i19 = $11 + AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
                        $10 = i19 % 128;
                        int i20 = i19 % 2;
                    } else {
                        short[] sArr = ICustomTabsService;
                        int i21 = iCustomTabsCallback.c;
                        iCustomTabsCallback.c = i21 - 1;
                        iCustomTabsCallback.createConnectionCallback = (char) (iCustomTabsCallback.createBrowser + (((short) (((short) (((long) sArr[i21]) ^ (-4629754035390455669L))) + s)) ^ b2));
                    }
                    sb.append(iCustomTabsCallback.createConnectionCallback);
                    iCustomTabsCallback.createBrowser = iCustomTabsCallback.createConnectionCallback;
                    iCustomTabsCallback.a++;
                }
            }
            objArr[0] = sb.toString();
        } catch (Throwable th2) {
            Throwable cause2 = th2.getCause();
            if (cause2 == null) {
                throw th2;
            }
            throw cause2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x03a7  */
    /* JADX WARN: Code duplicated, block: B:17:0x03d7 A[Catch: all -> 0x2b50, TryCatch #1 {all -> 0x2b50, blocks: (B:267:0x222b, B:269:0x2231, B:270:0x2260, B:272:0x228b, B:273:0x2313, B:170:0x15dd, B:172:0x15ea, B:173:0x161d, B:175:0x1627, B:177:0x1634, B:178:0x1664, B:107:0x0ec7, B:109:0x0ee9, B:110:0x0f38, B:15:0x03c3, B:17:0x03d7, B:18:0x0405), top: B:366:0x03c3 }] */
    /* JADX WARN: Code duplicated, block: B:21:0x041b  */
    /* JADX WARN: Code duplicated, block: B:223:0x1ce0  */
    /* JADX WARN: Code duplicated, block: B:225:0x1ce7  */
    /* JADX WARN: Code duplicated, block: B:227:0x1e17  */
    /* JADX WARN: Code duplicated, block: B:233:0x1e27  */
    /* JADX WARN: Code duplicated, block: B:237:0x1eb1  */
    /* JADX WARN: Code duplicated, block: B:239:0x1eba  */
    /* JADX WARN: Code duplicated, block: B:244:0x1f2b  */
    /* JADX WARN: Code duplicated, block: B:26:0x0480  */
    /* JADX WARN: Code duplicated, block: B:312:0x285f  */
    /* JADX WARN: Code duplicated, block: B:315:0x2869  */
    /* JADX WARN: Code duplicated, block: B:57:0x07a2  */
    /* JADX WARN: Code duplicated, block: B:59:0x07a8  */
    /* JADX WARN: Code duplicated, block: B:61:0x091a  */
    /* JADX WARN: Code duplicated, block: B:63:0x091e  */
    /* JADX WARN: Code duplicated, block: B:66:0x0932  */
    /* JADX WARN: Code duplicated, block: B:67:0x0934  */
    /* JADX WARN: Code duplicated, block: B:72:0x0b23  */
    /* JADX WARN: Code duplicated, block: B:74:0x0b2c  */
    /* JADX WARN: Code duplicated, block: B:79:0x0b99  */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onStart() throws Throwable {
        Object objAccessartificialFrame;
        Object[] objArrAccessartificialFrame$78cbbd35;
        Object objAccessartificialFrame2;
        Object objAccessartificialFrame3;
        int i;
        Context baseContext;
        Object[] objArr;
        Object objAccessartificialFrame4;
        Object objAccessartificialFrame5;
        int i2;
        Object[] objArr2;
        Object[] objArr3;
        int i3;
        Object[] objArr4;
        Context baseContext2;
        Object[] objArr5;
        Object objAccessartificialFrame6;
        Object objAccessartificialFrame7;
        int i4;
        Object[] objArr6;
        int i5;
        Object[] objArr7;
        int i6 = 2 % 2;
        Object[] objArr8 = new Object[1];
        d(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 1248954049, (byte) (ViewConfiguration.getTapTimeout() >> 16), (-25) - View.MeasureSpec.makeMeasureSpec(0, 0), (short) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 34), (-692477982) + ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length(), objArr8);
        String str = (String) objArr8[0];
        Object[] objArr9 = new Object[1];
        d(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 1248954067, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 35), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() - 29, (short) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 92), (ViewConfiguration.getKeyRepeatTimeout() >> 16) - 692477956, objArr9);
        String str2 = (String) objArr9[0];
        Object[] objArr10 = new Object[1];
        d(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 1248954089, (byte) View.MeasureSpec.getMode(0), View.resolveSize(0, 0) - 25, (short) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) - 40), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) - 692477977, objArr10);
        String str3 = (String) objArr10[0];
        Object[] objArr11 = new Object[1];
        d(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 1248954057, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 4), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(1) - 74, (short) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) + 75), (-692477925) - ExpandableListView.getPackedPositionType(0L), objArr11);
        String str4 = (String) objArr11[0];
        Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-444530678);
        if (objAccessartificialFrame8 == null) {
            int minimumFlingVelocity = 26 - (ViewConfiguration.getMinimumFlingVelocity() >> 16);
            char keyRepeatTimeout = (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16);
            int packedPositionType = 1041 - ExpandableListView.getPackedPositionType(0L);
            byte[] bArr = $$a;
            Object[] objArr12 = new Object[1];
            e((byte) 47, bArr[21], bArr[18], objArr12);
            objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(minimumFlingVelocity, keyRepeatTimeout, packedPositionType, 2061780482, false, (String) objArr12[0], null);
        }
        long j = ((Field) objAccessartificialFrame8).getLong(null);
        if (j != -1) {
            int i7 = getARTIFICIAL_FRAME_PACKAGE_NAME + 55;
            artificialFrame = i7 % 128;
            int i8 = i7 % 2;
            if (j + 1996 >= ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame9 == null) {
                    int iLastIndexOf = TextUtils.lastIndexOf("", '0', 0) + 27;
                    char c = (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                    int packedPositionGroup = ExpandableListView.getPackedPositionGroup(0L) + 1041;
                    byte[] bArr2 = $$a;
                    Object[] objArr13 = new Object[1];
                    e((byte) 47, bArr2[11], bArr2[18], objArr13);
                    objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(iLastIndexOf, c, packedPositionGroup, 1145017376, false, (String) objArr13[0], null);
                }
                Object[] objArr14 = (Object[]) ((Field) objAccessartificialFrame9).get(null);
                objArrAccessartificialFrame$78cbbd35 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
                int i9 = ((int[]) objArr14[3])[0];
                int i10 = ((int[]) objArr14[2])[0];
                String[] strArr = (String[]) objArr14[0];
                int iIdentityHashCode = System.identityHashCode(this);
                int i11 = (((~(120710768 | iIdentityHashCode)) | (-216550688)) * 398) + 2147057452 + (((~((~iIdentityHashCode) | 120710768)) | (-216550688)) * 398) + 1908680625;
                int i12 = (i11 << 13) ^ i11;
                int i13 = i12 ^ (i12 >>> 17);
                ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0] = i13 ^ (i13 << 5);
            } else {
                int iIntValue = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
                try {
                    Object[] objArr15 = {132275436};
                    objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1648942878);
                    if (objAccessartificialFrame == null) {
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(9 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (char) ((Process.myPid() >> 22) + 22251), TextUtils.indexOf("", "") + 1033, 47343338, false, null, new Class[]{Integer.TYPE});
                    }
                    objArrAccessartificialFrame$78cbbd35 = QuantizerCelebi.accessartificialFrame$78cbbd35(iIntValue, 0, ((Constructor) objAccessartificialFrame).newInstance(objArr15), 1908680625, false);
                    objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-614804952);
                    if (objAccessartificialFrame2 == null) {
                        int edgeSlop = 26 - (ViewConfiguration.getEdgeSlop() >> 16);
                        char cBlue = (char) Color.blue(0);
                        int tapTimeout = (ViewConfiguration.getTapTimeout() >> 16) + 1041;
                        byte[] bArr3 = $$a;
                        Object[] objArr16 = new Object[1];
                        e((byte) 47, bArr3[11], bArr3[18], objArr16);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(edgeSlop, cBlue, tapTimeout, 1145017376, false, (String) objArr16[0], null);
                    }
                    ((Field) objAccessartificialFrame2).set(null, objArrAccessartificialFrame$78cbbd35);
                    try {
                        Long lValueOf = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-444530678);
                        if (objAccessartificialFrame3 == null) {
                            int minimumFlingVelocity2 = (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 26;
                            char maximumFlingVelocity = (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16);
                            int maxKeyCode = (KeyEvent.getMaxKeyCode() >> 16) + 1041;
                            byte[] bArr4 = $$a;
                            Object[] objArr17 = new Object[1];
                            e((byte) 47, bArr4[21], bArr4[18], objArr17);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(minimumFlingVelocity2, maximumFlingVelocity, maxKeyCode, 2061780482, false, (String) objArr17[0], null);
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
            int iIntValue2 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
            Object[] objArr18 = {132275436};
            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame == null) {
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(9 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (char) ((Process.myPid() >> 22) + 22251), TextUtils.indexOf("", "") + 1033, 47343338, false, null, new Class[]{Integer.TYPE});
            }
            objArrAccessartificialFrame$78cbbd35 = QuantizerCelebi.accessartificialFrame$78cbbd35(iIntValue2, 0, ((Constructor) objAccessartificialFrame).newInstance(objArr18), 1908680625, false);
            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame2 == null) {
                int edgeSlop2 = 26 - (ViewConfiguration.getEdgeSlop() >> 16);
                char cBlue2 = (char) Color.blue(0);
                int tapTimeout2 = (ViewConfiguration.getTapTimeout() >> 16) + 1041;
                byte[] bArr5 = $$a;
                Object[] objArr19 = new Object[1];
                e((byte) 47, bArr5[11], bArr5[18], objArr19);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(edgeSlop2, cBlue2, tapTimeout2, 1145017376, false, (String) objArr19[0], null);
            }
            ((Field) objAccessartificialFrame2).set(null, objArrAccessartificialFrame$78cbbd35);
            Long lValueOf2 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-444530678);
            if (objAccessartificialFrame3 == null) {
                int minimumFlingVelocity3 = (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 26;
                char maximumFlingVelocity2 = (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16);
                int maxKeyCode2 = (KeyEvent.getMaxKeyCode() >> 16) + 1041;
                byte[] bArr6 = $$a;
                Object[] objArr110 = new Object[1];
                e((byte) 47, bArr6[21], bArr6[18], objArr110);
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(minimumFlingVelocity3, maximumFlingVelocity2, maxKeyCode2, 2061780482, false, (String) objArr110[0], null);
            }
            ((Field) objAccessartificialFrame3).set(null, lValueOf2);
        }
        int i14 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
        int i15 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
        if (i15 == i14) {
            Object[] objArr20 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i16 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i17 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i18 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr2 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int iIdentityHashCode2 = System.identityHashCode(this);
            int i19 = i16 + 1170634562 + (((~((-171967745) | iIdentityHashCode2)) | (~((~iIdentityHashCode2) | (-93863938)))) * (-318)) + (((~(172395952 | iIdentityHashCode2)) | (-266259890)) * (-318)) + (((~(iIdentityHashCode2 | (-172395953))) | 94292145) * TypedValues.AttributesType.TYPE_PIVOT_TARGET);
            int i20 = (i19 << 13) ^ i19;
            int i21 = i20 ^ (i20 >>> 17);
            ((int[]) objArr20[1])[0] = i21 ^ (i21 << 5);
            i = 0;
        } else {
            ArrayList arrayList = new ArrayList();
            String[] strArr3 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            if (strArr3 != null) {
                for (String str5 : strArr3) {
                    arrayList.add(str5);
                }
            }
            try {
                Object[] objArr21 = {Long.valueOf(((long) (i14 ^ i15)) ^ (((long) 352404197) << 32)), Long.valueOf(352404199)};
                byte[] bArr7 = $$d;
                Object[] objArr22 = new Object[1];
                f((byte) (-bArr7[388]), (byte) (-bArr7[70]), (short) 687, objArr22);
                Class<?> cls = Class.forName((String) objArr22[0]);
                byte b2 = (byte) (-bArr7[640]);
                byte b3 = bArr7[75];
                Object[] objArr23 = new Object[1];
                f(b2, b3, (short) (b3 | 645), objArr23);
                cls.getMethod((String) objArr23[0], Long.TYPE, Long.TYPE).invoke(null, objArr21);
                Object[] objArr24 = {strArr, new int[1], new int[]{i}, new int[]{i}};
                int i22 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
                int i23 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
                int i24 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
                String[] strArr4 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
                int i25 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().mcc;
                int i26 = ~i25;
                int i27 = i22 + (-702192220) + (((~(793112480 | i26)) | 871216287) * (-90)) + (((~(793112480 | i25)) | 201345824) * (-45)) + (((~(i25 | (-871216288))) | 793112480 | (~(i26 | 871216287))) * 45);
                int i28 = (i27 << 13) ^ i27;
                int i29 = i28 ^ (i28 >>> 17);
                int[] iArr = (int[]) objArr24[1];
                i = 0;
                iArr[0] = i29 ^ (i29 << 5);
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 == null) {
                    throw th2;
                }
                throw cause2;
            }
        }
        Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(1313006081);
        if (objAccessartificialFrame10 == null) {
            int iIndexOf = TextUtils.indexOf("", "") + 21;
            char packedPositionType2 = (char) ExpandableListView.getPackedPositionType(0L);
            int iNormalizeMetaState = 465 - KeyEvent.normalizeMetaState(i);
            byte[] bArr8 = $$a;
            Object[] objArr25 = new Object[1];
            e((byte) 47, bArr8[21], bArr8[18], objArr25);
            objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(iIndexOf, packedPositionType2, iNormalizeMetaState, -785931255, false, (String) objArr25[0], null);
        }
        long j2 = ((Field) objAccessartificialFrame10).getLong(null);
        if (j2 != -1) {
            int i30 = artificialFrame + 9;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i30 % 128;
            if (i30 % 2 == 0 ? j2 + 1926 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue() : (j2 | 1926) < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[1]).invoke(null, new Object[0])).longValue()) {
                baseContext = getBaseContext();
                if (baseContext == null) {
                    int i31 = getARTIFICIAL_FRAME_PACKAGE_NAME + 33;
                    artificialFrame = i31 % 128;
                    int i32 = i31 % 2;
                    Object[] objArr26 = new Object[1];
                    d(1248954084 - (ViewConfiguration.getTouchSlop() >> 8), (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) - 36), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) - 61, (short) (AndroidCharacter.getMirror('0') + '5'), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(1) - 692478010, objArr26);
                    Class<?> cls2 = Class.forName((String) objArr26[0]);
                    Object[] objArr27 = new Object[1];
                    d(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 1248954051, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 35), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 60, (short) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(3) - 140), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 692477918, objArr27);
                    baseContext = (Context) cls2.getMethod((String) objArr27[0], new Class[0]).invoke(null, null);
                }
                if (baseContext != null) {
                    if (baseContext instanceof ContextWrapper) {
                        int i33 = artificialFrame + 43;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i33 % 128;
                        int i34 = i33 % 2;
                        if (((ContextWrapper) baseContext).getBaseContext() != null) {
                            baseContext = baseContext.getApplicationContext();
                        } else {
                            baseContext = null;
                        }
                    } else {
                        baseContext = baseContext.getApplicationContext();
                    }
                }
                int iIntValue3 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
                Object[] objArr28 = new Object[1];
                d(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(0) + 1248954052, (byte) View.getDefaultSize(0, 0), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(3) - 140, (short) (Drawable.resolveOpacity(0, 0) - 29), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(3) - 692477980, objArr28);
                String str6 = (String) objArr28[0];
                Object[] objArr29 = new Object[1];
                d((ViewConfiguration.getEdgeSlop() >> 16) + 1248954040, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 21), (-25) - View.resolveSize(0, 0), (short) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 79), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() - 692477805, objArr29);
                try {
                    Object[] objArr30 = {baseContext, new String[]{str6, (String) objArr29[0]}, Integer.valueOf(iIntValue3), 1, 1758064153};
                    byte[] bArr9 = $$d;
                    Object[] objArr31 = new Object[1];
                    f(bArr9[177], (byte) (-bArr9[70]), (short) 643, objArr31);
                    Class<?> cls3 = Class.forName((String) objArr31[0]);
                    byte b4 = bArr9[205];
                    Object[] objArr32 = new Object[1];
                    f(b4, b4, (short) 587, objArr32);
                    objArr = (Object[]) cls3.getMethod((String) objArr32[0], Context.class, String[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr30);
                    int i35 = ((int[]) objArr[0])[0];
                    int i36 = ((int[]) objArr[3])[0];
                    if (baseContext != null) {
                        objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1142731807);
                        if (objAccessartificialFrame4 == null) {
                            int offsetBefore = TextUtils.getOffsetBefore("", 0) + 21;
                            char c2 = (char) (1 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)));
                            int minimumFlingVelocity4 = (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 465;
                            byte[] bArr10 = $$a;
                            Object[] objArr33 = new Object[1];
                            e((byte) 47, bArr10[11], bArr10[18], objArr33);
                            objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(offsetBefore, c2, minimumFlingVelocity4, -612765161, false, (String) objArr33[0], null);
                        }
                        ((Field) objAccessartificialFrame4).set(null, objArr);
                        try {
                            Long lValueOf3 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(1313006081);
                            if (objAccessartificialFrame5 == null) {
                                int trimmedLength = TextUtils.getTrimmedLength("") + 21;
                                char absoluteGravity = (char) Gravity.getAbsoluteGravity(0, 0);
                                int i37 = 466 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
                                byte[] bArr11 = $$a;
                                Object[] objArr34 = new Object[1];
                                e((byte) 47, bArr11[21], bArr11[18], objArr34);
                                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(trimmedLength, absoluteGravity, i37, -785931255, false, (String) objArr34[0], null);
                            }
                            ((Field) objAccessartificialFrame5).set(null, lValueOf3);
                        } catch (Exception unused2) {
                            throw new RuntimeException();
                        }
                    }
                } catch (Throwable th3) {
                    Throwable cause3 = th3.getCause();
                    if (cause3 == null) {
                        throw th3;
                    }
                    throw cause3;
                }
            } else {
                Object objAccessartificialFrame11 = ArtificialStackFrames.accessartificialFrame(1142731807);
                if (objAccessartificialFrame11 == null) {
                    int tapTimeout3 = 21 - (ViewConfiguration.getTapTimeout() >> 16);
                    char cLastIndexOf = (char) (TextUtils.lastIndexOf("", '0', 0, 0) + 1);
                    int longPressTimeout = 465 - (ViewConfiguration.getLongPressTimeout() >> 16);
                    byte[] bArr12 = $$a;
                    Object[] objArr35 = new Object[1];
                    e((byte) 47, bArr12[11], bArr12[18], objArr35);
                    objAccessartificialFrame11 = ArtificialStackFrames.coroutineCreation(tapTimeout3, cLastIndexOf, longPressTimeout, -612765161, false, (String) objArr35[0], null);
                }
                Object[] objArr36 = (Object[]) ((Field) objAccessartificialFrame11).get(null);
                objArr = new Object[]{new int[]{i}, strArr, new int[1], new int[]{i}};
                int i38 = ((int[]) objArr36[3])[0];
                int i39 = ((int[]) objArr36[0])[0];
                String[] strArr5 = (String[]) objArr36[1];
                int iUptimeMillis = (int) SystemClock.uptimeMillis();
                int i40 = (((-263086199) + (((~((-52768195) | iUptimeMillis)) | (-107581532)) * (-948))) + ((~((~iUptimeMillis) | (-35717187))) * (-948))) - 1521390491;
                int i41 = (i40 << 13) ^ i40;
                int i42 = i41 ^ (i41 >>> 17);
                ((int[]) objArr[2])[0] = i42 ^ (i42 << 5);
            }
        } else {
            baseContext = getBaseContext();
            if (baseContext == null) {
                int i310 = getARTIFICIAL_FRAME_PACKAGE_NAME + 33;
                artificialFrame = i310 % 128;
                int i311 = i310 % 2;
                Object[] objArr210 = new Object[1];
                d(1248954084 - (ViewConfiguration.getTouchSlop() >> 8), (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) - 36), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) - 61, (short) (AndroidCharacter.getMirror('0') + '5'), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(1) - 692478010, objArr210);
                Class<?> cls4 = Class.forName((String) objArr210[0]);
                Object[] objArr211 = new Object[1];
                d(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 1248954051, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 35), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 60, (short) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(3) - 140), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 692477918, objArr211);
                baseContext = (Context) cls4.getMethod((String) objArr211[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                if (baseContext instanceof ContextWrapper) {
                    int i312 = artificialFrame + 43;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i312 % 128;
                    int i313 = i312 % 2;
                    if (((ContextWrapper) baseContext).getBaseContext() != null) {
                        baseContext = baseContext.getApplicationContext();
                    } else {
                        baseContext = null;
                    }
                } else {
                    baseContext = baseContext.getApplicationContext();
                }
            }
            int iIntValue4 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
            Object[] objArr212 = new Object[1];
            d(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(0) + 1248954052, (byte) View.getDefaultSize(0, 0), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(3) - 140, (short) (Drawable.resolveOpacity(0, 0) - 29), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(3) - 692477980, objArr212);
            String str7 = (String) objArr212[0];
            Object[] objArr213 = new Object[1];
            d((ViewConfiguration.getEdgeSlop() >> 16) + 1248954040, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 21), (-25) - View.resolveSize(0, 0), (short) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 79), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() - 692477805, objArr213);
            Object[] objArr37 = {baseContext, new String[]{str7, (String) objArr213[0]}, Integer.valueOf(iIntValue4), 1, 1758064153};
            byte[] bArr13 = $$d;
            Object[] objArr38 = new Object[1];
            f(bArr13[177], (byte) (-bArr13[70]), (short) 643, objArr38);
            Class<?> cls5 = Class.forName((String) objArr38[0]);
            byte b5 = bArr13[205];
            Object[] objArr39 = new Object[1];
            f(b5, b5, (short) 587, objArr39);
            objArr = (Object[]) cls5.getMethod((String) objArr39[0], Context.class, String[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr37);
            int i314 = ((int[]) objArr[0])[0];
            int i315 = ((int[]) objArr[3])[0];
            if (baseContext != null) {
                objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1142731807);
                if (objAccessartificialFrame4 == null) {
                    int offsetBefore2 = TextUtils.getOffsetBefore("", 0) + 21;
                    char c3 = (char) (1 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)));
                    int minimumFlingVelocity5 = (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 465;
                    byte[] bArr14 = $$a;
                    Object[] objArr310 = new Object[1];
                    e((byte) 47, bArr14[11], bArr14[18], objArr310);
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(offsetBefore2, c3, minimumFlingVelocity5, -612765161, false, (String) objArr310[0], null);
                }
                ((Field) objAccessartificialFrame4).set(null, objArr);
                Long lValueOf4 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(1313006081);
                if (objAccessartificialFrame5 == null) {
                    int trimmedLength2 = TextUtils.getTrimmedLength("") + 21;
                    char absoluteGravity2 = (char) Gravity.getAbsoluteGravity(0, 0);
                    int i316 = 466 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
                    byte[] bArr15 = $$a;
                    Object[] objArr311 = new Object[1];
                    e((byte) 47, bArr15[21], bArr15[18], objArr311);
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(trimmedLength2, absoluteGravity2, i316, -785931255, false, (String) objArr311[0], null);
                }
                ((Field) objAccessartificialFrame5).set(null, lValueOf4);
            }
        }
        int i43 = ((int[]) objArr[0])[0];
        int i44 = ((int[]) objArr[3])[0];
        if (i44 == i43) {
            Object[] objArr40 = {new int[]{i}, strArr, new int[1], new int[]{i}};
            int i45 = ((int[]) objArr[2])[0];
            int i46 = ((int[]) objArr[3])[0];
            int i47 = ((int[]) objArr[0])[0];
            String[] strArr6 = (String[]) objArr[1];
            int i48 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().uiMode;
            int i49 = ~i48;
            int i50 = i45 + 2135700447 + (((~((-271329841) | i49)) | (-110980115)) * (-602)) + (((~(i48 | (-271329841))) | 270533152 | (~((-110183427) | i49))) * (-301)) + ((~(i49 | (-110980115))) * 301);
            int i51 = (i50 << 13) ^ i50;
            int i52 = i51 ^ (i51 >>> 17);
            ((int[]) objArr40[2])[0] = i52 ^ (i52 << 5);
            i2 = 0;
        } else {
            ArrayList arrayList2 = new ArrayList();
            String[] strArr7 = (String[]) objArr[1];
            if (strArr7 != null) {
                for (String str8 : strArr7) {
                    arrayList2.add(str8);
                }
            }
            Object[] objArr41 = {Long.valueOf(((long) (i43 ^ i44)) ^ (((long) 1032255761) << 32)), Long.valueOf(1032255825)};
            byte[] bArr16 = $$d;
            Object[] objArr42 = new Object[1];
            f((byte) (-bArr16[19]), (byte) (-bArr16[70]), (short) 567, objArr42);
            Class<?> cls6 = Class.forName((String) objArr42[0]);
            byte b6 = (byte) (-bArr16[640]);
            byte b7 = bArr16[75];
            Object[] objArr43 = new Object[1];
            f(b6, b7, (short) (b7 | 645), objArr43);
            cls6.getMethod((String) objArr43[0], Long.TYPE, Long.TYPE).invoke(null, objArr41);
            Object[] objArr44 = {new int[]{i}, strArr, new int[1], new int[]{i}};
            int i53 = ((int[]) objArr[2])[0];
            int i54 = ((int[]) objArr[3])[0];
            int i55 = ((int[]) objArr[0])[0];
            String[] strArr8 = (String[]) objArr[1];
            int i56 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().screenHeightDp;
            int i57 = i53 + ((((~(382129816 | i56)) | (-915620399)) * 262) - 309063827) + (((~((~i56) | 382129816)) | (-915620399)) * 262);
            int i58 = (i57 << 13) ^ i57;
            int i59 = i58 ^ (i58 >>> 17);
            i2 = 0;
            ((int[]) objArr44[2])[0] = i59 ^ (i59 << 5);
        }
        Object objAccessartificialFrame12 = ArtificialStackFrames.accessartificialFrame(-1268268649);
        if (objAccessartificialFrame12 == null) {
            int mirror = 'I' - AndroidCharacter.getMirror('0');
            char cRgb = (char) ((-16747148) - Color.rgb(i2, i2, i2));
            int iResolveOpacity = 816 - Drawable.resolveOpacity(i2, i2);
            byte[] bArr17 = $$a;
            Object[] objArr45 = new Object[1];
            e((byte) 47, bArr17[21], bArr17[18], objArr45);
            objAccessartificialFrame12 = ArtificialStackFrames.coroutineCreation(mirror, cRgb, iResolveOpacity, 721586079, false, (String) objArr45[0], null);
        }
        long j3 = ((Field) objAccessartificialFrame12).getLong(null);
        if (j3 == -1 || j3 + 1959 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Object[] objArr46 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, -834127482};
            Object objAccessartificialFrame13 = ArtificialStackFrames.accessartificialFrame(1327366003);
            if (objAccessartificialFrame13 == null) {
                int iKeyCodeFromString = 25 - KeyEvent.keyCodeFromString("");
                char cAlpha = (char) (30068 - Color.alpha(0));
                int iIndexOf2 = 815 - TextUtils.indexOf((CharSequence) "", '0');
                byte[] bArr18 = $$a;
                Object[] objArr47 = new Object[1];
                e(bArr18[35], bArr18[97], bArr18[1], objArr47);
                objAccessartificialFrame13 = ArtificialStackFrames.coroutineCreation(iKeyCodeFromString, cAlpha, iIndexOf2, -797394565, false, (String) objArr47[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            }
            objArr2 = (Object[]) ((Method) objAccessartificialFrame13).invoke(null, objArr46);
            Object objAccessartificialFrame14 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame14 == null) {
                int i60 = 25 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                char cAxisFromString = (char) (MotionEvent.axisFromString("") + 30069);
                int windowTouchSlop = (ViewConfiguration.getWindowTouchSlop() >> 8) + 816;
                byte[] bArr19 = $$a;
                Object[] objArr48 = new Object[1];
                e((byte) 47, bArr19[11], bArr19[18], objArr48);
                objAccessartificialFrame14 = ArtificialStackFrames.coroutineCreation(i60, cAxisFromString, windowTouchSlop, 891606461, false, (String) objArr48[0], null);
            }
            ((Field) objAccessartificialFrame14).set(null, objArr2);
            try {
                Long lValueOf5 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame15 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                if (objAccessartificialFrame15 == null) {
                    int deadChar = KeyEvent.getDeadChar(0, 0) + 25;
                    char c4 = (char) (30068 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)));
                    int iGreen = Color.green(0) + 816;
                    byte[] bArr20 = $$a;
                    Object[] objArr49 = new Object[1];
                    e((byte) 47, bArr20[21], bArr20[18], objArr49);
                    objAccessartificialFrame15 = ArtificialStackFrames.coroutineCreation(deadChar, c4, iGreen, 721586079, false, (String) objArr49[0], null);
                }
                ((Field) objAccessartificialFrame15).set(null, lValueOf5);
            } catch (Exception unused3) {
                throw new RuntimeException();
            }
        } else {
            Object objAccessartificialFrame16 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame16 == null) {
                int mode = View.MeasureSpec.getMode(0) + 25;
                char packedPositionType3 = (char) (30068 - ExpandableListView.getPackedPositionType(0L));
                int i61 = (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 815;
                byte[] bArr21 = $$a;
                Object[] objArr50 = new Object[1];
                e((byte) 47, bArr21[11], bArr21[18], objArr50);
                objAccessartificialFrame16 = ArtificialStackFrames.coroutineCreation(mode, packedPositionType3, i61, 891606461, false, (String) objArr50[0], null);
            }
            Object[] objArr51 = (Object[]) ((Field) objAccessartificialFrame16).get(null);
            objArr2 = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i62 = ((int[]) objArr51[0])[0];
            int i63 = ((int[]) objArr51[1])[0];
            String[] strArr9 = (String[]) objArr51[2];
            int iIdentityHashCode3 = System.identityHashCode(this);
            int i64 = ~iIdentityHashCode3;
            int i65 = (((912986639 + (((~(229784184 | i64)) | (~((-427956551) | iIdentityHashCode3))) * 1900)) + (((~(i64 | 427956550)) | (~(iIdentityHashCode3 | (-229784185)))) * (-950))) + (((~(iIdentityHashCode3 | 427956550)) | (~(i64 | (-229784185)))) * 950)) - 834127482;
            int i66 = (i65 << 13) ^ i65;
            int i67 = i66 ^ (i66 >>> 17);
            ((int[]) objArr2[3])[0] = i67 ^ (i67 << 5);
        }
        int i68 = ((int[]) objArr2[1])[0];
        int i69 = ((int[]) objArr2[0])[0];
        if (i69 == i68) {
            Object[] objArr52 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i70 = ((int[]) objArr2[3])[0];
            int i71 = ((int[]) objArr2[0])[0];
            int i72 = ((int[]) objArr2[1])[0];
            String[] strArr10 = (String[]) objArr2[2];
            int i73 = ~System.identityHashCode(this);
            int i74 = i70 + (-1328219251) + (((~(i73 | 456661476)) | 71311890) * (-160)) + (((~(i73 | 258489110)) | 456661476) * SyslogConstants.LOG_LOCAL4);
            int i75 = (i74 << 13) ^ i74;
            int i76 = i75 ^ (i75 >>> 17);
            ((int[]) objArr52[3])[0] = i76 ^ (i76 << 5);
        } else {
            ArrayList arrayList3 = new ArrayList();
            String[] strArr11 = (String[]) objArr2[2];
            if (strArr11 != null) {
                for (String str9 : strArr11) {
                    arrayList3.add(str9);
                }
            }
            Object[] objArr53 = {Long.valueOf(((long) (i68 ^ i69)) ^ (((long) 2122672037) << 32)), Long.valueOf(2122672036)};
            byte[] bArr22 = $$d;
            Object[] objArr54 = new Object[1];
            f((byte) (bArr22[219] + 1), (byte) (-bArr22[70]), (short) TypedValues.PositionType.TYPE_DRAWPATH, objArr54);
            Class<?> cls7 = Class.forName((String) objArr54[0]);
            byte b8 = (byte) (-bArr22[640]);
            byte b9 = bArr22[75];
            Object[] objArr55 = new Object[1];
            f(b8, b9, (short) (b9 | 645), objArr55);
            cls7.getMethod((String) objArr55[0], Long.TYPE, Long.TYPE).invoke(null, objArr53);
            Object[] objArr56 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i77 = ((int[]) objArr2[3])[0];
            int i78 = ((int[]) objArr2[0])[0];
            int i79 = ((int[]) objArr2[1])[0];
            String[] strArr12 = (String[]) objArr2[2];
            int iIdentityHashCode4 = System.identityHashCode(this);
            int i80 = 177644631 + (((-217572311) | iIdentityHashCode4) * 614);
            int i81 = ~iIdentityHashCode4;
            int i82 = i77 + i80 + (((~((-795078011) | i81)) | 587205672 | (~((-596905645) | i81))) * (-1228)) + (((~(i81 | (-9699973))) | (~((-207872339) | i81))) * 614);
            int i83 = (i82 << 13) ^ i82;
            int i84 = i83 ^ (i83 >>> 17);
            ((int[]) objArr56[3])[0] = i84 ^ (i84 << 5);
        }
        Object objAccessartificialFrame17 = ArtificialStackFrames.accessartificialFrame(1745676544);
        if (objAccessartificialFrame17 == null) {
            int i85 = (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 16;
            char packedPositionChild = (char) ((-1) - ExpandableListView.getPackedPositionChild(0L));
            int scrollBarFadeDuration = 747 - (ViewConfiguration.getScrollBarFadeDuration() >> 16);
            byte[] bArr23 = $$a;
            Object[] objArr57 = new Object[1];
            e((byte) 47, bArr23[21], bArr23[18], objArr57);
            objAccessartificialFrame17 = ArtificialStackFrames.coroutineCreation(i85, packedPositionChild, scrollBarFadeDuration, -144068856, false, (String) objArr57[0], null);
        }
        long j4 = ((Field) objAccessartificialFrame17).getLong(null);
        if (j4 == -1 || j4 + 1950 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Context baseContext3 = getBaseContext();
            if (baseContext3 == null) {
                Object[] objArr58 = new Object[1];
                d(1248954085 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 35), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 46, (short) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(17) - 4), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() - 692477913, objArr58);
                Class<?> cls8 = Class.forName((String) objArr58[0]);
                Object[] objArr59 = new Object[1];
                d(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 1248954051, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 35), TextUtils.lastIndexOf("", '0') - 24, (short) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(11) - 130), (-692477883) - (ViewConfiguration.getLongPressTimeout() >> 16), objArr59);
                baseContext3 = (Context) cls8.getMethod((String) objArr59[0], new Class[0]).invoke(null, null);
            }
            if (baseContext3 != null) {
                baseContext3 = ((baseContext3 instanceof ContextWrapper) && ((ContextWrapper) baseContext3).getBaseContext() == null) ? null : baseContext3.getApplicationContext();
            }
            Object[] objArr60 = {baseContext3, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 857873473};
            byte[] bArr24 = $$d;
            Object[] objArr61 = new Object[1];
            f(bArr24[685], (byte) (-bArr24[70]), (short) 464, objArr61);
            Class<?> cls9 = Class.forName((String) objArr61[0]);
            Object[] objArr62 = new Object[1];
            f((byte) (bArr24[205] + 1), bArr24[152], (short) 418, objArr62);
            objArr3 = (Object[]) cls9.getMethod((String) objArr62[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr60);
            Object objAccessartificialFrame18 = ArtificialStackFrames.accessartificialFrame(1575402270);
            if (objAccessartificialFrame18 == null) {
                int i86 = 17 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                char trimmedLength3 = (char) TextUtils.getTrimmedLength("");
                int longPressTimeout2 = 747 - (ViewConfiguration.getLongPressTimeout() >> 16);
                byte[] bArr25 = $$a;
                Object[] objArr63 = new Object[1];
                e((byte) 47, bArr25[11], bArr25[18], objArr63);
                objAccessartificialFrame18 = ArtificialStackFrames.coroutineCreation(i86, trimmedLength3, longPressTimeout2, -1031537386, false, (String) objArr63[0], null);
            }
            ((Field) objAccessartificialFrame18).set(null, objArr3);
            try {
                Long lValueOf6 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame19 = ArtificialStackFrames.accessartificialFrame(1745676544);
                if (objAccessartificialFrame19 == null) {
                    int minimumFlingVelocity6 = (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 17;
                    char cAxisFromString2 = (char) ((-1) - MotionEvent.axisFromString(""));
                    int keyRepeatDelay = 747 - (ViewConfiguration.getKeyRepeatDelay() >> 16);
                    byte[] bArr26 = $$a;
                    Object[] objArr64 = new Object[1];
                    e((byte) 47, bArr26[21], bArr26[18], objArr64);
                    objAccessartificialFrame19 = ArtificialStackFrames.coroutineCreation(minimumFlingVelocity6, cAxisFromString2, keyRepeatDelay, -144068856, false, (String) objArr64[0], null);
                }
                ((Field) objAccessartificialFrame19).set(null, lValueOf6);
            } catch (Exception unused4) {
                throw new RuntimeException();
            }
        } else {
            Object objAccessartificialFrame20 = ArtificialStackFrames.accessartificialFrame(1575402270);
            if (objAccessartificialFrame20 == null) {
                int scrollDefaultDelay = (ViewConfiguration.getScrollDefaultDelay() >> 16) + 17;
                char cAxisFromString3 = (char) ((-1) - MotionEvent.axisFromString(""));
                int i87 = 747 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                byte[] bArr27 = $$a;
                Object[] objArr65 = new Object[1];
                e((byte) 47, bArr27[11], bArr27[18], objArr65);
                objAccessartificialFrame20 = ArtificialStackFrames.coroutineCreation(scrollDefaultDelay, cAxisFromString3, i87, -1031537386, false, (String) objArr65[0], null);
            }
            Object[] objArr66 = (Object[]) ((Field) objAccessartificialFrame20).get(null);
            objArr3 = new Object[]{list, new int[1], list, new int[]{i}, new int[]{i}};
            int i88 = ((int[]) objArr66[3])[0];
            int i89 = ((int[]) objArr66[4])[0];
            List list = (List) objArr66[0];
            List list2 = (List) objArr66[2];
            int i90 = ~((((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 1695574679) | 76306450);
            int i91 = ((453396709 | i90) * (-658)) + 790067465 + ((i90 | 453116133) * 658) + 857873473;
            int i92 = (i91 << 13) ^ i91;
            int i93 = i92 ^ (i92 >>> 17);
            ((int[]) objArr3[1])[0] = i93 ^ (i93 << 5);
        }
        int i94 = ((int[]) objArr3[4])[0];
        int i95 = ((int[]) objArr3[3])[0];
        if (i95 == i94) {
            Object[] objArr67 = {list, new int[1], list, new int[]{i}, new int[]{i}};
            int i96 = ((int[]) objArr3[1])[0];
            int i97 = ((int[]) objArr3[3])[0];
            int i98 = ((int[]) objArr3[4])[0];
            List list3 = (List) objArr3[0];
            List list4 = (List) objArr3[2];
            int iIdentityHashCode5 = System.identityHashCode(this);
            int i99 = i96 + (((574742169 + (((~((-185279080) | iIdentityHashCode5)) | 151716386) * 1504)) + ((~(iIdentityHashCode5 | (-33562694))) * (-1504))) - 517471568);
            int i100 = (i99 << 13) ^ i99;
            int i101 = i100 ^ (i100 >>> 17);
            i3 = 0;
            ((int[]) objArr67[1])[0] = i101 ^ (i101 << 5);
        } else {
            ArrayList arrayList4 = new ArrayList();
            Object[] objArr68 = {objArr3};
            Object objAccessartificialFrame21 = ArtificialStackFrames.accessartificialFrame(1804664566);
            if (objAccessartificialFrame21 == null) {
                objAccessartificialFrame21 = ArtificialStackFrames.coroutineCreation((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 40, (char) (12469 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1))), View.MeasureSpec.getSize(0) + 3642, -185222914, false, "coroutineCreation", new Class[]{Object[].class});
            }
            arrayList4.add(((Method) objAccessartificialFrame21).invoke(null, objArr68));
            Object[] objArr69 = {objArr3};
            Object objAccessartificialFrame22 = ArtificialStackFrames.accessartificialFrame(-1243809191);
            if (objAccessartificialFrame22 == null) {
                objAccessartificialFrame22 = ArtificialStackFrames.coroutineCreation(TextUtils.getTrimmedLength("") + 41, (char) ((ViewConfiguration.getWindowTouchSlop() >> 8) + 12468), 3642 - Color.red(0), 716815441, false, "ArtificialStackFrames", new Class[]{Object[].class});
            }
            arrayList4.add(((Method) objAccessartificialFrame22).invoke(null, objArr69));
            long j5 = (((long) 639419959) << 32) ^ ((long) (i94 ^ i95));
            long j6 = 639419967;
            int i102 = getARTIFICIAL_FRAME_PACKAGE_NAME + 65;
            artificialFrame = i102 % 128;
            int i103 = i102 % 2;
            Object[] objArr70 = {Long.valueOf(j5), Long.valueOf(j6)};
            byte[] bArr28 = $$d;
            Object[] objArr71 = new Object[1];
            f(bArr28[29], (byte) (-bArr28[70]), (short) 399, objArr71);
            Class<?> cls10 = Class.forName((String) objArr71[0]);
            byte b10 = (byte) (-bArr28[640]);
            byte b11 = bArr28[75];
            Object[] objArr72 = new Object[1];
            f(b10, b11, (short) (b11 | 645), objArr72);
            cls10.getMethod((String) objArr72[0], Long.TYPE, Long.TYPE).invoke(null, objArr70);
            Object[] objArr73 = {list, new int[1], list, new int[]{i}, new int[]{i}};
            int i104 = ((int[]) objArr3[1])[0];
            int i105 = ((int[]) objArr3[3])[0];
            int i106 = ((int[]) objArr3[4])[0];
            List list5 = (List) objArr3[0];
            List list6 = (List) objArr3[2];
            int i107 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().navigation;
            int i108 = i104 + (-1157372748) + (((~((-4260365) | i107)) | (~(601188093 | i107))) * 69) + (((~(i107 | 4268781)) | (~((-601179677) | i107)) | 596919312) * (-69)) + 580773;
            int i109 = (i108 << 13) ^ i108;
            int i110 = i109 ^ (i109 >>> 17);
            i3 = 0;
            ((int[]) objArr73[1])[0] = i110 ^ (i110 << 5);
        }
        Object objAccessartificialFrame23 = ArtificialStackFrames.accessartificialFrame(1056123296);
        if (objAccessartificialFrame23 == null) {
            int modifierMetaStateMask = ((byte) KeyEvent.getModifierMetaStateMask()) + Ascii.US;
            char cIndexOf = (char) (49362 - TextUtils.indexOf("", "", i3, i3));
            int offsetAfter = TextUtils.getOffsetAfter("", i3) + 684;
            byte[] bArr29 = $$a;
            Object[] objArr74 = new Object[1];
            e((byte) (bArr29[84] + 1), (byte) ($$b & 62), bArr29[28], objArr74);
            objAccessartificialFrame23 = ArtificialStackFrames.coroutineCreation(modifierMetaStateMask, cIndexOf, offsetAfter, -1583976536, false, (String) objArr74[0], null);
        }
        long j7 = ((Field) objAccessartificialFrame23).getLong(null);
        if (j7 == -1 || j7 + 2022 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Object[] objArr75 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), -1960876810};
            byte[] bArr30 = $$d;
            Object[] objArr76 = new Object[1];
            f(bArr30[181], (byte) (-bArr30[70]), (short) 336, objArr76);
            Class<?> cls11 = Class.forName((String) objArr76[0]);
            Object[] objArr77 = new Object[1];
            f(bArr30[9], (byte) (-bArr30[70]), (short) 283, objArr77);
            objArr4 = (Object[]) cls11.getMethod((String) objArr77[0], Integer.TYPE, Integer.TYPE).invoke(null, objArr75);
            Object objAccessartificialFrame24 = ArtificialStackFrames.accessartificialFrame(910856866);
            if (objAccessartificialFrame24 == null) {
                int iLastIndexOf2 = 29 - TextUtils.lastIndexOf("", '0', 0, 0);
                char size = (char) (View.MeasureSpec.getSize(0) + 49362);
                int iIndexOf3 = 684 - TextUtils.indexOf("", "");
                byte b12 = (byte) 40;
                Object[] objArr78 = new Object[1];
                e(b12, (byte) (b12 - 2), $$a[18], objArr78);
                objAccessartificialFrame24 = ArtificialStackFrames.coroutineCreation(iLastIndexOf2, size, iIndexOf3, -1456483158, false, (String) objArr78[0], null);
            }
            ((Field) objAccessartificialFrame24).set(null, objArr4);
            try {
                Long lValueOf7 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame25 = ArtificialStackFrames.accessartificialFrame(1056123296);
                if (objAccessartificialFrame25 == null) {
                    int defaultSize = 30 - View.getDefaultSize(0, 0);
                    char c5 = (char) (49363 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)));
                    int iNormalizeMetaState2 = 684 - KeyEvent.normalizeMetaState(0);
                    byte[] bArr31 = $$a;
                    Object[] objArr79 = new Object[1];
                    e((byte) (bArr31[84] + 1), (byte) ($$b & 62), bArr31[28], objArr79);
                    objAccessartificialFrame25 = ArtificialStackFrames.coroutineCreation(defaultSize, c5, iNormalizeMetaState2, -1583976536, false, (String) objArr79[0], null);
                }
                ((Field) objAccessartificialFrame25).set(null, lValueOf7);
            } catch (Exception unused5) {
                throw new RuntimeException();
            }
        } else {
            Object objAccessartificialFrame26 = ArtificialStackFrames.accessartificialFrame(910856866);
            if (objAccessartificialFrame26 == null) {
                int tapTimeout4 = 30 - (ViewConfiguration.getTapTimeout() >> 16);
                char packedPositionType4 = (char) (49362 - ExpandableListView.getPackedPositionType(0L));
                int keyRepeatTimeout2 = (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 684;
                byte b13 = (byte) 40;
                Object[] objArr80 = new Object[1];
                e(b13, (byte) (b13 - 2), $$a[18], objArr80);
                objAccessartificialFrame26 = ArtificialStackFrames.coroutineCreation(tapTimeout4, packedPositionType4, keyRepeatTimeout2, -1456483158, false, (String) objArr80[0], null);
            }
            Object[] objArr81 = (Object[]) ((Field) objAccessartificialFrame26).get(null);
            objArr4 = new Object[]{new int[]{((int[]) objArr81[0])[0]}, new int[]{((int[]) objArr81[1])[0]}, new int[1], (String) objArr81[3]};
            int iCodePointAt = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) - 1064281232;
            int i111 = ~iCodePointAt;
            int i112 = (((-640431109) + (((~((-898023592) | i111)) | (~(iCodePointAt | 80600183))) * 333)) + (((~(iCodePointAt | (-898023592))) | (~(i111 | 80600183))) * 333)) - 1960876810;
            int i113 = (i112 << 13) ^ i112;
            int i114 = i113 ^ (i113 >>> 17);
            ((int[]) objArr4[2])[0] = i114 ^ (i114 << 5);
        }
        int i115 = ((int[]) objArr4[1])[0];
        int i116 = ((int[]) objArr4[0])[0];
        if (i116 == i115) {
            int i117 = ((int[]) objArr4[2])[0];
            Object[] objArr82 = {new int[]{((int[]) objArr4[0])[0]}, new int[]{((int[]) objArr4[1])[0]}, new int[1], (String) objArr4[3]};
            int iMyPid = Process.myPid();
            int i118 = 108783586 + (((~((~iMyPid) | (-119396650))) | 67704840) * (-245));
            int i119 = ~(iMyPid | (-119396650));
            int i120 = i117 + i118 + (i119 * (-245)) + ((i119 | 859227125) * 245);
            int i121 = (i120 << 13) ^ i120;
            int i122 = i121 ^ (i121 >>> 17);
            ((int[]) objArr82[2])[0] = i122 ^ (i122 << 5);
        } else {
            new ArrayList().add((String) objArr4[3]);
            Object[] objArr83 = {Long.valueOf((((long) (-548501792)) << 32) ^ ((long) (i115 ^ i116))), Long.valueOf(-548501776)};
            byte[] bArr32 = $$d;
            Object[] objArr84 = new Object[1];
            f(bArr32[17], (byte) (-bArr32[70]), (short) 267, objArr84);
            Class<?> cls12 = Class.forName((String) objArr84[0]);
            byte b14 = (byte) (-bArr32[640]);
            byte b15 = bArr32[75];
            Object[] objArr85 = new Object[1];
            f(b14, b15, (short) (b15 | 645), objArr85);
            cls12.getMethod((String) objArr85[0], Long.TYPE, Long.TYPE).invoke(null, objArr83);
            int i123 = ((int[]) objArr4[2])[0];
            Object[] objArr86 = {new int[]{((int[]) objArr4[0])[0]}, new int[]{((int[]) objArr4[1])[0]}, new int[1], (String) objArr4[3]};
            int i124 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().mcc;
            int i125 = i123 + (-435611584) + (((~((-6365473) | i124)) | (~(972258302 | i124))) * 69) + (((~(i124 | 32715698)) | (~((-945908077) | i124)) | 939542604) * (-69)) + 1818165594;
            int i126 = (i125 << 13) ^ i125;
            int i127 = i126 ^ (i126 >>> 17);
            ((int[]) objArr86[2])[0] = i127 ^ (i127 << 5);
        }
        Object objAccessartificialFrame27 = ArtificialStackFrames.accessartificialFrame(-2127922582);
        if (objAccessartificialFrame27 == null) {
            int iMyTid = 30 - (Process.myTid() >> 22);
            char cRed = (char) (49362 - Color.red(0));
            int tapTimeout5 = 684 - (ViewConfiguration.getTapTimeout() >> 16);
            byte b16 = (byte) 45;
            Object[] objArr87 = new Object[1];
            e(b16, (byte) (b16 + 1), $$a[28], objArr87);
            objAccessartificialFrame27 = ArtificialStackFrames.coroutineCreation(iMyTid, cRed, tapTimeout5, 508509282, false, (String) objArr87[0], null);
        }
        long j8 = ((Field) objAccessartificialFrame27).getLong(null);
        if (j8 != -1) {
            int i128 = artificialFrame + 15;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i128 % 128;
            int i129 = i128 % 2;
            if (j8 + 2050 >= ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame28 = ArtificialStackFrames.accessartificialFrame(777251007);
                if (objAccessartificialFrame28 == null) {
                    int iKeyCodeFromString2 = 30 - KeyEvent.keyCodeFromString("");
                    char doubleTapTimeout = (char) (49362 - (ViewConfiguration.getDoubleTapTimeout() >> 16));
                    int absoluteGravity3 = 684 - Gravity.getAbsoluteGravity(0, 0);
                    byte[] bArr33 = $$a;
                    Object[] objArr88 = new Object[1];
                    e((byte) (-bArr33[15]), (byte) 58, bArr33[49], objArr88);
                    objAccessartificialFrame28 = ArtificialStackFrames.coroutineCreation(iKeyCodeFromString2, doubleTapTimeout, absoluteGravity3, -1321816393, false, (String) objArr88[0], null);
                }
                Object[] objArr89 = (Object[]) ((Field) objAccessartificialFrame28).get(null);
                objArr5 = new Object[]{new int[]{((int[]) objArr89[0])[0]}, new int[]{((int[]) objArr89[1])[0]}, new int[1], (String) objArr89[3]};
                int iCodePointAt2 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(14) + 156529241;
                int i130 = ((((~((-451393428) | iCodePointAt2)) | 93016600) * 262) - 567857172) + (((~((~iCodePointAt2) | (-451393428))) | 93016600) * 262) + 1579242124;
                int i131 = (i130 << 13) ^ i130;
                int i132 = i131 ^ (i131 >>> 17);
                ((int[]) objArr5[2])[0] = i132 ^ (i132 << 5);
            } else {
                baseContext2 = getBaseContext();
                if (baseContext2 == null) {
                    Object[] objArr90 = new Object[1];
                    d(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 1248954049, (byte) (TextUtils.indexOf((CharSequence) "", '0', 0) + 1), (-24) - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), (short) (Gravity.getAbsoluteGravity(0, 0) + 101), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 692477913, objArr90);
                    Class<?> cls13 = Class.forName((String) objArr90[0]);
                    Object[] objArr91 = new Object[1];
                    d(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 1248954082, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 21), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 60, (short) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(16) - 135), ExpandableListView.getPackedPositionChild(0L) - 692477882, objArr91);
                    baseContext2 = (Context) cls13.getMethod((String) objArr91[0], new Class[0]).invoke(null, null);
                }
                if (baseContext2 != null) {
                    if ((baseContext2 instanceof ContextWrapper) || ((ContextWrapper) baseContext2).getBaseContext() != null) {
                        baseContext2 = baseContext2.getApplicationContext();
                    } else {
                        baseContext2 = null;
                    }
                }
                Object[] objArr92 = {baseContext2, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 1579242124};
                byte[] bArr34 = $$d;
                Object[] objArr93 = new Object[1];
                f(bArr34[569], (byte) (-bArr34[70]), (short) 243, objArr93);
                Class<?> cls14 = Class.forName((String) objArr93[0]);
                byte b17 = bArr34[205];
                Object[] objArr94 = new Object[1];
                f(b17, b17, (short) 587, objArr94);
                objArr5 = (Object[]) cls14.getMethod((String) objArr94[0], Context.class, Integer.TYPE, Integer.TYPE).invoke(null, objArr92);
                if (baseContext2 != null) {
                    objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(777251007);
                    if (objAccessartificialFrame6 == null) {
                        int windowTouchSlop2 = 30 - (ViewConfiguration.getWindowTouchSlop() >> 8);
                        char c6 = (char) (49363 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)));
                        int size2 = 684 - View.MeasureSpec.getSize(0);
                        byte[] bArr35 = $$a;
                        Object[] objArr95 = new Object[1];
                        e((byte) (-bArr35[15]), (byte) 58, bArr35[49], objArr95);
                        objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(windowTouchSlop2, c6, size2, -1321816393, false, (String) objArr95[0], null);
                    }
                    ((Field) objAccessartificialFrame6).set(null, objArr5);
                    try {
                        Long lValueOf8 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-2127922582);
                        if (objAccessartificialFrame7 == null) {
                            int edgeSlop3 = 30 - (ViewConfiguration.getEdgeSlop() >> 16);
                            char jumpTapTimeout = (char) (49362 - (ViewConfiguration.getJumpTapTimeout() >> 16));
                            int iIndexOf4 = TextUtils.indexOf("", "", 0) + 684;
                            byte b18 = (byte) 45;
                            Object[] objArr96 = new Object[1];
                            e(b18, (byte) (b18 + 1), $$a[28], objArr96);
                            objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(edgeSlop3, jumpTapTimeout, iIndexOf4, 508509282, false, (String) objArr96[0], null);
                        }
                        ((Field) objAccessartificialFrame7).set(null, lValueOf8);
                    } catch (Exception unused6) {
                        throw new RuntimeException();
                    }
                }
            }
        } else {
            baseContext2 = getBaseContext();
            if (baseContext2 == null) {
                Object[] objArr97 = new Object[1];
                d(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 1248954049, (byte) (TextUtils.indexOf((CharSequence) "", '0', 0) + 1), (-24) - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), (short) (Gravity.getAbsoluteGravity(0, 0) + 101), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 692477913, objArr97);
                Class<?> cls15 = Class.forName((String) objArr97[0]);
                Object[] objArr98 = new Object[1];
                d(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 1248954082, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 21), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 60, (short) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(16) - 135), ExpandableListView.getPackedPositionChild(0L) - 692477882, objArr98);
                baseContext2 = (Context) cls15.getMethod((String) objArr98[0], new Class[0]).invoke(null, null);
            }
            if (baseContext2 != null) {
                if (baseContext2 instanceof ContextWrapper) {
                    baseContext2 = baseContext2.getApplicationContext();
                } else {
                    baseContext2 = baseContext2.getApplicationContext();
                }
            }
            Object[] objArr99 = {baseContext2, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 1579242124};
            byte[] bArr36 = $$d;
            Object[] objArr910 = new Object[1];
            f(bArr36[569], (byte) (-bArr36[70]), (short) 243, objArr910);
            Class<?> cls16 = Class.forName((String) objArr910[0]);
            byte b19 = bArr36[205];
            Object[] objArr911 = new Object[1];
            f(b19, b19, (short) 587, objArr911);
            objArr5 = (Object[]) cls16.getMethod((String) objArr911[0], Context.class, Integer.TYPE, Integer.TYPE).invoke(null, objArr99);
            if (baseContext2 != null) {
                objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(777251007);
                if (objAccessartificialFrame6 == null) {
                    int windowTouchSlop3 = 30 - (ViewConfiguration.getWindowTouchSlop() >> 8);
                    char c7 = (char) (49363 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)));
                    int size3 = 684 - View.MeasureSpec.getSize(0);
                    byte[] bArr37 = $$a;
                    Object[] objArr912 = new Object[1];
                    e((byte) (-bArr37[15]), (byte) 58, bArr37[49], objArr912);
                    objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(windowTouchSlop3, c7, size3, -1321816393, false, (String) objArr912[0], null);
                }
                ((Field) objAccessartificialFrame6).set(null, objArr5);
                Long lValueOf9 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-2127922582);
                if (objAccessartificialFrame7 == null) {
                    int edgeSlop4 = 30 - (ViewConfiguration.getEdgeSlop() >> 16);
                    char jumpTapTimeout2 = (char) (49362 - (ViewConfiguration.getJumpTapTimeout() >> 16));
                    int iIndexOf5 = TextUtils.indexOf("", "", 0) + 684;
                    byte b110 = (byte) 45;
                    Object[] objArr913 = new Object[1];
                    e(b110, (byte) (b110 + 1), $$a[28], objArr913);
                    objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(edgeSlop4, jumpTapTimeout2, iIndexOf5, 508509282, false, (String) objArr913[0], null);
                }
                ((Field) objAccessartificialFrame7).set(null, lValueOf9);
            }
        }
        int i133 = ((int[]) objArr5[1])[0];
        int i134 = ((int[]) objArr5[0])[0];
        if (i134 == i133) {
            int i135 = getARTIFICIAL_FRAME_PACKAGE_NAME + 113;
            artificialFrame = i135 % 128;
            int i136 = i135 % 2;
            int i137 = ((int[]) objArr5[2])[0];
            Object[] objArr100 = {new int[]{((int[]) objArr5[0])[0]}, new int[]{((int[]) objArr5[1])[0]}, new int[1], (String) objArr5[3]};
            int i138 = ~System.identityHashCode(this);
            int i139 = i137 + 1300475790 + (((~(i138 | 1052602299)) | (~((-524953) | i138))) * (-184)) + ((1015350561 | (~((-1015875514) | i138)) | (~(37251738 | i138))) * SyslogConstants.LOG_LOCAL7) + 1832205784;
            int i140 = (i139 << 13) ^ i139;
            int i141 = i140 ^ (i140 >>> 17);
            ((int[]) objArr100[2])[0] = i141 ^ (i141 << 5);
            i4 = 0;
        } else {
            Object[] objArr101 = {Long.valueOf((((long) 1800785131) << 32) ^ ((long) (i133 ^ i134))), Long.valueOf(1800785643)};
            byte[] bArr38 = $$d;
            Object[] objArr102 = new Object[1];
            f(bArr38[442], (byte) (-bArr38[70]), (short) 181, objArr102);
            Class<?> cls17 = Class.forName((String) objArr102[0]);
            byte b20 = (byte) (-bArr38[640]);
            byte b21 = bArr38[75];
            Object[] objArr103 = new Object[1];
            f(b20, b21, (short) (b21 | 645), objArr103);
            cls17.getMethod((String) objArr103[0], Long.TYPE, Long.TYPE).invoke(null, objArr101);
            int i142 = ((int[]) objArr5[2])[0];
            Object[] objArr104 = {new int[]{((int[]) objArr5[0])[0]}, new int[]{((int[]) objArr5[1])[0]}, new int[1], (String) objArr5[3]};
            int length = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 1231417450;
            int i143 = i142 + (((~((-824197657) | length)) | 530566) * TypedValues.PositionType.TYPE_TRANSITION_EASING) + 106644968 + ((~((~length) | (-824197657))) * TypedValues.PositionType.TYPE_TRANSITION_EASING);
            int i144 = (i143 << 13) ^ i143;
            int i145 = i144 ^ (i144 >>> 17);
            i4 = 0;
            ((int[]) objArr104[2])[0] = i145 ^ (i145 << 5);
        }
        Object objAccessartificialFrame29 = ArtificialStackFrames.accessartificialFrame(-1168947751);
        if (objAccessartificialFrame29 == null) {
            int i146 = 37 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
            char cResolveOpacity = (char) Drawable.resolveOpacity(i4, i4);
            int packedPositionGroup2 = 540 - ExpandableListView.getPackedPositionGroup(0L);
            byte[] bArr39 = $$a;
            Object[] objArr105 = new Object[1];
            e((byte) 47, bArr39[21], bArr39[18], objArr105);
            objAccessartificialFrame29 = ArtificialStackFrames.coroutineCreation(i146, cResolveOpacity, packedPositionGroup2, 624296913, false, (String) objArr105[0], null);
        }
        long j9 = ((Field) objAccessartificialFrame29).getLong(null);
        if (j9 == -1 || j9 + 1951 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Object objAccessartificialFrame30 = ArtificialStackFrames.accessartificialFrame(-1717965552);
            if (objAccessartificialFrame30 == null) {
                objAccessartificialFrame30 = ArtificialStackFrames.coroutineCreation(20 - (ViewConfiguration.getDoubleTapTimeout() >> 16), (char) (39516 - (ViewConfiguration.getMinimumFlingVelocity() >> 16)), (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 982, 117222168, false, null, new Class[0]);
            }
            Object[] objArr106 = {null, ((Constructor) objAccessartificialFrame30).newInstance(null), 995038506, 0};
            Object objAccessartificialFrame31 = ArtificialStackFrames.accessartificialFrame(-501205803);
            if (objAccessartificialFrame31 == null) {
                int iIndexOf6 = TextUtils.indexOf((CharSequence) "", '0') + 37;
                char cIndexOf2 = (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0'));
                int i147 = 541 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                byte b22 = $$a[5];
                byte b23 = (byte) (b22 - 1);
                Object[] objArr107 = new Object[1];
                e(b23, (byte) (b23 | 65), (byte) (b22 - 1), objArr107);
                objAccessartificialFrame31 = ArtificialStackFrames.coroutineCreation(iIndexOf6, cIndexOf2, i147, 2101703389, false, (String) objArr107[0], new Class[]{(Class) ArtificialStackFrames.coroutineCreation(54 - Drawable.resolveOpacity(0, 0), (char) (881 - AndroidCharacter.getMirror('0')), 576 - (ViewConfiguration.getLongPressTimeout() >> 16)), (Class) ArtificialStackFrames.coroutineCreation(View.MeasureSpec.getSize(0) + 54, (char) View.MeasureSpec.makeMeasureSpec(0, 0), 630 - View.MeasureSpec.makeMeasureSpec(0, 0)), Integer.TYPE, Integer.TYPE});
            }
            objArr6 = (Object[]) ((Method) objAccessartificialFrame31).invoke(null, objArr106);
            Object objAccessartificialFrame32 = ArtificialStackFrames.accessartificialFrame(-1339222025);
            if (objAccessartificialFrame32 == null) {
                int iBlue = Color.blue(0) + 36;
                char edgeSlop5 = (char) (ViewConfiguration.getEdgeSlop() >> 16);
                int keyRepeatDelay2 = 540 - (ViewConfiguration.getKeyRepeatDelay() >> 16);
                byte[] bArr40 = $$a;
                Object[] objArr108 = new Object[1];
                e((byte) 47, bArr40[11], bArr40[18], objArr108);
                objAccessartificialFrame32 = ArtificialStackFrames.coroutineCreation(iBlue, edgeSlop5, keyRepeatDelay2, 793268735, false, (String) objArr108[0], null);
            }
            ((Field) objAccessartificialFrame32).set(null, objArr6);
            try {
                Long lValueOf10 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame33 = ArtificialStackFrames.accessartificialFrame(-1168947751);
                if (objAccessartificialFrame33 == null) {
                    int mode2 = View.MeasureSpec.getMode(0) + 36;
                    char offsetAfter2 = (char) TextUtils.getOffsetAfter("", 0);
                    int iMyPid2 = 540 - (Process.myPid() >> 22);
                    byte[] bArr41 = $$a;
                    Object[] objArr109 = new Object[1];
                    e((byte) 47, bArr41[21], bArr41[18], objArr109);
                    objAccessartificialFrame33 = ArtificialStackFrames.coroutineCreation(mode2, offsetAfter2, iMyPid2, 624296913, false, (String) objArr109[0], null);
                }
                ((Field) objAccessartificialFrame33).set(null, lValueOf10);
            } catch (Exception unused7) {
                throw new RuntimeException();
            }
        } else {
            Object objAccessartificialFrame34 = ArtificialStackFrames.accessartificialFrame(-1339222025);
            if (objAccessartificialFrame34 == null) {
                int minimumFlingVelocity7 = 36 - (ViewConfiguration.getMinimumFlingVelocity() >> 16);
                char c8 = (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1));
                int i148 = 540 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                byte[] bArr42 = $$a;
                Object[] objArr111 = new Object[1];
                e((byte) 47, bArr42[11], bArr42[18], objArr111);
                objAccessartificialFrame34 = ArtificialStackFrames.coroutineCreation(minimumFlingVelocity7, c8, i148, 793268735, false, (String) objArr111[0], null);
            }
            Object[] objArr112 = (Object[]) ((Field) objAccessartificialFrame34).get(null);
            objArr6 = new Object[]{new int[1], new int[1], new int[1]};
            int i149 = ((int[]) objArr112[2])[0];
            int i150 = ((int[]) objArr112[1])[0];
            ((int[]) objArr6[2])[0] = i149;
            ((int[]) objArr6[1])[0] = i150;
            int i151 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().uiMode;
            int i152 = (((~((~i151) | (-639899666))) * 130) - 1144836853) + (((~(i151 | (-639899666))) | 139182692) * 130) + 995038506;
            int i153 = (i152 << 13) ^ i152;
            int i154 = i153 ^ (i153 >>> 17);
            ((int[]) objArr6[0])[0] = i154 ^ (i154 << 5);
        }
        Object obj = objArr6[1];
        int i155 = ((int[]) obj)[0];
        Object obj2 = objArr6[2];
        int i156 = ((int[]) obj2)[0];
        if (i156 == i155) {
            int i157 = artificialFrame + 43;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i157 % 128;
            int i158 = i157 % 2;
            Object[] objArr113 = {new int[1], new int[1], new int[1]};
            int i159 = ((int[]) objArr6[0])[0];
            int i160 = ((int[]) obj2)[0];
            int i161 = ((int[]) obj)[0];
            ((int[]) objArr113[2])[0] = i160;
            ((int[]) objArr113[1])[0] = i161;
            int iCodePointAt3 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(0) - 929313149;
            int i162 = ~iCodePointAt3;
            int i163 = i159 + 273629197 + (((~((-534534666) | i162)) | 277889544 | (~((-817087085) | i162))) * (-1136)) + (((~((-534534666) | iCodePointAt3)) | (~((-817087085) | iCodePointAt3)) | (~(1073732205 | i162))) * (-568)) + (((~(iCodePointAt3 | (-277889545))) | (~(i162 | 817087084)) | (~(534534665 | i162))) * 568);
            int i164 = (i163 << 13) ^ i163;
            int i165 = i164 ^ (i164 >>> 17);
            i5 = 0;
            ((int[]) objArr113[0])[0] = i165 ^ (i165 << 5);
        } else {
            long j10 = (((long) 1082815923) << 32) ^ ((long) (i155 ^ i156));
            long j11 = 1082811827;
            int i166 = artificialFrame + 69;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i166 % 128;
            int i167 = i166 % 2;
            Object[] objArr114 = {Long.valueOf(j10), Long.valueOf(j11)};
            byte[] bArr43 = $$d;
            Object[] objArr115 = new Object[1];
            f(bArr43[442], (byte) (-bArr43[70]), (short) 181, objArr115);
            Class<?> cls18 = Class.forName((String) objArr115[0]);
            byte b24 = (byte) (-bArr43[640]);
            byte b25 = bArr43[75];
            Object[] objArr116 = new Object[1];
            f(b24, b25, (short) (b25 | 645), objArr116);
            cls18.getMethod((String) objArr116[0], Long.TYPE, Long.TYPE).invoke(null, objArr114);
            Object[] objArr117 = {new int[1], new int[1], new int[1]};
            int i168 = ((int[]) objArr6[0])[0];
            int i169 = ((int[]) objArr6[2])[0];
            int i170 = ((int[]) objArr6[1])[0];
            ((int[]) objArr117[2])[0] = i169;
            ((int[]) objArr117[1])[0] = i170;
            int i171 = ~((~((int) Process.getStartUptimeMillis())) | 548701582);
            int i172 = i168 + ((2359560 | i171) * (-970)) + 1969611017 + ((i171 | 546342022) * 970);
            int i173 = (i172 << 13) ^ i172;
            int i174 = i173 ^ (i173 >>> 17);
            i5 = 0;
            ((int[]) objArr117[0])[0] = i174 ^ (i174 << 5);
        }
        super.onStart();
        Object objAccessartificialFrame35 = ArtificialStackFrames.accessartificialFrame(-1283093189);
        if (objAccessartificialFrame35 == null) {
            int threadPriority = ((Process.getThreadPriority(i5) + 20) >> 6) + 30;
            char pressedStateDuration = (char) ((ViewConfiguration.getPressedStateDuration() >> 16) + 49362);
            int iLastIndexOf3 = 683 - TextUtils.lastIndexOf("", '0');
            Object[] objArr118 = new Object[1];
            e((byte) 45, (byte) 85, (byte) (-$$a[4]), objArr118);
            objAccessartificialFrame35 = ArtificialStackFrames.coroutineCreation(threadPriority, pressedStateDuration, iLastIndexOf3, 752929587, false, (String) objArr118[0], null);
        }
        long j12 = ((Field) objAccessartificialFrame35).getLong(null);
        if (j12 == -1 || j12 + 2043 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Context baseContext4 = getBaseContext();
            if (baseContext4 == null) {
                Object[] objArr119 = new Object[1];
                d(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 1248954049, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) - 36), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(1) - 126, (short) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 97), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 692477913, objArr119);
                Class<?> cls19 = Class.forName((String) objArr119[0]);
                Object[] objArr120 = new Object[1];
                d(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) + 1248954050, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) - 36), Color.alpha(0) - 25, (short) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(13) - 126), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(9) - 692477997, objArr120);
                baseContext4 = (Context) cls19.getMethod((String) objArr120[0], new Class[0]).invoke(null, null);
            }
            if (baseContext4 != null) {
                int i175 = artificialFrame + 27;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i175 % 128;
                if (i175 % 2 != 0) {
                    int i176 = 21 / 0;
                    if (baseContext4 instanceof ContextWrapper) {
                        if (((ContextWrapper) baseContext4).getBaseContext() != null) {
                            baseContext4 = null;
                        }
                    }
                } else if (baseContext4 instanceof ContextWrapper) {
                    if (((ContextWrapper) baseContext4).getBaseContext() != null) {
                        baseContext4 = null;
                    }
                }
                baseContext4 = baseContext4.getApplicationContext();
            }
            Object[] objArr121 = {baseContext4, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, -1014025372};
            byte[] bArr44 = $$d;
            Object[] objArr122 = new Object[1];
            f((byte) (-bArr44[19]), (byte) (-bArr44[70]), (short) 115, objArr122);
            Class<?> cls20 = Class.forName((String) objArr122[0]);
            Object[] objArr123 = new Object[1];
            f(bArr44[9], (byte) (-bArr44[70]), bArr44[65], objArr123);
            Object[] objArr124 = (Object[]) cls20.getMethod((String) objArr123[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr121);
            if (baseContext4 != null) {
                Object objAccessartificialFrame36 = ArtificialStackFrames.accessartificialFrame(-326560385);
                if (objAccessartificialFrame36 == null) {
                    int i177 = 31 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                    char c9 = (char) (49363 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)));
                    int i178 = 684 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                    byte[] bArr45 = $$a;
                    Object[] objArr125 = new Object[1];
                    e((byte) (bArr45[84] + 1), (byte) 100, (byte) (-bArr45[4]), objArr125);
                    objAccessartificialFrame36 = ArtificialStackFrames.coroutineCreation(i177, c9, i178, 1944867703, false, (String) objArr125[0], null);
                }
                ((Field) objAccessartificialFrame36).set(null, objArr124);
                try {
                    Long lValueOf11 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame37 = ArtificialStackFrames.accessartificialFrame(-1283093189);
                    if (objAccessartificialFrame37 == null) {
                        int iRgb = Color.rgb(0, 0, 0) + 16777246;
                        char minimumFlingVelocity8 = (char) ((ViewConfiguration.getMinimumFlingVelocity() >> 16) + 49362);
                        int iIndexOf7 = TextUtils.indexOf("", "", 0) + 684;
                        Object[] objArr126 = new Object[1];
                        e((byte) 45, (byte) 85, (byte) (-$$a[4]), objArr126);
                        objAccessartificialFrame37 = ArtificialStackFrames.coroutineCreation(iRgb, minimumFlingVelocity8, iIndexOf7, 752929587, false, (String) objArr126[0], null);
                    }
                    ((Field) objAccessartificialFrame37).set(null, lValueOf11);
                } catch (Exception unused8) {
                    throw new RuntimeException();
                }
            }
            objArr7 = objArr124;
        } else {
            Object objAccessartificialFrame38 = ArtificialStackFrames.accessartificialFrame(-326560385);
            if (objAccessartificialFrame38 == null) {
                int touchSlop = 30 - (ViewConfiguration.getTouchSlop() >> 8);
                char c10 = (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 49361);
                int iLastIndexOf4 = TextUtils.lastIndexOf("", '0') + 685;
                byte[] bArr46 = $$a;
                Object[] objArr127 = new Object[1];
                e((byte) (bArr46[84] + 1), (byte) 100, (byte) (-bArr46[4]), objArr127);
                objAccessartificialFrame38 = ArtificialStackFrames.coroutineCreation(touchSlop, c10, iLastIndexOf4, 1944867703, false, (String) objArr127[0], null);
            }
            Object[] objArr128 = (Object[]) ((Field) objAccessartificialFrame38).get(null);
            objArr7 = new Object[]{new int[]{((int[]) objArr128[0])[0]}, new int[]{((int[]) objArr128[1])[0]}, new int[1], (String) objArr128[3]};
            int iIdentityHashCode6 = System.identityHashCode(this);
            int i179 = ~iIdentityHashCode6;
            int i180 = ((((-1007608296) + ((731967736 | i179) * (-757))) + ((~((-68357127) | iIdentityHashCode6)) * 1514)) + (((~(iIdentityHashCode6 | 800324862)) | ((~(i179 | (-246656039))) | 178298912)) * 757)) - 1014025372;
            int i181 = (i180 << 13) ^ i180;
            int i182 = i181 ^ (i181 >>> 17);
            ((int[]) objArr7[2])[0] = i182 ^ (i182 << 5);
        }
        int i183 = ((int[]) objArr7[1])[0];
        int i184 = ((int[]) objArr7[0])[0];
        if (i184 == i183) {
            int i185 = ((int[]) objArr7[2])[0];
            Object[] objArr129 = {new int[]{((int[]) objArr7[0])[0]}, new int[]{((int[]) objArr7[1])[0]}, new int[1], (String) objArr7[3]};
            int iIdentityHashCode7 = System.identityHashCode(this);
            int i186 = (~((-477757743) | iIdentityHashCode7)) | 475660576;
            int i187 = ~((~iIdentityHashCode7) | 502963198);
            int i188 = i185 + 1200795102 + ((i186 | i187) * (-470)) + (((~(iIdentityHashCode7 | (-2097167))) | i187) * 470);
            int i189 = (i188 << 13) ^ i188;
            int i190 = i189 ^ (i189 >>> 17);
            ((int[]) objArr129[2])[0] = i190 ^ (i190 << 5);
            return;
        }
        Object[] objArr130 = {Long.valueOf(((long) (i183 ^ i184)) ^ (((long) 1725644712) << 32)), Long.valueOf(1725644716)};
        byte[] bArr47 = $$d;
        Object[] objArr131 = new Object[1];
        f((byte) (-bArr47[538]), (byte) (-bArr47[70]), bArr47[119], objArr131);
        Class<?> cls21 = Class.forName((String) objArr131[0]);
        byte b26 = (byte) (-bArr47[640]);
        byte b27 = bArr47[75];
        Object[] objArr132 = new Object[1];
        f(b26, b27, (short) (b27 | 645), objArr132);
        cls21.getMethod((String) objArr132[0], Long.TYPE, Long.TYPE).invoke(null, objArr130);
        int i191 = ((int[]) objArr7[2])[0];
        Object[] objArr133 = {new int[]{((int[]) objArr7[0])[0]}, new int[]{((int[]) objArr7[1])[0]}, new int[1], (String) objArr7[3]};
        int i192 = ~(((int) Runtime.getRuntime().maxMemory()) | 497939519);
        int i193 = i191 + (-1418264482) + (((-480684256) | i192) * (-220)) + ((i192 | (-498072832)) * 220) + 1927407680;
        int i194 = (i193 << 13) ^ i193;
        int i195 = i194 ^ (i194 >>> 17);
        ((int[]) objArr133[2])[0] = i195 ^ (i195 << 5);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onResume() throws Throwable {
        int i = 2 % 2;
        int i2 = artificialFrame + 83;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i2 % 128;
        Object obj = null;
        try {
            if (i2 % 2 != 0) {
                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(949068051);
                if (objAccessartificialFrame == null) {
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(TextUtils.getOffsetBefore("", 0) + 30, (char) ((Process.myPid() >> 22) + 49993), View.MeasureSpec.makeMeasureSpec(0, 0) + 74, -1477122277, false, "MediaDescriptionCompatApi23Builder", null);
                }
                Object obj2 = ((Field) objAccessartificialFrame).get(null);
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1579113874);
                if (objAccessartificialFrame2 == null) {
                    int iMyPid = 30 - (Process.myPid() >> 22);
                    char mode = (char) (49993 - View.MeasureSpec.getMode(0));
                    int scrollDefaultDelay = (ViewConfiguration.getScrollDefaultDelay() >> 16) + 74;
                    byte[] bArr = $$d;
                    Object[] objArr = new Object[1];
                    f(bArr[225], (byte) (bArr[205] + 1), bArr[75], objArr);
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iMyPid, mode, scrollDefaultDelay, -1048962150, false, (String) objArr[0], new Class[0]);
                }
                ((Method) objAccessartificialFrame2).invoke(obj2, null);
                super.onResume();
                int i3 = 79 / 0;
            } else {
                Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(949068051);
                if (objAccessartificialFrame3 == null) {
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getWindowTouchSlop() >> 8) + 30, (char) (49993 - (Process.myPid() >> 22)), 75 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), -1477122277, false, "MediaDescriptionCompatApi23Builder", null);
                }
                Object obj3 = ((Field) objAccessartificialFrame3).get(null);
                Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1579113874);
                if (objAccessartificialFrame4 == null) {
                    int offsetAfter = 30 - TextUtils.getOffsetAfter("", 0);
                    char mode2 = (char) (49993 - View.MeasureSpec.getMode(0));
                    int i4 = (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 73;
                    byte[] bArr2 = $$d;
                    Object[] objArr2 = new Object[1];
                    f(bArr2[225], (byte) (bArr2[205] + 1), bArr2[75], objArr2);
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(offsetAfter, mode2, i4, -1048962150, false, (String) objArr2[0], new Class[0]);
                }
                ((Method) objAccessartificialFrame4).invoke(obj3, null);
                super.onResume();
            }
            int i5 = getARTIFICIAL_FRAME_PACKAGE_NAME + 61;
            artificialFrame = i5 % 128;
            if (i5 % 2 != 0) {
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

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onPause() throws Throwable {
        int i = 2 % 2;
        int i2 = artificialFrame + 27;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i2 % 128;
        Object obj = null;
        if (i2 % 2 != 0) {
            Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(949068051);
            if (objAccessartificialFrame == null) {
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getTouchSlop() >> 8) + 30, (char) (TextUtils.lastIndexOf("", '0') + 49994), View.MeasureSpec.getSize(0) + 74, -1477122277, false, "MediaDescriptionCompatApi23Builder", null);
            }
            Object obj2 = ((Field) objAccessartificialFrame).get(null);
            try {
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1579114835);
                if (objAccessartificialFrame2 == null) {
                    int i3 = (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 31;
                    char c = (char) (49994 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)));
                    int iAlpha = Color.alpha(0) + 74;
                    byte[] bArr = $$d;
                    Object[] objArr = new Object[1];
                    f(bArr[225], (byte) (-bArr[70]), bArr[75], objArr);
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(i3, c, iAlpha, -1048959141, false, (String) objArr[0], new Class[0]);
                }
                ((Method) objAccessartificialFrame2).invoke(obj2, null);
                super.onPause();
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
        Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(949068051);
        if (objAccessartificialFrame3 == null) {
            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(KeyEvent.keyCodeFromString("") + 30, (char) ((ViewConfiguration.getTapTimeout() >> 16) + 49993), Color.green(0) + 74, -1477122277, false, "MediaDescriptionCompatApi23Builder", null);
        }
        Object obj3 = ((Field) objAccessartificialFrame3).get(null);
        try {
            Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1579114835);
            if (objAccessartificialFrame4 == null) {
                int i4 = 30 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                char mode = (char) (49993 - View.MeasureSpec.getMode(0));
                int iIndexOf = 73 - TextUtils.indexOf((CharSequence) "", '0', 0, 0);
                byte[] bArr2 = $$d;
                Object[] objArr2 = new Object[1];
                f(bArr2[225], (byte) (-bArr2[70]), bArr2[75], objArr2);
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(i4, mode, iIndexOf, -1048959141, false, (String) objArr2[0], new Class[0]);
            }
            ((Method) objAccessartificialFrame4).invoke(obj3, null);
            super.onPause();
            int i5 = getARTIFICIAL_FRAME_PACKAGE_NAME + 29;
            artificialFrame = i5 % 128;
            int i6 = i5 % 2;
        } catch (Throwable th2) {
            Throwable cause2 = th2.getCause();
            if (cause2 == null) {
                throw th2;
            }
            throw cause2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x025c  */
    /* JADX WARN: Code duplicated, block: B:17:0x03a3 A[Catch: all -> 0x0e94, TryCatch #2 {all -> 0x0e94, blocks: (B:52:0x0ae8, B:54:0x0b09, B:55:0x0b58, B:15:0x038f, B:17:0x03a3, B:18:0x03d2), top: B:96:0x038f }] */
    /* JADX WARN: Code duplicated, block: B:21:0x03e8  */
    /* JADX WARN: Code duplicated, block: B:26:0x0555  */
    /* JADX WARN: Code duplicated, block: B:51:0x0979  */
    /* JADX WARN: Code duplicated, block: B:54:0x0b09 A[Catch: all -> 0x0e94, TryCatch #2 {all -> 0x0e94, blocks: (B:52:0x0ae8, B:54:0x0b09, B:55:0x0b58, B:15:0x038f, B:17:0x03a3, B:18:0x03d2), top: B:96:0x038f }] */
    /* JADX WARN: Code duplicated, block: B:58:0x0b6a  */
    /* JADX WARN: Code duplicated, block: B:63:0x0c92  */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) throws Throwable {
        Object objAccessartificialFrame;
        Object[] objArrAccessartificialFrame$78cbbd35;
        Object objAccessartificialFrame2;
        Object objAccessartificialFrame3;
        Object objAccessartificialFrame4;
        Object[] objArr;
        Object objAccessartificialFrame5;
        Object objAccessartificialFrame6;
        int i = 2 % 2;
        super.attachBaseContext(context);
        Object objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-444530678);
        if (objAccessartificialFrame7 == null) {
            int deadChar = KeyEvent.getDeadChar(0, 0) + 26;
            char cBlue = (char) Color.blue(0);
            int windowTouchSlop = 1041 - (ViewConfiguration.getWindowTouchSlop() >> 8);
            byte[] bArr = $$a;
            Object[] objArr2 = new Object[1];
            e((byte) 47, bArr[21], bArr[18], objArr2);
            objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(deadChar, cBlue, windowTouchSlop, 2061780482, false, (String) objArr2[0], null);
        }
        long j = ((Field) objAccessartificialFrame7).getLong(null);
        if (j != -1) {
            long j2 = j + 2020;
            Object[] objArr3 = new Object[1];
            d(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(1) + 1248954035, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 35), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(1) - 74, (short) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 17), ((Process.getThreadPriority(0) + 20) >> 6) - 692477978, objArr3);
            Class<?> cls = Class.forName((String) objArr3[0]);
            Object[] objArr4 = new Object[1];
            d(1248954088 - View.MeasureSpec.getMode(0), (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(13) - 101), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(0) - 62, (short) ((-88) - (ViewConfiguration.getScrollBarSize() >> 8)), Process.getGidForName("") - 692477955, objArr4);
            if (j2 >= ((Long) cls.getDeclaredMethod((String) objArr4[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame8 == null) {
                    int packedPositionChild = ExpandableListView.getPackedPositionChild(0L) + 27;
                    char cBlue2 = (char) Color.blue(0);
                    int i2 = (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 1040;
                    byte[] bArr2 = $$a;
                    Object[] objArr5 = new Object[1];
                    e((byte) 47, bArr2[11], bArr2[18], objArr5);
                    objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(packedPositionChild, cBlue2, i2, 1145017376, false, (String) objArr5[0], null);
                }
                Object[] objArr6 = (Object[]) ((Field) objAccessartificialFrame8).get(null);
                objArrAccessartificialFrame$78cbbd35 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
                int i3 = ((int[]) objArr6[3])[0];
                int i4 = ((int[]) objArr6[2])[0];
                String[] strArr = (String[]) objArr6[0];
                int i5 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().smallestScreenWidthDp;
                int i6 = ((~((~i5) | 1065211711)) * 130) + 932892674 + (((~(i5 | 1065211711)) | 1413694) * 130) + 1846630415;
                int i7 = (i6 << 13) ^ i6;
                int i8 = i7 ^ (i7 >>> 17);
                ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0] = i8 ^ (i8 << 5);
            } else {
                Object[] objArr7 = new Object[1];
                d(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) + 1248954057, (byte) (ViewConfiguration.getMaximumFlingVelocity() >> 16), (-24) - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (short) (8 - ExpandableListView.getPackedPositionChild(0L)), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) - 692477977, objArr7);
                Class<?> cls2 = Class.forName((String) objArr7[0]);
                Object[] objArr8 = new Object[1];
                d(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) + 1248954056, (byte) TextUtils.getOffsetAfter("", 0), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 29, (short) (111 - (ViewConfiguration.getKeyRepeatTimeout() >> 16)), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 692477929, objArr8);
                int iIntValue = ((Integer) cls2.getMethod((String) objArr8[0], Object.class).invoke(null, this)).intValue();
                try {
                    Object[] objArr9 = {2094285947};
                    objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1648942878);
                    if (objAccessartificialFrame == null) {
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(8 - (ViewConfiguration.getScrollDefaultDelay() >> 16), (char) ((KeyEvent.getMaxKeyCode() >> 16) + 22251), 1033 - (ViewConfiguration.getTapTimeout() >> 16), 47343338, false, null, new Class[]{Integer.TYPE});
                    }
                    objArrAccessartificialFrame$78cbbd35 = NativeViewGestureHandler.NativeViewGestureHandlerHook.DefaultImpls.accessartificialFrame$78cbbd35(iIntValue, 0, ((Constructor) objAccessartificialFrame).newInstance(objArr9), 1846630415, false);
                    objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-614804952);
                    if (objAccessartificialFrame2 == null) {
                        int i9 = 27 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                        char cIndexOf = (char) (TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 1);
                        int iCombineMeasuredStates = 1041 - View.combineMeasuredStates(0, 0);
                        byte[] bArr3 = $$a;
                        Object[] objArr10 = new Object[1];
                        e((byte) 47, bArr3[11], bArr3[18], objArr10);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(i9, cIndexOf, iCombineMeasuredStates, 1145017376, false, (String) objArr10[0], null);
                    }
                    ((Field) objAccessartificialFrame2).set(null, objArrAccessartificialFrame$78cbbd35);
                    try {
                        Object[] objArr11 = new Object[1];
                        d(1248954084 - TextUtils.getCapsMode("", 0, 0), (byte) (1 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 60, (short) (AndroidCharacter.getMirror('0') - '\n'), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 692478013, objArr11);
                        Class<?> cls3 = Class.forName((String) objArr11[0]);
                        Object[] objArr12 = new Object[1];
                        d(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 1248954053, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 4), (-25) - Color.red(0), (short) ((-88) - (Process.myPid() >> 22)), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) - 692477992, objArr12);
                        Long lValueOf = Long.valueOf(((Long) cls3.getDeclaredMethod((String) objArr12[0], new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-444530678);
                        if (objAccessartificialFrame3 == null) {
                            int gidForName = 25 - Process.getGidForName("");
                            char c = (char) (1 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)));
                            int mirror = AndroidCharacter.getMirror('0') + 993;
                            byte[] bArr4 = $$a;
                            Object[] objArr13 = new Object[1];
                            e((byte) 47, bArr4[21], bArr4[18], objArr13);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(gidForName, c, mirror, 2061780482, false, (String) objArr13[0], null);
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
            Object[] objArr14 = new Object[1];
            d(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) + 1248954057, (byte) (ViewConfiguration.getMaximumFlingVelocity() >> 16), (-24) - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (short) (8 - ExpandableListView.getPackedPositionChild(0L)), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) - 692477977, objArr14);
            Class<?> cls4 = Class.forName((String) objArr14[0]);
            Object[] objArr15 = new Object[1];
            d(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) + 1248954056, (byte) TextUtils.getOffsetAfter("", 0), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 29, (short) (111 - (ViewConfiguration.getKeyRepeatTimeout() >> 16)), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 692477929, objArr15);
            int iIntValue2 = ((Integer) cls4.getMethod((String) objArr15[0], Object.class).invoke(null, this)).intValue();
            Object[] objArr16 = {2094285947};
            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame == null) {
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(8 - (ViewConfiguration.getScrollDefaultDelay() >> 16), (char) ((KeyEvent.getMaxKeyCode() >> 16) + 22251), 1033 - (ViewConfiguration.getTapTimeout() >> 16), 47343338, false, null, new Class[]{Integer.TYPE});
            }
            objArrAccessartificialFrame$78cbbd35 = NativeViewGestureHandler.NativeViewGestureHandlerHook.DefaultImpls.accessartificialFrame$78cbbd35(iIntValue2, 0, ((Constructor) objAccessartificialFrame).newInstance(objArr16), 1846630415, false);
            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame2 == null) {
                int i10 = 27 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                char cIndexOf2 = (char) (TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 1);
                int iCombineMeasuredStates2 = 1041 - View.combineMeasuredStates(0, 0);
                byte[] bArr5 = $$a;
                Object[] objArr17 = new Object[1];
                e((byte) 47, bArr5[11], bArr5[18], objArr17);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(i10, cIndexOf2, iCombineMeasuredStates2, 1145017376, false, (String) objArr17[0], null);
            }
            ((Field) objAccessartificialFrame2).set(null, objArrAccessartificialFrame$78cbbd35);
            Object[] objArr18 = new Object[1];
            d(1248954084 - TextUtils.getCapsMode("", 0, 0), (byte) (1 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 60, (short) (AndroidCharacter.getMirror('0') - '\n'), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 692478013, objArr18);
            Class<?> cls5 = Class.forName((String) objArr18[0]);
            Object[] objArr19 = new Object[1];
            d(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 1248954053, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 4), (-25) - Color.red(0), (short) ((-88) - (Process.myPid() >> 22)), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) - 692477992, objArr19);
            Long lValueOf2 = Long.valueOf(((Long) cls5.getDeclaredMethod((String) objArr19[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-444530678);
            if (objAccessartificialFrame3 == null) {
                int gidForName2 = 25 - Process.getGidForName("");
                char c2 = (char) (1 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)));
                int mirror2 = AndroidCharacter.getMirror('0') + 993;
                byte[] bArr6 = $$a;
                Object[] objArr110 = new Object[1];
                e((byte) 47, bArr6[21], bArr6[18], objArr110);
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(gidForName2, c2, mirror2, 2061780482, false, (String) objArr110[0], null);
            }
            ((Field) objAccessartificialFrame3).set(null, lValueOf2);
        }
        int i11 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
        int i12 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
        if (i12 == i11) {
            Object[] objArr20 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i13 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i14 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i15 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr2 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int iIdentityHashCode = System.identityHashCode(this);
            int i16 = ~iIdentityHashCode;
            int i17 = (-2057449138) + (((~((-86532609) | i16)) | (~((-276864508) | iIdentityHashCode))) * 520);
            int i18 = ~(276864507 | i16);
            int i19 = ~(iIdentityHashCode | 354968314);
            int i20 = i13 + i17 + ((i18 | i19) * (-1040)) + ((i19 | (~(i16 | (-354968315))) | (-363397116)) * 520);
            int i21 = (i20 << 13) ^ i20;
            int i22 = i21 ^ (i21 >>> 17);
            ((int[]) objArr20[1])[0] = i22 ^ (i22 << 5);
        } else {
            ArrayList arrayList = new ArrayList();
            String[] strArr3 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            if (strArr3 != null) {
                int i23 = getARTIFICIAL_FRAME_PACKAGE_NAME + 3;
                artificialFrame = i23 % 128;
                int i24 = i23 % 2;
                for (String str : strArr3) {
                    arrayList.add(str);
                }
            }
            long j3 = ((long) (i11 ^ i12)) ^ (((long) (-1836093661)) << 32);
            long j4 = -1836093663;
            int i25 = getARTIFICIAL_FRAME_PACKAGE_NAME + 9;
            artificialFrame = i25 % 128;
            int i26 = i25 % 2;
            try {
                Object[] objArr21 = {Long.valueOf(j3), Long.valueOf(j4)};
                byte[] bArr7 = $$d;
                Object[] objArr22 = new Object[1];
                f((byte) (-bArr7[388]), (byte) (-bArr7[70]), (short) 687, objArr22);
                Class<?> cls6 = Class.forName((String) objArr22[0]);
                byte b2 = (byte) (-bArr7[640]);
                byte b3 = bArr7[75];
                Object[] objArr23 = new Object[1];
                f(b2, b3, (short) (b3 | 645), objArr23);
                cls6.getMethod((String) objArr23[0], Long.TYPE, Long.TYPE).invoke(null, objArr21);
                Object[] objArr24 = {strArr, new int[1], new int[]{i}, new int[]{i}};
                int i27 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
                int i28 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
                int i29 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
                String[] strArr4 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
                int iCodePointAt = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(0) - 1546230510;
                int i30 = ~(503235327 | iCodePointAt);
                int i31 = i27 + 1531570837 + (((-503250688) | i30) * (-814)) + ((i30 | (~((~iCodePointAt) | 425131520)) | 425116160) * 407) + (((~(iCodePointAt | (-425131521))) | (~((-503235328) | iCodePointAt)) | 425116160) * 407);
                int i32 = (i31 << 13) ^ i31;
                int i33 = i32 ^ (i32 >>> 17);
                ((int[]) objArr24[1])[0] = i33 ^ (i33 << 5);
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
            int iArgb = Color.argb(0, 0, 0, 0) + 25;
            char fadingEdgeLength = (char) (30068 - (ViewConfiguration.getFadingEdgeLength() >> 16));
            int touchSlop = 816 - (ViewConfiguration.getTouchSlop() >> 8);
            byte[] bArr8 = $$a;
            Object[] objArr25 = new Object[1];
            e((byte) 47, bArr8[21], bArr8[18], objArr25);
            objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(iArgb, fadingEdgeLength, touchSlop, 721586079, false, (String) objArr25[0], null);
        }
        long j5 = ((Field) objAccessartificialFrame9).getLong(null);
        if (j5 != -1) {
            int i34 = artificialFrame + 51;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i34 % 128;
            int i35 = i34 % 2;
            long j6 = j5 + 1993;
            Object[] objArr26 = new Object[1];
            d(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 1248954049, (byte) ((-1) - TextUtils.indexOf((CharSequence) "", '0')), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(0) - 135, (short) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(16) - 72), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 692477982, objArr26);
            Class<?> cls7 = Class.forName((String) objArr26[0]);
            Object[] objArr27 = new Object[1];
            d(1248954087 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (byte) (ViewConfiguration.getMinimumFlingVelocity() >> 16), View.MeasureSpec.getSize(0) - 25, (short) ((-16777304) - Color.rgb(0, 0, 0)), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) - 692477992, objArr27);
            if (j6 >= ((Long) cls7.getDeclaredMethod((String) objArr27[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame10 == null) {
                    int i36 = (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 24;
                    char deadChar2 = (char) (KeyEvent.getDeadChar(0, 0) + 30068);
                    int maxKeyCode = 816 - (KeyEvent.getMaxKeyCode() >> 16);
                    byte[] bArr9 = $$a;
                    Object[] objArr28 = new Object[1];
                    e((byte) 47, bArr9[11], bArr9[18], objArr28);
                    objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(i36, deadChar2, maxKeyCode, 891606461, false, (String) objArr28[0], null);
                }
                Object[] objArr29 = (Object[]) ((Field) objAccessartificialFrame10).get(null);
                objArr = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i37 = ((int[]) objArr29[0])[0];
                int i38 = ((int[]) objArr29[1])[0];
                String[] strArr5 = (String[]) objArr29[2];
                int iIdentityHashCode2 = System.identityHashCode(this);
                int i39 = ~iIdentityHashCode2;
                int i40 = ((((-499762211) + (((~(i39 | 144616073)) | ((~((-53556293) | i39)) | 52499524)) * 464)) + (((-1056769) | iIdentityHashCode2) * (-464))) + (((~(iIdentityHashCode2 | 144616073)) | 52499524) * 464)) - 914471419;
                int i41 = (i40 << 13) ^ i40;
                int i42 = i41 ^ (i41 >>> 17);
                ((int[]) objArr[3])[0] = i42 ^ (i42 << 5);
            } else {
                Object[] objArr30 = new Object[1];
                d(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 1248954089, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 4), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(6) - 142, (short) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 8), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(11) - 692478046, objArr30);
                Class<?> cls8 = Class.forName((String) objArr30[0]);
                Object[] objArr31 = new Object[1];
                d(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) + 1248954056, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 21), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 60, (short) ((ViewConfiguration.getKeyRepeatTimeout() >> 16) + b.f40o), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(20) - 692478024, objArr31);
                Object[] objArr32 = {Integer.valueOf(((Integer) cls8.getMethod((String) objArr31[0], Object.class).invoke(null, this)).intValue()), 0, -914471419};
                objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1327366003);
                if (objAccessartificialFrame4 == null) {
                    int modifierMetaStateMask = 24 - ((byte) KeyEvent.getModifierMetaStateMask());
                    char cIndexOf3 = (char) (30067 - TextUtils.indexOf((CharSequence) "", '0', 0));
                    int iLastIndexOf = TextUtils.lastIndexOf("", '0') + 817;
                    byte[] bArr10 = $$a;
                    Object[] objArr33 = new Object[1];
                    e(bArr10[35], bArr10[97], bArr10[1], objArr33);
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(modifierMetaStateMask, cIndexOf3, iLastIndexOf, -797394565, false, (String) objArr33[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                }
                objArr = (Object[]) ((Method) objAccessartificialFrame4).invoke(null, objArr32);
                objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame5 == null) {
                    int i43 = (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 24;
                    char cKeyCodeFromString = (char) (KeyEvent.keyCodeFromString("") + 30068);
                    int iIndexOf = TextUtils.indexOf("", "", 0, 0) + 816;
                    byte[] bArr11 = $$a;
                    Object[] objArr34 = new Object[1];
                    e((byte) 47, bArr11[11], bArr11[18], objArr34);
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(i43, cKeyCodeFromString, iIndexOf, 891606461, false, (String) objArr34[0], null);
                }
                ((Field) objAccessartificialFrame5).set(null, objArr);
                try {
                    Object[] objArr35 = new Object[1];
                    d(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 1248954049, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(3) - 46), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 60, (short) (38 - View.combineMeasuredStates(0, 0)), Color.blue(0) - 692477978, objArr35);
                    Class<?> cls9 = Class.forName((String) objArr35[0]);
                    Object[] objArr36 = new Object[1];
                    d((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 1248954089, (byte) (TextUtils.indexOf((CharSequence) "", '0', 0) + 1), TextUtils.indexOf((CharSequence) "", '0', 0) - 24, (short) ((-89) - ImageFormat.getBitsPerPixel(0)), (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) - 692477957, objArr36);
                    Long lValueOf3 = Long.valueOf(((Long) cls9.getDeclaredMethod((String) objArr36[0], new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                    if (objAccessartificialFrame6 == null) {
                        int iRed = 25 - Color.red(0);
                        char maximumDrawingCacheSize = (char) (30068 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24));
                        int keyRepeatDelay = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 816;
                        byte[] bArr12 = $$a;
                        Object[] objArr37 = new Object[1];
                        e((byte) 47, bArr12[21], bArr12[18], objArr37);
                        objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(iRed, maximumDrawingCacheSize, keyRepeatDelay, 721586079, false, (String) objArr37[0], null);
                    }
                    ((Field) objAccessartificialFrame6).set(null, lValueOf3);
                } catch (Exception unused2) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object[] objArr38 = new Object[1];
            d(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 1248954089, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 4), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(6) - 142, (short) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 8), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(11) - 692478046, objArr38);
            Class<?> cls10 = Class.forName((String) objArr38[0]);
            Object[] objArr39 = new Object[1];
            d(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) + 1248954056, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 21), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 60, (short) ((ViewConfiguration.getKeyRepeatTimeout() >> 16) + b.f40o), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(20) - 692478024, objArr39);
            Object[] objArr310 = {Integer.valueOf(((Integer) cls10.getMethod((String) objArr39[0], Object.class).invoke(null, this)).intValue()), 0, -914471419};
            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1327366003);
            if (objAccessartificialFrame4 == null) {
                int modifierMetaStateMask2 = 24 - ((byte) KeyEvent.getModifierMetaStateMask());
                char cIndexOf4 = (char) (30067 - TextUtils.indexOf((CharSequence) "", '0', 0));
                int iLastIndexOf2 = TextUtils.lastIndexOf("", '0') + 817;
                byte[] bArr13 = $$a;
                Object[] objArr311 = new Object[1];
                e(bArr13[35], bArr13[97], bArr13[1], objArr311);
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(modifierMetaStateMask2, cIndexOf4, iLastIndexOf2, -797394565, false, (String) objArr311[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            }
            objArr = (Object[]) ((Method) objAccessartificialFrame4).invoke(null, objArr310);
            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame5 == null) {
                int i44 = (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 24;
                char cKeyCodeFromString2 = (char) (KeyEvent.keyCodeFromString("") + 30068);
                int iIndexOf2 = TextUtils.indexOf("", "", 0, 0) + 816;
                byte[] bArr14 = $$a;
                Object[] objArr312 = new Object[1];
                e((byte) 47, bArr14[11], bArr14[18], objArr312);
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(i44, cKeyCodeFromString2, iIndexOf2, 891606461, false, (String) objArr312[0], null);
            }
            ((Field) objAccessartificialFrame5).set(null, objArr);
            Object[] objArr313 = new Object[1];
            d(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 1248954049, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(3) - 46), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 60, (short) (38 - View.combineMeasuredStates(0, 0)), Color.blue(0) - 692477978, objArr313);
            Class<?> cls11 = Class.forName((String) objArr313[0]);
            Object[] objArr314 = new Object[1];
            d((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 1248954089, (byte) (TextUtils.indexOf((CharSequence) "", '0', 0) + 1), TextUtils.indexOf((CharSequence) "", '0', 0) - 24, (short) ((-89) - ImageFormat.getBitsPerPixel(0)), (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) - 692477957, objArr314);
            Long lValueOf4 = Long.valueOf(((Long) cls11.getDeclaredMethod((String) objArr314[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1268268649);
            if (objAccessartificialFrame6 == null) {
                int iRed2 = 25 - Color.red(0);
                char maximumDrawingCacheSize2 = (char) (30068 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24));
                int keyRepeatDelay2 = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 816;
                byte[] bArr15 = $$a;
                Object[] objArr315 = new Object[1];
                e((byte) 47, bArr15[21], bArr15[18], objArr315);
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(iRed2, maximumDrawingCacheSize2, keyRepeatDelay2, 721586079, false, (String) objArr315[0], null);
            }
            ((Field) objAccessartificialFrame6).set(null, lValueOf4);
        }
        int i45 = ((int[]) objArr[1])[0];
        int i46 = ((int[]) objArr[0])[0];
        if (i46 == i45) {
            Object[] objArr40 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i47 = ((int[]) objArr[3])[0];
            int i48 = ((int[]) objArr[0])[0];
            int i49 = ((int[]) objArr[1])[0];
            String[] strArr6 = (String[]) objArr[2];
            int i50 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getDisplayMetrics().widthPixels;
            int i51 = i47 + ((((-2142914385) + (((~i50) | 537944402) * 1324)) + (((~(i50 | (-533305006))) | (~(731477371 | i50))) * (-1324))) - 1227697658);
            int i52 = (i51 << 13) ^ i51;
            int i53 = i52 ^ (i52 >>> 17);
            ((int[]) objArr40[3])[0] = i53 ^ (i53 << 5);
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        int i54 = 2;
        String[] strArr7 = (String[]) objArr[2];
        if (strArr7 != null) {
            int i55 = getARTIFICIAL_FRAME_PACKAGE_NAME + 49;
            artificialFrame = i55 % 128;
            int i56 = i55 % 2;
            int i57 = 0;
            while (i57 < strArr7.length) {
                int i58 = getARTIFICIAL_FRAME_PACKAGE_NAME + 3;
                artificialFrame = i58 % 128;
                int i59 = i58 % i54;
                arrayList2.add(strArr7[i57]);
                i57++;
                int i60 = getARTIFICIAL_FRAME_PACKAGE_NAME + 89;
                artificialFrame = i60 % 128;
                int i61 = i60 % 2;
                i54 = 2;
            }
        }
        long j7 = (((long) 592776585) << 32) ^ ((long) (i45 ^ i46));
        long j8 = 592776584;
        int i62 = getARTIFICIAL_FRAME_PACKAGE_NAME + 41;
        artificialFrame = i62 % 128;
        int i63 = i62 % 2;
        Object[] objArr41 = {Long.valueOf(j7), Long.valueOf(j8)};
        byte[] bArr16 = $$d;
        byte b4 = bArr16[75];
        Object[] objArr42 = new Object[1];
        f(b4, (byte) (-bArr16[70]), b4, objArr42);
        Class<?> cls12 = Class.forName((String) objArr42[0]);
        byte b5 = (byte) (-bArr16[640]);
        byte b6 = bArr16[75];
        Object[] objArr43 = new Object[1];
        f(b5, b6, (short) (b6 | 645), objArr43);
        cls12.getMethod((String) objArr43[0], Long.TYPE, Long.TYPE).invoke(null, objArr41);
        Object[] objArr44 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
        int i64 = ((int[]) objArr[3])[0];
        int i65 = ((int[]) objArr[0])[0];
        int i66 = ((int[]) objArr[1])[0];
        String[] strArr8 = (String[]) objArr[2];
        int startElapsedRealtime = (int) Process.getStartElapsedRealtime();
        int i67 = ~startElapsedRealtime;
        int i68 = i64 + 214920980 + (((~((-837008586) | i67)) | (~(638836219 | i67))) * (-867)) + (((~((-837008586) | startElapsedRealtime)) | 299900928 | (~(638836219 | startElapsedRealtime))) * (-1734)) + (((~(startElapsedRealtime | 938737147)) | (~(i67 | (-299900929))) | (~((-537107658) | startElapsedRealtime))) * 867);
        int i69 = (i68 << 13) ^ i68;
        int i70 = i69 ^ (i69 >>> 17);
        ((int[]) objArr44[3])[0] = i70 ^ (i70 << 5);
    }

    static void accessartificialFrame() {
        onTransact = -765951855;
        mayLaunchUrl = -81862509;
        getInterfaceDescriptor = 1318099446;
        ICustomTabsCallbackStubProxy = new byte[]{117, 105, 69, 86, -120, 59, 105, SignedBytes.MAX_POWER_OF_TWO, 80, 95, -117, 116, Ascii.RS, 85, -112, 47, 94, 95, 92, 99, 91, 108, 124, -37, -41, -58, -21, -24, -33, -32, -51, -36, -63, -48, -20, -58, -44, 115, 116, 99, 115, 122, -106, -105, 53, 123, -113, 103, -66, 79, 105, -121, 101, 115, Ascii.EM, Ascii.CR, 54, -25, Ascii.CR, 40, 33, -21, Ascii.GS, Ascii.ETB, Ascii.CR, Ascii.FS, 17, Ascii.EM, 7, -119, Ascii.NAK, Ascii.FS, 5, 46, 36, -3, 43, 45, 5, 35, Ascii.ESC, 39, 54, 37, -46, Ascii.DLE, 33, 69, -18, Ascii.GS, Ascii.RS, 19, 34, Ascii.SUB, 35, 113, -109, -108, -123, -89, -100, -104, -99, -98, -110, -61, 109, -108, -87, -121, -110, -99, -96, -93, 103, -107, -62, 100, -86, -112, -37, 103, -61, -108, -109, -108, 120, -106, -109, -40, 97, -57, -110, -85, 103, -85, -37, 108, -63, 123, -64, 122, -57, -106, 103, -106, -107, -63, 122, -38, -111, 100, -52, 101, -64, -105, -86, -106, -105, 100, -105, -105, -64, -108, -88, 103, -62, -110, 120, -62, 101, -107, -60, -107, -109, -88, 99, -93, 39, 57, 85, 33, 35, Ascii.SI, 39, 82, 38, -11, 59, 34, 57, 80, 34, 57, 35, Utf8.REPLACEMENT_BYTE, 33, 37, 33, 59, 45, 58, -10, 58, 82, 59, 38, 39, 32, 59, -10, 81, -11, 84, 34, 36, 35, Ascii.SO, 82, -9, 57, 34, 106, 35, 59, 44, 9, 85, 33, 10, 81, 34, 62, 33, 58, -4, 37, 38, 38, 80, 36};
    }
}
