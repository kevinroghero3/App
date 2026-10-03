package com.salesforce.marketingcloud.analytics;

import androidx.annotation.NonNull;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public interface l {

    public enum a {
        SYNC_API("deviceSyncCallTimeMs"),
        TRIGGER_PROCESS("inAppMsgProcessingTimeMs");

        private final String b;

        a(String str) {
            this.b = str;
        }

        public String b() {
            return this.b;
        }
    }

    void a(@NonNull a aVar, @NonNull JSONObject jSONObject);
}
