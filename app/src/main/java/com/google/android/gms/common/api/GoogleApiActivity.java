package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.Build;
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
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import ch.qos.logback.core.CoreConstants;
import com.facebook.imageutils.JfifUtil;
import com.google.android.gms.cloudmessaging.CloudMessagingReceiver;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.internal.Preconditions;
import com.google.common.base.Ascii;
import com.google.crypto.tink.hybrid.internal.HpkePrivateKeyManager$$ExternalSyntheticLambda2;
import com.salesforce.marketingcloud.analytics.stats.b;
import io.sentry.android.core.SentryLogcatAdapter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import kotlin.text.Typography;
import net.pluservice.unicoc.R;
import o.ArtificialStackFrames;
import o.extraCallback;
import org.apache.commons.lang3.CharEncoding;
import org.apache.commons.lang3.CharUtils;

/* JADX INFO: loaded from: classes2.dex */
public class GoogleApiActivity extends Activity implements DialogInterface.OnCancelListener {
    private static final byte[] $$a;
    private static final int $$b;
    private static final byte[] $$d;
    private static final int $$e;
    private static char[] ArtificialStackFrames;
    private static int artificialFrame;
    private static char coroutineCreation;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME;
    protected int zaa = 0;
    private static final byte[] $$c = {99, -110, -1, 56};
    private static final int $$f = 18;
    private static int $10 = 0;
    private static int $11 = 1;

