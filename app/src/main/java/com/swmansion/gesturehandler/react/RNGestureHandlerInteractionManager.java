package com.swmansion.gesturehandler.react;

import android.util.SparseArray;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.swmansion.gesturehandler.core.GestureHandler;
import com.swmansion.gesturehandler.core.GestureHandlerInteractionController;
import com.swmansion.gesturehandler.core.NativeViewGestureHandler;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class RNGestureHandlerInteractionManager implements GestureHandlerInteractionController {
    public static final Companion Companion = new Companion(null);
    private static final String KEY_BLOCKS_HANDLERS = "blocksHandlers";
    private static final String KEY_SIMULTANEOUS_HANDLERS = "simultaneousHandlers";
    private static final String KEY_WAIT_FOR = "waitFor";
    private final SparseArray<int[]> waitForRelations = new SparseArray<>();
    private final SparseArray<int[]> simultaneousRelations = new SparseArray<>();
    private final SparseArray<int[]> blockingRelations = new SparseArray<>();

    public final void dropRelationsForHandlerWithTag(int i) {
        this.waitForRelations.remove(i);
        this.simultaneousRelations.remove(i);
    }

    private final int[] convertHandlerTagsArray(ReadableMap readableMap, String str) {
        ReadableArray array = readableMap.getArray(str);
        Intrinsics.checkNotNull(array);
        int size = array.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = array.getInt(i);
        }
        return iArr;
    }

    public final void configureInteractions(@NotNull GestureHandler handler, @NotNull ReadableMap config) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(config, "config");
        handler.setInteractionController(this);
        if (config.hasKey(KEY_WAIT_FOR)) {
            this.waitForRelations.put(handler.getTag(), convertHandlerTagsArray(config, KEY_WAIT_FOR));
        }
        if (config.hasKey(KEY_SIMULTANEOUS_HANDLERS)) {
            this.simultaneousRelations.put(handler.getTag(), convertHandlerTagsArray(config, KEY_SIMULTANEOUS_HANDLERS));
        }
        if (config.hasKey(KEY_BLOCKS_HANDLERS)) {
            this.blockingRelations.put(handler.getTag(), convertHandlerTagsArray(config, KEY_BLOCKS_HANDLERS));
        }
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandlerInteractionController
    public boolean shouldWaitForHandlerFailure(@NotNull GestureHandler handler, @NotNull GestureHandler otherHandler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(otherHandler, "otherHandler");
        int[] iArr = this.waitForRelations.get(handler.getTag());
        if (iArr == null) {
            return false;
        }
        for (int i : iArr) {
            if (i == otherHandler.getTag()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandlerInteractionController
    public boolean shouldRequireHandlerToWaitForFailure(@NotNull GestureHandler handler, @NotNull GestureHandler otherHandler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(otherHandler, "otherHandler");
        int[] iArr = this.blockingRelations.get(handler.getTag());
        if (iArr == null) {
            return false;
        }
        for (int i : iArr) {
            if (i == otherHandler.getTag()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandlerInteractionController
    public boolean shouldHandlerBeCancelledBy(@NotNull GestureHandler handler, @NotNull GestureHandler otherHandler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(otherHandler, "otherHandler");
        if (otherHandler instanceof NativeViewGestureHandler) {
            return ((NativeViewGestureHandler) otherHandler).getDisallowInterruption();
        }
        return otherHandler instanceof RNGestureHandlerRootHelper.RootViewGestureHandler;
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandlerInteractionController
    public boolean shouldRecognizeSimultaneously(@NotNull GestureHandler handler, @NotNull GestureHandler otherHandler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(otherHandler, "otherHandler");
        int[] iArr = this.simultaneousRelations.get(handler.getTag());
        if (iArr == null) {
            return false;
        }
        for (int i : iArr) {
            if (i == otherHandler.getTag()) {
                return true;
            }
        }
        return false;
    }

    public final void reset() {
        this.waitForRelations.clear();
        this.simultaneousRelations.clear();
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
