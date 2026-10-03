package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R;
import com.salesforce.marketingcloud.analytics.stats.b;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes5.dex */
public class Snackbar extends BaseTransientBottomBar<Snackbar> {
    private static final int[] SNACKBAR_BUTTON_STYLE_ATTR;
    private static final int[] SNACKBAR_CONTENT_STYLE_ATTRS;
    private static int artificialFrame = 1;
    private static byte extraCallback;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME;
    private final AccessibilityManager accessibilityManager;
    private BaseTransientBottomBar.BaseCallback<Snackbar> callback;
    private boolean hasAction;

    public static class Callback extends BaseTransientBottomBar.BaseCallback<Snackbar> {
        public static final int DISMISS_EVENT_ACTION = 1;
        public static final int DISMISS_EVENT_CONSECUTIVE = 4;
        public static final int DISMISS_EVENT_MANUAL = 3;
        public static final int DISMISS_EVENT_SWIPE = 0;
        public static final int DISMISS_EVENT_TIMEOUT = 2;

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.BaseCallback
        public void onDismissed(Snackbar snackbar, int i) {
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.BaseCallback
        public void onShown(Snackbar snackbar) {
        }
    }

    private static void a(String str, Object[] objArr) {
        byte[] bArrDecode = Base64.decode(str, 0);
        byte[] bArr = new byte[bArrDecode.length];
        for (int i = 0; i < bArrDecode.length; i++) {
            bArr[i] = (byte) (bArrDecode[(bArrDecode.length - i) - 1] ^ extraCallback);
        }
        objArr[0] = new String(bArr, StandardCharsets.UTF_8);
    }

    static {
        accessartificialFrame();
        int i = R.attr.snackbarButtonStyle;
        SNACKBAR_BUTTON_STYLE_ATTR = new int[]{i};
        SNACKBAR_CONTENT_STYLE_ATTRS = new int[]{i, R.attr.snackbarTextViewStyle};
    }

