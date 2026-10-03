package com.google.android.gms.common.util;

import androidx.annotation.NonNull;
import com.google.maps.android.BuildConfig;
import java.util.HashMap;

/* JADX INFO: loaded from: classes4.dex */
public class MapUtils {
    public static void writeStringMapToJson(@NonNull StringBuilder sb, @NonNull HashMap<String, String> map) {
        sb.append("{");
        boolean z = true;
        for (String str : map.keySet()) {
            if (!z) {
                sb.append(",");
            }
            String str2 = map.get(str);
            sb.append("\"");
            sb.append(str);
            sb.append("\":");
            if (str2 == null) {
                sb.append(BuildConfig.TRAVIS);
            } else {
                sb.append("\"");
                sb.append(str2);
                sb.append("\"");
            }
            z = false;
        }
        sb.append("}");
    }
}
