package ch.qos.logback.core.rolling.helper;

import ch.qos.logback.core.rolling.RolloverFailure;
import ch.qos.logback.core.spi.ContextAwareBase;
import ch.qos.logback.core.status.ErrorStatus;
import ch.qos.logback.core.status.WarnStatus;
import ch.qos.logback.core.util.FileUtil;
import io.sentry.instrumentation.file.SentryFileInputStream;
import io.sentry.instrumentation.file.SentryFileOutputStream;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.Future;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* JADX INFO: loaded from: classes4.dex */
public class Compressor extends ContextAwareBase {
    static final int BUFFER_SIZE = 8192;
    final CompressionMode compressionMode;

    /* JADX INFO: renamed from: ch.qos.logback.core.rolling.helper.Compressor$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$ch$qos$logback$core$rolling$helper$CompressionMode;

        static {
            int[] iArr = new int[CompressionMode.values().length];
            $SwitchMap$ch$qos$logback$core$rolling$helper$CompressionMode = iArr;
            try {
                iArr[CompressionMode.GZ.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$ch$qos$logback$core$rolling$helper$CompressionMode[CompressionMode.ZIP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$ch$qos$logback$core$rolling$helper$CompressionMode[CompressionMode.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    class CompressionRunnable implements Runnable {
        final String innerEntryName;
        final String nameOfCompressedFile;
        final String nameOfFile2Compress;

        CompressionRunnable(String str, String str2, String str3) {
            this.nameOfFile2Compress = str;
            this.nameOfCompressedFile = str2;
            this.innerEntryName = str3;
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            Compressor.this.compress(this.nameOfFile2Compress, this.nameOfCompressedFile, this.innerEntryName);
        }
    }

    public Compressor(CompressionMode compressionMode) {
        this.compressionMode = compressionMode;
    }

    public static String computeFileNameStrWithoutCompSuffix(String str, CompressionMode compressionMode) {
        int i;
        int length = str.length();
        int i2 = AnonymousClass1.$SwitchMap$ch$qos$logback$core$rolling$helper$CompressionMode[compressionMode.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3) {
                    return str;
                }
                throw new IllegalStateException("Execution should not reach this point");
            }
            if (!str.endsWith(".zip")) {
                return str;
            }
            i = length - 4;
        } else {
            if (!str.endsWith(".gz")) {
                return str;
            }
            i = length - 3;
        }
        return str.substring(0, i);
    }

    /* JADX WARN: Code duplicated, block: B:42:0x011c  */
    /* JADX WARN: Code duplicated, block: B:58:0x0143 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:64:0x013e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:74:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:75:? A[SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:42:0x011c, please report this as an issue */
    private void gzCompress(String str, String str2) throws Throwable {
        GZIPOutputStream gZIPOutputStream;
        BufferedInputStream bufferedInputStream;
        GZIPOutputStream gZIPOutputStream2;
        File file = new File(str);
        if (!file.exists()) {
            addStatus(new WarnStatus("The file to compress named [" + str + "] does not exist.", this));
            return;
        }
        if (!str2.endsWith(".gz")) {
            str2 = str2 + ".gz";
        }
        File file2 = new File(str2);
        if (file2.exists()) {
            addWarn("The target compressed file named [" + str2 + "] exist already. Aborting file compression.");
            return;
        }
        addInfo("GZ compressing [" + file + "] as [" + file2 + "]");
        createMissingTargetDirsIfNecessary(file2);
        BufferedInputStream bufferedInputStream2 = null;
        gZIPOutputStream = null;
        gZIPOutputStream = null;
        GZIPOutputStream gZIPOutputStream3 = null;
        try {
            bufferedInputStream = new BufferedInputStream(SentryFileInputStream.Factory.create(new FileInputStream(str), str));
            try {
                try {
                    gZIPOutputStream2 = new GZIPOutputStream(SentryFileOutputStream.Factory.create(new FileOutputStream(str2), str2));
                    try {
                        byte[] bArr = new byte[8192];
                        while (true) {
                            int i = bufferedInputStream.read(bArr);
                            if (i == -1) {
                                break;
                            } else {
                                gZIPOutputStream2.write(bArr, 0, i);
                            }
                        }
                        addInfo("Done ZIP compressing [" + file + "] as [" + file2 + "]");
                        try {
                            bufferedInputStream.close();
                        } catch (IOException unused) {
                        }
                    } catch (Exception e) {
                        e = e;
                        gZIPOutputStream3 = gZIPOutputStream2;
                        addStatus(new ErrorStatus("Error occurred while compressing [" + str + "] into [" + str2 + "].", this, e));
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException unused2) {
                            }
                        }
                        if (gZIPOutputStream3 != null) {
                            gZIPOutputStream2 = gZIPOutputStream3;
                        }
                        if (file.delete()) {
                        }
                        addStatus(new WarnStatus("Could not delete [" + str + "].", this));
                    } catch (Throwable th) {
                        th = th;
                        gZIPOutputStream3 = gZIPOutputStream2;
                        gZIPOutputStream = gZIPOutputStream3;
                        bufferedInputStream2 = bufferedInputStream;
                        if (bufferedInputStream2 != null) {
                            try {
                                bufferedInputStream2.close();
                            } catch (IOException unused3) {
                            }
                        }
                        if (gZIPOutputStream != null) {
                            throw th;
                        }
                        try {
                            gZIPOutputStream.close();
                            throw th;
                        } catch (IOException unused4) {
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception e3) {
            e = e3;
            bufferedInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            gZIPOutputStream = null;
            if (bufferedInputStream2 != null) {
                bufferedInputStream2.close();
            }
            if (gZIPOutputStream != null) {
                throw th;
            }
            gZIPOutputStream.close();
            throw th;
        }
        try {
            gZIPOutputStream2.close();
        } catch (IOException unused5) {
        }
        if (file.delete()) {
            addStatus(new WarnStatus("Could not delete [" + str + "].", this));
        }
    }

    /* JADX WARN: Code duplicated, block: B:44:0x0135  */
    /* JADX WARN: Code duplicated, block: B:60:0x0157 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:67:0x015c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:77:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:78:? A[SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:44:0x0135, please report this as an issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v3, types: [java.util.zip.ZipOutputStream] */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v15, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.util.zip.ZipOutputStream] */
    /* JADX WARN: Type inference failed for: r7v4, types: [java.util.zip.ZipOutputStream] */
    private void zipCompress(String str, String str2, String str3) throws Throwable {
        ?? r11;
        BufferedInputStream bufferedInputStream;
        ?? zipOutputStream;
        File file = new File(str);
        if (!file.exists()) {
            addStatus(new WarnStatus("The file to compress named [" + str + "] does not exist.", this));
            return;
        }
        if (str3 == null) {
            addStatus(new WarnStatus("The innerEntryName parameter cannot be null", this));
            return;
        }
        if (!str2.endsWith(".zip")) {
            str2 = str2 + ".zip";
        }
        File file2 = new File(str2);
        if (file2.exists()) {
            addStatus(new WarnStatus("The target compressed file named [" + str2 + "] exist already.", this));
            return;
        }
        addInfo("ZIP compressing [" + file + "] as [" + file2 + "]");
        createMissingTargetDirsIfNecessary(file2);
        ?? r3 = 0;
        r3 = 0;
        r3 = 0;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            try {
                bufferedInputStream = new BufferedInputStream(SentryFileInputStream.Factory.create(new FileInputStream(str), str));
                try {
                    zipOutputStream = new ZipOutputStream(SentryFileOutputStream.Factory.create(new FileOutputStream(str2), str2));
                    try {
                        zipOutputStream.putNextEntry(computeZipEntry(str3));
                        byte[] bArr = new byte[8192];
                        while (true) {
                            int i = bufferedInputStream.read(bArr);
                            if (i == -1) {
                                break;
                            } else {
                                zipOutputStream.write(bArr, 0, i);
                            }
                        }
                        StringBuilder sb = new StringBuilder();
                        r3 = "Done ZIP compressing [";
                        sb.append("Done ZIP compressing [");
                        sb.append(file);
                        sb.append("] as [");
                        sb.append(file2);
                        sb.append("]");
                        addInfo(sb.toString());
                        try {
                            bufferedInputStream.close();
                        } catch (IOException unused) {
                        }
                    } catch (Exception e) {
                        e = e;
                        r3 = zipOutputStream;
                        addStatus(new ErrorStatus("Error occurred while compressing [" + str + "] into [" + str2 + "].", this, e));
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException unused2) {
                            }
                        }
                        if (r3 != 0) {
                            zipOutputStream = r3;
                        }
                        if (file.delete()) {
                        }
                        addStatus(new WarnStatus("Could not delete [" + str + "].", this));
                    } catch (Throwable th) {
                        th = th;
                        r3 = zipOutputStream;
                        r11 = r3;
                        bufferedInputStream2 = bufferedInputStream;
                        if (bufferedInputStream2 != null) {
                            try {
                                bufferedInputStream2.close();
                            } catch (IOException unused3) {
                            }
                        }
                        if (r11 != 0) {
                            throw th;
                        }
                        try {
                            r11.close();
                            throw th;
                        } catch (IOException unused4) {
                            throw th;
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Exception e3) {
                e = e3;
                bufferedInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                r11 = 0;
                if (bufferedInputStream2 != null) {
                    bufferedInputStream2.close();
                }
                if (r11 != 0) {
                    throw th;
                }
                r11.close();
                throw th;
            }
            try {
                zipOutputStream.close();
            } catch (IOException unused5) {
            }
            if (file.delete()) {
                addStatus(new WarnStatus("Could not delete [" + str + "].", this));
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public Future<?> asyncCompress(String str, String str2, String str3) throws RolloverFailure {
        return this.context.getScheduledExecutorService().submit(new CompressionRunnable(str, str2, str3));
    }

    public void compress(String str, String str2, String str3) throws Throwable {
        int i = AnonymousClass1.$SwitchMap$ch$qos$logback$core$rolling$helper$CompressionMode[this.compressionMode.ordinal()];
        if (i == 1) {
            gzCompress(str, str2);
        } else if (i == 2) {
            zipCompress(str, str2, str3);
        } else if (i == 3) {
            throw new UnsupportedOperationException("compress method called in NONE compression mode");
        }
    }

    ZipEntry computeZipEntry(File file) {
        return computeZipEntry(file.getName());
    }

    ZipEntry computeZipEntry(String str) {
        return new ZipEntry(computeFileNameStrWithoutCompSuffix(str, this.compressionMode));
    }

    void createMissingTargetDirsIfNecessary(File file) {
        if (FileUtil.createMissingParentDirectories(file)) {
            return;
        }
        addError("Failed to create parent directories for [" + file.getAbsolutePath() + "]");
    }

    public String toString() {
        return getClass().getName();
    }
}
