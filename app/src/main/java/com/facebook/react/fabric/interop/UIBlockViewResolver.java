package com.facebook.react.fabric.interop;

import android.view.View;
import com.facebook.react.common.annotations.UnstableReactNativeAPI;
import kotlin.Deprecated;

/* JADX INFO: loaded from: classes.dex */
@Deprecated(message = "Use UIManagerListener or View Commands instead of addUIBlock and prependUIBlock.")
@UnstableReactNativeAPI
public interface UIBlockViewResolver {
    View resolveView(int i);
}
