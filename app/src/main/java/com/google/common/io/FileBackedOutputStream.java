package com.google.common.io;

import io.sentry.instrumentation.file.SentryFileInputStream;
import io.sentry.instrumentation.file.SentryFileOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Objects;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes5.dex */
@ElementTypesAreNonnullByDefault
public final class FileBackedOutputStream extends OutputStream {

    @CheckForNull
    private File file;
    private final int fileThreshold;

    @CheckForNull
    private MemoryOutput memory;
    private OutputStream out;

    @CheckForNull
    private final File parentDirectory;
    private final boolean resetOnFinalize;
    private final ByteSource source;

    static class MemoryOutput extends ByteArrayOutputStream {
        private MemoryOutput() {
        }

        byte[] getBuffer() {
            return ((ByteArrayOutputStream) this).buf;
        }

        int getCount() {
            return ((ByteArrayOutputStream) this).count;
        }
    }

    @CheckForNull
    File getFile() {
        File file;
        synchronized (this) {
            file = this.file;
        }
        return file;
    }

    public FileBackedOutputStream(int i) {
        this(i, false);
    }

    public FileBackedOutputStream(int i, boolean z) {
        this(i, z, null);
    }

    private FileBackedOutputStream(int i, boolean z, @CheckForNull File file) {
        this.fileThreshold = i;
        this.resetOnFinalize = z;
        this.parentDirectory = file;
        MemoryOutput memoryOutput = new MemoryOutput();
        this.memory = memoryOutput;
        this.out = memoryOutput;
        if (z) {
            this.source = new ByteSource() { // from class: com.google.common.io.FileBackedOutputStream.1
                @Override // com.google.common.io.ByteSource
                public InputStream openStream() throws IOException {
                    return FileBackedOutputStream.this.openInputStream();
                }

                protected void finalize() {
                    try {
                        FileBackedOutputStream.this.reset();
                    } catch (Throwable th) {
                        th.printStackTrace(System.err);
                    }
                }
            };
        } else {
            this.source = new ByteSource() { // from class: com.google.common.io.FileBackedOutputStream.2
                @Override // com.google.common.io.ByteSource
                public InputStream openStream() throws IOException {
                    return FileBackedOutputStream.this.openInputStream();
                }
            };
        }
    }

    public ByteSource asByteSource() {
        return this.source;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public InputStream openInputStream() throws IOException {
        synchronized (this) {
            if (this.file != null) {
                File file = this.file;
                return SentryFileInputStream.Factory.create(new FileInputStream(file), file);
            }
            Objects.requireNonNull(this.memory);
            return new ByteArrayInputStream(this.memory.getBuffer(), 0, this.memory.getCount());
        }
    }

    public void reset() throws IOException {
        synchronized (this) {
            try {
                close();
                MemoryOutput memoryOutput = this.memory;
                if (memoryOutput == null) {
                    this.memory = new MemoryOutput();
                } else {
                    memoryOutput.reset();
                }
                this.out = this.memory;
                File file = this.file;
                if (file != null) {
                    this.file = null;
                    if (!file.delete()) {
                        String strValueOf = String.valueOf(file);
                        StringBuilder sb = new StringBuilder(strValueOf.length() + 18);
                        sb.append("Could not delete: ");
                        sb.append(strValueOf);
                        throw new IOException(sb.toString());
                    }
                }
            } catch (Throwable th) {
                if (this.memory == null) {
                    this.memory = new MemoryOutput();
                } else {
                    this.memory.reset();
                }
                this.out = this.memory;
                File file2 = this.file;
                if (file2 != null) {
                    this.file = null;
                    if (!file2.delete()) {
                        String strValueOf2 = String.valueOf(file2);
                        StringBuilder sb2 = new StringBuilder(strValueOf2.length() + 18);
                        sb2.append("Could not delete: ");
                        sb2.append(strValueOf2);
                        throw new IOException(sb2.toString());
                    }
                }
                throw th;
            }
        }
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        synchronized (this) {
            update(1);
            this.out.write(i);
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        synchronized (this) {
            write(bArr, 0, bArr.length);
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        synchronized (this) {
            update(i2);
            this.out.write(bArr, i, i2);
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this) {
            this.out.close();
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        synchronized (this) {
            this.out.flush();
        }
    }

    private void update(int i) throws IOException {
        MemoryOutput memoryOutput = this.memory;
        if (memoryOutput == null || memoryOutput.getCount() + i <= this.fileThreshold) {
            return;
        }
        File fileCreateTempFile = File.createTempFile("FileBackedOutputStream", null, this.parentDirectory);
        if (this.resetOnFinalize) {
            fileCreateTempFile.deleteOnExit();
        }
        try {
            FileOutputStream fileOutputStreamCreate = SentryFileOutputStream.Factory.create(new FileOutputStream(fileCreateTempFile), fileCreateTempFile);
            fileOutputStreamCreate.write(this.memory.getBuffer(), 0, this.memory.getCount());
            fileOutputStreamCreate.flush();
            this.out = fileOutputStreamCreate;
            this.file = fileCreateTempFile;
            this.memory = null;
        } catch (IOException e) {
            fileCreateTempFile.delete();
            throw e;
        }
    }
}
