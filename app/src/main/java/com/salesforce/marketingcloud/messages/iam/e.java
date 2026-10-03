package com.salesforce.marketingcloud.messages.iam;

import android.content.res.Resources;
import android.graphics.Typeface;
import android.view.View;
import androidx.annotation.Nullable;
import com.salesforce.marketingcloud.R;

/* JADX INFO: loaded from: classes3.dex */
class e extends d {

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

    e(View.OnClickListener onClickListener, @Nullable Typeface typeface) {
        super(onClickListener, typeface);
    }

    @Override // com.salesforce.marketingcloud.messages.iam.d
    protected void a(View view, String str) {
    }

    @Override // com.salesforce.marketingcloud.messages.iam.d
    protected float b(Resources resources, InAppMessage.Size size) {
        if (size == null) {
            size = InAppMessage.Size.s;
        }
        int i = a.a[size.ordinal()];
        if (i != 1) {
            return i != 2 ? resources.getDimension(R.dimen.mcsdk_iam_fs_btn_font_small) : resources.getDimension(R.dimen.mcsdk_iam_fs_btn_font_medium);
        }
        return resources.getDimension(R.dimen.mcsdk_iam_fs_btn_font_large);
    }

    @Override // com.salesforce.marketingcloud.messages.iam.d
    protected float c(Resources resources, InAppMessage.Size size) {
        if (size == null) {
            size = InAppMessage.Size.s;
        }
        int i = a.a[size.ordinal()];
        return (i == 1 || i == 2) ? resources.getDimension(R.dimen.mcsdk_iam_fs_title_font_large) : resources.getDimension(R.dimen.mcsdk_iam_fs_title_font_small);
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
        return 0;
    }

    @Override // com.salesforce.marketingcloud.messages.iam.d
    protected int h() {
        return R.id.mcsdk_iam_title;
    }

    @Override // com.salesforce.marketingcloud.messages.iam.d
    protected void a(View view, String str, String str2, InAppMessage.Size size, InAppMessage.Size size2) {
        View viewFindViewById = view.findViewById(f());
        if (str == null || viewFindViewById == null) {
            return;
        }
        viewFindViewById.setBackgroundColor(g.a(view.getContext(), str, R.color.mcsdk_iam_default_message_background));
    }

    @Override // com.salesforce.marketingcloud.messages.iam.d
    protected float a(Resources resources, InAppMessage.Size size) {
        if (size == null) {
            size = InAppMessage.Size.s;
        }
        int i = a.a[size.ordinal()];
        if (i == 1) {
            return resources.getDimension(R.dimen.mcsdk_iam_fs_body_font_large);
        }
        if (i != 2) {
            return resources.getDimension(R.dimen.mcsdk_iam_fs_body_font_small);
        }
        return resources.getDimension(R.dimen.mcsdk_iam_fs_body_font_medium);
    }

    @Override // com.salesforce.marketingcloud.messages.iam.d
    protected float c(Resources resources) {
        return resources.getDimension(R.dimen.mcsdk_button_group_vertical_divider);
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
    protected int b() {
        return R.id.mcsdk_iam_buttons;
    }

    @Override // com.salesforce.marketingcloud.messages.iam.d
    protected float a(Resources resources) {
        return resources.getDimension(R.dimen.mcsdk_iam_fs_closebtn_hitbox_increase);
    }

    @Override // com.salesforce.marketingcloud.messages.iam.d
    protected int a() {
        return R.id.mcsdk_iam_body;
    }
}
