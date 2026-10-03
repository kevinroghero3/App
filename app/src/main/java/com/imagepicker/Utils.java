package com.imagepicker;

import android.app.Activity;
import android.content.ClipData;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.util.Base64;
import android.webkit.MimeTypeMap;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.exifinterface.media.ExifInterface;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes3.dex */
public class Utils {
    public static String cameraPermissionDescription = "This library does not require Manifest.permission.CAMERA, if you add this permission in manifest then you have to obtain the same.";
    public static String errCameraUnavailable = "camera_unavailable";
    public static String errOthers = "others";
    public static String errPermission = "permission";
    public static String fileNamePrefix = "rn_image_picker_lib_temp_";
    public static String mediaTypePhoto = "photo";
    public static String mediaTypeVideo = "video";

    static boolean isValidRequestCode(int i) {
        switch (i) {
            case ImagePickerModuleImpl.REQUEST_LAUNCH_IMAGE_CAPTURE /* 13001 */:
            case ImagePickerModuleImpl.REQUEST_LAUNCH_VIDEO_CAPTURE /* 13002 */:
            case ImagePickerModuleImpl.REQUEST_LAUNCH_LIBRARY /* 13003 */:
                return true;
            default:
                return false;
        }
    }

    public static File createFile(Context context, String str) {
        try {
            File file = new File(context.getCacheDir(), fileNamePrefix + UUID.randomUUID() + "." + str);
            file.createNewFile();
            return file;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Uri createUri(File file, Context context) {
        return FileProvider.getUriForFile(context, context.getApplicationContext().getPackageName() + ".imagepickerprovider", file);
    }

    public static void saveToPublicDirectory(Uri uri, Context context, String str) {
        Uri uriInsert;
        ContentResolver contentResolver = context.getContentResolver();
        ContentValues contentValues = new ContentValues();
        if (str.equals("video")) {
            contentValues.put("_display_name", UUID.randomUUID().toString());
            contentValues.put("mime_type", contentResolver.getType(uri));
            uriInsert = contentResolver.insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, contentValues);
        } else {
            contentValues.put("_display_name", UUID.randomUUID().toString());
            contentValues.put("mime_type", contentResolver.getType(uri));
            uriInsert = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
        }
        copyUri(uri, uriInsert, contentResolver);
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0030 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static void copyUri(Uri uri, Uri uri2, ContentResolver contentResolver) {
        try {
            OutputStream outputStreamOpenOutputStream = contentResolver.openOutputStream(uri2);
            try {
                InputStream inputStreamOpenInputStream = contentResolver.openInputStream(uri);
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int i = inputStreamOpenInputStream.read(bArr);
                        if (i == -1) {
                            break;
                        } else {
                            outputStreamOpenOutputStream.write(bArr, 0, i);
                        }
                        if (outputStreamOpenOutputStream != null) {
                            try {
                                outputStreamOpenOutputStream.close();
                            } catch (Throwable th) {
                                th.addSuppressed(th);
                            }
                        }
                        throw th;
                    }
                    inputStreamOpenInputStream.close();
                    if (outputStreamOpenOutputStream != null) {
                        outputStreamOpenOutputStream.close();
                    }
                } catch (Throwable th2) {
                    if (inputStreamOpenInputStream != null) {
                        try {
                            inputStreamOpenInputStream.close();
                        } catch (Throwable th3) {
                            th2.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            } catch (Throwable th4) {
                if (outputStreamOpenOutputStream != null) {
                    outputStreamOpenOutputStream.close();
                }
                throw th4;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Uri getAppSpecificStorageUri(Uri uri, Context context) {
        String string;
        int iLastIndexOf;
        if (uri == null) {
            return null;
        }
        ContentResolver contentResolver = context.getContentResolver();
        String fileTypeFromMime = getFileTypeFromMime(contentResolver.getType(uri));
        if (fileTypeFromMime == null) {
            Cursor cursorQuery = contentResolver.query(uri, null, null, null, null);
            if (cursorQuery.moveToFirst() && (iLastIndexOf = (string = cursorQuery.getString(cursorQuery.getColumnIndex("_display_name"))).lastIndexOf(46)) != -1) {
                fileTypeFromMime = string.substring(iLastIndexOf + 1);
            }
        }
        Uri uriFromFile = Uri.fromFile(createFile(context, fileTypeFromMime));
        copyUri(uri, uriFromFile, contentResolver);
        return uriFromFile;
    }

    public static boolean isCameraAvailable(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.camera") || context.getPackageManager().hasSystemFeature("android.hardware.camera.any");
    }

    public static void setFrontCamera(Intent intent) {
        int i = Build.VERSION.SDK_INT;
        intent.putExtra("android.intent.extras.CAMERA_FACING", 0);
        if (i >= 26) {
            intent.putExtra("android.intent.extra.USE_FRONT_CAMERA", true);
        }
    }

    public static int[] getImageDimensions(Uri uri, Context context) {
        try {
            InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
            try {
                String orientation = getOrientation(uri, context);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeStream(inputStreamOpenInputStream, null, options);
                if (needToSwapDimension(orientation)) {
                    int[] iArr = {options.outHeight, options.outWidth};
                    if (inputStreamOpenInputStream != null) {
                        inputStreamOpenInputStream.close();
                    }
                    return iArr;
                }
                int[] iArr2 = {options.outWidth, options.outHeight};
                if (inputStreamOpenInputStream != null) {
                    inputStreamOpenInputStream.close();
                }
                return iArr2;
            } catch (Throwable th) {
                if (inputStreamOpenInputStream != null) {
                    try {
                        inputStreamOpenInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return new int[]{0, 0};
        }
    }

    static boolean hasPermission(Activity activity) {
        return ContextCompat.checkSelfPermission(activity, "android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x003a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    static String getBase64String(Uri uri, Context context) {
        try {
            InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int i = inputStreamOpenInputStream.read(bArr);
                        if (i != -1) {
                            byteArrayOutputStream.write(bArr, 0, i);
                        } else {
                            String strEncodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
                            byteArrayOutputStream.close();
                            inputStreamOpenInputStream.close();
                            return strEncodeToString;
                        }
                        if (inputStreamOpenInputStream != null) {
                            try {
                                inputStreamOpenInputStream.close();
                            } catch (Throwable th) {
                                th.addSuppressed(th);
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                    throw th2;
                }
            } catch (Throwable th4) {
                if (inputStreamOpenInputStream != null) {
                    inputStreamOpenInputStream.close();
                }
                throw th4;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static boolean needToSwapDimension(String str) {
        return str.equals(String.valueOf(6)) || str.equals(String.valueOf(8));
    }

    public static Uri resizeImage(Uri uri, Context context, Options options) {
        Bitmap bitmapCreateScaledBitmap;
        try {
            int[] imageDimensions = getImageDimensions(uri, context);
            if (!shouldResizeImage(imageDimensions[0], imageDimensions[1], options)) {
                return uri;
            }
            int[] imageDimensBasedOnConstraints = getImageDimensBasedOnConstraints(imageDimensions[0], imageDimensions[1], options);
            InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
            try {
                String mimeType = getMimeType(uri, context);
                Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpenInputStream);
                String orientation = getOrientation(uri, context);
                if (needToSwapDimension(orientation)) {
                    bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapDecodeStream, imageDimensBasedOnConstraints[1], imageDimensBasedOnConstraints[0], true);
                } else {
                    bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapDecodeStream, imageDimensBasedOnConstraints[0], imageDimensBasedOnConstraints[1], true);
                }
                File fileCreateFile = createFile(context, getFileTypeFromMime(mimeType));
                OutputStream outputStreamOpenOutputStream = context.getContentResolver().openOutputStream(Uri.fromFile(fileCreateFile));
                try {
                    bitmapCreateScaledBitmap.compress(getBitmapCompressFormat(mimeType), options.quality, outputStreamOpenOutputStream);
                    if (outputStreamOpenOutputStream != null) {
                        outputStreamOpenOutputStream.close();
                    }
                    setOrientation(fileCreateFile, orientation, context);
                    deleteFile(uri);
                    Uri uriFromFile = Uri.fromFile(fileCreateFile);
                    if (inputStreamOpenInputStream != null) {
                        inputStreamOpenInputStream.close();
                    }
                    return uriFromFile;
                } catch (Throwable th) {
                    if (outputStreamOpenOutputStream != null) {
                        try {
                            outputStreamOpenOutputStream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                if (inputStreamOpenInputStream != null) {
                    try {
                        inputStreamOpenInputStream.close();
                    } catch (Throwable th4) {
                        th3.addSuppressed(th4);
                    }
                }
                throw th3;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return uri;
        }
    }

    static String getOrientation(Uri uri, Context context) throws IOException {
        return new ExifInterface(context.getContentResolver().openInputStream(uri)).getAttribute(ExifInterface.TAG_ORIENTATION);
    }

    static void setOrientation(File file, String str, Context context) throws Throwable {
        if (str.equals(String.valueOf(1)) || str.equals(String.valueOf(0))) {
            return;
        }
        ExifInterface exifInterface = new ExifInterface(file);
        exifInterface.setAttribute(ExifInterface.TAG_ORIENTATION, str);
        exifInterface.saveAttributes();
    }

    static int[] getImageDimensBasedOnConstraints(int i, int i2, Options options) {
        int i3;
        int i4 = options.maxWidth;
        if (i4 == 0 || (i3 = options.maxHeight) == 0) {
            return new int[]{i, i2};
        }
        if (i4 < i) {
            i2 = (int) ((i4 / i) * i2);
            i = i4;
        }
        if (i3 < i2) {
            i = (int) ((i3 / i2) * i);
        } else {
            i3 = i2;
        }
        return new int[]{i, i3};
    }

    static double getFileSize(Uri uri, Context context) {
        try {
            ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "r");
            try {
                double statSize = parcelFileDescriptorOpenFileDescriptor.getStatSize();
                parcelFileDescriptorOpenFileDescriptor.close();
                return statSize;
            } catch (Throwable th) {
                if (parcelFileDescriptorOpenFileDescriptor != null) {
                    try {
                        parcelFileDescriptorOpenFileDescriptor.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0.0d;
        }
    }

    static boolean shouldResizeImage(int i, int i2, Options options) {
        int i3 = options.maxWidth;
        if ((i3 == 0 || options.maxHeight == 0) && options.quality == 100) {
            return false;
        }
        return i3 < i || options.maxHeight < i2 || options.quality != 100;
    }

    static Bitmap.CompressFormat getBitmapCompressFormat(String str) {
        str.hashCode();
        if (str.equals("image/jpeg")) {
            return Bitmap.CompressFormat.JPEG;
        }
        if (str.equals("image/png")) {
            return Bitmap.CompressFormat.PNG;
        }
        return Bitmap.CompressFormat.JPEG;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0039  */
    static String getFileTypeFromMime(String str) {
        byte b;
        if (str == null) {
            return "jpg";
        }
        int iHashCode = str.hashCode();
        if (iHashCode != -1487394660) {
            if (iHashCode != -879267568) {
                if (iHashCode == -879258763 && str.equals("image/png")) {
                    b = 2;
                } else {
                    b = -1;
                }
            } else if (str.equals("image/gif")) {
                b = 1;
            } else {
                b = -1;
            }
        } else if (str.equals("image/jpeg")) {
            b = 0;
        } else {
            b = -1;
        }
        if (b == 0) {
            return "jpg";
        }
        if (b == 1) {
            return "gif";
        }
        if (b == 2) {
            return "png";
        }
        return MimeTypeMap.getSingleton().getExtensionFromMimeType(str);
    }

    static void deleteFile(Uri uri) {
        new File(uri.getPath()).delete();
    }

    public static boolean isCameraPermissionFulfilled(Context context, Activity activity) {
        try {
            String[] strArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
            return strArr == null || !Arrays.asList(strArr).contains("android.permission.CAMERA") || ContextCompat.checkSelfPermission(activity, "android.permission.CAMERA") == 0;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return true;
        }
    }

    static boolean isImageType(Uri uri, Context context) {
        return isContentType("image/", uri, context);
    }

    static boolean isVideoType(Uri uri, Context context) {
        return isContentType("video/", uri, context);
    }

    static boolean isContentType(String str, Uri uri, Context context) {
        String mimeType = getMimeType(uri, context);
        if (mimeType != null) {
            return mimeType.contains(str);
        }
        return false;
    }

    static String getMimeType(Uri uri, Context context) {
        if (uri.getScheme().equals("file")) {
            return MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(uri.toString()));
        }
        if (uri.getScheme().equals("content")) {
            String type = context.getContentResolver().getType(uri);
            return Utils$$ExternalSyntheticBackport0.m(type) ? getMimeTypeForContent(uri, context) : type;
        }
        return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
    }

    static String getMimeTypeForContent(Uri uri, Context context) {
        String fileNameForContent = getFileNameForContent(uri, context);
        int iLastIndexOf = fileNameForContent.lastIndexOf(46);
        if (iLastIndexOf == -1) {
            return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        }
        return fileNameForContent.substring(iLastIndexOf + 1);
    }

    static String getFileName(Uri uri, Context context) {
        if (uri.getScheme().equals("file")) {
            return uri.getLastPathSegment();
        }
        if (uri.getScheme().equals("content")) {
            return getFileNameForContent(uri, context);
        }
        return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
    }

    static String getOriginalFilePath(Uri uri, Context context) {
        if (uri.getScheme().contains("content")) {
            String filePathFromContent = getFilePathFromContent(uri, context);
            getAppSpecificStorageUri(uri, context);
            return filePathFromContent;
        }
        return uri.toString();
    }

    private static String getFilePathFromContent(Uri uri, Context context) {
        Cursor cursorQuery = context.getContentResolver().query(uri, new String[]{"_data"}, null, null, null);
        try {
            int columnIndex = cursorQuery.getColumnIndex("_data");
            if (columnIndex != -1) {
                cursorQuery.moveToFirst();
                String string = cursorQuery.getString(columnIndex);
                cursorQuery.close();
                return string;
            }
            cursorQuery.close();
            return null;
        } catch (Throwable th) {
            if (cursorQuery != null) {
                try {
                    cursorQuery.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    private static String getFileNameForContent(Uri uri, Context context) {
        Cursor cursorQuery = context.getContentResolver().query(uri, null, null, null, null);
        String lastPathSegment = uri.getLastPathSegment();
        try {
            if (cursorQuery.moveToFirst()) {
                lastPathSegment = cursorQuery.getString(cursorQuery.getColumnIndex("_display_name"));
            }
            return lastPathSegment;
        } finally {
            cursorQuery.close();
        }
    }

    static List<Uri> collectUrisFromData(Intent intent) {
        if (intent.getClipData() == null) {
            return Collections.singletonList(intent.getData());
        }
        ClipData clipData = intent.getClipData();
        ArrayList arrayList = new ArrayList(clipData.getItemCount());
        for (int i = 0; i < clipData.getItemCount(); i++) {
            arrayList.add(clipData.getItemAt(i).getUri());
        }
        return arrayList;
    }

    static ReadableMap getImageResponseMap(Uri uri, Uri uri2, Options options, Context context) {
        ImageMetadata imageMetadata = new ImageMetadata(uri2, context);
        int[] imageDimensions = getImageDimensions(uri2, context);
        String fileName = getFileName(uri, context);
        String originalFilePath = getOriginalFilePath(uri, context);
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("uri", uri2.toString());
        writableMapCreateMap.putDouble("fileSize", getFileSize(uri2, context));
        writableMapCreateMap.putString("fileName", fileName);
        writableMapCreateMap.putInt("width", imageDimensions[0]);
        writableMapCreateMap.putInt("height", imageDimensions[1]);
        writableMapCreateMap.putString("type", getMimeType(uri2, context));
        writableMapCreateMap.putString("originalPath", originalFilePath);
        if (options.includeBase64.booleanValue()) {
            writableMapCreateMap.putString(ReactNativeBlobUtilConst.RNFB_RESPONSE_BASE64, getBase64String(uri2, context));
        }
        if (options.includeExtra.booleanValue()) {
            writableMapCreateMap.putString("timestamp", imageMetadata.getDateTime());
            writableMapCreateMap.putString("id", fileName);
        }
        return writableMapCreateMap;
    }

    static ReadableMap getVideoResponseMap(Uri uri, Uri uri2, Options options, Context context) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        VideoMetadata videoMetadata = new VideoMetadata(uri2, context);
        String fileName = getFileName(uri, context);
        String originalFilePath = getOriginalFilePath(uri, context);
        writableMapCreateMap.putString("uri", uri2.toString());
        writableMapCreateMap.putDouble("fileSize", getFileSize(uri2, context));
        writableMapCreateMap.putInt("duration", videoMetadata.getDuration());
        writableMapCreateMap.putInt("bitrate", videoMetadata.getBitrate());
        writableMapCreateMap.putString("fileName", fileName);
        writableMapCreateMap.putString("type", getMimeType(uri2, context));
        writableMapCreateMap.putInt("width", videoMetadata.getWidth());
        writableMapCreateMap.putInt("height", videoMetadata.getHeight());
        writableMapCreateMap.putString("originalPath", originalFilePath);
        if (options.includeExtra.booleanValue()) {
            writableMapCreateMap.putString("timestamp", videoMetadata.getDateTime());
            writableMapCreateMap.putString("id", fileName);
        }
        return writableMapCreateMap;
    }

    static ReadableMap getResponseMap(List<Uri> list, Options options, Context context) throws RuntimeException {
        WritableArray writableArrayCreateArray = Arguments.createArray();
        for (int i = 0; i < list.size(); i++) {
            Uri uri = list.get(i);
            Uri appSpecificStorageUri = uri.getScheme().contains("content") ? getAppSpecificStorageUri(uri, context) : uri;
            if (isImageType(uri, context)) {
                writableArrayCreateArray.pushMap(getImageResponseMap(uri, resizeImage(appSpecificStorageUri, context, options), options, context));
            } else if (isVideoType(uri, context)) {
                if (uri.getScheme().contains("content")) {
                    appSpecificStorageUri = getAppSpecificStorageUri(uri, context);
                }
                writableArrayCreateArray.pushMap(getVideoResponseMap(uri, appSpecificStorageUri, options, context));
            } else {
                throw new RuntimeException("Unsupported file type");
            }
        }
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putArray("assets", writableArrayCreateArray);
        return writableMapCreateMap;
    }

    static ReadableMap getErrorMap(String str, String str2) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("errorCode", str);
        if (str2 != null) {
            writableMapCreateMap.putString("errorMessage", str2);
        }
        return writableMapCreateMap;
    }

    static ReadableMap getCancelMap() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putBoolean("didCancel", true);
        return writableMapCreateMap;
    }
}
