package com.facebook.react.viewmanagers;

import android.view.View;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.DynamicFromObject;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.viewmanagers.RNSVGLinearGradientManagerInterface;
import com.google.common.base.Ascii;

/* JADX INFO: loaded from: classes.dex */
public class RNSVGLinearGradientManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & RNSVGLinearGradientManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public RNSVGLinearGradientManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:81:0x00ff  */
    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public void setProperty(T t, String str, @Nullable Object obj) {
        byte b;
        str.hashCode();
        switch (str) {
            case "gradientUnits":
                b = 0;
                break;
            case "opacity":
                b = 1;
                break;
            case "matrix":
                b = 2;
                break;
            case "markerEnd":
                b = 3;
                break;
            case "markerMid":
                b = 4;
                break;
            case "pointerEvents":
                b = 5;
                break;
            case "x1":
                b = 6;
                break;
            case "x2":
                b = 7;
                break;
            case "y1":
                b = 8;
                break;
            case "y2":
                b = 9;
                break;
            case "mask":
                b = 10;
                break;
            case "name":
                b = Ascii.VT;
                break;
            case "gradient":
                b = Ascii.FF;
                break;
            case "markerStart":
                b = Ascii.CR;
                break;
            case "clipPath":
                b = Ascii.SO;
                break;
            case "clipRule":
                b = Ascii.SI;
                break;
            case "display":
                b = Ascii.DLE;
                break;
            case "gradientTransform":
                b = 17;
                break;
            case "responsible":
                b = Ascii.DC2;
                break;
            default:
                b = -1;
                break;
        }
        switch (b) {
            case 0:
                ((RNSVGLinearGradientManagerInterface) this.mViewManager).setGradientUnits(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 1:
                this.mViewManager.setOpacity(t, obj == null ? 1.0f : ((Double) obj).floatValue());
                break;
            case 2:
                ((RNSVGLinearGradientManagerInterface) this.mViewManager).setMatrix(t, (ReadableArray) obj);
                break;
            case 3:
                ((RNSVGLinearGradientManagerInterface) this.mViewManager).setMarkerEnd(t, obj != null ? (String) obj : null);
                break;
            case 4:
                ((RNSVGLinearGradientManagerInterface) this.mViewManager).setMarkerMid(t, obj != null ? (String) obj : null);
                break;
            case 5:
                ((RNSVGLinearGradientManagerInterface) this.mViewManager).setPointerEvents(t, obj != null ? (String) obj : null);
                break;
            case 6:
                ((RNSVGLinearGradientManagerInterface) this.mViewManager).setX1(t, new DynamicFromObject(obj));
                break;
            case 7:
                ((RNSVGLinearGradientManagerInterface) this.mViewManager).setX2(t, new DynamicFromObject(obj));
                break;
            case 8:
                ((RNSVGLinearGradientManagerInterface) this.mViewManager).setY1(t, new DynamicFromObject(obj));
                break;
            case 9:
                ((RNSVGLinearGradientManagerInterface) this.mViewManager).setY2(t, new DynamicFromObject(obj));
                break;
            case 10:
                ((RNSVGLinearGradientManagerInterface) this.mViewManager).setMask(t, obj != null ? (String) obj : null);
                break;
            case 11:
                ((RNSVGLinearGradientManagerInterface) this.mViewManager).setName(t, obj != null ? (String) obj : null);
                break;
            case 12:
                ((RNSVGLinearGradientManagerInterface) this.mViewManager).setGradient(t, (ReadableArray) obj);
                break;
            case 13:
                ((RNSVGLinearGradientManagerInterface) this.mViewManager).setMarkerStart(t, obj != null ? (String) obj : null);
                break;
            case 14:
                ((RNSVGLinearGradientManagerInterface) this.mViewManager).setClipPath(t, obj != null ? (String) obj : null);
                break;
            case 15:
                ((RNSVGLinearGradientManagerInterface) this.mViewManager).setClipRule(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 16:
                ((RNSVGLinearGradientManagerInterface) this.mViewManager).setDisplay(t, obj != null ? (String) obj : null);
                break;
            case 17:
                ((RNSVGLinearGradientManagerInterface) this.mViewManager).setGradientTransform(t, (ReadableArray) obj);
                break;
            case 18:
                ((RNSVGLinearGradientManagerInterface) this.mViewManager).setResponsible(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            default:
                super.setProperty(t, str, obj);
                break;
        }
    }
}
