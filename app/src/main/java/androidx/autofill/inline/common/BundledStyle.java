package androidx.autofill.inline.common;

import android.os.Bundle;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BundledStyle {
    public final Bundle mBundle;

    protected abstract String getStyleKey();

    public BundledStyle(@NonNull Bundle bundle) {
        this.mBundle = bundle;
    }

    public final Bundle getBundle() {
        return this.mBundle;
    }

    public boolean isValid() {
        Bundle bundle = this.mBundle;
        return bundle != null && bundle.getBoolean(getStyleKey(), false);
    }

    public void assertIsValid() {
        if (isValid()) {
            return;
        }
        throw new IllegalStateException("Invalid style, missing bundle key " + getStyleKey());
    }

    public static abstract class Builder<T extends BundledStyle> {
        public final Bundle mBundle;

        public abstract T build();

        public Builder(@NonNull String str) {
            Bundle bundle = new Bundle();
            this.mBundle = bundle;
            bundle.putBoolean(str, true);
        }
    }
}
