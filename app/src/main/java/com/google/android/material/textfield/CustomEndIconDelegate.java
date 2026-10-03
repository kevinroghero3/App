package com.google.android.material.textfield;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes5.dex */
class CustomEndIconDelegate extends EndIconDelegate {
    CustomEndIconDelegate(@NonNull EndCompoundLayout endCompoundLayout) {
        super(endCompoundLayout);
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    void setUp() {
        this.endLayout.setEndIconOnLongClickListener(null);
    }
}
