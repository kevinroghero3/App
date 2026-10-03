package com.swmansion.rnscreens.gamma.tabs;

import android.util.Log;

/* JADX INFO: loaded from: classes3.dex */
public final class TabScreenEventEmitterKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void logEventDispatch(int i, String str) {
        Log.d(TabScreenEventEmitter.TAG, "TabScreen [" + i + "] emits event: " + str);
    }
}
