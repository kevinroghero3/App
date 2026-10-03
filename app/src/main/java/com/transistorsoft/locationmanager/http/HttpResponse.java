package com.transistorsoft.locationmanager.http;

import android.content.Context;
import com.transistorsoft.locationmanager.logger.TSLog;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class HttpResponse {
    private final Context a;
    public String responseText;
    public int status;

    HttpResponse(Context context, int i, String str) {
        this.responseText = "";
        this.a = context;
        this.status = i;
        if (str != null) {
            this.responseText = str;
        }
    }

    public Context getContext() {
        return this.a;
    }

    public String getResponseText() {
        return this.responseText;
    }

    public int getStatus() {
        return this.status;
    }

    public Boolean isSuccess() {
        int i = this.status;
        return Boolean.valueOf(i == 200 || i == 201 || i == 204);
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status", this.status);
            jSONObject.put("responseText", this.responseText);
            jSONObject.put("success", isSuccess());
        } catch (JSONException e) {
            TSLog.logger.error(TSLog.error(e.getMessage()));
            e.printStackTrace();
        }
        return jSONObject;
    }
}
