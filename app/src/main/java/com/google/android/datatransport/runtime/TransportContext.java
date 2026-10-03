package com.google.android.datatransport.runtime;

import android.util.Base64;
import androidx.annotation.Nullable;
import com.google.android.datatransport.Priority;

/* JADX INFO: loaded from: classes2.dex */
public abstract class TransportContext {

    public static abstract class Builder {
        public abstract TransportContext build();

        public abstract Builder setBackendName(String str);

        public abstract Builder setExtras(@Nullable byte[] bArr);

        public abstract Builder setPriority(Priority priority);
    }

    public abstract String getBackendName();

    public abstract byte[] getExtras();

    public abstract Priority getPriority();

    public boolean shouldUploadClientHealthMetrics() {
        return getExtras() != null;
    }

    public final String toString() {
        return String.format("TransportContext(%s, %s, %s)", getBackendName(), getPriority(), getExtras() == null ? "" : Base64.encodeToString(getExtras(), 2));
    }

    public static Builder builder() {
        return new AutoValue_TransportContext.Builder().setPriority(Priority.DEFAULT);
    }

    public TransportContext withPriority(Priority priority) {
        return builder().setBackendName(getBackendName()).setPriority(priority).setExtras(getExtras()).build();
    }
}
