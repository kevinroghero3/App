package net.openid.appauth;

import android.graphics.Color;
import android.media.AudioTrack;
import android.net.Uri;
import android.os.Process;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.annotation.NonNull;
import com.google.common.base.Ascii;
import io.sentry.ProfilingTraceData;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import o.ArtificialStackFrames;
import o._CREATION;
import org.apache.commons.lang3.CharEncoding;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class AuthorizationServiceDiscovery {
    static final JsonUtil.StringListField ACR_VALUES_SUPPORTED;
    static final JsonUtil.UriField AUTHORIZATION_ENDPOINT;
    static final JsonUtil.StringListField CLAIMS_LOCALES_SUPPORTED;
    static final JsonUtil.BooleanField CLAIMS_PARAMETER_SUPPORTED;
    static final JsonUtil.StringListField CLAIMS_SUPPORTED;
    static final JsonUtil.StringListField CLAIM_TYPES_SUPPORTED;
    static final JsonUtil.StringListField DISPLAY_VALUES_SUPPORTED;
    static final JsonUtil.UriField END_SESSION_ENDPOINT;
    static final JsonUtil.StringListField GRANT_TYPES_SUPPORTED;
    static final JsonUtil.StringListField ID_TOKEN_ENCRYPTION_ALG_VALUES_SUPPORTED;
    static final JsonUtil.StringListField ID_TOKEN_ENCRYPTION_ENC_VALUES_SUPPORTED;
    static final JsonUtil.StringListField ID_TOKEN_SIGNING_ALG_VALUES_SUPPORTED;
    static final JsonUtil.StringField ISSUER;
    static final JsonUtil.UriField JWKS_URI;
    private static final List<String> MANDATORY_METADATA;
    static final JsonUtil.UriField OP_POLICY_URI;
    static final JsonUtil.UriField OP_TOS_URI;
    static final JsonUtil.UriField REGISTRATION_ENDPOINT;
    static final JsonUtil.StringListField REQUEST_OBJECT_ENCRYPTION_ALG_VALUES_SUPPORTED;
    static final JsonUtil.StringListField REQUEST_OBJECT_ENCRYPTION_ENC_VALUES_SUPPORTED;
    static final JsonUtil.StringListField REQUEST_OBJECT_SIGNING_ALG_VALUES_SUPPORTED;
    static final JsonUtil.BooleanField REQUEST_PARAMETER_SUPPORTED;
    static final JsonUtil.BooleanField REQUEST_URI_PARAMETER_SUPPORTED;
    static final JsonUtil.BooleanField REQUIRE_REQUEST_URI_REGISTRATION;
    static final JsonUtil.StringListField RESPONSE_MODES_SUPPORTED;
    static final JsonUtil.StringListField RESPONSE_TYPES_SUPPORTED;
    static final JsonUtil.StringListField SCOPES_SUPPORTED;
    static final JsonUtil.UriField SERVICE_DOCUMENTATION;
    static final JsonUtil.StringListField SUBJECT_TYPES_SUPPORTED;
    static final JsonUtil.UriField TOKEN_ENDPOINT;
    static final JsonUtil.StringListField TOKEN_ENDPOINT_AUTH_METHODS_SUPPORTED;
    static final JsonUtil.StringListField TOKEN_ENDPOINT_AUTH_SIGNING_ALG_VALUES_SUPPORTED;
    static final JsonUtil.StringListField UI_LOCALES_SUPPORTED;
    static final JsonUtil.StringListField USERINFO_ENCRYPTION_ALG_VALUES_SUPPORTED;
    static final JsonUtil.StringListField USERINFO_ENCRYPTION_ENC_VALUES_SUPPORTED;
    static final JsonUtil.UriField USERINFO_ENDPOINT;
    static final JsonUtil.StringListField USERINFO_SIGNING_ALG_VALUES_SUPPORTED;
    public final JSONObject docJson;

    static {
        JsonUtil.StringField stringFieldStr = str("issuer");
        ISSUER = stringFieldStr;
        JsonUtil.UriField uriFieldUri = uri("authorization_endpoint");
        AUTHORIZATION_ENDPOINT = uriFieldUri;
        TOKEN_ENDPOINT = uri("token_endpoint");
        END_SESSION_ENDPOINT = uri("end_session_endpoint");
        USERINFO_ENDPOINT = uri("userinfo_endpoint");
        JsonUtil.UriField uriFieldUri2 = uri("jwks_uri");
        JWKS_URI = uriFieldUri2;
        REGISTRATION_ENDPOINT = uri("registration_endpoint");
        SCOPES_SUPPORTED = strList("scopes_supported");
        JsonUtil.StringListField stringListFieldStrList = strList("response_types_supported");
        RESPONSE_TYPES_SUPPORTED = stringListFieldStrList;
        RESPONSE_MODES_SUPPORTED = strList("response_modes_supported");
        GRANT_TYPES_SUPPORTED = strList("grant_types_supported", Arrays.asList(GrantTypeValues.AUTHORIZATION_CODE, GrantTypeValues.IMPLICIT));
        ACR_VALUES_SUPPORTED = strList("acr_values_supported");
        JsonUtil.StringListField stringListFieldStrList2 = strList("subject_types_supported");
        SUBJECT_TYPES_SUPPORTED = stringListFieldStrList2;
        JsonUtil.StringListField stringListFieldStrList3 = strList("id_token_signing_alg_values_supported");
        ID_TOKEN_SIGNING_ALG_VALUES_SUPPORTED = stringListFieldStrList3;
        ID_TOKEN_ENCRYPTION_ALG_VALUES_SUPPORTED = strList("id_token_encryption_enc_values_supported");
        ID_TOKEN_ENCRYPTION_ENC_VALUES_SUPPORTED = strList("id_token_encryption_enc_values_supported");
        USERINFO_SIGNING_ALG_VALUES_SUPPORTED = strList("userinfo_signing_alg_values_supported");
        USERINFO_ENCRYPTION_ALG_VALUES_SUPPORTED = strList("userinfo_encryption_alg_values_supported");
        USERINFO_ENCRYPTION_ENC_VALUES_SUPPORTED = strList("userinfo_encryption_enc_values_supported");
        REQUEST_OBJECT_SIGNING_ALG_VALUES_SUPPORTED = strList("request_object_signing_alg_values_supported");
        REQUEST_OBJECT_ENCRYPTION_ALG_VALUES_SUPPORTED = strList("request_object_encryption_alg_values_supported");
        REQUEST_OBJECT_ENCRYPTION_ENC_VALUES_SUPPORTED = strList("request_object_encryption_enc_values_supported");
        TOKEN_ENDPOINT_AUTH_METHODS_SUPPORTED = strList("token_endpoint_auth_methods_supported", Collections.singletonList(ClientSecretBasic.NAME));
        TOKEN_ENDPOINT_AUTH_SIGNING_ALG_VALUES_SUPPORTED = strList("token_endpoint_auth_signing_alg_values_supported");
        DISPLAY_VALUES_SUPPORTED = strList("display_values_supported");
        CLAIM_TYPES_SUPPORTED = strList("claim_types_supported", Collections.singletonList(ProfilingTraceData.TRUNCATION_REASON_NORMAL));
        CLAIMS_SUPPORTED = strList("claims_supported");
        SERVICE_DOCUMENTATION = uri("service_documentation");
        CLAIMS_LOCALES_SUPPORTED = strList("claims_locales_supported");
        UI_LOCALES_SUPPORTED = strList("ui_locales_supported");
        CLAIMS_PARAMETER_SUPPORTED = bool("claims_parameter_supported", false);
        REQUEST_PARAMETER_SUPPORTED = bool("request_parameter_supported", false);
        REQUEST_URI_PARAMETER_SUPPORTED = bool("request_uri_parameter_supported", true);
        REQUIRE_REQUEST_URI_REGISTRATION = bool("require_request_uri_registration", false);
        OP_POLICY_URI = uri("op_policy_uri");
        OP_TOS_URI = uri("op_tos_uri");
        MANDATORY_METADATA = Arrays.asList(stringFieldStr.key, uriFieldUri.key, uriFieldUri2.key, stringListFieldStrList.key, stringListFieldStrList2.key, stringListFieldStrList3.key);
    }

    public static class MissingArgumentException extends Exception {
        private static long _BOUNDARY;
        private static char[] _CREATION;
        private String mMissingField;
        private static final byte[] $$c = {89, -28, 106, -128};
        private static final int $$d = 36;
        private static int $10 = 0;
        private static int $11 = 1;
        private static final byte[] $$a = {Ascii.FF, 109, 62, -103, 53, 2, -47, -11, -17, 5, -22, -1, 3, Ascii.FF, -11, 8, 0, -17, 52, 8, -19, 19, -53, Ascii.CR, 1};
        private static final int $$b = 255;
        private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
        private static int artificialFrame = 1;

        /* JADX WARN: Code duplicated, block: B:10:0x0025  */
        /* JADX WARN: Code duplicated, block: B:8:0x001f  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x002d). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0025
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        private static java.lang.String $$e(int r6, int r7, byte r8) {
            /*
                byte[] r0 = net.openid.appauth.AuthorizationServiceDiscovery.MissingArgumentException.$$c
                int r6 = r6 + 4
                int r8 = r8 * 3
                int r1 = 1 - r8
                int r7 = 106 - r7
                byte[] r1 = new byte[r1]
                r2 = 0
                int r8 = 0 - r8
                if (r0 != 0) goto L14
                r3 = r6
                r4 = r2
                goto L2d
            L14:
                r3 = r2
                r5 = r7
                r7 = r6
                r6 = r5
            L18:
                byte r4 = (byte) r6
                r1[r3] = r4
                int r7 = r7 + 1
                if (r3 != r8) goto L25
                java.lang.String r6 = new java.lang.String
                r6.<init>(r1, r2)
                return r6
            L25:
                int r3 = r3 + 1
                r4 = r0[r7]
                r5 = r3
                r3 = r7
                r7 = r4
                r4 = r5
            L2d:
                int r7 = -r7
                int r6 = r6 + r7
                r7 = r3
                r3 = r4
                goto L18
            */
            throw new UnsupportedOperationException("Method not decompiled: net.openid.appauth.AuthorizationServiceDiscovery.MissingArgumentException.$$e(int, int, byte):java.lang.String");
        }

        /* JADX WARN: Code duplicated, block: B:10:0x0022  */
        /* JADX WARN: Code duplicated, block: B:8:0x001a  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0022 -> B:11:0x002a). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0022
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        private static void b(byte r6, byte r7, byte r8, java.lang.Object[] r9) {
            /*
                byte[] r0 = net.openid.appauth.AuthorizationServiceDiscovery.MissingArgumentException.$$a
                int r1 = 4 - r7
                int r6 = r6 + 66
                int r8 = r8 + 4
                byte[] r1 = new byte[r1]
                int r7 = 3 - r7
                r2 = 0
                if (r0 != 0) goto L12
                r3 = r8
                r4 = r2
                goto L2a
            L12:
                r3 = r2
            L13:
                int r8 = r8 + 1
                byte r4 = (byte) r6
                r1[r3] = r4
                if (r3 != r7) goto L22
                java.lang.String r6 = new java.lang.String
                r6.<init>(r1, r2)
                r9[r2] = r6
                return
            L22:
                int r3 = r3 + 1
                r4 = r0[r8]
                r5 = r3
                r3 = r8
                r8 = r4
                r4 = r5
            L2a:
                int r8 = -r8
                int r6 = r6 + r8
                int r6 = r6 + (-2)
                r8 = r3
                r3 = r4
                goto L13
            */
            throw new UnsupportedOperationException("Method not decompiled: net.openid.appauth.AuthorizationServiceDiscovery.MissingArgumentException.b(byte, byte, byte, java.lang.Object[]):void");
        }

        private static void a(char c, int i, int i2, Object[] objArr) throws Throwable {
            int i3 = 2 % 2;
            _CREATION _creation = new _CREATION();
            long[] jArr = new long[i2];
            _creation.b = 0;
            while (_creation.b < i2) {
                int i4 = $11 + 35;
                $10 = i4 % 128;
                if (i4 % 2 != 0) {
                    int i5 = _creation.b;
                    try {
                        Object[] objArr2 = {Integer.valueOf(_CREATION[i >>> i5])};
                        Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-587087340);
                        if (objAccessartificialFrame == null) {
                            byte b = (byte) (-1);
                            byte b2 = (byte) (b + 3);
                            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(7 - ((byte) KeyEvent.getModifierMetaStateMask()), (char) ((ViewConfiguration.getDoubleTapTimeout() >> 16) + 9279), (ViewConfiguration.getKeyRepeatDelay() >> 16) + 1977, 1113883676, false, $$e(b, b2, (byte) (b2 - 2)), new Class[]{Integer.TYPE});
                        }
                        Object[] objArr3 = {Long.valueOf(((Long) ((Method) objAccessartificialFrame).invoke(null, objArr2)).longValue()), Long.valueOf(i5), Long.valueOf(_BOUNDARY), Integer.valueOf(c)};
                        Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1715896821);
                        if (objAccessartificialFrame2 == null) {
                            byte b3 = (byte) (-1);
                            byte b4 = (byte) (b3 + 1);
                            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 29, (char) ((android.os.SystemClock.elapsedRealtime() > 0L ? 1 : (android.os.SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 49361), 684 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), -115095555, false, $$e(b3, b4, b4), new Class[]{Long.TYPE, Long.TYPE, Long.TYPE, Integer.TYPE});
                        }
                        jArr[i5] = ((Long) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).longValue();
                        Object[] objArr4 = {_creation, _creation};
                        Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-293902099);
                        if (objAccessartificialFrame3 == null) {
                            byte b5 = (byte) (-1);
                            byte b6 = (byte) (b5 + 4);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(View.MeasureSpec.getMode(0) + 25, (char) (30069 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))), TextUtils.lastIndexOf("", '0') + 817, 1897803493, false, $$e(b5, b6, (byte) (b6 - 3)), new Class[]{Object.class, Object.class});
                        }
                        ((Method) objAccessartificialFrame3).invoke(null, objArr4);
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause == null) {
                            throw th;
                        }
                        throw cause;
                    }
                } else {
                    int i6 = _creation.b;
                    Object[] objArr5 = {Integer.valueOf(_CREATION[i + i6])};
                    Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-587087340);
                    if (objAccessartificialFrame4 == null) {
                        byte b7 = (byte) (-1);
                        byte b8 = (byte) (b7 + 3);
                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(8 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) (9279 - View.resolveSize(0, 0)), 1976 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), 1113883676, false, $$e(b7, b8, (byte) (b8 - 2)), new Class[]{Integer.TYPE});
                    }
                    Object[] objArr6 = {Long.valueOf(((Long) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).longValue()), Long.valueOf(i6), Long.valueOf(_BOUNDARY), Integer.valueOf(c)};
                    Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(1715896821);
                    if (objAccessartificialFrame5 == null) {
                        byte b9 = (byte) (-1);
                        byte b10 = (byte) (b9 + 1);
                        objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(29 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), (char) ((ViewConfiguration.getEdgeSlop() >> 16) + 49362), 684 - Color.alpha(0), -115095555, false, $$e(b9, b10, b10), new Class[]{Long.TYPE, Long.TYPE, Long.TYPE, Integer.TYPE});
                    }
                    jArr[i6] = ((Long) ((Method) objAccessartificialFrame5).invoke(null, objArr6)).longValue();
                    Object[] objArr7 = {_creation, _creation};
                    Object objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-293902099);
                    if (objAccessartificialFrame6 == null) {
                        byte b11 = (byte) (-1);
                        byte b12 = (byte) (b11 + 4);
                        objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(Color.green(0) + 25, (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 30067), ExpandableListView.getPackedPositionChild(0L) + 817, 1897803493, false, $$e(b11, b12, (byte) (b12 - 3)), new Class[]{Object.class, Object.class});
                    }
                    ((Method) objAccessartificialFrame6).invoke(null, objArr7);
                }
            }
            char[] cArr = new char[i2];
            _creation.b = 0;
            while (_creation.b < i2) {
                cArr[_creation.b] = (char) jArr[_creation.b];
                Object[] objArr8 = {_creation, _creation};
                Object objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-293902099);
                if (objAccessartificialFrame7 == null) {
                    byte b13 = (byte) (-1);
                    byte b14 = (byte) (b13 + 4);
                    objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(Gravity.getAbsoluteGravity(0, 0) + 25, (char) ((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 30068), Color.argb(0, 0, 0, 0) + 816, 1897803493, false, $$e(b13, b14, (byte) (b14 - 3)), new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame7).invoke(null, objArr8);
                int i7 = $10 + 53;
                $11 = i7 % 128;
                int i8 = i7 % 2;
            }
            objArr[0] = new String(cArr);
        }

        public MissingArgumentException(String str) {
            super("Missing mandatory configuration field: " + str);
            this.mMissingField = str;
        }

        public String getMissingField() {
            return this.mMissingField;
        }

        static {
            char[] cArr = new char[1959];
            ByteBuffer.wrap("·bÝÊbî÷\u0092\u001cî¡E6p[\u0014à1vÐ\u009bú ÿµ\u0081Ú\u0095oFôd\u0019\u0019®,4ÞYçî\u0082s\u008d\u0098¼-X²dÇ\u0005l&îM\u0084å;Á®½EÁøjo_\u0002;¹\u001e/ÿÂÕyÐì®\u0083º6x\u00adF@\"÷\u0014mË\u0000ß·®*\u008fÁ\u0083tsëN\u0019ÑsyÌ]Y!²]\u000fö\u0098Ãõ§N\u0082Øc5I\u008eL\u001b2t&ÁçZÊ· \u0000\u008eö\u009a\u009c%#\n¶o]\u0016à·w\u0088\u001aä¡Ø7\"Ú\u000ea[ôv\u009b].³µ\u009cXãïÏu0\u0018\u0004¯V2HÙVl¤ó\u0089\u0086û-É³=\u0014\u0092~;Á\u000fTw¿\u001e\u0002¶\u0095\u0088ø¦CÕÕ48\f\u0083\f7Í]dâPw(\u009cA!þ¶ÙÛº`Ôöi\u001bN L56\u0019ÑsnÌ\\Y4²\u0013\u000fã\u0098ÈõäN´ØC5m\u008eP\u001b,t\u001cÁÐZÒ·º\u0000\u008c-eGÍøím\u0097\u0086§;\n¬6Á\u001cz\"ìÄ\u0001ýºå/\u0088@¢\u0019\u008csrÌ\u0016Y5²\u001d\u000fþ\u0098ØõåN\u0094Ø`5D\u008eM\u001b5t\u0010ÁðZì· \u0000\u0088\u009a|÷x@&Ý\u000f6\u000f\u0083ª\u008f\u0096åhZ\fÏ/$\u0007\u0099ä\u000eÂcÿØ\u008eNz£^\u0018W\u008d/â\nWêÌö!º\u0096\u0092\ffabÖ<K\u0015 \u0015\u0015³\u0019ÑsnÌAY$²\u0006\u000fô\u0098ÁõäN\u008aØl5B\u008e\u0010\u001b6t\u0010ÁöZÝ·¬\u0000Ã\u009a{÷H\u0019\u009cstÌ_Y9²\u001d\u000féñ\u0099\u009bg(\u008bB4ý\u001bh~\u0083\\>®©\u009bÄ¾\u007fÞé6\u0004\u0014¿J*nEFð£k\u009c\u0086Â1ú«\u007fÆ\u0013q}ìV\u0007S²ì-\u008fXàóÄm!\u0098\u00023|®R\u0019ÑsnÌAY$²\u0006\u000fô\u0098ÁõäN\u0084Øl5N\u008e\u0010\u001b4t\u001cÁùZÆ·\u0098\u0000 \u009a%÷W@0Ý\u000e6\fóó\u0099L&c³\u0006X$åÖrã\u001fÆ¤¨2Nß`d2ñ\u0014\u009e2+Ô°ÿ]\u0089ê¢p_\u001dSª-73Ü,iÖöä\u0083Ù(¡¶B\u0019ÑsyÌ]Y!²]\u000fÿ\u0098Éõ¦N\u0093Øb5U\u008eZ\u001b)t\r\u0019\u008csrÌ\u0016Y5²\u0007\u000fø\u0098Àõ¯NÈØm5O\u008eL\u001b.\u0019\u0090sxÌYY$²\u0017\u000f¿\u0098Âõ®N\u0092,ÃF\u007fùXl*\u0087\u0003:¬\u00adØÀ°{\u0098ír\u0000A»T.;A\u001fôãoÌ\u0082¯\u0019\u0090sxÌUY\"²\u0001\u000f÷\u0019\u008csrÌ\u0016Y'²\u0000\u000fþ\u0098Èõ¾N\u0085Øq5\u000e\u008eR\u001b;t\u0017ÁáZÕ·¯\u0000\u008e\u009a|÷R@0Ý\u00046\u000ew\u001b\u001dú¢Ô7¬hT\u0002¢½\u0090(þÃÁ~8é\u0002\u0084??O©¦D\u0089ÿËjâ\u0005Ç°`+\rÆqqUë§\u0086\u009a1¶¬ÜGÖò4mB\u0018i³K-¾Ø\u0095sÌîÙ\u0099)41¯8ZpõHo¦\u001a\u008fµó ÃÛ9v\r\u0019\u008esxÌJY$²\u001b\u000fâ\u0098ØõåN\u0095Ø|5S\u008e\u0011\u001b8t\u001dÁºZ×·«\u0000\u008f\u009a}÷@@lÝ\u00066\f\u0083î\u001c\u0098i³Â\u0091\\d©O\u0002\u0016\u009f\u0003èóEëÞâ+®\u0084\u0092\u001e|kUÄ#Q\u0019ø\u0005\u0092ó-Á¸¯S\u0090îiyS\u0014n¯\u001e9÷ÔØo\u009aú³\u0095\u0096 1»\\V á\u0004{ö\u0016Ë¡ç<\u0098×\u0098b>ý^\u0088/#\u0012\u0019\u008esxÌJY$²\u001b\u000fâ\u0098ØõåN\u0095Ø|5S\u008e\u0011\u001b8t\u001dÁºZ×·«\u0000\u008f\u009a}÷@@lÝ\u00136\u0013\u0083µ\u001cÚi´Â\u0093IU#£\u009c\u0091\tÿâÀ_9È\u0003¥>\u001eN\u0088§e\u0088ÞÊKã$Æ\u0091a\n\fçpPTÊ¦§\u009b\u0010·\u008dÈfÈÓnL\u00009m\u0092H\u0019\u008esxÌJY$²\u001b\u000fâ\u0098ØõåN\u0095Ø|5S\u008e\u0011\u001b8t\u001dÁºZ×·«\u0000\u008f\u009a}÷@@lÝ\u00136\u0013\u0083µ\u001cÛi»Â\u0093\u0019\u0088s\u007fÌWY/²\u0001\u000f÷©ØÃd|Cé1\u0002\u0018¿·(ÈE\u00adþ\u008bhy\u0085E>S« \u0019\u0088s\u007fÌWY/²\u0015\u000fä\u0098Éõ¸N\u0092\u009d³÷rH\\Ý$6\u0015\u008bô\u001cÒq¨Ê\u0083\\a<ùV\u0001é!|K\u0097o*\u0094½°\u0019\u009dsuÌJY8²\u001f\u000fø\u0098Ùõ¦\u0019\u008csrÌ\u0016Y'²\u0000\u000fþ\u0098Èõ¾N\u0085Øq5\u000e\u008e[\u001b?t\u000fÁýZÐ·«\u0019\u0088s\u007fÌWY/²J\u000f§\u0098Ü\u0019\u0099sxÌVY2²\u0000\u000fø\u0098Ï8èR\tí'xC\u0093q.\u0089¹¾ÔåoïùL\u0014g\u008e^ä¿[\u0091Îõ%Ç\u0098?\u000f\bbSÙYOú¢Ñ\u0019§\u008c«ã\u008a\u0019\u008csrÌ\u0016Y'²\u0000\u000fþ\u0098Èõ¾N\u0085Øq5\u000e\u008eR\u001b5t\u001dÁñZß\u009fãõ\u0017J=\u0019\u009bspÌMY;²\u0013\u000få\u0098Ãõ¹\u0019¿smÌHYw² \u000fä\u0098Âõ¿N\u008fØh5E\u008e\u001f\u001b<t\u0016ÁæZ\u0093·\u008d\u0000\u0085\u009az÷H@/Ý\u0004\u0011\u0099{UÄzQ\u0003º;\u0007Þ\u0090îýÍF\u0093Ðg=M\u00869\u0013\u001e|*ÉÛRù¿\u009c\bë\u0092HÿnH\u0016Õg>\"\u008b\u0085\u0014¦\u0006\u008flCÓlF\u0015\u00ad-\u0010È\u0087øêÛQ\u0085Çq*[\u0091/\u0004\bk<ÞÍEï¨\u008a\u001fý\u0085^èx_\u0000Âq)4\u009c\u0093\u0003°vºÝöC\u000bl_\u0006¡¹Å,ìÇÀz0í\u001b\u0080o;T\u00ad¤@\u0096\u0019\u0099srÌTY3²\u0014\u000fø\u0098ßõ£\u0019\u0088s\u007fÌWY/²J\u000f§²\u001aØêgÀò¢\u0019\u008c¤r\u0019\u008csrÌ\u0016Y'²\u0000\u000fþ\u0098Èõ¾N\u0085Øq5\u000e\u008e]\u001b(t\u0018ÁúZ×T;>Å\u0081¡\u0014\u008bÿ BTÕu¸\u0019\u0003=\u0095\u009cxæÃíV\u00809»\u0019Ï÷Ú\u009d$\"@·r\\Aá¤v\u008f\u001bï Õæ.Ãì©\u0012\u0016v\u0083UhgÕ\u0098B /Ï\u0094¨\u0002\u0015ï2T0Á^®l\u001b\u0097\u0080§\u0019\u0098shÌTY;²-\u000fé\u0098\u0094õýtª\u001eT¡04\u0013ß!bÞõæ\u0098\u0089#îµEXoãwv\u001b\u0019:¬À7åÚ\u009am¢÷@\u009auS\n9ë\u0086Å\u0013¡ø\u0093EkÒ\\¿w\u0004\u0006\u0092ò\u007fØÄ\u0083Q®>\u008f\u008bi\u0010Eý/J\u0017ÐøöB\u009c£#\u008d¶é]Ûà#w\u0014\u001aO¡E7æÚÍaËôò\u009bÆ.$µ7Xmï\u000euå\u0018Ó¯þ2ßÙÉl%ó\u001f\u0086g-H³\u008bF\u0089íªp\u0089\u0019\u0099sxÌVY2²\u0000\u000fø\u0098ÏõäN\u0081Øj5O\u008eX\u001b6t\u001cÁËZÀ·ª\u0000\u0086\u009a'÷@@'Ý\u000f6\u0019\u0083é\u001cßi¶\u0019\u0099sxÌVY2²\u0000\u000fø\u0098ÏõäN\u0090Øg5O\u008eG\u001bbtOÁäZ\u009c·¸\u0000\u008f\u009ag÷_@zÝW6\f\u0005Õo>Ð\u001bE|®R\u0013¸\u0084ÏéôRÎÄ\")3\u0092\u0014\u0007fh]Ý·F\u0091«ç\u001cþ\u0086<ëS\\8Á\u0002*W\u009f²\u0000\u0094uüÞÎ@*µ\u0005\u001eZ\u0083Pô÷Yä\u0019\u008csrÌ\u0016Y5²\u001d\u000fþ\u0098Øõ§N\u0089Ød5D\u008eZ\u001b(ôi\u009e\u0097!ó´Ð_øâ\u001bu=\u0018G£n5\u0081Ø¢c¿ö\u0091\u0099þ,\u0004·?ZGílwÃ\u001a¤\u00adÎ0êÛþn\u001bñ!\u0084@/g±\u0083D¡ïØ\u0019¿ssÌ\\Y%²\u001d\u000fø\u0098ÈõæN\u009eØ=5\u0016\u0019\u008csrÌ\u0016Y5²\u0007\u000fø\u0098Àõ¯NÈØa5I\u008eL\u001b*t\u0015ÁõZÊ·à\u0000\u0084\u009al\u0019\u008asxÌKY#²_Ë\u0015¡ñ\u001eÓ\u008b¡`ÞÝ`JX'*\u009cJ\nöçÇ\\ÐÉ\u00ad¦Ö\u0013f\u0088Ce#Ò\u001fHù\u0019\u008fsxÌUY\"²\\\u000fù\u0098ÛõåN\u008bØd5I\u008eQ\u001b1t\u001cÁíZÀ\u0019\u008fsxÌUY\"²\\\u000fâ\u0098ÊõåN\u0080Ød5K\u008eZ\u001b\u0005t\u001aÁõZÞ·«\u0000\u009f\u009aiDÌ.;\u0091\u0016\u0004aï\u001fR¡Å\u0089¨¦\u0013É\u0085%h\u0007Ó#F})_\u009c¹\u0007\u0083êä]ÚÇ2çó\u008d\r2i§CLhñ\u009cf½\u000bÑ°õ&TË>p.åA\u008at?\u0084¤¥IÕþ¼d\u0006\t=¾P#kÈg'MM³ò×gô\u008cÜ1?¦\u0019Ë$pVæ¡\u000b\u008c°\u008b%µJÙÿ#d\u0016\u0089P>B¤¨É\u008b~æ\u0019\u008csrÌ\u0016Y8²\u0016\u000fü\u0098\u0082õ©N\u0093Øl5L\u008e[\u001btt\u001fÁýZÝ·©\u0000\u0088\u009az÷W@0Ý\b6\u0012\u0083ï\u0019\u008csrÌ\u0016Y'²\u0000\u000fþ\u0098Èõ¾N\u0085Øq5\u000e\u008e]\u001b/t\u0010ÁøZ×·à\u0000\u008b\u009aa÷I@%Ý\u00046\u000e\u0083ë\u001cÄi¼Â\u009e\\{\u0019\u008csrÌ\u0016Y$²\u000b\u000fâ\u0098Øõ®N\u008bØ+5B\u008eJ\u001b3t\u0015ÁðZ\u009d·¨\u0000\u0084\u009af÷@@'Ý\u00136\f\u0083é\u001cßi»Â\u0084dW\u000e©±Í$ÿÏÐr9å\u0003\u0088u3P¥\u0081H\u009eó\u009cfõ\t\u008c¼-'\u001dÊ|}Zç·\u008aÒ=ÿ ÓKÉþ'a\b\u0014|¿[!¦Ô\u0098\u007füâË½%×Ûh¿ý\u0088\u0016¾«V<aQ\rê=|\u0082\u0091ë*ã¿\u009aÐ¼eYþ4\u0013\u0001¤->ÏSéä\u008eyº\u0092¥'@¸vÍ\u0012f-É\u008c£r\u001c\u0016\u0089!b\u0017ßÿHÈ%¤\u009e\u0094\bZåD^SË1¤\u0014\u0011º\u008aÑg»Ð\u0084Jd'C\u0090l\r\u0007æ\u0015SõÌÑ¹°\u0012\u0082\u008c\u007fyXÒ O\n8÷\u0019Ä\u0019ÑsyÌ]Y!²]\u000fà\u0098Éõ¦N\u0093ØZ5P\u008eV\u001b*t\u001c_ï5G\u008ac\u001f\u001fôcIÜÞý³\u0096\b³\u009e^sjÈ.]\u00062&\u0087Ù\u001cèñ\u0092F²ÜX±}\u0006#\u009b8p'ÅËZñ/\u008f\u0019ÑsyÌ]Y!²]\u000fâ\u0098Ãõ¨N\u008dØ`5T\u008e\u0010\u001b=t\u001cÁúZÊ·ªª¨À\u0000\u007f$êX\u0001$¼\u009b+ºFÑýôk\u0019\u0086-=i¨RÇer\u0080é¿\u0004Ó¨\u008eÂ1}\u001eè{\u0003\u0002¾¿)\u0096DùÿÌi\u0005\u0084\u000b?\u0012ªdÅEp®\u0019ÑsnÌAY$²\u0006\u000fô\u0098ÁõäN\u008aØl5B\u008e\u0010\u001b6t\u0010ÁöZÐ·\u0091\u0000\u0080\u009ai÷K@.Ý\u000e6\u001f\u0083Ä\u001cÒi°Â\u0092\\z©M\u0002\u0016\u009f\u0015èæEóÞÈ+ö\u0084\u0084\u001e}Lñ&Y\u0099}\f\u0001ç}ZÓÍÿ \u009f\u001b\u0099\u008dB`pÛl-ëGCøgm\u001b\u0086g;É¬åÁ\u0085z\u0083ìK\u0001sºh/\u0005\u0019ÑsyÌ]Y!²]\u000fâ\u0098Ãõ¨N\u008dØ`5T\u008e\u0010\u001b8t\nÁàZÕ·¡\u0000\u0081\u009al÷B@0Ý\u0005\u008d\u0095ç*X\u0005Í`&B\u009b°\f\u0085a ÚÎL(¡\u0006\u001aT\u008fràTU²Î\u0095#ù\u0094Ý\u000e*c\fÔjIA¢]\u0017\u00ad\u0088\u00adýûVÚÈ\"=@\u0096~\u000bO\u0019ÑsyÌ]Y!²]\u000fó\u0098ßõ¿N\u0087Øf5C\u008eZa\u0088\u000b ´\u0004!xÊ\u0004wªà\u0086\u008dæ6Ø %M\u000bö\t\u0019ÑsyÌ]Y!²]\u000fó\u0098ßõ¿N\u008bØ`5G\u008eQûÇ\u0091o.K»7PKíåzÉ\u0017©¬\u009f:a×_lL\u0019ÑsyÌ]Y!²]\u000fó\u0098ßõ¿N\u0090Øh5S\u008eX\u0019ÑsyÌ]Y!²]\u000fó\u0098ßõ¿N\u0096Øb5A\u008eV\u001b*t\u001a\u0019ÑsyÌ]Y!²]\u000fó\u0098ßõ¿N¹Øl5M\u008eZ\u001f\u0003u«Ê\u008b_ñ´Á\tl\u009e\u001aóvHCÞ¹3\u009e\u0088\u0082\u001dérÏÇ5\\N±2\u0006G\u009c¸ñÚFòÛÀ0Ú\u0085\"\t\u009dc<Ü\u001aIo¢\u0011\u001fª\u0088\u0089åé^ÎÈ&%\u001b\u009e\u0000\u000b9dwÑ«J\u008b§Ñ\u0010É\u008a%ç\u0019PkÍI&v\u0093¸\f\u0096yýÒÙL1^\u008945\u008b\u0012\u001e`õIHæß\u009d²ü\tÎ\u009f2r\nÉ\u0013\\q\u0019Îs{Ì^Yw²H\u0019ÑsmÌJY8²\u0011\u000f¾\u0098ßõ®N\u008aØc5\u000f\u008eR\u001b;t\tÁç\u0019\u0099soÌYY;²\u001e\u000fþ\u0098ÏõåN\u0081Øj5L\u008e[\u001b<t\u0010ÁçZÛ·à\u0000\u009e\u009agb\\\bº·\u0094\"ÞÉðt\u001aã1\u008eZ5J£¸N\u009aõß`ç\u000fØ\u0019ÑsxÌLY4²]\u000fü\u0098Éõ¯N\u008fØd5\u007f\u008e\\\u001b5t\u001dÁñZÐ·½\u0000Ã\u009ap÷J@.\u0019\u009csqÌMY2²\u0001\u000få\u0098Íõ¨N\u008dØvØ\u0099²0\r\u0004\u0098|s\u0015Î´Y\u008b4ö\u008fÀ\u00199ô\u001b\u0019ÑsyÌYY#²\u0013\u000f¾\u0098Èõ¤N\u0091Øk5L\u008eP\u001b;t\u001dÁçZ\u009c·à\u0000\u0089\u009ax÷\b@#Ý\u00116\f\u0083è\u001c\u0098i\u00adÂ\u009d\\c\u0019ÑsmÌJY8²\u0011\u000f¾\u0098Ïõ»N\u0093Øl5N\u008eY\u001b5\u0019¹srÌTY3²\u0014\u000fø\u0098ßõ£\u0019ÑsyÌYY#²\u0013\u000f¾\u0098Áõ¢N\u0095Øf5\u000f\u008eO\u001b(t\u0016ÁòZÚ·¢\u0000\u0088\u009a{÷\b@!Ý\u00146\u000e\u0083´\u001c\u0086iúÂ\u0093\\`©G\u0002g\u009f\tèêEýÞÏ+·\u0084\u0081\u001e{kCÄ8QEªë\u0007À\u0090\u00adíªF\u0093Ðt-Q".getBytes(CharEncoding.ISO_8859_1)).asCharBuffer().get(cArr, 0, 1959);
            _CREATION = cArr;
            _BOUNDARY = -4207546092461919459L;
        }

        /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
            java.util.NoSuchElementException
            	at java.base/java.util.TreeMap.key(Unknown Source)
            	at java.base/java.util.TreeMap.lastKey(Unknown Source)
            	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
            	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
            	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
            */
        public static java.lang.Object[] CoroutineDebuggingKt(android.content.Context r66, int r67, int r68, int r69) {
            /*
                Method dump skipped, instruction units count: 15286
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: net.openid.appauth.AuthorizationServiceDiscovery.MissingArgumentException.CoroutineDebuggingKt(android.content.Context, int, int, int):java.lang.Object[]");
        }
    }

    public AuthorizationServiceDiscovery(@NonNull JSONObject jSONObject) throws JSONException, MissingArgumentException {
        this.docJson = (JSONObject) Preconditions.checkNotNull(jSONObject);
        for (String str : MANDATORY_METADATA) {
            if (!this.docJson.has(str) || this.docJson.get(str) == null) {
                throw new MissingArgumentException(str);
            }
        }
    }

    private <T> T get(JsonUtil.Field<T> field) {
        return (T) JsonUtil.get(this.docJson, field);
    }

    private <T> List<T> get(JsonUtil.ListField<T> listField) {
        return JsonUtil.get(this.docJson, listField);
    }

    public String getIssuer() {
        return (String) get(ISSUER);
    }

    public Uri getAuthorizationEndpoint() {
        return (Uri) get(AUTHORIZATION_ENDPOINT);
    }

    public Uri getTokenEndpoint() {
        return (Uri) get(TOKEN_ENDPOINT);
    }

    public Uri getEndSessionEndpoint() {
        return (Uri) get(END_SESSION_ENDPOINT);
    }

    public Uri getUserinfoEndpoint() {
        return (Uri) get(USERINFO_ENDPOINT);
    }

    public Uri getJwksUri() {
        return (Uri) get(JWKS_URI);
    }

    public Uri getRegistrationEndpoint() {
        return (Uri) get(REGISTRATION_ENDPOINT);
    }

    public List<String> getScopesSupported() {
        return get(SCOPES_SUPPORTED);
    }

    public List<String> getResponseTypesSupported() {
        return get(RESPONSE_TYPES_SUPPORTED);
    }

    public List<String> getResponseModesSupported() {
        return get(RESPONSE_MODES_SUPPORTED);
    }

    public List<String> getGrantTypesSupported() {
        return get(GRANT_TYPES_SUPPORTED);
    }

    public List<String> getAcrValuesSupported() {
        return get(ACR_VALUES_SUPPORTED);
    }

    public List<String> getSubjectTypesSupported() {
        return get(SUBJECT_TYPES_SUPPORTED);
    }

    public List<String> getIdTokenSigningAlgorithmValuesSupported() {
        return get(ID_TOKEN_SIGNING_ALG_VALUES_SUPPORTED);
    }

    public List<String> getIdTokenEncryptionAlgorithmValuesSupported() {
        return get(ID_TOKEN_ENCRYPTION_ALG_VALUES_SUPPORTED);
    }

    public List<String> getIdTokenEncryptionEncodingValuesSupported() {
        return get(ID_TOKEN_ENCRYPTION_ENC_VALUES_SUPPORTED);
    }

    public List<String> getUserinfoSigningAlgorithmValuesSupported() {
        return get(USERINFO_SIGNING_ALG_VALUES_SUPPORTED);
    }

    public List<String> getUserinfoEncryptionAlgorithmValuesSupported() {
        return get(USERINFO_ENCRYPTION_ALG_VALUES_SUPPORTED);
    }

    public List<String> getUserinfoEncryptionEncodingValuesSupported() {
        return get(USERINFO_ENCRYPTION_ENC_VALUES_SUPPORTED);
    }

    public List<String> getRequestObjectSigningAlgorithmValuesSupported() {
        return get(REQUEST_OBJECT_SIGNING_ALG_VALUES_SUPPORTED);
    }

    public List<String> getRequestObjectEncryptionAlgorithmValuesSupported() {
        return get(REQUEST_OBJECT_ENCRYPTION_ALG_VALUES_SUPPORTED);
    }

    public List<String> getRequestObjectEncryptionEncodingValuesSupported() {
        return get(REQUEST_OBJECT_ENCRYPTION_ENC_VALUES_SUPPORTED);
    }

    public List<String> getTokenEndpointAuthMethodsSupported() {
        return get(TOKEN_ENDPOINT_AUTH_METHODS_SUPPORTED);
    }

    public List<String> getTokenEndpointAuthSigningAlgorithmValuesSupported() {
        return get(TOKEN_ENDPOINT_AUTH_SIGNING_ALG_VALUES_SUPPORTED);
    }

    public List<String> getDisplayValuesSupported() {
        return get(DISPLAY_VALUES_SUPPORTED);
    }

    public List<String> getClaimTypesSupported() {
        return get(CLAIM_TYPES_SUPPORTED);
    }

    public List<String> getClaimsSupported() {
        return get(CLAIMS_SUPPORTED);
    }

    public Uri getServiceDocumentation() {
        return (Uri) get(SERVICE_DOCUMENTATION);
    }

    public List<String> getClaimsLocalesSupported() {
        return get(CLAIMS_LOCALES_SUPPORTED);
    }

    public List<String> getUiLocalesSupported() {
        return get(UI_LOCALES_SUPPORTED);
    }

    public boolean isClaimsParameterSupported() {
        return ((Boolean) get(CLAIMS_PARAMETER_SUPPORTED)).booleanValue();
    }

    public boolean isRequestParameterSupported() {
        return ((Boolean) get(REQUEST_PARAMETER_SUPPORTED)).booleanValue();
    }

    public boolean isRequestUriParameterSupported() {
        return ((Boolean) get(REQUEST_URI_PARAMETER_SUPPORTED)).booleanValue();
    }

    public boolean requireRequestUriRegistration() {
        return ((Boolean) get(REQUIRE_REQUEST_URI_REGISTRATION)).booleanValue();
    }

    public Uri getOpPolicyUri() {
        return (Uri) get(OP_POLICY_URI);
    }

    public Uri getOpTosUri() {
        return (Uri) get(OP_TOS_URI);
    }

    private static JsonUtil.StringField str(String str) {
        return new JsonUtil.StringField(str);
    }

    private static JsonUtil.UriField uri(String str) {
        return new JsonUtil.UriField(str);
    }

    private static JsonUtil.StringListField strList(String str) {
        return new JsonUtil.StringListField(str);
    }

    private static JsonUtil.StringListField strList(String str, List<String> list) {
        return new JsonUtil.StringListField(str, list);
    }

    private static JsonUtil.BooleanField bool(String str, boolean z) {
        return new JsonUtil.BooleanField(str, z);
    }
}
