package com.intentfilter.androidpermissions.services;

import android.content.Context;
import android.content.Intent;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.intentfilter.androidpermissions.PermissionsActivity;
import com.intentfilter.androidpermissions.models.DeniedPermissions;
import java.util.Set;
import org.parceler.Parcels;

/* JADX INFO: loaded from: classes3.dex */
public class BroadcastService {
    private final Context context;

    /* JADX INFO: loaded from: classes6.dex */
    public interface IntentAction {
        public static final String ACTION_PERMISSIONS_REQUEST = "com.intentfilter.androidpermissions.PERMISSIONS_REQUEST";
    }

    public BroadcastService(Context context) {
        this.context = context;
    }

    public void broadcastPermissionRequestResult(Set<String> set, DeniedPermissions deniedPermissions) {
        Intent intent = new Intent(IntentAction.ACTION_PERMISSIONS_REQUEST);
        intent.putExtra(PermissionsActivity.EXTRA_PERMISSIONS_GRANTED, (String[]) set.toArray(new String[0]));
        intent.putExtra(PermissionsActivity.EXTRA_PERMISSIONS_DENIED, Parcels.wrap(deniedPermissions));
        LocalBroadcastManager.getInstance(this.context).sendBroadcast(intent);
    }
}
