package io.sentry;

import io.sentry.protocol.SdkVersion;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public interface IOptionsObserver {
    void setDist(@Nullable String str);

    void setEnvironment(@Nullable String str);

    void setProguardUuid(@Nullable String str);

    void setRelease(@Nullable String str);

    void setReplayErrorSampleRate(@Nullable Double d);

    void setSdkVersion(@Nullable SdkVersion sdkVersion);

    void setTags(@NotNull Map<String, String> map);
}
