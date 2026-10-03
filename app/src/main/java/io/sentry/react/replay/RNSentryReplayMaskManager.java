package io.sentry.react.replay;

import androidx.annotation.NonNull;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;

/* JADX INFO: loaded from: classes3.dex */
@ReactModule(name = RNSentryReplayMaskManagerImpl.REACT_CLASS)
public class RNSentryReplayMaskManager extends ViewGroupManager<RNSentryReplayMask> {
    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return RNSentryReplayMaskManagerImpl.REACT_CLASS;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public RNSentryReplayMask createViewInstance(@NonNull ThemedReactContext themedReactContext) {
        return new RNSentryReplayMask(themedReactContext);
    }
}
