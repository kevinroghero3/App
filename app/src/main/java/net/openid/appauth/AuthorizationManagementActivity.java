package net.openid.appauth;

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
import com.google.android.gms.stats.zza;
import com.google.common.base.Ascii;
import com.google.common.collect.CompactHashMap;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import net.openid.appauth.internal.Logger;
import o.ArtificialStackFrames;
import o.onNavigationEvent;
import org.apache.commons.lang3.CharEncoding;
import org.apache.commons.lang3.CharUtils;
import org.json.JSONException;

/* JADX INFO: loaded from: classes6.dex */
public class AuthorizationManagementActivity extends AppCompatActivity {
    private static final byte[] $$a;
    private static final int $$b;
    private static final byte[] $$d;
    private static final int $$e;
    static final String KEY_AUTHORIZATION_STARTED = "authStarted";
    static final String KEY_AUTH_INTENT = "authIntent";
    static final String KEY_AUTH_REQUEST = "authRequest";
    static final String KEY_AUTH_REQUEST_TYPE = "authRequestType";
    static final String KEY_CANCEL_INTENT = "cancelIntent";
    static final String KEY_COMPLETE_INTENT = "completeIntent";
    private static int artificialFrame;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME;
    private static int setDefaultImpl;
    private Intent mAuthIntent;
    private AuthorizationManagementRequest mAuthRequest;
    private boolean mAuthorizationStarted = false;
    private PendingIntent mCancelIntent;
    private PendingIntent mCompleteIntent;
    private static final byte[] $$c = {52, -35, -61, -47};
    private static final int $$f = 57;
    private static int $10 = 0;
    private static int $11 = 1;

    /* JADX WARN: Code duplicated, block: B:10:0x0024  */
    /* JADX WARN: Code duplicated, block: B:8:0x001e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0024 -> B:11:0x002c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0024
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$g(byte r6, short r7, byte r8) {
        /*
            int r6 = r6 * 2
            int r0 = 1 - r6
            int r8 = r8 * 3
            int r8 = r8 + 4
            int r7 = r7 * 2
            int r7 = r7 + 114
            byte[] r1 = net.openid.appauth.AuthorizationManagementActivity.$$c
            byte[] r0 = new byte[r0]
            r2 = 0
            int r6 = 0 - r6
            if (r1 != 0) goto L18
            r3 = r8
            r4 = r2
            goto L2c
        L18:
            r3 = r2
        L19:
            byte r4 = (byte) r7
            r0[r3] = r4
            if (r3 != r6) goto L24
            java.lang.String r6 = new java.lang.String
            r6.<init>(r0, r2)
            return r6
        L24:
            r4 = r1[r8]
            int r3 = r3 + 1
            r5 = r3
            r3 = r8
            r8 = r4
            r4 = r5
        L2c:
            int r7 = r7 + r8
            int r8 = r3 + 1
            r3 = r4
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: net.openid.appauth.AuthorizationManagementActivity.$$g(byte, short, byte):java.lang.String");
    }

    private static void b(short s, int i, int i2, Object[] objArr) {
        byte[] bArr = $$a;
        int i3 = i + 65;
        int i4 = s + 4;
        byte[] bArr2 = new byte[i2 + 8];
        int i5 = i2 + 7;
        int i6 = -1;
        if (bArr == null) {
            i4++;
            i3 += -i5;
        }
        while (true) {
            i6++;
            bArr2[i6] = (byte) i3;
            if (i6 == i5) {
                objArr[0] = new String(bArr2, 0);
                return;
            } else {
                i4++;
                i3 += -bArr[i4];
            }
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
    private static void c(int r6, int r7, short r8, java.lang.Object[] r9) {
        /*
            int r8 = 111 - r8
            byte[] r0 = net.openid.appauth.AuthorizationManagementActivity.$$d
            int r6 = 67 - r6
            int r7 = 635 - r7
            byte[] r1 = new byte[r6]
            r2 = 0
            if (r0 != 0) goto L11
            r4 = r6
            r8 = r7
            r3 = r2
            goto L26
        L11:
            r3 = r2
        L12:
            byte r4 = (byte) r8
            r1[r3] = r4
            int r3 = r3 + 1
            if (r3 != r6) goto L21
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L21:
            r4 = r0[r7]
            r5 = r8
            r8 = r7
            r7 = r5
        L26:
            int r7 = r7 + r4
            int r8 = r8 + 1
            int r7 = r7 + (-4)
            r5 = r8
            r8 = r7
            r7 = r5
            goto L12
        */
        throw new UnsupportedOperationException("Method not decompiled: net.openid.appauth.AuthorizationManagementActivity.c(int, int, short, java.lang.Object[]):void");
    }

    private static void a(boolean z, int i, int i2, int i3, char[] cArr, Object[] objArr) throws Throwable {
        int i4 = 2 % 2;
        onNavigationEvent onnavigationevent = new onNavigationEvent();
        char[] cArr2 = new char[i3];
        onnavigationevent.d = 0;
        while (onnavigationevent.d < i3) {
            onnavigationevent.c = cArr[onnavigationevent.d];
            cArr2[onnavigationevent.d] = (char) (i2 + onnavigationevent.c);
            int i5 = onnavigationevent.d;
            try {
                Object[] objArr2 = {Integer.valueOf(cArr2[i5]), Integer.valueOf(setDefaultImpl)};
                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(465886069);
                if (objAccessartificialFrame == null) {
                    byte b = (byte) 0;
                    byte b2 = b;
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(22 - (ViewConfiguration.getFadingEdgeLength() >> 16), (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)), KeyEvent.normalizeMetaState(0) + 1775, -2069783171, false, $$g(b, b2, b2), new Class[]{Integer.TYPE, Integer.TYPE});
                }
                cArr2[i5] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                Object[] objArr3 = {onnavigationevent, onnavigationevent};
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1257606387);
                if (objAccessartificialFrame2 == null) {
                    byte b3 = (byte) 0;
                    byte b4 = (byte) (b3 + 1);
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(36 - TextUtils.lastIndexOf("", '0', 0, 0), (char) (KeyEvent.normalizeMetaState(0) + 56277), View.MeasureSpec.getSize(0) + 1259, 711931141, false, $$g(b3, b4, (byte) (b4 - 1)), new Class[]{Object.class, Object.class});
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
            onnavigationevent.b = i;
            char[] cArr3 = new char[i3];
            System.arraycopy(cArr2, 0, cArr3, 0, i3);
            System.arraycopy(cArr3, 0, cArr2, i3 - onnavigationevent.b, onnavigationevent.b);
            System.arraycopy(cArr3, onnavigationevent.b, cArr2, 0, i3 - onnavigationevent.b);
        }
        if (z) {
            int i6 = $10 + 13;
            $11 = i6 % 128;
            int i7 = i6 % 2;
            char[] cArr4 = new char[i3];
            onnavigationevent.d = 0;
            while (onnavigationevent.d < i3) {
                int i8 = $11 + AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
                $10 = i8 % 128;
                int i9 = i8 % 2;
                cArr4[onnavigationevent.d] = cArr2[(i3 - onnavigationevent.d) - 1];
                Object[] objArr4 = {onnavigationevent, onnavigationevent};
                Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1257606387);
                if (objAccessartificialFrame3 == null) {
                    byte b5 = (byte) 0;
                    byte b6 = (byte) (b5 + 1);
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(ExpandableListView.getPackedPositionGroup(0L) + 37, (char) (56277 - Color.red(0)), Gravity.getAbsoluteGravity(0, 0) + 1259, 711931141, false, $$g(b5, b6, (byte) (b6 - 1)), new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame3).invoke(null, objArr4);
            }
            cArr2 = cArr4;
        }
        objArr[0] = new String(cArr2);
    }

    public static Intent createStartIntent(Context context, AuthorizationManagementRequest authorizationManagementRequest, Intent intent, PendingIntent pendingIntent, PendingIntent pendingIntent2) {
        Intent intentCreateBaseIntent = createBaseIntent(context);
        intentCreateBaseIntent.putExtra(KEY_AUTH_INTENT, intent);
        intentCreateBaseIntent.putExtra(KEY_AUTH_REQUEST, authorizationManagementRequest.jsonSerializeString());
        intentCreateBaseIntent.putExtra(KEY_AUTH_REQUEST_TYPE, AuthorizationManagementUtil.requestTypeFor(authorizationManagementRequest));
        intentCreateBaseIntent.putExtra(KEY_COMPLETE_INTENT, pendingIntent);
        intentCreateBaseIntent.putExtra(KEY_CANCEL_INTENT, pendingIntent2);
        return intentCreateBaseIntent;
    }

    public static Intent createStartForResultIntent(Context context, AuthorizationManagementRequest authorizationManagementRequest, Intent intent) {
        return createStartIntent(context, authorizationManagementRequest, intent, null, null);
    }

    public static Intent createResponseHandlingIntent(Context context, Uri uri) {
        Intent intentCreateBaseIntent = createBaseIntent(context);
        intentCreateBaseIntent.setData(uri);
        intentCreateBaseIntent.addFlags(603979776);
        return intentCreateBaseIntent;
    }

    private static Intent createBaseIntent(Context context) {
        return new Intent(context, (Class<?>) AuthorizationManagementActivity.class);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            extractState(getIntent().getExtras());
        } else {
            extractState(bundle);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (!this.mAuthorizationStarted) {
            try {
                startActivity(this.mAuthIntent);
                this.mAuthorizationStarted = true;
                return;
            } catch (ActivityNotFoundException unused) {
                handleBrowserNotFound();
                finish();
                return;
            }
        }
        if (getIntent().getData() != null) {
            handleAuthorizationComplete();
        } else {
            handleAuthorizationCanceled();
        }
        finish();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(KEY_AUTHORIZATION_STARTED, this.mAuthorizationStarted);
        bundle.putParcelable(KEY_AUTH_INTENT, this.mAuthIntent);
        bundle.putString(KEY_AUTH_REQUEST, this.mAuthRequest.jsonSerializeString());
        bundle.putString(KEY_AUTH_REQUEST_TYPE, AuthorizationManagementUtil.requestTypeFor(this.mAuthRequest));
        bundle.putParcelable(KEY_COMPLETE_INTENT, this.mCompleteIntent);
        bundle.putParcelable(KEY_CANCEL_INTENT, this.mCancelIntent);
    }

    private void handleAuthorizationComplete() {
        Uri data = getIntent().getData();
        Intent intentExtractResponseData = extractResponseData(data);
        if (intentExtractResponseData == null) {
            Logger.error("Failed to extract OAuth2 response from redirect", new Object[0]);
        } else {
            intentExtractResponseData.setData(data);
            sendResult(this.mCompleteIntent, intentExtractResponseData, -1);
        }
    }

    private void handleAuthorizationCanceled() {
        Logger.debug("Authorization flow canceled by user", new Object[0]);
        sendResult(this.mCancelIntent, AuthorizationException.fromTemplate(AuthorizationException.GeneralErrors.USER_CANCELED_AUTH_FLOW, null).toIntent(), 0);
    }

    private void handleBrowserNotFound() {
        Logger.debug("Authorization flow canceled due to missing browser", new Object[0]);
        sendResult(this.mCancelIntent, AuthorizationException.fromTemplate(AuthorizationException.GeneralErrors.PROGRAM_CANCELED_AUTH_FLOW, null).toIntent(), 0);
    }

    private void extractState(Bundle bundle) {
        if (bundle == null) {
            Logger.warn("No stored state - unable to handle response", new Object[0]);
            finish();
            return;
        }
        this.mAuthIntent = (Intent) bundle.getParcelable(KEY_AUTH_INTENT);
        this.mAuthorizationStarted = bundle.getBoolean(KEY_AUTHORIZATION_STARTED, false);
        this.mCompleteIntent = (PendingIntent) bundle.getParcelable(KEY_COMPLETE_INTENT);
        this.mCancelIntent = (PendingIntent) bundle.getParcelable(KEY_CANCEL_INTENT);
        try {
            String string = bundle.getString(KEY_AUTH_REQUEST, null);
            this.mAuthRequest = string != null ? AuthorizationManagementUtil.requestFrom(string, bundle.getString(KEY_AUTH_REQUEST_TYPE, null)) : null;
        } catch (JSONException unused) {
            sendResult(this.mCancelIntent, AuthorizationException.AuthorizationRequestErrors.INVALID_REQUEST.toIntent(), 0);
        }
    }

    private void sendResult(PendingIntent pendingIntent, Intent intent, int i) {
        if (pendingIntent != null) {
            try {
                pendingIntent.send(this, 0, intent);
                return;
            } catch (PendingIntent.CanceledException e) {
                Logger.error("Failed to send cancel intent", e);
                return;
            }
        }
        setResult(i, intent);
    }

    private Intent extractResponseData(Uri uri) {
        if (uri.getQueryParameterNames().contains("error")) {
            return AuthorizationException.fromOAuthRedirect(uri).toIntent();
        }
        AuthorizationManagementResponse authorizationManagementResponseResponseWith = AuthorizationManagementUtil.responseWith(this.mAuthRequest, uri);
        if ((this.mAuthRequest.getState() == null && authorizationManagementResponseResponseWith.getState() != null) || (this.mAuthRequest.getState() != null && !this.mAuthRequest.getState().equals(authorizationManagementResponseResponseWith.getState()))) {
            Logger.warn("State returned in authorization response (%s) does not match state from request (%s) - discarding response", authorizationManagementResponseResponseWith.getState(), this.mAuthRequest.getState());
            return AuthorizationException.AuthorizationRequestErrors.STATE_MISMATCH.toIntent();
        }
        return authorizationManagementResponseResponseWith.toIntent();
    }

    /* JADX WARN: Code duplicated, block: B:104:0x0d3a  */
    /* JADX WARN: Code duplicated, block: B:108:0x0d93  */
    /* JADX WARN: Code duplicated, block: B:109:0x0e03  */
    /* JADX WARN: Code duplicated, block: B:114:0x0f0e  */
    /* JADX WARN: Code duplicated, block: B:123:0x1026  */
    /* JADX WARN: Code duplicated, block: B:126:0x102f A[Catch: all -> 0x283f, TryCatch #10 {all -> 0x283f, blocks: (B:224:0x1b92, B:226:0x1b9f, B:227:0x1bd1, B:229:0x1bdb, B:231:0x1be8, B:232:0x1c1e, B:159:0x14a2, B:161:0x14b7, B:162:0x14ee, B:124:0x1029, B:126:0x102f, B:127:0x105c, B:129:0x1086, B:130:0x1114, B:14:0x02eb, B:16:0x030c, B:17:0x0364), top: B:382:0x02eb }] */
    /* JADX WARN: Code duplicated, block: B:129:0x1086 A[Catch: all -> 0x283f, TryCatch #10 {all -> 0x283f, blocks: (B:224:0x1b92, B:226:0x1b9f, B:227:0x1bd1, B:229:0x1bdb, B:231:0x1be8, B:232:0x1c1e, B:159:0x14a2, B:161:0x14b7, B:162:0x14ee, B:124:0x1029, B:126:0x102f, B:127:0x105c, B:129:0x1086, B:130:0x1114, B:14:0x02eb, B:16:0x030c, B:17:0x0364), top: B:382:0x02eb }] */
    /* JADX WARN: Code duplicated, block: B:133:0x1127  */
    /* JADX WARN: Code duplicated, block: B:138:0x1190  */
    /* JADX WARN: Code duplicated, block: B:142:0x11e3  */
    /* JADX WARN: Code duplicated, block: B:143:0x1250  */
    /* JADX WARN: Code duplicated, block: B:148:0x133d  */
    /* JADX WARN: Code duplicated, block: B:158:0x1485  */
    /* JADX WARN: Code duplicated, block: B:161:0x14b7 A[Catch: all -> 0x283f, TryCatch #10 {all -> 0x283f, blocks: (B:224:0x1b92, B:226:0x1b9f, B:227:0x1bd1, B:229:0x1bdb, B:231:0x1be8, B:232:0x1c1e, B:159:0x14a2, B:161:0x14b7, B:162:0x14ee, B:124:0x1029, B:126:0x102f, B:127:0x105c, B:129:0x1086, B:130:0x1114, B:14:0x02eb, B:16:0x030c, B:17:0x0364), top: B:382:0x02eb }] */
    /* JADX WARN: Code duplicated, block: B:165:0x1505  */
    /* JADX WARN: Code duplicated, block: B:170:0x1571  */
    /* JADX WARN: Code duplicated, block: B:174:0x15cd  */
    /* JADX WARN: Code duplicated, block: B:175:0x1640  */
    /* JADX WARN: Code duplicated, block: B:177:0x164c  */
    /* JADX WARN: Code duplicated, block: B:180:0x1650 A[LOOP:1: B:178:0x164d->B:180:0x1650, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:186:0x1745  */
    /* JADX WARN: Code duplicated, block: B:189:0x1796  */
    /* JADX WARN: Code duplicated, block: B:191:0x17b7  */
    /* JADX WARN: Code duplicated, block: B:193:0x17c0  */
    /* JADX WARN: Code duplicated, block: B:196:0x187d  */
    /* JADX WARN: Code duplicated, block: B:197:0x187f  */
    /* JADX WARN: Code duplicated, block: B:200:0x1886  */
    /* JADX WARN: Code duplicated, block: B:202:0x19b4  */
    /* JADX WARN: Code duplicated, block: B:208:0x19c4  */
    /* JADX WARN: Code duplicated, block: B:213:0x1a61  */
    /* JADX WARN: Code duplicated, block: B:218:0x1acb  */
    /* JADX WARN: Code duplicated, block: B:222:0x1b26  */
    /* JADX WARN: Code duplicated, block: B:223:0x1b8d  */
    /* JADX WARN: Code duplicated, block: B:226:0x1b9f A[Catch: all -> 0x283f, TryCatch #10 {all -> 0x283f, blocks: (B:224:0x1b92, B:226:0x1b9f, B:227:0x1bd1, B:229:0x1bdb, B:231:0x1be8, B:232:0x1c1e, B:159:0x14a2, B:161:0x14b7, B:162:0x14ee, B:124:0x1029, B:126:0x102f, B:127:0x105c, B:129:0x1086, B:130:0x1114, B:14:0x02eb, B:16:0x030c, B:17:0x0364), top: B:382:0x02eb }] */
    /* JADX WARN: Code duplicated, block: B:231:0x1be8 A[Catch: all -> 0x283f, TryCatch #10 {all -> 0x283f, blocks: (B:224:0x1b92, B:226:0x1b9f, B:227:0x1bd1, B:229:0x1bdb, B:231:0x1be8, B:232:0x1c1e, B:159:0x14a2, B:161:0x14b7, B:162:0x14ee, B:124:0x1029, B:126:0x102f, B:127:0x105c, B:129:0x1086, B:130:0x1114, B:14:0x02eb, B:16:0x030c, B:17:0x0364), top: B:382:0x02eb }] */
    /* JADX WARN: Code duplicated, block: B:238:0x1d06  */
    /* JADX WARN: Code duplicated, block: B:241:0x1d59  */
    /* JADX WARN: Code duplicated, block: B:243:0x1d77  */
    /* JADX WARN: Code duplicated, block: B:245:0x1d80  */
    /* JADX WARN: Code duplicated, block: B:247:0x1e2e  */
    /* JADX WARN: Code duplicated, block: B:248:0x1e30  */
    /* JADX WARN: Code duplicated, block: B:251:0x1e37  */
    /* JADX WARN: Code duplicated, block: B:253:0x1ee4  */
    /* JADX WARN: Code duplicated, block: B:255:0x1ef2  */
    /* JADX WARN: Code duplicated, block: B:259:0x1efe  */
    /* JADX WARN: Code duplicated, block: B:263:0x1f88  */
    /* JADX WARN: Code duplicated, block: B:265:0x1f91  */
    /* JADX WARN: Code duplicated, block: B:270:0x2002  */
    /* JADX WARN: Code duplicated, block: B:276:0x206b  */
    /* JADX WARN: Code duplicated, block: B:277:0x20e0  */
    /* JADX WARN: Code duplicated, block: B:282:0x21cb  */
    /* JADX WARN: Code duplicated, block: B:285:0x2212  */
    /* JADX WARN: Code duplicated, block: B:291:0x2304  */
    /* JADX WARN: Code duplicated, block: B:293:0x230b  */
    /* JADX WARN: Code duplicated, block: B:295:0x23eb  */
    /* JADX WARN: Code duplicated, block: B:297:0x23f7  */
    /* JADX WARN: Code duplicated, block: B:300:0x2400  */
    /* JADX WARN: Code duplicated, block: B:302:0x2404  */
    /* JADX WARN: Code duplicated, block: B:305:0x240e  */
    /* JADX WARN: Code duplicated, block: B:311:0x25ae  */
    /* JADX WARN: Code duplicated, block: B:313:0x25b7  */
    /* JADX WARN: Code duplicated, block: B:318:0x2618  */
    /* JADX WARN: Code duplicated, block: B:325:0x266a  */
    /* JADX WARN: Code duplicated, block: B:326:0x26eb  */
    /* JADX WARN: Code duplicated, block: B:328:0x26f7  */
    /* JADX WARN: Code duplicated, block: B:331:0x26fb A[LOOP:0: B:329:0x26f8->B:331:0x26fb, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:80:0x09b0  */
    /* JADX WARN: Code duplicated, block: B:81:0x0a19  */
    /* JADX WARN: Code duplicated, block: B:86:0x0b11  */
    /* JADX WARN: Code duplicated, block: B:95:0x0c47  */
    /* JADX WARN: Code duplicated, block: B:99:0x0ccd  */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onStart() throws Throwable {
        Object[] objArr;
        int i;
        Context baseContext;
        Object[] objArr2;
        int i2;
        int i3;
        int i4;
        Object objAccessartificialFrame;
        long j;
        Object[] objArr3;
        Object objAccessartificialFrame2;
        Object objAccessartificialFrame3;
        int i5;
        int i6;
        Object objAccessartificialFrame4;
        long j2;
        Object objAccessartificialFrame5;
        Object objAccessartificialFrame6;
        Object[] objArr4;
        Object objAccessartificialFrame7;
        Object objAccessartificialFrame8;
        Object obj;
        int i7;
        Object obj2;
        int i8;
        int i9;
        Object objAccessartificialFrame9;
        long j3;
        Object objAccessartificialFrame10;
        Object[] objArrAccessartificialFrame$78cbbd35;
        Object objAccessartificialFrame11;
        Object objAccessartificialFrame12;
        int i10;
        int i11;
        ArrayList arrayList;
        String[] strArr;
        int i12;
        Object objAccessartificialFrame13;
        long j4;
        int i13;
        Context baseContext2;
        Object[] objArr5;
        Object objAccessartificialFrame14;
        Object objAccessartificialFrame15;
        int i14;
        int i15;
        Object objAccessartificialFrame16;
        Object objAccessartificialFrame17;
        int i16;
        Object objAccessartificialFrame18;
        long j5;
        int i17;
        Context baseContext3;
        Object[] objArr6;
        Object objAccessartificialFrame19;
        Object objAccessartificialFrame20;
        int i18;
        int i19;
        Object objAccessartificialFrame21;
        long j6;
        Context baseContext4;
        Object[] objArr7;
        Object[] objArr8;
        int i20;
        Object objAccessartificialFrame22;
        Object objAccessartificialFrame23;
        int i21;
        int i22;
        int i23;
        ArrayList arrayList2;
        String[] strArr2;
        int i24;
        Object objAccessartificialFrame24;
        Object objAccessartificialFrame25;
        int i25 = 2 % 2;
        int i26 = 0;
        Object[] objArr9 = new Object[1];
        a(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(0) - 32, (android.os.SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (android.os.SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 263, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 18, new char[]{'\f', 15, 1, 11, 65534, '\b', 0, '\f', '\t', 65504, '\n', 2, 17, 16, 22, 65520, 65483, 16, '\f', 65483, 1, 6}, objArr9);
        String str = (String) objArr9[0];
        Object[] objArr10 = new Object[1];
        a(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 10, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 233, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(1) - 34, new char[]{6, 2, CharUtils.CR, 5, 65530, 65534, 65515, 65533, 65534, '\f', '\t', 65530, 5, 65534, 65534}, objArr10);
        String str2 = (String) objArr10[0];
        Object[] objArr11 = new Object[1];
        a(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 5, (ViewConfiguration.getKeyRepeatDelay() >> 16) + 263, 16 - View.getDefaultSize(0, 0), new char[]{11, 3, 18, 17, 23, 65521, 65484, 5, '\f', 65535, '\n', 65484, 65535, 20, 65535, '\b'}, objArr11);
        String str3 = (String) objArr11[0];
        Object[] objArr12 = new Object[1];
        a(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(3) - 101, 267 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(1) - 85, new char[]{'\t', 65501, 2, CharUtils.CR, 65531, 65506, 19, 14, 3, 14, '\b', 65535, 65534, 3, 65535, 65534}, objArr12);
        String str4 = (String) objArr12[0];
        Object objAccessartificialFrame26 = ArtificialStackFrames.accessartificialFrame(-1268268649);
        if (objAccessartificialFrame26 == null) {
            int capsMode = TextUtils.getCapsMode("", 0, 0) + 25;
            char cLastIndexOf = (char) (30067 - TextUtils.lastIndexOf("", '0', 0, 0));
            int iAxisFromString = MotionEvent.axisFromString("") + 817;
            byte b = $$a[5];
            byte b2 = (byte) (b - 1);
            Object[] objArr13 = new Object[1];
            b(b2, (byte) (b2 | 47), b, objArr13);
            objAccessartificialFrame26 = ArtificialStackFrames.coroutineCreation(capsMode, cLastIndexOf, iAxisFromString, 721586079, false, (String) objArr13[0], null);
        }
        long j7 = ((Field) objAccessartificialFrame26).getLong(null);
        if (j7 == -1 || j7 + 2000 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
            try {
                Object[] objArr14 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 519732945};
                Object objAccessartificialFrame27 = ArtificialStackFrames.accessartificialFrame(1327366003);
                if (objAccessartificialFrame27 == null) {
                    int i27 = 26 - (android.os.SystemClock.elapsedRealtime() > 0L ? 1 : (android.os.SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                    char doubleTapTimeout = (char) (30068 - (ViewConfiguration.getDoubleTapTimeout() >> 16));
                    int maximumFlingVelocity = (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 816;
                    byte b3 = (byte) ($$b & 116);
                    byte[] bArr = $$a;
                    Object[] objArr15 = new Object[1];
                    b(b3, bArr[65], bArr[117], objArr15);
                    objAccessartificialFrame27 = ArtificialStackFrames.coroutineCreation(i27, doubleTapTimeout, maximumFlingVelocity, -797394565, false, (String) objArr15[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                }
                Object[] objArr16 = (Object[]) ((Method) objAccessartificialFrame27).invoke(null, objArr14);
                Object objAccessartificialFrame28 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame28 == null) {
                    int gidForName = Process.getGidForName("") + 26;
                    char cLastIndexOf2 = (char) (TextUtils.lastIndexOf("", '0', 0, 0) + 30069);
                    int i28 = (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 816;
                    byte[] bArr2 = $$a;
                    byte b4 = bArr2[28];
                    Object[] objArr17 = new Object[1];
                    b(b4, (byte) (b4 | 39), bArr2[5], objArr17);
                    objAccessartificialFrame28 = ArtificialStackFrames.coroutineCreation(gidForName, cLastIndexOf2, i28, 891606461, false, (String) objArr17[0], null);
                }
                ((Field) objAccessartificialFrame28).set(null, objArr16);
                try {
                    Long lValueOf = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame29 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                    if (objAccessartificialFrame29 == null) {
                        int keyRepeatDelay = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 25;
                        char c = (char) (30069 - (android.os.SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (android.os.SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)));
                        int i29 = 816 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                        byte b5 = $$a[5];
                        byte b6 = (byte) (b5 - 1);
                        Object[] objArr18 = new Object[1];
                        b(b6, (byte) (b6 | 47), b5, objArr18);
                        objAccessartificialFrame29 = ArtificialStackFrames.coroutineCreation(keyRepeatDelay, c, i29, 721586079, false, (String) objArr18[0], null);
                    }
                    ((Field) objAccessartificialFrame29).set(null, lValueOf);
                    objArr = objArr16;
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
        } else {
            Object objAccessartificialFrame30 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame30 == null) {
                int iIndexOf = TextUtils.indexOf((CharSequence) "", '0', 0) + 26;
                char cCombineMeasuredStates = (char) (View.combineMeasuredStates(0, 0) + 30068);
                int i30 = (android.os.SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (android.os.SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 815;
                byte[] bArr3 = $$a;
                byte b7 = bArr3[28];
                Object[] objArr19 = new Object[1];
                b(b7, (byte) (b7 | 39), bArr3[5], objArr19);
                objAccessartificialFrame30 = ArtificialStackFrames.coroutineCreation(iIndexOf, cCombineMeasuredStates, i30, 891606461, false, (String) objArr19[0], null);
            }
            Object[] objArr20 = (Object[]) ((Field) objAccessartificialFrame30).get(null);
            objArr = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i31 = ((int[]) objArr20[0])[0];
            int i32 = ((int[]) objArr20[1])[0];
            String[] strArr3 = (String[]) objArr20[2];
            int startUptimeMillis = (int) Process.getStartUptimeMillis();
            int i33 = (-1148354397) + (((~startUptimeMillis) | 338813234) * 1444) + (((~(startUptimeMillis | (-75172211))) | (~(273344576 | startUptimeMillis)) | 70320434) * (-1444)) + 709713147;
            int i34 = (i33 << 13) ^ i33;
            int i35 = i34 ^ (i34 >>> 17);
            ((int[]) objArr[3])[0] = i35 ^ (i35 << 5);
        }
        int i36 = ((int[]) objArr[1])[0];
        int i37 = ((int[]) objArr[0])[0];
        if (i37 == i36) {
            Object[] objArr21 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i38 = ((int[]) objArr[3])[0];
            int i39 = ((int[]) objArr[0])[0];
            int i40 = ((int[]) objArr[1])[0];
            String[] strArr4 = (String[]) objArr[2];
            int i41 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().navigation;
            int i42 = (~(743453472 | i41)) | 270532814;
            int i43 = ~((~i41) | (-72360449));
            int i44 = i38 + (-1500423935) + ((i42 | i43) * (-470)) + (((~(i41 | 1013986286)) | i43) * 470);
            int i45 = (i44 << 13) ^ i44;
            int i46 = i45 ^ (i45 >>> 17);
            ((int[]) objArr21[3])[0] = i46 ^ (i46 << 5);
        } else {
            ArrayList arrayList3 = new ArrayList();
            String[] strArr5 = (String[]) objArr[2];
            if (strArr5 != null) {
                for (String str5 : strArr5) {
                    arrayList3.add(str5);
                }
            }
            long j8 = ((long) (i36 ^ i37)) ^ (((long) 331204178) << 32);
            long j9 = 331204179;
            int i47 = getARTIFICIAL_FRAME_PACKAGE_NAME + 117;
            artificialFrame = i47 % 128;
            int i48 = i47 % 2;
            try {
                Object[] objArr22 = {Long.valueOf(j8), Long.valueOf(j9)};
                byte[] bArr4 = $$d;
                Object[] objArr23 = new Object[1];
                c((byte) (-bArr4[588]), (short) 631, bArr4[8], objArr23);
                Class<?> cls = Class.forName((String) objArr23[0]);
                byte b8 = (byte) (-bArr4[81]);
                Object[] objArr24 = new Object[1];
                c(b8, (short) (b8 | 529), bArr4[232], objArr24);
                cls.getMethod((String) objArr24[0], Long.TYPE, Long.TYPE).invoke(null, objArr22);
                Object[] objArr25 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i49 = ((int[]) objArr[3])[0];
                int i50 = ((int[]) objArr[0])[0];
                int i51 = ((int[]) objArr[1])[0];
                String[] strArr6 = (String[]) objArr[2];
                int mode = ((AudioManager) ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getSystemService("audio")).getMode();
                int i52 = i49 + 1405358087 + (((~(151820103 | mode)) | 46350464) * (-140)) + ((~(198170567 | mode)) * 70) + (((~(mode | 46352262)) | 198168769) * 70);
                int i53 = (i52 << 13) ^ i52;
                int i54 = i53 ^ (i53 >>> 17);
                i26 = 0;
                ((int[]) objArr25[3])[0] = i54 ^ (i54 << 5);
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 == null) {
                    throw th2;
                }
                throw cause2;
            }
        }
        Object objAccessartificialFrame31 = ArtificialStackFrames.accessartificialFrame(-1283093189);
        if (objAccessartificialFrame31 == null) {
            int threadPriority = ((Process.getThreadPriority(i26) + 20) >> 6) + 30;
            char c2 = (char) (49361 - (ExpandableListView.getPackedPositionForChild(i26, i26) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(i26, i26) == 0L ? 0 : -1)));
            int i55 = 685 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1));
            byte[] bArr5 = $$a;
            Object[] objArr26 = new Object[1];
            b((byte) (-bArr5[20]), (byte) 45, bArr5[28], objArr26);
            objAccessartificialFrame31 = ArtificialStackFrames.coroutineCreation(threadPriority, c2, i55, 752929587, false, (String) objArr26[0], null);
        }
        long j10 = ((Field) objAccessartificialFrame31).getLong(null);
        try {
            try {
                if (j10 != -1) {
                    if (j10 + 2009 >= ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                        Object objAccessartificialFrame32 = ArtificialStackFrames.accessartificialFrame(-326560385);
                        if (objAccessartificialFrame32 == null) {
                            int i56 = (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 30;
                            char cAxisFromString = (char) (49361 - MotionEvent.axisFromString(""));
                            int jumpTapTimeout = (ViewConfiguration.getJumpTapTimeout() >> 16) + 684;
                            byte[] bArr6 = $$a;
                            byte b9 = (byte) (bArr6[115] - 1);
                            Object[] objArr27 = new Object[1];
                            b(b9, (byte) (b9 - 4), bArr6[28], objArr27);
                            objAccessartificialFrame32 = ArtificialStackFrames.coroutineCreation(i56, cAxisFromString, jumpTapTimeout, 1944867703, false, (String) objArr27[0], null);
                        }
                        Object[] objArr28 = (Object[]) ((Field) objAccessartificialFrame32).get(null);
                        objArr2 = new Object[]{new int[]{((int[]) objArr28[0])[0]}, new int[]{((int[]) objArr28[1])[0]}, new int[1], (String) objArr28[3]};
                        int iIdentityHashCode = System.identityHashCode(this);
                        int i57 = ~iIdentityHashCode;
                        int i58 = (-289408382) + (((~((-75441429) | i57)) | (~((-903182347) | iIdentityHashCode))) * 210) + (((~(iIdentityHashCode | (-2753813))) | (~(i57 | (-830494731)))) * 210) + 1558156163;
                        int i59 = (i58 << 13) ^ i58;
                        int i60 = i59 ^ (i59 >>> 17);
                        ((int[]) objArr2[2])[0] = i60 ^ (i60 << 5);
                    } else {
                        i = 0;
                    }
                    i2 = ((int[]) objArr2[1])[0];
                    i3 = ((int[]) objArr2[0])[0];
                    if (i3 == i2) {
                        int i61 = ((int[]) objArr2[2])[0];
                        Object[] objArr29 = {new int[]{((int[]) objArr2[0])[0]}, new int[]{((int[]) objArr2[1])[0]}, new int[1], (String) objArr2[3]};
                        int iIdentityHashCode2 = System.identityHashCode(this);
                        int i62 = (~((-537016887) | iIdentityHashCode2)) | 139808;
                        int i63 = ~((~iIdentityHashCode2) | 978483966);
                        int i64 = i61 + 1044333534 + ((i62 | i63) * (-470)) + (((~(iIdentityHashCode2 | (-536877079))) | i63) * 470);
                        int i65 = (i64 << 13) ^ i64;
                        int i66 = i65 ^ (i65 >>> 17);
                        i4 = 0;
                        ((int[]) objArr29[2])[0] = i66 ^ (i66 << 5);
                    } else {
                        Object[] objArr30 = {Long.valueOf(((long) (i2 ^ i3)) ^ (((long) 575472497) << 32)), Long.valueOf(575472501)};
                        byte[] bArr7 = $$d;
                        byte b10 = bArr7[265];
                        Object[] objArr31 = new Object[1];
                        c(b10, (short) (b10 | 465), bArr7[8], objArr31);
                        Class<?> cls2 = Class.forName((String) objArr31[0]);
                        byte b11 = (byte) (-bArr7[81]);
                        Object[] objArr32 = new Object[1];
                        c(b11, (short) (b11 | 529), bArr7[232], objArr32);
                        cls2.getMethod((String) objArr32[0], Long.TYPE, Long.TYPE).invoke(null, objArr30);
                        int i67 = ((int[]) objArr2[2])[0];
                        Object[] objArr33 = {new int[]{((int[]) objArr2[0])[0]}, new int[]{((int[]) objArr2[1])[0]}, new int[1], (String) objArr2[3]};
                        int i68 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().keyboard;
                        int i69 = ~i68;
                        int i70 = i67 + 622690542 + (((-807967365) | i68) * (-676)) + (((~(165020025 | i69)) | 807967364) * 676) + (((~(i68 | 972987389)) | (~(i69 | (-813603750))) | 5636385) * 676);
                        int i71 = (i70 << 13) ^ i70;
                        int i72 = i71 ^ (i71 >>> 17);
                        i4 = 0;
                        ((int[]) objArr33[2])[0] = i72 ^ (i72 << 5);
                    }
                    objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(1056123296);
                    if (objAccessartificialFrame == null) {
                        int defaultSize = View.getDefaultSize(i4, i4) + 30;
                        char pressedStateDuration = (char) (49362 - (ViewConfiguration.getPressedStateDuration() >> 16));
                        int scrollBarSize = 684 - (ViewConfiguration.getScrollBarSize() >> 8);
                        Object[] objArr34 = new Object[1];
                        b((byte) 57, (byte) ($$b >>> 2), (byte) (-$$a[4]), objArr34);
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(defaultSize, pressedStateDuration, scrollBarSize, -1583976536, false, (String) objArr34[0], null);
                    }
                    j = ((Field) objAccessartificialFrame).getLong(null);
                    if (j != -1 || j + 1868 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                        Object[] objArr35 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 445147881};
                        byte[] bArr8 = $$d;
                        Object[] objArr36 = new Object[1];
                        c((byte) (-bArr8[83]), (short) 483, bArr8[8], objArr36);
                        Class<?> cls3 = Class.forName((String) objArr36[0]);
                        Object[] objArr37 = new Object[1];
                        c((byte) (-bArr8[30]), (short) 437, bArr8[8], objArr37);
                        objArr3 = (Object[]) cls3.getMethod((String) objArr37[0], Integer.TYPE, Integer.TYPE).invoke(null, objArr35);
                        objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(910856866);
                        if (objAccessartificialFrame2 == null) {
                            int i73 = (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 29;
                            char deadChar = (char) (49362 - KeyEvent.getDeadChar(0, 0));
                            int i74 = 684 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1));
                            Object[] objArr38 = new Object[1];
                            b((byte) 69, (byte) 40, $$a[5], objArr38);
                            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(i73, deadChar, i74, -1456483158, false, (String) objArr38[0], null);
                        }
                        ((Field) objAccessartificialFrame2).set(null, objArr3);
                        try {
                            Long lValueOf2 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(1056123296);
                            if (objAccessartificialFrame3 == null) {
                                int i75 = (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 30;
                                char size = (char) (49362 - View.MeasureSpec.getSize(0));
                                int absoluteGravity = Gravity.getAbsoluteGravity(0, 0) + 684;
                                Object[] objArr39 = new Object[1];
                                b((byte) 57, (byte) ($$b >>> 2), (byte) (-$$a[4]), objArr39);
                                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(i75, size, absoluteGravity, -1583976536, false, (String) objArr39[0], null);
                            }
                            ((Field) objAccessartificialFrame3).set(null, lValueOf2);
                        } catch (Exception unused2) {
                            throw new RuntimeException();
                        }
                    } else {
                        Object objAccessartificialFrame33 = ArtificialStackFrames.accessartificialFrame(910856866);
                        if (objAccessartificialFrame33 == null) {
                            int iAxisFromString2 = 29 - MotionEvent.axisFromString("");
                            char cCombineMeasuredStates2 = (char) (49362 - View.combineMeasuredStates(0, 0));
                            int defaultSize2 = View.getDefaultSize(0, 0) + 684;
                            Object[] objArr40 = new Object[1];
                            b((byte) 69, (byte) 40, $$a[5], objArr40);
                            objAccessartificialFrame33 = ArtificialStackFrames.coroutineCreation(iAxisFromString2, cCombineMeasuredStates2, defaultSize2, -1456483158, false, (String) objArr40[0], null);
                        }
                        Object[] objArr41 = (Object[]) ((Field) objAccessartificialFrame33).get(null);
                        objArr3 = new Object[]{new int[]{((int[]) objArr41[0])[0]}, new int[]{((int[]) objArr41[1])[0]}, new int[1], (String) objArr41[3]};
                        int i76 = ~((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().densityDpi;
                        int i77 = 122786304 + (((~((-904198166) | i76)) | (-74425610)) * (-983)) + (((~(i76 | (-74425610))) | 722184) * 983) + 445147881;
                        int i78 = (i77 << 13) ^ i77;
                        int i79 = i78 ^ (i78 >>> 17);
                        ((int[]) objArr3[2])[0] = i79 ^ (i79 << 5);
                    }
                    i5 = ((int[]) objArr3[1])[0];
                    i6 = ((int[]) objArr3[0])[0];
                    if (i6 == i5) {
                        int i80 = ((int[]) objArr3[2])[0];
                        Object[] objArr42 = {new int[]{((int[]) objArr3[0])[0]}, new int[]{((int[]) objArr3[1])[0]}, new int[1], (String) objArr3[3]};
                        int iMyPid = Process.myPid();
                        int i81 = i80 + (-1751810790) + (((~((~iMyPid) | (-67244617))) | (~(532633598 | iMyPid))) * (-302)) + ((~((-67244617) | iMyPid)) * (-604)) + (((~(iMyPid | 465388982)) | 19398806) * 302);
                        int i82 = (i81 << 13) ^ i81;
                        int i83 = i82 ^ (i82 >>> 17);
                        ((int[]) objArr42[2])[0] = i83 ^ (i83 << 5);
                    } else {
                        new ArrayList().add((String) objArr3[3]);
                        long j11 = ((long) (i5 ^ i6)) ^ (((long) 183426135) << 32);
                        long j12 = 183426119;
                        int i84 = artificialFrame + 67;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i84 % 128;
                        int i85 = i84 % 2;
                        Object[] objArr43 = {Long.valueOf(j11), Long.valueOf(j12)};
                        byte[] bArr9 = $$d;
                        byte b12 = bArr9[28];
                        Object[] objArr44 = new Object[1];
                        c(b12, (short) (b12 | 421), bArr9[8], objArr44);
                        Class<?> cls4 = Class.forName((String) objArr44[0]);
                        byte b13 = (byte) (-bArr9[81]);
                        Object[] objArr45 = new Object[1];
                        c(b13, (short) (b13 | 529), bArr9[232], objArr45);
                        cls4.getMethod((String) objArr45[0], Long.TYPE, Long.TYPE).invoke(null, objArr43);
                        int i86 = ((int[]) objArr3[2])[0];
                        Object[] objArr46 = {new int[]{((int[]) objArr3[0])[0]}, new int[]{((int[]) objArr3[1])[0]}, new int[1], (String) objArr3[3]};
                        int i87 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 1090054534;
                        int i88 = i86 + (-1639129168) + (((~((-244917214) | i87)) | 177807681) * 345) + (((~((-244917214) | (~i87))) | 555898880) * 345) + ((~(i87 | (-177807682))) * 345);
                        int i89 = (i88 << 13) ^ i88;
                        int i90 = i89 ^ (i89 >>> 17);
                        ((int[]) objArr46[2])[0] = i90 ^ (i90 << 5);
                    }
                    objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1168947751);
                    if (objAccessartificialFrame4 == null) {
                        int i91 = 36 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                        char cKeyCodeFromString = (char) KeyEvent.keyCodeFromString("");
                        int mirror = AndroidCharacter.getMirror('0') + 492;
                        byte b14 = $$a[5];
                        byte b15 = (byte) (b14 - 1);
                        Object[] objArr47 = new Object[1];
                        b(b15, (byte) (b15 | 47), b14, objArr47);
                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(i91, cKeyCodeFromString, mirror, 624296913, false, (String) objArr47[0], null);
                    }
                    j2 = ((Field) objAccessartificialFrame4).getLong(null);
                    if (j2 != -1 || j2 + 2000 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                        objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1717965552);
                        if (objAccessartificialFrame5 == null) {
                            objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(20 - KeyEvent.keyCodeFromString(""), (char) (39516 - ExpandableListView.getPackedPositionType(0L)), (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 982, 117222168, false, null, new Class[0]);
                        }
                        Object[] objArr48 = {null, ((Constructor) objAccessartificialFrame5).newInstance(null), 1006457261, 0};
                        objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-501205803);
                        if (objAccessartificialFrame6 == null) {
                            int maxKeyCode = 36 - (KeyEvent.getMaxKeyCode() >> 16);
                            char packedPositionGroup = (char) ExpandableListView.getPackedPositionGroup(0L);
                            int mirror2 = AndroidCharacter.getMirror('0') + 492;
                            byte[] bArr10 = $$a;
                            Object[] objArr49 = new Object[1];
                            b((byte) 77, (byte) (bArr10[5] - 1), bArr10[79], objArr49);
                            objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(maxKeyCode, packedPositionGroup, mirror2, 2101703389, false, (String) objArr49[0], new Class[]{(Class) ArtificialStackFrames.coroutineCreation((CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + 54, (char) ((android.os.SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (android.os.SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 832), 576 - TextUtils.getOffsetAfter("", 0)), (Class) ArtificialStackFrames.coroutineCreation(54 - Gravity.getAbsoluteGravity(0, 0), (char) KeyEvent.getDeadChar(0, 0), 629 - TextUtils.lastIndexOf("", '0')), Integer.TYPE, Integer.TYPE});
                        }
                        objArr4 = (Object[]) ((Method) objAccessartificialFrame6).invoke(null, objArr48);
                        objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-1339222025);
                        if (objAccessartificialFrame7 == null) {
                            int iResolveSize = 36 - View.resolveSize(0, 0);
                            char c3 = (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                            int modifierMetaStateMask = ((byte) KeyEvent.getModifierMetaStateMask()) + Ascii.GS;
                            byte[] bArr11 = $$a;
                            byte b16 = bArr11[28];
                            Object[] objArr50 = new Object[1];
                            b(b16, (byte) (b16 | 39), bArr11[5], objArr50);
                            objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(iResolveSize, c3, modifierMetaStateMask, 793268735, false, (String) objArr50[0], null);
                        }
                        ((Field) objAccessartificialFrame7).set(null, objArr4);
                        try {
                            Long lValueOf3 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                            objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-1168947751);
                            if (objAccessartificialFrame8 == null) {
                                int packedPositionType = ExpandableListView.getPackedPositionType(0L) + 36;
                                char size2 = (char) View.MeasureSpec.getSize(0);
                                int iGreen = 540 - Color.green(0);
                                byte b17 = $$a[5];
                                byte b18 = (byte) (b17 - 1);
                                Object[] objArr51 = new Object[1];
                                b(b18, (byte) (b18 | 47), b17, objArr51);
                                objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(packedPositionType, size2, iGreen, 624296913, false, (String) objArr51[0], null);
                            }
                            ((Field) objAccessartificialFrame8).set(null, lValueOf3);
                        } catch (Exception unused3) {
                            throw new RuntimeException();
                        }
                    } else {
                        Object objAccessartificialFrame34 = ArtificialStackFrames.accessartificialFrame(-1339222025);
                        if (objAccessartificialFrame34 == null) {
                            int bitsPerPixel = ImageFormat.getBitsPerPixel(0) + 37;
                            char edgeSlop = (char) (ViewConfiguration.getEdgeSlop() >> 16);
                            int i92 = 540 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                            byte[] bArr12 = $$a;
                            byte b19 = bArr12[28];
                            Object[] objArr52 = new Object[1];
                            b(b19, (byte) (b19 | 39), bArr12[5], objArr52);
                            objAccessartificialFrame34 = ArtificialStackFrames.coroutineCreation(bitsPerPixel, edgeSlop, i92, 793268735, false, (String) objArr52[0], null);
                        }
                        Object[] objArr53 = (Object[]) ((Field) objAccessartificialFrame34).get(null);
                        objArr4 = new Object[]{new int[1], new int[1], new int[1]};
                        int i93 = ((int[]) objArr53[2])[0];
                        int i94 = ((int[]) objArr53[1])[0];
                        ((int[]) objArr4[2])[0] = i93;
                        ((int[]) objArr4[1])[0] = i94;
                        int i95 = (int) Runtime.getRuntime().totalMemory();
                        int i96 = 1279395388 + (((~(i95 | 698095658)) | (-805051500)) * 305) + (((~((~i95) | 698095658)) | (-653526092)) * 305) + 1006457261;
                        int i97 = (i96 << 13) ^ i96;
                        int i98 = i97 ^ (i97 >>> 17);
                        ((int[]) objArr4[0])[0] = i98 ^ (i98 << 5);
                    }
                    obj = objArr4[1];
                    i7 = ((int[]) obj)[0];
                    obj2 = objArr4[2];
                    i8 = ((int[]) obj2)[0];
                    if (i8 == i7) {
                        Object[] objArr54 = {new int[1], new int[1], new int[1]};
                        int i99 = ((int[]) objArr4[0])[0];
                        int i100 = ((int[]) obj2)[0];
                        int i101 = ((int[]) obj)[0];
                        ((int[]) objArr54[2])[0] = i100;
                        ((int[]) objArr54[1])[0] = i101;
                        int i102 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().navigation;
                        int i103 = i99 + ((((~((-206503969) | i102)) | 587209537) * 449) - 207533485) + (((~((~i102) | (-206503969))) | 587209537) * 449);
                        int i104 = (i103 << 13) ^ i103;
                        int i105 = i104 ^ (i104 >>> 17);
                        ((int[]) objArr54[0])[0] = i105 ^ (i105 << 5);
                        i9 = 0;
                    } else {
                        Object[] objArr55 = {Long.valueOf(((long) (i7 ^ i8)) ^ (((long) (-640496706)) << 32)), Long.valueOf(-640492610)};
                        byte[] bArr13 = $$d;
                        byte b20 = bArr13[35];
                        Object[] objArr56 = new Object[1];
                        c(b20, (short) (b20 | 323), bArr13[8], objArr56);
                        Class<?> cls5 = Class.forName((String) objArr56[0]);
                        byte b21 = (byte) (-bArr13[81]);
                        Object[] objArr57 = new Object[1];
                        c(b21, (short) (b21 | 529), bArr13[232], objArr57);
                        cls5.getMethod((String) objArr57[0], Long.TYPE, Long.TYPE).invoke(null, objArr55);
                        Object[] objArr58 = {new int[1], new int[1], new int[1]};
                        int i106 = ((int[]) objArr4[0])[0];
                        int i107 = ((int[]) objArr4[2])[0];
                        int i108 = ((int[]) objArr4[1])[0];
                        ((int[]) objArr58[2])[0] = i107;
                        ((int[]) objArr58[1])[0] = i108;
                        int i109 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().orientation;
                        int i110 = (-717969941) + (((~((-574754213) | i109)) | 292 | (~(776867537 | i109))) * (-754));
                        int i111 = ~((-293) | i109);
                        int i112 = ~i109;
                        int i113 = i106 + i110 + ((i111 | (~(776867829 | i112))) * (-754)) + ((i112 | (-574754213)) * 754);
                        int i114 = (i113 << 13) ^ i113;
                        int i115 = i114 ^ (i114 >>> 17);
                        i9 = 0;
                        ((int[]) objArr58[0])[0] = i115 ^ (i115 << 5);
                    }
                    objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(-444530678);
                    if (objAccessartificialFrame9 == null) {
                        int i116 = (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 25;
                        char offsetBefore = (char) TextUtils.getOffsetBefore("", i9);
                        int i117 = 1041 - (CdmaCellLocation.convertQuartSecToDecDegrees(i9) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(i9) == 0.0d ? 0 : -1));
                        byte b22 = $$a[5];
                        byte b23 = (byte) (b22 - 1);
                        Object[] objArr59 = new Object[1];
                        b(b23, (byte) (b23 | 47), b22, objArr59);
                        objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(i116, offsetBefore, i117, 2061780482, false, (String) objArr59[0], null);
                    }
                    j3 = ((Field) objAccessartificialFrame9).getLong(null);
                    if (j3 != -1 || j3 + 4611686018427387803L < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                        int iIntValue = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
                        Object[] objArr60 = {2040768510};
                        objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-1648942878);
                        if (objAccessartificialFrame10 == null) {
                            objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(8 - (ViewConfiguration.getScrollBarSize() >> 8), (char) ((android.os.SystemClock.elapsedRealtime() > 0L ? 1 : (android.os.SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 22250), 1033 - ((Process.getThreadPriority(0) + 20) >> 6), 47343338, false, null, new Class[]{Integer.TYPE});
                        }
                        objArrAccessartificialFrame$78cbbd35 = zza.accessartificialFrame$78cbbd35(iIntValue, 0, ((Constructor) objAccessartificialFrame10).newInstance(objArr60), 119955734, false);
                        objAccessartificialFrame11 = ArtificialStackFrames.accessartificialFrame(-614804952);
                        if (objAccessartificialFrame11 == null) {
                            int i118 = (android.os.SystemClock.uptimeMillis() > 0L ? 1 : (android.os.SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 25;
                            char maxKeyCode2 = (char) (KeyEvent.getMaxKeyCode() >> 16);
                            int iArgb = Color.argb(0, 0, 0, 0) + 1041;
                            byte[] bArr14 = $$a;
                            byte b24 = bArr14[28];
                            Object[] objArr61 = new Object[1];
                            b(b24, (byte) (b24 | 39), bArr14[5], objArr61);
                            objAccessartificialFrame11 = ArtificialStackFrames.coroutineCreation(i118, maxKeyCode2, iArgb, 1145017376, false, (String) objArr61[0], null);
                        }
                        ((Field) objAccessartificialFrame11).set(null, objArrAccessartificialFrame$78cbbd35);
                        try {
                            Long lValueOf4 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                            objAccessartificialFrame12 = ArtificialStackFrames.accessartificialFrame(-444530678);
                            if (objAccessartificialFrame12 == null) {
                                int iResolveSize2 = View.resolveSize(0, 0) + 26;
                                char c4 = (char) ((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) - 1);
                                int maxKeyCode3 = 1041 - (KeyEvent.getMaxKeyCode() >> 16);
                                byte b25 = $$a[5];
                                byte b26 = (byte) (b25 - 1);
                                Object[] objArr62 = new Object[1];
                                b(b26, (byte) (b26 | 47), b25, objArr62);
                                objAccessartificialFrame12 = ArtificialStackFrames.coroutineCreation(iResolveSize2, c4, maxKeyCode3, 2061780482, false, (String) objArr62[0], null);
                            }
                            ((Field) objAccessartificialFrame12).set(null, lValueOf4);
                        } catch (Exception unused4) {
                            throw new RuntimeException();
                        }
                    } else {
                        Object objAccessartificialFrame35 = ArtificialStackFrames.accessartificialFrame(-614804952);
                        if (objAccessartificialFrame35 == null) {
                            int minimumFlingVelocity = (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 26;
                            char absoluteGravity2 = (char) Gravity.getAbsoluteGravity(0, 0);
                            int scrollBarFadeDuration = (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 1041;
                            byte[] bArr15 = $$a;
                            byte b27 = bArr15[28];
                            Object[] objArr63 = new Object[1];
                            b(b27, (byte) (b27 | 39), bArr15[5], objArr63);
                            objAccessartificialFrame35 = ArtificialStackFrames.coroutineCreation(minimumFlingVelocity, absoluteGravity2, scrollBarFadeDuration, 1145017376, false, (String) objArr63[0], null);
                        }
                        Object[] objArr64 = (Object[]) ((Field) objAccessartificialFrame35).get(null);
                        objArrAccessartificialFrame$78cbbd35 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
                        int i119 = ((int[]) objArr64[3])[0];
                        int i120 = ((int[]) objArr64[2])[0];
                        String[] strArr7 = (String[]) objArr64[0];
                        int iCodePointAt = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(2) - 1819645438;
                        int i121 = (-1286917476) + (((~((-103302657) | (~iCodePointAt))) | 25198849) * (-591)) + ((iCodePointAt | (-103302657)) * 591) + 119955734;
                        int i122 = (i121 << 13) ^ i121;
                        int i123 = i122 ^ (i122 >>> 17);
                        ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0] = i123 ^ (i123 << 5);
                    }
                    i10 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
                    i11 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
                    if (i11 == i10) {
                        int i124 = artificialFrame + 125;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i124 % 128;
                        int i125 = i124 % 2;
                        Object[] objArr65 = {strArr, new int[1], new int[]{i}, new int[]{i}};
                        int i126 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
                        int i127 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
                        int i128 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
                        String[] strArr8 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
                        int iIdentityHashCode3 = System.identityHashCode(this);
                        int i129 = i126 + (-478269278) + (((~iIdentityHashCode3) | 124274433) * 1444) + (((~(iIdentityHashCode3 | (-829870494))) | (~(907974300 | iIdentityHashCode3)) | 23085313) * (-1444)) + 468171868;
                        int i130 = (i129 << 13) ^ i129;
                        int i131 = i130 ^ (i130 >>> 17);
                        ((int[]) objArr65[1])[0] = i131 ^ (i131 << 5);
                    } else {
                        arrayList = new ArrayList();
                        strArr = (String[]) objArrAccessartificialFrame$78cbbd35[0];
                        if (strArr != null) {
                            for (String str6 : strArr) {
                                arrayList.add(str6);
                            }
                        }
                        Object[] objArr66 = {Long.valueOf(((long) (i10 ^ i11)) ^ (((long) (-1800487843)) << 32)), Long.valueOf(-1800487841)};
                        byte[] bArr16 = $$d;
                        Object[] objArr67 = new Object[1];
                        c(bArr16[8], (short) 321, bArr16[28], objArr67);
                        Class<?> cls6 = Class.forName((String) objArr67[0]);
                        byte b28 = (byte) (-bArr16[81]);
                        Object[] objArr68 = new Object[1];
                        c(b28, (short) (b28 | 529), bArr16[232], objArr68);
                        cls6.getMethod((String) objArr68[0], Long.TYPE, Long.TYPE).invoke(null, objArr66);
                        Object[] objArr69 = {strArr, new int[1], new int[]{i}, new int[]{i}};
                        int i132 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
                        int i133 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
                        int i134 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
                        String[] strArr9 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
                        int i135 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().keyboard;
                        int i136 = i132 + (-87008214) + (((~i135) | 80200960) * 1324) + (((~(i135 | (-943204366))) | (~(1021308172 | i135))) * (-1324)) + 1353223380;
                        int i137 = (i136 << 13) ^ i136;
                        int i138 = i137 ^ (i137 >>> 17);
                        ((int[]) objArr69[1])[0] = i138 ^ (i138 << 5);
                    }
                    objAccessartificialFrame13 = ArtificialStackFrames.accessartificialFrame(1745676544);
                    if (objAccessartificialFrame13 == null) {
                        int maximumDrawingCacheSize = 17 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                        char c5 = (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) - 1);
                        int i139 = 748 - (android.os.SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (android.os.SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1));
                        byte b29 = $$a[5];
                        byte b30 = (byte) (b29 - 1);
                        Object[] objArr70 = new Object[1];
                        b(b30, (byte) (b30 | 47), b29, objArr70);
                        objAccessartificialFrame13 = ArtificialStackFrames.coroutineCreation(maximumDrawingCacheSize, c5, i139, -144068856, false, (String) objArr70[0], null);
                    }
                    j4 = ((Field) objAccessartificialFrame13).getLong(null);
                    if (j4 != -1) {
                        if (j4 + 4611686018427387755L >= ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                            objAccessartificialFrame25 = ArtificialStackFrames.accessartificialFrame(1575402270);
                            if (objAccessartificialFrame25 == null) {
                                int i140 = 17 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                                char cMyTid = (char) (Process.myTid() >> 22);
                                int keyRepeatDelay2 = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 747;
                                byte[] bArr17 = $$a;
                                byte b31 = bArr17[28];
                                Object[] objArr71 = new Object[1];
                                b(b31, (byte) (b31 | 39), bArr17[5], objArr71);
                                objAccessartificialFrame25 = ArtificialStackFrames.coroutineCreation(i140, cMyTid, keyRepeatDelay2, -1031537386, false, (String) objArr71[0], null);
                            }
                            Object[] objArr72 = (Object[]) ((Field) objAccessartificialFrame25).get(null);
                            objArr5 = new Object[]{list, new int[1], list, new int[]{i}, new int[]{i}};
                            int i141 = ((int[]) objArr72[3])[0];
                            int i142 = ((int[]) objArr72[4])[0];
                            List list = (List) objArr72[0];
                            List list2 = (List) objArr72[2];
                            int startUptimeMillis2 = (int) Process.getStartUptimeMillis();
                            int i143 = (-2013343590) + (((~((-688329235) | startUptimeMillis2)) | (~((-82880777) | startUptimeMillis2))) * 69) + (((~(startUptimeMillis2 | (-82897386))) | (~((-688345844) | startUptimeMillis2)) | 16609) * (-69)) + 1645559974;
                            int i144 = (i143 << 13) ^ i143;
                            int i145 = i144 ^ (i144 >>> 17);
                            ((int[]) objArr5[1])[0] = i145 ^ (i145 << 5);
                        } else {
                            i13 = 0;
                        }
                        i14 = ((int[]) objArr5[4])[0];
                        i15 = ((int[]) objArr5[3])[0];
                        if (i15 == i14) {
                            Object[] objArr73 = {list, new int[1], list, new int[]{i}, new int[]{i}};
                            int i146 = ((int[]) objArr5[1])[0];
                            int i147 = ((int[]) objArr5[3])[0];
                            int i148 = ((int[]) objArr5[4])[0];
                            List list3 = (List) objArr5[0];
                            List list4 = (List) objArr5[2];
                            int i149 = ~System.identityHashCode(this);
                            int i150 = i146 + (-1061850123) + ((~((-450905154) | i149)) * (-783)) + (((~(i149 | (-451079498))) | (-1056527956)) * 783);
                            int i151 = (i150 << 13) ^ i150;
                            int i152 = i151 ^ (i151 >>> 17);
                            i16 = 0;
                            ((int[]) objArr73[1])[0] = i152 ^ (i152 << 5);
                        } else {
                            ArrayList arrayList4 = new ArrayList();
                            Object[] objArr74 = {objArr5};
                            objAccessartificialFrame16 = ArtificialStackFrames.accessartificialFrame(1804664566);
                            if (objAccessartificialFrame16 == null) {
                                objAccessartificialFrame16 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getTouchSlop() >> 8) + 41, (char) (12468 - TextUtils.getOffsetBefore("", 0)), TextUtils.lastIndexOf("", '0', 0) + 3643, -185222914, false, "coroutineCreation", new Class[]{Object[].class});
                            }
                            arrayList4.add(((Method) objAccessartificialFrame16).invoke(null, objArr74));
                            Object[] objArr75 = {objArr5};
                            objAccessartificialFrame17 = ArtificialStackFrames.accessartificialFrame(-1243809191);
                            if (objAccessartificialFrame17 == null) {
                                objAccessartificialFrame17 = ArtificialStackFrames.coroutineCreation(40 - TextUtils.lastIndexOf("", '0', 0), (char) ((ViewConfiguration.getTapTimeout() >> 16) + 12468), 3643 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), 716815441, false, "ArtificialStackFrames", new Class[]{Object[].class});
                            }
                            arrayList4.add(((Method) objAccessartificialFrame17).invoke(null, objArr75));
                            long j13 = ((long) (i14 ^ i15)) ^ (((long) 1526814264) << 32);
                            long j14 = 1526814256;
                            int i153 = artificialFrame + 71;
                            getARTIFICIAL_FRAME_PACKAGE_NAME = i153 % 128;
                            int i154 = i153 % 2;
                            Object[] objArr76 = {Long.valueOf(j13), Long.valueOf(j14)};
                            byte[] bArr18 = $$d;
                            byte b32 = bArr18[74];
                            Object[] objArr77 = new Object[1];
                            c(b32, (short) (b32 | 216), bArr18[8], objArr77);
                            Class<?> cls7 = Class.forName((String) objArr77[0]);
                            byte b33 = (byte) (-bArr18[81]);
                            Object[] objArr78 = new Object[1];
                            c(b33, (short) (b33 | 529), bArr18[232], objArr78);
                            cls7.getMethod((String) objArr78[0], Long.TYPE, Long.TYPE).invoke(null, objArr76);
                            Object[] objArr79 = {list, new int[1], list, new int[]{i}, new int[]{i}};
                            int i155 = ((int[]) objArr5[1])[0];
                            int i156 = ((int[]) objArr5[3])[0];
                            int i157 = ((int[]) objArr5[4])[0];
                            List list5 = (List) objArr5[0];
                            List list6 = (List) objArr5[2];
                            int iIdentityHashCode4 = System.identityHashCode(this);
                            int i158 = i155 + (((~(iIdentityHashCode4 | 145144368)) * TypedValues.CycleType.TYPE_EASING) - 164569299) + (((~((~iIdentityHashCode4) | 145144368)) | 136751632) * TypedValues.CycleType.TYPE_EASING);
                            int i159 = (i158 << 13) ^ i158;
                            int i160 = i159 ^ (i159 >>> 17);
                            i16 = 0;
                            ((int[]) objArr79[1])[0] = i160 ^ (i160 << 5);
                        }
                        objAccessartificialFrame18 = ArtificialStackFrames.accessartificialFrame(-2127922582);
                        if (objAccessartificialFrame18 == null) {
                            int iLastIndexOf = 29 - TextUtils.lastIndexOf("", '0', i16, i16);
                            char edgeSlop2 = (char) ((ViewConfiguration.getEdgeSlop() >> 16) + 49362);
                            int i161 = 685 - (android.os.SystemClock.elapsedRealtime() > 0L ? 1 : (android.os.SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                            Object[] objArr80 = new Object[1];
                            b((byte) 97, (byte) 45, (byte) (-$$a[4]), objArr80);
                            objAccessartificialFrame18 = ArtificialStackFrames.coroutineCreation(iLastIndexOf, edgeSlop2, i161, 508509282, false, (String) objArr80[0], null);
                        }
                        j5 = ((Field) objAccessartificialFrame18).getLong(null);
                        if (j5 != -1) {
                            if (j5 + 1885 >= ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                                objAccessartificialFrame24 = ArtificialStackFrames.accessartificialFrame(777251007);
                                if (objAccessartificialFrame24 == null) {
                                    int i162 = (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 30;
                                    char cRgb = (char) (Color.rgb(0, 0, 0) + 16826578);
                                    int deadChar2 = 684 - KeyEvent.getDeadChar(0, 0);
                                    byte b34 = (byte) AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
                                    byte[] bArr19 = $$a;
                                    Object[] objArr81 = new Object[1];
                                    b(b34, (byte) (-bArr19[15]), (byte) (bArr19[5] - 1), objArr81);
                                    objAccessartificialFrame24 = ArtificialStackFrames.coroutineCreation(i162, cRgb, deadChar2, -1321816393, false, (String) objArr81[0], null);
                                }
                                Object[] objArr82 = (Object[]) ((Field) objAccessartificialFrame24).get(null);
                                objArr6 = new Object[]{new int[]{((int[]) objArr82[0])[0]}, new int[]{((int[]) objArr82[1])[0]}, new int[1], (String) objArr82[3]};
                                int i163 = ~(((int) Runtime.getRuntime().freeMemory()) | 363037844);
                                int i164 = (((823303198 | i163) * (-658)) - 221505402) + ((i163 | 537925642) * 658) + 1340793227;
                                int i165 = (i164 << 13) ^ i164;
                                int i166 = i165 ^ (i165 >>> 17);
                                ((int[]) objArr6[2])[0] = i166 ^ (i166 << 5);
                            } else {
                                i17 = 0;
                            }
                            i18 = ((int[]) objArr6[1])[0];
                            i19 = ((int[]) objArr6[0])[0];
                            if (i19 == i18) {
                                int i167 = artificialFrame + 25;
                                getARTIFICIAL_FRAME_PACKAGE_NAME = i167 % 128;
                                int i168 = i167 % 2;
                                int i169 = ((int[]) objArr6[2])[0];
                                Object[] objArr83 = {new int[]{((int[]) objArr6[0])[0]}, new int[]{((int[]) objArr6[1])[0]}, new int[1], (String) objArr6[3]};
                                int iIdentityHashCode5 = System.identityHashCode(this);
                                int i170 = ~iIdentityHashCode5;
                                int i171 = i169 + 1897291658 + (((~(i170 | 114026812)) | (-936115199) | (~((-42508577) | iIdentityHashCode5))) * 717) + (((~(iIdentityHashCode5 | 114026812)) | (~(i170 | (-42508577))) | (-936115199)) * 717);
                                int i172 = (i171 << 13) ^ i171;
                                int i173 = i172 ^ (i172 >>> 17);
                                ((int[]) objArr83[2])[0] = i173 ^ (i173 << 5);
                            } else {
                                Object[] objArr84 = {Long.valueOf(((long) (i18 ^ i19)) ^ (((long) (-767742055)) << 32)), Long.valueOf(-767742567)};
                                byte[] bArr20 = $$d;
                                byte b35 = bArr20[28];
                                Object[] objArr85 = new Object[1];
                                c(b35, (short) (b35 | 421), bArr20[8], objArr85);
                                Class<?> cls8 = Class.forName((String) objArr85[0]);
                                byte b36 = (byte) (-bArr20[81]);
                                Object[] objArr86 = new Object[1];
                                c(b36, (short) (b36 | 529), bArr20[232], objArr86);
                                cls8.getMethod((String) objArr86[0], Long.TYPE, Long.TYPE).invoke(null, objArr84);
                                int i174 = ((int[]) objArr6[2])[0];
                                Object[] objArr87 = {new int[]{((int[]) objArr6[0])[0]}, new int[]{((int[]) objArr6[1])[0]}, new int[1], (String) objArr6[3]};
                                int iIdentityHashCode6 = System.identityHashCode(this);
                                int i175 = ~iIdentityHashCode6;
                                int i176 = i174 + (-112133018) + (((~((-979414305) | i175)) | (~((-25248475) | iIdentityHashCode6)) | (~(1005453307 | iIdentityHashCode6))) * 765) + (((~((-1004662779) | i175)) | 979414304) * 1530) + (((~(iIdentityHashCode6 | (-1004662779))) | (~(i175 | 1005453307))) * 765);
                                int i177 = (i176 << 13) ^ i176;
                                int i178 = i177 ^ (i177 >>> 17);
                                ((int[]) objArr87[2])[0] = i178 ^ (i178 << 5);
                            }
                            objAccessartificialFrame21 = ArtificialStackFrames.accessartificialFrame(1313006081);
                            if (objAccessartificialFrame21 == null) {
                                int jumpTapTimeout2 = 21 - (ViewConfiguration.getJumpTapTimeout() >> 16);
                                char maxKeyCode4 = (char) (KeyEvent.getMaxKeyCode() >> 16);
                                int edgeSlop3 = 465 - (ViewConfiguration.getEdgeSlop() >> 16);
                                byte b37 = $$a[5];
                                byte b38 = (byte) (b37 - 1);
                                Object[] objArr88 = new Object[1];
                                b(b38, (byte) (b38 | 47), b37, objArr88);
                                objAccessartificialFrame21 = ArtificialStackFrames.coroutineCreation(jumpTapTimeout2, maxKeyCode4, edgeSlop3, -785931255, false, (String) objArr88[0], null);
                            }
                            j6 = ((Field) objAccessartificialFrame21).getLong(null);
                            if (j6 != -1 || j6 + 1880 < ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                                baseContext4 = getBaseContext();
                                if (baseContext4 == null) {
                                    Object[] objArr89 = new Object[1];
                                    a(false, TextUtils.lastIndexOf("", '0', 0) + 23, (android.os.SystemClock.elapsedRealtime() > 0L ? 1 : (android.os.SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 263, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 5, new char[]{'\f', 6, 1, 65483, 65534, CharUtils.CR, CharUtils.CR, 65483, 65502, 0, 17, 6, 19, 6, 17, 22, 65521, 5, 15, 2, 65534, 1, 65534, 11, 1, 15}, objArr89);
                                    Class<?> cls9 = Class.forName((String) objArr89[0]);
                                    Object[] objArr90 = new Object[1];
                                    a(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length(), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(7) + 156, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 14, new char[]{'\b', '\b', 11, 65529, 4, 5, 65535, '\n', 65527, 65529, 65535, 2, 6, 6, 65495, '\n', 4, 65531}, objArr90);
                                    baseContext4 = (Context) cls9.getMethod((String) objArr90[0], new Class[0]).invoke(null, null);
                                }
                                if (baseContext4 != null) {
                                    i21 = artificialFrame + 71;
                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i21 % 128;
                                    if (i21 % 2 != 0) {
                                        int i179 = 97 / 0;
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
                                int iIntValue2 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
                                Object[] objArr91 = new Object[1];
                                a(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 19, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(19) + 128, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(17) - 41, new char[]{65511, 28, 65513, 26, 25, 65517, 27, 23, 25, 65510, 23, 65516, 65514, 65519, 65517, 23, 23, 28, 65510, 25, 65514, 65518, 65515, 28, 25, 65510, 28, 65519, 28, 65518, 26, 65515, 65515, 28, 28, 27, 65518, 26, 65510, 65513, 23, 65517, 28, 65518, 65519, 65515, 65515, 65516, 26, 27, 28, 65518, 65516, 65510, 23, 65515, 65519, 25, 65517, 28, 27, 65513, 65512, 65517}, objArr91);
                                String str7 = (String) objArr91[0];
                                Object[] objArr92 = new Object[1];
                                a(false, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 3, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 213, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 29, new char[]{65524, 65517, 65520, 65517, 65518, 65515, 65522, 65517, 65522, 65518, 28, '!', 29, ' ', 65521, 65521, 29, 28, 65523, 65518, 65515, 28, '!', ' ', 65520, 65522, ' ', ' ', ' ', '!', 65515, 65519, 65516, 65524, 65520, 29, 65521, 65518, 31, 65524, 65518, 65521, 65516, ' ', 28, '!', 65520, 28, 65524, 65519, 65521, 65517, 31, 65520, 29, 65517, 65520, 65518, 65517, 65517, 65520, 28, ' ', 65520}, objArr92);
                                String[] strArr10 = {str7, (String) objArr92[0]};
                                int i180 = artificialFrame + 119;
                                getARTIFICIAL_FRAME_PACKAGE_NAME = i180 % 128;
                                int i181 = i180 % 2;
                                Object[] objArr93 = {baseContext4, strArr10, Integer.valueOf(iIntValue2), 1, 109774963};
                                byte[] bArr21 = $$d;
                                byte b39 = bArr21[60];
                                Object[] objArr94 = new Object[1];
                                c(b39, (short) (b39 | 66), bArr21[8], objArr94);
                                Class<?> cls10 = Class.forName((String) objArr94[0]);
                                Object[] objArr95 = new Object[1];
                                c((byte) (bArr21[242] - 1), (short) 107, bArr21[455], objArr95);
                                objArr7 = (Object[]) cls10.getMethod((String) objArr95[0], Context.class, String[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr93);
                                int i182 = ((int[]) objArr7[0])[0];
                                int i183 = ((int[]) objArr7[3])[0];
                                if (baseContext4 != null) {
                                    objAccessartificialFrame22 = ArtificialStackFrames.accessartificialFrame(1142731807);
                                    if (objAccessartificialFrame22 == null) {
                                        int iIndexOf2 = 21 - TextUtils.indexOf("", "", 0, 0);
                                        char mode2 = (char) View.MeasureSpec.getMode(0);
                                        int iIndexOf3 = 464 - TextUtils.indexOf((CharSequence) "", '0');
                                        byte[] bArr22 = $$a;
                                        byte b40 = bArr22[28];
                                        Object[] objArr96 = new Object[1];
                                        b(b40, (byte) (b40 | 39), bArr22[5], objArr96);
                                        objAccessartificialFrame22 = ArtificialStackFrames.coroutineCreation(iIndexOf2, mode2, iIndexOf3, -612765161, false, (String) objArr96[0], null);
                                    }
                                    ((Field) objAccessartificialFrame22).set(null, objArr7);
                                    try {
                                        Long lValueOf5 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                                        objAccessartificialFrame23 = ArtificialStackFrames.accessartificialFrame(1313006081);
                                        if (objAccessartificialFrame23 == null) {
                                            int iArgb2 = Color.argb(0, 0, 0, 0) + 21;
                                            char cNormalizeMetaState = (char) KeyEvent.normalizeMetaState(0);
                                            int iRed = 465 - Color.red(0);
                                            byte b41 = $$a[5];
                                            byte b42 = (byte) (b41 - 1);
                                            Object[] objArr97 = new Object[1];
                                            b(b42, (byte) (b42 | 47), b41, objArr97);
                                            objAccessartificialFrame23 = ArtificialStackFrames.coroutineCreation(iArgb2, cNormalizeMetaState, iRed, -785931255, false, (String) objArr97[0], null);
                                        }
                                        ((Field) objAccessartificialFrame23).set(null, lValueOf5);
                                    } catch (Exception unused5) {
                                        throw new RuntimeException();
                                    }
                                }
                                objArr8 = objArr7;
                                i20 = 0;
                            } else {
                                int i184 = artificialFrame + 1;
                                getARTIFICIAL_FRAME_PACKAGE_NAME = i184 % 128;
                                int i185 = i184 % 2;
                                Object objAccessartificialFrame36 = ArtificialStackFrames.accessartificialFrame(1142731807);
                                if (objAccessartificialFrame36 == null) {
                                    int i186 = (android.os.SystemClock.uptimeMillis() > 0L ? 1 : (android.os.SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 20;
                                    char c6 = (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) - 1);
                                    int absoluteGravity3 = 465 - Gravity.getAbsoluteGravity(0, 0);
                                    byte[] bArr23 = $$a;
                                    byte b43 = bArr23[28];
                                    Object[] objArr98 = new Object[1];
                                    b(b43, (byte) (b43 | 39), bArr23[5], objArr98);
                                    objAccessartificialFrame36 = ArtificialStackFrames.coroutineCreation(i186, c6, absoluteGravity3, -612765161, false, (String) objArr98[0], null);
                                }
                                Object[] objArr99 = (Object[]) ((Field) objAccessartificialFrame36).get(null);
                                objArr8 = new Object[]{new int[]{i}, strArr, new int[1], new int[]{i}};
                                int i187 = ((int[]) objArr99[3])[0];
                                int i188 = ((int[]) objArr99[0])[0];
                                String[] strArr11 = (String[]) objArr99[1];
                                int iIdentityHashCode7 = System.identityHashCode(this);
                                int i189 = ~iIdentityHashCode7;
                                int i190 = 1302640201 + (((~((-536871495) | i189)) | (~((-8691970) | iIdentityHashCode7)) | (~(922085231 | iIdentityHashCode7))) * 765) + (((~((-545563464) | i189)) | 536871494) * 1530) + (((~(iIdentityHashCode7 | (-545563464))) | (~(i189 | 922085231))) * 765) + 109774963;
                                int i191 = (i190 << 13) ^ i190;
                                int i192 = i191 ^ (i191 >>> 17);
                                ((int[]) objArr8[2])[0] = i192 ^ (i192 << 5);
                                i20 = 0;
                            }
                            i22 = ((int[]) objArr8[i20])[i20];
                            i23 = ((int[]) objArr8[3])[i20];
                            if (i23 == i22) {
                                Object[] objArr100 = new Object[4];
                                int[] iArr = new int[1];
                                objArr100[i20] = iArr;
                                objArr100[2] = new int[1];
                                int[] iArr2 = new int[1];
                                objArr100[3] = iArr2;
                                int i193 = ((int[]) objArr8[2])[i20];
                                int i194 = ((int[]) objArr8[3])[i20];
                                int i195 = ((int[]) objArr8[i20])[i20];
                                String[] strArr12 = (String[]) objArr8[1];
                                iArr2[i20] = i194;
                                iArr[i20] = i195;
                                int mode3 = ((AudioManager) ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[i20]).invoke(null, null)).getSystemService("audio")).getMode();
                                int i196 = ~mode3;
                                int i197 = (~((-8922847) | i196)) | 1566;
                                int i198 = ~(mode3 | 160348159);
                                int i199 = i193 + ((i197 | i198) * (-252)) + 160744357 + ((i198 | (~(i196 | (-8921281)))) * 252);
                                int i200 = (i199 << 13) ^ i199;
                                int i201 = i200 ^ (i200 >>> 17);
                                ((int[]) objArr100[2])[0] = i201 ^ (i201 << 5);
                                objArr100[1] = strArr12;
                            } else {
                                arrayList2 = new ArrayList();
                                strArr2 = (String[]) objArr8[1];
                                if (strArr2 != null) {
                                    for (String str8 : strArr2) {
                                        arrayList2.add(str8);
                                    }
                                }
                                Object[] objArr101 = {Long.valueOf(((long) (i22 ^ i23)) ^ (((long) 569889844) << 32)), Long.valueOf(569889908)};
                                byte[] bArr24 = $$d;
                                Object[] objArr102 = new Object[1];
                                c(bArr24[39], bArr24[265], bArr24[8], objArr102);
                                Class<?> cls11 = Class.forName((String) objArr102[0]);
                                byte b44 = (byte) (-bArr24[81]);
                                Object[] objArr103 = new Object[1];
                                c(b44, (short) (b44 | 529), bArr24[232], objArr103);
                                cls11.getMethod((String) objArr103[0], Long.TYPE, Long.TYPE).invoke(null, objArr101);
                                Object[] objArr104 = {new int[]{i}, strArr, new int[1], new int[]{i}};
                                int i202 = ((int[]) objArr8[2])[0];
                                int i203 = ((int[]) objArr8[3])[0];
                                int i204 = ((int[]) objArr8[0])[0];
                                String[] strArr13 = (String[]) objArr8[1];
                                int length = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 1885298596;
                                int i205 = 655002107 + (((~((-758355811) | length)) | 555782464 | (~((-598006085) | length))) * (-754));
                                int i206 = ~((-555782465) | length);
                                int i207 = ~length;
                                int i208 = i202 + i205 + ((i206 | (~((-42223621) | i207))) * (-754)) + ((i207 | (-758355811)) * 754);
                                int i209 = (i208 << 13) ^ i208;
                                int i210 = i209 ^ (i209 >>> 17);
                                ((int[]) objArr104[2])[0] = i210 ^ (i210 << 5);
                            }
                            super.onStart();
                            return;
                        }
                        i17 = 0;
                        baseContext3 = getBaseContext();
                        if (baseContext3 == null) {
                            Object[] objArr105 = new Object[1];
                            a(false, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[i17]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(i17, 4).codePointAt(2) - 14, 264 - (ViewConfiguration.getLongPressTimeout() >> 16), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[i17]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 9, new char[]{'\f', 6, 1, 65483, 65534, CharUtils.CR, CharUtils.CR, 65483, 65502, 0, 17, 6, 19, 6, 17, 22, 65521, 5, 15, 2, 65534, 1, 65534, 11, 1, 15}, objArr105);
                            Class<?> cls12 = Class.forName((String) objArr105[0]);
                            Object[] objArr106 = new Object[1];
                            a(true, 4 - KeyEvent.normalizeMetaState(0), View.getDefaultSize(0, 0) + 271, (ViewConfiguration.getScrollDefaultDelay() >> 16) + 18, new char[]{'\b', '\b', 11, 65529, 4, 5, 65535, '\n', 65527, 65529, 65535, 2, 6, 6, 65495, '\n', 4, 65531}, objArr106);
                            baseContext3 = (Context) cls12.getMethod((String) objArr106[0], new Class[0]).invoke(null, null);
                        }
                        if (baseContext3 != null) {
                            int i211 = getARTIFICIAL_FRAME_PACKAGE_NAME + 29;
                            artificialFrame = i211 % 128;
                            int i212 = i211 % 2;
                            if ((baseContext3 instanceof ContextWrapper) || ((ContextWrapper) baseContext3).getBaseContext() != null) {
                                baseContext3 = baseContext3.getApplicationContext();
                            } else {
                                baseContext3 = null;
                            }
                        }
                        Object[] objArr107 = {baseContext3, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 1340793227};
                        byte[] bArr25 = $$d;
                        Object[] objArr108 = new Object[1];
                        c(bArr25[41], (short) 156, bArr25[8], objArr108);
                        Class<?> cls13 = Class.forName((String) objArr108[0]);
                        Object[] objArr109 = new Object[1];
                        c((byte) (bArr25[242] - 1), (short) 107, bArr25[455], objArr109);
                        objArr6 = (Object[]) cls13.getMethod((String) objArr109[0], Context.class, Integer.TYPE, Integer.TYPE).invoke(null, objArr107);
                        if (baseContext3 != null) {
                            objAccessartificialFrame19 = ArtificialStackFrames.accessartificialFrame(777251007);
                            if (objAccessartificialFrame19 == null) {
                                int iArgb3 = 30 - Color.argb(0, 0, 0, 0);
                                char packedPositionType2 = (char) (ExpandableListView.getPackedPositionType(0L) + 49362);
                                int i213 = 685 - (android.os.SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (android.os.SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1));
                                byte b45 = (byte) AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
                                byte[] bArr26 = $$a;
                                Object[] objArr110 = new Object[1];
                                b(b45, (byte) (-bArr26[15]), (byte) (bArr26[5] - 1), objArr110);
                                objAccessartificialFrame19 = ArtificialStackFrames.coroutineCreation(iArgb3, packedPositionType2, i213, -1321816393, false, (String) objArr110[0], null);
                            }
                            ((Field) objAccessartificialFrame19).set(null, objArr6);
                            try {
                                Long lValueOf6 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                                objAccessartificialFrame20 = ArtificialStackFrames.accessartificialFrame(-2127922582);
                                if (objAccessartificialFrame20 == null) {
                                    int capsMode2 = 30 - TextUtils.getCapsMode("", 0, 0);
                                    char maximumFlingVelocity2 = (char) ((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 49362);
                                    int packedPositionGroup2 = ExpandableListView.getPackedPositionGroup(0L) + 684;
                                    Object[] objArr111 = new Object[1];
                                    b((byte) 97, (byte) 45, (byte) (-$$a[4]), objArr111);
                                    objAccessartificialFrame20 = ArtificialStackFrames.coroutineCreation(capsMode2, maximumFlingVelocity2, packedPositionGroup2, 508509282, false, (String) objArr111[0], null);
                                }
                                ((Field) objAccessartificialFrame20).set(null, lValueOf6);
                                int i214 = getARTIFICIAL_FRAME_PACKAGE_NAME + 119;
                                artificialFrame = i214 % 128;
                                int i215 = i214 % 2;
                            } catch (Exception unused6) {
                                throw new RuntimeException();
                            }
                        }
                        i18 = ((int[]) objArr6[1])[0];
                        i19 = ((int[]) objArr6[0])[0];
                        if (i19 == i18) {
                            int i1610 = artificialFrame + 25;
                            getARTIFICIAL_FRAME_PACKAGE_NAME = i1610 % 128;
                            int i1611 = i1610 % 2;
                            int i1612 = ((int[]) objArr6[2])[0];
                            Object[] objArr810 = {new int[]{((int[]) objArr6[0])[0]}, new int[]{((int[]) objArr6[1])[0]}, new int[1], (String) objArr6[3]};
                            int iIdentityHashCode8 = System.identityHashCode(this);
                            int i1710 = ~iIdentityHashCode8;
                            int i1711 = i1612 + 1897291658 + (((~(i1710 | 114026812)) | (-936115199) | (~((-42508577) | iIdentityHashCode8))) * 717) + (((~(iIdentityHashCode8 | 114026812)) | (~(i1710 | (-42508577))) | (-936115199)) * 717);
                            int i1712 = (i1711 << 13) ^ i1711;
                            int i1713 = i1712 ^ (i1712 >>> 17);
                            ((int[]) objArr810[2])[0] = i1713 ^ (i1713 << 5);
                        } else {
                            Object[] objArr811 = {Long.valueOf(((long) (i18 ^ i19)) ^ (((long) (-767742055)) << 32)), Long.valueOf(-767742567)};
                            byte[] bArr27 = $$d;
                            byte b310 = bArr27[28];
                            Object[] objArr812 = new Object[1];
                            c(b310, (short) (b310 | 421), bArr27[8], objArr812);
                            Class<?> cls14 = Class.forName((String) objArr812[0]);
                            byte b311 = (byte) (-bArr27[81]);
                            Object[] objArr813 = new Object[1];
                            c(b311, (short) (b311 | 529), bArr27[232], objArr813);
                            cls14.getMethod((String) objArr813[0], Long.TYPE, Long.TYPE).invoke(null, objArr811);
                            int i1714 = ((int[]) objArr6[2])[0];
                            Object[] objArr814 = {new int[]{((int[]) objArr6[0])[0]}, new int[]{((int[]) objArr6[1])[0]}, new int[1], (String) objArr6[3]};
                            int iIdentityHashCode9 = System.identityHashCode(this);
                            int i1715 = ~iIdentityHashCode9;
                            int i1716 = i1714 + (-112133018) + (((~((-979414305) | i1715)) | (~((-25248475) | iIdentityHashCode9)) | (~(1005453307 | iIdentityHashCode9))) * 765) + (((~((-1004662779) | i1715)) | 979414304) * 1530) + (((~(iIdentityHashCode9 | (-1004662779))) | (~(i1715 | 1005453307))) * 765);
                            int i1717 = (i1716 << 13) ^ i1716;
                            int i1718 = i1717 ^ (i1717 >>> 17);
                            ((int[]) objArr814[2])[0] = i1718 ^ (i1718 << 5);
                        }
                        objAccessartificialFrame21 = ArtificialStackFrames.accessartificialFrame(1313006081);
                        if (objAccessartificialFrame21 == null) {
                            int jumpTapTimeout3 = 21 - (ViewConfiguration.getJumpTapTimeout() >> 16);
                            char maxKeyCode5 = (char) (KeyEvent.getMaxKeyCode() >> 16);
                            int edgeSlop4 = 465 - (ViewConfiguration.getEdgeSlop() >> 16);
                            byte b312 = $$a[5];
                            byte b313 = (byte) (b312 - 1);
                            Object[] objArr815 = new Object[1];
                            b(b313, (byte) (b313 | 47), b312, objArr815);
                            objAccessartificialFrame21 = ArtificialStackFrames.coroutineCreation(jumpTapTimeout3, maxKeyCode5, edgeSlop4, -785931255, false, (String) objArr815[0], null);
                        }
                        j6 = ((Field) objAccessartificialFrame21).getLong(null);
                        if (j6 != -1) {
                            baseContext4 = getBaseContext();
                            if (baseContext4 == null) {
                                Object[] objArr816 = new Object[1];
                                a(false, TextUtils.lastIndexOf("", '0', 0) + 23, (android.os.SystemClock.elapsedRealtime() > 0L ? 1 : (android.os.SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 263, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 5, new char[]{'\f', 6, 1, 65483, 65534, CharUtils.CR, CharUtils.CR, 65483, 65502, 0, 17, 6, 19, 6, 17, 22, 65521, 5, 15, 2, 65534, 1, 65534, 11, 1, 15}, objArr816);
                                Class<?> cls15 = Class.forName((String) objArr816[0]);
                                Object[] objArr910 = new Object[1];
                                a(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length(), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(7) + 156, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 14, new char[]{'\b', '\b', 11, 65529, 4, 5, 65535, '\n', 65527, 65529, 65535, 2, 6, 6, 65495, '\n', 4, 65531}, objArr910);
                                baseContext4 = (Context) cls15.getMethod((String) objArr910[0], new Class[0]).invoke(null, null);
                            }
                            if (baseContext4 != null) {
                                i21 = artificialFrame + 71;
                                getARTIFICIAL_FRAME_PACKAGE_NAME = i21 % 128;
                                if (i21 % 2 != 0) {
                                    int i1719 = 97 / 0;
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
                            int iIntValue3 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
                            Object[] objArr911 = new Object[1];
                            a(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 19, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(19) + 128, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(17) - 41, new char[]{65511, 28, 65513, 26, 25, 65517, 27, 23, 25, 65510, 23, 65516, 65514, 65519, 65517, 23, 23, 28, 65510, 25, 65514, 65518, 65515, 28, 25, 65510, 28, 65519, 28, 65518, 26, 65515, 65515, 28, 28, 27, 65518, 26, 65510, 65513, 23, 65517, 28, 65518, 65519, 65515, 65515, 65516, 26, 27, 28, 65518, 65516, 65510, 23, 65515, 65519, 25, 65517, 28, 27, 65513, 65512, 65517}, objArr911);
                            String str9 = (String) objArr911[0];
                            Object[] objArr912 = new Object[1];
                            a(false, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 3, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 213, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 29, new char[]{65524, 65517, 65520, 65517, 65518, 65515, 65522, 65517, 65522, 65518, 28, '!', 29, ' ', 65521, 65521, 29, 28, 65523, 65518, 65515, 28, '!', ' ', 65520, 65522, ' ', ' ', ' ', '!', 65515, 65519, 65516, 65524, 65520, 29, 65521, 65518, 31, 65524, 65518, 65521, 65516, ' ', 28, '!', 65520, 28, 65524, 65519, 65521, 65517, 31, 65520, 29, 65517, 65520, 65518, 65517, 65517, 65520, 28, ' ', 65520}, objArr912);
                            String[] strArr14 = {str9, (String) objArr912[0]};
                            int i1810 = artificialFrame + 119;
                            getARTIFICIAL_FRAME_PACKAGE_NAME = i1810 % 128;
                            int i1811 = i1810 % 2;
                            Object[] objArr913 = {baseContext4, strArr14, Integer.valueOf(iIntValue3), 1, 109774963};
                            byte[] bArr28 = $$d;
                            byte b314 = bArr28[60];
                            Object[] objArr914 = new Object[1];
                            c(b314, (short) (b314 | 66), bArr28[8], objArr914);
                            Class<?> cls16 = Class.forName((String) objArr914[0]);
                            Object[] objArr915 = new Object[1];
                            c((byte) (bArr28[242] - 1), (short) 107, bArr28[455], objArr915);
                            objArr7 = (Object[]) cls16.getMethod((String) objArr915[0], Context.class, String[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr913);
                            int i1812 = ((int[]) objArr7[0])[0];
                            int i1813 = ((int[]) objArr7[3])[0];
                            if (baseContext4 != null) {
                                objAccessartificialFrame22 = ArtificialStackFrames.accessartificialFrame(1142731807);
                                if (objAccessartificialFrame22 == null) {
                                    int iIndexOf4 = 21 - TextUtils.indexOf("", "", 0, 0);
                                    char mode4 = (char) View.MeasureSpec.getMode(0);
                                    int iIndexOf5 = 464 - TextUtils.indexOf((CharSequence) "", '0');
                                    byte[] bArr29 = $$a;
                                    byte b46 = bArr29[28];
                                    Object[] objArr916 = new Object[1];
                                    b(b46, (byte) (b46 | 39), bArr29[5], objArr916);
                                    objAccessartificialFrame22 = ArtificialStackFrames.coroutineCreation(iIndexOf4, mode4, iIndexOf5, -612765161, false, (String) objArr916[0], null);
                                }
                                ((Field) objAccessartificialFrame22).set(null, objArr7);
                                Long lValueOf7 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                                objAccessartificialFrame23 = ArtificialStackFrames.accessartificialFrame(1313006081);
                                if (objAccessartificialFrame23 == null) {
                                    int iArgb4 = Color.argb(0, 0, 0, 0) + 21;
                                    char cNormalizeMetaState2 = (char) KeyEvent.normalizeMetaState(0);
                                    int iRed2 = 465 - Color.red(0);
                                    byte b47 = $$a[5];
                                    byte b48 = (byte) (b47 - 1);
                                    Object[] objArr917 = new Object[1];
                                    b(b48, (byte) (b48 | 47), b47, objArr917);
                                    objAccessartificialFrame23 = ArtificialStackFrames.coroutineCreation(iArgb4, cNormalizeMetaState2, iRed2, -785931255, false, (String) objArr917[0], null);
                                }
                                ((Field) objAccessartificialFrame23).set(null, lValueOf7);
                            }
                            objArr8 = objArr7;
                            i20 = 0;
                        } else {
                            baseContext4 = getBaseContext();
                            if (baseContext4 == null) {
                                Object[] objArr817 = new Object[1];
                                a(false, TextUtils.lastIndexOf("", '0', 0) + 23, (android.os.SystemClock.elapsedRealtime() > 0L ? 1 : (android.os.SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 263, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 5, new char[]{'\f', 6, 1, 65483, 65534, CharUtils.CR, CharUtils.CR, 65483, 65502, 0, 17, 6, 19, 6, 17, 22, 65521, 5, 15, 2, 65534, 1, 65534, 11, 1, 15}, objArr817);
                                Class<?> cls17 = Class.forName((String) objArr817[0]);
                                Object[] objArr918 = new Object[1];
                                a(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length(), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(7) + 156, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 14, new char[]{'\b', '\b', 11, 65529, 4, 5, 65535, '\n', 65527, 65529, 65535, 2, 6, 6, 65495, '\n', 4, 65531}, objArr918);
                                baseContext4 = (Context) cls17.getMethod((String) objArr918[0], new Class[0]).invoke(null, null);
                            }
                            if (baseContext4 != null) {
                                i21 = artificialFrame + 71;
                                getARTIFICIAL_FRAME_PACKAGE_NAME = i21 % 128;
                                if (i21 % 2 != 0) {
                                    int i17110 = 97 / 0;
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
                            int iIntValue4 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
                            Object[] objArr919 = new Object[1];
                            a(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 19, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(19) + 128, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(17) - 41, new char[]{65511, 28, 65513, 26, 25, 65517, 27, 23, 25, 65510, 23, 65516, 65514, 65519, 65517, 23, 23, 28, 65510, 25, 65514, 65518, 65515, 28, 25, 65510, 28, 65519, 28, 65518, 26, 65515, 65515, 28, 28, 27, 65518, 26, 65510, 65513, 23, 65517, 28, 65518, 65519, 65515, 65515, 65516, 26, 27, 28, 65518, 65516, 65510, 23, 65515, 65519, 25, 65517, 28, 27, 65513, 65512, 65517}, objArr919);
                            String str10 = (String) objArr919[0];
                            Object[] objArr9110 = new Object[1];
                            a(false, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 3, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 213, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 29, new char[]{65524, 65517, 65520, 65517, 65518, 65515, 65522, 65517, 65522, 65518, 28, '!', 29, ' ', 65521, 65521, 29, 28, 65523, 65518, 65515, 28, '!', ' ', 65520, 65522, ' ', ' ', ' ', '!', 65515, 65519, 65516, 65524, 65520, 29, 65521, 65518, 31, 65524, 65518, 65521, 65516, ' ', 28, '!', 65520, 28, 65524, 65519, 65521, 65517, 31, 65520, 29, 65517, 65520, 65518, 65517, 65517, 65520, 28, ' ', 65520}, objArr9110);
                            String[] strArr15 = {str10, (String) objArr9110[0]};
                            int i1814 = artificialFrame + 119;
                            getARTIFICIAL_FRAME_PACKAGE_NAME = i1814 % 128;
                            int i1815 = i1814 % 2;
                            Object[] objArr9111 = {baseContext4, strArr15, Integer.valueOf(iIntValue4), 1, 109774963};
                            byte[] bArr210 = $$d;
                            byte b315 = bArr210[60];
                            Object[] objArr9112 = new Object[1];
                            c(b315, (short) (b315 | 66), bArr210[8], objArr9112);
                            Class<?> cls18 = Class.forName((String) objArr9112[0]);
                            Object[] objArr9113 = new Object[1];
                            c((byte) (bArr210[242] - 1), (short) 107, bArr210[455], objArr9113);
                            objArr7 = (Object[]) cls18.getMethod((String) objArr9113[0], Context.class, String[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr9111);
                            int i1816 = ((int[]) objArr7[0])[0];
                            int i1817 = ((int[]) objArr7[3])[0];
                            if (baseContext4 != null) {
                                objAccessartificialFrame22 = ArtificialStackFrames.accessartificialFrame(1142731807);
                                if (objAccessartificialFrame22 == null) {
                                    int iIndexOf6 = 21 - TextUtils.indexOf("", "", 0, 0);
                                    char mode5 = (char) View.MeasureSpec.getMode(0);
                                    int iIndexOf7 = 464 - TextUtils.indexOf((CharSequence) "", '0');
                                    byte[] bArr211 = $$a;
                                    byte b49 = bArr211[28];
                                    Object[] objArr9114 = new Object[1];
                                    b(b49, (byte) (b49 | 39), bArr211[5], objArr9114);
                                    objAccessartificialFrame22 = ArtificialStackFrames.coroutineCreation(iIndexOf6, mode5, iIndexOf7, -612765161, false, (String) objArr9114[0], null);
                                }
                                ((Field) objAccessartificialFrame22).set(null, objArr7);
                                Long lValueOf8 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                                objAccessartificialFrame23 = ArtificialStackFrames.accessartificialFrame(1313006081);
                                if (objAccessartificialFrame23 == null) {
                                    int iArgb5 = Color.argb(0, 0, 0, 0) + 21;
                                    char cNormalizeMetaState3 = (char) KeyEvent.normalizeMetaState(0);
                                    int iRed3 = 465 - Color.red(0);
                                    byte b410 = $$a[5];
                                    byte b411 = (byte) (b410 - 1);
                                    Object[] objArr9115 = new Object[1];
                                    b(b411, (byte) (b411 | 47), b410, objArr9115);
                                    objAccessartificialFrame23 = ArtificialStackFrames.coroutineCreation(iArgb5, cNormalizeMetaState3, iRed3, -785931255, false, (String) objArr9115[0], null);
                                }
                                ((Field) objAccessartificialFrame23).set(null, lValueOf8);
                            }
                            objArr8 = objArr7;
                            i20 = 0;
                        }
                        i22 = ((int[]) objArr8[i20])[i20];
                        i23 = ((int[]) objArr8[3])[i20];
                        if (i23 == i22) {
                            Object[] objArr1010 = new Object[4];
                            int[] iArr3 = new int[1];
                            objArr1010[i20] = iArr3;
                            objArr1010[2] = new int[1];
                            int[] iArr4 = new int[1];
                            objArr1010[3] = iArr4;
                            int i1910 = ((int[]) objArr8[2])[i20];
                            int i1911 = ((int[]) objArr8[3])[i20];
                            int i1912 = ((int[]) objArr8[i20])[i20];
                            String[] strArr16 = (String[]) objArr8[1];
                            iArr4[i20] = i1911;
                            iArr3[i20] = i1912;
                            int mode6 = ((AudioManager) ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[i20]).invoke(null, null)).getSystemService("audio")).getMode();
                            int i1913 = ~mode6;
                            int i1914 = (~((-8922847) | i1913)) | 1566;
                            int i1915 = ~(mode6 | 160348159);
                            int i1916 = i1910 + ((i1914 | i1915) * (-252)) + 160744357 + ((i1915 | (~(i1913 | (-8921281)))) * 252);
                            int i2010 = (i1916 << 13) ^ i1916;
                            int i2011 = i2010 ^ (i2010 >>> 17);
                            ((int[]) objArr1010[2])[0] = i2011 ^ (i2011 << 5);
                            objArr1010[1] = strArr16;
                        } else {
                            arrayList2 = new ArrayList();
                            strArr2 = (String[]) objArr8[1];
                            if (strArr2 != null) {
                                while (i24 < strArr2.length) {
                                    arrayList2.add(str8);
                                }
                            }
                            Object[] objArr1011 = {Long.valueOf(((long) (i22 ^ i23)) ^ (((long) 569889844) << 32)), Long.valueOf(569889908)};
                            byte[] bArr212 = $$d;
                            Object[] objArr1012 = new Object[1];
                            c(bArr212[39], bArr212[265], bArr212[8], objArr1012);
                            Class<?> cls19 = Class.forName((String) objArr1012[0]);
                            byte b412 = (byte) (-bArr212[81]);
                            Object[] objArr1013 = new Object[1];
                            c(b412, (short) (b412 | 529), bArr212[232], objArr1013);
                            cls19.getMethod((String) objArr1013[0], Long.TYPE, Long.TYPE).invoke(null, objArr1011);
                            Object[] objArr1014 = {new int[]{i204}, strArr13, new int[1], new int[]{i203}};
                            int i2012 = ((int[]) objArr8[2])[0];
                            int i2013 = ((int[]) objArr8[3])[0];
                            int i2014 = ((int[]) objArr8[0])[0];
                            String[] strArr17 = (String[]) objArr8[1];
                            int length2 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 1885298596;
                            int i2015 = 655002107 + (((~((-758355811) | length2)) | 555782464 | (~((-598006085) | length2))) * (-754));
                            int i2016 = ~((-555782465) | length2);
                            int i2017 = ~length2;
                            int i2018 = i2012 + i2015 + ((i2016 | (~((-42223621) | i2017))) * (-754)) + ((i2017 | (-758355811)) * 754);
                            int i2019 = (i2018 << 13) ^ i2018;
                            int i216 = i2019 ^ (i2019 >>> 17);
                            ((int[]) objArr1014[2])[0] = i216 ^ (i216 << 5);
                        }
                        super.onStart();
                        return;
                    }
                    i13 = 0;
                    baseContext2 = getBaseContext();
                    if (baseContext2 == null) {
                        Object[] objArr112 = new Object[1];
                        a(false, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[i13]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(i13, 4).codePointAt(1) - 27, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[i13]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(i13, 4).length() + 260, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[i13]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(i13, 4).codePointAt(i13) - 11, new char[]{'\f', 6, 1, 65483, 65534, CharUtils.CR, CharUtils.CR, 65483, 65502, 0, 17, 6, 19, 6, 17, 22, 65521, 5, 15, 2, 65534, 1, 65534, 11, 1, 15}, objArr112);
                        Class<?> cls20 = Class.forName((String) objArr112[0]);
                        Object[] objArr113 = new Object[1];
                        a(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 17, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(0) + 234, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 3, new char[]{'\b', '\b', 11, 65529, 4, 5, 65535, '\n', 65527, 65529, 65535, 2, 6, 6, 65495, '\n', 4, 65531}, objArr113);
                        baseContext2 = (Context) cls20.getMethod((String) objArr113[0], new Class[0]).invoke(null, null);
                    }
                    if (baseContext2 != null) {
                        if ((baseContext2 instanceof ContextWrapper) || ((ContextWrapper) baseContext2).getBaseContext() != null) {
                            baseContext2 = baseContext2.getApplicationContext();
                        } else {
                            baseContext2 = null;
                        }
                    }
                    Object[] objArr114 = {baseContext2, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, -974378094};
                    byte[] bArr30 = $$d;
                    Object[] objArr115 = new Object[1];
                    c(bArr30[33], (short) 267, bArr30[8], objArr115);
                    Class<?> cls21 = Class.forName((String) objArr115[0]);
                    Object[] objArr116 = new Object[1];
                    c(bArr30[242], (short) 526, (byte) (bArr30[127] - 1), objArr116);
                    objArr5 = (Object[]) cls21.getMethod((String) objArr116[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr114);
                    objAccessartificialFrame14 = ArtificialStackFrames.accessartificialFrame(1575402270);
                    if (objAccessartificialFrame14 == null) {
                        int modifierMetaStateMask2 = 16 - ((byte) KeyEvent.getModifierMetaStateMask());
                        char packedPositionGroup3 = (char) ExpandableListView.getPackedPositionGroup(0L);
                        int edgeSlop5 = 747 - (ViewConfiguration.getEdgeSlop() >> 16);
                        byte[] bArr31 = $$a;
                        byte b50 = bArr31[28];
                        Object[] objArr117 = new Object[1];
                        b(b50, (byte) (b50 | 39), bArr31[5], objArr117);
                        objAccessartificialFrame14 = ArtificialStackFrames.coroutineCreation(modifierMetaStateMask2, packedPositionGroup3, edgeSlop5, -1031537386, false, (String) objArr117[0], null);
                    }
                    ((Field) objAccessartificialFrame14).set(null, objArr5);
                    Long lValueOf9 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame15 = ArtificialStackFrames.accessartificialFrame(1745676544);
                    if (objAccessartificialFrame15 == null) {
                        int iIndexOf8 = 16 - TextUtils.indexOf((CharSequence) "", '0');
                        char c7 = (char) (1 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)));
                        int edgeSlop6 = (ViewConfiguration.getEdgeSlop() >> 16) + 747;
                        byte b51 = $$a[5];
                        byte b52 = (byte) (b51 - 1);
                        Object[] objArr118 = new Object[1];
                        b(b52, (byte) (b52 | 47), b51, objArr118);
                        objAccessartificialFrame15 = ArtificialStackFrames.coroutineCreation(iIndexOf8, c7, edgeSlop6, -144068856, false, (String) objArr118[0], null);
                    }
                    ((Field) objAccessartificialFrame15).set(null, lValueOf9);
                    i14 = ((int[]) objArr5[4])[0];
                    i15 = ((int[]) objArr5[3])[0];
                    if (i15 == i14) {
                        Object[] objArr710 = {list3, new int[1], list4, new int[]{i147}, new int[]{i148}};
                        int i1410 = ((int[]) objArr5[1])[0];
                        int i1411 = ((int[]) objArr5[3])[0];
                        int i1412 = ((int[]) objArr5[4])[0];
                        List list7 = (List) objArr5[0];
                        List list8 = (List) objArr5[2];
                        int i1413 = ~System.identityHashCode(this);
                        int i1510 = i1410 + (-1061850123) + ((~((-450905154) | i1413)) * (-783)) + (((~(i1413 | (-451079498))) | (-1056527956)) * 783);
                        int i1511 = (i1510 << 13) ^ i1510;
                        int i1512 = i1511 ^ (i1511 >>> 17);
                        i16 = 0;
                        ((int[]) objArr710[1])[0] = i1512 ^ (i1512 << 5);
                    } else {
                        ArrayList arrayList5 = new ArrayList();
                        Object[] objArr711 = {objArr5};
                        objAccessartificialFrame16 = ArtificialStackFrames.accessartificialFrame(1804664566);
                        if (objAccessartificialFrame16 == null) {
                            objAccessartificialFrame16 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getTouchSlop() >> 8) + 41, (char) (12468 - TextUtils.getOffsetBefore("", 0)), TextUtils.lastIndexOf("", '0', 0) + 3643, -185222914, false, "coroutineCreation", new Class[]{Object[].class});
                        }
                        arrayList5.add(((Method) objAccessartificialFrame16).invoke(null, objArr711));
                        Object[] objArr712 = {objArr5};
                        objAccessartificialFrame17 = ArtificialStackFrames.accessartificialFrame(-1243809191);
                        if (objAccessartificialFrame17 == null) {
                            objAccessartificialFrame17 = ArtificialStackFrames.coroutineCreation(40 - TextUtils.lastIndexOf("", '0', 0), (char) ((ViewConfiguration.getTapTimeout() >> 16) + 12468), 3643 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), 716815441, false, "ArtificialStackFrames", new Class[]{Object[].class});
                        }
                        arrayList5.add(((Method) objAccessartificialFrame17).invoke(null, objArr712));
                        long j15 = ((long) (i14 ^ i15)) ^ (((long) 1526814264) << 32);
                        long j16 = 1526814256;
                        int i1513 = artificialFrame + 71;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i1513 % 128;
                        int i1514 = i1513 % 2;
                        Object[] objArr713 = {Long.valueOf(j15), Long.valueOf(j16)};
                        byte[] bArr110 = $$d;
                        byte b316 = bArr110[74];
                        Object[] objArr714 = new Object[1];
                        c(b316, (short) (b316 | 216), bArr110[8], objArr714);
                        Class<?> cls22 = Class.forName((String) objArr714[0]);
                        byte b317 = (byte) (-bArr110[81]);
                        Object[] objArr715 = new Object[1];
                        c(b317, (short) (b317 | 529), bArr110[232], objArr715);
                        cls22.getMethod((String) objArr715[0], Long.TYPE, Long.TYPE).invoke(null, objArr713);
                        Object[] objArr716 = {list5, new int[1], list6, new int[]{i156}, new int[]{i157}};
                        int i1515 = ((int[]) objArr5[1])[0];
                        int i1516 = ((int[]) objArr5[3])[0];
                        int i1517 = ((int[]) objArr5[4])[0];
                        List list9 = (List) objArr5[0];
                        List list10 = (List) objArr5[2];
                        int iIdentityHashCode10 = System.identityHashCode(this);
                        int i1518 = i1515 + (((~(iIdentityHashCode10 | 145144368)) * TypedValues.CycleType.TYPE_EASING) - 164569299) + (((~((~iIdentityHashCode10) | 145144368)) | 136751632) * TypedValues.CycleType.TYPE_EASING);
                        int i1519 = (i1518 << 13) ^ i1518;
                        int i1613 = i1519 ^ (i1519 >>> 17);
                        i16 = 0;
                        ((int[]) objArr716[1])[0] = i1613 ^ (i1613 << 5);
                    }
                    objAccessartificialFrame18 = ArtificialStackFrames.accessartificialFrame(-2127922582);
                    if (objAccessartificialFrame18 == null) {
                        int iLastIndexOf2 = 29 - TextUtils.lastIndexOf("", '0', i16, i16);
                        char edgeSlop7 = (char) ((ViewConfiguration.getEdgeSlop() >> 16) + 49362);
                        int i1614 = 685 - (android.os.SystemClock.elapsedRealtime() > 0L ? 1 : (android.os.SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                        Object[] objArr818 = new Object[1];
                        b((byte) 97, (byte) 45, (byte) (-$$a[4]), objArr818);
                        objAccessartificialFrame18 = ArtificialStackFrames.coroutineCreation(iLastIndexOf2, edgeSlop7, i1614, 508509282, false, (String) objArr818[0], null);
                    }
                    j5 = ((Field) objAccessartificialFrame18).getLong(null);
                    if (j5 != -1) {
                        if (j5 + 1885 >= ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                            objAccessartificialFrame24 = ArtificialStackFrames.accessartificialFrame(777251007);
                            if (objAccessartificialFrame24 == null) {
                                int i1615 = (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 30;
                                char cRgb2 = (char) (Color.rgb(0, 0, 0) + 16826578);
                                int deadChar3 = 684 - KeyEvent.getDeadChar(0, 0);
                                byte b318 = (byte) AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
                                byte[] bArr111 = $$a;
                                Object[] objArr819 = new Object[1];
                                b(b318, (byte) (-bArr111[15]), (byte) (bArr111[5] - 1), objArr819);
                                objAccessartificialFrame24 = ArtificialStackFrames.coroutineCreation(i1615, cRgb2, deadChar3, -1321816393, false, (String) objArr819[0], null);
                            }
                            Object[] objArr820 = (Object[]) ((Field) objAccessartificialFrame24).get(null);
                            objArr6 = new Object[]{new int[]{((int[]) objArr820[0])[0]}, new int[]{((int[]) objArr820[1])[0]}, new int[1], (String) objArr820[3]};
                            int i1616 = ~(((int) Runtime.getRuntime().freeMemory()) | 363037844);
                            int i1617 = (((823303198 | i1616) * (-658)) - 221505402) + ((i1616 | 537925642) * 658) + 1340793227;
                            int i1618 = (i1617 << 13) ^ i1617;
                            int i1619 = i1618 ^ (i1618 >>> 17);
                            ((int[]) objArr6[2])[0] = i1619 ^ (i1619 << 5);
                        } else {
                            i17 = 0;
                        }
                        i18 = ((int[]) objArr6[1])[0];
                        i19 = ((int[]) objArr6[0])[0];
                        if (i19 == i18) {
                            int i16110 = artificialFrame + 25;
                            getARTIFICIAL_FRAME_PACKAGE_NAME = i16110 % 128;
                            int i16111 = i16110 % 2;
                            int i16112 = ((int[]) objArr6[2])[0];
                            Object[] objArr8110 = {new int[]{((int[]) objArr6[0])[0]}, new int[]{((int[]) objArr6[1])[0]}, new int[1], (String) objArr6[3]};
                            int iIdentityHashCode11 = System.identityHashCode(this);
                            int i17111 = ~iIdentityHashCode11;
                            int i17112 = i16112 + 1897291658 + (((~(i17111 | 114026812)) | (-936115199) | (~((-42508577) | iIdentityHashCode11))) * 717) + (((~(iIdentityHashCode11 | 114026812)) | (~(i17111 | (-42508577))) | (-936115199)) * 717);
                            int i17113 = (i17112 << 13) ^ i17112;
                            int i17114 = i17113 ^ (i17113 >>> 17);
                            ((int[]) objArr8110[2])[0] = i17114 ^ (i17114 << 5);
                        } else {
                            Object[] objArr8111 = {Long.valueOf(((long) (i18 ^ i19)) ^ (((long) (-767742055)) << 32)), Long.valueOf(-767742567)};
                            byte[] bArr213 = $$d;
                            byte b319 = bArr213[28];
                            Object[] objArr8112 = new Object[1];
                            c(b319, (short) (b319 | 421), bArr213[8], objArr8112);
                            Class<?> cls110 = Class.forName((String) objArr8112[0]);
                            byte b3110 = (byte) (-bArr213[81]);
                            Object[] objArr8113 = new Object[1];
                            c(b3110, (short) (b3110 | 529), bArr213[232], objArr8113);
                            cls110.getMethod((String) objArr8113[0], Long.TYPE, Long.TYPE).invoke(null, objArr8111);
                            int i17115 = ((int[]) objArr6[2])[0];
                            Object[] objArr8114 = {new int[]{((int[]) objArr6[0])[0]}, new int[]{((int[]) objArr6[1])[0]}, new int[1], (String) objArr6[3]};
                            int iIdentityHashCode12 = System.identityHashCode(this);
                            int i17116 = ~iIdentityHashCode12;
                            int i17117 = i17115 + (-112133018) + (((~((-979414305) | i17116)) | (~((-25248475) | iIdentityHashCode12)) | (~(1005453307 | iIdentityHashCode12))) * 765) + (((~((-1004662779) | i17116)) | 979414304) * 1530) + (((~(iIdentityHashCode12 | (-1004662779))) | (~(i17116 | 1005453307))) * 765);
                            int i17118 = (i17117 << 13) ^ i17117;
                            int i17119 = i17118 ^ (i17118 >>> 17);
                            ((int[]) objArr8114[2])[0] = i17119 ^ (i17119 << 5);
                        }
                        objAccessartificialFrame21 = ArtificialStackFrames.accessartificialFrame(1313006081);
                        if (objAccessartificialFrame21 == null) {
                            int jumpTapTimeout4 = 21 - (ViewConfiguration.getJumpTapTimeout() >> 16);
                            char maxKeyCode6 = (char) (KeyEvent.getMaxKeyCode() >> 16);
                            int edgeSlop8 = 465 - (ViewConfiguration.getEdgeSlop() >> 16);
                            byte b3111 = $$a[5];
                            byte b3112 = (byte) (b3111 - 1);
                            Object[] objArr8115 = new Object[1];
                            b(b3112, (byte) (b3112 | 47), b3111, objArr8115);
                            objAccessartificialFrame21 = ArtificialStackFrames.coroutineCreation(jumpTapTimeout4, maxKeyCode6, edgeSlop8, -785931255, false, (String) objArr8115[0], null);
                        }
                        j6 = ((Field) objAccessartificialFrame21).getLong(null);
                        if (j6 != -1) {
                            baseContext4 = getBaseContext();
                            if (baseContext4 == null) {
                                Object[] objArr8116 = new Object[1];
                                a(false, TextUtils.lastIndexOf("", '0', 0) + 23, (android.os.SystemClock.elapsedRealtime() > 0L ? 1 : (android.os.SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 263, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 5, new char[]{'\f', 6, 1, 65483, 65534, CharUtils.CR, CharUtils.CR, 65483, 65502, 0, 17, 6, 19, 6, 17, 22, 65521, 5, 15, 2, 65534, 1, 65534, 11, 1, 15}, objArr8116);
                                Class<?> cls111 = Class.forName((String) objArr8116[0]);
                                Object[] objArr9116 = new Object[1];
                                a(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length(), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(7) + 156, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 14, new char[]{'\b', '\b', 11, 65529, 4, 5, 65535, '\n', 65527, 65529, 65535, 2, 6, 6, 65495, '\n', 4, 65531}, objArr9116);
                                baseContext4 = (Context) cls111.getMethod((String) objArr9116[0], new Class[0]).invoke(null, null);
                            }
                            if (baseContext4 != null) {
                                i21 = artificialFrame + 71;
                                getARTIFICIAL_FRAME_PACKAGE_NAME = i21 % 128;
                                if (i21 % 2 != 0) {
                                    int i171110 = 97 / 0;
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
                            int iIntValue5 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
                            Object[] objArr9117 = new Object[1];
                            a(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 19, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(19) + 128, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(17) - 41, new char[]{65511, 28, 65513, 26, 25, 65517, 27, 23, 25, 65510, 23, 65516, 65514, 65519, 65517, 23, 23, 28, 65510, 25, 65514, 65518, 65515, 28, 25, 65510, 28, 65519, 28, 65518, 26, 65515, 65515, 28, 28, 27, 65518, 26, 65510, 65513, 23, 65517, 28, 65518, 65519, 65515, 65515, 65516, 26, 27, 28, 65518, 65516, 65510, 23, 65515, 65519, 25, 65517, 28, 27, 65513, 65512, 65517}, objArr9117);
                            String str11 = (String) objArr9117[0];
                            Object[] objArr9118 = new Object[1];
                            a(false, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 3, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 213, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 29, new char[]{65524, 65517, 65520, 65517, 65518, 65515, 65522, 65517, 65522, 65518, 28, '!', 29, ' ', 65521, 65521, 29, 28, 65523, 65518, 65515, 28, '!', ' ', 65520, 65522, ' ', ' ', ' ', '!', 65515, 65519, 65516, 65524, 65520, 29, 65521, 65518, 31, 65524, 65518, 65521, 65516, ' ', 28, '!', 65520, 28, 65524, 65519, 65521, 65517, 31, 65520, 29, 65517, 65520, 65518, 65517, 65517, 65520, 28, ' ', 65520}, objArr9118);
                            String[] strArr18 = {str11, (String) objArr9118[0]};
                            int i1818 = artificialFrame + 119;
                            getARTIFICIAL_FRAME_PACKAGE_NAME = i1818 % 128;
                            int i1819 = i1818 % 2;
                            Object[] objArr9119 = {baseContext4, strArr18, Integer.valueOf(iIntValue5), 1, 109774963};
                            byte[] bArr214 = $$d;
                            byte b3113 = bArr214[60];
                            Object[] objArr91110 = new Object[1];
                            c(b3113, (short) (b3113 | 66), bArr214[8], objArr91110);
                            Class<?> cls112 = Class.forName((String) objArr91110[0]);
                            Object[] objArr91111 = new Object[1];
                            c((byte) (bArr214[242] - 1), (short) 107, bArr214[455], objArr91111);
                            objArr7 = (Object[]) cls112.getMethod((String) objArr91111[0], Context.class, String[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr9119);
                            int i18110 = ((int[]) objArr7[0])[0];
                            int i18111 = ((int[]) objArr7[3])[0];
                            if (baseContext4 != null) {
                                objAccessartificialFrame22 = ArtificialStackFrames.accessartificialFrame(1142731807);
                                if (objAccessartificialFrame22 == null) {
                                    int iIndexOf9 = 21 - TextUtils.indexOf("", "", 0, 0);
                                    char mode7 = (char) View.MeasureSpec.getMode(0);
                                    int iIndexOf10 = 464 - TextUtils.indexOf((CharSequence) "", '0');
                                    byte[] bArr215 = $$a;
                                    byte b413 = bArr215[28];
                                    Object[] objArr91112 = new Object[1];
                                    b(b413, (byte) (b413 | 39), bArr215[5], objArr91112);
                                    objAccessartificialFrame22 = ArtificialStackFrames.coroutineCreation(iIndexOf9, mode7, iIndexOf10, -612765161, false, (String) objArr91112[0], null);
                                }
                                ((Field) objAccessartificialFrame22).set(null, objArr7);
                                Long lValueOf10 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                                objAccessartificialFrame23 = ArtificialStackFrames.accessartificialFrame(1313006081);
                                if (objAccessartificialFrame23 == null) {
                                    int iArgb6 = Color.argb(0, 0, 0, 0) + 21;
                                    char cNormalizeMetaState4 = (char) KeyEvent.normalizeMetaState(0);
                                    int iRed4 = 465 - Color.red(0);
                                    byte b414 = $$a[5];
                                    byte b415 = (byte) (b414 - 1);
                                    Object[] objArr91113 = new Object[1];
                                    b(b415, (byte) (b415 | 47), b414, objArr91113);
                                    objAccessartificialFrame23 = ArtificialStackFrames.coroutineCreation(iArgb6, cNormalizeMetaState4, iRed4, -785931255, false, (String) objArr91113[0], null);
                                }
                                ((Field) objAccessartificialFrame23).set(null, lValueOf10);
                            }
                            objArr8 = objArr7;
                            i20 = 0;
                        } else {
                            baseContext4 = getBaseContext();
                            if (baseContext4 == null) {
                                Object[] objArr8117 = new Object[1];
                                a(false, TextUtils.lastIndexOf("", '0', 0) + 23, (android.os.SystemClock.elapsedRealtime() > 0L ? 1 : (android.os.SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 263, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 5, new char[]{'\f', 6, 1, 65483, 65534, CharUtils.CR, CharUtils.CR, 65483, 65502, 0, 17, 6, 19, 6, 17, 22, 65521, 5, 15, 2, 65534, 1, 65534, 11, 1, 15}, objArr8117);
                                Class<?> cls113 = Class.forName((String) objArr8117[0]);
                                Object[] objArr91114 = new Object[1];
                                a(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length(), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(7) + 156, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 14, new char[]{'\b', '\b', 11, 65529, 4, 5, 65535, '\n', 65527, 65529, 65535, 2, 6, 6, 65495, '\n', 4, 65531}, objArr91114);
                                baseContext4 = (Context) cls113.getMethod((String) objArr91114[0], new Class[0]).invoke(null, null);
                            }
                            if (baseContext4 != null) {
                                i21 = artificialFrame + 71;
                                getARTIFICIAL_FRAME_PACKAGE_NAME = i21 % 128;
                                if (i21 % 2 != 0) {
                                    int i171111 = 97 / 0;
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
                            int iIntValue6 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
                            Object[] objArr91115 = new Object[1];
                            a(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 19, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(19) + 128, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(17) - 41, new char[]{65511, 28, 65513, 26, 25, 65517, 27, 23, 25, 65510, 23, 65516, 65514, 65519, 65517, 23, 23, 28, 65510, 25, 65514, 65518, 65515, 28, 25, 65510, 28, 65519, 28, 65518, 26, 65515, 65515, 28, 28, 27, 65518, 26, 65510, 65513, 23, 65517, 28, 65518, 65519, 65515, 65515, 65516, 26, 27, 28, 65518, 65516, 65510, 23, 65515, 65519, 25, 65517, 28, 27, 65513, 65512, 65517}, objArr91115);
                            String str12 = (String) objArr91115[0];
                            Object[] objArr91116 = new Object[1];
                            a(false, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 3, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 213, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 29, new char[]{65524, 65517, 65520, 65517, 65518, 65515, 65522, 65517, 65522, 65518, 28, '!', 29, ' ', 65521, 65521, 29, 28, 65523, 65518, 65515, 28, '!', ' ', 65520, 65522, ' ', ' ', ' ', '!', 65515, 65519, 65516, 65524, 65520, 29, 65521, 65518, 31, 65524, 65518, 65521, 65516, ' ', 28, '!', 65520, 28, 65524, 65519, 65521, 65517, 31, 65520, 29, 65517, 65520, 65518, 65517, 65517, 65520, 28, ' ', 65520}, objArr91116);
                            String[] strArr19 = {str12, (String) objArr91116[0]};
                            int i18112 = artificialFrame + 119;
                            getARTIFICIAL_FRAME_PACKAGE_NAME = i18112 % 128;
                            int i18113 = i18112 % 2;
                            Object[] objArr91117 = {baseContext4, strArr19, Integer.valueOf(iIntValue6), 1, 109774963};
                            byte[] bArr216 = $$d;
                            byte b3114 = bArr216[60];
                            Object[] objArr91118 = new Object[1];
                            c(b3114, (short) (b3114 | 66), bArr216[8], objArr91118);
                            Class<?> cls114 = Class.forName((String) objArr91118[0]);
                            Object[] objArr91119 = new Object[1];
                            c((byte) (bArr216[242] - 1), (short) 107, bArr216[455], objArr91119);
                            objArr7 = (Object[]) cls114.getMethod((String) objArr91119[0], Context.class, String[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr91117);
                            int i18114 = ((int[]) objArr7[0])[0];
                            int i18115 = ((int[]) objArr7[3])[0];
                            if (baseContext4 != null) {
                                objAccessartificialFrame22 = ArtificialStackFrames.accessartificialFrame(1142731807);
                                if (objAccessartificialFrame22 == null) {
                                    int iIndexOf11 = 21 - TextUtils.indexOf("", "", 0, 0);
                                    char mode8 = (char) View.MeasureSpec.getMode(0);
                                    int iIndexOf12 = 464 - TextUtils.indexOf((CharSequence) "", '0');
                                    byte[] bArr217 = $$a;
                                    byte b416 = bArr217[28];
                                    Object[] objArr911110 = new Object[1];
                                    b(b416, (byte) (b416 | 39), bArr217[5], objArr911110);
                                    objAccessartificialFrame22 = ArtificialStackFrames.coroutineCreation(iIndexOf11, mode8, iIndexOf12, -612765161, false, (String) objArr911110[0], null);
                                }
                                ((Field) objAccessartificialFrame22).set(null, objArr7);
                                Long lValueOf11 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                                objAccessartificialFrame23 = ArtificialStackFrames.accessartificialFrame(1313006081);
                                if (objAccessartificialFrame23 == null) {
                                    int iArgb7 = Color.argb(0, 0, 0, 0) + 21;
                                    char cNormalizeMetaState5 = (char) KeyEvent.normalizeMetaState(0);
                                    int iRed5 = 465 - Color.red(0);
                                    byte b417 = $$a[5];
                                    byte b418 = (byte) (b417 - 1);
                                    Object[] objArr911111 = new Object[1];
                                    b(b418, (byte) (b418 | 47), b417, objArr911111);
                                    objAccessartificialFrame23 = ArtificialStackFrames.coroutineCreation(iArgb7, cNormalizeMetaState5, iRed5, -785931255, false, (String) objArr911111[0], null);
                                }
                                ((Field) objAccessartificialFrame23).set(null, lValueOf11);
                            }
                            objArr8 = objArr7;
                            i20 = 0;
                        }
                        i22 = ((int[]) objArr8[i20])[i20];
                        i23 = ((int[]) objArr8[3])[i20];
                        if (i23 == i22) {
                            Object[] objArr1015 = new Object[4];
                            int[] iArr5 = new int[1];
                            objArr1015[i20] = iArr5;
                            objArr1015[2] = new int[1];
                            int[] iArr6 = new int[1];
                            objArr1015[3] = iArr6;
                            int i1917 = ((int[]) objArr8[2])[i20];
                            int i1918 = ((int[]) objArr8[3])[i20];
                            int i1919 = ((int[]) objArr8[i20])[i20];
                            String[] strArr110 = (String[]) objArr8[1];
                            iArr6[i20] = i1918;
                            iArr5[i20] = i1919;
                            int mode9 = ((AudioManager) ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[i20]).invoke(null, null)).getSystemService("audio")).getMode();
                            int i19110 = ~mode9;
                            int i19111 = (~((-8922847) | i19110)) | 1566;
                            int i19112 = ~(mode9 | 160348159);
                            int i19113 = i1917 + ((i19111 | i19112) * (-252)) + 160744357 + ((i19112 | (~(i19110 | (-8921281)))) * 252);
                            int i20110 = (i19113 << 13) ^ i19113;
                            int i20111 = i20110 ^ (i20110 >>> 17);
                            ((int[]) objArr1015[2])[0] = i20111 ^ (i20111 << 5);
                            objArr1015[1] = strArr110;
                        } else {
                            arrayList2 = new ArrayList();
                            strArr2 = (String[]) objArr8[1];
                            if (strArr2 != null) {
                                while (i24 < strArr2.length) {
                                    arrayList2.add(str8);
                                }
                            }
                            Object[] objArr1016 = {Long.valueOf(((long) (i22 ^ i23)) ^ (((long) 569889844) << 32)), Long.valueOf(569889908)};
                            byte[] bArr218 = $$d;
                            Object[] objArr1017 = new Object[1];
                            c(bArr218[39], bArr218[265], bArr218[8], objArr1017);
                            Class<?> cls115 = Class.forName((String) objArr1017[0]);
                            byte b419 = (byte) (-bArr218[81]);
                            Object[] objArr1018 = new Object[1];
                            c(b419, (short) (b419 | 529), bArr218[232], objArr1018);
                            cls115.getMethod((String) objArr1018[0], Long.TYPE, Long.TYPE).invoke(null, objArr1016);
                            Object[] objArr1019 = {new int[]{i2014}, strArr17, new int[1], new int[]{i2013}};
                            int i20112 = ((int[]) objArr8[2])[0];
                            int i20113 = ((int[]) objArr8[3])[0];
                            int i20114 = ((int[]) objArr8[0])[0];
                            String[] strArr111 = (String[]) objArr8[1];
                            int length3 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 1885298596;
                            int i20115 = 655002107 + (((~((-758355811) | length3)) | 555782464 | (~((-598006085) | length3))) * (-754));
                            int i20116 = ~((-555782465) | length3);
                            int i20117 = ~length3;
                            int i20118 = i20112 + i20115 + ((i20116 | (~((-42223621) | i20117))) * (-754)) + ((i20117 | (-758355811)) * 754);
                            int i20119 = (i20118 << 13) ^ i20118;
                            int i217 = i20119 ^ (i20119 >>> 17);
                            ((int[]) objArr1019[2])[0] = i217 ^ (i217 << 5);
                        }
                        super.onStart();
                        return;
                    }
                    i17 = 0;
                    baseContext3 = getBaseContext();
                    if (baseContext3 == null) {
                        Object[] objArr1020 = new Object[1];
                        a(false, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[i17]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(i17, 4).codePointAt(2) - 14, 264 - (ViewConfiguration.getLongPressTimeout() >> 16), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[i17]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 9, new char[]{'\f', 6, 1, 65483, 65534, CharUtils.CR, CharUtils.CR, 65483, 65502, 0, 17, 6, 19, 6, 17, 22, 65521, 5, 15, 2, 65534, 1, 65534, 11, 1, 15}, objArr1020);
                        Class<?> cls116 = Class.forName((String) objArr1020[0]);
                        Object[] objArr1021 = new Object[1];
                        a(true, 4 - KeyEvent.normalizeMetaState(0), View.getDefaultSize(0, 0) + 271, (ViewConfiguration.getScrollDefaultDelay() >> 16) + 18, new char[]{'\b', '\b', 11, 65529, 4, 5, 65535, '\n', 65527, 65529, 65535, 2, 6, 6, 65495, '\n', 4, 65531}, objArr1021);
                        baseContext3 = (Context) cls116.getMethod((String) objArr1021[0], new Class[0]).invoke(null, null);
                    }
                    if (baseContext3 != null) {
                        int i218 = getARTIFICIAL_FRAME_PACKAGE_NAME + 29;
                        artificialFrame = i218 % 128;
                        int i219 = i218 % 2;
                        if (baseContext3 instanceof ContextWrapper) {
                            baseContext3 = baseContext3.getApplicationContext();
                        } else {
                            baseContext3 = baseContext3.getApplicationContext();
                        }
                    }
                    Object[] objArr1022 = {baseContext3, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 1340793227};
                    byte[] bArr219 = $$d;
                    Object[] objArr1023 = new Object[1];
                    c(bArr219[41], (short) 156, bArr219[8], objArr1023);
                    Class<?> cls117 = Class.forName((String) objArr1023[0]);
                    Object[] objArr1024 = new Object[1];
                    c((byte) (bArr219[242] - 1), (short) 107, bArr219[455], objArr1024);
                    objArr6 = (Object[]) cls117.getMethod((String) objArr1024[0], Context.class, Integer.TYPE, Integer.TYPE).invoke(null, objArr1022);
                    if (baseContext3 != null) {
                        objAccessartificialFrame19 = ArtificialStackFrames.accessartificialFrame(777251007);
                        if (objAccessartificialFrame19 == null) {
                            int iArgb8 = 30 - Color.argb(0, 0, 0, 0);
                            char packedPositionType3 = (char) (ExpandableListView.getPackedPositionType(0L) + 49362);
                            int i2110 = 685 - (android.os.SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (android.os.SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1));
                            byte b420 = (byte) AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
                            byte[] bArr220 = $$a;
                            Object[] objArr119 = new Object[1];
                            b(b420, (byte) (-bArr220[15]), (byte) (bArr220[5] - 1), objArr119);
                            objAccessartificialFrame19 = ArtificialStackFrames.coroutineCreation(iArgb8, packedPositionType3, i2110, -1321816393, false, (String) objArr119[0], null);
                        }
                        ((Field) objAccessartificialFrame19).set(null, objArr6);
                        Long lValueOf12 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame20 = ArtificialStackFrames.accessartificialFrame(-2127922582);
                        if (objAccessartificialFrame20 == null) {
                            int capsMode3 = 30 - TextUtils.getCapsMode("", 0, 0);
                            char maximumFlingVelocity3 = (char) ((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 49362);
                            int packedPositionGroup4 = ExpandableListView.getPackedPositionGroup(0L) + 684;
                            Object[] objArr1110 = new Object[1];
                            b((byte) 97, (byte) 45, (byte) (-$$a[4]), objArr1110);
                            objAccessartificialFrame20 = ArtificialStackFrames.coroutineCreation(capsMode3, maximumFlingVelocity3, packedPositionGroup4, 508509282, false, (String) objArr1110[0], null);
                        }
                        ((Field) objAccessartificialFrame20).set(null, lValueOf12);
                        int i2111 = getARTIFICIAL_FRAME_PACKAGE_NAME + 119;
                        artificialFrame = i2111 % 128;
                        int i2112 = i2111 % 2;
                    }
                    i18 = ((int[]) objArr6[1])[0];
                    i19 = ((int[]) objArr6[0])[0];
                    if (i19 == i18) {
                        int i16113 = artificialFrame + 25;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i16113 % 128;
                        int i16114 = i16113 % 2;
                        int i16115 = ((int[]) objArr6[2])[0];
                        Object[] objArr8118 = {new int[]{((int[]) objArr6[0])[0]}, new int[]{((int[]) objArr6[1])[0]}, new int[1], (String) objArr6[3]};
                        int iIdentityHashCode13 = System.identityHashCode(this);
                        int i171112 = ~iIdentityHashCode13;
                        int i171113 = i16115 + 1897291658 + (((~(i171112 | 114026812)) | (-936115199) | (~((-42508577) | iIdentityHashCode13))) * 717) + (((~(iIdentityHashCode13 | 114026812)) | (~(i171112 | (-42508577))) | (-936115199)) * 717);
                        int i171114 = (i171113 << 13) ^ i171113;
                        int i171115 = i171114 ^ (i171114 >>> 17);
                        ((int[]) objArr8118[2])[0] = i171115 ^ (i171115 << 5);
                    } else {
                        Object[] objArr8119 = {Long.valueOf(((long) (i18 ^ i19)) ^ (((long) (-767742055)) << 32)), Long.valueOf(-767742567)};
                        byte[] bArr2110 = $$d;
                        byte b3115 = bArr2110[28];
                        Object[] objArr81110 = new Object[1];
                        c(b3115, (short) (b3115 | 421), bArr2110[8], objArr81110);
                        Class<?> cls118 = Class.forName((String) objArr81110[0]);
                        byte b3116 = (byte) (-bArr2110[81]);
                        Object[] objArr81111 = new Object[1];
                        c(b3116, (short) (b3116 | 529), bArr2110[232], objArr81111);
                        cls118.getMethod((String) objArr81111[0], Long.TYPE, Long.TYPE).invoke(null, objArr8119);
                        int i171116 = ((int[]) objArr6[2])[0];
                        Object[] objArr81112 = {new int[]{((int[]) objArr6[0])[0]}, new int[]{((int[]) objArr6[1])[0]}, new int[1], (String) objArr6[3]};
                        int iIdentityHashCode14 = System.identityHashCode(this);
                        int i171117 = ~iIdentityHashCode14;
                        int i171118 = i171116 + (-112133018) + (((~((-979414305) | i171117)) | (~((-25248475) | iIdentityHashCode14)) | (~(1005453307 | iIdentityHashCode14))) * 765) + (((~((-1004662779) | i171117)) | 979414304) * 1530) + (((~(iIdentityHashCode14 | (-1004662779))) | (~(i171117 | 1005453307))) * 765);
                        int i171119 = (i171118 << 13) ^ i171118;
                        int i171120 = i171119 ^ (i171119 >>> 17);
                        ((int[]) objArr81112[2])[0] = i171120 ^ (i171120 << 5);
                    }
                    objAccessartificialFrame21 = ArtificialStackFrames.accessartificialFrame(1313006081);
                    if (objAccessartificialFrame21 == null) {
                        int jumpTapTimeout5 = 21 - (ViewConfiguration.getJumpTapTimeout() >> 16);
                        char maxKeyCode7 = (char) (KeyEvent.getMaxKeyCode() >> 16);
                        int edgeSlop9 = 465 - (ViewConfiguration.getEdgeSlop() >> 16);
                        byte b3117 = $$a[5];
                        byte b3118 = (byte) (b3117 - 1);
                        Object[] objArr81113 = new Object[1];
                        b(b3118, (byte) (b3118 | 47), b3117, objArr81113);
                        objAccessartificialFrame21 = ArtificialStackFrames.coroutineCreation(jumpTapTimeout5, maxKeyCode7, edgeSlop9, -785931255, false, (String) objArr81113[0], null);
                    }
                    j6 = ((Field) objAccessartificialFrame21).getLong(null);
                    if (j6 != -1) {
                        baseContext4 = getBaseContext();
                        if (baseContext4 == null) {
                            Object[] objArr81114 = new Object[1];
                            a(false, TextUtils.lastIndexOf("", '0', 0) + 23, (android.os.SystemClock.elapsedRealtime() > 0L ? 1 : (android.os.SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 263, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 5, new char[]{'\f', 6, 1, 65483, 65534, CharUtils.CR, CharUtils.CR, 65483, 65502, 0, 17, 6, 19, 6, 17, 22, 65521, 5, 15, 2, 65534, 1, 65534, 11, 1, 15}, objArr81114);
                            Class<?> cls119 = Class.forName((String) objArr81114[0]);
                            Object[] objArr911112 = new Object[1];
                            a(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length(), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(7) + 156, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 14, new char[]{'\b', '\b', 11, 65529, 4, 5, 65535, '\n', 65527, 65529, 65535, 2, 6, 6, 65495, '\n', 4, 65531}, objArr911112);
                            baseContext4 = (Context) cls119.getMethod((String) objArr911112[0], new Class[0]).invoke(null, null);
                        }
                        if (baseContext4 != null) {
                            i21 = artificialFrame + 71;
                            getARTIFICIAL_FRAME_PACKAGE_NAME = i21 % 128;
                            if (i21 % 2 != 0) {
                                int i1711110 = 97 / 0;
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
                        int iIntValue7 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
                        Object[] objArr911113 = new Object[1];
                        a(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 19, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(19) + 128, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(17) - 41, new char[]{65511, 28, 65513, 26, 25, 65517, 27, 23, 25, 65510, 23, 65516, 65514, 65519, 65517, 23, 23, 28, 65510, 25, 65514, 65518, 65515, 28, 25, 65510, 28, 65519, 28, 65518, 26, 65515, 65515, 28, 28, 27, 65518, 26, 65510, 65513, 23, 65517, 28, 65518, 65519, 65515, 65515, 65516, 26, 27, 28, 65518, 65516, 65510, 23, 65515, 65519, 25, 65517, 28, 27, 65513, 65512, 65517}, objArr911113);
                        String str13 = (String) objArr911113[0];
                        Object[] objArr911114 = new Object[1];
                        a(false, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 3, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 213, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 29, new char[]{65524, 65517, 65520, 65517, 65518, 65515, 65522, 65517, 65522, 65518, 28, '!', 29, ' ', 65521, 65521, 29, 28, 65523, 65518, 65515, 28, '!', ' ', 65520, 65522, ' ', ' ', ' ', '!', 65515, 65519, 65516, 65524, 65520, 29, 65521, 65518, 31, 65524, 65518, 65521, 65516, ' ', 28, '!', 65520, 28, 65524, 65519, 65521, 65517, 31, 65520, 29, 65517, 65520, 65518, 65517, 65517, 65520, 28, ' ', 65520}, objArr911114);
                        String[] strArr112 = {str13, (String) objArr911114[0]};
                        int i18116 = artificialFrame + 119;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i18116 % 128;
                        int i18117 = i18116 % 2;
                        Object[] objArr911115 = {baseContext4, strArr112, Integer.valueOf(iIntValue7), 1, 109774963};
                        byte[] bArr2111 = $$d;
                        byte b3119 = bArr2111[60];
                        Object[] objArr911116 = new Object[1];
                        c(b3119, (short) (b3119 | 66), bArr2111[8], objArr911116);
                        Class<?> cls1110 = Class.forName((String) objArr911116[0]);
                        Object[] objArr911117 = new Object[1];
                        c((byte) (bArr2111[242] - 1), (short) 107, bArr2111[455], objArr911117);
                        objArr7 = (Object[]) cls1110.getMethod((String) objArr911117[0], Context.class, String[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr911115);
                        int i18118 = ((int[]) objArr7[0])[0];
                        int i18119 = ((int[]) objArr7[3])[0];
                        if (baseContext4 != null) {
                            objAccessartificialFrame22 = ArtificialStackFrames.accessartificialFrame(1142731807);
                            if (objAccessartificialFrame22 == null) {
                                int iIndexOf13 = 21 - TextUtils.indexOf("", "", 0, 0);
                                char mode10 = (char) View.MeasureSpec.getMode(0);
                                int iIndexOf14 = 464 - TextUtils.indexOf((CharSequence) "", '0');
                                byte[] bArr2112 = $$a;
                                byte b4110 = bArr2112[28];
                                Object[] objArr911118 = new Object[1];
                                b(b4110, (byte) (b4110 | 39), bArr2112[5], objArr911118);
                                objAccessartificialFrame22 = ArtificialStackFrames.coroutineCreation(iIndexOf13, mode10, iIndexOf14, -612765161, false, (String) objArr911118[0], null);
                            }
                            ((Field) objAccessartificialFrame22).set(null, objArr7);
                            Long lValueOf13 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                            objAccessartificialFrame23 = ArtificialStackFrames.accessartificialFrame(1313006081);
                            if (objAccessartificialFrame23 == null) {
                                int iArgb9 = Color.argb(0, 0, 0, 0) + 21;
                                char cNormalizeMetaState6 = (char) KeyEvent.normalizeMetaState(0);
                                int iRed6 = 465 - Color.red(0);
                                byte b4111 = $$a[5];
                                byte b4112 = (byte) (b4111 - 1);
                                Object[] objArr911119 = new Object[1];
                                b(b4112, (byte) (b4112 | 47), b4111, objArr911119);
                                objAccessartificialFrame23 = ArtificialStackFrames.coroutineCreation(iArgb9, cNormalizeMetaState6, iRed6, -785931255, false, (String) objArr911119[0], null);
                            }
                            ((Field) objAccessartificialFrame23).set(null, lValueOf13);
                        }
                        objArr8 = objArr7;
                        i20 = 0;
                    } else {
                        baseContext4 = getBaseContext();
                        if (baseContext4 == null) {
                            Object[] objArr81115 = new Object[1];
                            a(false, TextUtils.lastIndexOf("", '0', 0) + 23, (android.os.SystemClock.elapsedRealtime() > 0L ? 1 : (android.os.SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 263, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 5, new char[]{'\f', 6, 1, 65483, 65534, CharUtils.CR, CharUtils.CR, 65483, 65502, 0, 17, 6, 19, 6, 17, 22, 65521, 5, 15, 2, 65534, 1, 65534, 11, 1, 15}, objArr81115);
                            Class<?> cls1111 = Class.forName((String) objArr81115[0]);
                            Object[] objArr9111110 = new Object[1];
                            a(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length(), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(7) + 156, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 14, new char[]{'\b', '\b', 11, 65529, 4, 5, 65535, '\n', 65527, 65529, 65535, 2, 6, 6, 65495, '\n', 4, 65531}, objArr9111110);
                            baseContext4 = (Context) cls1111.getMethod((String) objArr9111110[0], new Class[0]).invoke(null, null);
                        }
                        if (baseContext4 != null) {
                            i21 = artificialFrame + 71;
                            getARTIFICIAL_FRAME_PACKAGE_NAME = i21 % 128;
                            if (i21 % 2 != 0) {
                                int i1711111 = 97 / 0;
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
                        int iIntValue8 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
                        Object[] objArr9111111 = new Object[1];
                        a(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 19, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(19) + 128, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(17) - 41, new char[]{65511, 28, 65513, 26, 25, 65517, 27, 23, 25, 65510, 23, 65516, 65514, 65519, 65517, 23, 23, 28, 65510, 25, 65514, 65518, 65515, 28, 25, 65510, 28, 65519, 28, 65518, 26, 65515, 65515, 28, 28, 27, 65518, 26, 65510, 65513, 23, 65517, 28, 65518, 65519, 65515, 65515, 65516, 26, 27, 28, 65518, 65516, 65510, 23, 65515, 65519, 25, 65517, 28, 27, 65513, 65512, 65517}, objArr9111111);
                        String str14 = (String) objArr9111111[0];
                        Object[] objArr9111112 = new Object[1];
                        a(false, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 3, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 213, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 29, new char[]{65524, 65517, 65520, 65517, 65518, 65515, 65522, 65517, 65522, 65518, 28, '!', 29, ' ', 65521, 65521, 29, 28, 65523, 65518, 65515, 28, '!', ' ', 65520, 65522, ' ', ' ', ' ', '!', 65515, 65519, 65516, 65524, 65520, 29, 65521, 65518, 31, 65524, 65518, 65521, 65516, ' ', 28, '!', 65520, 28, 65524, 65519, 65521, 65517, 31, 65520, 29, 65517, 65520, 65518, 65517, 65517, 65520, 28, ' ', 65520}, objArr9111112);
                        String[] strArr113 = {str14, (String) objArr9111112[0]};
                        int i181110 = artificialFrame + 119;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i181110 % 128;
                        int i181111 = i181110 % 2;
                        Object[] objArr9111113 = {baseContext4, strArr113, Integer.valueOf(iIntValue8), 1, 109774963};
                        byte[] bArr2113 = $$d;
                        byte b31110 = bArr2113[60];
                        Object[] objArr9111114 = new Object[1];
                        c(b31110, (short) (b31110 | 66), bArr2113[8], objArr9111114);
                        Class<?> cls1112 = Class.forName((String) objArr9111114[0]);
                        Object[] objArr9111115 = new Object[1];
                        c((byte) (bArr2113[242] - 1), (short) 107, bArr2113[455], objArr9111115);
                        objArr7 = (Object[]) cls1112.getMethod((String) objArr9111115[0], Context.class, String[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr9111113);
                        int i181112 = ((int[]) objArr7[0])[0];
                        int i181113 = ((int[]) objArr7[3])[0];
                        if (baseContext4 != null) {
                            objAccessartificialFrame22 = ArtificialStackFrames.accessartificialFrame(1142731807);
                            if (objAccessartificialFrame22 == null) {
                                int iIndexOf15 = 21 - TextUtils.indexOf("", "", 0, 0);
                                char mode11 = (char) View.MeasureSpec.getMode(0);
                                int iIndexOf16 = 464 - TextUtils.indexOf((CharSequence) "", '0');
                                byte[] bArr2114 = $$a;
                                byte b4113 = bArr2114[28];
                                Object[] objArr9111116 = new Object[1];
                                b(b4113, (byte) (b4113 | 39), bArr2114[5], objArr9111116);
                                objAccessartificialFrame22 = ArtificialStackFrames.coroutineCreation(iIndexOf15, mode11, iIndexOf16, -612765161, false, (String) objArr9111116[0], null);
                            }
                            ((Field) objAccessartificialFrame22).set(null, objArr7);
                            Long lValueOf14 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                            objAccessartificialFrame23 = ArtificialStackFrames.accessartificialFrame(1313006081);
                            if (objAccessartificialFrame23 == null) {
                                int iArgb10 = Color.argb(0, 0, 0, 0) + 21;
                                char cNormalizeMetaState7 = (char) KeyEvent.normalizeMetaState(0);
                                int iRed7 = 465 - Color.red(0);
                                byte b4114 = $$a[5];
                                byte b4115 = (byte) (b4114 - 1);
                                Object[] objArr9111117 = new Object[1];
                                b(b4115, (byte) (b4115 | 47), b4114, objArr9111117);
                                objAccessartificialFrame23 = ArtificialStackFrames.coroutineCreation(iArgb10, cNormalizeMetaState7, iRed7, -785931255, false, (String) objArr9111117[0], null);
                            }
                            ((Field) objAccessartificialFrame23).set(null, lValueOf14);
                        }
                        objArr8 = objArr7;
                        i20 = 0;
                    }
                    i22 = ((int[]) objArr8[i20])[i20];
                    i23 = ((int[]) objArr8[3])[i20];
                    if (i23 == i22) {
                        Object[] objArr10110 = new Object[4];
                        int[] iArr7 = new int[1];
                        objArr10110[i20] = iArr7;
                        objArr10110[2] = new int[1];
                        int[] iArr8 = new int[1];
                        objArr10110[3] = iArr8;
                        int i19114 = ((int[]) objArr8[2])[i20];
                        int i19115 = ((int[]) objArr8[3])[i20];
                        int i19116 = ((int[]) objArr8[i20])[i20];
                        String[] strArr114 = (String[]) objArr8[1];
                        iArr8[i20] = i19115;
                        iArr7[i20] = i19116;
                        int mode12 = ((AudioManager) ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[i20]).invoke(null, null)).getSystemService("audio")).getMode();
                        int i19117 = ~mode12;
                        int i19118 = (~((-8922847) | i19117)) | 1566;
                        int i19119 = ~(mode12 | 160348159);
                        int i191110 = i19114 + ((i19118 | i19119) * (-252)) + 160744357 + ((i19119 | (~(i19117 | (-8921281)))) * 252);
                        int i201110 = (i191110 << 13) ^ i191110;
                        int i201111 = i201110 ^ (i201110 >>> 17);
                        ((int[]) objArr10110[2])[0] = i201111 ^ (i201111 << 5);
                        objArr10110[1] = strArr114;
                    } else {
                        arrayList2 = new ArrayList();
                        strArr2 = (String[]) objArr8[1];
                        if (strArr2 != null) {
                            while (i24 < strArr2.length) {
                                arrayList2.add(str8);
                            }
                        }
                        Object[] objArr10111 = {Long.valueOf(((long) (i22 ^ i23)) ^ (((long) 569889844) << 32)), Long.valueOf(569889908)};
                        byte[] bArr2115 = $$d;
                        Object[] objArr10112 = new Object[1];
                        c(bArr2115[39], bArr2115[265], bArr2115[8], objArr10112);
                        Class<?> cls1113 = Class.forName((String) objArr10112[0]);
                        byte b4116 = (byte) (-bArr2115[81]);
                        Object[] objArr10113 = new Object[1];
                        c(b4116, (short) (b4116 | 529), bArr2115[232], objArr10113);
                        cls1113.getMethod((String) objArr10113[0], Long.TYPE, Long.TYPE).invoke(null, objArr10111);
                        Object[] objArr10114 = {new int[]{i20114}, strArr111, new int[1], new int[]{i20113}};
                        int i201112 = ((int[]) objArr8[2])[0];
                        int i201113 = ((int[]) objArr8[3])[0];
                        int i201114 = ((int[]) objArr8[0])[0];
                        String[] strArr115 = (String[]) objArr8[1];
                        int length4 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 1885298596;
                        int i201115 = 655002107 + (((~((-758355811) | length4)) | 555782464 | (~((-598006085) | length4))) * (-754));
                        int i201116 = ~((-555782465) | length4);
                        int i201117 = ~length4;
                        int i201118 = i201112 + i201115 + ((i201116 | (~((-42223621) | i201117))) * (-754)) + ((i201117 | (-758355811)) * 754);
                        int i201119 = (i201118 << 13) ^ i201118;
                        int i2113 = i201119 ^ (i201119 >>> 17);
                        ((int[]) objArr10114[2])[0] = i2113 ^ (i2113 << 5);
                    }
                    super.onStart();
                    return;
                }
                i = 0;
                if (j4 != -1) {
                    if (j4 + 4611686018427387755L >= ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                        objAccessartificialFrame25 = ArtificialStackFrames.accessartificialFrame(1575402270);
                        if (objAccessartificialFrame25 == null) {
                            int i1414 = 17 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                            char cMyTid2 = (char) (Process.myTid() >> 22);
                            int keyRepeatDelay3 = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 747;
                            byte[] bArr112 = $$a;
                            byte b320 = bArr112[28];
                            Object[] objArr717 = new Object[1];
                            b(b320, (byte) (b320 | 39), bArr112[5], objArr717);
                            objAccessartificialFrame25 = ArtificialStackFrames.coroutineCreation(i1414, cMyTid2, keyRepeatDelay3, -1031537386, false, (String) objArr717[0], null);
                        }
                        Object[] objArr718 = (Object[]) ((Field) objAccessartificialFrame25).get(null);
                        objArr5 = new Object[]{list, new int[1], list2, new int[]{i141}, new int[]{i142}};
                        int i1415 = ((int[]) objArr718[3])[0];
                        int i1416 = ((int[]) objArr718[4])[0];
                        List list11 = (List) objArr718[0];
                        List list12 = (List) objArr718[2];
                        int startUptimeMillis3 = (int) Process.getStartUptimeMillis();
                        int i1417 = (-2013343590) + (((~((-688329235) | startUptimeMillis3)) | (~((-82880777) | startUptimeMillis3))) * 69) + (((~(startUptimeMillis3 | (-82897386))) | (~((-688345844) | startUptimeMillis3)) | 16609) * (-69)) + 1645559974;
                        int i1418 = (i1417 << 13) ^ i1417;
                        int i1419 = i1418 ^ (i1418 >>> 17);
                        ((int[]) objArr5[1])[0] = i1419 ^ (i1419 << 5);
                    } else {
                        i13 = 0;
                    }
                    i14 = ((int[]) objArr5[4])[0];
                    i15 = ((int[]) objArr5[3])[0];
                    if (i15 == i14) {
                        Object[] objArr719 = {list7, new int[1], list8, new int[]{i1411}, new int[]{i1412}};
                        int i14110 = ((int[]) objArr5[1])[0];
                        int i14111 = ((int[]) objArr5[3])[0];
                        int i14112 = ((int[]) objArr5[4])[0];
                        List list13 = (List) objArr5[0];
                        List list14 = (List) objArr5[2];
                        int i14113 = ~System.identityHashCode(this);
                        int i15110 = i14110 + (-1061850123) + ((~((-450905154) | i14113)) * (-783)) + (((~(i14113 | (-451079498))) | (-1056527956)) * 783);
                        int i15111 = (i15110 << 13) ^ i15110;
                        int i15112 = i15111 ^ (i15111 >>> 17);
                        i16 = 0;
                        ((int[]) objArr719[1])[0] = i15112 ^ (i15112 << 5);
                    } else {
                        ArrayList arrayList6 = new ArrayList();
                        Object[] objArr7110 = {objArr5};
                        objAccessartificialFrame16 = ArtificialStackFrames.accessartificialFrame(1804664566);
                        if (objAccessartificialFrame16 == null) {
                            objAccessartificialFrame16 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getTouchSlop() >> 8) + 41, (char) (12468 - TextUtils.getOffsetBefore("", 0)), TextUtils.lastIndexOf("", '0', 0) + 3643, -185222914, false, "coroutineCreation", new Class[]{Object[].class});
                        }
                        arrayList6.add(((Method) objAccessartificialFrame16).invoke(null, objArr7110));
                        Object[] objArr7111 = {objArr5};
                        objAccessartificialFrame17 = ArtificialStackFrames.accessartificialFrame(-1243809191);
                        if (objAccessartificialFrame17 == null) {
                            objAccessartificialFrame17 = ArtificialStackFrames.coroutineCreation(40 - TextUtils.lastIndexOf("", '0', 0), (char) ((ViewConfiguration.getTapTimeout() >> 16) + 12468), 3643 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), 716815441, false, "ArtificialStackFrames", new Class[]{Object[].class});
                        }
                        arrayList6.add(((Method) objAccessartificialFrame17).invoke(null, objArr7111));
                        long j17 = ((long) (i14 ^ i15)) ^ (((long) 1526814264) << 32);
                        long j18 = 1526814256;
                        int i15113 = artificialFrame + 71;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i15113 % 128;
                        int i15114 = i15113 % 2;
                        Object[] objArr7112 = {Long.valueOf(j17), Long.valueOf(j18)};
                        byte[] bArr113 = $$d;
                        byte b3120 = bArr113[74];
                        Object[] objArr7113 = new Object[1];
                        c(b3120, (short) (b3120 | 216), bArr113[8], objArr7113);
                        Class<?> cls23 = Class.forName((String) objArr7113[0]);
                        byte b3121 = (byte) (-bArr113[81]);
                        Object[] objArr7114 = new Object[1];
                        c(b3121, (short) (b3121 | 529), bArr113[232], objArr7114);
                        cls23.getMethod((String) objArr7114[0], Long.TYPE, Long.TYPE).invoke(null, objArr7112);
                        Object[] objArr7115 = {list9, new int[1], list10, new int[]{i1516}, new int[]{i1517}};
                        int i15115 = ((int[]) objArr5[1])[0];
                        int i15116 = ((int[]) objArr5[3])[0];
                        int i15117 = ((int[]) objArr5[4])[0];
                        List list15 = (List) objArr5[0];
                        List list16 = (List) objArr5[2];
                        int iIdentityHashCode15 = System.identityHashCode(this);
                        int i15118 = i15115 + (((~(iIdentityHashCode15 | 145144368)) * TypedValues.CycleType.TYPE_EASING) - 164569299) + (((~((~iIdentityHashCode15) | 145144368)) | 136751632) * TypedValues.CycleType.TYPE_EASING);
                        int i15119 = (i15118 << 13) ^ i15118;
                        int i16116 = i15119 ^ (i15119 >>> 17);
                        i16 = 0;
                        ((int[]) objArr7115[1])[0] = i16116 ^ (i16116 << 5);
                    }
                    objAccessartificialFrame18 = ArtificialStackFrames.accessartificialFrame(-2127922582);
                    if (objAccessartificialFrame18 == null) {
                        int iLastIndexOf3 = 29 - TextUtils.lastIndexOf("", '0', i16, i16);
                        char edgeSlop10 = (char) ((ViewConfiguration.getEdgeSlop() >> 16) + 49362);
                        int i16117 = 685 - (android.os.SystemClock.elapsedRealtime() > 0L ? 1 : (android.os.SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                        Object[] objArr8120 = new Object[1];
                        b((byte) 97, (byte) 45, (byte) (-$$a[4]), objArr8120);
                        objAccessartificialFrame18 = ArtificialStackFrames.coroutineCreation(iLastIndexOf3, edgeSlop10, i16117, 508509282, false, (String) objArr8120[0], null);
                    }
                    j5 = ((Field) objAccessartificialFrame18).getLong(null);
                    if (j5 != -1) {
                        if (j5 + 1885 >= ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                            objAccessartificialFrame24 = ArtificialStackFrames.accessartificialFrame(777251007);
                            if (objAccessartificialFrame24 == null) {
                                int i16118 = (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 30;
                                char cRgb3 = (char) (Color.rgb(0, 0, 0) + 16826578);
                                int deadChar4 = 684 - KeyEvent.getDeadChar(0, 0);
                                byte b3122 = (byte) AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
                                byte[] bArr114 = $$a;
                                Object[] objArr8121 = new Object[1];
                                b(b3122, (byte) (-bArr114[15]), (byte) (bArr114[5] - 1), objArr8121);
                                objAccessartificialFrame24 = ArtificialStackFrames.coroutineCreation(i16118, cRgb3, deadChar4, -1321816393, false, (String) objArr8121[0], null);
                            }
                            Object[] objArr821 = (Object[]) ((Field) objAccessartificialFrame24).get(null);
                            objArr6 = new Object[]{new int[]{((int[]) objArr821[0])[0]}, new int[]{((int[]) objArr821[1])[0]}, new int[1], (String) objArr821[3]};
                            int i16119 = ~(((int) Runtime.getRuntime().freeMemory()) | 363037844);
                            int i16120 = (((823303198 | i16119) * (-658)) - 221505402) + ((i16119 | 537925642) * 658) + 1340793227;
                            int i16121 = (i16120 << 13) ^ i16120;
                            int i16122 = i16121 ^ (i16121 >>> 17);
                            ((int[]) objArr6[2])[0] = i16122 ^ (i16122 << 5);
                        } else {
                            i17 = 0;
                        }
                        i18 = ((int[]) objArr6[1])[0];
                        i19 = ((int[]) objArr6[0])[0];
                        if (i19 == i18) {
                            int i161110 = artificialFrame + 25;
                            getARTIFICIAL_FRAME_PACKAGE_NAME = i161110 % 128;
                            int i161111 = i161110 % 2;
                            int i161112 = ((int[]) objArr6[2])[0];
                            Object[] objArr81116 = {new int[]{((int[]) objArr6[0])[0]}, new int[]{((int[]) objArr6[1])[0]}, new int[1], (String) objArr6[3]};
                            int iIdentityHashCode16 = System.identityHashCode(this);
                            int i1711112 = ~iIdentityHashCode16;
                            int i1711113 = i161112 + 1897291658 + (((~(i1711112 | 114026812)) | (-936115199) | (~((-42508577) | iIdentityHashCode16))) * 717) + (((~(iIdentityHashCode16 | 114026812)) | (~(i1711112 | (-42508577))) | (-936115199)) * 717);
                            int i1711114 = (i1711113 << 13) ^ i1711113;
                            int i1711115 = i1711114 ^ (i1711114 >>> 17);
                            ((int[]) objArr81116[2])[0] = i1711115 ^ (i1711115 << 5);
                        } else {
                            Object[] objArr81117 = {Long.valueOf(((long) (i18 ^ i19)) ^ (((long) (-767742055)) << 32)), Long.valueOf(-767742567)};
                            byte[] bArr2116 = $$d;
                            byte b31111 = bArr2116[28];
                            Object[] objArr81118 = new Object[1];
                            c(b31111, (short) (b31111 | 421), bArr2116[8], objArr81118);
                            Class<?> cls1114 = Class.forName((String) objArr81118[0]);
                            byte b31112 = (byte) (-bArr2116[81]);
                            Object[] objArr81119 = new Object[1];
                            c(b31112, (short) (b31112 | 529), bArr2116[232], objArr81119);
                            cls1114.getMethod((String) objArr81119[0], Long.TYPE, Long.TYPE).invoke(null, objArr81117);
                            int i1711116 = ((int[]) objArr6[2])[0];
                            Object[] objArr811110 = {new int[]{((int[]) objArr6[0])[0]}, new int[]{((int[]) objArr6[1])[0]}, new int[1], (String) objArr6[3]};
                            int iIdentityHashCode17 = System.identityHashCode(this);
                            int i1711117 = ~iIdentityHashCode17;
                            int i1711118 = i1711116 + (-112133018) + (((~((-979414305) | i1711117)) | (~((-25248475) | iIdentityHashCode17)) | (~(1005453307 | iIdentityHashCode17))) * 765) + (((~((-1004662779) | i1711117)) | 979414304) * 1530) + (((~(iIdentityHashCode17 | (-1004662779))) | (~(i1711117 | 1005453307))) * 765);
                            int i1711119 = (i1711118 << 13) ^ i1711118;
                            int i171121 = i1711119 ^ (i1711119 >>> 17);
                            ((int[]) objArr811110[2])[0] = i171121 ^ (i171121 << 5);
                        }
                        objAccessartificialFrame21 = ArtificialStackFrames.accessartificialFrame(1313006081);
                        if (objAccessartificialFrame21 == null) {
                            int jumpTapTimeout6 = 21 - (ViewConfiguration.getJumpTapTimeout() >> 16);
                            char maxKeyCode8 = (char) (KeyEvent.getMaxKeyCode() >> 16);
                            int edgeSlop11 = 465 - (ViewConfiguration.getEdgeSlop() >> 16);
                            byte b31113 = $$a[5];
                            byte b31114 = (byte) (b31113 - 1);
                            Object[] objArr811111 = new Object[1];
                            b(b31114, (byte) (b31114 | 47), b31113, objArr811111);
                            objAccessartificialFrame21 = ArtificialStackFrames.coroutineCreation(jumpTapTimeout6, maxKeyCode8, edgeSlop11, -785931255, false, (String) objArr811111[0], null);
                        }
                        j6 = ((Field) objAccessartificialFrame21).getLong(null);
                        if (j6 != -1) {
                            baseContext4 = getBaseContext();
                            if (baseContext4 == null) {
                                Object[] objArr811112 = new Object[1];
                                a(false, TextUtils.lastIndexOf("", '0', 0) + 23, (android.os.SystemClock.elapsedRealtime() > 0L ? 1 : (android.os.SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 263, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 5, new char[]{'\f', 6, 1, 65483, 65534, CharUtils.CR, CharUtils.CR, 65483, 65502, 0, 17, 6, 19, 6, 17, 22, 65521, 5, 15, 2, 65534, 1, 65534, 11, 1, 15}, objArr811112);
                                Class<?> cls1115 = Class.forName((String) objArr811112[0]);
                                Object[] objArr9111118 = new Object[1];
                                a(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length(), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(7) + 156, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 14, new char[]{'\b', '\b', 11, 65529, 4, 5, 65535, '\n', 65527, 65529, 65535, 2, 6, 6, 65495, '\n', 4, 65531}, objArr9111118);
                                baseContext4 = (Context) cls1115.getMethod((String) objArr9111118[0], new Class[0]).invoke(null, null);
                            }
                            if (baseContext4 != null) {
                                i21 = artificialFrame + 71;
                                getARTIFICIAL_FRAME_PACKAGE_NAME = i21 % 128;
                                if (i21 % 2 != 0) {
                                    int i17111110 = 97 / 0;
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
                            int iIntValue9 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
                            Object[] objArr9111119 = new Object[1];
                            a(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 19, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(19) + 128, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(17) - 41, new char[]{65511, 28, 65513, 26, 25, 65517, 27, 23, 25, 65510, 23, 65516, 65514, 65519, 65517, 23, 23, 28, 65510, 25, 65514, 65518, 65515, 28, 25, 65510, 28, 65519, 28, 65518, 26, 65515, 65515, 28, 28, 27, 65518, 26, 65510, 65513, 23, 65517, 28, 65518, 65519, 65515, 65515, 65516, 26, 27, 28, 65518, 65516, 65510, 23, 65515, 65519, 25, 65517, 28, 27, 65513, 65512, 65517}, objArr9111119);
                            String str15 = (String) objArr9111119[0];
                            Object[] objArr91111110 = new Object[1];
                            a(false, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 3, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 213, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 29, new char[]{65524, 65517, 65520, 65517, 65518, 65515, 65522, 65517, 65522, 65518, 28, '!', 29, ' ', 65521, 65521, 29, 28, 65523, 65518, 65515, 28, '!', ' ', 65520, 65522, ' ', ' ', ' ', '!', 65515, 65519, 65516, 65524, 65520, 29, 65521, 65518, 31, 65524, 65518, 65521, 65516, ' ', 28, '!', 65520, 28, 65524, 65519, 65521, 65517, 31, 65520, 29, 65517, 65520, 65518, 65517, 65517, 65520, 28, ' ', 65520}, objArr91111110);
                            String[] strArr116 = {str15, (String) objArr91111110[0]};
                            int i181114 = artificialFrame + 119;
                            getARTIFICIAL_FRAME_PACKAGE_NAME = i181114 % 128;
                            int i181115 = i181114 % 2;
                            Object[] objArr91111111 = {baseContext4, strArr116, Integer.valueOf(iIntValue9), 1, 109774963};
                            byte[] bArr2117 = $$d;
                            byte b31115 = bArr2117[60];
                            Object[] objArr91111112 = new Object[1];
                            c(b31115, (short) (b31115 | 66), bArr2117[8], objArr91111112);
                            Class<?> cls1116 = Class.forName((String) objArr91111112[0]);
                            Object[] objArr91111113 = new Object[1];
                            c((byte) (bArr2117[242] - 1), (short) 107, bArr2117[455], objArr91111113);
                            objArr7 = (Object[]) cls1116.getMethod((String) objArr91111113[0], Context.class, String[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr91111111);
                            int i181116 = ((int[]) objArr7[0])[0];
                            int i181117 = ((int[]) objArr7[3])[0];
                            if (baseContext4 != null) {
                                objAccessartificialFrame22 = ArtificialStackFrames.accessartificialFrame(1142731807);
                                if (objAccessartificialFrame22 == null) {
                                    int iIndexOf17 = 21 - TextUtils.indexOf("", "", 0, 0);
                                    char mode13 = (char) View.MeasureSpec.getMode(0);
                                    int iIndexOf18 = 464 - TextUtils.indexOf((CharSequence) "", '0');
                                    byte[] bArr2118 = $$a;
                                    byte b4117 = bArr2118[28];
                                    Object[] objArr91111114 = new Object[1];
                                    b(b4117, (byte) (b4117 | 39), bArr2118[5], objArr91111114);
                                    objAccessartificialFrame22 = ArtificialStackFrames.coroutineCreation(iIndexOf17, mode13, iIndexOf18, -612765161, false, (String) objArr91111114[0], null);
                                }
                                ((Field) objAccessartificialFrame22).set(null, objArr7);
                                Long lValueOf15 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                                objAccessartificialFrame23 = ArtificialStackFrames.accessartificialFrame(1313006081);
                                if (objAccessartificialFrame23 == null) {
                                    int iArgb11 = Color.argb(0, 0, 0, 0) + 21;
                                    char cNormalizeMetaState8 = (char) KeyEvent.normalizeMetaState(0);
                                    int iRed8 = 465 - Color.red(0);
                                    byte b4118 = $$a[5];
                                    byte b4119 = (byte) (b4118 - 1);
                                    Object[] objArr91111115 = new Object[1];
                                    b(b4119, (byte) (b4119 | 47), b4118, objArr91111115);
                                    objAccessartificialFrame23 = ArtificialStackFrames.coroutineCreation(iArgb11, cNormalizeMetaState8, iRed8, -785931255, false, (String) objArr91111115[0], null);
                                }
                                ((Field) objAccessartificialFrame23).set(null, lValueOf15);
                            }
                            objArr8 = objArr7;
                            i20 = 0;
                        } else {
                            baseContext4 = getBaseContext();
                            if (baseContext4 == null) {
                                Object[] objArr811113 = new Object[1];
                                a(false, TextUtils.lastIndexOf("", '0', 0) + 23, (android.os.SystemClock.elapsedRealtime() > 0L ? 1 : (android.os.SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 263, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 5, new char[]{'\f', 6, 1, 65483, 65534, CharUtils.CR, CharUtils.CR, 65483, 65502, 0, 17, 6, 19, 6, 17, 22, 65521, 5, 15, 2, 65534, 1, 65534, 11, 1, 15}, objArr811113);
                                Class<?> cls1117 = Class.forName((String) objArr811113[0]);
                                Object[] objArr91111116 = new Object[1];
                                a(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length(), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(7) + 156, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 14, new char[]{'\b', '\b', 11, 65529, 4, 5, 65535, '\n', 65527, 65529, 65535, 2, 6, 6, 65495, '\n', 4, 65531}, objArr91111116);
                                baseContext4 = (Context) cls1117.getMethod((String) objArr91111116[0], new Class[0]).invoke(null, null);
                            }
                            if (baseContext4 != null) {
                                i21 = artificialFrame + 71;
                                getARTIFICIAL_FRAME_PACKAGE_NAME = i21 % 128;
                                if (i21 % 2 != 0) {
                                    int i17111111 = 97 / 0;
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
                            int iIntValue10 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
                            Object[] objArr91111117 = new Object[1];
                            a(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 19, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(19) + 128, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(17) - 41, new char[]{65511, 28, 65513, 26, 25, 65517, 27, 23, 25, 65510, 23, 65516, 65514, 65519, 65517, 23, 23, 28, 65510, 25, 65514, 65518, 65515, 28, 25, 65510, 28, 65519, 28, 65518, 26, 65515, 65515, 28, 28, 27, 65518, 26, 65510, 65513, 23, 65517, 28, 65518, 65519, 65515, 65515, 65516, 26, 27, 28, 65518, 65516, 65510, 23, 65515, 65519, 25, 65517, 28, 27, 65513, 65512, 65517}, objArr91111117);
                            String str16 = (String) objArr91111117[0];
                            Object[] objArr91111118 = new Object[1];
                            a(false, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 3, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 213, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 29, new char[]{65524, 65517, 65520, 65517, 65518, 65515, 65522, 65517, 65522, 65518, 28, '!', 29, ' ', 65521, 65521, 29, 28, 65523, 65518, 65515, 28, '!', ' ', 65520, 65522, ' ', ' ', ' ', '!', 65515, 65519, 65516, 65524, 65520, 29, 65521, 65518, 31, 65524, 65518, 65521, 65516, ' ', 28, '!', 65520, 28, 65524, 65519, 65521, 65517, 31, 65520, 29, 65517, 65520, 65518, 65517, 65517, 65520, 28, ' ', 65520}, objArr91111118);
                            String[] strArr117 = {str16, (String) objArr91111118[0]};
                            int i181118 = artificialFrame + 119;
                            getARTIFICIAL_FRAME_PACKAGE_NAME = i181118 % 128;
                            int i181119 = i181118 % 2;
                            Object[] objArr91111119 = {baseContext4, strArr117, Integer.valueOf(iIntValue10), 1, 109774963};
                            byte[] bArr2119 = $$d;
                            byte b31116 = bArr2119[60];
                            Object[] objArr911111110 = new Object[1];
                            c(b31116, (short) (b31116 | 66), bArr2119[8], objArr911111110);
                            Class<?> cls1118 = Class.forName((String) objArr911111110[0]);
                            Object[] objArr911111111 = new Object[1];
                            c((byte) (bArr2119[242] - 1), (short) 107, bArr2119[455], objArr911111111);
                            objArr7 = (Object[]) cls1118.getMethod((String) objArr911111111[0], Context.class, String[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr91111119);
                            int i1811110 = ((int[]) objArr7[0])[0];
                            int i1811111 = ((int[]) objArr7[3])[0];
                            if (baseContext4 != null) {
                                objAccessartificialFrame22 = ArtificialStackFrames.accessartificialFrame(1142731807);
                                if (objAccessartificialFrame22 == null) {
                                    int iIndexOf19 = 21 - TextUtils.indexOf("", "", 0, 0);
                                    char mode14 = (char) View.MeasureSpec.getMode(0);
                                    int iIndexOf110 = 464 - TextUtils.indexOf((CharSequence) "", '0');
                                    byte[] bArr21110 = $$a;
                                    byte b41110 = bArr21110[28];
                                    Object[] objArr911111112 = new Object[1];
                                    b(b41110, (byte) (b41110 | 39), bArr21110[5], objArr911111112);
                                    objAccessartificialFrame22 = ArtificialStackFrames.coroutineCreation(iIndexOf19, mode14, iIndexOf110, -612765161, false, (String) objArr911111112[0], null);
                                }
                                ((Field) objAccessartificialFrame22).set(null, objArr7);
                                Long lValueOf16 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                                objAccessartificialFrame23 = ArtificialStackFrames.accessartificialFrame(1313006081);
                                if (objAccessartificialFrame23 == null) {
                                    int iArgb12 = Color.argb(0, 0, 0, 0) + 21;
                                    char cNormalizeMetaState9 = (char) KeyEvent.normalizeMetaState(0);
                                    int iRed9 = 465 - Color.red(0);
                                    byte b41111 = $$a[5];
                                    byte b41112 = (byte) (b41111 - 1);
                                    Object[] objArr911111113 = new Object[1];
                                    b(b41112, (byte) (b41112 | 47), b41111, objArr911111113);
                                    objAccessartificialFrame23 = ArtificialStackFrames.coroutineCreation(iArgb12, cNormalizeMetaState9, iRed9, -785931255, false, (String) objArr911111113[0], null);
                                }
                                ((Field) objAccessartificialFrame23).set(null, lValueOf16);
                            }
                            objArr8 = objArr7;
                            i20 = 0;
                        }
                        i22 = ((int[]) objArr8[i20])[i20];
                        i23 = ((int[]) objArr8[3])[i20];
                        if (i23 == i22) {
                            Object[] objArr10115 = new Object[4];
                            int[] iArr9 = new int[1];
                            objArr10115[i20] = iArr9;
                            objArr10115[2] = new int[1];
                            int[] iArr10 = new int[1];
                            objArr10115[3] = iArr10;
                            int i191111 = ((int[]) objArr8[2])[i20];
                            int i191112 = ((int[]) objArr8[3])[i20];
                            int i191113 = ((int[]) objArr8[i20])[i20];
                            String[] strArr118 = (String[]) objArr8[1];
                            iArr10[i20] = i191112;
                            iArr9[i20] = i191113;
                            int mode15 = ((AudioManager) ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[i20]).invoke(null, null)).getSystemService("audio")).getMode();
                            int i191114 = ~mode15;
                            int i191115 = (~((-8922847) | i191114)) | 1566;
                            int i191116 = ~(mode15 | 160348159);
                            int i191117 = i191111 + ((i191115 | i191116) * (-252)) + 160744357 + ((i191116 | (~(i191114 | (-8921281)))) * 252);
                            int i2011110 = (i191117 << 13) ^ i191117;
                            int i2011111 = i2011110 ^ (i2011110 >>> 17);
                            ((int[]) objArr10115[2])[0] = i2011111 ^ (i2011111 << 5);
                            objArr10115[1] = strArr118;
                        } else {
                            arrayList2 = new ArrayList();
                            strArr2 = (String[]) objArr8[1];
                            if (strArr2 != null) {
                                while (i24 < strArr2.length) {
                                    arrayList2.add(str8);
                                }
                            }
                            Object[] objArr10116 = {Long.valueOf(((long) (i22 ^ i23)) ^ (((long) 569889844) << 32)), Long.valueOf(569889908)};
                            byte[] bArr21111 = $$d;
                            Object[] objArr10117 = new Object[1];
                            c(bArr21111[39], bArr21111[265], bArr21111[8], objArr10117);
                            Class<?> cls1119 = Class.forName((String) objArr10117[0]);
                            byte b41113 = (byte) (-bArr21111[81]);
                            Object[] objArr10118 = new Object[1];
                            c(b41113, (short) (b41113 | 529), bArr21111[232], objArr10118);
                            cls1119.getMethod((String) objArr10118[0], Long.TYPE, Long.TYPE).invoke(null, objArr10116);
                            Object[] objArr10119 = {new int[]{i201114}, strArr115, new int[1], new int[]{i201113}};
                            int i2011112 = ((int[]) objArr8[2])[0];
                            int i2011113 = ((int[]) objArr8[3])[0];
                            int i2011114 = ((int[]) objArr8[0])[0];
                            String[] strArr119 = (String[]) objArr8[1];
                            int length5 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 1885298596;
                            int i2011115 = 655002107 + (((~((-758355811) | length5)) | 555782464 | (~((-598006085) | length5))) * (-754));
                            int i2011116 = ~((-555782465) | length5);
                            int i2011117 = ~length5;
                            int i2011118 = i2011112 + i2011115 + ((i2011116 | (~((-42223621) | i2011117))) * (-754)) + ((i2011117 | (-758355811)) * 754);
                            int i2011119 = (i2011118 << 13) ^ i2011118;
                            int i2114 = i2011119 ^ (i2011119 >>> 17);
                            ((int[]) objArr10119[2])[0] = i2114 ^ (i2114 << 5);
                        }
                        super.onStart();
                        return;
                    }
                    i17 = 0;
                    baseContext3 = getBaseContext();
                    if (baseContext3 == null) {
                        Object[] objArr1025 = new Object[1];
                        a(false, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[i17]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(i17, 4).codePointAt(2) - 14, 264 - (ViewConfiguration.getLongPressTimeout() >> 16), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[i17]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 9, new char[]{'\f', 6, 1, 65483, 65534, CharUtils.CR, CharUtils.CR, 65483, 65502, 0, 17, 6, 19, 6, 17, 22, 65521, 5, 15, 2, 65534, 1, 65534, 11, 1, 15}, objArr1025);
                        Class<?> cls1120 = Class.forName((String) objArr1025[0]);
                        Object[] objArr1026 = new Object[1];
                        a(true, 4 - KeyEvent.normalizeMetaState(0), View.getDefaultSize(0, 0) + 271, (ViewConfiguration.getScrollDefaultDelay() >> 16) + 18, new char[]{'\b', '\b', 11, 65529, 4, 5, 65535, '\n', 65527, 65529, 65535, 2, 6, 6, 65495, '\n', 4, 65531}, objArr1026);
                        baseContext3 = (Context) cls1120.getMethod((String) objArr1026[0], new Class[0]).invoke(null, null);
                    }
                    if (baseContext3 != null) {
                        int i2115 = getARTIFICIAL_FRAME_PACKAGE_NAME + 29;
                        artificialFrame = i2115 % 128;
                        int i2116 = i2115 % 2;
                        if (baseContext3 instanceof ContextWrapper) {
                            baseContext3 = baseContext3.getApplicationContext();
                        } else {
                            baseContext3 = baseContext3.getApplicationContext();
                        }
                    }
                    Object[] objArr1027 = {baseContext3, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 1340793227};
                    byte[] bArr2120 = $$d;
                    Object[] objArr1028 = new Object[1];
                    c(bArr2120[41], (short) 156, bArr2120[8], objArr1028);
                    Class<?> cls1121 = Class.forName((String) objArr1028[0]);
                    Object[] objArr1029 = new Object[1];
                    c((byte) (bArr2120[242] - 1), (short) 107, bArr2120[455], objArr1029);
                    objArr6 = (Object[]) cls1121.getMethod((String) objArr1029[0], Context.class, Integer.TYPE, Integer.TYPE).invoke(null, objArr1027);
                    if (baseContext3 != null) {
                        objAccessartificialFrame19 = ArtificialStackFrames.accessartificialFrame(777251007);
                        if (objAccessartificialFrame19 == null) {
                            int iArgb13 = 30 - Color.argb(0, 0, 0, 0);
                            char packedPositionType4 = (char) (ExpandableListView.getPackedPositionType(0L) + 49362);
                            int i2117 = 685 - (android.os.SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (android.os.SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1));
                            byte b421 = (byte) AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
                            byte[] bArr221 = $$a;
                            Object[] objArr1111 = new Object[1];
                            b(b421, (byte) (-bArr221[15]), (byte) (bArr221[5] - 1), objArr1111);
                            objAccessartificialFrame19 = ArtificialStackFrames.coroutineCreation(iArgb13, packedPositionType4, i2117, -1321816393, false, (String) objArr1111[0], null);
                        }
                        ((Field) objAccessartificialFrame19).set(null, objArr6);
                        Long lValueOf17 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame20 = ArtificialStackFrames.accessartificialFrame(-2127922582);
                        if (objAccessartificialFrame20 == null) {
                            int capsMode4 = 30 - TextUtils.getCapsMode("", 0, 0);
                            char maximumFlingVelocity4 = (char) ((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 49362);
                            int packedPositionGroup5 = ExpandableListView.getPackedPositionGroup(0L) + 684;
                            Object[] objArr1112 = new Object[1];
                            b((byte) 97, (byte) 45, (byte) (-$$a[4]), objArr1112);
                            objAccessartificialFrame20 = ArtificialStackFrames.coroutineCreation(capsMode4, maximumFlingVelocity4, packedPositionGroup5, 508509282, false, (String) objArr1112[0], null);
                        }
                        ((Field) objAccessartificialFrame20).set(null, lValueOf17);
                        int i2118 = getARTIFICIAL_FRAME_PACKAGE_NAME + 119;
                        artificialFrame = i2118 % 128;
                        int i2119 = i2118 % 2;
                    }
                    i18 = ((int[]) objArr6[1])[0];
                    i19 = ((int[]) objArr6[0])[0];
                    if (i19 == i18) {
                        int i161113 = artificialFrame + 25;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i161113 % 128;
                        int i161114 = i161113 % 2;
                        int i161115 = ((int[]) objArr6[2])[0];
                        Object[] objArr811114 = {new int[]{((int[]) objArr6[0])[0]}, new int[]{((int[]) objArr6[1])[0]}, new int[1], (String) objArr6[3]};
                        int iIdentityHashCode18 = System.identityHashCode(this);
                        int i17111112 = ~iIdentityHashCode18;
                        int i17111113 = i161115 + 1897291658 + (((~(i17111112 | 114026812)) | (-936115199) | (~((-42508577) | iIdentityHashCode18))) * 717) + (((~(iIdentityHashCode18 | 114026812)) | (~(i17111112 | (-42508577))) | (-936115199)) * 717);
                        int i17111114 = (i17111113 << 13) ^ i17111113;
                        int i17111115 = i17111114 ^ (i17111114 >>> 17);
                        ((int[]) objArr811114[2])[0] = i17111115 ^ (i17111115 << 5);
                    } else {
                        Object[] objArr811115 = {Long.valueOf(((long) (i18 ^ i19)) ^ (((long) (-767742055)) << 32)), Long.valueOf(-767742567)};
                        byte[] bArr21112 = $$d;
                        byte b31117 = bArr21112[28];
                        Object[] objArr811116 = new Object[1];
                        c(b31117, (short) (b31117 | 421), bArr21112[8], objArr811116);
                        Class<?> cls11110 = Class.forName((String) objArr811116[0]);
                        byte b31118 = (byte) (-bArr21112[81]);
                        Object[] objArr811117 = new Object[1];
                        c(b31118, (short) (b31118 | 529), bArr21112[232], objArr811117);
                        cls11110.getMethod((String) objArr811117[0], Long.TYPE, Long.TYPE).invoke(null, objArr811115);
                        int i17111116 = ((int[]) objArr6[2])[0];
                        Object[] objArr811118 = {new int[]{((int[]) objArr6[0])[0]}, new int[]{((int[]) objArr6[1])[0]}, new int[1], (String) objArr6[3]};
                        int iIdentityHashCode19 = System.identityHashCode(this);
                        int i17111117 = ~iIdentityHashCode19;
                        int i17111118 = i17111116 + (-112133018) + (((~((-979414305) | i17111117)) | (~((-25248475) | iIdentityHashCode19)) | (~(1005453307 | iIdentityHashCode19))) * 765) + (((~((-1004662779) | i17111117)) | 979414304) * 1530) + (((~(iIdentityHashCode19 | (-1004662779))) | (~(i17111117 | 1005453307))) * 765);
                        int i17111119 = (i17111118 << 13) ^ i17111118;
                        int i171122 = i17111119 ^ (i17111119 >>> 17);
                        ((int[]) objArr811118[2])[0] = i171122 ^ (i171122 << 5);
                    }
                    objAccessartificialFrame21 = ArtificialStackFrames.accessartificialFrame(1313006081);
                    if (objAccessartificialFrame21 == null) {
                        int jumpTapTimeout7 = 21 - (ViewConfiguration.getJumpTapTimeout() >> 16);
                        char maxKeyCode9 = (char) (KeyEvent.getMaxKeyCode() >> 16);
                        int edgeSlop12 = 465 - (ViewConfiguration.getEdgeSlop() >> 16);
                        byte b31119 = $$a[5];
                        byte b311110 = (byte) (b31119 - 1);
                        Object[] objArr811119 = new Object[1];
                        b(b311110, (byte) (b311110 | 47), b31119, objArr811119);
                        objAccessartificialFrame21 = ArtificialStackFrames.coroutineCreation(jumpTapTimeout7, maxKeyCode9, edgeSlop12, -785931255, false, (String) objArr811119[0], null);
                    }
                    j6 = ((Field) objAccessartificialFrame21).getLong(null);
                    if (j6 != -1) {
                        baseContext4 = getBaseContext();
                        if (baseContext4 == null) {
                            Object[] objArr8111110 = new Object[1];
                            a(false, TextUtils.lastIndexOf("", '0', 0) + 23, (android.os.SystemClock.elapsedRealtime() > 0L ? 1 : (android.os.SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 263, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 5, new char[]{'\f', 6, 1, 65483, 65534, CharUtils.CR, CharUtils.CR, 65483, 65502, 0, 17, 6, 19, 6, 17, 22, 65521, 5, 15, 2, 65534, 1, 65534, 11, 1, 15}, objArr8111110);
                            Class<?> cls11111 = Class.forName((String) objArr8111110[0]);
                            Object[] objArr911111114 = new Object[1];
                            a(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length(), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(7) + 156, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 14, new char[]{'\b', '\b', 11, 65529, 4, 5, 65535, '\n', 65527, 65529, 65535, 2, 6, 6, 65495, '\n', 4, 65531}, objArr911111114);
                            baseContext4 = (Context) cls11111.getMethod((String) objArr911111114[0], new Class[0]).invoke(null, null);
                        }
                        if (baseContext4 != null) {
                            i21 = artificialFrame + 71;
                            getARTIFICIAL_FRAME_PACKAGE_NAME = i21 % 128;
                            if (i21 % 2 != 0) {
                                int i171111110 = 97 / 0;
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
                        int iIntValue11 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
                        Object[] objArr911111115 = new Object[1];
                        a(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 19, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(19) + 128, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(17) - 41, new char[]{65511, 28, 65513, 26, 25, 65517, 27, 23, 25, 65510, 23, 65516, 65514, 65519, 65517, 23, 23, 28, 65510, 25, 65514, 65518, 65515, 28, 25, 65510, 28, 65519, 28, 65518, 26, 65515, 65515, 28, 28, 27, 65518, 26, 65510, 65513, 23, 65517, 28, 65518, 65519, 65515, 65515, 65516, 26, 27, 28, 65518, 65516, 65510, 23, 65515, 65519, 25, 65517, 28, 27, 65513, 65512, 65517}, objArr911111115);
                        String str17 = (String) objArr911111115[0];
                        Object[] objArr911111116 = new Object[1];
                        a(false, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 3, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 213, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 29, new char[]{65524, 65517, 65520, 65517, 65518, 65515, 65522, 65517, 65522, 65518, 28, '!', 29, ' ', 65521, 65521, 29, 28, 65523, 65518, 65515, 28, '!', ' ', 65520, 65522, ' ', ' ', ' ', '!', 65515, 65519, 65516, 65524, 65520, 29, 65521, 65518, 31, 65524, 65518, 65521, 65516, ' ', 28, '!', 65520, 28, 65524, 65519, 65521, 65517, 31, 65520, 29, 65517, 65520, 65518, 65517, 65517, 65520, 28, ' ', 65520}, objArr911111116);
                        String[] strArr1110 = {str17, (String) objArr911111116[0]};
                        int i1811112 = artificialFrame + 119;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i1811112 % 128;
                        int i1811113 = i1811112 % 2;
                        Object[] objArr911111117 = {baseContext4, strArr1110, Integer.valueOf(iIntValue11), 1, 109774963};
                        byte[] bArr21113 = $$d;
                        byte b311111 = bArr21113[60];
                        Object[] objArr911111118 = new Object[1];
                        c(b311111, (short) (b311111 | 66), bArr21113[8], objArr911111118);
                        Class<?> cls11112 = Class.forName((String) objArr911111118[0]);
                        Object[] objArr911111119 = new Object[1];
                        c((byte) (bArr21113[242] - 1), (short) 107, bArr21113[455], objArr911111119);
                        objArr7 = (Object[]) cls11112.getMethod((String) objArr911111119[0], Context.class, String[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr911111117);
                        int i1811114 = ((int[]) objArr7[0])[0];
                        int i1811115 = ((int[]) objArr7[3])[0];
                        if (baseContext4 != null) {
                            objAccessartificialFrame22 = ArtificialStackFrames.accessartificialFrame(1142731807);
                            if (objAccessartificialFrame22 == null) {
                                int iIndexOf111 = 21 - TextUtils.indexOf("", "", 0, 0);
                                char mode16 = (char) View.MeasureSpec.getMode(0);
                                int iIndexOf112 = 464 - TextUtils.indexOf((CharSequence) "", '0');
                                byte[] bArr21114 = $$a;
                                byte b41114 = bArr21114[28];
                                Object[] objArr9111111110 = new Object[1];
                                b(b41114, (byte) (b41114 | 39), bArr21114[5], objArr9111111110);
                                objAccessartificialFrame22 = ArtificialStackFrames.coroutineCreation(iIndexOf111, mode16, iIndexOf112, -612765161, false, (String) objArr9111111110[0], null);
                            }
                            ((Field) objAccessartificialFrame22).set(null, objArr7);
                            Long lValueOf18 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                            objAccessartificialFrame23 = ArtificialStackFrames.accessartificialFrame(1313006081);
                            if (objAccessartificialFrame23 == null) {
                                int iArgb14 = Color.argb(0, 0, 0, 0) + 21;
                                char cNormalizeMetaState10 = (char) KeyEvent.normalizeMetaState(0);
                                int iRed10 = 465 - Color.red(0);
                                byte b41115 = $$a[5];
                                byte b41116 = (byte) (b41115 - 1);
                                Object[] objArr9111111111 = new Object[1];
                                b(b41116, (byte) (b41116 | 47), b41115, objArr9111111111);
                                objAccessartificialFrame23 = ArtificialStackFrames.coroutineCreation(iArgb14, cNormalizeMetaState10, iRed10, -785931255, false, (String) objArr9111111111[0], null);
                            }
                            ((Field) objAccessartificialFrame23).set(null, lValueOf18);
                        }
                        objArr8 = objArr7;
                        i20 = 0;
                    } else {
                        baseContext4 = getBaseContext();
                        if (baseContext4 == null) {
                            Object[] objArr8111111 = new Object[1];
                            a(false, TextUtils.lastIndexOf("", '0', 0) + 23, (android.os.SystemClock.elapsedRealtime() > 0L ? 1 : (android.os.SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 263, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 5, new char[]{'\f', 6, 1, 65483, 65534, CharUtils.CR, CharUtils.CR, 65483, 65502, 0, 17, 6, 19, 6, 17, 22, 65521, 5, 15, 2, 65534, 1, 65534, 11, 1, 15}, objArr8111111);
                            Class<?> cls11113 = Class.forName((String) objArr8111111[0]);
                            Object[] objArr9111111112 = new Object[1];
                            a(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length(), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(7) + 156, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 14, new char[]{'\b', '\b', 11, 65529, 4, 5, 65535, '\n', 65527, 65529, 65535, 2, 6, 6, 65495, '\n', 4, 65531}, objArr9111111112);
                            baseContext4 = (Context) cls11113.getMethod((String) objArr9111111112[0], new Class[0]).invoke(null, null);
                        }
                        if (baseContext4 != null) {
                            i21 = artificialFrame + 71;
                            getARTIFICIAL_FRAME_PACKAGE_NAME = i21 % 128;
                            if (i21 % 2 != 0) {
                                int i171111111 = 97 / 0;
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
                        int iIntValue12 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
                        Object[] objArr9111111113 = new Object[1];
                        a(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 19, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(19) + 128, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(17) - 41, new char[]{65511, 28, 65513, 26, 25, 65517, 27, 23, 25, 65510, 23, 65516, 65514, 65519, 65517, 23, 23, 28, 65510, 25, 65514, 65518, 65515, 28, 25, 65510, 28, 65519, 28, 65518, 26, 65515, 65515, 28, 28, 27, 65518, 26, 65510, 65513, 23, 65517, 28, 65518, 65519, 65515, 65515, 65516, 26, 27, 28, 65518, 65516, 65510, 23, 65515, 65519, 25, 65517, 28, 27, 65513, 65512, 65517}, objArr9111111113);
                        String str18 = (String) objArr9111111113[0];
                        Object[] objArr9111111114 = new Object[1];
                        a(false, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 3, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 213, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 29, new char[]{65524, 65517, 65520, 65517, 65518, 65515, 65522, 65517, 65522, 65518, 28, '!', 29, ' ', 65521, 65521, 29, 28, 65523, 65518, 65515, 28, '!', ' ', 65520, 65522, ' ', ' ', ' ', '!', 65515, 65519, 65516, 65524, 65520, 29, 65521, 65518, 31, 65524, 65518, 65521, 65516, ' ', 28, '!', 65520, 28, 65524, 65519, 65521, 65517, 31, 65520, 29, 65517, 65520, 65518, 65517, 65517, 65520, 28, ' ', 65520}, objArr9111111114);
                        String[] strArr1111 = {str18, (String) objArr9111111114[0]};
                        int i1811116 = artificialFrame + 119;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i1811116 % 128;
                        int i1811117 = i1811116 % 2;
                        Object[] objArr9111111115 = {baseContext4, strArr1111, Integer.valueOf(iIntValue12), 1, 109774963};
                        byte[] bArr21115 = $$d;
                        byte b311112 = bArr21115[60];
                        Object[] objArr9111111116 = new Object[1];
                        c(b311112, (short) (b311112 | 66), bArr21115[8], objArr9111111116);
                        Class<?> cls11114 = Class.forName((String) objArr9111111116[0]);
                        Object[] objArr9111111117 = new Object[1];
                        c((byte) (bArr21115[242] - 1), (short) 107, bArr21115[455], objArr9111111117);
                        objArr7 = (Object[]) cls11114.getMethod((String) objArr9111111117[0], Context.class, String[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr9111111115);
                        int i1811118 = ((int[]) objArr7[0])[0];
                        int i1811119 = ((int[]) objArr7[3])[0];
                        if (baseContext4 != null) {
                            objAccessartificialFrame22 = ArtificialStackFrames.accessartificialFrame(1142731807);
                            if (objAccessartificialFrame22 == null) {
                                int iIndexOf113 = 21 - TextUtils.indexOf("", "", 0, 0);
                                char mode17 = (char) View.MeasureSpec.getMode(0);
                                int iIndexOf114 = 464 - TextUtils.indexOf((CharSequence) "", '0');
                                byte[] bArr21116 = $$a;
                                byte b41117 = bArr21116[28];
                                Object[] objArr9111111118 = new Object[1];
                                b(b41117, (byte) (b41117 | 39), bArr21116[5], objArr9111111118);
                                objAccessartificialFrame22 = ArtificialStackFrames.coroutineCreation(iIndexOf113, mode17, iIndexOf114, -612765161, false, (String) objArr9111111118[0], null);
                            }
                            ((Field) objAccessartificialFrame22).set(null, objArr7);
                            Long lValueOf19 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                            objAccessartificialFrame23 = ArtificialStackFrames.accessartificialFrame(1313006081);
                            if (objAccessartificialFrame23 == null) {
                                int iArgb15 = Color.argb(0, 0, 0, 0) + 21;
                                char cNormalizeMetaState11 = (char) KeyEvent.normalizeMetaState(0);
                                int iRed11 = 465 - Color.red(0);
                                byte b41118 = $$a[5];
                                byte b41119 = (byte) (b41118 - 1);
                                Object[] objArr9111111119 = new Object[1];
                                b(b41119, (byte) (b41119 | 47), b41118, objArr9111111119);
                                objAccessartificialFrame23 = ArtificialStackFrames.coroutineCreation(iArgb15, cNormalizeMetaState11, iRed11, -785931255, false, (String) objArr9111111119[0], null);
                            }
                            ((Field) objAccessartificialFrame23).set(null, lValueOf19);
                        }
                        objArr8 = objArr7;
                        i20 = 0;
                    }
                    i22 = ((int[]) objArr8[i20])[i20];
                    i23 = ((int[]) objArr8[3])[i20];
                    if (i23 == i22) {
                        Object[] objArr101110 = new Object[4];
                        int[] iArr11 = new int[1];
                        objArr101110[i20] = iArr11;
                        objArr101110[2] = new int[1];
                        int[] iArr12 = new int[1];
                        objArr101110[3] = iArr12;
                        int i191118 = ((int[]) objArr8[2])[i20];
                        int i191119 = ((int[]) objArr8[3])[i20];
                        int i1911110 = ((int[]) objArr8[i20])[i20];
                        String[] strArr1112 = (String[]) objArr8[1];
                        iArr12[i20] = i191119;
                        iArr11[i20] = i1911110;
                        int mode18 = ((AudioManager) ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[i20]).invoke(null, null)).getSystemService("audio")).getMode();
                        int i1911111 = ~mode18;
                        int i1911112 = (~((-8922847) | i1911111)) | 1566;
                        int i1911113 = ~(mode18 | 160348159);
                        int i1911114 = i191118 + ((i1911112 | i1911113) * (-252)) + 160744357 + ((i1911113 | (~(i1911111 | (-8921281)))) * 252);
                        int i20111110 = (i1911114 << 13) ^ i1911114;
                        int i20111111 = i20111110 ^ (i20111110 >>> 17);
                        ((int[]) objArr101110[2])[0] = i20111111 ^ (i20111111 << 5);
                        objArr101110[1] = strArr1112;
                    } else {
                        arrayList2 = new ArrayList();
                        strArr2 = (String[]) objArr8[1];
                        if (strArr2 != null) {
                            while (i24 < strArr2.length) {
                                arrayList2.add(str8);
                            }
                        }
                        Object[] objArr101111 = {Long.valueOf(((long) (i22 ^ i23)) ^ (((long) 569889844) << 32)), Long.valueOf(569889908)};
                        byte[] bArr21117 = $$d;
                        Object[] objArr101112 = new Object[1];
                        c(bArr21117[39], bArr21117[265], bArr21117[8], objArr101112);
                        Class<?> cls11115 = Class.forName((String) objArr101112[0]);
                        byte b411110 = (byte) (-bArr21117[81]);
                        Object[] objArr101113 = new Object[1];
                        c(b411110, (short) (b411110 | 529), bArr21117[232], objArr101113);
                        cls11115.getMethod((String) objArr101113[0], Long.TYPE, Long.TYPE).invoke(null, objArr101111);
                        Object[] objArr101114 = {new int[]{i2011114}, strArr119, new int[1], new int[]{i2011113}};
                        int i20111112 = ((int[]) objArr8[2])[0];
                        int i20111113 = ((int[]) objArr8[3])[0];
                        int i20111114 = ((int[]) objArr8[0])[0];
                        String[] strArr1113 = (String[]) objArr8[1];
                        int length6 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 1885298596;
                        int i20111115 = 655002107 + (((~((-758355811) | length6)) | 555782464 | (~((-598006085) | length6))) * (-754));
                        int i20111116 = ~((-555782465) | length6);
                        int i20111117 = ~length6;
                        int i20111118 = i20111112 + i20111115 + ((i20111116 | (~((-42223621) | i20111117))) * (-754)) + ((i20111117 | (-758355811)) * 754);
                        int i20111119 = (i20111118 << 13) ^ i20111118;
                        int i21110 = i20111119 ^ (i20111119 >>> 17);
                        ((int[]) objArr101114[2])[0] = i21110 ^ (i21110 << 5);
                    }
                    super.onStart();
                    return;
                }
                i13 = 0;
                Long lValueOf20 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                objAccessartificialFrame15 = ArtificialStackFrames.accessartificialFrame(1745676544);
                if (objAccessartificialFrame15 == null) {
                    int iIndexOf20 = 16 - TextUtils.indexOf((CharSequence) "", '0');
                    char c8 = (char) (1 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)));
                    int edgeSlop13 = (ViewConfiguration.getEdgeSlop() >> 16) + 747;
                    byte b53 = $$a[5];
                    byte b54 = (byte) (b53 - 1);
                    Object[] objArr1113 = new Object[1];
                    b(b54, (byte) (b54 | 47), b53, objArr1113);
                    objAccessartificialFrame15 = ArtificialStackFrames.coroutineCreation(iIndexOf20, c8, edgeSlop13, -144068856, false, (String) objArr1113[0], null);
                }
                ((Field) objAccessartificialFrame15).set(null, lValueOf20);
                i14 = ((int[]) objArr5[4])[0];
                i15 = ((int[]) objArr5[3])[0];
                if (i15 == i14) {
                    Object[] objArr7116 = {list13, new int[1], list14, new int[]{i14111}, new int[]{i14112}};
                    int i14114 = ((int[]) objArr5[1])[0];
                    int i14115 = ((int[]) objArr5[3])[0];
                    int i14116 = ((int[]) objArr5[4])[0];
                    List list17 = (List) objArr5[0];
                    List list18 = (List) objArr5[2];
                    int i14117 = ~System.identityHashCode(this);
                    int i151110 = i14114 + (-1061850123) + ((~((-450905154) | i14117)) * (-783)) + (((~(i14117 | (-451079498))) | (-1056527956)) * 783);
                    int i151111 = (i151110 << 13) ^ i151110;
                    int i151112 = i151111 ^ (i151111 >>> 17);
                    i16 = 0;
                    ((int[]) objArr7116[1])[0] = i151112 ^ (i151112 << 5);
                } else {
                    ArrayList arrayList7 = new ArrayList();
                    Object[] objArr7117 = {objArr5};
                    objAccessartificialFrame16 = ArtificialStackFrames.accessartificialFrame(1804664566);
                    if (objAccessartificialFrame16 == null) {
                        objAccessartificialFrame16 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getTouchSlop() >> 8) + 41, (char) (12468 - TextUtils.getOffsetBefore("", 0)), TextUtils.lastIndexOf("", '0', 0) + 3643, -185222914, false, "coroutineCreation", new Class[]{Object[].class});
                    }
                    arrayList7.add(((Method) objAccessartificialFrame16).invoke(null, objArr7117));
                    Object[] objArr7118 = {objArr5};
                    objAccessartificialFrame17 = ArtificialStackFrames.accessartificialFrame(-1243809191);
                    if (objAccessartificialFrame17 == null) {
                        objAccessartificialFrame17 = ArtificialStackFrames.coroutineCreation(40 - TextUtils.lastIndexOf("", '0', 0), (char) ((ViewConfiguration.getTapTimeout() >> 16) + 12468), 3643 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), 716815441, false, "ArtificialStackFrames", new Class[]{Object[].class});
                    }
                    arrayList7.add(((Method) objAccessartificialFrame17).invoke(null, objArr7118));
                    long j19 = ((long) (i14 ^ i15)) ^ (((long) 1526814264) << 32);
                    long j110 = 1526814256;
                    int i151113 = artificialFrame + 71;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i151113 % 128;
                    int i151114 = i151113 % 2;
                    Object[] objArr7119 = {Long.valueOf(j19), Long.valueOf(j110)};
                    byte[] bArr115 = $$d;
                    byte b3123 = bArr115[74];
                    Object[] objArr71110 = new Object[1];
                    c(b3123, (short) (b3123 | 216), bArr115[8], objArr71110);
                    Class<?> cls24 = Class.forName((String) objArr71110[0]);
                    byte b3124 = (byte) (-bArr115[81]);
                    Object[] objArr71111 = new Object[1];
                    c(b3124, (short) (b3124 | 529), bArr115[232], objArr71111);
                    cls24.getMethod((String) objArr71111[0], Long.TYPE, Long.TYPE).invoke(null, objArr7119);
                    Object[] objArr71112 = {list15, new int[1], list16, new int[]{i15116}, new int[]{i15117}};
                    int i151115 = ((int[]) objArr5[1])[0];
                    int i151116 = ((int[]) objArr5[3])[0];
                    int i151117 = ((int[]) objArr5[4])[0];
                    List list19 = (List) objArr5[0];
                    List list110 = (List) objArr5[2];
                    int iIdentityHashCode110 = System.identityHashCode(this);
                    int i151118 = i151115 + (((~(iIdentityHashCode110 | 145144368)) * TypedValues.CycleType.TYPE_EASING) - 164569299) + (((~((~iIdentityHashCode110) | 145144368)) | 136751632) * TypedValues.CycleType.TYPE_EASING);
                    int i151119 = (i151118 << 13) ^ i151118;
                    int i161116 = i151119 ^ (i151119 >>> 17);
                    i16 = 0;
                    ((int[]) objArr71112[1])[0] = i161116 ^ (i161116 << 5);
                }
                objAccessartificialFrame18 = ArtificialStackFrames.accessartificialFrame(-2127922582);
                if (objAccessartificialFrame18 == null) {
                    int iLastIndexOf4 = 29 - TextUtils.lastIndexOf("", '0', i16, i16);
                    char edgeSlop14 = (char) ((ViewConfiguration.getEdgeSlop() >> 16) + 49362);
                    int i161117 = 685 - (android.os.SystemClock.elapsedRealtime() > 0L ? 1 : (android.os.SystemClock.elapsedRealtime() == 0L ? 0 : -1));
                    Object[] objArr8122 = new Object[1];
                    b((byte) 97, (byte) 45, (byte) (-$$a[4]), objArr8122);
                    objAccessartificialFrame18 = ArtificialStackFrames.coroutineCreation(iLastIndexOf4, edgeSlop14, i161117, 508509282, false, (String) objArr8122[0], null);
                }
                j5 = ((Field) objAccessartificialFrame18).getLong(null);
                if (j5 != -1) {
                    if (j5 + 1885 >= ((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue()) {
                        objAccessartificialFrame24 = ArtificialStackFrames.accessartificialFrame(777251007);
                        if (objAccessartificialFrame24 == null) {
                            int i161118 = (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 30;
                            char cRgb4 = (char) (Color.rgb(0, 0, 0) + 16826578);
                            int deadChar5 = 684 - KeyEvent.getDeadChar(0, 0);
                            byte b3125 = (byte) AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
                            byte[] bArr116 = $$a;
                            Object[] objArr8123 = new Object[1];
                            b(b3125, (byte) (-bArr116[15]), (byte) (bArr116[5] - 1), objArr8123);
                            objAccessartificialFrame24 = ArtificialStackFrames.coroutineCreation(i161118, cRgb4, deadChar5, -1321816393, false, (String) objArr8123[0], null);
                        }
                        Object[] objArr822 = (Object[]) ((Field) objAccessartificialFrame24).get(null);
                        objArr6 = new Object[]{new int[]{((int[]) objArr822[0])[0]}, new int[]{((int[]) objArr822[1])[0]}, new int[1], (String) objArr822[3]};
                        int i161119 = ~(((int) Runtime.getRuntime().freeMemory()) | 363037844);
                        int i16123 = (((823303198 | i161119) * (-658)) - 221505402) + ((i161119 | 537925642) * 658) + 1340793227;
                        int i16124 = (i16123 << 13) ^ i16123;
                        int i16125 = i16124 ^ (i16124 >>> 17);
                        ((int[]) objArr6[2])[0] = i16125 ^ (i16125 << 5);
                    } else {
                        i17 = 0;
                    }
                    i18 = ((int[]) objArr6[1])[0];
                    i19 = ((int[]) objArr6[0])[0];
                    if (i19 == i18) {
                        int i1611110 = artificialFrame + 25;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i1611110 % 128;
                        int i1611111 = i1611110 % 2;
                        int i1611112 = ((int[]) objArr6[2])[0];
                        Object[] objArr8111112 = {new int[]{((int[]) objArr6[0])[0]}, new int[]{((int[]) objArr6[1])[0]}, new int[1], (String) objArr6[3]};
                        int iIdentityHashCode111 = System.identityHashCode(this);
                        int i171111112 = ~iIdentityHashCode111;
                        int i171111113 = i1611112 + 1897291658 + (((~(i171111112 | 114026812)) | (-936115199) | (~((-42508577) | iIdentityHashCode111))) * 717) + (((~(iIdentityHashCode111 | 114026812)) | (~(i171111112 | (-42508577))) | (-936115199)) * 717);
                        int i171111114 = (i171111113 << 13) ^ i171111113;
                        int i171111115 = i171111114 ^ (i171111114 >>> 17);
                        ((int[]) objArr8111112[2])[0] = i171111115 ^ (i171111115 << 5);
                    } else {
                        Object[] objArr8111113 = {Long.valueOf(((long) (i18 ^ i19)) ^ (((long) (-767742055)) << 32)), Long.valueOf(-767742567)};
                        byte[] bArr21118 = $$d;
                        byte b311113 = bArr21118[28];
                        Object[] objArr8111114 = new Object[1];
                        c(b311113, (short) (b311113 | 421), bArr21118[8], objArr8111114);
                        Class<?> cls11116 = Class.forName((String) objArr8111114[0]);
                        byte b311114 = (byte) (-bArr21118[81]);
                        Object[] objArr8111115 = new Object[1];
                        c(b311114, (short) (b311114 | 529), bArr21118[232], objArr8111115);
                        cls11116.getMethod((String) objArr8111115[0], Long.TYPE, Long.TYPE).invoke(null, objArr8111113);
                        int i171111116 = ((int[]) objArr6[2])[0];
                        Object[] objArr8111116 = {new int[]{((int[]) objArr6[0])[0]}, new int[]{((int[]) objArr6[1])[0]}, new int[1], (String) objArr6[3]};
                        int iIdentityHashCode112 = System.identityHashCode(this);
                        int i171111117 = ~iIdentityHashCode112;
                        int i171111118 = i171111116 + (-112133018) + (((~((-979414305) | i171111117)) | (~((-25248475) | iIdentityHashCode112)) | (~(1005453307 | iIdentityHashCode112))) * 765) + (((~((-1004662779) | i171111117)) | 979414304) * 1530) + (((~(iIdentityHashCode112 | (-1004662779))) | (~(i171111117 | 1005453307))) * 765);
                        int i171111119 = (i171111118 << 13) ^ i171111118;
                        int i171123 = i171111119 ^ (i171111119 >>> 17);
                        ((int[]) objArr8111116[2])[0] = i171123 ^ (i171123 << 5);
                    }
                    objAccessartificialFrame21 = ArtificialStackFrames.accessartificialFrame(1313006081);
                    if (objAccessartificialFrame21 == null) {
                        int jumpTapTimeout8 = 21 - (ViewConfiguration.getJumpTapTimeout() >> 16);
                        char maxKeyCode10 = (char) (KeyEvent.getMaxKeyCode() >> 16);
                        int edgeSlop15 = 465 - (ViewConfiguration.getEdgeSlop() >> 16);
                        byte b311115 = $$a[5];
                        byte b311116 = (byte) (b311115 - 1);
                        Object[] objArr8111117 = new Object[1];
                        b(b311116, (byte) (b311116 | 47), b311115, objArr8111117);
                        objAccessartificialFrame21 = ArtificialStackFrames.coroutineCreation(jumpTapTimeout8, maxKeyCode10, edgeSlop15, -785931255, false, (String) objArr8111117[0], null);
                    }
                    j6 = ((Field) objAccessartificialFrame21).getLong(null);
                    if (j6 != -1) {
                        baseContext4 = getBaseContext();
                        if (baseContext4 == null) {
                            Object[] objArr8111118 = new Object[1];
                            a(false, TextUtils.lastIndexOf("", '0', 0) + 23, (android.os.SystemClock.elapsedRealtime() > 0L ? 1 : (android.os.SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 263, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 5, new char[]{'\f', 6, 1, 65483, 65534, CharUtils.CR, CharUtils.CR, 65483, 65502, 0, 17, 6, 19, 6, 17, 22, 65521, 5, 15, 2, 65534, 1, 65534, 11, 1, 15}, objArr8111118);
                            Class<?> cls11117 = Class.forName((String) objArr8111118[0]);
                            Object[] objArr91111111110 = new Object[1];
                            a(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length(), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(7) + 156, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 14, new char[]{'\b', '\b', 11, 65529, 4, 5, 65535, '\n', 65527, 65529, 65535, 2, 6, 6, 65495, '\n', 4, 65531}, objArr91111111110);
                            baseContext4 = (Context) cls11117.getMethod((String) objArr91111111110[0], new Class[0]).invoke(null, null);
                        }
                        if (baseContext4 != null) {
                            i21 = artificialFrame + 71;
                            getARTIFICIAL_FRAME_PACKAGE_NAME = i21 % 128;
                            if (i21 % 2 != 0) {
                                int i1711111110 = 97 / 0;
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
                        int iIntValue13 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
                        Object[] objArr91111111111 = new Object[1];
                        a(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 19, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(19) + 128, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(17) - 41, new char[]{65511, 28, 65513, 26, 25, 65517, 27, 23, 25, 65510, 23, 65516, 65514, 65519, 65517, 23, 23, 28, 65510, 25, 65514, 65518, 65515, 28, 25, 65510, 28, 65519, 28, 65518, 26, 65515, 65515, 28, 28, 27, 65518, 26, 65510, 65513, 23, 65517, 28, 65518, 65519, 65515, 65515, 65516, 26, 27, 28, 65518, 65516, 65510, 23, 65515, 65519, 25, 65517, 28, 27, 65513, 65512, 65517}, objArr91111111111);
                        String str19 = (String) objArr91111111111[0];
                        Object[] objArr91111111112 = new Object[1];
                        a(false, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 3, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 213, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 29, new char[]{65524, 65517, 65520, 65517, 65518, 65515, 65522, 65517, 65522, 65518, 28, '!', 29, ' ', 65521, 65521, 29, 28, 65523, 65518, 65515, 28, '!', ' ', 65520, 65522, ' ', ' ', ' ', '!', 65515, 65519, 65516, 65524, 65520, 29, 65521, 65518, 31, 65524, 65518, 65521, 65516, ' ', 28, '!', 65520, 28, 65524, 65519, 65521, 65517, 31, 65520, 29, 65517, 65520, 65518, 65517, 65517, 65520, 28, ' ', 65520}, objArr91111111112);
                        String[] strArr1114 = {str19, (String) objArr91111111112[0]};
                        int i18111110 = artificialFrame + 119;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i18111110 % 128;
                        int i18111111 = i18111110 % 2;
                        Object[] objArr91111111113 = {baseContext4, strArr1114, Integer.valueOf(iIntValue13), 1, 109774963};
                        byte[] bArr21119 = $$d;
                        byte b311117 = bArr21119[60];
                        Object[] objArr91111111114 = new Object[1];
                        c(b311117, (short) (b311117 | 66), bArr21119[8], objArr91111111114);
                        Class<?> cls11118 = Class.forName((String) objArr91111111114[0]);
                        Object[] objArr91111111115 = new Object[1];
                        c((byte) (bArr21119[242] - 1), (short) 107, bArr21119[455], objArr91111111115);
                        objArr7 = (Object[]) cls11118.getMethod((String) objArr91111111115[0], Context.class, String[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr91111111113);
                        int i18111112 = ((int[]) objArr7[0])[0];
                        int i18111113 = ((int[]) objArr7[3])[0];
                        if (baseContext4 != null) {
                            objAccessartificialFrame22 = ArtificialStackFrames.accessartificialFrame(1142731807);
                            if (objAccessartificialFrame22 == null) {
                                int iIndexOf115 = 21 - TextUtils.indexOf("", "", 0, 0);
                                char mode19 = (char) View.MeasureSpec.getMode(0);
                                int iIndexOf116 = 464 - TextUtils.indexOf((CharSequence) "", '0');
                                byte[] bArr211110 = $$a;
                                byte b411111 = bArr211110[28];
                                Object[] objArr91111111116 = new Object[1];
                                b(b411111, (byte) (b411111 | 39), bArr211110[5], objArr91111111116);
                                objAccessartificialFrame22 = ArtificialStackFrames.coroutineCreation(iIndexOf115, mode19, iIndexOf116, -612765161, false, (String) objArr91111111116[0], null);
                            }
                            ((Field) objAccessartificialFrame22).set(null, objArr7);
                            Long lValueOf110 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                            objAccessartificialFrame23 = ArtificialStackFrames.accessartificialFrame(1313006081);
                            if (objAccessartificialFrame23 == null) {
                                int iArgb16 = Color.argb(0, 0, 0, 0) + 21;
                                char cNormalizeMetaState12 = (char) KeyEvent.normalizeMetaState(0);
                                int iRed12 = 465 - Color.red(0);
                                byte b411112 = $$a[5];
                                byte b411113 = (byte) (b411112 - 1);
                                Object[] objArr91111111117 = new Object[1];
                                b(b411113, (byte) (b411113 | 47), b411112, objArr91111111117);
                                objAccessartificialFrame23 = ArtificialStackFrames.coroutineCreation(iArgb16, cNormalizeMetaState12, iRed12, -785931255, false, (String) objArr91111111117[0], null);
                            }
                            ((Field) objAccessartificialFrame23).set(null, lValueOf110);
                        }
                        objArr8 = objArr7;
                        i20 = 0;
                    } else {
                        baseContext4 = getBaseContext();
                        if (baseContext4 == null) {
                            Object[] objArr8111119 = new Object[1];
                            a(false, TextUtils.lastIndexOf("", '0', 0) + 23, (android.os.SystemClock.elapsedRealtime() > 0L ? 1 : (android.os.SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 263, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 5, new char[]{'\f', 6, 1, 65483, 65534, CharUtils.CR, CharUtils.CR, 65483, 65502, 0, 17, 6, 19, 6, 17, 22, 65521, 5, 15, 2, 65534, 1, 65534, 11, 1, 15}, objArr8111119);
                            Class<?> cls11119 = Class.forName((String) objArr8111119[0]);
                            Object[] objArr91111111118 = new Object[1];
                            a(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length(), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(7) + 156, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 14, new char[]{'\b', '\b', 11, 65529, 4, 5, 65535, '\n', 65527, 65529, 65535, 2, 6, 6, 65495, '\n', 4, 65531}, objArr91111111118);
                            baseContext4 = (Context) cls11119.getMethod((String) objArr91111111118[0], new Class[0]).invoke(null, null);
                        }
                        if (baseContext4 != null) {
                            i21 = artificialFrame + 71;
                            getARTIFICIAL_FRAME_PACKAGE_NAME = i21 % 128;
                            if (i21 % 2 != 0) {
                                int i1711111111 = 97 / 0;
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
                        int iIntValue14 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
                        Object[] objArr91111111119 = new Object[1];
                        a(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 19, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(19) + 128, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(17) - 41, new char[]{65511, 28, 65513, 26, 25, 65517, 27, 23, 25, 65510, 23, 65516, 65514, 65519, 65517, 23, 23, 28, 65510, 25, 65514, 65518, 65515, 28, 25, 65510, 28, 65519, 28, 65518, 26, 65515, 65515, 28, 28, 27, 65518, 26, 65510, 65513, 23, 65517, 28, 65518, 65519, 65515, 65515, 65516, 26, 27, 28, 65518, 65516, 65510, 23, 65515, 65519, 25, 65517, 28, 27, 65513, 65512, 65517}, objArr91111111119);
                        String str110 = (String) objArr91111111119[0];
                        Object[] objArr911111111110 = new Object[1];
                        a(false, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 3, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 213, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 29, new char[]{65524, 65517, 65520, 65517, 65518, 65515, 65522, 65517, 65522, 65518, 28, '!', 29, ' ', 65521, 65521, 29, 28, 65523, 65518, 65515, 28, '!', ' ', 65520, 65522, ' ', ' ', ' ', '!', 65515, 65519, 65516, 65524, 65520, 29, 65521, 65518, 31, 65524, 65518, 65521, 65516, ' ', 28, '!', 65520, 28, 65524, 65519, 65521, 65517, 31, 65520, 29, 65517, 65520, 65518, 65517, 65517, 65520, 28, ' ', 65520}, objArr911111111110);
                        String[] strArr1115 = {str110, (String) objArr911111111110[0]};
                        int i18111114 = artificialFrame + 119;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i18111114 % 128;
                        int i18111115 = i18111114 % 2;
                        Object[] objArr911111111111 = {baseContext4, strArr1115, Integer.valueOf(iIntValue14), 1, 109774963};
                        byte[] bArr211111 = $$d;
                        byte b311118 = bArr211111[60];
                        Object[] objArr911111111112 = new Object[1];
                        c(b311118, (short) (b311118 | 66), bArr211111[8], objArr911111111112);
                        Class<?> cls111110 = Class.forName((String) objArr911111111112[0]);
                        Object[] objArr911111111113 = new Object[1];
                        c((byte) (bArr211111[242] - 1), (short) 107, bArr211111[455], objArr911111111113);
                        objArr7 = (Object[]) cls111110.getMethod((String) objArr911111111113[0], Context.class, String[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr911111111111);
                        int i18111116 = ((int[]) objArr7[0])[0];
                        int i18111117 = ((int[]) objArr7[3])[0];
                        if (baseContext4 != null) {
                            objAccessartificialFrame22 = ArtificialStackFrames.accessartificialFrame(1142731807);
                            if (objAccessartificialFrame22 == null) {
                                int iIndexOf117 = 21 - TextUtils.indexOf("", "", 0, 0);
                                char mode110 = (char) View.MeasureSpec.getMode(0);
                                int iIndexOf118 = 464 - TextUtils.indexOf((CharSequence) "", '0');
                                byte[] bArr211112 = $$a;
                                byte b411114 = bArr211112[28];
                                Object[] objArr911111111114 = new Object[1];
                                b(b411114, (byte) (b411114 | 39), bArr211112[5], objArr911111111114);
                                objAccessartificialFrame22 = ArtificialStackFrames.coroutineCreation(iIndexOf117, mode110, iIndexOf118, -612765161, false, (String) objArr911111111114[0], null);
                            }
                            ((Field) objAccessartificialFrame22).set(null, objArr7);
                            Long lValueOf111 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                            objAccessartificialFrame23 = ArtificialStackFrames.accessartificialFrame(1313006081);
                            if (objAccessartificialFrame23 == null) {
                                int iArgb17 = Color.argb(0, 0, 0, 0) + 21;
                                char cNormalizeMetaState13 = (char) KeyEvent.normalizeMetaState(0);
                                int iRed13 = 465 - Color.red(0);
                                byte b411115 = $$a[5];
                                byte b411116 = (byte) (b411115 - 1);
                                Object[] objArr911111111115 = new Object[1];
                                b(b411116, (byte) (b411116 | 47), b411115, objArr911111111115);
                                objAccessartificialFrame23 = ArtificialStackFrames.coroutineCreation(iArgb17, cNormalizeMetaState13, iRed13, -785931255, false, (String) objArr911111111115[0], null);
                            }
                            ((Field) objAccessartificialFrame23).set(null, lValueOf111);
                        }
                        objArr8 = objArr7;
                        i20 = 0;
                    }
                    i22 = ((int[]) objArr8[i20])[i20];
                    i23 = ((int[]) objArr8[3])[i20];
                    if (i23 == i22) {
                        Object[] objArr101115 = new Object[4];
                        int[] iArr13 = new int[1];
                        objArr101115[i20] = iArr13;
                        objArr101115[2] = new int[1];
                        int[] iArr14 = new int[1];
                        objArr101115[3] = iArr14;
                        int i1911115 = ((int[]) objArr8[2])[i20];
                        int i1911116 = ((int[]) objArr8[3])[i20];
                        int i1911117 = ((int[]) objArr8[i20])[i20];
                        String[] strArr1116 = (String[]) objArr8[1];
                        iArr14[i20] = i1911116;
                        iArr13[i20] = i1911117;
                        int mode111 = ((AudioManager) ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[i20]).invoke(null, null)).getSystemService("audio")).getMode();
                        int i1911118 = ~mode111;
                        int i1911119 = (~((-8922847) | i1911118)) | 1566;
                        int i19111110 = ~(mode111 | 160348159);
                        int i19111111 = i1911115 + ((i1911119 | i19111110) * (-252)) + 160744357 + ((i19111110 | (~(i1911118 | (-8921281)))) * 252);
                        int i201111110 = (i19111111 << 13) ^ i19111111;
                        int i201111111 = i201111110 ^ (i201111110 >>> 17);
                        ((int[]) objArr101115[2])[0] = i201111111 ^ (i201111111 << 5);
                        objArr101115[1] = strArr1116;
                    } else {
                        arrayList2 = new ArrayList();
                        strArr2 = (String[]) objArr8[1];
                        if (strArr2 != null) {
                            while (i24 < strArr2.length) {
                                arrayList2.add(str8);
                            }
                        }
                        Object[] objArr101116 = {Long.valueOf(((long) (i22 ^ i23)) ^ (((long) 569889844) << 32)), Long.valueOf(569889908)};
                        byte[] bArr211113 = $$d;
                        Object[] objArr101117 = new Object[1];
                        c(bArr211113[39], bArr211113[265], bArr211113[8], objArr101117);
                        Class<?> cls111111 = Class.forName((String) objArr101117[0]);
                        byte b411117 = (byte) (-bArr211113[81]);
                        Object[] objArr101118 = new Object[1];
                        c(b411117, (short) (b411117 | 529), bArr211113[232], objArr101118);
                        cls111111.getMethod((String) objArr101118[0], Long.TYPE, Long.TYPE).invoke(null, objArr101116);
                        Object[] objArr101119 = {new int[]{i20111114}, strArr1113, new int[1], new int[]{i20111113}};
                        int i201111112 = ((int[]) objArr8[2])[0];
                        int i201111113 = ((int[]) objArr8[3])[0];
                        int i201111114 = ((int[]) objArr8[0])[0];
                        String[] strArr1117 = (String[]) objArr8[1];
                        int length7 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 1885298596;
                        int i201111115 = 655002107 + (((~((-758355811) | length7)) | 555782464 | (~((-598006085) | length7))) * (-754));
                        int i201111116 = ~((-555782465) | length7);
                        int i201111117 = ~length7;
                        int i201111118 = i201111112 + i201111115 + ((i201111116 | (~((-42223621) | i201111117))) * (-754)) + ((i201111117 | (-758355811)) * 754);
                        int i201111119 = (i201111118 << 13) ^ i201111118;
                        int i21111 = i201111119 ^ (i201111119 >>> 17);
                        ((int[]) objArr101119[2])[0] = i21111 ^ (i21111 << 5);
                    }
                    super.onStart();
                    return;
                }
                i17 = 0;
                baseContext3 = getBaseContext();
                if (baseContext3 == null) {
                    Object[] objArr10210 = new Object[1];
                    a(false, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[i17]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(i17, 4).codePointAt(2) - 14, 264 - (ViewConfiguration.getLongPressTimeout() >> 16), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[i17]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 9, new char[]{'\f', 6, 1, 65483, 65534, CharUtils.CR, CharUtils.CR, 65483, 65502, 0, 17, 6, 19, 6, 17, 22, 65521, 5, 15, 2, 65534, 1, 65534, 11, 1, 15}, objArr10210);
                    Class<?> cls1122 = Class.forName((String) objArr10210[0]);
                    Object[] objArr10211 = new Object[1];
                    a(true, 4 - KeyEvent.normalizeMetaState(0), View.getDefaultSize(0, 0) + 271, (ViewConfiguration.getScrollDefaultDelay() >> 16) + 18, new char[]{'\b', '\b', 11, 65529, 4, 5, 65535, '\n', 65527, 65529, 65535, 2, 6, 6, 65495, '\n', 4, 65531}, objArr10211);
                    baseContext3 = (Context) cls1122.getMethod((String) objArr10211[0], new Class[0]).invoke(null, null);
                }
                if (baseContext3 != null) {
                    int i21112 = getARTIFICIAL_FRAME_PACKAGE_NAME + 29;
                    artificialFrame = i21112 % 128;
                    int i21113 = i21112 % 2;
                    if (baseContext3 instanceof ContextWrapper) {
                        baseContext3 = baseContext3.getApplicationContext();
                    } else {
                        baseContext3 = baseContext3.getApplicationContext();
                    }
                }
                Object[] objArr10212 = {baseContext3, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 1340793227};
                byte[] bArr2121 = $$d;
                Object[] objArr10213 = new Object[1];
                c(bArr2121[41], (short) 156, bArr2121[8], objArr10213);
                Class<?> cls1123 = Class.forName((String) objArr10213[0]);
                Object[] objArr10214 = new Object[1];
                c((byte) (bArr2121[242] - 1), (short) 107, bArr2121[455], objArr10214);
                objArr6 = (Object[]) cls1123.getMethod((String) objArr10214[0], Context.class, Integer.TYPE, Integer.TYPE).invoke(null, objArr10212);
                if (baseContext3 != null) {
                    objAccessartificialFrame19 = ArtificialStackFrames.accessartificialFrame(777251007);
                    if (objAccessartificialFrame19 == null) {
                        int iArgb18 = 30 - Color.argb(0, 0, 0, 0);
                        char packedPositionType5 = (char) (ExpandableListView.getPackedPositionType(0L) + 49362);
                        int i21114 = 685 - (android.os.SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (android.os.SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1));
                        byte b422 = (byte) AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
                        byte[] bArr222 = $$a;
                        Object[] objArr1114 = new Object[1];
                        b(b422, (byte) (-bArr222[15]), (byte) (bArr222[5] - 1), objArr1114);
                        objAccessartificialFrame19 = ArtificialStackFrames.coroutineCreation(iArgb18, packedPositionType5, i21114, -1321816393, false, (String) objArr1114[0], null);
                    }
                    ((Field) objAccessartificialFrame19).set(null, objArr6);
                    Long lValueOf112 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame20 = ArtificialStackFrames.accessartificialFrame(-2127922582);
                    if (objAccessartificialFrame20 == null) {
                        int capsMode5 = 30 - TextUtils.getCapsMode("", 0, 0);
                        char maximumFlingVelocity5 = (char) ((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 49362);
                        int packedPositionGroup6 = ExpandableListView.getPackedPositionGroup(0L) + 684;
                        Object[] objArr1115 = new Object[1];
                        b((byte) 97, (byte) 45, (byte) (-$$a[4]), objArr1115);
                        objAccessartificialFrame20 = ArtificialStackFrames.coroutineCreation(capsMode5, maximumFlingVelocity5, packedPositionGroup6, 508509282, false, (String) objArr1115[0], null);
                    }
                    ((Field) objAccessartificialFrame20).set(null, lValueOf112);
                    int i21115 = getARTIFICIAL_FRAME_PACKAGE_NAME + 119;
                    artificialFrame = i21115 % 128;
                    int i21116 = i21115 % 2;
                }
                i18 = ((int[]) objArr6[1])[0];
                i19 = ((int[]) objArr6[0])[0];
                if (i19 == i18) {
                    int i1611113 = artificialFrame + 25;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i1611113 % 128;
                    int i1611114 = i1611113 % 2;
                    int i1611115 = ((int[]) objArr6[2])[0];
                    Object[] objArr81111110 = {new int[]{((int[]) objArr6[0])[0]}, new int[]{((int[]) objArr6[1])[0]}, new int[1], (String) objArr6[3]};
                    int iIdentityHashCode113 = System.identityHashCode(this);
                    int i1711111112 = ~iIdentityHashCode113;
                    int i1711111113 = i1611115 + 1897291658 + (((~(i1711111112 | 114026812)) | (-936115199) | (~((-42508577) | iIdentityHashCode113))) * 717) + (((~(iIdentityHashCode113 | 114026812)) | (~(i1711111112 | (-42508577))) | (-936115199)) * 717);
                    int i1711111114 = (i1711111113 << 13) ^ i1711111113;
                    int i1711111115 = i1711111114 ^ (i1711111114 >>> 17);
                    ((int[]) objArr81111110[2])[0] = i1711111115 ^ (i1711111115 << 5);
                } else {
                    Object[] objArr81111111 = {Long.valueOf(((long) (i18 ^ i19)) ^ (((long) (-767742055)) << 32)), Long.valueOf(-767742567)};
                    byte[] bArr211114 = $$d;
                    byte b311119 = bArr211114[28];
                    Object[] objArr81111112 = new Object[1];
                    c(b311119, (short) (b311119 | 421), bArr211114[8], objArr81111112);
                    Class<?> cls111112 = Class.forName((String) objArr81111112[0]);
                    byte b3111110 = (byte) (-bArr211114[81]);
                    Object[] objArr81111113 = new Object[1];
                    c(b3111110, (short) (b3111110 | 529), bArr211114[232], objArr81111113);
                    cls111112.getMethod((String) objArr81111113[0], Long.TYPE, Long.TYPE).invoke(null, objArr81111111);
                    int i1711111116 = ((int[]) objArr6[2])[0];
                    Object[] objArr81111114 = {new int[]{((int[]) objArr6[0])[0]}, new int[]{((int[]) objArr6[1])[0]}, new int[1], (String) objArr6[3]};
                    int iIdentityHashCode114 = System.identityHashCode(this);
                    int i1711111117 = ~iIdentityHashCode114;
                    int i1711111118 = i1711111116 + (-112133018) + (((~((-979414305) | i1711111117)) | (~((-25248475) | iIdentityHashCode114)) | (~(1005453307 | iIdentityHashCode114))) * 765) + (((~((-1004662779) | i1711111117)) | 979414304) * 1530) + (((~(iIdentityHashCode114 | (-1004662779))) | (~(i1711111117 | 1005453307))) * 765);
                    int i1711111119 = (i1711111118 << 13) ^ i1711111118;
                    int i171124 = i1711111119 ^ (i1711111119 >>> 17);
                    ((int[]) objArr81111114[2])[0] = i171124 ^ (i171124 << 5);
                }
                objAccessartificialFrame21 = ArtificialStackFrames.accessartificialFrame(1313006081);
                if (objAccessartificialFrame21 == null) {
                    int jumpTapTimeout9 = 21 - (ViewConfiguration.getJumpTapTimeout() >> 16);
                    char maxKeyCode11 = (char) (KeyEvent.getMaxKeyCode() >> 16);
                    int edgeSlop16 = 465 - (ViewConfiguration.getEdgeSlop() >> 16);
                    byte b3111111 = $$a[5];
                    byte b3111112 = (byte) (b3111111 - 1);
                    Object[] objArr81111115 = new Object[1];
                    b(b3111112, (byte) (b3111112 | 47), b3111111, objArr81111115);
                    objAccessartificialFrame21 = ArtificialStackFrames.coroutineCreation(jumpTapTimeout9, maxKeyCode11, edgeSlop16, -785931255, false, (String) objArr81111115[0], null);
                }
                j6 = ((Field) objAccessartificialFrame21).getLong(null);
                if (j6 != -1) {
                    baseContext4 = getBaseContext();
                    if (baseContext4 == null) {
                        Object[] objArr81111116 = new Object[1];
                        a(false, TextUtils.lastIndexOf("", '0', 0) + 23, (android.os.SystemClock.elapsedRealtime() > 0L ? 1 : (android.os.SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 263, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 5, new char[]{'\f', 6, 1, 65483, 65534, CharUtils.CR, CharUtils.CR, 65483, 65502, 0, 17, 6, 19, 6, 17, 22, 65521, 5, 15, 2, 65534, 1, 65534, 11, 1, 15}, objArr81111116);
                        Class<?> cls111113 = Class.forName((String) objArr81111116[0]);
                        Object[] objArr911111111116 = new Object[1];
                        a(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length(), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(7) + 156, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 14, new char[]{'\b', '\b', 11, 65529, 4, 5, 65535, '\n', 65527, 65529, 65535, 2, 6, 6, 65495, '\n', 4, 65531}, objArr911111111116);
                        baseContext4 = (Context) cls111113.getMethod((String) objArr911111111116[0], new Class[0]).invoke(null, null);
                    }
                    if (baseContext4 != null) {
                        i21 = artificialFrame + 71;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i21 % 128;
                        if (i21 % 2 != 0) {
                            int i17111111110 = 97 / 0;
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
                    int iIntValue15 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
                    Object[] objArr911111111117 = new Object[1];
                    a(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 19, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(19) + 128, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(17) - 41, new char[]{65511, 28, 65513, 26, 25, 65517, 27, 23, 25, 65510, 23, 65516, 65514, 65519, 65517, 23, 23, 28, 65510, 25, 65514, 65518, 65515, 28, 25, 65510, 28, 65519, 28, 65518, 26, 65515, 65515, 28, 28, 27, 65518, 26, 65510, 65513, 23, 65517, 28, 65518, 65519, 65515, 65515, 65516, 26, 27, 28, 65518, 65516, 65510, 23, 65515, 65519, 25, 65517, 28, 27, 65513, 65512, 65517}, objArr911111111117);
                    String str111 = (String) objArr911111111117[0];
                    Object[] objArr911111111118 = new Object[1];
                    a(false, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 3, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 213, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 29, new char[]{65524, 65517, 65520, 65517, 65518, 65515, 65522, 65517, 65522, 65518, 28, '!', 29, ' ', 65521, 65521, 29, 28, 65523, 65518, 65515, 28, '!', ' ', 65520, 65522, ' ', ' ', ' ', '!', 65515, 65519, 65516, 65524, 65520, 29, 65521, 65518, 31, 65524, 65518, 65521, 65516, ' ', 28, '!', 65520, 28, 65524, 65519, 65521, 65517, 31, 65520, 29, 65517, 65520, 65518, 65517, 65517, 65520, 28, ' ', 65520}, objArr911111111118);
                    String[] strArr1118 = {str111, (String) objArr911111111118[0]};
                    int i18111118 = artificialFrame + 119;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i18111118 % 128;
                    int i18111119 = i18111118 % 2;
                    Object[] objArr911111111119 = {baseContext4, strArr1118, Integer.valueOf(iIntValue15), 1, 109774963};
                    byte[] bArr211115 = $$d;
                    byte b3111113 = bArr211115[60];
                    Object[] objArr9111111111110 = new Object[1];
                    c(b3111113, (short) (b3111113 | 66), bArr211115[8], objArr9111111111110);
                    Class<?> cls111114 = Class.forName((String) objArr9111111111110[0]);
                    Object[] objArr9111111111111 = new Object[1];
                    c((byte) (bArr211115[242] - 1), (short) 107, bArr211115[455], objArr9111111111111);
                    objArr7 = (Object[]) cls111114.getMethod((String) objArr9111111111111[0], Context.class, String[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr911111111119);
                    int i181111110 = ((int[]) objArr7[0])[0];
                    int i181111111 = ((int[]) objArr7[3])[0];
                    if (baseContext4 != null) {
                        objAccessartificialFrame22 = ArtificialStackFrames.accessartificialFrame(1142731807);
                        if (objAccessartificialFrame22 == null) {
                            int iIndexOf119 = 21 - TextUtils.indexOf("", "", 0, 0);
                            char mode112 = (char) View.MeasureSpec.getMode(0);
                            int iIndexOf1110 = 464 - TextUtils.indexOf((CharSequence) "", '0');
                            byte[] bArr211116 = $$a;
                            byte b411118 = bArr211116[28];
                            Object[] objArr9111111111112 = new Object[1];
                            b(b411118, (byte) (b411118 | 39), bArr211116[5], objArr9111111111112);
                            objAccessartificialFrame22 = ArtificialStackFrames.coroutineCreation(iIndexOf119, mode112, iIndexOf1110, -612765161, false, (String) objArr9111111111112[0], null);
                        }
                        ((Field) objAccessartificialFrame22).set(null, objArr7);
                        Long lValueOf113 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame23 = ArtificialStackFrames.accessartificialFrame(1313006081);
                        if (objAccessartificialFrame23 == null) {
                            int iArgb19 = Color.argb(0, 0, 0, 0) + 21;
                            char cNormalizeMetaState14 = (char) KeyEvent.normalizeMetaState(0);
                            int iRed14 = 465 - Color.red(0);
                            byte b411119 = $$a[5];
                            byte b4111110 = (byte) (b411119 - 1);
                            Object[] objArr9111111111113 = new Object[1];
                            b(b4111110, (byte) (b4111110 | 47), b411119, objArr9111111111113);
                            objAccessartificialFrame23 = ArtificialStackFrames.coroutineCreation(iArgb19, cNormalizeMetaState14, iRed14, -785931255, false, (String) objArr9111111111113[0], null);
                        }
                        ((Field) objAccessartificialFrame23).set(null, lValueOf113);
                    }
                    objArr8 = objArr7;
                    i20 = 0;
                } else {
                    baseContext4 = getBaseContext();
                    if (baseContext4 == null) {
                        Object[] objArr81111117 = new Object[1];
                        a(false, TextUtils.lastIndexOf("", '0', 0) + 23, (android.os.SystemClock.elapsedRealtime() > 0L ? 1 : (android.os.SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 263, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 5, new char[]{'\f', 6, 1, 65483, 65534, CharUtils.CR, CharUtils.CR, 65483, 65502, 0, 17, 6, 19, 6, 17, 22, 65521, 5, 15, 2, 65534, 1, 65534, 11, 1, 15}, objArr81111117);
                        Class<?> cls111115 = Class.forName((String) objArr81111117[0]);
                        Object[] objArr9111111111114 = new Object[1];
                        a(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length(), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(7) + 156, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 14, new char[]{'\b', '\b', 11, 65529, 4, 5, 65535, '\n', 65527, 65529, 65535, 2, 6, 6, 65495, '\n', 4, 65531}, objArr9111111111114);
                        baseContext4 = (Context) cls111115.getMethod((String) objArr9111111111114[0], new Class[0]).invoke(null, null);
                    }
                    if (baseContext4 != null) {
                        i21 = artificialFrame + 71;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i21 % 128;
                        if (i21 % 2 != 0) {
                            int i17111111111 = 97 / 0;
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
                    int iIntValue16 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
                    Object[] objArr9111111111115 = new Object[1];
                    a(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 19, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(19) + 128, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(17) - 41, new char[]{65511, 28, 65513, 26, 25, 65517, 27, 23, 25, 65510, 23, 65516, 65514, 65519, 65517, 23, 23, 28, 65510, 25, 65514, 65518, 65515, 28, 25, 65510, 28, 65519, 28, 65518, 26, 65515, 65515, 28, 28, 27, 65518, 26, 65510, 65513, 23, 65517, 28, 65518, 65519, 65515, 65515, 65516, 26, 27, 28, 65518, 65516, 65510, 23, 65515, 65519, 25, 65517, 28, 27, 65513, 65512, 65517}, objArr9111111111115);
                    String str112 = (String) objArr9111111111115[0];
                    Object[] objArr9111111111116 = new Object[1];
                    a(false, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 3, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 213, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 29, new char[]{65524, 65517, 65520, 65517, 65518, 65515, 65522, 65517, 65522, 65518, 28, '!', 29, ' ', 65521, 65521, 29, 28, 65523, 65518, 65515, 28, '!', ' ', 65520, 65522, ' ', ' ', ' ', '!', 65515, 65519, 65516, 65524, 65520, 29, 65521, 65518, 31, 65524, 65518, 65521, 65516, ' ', 28, '!', 65520, 28, 65524, 65519, 65521, 65517, 31, 65520, 29, 65517, 65520, 65518, 65517, 65517, 65520, 28, ' ', 65520}, objArr9111111111116);
                    String[] strArr1119 = {str112, (String) objArr9111111111116[0]};
                    int i181111112 = artificialFrame + 119;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i181111112 % 128;
                    int i181111113 = i181111112 % 2;
                    Object[] objArr9111111111117 = {baseContext4, strArr1119, Integer.valueOf(iIntValue16), 1, 109774963};
                    byte[] bArr211117 = $$d;
                    byte b3111114 = bArr211117[60];
                    Object[] objArr9111111111118 = new Object[1];
                    c(b3111114, (short) (b3111114 | 66), bArr211117[8], objArr9111111111118);
                    Class<?> cls111116 = Class.forName((String) objArr9111111111118[0]);
                    Object[] objArr9111111111119 = new Object[1];
                    c((byte) (bArr211117[242] - 1), (short) 107, bArr211117[455], objArr9111111111119);
                    objArr7 = (Object[]) cls111116.getMethod((String) objArr9111111111119[0], Context.class, String[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr9111111111117);
                    int i181111114 = ((int[]) objArr7[0])[0];
                    int i181111115 = ((int[]) objArr7[3])[0];
                    if (baseContext4 != null) {
                        objAccessartificialFrame22 = ArtificialStackFrames.accessartificialFrame(1142731807);
                        if (objAccessartificialFrame22 == null) {
                            int iIndexOf1111 = 21 - TextUtils.indexOf("", "", 0, 0);
                            char mode113 = (char) View.MeasureSpec.getMode(0);
                            int iIndexOf1112 = 464 - TextUtils.indexOf((CharSequence) "", '0');
                            byte[] bArr211118 = $$a;
                            byte b4111111 = bArr211118[28];
                            Object[] objArr91111111111110 = new Object[1];
                            b(b4111111, (byte) (b4111111 | 39), bArr211118[5], objArr91111111111110);
                            objAccessartificialFrame22 = ArtificialStackFrames.coroutineCreation(iIndexOf1111, mode113, iIndexOf1112, -612765161, false, (String) objArr91111111111110[0], null);
                        }
                        ((Field) objAccessartificialFrame22).set(null, objArr7);
                        Long lValueOf114 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame23 = ArtificialStackFrames.accessartificialFrame(1313006081);
                        if (objAccessartificialFrame23 == null) {
                            int iArgb110 = Color.argb(0, 0, 0, 0) + 21;
                            char cNormalizeMetaState15 = (char) KeyEvent.normalizeMetaState(0);
                            int iRed15 = 465 - Color.red(0);
                            byte b4111112 = $$a[5];
                            byte b4111113 = (byte) (b4111112 - 1);
                            Object[] objArr91111111111111 = new Object[1];
                            b(b4111113, (byte) (b4111113 | 47), b4111112, objArr91111111111111);
                            objAccessartificialFrame23 = ArtificialStackFrames.coroutineCreation(iArgb110, cNormalizeMetaState15, iRed15, -785931255, false, (String) objArr91111111111111[0], null);
                        }
                        ((Field) objAccessartificialFrame23).set(null, lValueOf114);
                    }
                    objArr8 = objArr7;
                    i20 = 0;
                }
                i22 = ((int[]) objArr8[i20])[i20];
                i23 = ((int[]) objArr8[3])[i20];
                if (i23 == i22) {
                    Object[] objArr1011110 = new Object[4];
                    int[] iArr15 = new int[1];
                    objArr1011110[i20] = iArr15;
                    objArr1011110[2] = new int[1];
                    int[] iArr16 = new int[1];
                    objArr1011110[3] = iArr16;
                    int i19111112 = ((int[]) objArr8[2])[i20];
                    int i19111113 = ((int[]) objArr8[3])[i20];
                    int i19111114 = ((int[]) objArr8[i20])[i20];
                    String[] strArr11110 = (String[]) objArr8[1];
                    iArr16[i20] = i19111113;
                    iArr15[i20] = i19111114;
                    int mode114 = ((AudioManager) ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[i20]).invoke(null, null)).getSystemService("audio")).getMode();
                    int i19111115 = ~mode114;
                    int i19111116 = (~((-8922847) | i19111115)) | 1566;
                    int i19111117 = ~(mode114 | 160348159);
                    int i19111118 = i19111112 + ((i19111116 | i19111117) * (-252)) + 160744357 + ((i19111117 | (~(i19111115 | (-8921281)))) * 252);
                    int i2011111110 = (i19111118 << 13) ^ i19111118;
                    int i2011111111 = i2011111110 ^ (i2011111110 >>> 17);
                    ((int[]) objArr1011110[2])[0] = i2011111111 ^ (i2011111111 << 5);
                    objArr1011110[1] = strArr11110;
                } else {
                    arrayList2 = new ArrayList();
                    strArr2 = (String[]) objArr8[1];
                    if (strArr2 != null) {
                        while (i24 < strArr2.length) {
                            arrayList2.add(str8);
                        }
                    }
                    Object[] objArr1011111 = {Long.valueOf(((long) (i22 ^ i23)) ^ (((long) 569889844) << 32)), Long.valueOf(569889908)};
                    byte[] bArr211119 = $$d;
                    Object[] objArr1011112 = new Object[1];
                    c(bArr211119[39], bArr211119[265], bArr211119[8], objArr1011112);
                    Class<?> cls111117 = Class.forName((String) objArr1011112[0]);
                    byte b4111114 = (byte) (-bArr211119[81]);
                    Object[] objArr1011113 = new Object[1];
                    c(b4111114, (short) (b4111114 | 529), bArr211119[232], objArr1011113);
                    cls111117.getMethod((String) objArr1011113[0], Long.TYPE, Long.TYPE).invoke(null, objArr1011111);
                    Object[] objArr1011114 = {new int[]{i201111114}, strArr1117, new int[1], new int[]{i201111113}};
                    int i2011111112 = ((int[]) objArr8[2])[0];
                    int i2011111113 = ((int[]) objArr8[3])[0];
                    int i2011111114 = ((int[]) objArr8[0])[0];
                    String[] strArr11111 = (String[]) objArr8[1];
                    int length8 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 1885298596;
                    int i2011111115 = 655002107 + (((~((-758355811) | length8)) | 555782464 | (~((-598006085) | length8))) * (-754));
                    int i2011111116 = ~((-555782465) | length8);
                    int i2011111117 = ~length8;
                    int i2011111118 = i2011111112 + i2011111115 + ((i2011111116 | (~((-42223621) | i2011111117))) * (-754)) + ((i2011111117 | (-758355811)) * 754);
                    int i2011111119 = (i2011111118 << 13) ^ i2011111118;
                    int i21117 = i2011111119 ^ (i2011111119 >>> 17);
                    ((int[]) objArr1011114[2])[0] = i21117 ^ (i21117 << 5);
                }
                super.onStart();
                return;
            } catch (Exception unused7) {
                throw new RuntimeException();
            }
            Object[] objArr120 = {baseContext, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, 1558156163};
            byte[] bArr32 = $$d;
            byte b55 = bArr32[24];
            Object[] objArr121 = new Object[1];
            c(b55, (short) (b55 | 590), bArr32[8], objArr121);
            Class<?> cls25 = Class.forName((String) objArr121[0]);
            Object[] objArr122 = new Object[1];
            c(bArr32[242], (short) 526, (byte) (bArr32[127] - 1), objArr122);
            objArr2 = (Object[]) cls25.getMethod((String) objArr122[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr120);
            if (baseContext != null) {
                Object objAccessartificialFrame37 = ArtificialStackFrames.accessartificialFrame(-326560385);
                if (objAccessartificialFrame37 == null) {
                    int i220 = 30 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                    char cArgb = (char) (Color.argb(0, 0, 0, 0) + 49362);
                    int i221 = 685 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                    byte[] bArr33 = $$a;
                    byte b56 = (byte) (bArr33[115] - 1);
                    Object[] objArr123 = new Object[1];
                    b(b56, (byte) (b56 - 4), bArr33[28], objArr123);
                    objAccessartificialFrame37 = ArtificialStackFrames.coroutineCreation(i220, cArgb, i221, 1944867703, false, (String) objArr123[0], null);
                }
                ((Field) objAccessartificialFrame37).set(null, objArr2);
                try {
                    Long lValueOf21 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                    Object objAccessartificialFrame38 = ArtificialStackFrames.accessartificialFrame(-1283093189);
                    if (objAccessartificialFrame38 == null) {
                        int maximumFlingVelocity6 = (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 30;
                        char minimumFlingVelocity2 = (char) (49362 - (ViewConfiguration.getMinimumFlingVelocity() >> 16));
                        int iResolveSizeAndState = 684 - View.resolveSizeAndState(0, 0, 0);
                        byte[] bArr34 = $$a;
                        Object[] objArr124 = new Object[1];
                        b((byte) (-bArr34[20]), (byte) 45, bArr34[28], objArr124);
                        objAccessartificialFrame38 = ArtificialStackFrames.coroutineCreation(maximumFlingVelocity6, minimumFlingVelocity2, iResolveSizeAndState, 752929587, false, (String) objArr124[0], null);
                    }
                    ((Field) objAccessartificialFrame38).set(null, lValueOf21);
                } catch (Exception unused8) {
                    throw new RuntimeException();
                }
            }
            i2 = ((int[]) objArr2[1])[0];
            i3 = ((int[]) objArr2[0])[0];
            if (i3 == i2) {
                int i610 = ((int[]) objArr2[2])[0];
                Object[] objArr210 = {new int[]{((int[]) objArr2[0])[0]}, new int[]{((int[]) objArr2[1])[0]}, new int[1], (String) objArr2[3]};
                int iIdentityHashCode20 = System.identityHashCode(this);
                int i611 = (~((-537016887) | iIdentityHashCode20)) | 139808;
                int i612 = ~((~iIdentityHashCode20) | 978483966);
                int i613 = i610 + 1044333534 + ((i611 | i612) * (-470)) + (((~(iIdentityHashCode20 | (-536877079))) | i612) * 470);
                int i614 = (i613 << 13) ^ i613;
                int i615 = i614 ^ (i614 >>> 17);
                i4 = 0;
                ((int[]) objArr210[2])[0] = i615 ^ (i615 << 5);
            } else {
                Object[] objArr310 = {Long.valueOf(((long) (i2 ^ i3)) ^ (((long) 575472497) << 32)), Long.valueOf(575472501)};
                byte[] bArr35 = $$d;
                byte b110 = bArr35[265];
                Object[] objArr311 = new Object[1];
                c(b110, (short) (b110 | 465), bArr35[8], objArr311);
                Class<?> cls26 = Class.forName((String) objArr311[0]);
                byte b111 = (byte) (-bArr35[81]);
                Object[] objArr312 = new Object[1];
                c(b111, (short) (b111 | 529), bArr35[232], objArr312);
                cls26.getMethod((String) objArr312[0], Long.TYPE, Long.TYPE).invoke(null, objArr310);
                int i616 = ((int[]) objArr2[2])[0];
                Object[] objArr313 = {new int[]{((int[]) objArr2[0])[0]}, new int[]{((int[]) objArr2[1])[0]}, new int[1], (String) objArr2[3]};
                int i617 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().keyboard;
                int i618 = ~i617;
                int i710 = i616 + 622690542 + (((-807967365) | i617) * (-676)) + (((~(165020025 | i618)) | 807967364) * 676) + (((~(i617 | 972987389)) | (~(i618 | (-813603750))) | 5636385) * 676);
                int i711 = (i710 << 13) ^ i710;
                int i712 = i711 ^ (i711 >>> 17);
                i4 = 0;
                ((int[]) objArr313[2])[0] = i712 ^ (i712 << 5);
            }
            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(1056123296);
            if (objAccessartificialFrame == null) {
                int defaultSize3 = View.getDefaultSize(i4, i4) + 30;
                char pressedStateDuration2 = (char) (49362 - (ViewConfiguration.getPressedStateDuration() >> 16));
                int scrollBarSize2 = 684 - (ViewConfiguration.getScrollBarSize() >> 8);
                Object[] objArr314 = new Object[1];
                b((byte) 57, (byte) ($$b >>> 2), (byte) (-$$a[4]), objArr314);
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(defaultSize3, pressedStateDuration2, scrollBarSize2, -1583976536, false, (String) objArr314[0], null);
            }
            j = ((Field) objAccessartificialFrame).getLong(null);
            if (j != -1) {
                Object[] objArr315 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 445147881};
                byte[] bArr36 = $$d;
                Object[] objArr316 = new Object[1];
                c((byte) (-bArr36[83]), (short) 483, bArr36[8], objArr316);
                Class<?> cls27 = Class.forName((String) objArr316[0]);
                Object[] objArr317 = new Object[1];
                c((byte) (-bArr36[30]), (short) 437, bArr36[8], objArr317);
                objArr3 = (Object[]) cls27.getMethod((String) objArr317[0], Integer.TYPE, Integer.TYPE).invoke(null, objArr315);
                objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(910856866);
                if (objAccessartificialFrame2 == null) {
                    int i713 = (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 29;
                    char deadChar6 = (char) (49362 - KeyEvent.getDeadChar(0, 0));
                    int i714 = 684 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1));
                    Object[] objArr318 = new Object[1];
                    b((byte) 69, (byte) 40, $$a[5], objArr318);
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(i713, deadChar6, i714, -1456483158, false, (String) objArr318[0], null);
                }
                ((Field) objAccessartificialFrame2).set(null, objArr3);
                Long lValueOf22 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(1056123296);
                if (objAccessartificialFrame3 == null) {
                    int i715 = (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 30;
                    char size3 = (char) (49362 - View.MeasureSpec.getSize(0));
                    int absoluteGravity4 = Gravity.getAbsoluteGravity(0, 0) + 684;
                    Object[] objArr319 = new Object[1];
                    b((byte) 57, (byte) ($$b >>> 2), (byte) (-$$a[4]), objArr319);
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(i715, size3, absoluteGravity4, -1583976536, false, (String) objArr319[0], null);
                }
                ((Field) objAccessartificialFrame3).set(null, lValueOf22);
            } else {
                Object[] objArr3110 = {Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 445147881};
                byte[] bArr37 = $$d;
                Object[] objArr3111 = new Object[1];
                c((byte) (-bArr37[83]), (short) 483, bArr37[8], objArr3111);
                Class<?> cls28 = Class.forName((String) objArr3111[0]);
                Object[] objArr3112 = new Object[1];
                c((byte) (-bArr37[30]), (short) 437, bArr37[8], objArr3112);
                objArr3 = (Object[]) cls28.getMethod((String) objArr3112[0], Integer.TYPE, Integer.TYPE).invoke(null, objArr3110);
                objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(910856866);
                if (objAccessartificialFrame2 == null) {
                    int i716 = (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 29;
                    char deadChar7 = (char) (49362 - KeyEvent.getDeadChar(0, 0));
                    int i717 = 684 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1));
                    Object[] objArr3113 = new Object[1];
                    b((byte) 69, (byte) 40, $$a[5], objArr3113);
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(i716, deadChar7, i717, -1456483158, false, (String) objArr3113[0], null);
                }
                ((Field) objAccessartificialFrame2).set(null, objArr3);
                Long lValueOf23 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(1056123296);
                if (objAccessartificialFrame3 == null) {
                    int i718 = (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 30;
                    char size4 = (char) (49362 - View.MeasureSpec.getSize(0));
                    int absoluteGravity5 = Gravity.getAbsoluteGravity(0, 0) + 684;
                    Object[] objArr3114 = new Object[1];
                    b((byte) 57, (byte) ($$b >>> 2), (byte) (-$$a[4]), objArr3114);
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(i718, size4, absoluteGravity5, -1583976536, false, (String) objArr3114[0], null);
                }
                ((Field) objAccessartificialFrame3).set(null, lValueOf23);
            }
            i5 = ((int[]) objArr3[1])[0];
            i6 = ((int[]) objArr3[0])[0];
            if (i6 == i5) {
                int i810 = ((int[]) objArr3[2])[0];
                Object[] objArr410 = {new int[]{((int[]) objArr3[0])[0]}, new int[]{((int[]) objArr3[1])[0]}, new int[1], (String) objArr3[3]};
                int iMyPid2 = Process.myPid();
                int i811 = i810 + (-1751810790) + (((~((~iMyPid2) | (-67244617))) | (~(532633598 | iMyPid2))) * (-302)) + ((~((-67244617) | iMyPid2)) * (-604)) + (((~(iMyPid2 | 465388982)) | 19398806) * 302);
                int i812 = (i811 << 13) ^ i811;
                int i813 = i812 ^ (i812 >>> 17);
                ((int[]) objArr410[2])[0] = i813 ^ (i813 << 5);
            } else {
                new ArrayList().add((String) objArr3[3]);
                long j111 = ((long) (i5 ^ i6)) ^ (((long) 183426135) << 32);
                long j112 = 183426119;
                int i814 = artificialFrame + 67;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i814 % 128;
                int i815 = i814 % 2;
                Object[] objArr411 = {Long.valueOf(j111), Long.valueOf(j112)};
                byte[] bArr38 = $$d;
                byte b112 = bArr38[28];
                Object[] objArr412 = new Object[1];
                c(b112, (short) (b112 | 421), bArr38[8], objArr412);
                Class<?> cls29 = Class.forName((String) objArr412[0]);
                byte b113 = (byte) (-bArr38[81]);
                Object[] objArr413 = new Object[1];
                c(b113, (short) (b113 | 529), bArr38[232], objArr413);
                cls29.getMethod((String) objArr413[0], Long.TYPE, Long.TYPE).invoke(null, objArr411);
                int i816 = ((int[]) objArr3[2])[0];
                Object[] objArr414 = {new int[]{((int[]) objArr3[0])[0]}, new int[]{((int[]) objArr3[1])[0]}, new int[1], (String) objArr3[3]};
                int i817 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 1090054534;
                int i818 = i816 + (-1639129168) + (((~((-244917214) | i817)) | 177807681) * 345) + (((~((-244917214) | (~i817))) | 555898880) * 345) + ((~(i817 | (-177807682))) * 345);
                int i819 = (i818 << 13) ^ i818;
                int i910 = i819 ^ (i819 >>> 17);
                ((int[]) objArr414[2])[0] = i910 ^ (i910 << 5);
            }
            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1168947751);
            if (objAccessartificialFrame4 == null) {
                int i911 = 36 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                char cKeyCodeFromString2 = (char) KeyEvent.keyCodeFromString("");
                int mirror3 = AndroidCharacter.getMirror('0') + 492;
                byte b114 = $$a[5];
                byte b115 = (byte) (b114 - 1);
                Object[] objArr415 = new Object[1];
                b(b115, (byte) (b115 | 47), b114, objArr415);
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(i911, cKeyCodeFromString2, mirror3, 624296913, false, (String) objArr415[0], null);
            }
            j2 = ((Field) objAccessartificialFrame4).getLong(null);
            if (j2 != -1) {
                objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1717965552);
                if (objAccessartificialFrame5 == null) {
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(20 - KeyEvent.keyCodeFromString(""), (char) (39516 - ExpandableListView.getPackedPositionType(0L)), (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 982, 117222168, false, null, new Class[0]);
                }
                Object[] objArr416 = {null, ((Constructor) objAccessartificialFrame5).newInstance(null), 1006457261, 0};
                objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-501205803);
                if (objAccessartificialFrame6 == null) {
                    int maxKeyCode12 = 36 - (KeyEvent.getMaxKeyCode() >> 16);
                    char packedPositionGroup7 = (char) ExpandableListView.getPackedPositionGroup(0L);
                    int mirror4 = AndroidCharacter.getMirror('0') + 492;
                    byte[] bArr117 = $$a;
                    Object[] objArr417 = new Object[1];
                    b((byte) 77, (byte) (bArr117[5] - 1), bArr117[79], objArr417);
                    objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(maxKeyCode12, packedPositionGroup7, mirror4, 2101703389, false, (String) objArr417[0], new Class[]{(Class) ArtificialStackFrames.coroutineCreation((CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + 54, (char) ((android.os.SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (android.os.SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 832), 576 - TextUtils.getOffsetAfter("", 0)), (Class) ArtificialStackFrames.coroutineCreation(54 - Gravity.getAbsoluteGravity(0, 0), (char) KeyEvent.getDeadChar(0, 0), 629 - TextUtils.lastIndexOf("", '0')), Integer.TYPE, Integer.TYPE});
                }
                objArr4 = (Object[]) ((Method) objAccessartificialFrame6).invoke(null, objArr416);
                objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-1339222025);
                if (objAccessartificialFrame7 == null) {
                    int iResolveSize3 = 36 - View.resolveSize(0, 0);
                    char c9 = (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                    int modifierMetaStateMask3 = ((byte) KeyEvent.getModifierMetaStateMask()) + Ascii.GS;
                    byte[] bArr118 = $$a;
                    byte b116 = bArr118[28];
                    Object[] objArr510 = new Object[1];
                    b(b116, (byte) (b116 | 39), bArr118[5], objArr510);
                    objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(iResolveSize3, c9, modifierMetaStateMask3, 793268735, false, (String) objArr510[0], null);
                }
                ((Field) objAccessartificialFrame7).set(null, objArr4);
                Long lValueOf24 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-1168947751);
                if (objAccessartificialFrame8 == null) {
                    int packedPositionType6 = ExpandableListView.getPackedPositionType(0L) + 36;
                    char size5 = (char) View.MeasureSpec.getSize(0);
                    int iGreen2 = 540 - Color.green(0);
                    byte b117 = $$a[5];
                    byte b118 = (byte) (b117 - 1);
                    Object[] objArr511 = new Object[1];
                    b(b118, (byte) (b118 | 47), b117, objArr511);
                    objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(packedPositionType6, size5, iGreen2, 624296913, false, (String) objArr511[0], null);
                }
                ((Field) objAccessartificialFrame8).set(null, lValueOf24);
            } else {
                objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1717965552);
                if (objAccessartificialFrame5 == null) {
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(20 - KeyEvent.keyCodeFromString(""), (char) (39516 - ExpandableListView.getPackedPositionType(0L)), (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 982, 117222168, false, null, new Class[0]);
                }
                Object[] objArr418 = {null, ((Constructor) objAccessartificialFrame5).newInstance(null), 1006457261, 0};
                objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-501205803);
                if (objAccessartificialFrame6 == null) {
                    int maxKeyCode13 = 36 - (KeyEvent.getMaxKeyCode() >> 16);
                    char packedPositionGroup8 = (char) ExpandableListView.getPackedPositionGroup(0L);
                    int mirror5 = AndroidCharacter.getMirror('0') + 492;
                    byte[] bArr119 = $$a;
                    Object[] objArr419 = new Object[1];
                    b((byte) 77, (byte) (bArr119[5] - 1), bArr119[79], objArr419);
                    objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(maxKeyCode13, packedPositionGroup8, mirror5, 2101703389, false, (String) objArr419[0], new Class[]{(Class) ArtificialStackFrames.coroutineCreation((CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + 54, (char) ((android.os.SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (android.os.SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 832), 576 - TextUtils.getOffsetAfter("", 0)), (Class) ArtificialStackFrames.coroutineCreation(54 - Gravity.getAbsoluteGravity(0, 0), (char) KeyEvent.getDeadChar(0, 0), 629 - TextUtils.lastIndexOf("", '0')), Integer.TYPE, Integer.TYPE});
                }
                objArr4 = (Object[]) ((Method) objAccessartificialFrame6).invoke(null, objArr418);
                objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-1339222025);
                if (objAccessartificialFrame7 == null) {
                    int iResolveSize4 = 36 - View.resolveSize(0, 0);
                    char c10 = (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                    int modifierMetaStateMask4 = ((byte) KeyEvent.getModifierMetaStateMask()) + Ascii.GS;
                    byte[] bArr1110 = $$a;
                    byte b119 = bArr1110[28];
                    Object[] objArr512 = new Object[1];
                    b(b119, (byte) (b119 | 39), bArr1110[5], objArr512);
                    objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(iResolveSize4, c10, modifierMetaStateMask4, 793268735, false, (String) objArr512[0], null);
                }
                ((Field) objAccessartificialFrame7).set(null, objArr4);
                Long lValueOf25 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-1168947751);
                if (objAccessartificialFrame8 == null) {
                    int packedPositionType7 = ExpandableListView.getPackedPositionType(0L) + 36;
                    char size6 = (char) View.MeasureSpec.getSize(0);
                    int iGreen3 = 540 - Color.green(0);
                    byte b1110 = $$a[5];
                    byte b1111 = (byte) (b1110 - 1);
                    Object[] objArr513 = new Object[1];
                    b(b1111, (byte) (b1111 | 47), b1110, objArr513);
                    objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(packedPositionType7, size6, iGreen3, 624296913, false, (String) objArr513[0], null);
                }
                ((Field) objAccessartificialFrame8).set(null, lValueOf25);
            }
            obj = objArr4[1];
            i7 = ((int[]) obj)[0];
            obj2 = objArr4[2];
            i8 = ((int[]) obj2)[0];
            if (i8 == i7) {
                Object[] objArr514 = {new int[1], new int[1], new int[1]};
                int i912 = ((int[]) objArr4[0])[0];
                int i1010 = ((int[]) obj2)[0];
                int i1011 = ((int[]) obj)[0];
                ((int[]) objArr514[2])[0] = i1010;
                ((int[]) objArr514[1])[0] = i1011;
                int i1012 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().navigation;
                int i1013 = i912 + ((((~((-206503969) | i1012)) | 587209537) * 449) - 207533485) + (((~((~i1012) | (-206503969))) | 587209537) * 449);
                int i1014 = (i1013 << 13) ^ i1013;
                int i1015 = i1014 ^ (i1014 >>> 17);
                ((int[]) objArr514[0])[0] = i1015 ^ (i1015 << 5);
                i9 = 0;
            } else {
                Object[] objArr515 = {Long.valueOf(((long) (i7 ^ i8)) ^ (((long) (-640496706)) << 32)), Long.valueOf(-640492610)};
                byte[] bArr120 = $$d;
                byte b210 = bArr120[35];
                Object[] objArr516 = new Object[1];
                c(b210, (short) (b210 | 323), bArr120[8], objArr516);
                Class<?> cls30 = Class.forName((String) objArr516[0]);
                byte b211 = (byte) (-bArr120[81]);
                Object[] objArr517 = new Object[1];
                c(b211, (short) (b211 | 529), bArr120[232], objArr517);
                cls30.getMethod((String) objArr517[0], Long.TYPE, Long.TYPE).invoke(null, objArr515);
                Object[] objArr518 = {new int[1], new int[1], new int[1]};
                int i1016 = ((int[]) objArr4[0])[0];
                int i1017 = ((int[]) objArr4[2])[0];
                int i1018 = ((int[]) objArr4[1])[0];
                ((int[]) objArr518[2])[0] = i1017;
                ((int[]) objArr518[1])[0] = i1018;
                int i1019 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().orientation;
                int i1110 = (-717969941) + (((~((-574754213) | i1019)) | 292 | (~(776867537 | i1019))) * (-754));
                int i1111 = ~((-293) | i1019);
                int i1112 = ~i1019;
                int i1113 = i1016 + i1110 + ((i1111 | (~(776867829 | i1112))) * (-754)) + ((i1112 | (-574754213)) * 754);
                int i1114 = (i1113 << 13) ^ i1113;
                int i1115 = i1114 ^ (i1114 >>> 17);
                i9 = 0;
                ((int[]) objArr518[0])[0] = i1115 ^ (i1115 << 5);
            }
            objAccessartificialFrame9 = ArtificialStackFrames.accessartificialFrame(-444530678);
            if (objAccessartificialFrame9 == null) {
                int i1116 = (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 25;
                char offsetBefore2 = (char) TextUtils.getOffsetBefore("", i9);
                int i1117 = 1041 - (CdmaCellLocation.convertQuartSecToDecDegrees(i9) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(i9) == 0.0d ? 0 : -1));
                byte b212 = $$a[5];
                byte b213 = (byte) (b212 - 1);
                Object[] objArr519 = new Object[1];
                b(b213, (byte) (b213 | 47), b212, objArr519);
                objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(i1116, offsetBefore2, i1117, 2061780482, false, (String) objArr519[0], null);
            }
            j3 = ((Field) objAccessartificialFrame9).getLong(null);
            if (j3 != -1) {
                int iIntValue17 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
                Object[] objArr610 = {2040768510};
                objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-1648942878);
                if (objAccessartificialFrame10 == null) {
                    objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(8 - (ViewConfiguration.getScrollBarSize() >> 8), (char) ((android.os.SystemClock.elapsedRealtime() > 0L ? 1 : (android.os.SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 22250), 1033 - ((Process.getThreadPriority(0) + 20) >> 6), 47343338, false, null, new Class[]{Integer.TYPE});
                }
                objArrAccessartificialFrame$78cbbd35 = zza.accessartificialFrame$78cbbd35(iIntValue17, 0, ((Constructor) objAccessartificialFrame10).newInstance(objArr610), 119955734, false);
                objAccessartificialFrame11 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame11 == null) {
                    int i1118 = (android.os.SystemClock.uptimeMillis() > 0L ? 1 : (android.os.SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 25;
                    char maxKeyCode14 = (char) (KeyEvent.getMaxKeyCode() >> 16);
                    int iArgb20 = Color.argb(0, 0, 0, 0) + 1041;
                    byte[] bArr121 = $$a;
                    byte b214 = bArr121[28];
                    Object[] objArr611 = new Object[1];
                    b(b214, (byte) (b214 | 39), bArr121[5], objArr611);
                    objAccessartificialFrame11 = ArtificialStackFrames.coroutineCreation(i1118, maxKeyCode14, iArgb20, 1145017376, false, (String) objArr611[0], null);
                }
                ((Field) objAccessartificialFrame11).set(null, objArrAccessartificialFrame$78cbbd35);
                Long lValueOf26 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                objAccessartificialFrame12 = ArtificialStackFrames.accessartificialFrame(-444530678);
                if (objAccessartificialFrame12 == null) {
                    int iResolveSize5 = View.resolveSize(0, 0) + 26;
                    char c11 = (char) ((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) - 1);
                    int maxKeyCode15 = 1041 - (KeyEvent.getMaxKeyCode() >> 16);
                    byte b215 = $$a[5];
                    byte b216 = (byte) (b215 - 1);
                    Object[] objArr612 = new Object[1];
                    b(b216, (byte) (b216 | 47), b215, objArr612);
                    objAccessartificialFrame12 = ArtificialStackFrames.coroutineCreation(iResolveSize5, c11, maxKeyCode15, 2061780482, false, (String) objArr612[0], null);
                }
                ((Field) objAccessartificialFrame12).set(null, lValueOf26);
            } else {
                int iIntValue18 = ((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue();
                Object[] objArr613 = {2040768510};
                objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-1648942878);
                if (objAccessartificialFrame10 == null) {
                    objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(8 - (ViewConfiguration.getScrollBarSize() >> 8), (char) ((android.os.SystemClock.elapsedRealtime() > 0L ? 1 : (android.os.SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 22250), 1033 - ((Process.getThreadPriority(0) + 20) >> 6), 47343338, false, null, new Class[]{Integer.TYPE});
                }
                objArrAccessartificialFrame$78cbbd35 = zza.accessartificialFrame$78cbbd35(iIntValue18, 0, ((Constructor) objAccessartificialFrame10).newInstance(objArr613), 119955734, false);
                objAccessartificialFrame11 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame11 == null) {
                    int i1119 = (android.os.SystemClock.uptimeMillis() > 0L ? 1 : (android.os.SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 25;
                    char maxKeyCode16 = (char) (KeyEvent.getMaxKeyCode() >> 16);
                    int iArgb21 = Color.argb(0, 0, 0, 0) + 1041;
                    byte[] bArr122 = $$a;
                    byte b217 = bArr122[28];
                    Object[] objArr614 = new Object[1];
                    b(b217, (byte) (b217 | 39), bArr122[5], objArr614);
                    objAccessartificialFrame11 = ArtificialStackFrames.coroutineCreation(i1119, maxKeyCode16, iArgb21, 1145017376, false, (String) objArr614[0], null);
                }
                ((Field) objAccessartificialFrame11).set(null, objArrAccessartificialFrame$78cbbd35);
                Long lValueOf27 = Long.valueOf(((Long) Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0])).longValue());
                objAccessartificialFrame12 = ArtificialStackFrames.accessartificialFrame(-444530678);
                if (objAccessartificialFrame12 == null) {
                    int iResolveSize6 = View.resolveSize(0, 0) + 26;
                    char c12 = (char) ((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) - 1);
                    int maxKeyCode17 = 1041 - (KeyEvent.getMaxKeyCode() >> 16);
                    byte b218 = $$a[5];
                    byte b219 = (byte) (b218 - 1);
                    Object[] objArr615 = new Object[1];
                    b(b219, (byte) (b219 | 47), b218, objArr615);
                    objAccessartificialFrame12 = ArtificialStackFrames.coroutineCreation(iResolveSize6, c12, maxKeyCode17, 2061780482, false, (String) objArr615[0], null);
                }
                ((Field) objAccessartificialFrame12).set(null, lValueOf27);
            }
            i10 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
            i11 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
            if (i11 == i10) {
                int i1210 = artificialFrame + 125;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i1210 % 128;
                int i1211 = i1210 % 2;
                Object[] objArr616 = {strArr8, new int[1], new int[]{i128}, new int[]{i127}};
                int i1212 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
                int i1213 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
                int i1214 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
                String[] strArr20 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
                int iIdentityHashCode21 = System.identityHashCode(this);
                int i1215 = i1212 + (-478269278) + (((~iIdentityHashCode21) | 124274433) * 1444) + (((~(iIdentityHashCode21 | (-829870494))) | (~(907974300 | iIdentityHashCode21)) | 23085313) * (-1444)) + 468171868;
                int i1310 = (i1215 << 13) ^ i1215;
                int i1311 = i1310 ^ (i1310 >>> 17);
                ((int[]) objArr616[1])[0] = i1311 ^ (i1311 << 5);
            } else {
                arrayList = new ArrayList();
                strArr = (String[]) objArrAccessartificialFrame$78cbbd35[0];
                if (strArr != null) {
                    while (i12 < strArr.length) {
                        arrayList.add(str6);
                    }
                }
                Object[] objArr617 = {Long.valueOf(((long) (i10 ^ i11)) ^ (((long) (-1800487843)) << 32)), Long.valueOf(-1800487841)};
                byte[] bArr123 = $$d;
                Object[] objArr618 = new Object[1];
                c(bArr123[8], (short) 321, bArr123[28], objArr618);
                Class<?> cls31 = Class.forName((String) objArr618[0]);
                byte b220 = (byte) (-bArr123[81]);
                Object[] objArr619 = new Object[1];
                c(b220, (short) (b220 | 529), bArr123[232], objArr619);
                cls31.getMethod((String) objArr619[0], Long.TYPE, Long.TYPE).invoke(null, objArr617);
                Object[] objArr620 = {strArr9, new int[1], new int[]{i134}, new int[]{i133}};
                int i1312 = ((int[]) objArrAccessartificialFrame$78cbbd35[1])[0];
                int i1313 = ((int[]) objArrAccessartificialFrame$78cbbd35[3])[0];
                int i1314 = ((int[]) objArrAccessartificialFrame$78cbbd35[2])[0];
                String[] strArr21 = (String[]) objArrAccessartificialFrame$78cbbd35[0];
                int i1315 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getConfiguration().keyboard;
                int i1316 = i1312 + (-87008214) + (((~i1315) | 80200960) * 1324) + (((~(i1315 | (-943204366))) | (~(1021308172 | i1315))) * (-1324)) + 1353223380;
                int i1317 = (i1316 << 13) ^ i1316;
                int i1318 = i1317 ^ (i1317 >>> 17);
                ((int[]) objArr620[1])[0] = i1318 ^ (i1318 << 5);
            }
            objAccessartificialFrame13 = ArtificialStackFrames.accessartificialFrame(1745676544);
            if (objAccessartificialFrame13 == null) {
                int maximumDrawingCacheSize2 = 17 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                char c13 = (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) - 1);
                int i1319 = 748 - (android.os.SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (android.os.SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1));
                byte b221 = $$a[5];
                byte b321 = (byte) (b221 - 1);
                Object[] objArr720 = new Object[1];
                b(b321, (byte) (b321 | 47), b221, objArr720);
                objAccessartificialFrame13 = ArtificialStackFrames.coroutineCreation(maximumDrawingCacheSize2, c13, i1319, -144068856, false, (String) objArr720[0], null);
            }
            j4 = ((Field) objAccessartificialFrame13).getLong(null);
            baseContext2 = getBaseContext();
            if (baseContext2 == null) {
                Object[] objArr1116 = new Object[1];
                a(false, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[i13]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(i13, 4).codePointAt(1) - 27, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[i13]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(i13, 4).length() + 260, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[i13]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(i13, 4).codePointAt(i13) - 11, new char[]{'\f', 6, 1, 65483, 65534, CharUtils.CR, CharUtils.CR, 65483, 65502, 0, 17, 6, 19, 6, 17, 22, 65521, 5, 15, 2, 65534, 1, 65534, 11, 1, 15}, objArr1116);
                Class<?> cls210 = Class.forName((String) objArr1116[0]);
                Object[] objArr1117 = new Object[1];
                a(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 17, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(0) + 234, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 3, new char[]{'\b', '\b', 11, 65529, 4, 5, 65535, '\n', 65527, 65529, 65535, 2, 6, 6, 65495, '\n', 4, 65531}, objArr1117);
                baseContext2 = (Context) cls210.getMethod((String) objArr1117[0], new Class[0]).invoke(null, null);
            }
            if (baseContext2 != null) {
                if (baseContext2 instanceof ContextWrapper) {
                    baseContext2 = baseContext2.getApplicationContext();
                } else {
                    baseContext2 = baseContext2.getApplicationContext();
                }
            }
            Object[] objArr1118 = {baseContext2, Integer.valueOf(((Integer) Class.forName(str3).getMethod(str4, Object.class).invoke(null, this)).intValue()), 0, -974378094};
            byte[] bArr39 = $$d;
            Object[] objArr1119 = new Object[1];
            c(bArr39[33], (short) 267, bArr39[8], objArr1119);
            Class<?> cls211 = Class.forName((String) objArr1119[0]);
            Object[] objArr1120 = new Object[1];
            c(bArr39[242], (short) 526, (byte) (bArr39[127] - 1), objArr1120);
            objArr5 = (Object[]) cls211.getMethod((String) objArr1120[0], Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr1118);
            objAccessartificialFrame14 = ArtificialStackFrames.accessartificialFrame(1575402270);
            if (objAccessartificialFrame14 == null) {
                int modifierMetaStateMask5 = 16 - ((byte) KeyEvent.getModifierMetaStateMask());
                char packedPositionGroup9 = (char) ExpandableListView.getPackedPositionGroup(0L);
                int edgeSlop17 = 747 - (ViewConfiguration.getEdgeSlop() >> 16);
                byte[] bArr310 = $$a;
                byte b57 = bArr310[28];
                Object[] objArr1121 = new Object[1];
                b(b57, (byte) (b57 | 39), bArr310[5], objArr1121);
                objAccessartificialFrame14 = ArtificialStackFrames.coroutineCreation(modifierMetaStateMask5, packedPositionGroup9, edgeSlop17, -1031537386, false, (String) objArr1121[0], null);
            }
            ((Field) objAccessartificialFrame14).set(null, objArr5);
        } catch (Throwable th3) {
            Throwable cause3 = th3.getCause();
            if (cause3 == null) {
                throw th3;
            }
            throw cause3;
        }
        baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr125 = new Object[1];
            a(false, 22 - TextUtils.getTrimmedLength(""), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[i]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(i, 4).codePointAt(3) + 149, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[i]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(i, 4).length() + 22, new char[]{'\f', 6, 1, 65483, 65534, CharUtils.CR, CharUtils.CR, 65483, 65502, 0, 17, 6, 19, 6, 17, 22, 65521, 5, 15, 2, 65534, 1, 65534, 11, 1, 15}, objArr125);
            Class<?> cls32 = Class.forName((String) objArr125[0]);
            Object[] objArr126 = new Object[1];
            a(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(1) - 45, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 236, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(2) - 18, new char[]{'\b', '\b', 11, 65529, 4, 5, 65535, '\n', 65527, 65529, 65535, 2, 6, 6, 65495, '\n', 4, 65531}, objArr126);
            baseContext = (Context) cls32.getMethod((String) objArr126[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = ((baseContext instanceof ContextWrapper) && ((ContextWrapper) baseContext).getBaseContext() == null) ? null : baseContext.getApplicationContext();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onPause() throws Throwable {
        int i = 2 % 2;
        int i2 = artificialFrame + 45;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i2 % 128;
        int i3 = i2 % 2;
        Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(949068051);
        if (objAccessartificialFrame == null) {
            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(Color.rgb(0, 0, 0) + 16777246, (char) (49994 - (android.os.SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (android.os.SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1))), View.resolveSizeAndState(0, 0, 0) + 74, -1477122277, false, "MediaDescriptionCompatApi23Builder", null);
        }
        Object obj = ((Field) objAccessartificialFrame).get(null);
        try {
            Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1579114835);
            if (objAccessartificialFrame2 == null) {
                int iAlpha = Color.alpha(0) + 30;
                char cRgb = (char) (Color.rgb(0, 0, 0) + 16827209);
                int gidForName = Process.getGidForName("") + 75;
                byte[] bArr = $$d;
                Object[] objArr = new Object[1];
                c((byte) (-bArr[61]), bArr[28], bArr[8], objArr);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iAlpha, cRgb, gidForName, -1048959141, false, (String) objArr[0], new Class[0]);
            }
            ((Method) objAccessartificialFrame2).invoke(obj, null);
            super.onPause();
            int i4 = artificialFrame + 107;
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

    /* JADX WARN: Code duplicated, block: B:13:0x01f1  */
    /* JADX WARN: Code duplicated, block: B:16:0x0307 A[Catch: all -> 0x0c1c, TryCatch #2 {all -> 0x0c1c, blocks: (B:52:0x08a4, B:54:0x08b8, B:55:0x08e4, B:14:0x02e6, B:16:0x0307, B:17:0x035c), top: B:96:0x02e6 }] */
    /* JADX WARN: Code duplicated, block: B:20:0x036e  */
    /* JADX WARN: Code duplicated, block: B:25:0x0460  */
    /* JADX WARN: Code duplicated, block: B:51:0x07d8  */
    /* JADX WARN: Code duplicated, block: B:54:0x08b8 A[Catch: all -> 0x0c1c, TryCatch #2 {all -> 0x0c1c, blocks: (B:52:0x08a4, B:54:0x08b8, B:55:0x08e4, B:14:0x02e6, B:16:0x0307, B:17:0x035c), top: B:96:0x02e6 }] */
    /* JADX WARN: Code duplicated, block: B:58:0x08fa  */
    /* JADX WARN: Code duplicated, block: B:63:0x0a43  */
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
            int maxKeyCode = (KeyEvent.getMaxKeyCode() >> 16) + 25;
            char minimumFlingVelocity = (char) ((ViewConfiguration.getMinimumFlingVelocity() >> 16) + 30068);
            int iResolveSizeAndState = View.resolveSizeAndState(0, 0, 0) + 816;
            byte b = $$a[5];
            byte b2 = (byte) (b - 1);
            Object[] objArr3 = new Object[1];
            b(b2, (byte) (b2 | 47), b, objArr3);
            objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(maxKeyCode, minimumFlingVelocity, iResolveSizeAndState, 721586079, false, (String) objArr3[0], null);
        }
        long j = ((Field) objAccessartificialFrame7).getLong(null);
        if (j != -1) {
            long j2 = j + 2027;
            Object[] objArr4 = new Object[1];
            a(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 16, 263 - Process.getGidForName(""), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).codePointAt(1) - 27, new char[]{'\f', 15, 1, 11, 65534, '\b', 0, '\f', '\t', 65504, '\n', 2, 17, 16, 22, 65520, 65483, 16, '\f', 65483, 1, 6}, objArr4);
            Class<?> cls = Class.forName((String) objArr4[0]);
            Object[] objArr5 = new Object[1];
            a(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(0) - 23, (ViewConfiguration.getPressedStateDuration() >> 16) + 268, 15 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), new char[]{6, 2, CharUtils.CR, 5, 65530, 65534, 65515, 65533, 65534, '\f', '\t', 65530, 5, 65534, 65534}, objArr5);
            if (j2 >= ((Long) cls.getDeclaredMethod((String) objArr5[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                Object objAccessartificialFrame8 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                if (objAccessartificialFrame8 == null) {
                    int iGreen = 25 - Color.green(0);
                    char keyRepeatDelay = (char) ((ViewConfiguration.getKeyRepeatDelay() >> 16) + 30068);
                    int edgeSlop = 816 - (ViewConfiguration.getEdgeSlop() >> 16);
                    byte[] bArr = $$a;
                    byte b3 = bArr[28];
                    Object[] objArr6 = new Object[1];
                    b(b3, (byte) (b3 | 39), bArr[5], objArr6);
                    objAccessartificialFrame8 = ArtificialStackFrames.coroutineCreation(iGreen, keyRepeatDelay, edgeSlop, 891606461, false, (String) objArr6[0], null);
                }
                Object[] objArr7 = (Object[]) ((Field) objAccessartificialFrame8).get(null);
                objArr = new Object[]{new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i2 = ((int[]) objArr7[0])[0];
                int i3 = ((int[]) objArr7[1])[0];
                String[] strArr = (String[]) objArr7[2];
                int i4 = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getResources().getDisplayMetrics().widthPixels;
                int i5 = ((1952139404 + (((~((~i4) | 475054265)) | 8397122) * 529)) + (((~(i4 | 475054265)) | 276881899) * 529)) - 1555387088;
                int i6 = (i5 << 13) ^ i5;
                int i7 = i6 ^ (i6 >>> 17);
                ((int[]) objArr[3])[0] = i7 ^ (i7 << 5);
            } else {
                Object[] objArr8 = new Object[1];
                a(true, ((byte) KeyEvent.getModifierMetaStateMask()) + 17, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(0) + 226, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(12) - 83, new char[]{11, 3, 18, 17, 23, 65521, 65484, 5, '\f', 65535, '\n', 65484, 65535, 20, 65535, '\b'}, objArr8);
                Class<?> cls2 = Class.forName((String) objArr8[0]);
                Object[] objArr9 = new Object[1];
                a(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) - 35, 267 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 12, new char[]{'\t', 65501, 2, CharUtils.CR, 65531, 65506, 19, 14, 3, 14, '\b', 65535, 65534, 3, 65535, 65534}, objArr9);
                try {
                    Object[] objArr10 = {Integer.valueOf(((Integer) cls2.getMethod((String) objArr9[0], Object.class).invoke(null, this)).intValue()), 0, -1555387088};
                    objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(1327366003);
                    if (objAccessartificialFrame == null) {
                        int keyRepeatDelay2 = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 25;
                        char cMyTid = (char) (30068 - (Process.myTid() >> 22));
                        int i8 = (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 816;
                        byte b4 = (byte) ($$b & 116);
                        byte[] bArr2 = $$a;
                        Object[] objArr11 = new Object[1];
                        b(b4, bArr2[65], bArr2[117], objArr11);
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(keyRepeatDelay2, cMyTid, i8, -797394565, false, (String) objArr11[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
                    }
                    objArr = (Object[]) ((Method) objAccessartificialFrame).invoke(null, objArr10);
                    objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1438542923);
                    if (objAccessartificialFrame2 == null) {
                        int iMyPid = (Process.myPid() >> 22) + 25;
                        char c = (char) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 30067);
                        int jumpTapTimeout = 816 - (ViewConfiguration.getJumpTapTimeout() >> 16);
                        byte[] bArr3 = $$a;
                        byte b5 = bArr3[28];
                        Object[] objArr12 = new Object[1];
                        b(b5, (byte) (b5 | 39), bArr3[5], objArr12);
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iMyPid, c, jumpTapTimeout, 891606461, false, (String) objArr12[0], null);
                    }
                    ((Field) objAccessartificialFrame2).set(null, objArr);
                    try {
                        Object[] objArr13 = new Object[1];
                        a(true, Color.green(0) + 5, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 243, Color.alpha(0) + 22, new char[]{'\f', 15, 1, 11, 65534, '\b', 0, '\f', '\t', 65504, '\n', 2, 17, 16, 22, 65520, 65483, 16, '\f', 65483, 1, 6}, objArr13);
                        Class<?> cls3 = Class.forName((String) objArr13[0]);
                        Object[] objArr14 = new Object[1];
                        a(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 7, (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 268, KeyEvent.normalizeMetaState(0) + 15, new char[]{6, 2, CharUtils.CR, 5, 65530, 65534, 65515, 65533, 65534, '\f', '\t', 65530, 5, 65534, 65534}, objArr14);
                        Long lValueOf = Long.valueOf(((Long) cls3.getDeclaredMethod((String) objArr14[0], new Class[0]).invoke(null, new Object[0])).longValue());
                        objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1268268649);
                        if (objAccessartificialFrame3 == null) {
                            int windowTouchSlop = (ViewConfiguration.getWindowTouchSlop() >> 8) + 25;
                            char modifierMetaStateMask = (char) (30067 - ((byte) KeyEvent.getModifierMetaStateMask()));
                            int i9 = (android.os.SystemClock.uptimeMillis() > 0L ? 1 : (android.os.SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 815;
                            byte b6 = $$a[5];
                            byte b7 = (byte) (b6 - 1);
                            Object[] objArr15 = new Object[1];
                            b(b7, (byte) (b7 | 47), b6, objArr15);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(windowTouchSlop, modifierMetaStateMask, i9, 721586079, false, (String) objArr15[0], null);
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
            a(true, ((byte) KeyEvent.getModifierMetaStateMask()) + 17, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(0) + 226, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().codePointAt(12) - 83, new char[]{11, 3, 18, 17, 23, 65521, 65484, 5, '\f', 65535, '\n', 65484, 65535, 20, 65535, '\b'}, objArr16);
            Class<?> cls4 = Class.forName((String) objArr16[0]);
            Object[] objArr17 = new Object[1];
            a(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).codePointAt(1) - 35, 267 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 12, new char[]{'\t', 65501, 2, CharUtils.CR, 65531, 65506, 19, 14, 3, 14, '\b', 65535, 65534, 3, 65535, 65534}, objArr17);
            Object[] objArr18 = {Integer.valueOf(((Integer) cls4.getMethod((String) objArr17[0], Object.class).invoke(null, this)).intValue()), 0, -1555387088};
            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(1327366003);
            if (objAccessartificialFrame == null) {
                int keyRepeatDelay3 = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 25;
                char cMyTid2 = (char) (30068 - (Process.myTid() >> 22));
                int i10 = (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 816;
                byte b8 = (byte) ($$b & 116);
                byte[] bArr4 = $$a;
                Object[] objArr19 = new Object[1];
                b(b8, bArr4[65], bArr4[117], objArr19);
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(keyRepeatDelay3, cMyTid2, i10, -797394565, false, (String) objArr19[0], new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            }
            objArr = (Object[]) ((Method) objAccessartificialFrame).invoke(null, objArr18);
            objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1438542923);
            if (objAccessartificialFrame2 == null) {
                int iMyPid2 = (Process.myPid() >> 22) + 25;
                char c2 = (char) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 30067);
                int jumpTapTimeout2 = 816 - (ViewConfiguration.getJumpTapTimeout() >> 16);
                byte[] bArr5 = $$a;
                byte b9 = bArr5[28];
                Object[] objArr110 = new Object[1];
                b(b9, (byte) (b9 | 39), bArr5[5], objArr110);
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iMyPid2, c2, jumpTapTimeout2, 891606461, false, (String) objArr110[0], null);
            }
            ((Field) objAccessartificialFrame2).set(null, objArr);
            Object[] objArr111 = new Object[1];
            a(true, Color.green(0) + 5, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 243, Color.alpha(0) + 22, new char[]{'\f', 15, 1, 11, 65534, '\b', 0, '\f', '\t', 65504, '\n', 2, 17, 16, 22, 65520, 65483, 16, '\f', 65483, 1, 6}, objArr111);
            Class<?> cls5 = Class.forName((String) objArr111[0]);
            Object[] objArr112 = new Object[1];
            a(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 7, (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 268, KeyEvent.normalizeMetaState(0) + 15, new char[]{6, 2, CharUtils.CR, 5, 65530, 65534, 65515, 65533, 65534, '\f', '\t', 65530, 5, 65534, 65534}, objArr112);
            Long lValueOf2 = Long.valueOf(((Long) cls5.getDeclaredMethod((String) objArr112[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1268268649);
            if (objAccessartificialFrame3 == null) {
                int windowTouchSlop2 = (ViewConfiguration.getWindowTouchSlop() >> 8) + 25;
                char modifierMetaStateMask2 = (char) (30067 - ((byte) KeyEvent.getModifierMetaStateMask()));
                int i11 = (android.os.SystemClock.uptimeMillis() > 0L ? 1 : (android.os.SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 815;
                byte b10 = $$a[5];
                byte b11 = (byte) (b10 - 1);
                Object[] objArr113 = new Object[1];
                b(b11, (byte) (b11 | 47), b10, objArr113);
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(windowTouchSlop2, modifierMetaStateMask2, i11, 721586079, false, (String) objArr113[0], null);
            }
            ((Field) objAccessartificialFrame3).set(null, lValueOf2);
        }
        int i12 = ((int[]) objArr[1])[0];
        int i13 = ((int[]) objArr[0])[0];
        if (i13 == i12) {
            Object[] objArr20 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
            int i14 = ((int[]) objArr[3])[0];
            int i15 = ((int[]) objArr[0])[0];
            int i16 = ((int[]) objArr[1])[0];
            String[] strArr2 = (String[]) objArr[2];
            int iIdentityHashCode = System.identityHashCode(this);
            int i17 = i14 + 1264953413 + (((~(187719435 | iIdentityHashCode)) | 335552720) * 336) + (((~(iIdentityHashCode | 385891801)) | 137380354) * (-168)) + (((~((~iIdentityHashCode) | 385891801)) | 187719435) * 168);
            int i18 = (i17 << 13) ^ i17;
            int i19 = i18 ^ (i18 >>> 17);
            ((int[]) objArr20[3])[0] = i19 ^ (i19 << 5);
        } else {
            ArrayList arrayList = new ArrayList();
            String[] strArr3 = (String[]) objArr[2];
            if (strArr3 != null) {
                for (String str : strArr3) {
                    arrayList.add(str);
                }
            }
            try {
                Object[] objArr21 = {Long.valueOf(((long) (i12 ^ i13)) ^ (((long) (-1728515261)) << 32)), Long.valueOf(-1728515262)};
                byte[] bArr6 = $$d;
                Object[] objArr22 = new Object[1];
                c(bArr6[5], bArr6[28], bArr6[8], objArr22);
                Class<?> cls6 = Class.forName((String) objArr22[0]);
                byte b12 = (byte) (-bArr6[81]);
                Object[] objArr23 = new Object[1];
                c(b12, (short) (b12 | 529), bArr6[232], objArr23);
                cls6.getMethod((String) objArr23[0], Long.TYPE, Long.TYPE).invoke(null, objArr21);
                Object[] objArr24 = {new int[]{i}, new int[]{i}, strArr, new int[1]};
                int i20 = ((int[]) objArr[3])[0];
                int i21 = ((int[]) objArr[0])[0];
                int i22 = ((int[]) objArr[1])[0];
                String[] strArr4 = (String[]) objArr[2];
                int iIdentityHashCode2 = System.identityHashCode(this);
                int i23 = i20 + (((~((-15915236) | iIdentityHashCode2)) | 170908937) * 262) + 1559660821 + (((~((~iIdentityHashCode2) | (-15915236))) | 170908937) * 262);
                int i24 = (i23 << 13) ^ i23;
                int i25 = i24 ^ (i24 >>> 17);
                ((int[]) objArr24[3])[0] = i25 ^ (i25 << 5);
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
            int keyRepeatTimeout = 26 - (ViewConfiguration.getKeyRepeatTimeout() >> 16);
            char cIndexOf = (char) TextUtils.indexOf("", "", 0, 0);
            int modifierMetaStateMask3 = ((byte) KeyEvent.getModifierMetaStateMask()) + Ascii.DC2;
            byte b13 = $$a[5];
            byte b14 = (byte) (b13 - 1);
            Object[] objArr25 = new Object[1];
            b(b14, (byte) (b14 | 47), b13, objArr25);
            objAccessartificialFrame9 = ArtificialStackFrames.coroutineCreation(keyRepeatTimeout, cIndexOf, modifierMetaStateMask3, 2061780482, false, (String) objArr25[0], null);
        }
        long j3 = ((Field) objAccessartificialFrame9).getLong(null);
        if (j3 != -1) {
            int i26 = getARTIFICIAL_FRAME_PACKAGE_NAME + 55;
            artificialFrame = i26 % 128;
            int i27 = i26 % 2;
            long j4 = j3 + 4611686018427387811L;
            Object[] objArr26 = new Object[1];
            a(true, Drawable.resolveOpacity(0, 0) + 5, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion + 229, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 1, new char[]{'\f', 15, 1, 11, 65534, '\b', 0, '\f', '\t', 65504, '\n', 2, 17, 16, 22, 65520, 65483, 16, '\f', 65483, 1, 6}, objArr26);
            Class<?> cls7 = Class.forName((String) objArr26[0]);
            Object[] objArr27 = new Object[1];
            a(true, (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 15, (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 268, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getApplicationInfo().targetSdkVersion - 20, new char[]{6, 2, CharUtils.CR, 5, 65530, 65534, 65515, 65533, 65534, '\f', '\t', 65530, 5, 65534, 65534}, objArr27);
            if (j4 >= ((Long) cls7.getDeclaredMethod((String) objArr27[0], new Class[0]).invoke(null, new Object[0])).longValue()) {
                int i28 = getARTIFICIAL_FRAME_PACKAGE_NAME + 75;
                artificialFrame = i28 % 128;
                int i29 = i28 % 2;
                Object objAccessartificialFrame10 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame10 == null) {
                    int gidForName = 25 - Process.getGidForName("");
                    char packedPositionType = (char) ExpandableListView.getPackedPositionType(0L);
                    int iAlpha = 1041 - Color.alpha(0);
                    byte[] bArr7 = $$a;
                    byte b15 = bArr7[28];
                    Object[] objArr28 = new Object[1];
                    b(b15, (byte) (b15 | 39), bArr7[5], objArr28);
                    objAccessartificialFrame10 = ArtificialStackFrames.coroutineCreation(gidForName, packedPositionType, iAlpha, 1145017376, false, (String) objArr28[0], null);
                }
                Object[] objArr29 = (Object[]) ((Field) objAccessartificialFrame10).get(null);
                objArr2 = new Object[]{strArr, new int[1], new int[]{i}, new int[]{i}};
                int i30 = ((int[]) objArr29[3])[0];
                int i31 = ((int[]) objArr29[2])[0];
                String[] strArr5 = (String[]) objArr29[0];
                int iMaxMemory = (int) Runtime.getRuntime().maxMemory();
                int i32 = ((((-1687031426) + (((~(728442400 | iMaxMemory)) | 191431712) * (-502))) + ((~((~iMaxMemory) | 997977919)) * (-502))) + (((~(iMaxMemory | (-806546208))) | 728442400) * TypedValues.PositionType.TYPE_DRAWPATH)) - 867685819;
                int i33 = (i32 << 13) ^ i32;
                int i34 = i33 ^ (i33 >>> 17);
                ((int[]) objArr2[1])[0] = i34 ^ (i34 << 5);
                int i35 = artificialFrame + 119;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i35 % 128;
                int i36 = i35 % 2;
            } else {
                Object[] objArr30 = new Object[1];
                a(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 12, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 242, (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 15, new char[]{11, 3, 18, 17, 23, 65521, 65484, 5, '\f', 65535, '\n', 65484, 65535, 20, 65535, '\b'}, objArr30);
                Class<?> cls8 = Class.forName((String) objArr30[0]);
                Object[] objArr31 = new Object[1];
                a(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 7, 267 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), 16 - (KeyEvent.getMaxKeyCode() >> 16), new char[]{'\t', 65501, 2, CharUtils.CR, 65531, 65506, 19, 14, 3, 14, '\b', 65535, 65534, 3, 65535, 65534}, objArr31);
                int iIntValue = ((Integer) cls8.getMethod((String) objArr31[0], Object.class).invoke(null, this)).intValue();
                Object[] objArr32 = {481033525};
                objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1648942878);
                if (objAccessartificialFrame4 == null) {
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(8 - TextUtils.getOffsetBefore("", 0), (char) (22251 - Color.blue(0)), 1033 - Color.alpha(0), 47343338, false, null, new Class[]{Integer.TYPE});
                }
                Object[] objArrAccessartificialFrame$78cbbd35 = CompactHashMap.Itr.accessartificialFrame$78cbbd35(iIntValue, 0, ((Constructor) objAccessartificialFrame4).newInstance(objArr32), -867685819, false);
                objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-614804952);
                if (objAccessartificialFrame5 == null) {
                    int offsetBefore = TextUtils.getOffsetBefore("", 0) + 26;
                    char cResolveSize = (char) View.resolveSize(0, 0);
                    int iAxisFromString = 1040 - MotionEvent.axisFromString("");
                    byte[] bArr8 = $$a;
                    byte b16 = bArr8[28];
                    Object[] objArr33 = new Object[1];
                    b(b16, (byte) (b16 | 39), bArr8[5], objArr33);
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(offsetBefore, cResolveSize, iAxisFromString, 1145017376, false, (String) objArr33[0], null);
                }
                ((Field) objAccessartificialFrame5).set(null, objArrAccessartificialFrame$78cbbd35);
                try {
                    Object[] objArr34 = new Object[1];
                    a(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 16, 264 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 18, new char[]{'\f', 15, 1, 11, 65534, '\b', 0, '\f', '\t', 65504, '\n', 2, 17, 16, 22, 65520, 65483, 16, '\f', 65483, 1, 6}, objArr34);
                    Class<?> cls9 = Class.forName((String) objArr34[0]);
                    Object[] objArr35 = new Object[1];
                    a(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 10, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 264, ExpandableListView.getPackedPositionGroup(0L) + 15, new char[]{6, 2, CharUtils.CR, 5, 65530, 65534, 65515, 65533, 65534, '\f', '\t', 65530, 5, 65534, 65534}, objArr35);
                    Long lValueOf3 = Long.valueOf(((Long) cls9.getDeclaredMethod((String) objArr35[0], new Class[0]).invoke(null, new Object[0])).longValue());
                    objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-444530678);
                    if (objAccessartificialFrame6 == null) {
                        int iLastIndexOf = TextUtils.lastIndexOf("", '0', 0, 0) + 27;
                        char minimumFlingVelocity2 = (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16);
                        int maximumDrawingCacheSize = 1041 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                        byte b17 = $$a[5];
                        byte b18 = (byte) (b17 - 1);
                        Object[] objArr36 = new Object[1];
                        b(b18, (byte) (b18 | 47), b17, objArr36);
                        objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(iLastIndexOf, minimumFlingVelocity2, maximumDrawingCacheSize, 2061780482, false, (String) objArr36[0], null);
                    }
                    ((Field) objAccessartificialFrame6).set(null, lValueOf3);
                    objArr2 = objArrAccessartificialFrame$78cbbd35;
                } catch (Exception unused2) {
                    throw new RuntimeException();
                }
            }
        } else {
            Object[] objArr37 = new Object[1];
            a(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 12, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() + 242, (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 15, new char[]{11, 3, 18, 17, 23, 65521, 65484, 5, '\f', 65535, '\n', 65484, 65535, 20, 65535, '\b'}, objArr37);
            Class<?> cls10 = Class.forName((String) objArr37[0]);
            Object[] objArr38 = new Object[1];
            a(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 7, 267 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), 16 - (KeyEvent.getMaxKeyCode() >> 16), new char[]{'\t', 65501, 2, CharUtils.CR, 65531, 65506, 19, 14, 3, 14, '\b', 65535, 65534, 3, 65535, 65534}, objArr38);
            int iIntValue2 = ((Integer) cls10.getMethod((String) objArr38[0], Object.class).invoke(null, this)).intValue();
            Object[] objArr39 = {481033525};
            objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1648942878);
            if (objAccessartificialFrame4 == null) {
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(8 - TextUtils.getOffsetBefore("", 0), (char) (22251 - Color.blue(0)), 1033 - Color.alpha(0), 47343338, false, null, new Class[]{Integer.TYPE});
            }
            Object[] objArrAccessartificialFrame$78cbbd36 = CompactHashMap.Itr.accessartificialFrame$78cbbd35(iIntValue2, 0, ((Constructor) objAccessartificialFrame4).newInstance(objArr39), -867685819, false);
            objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-614804952);
            if (objAccessartificialFrame5 == null) {
                int offsetBefore2 = TextUtils.getOffsetBefore("", 0) + 26;
                char cResolveSize2 = (char) View.resolveSize(0, 0);
                int iAxisFromString2 = 1040 - MotionEvent.axisFromString("");
                byte[] bArr9 = $$a;
                byte b19 = bArr9[28];
                Object[] objArr310 = new Object[1];
                b(b19, (byte) (b19 | 39), bArr9[5], objArr310);
                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(offsetBefore2, cResolveSize2, iAxisFromString2, 1145017376, false, (String) objArr310[0], null);
            }
            ((Field) objAccessartificialFrame5).set(null, objArrAccessartificialFrame$78cbbd36);
            Object[] objArr311 = new Object[1];
            a(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 16, 264 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 18, new char[]{'\f', 15, 1, 11, 65534, '\b', 0, '\f', '\t', 65504, '\n', 2, 17, 16, 22, 65520, 65483, 16, '\f', 65483, 1, 6}, objArr311);
            Class<?> cls11 = Class.forName((String) objArr311[0]);
            Object[] objArr312 = new Object[1];
            a(true, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_day_of_week_column_header).substring(0, 4).length() + 10, ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getResources().getString(net.pluservice.unicoc.R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 264, ExpandableListView.getPackedPositionGroup(0L) + 15, new char[]{6, 2, CharUtils.CR, 5, 65530, 65534, 65515, 65533, 65534, '\f', '\t', 65530, 5, 65534, 65534}, objArr312);
            Long lValueOf4 = Long.valueOf(((Long) cls11.getDeclaredMethod((String) objArr312[0], new Class[0]).invoke(null, new Object[0])).longValue());
            objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-444530678);
            if (objAccessartificialFrame6 == null) {
                int iLastIndexOf2 = TextUtils.lastIndexOf("", '0', 0, 0) + 27;
                char minimumFlingVelocity3 = (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16);
                int maximumDrawingCacheSize2 = 1041 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                byte b110 = $$a[5];
                byte b111 = (byte) (b110 - 1);
                Object[] objArr313 = new Object[1];
                b(b111, (byte) (b111 | 47), b110, objArr313);
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(iLastIndexOf2, minimumFlingVelocity3, maximumDrawingCacheSize2, 2061780482, false, (String) objArr313[0], null);
            }
            ((Field) objAccessartificialFrame6).set(null, lValueOf4);
            objArr2 = objArrAccessartificialFrame$78cbbd36;
        }
        int i37 = ((int[]) objArr2[2])[0];
        int i38 = ((int[]) objArr2[3])[0];
        if (i38 == i37) {
            Object[] objArr40 = {strArr, new int[1], new int[]{i}, new int[]{i}};
            int i39 = ((int[]) objArr2[1])[0];
            int i40 = ((int[]) objArr2[3])[0];
            int i41 = ((int[]) objArr2[2])[0];
            String[] strArr6 = (String[]) objArr2[0];
            int length = ((Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext().getPackageName().length() - 1985524819;
            int i42 = ~((-397464245) | length);
            int i43 = ~length;
            int i44 = i39 + (-452445362) + ((i42 | (~((-319360438) | i43))) * (-1808)) + (((~((-78696961) | length)) | (~(i43 | (-593154)))) * TypedValues.Custom.TYPE_BOOLEAN) + (((~(length | 319360437)) | 318767284 | (~(397464244 | i43))) * TypedValues.Custom.TYPE_BOOLEAN);
            int i45 = (i44 << 13) ^ i44;
            int i46 = i45 ^ (i45 >>> 17);
            ((int[]) objArr40[1])[0] = i46 ^ (i46 << 5);
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        String[] strArr7 = (String[]) objArr2[0];
        if (strArr7 != null) {
            for (String str2 : strArr7) {
                arrayList2.add(str2);
            }
        }
        Object[] objArr41 = {Long.valueOf(((long) (i37 ^ i38)) ^ (((long) 609648209) << 32)), Long.valueOf(609648211)};
        byte[] bArr10 = $$d;
        Object[] objArr42 = new Object[1];
        c(bArr10[8], (short) 321, bArr10[28], objArr42);
        Class<?> cls12 = Class.forName((String) objArr42[0]);
        byte b20 = (byte) (-bArr10[81]);
        Object[] objArr43 = new Object[1];
        c(b20, (short) (b20 | 529), bArr10[232], objArr43);
        cls12.getMethod((String) objArr43[0], Long.TYPE, Long.TYPE).invoke(null, objArr41);
        Object[] objArr44 = {strArr, new int[1], new int[]{i}, new int[]{i}};
        int i47 = ((int[]) objArr2[1])[0];
        int i48 = ((int[]) objArr2[3])[0];
        int i49 = ((int[]) objArr2[2])[0];
        String[] strArr8 = (String[]) objArr2[0];
        int iMaxMemory2 = (int) Runtime.getRuntime().maxMemory();
        int i50 = i47 + ((~((-973541961) | iMaxMemory2)) * 521) + 644625936 + (((~((~iMaxMemory2) | (-973541961))) | (-1065310026)) * 521);
        int i51 = (i50 << 13) ^ i50;
        int i52 = i51 ^ (i51 >>> 17);
        ((int[]) objArr44[1])[0] = i52 ^ (i52 << 5);
    }

    static {
        byte[] bArr = new byte[699];
        System.arraycopy("c\u0092ÿ8\u0010\u0002Å=\f\u0004ü\týÍ9\u0013\u000bû\bÿÃJù\t\u0001Ç7\b\u0000\u0007Î\u0017(\u0012Ö \u001b×\u001e\u0018¯\u0011\u0004A\u0010\u0002Å<ÿ\u0006\u0006\u0001\u0011\u0004\u0000ÇH÷\u0000\u0006\u0015¾C\u0006ù\u0015ûý\u0012¿?Ì\u000b:\u0003ø\u0011÷\n\u0002\u0011À\u001fì\u000b:ã\u0018\u0011÷\n\u0002\u0011ß&ù\u0015ûýÃ#0\u0002\u0007õ\u0011ÿ\n\u00030\u0007\u0001\n\u0003ù\tûã%\u0001\u0017ö\u0004\u0006\týè-\u0010\u0002Å=\f\u0004ü\týÍ7\u0013ýÉ'(þ\tñó&\u0001\tÿ\u0010\u0002ÅH÷\u0000\u0006\u0015þ÷\u0017ù\u0011óÍ?\u0011þ\t\u0002úþÏ?\bø\n\u0002\u000fýþ\fþ\u0011À\u00190\u0002\u0007\u0006÷\u0012\u0004ú\n\u0003\u0010\u0007\u0001\n\u0003ù\tûâ3÷\u0000\u0017ù\n\u0003\u0010\u0002Å<ÿ\u0006\u0006\u0001\u0011\u0004\u0000ÇH÷\u0000\u0006\u0015¾Kø\bø\u0011÷\n\u0002\u0011À/\u001aüþñ%ù\u0005ï#\u0004\u0001¼\u0004%7\u0000õ\u0011\u0000÷\u000fë*ù\nø\u0001\u0013ùþí\u0019\u0010ù\u0006\u0001Ó\u0010\u0002Å<ÿ\u0006\u0006\u0001\u0011\u0004\u0000Ç7\u0013\u0004\u0000\u0001\t\u0001\f¿\u00173\u0004à!\t\u0001Ý!\u0017ñÇ\u0011\u0000\u0001\u0010\u0004\u0000Çÿ?\t\nõ\u0011\u0000÷\u000fÆF\u0000ù\u0017ö\r\u0007ÿÅ7\u0011ú\u0012\u0001þÿÎ\u001a%\u0005\u0003\u0011\u0004÷\u0003ó ø\fþ\u0013Ñ'\u0001\u0013\bõ\u0011\u0010\u0002Å=\f\u0004ü\týÍ9\u0013\u000bû\bÿÃJù\t\u0001Ç?\t\nõ\u0011\u0000÷\u000fÆ&&÷\u0005\u0007\u0013Ù\u0018\u0013¸\"7ø\u0007ü\u0005\u0011\u0010\u0002Å=\f\u0004ü\týÍ7\u0011ú\u0012\u0001þÿÎ=\n\n¿?\t\nõ\u0011\u0000÷\u000fÆC\u0003\u0003\u0002\u000fï\u001b÷\u000eú\n\u0003õ\u0007\u0003\u0015õ\u0010ù\u0005þ\u0007\u0017ýú\fý\u0003ÎP\u0004ï\u0010\u0002ÅIò\u000fý\u0012÷\r\u0007õ\u0006ÍCø\u0015ýþ\u0013ù\tý\u0000\r\u0007\nóÎCü\u0012\u0004ò\n\u0002\u0012¿?\tø\u0011\rº9ÅL¼A\u0006\u0004\u0006\u0012\u0004ò\u0015\u0006ù\u0001\u0007þ\nü\u000fÞ0ó\u0010ü\u0010\u0002Å8\u0007\u0000ÑNù\u0003ÆI\u0005\u0002÷\u0000\u0010Å;\u0015ó\r\n\u0003¿\u001b-\nù\u000f\tÝ\u0017\u0005\u0003\u0011÷\rù\u0006ä5ó\r\n\u0010\u0002Å>\u0005\u000fñ\u0006\t\u0005ü\u0013\u0004Â;\u0017ï\u0006\u000f\bù\n\u0003\t¿#0Î*þ\u0006\u0011\u0001Ú7ï\u0006\u000f\bù\n\u0003\u0010\u0002Å<ÿ\u0006\u0006\u0001\u0011\u0004\u0000Ç?\bø\n\u0002\u000fý\u000bù\u000b\u0001\tûÍ9\u0010\u0007÷Í&&\u0001ù\u0015ò\u0006\u0011å\u0016\u0010\bô\rù\u0006å\u001f\u0006\u0015ÿ\u0007\u000b¯#0\u0002\u0007õ\u0011ÿ\n\u0003".getBytes(CharEncoding.ISO_8859_1), 0, bArr, 0, 699);
        $$d = bArr;
        $$e = 141;
        $$a = new byte[]{75, 100, -62, Ascii.SYN, -5, 1, 33, -33, 2, 9, -5, 7, -5, 1, 50, -39, -11, 7, Ascii.FF, -15, -27, -1, 7, 6, 33, -51, Ascii.FF, -3, 8, -1, -13, 9, -18, 34, -25, -4, 17, -19, Ascii.SI, 1, Ascii.DC2, -15, -19, Ascii.VT, -5, 7, 2, -15, 36, -21, -13, Ascii.SI, -2, -9, -6, 34, -15, -19, Ascii.VT, -5, 7, 2, -15, 33, -33, 19, -17, 32, -15, -19, Ascii.VT, -5, 7, -10, Ascii.US, -20, -13, 8, Ascii.VT, Ascii.CR, -27, -49, -2, Ascii.VT, 3, -3, 6, -6, 8, -11, Ascii.EM, -33, 19, -2, -8, 37, -44, 17, -12, 8, -14, 9, -18, 36, -33, 19, -17, 32, -15, -19, Ascii.VT, -5, 7, 7, -18, 43, -29, 4, -17, -2};
        $$b = 153;
        getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
        artificialFrame = 1;
        setDefaultImpl = -260894128;
    }
}
