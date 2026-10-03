package androidx.camera.video;

import android.content.Context;
import androidx.camera.core.impl.utils.ContextUtil;
import androidx.core.content.PermissionChecker;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class PendingRecording {
    private final Context applicationContext;
    private Consumer<VideoRecordEvent> eventListener;
    private boolean isAudioEnabled;
    private boolean isAudioInitialMuted;
    private boolean isPersistent;
    private Executor listenerExecutor;
    private final OutputOptions outputOptions;
    private final Recorder recorder;

    public final PendingRecording withAudioEnabled() {
        return withAudioEnabled$default(this, false, 1, null);
    }

    public PendingRecording(@NotNull Context context, @NotNull Recorder recorder, @NotNull OutputOptions outputOptions) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(recorder, "recorder");
        Intrinsics.checkNotNullParameter(outputOptions, "outputOptions");
        this.recorder = recorder;
        this.outputOptions = outputOptions;
        Context applicationContext = ContextUtil.getApplicationContext(context);
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(context)");
        this.applicationContext = applicationContext;
    }

    public final Context getApplicationContext() {
        return this.applicationContext;
    }

    public final Recorder getRecorder() {
        return this.recorder;
    }

    public final OutputOptions getOutputOptions() {
        return this.outputOptions;
    }

    public final Executor getListenerExecutor() {
        return this.listenerExecutor;
    }

    public final Consumer<VideoRecordEvent> getEventListener() {
        return this.eventListener;
    }

    public final boolean isAudioEnabled() {
        return this.isAudioEnabled;
    }

    public final boolean isAudioInitialMuted() {
        return this.isAudioInitialMuted;
    }

    public final boolean isPersistent() {
        return this.isPersistent;
    }

    public static /* synthetic */ PendingRecording withAudioEnabled$default(PendingRecording pendingRecording, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return pendingRecording.withAudioEnabled(z);
    }

    public final PendingRecording withAudioEnabled(boolean z) {
        if (PermissionChecker.checkSelfPermission(this.applicationContext, "android.permission.RECORD_AUDIO") == -1) {
            throw new SecurityException("Attempted to enable audio for recording but application does not have RECORD_AUDIO permission granted.");
        }
        Preconditions.checkState(this.recorder.isAudioSupported(), "The Recorder this recording is associated to doesn't support audio.");
        this.isAudioEnabled = true;
        this.isAudioInitialMuted = z;
        return this;
    }

    public final PendingRecording asPersistentRecording() {
        this.isPersistent = true;
        return this;
    }

    public final Recording start(@NotNull Executor listenerExecutor, @NotNull Consumer<VideoRecordEvent> listener) {
        Intrinsics.checkNotNullParameter(listenerExecutor, "listenerExecutor");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Preconditions.checkNotNull(listenerExecutor, "Listener Executor can't be null.");
        Preconditions.checkNotNull(listener, "Event listener can't be null");
        this.listenerExecutor = listenerExecutor;
        this.eventListener = listener;
        Recording recordingStart = this.recorder.start(this);
        Intrinsics.checkNotNullExpressionValue(recordingStart, "recorder.start(this)");
        return recordingStart;
    }
}
