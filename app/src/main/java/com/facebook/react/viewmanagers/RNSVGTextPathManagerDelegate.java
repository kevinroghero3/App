package com.facebook.react.viewmanagers;

import android.view.View;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.DynamicFromObject;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface;
import com.google.common.base.Ascii;

/* JADX INFO: loaded from: classes.dex */
public class RNSVGTextPathManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & RNSVGTextPathManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public RNSVGTextPathManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:193:0x0288  */
    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public void setProperty(T t, String str, @Nullable Object obj) {
        byte b;
        str.hashCode();
        switch (str) {
            case "spacing":
                b = 0;
                break;
            case "startOffset":
                b = 1;
                break;
            case "lengthAdjust":
                b = 2;
                break;
            case "filter":
                b = 3;
                break;
            case "opacity":
                b = 4;
                break;
            case "alignmentBaseline":
                b = 5;
                break;
            case "verticalAlign":
                b = 6;
                break;
            case "matrix":
                b = 7;
                break;
            case "method":
                b = 8;
                break;
            case "propList":
                b = 9;
                break;
            case "markerEnd":
                b = 10;
                break;
            case "markerMid":
                b = Ascii.VT;
                break;
            case "rotate":
                b = Ascii.FF;
                break;
            case "stroke":
                b = Ascii.CR;
                break;
            case "fontWeight":
                b = Ascii.SO;
                break;
            case "fillRule":
                b = Ascii.SI;
                break;
            case "strokeOpacity":
                b = Ascii.DLE;
                break;
            case "pointerEvents":
                b = 17;
                break;
            case "fillOpacity":
                b = Ascii.DC2;
                break;
            case "strokeDashoffset":
                b = 19;
                break;
            case "x":
                b = Ascii.DC4;
                break;
            case "y":
                b = Ascii.NAK;
                break;
            case "dx":
                b = Ascii.SYN;
                break;
            case "dy":
                b = Ascii.ETB;
                break;
            case "fill":
                b = Ascii.CAN;
                break;
            case "font":
                b = Ascii.EM;
                break;
            case "href":
                b = Ascii.SUB;
                break;
            case "mask":
                b = Ascii.ESC;
                break;
            case "name":
                b = Ascii.FS;
                break;
            case "side":
                b = Ascii.GS;
                break;
            case "strokeMiterlimit":
                b = Ascii.RS;
                break;
            case "color":
                b = Ascii.US;
                break;
            case "vectorEffect":
                b = 32;
                break;
            case "markerStart":
                b = 33;
                break;
            case "baselineShift":
                b = 34;
                break;
            case "fontSize":
                b = 35;
                break;
            case "strokeDasharray":
                b = 36;
                break;
            case "inlineSize":
                b = 37;
                break;
            case "clipPath":
                b = 38;
                break;
            case "clipRule":
                b = 39;
                break;
            case "strokeLinecap":
                b = 40;
                break;
            case "midLine":
                b = 41;
                break;
            case "textLength":
                b = 42;
                break;
            case "display":
                b = 43;
                break;
            case "strokeLinejoin":
                b = 44;
                break;
            case "responsible":
                b = 45;
                break;
            case "strokeWidth":
                b = 46;
                break;
            default:
                b = -1;
                break;
        }
        switch (b) {
            case 0:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setSpacing(t, obj != null ? (String) obj : null);
                break;
            case 1:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setStartOffset(t, new DynamicFromObject(obj));
                break;
            case 2:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setLengthAdjust(t, obj != null ? (String) obj : null);
                break;
            case 3:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setFilter(t, obj != null ? (String) obj : null);
                break;
            case 4:
                this.mViewManager.setOpacity(t, obj != null ? ((Double) obj).floatValue() : 1.0f);
                break;
            case 5:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setAlignmentBaseline(t, obj != null ? (String) obj : null);
                break;
            case 6:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setVerticalAlign(t, new DynamicFromObject(obj));
                break;
            case 7:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setMatrix(t, (ReadableArray) obj);
                break;
            case 8:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setMethod(t, obj != null ? (String) obj : null);
                break;
            case 9:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setPropList(t, (ReadableArray) obj);
                break;
            case 10:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setMarkerEnd(t, obj != null ? (String) obj : null);
                break;
            case 11:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setMarkerMid(t, obj != null ? (String) obj : null);
                break;
            case 12:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setRotate(t, new DynamicFromObject(obj));
                break;
            case 13:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setStroke(t, new DynamicFromObject(obj));
                break;
            case 14:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setFontWeight(t, new DynamicFromObject(obj));
                break;
            case 15:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setFillRule(t, obj != null ? ((Double) obj).intValue() : 1);
                break;
            case 16:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setStrokeOpacity(t, obj != null ? ((Double) obj).floatValue() : 1.0f);
                break;
            case 17:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setPointerEvents(t, obj != null ? (String) obj : null);
                break;
            case 18:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setFillOpacity(t, obj != null ? ((Double) obj).floatValue() : 1.0f);
                break;
            case 19:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setStrokeDashoffset(t, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case 20:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setX(t, new DynamicFromObject(obj));
                break;
            case 21:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setY(t, new DynamicFromObject(obj));
                break;
            case 22:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setDx(t, new DynamicFromObject(obj));
                break;
            case 23:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setDy(t, new DynamicFromObject(obj));
                break;
            case 24:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setFill(t, new DynamicFromObject(obj));
                break;
            case 25:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setFont(t, new DynamicFromObject(obj));
                break;
            case 26:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setHref(t, obj != null ? (String) obj : null);
                break;
            case 27:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setMask(t, obj != null ? (String) obj : null);
                break;
            case 28:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setName(t, obj != null ? (String) obj : null);
                break;
            case 29:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setSide(t, obj != null ? (String) obj : null);
                break;
            case 30:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setStrokeMiterlimit(t, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case 31:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case 32:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setVectorEffect(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 33:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setMarkerStart(t, obj != null ? (String) obj : null);
                break;
            case 34:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setBaselineShift(t, new DynamicFromObject(obj));
                break;
            case 35:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setFontSize(t, new DynamicFromObject(obj));
                break;
            case 36:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setStrokeDasharray(t, new DynamicFromObject(obj));
                break;
            case 37:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setInlineSize(t, new DynamicFromObject(obj));
                break;
            case 38:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setClipPath(t, obj != null ? (String) obj : null);
                break;
            case 39:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setClipRule(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 40:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setStrokeLinecap(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 41:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setMidLine(t, obj != null ? (String) obj : null);
                break;
            case 42:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setTextLength(t, new DynamicFromObject(obj));
                break;
            case 43:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setDisplay(t, obj != null ? (String) obj : null);
                break;
            case 44:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setStrokeLinejoin(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 45:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setResponsible(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 46:
                ((RNSVGTextPathManagerInterface) this.mViewManager).setStrokeWidth(t, new DynamicFromObject(obj));
                break;
            default:
                super.setProperty(t, str, obj);
                break;
        }
    }
}
