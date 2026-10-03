package com.facebook.react;

import com.facebook.react.bridge.ModuleHolder;
import com.facebook.react.bridge.ReactApplicationContext;
import java.util.Iterator;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes.dex */
public final class BaseReactPackage$getNativeModuleIterator$$inlined$Iterable$1 implements Iterable<ModuleHolder>, KMappedMarker {
    final /* synthetic */ Iterator $entrySetIterator$inlined;
    final /* synthetic */ ReactApplicationContext $reactContext$inlined;
    final /* synthetic */ BaseReactPackage this$0;

    public BaseReactPackage$getNativeModuleIterator$$inlined$Iterable$1(Iterator it2, BaseReactPackage baseReactPackage, ReactApplicationContext reactApplicationContext) {
        this.$entrySetIterator$inlined = it2;
        this.this$0 = baseReactPackage;
        this.$reactContext$inlined = reactApplicationContext;
    }

    @Override // java.lang.Iterable
    public Iterator<ModuleHolder> iterator() {
        return new BaseReactPackage$getNativeModuleIterator$1$1(this.$entrySetIterator$inlined, this.this$0, this.$reactContext$inlined);
    }
}
