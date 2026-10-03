package com.facebook.common.internal;

import io.sentry.instrumentation.file.SentryFileInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes4.dex */
public class Files {
    private Files() {
    }

    static byte[] readFile(InputStream inputStream, long j) throws IOException {
        if (j <= 2147483647L) {
            if (j == 0) {
                return ByteStreams.toByteArray(inputStream);
            }
            return ByteStreams.toByteArray(inputStream, (int) j);
        }
        throw new OutOfMemoryError("file is too large to fit in a byte array: " + j + " bytes");
    }

    public static byte[] toByteArray(File file) throws IOException {
        FileInputStream fileInputStreamCreate = null;
        try {
            fileInputStreamCreate = SentryFileInputStream.Factory.create(new FileInputStream(file), file);
            byte[] file2 = readFile(fileInputStreamCreate, fileInputStreamCreate.getChannel().size());
            fileInputStreamCreate.close();
            return file2;
        } catch (Throwable th) {
            if (fileInputStreamCreate != null) {
                fileInputStreamCreate.close();
            }
            throw th;
        }
    }
}
