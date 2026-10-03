package com.facebook.react.viewmanagers;

import android.view.View;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.DynamicFromObject;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface;
import com.google.common.base.Ascii;

/* JADX INFO: loaded from: classes.dex */
public class RNSVGMarkerManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & RNSVGMarkerManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public RNSVGMarkerManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:173:0x0242  */
    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public void setProperty(T t, String str, @Nullable Object obj) {
        byte b;
        str.hashCode();
        switch (str) {
            case "vbHeight":
                b = 0;
                break;
            case "filter":
                b = 1;
                break;
            case "opacity":
                b = 2;
                break;
            case "matrix":
                b = 3;
                break;
            case "orient":
                b = 4;
                break;
            case "propList":
                b = 5;
                break;
            case "markerEnd":
                b = 6;
                break;
            case "markerMid":
                b = 7;
                break;
            case "stroke":
                b = 8;
                break;
            case "fontWeight":
                b = 9;
                break;
            case "fillRule":
                b = 10;
                break;
            case "strokeOpacity":
                b = Ascii.VT;
                break;
            case "pointerEvents":
                b = Ascii.FF;
                break;
            case "fillOpacity":
                b = Ascii.CR;
                break;
            case "strokeDashoffset":
                b = Ascii.SO;
                break;
            case "fill":
                b = Ascii.SI;
                break;
            case "font":
                b = Ascii.DLE;
                break;
            case "mask":
                b = 17;
                break;
            case "minX":
                b = Ascii.DC2;
                break;
            case "minY":
                b = 19;
                break;
            case "name":
                b = Ascii.DC4;
                break;
            case "refX":
                b = Ascii.NAK;
                break;
            case "refY":
                b = Ascii.SYN;
                break;
            case "strokeMiterlimit":
                b = Ascii.ETB;
                break;
            case "align":
                b = Ascii.CAN;
                break;
            case "color":
                b = Ascii.EM;
                break;
            case "vectorEffect":
                b = Ascii.SUB;
                break;
            case "markerStart":
                b = Ascii.ESC;
                break;
            case "markerUnits":
                b = Ascii.FS;
                break;
            case "markerWidth":
                b = Ascii.GS;
                break;
            case "vbWidth":
                b = Ascii.RS;
                break;
            case "fontSize":
                b = Ascii.US;
                break;
            case "strokeDasharray":
                b = 32;
                break;
            case "clipPath":
                b = 33;
                break;
            case "clipRule":
                b = 34;
                break;
            case "strokeLinecap":
                b = 35;
                break;
            case "display":
                b = 36;
                break;
            case "strokeLinejoin":
                b = 37;
                break;
            case "responsible":
                b = 38;
                break;
            case "meetOrSlice":
                b = 39;
                break;
            case "strokeWidth":
                b = 40;
                break;
            case "markerHeight":
                b = 41;
                break;
            default:
                b = -1;
                break;
        }
        switch (b) {
            case 0:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setVbHeight(t, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case 1:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setFilter(t, obj != null ? (String) obj : null);
                break;
            case 2:
                this.mViewManager.setOpacity(t, obj != null ? ((Double) obj).floatValue() : 1.0f);
                break;
            case 3:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setMatrix(t, (ReadableArray) obj);
                break;
            case 4:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setOrient(t, obj != null ? (String) obj : null);
                break;
            case 5:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setPropList(t, (ReadableArray) obj);
                break;
            case 6:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setMarkerEnd(t, obj != null ? (String) obj : null);
                break;
            case 7:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setMarkerMid(t, obj != null ? (String) obj : null);
                break;
            case 8:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setStroke(t, new DynamicFromObject(obj));
                break;
            case 9:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setFontWeight(t, new DynamicFromObject(obj));
                break;
            case 10:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setFillRule(t, obj != null ? ((Double) obj).intValue() : 1);
                break;
            case 11:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setStrokeOpacity(t, obj != null ? ((Double) obj).floatValue() : 1.0f);
                break;
            case 12:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setPointerEvents(t, obj != null ? (String) obj : null);
                break;
            case 13:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setFillOpacity(t, obj != null ? ((Double) obj).floatValue() : 1.0f);
                break;
            case 14:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setStrokeDashoffset(t, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case 15:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setFill(t, new DynamicFromObject(obj));
                break;
            case 16:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setFont(t, new DynamicFromObject(obj));
                break;
            case 17:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setMask(t, obj != null ? (String) obj : null);
                break;
            case 18:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setMinX(t, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case 19:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setMinY(t, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case 20:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setName(t, obj != null ? (String) obj : null);
                break;
            case 21:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setRefX(t, new DynamicFromObject(obj));
                break;
            case 22:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setRefY(t, new DynamicFromObject(obj));
                break;
            case 23:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setStrokeMiterlimit(t, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case 24:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setAlign(t, obj != null ? (String) obj : null);
                break;
            case 25:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case 26:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setVectorEffect(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 27:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setMarkerStart(t, obj != null ? (String) obj : null);
                break;
            case 28:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setMarkerUnits(t, obj != null ? (String) obj : null);
                break;
            case 29:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setMarkerWidth(t, new DynamicFromObject(obj));
                break;
            case 30:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setVbWidth(t, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case 31:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setFontSize(t, new DynamicFromObject(obj));
                break;
            case 32:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setStrokeDasharray(t, new DynamicFromObject(obj));
                break;
            case 33:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setClipPath(t, obj != null ? (String) obj : null);
                break;
            case 34:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setClipRule(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 35:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setStrokeLinecap(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 36:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setDisplay(t, obj != null ? (String) obj : null);
                break;
            case 37:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setStrokeLinejoin(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 38:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setResponsible(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 39:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setMeetOrSlice(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 40:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setStrokeWidth(t, new DynamicFromObject(obj));
                break;
            case 41:
                ((RNSVGMarkerManagerInterface) this.mViewManager).setMarkerHeight(t, new DynamicFromObject(obj));
                break;
            default:
                super.setProperty(t, str, obj);
                break;
        }
    }
}
