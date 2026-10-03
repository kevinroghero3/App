package com.rnmaps.maps;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.fabric.interop.UIBlockViewResolver;
import com.facebook.react.uimanager.NativeViewHierarchyManager;
import com.facebook.react.uimanager.UIManagerModule;
import java.util.function.Function;

/* JADX INFO: loaded from: classes6.dex */
public class MapUIBlock implements UIBlockInterface {
    private ReactApplicationContext context;
    private Function<MapView, Void> mapOperation;
    private Promise promise;
    private int tag;

    public MapUIBlock(int i, Promise promise, ReactApplicationContext reactApplicationContext, Function<MapView, Void> function) {
        this.tag = i;
        this.promise = promise;
        this.context = reactApplicationContext;
        this.mapOperation = function;
    }

    @Override // com.facebook.react.uimanager.UIBlock
    public void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
        executeImpl(nativeViewHierarchyManager, null);
    }

    @Override // com.facebook.react.fabric.interop.UIBlock
    public void execute(UIBlockViewResolver uIBlockViewResolver) {
        executeImpl(null, uIBlockViewResolver);
    }

    private void executeImpl(NativeViewHierarchyManager nativeViewHierarchyManager, UIBlockViewResolver uIBlockViewResolver) {
        MapView mapView = (MapView) (uIBlockViewResolver != null ? uIBlockViewResolver.resolveView(this.tag) : nativeViewHierarchyManager.resolveView(this.tag));
        if (mapView == null) {
            this.promise.reject("AirMapView not found");
        } else if (mapView.map == null) {
            this.promise.reject("AirMapView.map is not valid");
        } else {
            this.mapOperation.apply(mapView);
        }
    }

    public void addToUIManager() {
        ((UIManagerModule) this.context.getNativeModule(UIManagerModule.class)).addUIBlock(this);
    }
}