    /* JADX WARN: Code duplicated, block: B:10:0x0024  */
    /* JADX WARN: Code duplicated, block: B:8:0x001e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0024 -> B:11:0x0026). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0024
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$g(int r5, int r6, short r7) {
        /*
            byte[] r0 = com.google.android.gms.common.api.GoogleApiActivity.$$c
            int r5 = r5 * 3
            int r1 = 1 - r5
            int r7 = r7 * 3
            int r7 = r7 + 4
            int r6 = r6 + 97
            byte[] r1 = new byte[r1]
            r2 = 0
            int r5 = 0 - r5
            if (r0 != 0) goto L16
            r3 = r5
            r4 = r2
            goto L26
        L16:
            r3 = r2
        L17:
            byte r4 = (byte) r6
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r5) goto L24
            java.lang.String r5 = new java.lang.String
            r5.<init>(r1, r2)
            return r5
        L24:
            r3 = r0[r7]
        L26:
            int r7 = r7 + 1
            int r3 = -r3
            int r6 = r6 + r3
            r3 = r4
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.GoogleApiActivity.$$g(int, int, short):java.lang.String");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0023  */
    /* JADX WARN: Code duplicated, block: B:8:0x001b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x0029). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0023
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void b(byte r7, short r8, int r9, java.lang.Object[] r10) {
        /*
            int r9 = r9 + 8
            int r8 = 112 - r8
            int r7 = 108 - r7
            byte[] r0 = com.google.android.gms.common.api.GoogleApiActivity.$$a
            byte[] r1 = new byte[r9]
            r2 = 0
            if (r0 != 0) goto L11
            r3 = r8
            r4 = r2
            r8 = r7
            goto L29
        L11:
            r3 = r2
        L12:
            int r4 = r3 + 1
            byte r5 = (byte) r8
            r1[r3] = r5
            int r7 = r7 + 1
            if (r4 != r9) goto L23
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L23:
            r3 = r0[r7]
            r6 = r8
            r8 = r7
            r7 = r3
            r3 = r6
        L29:
            int r7 = -r7
            int r7 = r7 + r3
            r3 = r4
            r6 = r8
            r8 = r7
            r7 = r6
            goto L12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.GoogleApiActivity.b(byte, short, int, java.lang.Object[]):void");
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
    private static void c(byte r6, int r7, byte r8, java.lang.Object[] r9) {
        /*
            int r8 = 92 - r8
            byte[] r0 = com.google.android.gms.common.api.GoogleApiActivity.$$d
            int r6 = r6 + 36
            int r7 = 680 - r7
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L10
            r3 = r7
            r4 = r2
            goto L26
        L10:
            r3 = r2
        L11:
            byte r4 = (byte) r6
            r1[r3] = r4
            int r3 = r3 + 1
            if (r3 != r8) goto L20
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L20:
            r4 = r0[r7]
            r5 = r3
            r3 = r6
            r6 = r4
            r4 = r5
        L26:
            int r6 = -r6
            int r7 = r7 + 1
            int r3 = r3 + r6
            int r6 = r3 + (-4)
            r3 = r4
            goto L11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.GoogleApiActivity.c(byte, int, byte, java.lang.Object[]):void");
    }

    public static Intent zaa(@NonNull Context context, @NonNull PendingIntent pendingIntent, int i, boolean z) {
        Intent intent = new Intent(context, (Class<?>) GoogleApiActivity.class);
        intent.putExtra(CloudMessagingReceiver.IntentKeys.PENDING_INTENT, pendingIntent);
        intent.putExtra("failing_client_id", i);
        intent.putExtra("notify_manager", z);
        return intent;
    }

    private final void zab() {
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            SentryLogcatAdapter.e("GoogleApiActivity", "Activity started without extras");
            finish();
            return;
        }
        PendingIntent pendingIntent = (PendingIntent) extras.get(CloudMessagingReceiver.IntentKeys.PENDING_INTENT);
        Integer num = (Integer) extras.get("error_code");
        if (pendingIntent == null && num == null) {
            SentryLogcatAdapter.e("GoogleApiActivity", "Activity started without resolution");
            finish();
            return;
        }
        if (pendingIntent == null) {
            GoogleApiAvailability.getInstance().showErrorDialogFragment(this, ((Integer) Preconditions.checkNotNull(num)).intValue(), 2, this);
            this.zaa = 1;
            return;
        }
        try {
            startIntentSenderForResult(pendingIntent.getIntentSender(), 1, null, 0, 0, 0);
            this.zaa = 1;
        } catch (ActivityNotFoundException e) {
            if (extras.getBoolean("notify_manager", true)) {
                GoogleApiManager.zak(this).zax(new ConnectionResult(22, null), getIntent().getIntExtra("failing_client_id", -1));
            } else {
                String strConcat = "Activity not found while launching " + pendingIntent.toString() + ".";
                if (Build.FINGERPRINT.contains("generic")) {
                    strConcat = strConcat.concat(" This may occur when resolving Google Play services connection issues on emulators with Google APIs but not Google Play Store.");
                }
                SentryLogcatAdapter.e("GoogleApiActivity", strConcat, e);
            }
            this.zaa = 1;
            finish();
        } catch (IntentSender.SendIntentException e2) {
            SentryLogcatAdapter.e("GoogleApiActivity", "Failed to launch pendingIntent", e2);
            finish();
        }
    }

    @Override // android.app.Activity
    protected final void onActivityResult(int i, int i2, @NonNull Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1) {
            boolean booleanExtra = getIntent().getBooleanExtra("notify_manager", true);
            this.zaa = 0;
            setResult(i2, intent);
            if (booleanExtra) {
                GoogleApiManager googleApiManagerZak = GoogleApiManager.zak(this);
                if (i2 == -1) {
                    googleApiManagerZak.zay();
                } else if (i2 == 0) {
                    googleApiManagerZak.zax(new ConnectionResult(13, null), getIntent().getIntExtra("failing_client_id", -1));
                }
            }
        } else if (i == 2) {
            this.zaa = 0;
            setResult(i2, intent);
        }
        finish();
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(@NonNull DialogInterface dialogInterface) {
        this.zaa = 0;
        setResult(0);
        finish();
    }

    @Override // android.app.Activity
    protected final void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.zaa = bundle.getInt("resolution");
        }
        if (this.zaa != 1) {
            zab();
        }
    }

    @Override // android.app.Activity
    protected final void onSaveInstanceState(@NonNull Bundle bundle) {
        bundle.putInt("resolution", this.zaa);
        super.onSaveInstanceState(bundle);
    }

    private static void a(int i, char[] cArr, byte b, Object[] objArr) throws Throwable {
        int i2;
        int length;
        char[] cArr2;
        int i3;
        char c = 2;
        int i4 = 2 % 2;
        extraCallback extracallback = new extraCallback();
        char[] cArr3 = ArtificialStackFrames;
        int i5 = -1819279892;
        if (cArr3 != null) {
            int i6 = $11 + 63;
            $10 = i6 % 128;
            if (i6 % 2 != 0) {
                length = cArr3.length;
                cArr2 = new char[length];
                i3 = 1;
            } else {
                length = cArr3.length;
                cArr2 = new char[length];
                i3 = 0;
            }
            while (i3 < length) {
                try {
                    Object[] objArr2 = {Integer.valueOf(cArr3[i3])};
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(i5);
                    if (objAccessartificialFrame == null) {
                        int absoluteGravity = Gravity.getAbsoluteGravity(0, 0) + 15;
                        char c2 = (char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 20487);
                        int capsMode = TextUtils.getCapsMode("", 0, 0) + 2148;
                        byte b2 = (byte) ($$c[c] + 1);
                        byte b3 = b2;
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(absoluteGravity, c2, capsMode, 216710116, false, $$g(b2, b3, b3), new Class[]{Integer.TYPE});
                    }
                    cArr2[i3] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                    i3++;
                    c = 2;
                    i5 = -1819279892;
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
            cArr3 = cArr2;
        }
        Object[] objArr3 = {Integer.valueOf(coroutineCreation)};
        Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1819279892);
        if (objAccessartificialFrame2 == null) {
            int gidForName = Process.getGidForName("") + 16;
            char cBlue = (char) (Color.blue(0) + 20488);
            int tapTimeout = (ViewConfiguration.getTapTimeout() >> 16) + 2148;
            byte b4 = (byte) ($$c[2] + 1);
            byte b5 = b4;
            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(gidForName, cBlue, tapTimeout, 216710116, false, $$g(b4, b5, b5), new Class[]{Integer.TYPE});
        }
        char cCharValue = ((Character) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).charValue();
        char[] cArr4 = new char[i];
        if (i % 2 != 0) {
            int i7 = $10 + 61;
            $11 = i7 % 128;
            if (i7 % 2 == 0) {
                i2 = i + AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
                cArr4[i2] = (char) (cArr[i2] * b);
            } else {
                i2 = i - 1;
                cArr4[i2] = (char) (cArr[i2] - b);
            }
        } else {
            i2 = i;
        }
        if (i2 > 1) {
            extracallback.a = 0;
            while (extracallback.a < i2) {
                extracallback.createBrowser = cArr[extracallback.a];
                extracallback.c = cArr[extracallback.a + 1];
                if (extracallback.createBrowser == extracallback.c) {
                    cArr4[extracallback.a] = (char) (extracallback.createBrowser - b);
                    cArr4[extracallback.a + 1] = (char) (extracallback.c - b);
                } else {
                    Object[] objArr4 = {extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback};
                    Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1894223152);
                    if (objAccessartificialFrame3 == null) {
                        int mirror = '^' - AndroidCharacter.getMirror('0');
                        char cArgb = (char) (58859 - Color.argb(0, 0, 0, 0));
                        int modifierMetaStateMask = 2463 - ((byte) KeyEvent.getModifierMetaStateMask());
                        byte b6 = (byte) ($$c[2] + 1);
                        byte b7 = (byte) (b6 + 5);
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(mirror, cArgb, modifierMetaStateMask, 276640984, false, $$g(b6, b7, (byte) (b7 - 5)), new Class[]{Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class});
                    }
                    if (((Integer) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).intValue() == extracallback.g) {
                        Object[] objArr5 = {extracallback, extracallback, Integer.valueOf(cCharValue), Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), Integer.valueOf(cCharValue), extracallback, Integer.valueOf(cCharValue), extracallback};
                        Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1361113423);
                        if (objAccessartificialFrame4 == null) {
                            int maxKeyCode = (KeyEvent.getMaxKeyCode() >> 16) + 24;
                            char cIndexOf = (char) TextUtils.indexOf("", "", 0);
                            int longPressTimeout = 792 - (ViewConfiguration.getLongPressTimeout() >> 16);
                            byte b8 = $$c[2];
                            byte b9 = (byte) (b8 + 1);
                            objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(maxKeyCode, cIndexOf, longPressTimeout, -834291897, false, $$g(b9, (byte) (b9 | 8), (byte) (b8 + 1)), new Class[]{Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Integer.TYPE, Object.class});
                        }
                        int iIntValue = ((Integer) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).intValue();
                        int i8 = (extracallback.d * cCharValue) + extracallback.g;
                        cArr4[extracallback.a] = cArr3[iIntValue];
                        cArr4[extracallback.a + 1] = cArr3[i8];
                    } else if (extracallback.b == extracallback.d) {
                        extracallback.j = ((extracallback.j + cCharValue) - 1) % cCharValue;
                        extracallback.g = ((extracallback.g + cCharValue) - 1) % cCharValue;
                        int i9 = (extracallback.b * cCharValue) + extracallback.j;
                        int i10 = (extracallback.d * cCharValue) + extracallback.g;
                        cArr4[extracallback.a] = cArr3[i9];
                        cArr4[extracallback.a + 1] = cArr3[i10];
                    } else {
                        int i11 = (extracallback.b * cCharValue) + extracallback.g;
                        int i12 = (extracallback.d * cCharValue) + extracallback.j;
                        cArr4[extracallback.a] = cArr3[i11];
                        cArr4[extracallback.a + 1] = cArr3[i12];
                    }
                }
                extracallback.a += 2;
            }
        }
        int i13 = $11 + 71;
        $10 = i13 % 128;
        int i14 = i13 % 2;
        for (int i15 = 0; i15 < i; i15++) {
            cArr4[i15] = (char) (cArr4[i15] ^ 13722);
        }
        String str = new String(cArr4);
        int i16 = $11 + 113;
        $10 = i16 % 128;
        if (i16 % 2 != 0) {
            Object obj = null;
            obj.hashCode();
            throw null;
        }
        objArr[0] = str;
    }

    @Override // android.app.Activity
    public void onStart() throws Throwable {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        int i;
        Object[] objArr5;
        Object[] objArr6;
        Object[] objArr7;
        char c;
        Object[] objArrAccessartificialFrame$78cbbd35;
        int i2 = 2 % 2;
        Object[] objArr8 = new Object[1];
        a(21 - ImageFormat.getBitsPerPixel(0), new char[]{30, CoreConstants.COMMA_CHAR, 19, 28, ' ', 15, 17, '#', 31, 1, CoreConstants.SINGLE_QUOTE_CHAR, '\n', Typography.amp, 1, 26, 7, 25, '0', '$', '\"', '.', CoreConstants.LEFT_PARENTHESIS_CHAR}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 24), objArr8);
        String str = (String) objArr8[0];
        Object[] objArr9 = new Object[1];
        a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(1) - 34, new char[]{CharUtils.CR, CoreConstants.LEFT_PARENTHESIS_CHAR, 21, 2, 5, '\n', 21, '#', '\t', 26, '#', 27, 20, 25, 13942}, (byte) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 118), objArr9);
        String str2 = (String) objArr9[0];
        Object[] objArr10 = new Object[1];
        a(15 - TextUtils.indexOf((CharSequence) "", '0', 0), new char[]{16, 26, '\t', 24, CoreConstants.SINGLE_QUOTE_CHAR, '#', 30, CoreConstants.COMMA_CHAR, 31, CoreConstants.DASH_CHAR, '\b', CoreConstants.SINGLE_QUOTE_CHAR, 0, 24, CharUtils.CR, 26}, (byte) (TextUtils.indexOf((CharSequence) "", '0', 0) + 43), objArr10);
        String str3 = (String) objArr10[0];
        Object[] objArr11 = new Object[1];
        a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) - 20, new char[]{19, 15, '\t', CoreConstants.LEFT_PARENTHESIS_CHAR, 25, 14, 22, '#', 27, 24, '\n', 24, '+', ' ', 19, 7}, (byte) (TextUtils.getOffsetAfter("", 0) + 91), objArr11);
        String str4 = (String) objArr11[0];
        Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1283093189);
        if (objAccessartificialFrame == null) {
            int offsetAfter = 30 - TextUtils.getOffsetAfter("", 0);
            char c2 = (char) ((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 49361);
            int i3 = 685 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
            byte[] bArr = $$a;
            Object[] objArr12 = new Object[1];
            b((byte) 105, bArr[19], bArr[76], objArr12);
            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(offsetAfter, c2, i3, 752929587, false, (String) objArr12[0], null);
        }
        long j = ((Field) objAccessartificialFrame).getLong(null);
        if (j == -1 || j + 1902 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr13 = new Object[1];
                a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(0) - 11, new char[]{30, CoreConstants.COMMA_CHAR, 19, 28, ' ', 15, 17, '#', 21, 2, 3, '#', '\f', '*', 25, 14, 11, 17, 22, '#', '\n', 15, CoreConstants.LEFT_PARENTHESIS_CHAR, 19, 21, 16}, (byte) (34 - KeyEvent.normalizeMetaState(0)), objArr13);
                Class<?> cls = Class.forName((String) objArr13[0]);
                Object[] objArr14 = new Object[1];
                a((CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + 18, new char[]{'.', 5, 13882, 13882, '\t', CoreConstants.LEFT_PARENTHESIS_CHAR, 28, 14, 13884, 13884, CoreConstants.SINGLE_QUOTE_CHAR, 20, CoreConstants.COMMA_CHAR, 26, 25, 14, 30, '$'}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 47), objArr14);
                baseContext = (Context) cls.getMethod((String) objArr14[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                int i4 = artificialFrame + b.f40o;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i4 % 128;
                if (i4 % 2 != 0) {
                    boolean z = baseContext instanceof ContextWrapper;
                    throw null;
                }
                baseContext = ((baseContext instanceof ContextWrapper) && ((ContextWrapper) baseContext).getBaseContext() == null) ? null : baseContext.getApplicationContext();
            }
            try {
                Object[] objArr15 = {baseContext, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 124784312};
                byte[] bArr2 = $$d;
                Object[] objArr16 = new Object[1];
                c((byte) (bArr2[110] + 1), (short) 676, (byte) (bArr2[135] - 1), objArr16);
                Class<?> cls2 = Class.forName((String) objArr16[0]);
                Object[] objArr17 = new Object[1];
                c(bArr2[166], (short) 629, (byte) (-bArr2[82]), objArr17);
                Object[] objArr18 = (Object[]) cls2.getMethod((String) objArr17[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr15);
                if (baseContext != null) {
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-326560385);
                    if (objAccessartificialFrame2 == null) {
                        int absoluteGravity = Gravity.getAbsoluteGravity(0, 0) + 30;
                        char c3 = (char) (49362 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)));
                        int i5 = 684 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1));
                        byte[] bArr3 = $$a;
                        Object[] objArr19 = new Object[1];
                        b((byte) 90, bArr3[4], bArr3[76], objArr19);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(absoluteGravity, c3, i5, 1944867703, false, (String) objArr19[0], null);
                    }
                    ((Field) objAccessartificialFrame2).set(null, objArr18);
                    try {
                        Long lValueOf = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                        Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1283093189);
                        if (objAccessartificialFrame3 == null) {
                            int i6 = 30 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                            char c4 = (char) (49363 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)));
                            int offsetAfter2 = 684 - TextUtils.getOffsetAfter("", 0);
                            byte[] bArr4 = $$a;
                            Object[] objArr20 = new Object[1];
                            b((byte) 105, bArr4[19], bArr4[76], objArr20);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(i6, c4, offsetAfter2, 752929587, false, (String) objArr20[0], null);
                        }
                        ((Field) objAccessartificialFrame3).set(null, lValueOf);
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
            int i7 = getARTIFICIAL_FRAME_PACKAGE_NAME + 39;
            artificialFrame = i7 % 128;
            int i8 = i7 % 2;
            Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-326560385);
            if (objAccessartificialFrame4 == null) {
                int iResolveSize = View.resolveSize(0, 0) + 30;
                char cKeyCodeFromString = (char) (49362 - KeyEvent.keyCodeFromString(""));
                int i9 = (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 683;
                byte[] bArr5 = $$a;
                Object[] objArr21 = new Object[1];
                b((byte) 90, bArr5[4], bArr5[76], objArr21);
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(iResolveSize, cKeyCodeFromString, i9, 1944867703, false, (String) objArr21[0], null);
            }
            Object[] objArr22 = (Object[]) ((Field) objAccessartificialFrame4).get(null);
            objArr = new Object[]{new int[]{((int[]) objArr22[0])[0]}, new int[]{((int[]) objArr22[1])[0]}, new int[1], (String) objArr22[3]};
            int iElapsedRealtime = (int) SystemClock.elapsedRealtime();
            int i10 = ~iElapsedRealtime;
            int i11 = 1502353939 + (((~((-8793384) | iElapsedRealtime)) | (~(i10 | 411447287)) | (-969830392)) * 717) + (((~(iElapsedRealtime | 411447287)) | (~((-8793384) | i10)) | (-969830392)) * 717) + 124784312;
            int i12 = (i11 << 13) ^ i11;
            int i13 = i12 ^ (i12 >>> 17);
            ((int[]) objArr[2])[0] = i13 ^ (i13 << 5);
        }
        int i14 = ((int[]) objArr[1])[0];
        int i15 = ((int[]) objArr[0])[0];
        if (i15 == i14) {
            int i16 = ((int[]) objArr[2])[0];
            Object[] objArr23 = {new int[]{((int[]) objArr[0])[0]}, new int[]{((int[]) objArr[1])[0]}, new int[1], (String) objArr[3]};
            int i17 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().densityDpi;
            int i18 = i16 + 1718044170 + (((~((~i17) | (-538214413))) | (~(976525982 | i17))) * (-302)) + ((~((-538214413) | i17)) * (-604)) + (((~(i17 | 438311570)) | 436213778) * 302);
            int i19 = (i18 << 13) ^ i18;
            int i20 = i19 ^ (i19 >>> 17);
            ((int[]) objArr23[2])[0] = i20 ^ (i20 << 5);
        } else {
            try {
                Object[] objArr24 = {Long.valueOf(((long) (i14 ^ i15)) ^ (((long) 1304839507) << 32)), Long.valueOf(1304839511)};
                byte[] bArr6 = $$d;
                Object[] objArr25 = new Object[1];
                c((byte) (-bArr6[253]), (short) TypedValues.MotionType.TYPE_QUANTIZE_MOTIONSTEPS, (byte) (-bArr6[45]), objArr25);
                Class<?> cls3 = Class.forName((String) objArr25[0]);
                byte b = bArr6[29];
                Object[] objArr26 = new Object[1];
                c(b, (short) (b | 544), (byte) 89, objArr26);
                cls3.getMethod((String) objArr26[0], Long.TYPE, Long.TYPE).invoke(null, objArr24);
                int i21 = ((int[]) objArr[2])[0];
                Object[] objArr27 = {new int[]{((int[]) objArr[0])[0]}, new int[]{((int[]) objArr[1])[0]}, new int[1], (String) objArr[3]};
                int iIdentityHashCode = System.identityHashCode(this);
                int i22 = i21 + (-1695882534) + (((~((~iIdentityHashCode) | (-603346699))) | 39208448) * 446) + (((~(iIdentityHashCode | (-564138251))) | 336068628) * 446) + 307098624;
                int i23 = (i22 << 13) ^ i22;
                int i24 = i23 ^ (i23 >>> 17);
                ((int[]) objArr27[2])[0] = i24 ^ (i24 << 5);
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 == null) {
                    throw th2;
                }
                throw cause2;
            }
        }
        Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-2127922582);
        if (objAccessartificialFrame5 == null) {
            int packedPositionGroup = ExpandableListView.getPackedPositionGroup(0L) + 30;
            char cNormalizeMetaState = (char) (KeyEvent.normalizeMetaState(0) + 49362);
            int longPressTimeout = (ViewConfiguration.getLongPressTimeout() >> 16) + 684;
            byte[] bArr7 = $$a;
            Object[] objArr28 = new Object[1];
            b((byte) 75, bArr7[19], (byte) (-bArr7[17]), objArr28);
            objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(packedPositionGroup, cNormalizeMetaState, longPressTimeout, 508509282, false, (String) objArr28[0], null);
        }
        long j2 = ((Field) objAccessartificialFrame5).getLong(null);
        if (j2 == -1 || j2 + 1972 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Context baseContext2 = getBaseContext();
            if (baseContext2 == null) {
                Object[] objArr29 = new Object[1];
                a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 9, new char[]{30, CoreConstants.COMMA_CHAR, 19, 28, ' ', 15, 17, '#', 21, 2, 3, '#', '\f', '*', 25, 14, 11, 17, 22, '#', '\n', 15, CoreConstants.LEFT_PARENTHESIS_CHAR, 19, 21, 16}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) - 15), objArr29);
                Class<?> cls4 = Class.forName((String) objArr29[0]);
                Object[] objArr30 = new Object[1];
                a(18 - Color.argb(0, 0, 0, 0), new char[]{'.', 5, 13882, 13882, '\t', CoreConstants.LEFT_PARENTHESIS_CHAR, 28, 14, 13884, 13884, CoreConstants.SINGLE_QUOTE_CHAR, 20, CoreConstants.COMMA_CHAR, 26, 25, 14, 30, '$'}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) + 46), objArr30);
                baseContext2 = (Context) cls4.getMethod((String) objArr30[0], new Class[0]).invoke(null, null);
            }
            if (baseContext2 != null) {
                baseContext2 = ((baseContext2 instanceof ContextWrapper) && ((ContextWrapper) baseContext2).getBaseContext() == null) ? null : baseContext2.getApplicationContext();
            }
            int iIntValue = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
            int i25 = getARTIFICIAL_FRAME_PACKAGE_NAME + 45;
            artificialFrame = i25 % 128;
            int i26 = i25 % 2;
            Object[] objArr31 = {baseContext2, Integer.valueOf(iIntValue), 851383254};
            byte[] bArr8 = $$d;
            Object[] objArr32 = new Object[1];
            c((byte) (-bArr8[253]), (short) 542, bArr8[241], objArr32);
            Class<?> cls5 = Class.forName((String) objArr32[0]);
            Object[] objArr33 = new Object[1];
            c(bArr8[5], (short) 483, bArr8[12], objArr33);
            Object[] objArr34 = (Object[]) cls5.getMethod((String) objArr33[0], Context.class, Integer.TYPE, Integer.TYPE).invoke(null, objArr31);
            if (baseContext2 != null) {
                Object objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(777251007);
                if (objAccessartificialFrame6 == null) {
                    int keyRepeatDelay = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 30;
                    char bitsPerPixel = (char) (49361 - ImageFormat.getBitsPerPixel(0));
                    int absoluteGravity2 = 684 - Gravity.getAbsoluteGravity(0, 0);
                    byte[] bArr9 = $$a;
                    Object[] objArr35 = new Object[1];
                    b((byte) (-bArr9[1]), bArr9[76], (byte) (bArr9[12] - 1), objArr35);
                    objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(keyRepeatDelay, bitsPerPixel, absoluteGravity2, -1321816393, false, (String) objArr35[0], null);
                }
                ((Field) objAccessartificialFrame6).set(null, objArr34);
                try {
                    Long lValueOf2 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-2127922582);
                    if (objAccessartificialFrame7 == null) {
                        int i27 = (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 29;
                        char cRgb = (char) ((-16727854) - Color.rgb(0, 0, 0));
                        int iCombineMeasuredStates = 684 - View.combineMeasuredStates(0, 0);
                        byte[] bArr10 = $$a;
                        Object[] objArr36 = new Object[1];
                        b((byte) 75, bArr10[19], (byte) (-bArr10[17]), objArr36);
                        objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(i27, cRgb, iCombineMeasuredStates, 508509282, false, (String) objArr36[0], null);
                    }
                    ((Field) objAccessartificialFrame7).set(null, lValueOf2);
                } catch (Exception unused2) {
                    throw new RuntimeException();
                }
            } else {
                objArr34 = objArr34;
            }
            objArr2 = objArr34;
        } else {
            Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(777251007);
            if (objAccessartificialFrame8 == null) {
                int keyRepeatTimeout = (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 30;
                char absoluteGravity3 = (char) (Gravity.getAbsoluteGravity(0, 0) + 49362);
                int iIndexOf = TextUtils.indexOf("", "", 0) + 684;
                byte[] bArr11 = $$a;
                Object[] objArr37 = new Object[1];
                b((byte) (-bArr11[1]), bArr11[76], (byte) (bArr11[12] - 1), objArr37);
                objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(keyRepeatTimeout, absoluteGravity3, iIndexOf, -1321816393, false, (String) objArr37[0], null);
            }
            Object[] objArr38 = (Object[]) ((Field) objAccessartificialFrame8).get(null);
            objArr2 = new Object[]{new int[]{((int[]) objArr38[0])[0]}, new int[]{((int[]) objArr38[1])[0]}, new int[1], (String) objArr38[3]};
            int i28 = ~(Settings.System.getInt(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getContentResolver(), "screen_brightness", -1) | 620898105);
            int i29 = (((-137179338) + (((-357725670) | i28) * (-220))) + ((i28 | (-894597118)) * 220)) - 180179362;
            int i30 = (i29 << 13) ^ i29;
            int i31 = i30 ^ (i30 >>> 17);
            ((int[]) objArr2[2])[0] = i31 ^ (i31 << 5);
        }
        int i32 = ((int[]) objArr2[1])[0];
        int i33 = ((int[]) objArr2[0])[0];
        if (i33 == i32) {
            int i34 = ((int[]) objArr2[2])[0];
            Object[] objArr39 = {new int[]{((int[]) objArr2[0])[0]}, new int[]{((int[]) objArr2[1])[0]}, new int[1], (String) objArr2[3]};
            int i35 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().smallestScreenWidthDp;
            int i36 = i34 + ((((-1025999456) + (((-10504283) | i35) * (-381))) + (((~((~i35) | 526136228)) | (-94657247)) * 381)) - 292835854);
            int i37 = (i36 << 13) ^ i36;
            int i38 = i37 ^ (i37 >>> 17);
            ((int[]) objArr39[2])[0] = i38 ^ (i38 << 5);
        } else {
            Object[] objArr40 = {Long.valueOf((((long) (-1418786876)) << 32) ^ ((long) (i32 ^ i33))), Long.valueOf(-1418787388)};
            byte[] bArr12 = $$d;
            Object[] objArr41 = new Object[1];
            c((byte) (-bArr12[253]), (short) TypedValues.MotionType.TYPE_QUANTIZE_MOTIONSTEPS, (byte) (-bArr12[45]), objArr41);
            Class<?> cls6 = Class.forName((String) objArr41[0]);
            byte b2 = bArr12[29];
            Object[] objArr42 = new Object[1];
            c(b2, (short) (b2 | 544), (byte) 89, objArr42);
            cls6.getMethod((String) objArr42[0], Long.TYPE, Long.TYPE).invoke(null, objArr40);
            int i39 = ((int[]) objArr2[2])[0];
            Object[] objArr43 = {new int[]{((int[]) objArr2[0])[0]}, new int[]{((int[]) objArr2[1])[0]}, new int[1], (String) objArr2[3]};
            int ringerMode = ((AudioManager) ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getSystemService("audio")).getRingerMode();
            int i40 = ~ringerMode;
            int i41 = i39 + (-1682668618) + (((~((-258496879) | i40)) | (-720126897) | (~(258496878 | ringerMode))) * (-564)) + ((~(ringerMode | (-545522321))) * 1128) + (((~((-720126897) | i40)) | (-804019199)) * 564);
            int i42 = (i41 << 13) ^ i41;
            int i43 = i42 ^ (i42 >>> 17);
            ((int[]) objArr43[2])[0] = i43 ^ (i43 << 5);
        }
        Object objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(-1168947751);
        if (objAccessartificialFrame9 == null) {
            int iIndexOf2 = 36 - TextUtils.indexOf("", "", 0);
            char packedPositionGroup2 = (char) ExpandableListView.getPackedPositionGroup(0L);
            int i44 = 540 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
            byte b3 = $$a[12];
            Object[] objArr44 = new Object[1];
            b((byte) 56, (byte) (b3 - 1), b3, objArr44);
            objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(iIndexOf2, packedPositionGroup2, i44, 624296913, false, (String) objArr44[0], null);
        }
        long j3 = ((Field) objAccessartificialFrame9).getLong(null);
        if (j3 == -1 || j3 + 2038 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            try {
                Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-1717965552);
                if (objAccessartificialFrame10 == null) {
                    objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(21 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), (char) ((ViewConfiguration.getDoubleTapTimeout() >> 16) + 39516), 982 - Drawable.resolveOpacity(0, 0), 117222168, false, null, new Class[0]);
                }
                Object[] objArr45 = {null, ((Constructor) objAccessartificialFrame10).newInstance(null), 1472693274, 0};
                Object objAccessartificialFrame11 = ArtificialStackFrames.accessartificialFrame(-501205803);
                if (objAccessartificialFrame11 == null) {
                    int mirror = 'T' - AndroidCharacter.getMirror('0');
                    char cKeyCodeFromString2 = (char) KeyEvent.keyCodeFromString("");
                    int iNormalizeMetaState = 540 - KeyEvent.normalizeMetaState(0);
                    byte b4 = (byte) 40;
                    Object[] objArr46 = new Object[1];
                    b(b4, (byte) (b4 | 7), $$a[107], objArr46);
                    objAccessartificialFrame11 = ArtificialStackFrames.coroutineCreation(mirror, cKeyCodeFromString2, iNormalizeMetaState, 2101703389, false, (String) objArr46[0], new Class[]{(Class) ArtificialStackFrames.coroutineCreation(54 - View.getDefaultSize(0, 0), (char) (833 - TextUtils.getCapsMode("", 0, 0)), (ViewConfiguration.getDoubleTapTimeout() >> 16) + 576), (Class) ArtificialStackFrames.coroutineCreation(View.resolveSize(0, 0) + 54, (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 1), TextUtils.indexOf("", "", 0, 0) + 630), Integer.TYPE, Integer.TYPE});
                }
                Object[] objArr47 = (Object[]) ((Method) objAccessartificialFrame11).invoke(null, objArr45);
                Object objAccessartificialFrame12 = ArtificialStackFrames.accessartificialFrame(-1339222025);
                if (objAccessartificialFrame12 == null) {
                    int trimmedLength = TextUtils.getTrimmedLength("") + 36;
                    char c5 = (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                    int iNormalizeMetaState2 = 540 - KeyEvent.normalizeMetaState(0);
                    byte b5 = (byte) ($$b << 2);
                    byte b6 = $$a[12];
                    Object[] objArr48 = new Object[1];
                    b(b5, (byte) (b6 - 1), b6, objArr48);
                    objAccessartificialFrame12 = ArtificialStackFrames.coroutineCreation(trimmedLength, c5, iNormalizeMetaState2, 793268735, false, (String) objArr48[0], null);
                }
                ((Field) objAccessartificialFrame12).set(null, objArr47);
                try {
                    Long lValueOf3 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame13 = ArtificialStackFrames.accessartificialFrame(-1168947751);
                    if (objAccessartificialFrame13 == null) {
                        int packedPositionType = ExpandableListView.getPackedPositionType(0L) + 36;
                        char gidForName = (char) (Process.getGidForName("") + 1);
                        int i45 = (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 539;
                        byte b7 = $$a[12];
                        Object[] objArr49 = new Object[1];
                        b((byte) 56, (byte) (b7 - 1), b7, objArr49);
                        objAccessartificialFrame13 = ArtificialStackFrames.coroutineCreation(packedPositionType, gidForName, i45, 624296913, false, (String) objArr49[0], null);
                    }
                    ((Field) objAccessartificialFrame13).set(null, lValueOf3);
                    objArr3 = objArr47;
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
            Object objAccessartificialFrame14 = ArtificialStackFrames.accessartificialFrame(-1339222025);
            if (objAccessartificialFrame14 == null) {
                int i46 = (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 35;
                char cArgb = (char) Color.argb(0, 0, 0, 0);
                int i47 = 541 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1));
                byte b8 = (byte) ($$b << 2);
                byte b9 = $$a[12];
                Object[] objArr50 = new Object[1];
                b(b8, (byte) (b9 - 1), b9, objArr50);
                objAccessartificialFrame14 = ArtificialStackFrames.coroutineCreation(i46, cArgb, i47, 793268735, false, (String) objArr50[0], null);
            }
            Object[] objArr51 = (Object[]) ((Field) objAccessartificialFrame14).get(null);
            objArr3 = new Object[]{new int[1], new int[1], new int[1]};
            int i48 = ((int[]) objArr51[2])[0];
            int i49 = ((int[]) objArr51[1])[0];
            ((int[]) objArr3[2])[0] = i48;
            ((int[]) objArr3[1])[0] = i49;
            int layoutDirection = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().getLayoutDirection();
            int i50 = 1581075900 + (((~(layoutDirection | 781513716)) | (-570108034)) * (-465)) + ((781513716 | (~((-570108034) | layoutDirection))) * 930) + ((layoutDirection | (-23791618)) * 465) + 1472693274;
            int i51 = (i50 << 13) ^ i50;
            int i52 = i51 ^ (i51 >>> 17);
            ((int[]) objArr3[0])[0] = i52 ^ (i52 << 5);
        }
        Object obj = objArr3[1];
        int i53 = ((int[]) obj)[0];
        Object obj2 = objArr3[2];
        int i54 = ((int[]) obj2)[0];
        if (i54 == i53) {
            Object[] objArr52 = {new int[1], new int[1], new int[1]};
            int i55 = ((int[]) objArr3[0])[0];
            int i56 = ((int[]) obj2)[0];
            int i57 = ((int[]) obj)[0];
            ((int[]) objArr52[2])[0] = i56;
            ((int[]) objArr52[1])[0] = i57;
            int startElapsedRealtime = (int) Process.getStartElapsedRealtime();
            int i58 = ~((-1260754046) | startElapsedRealtime);
            int i59 = ~startElapsedRealtime;
            int i60 = i55 + (-415893661) + ((i58 | (~(1332713469 | i59))) * (-406)) + ((~((-1241845766) | i59)) * (-406)) + (((~(startElapsedRealtime | (-90867705))) | (~(1260754045 | i59))) * 406);
            int i61 = (i60 << 13) ^ i60;
            int i62 = i61 ^ (i61 >>> 17);
            ((int[]) objArr52[0])[0] = i62 ^ (i62 << 5);
        } else {
            Object[] objArr53 = {Long.valueOf((((long) 899362477) << 32) ^ ((long) (i53 ^ i54))), Long.valueOf(899366573)};
            byte[] bArr13 = $$d;
            Object[] objArr54 = new Object[1];
            c((byte) (-bArr13[253]), (short) 463, bArr13[81], objArr54);
            Class<?> cls7 = Class.forName((String) objArr54[0]);
            byte b10 = bArr13[29];
            Object[] objArr55 = new Object[1];
            c(b10, (short) (b10 | 544), (byte) 89, objArr55);
            cls7.getMethod((String) objArr55[0], Long.TYPE, Long.TYPE).invoke(null, objArr53);
            Object[] objArr56 = {new int[1], new int[1], new int[1]};
            int i63 = ((int[]) objArr3[0])[0];
            int i64 = ((int[]) objArr3[2])[0];
            int i65 = ((int[]) objArr3[1])[0];
            ((int[]) objArr56[2])[0] = i64;
            ((int[]) objArr56[1])[0] = i65;
            int iElapsedRealtime2 = (int) SystemClock.elapsedRealtime();
            int i66 = ~(416327671 | iElapsedRealtime2);
            int i67 = i63 + 175914341 + ((657412104 | i66) * (-814)) + ((i66 | (~((~iElapsedRealtime2) | (-935294079))) | 138445697) * 407) + (((~(iElapsedRealtime2 | 935294078)) | (~((-416327672) | iElapsedRealtime2)) | 138445697) * 407);
            int i68 = (i67 << 13) ^ i67;
            int i69 = i68 ^ (i68 >>> 17);
            ((int[]) objArr56[0])[0] = i69 ^ (i69 << 5);
        }
        Object objAccessartificialFrame15 = ArtificialStackFrames.accessartificialFrame(1745676544);
        if (objAccessartificialFrame15 == null) {
            int iKeyCodeFromString = 17 - KeyEvent.keyCodeFromString("");
            char c6 = (char) (1 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)));
            int iLastIndexOf = TextUtils.lastIndexOf("", '0', 0) + 748;
            byte b11 = $$a[12];
            Object[] objArr57 = new Object[1];
            b((byte) 56, (byte) (b11 - 1), b11, objArr57);
            objAccessartificialFrame15 = ArtificialStackFrames.coroutineCreation(iKeyCodeFromString, c6, iLastIndexOf, -144068856, false, (String) objArr57[0], null);
        }
        long j4 = ((Field) objAccessartificialFrame15).getLong(null);
        if (j4 == -1 || j4 + 4611686018427387826L < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Context baseContext3 = getBaseContext();
            if (baseContext3 == null) {
                int i70 = artificialFrame + 37;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i70 % 128;
                int i71 = i70 % 2;
                Object[] objArr58 = new Object[1];
                a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 22, new char[]{30, CoreConstants.COMMA_CHAR, 19, 28, ' ', 15, 17, '#', 21, 2, 3, '#', '\f', '*', 25, 14, 11, 17, 22, '#', '\n', 15, CoreConstants.LEFT_PARENTHESIS_CHAR, 19, 21, 16}, (byte) (34 - TextUtils.getOffsetBefore("", 0)), objArr58);
                Class<?> cls8 = Class.forName((String) objArr58[0]);
                Object[] objArr59 = new Object[1];
                a(KeyEvent.keyCodeFromString("") + 18, new char[]{'.', 5, 13882, 13882, '\t', CoreConstants.LEFT_PARENTHESIS_CHAR, 28, 14, 13884, 13884, CoreConstants.SINGLE_QUOTE_CHAR, 20, CoreConstants.COMMA_CHAR, 26, 25, 14, 30, '$'}, (byte) (82 - View.resolveSize(0, 0)), objArr59);
                baseContext3 = (Context) cls8.getMethod((String) objArr59[0], new Class[0]).invoke(null, null);
            }
            if (baseContext3 != null) {
                baseContext3 = ((baseContext3 instanceof ContextWrapper) && ((ContextWrapper) baseContext3).getBaseContext() == null) ? null : baseContext3.getApplicationContext();
            }
            Object[] objArr60 = {baseContext3, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, -1662214226};
            byte[] bArr14 = $$d;
            Object[] objArr61 = new Object[1];
            c((byte) (bArr14[110] + 1), (short) 429, bArr14[29], objArr61);
            Class<?> cls9 = Class.forName((String) objArr61[0]);
            Object[] objArr62 = new Object[1];
            c(bArr14[166], (short) 629, (byte) (-bArr14[82]), objArr62);
            objArr4 = (Object[]) cls9.getMethod((String) objArr62[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr60);
            Object objAccessartificialFrame16 = ArtificialStackFrames.accessartificialFrame(1575402270);
            if (objAccessartificialFrame16 == null) {
                int keyRepeatTimeout2 = 17 - (ViewConfiguration.getKeyRepeatTimeout() >> 16);
                char defaultSize = (char) View.getDefaultSize(0, 0);
                int iIndexOf3 = TextUtils.indexOf((CharSequence) "", '0', 0) + 748;
                byte b12 = (byte) ($$b << 2);
                byte b13 = $$a[12];
                Object[] objArr63 = new Object[1];
                b(b12, (byte) (b13 - 1), b13, objArr63);
                objAccessartificialFrame16 = ArtificialStackFrames.coroutineCreation(keyRepeatTimeout2, defaultSize, iIndexOf3, -1031537386, false, (String) objArr63[0], null);
            }
            ((Field) objAccessartificialFrame16).set(null, objArr4);
            try {
                Long lValueOf4 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame17 = ArtificialStackFrames.accessartificialFrame(1745676544);
                if (objAccessartificialFrame17 == null) {
                    int iMyPid = (Process.myPid() >> 22) + 17;
                    char scrollBarSize = (char) (ViewConfiguration.getScrollBarSize() >> 8);
                    int iResolveOpacity = Drawable.resolveOpacity(0, 0) + 747;
                    byte b14 = $$a[12];
                    Object[] objArr64 = new Object[1];
                    b((byte) 56, (byte) (b14 - 1), b14, objArr64);
                    objAccessartificialFrame17 = ArtificialStackFrames.coroutineCreation(iMyPid, scrollBarSize, iResolveOpacity, -144068856, false, (String) objArr64[0], null);
                }
                ((Field) objAccessartificialFrame17).set(null, lValueOf4);
            } catch (Exception unused4) {
                throw new RuntimeException();
            }
        } else {
            Object objAccessartificialFrame18 = ArtificialStackFrames.accessartificialFrame(1575402270);
            if (objAccessartificialFrame18 == null) {
                int scrollBarFadeDuration = 17 - (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                char cMyPid = (char) (Process.myPid() >> 22);
                int iLastIndexOf2 = TextUtils.lastIndexOf("", '0', 0) + 748;
                byte b15 = (byte) ($$b << 2);
                byte b16 = $$a[12];
                Object[] objArr65 = new Object[1];
                b(b15, (byte) (b16 - 1), b16, objArr65);
                objAccessartificialFrame18 = ArtificialStackFrames.coroutineCreation(scrollBarFadeDuration, cMyPid, iLastIndexOf2, -1031537386, false, (String) objArr65[0], null);
            }
            Object[] objArr66 = (Object[]) ((Field) objAccessartificialFrame18).get(null);
            objArr4 = new Object[]{list, new int[1], list, new int[]{i}, new int[]{i}};
            int i72 = ((int[]) objArr66[3])[0];
            int i73 = ((int[]) objArr66[4])[0];
            List list = (List) objArr66[0];
            List list2 = (List) objArr66[2];
            int i74 = Settings.System.getInt(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getContentResolver(), "screen_brightness", -1);
            int i75 = ~i74;
            int i76 = 1283078155 + (((~(81330931 | i75)) | (~((-686779390) | i74))) * (-370)) + (((~(i74 | 81330931)) | (~(i75 | (-686779390))) | 68157442) * (-370)) + 2081202834;
            int i77 = (i76 << 13) ^ i76;
            int i78 = i77 ^ (i77 >>> 17);
            ((int[]) objArr4[1])[0] = i78 ^ (i78 << 5);
        }
        int i79 = ((int[]) objArr4[4])[0];
        int i80 = ((int[]) objArr4[3])[0];
        if (i80 == i79) {
            Object[] objArr67 = {list, new int[1], list, new int[]{i}, new int[]{i}};
            int i81 = ((int[]) objArr4[1])[0];
            int i82 = ((int[]) objArr4[3])[0];
            int i83 = ((int[]) objArr4[4])[0];
            List list3 = (List) objArr4[0];
            List list4 = (List) objArr4[2];
            int i84 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getDisplayMetrics().heightPixels;
            int i85 = ~i84;
            int i86 = (-1891477295) + (((~((-680160289) | i85)) | (~((-125043615) | i84))) * 520);
            int i87 = ~(125043614 | i85);
            int i88 = ~(i84 | 730492072);
            int i89 = i81 + i86 + ((i87 | i88) * (-1040)) + ((i88 | (~(i85 | (-730492073))) | (-805203903)) * 520);
            int i90 = (i89 << 13) ^ i89;
            int i91 = i90 ^ (i90 >>> 17);
            i = 0;
            ((int[]) objArr67[1])[0] = i91 ^ (i91 << 5);
        } else {
            ArrayList arrayList = new ArrayList();
            Object[] objArr68 = {objArr4};
            Object objAccessartificialFrame19 = ArtificialStackFrames.accessartificialFrame(1804664566);
            if (objAccessartificialFrame19 == null) {
                objAccessartificialFrame19 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getTapTimeout() >> 16) + 41, (char) (12468 - ((Process.getThreadPriority(0) + 20) >> 6)), 3643 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), -185222914, false, "coroutineCreation", new Class[]{Object[].class});
            }
            arrayList.add(((Method) objAccessartificialFrame19).invoke(null, objArr68));
            Object[] objArr69 = {objArr4};
            Object objAccessartificialFrame20 = ArtificialStackFrames.accessartificialFrame(-1243809191);
            if (objAccessartificialFrame20 == null) {
                objAccessartificialFrame20 = ArtificialStackFrames.coroutineCreation((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 41, (char) (TextUtils.getOffsetBefore("", 0) + 12468), 3642 - Gravity.getAbsoluteGravity(0, 0), 716815441, false, "ArtificialStackFrames", new Class[]{Object[].class});
            }
            arrayList.add(((Method) objAccessartificialFrame20).invoke(null, objArr69));
            long j5 = ((long) (i79 ^ i80)) ^ (((long) 1614503194) << 32);
            long j6 = 1614503186;
            int i92 = artificialFrame + 19;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i92 % 128;
            int i93 = i92 % 2;
            Object[] objArr70 = {Long.valueOf(j5), Long.valueOf(j6)};
            byte[] bArr15 = $$d;
            Object[] objArr71 = new Object[1];
            c((byte) (-bArr15[253]), (short) 338, bArr15[730], objArr71);
            Class<?> cls10 = Class.forName((String) objArr71[0]);
            byte b17 = bArr15[29];
            Object[] objArr72 = new Object[1];
            c(b17, (short) (b17 | 544), (byte) 89, objArr72);
            cls10.getMethod((String) objArr72[0], Long.TYPE, Long.TYPE).invoke(null, objArr70);
            Object[] objArr73 = {list, new int[1], list, new int[]{i}, new int[]{i}};
            int i94 = ((int[]) objArr4[1])[0];
            int i95 = ((int[]) objArr4[3])[0];
            int i96 = ((int[]) objArr4[4])[0];
            List list5 = (List) objArr4[0];
            List list6 = (List) objArr4[2];
            int length = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 23519224;
            int i97 = ~length;
            int i98 = i94 + (-2138540935) + (((~(i97 | 734817910)) | (~(129369452 | i97)) | (-805203839)) * 464) + (((-675834387) | length) * (-464)) + (((~(length | 734817910)) | (-805203839)) * 464);
            int i99 = (i98 << 13) ^ i98;
            int i100 = i99 ^ (i99 >>> 17);
            i = 0;
            ((int[]) objArr73[1])[0] = i100 ^ (i100 << 5);
        }
        Object objAccessartificialFrame21 = ArtificialStackFrames.accessartificialFrame(1056123296);
        if (objAccessartificialFrame21 == null) {
            int i101 = 30 - (TypedValue.complexToFloat(i) > 0.0f ? 1 : (TypedValue.complexToFloat(i) == 0.0f ? 0 : -1));
            char deadChar = (char) (49362 - KeyEvent.getDeadChar(i, i));
            int deadChar2 = KeyEvent.getDeadChar(i, i) + 684;
            byte[] bArr16 = $$a;
            Object[] objArr74 = new Object[1];
            b((byte) (-bArr16[103]), bArr16[4], (byte) (-bArr16[17]), objArr74);
            objAccessartificialFrame21 = ArtificialStackFrames.coroutineCreation(i101, deadChar, deadChar2, -1583976536, false, (String) objArr74[0], null);
        }
        long j7 = ((Field) objAccessartificialFrame21).getLong(null);
        if (j7 == -1 || j7 + 2033 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            int iIntValue2 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
            int i102 = getARTIFICIAL_FRAME_PACKAGE_NAME + 99;
            artificialFrame = i102 % 128;
            int i103 = i102 % 2;
            Object[] objArr75 = {Integer.valueOf(iIntValue2), -2126076270};
            byte[] bArr17 = $$d;
            Object[] objArr76 = new Object[1];
            c(bArr17[12], (short) 275, bArr17[552], objArr76);
            Class<?> cls11 = Class.forName((String) objArr76[0]);
            Object[] objArr77 = new Object[1];
            c((byte) (-bArr17[253]), (short) 231, (byte) (-bArr17[88]), objArr77);
            objArr5 = (Object[]) cls11.getMethod((String) objArr77[0], Integer.TYPE, Integer.TYPE).invoke(null, objArr75);
            Object objAccessartificialFrame22 = ArtificialStackFrames.accessartificialFrame(910856866);
            if (objAccessartificialFrame22 == null) {
                int absoluteGravity4 = 30 - Gravity.getAbsoluteGravity(0, 0);
                char c7 = (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 49361);
                int iIndexOf4 = TextUtils.indexOf("", "") + 684;
                byte[] bArr18 = $$a;
                Object[] objArr78 = new Object[1];
                b(bArr18[76], bArr18[18], bArr18[12], objArr78);
                objAccessartificialFrame22 = ArtificialStackFrames.coroutineCreation(absoluteGravity4, c7, iIndexOf4, -1456483158, false, (String) objArr78[0], null);
            }
            ((Field) objAccessartificialFrame22).set(null, objArr5);
            try {
                Long lValueOf5 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame23 = ArtificialStackFrames.accessartificialFrame(1056123296);
                if (objAccessartificialFrame23 == null) {
                    int i104 = (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 30;
                    char longPressTimeout2 = (char) ((ViewConfiguration.getLongPressTimeout() >> 16) + 49362);
                    int iIndexOf5 = TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 685;
                    byte[] bArr19 = $$a;
                    Object[] objArr79 = new Object[1];
                    b((byte) (-bArr19[103]), bArr19[4], (byte) (-bArr19[17]), objArr79);
                    objAccessartificialFrame23 = ArtificialStackFrames.coroutineCreation(i104, longPressTimeout2, iIndexOf5, -1583976536, false, (String) objArr79[0], null);
                }
                ((Field) objAccessartificialFrame23).set(null, lValueOf5);
            } catch (Exception unused5) {
                throw new RuntimeException();
            }
        } else {
            Object objAccessartificialFrame24 = ArtificialStackFrames.accessartificialFrame(910856866);
            if (objAccessartificialFrame24 == null) {
                int i105 = 29 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1));
                char c8 = (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 49361);
                int iGreen = Color.green(0) + 684;
                byte[] bArr20 = $$a;
                Object[] objArr80 = new Object[1];
                b(bArr20[76], bArr20[18], bArr20[12], objArr80);
                objAccessartificialFrame24 = ArtificialStackFrames.coroutineCreation(i105, c8, iGreen, -1456483158, false, (String) objArr80[0], null);
            }
            Object[] objArr81 = (Object[]) ((Field) objAccessartificialFrame24).get(null);
            objArr5 = new Object[]{new int[]{((int[]) objArr81[0])[0]}, new int[]{((int[]) objArr81[1])[0]}, new int[1], (String) objArr81[3]};
            int i106 = Settings.System.getInt(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getContentResolver(), "screen_brightness", -1);
            int i107 = 688151678 + (((~(434966873 | i106)) | 543656901) * 672);
            int i108 = ~i106;
            int i109 = ((i107 + (((~(i106 | 543656901)) | (~((-434966874) | i108))) * (-672))) + (((~((-543656902) | i108)) | 537037444) * 672)) - 2126076270;
            int i110 = (i109 << 13) ^ i109;
            int i111 = i110 ^ (i110 >>> 17);
            ((int[]) objArr5[2])[0] = i111 ^ (i111 << 5);
        }
        int i112 = ((int[]) objArr5[1])[0];
        int i113 = ((int[]) objArr5[0])[0];
        if (i113 == i112) {
            int i114 = ((int[]) objArr5[2])[0];
            Object[] objArr82 = {new int[]{((int[]) objArr5[0])[0]}, new int[]{((int[]) objArr5[1])[0]}, new int[1], (String) objArr5[3]};
            int iIdentityHashCode2 = System.identityHashCode(this);
            int i115 = i114 + ((((~((-8542869) | iIdentityHashCode2)) | 554762314) * TypedValues.PositionType.TYPE_TRANSITION_EASING) - 2064398168) + ((~((~iIdentityHashCode2) | (-8542869))) * TypedValues.PositionType.TYPE_TRANSITION_EASING);
            int i116 = (i115 << 13) ^ i115;
            int i117 = i116 ^ (i116 >>> 17);
            ((int[]) objArr82[2])[0] = i117 ^ (i117 << 5);
        } else {
            new ArrayList().add((String) objArr5[3]);
            Object[] objArr83 = {Long.valueOf(((long) (i112 ^ i113)) ^ (((long) 16135116) << 32)), Long.valueOf(16135132)};
            byte[] bArr21 = $$d;
            Object[] objArr84 = new Object[1];
            c((byte) (-bArr21[253]), (short) 463, bArr21[81], objArr84);
            Class<?> cls12 = Class.forName((String) objArr84[0]);
            byte b18 = bArr21[29];
            Object[] objArr85 = new Object[1];
            c(b18, (short) (b18 | 544), (byte) 89, objArr85);
            cls12.getMethod((String) objArr85[0], Long.TYPE, Long.TYPE).invoke(null, objArr83);
            int i118 = ((int[]) objArr5[2])[0];
            Object[] objArr86 = {new int[]{((int[]) objArr5[0])[0]}, new int[]{((int[]) objArr5[1])[0]}, new int[1], (String) objArr5[3]};
            int i119 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().mcc;
            int i120 = ~i119;
            int i121 = 1933896798 + (((~((-206915204) | i120)) | (~(762795651 | i119))) * 520);
            int i122 = ~((-762795652) | i120);
            int i123 = ~(i119 | 215828123);
            int i124 = i118 + i121 + ((i122 | i123) * (-1040)) + ((i123 | (~(i120 | (-215828124))) | 555880448) * 520);
            int i125 = (i124 << 13) ^ i124;
            int i126 = i125 ^ (i125 >>> 17);
            ((int[]) objArr86[2])[0] = i126 ^ (i126 << 5);
            int i127 = artificialFrame + 107;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i127 % 128;
            int i128 = i127 % 2;
        }
        Object objAccessartificialFrame25 = ArtificialStackFrames.accessartificialFrame(-1268268649);
        if (objAccessartificialFrame25 == null) {
            int i129 = (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 24;
            char mode = (char) (View.MeasureSpec.getMode(0) + 30068);
            int trimmedLength2 = TextUtils.getTrimmedLength("") + 816;
            byte b19 = $$a[12];
            Object[] objArr87 = new Object[1];
            b((byte) 56, (byte) (b19 - 1), b19, objArr87);
            objAccessartificialFrame25 = ArtificialStackFrames.coroutineCreation(i129, mode, trimmedLength2, 721586079, false, (String) objArr87[0], null);
        }
        long j8 = ((Field) objAccessartificialFrame25).getLong(null);
        if (j8 == -1 || j8 + 1891 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Object[] objArr88 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 743584470};
            Object objAccessartificialFrame26 = ArtificialStackFrames.accessartificialFrame(1327366003);
            if (objAccessartificialFrame26 == null) {
                int i130 = (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 24;
                char maxKeyCode = (char) (30068 - (KeyEvent.getMaxKeyCode() >> 16));
                int absoluteGravity5 = Gravity.getAbsoluteGravity(0, 0) + 816;
                byte[] bArr22 = $$a;
                byte b20 = (byte) (bArr22[12] - 1);
                Object[] objArr89 = new Object[1];
                b(b20, (byte) (b20 | Ascii.FS), bArr22[3], objArr89);
                objAccessartificialFrame26 = ArtificialStackFrames.coroutineCreation(i130, maxKeyCode, absoluteGravity5, -797394565, false, (String) objArr89[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            }
            objArr6 = (Object[]) ((Method) objAccessartificialFrame26).invoke(null, objArr88);
            Object objAccessartificialFrame27 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame27 == null) {
                int iAlpha = 25 - Color.alpha(0);
                char c9 = (char) ((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 30067);
                int iMyTid = (Process.myTid() >> 22) + 816;
                byte b21 = (byte) ($$b << 2);
                byte b22 = $$a[12];
                Object[] objArr90 = new Object[1];
                b(b21, (byte) (b22 - 1), b22, objArr90);
                objAccessartificialFrame27 = ArtificialStackFrames.coroutineCreation(iAlpha, c9, iMyTid, 891606461, false, (String) objArr90[0], null);
            }
            ((Field) objAccessartificialFrame27).set(null, objArr6);
            try {
                Long lValueOf6 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame28 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                if (objAccessartificialFrame28 == null) {
                    int iRed = 25 - Color.red(0);
                    char cResolveSize = (char) (30068 - View.resolveSize(0, 0));
                    int scrollDefaultDelay = (ViewConfiguration.getScrollDefaultDelay() >> 16) + 816;
                    byte b23 = $$a[12];
                    Object[] objArr91 = new Object[1];
                    b((byte) 56, (byte) (b23 - 1), b23, objArr91);
                    objAccessartificialFrame28 = ArtificialStackFrames.coroutineCreation(iRed, cResolveSize, scrollDefaultDelay, 721586079, false, (String) objArr91[0], null);
                }
                ((Field) objAccessartificialFrame28).set(null, lValueOf6);
            } catch (Exception unused6) {
                throw new RuntimeException();
            }
        } else {
            Object objAccessartificialFrame29 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame29 == null) {
                int packedPositionGroup3 = ExpandableListView.getPackedPositionGroup(0L) + 25;
                char cLastIndexOf = (char) (30067 - TextUtils.lastIndexOf("", '0', 0));
                int tapTimeout = (ViewConfiguration.getTapTimeout() >> 16) + 816;
                byte b24 = (byte) ($$b << 2);
                byte b25 = $$a[12];
                Object[] objArr92 = new Object[1];
                b(b24, (byte) (b25 - 1), b25, objArr92);
                objAccessartificialFrame29 = ArtificialStackFrames.coroutineCreation(packedPositionGroup3, cLastIndexOf, tapTimeout, 891606461, false, (String) objArr92[0], null);
            }
            Object[] objArr93 = (Object[]) ((Field) objAccessartificialFrame29).get(null);
            objArr6 = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i131 = ((int[]) objArr93[0])[0];
            int i132 = ((int[]) objArr93[1])[0];
            String[] strArr = (String[]) objArr93[2];
            int i133 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().screenWidthDp;
            int i134 = ~i133;
            int i135 = (~((-74645416) | i134)) | 2236545;
            int i136 = ~(i133 | (-51118081));
            int i137 = (-294623722) + ((i135 | i136) * (-713)) + (i136 * 1426) + ((~((-123526951) | i134)) * 713) + 743584470;
            int i138 = (i137 << 13) ^ i137;
            int i139 = i138 ^ (i138 >>> 17);
            ((int[]) objArr6[3])[0] = i139 ^ (i139 << 5);
        }
        int i140 = ((int[]) objArr6[1])[0];
        int i141 = ((int[]) objArr6[0])[0];
        if (i141 == i140) {
            Object[] objArr94 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i142 = ((int[]) objArr6[3])[0];
            int i143 = ((int[]) objArr6[0])[0];
            int i144 = ((int[]) objArr6[1])[0];
            String[] strArr2 = (String[]) objArr6[2];
            int iIdentityHashCode3 = System.identityHashCode(this);
            int i145 = ~iIdentityHashCode3;
            int i146 = (-335218159) + (((~((-417242975) | i145)) | 282074958 | (~(219070608 | i145)) | (~((-83902593) | iIdentityHashCode3))) * (-84));
            int i147 = (~(iIdentityHashCode3 | 219070608)) | 417242974;
            int i148 = ~(i145 | (-219070609));
            int i149 = i142 + i146 + ((i147 | i148) * (-84)) + ((83902592 | i148) * 84);
            int i150 = (i149 << 13) ^ i149;
            int i151 = i150 ^ (i150 >>> 17);
            ((int[]) objArr94[3])[0] = i151 ^ (i151 << 5);
        } else {
            ArrayList arrayList2 = new ArrayList();
            String[] strArr3 = (String[]) objArr6[2];
            if (strArr3 != null) {
                for (String str5 : strArr3) {
                    arrayList2.add(str5);
                }
            }
            Object[] objArr95 = {Long.valueOf(((long) (i140 ^ i141)) ^ (((long) 966045685) << 32)), Long.valueOf(966045684)};
            byte[] bArr23 = $$d;
            Object[] objArr96 = new Object[1];
            c((byte) (-bArr23[253]), (short) JfifUtil.MARKER_RST7, bArr23[171], objArr96);
            Class<?> cls13 = Class.forName((String) objArr96[0]);
            byte b26 = bArr23[29];
            Object[] objArr97 = new Object[1];
            c(b26, (short) (b26 | 544), (byte) 89, objArr97);
            cls13.getMethod((String) objArr97[0], Long.TYPE, Long.TYPE).invoke(null, objArr95);
            Object[] objArr98 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i152 = ((int[]) objArr6[3])[0];
            int i153 = ((int[]) objArr6[0])[0];
            int i154 = ((int[]) objArr6[1])[0];
            String[] strArr4 = (String[]) objArr6[2];
            int iElapsedRealtime3 = (int) SystemClock.elapsedRealtime();
            int i155 = (~(650798901 | iElapsedRealtime3)) | 269484034;
            int i156 = ~((~iElapsedRealtime3) | (-71311669));
            int i157 = i152 + (-1993350535) + ((i155 | i156) * (-470)) + (((~(iElapsedRealtime3 | 920282935)) | i156) * 470);
            int i158 = (i157 << 13) ^ i157;
            int i159 = i158 ^ (i158 >>> 17);
            ((int[]) objArr98[3])[0] = i159 ^ (i159 << 5);
        }
        super.onStart();
        Object objAccessartificialFrame30 = ArtificialStackFrames.accessartificialFrame(1313006081);
        if (objAccessartificialFrame30 == null) {
            int maxKeyCode2 = (KeyEvent.getMaxKeyCode() >> 16) + 21;
            char cIndexOf = (char) TextUtils.indexOf("", "");
            int offsetBefore = TextUtils.getOffsetBefore("", 0) + 465;
            byte b27 = $$a[12];
            Object[] objArr99 = new Object[1];
            b((byte) 56, (byte) (b27 - 1), b27, objArr99);
            objAccessartificialFrame30 = ArtificialStackFrames.coroutineCreation(maxKeyCode2, cIndexOf, offsetBefore, -785931255, false, (String) objArr99[0], null);
        }
        long j9 = ((Field) objAccessartificialFrame30).getLong(null);
        if (j9 == -1 || j9 + 2032 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            Context baseContext4 = getBaseContext();
            if (baseContext4 == null) {
                Object[] objArr100 = new Object[1];
                a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 9, new char[]{30, CoreConstants.COMMA_CHAR, 19, 28, ' ', 15, 17, '#', 21, 2, 3, '#', '\f', '*', 25, 14, 11, 17, 22, '#', '\n', 15, CoreConstants.LEFT_PARENTHESIS_CHAR, 19, 21, 16}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(20) - 65), objArr100);
                Class<?> cls14 = Class.forName((String) objArr100[0]);
                Object[] objArr101 = new Object[1];
                a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(11) - 87, new char[]{'.', 5, 13882, 13882, '\t', CoreConstants.LEFT_PARENTHESIS_CHAR, 28, 14, 13884, 13884, CoreConstants.SINGLE_QUOTE_CHAR, 20, CoreConstants.COMMA_CHAR, 26, 25, 14, 30, '$'}, (byte) ((ViewConfiguration.getEdgeSlop() >> 16) + 82), objArr101);
                baseContext4 = (Context) cls14.getMethod((String) objArr101[0], new Class[0]).invoke(null, null);
            }
            if (baseContext4 != null) {
                baseContext4 = ((baseContext4 instanceof ContextWrapper) && ((ContextWrapper) baseContext4).getBaseContext() == null) ? null : baseContext4.getApplicationContext();
            }
            int iIntValue3 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
            Object[] objArr102 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(1) + 15, new char[]{2, CharUtils.CR, '.', 31, 19, '\t', 3, '0', '0', '+', 23, 24, '\f', '/', 20, 1, 7, 19, '$', 26, 21, '+', 20, 1, CoreConstants.COMMA_CHAR, 24, 19, 2, 15, 16, CharUtils.CR, 5, 1, 27, 21, 15, 20, 1, '0', 0, '\f', 5, 1, 27, 16, 1, 5, '\f', 2, 27, 24, CoreConstants.COMMA_CHAR, CoreConstants.COMMA_CHAR, 0, CoreConstants.PERCENT_CHAR, 26, '\f', 5, 26, '\t', '.', '0', 15, 17}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 29), objArr102);
            String str6 = (String) objArr102[0];
            Object[] objArr103 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 29, new char[]{24, '+', 13930, 13930, CharUtils.CR, 5, 6, 3, 7, CoreConstants.COMMA_CHAR, 27, '\b', CoreConstants.PERCENT_CHAR, 19, 21, 0, 19, CoreConstants.PERCENT_CHAR, '\n', CharUtils.CR, 27, 2, 23, 24, CoreConstants.COMMA_CHAR, 0, CoreConstants.SINGLE_QUOTE_CHAR, '!', 15, 21, 11, '\"', 23, 15, 13843, 13843, 23, 24, '\b', 26, '.', 28, 25, 29, 19, 2, '.', 31, CoreConstants.COMMA_CHAR, 17, 27, 2, 7, CharUtils.CR, 13847, 13847, '\t', 27, 16, 17, 2, 26, 5, CharUtils.CR}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 86), objArr103);
            String[] strArr5 = {str6, (String) objArr103[0]};
            int i160 = artificialFrame + 29;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i160 % 128;
            int i161 = i160 % 2;
            Object[] objArr104 = {baseContext4, strArr5, Integer.valueOf(iIntValue3), 1, -889788311};
            byte[] bArr24 = $$d;
            Object[] objArr105 = new Object[1];
            c(bArr24[5], (short) 151, bArr24[434], objArr105);
            Class<?> cls15 = Class.forName((String) objArr105[0]);
            Object[] objArr106 = new Object[1];
            c(bArr24[5], (short) 483, bArr24[12], objArr106);
            objArr7 = (Object[]) cls15.getMethod((String) objArr106[0], Context.class, String[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr104);
            int i162 = ((int[]) objArr7[0])[0];
            int i163 = ((int[]) objArr7[3])[0];
            if (baseContext4 != null) {
                int i164 = getARTIFICIAL_FRAME_PACKAGE_NAME + 19;
                artificialFrame = i164 % 128;
                int i165 = i164 % 2;
                Object objAccessartificialFrame31 = ArtificialStackFrames.accessartificialFrame(1142731807);
                if (objAccessartificialFrame31 == null) {
                    int maximumDrawingCacheSize = 21 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                    char cIndexOf2 = (char) (TextUtils.indexOf((CharSequence) "", '0') + 1);
                    int iGreen2 = Color.green(0) + 465;
                    byte b28 = (byte) ($$b << 2);
                    byte b29 = $$a[12];
                    Object[] objArr107 = new Object[1];
                    b(b28, (byte) (b29 - 1), b29, objArr107);
                    objAccessartificialFrame31 = ArtificialStackFrames.coroutineCreation(maximumDrawingCacheSize, cIndexOf2, iGreen2, -612765161, false, (String) objArr107[0], null);
                }
                ((Field) objAccessartificialFrame31).set(null, objArr7);
                try {
                    Long lValueOf7 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame32 = ArtificialStackFrames.accessartificialFrame(1313006081);
                    if (objAccessartificialFrame32 == null) {
                        int i166 = 20 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1));
                        char edgeSlop = (char) (ViewConfiguration.getEdgeSlop() >> 16);
                        int threadPriority = 465 - ((Process.getThreadPriority(0) + 20) >> 6);
                        byte b30 = $$a[12];
                        Object[] objArr108 = new Object[1];
                        b((byte) 56, (byte) (b30 - 1), b30, objArr108);
                        objAccessartificialFrame32 = ArtificialStackFrames.coroutineCreation(i166, edgeSlop, threadPriority, -785931255, false, (String) objArr108[0], null);
                    }
                    ((Field) objAccessartificialFrame32).set(null, lValueOf7);
                } catch (Exception unused7) {
                    throw new RuntimeException();
                }
            }
            c = 0;
        } else {
            int i167 = artificialFrame + 121;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i167 % 128;
            int i168 = i167 % 2;
            Object objAccessartificialFrame33 = ArtificialStackFrames.accessartificialFrame(1142731807);
            if (objAccessartificialFrame33 == null) {
                int windowTouchSlop = (ViewConfiguration.getWindowTouchSlop() >> 8) + 21;
                char c10 = (char) (1 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)));
                int i169 = (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 464;
                byte b31 = (byte) ($$b << 2);
                byte b32 = $$a[12];
                Object[] objArr109 = new Object[1];
                b(b31, (byte) (b32 - 1), b32, objArr109);
                objAccessartificialFrame33 = ArtificialStackFrames.coroutineCreation(windowTouchSlop, c10, i169, -612765161, false, (String) objArr109[0], null);
            }
            Object[] objArr110 = (Object[]) ((Field) objAccessartificialFrame33).get(null);
            objArr7 = new Object[]{new int[]{i}, strArr, new int[1], new int[]{i}};
            int i170 = ((int[]) objArr110[3])[0];
            int i171 = ((int[]) objArr110[0])[0];
            String[] strArr6 = (String[]) objArr110[1];
            int iCodePointAt = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(1) - 1315238190;
            int i172 = ~((-446756155) | (~iCodePointAt));
            int i173 = ((((((-464713535) | i172) | (~(446756154 | iCodePointAt))) * (-338)) + 2000964847) + (((~(iCodePointAt | (-17957381))) | i172) * 338)) - 889788311;
            int i174 = (i173 << 13) ^ i173;
            int i175 = i174 ^ (i174 >>> 17);
            ((int[]) objArr7[2])[0] = i175 ^ (i175 << 5);
            c = 0;
        }
        int i176 = ((int[]) objArr7[c])[c];
        int i177 = ((int[]) objArr7[3])[c];
        if (i177 == i176) {
            Object[] objArr111 = new Object[4];
            int[] iArr = new int[1];
            objArr111[c] = iArr;
            objArr111[2] = new int[1];
            int[] iArr2 = new int[1];
            objArr111[3] = iArr2;
            int i178 = ((int[]) objArr7[2])[c];
            int i179 = ((int[]) objArr7[3])[c];
            int i180 = ((int[]) objArr7[c])[c];
            String[] strArr7 = (String[]) objArr7[1];
            iArr2[c] = i179;
            iArr[c] = i180;
            int i181 = ~((int) SystemClock.elapsedRealtime());
            int i182 = i178 + ((((-214064151) + (((~((-108528137) | i181)) | 268877862) * (-828))) + ((i181 | (-108528137)) * (-828))) - 333016608);
            int i183 = (i182 << 13) ^ i182;
            int i184 = i183 ^ (i183 >>> 17);
            ((int[]) objArr111[2])[0] = i184 ^ (i184 << 5);
            objArr111[1] = strArr7;
        } else {
            ArrayList arrayList3 = new ArrayList();
            String[] strArr8 = (String[]) objArr7[1];
            if (strArr8 != null) {
                for (String str7 : strArr8) {
                    arrayList3.add(str7);
                }
            }
            Object[] objArr112 = {Long.valueOf(((long) (i176 ^ i177)) ^ (((long) (-584746129)) << 32)), Long.valueOf(-584746193)};
            byte[] bArr25 = $$d;
            Object[] objArr113 = new Object[1];
            c((byte) (-bArr25[253]), (short) 96, (byte) (-bArr25[302]), objArr113);
            Class<?> cls16 = Class.forName((String) objArr113[0]);
            byte b33 = bArr25[29];
            Object[] objArr114 = new Object[1];
            c(b33, (short) (b33 | 544), (byte) 89, objArr114);
            cls16.getMethod((String) objArr114[0], Long.TYPE, Long.TYPE).invoke(null, objArr112);
            Object[] objArr115 = {new int[]{i}, strArr, new int[1], new int[]{i}};
            int i185 = ((int[]) objArr7[2])[0];
            int i186 = ((int[]) objArr7[3])[0];
            int i187 = ((int[]) objArr7[0])[0];
            String[] strArr9 = (String[]) objArr7[1];
            int i188 = ~((int) SystemClock.uptimeMillis());
            int i189 = i185 + 535307434 + (((~((-91417387) | i188)) | (-68932340)) * (-983)) + (((~(i188 | (-68932340))) | 594129) * 983);
            int i190 = (i189 << 13) ^ i189;
            int i191 = i190 ^ (i190 >>> 17);
            ((int[]) objArr115[2])[0] = i191 ^ (i191 << 5);
        }
        Object objAccessartificialFrame34 = ArtificialStackFrames.accessartificialFrame(-444530678);
        if (objAccessartificialFrame34 == null) {
            int i192 = 27 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1));
            char touchSlop = (char) (ViewConfiguration.getTouchSlop() >> 8);
            int i193 = (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 1040;
            byte b34 = $$a[12];
            Object[] objArr116 = new Object[1];
            b((byte) 56, (byte) (b34 - 1), b34, objArr116);
            objAccessartificialFrame34 = ArtificialStackFrames.coroutineCreation(i192, touchSlop, i193, 2061780482, false, (String) objArr116[0], null);
        }
        long j10 = ((Field) objAccessartificialFrame34).getLong(null);
        if (j10 == -1 || j10 + 4611686018427387861L < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            int iIntValue4 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
            Object[] objArr117 = {-1210500958};
            Object objAccessartificialFrame35 = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame35 == null) {
                objAccessartificialFrame35 = ArtificialStackFrames.coroutineCreation(9 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), (char) (Drawable.resolveOpacity(0, 0) + 22251), (ViewConfiguration.getWindowTouchSlop() >> 8) + 1033, 47343338, false, null, new Class[]{Integer.TYPE});
            }
            objArrAccessartificialFrame$78cbbd35 = HpkePrivateKeyManager$$ExternalSyntheticLambda2.accessartificialFrame$78cbbd35(iIntValue4, 0, ((Constructor) objAccessartificialFrame35).newInstance(objArr117), -1873853914, false);
            Object objAccessartificialFrame36 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame36 == null) {
                int iIndexOf6 = TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 27;
                char jumpTapTimeout = (char) (ViewConfiguration.getJumpTapTimeout() >> 16);
                int i194 = (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 1041;
                byte b35 = (byte) ($$b << 2);
                byte b36 = $$a[12];
                Object[] objArr118 = new Object[1];
                b(b35, (byte) (b36 - 1), b36, objArr118);
                objAccessartificialFrame36 = ArtificialStackFrames.coroutineCreation(iIndexOf6, jumpTapTimeout, i194, 1145017376, false, (String) objArr118[0], null);
            }
            ((Field) objAccessartificialFrame36).set(null, objArrAccessartificialFrame$78cbbd35);
            try {
                Long lValueOf8 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                Object objAccessartificialFrame37 = ArtificialStackFrames.accessartificialFrame(-444530678);
                if (objAccessartificialFrame37 == null) {
                    int maximumDrawingCacheSize2 = 26 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                    char cNormalizeMetaState2 = (char) KeyEvent.normalizeMetaState(0);
                    int i195 = (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 1041;
                    byte b37 = $$a[12];
                    Object[] objArr119 = new Object[1];
                    b((byte) 56, (byte) (b37 - 1), b37, objArr119);
                    objAccessartificialFrame37 = ArtificialStackFrames.coroutineCreation(maximumDrawingCacheSize2, cNormalizeMetaState2, i195, 2061780482, false, (String) objArr119[0], null);
                }
                ((Field) objAccessartificialFrame37).set(null, lValueOf8);
            } catch (Exception unused8) {
                throw new RuntimeException();
            }
        } else {
            Object objAccessartificialFrame38 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame38 == null) {
                int packedPositionGroup4 = ExpandableListView.getPackedPositionGroup(0L) + 26;
                char modifierMetaStateMask = (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 1);
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0) + 1041;
                byte b38 = (byte) ($$b << 2);
                byte b39 = $$a[12];
                Object[] objArr120 = new Object[1];
                b(b38, (byte) (b39 - 1), b39, objArr120);
                objAccessartificialFrame38 = ArtificialStackFrames.coroutineCreation(packedPositionGroup4, modifierMetaStateMask, iMakeMeasureSpec, 1145017376, false, (String) objArr120[0], null);
            }
            Object[] objArr121 = (Object[]) ((Field) objAccessartificialFrame38).get(null);
            objArrAccessartificialFrame$78cbbd35 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
            int i196 = ((int[]) objArr121[3])[0];
            int i197 = ((int[]) objArr121[2])[0];
            String[] strArr10 = (String[]) objArr121[0];
            int i198 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 1090396854;
            int i199 = ~i198;
            int i200 = (((((~(i199 | (-263721035))) | ((~((-341824842) | i199)) | 68685896)) * (-397)) - 1536848934) + ((i198 | (-468174084)) * 397)) - 1873853914;
            int i201 = (i200 << 13) ^ i200;
            int i202 = i201 ^ (i201 >>> 17);
            ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0] = i202 ^ (i202 << 5);
        }
        int i203 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
        int i204 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
        if (i204 == i203) {
            Object[] objArr122 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i205 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
            int i206 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            int i207 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            String[] strArr11 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
            int streamMaxVolume = ((AudioManager) ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getSystemService("audio")).getStreamMaxVolume(3);
            int i208 = ~streamMaxVolume;
            int i209 = i205 + ((((~(769646435 | i208)) | (~((-77106434) | streamMaxVolume))) * 988) - 1616035054) + (((~(streamMaxVolume | 614436195)) | 155210240 | (~(i208 | (-77106434)))) * 988);
            int i210 = (i209 << 13) ^ i209;
            int i211 = i210 ^ (i210 >>> 17);
            ((int[]) objArr122[1])[0] = i211 ^ (i211 << 5);
            return;
        }
        ArrayList arrayList4 = new ArrayList();
        String[] strArr12 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
        if (strArr12 != null) {
            for (String str8 : strArr12) {
                arrayList4.add(str8);
            }
        }
        Object[] objArr123 = {Long.valueOf(((long) (i203 ^ i204)) ^ (((long) 1830619336) << 32)), Long.valueOf(1830619338)};
        byte[] bArr26 = $$d;
        Object[] objArr124 = new Object[1];
        c((byte) (-bArr26[88]), (short) 54, (byte) (-bArr26[27]), objArr124);
        Class<?> cls17 = Class.forName((String) objArr124[0]);
        byte b40 = bArr26[29];
        Object[] objArr125 = new Object[1];
        c(b40, (short) (b40 | 544), (byte) 89, objArr125);
        cls17.getMethod((String) objArr125[0], Long.TYPE, Long.TYPE).invoke(null, objArr123);
        Object[] objArr126 = {strArr, new int[1], new int[]{i}, new int[]{i}};
        int i212 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
        int i213 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
        int i214 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
        String[] strArr13 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
        int iIdentityHashCode4 = System.identityHashCode(this);
        int i215 = i212 + (-1870038530) + (((~(iIdentityHashCode4 | 1054324439)) | 2638088) * 305) + (((~((~iIdentityHashCode4) | 1054324439)) | 976220632) * 305);
        int i216 = (i215 << 13) ^ i215;
        int i217 = i216 ^ (i216 >>> 17);
        ((int[]) objArr126[1])[0] = i217 ^ (i217 << 5);
    }

    @Override // android.app.Activity
    protected void onResume() throws Throwable {
        int i = 2 % 2;
        int i2 = getARTIFICIAL_FRAME_PACKAGE_NAME + 49;
        artificialFrame = i2 % 128;
        try {
            if (i2 % 2 == 0) {
                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(949068051);
                if (objAccessartificialFrame == null) {
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(30 - View.resolveSizeAndState(0, 0, 0), (char) (49993 - TextUtils.getCapsMode("", 0, 0)), 74 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), -1477122277, false, "MediaDescriptionCompatApi23Builder", null);
                }
                Object obj = ((Field) objAccessartificialFrame).get(null);
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1579113874);
                if (objAccessartificialFrame2 == null) {
                    int iMyPid = (Process.myPid() >> 22) + 30;
                    char cCombineMeasuredStates = (char) (49993 - View.combineMeasuredStates(0, 0));
                    int i3 = 75 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
                    byte[] bArr = $$d;
                    byte b = bArr[545];
                    short s = bArr[29];
                    Object[] objArr = new Object[1];
                    c(b, s, (byte) (s | 91), objArr);
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iMyPid, cCombineMeasuredStates, i3, -1048962150, false, (String) objArr[0], new Class[0]);
                }
                ((Method) objAccessartificialFrame2).invoke(obj, null);
                super.onResume();
                throw null;
            }
            Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(949068051);
            if (objAccessartificialFrame3 == null) {
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(TextUtils.indexOf("", "") + 30, (char) (49993 - (ViewConfiguration.getPressedStateDuration() >> 16)), (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 73, -1477122277, false, "MediaDescriptionCompatApi23Builder", null);
            }
            Object obj2 = ((Field) objAccessartificialFrame3).get(null);
            Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1579113874);
            if (objAccessartificialFrame4 == null) {
                int iResolveOpacity = 30 - Drawable.resolveOpacity(0, 0);
                char packedPositionGroup = (char) (ExpandableListView.getPackedPositionGroup(0L) + 49993);
                int i4 = (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + 74;
                byte[] bArr2 = $$d;
                byte b2 = bArr2[545];
                short s2 = bArr2[29];
                Object[] objArr2 = new Object[1];
                c(b2, s2, (byte) (s2 | 91), objArr2);
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(iResolveOpacity, packedPositionGroup, i4, -1048962150, false, (String) objArr2[0], new Class[0]);
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

    @Override // android.app.Activity
    protected void onPause() throws Throwable {
        int i = 2 % 2;
        int i2 = artificialFrame + 79;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i2 % 128;
        Object obj = null;
        try {
            if (i2 % 2 != 0) {
                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(949068051);
                if (objAccessartificialFrame == null) {
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(View.MeasureSpec.getMode(0) + 30, (char) (49994 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))), TextUtils.lastIndexOf("", '0', 0, 0) + 75, -1477122277, false, "MediaDescriptionCompatApi23Builder", null);
                }
                Object obj2 = ((Field) objAccessartificialFrame).get(null);
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1579114835);
                if (objAccessartificialFrame2 == null) {
                    int fadingEdgeLength = (ViewConfiguration.getFadingEdgeLength() >> 16) + 30;
                    char c = (char) (49993 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)));
                    int iRgb = Color.rgb(0, 0, 0) + 16777290;
                    byte[] bArr = $$d;
                    byte b = (byte) (-bArr[253]);
                    short s = bArr[29];
                    Object[] objArr = new Object[1];
                    c(b, s, (byte) (s | 91), objArr);
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(fadingEdgeLength, c, iRgb, -1048959141, false, (String) objArr[0], new Class[0]);
                }
                ((Method) objAccessartificialFrame2).invoke(obj2, null);
                super.onPause();
                int i3 = 67 / 0;
            } else {
                Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(949068051);
                if (objAccessartificialFrame3 == null) {
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(Process.getGidForName("") + 31, (char) (49993 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24)), View.resolveSize(0, 0) + 74, -1477122277, false, "MediaDescriptionCompatApi23Builder", null);
                }
                Object obj3 = ((Field) objAccessartificialFrame3).get(null);
                Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1579114835);
                if (objAccessartificialFrame4 == null) {
                    int keyRepeatTimeout = (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 30;
                    char c2 = (char) (49992 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)));
                    int iGreen = Color.green(0) + 74;
                    byte[] bArr2 = $$d;
                    byte b2 = (byte) (-bArr2[253]);
                    short s2 = bArr2[29];
                    Object[] objArr2 = new Object[1];
                    c(b2, s2, (byte) (s2 | 91), objArr2);
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(keyRepeatTimeout, c2, iGreen, -1048959141, false, (String) objArr2[0], new Class[0]);
                }
                ((Method) objAccessartificialFrame4).invoke(obj3, null);
                super.onPause();
            }
            int i4 = artificialFrame + 45;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i4 % 128;
            if (i4 % 2 == 0) {
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

    /* JADX WARN: Code duplicated, block: B:13:0x01b2  */
    /* JADX WARN: Code duplicated, block: B:16:0x0256 A[Catch: all -> 0x0b2a, TryCatch #0 {all -> 0x0b2a, blocks: (B:51:0x0828, B:53:0x083c, B:54:0x086d, B:14:0x0236, B:16:0x0256, B:17:0x02a5), top: B:91:0x0236 }] */
    /* JADX WARN: Code duplicated, block: B:20:0x02b7  */
    /* JADX WARN: Code duplicated, block: B:25:0x03c2  */
    /* JADX WARN: Code duplicated, block: B:50:0x0789  */
    /* JADX WARN: Code duplicated, block: B:53:0x083c A[Catch: all -> 0x0b2a, TryCatch #0 {all -> 0x0b2a, blocks: (B:51:0x0828, B:53:0x083c, B:54:0x086d, B:14:0x0236, B:16:0x0256, B:17:0x02a5), top: B:91:0x0236 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x0883  */
    /* JADX WARN: Code duplicated, block: B:62:0x0964  */
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
            int iRgb = (-16777191) - Color.rgb(0, 0, 0);
            char c = (char) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 30067);
            int iIndexOf = 816 - TextUtils.indexOf("", "", 0);
            byte b = $$a[12];
            Object[] objArr3 = new Object[1];
            b((byte) 56, (byte) (b - 1), b, objArr3);
            objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(iRgb, c, iIndexOf, 721586079, false, (String) objArr3[0], null);
        }
        long j = ((Field) objAccessartificialFrame7).getLong(null);
        if (j != -1) {
            long j2 = j + 1985;
            Object[] objArr4 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 13, new char[]{30, CoreConstants.COMMA_CHAR, 19, 28, ' ', 15, 17, '#', 31, 1, CoreConstants.SINGLE_QUOTE_CHAR, '\n', Typography.amp, 1, 26, 7, 25, '0', '$', '\"', '.', CoreConstants.LEFT_PARENTHESIS_CHAR}, (byte) (28 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24)), objArr4);
            Class<?> cls = Class.forName((String) objArr4[0]);
            Object[] objArr5 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) - 21, new char[]{CharUtils.CR, CoreConstants.LEFT_PARENTHESIS_CHAR, 21, 2, 5, '\n', 21, '#', '\t', 26, '#', 27, 20, 25, 13942}, (byte) (119 - TextUtils.getOffsetBefore("", 0)), objArr5);
            if (j2 >= ((Long) cls.getDeclaredMethod((String) objArr5[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame8 == null) {
                    int longPressTimeout = (ViewConfiguration.getLongPressTimeout() >> 16) + 25;
                    char cIndexOf = (char) (30068 - TextUtils.indexOf("", "", 0));
                    int i2 = (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 815;
                    byte b2 = (byte) ($$b << 2);
                    byte b3 = $$a[12];
                    Object[] objArr6 = new Object[1];
                    b(b2, (byte) (b3 - 1), b3, objArr6);
                    objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(longPressTimeout, cIndexOf, i2, 891606461, false, (String) objArr6[0], null);
                }
                Object[] objArr7 = (Object[]) ((Field) objAccessartificialFrame8).get(null);
                objArr = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i3 = ((int[]) objArr7[0])[0];
                int i4 = ((int[]) objArr7[1])[0];
                String[] strArr = (String[]) objArr7[2];
                int iIdentityHashCode = System.identityHashCode(this);
                int i5 = 1192546983 + (((~((-296265970) | iIdentityHashCode)) | 25724961 | (~((-98093604) | iIdentityHashCode))) * (-754));
                int i6 = ~((-25724962) | iIdentityHashCode);
                int i7 = ~iIdentityHashCode;
                int i8 = ((i5 + ((i6 | (~((-72368643) | i7))) * (-754))) + ((i7 | (-296265970)) * 754)) - 1553287631;
                int i9 = (i8 << 13) ^ i8;
                int i10 = i9 ^ (i9 >>> 17);
                ((int[]) objArr[3])[0] = i10 ^ (i10 << 5);
            } else {
                Object[] objArr8 = new Object[1];
                a((ViewConfiguration.getScrollDefaultDelay() >> 16) + 16, new char[]{16, 26, '\t', 24, CoreConstants.SINGLE_QUOTE_CHAR, '#', 30, CoreConstants.COMMA_CHAR, 31, CoreConstants.DASH_CHAR, '\b', CoreConstants.SINGLE_QUOTE_CHAR, 0, 24, CharUtils.CR, 26}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 7), objArr8);
                Class<?> cls2 = Class.forName((String) objArr8[0]);
                Object[] objArr9 = new Object[1];
                a(AndroidCharacter.getMirror('0') - ' ', new char[]{19, 15, '\t', CoreConstants.LEFT_PARENTHESIS_CHAR, 25, 14, 22, '#', 27, 24, '\n', 24, '+', ' ', 19, 7}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 56), objArr9);
                try {
                    Object[] objArr10 = {Integer.valueOf(((Integer) cls2.getMethod((String) objArr9[0], Object.class).invoke(null, this)).intValue()), 0, -1553287631};
                    objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(1327366003);
                    if (objAccessartificialFrame == null) {
                        int keyRepeatDelay = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 25;
                        char pressedStateDuration = (char) ((ViewConfiguration.getPressedStateDuration() >> 16) + 30068);
                        int i11 = (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 816;
                        byte[] bArr = $$a;
                        byte b4 = (byte) (bArr[12] - 1);
                        Object[] objArr11 = new Object[1];
                        b(b4, (byte) (b4 | Ascii.FS), bArr[3], objArr11);
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(keyRepeatDelay, pressedStateDuration, i11, -797394565, false, (String) objArr11[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                    }
                    objArr = (Object[]) ((Method) objAccessartificialFrame).invoke(null, objArr10);
                    objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                    if (objAccessartificialFrame2 == null) {
                        int bitsPerPixel = 24 - ImageFormat.getBitsPerPixel(0);
                        char maximumDrawingCacheSize = (char) (30068 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24));
                        int keyRepeatDelay2 = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 816;
                        byte b5 = (byte) ($$b << 2);
                        byte b6 = $$a[12];
                        Object[] objArr12 = new Object[1];
                        b(b5, (byte) (b6 - 1), b6, objArr12);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(bitsPerPixel, maximumDrawingCacheSize, keyRepeatDelay2, 891606461, false, (String) objArr12[0], null);
                    }
                    ((Field) objAccessartificialFrame2).set(null, objArr);
                    try {
                        Object[] objArr13 = new Object[1];
                        a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(3) - 93, new char[]{30, CoreConstants.COMMA_CHAR, 19, 28, ' ', 15, 17, '#', 31, 1, CoreConstants.SINGLE_QUOTE_CHAR, '\n', Typography.amp, 1, 26, 7, 25, '0', '$', '\"', '.', CoreConstants.LEFT_PARENTHESIS_CHAR}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 7), objArr13);
                        Class<?> cls3 = Class.forName((String) objArr13[0]);
                        Object[] objArr14 = new Object[1];
                        a(15 - (ViewConfiguration.getPressedStateDuration() >> 16), new char[]{CharUtils.CR, CoreConstants.LEFT_PARENTHESIS_CHAR, 21, 2, 5, '\n', 21, '#', '\t', 26, '#', 27, 20, 25, 13942}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 115), objArr14);
                        Long lValueOf = Long.valueOf(((Long) cls3.getDeclaredMethod((String) objArr14[0], new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                        if (objAccessartificialFrame3 == null) {
                            int iIndexOf2 = 24 - TextUtils.indexOf((CharSequence) "", '0', 0, 0);
                            char c2 = (char) ((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 30068);
                            int scrollBarFadeDuration = (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 816;
                            byte b7 = $$a[12];
                            Object[] objArr15 = new Object[1];
                            b((byte) 56, (byte) (b7 - 1), b7, objArr15);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(iIndexOf2, c2, scrollBarFadeDuration, 721586079, false, (String) objArr15[0], null);
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
            a((ViewConfiguration.getScrollDefaultDelay() >> 16) + 16, new char[]{16, 26, '\t', 24, CoreConstants.SINGLE_QUOTE_CHAR, '#', 30, CoreConstants.COMMA_CHAR, 31, CoreConstants.DASH_CHAR, '\b', CoreConstants.SINGLE_QUOTE_CHAR, 0, 24, CharUtils.CR, 26}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 7), objArr16);
            Class<?> cls4 = Class.forName((String) objArr16[0]);
            Object[] objArr17 = new Object[1];
            a(AndroidCharacter.getMirror('0') - ' ', new char[]{19, 15, '\t', CoreConstants.LEFT_PARENTHESIS_CHAR, 25, 14, 22, '#', 27, 24, '\n', 24, '+', ' ', 19, 7}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 56), objArr17);
            Object[] objArr18 = {Integer.valueOf(((Integer) cls4.getMethod((String) objArr17[0], Object.class).invoke(null, this)).intValue()), 0, -1553287631};
            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(1327366003);
            if (objAccessartificialFrame == null) {
                int keyRepeatDelay3 = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 25;
                char pressedStateDuration2 = (char) ((ViewConfiguration.getPressedStateDuration() >> 16) + 30068);
                int i12 = (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 816;
                byte[] bArr2 = $$a;
                byte b8 = (byte) (bArr2[12] - 1);
                Object[] objArr19 = new Object[1];
                b(b8, (byte) (b8 | Ascii.FS), bArr2[3], objArr19);
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(keyRepeatDelay3, pressedStateDuration2, i12, -797394565, false, (String) objArr19[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            }
            objArr = (Object[]) ((Method) objAccessartificialFrame).invoke(null, objArr18);
            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame2 == null) {
                int bitsPerPixel2 = 24 - ImageFormat.getBitsPerPixel(0);
                char maximumDrawingCacheSize2 = (char) (30068 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24));
                int keyRepeatDelay4 = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 816;
                byte b9 = (byte) ($$b << 2);
                byte b10 = $$a[12];
                Object[] objArr110 = new Object[1];
                b(b9, (byte) (b10 - 1), b10, objArr110);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(bitsPerPixel2, maximumDrawingCacheSize2, keyRepeatDelay4, 891606461, false, (String) objArr110[0], null);
            }
            ((Field) objAccessartificialFrame2).set(null, objArr);
            Object[] objArr111 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(3) - 93, new char[]{30, CoreConstants.COMMA_CHAR, 19, 28, ' ', 15, 17, '#', 31, 1, CoreConstants.SINGLE_QUOTE_CHAR, '\n', Typography.amp, 1, 26, 7, 25, '0', '$', '\"', '.', CoreConstants.LEFT_PARENTHESIS_CHAR}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 7), objArr111);
            Class<?> cls5 = Class.forName((String) objArr111[0]);
            Object[] objArr112 = new Object[1];
            a(15 - (ViewConfiguration.getPressedStateDuration() >> 16), new char[]{CharUtils.CR, CoreConstants.LEFT_PARENTHESIS_CHAR, 21, 2, 5, '\n', 21, '#', '\t', 26, '#', 27, 20, 25, 13942}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 115), objArr112);
            Long lValueOf2 = Long.valueOf(((Long) cls5.getDeclaredMethod((String) objArr112[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1268268649);
            if (objAccessartificialFrame3 == null) {
                int iIndexOf3 = 24 - TextUtils.indexOf((CharSequence) "", '0', 0, 0);
                char c3 = (char) ((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 30068);
                int scrollBarFadeDuration2 = (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 816;
                byte b11 = $$a[12];
                Object[] objArr113 = new Object[1];
                b((byte) 56, (byte) (b11 - 1), b11, objArr113);
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(iIndexOf3, c3, scrollBarFadeDuration2, 721586079, false, (String) objArr113[0], null);
            }
            ((Field) objAccessartificialFrame3).set(null, lValueOf2);
        }
        int i13 = ((int[]) objArr[1])[0];
        int i14 = ((int[]) objArr[0])[0];
        if (i14 == i13) {
            int i15 = getARTIFICIAL_FRAME_PACKAGE_NAME + 43;
            artificialFrame = i15 % 128;
            int i16 = i15 % 2;
            Object[] objArr20 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i17 = ((int[]) objArr[3])[0];
            int i18 = ((int[]) objArr[0])[0];
            int i19 = ((int[]) objArr[1])[0];
            String[] strArr2 = (String[]) objArr[2];
            int length = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 1175324920;
            int i20 = i17 + (((~(465551839 | length)) | (-1009803635)) * 398) + 973926049 + (((~((~length) | 465551839)) | (-1009803635)) * 398);
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
            try {
                Object[] objArr21 = {Long.valueOf((((long) 163859841) << 32) ^ ((long) (i13 ^ i14))), Long.valueOf(163859840)};
                byte[] bArr3 = $$d;
                Object[] objArr22 = new Object[1];
                c((byte) (-bArr3[253]), bArr3[29], bArr3[7], objArr22);
                Class<?> cls6 = Class.forName((String) objArr22[0]);
                byte b12 = bArr3[29];
                Object[] objArr23 = new Object[1];
                c(b12, (short) (b12 | 544), (byte) 89, objArr23);
                cls6.getMethod((String) objArr23[0], Long.TYPE, Long.TYPE).invoke(null, objArr21);
                Object[] objArr24 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i23 = ((int[]) objArr[3])[0];
                int i24 = ((int[]) objArr[0])[0];
                int i25 = ((int[]) objArr[1])[0];
                String[] strArr4 = (String[]) objArr[2];
                int i26 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().navigation;
                int i27 = ~i26;
                int i28 = i23 + 525994198 + (((~(550196809 | i27)) | 748369175) * (-90)) + (((~(550196809 | i26)) | 4211272) * (-45)) + (((~(i26 | (-748369176))) | 550196809 | (~(i27 | 748369175))) * 45);
                int i29 = (i28 << 13) ^ i28;
                int i30 = i29 ^ (i29 >>> 17);
                ((int[]) objArr24[3])[0] = i30 ^ (i30 << 5);
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
            int iResolveSizeAndState = View.resolveSizeAndState(0, 0, 0) + 26;
            char cIndexOf2 = (char) TextUtils.indexOf("", "");
            int pressedStateDuration3 = 1041 - (ViewConfiguration.getPressedStateDuration() >> 16);
            byte b13 = $$a[12];
            Object[] objArr25 = new Object[1];
            b((byte) 56, (byte) (b13 - 1), b13, objArr25);
            objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(iResolveSizeAndState, cIndexOf2, pressedStateDuration3, 2061780482, false, (String) objArr25[0], null);
        }
        long j3 = ((Field) objAccessartificialFrame9).getLong(null);
        if (j3 != -1) {
            int i31 = getARTIFICIAL_FRAME_PACKAGE_NAME + 75;
            artificialFrame = i31 % 128;
            int i32 = i31 % 2;
            long j4 = j3 + 4611686018427387787L;
            Object[] objArr26 = new Object[1];
            a(22 - (Process.myPid() >> 22), new char[]{30, CoreConstants.COMMA_CHAR, 19, 28, ' ', 15, 17, '#', 31, 1, CoreConstants.SINGLE_QUOTE_CHAR, '\n', Typography.amp, 1, 26, 7, 25, '0', '$', '\"', '.', CoreConstants.LEFT_PARENTHESIS_CHAR}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 7), objArr26);
            Class<?> cls7 = Class.forName((String) objArr26[0]);
            Object[] objArr27 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 20, new char[]{CharUtils.CR, CoreConstants.LEFT_PARENTHESIS_CHAR, 21, 2, 5, '\n', 21, '#', '\t', 26, '#', 27, 20, 25, 13942}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) + 70), objArr27);
            if (j4 >= ((Long) cls7.getDeclaredMethod((String) objArr27[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                int i33 = getARTIFICIAL_FRAME_PACKAGE_NAME + 3;
                artificialFrame = i33 % 128;
                int i34 = i33 % 2;
                Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame10 == null) {
                    int iIndexOf4 = 26 - TextUtils.indexOf("", "", 0, 0);
                    char c4 = (char) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) - 1);
                    int trimmedLength = 1041 - TextUtils.getTrimmedLength("");
                    byte b14 = (byte) ($$b << 2);
                    byte b15 = $$a[12];
                    Object[] objArr28 = new Object[1];
                    b(b14, (byte) (b15 - 1), b15, objArr28);
                    objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(iIndexOf4, c4, trimmedLength, 1145017376, false, (String) objArr28[0], null);
                }
                Object[] objArr29 = (Object[]) ((Field) objAccessartificialFrame10).get(null);
                objArr2 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
                int i35 = ((int[]) objArr29[3])[0];
                int i36 = ((int[]) objArr29[2])[0];
                String[] strArr5 = (String[]) objArr29[0];
                int length2 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() - 1271971443;
                int i37 = (-158433714) + (((~(670139583 | length2)) | 134760704) * 336) + (((~(length2 | 748243390)) | 56656897) * (-168)) + (((~((~length2) | 748243390)) | 670139583) * 168) + 146898996;
                int i38 = (i37 << 13) ^ i37;
                int i39 = i38 ^ (i38 >>> 17);
                ((int[]) objArr2[1])[0] = i39 ^ (i39 << 5);
            } else {
                Object[] objArr30 = new Object[1];
                a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(15) - 101, new char[]{16, 26, '\t', 24, CoreConstants.SINGLE_QUOTE_CHAR, '#', 30, CoreConstants.COMMA_CHAR, 31, CoreConstants.DASH_CHAR, '\b', CoreConstants.SINGLE_QUOTE_CHAR, 0, 24, CharUtils.CR, 26}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 21), objArr30);
                Class<?> cls8 = Class.forName((String) objArr30[0]);
                Object[] objArr31 = new Object[1];
                a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 19, new char[]{19, 15, '\t', CoreConstants.LEFT_PARENTHESIS_CHAR, 25, 14, 22, '#', 27, 24, '\n', 24, '+', ' ', 19, 7}, (byte) (91 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24)), objArr31);
                int iIntValue = ((Integer) cls8.getMethod((String) objArr31[0], Object.class).invoke(null, this)).intValue();
                Object[] objArr32 = {-404338547};
                objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1648942878);
                if (objAccessartificialFrame4 == null) {
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(9 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), (char) ((ViewConfiguration.getPressedStateDuration() >> 16) + 22251), 1033 - ExpandableListView.getPackedPositionGroup(0L), 47343338, false, null, new Class[]{Integer.TYPE});
                }
                Object[] objArrAccessartificialFrame$78cbbd35 = HpkePrivateKeyManager$$ExternalSyntheticLambda2.accessartificialFrame$78cbbd35(iIntValue, 0, ((Constructor) objAccessartificialFrame4).newInstance(objArr32), 146898996, false);
                objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame5 == null) {
                    int offsetAfter = 26 - TextUtils.getOffsetAfter("", 0);
                    char cIndexOf3 = (char) TextUtils.indexOf("", "", 0);
                    int iResolveOpacity = Drawable.resolveOpacity(0, 0) + 1041;
                    byte b16 = (byte) ($$b << 2);
                    byte b17 = $$a[12];
                    Object[] objArr33 = new Object[1];
                    b(b16, (byte) (b17 - 1), b17, objArr33);
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(offsetAfter, cIndexOf3, iResolveOpacity, 1145017376, false, (String) objArr33[0], null);
                }
                ((Field) objAccessartificialFrame5).set(null, objArrAccessartificialFrame$78cbbd35);
                try {
                    Object[] objArr34 = new Object[1];
                    a(23 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), new char[]{30, CoreConstants.COMMA_CHAR, 19, 28, ' ', 15, 17, '#', 31, 1, CoreConstants.SINGLE_QUOTE_CHAR, '\n', Typography.amp, 1, 26, 7, 25, '0', '$', '\"', '.', CoreConstants.LEFT_PARENTHESIS_CHAR}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 7), objArr34);
                    Class<?> cls9 = Class.forName((String) objArr34[0]);
                    Object[] objArr35 = new Object[1];
                    a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(0) - 22, new char[]{CharUtils.CR, CoreConstants.LEFT_PARENTHESIS_CHAR, 21, 2, 5, '\n', 21, '#', '\t', 26, '#', 27, 20, 25, 13942}, (byte) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 118), objArr35);
                    Long lValueOf3 = Long.valueOf(((Long) cls9.getDeclaredMethod((String) objArr35[0], new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-444530678);
                    if (objAccessartificialFrame6 == null) {
                        int packedPositionType = ExpandableListView.getPackedPositionType(0L) + 26;
                        char edgeSlop = (char) (ViewConfiguration.getEdgeSlop() >> 16);
                        int doubleTapTimeout = 1041 - (ViewConfiguration.getDoubleTapTimeout() >> 16);
                        byte b18 = $$a[12];
                        Object[] objArr36 = new Object[1];
                        b((byte) 56, (byte) (b18 - 1), b18, objArr36);
                        objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(packedPositionType, edgeSlop, doubleTapTimeout, 2061780482, false, (String) objArr36[0], null);
                    }
                    ((Field) objAccessartificialFrame6).set(null, lValueOf3);
                    objArr2 = objArrAccessartificialFrame$78cbbd35;
                } catch (Exception unused2) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object[] objArr37 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(15) - 101, new char[]{16, 26, '\t', 24, CoreConstants.SINGLE_QUOTE_CHAR, '#', 30, CoreConstants.COMMA_CHAR, 31, CoreConstants.DASH_CHAR, '\b', CoreConstants.SINGLE_QUOTE_CHAR, 0, 24, CharUtils.CR, 26}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 21), objArr37);
            Class<?> cls10 = Class.forName((String) objArr37[0]);
            Object[] objArr38 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 19, new char[]{19, 15, '\t', CoreConstants.LEFT_PARENTHESIS_CHAR, 25, 14, 22, '#', 27, 24, '\n', 24, '+', ' ', 19, 7}, (byte) (91 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24)), objArr38);
            int iIntValue2 = ((Integer) cls10.getMethod((String) objArr38[0], Object.class).invoke(null, this)).intValue();
            Object[] objArr39 = {-404338547};
            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame4 == null) {
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(9 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), (char) ((ViewConfiguration.getPressedStateDuration() >> 16) + 22251), 1033 - ExpandableListView.getPackedPositionGroup(0L), 47343338, false, null, new Class[]{Integer.TYPE});
            }
            Object[] objArrAccessartificialFrame$78cbbd36 = HpkePrivateKeyManager$$ExternalSyntheticLambda2.accessartificialFrame$78cbbd35(iIntValue2, 0, ((Constructor) objAccessartificialFrame4).newInstance(objArr39), 146898996, false);
            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame5 == null) {
                int offsetAfter2 = 26 - TextUtils.getOffsetAfter("", 0);
                char cIndexOf4 = (char) TextUtils.indexOf("", "", 0);
                int iResolveOpacity2 = Drawable.resolveOpacity(0, 0) + 1041;
                byte b19 = (byte) ($$b << 2);
                byte b110 = $$a[12];
                Object[] objArr310 = new Object[1];
                b(b19, (byte) (b110 - 1), b110, objArr310);
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(offsetAfter2, cIndexOf4, iResolveOpacity2, 1145017376, false, (String) objArr310[0], null);
            }
            ((Field) objAccessartificialFrame5).set(null, objArrAccessartificialFrame$78cbbd36);
            Object[] objArr311 = new Object[1];
            a(23 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), new char[]{30, CoreConstants.COMMA_CHAR, 19, 28, ' ', 15, 17, '#', 31, 1, CoreConstants.SINGLE_QUOTE_CHAR, '\n', Typography.amp, 1, 26, 7, 25, '0', '$', '\"', '.', CoreConstants.LEFT_PARENTHESIS_CHAR}, (byte) (((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 7), objArr311);
            Class<?> cls11 = Class.forName((String) objArr311[0]);
            Object[] objArr312 = new Object[1];
            a(((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(0) - 22, new char[]{CharUtils.CR, CoreConstants.LEFT_PARENTHESIS_CHAR, 21, 2, 5, '\n', 21, '#', '\t', 26, '#', 27, 20, 25, 13942}, (byte) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 118), objArr312);
            Long lValueOf4 = Long.valueOf(((Long) cls11.getDeclaredMethod((String) objArr312[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-444530678);
            if (objAccessartificialFrame6 == null) {
                int packedPositionType2 = ExpandableListView.getPackedPositionType(0L) + 26;
                char edgeSlop2 = (char) (ViewConfiguration.getEdgeSlop() >> 16);
                int doubleTapTimeout2 = 1041 - (ViewConfiguration.getDoubleTapTimeout() >> 16);
                byte b111 = $$a[12];
                Object[] objArr313 = new Object[1];
                b((byte) 56, (byte) (b111 - 1), b111, objArr313);
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(packedPositionType2, edgeSlop2, doubleTapTimeout2, 2061780482, false, (String) objArr313[0], null);
            }
            ((Field) objAccessartificialFrame6).set(null, lValueOf4);
            objArr2 = objArrAccessartificialFrame$78cbbd36;
        }
        int i40 = ((int[]) objArr2[2])[0];
        int i41 = ((int[]) objArr2[3])[0];
        if (i41 == i40) {
            int i42 = getARTIFICIAL_FRAME_PACKAGE_NAME + 79;
            artificialFrame = i42 % 128;
            int i43 = i42 % 2;
            Object[] objArr40 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i44 = ((int[]) objArr2[1])[0];
            int i45 = ((int[]) objArr2[3])[0];
            int i46 = ((int[]) objArr2[2])[0];
            String[] strArr6 = (String[]) objArr2[0];
            int i47 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getDisplayMetrics().heightPixels;
            int i48 = i44 + 1215493546 + (((~(i47 | (-680921578))) | (-759025385)) * (-465)) + (((-680921578) | (~((-759025385) | i47))) * 930) + ((i47 | (-672401641)) * 465);
            int i49 = (i48 << 13) ^ i48;
            int i50 = i49 ^ (i49 >>> 17);
            ((int[]) objArr40[1])[0] = i50 ^ (i50 << 5);
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        String[] strArr7 = (String[]) objArr2[0];
        if (strArr7 != null) {
            for (String str2 : strArr7) {
                arrayList2.add(str2);
            }
        }
        Object[] objArr41 = {Long.valueOf(((long) (i40 ^ i41)) ^ (((long) 628683111) << 32)), Long.valueOf(628683109)};
        byte[] bArr4 = $$d;
        Object[] objArr42 = new Object[1];
        c((byte) (-bArr4[88]), (short) 54, (byte) (-bArr4[27]), objArr42);
        Class<?> cls12 = Class.forName((String) objArr42[0]);
        byte b20 = bArr4[29];
        Object[] objArr43 = new Object[1];
        c(b20, (short) (b20 | 544), (byte) 89, objArr43);
        cls12.getMethod((String) objArr43[0], Long.TYPE, Long.TYPE).invoke(null, objArr41);
        Object[] objArr44 = {strArr, new int[1], new int[]{i}, new int[]{i}};
        int i51 = ((int[]) objArr2[1])[0];
        int i52 = ((int[]) objArr2[3])[0];
        int i53 = ((int[]) objArr2[2])[0];
        String[] strArr8 = (String[]) objArr2[0];
        int iIdentityHashCode2 = System.identityHashCode(this);
        int i54 = ~iIdentityHashCode2;
        int i55 = (~(916890262 | i54)) | 155731201;
        int i56 = ~(iIdentityHashCode2 | (-77627395));
        int i57 = i51 + ((i55 | i56) * (-252)) + 667660794 + ((i56 | (~(i54 | 1072621463))) * 252);
        int i58 = (i57 << 13) ^ i57;
        int i59 = i58 ^ (i58 >>> 17);
        ((int[]) objArr44[1])[0] = i59 ^ (i59 << 5);
    }

    static {
        byte[] bArr = new byte[761];
        System.arraycopy("I\u0014Ó~ö=·\nóöþõG×êóöþõ!Þ\rúúïJüÛÉ\u0000\u000bï\u0000\tñ\u0015Ö\u0007ö\bÿí\u0007\u0002\u0013çð\u0007úÿ+Ðùÿöý\u0007÷\u0005\u001dÛÿé\nüú÷\u0003\u0018Óðþ;Ä\u0001úúÿïü\u00009¸\t\u0000úëBµ\bø\bï\töþï@Ñæ\u0004\u0002\u000fÛ\u0007û\u0011ÝüÿDüÛÉ\u0000\u000bï\u0000\tñ\u0015Ö\u0007ö\bÿí\u0007\u0002\u0013çð\u0007úÿ-ü¿ðþ;Ä\u0001úúÿïü\u00009Çþú÷ÿ3Æ÷ò\u00049×ìðù\t\u001fÝê\ný\u001bË\t\u0002ë\u0007öý'Ðþù\u000bë\ré\u0001ù\u001bÚ\u0001ü\u0000ÿ\u0000ïúüúîü\u000eëú\u0007ÿù\u0002ö\u0004ñ\"Ð\rð\u0004ðþ;Ä\u0001úúÿïü\u00009Éíü\u0000ÿ÷ÿôAéÍü ß÷ÿ#ßé\u000f9ïö=Á÷ô\rïú\u000fê\n3Äùó\tÿýê\n3Éï\tñï\u0001\u0007\u0002ìAØé\u0000úë\"éé\u0007ï\r\u001bÙó\tÿýê\n Ï\tñï\u0001\u0007\u0002ì\"Ú\u0007ë\u0005\u0003=üÛÉ\u0000\u000bï\u0000\tñ\u0015Ö\u0007ö\bÿí\u0007\u0002\u0013çð\u0007úÿ'ðþ;Ãôü\u0004÷\u00033Éï\u0006îÿ\u0002\u00012ÃööAÁ÷ö\u000bï\u0000\tñ:½ýýþñ\u0011å\tò\u0006öý\u000bùýë\u000bð\u0007û\u0002ùé\u0003\u0006ô\u0003ý2°ü\u0011ø÷\u0004ÿ÷<Çðÿü\u0003þë\u0007öý÷AçÐÿü\u0003þë\u0007öý÷$Ó\u0011ü\u0012Ñ\u000bï\rûò\u0003î$Óðùÿöý\u0007÷\u0005\u001eÍ\t\u0000é\u0007öýðþ;Ä\u0001úúÿïü\u00009Áø\böþñ\u0003õ\u0007õÿ÷\u00053Çðù\t3ÚÚÿ\u0007ë\u000eúï\u001bêðø\fó\u0007ú\u001báúë\u0001ùõQÝÐþù\u000bï\u0001öýï\u0006îÿ\u0002\u00012·ú\u0001üýùúB´>\u0002½\u0004ý÷\u0004/Ýäý÷\u0004\u001bÌÿô\u0000\nï+Ðþù\u000béLÍÚ\u000fë\fí\u0005õø\u0007öýðþ;Âûñ\u000fú÷û\u0004íü>Åé\u0011úñø\u0007öý÷AÝÐ2Ö\u0002úïÿ&É\u0011úñø\u0007öý\u0000ÿðü\u00009\u0001Á÷ö\u000bï\u0000\tñ:º\u0000\u0007é\nóù\u0001;Éï\u0006îÿ\u0002\u00012æÛûýïü\tý\rà\bô\u0002í/Ùÿíø\u000bïðþ;Ãôü\u0004÷\u00033Éï\u0006îÿ\u0002\u00012½\bé\u000bï\u0005\u0004ñ:Çðÿùù@µý\u0007ùÿñ\u0007\u0000îAæÇ\u0007\tð\u0000\u0002\u001cÐÿùùJüÛÉ\u0000\u000bï\u0000\tñ\u0015Ö\u0007ö\bÿí\u0007\u0002\u0013çð\u0007úÿ-".getBytes(CharEncoding.ISO_8859_1), 0, bArr, 0, 761);
        $$d = bArr;
        $$e = 158;
        $$a = new byte[]{96, -63, 33, 4, 9, -18, 34, -25, -4, 17, -19, Ascii.SI, 1, Ascii.DC2, -15, -19, Ascii.VT, -5, 7, 2, -15, 36, -21, -13, Ascii.SI, -2, -9, -6, 34, -15, -19, Ascii.VT, -5, 7, 9, -18, 36, -33, 19, -17, 32, -15, -19, Ascii.VT, -5, 7, 7, -18, 43, -29, 4, -17, -2, -5, 1, 33, -33, 2, 9, -5, 7, -5, 1, 50, -39, -11, 7, Ascii.FF, -15, -49, -2, Ascii.VT, 3, -3, 6, -6, 8, -11, Ascii.EM, -33, 19, -2, -8, 37, -44, 17, -12, 8, -14, 2, -15, 33, -33, 19, -17, 32, -15, -19, Ascii.VT, -5, 7, -10, Ascii.US, -20, -13, 8, Ascii.VT, Ascii.CR, -27, -27, -1, 7, 6, 33, -51, Ascii.FF, -3, 8, -1, -13};
        $$b = 12;
        getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
        artificialFrame = 1;
        ArtificialStackFrames = new char[]{44400, 44702, 44340, 44403, 44405, 44336, 44390, 44353, 44372, 44337, 44406, 44371, 44389, 44386, 44388, 44344, 44339, 44392, 44393, 44394, 44698, 44404, 44341, 44385, 44391, 44696, 44360, 44397, 44370, 44399, 44700, 44407, 44338, 44402, 44697, 44703, 44409, 44398, 44334, 44395, 44342, 44396, 44345, 44699, 44384, 44343, 44355, 44387, 44401};
        coroutineCreation = (char) 39069;
    }
}
