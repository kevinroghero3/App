package com.facebook.gamingservices.cloudgaming;

import android.content.Context;
import android.graphics.Color;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegate;
import com.facebook.GraphResponse;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKLogger;
import com.facebook.gamingservices.cloudgaming.internal.SDKMessageEnum;
import com.google.common.base.Ascii;
import java.lang.reflect.Method;
import o.ArtificialStackFrames;
import o.onMessageChannelReady;
import o.onPostMessage;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class GameFeaturesLibrary {
    public static void getPayload(Context context, JSONObject jSONObject, DaemonRequest.Callback callback) {
        DaemonRequest.executeAsync(context, jSONObject, callback, SDKMessageEnum.GET_PAYLOAD);
    }

    public static void canCreateShortcut(Context context, JSONObject jSONObject, DaemonRequest.Callback callback) {
        DaemonRequest.executeAsync(context, jSONObject, callback, SDKMessageEnum.CAN_CREATE_SHORTCUT);
    }

    public static void createShortcut(Context context, JSONObject jSONObject, DaemonRequest.Callback callback) {
        DaemonRequest.executeAsync(context, jSONObject, callback, SDKMessageEnum.CREATE_SHORTCUT);
    }

    public static void postSessionScore(Context context, int i, DaemonRequest.Callback callback) {
        try {
            DaemonRequest.executeAsync(context, new JSONObject().put("score", i), callback, SDKMessageEnum.POST_SESSION_SCORE);
        } catch (JSONException e) {
            SDKLogger.logInternalError(context, SDKMessageEnum.POST_SESSION_SCORE, e);
        }
    }

    public static void postSessionScoreAsync(Context context, int i, DaemonRequest.Callback callback) {
        try {
            DaemonRequest.executeAsync(context, new JSONObject().put("score", i), callback, SDKMessageEnum.POST_SESSION_SCORE_ASYNC);
        } catch (JSONException e) {
            SDKLogger.logInternalError(context, SDKMessageEnum.POST_SESSION_SCORE_ASYNC, e);
        }
    }

    public static void getTournamentAsync(Context context, DaemonRequest.Callback callback) {
        DaemonRequest.executeAsync(context, (JSONObject) null, callback, SDKMessageEnum.GET_TOURNAMENT_ASYNC);
    }

    public static void createTournamentAsync(Context context, int i, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable Integer num, @Nullable JSONObject jSONObject, DaemonRequest.Callback callback) {
        try {
            DaemonRequest.executeAsync(context, new JSONObject().put(SDKConstants.PARAM_INITIAL_SCORE, i).put("title", str).put("image", str2).put(SDKConstants.PARAM_SORT_ORDER, str3).put(SDKConstants.PARAM_SCORE_FORMAT, str4).put(SDKConstants.PARAM_END_TIME, num).put("data", jSONObject), callback, SDKMessageEnum.TOURNAMENT_CREATE_ASYNC);
        } catch (JSONException e) {
            SDKLogger.logInternalError(context, SDKMessageEnum.TOURNAMENT_CREATE_ASYNC, e);
        }
    }

    public static void shareTournamentAsync(Context context, @Nullable Integer num, @Nullable JSONObject jSONObject, DaemonRequest.Callback callback) {
        try {
            DaemonRequest.executeAsync(context, new JSONObject().put("score", num).put("data", jSONObject), callback, SDKMessageEnum.TOURNAMENT_SHARE_ASYNC);
        } catch (JSONException e) {
            SDKLogger.logInternalError(context, SDKMessageEnum.TOURNAMENT_SHARE_ASYNC, e);
        }
    }

    public static void postTournamentScoreAsync(Context context, int i, DaemonRequest.Callback callback) throws JSONException {
        DaemonRequest.executeAsync(context, new JSONObject().put("score", i), callback, SDKMessageEnum.TOURNAMENT_POST_SCORE_ASYNC);
    }

    public static void getTournamentsAsync(Context context, DaemonRequest.Callback callback) throws JSONException {
        DaemonRequest.executeAsync(context, (JSONObject) null, callback, SDKMessageEnum.TOURNAMENT_GET_TOURNAMENTS_ASYNC);
    }

    public static void joinTournamentAsync(Context context, String str, DaemonRequest.Callback callback) throws JSONException {
        DaemonRequest.executeAsync(context, new JSONObject().put(SDKConstants.PARAM_TOURNAMENT_ID, str), callback, SDKMessageEnum.TOURNAMENT_JOIN_ASYNC);
    }

    public static void performHapticFeedback(Context context) {
        DaemonRequest.executeAsync(context, (JSONObject) null, new DaemonRequest.Callback() { // from class: com.facebook.gamingservices.cloudgaming.GameFeaturesLibrary.1
            private static final byte[] $$a = {112, Ascii.SUB, -43, 87};
            private static final int $$b = 53;
            private static int $10 = 0;
            private static int $11 = 1;
            private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
            private static int artificialFrame = 1;
            private static char[] validateRelationship = {55859, 56004, 55855, 55853, 56055, 55850, 55864, 55866, 55848, 55851, 55868, 55849, 55852, 55869, 56040, 56053, 56013, 56021, 55863, 55861, 55857, 56026, 56023, 56032, 56036, 55865, 55862, 55941, 56025, 55867, 55870, 56049, 56022, 56008, 56010, 55858, 56016, 56028, 55871, 56044, 56027};
            private static int warmup = -1044260187;
            private static boolean requestPostMessageChannelWithExtras = true;
            private static boolean ICustomTabsServiceDefault = true;
            private static char[] IPostMessageService = {38229, 38227, 38233, 38223, 38231, 38233, 38250, 38214, 38229, 38227, 38229, 38221, 38233, 38252, 38287, 38360, 38358, 38356, 38351, 38355, 38361, 38390, 38391, 38358, 38353, 38350, 38355, 38358, 38350, 38382, 38384, 38353, 38386, 38272, 38375, 38365, 38360, 38361, 38363, 38361, 38374, 38376, 38360, 38360, 38363, 38361, 38356, 38280, 38357, 38357, 38372, 38376, 38361, 38363, 38361, 38360, 38365, 38375, 38272, 38386, 38353, 38384, 38382, 38350, 38358, 38355, 38350, 38353, 38358, 38391, 38390, 38361, 38355, 38351, 38356, 38358, 38360, 38277, 38353, 38354, 38348, 38355, 38363, 38355, 38383, 38392, 38356, 38356, 38362, 38350, 38346, 38351, 38350, 38356, 38365, 38380, 38378, 38355, 38357, 38365, 38361, 38360, 38360, 38353, 38348, 38356, 38379, 38279, 38382, 38348, 38356, 38363, 38391, 38380, 38348, 38225, 38239, 38242, 38221, 38218, 38227, 38230, 38229, 38233, 38231, 38285, 38356, 38348, 38347, 38357, 38360, 38357, 38359, 38369, 38399, 38386, 38353, 38384, 38382, 38350, 38358, 38355, 38350, 38353, 38358, 38391, 38390, 38361, 38355, 38351, 38356, 38358, 38360, 38380, 38170, 38167, 38167, 38165, 38167, 38166, 38164, 38188, 38188, 38165, 38157, 38162, 38169, 38169, 38170, 38174, 38166, 38164, 38387, 38189, 38191, 38204, 38206, 38387, 38184, 38189, 38200, 38191, 38188, 38206, 38204, 38190, 38387, 38336, 38187, 38336, 38199, 38204, 38189, 38336, 38206, 38200, 38203, 38200, 38189, 38191, 38204, 38366, 38376, 38385, 38380, 38345, 38375, 38164, 38162, 38158, 38164, 38162, 38159, 38157, 38169, 38202, 38346, 38344, 38196, 38164, 38159, 38166, 38163, 38164, 38159, 38166, 38167, 38158, 38164};

            /* JADX WARN: Code duplicated, block: B:10:0x0025  */
            /* JADX WARN: Code duplicated, block: B:8:0x001f  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x002b). Please report as a decompilation issue!!! */
            /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0025
                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                */
            private static java.lang.String $$c(int r6, byte r7, int r8) {
                /*
                    int r8 = 122 - r8
                    int r7 = r7 + 4
                    int r6 = r6 * 2
                    int r0 = 1 - r6
                    byte[] r1 = com.facebook.gamingservices.cloudgaming.GameFeaturesLibrary.AnonymousClass1.$$a
                    byte[] r0 = new byte[r0]
                    r2 = 0
                    int r6 = 0 - r6
                    if (r1 != 0) goto L15
                    r3 = r6
                    r8 = r7
                    r4 = r2
                    goto L2b
                L15:
                    r3 = r2
                L16:
                    int r7 = r7 + 1
                    byte r4 = (byte) r8
                    r0[r3] = r4
                    int r4 = r3 + 1
                    if (r3 != r6) goto L25
                    java.lang.String r6 = new java.lang.String
                    r6.<init>(r0, r2)
                    return r6
                L25:
                    r3 = r1[r7]
                    r5 = r8
                    r8 = r7
                    r7 = r3
                    r3 = r5
                L2b:
                    int r7 = r7 + r3
                    r3 = r4
                    r5 = r8
                    r8 = r7
                    r7 = r5
                    goto L16
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.gamingservices.cloudgaming.GameFeaturesLibrary.AnonymousClass1.$$c(int, byte, int):java.lang.String");
            }

            @Override // com.facebook.gamingservices.cloudgaming.DaemonRequest.Callback
            public void onCompleted(GraphResponse graphResponse) {
            }

            private static void a(int i, byte[] bArr, char[] cArr, int[] iArr, Object[] objArr) throws Throwable {
                int i2 = 2 % 2;
                onMessageChannelReady onmessagechannelready = new onMessageChannelReady();
                char[] cArr2 = validateRelationship;
                long j = 0;
                int i3 = 0;
                if (cArr2 != null) {
                    int length = cArr2.length;
                    char[] cArr3 = new char[length];
                    int i4 = 0;
                    while (i4 < length) {
                        try {
                            Object[] objArr2 = new Object[1];
                            objArr2[i3] = Integer.valueOf(cArr2[i4]);
                            Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(115862995);
                            if (objAccessartificialFrame == null) {
                                byte b = (byte) i3;
                                byte b2 = (byte) (b - 1);
                                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(TextUtils.indexOf("", "") + 26, (char) ((SystemClock.uptimeMillis() > j ? 1 : (SystemClock.uptimeMillis() == j ? 0 : -1)) - 1), (TypedValue.complexToFloat(i3) > 0.0f ? 1 : (TypedValue.complexToFloat(i3) == 0.0f ? 0 : -1)) + 1041, -1719489573, false, $$c(b, b2, (byte) (-b2)), new Class[]{Integer.TYPE});
                            }
                            cArr3[i4] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                            i4++;
                            j = 0;
                            i3 = 0;
                        } catch (Throwable th) {
                            Throwable cause = th.getCause();
                            if (cause == null) {
                                throw th;
                            }
                            throw cause;
                        }
                    }
                    cArr2 = cArr3;
                }
                Object[] objArr3 = {Integer.valueOf(warmup)};
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1820173622);
                if (objAccessartificialFrame2 == null) {
                    byte b3 = (byte) 0;
                    byte b4 = (byte) (b3 - 1);
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(15 - ExpandableListView.getPackedPositionGroup(0L), (char) (20488 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1))), 2148 - KeyEvent.normalizeMetaState(0), 216472770, false, $$c(b3, b4, (byte) (b4 & 55)), new Class[]{Integer.TYPE});
                }
                int iIntValue = ((Integer) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).intValue();
                int i5 = 59174;
                int i6 = -2083387879;
                if (ICustomTabsServiceDefault) {
                    onmessagechannelready.c = bArr.length;
                    char[] cArr4 = new char[onmessagechannelready.c];
                    onmessagechannelready.a = 0;
                    int i7 = $10 + 23;
                    $11 = i7 % 128;
                    int i8 = i7 % 2;
                    while (onmessagechannelready.a < onmessagechannelready.c) {
                        int i9 = $10 + 79;
                        $11 = i9 % 128;
                        if (i9 % 2 == 0) {
                            cArr4[onmessagechannelready.a] = (char) (cArr2[bArr[(onmessagechannelready.c % 0) % onmessagechannelready.a] * i] - iIntValue);
                            Object[] objArr4 = {onmessagechannelready, onmessagechannelready};
                            Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-2083387879);
                            if (objAccessartificialFrame3 == null) {
                                byte b5 = (byte) 0;
                                byte b6 = (byte) (b5 - 1);
                                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(TextUtils.indexOf("", "", 0) + 21, (char) ((ViewConfiguration.getTapTimeout() >> 16) + i5), 1943 - (ViewConfiguration.getFadingEdgeLength() >> 16), 481771537, false, $$c(b5, b6, (byte) (b6 & 56)), new Class[]{Object.class, Object.class});
                            }
                            ((Method) objAccessartificialFrame3).invoke(null, objArr4);
                        } else {
                            cArr4[onmessagechannelready.a] = (char) (cArr2[bArr[(onmessagechannelready.c - 1) - onmessagechannelready.a] + i] - iIntValue);
                            Object[] objArr5 = {onmessagechannelready, onmessagechannelready};
                            Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-2083387879);
                            if (objAccessartificialFrame4 == null) {
                                byte b7 = (byte) 0;
                                byte b8 = (byte) (b7 - 1);
                                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(((Process.getThreadPriority(0) + 20) >> 6) + 21, (char) (59174 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1))), 1943 - ExpandableListView.getPackedPositionType(0L), 481771537, false, $$c(b7, b8, (byte) (b8 & 56)), new Class[]{Object.class, Object.class});
                            }
                            ((Method) objAccessartificialFrame4).invoke(null, objArr5);
                        }
                        i5 = 59174;
                    }
                    objArr[0] = new String(cArr4);
                    return;
                }
                if (requestPostMessageChannelWithExtras) {
                    onmessagechannelready.c = cArr.length;
                    char[] cArr5 = new char[onmessagechannelready.c];
                    onmessagechannelready.a = 0;
                    while (onmessagechannelready.a < onmessagechannelready.c) {
                        cArr5[onmessagechannelready.a] = (char) (cArr2[cArr[(onmessagechannelready.c - 1) - onmessagechannelready.a] - i] - iIntValue);
                        Object[] objArr6 = {onmessagechannelready, onmessagechannelready};
                        Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(i6);
                        if (objAccessartificialFrame5 == null) {
                            byte b9 = (byte) 0;
                            byte b10 = (byte) (b9 - 1);
                            objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(MotionEvent.axisFromString("") + 22, (char) ((CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + 59174), View.resolveSizeAndState(0, 0, 0) + 1943, 481771537, false, $$c(b9, b10, (byte) (b10 & 56)), new Class[]{Object.class, Object.class});
                        }
                        ((Method) objAccessartificialFrame5).invoke(null, objArr6);
                        int i10 = $11 + AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
                        $10 = i10 % 128;
                        int i11 = i10 % 2;
                        i6 = -2083387879;
                    }
                    String str = new String(cArr5);
                    int i12 = $11 + 11;
                    $10 = i12 % 128;
                    int i13 = i12 % 2;
                    objArr[0] = str;
                    return;
                }
                int i14 = 0;
                onmessagechannelready.c = iArr.length;
                char[] cArr6 = new char[onmessagechannelready.c];
                while (true) {
                    onmessagechannelready.a = i14;
                    if (onmessagechannelready.a >= onmessagechannelready.c) {
                        objArr[0] = new String(cArr6);
                        return;
                    }
                    int i15 = $11 + 55;
                    $10 = i15 % 128;
                    if (i15 % 2 != 0) {
                        cArr6[onmessagechannelready.a] = (char) (cArr2[iArr[onmessagechannelready.c << onmessagechannelready.a] / i] - iIntValue);
                        i14 = onmessagechannelready.a;
                    } else {
                        cArr6[onmessagechannelready.a] = (char) (cArr2[iArr[(onmessagechannelready.c - 1) - onmessagechannelready.a] - i] - iIntValue);
                        i14 = onmessagechannelready.a + 1;
                    }
                }
            }

            private static void b(boolean z, byte[] bArr, int[] iArr, Object[] objArr) throws Throwable {
                int i;
                int i2;
                int i3 = 2 % 2;
                onPostMessage onpostmessage = new onPostMessage();
                int i4 = 0;
                int i5 = iArr[0];
                int i6 = 1;
                int i7 = iArr[1];
                int i8 = iArr[2];
                int i9 = iArr[3];
                char[] cArr = IPostMessageService;
                if (cArr != null) {
                    int i10 = $11 + 117;
                    $10 = i10 % 128;
                    int i11 = i10 % 2;
                    int length = cArr.length;
                    char[] cArr2 = new char[length];
                    int i12 = 0;
                    while (i12 < length) {
                        try {
                            Object[] objArr2 = new Object[i6];
                            objArr2[i4] = Integer.valueOf(cArr[i12]);
                            Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1782207618);
                            if (objAccessartificialFrame == null) {
                                byte b = (byte) i4;
                                byte b2 = (byte) (b - 1);
                                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(11 - Color.alpha(i4), (char) TextUtils.getOffsetAfter("", i4), TextUtils.indexOf("", "") + 1562, 178318710, false, $$c(b, b2, (byte) (b2 & 57)), new Class[]{Integer.TYPE});
                            }
                            cArr2[i12] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                            i12++;
                            i4 = 0;
                            i6 = 1;
                        } catch (Throwable th) {
                            Throwable cause = th.getCause();
                            if (cause == null) {
                                throw th;
                            }
                            throw cause;
                        }
                    }
                    cArr = cArr2;
                }
                char[] cArr3 = new char[i7];
                System.arraycopy(cArr, i5, cArr3, 0, i7);
                if (bArr != null) {
                    int i13 = $10 + 11;
                    $11 = i13 % 128;
                    int i14 = i13 % 2;
                    char[] cArr4 = new char[i7];
                    onpostmessage.a = 0;
                    char c = 0;
                    while (onpostmessage.a < i7) {
                        if (bArr[onpostmessage.a] == 1) {
                            int i15 = onpostmessage.a;
                            Object[] objArr3 = {Integer.valueOf(cArr3[onpostmessage.a]), Integer.valueOf(c)};
                            Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1378437083);
                            if (objAccessartificialFrame2 == null) {
                                byte b3 = (byte) 0;
                                byte b4 = (byte) (b3 - 1);
                                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(23 - ExpandableListView.getPackedPositionGroup(0L), (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)), 2442 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), -850656813, false, $$c(b3, b4, (byte) (b4 & 54)), new Class[]{Integer.TYPE, Integer.TYPE});
                            }
                            cArr4[i15] = ((Character) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).charValue();
                        } else {
                            int i16 = onpostmessage.a;
                            Object[] objArr4 = {Integer.valueOf(cArr3[onpostmessage.a]), Integer.valueOf(c)};
                            Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-314759072);
                            if (objAccessartificialFrame3 == null) {
                                byte b5 = (byte) 0;
                                byte b6 = (byte) (b5 - 1);
                                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(11 - KeyEvent.getDeadChar(0, 0), (char) (ViewConfiguration.getFadingEdgeLength() >> 16), 1562 - View.combineMeasuredStates(0, 0), 1918398056, false, $$c(b5, b6, (byte) (b6 + 1)), new Class[]{Integer.TYPE, Integer.TYPE});
                            }
                            cArr4[i16] = ((Character) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).charValue();
                        }
                        c = cArr4[onpostmessage.a];
                        Object[] objArr5 = {onpostmessage, onpostmessage};
                        Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(898481158);
                        if (objAccessartificialFrame4 == null) {
                            objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(22 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (char) ((Process.myTid() >> 22) + 29363), 214 - MotionEvent.axisFromString(""), -1427572210, false, "F", new Class[]{Object.class, Object.class});
                        }
                        ((Method) objAccessartificialFrame4).invoke(null, objArr5);
                    }
                    cArr3 = cArr4;
                }
                if (i9 > 0) {
                    char[] cArr5 = new char[i7];
                    i = 0;
                    System.arraycopy(cArr3, 0, cArr5, 0, i7);
                    int i17 = i7 - i9;
                    System.arraycopy(cArr5, 0, cArr3, i17, i9);
                    System.arraycopy(cArr5, i9, cArr3, 0, i17);
                } else {
                    i = 0;
                }
                int i18 = 1;
                if (z) {
                    char[] cArr6 = new char[i7];
                    onpostmessage.a = i;
                    while (onpostmessage.a < i7) {
                        int i19 = $10 + i18;
                        $11 = i19 % 128;
                        if (i19 % 2 == 0) {
                            cArr6[onpostmessage.a] = cArr3[i7 >>> onpostmessage.a];
                            i2 = onpostmessage.a;
                        } else {
                            cArr6[onpostmessage.a] = cArr3[(i7 - onpostmessage.a) - 1];
                            i2 = onpostmessage.a + 1;
                        }
                        onpostmessage.a = i2;
                        i18 = 1;
                    }
                    cArr3 = cArr6;
                }
                if (i8 > 0) {
                    int i20 = $11 + 119;
                    $10 = i20 % 128;
                    int i21 = i20 % 2 != 0 ? 1 : 0;
                    while (true) {
                        onpostmessage.a = i21;
                        if (onpostmessage.a >= i7) {
                            break;
                        }
                        cArr3[onpostmessage.a] = (char) (cArr3[onpostmessage.a] - iArr[2]);
                        i21 = onpostmessage.a + 1;
                    }
                }
                objArr[0] = new String(cArr3);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r10v112, types: [int] */
            /* JADX WARN: Type inference failed for: r13v93, types: [int] */
            /* JADX WARN: Type inference failed for: r3v99, types: [java.lang.Object, java.lang.Throwable] */
            /* JADX WARN: Type inference failed for: r6v0 */
            /* JADX WARN: Type inference failed for: r6v35 */
            /* JADX WARN: Type inference failed for: r6v5, types: [boolean, int] */
            /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
                java.util.NoSuchElementException
                	at java.base/java.util.TreeMap.key(Unknown Source)
                	at java.base/java.util.TreeMap.lastKey(Unknown Source)
                	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
                	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
                	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
                */
            public static java.lang.Object[] accessartificialFrame(android.content.Context r24, int r25, int r26) {
                /*
                    Method dump skipped, instruction units count: 3146
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.gamingservices.cloudgaming.GameFeaturesLibrary.AnonymousClass1.accessartificialFrame(android.content.Context, int, int):java.lang.Object[]");
            }
        }, SDKMessageEnum.PERFORM_HAPTIC_FEEDBACK_ASYNC);
    }
}
