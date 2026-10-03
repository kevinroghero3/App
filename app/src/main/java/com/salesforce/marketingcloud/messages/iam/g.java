package com.salesforce.marketingcloud.messages.iam;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.Dimension;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;

/* JADX INFO: loaded from: classes3.dex */
class g {

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[InAppMessage.Alignment.values().length];
            a = iArr;
            try {
                iArr[InAppMessage.Alignment.center.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[InAppMessage.Alignment.end.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[InAppMessage.Alignment.beginning.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private g() {
    }

    static void a(TextView textView, String str, @ColorInt int i, @Dimension float f, int i2) {
        textView.setText(str);
        textView.setTextColor(i);
        textView.setTextSize(0, f);
        textView.setGravity(i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r2v1, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r2v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    static int a(Context context, @Nullable String str, @ColorRes int i) {
        try {
            if (str != null) {
                context = Color.parseColor(str.replace("0x", "#"));
            } else {
                context = context.getResources().getColor(i);
            }
            return context;
        } catch (Exception unused) {
            return context.getResources().getColor(i);
        }
    }

    static int a(InAppMessage.Alignment alignment) {
        int i = a.a[alignment.ordinal()];
        if (i != 1) {
            return i != 2 ? GravityCompat.START : GravityCompat.END;
        }
        return 17;
    }

    static Drawable a(@ColorInt int i, float f, @ColorInt int i2, float f2) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        gradientDrawable.setColor(i);
        gradientDrawable.setStroke(Math.round(f2), i2);
        return gradientDrawable;
    }
}
