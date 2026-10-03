package com.facebook.react;

import com.facebook.react.bridge.ModuleHolder;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.internal.featureflags.ReactNativeFeatureFlags;
import com.facebook.react.module.model.ReactModuleInfo;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes.dex */
public final class BaseReactPackage$getNativeModuleIterator$1$1 implements Iterator<ModuleHolder>, KMappedMarker {
    final /* synthetic */ Iterator<Map.Entry<String, ReactModuleInfo>> $entrySetIterator;
    final /* synthetic */ ReactApplicationContext $reactContext;
    private Map.Entry<String, ReactModuleInfo> nextEntry;
    final /* synthetic */ BaseReactPackage this$0;

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX WARN: Multi-variable type inference failed */
    BaseReactPackage$getNativeModuleIterator$1$1(Iterator<? extends Map.Entry<String, ReactModuleInfo>> it2, BaseReactPackage baseReactPackage, ReactApplicationContext reactApplicationContext) {
        this.$entrySetIterator = it2;
        this.this$0 = baseReactPackage;
        this.$reactContext = reactApplicationContext;
    }

    public final Map.Entry<String, ReactModuleInfo> getNextEntry() {
        return this.nextEntry;
    }

    public final void setNextEntry(Map.Entry<String, ReactModuleInfo> entry) {
        this.nextEntry = entry;
    }

    private final void findNext() {
        while (this.$entrySetIterator.hasNext()) {
            Map.Entry<String, ReactModuleInfo> next = this.$entrySetIterator.next();
            ReactModuleInfo value = next.getValue();
            if (!ReactNativeFeatureFlags.useTurboModules() || !value.isTurboModule()) {
                this.nextEntry = next;
                return;
            }
        }
        this.nextEntry = null;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.nextEntry == null) {
            findNext();
        }
        return this.nextEntry != null;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    public ModuleHolder next() {
        if (this.nextEntry == null) {
            findNext();
        }
        Map.Entry<String, ReactModuleInfo> entry = this.nextEntry;
        if (entry == null) {
            throw new NoSuchElementException("ModuleHolder not found");
        }
        findNext();
        return new ModuleHolder(entry.getValue(), new BaseReactPackage.ModuleHolderProvider(this.this$0, entry.getKey(), this.$reactContext));
    }
}
