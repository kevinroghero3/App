package com.salesforce.marketingcloud.messages.iam;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.salesforce.marketingcloud.R;
import com.salesforce.marketingcloud.media.o;
import com.salesforce.marketingcloud.media.u;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
abstract class d {
    private final View.OnClickListener a;
    private final Typeface b;

    class a implements Comparator<InAppMessage.Button> {
        a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(InAppMessage.Button button, InAppMessage.Button button2) {
            return button.index() - button2.index();
        }
    }

    class b implements Runnable {
        final /* synthetic */ View b;
        final /* synthetic */ int c;
        final /* synthetic */ View d;

        b(View view, int i, View view2) {
            this.b = view;
            this.c = i;
            this.d = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Rect rect = new Rect();
            this.b.getHitRect(rect);
            int i = rect.top;
            int i2 = this.c;
            rect.top = i - i2;
            rect.left -= i2;
            rect.bottom += i2;
            rect.right += i2;
            this.d.setTouchDelegate(new TouchDelegate(rect, this.b));
        }
    }

    static /* synthetic */ class c {
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

    d(View.OnClickListener onClickListener, @Nullable Typeface typeface) {
        this.a = onClickListener;
        this.b = typeface;
    }

    static boolean a(InAppMessage.TextField textField) {
        return (textField == null || TextUtils.isEmpty(textField.text())) ? false : true;
    }

    protected abstract float a(Resources resources);

    protected abstract float a(Resources resources, InAppMessage.Size size);

    protected abstract int a();

    protected abstract float b(Resources resources);

    protected abstract float b(Resources resources, InAppMessage.Size size);

    protected abstract int b();

    protected void b(@NonNull View view, @NonNull k kVar) {
    }

    protected abstract float c(Resources resources);

    protected abstract float c(Resources resources, InAppMessage.Size size);

    protected abstract int c();

    protected abstract int d();

    protected abstract int e();

    protected abstract int f();

    protected abstract int g();

    protected abstract int h();

    static boolean a(InAppMessage inAppMessage) {
        return ((inAppMessage.type() == InAppMessage.Type.full || inAppMessage.type() == InAppMessage.Type.modal) && inAppMessage.closeButton() == null && (inAppMessage.buttons() == null || inAppMessage.buttons().isEmpty())) ? false : true;
    }

    private float b(Context context, InAppMessage.Size size) {
        if (size == null) {
            size = InAppMessage.Size.s;
        }
        Resources resources = context.getResources();
        int i = c.a[size.ordinal()];
        if (i != 1) {
            return i != 2 ? resources.getDimension(R.dimen.mcsdk_corner_radius_small) : resources.getDimension(R.dimen.mcsdk_corner_radius_medium);
        }
        return resources.getDimension(R.dimen.mcsdk_corner_radius_large);
    }

    void a(View view, k kVar) {
        if (kVar == null || view == null) {
            return;
        }
        InAppMessage inAppMessageL = kVar.l();
        a(view, inAppMessageL.windowColor());
        a(view, inAppMessageL.backgroundColor(), inAppMessageL.borderColor(), inAppMessageL.borderWidth(), inAppMessageL.cornerRadius());
        b(view, inAppMessageL.title());
        a(view, inAppMessageL.body());
        a(view, a(inAppMessageL) ? inAppMessageL.closeButton() : com.salesforce.marketingcloud.internal.c.a());
        List<InAppMessage.Button> listButtons = inAppMessageL.buttons();
        if (listButtons != null && !listButtons.isEmpty()) {
            ArrayList arrayList = new ArrayList(listButtons);
            Collections.sort(arrayList, new a());
            a(view, inAppMessageL.buttonConfiguration(), arrayList);
        } else {
            View viewFindViewById = view.findViewById(b());
            if (viewFindViewById != null) {
                viewFindViewById.setVisibility(8);
            }
        }
        a(view, kVar.m(), inAppMessageL.media(), inAppMessageL.type());
        b(view, kVar);
    }

    private void b(View view, InAppMessage.TextField textField) {
        TextView textView = (TextView) view.findViewById(h());
        if (textView == null) {
            return;
        }
        if (a(textField)) {
            textView.setVisibility(0);
            Typeface typeface = this.b;
            if (typeface != null) {
                textView.setTypeface(typeface, 1);
            }
            g.a(textView, textField.text(), g.a(view.getContext(), textField.fontColor(), R.color.mcsdk_iam_default_font_color), c(view.getContext().getResources(), textField.fontSize()), g.a(textField.alignment()));
            return;
        }
        textView.setVisibility(8);
    }

    private void b(ViewGroup viewGroup) {
        Space space = new Space(viewGroup.getContext());
        space.setLayoutParams(new LinearLayout.LayoutParams(-1, Math.round(c(viewGroup.getResources()))));
        viewGroup.addView(space);
    }

    private float a(Context context, InAppMessage.Size size) {
        if (size == null) {
            size = InAppMessage.Size.s;
        }
        Resources resources = context.getResources();
        int i = c.a[size.ordinal()];
        if (i == 1) {
            return resources.getDimension(R.dimen.mcsdk_border_width_large);
        }
        if (i != 2) {
            return resources.getDimension(R.dimen.mcsdk_border_width_small);
        }
        return resources.getDimension(R.dimen.mcsdk_border_width_medium);
    }

    protected void a(View view, @Nullable String str) {
        View viewFindViewById = view.findViewById(g());
        if (viewFindViewById == null) {
            return;
        }
        viewFindViewById.setBackgroundColor(g.a(view.getContext(), str, R.color.mcsdk_iam_default_window_background));
    }

    protected void a(View view, String str, String str2, InAppMessage.Size size, InAppMessage.Size size2) {
        View viewFindViewById = view.findViewById(f());
        if (viewFindViewById == null) {
            return;
        }
        Context context = view.getContext();
        float fB = b(context, size2);
        float fA = a(context, size);
        ViewCompat.setBackground(viewFindViewById, g.a(g.a(context, str, R.color.mcsdk_iam_default_message_background), fB, g.a(context, str2, R.color.mcsdk_iam_default_border), fA));
        if (viewFindViewById instanceof ClippingConstraintLayout) {
            ((ClippingConstraintLayout) viewFindViewById).setClippingDetails(fA, fB);
        }
    }

    private void a(View view, InAppMessage.TextField textField) {
        TextView textView = (TextView) view.findViewById(a());
        if (textView == null) {
            return;
        }
        if (a(textField)) {
            textView.setVisibility(0);
            Typeface typeface = this.b;
            if (typeface != null) {
                textView.setTypeface(typeface, 0);
            }
            g.a(textView, textField.text(), g.a(view.getContext(), textField.fontColor(), R.color.mcsdk_iam_default_font_color), a(view.getContext().getResources(), textField.fontSize()), g.a(textField.alignment()));
            return;
        }
        textView.setVisibility(8);
    }

    private void a(View view, InAppMessage.CloseButton closeButton) {
        ImageButton imageButton = (ImageButton) view.findViewById(c());
        if (imageButton == null) {
            return;
        }
        if (closeButton != null) {
            ViewCompat.setTranslationZ(imageButton, 1.0f);
            imageButton.setVisibility(0);
            imageButton.setTag(closeButton);
            imageButton.setOnClickListener(this.a);
            a(imageButton);
            return;
        }
        imageButton.setVisibility(8);
    }

    private void a(View view) {
        if (view == null) {
            return;
        }
        View view2 = (View) view.getParent();
        view2.post(new b(view, Math.round(a(view.getContext().getResources())), view2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r6v8 */
    protected void a(View view, InAppMessage.ButtonConfig buttonConfig, List<InAppMessage.Button> list) {
        int i;
        Context context = view.getContext();
        LinearLayout linearLayout = (LinearLayout) view.findViewById(b());
        ?? r6 = 0;
        if (buttonConfig == InAppMessage.ButtonConfig.stacked) {
            linearLayout.setOrientation(1);
            i = R.layout.mcsdk_iam_stacked_button;
        } else {
            linearLayout.setOrientation(0);
            i = R.layout.mcsdk_iam_sbs_button;
        }
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        int size = list.size();
        int i2 = 0;
        while (i2 < 2 && i2 < size) {
            InAppMessage.Button button = list.get(i2);
            Button button2 = (Button) layoutInflaterFrom.inflate(i, linearLayout, (boolean) r6);
            Typeface typeface = this.b;
            if (typeface != null) {
                button2.setTypeface(typeface, r6);
            }
            g.a(button2, button.text(), g.a(context, button.fontColor(), R.color.mcsdk_iam_default_font_color), b(context.getResources(), button.fontSize()), g.a(InAppMessage.Alignment.center));
            ViewCompat.setBackground(button2, g.a(g.a(context, button.backgroundColor(), R.color.mcsdk_iam_default_btn_background), b(context, button.cornerRadius()), g.a(context, button.borderColor(), R.color.mcsdk_iam_default_border), a(context, button.borderWidth())));
            button2.setTag(button);
            button2.setOnClickListener(this.a);
            linearLayout.addView(button2);
            if (i2 == 0 && size > 1) {
                if (buttonConfig == InAppMessage.ButtonConfig.stacked) {
                    b(linearLayout);
                } else {
                    a((ViewGroup) linearLayout);
                }
            }
            i2++;
            r6 = 0;
        }
    }

    private void a(ViewGroup viewGroup) {
        Space space = new Space(viewGroup.getContext());
        space.setLayoutParams(new LinearLayout.LayoutParams(Math.round(b(viewGroup.getResources())), -1));
        viewGroup.addView(space);
    }

    private void a(View view, o oVar, InAppMessage.Media media, InAppMessage.Type type) {
        ImageView imageView = (ImageView) view.findViewById(e());
        if (imageView == null) {
            return;
        }
        Context context = view.getContext();
        if (media == null) {
            View viewFindViewById = view.findViewById(d());
            if (viewFindViewById != null) {
                viewFindViewById.setVisibility(8);
                return;
            } else {
                imageView.setVisibility(8);
                return;
            }
        }
        if (oVar != null) {
            imageView.setVisibility(0);
            u uVarD = oVar.b(media.url()).d();
            if (type == InAppMessage.Type.fullImageFill) {
                uVarD.b();
            } else {
                uVarD.a();
            }
            uVarD.a(b(context, media.cornerRadius()), a(context, media.borderWidth()), g.a(context, media.borderColor(), R.color.mcsdk_iam_default_border)).a(imageView);
        }
    }
}
