package com.google.android.material.timepicker;

import android.content.Context;
import android.util.Base64;
import android.view.View;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes5.dex */
class ClickActionDelegate extends AccessibilityDelegateCompat {
    private static int artificialFrame = 1;
    private static byte extraCallback = -124;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME;
    private final AccessibilityNodeInfoCompat.AccessibilityActionCompat clickAction;

    public ClickActionDelegate(Context context, int i) {
        String string = context.getString(i);
        if (string.startsWith(".,.%")) {
            Object[] objArr = new Object[1];
            a(string.substring(4), objArr);
            string = ((String) objArr[0]).intern();
            int i2 = getARTIFICIAL_FRAME_PACKAGE_NAME + 53;
            artificialFrame = i2 % 128;
            if (i2 % 2 == 0) {
                int i3 = 2 / 5;
            } else {
                int i4 = 2 % 2;
            }
        }
        this.clickAction = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16, string);
    }

    private static void a(String str, Object[] objArr) {
        byte[] bArrDecode = Base64.decode(str, 0);
        byte[] bArr = new byte[bArrDecode.length];
        for (int i = 0; i < bArrDecode.length; i++) {
            bArr[i] = (byte) (bArrDecode[(bArrDecode.length - i) - 1] ^ extraCallback);
        }
        objArr[0] = new String(bArr, StandardCharsets.UTF_8);
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        accessibilityNodeInfoCompat.addAction(this.clickAction);
    }
}
