package com.imagepicker;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.net.Uri;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.activity.result.PickVisualMediaRequest;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatDelegate;
import ch.qos.logback.core.net.SyslogConstants;
import com.facebook.imageutils.JfifUtil;
import com.facebook.imageutils.TiffUtil;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;
import com.google.crypto.tink.jwt.JwtRsaSsaPkcs1PrivateKey;
import com.salesforce.marketingcloud.analytics.stats.b;
import io.sentry.rrweb.RRWebVideoEvent;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import o.ArtificialStackFrames;
import o.onNavigationEvent;
import o.onPostMessage;
import org.apache.commons.lang3.CharUtils;

/* JADX INFO: loaded from: classes3.dex */
public class ImagePickerModuleImpl implements ActivityEventListener {
    static final String NAME = "ImagePicker";
    public static final int REQUEST_LAUNCH_IMAGE_CAPTURE = 13001;
    public static final int REQUEST_LAUNCH_LIBRARY = 13003;
    public static final int REQUEST_LAUNCH_VIDEO_CAPTURE = 13002;
    Callback callback;
    Uri cameraCaptureURI;
    private Uri fileUri;
    Options options;
    private ReactApplicationContext reactContext;
    private static final byte[] $$a = {44, 60, -60, 113};
    private static final int $$b = 123;
    private static int $10 = 0;
    private static int $11 = 1;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static int setDefaultImpl = -260894142;
    private static char[] IPostMessageService = {38207, 38074, 38077, 38211, 38059, 38041, 38039, 38034, 38038, 38044, 38208, 38224, 38062, 38047, 38039, 38036, 38073, 38213, 38076, 38211, 38059, 38041, 38039, 38034, 38038, 38044, 38074, 38219, 38210, 38073, 38062, 38284, 38363, 38361, 38360, 38365, 38375, 38365, 38355, 38361, 38355, 38356, 38361, 38363, 38360, 38360, 38376, 38374, 38285, 38374, 38376, 38360, 38358, 38361, 38361, 38355, 38365, 38375, 38365, 38360, 38361, 38363, 38387, 38188, 38190, 38191, 38173, 38285, 38356, 38348, 38347, 38357, 38360, 38357, 38359, 38369, 38399, 38386, 38353, 38384, 38382, 38350, 38358, 38355, 38350, 38353, 38358, 38391, 38390, 38361, 38355, 38351, 38356, 38358, 38360, 38385, 38178, 38187, 38183, 38174, 38179, 38204, 38199, 38174, 38184, 38337, 38285, 38355, 38357, 38365, 38361, 38360, 38360, 38353, 38348, 38356, 38379, 38379, 38355, 38357, 38358, 38356, 38358, 38358, 38361, 38291, 38393, 38285, 38287, 38399, 38366, 38354, 38356, 38359, 38361, 38355, 38359, 38361, 38358, 38361, 38355, 38364, 38363, 38356, 38361, 38360, 38363, 38356};

