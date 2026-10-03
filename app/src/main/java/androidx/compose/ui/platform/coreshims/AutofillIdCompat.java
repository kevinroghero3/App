package androidx.compose.ui.platform.coreshims;

import android.view.autofill.AutofillId;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes4.dex */
public class AutofillIdCompat {
    private final Object mWrappedObj;

    private AutofillIdCompat(@NonNull AutofillId autofillId) {
        this.mWrappedObj = autofillId;
    }

    public static AutofillIdCompat toAutofillIdCompat(@NonNull AutofillId autofillId) {
        return new AutofillIdCompat(autofillId);
    }

    public AutofillId toAutofillId() {
        return AutofillIdCompat$$ExternalSyntheticApiModelOutline0.m(this.mWrappedObj);
    }
}
