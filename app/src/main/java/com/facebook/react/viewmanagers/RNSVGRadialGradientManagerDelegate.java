package com.facebook.react.viewmanagers;

import android.view.View;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.DynamicFromObject;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.viewmanagers.RNSVGRadialGradientManagerInterface;
import com.google.common.base.Ascii;

/* JADX INFO: loaded from: classes.dex */
public class RNSVGRadialGradientManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & RNSVGRadialGradientManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public RNSVGRadialGradientManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:89:0x011b  */
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
            case "cx":
                b = 6;
                break;
            case "cy":
                b = 7;
                break;
            case "fx":
                b = 8;
                break;
            case "fy":
                b = 9;
                break;
            case "rx":
                b = 10;
                break;
            case "ry":
                b = Ascii.VT;
                break;
            case "mask":
                b = Ascii.FF;
                break;
            case "name":
                b = Ascii.CR;
                break;
            case "gradient":
                b = Ascii.SO;
                break;
            case "markerStart":
                b = Ascii.SI;
                break;
            case "clipPath":
                b = Ascii.DLE;
                break;
            case "clipRule":
                b = 17;
                break;
            case "display":
                b = Ascii.DC2;
                break;
            case "gradientTransform":
                b = 19;
                break;
            case "responsible":
                b = Ascii.DC4;
                break;
            default:
                b = -1;
                break;
        }
        switch (b) {
            case 0:
                ((RNSVGRadialGradientManagerInterface) this.mViewManager).setGradientUnits(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 1:
                this.mViewManager.setOpacity(t, obj == null ? 1.0f : ((Double) obj).floatValue());
                break;
            case 2:
                ((RNSVGRadialGradientManagerInterface) this.mViewManager).setMatrix(t, (ReadableArray) obj);
                break;
            case 3:
                ((RNSVGRadialGradientManagerInterface) this.mViewManager).setMarkerEnd(t, obj != null ? (String) obj : null);
                break;
            case 4:
                ((RNSVGRadialGradientManagerInterface) this.mViewManager).setMarkerMid(t, obj != null ? (String) obj : null);
                break;
            case 5:
                ((RNSVGRadialGradientManagerInterface) this.mViewManager).setPointerEvents(t, obj != null ? (String) obj : null);
                break;
            case 6:
                ((RNSVGRadialGradientManagerInterface) this.mViewManager).setCx(t, new DynamicFromObject(obj));
                break;
            case 7:
                ((RNSVGRadialGradientManagerInterface) this.mViewManager).setCy(t, new DynamicFromObject(obj));
                break;
            case 8:
                ((RNSVGRadialGradientManagerInterface) this.mViewManager).setFx(t, new DynamicFromObject(obj));
                break;
            case 9:
                ((RNSVGRadialGradientManagerInterface) this.mViewManager).setFy(t, new DynamicFromObject(obj));
                break;
            case 10:
                ((RNSVGRadialGradientManagerInterface) this.mViewManager).setRx(t, new DynamicFromObject(obj));
                break;
            case 11:
                ((RNSVGRadialGradientManagerInterface) this.mViewManager).setRy(t, new DynamicFromObject(obj));
                break;
            case 12:
                ((RNSVGRadialGradientManagerInterface) this.mViewManager).setMask(t, obj != null ? (String) obj : null);
                break;
            case 13:
                ((RNSVGRadialGradientManagerInterface) this.mViewManager).setName(t, obj != null ? (String) obj : null);
                break;
            case 14:
                ((RNSVGRadialGradientManagerInterface) this.mViewManager).setGradient(t, (ReadableArray) obj);
                break;
            case 15:
                ((RNSVGRadialGradientManagerInterface) this.mViewManager).setMarkerStart(t, obj != null ? (String) obj : null);
                break;
            case 16:
                ((RNSVGRadialGradientManagerInterface) this.mViewManager).setClipPath(t, obj != null ? (String) obj : null);
                break;
            case 17:
                ((RNSVGRadialGradientManagerInterface) this.mViewManager).setClipRule(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 18:
                ((RNSVGRadialGradientManagerInterface) this.mViewManager).setDisplay(t, obj != null ? (String) obj : null);
                break;
            case 19:
                ((RNSVGRadialGradientManagerInterface) this.mViewManager).setGradientTransform(t, (ReadableArray) obj);
                break;
            case 20:
                ((RNSVGRadialGradientManagerInterface) this.mViewManager).setResponsible(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            default:
                super.setProperty(t, str, obj);
                break;
        }
    }
}
