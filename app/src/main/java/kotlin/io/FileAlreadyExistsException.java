package kotlin.io;

import java.io.File;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class FileAlreadyExistsException extends FileSystemException {
    public static int handleMediaPlayPauseKeySingleTapIfPending;
    public static int onAddQueueItem;

    public /* synthetic */ FileAlreadyExistsException(File file, File file2, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(file, (i & 2) != 0 ? null : file2, (i & 4) != 0 ? null : str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileAlreadyExistsException(@NotNull File file, @Nullable File file2, @Nullable String str) {
        super(file, file2, str);
        Intrinsics.checkNotNullParameter(file, "file");
    }

    public static int MediaBrowserCompatMediaBrowserImplBase5() {
        int i = onAddQueueItem;
        int i2 = i % 8909992;
        onAddQueueItem = i + 1;
        if (i2 != 0) {
            return handleMediaPlayPauseKeySingleTapIfPending;
        }
        int i3 = (int) Runtime.getRuntime().totalMemory();
        handleMediaPlayPauseKeySingleTapIfPending = i3;
        return i3;
    }
}
