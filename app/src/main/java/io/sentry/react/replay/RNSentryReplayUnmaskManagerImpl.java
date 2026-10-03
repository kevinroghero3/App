package io.sentry.react.replay;

import androidx.annotation.NonNull;
import com.facebook.react.uimanager.ThemedReactContext;

/* JADX INFO: loaded from: classes6.dex */
public final class RNSentryReplayUnmaskManagerImpl {
    public static final String REACT_CLASS = "RNSentryReplayUnmask";

    private RNSentryReplayUnmaskManagerImpl() {
    }

    public RNSentryReplayUnmask createViewInstance(@NonNull ThemedReactContext themedReactContext) {
        return new RNSentryReplayUnmask(themedReactContext);
    }
}
