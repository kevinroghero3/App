package com.facebook.react.modules.core;

import android.view.Choreographer;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.internal.ChoreographerProvider;
import java.util.ArrayDeque;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class ReactChoreographer {
    public static final Companion Companion = new Companion(null);
    private static ReactChoreographer choreographer;
    private final ArrayDeque<Choreographer.FrameCallback>[] callbackQueues;
    private ChoreographerProvider.Choreographer choreographer$1;
    private final Choreographer.FrameCallback frameCallback;
    private boolean hasPostedCallback;
    private int totalCallbacks;

    public /* synthetic */ ReactChoreographer(ChoreographerProvider choreographerProvider, DefaultConstructorMarker defaultConstructorMarker) {
        this(choreographerProvider);
    }

    @JvmStatic
    public static final ReactChoreographer getInstance() {
        return Companion.getInstance();
    }

    @JvmStatic
    public static final void initialize(@NotNull ChoreographerProvider choreographerProvider) {
        Companion.initialize(choreographerProvider);
    }

    public enum CallbackType {
        PERF_MARKERS(0),
        DISPATCH_UI(1),
        NATIVE_ANIMATED_MODULE(2),
        TIMERS_EVENTS(3),
        IDLE_EVENT(4);

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
        private final int order;

        public static EnumEntries<CallbackType> getEntries() {
            return $ENTRIES;
        }

        CallbackType(int i) {
            this.order = i;
        }

        public final int getOrder$ReactAndroid_release() {
            return this.order;
        }
    }

    private ReactChoreographer(final ChoreographerProvider choreographerProvider) {
        int size = CallbackType.getEntries().size();
        ArrayDeque<Choreographer.FrameCallback>[] arrayDequeArr = new ArrayDeque[size];
        for (int i = 0; i < size; i++) {
            arrayDequeArr[i] = new ArrayDeque<>();
        }
        this.callbackQueues = arrayDequeArr;
        this.frameCallback = new Choreographer.FrameCallback() { // from class: com.facebook.react.modules.core.ReactChoreographer$$ExternalSyntheticLambda0
            @Override // android.view.Choreographer.FrameCallback
            public final void doFrame(long j) {
                ReactChoreographer.frameCallback$lambda$1(this.f$0, j);
            }
        };
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.facebook.react.modules.core.ReactChoreographer$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                ReactChoreographer._init_$lambda$2(this.f$0, choreographerProvider);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void frameCallback$lambda$1(ReactChoreographer reactChoreographer, long j) {
        synchronized (reactChoreographer.callbackQueues) {
            reactChoreographer.hasPostedCallback = false;
            int length = reactChoreographer.callbackQueues.length;
            for (int i = 0; i < length; i++) {
                ArrayDeque<Choreographer.FrameCallback> arrayDeque = reactChoreographer.callbackQueues[i];
                int size = arrayDeque.size();
                for (int i2 = 0; i2 < size; i2++) {
                    Choreographer.FrameCallback frameCallbackPollFirst = arrayDeque.pollFirst();
                    if (frameCallbackPollFirst != null) {
                        frameCallbackPollFirst.doFrame(j);
                        reactChoreographer.totalCallbacks--;
                    } else {
                        FLog.e(ReactConstants.TAG, "Tried to execute non-existent frame callback");
                    }
                }
            }
            reactChoreographer.maybeRemoveFrameCallback();
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$2(ReactChoreographer reactChoreographer, ChoreographerProvider choreographerProvider) {
        reactChoreographer.choreographer$1 = choreographerProvider.getChoreographer();
    }

    public final void postFrameCallback(@NotNull CallbackType type, @NotNull Choreographer.FrameCallback callback) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(callback, "callback");
        synchronized (this.callbackQueues) {
            this.callbackQueues[type.getOrder$ReactAndroid_release()].addLast(callback);
            boolean z = true;
            int i = this.totalCallbacks + 1;
            this.totalCallbacks = i;
            if (i <= 0) {
                z = false;
            }
            Assertions.assertCondition(z);
            postFrameCallbackOnChoreographer();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void removeFrameCallback(@NotNull CallbackType type, @Nullable Choreographer.FrameCallback frameCallback) {
        Intrinsics.checkNotNullParameter(type, "type");
        synchronized (this.callbackQueues) {
            if (this.callbackQueues[type.getOrder$ReactAndroid_release()].removeFirstOccurrence(frameCallback)) {
                this.totalCallbacks--;
                maybeRemoveFrameCallback();
            } else {
                FLog.e(ReactConstants.TAG, "Tried to remove non-existent frame callback");
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void postFrameCallbackOnChoreographer() {
        if (this.hasPostedCallback) {
            return;
        }
        ChoreographerProvider.Choreographer choreographer2 = this.choreographer$1;
        if (choreographer2 == null) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.facebook.react.modules.core.ReactChoreographer$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    ReactChoreographer.postFrameCallbackOnChoreographer$lambda$6(this.f$0);
                }
            });
        } else {
            choreographer2.postFrameCallback(this.frameCallback);
            this.hasPostedCallback = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void postFrameCallbackOnChoreographer$lambda$6(ReactChoreographer reactChoreographer) {
        synchronized (reactChoreographer.callbackQueues) {
            reactChoreographer.postFrameCallbackOnChoreographer();
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void maybeRemoveFrameCallback() {
        Assertions.assertCondition(this.totalCallbacks >= 0);
        if (this.totalCallbacks == 0 && this.hasPostedCallback) {
            ChoreographerProvider.Choreographer choreographer2 = this.choreographer$1;
            if (choreographer2 != null) {
                choreographer2.removeFrameCallback(this.frameCallback);
            }
            this.hasPostedCallback = false;
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final void initialize(@NotNull ChoreographerProvider choreographerProvider) {
            Intrinsics.checkNotNullParameter(choreographerProvider, "choreographerProvider");
            if (ReactChoreographer.choreographer == null) {
                ReactChoreographer.choreographer = new ReactChoreographer(choreographerProvider, null);
            }
        }

        @JvmStatic
        public final ReactChoreographer getInstance() {
            ReactChoreographer reactChoreographer = ReactChoreographer.choreographer;
            if (reactChoreographer != null) {
                return reactChoreographer;
            }
            throw new IllegalStateException("ReactChoreographer needs to be initialized.");
        }

        @VisibleForTesting
        public final ReactChoreographer overrideInstanceForTest$ReactAndroid_release(@Nullable ReactChoreographer reactChoreographer) {
            ReactChoreographer reactChoreographer2 = ReactChoreographer.choreographer;
            Companion companion = ReactChoreographer.Companion;
            ReactChoreographer.choreographer = reactChoreographer;
            return reactChoreographer2;
        }
    }
}
