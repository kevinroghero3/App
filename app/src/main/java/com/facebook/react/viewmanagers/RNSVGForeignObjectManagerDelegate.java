package com.facebook.react.viewmanagers;

import android.view.View;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.DynamicFromObject;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface;
import com.google.common.base.Ascii;

/* JADX INFO: loaded from: classes.dex */
public class RNSVGForeignObjectManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & RNSVGForeignObjectManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public RNSVGForeignObjectManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:141:0x01d2  */
    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public void setProperty(T t, String str, @Nullable Object obj) {
        byte b;
        str.hashCode();
        switch (str) {
            case "filter":
                b = 0;
                break;
            case "opacity":
                b = 1;
                break;
            case "height":
                b = 2;
                break;
            case "matrix":
                b = 3;
                break;
            case "propList":
                b = 4;
                break;
            case "markerEnd":
                b = 5;
                break;
            case "markerMid":
                b = 6;
                break;
            case "stroke":
                b = 7;
                break;
            case "fontWeight":
                b = 8;
                break;
            case "fillRule":
                b = 9;
                break;
            case "strokeOpacity":
                b = 10;
                break;
            case "pointerEvents":
                b = Ascii.VT;
                break;
            case "fillOpacity":
                b = Ascii.FF;
                break;
            case "strokeDashoffset":
                b = Ascii.CR;
                break;
            case "x":
                b = Ascii.SO;
                break;
            case "y":
                b = Ascii.SI;
                break;
            case "fill":
                b = Ascii.DLE;
                break;
            case "font":
                b = 17;
                break;
            case "mask":
                b = Ascii.DC2;
                break;
            case "name":
                b = 19;
                break;
            case "strokeMiterlimit":
                b = Ascii.DC4;
                break;
            case "color":
                b = Ascii.NAK;
                break;
            case "vectorEffect":
                b = Ascii.SYN;
                break;
            case "width":
                b = Ascii.ETB;
                break;
            case "markerStart":
                b = Ascii.CAN;
                break;
            case "fontSize":
                b = Ascii.EM;
                break;
            case "strokeDasharray":
                b = Ascii.SUB;
                break;
            case "clipPath":
                b = Ascii.ESC;
                break;
            case "clipRule":
                b = Ascii.FS;
                break;
            case "strokeLinecap":
                b = Ascii.GS;
                break;
            case "display":
                b = Ascii.RS;
                break;
            case "strokeLinejoin":
                b = Ascii.US;
                break;
            case "responsible":
                b = 32;
                break;
            case "strokeWidth":
                b = 33;
                break;
            default:
                b = -1;
                break;
        }
        switch (b) {
            case 0:
                ((RNSVGForeignObjectManagerInterface) this.mViewManager).setFilter(t, obj != null ? (String) obj : null);
                break;
            case 1:
                this.mViewManager.setOpacity(t, obj != null ? ((Double) obj).floatValue() : 1.0f);
                break;
            case 2:
                ((RNSVGForeignObjectManagerInterface) this.mViewManager).setHeight(t, new DynamicFromObject(obj));
                break;
            case 3:
                ((RNSVGForeignObjectManagerInterface) this.mViewManager).setMatrix(t, (ReadableArray) obj);
                break;
            case 4:
                ((RNSVGForeignObjectManagerInterface) this.mViewManager).setPropList(t, (ReadableArray) obj);
                break;
            case 5:
                ((RNSVGForeignObjectManagerInterface) this.mViewManager).setMarkerEnd(t, obj != null ? (String) obj : null);
                break;
            case 6:
                ((RNSVGForeignObjectManagerInterface) this.mViewManager).setMarkerMid(t, obj != null ? (String) obj : null);
                break;
            case 7:
                ((RNSVGForeignObjectManagerInterface) this.mViewManager).setStroke(t, new DynamicFromObject(obj));
                break;
            case 8:
                ((RNSVGForeignObjectManagerInterface) this.mViewManager).setFontWeight(t, new DynamicFromObject(obj));
                break;
            case 9:
                ((RNSVGForeignObjectManagerInterface) this.mViewManager).setFillRule(t, obj != null ? ((Double) obj).intValue() : 1);
                break;
            case 10:
                ((RNSVGForeignObjectManagerInterface) this.mViewManager).setStrokeOpacity(t, obj != null ? ((Double) obj).floatValue() : 1.0f);
                break;
            case 11:
                ((RNSVGForeignObjectManagerInterface) this.mViewManager).setPointerEvents(t, obj != null ? (String) obj : null);
                break;
            case 12:
                ((RNSVGForeignObjectManagerInterface) this.mViewManager).setFillOpacity(t, obj != null ? ((Double) obj).floatValue() : 1.0f);
                break;
            case 13:
                ((RNSVGForeignObjectManagerInterface) this.mViewManager).setStrokeDashoffset(t, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case 14:
                ((RNSVGForeignObjectManagerInterface) this.mViewManager).setX(t, new DynamicFromObject(obj));
                break;
            case 15:
                ((RNSVGForeignObjectManagerInterface) this.mViewManager).setY(t, new DynamicFromObject(obj));
                break;
            case 16:
                ((RNSVGForeignObjectManagerInterface) this.mViewManager).setFill(t, new DynamicFromObject(obj));
                break;
            case 17:
                ((RNSVGForeignObjectManagerInterface) this.mViewManager).setFont(t, new DynamicFromObject(obj));
                break;
            case 18:
                ((RNSVGForeignObjectManagerInterface) this.mViewManager).setMask(t, obj != null ? (String) obj : null);
                break;
            case 19:
                ((RNSVGForeignObjectManagerInterface) this.mViewManager).setName(t, obj != null ? (String) obj : null);
                break;
            case 20:
                ((RNSVGForeignObjectManagerInterface) this.mViewManager).setStrokeMiterlimit(t, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case 21:
                ((RNSVGForeignObjectManagerInterface) this.mViewManager).setColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case 22:
                ((RNSVGForeignObjectManagerInterface) this.mViewManager).setVectorEffect(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 23:
                ((RNSVGForeignObjectManagerInterface) this.mViewManager).setWidth(t, new DynamicFromObject(obj));
                break;
            case 24:
                ((RNSVGForeignObjectManagerInterface) this.mViewManager).setMarkerStart(t, obj != null ? (String) obj : null);
                break;
            case 25:
                ((RNSVGForeignObjectManagerInterface) this.mViewManager).setFontSize(t, new DynamicFromObject(obj));
                break;
            case 26:
                ((RNSVGForeignObjectManagerInterface) this.mViewManager).setStrokeDasharray(t, new DynamicFromObject(obj));
                break;
            case 27:
                ((RNSVGForeignObjectManagerInterface) this.mViewManager).setClipPath(t, obj != null ? (String) obj : null);
                break;
            case 28:
                ((RNSVGForeignObjectManagerInterface) this.mViewManager).setClipRule(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 29:
                ((RNSVGForeignObjectManagerInterface) this.mViewManager).setStrokeLinecap(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 30:
                ((RNSVGForeignObjectManagerInterface) this.mViewManager).setDisplay(t, obj != null ? (String) obj : null);
                break;
            case 31:
                ((RNSVGForeignObjectManagerInterface) this.mViewManager).setStrokeLinejoin(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 32:
                ((RNSVGForeignObjectManagerInterface) this.mViewManager).setResponsible(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 33:
                ((RNSVGForeignObjectManagerInterface) this.mViewManager).setStrokeWidth(t, new DynamicFromObject(obj));
                break;
            default:
                super.setProperty(t, str, obj);
                break;
        }
    }
}
