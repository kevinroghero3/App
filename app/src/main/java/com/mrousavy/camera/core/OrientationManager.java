package com.mrousavy.camera.core;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.util.Log;
import android.view.Display;
import android.view.OrientationEventListener;
import com.mrousavy.camera.core.types.Orientation;
import com.mrousavy.camera.core.types.OutputOrientation;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class OrientationManager {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "OrientationManager";
    private final Callback callback;
    private final Context context;
    private int deviceRotation;
    private final OrientationManager$displayListener$1 displayListener;
    private final DisplayManager displayManager;
    private Orientation lastOutputOrientation;
    private Orientation lastPreviewOrientation;
    private final OrientationManager$orientationListener$1 orientationListener;
    private int screenRotation;
    private OutputOrientation targetOutputOrientation;

    public interface Callback {
        void onOutputOrientationChanged(@NotNull Orientation orientation);

        void onPreviewOrientationChanged(@NotNull Orientation orientation);
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[OutputOrientation.values().length];
            try {
                iArr[OutputOrientation.DEVICE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[OutputOrientation.PREVIEW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int degreesToSurfaceRotation(int i) {
        if (45 <= i && i < 136) {
            return 3;
        }
        if (135 > i || i >= 226) {
            return (225 > i || i >= 316) ? 0 : 1;
        }
        return 2;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Type inference failed for: r3v5, types: [com.mrousavy.camera.core.OrientationManager$displayListener$1] */
    /* JADX WARN: Type inference failed for: r3v6, types: [com.mrousavy.camera.core.OrientationManager$orientationListener$1] */
    public OrientationManager(@NotNull final Context context, @NotNull Callback callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.context = context;
        this.callback = callback;
        this.targetOutputOrientation = OutputOrientation.DEVICE;
        Object systemService = context.getSystemService("display");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.hardware.display.DisplayManager");
        this.displayManager = (DisplayManager) systemService;
        this.displayListener = new DisplayManager.DisplayListener() { // from class: com.mrousavy.camera.core.OrientationManager$displayListener$1
            @Override // android.hardware.display.DisplayManager.DisplayListener
            public void onDisplayAdded(int i) {
            }

            @Override // android.hardware.display.DisplayManager.DisplayListener
            public void onDisplayRemoved(int i) {
            }

            @Override // android.hardware.display.DisplayManager.DisplayListener
            public void onDisplayChanged(int i) {
                Display display = this.this$0.displayManager.getDisplay(i);
                if (display == null) {
                    return;
                }
                this.this$0.screenRotation = display.getRotation();
                this.this$0.maybeNotifyOrientationChanged();
            }
        };
        this.orientationListener = new OrientationEventListener(context) { // from class: com.mrousavy.camera.core.OrientationManager$orientationListener$1
            @Override // android.view.OrientationEventListener
            public void onOrientationChanged(int i) {
                if (i == -1) {
                    return;
                }
                OrientationManager orientationManager = this.this$0;
                orientationManager.deviceRotation = orientationManager.degreesToSurfaceRotation(i);
                this.this$0.maybeNotifyOrientationChanged();
            }
        };
    }

    public final Orientation getPreviewOrientation() {
        return Orientation.Companion.fromSurfaceRotation(this.screenRotation);
    }

    public final Orientation getOutputOrientation() {
        int i = WhenMappings.$EnumSwitchMapping$0[this.targetOutputOrientation.ordinal()];
        if (i == 1) {
            return Orientation.Companion.fromSurfaceRotation(this.deviceRotation);
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        return getPreviewOrientation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void maybeNotifyOrientationChanged() {
        Orientation previewOrientation = getPreviewOrientation();
        if (this.lastPreviewOrientation != previewOrientation) {
            this.callback.onPreviewOrientationChanged(previewOrientation);
            this.lastPreviewOrientation = previewOrientation;
        }
        Orientation outputOrientation = getOutputOrientation();
        if (this.lastOutputOrientation != outputOrientation) {
            this.callback.onOutputOrientationChanged(outputOrientation);
            this.lastOutputOrientation = outputOrientation;
        }
    }

    public final void stopOrientationUpdates() {
        this.displayManager.unregisterDisplayListener(this.displayListener);
        disable();
    }

    public final void setTargetOutputOrientation(@NotNull OutputOrientation targetOrientation) {
        Intrinsics.checkNotNullParameter(targetOrientation, "targetOrientation");
        Log.i(TAG, "Target Orientation changed " + this.targetOutputOrientation + " -> " + targetOrientation + "!");
        this.targetOutputOrientation = targetOrientation;
        stopOrientationUpdates();
        int i = WhenMappings.$EnumSwitchMapping$0[targetOrientation.ordinal()];
        if (i == 1) {
            Log.i(TAG, "Starting streaming device and screen orientation updates...");
            enable();
            this.displayManager.registerDisplayListener(this.displayListener, null);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            Log.i(TAG, "Starting streaming device and screen orientation updates...");
            this.displayManager.registerDisplayListener(this.displayListener, null);
        }
    }
}
