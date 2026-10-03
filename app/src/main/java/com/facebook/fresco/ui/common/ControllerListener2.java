package com.facebook.fresco.ui.common;

import android.net.Uri;
import com.facebook.infer.annotation.PropagatesNullable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public interface ControllerListener2<INFO> {
    void onEmptyEvent(@Nullable Object obj);

    void onFailure(@NotNull String str, @Nullable Throwable th, @Nullable Extras extras);

    void onFinalImageSet(@NotNull String str, @Nullable INFO info, @Nullable Extras extras);

    void onIntermediateImageFailed(@NotNull String str);

    void onIntermediateImageSet(@NotNull String str, @Nullable INFO info);

    void onRelease(@NotNull String str, @Nullable Extras extras);

    void onSubmit(@NotNull String str, @Nullable Object obj, @Nullable Extras extras);

    public static final class Extras {
        public static final Companion Companion = new Companion(null);
        public Object callerContext;
        public Map<String, ? extends Object> componentExtras;
        public Map<String, ? extends Object> datasourceExtras;
        public Float focusX;
        public Float focusY;
        public Map<String, ? extends Object> imageExtras;
        public Map<String, ? extends Object> imageSourceExtras;
        public boolean logWithHighSamplingRate;
        public Uri mainUri;
        public String modifiedUriStatus;
        public Uri originalUri;
        public Object scaleType;
        public Map<String, ? extends Object> shortcutExtras;
        public String uiFramework;
        public int viewportWidth = -1;
        public int viewportHeight = -1;

        @JvmStatic
        public static final Extras of(@Nullable Map<String, ? extends Object> map) {
            return Companion.of(map);
        }

        public final Extras makeExtrasCopy() {
            Extras extras = new Extras();
            Companion companion = Companion;
            extras.componentExtras = companion.copyMap(this.componentExtras);
            extras.shortcutExtras = companion.copyMap(this.shortcutExtras);
            extras.datasourceExtras = companion.copyMap(this.datasourceExtras);
            extras.imageExtras = companion.copyMap(this.imageExtras);
            extras.callerContext = this.callerContext;
            extras.mainUri = this.mainUri;
            extras.viewportWidth = this.viewportWidth;
            extras.viewportHeight = this.viewportHeight;
            extras.scaleType = this.scaleType;
            extras.focusX = this.focusX;
            extras.focusY = this.focusY;
            extras.uiFramework = this.uiFramework;
            return extras;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Extras of(@Nullable Map<String, ? extends Object> map) {
                Extras extras = new Extras();
                extras.componentExtras = map;
                return extras;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final Map<String, Object> copyMap(@PropagatesNullable Map<String, ? extends Object> map) {
                if (map != null) {
                    return new ConcurrentHashMap(map);
                }
                return null;
            }
        }
    }
}
