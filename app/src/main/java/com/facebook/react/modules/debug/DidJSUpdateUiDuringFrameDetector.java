package com.facebook.react.modules.debug;

import com.facebook.react.bridge.NotThreadSafeBridgeIdleDebugListener;
import com.facebook.react.uimanager.debug.NotThreadSafeViewHierarchyUpdateDebugListener;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class DidJSUpdateUiDuringFrameDetector implements NotThreadSafeBridgeIdleDebugListener, NotThreadSafeViewHierarchyUpdateDebugListener {
    private final ArrayList<Long> transitionToIdleEvents = new ArrayList<>(20);
    private final ArrayList<Long> transitionToBusyEvents = new ArrayList<>(20);
    private final ArrayList<Long> viewHierarchyUpdateEnqueuedEvents = new ArrayList<>(20);
    private final ArrayList<Long> viewHierarchyUpdateFinishedEvents = new ArrayList<>(20);
    private volatile boolean wasIdleAtEndOfLastFrame = true;

    @Override // com.facebook.react.bridge.NotThreadSafeBridgeIdleDebugListener
    public void onTransitionToBridgeIdle() {
        synchronized (this) {
            this.transitionToIdleEvents.add(Long.valueOf(System.nanoTime()));
        }
    }

    @Override // com.facebook.react.bridge.NotThreadSafeBridgeIdleDebugListener
    public void onTransitionToBridgeBusy() {
        synchronized (this) {
            this.transitionToBusyEvents.add(Long.valueOf(System.nanoTime()));
        }
    }

    @Override // com.facebook.react.bridge.NotThreadSafeBridgeIdleDebugListener
    public void onBridgeDestroyed() {
        synchronized (this) {
        }
    }

    @Override // com.facebook.react.uimanager.debug.NotThreadSafeViewHierarchyUpdateDebugListener
    public void onViewHierarchyUpdateEnqueued() {
        synchronized (this) {
            this.viewHierarchyUpdateEnqueuedEvents.add(Long.valueOf(System.nanoTime()));
        }
    }

    @Override // com.facebook.react.uimanager.debug.NotThreadSafeViewHierarchyUpdateDebugListener
    public void onViewHierarchyUpdateFinished() {
        synchronized (this) {
            this.viewHierarchyUpdateFinishedEvents.add(Long.valueOf(System.nanoTime()));
        }
    }

    public final boolean getDidJSHitFrameAndCleanup(long j, long j2) {
        boolean z;
        synchronized (this) {
            boolean zHasEventBetweenTimestamps = DidJSUpdateUiDuringFrameDetectorKt.hasEventBetweenTimestamps(this.viewHierarchyUpdateFinishedEvents, j, j2);
            boolean zDidEndFrameIdle = didEndFrameIdle(j, j2);
            z = zHasEventBetweenTimestamps || (zDidEndFrameIdle && !DidJSUpdateUiDuringFrameDetectorKt.hasEventBetweenTimestamps(this.viewHierarchyUpdateEnqueuedEvents, j, j2));
            DidJSUpdateUiDuringFrameDetectorKt.cleanUp(this.transitionToIdleEvents, j2);
            DidJSUpdateUiDuringFrameDetectorKt.cleanUp(this.transitionToBusyEvents, j2);
            DidJSUpdateUiDuringFrameDetectorKt.cleanUp(this.viewHierarchyUpdateEnqueuedEvents, j2);
            DidJSUpdateUiDuringFrameDetectorKt.cleanUp(this.viewHierarchyUpdateFinishedEvents, j2);
            this.wasIdleAtEndOfLastFrame = zDidEndFrameIdle;
        }
        return z;
    }

    private final boolean didEndFrameIdle(long j, long j2) {
        long lastEventBetweenTimestamps = DidJSUpdateUiDuringFrameDetectorKt.getLastEventBetweenTimestamps(this.transitionToIdleEvents, j, j2);
        long lastEventBetweenTimestamps2 = DidJSUpdateUiDuringFrameDetectorKt.getLastEventBetweenTimestamps(this.transitionToBusyEvents, j, j2);
        if (lastEventBetweenTimestamps == -1 && lastEventBetweenTimestamps2 == -1) {
            return this.wasIdleAtEndOfLastFrame;
        }
        return lastEventBetweenTimestamps > lastEventBetweenTimestamps2;
    }
}
