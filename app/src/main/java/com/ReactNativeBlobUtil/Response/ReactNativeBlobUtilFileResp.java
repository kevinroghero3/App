package com.ReactNativeBlobUtil.Response;

import androidx.annotation.NonNull;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilProgressConfig;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilReq;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.transistorsoft.tsbackgroundfetch.BackgroundFetchConfig;
import io.sentry.instrumentation.file.SentryFileOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;
import okio.Timeout;

/* JADX INFO: loaded from: classes4.dex */
public class ReactNativeBlobUtilFileResp extends ResponseBody {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    long bytesDownloaded;
    boolean isEndMarkerReceived;
    String mPath;
    String mTaskId;
    FileOutputStream ofStream;
    ResponseBody originalBody;
    ReactApplicationContext rctContext;

    public ReactNativeBlobUtilFileResp(ResponseBody responseBody) {
        this.bytesDownloaded = 0L;
        this.originalBody = responseBody;
    }

    public ReactNativeBlobUtilFileResp(ReactApplicationContext reactApplicationContext, String str, ResponseBody responseBody, String str2, boolean z) throws IOException {
        this.bytesDownloaded = 0L;
        this.rctContext = reactApplicationContext;
        this.mTaskId = str;
        this.originalBody = responseBody;
        this.mPath = str2;
        this.isEndMarkerReceived = false;
        if (str2 != null) {
            boolean z2 = !z;
            String strReplace = str2.replace("?append=true", "");
            this.mPath = strReplace;
            File file = new File(strReplace);
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
                throw new IllegalStateException("Couldn't create dir: " + parentFile);
            }
            if (!file.exists()) {
                file.createNewFile();
            }
            File file2 = new File(strReplace);
            this.ofStream = SentryFileOutputStream.Factory.create(new FileOutputStream(file2, z2), file2, z2);
        }
    }

    @Override // okhttp3.ResponseBody
    public MediaType contentType() {
        return this.originalBody.contentType();
    }

    @Override // okhttp3.ResponseBody
    public long contentLength() {
        if (this.originalBody.contentLength() > 2147483647L) {
            return 2147483647L;
        }
        return this.originalBody.contentLength();
    }

    public boolean isDownloadComplete() {
        return this.bytesDownloaded == contentLength() || (contentLength() == -1 && this.isEndMarkerReceived);
    }

    @Override // okhttp3.ResponseBody
    public BufferedSource source() {
        return Okio.buffer(new ProgressReportingSource());
    }

    class ProgressReportingSource implements Source {
        @Override // okio.Source
        public Timeout timeout() {
            return null;
        }

        private ProgressReportingSource() {
        }

        @Override // okio.Source
        public long read(@NonNull Buffer buffer, long j) throws IOException {
            float fContentLength;
            int i = (int) j;
            try {
                byte[] bArr = new byte[i];
                long j2 = ReactNativeBlobUtilFileResp.this.originalBody.byteStream().read(bArr, 0, i);
                ReactNativeBlobUtilFileResp reactNativeBlobUtilFileResp = ReactNativeBlobUtilFileResp.this;
                reactNativeBlobUtilFileResp.bytesDownloaded += j2 > 0 ? j2 : 0L;
                if (j2 > 0) {
                    reactNativeBlobUtilFileResp.ofStream.write(bArr, 0, (int) j2);
                } else if (reactNativeBlobUtilFileResp.contentLength() == -1 && j2 == -1) {
                    ReactNativeBlobUtilFileResp.this.isEndMarkerReceived = true;
                }
                ReactNativeBlobUtilProgressConfig reportProgress = ReactNativeBlobUtilReq.getReportProgress(ReactNativeBlobUtilFileResp.this.mTaskId);
                if (ReactNativeBlobUtilFileResp.this.contentLength() != 0) {
                    if (ReactNativeBlobUtilFileResp.this.contentLength() != -1) {
                        ReactNativeBlobUtilFileResp reactNativeBlobUtilFileResp2 = ReactNativeBlobUtilFileResp.this;
                        fContentLength = reactNativeBlobUtilFileResp2.bytesDownloaded / reactNativeBlobUtilFileResp2.contentLength();
                    } else {
                        fContentLength = ReactNativeBlobUtilFileResp.this.isEndMarkerReceived ? 1.0f : 0.0f;
                    }
                    if (reportProgress != null && reportProgress.shouldReport(fContentLength)) {
                        if (ReactNativeBlobUtilFileResp.this.contentLength() != -1) {
                            ReactNativeBlobUtilFileResp reactNativeBlobUtilFileResp3 = ReactNativeBlobUtilFileResp.this;
                            reportProgress(reactNativeBlobUtilFileResp3.mTaskId, reactNativeBlobUtilFileResp3.bytesDownloaded, reactNativeBlobUtilFileResp3.contentLength());
                        } else {
                            ReactNativeBlobUtilFileResp reactNativeBlobUtilFileResp4 = ReactNativeBlobUtilFileResp.this;
                            if (!reactNativeBlobUtilFileResp4.isEndMarkerReceived) {
                                reportProgress(reactNativeBlobUtilFileResp4.mTaskId, 0L, reactNativeBlobUtilFileResp4.contentLength());
                            } else {
                                String str = reactNativeBlobUtilFileResp4.mTaskId;
                                long j3 = reactNativeBlobUtilFileResp4.bytesDownloaded;
                                reportProgress(str, j3, j3);
                            }
                        }
                    }
                }
                return j2;
            } catch (Exception unused) {
                return -1L;
            }
        }

        private void reportProgress(String str, long j, long j2) {
            WritableMap writableMapCreateMap = Arguments.createMap();
            writableMapCreateMap.putString(BackgroundFetchConfig.FIELD_TASK_ID, str);
            writableMapCreateMap.putString("written", String.valueOf(j));
            writableMapCreateMap.putString("total", String.valueOf(j2));
            ((DeviceEventManagerModule.RCTDeviceEventEmitter) ReactNativeBlobUtilFileResp.this.rctContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(ReactNativeBlobUtilConst.EVENT_PROGRESS, writableMapCreateMap);
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            ReactNativeBlobUtilFileResp.this.ofStream.close();
        }
    }
}
