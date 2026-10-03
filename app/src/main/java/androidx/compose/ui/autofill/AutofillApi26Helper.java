package androidx.compose.ui.autofill;

import android.view.ViewStructure;
import android.view.autofill.AutofillId;
import android.view.autofill.AutofillValue;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class AutofillApi26Helper {
    public static final int $stable = 0;
    public static final AutofillApi26Helper INSTANCE = new AutofillApi26Helper();

    private AutofillApi26Helper() {
    }

    public final void setAutofillId(@NotNull ViewStructure viewStructure, @NotNull AutofillId autofillId, int i) {
        viewStructure.setAutofillId(autofillId, i);
    }

    public final AutofillId getAutofillId(@NotNull ViewStructure viewStructure) {
        return viewStructure.getAutofillId();
    }

    public final void setAutofillType(@NotNull ViewStructure viewStructure, int i) {
        viewStructure.setAutofillType(i);
    }

    public final void setAutofillHints(@NotNull ViewStructure viewStructure, @NotNull String[] strArr) {
        viewStructure.setAutofillHints(strArr);
    }

    public final boolean isText(@NotNull AutofillValue autofillValue) {
        return autofillValue.isText();
    }

    public final boolean isDate(@NotNull AutofillValue autofillValue) {
        return autofillValue.isDate();
    }

    public final boolean isList(@NotNull AutofillValue autofillValue) {
        return autofillValue.isList();
    }

    public final boolean isToggle(@NotNull AutofillValue autofillValue) {
        return autofillValue.isToggle();
    }

    public final CharSequence textValue(@NotNull AutofillValue autofillValue) {
        return autofillValue.getTextValue();
    }
}
