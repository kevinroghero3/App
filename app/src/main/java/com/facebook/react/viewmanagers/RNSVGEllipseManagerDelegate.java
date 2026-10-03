package com.facebook.react.viewmanagers;

import android.view.View;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.DynamicFromObject;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.viewmanagers.RNSVGEllipseManagerInterface;
import com.google.common.base.Ascii;

/* JADX INFO: loaded from: classes.dex */
public class RNSVGEllipseManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & RNSVGEllipseManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public RNSVGEllipseManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:129:0x01a8  */
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
            case "fillRule":
                b = 7;
                break;
            case "strokeOpacity":
                b = 8;
                break;
            case "pointerEvents":
                b = 9;
                break;
            case "fillOpacity":
                b = 10;
                break;
            case "strokeDashoffset":
                b = Ascii.VT;
                break;
            case "cx":
                b = Ascii.FF;
                break;
            case "cy":
                b = Ascii.CR;
                break;
            case "rx":
                b = Ascii.SO;
                break;
            case "ry":
                b = Ascii.SI;
                break;
            case "fill":
                b = Ascii.DLE;
                break;
            case "mask":
                b = 17;
                break;
            case "name":
                b = Ascii.DC2;
                break;
            case "strokeMiterlimit":
                b = 19;
                break;
            case "color":
                b = Ascii.DC4;
                break;
            case "vectorEffect":
                b = Ascii.NAK;
                break;
            case "markerStart":
                b = Ascii.SYN;
                break;
            case "strokeDasharray":
                b = Ascii.ETB;
                break;
            case "clipPath":
                b = Ascii.CAN;
                break;
            case "clipRule":
                b = Ascii.EM;
                break;
            case "strokeLinecap":
                b = Ascii.SUB;
                break;
            case "display":
                b = Ascii.ESC;
                break;
            case "strokeLinejoin":
                b = Ascii.FS;
                break;
            case "responsible":
                b = Ascii.GS;
                break;
            case "strokeWidth":
                b = Ascii.RS;
                break;
            default:
                b = -1;
                break;
        }
        switch (b) {
            case 0:
                ((RNSVGEllipseManagerInterface) this.mViewManager).setFilter(t, obj != null ? (String) obj : null);
                break;
            case 1:
                this.mViewManager.setOpacity(t, obj != null ? ((Double) obj).floatValue() : 1.0f);
                break;
            case 2:
                ((RNSVGEllipseManagerInterface) this.mViewManager).setMatrix(t, (ReadableArray) obj);
                break;
            case 3:
                ((RNSVGEllipseManagerInterface) this.mViewManager).setPropList(t, (ReadableArray) obj);
                break;
            case 4:
                ((RNSVGEllipseManagerInterface) this.mViewManager).setMarkerEnd(t, obj != null ? (String) obj : null);
                break;
            case 5:
                ((RNSVGEllipseManagerInterface) this.mViewManager).setMarkerMid(t, obj != null ? (String) obj : null);
                break;
            case 6:
                ((RNSVGEllipseManagerInterface) this.mViewManager).setStroke(t, new DynamicFromObject(obj));
                break;
            case 7:
                ((RNSVGEllipseManagerInterface) this.mViewManager).setFillRule(t, obj != null ? ((Double) obj).intValue() : 1);
                break;
            case 8:
                ((RNSVGEllipseManagerInterface) this.mViewManager).setStrokeOpacity(t, obj != null ? ((Double) obj).floatValue() : 1.0f);
                break;
            case 9:
                ((RNSVGEllipseManagerInterface) this.mViewManager).setPointerEvents(t, obj != null ? (String) obj : null);
                break;
            case 10:
                ((RNSVGEllipseManagerInterface) this.mViewManager).setFillOpacity(t, obj != null ? ((Double) obj).floatValue() : 1.0f);
                break;
            case 11:
                ((RNSVGEllipseManagerInterface) this.mViewManager).setStrokeDashoffset(t, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case 12:
                ((RNSVGEllipseManagerInterface) this.mViewManager).setCx(t, new DynamicFromObject(obj));
                break;
            case 13:
                ((RNSVGEllipseManagerInterface) this.mViewManager).setCy(t, new DynamicFromObject(obj));
                break;
            case 14:
                ((RNSVGEllipseManagerInterface) this.mViewManager).setRx(t, new DynamicFromObject(obj));
                break;
            case 15:
                ((RNSVGEllipseManagerInterface) this.mViewManager).setRy(t, new DynamicFromObject(obj));
                break;
            case 16:
                ((RNSVGEllipseManagerInterface) this.mViewManager).setFill(t, new DynamicFromObject(obj));
                break;
            case 17:
                ((RNSVGEllipseManagerInterface) this.mViewManager).setMask(t, obj != null ? (String) obj : null);
                break;
            case 18:
                ((RNSVGEllipseManagerInterface) this.mViewManager).setName(t, obj != null ? (String) obj : null);
                break;
            case 19:
                ((RNSVGEllipseManagerInterface) this.mViewManager).setStrokeMiterlimit(t, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case 20:
                ((RNSVGEllipseManagerInterface) this.mViewManager).setColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case 21:
                ((RNSVGEllipseManagerInterface) this.mViewManager).setVectorEffect(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 22:
                ((RNSVGEllipseManagerInterface) this.mViewManager).setMarkerStart(t, obj != null ? (String) obj : null);
                break;
            case 23:
                ((RNSVGEllipseManagerInterface) this.mViewManager).setStrokeDasharray(t, new DynamicFromObject(obj));
                break;
            case 24:
                ((RNSVGEllipseManagerInterface) this.mViewManager).setClipPath(t, obj != null ? (String) obj : null);
                break;
            case 25:
                ((RNSVGEllipseManagerInterface) this.mViewManager).setClipRule(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 26:
                ((RNSVGEllipseManagerInterface) this.mViewManager).setStrokeLinecap(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 27:
                ((RNSVGEllipseManagerInterface) this.mViewManager).setDisplay(t, obj != null ? (String) obj : null);
                break;
            case 28:
                ((RNSVGEllipseManagerInterface) this.mViewManager).setStrokeLinejoin(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 29:
                ((RNSVGEllipseManagerInterface) this.mViewManager).setResponsible(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 30:
                ((RNSVGEllipseManagerInterface) this.mViewManager).setStrokeWidth(t, new DynamicFromObject(obj));
                break;
            default:
                super.setProperty(t, str, obj);
                break;
        }
    }
}
