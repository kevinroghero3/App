package com.facebook.react.viewmanagers;

import android.view.View;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.DynamicFromObject;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.viewmanagers.RNSVGPatternManagerInterface;
import com.google.common.base.Ascii;

/* JADX INFO: loaded from: classes.dex */
public class RNSVGPatternManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & RNSVGPatternManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public RNSVGPatternManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:177:0x0250  */
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
            case "height":
                b = 3;
                break;
            case "matrix":
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
            case "patternUnits":
                b = Ascii.CR;
                break;
            case "patternContentUnits":
                b = Ascii.SO;
                break;
            case "fillOpacity":
                b = Ascii.SI;
                break;
            case "strokeDashoffset":
                b = Ascii.DLE;
                break;
            case "x":
                b = 17;
                break;
            case "y":
                b = Ascii.DC2;
                break;
            case "fill":
                b = 19;
                break;
            case "font":
                b = Ascii.DC4;
                break;
            case "mask":
                b = Ascii.NAK;
                break;
            case "minX":
                b = Ascii.SYN;
                break;
            case "minY":
                b = Ascii.ETB;
                break;
            case "name":
                b = Ascii.CAN;
                break;
            case "strokeMiterlimit":
                b = Ascii.EM;
                break;
            case "align":
                b = Ascii.SUB;
                break;
            case "color":
                b = Ascii.ESC;
                break;
            case "vectorEffect":
                b = Ascii.FS;
                break;
            case "width":
                b = Ascii.GS;
                break;
            case "markerStart":
                b = Ascii.RS;
                break;
            case "vbWidth":
                b = Ascii.US;
                break;
            case "fontSize":
                b = 32;
                break;
            case "strokeDasharray":
                b = 33;
                break;
            case "patternTransform":
                b = 34;
                break;
            case "clipPath":
                b = 35;
                break;
            case "clipRule":
                b = 36;
                break;
            case "strokeLinecap":
                b = 37;
                break;
            case "display":
                b = 38;
                break;
            case "strokeLinejoin":
                b = 39;
                break;
            case "responsible":
                b = 40;
                break;
            case "meetOrSlice":
                b = 41;
                break;
            case "strokeWidth":
                b = 42;
                break;
            default:
                b = -1;
                break;
        }
        switch (b) {
            case 0:
                ((RNSVGPatternManagerInterface) this.mViewManager).setVbHeight(t, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case 1:
                ((RNSVGPatternManagerInterface) this.mViewManager).setFilter(t, obj != null ? (String) obj : null);
                break;
            case 2:
                this.mViewManager.setOpacity(t, obj != null ? ((Double) obj).floatValue() : 1.0f);
                break;
            case 3:
                ((RNSVGPatternManagerInterface) this.mViewManager).setHeight(t, new DynamicFromObject(obj));
                break;
            case 4:
                ((RNSVGPatternManagerInterface) this.mViewManager).setMatrix(t, (ReadableArray) obj);
                break;
            case 5:
                ((RNSVGPatternManagerInterface) this.mViewManager).setPropList(t, (ReadableArray) obj);
                break;
            case 6:
                ((RNSVGPatternManagerInterface) this.mViewManager).setMarkerEnd(t, obj != null ? (String) obj : null);
                break;
            case 7:
                ((RNSVGPatternManagerInterface) this.mViewManager).setMarkerMid(t, obj != null ? (String) obj : null);
                break;
            case 8:
                ((RNSVGPatternManagerInterface) this.mViewManager).setStroke(t, new DynamicFromObject(obj));
                break;
            case 9:
                ((RNSVGPatternManagerInterface) this.mViewManager).setFontWeight(t, new DynamicFromObject(obj));
                break;
            case 10:
                ((RNSVGPatternManagerInterface) this.mViewManager).setFillRule(t, obj != null ? ((Double) obj).intValue() : 1);
                break;
            case 11:
                ((RNSVGPatternManagerInterface) this.mViewManager).setStrokeOpacity(t, obj != null ? ((Double) obj).floatValue() : 1.0f);
                break;
            case 12:
                ((RNSVGPatternManagerInterface) this.mViewManager).setPointerEvents(t, obj != null ? (String) obj : null);
                break;
            case 13:
                ((RNSVGPatternManagerInterface) this.mViewManager).setPatternUnits(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 14:
                ((RNSVGPatternManagerInterface) this.mViewManager).setPatternContentUnits(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 15:
                ((RNSVGPatternManagerInterface) this.mViewManager).setFillOpacity(t, obj != null ? ((Double) obj).floatValue() : 1.0f);
                break;
            case 16:
                ((RNSVGPatternManagerInterface) this.mViewManager).setStrokeDashoffset(t, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case 17:
                ((RNSVGPatternManagerInterface) this.mViewManager).setX(t, new DynamicFromObject(obj));
                break;
            case 18:
                ((RNSVGPatternManagerInterface) this.mViewManager).setY(t, new DynamicFromObject(obj));
                break;
            case 19:
                ((RNSVGPatternManagerInterface) this.mViewManager).setFill(t, new DynamicFromObject(obj));
                break;
            case 20:
                ((RNSVGPatternManagerInterface) this.mViewManager).setFont(t, new DynamicFromObject(obj));
                break;
            case 21:
                ((RNSVGPatternManagerInterface) this.mViewManager).setMask(t, obj != null ? (String) obj : null);
                break;
            case 22:
                ((RNSVGPatternManagerInterface) this.mViewManager).setMinX(t, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case 23:
                ((RNSVGPatternManagerInterface) this.mViewManager).setMinY(t, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case 24:
                ((RNSVGPatternManagerInterface) this.mViewManager).setName(t, obj != null ? (String) obj : null);
                break;
            case 25:
                ((RNSVGPatternManagerInterface) this.mViewManager).setStrokeMiterlimit(t, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case 26:
                ((RNSVGPatternManagerInterface) this.mViewManager).setAlign(t, obj != null ? (String) obj : null);
                break;
            case 27:
                ((RNSVGPatternManagerInterface) this.mViewManager).setColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case 28:
                ((RNSVGPatternManagerInterface) this.mViewManager).setVectorEffect(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 29:
                ((RNSVGPatternManagerInterface) this.mViewManager).setWidth(t, new DynamicFromObject(obj));
                break;
            case 30:
                ((RNSVGPatternManagerInterface) this.mViewManager).setMarkerStart(t, obj != null ? (String) obj : null);
                break;
            case 31:
                ((RNSVGPatternManagerInterface) this.mViewManager).setVbWidth(t, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case 32:
                ((RNSVGPatternManagerInterface) this.mViewManager).setFontSize(t, new DynamicFromObject(obj));
                break;
            case 33:
                ((RNSVGPatternManagerInterface) this.mViewManager).setStrokeDasharray(t, new DynamicFromObject(obj));
                break;
            case 34:
                ((RNSVGPatternManagerInterface) this.mViewManager).setPatternTransform(t, (ReadableArray) obj);
                break;
            case 35:
                ((RNSVGPatternManagerInterface) this.mViewManager).setClipPath(t, obj != null ? (String) obj : null);
                break;
            case 36:
                ((RNSVGPatternManagerInterface) this.mViewManager).setClipRule(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 37:
                ((RNSVGPatternManagerInterface) this.mViewManager).setStrokeLinecap(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 38:
                ((RNSVGPatternManagerInterface) this.mViewManager).setDisplay(t, obj != null ? (String) obj : null);
                break;
            case 39:
                ((RNSVGPatternManagerInterface) this.mViewManager).setStrokeLinejoin(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 40:
                ((RNSVGPatternManagerInterface) this.mViewManager).setResponsible(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 41:
                ((RNSVGPatternManagerInterface) this.mViewManager).setMeetOrSlice(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 42:
                ((RNSVGPatternManagerInterface) this.mViewManager).setStrokeWidth(t, new DynamicFromObject(obj));
                break;
            default:
                super.setProperty(t, str, obj);
                break;
        }
    }
}
