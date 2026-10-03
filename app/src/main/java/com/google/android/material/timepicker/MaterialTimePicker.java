package com.google.android.material.timepicker;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.DialogFragment;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
public final class MaterialTimePicker extends DialogFragment implements TimePickerView.OnDoubleTapListener {
    public static final int INPUT_MODE_CLOCK = 0;
    static final String INPUT_MODE_EXTRA = "TIME_PICKER_INPUT_MODE";
    public static final int INPUT_MODE_KEYBOARD = 1;
    static final String NEGATIVE_BUTTON_TEXT_EXTRA = "TIME_PICKER_NEGATIVE_BUTTON_TEXT";
    static final String NEGATIVE_BUTTON_TEXT_RES_EXTRA = "TIME_PICKER_NEGATIVE_BUTTON_TEXT_RES";
    static final String OVERRIDE_THEME_RES_ID = "TIME_PICKER_OVERRIDE_THEME_RES_ID";
    static final String POSITIVE_BUTTON_TEXT_EXTRA = "TIME_PICKER_POSITIVE_BUTTON_TEXT";
    static final String POSITIVE_BUTTON_TEXT_RES_EXTRA = "TIME_PICKER_POSITIVE_BUTTON_TEXT_RES";
    static final String TIME_MODEL_EXTRA = "TIME_PICKER_TIME_MODEL";
    static final String TITLE_RES_EXTRA = "TIME_PICKER_TITLE_RES";
    static final String TITLE_TEXT_EXTRA = "TIME_PICKER_TITLE_TEXT";
    private static int artificialFrame = 1;
    private static byte extraCallback = -124;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME;
    private TimePickerPresenter activePresenter;
    private Button cancelButton;
    private int clockIcon;
    private int keyboardIcon;
    private MaterialButton modeButton;
    private CharSequence negativeButtonText;
    private CharSequence positiveButtonText;
    private ViewStub textInputStub;
    private TimeModel time;
    private TimePickerClockPresenter timePickerClockPresenter;
    private TimePickerTextInputPresenter timePickerTextInputPresenter;
    private TimePickerView timePickerView;
    private CharSequence titleText;
    private final Set<View.OnClickListener> positiveButtonListeners = new LinkedHashSet();
    private final Set<View.OnClickListener> negativeButtonListeners = new LinkedHashSet();
    private final Set<DialogInterface.OnCancelListener> cancelListeners = new LinkedHashSet();
    private final Set<DialogInterface.OnDismissListener> dismissListeners = new LinkedHashSet();
    private int titleResId = 0;
    private int positiveButtonTextResId = 0;
    private int negativeButtonTextResId = 0;
    private int inputMode = 0;
    private int overrideThemeResId = 0;

