package com.intentfilter.androidpermissions;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.intentfilter.androidpermissions.helpers.AppStatus;
import com.intentfilter.androidpermissions.helpers.Logger;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public class NotificationDismissReceiver extends BroadcastReceiver {
    private static final Logger logger = Logger.loggerFor(NotificationDismissReceiver.class);

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String[] stringArrayExtra = intent.getStringArrayExtra("com.intentfilter.androidpermissions.PERMISSIONS");
        if (new AppStatus(context).isInForeground()) {
            showPermissionsDialog(context, stringArrayExtra);
        } else {
            PermissionManager.getInstance(context).removePendingPermissionRequests(Arrays.asList(stringArrayExtra));
        }
        logger.i("Pending permission notification dismissed. Cancelling: " + Arrays.toString(stringArrayExtra));
    }

    private void showPermissionsDialog(Context context, String[] strArr) {
        Intent intent = new Intent(context, (Class<?>) PermissionsActivity.class);
        intent.putExtra("com.intentfilter.androidpermissions.PERMISSIONS", strArr);
        intent.setFlags(268435456);
        context.startActivity(intent);
    }
}
