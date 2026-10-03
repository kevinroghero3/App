package com.google.android.material.datepicker;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.textfield.TextInputLayout;
import com.salesforce.marketingcloud.analytics.stats.b;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes5.dex */
abstract class DateFormatTextWatcher extends TextWatcherAdapter {
    private static int artificialFrame = 1;
    private static byte extraCallback = -124;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME;
    private final CalendarConstraints constraints;
    private final DateFormat dateFormat;
    private final String formatHint;
    private int lastLength = 0;
    private final String outOfRange;
    private final Runnable setErrorCallback;
    private Runnable setRangeErrorCallback;
    private final TextInputLayout textInputLayout;

    void onInvalidDate() {
    }

    abstract void onValidDate(@Nullable Long l);

    private static void a(String str, Object[] objArr) {
        byte[] bArrDecode = Base64.decode(str, 0);
        byte[] bArr = new byte[bArrDecode.length];
        for (int i = 0; i < bArrDecode.length; i++) {
            bArr[i] = (byte) (bArrDecode[(bArrDecode.length - i) - 1] ^ extraCallback);
        }
        objArr[0] = new String(bArr, StandardCharsets.UTF_8);
    }

    DateFormatTextWatcher(final String str, DateFormat dateFormat, @NonNull TextInputLayout textInputLayout, CalendarConstraints calendarConstraints) {
        this.formatHint = str;
        this.dateFormat = dateFormat;
        this.textInputLayout = textInputLayout;
        this.constraints = calendarConstraints;
        this.outOfRange = textInputLayout.getContext().getString(R.string.mtrl_picker_out_of_range);
        this.setErrorCallback = new Runnable() { // from class: com.google.android.material.datepicker.DateFormatTextWatcher$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$new$0(str);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(String str) {
        int i = 2 % 2;
        int i2 = artificialFrame + 39;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i2 % 128;
        int i3 = i2 % 2;
        TextInputLayout textInputLayout = this.textInputLayout;
        DateFormat dateFormat = this.dateFormat;
        Context context = textInputLayout.getContext();
        String string = context.getString(R.string.mtrl_picker_invalid_format);
        String string2 = context.getString(R.string.mtrl_picker_invalid_format_use);
        if (string2.startsWith(".,.%")) {
            int i4 = getARTIFICIAL_FRAME_PACKAGE_NAME + 43;
            artificialFrame = i4 % 128;
            if (i4 % 2 == 0) {
                Object[] objArr = new Object[1];
                a(string2.substring(4), objArr);
                string2 = ((String) objArr[0]).intern();
                int i5 = 35 / 0;
            } else {
                Object[] objArr2 = new Object[1];
                a(string2.substring(4), objArr2);
                string2 = ((String) objArr2[0]).intern();
            }
        }
        String str2 = String.format(string2, sanitizeDateString(str));
        String string3 = context.getString(R.string.mtrl_picker_invalid_format_example);
        if (string3.startsWith(".,.%")) {
            Object[] objArr3 = new Object[1];
            a(string3.substring(4), objArr3);
            string3 = ((String) objArr3[0]).intern();
        }
        textInputLayout.setError(string + "\n" + str2 + "\n" + String.format(string3, sanitizeDateString(dateFormat.format(new Date(UtcDates.getTodayCalendar().getTimeInMillis())))));
        onInvalidDate();
        int i6 = getARTIFICIAL_FRAME_PACKAGE_NAME + b.i;
        artificialFrame = i6 % 128;
        int i7 = i6 % 2;
    }

    @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
    public void onTextChanged(@NonNull CharSequence charSequence, int i, int i2, int i3) {
        this.textInputLayout.removeCallbacks(this.setErrorCallback);
        this.textInputLayout.removeCallbacks(this.setRangeErrorCallback);
        this.textInputLayout.setError(null);
        onValidDate(null);
        if (TextUtils.isEmpty(charSequence) || charSequence.length() < this.formatHint.length()) {
            return;
        }
        try {
            Date date = this.dateFormat.parse(charSequence.toString());
            this.textInputLayout.setError(null);
            long time = date.getTime();
            if (this.constraints.getDateValidator().isValid(time) && this.constraints.isWithinBounds(time)) {
                onValidDate(Long.valueOf(date.getTime()));
                return;
            }
            Runnable runnableCreateRangeErrorCallback = createRangeErrorCallback(time);
            this.setRangeErrorCallback = runnableCreateRangeErrorCallback;
            runValidation(this.textInputLayout, runnableCreateRangeErrorCallback);
        } catch (ParseException unused) {
            runValidation(this.textInputLayout, this.setErrorCallback);
        }
    }

    @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
    public void beforeTextChanged(@NonNull CharSequence charSequence, int i, int i2, int i3) {
        this.lastLength = charSequence.length();
    }

    @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
    public void afterTextChanged(@NonNull Editable editable) {
        if (!Locale.getDefault().getLanguage().equals(Locale.KOREAN.getLanguage()) && editable.length() != 0 && editable.length() < this.formatHint.length() && editable.length() >= this.lastLength) {
            char cCharAt = this.formatHint.charAt(editable.length());
            if (Character.isLetterOrDigit(cCharAt)) {
                return;
            }
            editable.append(cCharAt);
        }
    }

    private Runnable createRangeErrorCallback(final long j) {
        return new Runnable() { // from class: com.google.android.material.datepicker.DateFormatTextWatcher$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$createRangeErrorCallback$1(j);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createRangeErrorCallback$1(long j) {
        this.textInputLayout.setError(String.format(this.outOfRange, sanitizeDateString(DateStrings.getDateString(j))));
        onInvalidDate();
    }

    private String sanitizeDateString(String str) {
        return str.replace(' ', Typography.nbsp);
    }

    public void runValidation(View view, Runnable runnable) {
        view.post(runnable);
    }
}
