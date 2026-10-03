package com.rnmaps.maps;

import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.core.internal.view.SupportMenu;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.google.android.gms.maps.model.ButtCap;
import com.google.android.gms.maps.model.Cap;
import com.google.android.gms.maps.model.RoundCap;
import com.google.android.gms.maps.model.SquareCap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class MapPolylineManager extends ViewGroupManager<MapPolyline> {
    private final DisplayMetrics metrics;

    public MapPolylineManager(ReactApplicationContext reactApplicationContext) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.metrics = displayMetrics;
        ((WindowManager) reactApplicationContext.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return "AIRMapPolyline";
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public MapPolyline createViewInstance(ThemedReactContext themedReactContext) {
        return new MapPolyline(themedReactContext);
    }

    @ReactProp(name = "coordinates")
    public void setCoordinate(MapPolyline mapPolyline, ReadableArray readableArray) {
        mapPolyline.setCoordinates(readableArray);
    }

    @ReactProp(defaultFloat = 1.0f, name = "strokeWidth")
    public void setStrokeWidth(MapPolyline mapPolyline, float f) {
        mapPolyline.setWidth(this.metrics.density * f);
    }

    @ReactProp(customType = "Color", defaultInt = SupportMenu.CATEGORY_MASK, name = "strokeColor")
    public void setStrokeColor(MapPolyline mapPolyline, int i) {
        mapPolyline.setColor(i);
    }

    @ReactProp(defaultBoolean = false, name = "tappable")
    public void setTappable(MapPolyline mapPolyline, boolean z) {
        mapPolyline.setTappable(z);
    }

    @ReactProp(defaultBoolean = false, name = "geodesic")
    public void setGeodesic(MapPolyline mapPolyline, boolean z) {
        mapPolyline.setGeodesic(z);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager
    @ReactProp(defaultFloat = 1.0f, name = ViewProps.Z_INDEX)
    public void setZIndex(MapPolyline mapPolyline, float f) {
        mapPolyline.setZIndex(f);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0037  */
    @ReactProp(name = "lineCap")
    public void setlineCap(MapPolyline mapPolyline, String str) {
        byte b;
        Cap squareCap;
        str.hashCode();
        int iHashCode = str.hashCode();
        if (iHashCode != -894674659) {
            if (iHashCode != 3035667) {
                if (iHashCode == 108704142 && str.equals("round")) {
                    b = 2;
                } else {
                    b = -1;
                }
            } else if (str.equals("butt")) {
                b = 1;
            } else {
                b = -1;
            }
        } else if (str.equals("square")) {
            b = 0;
        } else {
            b = -1;
        }
        if (b == 0) {
            squareCap = new SquareCap();
        } else if (b == 1) {
            squareCap = new ButtCap();
        } else if (b == 2) {
            squareCap = new RoundCap();
        } else {
            squareCap = new RoundCap();
        }
        mapPolyline.setLineCap(squareCap);
    }

    @ReactProp(name = "lineDashPattern")
    public void setLineDashPattern(MapPolyline mapPolyline, ReadableArray readableArray) {
        mapPolyline.setLineDashPattern(readableArray);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public Map getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.of("onPress", MapBuilder.of("registrationName", "onPress"));
    }
}
