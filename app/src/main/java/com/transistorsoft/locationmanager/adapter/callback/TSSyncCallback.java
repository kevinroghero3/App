package com.transistorsoft.locationmanager.adapter.callback;

import com.transistorsoft.locationmanager.data.LocationModel;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface TSSyncCallback {
    void onFailure(String str);

    void onSuccess(List<LocationModel> list);
}
