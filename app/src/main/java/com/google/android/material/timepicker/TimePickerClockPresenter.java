package com.google.android.material.timepicker;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.util.Base64;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import androidx.core.content.ContextCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.material.R;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
class TimePickerClockPresenter implements ClockHandView.OnRotateListener, TimePickerView.OnSelectionChange, TimePickerView.OnPeriodChangeListener, ClockHandView.OnActionUpListener, TimePickerPresenter {
    private static final int DEGREES_PER_HOUR = 30;
    private static final int DEGREES_PER_MINUTE = 6;
    private boolean broadcasting = false;
    private float hourRotation;
    private float minuteRotation;
    private final TimeModel time;
    private final TimePickerView timePickerView;
    private static final String[] HOUR_CLOCK_VALUES = {"12", AppEventsConstants.EVENT_PARAM_VALUE_YES, ExifInterface.GPS_MEASUREMENT_2D, ExifInterface.GPS_MEASUREMENT_3D, "4", "5", "6", "7", "8", "9", "10", "11"};
    private static final String[] HOUR_CLOCK_24_VALUES = {"00", AppEventsConstants.EVENT_PARAM_VALUE_YES, ExifInterface.GPS_MEASUREMENT_2D, ExifInterface.GPS_MEASUREMENT_3D, "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"};
    private static final String[] MINUTE_CLOCK_VALUES = {"00", "5", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"};

    public TimePickerClockPresenter(TimePickerView timePickerView, TimeModel timeModel) {
        this.timePickerView = timePickerView;
        this.time = timeModel;
        initialize();
    }

    @Override // com.google.android.material.timepicker.TimePickerPresenter
    public void initialize() {
        if (this.time.format == 0) {
            this.timePickerView.showToggle();
        }
        this.timePickerView.addOnRotateListener(this);
        this.timePickerView.setOnSelectionChangeListener(this);
        this.timePickerView.setOnPeriodChangeListener(this);
        this.timePickerView.setOnActionUpListener(this);
        updateValues();
        invalidate();
    }

    @Override // com.google.android.material.timepicker.TimePickerPresenter
    public void invalidate() {
        this.hourRotation = getHourRotation();
        TimeModel timeModel = this.time;
        this.minuteRotation = timeModel.minute * 6;
        setSelection(timeModel.selection, false);
        updateTime();
    }

    @Override // com.google.android.material.timepicker.TimePickerPresenter
    public void show() {
        this.timePickerView.setVisibility(0);
    }

    @Override // com.google.android.material.timepicker.TimePickerPresenter
    public void hide() {
        this.timePickerView.setVisibility(8);
    }

    private String[] getHourClockValues() {
        return this.time.format == 1 ? HOUR_CLOCK_24_VALUES : HOUR_CLOCK_VALUES;
    }

    @Override // com.google.android.material.timepicker.ClockHandView.OnRotateListener
    public void onRotate(float f, boolean z) {
        if (this.broadcasting) {
            return;
        }
        TimeModel timeModel = this.time;
        int i = timeModel.hour;
        int i2 = timeModel.minute;
        int iRound = Math.round(f);
        TimeModel timeModel2 = this.time;
        if (timeModel2.selection == 12) {
            timeModel2.setMinute((iRound + 3) / 6);
            this.minuteRotation = (float) Math.floor(this.time.minute * 6);
        } else {
            int i3 = (iRound + 15) / 30;
            if (timeModel2.format == 1) {
                i3 %= 12;
                if (this.timePickerView.getCurrentLevel() == 2) {
                    i3 += 12;
                }
            }
            this.time.setHour(i3);
            this.hourRotation = getHourRotation();
        }
        if (z) {
            return;
        }
        updateTime();
        performHapticFeedback(i, i2);
    }

    private void performHapticFeedback(int i, int i2) {
        TimeModel timeModel = this.time;
        if (timeModel.minute == i2 && timeModel.hour == i) {
            return;
        }
        this.timePickerView.performHapticFeedback(4);
    }

    @Override // com.google.android.material.timepicker.TimePickerView.OnSelectionChange
    public void onSelectionChanged(int i) {
        setSelection(i, true);
    }

    @Override // com.google.android.material.timepicker.TimePickerView.OnPeriodChangeListener
    public void onPeriodChange(int i) {
        this.time.setPeriod(i);
    }

    void setSelection(int i, boolean z) {
        boolean z2 = i == 12;
        this.timePickerView.setAnimateOnTouchUp(z2);
        this.time.selection = i;
        this.timePickerView.setValues(z2 ? MINUTE_CLOCK_VALUES : getHourClockValues(), z2 ? R.string.material_minute_suffix : this.time.getHourContentDescriptionResId());
        updateCurrentLevel();
        this.timePickerView.setHandRotation(z2 ? this.minuteRotation : this.hourRotation, z);
        this.timePickerView.setActiveSelection(i);
        TimePickerView timePickerView = this.timePickerView;
        timePickerView.setMinuteHourDelegate(new ClickActionDelegate(timePickerView.getContext(), R.string.material_hour_selection) { // from class: com.google.android.material.timepicker.TimePickerClockPresenter.1
            private static int artificialFrame = 1;
            private static byte extraCallback = -124;
            private static int getARTIFICIAL_FRAME_PACKAGE_NAME;

            private void b(String str, Object[] objArr) {
                byte[] bArrDecode = Base64.decode(str, 0);
                byte[] bArr = new byte[bArrDecode.length];
                for (int i2 = 0; i2 < bArrDecode.length; i2++) {
                    bArr[i2] = (byte) (bArrDecode[(bArrDecode.length - i2) - 1] ^ extraCallback);
                }
                objArr[0] = new String(bArr, StandardCharsets.UTF_8);
            }

            @Override // com.google.android.material.timepicker.ClickActionDelegate, androidx.core.view.AccessibilityDelegateCompat
            public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                Locale locale;
                int i2 = 2 % 2;
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                Resources resources = view.getResources();
                int hourContentDescriptionResId = TimePickerClockPresenter.this.time.getHourContentDescriptionResId();
                Object[] objArr = {String.valueOf(TimePickerClockPresenter.this.time.getHourForDisplay())};
                Configuration configuration = resources.getConfiguration();
                if (Build.VERSION.SDK_INT >= 24) {
                    int i3 = artificialFrame + 75;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i3 % 128;
                    locale = i3 % 2 != 0 ? configuration.getLocales().get(1) : configuration.getLocales().get(0);
                    int i4 = getARTIFICIAL_FRAME_PACKAGE_NAME + 47;
                    artificialFrame = i4 % 128;
                    if (i4 % 2 == 0) {
                        int i5 = 5 / 3;
                    }
                } else {
                    locale = configuration.locale;
                }
                String string = resources.getString(hourContentDescriptionResId);
                if (string.startsWith(".,.%")) {
                    int i6 = getARTIFICIAL_FRAME_PACKAGE_NAME + 77;
                    artificialFrame = i6 % 128;
                    if (i6 % 2 == 0) {
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
        TimePickerView timePickerView2 = this.timePickerView;
        timePickerView2.setHourClickDelegate(new ClickActionDelegate(timePickerView2.getContext(), R.string.material_minute_selection) { // from class: com.google.android.material.timepicker.TimePickerClockPresenter.2
            private static int artificialFrame = 1;
            private static byte extraCallback = -124;
            private static int getARTIFICIAL_FRAME_PACKAGE_NAME;

            private void b(String str, Object[] objArr) {
                byte[] bArrDecode = Base64.decode(str, 0);
                byte[] bArr = new byte[bArrDecode.length];
                for (int i2 = 0; i2 < bArrDecode.length; i2++) {
                    bArr[i2] = (byte) (bArrDecode[(bArrDecode.length - i2) - 1] ^ extraCallback);
                }
                objArr[0] = new String(bArr, StandardCharsets.UTF_8);
            }

            @Override // com.google.android.material.timepicker.ClickActionDelegate, androidx.core.view.AccessibilityDelegateCompat
            public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                int i2 = 2 % 2;
                int i3 = artificialFrame + 49;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i3 % 128;
                int i4 = i3 % 2;
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                Resources resources = view.getResources();
                int i5 = R.string.material_minute_suffix;
                Object[] objArr = {String.valueOf(TimePickerClockPresenter.this.time.minute)};
                Configuration configuration = resources.getConfiguration();
                Locale locale = Build.VERSION.SDK_INT >= 24 ? configuration.getLocales().get(0) : configuration.locale;
                String string = resources.getString(i5);
                if (string.startsWith(".,.%")) {
                    int i6 = getARTIFICIAL_FRAME_PACKAGE_NAME + 47;
                    artificialFrame = i6 % 128;
                    if (i6 % 2 == 0) {
                        Object[] objArr2 = new Object[1];
                        b(string.substring(4), objArr2);
                        string = ((String) objArr2[0]).intern();
                        int i7 = 15 / 0;
                    } else {
                        Object[] objArr3 = new Object[1];
                        b(string.substring(4), objArr3);
                        string = ((String) objArr3[0]).intern();
                    }
                }
                accessibilityNodeInfoCompat.setContentDescription(String.format(locale, string, objArr));
            }
        });
    }

    private void updateCurrentLevel() {
        TimeModel timeModel = this.time;
        int i = 1;
        if (timeModel.selection == 10 && timeModel.format == 1 && timeModel.hour >= 12) {
            i = 2;
        }
        this.timePickerView.setCurrentLevel(i);
    }

    @Override // com.google.android.material.timepicker.ClockHandView.OnActionUpListener
    public void onActionUp(float f, boolean z) {
        this.broadcasting = true;
        TimeModel timeModel = this.time;
        int i = timeModel.minute;
        int i2 = timeModel.hour;
        if (timeModel.selection == 10) {
            this.timePickerView.setHandRotation(this.hourRotation, false);
            AccessibilityManager accessibilityManager = (AccessibilityManager) ContextCompat.getSystemService(this.timePickerView.getContext(), AccessibilityManager.class);
            if (accessibilityManager == null || !accessibilityManager.isTouchExplorationEnabled()) {
                setSelection(12, true);
            }
        } else {
            int iRound = Math.round(f);
            if (!z) {
                this.time.setMinute(((iRound + 15) / 30) * 5);
                this.minuteRotation = this.time.minute * 6;
            }
            this.timePickerView.setHandRotation(this.minuteRotation, z);
        }
        this.broadcasting = false;
        updateTime();
        performHapticFeedback(i2, i);
    }

    private void updateTime() {
        TimePickerView timePickerView = this.timePickerView;
        TimeModel timeModel = this.time;
        timePickerView.updateTime(timeModel.period, timeModel.getHourForDisplay(), this.time.minute);
    }

    private void updateValues() {
        updateValues(HOUR_CLOCK_VALUES, TimeModel.NUMBER_FORMAT);
        updateValues(MINUTE_CLOCK_VALUES, TimeModel.ZERO_LEADING_NUMBER_FORMAT);
    }

    private void updateValues(String[] strArr, String str) {
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = TimeModel.formatText(this.timePickerView.getResources(), strArr[i], str);
        }
    }

    private int getHourRotation() {
        return (this.time.getHourForDisplay() * 30) % 360;
    }
}
