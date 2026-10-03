package io.sentry.android.core;

import io.sentry.protocol.DebugImage;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes6.dex */
public interface IDebugImagesLoader {
    void clearDebugImages();

    List<DebugImage> loadDebugImages();

    Set<DebugImage> loadDebugImagesForAddresses(Set<String> set);
}
