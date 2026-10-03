package com.salesforce.marketingcloud.messages.iam;

import android.content.res.Resources;
import android.graphics.Typeface;
import android.view.View;
import androidx.annotation.Nullable;
import com.salesforce.marketingcloud.R;

/* JADX INFO: loaded from: classes3.dex */
class l extends d {

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[InAppMessage.Size.values().length];
            a = iArr;
            try {
                iArr[InAppMessage.Size.l.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[InAppMessage.Size.m.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[InAppMessage.Size.s.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    l(View.OnClickListener onClickListener, @Nullable Typeface typeface) {
        super(onClickListener, typeface);
    }

    @Override // com.salesforce.marketingcloud.messages.iam.d
    protected float a(Resources resources, InAppMessage.Size size) {
        if (size == null) {
            size = InAppMessage.Size.s;
        }
        int i = a.a[size.ordinal()];
        if (i != 1) {
            return i != 2 ? resources.getDimension(R.dimen.mcsdk_iam_modal_body_font_small) : resources.getDimension(R.dimen.mcsdk_iam_modal_body_font_medium);
        }
        return resources.getDimension(R.dimen.mcsdk_iam_modal_body_font_large);
    }

    @Override // com.salesforce.marketingcloud.messages.iam.d
    protected float b(Resources resources, InAppMessage.Size size) {
        if (size == null) {
            size = InAppMessage.Size.s;
        }
        int i = a.a[size.ordinal()];
        if (i != 1) {
            return i != 2 ? resources.getDimension(R.dimen.mcsdk_iam_modal_btn_font_small) : resources.getDimension(R.dimen.mcsdk_iam_modal_btn_font_medium);
        }
        return resources.getDimension(R.dimen.mcsdk_iam_modal_btn_font_large);
    }

    @Override // com.salesforce.marketingcloud.messages.iam.d
    protected float c(Resources resources, InAppMessage.Size size) {
        if (size == null) {
            size = InAppMessage.Size.s;
        }
        int i = a.a[size.ordinal()];
        return (i == 1 || i == 2) ? resources.getDimension(R.dimen.mcsdk_iam_modal_title_font_large) : resources.getDimension(R.dimen.mcsdk_iam_modal_title_font_small);
    }

    @Override // com.salesforce.marketingcloud.messages.iam.d
    protected int d() {
        return R.id.mcsdk_iam_media_group;
    }

    @Override // com.salesforce.marketingcloud.messages.iam.d
    protected int e() {
        return R.id.mcsdk_iam_media;
    }

    @Override // com.salesforce.marketingcloud.messages.iam.d
    protected int f() {
        return R.id.mcsdk_iam_container;
    }

    @Override // com.salesforce.marketingcloud.messages.iam.d
    protected int g() {
        return R.id.mcsdk_iam_parent;
    }

    @Override // com.salesforce.marketingcloud.messages.iam.d
    protected int h() {
        return R.id.mcsdk_iam_title;
    }

    @Override // com.salesforce.marketingcloud.messages.iam.d
    protected float c(Resources resources) {
        return resources.getDimension(R.dimen.mcsdk_button_group_vertical_divider);
    }

    @Override // com.salesforce.marketingcloud.messages.iam.d
    protected float a(Resources resources) {
        return resources.getDimension(R.dimen.mcsdk_iam_modal_closebtn_hitbox_increase);
    }

    @Override // com.salesforce.marketingcloud.messages.iam.d
    protected float b(Resources resources) {
        return resources.getDimension(R.dimen.mcsdk_button_group_horizontal_divider);
    }

    @Override // com.salesforce.marketingcloud.messages.iam.d
    protected int c() {
        return R.id.mcsdk_iam_close;
    }

    @Override // com.salesforce.marketingcloud.messages.iam.d
    protected int a() {
        return R.id.mcsdk_iam_body;
    }

    @Override // com.salesforce.marketingcloud.messages.iam.d
    protected int b() {
        return R.id.mcsdk_iam_buttons;
    }
}
