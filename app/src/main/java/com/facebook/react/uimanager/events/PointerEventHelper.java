package com.facebook.react.uimanager.events;

import android.view.MotionEvent;
import android.view.View;
import com.facebook.react.R;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class PointerEventHelper {
    public static final String CLICK = "topClick";
    public static final PointerEventHelper INSTANCE = new PointerEventHelper();
    public static final String POINTER_CANCEL = "topPointerCancel";
    public static final String POINTER_DOWN = "topPointerDown";
    public static final String POINTER_ENTER = "topPointerEnter";
    public static final String POINTER_LEAVE = "topPointerLeave";
    public static final String POINTER_MOVE = "topPointerMove";
    public static final String POINTER_OUT = "topPointerOut";
    public static final String POINTER_OVER = "topPointerOver";
    public static final String POINTER_TYPE_MOUSE = "mouse";
    public static final String POINTER_TYPE_PEN = "pen";
    public static final String POINTER_TYPE_TOUCH = "touch";
    public static final String POINTER_TYPE_UNKNOWN = "";
    public static final String POINTER_UP = "topPointerUp";
    public static final int X_FLAG_SUPPORTS_HOVER = 16777216;

    public enum EVENT {
        CANCEL,
        CANCEL_CAPTURE,
        CLICK,
        CLICK_CAPTURE,
        DOWN,
        DOWN_CAPTURE,
        ENTER,
        ENTER_CAPTURE,
        LEAVE,
        LEAVE_CAPTURE,
        MOVE,
        MOVE_CAPTURE,
        UP,
        UP_CAPTURE,
        OUT,
        OUT_CAPTURE,
        OVER,
        OVER_CAPTURE;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<EVENT> getEntries() {
            return $ENTRIES;
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EVENT.values().length];
            try {
                iArr[EVENT.DOWN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EVENT.DOWN_CAPTURE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EVENT.UP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EVENT.UP_CAPTURE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[EVENT.CANCEL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[EVENT.CANCEL_CAPTURE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[EVENT.CLICK.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[EVENT.CLICK_CAPTURE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private PointerEventHelper() {
    }

    @JvmStatic
    public static final int getButtons(@Nullable String str, @NotNull String pointerType, int i) {
        Intrinsics.checkNotNullParameter(pointerType, "pointerType");
        if (INSTANCE.isExitEvent(str)) {
            return 0;
        }
        if (Intrinsics.areEqual("touch", pointerType)) {
            return 1;
        }
        return i;
    }

    @JvmStatic
    public static final int getButtonChange(@NotNull String pointerType, int i, int i2) {
        Intrinsics.checkNotNullParameter(pointerType, "pointerType");
        if (Intrinsics.areEqual("touch", pointerType)) {
            return 0;
        }
        int i3 = i2 ^ i;
        if (i3 == 0) {
            return -1;
        }
        if (i3 == 1) {
            return 0;
        }
        if (i3 == 2) {
            return 2;
        }
        if (i3 == 4) {
            return 1;
        }
        if (i3 != 8) {
            return i3 != 16 ? -1 : 4;
        }
        return 3;
    }

    @JvmStatic
    public static final String getW3CPointerType(int i) {
        if (i == 1) {
            return "touch";
        }
        if (i == 2) {
            return POINTER_TYPE_PEN;
        }
        if (i == 3) {
            return POINTER_TYPE_MOUSE;
        }
        return "";
    }

    @JvmStatic
    public static final boolean isListening(@Nullable View view, @NotNull EVENT event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (view == null) {
            return true;
        }
        switch (WhenMappings.$EnumSwitchMapping$0[event.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return true;
            default:
                Object tag = view.getTag(R.id.pointer_events);
                Integer num = tag instanceof Integer ? (Integer) tag : null;
                return (num == null || (num.intValue() & (1 << event.ordinal())) == 0) ? false : true;
        }
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0048 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:33:0x005e A[ORIG_RETURN, RETURN] */
    @JvmStatic
    public static final int getEventCategory(@Nullable String str) {
        if (str == null) {
            return 2;
        }
        switch (str) {
            case "topPointerEnter":
            case "topPointerLeave":
                return 4;
            case "topPointerDown":
                return 3;
            case "topPointerMove":
            case "topPointerOver":
                return 4;
            case "topPointerUp":
            case "topPointerCancel":
                return 3;
            case "topPointerOut":
                return 4;
            default:
                return 2;
        }
    }

    public final boolean supportsHover(@NotNull MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "motionEvent");
        if ((motionEvent.getFlags() & 16777216) != 0) {
            return true;
        }
        return motionEvent.isFromSource(8194);
    }

    public final boolean isExitEvent(@Nullable String str) {
        int iHashCode;
        return str != null && ((iHashCode = str.hashCode()) == -1780335505 ? str.equals(POINTER_LEAVE) : !(iHashCode == -1065042973 ? !str.equals(POINTER_UP) : !(iHashCode == 1343400710 && str.equals(POINTER_OUT))));
    }

    @JvmStatic
    public static final double getPressure(int i, @Nullable String str) {
        return (INSTANCE.isExitEvent(str) || i == 0) ? 0.0d : 0.5d;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:24:0x0046 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @JvmStatic
    public static final boolean isBubblingEvent(@Nullable String str) {
        if (str != null) {
            switch (str.hashCode()) {
                case -1304584214:
                    if (str.equals(POINTER_DOWN)) {
                        return true;
                    }
                    break;
                case -1304316135:
                    if (str.equals(POINTER_MOVE)) {
                        return true;
                    }
                    break;
                case -1304250340:
                    if (str.equals(POINTER_OVER)) {
                        return true;
                    }
                    break;
                case -1065042973:
                    if (str.equals(POINTER_UP)) {
                        return true;
                    }
                    break;
                case 383186882:
                    if (str.equals(POINTER_CANCEL)) {
                        return true;
                    }
                    break;
                case 1343400710:
                    if (str.equals(POINTER_OUT)) {
                        return true;
                    }
                    break;
            }
        }
        return false;
    }
}
