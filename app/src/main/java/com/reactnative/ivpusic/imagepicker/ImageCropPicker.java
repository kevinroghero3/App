package com.reactnative.ivpusic.imagepicker;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.util.Base64;
import android.util.Log;
import android.webkit.MimeTypeMap;
import androidx.activity.result.PickVisualMediaRequest;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.PromiseImpl;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.modules.core.PermissionAwareActivity;
import com.facebook.react.modules.core.PermissionListener;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.yalantis.ucrop.UCrop;
import io.sentry.android.core.SentryLogcatAdapter;
import io.sentry.instrumentation.file.SentryFileInputStream;
import io.sentry.instrumentation.file.SentryFileOutputStream;
import io.sentry.rrweb.RRWebVideoEvent;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Callable;
import net.openid.appauth.ResponseTypeValues;

/* JADX INFO: loaded from: classes3.dex */
class ImageCropPicker implements ActivityEventListener {
    private static final int CAMERA_PICKER_REQUEST = 61111;
    private static final String E_ACTIVITY_DOES_NOT_EXIST = "E_ACTIVITY_DOES_NOT_EXIST";
    private static final String E_CALLBACK_ERROR = "E_CALLBACK_ERROR";
    private static final String E_CAMERA_IS_NOT_AVAILABLE = "E_CAMERA_IS_NOT_AVAILABLE";
    private static final String E_CANNOT_LAUNCH_CAMERA = "E_CANNOT_LAUNCH_CAMERA";
    private static final String E_ERROR_WHILE_CLEANING_FILES = "E_ERROR_WHILE_CLEANING_FILES";
    private static final String E_FAILED_TO_OPEN_CAMERA = "E_FAILED_TO_OPEN_CAMERA";
    private static final String E_FAILED_TO_SHOW_PICKER = "E_FAILED_TO_SHOW_PICKER";
    private static final String E_LOW_MEMORY_ERROR = "E_LOW_MEMORY_ERROR";
    private static final String E_NO_CAMERA_PERMISSION_KEY = "E_NO_CAMERA_PERMISSION";
    private static final String E_NO_CAMERA_PERMISSION_MSG = "User did not grant camera permission.";
    private static final String E_NO_IMAGE_DATA_FOUND = "E_NO_IMAGE_DATA_FOUND";
    private static final String E_NO_LIBRARY_PERMISSION_KEY = "E_NO_LIBRARY_PERMISSION";
    private static final String E_NO_LIBRARY_PERMISSION_MSG = "User did not grant library permission.";
    private static final String E_PICKER_CANCELLED_KEY = "E_PICKER_CANCELLED";
    private static final String E_PICKER_CANCELLED_MSG = "User cancelled image selection";
    private static final int IMAGE_PICKER_REQUEST = 61110;
    static final String NAME = "RNCImageCropPicker";
    private Uri mCameraCaptureURI;
    private String mCurrentMediaPath;
    private ReadableMap options;
    private ReactApplicationContext reactContext;
    private String mediaType = "any";
    private boolean multiple = false;
    private boolean includeBase64 = false;
    private boolean includeExif = false;
    private boolean cropping = false;
    private boolean cropperCircleOverlay = false;
    private boolean freeStyleCropEnabled = false;
    private boolean showCropGuidelines = true;
    private boolean showCropFrame = true;
    private boolean hideBottomControls = false;
    private boolean enableRotationGesture = false;
    private boolean disableCropperColorSetters = false;
    private boolean useFrontCamera = false;
    private boolean cropperStatusBarLight = true;
    private boolean cropperNavigationBarLight = false;
    private String cropperActiveWidgetColor = null;
    private String cropperToolbarColor = null;
    private String cropperToolbarTitle = null;
    private String cropperToolbarWidgetColor = null;
    private int width = 0;
    private int height = 0;
    private int maxFiles = 5;
    private ResultCollector resultCollector = new ResultCollector();
    private Compression compression = new Compression();

    @Override // com.facebook.react.bridge.ActivityEventListener
    public void onNewIntent(Intent intent) {
    }

