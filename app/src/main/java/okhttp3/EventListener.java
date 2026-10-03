package okhttp3;

import android.graphics.Color;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.core.view.ViewCompat;
import ch.qos.logback.core.net.SyslogConstants;
import com.facebook.imageutils.JfifUtil;
import com.google.common.base.Ascii;
import com.google.crypto.tink.proto.JwtEcdsaAlgorithm;
import com.salesforce.marketingcloud.analytics.stats.b;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o.ArtificialStackFrames;
import o.onRelationshipValidationResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public abstract class EventListener {
    public static final Companion Companion = new Companion(null);
    public static final EventListener NONE = new EventListener() { // from class: okhttp3.EventListener$Companion$NONE$1
    };

    public interface Factory {
        EventListener create(@NotNull Call call);
    }

    public void callEnd(@NotNull Call call) {
        Intrinsics.checkParameterIsNotNull(call, "call");
    }

    public void callFailed(@NotNull Call call, @NotNull IOException ioe) {
        Intrinsics.checkParameterIsNotNull(call, "call");
        Intrinsics.checkParameterIsNotNull(ioe, "ioe");
    }

    public void callStart(@NotNull Call call) {
        Intrinsics.checkParameterIsNotNull(call, "call");
    }

    public void canceled(@NotNull Call call) {
        Intrinsics.checkParameterIsNotNull(call, "call");
    }

    public void connectEnd(@NotNull Call call, @NotNull InetSocketAddress inetSocketAddress, @NotNull Proxy proxy, @Nullable Protocol protocol) {
        Intrinsics.checkParameterIsNotNull(call, "call");
        Intrinsics.checkParameterIsNotNull(inetSocketAddress, "inetSocketAddress");
        Intrinsics.checkParameterIsNotNull(proxy, "proxy");
    }

    public void connectFailed(@NotNull Call call, @NotNull InetSocketAddress inetSocketAddress, @NotNull Proxy proxy, @Nullable Protocol protocol, @NotNull IOException ioe) {
        Intrinsics.checkParameterIsNotNull(call, "call");
        Intrinsics.checkParameterIsNotNull(inetSocketAddress, "inetSocketAddress");
        Intrinsics.checkParameterIsNotNull(proxy, "proxy");
        Intrinsics.checkParameterIsNotNull(ioe, "ioe");
    }

    public void connectStart(@NotNull Call call, @NotNull InetSocketAddress inetSocketAddress, @NotNull Proxy proxy) {
        Intrinsics.checkParameterIsNotNull(call, "call");
        Intrinsics.checkParameterIsNotNull(inetSocketAddress, "inetSocketAddress");
        Intrinsics.checkParameterIsNotNull(proxy, "proxy");
    }

    public void connectionAcquired(@NotNull Call call, @NotNull Connection connection) {
        Intrinsics.checkParameterIsNotNull(call, "call");
        Intrinsics.checkParameterIsNotNull(connection, "connection");
    }

    public void connectionReleased(@NotNull Call call, @NotNull Connection connection) {
        Intrinsics.checkParameterIsNotNull(call, "call");
        Intrinsics.checkParameterIsNotNull(connection, "connection");
    }

    public void dnsEnd(@NotNull Call call, @NotNull String domainName, @NotNull List<InetAddress> inetAddressList) {
        Intrinsics.checkParameterIsNotNull(call, "call");
        Intrinsics.checkParameterIsNotNull(domainName, "domainName");
        Intrinsics.checkParameterIsNotNull(inetAddressList, "inetAddressList");
    }

    public void dnsStart(@NotNull Call call, @NotNull String domainName) {
        Intrinsics.checkParameterIsNotNull(call, "call");
        Intrinsics.checkParameterIsNotNull(domainName, "domainName");
    }

    public void proxySelectEnd(@NotNull Call call, @NotNull HttpUrl url, @NotNull List<Proxy> proxies) {
        Intrinsics.checkParameterIsNotNull(call, "call");
        Intrinsics.checkParameterIsNotNull(url, "url");
        Intrinsics.checkParameterIsNotNull(proxies, "proxies");
    }

    public void proxySelectStart(@NotNull Call call, @NotNull HttpUrl url) {
        Intrinsics.checkParameterIsNotNull(call, "call");
        Intrinsics.checkParameterIsNotNull(url, "url");
    }

    public void requestBodyEnd(@NotNull Call call, long j) {
        Intrinsics.checkParameterIsNotNull(call, "call");
    }

    public void requestBodyStart(@NotNull Call call) {
        Intrinsics.checkParameterIsNotNull(call, "call");
    }

    public void requestFailed(@NotNull Call call, @NotNull IOException ioe) {
        Intrinsics.checkParameterIsNotNull(call, "call");
        Intrinsics.checkParameterIsNotNull(ioe, "ioe");
    }

    public void requestHeadersEnd(@NotNull Call call, @NotNull Request request) {
        Intrinsics.checkParameterIsNotNull(call, "call");
        Intrinsics.checkParameterIsNotNull(request, "request");
    }

    public void requestHeadersStart(@NotNull Call call) {
        Intrinsics.checkParameterIsNotNull(call, "call");
    }

    public void responseBodyEnd(@NotNull Call call, long j) {
        Intrinsics.checkParameterIsNotNull(call, "call");
    }

    public void responseBodyStart(@NotNull Call call) {
        Intrinsics.checkParameterIsNotNull(call, "call");
    }

    public void responseFailed(@NotNull Call call, @NotNull IOException ioe) {
        Intrinsics.checkParameterIsNotNull(call, "call");
        Intrinsics.checkParameterIsNotNull(ioe, "ioe");
    }

    public void responseHeadersEnd(@NotNull Call call, @NotNull Response response) {
        Intrinsics.checkParameterIsNotNull(call, "call");
        Intrinsics.checkParameterIsNotNull(response, "response");
    }

    public void responseHeadersStart(@NotNull Call call) {
        Intrinsics.checkParameterIsNotNull(call, "call");
    }

    public void secureConnectEnd(@NotNull Call call, @Nullable Handshake handshake) {
        Intrinsics.checkParameterIsNotNull(call, "call");
    }

    public void secureConnectStart(@NotNull Call call) {
        Intrinsics.checkParameterIsNotNull(call, "call");
    }

    /* JADX INFO: loaded from: classes3.dex */
    public static final class Companion {
        private static final byte[] $$c = {122, -14, -75, -84};
        private static final int $$d = 196;
        private static int $10 = 0;
        private static int $11 = 1;
        private static final byte[] $$a = {110, 48, -111, -89, Ascii.VT, 2, -12};
        private static final int $$b = 157;
        private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
        private static int artificialFrame = 1;
        private static long onPostMessage = -8874134911166559476L;

        private static String $$e(short s, int i, int i2) {
            byte[] bArr = $$c;
            int i3 = (i2 * 2) + b.f40o;
            int i4 = i * 4;
            int i5 = 4 - (s * 2);
            byte[] bArr2 = new byte[i4 + 1];
            int i6 = -1;
            if (bArr == null) {
                i3 = i5 + i3;
                i5++;
            }
            while (true) {
                i6++;
                bArr2[i6] = (byte) i3;
                if (i6 == i4) {
                    return new String(bArr2, 0);
                }
                int i7 = i3;
                int i8 = i5 + 1;
                i3 = i7 + bArr[i5];
                i5 = i8;
            }
        }

        /* JADX WARN: Code duplicated, block: B:10:0x0027  */
        /* JADX WARN: Code duplicated, block: B:8:0x001f  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x002c). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0027
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        private static void b(int r7, byte r8, int r9, java.lang.Object[] r10) {
            /*
                int r8 = r8 + 4
                int r7 = r7 * 4
                int r7 = r7 + 109
                int r9 = r9 * 4
                int r9 = 4 - r9
                byte[] r0 = okhttp3.EventListener.Companion.$$a
                byte[] r1 = new byte[r9]
                r2 = 0
                if (r0 != 0) goto L15
                r7 = r8
                r3 = r9
                r4 = r2
                goto L2c
            L15:
                r3 = r2
            L16:
                int r8 = r8 + 1
                int r4 = r3 + 1
                byte r5 = (byte) r7
                r1[r3] = r5
                if (r4 != r9) goto L27
                java.lang.String r7 = new java.lang.String
                r7.<init>(r1, r2)
                r10[r2] = r7
                return
            L27:
                r3 = r0[r8]
                r6 = r8
                r8 = r7
                r7 = r6
            L2c:
                int r8 = r8 + r3
                int r8 = r8 + (-3)
                r3 = r4
                r6 = r8
                r8 = r7
                r7 = r6
                goto L16
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.EventListener.Companion.b(int, byte, int, java.lang.Object[]):void");
        }

        private static void a(int i, char[] cArr, Object[] objArr) throws Throwable {
            int i2 = 2 % 2;
            onRelationshipValidationResult onrelationshipvalidationresult = new onRelationshipValidationResult();
            char[] cArrAccessartificialFrame = onRelationshipValidationResult.accessartificialFrame(onPostMessage ^ 2573525503365829440L, cArr, i);
            onrelationshipvalidationresult.e = 4;
            while (onrelationshipvalidationresult.e < cArrAccessartificialFrame.length) {
                int i3 = $11 + 83;
                $10 = i3 % 128;
                int i4 = i3 % 2;
                onrelationshipvalidationresult.d = onrelationshipvalidationresult.e - 4;
                int i5 = onrelationshipvalidationresult.e;
                try {
                    Object[] objArr2 = {Long.valueOf(cArrAccessartificialFrame[onrelationshipvalidationresult.e] ^ cArrAccessartificialFrame[onrelationshipvalidationresult.e % 4]), Long.valueOf(onrelationshipvalidationresult.d), Long.valueOf(onPostMessage)};
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(797310229);
                    if (objAccessartificialFrame == null) {
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(TextUtils.getOffsetAfter("", 0) + 27, (char) ((ViewConfiguration.getPressedStateDuration() >> 16) + 30690), Gravity.getAbsoluteGravity(0, 0) + 188, -1327449315, false, "k", new Class[]{Long.TYPE, Long.TYPE, Long.TYPE});
                    }
                    cArrAccessartificialFrame[i5] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                    Object[] objArr3 = {onrelationshipvalidationresult, onrelationshipvalidationresult};
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(321542193);
                    if (objAccessartificialFrame2 == null) {
                        byte b = (byte) 0;
                        byte b2 = b;
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(TextUtils.getOffsetBefore("", 0) + 33, (char) (ViewConfiguration.getFadingEdgeLength() >> 16), (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 1483, -1940971975, false, $$e(b, b2, b2), new Class[]{Object.class, Object.class});
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
            int i6 = $11 + 99;
            $10 = i6 % 128;
            int i7 = i6 % 2;
            objArr[0] = str;
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Code duplicated, block: B:100:0x0601 A[Catch: Exception -> 0x0778, TRY_LEAVE, TryCatch #3 {Exception -> 0x0778, blocks: (B:87:0x05c3, B:90:0x05ec, B:92:0x05f3, B:100:0x0601, B:102:0x062a, B:105:0x063f, B:107:0x0662, B:109:0x0688, B:114:0x075e, B:115:0x0764, B:118:0x0771, B:119:0x0777, B:98:0x05fb, B:101:0x060b, B:108:0x066c), top: B:144:0x05c3, inners: #0, #5 }] */
        /* JADX WARN: Code duplicated, block: B:105:0x063f A[Catch: Exception -> 0x0778, TRY_ENTER, TryCatch #3 {Exception -> 0x0778, blocks: (B:87:0x05c3, B:90:0x05ec, B:92:0x05f3, B:100:0x0601, B:102:0x062a, B:105:0x063f, B:107:0x0662, B:109:0x0688, B:114:0x075e, B:115:0x0764, B:118:0x0771, B:119:0x0777, B:98:0x05fb, B:101:0x060b, B:108:0x066c), top: B:144:0x05c3, inners: #0, #5 }] */
        /* JADX WARN: Code duplicated, block: B:107:0x0662 A[Catch: Exception -> 0x0778, TRY_LEAVE, TryCatch #3 {Exception -> 0x0778, blocks: (B:87:0x05c3, B:90:0x05ec, B:92:0x05f3, B:100:0x0601, B:102:0x062a, B:105:0x063f, B:107:0x0662, B:109:0x0688, B:114:0x075e, B:115:0x0764, B:118:0x0771, B:119:0x0777, B:98:0x05fb, B:101:0x060b, B:108:0x066c), top: B:144:0x05c3, inners: #0, #5 }] */
        /* JADX WARN: Code duplicated, block: B:111:0x0690 A[ADDED_TO_REGION] */
        /* JADX WARN: Code duplicated, block: B:116:0x0765  */
        /* JADX WARN: Code duplicated, block: B:122:0x07b8  */
        /* JADX WARN: Code duplicated, block: B:123:0x07c9  */
        /* JADX WARN: Code duplicated, block: B:126:0x0829  */
        /* JADX WARN: Code duplicated, block: B:127:0x084a  */
        /* JADX WARN: Code duplicated, block: B:90:0x05ec A[Catch: Exception -> 0x0778, TRY_ENTER, TRY_LEAVE, TryCatch #3 {Exception -> 0x0778, blocks: (B:87:0x05c3, B:90:0x05ec, B:92:0x05f3, B:100:0x0601, B:102:0x062a, B:105:0x063f, B:107:0x0662, B:109:0x0688, B:114:0x075e, B:115:0x0764, B:118:0x0771, B:119:0x0777, B:98:0x05fb, B:101:0x060b, B:108:0x066c), top: B:144:0x05c3, inners: #0, #5 }] */
        /* JADX WARN: Code duplicated, block: B:98:0x05fb A[Catch: Exception -> 0x0778, TRY_ENTER, TryCatch #3 {Exception -> 0x0778, blocks: (B:87:0x05c3, B:90:0x05ec, B:92:0x05f3, B:100:0x0601, B:102:0x062a, B:105:0x063f, B:107:0x0662, B:109:0x0688, B:114:0x075e, B:115:0x0764, B:118:0x0771, B:119:0x0777, B:98:0x05fb, B:101:0x060b, B:108:0x066c), top: B:144:0x05c3, inners: #0, #5 }] */
        public static Object[] coroutineCreation(int i, int i2) throws Throwable {
            Object[] objArr;
            char c;
            Object[] objArr2;
            String str;
            int i3;
            int i4;
            int i5;
            int i6;
            int i7;
            int i8;
            int iITrustedWebActivityCallbackStub;
            int i9;
            int i10;
            int i11;
            int i12;
            int i13;
            File file;
            int i14;
            FileReader fileReader;
            BufferedReader bufferedReader;
            boolean zEquals;
            File file2;
            FileReader fileReader2;
            BufferedReader bufferedReader2;
            boolean zEquals2;
            int i15;
            int i16;
            int i17;
            int i18;
            int i19 = 2 % 2;
            int i20 = artificialFrame;
            int i21 = (i20 & 45) + (i20 | 45);
            getARTIFICIAL_FRAME_PACKAGE_NAME = i21 % 128;
            int i22 = i21 % 2;
            try {
                String[] strArr = new String[2];
                Object[] objArr3 = new Object[1];
                a(TextUtils.indexOf("", "", 0), new char[]{30729, 31807, 30816, 25600, 36109, 2668, 48593, 17133, 6491, 1334, 7330, 40991, 47628, 42721, 32694, 327, 23543, 18317, 55616, 26235, 64701, 57686, 14385}, objArr3);
                strArr[0] = (String) objArr3[0];
                int i23 = getARTIFICIAL_FRAME_PACKAGE_NAME + 125;
                artificialFrame = i23 % 128;
                int i24 = i23 % 2;
                int i25 = -Color.rgb(0, 0, 0);
                Object[] objArr4 = new Object[1];
                a(((i25 | ViewCompat.MEASURED_STATE_MASK) << 1) - (i25 ^ ViewCompat.MEASURED_STATE_MASK), new char[]{28684, 861, 28795, 7024, 27475, 50156, 23458, 35708, 4437, 31311, 64252, 27070, 45571, 55683, 39407, 51405, 21502, 14580, 16156, 45055, 62633, 40483}, objArr4);
                strArr[1] = (String) objArr4[0];
                int i26 = 0;
                while (true) {
                    if (i26 >= 2) {
                        objArr = new Object[4];
                        int[] iArr = new int[1];
                        objArr[0] = iArr;
                        int[] iArr2 = new int[1];
                        objArr[1] = iArr2;
                        objArr[2] = new int[1];
                        int i27 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                        int i28 = (i27 ^ 117) + ((i27 & 117) << 1);
                        int i29 = i28 % 128;
                        artificialFrame = i29;
                        if (i28 % 2 == 0) {
                            iArr2[1] = i;
                            iArr2[0] = i;
                        } else {
                            iArr[0] = i;
                            iArr2[0] = i;
                        }
                        int i30 = i29 + 35;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i30 % 128;
                        int i31 = i30 % 2;
                        objArr[3] = null;
                        int iMaxMemory = (int) Runtime.getRuntime().maxMemory();
                        int i32 = ~iMaxMemory;
                        int i33 = (-1220588379) + (((~((-73435519) | i32)) | (~(iMaxMemory | 905188256))) * 333) + (((~(iMaxMemory | (-73435519))) | (~(i32 | 905188256))) * 333);
                        int i34 = i33 * 434;
                        int i35 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                        int i36 = i35 + 69;
                        artificialFrame = i36 % 128;
                        if (i36 % 2 == 0) {
                            int i37 = ~i;
                            int i38 = i34 / (432 - (~(~((i37 | ((-1) ^ i37)) | i33))));
                            int i39 = ~i33;
                            int i40 = ~((i39 & i) | (i39 ^ i));
                            i15 = (i38 - (~((-433) - (i40 | ((-1) ^ i40))))) - 1;
                        } else {
                            int i41 = ~i;
                            int i42 = i41 | ((-1) ^ i41);
                            int i43 = i34 + ((~((i42 & i33) | (i42 ^ i33))) * 433);
                            int i44 = ~i33;
                            int i45 = ~((i44 & i) | (i44 ^ i));
                            int i46 = -(-((i45 | ((-1) ^ i45)) * (-433)));
                            i15 = ((i43 | i46) << 1) - (i43 ^ i46);
                        }
                        int i47 = ((i35 | 53) << 1) - (i35 ^ 53);
                        artificialFrame = i47 % 128;
                        if (i47 % 2 == 0) {
                            int i48 = ~(((-1) ^ i) | i);
                            int i49 = ~i33;
                            int i50 = -(-(433 % ((i48 & i49) | (i48 ^ i49))));
                            int i51 = i2 * ((i15 & i50) + (i15 | i50));
                            int i52 = i51 / 47;
                            i16 = ((~i51) & i52) | ((~i52) & i51);
                        } else {
                            int i53 = -(-(i15 + (433 * ((~(((-1) ^ i) | i)) | (~i33)))));
                            int i54 = (i2 & i53) + (i53 | i2);
                            int i55 = i54 << 13;
                            i16 = (i55 | i54) & (~(i54 & i55));
                        }
                        int i56 = i16 >>> 17;
                        int i57 = (i16 | i56) & (~(i16 & i56));
                        int i58 = i57 << 5;
                        ((int[]) objArr[2])[0] = (i57 | i58) & (~(i57 & i58));
                        i17 = (i35 ^ 21) + ((i35 & 21) << 1);
                        break;
                    }
                    int i59 = artificialFrame;
                    int i60 = (i59 ^ 75) + ((i59 & 75) << 1);
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i60 % 128;
                    int i61 = i60 % 2;
                    String str2 = strArr[i26];
                    int windowTouchSlop = ViewConfiguration.getWindowTouchSlop();
                    int i62 = getARTIFICIAL_FRAME_PACKAGE_NAME + 29;
                    artificialFrame = i62 % 128;
                    int i63 = i62 % 2;
                    Object[] objArr5 = new Object[1];
                    a(windowTouchSlop >> 8, new char[]{62614, 49993, 62711, 56171, 27373, 3479, 23057, 17665, 38345, 47708, 64321, 42925, 13977, 6550, 38971, 1687, 55139, 63735, 16048, 24964}, objArr5);
                    Class<?> cls = Class.forName((String) objArr5[0]);
                    if (((Boolean) cls.getMethod(str2, new Class[0]).invoke(cls, null)).booleanValue()) {
                        int i64 = artificialFrame + 95;
                        int i65 = i64 % 128;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i65;
                        int i66 = i64 % 2;
                        int i67 = ~i;
                        int i68 = (i & (-2)) | (i67 & 1);
                        objArr = new Object[4];
                        objArr[0] = new int[]{i};
                        int[] iArr3 = new int[1];
                        objArr[1] = iArr3;
                        objArr[2] = new int[1];
                        int i69 = i65 + 77;
                        artificialFrame = i69 % 128;
                        int i70 = i69 % 2;
                        iArr3[0] = i68;
                        objArr[3] = null;
                        int i71 = i65 + 55;
                        artificialFrame = i71 % 128;
                        if (i71 % 2 == 0) {
                            int iMyTid = Process.myTid();
                            i18 = (((69164090 + (((~(66311298 | iMyTid)) | 872417308) * (-140))) + ((~(938728606 | iMyTid)) * 70)) + (((~(iMyTid | 912312476)) | 898833438) * 70)) << 16;
                        } else {
                            int i72 = (-921507573) + (((~((-474983342) | i67)) | (~((-503640434) | i))) * JfifUtil.MARKER_EOI) + (((~((-474983342) | i)) | 470065441) * JfifUtil.MARKER_EOI) + (((~((-503640434) | i67)) | 474983341) * JfifUtil.MARKER_EOI);
                            i18 = (i72 & 16) + (i72 | 16);
                        }
                        int i73 = -(-i18);
                        int i74 = ((i2 | i73) << 1) - (i73 ^ i2);
                        int i75 = i74 << 13;
                        int i76 = (i75 & (~i74)) | ((~i75) & i74);
                        int i77 = i76 >>> 17;
                        int i78 = ((~i76) & i77) | ((~i77) & i76);
                        int i79 = i78 << 5;
                        ((int[]) objArr[2])[0] = ((~i78) & i79) | ((~i79) & i78);
                        i17 = getARTIFICIAL_FRAME_PACKAGE_NAME + 119;
                        break;
                    }
                    i26 = ((i26 | 1) << 1) - (i26 ^ 1);
                    int i80 = artificialFrame + 25;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i80 % 128;
                    int i81 = i80 % 2;
                }
                artificialFrame = i17 % 128;
                int i82 = i17 % 2;
            } catch (Exception unused) {
                objArr = new Object[]{new int[]{i}, new int[]{(i & (-3)) | ((~i) & 2)}, new int[]{(i | i) & (~(i & i))}, null};
                int i83 = i2 + 788813806 + (((~(i | 918389942)) | (-60233833)) * (-668)) + ((918389942 | (~((-60233833) | i))) * 1336) + (((-16914505) | i) * 668) + 16;
                int i84 = i83 ^ (i83 << 13);
                int i85 = i84 >>> 17;
                int i86 = (i84 | i85) & (~(i84 & i85));
                int i87 = i86 << 5;
            }
            if (i != ((int[]) objArr[1])[0]) {
                return objArr;
            }
            try {
                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(590025679);
                if (objAccessartificialFrame == null) {
                    int iLastIndexOf = TextUtils.lastIndexOf("", '0') + 10;
                    char absoluteGravity = (char) (Gravity.getAbsoluteGravity(0, 0) + 64610);
                    int defaultSize = 1806 - View.getDefaultSize(0, 0);
                    byte b = (byte) 0;
                    byte b2 = (byte) (b - 1);
                    Object[] objArr6 = new Object[1];
                    b(b, b2, (byte) (b2 + 1), objArr6);
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(iLastIndexOf, absoluteGravity, defaultSize, -1135716921, false, (String) objArr6[0], new Class[0]);
                }
                long jLongValue = ((Long) ((Method) objAccessartificialFrame).invoke(null, null)).longValue();
                int i88 = getARTIFICIAL_FRAME_PACKAGE_NAME + 47;
                int i89 = i88 % 128;
                artificialFrame = i89;
                int i90 = i88 % 2;
                long j = -1327647728;
                long j2 = (((long) 465) * j) + (((long) (-463)) * jLongValue);
                long j3 = 464;
                long j4 = -1;
                long j5 = jLongValue ^ j4;
                long j6 = i;
                long j7 = j6 ^ j4;
                long j8 = (j5 | j) ^ j4;
                long j9 = j2 + ((((j5 | j7) ^ j4) | j8 | ((j7 | j) ^ j4)) * j3) + (((long) (-464)) * (j6 | (j ^ j4) | j5)) + (j3 * (j8 | ((j | j6) ^ j4))) + ((long) 1667855762);
                int i91 = (int) (j9 >> 32);
                int i92 = 1169697140 + (((~(2099175864 | i)) | (-758565021)) * (-366)) + (((~((-2099205) | i)) | 1342710048) * 366);
                int i93 = (i89 ^ 27) + ((i89 & 27) << 1);
                getARTIFICIAL_FRAME_PACKAGE_NAME = i93 % 128;
                if (i93 % 2 != 0) {
                    Object obj = null;
                    obj.hashCode();
                    throw null;
                }
                int i94 = i91 & i92;
                int i95 = ~((-42057763) | i);
                int i96 = ~i;
                int i97 = ((int) j9) & ((-672400046) + ((i95 | (~((-620898833) | i96))) * 497) + (((~(2100183004 | i96)) | (-2142240767) | (~((-620898833) | i))) * 497));
                if (((i94 & i97) | (i94 ^ i97)) == 1) {
                    int i98 = ((i89 | 87) << 1) - (i89 ^ 87);
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i98 % 128;
                    int i99 = i98 % 2;
                    int i100 = ~i;
                    Object[] objArr7 = {new int[]{i}, new int[]{(i & (-11)) | (i100 & 10)}, new int[1], null};
                    int i101 = 1267469710 + (((~((-995840104) | i100)) | 17216328) * (-933)) + (((~(17216328 | i100)) | (-996143984)) * 933) + 283520040;
                    int i102 = (i101 ^ 16) + ((i101 & 16) << 1);
                    int iITrustedWebActivityCallbackStub2 = JwtEcdsaAlgorithm.AnonymousClass1.ITrustedWebActivityCallbackStub();
                    int i103 = ((i102 * 193) - (~(-(-(i2 * 193))))) - 1;
                    int i104 = ~iITrustedWebActivityCallbackStub2;
                    int i105 = ~i102;
                    int i106 = ~(i105 | i2);
                    int i107 = (i103 - (~(-(-(((i106 & i104) | (i104 ^ i106)) * (-192)))))) - 1;
                    int i108 = ~i2;
                    int i109 = -(-(((~((i105 & i108) | (i105 ^ i108))) | (~((i108 ^ i104) | (i108 & i104)))) * (-384)));
                    int i110 = ((i107 | i109) << 1) - (i107 ^ i109);
                    int i111 = (~i102) | i108;
                    int i112 = ~((i111 & iITrustedWebActivityCallbackStub2) | (i111 ^ iITrustedWebActivityCallbackStub2));
                    int i113 = ~i2;
                    int i114 = (~((i104 & i113) | (i113 ^ i104) | i102)) | i112;
                    int i115 = (i102 & i2) | (i102 ^ i2);
                    int i116 = ~((i115 & iITrustedWebActivityCallbackStub2) | (i115 ^ iITrustedWebActivityCallbackStub2));
                    int i117 = (i110 - (~(-(-(((i116 & i114) | (i114 ^ i116)) * JfifUtil.MARKER_SOFn))))) - 1;
                    int i118 = i117 << 13;
                    int i119 = (i118 | i117) & (~(i117 & i118));
                    int i120 = i119 ^ (i119 >>> 17);
                    ((int[]) objArr7[2])[0] = i120 ^ (i120 << 5);
                    objArr2 = objArr7;
                    c = 0;
                } else {
                    Object[] objArr8 = {new int[]{i}, new int[]{i}, new int[1], null};
                    int i121 = ~((int) SystemClock.elapsedRealtime());
                    int i122 = ((((~((-374339465) | i121)) | 67413376) * (-241)) - 491498008) + (((~(i121 | (-306926089))) | 536870934) * 241);
                    int i123 = -(-(i122 * (-69)));
                    int i124 = -(-((~((i122 ^ i) | (i122 & i))) * (-140)));
                    int i125 = (i123 ^ i124) + ((i123 & i124) << 1) + ((~((i122 ^ i) | (i122 & i))) * 70);
                    int i126 = ~(((-1) ^ i122) | i122);
                    int i127 = ~(~i122);
                    int i128 = (i126 & i127) | (i126 ^ i127);
                    int i129 = ~i;
                    int i130 = i125 + (((i128 & i129) | (i128 ^ i129)) * 70);
                    int i131 = (i2 ^ i130) + ((i2 & i130) << 1);
                    int i132 = i131 ^ (i131 << 13);
                    int i133 = i132 >>> 17;
                    int i134 = (i132 | i133) & (~(i132 & i133));
                    int i135 = i134 << 5;
                    int i136 = (i134 | i135) & (~(i134 & i135));
                    c = 0;
                    ((int[]) objArr8[2])[0] = i136;
                    objArr2 = objArr8;
                }
                if (i != ((int[]) objArr2[1])[c]) {
                    int i137 = artificialFrame;
                    int i138 = (i137 & 115) + (i137 | 115);
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i138 % 128;
                    if (i138 % 2 == 0) {
                        return objArr2;
                    }
                    throw null;
                }
                try {
                    Object[] objArr9 = new Object[1];
                    a((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), new char[]{55266, 44958, 55245, 47009, 52997, 15369, 65508, 29854, 46845, 54921, 24232, 38511, 5612, 30039, 15761, 14178, 62486, 37927, 39759, 20488, 21317, 12989, 31273, 61919, 12915, 20929, 55780, 4787, 37029, 61661, 47326, 44152, 32704, 28528, 6024, 52563, 56854, 36365, 62825, 28191, 48435, 11521, 21544, 36847}, objArr9);
                    File file3 = new File((String) objArr9[0]);
                    try {
                        if (file3.canRead()) {
                            FileReader fileReader3 = new FileReader(file3);
                            BufferedReader bufferedReader3 = new BufferedReader(fileReader3);
                            int i139 = getARTIFICIAL_FRAME_PACKAGE_NAME + 81;
                            artificialFrame = i139 % 128;
                            try {
                                String line = i139 % 2 == 0 ? bufferedReader3.readLine() : bufferedReader3.readLine();
                                Object[] objArr10 = new Object[1];
                                a(ExpandableListView.getPackedPositionGroup(0L), new char[]{10036, 13465, 10074, 11450, 2394, 31434, 14770}, objArr10);
                                if (!line.equals((String) objArr10[0])) {
                                    fileReader3.close();
                                    bufferedReader3.close();
                                    str = line;
                                } else {
                                    fileReader3.close();
                                    bufferedReader3.close();
                                }
                                Object[] objArr11 = new Object[1];
                                a(ViewConfiguration.getScrollBarSize() >> 8, new char[]{27638, 31851, 27609, 25687, 49274, 42354, 61584, 60921, 2725, 1336, 20929, 3871, 43493, 42728, 13033, 44627, 18452, 18393, 37943, 51562, 61209, 57601, 30038, 26788, 36455, 33332, 54935, 35833, 11443, 9065, 47011, 13588, 50122, 48274, 6390}, objArr11);
                                file = new File((String) objArr11[0]);
                                i14 = artificialFrame + 23;
                                getARTIFICIAL_FRAME_PACKAGE_NAME = i14 % 128;
                                if (i14 % 2 != 0) {
                                    int i140 = 43 / 0;
                                    if (file.canRead()) {
                                        fileReader = new FileReader(file);
                                        bufferedReader = new BufferedReader(fileReader);
                                        try {
                                            String line2 = bufferedReader.readLine();
                                            Object[] objArr12 = new Object[1];
                                            a(ViewConfiguration.getWindowTouchSlop() >> 8, new char[]{15630, 61706, 15679, 9006, 60736}, objArr12);
                                            zEquals = line2.equals((String) objArr12[0]);
                                            fileReader.close();
                                            bufferedReader.close();
                                            int i141 = artificialFrame;
                                            int i142 = (i141 & 105) + (i141 | 105);
                                            getARTIFICIAL_FRAME_PACKAGE_NAME = i142 % 128;
                                            int i143 = i142 % 2;
                                            if (zEquals) {
                                                Object[] objArr13 = new Object[1];
                                                a(KeyEvent.getDeadChar(0, 0), new char[]{42756, 65017, 42795, 58822, 4662, 23495, 8919, 4944, 50715, 34030, 33691, 61857, 25866, 10032, 57506, 20652, 34032, 50752, 18044, 14278, 9123, 24794, 42778, 38417, 17045, 934, 1239, 30077, 57411, 41658, 26106, 52145, 3893, 15622, 51895, 43677, 44771, 56426, 10305, 2509}, objArr13);
                                                file2 = new File((String) objArr13[0]);
                                                if (!(!file2.canRead())) {
                                                    fileReader2 = new FileReader(file2);
                                                    bufferedReader2 = new BufferedReader(fileReader2);
                                                    try {
                                                        String line3 = bufferedReader2.readLine();
                                                        Object[] objArr14 = new Object[1];
                                                        a(ExpandableListView.getPackedPositionType(0L), new char[]{15630, 61706, 15679, 9006, 60736}, objArr14);
                                                        zEquals2 = line3.equals((String) objArr14[0]);
                                                        fileReader2.close();
                                                        bufferedReader2.close();
                                                        if (zEquals2 && str != null) {
                                                            Object[] objArr15 = {new int[]{i}, new int[]{(~(i & 20)) & (i | 20)}, new int[]{(i | i) & (~(i & i))}, str};
                                                            int i144 = ~i;
                                                            int i145 = 2067020644 + (((~((-488853763) | i144)) | 489770012) * (-90)) + (((~((-488853763) | i)) | (-489905439)) * (-45)) + (((-488853763) | (~((-489770013) | i)) | (~(i144 | 489770012))) * 45);
                                                            int i146 = (-2928) + (i145 * 185);
                                                            int i147 = ((i145 ^ (-17)) | (i145 & (-17))) * (-368);
                                                            int i148 = (i146 & i147) + (i147 | i146);
                                                            int i149 = (~i145) | 16;
                                                            int i150 = ~i;
                                                            int i151 = ((i149 & i150) | (i149 ^ i150)) * SyslogConstants.LOG_LOCAL7;
                                                            int i152 = (i148 & i151) + (i151 | i148);
                                                            int i153 = ~i145;
                                                            int i154 = ~((i153 & (-17)) | ((-17) ^ i153));
                                                            int i155 = ~((i144 ^ 16) | (i144 & 16));
                                                            int i156 = (i154 & i155) | (i154 ^ i155);
                                                            int i157 = ~(i145 | 16);
                                                            int i158 = (i152 - (~(-(-(((i156 & i157) | (i156 ^ i157)) * SyslogConstants.LOG_LOCAL7))))) - 1;
                                                            int i159 = (((i158 * (-559)) + (i2 * 561)) - (~(-(-((~(i144 | i158)) * (-560)))))) - 1;
                                                            int i160 = ~i2;
                                                            int i161 = i159 + ((~(i | (i160 & i158) | (i160 ^ i158))) * (-560));
                                                            int i162 = ~((~i158) | i2);
                                                            int i163 = ~(i144 | i2);
                                                            int i164 = (i161 - (~(((i163 & i162) | (i162 ^ i163)) * 560))) - 1;
                                                            int i165 = i164 << 13;
                                                            int i166 = (i165 & (~i164)) | ((~i165) & i164);
                                                            int i167 = i166 ^ (i166 >>> 17);
                                                            int i168 = i167 << 5;
                                                            return objArr15;
                                                        }
                                                    } catch (Throwable th) {
                                                        fileReader2.close();
                                                        bufferedReader2.close();
                                                        throw th;
                                                    }
                                                } else {
                                                    int i169 = artificialFrame + 3;
                                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i169 % 128;
                                                    int i170 = i169 % 2;
                                                }
                                            }
                                        } catch (Throwable th2) {
                                            fileReader.close();
                                            bufferedReader.close();
                                            throw th2;
                                        }
                                    }
                                } else if (file.canRead()) {
                                    fileReader = new FileReader(file);
                                    bufferedReader = new BufferedReader(fileReader);
                                    String line4 = bufferedReader.readLine();
                                    Object[] objArr16 = new Object[1];
                                    a(ViewConfiguration.getWindowTouchSlop() >> 8, new char[]{15630, 61706, 15679, 9006, 60736}, objArr16);
                                    zEquals = line4.equals((String) objArr16[0]);
                                    fileReader.close();
                                    bufferedReader.close();
                                    int i1410 = artificialFrame;
                                    int i1411 = (i1410 & 105) + (i1410 | 105);
                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i1411 % 128;
                                    int i1412 = i1411 % 2;
                                    if (zEquals) {
                                        Object[] objArr17 = new Object[1];
                                        a(KeyEvent.getDeadChar(0, 0), new char[]{42756, 65017, 42795, 58822, 4662, 23495, 8919, 4944, 50715, 34030, 33691, 61857, 25866, 10032, 57506, 20652, 34032, 50752, 18044, 14278, 9123, 24794, 42778, 38417, 17045, 934, 1239, 30077, 57411, 41658, 26106, 52145, 3893, 15622, 51895, 43677, 44771, 56426, 10305, 2509}, objArr17);
                                        file2 = new File((String) objArr17[0]);
                                        if (!(!file2.canRead())) {
                                            fileReader2 = new FileReader(file2);
                                            bufferedReader2 = new BufferedReader(fileReader2);
                                            String line5 = bufferedReader2.readLine();
                                            Object[] objArr18 = new Object[1];
                                            a(ExpandableListView.getPackedPositionType(0L), new char[]{15630, 61706, 15679, 9006, 60736}, objArr18);
                                            zEquals2 = line5.equals((String) objArr18[0]);
                                            fileReader2.close();
                                            bufferedReader2.close();
                                            if (zEquals2) {
                                                Object[] objArr19 = {new int[]{i}, new int[]{(~(i & 20)) & (i | 20)}, new int[]{(i167 | i168) & (~(i167 & i168))}, str};
                                                int i1413 = ~i;
                                                int i1414 = 2067020644 + (((~((-488853763) | i1413)) | 489770012) * (-90)) + (((~((-488853763) | i)) | (-489905439)) * (-45)) + (((-488853763) | (~((-489770013) | i)) | (~(i1413 | 489770012))) * 45);
                                                int i1415 = (-2928) + (i1414 * 185);
                                                int i1416 = ((i1414 ^ (-17)) | (i1414 & (-17))) * (-368);
                                                int i1417 = (i1415 & i1416) + (i1416 | i1415);
                                                int i1418 = (~i1414) | 16;
                                                int i1510 = ~i;
                                                int i1511 = ((i1418 & i1510) | (i1418 ^ i1510)) * SyslogConstants.LOG_LOCAL7;
                                                int i1512 = (i1417 & i1511) + (i1511 | i1417);
                                                int i1513 = ~i1414;
                                                int i1514 = ~((i1513 & (-17)) | ((-17) ^ i1513));
                                                int i1515 = ~((i1413 ^ 16) | (i1413 & 16));
                                                int i1516 = (i1514 & i1515) | (i1514 ^ i1515);
                                                int i1517 = ~(i1414 | 16);
                                                int i1518 = (i1512 - (~(-(-(((i1516 & i1517) | (i1516 ^ i1517)) * SyslogConstants.LOG_LOCAL7))))) - 1;
                                                int i1519 = (((i1518 * (-559)) + (i2 * 561)) - (~(-(-((~(i1413 | i1518)) * (-560)))))) - 1;
                                                int i1610 = ~i2;
                                                int i1611 = i1519 + ((~(i | (i1610 & i1518) | (i1610 ^ i1518))) * (-560));
                                                int i1612 = ~((~i1518) | i2);
                                                int i1613 = ~(i1413 | i2);
                                                int i1614 = (i1611 - (~(((i1613 & i1612) | (i1612 ^ i1613)) * 560))) - 1;
                                                int i1615 = i1614 << 13;
                                                int i1616 = (i1615 & (~i1614)) | ((~i1615) & i1614);
                                                int i1617 = i1616 ^ (i1616 >>> 17);
                                                int i1618 = i1617 << 5;
                                                return objArr19;
                                            }
                                        } else {
                                            int i1619 = artificialFrame + 3;
                                            getARTIFICIAL_FRAME_PACKAGE_NAME = i1619 % 128;
                                            int i171 = i1619 % 2;
                                        }
                                    }
                                }
                                Object[] objArr20 = {new int[]{i}, new int[]{i}, new int[1], null};
                                int i172 = ~(835986176 | i);
                                i3 = (((827588864 | i172) * (-196)) - 1668589282) + ((i172 | 8397312) * 196);
                                i4 = artificialFrame + 47;
                                getARTIFICIAL_FRAME_PACKAGE_NAME = i4 % 128;
                                if (i4 % 2 != 0) {
                                    i5 = 483 % (242 >> i3);
                                    int i173 = ~i3;
                                    i7 = ~(i173 | ((-1) ^ i173));
                                    int i174 = ~i;
                                    i6 = i174 | ((-1) ^ i174);
                                } else {
                                    i5 = -(-(i3 * 242));
                                    int i175 = ~i;
                                    i6 = i175 | ((-1) ^ i175);
                                    i7 = 0;
                                }
                                int i176 = ~i6;
                                int i177 = i5 + ((-241) * ((i176 & i7) | (i7 ^ i176))) + (i3 * (-482));
                                int i178 = ~(~i3);
                                int i179 = ~i;
                                int i180 = i179 | ((-1) ^ i179);
                                int i181 = ~((i3 & i180) | (i180 ^ i3));
                                i8 = (i177 - (~(-(-(((i178 & i181) | (i178 ^ i181)) * 241))))) - 1;
                                iITrustedWebActivityCallbackStub = JwtEcdsaAlgorithm.AnonymousClass1.ITrustedWebActivityCallbackStub();
                                int i182 = i8 * (-109);
                                int i183 = i2 * b.f40o;
                                int i184 = ((i182 | i183) << 1) - (i182 ^ i183);
                                i9 = ~i8;
                                i10 = ~((i2 ^ iITrustedWebActivityCallbackStub) | (i2 & iITrustedWebActivityCallbackStub));
                                int i185 = ((i9 ^ i10) | (i9 & i10)) * (-220);
                                i11 = (i184 ^ i185) + ((i185 & i184) << 1);
                                int i186 = artificialFrame;
                                i12 = (i186 & 121) + (i186 | 121);
                                getARTIFICIAL_FRAME_PACKAGE_NAME = i12 % 128;
                                if (i12 % 2 != 0) {
                                    int i187 = ~((i8 ^ i2) | (i8 & i2));
                                    int i188 = i11 / (220 >>> ((i187 & i10) | (i187 ^ i10)));
                                    int i189 = ~i8;
                                    int i190 = ~((i189 & i2) | (i189 ^ i2));
                                    int i191 = ~((~i2) | i8);
                                    i13 = i188 >>> (b.f39n >>> ((i190 & i191) | (i190 ^ i191)));
                                } else {
                                    int i192 = (i11 - (~(-(-(((~(iITrustedWebActivityCallbackStub | i2)) | (~(i8 | i2))) * 220))))) - 1;
                                    int i193 = ~(i9 | i2);
                                    int i194 = ~((~i2) | i8);
                                    int i195 = -(-(((i193 & i194) | (i193 ^ i194)) * b.f39n));
                                    i13 = ((i192 | i195) << 1) - (i195 ^ i192);
                                }
                                int i196 = i13 ^ (i13 << 13);
                                int i197 = i196 >>> 17;
                                int i198 = ((~i196) & i197) | ((~i197) & i196);
                                int i199 = i198 << 5;
                                ((int[]) objArr20[2])[0] = (i198 | i199) & (~(i198 & i199));
                                return objArr20;
                            } catch (Throwable th3) {
                                fileReader3.close();
                                bufferedReader3.close();
                                throw th3;
                            }
                        }
                        int i200 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                        int i201 = (i200 & 1) + (i200 | 1);
                        artificialFrame = i201 % 128;
                        int i202 = i201 % 2;
                        Object[] objArr110 = new Object[1];
                        a(ViewConfiguration.getScrollBarSize() >> 8, new char[]{27638, 31851, 27609, 25687, 49274, 42354, 61584, 60921, 2725, 1336, 20929, 3871, 43493, 42728, 13033, 44627, 18452, 18393, 37943, 51562, 61209, 57601, 30038, 26788, 36455, 33332, 54935, 35833, 11443, 9065, 47011, 13588, 50122, 48274, 6390}, objArr110);
                        file = new File((String) objArr110[0]);
                        i14 = artificialFrame + 23;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i14 % 128;
                        if (i14 % 2 != 0) {
                            int i1419 = 43 / 0;
                            if (file.canRead()) {
                                fileReader = new FileReader(file);
                                bufferedReader = new BufferedReader(fileReader);
                                String line6 = bufferedReader.readLine();
                                Object[] objArr111 = new Object[1];
                                a(ViewConfiguration.getWindowTouchSlop() >> 8, new char[]{15630, 61706, 15679, 9006, 60736}, objArr111);
                                zEquals = line6.equals((String) objArr111[0]);
                                fileReader.close();
                                bufferedReader.close();
                                int i14110 = artificialFrame;
                                int i14111 = (i14110 & 105) + (i14110 | 105);
                                getARTIFICIAL_FRAME_PACKAGE_NAME = i14111 % 128;
                                int i14112 = i14111 % 2;
                                if (zEquals) {
                                    Object[] objArr112 = new Object[1];
                                    a(KeyEvent.getDeadChar(0, 0), new char[]{42756, 65017, 42795, 58822, 4662, 23495, 8919, 4944, 50715, 34030, 33691, 61857, 25866, 10032, 57506, 20652, 34032, 50752, 18044, 14278, 9123, 24794, 42778, 38417, 17045, 934, 1239, 30077, 57411, 41658, 26106, 52145, 3893, 15622, 51895, 43677, 44771, 56426, 10305, 2509}, objArr112);
                                    file2 = new File((String) objArr112[0]);
                                    if (!(!file2.canRead())) {
                                        fileReader2 = new FileReader(file2);
                                        bufferedReader2 = new BufferedReader(fileReader2);
                                        String line7 = bufferedReader2.readLine();
                                        Object[] objArr113 = new Object[1];
                                        a(ExpandableListView.getPackedPositionType(0L), new char[]{15630, 61706, 15679, 9006, 60736}, objArr113);
                                        zEquals2 = line7.equals((String) objArr113[0]);
                                        fileReader2.close();
                                        bufferedReader2.close();
                                        if (zEquals2) {
                                            Object[] objArr114 = {new int[]{i}, new int[]{(~(i & 20)) & (i | 20)}, new int[]{(i1617 | i1618) & (~(i1617 & i1618))}, str};
                                            int i14113 = ~i;
                                            int i14114 = 2067020644 + (((~((-488853763) | i14113)) | 489770012) * (-90)) + (((~((-488853763) | i)) | (-489905439)) * (-45)) + (((-488853763) | (~((-489770013) | i)) | (~(i14113 | 489770012))) * 45);
                                            int i14115 = (-2928) + (i14114 * 185);
                                            int i14116 = ((i14114 ^ (-17)) | (i14114 & (-17))) * (-368);
                                            int i14117 = (i14115 & i14116) + (i14116 | i14115);
                                            int i14118 = (~i14114) | 16;
                                            int i15110 = ~i;
                                            int i15111 = ((i14118 & i15110) | (i14118 ^ i15110)) * SyslogConstants.LOG_LOCAL7;
                                            int i15112 = (i14117 & i15111) + (i15111 | i14117);
                                            int i15113 = ~i14114;
                                            int i15114 = ~((i15113 & (-17)) | ((-17) ^ i15113));
                                            int i15115 = ~((i14113 ^ 16) | (i14113 & 16));
                                            int i15116 = (i15114 & i15115) | (i15114 ^ i15115);
                                            int i15117 = ~(i14114 | 16);
                                            int i15118 = (i15112 - (~(-(-(((i15116 & i15117) | (i15116 ^ i15117)) * SyslogConstants.LOG_LOCAL7))))) - 1;
                                            int i15119 = (((i15118 * (-559)) + (i2 * 561)) - (~(-(-((~(i14113 | i15118)) * (-560)))))) - 1;
                                            int i16110 = ~i2;
                                            int i16111 = i15119 + ((~(i | (i16110 & i15118) | (i16110 ^ i15118))) * (-560));
                                            int i16112 = ~((~i15118) | i2);
                                            int i16113 = ~(i14113 | i2);
                                            int i16114 = (i16111 - (~(((i16113 & i16112) | (i16112 ^ i16113)) * 560))) - 1;
                                            int i16115 = i16114 << 13;
                                            int i16116 = (i16115 & (~i16114)) | ((~i16115) & i16114);
                                            int i16117 = i16116 ^ (i16116 >>> 17);
                                            int i16118 = i16117 << 5;
                                            return objArr114;
                                        }
                                    } else {
                                        int i16119 = artificialFrame + 3;
                                        getARTIFICIAL_FRAME_PACKAGE_NAME = i16119 % 128;
                                        int i1710 = i16119 % 2;
                                    }
                                }
                            }
                        } else if (file.canRead()) {
                            fileReader = new FileReader(file);
                            bufferedReader = new BufferedReader(fileReader);
                            String line8 = bufferedReader.readLine();
                            Object[] objArr115 = new Object[1];
                            a(ViewConfiguration.getWindowTouchSlop() >> 8, new char[]{15630, 61706, 15679, 9006, 60736}, objArr115);
                            zEquals = line8.equals((String) objArr115[0]);
                            fileReader.close();
                            bufferedReader.close();
                            int i14119 = artificialFrame;
                            int i141110 = (i14119 & 105) + (i14119 | 105);
                            getARTIFICIAL_FRAME_PACKAGE_NAME = i141110 % 128;
                            int i141111 = i141110 % 2;
                            if (zEquals) {
                                Object[] objArr116 = new Object[1];
                                a(KeyEvent.getDeadChar(0, 0), new char[]{42756, 65017, 42795, 58822, 4662, 23495, 8919, 4944, 50715, 34030, 33691, 61857, 25866, 10032, 57506, 20652, 34032, 50752, 18044, 14278, 9123, 24794, 42778, 38417, 17045, 934, 1239, 30077, 57411, 41658, 26106, 52145, 3893, 15622, 51895, 43677, 44771, 56426, 10305, 2509}, objArr116);
                                file2 = new File((String) objArr116[0]);
                                if (!(!file2.canRead())) {
                                    fileReader2 = new FileReader(file2);
                                    bufferedReader2 = new BufferedReader(fileReader2);
                                    String line9 = bufferedReader2.readLine();
                                    Object[] objArr117 = new Object[1];
                                    a(ExpandableListView.getPackedPositionType(0L), new char[]{15630, 61706, 15679, 9006, 60736}, objArr117);
                                    zEquals2 = line9.equals((String) objArr117[0]);
                                    fileReader2.close();
                                    bufferedReader2.close();
                                    if (zEquals2) {
                                        Object[] objArr118 = {new int[]{i}, new int[]{(~(i & 20)) & (i | 20)}, new int[]{(i16117 | i16118) & (~(i16117 & i16118))}, str};
                                        int i141112 = ~i;
                                        int i141113 = 2067020644 + (((~((-488853763) | i141112)) | 489770012) * (-90)) + (((~((-488853763) | i)) | (-489905439)) * (-45)) + (((-488853763) | (~((-489770013) | i)) | (~(i141112 | 489770012))) * 45);
                                        int i141114 = (-2928) + (i141113 * 185);
                                        int i141115 = ((i141113 ^ (-17)) | (i141113 & (-17))) * (-368);
                                        int i141116 = (i141114 & i141115) + (i141115 | i141114);
                                        int i141117 = (~i141113) | 16;
                                        int i151110 = ~i;
                                        int i151111 = ((i141117 & i151110) | (i141117 ^ i151110)) * SyslogConstants.LOG_LOCAL7;
                                        int i151112 = (i141116 & i151111) + (i151111 | i141116);
                                        int i151113 = ~i141113;
                                        int i151114 = ~((i151113 & (-17)) | ((-17) ^ i151113));
                                        int i151115 = ~((i141112 ^ 16) | (i141112 & 16));
                                        int i151116 = (i151114 & i151115) | (i151114 ^ i151115);
                                        int i151117 = ~(i141113 | 16);
                                        int i151118 = (i151112 - (~(-(-(((i151116 & i151117) | (i151116 ^ i151117)) * SyslogConstants.LOG_LOCAL7))))) - 1;
                                        int i151119 = (((i151118 * (-559)) + (i2 * 561)) - (~(-(-((~(i141112 | i151118)) * (-560)))))) - 1;
                                        int i161110 = ~i2;
                                        int i161111 = i151119 + ((~(i | (i161110 & i151118) | (i161110 ^ i151118))) * (-560));
                                        int i161112 = ~((~i151118) | i2);
                                        int i161113 = ~(i141112 | i2);
                                        int i161114 = (i161111 - (~(((i161113 & i161112) | (i161112 ^ i161113)) * 560))) - 1;
                                        int i161115 = i161114 << 13;
                                        int i161116 = (i161115 & (~i161114)) | ((~i161115) & i161114);
                                        int i161117 = i161116 ^ (i161116 >>> 17);
                                        int i161118 = i161117 << 5;
                                        return objArr118;
                                    }
                                } else {
                                    int i161119 = artificialFrame + 3;
                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i161119 % 128;
                                    int i1711 = i161119 % 2;
                                }
                            }
                        }
                    } catch (Exception unused2) {
                    }
                } catch (Exception unused3) {
                }
                str = null;
                Object[] objArr21 = {new int[]{i}, new int[]{i}, new int[1], null};
                int i1712 = ~(835986176 | i);
                i3 = (((827588864 | i1712) * (-196)) - 1668589282) + ((i1712 | 8397312) * 196);
                i4 = artificialFrame + 47;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i4 % 128;
                if (i4 % 2 != 0) {
                    i5 = 483 % (242 >> i3);
                    int i1713 = ~i3;
                    i7 = ~(i1713 | ((-1) ^ i1713));
                    int i1714 = ~i;
                    i6 = i1714 | ((-1) ^ i1714);
                } else {
                    i5 = -(-(i3 * 242));
                    int i1715 = ~i;
                    i6 = i1715 | ((-1) ^ i1715);
                    i7 = 0;
                }
                int i1716 = ~i6;
                int i1717 = i5 + ((-241) * ((i1716 & i7) | (i7 ^ i1716))) + (i3 * (-482));
                int i1718 = ~(~i3);
                int i1719 = ~i;
                int i1810 = i1719 | ((-1) ^ i1719);
                int i1811 = ~((i3 & i1810) | (i1810 ^ i3));
                i8 = (i1717 - (~(-(-(((i1718 & i1811) | (i1718 ^ i1811)) * 241))))) - 1;
                iITrustedWebActivityCallbackStub = JwtEcdsaAlgorithm.AnonymousClass1.ITrustedWebActivityCallbackStub();
                int i1812 = i8 * (-109);
                int i1813 = i2 * b.f40o;
                int i1814 = ((i1812 | i1813) << 1) - (i1812 ^ i1813);
                i9 = ~i8;
                i10 = ~((i2 ^ iITrustedWebActivityCallbackStub) | (i2 & iITrustedWebActivityCallbackStub));
                int i1815 = ((i9 ^ i10) | (i9 & i10)) * (-220);
                i11 = (i1814 ^ i1815) + ((i1815 & i1814) << 1);
                int i1816 = artificialFrame;
                i12 = (i1816 & 121) + (i1816 | 121);
                getARTIFICIAL_FRAME_PACKAGE_NAME = i12 % 128;
                if (i12 % 2 != 0) {
                    int i1817 = ~((i8 ^ i2) | (i8 & i2));
                    int i1818 = i11 / (220 >>> ((i1817 & i10) | (i1817 ^ i10)));
                    int i1819 = ~i8;
                    int i1910 = ~((i1819 & i2) | (i1819 ^ i2));
                    int i1911 = ~((~i2) | i8);
                    i13 = i1818 >>> (b.f39n >>> ((i1910 & i1911) | (i1910 ^ i1911)));
                } else {
                    int i1912 = (i11 - (~(-(-(((~(iITrustedWebActivityCallbackStub | i2)) | (~(i8 | i2))) * 220))))) - 1;
                    int i1913 = ~(i9 | i2);
                    int i1914 = ~((~i2) | i8);
                    int i1915 = -(-(((i1913 & i1914) | (i1913 ^ i1914)) * b.f39n));
                    i13 = ((i1912 | i1915) << 1) - (i1915 ^ i1912);
                }
                int i1916 = i13 ^ (i13 << 13);
                int i1917 = i1916 >>> 17;
                int i1918 = ((~i1916) & i1917) | ((~i1917) & i1916);
                int i1919 = i1918 << 5;
                ((int[]) objArr21[2])[0] = (i1918 | i1919) & (~(i1918 & i1919));
                return objArr21;
            } catch (Throwable th4) {
                Throwable cause = th4.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th4;
            }
        }
    }
}
