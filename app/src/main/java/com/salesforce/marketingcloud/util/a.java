package com.salesforce.marketingcloud.util;

import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    private static final String a = "Amazon";

    private a() {
    }

    public static boolean a() {
        return Build.MANUFACTURER.equalsIgnoreCase(a);
    }
}
