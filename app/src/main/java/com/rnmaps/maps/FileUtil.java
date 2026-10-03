package com.rnmaps.maps;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import com.facebook.common.logging.FLog;
import com.facebook.react.common.ReactConstants;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import io.sentry.instrumentation.file.SentryFileInputStream;
import io.sentry.instrumentation.file.SentryFileOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

/* JADX INFO: loaded from: classes6.dex */
public class FileUtil extends AsyncTask<String, Void, InputStream> {
    private Context context;

    public FileUtil(Context context) {
        this.context = context;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public InputStream doInBackground(String... strArr) {
        try {
            Uri uri = Uri.parse(strArr[0]);
            if (uri.getScheme().startsWith("http")) {
                return getDownloadFileInputStream(this.context, uri);
            }
            return this.context.getContentResolver().openInputStream(uri);
        } catch (Exception e) {
            FLog.e(ReactConstants.TAG, "Could not retrieve file for contentUri " + strArr[0], e);
            return null;
        }
    }

    private InputStream getDownloadFileInputStream(Context context, Uri uri) throws IOException {
        File fileCreateTempFile = File.createTempFile("FileUtil", "temp", context.getApplicationContext().getCacheDir());
        fileCreateTempFile.deleteOnExit();
        InputStream inputStreamOpenStream = FirebasePerfUrlConnection.openStream(new URL(uri.toString()));
        try {
            ReadableByteChannel readableByteChannelNewChannel = Channels.newChannel(inputStreamOpenStream);
            try {
                FileOutputStream fileOutputStreamCreate = SentryFileOutputStream.Factory.create(new FileOutputStream(fileCreateTempFile), fileCreateTempFile);
                try {
                    fileOutputStreamCreate.getChannel().transferFrom(readableByteChannelNewChannel, 0L, Long.MAX_VALUE);
                    FileInputStream fileInputStreamCreate = SentryFileInputStream.Factory.create(new FileInputStream(fileCreateTempFile), fileCreateTempFile);
                    fileOutputStreamCreate.close();
                    readableByteChannelNewChannel.close();
                    inputStreamOpenStream.close();
                    return fileInputStreamCreate;
                } catch (Throwable th) {
                    fileOutputStreamCreate.close();
                    throw th;
                }
            } catch (Throwable th2) {
                readableByteChannelNewChannel.close();
                throw th2;
            }
        } catch (Throwable th3) {
            inputStreamOpenStream.close();
            throw th3;
        }
    }
}
