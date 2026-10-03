package com.mrousavy.camera.core.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Size;
import com.google.maps.android.BuildConfig;
import com.mrousavy.camera.core.InvalidPathError;
import io.sentry.instrumentation.file.SentryFileOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public final class FileUtils {
    public static final Companion Companion = new Companion(null);

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final File getDirectory(@Nullable String str) throws InvalidPathError {
            if (str == null) {
                throw new InvalidPathError(BuildConfig.TRAVIS);
            }
            File file = new File(str);
            if (file.isDirectory()) {
                return file;
            }
            throw new InvalidPathError(str);
        }

        public final void writeBitmapTofile(@NotNull Bitmap bitmap, @NotNull File file, int i) throws FileNotFoundException {
            Intrinsics.checkNotNullParameter(bitmap, "bitmap");
            Intrinsics.checkNotNullParameter(file, "file");
            FileOutputStream fileOutputStreamCreate = SentryFileOutputStream.Factory.create(new FileOutputStream(file), file);
            try {
                bitmap.compress(Bitmap.CompressFormat.JPEG, i, fileOutputStreamCreate);
                CloseableKt.closeFinally(fileOutputStreamCreate, null);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(fileOutputStreamCreate, th);
                    throw th2;
                }
            }
        }

        public final Size getImageSize(@NotNull String imagePath) {
            Intrinsics.checkNotNullParameter(imagePath, "imagePath");
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(imagePath, options);
            return new Size(options.outWidth, options.outHeight);
        }
    }
}
