package com.salesforce.marketingcloud.analytics;

import androidx.annotation.NonNull;
import ch.qos.logback.core.CoreConstants;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class c {
    private c() {
    }

    public static String[] a(@NonNull String str) {
        return str.split("\\s*,\\s*");
    }

    public static String a(List<b> list) {
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (b bVar : list) {
            if (bVar != null) {
                if (z) {
                    z = false;
                } else {
                    sb.append(CoreConstants.COMMA_CHAR);
                }
                sb.append(bVar.d());
            }
        }
        return sb.toString();
    }
}
