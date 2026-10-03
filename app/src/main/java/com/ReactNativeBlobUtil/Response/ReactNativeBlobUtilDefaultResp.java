package com.ReactNativeBlobUtil.Response;

import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilProgressConfig;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilReq;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.transistorsoft.tsbackgroundfetch.BackgroundFetchConfig;
import java.io.IOException;
import java.nio.charset.Charset;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;
import okio.Timeout;

/* JADX INFO: loaded from: classes4.dex */
public class ReactNativeBlobUtilDefaultResp extends ResponseBody {
    boolean isIncrement;
    String mTaskId;
    ResponseBody originalBody;
    ReactApplicationContext rctContext;

    public ReactNativeBlobUtilDefaultResp(ReactApplicationContext reactApplicationContext, String str, ResponseBody responseBody, boolean z) {
        this.rctContext = reactApplicationContext;
        this.mTaskId = str;
        this.originalBody = responseBody;
        this.isIncrement = z;
    }

    @Override // okhttp3.ResponseBody
    public MediaType contentType() {
        return this.originalBody.contentType();
    }

    @Override // okhttp3.ResponseBody
    public long contentLength() {
        return this.originalBody.contentLength();
    }

    @Override // okhttp3.ResponseBody
    public BufferedSource source() {
        return Okio.buffer(new ProgressReportingSource(this.originalBody.source()));
    }

    class ProgressReportingSource implements Source {
        long bytesRead = 0;
        BufferedSource mOriginalSource;

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        @Override // okio.Source
        public Timeout timeout() {
            return null;
        }

        ProgressReportingSource(BufferedSource bufferedSource) {
            this.mOriginalSource = bufferedSource;
        }

        @Override // okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            long j2 = this.mOriginalSource.read(buffer, j);
            this.bytesRead += j2 > 0 ? j2 : 0L;
            ReactNativeBlobUtilProgressConfig reportProgress = ReactNativeBlobUtilReq.getReportProgress(ReactNativeBlobUtilDefaultResp.this.mTaskId);
            long jContentLength = ReactNativeBlobUtilDefaultResp.this.contentLength();
            if (reportProgress != null && jContentLength != 0 && reportProgress.shouldReport(this.bytesRead / ReactNativeBlobUtilDefaultResp.this.contentLength())) {
                WritableMap writableMapCreateMap = Arguments.createMap();
                writableMapCreateMap.putString(BackgroundFetchConfig.FIELD_TASK_ID, ReactNativeBlobUtilDefaultResp.this.mTaskId);
                writableMapCreateMap.putString("written", String.valueOf(this.bytesRead));
                writableMapCreateMap.putString("total", String.valueOf(ReactNativeBlobUtilDefaultResp.this.contentLength()));
                if (ReactNativeBlobUtilDefaultResp.this.isIncrement) {
                    writableMapCreateMap.putString("chunk", buffer.readString(Charset.defaultCharset()));
                } else {
                    writableMapCreateMap.putString("chunk", "");
                }
                ((DeviceEventManagerModule.RCTDeviceEventEmitter) ReactNativeBlobUtilDefaultResp.this.rctContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(ReactNativeBlobUtilConst.EVENT_PROGRESS, writableMapCreateMap);
            }
            return j2;
        }
    }
}
