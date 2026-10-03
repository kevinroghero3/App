package com.transistorsoft.locationmanager.adapter.callback;

import com.transistorsoft.locationmanager.data.LocationModel;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface TSGetLocationsCallback {
    void onFailure(Integer num);

    void onSuccess(List<LocationModel> list);
}
