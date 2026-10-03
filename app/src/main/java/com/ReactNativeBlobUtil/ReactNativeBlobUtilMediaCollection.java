package com.ReactNativeBlobUtil;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.util.Base64;
import androidx.work.Data;
import com.ReactNativeBlobUtil.Utils.FileDescription;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.WritableArray;
import io.sentry.instrumentation.file.SentryFileInputStream;
import io.sentry.instrumentation.file.SentryFileOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes4.dex */
public class ReactNativeBlobUtilMediaCollection {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    public enum MediaType {
        Audio,
        Image,
        Video,
        Download
    }

    private static Uri getMediaUri(MediaType mediaType) {
        if (mediaType == MediaType.Audio) {
            if (Build.VERSION.SDK_INT >= 29) {
                return MediaStore.Audio.Media.getContentUri("external_primary");
            }
            return MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        }
        if (mediaType == MediaType.Video) {
            if (Build.VERSION.SDK_INT >= 29) {
                return MediaStore.Video.Media.getContentUri("external_primary");
            }
            return MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        }
        if (mediaType == MediaType.Image) {
            if (Build.VERSION.SDK_INT >= 29) {
                return MediaStore.Images.Media.getContentUri("external_primary");
            }
            return MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        }
        if (mediaType != MediaType.Download || Build.VERSION.SDK_INT < 29) {
            return null;
        }
        return MediaStore.Downloads.getContentUri("external_primary");
    }

    private static String getRelativePath(MediaType mediaType, ReactApplicationContext reactApplicationContext) {
        if (Build.VERSION.SDK_INT >= 29) {
            if (mediaType == MediaType.Audio) {
                return Environment.DIRECTORY_MUSIC;
            }
            if (mediaType == MediaType.Video) {
                return Environment.DIRECTORY_MOVIES;
            }
            if (mediaType == MediaType.Image) {
                return Environment.DIRECTORY_PICTURES;
            }
            return mediaType == MediaType.Download ? Environment.DIRECTORY_DOWNLOADS : Environment.DIRECTORY_DOWNLOADS;
        }
        if (mediaType == MediaType.Audio) {
            return ReactNativeBlobUtilFS.getLegacySystemfolders(reactApplicationContext).get("LegacyMusicDir").toString();
        }
        if (mediaType == MediaType.Video) {
            return ReactNativeBlobUtilFS.getLegacySystemfolders(reactApplicationContext).get("LegacyMovieDir").toString();
        }
        if (mediaType == MediaType.Image) {
            return ReactNativeBlobUtilFS.getLegacySystemfolders(reactApplicationContext).get("LegacyPictureDir").toString();
        }
        return mediaType == MediaType.Download ? ReactNativeBlobUtilFS.getLegacySystemfolders(reactApplicationContext).get("LegacyDownloadDir").toString() : ReactNativeBlobUtilFS.getLegacySystemfolders(reactApplicationContext).get("LegacyDownloadDir").toString();
    }