    ImageCropPicker(ReactApplicationContext reactApplicationContext) {
        this.reactContext = reactApplicationContext;
        reactApplicationContext.addActivityEventListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getTmpDir(Activity activity) {
        String str = activity.getCacheDir() + "/react-native-image-crop-picker";
        new File(str).mkdir();
        return str;
    }

    private void setConfiguration(ReadableMap readableMap) {
        this.mediaType = readableMap.hasKey("mediaType") ? readableMap.getString("mediaType") : "any";
        this.multiple = readableMap.hasKey("multiple") && readableMap.getBoolean("multiple");
        this.includeBase64 = readableMap.hasKey("includeBase64") && readableMap.getBoolean("includeBase64");
        this.includeExif = readableMap.hasKey("includeExif") && readableMap.getBoolean("includeExif");
        this.width = readableMap.hasKey("width") ? readableMap.getInt("width") : 0;
        this.height = readableMap.hasKey("height") ? readableMap.getInt("height") : 0;
        this.maxFiles = readableMap.hasKey("maxFiles") ? readableMap.getInt("maxFiles") : this.maxFiles;
        this.cropping = readableMap.hasKey("cropping") && readableMap.getBoolean("cropping");
        this.cropperActiveWidgetColor = readableMap.hasKey("cropperActiveWidgetColor") ? readableMap.getString("cropperActiveWidgetColor") : null;
        this.cropperToolbarColor = readableMap.hasKey("cropperToolbarColor") ? readableMap.getString("cropperToolbarColor") : null;
        this.cropperToolbarTitle = readableMap.hasKey("cropperToolbarTitle") ? readableMap.getString("cropperToolbarTitle") : null;
        this.cropperToolbarWidgetColor = readableMap.hasKey("cropperToolbarWidgetColor") ? readableMap.getString("cropperToolbarWidgetColor") : null;
        this.cropperCircleOverlay = readableMap.hasKey("cropperCircleOverlay") && readableMap.getBoolean("cropperCircleOverlay");
        this.freeStyleCropEnabled = readableMap.hasKey("freeStyleCropEnabled") && readableMap.getBoolean("freeStyleCropEnabled");
        this.showCropGuidelines = !readableMap.hasKey("showCropGuidelines") || readableMap.getBoolean("showCropGuidelines");
        this.showCropFrame = !readableMap.hasKey("showCropFrame") || readableMap.getBoolean("showCropFrame");
        this.hideBottomControls = readableMap.hasKey("hideBottomControls") && readableMap.getBoolean("hideBottomControls");
        this.enableRotationGesture = readableMap.hasKey("enableRotationGesture") && readableMap.getBoolean("enableRotationGesture");
        this.disableCropperColorSetters = readableMap.hasKey("disableCropperColorSetters") && readableMap.getBoolean("disableCropperColorSetters");
        this.useFrontCamera = readableMap.hasKey("useFrontCamera") && readableMap.getBoolean("useFrontCamera");
        this.cropperStatusBarLight = readableMap.hasKey("cropperStatusBarLight") ? readableMap.getBoolean("cropperStatusBarLight") : true;
        this.cropperNavigationBarLight = readableMap.hasKey("cropperNavigationBarLight") ? readableMap.getBoolean("cropperNavigationBarLight") : false;
        this.options = readableMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteRecursive(File file) {
        if (file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                deleteRecursive(file2);
            }
        }
        file.delete();
    }

    public void clean(final Promise promise) {
        final Activity currentActivity = this.reactContext.getCurrentActivity();
        if (currentActivity == null) {
            promise.reject(E_ACTIVITY_DOES_NOT_EXIST, "Activity doesn't exist");
        } else {
            permissionsCheck(currentActivity, promise, Collections.singletonList("android.permission.WRITE_EXTERNAL_STORAGE"), new Callable<Void>() { // from class: com.reactnative.ivpusic.imagepicker.ImageCropPicker.1
                @Override // java.util.concurrent.Callable
                public Void call() {
                    try {
                        File file = new File(this.getTmpDir(currentActivity));
                        if (!file.exists()) {
                            throw new Exception("File does not exist");
                        }
                        this.deleteRecursive(file);
                        promise.resolve(null);
                        return null;
                    } catch (Exception e) {
                        e.printStackTrace();
                        promise.reject(ImageCropPicker.E_ERROR_WHILE_CLEANING_FILES, e.getMessage());
                    }
                }
            });
        }
    }

    public void cleanSingle(final String str, final Promise promise) {
        if (str == null) {
            promise.reject(E_ERROR_WHILE_CLEANING_FILES, "Cannot cleanup empty path");
            return;
        }
        Activity currentActivity = this.reactContext.getCurrentActivity();
        if (currentActivity == null) {
            promise.reject(E_ACTIVITY_DOES_NOT_EXIST, "Activity doesn't exist");
        } else {
            permissionsCheck(currentActivity, promise, Collections.singletonList("android.permission.WRITE_EXTERNAL_STORAGE"), new Callable<Void>() { // from class: com.reactnative.ivpusic.imagepicker.ImageCropPicker.2
                @Override // java.util.concurrent.Callable
                public Void call() {
                    try {
                        String strSubstring = str;
                        if (strSubstring.startsWith("file://")) {
                            strSubstring = strSubstring.substring(7);
                        }
                        File file = new File(strSubstring);
                        if (!file.exists()) {
                            throw new Exception("File does not exist. Path: " + strSubstring);
                        }
                        this.deleteRecursive(file);
                        promise.resolve(null);
                        return null;
                    } catch (Exception e) {
                        e.printStackTrace();
                        promise.reject(ImageCropPicker.E_ERROR_WHILE_CLEANING_FILES, e.getMessage());
                    }
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void permissionsCheck(Activity activity, final Promise promise, List<String> list, final Callable<Void> callable) {
        ArrayList arrayList = new ArrayList();
        ArrayList<String> arrayList2 = new ArrayList(list);
        if (Build.VERSION.SDK_INT > 29) {
            arrayList2.remove("android.permission.WRITE_EXTERNAL_STORAGE");
        }
        for (String str : arrayList2) {
            if (ContextCompat.checkSelfPermission(activity, str) != 0) {
                arrayList.add(str);
            }
        }
        if (!arrayList.isEmpty()) {
            ((PermissionAwareActivity) activity).requestPermissions((String[]) arrayList.toArray(new String[arrayList.size()]), 1, new PermissionListener() { // from class: com.reactnative.ivpusic.imagepicker.ImageCropPicker.3
                @Override // com.facebook.react.modules.core.PermissionListener
                public boolean onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
                    if (i == 1) {
                        for (int i2 = 0; i2 < strArr.length; i2++) {
                            String str2 = strArr[i2];
                            if (iArr[i2] == -1) {
                                if (str2.equals("android.permission.CAMERA")) {
                                    promise.reject(ImageCropPicker.E_NO_CAMERA_PERMISSION_KEY, ImageCropPicker.E_NO_CAMERA_PERMISSION_MSG);
                                } else if (str2.equals("android.permission.WRITE_EXTERNAL_STORAGE")) {
                                    promise.reject(ImageCropPicker.E_NO_LIBRARY_PERMISSION_KEY, ImageCropPicker.E_NO_LIBRARY_PERMISSION_MSG);
                                } else {
                                    promise.reject(ImageCropPicker.E_NO_LIBRARY_PERMISSION_KEY, "Required permission missing");
                                }
                                return true;
                            }
                        }
                        try {
                            callable.call();
                        } catch (Exception e) {
                            promise.reject(ImageCropPicker.E_CALLBACK_ERROR, "Unknown error", e);
                        }
                    }
                    return true;
                }
            });
            return;
        }
        try {
            callable.call();
        } catch (Exception e) {
            promise.reject(E_CALLBACK_ERROR, "Unknown error", e);
        }
    }

    public void openCamera(ReadableMap readableMap, Promise promise) {
        final Activity currentActivity = this.reactContext.getCurrentActivity();
        if (currentActivity == null) {
            promise.reject(E_ACTIVITY_DOES_NOT_EXIST, "Activity doesn't exist");
        } else {
            if (!isCameraAvailable(currentActivity)) {
                promise.reject(E_CAMERA_IS_NOT_AVAILABLE, "Camera not available");
                return;
            }
            setConfiguration(readableMap);
            this.resultCollector.setup(promise, false);
            permissionsCheck(currentActivity, promise, Arrays.asList("android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE"), new Callable<Void>() { // from class: com.reactnative.ivpusic.imagepicker.ImageCropPicker.4
                @Override // java.util.concurrent.Callable
                public Void call() {
                    ImageCropPicker.this.initiateCamera(currentActivity);
                    return null;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initiateCamera(Activity activity) {
        File fileCreateImageFile;
        String str;
        try {
            if (this.mediaType.equals("video")) {
                fileCreateImageFile = createVideoFile();
                str = "android.media.action.VIDEO_CAPTURE";
            } else {
                fileCreateImageFile = createImageFile();
                str = "android.media.action.IMAGE_CAPTURE";
            }
            Intent intent = new Intent(str);
            Uri uriForFile = FileProvider.getUriForFile(activity, activity.getApplicationContext().getPackageName() + ".provider", fileCreateImageFile);
            this.mCameraCaptureURI = uriForFile;
            intent.putExtra("output", uriForFile);
            if (this.useFrontCamera) {
                intent.putExtra("android.intent.extras.CAMERA_FACING", 1);
                intent.putExtra("android.intent.extras.LENS_FACING_FRONT", 1);
                intent.putExtra("android.intent.extra.USE_FRONT_CAMERA", true);
            }
            if (intent.resolveActivity(activity.getPackageManager()) == null) {
                this.resultCollector.notifyProblem(E_CANNOT_LAUNCH_CAMERA, "Cannot launch camera");
            } else {
                activity.startActivityForResult(intent, CAMERA_PICKER_REQUEST);
            }
        } catch (Exception e) {
            this.resultCollector.notifyProblem(E_FAILED_TO_OPEN_CAMERA, e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initiatePicker(Activity activity) {
        Intent intentCreateIntent;
        try {
            PickVisualMediaRequest.Builder builder = new PickVisualMediaRequest.Builder();
            if (this.mediaType.equals("video")) {
                builder.setMediaType(ActivityResultContracts.PickVisualMedia.VideoOnly.INSTANCE);
            } else if (this.mediaType.equals(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_PHOTO) || this.cropping) {
                builder.setMediaType(ActivityResultContracts.PickVisualMedia.ImageOnly.INSTANCE);
            } else {
                builder.setMediaType(ActivityResultContracts.PickVisualMedia.ImageAndVideo.INSTANCE);
            }
            if (this.multiple && this.maxFiles > 1) {
                intentCreateIntent = new ActivityResultContracts.PickMultipleVisualMedia(this.maxFiles).createIntent((Context) activity, builder.build());
            } else {
                intentCreateIntent = new ActivityResultContracts.PickVisualMedia().createIntent((Context) activity, builder.build());
            }
            activity.startActivityForResult(intentCreateIntent, IMAGE_PICKER_REQUEST);
        } catch (Exception e) {
            this.resultCollector.notifyProblem(E_FAILED_TO_SHOW_PICKER, e);
        }
    }

    public void openPicker(ReadableMap readableMap, Promise promise) {
        final Activity currentActivity = this.reactContext.getCurrentActivity();
        if (currentActivity == null) {
            promise.reject(E_ACTIVITY_DOES_NOT_EXIST, "Activity doesn't exist");
            return;
        }
        setConfiguration(readableMap);
        this.resultCollector.setup(promise, this.multiple);
        permissionsCheck(currentActivity, promise, Collections.singletonList("android.permission.WRITE_EXTERNAL_STORAGE"), new Callable<Void>() { // from class: com.reactnative.ivpusic.imagepicker.ImageCropPicker.5
            @Override // java.util.concurrent.Callable
            public Void call() {
                ImageCropPicker.this.initiatePicker(currentActivity);
                return null;
            }
        });
    }

    public void openCropper(ReadableMap readableMap, Promise promise) {
        final Activity currentActivity = this.reactContext.getCurrentActivity();
        if (currentActivity == null) {
            promise.reject(E_ACTIVITY_DOES_NOT_EXIST, "Activity doesn't exist");
            return;
        }
        setConfiguration(readableMap);
        this.resultCollector.setup(promise, false);
        final Uri uri = Uri.parse(readableMap.getString("path"));
        permissionsCheck(currentActivity, promise, Collections.singletonList("android.permission.WRITE_EXTERNAL_STORAGE"), new Callable<Void>() { // from class: com.reactnative.ivpusic.imagepicker.ImageCropPicker.6
            @Override // java.util.concurrent.Callable
            public Void call() {
                ImageCropPicker.this.startCropping(currentActivity, uri);
                return null;
            }
        });
    }

    private String getBase64StringFromFile(String str) {
        try {
            FileInputStream fileInputStreamCreate = SentryFileInputStream.Factory.create(new FileInputStream(str), str);
            byte[] bArr = new byte[8192];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                try {
                    int i = fileInputStreamCreate.read(bArr);
                    if (i == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, i);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private String getMimeType(String str) {
        Uri uriFromFile = Uri.fromFile(new File(str));
        if (uriFromFile.getScheme().equals("content")) {
            return this.reactContext.getContentResolver().getType(uriFromFile);
        }
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(uriFromFile.toString());
        if (fileExtensionFromUrl != null) {
            return MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl.toLowerCase());
        }
        return null;
    }

    private WritableMap getSelection(Activity activity, Uri uri, boolean z) throws Exception {
        String strResolveRealPath = resolveRealPath(activity, uri, z);
        if (strResolveRealPath == null || strResolveRealPath.isEmpty()) {
            throw new Exception("Cannot resolve asset path.");
        }
        String mimeType = getMimeType(strResolveRealPath);
        if (mimeType != null && mimeType.startsWith("video/")) {
            getVideo(activity, strResolveRealPath, mimeType);
            return null;
        }
        return getImage(activity, strResolveRealPath);
    }

    private void getAsyncSelection(Activity activity, Uri uri, boolean z) throws Exception {
        String strResolveRealPath = resolveRealPath(activity, uri, z);
        if (strResolveRealPath == null || strResolveRealPath.isEmpty()) {
            this.resultCollector.notifyProblem(E_NO_IMAGE_DATA_FOUND, "Cannot resolve asset path.");
            return;
        }
        String mimeType = getMimeType(strResolveRealPath);
        if (mimeType != null && mimeType.startsWith("video/")) {
            getVideo(activity, strResolveRealPath, mimeType);
        } else {
            this.resultCollector.notifySuccess(getImage(activity, strResolveRealPath));
        }
    }

    private Bitmap validateVideo(Uri uri) throws Exception {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(this.reactContext.getCurrentActivity(), uri);
        Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime();
        if (frameAtTime == null) {
            throw new Exception("Cannot retrieve video data");
        }
        mediaMetadataRetriever.release();
        return frameAtTime;
    }

    private static Long getVideoDuration(String str) {
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(str);
            return Long.valueOf(Long.parseLong(mediaMetadataRetriever.extractMetadata(9)));
        } catch (Exception unused) {
            return -1L;
        }
    }

    private void getVideo(final Activity activity, final String str, final String str2) throws Exception {
        validateVideo(Uri.parse(str));
        final String str3 = getTmpDir(activity) + RemoteSettings.FORWARD_SLASH_STRING + UUID.randomUUID().toString() + ".mp4";
        new Thread(new Runnable() { // from class: com.reactnative.ivpusic.imagepicker.ImageCropPicker$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getVideo$2(activity, str, str3, str2);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getVideo$2(Activity activity, String str, String str2, final String str3) {
        this.compression.compressVideo(activity, this.options, str, str2, new PromiseImpl(new Callback() { // from class: com.reactnative.ivpusic.imagepicker.ImageCropPicker$$ExternalSyntheticLambda0
            @Override // com.facebook.react.bridge.Callback
            public final void invoke(Object[] objArr) {
                this.f$0.lambda$getVideo$0(str3, objArr);
            }
        }, new Callback() { // from class: com.reactnative.ivpusic.imagepicker.ImageCropPicker$$ExternalSyntheticLambda1
            @Override // com.facebook.react.bridge.Callback
            public final void invoke(Object[] objArr) {
                this.f$0.lambda$getVideo$1(objArr);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getVideo$0(String str, Object[] objArr) {
        String str2 = (String) objArr[0];
        try {
            Bitmap bitmapValidateVideo = validateVideo(Uri.fromFile(new File(str2)));
            long jLastModified = new File(str2).lastModified();
            long jLongValue = getVideoDuration(str2).longValue();
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            writableNativeMap.putInt("width", bitmapValidateVideo.getWidth());
            writableNativeMap.putInt("height", bitmapValidateVideo.getHeight());
            writableNativeMap.putString("mime", str);
            writableNativeMap.putInt(RRWebVideoEvent.JsonKeys.SIZE, (int) new File(str2).length());
            writableNativeMap.putInt("duration", (int) jLongValue);
            writableNativeMap.putString("path", "file://" + str2);
            writableNativeMap.putString("modificationDate", String.valueOf(jLastModified));
            this.resultCollector.notifySuccess(writableNativeMap);
        } catch (Exception e) {
            this.resultCollector.notifyProblem(E_NO_IMAGE_DATA_FOUND, e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getVideo$1(Object[] objArr) {
        WritableNativeMap writableNativeMap = (WritableNativeMap) objArr[0];
        this.resultCollector.notifyProblem(writableNativeMap.getString(ResponseTypeValues.CODE), writableNativeMap.getString("message"));
    }

    private String resolveRealPath(Activity activity, Uri uri, boolean z) throws IOException {
        String realPathFromURI;
        if (z) {
            realPathFromURI = Uri.parse(this.mCurrentMediaPath).getPath();
        } else {
            realPathFromURI = RealPathUtil.getRealPathFromURI(activity, uri);
        }
        if (Build.VERSION.SDK_INT < 29) {
            return realPathFromURI;
        }
        String type = activity.getContentResolver().getType(uri);
        if (type == null || !type.startsWith("video/")) {
            return (realPathFromURI.startsWith(Uri.fromFile(activity.getExternalCacheDir()).getPath()) || realPathFromURI.startsWith(Uri.fromFile(activity.getExternalFilesDir(null)).getPath()) || realPathFromURI.startsWith(Uri.fromFile(activity.getCacheDir()).getPath()) || realPathFromURI.startsWith(Uri.fromFile(activity.getFilesDir()).getPath())) ? realPathFromURI : RealPathUtil.getRealPathFromURI(activity, Uri.fromFile(createExternalStoragePrivateFile(activity, uri)));
        }
        return RealPathUtil.getRealPathFromURI(activity, uri);
    }

    private File createExternalStoragePrivateFile(Context context, Uri uri) throws FileNotFoundException {
        InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
        String extension = getExtension(context, uri);
        File file = new File(context.getExternalCacheDir(), "/temp/" + System.currentTimeMillis() + "." + extension);
        File parentFile = file.getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
        }
        try {
            FileOutputStream fileOutputStreamCreate = SentryFileOutputStream.Factory.create(new FileOutputStream(file), file);
            byte[] bArr = new byte[inputStreamOpenInputStream.available()];
            inputStreamOpenInputStream.read(bArr);
            fileOutputStreamCreate.write(bArr);
            inputStreamOpenInputStream.close();
            fileOutputStreamCreate.close();
        } catch (IOException e) {
            SentryLogcatAdapter.w("image-crop-picker", "Error writing " + file, e);
        }
        return file;
    }

    public String getExtension(Context context, Uri uri) {
        if (uri.getScheme().equals("content")) {
            return MimeTypeMap.getSingleton().getExtensionFromMimeType(context.getContentResolver().getType(uri));
        }
        return MimeTypeMap.getFileExtensionFromUrl(Uri.fromFile(new File(uri.getPath())).toString());
    }

    private BitmapFactory.Options validateImage(String str) throws Exception {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        options.inDither = true;
        BitmapFactory.decodeFile(str, options);
        if (options.outMimeType == null || options.outWidth == 0 || options.outHeight == 0) {
            throw new Exception("Invalid image selected");
        }
        return options;
    }

    private WritableMap getImage(Activity activity, String str) throws Exception {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        if (str.startsWith("http://") || str.startsWith("https://")) {
            throw new Exception("Cannot select remote files");
        }
        BitmapFactory.Options optionsValidateImage = validateImage(str);
        boolean z = true;
        int attributeInt = new ExifInterface(str).getAttributeInt(ExifInterface.TAG_ORIENTATION, 1);
        if (attributeInt != 6 && attributeInt != 8 && attributeInt != 5 && attributeInt != 7) {
            z = false;
        }
        String path = this.compression.compressImage(this.reactContext, this.options, str, optionsValidateImage).getPath();
        BitmapFactory.Options optionsValidateImage2 = validateImage(path);
        long jLastModified = new File(str).lastModified();
        writableNativeMap.putString("path", "file://" + path);
        writableNativeMap.putInt("width", z ? optionsValidateImage2.outHeight : optionsValidateImage2.outWidth);
        writableNativeMap.putInt("height", z ? optionsValidateImage2.outWidth : optionsValidateImage2.outHeight);
        writableNativeMap.putString("mime", optionsValidateImage2.outMimeType);
        writableNativeMap.putInt(RRWebVideoEvent.JsonKeys.SIZE, (int) new File(path).length());
        writableNativeMap.putString("modificationDate", String.valueOf(jLastModified));
        writableNativeMap.putString("filename", new File(str).getName());
        if (this.includeBase64) {
            writableNativeMap.putString("data", getBase64StringFromFile(path));
        }
        if (this.includeExif) {
            try {
                writableNativeMap.putMap("exif", ExifExtractor.extract(str));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return writableNativeMap;
    }

    private void configureCropperColors(UCrop.Options options) {
        String str = this.cropperActiveWidgetColor;
        if (str != null) {
            options.setActiveControlsWidgetColor(Color.parseColor(str));
        }
        String str2 = this.cropperToolbarColor;
        if (str2 != null) {
            options.setToolbarColor(Color.parseColor(str2));
        }
        String str3 = this.cropperToolbarWidgetColor;
        if (str3 != null) {
            options.setToolbarWidgetColor(Color.parseColor(str3));
        }
        options.setStatusBarLight(this.cropperStatusBarLight);
        options.setNavigationBarLight(this.cropperNavigationBarLight);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startCropping(Activity activity, Uri uri) {
        int i;
        UCrop.Options options = new UCrop.Options();
        options.setCompressionFormat(Bitmap.CompressFormat.JPEG);
        options.setCompressionQuality(100);
        options.setCircleDimmedLayer(this.cropperCircleOverlay);
        options.setFreeStyleCropEnabled(this.freeStyleCropEnabled);
        options.setShowCropGrid(this.showCropGuidelines);
        options.setShowCropFrame(this.showCropFrame);
        options.setHideBottomControls(this.hideBottomControls);
        String str = this.cropperToolbarTitle;
        if (str != null) {
            options.setToolbarTitle(str);
        }
        if (this.enableRotationGesture) {
            options.setAllowedGestures(3, 3, 3);
        }
        if (!this.disableCropperColorSetters) {
            configureCropperColors(options);
        }
        UCrop uCropWithOptions = UCrop.of(uri, Uri.fromFile(new File(getTmpDir(activity), UUID.randomUUID().toString() + ".jpg"))).withOptions(options);
        int i2 = this.width;
        if (i2 > 0 && (i = this.height) > 0) {
            uCropWithOptions.withAspectRatio(i2, i);
        }
        uCropWithOptions.start(activity);
    }

    private void imagePickerResult(Activity activity, int i, int i2, Intent intent) {
        ClipData clipData;
        if (i2 == 0) {
            this.resultCollector.notifyProblem(E_PICKER_CANCELLED_KEY, E_PICKER_CANCELLED_MSG);
            return;
        }
        if (i2 == -1) {
            if (this.multiple) {
                ClipData clipData2 = intent.getClipData();
                try {
                    if (clipData2 == null) {
                        this.resultCollector.setWaitCount(1);
                        getAsyncSelection(activity, intent.getData(), false);
                        return;
                    }
                    this.resultCollector.setWaitCount(clipData2.getItemCount());
                    for (int i3 = 0; i3 < clipData2.getItemCount(); i3++) {
                        getAsyncSelection(activity, clipData2.getItemAt(i3).getUri(), false);
                    }
                    return;
                } catch (Exception e) {
                    this.resultCollector.notifyProblem(E_NO_IMAGE_DATA_FOUND, e.getMessage());
                    return;
                }
            }
            Uri data = intent.getData();
            if (data == null && (clipData = intent.getClipData()) != null && clipData.getItemCount() > 0) {
                data = clipData.getItemAt(0).getUri();
            }
            if (data == null) {
                this.resultCollector.notifyProblem(E_NO_IMAGE_DATA_FOUND, "Cannot resolve image url");
                return;
            }
            if (this.cropping) {
                startCropping(activity, data);
                return;
            }
            try {
                getAsyncSelection(activity, data, false);
            } catch (Exception e2) {
                this.resultCollector.notifyProblem(E_NO_IMAGE_DATA_FOUND, e2.getMessage());
            }
        }
    }

    private void cameraPickerResult(Activity activity, int i, int i2, Intent intent) {
        if (i2 == 0) {
            this.resultCollector.notifyProblem(E_PICKER_CANCELLED_KEY, E_PICKER_CANCELLED_MSG);
            return;
        }
        if (i2 == -1) {
            Uri uri = this.mCameraCaptureURI;
            if (uri == null) {
                this.resultCollector.notifyProblem(E_NO_IMAGE_DATA_FOUND, "Cannot resolve image url");
                return;
            }
            if (this.cropping) {
                new UCrop.Options().setCompressionFormat(Bitmap.CompressFormat.JPEG);
                startCropping(activity, uri);
                return;
            }
            try {
                this.resultCollector.setWaitCount(1);
                WritableMap selection = getSelection(activity, uri, true);
                if (selection != null) {
                    this.resultCollector.notifySuccess(selection);
                }
            } catch (Exception e) {
                this.resultCollector.notifyProblem(E_NO_IMAGE_DATA_FOUND, e.getMessage());
            }
        }
    }

    private void croppingResult(Activity activity, int i, int i2, Intent intent) {
        File fileResize;
        if (intent != null) {
            Uri output = UCrop.getOutput(intent);
            if (output == null) {
                this.resultCollector.notifyProblem(E_NO_IMAGE_DATA_FOUND, "Cannot find image data");
                return;
            }
            try {
                if (this.width > 0 && this.height > 0) {
                    try {
                        Compression compression = this.compression;
                        ReactApplicationContext reactApplicationContext = this.reactContext;
                        String path = output.getPath();
                        int i3 = this.width;
                        int i4 = this.height;
                        fileResize = compression.resize(reactApplicationContext, path, i3, i4, i3, i4, 100);
                    } catch (OutOfMemoryError e) {
                        this.resultCollector.notifyProblem(E_LOW_MEMORY_ERROR, e.getMessage());
                        fileResize = null;
                    }
                    output = Uri.fromFile(fileResize);
                }
                WritableMap selection = getSelection(activity, output, false);
                if (selection != null) {
                    selection.putMap("cropRect", getCroppedRectMap(intent));
                    this.resultCollector.setWaitCount(1);
                    this.resultCollector.notifySuccess(selection);
                    return;
                }
                throw new Exception("Cannot crop video files");
            } catch (Exception e2) {
                this.resultCollector.notifyProblem(E_NO_IMAGE_DATA_FOUND, e2.getMessage());
                return;
            }
        }
        this.resultCollector.notifyProblem(E_PICKER_CANCELLED_KEY, E_PICKER_CANCELLED_MSG);
    }

    @Override // com.facebook.react.bridge.ActivityEventListener
    public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
        Log.d("RESULT", "onActivityResult");
        if (i == IMAGE_PICKER_REQUEST) {
            imagePickerResult(activity, i, i2, intent);
        } else if (i == CAMERA_PICKER_REQUEST) {
            cameraPickerResult(activity, i, i2, intent);
        } else if (i == 69) {
            croppingResult(activity, i, i2, intent);
        }
    }

    private boolean isCameraAvailable(Activity activity) {
        return activity.getPackageManager().hasSystemFeature("android.hardware.camera") || activity.getPackageManager().hasSystemFeature("android.hardware.camera.any");
    }

    private File createImageFile() throws IOException {
        String str = "image-" + UUID.randomUUID().toString();
        File externalFilesDir = this.reactContext.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        if (!externalFilesDir.exists() && !externalFilesDir.isDirectory()) {
            externalFilesDir.mkdirs();
        }
        File fileCreateTempFile = File.createTempFile(str, ".jpg", externalFilesDir);
        this.mCurrentMediaPath = "file:" + fileCreateTempFile.getAbsolutePath();
        return fileCreateTempFile;
    }

    private File createVideoFile() throws IOException {
        String str = "video-" + UUID.randomUUID().toString();
        File externalFilesDir = this.reactContext.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        if (!externalFilesDir.exists() && !externalFilesDir.isDirectory()) {
            externalFilesDir.mkdirs();
        }
        File fileCreateTempFile = File.createTempFile(str, ".mp4", externalFilesDir);
        this.mCurrentMediaPath = "file:" + fileCreateTempFile.getAbsolutePath();
        return fileCreateTempFile;
    }

    private static WritableMap getCroppedRectMap(Intent intent) {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putInt("x", intent.getIntExtra(UCrop.EXTRA_OUTPUT_OFFSET_X, -1));
        writableNativeMap.putInt("y", intent.getIntExtra(UCrop.EXTRA_OUTPUT_OFFSET_Y, -1));
        writableNativeMap.putInt("width", intent.getIntExtra(UCrop.EXTRA_OUTPUT_IMAGE_WIDTH, -1));
        writableNativeMap.putInt("height", intent.getIntExtra(UCrop.EXTRA_OUTPUT_IMAGE_HEIGHT, -1));
        return writableNativeMap;
    }
}
