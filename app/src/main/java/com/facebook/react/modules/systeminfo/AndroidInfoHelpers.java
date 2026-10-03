package com.facebook.react.modules.systeminfo;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.util.Base64;
import com.facebook.common.logging.FLog;
import com.facebook.react.R;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.apache.commons.lang3.CharEncoding;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class AndroidInfoHelpers {
    public static final String DEVICE_LOCALHOST = "localhost";
    public static final String EMULATOR_LOCALHOST = "10.0.2.2";
    public static final String GENYMOTION_LOCALHOST = "10.0.3.2";
    public static final AndroidInfoHelpers INSTANCE;
    public static final String METRO_HOST_PROP_NAME = "metro.host";
    private static final String TAG;
    private static int artificialFrame = 1;
    private static byte extraCallback;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME;
    private static String metroHostPropValue;

    private AndroidInfoHelpers() {
    }

    static {
        accessartificialFrame();
        INSTANCE = new AndroidInfoHelpers();
        TAG = AndroidInfoHelpers.class.getSimpleName();
    }

    private final boolean isRunningOnGenymotion() {
        String FINGERPRINT = Build.FINGERPRINT;
        Intrinsics.checkNotNullExpressionValue(FINGERPRINT, "FINGERPRINT");
        return StringsKt__StringsKt.contains$default((CharSequence) FINGERPRINT, (CharSequence) "vbox", false, 2, (Object) null);
    }

    private static void a(String str, Object[] objArr) {
        byte[] bArrDecode = Base64.decode(str, 0);
        byte[] bArr = new byte[bArrDecode.length];
        for (int i = 0; i < bArrDecode.length; i++) {
            bArr[i] = (byte) (bArrDecode[(bArrDecode.length - i) - 1] ^ extraCallback);
        }
        objArr[0] = new String(bArr, StandardCharsets.UTF_8);
    }

    private final boolean isRunningOnStockEmulator() {
        String FINGERPRINT = Build.FINGERPRINT;
        Intrinsics.checkNotNullExpressionValue(FINGERPRINT, "FINGERPRINT");
        if (!StringsKt__StringsKt.contains$default((CharSequence) FINGERPRINT, (CharSequence) "generic", false, 2, (Object) null)) {
            Intrinsics.checkNotNullExpressionValue(FINGERPRINT, "FINGERPRINT");
            if (!StringsKt__StringsJVMKt.startsWith$default(FINGERPRINT, "google/sdk_gphone", false, 2, null)) {
                return false;
            }
        }
        return true;
    }

    @JvmStatic
    public static final String getServerHost(int i) {
        return INSTANCE.getServerIpAddress(i);
    }

    @JvmStatic
    public static final String getServerHost(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        AndroidInfoHelpers androidInfoHelpers = INSTANCE;
        return androidInfoHelpers.getServerIpAddress(androidInfoHelpers.getDevServerPort(context));
    }

    @JvmStatic
    public static final String getAdbReverseTcpCommand(int i) {
        return "adb reverse tcp:" + i + " tcp:" + i;
    }

    @JvmStatic
    public static final String getAdbReverseTcpCommand(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return getAdbReverseTcpCommand(INSTANCE.getDevServerPort(context));
    }

    @JvmStatic
    public static final String getFriendlyDeviceName() {
        if (INSTANCE.isRunningOnGenymotion()) {
            String str = Build.MODEL;
            Intrinsics.checkNotNull(str);
            return str;
        }
        return Build.MODEL + " - " + Build.VERSION.RELEASE + " - API " + Build.VERSION.SDK_INT;
    }

    @JvmStatic
    public static final Map<String, String> getInspectorHostMetadata(@Nullable Context context) {
        String packageName;
        String string;
        int i = 2 % 2;
        int i2 = getARTIFICIAL_FRAME_PACKAGE_NAME + 83;
        artificialFrame = i2 % 128;
        int i3 = i2 % 2;
        if (context != null) {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            int i4 = applicationInfo.labelRes;
            packageName = context.getPackageName();
            if (i4 == 0) {
                int i5 = getARTIFICIAL_FRAME_PACKAGE_NAME + 57;
                artificialFrame = i5 % 128;
                int i6 = i5 % 2;
                string = applicationInfo.nonLocalizedLabel.toString();
            } else {
                string = context.getString(i4);
                if (string.startsWith(".,.%")) {
                    int i7 = getARTIFICIAL_FRAME_PACKAGE_NAME + 37;
                    artificialFrame = i7 % 128;
                    if (i7 % 2 == 0) {
                        Object[] objArr = new Object[1];
                        a(string.substring(4), objArr);
                        string = ((String) objArr[0]).intern();
                        int i8 = 5 / 0;
                    } else {
                        Object[] objArr2 = new Object[1];
                        a(string.substring(4), objArr2);
                        string = ((String) objArr2[0]).intern();
                    }
                }
                Intrinsics.checkNotNull(string);
            }
        } else {
            packageName = null;
            string = null;
        }
        return MapsKt__MapsKt.mapOf(TuplesKt.to("appDisplayName", string), TuplesKt.to("appIdentifier", packageName), TuplesKt.to("platform", "android"), TuplesKt.to("deviceName", Build.MODEL), TuplesKt.to("reactNativeVersion", INSTANCE.getReactNativeVersionString()));
    }

    /* JADX WARN: Code duplicated, block: B:6:0x002f  */
    private final String getReactNativeVersionString() {
        String str;
        Map<String, Object> map = ReactNativeVersion.VERSION;
        Object obj = map.get("major");
        Object obj2 = map.get("minor");
        Object obj3 = map.get("patch");
        Object obj4 = map.get("prerelease");
        if (obj4 != null) {
            str = "-" + obj4;
            if (str == null) {
                str = "";
            }
        } else {
            str = "";
        }
        return obj + "." + obj2 + "." + obj3 + str;
    }

    private final int getDevServerPort(Context context) {
        return context.getResources().getInteger(R.integer.react_native_dev_server_port);
    }

    private final String getServerIpAddress(int i) {
        String metroHostPropValue2;
        if (getMetroHostPropValue().length() > 0) {
            metroHostPropValue2 = getMetroHostPropValue();
        } else if (isRunningOnGenymotion()) {
            metroHostPropValue2 = GENYMOTION_LOCALHOST;
        } else {
            metroHostPropValue2 = isRunningOnStockEmulator() ? EMULATOR_LOCALHOST : DEVICE_LOCALHOST;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(Locale.US, "%s:%d", Arrays.copyOf(new Object[]{metroHostPropValue2, Integer.valueOf(i)}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    /* JADX WARN: Code duplicated, block: B:38:0x0073  */
    /* JADX WARN: Code duplicated, block: B:45:0x0080 A[Catch: all -> 0x0089, TRY_ENTER, TryCatch #5 {, blocks: (B:3:0x0001, B:5:0x0005, B:16:0x0040, B:35:0x006c, B:36:0x006f, B:45:0x0080, B:47:0x0085, B:48:0x0088, B:32:0x0066), top: B:54:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:47:0x0085 A[Catch: all -> 0x0089, TryCatch #5 {, blocks: (B:3:0x0001, B:5:0x0005, B:16:0x0040, B:35:0x006c, B:36:0x006f, B:45:0x0080, B:47:0x0085, B:48:0x0088, B:32:0x0066), top: B:54:0x0001 }] */
    private final String getMetroHostPropValue() {
        Throwable th;
        Process processExec;
        BufferedReader bufferedReader;
        Throwable th2;
        String str;
        synchronized (this) {
            String str2 = metroHostPropValue;
            if (str2 != null) {
                Intrinsics.checkNotNull(str2);
                return str2;
            }
            BufferedReader bufferedReader2 = null;
            bufferedReader2 = null;
            Process process = null;
            try {
                processExec = Runtime.getRuntime().exec(new String[]{"/system/bin/getprop", METRO_HOST_PROP_NAME});
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(processExec.getInputStream(), Charset.forName(CharEncoding.UTF_8)));
                    String str3 = "";
                    while (true) {
                        try {
                            String line = bufferedReader.readLine();
                            if (line == null) {
                                break;
                            }
                            str3 = line;
                        } catch (Exception e) {
                            e = e;
                            process = processExec;
                            try {
                                FLog.w(TAG, "Failed to query for metro.host prop:", e);
                                metroHostPropValue = "";
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                }
                                if (process != null) {
                                    processExec = process;
                                }
                                str = metroHostPropValue;
                                if (str == null) {
                                    str = "";
                                }
                                return str;
                            } catch (Throwable th3) {
                                processExec = process;
                                th2 = th3;
                                BufferedReader bufferedReader3 = bufferedReader;
                                th = th2;
                                bufferedReader2 = bufferedReader3;
                                if (bufferedReader2 != null) {
                                    bufferedReader2.close();
                                }
                                if (processExec != null) {
                                    processExec.destroy();
                                }
                                throw th;
                            }
                        } catch (Throwable th4) {
                            th2 = th4;
                            BufferedReader bufferedReader4 = bufferedReader;
                            th = th2;
                            bufferedReader2 = bufferedReader4;
                            if (bufferedReader2 != null) {
                                bufferedReader2.close();
                            }
                            if (processExec != null) {
                                processExec.destroy();
                            }
                            throw th;
                        }
                    }
                    metroHostPropValue = str3;
                    bufferedReader.close();
                } catch (Exception e2) {
                    bufferedReader = null;
                    process = processExec;
                    e = e2;
                } catch (Throwable th5) {
                    th = th5;
                    if (bufferedReader2 != null) {
                        bufferedReader2.close();
                    }
                    if (processExec != null) {
                        processExec.destroy();
                    }
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                bufferedReader = null;
            } catch (Throwable th6) {
                th = th6;
                processExec = null;
            }
            processExec.destroy();
            str = metroHostPropValue;
            if (str == null) {
                str = "";
            }
            return str;
        }
    }

    static void accessartificialFrame() {
        extraCallback = (byte) -124;
    }
}