    public static Uri createNewMediaFile(FileDescription fileDescription, MediaType mediaType, ReactApplicationContext reactApplicationContext) {
        ContentResolver contentResolver = ReactNativeBlobUtilImpl.RCTContext.getApplicationContext().getContentResolver();
        ContentValues contentValues = new ContentValues();
        String relativePath = getRelativePath(mediaType, reactApplicationContext);
        String str = fileDescription.mimeType;
        if (Build.VERSION.SDK_INT >= 29) {
            contentValues.put("date_added", Long.valueOf(System.currentTimeMillis() / 1000));
            contentValues.put("date_modified", Long.valueOf(System.currentTimeMillis() / 1000));
            contentValues.put("mime_type", str);
            contentValues.put("_display_name", fileDescription.name);
            contentValues.put("relative_path", relativePath + '/' + fileDescription.partentFolder);
            try {
                return contentResolver.insert(getMediaUri(mediaType), contentValues);
            } catch (Exception unused) {
                return null;
            }
        }
        File file = new File(relativePath + fileDescription.getFullPath());
        if (!file.exists()) {
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
                return null;
            }
            try {
                file.createNewFile();
                return Uri.fromFile(file);
            } catch (IOException unused2) {
                return null;
            }
        }
        return Uri.fromFile(file);
    }

    public static boolean writeToMediaFile(Uri uri, String str, boolean z, Promise promise, ReactApplicationContext reactApplicationContext) throws Throwable {
        IOException e;
        OutputStream outputStreamOpenOutputStream;
        if (Build.VERSION.SDK_INT >= 29) {
            try {
                Context applicationContext = reactApplicationContext.getApplicationContext();
                ContentResolver contentResolver = applicationContext.getContentResolver();
                OutputStream outputStream = null;
                try {
                    try {
                        try {
                            ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = applicationContext.getContentResolver().openFileDescriptor(uri, "w");
                            String strNormalizePath = ReactNativeBlobUtilUtils.normalizePath(str);
                            File file = new File(strNormalizePath);
                            if (!file.exists()) {
                                promise.reject("ENOENT", "No such file ('" + strNormalizePath + "')");
                                return false;
                            }
                            FileInputStream fileInputStreamCreate = SentryFileInputStream.Factory.create(new FileInputStream(file), file);
                            FileDescriptor fileDescriptor = parcelFileDescriptorOpenFileDescriptor.getFileDescriptor();
                            FileOutputStream fileOutputStreamCreate = SentryFileOutputStream.Factory.create(new FileOutputStream(fileDescriptor), fileDescriptor);
                            if (z) {
                                byte[] bArr = new byte[(int) file.length()];
                                fileInputStreamCreate.read(bArr);
                                ReactNativeBlobUtilFileTransformer.FileTransformer fileTransformer = ReactNativeBlobUtilFileTransformer.sharedFileTransformer;
                                if (fileTransformer == null) {
                                    throw new IllegalStateException("Write to media file with transform was specified but the shared file transformer is not set");
                                }
                                fileOutputStreamCreate.write(fileTransformer.onWriteFile(bArr));
                            } else {
                                byte[] bArr2 = new byte[Data.MAX_DATA_BYTES];
                                while (true) {
                                    int i = fileInputStreamCreate.read(bArr2);
                                    if (i <= 0) {
                                        break;
                                    }
                                    fileOutputStreamCreate.write(bArr2, 0, i);
                                }
                            }
                            fileInputStreamCreate.close();
                            fileOutputStreamCreate.close();
                            parcelFileDescriptorOpenFileDescriptor.close();
                            outputStreamOpenOutputStream = contentResolver.openOutputStream(uri);
                            if (outputStreamOpenOutputStream != null) {
                                outputStreamOpenOutputStream.close();
                                return true;
                            }
                            try {
                                try {
                                    promise.reject(new IOException("Failed to get output stream."));
                                    if (outputStreamOpenOutputStream != null) {
                                        outputStreamOpenOutputStream.close();
                                    }
                                    return false;
                                } catch (Throwable th) {
                                    outputStream = outputStreamOpenOutputStream;
                                    th = th;
                                    if (outputStream != null) {
                                        outputStream.close();
                                    }
                                    throw th;
                                }
                            } catch (IOException e2) {
                                e = e2;
                                contentResolver.delete(null, null, null);
                                promise.reject(e);
                                if (outputStreamOpenOutputStream != null) {
                                    outputStreamOpenOutputStream.close();
                                }
                                return false;
                            }
                        } catch (Exception e3) {
                            e3.printStackTrace();
                            promise.reject(new IOException("Failed to get output stream."));
                            return false;
                        }
                    } catch (IOException e4) {
                        e = e4;
                        outputStreamOpenOutputStream = null;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException unused) {
                promise.reject("ReactNativeBlobUtil.createMediaFile", "Cannot write to file, file might not exist");
                return false;
            }
        } else {
            return ReactNativeBlobUtilFS.writeFile(ReactNativeBlobUtilUtils.normalizePath(uri.toString()), "uri", str, false);
        }
    }

    /* JADX WARN: Code duplicated, block: B:70:0x00e4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:74:0x00ee A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:83:? A[SYNTHETIC] */
    public static void copyToInternal(Uri uri, String str, Promise promise) {
        FileOutputStream fileOutputStream;
        ContentResolver contentResolver = ReactNativeBlobUtilImpl.RCTContext.getApplicationContext().getContentResolver();
        File file = new File(str);
        if (!file.exists()) {
            try {
                File parentFile = file.getParentFile();
                if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
                    promise.reject("ReactNativeBlobUtil.copyToInternal: Cannot create parent folders<'" + str);
                    return;
                }
                if (!file.createNewFile()) {
                    promise.reject("ReactNativeBlobUtil.copyToInternal: Destination file at '" + str + "' already exists");
                    return;
                }
            } catch (IOException e) {
                promise.reject("ReactNativeBlobUtil.copyToInternal: Could not create file: " + e.getLocalizedMessage());
            }
        }
        InputStream inputStream = null;
        fileOutputStreamCreate = null;
        FileOutputStream fileOutputStreamCreate = null;
        inputStream = null;
        try {
            try {
                InputStream inputStreamOpenInputStream = contentResolver.openInputStream(uri);
                try {
                    fileOutputStreamCreate = SentryFileOutputStream.Factory.create(new FileOutputStream(str), str);
                    byte[] bArr = new byte[Data.MAX_DATA_BYTES];
                    while (true) {
                        int i = inputStreamOpenInputStream.read(bArr);
                        if (i > 0) {
                            fileOutputStreamCreate.write(bArr, 0, i);
                        } else {
                            try {
                                break;
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                    inputStreamOpenInputStream.close();
                    if (fileOutputStreamCreate != null) {
                        fileOutputStreamCreate.close();
                    }
                } catch (IOException e3) {
                    e = e3;
                    FileOutputStream fileOutputStream2 = fileOutputStreamCreate;
                    inputStream = inputStreamOpenInputStream;
                    fileOutputStream = fileOutputStream2;
                    try {
                        promise.reject("ReactNativeBlobUtil.copyToInternal:  Could not write data: " + e.getLocalizedMessage());
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        promise.resolve("");
                    } catch (Throwable th) {
                        th = th;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e5) {
                                e5.printStackTrace();
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                                throw th;
                            } catch (IOException e6) {
                                e6.printStackTrace();
                                throw th;
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    FileOutputStream fileOutputStream3 = fileOutputStreamCreate;
                    inputStream = inputStreamOpenInputStream;
                    fileOutputStream = fileOutputStream3;
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                        throw th;
                    }
                    throw th;
                }
            } catch (IOException e7) {
                e = e7;
                fileOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
            }
        } catch (IOException e8) {
            e8.printStackTrace();
        }
        promise.resolve("");
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0065  */
    public static void getBlob(Uri uri, String str, Promise promise) {
        byte b;
        try {
            InputStream inputStreamOpenInputStream = ReactNativeBlobUtilImpl.RCTContext.getApplicationContext().getContentResolver().openInputStream(uri);
            int iAvailable = inputStreamOpenInputStream.available();
            byte[] bArr = new byte[iAvailable];
            int i = inputStreamOpenInputStream.read(bArr);
            inputStreamOpenInputStream.close();
            if (i < iAvailable) {
                promise.reject("EUNSPECIFIED", "Read only " + i + " bytes of " + iAvailable);
                return;
            }
            String lowerCase = str.toLowerCase();
            int iHashCode = lowerCase.hashCode();
            if (iHashCode != -1396204209) {
                if (iHashCode == 93106001 && lowerCase.equals("ascii")) {
                    b = 1;
                } else {
                    b = -1;
                }
            } else if (lowerCase.equals(ReactNativeBlobUtilConst.RNFB_RESPONSE_BASE64)) {
                b = 0;
            } else {
                b = -1;
            }
            if (b == 0) {
                promise.resolve(Base64.encodeToString(bArr, 2));
                return;
            }
            if (b == 1) {
                WritableArray writableArrayCreateArray = Arguments.createArray();
                for (int i2 = 0; i2 < iAvailable; i2++) {
                    writableArrayCreateArray.pushInt(bArr[i2]);
                }
                promise.resolve(writableArrayCreateArray);
                return;
            }
            promise.resolve(new String(bArr));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
