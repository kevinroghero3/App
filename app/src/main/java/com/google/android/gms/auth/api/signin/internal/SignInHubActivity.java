package com.google.android.gms.auth.api.signin.internal;

import android.content.ActivityNotFoundException;
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
import android.provider.Settings;
import android.telephony.cdma.CdmaCellLocation;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.widget.ExpandableListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.fragment.app.FragmentActivity;
import com.facebook.fresco.urimod.UriModifierInterface;
import com.facebook.imagepipeline.memory.BitmapCounterConfig;
import com.facebook.imageutils.JfifUtil;
import com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager$$ExternalSyntheticLambda5;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInApi;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInStatusCodes;
import com.google.android.gms.auth.api.signin.SignInAccount;
import com.google.android.gms.common.api.Status;
import com.google.common.base.Ascii;
import io.sentry.android.core.SentryLogcatAdapter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.pluservice.unicoc.R;
import o.ArtificialStackFrames;
import o.asBinder;
import org.apache.commons.lang3.CharEncoding;

/* JADX INFO: loaded from: classes4.dex */
public class SignInHubActivity extends FragmentActivity {
    private static final byte[] $$a;
    private static final int $$b;
    private static final byte[] $$d;
    private static final int $$e;
    private static int artificialFrame = 0;
    private static long extraCommand = 0;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static boolean zba = false;
    private boolean zbb = false;
    private SignInConfiguration zbc;
    private boolean zbd;
    private int zbe;
    private Intent zbf;
    private static final byte[] $$c = {5, -37, 48, 84};
    private static final int $$f = 172;
    private static int $10 = 0;
    private static int $11 = 1;

