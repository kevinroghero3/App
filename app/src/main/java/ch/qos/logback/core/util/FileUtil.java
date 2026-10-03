package ch.qos.logback.core.util;

import ch.qos.logback.core.Context;
import ch.qos.logback.core.rolling.RolloverFailure;
import ch.qos.logback.core.spi.ContextAwareBase;
import com.google.firebase.sessions.settings.RemoteSettings;
import io.sentry.instrumentation.file.SentryFileInputStream;
import io.sentry.instrumentation.file.SentryFileOutputStream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public class FileUtil extends ContextAwareBase {
    static final int BUF_SIZE = 32768;

    public FileUtil(Context context) {
        setContext(context);
    }

    public static boolean createMissingParentDirectories(File file) {
        File parentFile = file.getParentFile();
        if (parentFile == null) {
            return true;
        }
        parentFile.mkdirs();
        return parentFile.exists();
    }

    public static String prefixRelativePath(String str, String str2) {
        if (str == null || OptionHelper.isEmpty(str.trim()) || new File(str2).isAbsolute()) {
            return str2;
        }
        return str + RemoteSettings.FORWARD_SLASH_STRING + str2;
    }

    /* JADX WARN: Code duplicated, block: B:41:0x0083 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:43:0x007e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:56:? A[SYNTHETIC] */
    public void copy(String str, String str2) throws Throwable {
        BufferedOutputStream bufferedOutputStream;
        BufferedInputStream bufferedInputStream = null;
        bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream2 = null;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            BufferedInputStream bufferedInputStream3 = new BufferedInputStream(SentryFileInputStream.Factory.create(new FileInputStream(str), str));
            try {
                bufferedOutputStream = new BufferedOutputStream(SentryFileOutputStream.Factory.create(new FileOutputStream(str2), str2));
                try {
                    byte[] bArr = new byte[32768];
                    while (true) {
                        int i = bufferedInputStream3.read(bArr);
                        if (i != -1) {
                            bufferedOutputStream.write(bArr, 0, i);
                        } else {
                            bufferedInputStream3.close();
                            try {
                                bufferedOutputStream.close();
                                return;
                            } catch (IOException e) {
                                bufferedInputStream3 = null;
                                bufferedOutputStream2 = bufferedOutputStream;
                                e = e;
                                IOException iOException = e;
                                bufferedOutputStream = bufferedOutputStream2;
                                bufferedInputStream2 = bufferedInputStream3;
                                e = iOException;
                                try {
                                    String str3 = "Failed to copy [" + str + "] to [" + str2 + "]";
                                    addError(str3, e);
                                    throw new RolloverFailure(str3);
                                } catch (Throwable th) {
                                    th = th;
                                    bufferedInputStream3 = bufferedInputStream2;
                                    bufferedInputStream = bufferedInputStream3;
                                    if (bufferedInputStream != null) {
                                        try {
                                            bufferedInputStream.close();
                                        } catch (IOException unused) {
                                        }
                                    }
                                    if (bufferedOutputStream != null) {
                                        throw th;
                                    }
                                    try {
                                        bufferedOutputStream.close();
                                        throw th;
                                    } catch (IOException unused2) {
                                        throw th;
                                    }
                                }
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        }
                        if (bufferedInputStream != null) {
                            bufferedInputStream.close();
                        }
                        if (bufferedOutputStream != null) {
                            throw th;
                        }
                        bufferedOutputStream.close();
                        throw th;
                    }
                } catch (IOException e2) {
                    e = e2;
                    bufferedInputStream2 = bufferedInputStream3;
                    String str4 = "Failed to copy [" + str + "] to [" + str2 + "]";
                    addError(str4, e);
                    throw new RolloverFailure(str4);
                } catch (Throwable th3) {
                    th = th3;
                    bufferedInputStream = bufferedInputStream3;
                }
            } catch (IOException e3) {
                e = e3;
            } catch (Throwable th4) {
                th = th4;
                bufferedOutputStream = null;
            }
        } catch (IOException e4) {
            e = e4;
            bufferedOutputStream = null;
        } catch (Throwable th5) {
            th = th5;
            bufferedOutputStream = null;
        }
    }
}
