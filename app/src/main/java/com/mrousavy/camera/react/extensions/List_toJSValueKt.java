package com.mrousavy.camera.react.extensions;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableArray;
import com.mrousavy.camera.core.types.JSUnionValue;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class List_toJSValueKt {
    public static final ReadableArray toJSValue(@NotNull List<? extends JSUnionValue> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        WritableArray writableArrayCreateArray = Arguments.createArray();
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            writableArrayCreateArray.pushString(((JSUnionValue) it2.next()).getUnionValue());
        }
        Intrinsics.checkNotNull(writableArrayCreateArray);
        return writableArrayCreateArray;
    }
}
