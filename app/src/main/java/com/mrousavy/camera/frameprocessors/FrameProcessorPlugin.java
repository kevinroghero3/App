package com.mrousavy.camera.frameprocessors;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public abstract class FrameProcessorPlugin {
    public abstract Object callback(@NonNull Frame frame, @Nullable Map<String, Object> map) throws Throwable;
}
