package com.swmansion.rnscreens;

import com.facebook.react.module.annotations.ReactModule;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
@ReactModule(name = ModalScreenViewManager.REACT_CLASS)
public final class ModalScreenViewManager extends ScreenViewManager {
    public static final Companion Companion = new Companion(null);
    public static final String REACT_CLASS = "RNSModalScreen";

    @Override // com.swmansion.rnscreens.ScreenViewManager, com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
