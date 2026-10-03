package androidx.compose.ui.input.pointer;

import android.view.MotionEvent;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public final class PointerInputEvent {
    public static final int $stable = 8;
    private final MotionEvent motionEvent;
    private final List<PointerInputEventData> pointers;
    private final long uptime;

    public PointerInputEvent(long j, @NotNull List<PointerInputEventData> list, @NotNull MotionEvent motionEvent) {
        this.uptime = j;
        this.pointers = list;
        this.motionEvent = motionEvent;
    }

    public final long getUptime() {
        return this.uptime;
    }

    public final List<PointerInputEventData> getPointers() {
        return this.pointers;
    }

    public final MotionEvent getMotionEvent() {
        return this.motionEvent;
    }
}
