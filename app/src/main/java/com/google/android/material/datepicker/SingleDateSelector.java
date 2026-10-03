package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import com.google.android.material.R;
import com.google.android.material.internal.ManufacturerUtils;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.textfield.TextInputLayout;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class SingleDateSelector implements DateSelector<Long> {
    public static final Parcelable.Creator<SingleDateSelector> CREATOR;
    private static int artificialFrame = 1;
    private static byte extraCallback;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME;
    private CharSequence error;
    private Long selectedItem;
    private SimpleDateFormat textInputFormat;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private void a(String str, Object[] objArr) {
        byte[] bArrDecode = Base64.decode(str, 0);
        byte[] bArr = new byte[bArrDecode.length];
        for (int i = 0; i < bArrDecode.length; i++) {
            bArr[i] = (byte) (bArrDecode[(bArrDecode.length - i) - 1] ^ extraCallback);
        }
        objArr[0] = new String(bArr, StandardCharsets.UTF_8);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public void select(long j) {
        this.selectedItem = Long.valueOf(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSelection() {
        this.selectedItem = null;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public void setSelection(@Nullable Long l) {
        this.selectedItem = l == null ? null : Long.valueOf(UtcDates.canonicalYearMonthDay(l.longValue()));
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public boolean isSelectionComplete() {
        return this.selectedItem != null;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public Collection<Pair<Long, Long>> getSelectedRanges() {
        return new ArrayList();
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public Collection<Long> getSelectedDays() {
        ArrayList arrayList = new ArrayList();
        Long l = this.selectedItem;
        if (l != null) {
            arrayList.add(l);
        }
        return arrayList;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.material.datepicker.DateSelector
    public Long getSelection() {
        return this.selectedItem;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public void setTextInputFormat(@Nullable SimpleDateFormat simpleDateFormat) {
        if (simpleDateFormat != null) {
            simpleDateFormat = (SimpleDateFormat) UtcDates.getNormalizedFormat(simpleDateFormat);
        }
        this.textInputFormat = simpleDateFormat;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public View onCreateTextInputView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle, CalendarConstraints calendarConstraints, @NonNull final OnSelectionChangedListener<Long> onSelectionChangedListener) {
        String defaultTextInputHint;
        View viewInflate = layoutInflater.inflate(R.layout.mtrl_picker_text_input_date, viewGroup, false);
        final TextInputLayout textInputLayout = (TextInputLayout) viewInflate.findViewById(R.id.mtrl_picker_text_input_date);
        EditText editText = textInputLayout.getEditText();
        if (ManufacturerUtils.isDateInputKeyboardMissingSeparatorCharacters()) {
            editText.setInputType(17);
        }
        SimpleDateFormat defaultTextInputFormat = this.textInputFormat;
        boolean z = defaultTextInputFormat != null;
        if (!z) {
            defaultTextInputFormat = UtcDates.getDefaultTextInputFormat();
        }
        SimpleDateFormat simpleDateFormat = defaultTextInputFormat;
        if (z) {
            defaultTextInputHint = simpleDateFormat.toPattern();
        } else {
            defaultTextInputHint = UtcDates.getDefaultTextInputHint(viewInflate.getResources(), simpleDateFormat);
        }
        String str = defaultTextInputHint;
        textInputLayout.setPlaceholderText(str);
        Long l = this.selectedItem;
        if (l != null) {
            editText.setText(simpleDateFormat.format(l));
        }
        editText.addTextChangedListener(new DateFormatTextWatcher(str, simpleDateFormat, textInputLayout, calendarConstraints) { // from class: com.google.android.material.datepicker.SingleDateSelector.1
            @Override // com.google.android.material.datepicker.DateFormatTextWatcher
            void onValidDate(@Nullable Long l2) {
                if (l2 == null) {
                    SingleDateSelector.this.clearSelection();
                } else {
                    SingleDateSelector.this.select(l2.longValue());
                }
                SingleDateSelector.this.error = null;
                onSelectionChangedListener.onSelectionChanged(SingleDateSelector.this.getSelection());
            }

            @Override // com.google.android.material.datepicker.DateFormatTextWatcher
            void onInvalidDate() {
                SingleDateSelector.this.error = textInputLayout.getError();
                onSelectionChangedListener.onIncompleteSelectionChanged();
            }
        });
        DateSelector.showKeyboardWithAutoHideBehavior(editText);
        return viewInflate;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public int getDefaultThemeResId(Context context) {
        return MaterialAttributes.resolveOrThrow(context, R.attr.materialCalendarTheme, MaterialDatePicker.class.getCanonicalName());
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public String getSelectionDisplayString(@NonNull Context context) {
        Locale locale;
        int i = 2 % 2;
        Resources resources = context.getResources();
        Long l = this.selectedItem;
        Object obj = null;
        if (l != null) {
            String yearMonthDay = DateStrings.getYearMonthDay(l.longValue());
            int i2 = R.string.mtrl_picker_date_header_selected;
            Object[] objArr = {yearMonthDay};
            Configuration configuration = resources.getConfiguration();
            if (Build.VERSION.SDK_INT >= 24) {
                int i3 = getARTIFICIAL_FRAME_PACKAGE_NAME + 77;
                artificialFrame = i3 % 128;
                int i4 = i3 % 2;
                locale = configuration.getLocales().get(0);
            } else {
                locale = configuration.locale;
            }
            String string = resources.getString(i2);
            if (string.startsWith(".,.%")) {
                Object[] objArr2 = new Object[1];
                a(string.substring(4), objArr2);
                string = ((String) objArr2[0]).intern();
            }
            String str = String.format(locale, string, objArr);
            int i5 = artificialFrame + 61;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i5 % 128;
            if (i5 % 2 == 0) {
                return str;
            }
            obj.hashCode();
            throw null;
        }
        int i6 = getARTIFICIAL_FRAME_PACKAGE_NAME + 69;
        artificialFrame = i6 % 128;
        if (i6 % 2 != 0) {
            return resources.getString(R.string.mtrl_picker_date_header_unselected);
        }
        resources.getString(R.string.mtrl_picker_date_header_unselected);
        throw null;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public String getSelectionContentDescription(@NonNull Context context) {
        String yearMonthDay;
        int i = 2 % 2;
        Resources resources = context.getResources();
        Long l = this.selectedItem;
        if (l == null) {
            int i2 = artificialFrame + 65;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i2 % 128;
            int i3 = i2 % 2;
            yearMonthDay = resources.getString(R.string.mtrl_picker_announce_current_selection_none);
            int i4 = artificialFrame + 81;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i4 % 128;
            int i5 = i4 % 2;
        } else {
            yearMonthDay = DateStrings.getYearMonthDay(l.longValue());
        }
        int i6 = R.string.mtrl_picker_announce_current_selection;
        Object[] objArr = {yearMonthDay};
        Configuration configuration = resources.getConfiguration();
        Locale locale = Build.VERSION.SDK_INT >= 24 ? configuration.getLocales().get(0) : configuration.locale;
        String string = resources.getString(i6);
        if (string.startsWith(".,.%")) {
            int i7 = artificialFrame + 59;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i7 % 128;
            int i8 = i7 % 2;
            String strSubstring = string.substring(4);
            Object[] objArr2 = new Object[1];
            if (i8 != 0) {
                a(strSubstring, objArr2);
                ((String) objArr2[0]).intern();
                Object obj = null;
                obj.hashCode();
                throw null;
            }
            a(strSubstring, objArr2);
            string = ((String) objArr2[0]).intern();
        }
        return String.format(locale, string, objArr);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public String getError() {
        if (TextUtils.isEmpty(this.error)) {
            return null;
        }
        return this.error.toString();
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public int getDefaultTitleResId() {
        return R.string.mtrl_picker_date_header_title;
    }

    static {
        accessartificialFrame();
        CREATOR = new Parcelable.Creator<SingleDateSelector>() { // from class: com.google.android.material.datepicker.SingleDateSelector.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SingleDateSelector createFromParcel(@NonNull Parcel parcel) {
                SingleDateSelector singleDateSelector = new SingleDateSelector();
                singleDateSelector.selectedItem = (Long) parcel.readValue(Long.class.getClassLoader());
                return singleDateSelector;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SingleDateSelector[] newArray(int i) {
                return new SingleDateSelector[i];
            }
        };
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeValue(this.selectedItem);
    }

    static void accessartificialFrame() {
        extraCallback = (byte) -124;
    }
}
