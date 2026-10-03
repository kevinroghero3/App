package com.facebook.react.viewmanagers;

import android.view.View;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.DynamicFromObject;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.viewmanagers.RNSVGTextManagerInterface;
import com.google.common.base.Ascii;

/* JADX INFO: loaded from: classes.dex */
public class RNSVGTextManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & RNSVGTextManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public RNSVGTextManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:169:0x0234  */
    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public void setProperty(T t, String str, @Nullable Object obj) {
        byte b;
        str.hashCode();
        switch (str) {
            case "lengthAdjust":
                b = 0;
                break;
            case "filter":
                b = 1;
                break;
            case "opacity":
                b = 2;
                break;
            case "alignmentBaseline":
                b = 3;
                break;
            case "verticalAlign":
                b = 4;
                break;
            case "matrix":
                b = 5;
                break;
            case "propList":
                b = 6;
                break;
            case "markerEnd":
                b = 7;
                break;
            case "markerMid":
                b = 8;
                break;
            case "rotate":
                b = 9;
                break;
            case "stroke":
                b = 10;
                break;
            case "fontWeight":
                b = Ascii.VT;
                break;
            case "fillRule":
                b = Ascii.FF;
                break;
            case "strokeOpacity":
                b = Ascii.CR;
                break;
            case "pointerEvents":
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
            case "dx":
                b = 19;
                break;
            case "dy":
                b = Ascii.DC4;
                break;
            case "fill":
                b = Ascii.NAK;
                break;
            case "font":
                b = Ascii.SYN;
                break;
            case "mask":
                b = Ascii.ETB;
                break;
            case "name":
                b = Ascii.CAN;
                break;
            case "strokeMiterlimit":
                b = Ascii.EM;
                break;
            case "color":
                b = Ascii.SUB;
                break;
            case "vectorEffect":
                b = Ascii.ESC;
                break;
            case "markerStart":
                b = Ascii.FS;
                break;
            case "baselineShift":
                b = Ascii.GS;
                break;
            case "fontSize":
                b = Ascii.RS;
                break;
            case "strokeDasharray":
                b = Ascii.US;
                break;
            case "inlineSize":
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
            case "textLength":
                b = 36;
                break;
            case "display":
                b = 37;
                break;
            case "strokeLinejoin":
                b = 38;
                break;
            case "responsible":
                b = 39;
                break;
            case "strokeWidth":
                b = 40;
                break;
            default:
                b = -1;
                break;
        }
        switch (b) {
            case 0:
                ((RNSVGTextManagerInterface) this.mViewManager).setLengthAdjust(t, obj != null ? (String) obj : null);
                break;
            case 1:
                ((RNSVGTextManagerInterface) this.mViewManager).setFilter(t, obj != null ? (String) obj : null);
                break;
            case 2:
                this.mViewManager.setOpacity(t, obj != null ? ((Double) obj).floatValue() : 1.0f);
                break;
            case 3:
                ((RNSVGTextManagerInterface) this.mViewManager).setAlignmentBaseline(t, obj != null ? (String) obj : null);
                break;
            case 4:
                ((RNSVGTextManagerInterface) this.mViewManager).setVerticalAlign(t, new DynamicFromObject(obj));
                break;
            case 5:
                ((RNSVGTextManagerInterface) this.mViewManager).setMatrix(t, (ReadableArray) obj);
                break;
            case 6:
                ((RNSVGTextManagerInterface) this.mViewManager).setPropList(t, (ReadableArray) obj);
                break;
            case 7:
                ((RNSVGTextManagerInterface) this.mViewManager).setMarkerEnd(t, obj != null ? (String) obj : null);
                break;
            case 8:
                ((RNSVGTextManagerInterface) this.mViewManager).setMarkerMid(t, obj != null ? (String) obj : null);
                break;
            case 9:
                ((RNSVGTextManagerInterface) this.mViewManager).setRotate(t, new DynamicFromObject(obj));
                break;
            case 10:
                ((RNSVGTextManagerInterface) this.mViewManager).setStroke(t, new DynamicFromObject(obj));
                break;
            case 11:
                ((RNSVGTextManagerInterface) this.mViewManager).setFontWeight(t, new DynamicFromObject(obj));
                break;
            case 12:
                ((RNSVGTextManagerInterface) this.mViewManager).setFillRule(t, obj != null ? ((Double) obj).intValue() : 1);
                break;
            case 13:
                ((RNSVGTextManagerInterface) this.mViewManager).setStrokeOpacity(t, obj != null ? ((Double) obj).floatValue() : 1.0f);
                break;
            case 14:
                ((RNSVGTextManagerInterface) this.mViewManager).setPointerEvents(t, obj != null ? (String) obj : null);
                break;
            case 15:
                ((RNSVGTextManagerInterface) this.mViewManager).setFillOpacity(t, obj != null ? ((Double) obj).floatValue() : 1.0f);
                break;
            case 16:
                ((RNSVGTextManagerInterface) this.mViewManager).setStrokeDashoffset(t, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case 17:
                ((RNSVGTextManagerInterface) this.mViewManager).setX(t, new DynamicFromObject(obj));
                break;
            case 18:
                ((RNSVGTextManagerInterface) this.mViewManager).setY(t, new DynamicFromObject(obj));
                break;
            case 19:
                ((RNSVGTextManagerInterface) this.mViewManager).setDx(t, new DynamicFromObject(obj));
                break;
            case 20:
                ((RNSVGTextManagerInterface) this.mViewManager).setDy(t, new DynamicFromObject(obj));
                break;
            case 21:
                ((RNSVGTextManagerInterface) this.mViewManager).setFill(t, new DynamicFromObject(obj));
                break;
            case 22:
                ((RNSVGTextManagerInterface) this.mViewManager).setFont(t, new DynamicFromObject(obj));
                break;
            case 23:
                ((RNSVGTextManagerInterface) this.mViewManager).setMask(t, obj != null ? (String) obj : null);
                break;
            case 24:
                ((RNSVGTextManagerInterface) this.mViewManager).setName(t, obj != null ? (String) obj : null);
                break;
            case 25:
                ((RNSVGTextManagerInterface) this.mViewManager).setStrokeMiterlimit(t, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case 26:
                ((RNSVGTextManagerInterface) this.mViewManager).setColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case 27:
                ((RNSVGTextManagerInterface) this.mViewManager).setVectorEffect(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 28:
                ((RNSVGTextManagerInterface) this.mViewManager).setMarkerStart(t, obj != null ? (String) obj : null);
                break;
            case 29:
                ((RNSVGTextManagerInterface) this.mViewManager).setBaselineShift(t, new DynamicFromObject(obj));
                break;
            case 30:
                ((RNSVGTextManagerInterface) this.mViewManager).setFontSize(t, new DynamicFromObject(obj));
                break;
            case 31:
                ((RNSVGTextManagerInterface) this.mViewManager).setStrokeDasharray(t, new DynamicFromObject(obj));
                break;
            case 32:
                ((RNSVGTextManagerInterface) this.mViewManager).setInlineSize(t, new DynamicFromObject(obj));
                break;
            case 33:
                ((RNSVGTextManagerInterface) this.mViewManager).setClipPath(t, obj != null ? (String) obj : null);
                break;
            case 34:
                ((RNSVGTextManagerInterface) this.mViewManager).setClipRule(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 35:
                ((RNSVGTextManagerInterface) this.mViewManager).setStrokeLinecap(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 36:
                ((RNSVGTextManagerInterface) this.mViewManager).setTextLength(t, new DynamicFromObject(obj));
                break;
            case 37:
                ((RNSVGTextManagerInterface) this.mViewManager).setDisplay(t, obj != null ? (String) obj : null);
                break;
            case 38:
                ((RNSVGTextManagerInterface) this.mViewManager).setStrokeLinejoin(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 39:
                ((RNSVGTextManagerInterface) this.mViewManager).setResponsible(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 40:
                ((RNSVGTextManagerInterface) this.mViewManager).setStrokeWidth(t, new DynamicFromObject(obj));
                break;
            default:
                super.setProperty(t, str, obj);
                break;
        }
    }
}
