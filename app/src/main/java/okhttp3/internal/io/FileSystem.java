package okhttp3.internal.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.Okio;
import okio.Okio__JvmOkioKt;
import okio.Sink;
import okio.Source;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public interface FileSystem {
    public static final Companion Companion = new Companion(null);
    public static final FileSystem SYSTEM = new FileSystem() { // from class: okhttp3.internal.io.FileSystem$Companion$SYSTEM$1
        @Override // okhttp3.internal.io.FileSystem
        public Source source(@NotNull File file) throws FileNotFoundException {
            Intrinsics.checkParameterIsNotNull(file, "file");
            return Okio.source(file);
        }

        @Override // okhttp3.internal.io.FileSystem
        public Sink sink(@NotNull File file) throws FileNotFoundException {
            Intrinsics.checkParameterIsNotNull(file, "file");
            try {
                return Okio__JvmOkioKt.sink$default(file, false, 1, null);
            } catch (FileNotFoundException unused) {
                file.getParentFile().mkdirs();
                return Okio__JvmOkioKt.sink$default(file, false, 1, null);
            }
        }

        @Override // okhttp3.internal.io.FileSystem
        public Sink appendingSink(@NotNull File file) throws FileNotFoundException {
            Intrinsics.checkParameterIsNotNull(file, "file");
            try {
                return Okio.appendingSink(file);
            } catch (FileNotFoundException unused) {
                file.getParentFile().mkdirs();
                return Okio.appendingSink(file);
            }
        }

        @Override // okhttp3.internal.io.FileSystem
        public void delete(@NotNull File file) throws IOException {
            Intrinsics.checkParameterIsNotNull(file, "file");
            if (file.delete() || !file.exists()) {
                return;
            }
            throw new IOException("failed to delete " + file);
        }

        @Override // okhttp3.internal.io.FileSystem
        public boolean exists(@NotNull File file) {
            Intrinsics.checkParameterIsNotNull(file, "file");
            return file.exists();
        }

        @Override // okhttp3.internal.io.FileSystem
        public long size(@NotNull File file) {
            Intrinsics.checkParameterIsNotNull(file, "file");
            return file.length();
        }

        @Override // okhttp3.internal.io.FileSystem
        public void rename(@NotNull File from, @NotNull File to) throws IOException {
            Intrinsics.checkParameterIsNotNull(from, "from");
            Intrinsics.checkParameterIsNotNull(to, "to");
            delete(to);
            if (from.renameTo(to)) {
                return;
            }
            throw new IOException("failed to rename " + from + " to " + to);
        }

        @Override // okhttp3.internal.io.FileSystem
        public void deleteContents(@NotNull File directory) throws IOException {
            Intrinsics.checkParameterIsNotNull(directory, "directory");
            File[] fileArrListFiles = directory.listFiles();
            if (fileArrListFiles == null) {
                throw new IOException("not a readable directory: " + directory);
            }
            for (File file : fileArrListFiles) {
                Intrinsics.checkExpressionValueIsNotNull(file, "file");
                if (file.isDirectory()) {
                    deleteContents(file);
                }
                if (!file.delete()) {
                    throw new IOException("failed to delete " + file);
                }
            }
        }
    };

    Sink appendingSink(@NotNull File file) throws FileNotFoundException;

    void delete(@NotNull File file) throws IOException;

    void deleteContents(@NotNull File file) throws IOException;

    boolean exists(@NotNull File file);

    void rename(@NotNull File file, @NotNull File file2) throws IOException;

    Sink sink(@NotNull File file) throws FileNotFoundException;

    long size(@NotNull File file);

    Source source(@NotNull File file) throws FileNotFoundException;

    /* JADX INFO: loaded from: classes3.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
