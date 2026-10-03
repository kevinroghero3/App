package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.annotation.NonNull;
import io.sentry.android.core.SentryLogcatAdapter;

/* JADX INFO: loaded from: classes4.dex */
public class ViewUtils {
    private ViewUtils() {
    }

    public static String getXmlAttributeString(@NonNull String str, @NonNull String str2, @NonNull Context context, @NonNull AttributeSet attributeSet, boolean z, boolean z2, @NonNull String str3) {
        String attributeValue = attributeSet == null ? null : attributeSet.getAttributeValue(str, str2);
        if (attributeValue != null && attributeValue.startsWith("@string/") && z) {
            String strSubstring = attributeValue.substring(8);
            String packageName = context.getPackageName();
            TypedValue typedValue = new TypedValue();
            try {
                context.getResources().getValue(packageName + ":string/" + strSubstring, typedValue, true);
            } catch (Resources.NotFoundException unused) {
                SentryLogcatAdapter.w(str3, "Could not find resource for " + str2 + ": " + attributeValue);
            }
            CharSequence charSequence = typedValue.string;
            if (charSequence != null) {
                attributeValue = charSequence.toString();
            } else {
                SentryLogcatAdapter.w(str3, "Resource " + str2 + " was not a string: " + typedValue.toString());
            }
        }
        if (z2 && attributeValue == null) {
            SentryLogcatAdapter.w(str3, "Required XML attribute \"" + str2 + "\" missing");
        }
        return attributeValue;
    }
}
