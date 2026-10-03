package com.github.barteksc.pdfviewer.util;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.ImageFormat;
import android.util.TypedValue;
import android.view.ViewConfiguration;
import com.google.firebase.sessions.settings.RemoteSettings;
import io.sentry.instrumentation.file.SentryFileOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import o.ArtificialStackFrames;

/* JADX INFO: loaded from: classes4.dex */
public class FileUtils {
    private static int artificialFrame = 1;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME;

    private FileUtils() {
    }

    public static File fileFromAsset(Context context, String str) throws Throwable {
        int i = 2 % 2;
        File file = new File(context.getCacheDir(), str + "-pdfview.pdf");
        int i2 = getARTIFICIAL_FRAME_PACKAGE_NAME + 87;
        artificialFrame = i2 % 128;
        int i3 = i2 % 2;
        try {
            if (((Boolean) String.class.getMethod("contains", CharSequence.class).invoke(str, RemoteSettings.FORWARD_SLASH_STRING)).booleanValue()) {
                int i4 = getARTIFICIAL_FRAME_PACKAGE_NAME + 13;
                artificialFrame = i4 % 128;
                int i5 = i4 % 2;
                file.getParentFile().mkdirs();
            }
            try {
                Object[] objArr = {context.getAssets(), str};
                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-982065286);
                if (objAccessartificialFrame == null) {
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 12, (char) (7116 - (ViewConfiguration.getLongPressTimeout() >> 16)), 36 - ImageFormat.getBitsPerPixel(0), 1511233906, false, "accessartificialFrame", new Class[]{AssetManager.class, String.class});
                }
                copy((InputStream) ((Method) objAccessartificialFrame).invoke(null, objArr), file);
                return file;
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        } catch (Throwable th2) {
            Throwable cause2 = th2.getCause();
            if (cause2 != null) {
                throw cause2;
            }
            throw th2;
        }
    }

    public static void copy(InputStream inputStream, File file) throws IOException {
        FileOutputStream fileOutputStreamCreate = null;
        try {
            fileOutputStreamCreate = SentryFileOutputStream.Factory.create(new FileOutputStream(file), file);
            byte[] bArr = new byte[1024];
            while (true) {
                int i = inputStream.read(bArr);
                if (i != -1) {
                    fileOutputStreamCreate.write(bArr, 0, i);
                } else {
                    try {
                        break;
                    } finally {
                        if (fileOutputStreamCreate != null) {
                            fileOutputStreamCreate.close();
                        }
                    }
                }
            }
            inputStream.close();
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } finally {
                    if (fileOutputStreamCreate != null) {
                        fileOutputStreamCreate.close();
                    }
                }
            }
            throw th;
        }
    }
}
