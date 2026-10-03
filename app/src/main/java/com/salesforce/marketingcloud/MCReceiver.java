package com.salesforce.marketingcloud;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public class MCReceiver extends BroadcastReceiver {
    public static final String a = "com.salesforce.marketingcloud.WAKE_FOR_ALARM";
    private static final String b = "alarmName";
    private static final String c = g.a("MCReceiver");

    public static Intent a(@NonNull Context context, String str) {
        return new Intent(context, (Class<?>) MCReceiver.class).setAction(context.getApplicationContext().getPackageName() + ".com.salesforce.marketingcloud.WAKE_FOR_ALARM").putExtra(b, str);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:33:0x0096  */
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        byte b2;
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            g.a(c, "Action was empty %s", intent.toString());
            return;
        }
        String strReplaceFirst = action.replaceFirst(context.getApplicationContext().getPackageName() + ".", "");
        g.d(c, "onReceive with action: %s", strReplaceFirst);
        strReplaceFirst.hashCode();
        switch (strReplaceFirst) {
            case "android.intent.action.AIRPLANE_MODE":
                b2 = 0;
                break;
            case "com.salesforce.marketingcloud.WAKE_FOR_ALARM":
                b2 = 1;
                break;
            case "android.intent.action.TIMEZONE_CHANGED":
                b2 = 2;
                break;
            case "android.intent.action.BOOT_COMPLETED":
                b2 = 3;
                break;
            case "android.intent.action.MY_PACKAGE_REPLACED":
                b2 = 4;
                break;
            case "android.intent.action.ACTION_SHUTDOWN":
                b2 = 5;
                break;
            default:
                b2 = -1;
                break;
        }
        if (b2 != 0) {
            if (b2 == 1) {
                MCService.a(context, intent.getStringExtra(b));
                return;
            } else if (b2 != 2 && b2 != 3 && b2 != 4 && b2 != 5) {
                return;
            }
        }
        com.salesforce.marketingcloud.behaviors.a aVarA = com.salesforce.marketingcloud.behaviors.a.a(strReplaceFirst);
        if (aVarA != null) {
            MCService.a(context, aVarA, intent.getExtras());
        }
    }
}
