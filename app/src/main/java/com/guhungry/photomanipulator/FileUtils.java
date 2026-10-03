package com.guhungry.photomanipulator;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Base64;
import com.facebook.common.util.UriUtil;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.guhungry.photomanipulator.factory.AndroidConcreteFactory;
import com.guhungry.photomanipulator.factory.AndroidFactory;
import com.guhungry.photomanipulator.helper.AndroidConcreteFile;
import com.guhungry.photomanipulator.helper.AndroidFile;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public final class FileUtils {
    private static final String BASE64_URI_PREFIX = "data:";
    public static final FileUtils INSTANCE = new FileUtils();
    private static final String[] LOCAL_URI_PREFIXES = {"file", "content", UriUtil.QUALIFIED_RESOURCE_SCHEME};

    private FileUtils() {
    }

    private final boolean isLocalUri(String str) {
        for (String str2 : LOCAL_URI_PREFIXES) {
            if (StringsKt__StringsJVMKt.startsWith$default(str, str2, false, 2, null)) {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ File createTempFile$default(Context context, String str, String str2, AndroidFile androidFile, int i, Object obj) {
        if ((i & 8) != 0) {
            androidFile = new AndroidConcreteFile();
        }
        return createTempFile(context, str, str2, androidFile);
    }

    @JvmStatic
    public static final File createTempFile(@NotNull Context context, @NotNull String prefix, @Nullable String str, @NotNull AndroidFile file) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(file, "file");
        return file.createTempFile(prefix, MimeUtils.toExtension(str), cachePath(context));
    }

    @JvmStatic
    public static final File cachePath(@NotNull Context context) throws IOException {
        Intrinsics.checkNotNullParameter(context, "context");
        File externalCacheDir = context.getExternalCacheDir();
        File cacheDir = context.getCacheDir();
        if (externalCacheDir == null && cacheDir == null) {
            throw new IOException("No cache directory available");
        }
        return (externalCacheDir != null && (cacheDir == null || externalCacheDir.getFreeSpace() > cacheDir.getFreeSpace())) ? externalCacheDir : cacheDir;
    }

    @JvmStatic
    public static final void cleanDirectory(@NotNull File directory, @NotNull final String prefix) {
        Intrinsics.checkNotNullParameter(directory, "directory");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        File[] fileArrListFiles = directory.listFiles(new FilenameFilter() { // from class: com.guhungry.photomanipulator.FileUtils$$ExternalSyntheticLambda0
            @Override // java.io.FilenameFilter
            public final boolean accept(File file, String str) {
                return FileUtils.cleanDirectory$lambda$1(prefix, file, str);
            }
        });
        if (fileArrListFiles != null) {
            for (File file : fileArrListFiles) {
                file.delete();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean cleanDirectory$lambda$1(String prefix, File file, String name) {
        Intrinsics.checkNotNullParameter(prefix, "$prefix");
        Intrinsics.checkNotNullExpressionValue(name, "name");
        return StringsKt__StringsJVMKt.startsWith$default(name, prefix, false, 2, null);
    }

    public static /* synthetic */ void saveImageFile$default(Bitmap bitmap, String str, int i, File file, AndroidFile androidFile, int i2, Object obj) {
        if ((i2 & 16) != 0) {
            androidFile = new AndroidConcreteFile();
        }
        saveImageFile(bitmap, str, i, file, androidFile);
    }

    @JvmStatic
    public static final void saveImageFile(@NotNull Bitmap image, @NotNull String mime, int i, @NotNull File target, @NotNull AndroidFile file) {
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(mime, "mime");
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(file, "file");
        FileOutputStream fileOutputStreamMakeFileOutputStream = file.makeFileOutputStream(target);
        try {
            image.compress(MimeUtils.toCompressFormat(mime), i, fileOutputStreamMakeFileOutputStream);
            CloseableKt.closeFinally(fileOutputStreamMakeFileOutputStream, null);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(fileOutputStreamMakeFileOutputStream, th);
                throw th2;
            }
        }
    }

    public static /* synthetic */ InputStream openBitmapInputStream$default(Context context, String str, AndroidFactory androidFactory, int i, Object obj) {
        if ((i & 4) != 0) {
            androidFactory = new AndroidConcreteFactory();
        }
        return openBitmapInputStream(context, str, androidFactory);
    }

    @JvmStatic
    public static final InputStream openBitmapInputStream(@NotNull Context context, @NotNull String uri, @NotNull AndroidFactory factory) throws IOException {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(factory, "factory");
        FileUtils fileUtils = INSTANCE;
        if (fileUtils.isBase64Data(uri)) {
            String strSubstring = uri.substring(StringsKt__StringsKt.indexOf$default((CharSequence) uri, ",", 0, false, 6, (Object) null) + 1);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            return new ByteArrayInputStream(Base64.decode(strSubstring, 0));
        }
        if (fileUtils.isLocalUri(uri)) {
            InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(factory.makeUri(uri));
            if (inputStreamOpenInputStream != null) {
                return inputStreamOpenInputStream;
            }
            throw new IOException("Cannot open bitmap: " + uri);
        }
        InputStream inputStream = ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(uri).openConnection())).getInputStream();
        Intrinsics.checkNotNullExpressionValue(inputStream, "URL(uri).openConnection().getInputStream()");
        return inputStream;
    }

    private final boolean isBase64Data(String str) {
        return StringsKt__StringsJVMKt.startsWith$default(str, BASE64_URI_PREFIX, false, 2, null);
    }
}
