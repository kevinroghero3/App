package com.rnmaps.maps;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.internal.view.SupportMenu;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class MapMarkerManager extends ViewGroupManager<MapMarker> {
    private final Map<String, AirMapMarkerSharedIcon> sharedIcons = new ConcurrentHashMap();

    public static class AirMapMarkerSharedIcon {
        private Bitmap bitmap;
        private BitmapDescriptor iconBitmapDescriptor;
        private final Map<MapMarker, Boolean> markers = new WeakHashMap();
        private boolean loadImageStarted = false;

        public boolean shouldLoadImage() {
            synchronized (this) {
                if (this.loadImageStarted) {
                    return false;
                }
                this.loadImageStarted = true;
                return true;
            }
        }

        public void addMarker(MapMarker mapMarker) {
            synchronized (this) {
                this.markers.put(mapMarker, Boolean.TRUE);
                BitmapDescriptor bitmapDescriptor = this.iconBitmapDescriptor;
                if (bitmapDescriptor != null) {
                    mapMarker.setIconBitmapDescriptor(bitmapDescriptor, this.bitmap);
                }
            }
        }

        public void removeMarker(MapMarker mapMarker) {
            synchronized (this) {
                this.markers.remove(mapMarker);
            }
        }

        public boolean hasMarker() {
            boolean zIsEmpty;
            synchronized (this) {
                zIsEmpty = this.markers.isEmpty();
            }
            return zIsEmpty;
        }

        public void updateIcon(BitmapDescriptor bitmapDescriptor, Bitmap bitmap) {
            synchronized (this) {
                this.iconBitmapDescriptor = bitmapDescriptor;
                this.bitmap = bitmap.copy(Bitmap.Config.ARGB_8888, true);
                if (this.markers.isEmpty()) {
                    return;
                }
                for (Map.Entry<MapMarker, Boolean> entry : this.markers.entrySet()) {
                    if (entry.getKey() != null) {
                        entry.getKey().setIconBitmapDescriptor(bitmapDescriptor, bitmap);
                    }
                }
            }
        }
    }

    public AirMapMarkerSharedIcon getSharedIcon(String str) {
        AirMapMarkerSharedIcon airMapMarkerSharedIcon = this.sharedIcons.get(str);
        if (airMapMarkerSharedIcon == null) {
            synchronized (this) {
                airMapMarkerSharedIcon = this.sharedIcons.get(str);
                if (airMapMarkerSharedIcon == null) {
                    airMapMarkerSharedIcon = new AirMapMarkerSharedIcon();
                    this.sharedIcons.put(str, airMapMarkerSharedIcon);
                }
            }
        }
        return airMapMarkerSharedIcon;
    }

    public void removeSharedIconIfEmpty(String str) {
        AirMapMarkerSharedIcon airMapMarkerSharedIcon = this.sharedIcons.get(str);
        if (airMapMarkerSharedIcon == null || airMapMarkerSharedIcon.hasMarker()) {
            return;
        }
        synchronized (this) {
            AirMapMarkerSharedIcon airMapMarkerSharedIcon2 = this.sharedIcons.get(str);
            if (airMapMarkerSharedIcon2 != null && !airMapMarkerSharedIcon2.hasMarker()) {
                this.sharedIcons.remove(str);
            }
        }
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return "AIRMapMarker";
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public MapMarker createViewInstance(ThemedReactContext themedReactContext) {
        return new MapMarker(themedReactContext, this);
    }

    @ReactProp(name = "coordinate")
    public void setCoordinate(MapMarker mapMarker, ReadableMap readableMap) {
        mapMarker.setCoordinate(readableMap);
    }

    @ReactProp(name = "title")
    public void setTitle(MapMarker mapMarker, String str) {
        mapMarker.setTitle(str);
    }

    @ReactProp(name = "identifier")
    public void setIdentifier(MapMarker mapMarker, String str) {
        mapMarker.setIdentifier(str);
    }

    @ReactProp(name = "description")
    public void setDescription(MapMarker mapMarker, String str) {
        mapMarker.setSnippet(str);
    }

    @ReactProp(name = "anchor")
    public void setAnchor(MapMarker mapMarker, ReadableMap readableMap) {
        mapMarker.setAnchor((readableMap == null || !readableMap.hasKey("x")) ? 0.5d : readableMap.getDouble("x"), (readableMap == null || !readableMap.hasKey("y")) ? 1.0d : readableMap.getDouble("y"));
    }

    @ReactProp(name = "calloutAnchor")
    public void setCalloutAnchor(MapMarker mapMarker, ReadableMap readableMap) {
        mapMarker.setCalloutAnchor((readableMap == null || !readableMap.hasKey("x")) ? 0.5d : readableMap.getDouble("x"), (readableMap == null || !readableMap.hasKey("y")) ? 0.0d : readableMap.getDouble("y"));
    }

    @ReactProp(name = "image")
    public void setImage(MapMarker mapMarker, @Nullable String str) {
        mapMarker.setImage(str);
    }

    @ReactProp(name = "icon")
    public void setIcon(MapMarker mapMarker, @Nullable String str) {
        mapMarker.setImage(str);
    }

    @ReactProp(customType = "Color", defaultInt = SupportMenu.CATEGORY_MASK, name = "pinColor")
    public void setPinColor(MapMarker mapMarker, int i) {
        float[] fArr = new float[3];
        Color.colorToHSV(i, fArr);
        mapMarker.setMarkerHue(fArr[0]);
    }

    @ReactProp(defaultFloat = 0.0f, name = "rotation")
    public void setMarkerRotation(MapMarker mapMarker, float f) {
        mapMarker.setRotation(f);
    }

    @ReactProp(defaultBoolean = false, name = "flat")
    public void setFlat(MapMarker mapMarker, boolean z) {
        mapMarker.setFlat(z);
    }

    @ReactProp(defaultBoolean = false, name = "draggable")
    public void setDraggable(MapMarker mapMarker, boolean z) {
        mapMarker.setDraggable(z);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager
    @ReactProp(defaultFloat = 0.0f, name = ViewProps.Z_INDEX)
    public void setZIndex(MapMarker mapMarker, float f) {
        super.setZIndex(mapMarker, f);
        mapMarker.setZIndex(Math.round(f));
    }

    @Override // com.facebook.react.uimanager.BaseViewManager
    @ReactProp(defaultFloat = 1.0f, name = ViewProps.OPACITY)
    public void setOpacity(MapMarker mapMarker, float f) {
        super.setOpacity(mapMarker, f);
        mapMarker.setOpacity(f);
    }

    @ReactProp(defaultBoolean = true, name = "tracksViewChanges")
    public void setTracksViewChanges(MapMarker mapMarker, boolean z) {
        mapMarker.setTracksViewChanges(z);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager
    @ReactProp(name = ViewProps.ACCESSIBILITY_LABEL)
    public void setAccessibilityLabel(MapMarker mapMarker, @Nullable String str) {
        mapMarker.setTag(com.facebook.react.R.id.accessibility_label, str);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void addView(MapMarker mapMarker, View view, int i) {
        if (view instanceof MapCallout) {
            mapMarker.setCalloutView((MapCallout) view);
        } else {
            super.addView(mapMarker, view, i);
            mapMarker.update(true);
        }
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void removeViewAt(MapMarker mapMarker, int i) {
        super.removeViewAt(mapMarker, i);
        mapMarker.update(true);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:21:0x003b  */
    @Override // com.facebook.react.uimanager.ViewManager
    public void receiveCommand(@NonNull MapMarker mapMarker, String str, @Nullable ReadableArray readableArray) {
        byte b;
        str.hashCode();
        switch (str) {
            case "animateMarkerToCoordinate":
                b = 0;
                break;
            case "redraw":
                b = 1;
                break;
            case "hideCallout":
                b = 2;
                break;
            case "showCallout":
                b = 3;
                break;
            default:
                b = -1;
                break;
        }
        if (b == 0) {
            if (readableArray == null) {
                return;
            }
            ReadableMap map = readableArray.getMap(0);
            mapMarker.animateToCoodinate(new LatLng(map.getDouble("latitude"), map.getDouble("longitude")), Integer.valueOf(readableArray.getInt(1)));
            return;
        }
        if (b == 1) {
            mapMarker.updateMarkerIcon();
        } else if (b == 2) {
            ((Marker) mapMarker.getFeature()).hideInfoWindow();
        } else {
            if (b != 3) {
                return;
            }
            ((Marker) mapMarker.getFeature()).showInfoWindow();
        }
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public Map getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.builder().put("onPress", MapBuilder.of("registrationName", "onPress")).put("onCalloutPress", MapBuilder.of("registrationName", "onCalloutPress")).put("onDragStart", MapBuilder.of("registrationName", "onDragStart")).put("onDrag", MapBuilder.of("registrationName", "onDrag")).put("onDragEnd", MapBuilder.of("registrationName", "onDragEnd")).build();
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public Map getExportedCustomBubblingEventTypeConstants() {
        return MapBuilder.builder().put("onSelect", MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onSelect"))).put("onDeselect", MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onDeselect"))).build();
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.ViewManager
    public LayoutShadowNode createShadowNodeInstance() {
        return new SizeReportingShadowNode();
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void updateExtraData(MapMarker mapMarker, Object obj) {
        HashMap map = (HashMap) obj;
        mapMarker.update((int) ((Float) map.get("width")).floatValue(), (int) ((Float) map.get("height")).floatValue());
    }
}
