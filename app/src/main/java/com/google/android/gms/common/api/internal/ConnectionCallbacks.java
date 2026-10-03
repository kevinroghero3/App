package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public interface ConnectionCallbacks {
    void onConnected(@Nullable Bundle bundle);

    void onConnectionSuspended(int i);
}