    /* JADX WARN: Code duplicated, block: B:10:0x0025  */
    /* JADX WARN: Code duplicated, block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x0027). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0025
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$g(byte r5, short r6, byte r7) {
        /*
            int r7 = r7 * 3
            int r7 = 118 - r7
            byte[] r0 = com.google.android.gms.auth.api.signin.internal.SignInHubActivity.$$c
            int r6 = r6 * 4
            int r6 = r6 + 1
            int r5 = r5 * 3
            int r5 = r5 + 4
            byte[] r1 = new byte[r6]
            r2 = 0
            if (r0 != 0) goto L17
            r7 = r5
            r4 = r6
            r3 = r2
            goto L27
        L17:
            r3 = r2
        L18:
            byte r4 = (byte) r7
            r1[r3] = r4
            int r3 = r3 + 1
            if (r3 != r6) goto L25
            java.lang.String r5 = new java.lang.String
            r5.<init>(r1, r2)
            return r5
        L25:
            r4 = r0[r5]
        L27:
            int r4 = -r4
            int r5 = r5 + 1
            int r7 = r7 + r4
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.signin.internal.SignInHubActivity.$$g(byte, short, byte):java.lang.String");
    }

    static {
        byte[] bArr = new byte[667];
        System.arraycopy("\u0016\u0088%l\u0010\u0002Å=\f\u0004ü\týÍ7\u0011ú\u0012\u0001þÿÎEù\r\u0003Æ?\bø\n\u0002Í(\u0006\u0004\u0006\u0012\u0004ò\u0015\u0006ù\u0001\u0007þ\nü\u000fÞ0ó\u0010ü\u0010\u0002Å<ÿ\u0006\u0006\u0001\u0011\u0004\u0000ÇH÷\u0000\u0006\u0015¾Kø\bø\u0011÷\n\u0002\u0011À/\u001aüþñ%ù\u0005ï#\u0004\u0001¼\u0004%7\u0000õ\u0011\u0000÷\u000fë*ù\nø\u0001\u0013ùþí\u0019\u0010ù\u0006\u0001Ó\u0004A\u0010\u0002Å=\f\u0004ü\týÍ7\u0013ýÉ'(þ\tñó&\u0001\tÿ\u0010\u0002Å<ÿ\u0006\u0006\u0001\u0011\u0004\u0000ÇH÷\u0000\u0006\u0015¾:\u0005\u0015\u0001\u0006ÿ\u0004\u0003\u0007\u0006¾\u00199\u0004Õ)\t\u0001ù\u0002\u0015ÿ\u0007â\u0015\u0006\fú\n\u0002\u0011Õ0\u0003\u0004û\u0002\u0015ù\n\u0003º$%\u000bý\u0006þ\u0017õè(\u0007\u0000\u0010\u0002Å=\f\u0004ü\týÍC\u0003\u0003\u0002\u000f¾9\u0010\u0002\u0004\u0006\u0003ÄIõ\u000b\u0002\t\nõ\u0011\u0000÷\u000fÆP\u0004û\u0000\u0001\u0010\u0004\u0000Çÿ?\t\nõ\u0011\u0000÷\u000fÆM\u0000¿(\u0017\u0000\u000fï\u0012\u0001õ ø\fþ\u0013´7\u001fû\u000fõ\u0011æ\u0011\u0016ü\u0010\u0002ÅH÷\u0000\u0006\u0015þ÷\u0017ù\u0011ó\nþ\u0018í\u0011ö\u0015ö\u0003\u0010\u0003\n\u0002\u0001\u0001\u0004ý\u0011ÀB\u0001\u000e\u0005õ\rû\u0011\u0005¿\u001c-ø\u0016\u0002ö\u0003é)\u0006\t\u0003ß\u0017\u0015ö\u0011\bó\u0011¶\u0004%7\u0000õ\u0011\u0000÷\u000fë*ù\nø\u0001\u0013ùþí\u0019\u0010ù\u0006\u0001Õ0\u0007\u0001\n\u0003ù\tûã%\u0001\u0017ö\u0004\u0006\týè-\u0010\u0002Å=\f\u0004ü\týÍ7\u0011ú\u0012\u0001þÿÎ=\n\n¿?\t\nõ\u0011\u0000÷\u000fÆC\u0003\u0003\u0002\u000fï\u001b÷\u000eú\n\u0003õ\u0007\u0003\u0015õ\u0010ù\u0005ÍP\u0004ì\u0016\u0010\u0007\u0001\n\u0003ù\tûâ3÷\u0000\u0017ù\n\u0003û\u0013¾Jù\büÓ:È;\rý\u0006\tûÍ\u0019\"\u000fý\rú\u0001\u0015Ø\u001f\u0010\u0000\u0007\u0011¯\u0011\u0010\u0002Å=\f\u0004ü\týÍ7\u0011ú\u0012\u0001þÿÎ=\n\n¿?\t\nõ\u0011\u0000÷\u000fÆC\u0003\u0003\u0002\u000fï\u001b÷\u000eú\n\u0003õ\u0007\u0003\u0015õ\u0010ù\u0005þ\u0007\u0017ýú\fý\u0003ÎP\u0004ï\u0010\u0002Å=\f\u0004ü\týÍ9\u0013\u000bû\bÿÃJù\t\u0001Ç7\b\u0000\u0007Î\u0017(\u0012Ö \u001b×\u001e\u0018¯\u0011\u0000\u0001\u0010\u0004\u0000Çÿ?\t\nõ\u0011\u0000÷\u000fÆF\u0000ù\u0017ö\r\u0007ÿÅ7\u0011ú\u0012\u0001þÿÎ\u001a%\u0005\u0003\u0011\u0004÷\u0003ó ø\fþ\u0013Ñ'\u0001\u0013\bõ\u0011".getBytes(CharEncoding.ISO_8859_1), 0, bArr, 0, 667);
        $$d = bArr;
        $$e = 77;
        $$a = new byte[]{67, 87, 59, -10, -9, Ascii.DC2, -36, 33, -19, 17, -32, Ascii.SI, 19, -11, 5, -7, -7, Ascii.DC2, -43, Ascii.GS, -4, 17, 2, 5, -1, -33, 33, -2, -9, 5, -7, 5, -1, -50, 39, Ascii.VT, -7, -12, Ascii.SI, 49, 2, -11, -3, 3, -6, 6, -8, Ascii.VT, -25, 33, -19, 2, 8, -37, 44, -17, Ascii.FF, -8, Ascii.SO, -9, Ascii.DC2, -34, Ascii.EM, 4, -17, 19, -15, -1, -18, Ascii.SI, 19, -11, 5, -7, -2, Ascii.SI, -36, Ascii.NAK, Ascii.CR, -15, 2, 9, 6, -34, Ascii.SI, 19, -11, 5, -7, -2, Ascii.SI, -33, 33, -19, 17, -32, Ascii.SI, 19, -11, 5, -7, 10, -31, Ascii.DC4, Ascii.CR, -8, -11, -13, Ascii.ESC, Ascii.ESC, 1, -7, -6, -33, 51, -12, 3, -8, 1, Ascii.CR};
        $$b = 58;
        getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
        artificialFrame = 1;
        accessartificialFrame();
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0020  */
    /* JADX WARN: Code duplicated, block: B:8:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0020 -> B:11:0x0029). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0020
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void b(byte r6, int r7, byte r8, java.lang.Object[] r9) {
        /*
            int r0 = 21 - r8
            int r6 = 112 - r6
            byte[] r1 = com.google.android.gms.auth.api.signin.internal.SignInHubActivity.$$a
            int r7 = r7 + 4
            byte[] r0 = new byte[r0]
            int r8 = 20 - r8
            r2 = 0
            if (r1 != 0) goto L12
            r3 = r7
            r4 = r2
            goto L29
        L12:
            r3 = r2
        L13:
            byte r4 = (byte) r6
            r0[r3] = r4
            if (r3 != r8) goto L20
            java.lang.String r6 = new java.lang.String
            r6.<init>(r0, r2)
            r9[r2] = r6
            return
        L20:
            int r3 = r3 + 1
            r4 = r1[r7]
            r5 = r7
            r7 = r6
            r6 = r4
            r4 = r3
            r3 = r5
        L29:
            int r6 = r6 + r7
            int r7 = r3 + 1
            r3 = r4
            goto L13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.signin.internal.SignInHubActivity.b(byte, int, byte, java.lang.Object[]):void");
    }

    private static void c(short s, short s2, int i, Object[] objArr) {
        int i2 = 111 - i;
        byte[] bArr = $$d;
        int i3 = s + 4;
        byte[] bArr2 = new byte[s2 + 1];
        int i4 = -1;
        if (bArr == null) {
            i3++;
            i2 = (i3 + s2) - 4;
        }
        while (true) {
            i4++;
            bArr2[i4] = (byte) i2;
            if (i4 == s2) {
                objArr[0] = new String(bArr2, 0);
                return;
            } else {
                byte b = bArr[i3];
                i3++;
                i2 = (i2 + b) - 4;
            }
        }
    }

    private final void zbc() {
        getSupportLoaderManager().initLoader(0, null, new zbw(this, null));
        zba = false;
    }

    private final void zbd(int i) {
        Status status = new Status(i);
        Intent intent = new Intent();
        intent.putExtra("googleSignInStatus", status);
        setResult(0, intent);
        finish();
        zba = false;
    }

    private final void zbe(String str) {
        Intent intent = new Intent(str);
        if (str.equals("com.google.android.gms.auth.GOOGLE_SIGN_IN")) {
            intent.setPackage("com.google.android.gms");
        } else {
            intent.setPackage(getPackageName());
        }
        intent.putExtra("config", this.zbc);
        try {
            startActivityForResult(intent, 40962);
        } catch (ActivityNotFoundException unused) {
            this.zbb = true;
            SentryLogcatAdapter.w("AuthSignInClient", "Could not launch sign in Intent. Google Play Service is probably being updated...");
            zbd(17);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final boolean dispatchPopulateAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public final void onActivityResult(int i, int i2, @Nullable Intent intent) {
        if (this.zbb) {
            return;
        }
        setResult(0);
        if (i != 40962) {
            return;
        }
        if (intent != null) {
            SignInAccount signInAccount = (SignInAccount) intent.getParcelableExtra(GoogleSignInApi.EXTRA_SIGN_IN_ACCOUNT);
            if (signInAccount != null && signInAccount.zba() != null) {
                GoogleSignInAccount googleSignInAccountZba = signInAccount.zba();
                zbn zbnVarZbc = zbn.zbc(this);
                GoogleSignInOptions googleSignInOptionsZba = this.zbc.zba();
                googleSignInAccountZba.getClass();
                zbnVarZbc.zbe(googleSignInOptionsZba, googleSignInAccountZba);
                intent.removeExtra(GoogleSignInApi.EXTRA_SIGN_IN_ACCOUNT);
                intent.putExtra("googleSignInAccount", googleSignInAccountZba);
                this.zbd = true;
                this.zbe = i2;
                this.zbf = intent;
                zbc();
                return;
            }
            if (intent.hasExtra("errorCode")) {
                int intExtra = intent.getIntExtra("errorCode", 8);
                if (intExtra == 13) {
                    intExtra = GoogleSignInStatusCodes.SIGN_IN_CANCELLED;
                }
                zbd(intExtra);
                return;
            }
        }
        zbd(8);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        String action = intent.getAction();
        action.getClass();
        if ("com.google.android.gms.auth.NO_IMPL".equals(action)) {
            zbd(GoogleSignInStatusCodes.SIGN_IN_FAILED);
            return;
        }
        if (!action.equals("com.google.android.gms.auth.GOOGLE_SIGN_IN") && !action.equals("com.google.android.gms.auth.APPAUTH_SIGN_IN")) {
            SentryLogcatAdapter.e("AuthSignInClient", "Unknown action: ".concat(String.valueOf(intent.getAction())));
            finish();
            return;
        }
        Bundle bundleExtra = intent.getBundleExtra("config");
        bundleExtra.getClass();
        SignInConfiguration signInConfiguration = (SignInConfiguration) bundleExtra.getParcelable("config");
        if (signInConfiguration == null) {
            SentryLogcatAdapter.e("AuthSignInClient", "Activity started with invalid configuration.");
            setResult(0);
            finish();
            return;
        }
        this.zbc = signInConfiguration;
        if (bundle == null) {
            if (zba) {
                setResult(0);
                zbd(GoogleSignInStatusCodes.SIGN_IN_CURRENTLY_IN_PROGRESS);
                return;
            } else {
                zba = true;
                zbe(action);
                return;
            }
        }
        boolean z = bundle.getBoolean("signingInGoogleApiClients");
        this.zbd = z;
        if (z) {
            this.zbe = bundle.getInt("signInResultCode");
            Intent intent2 = (Intent) bundle.getParcelable("signInResultData");
            intent2.getClass();
            this.zbf = intent2;
            zbc();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        zba = false;
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("signingInGoogleApiClients", this.zbd);
        if (this.zbd) {
            bundle.putInt("signInResultCode", this.zbe);
            bundle.putParcelable("signInResultData", this.zbf);
        }
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
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(TextUtils.getOffsetBefore("", 0) + 11, (char) ExpandableListView.getPackedPositionGroup(0L), 1407 - View.getDefaultSize(0, 0), 1035473698, false, $$g(b, b2, b2), new Class[]{Integer.TYPE, Object.class, Object.class});
                }
                jArr[i3] = ((Long) ((Method) objAccessartificialFrame).invoke(null, objArr2)).longValue() ^ (extraCommand ^ (-2360974883025274865L));
                try {
                    Object[] objArr3 = {asbinder, asbinder};
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1981632360);
                    if (objAccessartificialFrame2 == null) {
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(Gravity.getAbsoluteGravity(0, 0) + 8, (char) ((-1) - ((byte) KeyEvent.getModifierMetaStateMask())), (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 248, 378009232, false, "w", new Class[]{Object.class, Object.class});
                    }
                    ((Method) objAccessartificialFrame2).invoke(null, objArr3);
                    int i4 = $10 + 9;
                    $11 = i4 % 128;
                    int i5 = i4 % 2;
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 == null) {
                    throw th2;
                }
                throw cause2;
            }
        }
        char[] cArr2 = new char[length];
        asbinder.d = 0;
        while (asbinder.d < cArr.length) {
            cArr2[asbinder.d] = (char) jArr[asbinder.d];
            try {
                Object[] objArr4 = {asbinder, asbinder};
                Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1981632360);
                if (objAccessartificialFrame3 == null) {
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 9, (char) KeyEvent.getDeadChar(0, 0), 250 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), 378009232, false, "w", new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame3).invoke(null, objArr4);
                int i6 = $10 + 123;
                $11 = i6 % 128;
                int i7 = i6 % 2;
            } catch (Throwable th3) {
                Throwable cause3 = th3.getCause();
                if (cause3 == null) {
                    throw th3;
                }
                throw cause3;
            }
        }
        objArr[0] = new String(cArr2);
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0222  */
    /* JADX WARN: Code duplicated, block: B:20:0x0228  */
    /* JADX WARN: Code duplicated, block: B:22:0x028e  */
    /* JADX WARN: Code duplicated, block: B:232:0x16d9  */
    /* JADX WARN: Code duplicated, block: B:233:0x173a  */
    /* JADX WARN: Code duplicated, block: B:238:0x1819  */
    /* JADX WARN: Code duplicated, block: B:248:0x193c  */
    /* JADX WARN: Code duplicated, block: B:24:0x029a  */
    /* JADX WARN: Code duplicated, block: B:252:0x19c5  */
    /* JADX WARN: Code duplicated, block: B:257:0x1a35  */
    /* JADX WARN: Code duplicated, block: B:261:0x1a8f  */
    /* JADX WARN: Code duplicated, block: B:262:0x1af6  */
    /* JADX WARN: Code duplicated, block: B:267:0x1beb  */
    /* JADX WARN: Code duplicated, block: B:277:0x1d37  */
    /* JADX WARN: Code duplicated, block: B:279:0x1d3e  */
    /* JADX WARN: Code duplicated, block: B:27:0x02a2  */
    /* JADX WARN: Code duplicated, block: B:281:0x1d99  */
    /* JADX WARN: Code duplicated, block: B:283:0x1d9d  */
    /* JADX WARN: Code duplicated, block: B:287:0x1da9  */
    /* JADX WARN: Code duplicated, block: B:292:0x1e4b  */
    /* JADX WARN: Code duplicated, block: B:297:0x1ebb  */
    /* JADX WARN: Code duplicated, block: B:29:0x02a6  */
    /* JADX WARN: Code duplicated, block: B:301:0x1f16  */
    /* JADX WARN: Code duplicated, block: B:302:0x1f8f  */
    /* JADX WARN: Code duplicated, block: B:305:0x1fa2 A[Catch: all -> 0x259e, TryCatch #10 {all -> 0x259e, blocks: (B:333:0x22b6, B:335:0x22d9, B:336:0x2331, B:303:0x1f95, B:305:0x1fa2, B:306:0x1fd1, B:308:0x1fdb, B:310:0x1fe8, B:311:0x201a, B:155:0x1003, B:157:0x1018, B:158:0x1048, B:69:0x069b, B:71:0x06a1, B:72:0x06ce, B:74:0x06f7, B:75:0x077e), top: B:405:0x069b }] */
    /* JADX WARN: Code duplicated, block: B:310:0x1fe8 A[Catch: all -> 0x259e, TryCatch #10 {all -> 0x259e, blocks: (B:333:0x22b6, B:335:0x22d9, B:336:0x2331, B:303:0x1f95, B:305:0x1fa2, B:306:0x1fd1, B:308:0x1fdb, B:310:0x1fe8, B:311:0x201a, B:155:0x1003, B:157:0x1018, B:158:0x1048, B:69:0x069b, B:71:0x06a1, B:72:0x06ce, B:74:0x06f7, B:75:0x077e), top: B:405:0x069b }] */
    /* JADX WARN: Code duplicated, block: B:317:0x2130  */
    /* JADX WARN: Code duplicated, block: B:320:0x2185  */
    /* JADX WARN: Code duplicated, block: B:322:0x2191  */
    /* JADX WARN: Code duplicated, block: B:325:0x21b2  */
    /* JADX WARN: Code duplicated, block: B:327:0x21d1 A[PHI: r1
  0x21d1: PHI (r1v78 int) = (r1v77 int), (r1v96 int) binds: [B:326:0x21cf, B:323:0x21af] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:329:0x21da  */
    /* JADX WARN: Code duplicated, block: B:32:0x02b0  */
    /* JADX WARN: Code duplicated, block: B:332:0x2298  */
    /* JADX WARN: Code duplicated, block: B:335:0x22d9 A[Catch: all -> 0x259e, TryCatch #10 {all -> 0x259e, blocks: (B:333:0x22b6, B:335:0x22d9, B:336:0x2331, B:303:0x1f95, B:305:0x1fa2, B:306:0x1fd1, B:308:0x1fdb, B:310:0x1fe8, B:311:0x201a, B:155:0x1003, B:157:0x1018, B:158:0x1048, B:69:0x069b, B:71:0x06a1, B:72:0x06ce, B:74:0x06f7, B:75:0x077e), top: B:405:0x069b }] */
    /* JADX WARN: Code duplicated, block: B:339:0x2343  */
    /* JADX WARN: Code duplicated, block: B:344:0x23b3  */
    /* JADX WARN: Code duplicated, block: B:348:0x2408  */
    /* JADX WARN: Code duplicated, block: B:349:0x2478  */
    /* JADX WARN: Code duplicated, block: B:351:0x2484  */
    /* JADX WARN: Code duplicated, block: B:354:0x2488 A[LOOP:0: B:352:0x2485->B:354:0x2488, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:37:0x033c  */
    /* JADX WARN: Code duplicated, block: B:39:0x034f  */
    /* JADX WARN: Code duplicated, block: B:44:0x03bb  */
    /* JADX WARN: Code duplicated, block: B:45:0x0401  */
    /* JADX WARN: Code duplicated, block: B:49:0x0410  */
    /* JADX WARN: Code duplicated, block: B:68:0x0698  */
    /* JADX WARN: Code duplicated, block: B:71:0x06a1 A[Catch: all -> 0x259e, TryCatch #10 {all -> 0x259e, blocks: (B:333:0x22b6, B:335:0x22d9, B:336:0x2331, B:303:0x1f95, B:305:0x1fa2, B:306:0x1fd1, B:308:0x1fdb, B:310:0x1fe8, B:311:0x201a, B:155:0x1003, B:157:0x1018, B:158:0x1048, B:69:0x069b, B:71:0x06a1, B:72:0x06ce, B:74:0x06f7, B:75:0x077e), top: B:405:0x069b }] */
    /* JADX WARN: Code duplicated, block: B:74:0x06f7 A[Catch: all -> 0x259e, TryCatch #10 {all -> 0x259e, blocks: (B:333:0x22b6, B:335:0x22d9, B:336:0x2331, B:303:0x1f95, B:305:0x1fa2, B:306:0x1fd1, B:308:0x1fdb, B:310:0x1fe8, B:311:0x201a, B:155:0x1003, B:157:0x1018, B:158:0x1048, B:69:0x069b, B:71:0x06a1, B:72:0x06ce, B:74:0x06f7, B:75:0x077e), top: B:405:0x069b }] */
    /* JADX WARN: Code duplicated, block: B:78:0x0791  */
    /* JADX WARN: Code duplicated, block: B:83:0x07fd  */
    /* JADX WARN: Code duplicated, block: B:84:0x0843  */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onStart() throws Throwable {
        Context baseContext;
        Object[] objArr;
        Object[] objArr2;
        Object objAccessartificialFrame;
        Object objAccessartificialFrame2;
        int i;
        Object objAccessartificialFrame3;
        Object objAccessartificialFrame4;
        Object objAccessartificialFrame5;
        Object objAccessartificialFrame6;
        Object[] objArr3;
        int i2;
        Object[] objArr4;
        int i3;
        Object[] objArrAccessartificialFrame$78cbbd35;
        int i4;
        Object[] objArr5;
        Long lValueOf;
        Object objAccessartificialFrame7;
        int offsetAfter;
        char absoluteGravity;
        int windowTouchSlop;
        int i5;
        boolean z;
        String str;
        int i6;
        int i7;
        int i8;
        Object objAccessartificialFrame8;
        long j;
        Object[] objArr6;
        Object objAccessartificialFrame9;
        Object objAccessartificialFrame10;
        int i9;
        int i10;
        Object objAccessartificialFrame11;
        long j2;
        Context baseContext2;
        Object[] objArr7;
        Object objAccessartificialFrame12;
        Object objAccessartificialFrame13;
        int i11;
        int i12;
        Object objAccessartificialFrame14;
        Object objAccessartificialFrame15;
        Object objAccessartificialFrame16;
        long j3;
        Object objAccessartificialFrame17;
        Object objAccessartificialFrame18;
        Object objAccessartificialFrame19;
        Object[] objArr8;
        int i13;
        int i14;
        ArrayList arrayList;
        String[] strArr;
        int i15;
        int i16;
        int i17;
        Object objAccessartificialFrame20;
        int i18 = 2 % 2;
        Object[] objArr9 = new Object[1];
        a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 59504, new char[]{5469, 64961, 50302, 44279, 46879, 40842, 26154, 18711, 20939, 14436, 172, 60222, 62369, 55864, 44354, 46532, 40033, 25788, 20230, 22458, 15907, 344}, objArr9);
        String str2 = (String) objArr9[0];
        Object[] objArr10 = new Object[1];
        a(55373 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), new char[]{5465, 52509, 42439, 40363, 29819, 11480, 1174, 65397, 55089, 36840, 26194, 24071, 14025, 61112, 49519}, objArr10);
        String str3 = (String) objArr10[0];
        Object[] objArr11 = new Object[1];
        a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 51832, new char[]{5462, 57296, 32848, 19194, 16166, 57745, 43539, 40073, 16691, 3047, 64749, 41290, 27603, 23649, 1775, 51986}, objArr11);
        String str4 = (String) objArr11[0];
        Object[] objArr12 = new Object[1];
        a(43488 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), new char[]{5461, 48263, 18151, 59599, 45620, 17422, 61042, 45148, 23436, 60810, 47097, 22977, 58123, 46336, 24426, 57672}, objArr12);
        String str5 = (String) objArr12[0];
        Object objAccessartificialFrame21 = ArtificialStackFrames.accessartificialFrame(-2127922582);
        if (objAccessartificialFrame21 == null) {
            int maximumFlingVelocity = (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 30;
            char defaultSize = (char) (View.getDefaultSize(0, 0) + 49362);
            int scrollBarSize = (ViewConfiguration.getScrollBarSize() >> 8) + 684;
            byte[] bArr = $$a;
            byte b = bArr[22];
            Object[] objArr13 = new Object[1];
            b(b, (byte) (b - 2), bArr[52], objArr13);
            objAccessartificialFrame21 = ArtificialStackFrames.coroutineCreation(maximumFlingVelocity, defaultSize, scrollBarSize, 508509282, false, (String) objArr13[0], null);
        }
        long j4 = ((Field) objAccessartificialFrame21).getLong(null);
        if (j4 != -1) {
            int i19 = artificialFrame + 17;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i19 % 128;
            if (i19 % 2 == 0 ? j4 + 2034 < ((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue() : j4 % 2034 < ((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue()) {
                baseContext = getBaseContext();
                if (baseContext == null) {
                    Object[] objArr14 = new Object[1];
                    a(21466 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), new char[]{5469, 18057, 45806, 61151, 23103, 46610, 57978, 24559, 35717, 59391, 21442, 36731, 64313, 22336, 32946, 64640, 10490, 34014, 61486, 11268, 39028, 62883, 8604, 40436, 51669, 9531}, objArr14);
                    Class<?> cls = Class.forName((String) objArr14[0]);
                    Object[] objArr15 = new Object[1];
                    a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(0) + 44086, new char[]{5471, 47378, 19960, 4191, 42037, 18581, 8042, 41728, 30612, 6783, 44766, 29372, 283, 54722, 31154, 3072, 53475, 26457}, objArr15);
                    baseContext = (Context) cls.getMethod((String) objArr15[0], new Class[0]).invoke(null, null);
                }
                if (baseContext != null) {
                    i = artificialFrame + 67;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i % 128;
                    if (i % 2 != 0) {
                        int i20 = 47 / 0;
                        if (baseContext instanceof ContextWrapper) {
                            if (((ContextWrapper) baseContext).getBaseContext() != null) {
                                baseContext = null;
                            }
                        }
                    } else if (baseContext instanceof ContextWrapper) {
                        if (((ContextWrapper) baseContext).getBaseContext() != null) {
                            baseContext = null;
                        }
                    }
                    baseContext = baseContext.getApplicationContext();
                }
                try {
                    Object[] objArr16 = {baseContext, Integer.valueOf(((Integer) Class.forName(str4).getMethod(str5, Object.class).invoke(null, this)).intValue()), 1643199463};
                    byte[] bArr2 = $$d;
                    Object[] objArr17 = new Object[1];
                    c(bArr2[64], bArr2[609], bArr2[8], objArr17);
                    Class<?> cls2 = Class.forName((String) objArr17[0]);
                    Object[] objArr18 = new Object[1];
                    c(bArr2[609], (byte) (-bArr2[461]), bArr2[334], objArr18);
                    objArr = (Object[]) cls2.getMethod((String) objArr18[0], Context.class, Integer.TYPE, Integer.TYPE).invoke(null, objArr16);
                    if (baseContext != null) {
                        int i21 = getARTIFICIAL_FRAME_PACKAGE_NAME + 121;
                        artificialFrame = i21 % 128;
                        int i22 = i21 % 2;
                        objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(777251007);
                        if (objAccessartificialFrame == null) {
                            int scrollBarFadeDuration = 30 - (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                            char fadingEdgeLength = (char) ((ViewConfiguration.getFadingEdgeLength() >> 16) + 49362);
                            int modifierMetaStateMask = ((byte) KeyEvent.getModifierMetaStateMask()) + 685;
                            byte[] bArr3 = $$a;
                            Object[] objArr19 = new Object[1];
                            b(bArr3[52], bArr3[56], bArr3[78], objArr19);
                            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(scrollBarFadeDuration, fadingEdgeLength, modifierMetaStateMask, -1321816393, false, (String) objArr19[0], null);
                        }
                        ((Field) objAccessartificialFrame).set(null, objArr);
                        try {
                            Long lValueOf2 = Long.valueOf(((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue());
                            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-2127922582);
                            if (objAccessartificialFrame2 == null) {
                                int modifierMetaStateMask2 = ((byte) KeyEvent.getModifierMetaStateMask()) + Ascii.US;
                                char scrollDefaultDelay = (char) (49362 - (ViewConfiguration.getScrollDefaultDelay() >> 16));
                                int iCombineMeasuredStates = View.combineMeasuredStates(0, 0) + 684;
                                byte[] bArr4 = $$a;
                                byte b2 = bArr4[22];
                                Object[] objArr20 = new Object[1];
                                b(b2, (byte) (b2 - 2), bArr4[52], objArr20);
                                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(modifierMetaStateMask2, scrollDefaultDelay, iCombineMeasuredStates, 508509282, false, (String) objArr20[0], null);
                            }
                            ((Field) objAccessartificialFrame2).set(null, lValueOf2);
                        } catch (Exception unused) {
                            throw new RuntimeException();
                        }
                    } else {
                        objArr = objArr;
                    }
                    objArr2 = objArr;
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            } else {
                Object objAccessartificialFrame22 = ArtificialStackFrames.accessartificialFrame(777251007);
                if (objAccessartificialFrame22 == null) {
                    int gidForName = Process.getGidForName("") + 31;
                    char defaultSize2 = (char) (49362 - View.getDefaultSize(0, 0));
                    int scrollDefaultDelay2 = (ViewConfiguration.getScrollDefaultDelay() >> 16) + 684;
                    byte[] bArr5 = $$a;
                    Object[] objArr21 = new Object[1];
                    b(bArr5[52], bArr5[56], bArr5[78], objArr21);
                    objAccessartificialFrame22 = ArtificialStackFrames.coroutineCreation(gidForName, defaultSize2, scrollDefaultDelay2, -1321816393, false, (String) objArr21[0], null);
                }
                Object[] objArr22 = (Object[]) ((Field) objAccessartificialFrame22).get(null);
                objArr2 = new Object[]{new int[]{((int[]) objArr22[0])[0]}, new int[]{((int[]) objArr22[1])[0]}, new int[1], (String) objArr22[3]};
                int iCodePointAt = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) + 1009830243;
                int i23 = ~iCodePointAt;
                int i24 = (-932641058) + ((~(214913333 | i23)) * (-560)) + ((~(iCodePointAt | (-553650889))) * (-560)) + (((~(763710441 | i23)) | 4853780) * 560) + 1643199463;
                int i25 = (i24 << 13) ^ i24;
                int i26 = i25 ^ (i25 >>> 17);
                ((int[]) objArr2[2])[0] = i26 ^ (i26 << 5);
            }
        } else {
            baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr110 = new Object[1];
                a(21466 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), new char[]{5469, 18057, 45806, 61151, 23103, 46610, 57978, 24559, 35717, 59391, 21442, 36731, 64313, 22336, 32946, 64640, 10490, 34014, 61486, 11268, 39028, 62883, 8604, 40436, 51669, 9531}, objArr110);
                Class<?> cls3 = Class.forName((String) objArr110[0]);
                Object[] objArr111 = new Object[1];
                a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(0) + 44086, new char[]{5471, 47378, 19960, 4191, 42037, 18581, 8042, 41728, 30612, 6783, 44766, 29372, 283, 54722, 31154, 3072, 53475, 26457}, objArr111);
                baseContext = (Context) cls3.getMethod((String) objArr111[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                i = artificialFrame + 67;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i % 128;
                if (i % 2 != 0) {
                    int i27 = 47 / 0;
                    if (baseContext instanceof ContextWrapper) {
                        if (((ContextWrapper) baseContext).getBaseContext() != null) {
                            baseContext = null;
                        }
                    }
                } else if (baseContext instanceof ContextWrapper) {
                    if (((ContextWrapper) baseContext).getBaseContext() != null) {
                        baseContext = null;
                    }
                }
                baseContext = baseContext.getApplicationContext();
            }
            Object[] objArr112 = {baseContext, Integer.valueOf(((Integer) Class.forName(str4).getMethod(str5, Object.class).invoke(null, this)).intValue()), 1643199463};
            byte[] bArr6 = $$d;
            Object[] objArr113 = new Object[1];
            c(bArr6[64], bArr6[609], bArr6[8], objArr113);
            Class<?> cls4 = Class.forName((String) objArr113[0]);
            Object[] objArr114 = new Object[1];
            c(bArr6[609], (byte) (-bArr6[461]), bArr6[334], objArr114);
            objArr = (Object[]) cls4.getMethod((String) objArr114[0], Context.class, Integer.TYPE, Integer.TYPE).invoke(null, objArr112);
            if (baseContext != null) {
                int i28 = getARTIFICIAL_FRAME_PACKAGE_NAME + 121;
                artificialFrame = i28 % 128;
                int i29 = i28 % 2;
                objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(777251007);
                if (objAccessartificialFrame == null) {
                    int scrollBarFadeDuration2 = 30 - (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                    char fadingEdgeLength2 = (char) ((ViewConfiguration.getFadingEdgeLength() >> 16) + 49362);
                    int modifierMetaStateMask3 = ((byte) KeyEvent.getModifierMetaStateMask()) + 685;
                    byte[] bArr7 = $$a;
                    Object[] objArr115 = new Object[1];
                    b(bArr7[52], bArr7[56], bArr7[78], objArr115);
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(scrollBarFadeDuration2, fadingEdgeLength2, modifierMetaStateMask3, -1321816393, false, (String) objArr115[0], null);
                }
                ((Field) objAccessartificialFrame).set(null, objArr);
                Long lValueOf3 = Long.valueOf(((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue());
                objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-2127922582);
                if (objAccessartificialFrame2 == null) {
                    int modifierMetaStateMask4 = ((byte) KeyEvent.getModifierMetaStateMask()) + Ascii.US;
                    char scrollDefaultDelay3 = (char) (49362 - (ViewConfiguration.getScrollDefaultDelay() >> 16));
                    int iCombineMeasuredStates2 = View.combineMeasuredStates(0, 0) + 684;
                    byte[] bArr8 = $$a;
                    byte b3 = bArr8[22];
                    Object[] objArr23 = new Object[1];
                    b(b3, (byte) (b3 - 2), bArr8[52], objArr23);
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(modifierMetaStateMask4, scrollDefaultDelay3, iCombineMeasuredStates2, 508509282, false, (String) objArr23[0], null);
                }
                ((Field) objAccessartificialFrame2).set(null, lValueOf3);
            } else {
                objArr = objArr;
            }
            objArr2 = objArr;
        }
        int i30 = ((int[]) objArr2[1])[0];
        int i31 = ((int[]) objArr2[0])[0];
        if (i31 == i30) {
            int i32 = getARTIFICIAL_FRAME_PACKAGE_NAME + AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
            artificialFrame = i32 % 128;
            int i33 = i32 % 2;
            int i34 = ((int[]) objArr2[2])[0];
            Object[] objArr24 = {new int[]{((int[]) objArr2[0])[0]}, new int[]{((int[]) objArr2[1])[0]}, new int[1], (String) objArr2[3]};
            int iIdentityHashCode = System.identityHashCode(this);
            int i35 = i34 + 820366890 + (((~(367728942 | iIdentityHashCode)) | 536904400) * (-140)) + ((~(904633342 | iIdentityHashCode)) * 70) + (((~(iIdentityHashCode | 610894832)) | 830642910) * 70);
            int i36 = (i35 << 13) ^ i35;
            int i37 = i36 ^ (i36 >>> 17);
            ((int[]) objArr24[2])[0] = i37 ^ (i37 << 5);
        } else {
            try {
                Object[] objArr25 = {Long.valueOf(((long) (i30 ^ i31)) ^ (((long) 1249320304) << 32)), Long.valueOf(1249320816)};
                byte[] bArr9 = $$d;
                Object[] objArr26 = new Object[1];
                c((short) (-bArr9[21]), bArr9[332], bArr9[8], objArr26);
                Class<?> cls5 = Class.forName((String) objArr26[0]);
                Object[] objArr27 = new Object[1];
                c((short) 116, bArr9[5], bArr9[72], objArr27);
                cls5.getMethod((String) objArr27[0], Long.TYPE, Long.TYPE).invoke(null, objArr25);
                int i38 = ((int[]) objArr2[2])[0];
                Object[] objArr28 = {new int[]{((int[]) objArr2[0])[0]}, new int[]{((int[]) objArr2[1])[0]}, new int[1], (String) objArr2[3]};
                int iIdentityHashCode2 = System.identityHashCode(this);
                int i39 = i38 + (((~(iIdentityHashCode2 | 290594830)) | 688028944) * 56) + 31300950 + (((~((~iIdentityHashCode2) | 688028944)) | 290594830) * 56);
                int i40 = (i39 << 13) ^ i39;
                int i41 = i40 ^ (i40 >>> 17);
                ((int[]) objArr28[2])[0] = i41 ^ (i41 << 5);
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 == null) {
                    throw th2;
                }
                throw cause2;
            }
        }
        Object objAccessartificialFrame23 = ArtificialStackFrames.accessartificialFrame(-1168947751);
        if (objAccessartificialFrame23 == null) {
            int iLastIndexOf = TextUtils.lastIndexOf("", '0', 0) + 37;
            char packedPositionType = (char) ExpandableListView.getPackedPositionType(0L);
            int trimmedLength = 540 - TextUtils.getTrimmedLength("");
            byte[] bArr10 = $$a;
            Object[] objArr29 = new Object[1];
            b((byte) (bArr10[110] - 1), bArr10[12], bArr10[56], objArr29);
            objAccessartificialFrame23 = ArtificialStackFrames.coroutineCreation(iLastIndexOf, packedPositionType, trimmedLength, 624296913, false, (String) objArr29[0], null);
        }
        long j5 = ((Field) objAccessartificialFrame23).getLong(null);
        if (j5 != -1) {
            int i42 = getARTIFICIAL_FRAME_PACKAGE_NAME + 83;
            artificialFrame = i42 % 128;
            int i43 = i42 % 2;
            if (j5 + 1973 >= ((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame24 = ArtificialStackFrames.accessartificialFrame(-1339222025);
                if (objAccessartificialFrame24 == null) {
                    int i44 = 37 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1));
                    char cCombineMeasuredStates = (char) View.combineMeasuredStates(0, 0);
                    int defaultSize3 = 540 - View.getDefaultSize(0, 0);
                    byte[] bArr11 = $$a;
                    Object[] objArr30 = new Object[1];
                    b((byte) (bArr11[110] - 1), bArr11[108], bArr11[56], objArr30);
                    objAccessartificialFrame24 = ArtificialStackFrames.coroutineCreation(i44, cCombineMeasuredStates, defaultSize3, 793268735, false, (String) objArr30[0], null);
                }
                Object[] objArr31 = (Object[]) ((Field) objAccessartificialFrame24).get(null);
                objArr3 = new Object[]{new int[1], new int[1], new int[1]};
                int i45 = ((int[]) objArr31[2])[0];
                int i46 = ((int[]) objArr31[1])[0];
                ((int[]) objArr3[2])[0] = i45;
                ((int[]) objArr3[1])[0] = i46;
                int layoutDirection = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().getLayoutDirection();
                int i47 = 1279395388 + (((~(layoutDirection | 267735178)) | (-1342168044)) * 305) + (((~((~layoutDirection) | 267735178)) | (-1083886572)) * 305) + 629970238;
                int i48 = (i47 << 13) ^ i47;
                int i49 = i48 ^ (i48 >>> 17);
                ((int[]) objArr3[0])[0] = i49 ^ (i49 << 5);
            } else {
                try {
                    objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1717965552);
                    if (objAccessartificialFrame3 == null) {
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 20, (char) (KeyEvent.getDeadChar(0, 0) + 39516), 981 - TextUtils.indexOf((CharSequence) "", '0', 0), 117222168, false, null, new Class[0]);
                    }
                    Object[] objArr32 = {null, ((Constructor) objAccessartificialFrame3).newInstance(null), 629970238, 0};
                    objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-501205803);
                    if (objAccessartificialFrame4 == null) {
                        int iMakeMeasureSpec = 36 - View.MeasureSpec.makeMeasureSpec(0, 0);
                        char windowTouchSlop2 = (char) (ViewConfiguration.getWindowTouchSlop() >> 8);
                        int packedPositionGroup = 540 - ExpandableListView.getPackedPositionGroup(0L);
                        byte b4 = (byte) 47;
                        Object[] objArr33 = new Object[1];
                        b(b4, (byte) (b4 & 243), (byte) ($$a[110] - 1), objArr33);
                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(iMakeMeasureSpec, windowTouchSlop2, packedPositionGroup, 2101703389, false, (String) objArr33[0], new Class[]{(Class) ArtificialStackFrames.coroutineCreation(Color.blue(0) + 54, (char) ((ViewConfiguration.getLongPressTimeout() >> 16) + 833), 624 - AndroidCharacter.getMirror('0')), (Class) ArtificialStackFrames.coroutineCreation(Color.red(0) + 54, (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), 630 - Drawable.resolveOpacity(0, 0)), Integer.TYPE, Integer.TYPE});
                    }
                    Object[] objArr34 = (Object[]) ((Method) objAccessartificialFrame4).invoke(null, objArr32);
                    objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1339222025);
                    if (objAccessartificialFrame5 == null) {
                        int bitsPerPixel = ImageFormat.getBitsPerPixel(0) + 37;
                        char c = (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) - 1);
                        int i50 = 540 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1));
                        byte[] bArr12 = $$a;
                        Object[] objArr35 = new Object[1];
                        b((byte) (bArr12[110] - 1), bArr12[108], bArr12[56], objArr35);
                        objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(bitsPerPixel, c, i50, 793268735, false, (String) objArr35[0], null);
                    }
                    ((Field) objAccessartificialFrame5).set(null, objArr34);
                    try {
                        Long lValueOf4 = Long.valueOf(((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1168947751);
                        if (objAccessartificialFrame6 == null) {
                            int i51 = 37 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                            char keyRepeatDelay = (char) (ViewConfiguration.getKeyRepeatDelay() >> 16);
                            int packedPositionType2 = 540 - ExpandableListView.getPackedPositionType(0L);
                            byte[] bArr13 = $$a;
                            Object[] objArr36 = new Object[1];
                            b((byte) (bArr13[110] - 1), bArr13[12], bArr13[56], objArr36);
                            objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(i51, keyRepeatDelay, packedPositionType2, 624296913, false, (String) objArr36[0], null);
                        }
                        ((Field) objAccessartificialFrame6).set(null, lValueOf4);
                        objArr3 = objArr34;
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
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 20, (char) (KeyEvent.getDeadChar(0, 0) + 39516), 981 - TextUtils.indexOf((CharSequence) "", '0', 0), 117222168, false, null, new Class[0]);
            }
            Object[] objArr37 = {null, ((Constructor) objAccessartificialFrame3).newInstance(null), 629970238, 0};
            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-501205803);
            if (objAccessartificialFrame4 == null) {
                int iMakeMeasureSpec2 = 36 - View.MeasureSpec.makeMeasureSpec(0, 0);
                char windowTouchSlop3 = (char) (ViewConfiguration.getWindowTouchSlop() >> 8);
                int packedPositionGroup2 = 540 - ExpandableListView.getPackedPositionGroup(0L);
                byte b5 = (byte) 47;
                Object[] objArr38 = new Object[1];
                b(b5, (byte) (b5 & 243), (byte) ($$a[110] - 1), objArr38);
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(iMakeMeasureSpec2, windowTouchSlop3, packedPositionGroup2, 2101703389, false, (String) objArr38[0], new Class[]{(Class) ArtificialStackFrames.coroutineCreation(Color.blue(0) + 54, (char) ((ViewConfiguration.getLongPressTimeout() >> 16) + 833), 624 - AndroidCharacter.getMirror('0')), (Class) ArtificialStackFrames.coroutineCreation(Color.red(0) + 54, (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), 630 - Drawable.resolveOpacity(0, 0)), Integer.TYPE, Integer.TYPE});
            }
            Object[] objArr39 = (Object[]) ((Method) objAccessartificialFrame4).invoke(null, objArr37);
            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1339222025);
            if (objAccessartificialFrame5 == null) {
                int bitsPerPixel2 = ImageFormat.getBitsPerPixel(0) + 37;
                char c2 = (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) - 1);
                int i52 = 540 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1));
                byte[] bArr14 = $$a;
                Object[] objArr310 = new Object[1];
                b((byte) (bArr14[110] - 1), bArr14[108], bArr14[56], objArr310);
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(bitsPerPixel2, c2, i52, 793268735, false, (String) objArr310[0], null);
            }
            ((Field) objAccessartificialFrame5).set(null, objArr39);
            Long lValueOf5 = Long.valueOf(((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-1168947751);
            if (objAccessartificialFrame6 == null) {
                int i53 = 37 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                char keyRepeatDelay2 = (char) (ViewConfiguration.getKeyRepeatDelay() >> 16);
                int packedPositionType3 = 540 - ExpandableListView.getPackedPositionType(0L);
                byte[] bArr15 = $$a;
                Object[] objArr311 = new Object[1];
                b((byte) (bArr15[110] - 1), bArr15[12], bArr15[56], objArr311);
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(i53, keyRepeatDelay2, packedPositionType3, 624296913, false, (String) objArr311[0], null);
            }
            ((Field) objAccessartificialFrame6).set(null, lValueOf5);
            objArr3 = objArr39;
        }
        Object obj = objArr3[1];
        int i54 = ((int[]) obj)[0];
        Object obj2 = objArr3[2];
        int i55 = ((int[]) obj2)[0];
        if (i55 == i54) {
            Object[] objArr40 = {new int[1], new int[1], new int[1]};
            int i56 = ((int[]) objArr3[0])[0];
            int i57 = ((int[]) obj2)[0];
            int i58 = ((int[]) obj)[0];
            ((int[]) objArr40[2])[0] = i57;
            ((int[]) objArr40[1])[0] = i58;
            int iIdentityHashCode3 = System.identityHashCode(this);
            int i59 = i56 + (-817678479) + ((~((~iIdentityHashCode3) | 1342118845)) * (-116)) + ((62722489 | iIdentityHashCode3) * 116) + (((~(iIdentityHashCode3 | (-1288899261))) | 9502904) * 116);
            int i60 = (i59 << 13) ^ i59;
            int i61 = i60 ^ (i60 >>> 17);
            ((int[]) objArr40[0])[0] = i61 ^ (i61 << 5);
            i2 = 0;
        } else {
            Object[] objArr41 = {Long.valueOf(((long) (i54 ^ i55)) ^ (((long) (-981820242)) << 32)), Long.valueOf(-981824338)};
            byte[] bArr16 = $$d;
            Object[] objArr42 = new Object[1];
            c((short) 118, bArr16[315], bArr16[8], objArr42);
            Class<?> cls6 = Class.forName((String) objArr42[0]);
            Object[] objArr43 = new Object[1];
            c((short) 116, bArr16[5], bArr16[72], objArr43);
            cls6.getMethod((String) objArr43[0], Long.TYPE, Long.TYPE).invoke(null, objArr41);
            Object[] objArr44 = {new int[1], new int[1], new int[1]};
            int i62 = ((int[]) objArr3[0])[0];
            int i63 = ((int[]) objArr3[2])[0];
            int i64 = ((int[]) objArr3[1])[0];
            ((int[]) objArr44[2])[0] = i63;
            ((int[]) objArr44[1])[0] = i64;
            int iIdentityHashCode4 = System.identityHashCode(this);
            int i65 = i62 + (-1386904282) + (((~((-546316475) | (~iIdentityHashCode4))) | (-805305276)) * (-591)) + ((iIdentityHashCode4 | (-546316475)) * 591);
            int i66 = (i65 << 13) ^ i65;
            int i67 = i66 ^ (i66 >>> 17);
            i2 = 0;
            ((int[]) objArr44[0])[0] = i67 ^ (i67 << 5);
        }
        Object objAccessartificialFrame25 = ArtificialStackFrames.accessartificialFrame(1313006081);
        if (objAccessartificialFrame25 == null) {
            int iArgb = Color.argb(i2, i2, i2, i2) + 21;
            char cAlpha = (char) Color.alpha(i2);
            int maximumDrawingCacheSize = 465 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
            byte[] bArr17 = $$a;
            Object[] objArr45 = new Object[1];
            b((byte) (bArr17[110] - 1), bArr17[12], bArr17[56], objArr45);
            objAccessartificialFrame25 = ArtificialStackFrames.coroutineCreation(iArgb, cAlpha, maximumDrawingCacheSize, -785931255, false, (String) objArr45[0], null);
        }
        long j6 = ((Field) objAccessartificialFrame25).getLong(null);
        if (j6 == -1 || j6 + 1866 < ((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Context baseContext3 = getBaseContext();
            if (baseContext3 == null) {
                Object[] objArr46 = new Object[1];
                a((Process.myPid() >> 22) + 21467, new char[]{5469, 18057, 45806, 61151, 23103, 46610, 57978, 24559, 35717, 59391, 21442, 36731, 64313, 22336, 32946, 64640, 10490, 34014, 61486, 11268, 39028, 62883, 8604, 40436, 51669, 9531}, objArr46);
                Class<?> cls7 = Class.forName((String) objArr46[0]);
                Object[] objArr47 = new Object[1];
                a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 44119, new char[]{5471, 47378, 19960, 4191, 42037, 18581, 8042, 41728, 30612, 6783, 44766, 29372, 283, 54722, 31154, 3072, 53475, 26457}, objArr47);
                baseContext3 = (Context) cls7.getMethod((String) objArr47[0], new Class[0]).invoke(null, null);
            }
            if (baseContext3 != null) {
                baseContext3 = ((baseContext3 instanceof ContextWrapper) && ((ContextWrapper) baseContext3).getBaseContext() == null) ? null : baseContext3.getApplicationContext();
            }
            int iIntValue = ((Integer) Class.forName(str4).getMethod(str5, Object.class).invoke(null, this)).intValue();
            Object[] objArr48 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 19047, new char[]{5466, 24422, 33245, 51791, 15523, 24910, 43992, 7654, 17927, 35014, 64807, 10180, 26632, 53861, 1246, 18719, 46057, 58435, 11916, 37112, 50517, 4034, 28726, 47815, 61187, 20782, 39889, 52293, 14060, 31515, 44499, 6063, 22586, 33474, 63295, 14841, 25096, 54317, 7911, 17175, 46516, 65148, 8404, 27376, 57184, 455, 19045, 48297, 57674, 11046, 40379, 50778, 2233, 32047, 42904, 59808, 21092, 33932, 51555, 13296, 25631, 44576, 4274, 17754}, objArr48);
            String str6 = (String) objArr48[0];
            Object[] objArr49 = new Object[1];
            a(4001 - (ViewConfiguration.getLongPressTimeout() >> 16), new char[]{5385, 6826, 2587, 15290, 11229, 23423, 18634, 30831, 26629, 39340, 35139, 48821, 44678, 56866, 53142, 65386, 61215, 7355, 3167, 15786, 11721, 23919, 17119, 29226, 25117, 37809, 33616, 45301, 41156, 53300, 49536, 61809, 57641, 5838, 1644, 13837, 10157, 22296, 17599, 29838, 25645, 38343, 34147, 46341, 47779, 43585, 56293, 52097, 64315, 59614, 6191, 2121, 14826, 10508, 24316, 20125, 32358, 28548, 40830, 36628, 48304, 44032, 56740, 52678}, objArr49);
            Object[] objArr50 = {baseContext3, new String[]{str6, (String) objArr49[0]}, Integer.valueOf(iIntValue), 1, -450356239};
            byte[] bArr18 = $$d;
            Object[] objArr51 = new Object[1];
            c((short) 142, bArr18[66], bArr18[8], objArr51);
            Class<?> cls8 = Class.forName((String) objArr51[0]);
            Object[] objArr52 = new Object[1];
            c(bArr18[609], (byte) (-bArr18[461]), bArr18[334], objArr52);
            objArr4 = (Object[]) cls8.getMethod((String) objArr52[0], Context.class, String[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr50);
            int i68 = ((int[]) objArr4[0])[0];
            int i69 = ((int[]) objArr4[3])[0];
            if (baseContext3 != null) {
                Object objAccessartificialFrame26 = ArtificialStackFrames.accessartificialFrame(1142731807);
                if (objAccessartificialFrame26 == null) {
                    int iRgb = (-16777195) - Color.rgb(0, 0, 0);
                    char modifierMetaStateMask5 = (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 1);
                    int keyRepeatTimeout = (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 465;
                    byte[] bArr19 = $$a;
                    Object[] objArr53 = new Object[1];
                    b((byte) (bArr19[110] - 1), bArr19[108], bArr19[56], objArr53);
                    objAccessartificialFrame26 = ArtificialStackFrames.coroutineCreation(iRgb, modifierMetaStateMask5, keyRepeatTimeout, -612765161, false, (String) objArr53[0], null);
                }
                ((Field) objAccessartificialFrame26).set(null, objArr4);
                try {
                    Long lValueOf6 = Long.valueOf(((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame27 = ArtificialStackFrames.accessartificialFrame(1313006081);
                    if (objAccessartificialFrame27 == null) {
                        int keyRepeatTimeout2 = (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 21;
                        char defaultSize4 = (char) View.getDefaultSize(0, 0);
                        int packedPositionGroup3 = ExpandableListView.getPackedPositionGroup(0L) + 465;
                        byte[] bArr20 = $$a;
                        Object[] objArr54 = new Object[1];
                        b((byte) (bArr20[110] - 1), bArr20[12], bArr20[56], objArr54);
                        objAccessartificialFrame27 = ArtificialStackFrames.coroutineCreation(keyRepeatTimeout2, defaultSize4, packedPositionGroup3, -785931255, false, (String) objArr54[0], null);
                    }
                    ((Field) objAccessartificialFrame27).set(null, lValueOf6);
                } catch (Exception unused3) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object objAccessartificialFrame28 = ArtificialStackFrames.accessartificialFrame(1142731807);
            if (objAccessartificialFrame28 == null) {
                int i70 = 20 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1));
                char cResolveSize = (char) View.resolveSize(0, 0);
                int iIndexOf = 464 - TextUtils.indexOf((CharSequence) "", '0');
                byte[] bArr21 = $$a;
                Object[] objArr55 = new Object[1];
                b((byte) (bArr21[110] - 1), bArr21[108], bArr21[56], objArr55);
                objAccessartificialFrame28 = ArtificialStackFrames.coroutineCreation(i70, cResolveSize, iIndexOf, -612765161, false, (String) objArr55[0], null);
            }
            Object[] objArr56 = (Object[]) ((Field) objAccessartificialFrame28).get(null);
            objArr4 = new Object[]{new int[]{i}, strArr, new int[1], new int[]{i}};
            int i71 = ((int[]) objArr56[3])[0];
            int i72 = ((int[]) objArr56[0])[0];
            String[] strArr2 = (String[]) objArr56[1];
            int length = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() - 18276327;
            int i73 = (~(727498935 | length)) | 346242624;
            int i74 = ~((~length) | (-185892899));
            int i75 = (((-314374243) + ((i73 | i74) * (-470))) + (((~(length | 1073741559)) | i74) * 470)) - 450356239;
            int i76 = (i75 << 13) ^ i75;
            int i77 = i76 ^ (i76 >>> 17);
            ((int[]) objArr4[2])[0] = i77 ^ (i77 << 5);
        }
        int i78 = ((int[]) objArr4[0])[0];
        int i79 = ((int[]) objArr4[3])[0];
        if (i79 == i78) {
            Object[] objArr57 = {new int[]{i}, strArr, new int[1], new int[]{i}};
            int i80 = ((int[]) objArr4[2])[0];
            int i81 = ((int[]) objArr4[3])[0];
            int i82 = ((int[]) objArr4[0])[0];
            String[] strArr3 = (String[]) objArr4[1];
            int i83 = (int) Runtime.getRuntime().totalMemory();
            int i84 = ~(928041406 | i83);
            int i85 = i80 + 1730987778 + (((-1070779327) | i84) * (-814)) + ((i84 | (~((~i83) | 767691680)) | 624953760) * 407) + (((~(i83 | (-767691681))) | (~((-928041407) | i83)) | 624953760) * 407);
            int i86 = (i85 << 13) ^ i85;
            int i87 = i86 ^ (i86 >>> 17);
            ((int[]) objArr57[2])[0] = i87 ^ (i87 << 5);
            i3 = 0;
        } else {
            ArrayList arrayList2 = new ArrayList();
            String[] strArr4 = (String[]) objArr4[1];
            if (strArr4 != null) {
                for (String str7 : strArr4) {
                    arrayList2.add(str7);
                }
            }
            Object[] objArr58 = {Long.valueOf((((long) (-1909674674)) << 32) ^ ((long) (i78 ^ i79))), Long.valueOf(-1909674738)};
            byte[] bArr22 = $$d;
            Object[] objArr59 = new Object[1];
            c((short) 214, bArr22[142], bArr22[8], objArr59);
            Class<?> cls9 = Class.forName((String) objArr59[0]);
            Object[] objArr60 = new Object[1];
            c((short) 116, bArr22[5], bArr22[72], objArr60);
            cls9.getMethod((String) objArr60[0], Long.TYPE, Long.TYPE).invoke(null, objArr58);
            Object[] objArr61 = {new int[]{i}, strArr, new int[1], new int[]{i}};
            int i88 = ((int[]) objArr4[2])[0];
            int i89 = ((int[]) objArr4[3])[0];
            int i90 = ((int[]) objArr4[0])[0];
            String[] strArr5 = (String[]) objArr4[1];
            int iIdentityHashCode5 = System.identityHashCode(this);
            int i91 = i88 + 1119238613 + (((~(845753354 | iIdentityHashCode5)) | 143802852 | (~((-685403629) | iIdentityHashCode5))) * (-744)) + (((~iIdentityHashCode5) | 304152578) * 744) + ((iIdentityHashCode5 | (-143802853)) * 744);
            int i92 = (i91 << 13) ^ i91;
            int i93 = i92 ^ (i92 >>> 17);
            i3 = 0;
            ((int[]) objArr61[2])[0] = i93 ^ (i93 << 5);
        }
        Object objAccessartificialFrame29 = ArtificialStackFrames.accessartificialFrame(-444530678);
        if (objAccessartificialFrame29 == null) {
            int iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(i3, i3) + 26;
            char absoluteGravity2 = (char) Gravity.getAbsoluteGravity(i3, i3);
            int i94 = (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 1040;
            byte[] bArr23 = $$a;
            Object[] objArr62 = new Object[1];
            b((byte) (bArr23[110] - 1), bArr23[12], bArr23[56], objArr62);
            objAccessartificialFrame29 = ArtificialStackFrames.coroutineCreation(iMakeMeasureSpec3, absoluteGravity2, i94, 2061780482, false, (String) objArr62[0], null);
        }
        long j7 = ((Field) objAccessartificialFrame29).getLong(null);
        if (j7 == -1 || j7 + 4611686018427387892L < ((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue()) {
            int iIntValue2 = ((Integer) Class.forName(str4).getMethod(str5, Object.class).invoke(null, this)).intValue();
            Object[] objArr63 = {-1135603529};
            Object objAccessartificialFrame30 = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame30 == null) {
                objAccessartificialFrame30 = ArtificialStackFrames.coroutineCreation(View.MeasureSpec.getMode(0) + 8, (char) (22251 - (ViewConfiguration.getDoubleTapTimeout() >> 16)), KeyEvent.getDeadChar(0, 0) + 1033, 47343338, false, null, new Class[]{Integer.TYPE});
            }
            objArrAccessartificialFrame$78cbbd35 = SchemaManager$$ExternalSyntheticLambda5.accessartificialFrame$78cbbd35(iIntValue2, 0, ((Constructor) objAccessartificialFrame30).newInstance(objArr63), 1651858013, false);
            Object objAccessartificialFrame31 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame31 == null) {
                int iMakeMeasureSpec4 = View.MeasureSpec.makeMeasureSpec(0, 0) + 26;
                char cAxisFromString = (char) ((-1) - MotionEvent.axisFromString(""));
                int longPressTimeout = (ViewConfiguration.getLongPressTimeout() >> 16) + 1041;
                byte[] bArr24 = $$a;
                Object[] objArr64 = new Object[1];
                b((byte) (bArr24[110] - 1), bArr24[108], bArr24[56], objArr64);
                objAccessartificialFrame31 = ArtificialStackFrames.coroutineCreation(iMakeMeasureSpec4, cAxisFromString, longPressTimeout, 1145017376, false, (String) objArr64[0], null);
            }
            ((Field) objAccessartificialFrame31).set(null, objArrAccessartificialFrame$78cbbd35);
            try {
                Long lValueOf7 = Long.valueOf(((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame32 = ArtificialStackFrames.accessartificialFrame(-444530678);
                if (objAccessartificialFrame32 == null) {
                    int i95 = (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + 26;
                    char absoluteGravity3 = (char) Gravity.getAbsoluteGravity(0, 0);
                    int modifierMetaStateMask6 = ((byte) KeyEvent.getModifierMetaStateMask()) + Ascii.DC2;
                    byte[] bArr25 = $$a;
                    Object[] objArr65 = new Object[1];
                    b((byte) (bArr25[110] - 1), bArr25[12], bArr25[56], objArr65);
                    objAccessartificialFrame32 = ArtificialStackFrames.coroutineCreation(i95, absoluteGravity3, modifierMetaStateMask6, 2061780482, false, (String) objArr65[0], null);
                }
                ((Field) objAccessartificialFrame32).set(null, lValueOf7);
            } catch (Exception unused4) {
                throw new RuntimeException();
            }
        } else {
            Object objAccessartificialFrame33 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame33 == null) {
                int keyRepeatDelay3 = 26 - (ViewConfiguration.getKeyRepeatDelay() >> 16);
                char cResolveOpacity = (char) Drawable.resolveOpacity(0, 0);
                int absoluteGravity4 = Gravity.getAbsoluteGravity(0, 0) + 1041;
                byte[] bArr26 = $$a;
                Object[] objArr66 = new Object[1];
                b((byte) (bArr26[110] - 1), bArr26[108], bArr26[56], objArr66);
                objAccessartificialFrame33 = ArtificialStackFrames.coroutineCreation(keyRepeatDelay3, cResolveOpacity, absoluteGravity4, 1145017376, false, (String) objArr66[0], null);
            }
            Object[] objArr67 = (Object[]) ((Field) objAccessartificialFrame33).get(null);
            objArrAccessartificialFrame$78cbbd35 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
            int i96 = ((int[]) objArr67[3])[0];
            int i97 = ((int[]) objArr67[2])[0];
            String[] strArr6 = (String[]) objArr67[0];
            int i98 = Settings.System.getInt(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getContentResolver(), "screen_brightness", -1);
            int i99 = ~i98;
            int i100 = (-1398827870) + ((~(129096998 | i99)) * 979) + ((i98 | 207200805) * (-979)) + (((~(i98 | 129096998)) | (~(i99 | 207200805))) * 979) + 1651858013;
            int i101 = (i100 << 13) ^ i100;
            int i102 = i101 ^ (i101 >>> 17);
            ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0] = i102 ^ (i102 << 5);
        }
        int i103 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
        int i104 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
        if (i104 == i103) {
            Object[] objArr68 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i105 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i106 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i107 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr7 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int length2 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 1184357322;
            int i108 = ~length2;
            int i109 = (~(179962257 | i108)) | (-268158866) | (~(258066064 | i108));
            int i110 = i105 + (-660568414) + (((~(length2 | (-169869457))) | i109) * 590) + (i109 * (-1180)) + (((~((-258066065) | i108)) | (~(i108 | (-179962258)))) * 590);
            int i111 = (i110 << 13) ^ i110;
            int i112 = i111 ^ (i111 >>> 17);
            ((int[]) objArr68[1])[0] = i112 ^ (i112 << 5);
        } else {
            ArrayList arrayList3 = new ArrayList();
            String[] strArr8 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            if (strArr8 != null) {
                for (String str8 : strArr8) {
                    arrayList3.add(str8);
                }
            }
            Object[] objArr69 = {Long.valueOf((((long) (-1687291281)) << 32) ^ ((long) (i103 ^ i104))), Long.valueOf(-1687291283)};
            byte[] bArr27 = $$d;
            Object[] objArr70 = new Object[1];
            c((short) 252, (byte) (-bArr27[178]), bArr27[64], objArr70);
            Class<?> cls10 = Class.forName((String) objArr70[0]);
            Object[] objArr71 = new Object[1];
            c((short) 116, bArr27[5], bArr27[72], objArr71);
            cls10.getMethod((String) objArr71[0], Long.TYPE, Long.TYPE).invoke(null, objArr69);
            Object[] objArr72 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i113 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i114 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i115 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr9 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int i116 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().densityDpi;
            int i117 = ~i116;
            int i118 = 1344309608 + (((~((-953215077) | i117)) | 944810080) * (-1188));
            int i119 = (~(i116 | 953215076)) | 944810080;
            int i120 = ~(1031318883 | i117);
            int i121 = i113 + i118 + ((i119 | i120) * 594) + (((~(953215076 | i117)) | (-1039723880) | i120) * 594);
            int i122 = i121 ^ (i121 << 13);
            int i123 = i122 ^ (i122 >>> 17);
            ((int[]) objArr72[1])[0] = i123 ^ (i123 << 5);
        }
        Object objAccessartificialFrame34 = ArtificialStackFrames.accessartificialFrame(-1283093189);
        if (objAccessartificialFrame34 == null) {
            int minimumFlingVelocity = (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 30;
            char scrollBarFadeDuration3 = (char) ((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 49362);
            int i124 = 684 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
            byte[] bArr28 = $$a;
            byte b6 = bArr28[22];
            Object[] objArr73 = new Object[1];
            b(b6, (byte) (b6 | 53), bArr28[14], objArr73);
            objAccessartificialFrame34 = ArtificialStackFrames.coroutineCreation(minimumFlingVelocity, scrollBarFadeDuration3, i124, 752929587, false, (String) objArr73[0], null);
        }
        long j8 = ((Field) objAccessartificialFrame34).getLong(null);
        if (j8 != -1) {
            if (j8 + 1952 >= ((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame35 = ArtificialStackFrames.accessartificialFrame(-326560385);
                if (objAccessartificialFrame35 == null) {
                    int i125 = 30 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1));
                    char pressedStateDuration = (char) (49362 - (ViewConfiguration.getPressedStateDuration() >> 16));
                    int capsMode = 684 - TextUtils.getCapsMode("", 0, 0);
                    byte[] bArr29 = $$a;
                    Object[] objArr74 = new Object[1];
                    b(bArr29[81], (byte) 70, bArr29[14], objArr74);
                    objAccessartificialFrame35 = ArtificialStackFrames.coroutineCreation(i125, pressedStateDuration, capsMode, 1944867703, false, (String) objArr74[0], null);
                }
                Object[] objArr75 = (Object[]) ((Field) objAccessartificialFrame35).get(null);
                objArr5 = new Object[]{new int[]{((int[]) objArr75[0])[0]}, new int[]{((int[]) objArr75[1])[0]}, new int[1], (String) objArr75[3]};
                int iElapsedRealtime = (int) SystemClock.elapsedRealtime();
                int i126 = ~iElapsedRealtime;
                int i127 = ((((-1234444416) + (((~(127771689 | i126)) | 807557332) * (-108))) + (((~(i126 | 850852085)) | ((~((-850852086) | iElapsedRealtime)) | 84476936)) * 54)) + ((iElapsedRealtime | 84476936) * 54)) - 1742146671;
                int i128 = (i127 << 13) ^ i127;
                int i129 = i128 ^ (i128 >>> 17);
                ((int[]) objArr5[2])[0] = i129 ^ (i129 << 5);
            } else {
                i4 = 0;
            }
            i6 = ((int[]) objArr5[1])[0];
            i7 = ((int[]) objArr5[0])[0];
            if (i7 == i6) {
                int i130 = ((int[]) objArr5[2])[0];
                Object[] objArr76 = {new int[]{((int[]) objArr5[0])[0]}, new int[]{((int[]) objArr5[1])[0]}, new int[1], (String) objArr5[3]};
                int i131 = ~(System.identityHashCode(this) | 711681023);
                int i132 = i130 + (((537019104 | i131) * (-196)) - 1013811998) + ((i131 | 174661919) * 196);
                int i133 = (i132 << 13) ^ i132;
                int i134 = i133 ^ (i133 >>> 17);
                ((int[]) objArr76[2])[0] = i134 ^ (i134 << 5);
                i8 = 0;
            } else {
                Object[] objArr77 = {Long.valueOf((((long) (-696522124)) << 32) ^ ((long) (i6 ^ i7))), Long.valueOf(-696522128)};
                byte[] bArr30 = $$d;
                Object[] objArr78 = new Object[1];
                c((short) (-bArr30[21]), bArr30[332], bArr30[8], objArr78);
                Class<?> cls11 = Class.forName((String) objArr78[0]);
                Object[] objArr79 = new Object[1];
                c((short) 116, bArr30[5], bArr30[72], objArr79);
                cls11.getMethod((String) objArr79[0], Long.TYPE, Long.TYPE).invoke(null, objArr77);
                int i135 = ((int[]) objArr5[2])[0];
                Object[] objArr80 = {new int[]{((int[]) objArr5[0])[0]}, new int[]{((int[]) objArr5[1])[0]}, new int[1], (String) objArr5[3]};
                int startElapsedRealtime = (int) Process.getStartElapsedRealtime();
                int i136 = (-1369658530) + ((~(startElapsedRealtime | 931268475)) * JfifUtil.MARKER_SOI);
                int i137 = ~startElapsedRealtime;
                int i138 = i135 + i136 + (((-5279873) | i137) * (-216)) + (((~(i137 | 931268475)) | 47355299) * JfifUtil.MARKER_SOI);
                int i139 = (i138 << 13) ^ i138;
                int i140 = i139 ^ (i139 >>> 17);
                i8 = 0;
                ((int[]) objArr80[2])[0] = i140 ^ (i140 << 5);
            }
            objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(1056123296);
            if (objAccessartificialFrame8 == null) {
                int size = 30 - View.MeasureSpec.getSize(i8);
                char cIndexOf = (char) (TextUtils.indexOf("", "") + 49362);
                int iAlpha = Color.alpha(i8) + 684;
                byte[] bArr31 = $$a;
                byte b7 = bArr31[52];
                Object[] objArr81 = new Object[1];
                b(bArr31[81], (byte) 85, b7, objArr81);
                objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(size, cIndexOf, iAlpha, -1583976536, false, (String) objArr81[0], null);
            }
            j = ((Field) objAccessartificialFrame8).getLong(null);
            if (j != -1 || j + 1939 < ((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object[] objArr82 = {Integer.valueOf(((Integer) Class.forName(str4).getMethod(str5, Object.class).invoke(null, this)).intValue()), 1149280877};
                short s = (short) TypedValues.CycleType.TYPE_ALPHA;
                byte[] bArr32 = $$d;
                Object[] objArr83 = new Object[1];
                c(s, (byte) (-bArr32[488]), bArr32[8], objArr83);
                Class<?> cls12 = Class.forName((String) objArr83[0]);
                Object[] objArr84 = new Object[1];
                c((short) 459, bArr32[4], bArr32[8], objArr84);
                objArr6 = (Object[]) cls12.getMethod((String) objArr84[0], Integer.TYPE, Integer.TYPE).invoke(null, objArr82);
                objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(910856866);
                if (objAccessartificialFrame9 == null) {
                    int maximumFlingVelocity2 = 30 - (ViewConfiguration.getMaximumFlingVelocity() >> 16);
                    char bitsPerPixel3 = (char) (49361 - ImageFormat.getBitsPerPixel(0));
                    int windowTouchSlop4 = (ViewConfiguration.getWindowTouchSlop() >> 8) + 684;
                    byte[] bArr33 = $$a;
                    Object[] objArr85 = new Object[1];
                    b((byte) (-bArr33[15]), (byte) 97, bArr33[56], objArr85);
                    objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(maximumFlingVelocity2, bitsPerPixel3, windowTouchSlop4, -1456483158, false, (String) objArr85[0], null);
                }
                ((Field) objAccessartificialFrame9).set(null, objArr6);
                try {
                    Long lValueOf8 = Long.valueOf(((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(1056123296);
                    if (objAccessartificialFrame10 == null) {
                        int capsMode2 = 30 - TextUtils.getCapsMode("", 0, 0);
                        char mode = (char) (49362 - View.MeasureSpec.getMode(0));
                        int capsMode3 = 684 - TextUtils.getCapsMode("", 0, 0);
                        byte[] bArr34 = $$a;
                        Object[] objArr86 = new Object[1];
                        b(bArr34[81], (byte) 85, bArr34[52], objArr86);
                        objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(capsMode2, mode, capsMode3, -1583976536, false, (String) objArr86[0], null);
                    }
                    ((Field) objAccessartificialFrame10).set(null, lValueOf8);
                } catch (Exception unused5) {
                    throw new RuntimeException();
                }
            } else {
                Object objAccessartificialFrame36 = ArtificialStackFrames.accessartificialFrame(910856866);
                if (objAccessartificialFrame36 == null) {
                    int gidForName2 = Process.getGidForName("") + 31;
                    char size2 = (char) (View.MeasureSpec.getSize(0) + 49362);
                    int i141 = 685 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                    byte[] bArr35 = $$a;
                    Object[] objArr87 = new Object[1];
                    b((byte) (-bArr35[15]), (byte) 97, bArr35[56], objArr87);
                    objAccessartificialFrame36 = ArtificialStackFrames.coroutineCreation(gidForName2, size2, i141, -1456483158, false, (String) objArr87[0], null);
                }
                Object[] objArr88 = (Object[]) ((Field) objAccessartificialFrame36).get(null);
                objArr6 = new Object[]{new int[]{((int[]) objArr88[0])[0]}, new int[]{((int[]) objArr88[1])[0]}, new int[1], (String) objArr88[3]};
                int iMyPid = Process.myPid();
                int i142 = 1857453166 + (((~((-43515618) | iMyPid)) | (-935108158)) * (-948)) + ((~((~iMyPid) | (-43294242))) * (-948)) + 939415481;
                int i143 = (i142 << 13) ^ i142;
                int i144 = i143 ^ (i143 >>> 17);
                ((int[]) objArr6[2])[0] = i144 ^ (i144 << 5);
            }
            i9 = ((int[]) objArr6[1])[0];
            i10 = ((int[]) objArr6[0])[0];
            if (i10 == i9) {
                int i145 = ((int[]) objArr6[2])[0];
                Object[] objArr89 = {new int[]{((int[]) objArr6[0])[0]}, new int[]{((int[]) objArr6[1])[0]}, new int[1], (String) objArr6[3]};
                int iNextInt = new Random().nextInt(1113871552);
                int i146 = i145 + (-1581907322) + (((~(905731038 | iNextInt)) | 72892736) * (-756)) + (((~iNextInt) | 905731038) * 756);
                int i147 = (i146 << 13) ^ i146;
                int i148 = i147 ^ (i147 >>> 17);
                ((int[]) objArr89[2])[0] = i148 ^ (i148 << 5);
            } else {
                new ArrayList().add((String) objArr6[3]);
                Object[] objArr90 = {Long.valueOf((((long) 1478142762) << 32) ^ ((long) (i9 ^ i10))), Long.valueOf(1478142778)};
                byte[] bArr36 = $$d;
                Object[] objArr91 = new Object[1];
                c((short) (-bArr36[21]), bArr36[332], bArr36[8], objArr91);
                Class<?> cls13 = Class.forName((String) objArr91[0]);
                Object[] objArr92 = new Object[1];
                c((short) 116, bArr36[5], bArr36[72], objArr92);
                cls13.getMethod((String) objArr92[0], Long.TYPE, Long.TYPE).invoke(null, objArr90);
                int i149 = ((int[]) objArr6[2])[0];
                Object[] objArr93 = {new int[]{((int[]) objArr6[0])[0]}, new int[]{((int[]) objArr6[1])[0]}, new int[1], (String) objArr6[3]};
                int iMaxMemory = (int) Runtime.getRuntime().maxMemory();
                int i150 = ~iMaxMemory;
                int i151 = (~((-273153588) | i150)) | 302627;
                int i152 = ~(iMaxMemory | 978321147);
                int i153 = i149 + 1130542528 + ((i151 | i152) * (-502)) + ((i152 | (~(i150 | (-272850961)))) * TypedValues.PositionType.TYPE_DRAWPATH);
                int i154 = (i153 << 13) ^ i153;
                int i155 = i154 ^ (i154 >>> 17);
                ((int[]) objArr93[2])[0] = i155 ^ (i155 << 5);
            }
            super.onStart();
            objAccessartificialFrame11 = ArtificialStackFrames.accessartificialFrame(1745676544);
            if (objAccessartificialFrame11 == null) {
                int i156 = (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 16;
                char c3 = (char) ((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) - 1);
                int iMyTid = (Process.myTid() >> 22) + 747;
                byte[] bArr37 = $$a;
                byte b8 = (byte) (bArr37[110] - 1);
                byte b9 = bArr37[12];
                byte b10 = bArr37[56];
                Object[] objArr94 = new Object[1];
                b(b8, b9, b10, objArr94);
                objAccessartificialFrame11 = ArtificialStackFrames.coroutineCreation(i156, c3, iMyTid, -144068856, false, (String) objArr94[0], null);
            }
            j2 = ((Field) objAccessartificialFrame11).getLong(null);
            if (j2 != -1 || j2 + 4611686018427387889L < ((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue()) {
                baseContext2 = getBaseContext();
                if (baseContext2 == null) {
                    Object[] objArr95 = new Object[1];
                    a(Gravity.getAbsoluteGravity(0, 0) + 21467, new char[]{5469, 18057, 45806, 61151, 23103, 46610, 57978, 24559, 35717, 59391, 21442, 36731, 64313, 22336, 32946, 64640, 10490, 34014, 61486, 11268, 39028, 62883, 8604, 40436, 51669, 9531}, objArr95);
                    Class<?> cls14 = Class.forName((String) objArr95[0]);
                    Object[] objArr96 = new Object[1];
                    a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 44088, new char[]{5471, 47378, 19960, 4191, 42037, 18581, 8042, 41728, 30612, 6783, 44766, 29372, 283, 54722, 31154, 3072, 53475, 26457}, objArr96);
                    baseContext2 = (Context) cls14.getMethod((String) objArr96[0], new Class[0]).invoke(null, null);
                }
                if (baseContext2 != null) {
                    if ((baseContext2 instanceof ContextWrapper) || ((ContextWrapper) baseContext2).getBaseContext() != null) {
                        baseContext2 = baseContext2.getApplicationContext();
                    } else {
                        baseContext2 = null;
                    }
                }
                Object[] objArr97 = {baseContext2, Integer.valueOf(((Integer) Class.forName(str4).getMethod(str5, Object.class).invoke(null, this)).intValue()), 0, -1696726223};
                byte[] bArr38 = $$d;
                Object[] objArr98 = new Object[1];
                c((short) 475, (byte) (-bArr38[354]), bArr38[18], objArr98);
                Class<?> cls15 = Class.forName((String) objArr98[0]);
                Object[] objArr99 = new Object[1];
                c((short) BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, bArr38[110], (byte) (bArr38[343] - 1), objArr99);
                objArr7 = (Object[]) cls15.getMethod((String) objArr99[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr97);
                objAccessartificialFrame12 = ArtificialStackFrames.accessartificialFrame(1575402270);
                if (objAccessartificialFrame12 == null) {
                    int iGreen = 17 - Color.green(0);
                    char c4 = (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) - 1);
                    int i157 = (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 748;
                    byte[] bArr39 = $$a;
                    Object[] objArr100 = new Object[1];
                    b((byte) (bArr39[110] - 1), bArr39[108], bArr39[56], objArr100);
                    objAccessartificialFrame12 = ArtificialStackFrames.coroutineCreation(iGreen, c4, i157, -1031537386, false, (String) objArr100[0], null);
                }
                ((Field) objAccessartificialFrame12).set(null, objArr7);
                try {
                    Long lValueOf9 = Long.valueOf(((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame13 = ArtificialStackFrames.accessartificialFrame(1745676544);
                    if (objAccessartificialFrame13 == null) {
                        int iCombineMeasuredStates3 = View.combineMeasuredStates(0, 0) + 17;
                        char cAlpha2 = (char) Color.alpha(0);
                        int i158 = (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 746;
                        byte[] bArr40 = $$a;
                        Object[] objArr101 = new Object[1];
                        b((byte) (bArr40[110] - 1), bArr40[12], bArr40[56], objArr101);
                        objAccessartificialFrame13 = ArtificialStackFrames.coroutineCreation(iCombineMeasuredStates3, cAlpha2, i158, -144068856, false, (String) objArr101[0], null);
                    }
                    ((Field) objAccessartificialFrame13).set(null, lValueOf9);
                } catch (Exception unused6) {
                    throw new RuntimeException();
                }
            } else {
                int i159 = getARTIFICIAL_FRAME_PACKAGE_NAME + 105;
                artificialFrame = i159 % 128;
                int i160 = i159 % 2;
                Object objAccessartificialFrame37 = ArtificialStackFrames.accessartificialFrame(1575402270);
                if (objAccessartificialFrame37 == null) {
                    int i161 = (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 16;
                    char cMyTid = (char) (Process.myTid() >> 22);
                    int tapTimeout = 747 - (ViewConfiguration.getTapTimeout() >> 16);
                    byte[] bArr41 = $$a;
                    Object[] objArr102 = new Object[1];
                    b((byte) (bArr41[110] - 1), bArr41[108], bArr41[56], objArr102);
                    objAccessartificialFrame37 = ArtificialStackFrames.coroutineCreation(i161, cMyTid, tapTimeout, -1031537386, false, (String) objArr102[0], null);
                }
                Object[] objArr103 = (Object[]) ((Field) objAccessartificialFrame37).get(null);
                objArr7 = new Object[]{list, new int[1], list, new int[]{i}, new int[]{i}};
                int i162 = ((int[]) objArr103[3])[0];
                int i163 = ((int[]) objArr103[4])[0];
                List list = (List) objArr103[0];
                List list2 = (List) objArr103[2];
                int iNextInt2 = new Random().nextInt();
                int i164 = 506581364 + (((-142675970) | iNextInt2) * (-381)) + (((~((~iNextInt2) | (-142684280))) | 605465078) * 381) + 1123210414;
                int i165 = (i164 << 13) ^ i164;
                int i166 = i165 ^ (i165 >>> 17);
                ((int[]) objArr7[1])[0] = i166 ^ (i166 << 5);
            }
            i11 = ((int[]) objArr7[4])[0];
            i12 = ((int[]) objArr7[3])[0];
            if (i12 == i11) {
                Object[] objArr104 = {list, new int[1], list, new int[]{i}, new int[]{i}};
                int i167 = ((int[]) objArr7[1])[0];
                int i168 = ((int[]) objArr7[3])[0];
                int i169 = ((int[]) objArr7[4])[0];
                List list3 = (List) objArr7[0];
                List list4 = (List) objArr7[2];
                int iIdentityHashCode6 = System.identityHashCode(this);
                int i170 = ~iIdentityHashCode6;
                int i171 = i167 + (-635952723) + (((~(94366196 | i170)) | (-699814655) | (~((-94366197) | iIdentityHashCode6))) * (-564)) + ((~(iIdentityHashCode6 | (-26624245))) * 1128) + (((~((-699814655) | i170)) | 67741952) * 564);
                int i172 = (i171 << 13) ^ i171;
                int i173 = i172 ^ (i172 >>> 17);
                ((int[]) objArr104[1])[0] = i173 ^ (i173 << 5);
            } else {
                ArrayList arrayList4 = new ArrayList();
                Object[] objArr105 = {objArr7};
                objAccessartificialFrame14 = ArtificialStackFrames.accessartificialFrame(1804664566);
                if (objAccessartificialFrame14 == null) {
                    objAccessartificialFrame14 = ArtificialStackFrames.coroutineCreation(Color.red(0) + 41, (char) (12468 - TextUtils.getTrimmedLength("")), MotionEvent.axisFromString("") + 3643, -185222914, false, "coroutineCreation", new Class[]{Object[].class});
                }
                arrayList4.add(((Method) objAccessartificialFrame14).invoke(null, objArr105));
                Object[] objArr106 = {objArr7};
                objAccessartificialFrame15 = ArtificialStackFrames.accessartificialFrame(-1243809191);
                if (objAccessartificialFrame15 == null) {
                    objAccessartificialFrame15 = ArtificialStackFrames.coroutineCreation(40 - TextUtils.lastIndexOf("", '0'), (char) (Color.rgb(0, 0, 0) + 16789684), View.MeasureSpec.makeMeasureSpec(0, 0) + 3642, 716815441, false, "ArtificialStackFrames", new Class[]{Object[].class});
                }
                arrayList4.add(((Method) objAccessartificialFrame15).invoke(null, objArr106));
                Object[] objArr107 = {Long.valueOf(((long) (i11 ^ i12)) ^ (((long) (-166942286)) << 32)), Long.valueOf(-166942278)};
                short s2 = (short) TypedValues.PositionType.TYPE_CURVE_FIT;
                byte[] bArr42 = $$d;
                Object[] objArr108 = new Object[1];
                c(s2, bArr42[27], bArr42[8], objArr108);
                Class<?> cls16 = Class.forName((String) objArr108[0]);
                Object[] objArr109 = new Object[1];
                c((short) 116, bArr42[5], bArr42[72], objArr109);
                cls16.getMethod((String) objArr109[0], Long.TYPE, Long.TYPE).invoke(null, objArr107);
                Object[] objArr116 = {list, new int[1], list, new int[]{i}, new int[]{i}};
                int i174 = ((int[]) objArr7[1])[0];
                int i175 = ((int[]) objArr7[3])[0];
                int i176 = ((int[]) objArr7[4])[0];
                List list5 = (List) objArr7[0];
                List list6 = (List) objArr7[2];
                int i177 = ~(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 80407914);
                int i178 = i174 + 1925394650 + (((~((-611859044) | i177)) | 6410585) * (-933)) + (((~(i177 | 6410585)) | (-611974012)) * 933) + 107265144;
                int i179 = i178 ^ (i178 << 13);
                int i180 = i179 ^ (i179 >>> 17);
                ((int[]) objArr116[1])[0] = i180 ^ (i180 << 5);
            }
            objAccessartificialFrame16 = ArtificialStackFrames.accessartificialFrame(-1268268649);
            if (objAccessartificialFrame16 == null) {
                int scrollBarSize2 = (ViewConfiguration.getScrollBarSize() >> 8) + 25;
                char pressedStateDuration2 = (char) (30068 - (ViewConfiguration.getPressedStateDuration() >> 16));
                int iMyPid2 = (Process.myPid() >> 22) + 816;
                byte[] bArr43 = $$a;
                Object[] objArr117 = new Object[1];
                b((byte) (bArr43[110] - 1), bArr43[12], bArr43[56], objArr117);
                objAccessartificialFrame16 = ArtificialStackFrames.coroutineCreation(scrollBarSize2, pressedStateDuration2, iMyPid2, 721586079, false, (String) objArr117[0], null);
            }
            j3 = ((Field) objAccessartificialFrame16).getLong(null);
            if (j3 != -1) {
                i16 = getARTIFICIAL_FRAME_PACKAGE_NAME + 5;
                artificialFrame = i16 % 128;
                if (i16 % 2 == 0) {
                    i17 = 0;
                    if (j3 - 1952 >= ((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[1]).invoke(null, new Object[0])).longValue()) {
                        objAccessartificialFrame20 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                        if (objAccessartificialFrame20 == null) {
                            int bitsPerPixel4 = 24 - ImageFormat.getBitsPerPixel(i17);
                            char c5 = (char) (30069 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)));
                            int keyRepeatDelay4 = 816 - (ViewConfiguration.getKeyRepeatDelay() >> 16);
                            byte[] bArr44 = $$a;
                            Object[] objArr118 = new Object[1];
                            b((byte) (bArr44[110] - 1), bArr44[108], bArr44[56], objArr118);
                            objAccessartificialFrame20 = ArtificialStackFrames.coroutineCreation(bitsPerPixel4, c5, keyRepeatDelay4, 891606461, false, (String) objArr118[0], null);
                        }
                        Object[] objArr119 = (Object[]) ((Field) objAccessartificialFrame20).get(null);
                        objArr8 = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
                        int i181 = ((int[]) objArr119[0])[0];
                        int i182 = ((int[]) objArr119[1])[0];
                        String[] strArr10 = (String[]) objArr119[2];
                        int iNextInt3 = new Random().nextInt();
                        int i183 = ~iNextInt3;
                        int i184 = 429515193 + (((~(837377125 | i183)) | (-1035549492) | (~((-837377126) | iNextInt3))) * (-564)) + ((~(iNextInt3 | (-833165346))) * 1128) + (((~((-1035549492) | i183)) | 4211780) * 564) + 1537211204;
                        int i185 = (i184 << 13) ^ i184;
                        int i186 = i185 ^ (i185 >>> 17);
                        ((int[]) objArr8[3])[0] = i186 ^ (i186 << 5);
                    } else {
                        Object[] objArr120 = {Integer.valueOf(((Integer) Class.forName(str4).getMethod(str5, Object.class).invoke(null, this)).intValue()), 0, 1537211204};
                        objAccessartificialFrame17 = ArtificialStackFrames.accessartificialFrame(1327366003);
                        if (objAccessartificialFrame17 == null) {
                            int packedPositionType4 = ExpandableListView.getPackedPositionType(0L) + 25;
                            char cIndexOf2 = (char) (30067 - TextUtils.indexOf((CharSequence) "", '0', 0, 0));
                            int i187 = 817 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1));
                            byte[] bArr45 = $$a;
                            Object[] objArr121 = new Object[1];
                            b((byte) (bArr45[19] - 1), (byte) 105, bArr45[81], objArr121);
                            objAccessartificialFrame17 = ArtificialStackFrames.coroutineCreation(packedPositionType4, cIndexOf2, i187, -797394565, false, (String) objArr121[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                        }
                        Object[] objArr122 = (Object[]) ((Method) objAccessartificialFrame17).invoke(null, objArr120);
                        objAccessartificialFrame18 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                        if (objAccessartificialFrame18 == null) {
                            int scrollBarSize3 = (ViewConfiguration.getScrollBarSize() >> 8) + 25;
                            char mode2 = (char) (View.MeasureSpec.getMode(0) + 30068);
                            int maximumFlingVelocity3 = 816 - (ViewConfiguration.getMaximumFlingVelocity() >> 16);
                            byte[] bArr46 = $$a;
                            Object[] objArr123 = new Object[1];
                            b((byte) (bArr46[110] - 1), bArr46[108], bArr46[56], objArr123);
                            objAccessartificialFrame18 = ArtificialStackFrames.coroutineCreation(scrollBarSize3, mode2, maximumFlingVelocity3, 891606461, false, (String) objArr123[0], null);
                        }
                        ((Field) objAccessartificialFrame18).set(null, objArr122);
                        try {
                            Long lValueOf10 = Long.valueOf(((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue());
                            objAccessartificialFrame19 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                            if (objAccessartificialFrame19 == null) {
                                int tapTimeout2 = 25 - (ViewConfiguration.getTapTimeout() >> 16);
                                char cMakeMeasureSpec = (char) (View.MeasureSpec.makeMeasureSpec(0, 0) + 30068);
                                int maximumFlingVelocity4 = (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 816;
                                byte[] bArr47 = $$a;
                                Object[] objArr124 = new Object[1];
                                b((byte) (bArr47[110] - 1), bArr47[12], bArr47[56], objArr124);
                                objAccessartificialFrame19 = ArtificialStackFrames.coroutineCreation(tapTimeout2, cMakeMeasureSpec, maximumFlingVelocity4, 721586079, false, (String) objArr124[0], null);
                            }
                            ((Field) objAccessartificialFrame19).set(null, lValueOf10);
                            objArr8 = objArr122;
                        } catch (Exception unused7) {
                            throw new RuntimeException();
                        }
                    }
                } else {
                    i17 = 0;
                    if (j3 + 1952 >= ((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue()) {
                        objAccessartificialFrame20 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                        if (objAccessartificialFrame20 == null) {
                            int bitsPerPixel5 = 24 - ImageFormat.getBitsPerPixel(i17);
                            char c6 = (char) (30069 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)));
                            int keyRepeatDelay5 = 816 - (ViewConfiguration.getKeyRepeatDelay() >> 16);
                            byte[] bArr48 = $$a;
                            Object[] objArr1110 = new Object[1];
                            b((byte) (bArr48[110] - 1), bArr48[108], bArr48[56], objArr1110);
                            objAccessartificialFrame20 = ArtificialStackFrames.coroutineCreation(bitsPerPixel5, c6, keyRepeatDelay5, 891606461, false, (String) objArr1110[0], null);
                        }
                        Object[] objArr1111 = (Object[]) ((Field) objAccessartificialFrame20).get(null);
                        objArr8 = new Object[]{new int[]{i181}, new int[]{i182}, strArr10, new int[1]};
                        int i188 = ((int[]) objArr1111[0])[0];
                        int i189 = ((int[]) objArr1111[1])[0];
                        String[] strArr11 = (String[]) objArr1111[2];
                        int iNextInt4 = new Random().nextInt();
                        int i1810 = ~iNextInt4;
                        int i1811 = 429515193 + (((~(837377125 | i1810)) | (-1035549492) | (~((-837377126) | iNextInt4))) * (-564)) + ((~(iNextInt4 | (-833165346))) * 1128) + (((~((-1035549492) | i1810)) | 4211780) * 564) + 1537211204;
                        int i1812 = (i1811 << 13) ^ i1811;
                        int i1813 = i1812 ^ (i1812 >>> 17);
                        ((int[]) objArr8[3])[0] = i1813 ^ (i1813 << 5);
                    } else {
                        Object[] objArr125 = {Integer.valueOf(((Integer) Class.forName(str4).getMethod(str5, Object.class).invoke(null, this)).intValue()), 0, 1537211204};
                        objAccessartificialFrame17 = ArtificialStackFrames.accessartificialFrame(1327366003);
                        if (objAccessartificialFrame17 == null) {
                            int packedPositionType5 = ExpandableListView.getPackedPositionType(0L) + 25;
                            char cIndexOf3 = (char) (30067 - TextUtils.indexOf((CharSequence) "", '0', 0, 0));
                            int i1814 = 817 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1));
                            byte[] bArr49 = $$a;
                            Object[] objArr126 = new Object[1];
                            b((byte) (bArr49[19] - 1), (byte) 105, bArr49[81], objArr126);
                            objAccessartificialFrame17 = ArtificialStackFrames.coroutineCreation(packedPositionType5, cIndexOf3, i1814, -797394565, false, (String) objArr126[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                        }
                        Object[] objArr127 = (Object[]) ((Method) objAccessartificialFrame17).invoke(null, objArr125);
                        objAccessartificialFrame18 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                        if (objAccessartificialFrame18 == null) {
                            int scrollBarSize4 = (ViewConfiguration.getScrollBarSize() >> 8) + 25;
                            char mode3 = (char) (View.MeasureSpec.getMode(0) + 30068);
                            int maximumFlingVelocity5 = 816 - (ViewConfiguration.getMaximumFlingVelocity() >> 16);
                            byte[] bArr410 = $$a;
                            Object[] objArr128 = new Object[1];
                            b((byte) (bArr410[110] - 1), bArr410[108], bArr410[56], objArr128);
                            objAccessartificialFrame18 = ArtificialStackFrames.coroutineCreation(scrollBarSize4, mode3, maximumFlingVelocity5, 891606461, false, (String) objArr128[0], null);
                        }
                        ((Field) objAccessartificialFrame18).set(null, objArr127);
                        Long lValueOf11 = Long.valueOf(((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame19 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                        if (objAccessartificialFrame19 == null) {
                            int tapTimeout3 = 25 - (ViewConfiguration.getTapTimeout() >> 16);
                            char cMakeMeasureSpec2 = (char) (View.MeasureSpec.makeMeasureSpec(0, 0) + 30068);
                            int maximumFlingVelocity6 = (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 816;
                            byte[] bArr411 = $$a;
                            Object[] objArr129 = new Object[1];
                            b((byte) (bArr411[110] - 1), bArr411[12], bArr411[56], objArr129);
                            objAccessartificialFrame19 = ArtificialStackFrames.coroutineCreation(tapTimeout3, cMakeMeasureSpec2, maximumFlingVelocity6, 721586079, false, (String) objArr129[0], null);
                        }
                        ((Field) objAccessartificialFrame19).set(null, lValueOf11);
                        objArr8 = objArr127;
                    }
                }
            } else {
                Object[] objArr1210 = {Integer.valueOf(((Integer) Class.forName(str4).getMethod(str5, Object.class).invoke(null, this)).intValue()), 0, 1537211204};
                objAccessartificialFrame17 = ArtificialStackFrames.accessartificialFrame(1327366003);
                if (objAccessartificialFrame17 == null) {
                    int packedPositionType6 = ExpandableListView.getPackedPositionType(0L) + 25;
                    char cIndexOf4 = (char) (30067 - TextUtils.indexOf((CharSequence) "", '0', 0, 0));
                    int i1815 = 817 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1));
                    byte[] bArr412 = $$a;
                    Object[] objArr1211 = new Object[1];
                    b((byte) (bArr412[19] - 1), (byte) 105, bArr412[81], objArr1211);
                    objAccessartificialFrame17 = ArtificialStackFrames.coroutineCreation(packedPositionType6, cIndexOf4, i1815, -797394565, false, (String) objArr1211[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                }
                Object[] objArr1212 = (Object[]) ((Method) objAccessartificialFrame17).invoke(null, objArr1210);
                objAccessartificialFrame18 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame18 == null) {
                    int scrollBarSize5 = (ViewConfiguration.getScrollBarSize() >> 8) + 25;
                    char mode4 = (char) (View.MeasureSpec.getMode(0) + 30068);
                    int maximumFlingVelocity7 = 816 - (ViewConfiguration.getMaximumFlingVelocity() >> 16);
                    byte[] bArr413 = $$a;
                    Object[] objArr1213 = new Object[1];
                    b((byte) (bArr413[110] - 1), bArr413[108], bArr413[56], objArr1213);
                    objAccessartificialFrame18 = ArtificialStackFrames.coroutineCreation(scrollBarSize5, mode4, maximumFlingVelocity7, 891606461, false, (String) objArr1213[0], null);
                }
                ((Field) objAccessartificialFrame18).set(null, objArr1212);
                Long lValueOf12 = Long.valueOf(((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue());
                objAccessartificialFrame19 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                if (objAccessartificialFrame19 == null) {
                    int tapTimeout4 = 25 - (ViewConfiguration.getTapTimeout() >> 16);
                    char cMakeMeasureSpec3 = (char) (View.MeasureSpec.makeMeasureSpec(0, 0) + 30068);
                    int maximumFlingVelocity8 = (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 816;
                    byte[] bArr414 = $$a;
                    Object[] objArr1214 = new Object[1];
                    b((byte) (bArr414[110] - 1), bArr414[12], bArr414[56], objArr1214);
                    objAccessartificialFrame19 = ArtificialStackFrames.coroutineCreation(tapTimeout4, cMakeMeasureSpec3, maximumFlingVelocity8, 721586079, false, (String) objArr1214[0], null);
                }
                ((Field) objAccessartificialFrame19).set(null, lValueOf12);
                objArr8 = objArr1212;
            }
            i13 = ((int[]) objArr8[1])[0];
            i14 = ((int[]) objArr8[0])[0];
            if (i14 == i13) {
                Object[] objArr130 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i190 = ((int[]) objArr8[3])[0];
                int i191 = ((int[]) objArr8[0])[0];
                int i192 = ((int[]) objArr8[1])[0];
                String[] strArr12 = (String[]) objArr8[2];
                int iIdentityHashCode7 = System.identityHashCode(this);
                int i193 = ~iIdentityHashCode7;
                int i194 = ~((-582700715) | i193);
                int i195 = ~(384528348 | iIdentityHashCode7);
                int i196 = i190 + (-2081787814) + ((i194 | i195) * 1150) + (((~((-384528349) | i193)) | i195) * (-575)) + (((~(iIdentityHashCode7 | (-582700715))) | (~(i193 | 582700714))) * 575);
                int i197 = (i196 << 13) ^ i196;
                int i198 = i197 ^ (i197 >>> 17);
                ((int[]) objArr130[3])[0] = i198 ^ (i198 << 5);
                return;
            }
            arrayList = new ArrayList();
            strArr = (String[]) objArr8[2];
            if (strArr != null) {
                for (String str9 : strArr) {
                    arrayList.add(str9);
                }
            }
            long j9 = ((long) (i13 ^ i14)) ^ (((long) 944545494) << 32);
            long j10 = 944545495;
            int i199 = getARTIFICIAL_FRAME_PACKAGE_NAME + 113;
            artificialFrame = i199 % 128;
            int i200 = i199 % 2;
            Object[] objArr131 = {Long.valueOf(j9), Long.valueOf(j10)};
            byte[] bArr50 = $$d;
            Object[] objArr132 = new Object[1];
            c((short) 571, bArr50[142], bArr50[8], objArr132);
            Class<?> cls17 = Class.forName((String) objArr132[0]);
            Object[] objArr133 = new Object[1];
            c((short) 116, bArr50[5], bArr50[72], objArr133);
            cls17.getMethod((String) objArr133[0], Long.TYPE, Long.TYPE).invoke(null, objArr131);
            Object[] objArr134 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i201 = ((int[]) objArr8[3])[0];
            int i202 = ((int[]) objArr8[0])[0];
            int i203 = ((int[]) objArr8[1])[0];
            String[] strArr13 = (String[]) objArr8[2];
            int i204 = (int) Runtime.getRuntime().totalMemory();
            int i205 = ~i204;
            int i206 = i201 + (-915497092) + (((~((-269541649) | i205)) | (~((-673452041) | i204)) | (~(1014362970 | i204))) * 765) + (((~((-942993689) | i205)) | 269541648) * 1530) + (((~(i204 | (-942993689))) | (~(i205 | 1014362970))) * 765);
            int i207 = (i206 << 13) ^ i206;
            int i208 = i207 ^ (i207 >>> 17);
            ((int[]) objArr134[3])[0] = i208 ^ (i208 << 5);
        }
        i4 = 0;
        Context baseContext4 = getBaseContext();
        if (baseContext4 == null) {
            Object[] objArr135 = new Object[1];
            a(21467 - Gravity.getAbsoluteGravity(i4, i4), new char[]{5469, 18057, 45806, 61151, 23103, 46610, 57978, 24559, 35717, 59391, 21442, 36731, 64313, 22336, 32946, 64640, 10490, 34014, 61486, 11268, 39028, 62883, 8604, 40436, 51669, 9531}, objArr135);
            Class<?> cls18 = Class.forName((String) objArr135[i4]);
            Object[] objArr136 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[i4]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(i4, 4).codePointAt(i4) + 44086, new char[]{5471, 47378, 19960, 4191, 42037, 18581, 8042, 41728, 30612, 6783, 44766, 29372, 283, 54722, 31154, 3072, 53475, 26457}, objArr136);
            baseContext4 = (Context) cls18.getMethod((String) objArr136[i4], new Class[i4]).invoke(null, null);
        }
        if (baseContext4 != null) {
            baseContext4 = ((baseContext4 instanceof ContextWrapper) && ((ContextWrapper) baseContext4).getBaseContext() == null) ? null : baseContext4.getApplicationContext();
        }
        int iIntValue3 = ((Integer) Class.forName(str4).getMethod(str5, Object.class).invoke(null, this)).intValue();
        int i209 = artificialFrame + 87;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i209 % 128;
        int i210 = i209 % 2;
        Object[] objArr137 = {baseContext4, Integer.valueOf(iIntValue3), 0, -1742146671};
        byte[] bArr51 = $$d;
        Object[] objArr138 = new Object[1];
        c((short) 295, (byte) 89, bArr51[8], objArr138);
        Class<?> cls19 = Class.forName((String) objArr138[0]);
        Object[] objArr139 = new Object[1];
        c((short) BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, bArr51[110], (byte) (bArr51[343] - 1), objArr139);
        objArr5 = (Object[]) cls19.getMethod((String) objArr139[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr137);
        if (baseContext4 != null) {
            int i211 = getARTIFICIAL_FRAME_PACKAGE_NAME + 89;
            artificialFrame = i211 % 128;
            try {
                if (i211 % 2 == 0) {
                    Object objAccessartificialFrame38 = ArtificialStackFrames.accessartificialFrame(-326560385);
                    if (objAccessartificialFrame38 == null) {
                        int scrollBarSize6 = 30 - (ViewConfiguration.getScrollBarSize() >> 8);
                        char c7 = (char) ((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 49362);
                        int pressedStateDuration3 = (ViewConfiguration.getPressedStateDuration() >> 16) + 684;
                        byte[] bArr52 = $$a;
                        Object[] objArr140 = new Object[1];
                        b(bArr52[81], (byte) 70, bArr52[14], objArr140);
                        objAccessartificialFrame38 = ArtificialStackFrames.coroutineCreation(scrollBarSize6, c7, pressedStateDuration3, 1944867703, false, (String) objArr140[0], null);
                    }
                    ((Field) objAccessartificialFrame38).set(null, objArr5);
                    lValueOf = Long.valueOf(((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[1]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-1283093189);
                    if (objAccessartificialFrame7 == null) {
                        offsetAfter = (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 30;
                        absoluteGravity = (char) (View.getDefaultSize(0, 0) + 49362);
                        windowTouchSlop = 685 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1));
                        i5 = 752929587;
                        z = false;
                        byte[] bArr53 = $$a;
                        byte b11 = bArr53[22];
                        Object[] objArr141 = new Object[1];
                        b(b11, (byte) (b11 | 53), bArr53[14], objArr141);
                        str = (String) objArr141[0];
                        objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(offsetAfter, absoluteGravity, windowTouchSlop, i5, z, str, null);
                    }
                } else {
                    Object objAccessartificialFrame39 = ArtificialStackFrames.accessartificialFrame(-326560385);
                    if (objAccessartificialFrame39 == null) {
                        int maximumFlingVelocity9 = (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 30;
                        char maximumFlingVelocity10 = (char) ((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 49362);
                        int iAxisFromString = MotionEvent.axisFromString("") + 685;
                        byte[] bArr54 = $$a;
                        Object[] objArr142 = new Object[1];
                        b(bArr54[81], (byte) 70, bArr54[14], objArr142);
                        objAccessartificialFrame39 = ArtificialStackFrames.coroutineCreation(maximumFlingVelocity9, maximumFlingVelocity10, iAxisFromString, 1944867703, false, (String) objArr142[0], null);
                    }
                    ((Field) objAccessartificialFrame39).set(null, objArr5);
                    lValueOf = Long.valueOf(((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-1283093189);
                    if (objAccessartificialFrame7 == null) {
                        offsetAfter = 30 - TextUtils.getOffsetAfter("", 0);
                        absoluteGravity = (char) (49362 - Gravity.getAbsoluteGravity(0, 0));
                        windowTouchSlop = 684 - (ViewConfiguration.getWindowTouchSlop() >> 8);
                        i5 = 752929587;
                        z = false;
                        byte[] bArr55 = $$a;
                        byte b12 = bArr55[22];
                        Object[] objArr143 = new Object[1];
                        b(b12, (byte) (b12 | 53), bArr55[14], objArr143);
                        str = (String) objArr143[0];
                        objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(offsetAfter, absoluteGravity, windowTouchSlop, i5, z, str, null);
                    }
                }
                ((Field) objAccessartificialFrame7).set(null, lValueOf);
            } catch (Exception unused8) {
                throw new RuntimeException();
            }
        }
        i6 = ((int[]) objArr5[1])[0];
        i7 = ((int[]) objArr5[0])[0];
        if (i7 == i6) {
            int i1310 = ((int[]) objArr5[2])[0];
            Object[] objArr710 = {new int[]{((int[]) objArr5[0])[0]}, new int[]{((int[]) objArr5[1])[0]}, new int[1], (String) objArr5[3]};
            int i1311 = ~(System.identityHashCode(this) | 711681023);
            int i1312 = i1310 + (((537019104 | i1311) * (-196)) - 1013811998) + ((i1311 | 174661919) * 196);
            int i1313 = (i1312 << 13) ^ i1312;
            int i1314 = i1313 ^ (i1313 >>> 17);
            ((int[]) objArr710[2])[0] = i1314 ^ (i1314 << 5);
            i8 = 0;
        } else {
            Object[] objArr711 = {Long.valueOf((((long) (-696522124)) << 32) ^ ((long) (i6 ^ i7))), Long.valueOf(-696522128)};
            byte[] bArr310 = $$d;
            Object[] objArr712 = new Object[1];
            c((short) (-bArr310[21]), bArr310[332], bArr310[8], objArr712);
            Class<?> cls110 = Class.forName((String) objArr712[0]);
            Object[] objArr713 = new Object[1];
            c((short) 116, bArr310[5], bArr310[72], objArr713);
            cls110.getMethod((String) objArr713[0], Long.TYPE, Long.TYPE).invoke(null, objArr711);
            int i1315 = ((int[]) objArr5[2])[0];
            Object[] objArr810 = {new int[]{((int[]) objArr5[0])[0]}, new int[]{((int[]) objArr5[1])[0]}, new int[1], (String) objArr5[3]};
            int startElapsedRealtime2 = (int) Process.getStartElapsedRealtime();
            int i1316 = (-1369658530) + ((~(startElapsedRealtime2 | 931268475)) * JfifUtil.MARKER_SOI);
            int i1317 = ~startElapsedRealtime2;
            int i1318 = i1315 + i1316 + (((-5279873) | i1317) * (-216)) + (((~(i1317 | 931268475)) | 47355299) * JfifUtil.MARKER_SOI);
            int i1319 = (i1318 << 13) ^ i1318;
            int i1410 = i1319 ^ (i1319 >>> 17);
            i8 = 0;
            ((int[]) objArr810[2])[0] = i1410 ^ (i1410 << 5);
        }
        objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(1056123296);
        if (objAccessartificialFrame8 == null) {
            int size3 = 30 - View.MeasureSpec.getSize(i8);
            char cIndexOf5 = (char) (TextUtils.indexOf("", "") + 49362);
            int iAlpha2 = Color.alpha(i8) + 684;
            byte[] bArr311 = $$a;
            byte b13 = bArr311[52];
            Object[] objArr811 = new Object[1];
            b(bArr311[81], (byte) 85, b13, objArr811);
            objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(size3, cIndexOf5, iAlpha2, -1583976536, false, (String) objArr811[0], null);
        }
        j = ((Field) objAccessartificialFrame8).getLong(null);
        if (j != -1) {
            Object[] objArr812 = {Integer.valueOf(((Integer) Class.forName(str4).getMethod(str5, Object.class).invoke(null, this)).intValue()), 1149280877};
            short s3 = (short) TypedValues.CycleType.TYPE_ALPHA;
            byte[] bArr312 = $$d;
            Object[] objArr813 = new Object[1];
            c(s3, (byte) (-bArr312[488]), bArr312[8], objArr813);
            Class<?> cls111 = Class.forName((String) objArr813[0]);
            Object[] objArr814 = new Object[1];
            c((short) 459, bArr312[4], bArr312[8], objArr814);
            objArr6 = (Object[]) cls111.getMethod((String) objArr814[0], Integer.TYPE, Integer.TYPE).invoke(null, objArr812);
            objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(910856866);
            if (objAccessartificialFrame9 == null) {
                int maximumFlingVelocity11 = 30 - (ViewConfiguration.getMaximumFlingVelocity() >> 16);
                char bitsPerPixel6 = (char) (49361 - ImageFormat.getBitsPerPixel(0));
                int windowTouchSlop5 = (ViewConfiguration.getWindowTouchSlop() >> 8) + 684;
                byte[] bArr313 = $$a;
                Object[] objArr815 = new Object[1];
                b((byte) (-bArr313[15]), (byte) 97, bArr313[56], objArr815);
                objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(maximumFlingVelocity11, bitsPerPixel6, windowTouchSlop5, -1456483158, false, (String) objArr815[0], null);
            }
            ((Field) objAccessartificialFrame9).set(null, objArr6);
            Long lValueOf13 = Long.valueOf(((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(1056123296);
            if (objAccessartificialFrame10 == null) {
                int capsMode4 = 30 - TextUtils.getCapsMode("", 0, 0);
                char mode5 = (char) (49362 - View.MeasureSpec.getMode(0));
                int capsMode5 = 684 - TextUtils.getCapsMode("", 0, 0);
                byte[] bArr314 = $$a;
                Object[] objArr816 = new Object[1];
                b(bArr314[81], (byte) 85, bArr314[52], objArr816);
                objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(capsMode4, mode5, capsMode5, -1583976536, false, (String) objArr816[0], null);
            }
            ((Field) objAccessartificialFrame10).set(null, lValueOf13);
        } else {
            Object[] objArr817 = {Integer.valueOf(((Integer) Class.forName(str4).getMethod(str5, Object.class).invoke(null, this)).intValue()), 1149280877};
            short s4 = (short) TypedValues.CycleType.TYPE_ALPHA;
            byte[] bArr315 = $$d;
            Object[] objArr818 = new Object[1];
            c(s4, (byte) (-bArr315[488]), bArr315[8], objArr818);
            Class<?> cls112 = Class.forName((String) objArr818[0]);
            Object[] objArr819 = new Object[1];
            c((short) 459, bArr315[4], bArr315[8], objArr819);
            objArr6 = (Object[]) cls112.getMethod((String) objArr819[0], Integer.TYPE, Integer.TYPE).invoke(null, objArr817);
            objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(910856866);
            if (objAccessartificialFrame9 == null) {
                int maximumFlingVelocity12 = 30 - (ViewConfiguration.getMaximumFlingVelocity() >> 16);
                char bitsPerPixel7 = (char) (49361 - ImageFormat.getBitsPerPixel(0));
                int windowTouchSlop6 = (ViewConfiguration.getWindowTouchSlop() >> 8) + 684;
                byte[] bArr316 = $$a;
                Object[] objArr8110 = new Object[1];
                b((byte) (-bArr316[15]), (byte) 97, bArr316[56], objArr8110);
                objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(maximumFlingVelocity12, bitsPerPixel7, windowTouchSlop6, -1456483158, false, (String) objArr8110[0], null);
            }
            ((Field) objAccessartificialFrame9).set(null, objArr6);
            Long lValueOf14 = Long.valueOf(((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(1056123296);
            if (objAccessartificialFrame10 == null) {
                int capsMode6 = 30 - TextUtils.getCapsMode("", 0, 0);
                char mode6 = (char) (49362 - View.MeasureSpec.getMode(0));
                int capsMode7 = 684 - TextUtils.getCapsMode("", 0, 0);
                byte[] bArr317 = $$a;
                Object[] objArr8111 = new Object[1];
                b(bArr317[81], (byte) 85, bArr317[52], objArr8111);
                objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(capsMode6, mode6, capsMode7, -1583976536, false, (String) objArr8111[0], null);
            }
            ((Field) objAccessartificialFrame10).set(null, lValueOf14);
        }
        i9 = ((int[]) objArr6[1])[0];
        i10 = ((int[]) objArr6[0])[0];
        if (i10 == i9) {
            int i1411 = ((int[]) objArr6[2])[0];
            Object[] objArr820 = {new int[]{((int[]) objArr6[0])[0]}, new int[]{((int[]) objArr6[1])[0]}, new int[1], (String) objArr6[3]};
            int iNextInt5 = new Random().nextInt(1113871552);
            int i1412 = i1411 + (-1581907322) + (((~(905731038 | iNextInt5)) | 72892736) * (-756)) + (((~iNextInt5) | 905731038) * 756);
            int i1413 = (i1412 << 13) ^ i1412;
            int i1414 = i1413 ^ (i1413 >>> 17);
            ((int[]) objArr820[2])[0] = i1414 ^ (i1414 << 5);
        } else {
            new ArrayList().add((String) objArr6[3]);
            Object[] objArr910 = {Long.valueOf((((long) 1478142762) << 32) ^ ((long) (i9 ^ i10))), Long.valueOf(1478142778)};
            byte[] bArr318 = $$d;
            Object[] objArr911 = new Object[1];
            c((short) (-bArr318[21]), bArr318[332], bArr318[8], objArr911);
            Class<?> cls113 = Class.forName((String) objArr911[0]);
            Object[] objArr912 = new Object[1];
            c((short) 116, bArr318[5], bArr318[72], objArr912);
            cls113.getMethod((String) objArr912[0], Long.TYPE, Long.TYPE).invoke(null, objArr910);
            int i1415 = ((int[]) objArr6[2])[0];
            Object[] objArr913 = {new int[]{((int[]) objArr6[0])[0]}, new int[]{((int[]) objArr6[1])[0]}, new int[1], (String) objArr6[3]};
            int iMaxMemory2 = (int) Runtime.getRuntime().maxMemory();
            int i1510 = ~iMaxMemory2;
            int i1511 = (~((-273153588) | i1510)) | 302627;
            int i1512 = ~(iMaxMemory2 | 978321147);
            int i1513 = i1415 + 1130542528 + ((i1511 | i1512) * (-502)) + ((i1512 | (~(i1510 | (-272850961)))) * TypedValues.PositionType.TYPE_DRAWPATH);
            int i1514 = (i1513 << 13) ^ i1513;
            int i1515 = i1514 ^ (i1514 >>> 17);
            ((int[]) objArr913[2])[0] = i1515 ^ (i1515 << 5);
        }
        super.onStart();
        objAccessartificialFrame11 = ArtificialStackFrames.accessartificialFrame(1745676544);
        if (objAccessartificialFrame11 == null) {
            int i1516 = (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 16;
            char c8 = (char) ((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) - 1);
            int iMyTid2 = (Process.myTid() >> 22) + 747;
            byte[] bArr319 = $$a;
            byte b14 = (byte) (bArr319[110] - 1);
            byte b15 = bArr319[12];
            byte b16 = bArr319[56];
            Object[] objArr914 = new Object[1];
            b(b14, b15, b16, objArr914);
            objAccessartificialFrame11 = ArtificialStackFrames.coroutineCreation(i1516, c8, iMyTid2, -144068856, false, (String) objArr914[0], null);
        }
        j2 = ((Field) objAccessartificialFrame11).getLong(null);
        if (j2 != -1) {
            baseContext2 = getBaseContext();
            if (baseContext2 == null) {
                Object[] objArr915 = new Object[1];
                a(Gravity.getAbsoluteGravity(0, 0) + 21467, new char[]{5469, 18057, 45806, 61151, 23103, 46610, 57978, 24559, 35717, 59391, 21442, 36731, 64313, 22336, 32946, 64640, 10490, 34014, 61486, 11268, 39028, 62883, 8604, 40436, 51669, 9531}, objArr915);
                Class<?> cls114 = Class.forName((String) objArr915[0]);
                Object[] objArr916 = new Object[1];
                a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 44088, new char[]{5471, 47378, 19960, 4191, 42037, 18581, 8042, 41728, 30612, 6783, 44766, 29372, 283, 54722, 31154, 3072, 53475, 26457}, objArr916);
                baseContext2 = (Context) cls114.getMethod((String) objArr916[0], new Class[0]).invoke(null, null);
            }
            if (baseContext2 != null) {
                if (baseContext2 instanceof ContextWrapper) {
                    baseContext2 = baseContext2.getApplicationContext();
                } else {
                    baseContext2 = baseContext2.getApplicationContext();
                }
            }
            Object[] objArr917 = {baseContext2, Integer.valueOf(((Integer) Class.forName(str4).getMethod(str5, Object.class).invoke(null, this)).intValue()), 0, -1696726223};
            byte[] bArr320 = $$d;
            Object[] objArr918 = new Object[1];
            c((short) 475, (byte) (-bArr320[354]), bArr320[18], objArr918);
            Class<?> cls115 = Class.forName((String) objArr918[0]);
            Object[] objArr919 = new Object[1];
            c((short) BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, bArr320[110], (byte) (bArr320[343] - 1), objArr919);
            objArr7 = (Object[]) cls115.getMethod((String) objArr919[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr917);
            objAccessartificialFrame12 = ArtificialStackFrames.accessartificialFrame(1575402270);
            if (objAccessartificialFrame12 == null) {
                int iGreen2 = 17 - Color.green(0);
                char c9 = (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) - 1);
                int i1517 = (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 748;
                byte[] bArr321 = $$a;
                Object[] objArr1010 = new Object[1];
                b((byte) (bArr321[110] - 1), bArr321[108], bArr321[56], objArr1010);
                objAccessartificialFrame12 = ArtificialStackFrames.coroutineCreation(iGreen2, c9, i1517, -1031537386, false, (String) objArr1010[0], null);
            }
            ((Field) objAccessartificialFrame12).set(null, objArr7);
            Long lValueOf15 = Long.valueOf(((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame13 = ArtificialStackFrames.accessartificialFrame(1745676544);
            if (objAccessartificialFrame13 == null) {
                int iCombineMeasuredStates4 = View.combineMeasuredStates(0, 0) + 17;
                char cAlpha3 = (char) Color.alpha(0);
                int i1518 = (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 746;
                byte[] bArr415 = $$a;
                Object[] objArr1011 = new Object[1];
                b((byte) (bArr415[110] - 1), bArr415[12], bArr415[56], objArr1011);
                objAccessartificialFrame13 = ArtificialStackFrames.coroutineCreation(iCombineMeasuredStates4, cAlpha3, i1518, -144068856, false, (String) objArr1011[0], null);
            }
            ((Field) objAccessartificialFrame13).set(null, lValueOf15);
        } else {
            baseContext2 = getBaseContext();
            if (baseContext2 == null) {
                Object[] objArr9110 = new Object[1];
                a(Gravity.getAbsoluteGravity(0, 0) + 21467, new char[]{5469, 18057, 45806, 61151, 23103, 46610, 57978, 24559, 35717, 59391, 21442, 36731, 64313, 22336, 32946, 64640, 10490, 34014, 61486, 11268, 39028, 62883, 8604, 40436, 51669, 9531}, objArr9110);
                Class<?> cls116 = Class.forName((String) objArr9110[0]);
                Object[] objArr9111 = new Object[1];
                a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 44088, new char[]{5471, 47378, 19960, 4191, 42037, 18581, 8042, 41728, 30612, 6783, 44766, 29372, 283, 54722, 31154, 3072, 53475, 26457}, objArr9111);
                baseContext2 = (Context) cls116.getMethod((String) objArr9111[0], new Class[0]).invoke(null, null);
            }
            if (baseContext2 != null) {
                if (baseContext2 instanceof ContextWrapper) {
                    baseContext2 = baseContext2.getApplicationContext();
                } else {
                    baseContext2 = baseContext2.getApplicationContext();
                }
            }
            Object[] objArr9112 = {baseContext2, Integer.valueOf(((Integer) Class.forName(str4).getMethod(str5, Object.class).invoke(null, this)).intValue()), 0, -1696726223};
            byte[] bArr322 = $$d;
            Object[] objArr9113 = new Object[1];
            c((short) 475, (byte) (-bArr322[354]), bArr322[18], objArr9113);
            Class<?> cls117 = Class.forName((String) objArr9113[0]);
            Object[] objArr9114 = new Object[1];
            c((short) BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, bArr322[110], (byte) (bArr322[343] - 1), objArr9114);
            objArr7 = (Object[]) cls117.getMethod((String) objArr9114[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr9112);
            objAccessartificialFrame12 = ArtificialStackFrames.accessartificialFrame(1575402270);
            if (objAccessartificialFrame12 == null) {
                int iGreen3 = 17 - Color.green(0);
                char c10 = (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) - 1);
                int i1519 = (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 748;
                byte[] bArr323 = $$a;
                Object[] objArr1012 = new Object[1];
                b((byte) (bArr323[110] - 1), bArr323[108], bArr323[56], objArr1012);
                objAccessartificialFrame12 = ArtificialStackFrames.coroutineCreation(iGreen3, c10, i1519, -1031537386, false, (String) objArr1012[0], null);
            }
            ((Field) objAccessartificialFrame12).set(null, objArr7);
            Long lValueOf16 = Long.valueOf(((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame13 = ArtificialStackFrames.accessartificialFrame(1745676544);
            if (objAccessartificialFrame13 == null) {
                int iCombineMeasuredStates5 = View.combineMeasuredStates(0, 0) + 17;
                char cAlpha4 = (char) Color.alpha(0);
                int i15110 = (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 746;
                byte[] bArr416 = $$a;
                Object[] objArr1013 = new Object[1];
                b((byte) (bArr416[110] - 1), bArr416[12], bArr416[56], objArr1013);
                objAccessartificialFrame13 = ArtificialStackFrames.coroutineCreation(iCombineMeasuredStates5, cAlpha4, i15110, -144068856, false, (String) objArr1013[0], null);
            }
            ((Field) objAccessartificialFrame13).set(null, lValueOf16);
        }
        i11 = ((int[]) objArr7[4])[0];
        i12 = ((int[]) objArr7[3])[0];
        if (i12 == i11) {
            Object[] objArr1014 = {list3, new int[1], list4, new int[]{i168}, new int[]{i169}};
            int i1610 = ((int[]) objArr7[1])[0];
            int i1611 = ((int[]) objArr7[3])[0];
            int i1612 = ((int[]) objArr7[4])[0];
            List list7 = (List) objArr7[0];
            List list8 = (List) objArr7[2];
            int iIdentityHashCode8 = System.identityHashCode(this);
            int i1710 = ~iIdentityHashCode8;
            int i1711 = i1610 + (-635952723) + (((~(94366196 | i1710)) | (-699814655) | (~((-94366197) | iIdentityHashCode8))) * (-564)) + ((~(iIdentityHashCode8 | (-26624245))) * 1128) + (((~((-699814655) | i1710)) | 67741952) * 564);
            int i1712 = (i1711 << 13) ^ i1711;
            int i1713 = i1712 ^ (i1712 >>> 17);
            ((int[]) objArr1014[1])[0] = i1713 ^ (i1713 << 5);
        } else {
            ArrayList arrayList5 = new ArrayList();
            Object[] objArr1015 = {objArr7};
            objAccessartificialFrame14 = ArtificialStackFrames.accessartificialFrame(1804664566);
            if (objAccessartificialFrame14 == null) {
                objAccessartificialFrame14 = ArtificialStackFrames.coroutineCreation(Color.red(0) + 41, (char) (12468 - TextUtils.getTrimmedLength("")), MotionEvent.axisFromString("") + 3643, -185222914, false, "coroutineCreation", new Class[]{Object[].class});
            }
            arrayList5.add(((Method) objAccessartificialFrame14).invoke(null, objArr1015));
            Object[] objArr1016 = {objArr7};
            objAccessartificialFrame15 = ArtificialStackFrames.accessartificialFrame(-1243809191);
            if (objAccessartificialFrame15 == null) {
                objAccessartificialFrame15 = ArtificialStackFrames.coroutineCreation(40 - TextUtils.lastIndexOf("", '0'), (char) (Color.rgb(0, 0, 0) + 16789684), View.MeasureSpec.makeMeasureSpec(0, 0) + 3642, 716815441, false, "ArtificialStackFrames", new Class[]{Object[].class});
            }
            arrayList5.add(((Method) objAccessartificialFrame15).invoke(null, objArr1016));
            Object[] objArr1017 = {Long.valueOf(((long) (i11 ^ i12)) ^ (((long) (-166942286)) << 32)), Long.valueOf(-166942278)};
            short s5 = (short) TypedValues.PositionType.TYPE_CURVE_FIT;
            byte[] bArr417 = $$d;
            Object[] objArr1018 = new Object[1];
            c(s5, bArr417[27], bArr417[8], objArr1018);
            Class<?> cls118 = Class.forName((String) objArr1018[0]);
            Object[] objArr1019 = new Object[1];
            c((short) 116, bArr417[5], bArr417[72], objArr1019);
            cls118.getMethod((String) objArr1019[0], Long.TYPE, Long.TYPE).invoke(null, objArr1017);
            Object[] objArr1112 = {list5, new int[1], list6, new int[]{i175}, new int[]{i176}};
            int i1714 = ((int[]) objArr7[1])[0];
            int i1715 = ((int[]) objArr7[3])[0];
            int i1716 = ((int[]) objArr7[4])[0];
            List list9 = (List) objArr7[0];
            List list10 = (List) objArr7[2];
            int i1717 = ~(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 80407914);
            int i1718 = i1714 + 1925394650 + (((~((-611859044) | i1717)) | 6410585) * (-933)) + (((~(i1717 | 6410585)) | (-611974012)) * 933) + 107265144;
            int i1719 = i1718 ^ (i1718 << 13);
            int i1816 = i1719 ^ (i1719 >>> 17);
            ((int[]) objArr1112[1])[0] = i1816 ^ (i1816 << 5);
        }
        objAccessartificialFrame16 = ArtificialStackFrames.accessartificialFrame(-1268268649);
        if (objAccessartificialFrame16 == null) {
            int scrollBarSize7 = (ViewConfiguration.getScrollBarSize() >> 8) + 25;
            char pressedStateDuration4 = (char) (30068 - (ViewConfiguration.getPressedStateDuration() >> 16));
            int iMyPid3 = (Process.myPid() >> 22) + 816;
            byte[] bArr418 = $$a;
            Object[] objArr1113 = new Object[1];
            b((byte) (bArr418[110] - 1), bArr418[12], bArr418[56], objArr1113);
            objAccessartificialFrame16 = ArtificialStackFrames.coroutineCreation(scrollBarSize7, pressedStateDuration4, iMyPid3, 721586079, false, (String) objArr1113[0], null);
        }
        j3 = ((Field) objAccessartificialFrame16).getLong(null);
        if (j3 != -1) {
            i16 = getARTIFICIAL_FRAME_PACKAGE_NAME + 5;
            artificialFrame = i16 % 128;
            if (i16 % 2 == 0) {
                i17 = 0;
                if (j3 - 1952 >= ((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[1]).invoke(null, new Object[0])).longValue()) {
                    objAccessartificialFrame20 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                    if (objAccessartificialFrame20 == null) {
                        int bitsPerPixel8 = 24 - ImageFormat.getBitsPerPixel(i17);
                        char c11 = (char) (30069 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)));
                        int keyRepeatDelay6 = 816 - (ViewConfiguration.getKeyRepeatDelay() >> 16);
                        byte[] bArr419 = $$a;
                        Object[] objArr1114 = new Object[1];
                        b((byte) (bArr419[110] - 1), bArr419[108], bArr419[56], objArr1114);
                        objAccessartificialFrame20 = ArtificialStackFrames.coroutineCreation(bitsPerPixel8, c11, keyRepeatDelay6, 891606461, false, (String) objArr1114[0], null);
                    }
                    Object[] objArr1115 = (Object[]) ((Field) objAccessartificialFrame20).get(null);
                    objArr8 = new Object[]{new int[]{i188}, new int[]{i189}, strArr11, new int[1]};
                    int i1817 = ((int[]) objArr1115[0])[0];
                    int i1818 = ((int[]) objArr1115[1])[0];
                    String[] strArr14 = (String[]) objArr1115[2];
                    int iNextInt6 = new Random().nextInt();
                    int i1819 = ~iNextInt6;
                    int i18110 = 429515193 + (((~(837377125 | i1819)) | (-1035549492) | (~((-837377126) | iNextInt6))) * (-564)) + ((~(iNextInt6 | (-833165346))) * 1128) + (((~((-1035549492) | i1819)) | 4211780) * 564) + 1537211204;
                    int i18111 = (i18110 << 13) ^ i18110;
                    int i18112 = i18111 ^ (i18111 >>> 17);
                    ((int[]) objArr8[3])[0] = i18112 ^ (i18112 << 5);
                } else {
                    Object[] objArr1215 = {Integer.valueOf(((Integer) Class.forName(str4).getMethod(str5, Object.class).invoke(null, this)).intValue()), 0, 1537211204};
                    objAccessartificialFrame17 = ArtificialStackFrames.accessartificialFrame(1327366003);
                    if (objAccessartificialFrame17 == null) {
                        int packedPositionType7 = ExpandableListView.getPackedPositionType(0L) + 25;
                        char cIndexOf6 = (char) (30067 - TextUtils.indexOf((CharSequence) "", '0', 0, 0));
                        int i18113 = 817 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1));
                        byte[] bArr4110 = $$a;
                        Object[] objArr1216 = new Object[1];
                        b((byte) (bArr4110[19] - 1), (byte) 105, bArr4110[81], objArr1216);
                        objAccessartificialFrame17 = ArtificialStackFrames.coroutineCreation(packedPositionType7, cIndexOf6, i18113, -797394565, false, (String) objArr1216[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                    }
                    Object[] objArr1217 = (Object[]) ((Method) objAccessartificialFrame17).invoke(null, objArr1215);
                    objAccessartificialFrame18 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                    if (objAccessartificialFrame18 == null) {
                        int scrollBarSize8 = (ViewConfiguration.getScrollBarSize() >> 8) + 25;
                        char mode7 = (char) (View.MeasureSpec.getMode(0) + 30068);
                        int maximumFlingVelocity13 = 816 - (ViewConfiguration.getMaximumFlingVelocity() >> 16);
                        byte[] bArr4111 = $$a;
                        Object[] objArr1218 = new Object[1];
                        b((byte) (bArr4111[110] - 1), bArr4111[108], bArr4111[56], objArr1218);
                        objAccessartificialFrame18 = ArtificialStackFrames.coroutineCreation(scrollBarSize8, mode7, maximumFlingVelocity13, 891606461, false, (String) objArr1218[0], null);
                    }
                    ((Field) objAccessartificialFrame18).set(null, objArr1217);
                    Long lValueOf17 = Long.valueOf(((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame19 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                    if (objAccessartificialFrame19 == null) {
                        int tapTimeout5 = 25 - (ViewConfiguration.getTapTimeout() >> 16);
                        char cMakeMeasureSpec4 = (char) (View.MeasureSpec.makeMeasureSpec(0, 0) + 30068);
                        int maximumFlingVelocity14 = (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 816;
                        byte[] bArr4112 = $$a;
                        Object[] objArr1219 = new Object[1];
                        b((byte) (bArr4112[110] - 1), bArr4112[12], bArr4112[56], objArr1219);
                        objAccessartificialFrame19 = ArtificialStackFrames.coroutineCreation(tapTimeout5, cMakeMeasureSpec4, maximumFlingVelocity14, 721586079, false, (String) objArr1219[0], null);
                    }
                    ((Field) objAccessartificialFrame19).set(null, lValueOf17);
                    objArr8 = objArr1217;
                }
            } else {
                i17 = 0;
                if (j3 + 1952 >= ((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue()) {
                    objAccessartificialFrame20 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                    if (objAccessartificialFrame20 == null) {
                        int bitsPerPixel9 = 24 - ImageFormat.getBitsPerPixel(i17);
                        char c12 = (char) (30069 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)));
                        int keyRepeatDelay7 = 816 - (ViewConfiguration.getKeyRepeatDelay() >> 16);
                        byte[] bArr4113 = $$a;
                        Object[] objArr1116 = new Object[1];
                        b((byte) (bArr4113[110] - 1), bArr4113[108], bArr4113[56], objArr1116);
                        objAccessartificialFrame20 = ArtificialStackFrames.coroutineCreation(bitsPerPixel9, c12, keyRepeatDelay7, 891606461, false, (String) objArr1116[0], null);
                    }
                    Object[] objArr1117 = (Object[]) ((Field) objAccessartificialFrame20).get(null);
                    objArr8 = new Object[]{new int[]{i1817}, new int[]{i1818}, strArr14, new int[1]};
                    int i18114 = ((int[]) objArr1117[0])[0];
                    int i18115 = ((int[]) objArr1117[1])[0];
                    String[] strArr15 = (String[]) objArr1117[2];
                    int iNextInt7 = new Random().nextInt();
                    int i18116 = ~iNextInt7;
                    int i18117 = 429515193 + (((~(837377125 | i18116)) | (-1035549492) | (~((-837377126) | iNextInt7))) * (-564)) + ((~(iNextInt7 | (-833165346))) * 1128) + (((~((-1035549492) | i18116)) | 4211780) * 564) + 1537211204;
                    int i18118 = (i18117 << 13) ^ i18117;
                    int i18119 = i18118 ^ (i18118 >>> 17);
                    ((int[]) objArr8[3])[0] = i18119 ^ (i18119 << 5);
                } else {
                    Object[] objArr12110 = {Integer.valueOf(((Integer) Class.forName(str4).getMethod(str5, Object.class).invoke(null, this)).intValue()), 0, 1537211204};
                    objAccessartificialFrame17 = ArtificialStackFrames.accessartificialFrame(1327366003);
                    if (objAccessartificialFrame17 == null) {
                        int packedPositionType8 = ExpandableListView.getPackedPositionType(0L) + 25;
                        char cIndexOf7 = (char) (30067 - TextUtils.indexOf((CharSequence) "", '0', 0, 0));
                        int i181110 = 817 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1));
                        byte[] bArr4114 = $$a;
                        Object[] objArr12111 = new Object[1];
                        b((byte) (bArr4114[19] - 1), (byte) 105, bArr4114[81], objArr12111);
                        objAccessartificialFrame17 = ArtificialStackFrames.coroutineCreation(packedPositionType8, cIndexOf7, i181110, -797394565, false, (String) objArr12111[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                    }
                    Object[] objArr12112 = (Object[]) ((Method) objAccessartificialFrame17).invoke(null, objArr12110);
                    objAccessartificialFrame18 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                    if (objAccessartificialFrame18 == null) {
                        int scrollBarSize9 = (ViewConfiguration.getScrollBarSize() >> 8) + 25;
                        char mode8 = (char) (View.MeasureSpec.getMode(0) + 30068);
                        int maximumFlingVelocity15 = 816 - (ViewConfiguration.getMaximumFlingVelocity() >> 16);
                        byte[] bArr4115 = $$a;
                        Object[] objArr12113 = new Object[1];
                        b((byte) (bArr4115[110] - 1), bArr4115[108], bArr4115[56], objArr12113);
                        objAccessartificialFrame18 = ArtificialStackFrames.coroutineCreation(scrollBarSize9, mode8, maximumFlingVelocity15, 891606461, false, (String) objArr12113[0], null);
                    }
                    ((Field) objAccessartificialFrame18).set(null, objArr12112);
                    Long lValueOf18 = Long.valueOf(((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame19 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                    if (objAccessartificialFrame19 == null) {
                        int tapTimeout6 = 25 - (ViewConfiguration.getTapTimeout() >> 16);
                        char cMakeMeasureSpec5 = (char) (View.MeasureSpec.makeMeasureSpec(0, 0) + 30068);
                        int maximumFlingVelocity16 = (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 816;
                        byte[] bArr4116 = $$a;
                        Object[] objArr12114 = new Object[1];
                        b((byte) (bArr4116[110] - 1), bArr4116[12], bArr4116[56], objArr12114);
                        objAccessartificialFrame19 = ArtificialStackFrames.coroutineCreation(tapTimeout6, cMakeMeasureSpec5, maximumFlingVelocity16, 721586079, false, (String) objArr12114[0], null);
                    }
                    ((Field) objAccessartificialFrame19).set(null, lValueOf18);
                    objArr8 = objArr12112;
                }
            }
        } else {
            Object[] objArr12115 = {Integer.valueOf(((Integer) Class.forName(str4).getMethod(str5, Object.class).invoke(null, this)).intValue()), 0, 1537211204};
            objAccessartificialFrame17 = ArtificialStackFrames.accessartificialFrame(1327366003);
            if (objAccessartificialFrame17 == null) {
                int packedPositionType9 = ExpandableListView.getPackedPositionType(0L) + 25;
                char cIndexOf8 = (char) (30067 - TextUtils.indexOf((CharSequence) "", '0', 0, 0));
                int i181111 = 817 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1));
                byte[] bArr4117 = $$a;
                Object[] objArr12116 = new Object[1];
                b((byte) (bArr4117[19] - 1), (byte) 105, bArr4117[81], objArr12116);
                objAccessartificialFrame17 = ArtificialStackFrames.coroutineCreation(packedPositionType9, cIndexOf8, i181111, -797394565, false, (String) objArr12116[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            }
            Object[] objArr12117 = (Object[]) ((Method) objAccessartificialFrame17).invoke(null, objArr12115);
            objAccessartificialFrame18 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame18 == null) {
                int scrollBarSize10 = (ViewConfiguration.getScrollBarSize() >> 8) + 25;
                char mode9 = (char) (View.MeasureSpec.getMode(0) + 30068);
                int maximumFlingVelocity17 = 816 - (ViewConfiguration.getMaximumFlingVelocity() >> 16);
                byte[] bArr4118 = $$a;
                Object[] objArr12118 = new Object[1];
                b((byte) (bArr4118[110] - 1), bArr4118[108], bArr4118[56], objArr12118);
                objAccessartificialFrame18 = ArtificialStackFrames.coroutineCreation(scrollBarSize10, mode9, maximumFlingVelocity17, 891606461, false, (String) objArr12118[0], null);
            }
            ((Field) objAccessartificialFrame18).set(null, objArr12117);
            Long lValueOf19 = Long.valueOf(((Long) Class.forName(str2).getDeclaredMethod(str3, new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame19 = ArtificialStackFrames.accessartificialFrame(-1268268649);
            if (objAccessartificialFrame19 == null) {
                int tapTimeout7 = 25 - (ViewConfiguration.getTapTimeout() >> 16);
                char cMakeMeasureSpec6 = (char) (View.MeasureSpec.makeMeasureSpec(0, 0) + 30068);
                int maximumFlingVelocity18 = (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 816;
                byte[] bArr4119 = $$a;
                Object[] objArr12119 = new Object[1];
                b((byte) (bArr4119[110] - 1), bArr4119[12], bArr4119[56], objArr12119);
                objAccessartificialFrame19 = ArtificialStackFrames.coroutineCreation(tapTimeout7, cMakeMeasureSpec6, maximumFlingVelocity18, 721586079, false, (String) objArr12119[0], null);
            }
            ((Field) objAccessartificialFrame19).set(null, lValueOf19);
            objArr8 = objArr12117;
        }
        i13 = ((int[]) objArr8[1])[0];
        i14 = ((int[]) objArr8[0])[0];
        if (i14 == i13) {
            Object[] objArr1310 = {new int[]{i191}, new int[]{i192}, strArr12, new int[1]};
            int i1910 = ((int[]) objArr8[3])[0];
            int i1911 = ((int[]) objArr8[0])[0];
            int i1912 = ((int[]) objArr8[1])[0];
            String[] strArr16 = (String[]) objArr8[2];
            int iIdentityHashCode9 = System.identityHashCode(this);
            int i1913 = ~iIdentityHashCode9;
            int i1914 = ~((-582700715) | i1913);
            int i1915 = ~(384528348 | iIdentityHashCode9);
            int i1916 = i1910 + (-2081787814) + ((i1914 | i1915) * 1150) + (((~((-384528349) | i1913)) | i1915) * (-575)) + (((~(iIdentityHashCode9 | (-582700715))) | (~(i1913 | 582700714))) * 575);
            int i1917 = (i1916 << 13) ^ i1916;
            int i1918 = i1917 ^ (i1917 >>> 17);
            ((int[]) objArr1310[3])[0] = i1918 ^ (i1918 << 5);
            return;
        }
        arrayList = new ArrayList();
        strArr = (String[]) objArr8[2];
        if (strArr != null) {
            while (i15 < strArr.length) {
                arrayList.add(str9);
            }
        }
        long j11 = ((long) (i13 ^ i14)) ^ (((long) 944545494) << 32);
        long j12 = 944545495;
        int i1919 = getARTIFICIAL_FRAME_PACKAGE_NAME + 113;
        artificialFrame = i1919 % 128;
        int i2010 = i1919 % 2;
        Object[] objArr1311 = {Long.valueOf(j11), Long.valueOf(j12)};
        byte[] bArr56 = $$d;
        Object[] objArr1312 = new Object[1];
        c((short) 571, bArr56[142], bArr56[8], objArr1312);
        Class<?> cls119 = Class.forName((String) objArr1312[0]);
        Object[] objArr1313 = new Object[1];
        c((short) 116, bArr56[5], bArr56[72], objArr1313);
        cls119.getMethod((String) objArr1313[0], Long.TYPE, Long.TYPE).invoke(null, objArr1311);
        Object[] objArr1314 = {new int[]{i202}, new int[]{i203}, strArr13, new int[1]};
        int i2011 = ((int[]) objArr8[3])[0];
        int i2012 = ((int[]) objArr8[0])[0];
        int i2013 = ((int[]) objArr8[1])[0];
        String[] strArr17 = (String[]) objArr8[2];
        int i2014 = (int) Runtime.getRuntime().totalMemory();
        int i2015 = ~i2014;
        int i2016 = i2011 + (-915497092) + (((~((-269541649) | i2015)) | (~((-673452041) | i2014)) | (~(1014362970 | i2014))) * 765) + (((~((-942993689) | i2015)) | 269541648) * 1530) + (((~(i2014 | (-942993689))) | (~(i2015 | 1014362970))) * 765);
        int i2017 = (i2016 << 13) ^ i2016;
        int i2018 = i2017 ^ (i2017 >>> 17);
        ((int[]) objArr1314[3])[0] = i2018 ^ (i2018 << 5);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onResume() throws Throwable {
        int i = 2 % 2;
        int i2 = getARTIFICIAL_FRAME_PACKAGE_NAME + AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
        artificialFrame = i2 % 128;
        Object obj = null;
        if (i2 % 2 == 0) {
            Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(949068051);
            if (objAccessartificialFrame == null) {
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(30 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) (KeyEvent.normalizeMetaState(0) + 49993), View.MeasureSpec.makeMeasureSpec(0, 0) + 74, -1477122277, false, "MediaDescriptionCompatApi23Builder", null);
            }
            Object obj2 = ((Field) objAccessartificialFrame).get(null);
            try {
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1579113874);
                if (objAccessartificialFrame2 == null) {
                    int i3 = 30 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                    char cRgb = (char) (Color.rgb(0, 0, 0) + 16827209);
                    int mode = 74 - View.MeasureSpec.getMode(0);
                    short s = (short) TypedValues.MotionType.TYPE_POLAR_RELATIVETO;
                    byte[] bArr = $$d;
                    Object[] objArr = new Object[1];
                    c(s, bArr[64], bArr[24], objArr);
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(i3, cRgb, mode, -1048962150, false, (String) objArr[0], new Class[0]);
                }
                ((Method) objAccessartificialFrame2).invoke(obj2, null);
                super.onResume();
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
            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation('N' - AndroidCharacter.getMirror('0'), (char) ((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 49993), Process.getGidForName("") + 75, -1477122277, false, "MediaDescriptionCompatApi23Builder", null);
        }
        Object obj3 = ((Field) objAccessartificialFrame3).get(null);
        try {
            Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1579113874);
            if (objAccessartificialFrame4 == null) {
                int scrollBarSize = 30 - (ViewConfiguration.getScrollBarSize() >> 8);
                char c = (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 49992);
                int iIndexOf = 73 - TextUtils.indexOf((CharSequence) "", '0', 0, 0);
                short s2 = (short) TypedValues.MotionType.TYPE_POLAR_RELATIVETO;
                byte[] bArr2 = $$d;
                Object[] objArr2 = new Object[1];
                c(s2, bArr2[64], bArr2[24], objArr2);
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(scrollBarSize, c, iIndexOf, -1048962150, false, (String) objArr2[0], new Class[0]);
            }
            ((Method) objAccessartificialFrame4).invoke(obj3, null);
            super.onResume();
            int i4 = getARTIFICIAL_FRAME_PACKAGE_NAME + 43;
            artificialFrame = i4 % 128;
            int i5 = i4 % 2;
        } catch (Throwable th2) {
            Throwable cause2 = th2.getCause();
            if (cause2 == null) {
                throw th2;
            }
            throw cause2;
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onPause() throws Throwable {
        int i = 2 % 2;
        int i2 = getARTIFICIAL_FRAME_PACKAGE_NAME + 51;
        artificialFrame = i2 % 128;
        int i3 = i2 % 2;
        Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(949068051);
        if (objAccessartificialFrame == null) {
            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(30 - KeyEvent.keyCodeFromString(""), (char) (49992 - MotionEvent.axisFromString("")), TextUtils.getOffsetAfter("", 0) + 74, -1477122277, false, "MediaDescriptionCompatApi23Builder", null);
        }
        Object obj = ((Field) objAccessartificialFrame).get(null);
        try {
            Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1579114835);
            if (objAccessartificialFrame2 == null) {
                int iMyPid = 30 - (Process.myPid() >> 22);
                char offsetAfter = (char) (49993 - TextUtils.getOffsetAfter("", 0));
                int deadChar = KeyEvent.getDeadChar(0, 0) + 74;
                short s = (short) TypedValues.MotionType.TYPE_POLAR_RELATIVETO;
                byte[] bArr = $$d;
                Object[] objArr = new Object[1];
                c(s, bArr[64], bArr[8], objArr);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iMyPid, offsetAfter, deadChar, -1048959141, false, (String) objArr[0], new Class[0]);
            }
            ((Method) objAccessartificialFrame2).invoke(obj, null);
            super.onPause();
            int i4 = getARTIFICIAL_FRAME_PACKAGE_NAME + 49;
            artificialFrame = i4 % 128;
            int i5 = i4 % 2;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x01cb  */
    /* JADX WARN: Code duplicated, block: B:16:0x027e A[Catch: all -> 0x0acc, TryCatch #2 {all -> 0x0acc, blocks: (B:55:0x07a7, B:57:0x07bb, B:58:0x07ea, B:14:0x025d, B:16:0x027e, B:17:0x02cb), top: B:102:0x025d }] */
    /* JADX WARN: Code duplicated, block: B:20:0x02dd  */
    /* JADX WARN: Code duplicated, block: B:25:0x03b5  */
    /* JADX WARN: Code duplicated, block: B:54:0x0735  */
    /* JADX WARN: Code duplicated, block: B:57:0x07bb A[Catch: all -> 0x0acc, TryCatch #2 {all -> 0x0acc, blocks: (B:55:0x07a7, B:57:0x07bb, B:58:0x07ea, B:14:0x025d, B:16:0x027e, B:17:0x02cb), top: B:102:0x025d }] */
    /* JADX WARN: Code duplicated, block: B:61:0x0800  */
    /* JADX WARN: Code duplicated, block: B:66:0x08a3  */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) throws Throwable {
        Object objAccessartificialFrame;
        Object[] objArr;
        Object objAccessartificialFrame2;
        Object objAccessartificialFrame3;
        Object objAccessartificialFrame4;
        Object[] objArrAccessartificialFrame$78cbbd35;
        Object objAccessartificialFrame5;
        Object objAccessartificialFrame6;
        char c;
        int i = 2 % 2;
        super.attachBaseContext(context);
        Object objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-1268268649);
        if (objAccessartificialFrame7 == null) {
            int size = 25 - View.MeasureSpec.getSize(0);
            char cLastIndexOf = (char) (TextUtils.lastIndexOf("", '0', 0, 0) + 30069);
            int i2 = (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 815;
            byte[] bArr = $$a;
            Object[] objArr2 = new Object[1];
            b((byte) (bArr[110] - 1), bArr[12], bArr[56], objArr2);
            objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(size, cLastIndexOf, i2, 721586079, false, (String) objArr2[0], null);
        }
        long j = ((Field) objAccessartificialFrame7).getLong(null);
        if (j != -1) {
            long j2 = j + 1991;
            Object[] objArr3 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 59504, new char[]{5469, 64961, 50302, 44279, 46879, 40842, 26154, 18711, 20939, 14436, 172, 60222, 62369, 55864, 44354, 46532, 40033, 25788, 20230, 22458, 15907, 344}, objArr3);
            Class<?> cls = Class.forName((String) objArr3[0]);
            Object[] objArr4 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 55369, new char[]{5465, 52509, 42439, 40363, 29819, 11480, 1174, 65397, 55089, 36840, 26194, 24071, 14025, 61112, 49519}, objArr4);
            if (j2 >= ((Long) cls.getDeclaredMethod((String) objArr4[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame8 == null) {
                    int threadPriority = 25 - ((Process.getThreadPriority(0) + 20) >> 6);
                    char pressedStateDuration = (char) ((ViewConfiguration.getPressedStateDuration() >> 16) + 30068);
                    int windowTouchSlop = 816 - (ViewConfiguration.getWindowTouchSlop() >> 8);
                    byte[] bArr2 = $$a;
                    Object[] objArr5 = new Object[1];
                    b((byte) (bArr2[110] - 1), bArr2[108], bArr2[56], objArr5);
                    objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(threadPriority, pressedStateDuration, windowTouchSlop, 891606461, false, (String) objArr5[0], null);
                }
                Object[] objArr6 = (Object[]) ((Field) objAccessartificialFrame8).get(null);
                objArr = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i3 = ((int[]) objArr6[0])[0];
                int i4 = ((int[]) objArr6[1])[0];
                String[] strArr = (String[]) objArr6[2];
                int length = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 1118021637;
                int i5 = (-1935965397) + (((~((-966879648) | length)) | 768707281) * (-318));
                int i6 = ~(768707281 | length);
                int i7 = ~length;
                int i8 = ((i5 + ((i6 | (~((-72385089) | i7))) * TypedValues.AttributesType.TYPE_PIVOT_TARGET)) + (((~(length | (-72385089))) | (~(1039264735 | i7))) * TypedValues.AttributesType.TYPE_PIVOT_TARGET)) - 1321750609;
                int i9 = (i8 << 13) ^ i8;
                int i10 = i9 ^ (i9 >>> 17);
                ((int[]) objArr[3])[0] = i10 ^ (i10 << 5);
            } else {
                Object[] objArr7 = new Object[1];
                a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) + 51817, new char[]{5462, 57296, 32848, 19194, 16166, 57745, 43539, 40073, 16691, 3047, 64749, 41290, 27603, 23649, 1775, 51986}, objArr7);
                Class<?> cls2 = Class.forName((String) objArr7[0]);
                Object[] objArr8 = new Object[1];
                a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 43483, new char[]{5461, 48263, 18151, 59599, 45620, 17422, 61042, 45148, 23436, 60810, 47097, 22977, 58123, 46336, 24426, 57672}, objArr8);
                try {
                    Object[] objArr9 = {Integer.valueOf(((Integer) cls2.getMethod((String) objArr8[0], Object.class).invoke(null, this)).intValue()), 0, -1321750609};
                    objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(1327366003);
                    if (objAccessartificialFrame == null) {
                        int iGreen = Color.green(0) + 25;
                        char keyRepeatTimeout = (char) ((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 30068);
                        int iNormalizeMetaState = 816 - KeyEvent.normalizeMetaState(0);
                        byte[] bArr3 = $$a;
                        Object[] objArr10 = new Object[1];
                        b((byte) (bArr3[19] - 1), (byte) 105, bArr3[81], objArr10);
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(iGreen, keyRepeatTimeout, iNormalizeMetaState, -797394565, false, (String) objArr10[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                    }
                    objArr = (Object[]) ((Method) objAccessartificialFrame).invoke(null, objArr9);
                    objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                    if (objAccessartificialFrame2 == null) {
                        int i11 = 26 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
                        char offsetBefore = (char) (TextUtils.getOffsetBefore("", 0) + 30068);
                        int maximumDrawingCacheSize = 816 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                        byte[] bArr4 = $$a;
                        Object[] objArr11 = new Object[1];
                        b((byte) (bArr4[110] - 1), bArr4[108], bArr4[56], objArr11);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(i11, offsetBefore, maximumDrawingCacheSize, 891606461, false, (String) objArr11[0], null);
                    }
                    ((Field) objAccessartificialFrame2).set(null, objArr);
                    try {
                        Object[] objArr12 = new Object[1];
                        a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(0) + 59502, new char[]{5469, 64961, 50302, 44279, 46879, 40842, 26154, 18711, 20939, 14436, 172, 60222, 62369, 55864, 44354, 46532, 40033, 25788, 20230, 22458, 15907, 344}, objArr12);
                        Class<?> cls3 = Class.forName((String) objArr12[0]);
                        Object[] objArr13 = new Object[1];
                        a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 55338, new char[]{5465, 52509, 42439, 40363, 29819, 11480, 1174, 65397, 55089, 36840, 26194, 24071, 14025, 61112, 49519}, objArr13);
                        Long lValueOf = Long.valueOf(((Long) cls3.getDeclaredMethod((String) objArr13[0], new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                        if (objAccessartificialFrame3 == null) {
                            int iResolveOpacity = Drawable.resolveOpacity(0, 0) + 25;
                            char modifierMetaStateMask = (char) (30067 - ((byte) KeyEvent.getModifierMetaStateMask()));
                            int i12 = (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 815;
                            byte[] bArr5 = $$a;
                            Object[] objArr14 = new Object[1];
                            b((byte) (bArr5[110] - 1), bArr5[12], bArr5[56], objArr14);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(iResolveOpacity, modifierMetaStateMask, i12, 721586079, false, (String) objArr14[0], null);
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
            Object[] objArr15 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) + 51817, new char[]{5462, 57296, 32848, 19194, 16166, 57745, 43539, 40073, 16691, 3047, 64749, 41290, 27603, 23649, 1775, 51986}, objArr15);
            Class<?> cls4 = Class.forName((String) objArr15[0]);
            Object[] objArr16 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 43483, new char[]{5461, 48263, 18151, 59599, 45620, 17422, 61042, 45148, 23436, 60810, 47097, 22977, 58123, 46336, 24426, 57672}, objArr16);
            Object[] objArr17 = {Integer.valueOf(((Integer) cls4.getMethod((String) objArr16[0], Object.class).invoke(null, this)).intValue()), 0, -1321750609};
            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(1327366003);
            if (objAccessartificialFrame == null) {
                int iGreen2 = Color.green(0) + 25;
                char keyRepeatTimeout2 = (char) ((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 30068);
                int iNormalizeMetaState2 = 816 - KeyEvent.normalizeMetaState(0);
                byte[] bArr6 = $$a;
                Object[] objArr18 = new Object[1];
                b((byte) (bArr6[19] - 1), (byte) 105, bArr6[81], objArr18);
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(iGreen2, keyRepeatTimeout2, iNormalizeMetaState2, -797394565, false, (String) objArr18[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            }
            objArr = (Object[]) ((Method) objAccessartificialFrame).invoke(null, objArr17);
            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame2 == null) {
                int i13 = 26 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
                char offsetBefore2 = (char) (TextUtils.getOffsetBefore("", 0) + 30068);
                int maximumDrawingCacheSize2 = 816 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                byte[] bArr7 = $$a;
                Object[] objArr19 = new Object[1];
                b((byte) (bArr7[110] - 1), bArr7[108], bArr7[56], objArr19);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(i13, offsetBefore2, maximumDrawingCacheSize2, 891606461, false, (String) objArr19[0], null);
            }
            ((Field) objAccessartificialFrame2).set(null, objArr);
            Object[] objArr110 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(0) + 59502, new char[]{5469, 64961, 50302, 44279, 46879, 40842, 26154, 18711, 20939, 14436, 172, 60222, 62369, 55864, 44354, 46532, 40033, 25788, 20230, 22458, 15907, 344}, objArr110);
            Class<?> cls5 = Class.forName((String) objArr110[0]);
            Object[] objArr111 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 55338, new char[]{5465, 52509, 42439, 40363, 29819, 11480, 1174, 65397, 55089, 36840, 26194, 24071, 14025, 61112, 49519}, objArr111);
            Long lValueOf2 = Long.valueOf(((Long) cls5.getDeclaredMethod((String) objArr111[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1268268649);
            if (objAccessartificialFrame3 == null) {
                int iResolveOpacity2 = Drawable.resolveOpacity(0, 0) + 25;
                char modifierMetaStateMask2 = (char) (30067 - ((byte) KeyEvent.getModifierMetaStateMask()));
                int i14 = (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 815;
                byte[] bArr8 = $$a;
                Object[] objArr112 = new Object[1];
                b((byte) (bArr8[110] - 1), bArr8[12], bArr8[56], objArr112);
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(iResolveOpacity2, modifierMetaStateMask2, i14, 721586079, false, (String) objArr112[0], null);
            }
            ((Field) objAccessartificialFrame3).set(null, lValueOf2);
        }
        int i15 = ((int[]) objArr[1])[0];
        int i16 = ((int[]) objArr[0])[0];
        if (i16 == i15) {
            int i17 = getARTIFICIAL_FRAME_PACKAGE_NAME + 41;
            artificialFrame = i17 % 128;
            int i18 = i17 % 2;
            Object[] objArr20 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i19 = ((int[]) objArr[3])[0];
            int i20 = ((int[]) objArr[0])[0];
            int i21 = ((int[]) objArr[1])[0];
            String[] strArr2 = (String[]) objArr[2];
            int iMyTid = Process.myTid();
            int i22 = ~iMyTid;
            int i23 = (~((-852377027) | i22)) | 583933120;
            int i24 = ~(iMyTid | 922648566);
            int i25 = i19 + 649091196 + ((i23 | i24) * (-713)) + (i24 * 1426) + ((~(654204660 | i22)) * 713);
            int i26 = (i25 << 13) ^ i25;
            int i27 = i26 ^ (i26 >>> 17);
            ((int[]) objArr20[3])[0] = i27 ^ (i27 << 5);
        } else {
            ArrayList arrayList = new ArrayList();
            int i28 = 2;
            String[] strArr3 = (String[]) objArr[2];
            if (strArr3 != null) {
                int i29 = getARTIFICIAL_FRAME_PACKAGE_NAME + 121;
                artificialFrame = i29 % 128;
                int i30 = i29 % 2;
                int i31 = 0;
                while (i31 < strArr3.length) {
                    int i32 = getARTIFICIAL_FRAME_PACKAGE_NAME + 81;
                    artificialFrame = i32 % 128;
                    if (i32 % i28 == 0) {
                        arrayList.add(strArr3[i31]);
                        i31 += 105;
                    } else {
                        arrayList.add(strArr3[i31]);
                        i31++;
                    }
                    i28 = 2;
                }
            }
            try {
                Object[] objArr21 = {Long.valueOf(((long) (i15 ^ i16)) ^ (((long) 69604592) << 32)), Long.valueOf(69604593)};
                byte[] bArr9 = $$d;
                Object[] objArr22 = new Object[1];
                c((short) 571, bArr9[142], bArr9[8], objArr22);
                Class<?> cls6 = Class.forName((String) objArr22[0]);
                Object[] objArr23 = new Object[1];
                c((short) 116, bArr9[5], bArr9[72], objArr23);
                cls6.getMethod((String) objArr23[0], Long.TYPE, Long.TYPE).invoke(null, objArr21);
                Object[] objArr24 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i33 = ((int[]) objArr[3])[0];
                int i34 = ((int[]) objArr[0])[0];
                int i35 = ((int[]) objArr[1])[0];
                String[] strArr4 = (String[]) objArr[2];
                int length2 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 1866809300;
                int i36 = ~length2;
                int i37 = i33 + 81131033 + (((~(262739113 | i36)) | (-460911480) | (~((-262739114) | length2))) * (-564)) + ((~(length2 | (-187174946))) * 1128) + (((~((-460911480) | i36)) | 75564168) * 564);
                int i38 = (i37 << 13) ^ i37;
                int i39 = i38 ^ (i38 >>> 17);
                ((int[]) objArr24[3])[0] = i39 ^ (i39 << 5);
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
            int deadChar = KeyEvent.getDeadChar(0, 0) + 26;
            char cLastIndexOf2 = (char) (TextUtils.lastIndexOf("", '0', 0) + 1);
            int iAlpha = Color.alpha(0) + 1041;
            byte[] bArr10 = $$a;
            Object[] objArr25 = new Object[1];
            b((byte) (bArr10[110] - 1), bArr10[12], bArr10[56], objArr25);
            objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(deadChar, cLastIndexOf2, iAlpha, 2061780482, false, (String) objArr25[0], null);
        }
        long j3 = ((Field) objAccessartificialFrame9).getLong(null);
        if (j3 != -1) {
            long j4 = j3 + 4611686018427387842L;
            Object[] objArr26 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 59504, new char[]{5469, 64961, 50302, 44279, 46879, 40842, 26154, 18711, 20939, 14436, 172, 60222, 62369, 55864, 44354, 46532, 40033, 25788, 20230, 22458, 15907, 344}, objArr26);
            Class<?> cls7 = Class.forName((String) objArr26[0]);
            Object[] objArr27 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 55338, new char[]{5465, 52509, 42439, 40363, 29819, 11480, 1174, 65397, 55089, 36840, 26194, 24071, 14025, 61112, 49519}, objArr27);
            if (j4 >= ((Long) cls7.getDeclaredMethod((String) objArr27[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame10 == null) {
                    int i40 = (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 26;
                    char touchSlop = (char) (ViewConfiguration.getTouchSlop() >> 8);
                    int scrollDefaultDelay = (ViewConfiguration.getScrollDefaultDelay() >> 16) + 1041;
                    byte[] bArr11 = $$a;
                    Object[] objArr28 = new Object[1];
                    b((byte) (bArr11[110] - 1), bArr11[108], bArr11[56], objArr28);
                    objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(i40, touchSlop, scrollDefaultDelay, 1145017376, false, (String) objArr28[0], null);
                }
                Object[] objArr29 = (Object[]) ((Field) objAccessartificialFrame10).get(null);
                objArrAccessartificialFrame$78cbbd35 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
                int i41 = ((int[]) objArr29[3])[0];
                int i42 = ((int[]) objArr29[2])[0];
                String[] strArr5 = (String[]) objArr29[0];
                int i43 = ~(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().smallestScreenWidthDp | (-847353393));
                int i44 = (((-1657532994) + (((-925457200) | i43) * (-220))) + ((i43 | 8422416) * 220)) - 142129537;
                int i45 = (i44 << 13) ^ i44;
                int i46 = i45 ^ (i45 >>> 17);
                ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0] = i46 ^ (i46 << 5);
                c = 2;
            } else {
                Object[] objArr30 = new Object[1];
                a(51853 - Color.argb(0, 0, 0, 0), new char[]{5462, 57296, 32848, 19194, 16166, 57745, 43539, 40073, 16691, 3047, 64749, 41290, 27603, 23649, 1775, 51986}, objArr30);
                Class<?> cls8 = Class.forName((String) objArr30[0]);
                Object[] objArr31 = new Object[1];
                a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 43483, new char[]{5461, 48263, 18151, 59599, 45620, 17422, 61042, 45148, 23436, 60810, 47097, 22977, 58123, 46336, 24426, 57672}, objArr31);
                int iIntValue = ((Integer) cls8.getMethod((String) objArr31[0], Object.class).invoke(null, this)).intValue();
                Object[] objArr32 = {683807379};
                objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1648942878);
                if (objAccessartificialFrame4 == null) {
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 7, (char) (22251 - View.getDefaultSize(0, 0)), 1032 - ((byte) KeyEvent.getModifierMetaStateMask()), 47343338, false, null, new Class[]{Integer.TYPE});
                }
                objArrAccessartificialFrame$78cbbd35 = UriModifierInterface.ModificationResult.Modified.ModifiedToMaxDimens.accessartificialFrame$78cbbd35(iIntValue, 0, ((Constructor) objAccessartificialFrame4).newInstance(objArr32), 1712286271, false);
                objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame5 == null) {
                    int pressedStateDuration2 = 26 - (ViewConfiguration.getPressedStateDuration() >> 16);
                    char c2 = (char) (1 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)));
                    int iIndexOf = 1040 - TextUtils.indexOf((CharSequence) "", '0', 0);
                    byte[] bArr12 = $$a;
                    Object[] objArr33 = new Object[1];
                    b((byte) (bArr12[110] - 1), bArr12[108], bArr12[56], objArr33);
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(pressedStateDuration2, c2, iIndexOf, 1145017376, false, (String) objArr33[0], null);
                }
                ((Field) objAccessartificialFrame5).set(null, objArrAccessartificialFrame$78cbbd35);
                try {
                    Object[] objArr34 = new Object[1];
                    a(TextUtils.getOffsetBefore("", 0) + 59539, new char[]{5469, 64961, 50302, 44279, 46879, 40842, 26154, 18711, 20939, 14436, 172, 60222, 62369, 55864, 44354, 46532, 40033, 25788, 20230, 22458, 15907, 344}, objArr34);
                    Class<?> cls9 = Class.forName((String) objArr34[0]);
                    Object[] objArr35 = new Object[1];
                    a(55374 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), new char[]{5465, 52509, 42439, 40363, 29819, 11480, 1174, 65397, 55089, 36840, 26194, 24071, 14025, 61112, 49519}, objArr35);
                    Long lValueOf3 = Long.valueOf(((Long) cls9.getDeclaredMethod((String) objArr35[0], new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-444530678);
                    if (objAccessartificialFrame6 == null) {
                        int modifierMetaStateMask3 = 25 - ((byte) KeyEvent.getModifierMetaStateMask());
                        char c3 = (char) ((-1) - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)));
                        int iAxisFromString = 1040 - MotionEvent.axisFromString("");
                        byte[] bArr13 = $$a;
                        Object[] objArr36 = new Object[1];
                        b((byte) (bArr13[110] - 1), bArr13[12], bArr13[56], objArr36);
                        objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(modifierMetaStateMask3, c3, iAxisFromString, 2061780482, false, (String) objArr36[0], null);
                    }
                    ((Field) objAccessartificialFrame6).set(null, lValueOf3);
                    int i47 = getARTIFICIAL_FRAME_PACKAGE_NAME + 83;
                    artificialFrame = i47 % 128;
                    c = 2;
                    int i48 = i47 % 2;
                } catch (Exception unused2) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object[] objArr37 = new Object[1];
            a(51853 - Color.argb(0, 0, 0, 0), new char[]{5462, 57296, 32848, 19194, 16166, 57745, 43539, 40073, 16691, 3047, 64749, 41290, 27603, 23649, 1775, 51986}, objArr37);
            Class<?> cls10 = Class.forName((String) objArr37[0]);
            Object[] objArr38 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 43483, new char[]{5461, 48263, 18151, 59599, 45620, 17422, 61042, 45148, 23436, 60810, 47097, 22977, 58123, 46336, 24426, 57672}, objArr38);
            int iIntValue2 = ((Integer) cls10.getMethod((String) objArr38[0], Object.class).invoke(null, this)).intValue();
            Object[] objArr39 = {683807379};
            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame4 == null) {
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 7, (char) (22251 - View.getDefaultSize(0, 0)), 1032 - ((byte) KeyEvent.getModifierMetaStateMask()), 47343338, false, null, new Class[]{Integer.TYPE});
            }
            objArrAccessartificialFrame$78cbbd35 = UriModifierInterface.ModificationResult.Modified.ModifiedToMaxDimens.accessartificialFrame$78cbbd35(iIntValue2, 0, ((Constructor) objAccessartificialFrame4).newInstance(objArr39), 1712286271, false);
            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame5 == null) {
                int pressedStateDuration3 = 26 - (ViewConfiguration.getPressedStateDuration() >> 16);
                char c4 = (char) (1 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)));
                int iIndexOf2 = 1040 - TextUtils.indexOf((CharSequence) "", '0', 0);
                byte[] bArr14 = $$a;
                Object[] objArr310 = new Object[1];
                b((byte) (bArr14[110] - 1), bArr14[108], bArr14[56], objArr310);
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(pressedStateDuration3, c4, iIndexOf2, 1145017376, false, (String) objArr310[0], null);
            }
            ((Field) objAccessartificialFrame5).set(null, objArrAccessartificialFrame$78cbbd35);
            Object[] objArr311 = new Object[1];
            a(TextUtils.getOffsetBefore("", 0) + 59539, new char[]{5469, 64961, 50302, 44279, 46879, 40842, 26154, 18711, 20939, 14436, 172, 60222, 62369, 55864, 44354, 46532, 40033, 25788, 20230, 22458, 15907, 344}, objArr311);
            Class<?> cls11 = Class.forName((String) objArr311[0]);
            Object[] objArr312 = new Object[1];
            a(55374 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), new char[]{5465, 52509, 42439, 40363, 29819, 11480, 1174, 65397, 55089, 36840, 26194, 24071, 14025, 61112, 49519}, objArr312);
            Long lValueOf4 = Long.valueOf(((Long) cls11.getDeclaredMethod((String) objArr312[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-444530678);
            if (objAccessartificialFrame6 == null) {
                int modifierMetaStateMask4 = 25 - ((byte) KeyEvent.getModifierMetaStateMask());
                char c5 = (char) ((-1) - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)));
                int iAxisFromString2 = 1040 - MotionEvent.axisFromString("");
                byte[] bArr15 = $$a;
                Object[] objArr313 = new Object[1];
                b((byte) (bArr15[110] - 1), bArr15[12], bArr15[56], objArr313);
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(modifierMetaStateMask4, c5, iAxisFromString2, 2061780482, false, (String) objArr313[0], null);
            }
            ((Field) objAccessartificialFrame6).set(null, lValueOf4);
            int i49 = getARTIFICIAL_FRAME_PACKAGE_NAME + 83;
            artificialFrame = i49 % 128;
            c = 2;
            int i410 = i49 % 2;
        }
        int i50 = ((int[]) objArrAccessartificialFrame$78cbbd35[c])[0];
        int i51 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
        if (i51 == i50) {
            Object[] objArr40 = new Object[4];
            objArr40[1] = new int[1];
            objArr40[c] = new int[]{i};
            objArr40[3] = new int[]{i};
            int i52 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i53 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i54 = ((int[]) objArrAccessartificialFrame$78cbbd35[c])[0];
            objArr40[0] = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int length3 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() - 1587288325;
            int i55 = ~length3;
            int i56 = i52 + (-1224222930) + ((619699031 | length3) * (-676)) + (((~(619434069 | i55)) | (-619699032)) * 676) + (((~(length3 | (-264963))) | (~(i55 | 541330262)) | 78368769) * 676);
            int i57 = (i56 << 13) ^ i56;
            int i58 = i57 ^ (i57 >>> 17);
            ((int[]) objArr40[1])[0] = i58 ^ (i58 << 5);
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        String[] strArr6 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
        if (strArr6 != null) {
            int i59 = 0;
            while (i59 < strArr6.length) {
                int i60 = getARTIFICIAL_FRAME_PACKAGE_NAME + 3;
                artificialFrame = i60 % 128;
                if (i60 % 2 == 0) {
                    arrayList2.add(strArr6[i59]);
                    i59 += 61;
                } else {
                    arrayList2.add(strArr6[i59]);
                    i59++;
                }
            }
        }
        long j5 = (((long) (-1825346109)) << 32) ^ ((long) (i50 ^ i51));
        long j6 = -1825346111;
        int i61 = artificialFrame + 101;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i61 % 128;
        int i62 = i61 % 2;
        Object[] objArr41 = {Long.valueOf(j5), Long.valueOf(j6)};
        short s = (short) TypedValues.MotionType.TYPE_POLAR_RELATIVETO;
        byte[] bArr16 = $$d;
        Object[] objArr42 = new Object[1];
        c(s, (byte) (bArr16[14] - 1), bArr16[64], objArr42);
        Class<?> cls12 = Class.forName((String) objArr42[0]);
        Object[] objArr43 = new Object[1];
        c((short) 116, bArr16[5], bArr16[72], objArr43);
        cls12.getMethod((String) objArr43[0], Long.TYPE, Long.TYPE).invoke(null, objArr41);
        Object[] objArr44 = {strArr, new int[1], new int[]{i}, new int[]{i}};
        int i63 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
        int i64 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
        int i65 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
        String[] strArr7 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
        int i66 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().screenLayout;
        int i67 = 1589361294 + (((~((-3028484) | i66)) | 405504 | (~(75075323 | i66))) * (-754));
        int i68 = ~((-405505) | i66);
        int i69 = ~i66;
        int i70 = i63 + i67 + ((i68 | (~(75480827 | i69))) * (-754)) + ((i69 | (-3028484)) * 754);
        int i71 = (i70 << 13) ^ i70;
        int i72 = i71 ^ (i71 >>> 17);
        ((int[]) objArr44[1])[0] = i72 ^ (i72 << 5);
    }

    static void accessartificialFrame() {
        extraCommand = 5605737734866447667L;
    }
}