    private Snackbar(@NonNull Context context, @NonNull ViewGroup viewGroup, @NonNull View view, @NonNull ContentViewCallback contentViewCallback) {
        super(context, viewGroup, view, contentViewCallback);
        this.accessibilityManager = (AccessibilityManager) viewGroup.getContext().getSystemService("accessibility");
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public void show() {
        super.show();
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public void dismiss() {
        super.dismiss();
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public boolean isShown() {
        return super.isShown();
    }

    public static Snackbar make(@NonNull View view, @NonNull CharSequence charSequence, int i) {
        return makeInternal(null, view, charSequence, i);
    }

    public static Snackbar make(@NonNull Context context, @NonNull View view, @NonNull CharSequence charSequence, int i) {
        return makeInternal(context, view, charSequence, i);
    }

    private static Snackbar makeInternal(@Nullable Context context, @NonNull View view, @NonNull CharSequence charSequence, int i) {
        int i2;
        ViewGroup viewGroupFindSuitableParent = findSuitableParent(view);
        if (viewGroupFindSuitableParent == null) {
            throw new IllegalArgumentException("No suitable parent found from the given view. Please provide a valid view.");
        }
        if (context == null) {
            context = viewGroupFindSuitableParent.getContext();
        }
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        if (hasSnackbarContentStyleAttrs(context)) {
            i2 = R.layout.mtrl_layout_snackbar_include;
        } else {
            i2 = R.layout.design_layout_snackbar_include;
        }
        SnackbarContentLayout snackbarContentLayout = (SnackbarContentLayout) layoutInflaterFrom.inflate(i2, viewGroupFindSuitableParent, false);
        Snackbar snackbar = new Snackbar(context, viewGroupFindSuitableParent, snackbarContentLayout, snackbarContentLayout);
        snackbar.setText(charSequence);
        snackbar.setDuration(i);
        return snackbar;
    }

    @Deprecated
    protected static boolean hasSnackbarButtonStyleAttr(@NonNull Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(SNACKBAR_BUTTON_STYLE_ATTR);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId != -1;
    }

    private static boolean hasSnackbarContentStyleAttrs(@NonNull Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(SNACKBAR_CONTENT_STYLE_ATTRS);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(1, -1);
        typedArrayObtainStyledAttributes.recycle();
        return (resourceId == -1 || resourceId2 == -1) ? false : true;
    }

    public static Snackbar make(@NonNull View view, @StringRes int i, int i2) {
        String strIntern;
        int i3 = 2 % 2;
        int i4 = artificialFrame + b.f40o;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i4 % 128;
        int i5 = i4 % 2;
        Resources resources = view.getResources();
        String string = resources.getString(i);
        boolean zStartsWith = string.startsWith(".,.%");
        CharSequence charSequence = string;
        if (zStartsWith) {
            int i6 = getARTIFICIAL_FRAME_PACKAGE_NAME + 31;
            artificialFrame = i6 % 128;
            int i7 = i6 % 2;
            Object[] objArr = new Object[1];
            a(string.substring(4), objArr);
            strIntern = ((String) objArr[0]).intern();
            CharSequence text = resources.getText(i);
            if (text instanceof Spanned) {
                charSequence = strIntern;
                SpannableString spannableString = new SpannableString(strIntern);
                TextUtils.copySpansFrom((SpannedString) text, 0, strIntern.length(), Object.class, spannableString, 0);
                int i8 = getARTIFICIAL_FRAME_PACKAGE_NAME + 79;
                artificialFrame = i8 % 128;
                int i9 = i8 % 2;
                charSequence = spannableString;
            }
        }
        charSequence = strIntern;
        return make(view, charSequence, i2);
    }

    private static ViewGroup findSuitableParent(View view) {
        ViewGroup viewGroup = null;
        while (!(view instanceof CoordinatorLayout)) {
            if (view instanceof FrameLayout) {
                if (view.getId() == 16908290) {
                    return (ViewGroup) view;
                }
                viewGroup = (ViewGroup) view;
            }
            if (view != null) {
                Object parent = view.getParent();
                view = parent instanceof View ? (View) parent : null;
            }
            if (view == null) {
                return viewGroup;
            }
        }
        return (ViewGroup) view;
    }

    public Snackbar setText(@NonNull CharSequence charSequence) {
        getMessageView().setText(charSequence);
        return this;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x004c  */
    /* JADX WARN: Code duplicated, block: B:9:0x0031 A[PHI: r1 r4
  0x0031: PHI (r1v5 android.content.Context) = (r1v4 android.content.Context), (r1v11 android.content.Context) binds: [B:8:0x002f, B:5:0x0020] A[DONT_GENERATE, DONT_INLINE]
  0x0031: PHI (r4v1 java.lang.String) = (r4v11 java.lang.String), (r4v12 java.lang.String) binds: [B:8:0x002f, B:5:0x0020] A[DONT_GENERATE, DONT_INLINE]] */
    public Snackbar setText(@StringRes int i) {
        Context context;
        String string;
        String str;
        String strIntern;
        CharSequence text;
        CharSequence charSequence;
        String string2;
        int i2 = 2 % 2;
        int i3 = artificialFrame + 89;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i3 % 128;
        if (i3 % 2 != 0) {
            context = getContext();
            string2 = context.getString(i);
            int i4 = 56 / 0;
            if (string2.startsWith(".,.%")) {
                charSequence = string;
                str = string;
                charSequence = string2;
                str = string2;
                String strSubstring = str.substring(4);
                Object[] objArr = new Object[1];
                a(strSubstring, objArr);
                strIntern = ((String) objArr[0]).intern();
                text = context.getText(i);
                charSequence = strIntern;
                if (text instanceof Spanned) {
                    SpannableString spannableString = new SpannableString(strIntern);
                    TextUtils.copySpansFrom((SpannedString) text, 0, strIntern.length(), Object.class, spannableString, 0);
                    int i5 = getARTIFICIAL_FRAME_PACKAGE_NAME + b.i;
                    artificialFrame = i5 % 128;
                    int i6 = i5 % 2;
                    charSequence = spannableString;
                }
            }
        } else {
            context = getContext();
            string = context.getString(i);
            if (string.startsWith(".,.%")) {
                charSequence = string;
                str = string;
                charSequence = string2;
                str = string2;
                String strSubstring2 = str.substring(4);
                Object[] objArr2 = new Object[1];
                a(strSubstring2, objArr2);
                strIntern = ((String) objArr2[0]).intern();
                text = context.getText(i);
                charSequence = strIntern;
                if (text instanceof Spanned) {
                    SpannableString spannableString2 = new SpannableString(strIntern);
                    TextUtils.copySpansFrom((SpannedString) text, 0, strIntern.length(), Object.class, spannableString2, 0);
                    int i7 = getARTIFICIAL_FRAME_PACKAGE_NAME + b.i;
                    artificialFrame = i7 % 128;
                    int i8 = i7 % 2;
                    charSequence = spannableString2;
                }
            }
        }
        charSequence = string;
        str = string;
        charSequence = string2;
        str = string2;
        Snackbar text2 = setText(charSequence);
        int i9 = getARTIFICIAL_FRAME_PACKAGE_NAME + 81;
        artificialFrame = i9 % 128;
        int i10 = i9 % 2;
        return text2;
    }

    public Snackbar setAction(@StringRes int i, View.OnClickListener onClickListener) {
        String strIntern;
        int i2 = 2 % 2;
        int i3 = getARTIFICIAL_FRAME_PACKAGE_NAME + 1;
        artificialFrame = i3 % 128;
        int i4 = i3 % 2;
        Context context = getContext();
        String string = context.getString(i);
        boolean zStartsWith = string.startsWith(".,.%");
        CharSequence charSequence = string;
        if (zStartsWith) {
            int i5 = getARTIFICIAL_FRAME_PACKAGE_NAME + 9;
            artificialFrame = i5 % 128;
            int i6 = i5 % 2;
            Object[] objArr = new Object[1];
            a(string.substring(4), objArr);
            strIntern = ((String) objArr[0]).intern();
            CharSequence text = context.getText(i);
            if (text instanceof Spanned) {
                charSequence = strIntern;
                SpannableString spannableString = new SpannableString(strIntern);
                TextUtils.copySpansFrom((SpannedString) text, 0, strIntern.length(), Object.class, spannableString, 0);
                int i7 = getARTIFICIAL_FRAME_PACKAGE_NAME + 49;
                artificialFrame = i7 % 128;
                int i8 = i7 % 2;
                charSequence = spannableString;
            }
        }
        charSequence = strIntern;
        return setAction(charSequence, onClickListener);
    }

    public Snackbar setAction(@Nullable CharSequence charSequence, @Nullable final View.OnClickListener onClickListener) {
        Button actionView = getActionView();
        if (TextUtils.isEmpty(charSequence) || onClickListener == null) {
            actionView.setVisibility(8);
            actionView.setOnClickListener(null);
            this.hasAction = false;
        } else {
            this.hasAction = true;
            actionView.setVisibility(0);
            actionView.setText(charSequence);
            actionView.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.snackbar.Snackbar$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$setAction$0(onClickListener, view);
                }
            });
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setAction$0(View.OnClickListener onClickListener, View view) {
        onClickListener.onClick(view);
        dispatchDismiss(1);
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public int getDuration() {
        int duration = super.getDuration();
        if (duration == -2) {
            return -2;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            return this.accessibilityManager.getRecommendedTimeoutMillis(duration, (this.hasAction ? 4 : 0) | 3);
        }
        if (this.hasAction && this.accessibilityManager.isTouchExplorationEnabled()) {
            return -2;
        }
        return duration;
    }

    public Snackbar setTextColor(ColorStateList colorStateList) {
        getMessageView().setTextColor(colorStateList);
        return this;
    }

    public Snackbar setTextColor(@ColorInt int i) {
        getMessageView().setTextColor(i);
        return this;
    }

    public Snackbar setTextMaxLines(int i) {
        getMessageView().setMaxLines(i);
        return this;
    }

    public Snackbar setActionTextColor(ColorStateList colorStateList) {
        getActionView().setTextColor(colorStateList);
        return this;
    }

    public Snackbar setMaxInlineActionWidth(@Dimension int i) {
        getContentLayout().setMaxInlineActionWidth(i);
        return this;
    }

    public Snackbar setActionTextColor(@ColorInt int i) {
        getActionView().setTextColor(i);
        return this;
    }

    public Snackbar setBackgroundTint(@ColorInt int i) {
        return setBackgroundTintList(ColorStateList.valueOf(i));
    }

    public Snackbar setBackgroundTintList(@Nullable ColorStateList colorStateList) {
        this.view.setBackgroundTintList(colorStateList);
        return this;
    }

    public Snackbar setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        this.view.setBackgroundTintMode(mode);
        return this;
    }

    @Deprecated
    public Snackbar setCallback(@Nullable Callback callback) {
        BaseTransientBottomBar.BaseCallback<Snackbar> baseCallback = this.callback;
        if (baseCallback != null) {
            removeCallback(baseCallback);
        }
        if (callback != null) {
            addCallback(callback);
        }
        this.callback = callback;
        return this;
    }

    public static final class SnackbarLayout extends BaseTransientBottomBar.SnackbarBaseLayout {
        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setBackground(@Nullable Drawable drawable) {
            super.setBackground(drawable);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setBackgroundDrawable(@Nullable Drawable drawable) {
            super.setBackgroundDrawable(drawable);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
            super.setBackgroundTintList(colorStateList);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
            super.setBackgroundTintMode(mode);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
            super.setLayoutParams(layoutParams);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
            super.setOnClickListener(onClickListener);
        }

        public SnackbarLayout(Context context) {
            super(context);
        }

        public SnackbarLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            int childCount = getChildCount();
            int measuredWidth = getMeasuredWidth();
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getLayoutParams().width == -1) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec((measuredWidth - paddingLeft) - paddingRight, 1073741824), View.MeasureSpec.makeMeasureSpec(childAt.getMeasuredHeight(), 1073741824));
                }
            }
        }
    }

    private TextView getMessageView() {
        return getContentLayout().getMessageView();
    }

    private Button getActionView() {
        return getContentLayout().getActionView();
    }

    private SnackbarContentLayout getContentLayout() {
        return (SnackbarContentLayout) this.view.getChildAt(0);
    }

    static void accessartificialFrame() {
        extraCallback = (byte) -124;
    }
}
