package com.salesforce.marketingcloud.sfmcsdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.salesforce.marketingcloud.sfmcsdk.components.behaviors.BehaviorType;
import com.salesforce.marketingcloud.sfmcsdk.components.logging.SFMCSdkLogger;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public final class SFMCSdkReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(@NotNull Context context, @NotNull Intent intent) {
        BehaviorType behaviorTypeFromString;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        String action = intent.getAction();
        if (action == null) {
            action = "";
        }
        String str = action;
        if (StringsKt__StringsKt.isBlank(str)) {
            return;
        }
        final String strReplaceFirst$default = StringsKt__StringsJVMKt.replaceFirst$default(str, context.getApplicationContext().getPackageName() + new Regex("."), "", false, 4, (Object) null);
        SFMCSdkLogger.INSTANCE.d("~$SFMCSdkReceiver", new Function0<String>() { // from class: com.salesforce.marketingcloud.sfmcsdk.SFMCSdkReceiver.onReceive.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "onReceive with action: " + strReplaceFirst$default;
            }
        });
        if (!Intrinsics.areEqual(strReplaceFirst$default, "android.intent.action.MY_PACKAGE_REPLACED") || (behaviorTypeFromString = BehaviorType.Companion.fromString(strReplaceFirst$default)) == null) {
            return;
        }
        SFMCSdkJobIntentService.Companion.enqueueSystemBehavior(context, behaviorTypeFromString, intent.getExtras());
    }
}
