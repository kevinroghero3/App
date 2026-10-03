package androidx.camera.video.internal;

import android.net.Uri;
import androidx.camera.video.FileDescriptorOutputOptions;
import androidx.camera.video.FileOutputOptions;
import androidx.camera.video.MediaStoreOutputOptions;
import androidx.camera.video.OutputOptions;
import androidx.camera.video.internal.utils.StorageUtil;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public final class OutputStorageImpl implements OutputStorage {
    private static final Companion Companion = new Companion(null);
    private static final String TAG = "OutputStorageImpl";
    private final OutputOptions outputOptions;

    public OutputStorageImpl(@NotNull OutputOptions outputOptions) {
        Intrinsics.checkNotNullParameter(outputOptions, "outputOptions");
        this.outputOptions = outputOptions;
    }

    @Override // androidx.camera.video.internal.OutputStorage
    public OutputOptions getOutputOptions() {
        return this.outputOptions;
    }

    @Override // androidx.camera.video.internal.OutputStorage
    public long getAvailableBytes() {
        OutputOptions outputOptions = this.outputOptions;
        if (outputOptions instanceof FileOutputOptions) {
            String path = ((FileOutputOptions) outputOptions).getFile().getPath();
            Intrinsics.checkNotNullExpressionValue(path, "outputOptions.file.path");
            return StorageUtil.getAvailableBytes(path);
        }
        if (outputOptions instanceof MediaStoreOutputOptions) {
            Uri collectionUri = ((MediaStoreOutputOptions) outputOptions).getCollectionUri();
            Intrinsics.checkNotNullExpressionValue(collectionUri, "outputOptions.collectionUri");
            return StorageUtil.getAvailableBytesForMediaStoreUri(collectionUri);
        }
        if (outputOptions instanceof FileDescriptorOutputOptions) {
            return Long.MAX_VALUE;
        }
        throw new AssertionError("Unknown OutputOptions: " + this.outputOptions);
    }

    static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
