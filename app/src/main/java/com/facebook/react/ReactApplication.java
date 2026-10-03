package com.facebook.react;

/* JADX INFO: loaded from: classes.dex */
public interface ReactApplication {
    default ReactHost getReactHost() {
        return null;
    }

    ReactNativeHost getReactNativeHost();
}
