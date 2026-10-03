package io.sentry.android.core.internal.util;

import io.sentry.ISentryLifecycleToken;
import io.sentry.util.AutoClosableReentrantLock;
import io.sentry.util.FileUtils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public final class CpuInfoUtils {
    static final String CPUINFO_MAX_FREQ_PATH = "cpufreq/cpuinfo_max_freq";
    private static final String SYSTEM_CPU_PATH = "/sys/devices/system/cpu";
    private static final CpuInfoUtils instance = new CpuInfoUtils();
    private final AutoClosableReentrantLock lock = new AutoClosableReentrantLock();
    private final List<Integer> cpuMaxFrequenciesMhz = new ArrayList();

    public static CpuInfoUtils getInstance() {
        return instance;
    }

    private CpuInfoUtils() {
    }

    public List<Integer> readMaxFrequencies() {
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.lock.acquire();
        try {
            if (!this.cpuMaxFrequenciesMhz.isEmpty()) {
                List<Integer> list = this.cpuMaxFrequenciesMhz;
                if (iSentryLifecycleTokenAcquire != null) {
                    iSentryLifecycleTokenAcquire.close();
                }
                return list;
            }
            File[] fileArrListFiles = new File(getSystemCpuPath()).listFiles();
            if (fileArrListFiles == null) {
                ArrayList arrayList = new ArrayList();
                if (iSentryLifecycleTokenAcquire != null) {
                    iSentryLifecycleTokenAcquire.close();
                }
                return arrayList;
            }
            for (File file : fileArrListFiles) {
                if (file.getName().matches("cpu[0-9]+")) {
                    File file2 = new File(file, CPUINFO_MAX_FREQ_PATH);
                    if (file2.exists() && file2.canRead()) {
                        try {
                            String text = FileUtils.readText(file2);
                            if (text != null) {
                                this.cpuMaxFrequenciesMhz.add(Integer.valueOf((int) (Long.parseLong(text.trim()) / 1000)));
                            }
                        } catch (IOException | NumberFormatException unused) {
                        }
                    }
                }
            }
            List<Integer> list2 = this.cpuMaxFrequenciesMhz;
            if (iSentryLifecycleTokenAcquire != null) {
                iSentryLifecycleTokenAcquire.close();
            }
            return list2;
        } catch (Throwable th) {
            if (iSentryLifecycleTokenAcquire != null) {
                try {
                    iSentryLifecycleTokenAcquire.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    String getSystemCpuPath() {
        return SYSTEM_CPU_PATH;
    }

    public void setCpuMaxFrequencies(List<Integer> list) {
        this.cpuMaxFrequenciesMhz.clear();
        this.cpuMaxFrequenciesMhz.addAll(list);
    }

    final void clear() {
        this.cpuMaxFrequenciesMhz.clear();
    }
}
