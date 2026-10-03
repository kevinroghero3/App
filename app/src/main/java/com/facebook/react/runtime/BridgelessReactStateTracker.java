package com.facebook.react.runtime;

import com.facebook.common.logging.FLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public final class BridgelessReactStateTracker {
    private static final Companion Companion = new Companion(null);
    private static final String TAG = "BridgelessReact";
    private final boolean shouldTrackStates;
    private final List<String> states = Collections.synchronizedList(new ArrayList());

    public BridgelessReactStateTracker(boolean z) {
        this.shouldTrackStates = z;
    }

    protected final void enterState(@NotNull String state) {
        Intrinsics.checkNotNullParameter(state, "state");
        FLog.w(TAG, state);
        if (this.shouldTrackStates) {
            this.states.add(state);
        }
    }

    static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
