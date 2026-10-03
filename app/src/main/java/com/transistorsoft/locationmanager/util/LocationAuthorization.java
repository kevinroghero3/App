package com.transistorsoft.locationmanager.util;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import androidx.core.content.ContextCompat;
import com.intentfilter.androidpermissions.PermissionManager;
import com.intentfilter.androidpermissions.models.DeniedPermissions;
import com.transistorsoft.locationmanager.activity.TSLocationManagerActivity;
import com.transistorsoft.locationmanager.adapter.BackgroundGeolocation;
import com.transistorsoft.locationmanager.adapter.TSConfig;
import com.transistorsoft.locationmanager.config.TSBackgroundPermissionRationale;
import com.transistorsoft.locationmanager.event.LocationProviderChangeEvent;
import com.transistorsoft.locationmanager.logger.TSLog;
import com.transistorsoft.locationmanager.settings.Settings;
import com.transistorsoft.rnbackgroundgeolocation.RNBackgroundGeolocationModule;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.greenrobot.eventbus.EventBus;

/* JADX INFO: loaded from: classes.dex */
public class LocationAuthorization {
    public static final String AUTHORIZATION_REQUEST_ALWAYS = "Always";
    public static final String AUTHORIZATION_REQUEST_ANY = "Any";
    public static final String AUTHORIZATION_REQUEST_WHEN_IN_USE = "WhenInUse";
    public static final String LOCATION_PERMISSION_DENIED = "Permission denied";
    public static final String LOCATION_PERMISSION_GRANTED = "Permission granted";
    public static final String LOCATION_PERMISSION_REQUESTING = "Requesting permission";
    public static final String LOCATION_PERMISSION_REQUESTING_BACKGROUND = "Requesting Background permission";
    public static final String NAME = "LocationAuthorization";
    private static final List<PermissionManager.PermissionRequestListener> a = new ArrayList();
    private static final AtomicInteger b = new AtomicInteger(-1);
    private static final AtomicBoolean c = new AtomicBoolean(false);

    class a implements Runnable {
        final /* synthetic */ PermissionManager.PermissionRequestListener a;
        final /* synthetic */ DeniedPermissions b;

        a(PermissionManager.PermissionRequestListener permissionRequestListener, DeniedPermissions deniedPermissions) {
            this.a = permissionRequestListener;
            this.b = deniedPermissions;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.onPermissionDenied(this.b);
        }
    }

    class b implements Runnable {
        final /* synthetic */ PermissionManager.PermissionRequestListener a;

        b(PermissionManager.PermissionRequestListener permissionRequestListener) {
            this.a = permissionRequestListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.onPermissionGranted();
        }
    }