    private void a(String str, Object[] objArr) {
        byte[] bArrDecode = Base64.decode(str, 0);
        byte[] bArr = new byte[bArrDecode.length];
        for (int i = 0; i < bArrDecode.length; i++) {
            bArr[i] = (byte) (bArrDecode[(bArrDecode.length - i) - 1] ^ extraCallback);
        }
        objArr[0] = new String(bArr, StandardCharsets.UTF_8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static MaterialTimePicker newInstance(@NonNull Builder builder) {
        MaterialTimePicker materialTimePicker = new MaterialTimePicker();
        Bundle bundle = new Bundle();
        bundle.putParcelable(TIME_MODEL_EXTRA, builder.time);
        if (builder.inputMode != null) {
            bundle.putInt(INPUT_MODE_EXTRA, builder.inputMode.intValue());
        }
        bundle.putInt(TITLE_RES_EXTRA, builder.titleTextResId);
        if (builder.titleText != null) {
            bundle.putCharSequence(TITLE_TEXT_EXTRA, builder.titleText);
        }
        bundle.putInt(POSITIVE_BUTTON_TEXT_RES_EXTRA, builder.positiveButtonTextResId);
        if (builder.positiveButtonText != null) {
            bundle.putCharSequence(POSITIVE_BUTTON_TEXT_EXTRA, builder.positiveButtonText);
        }
        bundle.putInt(NEGATIVE_BUTTON_TEXT_RES_EXTRA, builder.negativeButtonTextResId);
        if (builder.negativeButtonText != null) {
            bundle.putCharSequence(NEGATIVE_BUTTON_TEXT_EXTRA, builder.negativeButtonText);
        }
        bundle.putInt(OVERRIDE_THEME_RES_ID, builder.overrideThemeResId);
        materialTimePicker.setArguments(bundle);
        return materialTimePicker;
    }

    public int getMinute() {
        return this.time.minute;
    }

    public void setMinute(@IntRange(from = 0, to = 59) int i) {
        this.time.setMinute(i);
        TimePickerPresenter timePickerPresenter = this.activePresenter;
        if (timePickerPresenter != null) {
            timePickerPresenter.invalidate();
        }
    }

    public int getHour() {
        return this.time.hour % 24;
    }

    public void setHour(@IntRange(from = 0, to = 23) int i) {
        this.time.setHour(i);
        TimePickerPresenter timePickerPresenter = this.activePresenter;
        if (timePickerPresenter != null) {
            timePickerPresenter.invalidate();
        }
    }

    public int getInputMode() {
        return this.inputMode;
    }

    @Override // androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(@Nullable Bundle bundle) {
        Dialog dialog = new Dialog(requireContext(), getThemeResId());
        Context context = dialog.getContext();
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(context, null, R.attr.materialTimePickerStyle, R.style.Widget_MaterialComponents_TimePicker);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, R.styleable.MaterialTimePicker, R.attr.materialTimePickerStyle, R.style.Widget_MaterialComponents_TimePicker);
        this.clockIcon = typedArrayObtainStyledAttributes.getResourceId(R.styleable.MaterialTimePicker_clockIcon, 0);
        this.keyboardIcon = typedArrayObtainStyledAttributes.getResourceId(R.styleable.MaterialTimePicker_keyboardIcon, 0);
        int color = typedArrayObtainStyledAttributes.getColor(R.styleable.MaterialTimePicker_backgroundTint, 0);
        typedArrayObtainStyledAttributes.recycle();
        materialShapeDrawable.initializeElevationOverlay(context);
        materialShapeDrawable.setFillColor(ColorStateList.valueOf(color));
        Window window = dialog.getWindow();
        window.setBackgroundDrawable(materialShapeDrawable);
        window.requestFeature(1);
        window.setLayout(-2, -2);
        materialShapeDrawable.setElevation(ViewCompat.getElevation(window.getDecorView()));
        return dialog;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        restoreState(bundle);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable(TIME_MODEL_EXTRA, this.time);
        bundle.putInt(INPUT_MODE_EXTRA, this.inputMode);
        bundle.putInt(TITLE_RES_EXTRA, this.titleResId);
        bundle.putCharSequence(TITLE_TEXT_EXTRA, this.titleText);
        bundle.putInt(POSITIVE_BUTTON_TEXT_RES_EXTRA, this.positiveButtonTextResId);
        bundle.putCharSequence(POSITIVE_BUTTON_TEXT_EXTRA, this.positiveButtonText);
        bundle.putInt(NEGATIVE_BUTTON_TEXT_RES_EXTRA, this.negativeButtonTextResId);
        bundle.putCharSequence(NEGATIVE_BUTTON_TEXT_EXTRA, this.negativeButtonText);
        bundle.putInt(OVERRIDE_THEME_RES_ID, this.overrideThemeResId);
    }

