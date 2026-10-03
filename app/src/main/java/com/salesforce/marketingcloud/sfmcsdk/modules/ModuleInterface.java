package com.salesforce.marketingcloud.sfmcsdk.modules;

import com.salesforce.marketingcloud.sfmcsdk.components.identity.ModuleIdentity;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public interface ModuleInterface {
    ModuleIdentity getModuleIdentity();

    JSONObject getState();
}
