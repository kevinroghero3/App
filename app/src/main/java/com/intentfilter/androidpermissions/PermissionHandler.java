package com.intentfilter.androidpermissions;

import android.content.Context;
import com.intentfilter.androidpermissions.helpers.AppStatus;
import com.intentfilter.androidpermissions.helpers.Logger;
import com.intentfilter.androidpermissions.models.DeniedPermission;
import com.intentfilter.androidpermissions.models.DeniedPermissions;
import com.intentfilter.androidpermissions.services.BroadcastService;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes3.dex */
class PermissionHandler {
    private final AppStatus appStatus;
    private final Logger logger;
    private final PermissionManager manager;
    private final Set<String> pendingPermissionRequests;
    private final ConcurrentHashMap<PermissionManager.PermissionRequestListener, Set<String>> requiredPermissionsMap;

    PermissionHandler(PermissionManager permissionManager, Context context) {
        this(new AppStatus(context), Logger.loggerFor(PermissionHandler.class), permissionManager);
    }

    PermissionHandler(AppStatus appStatus, Logger logger, PermissionManager permissionManager) {
        this.requiredPermissionsMap = new ConcurrentHashMap<>();
        this.pendingPermissionRequests = new CopyOnWriteArraySet();
        this.logger = logger;
        this.manager = permissionManager;
        this.appStatus = appStatus;
    }

    void checkPermissions(Collection<String> collection, PermissionManager.PermissionRequestListener permissionRequestListener) {
        Set<String> setFilterGrantedPermissions = filterGrantedPermissions(collection);
        if (setFilterGrantedPermissions.isEmpty()) {
            permissionRequestListener.onPermissionGranted();
            return;
        }
        this.requiredPermissionsMap.put(permissionRequestListener, new HashSet(setFilterGrantedPermissions));
        registerForBroadcastIfNeeded(BroadcastService.IntentAction.ACTION_PERMISSIONS_REQUEST);
        filterPendingPermissions(setFilterGrantedPermissions);
        if (setFilterGrantedPermissions.isEmpty()) {
            return;
        }
        requestPermissions(setFilterGrantedPermissions);
    }

    void onPermissionsResult(String[] strArr, DeniedPermissions deniedPermissions) {
        synchronized (this.requiredPermissionsMap) {
            informPermissionsDenied(deniedPermissions);
            informPermissionsGranted(strArr);
        }
        this.pendingPermissionRequests.removeAll(Arrays.asList(strArr));
        this.pendingPermissionRequests.removeAll(deniedPermissions.stripped());
        if (this.pendingPermissionRequests.isEmpty()) {
            this.manager.unregisterBroadcastReceiver();
        }
    }

    void requestPermissions(Set<String> set) {
        this.logger.i("No pending foreground permission request for " + set + ", asking.");
        this.pendingPermissionRequests.addAll(set);
        if (this.appStatus.isInForeground()) {
            this.manager.startPermissionActivity(set);
        } else {
            this.manager.showPermissionNotification(set);
        }
    }

    void invalidatePendingPermissionRequests(Collection<String> collection) {
        this.pendingPermissionRequests.removeAll(collection);
        DeniedPermissions deniedPermissions = new DeniedPermissions();
        Iterator<String> it2 = collection.iterator();
        while (it2.hasNext()) {
            deniedPermissions.add(new DeniedPermission(it2.next(), false));
        }
        informPermissionsDenied(deniedPermissions);
        if (this.pendingPermissionRequests.isEmpty()) {
            this.manager.unregisterBroadcastReceiver();
        }
    }

    private void informPermissionsDenied(DeniedPermissions deniedPermissions) {
        for (PermissionManager.PermissionRequestListener permissionRequestListener : this.requiredPermissionsMap.keySet()) {
            Set<String> set = this.requiredPermissionsMap.get(permissionRequestListener);
            Set<String> setStripped = deniedPermissions.stripped();
            setStripped.retainAll(set);
            if (!setStripped.isEmpty()) {
                permissionRequestListener.onPermissionDenied(deniedPermissions);
                this.requiredPermissionsMap.remove(permissionRequestListener);
            }
        }
    }

    private void informPermissionsGranted(String[] strArr) {
        for (PermissionManager.PermissionRequestListener permissionRequestListener : this.requiredPermissionsMap.keySet()) {
            Set<String> set = this.requiredPermissionsMap.get(permissionRequestListener);
            set.removeAll(Arrays.asList(strArr));
            if (set.isEmpty()) {
                permissionRequestListener.onPermissionGranted();
                this.requiredPermissionsMap.remove(permissionRequestListener);
            }
        }
    }

    private void registerForBroadcastIfNeeded(String str) {
        if (this.pendingPermissionRequests.isEmpty()) {
            this.manager.registerBroadcastReceiver(str);
        }
    }

    private Set<String> filterGrantedPermissions(Collection<String> collection) {
        HashSet hashSet = new HashSet();
        for (String str : collection) {
            if (!this.manager.permissionAlreadyGranted(str)) {
                hashSet.add(str);
            }
        }
        return hashSet;
    }

    private void filterPendingPermissions(Set<String> set) {
        for (String str : set) {
            if (this.pendingPermissionRequests.contains(str)) {
                this.logger.i("Permission request for " + str + " pending, not asking again.");
            }
        }
        set.removeAll(this.pendingPermissionRequests);
    }
}
