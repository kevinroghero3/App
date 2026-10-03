package com.ReactNativeBlobUtil;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.util.Base64;
import android.view.ViewConfiguration;
import androidx.work.Data;
import ch.qos.logback.core.pattern.parser.Parser;
import com.facebook.common.util.UriUtil;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.google.firebase.sessions.settings.RemoteSettings;
import io.sentry.instrumentation.file.SentryFileInputStream;
import io.sentry.instrumentation.file.SentryFileOutputStream;
import io.sentry.rrweb.RRWebVideoEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import o.ArtificialStackFrames;

/* JADX INFO: loaded from: classes4.dex */
class ReactNativeBlobUtilFS {
    private static int artificialFrame = 1;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME;
    private DeviceEventManagerModule.RCTDeviceEventEmitter emitter;
    private ReactApplicationContext mCtx;

    ReactNativeBlobUtilFS(ReactApplicationContext reactApplicationContext) {
        this.mCtx = reactApplicationContext;
        this.emitter = (DeviceEventManagerModule.RCTDeviceEventEmitter) reactApplicationContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class);
    }

    static boolean writeFile(String str, String str2, String str3, boolean z) {
        FileOutputStream fileOutputStream;
        try {
            File file = new File(ReactNativeBlobUtilUtils.normalizePath(str));
            File parentFile = file.getParentFile();
            if (!file.exists() && ((parentFile != null && !parentFile.exists() && !parentFile.mkdirs() && !parentFile.exists()) || !file.createNewFile())) {
                return false;
            }
            if (str2.equalsIgnoreCase("uri")) {
                File file2 = new File(ReactNativeBlobUtilUtils.normalizePath(str3));
                if (!file2.exists()) {
                    return false;
                }
                byte[] bArr = new byte[Data.MAX_DATA_BYTES];
                FileInputStream fileInputStream = null;
                FileOutputStream fileOutputStreamCreate = null;
                try {
                    FileInputStream fileInputStreamCreate = SentryFileInputStream.Factory.create(new FileInputStream(file2), file2);
                    try {
                        fileOutputStreamCreate = SentryFileOutputStream.Factory.create(new FileOutputStream(file, z), file, z);
                        while (true) {
                            int i = fileInputStreamCreate.read(bArr);
                            if (i <= 0) {
                                break;
                            }
                            fileOutputStreamCreate.write(bArr, 0, i);
                        }
                        fileInputStreamCreate.close();
                        if (fileOutputStreamCreate == null) {
                            return true;
                        }
                        fileOutputStreamCreate.close();
                        return true;
                    } catch (Throwable th) {
                        th = th;
                        FileOutputStream fileOutputStream2 = fileOutputStreamCreate;
                        fileInputStream = fileInputStreamCreate;
                        fileOutputStream = fileOutputStream2;
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = null;
                }
            } else {
                byte[] bArrStringToBytes = ReactNativeBlobUtilUtils.stringToBytes(str3, str2);
                FileOutputStream fileOutputStreamCreate2 = SentryFileOutputStream.Factory.create(new FileOutputStream(file, z), file, z);
                try {
                    fileOutputStreamCreate2.write(bArrStringToBytes);
                    int length = bArrStringToBytes.length;
                    return true;
                } finally {
                    fileOutputStreamCreate2.close();
                }
            }
        } catch (FileNotFoundException | Exception unused) {
            return false;
        }
    }

    static void writeFile(String str, String str2, String str3, boolean z, boolean z2, Promise promise) {
        int length;
        FileOutputStream fileOutputStream;
        try {
            File file = new File(str);
            File parentFile = file.getParentFile();
            if (!file.exists()) {
                if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs() && !parentFile.exists()) {
                    promise.reject("EUNSPECIFIED", "Failed to create parent directory of '" + str + "'");
                    return;
                }
                if (!file.createNewFile()) {
                    promise.reject("ENOENT", "File '" + str + "' does not exist and could not be created");
                    return;
                }
            }
            if (str2.equalsIgnoreCase("uri")) {
                String strNormalizePath = ReactNativeBlobUtilUtils.normalizePath(str3);
                File file2 = new File(strNormalizePath);
                if (!file2.exists()) {
                    promise.reject("ENOENT", "No such file '" + str + "' ('" + strNormalizePath + "')");
                    return;
                }
                byte[] bArr = new byte[Data.MAX_DATA_BYTES];
                FileInputStream fileInputStream = null;
                FileOutputStream fileOutputStreamCreate = null;
                try {
                    FileInputStream fileInputStreamCreate = SentryFileInputStream.Factory.create(new FileInputStream(file2), file2);
                    try {
                        fileOutputStreamCreate = SentryFileOutputStream.Factory.create(new FileOutputStream(file, z2), file, z2);
                        length = 0;
                        while (true) {
                            int i = fileInputStreamCreate.read(bArr);
                            if (i <= 0) {
                                break;
                            }
                            fileOutputStreamCreate.write(bArr, 0, i);
                            length += i;
                        }
                        fileInputStreamCreate.close();
                        if (fileOutputStreamCreate != null) {
                            fileOutputStreamCreate.close();
                        }
                    } catch (Throwable th) {
                        th = th;
                        FileOutputStream fileOutputStream2 = fileOutputStreamCreate;
                        fileInputStream = fileInputStreamCreate;
                        fileOutputStream = fileOutputStream2;
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = null;
                }
            } else {
                byte[] bArrStringToBytes = ReactNativeBlobUtilUtils.stringToBytes(str3, str2);
                if (z) {
                    ReactNativeBlobUtilFileTransformer.FileTransformer fileTransformer = ReactNativeBlobUtilFileTransformer.sharedFileTransformer;
                    if (fileTransformer == null) {
                        throw new IllegalStateException("Write file with transform was specified but the shared file transformer is not set");
                    }
                    bArrStringToBytes = fileTransformer.onWriteFile(bArrStringToBytes);
                }
                FileOutputStream fileOutputStreamCreate2 = SentryFileOutputStream.Factory.create(new FileOutputStream(file, z2), file, z2);
                try {
                    fileOutputStreamCreate2.write(bArrStringToBytes);
                    length = bArrStringToBytes.length;
                    fileOutputStreamCreate2.close();
                } catch (Throwable th3) {
                    fileOutputStreamCreate2.close();
                    throw th3;
                }
            }
            promise.resolve(Integer.valueOf(length));
        } catch (FileNotFoundException unused) {
            promise.reject("ENOENT", "File '" + str + "' does not exist and could not be created, or it is a directory");
        } catch (Exception e) {
            promise.reject("EUNSPECIFIED", e.getLocalizedMessage());
        }
    }

    static void writeFile(String str, ReadableArray readableArray, boolean z, Promise promise) {
        try {
            File file = new File(str);
            File parentFile = file.getParentFile();
            if (!file.exists()) {
                if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs() && !parentFile.exists()) {
                    promise.reject("ENOTDIR", "Failed to create parent directory of '" + str + "'");
                    return;
                }
                if (!file.createNewFile()) {
                    promise.reject("ENOENT", "File '" + str + "' does not exist and could not be created");
                    return;
                }
            }
            FileOutputStream fileOutputStreamCreate = SentryFileOutputStream.Factory.create(new FileOutputStream(file, z), file, z);
            try {
                byte[] bArr = new byte[readableArray.size()];
                for (int i = 0; i < readableArray.size(); i++) {
                    bArr[i] = (byte) readableArray.getInt(i);
                }
                fileOutputStreamCreate.write(bArr);
                fileOutputStreamCreate.close();
                promise.resolve(Integer.valueOf(readableArray.size()));
            } catch (Throwable th) {
                fileOutputStreamCreate.close();
                throw th;
            }
        } catch (FileNotFoundException unused) {
            promise.reject("ENOENT", "File '" + str + "' does not exist and could not be created");
        } catch (Exception e) {
            promise.reject("EUNSPECIFIED", e.getLocalizedMessage());
        }
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00dd A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:35:0x00df A[Catch: Exception -> 0x00fb, FileNotFoundException -> 0x00fe, TryCatch #12 {FileNotFoundException -> 0x00fe, Exception -> 0x00fb, blocks: (B:13:0x0068, B:18:0x00b4, B:42:0x011f, B:46:0x0147, B:50:0x0156, B:51:0x015b, B:52:0x015e, B:56:0x0162, B:57:0x0169, B:58:0x016a, B:98:0x0251, B:99:0x025b, B:100:0x0265, B:102:0x026d, B:103:0x0275, B:104:0x027a, B:74:0x01dc, B:76:0x01e2, B:77:0x01e3, B:83:0x020e, B:85:0x0214, B:86:0x0215, B:106:0x0284, B:108:0x028a, B:109:0x028b, B:111:0x028d, B:113:0x0293, B:114:0x0294, B:116:0x0296, B:118:0x029c, B:119:0x029d, B:20:0x00c3, B:22:0x00c9, B:23:0x00ca, B:25:0x00cc, B:27:0x00d2, B:28:0x00d3, B:35:0x00df, B:40:0x0101, B:30:0x00d5, B:32:0x00db, B:33:0x00dc), top: B:152:0x0021 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x0101 A[Catch: Exception -> 0x00fb, FileNotFoundException -> 0x00fe, TryCatch #12 {FileNotFoundException -> 0x00fe, Exception -> 0x00fb, blocks: (B:13:0x0068, B:18:0x00b4, B:42:0x011f, B:46:0x0147, B:50:0x0156, B:51:0x015b, B:52:0x015e, B:56:0x0162, B:57:0x0169, B:58:0x016a, B:98:0x0251, B:99:0x025b, B:100:0x0265, B:102:0x026d, B:103:0x0275, B:104:0x027a, B:74:0x01dc, B:76:0x01e2, B:77:0x01e3, B:83:0x020e, B:85:0x0214, B:86:0x0215, B:106:0x0284, B:108:0x028a, B:109:0x028b, B:111:0x028d, B:113:0x0293, B:114:0x0294, B:116:0x0296, B:118:0x029c, B:119:0x029d, B:20:0x00c3, B:22:0x00c9, B:23:0x00ca, B:25:0x00cc, B:27:0x00d2, B:28:0x00d3, B:35:0x00df, B:40:0x0101, B:30:0x00d5, B:32:0x00db, B:33:0x00dc), top: B:152:0x0021 }] */
    /* JADX WARN: Code duplicated, block: B:90:0x0234  */
    static void readFile(String str, String str2, boolean z, Promise promise) {
        int iAvailable;
        byte[] bArrOnReadFile;
        int i;
        byte b;
        int i2 = 2 % 2;
        int i3 = getARTIFICIAL_FRAME_PACKAGE_NAME + 71;
        artificialFrame = i3 % 128;
        int i4 = i3 % 2;
        String strNormalizePath = ReactNativeBlobUtilUtils.normalizePath(str);
        String str3 = strNormalizePath != null ? strNormalizePath : str;
        try {
            if (strNormalizePath != null) {
                try {
                    if (((Boolean) String.class.getMethod("startsWith", String.class).invoke(strNormalizePath, ReactNativeBlobUtilConst.FILE_PREFIX_BUNDLE_ASSET)).booleanValue()) {
                        int i5 = artificialFrame + 17;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i5 % 128;
                        int i6 = i5 % 2;
                        try {
                            try {
                                Object[] objArr = {ReactNativeBlobUtilImpl.RCTContext.getAssets(), (String) String.class.getMethod(Parser.REPLACE_CONVERTER_WORD, CharSequence.class, CharSequence.class).invoke(str3, ReactNativeBlobUtilConst.FILE_PREFIX_BUNDLE_ASSET, "")};
                                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-982065286);
                                if (objAccessartificialFrame == null) {
                                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(12 - (ViewConfiguration.getFadingEdgeLength() >> 16), (char) ((ViewConfiguration.getKeyRepeatDelay() >> 16) + 7116), (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 36, 1511233906, false, "accessartificialFrame", new Class[]{AssetManager.class, String.class});
                                }
                                InputStream inputStream = (InputStream) ((Method) objAccessartificialFrame).invoke(null, objArr);
                                iAvailable = inputStream.available();
                                bArrOnReadFile = new byte[iAvailable];
                                i = inputStream.read(bArrOnReadFile, 0, iAvailable);
                                inputStream.close();
                            } catch (Throwable th) {
                                Throwable cause = th.getCause();
                                if (cause == null) {
                                    throw th;
                                }
                                throw cause;
                            }
                        } catch (Throwable th2) {
                            Throwable cause2 = th2.getCause();
                            if (cause2 == null) {
                                throw th2;
                            }
                            throw cause2;
                        }
                    } else if (strNormalizePath == null) {
                        InputStream inputStreamOpenInputStream = ReactNativeBlobUtilImpl.RCTContext.getContentResolver().openInputStream(Uri.parse(str3));
                        iAvailable = inputStreamOpenInputStream.available();
                        bArrOnReadFile = new byte[iAvailable];
                        i = inputStreamOpenInputStream.read(bArrOnReadFile);
                        inputStreamOpenInputStream.close();
                    } else {
                        File file = new File(str3);
                        iAvailable = (int) file.length();
                        bArrOnReadFile = new byte[iAvailable];
                        FileInputStream fileInputStreamCreate = SentryFileInputStream.Factory.create(new FileInputStream(file), file);
                        i = fileInputStreamCreate.read(bArrOnReadFile);
                        fileInputStreamCreate.close();
                    }
                } catch (Throwable th3) {
                    Throwable cause3 = th3.getCause();
                    if (cause3 == null) {
                        throw th3;
                    }
                    throw cause3;
                }
            } else if (strNormalizePath == null) {
                InputStream inputStreamOpenInputStream2 = ReactNativeBlobUtilImpl.RCTContext.getContentResolver().openInputStream(Uri.parse(str3));
                iAvailable = inputStreamOpenInputStream2.available();
                bArrOnReadFile = new byte[iAvailable];
                i = inputStreamOpenInputStream2.read(bArrOnReadFile);
                inputStreamOpenInputStream2.close();
            } else {
                File file2 = new File(str3);
                iAvailable = (int) file2.length();
                bArrOnReadFile = new byte[iAvailable];
                FileInputStream fileInputStreamCreate2 = SentryFileInputStream.Factory.create(new FileInputStream(file2), file2);
                i = fileInputStreamCreate2.read(bArrOnReadFile);
                fileInputStreamCreate2.close();
            }
            if (i < iAvailable) {
                promise.reject("EUNSPECIFIED", "Read only " + i + " bytes of " + iAvailable);
                return;
            }
            if (z) {
                int i7 = getARTIFICIAL_FRAME_PACKAGE_NAME + 45;
                artificialFrame = i7 % 128;
                int i8 = i7 % 2;
                ReactNativeBlobUtilFileTransformer.FileTransformer fileTransformer = ReactNativeBlobUtilFileTransformer.sharedFileTransformer;
                if (fileTransformer == null) {
                    throw new IllegalStateException("Read file with transform was specified but the shared file transformer is not set");
                }
                int i9 = getARTIFICIAL_FRAME_PACKAGE_NAME + 53;
                artificialFrame = i9 % 128;
                if (i9 % 2 == 0) {
                    fileTransformer.onReadFile(bArrOnReadFile);
                    try {
                        throw null;
                    } catch (Throwable th4) {
                        throw th4;
                    }
                }
                bArrOnReadFile = fileTransformer.onReadFile(bArrOnReadFile);
            }
            Locale locale = Locale.ROOT;
            int i10 = getARTIFICIAL_FRAME_PACKAGE_NAME + 19;
            artificialFrame = i10 % 128;
            int i11 = i10 % 2;
            try {
                Object objInvoke = String.class.getMethod("toLowerCase", Locale.class).invoke(str2, locale);
                try {
                    int iIntValue = ((Integer) String.class.getMethod("hashCode", null).invoke(objInvoke, null)).intValue();
                    if (iIntValue == -1396204209) {
                        try {
                            if (!((Boolean) String.class.getMethod("equals", Object.class).invoke(objInvoke, ReactNativeBlobUtilConst.RNFB_RESPONSE_BASE64)).booleanValue()) {
                                b = -1;
                            } else {
                                int i12 = artificialFrame + 81;
                                int i13 = i12 % 128;
                                getARTIFICIAL_FRAME_PACKAGE_NAME = i13;
                                int i14 = i12 % 2;
                                int i15 = i13 + 75;
                                artificialFrame = i15 % 128;
                                if (i15 % 2 == 0) {
                                    int i16 = 3 % 3;
                                }
                                b = 0;
                            }
                        } catch (Throwable th5) {
                            Throwable cause4 = th5.getCause();
                            if (cause4 == null) {
                                throw th5;
                            }
                            throw cause4;
                        }
                    } else if (iIntValue == 3600241) {
                        try {
                            if (((Boolean) String.class.getMethod("equals", Object.class).invoke(objInvoke, ReactNativeBlobUtilConst.RNFB_RESPONSE_UTF8)).booleanValue()) {
                                int i17 = getARTIFICIAL_FRAME_PACKAGE_NAME + 55;
                                artificialFrame = i17 % 128;
                                int i18 = i17 % 2;
                                b = 2;
                            } else {
                                b = -1;
                            }
                        } catch (Throwable th6) {
                            Throwable cause5 = th6.getCause();
                            if (cause5 == null) {
                                throw th6;
                            }
                            throw cause5;
                        }
                    } else if (iIntValue != 93106001) {
                        b = -1;
                    } else {
                        try {
                            if (((Boolean) String.class.getMethod("equals", Object.class).invoke(objInvoke, "ascii")).booleanValue()) {
                                int i19 = artificialFrame + 1;
                                getARTIFICIAL_FRAME_PACKAGE_NAME = i19 % 128;
                                int i20 = i19 % 2;
                                b = 1;
                            } else {
                                b = -1;
                            }
                        } catch (Throwable th7) {
                            Throwable cause6 = th7.getCause();
                            if (cause6 == null) {
                                throw th7;
                            }
                            throw cause6;
                        }
                    }
                    if (b == 0) {
                        promise.resolve(Base64.encodeToString(bArrOnReadFile, 2));
                        return;
                    }
                    if (b != 1) {
                        if (b != 2) {
                            promise.resolve(new String(bArrOnReadFile));
                            return;
                        } else {
                            promise.resolve(new String(bArrOnReadFile));
                            return;
                        }
                    }
                    WritableArray writableArrayCreateArray = Arguments.createArray();
                    for (byte b2 : bArrOnReadFile) {
                        writableArrayCreateArray.pushInt(b2);
                    }
                    promise.resolve(writableArrayCreateArray);
                } catch (Throwable th8) {
                    Throwable cause7 = th8.getCause();
                    if (cause7 == null) {
                        throw th8;
                    }
                    throw cause7;
                }
            } catch (Throwable th9) {
                Throwable cause8 = th9.getCause();
                if (cause8 == null) {
                    throw th9;
                }
                throw cause8;
            }
        } catch (FileNotFoundException e) {
            String localizedMessage = e.getLocalizedMessage();
            try {
                if (((Boolean) String.class.getMethod("contains", CharSequence.class).invoke(localizedMessage, "EISDIR")).booleanValue()) {
                    promise.reject("EISDIR", "Expecting a file but '" + str3 + "' is a directory; " + localizedMessage);
                    return;
                }
                promise.reject("ENOENT", "No such file '" + str3 + "'; " + localizedMessage);
            } catch (Throwable th10) {
                Throwable cause9 = th10.getCause();
                if (cause9 == null) {
                    throw th10;
                }
                throw cause9;
            }
        } catch (Exception e2) {
            promise.reject("EUNSPECIFIED", e2.getLocalizedMessage());
        }
    }

    static Map<String, Object> getSystemfolders(ReactApplicationContext reactApplicationContext) {
        HashMap map = new HashMap();
        map.put("DocumentDir", getFilesDirPath(reactApplicationContext));
        map.put("CacheDir", getCacheDirPath(reactApplicationContext));
        map.put("DCIMDir", getExternalFilesDirPath(reactApplicationContext, Environment.DIRECTORY_DCIM));
        map.put("PictureDir", getExternalFilesDirPath(reactApplicationContext, Environment.DIRECTORY_PICTURES));
        map.put("MusicDir", getExternalFilesDirPath(reactApplicationContext, Environment.DIRECTORY_MUSIC));
        map.put("DownloadDir", getExternalFilesDirPath(reactApplicationContext, Environment.DIRECTORY_DOWNLOADS));
        map.put("MovieDir", getExternalFilesDirPath(reactApplicationContext, Environment.DIRECTORY_MOVIES));
        map.put("RingtoneDir", getExternalFilesDirPath(reactApplicationContext, Environment.DIRECTORY_RINGTONES));
        if (Environment.getExternalStorageState().equals("mounted")) {
            map.put("SDCardDir", getExternalFilesDirPath(reactApplicationContext, null));
            File externalFilesDir = reactApplicationContext.getExternalFilesDir(null);
            if (externalFilesDir != null && externalFilesDir.getParentFile() != null) {
                map.put("SDCardApplicationDir", externalFilesDir.getParentFile().getAbsolutePath());
            } else {
                map.put("SDCardApplicationDir", "");
            }
        } else {
            map.put("SDCardDir", "");
            map.put("SDCardApplicationDir", "");
        }
        map.put("MainBundleDir", reactApplicationContext.getApplicationInfo().dataDir);
        map.put("LibraryDir", "");
        map.put("ApplicationSupportDir", "");
        return map;
    }

    static Map<String, Object> getLegacySystemfolders(ReactApplicationContext reactApplicationContext) {
        HashMap map = new HashMap();
        map.put("LegacyDCIMDir", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath());
        map.put("LegacyPictureDir", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath());
        map.put("LegacyMusicDir", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC).getAbsolutePath());
        map.put("LegacyDownloadDir", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath());
        map.put("LegacyMovieDir", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES).getAbsolutePath());
        map.put("LegacyRingtoneDir", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_RINGTONES).getAbsolutePath());
        if (Environment.getExternalStorageState().equals("mounted")) {
            map.put("LegacySDCardDir", Environment.getExternalStorageDirectory().getAbsolutePath());
        } else {
            map.put("LegacySDCardDir", "");
        }
        return map;
    }

    static String getExternalFilesDirPath(ReactApplicationContext reactApplicationContext, String str) {
        File externalFilesDir = reactApplicationContext.getExternalFilesDir(str);
        if (externalFilesDir != null) {
            return externalFilesDir.getAbsolutePath();
        }
        return "";
    }

    static String getFilesDirPath(ReactApplicationContext reactApplicationContext) {
        File filesDir = reactApplicationContext.getFilesDir();
        if (filesDir != null) {
            return filesDir.getAbsolutePath();
        }
        return "";
    }

    static String getCacheDirPath(ReactApplicationContext reactApplicationContext) {
        File cacheDir = reactApplicationContext.getCacheDir();
        if (cacheDir != null) {
            return cacheDir.getAbsolutePath();
        }
        return "";
    }

    public static void getSDCardDir(ReactApplicationContext reactApplicationContext, Promise promise) {
        if (Environment.getExternalStorageState().equals("mounted")) {
            try {
                promise.resolve(reactApplicationContext.getExternalFilesDir(null).getAbsolutePath());
                return;
            } catch (Exception e) {
                promise.reject("ReactNativeBlobUtil.getSDCardDir", e.getLocalizedMessage());
                return;
            }
        }
        promise.reject("ReactNativeBlobUtil.getSDCardDir", "External storage not mounted");
    }

    public static void getSDCardApplicationDir(ReactApplicationContext reactApplicationContext, Promise promise) {
        if (Environment.getExternalStorageState().equals("mounted")) {
            try {
                promise.resolve(reactApplicationContext.getExternalFilesDir(null).getParentFile().getAbsolutePath());
                return;
            } catch (Exception e) {
                promise.reject("ReactNativeBlobUtil.getSDCardApplicationDir", e.getLocalizedMessage());
                return;
            }
        }
        promise.reject("ReactNativeBlobUtil.getSDCardApplicationDir", "External storage not mounted");
    }

    static String getTmpPath(String str) {
        return ReactNativeBlobUtilImpl.RCTContext.getFilesDir() + "/ReactNativeBlobUtilTmp_" + str;
    }

    static void unlink(String str, Callback callback) {
        try {
            deleteRecursive(new File(ReactNativeBlobUtilUtils.normalizePath(str)));
            callback.invoke(null, Boolean.TRUE);
        } catch (Exception e) {
            callback.invoke(e.getLocalizedMessage(), Boolean.FALSE);
        }
    }

    private static void deleteRecursive(File file) throws IOException {
        if (file.isDirectory()) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null) {
                throw new NullPointerException("Received null trying to list files of directory '" + file + "'");
            }
            for (File file2 : fileArrListFiles) {
                deleteRecursive(file2);
            }
        }
        if (file.delete()) {
            return;
        }
        throw new IOException("Failed to delete '" + file + "'");
    }

    static void mkdir(String str, Promise promise) {
        String strNormalizePath = ReactNativeBlobUtilUtils.normalizePath(str);
        File file = new File(strNormalizePath);
        if (file.exists()) {
            StringBuilder sb = new StringBuilder();
            sb.append(file.isDirectory() ? "Folder" : "File");
            sb.append(" '");
            sb.append(strNormalizePath);
            sb.append("' already exists");
            promise.reject("EEXIST", sb.toString());
            return;
        }
        try {
            if (!file.mkdirs()) {
                promise.reject("EUNSPECIFIED", "mkdir failed to create some or all directories in '" + strNormalizePath + "'");
                return;
            }
            promise.resolve(Boolean.TRUE);
        } catch (Exception e) {
            promise.reject("EUNSPECIFIED", e.getLocalizedMessage());
        }
    }

    /* JADX WARN: Code duplicated, block: B:47:0x00d2 A[Catch: Exception -> 0x00ce, TRY_LEAVE, TryCatch #2 {Exception -> 0x00ce, blocks: (B:43:0x00ca, B:47:0x00d2), top: B:66:0x00ca }] */
    /* JADX WARN: Code duplicated, block: B:59:0x0102 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:60:0x0104 A[Catch: Exception -> 0x0100, TRY_LEAVE, TryCatch #0 {Exception -> 0x0100, blocks: (B:56:0x00fc, B:60:0x0104), top: B:64:0x00fc }] */
    /* JADX WARN: Code duplicated, block: B:64:0x00fc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    static void cp(String str, String str2, Callback callback) {
        String str3;
        String strNormalizePath = ReactNativeBlobUtilUtils.normalizePath(str2);
        InputStream inputStream = null;
        OutputStream outputStream = null;
        inputStream = null;
        try {
            InputStream inputStreamInputStreamFromPath = inputStreamFromPath(str);
            try {
                if (inputStreamInputStreamFromPath == null) {
                    callback.invoke("Source file at path`" + str + "` does not exist or can not be opened");
                    if (inputStreamInputStreamFromPath != null) {
                        try {
                            inputStreamInputStreamFromPath.close();
                            return;
                        } catch (Exception e) {
                            e.getLocalizedMessage();
                            return;
                        }
                    }
                    return;
                }
                if (!new File(strNormalizePath).exists() && !new File(strNormalizePath).createNewFile()) {
                    callback.invoke("Destination file at '" + strNormalizePath + "' already exists");
                    try {
                        inputStreamInputStreamFromPath.close();
                        return;
                    } catch (Exception e2) {
                        e2.getLocalizedMessage();
                        return;
                    }
                }
                FileOutputStream fileOutputStreamCreate = SentryFileOutputStream.Factory.create(new FileOutputStream(strNormalizePath), strNormalizePath);
                byte[] bArr = new byte[Data.MAX_DATA_BYTES];
                while (true) {
                    int i = inputStreamInputStreamFromPath.read(bArr);
                    if (i > 0) {
                        fileOutputStreamCreate.write(bArr, 0, i);
                    } else {
                        try {
                            break;
                        } catch (Exception e3) {
                            str3 = "" + e3.getLocalizedMessage();
                        }
                    }
                }
                inputStreamInputStreamFromPath.close();
                if (fileOutputStreamCreate != null) {
                    fileOutputStreamCreate.close();
                }
                str3 = "";
                if (str3 != "") {
                    callback.invoke(str3);
                } else {
                    callback.invoke(new Object[0]);
                }
            } catch (Exception e4) {
                e = e4;
                inputStream = inputStreamInputStreamFromPath;
                try {
                    str3 = "" + e.getLocalizedMessage();
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                            if (inputStream != 0) {
                                inputStream.close();
                            }
                        } catch (Exception e5) {
                            str3 = str3 + e5.getLocalizedMessage();
                        }
                    } else if (inputStream != 0) {
                        inputStream.close();
                    }
                } catch (Throwable th) {
                    th = th;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                            if (outputStream != null) {
                                outputStream.close();
                            }
                        } catch (Exception e6) {
                            e6.getLocalizedMessage();
                            throw th;
                        }
                    } else if (outputStream != null) {
                        outputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                outputStream = null;
                inputStream = inputStreamInputStreamFromPath;
                if (inputStream != null) {
                    inputStream.close();
                    if (outputStream != null) {
                        outputStream.close();
                    }
                } else if (outputStream != null) {
                    outputStream.close();
                }
                throw th;
            }
        } catch (Exception e7) {
            e = e7;
        } catch (Throwable th3) {
            th = th3;
            outputStream = null;
        }
    }

    static void mv(String str, String str2, Callback callback) {
        String strNormalizePath = ReactNativeBlobUtilUtils.normalizePath(str);
        String strNormalizePath2 = ReactNativeBlobUtilUtils.normalizePath(str2);
        File file = new File(strNormalizePath);
        if (!file.exists()) {
            callback.invoke("Source file at path `" + strNormalizePath + "` does not exist");
            return;
        }
        try {
            File file2 = new File(strNormalizePath2);
            File parentFile = file2.getParentFile();
            if (parentFile != null && !parentFile.exists()) {
                callback.invoke("mv failed because the destination directory doesn't exist");
                return;
            }
            if (file2.exists()) {
                file2.delete();
            }
            if (!file.renameTo(file2)) {
                callback.invoke("mv failed for unknown reasons");
            } else {
                callback.invoke(new Object[0]);
            }
        } catch (Exception e) {
            callback.invoke(e.toString());
        }
    }

    static void exists(String str, Callback callback) {
        if (isAsset(str)) {
            try {
                ReactNativeBlobUtilImpl.RCTContext.getAssets().openFd(str.replace(ReactNativeBlobUtilConst.FILE_PREFIX_BUNDLE_ASSET, ""));
                callback.invoke(Boolean.TRUE, Boolean.FALSE);
                return;
            } catch (IOException unused) {
                Boolean bool = Boolean.FALSE;
                callback.invoke(bool, bool);
                return;
            }
        }
        String strNormalizePath = ReactNativeBlobUtilUtils.normalizePath(str);
        if (strNormalizePath != null) {
            callback.invoke(Boolean.valueOf(new File(strNormalizePath).exists()), Boolean.valueOf(new File(strNormalizePath).isDirectory()));
        } else {
            Boolean bool2 = Boolean.FALSE;
            callback.invoke(bool2, bool2);
        }
    }

    static void ls(String str, Promise promise) {
        try {
            String strNormalizePath = ReactNativeBlobUtilUtils.normalizePath(str);
            File file = new File(strNormalizePath);
            if (!file.exists()) {
                promise.reject("ENOENT", "No such file '" + strNormalizePath + "'");
                return;
            }
            if (!file.isDirectory()) {
                promise.reject("ENOTDIR", "Not a directory '" + strNormalizePath + "'");
                return;
            }
            String[] list = new File(strNormalizePath).list();
            WritableArray writableArrayCreateArray = Arguments.createArray();
            for (String str2 : list) {
                writableArrayCreateArray.pushString(str2);
            }
            promise.resolve(writableArrayCreateArray);
        } catch (Exception e) {
            e.printStackTrace();
            promise.reject("EUNSPECIFIED", e.getLocalizedMessage());
        }
    }

    static void slice(String str, String str2, long j, long j2, String str3, Promise promise) {
        try {
            String strNormalizePath = ReactNativeBlobUtilUtils.normalizePath(str2);
            if (!str.startsWith(ReactNativeBlobUtilConst.FILE_PREFIX_CONTENT) && new File(ReactNativeBlobUtilUtils.normalizePath(str)).isDirectory()) {
                promise.reject("EISDIR", "Expecting a file but '" + str + "' is a directory");
                return;
            }
            InputStream inputStreamInputStreamFromPath = inputStreamFromPath(str);
            if (inputStreamInputStreamFromPath == null) {
                promise.reject("ENOENT", "No such file '" + str + "'");
                return;
            }
            File file = new File(strNormalizePath);
            FileOutputStream fileOutputStreamCreate = SentryFileOutputStream.Factory.create(new FileOutputStream(file), file);
            long jSkip = inputStreamInputStreamFromPath.skip(j);
            if (jSkip != j) {
                promise.reject("EUNSPECIFIED", "Skipped " + jSkip + " instead of the specified " + j + " bytes");
                return;
            }
            byte[] bArr = new byte[Data.MAX_DATA_BYTES];
            int i = (int) (j2 - j);
            while (i > 0) {
                int i2 = inputStreamInputStreamFromPath.read(bArr, 0, Data.MAX_DATA_BYTES);
                if (i2 <= 0) {
                    break;
                }
                fileOutputStreamCreate.write(bArr, 0, Math.min(i, i2));
                i -= i2;
            }
            inputStreamInputStreamFromPath.close();
            fileOutputStreamCreate.flush();
            fileOutputStreamCreate.close();
            promise.resolve(strNormalizePath);
        } catch (Exception e) {
            e.printStackTrace();
            promise.reject("EUNSPECIFIED", e.getLocalizedMessage());
        }
    }

    static void lstat(String str, final Callback callback) {
        new AsyncTask<String, Integer, Integer>() { // from class: com.ReactNativeBlobUtil.ReactNativeBlobUtilFS.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public Integer doInBackground(String... strArr) {
                WritableArray writableArrayCreateArray = Arguments.createArray();
                if (strArr[0] == null) {
                    callback.invoke("the path specified for lstat is either `null` or `undefined`.");
                    return 0;
                }
                File file = new File(strArr[0]);
                if (!file.exists()) {
                    callback.invoke("failed to lstat path `" + strArr[0] + "` because it does not exist or it is not a folder");
                    return 0;
                }
                if (file.isDirectory()) {
                    for (String str2 : file.list()) {
                        writableArrayCreateArray.pushMap(ReactNativeBlobUtilFS.statFile(file.getPath() + RemoteSettings.FORWARD_SLASH_STRING + str2));
                    }
                } else {
                    writableArrayCreateArray.pushMap(ReactNativeBlobUtilFS.statFile(file.getAbsolutePath()));
                }
                callback.invoke(null, writableArrayCreateArray);
                return 0;
            }
        }.execute(ReactNativeBlobUtilUtils.normalizePath(str));
    }

    static void stat(String str, Callback callback) {
        try {
            String strNormalizePath = ReactNativeBlobUtilUtils.normalizePath(str);
            WritableMap writableMapStatFile = statFile(strNormalizePath);
            if (writableMapStatFile == null) {
                callback.invoke("failed to stat path `" + strNormalizePath + "` because it does not exist or it is not a folder", null);
            } else {
                callback.invoke(null, writableMapStatFile);
            }
        } catch (Exception e) {
            callback.invoke(e.getLocalizedMessage());
        }
    }

    static WritableMap statFile(String str) {
        try {
            String strNormalizePath = ReactNativeBlobUtilUtils.normalizePath(str);
            WritableMap writableMapCreateMap = Arguments.createMap();
            if (isAsset(strNormalizePath)) {
                String strReplace = strNormalizePath.replace(ReactNativeBlobUtilConst.FILE_PREFIX_BUNDLE_ASSET, "");
                AssetFileDescriptor assetFileDescriptorOpenFd = ReactNativeBlobUtilImpl.RCTContext.getAssets().openFd(strReplace);
                writableMapCreateMap.putString("filename", strReplace);
                writableMapCreateMap.putString("path", strNormalizePath);
                writableMapCreateMap.putString("type", UriUtil.LOCAL_ASSET_SCHEME);
                writableMapCreateMap.putString(RRWebVideoEvent.JsonKeys.SIZE, String.valueOf(assetFileDescriptorOpenFd.getLength()));
                writableMapCreateMap.putInt("lastModified", 0);
            } else {
                File file = new File(strNormalizePath);
                if (!file.exists()) {
                    return null;
                }
                writableMapCreateMap.putString("filename", file.getName());
                writableMapCreateMap.putString("path", file.getPath());
                writableMapCreateMap.putString("type", file.isDirectory() ? "directory" : "file");
                writableMapCreateMap.putString(RRWebVideoEvent.JsonKeys.SIZE, String.valueOf(file.length()));
                writableMapCreateMap.putString("lastModified", String.valueOf(file.lastModified()));
            }
            return writableMapCreateMap;
        } catch (Exception unused) {
            return null;
        }
    }

    void scanFile(String[] strArr, String[] strArr2, final Callback callback) {
        try {
            MediaScannerConnection.scanFile(this.mCtx, strArr, strArr2, new MediaScannerConnection.OnScanCompletedListener() { // from class: com.ReactNativeBlobUtil.ReactNativeBlobUtilFS.2
                @Override // android.media.MediaScannerConnection.OnScanCompletedListener
                public void onScanCompleted(String str, Uri uri) {
                    callback.invoke(null, Boolean.TRUE);
                }
            });
        } catch (Exception e) {
            callback.invoke(e.getLocalizedMessage(), null);
        }
    }

    static void hash(String str, String str2, Promise promise) {
        try {
            HashMap map = new HashMap();
            map.put("md5", "MD5");
            map.put("sha1", "SHA-1");
            map.put("sha224", "SHA-224");
            map.put("sha256", "SHA-256");
            map.put("sha384", "SHA-384");
            map.put("sha512", "SHA-512");
            if (!map.containsKey(str2)) {
                promise.reject("EINVAL", "Invalid algorithm '" + str2 + "', must be one of md5, sha1, sha224, sha256, sha384, sha512");
                return;
            }
            if (!str.startsWith(ReactNativeBlobUtilConst.FILE_PREFIX_CONTENT) && new File(ReactNativeBlobUtilUtils.normalizePath(str)).isDirectory()) {
                promise.reject("EISDIR", "Expecting a file but '" + str + "' is a directory");
                return;
            }
            MessageDigest messageDigest = MessageDigest.getInstance((String) map.get(str2));
            InputStream inputStreamInputStreamFromPath = inputStreamFromPath(str);
            if (inputStreamInputStreamFromPath == null) {
                promise.reject("ENOENT", "No such file '" + str + "'");
                return;
            }
            byte[] bArr = new byte[1048576];
            while (true) {
                int i = inputStreamInputStreamFromPath.read(bArr);
                if (i == -1) {
                    break;
                } else {
                    messageDigest.update(bArr, 0, i);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (byte b : messageDigest.digest()) {
                sb.append(String.format("%02x", Byte.valueOf(b)));
            }
            promise.resolve(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
            promise.reject("EUNSPECIFIED", e.getLocalizedMessage());
        }
    }

    static void createFile(String str, String str2, String str3, Promise promise) {
        try {
            String strNormalizePath = ReactNativeBlobUtilUtils.normalizePath(str);
            File file = new File(strNormalizePath);
            boolean zCreateNewFile = file.createNewFile();
            if (str3.equals("uri")) {
                File file2 = new File(str2.replace(ReactNativeBlobUtilConst.FILE_PREFIX, ""));
                if (!file2.exists()) {
                    promise.reject("ENOENT", "Source file : " + str2 + " does not exist");
                    return;
                }
                FileInputStream fileInputStreamCreate = SentryFileInputStream.Factory.create(new FileInputStream(file2), file2);
                FileOutputStream fileOutputStreamCreate = SentryFileOutputStream.Factory.create(new FileOutputStream(file), file);
                byte[] bArr = new byte[Data.MAX_DATA_BYTES];
                for (int i = fileInputStreamCreate.read(bArr); i > 0; i = fileInputStreamCreate.read(bArr)) {
                    fileOutputStreamCreate.write(bArr, 0, i);
                }
                fileInputStreamCreate.close();
                fileOutputStreamCreate.close();
            } else {
                if (!zCreateNewFile) {
                    promise.reject("EEXIST", "File `" + strNormalizePath + "` already exists");
                    return;
                }
                SentryFileOutputStream.Factory.create(new FileOutputStream(file), file).write(ReactNativeBlobUtilUtils.stringToBytes(str2, str3));
            }
            promise.resolve(strNormalizePath);
        } catch (Exception e) {
            promise.reject("EUNSPECIFIED", e.getLocalizedMessage());
        }
    }

    static void createFileASCII(String str, ReadableArray readableArray, Promise promise) {
        try {
            String strNormalizePath = ReactNativeBlobUtilUtils.normalizePath(str);
            File file = new File(strNormalizePath);
            if (!file.createNewFile()) {
                promise.reject("EEXIST", "File at path `" + strNormalizePath + "` already exists");
                return;
            }
            FileOutputStream fileOutputStreamCreate = SentryFileOutputStream.Factory.create(new FileOutputStream(file), file);
            byte[] bArr = new byte[readableArray.size()];
            for (int i = 0; i < readableArray.size(); i++) {
                bArr[i] = (byte) readableArray.getInt(i);
            }
            fileOutputStreamCreate.write(bArr);
            promise.resolve(strNormalizePath);
        } catch (Exception e) {
            promise.reject("EUNSPECIFIED", e.getLocalizedMessage());
        }
    }

    static void df(Callback callback, ReactApplicationContext reactApplicationContext) {
        StatFs statFs = new StatFs(reactApplicationContext.getFilesDir().getPath());
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("internal_free", String.valueOf(statFs.getFreeBytes()));
        writableMapCreateMap.putString("internal_total", String.valueOf(statFs.getTotalBytes()));
        File externalFilesDir = reactApplicationContext.getExternalFilesDir(null);
        if (externalFilesDir != null) {
            StatFs statFs2 = new StatFs(externalFilesDir.getPath());
            writableMapCreateMap.putString("external_free", String.valueOf(statFs2.getFreeBytes()));
            writableMapCreateMap.putString("external_total", String.valueOf(statFs2.getTotalBytes()));
        } else {
            writableMapCreateMap.putString("external_free", "-1");
            writableMapCreateMap.putString("external_total", "-1");
        }
        callback.invoke(null, writableMapCreateMap);
    }

    static void removeSession(ReadableArray readableArray, final Callback callback) {
        new AsyncTask<ReadableArray, Integer, Integer>() { // from class: com.ReactNativeBlobUtil.ReactNativeBlobUtilFS.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public Integer doInBackground(ReadableArray... readableArrayArr) {
                try {
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < readableArrayArr[0].size(); i++) {
                        String string = readableArrayArr[0].getString(i);
                        File file = new File(string);
                        if (file.exists() && !file.delete()) {
                            arrayList.add(string);
                        }
                    }
                    if (arrayList.isEmpty()) {
                        callback.invoke(null, Boolean.TRUE);
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Failed to delete: ");
                        Iterator it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            sb.append((String) it2.next());
                            sb.append(", ");
                        }
                        callback.invoke(sb.toString());
                    }
                } catch (Exception e) {
                    callback.invoke(e.getLocalizedMessage());
                }
                return Integer.valueOf(readableArrayArr[0].size());
            }
        }.execute(readableArray);
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x017e, code lost:
    
        if (((java.lang.Boolean) java.lang.String.class.getMethod("startsWith", java.lang.String.class).invoke(r19, com.ReactNativeBlobUtil.ReactNativeBlobUtilConst.FILE_PREFIX_CONTENT)).booleanValue() != false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x004d, code lost:
    
        if (((java.lang.Boolean) java.lang.String.class.getMethod("startsWith", java.lang.String.class).invoke(r19, com.ReactNativeBlobUtil.ReactNativeBlobUtilConst.FILE_PREFIX_BUNDLE_ASSET)).booleanValue() != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.io.InputStream inputStreamFromPath(java.lang.String r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 427
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ReactNativeBlobUtil.ReactNativeBlobUtilFS.inputStreamFromPath(java.lang.String):java.io.InputStream");
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0056, code lost:
    
        if (((java.lang.Boolean) java.lang.String.class.getMethod("startsWith", java.lang.String.class).invoke(r13, com.ReactNativeBlobUtil.ReactNativeBlobUtilConst.FILE_PREFIX_BUNDLE_ASSET)).booleanValue() != false) goto L40;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean isPathExists(java.lang.String r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 224
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ReactNativeBlobUtil.ReactNativeBlobUtilFS.isPathExists(java.lang.String):boolean");
    }

    static boolean isAsset(String str) {
        return str != null && str.startsWith(ReactNativeBlobUtilConst.FILE_PREFIX_BUNDLE_ASSET);
    }
}
