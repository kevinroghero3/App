package it.aep_italia.vts.sdk.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/* JADX INFO: loaded from: classes6.dex */
public class StreamUtils {
    public static void closeSilently(InputStream inputStream) {
        if (inputStream == null) {
            return;
        }
        try {
            inputStream.close();
        } catch (Exception unused) {
        }
    }

    public static void closeSilently(OutputStream outputStream) {
        if (outputStream == null) {
            return;
        }
        try {
            outputStream.close();
        } catch (Exception unused) {
        }
    }

    public static void closeSilently(OutputStreamWriter outputStreamWriter) {
        if (outputStreamWriter == null) {
            return;
        }
        try {
            outputStreamWriter.close();
        } catch (Exception unused) {
        }
    }

    public static byte[] extract(InputStream inputStream, int i) throws IOException {
        if (inputStream.available() < i) {
            throw new IOException("Not enough data available");
        }
        byte[] bArr = new byte[i];
        inputStream.read(bArr);
        return bArr;
    }

    public static byte[] extractAll(InputStream inputStream) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        int i;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byte[] bArr = new byte[4096];
                do {
                    i = inputStream.read(bArr);
                    if (i > 0) {
                        byteArrayOutputStream.write(bArr, 0, i);
                    }
                } while (i > 0);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                closeSilently(byteArrayOutputStream);
                return byteArray;
            } catch (Throwable th) {
                th = th;
                closeSilently(byteArrayOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            byteArrayOutputStream = null;
        }
    }

    public static byte[] extractAllAndClose(InputStream inputStream) throws IOException {
        try {
            return extractAll(inputStream);
        } finally {
            closeSilently(inputStream);
        }
    }

    public static void pipe(InputStream inputStream, OutputStream outputStream) throws IOException {
        if (inputStream == null) {
            throw new IOException("Input stream cannot be null.");
        }
        if (outputStream == null) {
            throw new IOException("Output stream cannot be null.");
        }
        byte[] bArr = new byte[1024];
        while (inputStream.available() > 0) {
            outputStream.write(bArr, 0, inputStream.read(bArr));
        }
    }

    public static void pipeAndClose(InputStream inputStream, OutputStream outputStream) throws IOException {
        try {
            pipe(inputStream, outputStream);
        } finally {
            closeSilently(inputStream);
            closeSilently(outputStream);
        }
    }

    public static int readInt(InputStream inputStream) throws IOException {
        return ByteUtils.bytesToInt(extract(inputStream, 4));
    }

    public static long readLong(InputStream inputStream) throws IOException {
        return ByteUtils.bytesToLong(extract(inputStream, 8));
    }

    public static short readShort(InputStream inputStream) throws IOException {
        return (short) ByteUtils.bytesToInt(extract(inputStream, 2));
    }

    public static void writeAndClose(byte[] bArr, int i, int i2, OutputStream outputStream) throws IOException {
        try {
            outputStream.write(bArr, i, i2);
        } finally {
            closeSilently(outputStream);
        }
    }

    public static void writeAndClose(byte[] bArr, OutputStream outputStream) throws IOException {
        try {
            outputStream.write(bArr);
        } finally {
            closeSilently(outputStream);
        }
    }
}
