package androidx.core.view.autofill;

import android.view.autofill.AutofillId;
import androidx.compose.ui.platform.coreshims.AutofillIdCompat$$ExternalSyntheticApiModelOutline0;

/* JADX INFO: loaded from: classes4.dex */
public class AutofillIdCompat {
    private final Object mWrappedObj;

    private AutofillIdCompat(AutofillId autofillId) {
        this.mWrappedObj = autofillId;
    }

    public static AutofillIdCompat toAutofillIdCompat(AutofillId autofillId) {
        return new AutofillIdCompat(autofillId);
    }

    public AutofillId toAutofillId() {
        return AutofillIdCompat$$ExternalSyntheticApiModelOutline0.m(this.mWrappedObj);
    }
}
