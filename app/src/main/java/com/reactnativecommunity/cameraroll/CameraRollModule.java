package com.reactnativecommunity.cameraroll;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.media.ExifInterface;
import android.media.MediaMetadataRetriever;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.FileUtils;
import android.provider.MediaStore;
import android.text.TextUtils;
import ch.qos.logback.classic.spi.CallerData;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.common.logging.FLog;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.BaseActivityEventListener;
import com.facebook.react.bridge.GuardedAsyncTask;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.share.internal.ShareConstants;
import com.google.firebase.sessions.settings.RemoteSettings;
import io.sentry.instrumentation.file.SentryFileInputStream;
import io.sentry.instrumentation.file.SentryFileOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
@ReactModule(name = CameraRollModule.NAME)
public class CameraRollModule extends NativeCameraRollModuleSpec {
    private static final String ASSET_TYPE_ALL = "All";
    private static final String ASSET_TYPE_PHOTOS = "Photos";
    private static final String ASSET_TYPE_VIDEOS = "Videos";
    private static final int DELETE_REQUEST_CODE = 1001;
    private static final String ERROR_UNABLE_TO_DELETE = "E_UNABLE_TO_DELETE";
    private static final String ERROR_UNABLE_TO_FILTER = "E_UNABLE_TO_FILTER";
    private static final String ERROR_UNABLE_TO_LOAD = "E_UNABLE_TO_LOAD";
    private static final String ERROR_UNABLE_TO_LOAD_PERMISSION = "E_UNABLE_TO_LOAD_PERMISSION";
    private static final String ERROR_UNABLE_TO_SAVE = "E_UNABLE_TO_SAVE";
    private static final String INCLUDE_ALBUMS = "albums";
    private static final String INCLUDE_FILENAME = "filename";
    private static final String INCLUDE_FILE_EXTENSION = "fileExtension";
    private static final String INCLUDE_FILE_SIZE = "fileSize";
    private static final String INCLUDE_IMAGE_SIZE = "imageSize";
    private static final String INCLUDE_LOCATION = "location";
    private static final String INCLUDE_ORIENTATION = "orientation";
    private static final String INCLUDE_PLAYABLE_DURATION = "playableDuration";
    private static final String INCLUDE_SOURCE_TYPE = "sourceType";
    public static final String NAME = "RNCCameraRoll";
    private static final String[] PROJECTION = {"_id", "mime_type", "bucket_display_name", "datetaken", "date_added", "date_modified", "width", "height", "_size", "_data", "orientation"};
    private static final String SELECTION_BUCKET = "bucket_display_name = ?";
    private Promise deletePromise;

    public void addListener(String str) {
    }

    public void removeListeners(double d) {
    }

