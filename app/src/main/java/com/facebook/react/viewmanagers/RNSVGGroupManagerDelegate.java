package com.facebook.react.viewmanagers;

import android.view.View;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.DynamicFromObject;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.viewmanagers.RNSVGGroupManagerInterface;
import com.google.common.base.Ascii;

/* JADX INFO: loaded from: classes.dex */
public class RNSVGGroupManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & RNSVGGroupManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public RNSVGGroupManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:125:0x019a  */
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
            case "matrix":
                b = 2;
                break;
            case "propList":
                b = 3;
                break;
            case "markerEnd":
                b = 4;
                break;
            case "markerMid":
                b = 5;
                break;
            case "stroke":
                b = 6;
                break;
            case "fontWeight":
                b = 7;
                break;
            case "fillRule":
                b = 8;
                break;
            case "strokeOpacity":
                b = 9;
                break;
            case "pointerEvents":
                b = 10;
                break;
            case "fillOpacity":
                b = Ascii.VT;
                break;
            case "strokeDashoffset":
                b = Ascii.FF;
                break;
            case "fill":
                b = Ascii.CR;
                break;
            case "font":
                b = Ascii.SO;
                break;
            case "mask":
                b = Ascii.SI;
                break;
            case "name":
                b = Ascii.DLE;
                break;
            case "strokeMiterlimit":
                b = 17;
                break;
            case "color":
                b = Ascii.DC2;
                break;
            case "vectorEffect":
                b = 19;
                break;
            case "markerStart":
                b = Ascii.DC4;
                break;
            case "fontSize":
                b = Ascii.NAK;
                break;
            case "strokeDasharray":
                b = Ascii.SYN;
                break;
            case "clipPath":
                b = Ascii.ETB;
                break;
            case "clipRule":
                b = Ascii.CAN;
                break;
            case "strokeLinecap":
                b = Ascii.EM;
                break;
            case "display":
                b = Ascii.SUB;
                break;
            case "strokeLinejoin":
                b = Ascii.ESC;
                break;
            case "responsible":
                b = Ascii.FS;
                break;
            case "strokeWidth":
                b = Ascii.GS;
                break;
            default:
                b = -1;
                break;
        }
        switch (b) {
            case 0:
                ((RNSVGGroupManagerInterface) this.mViewManager).setFilter(t, obj != null ? (String) obj : null);
                break;
            case 1:
                this.mViewManager.setOpacity(t, obj != null ? ((Double) obj).floatValue() : 1.0f);
                break;
            case 2:
                ((RNSVGGroupManagerInterface) this.mViewManager).setMatrix(t, (ReadableArray) obj);
                break;
            case 3:
                ((RNSVGGroupManagerInterface) this.mViewManager).setPropList(t, (ReadableArray) obj);
                break;
            case 4:
                ((RNSVGGroupManagerInterface) this.mViewManager).setMarkerEnd(t, obj != null ? (String) obj : null);
                break;
            case 5:
                ((RNSVGGroupManagerInterface) this.mViewManager).setMarkerMid(t, obj != null ? (String) obj : null);
                break;
            case 6:
                ((RNSVGGroupManagerInterface) this.mViewManager).setStroke(t, new DynamicFromObject(obj));
                break;
            case 7:
                ((RNSVGGroupManagerInterface) this.mViewManager).setFontWeight(t, new DynamicFromObject(obj));
                break;
            case 8:
                ((RNSVGGroupManagerInterface) this.mViewManager).setFillRule(t, obj != null ? ((Double) obj).intValue() : 1);
                break;
            case 9:
                ((RNSVGGroupManagerInterface) this.mViewManager).setStrokeOpacity(t, obj != null ? ((Double) obj).floatValue() : 1.0f);
                break;
            case 10:
                ((RNSVGGroupManagerInterface) this.mViewManager).setPointerEvents(t, obj != null ? (String) obj : null);
                break;
            case 11:
                ((RNSVGGroupManagerInterface) this.mViewManager).setFillOpacity(t, obj != null ? ((Double) obj).floatValue() : 1.0f);
                break;
            case 12:
                ((RNSVGGroupManagerInterface) this.mViewManager).setStrokeDashoffset(t, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case 13:
                ((RNSVGGroupManagerInterface) this.mViewManager).setFill(t, new DynamicFromObject(obj));
                break;
            case 14:
                ((RNSVGGroupManagerInterface) this.mViewManager).setFont(t, new DynamicFromObject(obj));
                break;
            case 15:
                ((RNSVGGroupManagerInterface) this.mViewManager).setMask(t, obj != null ? (String) obj : null);
                break;
            case 16:
                ((RNSVGGroupManagerInterface) this.mViewManager).setName(t, obj != null ? (String) obj : null);
                break;
            case 17:
                ((RNSVGGroupManagerInterface) this.mViewManager).setStrokeMiterlimit(t, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case 18:
                ((RNSVGGroupManagerInterface) this.mViewManager).setColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case 19:
                ((RNSVGGroupManagerInterface) this.mViewManager).setVectorEffect(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 20:
                ((RNSVGGroupManagerInterface) this.mViewManager).setMarkerStart(t, obj != null ? (String) obj : null);
                break;
            case 21:
                ((RNSVGGroupManagerInterface) this.mViewManager).setFontSize(t, new DynamicFromObject(obj));
                break;
            case 22:
                ((RNSVGGroupManagerInterface) this.mViewManager).setStrokeDasharray(t, new DynamicFromObject(obj));
                break;
            case 23:
                ((RNSVGGroupManagerInterface) this.mViewManager).setClipPath(t, obj != null ? (String) obj : null);
                break;
            case 24:
                ((RNSVGGroupManagerInterface) this.mViewManager).setClipRule(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 25:
                ((RNSVGGroupManagerInterface) this.mViewManager).setStrokeLinecap(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 26:
                ((RNSVGGroupManagerInterface) this.mViewManager).setDisplay(t, obj != null ? (String) obj : null);
                break;
            case 27:
                ((RNSVGGroupManagerInterface) this.mViewManager).setStrokeLinejoin(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 28:
                ((RNSVGGroupManagerInterface) this.mViewManager).setResponsible(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 29:
                ((RNSVGGroupManagerInterface) this.mViewManager).setStrokeWidth(t, new DynamicFromObject(obj));
                break;
            default:
                super.setProperty(t, str, obj);
                break;
        }
    }
}
