package com.ReactNativeBlobUtil;

import android.content.res.AssetManager;
import android.graphics.Color;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import androidx.webkit.internal.AssetHelper;
import androidx.work.Data;
import ch.qos.logback.core.pattern.parser.Parser;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.transistorsoft.tsbackgroundfetch.BackgroundFetchConfig;
import io.sentry.instrumentation.file.SentryFileInputStream;
import io.sentry.instrumentation.file.SentryFileOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import o.ArtificialStackFrames;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;

/* JADX INFO: loaded from: classes4.dex */
class ReactNativeBlobUtilBody extends RequestBody {
    private static int artificialFrame = 1;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME;
    private File bodyCache;
    private ReadableArray form;
    private String mTaskId;
    private MediaType mime;
    private String rawBody;
    private ReactNativeBlobUtilReq.RequestType requestType;
    private long contentLength = 0;
    int reported = 0;
    private Boolean chunkedEncoding = Boolean.FALSE;

    ReactNativeBlobUtilBody(String str) {
        this.mTaskId = str;
    }

    ReactNativeBlobUtilBody chunkedEncoding(boolean z) {
        this.chunkedEncoding = Boolean.valueOf(z);
        return this;
    }

    ReactNativeBlobUtilBody setMIME(MediaType mediaType) {
        this.mime = mediaType;
        return this;
    }

    ReactNativeBlobUtilBody setRequestType(ReactNativeBlobUtilReq.RequestType requestType) {
        this.requestType = requestType;
        return this;
    }

    ReactNativeBlobUtilBody setBody(String str) {
        this.rawBody = str;
        if (str == null) {
            this.rawBody = "";
            this.requestType = ReactNativeBlobUtilReq.RequestType.AsIs;
        }
        try {
            int i = AnonymousClass1.$SwitchMap$com$ReactNativeBlobUtil$ReactNativeBlobUtilReq$RequestType[this.requestType.ordinal()];
            if (i == 1) {
                this.contentLength = getRequestStream().available();
            } else if (i == 2) {
                this.contentLength = this.rawBody.getBytes().length;
            }
        } catch (Exception e) {
            e.printStackTrace();
            ReactNativeBlobUtilUtils.emitWarningEvent("ReactNativeBlobUtil failed to create single content request body :" + e.getLocalizedMessage() + "\r\n");
        }
        return this;
    }

