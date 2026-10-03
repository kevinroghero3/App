package com.rnappauth;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Process;
import android.os.SystemClock;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.annotation.Nullable;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import androidx.browser.customtabs.CustomTabsSession;
import androidx.browser.customtabs.TrustedWebUtils;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.WritableMap;
import com.google.common.base.Ascii;
import com.rnappauth.utils.CustomConnectionBuilder;
import com.rnappauth.utils.EndSessionResponseFactory;
import com.rnappauth.utils.MapUtil;
import com.rnappauth.utils.MutableBrowserAllowList;
import com.rnappauth.utils.RegistrationResponseFactory;
import com.rnappauth.utils.TokenResponseFactory;
import com.rnappauth.utils.UnsafeConnectionBuilder;
import com.salesforce.marketingcloud.analytics.stats.b;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import kotlin.io.encoding.Base64;
import net.openid.appauth.AppAuthConfiguration;
import net.openid.appauth.AuthorizationException;
import net.openid.appauth.AuthorizationRequest;
import net.openid.appauth.AuthorizationResponse;
import net.openid.appauth.AuthorizationService;
import net.openid.appauth.AuthorizationServiceConfiguration;
import net.openid.appauth.ClientAuthentication;
import net.openid.appauth.ClientSecretBasic;
import net.openid.appauth.ClientSecretPost;
import net.openid.appauth.CodeVerifierUtil;
import net.openid.appauth.EndSessionRequest;
import net.openid.appauth.EndSessionResponse;
import net.openid.appauth.RegistrationRequest;
import net.openid.appauth.RegistrationResponse;
import net.openid.appauth.ResponseTypeValues;
import net.openid.appauth.TokenRequest;
import net.openid.appauth.TokenResponse;
import net.openid.appauth.browser.AnyBrowserMatcher;
import net.openid.appauth.browser.BrowserMatcher;
import net.openid.appauth.browser.VersionedBrowserMatcher;
import net.openid.appauth.connectivity.ConnectionBuilder;
import net.openid.appauth.connectivity.DefaultConnectionBuilder;
import o.ArtificialStackFrames;
import o._CREATION;
import org.apache.commons.lang3.CharEncoding;

/* JADX INFO: loaded from: classes3.dex */
public class RNAppAuthModule extends ReactContextBaseJavaModule implements ActivityEventListener {
    public static final String CUSTOM_TAB_PACKAGE_NAME = "com.android.chrome";
    private Map<String, String> additionalParametersMap;
    private Map<String, String> authorizationRequestHeaders;
    private String clientAuthMethod;
    private String clientSecret;
    private String codeVerifier;
    private boolean dangerouslyAllowInsecureHttpRequests;
    private boolean isPrefetched;
    private final ConcurrentHashMap<String, AuthorizationServiceConfiguration> mServiceConfigurations;
    private Promise promise;
    private final ReactApplicationContext reactContext;
    private Map<String, String> registrationRequestHeaders;
    private Boolean skipCodeExchange;
    private Map<String, String> tokenRequestHeaders;
    private Boolean useNonce;
    private Boolean usePKCE;

    @Override // com.facebook.react.bridge.ActivityEventListener
    public void onNewIntent(Intent intent) {
    }

