package com.facebook.react.animated;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.UnexpectedNativeTypeException;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.RCTModernEventEmitter;
import com.facebook.react.uimanager.events.TouchEvent;
import java.util.List;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class EventAnimationDriver implements RCTModernEventEmitter {
    public String eventName;
    private final List<String> eventPath;
    public ValueAnimatedNode valueNode;
    public int viewTag;

    public EventAnimationDriver(@NotNull String eventName, int i, @NotNull List<String> eventPath, @NotNull ValueAnimatedNode valueNode) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(eventPath, "eventPath");
        Intrinsics.checkNotNullParameter(valueNode, "valueNode");
        this.eventName = eventName;
        this.viewTag = i;
        this.eventPath = eventPath;
        this.valueNode = valueNode;
    }

    @Override // com.facebook.react.uimanager.events.RCTEventEmitter
    @Deprecated(message = "Deprecated in Java")
    public void receiveEvent(int i, @NotNull String eventName, @Nullable WritableMap writableMap) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        receiveEvent(-1, i, eventName, writableMap);
    }

    @Override // com.facebook.react.uimanager.events.RCTModernEventEmitter
    public void receiveEvent(int i, int i2, @NotNull String eventName, @Nullable WritableMap writableMap) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        receiveEvent(i, i2, eventName, false, 0, writableMap, 2);
    }

    @Override // com.facebook.react.uimanager.events.RCTEventEmitter
    @Deprecated(message = "Deprecated in Java")
    public void receiveTouches(@NotNull String eventName, @NotNull WritableArray touches, @NotNull WritableArray changedIndices) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(touches, "touches");
        Intrinsics.checkNotNullParameter(changedIndices, "changedIndices");
        throw new UnsupportedOperationException("receiveTouches is not support by native animated events");
    }

    @Override // com.facebook.react.uimanager.events.RCTModernEventEmitter
    @Deprecated(message = "Deprecated in Java")
    public void receiveTouches(@NotNull TouchEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        throw new UnsupportedOperationException("receiveTouches is not support by native animated events");
    }

    @Override // com.facebook.react.uimanager.events.RCTModernEventEmitter
    public void receiveEvent(int i, int i2, @NotNull String eventName, boolean z, int i3, @Nullable WritableMap writableMap, int i4) {
        ReadableMap map;
        ReadableMap readableMap;
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        if (writableMap == null) {
            throw new IllegalArgumentException("Native animated events must have event data.");
        }
        int size = this.eventPath.size();
        int i5 = 0;
        ReadableArray array = null;
        ReadableMap readableMap2 = writableMap;
        while (i5 < size - 1) {
            if (readableMap2 != null) {
                String str = this.eventPath.get(i5);
                ReadableType type = readableMap2.getType(str);
                if (type == ReadableType.Map) {
                    map = readableMap2.getMap(str);
                    readableMap = map;
                    array = null;
                } else if (type == ReadableType.Array) {
                    array = readableMap2.getArray(str);
                    readableMap = null;
                } else {
                    throw new UnexpectedNativeTypeException("Unexpected type " + type + " for key '" + str + "'");
                }
            } else {
                int i6 = Integer.parseInt(this.eventPath.get(i5));
                ReadableType type2 = array != null ? array.getType(i6) : null;
                if (type2 == ReadableType.Map) {
                    map = array != null ? array.getMap(i6) : null;
                    readableMap = map;
                    array = null;
                } else if (type2 == ReadableType.Array) {
                    array = array != null ? array.getArray(i6) : null;
                    readableMap = null;
                } else {
                    throw new UnexpectedNativeTypeException("Unexpected type " + type2 + " for index '" + i6 + "'");
                }
            }
            i5++;
            readableMap2 = readableMap;
        }
        List<String> list = this.eventPath;
        String str2 = list.get(list.size() - 1);
        if (readableMap2 != null) {
            this.valueNode.nodeValue = readableMap2.getDouble(str2);
            return;
        }
        this.valueNode.nodeValue = array != null ? array.getDouble(Integer.parseInt(str2)) : 0.0d;
    }
}
