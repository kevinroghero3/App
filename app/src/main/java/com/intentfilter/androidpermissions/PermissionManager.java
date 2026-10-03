package com.intentfilter.androidpermissions;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Base64;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.content.ContextCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.intentfilter.androidpermissions.helpers.Logger;
import com.intentfilter.androidpermissions.helpers.VersionOrchestrator;
import com.intentfilter.androidpermissions.models.DeniedPermissions;
import com.intentfilter.androidpermissions.services.NotificationService;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import org.parceler.Parcels;

/* JADX INFO: loaded from: classes3.dex */
public class PermissionManager extends BroadcastReceiver {
    private static int artificialFrame = 1;
    private static byte extraCallback = -124;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME;
    private static PermissionManager permissionManager;
    private final Context context;
    private final Logger logger = Logger.loggerFor(PermissionManager.class);
    private NotificationSettings notificationSettings = NotificationSettings.getDefault();
    private final PermissionHandler permissionHandler;

    public interface PermissionRequestListener {
        void onPermissionDenied(DeniedPermissions deniedPermissions);

        void onPermissionGranted();
    }

    private void a(String str, Object[] objArr) {
        byte[] bArrDecode = Base64.decode(str, 0);
        byte[] bArr = new byte[bArrDecode.length];
        for (int i = 0; i < bArrDecode.length; i++) {
            bArr[i] = (byte) (bArrDecode[(bArrDecode.length - i) - 1] ^ extraCallback);
        }
        objArr[0] = new String(bArr, StandardCharsets.UTF_8);
    }

    private PermissionManager(Context context) {
        this.context = context;
        this.permissionHandler = new PermissionHandler(this, context);
    }

    public static PermissionManager getInstance(Context context) {
        if (permissionManager == null) {
            permissionManager = new PermissionManager(context.getApplicationContext());
        }
        return permissionManager;
    }

    public void checkPermissions(@NonNull Collection<String> collection, @NonNull PermissionRequestListener permissionRequestListener) {
        this.permissionHandler.checkPermissions(collection, permissionRequestListener);
    }

    public void setNotificationSettings(NotificationSettings notificationSettings) {
        this.notificationSettings = notificationSettings;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String[] stringArrayExtra = intent.getStringArrayExtra(PermissionsActivity.EXTRA_PERMISSIONS_GRANTED);
        DeniedPermissions deniedPermissions = (DeniedPermissions) Parcels.unwrap(intent.getParcelableExtra(PermissionsActivity.EXTRA_PERMISSIONS_DENIED));
        logPermissionsResponse(stringArrayExtra, deniedPermissions);
        this.permissionHandler.onPermissionsResult(stringArrayExtra, deniedPermissions);
    }

    void startPermissionActivity(Set<String> set) {
        this.context.startActivity(permissionActivityIntent(set));
    }

    void showPermissionNotification(Set<String> set) {
        int i = 2 % 2;
        NotificationService notificationService = new NotificationService(this.context);
        int titleResId = this.notificationSettings.getTitleResId();
        int messageResId = this.notificationSettings.getMessageResId();
        int smallIconResId = this.notificationSettings.getSmallIconResId();
        String string = this.context.getString(titleResId);
        if (string.startsWith(".,.%")) {
            Object[] objArr = new Object[1];
            a(string.substring(4), objArr);
            string = ((String) objArr[0]).intern();
        }
        String str = string;
        String string2 = this.context.getString(messageResId);
        if (string2.startsWith(".,.%")) {
            int i2 = getARTIFICIAL_FRAME_PACKAGE_NAME + AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
            artificialFrame = i2 % 128;
            int i3 = i2 % 2;
            Object[] objArr2 = new Object[1];
            a(string2.substring(4), objArr2);
            string2 = ((String) objArr2[0]).intern();
            int i4 = artificialFrame + 89;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i4 % 128;
            int i5 = i4 % 2;
        }
        notificationService.notify(set.toString(), set.hashCode(), notificationService.buildNotification(str, string2, smallIconResId, permissionActivityIntent(set), notificationDismissIntent(set)));
        int i6 = getARTIFICIAL_FRAME_PACKAGE_NAME + 39;
        artificialFrame = i6 % 128;
        int i7 = i6 % 2;
    }

    private Intent permissionActivityIntent(Set<String> set) {
        return new Intent(this.context, (Class<?>) PermissionsActivity.class).putExtra("com.intentfilter.androidpermissions.PERMISSIONS", (String[]) set.toArray(new String[0])).setAction(set.toString()).setFlags(268435456);
    }

    boolean permissionAlreadyGranted(String str) {
        return ContextCompat.checkSelfPermission(this.context, str) == 0;
    }

    void registerBroadcastReceiver(String str) {
        this.logger.i("Registering for PERMISSIONS_REQUEST broadcast");
        LocalBroadcastManager.getInstance(this.context).registerReceiver(this, new IntentFilter(str));
    }

    void unregisterBroadcastReceiver() {
        this.logger.i("Un-registering for PERMISSIONS_REQUEST broadcast");
        LocalBroadcastManager.getInstance(this.context).unregisterReceiver(this);
    }

    void removePendingPermissionRequests(List<String> list) {
        this.permissionHandler.invalidatePendingPermissionRequests(list);
    }

    private PendingIntent notificationDismissIntent(Set<String> set) {
        Intent intent = new Intent(this.context, (Class<?>) NotificationDismissReceiver.class);
        intent.putExtra("com.intentfilter.androidpermissions.PERMISSIONS", (String[]) set.toArray(new String[0]));
        return PendingIntent.getBroadcast(this.context, 100, intent, VersionOrchestrator.getImmutablePendingIntentFlags(1073741824));
    }

    private void logPermissionsResponse(String[] strArr, DeniedPermissions deniedPermissions) {
        this.logger.i(String.format("Received broadcast response for permission(s). \nGranted: %s\nDenied: %s", Arrays.toString(strArr), deniedPermissions));
    }
}