    /* JADX INFO: renamed from: com.ReactNativeBlobUtil.ReactNativeBlobUtilBody$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ReactNativeBlobUtil$ReactNativeBlobUtilReq$RequestType;

        static {
            int[] iArr = new int[ReactNativeBlobUtilReq.RequestType.values().length];
            $SwitchMap$com$ReactNativeBlobUtil$ReactNativeBlobUtilReq$RequestType = iArr;
            try {
                iArr[ReactNativeBlobUtilReq.RequestType.SingleFile.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ReactNativeBlobUtil$ReactNativeBlobUtilReq$RequestType[ReactNativeBlobUtilReq.RequestType.AsIs.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ReactNativeBlobUtil$ReactNativeBlobUtilReq$RequestType[ReactNativeBlobUtilReq.RequestType.Others.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    ReactNativeBlobUtilBody setBody(ReadableArray readableArray) throws Throwable {
        this.form = readableArray;
        try {
            File fileCreateMultipartBodyCache = createMultipartBodyCache();
            this.bodyCache = fileCreateMultipartBodyCache;
            this.contentLength = fileCreateMultipartBodyCache.length();
        } catch (Exception e) {
            e.printStackTrace();
            ReactNativeBlobUtilUtils.emitWarningEvent("ReactNativeBlobUtil failed to create request multipart body :" + e.getLocalizedMessage());
        }
        return this;
    }

    InputStream getInputStreamForRequestBody() {
        try {
            if (this.form != null) {
                File file = this.bodyCache;
                return SentryFileInputStream.Factory.create(new FileInputStream(file), file);
            }
            int i = AnonymousClass1.$SwitchMap$com$ReactNativeBlobUtil$ReactNativeBlobUtilReq$RequestType[this.requestType.ordinal()];
            if (i == 1) {
                return getRequestStream();
            }
            if (i == 2) {
                return new ByteArrayInputStream(this.rawBody.getBytes());
            }
            if (i != 3) {
                return null;
            }
            ReactNativeBlobUtilUtils.emitWarningEvent("ReactNativeBlobUtil could not create input stream for request type others");
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            ReactNativeBlobUtilUtils.emitWarningEvent("ReactNativeBlobUtil failed to create input stream for request:" + e.getLocalizedMessage());
            return null;
        }
    }

    @Override // okhttp3.RequestBody
    public long contentLength() {
        if (this.chunkedEncoding.booleanValue()) {
            return -1L;
        }
        return this.contentLength;
    }

    @Override // okhttp3.RequestBody
    public MediaType contentType() {
        return this.mime;
    }

    @Override // okhttp3.RequestBody
    public void writeTo(@NonNull BufferedSink bufferedSink) {
        try {
            pipeStreamToSink(getInputStreamForRequestBody(), bufferedSink);
        } catch (Exception e) {
            ReactNativeBlobUtilUtils.emitWarningEvent(e.getLocalizedMessage());
            e.printStackTrace();
        }
    }

    boolean clearRequestBody() {
        try {
            File file = this.bodyCache;
            if (file == null || !file.exists()) {
                return true;
            }
            this.bodyCache.delete();
            return true;
        } catch (Exception e) {
            ReactNativeBlobUtilUtils.emitWarningEvent(e.getLocalizedMessage());
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x011c, code lost:
    
        if (com.ReactNativeBlobUtil.ReactNativeBlobUtilUtils.isAsset(r0) != false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0141, code lost:
    
        if (com.ReactNativeBlobUtil.ReactNativeBlobUtilUtils.isAsset(r0) != false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0169, code lost:
    
        r0 = new java.lang.Object[]{com.ReactNativeBlobUtil.ReactNativeBlobUtilImpl.RCTContext.getAssets(), (java.lang.String) java.lang.String.class.getMethod(ch.qos.logback.core.pattern.parser.Parser.REPLACE_CONVERTER_WORD, java.lang.CharSequence.class, java.lang.CharSequence.class).invoke(r0, com.ReactNativeBlobUtil.ReactNativeBlobUtilConst.FILE_PREFIX_BUNDLE_ASSET, "")};
        r3 = o.ArtificialStackFrames.accessartificialFrame(-982065286);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0174, code lost:
    
        if (r3 != null) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0176, code lost:
    
        r3 = o.ArtificialStackFrames.coroutineCreation(13 - (android.os.SystemClock.elapsedRealtimeNanos() > 0 ? 1 : (android.os.SystemClock.elapsedRealtimeNanos() == 0 ? 0 : -1)), (char) (7116 - (android.view.ViewConfiguration.getEdgeSlop() >> 16)), (android.media.AudioTrack.getMaxVolume() > 0.0f ? 1 : (android.media.AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 36, 1511233906, false, "accessartificialFrame", new java.lang.Class[]{android.content.res.AssetManager.class, java.lang.String.class});
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x01b0, code lost:
    
        return (java.io.InputStream) ((java.lang.reflect.Method) r3).invoke(null, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x01b1, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x01b2, code lost:
    
        r2 = r0.getCause();
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x01b6, code lost:
    
        if (r2 != null) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x01b8, code lost:
    
        throw r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x01b9, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x01ba, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x01bb, code lost:
    
        r2 = r0.getCause();
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x01bf, code lost:
    
        if (r2 != null) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x01c1, code lost:
    
        throw r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x01c2, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x01c3, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x01de, code lost:
    
        throw new java.lang.Exception("error when getting request stream from asset : " + r0.getLocalizedMessage());
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x01df, code lost:
    
        r2 = new java.io.File(com.ReactNativeBlobUtil.ReactNativeBlobUtilUtils.normalizePath(r0));
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x01ec, code lost:
    
        if (r2.exists() != false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x01ee, code lost:
    
        r2.createNewFile();
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x01fa, code lost:
    
        return io.sentry.instrumentation.file.SentryFileInputStream.Factory.create(new java.io.FileInputStream(r2), r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x01fb, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0214, code lost:
    
        throw new java.lang.Exception("error when getting request stream: " + r0.getLocalizedMessage());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.io.InputStream getRequestStream() throws java.lang.Exception {
        /*
            Method dump skipped, instruction units count: 543
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ReactNativeBlobUtil.ReactNativeBlobUtilBody.getRequestStream():java.io.InputStream");
    }

    /* JADX WARN: Code duplicated, block: B:118:0x006e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:119:0x0364 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:124:0x0039 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:16:0x0092  */
    /* JADX WARN: Code duplicated, block: B:20:0x00ed A[Catch: all -> 0x03a5, TRY_ENTER, TryCatch #2 {all -> 0x03a5, blocks: (B:17:0x00c8, B:20:0x00ed, B:52:0x01d0, B:91:0x034e, B:93:0x0364, B:56:0x01f6, B:27:0x012c, B:30:0x0154, B:23:0x010b, B:85:0x0321, B:87:0x0333, B:97:0x038e), top: B:109:0x00c8 }] */
    /* JADX WARN: Code duplicated, block: B:22:0x0109  */
    /* JADX WARN: Code duplicated, block: B:23:0x010b A[Catch: all -> 0x03a5, TRY_LEAVE, TryCatch #2 {all -> 0x03a5, blocks: (B:17:0x00c8, B:20:0x00ed, B:52:0x01d0, B:91:0x034e, B:93:0x0364, B:56:0x01f6, B:27:0x012c, B:30:0x0154, B:23:0x010b, B:85:0x0321, B:87:0x0333, B:97:0x038e), top: B:109:0x00c8 }] */
    /* JADX WARN: Code duplicated, block: B:26:0x012a  */
    /* JADX WARN: Code duplicated, block: B:29:0x014a  */
    /* JADX WARN: Code duplicated, block: B:43:0x01ab A[PHI: r8
  0x01ab: PHI (r8v17 java.io.InputStream) = (r8v16 java.io.InputStream), (r8v19 java.io.InputStream) binds: [B:42:0x01a9, B:33:0x0181] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:49:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:50:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:52:0x01d0 A[Catch: all -> 0x03a5, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x03a5, blocks: (B:17:0x00c8, B:20:0x00ed, B:52:0x01d0, B:91:0x034e, B:93:0x0364, B:56:0x01f6, B:27:0x012c, B:30:0x0154, B:23:0x010b, B:85:0x0321, B:87:0x0333, B:97:0x038e), top: B:109:0x00c8 }] */
    /* JADX WARN: Code duplicated, block: B:56:0x01f6 A[Catch: all -> 0x03a5, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x03a5, blocks: (B:17:0x00c8, B:20:0x00ed, B:52:0x01d0, B:91:0x034e, B:93:0x0364, B:56:0x01f6, B:27:0x012c, B:30:0x0154, B:23:0x010b, B:85:0x0321, B:87:0x0333, B:97:0x038e), top: B:109:0x00c8 }] */
    /* JADX WARN: Code duplicated, block: B:59:0x021b A[PHI: r0
  0x021b: PHI (r0v72 java.lang.String) = (r0v71 java.lang.String), (r0v93 java.lang.String) binds: [B:58:0x0219, B:54:0x01f3] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:65:0x024d A[Catch: all -> 0x028c, TryCatch #6 {all -> 0x028c, blocks: (B:63:0x0240, B:65:0x024d, B:66:0x027e), top: B:110:0x0240, outer: #7 }] */
    /* JADX WARN: Code duplicated, block: B:80:0x02bf A[PHI: r0
  0x02bf: PHI (r0v85 java.lang.String) = (r0v71 java.lang.String), (r0v93 java.lang.String) binds: [B:58:0x0219, B:54:0x01f3] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:82:0x02ce  */
    /* JADX WARN: Code duplicated, block: B:83:0x02db  */
    /* JADX WARN: Code duplicated, block: B:84:0x02f5  */
    /* JADX WARN: Code duplicated, block: B:91:0x034e A[Catch: all -> 0x03a5, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x03a5, blocks: (B:17:0x00c8, B:20:0x00ed, B:52:0x01d0, B:91:0x034e, B:93:0x0364, B:56:0x01f6, B:27:0x012c, B:30:0x0154, B:23:0x010b, B:85:0x0321, B:87:0x0333, B:97:0x038e), top: B:109:0x00c8 }] */
    /* JADX WARN: Instruction removed from duplicated block: B:16:0x0092, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:83:0x02db, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:84:0x02f5, please report this as an issue */
    private File createMultipartBodyCache() throws Throwable {
        FormField next;
        String str;
        String str2;
        String str3;
        Iterator<FormField> it2;
        File file;
        int i;
        int i2;
        String str4;
        InputStream inputStream;
        InputStream inputStreamOpenInputStream;
        int i3;
        String strNormalizePath;
        String str5;
        Object objAccessartificialFrame;
        File file2;
        Object[] objArr;
        Class[] clsArr;
        int i4 = 2;
        int i5 = 2 % 2;
        String str6 = "ReactNativeBlobUtil-" + this.mTaskId;
        File fileCreateTempFile = File.createTempFile("rnfb-form-tmp", "", ReactNativeBlobUtilImpl.RCTContext.getCacheDir());
        FileOutputStream fileOutputStreamCreate = SentryFileOutputStream.Factory.create(new FileOutputStream(fileCreateTempFile), fileCreateTempFile);
        ArrayList<FormField> arrayListCountFormDataLength = countFormDataLength();
        ReactApplicationContext reactApplicationContext = ReactNativeBlobUtilImpl.RCTContext;
        Iterator<FormField> it3 = arrayListCountFormDataLength.iterator();
        while (it3.hasNext()) {
            int i6 = getARTIFICIAL_FRAME_PACKAGE_NAME + 35;
            artificialFrame = i6 % 128;
            if (i6 % i4 == 0) {
                next = it3.next();
                str = next.data;
                str2 = next.name;
                int i7 = 97 / 0;
                if (str2 == null) {
                    continue;
                } else if (str == null) {
                    continue;
                } else {
                    str3 = "--" + str6 + "\r\n";
                    it2 = it3;
                    file = fileCreateTempFile;
                    if (next.filename != null) {
                        try {
                            fileOutputStreamCreate.write((byte[]) String.class.getMethod("getBytes", null).invoke((str3 + "Content-Disposition: form-data; name=\"" + str2 + "\"; filename=\"" + next.filename + "\"\r\n") + "Content-Type: " + next.mime + "\r\n\r\n", null));
                            i2 = getARTIFICIAL_FRAME_PACKAGE_NAME + 17;
                            artificialFrame = i2 % 128;
                            if (i2 % 2 == 0) {
                                objArr = new Object[1];
                                objArr[1] = ReactNativeBlobUtilConst.FILE_PREFIX;
                                clsArr = new Class[1];
                                clsArr[1] = String.class;
                                if (((Boolean) String.class.getMethod("startsWith", clsArr).invoke(str, objArr)).booleanValue()) {
                                    i3 = artificialFrame + 123;
                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i3 % 128;
                                    if (i3 % 2 != 0) {
                                        Object[] objArr2 = new Object[1];
                                        objArr2[1] = 27;
                                        strNormalizePath = ReactNativeBlobUtilUtils.normalizePath((String) String.class.getMethod("substring", Integer.TYPE).invoke(str, objArr2));
                                        if (ReactNativeBlobUtilUtils.isAsset(strNormalizePath)) {
                                            str5 = strNormalizePath;
                                            try {
                                                try {
                                                    try {
                                                        Object[] objArr3 = {reactApplicationContext.getAssets(), (String) String.class.getMethod(Parser.REPLACE_CONVERTER_WORD, CharSequence.class, CharSequence.class).invoke(str5, ReactNativeBlobUtilConst.FILE_PREFIX_BUNDLE_ASSET, "")};
                                                        objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-982065286);
                                                        if (objAccessartificialFrame == null) {
                                                            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(12 - View.getDefaultSize(0, 0), (char) (7116 - Color.alpha(0)), 36 - TextUtils.lastIndexOf("", '0', 0, 0), 1511233906, false, "accessartificialFrame", new Class[]{AssetManager.class, String.class});
                                                        }
                                                        pipeStreamToFileStream((InputStream) ((Method) objAccessartificialFrame).invoke(null, objArr3), fileOutputStreamCreate);
                                                    } catch (Throwable th) {
                                                        Throwable cause = th.getCause();
                                                        if (cause != null) {
                                                            throw cause;
                                                        }
                                                        throw th;
                                                    }
                                                } catch (IOException e) {
                                                    ReactNativeBlobUtilUtils.emitWarningEvent("Failed to create form data asset :" + str5 + ", " + e.getLocalizedMessage());
                                                }
                                            } catch (Throwable th2) {
                                                Throwable cause2 = th2.getCause();
                                                if (cause2 != null) {
                                                    throw cause2;
                                                }
                                                throw th2;
                                            }
                                        } else {
                                            file2 = new File(ReactNativeBlobUtilUtils.normalizePath(strNormalizePath));
                                            if (file2.exists()) {
                                                pipeStreamToFileStream(SentryFileInputStream.Factory.create(new FileInputStream(file2), file2), fileOutputStreamCreate);
                                            } else {
                                                ReactNativeBlobUtilUtils.emitWarningEvent("Failed to create form data from path :" + strNormalizePath + ", file not exists.");
                                            }
                                        }
                                    } else {
                                        strNormalizePath = ReactNativeBlobUtilUtils.normalizePath((String) String.class.getMethod("substring", Integer.TYPE).invoke(str, 27));
                                        if (ReactNativeBlobUtilUtils.isAsset(strNormalizePath)) {
                                            str5 = strNormalizePath;
                                            Object[] objArr4 = {reactApplicationContext.getAssets(), (String) String.class.getMethod(Parser.REPLACE_CONVERTER_WORD, CharSequence.class, CharSequence.class).invoke(str5, ReactNativeBlobUtilConst.FILE_PREFIX_BUNDLE_ASSET, "")};
                                            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-982065286);
                                            if (objAccessartificialFrame == null) {
                                                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(12 - View.getDefaultSize(0, 0), (char) (7116 - Color.alpha(0)), 36 - TextUtils.lastIndexOf("", '0', 0, 0), 1511233906, false, "accessartificialFrame", new Class[]{AssetManager.class, String.class});
                                            }
                                            pipeStreamToFileStream((InputStream) ((Method) objAccessartificialFrame).invoke(null, objArr4), fileOutputStreamCreate);
                                        } else {
                                            file2 = new File(ReactNativeBlobUtilUtils.normalizePath(strNormalizePath));
                                            if (file2.exists()) {
                                                pipeStreamToFileStream(SentryFileInputStream.Factory.create(new FileInputStream(file2), file2), fileOutputStreamCreate);
                                            } else {
                                                ReactNativeBlobUtilUtils.emitWarningEvent("Failed to create form data from path :" + strNormalizePath + ", file not exists.");
                                            }
                                        }
                                    }
                                } else if (((Boolean) String.class.getMethod("startsWith", String.class).invoke(str, ReactNativeBlobUtilConst.CONTENT_PREFIX)).booleanValue()) {
                                    int i8 = artificialFrame + 125;
                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i8 % 128;
                                    int i9 = i8 % 2;
                                    str4 = (String) String.class.getMethod("substring", Integer.TYPE).invoke(str, 30);
                                    try {
                                        inputStreamOpenInputStream = reactApplicationContext.getContentResolver().openInputStream(Uri.parse(str4));
                                        try {
                                            try {
                                                pipeStreamToFileStream(inputStreamOpenInputStream, fileOutputStreamCreate);
                                                if (inputStreamOpenInputStream != null) {
                                                    inputStreamOpenInputStream.close();
                                                }
                                            } catch (Exception e2) {
                                                e = e2;
                                                ReactNativeBlobUtilUtils.emitWarningEvent("Failed to create form data from content URI:" + str4 + ", " + e.getLocalizedMessage());
                                                if (inputStreamOpenInputStream != null) {
                                                    inputStreamOpenInputStream.close();
                                                }
                                            }
                                        } catch (Throwable th3) {
                                            th = th3;
                                            inputStream = inputStreamOpenInputStream;
                                            if (inputStream != null) {
                                                inputStream.close();
                                            }
                                            throw th;
                                        }
                                    } catch (Exception e3) {
                                        e = e3;
                                        inputStreamOpenInputStream = null;
                                    } catch (Throwable th4) {
                                        th = th4;
                                        inputStream = null;
                                    }
                                } else {
                                    fileOutputStreamCreate.write(Base64.decode(str, 0));
                                }
                            } else if (!((Boolean) String.class.getMethod("startsWith", String.class).invoke(str, ReactNativeBlobUtilConst.FILE_PREFIX)).booleanValue()) {
                                i3 = artificialFrame + 123;
                                getARTIFICIAL_FRAME_PACKAGE_NAME = i3 % 128;
                                if (i3 % 2 != 0) {
                                    Object[] objArr5 = new Object[1];
                                    objArr5[1] = 27;
                                    strNormalizePath = ReactNativeBlobUtilUtils.normalizePath((String) String.class.getMethod("substring", Integer.TYPE).invoke(str, objArr5));
                                    if (ReactNativeBlobUtilUtils.isAsset(strNormalizePath)) {
                                        str5 = strNormalizePath;
                                        Object[] objArr6 = {reactApplicationContext.getAssets(), (String) String.class.getMethod(Parser.REPLACE_CONVERTER_WORD, CharSequence.class, CharSequence.class).invoke(str5, ReactNativeBlobUtilConst.FILE_PREFIX_BUNDLE_ASSET, "")};
                                        objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-982065286);
                                        if (objAccessartificialFrame == null) {
                                            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(12 - View.getDefaultSize(0, 0), (char) (7116 - Color.alpha(0)), 36 - TextUtils.lastIndexOf("", '0', 0, 0), 1511233906, false, "accessartificialFrame", new Class[]{AssetManager.class, String.class});
                                        }
                                        pipeStreamToFileStream((InputStream) ((Method) objAccessartificialFrame).invoke(null, objArr6), fileOutputStreamCreate);
                                    } else {
                                        file2 = new File(ReactNativeBlobUtilUtils.normalizePath(strNormalizePath));
                                        if (file2.exists()) {
                                            pipeStreamToFileStream(SentryFileInputStream.Factory.create(new FileInputStream(file2), file2), fileOutputStreamCreate);
                                        } else {
                                            ReactNativeBlobUtilUtils.emitWarningEvent("Failed to create form data from path :" + strNormalizePath + ", file not exists.");
                                        }
                                    }
                                } else {
                                    strNormalizePath = ReactNativeBlobUtilUtils.normalizePath((String) String.class.getMethod("substring", Integer.TYPE).invoke(str, 27));
                                    if (ReactNativeBlobUtilUtils.isAsset(strNormalizePath)) {
                                        str5 = strNormalizePath;
                                        Object[] objArr7 = {reactApplicationContext.getAssets(), (String) String.class.getMethod(Parser.REPLACE_CONVERTER_WORD, CharSequence.class, CharSequence.class).invoke(str5, ReactNativeBlobUtilConst.FILE_PREFIX_BUNDLE_ASSET, "")};
                                        objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-982065286);
                                        if (objAccessartificialFrame == null) {
                                            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(12 - View.getDefaultSize(0, 0), (char) (7116 - Color.alpha(0)), 36 - TextUtils.lastIndexOf("", '0', 0, 0), 1511233906, false, "accessartificialFrame", new Class[]{AssetManager.class, String.class});
                                        }
                                        pipeStreamToFileStream((InputStream) ((Method) objAccessartificialFrame).invoke(null, objArr7), fileOutputStreamCreate);
                                    } else {
                                        file2 = new File(ReactNativeBlobUtilUtils.normalizePath(strNormalizePath));
                                        if (file2.exists()) {
                                            pipeStreamToFileStream(SentryFileInputStream.Factory.create(new FileInputStream(file2), file2), fileOutputStreamCreate);
                                        } else {
                                            ReactNativeBlobUtilUtils.emitWarningEvent("Failed to create form data from path :" + strNormalizePath + ", file not exists.");
                                        }
                                    }
                                }
                            } else if (((Boolean) String.class.getMethod("startsWith", String.class).invoke(str, ReactNativeBlobUtilConst.CONTENT_PREFIX)).booleanValue()) {
                                int i10 = artificialFrame + 125;
                                getARTIFICIAL_FRAME_PACKAGE_NAME = i10 % 128;
                                int i11 = i10 % 2;
                                str4 = (String) String.class.getMethod("substring", Integer.TYPE).invoke(str, 30);
                                inputStreamOpenInputStream = reactApplicationContext.getContentResolver().openInputStream(Uri.parse(str4));
                                pipeStreamToFileStream(inputStreamOpenInputStream, fileOutputStreamCreate);
                                if (inputStreamOpenInputStream != null) {
                                    inputStreamOpenInputStream.close();
                                }
                            } else {
                                fileOutputStreamCreate.write(Base64.decode(str, 0));
                            }
                        } catch (Throwable th5) {
                            Throwable cause3 = th5.getCause();
                            if (cause3 != null) {
                                throw cause3;
                            }
                            throw th5;
                        }
                    } else {
                        fileOutputStreamCreate.write((byte[]) String.class.getMethod("getBytes", null).invoke((str3 + "Content-Disposition: form-data; name=\"" + str2 + "\"\r\n") + "Content-Type: " + next.mime + "\r\n\r\n", null));
                        fileOutputStreamCreate.write((byte[]) String.class.getMethod("getBytes", null).invoke(next.data, null));
                    }
                    i = getARTIFICIAL_FRAME_PACKAGE_NAME + 35;
                    artificialFrame = i % 128;
                    i4 = 2;
                    if (i % 2 != 0) {
                        Object obj = null;
                        fileOutputStreamCreate.write((byte[]) String.class.getMethod("getBytes", null).invoke("\r\n", null));
                        obj.hashCode();
                        throw null;
                    }
                    fileOutputStreamCreate.write((byte[]) String.class.getMethod("getBytes", null).invoke("\r\n", null));
                    it3 = it2;
                    fileCreateTempFile = file;
                }
            } else {
                next = it3.next();
                str = next.data;
                str2 = next.name;
                if (str2 == null) {
                    continue;
                } else if (str == null) {
                    continue;
                } else {
                    str3 = "--" + str6 + "\r\n";
                    it2 = it3;
                    file = fileCreateTempFile;
                    if (next.filename != null) {
                        fileOutputStreamCreate.write((byte[]) String.class.getMethod("getBytes", null).invoke((str3 + "Content-Disposition: form-data; name=\"" + str2 + "\"; filename=\"" + next.filename + "\"\r\n") + "Content-Type: " + next.mime + "\r\n\r\n", null));
                        i2 = getARTIFICIAL_FRAME_PACKAGE_NAME + 17;
                        artificialFrame = i2 % 128;
                        if (i2 % 2 == 0) {
                            objArr = new Object[1];
                            objArr[1] = ReactNativeBlobUtilConst.FILE_PREFIX;
                            clsArr = new Class[1];
                            clsArr[1] = String.class;
                            if (((Boolean) String.class.getMethod("startsWith", clsArr).invoke(str, objArr)).booleanValue()) {
                                i3 = artificialFrame + 123;
                                getARTIFICIAL_FRAME_PACKAGE_NAME = i3 % 128;
                                if (i3 % 2 != 0) {
                                    Object[] objArr8 = new Object[1];
                                    objArr8[1] = 27;
                                    strNormalizePath = ReactNativeBlobUtilUtils.normalizePath((String) String.class.getMethod("substring", Integer.TYPE).invoke(str, objArr8));
                                    if (ReactNativeBlobUtilUtils.isAsset(strNormalizePath)) {
                                        str5 = strNormalizePath;
                                        Object[] objArr9 = {reactApplicationContext.getAssets(), (String) String.class.getMethod(Parser.REPLACE_CONVERTER_WORD, CharSequence.class, CharSequence.class).invoke(str5, ReactNativeBlobUtilConst.FILE_PREFIX_BUNDLE_ASSET, "")};
                                        objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-982065286);
                                        if (objAccessartificialFrame == null) {
                                            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(12 - View.getDefaultSize(0, 0), (char) (7116 - Color.alpha(0)), 36 - TextUtils.lastIndexOf("", '0', 0, 0), 1511233906, false, "accessartificialFrame", new Class[]{AssetManager.class, String.class});
                                        }
                                        pipeStreamToFileStream((InputStream) ((Method) objAccessartificialFrame).invoke(null, objArr9), fileOutputStreamCreate);
                                    } else {
                                        file2 = new File(ReactNativeBlobUtilUtils.normalizePath(strNormalizePath));
                                        if (file2.exists()) {
                                            pipeStreamToFileStream(SentryFileInputStream.Factory.create(new FileInputStream(file2), file2), fileOutputStreamCreate);
                                        } else {
                                            ReactNativeBlobUtilUtils.emitWarningEvent("Failed to create form data from path :" + strNormalizePath + ", file not exists.");
                                        }
                                    }
                                } else {
                                    strNormalizePath = ReactNativeBlobUtilUtils.normalizePath((String) String.class.getMethod("substring", Integer.TYPE).invoke(str, 27));
                                    if (ReactNativeBlobUtilUtils.isAsset(strNormalizePath)) {
                                        str5 = strNormalizePath;
                                        Object[] objArr10 = {reactApplicationContext.getAssets(), (String) String.class.getMethod(Parser.REPLACE_CONVERTER_WORD, CharSequence.class, CharSequence.class).invoke(str5, ReactNativeBlobUtilConst.FILE_PREFIX_BUNDLE_ASSET, "")};
                                        objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-982065286);
                                        if (objAccessartificialFrame == null) {
                                            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(12 - View.getDefaultSize(0, 0), (char) (7116 - Color.alpha(0)), 36 - TextUtils.lastIndexOf("", '0', 0, 0), 1511233906, false, "accessartificialFrame", new Class[]{AssetManager.class, String.class});
                                        }
                                        pipeStreamToFileStream((InputStream) ((Method) objAccessartificialFrame).invoke(null, objArr10), fileOutputStreamCreate);
                                    } else {
                                        file2 = new File(ReactNativeBlobUtilUtils.normalizePath(strNormalizePath));
                                        if (file2.exists()) {
                                            pipeStreamToFileStream(SentryFileInputStream.Factory.create(new FileInputStream(file2), file2), fileOutputStreamCreate);
                                        } else {
                                            ReactNativeBlobUtilUtils.emitWarningEvent("Failed to create form data from path :" + strNormalizePath + ", file not exists.");
                                        }
                                    }
                                }
                            } else if (((Boolean) String.class.getMethod("startsWith", String.class).invoke(str, ReactNativeBlobUtilConst.CONTENT_PREFIX)).booleanValue()) {
                                int i12 = artificialFrame + 125;
                                getARTIFICIAL_FRAME_PACKAGE_NAME = i12 % 128;
                                int i13 = i12 % 2;
                                str4 = (String) String.class.getMethod("substring", Integer.TYPE).invoke(str, 30);
                                inputStreamOpenInputStream = reactApplicationContext.getContentResolver().openInputStream(Uri.parse(str4));
                                pipeStreamToFileStream(inputStreamOpenInputStream, fileOutputStreamCreate);
                                if (inputStreamOpenInputStream != null) {
                                    inputStreamOpenInputStream.close();
                                }
                            } else {
                                fileOutputStreamCreate.write(Base64.decode(str, 0));
                            }
                        } else if (!((Boolean) String.class.getMethod("startsWith", String.class).invoke(str, ReactNativeBlobUtilConst.FILE_PREFIX)).booleanValue()) {
                            i3 = artificialFrame + 123;
                            getARTIFICIAL_FRAME_PACKAGE_NAME = i3 % 128;
                            if (i3 % 2 != 0) {
                                Object[] objArr11 = new Object[1];
                                objArr11[1] = 27;
                                strNormalizePath = ReactNativeBlobUtilUtils.normalizePath((String) String.class.getMethod("substring", Integer.TYPE).invoke(str, objArr11));
                                if (ReactNativeBlobUtilUtils.isAsset(strNormalizePath)) {
                                    str5 = strNormalizePath;
                                    Object[] objArr12 = {reactApplicationContext.getAssets(), (String) String.class.getMethod(Parser.REPLACE_CONVERTER_WORD, CharSequence.class, CharSequence.class).invoke(str5, ReactNativeBlobUtilConst.FILE_PREFIX_BUNDLE_ASSET, "")};
                                    objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-982065286);
                                    if (objAccessartificialFrame == null) {
                                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(12 - View.getDefaultSize(0, 0), (char) (7116 - Color.alpha(0)), 36 - TextUtils.lastIndexOf("", '0', 0, 0), 1511233906, false, "accessartificialFrame", new Class[]{AssetManager.class, String.class});
                                    }
                                    pipeStreamToFileStream((InputStream) ((Method) objAccessartificialFrame).invoke(null, objArr12), fileOutputStreamCreate);
                                } else {
                                    file2 = new File(ReactNativeBlobUtilUtils.normalizePath(strNormalizePath));
                                    if (file2.exists()) {
                                        pipeStreamToFileStream(SentryFileInputStream.Factory.create(new FileInputStream(file2), file2), fileOutputStreamCreate);
                                    } else {
                                        ReactNativeBlobUtilUtils.emitWarningEvent("Failed to create form data from path :" + strNormalizePath + ", file not exists.");
                                    }
                                }
                            } else {
                                strNormalizePath = ReactNativeBlobUtilUtils.normalizePath((String) String.class.getMethod("substring", Integer.TYPE).invoke(str, 27));
                                if (ReactNativeBlobUtilUtils.isAsset(strNormalizePath)) {
                                    str5 = strNormalizePath;
                                    Object[] objArr13 = {reactApplicationContext.getAssets(), (String) String.class.getMethod(Parser.REPLACE_CONVERTER_WORD, CharSequence.class, CharSequence.class).invoke(str5, ReactNativeBlobUtilConst.FILE_PREFIX_BUNDLE_ASSET, "")};
                                    objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-982065286);
                                    if (objAccessartificialFrame == null) {
                                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(12 - View.getDefaultSize(0, 0), (char) (7116 - Color.alpha(0)), 36 - TextUtils.lastIndexOf("", '0', 0, 0), 1511233906, false, "accessartificialFrame", new Class[]{AssetManager.class, String.class});
                                    }
                                    pipeStreamToFileStream((InputStream) ((Method) objAccessartificialFrame).invoke(null, objArr13), fileOutputStreamCreate);
                                } else {
                                    file2 = new File(ReactNativeBlobUtilUtils.normalizePath(strNormalizePath));
                                    if (file2.exists()) {
                                        pipeStreamToFileStream(SentryFileInputStream.Factory.create(new FileInputStream(file2), file2), fileOutputStreamCreate);
                                    } else {
                                        ReactNativeBlobUtilUtils.emitWarningEvent("Failed to create form data from path :" + strNormalizePath + ", file not exists.");
                                    }
                                }
                            }
                        } else if (((Boolean) String.class.getMethod("startsWith", String.class).invoke(str, ReactNativeBlobUtilConst.CONTENT_PREFIX)).booleanValue()) {
                            int i14 = artificialFrame + 125;
                            getARTIFICIAL_FRAME_PACKAGE_NAME = i14 % 128;
                            int i15 = i14 % 2;
                            str4 = (String) String.class.getMethod("substring", Integer.TYPE).invoke(str, 30);
                            inputStreamOpenInputStream = reactApplicationContext.getContentResolver().openInputStream(Uri.parse(str4));
                            pipeStreamToFileStream(inputStreamOpenInputStream, fileOutputStreamCreate);
                            if (inputStreamOpenInputStream != null) {
                                inputStreamOpenInputStream.close();
                            }
                        } else {
                            fileOutputStreamCreate.write(Base64.decode(str, 0));
                        }
                    } else {
                        fileOutputStreamCreate.write((byte[]) String.class.getMethod("getBytes", null).invoke((str3 + "Content-Disposition: form-data; name=\"" + str2 + "\"\r\n") + "Content-Type: " + next.mime + "\r\n\r\n", null));
                        fileOutputStreamCreate.write((byte[]) String.class.getMethod("getBytes", null).invoke(next.data, null));
                    }
                    i = getARTIFICIAL_FRAME_PACKAGE_NAME + 35;
                    artificialFrame = i % 128;
                    i4 = 2;
                    if (i % 2 != 0) {
                        Object obj2 = null;
                        fileOutputStreamCreate.write((byte[]) String.class.getMethod("getBytes", null).invoke("\r\n", null));
                        obj2.hashCode();
                        throw null;
                    }
                    fileOutputStreamCreate.write((byte[]) String.class.getMethod("getBytes", null).invoke("\r\n", null));
                    it3 = it2;
                    fileCreateTempFile = file;
                }
            }
        }
        File file3 = fileCreateTempFile;
        fileOutputStreamCreate.write((byte[]) String.class.getMethod("getBytes", null).invoke("--" + str6 + "--\r\n", null));
        fileOutputStreamCreate.flush();
        fileOutputStreamCreate.close();
        return file3;
    }

    private void pipeStreamToSink(InputStream inputStream, BufferedSink bufferedSink) throws IOException {
        byte[] bArr = new byte[Data.MAX_DATA_BYTES];
        long j = 0;
        while (true) {
            int i = inputStream.read(bArr, 0, Data.MAX_DATA_BYTES);
            if (i > 0) {
                bufferedSink.write(bArr, 0, i);
                j += (long) i;
                emitUploadProgress(j);
            } else {
                inputStream.close();
                return;
            }
        }
    }

    private void pipeStreamToFileStream(InputStream inputStream, FileOutputStream fileOutputStream) throws IOException {
        byte[] bArr = new byte[Data.MAX_DATA_BYTES];
        while (true) {
            int i = inputStream.read(bArr);
            if (i > 0) {
                fileOutputStream.write(bArr, 0, i);
            } else {
                inputStream.close();
                return;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:25:0x00f6 A[Catch: all -> 0x0135, TryCatch #2 {all -> 0x0135, blocks: (B:23:0x00e9, B:25:0x00f6, B:26:0x0126), top: B:84:0x00e9, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x0151  */
    /* JADX WARN: Code duplicated, block: B:41:0x0160  */
    /* JADX WARN: Code duplicated, block: B:44:0x0187 A[Catch: all -> 0x0211, TRY_LEAVE, TryCatch #0 {all -> 0x0211, blocks: (B:12:0x0068, B:17:0x00a1, B:42:0x016b, B:44:0x0187, B:15:0x0085, B:66:0x01fb), top: B:81:0x0068 }] */
    /* JADX WARN: Code duplicated, block: B:63:0x01f1  */
    /* JADX WARN: Code duplicated, block: B:65:0x01f5  */
    private ArrayList<FormField> countFormDataLength() throws Throwable {
        int length;
        long length2;
        String str;
        InputStream inputStream;
        InputStream inputStream2;
        InputStream inputStreamOpenInputStream;
        String strNormalizePath;
        Object objAccessartificialFrame;
        int i = 2 % 2;
        ArrayList<FormField> arrayList = new ArrayList<>();
        ReactApplicationContext reactApplicationContext = ReactNativeBlobUtilImpl.RCTContext;
        long jAvailable = 0;
        for (int i2 = 0; i2 < this.form.size(); i2++) {
            FormField formField = new FormField(this.form.getMap(i2));
            arrayList.add(formField);
            String str2 = formField.data;
            if (str2 == null) {
                ReactNativeBlobUtilUtils.emitWarningEvent("ReactNativeBlobUtil multipart request builder has found a field without `data` property, the field `" + formField.name + "` will be removed implicitly.");
                int i3 = getARTIFICIAL_FRAME_PACKAGE_NAME + 17;
                artificialFrame = i3 % 128;
                int i4 = i3 % 2;
            } else {
                if (formField.filename != null) {
                    int i5 = getARTIFICIAL_FRAME_PACKAGE_NAME + 77;
                    artificialFrame = i5 % 128;
                    if (i5 % 2 == 0) {
                        try {
                            Object[] objArr = new Object[1];
                            objArr[1] = ReactNativeBlobUtilConst.FILE_PREFIX;
                            Class[] clsArr = new Class[0];
                            clsArr[1] = String.class;
                            if (((Boolean) String.class.getMethod("startsWith", clsArr).invoke(str2, objArr)).booleanValue()) {
                                strNormalizePath = ReactNativeBlobUtilUtils.normalizePath((String) String.class.getMethod("substring", Integer.TYPE).invoke(str2, 27));
                                if (ReactNativeBlobUtilUtils.isAsset(strNormalizePath)) {
                                    try {
                                        try {
                                            try {
                                                Object[] objArr2 = {reactApplicationContext.getAssets(), (String) String.class.getMethod(Parser.REPLACE_CONVERTER_WORD, CharSequence.class, CharSequence.class).invoke(strNormalizePath, ReactNativeBlobUtilConst.FILE_PREFIX_BUNDLE_ASSET, "")};
                                                objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-982065286);
                                                if (objAccessartificialFrame == null) {
                                                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(11 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (char) (View.resolveSizeAndState(0, 0, 0) + 7116), 37 - (ViewConfiguration.getScrollBarSize() >> 8), 1511233906, false, "accessartificialFrame", new Class[]{AssetManager.class, String.class});
                                                }
                                                length = ((InputStream) ((Method) objAccessartificialFrame).invoke(null, objArr2)).available();
                                            } catch (Throwable th) {
                                                Throwable cause = th.getCause();
                                                if (cause != null) {
                                                    throw cause;
                                                }
                                                throw th;
                                            }
                                        } catch (IOException e) {
                                            ReactNativeBlobUtilUtils.emitWarningEvent(e.getLocalizedMessage());
                                        }
                                    } catch (Throwable th2) {
                                        Throwable cause2 = th2.getCause();
                                        if (cause2 != null) {
                                            throw cause2;
                                        }
                                        throw th2;
                                    }
                                } else {
                                    length2 = new File(ReactNativeBlobUtilUtils.normalizePath(strNormalizePath)).length();
                                    jAvailable += length2;
                                }
                            } else {
                                int i6 = artificialFrame + 25;
                                getARTIFICIAL_FRAME_PACKAGE_NAME = i6 % 128;
                                int i7 = i6 % 2;
                                if (((Boolean) String.class.getMethod("startsWith", String.class).invoke(str2, ReactNativeBlobUtilConst.CONTENT_PREFIX)).booleanValue()) {
                                    str = (String) String.class.getMethod("substring", Integer.TYPE).invoke(str2, 30);
                                    try {
                                        inputStreamOpenInputStream = reactApplicationContext.getContentResolver().openInputStream(Uri.parse(str));
                                        try {
                                            jAvailable += (long) inputStreamOpenInputStream.available();
                                        } catch (Exception e2) {
                                            e = e2;
                                            inputStream2 = inputStreamOpenInputStream;
                                            try {
                                                ReactNativeBlobUtilUtils.emitWarningEvent("Failed to estimate form data length from content URI:" + str + ", " + e.getLocalizedMessage());
                                                if (inputStream2 != null) {
                                                    inputStreamOpenInputStream = inputStream2;
                                                }
                                            } catch (Throwable th3) {
                                                th = th3;
                                                inputStream = inputStream2;
                                                if (inputStream != null) {
                                                    inputStream.close();
                                                }
                                                throw th;
                                            }
                                        } catch (Throwable th4) {
                                            th = th4;
                                            inputStream = inputStreamOpenInputStream;
                                            if (inputStream != null) {
                                                inputStream.close();
                                            }
                                            throw th;
                                        }
                                    } catch (Exception e3) {
                                        e = e3;
                                        inputStream2 = null;
                                    } catch (Throwable th5) {
                                        th = th5;
                                        inputStream = null;
                                    }
                                    inputStreamOpenInputStream.close();
                                } else {
                                    length = Base64.decode(str2, 0).length;
                                }
                            }
                        } catch (Throwable th6) {
                            Throwable cause3 = th6.getCause();
                            if (cause3 != null) {
                                throw cause3;
                            }
                            throw th6;
                        }
                    } else if (((Boolean) String.class.getMethod("startsWith", String.class).invoke(str2, ReactNativeBlobUtilConst.FILE_PREFIX)).booleanValue()) {
                        strNormalizePath = ReactNativeBlobUtilUtils.normalizePath((String) String.class.getMethod("substring", Integer.TYPE).invoke(str2, 27));
                        if (ReactNativeBlobUtilUtils.isAsset(strNormalizePath)) {
                            Object[] objArr3 = {reactApplicationContext.getAssets(), (String) String.class.getMethod(Parser.REPLACE_CONVERTER_WORD, CharSequence.class, CharSequence.class).invoke(strNormalizePath, ReactNativeBlobUtilConst.FILE_PREFIX_BUNDLE_ASSET, "")};
                            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-982065286);
                            if (objAccessartificialFrame == null) {
                                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(11 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (char) (View.resolveSizeAndState(0, 0, 0) + 7116), 37 - (ViewConfiguration.getScrollBarSize() >> 8), 1511233906, false, "accessartificialFrame", new Class[]{AssetManager.class, String.class});
                            }
                            length = ((InputStream) ((Method) objAccessartificialFrame).invoke(null, objArr3)).available();
                        } else {
                            length2 = new File(ReactNativeBlobUtilUtils.normalizePath(strNormalizePath)).length();
                            jAvailable += length2;
                        }
                    } else {
                        int i8 = artificialFrame + 25;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i8 % 128;
                        int i9 = i8 % 2;
                        if (((Boolean) String.class.getMethod("startsWith", String.class).invoke(str2, ReactNativeBlobUtilConst.CONTENT_PREFIX)).booleanValue()) {
                            str = (String) String.class.getMethod("substring", Integer.TYPE).invoke(str2, 30);
                            inputStreamOpenInputStream = reactApplicationContext.getContentResolver().openInputStream(Uri.parse(str));
                            jAvailable += (long) inputStreamOpenInputStream.available();
                            inputStreamOpenInputStream.close();
                        } else {
                            length = Base64.decode(str2, 0).length;
                        }
                    }
                } else {
                    length = ((byte[]) String.class.getMethod("getBytes", null).invoke(str2, null)).length;
                }
                length2 = length;
                jAvailable += length2;
            }
        }
        this.contentLength = jAvailable;
        int i10 = artificialFrame + 17;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i10 % 128;
        if (i10 % 2 == 0) {
            return arrayList;
        }
        Object obj = null;
        obj.hashCode();
        throw null;
    }

    class FormField {
        public String data;
        String filename;
        String mime;
        public String name;

        FormField(ReadableMap readableMap) {
            if (readableMap.hasKey("name")) {
                this.name = readableMap.getString("name");
            }
            if (readableMap.hasKey("filename")) {
                this.filename = readableMap.getString("filename");
            }
            if (readableMap.hasKey("type")) {
                this.mime = readableMap.getString("type");
            } else {
                this.mime = this.filename == null ? AssetHelper.DEFAULT_MIME_TYPE : "application/octet-stream";
            }
            if (readableMap.hasKey("data")) {
                this.data = readableMap.getString("data");
            }
        }
    }

    private void emitUploadProgress(long j) {
        ReactNativeBlobUtilProgressConfig reportUploadProgress = ReactNativeBlobUtilReq.getReportUploadProgress(this.mTaskId);
        if (reportUploadProgress != null) {
            long j2 = this.contentLength;
            if (j2 == 0 || !reportUploadProgress.shouldReport(j / j2)) {
                return;
            }
            WritableMap writableMapCreateMap = Arguments.createMap();
            writableMapCreateMap.putString(BackgroundFetchConfig.FIELD_TASK_ID, this.mTaskId);
            writableMapCreateMap.putString("written", String.valueOf(j));
            writableMapCreateMap.putString("total", String.valueOf(this.contentLength));
            ((DeviceEventManagerModule.RCTDeviceEventEmitter) ReactNativeBlobUtilImpl.RCTContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(ReactNativeBlobUtilConst.EVENT_UPLOAD_PROGRESS, writableMapCreateMap);
        }
    }
}
