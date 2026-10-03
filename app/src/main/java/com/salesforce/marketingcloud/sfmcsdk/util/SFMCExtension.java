package com.salesforce.marketingcloud.sfmcsdk.util;

import android.text.TextUtils;
import com.salesforce.marketingcloud.sfmcsdk.components.logging.SFMCSdkLogger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class SFMCExtension {
    public static final SFMCExtension INSTANCE = new SFMCExtension();
    public static final String TAG = "~$SFMCExtension";

    private SFMCExtension() {
    }

    @JvmStatic
    public static final String getValidContactKey(@NotNull String contactKey) {
        Intrinsics.checkNotNullParameter(contactKey, "contactKey");
        if (TextUtils.isEmpty(contactKey) || TextUtils.getTrimmedLength(contactKey) == 0) {
            SFMCSdkLogger.INSTANCE.w(TAG, new Function0<String>() { // from class: com.salesforce.marketingcloud.sfmcsdk.util.SFMCExtension.getValidContactKey.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "An empty or blank ContactKey will not be transmitted to the Salesforce servers as its invalid.";
                }
            });
            return null;
        }
        return StringsKt__StringsKt.trim((CharSequence) contactKey).toString();
    }
}
