package com.facebook.react.uimanager.events;

import android.os.Handler;
import android.view.Choreographer;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactNoCrashSoftException;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.internal.featureflags.ReactNativeFeatureFlags;
import com.facebook.react.modules.core.ReactChoreographer;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.systrace.Systrace;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Deprecated;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public class FabricEventDispatcher implements EventDispatcher, LifecycleEventListener {
    private static final Companion Companion = new Companion(null);
    private static final Handler uiThreadHandler;
    private final ScheduleDispatchFrameCallback currentFrameCallback;
    private final Runnable dispatchEventsRunnable;
    private boolean isDispatchScheduled;
    private final CopyOnWriteArrayList<EventDispatcherListener> listeners;
    private final CopyOnWriteArrayList<BatchEventDispatchedListener> postEventDispatchListeners;
    private final ReactApplicationContext reactContext;
    private final ReactEventEmitter reactEventEmitter;

    public FabricEventDispatcher(@NotNull ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.reactContext = reactContext;
        this.listeners = new CopyOnWriteArrayList<>();
        this.postEventDispatchListeners = new CopyOnWriteArrayList<>();
        this.currentFrameCallback = new ScheduleDispatchFrameCallback();
        this.dispatchEventsRunnable = new Runnable() { // from class: com.facebook.react.uimanager.events.FabricEventDispatcher$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                FabricEventDispatcher.dispatchEventsRunnable$lambda$0(this.f$0);
            }
        };
        reactContext.addLifecycleEventListener(this);
        this.reactEventEmitter = new ReactEventEmitter(reactContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dispatchEventsRunnable$lambda$0(FabricEventDispatcher fabricEventDispatcher) {
        fabricEventDispatcher.isDispatchScheduled = false;
        Systrace.beginSection(0L, "BatchEventDispatchedListeners");
        try {
            Iterator<BatchEventDispatchedListener> it2 = fabricEventDispatcher.postEventDispatchListeners.iterator();
            Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
            while (it2.hasNext()) {
                it2.next().onBatchEventDispatched();
            }
            Systrace.endSection(0L);
        } catch (Throwable th) {
            Systrace.endSection(0L);
            throw th;
        }
    }

    @Override // com.facebook.react.uimanager.events.EventDispatcher
    public void dispatchEvent(@NotNull Event<?> event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Iterator<EventDispatcherListener> it2 = this.listeners.iterator();
        Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
        while (it2.hasNext()) {
            it2.next().onEventDispatch(event);
        }
        if (event.experimental_isSynchronous()) {
            dispatchSynchronous(event);
        } else {
            event.dispatchModern(this.reactEventEmitter);
        }
        event.dispose();
        scheduleDispatchOfBatchedEvents();
    }

    private final void dispatchSynchronous(Event<?> event) {
        Systrace.beginSection(0L, "FabricEventDispatcher.dispatchSynchronous('" + event.getEventName() + "')");
        try {
            UIManager uIManager = UIManagerHelper.getUIManager(this.reactContext, 2);
            if (uIManager instanceof SynchronousEventReceiver) {
                int surfaceId = event.getSurfaceId();
                int viewTag = event.getViewTag();
                String eventName = event.getEventName();
                Intrinsics.checkNotNullExpressionValue(eventName, "getEventName(...)");
                ((SynchronousEventReceiver) uIManager).receiveEvent(surfaceId, viewTag, eventName, event.canCoalesce(), event.getEventData(), event.getEventCategory(), true);
            } else {
                ReactSoftExceptionLogger.logSoftException("FabricEventDispatcher", new ReactNoCrashSoftException("Fabric UIManager expected to implement SynchronousEventReceiver."));
            }
        } finally {
            Systrace.endSection(0L);
        }
    }

    @Override // com.facebook.react.uimanager.events.EventDispatcher
    public void dispatchAllEvents() {
        scheduleDispatchOfBatchedEvents();
    }

    private final void scheduleDispatchOfBatchedEvents() {
        if (ReactNativeFeatureFlags.useOptimizedEventBatchingOnAndroid()) {
            if (this.isDispatchScheduled) {
                return;
            }
            this.isDispatchScheduled = true;
            uiThreadHandler.postAtFrontOfQueue(this.dispatchEventsRunnable);
            return;
        }
        this.currentFrameCallback.maybeScheduleDispatchOfBatchedEvents();
    }

    @Override // com.facebook.react.uimanager.events.EventDispatcher
    public void addListener(@NotNull EventDispatcherListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners.add(listener);
    }

    @Override // com.facebook.react.uimanager.events.EventDispatcher
    public void removeListener(@NotNull EventDispatcherListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners.remove(listener);
    }

    @Override // com.facebook.react.uimanager.events.EventDispatcher
    public void addBatchEventDispatchedListener(@NotNull BatchEventDispatchedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.postEventDispatchListeners.add(listener);
    }

    @Override // com.facebook.react.uimanager.events.EventDispatcher
    public void removeBatchEventDispatchedListener(@NotNull BatchEventDispatchedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.postEventDispatchListeners.remove(listener);
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostResume() {
        scheduleDispatchOfBatchedEvents();
        if (ReactNativeFeatureFlags.useOptimizedEventBatchingOnAndroid()) {
            return;
        }
        this.currentFrameCallback.resume();
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostPause() {
        cancelDispatchOfBatchedEvents();
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostDestroy() {
        cancelDispatchOfBatchedEvents();
    }

    @Override // com.facebook.react.uimanager.events.EventDispatcher
    public void onCatalystInstanceDestroyed() {
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.facebook.react.uimanager.events.FabricEventDispatcher$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.cancelDispatchOfBatchedEvents();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cancelDispatchOfBatchedEvents() {
        UiThreadUtil.assertOnUiThread();
        if (ReactNativeFeatureFlags.useOptimizedEventBatchingOnAndroid()) {
            this.isDispatchScheduled = false;
            uiThreadHandler.removeCallbacks(this.dispatchEventsRunnable);
        } else {
            this.currentFrameCallback.stop();
        }
    }

    @Override // com.facebook.react.uimanager.events.EventDispatcher
    @Deprecated(message = "Use the modern version with RCTModernEventEmitter")
    public void registerEventEmitter(int i, @NotNull RCTEventEmitter eventEmitter) {
        Intrinsics.checkNotNullParameter(eventEmitter, "eventEmitter");
        this.reactEventEmitter.register(i, eventEmitter);
    }

    @Override // com.facebook.react.uimanager.events.EventDispatcher
    public void registerEventEmitter(int i, @NotNull RCTModernEventEmitter eventEmitter) {
        Intrinsics.checkNotNullParameter(eventEmitter, "eventEmitter");
        this.reactEventEmitter.register(i, eventEmitter);
    }

    @Override // com.facebook.react.uimanager.events.EventDispatcher
    public void unregisterEventEmitter(int i) {
        this.reactEventEmitter.unregister(i);
    }

    final class ScheduleDispatchFrameCallback implements Choreographer.FrameCallback {
        private volatile boolean isFrameCallbackDispatchScheduled;
        private boolean shouldStop;

        public ScheduleDispatchFrameCallback() {
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            UiThreadUtil.assertOnUiThread();
            if (this.shouldStop) {
                this.isFrameCallbackDispatchScheduled = false;
            } else {
                dispatchBatchedEvents();
            }
            Systrace.beginSection(0L, "BatchEventDispatchedListeners");
            try {
                Iterator it2 = FabricEventDispatcher.this.postEventDispatchListeners.iterator();
                Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
                while (it2.hasNext()) {
                    ((BatchEventDispatchedListener) it2.next()).onBatchEventDispatched();
                }
                Systrace.endSection(0L);
            } catch (Throwable th) {
                Systrace.endSection(0L);
                throw th;
            }
        }

        public final void stop() {
            this.shouldStop = true;
        }

        public final void resume() {
            this.shouldStop = false;
        }

        public final void maybeDispatchBatchedEvents() {
            if (this.isFrameCallbackDispatchScheduled) {
                return;
            }
            this.isFrameCallbackDispatchScheduled = true;
            dispatchBatchedEvents();
        }

        private final void dispatchBatchedEvents() {
            ReactChoreographer.Companion.getInstance().postFrameCallback(ReactChoreographer.CallbackType.TIMERS_EVENTS, FabricEventDispatcher.this.currentFrameCallback);
        }

        public final void maybeScheduleDispatchOfBatchedEvents() {
            if (this.isFrameCallbackDispatchScheduled) {
                return;
            }
            if (!FabricEventDispatcher.this.reactContext.isOnUiQueueThread()) {
                FabricEventDispatcher.this.reactContext.runOnUiQueueThread(new Runnable() { // from class: com.facebook.react.uimanager.events.FabricEventDispatcher$ScheduleDispatchFrameCallback$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.maybeDispatchBatchedEvents();
                    }
                });
            } else {
                maybeDispatchBatchedEvents();
            }
        }
    }

    static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Handler uiThreadHandler2 = UiThreadUtil.getUiThreadHandler();
        Intrinsics.checkNotNullExpressionValue(uiThreadHandler2, "getUiThreadHandler(...)");
        uiThreadHandler = uiThreadHandler2;
    }
}
