package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Base64;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.internal.ViewUtils;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
class TimePickerTextInputPresenter implements TimePickerView.OnSelectionChange, TimePickerPresenter {
    private final TimePickerTextInputKeyController controller;
    private final EditText hourEditText;
    private final ChipTextInputComboView hourTextInput;
    private final EditText minuteEditText;
    private final ChipTextInputComboView minuteTextInput;
    private final TimeModel time;
    private final LinearLayout timePickerView;
    private MaterialButtonToggleGroup toggle;
    private final TextWatcher minuteTextWatcher = new TextWatcherAdapter() { // from class: com.google.android.material.timepicker.TimePickerTextInputPresenter.1
        @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            try {
                if (TextUtils.isEmpty(editable)) {
                    TimePickerTextInputPresenter.this.time.setMinute(0);
                } else {
                    TimePickerTextInputPresenter.this.time.setMinute(Integer.parseInt(editable.toString()));
                }
            } catch (NumberFormatException unused) {
            }
        }
    };
    private final TextWatcher hourTextWatcher = new TextWatcherAdapter() { // from class: com.google.android.material.timepicker.TimePickerTextInputPresenter.2
        @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            try {
                if (TextUtils.isEmpty(editable)) {
                    TimePickerTextInputPresenter.this.time.setHour(0);
                } else {
                    TimePickerTextInputPresenter.this.time.setHour(Integer.parseInt(editable.toString()));
                }
            } catch (NumberFormatException unused) {
            }
        }
    };

    public TimePickerTextInputPresenter(LinearLayout linearLayout, final TimeModel timeModel) {
        this.timePickerView = linearLayout;
        this.time = timeModel;
        Resources resources = linearLayout.getResources();
        ChipTextInputComboView chipTextInputComboView = (ChipTextInputComboView) linearLayout.findViewById(R.id.material_minute_text_input);
        this.minuteTextInput = chipTextInputComboView;
        ChipTextInputComboView chipTextInputComboView2 = (ChipTextInputComboView) linearLayout.findViewById(R.id.material_hour_text_input);
        this.hourTextInput = chipTextInputComboView2;
        TextView textView = (TextView) chipTextInputComboView.findViewById(R.id.material_label);
        TextView textView2 = (TextView) chipTextInputComboView2.findViewById(R.id.material_label);
        textView.setText(resources.getString(R.string.material_timepicker_minute));
        textView2.setText(resources.getString(R.string.material_timepicker_hour));
        chipTextInputComboView.setTag(R.id.selection_type, 12);
        chipTextInputComboView2.setTag(R.id.selection_type, 10);
        if (timeModel.format == 0) {
            setupPeriodToggle();
        }
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.google.android.material.timepicker.TimePickerTextInputPresenter.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TimePickerTextInputPresenter.this.onSelectionChanged(((Integer) view.getTag(R.id.selection_type)).intValue());
            }
        };
        chipTextInputComboView2.setOnClickListener(onClickListener);
        chipTextInputComboView.setOnClickListener(onClickListener);
        chipTextInputComboView2.addInputFilter(timeModel.getHourInputValidator());
        chipTextInputComboView.addInputFilter(timeModel.getMinuteInputValidator());
        this.hourEditText = chipTextInputComboView2.getTextInput().getEditText();
        this.minuteEditText = chipTextInputComboView.getTextInput().getEditText();
        this.controller = new TimePickerTextInputKeyController(chipTextInputComboView2, chipTextInputComboView, timeModel);
        chipTextInputComboView2.setChipDelegate(new ClickActionDelegate(linearLayout.getContext(), R.string.material_hour_selection) { // from class: com.google.android.material.timepicker.TimePickerTextInputPresenter.4
            private static int artificialFrame = 1;
            private static byte extraCallback = -124;
            private static int getARTIFICIAL_FRAME_PACKAGE_NAME;

            private void b(String str, Object[] objArr) {
                byte[] bArrDecode = Base64.decode(str, 0);
                byte[] bArr = new byte[bArrDecode.length];
                for (int i = 0; i < bArrDecode.length; i++) {
                    bArr[i] = (byte) (bArrDecode[(bArrDecode.length - i) - 1] ^ extraCallback);
                }
                objArr[0] = new String(bArr, StandardCharsets.UTF_8);
            }

            @Override // com.google.android.material.timepicker.ClickActionDelegate, androidx.core.view.AccessibilityDelegateCompat
            public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                Locale locale;
                int i = 2 % 2;
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                Resources resources2 = view.getResources();
                int hourContentDescriptionResId = timeModel.getHourContentDescriptionResId();
                Object[] objArr = {String.valueOf(timeModel.getHourForDisplay())};
                Configuration configuration = resources2.getConfiguration();
                if (Build.VERSION.SDK_INT >= 24) {
                    locale = configuration.getLocales().get(0);
                } else {
                    locale = configuration.locale;
                    int i2 = artificialFrame + 19;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i2 % 128;
                    int i3 = i2 % 2;
                }
                String string = resources2.getString(hourContentDescriptionResId);
                if (string.startsWith(".,.%")) {
                    Object[] objArr2 = new Object[1];
                    b(string.substring(4), objArr2);
                    string = ((String) objArr2[0]).intern();
                    int i4 = getARTIFICIAL_FRAME_PACKAGE_NAME + 117;
                    artificialFrame = i4 % 128;
                    int i5 = i4 % 2;
                }
                accessibilityNodeInfoCompat.setContentDescription(String.format(locale, string, objArr));
            }
        });
        chipTextInputComboView.setChipDelegate(new ClickActionDelegate(linearLayout.getContext(), R.string.material_minute_selection) { // from class: com.google.android.material.timepicker.TimePickerTextInputPresenter.5
            private static int artificialFrame = 1;
            private static byte extraCallback = -124;
            private static int getARTIFICIAL_FRAME_PACKAGE_NAME;

            private void b(String str, Object[] objArr) {
                byte[] bArrDecode = Base64.decode(str, 0);
                byte[] bArr = new byte[bArrDecode.length];
                for (int i = 0; i < bArrDecode.length; i++) {
                    bArr[i] = (byte) (bArrDecode[(bArrDecode.length - i) - 1] ^ extraCallback);
                }
                objArr[0] = new String(bArr, StandardCharsets.UTF_8);
            }

            @Override // com.google.android.material.timepicker.ClickActionDelegate, androidx.core.view.AccessibilityDelegateCompat
            public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                int i = 2 % 2;
                int i2 = artificialFrame + 37;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i2 % 128;
                int i3 = i2 % 2;
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                Resources resources2 = view.getResources();
                int i4 = R.string.material_minute_suffix;
                Object[] objArr = {String.valueOf(timeModel.minute)};
                Configuration configuration = resources2.getConfiguration();
                Locale locale = Build.VERSION.SDK_INT >= 24 ? configuration.getLocales().get(0) : configuration.locale;
                String string = resources2.getString(i4);
                if (string.startsWith(".,.%")) {
                    int i5 = artificialFrame + 11;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i5 % 128;
                    if (i5 % 2 != 0) {
                        Object[] objArr2 = new Object[1];
                        b(string.substring(4), objArr2);
                        ((String) objArr2[0]).intern();
                        throw null;
                    }
                    Object[] objArr3 = new Object[1];
                    b(string.substring(4), objArr3);
                    string = ((String) objArr3[0]).intern();
                }
                accessibilityNodeInfoCompat.setContentDescription(String.format(locale, string, objArr));
            }
        });
        initialize();
    }

    @Override // com.google.android.material.timepicker.TimePickerPresenter
    public void initialize() {
        addTextWatchers();
        setTime(this.time);
        this.controller.bind();
    }

    private void addTextWatchers() {
        this.hourEditText.addTextChangedListener(this.hourTextWatcher);
        this.minuteEditText.addTextChangedListener(this.minuteTextWatcher);
    }

    private void removeTextWatchers() {
        this.hourEditText.removeTextChangedListener(this.hourTextWatcher);
        this.minuteEditText.removeTextChangedListener(this.minuteTextWatcher);
    }

    private void setTime(TimeModel timeModel) {
        removeTextWatchers();
        Locale locale = this.timePickerView.getResources().getConfiguration().locale;
        String str = String.format(locale, TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(timeModel.minute));
        String str2 = String.format(locale, TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(timeModel.getHourForDisplay()));
        this.minuteTextInput.setText(str);
        this.hourTextInput.setText(str2);
        addTextWatchers();
        updateSelection();
    }

    private void setupPeriodToggle() {
        MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) this.timePickerView.findViewById(R.id.material_clock_period_toggle);
        this.toggle = materialButtonToggleGroup;
        materialButtonToggleGroup.addOnButtonCheckedListener(new MaterialButtonToggleGroup.OnButtonCheckedListener() { // from class: com.google.android.material.timepicker.TimePickerTextInputPresenter$$ExternalSyntheticLambda0
            @Override // com.google.android.material.button.MaterialButtonToggleGroup.OnButtonCheckedListener
            public final void onButtonChecked(MaterialButtonToggleGroup materialButtonToggleGroup2, int i, boolean z) {
                this.f$0.lambda$setupPeriodToggle$0(materialButtonToggleGroup2, i, z);
            }
        });
        this.toggle.setVisibility(0);
        updateSelection();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupPeriodToggle$0(MaterialButtonToggleGroup materialButtonToggleGroup, int i, boolean z) {
        if (z) {
            this.time.setPeriod(i == R.id.material_clock_period_pm_button ? 1 : 0);
        }
    }

    private void updateSelection() {
        int i;
        MaterialButtonToggleGroup materialButtonToggleGroup = this.toggle;
        if (materialButtonToggleGroup == null) {
            return;
        }
        if (this.time.period == 0) {
            i = R.id.material_clock_period_am_button;
        } else {
            i = R.id.material_clock_period_pm_button;
        }
        materialButtonToggleGroup.check(i);
    }

    @Override // com.google.android.material.timepicker.TimePickerView.OnSelectionChange
    public void onSelectionChanged(int i) {
        this.time.selection = i;
        this.minuteTextInput.setChecked(i == 12);
        this.hourTextInput.setChecked(i == 10);
        updateSelection();
    }

    @Override // com.google.android.material.timepicker.TimePickerPresenter
    public void show() {
        this.timePickerView.setVisibility(0);
        onSelectionChanged(this.time.selection);
    }

    @Override // com.google.android.material.timepicker.TimePickerPresenter
    public void hide() {
        View focusedChild = this.timePickerView.getFocusedChild();
        if (focusedChild != null) {
            ViewUtils.hideKeyboard(focusedChild, false);
        }
        this.timePickerView.setVisibility(8);
    }

    @Override // com.google.android.material.timepicker.TimePickerPresenter
    public void invalidate() {
        setTime(this.time);
    }

    private static void setCursorDrawableColor(EditText editText, @ColorInt int i) {
        try {
            Context context = editText.getContext();
            Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            int i2 = declaredField.getInt(editText);
            Field declaredField2 = TextView.class.getDeclaredField("mEditor");
            declaredField2.setAccessible(true);
            Object obj = declaredField2.get(editText);
            Field declaredField3 = obj.getClass().getDeclaredField("mCursorDrawable");
            declaredField3.setAccessible(true);
            Drawable drawable = AppCompatResources.getDrawable(context, i2);
            drawable.setColorFilter(i, PorterDuff.Mode.SRC_IN);
            declaredField3.set(obj, new Drawable[]{drawable, drawable});
        } catch (Throwable unused) {
        }
    }

    public void resetChecked() {
        this.minuteTextInput.setChecked(this.time.selection == 12);
        this.hourTextInput.setChecked(this.time.selection == 10);
    }

    public void clearCheck() {
        this.minuteTextInput.setChecked(false);
        this.hourTextInput.setChecked(false);
    }
}