    /* JADX WARN: Code duplicated, block: B:10:0x0024  */
    /* JADX WARN: Code duplicated, block: B:8:0x001e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0024 -> B:11:0x0026). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0024
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$c(byte r6, short r7, short r8) {
        /*
            int r7 = r7 * 3
            int r7 = 1 - r7
            byte[] r0 = com.imagepicker.ImagePickerModuleImpl.$$a
            int r8 = 122 - r8
            int r6 = r6 * 4
            int r6 = 3 - r6
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L14
            r3 = r7
            r4 = r2
            goto L26
        L14:
            r3 = r2
        L15:
            int r6 = r6 + 1
            int r4 = r3 + 1
            byte r5 = (byte) r8
            r1[r3] = r5
            if (r4 != r7) goto L24
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            return r6
        L24:
            r3 = r0[r6]
        L26:
            int r3 = -r3
            int r8 = r8 + r3
            r3 = r4
            goto L15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.imagepicker.ImagePickerModuleImpl.$$c(byte, short, short):java.lang.String");
    }

    @Override // com.facebook.react.bridge.ActivityEventListener
    public void onNewIntent(Intent intent) {
    }

    public ImagePickerModuleImpl(ReactApplicationContext reactApplicationContext) {
        this.reactContext = reactApplicationContext;
        reactApplicationContext.addActivityEventListener(this);
    }

    public void launchCamera(ReadableMap readableMap, Callback callback) {
        Intent intent;
        File fileCreateFile;
        int i;
        if (!Utils.isCameraAvailable(this.reactContext)) {
            callback.invoke(Utils.getErrorMap(Utils.errCameraUnavailable, null));
            return;
        }
        Activity currentActivity = this.reactContext.getCurrentActivity();
        if (currentActivity == null) {
            callback.invoke(Utils.getErrorMap(Utils.errOthers, "Activity error"));
            return;
        }
        if (!Utils.isCameraPermissionFulfilled(this.reactContext, currentActivity)) {
            callback.invoke(Utils.getErrorMap(Utils.errOthers, Utils.cameraPermissionDescription));
            return;
        }
        this.callback = callback;
        Options options = new Options(readableMap);
        this.options = options;
        if (options.saveToPhotos.booleanValue() && Build.VERSION.SDK_INT <= 28 && !Utils.hasPermission(currentActivity)) {
            callback.invoke(Utils.getErrorMap(Utils.errPermission, null));
            return;
        }
        if (this.options.mediaType.equals(Utils.mediaTypeVideo)) {
            intent = new Intent("android.media.action.VIDEO_CAPTURE");
            intent.putExtra("android.intent.extra.videoQuality", this.options.videoQuality);
            int i2 = this.options.durationLimit;
            if (i2 > 0) {
                intent.putExtra("android.intent.extra.durationLimit", i2);
            }
            fileCreateFile = Utils.createFile(this.reactContext, RRWebVideoEvent.REPLAY_CONTAINER);
            this.cameraCaptureURI = Utils.createUri(fileCreateFile, this.reactContext);
            i = REQUEST_LAUNCH_VIDEO_CAPTURE;
        } else {
            intent = new Intent("android.media.action.IMAGE_CAPTURE");
            fileCreateFile = Utils.createFile(this.reactContext, "jpg");
            this.cameraCaptureURI = Utils.createUri(fileCreateFile, this.reactContext);
            i = REQUEST_LAUNCH_IMAGE_CAPTURE;
        }
        if (this.options.useFrontCamera.booleanValue()) {
            Utils.setFrontCamera(intent);
        }
        this.fileUri = Uri.fromFile(fileCreateFile);
        intent.putExtra("output", this.cameraCaptureURI);
        intent.addFlags(3);
        try {
            currentActivity.startActivityForResult(intent, i);
        } catch (ActivityNotFoundException e) {
            callback.invoke(Utils.getErrorMap(Utils.errOthers, e.getMessage()));
            this.callback = null;
        }
    }

    public void launchImageLibrary(ReadableMap readableMap, Callback callback) {
        ActivityResultContracts.PickVisualMedia.VisualMediaType visualMediaType;
        ActivityResultContracts.PickMultipleVisualMedia pickMultipleVisualMedia;
        Intent intentCreateIntent2;
        Activity currentActivity = this.reactContext.getCurrentActivity();
        if (currentActivity == null) {
            callback.invoke(Utils.getErrorMap(Utils.errOthers, "Activity error"));
            return;
        }
        this.callback = callback;
        Options options = new Options(readableMap);
        this.options = options;
        int i = options.selectionLimit;
        boolean z = i == 1;
        boolean zEquals = options.mediaType.equals(Utils.mediaTypePhoto);
        boolean zEquals2 = this.options.mediaType.equals(Utils.mediaTypeVideo);
        if (zEquals) {
            visualMediaType = ActivityResultContracts.PickVisualMedia.ImageOnly.INSTANCE;
        } else if (zEquals2) {
            visualMediaType = ActivityResultContracts.PickVisualMedia.VideoOnly.INSTANCE;
        } else {
            visualMediaType = ActivityResultContracts.PickVisualMedia.ImageAndVideo.INSTANCE;
        }
        PickVisualMediaRequest pickVisualMediaRequestBuild = new PickVisualMediaRequest.Builder().setMediaType(visualMediaType).build();
        if (z) {
            intentCreateIntent2 = new ActivityResultContracts.PickVisualMedia().createIntent(this.reactContext.getApplicationContext(), pickVisualMediaRequestBuild);
        } else {
            if (i > 1) {
                pickMultipleVisualMedia = new ActivityResultContracts.PickMultipleVisualMedia(i);
            } else {
                pickMultipleVisualMedia = new ActivityResultContracts.PickMultipleVisualMedia();
            }
            intentCreateIntent2 = pickMultipleVisualMedia.createIntent(this.reactContext.getApplicationContext(), pickVisualMediaRequestBuild);
        }
        try {
            currentActivity.startActivityForResult(intentCreateIntent2, REQUEST_LAUNCH_LIBRARY);
        } catch (ActivityNotFoundException e) {
            callback.invoke(Utils.getErrorMap(Utils.errOthers, e.getMessage()));
            this.callback = null;
        }
    }

    private static void a(boolean z, int i, int i2, int i3, char[] cArr, Object[] objArr) throws Throwable {
        int i4 = 2 % 2;
        onNavigationEvent onnavigationevent = new onNavigationEvent();
        char[] cArr2 = new char[i3];
        onnavigationevent.d = 0;
        int i5 = $11 + 13;
        $10 = i5 % 128;
        int i6 = i5 % 2;
        while (onnavigationevent.d < i3) {
            onnavigationevent.c = cArr[onnavigationevent.d];
            cArr2[onnavigationevent.d] = (char) (i2 + onnavigationevent.c);
            int i7 = onnavigationevent.d;
            try {
                Object[] objArr2 = {Integer.valueOf(cArr2[i7]), Integer.valueOf(setDefaultImpl)};
                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(465886069);
                if (objAccessartificialFrame == null) {
                    byte b = (byte) 0;
                    byte b2 = b;
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getLongPressTimeout() >> 16) + 22, (char) View.getDefaultSize(0, 0), TextUtils.getTrimmedLength("") + 1775, -2069783171, false, $$c(b, b2, (byte) (b2 | 8)), new Class[]{Integer.TYPE, Integer.TYPE});
                }
                cArr2[i7] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                Object[] objArr3 = {onnavigationevent, onnavigationevent};
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1257606387);
                if (objAccessartificialFrame2 == null) {
                    byte b3 = (byte) 0;
                    byte b4 = b3;
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(Color.blue(0) + 37, (char) (View.MeasureSpec.makeMeasureSpec(0, 0) + 56277), (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 1259, 711931141, false, $$c(b3, b4, (byte) (b4 | 6)), new Class[]{Object.class, Object.class});
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
            int i8 = $11 + 7;
            $10 = i8 % 128;
            int i9 = i8 % 2;
            onnavigationevent.b = i;
            char[] cArr3 = new char[i3];
            System.arraycopy(cArr2, 0, cArr3, 0, i3);
            System.arraycopy(cArr3, 0, cArr2, i3 - onnavigationevent.b, onnavigationevent.b);
            System.arraycopy(cArr3, onnavigationevent.b, cArr2, 0, i3 - onnavigationevent.b);
        }
        if (z) {
            char[] cArr4 = new char[i3];
            onnavigationevent.d = 0;
            while (onnavigationevent.d < i3) {
                cArr4[onnavigationevent.d] = cArr2[(i3 - onnavigationevent.d) - 1];
                Object[] objArr4 = {onnavigationevent, onnavigationevent};
                Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1257606387);
                if (objAccessartificialFrame3 == null) {
                    byte b5 = (byte) 0;
                    byte b6 = b5;
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getFadingEdgeLength() >> 16) + 37, (char) ((ViewConfiguration.getLongPressTimeout() >> 16) + 56277), 1260 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), 711931141, false, $$c(b5, b6, (byte) (b6 | 6)), new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame3).invoke(null, objArr4);
            }
            cArr2 = cArr4;
        }
        objArr[0] = new String(cArr2);
    }

    void onAssetsObtained(final List<Uri> list) {
        Executors.newSingleThreadExecutor().submit(new Runnable() { // from class: com.imagepicker.ImagePickerModuleImpl$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onAssetsObtained$0(list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onAssetsObtained$0(List list) {
        try {
            try {
                this.callback.invoke(Utils.getResponseMap(list, this.options, this.reactContext));
            } catch (RuntimeException e) {
                this.callback.invoke(Utils.getErrorMap(Utils.errOthers, e.getMessage()));
            }
        } finally {
            this.callback = null;
        }
    }

    @Override // com.facebook.react.bridge.ActivityEventListener
    public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
        if (!Utils.isValidRequestCode(i) || this.callback == null) {
            return;
        }
        if (i2 != -1) {
            if (i == 13001) {
                Utils.deleteFile(this.fileUri);
            }
            try {
                try {
                    this.callback.invoke(Utils.getCancelMap());
                    this.callback = null;
                    return;
                } catch (RuntimeException e) {
                    this.callback.invoke(Utils.getErrorMap(Utils.errOthers, e.getMessage()));
                    this.callback = null;
                }
            } catch (Throwable th) {
                this.callback = null;
                throw th;
            }
        }
        switch (i) {
            case REQUEST_LAUNCH_IMAGE_CAPTURE /* 13001 */:
                if (this.options.saveToPhotos.booleanValue()) {
                    Utils.saveToPublicDirectory(this.cameraCaptureURI, this.reactContext, AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_PHOTO);
                }
                onAssetsObtained(Collections.singletonList(this.fileUri));
                return;
            case REQUEST_LAUNCH_VIDEO_CAPTURE /* 13002 */:
                if (this.options.saveToPhotos.booleanValue()) {
                    Utils.saveToPublicDirectory(this.cameraCaptureURI, this.reactContext, "video");
                }
                onAssetsObtained(Collections.singletonList(this.fileUri));
                return;
            case REQUEST_LAUNCH_LIBRARY /* 13003 */:
                onAssetsObtained(Utils.collectUrisFromData(intent));
                return;
            default:
                return;
        }
    }

    private static void b(boolean z, byte[] bArr, int[] iArr, Object[] objArr) throws Throwable {
        int i;
        int i2 = 2 % 2;
        onPostMessage onpostmessage = new onPostMessage();
        int i3 = 0;
        int i4 = iArr[0];
        int i5 = iArr[1];
        int i6 = iArr[2];
        int i7 = iArr[3];
        char[] cArr = IPostMessageService;
        if (cArr != null) {
            int length = cArr.length;
            char[] cArr2 = new char[length];
            int i8 = 0;
            while (i8 < length) {
                try {
                    Object[] objArr2 = new Object[1];
                    objArr2[i3] = Integer.valueOf(cArr[i8]);
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1782207618);
                    if (objAccessartificialFrame == null) {
                        byte b = (byte) i3;
                        byte b2 = b;
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(Color.rgb(i3, i3, i3) + 16777227, (char) View.combineMeasuredStates(i3, i3), (CdmaCellLocation.convertQuartSecToDecDegrees(i3) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(i3) == 0.0d ? 0 : -1)) + 1562, 178318710, false, $$c(b, b2, (byte) (b2 | 57)), new Class[]{Integer.TYPE});
                    }
                    cArr2[i8] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                    i8++;
                    i3 = 0;
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
            int i9 = $10 + 55;
            $11 = i9 % 128;
            int i10 = i9 % 2;
            cArr = cArr2;
        }
        char[] cArr3 = new char[i5];
        System.arraycopy(cArr, i4, cArr3, 0, i5);
        if (bArr != null) {
            char[] cArr4 = new char[i5];
            onpostmessage.a = 0;
            char c = 0;
            while (onpostmessage.a < i5) {
                int i11 = $10 + AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
                $11 = i11 % 128;
                int i12 = i11 % 2;
                if (bArr[onpostmessage.a] == 1) {
                    int i13 = $10 + 105;
                    $11 = i13 % 128;
                    int i14 = i13 % 2;
                    int i15 = onpostmessage.a;
                    Object[] objArr3 = {Integer.valueOf(cArr3[onpostmessage.a]), Integer.valueOf(c)};
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1378437083);
                    if (objAccessartificialFrame2 == null) {
                        byte b3 = (byte) 0;
                        byte b4 = b3;
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 23, (char) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) - 1), 2441 - (ViewConfiguration.getDoubleTapTimeout() >> 16), -850656813, false, $$c(b3, b4, (byte) (b4 | 54)), new Class[]{Integer.TYPE, Integer.TYPE});
                    }
                    cArr4[i15] = ((Character) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).charValue();
                } else {
                    int i16 = onpostmessage.a;
                    Object[] objArr4 = {Integer.valueOf(cArr3[onpostmessage.a]), Integer.valueOf(c)};
                    Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-314759072);
                    if (objAccessartificialFrame3 == null) {
                        byte b5 = (byte) 0;
                        byte b6 = b5;
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(11 - (ViewConfiguration.getKeyRepeatDelay() >> 16), (char) (ViewConfiguration.getScrollDefaultDelay() >> 16), (-16775654) - Color.rgb(0, 0, 0), 1918398056, false, $$c(b5, b6, b6), new Class[]{Integer.TYPE, Integer.TYPE});
                    }
                    cArr4[i16] = ((Character) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).charValue();
                }
                c = cArr4[onpostmessage.a];
                Object[] objArr5 = {onpostmessage, onpostmessage};
                Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(898481158);
                if (objAccessartificialFrame4 == null) {
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 21, (char) (29363 - (Process.myPid() >> 22)), 215 - ExpandableListView.getPackedPositionGroup(0L), -1427572210, false, "F", new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame4).invoke(null, objArr5);
            }
            cArr3 = cArr4;
        }
        if (i7 > 0) {
            char[] cArr5 = new char[i5];
            i = 0;
            System.arraycopy(cArr3, 0, cArr5, 0, i5);
            int i17 = i5 - i7;
            System.arraycopy(cArr5, 0, cArr3, i17, i7);
            System.arraycopy(cArr5, i7, cArr3, 0, i17);
        } else {
            i = 0;
        }
        if (z) {
            char[] cArr6 = new char[i5];
            while (true) {
                onpostmessage.a = i;
                if (onpostmessage.a >= i5) {
                    break;
                }
                cArr6[onpostmessage.a] = cArr3[(i5 - onpostmessage.a) - 1];
                i = onpostmessage.a + 1;
            }
            cArr3 = cArr6;
        }
        if (i6 > 0) {
            onpostmessage.a = 0;
            while (onpostmessage.a < i5) {
                int i18 = $11 + 115;
                $10 = i18 % 128;
                int i19 = i18 % 2;
                cArr3[onpostmessage.a] = (char) (cArr3[onpostmessage.a] - iArr[2]);
                onpostmessage.a++;
                int i20 = $10 + 75;
                $11 = i20 % 128;
                if (i20 % 2 == 0) {
                    int i21 = 3 / 2;
                }
            }
        }
        objArr[0] = new String(cArr3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v29 */
    public static Object[] accessartificialFrame(Context context, int i, int i2) {
        int i3;
        int i4;
        int i5;
        int iITrustedWebActivityCallbackDefault;
        int i6;
        int i7;
        Object obj;
        int i8;
        Object objInvoke;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        Object objInvoke2;
        int i14;
        int touchSlop;
        int i15;
        Object obj2;
        char c;
        int i16 = 2 % 2;
        int i17 = getARTIFICIAL_FRAME_PACKAGE_NAME;
        int i18 = 1;
        int i19 = (i17 ^ 3) + ((i17 & 3) << 1);
        artificialFrame = i19 % 128;
        int i20 = i19 % 2;
        if (context == null) {
            Object[] objArr = {new int[]{i}, new int[]{i}, new int[1], null};
            int iNextInt = new Random().nextInt();
            int i21 = ~iNextInt;
            int i22 = (((~((-234102183) | i21)) | (~(iNextInt | 744521592))) * 959) + 844567179 + (((~(iNextInt | (-234102183))) | (~(i21 | 744521592))) * 959);
            int i23 = i2 + ((i22 << 1) - i22);
            int i24 = i23 << 13;
            int i25 = ((~i23) & i24) | ((~i24) & i23);
            int i26 = i25 >>> 17;
            int i27 = (i25 | i26) & (~(i25 & i26));
            int i28 = i27 << 5;
            ((int[]) objArr[2])[0] = ((~i27) & i28) | ((~i28) & i27);
            return objArr;
        }
        try {
            int i29 = -View.resolveSizeAndState(0, 0, 0);
            int i30 = (i29 * 624) - 22392;
            int i31 = -(-((~(((-37) & i29) | ((-37) ^ i29) | i)) * 623));
            int i32 = (i30 & i31) + (i30 | i31);
            int i33 = ~i;
            int i34 = ~((~i29) | 36);
            int i35 = -(-(((i34 & i33) | (i33 ^ i34)) * (-623)));
            int i36 = (i32 ^ i35) + ((i35 & i32) << 1);
            int i37 = ~(((-37) ^ i29) | ((-37) & i29));
            int i38 = ~(((-37) & i) | ((-37) ^ i));
            int i39 = (i36 - (~(((~((i29 & i) | (i29 ^ i))) | ((i38 & i37) | (i37 ^ i38))) * 623))) - 1;
            int i40 = (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
            int i41 = (i40 * (-375)) - 102750;
            int i42 = ~i40;
            int i43 = ~((i42 ^ (-275)) | (i42 & (-275)));
            int i44 = (i43 & i) | (i ^ i43);
            int i45 = artificialFrame;
            int i46 = (i45 ^ 3) + ((i45 & 3) << 1);
            getARTIFICIAL_FRAME_PACKAGE_NAME = i46 % 128;
            if (i46 % 2 != 0) {
                int i47 = (i40 & TiffUtil.TIFF_TAG_ORIENTATION) | (i40 ^ TiffUtil.TIFF_TAG_ORIENTATION);
                int i48 = (i41 - (~(-(-(376 >>> (i44 | (~i47))))))) - 1;
                int i49 = ~i;
                int i50 = ~((i49 & i40) | (i49 ^ i40));
                int i51 = ~i47;
                i4 = i48 * ((-376) >>> ((i50 & i51) | (i50 ^ i51)));
            } else {
                int i52 = ~((i40 ^ TiffUtil.TIFF_TAG_ORIENTATION) | (i40 & TiffUtil.TIFF_TAG_ORIENTATION));
                int i53 = ((i52 & i44) | (i44 ^ i52)) * 376;
                int i54 = (i41 & i53) + (i53 | i41);
                int i55 = ~((i33 ^ i40) | (i33 & i40));
                int i56 = ~(i40 | TiffUtil.TIFF_TAG_ORIENTATION);
                int i57 = -(-(((i55 & i56) | (i55 ^ i56)) * (-376)));
                i4 = (i54 & i57) + (i54 | i57);
            }
            int i58 = ~((i42 ^ i) | (i42 & i));
            int i59 = -(-(376 * ((i58 & TiffUtil.TIFF_TAG_ORIENTATION) | (i58 ^ TiffUtil.TIFF_TAG_ORIENTATION))));
            int i60 = (i4 & i59) + (i59 | i4);
            Object[] objArr2 = new Object[1];
            a(true, i39, i60, 38 - (~(-(-ExpandableListView.getPackedPositionChild(0L)))), new char[]{21, 14, '\b', 19, 14, 23, 65525, 65493, 65493, 65498, 65533, 65491, 65493, 65493, 65498, 29, 65491, CharUtils.CR, 25, 26, 6, 65491, 30, 25, 14, 23, 26, '\b', '\n', 24, 65491, 29, 6, 27, 6, 15, 17, 6}, objArr2);
            Object[] objArr3 = (Object[]) Array.newInstance(Class.forName((String) objArr2[0]), 2);
            Object[] objArr4 = new Object[1];
            b(false, new byte[]{0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0}, new int[]{0, 31, 189, 31}, objArr4);
            try {
                Object[] objArr5 = {(String) objArr4[0]};
                int iLastIndexOf = TextUtils.lastIndexOf("", '0', 0);
                int iITrustedWebActivityCallbackDefault2 = JwtRsaSsaPkcs1PrivateKey.Builder.ITrustedWebActivityCallbackDefault();
                int i61 = iLastIndexOf * (-244);
                int i62 = (i61 & 9102) + (i61 | 9102);
                int i63 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                int i64 = (i63 & 115) + (i63 | 115);
                artificialFrame = i64 % 128;
                if (i64 % 2 == 0) {
                    int i65 = ~((-38) | (~iITrustedWebActivityCallbackDefault2));
                    int i66 = ~(((-38) ^ iLastIndexOf) | ((-38) & iLastIndexOf));
                    int i67 = i62 >>> ((-245) % ((i65 ^ i66) | (i65 & i66)));
                    int i68 = -(~((-38) | iITrustedWebActivityCallbackDefault2));
                    i5 = i67 * (((i68 | (-245)) << 1) - (i68 ^ (-245)));
                } else {
                    int i69 = ~iITrustedWebActivityCallbackDefault2;
                    int i70 = ~((i69 & (-38)) | ((-38) ^ i69));
                    int i71 = ~(((-38) ^ iLastIndexOf) | ((-38) & iLastIndexOf));
                    i5 = ((~(((-38) ^ iITrustedWebActivityCallbackDefault2) | ((-38) & iITrustedWebActivityCallbackDefault2))) * (-245)) + i62 + (((i70 ^ i71) | (i70 & i71)) * (-245));
                }
                int i72 = ~(iITrustedWebActivityCallbackDefault2 | (-38));
                int i73 = (i5 - (~(-(-(245 * ((iLastIndexOf & i72) | (iLastIndexOf ^ i72))))))) - 1;
                int i74 = -ExpandableListView.getPackedPositionType(0L);
                int i75 = ((i74 | TiffUtil.TIFF_TAG_ORIENTATION) << 1) - (i74 ^ TiffUtil.TIFF_TAG_ORIENTATION);
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                Object[] objArr6 = new Object[1];
                a(true, i73, i75, ((iMakeMeasureSpec | 38) << 1) - (iMakeMeasureSpec ^ 38), new char[]{21, 14, '\b', 19, 14, 23, 65525, 65493, 65493, 65498, 65533, 65491, 65493, 65493, 65498, 29, 65491, CharUtils.CR, 25, 26, 6, 65491, 30, 25, 14, 23, 26, '\b', '\n', 24, 65491, 29, 6, 27, 6, 15, 17, 6}, objArr6);
                Class<?> cls = Class.forName((String) objArr6[0]);
                Class<?>[] clsArr = new Class[1];
                int i76 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                int i77 = (i76 & 121) + (i76 | 121);
                artificialFrame = i77 % 128;
                int i78 = i77 % 2;
                clsArr[0] = String.class;
                objArr3[0] = cls.getDeclaredConstructor(clsArr).newInstance(objArr5);
                int i79 = -(ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                int i80 = ((i79 | 16) << 1) - (i79 ^ 16);
                int iAxisFromString = MotionEvent.axisFromString("");
                int iITrustedWebActivityCallbackDefault3 = JwtRsaSsaPkcs1PrivateKey.Builder.ITrustedWebActivityCallbackDefault();
                int i81 = ~iITrustedWebActivityCallbackDefault3;
                int i82 = (~((i81 & 1432472565) | (1432472565 ^ i81) | 1761326867)) * 130;
                int i83 = (1746755723 & i82) + (i82 | 1746755723);
                int i84 = ~((iITrustedWebActivityCallbackDefault3 & 2113667063) | (2113667063 ^ iITrustedWebActivityCallbackDefault3));
                int i85 = (((i83 & (-202377248)) + ((-202377248) | i83)) - (~(-(-(((i84 & 1080132369) | (1080132369 ^ i84)) * 130))))) - 1;
                int i86 = ~i;
                int i87 = ~((-1814931368) | i86);
                int i88 = ~(((-1493905584) ^ i) | ((-1493905584) & i));
                int i89 = 336865992 + (((i87 ^ i88) | (i87 & i88)) * 210);
                int i90 = ((-1493905584) ^ i33) | ((-1493905584) & i33);
                int i91 = ~((i90 ^ 1814931367) | (i90 & 1814931367));
                int i92 = ~((-606373633) | i);
                int i93 = ((i91 ^ i92) | (i91 & i92)) * 210;
                if (i85 <= (i89 ^ i93) + ((i93 & i89) << 1)) {
                    iITrustedWebActivityCallbackDefault = JwtRsaSsaPkcs1PrivateKey.Builder.ITrustedWebActivityCallbackDefault();
                    i6 = (((-464) << iAxisFromString) >>> (-122)) * ((-465) >> ((~((iITrustedWebActivityCallbackDefault & 269) | (iITrustedWebActivityCallbackDefault ^ 269))) | (~iAxisFromString)));
                } else {
                    iITrustedWebActivityCallbackDefault = JwtRsaSsaPkcs1PrivateKey.Builder.ITrustedWebActivityCallbackDefault();
                    int i94 = iAxisFromString * (-464);
                    i6 = (i94 & (-249901)) + (i94 | (-249901)) + (((~iAxisFromString) | (~((iITrustedWebActivityCallbackDefault ^ 269) | (iITrustedWebActivityCallbackDefault & 269)))) * (-465));
                }
                int i95 = ~iAxisFromString;
                int i96 = ~((i95 & iITrustedWebActivityCallbackDefault) | (i95 ^ iITrustedWebActivityCallbackDefault));
                int i97 = -(-(930 * ((i96 & 269) | (269 ^ i96))));
                int i98 = ((i6 | i97) << 1) - (i97 ^ i6);
                int i99 = (269 ^ iITrustedWebActivityCallbackDefault) | (iITrustedWebActivityCallbackDefault & 269);
                int i100 = ~iAxisFromString;
                int i101 = -(-(((i99 & i100) | (i99 ^ i100)) * 465));
                int i102 = (i98 & i101) + (i101 | i98);
                int i103 = -TextUtils.lastIndexOf("", '0');
                int i104 = artificialFrame + 83;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i104 % 128;
                if (i104 % 2 != 0) {
                    int i105 = (284 >>> i103) * (-9);
                    int i106 = ~i103;
                    int i107 = ~((i106 ^ 30) | (i106 & 30));
                    int i108 = ~((i106 & i) | (i106 ^ i));
                    i7 = i105 / ((-283) % ((i108 & i107) | (i107 ^ i108)));
                } else {
                    int i109 = i103 * 284;
                    int i110 = ((i109 | (-8460)) << 1) - (i109 ^ (-8460));
                    int i111 = ~i103;
                    int i112 = ~((i111 ^ 30) | (i111 & 30));
                    int i113 = ~((i111 & i) | (i111 ^ i));
                    i7 = (((i113 & i112) | (i112 ^ i113)) * (-283)) + i110;
                }
                int iITrustedWebActivityCallbackDefault4 = JwtRsaSsaPkcs1PrivateKey.Builder.ITrustedWebActivityCallbackDefault();
                int i114 = ~((648938771 ^ iITrustedWebActivityCallbackDefault4) | (648938771 & iITrustedWebActivityCallbackDefault4));
                int i115 = -(-(((1078040708 ^ i114) | (1078040708 & i114)) * 305));
                int i116 = ~((~iITrustedWebActivityCallbackDefault4) | 648938771);
                int i117 = ((-480974594) ^ i115) + (((-480974594) & i115) << 1) + (((i116 & 1113693332) | (1113693332 ^ i116)) * 305);
                int i118 = ~(((-1158768991) & i) | ((-1158768991) ^ i));
                if (i117 <= (((-2099722056) - (~(((1074864396 ^ i118) | (i118 & 1074864396)) * (-566)))) - (~(-(-((~(((-83904595) ^ i) | ((-83904595) & i))) * 566))))) - 1) {
                    int i119 = -(283 << (~((-31) | i103)));
                    int i120 = ~i103;
                    int i121 = (i120 & (-31)) | (i120 ^ (-31));
                    int i122 = ((i7 & i119) + (i7 | i119)) >>> (283 >>> (~((i121 & i) | (i121 ^ i))));
                    Object[] objArr7 = new Object[1];
                    a(true, i80, i102, i122, new char[]{65518, 65495, 15, 20, 26, 29, 15, 25, 65516, 65512, 65530, 65495, 65534, 0, 65512, 65518, 18, ' ', CharUtils.CR, 16, 65519, 65483, 15, 20, 26, 29, 15, 25, 65516, 65512, 65529}, objArr7);
                    obj = objArr7[0];
                } else {
                    int i123 = -(-(283 * (~(((-31) ^ i103) | ((-31) & i103)))));
                    int i124 = (i7 & i123) + (i7 | i123);
                    int i125 = ~i103;
                    int i126 = (i125 & (-31)) | (i125 ^ (-31));
                    int i127 = (~((i126 & i) | (i126 ^ i))) * 283;
                    Object[] objArr8 = new Object[1];
                    a(true, i80, i102, (i124 & i127) + (i127 | i124), new char[]{65518, 65495, 15, 20, 26, 29, 15, 25, 65516, 65512, 65530, 65495, 65534, 0, 65512, 65518, 18, ' ', CharUtils.CR, 16, 65519, 65483, 15, 20, 26, 29, 15, 25, 65516, 65512, 65529}, objArr8);
                    obj = objArr8[0];
                }
                try {
                    int iGreen = 36 - Color.green(0);
                    byte modifierMetaStateMask = (byte) KeyEvent.getModifierMetaStateMask();
                    int i128 = modifierMetaStateMask * (-300);
                    int i129 = (i128 ^ 83050) + ((i128 & 83050) << 1);
                    int i130 = (modifierMetaStateMask ^ 275) | (modifierMetaStateMask & 275);
                    int i131 = (i129 - (~((~((i130 & i) | (i130 ^ i))) * (-301)))) - 1;
                    int i132 = -(-(((~((-276) | i)) | (~((i86 ^ modifierMetaStateMask) | (i86 & modifierMetaStateMask)))) * (-301)));
                    int i133 = ((i131 | i132) << 1) - (i132 ^ i131);
                    int i134 = ~modifierMetaStateMask;
                    int i135 = ~((i134 & i) | (i134 ^ i));
                    int i136 = ((i135 & (-276)) | ((-276) ^ i135)) * 301;
                    Object[] objArr9 = new Object[1];
                    a(true, iGreen, (i133 & i136) + (i136 | i133), 37 - (~(-(-Color.argb(0, 0, 0, 0)))), new char[]{21, 14, '\b', 19, 14, 23, 65525, 65493, 65493, 65498, 65533, 65491, 65493, 65493, 65498, 29, 65491, CharUtils.CR, 25, 26, 6, 65491, 30, 25, 14, 23, 26, '\b', '\n', 24, 65491, 29, 6, 27, 6, 15, 17, 6}, objArr9);
                    objArr3[1] = Class.forName((String) objArr9[0]).getDeclaredConstructor(String.class).newInstance((String) obj);
                    try {
                        int iMyTid = (Process.myTid() >> 22) + 12;
                        int iIndexOf = TextUtils.indexOf((CharSequence) "", '0', 0);
                        Object[] objArr10 = new Object[1];
                        a(true, iMyTid, (iIndexOf ^ 285) + ((iIndexOf & 285) << 1), View.MeasureSpec.getMode(0) + 23, new char[]{15, '\t', '\n', 65534, 65481, 65535, 4, '\n', CharUtils.CR, 65535, '\t', 65532, 15, 19, 0, 15, '\t', '\n', 65502, 65481, 15, '\t', 0}, objArr10);
                        Class<?> cls2 = Class.forName((String) objArr10[0]);
                        Object[] objArr11 = new Object[1];
                        b(true, new byte[]{1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 0, 0, 1, 1, 0, 0}, new int[]{31, 17, 0, 9}, objArr11);
                        Object objInvoke3 = cls2.getMethod((String) objArr11[0], null).invoke(context, null);
                        try {
                            int i137 = -(ViewConfiguration.getFadingEdgeLength() >> 16);
                            int i138 = (i137 * (-963)) - 964;
                            int i139 = (i138 & 11580) + (i138 | 11580);
                            int i140 = ~i137;
                            int i141 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                            int i142 = (i141 ^ 115) + ((i141 & 115) << 1);
                            artificialFrame = i142 % 128;
                            if (i142 % 2 == 0) {
                                int i143 = i140 | (~((-13) | i));
                                i8 = i139 >> (((i143 | (-964)) << 1) - (i143 ^ (-964)));
                            } else {
                                int i144 = ~(((-13) & i) | ((-13) ^ i));
                                int i145 = -(-(((i140 & i144) | (i140 ^ i144)) * (-964)));
                                i8 = (i145 | i139) + (i139 & i145);
                            }
                            int i146 = ~(((-13) & i33) | ((-13) ^ i33));
                            int i147 = ~((i137 & (-13)) | ((-13) ^ i137));
                            int i148 = -(-((-964) * ((i147 & i146) | (i146 ^ i147))));
                            int i149 = (i8 & i148) + (i148 | i8);
                            int i150 = -View.MeasureSpec.getMode(0);
                            Object[] objArr12 = new Object[1];
                            a(true, i149, ((i150 | 284) << 1) - (i150 ^ 284), (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 22, new char[]{15, '\t', '\n', 65534, 65481, 65535, 4, '\n', CharUtils.CR, 65535, '\t', 65532, 15, 19, 0, 15, '\t', '\n', 65502, 65481, 15, '\t', 0}, objArr12);
                            Class<?> cls3 = Class.forName((String) objArr12[0]);
                            Object[] objArr13 = new Object[1];
                            b(false, new byte[]{1, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0}, new int[]{48, 14, 0, 5}, objArr13);
                            Method method = cls3.getMethod((String) objArr13[0], null);
                            int i151 = artificialFrame + 73;
                            getARTIFICIAL_FRAME_PACKAGE_NAME = i151 % 128;
                            if (i151 % 2 != 0) {
                                objInvoke = method.invoke(context, null);
                                i9 = 35;
                            } else {
                                objInvoke = method.invoke(context, null);
                                i9 = 64;
                            }
                            int i152 = artificialFrame;
                            int i153 = (i152 ^ 113) + ((i152 & 113) << 1);
                            getARTIFICIAL_FRAME_PACKAGE_NAME = i153 % 128;
                            int i154 = i153 % 2;
                            try {
                                Object[] objArr14 = {objInvoke, Integer.valueOf(i9)};
                                int maxKeyCode = KeyEvent.getMaxKeyCode() >> 16;
                                int i155 = (maxKeyCode ^ 32) | (maxKeyCode & 32);
                                int i156 = ~i155;
                                int i157 = ~((maxKeyCode ^ i) | (maxKeyCode & i));
                                int i158 = (i156 ^ i157) | (i157 & i156);
                                int i159 = ~(i | 32);
                                int i160 = (((maxKeyCode * (-743)) - 23776) - (~(((i158 ^ i159) | (i158 & i159)) * (-744)))) - 1;
                                int i161 = ~maxKeyCode;
                                int i162 = ~((i161 & (-33)) | (i161 ^ (-33)));
                                int i163 = i160 + (((i162 & i33) | (i33 ^ i162)) * 744);
                                int i164 = ((i155 ^ i) | (i155 & i)) * 744;
                                int i165 = (i163 & i164) + (i164 | i163);
                                int absoluteGravity = Gravity.getAbsoluteGravity(0, 0) + 281;
                                int i166 = -(ViewConfiguration.getTouchSlop() >> 8);
                                int i167 = ((i166 * (-494)) - 16302) + ((~((i166 ^ 33) | (i166 & 33))) * (-495)) + (((i166 ^ i33) | (i166 & i33)) * 495);
                                int i168 = ~i166;
                                int i169 = -(-(((~(i166 | i86)) | (~((i168 & (-34)) | (i168 ^ (-34))))) * 495));
                                Object[] objArr15 = new Object[1];
                                a(true, i165, absoluteGravity, ((i167 | i169) << 1) - (i169 ^ i167), new char[]{3, 5, 65535, '\f', 65535, 65515, 3, 5, 65535, '\t', 1, 65535, 65518, 65484, 11, 14, 65484, 18, '\f', 3, 18, '\f', CharUtils.CR, 1, 65484, 2, 7, CharUtils.CR, 16, 2, '\f', 65535, 16}, objArr15);
                                Class<?> cls4 = Class.forName((String) objArr15[0]);
                                int iIndexOf2 = TextUtils.indexOf("", "");
                                int iITrustedWebActivityCallbackDefault5 = JwtRsaSsaPkcs1PrivateKey.Builder.ITrustedWebActivityCallbackDefault();
                                int i170 = iIndexOf2 * 399;
                                int i171 = ((i170 | 3192) << 1) - (i170 ^ 3192);
                                int i172 = ~iIndexOf2;
                                int i173 = ~(i172 | 8);
                                int i174 = ~(((-9) ^ iIndexOf2) | ((-9) & iIndexOf2));
                                int i175 = (i173 ^ i174) | (i174 & i173);
                                int i176 = ~(((-9) ^ iITrustedWebActivityCallbackDefault5) | ((-9) & iITrustedWebActivityCallbackDefault5));
                                int i177 = -(-(((i175 ^ i176) | (i175 & i176)) * 398));
                                int i178 = (i171 & i177) + (i177 | i171);
                                int i179 = ((iIndexOf2 ^ 8) | (iIndexOf2 & 8)) * (-1194);
                                int i180 = ((i178 | i179) << 1) - (i179 ^ i178);
                                int i181 = ~((-9) | (~iITrustedWebActivityCallbackDefault5));
                                int i182 = ~((i172 ^ 8) | (i172 & 8));
                                int i183 = (i181 & i182) | (i181 ^ i182);
                                int i184 = ~((iIndexOf2 & (-9)) | ((-9) ^ iIndexOf2));
                                int i185 = -(-(((i183 & i184) | (i183 ^ i184)) * 398));
                                int i186 = (i180 ^ i185) + ((i185 & i180) << 1);
                                int i187 = -Color.alpha(0);
                                int i188 = (i187 * (-1965)) - (-278472);
                                int i189 = -(-(((i187 ^ (-284)) | (i187 & (-284))) * 983));
                                int i190 = ((i188 | i189) << 1) - (i188 ^ i189);
                                int i191 = ~i187;
                                int i192 = ~(((-284) & i86) | ((-284) ^ i86));
                                int i193 = i190 + (((i192 & i191) | (i191 ^ i192)) * (-983));
                                int i194 = ~((i191 & i33) | (i191 ^ i33));
                                int i195 = ~((~i187) | 283);
                                int i196 = ((i195 & i194) | (i194 ^ i195)) * 983;
                                Object[] objArr16 = new Object[1];
                                a(false, i186, ((i193 | i196) << 1) - (i196 ^ i193), 15 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), new char[]{7, 65533, 3, 1, 65509, '\n', 2, 11, 3, 1, 16, 65516, 65533, 65535}, objArr16);
                                Object objInvoke4 = cls4.getMethod((String) objArr16[0], String.class, Integer.TYPE).invoke(objInvoke3, objArr14);
                                int threadPriority = Process.getThreadPriority(0);
                                int i197 = 20 - (~(-(-(((threadPriority ^ 20) + ((threadPriority & 20) << 1)) >> 6))));
                                int i198 = -TextUtils.getOffsetBefore("", 0);
                                int i199 = (i198 & 280) + (i198 | 280);
                                int i200 = -(-(AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)));
                                Object[] objArr17 = new Object[1];
                                a(true, i197, i199, ((i200 | 30) << 1) - (i200 ^ 30), new char[]{0, 65519, 65485, '\f', 15, 65485, 19, CharUtils.CR, 4, 19, CharUtils.CR, 14, 2, 65485, 3, '\b', 14, 17, 3, CharUtils.CR, 0, 14, 5, CharUtils.CR, 65512, 4, 6, 0, '\n', 2}, objArr17);
                                Class<?> cls5 = Class.forName((String) objArr17[0]);
                                int maximumDrawingCacheSize = (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 3;
                                int touchSlop2 = (ViewConfiguration.getTouchSlop() >> 8) + 292;
                                int i201 = (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                                int iITrustedWebActivityCallbackDefault6 = JwtRsaSsaPkcs1PrivateKey.Builder.ITrustedWebActivityCallbackDefault();
                                int i202 = i201 * 477;
                                int i203 = (i202 & (-4750)) + (i202 | (-4750));
                                int i204 = ~i201;
                                int i205 = ~((i204 & 10) | (i204 ^ 10));
                                int i206 = ~(((-11) ^ i201) | ((-11) & i201) | iITrustedWebActivityCallbackDefault6);
                                int i207 = -(-(((i205 ^ i206) | (i206 & i205)) * (-476)));
                                int i208 = (i203 ^ i207) + ((i207 & i203) << 1);
                                int i209 = (-11) | i201;
                                int i210 = -(-((~((i209 & iITrustedWebActivityCallbackDefault6) | (i209 ^ iITrustedWebActivityCallbackDefault6))) * 952));
                                int i211 = ((i208 | i210) << 1) - (i210 ^ i208);
                                int i212 = ~iITrustedWebActivityCallbackDefault6;
                                int i213 = (~(i201 | (i212 & (-11)) | ((-11) ^ i212))) * 476;
                                Object[] objArr18 = new Object[1];
                                a(true, maximumDrawingCacheSize, touchSlop2, (i211 ^ i213) + ((i213 & i211) << 1), new char[]{65530, 65532, 6, 6, 65528, 5, '\b', 7, 65524, 1}, objArr18);
                                Object[] objArr19 = (Object[]) cls5.getField((String) objArr18[0]).get(objInvoke4);
                                int length = objArr19.length;
                                int i214 = 0;
                                while (i214 < length) {
                                    int i215 = getARTIFICIAL_FRAME_PACKAGE_NAME + 7;
                                    artificialFrame = i215 % 128;
                                    int i216 = i215 % 2;
                                    Object obj3 = objArr19[i214];
                                    Object[] objArr20 = new Object[i18];
                                    b(i18, new byte[]{0, 1, 1, 1, 0}, new int[]{62, 5, 95, 0}, objArr20);
                                    String str = (String) objArr20[0];
                                    int i217 = artificialFrame;
                                    int i218 = (i217 & 79) + (i217 | 79);
                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i218 % 128;
                                    if (i218 % 2 != 0) {
                                        int i219 = 2 / 5;
                                    }
                                    int i220 = i217 + AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i220 % 128;
                                    int i221 = i220 % 2;
                                    try {
                                        Object[] objArr21 = {str};
                                        int packedPositionType = ExpandableListView.getPackedPositionType(0L);
                                        int iITrustedWebActivityCallbackDefault7 = JwtRsaSsaPkcs1PrivateKey.Builder.ITrustedWebActivityCallbackDefault();
                                        int i222 = (packedPositionType * (-494)) - 13832;
                                        int i223 = artificialFrame;
                                        int i224 = (i223 & 97) + (i223 | 97);
                                        getARTIFICIAL_FRAME_PACKAGE_NAME = i224 % 128;
                                        int i225 = i224 % 2;
                                        int i226 = (-495) * (((packedPositionType ^ 28) | (packedPositionType & 28)) ^ (-1));
                                        int i227 = (i222 & i226) + (i222 | i226) + (((~iITrustedWebActivityCallbackDefault7) | packedPositionType) * 495);
                                        int i228 = ~((~packedPositionType) | (-29));
                                        int i229 = ~iITrustedWebActivityCallbackDefault7;
                                        int i230 = -(-(((~((packedPositionType & i229) | (i229 ^ packedPositionType))) | i228) * 495));
                                        int i231 = ((i227 | i230) << i18) - (i227 ^ i230);
                                        int iBlue = Color.blue(0);
                                        int i232 = iBlue * (-433);
                                        int i233 = (i232 ^ (-61128)) + ((i232 & (-61128)) << i18);
                                        int i234 = ~iBlue;
                                        int i235 = ~((i234 & i33) | (i234 ^ i33));
                                        int i236 = ~(((-284) ^ i) | ((-284) & i));
                                        int i237 = ((i235 ^ i236) | (i235 & i236)) * JfifUtil.MARKER_EOI;
                                        int i238 = (i233 & i237) + (i237 | i233);
                                        int i239 = ~iBlue;
                                        int i240 = ~((i239 & (-284)) | (i239 ^ (-284)));
                                        int i241 = ~((i239 & i) | (i239 ^ i));
                                        int i242 = i238 + (((i240 & i241) | (i240 ^ i241)) * JfifUtil.MARKER_EOI);
                                        int i243 = ~((-284) | i33);
                                        int i244 = getARTIFICIAL_FRAME_PACKAGE_NAME + 41;
                                        artificialFrame = i244 % 128;
                                        int i245 = i244 % 2;
                                        int i246 = (i242 - (~(-(-(JfifUtil.MARKER_EOI * ((i243 & iBlue) | (iBlue ^ i243))))))) - 1;
                                        int i247 = -(ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1));
                                        Object[] objArr22 = new Object[1];
                                        a(true, i231, i246, (i247 ^ 37) + ((i247 & 37) << 1), new char[]{65533, 65535, 5, 2, 5, 16, 14, 1, 65503, 65482, 16, 14, 1, 65535, 65482, 21, 16, 5, 14, 17, 65535, 1, 15, 65482, 65533, 18, 65533, 6, 21, 14, 11, 16, 65535, 65533, 65506, 1, 16}, objArr22);
                                        Class<?> cls6 = Class.forName((String) objArr22[0]);
                                        int i248 = -(-KeyEvent.getDeadChar(0, 0));
                                        int i249 = (i248 ^ 7) + ((i248 & 7) << 1);
                                        int i250 = 286 - (~(-(SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))));
                                        int jumpTapTimeout = ViewConfiguration.getJumpTapTimeout() >> 16;
                                        int iITrustedWebActivityCallbackDefault8 = JwtRsaSsaPkcs1PrivateKey.Builder.ITrustedWebActivityCallbackDefault();
                                        int i251 = jumpTapTimeout * (-51);
                                        int i252 = ((i251 | 583) << 1) - (i251 ^ 583);
                                        int i253 = ~iITrustedWebActivityCallbackDefault8;
                                        int i254 = (i253 ^ jumpTapTimeout) | (i253 & jumpTapTimeout);
                                        Object[] objArr23 = objArr19;
                                        int i255 = i252 + ((~((i254 ^ 11) | (i254 & 11))) * 52);
                                        int i256 = ~iITrustedWebActivityCallbackDefault8;
                                        int i257 = ~(((-12) ^ i256) | (i256 & (-12)));
                                        int i258 = ~(((-12) ^ jumpTapTimeout) | ((-12) & jumpTapTimeout));
                                        int i259 = i255 + (((i257 ^ i258) | (i257 & i258) | (~i254)) * (-52));
                                        int i260 = ~jumpTapTimeout;
                                        Object[] objArr24 = new Object[1];
                                        a(false, i249, i250, (i259 - (~(-(-(((~((i260 & 11) | (i260 ^ 11))) | (~((i260 ^ i253) | (i260 & i253)))) * 52))))) - 1, new char[]{7, '\f', CharUtils.CR, 65530, 7, 65532, 65534, 0, 65534, CharUtils.CR, 65506}, objArr24);
                                        Object objInvoke5 = cls6.getMethod((String) objArr24[0], String.class).invoke(null, objArr21);
                                        try {
                                            Object[] objArr25 = new Object[1];
                                            b(true, new byte[]{1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1}, new int[]{67, 28, 0, 0}, objArr25);
                                            Class<?> cls7 = Class.forName((String) objArr25[0]);
                                            Object[] objArr26 = new Object[1];
                                            b(false, new byte[]{1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0}, new int[]{95, 11, 43, 4}, objArr26);
                                            try {
                                                Object[] objArr27 = {new ByteArrayInputStream((byte[]) cls7.getMethod((String) objArr26[0], null).invoke(obj3, null))};
                                                int i261 = -(SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1));
                                                int iITrustedWebActivityCallbackDefault9 = JwtRsaSsaPkcs1PrivateKey.Builder.ITrustedWebActivityCallbackDefault();
                                                int i262 = (i261 * 236) + 13659;
                                                int i263 = ~i261;
                                                int i264 = ~iITrustedWebActivityCallbackDefault9;
                                                int i265 = ~((i263 & i264) | (i263 ^ i264));
                                                int i266 = -(-(((i265 & 29) | (i265 ^ 29)) * (-235)));
                                                int i267 = (i262 ^ i266) + ((i262 & i266) << 1);
                                                int i268 = ~i261;
                                                int i269 = (i268 ^ iITrustedWebActivityCallbackDefault9) | (i268 & iITrustedWebActivityCallbackDefault9);
                                                int i270 = artificialFrame;
                                                int i271 = ((i270 | 9) << 1) - (i270 ^ 9);
                                                getARTIFICIAL_FRAME_PACKAGE_NAME = i271 % 128;
                                                if (i271 % 2 != 0) {
                                                    int i272 = ~i269;
                                                    int i273 = i267 << (((i272 & 29) | (i272 ^ 29)) * (-470));
                                                    int i274 = ~((i261 & (-30)) | ((-30) ^ i261));
                                                    int i275 = (i268 & 29) | (i268 ^ 29);
                                                    int i276 = ~((iITrustedWebActivityCallbackDefault9 & i275) | (i275 ^ iITrustedWebActivityCallbackDefault9));
                                                    int i277 = i273 / (235 << ((i274 & i276) | (i274 ^ i276)));
                                                    i11 = 19958;
                                                    i10 = i277;
                                                } else {
                                                    int i278 = ~i269;
                                                    int i279 = (i267 - (~(-(-(((i278 & 29) | (i278 ^ 29)) * (-470)))))) - 1;
                                                    int i280 = ~(i261 | (-30));
                                                    int i281 = ~(iITrustedWebActivityCallbackDefault9 | i268 | 29);
                                                    int i282 = ((i280 & i281) | (i280 ^ i281)) * 235;
                                                    i10 = (i279 & i282) + (i282 | i279);
                                                    i11 = 283;
                                                }
                                                int iIndexOf3 = TextUtils.indexOf("", "", 0, 0);
                                                int i283 = iIndexOf3 * (-711);
                                                int i284 = i11 * 713;
                                                int i285 = artificialFrame + 123;
                                                getARTIFICIAL_FRAME_PACKAGE_NAME = i285 % 128;
                                                if (i285 % 2 != 0) {
                                                    int i286 = i283 % i284;
                                                    int i287 = ~i11;
                                                    int i288 = ~((i287 & iIndexOf3) | (i287 ^ iIndexOf3));
                                                    int i289 = ~(i33 | iIndexOf3);
                                                    int i290 = -(-((i288 & i289) | (i288 ^ i289)));
                                                    int i291 = -((i290 ^ (-712)) + ((i290 & (-712)) << 1));
                                                    i13 = (i286 & i291) + (i286 | i291);
                                                    i12 = ~i11;
                                                } else {
                                                    int i292 = -(-i284);
                                                    int i293 = (i283 ^ i292) + ((i283 & i292) << 1);
                                                    i12 = ~i11;
                                                    int i294 = ~((i12 ^ iIndexOf3) | (i12 & iIndexOf3));
                                                    int i295 = ~((i86 ^ iIndexOf3) | (i86 & iIndexOf3));
                                                    int i296 = -(-(((i294 ^ i295) | (i294 & i295)) * (-712)));
                                                    i13 = ((i293 | i296) << 1) - (i296 ^ i293);
                                                }
                                                int i297 = ~((i12 & i33) | (i12 ^ i33) | iIndexOf3);
                                                int i298 = iIndexOf3 | i11;
                                                int i299 = ~((i298 & i) | (i298 ^ i));
                                                int i300 = i13 + ((-712) * ((i297 & i299) | (i297 ^ i299)));
                                                int i301 = ~i11;
                                                int i302 = ~((iIndexOf3 & i86) | (i86 ^ iIndexOf3));
                                                int i303 = -(-(((i301 & i302) | (i301 ^ i302)) * 712));
                                                int i304 = ((i300 | i303) << 1) - (i303 ^ i300);
                                                int i305 = -(SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1));
                                                Object[] objArr28 = new Object[1];
                                                a(true, i10, i304, ((i305 | 38) << 1) - (i305 ^ 38), new char[]{65533, 65535, 5, 2, 5, 16, 14, 1, 65503, 65482, 16, 14, 1, 65535, 65482, 21, 16, 5, 14, 17, 65535, 1, 15, 65482, 65533, 18, 65533, 6, 21, 14, 11, 16, 65535, 65533, 65506, 1, 16}, objArr28);
                                                Class<?> cls8 = Class.forName((String) objArr28[0]);
                                                Object[] objArr29 = new Object[1];
                                                b(true, new byte[]{1, 1, 1, 0, 0, 1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0}, new int[]{b.l, 19, 0, 0}, objArr29);
                                                String str2 = (String) objArr29[0];
                                                Class<?>[] clsArr2 = new Class[1];
                                                int i306 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                                int i307 = (i306 ^ 37) + ((i306 & 37) << 1);
                                                artificialFrame = i307 % 128;
                                                if (i307 % 2 == 0) {
                                                    clsArr2[1] = InputStream.class;
                                                    objInvoke2 = cls8.getMethod(str2, clsArr2).invoke(objInvoke5, objArr27);
                                                    int length2 = objArr3.length;
                                                    i14 = 1;
                                                } else {
                                                    clsArr2[0] = InputStream.class;
                                                    objInvoke2 = cls8.getMethod(str2, clsArr2).invoke(objInvoke5, objArr27);
                                                    int length3 = objArr3.length;
                                                    i14 = 0;
                                                }
                                                while (i14 < 2) {
                                                    Object obj4 = objArr3[i14];
                                                    int i308 = artificialFrame + 87;
                                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i308 % 128;
                                                    int i309 = i308 % 2;
                                                    try {
                                                        int i310 = -(Process.myPid() >> 22);
                                                        int iITrustedWebActivityCallbackDefault10 = JwtRsaSsaPkcs1PrivateKey.Builder.ITrustedWebActivityCallbackDefault();
                                                        int i311 = ~iITrustedWebActivityCallbackDefault10;
                                                        int i312 = ~(((-22) ^ i311) | ((-22) & i311));
                                                        int i313 = ~((-22) | i310);
                                                        int i314 = (i312 ^ i313) | (i313 & i312);
                                                        int i315 = ~((i311 & i310) | (i311 ^ i310));
                                                        int i316 = ((i310 * 465) - 9723) + (((i315 & i314) | (i314 ^ i315)) * 464);
                                                        int i317 = ~i310;
                                                        int i318 = (i316 - (~(-(-((((i317 & iITrustedWebActivityCallbackDefault10) | (iITrustedWebActivityCallbackDefault10 ^ i317)) | (-22)) * (-464)))))) - 1;
                                                        int i319 = getARTIFICIAL_FRAME_PACKAGE_NAME + 29;
                                                        artificialFrame = i319 % 128;
                                                        if (i319 % 2 == 0) {
                                                            int i320 = ~(((-22) ^ i310) | ((-22) & i310));
                                                            int i321 = ~((i310 & iITrustedWebActivityCallbackDefault10) | (i310 ^ iITrustedWebActivityCallbackDefault10));
                                                            int i322 = (i318 - (~(464 >>> ((i321 & i320) | (i320 ^ i321))))) - 1;
                                                            touchSlop = 11647 << (ViewConfiguration.getTouchSlop() * 40);
                                                            i15 = i322;
                                                        } else {
                                                            int i323 = ~((-22) | i310);
                                                            int i324 = ~(i310 | iITrustedWebActivityCallbackDefault10);
                                                            int i325 = ((i324 & i323) | (i323 ^ i324)) * 464;
                                                            int i326 = ((i318 | i325) << 1) - (i325 ^ i318);
                                                            touchSlop = 277 - (~(ViewConfiguration.getTouchSlop() >> 8));
                                                            i15 = i326;
                                                        }
                                                        int i327 = artificialFrame;
                                                        int i328 = (i327 & 5) + (i327 | 5);
                                                        getARTIFICIAL_FRAME_PACKAGE_NAME = i328 % 128;
                                                        int i329 = i328 % 2;
                                                        int iResolveOpacity = Drawable.resolveOpacity(0, 0);
                                                        int iITrustedWebActivityCallbackDefault11 = JwtRsaSsaPkcs1PrivateKey.Builder.ITrustedWebActivityCallbackDefault();
                                                        int i330 = ~iResolveOpacity;
                                                        int i331 = ((iResolveOpacity * (-103)) - 3502) + (((~((i330 & (-35)) | (i330 ^ (-35)))) | (~((-35) | iITrustedWebActivityCallbackDefault11))) * 104);
                                                        int i332 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                                        int i333 = ((i332 | 41) << 1) - (i332 ^ 41);
                                                        artificialFrame = i333 % 128;
                                                        if (i333 % 2 == 0) {
                                                            int i334 = ~iITrustedWebActivityCallbackDefault11;
                                                            int i335 = (i334 & iResolveOpacity) | (i334 ^ iResolveOpacity);
                                                            int i336 = (i331 >> ((-104) >>> (~((i335 & 34) | (i335 ^ 34))))) >> ((iITrustedWebActivityCallbackDefault11 | iResolveOpacity) * 104);
                                                            Object[] objArr30 = new Object[1];
                                                            a(false, i15, touchSlop, i336, new char[]{65487, 4, 6, 19, 21, 65487, 65529, 65494, 65489, 65498, 65508, 6, 19, 21, '\n', 7, '\n', 4, 2, 21, 6, 11, 2, 23, 2, 65487, 20, 6, 4, 22, 19, '\n', 21, 26}, objArr30);
                                                            obj2 = objArr30[0];
                                                        } else {
                                                            int i337 = ~iITrustedWebActivityCallbackDefault11;
                                                            int i338 = (i337 & iResolveOpacity) | (i337 ^ iResolveOpacity);
                                                            int i339 = (~((i338 & 34) | (i338 ^ 34))) * (-104);
                                                            int i340 = (i331 ^ i339) + ((i331 & i339) << 1);
                                                            int i341 = iResolveOpacity ^ iITrustedWebActivityCallbackDefault11;
                                                            Object[] objArr31 = new Object[1];
                                                            a(false, i15, touchSlop, (i340 - (~(-(-(((iITrustedWebActivityCallbackDefault11 & iResolveOpacity) | i341) * 104))))) - 1, new char[]{65487, 4, 6, 19, 21, 65487, 65529, 65494, 65489, 65498, 65508, 6, 19, 21, '\n', 7, '\n', 4, 2, 21, 6, 11, 2, 23, 2, 65487, 20, 6, 4, 22, 19, '\n', 21, 26}, objArr31);
                                                            obj2 = objArr31[0];
                                                        }
                                                        Class<?> cls9 = Class.forName((String) obj2);
                                                        Object[] objArr32 = new Object[1];
                                                        b(false, new byte[]{0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1}, new int[]{125, 23, 0, 13}, objArr32);
                                                        if (obj4.equals(cls9.getMethod((String) objArr32[0], null).invoke(objInvoke2, null))) {
                                                            int i342 = i ^ 1;
                                                            Object[] objArr33 = new Object[4];
                                                            int i343 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                                            int i344 = (i343 & 67) + (i343 | 67);
                                                            artificialFrame = i344 % 128;
                                                            char c2 = 1;
                                                            if (i344 % 2 == 0) {
                                                                objArr33[0] = new int[1];
                                                                objArr33[0] = new int[1];
                                                                objArr33[2] = new int[0];
                                                                c2 = 1;
                                                                c = 0;
                                                            } else {
                                                                c = 0;
                                                                objArr33[0] = new int[1];
                                                                objArr33[1] = new int[1];
                                                                objArr33[2] = new int[1];
                                                            }
                                                            ((int[]) objArr33[c])[c] = i;
                                                            ((int[]) objArr33[c2])[c] = i342;
                                                            objArr33[3] = null;
                                                            int i345 = ~((int) Process.getStartUptimeMillis());
                                                            int i346 = i2 + 37728507 + (((~((-271176853) | i345)) | (-707446923)) * (-983)) + (((~(i345 | (-707446923))) | 704776202) * 983) + 16;
                                                            int i347 = i346 << 13;
                                                            int i348 = ((~i346) & i347) | ((~i347) & i346);
                                                            int i349 = i348 >>> 17;
                                                            int i350 = (i348 | i349) & (~(i348 & i349));
                                                            int i351 = i350 << 5;
                                                            ((int[]) objArr33[2])[0] = (i350 | i351) & (~(i350 & i351));
                                                            return objArr33;
                                                        }
                                                        i14++;
                                                    } catch (Throwable th) {
                                                        Throwable cause = th.getCause();
                                                        if (cause != null) {
                                                            throw cause;
                                                        }
                                                        throw th;
                                                    }
                                                }
                                                i214++;
                                                objArr19 = objArr23;
                                                i18 = 1;
                                            } catch (Throwable th2) {
                                                Throwable cause2 = th2.getCause();
                                                if (cause2 != null) {
                                                    throw cause2;
                                                }
                                                throw th2;
                                            }
                                        } catch (Throwable th3) {
                                            Throwable cause3 = th3.getCause();
                                            if (cause3 != null) {
                                                throw cause3;
                                            }
                                            throw th3;
                                        }
                                    } catch (Throwable th4) {
                                        Throwable cause4 = th4.getCause();
                                        if (cause4 != null) {
                                            throw cause4;
                                        }
                                        throw th4;
                                    }
                                }
                            } catch (Throwable th5) {
                                Throwable cause5 = th5.getCause();
                                if (cause5 != null) {
                                    throw cause5;
                                }
                                throw th5;
                            }
                        } catch (Throwable th6) {
                            Throwable cause6 = th6.getCause();
                            if (cause6 != null) {
                                throw cause6;
                            }
                            throw th6;
                        }
                    } catch (Throwable th7) {
                        Throwable cause7 = th7.getCause();
                        if (cause7 != null) {
                            throw cause7;
                        }
                        throw th7;
                    }
                } catch (Throwable th8) {
                    Throwable cause8 = th8.getCause();
                    if (cause8 != null) {
                        throw cause8;
                    }
                    throw th8;
                }
            } catch (Throwable th9) {
                Throwable cause9 = th9.getCause();
                if (cause9 != null) {
                    throw cause9;
                }
                throw th9;
            }
        } catch (Throwable unused) {
        }
        Object[] objArr34 = new Object[4];
        objArr34[0] = new int[]{i};
        int[] iArr = new int[1];
        objArr34[1] = iArr;
        objArr34[2] = new int[1];
        int i352 = artificialFrame + 11;
        int i353 = i352 % 128;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i353;
        if (i352 % 2 != 0) {
            iArr[0] = i;
            objArr34[2] = null;
        } else {
            iArr[0] = i;
            objArr34[3] = null;
        }
        int i354 = i353 + 53;
        artificialFrame = i354 % 128;
        if (i354 % 2 == 0) {
            int i355 = ~((int) Runtime.getRuntime().totalMemory());
            i3 = i2 >> ((((1300475790 + (((~(i355 | (-554893393))) | (~((-335560845) | i355))) * (-184))) + (((44084769 | (~((-379645614) | i355))) | (~((-598978162) | i355))) * SyslogConstants.LOG_LOCAL7)) + 156485080) % 0);
        } else {
            int i356 = (-632893538) + (((~(423659392 | i)) | 554964382) * 672);
            int i357 = ~i;
            i3 = i2 + i356 + (((~(i | 554964382)) | (~((-423659393) | i357))) * (-672)) + (((~((-554964383) | i357)) | 538185758) * 672);
        }
        int i358 = i3 << 13;
        int i359 = ((~i3) & i358) | ((~i358) & i3);
        int i360 = i359 ^ (i359 >>> 17);
        int i361 = i360 << 5;
        ((int[]) objArr34[2])[0] = (i360 | i361) & (~(i360 & i361));
        return objArr34;
    }
}