    public CameraRollModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        reactApplicationContext.addActivityEventListener(new BaseActivityEventListener() { // from class: com.reactnativecommunity.cameraroll.CameraRollModule.1
            @Override // com.facebook.react.bridge.BaseActivityEventListener, com.facebook.react.bridge.ActivityEventListener
            public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
                if (i != 1001 || CameraRollModule.this.deletePromise == null) {
                    return;
                }
                if (i2 == -1) {
                    CameraRollModule.this.deletePromise.resolve("Files successfully deleted");
                } else {
                    CameraRollModule.this.deletePromise.reject("ERROR", "Deletion was not completed");
                }
                CameraRollModule.this.deletePromise = null;
            }
        });
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    @Override // com.reactnativecommunity.cameraroll.NativeCameraRollModuleSpec
    @ReactMethod
    public void saveToCameraRoll(String str, ReadableMap readableMap, Promise promise) {
        new SaveToCameraRoll(getReactApplicationContext(), Uri.parse(str), readableMap, promise).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    /* JADX INFO: loaded from: classes6.dex */
    static class SaveToCameraRoll extends GuardedAsyncTask<Void, Void> {
        private final Context mContext;
        private final ReadableMap mOptions;
        private final Promise mPromise;
        private final Uri mUri;

        public SaveToCameraRoll(ReactContext reactContext, Uri uri, ReadableMap readableMap, Promise promise) {
            super(reactContext);
            this.mContext = reactContext;
            this.mUri = uri;
            this.mPromise = promise;
            this.mOptions = readableMap;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Code duplicated, block: B:120:0x020e A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:122:0x01e7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:124:0x0203 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:141:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:142:? A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:97:0x01f2 A[Catch: IOException -> 0x01f6, TRY_ENTER, TRY_LEAVE, TryCatch #1 {IOException -> 0x01f6, blocks: (B:77:0x01c9, B:97:0x01f2), top: B:118:0x002e }] */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r10v0 */
        /* JADX WARN: Type inference failed for: r10v1 */
        /* JADX WARN: Type inference failed for: r10v15, types: [java.io.OutputStream] */
        /* JADX WARN: Type inference failed for: r10v19 */
        /* JADX WARN: Type inference failed for: r10v20 */
        /* JADX WARN: Type inference failed for: r10v21 */
        /* JADX WARN: Type inference failed for: r10v4 */
        /* JADX WARN: Type inference failed for: r10v5 */
        /* JADX WARN: Type inference failed for: r11v0 */
        /* JADX WARN: Type inference failed for: r11v1 */
        /* JADX WARN: Type inference failed for: r11v10 */
        /* JADX WARN: Type inference failed for: r11v11 */
        /* JADX WARN: Type inference failed for: r11v12 */
        /* JADX WARN: Type inference failed for: r11v2, types: [java.io.FileInputStream] */
        /* JADX WARN: Type inference failed for: r11v3 */
        /* JADX WARN: Type inference failed for: r11v4 */
        /* JADX WARN: Type inference failed for: r11v5 */
        /* JADX WARN: Type inference failed for: r11v6, types: [java.io.FileInputStream] */
        /* JADX WARN: Type inference failed for: r11v8 */
        /* JADX WARN: Type inference failed for: r11v9 */
        /* JADX WARN: Type inference failed for: r5v0, types: [java.io.File] */
        /* JADX WARN: Type inference failed for: r5v10 */
        /* JADX WARN: Type inference failed for: r5v11 */
        /* JADX WARN: Type inference failed for: r5v16, types: [java.io.FileInputStream] */
        /* JADX WARN: Type inference failed for: r5v19 */
        /* JADX WARN: Type inference failed for: r5v20 */
        /* JADX WARN: Type inference failed for: r5v21 */
        /* JADX WARN: Type inference failed for: r5v22 */
        /* JADX WARN: Type inference failed for: r5v23 */
        /* JADX WARN: Type inference failed for: r5v24 */
        /* JADX WARN: Type inference failed for: r5v25 */
        /* JADX WARN: Type inference failed for: r5v3 */
        /* JADX WARN: Type inference failed for: r5v5 */
        /* JADX WARN: Type inference failed for: r5v6 */
        /* JADX WARN: Type inference failed for: r5v9 */
        /* JADX WARN: Type inference failed for: r8v1 */
        /* JADX WARN: Type inference failed for: r8v10 */
        /* JADX WARN: Type inference failed for: r8v14 */
        /* JADX WARN: Type inference failed for: r8v15 */
        /* JADX WARN: Type inference failed for: r8v2 */
        /* JADX WARN: Type inference failed for: r8v24 */
        /* JADX WARN: Type inference failed for: r8v25 */
        /* JADX WARN: Type inference failed for: r8v3, types: [java.io.OutputStream] */
        /* JADX WARN: Type inference failed for: r8v4 */
        /* JADX WARN: Type inference failed for: r8v5 */
        /* JADX WARN: Type inference failed for: r8v6, types: [java.io.OutputStream] */
        /* JADX WARN: Type inference failed for: r8v7 */
        /* JADX WARN: Type inference failed for: r8v8 */
        /* JADX WARN: Type inference failed for: r8v9 */
        @Override // com.facebook.react.bridge.GuardedAsyncTask
        public void doInBackgroundGuarded(Void... voidArr) throws Throwable {
            ?? r8;
            Throwable th;
            ?? r11;
            ?? r9;
            ?? r12;
            ?? r13;
            ?? r5;
            Throwable th2;
            ?? r10;
            ?? r6;
            OutputStream outputStreamOpenOutputStream;
            ?? r14;
            ?? r7;
            File externalStoragePublicDirectory;
            String strSubstring;
            Uri uriInsert;
            ?? file = new File(this.mUri.getPath());
            String mimeType = Utils.getMimeType(this.mUri.toString());
            int i = 0;
            ?? r15 = (mimeType == null || !mimeType.contains("video")) ? 0 : 1;
            try {
                try {
                    String string = this.mOptions.getString("album");
                    boolean zIsEmpty = TextUtils.isEmpty(string);
                    try {
                        try {
                            if (Build.VERSION.SDK_INT >= 29) {
                                ContentValues contentValues = new ContentValues();
                                if (!zIsEmpty) {
                                    contentValues.put("relative_path", Environment.DIRECTORY_DCIM + File.separator + string);
                                }
                                contentValues.put("mime_type", mimeType);
                                contentValues.put("_display_name", file.getName());
                                contentValues.put("is_pending", (Integer) 1);
                                ContentResolver contentResolver = this.mContext.getContentResolver();
                                if (r15 != 0) {
                                    uriInsert = contentResolver.insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, contentValues);
                                } else {
                                    uriInsert = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
                                }
                                if (uriInsert == null) {
                                    this.mPromise.reject(CameraRollModule.ERROR_UNABLE_TO_LOAD, "ContentResolver#insert() returns null, insert failed");
                                }
                                outputStreamOpenOutputStream = contentResolver.openOutputStream(uriInsert);
                                try {
                                    FileInputStream fileInputStreamCreate = SentryFileInputStream.Factory.create(new FileInputStream((File) file), (File) file);
                                    FileUtils.copy(fileInputStreamCreate, outputStreamOpenOutputStream);
                                    contentValues.clear();
                                    contentValues.put("is_pending", (Integer) 0);
                                    contentResolver.update(uriInsert, contentValues, null, null);
                                    this.mPromise.resolve(getSingleAssetInfo(uriInsert));
                                    file = fileInputStreamCreate;
                                    r15 = outputStreamOpenOutputStream;
                                } catch (IOException e) {
                                    e = e;
                                    r9 = outputStreamOpenOutputStream;
                                    r12 = 0;
                                    try {
                                        this.mPromise.reject(e);
                                        if (r12 != 0) {
                                            try {
                                                r12.close();
                                            } catch (IOException e2) {
                                                FLog.e(ReactConstants.TAG, "Could not close input channel", e2);
                                            }
                                        }
                                        if (r9 != 0) {
                                            return;
                                        } else {
                                            r9.close();
                                        }
                                    } catch (Throwable th3) {
                                        th2 = th3;
                                        r6 = r12;
                                        r10 = r9;
                                        r13 = r10;
                                        r5 = r6;
                                        r8 = r13;
                                        r11 = r5;
                                        th = th2;
                                        if (r11 != 0) {
                                            try {
                                                r11.close();
                                            } catch (IOException e3) {
                                                FLog.e(ReactConstants.TAG, "Could not close input channel", e3);
                                            }
                                        }
                                        if (r8 != 0) {
                                            try {
                                                r8.close();
                                                throw th;
                                            } catch (IOException e4) {
                                                FLog.e(ReactConstants.TAG, "Could not close output channel", e4);
                                                throw th;
                                            }
                                        }
                                        throw th;
                                    }
                                } catch (Throwable th4) {
                                    th = th4;
                                    th = th;
                                    r8 = outputStreamOpenOutputStream;
                                    r11 = 0;
                                    if (r11 != 0) {
                                        r11.close();
                                    }
                                    if (r8 != 0) {
                                        r8.close();
                                        throw th;
                                    }
                                    throw th;
                                }
                            } else {
                                if (!zIsEmpty) {
                                    if ("video".equals(this.mOptions.getString("type"))) {
                                        externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES);
                                    } else {
                                        externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                                    }
                                } else {
                                    externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
                                }
                                if (!zIsEmpty) {
                                    File file2 = new File(externalStoragePublicDirectory, string);
                                    if (!file2.exists() && !file2.mkdirs()) {
                                        this.mPromise.reject(CameraRollModule.ERROR_UNABLE_TO_LOAD, "Album Directory not created. Did you request WRITE_EXTERNAL_STORAGE?");
                                        return;
                                    }
                                    externalStoragePublicDirectory = file2;
                                }
                                if (!externalStoragePublicDirectory.isDirectory()) {
                                    this.mPromise.reject(CameraRollModule.ERROR_UNABLE_TO_LOAD, "External media storage directory not available");
                                    return;
                                }
                                File file3 = new File(externalStoragePublicDirectory, file.getName());
                                String name = file.getName();
                                if (name.indexOf(46) >= 0) {
                                    String strSubstring2 = name.substring(0, name.lastIndexOf(46));
                                    strSubstring = name.substring(name.lastIndexOf(46));
                                    name = strSubstring2;
                                } else {
                                    strSubstring = "";
                                }
                                while (!file3.createNewFile()) {
                                    i++;
                                    file3 = new File(externalStoragePublicDirectory, name + "_" + i + strSubstring);
                                }
                                FileInputStream fileInputStreamCreate2 = SentryFileInputStream.Factory.create(new FileInputStream((File) file), (File) file);
                                try {
                                    FileOutputStream fileOutputStreamCreate = SentryFileOutputStream.Factory.create(new FileOutputStream(file3), file3);
                                    fileOutputStreamCreate.getChannel().transferFrom(fileInputStreamCreate2.getChannel(), 0L, fileInputStreamCreate2.getChannel().size());
                                    fileInputStreamCreate2.close();
                                    fileOutputStreamCreate.close();
                                    MediaScannerConnection.scanFile(this.mContext, new String[]{file3.getAbsolutePath()}, null, new MediaScannerConnection.OnScanCompletedListener() { // from class: com.reactnativecommunity.cameraroll.CameraRollModule$SaveToCameraRoll$$ExternalSyntheticLambda3
                                        @Override // android.media.MediaScannerConnection.OnScanCompletedListener
                                        public final void onScanCompleted(String str, Uri uri) {
                                            this.f$0.lambda$doInBackgroundGuarded$0(str, uri);
                                        }
                                    });
                                    file = fileInputStreamCreate2;
                                    r15 = fileOutputStreamCreate;
                                } catch (IOException e5) {
                                    e = e5;
                                    r14 = 0;
                                    r7 = fileInputStreamCreate2;
                                    r12 = r7;
                                    r9 = r14;
                                    this.mPromise.reject(e);
                                    if (r12 != 0) {
                                        r12.close();
                                    }
                                    if (r9 != 0) {
                                        return;
                                    } else {
                                        r9.close();
                                    }
                                } catch (Throwable th5) {
                                    th2 = th5;
                                    r10 = 0;
                                    r6 = fileInputStreamCreate2;
                                    r13 = r10;
                                    r5 = r6;
                                    r8 = r13;
                                    r11 = r5;
                                    th = th2;
                                    if (r11 != 0) {
                                        r11.close();
                                    }
                                    if (r8 != 0) {
                                        r8.close();
                                        throw th;
                                    }
                                    throw th;
                                }
                                this.mPromise.reject(e);
                                if (r12 != 0) {
                                    r12.close();
                                }
                                if (r9 != 0) {
                                    r9.close();
                                }
                                return;
                            }
                            if (file != 0) {
                                try {
                                    file.close();
                                } catch (IOException e6) {
                                    FLog.e(ReactConstants.TAG, "Could not close input channel", e6);
                                }
                            }
                            if (r15 != 0) {
                                r15.close();
                            }
                        } catch (IOException e7) {
                            e = e7;
                            outputStreamOpenOutputStream = null;
                        } catch (Throwable th6) {
                            th = th6;
                            outputStreamOpenOutputStream = null;
                        }
                    } catch (IOException e8) {
                        e = e8;
                        r14 = r15;
                        r7 = file;
                    } catch (Throwable th7) {
                        th2 = th7;
                        r13 = r15;
                        r5 = file;
                        r8 = r13;
                        r11 = r5;
                        th = th2;
                        if (r11 != 0) {
                            r11.close();
                        }
                        if (r8 != 0) {
                            r8.close();
                            throw th;
                        }
                        throw th;
                    }
                } catch (IOException e9) {
                    e = e9;
                    r9 = 0;
                    r12 = 0;
                } catch (Throwable th8) {
                    r8 = 0;
                    th = th8;
                    r11 = 0;
                }
            } catch (IOException e10) {
                FLog.e(ReactConstants.TAG, "Could not close output channel", e10);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$doInBackgroundGuarded$0(String str, Uri uri) {
            if (uri == null) {
                this.mPromise.reject(CameraRollModule.ERROR_UNABLE_TO_SAVE, "Could not add image to gallery");
                return;
            }
            try {
                this.mPromise.resolve(getSingleAssetInfo(uri));
            } catch (Exception e) {
                this.mPromise.reject(CameraRollModule.ERROR_UNABLE_TO_SAVE, e.getMessage());
            }
        }

        private WritableMap getSingleAssetInfo(Uri uri) {
            ContentResolver contentResolver = this.mContext.getContentResolver();
            Cursor cursorQuery = contentResolver.query(uri, CameraRollModule.PROJECTION, null, null, null);
            if (cursorQuery == null) {
                throw new RuntimeException("Failed to find the photo that was just saved!");
            }
            cursorQuery.moveToFirst();
            WritableMap writableMapConvertMediaToMap = CameraRollModule.convertMediaToMap(contentResolver, cursorQuery, CameraRollModule$SaveToCameraRoll$$ExternalSyntheticBackport2.m(new Object[]{"location", "filename", CameraRollModule.INCLUDE_FILE_SIZE, CameraRollModule.INCLUDE_FILE_EXTENSION, CameraRollModule.INCLUDE_IMAGE_SIZE, CameraRollModule.INCLUDE_PLAYABLE_DURATION, "orientation", CameraRollModule.INCLUDE_ALBUMS, CameraRollModule.INCLUDE_SOURCE_TYPE}));
            cursorQuery.close();
            return writableMapConvertMediaToMap;
        }
    }

    @Override // com.reactnativecommunity.cameraroll.NativeCameraRollModuleSpec
    @ReactMethod
    public void getPhotos(ReadableMap readableMap, Promise promise) {
        int i = readableMap.getInt("first");
        String string = readableMap.hasKey("after") ? readableMap.getString("after") : null;
        String string2 = readableMap.hasKey("groupName") ? readableMap.getString("groupName") : null;
        String string3 = readableMap.hasKey("assetType") ? readableMap.getString("assetType") : ASSET_TYPE_PHOTOS;
        long j = readableMap.hasKey("fromTime") ? (long) readableMap.getDouble("fromTime") : 0L;
        long j2 = readableMap.hasKey("toTime") ? (long) readableMap.getDouble("toTime") : 0L;
        new GetMediaTask(getReactApplicationContext(), i, string, string2, readableMap.hasKey("mimeTypes") ? readableMap.getArray("mimeTypes") : null, string3, j, j2, readableMap.hasKey("include") ? readableMap.getArray("include") : null, promise).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    @ReactMethod
    public void deleteMediaFiles(ReadableArray readableArray, Promise promise) {
        ContentResolver contentResolver = getReactApplicationContext().getContentResolver();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < readableArray.size(); i++) {
            arrayList.add(Uri.parse(readableArray.getString(i)));
        }
        this.deletePromise = promise;
        if (Build.VERSION.SDK_INT >= 30) {
            try {
                IntentSender intentSender = MediaStore.createDeleteRequest(contentResolver, arrayList).getIntentSender();
                Activity currentActivity = getCurrentActivity();
                if (currentActivity != null) {
                    currentActivity.startIntentSenderForResult(intentSender, 1001, null, 0, 0, 0);
                } else {
                    promise.reject("ERROR", "Activity is null");
                }
                return;
            } catch (Exception e) {
                promise.reject("ERROR", e.getMessage());
                return;
            }
        }
        try {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                contentResolver.delete((Uri) it2.next(), null, null);
            }
            promise.resolve("Files deleted");
        } catch (Exception e2) {
            promise.reject("ERROR", e2.getMessage());
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    static class GetMediaTask extends GuardedAsyncTask<Void, Void> {

        @Nullable
        private final String mAfter;
        private final String mAssetType;
        private final Context mContext;
        private final int mFirst;
        private final long mFromTime;

        @Nullable
        private final String mGroupName;
        private final Set<String> mInclude;

        @Nullable
        private final ReadableArray mMimeTypes;
        private final Promise mPromise;
        private final long mToTime;

        private GetMediaTask(ReactContext reactContext, int i, @Nullable String str, @Nullable String str2, @Nullable ReadableArray readableArray, String str3, long j, long j2, @Nullable ReadableArray readableArray2, Promise promise) {
            super(reactContext);
            this.mContext = reactContext;
            this.mFirst = i;
            this.mAfter = str;
            this.mGroupName = str2;
            this.mMimeTypes = readableArray;
            this.mPromise = promise;
            this.mAssetType = str3;
            this.mFromTime = j;
            this.mToTime = j2;
            this.mInclude = createSetFromIncludeArray(readableArray2);
        }

        private static Set<String> createSetFromIncludeArray(@Nullable ReadableArray readableArray) {
            HashSet hashSet = new HashSet();
            if (readableArray == null) {
                return hashSet;
            }
            for (int i = 0; i < readableArray.size(); i++) {
                String string = readableArray.getString(i);
                if (string != null) {
                    hashSet.add(string);
                }
            }
            return hashSet;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.react.bridge.GuardedAsyncTask
        public void doInBackgroundGuarded(Void... voidArr) {
            Cursor cursorQuery;
            StringBuilder sb = new StringBuilder(AppEventsConstants.EVENT_PARAM_VALUE_YES);
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(this.mGroupName)) {
                sb.append(" AND bucket_display_name = ?");
                arrayList.add(this.mGroupName);
            }
            if (this.mAssetType.equals(CameraRollModule.ASSET_TYPE_PHOTOS)) {
                sb.append(" AND media_type = 1");
            } else if (this.mAssetType.equals(CameraRollModule.ASSET_TYPE_VIDEOS)) {
                sb.append(" AND media_type = 3");
            } else if (this.mAssetType.equals(CameraRollModule.ASSET_TYPE_ALL)) {
                sb.append(" AND media_type IN (3,1)");
            } else {
                this.mPromise.reject(CameraRollModule.ERROR_UNABLE_TO_FILTER, "Invalid filter option: '" + this.mAssetType + "'. Expected one of '" + CameraRollModule.ASSET_TYPE_PHOTOS + "', '" + CameraRollModule.ASSET_TYPE_VIDEOS + "' or '" + CameraRollModule.ASSET_TYPE_ALL + "'.");
                return;
            }
            ReadableArray readableArray = this.mMimeTypes;
            if (readableArray != null && readableArray.size() > 0) {
                sb.append(" AND mime_type IN (");
                for (int i = 0; i < this.mMimeTypes.size(); i++) {
                    sb.append("?,");
                    arrayList.add(this.mMimeTypes.getString(i));
                }
                sb.replace(sb.length() - 1, sb.length(), ")");
            }
            long j = this.mFromTime;
            if (j > 0) {
                sb.append(" AND (datetaken > ? OR ( datetaken IS NULL AND date_added> ? ))");
                arrayList.add(this.mFromTime + "");
                arrayList.add((j / 1000) + "");
            }
            long j2 = this.mToTime;
            if (j2 > 0) {
                sb.append(" AND (datetaken <= ? OR ( datetaken IS NULL AND date_added <= ? ))");
                arrayList.add(this.mToTime + "");
                arrayList.add((j2 / 1000) + "");
            }
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            ContentResolver contentResolver = this.mContext.getContentResolver();
            try {
                if (Build.VERSION.SDK_INT >= 30) {
                    Bundle bundle = new Bundle();
                    bundle.putString("android:query-arg-sql-selection", sb.toString());
                    bundle.putStringArray("android:query-arg-sql-selection-args", (String[]) arrayList.toArray(new String[arrayList.size()]));
                    bundle.putString("android:query-arg-sql-sort-order", "date_added DESC, date_modified DESC");
                    bundle.putInt("android:query-arg-limit", this.mFirst + 1);
                    if (!TextUtils.isEmpty(this.mAfter)) {
                        bundle.putInt("android:query-arg-offset", Integer.parseInt(this.mAfter));
                    }
                    cursorQuery = contentResolver.query(MediaStore.Files.getContentUri("external"), CameraRollModule.PROJECTION, bundle, null);
                } else {
                    String str = "limit=" + (this.mFirst + 1);
                    if (!TextUtils.isEmpty(this.mAfter)) {
                        str = "limit=" + this.mAfter + "," + (this.mFirst + 1);
                    }
                    cursorQuery = contentResolver.query(MediaStore.Files.getContentUri("external").buildUpon().encodedQuery(str).build(), CameraRollModule.PROJECTION, sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]), "date_added DESC, date_modified DESC");
                }
                if (cursorQuery == null) {
                    this.mPromise.reject(CameraRollModule.ERROR_UNABLE_TO_LOAD, "Could not get media");
                    return;
                }
                try {
                    CameraRollModule.putEdges(contentResolver, cursorQuery, writableNativeMap, this.mFirst, this.mInclude);
                    CameraRollModule.putPageInfo(cursorQuery, writableNativeMap, this.mFirst, TextUtils.isEmpty(this.mAfter) ? 0 : Integer.parseInt(this.mAfter));
                } finally {
                    cursorQuery.close();
                    this.mPromise.resolve(writableNativeMap);
                }
            } catch (SecurityException e) {
                this.mPromise.reject(CameraRollModule.ERROR_UNABLE_TO_LOAD_PERMISSION, "Could not get media: need READ_EXTERNAL_STORAGE permission", e);
            }
        }
    }

    @Override // com.reactnativecommunity.cameraroll.NativeCameraRollModuleSpec
    @ReactMethod
    public void getAlbums(ReadableMap readableMap, Promise promise) {
        String string = readableMap.hasKey("assetType") ? readableMap.getString("assetType") : ASSET_TYPE_ALL;
        StringBuilder sb = new StringBuilder(AppEventsConstants.EVENT_PARAM_VALUE_YES);
        ArrayList arrayList = new ArrayList();
        if (string.equals(ASSET_TYPE_PHOTOS)) {
            sb.append(" AND media_type = 1");
        } else if (string.equals(ASSET_TYPE_VIDEOS)) {
            sb.append(" AND media_type = 3");
        } else {
            if (!string.equals(ASSET_TYPE_ALL)) {
                promise.reject(ERROR_UNABLE_TO_FILTER, "Invalid filter option: '" + string + "'. Expected one of '" + ASSET_TYPE_PHOTOS + "', '" + ASSET_TYPE_VIDEOS + "' or '" + ASSET_TYPE_ALL + "'.");
                return;
            }
            sb.append(" AND media_type IN (3,1)");
        }
        try {
            Cursor cursorQuery = getReactApplicationContext().getContentResolver().query(MediaStore.Files.getContentUri("external"), new String[]{"bucket_display_name", "bucket_id"}, sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]), null);
            if (cursorQuery == null) {
                promise.reject(ERROR_UNABLE_TO_LOAD, "Could not get media");
                return;
            }
            WritableNativeArray writableNativeArray = new WritableNativeArray();
            try {
                if (cursorQuery.moveToFirst()) {
                    HashMap map = new HashMap();
                    do {
                        int columnIndex = cursorQuery.getColumnIndex("bucket_display_name");
                        int columnIndex2 = cursorQuery.getColumnIndex("bucket_id");
                        if (columnIndex < 0) {
                            throw new IndexOutOfBoundsException();
                        }
                        String string2 = cursorQuery.getString(columnIndex2);
                        String string3 = cursorQuery.getString(columnIndex);
                        if (string3 != null) {
                            Map map2 = (Map) map.get(string3);
                            if (map2 != null) {
                                map2.put("count", Integer.valueOf(((Integer) map2.get("count")).intValue() + 1));
                            } else {
                                map.put(string3, new HashMap<String, Object>(string2) { // from class: com.reactnativecommunity.cameraroll.CameraRollModule.2
                                    final /* synthetic */ String val$albumId;

                                    {
                                        this.val$albumId = string2;
                                        put("id", string2);
                                        put("count", 1);
                                    }
                                });
                            }
                        }
                    } while (cursorQuery.moveToNext());
                    for (Map.Entry entry : map.entrySet()) {
                        WritableNativeMap writableNativeMap = new WritableNativeMap();
                        Map map3 = (Map) entry.getValue();
                        writableNativeMap.putString("title", (String) entry.getKey());
                        writableNativeMap.putInt("count", ((Integer) map3.get("count")).intValue());
                        writableNativeMap.putString("id", (String) map3.get("id"));
                        writableNativeArray.pushMap(writableNativeMap);
                    }
                }
                cursorQuery.close();
                promise.resolve(writableNativeArray);
            } catch (Throwable th) {
                cursorQuery.close();
                promise.resolve(writableNativeArray);
                throw th;
            }
        } catch (Exception e) {
            promise.reject(ERROR_UNABLE_TO_LOAD, "Could not get media", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void putPageInfo(Cursor cursor, WritableMap writableMap, int i, int i2) {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putBoolean("has_next_page", i < cursor.getCount());
        if (i < cursor.getCount()) {
            writableNativeMap.putString("end_cursor", Integer.toString(i2 + i));
        }
        writableMap.putMap("page_info", writableNativeMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public static WritableMap convertMediaToMap(ContentResolver contentResolver, Cursor cursor, Set<String> set) {
        int columnIndex = cursor.getColumnIndex("_id");
        int columnIndex2 = cursor.getColumnIndex("mime_type");
        int columnIndex3 = cursor.getColumnIndex("bucket_display_name");
        int columnIndex4 = cursor.getColumnIndex("datetaken");
        int columnIndex5 = cursor.getColumnIndex("date_added");
        int columnIndex6 = cursor.getColumnIndex("date_modified");
        int columnIndex7 = cursor.getColumnIndex("width");
        int columnIndex8 = cursor.getColumnIndex("height");
        int columnIndex9 = cursor.getColumnIndex("_size");
        int columnIndex10 = cursor.getColumnIndex("_data");
        int columnIndex11 = cursor.getColumnIndex("orientation");
        boolean zContains = set.contains("location");
        boolean zContains2 = set.contains("filename");
        boolean zContains3 = set.contains(INCLUDE_FILE_SIZE);
        boolean zContains4 = set.contains(INCLUDE_FILE_EXTENSION);
        boolean zContains5 = set.contains(INCLUDE_IMAGE_SIZE);
        boolean zContains6 = set.contains(INCLUDE_PLAYABLE_DURATION);
        boolean zContains7 = set.contains("orientation");
        boolean zContains8 = set.contains(INCLUDE_ALBUMS);
        boolean zContains9 = set.contains(INCLUDE_SOURCE_TYPE);
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        WritableNativeMap writableNativeMap2 = new WritableNativeMap();
        if (!putImageInfo(contentResolver, cursor, writableNativeMap2, columnIndex7, columnIndex8, columnIndex9, columnIndex10, columnIndex11, columnIndex2, zContains2, zContains3, zContains4, zContains5, zContains6, zContains7)) {
            return null;
        }
        putBasicNodeInfo(cursor, writableNativeMap2, columnIndex, columnIndex2, columnIndex3, columnIndex4, columnIndex5, columnIndex6, zContains8, zContains9);
        putLocationInfo(cursor, writableNativeMap2, columnIndex10, zContains, columnIndex2, contentResolver);
        writableNativeMap.putMap("node", writableNativeMap2);
        return writableNativeMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void putEdges(ContentResolver contentResolver, Cursor cursor, WritableMap writableMap, int i, Set<String> set) {
        WritableNativeArray writableNativeArray = new WritableNativeArray();
        cursor.moveToFirst();
        int i2 = 0;
        while (i2 < i && !cursor.isAfterLast()) {
            WritableMap writableMapConvertMediaToMap = convertMediaToMap(contentResolver, cursor, set);
            if (writableMapConvertMediaToMap != null) {
                writableNativeArray.pushMap(writableMapConvertMediaToMap);
            } else {
                i2--;
            }
            cursor.moveToNext();
            i2++;
        }
        writableMap.putArray("edges", writableNativeArray);
    }

    private static void putBasicNodeInfo(Cursor cursor, WritableMap writableMap, int i, int i2, int i3, int i4, int i5, int i6, boolean z, boolean z2) {
        writableMap.putString("id", Long.toString(cursor.getLong(i)));
        writableMap.putString("type", cursor.getString(i2));
        writableMap.putArray("subTypes", Arguments.createArray());
        if (z2) {
            writableMap.putString(INCLUDE_SOURCE_TYPE, "UserLibrary");
        } else {
            writableMap.putNull(INCLUDE_SOURCE_TYPE);
        }
        WritableArray writableArrayCreateArray = Arguments.createArray();
        if (z) {
            writableArrayCreateArray.pushString(cursor.getString(i3));
        }
        writableMap.putArray("group_name", writableArrayCreateArray);
        long j = cursor.getLong(i4);
        if (j == 0) {
            j = cursor.getLong(i5) * 1000;
        }
        writableMap.putDouble("timestamp", j / 1000.0d);
        writableMap.putDouble("modificationTimestamp", cursor.getLong(i6));
    }

    private static boolean putImageInfo(ContentResolver contentResolver, Cursor cursor, WritableMap writableMap, int i, int i2, int i3, int i4, int i5, int i6, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) throws FileNotFoundException {
        Uri uriWithAppendedId;
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        int columnIndex = cursor.getColumnIndex("_id");
        long j = columnIndex >= 0 ? cursor.getLong(columnIndex) : -1L;
        String string = cursor.getString(i6);
        boolean z7 = string != null && string.startsWith("video");
        if (z7) {
            uriWithAppendedId = ContentUris.withAppendedId(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, j);
        } else {
            uriWithAppendedId = ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, j);
        }
        Uri uri = uriWithAppendedId;
        writableNativeMap.putString("uri", uri.toString());
        boolean zPutImageSize = putImageSize(contentResolver, cursor, writableNativeMap, i, i2, i5, uri, z7, z4);
        boolean zPutPlayableDuration = putPlayableDuration(contentResolver, writableNativeMap, uri, z7, z5);
        if (z) {
            writableNativeMap.putString("filename", new File(cursor.getString(i4)).getName());
        } else {
            writableNativeMap.putNull("filename");
        }
        if (z2) {
            writableNativeMap.putDouble(INCLUDE_FILE_SIZE, cursor.getLong(i3));
        } else {
            writableNativeMap.putNull(INCLUDE_FILE_SIZE);
        }
        if (z3) {
            writableNativeMap.putString(ShareConstants.MEDIA_EXTENSION, Utils.getExtension(string));
        } else {
            writableNativeMap.putNull(ShareConstants.MEDIA_EXTENSION);
        }
        if (z6) {
            if (cursor.isNull(i5)) {
                writableNativeMap.putInt("orientation", cursor.getInt(i5));
            } else {
                writableNativeMap.putInt("orientation", 0);
            }
        } else {
            writableNativeMap.putNull("orientation");
        }
        writableMap.putMap("image", writableNativeMap);
        return zPutImageSize && zPutPlayableDuration;
    }

    private static boolean putPlayableDuration(ContentResolver contentResolver, WritableMap writableMap, Uri uri, boolean z, boolean z2) {
        AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor;
        writableMap.putNull(INCLUDE_PLAYABLE_DURATION);
        boolean z3 = true;
        if (z2 && z) {
            boolean z4 = false;
            Integer numValueOf = null;
            try {
                assetFileDescriptorOpenAssetFileDescriptor = contentResolver.openAssetFileDescriptor(uri, "r");
            } catch (FileNotFoundException e) {
                FLog.e(ReactConstants.TAG, "Could not open asset file " + uri.toString(), e);
                z3 = false;
                assetFileDescriptorOpenAssetFileDescriptor = null;
            }
            if (assetFileDescriptorOpenAssetFileDescriptor != null) {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                try {
                    mediaMetadataRetriever.setDataSource(assetFileDescriptorOpenAssetFileDescriptor.getFileDescriptor());
                } catch (RuntimeException unused) {
                }
                try {
                    numValueOf = Integer.valueOf(Integer.parseInt(mediaMetadataRetriever.extractMetadata(9)) / 1000);
                    z4 = z3;
                } catch (NumberFormatException e2) {
                    FLog.e(ReactConstants.TAG, "Number format exception occurred while trying to fetch video metadata for " + uri.toString(), e2);
                }
                try {
                    mediaMetadataRetriever.release();
                } catch (Exception unused2) {
                }
                z3 = z4;
            }
            if (assetFileDescriptorOpenAssetFileDescriptor != null) {
                try {
                    assetFileDescriptorOpenAssetFileDescriptor.close();
                } catch (IOException unused3) {
                }
            }
            if (numValueOf != null) {
                writableMap.putInt(INCLUDE_PLAYABLE_DURATION, numValueOf.intValue());
            }
        }
        return z3;
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    private static boolean putImageSize(ContentResolver contentResolver, Cursor cursor, WritableMap writableMap, int i, int i2, int i3, Uri uri, boolean z, boolean z2) throws FileNotFoundException {
        AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor;
        boolean z3;
        int i4;
        writableMap.putNull("width");
        writableMap.putNull("height");
        boolean z4 = true;
        if (!z2) {
            return true;
        }
        int i5 = cursor.getInt(i);
        int i6 = cursor.getInt(i2);
        if (i5 <= 0 || i6 <= 0) {
            boolean z5 = false;
            try {
                assetFileDescriptorOpenAssetFileDescriptor = contentResolver.openAssetFileDescriptor(uri, "r");
                z3 = true;
            } catch (FileNotFoundException e) {
                FLog.e(ReactConstants.TAG, "Could not open asset file " + uri.toString(), e);
                assetFileDescriptorOpenAssetFileDescriptor = null;
                z3 = false;
            }
            if (assetFileDescriptorOpenAssetFileDescriptor != null) {
                if (z) {
                    MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                    try {
                        mediaMetadataRetriever.setDataSource(assetFileDescriptorOpenAssetFileDescriptor.getFileDescriptor());
                    } catch (RuntimeException unused) {
                    }
                    try {
                        i5 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
                        i6 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
                        z5 = z3;
                    } catch (NumberFormatException e2) {
                        FLog.e(ReactConstants.TAG, "Number format exception occurred while trying to fetch video metadata for " + uri.toString(), e2);
                    }
                    try {
                        mediaMetadataRetriever.release();
                    } catch (Exception unused2) {
                    }
                    z4 = z5;
                } else {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeFileDescriptor(assetFileDescriptorOpenAssetFileDescriptor.getFileDescriptor(), null, options);
                    int i7 = options.outWidth;
                    i6 = options.outHeight;
                    i5 = i7;
                    z4 = z3;
                }
                try {
                    assetFileDescriptorOpenAssetFileDescriptor.close();
                } catch (IOException e3) {
                    FLog.e(ReactConstants.TAG, "Can't close media descriptor " + uri.toString(), e3);
                }
            } else {
                z4 = z3;
            }
        }
        if (!cursor.isNull(i3) && (i4 = cursor.getInt(i3)) >= 0 && i4 % RotationOptions.ROTATE_180 != 0) {
            int i8 = i6;
            i6 = i5;
            i5 = i8;
        }
        writableMap.putInt("width", i5);
        writableMap.putInt("height", i6);
        return z4;
    }

    private static void putLocationInfo(Cursor cursor, WritableMap writableMap, int i, boolean z, int i2, ContentResolver contentResolver) {
        AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor;
        writableMap.putNull("location");
        if (z) {
            try {
                String string = cursor.getString(i2);
                if (string != null && string.startsWith("video")) {
                    Uri uri = Uri.parse("file://" + cursor.getString(i));
                    try {
                        assetFileDescriptorOpenAssetFileDescriptor = contentResolver.openAssetFileDescriptor(uri, "r");
                    } catch (FileNotFoundException e) {
                        FLog.e(ReactConstants.TAG, "Could not open asset file " + uri.toString(), e);
                        assetFileDescriptorOpenAssetFileDescriptor = null;
                    }
                    if (assetFileDescriptorOpenAssetFileDescriptor != null) {
                        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                        try {
                            mediaMetadataRetriever.setDataSource(assetFileDescriptorOpenAssetFileDescriptor.getFileDescriptor());
                        } catch (RuntimeException unused) {
                        }
                        try {
                            String strExtractMetadata = mediaMetadataRetriever.extractMetadata(23);
                            if (strExtractMetadata != null) {
                                String strReplaceAll = strExtractMetadata.replaceAll(RemoteSettings.FORWARD_SLASH_STRING, "");
                                WritableNativeMap writableNativeMap = new WritableNativeMap();
                                writableNativeMap.putDouble("latitude", Double.parseDouble(strReplaceAll.split("[+]|[-]")[1]));
                                writableNativeMap.putDouble("longitude", Double.parseDouble(strReplaceAll.split("[+]|[-]")[2]));
                                writableMap.putMap("location", writableNativeMap);
                            }
                        } catch (NumberFormatException e2) {
                            FLog.e(ReactConstants.TAG, "Number format exception occurred while trying to fetch video metadata for " + uri.toString(), e2);
                        }
                        try {
                            mediaMetadataRetriever.release();
                        } catch (Exception unused2) {
                        }
                    }
                    if (assetFileDescriptorOpenAssetFileDescriptor != null) {
                        try {
                            assetFileDescriptorOpenAssetFileDescriptor.close();
                            return;
                        } catch (IOException unused3) {
                            return;
                        }
                    }
                    return;
                }
                ExifInterface exifInterface = new ExifInterface(cursor.getString(i));
                float[] fArr = new float[2];
                if (exifInterface.getLatLong(fArr)) {
                    double d = fArr[1];
                    double d2 = fArr[0];
                    WritableNativeMap writableNativeMap2 = new WritableNativeMap();
                    writableNativeMap2.putDouble("longitude", d);
                    writableNativeMap2.putDouble("latitude", d2);
                    writableMap.putMap("location", writableNativeMap2);
                }
            } catch (IOException e3) {
                FLog.e(ReactConstants.TAG, "Could not read the metadata", e3);
            }
        }
    }

    @Override // com.reactnativecommunity.cameraroll.NativeCameraRollModuleSpec
    @ReactMethod
    public void deletePhotos(ReadableArray readableArray, Promise promise) {
        if (readableArray.size() == 0) {
            promise.reject(ERROR_UNABLE_TO_DELETE, "Need at least one URI to delete");
        } else {
            deleteMediaFiles(readableArray, promise);
        }
    }

    @Override // com.reactnativecommunity.cameraroll.NativeCameraRollModuleSpec
    @ReactMethod
    public void getPhotoByInternalID(String str, ReadableMap readableMap, Promise promise) {
        promise.reject("CameraRoll:getPhotoByInternalID", "getPhotoByInternalID is not supported on Android");
    }

    /* JADX INFO: loaded from: classes6.dex */
    static class DeletePhotos extends GuardedAsyncTask<Void, Void> {
        private final Context mContext;
        private final Promise mPromise;
        private final ReadableArray mUris;

        public DeletePhotos(ReactContext reactContext, ReadableArray readableArray, Promise promise) {
            super(reactContext);
            this.mContext = reactContext;
            this.mUris = readableArray;
            this.mPromise = promise;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.react.bridge.GuardedAsyncTask
        public void doInBackgroundGuarded(Void... voidArr) {
            ContentResolver contentResolver = this.mContext.getContentResolver();
            String[] strArr = {"_id"};
            String str = CallerData.NA;
            for (int i = 1; i < this.mUris.size(); i++) {
                str = str + ", ?";
            }
            String str2 = "_data IN (" + str + ")";
            Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            String[] strArr2 = new String[this.mUris.size()];
            int i2 = 0;
            for (int i3 = 0; i3 < this.mUris.size(); i3++) {
                strArr2[i3] = Uri.parse(this.mUris.getString(i3)).getPath();
            }
            Cursor cursorQuery = contentResolver.query(uri, strArr, str2, strArr2, null);
            while (cursorQuery.moveToNext()) {
                if (contentResolver.delete(ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, cursorQuery.getLong(cursorQuery.getColumnIndexOrThrow("_id"))), null, null) == 1) {
                    i2++;
                }
            }
            cursorQuery.close();
            if (i2 == this.mUris.size()) {
                this.mPromise.resolve(Boolean.TRUE);
                return;
            }
            this.mPromise.reject(CameraRollModule.ERROR_UNABLE_TO_DELETE, "Could not delete all media, only deleted " + i2 + " photos.");
        }
    }

    @Override // com.reactnativecommunity.cameraroll.NativeCameraRollModuleSpec
    @ReactMethod
    public void getPhotoThumbnail(String str, ReadableMap readableMap, Promise promise) {
        promise.reject("CameraRoll:getPhotoThumbnail", "getPhotoThumbnail is not supported on Android");
    }
}
