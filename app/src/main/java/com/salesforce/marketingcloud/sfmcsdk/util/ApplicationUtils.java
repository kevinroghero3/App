package com.salesforce.marketingcloud.sfmcsdk.util;

import android.content.Context;
import ch.qos.logback.core.CoreConstants;
import com.salesforce.marketingcloud.sfmcsdk.components.logging.SFMCSdkLogger;
import java.lang.reflect.Field;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class ApplicationUtils {
    public static final ApplicationUtils INSTANCE = new ApplicationUtils();
    public static final String TAG = "~$ApplicationUtils";

    private ApplicationUtils() {
    }

    @JvmStatic
    public static final String getApplicationName(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            return context.getApplicationInfo().loadLabel(context.getPackageManager()).toString();
        } catch (Exception e) {
            SFMCSdkLogger.INSTANCE.e(TAG, e, new Function0<String>() { // from class: com.salesforce.marketingcloud.sfmcsdk.util.ApplicationUtils.getApplicationName.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Failed to get appName from the packageManager.";
                }
            });
            return null;
        }
    }

    @JvmStatic
    public static final String getApplicationVersion(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            try {
                ApplicationUtils applicationUtils = INSTANCE;
                String packageName = context.getPackageName();
                Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
                Field field = Class.forName(applicationUtils.findBuildConfig(packageName) + ".BuildConfig").getField(CoreConstants.VERSION_NAME_KEY);
                Intrinsics.checkNotNullExpressionValue(field, "getField(...)");
                field.setAccessible(true);
                Object obj = field.get(null);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                return (String) obj;
            } catch (Exception e) {
                SFMCSdkLogger.INSTANCE.w(TAG, e, new Function0<String>() { // from class: com.salesforce.marketingcloud.sfmcsdk.util.ApplicationUtils.getApplicationVersion.1
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Failed to get VERSION_NAME from the application's BuildConfig.";
                    }
                });
                return null;
            }
        } catch (Throwable unused) {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        }
    }

    private final String findBuildConfig(String str) {
        try {
            Class.forName(str + ".BuildConfig");
            return str;
        } catch (Exception unused) {
            if (StringsKt__StringsKt.lastIndexOf$default((CharSequence) str, ".", 0, false, 6, (Object) null) <= 0) {
                return null;
            }
            String strSubstring = str.substring(0, StringsKt__StringsKt.lastIndexOf$default((CharSequence) str, ".", 0, false, 6, (Object) null));
            Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            return findBuildConfig(strSubstring);
        }
    }
}
