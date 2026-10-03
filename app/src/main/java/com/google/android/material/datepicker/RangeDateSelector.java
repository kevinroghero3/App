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
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.util.Pair;
import androidx.core.util.Preconditions;
import com.google.android.material.R;
import com.google.android.material.internal.ManufacturerUtils;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.textfield.TextInputLayout;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: classes5.dex */
public class RangeDateSelector implements DateSelector<Pair<Long, Long>> {
    public static final Parcelable.Creator<RangeDateSelector> CREATOR;
    private static int artificialFrame = 1;
    private static byte extraCallback;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME;
    private CharSequence error;
    private String invalidRangeStartError;
    private SimpleDateFormat textInputFormat;
    private final String invalidRangeEndError = StringUtils.SPACE;
    private Long selectedStartItem = null;
    private Long selectedEndItem = null;
    private Long proposedTextStart = null;
    private Long proposedTextEnd = null;

    private boolean isValidRange(long j, long j2) {
        return j <= j2;
    }

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
        Long l = this.selectedStartItem;
        if (l == null) {
            this.selectedStartItem = Long.valueOf(j);
        } else if (this.selectedEndItem == null && isValidRange(l.longValue(), j)) {
            this.selectedEndItem = Long.valueOf(j);
        } else {
            this.selectedEndItem = null;
            this.selectedStartItem = Long.valueOf(j);
        }
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public boolean isSelectionComplete() {
        Long l = this.selectedStartItem;
        return (l == null || this.selectedEndItem == null || !isValidRange(l.longValue(), this.selectedEndItem.longValue())) ? false : true;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public void setSelection(@NonNull Pair<Long, Long> pair) {
        Long l = pair.first;
        if (l != null && pair.second != null) {
            Preconditions.checkArgument(isValidRange(l.longValue(), pair.second.longValue()));
        }
        Long l2 = pair.first;
        this.selectedStartItem = l2 == null ? null : Long.valueOf(UtcDates.canonicalYearMonthDay(l2.longValue()));
        Long l3 = pair.second;
        this.selectedEndItem = l3 != null ? Long.valueOf(UtcDates.canonicalYearMonthDay(l3.longValue())) : null;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.material.datepicker.DateSelector
    public Pair<Long, Long> getSelection() {
        return new Pair<>(this.selectedStartItem, this.selectedEndItem);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public Collection<Pair<Long, Long>> getSelectedRanges() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair(this.selectedStartItem, this.selectedEndItem));
        return arrayList;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public Collection<Long> getSelectedDays() {
        ArrayList arrayList = new ArrayList();
        Long l = this.selectedStartItem;
        if (l != null) {
            arrayList.add(l);
        }
        Long l2 = this.selectedEndItem;
        if (l2 != null) {
            arrayList.add(l2);
        }
        return arrayList;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public int getDefaultThemeResId(@NonNull Context context) {
        int i;
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        if (Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels) > resources.getDimensionPixelSize(R.dimen.mtrl_calendar_maximum_default_fullscreen_minor_axis)) {
            i = R.attr.materialCalendarTheme;
        } else {
            i = R.attr.materialCalendarFullscreenTheme;
        }
        return MaterialAttributes.resolveOrThrow(context, i, MaterialDatePicker.class.getCanonicalName());
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public String getSelectionDisplayString(@NonNull Context context) {
        int i = 2 % 2;
        int i2 = artificialFrame + 91;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i2 % 128;
        int i3 = i2 % 2;
        Resources resources = context.getResources();
        Long l = this.selectedStartItem;
        if (l == null) {
            int i4 = getARTIFICIAL_FRAME_PACKAGE_NAME + 95;
            artificialFrame = i4 % 128;
            int i5 = i4 % 2;
            if (this.selectedEndItem == null) {
                return resources.getString(R.string.mtrl_picker_range_header_unselected);
            }
        }
        Long l2 = this.selectedEndItem;
        if (l2 == null) {
            int i6 = R.string.mtrl_picker_range_header_only_start_selected;
            Object[] objArr = {DateStrings.getDateString(l.longValue())};
            Configuration configuration = resources.getConfiguration();
            Locale locale = Build.VERSION.SDK_INT >= 24 ? configuration.getLocales().get(0) : configuration.locale;
            String string = resources.getString(i6);
            if (string.startsWith(".,.%")) {
                Object[] objArr2 = new Object[1];
                a(string.substring(4), objArr2);
                string = ((String) objArr2[0]).intern();
            }
            return String.format(locale, string, objArr);
        }
        if (l != null) {
            Pair<String, String> dateRangeString = DateStrings.getDateRangeString(l, l2);
            int i7 = R.string.mtrl_picker_range_header_selected;
            Object[] objArr3 = {dateRangeString.first, dateRangeString.second};
            Configuration configuration2 = resources.getConfiguration();
            Locale locale2 = Build.VERSION.SDK_INT >= 24 ? configuration2.getLocales().get(0) : configuration2.locale;
            String string2 = resources.getString(i7);
            if (string2.startsWith(".,.%")) {
                Object[] objArr4 = new Object[1];
                a(string2.substring(4), objArr4);
                string2 = ((String) objArr4[0]).intern();
            }
            return String.format(locale2, string2, objArr3);
        }
        int i8 = R.string.mtrl_picker_range_header_only_end_selected;
        Object[] objArr5 = {DateStrings.getDateString(l2.longValue())};
        Configuration configuration3 = resources.getConfiguration();
        Locale locale3 = Build.VERSION.SDK_INT >= 24 ? configuration3.getLocales().get(0) : configuration3.locale;
        String string3 = resources.getString(i8);
        if (!(!string3.startsWith(".,.%"))) {
            Object[] objArr6 = new Object[1];
            a(string3.substring(4), objArr6);
            string3 = ((String) objArr6[0]).intern();
        }
        String str = String.format(locale3, string3, objArr5);
        int i9 = artificialFrame + 87;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i9 % 128;
        int i10 = i9 % 2;
        return str;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public String getSelectionContentDescription(@NonNull Context context) {
        String string;
        int i = 2 % 2;
        int i2 = artificialFrame + 105;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i2 % 128;
        if (i2 % 2 != 0) {
            context.getResources();
            String str = DateStrings.getDateRangeString(this.selectedStartItem, this.selectedEndItem).first;
            Object obj = null;
            obj.hashCode();
            throw null;
        }
        Resources resources = context.getResources();
        Pair<String, String> dateRangeString = DateStrings.getDateRangeString(this.selectedStartItem, this.selectedEndItem);
        String str2 = dateRangeString.first;
        String string2 = str2 == null ? resources.getString(R.string.mtrl_picker_announce_current_selection_none) : str2;
        String str3 = dateRangeString.second;
        if (str3 == null) {
            int i3 = getARTIFICIAL_FRAME_PACKAGE_NAME + 73;
            artificialFrame = i3 % 128;
            int i4 = i3 % 2;
            string = resources.getString(R.string.mtrl_picker_announce_current_selection_none);
        } else {
            string = str3;
            int i5 = artificialFrame + AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i5 % 128;
            int i6 = i5 % 2;
        }
        int i7 = R.string.mtrl_picker_announce_current_range_selection;
        Object[] objArr = {string2, string};
        Configuration configuration = resources.getConfiguration();
        Locale locale = Build.VERSION.SDK_INT >= 24 ? configuration.getLocales().get(0) : configuration.locale;
        String string3 = resources.getString(i7);
        if (string3.startsWith(".,.%")) {
            Object[] objArr2 = new Object[1];
            a(string3.substring(4), objArr2);
            string3 = ((String) objArr2[0]).intern();
        }
        String str4 = String.format(locale, string3, objArr);
        int i8 = artificialFrame + 61;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i8 % 128;
        int i9 = i8 % 2;
        return str4;
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
        return R.string.mtrl_picker_range_header_title;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public void setTextInputFormat(@Nullable SimpleDateFormat simpleDateFormat) {
        if (simpleDateFormat != null) {
            simpleDateFormat = (SimpleDateFormat) UtcDates.getNormalizedFormat(simpleDateFormat);
        }
        this.textInputFormat = simpleDateFormat;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public View onCreateTextInputView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle, CalendarConstraints calendarConstraints, @NonNull final OnSelectionChangedListener<Pair<Long, Long>> onSelectionChangedListener) {
        String defaultTextInputHint;
        View viewInflate = layoutInflater.inflate(R.layout.mtrl_picker_text_input_date_range, viewGroup, false);
        final TextInputLayout textInputLayout = (TextInputLayout) viewInflate.findViewById(R.id.mtrl_picker_text_input_range_start);
        final TextInputLayout textInputLayout2 = (TextInputLayout) viewInflate.findViewById(R.id.mtrl_picker_text_input_range_end);
        EditText editText = textInputLayout.getEditText();
        EditText editText2 = textInputLayout2.getEditText();
        if (ManufacturerUtils.isDateInputKeyboardMissingSeparatorCharacters()) {
            editText.setInputType(17);
            editText2.setInputType(17);
        }
        this.invalidRangeStartError = viewInflate.getResources().getString(R.string.mtrl_picker_invalid_range);
        SimpleDateFormat defaultTextInputFormat = this.textInputFormat;
        boolean z = defaultTextInputFormat != null;
        if (!z) {
            defaultTextInputFormat = UtcDates.getDefaultTextInputFormat();
        }
        SimpleDateFormat simpleDateFormat = defaultTextInputFormat;
        Long l = this.selectedStartItem;
        if (l != null) {
            editText.setText(simpleDateFormat.format(l));
            this.proposedTextStart = this.selectedStartItem;
        }
        Long l2 = this.selectedEndItem;
        if (l2 != null) {
            editText2.setText(simpleDateFormat.format(l2));
            this.proposedTextEnd = this.selectedEndItem;
        }
        if (z) {
            defaultTextInputHint = simpleDateFormat.toPattern();
        } else {
            defaultTextInputHint = UtcDates.getDefaultTextInputHint(viewInflate.getResources(), simpleDateFormat);
        }
        String str = defaultTextInputHint;
        textInputLayout.setPlaceholderText(str);
        textInputLayout2.setPlaceholderText(str);
        editText.addTextChangedListener(new DateFormatTextWatcher(str, simpleDateFormat, textInputLayout, calendarConstraints) { // from class: com.google.android.material.datepicker.RangeDateSelector.1
            @Override // com.google.android.material.datepicker.DateFormatTextWatcher
            void onValidDate(@Nullable Long l3) {
                RangeDateSelector.this.proposedTextStart = l3;
                RangeDateSelector.this.updateIfValidTextProposal(textInputLayout, textInputLayout2, onSelectionChangedListener);
            }

            @Override // com.google.android.material.datepicker.DateFormatTextWatcher
            void onInvalidDate() {
                RangeDateSelector.this.proposedTextStart = null;
                RangeDateSelector.this.updateIfValidTextProposal(textInputLayout, textInputLayout2, onSelectionChangedListener);
            }
        });
        editText2.addTextChangedListener(new DateFormatTextWatcher(str, simpleDateFormat, textInputLayout2, calendarConstraints) { // from class: com.google.android.material.datepicker.RangeDateSelector.2
            @Override // com.google.android.material.datepicker.DateFormatTextWatcher
            void onValidDate(@Nullable Long l3) {
                RangeDateSelector.this.proposedTextEnd = l3;
                RangeDateSelector.this.updateIfValidTextProposal(textInputLayout, textInputLayout2, onSelectionChangedListener);
            }

            @Override // com.google.android.material.datepicker.DateFormatTextWatcher
            void onInvalidDate() {
                RangeDateSelector.this.proposedTextEnd = null;
                RangeDateSelector.this.updateIfValidTextProposal(textInputLayout, textInputLayout2, onSelectionChangedListener);
            }
        });
        DateSelector.showKeyboardWithAutoHideBehavior(editText, editText2);
        return viewInflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateIfValidTextProposal(@NonNull TextInputLayout textInputLayout, @NonNull TextInputLayout textInputLayout2, @NonNull OnSelectionChangedListener<Pair<Long, Long>> onSelectionChangedListener) {
        Long l = this.proposedTextStart;
        if (l == null || this.proposedTextEnd == null) {
            clearInvalidRange(textInputLayout, textInputLayout2);
            onSelectionChangedListener.onIncompleteSelectionChanged();
        } else if (isValidRange(l.longValue(), this.proposedTextEnd.longValue())) {
            this.selectedStartItem = this.proposedTextStart;
            this.selectedEndItem = this.proposedTextEnd;
            onSelectionChangedListener.onSelectionChanged(getSelection());
        } else {
            setInvalidRange(textInputLayout, textInputLayout2);
            onSelectionChangedListener.onIncompleteSelectionChanged();
        }
        updateError(textInputLayout, textInputLayout2);
    }

    private void updateError(@NonNull TextInputLayout textInputLayout, @NonNull TextInputLayout textInputLayout2) {
        if (!TextUtils.isEmpty(textInputLayout.getError())) {
            this.error = textInputLayout.getError();
        } else if (!TextUtils.isEmpty(textInputLayout2.getError())) {
            this.error = textInputLayout2.getError();
        } else {
            this.error = null;
        }
    }

    private void clearInvalidRange(@NonNull TextInputLayout textInputLayout, @NonNull TextInputLayout textInputLayout2) {
        if (textInputLayout.getError() != null && this.invalidRangeStartError.contentEquals(textInputLayout.getError())) {
            textInputLayout.setError(null);
        }
        if (textInputLayout2.getError() == null || !StringUtils.SPACE.contentEquals(textInputLayout2.getError())) {
            return;
        }
        textInputLayout2.setError(null);
    }

    private void setInvalidRange(@NonNull TextInputLayout textInputLayout, @NonNull TextInputLayout textInputLayout2) {
        textInputLayout.setError(this.invalidRangeStartError);
        textInputLayout2.setError(StringUtils.SPACE);
    }

    static {
        accessartificialFrame();
        CREATOR = new Parcelable.Creator<RangeDateSelector>() { // from class: com.google.android.material.datepicker.RangeDateSelector.3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public RangeDateSelector createFromParcel(@NonNull Parcel parcel) {
                RangeDateSelector rangeDateSelector = new RangeDateSelector();
                rangeDateSelector.selectedStartItem = (Long) parcel.readValue(Long.class.getClassLoader());
                rangeDateSelector.selectedEndItem = (Long) parcel.readValue(Long.class.getClassLoader());
                return rangeDateSelector;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public RangeDateSelector[] newArray(int i) {
                return new RangeDateSelector[i];
            }
        };
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeValue(this.selectedStartItem);
        parcel.writeValue(this.selectedEndItem);
    }

    static void accessartificialFrame() {
        extraCallback = (byte) -124;
    }
}
