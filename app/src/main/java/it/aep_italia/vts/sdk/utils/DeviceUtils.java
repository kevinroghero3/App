package it.aep_italia.vts.sdk.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Build;
import android.provider.Settings;
import it.aep_italia.vts.sdk.core.VtsLog;
import it.aep_italia.vts.sdk.core.VtsSecureStorage;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.HashMap;

/* JADX INFO: loaded from: classes6.dex */
public class DeviceUtils {
    private static String a(boolean z) throws SocketException {
        Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
        while (networkInterfaces.hasMoreElements()) {
            Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
            while (inetAddresses.hasMoreElements()) {
                InetAddress inetAddressNextElement = inetAddresses.nextElement();
                if (!inetAddressNextElement.isLoopbackAddress() && (!z || (inetAddressNextElement instanceof Inet4Address))) {
                    if (z || (inetAddressNextElement instanceof Inet6Address)) {
                        return inetAddressNextElement.getHostAddress();
                    }
                }
            }
        }
        return null;
    }

    public static String getCryptedDevideUID(VtsSecureStorage vtsSecureStorage) {
        try {
            return vtsSecureStorage.read("DeviceUID");
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getDeviceSubType() {
        return String.format("Android %s %s on %s %s", Build.VERSION.RELEASE, Build.VERSION.CODENAME, Build.MANUFACTURER, Build.MODEL);
    }

    public static long getDeviceUID(Context context) {
        if (!getStoredDevideUID(context).isEmpty()) {
            return StringUtils.unsignedHexStringToSignedLong(getStoredDevideUID(context));
        }
        String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        setStoredDevideUID(context, string);
        return StringUtils.unsignedHexStringToSignedLong(string);
    }

    public static long getDeviceUIDCrypt(Context context) {
        String cryptedDevideUID;
        VtsSecureStorage vtsSecureStorage = new VtsSecureStorage(context);
        HashMap map = new HashMap();
        map.put("encryptedSharedPreferences", "true");
        vtsSecureStorage.options = map;
        if (getCryptedDevideUID(vtsSecureStorage).isEmpty()) {
            cryptedDevideUID = Settings.Secure.getString(context.getContentResolver(), "android_id");
            setCryptedDevideUID(vtsSecureStorage, cryptedDevideUID);
        } else {
            cryptedDevideUID = getCryptedDevideUID(vtsSecureStorage);
        }
        return StringUtils.unsignedHexStringToSignedLong(cryptedDevideUID);
    }

    public static String getDeviceUIDHex(Context context) {
        return Long.toHexString(getDeviceUID(context));
    }

    public static String getIMEI(Context context) {
        return "";
    }

    public static String getIMSI(Context context) {
        return "";
    }

    public static String getLocalIpv4Address() {
        try {
            return a(true);
        } catch (SocketException unused) {
            return null;
        }
    }

    public static String getLocalIpv6Address() {
        try {
            return a(false);
        } catch (SocketException unused) {
            return null;
        }
    }

    public static String getPhoneNumber(Context context) {
        return "";
    }

    public static String getSIMID(Context context) {
        return "";
    }

    public static String getStoredDevideUID(Context context) {
        return context.getSharedPreferences("vtsSDK", 0).getString("DeviceUID", "");
    }

    public static boolean isOnWiFiNetwork(Context context) {
        NetworkCapabilities networkCapabilities;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        Network activeNetwork = connectivityManager.getActiveNetwork();
        if (activeNetwork == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null) {
            return false;
        }
        return networkCapabilities.hasTransport(1) || networkCapabilities.hasTransport(0) || networkCapabilities.hasTransport(3) || networkCapabilities.hasTransport(2);
    }

    public static void setCryptedDevideUID(VtsSecureStorage vtsSecureStorage, String str) {
        VtsLog.i("Saving DeviceUID to %s", str);
        try {
            vtsSecureStorage.write("DeviceUID", str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setStoredDevideUID(Context context, String str) {
        VtsLog.i("Saving DeviceUID to %s", str);
        context.getSharedPreferences("vtsSDK", 0).edit().putString("DeviceUID", str).apply();
    }
}
