package com.reactnativecommunity.picker;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatSpinner;
import com.facebook.react.uimanager.StateWrapper;

/* JADX INFO: loaded from: classes3.dex */
public abstract class FabricEnabledPicker extends AppCompatSpinner {
    protected void setMeasuredHeight(int i) {
    }

    public void setStateWrapper(StateWrapper stateWrapper) {
    }

    public FabricEnabledPicker(@NonNull Context context) {
        super(context);
    }

    public FabricEnabledPicker(@NonNull Context context, int i) {
        super(context, i);
    }

    public FabricEnabledPicker(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FabricEnabledPicker(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public FabricEnabledPicker(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public FabricEnabledPicker(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2, Resources.Theme theme) {
        super(context, attributeSet, i, i2, theme);
    }
}
