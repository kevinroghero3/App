package com.google.android.gms.common.util;

import android.app.Application;
import android.os.Build;
import android.os.Process;
import android.os.StrictMode;
import com.google.android.gms.common.internal.Preconditions;
import io.sentry.instrumentation.file.SentryFileReader;
import java.io.BufferedReader;
import java.io.IOException;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public class ProcessUtils {

    @Nullable
    private static String zza;
    private static int zzb;

    private ProcessUtils() {
    }

    public static String getMyProcessName() throws Throwable {
        String strTrim;
        if (zza == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                zza = Application.getProcessName();
            } else {
                int iMyPid = zzb;
                if (iMyPid == 0) {
                    iMyPid = Process.myPid();
                    zzb = iMyPid;
                }
                String str = null;
                BufferedReader bufferedReader = null;
                BufferedReader bufferedReader2 = null;
                if (iMyPid > 0) {
                    try {
                        String str2 = "/proc/" + iMyPid + "/cmdline";
                        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
                        try {
                            BufferedReader bufferedReader3 = new BufferedReader(new SentryFileReader(str2));
                            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                            try {
                                String line = bufferedReader3.readLine();
                                Preconditions.checkNotNull(line);
                                strTrim = line.trim();
                            } catch (IOException unused) {
                                strTrim = null;
                            } catch (Throwable th) {
                                th = th;
                                bufferedReader2 = bufferedReader3;
                                IOUtils.closeQuietly(bufferedReader2);
                                throw th;
                            }
                            bufferedReader = bufferedReader3;
                            IOUtils.closeQuietly(bufferedReader);
                            str = strTrim;
                        } catch (Throwable th2) {
                            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                            throw th2;
                        }
                    } catch (IOException unused2) {
                        strTrim = null;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                }
                zza = str;
            }
        }
        return zza;
    }
}
