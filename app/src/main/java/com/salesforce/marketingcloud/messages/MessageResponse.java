package com.salesforce.marketingcloud.messages;

import com.salesforce.marketingcloud.location.LatLon;

/* JADX INFO: loaded from: classes.dex */
public interface MessageResponse {
    LatLon getRefreshCenter();

    int getRefreshRadius();
}
