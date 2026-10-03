package com.transistorsoft.locationmanager.adapter.callback;

import com.transistorsoft.locationmanager.location.TSLocation;

/* JADX INFO: loaded from: classes.dex */
public interface TSLocationCallback {
    void onError(Integer num);

    void onLocation(TSLocation tSLocation);
}
