package com.transistorsoft.locationmanager.data;

import com.transistorsoft.locationmanager.logger.TSLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class LocationModel {
    private final String a;
    private final String b;
    private final LocationDAO c;
    public boolean destroyed = false;
    public Integer id;
    public Object json;

    public LocationModel(LocationDAO locationDAO, Integer num, String str, String str2, String str3) {
        this.json = null;
        this.c = locationDAO;
        this.id = num;
        this.a = str;
        this.b = str2;
        try {
            char cCharAt = str3.charAt(0);
            if (cCharAt == '{') {
                this.json = new JSONObject(str3);
            } else {
                if (cCharAt != '[') {
                    throw new JSONException("Invalid JSON");
                }
                this.json = new JSONArray(str3);
            }
        } catch (JSONException e) {
            TSLog.logger.error(TSLog.error("JSON Error: " + e.getMessage()));
            e.printStackTrace();
        }
    }

    public Boolean destroy() {
        this.destroyed = true;
        return Boolean.valueOf(this.c.destroy(this));
    }

    public Integer getId() {
        return this.id;
    }

    public Object getJson() {
        return this.json;
    }

    public String getTimestamp() {
        return this.b;
    }

    public String getUUID() {
        return this.a;
    }

    public Boolean unlock() {
        return Boolean.valueOf(this.c.unlock(this));
    }
}
