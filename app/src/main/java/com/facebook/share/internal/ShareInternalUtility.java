package com.facebook.share.internal;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.appcompat.app.AppCompatDelegate;
import ch.qos.logback.core.CoreConstants;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookGraphResponseException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.NativeAppCallAttachmentStore;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.share.Sharer;
import com.facebook.share.model.CameraEffectTextures;
import com.facebook.share.model.ShareCameraEffectContent;
import com.facebook.share.model.ShareMedia;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareStoryContent;
import com.facebook.share.model.ShareVideo;
import com.facebook.share.model.ShareVideoContent;
import com.google.common.base.Ascii;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import o.ArtificialStackFrames;
import o.artificialFrame;
import o.build;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class ShareInternalUtility {
    public static final ShareInternalUtility INSTANCE = new ShareInternalUtility();
    public static final String MY_STAGING_RESOURCES = "me/staging_resources";
    public static final String STAGING_PARAM = "file";

    private ShareInternalUtility() {
    }

    @JvmStatic
    public static final void invokeCallbackWithException(@Nullable FacebookCallback<Sharer.Result> facebookCallback, @NotNull Exception exception) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        if (exception instanceof FacebookException) {
            invokeOnErrorCallback(facebookCallback, (FacebookException) exception);
            return;
        }
        invokeCallbackWithError(facebookCallback, "Error preparing share content: " + exception.getLocalizedMessage());
    }

    @JvmStatic
    public static final void invokeCallbackWithError(@Nullable FacebookCallback<Sharer.Result> facebookCallback, @Nullable String str) {
        invokeOnErrorCallback(facebookCallback, str);
    }

    @JvmStatic
    public static final void invokeCallbackWithResults(@Nullable FacebookCallback<Sharer.Result> facebookCallback, @Nullable String str, @NotNull GraphResponse graphResponse) {
        Intrinsics.checkNotNullParameter(graphResponse, "graphResponse");
        FacebookRequestError error = graphResponse.getError();
        if (error != null) {
            String errorMessage = error.getErrorMessage();
            if (Utility.isNullOrEmpty(errorMessage)) {
                errorMessage = "Unexpected error sharing.";
            }
            invokeOnErrorCallback(facebookCallback, graphResponse, errorMessage);
            return;
        }
        invokeOnSuccessCallback(facebookCallback, str);
    }

    @JvmStatic
    public static final String getNativeDialogCompletionGesture(@NotNull Bundle result) {
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.containsKey(NativeProtocol.RESULT_ARGS_DIALOG_COMPLETION_GESTURE_KEY)) {
            return result.getString(NativeProtocol.RESULT_ARGS_DIALOG_COMPLETION_GESTURE_KEY);
        }
        return result.getString(NativeProtocol.EXTRA_DIALOG_COMPLETION_GESTURE_KEY);
    }

    @JvmStatic
    public static final String getShareDialogPostId(@NotNull Bundle result) {
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.containsKey(ShareConstants.RESULT_POST_ID)) {
            return result.getString(ShareConstants.RESULT_POST_ID);
        }
        if (result.containsKey(ShareConstants.EXTRA_RESULT_POST_ID)) {
            return result.getString(ShareConstants.EXTRA_RESULT_POST_ID);
        }
        return result.getString(ShareConstants.WEB_DIALOG_RESULT_PARAM_POST_ID);
    }

    @JvmStatic
    public static final boolean handleActivityResult(int i, int i2, @Nullable Intent intent, @Nullable ResultProcessor resultProcessor) {
        AppCall appCallFromActivityResult = INSTANCE.getAppCallFromActivityResult(i, i2, intent);
        if (appCallFromActivityResult == null) {
            return false;
        }
        NativeAppCallAttachmentStore.cleanupAttachmentsForCall(appCallFromActivityResult.getCallId());
        if (resultProcessor == null) {
            return true;
        }
        FacebookException exceptionFromErrorData = intent != null ? NativeProtocol.getExceptionFromErrorData(NativeProtocol.getErrorDataFromResultIntent(intent)) : null;
        if (exceptionFromErrorData != null) {
            if (exceptionFromErrorData instanceof FacebookOperationCanceledException) {
                resultProcessor.onCancel(appCallFromActivityResult);
            } else {
                resultProcessor.onError(appCallFromActivityResult, exceptionFromErrorData);
            }
        } else {
            resultProcessor.onSuccess(appCallFromActivityResult, intent != null ? NativeProtocol.getSuccessResultsFromIntent(intent) : null);
        }
        return true;
    }

    @JvmStatic
    public static final ResultProcessor getShareResultProcessor(@Nullable FacebookCallback<Sharer.Result> facebookCallback) {
        return new ResultProcessor(facebookCallback) { // from class: com.facebook.share.internal.ShareInternalUtility.getShareResultProcessor.1
            final /* synthetic */ FacebookCallback<Sharer.Result> $callback;
            private static final byte[] $$c = {70, -105, 85, -56};
            private static final int $$d = 114;
            private static int $10 = 0;
            private static int $11 = 1;
            private static final byte[] $$a = {122, -14, -75, -84, -12, -6, Ascii.ESC, -22, -26, 4, -12, 0, -8, -2, -8};
            private static final int $$b = 33;
            private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
            private static int artificialFrame = 1;
            private static char TopicBuilder = 44871;
            private static char ICustomTabsCallback = 52001;
            private static char extraCallbackWithResult = 4211;
            private static char onMessageChannelReady = 50488;
            private static int[] ICustomTabsCallbackStub = {280956684, -177172911, -1685438685, 1700752118, 248996875, -1939466161, 455224789, -723696167, 1626239962, 826553751, 1676882289, 1515376850, 1597635565, -1093239611, -1229000407, 934095830, 1004762482, -1124413562};

            /* JADX WARN: Code duplicated, block: B:10:0x0025  */
            /* JADX WARN: Code duplicated, block: B:8:0x001f  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x002a). Please report as a decompilation issue!!! */
            /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0025
                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                */
            private static java.lang.String $$e(int r6, short r7, byte r8) {
                /*
                    int r8 = r8 * 2
                    int r0 = 1 - r8
                    int r7 = 115 - r7
                    int r6 = r6 * 4
                    int r6 = r6 + 4
                    byte[] r1 = com.facebook.share.internal.ShareInternalUtility.AnonymousClass1.$$c
                    byte[] r0 = new byte[r0]
                    r2 = 0
                    int r8 = 0 - r8
                    if (r1 != 0) goto L17
                    r7 = r6
                    r3 = r8
                    r4 = r2
                    goto L2a
                L17:
                    r3 = r2
                L18:
                    byte r4 = (byte) r7
                    r0[r3] = r4
                    int r4 = r3 + 1
                    if (r3 != r8) goto L25
                    java.lang.String r6 = new java.lang.String
                    r6.<init>(r0, r2)
                    return r6
                L25:
                    r3 = r1[r6]
                    r5 = r7
                    r7 = r6
                    r6 = r5
                L2a:
                    int r6 = r6 + r3
                    int r7 = r7 + 1
                    r3 = r4
                    r5 = r7
                    r7 = r6
                    r6 = r5
                    goto L18
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.share.internal.ShareInternalUtility.AnonymousClass1.$$e(int, short, byte):java.lang.String");
            }

            /* JADX WARN: Code duplicated, block: B:10:0x002a  */
            /* JADX WARN: Code duplicated, block: B:8:0x0022  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x0031). Please report as a decompilation issue!!! */
            /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x002a
                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                */
            private static void b(short r6, byte r7, byte r8, java.lang.Object[] r9) {
                /*
                    int r8 = r8 * 5
                    int r0 = r8 + 4
                    byte[] r1 = com.facebook.share.internal.ShareInternalUtility.AnonymousClass1.$$a
                    int r6 = r6 * 8
                    int r6 = r6 + 4
                    int r7 = r7 * 3
                    int r7 = 115 - r7
                    byte[] r0 = new byte[r0]
                    int r8 = r8 + 3
                    r2 = 0
                    if (r1 != 0) goto L19
                    r7 = r6
                    r4 = r8
                    r3 = r2
                    goto L31
                L19:
                    r3 = r2
                L1a:
                    r5 = r7
                    r7 = r6
                    r6 = r5
                    byte r4 = (byte) r6
                    r0[r3] = r4
                    if (r3 != r8) goto L2a
                    java.lang.String r6 = new java.lang.String
                    r6.<init>(r0, r2)
                    r9[r2] = r6
                    return
                L2a:
                    int r3 = r3 + 1
                    r4 = r1[r7]
                    r5 = r7
                    r7 = r6
                    r6 = r5
                L31:
                    int r4 = -r4
                    int r6 = r6 + 1
                    int r7 = r7 + r4
                    int r7 = r7 + (-7)
                    goto L1a
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.share.internal.ShareInternalUtility.AnonymousClass1.b(short, byte, byte, java.lang.Object[]):void");
            }

            private static void a(int i, char[] cArr, Object[] objArr) throws Throwable {
                int i2 = 2 % 2;
                build buildVar = new build();
                char[] cArr2 = new char[cArr.length];
                int i3 = 0;
                buildVar.c = 0;
                char[] cArr3 = new char[2];
                while (buildVar.c < cArr.length) {
                    int i4 = $11 + 53;
                    $10 = i4 % 128;
                    int i5 = i4 % 2;
                    cArr3[i3] = cArr[buildVar.c];
                    cArr3[1] = cArr[buildVar.c + 1];
                    int i6 = 58224;
                    int i7 = i3;
                    while (i7 < 16) {
                        int i8 = $10 + 107;
                        $11 = i8 % 128;
                        int i9 = i8 % 2;
                        char c = cArr3[1];
                        char c2 = cArr3[i3];
                        int i10 = (c2 + i6) ^ ((c2 << 4) + ((char) (((long) extraCallbackWithResult) ^ (-4408183324873663413L))));
                        int i11 = c2 >>> 5;
                        try {
                            Object[] objArr2 = new Object[4];
                            objArr2[3] = Integer.valueOf(onMessageChannelReady);
                            objArr2[2] = Integer.valueOf(i11);
                            objArr2[1] = Integer.valueOf(i10);
                            objArr2[i3] = Integer.valueOf(c);
                            Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1585798252);
                            if (objAccessartificialFrame == null) {
                                int jumpTapTimeout = (ViewConfiguration.getJumpTapTimeout() >> 16) + 28;
                                char scrollBarSize = (char) ((ViewConfiguration.getScrollBarSize() >> 8) + 17263);
                                int touchSlop = 1067 - (ViewConfiguration.getTouchSlop() >> 8);
                                byte b = (byte) i3;
                                String str$$e = $$e(b, (byte) (b | 7), b);
                                Class[] clsArr = new Class[4];
                                clsArr[i3] = Integer.TYPE;
                                clsArr[1] = Integer.TYPE;
                                clsArr[2] = Integer.TYPE;
                                clsArr[3] = Integer.TYPE;
                                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(jumpTapTimeout, scrollBarSize, touchSlop, 1042277788, false, str$$e, clsArr);
                            }
                            char cCharValue = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                            cArr3[1] = cCharValue;
                            char[] cArr4 = cArr3;
                            Object[] objArr3 = {Integer.valueOf(cArr3[i3]), Integer.valueOf((cCharValue + i6) ^ ((cCharValue << 4) + ((char) (((long) TopicBuilder) ^ (-4408183324873663413L))))), Integer.valueOf(cCharValue >>> 5), Integer.valueOf(ICustomTabsCallback)};
                            Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1585798252);
                            if (objAccessartificialFrame2 == null) {
                                byte b2 = (byte) 0;
                                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation((Process.myTid() >> 22) + 28, (char) (17263 - TextUtils.getOffsetBefore("", 0)), View.getDefaultSize(0, 0) + 1067, 1042277788, false, $$e(b2, (byte) (b2 | 7), b2), new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE});
                            }
                            cArr4[0] = ((Character) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).charValue();
                            i6 -= 40503;
                            i7++;
                            cArr3 = cArr4;
                            i3 = 0;
                        } catch (Throwable th) {
                            Throwable cause = th.getCause();
                            if (cause == null) {
                                throw th;
                            }
                            throw cause;
                        }
                    }
                    char[] cArr5 = cArr3;
                    cArr2[buildVar.c] = cArr5[0];
                    cArr2[buildVar.c + 1] = cArr5[1];
                    Object[] objArr4 = {buildVar, buildVar};
                    Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1010141908);
                    if (objAccessartificialFrame3 == null) {
                        byte b3 = (byte) 0;
                        byte b4 = (byte) (b3 + 5);
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getEdgeSlop() >> 16) + 25, (char) ((ViewConfiguration.getJumpTapTimeout() >> 16) + 63928), ImageFormat.getBitsPerPixel(0) + 487, 1554985764, false, $$e(b3, b4, (byte) (b4 - 5)), new Class[]{Object.class, Object.class});
                    }
                    ((Method) objAccessartificialFrame3).invoke(null, objArr4);
                    cArr3 = cArr5;
                    i3 = 0;
                }
                objArr[0] = new String(cArr2, 0, i);
            }

            private static void c(int i, int[] iArr, Object[] objArr) throws Throwable {
                int length;
                int[] iArr2;
                int i2;
                int i3 = 2;
                int i4 = 2 % 2;
                artificialFrame artificialframe = new artificialFrame();
                char[] cArr = new char[4];
                char[] cArr2 = new char[iArr.length * 2];
                int[] iArr3 = ICustomTabsCallbackStub;
                int i5 = -1780896814;
                int i6 = 16;
                int i7 = 1;
                int i8 = 0;
                if (iArr3 != null) {
                    int i9 = $11 + 7;
                    $10 = i9 % 128;
                    if (i9 % 2 != 0) {
                        length = iArr3.length;
                        iArr2 = new int[length];
                        i2 = 1;
                    } else {
                        length = iArr3.length;
                        iArr2 = new int[length];
                        i2 = 0;
                    }
                    while (i2 < length) {
                        int i10 = $11 + AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
                        $10 = i10 % 128;
                        if (i10 % i3 != 0) {
                            try {
                                Object[] objArr2 = {Integer.valueOf(iArr3[i2])};
                                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(i5);
                                if (objAccessartificialFrame == null) {
                                    byte b = (byte) 0;
                                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(Color.red(0) + 11, (char) (ViewConfiguration.getKeyRepeatTimeout() >> i6), 1562 - TextUtils.getCapsMode("", 0, 0), 180153818, false, $$e(b, (byte) (b | 6), b), new Class[]{Integer.TYPE});
                                }
                                iArr2[i2] = ((Integer) ((Method) objAccessartificialFrame).invoke(null, objArr2)).intValue();
                            } catch (Throwable th) {
                                Throwable cause = th.getCause();
                                if (cause == null) {
                                    throw th;
                                }
                                throw cause;
                            }
                        } else {
                            try {
                                Object[] objArr3 = {Integer.valueOf(iArr3[i2])};
                                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1780896814);
                                if (objAccessartificialFrame2 == null) {
                                    byte b2 = (byte) 0;
                                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(View.getDefaultSize(0, 0) + 11, (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 1), 1562 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), 180153818, false, $$e(b2, (byte) (b2 | 6), b2), new Class[]{Integer.TYPE});
                                }
                                iArr2[i2] = ((Integer) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).intValue();
                                i2++;
                            } catch (Throwable th2) {
                                Throwable cause2 = th2.getCause();
                                if (cause2 == null) {
                                    throw th2;
                                }
                                throw cause2;
                            }
                        }
                        i3 = 2;
                        i5 = -1780896814;
                        i6 = 16;
                    }
                    iArr3 = iArr2;
                }
                int length2 = iArr3.length;
                int[] iArr4 = new int[length2];
                int[] iArr5 = ICustomTabsCallbackStub;
                if (iArr5 != null) {
                    int length3 = iArr5.length;
                    int[] iArr6 = new int[length3];
                    int i11 = 0;
                    while (i11 < length3) {
                        try {
                            Object[] objArr4 = new Object[i7];
                            objArr4[i8] = Integer.valueOf(iArr5[i11]);
                            Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1780896814);
                            if (objAccessartificialFrame3 == null) {
                                byte b3 = (byte) i8;
                                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 10, (char) (ViewConfiguration.getTouchSlop() >> 8), ((byte) KeyEvent.getModifierMetaStateMask()) + Ascii.ESC, 180153818, false, $$e(b3, (byte) (b3 | 6), b3), new Class[]{Integer.TYPE});
                            }
                            iArr6[i11] = ((Integer) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).intValue();
                            i11++;
                            i7 = 1;
                            i8 = 0;
                        } catch (Throwable th3) {
                            Throwable cause3 = th3.getCause();
                            if (cause3 == null) {
                                throw th3;
                            }
                            throw cause3;
                        }
                    }
                    iArr5 = iArr6;
                }
                int i12 = i8;
                System.arraycopy(iArr5, i12, iArr4, i12, length2);
                artificialframe.e = i12;
                while (artificialframe.e < iArr.length) {
                    cArr[i12] = (char) (iArr[artificialframe.e] >> 16);
                    cArr[1] = (char) iArr[artificialframe.e];
                    cArr[2] = (char) (iArr[artificialframe.e + 1] >> 16);
                    cArr[3] = (char) iArr[artificialframe.e + 1];
                    artificialframe.c = (cArr[0] << 16) + cArr[1];
                    artificialframe.b = (cArr[2] << 16) + cArr[3];
                    artificialFrame.coroutineBoundary(iArr4);
                    int i13 = 0;
                    for (int i14 = 16; i13 < i14; i14 = 16) {
                        int i15 = $11 + 11;
                        $10 = i15 % 128;
                        if (i15 % 2 != 0) {
                            artificialframe.c ^= iArr4[i13];
                            Object[] objArr5 = {artificialframe, Integer.valueOf(artificialFrame.coroutineBoundary(artificialframe.c)), artificialframe, artificialframe};
                            Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1540318455);
                            if (objAccessartificialFrame4 == null) {
                                byte b4 = (byte) 0;
                                byte b5 = b4;
                                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(Color.blue(0) + 26, (char) (MotionEvent.axisFromString("") + 1), 1041 - (ViewConfiguration.getLongPressTimeout() >> 16), 995482881, false, $$e(b4, b5, b5), new Class[]{Object.class, Integer.TYPE, Object.class, Object.class});
                            }
                            int iIntValue = ((Integer) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).intValue();
                            artificialframe.c = artificialframe.b;
                            artificialframe.b = iIntValue;
                            i13 += 29;
                        } else {
                            artificialframe.c ^= iArr4[i13];
                            Object[] objArr6 = {artificialframe, Integer.valueOf(artificialFrame.coroutineBoundary(artificialframe.c)), artificialframe, artificialframe};
                            Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1540318455);
                            if (objAccessartificialFrame5 == null) {
                                byte b6 = (byte) 0;
                                byte b7 = b6;
                                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(26 - ExpandableListView.getPackedPositionGroup(0L), (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0, 0)), (ViewConfiguration.getScrollBarSize() >> 8) + 1041, 995482881, false, $$e(b6, b7, b7), new Class[]{Object.class, Integer.TYPE, Object.class, Object.class});
                            }
                            int iIntValue2 = ((Integer) ((Method) objAccessartificialFrame5).invoke(null, objArr6)).intValue();
                            artificialframe.c = artificialframe.b;
                            artificialframe.b = iIntValue2;
                            i13++;
                        }
                    }
                    int i16 = artificialframe.c;
                    artificialframe.c = artificialframe.b;
                    artificialframe.b = i16;
                    artificialframe.b ^= iArr4[16];
                    artificialframe.c ^= iArr4[17];
                    int i17 = artificialframe.c;
                    int i18 = artificialframe.b;
                    cArr[0] = (char) (artificialframe.c >>> 16);
                    cArr[1] = (char) artificialframe.c;
                    cArr[2] = (char) (artificialframe.b >>> 16);
                    cArr[3] = (char) artificialframe.b;
                    artificialFrame.coroutineBoundary(iArr4);
                    cArr2[artificialframe.e * 2] = cArr[0];
                    cArr2[(artificialframe.e * 2) + 1] = cArr[1];
                    cArr2[(artificialframe.e * 2) + 2] = cArr[2];
                    cArr2[(artificialframe.e * 2) + 3] = cArr[3];
                    Object[] objArr7 = {artificialframe, artificialframe};
                    Object objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(1348396126);
                    if (objAccessartificialFrame6 == null) {
                        objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getKeyRepeatDelay() >> 16) + 37, (char) ((ViewConfiguration.getMinimumFlingVelocity() >> 16) + 28010), (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 305, -818175402, false, "q", new Class[]{Object.class, Object.class});
                    }
                    ((Method) objAccessartificialFrame6).invoke(null, objArr7);
                    i12 = 0;
                }
                objArr[0] = new String(cArr2, 0, i);
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(facebookCallback);
                this.$callback = facebookCallback;
            }

            @Override // com.facebook.share.internal.ResultProcessor
            public void onSuccess(@NotNull AppCall appCall, @Nullable Bundle bundle) {
                Intrinsics.checkNotNullParameter(appCall, "appCall");
                if (bundle != null) {
                    String nativeDialogCompletionGesture = ShareInternalUtility.getNativeDialogCompletionGesture(bundle);
                    if (nativeDialogCompletionGesture == null || StringsKt__StringsJVMKt.equals("post", nativeDialogCompletionGesture, true)) {
                        ShareInternalUtility.invokeOnSuccessCallback(this.$callback, ShareInternalUtility.getShareDialogPostId(bundle));
                    } else if (StringsKt__StringsJVMKt.equals("cancel", nativeDialogCompletionGesture, true)) {
                        ShareInternalUtility.invokeOnCancelCallback(this.$callback);
                    } else {
                        ShareInternalUtility.invokeOnErrorCallback(this.$callback, new FacebookException(NativeProtocol.ERROR_UNKNOWN_ERROR));
                    }
                }
            }

            @Override // com.facebook.share.internal.ResultProcessor
            public void onCancel(@NotNull AppCall appCall) {
                Intrinsics.checkNotNullParameter(appCall, "appCall");
                ShareInternalUtility.invokeOnCancelCallback(this.$callback);
            }

            @Override // com.facebook.share.internal.ResultProcessor
            public void onError(@NotNull AppCall appCall, @NotNull FacebookException error) {
                Intrinsics.checkNotNullParameter(appCall, "appCall");
                Intrinsics.checkNotNullParameter(error, "error");
                ShareInternalUtility.invokeOnErrorCallback(this.$callback, error);
            }

            /*  JADX ERROR: Type inference failed
                jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 151141. Try increasing type updates limit count.
                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
                */
            public static java.lang.Object[] accessartificialFrame(android.content.Context r41, java.lang.String[] r42, int r43, int r44, int r45) {
                /*
                    Method dump skipped, instruction units count: 15114
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.share.internal.ShareInternalUtility.AnonymousClass1.accessartificialFrame(android.content.Context, java.lang.String[], int, int, int):java.lang.Object[]");
            }
        };
    }

    private final AppCall getAppCallFromActivityResult(int i, int i2, Intent intent) {
        UUID callIdFromIntent = NativeProtocol.getCallIdFromIntent(intent);
        if (callIdFromIntent == null) {
            return null;
        }
        return AppCall.Companion.finishPendingCall(callIdFromIntent, i);
    }

    @JvmStatic
    public static final void registerStaticShareCallback(final int i) {
        CallbackManagerImpl.Companion.registerStaticCallback(i, new CallbackManagerImpl.Callback() { // from class: com.facebook.share.internal.ShareInternalUtility$$ExternalSyntheticLambda1
            @Override // com.facebook.internal.CallbackManagerImpl.Callback
            public final boolean onActivityResult(int i2, Intent intent) {
                return ShareInternalUtility.registerStaticShareCallback$lambda$0(i, i2, intent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean registerStaticShareCallback$lambda$0(int i, int i2, Intent intent) {
        return handleActivityResult(i, i2, intent, getShareResultProcessor(null));
    }

    @JvmStatic
    public static final void registerSharerCallback(final int i, @Nullable CallbackManager callbackManager, @Nullable final FacebookCallback<Sharer.Result> facebookCallback) {
        if (!(callbackManager instanceof CallbackManagerImpl)) {
            throw new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
        }
        ((CallbackManagerImpl) callbackManager).registerCallback(i, new CallbackManagerImpl.Callback() { // from class: com.facebook.share.internal.ShareInternalUtility$$ExternalSyntheticLambda0
            @Override // com.facebook.internal.CallbackManagerImpl.Callback
            public final boolean onActivityResult(int i2, Intent intent) {
                return ShareInternalUtility.registerSharerCallback$lambda$1(i, facebookCallback, i2, intent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean registerSharerCallback$lambda$1(int i, FacebookCallback facebookCallback, int i2, Intent intent) {
        return handleActivityResult(i, i2, intent, getShareResultProcessor(facebookCallback));
    }

    @JvmStatic
    public static final List<String> getPhotoUrls(@Nullable SharePhotoContent sharePhotoContent, @NotNull UUID appCallId) {
        List<SharePhoto> photos;
        Intrinsics.checkNotNullParameter(appCallId, "appCallId");
        if (sharePhotoContent == null || (photos = sharePhotoContent.getPhotos()) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it2 = photos.iterator();
        while (it2.hasNext()) {
            NativeAppCallAttachmentStore.Attachment attachment = INSTANCE.getAttachment(appCallId, (SharePhoto) it2.next());
            if (attachment != null) {
                arrayList.add(attachment);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            arrayList2.add(((NativeAppCallAttachmentStore.Attachment) it3.next()).getAttachmentUrl());
        }
        NativeAppCallAttachmentStore.addAttachments(arrayList);
        return arrayList2;
    }

    @JvmStatic
    public static final String getVideoUrl(@Nullable ShareVideoContent shareVideoContent, @NotNull UUID appCallId) {
        ShareVideo video;
        Uri localUrl;
        Intrinsics.checkNotNullParameter(appCallId, "appCallId");
        if (shareVideoContent == null || (video = shareVideoContent.getVideo()) == null || (localUrl = video.getLocalUrl()) == null) {
            return null;
        }
        NativeAppCallAttachmentStore.Attachment attachmentCreateAttachment = NativeAppCallAttachmentStore.createAttachment(appCallId, localUrl);
        NativeAppCallAttachmentStore.addAttachments(CollectionsKt__CollectionsJVMKt.listOf(attachmentCreateAttachment));
        return attachmentCreateAttachment.getAttachmentUrl();
    }

    @JvmStatic
    public static final List<Bundle> getMediaInfos(@Nullable ShareMediaContent shareMediaContent, @NotNull UUID appCallId) {
        List<ShareMedia<?, ?>> media;
        Bundle bundle;
        Intrinsics.checkNotNullParameter(appCallId, "appCallId");
        if (shareMediaContent == null || (media = shareMediaContent.getMedia()) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (ShareMedia<?, ?> shareMedia : media) {
            NativeAppCallAttachmentStore.Attachment attachment = INSTANCE.getAttachment(appCallId, shareMedia);
            if (attachment == null) {
                bundle = null;
            } else {
                arrayList.add(attachment);
                bundle = new Bundle();
                bundle.putString("type", shareMedia.getMediaType().name());
                bundle.putString("uri", attachment.getAttachmentUrl());
            }
            if (bundle != null) {
                arrayList2.add(bundle);
            }
        }
        NativeAppCallAttachmentStore.addAttachments(arrayList);
        return arrayList2;
    }

    @JvmStatic
    public static final Bundle getTextureUrlBundle(@Nullable ShareCameraEffectContent shareCameraEffectContent, @NotNull UUID appCallId) {
        CameraEffectTextures textures;
        Intrinsics.checkNotNullParameter(appCallId, "appCallId");
        if (shareCameraEffectContent == null || (textures = shareCameraEffectContent.getTextures()) == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        ArrayList arrayList = new ArrayList();
        for (String str : textures.keySet()) {
            NativeAppCallAttachmentStore.Attachment attachment = INSTANCE.getAttachment(appCallId, textures.getTextureUri(str), textures.getTextureBitmap(str));
            if (attachment != null) {
                arrayList.add(attachment);
                bundle.putString(str, attachment.getAttachmentUrl());
            }
        }
        NativeAppCallAttachmentStore.addAttachments(arrayList);
        return bundle;
    }

    @JvmStatic
    public static final JSONArray removeNamespacesFromOGJsonArray(@NotNull JSONArray jsonArray, boolean z) throws JSONException {
        Intrinsics.checkNotNullParameter(jsonArray, "jsonArray");
        JSONArray jSONArray = new JSONArray();
        int length = jsonArray.length();
        for (int i = 0; i < length; i++) {
            Object objRemoveNamespacesFromOGJsonObject = jsonArray.get(i);
            if (objRemoveNamespacesFromOGJsonObject instanceof JSONArray) {
                objRemoveNamespacesFromOGJsonObject = removeNamespacesFromOGJsonArray((JSONArray) objRemoveNamespacesFromOGJsonObject, z);
            } else if (objRemoveNamespacesFromOGJsonObject instanceof JSONObject) {
                objRemoveNamespacesFromOGJsonObject = removeNamespacesFromOGJsonObject((JSONObject) objRemoveNamespacesFromOGJsonObject, z);
            }
            jSONArray.put(objRemoveNamespacesFromOGJsonObject);
        }
        return jSONArray;
    }

    @JvmStatic
    public static final JSONObject removeNamespacesFromOGJsonObject(@Nullable JSONObject jSONObject, boolean z) {
        if (jSONObject == null) {
            return null;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            JSONArray jSONArrayNames = jSONObject.names();
            if (jSONArrayNames == null) {
                return null;
            }
            int length = jSONArrayNames.length();
            for (int i = 0; i < length; i++) {
                String key = jSONArrayNames.getString(i);
                Object objRemoveNamespacesFromOGJsonArray = jSONObject.get(key);
                if (objRemoveNamespacesFromOGJsonArray instanceof JSONObject) {
                    objRemoveNamespacesFromOGJsonArray = removeNamespacesFromOGJsonObject((JSONObject) objRemoveNamespacesFromOGJsonArray, true);
                } else if (objRemoveNamespacesFromOGJsonArray instanceof JSONArray) {
                    objRemoveNamespacesFromOGJsonArray = removeNamespacesFromOGJsonArray((JSONArray) objRemoveNamespacesFromOGJsonArray, true);
                }
                Intrinsics.checkNotNullExpressionValue(key, "key");
                Pair<String, String> fieldNameAndNamespaceFromFullName = getFieldNameAndNamespaceFromFullName(key);
                String str = (String) fieldNameAndNamespaceFromFullName.first;
                String str2 = (String) fieldNameAndNamespaceFromFullName.second;
                if (z) {
                    if (str != null && Intrinsics.areEqual(str, DeviceRequestsHelper.SDK_HEADER)) {
                        jSONObject2.put(key, objRemoveNamespacesFromOGJsonArray);
                    } else if (str == null || Intrinsics.areEqual(str, "og")) {
                        jSONObject2.put(str2, objRemoveNamespacesFromOGJsonArray);
                    } else {
                        jSONObject3.put(str2, objRemoveNamespacesFromOGJsonArray);
                    }
                } else if (str != null && Intrinsics.areEqual(str, "fb")) {
                    jSONObject2.put(key, objRemoveNamespacesFromOGJsonArray);
                } else {
                    jSONObject2.put(str2, objRemoveNamespacesFromOGJsonArray);
                }
            }
            if (jSONObject3.length() > 0) {
                jSONObject2.put("data", jSONObject3);
            }
            return jSONObject2;
        } catch (JSONException unused) {
            throw new FacebookException("Failed to create json object from share content");
        }
    }

    @JvmStatic
    public static final Pair<String, String> getFieldNameAndNamespaceFromFullName(@NotNull String fullName) {
        String strSubstring;
        int i;
        Intrinsics.checkNotNullParameter(fullName, "fullName");
        int iIndexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) fullName, CoreConstants.COLON_CHAR, 0, false, 6, (Object) null);
        if (iIndexOf$default == -1 || fullName.length() <= (i = iIndexOf$default + 1)) {
            strSubstring = null;
        } else {
            strSubstring = fullName.substring(0, iIndexOf$default);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            fullName = fullName.substring(i);
            Intrinsics.checkNotNullExpressionValue(fullName, "this as java.lang.String).substring(startIndex)");
        }
        return new Pair<>(strSubstring, fullName);
    }

    private final NativeAppCallAttachmentStore.Attachment getAttachment(UUID uuid, ShareMedia<?, ?> shareMedia) {
        Uri localUrl;
        Bitmap bitmap;
        if (shareMedia instanceof SharePhoto) {
            SharePhoto sharePhoto = (SharePhoto) shareMedia;
            bitmap = sharePhoto.getBitmap();
            localUrl = sharePhoto.getImageUrl();
        } else if (shareMedia instanceof ShareVideo) {
            localUrl = ((ShareVideo) shareMedia).getLocalUrl();
            bitmap = null;
        } else {
            localUrl = null;
            bitmap = null;
        }
        return getAttachment(uuid, localUrl, bitmap);
    }

    private final NativeAppCallAttachmentStore.Attachment getAttachment(UUID uuid, Uri uri, Bitmap bitmap) {
        if (bitmap != null) {
            return NativeAppCallAttachmentStore.createAttachment(uuid, bitmap);
        }
        if (uri != null) {
            return NativeAppCallAttachmentStore.createAttachment(uuid, uri);
        }
        return null;
    }

    @JvmStatic
    public static final void invokeOnCancelCallback(@Nullable FacebookCallback<Sharer.Result> facebookCallback) {
        INSTANCE.logShareResult(AnalyticsEvents.PARAMETER_SHARE_OUTCOME_CANCELLED, null);
        if (facebookCallback != null) {
            facebookCallback.onCancel();
        }
    }

    @JvmStatic
    public static final void invokeOnSuccessCallback(@Nullable FacebookCallback<Sharer.Result> facebookCallback, @Nullable String str) {
        INSTANCE.logShareResult(AnalyticsEvents.PARAMETER_SHARE_OUTCOME_SUCCEEDED, null);
        if (facebookCallback != null) {
            facebookCallback.onSuccess(new Sharer.Result(str));
        }
    }

    @JvmStatic
    public static final void invokeOnErrorCallback(@Nullable FacebookCallback<Sharer.Result> facebookCallback, @Nullable GraphResponse graphResponse, @Nullable String str) {
        INSTANCE.logShareResult("error", str);
        if (facebookCallback != null) {
            facebookCallback.onError(new FacebookGraphResponseException(graphResponse, str));
        }
    }

    @JvmStatic
    public static final void invokeOnErrorCallback(@Nullable FacebookCallback<Sharer.Result> facebookCallback, @Nullable String str) {
        INSTANCE.logShareResult("error", str);
        if (facebookCallback != null) {
            facebookCallback.onError(new FacebookException(str));
        }
    }

    @JvmStatic
    public static final void invokeOnErrorCallback(@Nullable FacebookCallback<Sharer.Result> facebookCallback, @NotNull FacebookException ex) {
        Intrinsics.checkNotNullParameter(ex, "ex");
        INSTANCE.logShareResult("error", ex.getMessage());
        if (facebookCallback != null) {
            facebookCallback.onError(ex);
        }
    }

    private final void logShareResult(String str, String str2) {
        InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(FacebookSdk.getApplicationContext());
        Bundle bundle = new Bundle();
        bundle.putString(AnalyticsEvents.PARAMETER_SHARE_OUTCOME, str);
        if (str2 != null) {
            bundle.putString("error_message", str2);
        }
        internalAppEventsLogger.logEventImplicitly(AnalyticsEvents.EVENT_SHARE_RESULT, bundle);
    }

    @JvmStatic
    public static final GraphRequest newUploadStagingResourceWithImageRequest(@Nullable AccessToken accessToken, @Nullable Bitmap bitmap, @Nullable GraphRequest.Callback callback) {
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("file", bitmap);
        return new GraphRequest(accessToken, MY_STAGING_RESOURCES, bundle, HttpMethod.POST, callback, null, 32, null);
    }

    @JvmStatic
    public static final GraphRequest newUploadStagingResourceWithImageRequest(@Nullable AccessToken accessToken, @Nullable File file, @Nullable GraphRequest.Callback callback) throws FileNotFoundException {
        GraphRequest.ParcelableResourceWithMimeType parcelableResourceWithMimeType = new GraphRequest.ParcelableResourceWithMimeType(ParcelFileDescriptor.open(file, 268435456), "image/png");
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("file", parcelableResourceWithMimeType);
        return new GraphRequest(accessToken, MY_STAGING_RESOURCES, bundle, HttpMethod.POST, callback, null, 32, null);
    }

    @JvmStatic
    public static final GraphRequest newUploadStagingResourceWithImageRequest(@Nullable AccessToken accessToken, @NotNull Uri imageUri, @Nullable GraphRequest.Callback callback) throws FileNotFoundException {
        Intrinsics.checkNotNullParameter(imageUri, "imageUri");
        String path = imageUri.getPath();
        if (Utility.isFileUri(imageUri) && path != null) {
            return newUploadStagingResourceWithImageRequest(accessToken, new File(path), callback);
        }
        if (!Utility.isContentUri(imageUri)) {
            throw new FacebookException("The image Uri must be either a file:// or content:// Uri");
        }
        GraphRequest.ParcelableResourceWithMimeType parcelableResourceWithMimeType = new GraphRequest.ParcelableResourceWithMimeType(imageUri, "image/png");
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("file", parcelableResourceWithMimeType);
        return new GraphRequest(accessToken, MY_STAGING_RESOURCES, bundle, HttpMethod.POST, callback, null, 32, null);
    }

    @JvmStatic
    public static final Bundle getStickerUrl(@Nullable ShareStoryContent shareStoryContent, @NotNull UUID appCallId) {
        Intrinsics.checkNotNullParameter(appCallId, "appCallId");
        if (shareStoryContent == null || shareStoryContent.getStickerAsset() == null) {
            return null;
        }
        new ArrayList().add(shareStoryContent.getStickerAsset());
        NativeAppCallAttachmentStore.Attachment attachment = INSTANCE.getAttachment(appCallId, shareStoryContent.getStickerAsset());
        if (attachment == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("uri", attachment.getAttachmentUrl());
        String uriExtension = getUriExtension(attachment.getOriginalUri());
        if (uriExtension != null) {
            Utility.putNonEmptyString(bundle, ShareConstants.MEDIA_EXTENSION, uriExtension);
        }
        NativeAppCallAttachmentStore.addAttachments(CollectionsKt__CollectionsJVMKt.listOf(attachment));
        return bundle;
    }

    @JvmStatic
    public static final Bundle getBackgroundAssetMediaInfo(@Nullable ShareStoryContent shareStoryContent, @NotNull UUID appCallId) {
        Intrinsics.checkNotNullParameter(appCallId, "appCallId");
        Bundle bundle = null;
        if (shareStoryContent != null && shareStoryContent.getBackgroundAsset() != null) {
            ShareMedia<?, ?> backgroundAsset = shareStoryContent.getBackgroundAsset();
            NativeAppCallAttachmentStore.Attachment attachment = INSTANCE.getAttachment(appCallId, backgroundAsset);
            if (attachment == null) {
                return null;
            }
            bundle = new Bundle();
            bundle.putString("type", backgroundAsset.getMediaType().name());
            bundle.putString("uri", attachment.getAttachmentUrl());
            String uriExtension = getUriExtension(attachment.getOriginalUri());
            if (uriExtension != null) {
                Utility.putNonEmptyString(bundle, ShareConstants.MEDIA_EXTENSION, uriExtension);
            }
            NativeAppCallAttachmentStore.addAttachments(CollectionsKt__CollectionsJVMKt.listOf(attachment));
        }
        return bundle;
    }

    @JvmStatic
    public static final String getUriExtension(@Nullable Uri uri) {
        if (uri == null) {
            return null;
        }
        String string = uri.toString();
        Intrinsics.checkNotNullExpressionValue(string, "uri.toString()");
        int iLastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) string, '.', 0, false, 6, (Object) null);
        if (iLastIndexOf$default == -1) {
            return null;
        }
        String strSubstring = string.substring(iLastIndexOf$default);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
        return strSubstring;
    }
}
