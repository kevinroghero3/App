package androidx.compose.ui.input.pointer;

import android.os.Build;
import android.util.SparseBooleanArray;
import android.util.SparseLongArray;
import android.view.MotionEvent;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public final class MotionEventAdapter {
    public static final int $stable = 8;
    private long nextId;
    private final SparseLongArray motionEventToComposePointerIdMap = new SparseLongArray();
    private final SparseBooleanArray activeHoverIds = new SparseBooleanArray();
    private final List<PointerInputEventData> pointers = new ArrayList();
    private int previousToolType = -1;
    private int previousSource = -1;

    public static /* synthetic */ void getMotionEventToComposePointerIdMap$ui_release$annotations() {
    }

    public final SparseLongArray getMotionEventToComposePointerIdMap$ui_release() {
        return this.motionEventToComposePointerIdMap;
    }

    public final PointerInputEvent convertToPointerInputEvent$ui_release(@NotNull MotionEvent motionEvent, @NotNull PositionCalculator positionCalculator) {
        int actionIndex;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 3 || actionMasked == 4) {
            this.motionEventToComposePointerIdMap.clear();
            this.activeHoverIds.clear();
            return null;
        }
        clearOnDeviceChange(motionEvent);
        addFreshIds(motionEvent);
        boolean z = actionMasked == 9 || actionMasked == 7 || actionMasked == 10;
        boolean z2 = actionMasked == 8;
        if (z) {
            this.activeHoverIds.put(motionEvent.getPointerId(motionEvent.getActionIndex()), true);
        }
        if (actionMasked != 1) {
            actionIndex = actionMasked != 6 ? -1 : motionEvent.getActionIndex();
        } else {
            actionIndex = 0;
        }
        this.pointers.clear();
        int pointerCount = motionEvent.getPointerCount();
        int i = 0;
        while (i < pointerCount) {
            this.pointers.add(createPointerInputEventData(positionCalculator, motionEvent, i, (z || i == actionIndex || (z2 && motionEvent.getButtonState() == 0)) ? false : true));
            i++;
        }
        removeStaleIds(motionEvent);
        return new PointerInputEvent(motionEvent.getEventTime(), this.pointers, motionEvent);
    }

    public final void endStream(int i) {
        this.activeHoverIds.delete(i);
        this.motionEventToComposePointerIdMap.delete(i);
    }

    private final void addFreshIds(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0 && actionMasked != 5) {
            if (actionMasked != 9) {
                return;
            }
            int pointerId = motionEvent.getPointerId(0);
            if (this.motionEventToComposePointerIdMap.indexOfKey(pointerId) < 0) {
                SparseLongArray sparseLongArray = this.motionEventToComposePointerIdMap;
                long j = this.nextId;
                this.nextId = 1 + j;
                sparseLongArray.put(pointerId, j);
                return;
            }
            return;
        }
        int actionIndex = motionEvent.getActionIndex();
        int pointerId2 = motionEvent.getPointerId(actionIndex);
        if (this.motionEventToComposePointerIdMap.indexOfKey(pointerId2) < 0) {
            SparseLongArray sparseLongArray2 = this.motionEventToComposePointerIdMap;
            long j2 = this.nextId;
            this.nextId = 1 + j2;
            sparseLongArray2.put(pointerId2, j2);
            if (motionEvent.getToolType(actionIndex) == 3) {
                this.activeHoverIds.put(pointerId2, true);
            }
        }
    }

    private final void removeStaleIds(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1 || actionMasked == 6) {
            int pointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
            if (!this.activeHoverIds.get(pointerId, false)) {
                this.motionEventToComposePointerIdMap.delete(pointerId);
                this.activeHoverIds.delete(pointerId);
            }
        }
        if (this.motionEventToComposePointerIdMap.size() > motionEvent.getPointerCount()) {
            for (int size = this.motionEventToComposePointerIdMap.size() - 1; -1 < size; size--) {
                int iKeyAt = this.motionEventToComposePointerIdMap.keyAt(size);
                if (!hasPointerId(motionEvent, iKeyAt)) {
                    this.motionEventToComposePointerIdMap.removeAt(size);
                    this.activeHoverIds.delete(iKeyAt);
                }
            }
        }
    }

    private final boolean hasPointerId(MotionEvent motionEvent, int i) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i2 = 0; i2 < pointerCount; i2++) {
            if (motionEvent.getPointerId(i2) == i) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: getComposePointerId-_I2yYro, reason: not valid java name */
    private final long m2310getComposePointerId_I2yYro(int i) {
        long jValueAt;
        int iIndexOfKey = this.motionEventToComposePointerIdMap.indexOfKey(i);
        if (iIndexOfKey >= 0) {
            jValueAt = this.motionEventToComposePointerIdMap.valueAt(iIndexOfKey);
        } else {
            jValueAt = this.nextId;
            this.nextId = 1 + jValueAt;
            this.motionEventToComposePointerIdMap.put(i, jValueAt);
        }
        return PointerId.m2361constructorimpl(jValueAt);
    }

    private final void clearOnDeviceChange(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() != 1) {
            return;
        }
        int toolType = motionEvent.getToolType(0);
        int source = motionEvent.getSource();
        if (toolType == this.previousToolType && source == this.previousSource) {
            return;
        }
        this.previousToolType = toolType;
        this.previousSource = source;
        this.activeHoverIds.clear();
        this.motionEventToComposePointerIdMap.clear();
    }

    /* JADX WARN: Code duplicated, block: B:12:0x005b  */
    /* JADX WARN: Code duplicated, block: B:14:0x005e  */
    /* JADX WARN: Code duplicated, block: B:16:0x0061  */
    /* JADX WARN: Code duplicated, block: B:18:0x0064  */
    /* JADX WARN: Code duplicated, block: B:20:0x0067  */
    /* JADX WARN: Code duplicated, block: B:21:0x006e  */
    /* JADX WARN: Code duplicated, block: B:22:0x0075  */
    /* JADX WARN: Code duplicated, block: B:23:0x007c  */
    /* JADX WARN: Code duplicated, block: B:24:0x0083  */
    /* JADX WARN: Code duplicated, block: B:25:0x008a  */
    /* JADX WARN: Code duplicated, block: B:28:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:40:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:41:0x00f8  */
    private final PointerInputEventData createPointerInputEventData(PositionCalculator positionCalculator, MotionEvent motionEvent, int i, boolean z) {
        long j;
        long jMo2465localToScreenMKHz9U;
        long jM2311toRawOffsetdBAh8RU;
        long jMo2466screenToLocalMKHz9U;
        int toolType;
        int iM2463getUnknownT8wyACA;
        int historySize;
        int i2;
        long jM944getZeroF1C5BW0;
        float historicalX;
        long jM2310getComposePointerId_I2yYro = m2310getComposePointerId_I2yYro(motionEvent.getPointerId(i));
        float pressure = motionEvent.getPressure(i);
        long jOffset = OffsetKt.Offset(motionEvent.getX(i), motionEvent.getY(i));
        long jM922copydBAh8RU$default = Offset.m922copydBAh8RU$default(jOffset, 0.0f, 0.0f, 3, null);
        if (i == 0) {
            jM2311toRawOffsetdBAh8RU = OffsetKt.Offset(motionEvent.getRawX(), motionEvent.getRawY());
            jMo2466screenToLocalMKHz9U = positionCalculator.mo2466screenToLocalMKHz9U(jM2311toRawOffsetdBAh8RU);
        } else {
            if (Build.VERSION.SDK_INT >= 29) {
                jM2311toRawOffsetdBAh8RU = MotionEventHelper.INSTANCE.m2311toRawOffsetdBAh8RU(motionEvent, i);
                jMo2466screenToLocalMKHz9U = positionCalculator.mo2466screenToLocalMKHz9U(jM2311toRawOffsetdBAh8RU);
            } else {
                j = jOffset;
                jMo2465localToScreenMKHz9U = positionCalculator.mo2465localToScreenMKHz9U(jOffset);
            }
            toolType = motionEvent.getToolType(i);
            if (toolType != 0) {
                iM2463getUnknownT8wyACA = PointerType.Companion.m2463getUnknownT8wyACA();
            } else if (toolType != 1) {
                iM2463getUnknownT8wyACA = PointerType.Companion.m2462getTouchT8wyACA();
            } else if (toolType != 2) {
                iM2463getUnknownT8wyACA = PointerType.Companion.m2461getStylusT8wyACA();
            } else if (toolType != 3) {
                iM2463getUnknownT8wyACA = PointerType.Companion.m2460getMouseT8wyACA();
            } else if (toolType != 4) {
                iM2463getUnknownT8wyACA = PointerType.Companion.m2459getEraserT8wyACA();
            } else {
                iM2463getUnknownT8wyACA = PointerType.Companion.m2463getUnknownT8wyACA();
            }
            int i3 = iM2463getUnknownT8wyACA;
            ArrayList arrayList = new ArrayList(motionEvent.getHistorySize());
            historySize = motionEvent.getHistorySize();
            for (i2 = 0; i2 < historySize; i2++) {
                historicalX = motionEvent.getHistoricalX(i, i2);
                float historicalY = motionEvent.getHistoricalY(i, i2);
                if (Float.isInfinite(historicalX) && !Float.isNaN(historicalX) && !Float.isInfinite(historicalY) && !Float.isNaN(historicalY)) {
                    long jOffset2 = OffsetKt.Offset(historicalX, historicalY);
                    arrayList.add(new HistoricalChange(motionEvent.getHistoricalEventTime(i2), jOffset2, jOffset2, null));
                }
            }
            if (motionEvent.getActionMasked() == 8) {
                jM944getZeroF1C5BW0 = OffsetKt.Offset(motionEvent.getAxisValue(10), (-motionEvent.getAxisValue(9)) + 0.0f);
            } else {
                jM944getZeroF1C5BW0 = Offset.Companion.m944getZeroF1C5BW0();
            }
            return new PointerInputEventData(jM2310getComposePointerId_I2yYro, motionEvent.getEventTime(), jMo2465localToScreenMKHz9U, j, z, pressure, i3, this.activeHoverIds.get(motionEvent.getPointerId(i), false), arrayList, jM944getZeroF1C5BW0, jM922copydBAh8RU$default, null);
        }
        jMo2465localToScreenMKHz9U = jM2311toRawOffsetdBAh8RU;
        j = jMo2466screenToLocalMKHz9U;
        toolType = motionEvent.getToolType(i);
        if (toolType != 0) {
            iM2463getUnknownT8wyACA = PointerType.Companion.m2463getUnknownT8wyACA();
        } else if (toolType != 1) {
            iM2463getUnknownT8wyACA = PointerType.Companion.m2462getTouchT8wyACA();
        } else if (toolType != 2) {
            iM2463getUnknownT8wyACA = PointerType.Companion.m2461getStylusT8wyACA();
        } else if (toolType != 3) {
            iM2463getUnknownT8wyACA = PointerType.Companion.m2460getMouseT8wyACA();
        } else if (toolType != 4) {
            iM2463getUnknownT8wyACA = PointerType.Companion.m2459getEraserT8wyACA();
        } else {
            iM2463getUnknownT8wyACA = PointerType.Companion.m2463getUnknownT8wyACA();
        }
        int i4 = iM2463getUnknownT8wyACA;
        ArrayList arrayList2 = new ArrayList(motionEvent.getHistorySize());
        historySize = motionEvent.getHistorySize();
        while (i2 < historySize) {
            historicalX = motionEvent.getHistoricalX(i, i2);
            float historicalY2 = motionEvent.getHistoricalY(i, i2);
            if (Float.isInfinite(historicalX)) {
            }
        }
        if (motionEvent.getActionMasked() == 8) {
            jM944getZeroF1C5BW0 = OffsetKt.Offset(motionEvent.getAxisValue(10), (-motionEvent.getAxisValue(9)) + 0.0f);
        } else {
            jM944getZeroF1C5BW0 = Offset.Companion.m944getZeroF1C5BW0();
        }
        return new PointerInputEventData(jM2310getComposePointerId_I2yYro, motionEvent.getEventTime(), jMo2465localToScreenMKHz9U, j, z, pressure, i4, this.activeHoverIds.get(motionEvent.getPointerId(i), false), arrayList2, jM944getZeroF1C5BW0, jM922copydBAh8RU$default, null);
    }
}