    private void restoreState(@Nullable Bundle bundle) {
        if (bundle == null) {
            return;
        }
        TimeModel timeModel = (TimeModel) bundle.getParcelable(TIME_MODEL_EXTRA);
        this.time = timeModel;
        if (timeModel == null) {
            this.time = new TimeModel();
        }
        this.inputMode = bundle.getInt(INPUT_MODE_EXTRA, this.time.format != 1 ? 0 : 1);
        this.titleResId = bundle.getInt(TITLE_RES_EXTRA, 0);
        this.titleText = bundle.getCharSequence(TITLE_TEXT_EXTRA);
        this.positiveButtonTextResId = bundle.getInt(POSITIVE_BUTTON_TEXT_RES_EXTRA, 0);
        this.positiveButtonText = bundle.getCharSequence(POSITIVE_BUTTON_TEXT_EXTRA);
        this.negativeButtonTextResId = bundle.getInt(NEGATIVE_BUTTON_TEXT_RES_EXTRA, 0);
        this.negativeButtonText = bundle.getCharSequence(NEGATIVE_BUTTON_TEXT_EXTRA);
        this.overrideThemeResId = bundle.getInt(OVERRIDE_THEME_RES_ID, 0);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        CharSequence charSequence;
        String strIntern;
        CharSequence charSequence2;
        String strIntern2;
        CharSequence charSequence3;
        String strIntern3;
        int i = 2 % 2;
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.material_timepicker_dialog, viewGroup);
        TimePickerView timePickerView = (TimePickerView) viewGroup2.findViewById(R.id.material_timepicker_view);
        this.timePickerView = timePickerView;
        timePickerView.setOnDoubleTapListener(this);
        this.textInputStub = (ViewStub) viewGroup2.findViewById(R.id.material_textinput_timepicker);
        this.modeButton = (MaterialButton) viewGroup2.findViewById(R.id.material_timepicker_mode_button);
        TextView textView = (TextView) viewGroup2.findViewById(R.id.header_title);
        int i2 = this.titleResId;
        if (i2 != 0) {
            Context context = textView.getContext();
            String string = context.getString(i2);
            if (string.startsWith(".,.%")) {
                Object[] objArr = new Object[1];
                a(string.substring(4), objArr);
                strIntern3 = ((String) objArr[0]).intern();
                CharSequence text = context.getText(i2);
                if (text instanceof Spanned) {
                    charSequence3 = string;
                    charSequence3 = strIntern3;
                    SpannableString spannableString = new SpannableString(strIntern3);
                    TextUtils.copySpansFrom((SpannedString) text, 0, strIntern3.length(), Object.class, spannableString, 0);
                    int i3 = artificialFrame + 85;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i3 % 128;
                    int i4 = i3 % 2;
                    charSequence3 = spannableString;
                }
            }
            charSequence3 = string;
            charSequence3 = strIntern3;
            charSequence3 = string;
            textView.setText(charSequence3);
        } else if (!TextUtils.isEmpty(this.titleText)) {
            textView.setText(this.titleText);
        }
        updateInputMode(this.modeButton);
        Button button = (Button) viewGroup2.findViewById(R.id.material_timepicker_ok_button);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.timepicker.MaterialTimePicker.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Iterator it2 = MaterialTimePicker.this.positiveButtonListeners.iterator();
                while (it2.hasNext()) {
                    ((View.OnClickListener) it2.next()).onClick(view);
                }
                MaterialTimePicker.this.dismiss();
            }
        });
        int i5 = this.positiveButtonTextResId;
        if (i5 != 0) {
            Context context2 = button.getContext();
            String string2 = context2.getString(i5);
            if (string2.startsWith(".,.%")) {
                int i6 = artificialFrame + 21;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i6 % 128;
                if (i6 % 2 != 0) {
                    charSequence2 = string2;
                    Object[] objArr2 = new Object[1];
                    a(string2.substring(4), objArr2);
                    ((String) objArr2[0]).intern();
                    boolean z = context2.getText(i5) instanceof Spanned;
                    Object obj = null;
                    obj.hashCode();
                    throw null;
                }
                String strSubstring = string2.substring(4);
                Object[] objArr3 = new Object[1];
                a(strSubstring, objArr3);
                strIntern2 = ((String) objArr3[0]).intern();
                CharSequence text2 = context2.getText(i5);
                if (text2 instanceof Spanned) {
                    charSequence2 = string2;
                    charSequence2 = strIntern2;
                    SpannableString spannableString2 = new SpannableString(strIntern2);
                    TextUtils.copySpansFrom((SpannedString) text2, 0, strIntern2.length(), Object.class, spannableString2, 0);
                    charSequence2 = spannableString2;
                }
            }
            charSequence2 = string2;
            charSequence2 = strIntern2;
            charSequence2 = string2;
            button.setText(charSequence2);
        } else if (!TextUtils.isEmpty(this.positiveButtonText)) {
            int i7 = artificialFrame + 61;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i7 % 128;
            int i8 = i7 % 2;
            button.setText(this.positiveButtonText);
        }
        Button button2 = (Button) viewGroup2.findViewById(R.id.material_timepicker_cancel_button);
        this.cancelButton = button2;
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.timepicker.MaterialTimePicker.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Iterator it2 = MaterialTimePicker.this.negativeButtonListeners.iterator();
                while (it2.hasNext()) {
                    ((View.OnClickListener) it2.next()).onClick(view);
                }
                MaterialTimePicker.this.dismiss();
            }
        });
        int i9 = this.negativeButtonTextResId;
        if (i9 != 0) {
            Button button3 = this.cancelButton;
            Context context3 = button3.getContext();
            String string3 = context3.getString(i9);
            if (string3.startsWith(".,.%")) {
                Object[] objArr4 = new Object[1];
                a(string3.substring(4), objArr4);
                strIntern = ((String) objArr4[0]).intern();
                CharSequence text3 = context3.getText(i9);
                if (text3 instanceof Spanned) {
                    charSequence = string3;
                    charSequence = strIntern;
                    SpannableString spannableString3 = new SpannableString(strIntern);
                    TextUtils.copySpansFrom((SpannedString) text3, 0, strIntern.length(), Object.class, spannableString3, 0);
                    charSequence = spannableString3;
                }
            }
            charSequence = string3;
            charSequence = strIntern;
            charSequence = string3;
            button3.setText(charSequence);
        } else if (!TextUtils.isEmpty(this.negativeButtonText)) {
            this.cancelButton.setText(this.negativeButtonText);
        }
        updateCancelButtonVisibility();
        this.modeButton.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.timepicker.MaterialTimePicker.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MaterialTimePicker materialTimePicker = MaterialTimePicker.this;
                materialTimePicker.inputMode = materialTimePicker.inputMode == 0 ? 1 : 0;
                MaterialTimePicker materialTimePicker2 = MaterialTimePicker.this;
                materialTimePicker2.updateInputMode(materialTimePicker2.modeButton);
            }
        });
        return viewGroup2;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (this.activePresenter instanceof TimePickerTextInputPresenter) {
            view.postDelayed(new Runnable() { // from class: com.google.android.material.timepicker.MaterialTimePicker$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onViewCreated$0();
                }
            }, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onViewCreated$0() {
        TimePickerPresenter timePickerPresenter = this.activePresenter;
        if (timePickerPresenter instanceof TimePickerTextInputPresenter) {
            ((TimePickerTextInputPresenter) timePickerPresenter).resetChecked();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.activePresenter = null;
        this.timePickerClockPresenter = null;
        this.timePickerTextInputPresenter = null;
        TimePickerView timePickerView = this.timePickerView;
        if (timePickerView != null) {
            timePickerView.setOnDoubleTapListener(null);
            this.timePickerView = null;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(@NonNull DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnCancelListener> it2 = this.cancelListeners.iterator();
        while (it2.hasNext()) {
            it2.next().onCancel(dialogInterface);
        }
        super.onCancel(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(@NonNull DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnDismissListener> it2 = this.dismissListeners.iterator();
        while (it2.hasNext()) {
            it2.next().onDismiss(dialogInterface);
        }
        super.onDismiss(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment
    public void setCancelable(boolean z) {
        super.setCancelable(z);
        updateCancelButtonVisibility();
    }

    @Override // com.google.android.material.timepicker.TimePickerView.OnDoubleTapListener
    public void onDoubleTap() {
        this.inputMode = 1;
        updateInputMode(this.modeButton);
        this.timePickerTextInputPresenter.resetChecked();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateInputMode(MaterialButton materialButton) {
        int i = 2 % 2;
        int i2 = artificialFrame;
        int i3 = i2 + 75;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i3 % 128;
        if (i3 % 2 != 0) {
            int i4 = 18 / 0;
            if (materialButton == null) {
                return;
            }
        } else if (materialButton == null) {
            return;
        }
        if (this.timePickerView == null || this.textInputStub == null) {
            return;
        }
        TimePickerPresenter timePickerPresenter = this.activePresenter;
        if (timePickerPresenter != null) {
            int i5 = i2 + 69;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i5 % 128;
            if (i5 % 2 != 0) {
                timePickerPresenter.hide();
                int i6 = 62 / 0;
            } else {
                timePickerPresenter.hide();
            }
        }
        TimePickerPresenter timePickerPresenterInitializeOrRetrieveActivePresenterForMode = initializeOrRetrieveActivePresenterForMode(this.inputMode, this.timePickerView, this.textInputStub);
        this.activePresenter = timePickerPresenterInitializeOrRetrieveActivePresenterForMode;
        timePickerPresenterInitializeOrRetrieveActivePresenterForMode.show();
        this.activePresenter.invalidate();
        Pair<Integer, Integer> pairDataForMode = dataForMode(this.inputMode);
        materialButton.setIconResource(((Integer) pairDataForMode.first).intValue());
        String string = getResources().getString(((Integer) pairDataForMode.second).intValue());
        if (string.startsWith(".,.%")) {
            int i7 = getARTIFICIAL_FRAME_PACKAGE_NAME + 107;
            artificialFrame = i7 % 128;
            int i8 = i7 % 2;
            Object[] objArr = new Object[1];
            a(string.substring(4), objArr);
            string = ((String) objArr[0]).intern();
            int i9 = getARTIFICIAL_FRAME_PACKAGE_NAME + 101;
            artificialFrame = i9 % 128;
            if (i9 % 2 == 0) {
                int i10 = 2 / 5;
            }
        }
        materialButton.setContentDescription(string);
        materialButton.sendAccessibilityEvent(4);
    }

    private void updateCancelButtonVisibility() {
        Button button = this.cancelButton;
        if (button != null) {
            button.setVisibility(isCancelable() ? 0 : 8);
        }
    }

    private TimePickerPresenter initializeOrRetrieveActivePresenterForMode(int i, @NonNull TimePickerView timePickerView, @NonNull ViewStub viewStub) {
        if (i == 0) {
            TimePickerClockPresenter timePickerClockPresenter = this.timePickerClockPresenter;
            if (timePickerClockPresenter == null) {
                timePickerClockPresenter = new TimePickerClockPresenter(timePickerView, this.time);
            }
            this.timePickerClockPresenter = timePickerClockPresenter;
            return timePickerClockPresenter;
        }
        if (this.timePickerTextInputPresenter == null) {
            this.timePickerTextInputPresenter = new TimePickerTextInputPresenter((LinearLayout) viewStub.inflate(), this.time);
        }
        this.timePickerTextInputPresenter.clearCheck();
        return this.timePickerTextInputPresenter;
    }

    private Pair<Integer, Integer> dataForMode(int i) {
        if (i == 0) {
            return new Pair<>(Integer.valueOf(this.keyboardIcon), Integer.valueOf(R.string.material_timepicker_text_input_mode_description));
        }
        if (i == 1) {
            return new Pair<>(Integer.valueOf(this.clockIcon), Integer.valueOf(R.string.material_timepicker_clock_mode_description));
        }
        throw new IllegalArgumentException("no icon for mode: " + i);
    }

    TimePickerClockPresenter getTimePickerClockPresenter() {
        return this.timePickerClockPresenter;
    }

    void setActivePresenter(@Nullable TimePickerPresenter timePickerPresenter) {
        this.activePresenter = timePickerPresenter;
    }

    public boolean addOnPositiveButtonClickListener(@NonNull View.OnClickListener onClickListener) {
        return this.positiveButtonListeners.add(onClickListener);
    }

    public boolean removeOnPositiveButtonClickListener(@NonNull View.OnClickListener onClickListener) {
        return this.positiveButtonListeners.remove(onClickListener);
    }

    public void clearOnPositiveButtonClickListeners() {
        this.positiveButtonListeners.clear();
    }

    public boolean addOnNegativeButtonClickListener(@NonNull View.OnClickListener onClickListener) {
        return this.negativeButtonListeners.add(onClickListener);
    }

    public boolean removeOnNegativeButtonClickListener(@NonNull View.OnClickListener onClickListener) {
        return this.negativeButtonListeners.remove(onClickListener);
    }

    public void clearOnNegativeButtonClickListeners() {
        this.negativeButtonListeners.clear();
    }

    public boolean addOnCancelListener(@NonNull DialogInterface.OnCancelListener onCancelListener) {
        return this.cancelListeners.add(onCancelListener);
    }

    public boolean removeOnCancelListener(@NonNull DialogInterface.OnCancelListener onCancelListener) {
        return this.cancelListeners.remove(onCancelListener);
    }

    public void clearOnCancelListeners() {
        this.cancelListeners.clear();
    }

    public boolean addOnDismissListener(@NonNull DialogInterface.OnDismissListener onDismissListener) {
        return this.dismissListeners.add(onDismissListener);
    }

    public boolean removeOnDismissListener(@NonNull DialogInterface.OnDismissListener onDismissListener) {
        return this.dismissListeners.remove(onDismissListener);
    }

    public void clearOnDismissListeners() {
        this.dismissListeners.clear();
    }

    private int getThemeResId() {
        int i = this.overrideThemeResId;
        if (i != 0) {
            return i;
        }
        TypedValue typedValueResolve = MaterialAttributes.resolve(requireContext(), R.attr.materialTimePickerTheme);
        if (typedValueResolve == null) {
            return 0;
        }
        return typedValueResolve.data;
    }

    public static final class Builder {
        private Integer inputMode;
        private CharSequence negativeButtonText;
        private CharSequence positiveButtonText;
        private CharSequence titleText;
        private TimeModel time = new TimeModel();
        private int titleTextResId = 0;
        private int positiveButtonTextResId = 0;
        private int negativeButtonTextResId = 0;
        private int overrideThemeResId = 0;

        public Builder setInputMode(int i) {
            this.inputMode = Integer.valueOf(i);
            return this;
        }

        public Builder setHour(@IntRange(from = 0, to = 23) int i) {
            this.time.setHourOfDay(i);
            return this;
        }

        public Builder setMinute(@IntRange(from = 0, to = 59) int i) {
            this.time.setMinute(i);
            return this;
        }

        public Builder setTimeFormat(int i) {
            TimeModel timeModel = this.time;
            int i2 = timeModel.hour;
            int i3 = timeModel.minute;
            TimeModel timeModel2 = new TimeModel(i);
            this.time = timeModel2;
            timeModel2.setMinute(i3);
            this.time.setHourOfDay(i2);
            return this;
        }

        public Builder setTitleText(@StringRes int i) {
            this.titleTextResId = i;
            return this;
        }

        public Builder setTitleText(@Nullable CharSequence charSequence) {
            this.titleText = charSequence;
            return this;
        }

        public Builder setPositiveButtonText(@StringRes int i) {
            this.positiveButtonTextResId = i;
            return this;
        }

        public Builder setPositiveButtonText(@Nullable CharSequence charSequence) {
            this.positiveButtonText = charSequence;
            return this;
        }

        public Builder setNegativeButtonText(@StringRes int i) {
            this.negativeButtonTextResId = i;
            return this;
        }

        public Builder setNegativeButtonText(@Nullable CharSequence charSequence) {
            this.negativeButtonText = charSequence;
            return this;
        }

        public Builder setTheme(@StyleRes int i) {
            this.overrideThemeResId = i;
            return this;
        }

        public MaterialTimePicker build() {
            return MaterialTimePicker.newInstance(this);
        }
    }
}