    /* JADX INFO: loaded from: classes3.dex */
    class c implements PermissionManager.PermissionRequestListener {
        final /* synthetic */ Context a;
        final /* synthetic */ PermissionManager.PermissionRequestListener b;

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c cVar = c.this;
                LocationAuthorization.d(cVar.a, cVar.b);
            }
        }

        c(Context context, PermissionManager.PermissionRequestListener permissionRequestListener) {
            this.a = context;
            this.b = permissionRequestListener;
        }

        @Override // com.intentfilter.androidpermissions.PermissionManager.PermissionRequestListener
        public void onPermissionDenied(DeniedPermissions deniedPermissions) {
            this.b.onPermissionDenied(deniedPermissions);
        }

        @Override // com.intentfilter.androidpermissions.PermissionManager.PermissionRequestListener
        public void onPermissionGranted() {
            if (LocationAuthorization.hasBackgroundPermission(this.a)) {
                this.b.onPermissionGranted();
            } else {
                BackgroundGeolocation.getUiHandler().post(new a());
            }
        }
    }

    class d implements TSBackgroundPermissionRationale.CompletionHandler {
        final /* synthetic */ Context a;
        final /* synthetic */ PermissionManager.PermissionRequestListener b;
        final /* synthetic */ TSConfig c;

        d(Context context, PermissionManager.PermissionRequestListener permissionRequestListener, TSConfig tSConfig) {
            this.a = context;
            this.b = permissionRequestListener;
            this.c = tSConfig;
        }

        @Override // com.transistorsoft.locationmanager.config.TSBackgroundPermissionRationale.CompletionHandler
        public void onClickCancel() {
            this.c.setDidShowBackgroundPermissionRationale(Boolean.TRUE);
            if (LocationAuthorization.hasPermission(this.a)) {
                this.b.onPermissionGranted();
            } else {
                this.b.onPermissionDenied(new DeniedPermissions());
            }
        }

        @Override // com.transistorsoft.locationmanager.config.TSBackgroundPermissionRationale.CompletionHandler
        public void onClickOk() {
            LocationAuthorization.c(this.a, this.b);
        }
    }

    class e implements Runnable {
        final /* synthetic */ PermissionManager.PermissionRequestListener a;

        e(PermissionManager.PermissionRequestListener permissionRequestListener) {
            this.a = permissionRequestListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.onPermissionDenied(new DeniedPermissions());
        }
    }

    class f implements Runnable {
        final /* synthetic */ PermissionManager.PermissionRequestListener a;

        f(PermissionManager.PermissionRequestListener permissionRequestListener) {
            this.a = permissionRequestListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.onPermissionGranted();
        }
    }

    class g implements Runnable {
        final /* synthetic */ Context a;
        final /* synthetic */ List b;
        final /* synthetic */ PermissionManager.PermissionRequestListener c;

        g(Context context, List list, PermissionManager.PermissionRequestListener permissionRequestListener) {
            this.a = context;
            this.b = list;
            this.c = permissionRequestListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            PermissionManager.getInstance(this.a).checkPermissions(this.b, this.c);
        }
    }

    class h implements PermissionManager.PermissionRequestListener {
        final /* synthetic */ Context a;
        final /* synthetic */ PermissionManager.PermissionRequestListener b;

        h(Context context, PermissionManager.PermissionRequestListener permissionRequestListener) {
            this.a = context;
            this.b = permissionRequestListener;
        }

        @Override // com.intentfilter.androidpermissions.PermissionManager.PermissionRequestListener
        public void onPermissionDenied(DeniedPermissions deniedPermissions) {
            if (LocationAuthorization.hasPermission(this.a)) {
                this.b.onPermissionGranted();
            } else {
                this.b.onPermissionDenied(deniedPermissions);
            }
        }

        @Override // com.intentfilter.androidpermissions.PermissionManager.PermissionRequestListener
        public void onPermissionGranted() {
            if (LocationAuthorization.hasBackgroundPermission(this.a) || LocationAuthorization.hasPermission(this.a)) {
                this.b.onPermissionGranted();
            } else {
                this.b.onPermissionDenied(new DeniedPermissions());
            }
        }
    }

    class i implements Runnable {
        final /* synthetic */ Context a;
        final /* synthetic */ List b;
        final /* synthetic */ PermissionManager.PermissionRequestListener c;

        i(Context context, List list, PermissionManager.PermissionRequestListener permissionRequestListener) {
            this.a = context;
            this.b = list;
            this.c = permissionRequestListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            PermissionManager.getInstance(this.a).checkPermissions(this.b, this.c);
        }
    }

    /* JADX INFO: loaded from: classes3.dex */
    static class j implements PermissionManager.PermissionRequestListener, Runnable {
        private final Context a;
        private final List<String> b;

        j(Context context, List<String> list) {
            this.a = context;
            this.b = list;
        }

        @Override // com.intentfilter.androidpermissions.PermissionManager.PermissionRequestListener
        public void onPermissionDenied(DeniedPermissions deniedPermissions) {
            if (!LocationAuthorization.hasPermission(this.a)) {
                TSLog.logger.warn(TSLog.warn("LocationAuthorization: Permission denied"));
                synchronized (LocationAuthorization.a) {
                    Iterator it2 = LocationAuthorization.a.iterator();
                    while (it2.hasNext()) {
                        ((PermissionManager.PermissionRequestListener) it2.next()).onPermissionDenied(deniedPermissions);
                    }
                    LocationAuthorization.a.clear();
                }
            } else if (Build.VERSION.SDK_INT >= 29) {
                synchronized (LocationAuthorization.a) {
                    Iterator it3 = LocationAuthorization.a.iterator();
                    while (it3.hasNext()) {
                        ((PermissionManager.PermissionRequestListener) it3.next()).onPermissionGranted();
                    }
                    LocationAuthorization.a.clear();
                }
            }
            LocationProviderChangeEvent locationProviderChangeEvent = new LocationProviderChangeEvent(this.a);
            int status = locationProviderChangeEvent.getStatus();
            if (status != LocationAuthorization.b.get()) {
                EventBus.getDefault().post(locationProviderChangeEvent);
            }
            LocationAuthorization.b.set(status);
        }

        @Override // com.intentfilter.androidpermissions.PermissionManager.PermissionRequestListener
        public void onPermissionGranted() {
            TSLog.logger.info(TSLog.ok("LocationAuthorization: Permission granted"));
            synchronized (LocationAuthorization.a) {
                Iterator it2 = LocationAuthorization.a.iterator();
                while (it2.hasNext()) {
                    ((PermissionManager.PermissionRequestListener) it2.next()).onPermissionGranted();
                }
                LocationAuthorization.a.clear();
            }
            LocationProviderChangeEvent locationProviderChangeEvent = new LocationProviderChangeEvent(this.a);
            int status = locationProviderChangeEvent.getStatus();
            if (status != LocationAuthorization.b.get()) {
                EventBus.getDefault().post(locationProviderChangeEvent);
            }
            LocationAuthorization.b.set(status);
        }

        @Override // java.lang.Runnable
        public void run() {
            PermissionManager.getInstance(this.a).checkPermissions(this.b, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Context context, PermissionManager.PermissionRequestListener permissionRequestListener) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(TSLocationManagerActivity.ACCESS_BACKGROUND_LOCATION);
        requestPermission(context, arrayList, new h(context, permissionRequestListener));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(Context context, PermissionManager.PermissionRequestListener permissionRequestListener) {
        TSConfig tSConfig = TSConfig.getInstance(context);
        if (!hasPermission(context) || (!hasActivityPermission(context) && !tSConfig.getDisableMotionActivityUpdates().booleanValue() && !c.get())) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(RNBackgroundGeolocationModule.ACCESS_COARSE_LOCATION);
            arrayList.add(RNBackgroundGeolocationModule.ACCESS_FINE_LOCATION);
            if (!tSConfig.getDisableMotionActivityUpdates().booleanValue()) {
                c.set(true);
                arrayList.add("android.permission.ACTIVITY_RECOGNITION");
            }
            requestPermission(context, arrayList, new c(context, permissionRequestListener));
            return;
        }
        new ArrayList().add(TSLocationManagerActivity.ACCESS_BACKGROUND_LOCATION);
        Activity activity = BackgroundGeolocation.getInstance(context).getActivity();
        TSBackgroundPermissionRationale backgroundPermissionRationale = tSConfig.getBackgroundPermissionRationale();
        boolean zShouldShow = backgroundPermissionRationale.shouldShow(activity);
        TSLog.logger.info(TSLog.notice("Should show backgroundPermissionRationale? " + zShouldShow));
        if (zShouldShow) {
            backgroundPermissionRationale.show(activity, new d(context, permissionRequestListener, tSConfig));
        } else if (hasBackgroundPermission(context)) {
            permissionRequestListener.onPermissionGranted();
        } else {
            c(context, permissionRequestListener);
        }
    }

    public static boolean hasActivityPermission(Context context) {
        return Build.VERSION.SDK_INT < 29 || ContextCompat.checkSelfPermission(context, "android.permission.ACTIVITY_RECOGNITION") == 0;
    }

    public static boolean hasBackgroundPermission(Context context) {
        return Build.VERSION.SDK_INT < 29 || ContextCompat.checkSelfPermission(context, TSLocationManagerActivity.ACCESS_BACKGROUND_LOCATION) == 0;
    }

    public static boolean hasPermission(Context context) {
        return ContextCompat.checkSelfPermission(context, RNBackgroundGeolocationModule.ACCESS_FINE_LOCATION) == 0 || ContextCompat.checkSelfPermission(context, RNBackgroundGeolocationModule.ACCESS_COARSE_LOCATION) == 0;
    }

    public static String logBackgroundWarning(Context context) {
        TSConfig tSConfig = TSConfig.getInstance(context);
        String str = (TSLog.header("⚠️  Background location-updates forbidden (WhenInUse)") + TSLog.boxRow("Cannot initiate location requests in the background/headless with WhenInUse authorization.")) + TSLog.boxRow("Location updates must have previously been initiated with your app in the foreground.  Eg: .changePace(true).");
        if (tSConfig.getUseSignificantChangesOnly().booleanValue()) {
            str = str + TSLog.boxRow("useSignificantChangesOnly cannot continue location-updates after app terminate.");
        }
        if (!tSConfig.getStopOnTerminate().booleanValue()) {
            str = str + TSLog.boxRow("You may want to configure stopOnTerminate: true");
        }
        return str + TSLog.BOX_BOTTOM;
    }

    public static void requestActivityPermission(Context context, PermissionManager.PermissionRequestListener permissionRequestListener) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("android.permission.ACTIVITY_RECOGNITION");
        BackgroundGeolocation.getUiHandler().post(new i(context, arrayList, permissionRequestListener));
    }

    public static void requestPermission(Context context, List<String> list, PermissionManager.PermissionRequestListener permissionRequestListener) {
        boolean z;
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (str.equalsIgnoreCase("LOCATION_ALWAYS")) {
                withBackgroundPermission(context, permissionRequestListener);
                return;
            } else if (str.equalsIgnoreCase("LOCATION_WHEN_IN_USE")) {
                arrayList.add(RNBackgroundGeolocationModule.ACCESS_COARSE_LOCATION);
                arrayList.add(RNBackgroundGeolocationModule.ACCESS_FINE_LOCATION);
            } else if (!str.equalsIgnoreCase("ACTIVITY_RECOGNITION")) {
                arrayList.add(str);
            } else if (Build.VERSION.SDK_INT >= 29) {
                arrayList.add("android.permission.ACTIVITY_RECOGNITION");
            }
        }
        List<PermissionManager.PermissionRequestListener> list2 = a;
        synchronized (list2) {
            list2.add(permissionRequestListener);
            z = true;
            if (list2.size() != 1) {
                z = false;
            }
        }
        if (z) {
            BackgroundGeolocation.getUiHandler().post(new j(context, arrayList));
        }
    }

    public static void requestTemporaryFullAccuracy(Context context, PermissionManager.PermissionRequestListener permissionRequestListener) {
        if (ContextCompat.checkSelfPermission(context, RNBackgroundGeolocationModule.ACCESS_FINE_LOCATION) == 0) {
            permissionRequestListener.onPermissionGranted();
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(RNBackgroundGeolocationModule.ACCESS_COARSE_LOCATION);
        arrayList.add(RNBackgroundGeolocationModule.ACCESS_FINE_LOCATION);
        BackgroundGeolocation.getUiHandler().post(new g(context, arrayList, permissionRequestListener));
    }

    public static void withBackgroundPermission(Context context, PermissionManager.PermissionRequestListener permissionRequestListener) {
        if (!Settings.isValid(context)) {
            BackgroundGeolocation.getUiHandler().post(new a(permissionRequestListener, new DeniedPermissions()));
            return;
        }
        TSConfig tSConfig = TSConfig.getInstance(context);
        if (hasPermission(context) && ((hasBackgroundPermission(context) || !a(tSConfig.getLocationAuthorizationRequest())) && (hasActivityPermission(context) || tSConfig.getDisableMotionActivityUpdates().booleanValue()))) {
            TSLog.logger.debug(TSLog.info("LocationAuthorization: Permission granted"));
            BackgroundGeolocation.getUiHandler().post(new b(permissionRequestListener));
            return;
        }
        TSLog.logger.info(TSLog.notice("LocationAuthorization: Requesting Background permission"));
        tSConfig.setDidShowBackgroundPermissionRationale(Boolean.FALSE);
        ArrayList arrayList = new ArrayList();
        arrayList.add(RNBackgroundGeolocationModule.ACCESS_COARSE_LOCATION);
        arrayList.add(RNBackgroundGeolocationModule.ACCESS_FINE_LOCATION);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 29) {
            if (!tSConfig.getDisableMotionActivityUpdates().booleanValue()) {
                arrayList.add("android.permission.ACTIVITY_RECOGNITION");
            }
            if (a(tSConfig.getLocationAuthorizationRequest(), tSConfig.getDidShowBackgroundPermissionRationale().booleanValue())) {
                if (i2 >= 30) {
                    d(context, permissionRequestListener);
                    return;
                }
                arrayList.add(TSLocationManagerActivity.ACCESS_BACKGROUND_LOCATION);
            }
        }
        requestPermission(context, arrayList, permissionRequestListener);
    }

    public static void withPermission(Context context, PermissionManager.PermissionRequestListener permissionRequestListener) {
        if (!Settings.isValid(context)) {
            BackgroundGeolocation.getUiHandler().post(new e(permissionRequestListener));
            return;
        }
        if (hasPermission(context) && hasBackgroundPermission(context)) {
            TSLog.logger.debug(TSLog.info("LocationAuthorization: Permission granted"));
            BackgroundGeolocation.getUiHandler().post(new f(permissionRequestListener));
            return;
        }
        TSLog.logger.info(TSLog.notice("LocationAuthorization: Requesting permission"));
        ArrayList arrayList = new ArrayList();
        arrayList.add(RNBackgroundGeolocationModule.ACCESS_COARSE_LOCATION);
        arrayList.add(RNBackgroundGeolocationModule.ACCESS_FINE_LOCATION);
        requestPermission(context, arrayList, permissionRequestListener);
    }

    private static boolean a(String str, boolean z) {
        return a(str) || (b(str) && !z);
    }

    private static boolean b(String str) {
        return str.equalsIgnoreCase(AUTHORIZATION_REQUEST_ANY);
    }

    private static boolean a(String str) {
        return str.equalsIgnoreCase(AUTHORIZATION_REQUEST_ALWAYS);
    }

    private static boolean c(String str) {
        return str.equalsIgnoreCase(AUTHORIZATION_REQUEST_WHEN_IN_USE);
    }
}