    public RNAppAuthModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.clientAuthMethod = "basic";
        this.registrationRequestHeaders = null;
        this.authorizationRequestHeaders = null;
        this.tokenRequestHeaders = null;
        this.mServiceConfigurations = new ConcurrentHashMap<>();
        this.isPrefetched = false;
        this.reactContext = reactApplicationContext;
        reactApplicationContext.addActivityEventListener(this);
    }

    @ReactMethod
    public void prefetchConfiguration(Boolean bool, final String str, String str2, String str3, ReadableArray readableArray, ReadableMap readableMap, boolean z, ReadableMap readableMap2, Double d, final Promise promise) {
        if (bool.booleanValue()) {
            warmChromeCustomTab(this.reactContext, str);
        }
        parseHeaderMap(readableMap2);
        ConnectionBuilder connectionBuilderCreateConnectionBuilder = createConnectionBuilder(z, this.authorizationRequestHeaders, d);
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        if (!this.isPrefetched) {
            if (readableMap != null && !hasServiceConfiguration(str)) {
                try {
                    setServiceConfiguration(str, createAuthorizationServiceConfiguration(readableMap));
                    this.isPrefetched = true;
                    countDownLatch.countDown();
                } catch (Exception e) {
                    promise.reject("configuration_error", "Failed to convert serviceConfiguration", e);
                }
            } else if (!hasServiceConfiguration(str)) {
                AuthorizationServiceConfiguration.fetchFromUrl(buildConfigurationUriFromIssuer(Uri.parse(str)), new AuthorizationServiceConfiguration.RetrieveConfigurationCallback() { // from class: com.rnappauth.RNAppAuthModule.1
                    @Override // net.openid.appauth.AuthorizationServiceConfiguration.RetrieveConfigurationCallback
                    public void onFetchConfigurationCompleted(@Nullable AuthorizationServiceConfiguration authorizationServiceConfiguration, @Nullable AuthorizationException authorizationException) {
                        if (authorizationException != null) {
                            promise.reject("service_configuration_fetch_error", "Failed to fetch configuration", authorizationException);
                            return;
                        }
                        RNAppAuthModule.this.setServiceConfiguration(str, authorizationServiceConfiguration);
                        RNAppAuthModule.this.isPrefetched = true;
                        countDownLatch.countDown();
                    }
                }, connectionBuilderCreateConnectionBuilder);
            }
        } else {
            countDownLatch.countDown();
        }
        try {
            countDownLatch.await();
            promise.resolve(Boolean.valueOf(this.isPrefetched));
        } catch (Exception e2) {
            promise.reject("service_configuration_fetch_error", "Failed to await fetch configuration", e2);
        }
    }

    @ReactMethod
    public void register(final String str, final ReadableArray readableArray, final ReadableArray readableArray2, final ReadableArray readableArray3, final String str2, final String str3, ReadableMap readableMap, ReadableMap readableMap2, Double d, boolean z, ReadableMap readableMap3, final Promise promise) {
        AuthorizationServiceConfiguration authorizationServiceConfigurationCreateAuthorizationServiceConfiguration;
        parseHeaderMap(readableMap3);
        ConnectionBuilder connectionBuilderCreateConnectionBuilder = createConnectionBuilder(z, this.registrationRequestHeaders, d);
        final AppAuthConfiguration appAuthConfigurationCreateAppAuthConfiguration = createAppAuthConfiguration(connectionBuilderCreateConnectionBuilder, Boolean.valueOf(z), null);
        final HashMap<String, String> map = MapUtil.readableMapToHashMap(readableMap);
        if (readableMap2 != null || hasServiceConfiguration(str)) {
            try {
                if (hasServiceConfiguration(str)) {
                    authorizationServiceConfigurationCreateAuthorizationServiceConfiguration = getServiceConfiguration(str);
                } else {
                    authorizationServiceConfigurationCreateAuthorizationServiceConfiguration = createAuthorizationServiceConfiguration(readableMap2);
                }
                registerWithConfiguration(authorizationServiceConfigurationCreateAuthorizationServiceConfiguration, appAuthConfigurationCreateAppAuthConfiguration, readableArray, readableArray2, readableArray3, str2, str3, map, promise);
                return;
            } catch (Exception e) {
                promise.reject("registration_failed", e.getMessage());
                return;
            }
        }
        AuthorizationServiceConfiguration.fetchFromUrl(buildConfigurationUriFromIssuer(Uri.parse(str)), new AuthorizationServiceConfiguration.RetrieveConfigurationCallback() { // from class: com.rnappauth.RNAppAuthModule.2
            private static long _BOUNDARY;
            private static char[] _CREATION;
            private static final byte[] $$c = {Ascii.FF, 109, 62, -103};
            private static final int $$d = 143;
            private static int $10 = 0;
            private static int $11 = 1;
            private static final byte[] $$a = {71, Base64.padSymbol, 39, Base64.padSymbol, -53, -3, 46, 10, Ascii.DLE, -6, -13, 10, -9, -9, Ascii.DC2, -20, -1, Ascii.DLE, Ascii.NAK, 0, -4, 52, -14, -2};
            private static final int $$b = 201;
            private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
            private static int artificialFrame = 1;

            private static String $$e(short s, byte b, short s2) {
                int i = s2 * 4;
                byte[] bArr = $$c;
                int i2 = s + b.i;
                int i3 = 4 - (b * 3);
                byte[] bArr2 = new byte[1 - i];
                int i4 = 0 - i;
                int i5 = -1;
                if (bArr == null) {
                    i2 = i4 + i3;
                    i3++;
                    i5 = -1;
                }
                while (true) {
                    int i6 = i5 + 1;
                    bArr2[i6] = (byte) i2;
                    if (i6 == i4) {
                        return new String(bArr2, 0);
                    }
                    int i7 = i3;
                    i2 += bArr[i3];
                    i3 = i7 + 1;
                    i5 = i6;
                }
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
            private static void b(byte r6, int r7, int r8, java.lang.Object[] r9) {
                /*
                    int r8 = 115 - r8
                    int r0 = 4 - r6
                    byte[] r1 = com.rnappauth.RNAppAuthModule.AnonymousClass2.$$a
                    int r7 = 21 - r7
                    byte[] r0 = new byte[r0]
                    int r6 = 3 - r6
                    r2 = 0
                    if (r1 != 0) goto L13
                    r3 = r8
                    r4 = r2
                    r8 = r7
                    goto L2a
                L13:
                    r3 = r2
                L14:
                    byte r4 = (byte) r8
                    r0[r3] = r4
                    if (r3 != r6) goto L21
                    java.lang.String r6 = new java.lang.String
                    r6.<init>(r0, r2)
                    r9[r2] = r6
                    return
                L21:
                    int r3 = r3 + 1
                    r4 = r1[r7]
                    r5 = r8
                    r8 = r7
                    r7 = r4
                    r4 = r3
                    r3 = r5
                L2a:
                    int r3 = r3 + r7
                    int r7 = r3 + (-1)
                    int r8 = r8 + 1
                    r3 = r4
                    r5 = r8
                    r8 = r7
                    r7 = r5
                    goto L14
                */
                throw new UnsupportedOperationException("Method not decompiled: com.rnappauth.RNAppAuthModule.AnonymousClass2.b(byte, int, int, java.lang.Object[]):void");
            }

            private static void a(char c, int i, int i2, Object[] objArr) throws Throwable {
                Object obj;
                int i3 = 2 % 2;
                _CREATION _creation = new _CREATION();
                long[] jArr = new long[i2];
                _creation.b = 0;
                while (_creation.b < i2) {
                    int i4 = _creation.b;
                    try {
                        Object[] objArr2 = {Integer.valueOf(_CREATION[i + i4])};
                        Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-587087340);
                        if (objAccessartificialFrame == null) {
                            int jumpTapTimeout = 8 - (ViewConfiguration.getJumpTapTimeout() >> 16);
                            char packedPositionGroup = (char) (9279 - ExpandableListView.getPackedPositionGroup(0L));
                            int i5 = (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 1977;
                            byte b = (byte) ($$d & 1);
                            byte b2 = (byte) (b - 1);
                            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(jumpTapTimeout, packedPositionGroup, i5, 1113883676, false, $$e(b, b2, b2), new Class[]{Integer.TYPE});
                        }
                        Object[] objArr3 = {Long.valueOf(((Long) ((Method) objAccessartificialFrame).invoke(null, objArr2)).longValue()), Long.valueOf(i4), Long.valueOf(_BOUNDARY), Integer.valueOf(c)};
                        Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1715896821);
                        if (objAccessartificialFrame2 == null) {
                            int iMyTid = 30 - (Process.myTid() >> 22);
                            char jumpTapTimeout2 = (char) ((ViewConfiguration.getJumpTapTimeout() >> 16) + 49362);
                            int i6 = (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 683;
                            byte b3 = (byte) ($$d & 3);
                            byte b4 = (byte) (b3 - 3);
                            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iMyTid, jumpTapTimeout2, i6, -115095555, false, $$e(b3, b4, b4), new Class[]{Long.TYPE, Long.TYPE, Long.TYPE, Integer.TYPE});
                        }
                        jArr[i4] = ((Long) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).longValue();
                        Object[] objArr4 = {_creation, _creation};
                        Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-293902099);
                        if (objAccessartificialFrame3 == null) {
                            byte b5 = (byte) 0;
                            byte b6 = b5;
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(25 - (ViewConfiguration.getLongPressTimeout() >> 16), (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 30069), (ViewConfiguration.getFadingEdgeLength() >> 16) + 816, 1897803493, false, $$e(b5, b6, b6), new Class[]{Object.class, Object.class});
                        }
                        ((Method) objAccessartificialFrame3).invoke(null, objArr4);
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause == null) {
                            throw th;
                        }
                        throw cause;
                    }
                }
                char[] cArr = new char[i2];
                _creation.b = 0;
                int i7 = $10 + 95;
                $11 = i7 % 128;
                if (i7 % 2 == 0) {
                    int i8 = 2 / 2;
                }
                while (_creation.b < i2) {
                    int i9 = $10 + 87;
                    $11 = i9 % 128;
                    if (i9 % 2 == 0) {
                        cArr[_creation.b] = (char) jArr[_creation.b];
                        Object[] objArr5 = {_creation, _creation};
                        Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-293902099);
                        if (objAccessartificialFrame4 == null) {
                            byte b7 = (byte) 0;
                            byte b8 = b7;
                            objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(25 - View.resolveSizeAndState(0, 0, 0), (char) (30068 - (ViewConfiguration.getTapTimeout() >> 16)), 816 - ExpandableListView.getPackedPositionType(0L), 1897803493, false, $$e(b7, b8, b8), new Class[]{Object.class, Object.class});
                        }
                        ((Method) objAccessartificialFrame4).invoke(null, objArr5);
                        int i10 = 42 / 0;
                        obj = null;
                    } else {
                        cArr[_creation.b] = (char) jArr[_creation.b];
                        Object[] objArr6 = {_creation, _creation};
                        Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-293902099);
                        if (objAccessartificialFrame5 == null) {
                            byte b9 = (byte) 0;
                            byte b10 = b9;
                            objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(24 - MotionEvent.axisFromString(""), (char) (View.combineMeasuredStates(0, 0) + 30068), 816 - (ViewConfiguration.getScrollBarSize() >> 8), 1897803493, false, $$e(b9, b10, b10), new Class[]{Object.class, Object.class});
                        }
                        obj = null;
                        ((Method) objAccessartificialFrame5).invoke(null, objArr6);
                    }
                }
                objArr[0] = new String(cArr);
            }

            @Override // net.openid.appauth.AuthorizationServiceConfiguration.RetrieveConfigurationCallback
            public void onFetchConfigurationCompleted(@Nullable AuthorizationServiceConfiguration authorizationServiceConfiguration, @Nullable AuthorizationException authorizationException) {
                if (authorizationException != null) {
                    promise.reject("service_configuration_fetch_error", authorizationException.getLocalizedMessage(), authorizationException);
                } else {
                    RNAppAuthModule.this.setServiceConfiguration(str, authorizationServiceConfiguration);
                    RNAppAuthModule.this.registerWithConfiguration(authorizationServiceConfiguration, appAuthConfigurationCreateAppAuthConfiguration, readableArray, readableArray2, readableArray3, str2, str3, map, promise);
                }
            }

            static {
                char[] cArr = new char[1959];
                ByteBuffer.wrap("uÂ%$ÔÒ\u0087\u009c7væë\u0091\u008cA:ðá£\u009eSF\u0002ñ½\u0099m{\u001cúÏª\u007fY.âÙ¢\u0089I8\u001aë\u0083\u009b@J\u0016å´\u0095kD\u001a¦ öF\u0007°Tþä\u00145\u0089Bî\u0092X#\u0083pü\u0080$Ñ\u0093nû¾\u0019Ï\u0089\u001cÅ¬/ý\u0097\núZ<ë{8ÌH2\u0099p6Ó\u0019ÑI7¸Áë\u008f[e\u008aøý\u009f-)\u009còÏ\u008d?UnâÑ\u008a\u0001hpû£¤\u0013@Bà\u0019ÑI ¸Ýë\u008a[e\u008aòý\u009f-!\u009cãÏ\u0087?Yn¾Ñ\u0085\u0001Xpä£¹\u0013HBêµ§åAT%\u0087\u00ad÷A&\u0001\u0089²ù~(\u001e\u009b¸\u0019ÑI6¸Ðë\u009a[e\u008aûý\u0097-k\u009cæÏ\u0099?Sná\u0019ÑI6¸Ðë\u009a[e\u008aìý\u0099-(\u009c¸Ï\u009b?NnþÑ\u0092\u0019ÑI ¸Àë\u009a[+\u008aíý\u0094-j\u009cÄÏ\u00ad?qnþÑ\u0094\u0001RpÌ£¼\u0013ZBâ\u0019ÑI7¸Åë\u008d[+\u008a°ýÞ-&\u009cæÏ\u009e?UnÿÑ\u0084\u0001Xû¼«\fZº\t«¹\u0015hÀ\u001f´Ï[~Ô-¾Ýh\u008cÓ3½ãn\u0092ÜA²ñp ÖW\u0090\u0007F¶.e\u0091\u0015cÄt\u0019\u008cI<¸\u008aë\u009b[%\u008aðý\u0084-k\u009cäÏ\u008e?XnãÑ\u008d\u0001^pì£\u0082\u0013@Bæµ åvT\u001e\u0087¡÷S&G\u0019ÑI ¸Ýë\u008a[>\u008aúý\u009d-j\u009cúÏ\u0082?^n¾Ñ\u008e\u0001^pê£³\u0013LB\u00adµ§åFa 1\u0006Àÿ\u0093«#\u0019òÛ\u0019¢I\u0012\u0093ÝÃ,2Ña\u0086Ñ2\u0000öw\u0091§f\u0016øE\u008eµ^ä²[\u0080\u008b^úé)¤\u0099tÈÂ?õoKÞ\u0013\r®}Y¬T\u0003©sx¢\u000e\u0011¹Al°\u0004çØ\u0019ÑI ¸Ýë\u008a[>\u008aúý\u009d-j\u009côÏ\u0082?Rn¾Ñ\u008c\u0001Rpå£¨\u0013xBÎµùåYT\b\u0087 ÷P\u0019ÑI ¸Ýë\u008a[>\u008aúý\u009d-j\u009cúÏ\u0082?^n¾Ñ\u008e\u0001^pê£³\u0013KBîµ¡å\u007fT7\u0087¿÷R&\u001a\u0089¶ù5(\u001f\u009b®M¼\u001dZì¬¿â\u000f\bÞ\u009c©øyEÈ\u008e\u009bák$:\u0099\u0085üU.¶_æï\u0017YDHôì%%RO\u0082ò3k`P\u0090\u0080Á1~EÃu\u0093Ób 1o\u0081ÊPT'{÷ÅF\u0007\u0019ÑI#¸Öë\u0096[)\u008a°ý\u0096-,\u009cúÏ\u008e?OnèÑ\u0091\u0001Cpí£°\u0013]ÔÄ\u0084bu\u009d&Ø\u0096mG\u00ad\u001c\u007fLÏ½yîz^Ë\u008f\u0003øg(Ã\u0099\u0006Êl:ák\u000fÔp\u0004ªu\u000e¦H\u0016¼G\u0013°Sà¯Qû\u0082Yò¡\u0019\u0099I6¸Êë\u0080 Ìpt\u0081\u0094ÒÈba³®ÄÆ\u0014)¥§öÐ\u0006\rWýèÂ8\u0011Iä\u009aû*\t{£\u008cãÜ\fm\u0016¾êÎ\u0012\u001fB°ªÀ?\u0011O¢èò5\u0003zT\u009dä?5iF®\u00964'~x\u0086\u0089ÙÙwj\u0095»ÑË{Uf\u0005Þô>§b\u0017ËÆ\u0004±la\u0083Ð\r\u0083zs§\"W\u009dhM»<NïQ_£\u000e\tùI©¦\u0018¼Ë@»¸jèÅ\u0000µ\u0095då×B\u0087\u009fvÐ!7\u0091\u0095@Ã3\u0004ã\u009aRÔ\r,üs¬×\u001f?wó'KÖ«\u0085÷5^ä\u0091\u0093ùC\u0016ò\u0098¡ïQ2\u0000Â¿ýo.\u001eÛÍÄ}6,\u009cÛÜ\u008b3:)éÀ\u00992H&çØ\u0097\u0017Fx\u0019\u008eI6¸Öë\u008a[#\u008aìý\u0084-k\u009cåÏ\u0092?On¿Ñ\u0080\u0001Sp¦£¹\u0013KBáµ¡åNTT\u0087½÷O&[\u0089ªùz(\u000f\u001d\u0091M)¼Éï\u0095_<\u008eóù\u009b)t\u0098úË\u008d;Pj Õ\u009f\u0005Lt¹§¦\u0017TFþ±¾áQPK\u0083¢óP\"D\u008d´ýg,\u0010\u0019\u008eI6¸Öë\u008a[#\u008aìý\u0084-k\u009cåÏ\u0092?On¿Ñ\u0080\u0001Sp¦£¹\u0013KBáµ¡åNTT\u0087½÷O&[\u0089«ùu(\u000f¥\u0098õ!\u0004ÛW\u0091ç)6éÄ[\u0094©e\\6\u001c\u0086£W: \u0017ð Ax\u0012\u0014âÚ³~\f\u001b\u0019\u0088I1¸Ëë\u0081[-\u008aêý\u0095-6\u009câ\u0019¹I6¸Êë\u0080['\u008aðý\u0084-,\u009cùÏ\u0085P\u008e\u00008ñÊ¢\u0092\u0012 Ãí´\u009b5\u000be\u00ad\u0094@Ç\u0000w±¦`Ñ\u0013\u0001¾\u0019\u008cI<¸\u008aë\u0089[8\u008aðý\u0094-0\u009cõÏ\u009f?\u0012nõÑ\u0087\u0001Apá£¾\u0013K\u0094\u0012Ä«5Qf\u001bÖè\u00073p\u001aîO¾àO\u001c\u001cJ¬î} \nE.w~Ø\u008f$ÜrlÖ½\u0018Ê}\u001aô«\u0000ø=\bä\u0007ïW@¦¼õêEN\u0094\u0080ãå3l\u0082\u0098Ñ¥!|p¸Ï¢\u001fuõØ¥hTÞ\u0007Ý·lf¤\u0011ÀÁdp¡#ËÓF\u0082¨=Ùí\u0007\u009c¹Oå«)û\u0093\nko\u001b?¾ÎQ\u009d\u0015-«ük\u008b\u001f[·Ðá\u0080}q\u008a\"\u0087\u0092FC´4ÀäoU¡\u0006Øö\u0007§ï\u0018ÚÈ\u0006¹¤j£Ú3\u008bµ|ø,\u0018\u009dINôÃ\\\u0093Þb#1h\u0081ÆP\u0015'w÷\u0086F&\u0015Lå\u0094´R\u000bcÛ¡ª\u0002yRÉ¹\u0098@oQ?¥\u008eë]\f-»ü®S\u0013\u0019¿I=¸Àë\u008b[%\u008aöý\u0094-e\u009cÅÏ¯?wn±Ñ\u0080\u0001Bpá£±\u0013ZB£µ²åFT\b\u0087ï÷X&M\u0089ðùD(Z\u009bõ\u0019\u008cI<¸\u008aë\u0091[+\u008aíý\u0094-2\u009c÷Ï\u0099?Y\u0019\u0099I<¸Èë\u009d[,\u008aöý\u0083--\u0019\u0088I1¸Ëë\u0081[r\u008a©\u0019\u008cI2¸Êë\u009a[\"\u008aê²àâP\u0013æ@åðT!\u009cVø\u0086\\7\u0099dó\u0094~Å\u009fzüª:Û\u008a\bÕ\u0019\u008cI<¸\u008aë\u0092[/\u008aíý\u009e- \u009cúÏÅ?MnôÑ\u008f\u0001B\u0019Ï\u0019\u008cI<¸\u008aë\u008a[/\u008aüý\u0085-7\u009có\u0019Î\u0006EVõ§CôRDö\u0095?âU2è\u0083qÐR \u0087q7ÎO\u001e\u008bo\"¼`\u0019\u0098I&¸Èë\u0095[\u0015\u008açýÈ-sÑa\u0081Ñpg#v\u0093ÒB\u001b5qåÌTU\u0007`÷¸¦\u0012\u0019hÉ¿¸\u0017k@Û±\u008a\u0007}W-°\u0019\u0099I6¸Êë\u009c[8\u008aöý\u0093-j\u009cåÏ\u008f?Wn¾Ñ\u0085\u0001Rpæ£¸\u0013\\Bêµ·\u0019\u0099I6¸Êë\u009c[8\u008aöý\u0093-\u001a\u009cîÏÓ?\nn¾Ñ\u0091\u0001Spã£\u0082\u0013VB»µâå\u0006T\u001d\u0087ª÷N&\u0010\u0089´ùr(\u000f\u009b\u009eËj:_m\u008e\u0019\u0099I6¸Êë\u009c[8\u008aöý\u0093-j\u009cñÏ\u0084?SnöÑ\u008e\u0001Rp×£®\u0013JBèµûåNT\u001f\u0087¡÷E&\u0007\u0089¯ùx\u0092\u0002Â\u00ad3Q`\u0007Ð£\u0001mv\b¦ñ\u0017{D\u0012´ÈårZA\u008a\u009aûc(i\u0098ÃÉz> nÊßÙ\fb|Ëµ¡å\u0004\u0014óG¦÷\u001e&ÂQç\u0081\u000e0Êc¸\u0093[ÂÎ}ª\u00adgÜß\u000f\u008b¿sîä\u0019\u0094I)øt+Ø[\u007f\u008a(%\u0090UF\u0084&7\u0090gI\u0096\u0000Áøq\r P\u0019\u008cI<¸\u008aë\u009b[%\u008aðý\u0084-)\u009cùÏ\u008a?XnôÑ\u0090\u0019\u008cI<¸\u008aë\u009b[%\u008aðý\u0084-,\u009cûÏ\u008a?[nôÑÌ\u0001Upý£´\u0013BBçµúåOT\u0013\u0087¡÷G&\u0010\u0089´ùk(\u001e\u009b¨Ë|:\u0013\u0096\u0086Æ\u00047ùd²Ô\u001c\u0005Ïr\u00ad¢Q\u0013×@ê°3s\u0094#$Ò\u0092\u0081\u00831'àî\u0097\u0084G9ö ¥\u0097UM\u0004ú»\u008akC\u001añÉ¼y\u0018(òß¨\u0019\u008aI6¸×ë\u008d[g\u0019\u0097I=¸Íë\u008d[d\u008aìý\u0086-&\u009c¸Ï\u009a?YnüÑ\u0097\u0001\u001apø£¯\u0013ABóµ§\u0096íÆT7«dîÔ\u0006\u0005\u0095rå¢\t\u0013\u0099@è°7á\u009d^ë\u008e0ÿ\u0093,Ì\u0019\u008fI6¸Éë\u008c[d\u008aìý\u0096-k\u009cðÏ\u008a?WnôÑ½\u0001Tpé£°\u0013KBñµµ\u0019\u008fI6¸Éë\u008c[d\u008aìý\u0096-k\u009cúÏ\u0088?XnÎÑ\u0086\u0001Rpæ£®\u0013GB÷µ\u00ad\u0019\u008cI<¸\u008aë\u0092[/\u008aíý\u009e- \u009cúÏÅ?]nÿÑ\u0086\u0001Epç£´\u0013JB\u00adµ¥åLT\u0017\u0087º÷D\u0019\u008cI<¸\u008aë\u009b[%\u008aðý\u0084-k\u009cçÏ\u008e?QnäÑÌ\u0001Vpþ£¹\u0013qBíµµåDT\u001f\u0019\u008cI<¸\u008aë\u0096[.\u008aòýÞ-'\u009cãÏ\u0082?PnõÑÌ\u0001Qpá£³\u0013IBæµ¦åYT\b\u0087¦÷N&\u0001\u0019\u008cI<¸\u008aë\u0089[8\u008aðý\u0094-0\u009cõÏ\u009f?\u0012nóÑ\u0097\u0001^pä£¹\u0013\u0000Båµ½åGT\u001d\u0087ª÷R&\u0005\u0089´ùr(\u0002\u009bµ\u0019\u008cI<¸\u008aë\u008a[3\u008aìý\u0084- \u009cûÏÅ?^näÑ\u008b\u0001[pì£ó\u0013HBêµºåNT\u001f\u0087½÷P&\u0007\u0089¯ùu(\u0018\u0019\u008cI<¸\u008aë\u008a[3\u008aìý\u0084- \u009cûÏ´?YnéÑ\u0096\u0001\u0019pê£¨\u0013GBïµ°å\u0007T\u001c\u0087¦÷N&\u0012\u0089£ùi(\u001c\u009b³Ë{:\tmÌ\u0019\u008cI<¸\u008aë\u008f[/\u008añý\u0094-*\u009cäÏÅ?^näÑ\u008b\u0001[pì£ó\u0013HBêµºåNT\u001f\u0087½÷P&\u0007\u0089¯ùu(\u0018\u0019\u008cI<¸\u008aë\u008f[/\u008añý\u0094-*\u009cäÏ´?XnýÑ\u0089\u0001Zp¦£¿\u0013[Bêµ¸åMTT\u0087©÷I&\u001b\u0089¡ù~(\u001e\u009b±Ë`:\u000emÖÝy\u0019ÄÓ{\u0083\u009drk!%\u0091Ï@D7?ç\u0082VI\u0005\u001eõæ¤R\u001b8ËøÔ|\u0084\u009aul&\"\u0096ÈGA02à\u008bQP\u0002#òå£\u0013\u001c-Ìû½Vn\u0015Þá\u008fOx\u0017(à\u0099\u0088J\u0005:èë¶D\u00124ÒJ\u0099\u001a\u007fë\u0089¸Ç\b-Ù¤®×~nÏµ\u009cÆl\u0000=ö\u0082ÍR\u001a#®ðì@\u0002Zn\n\u0088û~¨0\u0018ÚÉS¾ n\u0099ßB\u008c1|÷-\u0001\u0092,Bí3Zà\u0017Põá\u009c±m@\u0090\u0013Ç£(r£\u0005ØÕed®7ùÇ\u0005\u0096®)Îù\u0019\u0088 \u0019ÑI ¸Ýë\u008a[>\u008aúý\u009d-j\u009cúÏ\u0082?^n¾Ñ\u008e\u0001^pê£¾\u0013qBîµµåET\u0016\u0087 ÷C&*\u0089¢ù~(\u000e\u009b´Ëu:8mÉÝh\f3\u007fÆ¯*\u001e*AÅ¤\u001côú\u0005\fVBæ¨70@N\u0090ü!\u0004rA\u0082\u0081Ó/\u0017sG\u0095¶cå-UÇ\u0084_ó!#\u0093\u0092kÁ=1÷`^ß%üª¬L]º\u000eô¾\u001eo\u0097\u0018äÈ]y\u0086*õÚ3\u008bÅ4ûä?\u0095\u0087FÀö:§\u0094PË\u00007±sbÐ\u0019ÑI ¸Ýë\u008a[>\u008aúý\u009d-j\u009cúÏ\u0082?^n¾Ñ\u008e\u0001^pê£¿\u0013]B÷µ²åFT\u0016\u0087«÷E&\u0007\u0089\u0099ùq(\u0002\u009b¨Ë<:\u0014m×\u0019ÑI7¸Áë\u008f[e\u008aýý\u0083-1\u009c÷Ï\u0088?_nôÎc\u009e\u0085os<=\u008c×]O*1ú\u0083KC\u0018 èü¹L\u0019ÑI7¸Áë\u008f[e\u008aýý\u0083-1\u009cûÏ\u008e?[nÿ\u009cÝÌ;=Ín\u0083Þi\u000fñx\u008f¨=\u0019õJ\u0095ºYëø\u0019ÑI7¸Áë\u008f[e\u008aýý\u0083-1\u009càÏ\u0086?OnöÐ0\u0080Öq \"n\u0092\u0084C\u001c4bäÐU\u0007\u0006mö¼§\u0019\u0018sÈµ\u0011MA«°]ã\u0013Sù\u0082aõ\u001f%\u00ad\u0094UÇ\u001e7Ífh\u0019ÑI7¸Åë\u008d[+\u008a°ý\u0094-*\u009cáÏ\u0085?PnþÑ\u0083\u0001Spû£ò\u0013\u0000Bûµ¶å\u0006T\u0018\u0087¼÷T&\u001eç\n·åF\u0011\u0015V¥¾t3\u0003BÓðb)1_Á\u0090\u00909/\u0016ÿ®\u008e ]rí¦¼0Kn\u001b\u0080ªÄyp\t½ØÁwq\u0007¤ÖÒeh\u0019ÑI#¸Öë\u0096[)\u008a°ý\u0099-*\u009cæÏ\u0084?NnåÑ\u0091\u00895ÙÎ(9{\"Ë\u008b\u0098\u008aÈx9\u008djÍÚr\u000bë|Ø¬{\u001d¡NÖ¾Hï§PØ\u0080\u001cñ \u0010J@ò±\u0016âFRõ\u0083#ô@$¸\u0095\"ÆW6\u0083g&ØW\b\u008dy(ªf\u001aÓK#¼h\u0019\u0092I:¸Æë¾[\u0006\u008aÚý£-\u001a\u009côÏ\u0098?Hn¿Ñ\u0091\u0001X\u0019ÑI6¸Ðë\u009a[e\u008aòý\u0095-!\u009cÿÏ\u008a?cnòÑ\u008d\u0001Spí£¾\u0013]B\u00adµ¬åDT\u0016\u0019\u009cI?¸Ñë\u009c[9\u008aëý\u0091-&\u009cýÏ\u0098\u0001ÌQ+ Íó\u0087Cx\u0092ïå\u00825-\u0084å×\u0082'R\u0019ÑI7¸Åë\u008d[+\u008a°ý\u0094-*\u009cáÏ\u0085?PnþÑ\u0083\u0001Spû£ò\u0013\u0000Bçµ¤å\u0006T\u001b\u0087¿÷P&\u0006\u0089èùc(\u0001\u009b\u00adWä\u0007\u0016öã¥£\u0015\u001cÄ\u0085³¦c\u0000ÒÖ\u0081·qg Â\u009f¸\u0019¹I<¸Èë\u009d[,\u008aöý\u0083--\u0019ÑI7¸Åë\u008d[+\u008a°ý\u009d-,\u009cåÏ\u0088?\u0013náÑ\u0090\u0001Xpî£´\u0013BBæµ§å\u0006T\u0019\u0087º÷R&Z\u0089öù4(\u000f\u009b®Ë\u007f:ImÕÝd\f=\u007fÁ¯k\u001e/AÃ°\u008dà$S\u008b\u0082\u009bò.%ñ\u0094\u0084Ä+7úf\u008d".getBytes(CharEncoding.ISO_8859_1)).asCharBuffer().get(cArr, 0, 1959);
                _CREATION = cArr;
                _BOUNDARY = -7759397095488337581L;
            }

            /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
                java.util.NoSuchElementException
                	at java.base/java.util.TreeMap.key(Unknown Source)
                	at java.base/java.util.TreeMap.lastKey(Unknown Source)
                	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
                	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
                	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
                */
            public static java.lang.Object[] CoroutineDebuggingKt(android.content.Context r68, int r69, int r70, int r71) {
                /*
                    Method dump skipped, instruction units count: 15375
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.rnappauth.RNAppAuthModule.AnonymousClass2.CoroutineDebuggingKt(android.content.Context, int, int, int):java.lang.Object[]");
            }
        }, connectionBuilderCreateConnectionBuilder);
    }

    @ReactMethod
    public void authorize(final String str, final String str2, final String str3, String str4, final ReadableArray readableArray, ReadableMap readableMap, ReadableMap readableMap2, Boolean bool, Double d, final Boolean bool2, final Boolean bool3, String str5, boolean z, ReadableMap readableMap3, ReadableArray readableArray2, final boolean z2, final Promise promise) {
        AuthorizationServiceConfiguration authorizationServiceConfigurationCreateAuthorizationServiceConfiguration;
        parseHeaderMap(readableMap3);
        ConnectionBuilder connectionBuilderCreateConnectionBuilder = createConnectionBuilder(z, this.authorizationRequestHeaders, d);
        final AppAuthConfiguration appAuthConfigurationCreateAppAuthConfiguration = createAppAuthConfiguration(connectionBuilderCreateConnectionBuilder, Boolean.valueOf(z), readableArray2);
        final HashMap<String, String> map = MapUtil.readableMapToHashMap(readableMap);
        this.promise = promise;
        this.dangerouslyAllowInsecureHttpRequests = z;
        this.additionalParametersMap = map;
        this.clientSecret = str4;
        this.clientAuthMethod = str5;
        this.skipCodeExchange = bool;
        this.useNonce = bool2;
        this.usePKCE = bool3;
        if (readableMap2 != null || hasServiceConfiguration(str)) {
            try {
                if (hasServiceConfiguration(str)) {
                    authorizationServiceConfigurationCreateAuthorizationServiceConfiguration = getServiceConfiguration(str);
                } else {
                    authorizationServiceConfigurationCreateAuthorizationServiceConfiguration = createAuthorizationServiceConfiguration(readableMap2);
                }
                authorizeWithConfiguration(authorizationServiceConfigurationCreateAuthorizationServiceConfiguration, appAuthConfigurationCreateAppAuthConfiguration, str3, readableArray, str2, bool2, bool3, map, Boolean.valueOf(z2));
                return;
            } catch (ActivityNotFoundException e) {
                promise.reject("browser_not_found", e.getMessage());
                return;
            } catch (Exception e2) {
                promise.reject("authentication_failed", e2.getMessage());
                return;
            }
        }
        AuthorizationServiceConfiguration.fetchFromUrl(buildConfigurationUriFromIssuer(Uri.parse(str)), new AuthorizationServiceConfiguration.RetrieveConfigurationCallback() { // from class: com.rnappauth.RNAppAuthModule.3
            @Override // net.openid.appauth.AuthorizationServiceConfiguration.RetrieveConfigurationCallback
            public void onFetchConfigurationCompleted(@Nullable AuthorizationServiceConfiguration authorizationServiceConfiguration, @Nullable AuthorizationException authorizationException) {
                if (authorizationException != null) {
                    promise.reject("service_configuration_fetch_error", authorizationException.getLocalizedMessage(), authorizationException);
                    return;
                }
                RNAppAuthModule.this.setServiceConfiguration(str, authorizationServiceConfiguration);
                try {
                    RNAppAuthModule.this.authorizeWithConfiguration(authorizationServiceConfiguration, appAuthConfigurationCreateAppAuthConfiguration, str3, readableArray, str2, bool2, bool3, map, Boolean.valueOf(z2));
                } catch (ActivityNotFoundException e3) {
                    promise.reject("browser_not_found", e3.getMessage());
                } catch (Exception e4) {
                    promise.reject("authentication_failed", e4.getMessage());
                }
            }
        }, connectionBuilderCreateConnectionBuilder);
    }

    @ReactMethod
    public void refresh(final String str, final String str2, final String str3, final String str4, final String str5, final ReadableArray readableArray, ReadableMap readableMap, ReadableMap readableMap2, Double d, final String str6, boolean z, ReadableMap readableMap3, ReadableArray readableArray2, final Promise promise) {
        AuthorizationServiceConfiguration authorizationServiceConfigurationCreateAuthorizationServiceConfiguration;
        parseHeaderMap(readableMap3);
        ConnectionBuilder connectionBuilderCreateConnectionBuilder = createConnectionBuilder(z, this.tokenRequestHeaders, d);
        final AppAuthConfiguration appAuthConfigurationCreateAppAuthConfiguration = createAppAuthConfiguration(connectionBuilderCreateConnectionBuilder, Boolean.valueOf(z), readableArray2);
        final HashMap<String, String> map = MapUtil.readableMapToHashMap(readableMap);
        if (str4 != null) {
            map.put("client_secret", str4);
        }
        this.dangerouslyAllowInsecureHttpRequests = z;
        this.additionalParametersMap = map;
        if (readableMap2 != null || hasServiceConfiguration(str)) {
            try {
                if (hasServiceConfiguration(str)) {
                    authorizationServiceConfigurationCreateAuthorizationServiceConfiguration = getServiceConfiguration(str);
                } else {
                    authorizationServiceConfigurationCreateAuthorizationServiceConfiguration = createAuthorizationServiceConfiguration(readableMap2);
                }
                refreshWithConfiguration(authorizationServiceConfigurationCreateAuthorizationServiceConfiguration, appAuthConfigurationCreateAppAuthConfiguration, str5, str3, readableArray, str2, map, str6, str4, promise);
                return;
            } catch (ActivityNotFoundException e) {
                promise.reject("browser_not_found", e.getMessage());
                return;
            } catch (Exception e2) {
                promise.reject("token_refresh_failed", e2.getMessage());
                return;
            }
        }
        AuthorizationServiceConfiguration.fetchFromUrl(buildConfigurationUriFromIssuer(Uri.parse(str)), new AuthorizationServiceConfiguration.RetrieveConfigurationCallback() { // from class: com.rnappauth.RNAppAuthModule.4
            @Override // net.openid.appauth.AuthorizationServiceConfiguration.RetrieveConfigurationCallback
            public void onFetchConfigurationCompleted(@Nullable AuthorizationServiceConfiguration authorizationServiceConfiguration, @Nullable AuthorizationException authorizationException) {
                if (authorizationException != null) {
                    promise.reject("service_configuration_fetch_error", authorizationException.getLocalizedMessage(), authorizationException);
                    return;
                }
                RNAppAuthModule.this.setServiceConfiguration(str, authorizationServiceConfiguration);
                try {
                    RNAppAuthModule.this.refreshWithConfiguration(authorizationServiceConfiguration, appAuthConfigurationCreateAppAuthConfiguration, str5, str3, readableArray, str2, map, str6, str4, promise);
                } catch (ActivityNotFoundException e3) {
                    promise.reject("browser_not_found", e3.getMessage());
                } catch (Exception e4) {
                    promise.reject("token_refresh_failed", e4.getMessage());
                }
            }
        }, connectionBuilderCreateConnectionBuilder);
    }

    @ReactMethod
    public void logout(final String str, final String str2, final String str3, ReadableMap readableMap, ReadableMap readableMap2, boolean z, ReadableArray readableArray, final Promise promise) {
        AuthorizationServiceConfiguration authorizationServiceConfigurationCreateAuthorizationServiceConfiguration;
        ConnectionBuilder connectionBuilderCreateConnectionBuilder = createConnectionBuilder(z, null);
        final AppAuthConfiguration appAuthConfigurationCreateAppAuthConfiguration = createAppAuthConfiguration(connectionBuilderCreateConnectionBuilder, Boolean.valueOf(z), readableArray);
        final HashMap<String, String> map = MapUtil.readableMapToHashMap(readableMap2);
        this.promise = promise;
        if (readableMap != null || hasServiceConfiguration(str)) {
            try {
                if (hasServiceConfiguration(str)) {
                    authorizationServiceConfigurationCreateAuthorizationServiceConfiguration = getServiceConfiguration(str);
                } else {
                    authorizationServiceConfigurationCreateAuthorizationServiceConfiguration = createAuthorizationServiceConfiguration(readableMap);
                }
                endSessionWithConfiguration(authorizationServiceConfigurationCreateAuthorizationServiceConfiguration, appAuthConfigurationCreateAppAuthConfiguration, str2, str3, map);
                return;
            } catch (ActivityNotFoundException e) {
                promise.reject("browser_not_found", e.getMessage());
                return;
            } catch (Exception e2) {
                promise.reject("end_session_failed", e2.getMessage());
                return;
            }
        }
        AuthorizationServiceConfiguration.fetchFromUrl(buildConfigurationUriFromIssuer(Uri.parse(str)), new AuthorizationServiceConfiguration.RetrieveConfigurationCallback() { // from class: com.rnappauth.RNAppAuthModule.5
            @Override // net.openid.appauth.AuthorizationServiceConfiguration.RetrieveConfigurationCallback
            public void onFetchConfigurationCompleted(@Nullable AuthorizationServiceConfiguration authorizationServiceConfiguration, @Nullable AuthorizationException authorizationException) {
                if (authorizationException != null) {
                    promise.reject("service_configuration_fetch_error", authorizationException.getLocalizedMessage(), authorizationException);
                    return;
                }
                RNAppAuthModule.this.setServiceConfiguration(str, authorizationServiceConfiguration);
                try {
                    RNAppAuthModule.this.endSessionWithConfiguration(authorizationServiceConfiguration, appAuthConfigurationCreateAppAuthConfiguration, str2, str3, map);
                } catch (ActivityNotFoundException e3) {
                    promise.reject("browser_not_found", e3.getMessage());
                } catch (Exception e4) {
                    promise.reject("end_session_failed", e4.getMessage());
                }
            }
        }, connectionBuilderCreateConnectionBuilder);
    }

    @Override // com.facebook.react.bridge.ActivityEventListener
    public void onActivityResult(Activity activity, int i, int i2, Intent intent) throws Exception {
        TokenRequest tokenRequestCreateTokenExchangeRequest;
        WritableMap writableMapAuthorizationResponseToMap;
        String str;
        try {
            if (i == 52) {
                if (intent == null) {
                    Promise promise = this.promise;
                    if (promise != null) {
                        promise.reject("authentication_error", "Data intent is null");
                        return;
                    }
                    return;
                }
                final AuthorizationResponse authorizationResponseFromIntent = AuthorizationResponse.fromIntent(intent);
                AuthorizationException authorizationExceptionFromIntent = AuthorizationException.fromIntent(intent);
                if (authorizationExceptionFromIntent != null) {
                    Promise promise2 = this.promise;
                    if (promise2 != null) {
                        handleAuthorizationException("authentication_error", authorizationExceptionFromIntent, promise2);
                        return;
                    }
                    return;
                }
                Boolean bool = this.skipCodeExchange;
                if (bool != null && bool.booleanValue()) {
                    Boolean bool2 = this.usePKCE;
                    if (bool2 != null && bool2.booleanValue() && (str = this.codeVerifier) != null) {
                        writableMapAuthorizationResponseToMap = TokenResponseFactory.authorizationCodeResponseToMap(authorizationResponseFromIntent, str);
                    } else {
                        writableMapAuthorizationResponseToMap = TokenResponseFactory.authorizationResponseToMap(authorizationResponseFromIntent);
                    }
                    Promise promise3 = this.promise;
                    if (promise3 != null) {
                        promise3.resolve(writableMapAuthorizationResponseToMap);
                        return;
                    }
                    return;
                }
                final Promise promise4 = this.promise;
                AuthorizationService authorizationService = new AuthorizationService(this.reactContext, createAppAuthConfiguration(createConnectionBuilder(this.dangerouslyAllowInsecureHttpRequests, this.tokenRequestHeaders), Boolean.valueOf(this.dangerouslyAllowInsecureHttpRequests), null));
                Map<String, String> map = this.additionalParametersMap;
                if (map == null) {
                    tokenRequestCreateTokenExchangeRequest = authorizationResponseFromIntent.createTokenExchangeRequest();
                } else {
                    tokenRequestCreateTokenExchangeRequest = authorizationResponseFromIntent.createTokenExchangeRequest(map);
                }
                AuthorizationService.TokenResponseCallback tokenResponseCallback = new AuthorizationService.TokenResponseCallback() { // from class: com.rnappauth.RNAppAuthModule.6
                    @Override // net.openid.appauth.AuthorizationService.TokenResponseCallback
                    public void onTokenRequestCompleted(TokenResponse tokenResponse, AuthorizationException authorizationException) {
                        if (tokenResponse != null) {
                            WritableMap writableMap = TokenResponseFactory.tokenResponseToMap(tokenResponse, authorizationResponseFromIntent);
                            Promise promise5 = promise4;
                            if (promise5 != null) {
                                promise5.resolve(writableMap);
                                return;
                            }
                            return;
                        }
                        if (RNAppAuthModule.this.promise != null) {
                            RNAppAuthModule rNAppAuthModule = RNAppAuthModule.this;
                            rNAppAuthModule.handleAuthorizationException("token_exchange_failed", authorizationException, rNAppAuthModule.promise);
                        }
                    }
                };
                String str2 = this.clientSecret;
                if (str2 != null) {
                    authorizationService.performTokenRequest(tokenRequestCreateTokenExchangeRequest, getClientAuthentication(str2, this.clientAuthMethod), tokenResponseCallback);
                } else {
                    authorizationService.performTokenRequest(tokenRequestCreateTokenExchangeRequest, tokenResponseCallback);
                }
            }
            if (i == 53) {
                if (intent == null) {
                    Promise promise5 = this.promise;
                    if (promise5 != null) {
                        promise5.reject("end_session_failed", "Data intent is null");
                        return;
                    }
                    return;
                }
                EndSessionResponse endSessionResponseFromIntent = EndSessionResponse.fromIntent(intent);
                AuthorizationException authorizationExceptionFromIntent2 = AuthorizationException.fromIntent(intent);
                if (authorizationExceptionFromIntent2 != null) {
                    Promise promise6 = this.promise;
                    if (promise6 != null) {
                        handleAuthorizationException("end_session_failed", authorizationExceptionFromIntent2, promise6);
                        return;
                    }
                    return;
                }
                Promise promise7 = this.promise;
                if (promise7 != null) {
                    promise7.resolve(EndSessionResponseFactory.endSessionResponseToMap(endSessionResponseFromIntent));
                }
            }
        } catch (Exception e) {
            Promise promise8 = this.promise;
            if (promise8 != null) {
                promise8.reject("run_time_exception", e.getMessage());
                return;
            }
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registerWithConfiguration(AuthorizationServiceConfiguration authorizationServiceConfiguration, AppAuthConfiguration appAuthConfiguration, ReadableArray readableArray, ReadableArray readableArray2, ReadableArray readableArray3, String str, String str2, Map<String, String> map, final Promise promise) {
        AuthorizationService authorizationService = new AuthorizationService(this.reactContext, appAuthConfiguration);
        RegistrationRequest.Builder additionalParameters = new RegistrationRequest.Builder(authorizationServiceConfiguration, arrayToUriList(readableArray)).setAdditionalParameters(map);
        if (readableArray2 != null) {
            additionalParameters.setResponseTypeValues(arrayToList(readableArray2));
        }
        if (readableArray3 != null) {
            additionalParameters.setGrantTypeValues(arrayToList(readableArray3));
        }
        if (str != null) {
            additionalParameters.setSubjectType(str);
        }
        if (str2 != null) {
            additionalParameters.setTokenEndpointAuthenticationMethod(str2);
        }
        authorizationService.performRegistrationRequest(additionalParameters.build(), new AuthorizationService.RegistrationResponseCallback() { // from class: com.rnappauth.RNAppAuthModule.7
            @Override // net.openid.appauth.AuthorizationService.RegistrationResponseCallback
            public void onRegistrationRequestCompleted(@Nullable RegistrationResponse registrationResponse, @Nullable AuthorizationException authorizationException) {
                if (registrationResponse != null) {
                    promise.resolve(RegistrationResponseFactory.registrationResponseToMap(registrationResponse));
                } else {
                    RNAppAuthModule.this.handleAuthorizationException("registration_failed", authorizationException, promise);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void authorizeWithConfiguration(AuthorizationServiceConfiguration authorizationServiceConfiguration, AppAuthConfiguration appAuthConfiguration, String str, ReadableArray readableArray, String str2, Boolean bool, Boolean bool2, Map<String, String> map, Boolean bool3) {
        String strArrayToString = readableArray != null ? arrayToString(readableArray) : null;
        ReactApplicationContext reactApplicationContext = this.reactContext;
        Activity currentActivity = getCurrentActivity();
        AuthorizationRequest.Builder builder = new AuthorizationRequest.Builder(authorizationServiceConfiguration, str, ResponseTypeValues.CODE, Uri.parse(str2));
        if (strArrayToString != null) {
            builder.setScope(strArrayToString);
        }
        if (map != null) {
            if (map.containsKey("display")) {
                builder.setDisplay(map.get("display"));
                map.remove("display");
            }
            if (map.containsKey("login_hint")) {
                builder.setLoginHint(map.get("login_hint"));
                map.remove("login_hint");
            }
            if (map.containsKey("prompt")) {
                builder.setPrompt(map.get("prompt"));
                map.remove("prompt");
            }
            if (map.containsKey("state")) {
                builder.setState(map.get("state"));
                map.remove("state");
            }
            if (map.containsKey("nonce")) {
                builder.setNonce(map.get("nonce"));
                map.remove("nonce");
            }
            if (map.containsKey("ui_locales")) {
                builder.setUiLocales(map.get("ui_locales"));
                map.remove("ui_locales");
            }
            builder.setAdditionalParameters(map);
        }
        if (!bool2.booleanValue()) {
            builder.setCodeVerifier(null);
        } else {
            String strGenerateRandomCodeVerifier = CodeVerifierUtil.generateRandomCodeVerifier();
            this.codeVerifier = strGenerateRandomCodeVerifier;
            builder.setCodeVerifier(strGenerateRandomCodeVerifier);
        }
        if (!bool.booleanValue()) {
            builder.setNonce(null);
        }
        AuthorizationRequest authorizationRequestBuild = builder.build();
        AuthorizationService authorizationService = new AuthorizationService(reactApplicationContext, appAuthConfiguration);
        CustomTabsIntent customTabsIntentBuild = authorizationService.createCustomTabsIntentBuilder(new Uri[0]).build();
        if (bool3.booleanValue()) {
            customTabsIntentBuild.intent.putExtra(TrustedWebUtils.EXTRA_LAUNCH_AS_TRUSTED_WEB_ACTIVITY, true);
        }
        currentActivity.startActivityForResult(authorizationService.getAuthorizationRequestIntent(authorizationRequestBuild, customTabsIntentBuild), 52);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshWithConfiguration(AuthorizationServiceConfiguration authorizationServiceConfiguration, AppAuthConfiguration appAuthConfiguration, String str, String str2, ReadableArray readableArray, String str3, Map<String, String> map, String str4, String str5, final Promise promise) {
        String strArrayToString = readableArray != null ? arrayToString(readableArray) : null;
        ReactApplicationContext reactApplicationContext = this.reactContext;
        TokenRequest.Builder redirectUri = new TokenRequest.Builder(authorizationServiceConfiguration, str2).setRefreshToken(str).setRedirectUri(Uri.parse(str3));
        if (strArrayToString != null) {
            redirectUri.setScope(strArrayToString);
        }
        if (!map.isEmpty()) {
            redirectUri.setAdditionalParameters(map);
        }
        TokenRequest tokenRequestBuild = redirectUri.build();
        AuthorizationService authorizationService = new AuthorizationService(reactApplicationContext, appAuthConfiguration);
        AuthorizationService.TokenResponseCallback tokenResponseCallback = new AuthorizationService.TokenResponseCallback() { // from class: com.rnappauth.RNAppAuthModule.8
            @Override // net.openid.appauth.AuthorizationService.TokenResponseCallback
            public void onTokenRequestCompleted(@Nullable TokenResponse tokenResponse, @Nullable AuthorizationException authorizationException) {
                if (tokenResponse != null) {
                    promise.resolve(TokenResponseFactory.tokenResponseToMap(tokenResponse));
                } else {
                    RNAppAuthModule.this.handleAuthorizationException("token_refresh_failed", authorizationException, promise);
                }
            }
        };
        if (str5 != null) {
            authorizationService.performTokenRequest(tokenRequestBuild, getClientAuthentication(str5, str4), tokenResponseCallback);
        } else {
            authorizationService.performTokenRequest(tokenRequestBuild, tokenResponseCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void endSessionWithConfiguration(AuthorizationServiceConfiguration authorizationServiceConfiguration, AppAuthConfiguration appAuthConfiguration, String str, String str2, Map<String, String> map) {
        ReactApplicationContext reactApplicationContext = this.reactContext;
        Activity currentActivity = getCurrentActivity();
        EndSessionRequest.Builder postLogoutRedirectUri = new EndSessionRequest.Builder(authorizationServiceConfiguration).setIdTokenHint(str).setPostLogoutRedirectUri(Uri.parse(str2));
        if (map != null) {
            if (map.containsKey("state")) {
                postLogoutRedirectUri.setState(map.get("state"));
                map.remove("state");
            }
            postLogoutRedirectUri.setAdditionalParameters(map);
        }
        currentActivity.startActivityForResult(new AuthorizationService(reactApplicationContext, appAuthConfiguration).getEndSessionRequestIntent(postLogoutRedirectUri.build()), 53);
    }

    private void parseHeaderMap(ReadableMap readableMap) {
        if (readableMap == null) {
            return;
        }
        if (readableMap.hasKey("register") && readableMap.getType("register") == ReadableType.Map) {
            this.registrationRequestHeaders = MapUtil.readableMapToHashMap(readableMap.getMap("register"));
        }
        if (readableMap.hasKey("authorize") && readableMap.getType("authorize") == ReadableType.Map) {
            this.authorizationRequestHeaders = MapUtil.readableMapToHashMap(readableMap.getMap("authorize"));
        }
        if (readableMap.hasKey(ResponseTypeValues.TOKEN) && readableMap.getType(ResponseTypeValues.TOKEN) == ReadableType.Map) {
            this.tokenRequestHeaders = MapUtil.readableMapToHashMap(readableMap.getMap(ResponseTypeValues.TOKEN));
        }
    }

    private ClientAuthentication getClientAuthentication(String str, String str2) {
        if (str2.equals("post")) {
            return new ClientSecretPost(str);
        }
        return new ClientSecretBasic(str);
    }

    private String arrayToString(ReadableArray readableArray) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < readableArray.size(); i++) {
            if (i != 0) {
                sb.append(' ');
            }
            sb.append(readableArray.getString(i));
        }
        return sb.toString();
    }

    private List<String> arrayToList(ReadableArray readableArray) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < readableArray.size(); i++) {
            arrayList.add(readableArray.getString(i));
        }
        return arrayList;
    }

    private List<Uri> arrayToUriList(ReadableArray readableArray) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < readableArray.size(); i++) {
            arrayList.add(Uri.parse(readableArray.getString(i)));
        }
        return arrayList;
    }

    private AppAuthConfiguration createAppAuthConfiguration(ConnectionBuilder connectionBuilder, Boolean bool, ReadableArray readableArray) {
        return new AppAuthConfiguration.Builder().setBrowserMatcher(getBrowserAllowList(readableArray)).setConnectionBuilder(connectionBuilder).setSkipIssuerHttpsCheck(bool).build();
    }

    private ConnectionBuilder createConnectionBuilder(boolean z, Map<String, String> map, Double d) {
        ConnectionBuilder connectionBuilder;
        if (z) {
            connectionBuilder = UnsafeConnectionBuilder.INSTANCE;
        } else {
            connectionBuilder = DefaultConnectionBuilder.INSTANCE;
        }
        CustomConnectionBuilder customConnectionBuilder = new CustomConnectionBuilder(connectionBuilder);
        if (map != null) {
            customConnectionBuilder.setHeaders(map);
        }
        customConnectionBuilder.setConnectionTimeout(d.intValue());
        return customConnectionBuilder;
    }

    private ConnectionBuilder createConnectionBuilder(boolean z, Map<String, String> map) {
        ConnectionBuilder connectionBuilder;
        if (z) {
            connectionBuilder = UnsafeConnectionBuilder.INSTANCE;
        } else {
            connectionBuilder = DefaultConnectionBuilder.INSTANCE;
        }
        CustomConnectionBuilder customConnectionBuilder = new CustomConnectionBuilder(connectionBuilder);
        if (map != null) {
            customConnectionBuilder.setHeaders(map);
        }
        return customConnectionBuilder;
    }

    private Uri buildConfigurationUriFromIssuer(Uri uri) {
        return uri.buildUpon().appendPath(AuthorizationServiceConfiguration.WELL_KNOWN_PATH).appendPath(AuthorizationServiceConfiguration.OPENID_CONFIGURATION_RESOURCE).build();
    }

    private AuthorizationServiceConfiguration createAuthorizationServiceConfiguration(ReadableMap readableMap) throws Exception {
        if (!readableMap.hasKey("authorizationEndpoint")) {
            throw new Exception("serviceConfiguration passed without an authorizationEndpoint");
        }
        if (!readableMap.hasKey("tokenEndpoint")) {
            throw new Exception("serviceConfiguration passed without a tokenEndpoint");
        }
        return new AuthorizationServiceConfiguration(Uri.parse(readableMap.getString("authorizationEndpoint")), Uri.parse(readableMap.getString("tokenEndpoint")), readableMap.hasKey("registrationEndpoint") ? Uri.parse(readableMap.getString("registrationEndpoint")) : null, readableMap.hasKey("endSessionEndpoint") ? Uri.parse(readableMap.getString("endSessionEndpoint")) : null);
    }

    private void warmChromeCustomTab(Context context, final String str) {
        CustomTabsClient.bindCustomTabsService(context, "com.android.chrome", new CustomTabsServiceConnection() { // from class: com.rnappauth.RNAppAuthModule.9
            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
            }

            @Override // androidx.browser.customtabs.CustomTabsServiceConnection
            public void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
                customTabsClient.warmup(0L);
                CustomTabsSession customTabsSessionNewSession = customTabsClient.newSession(new CustomTabsCallback());
                if (customTabsSessionNewSession == null) {
                    return;
                }
                customTabsSessionNewSession.mayLaunchUrl(Uri.parse(str), null, Collections.emptyList());
            }
        });
    }

    private boolean hasServiceConfiguration(@Nullable String str) {
        return str != null && this.mServiceConfigurations.containsKey(str);
    }

    private AuthorizationServiceConfiguration getServiceConfiguration(@Nullable String str) {
        if (str == null) {
            return null;
        }
        return this.mServiceConfigurations.get(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleAuthorizationException(String str, AuthorizationException authorizationException, Promise promise) {
        if (authorizationException.getLocalizedMessage() == null) {
            promise.reject(str, authorizationException.error, authorizationException);
            return;
        }
        String str2 = authorizationException.error;
        if (str2 != null) {
            str = str2;
        }
        promise.reject(str, authorizationException.getLocalizedMessage(), authorizationException);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setServiceConfiguration(@Nullable String str, AuthorizationServiceConfiguration authorizationServiceConfiguration) {
        if (str != null) {
            this.mServiceConfigurations.put(str, authorizationServiceConfiguration);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:39:0x006e  */
    private BrowserMatcher getBrowserAllowList(ReadableArray readableArray) {
        byte b;
        if (readableArray == null || readableArray.size() == 0) {
            return AnyBrowserMatcher.INSTANCE;
        }
        MutableBrowserAllowList mutableBrowserAllowList = new MutableBrowserAllowList();
        for (int i = 0; i < readableArray.size(); i++) {
            String string = readableArray.getString(i);
            if (string != null) {
                switch (string) {
                    case "chromeCustomTab":
                        b = 0;
                        break;
                    case "chrome":
                        b = 1;
                        break;
                    case "firefox":
                        b = 2;
                        break;
                    case "samsungCustomTab":
                        b = 3;
                        break;
                    case "firefoxCustomTab":
                        b = 4;
                        break;
                    case "samsung":
                        b = 5;
                        break;
                    default:
                        b = -1;
                        break;
                }
                if (b == 0) {
                    mutableBrowserAllowList.add(VersionedBrowserMatcher.CHROME_CUSTOM_TAB);
                } else if (b == 1) {
                    mutableBrowserAllowList.add(VersionedBrowserMatcher.CHROME_BROWSER);
                } else if (b == 2) {
                    mutableBrowserAllowList.add(VersionedBrowserMatcher.FIREFOX_BROWSER);
                } else if (b == 3) {
                    mutableBrowserAllowList.add(VersionedBrowserMatcher.SAMSUNG_CUSTOM_TAB);
                } else if (b == 4) {
                    mutableBrowserAllowList.add(VersionedBrowserMatcher.FIREFOX_CUSTOM_TAB);
                } else if (b == 5) {
                    mutableBrowserAllowList.add(VersionedBrowserMatcher.SAMSUNG_BROWSER);
                }
            }
        }
        return mutableBrowserAllowList;
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "RNAppAuth";
    }
}
