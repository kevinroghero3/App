package com.facebook.react.views.scroll;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.PixelUtil;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class ReactScrollViewCommandHelper {
    public static final int COMMAND_FLASH_SCROLL_INDICATORS = 3;
    public static final int COMMAND_SCROLL_TO = 1;
    public static final int COMMAND_SCROLL_TO_END = 2;
    public static final Companion Companion = new Companion(null);

    public interface ScrollCommandHandler<T> {
        void flashScrollIndicators(T t);

        void scrollTo(T t, @NotNull ScrollToCommandData scrollToCommandData);

        void scrollToEnd(T t, @NotNull ScrollToEndCommandData scrollToEndCommandData);
    }

    @JvmStatic
    public static final Map<String, Integer> getCommandsMap() {
        return Companion.getCommandsMap();
    }

    @JvmStatic
    public static final <T> void receiveCommand(@NotNull ScrollCommandHandler<T> scrollCommandHandler, T t, int i, @Nullable ReadableArray readableArray) {
        Companion.receiveCommand(scrollCommandHandler, t, i, readableArray);
    }

    @JvmStatic
    public static final <T> void receiveCommand(@NotNull ScrollCommandHandler<T> scrollCommandHandler, T t, @NotNull String str, @Nullable ReadableArray readableArray) {
        Companion.receiveCommand(scrollCommandHandler, t, str, readableArray);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final Map<String, Integer> getCommandsMap() {
            return MapsKt__MapsKt.hashMapOf(TuplesKt.to("scrollTo", 1), TuplesKt.to("scrollToEnd", 2), TuplesKt.to("flashScrollIndicators", 3));
        }

        @JvmStatic
        public final <T> void receiveCommand(@NotNull ScrollCommandHandler<T> viewManager, T t, int i, @Nullable ReadableArray readableArray) {
            Intrinsics.checkNotNullParameter(viewManager, "viewManager");
            if (t == null) {
                throw new IllegalStateException("Required value was null.");
            }
            if (i == 1) {
                if (readableArray == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                scrollTo(viewManager, t, readableArray);
                return;
            }
            if (i == 2) {
                if (readableArray == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                scrollToEnd(viewManager, t, readableArray);
            } else {
                if (i == 3) {
                    viewManager.flashScrollIndicators(t);
                    return;
                }
                throw new IllegalArgumentException("Unsupported command " + i + " received by " + viewManager.getClass().getSimpleName() + ".");
            }
        }

        @JvmStatic
        public final <T> void receiveCommand(@NotNull ScrollCommandHandler<T> viewManager, T t, @NotNull String commandType, @Nullable ReadableArray readableArray) {
            Intrinsics.checkNotNullParameter(viewManager, "viewManager");
            Intrinsics.checkNotNullParameter(commandType, "commandType");
            if (t == null) {
                throw new IllegalStateException("Required value was null.");
            }
            int iHashCode = commandType.hashCode();
            if (iHashCode != -402165208) {
                if (iHashCode != 28425985) {
                    if (iHashCode == 2055114131 && commandType.equals("scrollToEnd")) {
                        if (readableArray == null) {
                            throw new IllegalStateException("Required value was null.");
                        }
                        scrollToEnd(viewManager, t, readableArray);
                        return;
                    }
                } else if (commandType.equals("flashScrollIndicators")) {
                    viewManager.flashScrollIndicators(t);
                    return;
                }
            } else if (commandType.equals("scrollTo")) {
                if (readableArray == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                scrollTo(viewManager, t, readableArray);
                return;
            }
            throw new IllegalArgumentException("Unsupported command " + commandType + " received by " + viewManager.getClass().getSimpleName() + ".");
        }

        private final <T> void scrollTo(ScrollCommandHandler<T> scrollCommandHandler, T t, ReadableArray readableArray) {
            scrollCommandHandler.scrollTo(t, new ScrollToCommandData(Math.round(PixelUtil.toPixelFromDIP(readableArray.getDouble(0))), Math.round(PixelUtil.toPixelFromDIP(readableArray.getDouble(1))), readableArray.getBoolean(2)));
        }

        private final <T> void scrollToEnd(ScrollCommandHandler<T> scrollCommandHandler, T t, ReadableArray readableArray) {
            scrollCommandHandler.scrollToEnd(t, new ScrollToEndCommandData(readableArray.getBoolean(0)));
        }
    }

    /* JADX INFO: loaded from: classes4.dex */
    public static final class ScrollToCommandData {
        public final boolean mAnimated;
        public final int mDestX;
        public final int mDestY;

        public ScrollToCommandData(int i, int i2, boolean z) {
            this.mDestX = i;
            this.mDestY = i2;
            this.mAnimated = z;
        }
    }

    /* JADX INFO: loaded from: classes4.dex */
    public static final class ScrollToEndCommandData {
        public final boolean mAnimated;

        public ScrollToEndCommandData(boolean z) {
            this.mAnimated = z;
        }
    }
}
