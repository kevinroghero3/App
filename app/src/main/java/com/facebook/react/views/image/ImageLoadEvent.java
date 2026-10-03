package com.facebook.react.views.image;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.horcrux.svg.events.SvgLoadEvent;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class ImageLoadEvent extends Event<ImageLoadEvent> {
    public static final Companion Companion = new Companion(null);
    public static final int ON_ERROR = 1;
    public static final int ON_LOAD = 2;
    public static final int ON_LOAD_END = 3;
    public static final int ON_LOAD_START = 4;
    public static final int ON_PROGRESS = 5;
    private final String errorMessage;
    private final int eventType;
    private final int height;
    private final int loaded;
    private final String sourceUri;
    private final int total;
    private final int width;

    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface ImageEventType {
    }

    public /* synthetic */ ImageLoadEvent(int i, int i2, int i3, String str, String str2, int i4, int i5, int i6, int i7, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3, str, str2, i4, i5, i6, i7);
    }

    @JvmStatic
    public static final ImageLoadEvent createErrorEvent(int i, int i2, @NotNull Throwable th) {
        return Companion.createErrorEvent(i, i2, th);
    }

    @Deprecated(message = "Use the createErrorEvent version that explicitly takes surfaceId as an argument", replaceWith = @ReplaceWith(expression = "createErrorEvent(surfaceId, viewId, throwable)", imports = {}))
    @JvmStatic
    public static final ImageLoadEvent createErrorEvent(int i, @NotNull Throwable th) {
        return Companion.createErrorEvent(i, th);
    }

    @Deprecated(message = "Use the createLoadEndEvent version that explicitly takes surfaceId as an argument", replaceWith = @ReplaceWith(expression = "createLoadEndEvent(surfaceId, viewId)", imports = {}))
    @JvmStatic
    public static final ImageLoadEvent createLoadEndEvent(int i) {
        return Companion.createLoadEndEvent(i);
    }

    @JvmStatic
    public static final ImageLoadEvent createLoadEndEvent(int i, int i2) {
        return Companion.createLoadEndEvent(i, i2);
    }

    @JvmStatic
    public static final ImageLoadEvent createLoadEvent(int i, int i2, @Nullable String str, int i3, int i4) {
        return Companion.createLoadEvent(i, i2, str, i3, i4);
    }

    @Deprecated(message = "Use the createLoadEvent version that explicitly takes surfaceId as an argument", replaceWith = @ReplaceWith(expression = "createLoadEvent(surfaceId, viewId, imageUri, width, height)", imports = {}))
    @JvmStatic
    public static final ImageLoadEvent createLoadEvent(int i, @Nullable String str, int i2, int i3) {
        return Companion.createLoadEvent(i, str, i2, i3);
    }

    @Deprecated(message = "Use the createLoadStartEvent version that explicitly takes surfaceId as an argument", replaceWith = @ReplaceWith(expression = "createLoadStartEvent(surfaceId, viewId)", imports = {}))
    @JvmStatic
    public static final ImageLoadEvent createLoadStartEvent(int i) {
        return Companion.createLoadStartEvent(i);
    }

    @JvmStatic
    public static final ImageLoadEvent createLoadStartEvent(int i, int i2) {
        return Companion.createLoadStartEvent(i, i2);
    }

    @JvmStatic
    public static final ImageLoadEvent createProgressEvent(int i, int i2, @Nullable String str, int i3, int i4) {
        return Companion.createProgressEvent(i, i2, str, i3, i4);
    }

    @Deprecated(message = "Use the createProgressEvent version that explicitly takes surfaceId as an argument", replaceWith = @ReplaceWith(expression = "createProgressEvent(surfaceId, viewId, imageUri, loaded, total)", imports = {}))
    @JvmStatic
    public static final ImageLoadEvent createProgressEvent(int i, @Nullable String str, int i2, int i3) {
        return Companion.createProgressEvent(i, str, i2, i3);
    }

    @JvmStatic
    public static final String eventNameForType(int i) {
        return Companion.eventNameForType(i);
    }

    /* synthetic */ ImageLoadEvent(int i, int i2, int i3, String str, String str2, int i4, int i5, int i6, int i7, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3, (i8 & 8) != 0 ? null : str, (i8 & 16) != 0 ? null : str2, (i8 & 32) != 0 ? 0 : i4, (i8 & 64) != 0 ? 0 : i5, (i8 & 128) != 0 ? 0 : i6, (i8 & 256) != 0 ? 0 : i7);
    }

    private ImageLoadEvent(int i, int i2, int i3, String str, String str2, int i4, int i5, int i6, int i7) {
        super(i, i2);
        this.eventType = i3;
        this.errorMessage = str;
        this.sourceUri = str2;
        this.width = i4;
        this.height = i5;
        this.loaded = i6;
        this.total = i7;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return Companion.eventNameForType(this.eventType);
    }

    @Override // com.facebook.react.uimanager.events.Event
    public short getCoalescingKey() {
        return (short) this.eventType;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public WritableMap getEventData() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        int i = this.eventType;
        if (i == 1) {
            writableMapCreateMap.putString("error", this.errorMessage);
        } else if (i == 2) {
            writableMapCreateMap.putMap("source", createEventDataSource());
        } else if (i == 5) {
            writableMapCreateMap.putInt("loaded", this.loaded);
            writableMapCreateMap.putInt("total", this.total);
            writableMapCreateMap.putDouble("progress", ((double) this.loaded) / ((double) this.total));
        }
        return writableMapCreateMap;
    }

    private final WritableMap createEventDataSource() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("uri", this.sourceUri);
        writableMapCreateMap.putDouble("width", this.width);
        writableMapCreateMap.putDouble("height", this.height);
        Intrinsics.checkNotNullExpressionValue(writableMapCreateMap, "apply(...)");
        return writableMapCreateMap;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Deprecated(message = "Use the createLoadStartEvent version that explicitly takes surfaceId as an argument", replaceWith = @ReplaceWith(expression = "createLoadStartEvent(surfaceId, viewId)", imports = {}))
        @JvmStatic
        public final ImageLoadEvent createLoadStartEvent(int i) {
            return createLoadStartEvent(-1, i);
        }

        @Deprecated(message = "Use the createProgressEvent version that explicitly takes surfaceId as an argument", replaceWith = @ReplaceWith(expression = "createProgressEvent(surfaceId, viewId, imageUri, loaded, total)", imports = {}))
        @JvmStatic
        public final ImageLoadEvent createProgressEvent(int i, @Nullable String str, int i2, int i3) {
            return createProgressEvent(-1, i, str, i2, i3);
        }

        @Deprecated(message = "Use the createLoadEvent version that explicitly takes surfaceId as an argument", replaceWith = @ReplaceWith(expression = "createLoadEvent(surfaceId, viewId, imageUri, width, height)", imports = {}))
        @JvmStatic
        public final ImageLoadEvent createLoadEvent(int i, @Nullable String str, int i2, int i3) {
            return createLoadEvent(-1, i, str, i2, i3);
        }

        @Deprecated(message = "Use the createErrorEvent version that explicitly takes surfaceId as an argument", replaceWith = @ReplaceWith(expression = "createErrorEvent(surfaceId, viewId, throwable)", imports = {}))
        @JvmStatic
        public final ImageLoadEvent createErrorEvent(int i, @NotNull Throwable throwable) {
            Intrinsics.checkNotNullParameter(throwable, "throwable");
            return createErrorEvent(-1, i, throwable);
        }

        @Deprecated(message = "Use the createLoadEndEvent version that explicitly takes surfaceId as an argument", replaceWith = @ReplaceWith(expression = "createLoadEndEvent(surfaceId, viewId)", imports = {}))
        @JvmStatic
        public final ImageLoadEvent createLoadEndEvent(int i) {
            return createLoadEndEvent(-1, i);
        }

        @JvmStatic
        public final ImageLoadEvent createLoadStartEvent(int i, int i2) {
            return new ImageLoadEvent(i, i2, 4, null, null, 0, 0, 0, 0, TypedValues.PositionType.TYPE_PERCENT_HEIGHT, null);
        }

        @JvmStatic
        public final ImageLoadEvent createProgressEvent(int i, int i2, @Nullable String str, int i3, int i4) {
            return new ImageLoadEvent(i, i2, 5, null, str, 0, 0, i3, i4, null);
        }

        @JvmStatic
        public final ImageLoadEvent createLoadEvent(int i, int i2, @Nullable String str, int i3, int i4) {
            return new ImageLoadEvent(i, i2, 2, null, str, i3, i4, 0, 0, null);
        }

        @JvmStatic
        public final ImageLoadEvent createErrorEvent(int i, int i2, @NotNull Throwable throwable) {
            Intrinsics.checkNotNullParameter(throwable, "throwable");
            return new ImageLoadEvent(i, i2, 1, throwable.getMessage(), null, 0, 0, 0, 0, null);
        }

        @JvmStatic
        public final ImageLoadEvent createLoadEndEvent(int i, int i2) {
            return new ImageLoadEvent(i, i2, 3, null, null, 0, 0, 0, 0, TypedValues.PositionType.TYPE_PERCENT_HEIGHT, null);
        }

        @JvmStatic
        public final String eventNameForType(int i) {
            if (i == 1) {
                return "topError";
            }
            if (i == 2) {
                return SvgLoadEvent.EVENT_NAME;
            }
            if (i == 3) {
                return "topLoadEnd";
            }
            if (i == 4) {
                return "topLoadStart";
            }
            if (i == 5) {
                return "topProgress";
            }
            throw new IllegalStateException(("Invalid image event: " + i).toString());
        }
    }
}
