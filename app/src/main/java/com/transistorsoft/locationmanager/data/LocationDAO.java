package com.transistorsoft.locationmanager.data;

import com.transistorsoft.locationmanager.location.TSLocation;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public interface LocationDAO {
    List<LocationModel> all();

    List<LocationModel> allWithLocking(Integer num);

    boolean clear();

    void close();

    int count();

    boolean destroy(LocationModel locationModel);

    void destroyAll(List<LocationModel> list);

    LocationModel first();

    String persist(JSONObject jSONObject);

    boolean persist(TSLocation tSLocation);

    void prune(int i);

    boolean unlock();

    boolean unlock(LocationModel locationModel);

    boolean unlock(List<LocationModel> list);
}
