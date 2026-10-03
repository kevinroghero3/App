package com.salesforce.marketingcloud.sfmcsdk.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.security.ProviderInstaller;
import com.salesforce.marketingcloud.sfmcsdk.components.logging.SFMCSdkLogger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public final class NetworkUtils {
    public static final NetworkUtils INSTANCE = new NetworkUtils();
    public static final String TAG = "~$NetworkUtils";

    private NetworkUtils() {
    }

    @JvmStatic
    public static final boolean hasConnectivity(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("connectivity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
        Network activeNetwork = connectivityManager.getActiveNetwork();
        if (activeNetwork == null) {
            SFMCSdkLogger.INSTANCE.d(TAG, new Function0<String>() { // from class: com.salesforce.marketingcloud.sfmcsdk.util.NetworkUtils$hasConnectivity$network$1$1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Device has _no_ connectivity.";
                }
            });
            return false;
        }
        NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork);
        if (networkCapabilities == null) {
            SFMCSdkLogger.INSTANCE.d(TAG, new Function0<String>() { // from class: com.salesforce.marketingcloud.sfmcsdk.util.NetworkUtils$hasConnectivity$activeNetwork$1$1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Device has _no_ connectivity.";
                }
            });
            return false;
        }
        if (networkCapabilities.hasTransport(1) || networkCapabilities.hasTransport(0) || networkCapabilities.hasTransport(3) || networkCapabilities.hasTransport(2)) {
            return true;
        }
        SFMCSdkLogger.INSTANCE.d(TAG, new Function0<String>() { // from class: com.salesforce.marketingcloud.sfmcsdk.util.NetworkUtils.hasConnectivity.1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Device has _no_ connectivity.";
            }
        });
        return false;
    }

    @JvmStatic
    public static final void installProvidersIfNeeded(@NotNull Context context) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        Intrinsics.checkNotNullParameter(context, "context");
        ProviderInstaller.installIfNeeded(context);
    }
}
