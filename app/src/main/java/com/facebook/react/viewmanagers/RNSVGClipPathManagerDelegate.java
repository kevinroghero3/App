package com.facebook.react.viewmanagers;

import android.view.View;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.DynamicFromObject;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.viewmanagers.RNSVGClipPathManagerInterface;
import com.google.common.base.Ascii;

/* JADX INFO: loaded from: classes.dex */
public class RNSVGClipPathManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & RNSVGClipPathManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public RNSVGClipPathManagerDelegate(BaseViewManager baseViewManager) {
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
                ((RNSVGClipPathManagerInterface) this.mViewManager).setFilter(t, obj != null ? (String) obj : null);
                break;
            case 1:
                this.mViewManager.setOpacity(t, obj != null ? ((Double) obj).floatValue() : 1.0f);
                break;
            case 2:
                ((RNSVGClipPathManagerInterface) this.mViewManager).setMatrix(t, (ReadableArray) obj);
                break;
            case 3:
                ((RNSVGClipPathManagerInterface) this.mViewManager).setPropList(t, (ReadableArray) obj);
                break;
            case 4:
                ((RNSVGClipPathManagerInterface) this.mViewManager).setMarkerEnd(t, obj != null ? (String) obj : null);
                break;
            case 5:
                ((RNSVGClipPathManagerInterface) this.mViewManager).setMarkerMid(t, obj != null ? (String) obj : null);
                break;
            case 6:
                ((RNSVGClipPathManagerInterface) this.mViewManager).setStroke(t, new DynamicFromObject(obj));
                break;
            case 7:
                ((RNSVGClipPathManagerInterface) this.mViewManager).setFontWeight(t, new DynamicFromObject(obj));
                break;
            case 8:
                ((RNSVGClipPathManagerInterface) this.mViewManager).setFillRule(t, obj != null ? ((Double) obj).intValue() : 1);
                break;
            case 9:
                ((RNSVGClipPathManagerInterface) this.mViewManager).setStrokeOpacity(t, obj != null ? ((Double) obj).floatValue() : 1.0f);
                break;
            case 10:
                ((RNSVGClipPathManagerInterface) this.mViewManager).setPointerEvents(t, obj != null ? (String) obj : null);
                break;
            case 11:
                ((RNSVGClipPathManagerInterface) this.mViewManager).setFillOpacity(t, obj != null ? ((Double) obj).floatValue() : 1.0f);
                break;
            case 12:
                ((RNSVGClipPathManagerInterface) this.mViewManager).setStrokeDashoffset(t, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case 13:
                ((RNSVGClipPathManagerInterface) this.mViewManager).setFill(t, new DynamicFromObject(obj));
                break;
            case 14:
                ((RNSVGClipPathManagerInterface) this.mViewManager).setFont(t, new DynamicFromObject(obj));
                break;
            case 15:
                ((RNSVGClipPathManagerInterface) this.mViewManager).setMask(t, obj != null ? (String) obj : null);
                break;
            case 16:
                ((RNSVGClipPathManagerInterface) this.mViewManager).setName(t, obj != null ? (String) obj : null);
                break;
            case 17:
                ((RNSVGClipPathManagerInterface) this.mViewManager).setStrokeMiterlimit(t, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case 18:
                ((RNSVGClipPathManagerInterface) this.mViewManager).setColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case 19:
                ((RNSVGClipPathManagerInterface) this.mViewManager).setVectorEffect(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 20:
                ((RNSVGClipPathManagerInterface) this.mViewManager).setMarkerStart(t, obj != null ? (String) obj : null);
                break;
            case 21:
                ((RNSVGClipPathManagerInterface) this.mViewManager).setFontSize(t, new DynamicFromObject(obj));
                break;
            case 22:
                ((RNSVGClipPathManagerInterface) this.mViewManager).setStrokeDasharray(t, new DynamicFromObject(obj));
                break;
            case 23:
                ((RNSVGClipPathManagerInterface) this.mViewManager).setClipPath(t, obj != null ? (String) obj : null);
                break;
            case 24:
                ((RNSVGClipPathManagerInterface) this.mViewManager).setClipRule(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 25:
                ((RNSVGClipPathManagerInterface) this.mViewManager).setStrokeLinecap(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 26:
                ((RNSVGClipPathManagerInterface) this.mViewManager).setDisplay(t, obj != null ? (String) obj : null);
                break;
            case 27:
                ((RNSVGClipPathManagerInterface) this.mViewManager).setStrokeLinejoin(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 28:
                ((RNSVGClipPathManagerInterface) this.mViewManager).setResponsible(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 29:
                ((RNSVGClipPathManagerInterface) this.mViewManager).setStrokeWidth(t, new DynamicFromObject(obj));
                break;
            default:
                super.setProperty(t, str, obj);
                break;
        }
    }
}
