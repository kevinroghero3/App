package com.henninghall.date_picker.pickers;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import com.henninghall.date_picker.Utils;
import com.henninghall.date_picker.generated.NumberPicker;
import io.sentry.android.core.SentryLogcatAdapter;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes6.dex */
public class AndroidNative extends NumberPicker implements Picker {
    private final Handler handler;
    private int internalSpinState;
    private boolean isAnimating;
    private Picker.OnValueChangeListenerInScrolling listenerInScrolling;
    private Picker.OnValueChangeListener onValueChangedListener;
    private boolean spinning;

    @Override // com.henninghall.date_picker.pickers.Picker
    public View getView() {
        return this;
    }

    @Override // com.henninghall.date_picker.pickers.Picker
    public void setTextAlign(Paint.Align align) {
    }

    public AndroidNative(Context context) {
        super(context);
        this.internalSpinState = 0;
        this.handler = new Handler();
    }

    public AndroidNative(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.internalSpinState = 0;
        this.handler = new Handler();
    }

    public AndroidNative(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.internalSpinState = 0;
        this.handler = new Handler();
    }

    @Override // com.henninghall.date_picker.pickers.Picker
    public void smoothScrollToValue(int i, boolean z) {
        smoothScrollToValue(i);
    }

    @Override // com.henninghall.date_picker.pickers.Picker
    public void setTextColor(String str) {
        int color = Color.parseColor(str);
        if (Build.VERSION.SDK_INT >= 29) {
            super.setTextColor(color);
            return;
        }
        try {
            Field declaredField = getClass().getSuperclass().getDeclaredField("mSelectorWheelPaint");
            declaredField.setAccessible(true);
            ((Paint) declaredField.get(this)).setColor(color);
        } catch (IllegalAccessException e) {
            SentryLogcatAdapter.w("setSelectedTextColor", e);
        } catch (IllegalArgumentException e2) {
            SentryLogcatAdapter.w("setSelectedTextColor", e2);
        } catch (NoSuchFieldException e3) {
            SentryLogcatAdapter.w("setSelectedTextColor", e3);
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof EditText) {
                ((EditText) childAt).setTextColor(color);
            }
        }
        invalidate();
    }

    @Override // com.henninghall.date_picker.pickers.Picker
    public void setDividerColor(String str) {
        super.setDividerTint(Color.parseColor(str));
    }

    @Override // com.henninghall.date_picker.pickers.Picker
    public boolean isSpinning() {
        return this.spinning || this.isAnimating;
    }

    @Override // com.henninghall.date_picker.pickers.Picker
    public void smoothScrollToValue(int i) {
        int value = getValue();
        if (i == value) {
            return;
        }
        int shortestScrollOption = Utils.getShortestScrollOption(value, i, getMaxValue(), getWrapSelectorWheel());
        int iAbs = Math.abs(shortestScrollOption);
        this.isAnimating = true;
        this.onValueChangedListener.onSpinnerStateChange();
        this.handler.postDelayed(new Runnable() { // from class: com.henninghall.date_picker.pickers.AndroidNative.1
            @Override // java.lang.Runnable
            public void run() {
                AndroidNative.this.isAnimating = false;
                AndroidNative.this.onValueChangedListener.onSpinnerStateChange();
            }
        }, iAbs * 100);
        int i2 = 0;
        while (i2 < iAbs) {
            changeValueByOne(shortestScrollOption > 0, i2 * 100, i2 == iAbs + (-1));
            i2++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:27:0x0054 A[PHI: r8
  0x0054: PHI (r8v10 int) = (r8v2 int), (r8v4 int), (r8v6 int), (r8v12 int) binds: [B:10:0x0030, B:20:0x0046, B:25:0x0051, B:15:0x003b] A[DONT_GENERATE, DONT_INLINE]] */
    public void changeValueByOne(NumberPicker numberPicker, boolean z) {
        int value;
        int i = 1;
        try {
            try {
                try {
                    Method declaredMethod = getClass().getSuperclass().getDeclaredMethod("changeValueByOne", Boolean.TYPE);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(numberPicker, Boolean.valueOf(z));
                } catch (IllegalArgumentException e) {
                    SentryLogcatAdapter.w("changeValueByOne", e);
                    value = getValue();
                    if (!z) {
                        i = -1;
                    }
                    setValue((value + i) % getMaxValue());
                } catch (InvocationTargetException e2) {
                    SentryLogcatAdapter.w("changeValueByOne", e2);
                    value = getValue();
                    if (!z) {
                        i = -1;
                    }
                    setValue((value + i) % getMaxValue());
                }
            } catch (IllegalAccessException e3) {
                SentryLogcatAdapter.w("changeValueByOne", e3);
                value = getValue();
                if (!z) {
                    i = -1;
                }
                setValue((value + i) % getMaxValue());
            } catch (NoSuchMethodException e4) {
                SentryLogcatAdapter.w("changeValueByOne", e4);
                value = getValue();
                if (!z) {
                    i = -1;
                }
                setValue((value + i) % getMaxValue());
            }
        } catch (Throwable th) {
            setValue((getValue() + (z ? 1 : -1)) % getMaxValue());
            throw th;
        }
    }

    private void changeValueByOne(final boolean z, int i, final boolean z2) {
        this.handler.postDelayed(new Runnable() { // from class: com.henninghall.date_picker.pickers.AndroidNative.2
            @Override // java.lang.Runnable
            public void run() {
                AndroidNative.this.changeValueByOne(this, z);
                if (z2) {
                    AndroidNative.this.sendEventIn500ms();
                }
            }
        }, i);
    }

    @Override // com.henninghall.date_picker.pickers.Picker
    public void setOnValueChangeListenerInScrolling(Picker.OnValueChangeListenerInScrolling onValueChangeListenerInScrolling) {
        this.listenerInScrolling = onValueChangeListenerInScrolling;
    }

    @Override // com.henninghall.date_picker.pickers.Picker
    public void setOnValueChangedListener(Picker.OnValueChangeListener onValueChangeListener) {
        this.onValueChangedListener = onValueChangeListener;
        super.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() { // from class: com.henninghall.date_picker.pickers.AndroidNative.3
            @Override // com.henninghall.date_picker.generated.NumberPicker.OnValueChangeListener
            public void onValueChange(NumberPicker numberPicker, int i, int i2) {
                if (AndroidNative.this.listenerInScrolling != null) {
                    AndroidNative.this.listenerInScrolling.onValueChangeInScrolling(this, i, i2);
                }
                if (AndroidNative.this.internalSpinState == 0) {
                    AndroidNative.this.sendEventIn500ms();
                }
            }
        });
        super.setOnScrollListener(new NumberPicker.OnScrollListener() { // from class: com.henninghall.date_picker.pickers.AndroidNative.4
            @Override // com.henninghall.date_picker.generated.NumberPicker.OnScrollListener
            public void onScrollStateChange(NumberPicker numberPicker, int i) {
                AndroidNative.this.sendEventIfStopped(i);
                AndroidNative.this.internalSpinState = i;
                if (i != 0) {
                    AndroidNative.this.spinning = true;
                    AndroidNative.this.onValueChangedListener.onSpinnerStateChange();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendEventIfStopped(int i) {
        if (this.internalSpinState == 0 || i != 0) {
            return;
        }
        sendEventIn500ms();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendEventIn500ms() {
        this.handler.postDelayed(new Runnable() { // from class: com.henninghall.date_picker.pickers.AndroidNative.5
            @Override // java.lang.Runnable
            public void run() {
                AndroidNative.this.spinning = false;
                AndroidNative.this.onValueChangedListener.onValueChange();
                AndroidNative.this.onValueChangedListener.onSpinnerStateChange();
            }
        }, 500L);
    }

    @Override // com.henninghall.date_picker.generated.NumberPicker, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.handler.removeCallbacksAndMessages(null);
    }
}
