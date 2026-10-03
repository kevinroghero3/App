package com.facebook.soloader;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Process;
import android.os.StrictMode;
import android.os.SystemClock;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.facebook.soloader.nativeloader.NativeLoader;
import com.facebook.soloader.nativeloader.SystemDelegate;
import com.facebook.soloader.observer.ObserverHolder;
import com.facebook.soloader.recovery.DefaultRecoveryStrategyFactory;
import com.facebook.soloader.recovery.RecoveryStrategy;
import com.facebook.soloader.recovery.RecoveryStrategyFactory;
import com.google.common.base.Ascii;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.zip.ZipFile;
import javax.annotation.Nullable;
import o.ArtificialStackFrames;
import o.asBinder;
import o.asInterface;
import o.coroutineBoundary;
import o.onRelationshipValidationResult;

/* JADX INFO: loaded from: classes.dex */
public class SoLoader {
    static final boolean DEBUG = false;
    public static final int SOLOADER_ALLOW_ASYNC_INIT = 2;
    public static final int SOLOADER_DISABLE_BACKUP_SOSOURCE = 8;
    public static final int SOLOADER_DISABLE_FS_SYNC_JOB = 256;

    @Deprecated
    public static final int SOLOADER_DONT_TREAT_AS_SYSTEMAPP = 32;
    public static final int SOLOADER_ENABLE_BACKUP_SOSOURCE_DSONOTFOUND_ERROR_RECOVERY = 2048;
    public static final int SOLOADER_ENABLE_BASE_APK_SPLIT_SOURCE = 1024;

    @Deprecated
    public static final int SOLOADER_ENABLE_DIRECT_SOSOURCE = 64;
    public static final int SOLOADER_ENABLE_EXOPACKAGE = 1;
    public static final int SOLOADER_ENABLE_SYSTEMLOAD_WRAPPER_SOSOURCE = 512;
    public static final int SOLOADER_EXPLICITLY_ENABLE_BACKUP_SOSOURCE = 128;
    public static final int SOLOADER_IMPLICIT_DEPENDENCIES_TEST = 4096;
    public static final int SOLOADER_LOOK_IN_ZIP = 4;
    public static final int SOLOADER_SKIP_MERGED_JNI_ONLOAD = 16;
    public static final String SO_STORE_NAME_MAIN = "lib-main";
    static final boolean SYSTRACE_LIBRARY_LOADING;
    public static final String TAG = "SoLoader";
    public static final String VERSION = "0.12.1";

    @Nullable
    private static ExternalSoMapping externalSoMapping;
    private static long extraCommand;
    private static boolean isEnabled;
    private static long notify;
    private static long onPostMessage;
    private static int sAppType;

    @Nullable
    static Context sApplicationContext;
    private static int sFlags;
    private static final Map<String, Object> sInvokingJniForLibrary;
    private static final Set<String> sLoadedAndJniInvoked;
    private static final Set<String> sLoadedLibraries;
    private static final Map<String, Object> sLoadingLibraries;

    @Nullable
    private static RecoveryStrategyFactory sRecoveryStrategyFactory;

    @Nullable
    static SoFileLoader sSoFileLoader;

    @Nullable
    private static volatile SoSource[] sSoSources;
    private static final ReentrantReadWriteLock sSoSourcesLock;
    private static final AtomicInteger sSoSourcesVersion;

    @Nullable
    private static SystemLoadLibraryWrapper sSystemLoadLibraryWrapper;
    private static final byte[] cancelAll = {72, -88, 5, 32, 44, -45, 46, 4, -9, -3, -5, 10, Ascii.CAN, -29, 7, -16, 17, -17, -7};
    private static final int INotificationSideChannel = 56;

    interface AppType {
        public static final int SYSTEM_APP = 2;
        public static final int THIRD_PARTY_APP = 1;
        public static final int UNSET = 0;
        public static final int UPDATED_SYSTEM_APP = 3;
    }

    private static int makeRecoveryFlags(int i) {
        return (i & 2048) != 0 ? 1 : 0;
    }

    private static void c(int i, char[] cArr, Object[] objArr) {
        onRelationshipValidationResult onrelationshipvalidationresult = new onRelationshipValidationResult();
        char[] cArrAccessartificialFrame = onRelationshipValidationResult.accessartificialFrame(onPostMessage ^ 2573525503365829440L, cArr, i);
        onrelationshipvalidationresult.e = 4;
        while (onrelationshipvalidationresult.e < cArrAccessartificialFrame.length) {
            onrelationshipvalidationresult.d = onrelationshipvalidationresult.e - 4;
            cArrAccessartificialFrame[onrelationshipvalidationresult.e] = (char) (((long) (cArrAccessartificialFrame[onrelationshipvalidationresult.e] ^ cArrAccessartificialFrame[onrelationshipvalidationresult.e % 4])) ^ (((long) onrelationshipvalidationresult.d) * (onPostMessage ^ 2573525503365829440L)));
            onrelationshipvalidationresult.e++;
        }
        objArr[0] = new String(cArrAccessartificialFrame, 4, cArrAccessartificialFrame.length - 4);
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        asBinder asbinder = new asBinder();
        asbinder.c = i;
        int length = cArr.length;
        long[] jArr = new long[length];
        asbinder.d = 0;
        while (asbinder.d < cArr.length) {
            jArr[asbinder.d] = (((long) cArr[asbinder.d]) ^ (((long) asbinder.d) * ((long) asbinder.c))) ^ (extraCommand ^ (-2360974883025274865L));
            asbinder.d++;
        }
        char[] cArr2 = new char[length];
        asbinder.d = 0;
        while (asbinder.d < cArr.length) {
            cArr2[asbinder.d] = (char) jArr[asbinder.d];
            asbinder.d++;
        }
        objArr[0] = new String(cArr2);
    }

    private static InputStream ArtificialStackFrames(InputStream inputStream, int i, byte[] bArr, int i2, int i3) throws IOException {
        long j = notify;
        return new coroutineBoundary(inputStream, new int[]{((int) (j >>> 32)) ^ i3, i3 ^ ((int) j)}, bArr, i2, i2 <= 6, i);
    }

    static {
        extraCommand();
        accessartificialFrame();
        accessartificialFrame("a5b409");
        sSoSourcesLock = new ReentrantReadWriteLock();
        sApplicationContext = null;
        sSoSources = null;
        sSoSourcesVersion = new AtomicInteger(0);
        sRecoveryStrategyFactory = null;
        sLoadedLibraries = Collections.newSetFromMap(new ConcurrentHashMap());
        sLoadingLibraries = new HashMap();
        sLoadedAndJniInvoked = Collections.newSetFromMap(new ConcurrentHashMap());
        sInvokingJniForLibrary = new HashMap();
        sSystemLoadLibraryWrapper = null;
        isEnabled = true;
        sAppType = 0;
        externalSoMapping = null;
        SYSTRACE_LIBRARY_LOADING = true;
    }

    public static void init(Context context, int i) throws IOException {
        init(context, i, null);
    }

    public static void init(Context context, int i, @Nullable SoFileLoader soFileLoader) throws IOException {
        if (isInitialized()) {
            LogUtil.w(TAG, "SoLoader already initialized");
            return;
        }
        LogUtil.w(TAG, "Initializing SoLoader: " + i);
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
        try {
            boolean zInitEnableConfig = initEnableConfig(context);
            isEnabled = zInitEnableConfig;
            if (zInitEnableConfig) {
                int appType = getAppType(context);
                sAppType = appType;
                if ((i & 128) == 0 && SysUtil.isSupportedDirectLoad(context, appType)) {
                    i |= 8;
                }
                initSoLoader(context, soFileLoader, i);
                initSoSources(context, i);
                LogUtil.v(TAG, "Init SoLoader delegate");
                NativeLoader.initIfUninitialized(new NativeLoaderToSoLoaderDelegate());
            } else {
                initDummySoSource();
                LogUtil.v(TAG, "Init System Loader delegate");
                NativeLoader.initIfUninitialized(new SystemDelegate());
            }
            LogUtil.w(TAG, "SoLoader initialized: " + i);
        } finally {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskWrites);
        }
    }

    public static void init(Context context, boolean z) {
        try {
            init(context, z ? 1 : 0, null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void init(Context context, @Nullable ExternalSoMapping externalSoMapping2) throws IOException {
        synchronized (SoLoader.class) {
            externalSoMapping = externalSoMapping2;
        }
        init(context, 0);
    }

    private static boolean initEnableConfig(Context context) {
        String packageName;
        if (externalSoMapping != null) {
            return true;
        }
        Bundle bundle = null;
        try {
            packageName = context.getPackageName();
            try {
                bundle = context.getPackageManager().getApplicationInfo(packageName, 128).metaData;
            } catch (Exception e) {
                e = e;
                LogUtil.w(TAG, "Unexpected issue with package manager (" + packageName + ")", e);
            }
        } catch (Exception e2) {
            e = e2;
            packageName = null;
        }
        return bundle == null || bundle.getBoolean("com.facebook.soloader.enabled", true);
    }

    private static void initSoSources(@Nullable Context context, int i) throws IOException {
        ReentrantReadWriteLock.WriteLock writeLock;
        if (sSoSources != null) {
            return;
        }
        ReentrantReadWriteLock reentrantReadWriteLock = sSoSourcesLock;
        reentrantReadWriteLock.writeLock().lock();
        try {
            if (sSoSources == null) {
                sFlags = i;
                ArrayList arrayList = new ArrayList();
                boolean z = (i & 512) != 0;
                boolean z2 = (i & 1024) != 0;
                if (z) {
                    addSystemLoadWrapperSoSource(context, arrayList);
                } else if (z2) {
                    addSystemLibSoSource(arrayList);
                    arrayList.add(0, new DirectSplitSoSource("base"));
                } else {
                    addSystemLibSoSource(arrayList);
                    if (context != null) {
                        if ((i & 1) != 0) {
                            addApplicationSoSource(arrayList, getApplicationSoSourceFlags());
                            LogUtil.d(TAG, "Adding exo package source: lib-main");
                            arrayList.add(0, new ExoSoSource(context, SO_STORE_NAME_MAIN));
                        } else {
                            if (SysUtil.isSupportedDirectLoad(context, sAppType)) {
                                addDirectApkSoSource(context, arrayList);
                            }
                            addApplicationSoSource(arrayList, getApplicationSoSourceFlags());
                            addBackupSoSource(context, arrayList, (i & 4096) != 0);
                        }
                    }
                }
                SoSource[] soSourceArr = (SoSource[]) arrayList.toArray(new SoSource[arrayList.size()]);
                int iMakePrepareFlags = makePrepareFlags();
                int length = soSourceArr.length;
                while (true) {
                    int i2 = length - 1;
                    if (length <= 0) {
                        break;
                    }
                    LogUtil.i(TAG, "Preparing SO source: " + soSourceArr[i2]);
                    boolean z3 = SYSTRACE_LIBRARY_LOADING;
                    if (z3) {
                        Api18TraceUtils.beginTraceSection(TAG, "_", soSourceArr[i2].getClass().getSimpleName());
                    }
                    soSourceArr[i2].prepare(iMakePrepareFlags);
                    if (z3) {
                        Api18TraceUtils.endSection();
                    }
                    length = i2;
                }
                sSoSources = soSourceArr;
                sSoSourcesVersion.getAndIncrement();
                LogUtil.i(TAG, "init finish: " + sSoSources.length + " SO sources prepared");
                writeLock = sSoSourcesLock.writeLock();
            } else {
                writeLock = reentrantReadWriteLock.writeLock();
            }
            writeLock.unlock();
        } catch (Throwable th) {
            sSoSourcesLock.writeLock().unlock();
            throw th;
        }
    }

    private static void initDummySoSource() {
        if (sSoSources != null) {
            return;
        }
        sSoSourcesLock.writeLock().lock();
        try {
            if (sSoSources == null) {
                sSoSources = new SoSource[0];
            }
        } finally {
            sSoSourcesLock.writeLock().unlock();
        }
    }

    private static int getApplicationSoSourceFlags() {
        int i = sAppType;
        if (i == 1) {
            return 0;
        }
        if (i == 2 || i == 3) {
            return 1;
        }
        throw new RuntimeException("Unsupported app type, we should not reach here");
    }

    private static void addDirectApkSoSource(Context context, ArrayList<SoSource> arrayList) {
        DirectApkSoSource directApkSoSource = new DirectApkSoSource(context);
        LogUtil.d(TAG, "validating/adding directApk source: " + directApkSoSource.toString());
        if (directApkSoSource.isValid()) {
            arrayList.add(0, directApkSoSource);
        }
    }

    private static void addApplicationSoSource(ArrayList<SoSource> arrayList, int i) {
        ApplicationSoSource applicationSoSource = new ApplicationSoSource(sApplicationContext, i);
        LogUtil.d(TAG, "Adding application source: " + applicationSoSource.toString());
        arrayList.add(0, applicationSoSource);
    }

    private static void addBackupSoSource(Context context, ArrayList<SoSource> arrayList, boolean z) throws IOException {
        if ((sFlags & 8) != 0) {
            return;
        }
        arrayList.add(0, new BackupSoSource(context, SO_STORE_NAME_MAIN, !z));
    }

    private static void addSystemLibSoSource(ArrayList<SoSource> arrayList) {
        String str = SysUtil.is64Bit() ? "/system/lib64:/vendor/lib64" : "/system/lib:/vendor/lib";
        String str2 = System.getenv("LD_LIBRARY_PATH");
        if (str2 != null && !str2.equals("")) {
            str = str2 + ":" + str;
        }
        for (String str3 : new HashSet(Arrays.asList(str.split(":")))) {
            LogUtil.d(TAG, "adding system library source: " + str3);
            arrayList.add(new DirectorySoSource(new File(str3), 2));
        }
    }

    private static void addSystemLoadWrapperSoSource(Context context, ArrayList<SoSource> arrayList) {
        SystemLoadWrapperSoSource systemLoadWrapperSoSource = new SystemLoadWrapperSoSource();
        LogUtil.d(TAG, "adding systemLoadWrapper source: " + systemLoadWrapperSoSource);
        arrayList.add(0, systemLoadWrapperSoSource);
    }

    private static int makePrepareFlags() {
        sSoSourcesLock.writeLock().lock();
        try {
            int i = sFlags;
            int i2 = (i & 2) != 0 ? 1 : 0;
            if ((i & 256) != 0) {
                i2 |= 4;
            }
            if ((i & 128) == 0) {
                i2 |= 8;
            }
            return i2;
        } finally {
            sSoSourcesLock.writeLock().unlock();
        }
    }

    private static void initSoLoader(@Nullable Context context, @Nullable SoFileLoader soFileLoader, int i) {
        synchronized (SoLoader.class) {
            if (context != null) {
                try {
                    Context applicationContext = context.getApplicationContext();
                    if (applicationContext == null) {
                        LogUtil.w(TAG, "context.getApplicationContext returned null, holding reference to original context.ApplicationSoSource fallbacks to: " + context.getApplicationInfo().nativeLibraryDir);
                    } else {
                        context = applicationContext;
                    }
                    sApplicationContext = context;
                    sRecoveryStrategyFactory = new DefaultRecoveryStrategyFactory(context, makeRecoveryFlags(i));
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (soFileLoader != null || sSoFileLoader == null) {
                if (soFileLoader != null) {
                    sSoFileLoader = soFileLoader;
                } else {
                    sSoFileLoader = new InstrumentedSoFileLoader(new SoFileLoaderImpl());
                }
            }
        }
    }

    private static int getAppType(@Nullable Context context) {
        int i = sAppType;
        if (i != 0) {
            return i;
        }
        int i2 = 1;
        if (context == null) {
            LogUtil.d(TAG, "context is null, fallback to THIRD_PARTY_APP appType");
            return 1;
        }
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        int i3 = applicationInfo.flags;
        if ((i3 & 1) != 0) {
            i2 = (i3 & 128) != 0 ? 3 : 2;
        }
        LogUtil.d(TAG, "ApplicationInfo.flags is: " + applicationInfo.flags + " appType is: " + i2);
        return i2;
    }

    public static void setInTestMode() {
        TestOnlyUtils.setSoSources(new SoSource[]{new NoopSoSource()});
    }

    public static void deinitForTest() {
        TestOnlyUtils.setSoSources(null);
    }

    static class TestOnlyUtils {
        TestOnlyUtils() {
        }

        static void setSoSources(SoSource[] soSourceArr) {
            SoLoader.sSoSourcesLock.writeLock().lock();
            try {
                SoSource[] unused = SoLoader.sSoSources = soSourceArr;
                SoLoader.sSoSourcesVersion.getAndIncrement();
            } finally {
                SoLoader.sSoSourcesLock.writeLock().unlock();
            }
        }

        static void setSoFileLoader(SoFileLoader soFileLoader) {
            SoLoader.sSoFileLoader = soFileLoader;
        }

        static void resetStatus() {
            synchronized (SoLoader.class) {
                SoLoader.sLoadedLibraries.clear();
                SoLoader.sLoadedAndJniInvoked.clear();
                SoLoader.sLoadingLibraries.clear();
                SoLoader.sSoFileLoader = null;
                SoLoader.sApplicationContext = null;
                RecoveryStrategyFactory unused = SoLoader.sRecoveryStrategyFactory = null;
                ObserverHolder.resetObserversForTestsOnly();
            }
            setSoSources(null);
        }

        static void setContext(Context context) {
            SoLoader.sApplicationContext = context;
        }
    }

    public static void setSystemLoadLibraryWrapper(SystemLoadLibraryWrapper systemLoadLibraryWrapper) {
        sSystemLoadLibraryWrapper = systemLoadLibraryWrapper;
    }

    public static final class WrongAbiError extends UnsatisfiedLinkError {
        WrongAbiError(Throwable th, String str) {
            super("APK was built for a different platform. Supported ABIs: " + Arrays.toString(SysUtil.getSupportedAbis()) + " error: " + str);
            initCause(th);
        }
    }

    @Nullable
    public static String getLibraryPath(String str) throws IOException {
        sSoSourcesLock.readLock().lock();
        try {
            String libraryPath = null;
            if (sSoSources != null) {
                for (int i = 0; libraryPath == null && i < sSoSources.length; i++) {
                    libraryPath = sSoSources[i].getLibraryPath(str);
                }
            }
            return libraryPath;
        } finally {
            sSoSourcesLock.readLock().unlock();
        }
    }

    public static SoSource[] cloneSoSources() {
        sSoSourcesLock.readLock().lock();
        try {
            return sSoSources == null ? new SoSource[0] : (SoSource[]) sSoSources.clone();
        } finally {
            sSoSourcesLock.readLock().unlock();
        }
    }

    @Nullable
    public static String[] getLibraryDependencies(String str) throws IOException {
        sSoSourcesLock.readLock().lock();
        try {
            String[] libraryDependencies = null;
            if (sSoSources != null) {
                for (int i = 0; libraryDependencies == null && i < sSoSources.length; i++) {
                    libraryDependencies = sSoSources[i].getLibraryDependencies(str);
                }
            }
            return libraryDependencies;
        } finally {
            sSoSourcesLock.readLock().unlock();
        }
    }

    @Nullable
    public static File getSoFile(String str) {
        String strMapLibName;
        ExternalSoMapping externalSoMapping2 = externalSoMapping;
        if (externalSoMapping2 != null) {
            strMapLibName = externalSoMapping2.mapLibName(str);
        } else {
            strMapLibName = MergedSoMapping.mapLibName(str);
        }
        if (strMapLibName != null) {
            str = strMapLibName;
        }
        String strMapLibraryName = System.mapLibraryName(str);
        sSoSourcesLock.readLock().lock();
        try {
            if (sSoSources != null) {
                for (int i = 0; i < sSoSources.length; i++) {
                    try {
                        File soFileByName = sSoSources[i].getSoFileByName(strMapLibraryName);
                        if (soFileByName != null) {
                            sSoSourcesLock.readLock().unlock();
                            return soFileByName;
                        }
                    } catch (IOException unused) {
                    }
                }
            }
            sSoSourcesLock.readLock().unlock();
            return null;
        } catch (Throwable th) {
            sSoSourcesLock.readLock().unlock();
            throw th;
        }
    }

    public static boolean loadLibrary(String str) {
        return isEnabled ? loadLibrary(str, 0) : NativeLoader.loadLibrary(str);
    }

    public static boolean loadLibrary(String str, int i) throws UnsatisfiedLinkError {
        SystemLoadLibraryWrapper systemLoadLibraryWrapper;
        Boolean boolLoadLibraryOnNonAndroid = loadLibraryOnNonAndroid(str);
        if (boolLoadLibraryOnNonAndroid != null) {
            return boolLoadLibraryOnNonAndroid.booleanValue();
        }
        if (!isEnabled) {
            return NativeLoader.loadLibrary(str);
        }
        int i2 = sAppType;
        if ((i2 == 2 || i2 == 3) && (systemLoadLibraryWrapper = sSystemLoadLibraryWrapper) != null) {
            systemLoadLibraryWrapper.loadLibrary(str);
            return true;
        }
        return loadLibraryOnAndroid(str, i);
    }

    private static boolean loadLibraryOnAndroid(String str, int i) {
        String strMapLibName;
        ExternalSoMapping externalSoMapping2 = externalSoMapping;
        if (externalSoMapping2 != null) {
            strMapLibName = externalSoMapping2.mapLibName(str);
        } else {
            strMapLibName = MergedSoMapping.mapLibName(str);
        }
        String str2 = strMapLibName != null ? strMapLibName : str;
        ObserverHolder.onLoadLibraryStart(str, strMapLibName, i);
        try {
            boolean zLoadLibraryBySoName = loadLibraryBySoName(System.mapLibraryName(str2), str, strMapLibName, i, null);
            ObserverHolder.onLoadLibraryEnd(null, zLoadLibraryBySoName);
            return zLoadLibraryBySoName;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                ObserverHolder.onLoadLibraryEnd(th, false);
                throw th2;
            }
        }
    }

    @Nullable
    private static Boolean loadLibraryOnNonAndroid(String str) {
        boolean zContains;
        if (sSoSources != null) {
            return null;
        }
        ReentrantReadWriteLock reentrantReadWriteLock = sSoSourcesLock;
        reentrantReadWriteLock.readLock().lock();
        try {
            if (sSoSources == null) {
                if ("http://www.android.com/".equals(System.getProperty("java.vendor.url"))) {
                    assertInitialized();
                } else {
                    synchronized (SoLoader.class) {
                        zContains = sLoadedLibraries.contains(str);
                        if (!zContains) {
                            SystemLoadLibraryWrapper systemLoadLibraryWrapper = sSystemLoadLibraryWrapper;
                            if (systemLoadLibraryWrapper != null) {
                                systemLoadLibraryWrapper.loadLibrary(str);
                            } else {
                                CoroutineDebuggingKt(str);
                            }
                        }
                    }
                    reentrantReadWriteLock.readLock().unlock();
                    return Boolean.valueOf(!zContains);
                }
            }
            reentrantReadWriteLock.readLock().unlock();
            return null;
        } catch (Throwable th) {
            sSoSourcesLock.readLock().unlock();
            throw th;
        }
    }

    static void loadDependency(String str, int i, StrictMode.ThreadPolicy threadPolicy) {
        ObserverHolder.onLoadDependencyStart(str, i);
        try {
            ObserverHolder.onLoadDependencyEnd(null, loadLibraryBySoNameImpl(str, null, null, i | 1, threadPolicy));
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                ObserverHolder.onLoadDependencyEnd(th, false);
                throw th2;
            }
        }
    }

    private static boolean loadLibraryBySoName(String str, @Nullable String str2, @Nullable String str3, int i, @Nullable StrictMode.ThreadPolicy threadPolicy) {
        RecoveryStrategy recoveryStrategyRecover = null;
        while (true) {
            try {
                return loadLibraryBySoNameImpl(str, str2, str3, i, threadPolicy);
            } catch (UnsatisfiedLinkError e) {
                recoveryStrategyRecover = recover(str, e, recoveryStrategyRecover);
            }
        }
    }

    private static RecoveryStrategy recover(String str, UnsatisfiedLinkError unsatisfiedLinkError, @Nullable RecoveryStrategy recoveryStrategy) {
        LogUtil.w(TAG, "Running a recovery step for " + str + " due to " + unsatisfiedLinkError.toString());
        ReentrantReadWriteLock reentrantReadWriteLock = sSoSourcesLock;
        reentrantReadWriteLock.writeLock().lock();
        try {
            if (recoveryStrategy == null) {
                try {
                    recoveryStrategy = getRecoveryStrategy();
                    if (recoveryStrategy == null) {
                        LogUtil.w(TAG, "No recovery strategy");
                        throw unsatisfiedLinkError;
                    }
                } catch (NoBaseApkException e) {
                    LogUtil.e(TAG, "Base APK not found during recovery", e);
                    throw e;
                } catch (Exception e2) {
                    LogUtil.e(TAG, "Got an exception during recovery, will throw the initial error instead", e2);
                    throw unsatisfiedLinkError;
                }
            }
            if (recoverLocked(unsatisfiedLinkError, recoveryStrategy)) {
                sSoSourcesVersion.getAndIncrement();
                reentrantReadWriteLock.writeLock().unlock();
                return recoveryStrategy;
            }
            reentrantReadWriteLock.writeLock().unlock();
            LogUtil.w(TAG, "Failed to recover");
            throw unsatisfiedLinkError;
        } catch (Throwable th) {
            sSoSourcesLock.writeLock().unlock();
            throw th;
        }
    }

    private static boolean recoverLocked(UnsatisfiedLinkError unsatisfiedLinkError, RecoveryStrategy recoveryStrategy) {
        ObserverHolder.onRecoveryStart(recoveryStrategy);
        try {
            boolean zRecover = recoveryStrategy.recover(unsatisfiedLinkError, sSoSources);
            ObserverHolder.onRecoveryEnd(null);
            return zRecover;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                ObserverHolder.onRecoveryEnd(th);
                throw th2;
            }
        }
    }

    @Nullable
    private static RecoveryStrategy getRecoveryStrategy() {
        RecoveryStrategy recoveryStrategy;
        synchronized (SoLoader.class) {
            RecoveryStrategyFactory recoveryStrategyFactory = sRecoveryStrategyFactory;
            recoveryStrategy = recoveryStrategyFactory == null ? null : recoveryStrategyFactory.get();
        }
        return recoveryStrategy;
    }

    static void setRecoveryStrategyFactory(RecoveryStrategyFactory recoveryStrategyFactory) {
        synchronized (SoLoader.class) {
            sRecoveryStrategyFactory = recoveryStrategyFactory;
        }
    }

    private static boolean loadLibraryBySoNameImpl(String str, @Nullable String str2, @Nullable String str3, int i, @Nullable StrictMode.ThreadPolicy threadPolicy) {
        boolean z;
        Object obj;
        Object obj2;
        if (!TextUtils.isEmpty(str2) && sLoadedAndJniInvoked.contains(str2)) {
            return false;
        }
        Set<String> set = sLoadedLibraries;
        if (set.contains(str) && str3 == null) {
            return false;
        }
        synchronized (SoLoader.class) {
            if (!set.contains(str)) {
                z = false;
            } else {
                if (str3 == null) {
                    return false;
                }
                z = true;
            }
            Map<String, Object> map = sLoadingLibraries;
            if (map.containsKey(str)) {
                obj = map.get(str);
            } else {
                Object obj3 = new Object();
                map.put(str, obj3);
                obj = obj3;
            }
            Map<String, Object> map2 = sInvokingJniForLibrary;
            if (map2.containsKey(str2)) {
                obj2 = map2.get(str2);
            } else {
                Object obj4 = new Object();
                map2.put(str2, obj4);
                obj2 = obj4;
            }
            ReentrantReadWriteLock reentrantReadWriteLock = sSoSourcesLock;
            reentrantReadWriteLock.readLock().lock();
            try {
                synchronized (obj) {
                    if (!z) {
                        if (set.contains(str)) {
                            if (str3 == null) {
                                reentrantReadWriteLock.readLock().unlock();
                                return false;
                            }
                            z = true;
                        }
                        if (!z) {
                            try {
                                LogUtil.d(TAG, "About to load: " + str);
                                doLoadLibraryBySoName(str, str2, i, threadPolicy);
                                LogUtil.d(TAG, "Loaded: " + str);
                                set.add(str);
                            } catch (UnsatisfiedLinkError e) {
                                String message = e.getMessage();
                                if (message != null && message.contains("unexpected e_machine:")) {
                                    throw new WrongAbiError(e, message.substring(message.lastIndexOf("unexpected e_machine:")));
                                }
                                throw e;
                            }
                        }
                    }
                    synchronized (obj2) {
                        if ((i & 16) == 0 && str3 != null) {
                            if (TextUtils.isEmpty(str2) || !sLoadedAndJniInvoked.contains(str2)) {
                                boolean z2 = SYSTRACE_LIBRARY_LOADING;
                                if (z2 && externalSoMapping == null) {
                                    Api18TraceUtils.beginTraceSection("MergedSoMapping.invokeJniOnload[", str2, "]");
                                }
                                try {
                                    try {
                                        LogUtil.d(TAG, "About to invoke JNI_OnLoad for merged library " + str2 + ", which was merged into " + str);
                                        ExternalSoMapping externalSoMapping2 = externalSoMapping;
                                        if (externalSoMapping2 != null) {
                                            externalSoMapping2.invokeJniOnload(str2);
                                        } else {
                                            MergedSoMapping.invokeJniOnload(str2);
                                        }
                                        sLoadedAndJniInvoked.add(str2);
                                        if (z2 && externalSoMapping == null) {
                                            Api18TraceUtils.endSection();
                                        }
                                    } catch (UnsatisfiedLinkError e2) {
                                        throw new RuntimeException("Failed to call JNI_OnLoad from '" + str2 + "', which has been merged into '" + str + "'.  See comment for details.", e2);
                                    }
                                } catch (Throwable th) {
                                    if (SYSTRACE_LIBRARY_LOADING && externalSoMapping == null) {
                                        Api18TraceUtils.endSection();
                                    }
                                    throw th;
                                }
                            }
                        }
                    }
                    reentrantReadWriteLock.readLock().unlock();
                    return !z;
                }
            } catch (Throwable th2) {
                sSoSourcesLock.readLock().unlock();
                throw th2;
            }
        }
    }

    public static File unpackLibraryAndDependencies(String str) throws UnsatisfiedLinkError {
        assertInitialized();
        try {
            return unpackLibraryBySoName(System.mapLibraryName(str));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void doLoadLibraryBySoName(String str, @Nullable String str2, int i, @Nullable StrictMode.ThreadPolicy threadPolicy) throws UnsatisfiedLinkError {
        boolean z;
        ReentrantReadWriteLock reentrantReadWriteLock = sSoSourcesLock;
        reentrantReadWriteLock.readLock().lock();
        try {
            if (sSoSources == null) {
                LogUtil.e(TAG, "Could not load: " + str + " because SoLoader is not initialized");
                throw new UnsatisfiedLinkError("SoLoader not initialized, couldn't find DSO to load: " + str);
            }
            reentrantReadWriteLock.readLock().unlock();
            if (threadPolicy == null) {
                threadPolicy = StrictMode.allowThreadDiskReads();
                z = true;
            } else {
                z = false;
            }
            if (SYSTRACE_LIBRARY_LOADING) {
                if (str2 != null) {
                    Api18TraceUtils.beginTraceSection("SoLoader.loadLibrary[", str2, "]");
                }
                Api18TraceUtils.beginTraceSection("SoLoader.loadLibrary[", str, "]");
            }
            try {
                reentrantReadWriteLock.readLock().lock();
                try {
                    try {
                        for (SoSource soSource : sSoSources) {
                            if (loadLibraryFromSoSource(soSource, str, i, threadPolicy)) {
                                sSoSourcesLock.readLock().unlock();
                                if (SYSTRACE_LIBRARY_LOADING) {
                                    if (str2 != null) {
                                        Api18TraceUtils.endSection();
                                    }
                                    Api18TraceUtils.endSection();
                                }
                                if (z) {
                                    StrictMode.setThreadPolicy(threadPolicy);
                                    return;
                                }
                                return;
                            }
                        }
                        throw SoLoaderDSONotFoundError.create(str, sApplicationContext, sSoSources);
                    } catch (IOException e) {
                        SoLoaderULError soLoaderULError = new SoLoaderULError(str, e.toString());
                        soLoaderULError.initCause(e);
                        throw soLoaderULError;
                    }
                } catch (Throwable th) {
                    sSoSourcesLock.readLock().unlock();
                    throw th;
                }
            } catch (Throwable th2) {
                if (SYSTRACE_LIBRARY_LOADING) {
                    if (str2 != null) {
                        Api18TraceUtils.endSection();
                    }
                    Api18TraceUtils.endSection();
                }
                if (z) {
                    StrictMode.setThreadPolicy(threadPolicy);
                }
                throw th2;
            }
        } catch (Throwable th3) {
            sSoSourcesLock.readLock().unlock();
            throw th3;
        }
    }

    private static boolean loadLibraryFromSoSource(SoSource soSource, String str, int i, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        ObserverHolder.onSoSourceLoadLibraryStart(soSource);
        try {
            boolean z = soSource.loadLibrary(str, i, threadPolicy) != 0;
            ObserverHolder.onSoSourceLoadLibraryEnd(null);
            return z;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                ObserverHolder.onSoSourceLoadLibraryEnd(th);
                throw th2;
            }
        }
    }

    static File unpackLibraryBySoName(String str) throws IOException {
        sSoSourcesLock.readLock().lock();
        try {
            for (SoSource soSource : sSoSources) {
                File fileUnpackLibrary = soSource.unpackLibrary(str);
                if (fileUnpackLibrary != null) {
                    return fileUnpackLibrary;
                }
            }
            throw new FileNotFoundException(str);
        } finally {
            sSoSourcesLock.readLock().unlock();
        }
    }

    private static void assertInitialized() {
        if (!isInitialized()) {
            throw new IllegalStateException("SoLoader.init() not yet called");
        }
    }

    public static boolean isInitialized() {
        if (sSoSources != null) {
            return true;
        }
        sSoSourcesLock.readLock().lock();
        try {
            return sSoSources != null;
        } finally {
            sSoSourcesLock.readLock().unlock();
        }
    }

    public static int getSoSourcesVersion() {
        return sSoSourcesVersion.get();
    }

    public static void prependSoSource(SoSource soSource) throws IOException {
        sSoSourcesLock.writeLock().lock();
        try {
            assertInitialized();
            soSource.prepare(makePrepareFlags());
            SoSource[] soSourceArr = new SoSource[sSoSources.length + 1];
            soSourceArr[0] = soSource;
            System.arraycopy(sSoSources, 0, soSourceArr, 1, sSoSources.length);
            sSoSources = soSourceArr;
            sSoSourcesVersion.getAndIncrement();
            LogUtil.d(TAG, "Prepended to SO sources: " + soSource);
        } finally {
            sSoSourcesLock.writeLock().unlock();
        }
    }

    public static String makeLdLibraryPath() {
        sSoSourcesLock.readLock().lock();
        try {
            assertInitialized();
            ArrayList arrayList = new ArrayList();
            SoSource[] soSourceArr = sSoSources;
            if (soSourceArr != null) {
                for (SoSource soSource : soSourceArr) {
                    soSource.addToLdLibraryPath(arrayList);
                }
            }
            String strJoin = TextUtils.join(":", arrayList);
            LogUtil.d(TAG, "makeLdLibraryPath final path: " + strJoin);
            return strJoin;
        } finally {
            sSoSourcesLock.readLock().unlock();
        }
    }

    public static boolean areSoSourcesAbisSupported() {
        ReentrantReadWriteLock reentrantReadWriteLock = sSoSourcesLock;
        reentrantReadWriteLock.readLock().lock();
        try {
            if (sSoSources != null) {
                String[] supportedAbis = SysUtil.getSupportedAbis();
                for (SoSource soSource : sSoSources) {
                    for (String str : soSource.getSoSourceAbis()) {
                        boolean zEquals = false;
                        for (int i = 0; i < supportedAbis.length && !zEquals; i++) {
                            zEquals = str.equals(supportedAbis[i]);
                        }
                        if (!zEquals) {
                            LogUtil.e(TAG, "abi not supported: " + str);
                            reentrantReadWriteLock = sSoSourcesLock;
                        }
                    }
                }
                sSoSourcesLock.readLock().unlock();
                return true;
            }
            reentrantReadWriteLock.readLock().unlock();
            return false;
        } catch (Throwable th) {
            sSoSourcesLock.readLock().unlock();
            throw th;
        }
    }

    public static boolean useDepsFile(Context context, boolean z, boolean z2) {
        return NativeDeps.useDepsFile(context, z, z2);
    }

    public static int getLoadedLibrariesCount() {
        return sLoadedLibraries.size();
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0029  */
    /* JADX WARN: Code duplicated, block: B:8:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0029 -> B:11:0x0031). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0029
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void b(int r6, byte r7, byte r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 * 5
            int r8 = r8 + 4
            int r6 = r6 * 5
            int r6 = 102 - r6
            int r7 = r7 * 5
            int r0 = r7 + 6
            byte[] r1 = com.facebook.soloader.SoLoader.cancelAll
            byte[] r0 = new byte[r0]
            int r7 = r7 + 5
            r2 = 0
            if (r1 != 0) goto L18
            r3 = r8
            r4 = r2
            goto L31
        L18:
            r3 = r2
            r5 = r8
            r8 = r6
            r6 = r5
        L1c:
            byte r4 = (byte) r8
            r0[r3] = r4
            if (r3 != r7) goto L29
            java.lang.String r6 = new java.lang.String
            r6.<init>(r0, r2)
            r9[r2] = r6
            return
        L29:
            int r3 = r3 + 1
            r4 = r1[r6]
            r5 = r3
            r3 = r6
            r6 = r4
            r4 = r5
        L31:
            int r6 = -r6
            int r8 = r8 + r6
            int r6 = r3 + 1
            r3 = r4
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.SoLoader.b(int, byte, byte, java.lang.Object[]):void");
    }

    static void extraCommand() {
        extraCommand = 2612099734891809305L;
        onPostMessage = 2790016728971802670L;
    }

    static void accessartificialFrame() {
        notify = -4459241781360305715L;
    }

    /* JADX WARN: Code duplicated, block: B:131:0x03fc A[Catch: Exception -> 0x08c5, TRY_ENTER, TRY_LEAVE, TryCatch #69 {Exception -> 0x08c5, blocks: (B:79:0x0257, B:145:0x0476, B:212:0x05f1, B:217:0x060a, B:218:0x0611, B:223:0x061c, B:236:0x0664, B:287:0x07a8, B:288:0x07ae, B:131:0x03fc, B:144:0x0469), top: B:589:0x0257 }] */
    /* JADX WARN: Code duplicated, block: B:148:0x0486  */
    /* JADX WARN: Code duplicated, block: B:155:0x04c7 A[Catch: Exception -> 0x01e2, TRY_ENTER, TRY_LEAVE, TryCatch #16 {Exception -> 0x01e2, blocks: (B:52:0x01d0, B:54:0x01d6, B:55:0x01d7, B:84:0x0298, B:88:0x0327, B:92:0x0393, B:155:0x04c7, B:171:0x0522, B:175:0x0533, B:180:0x0571, B:182:0x0577, B:183:0x0578, B:185:0x057a, B:187:0x0581, B:188:0x0582, B:190:0x058e, B:191:0x0594, B:206:0x05e6, B:208:0x05e8, B:210:0x05ef, B:211:0x05f0, B:221:0x0618, B:258:0x06f1, B:263:0x0722, B:268:0x075e, B:270:0x0764, B:271:0x0765, B:273:0x0767, B:275:0x076e, B:276:0x076f, B:278:0x0771, B:280:0x0778, B:281:0x0779, B:94:0x039e, B:96:0x03a5, B:97:0x03a6, B:99:0x03a8, B:101:0x03af, B:102:0x03b0, B:104:0x03b2, B:106:0x03b9, B:107:0x03ba, B:109:0x03bc, B:111:0x03c3, B:112:0x03c4, B:114:0x03c6, B:116:0x03cd, B:117:0x03ce, B:122:0x03ea, B:124:0x03f0, B:125:0x03f1, B:127:0x03f3, B:129:0x03fa, B:130:0x03fb, B:57:0x01d9, B:59:0x01e0, B:60:0x01e1, B:90:0x035f, B:89:0x032e, B:87:0x0300, B:85:0x02cd, B:48:0x019f, B:45:0x0190, B:194:0x05cd, B:196:0x05d3, B:197:0x05d8, B:199:0x05da, B:201:0x05e1, B:202:0x05e2, B:189:0x0583, B:118:0x03cf, B:82:0x0267, B:91:0x0378), top: B:495:0x0298, inners: #3, #7, #14, #20, #26, #30, #39, #44, #46, #51, #71 }] */
    /* JADX WARN: Code duplicated, block: B:212:0x05f1 A[Catch: Exception -> 0x08c5, TRY_ENTER, TRY_LEAVE, TryCatch #69 {Exception -> 0x08c5, blocks: (B:79:0x0257, B:145:0x0476, B:212:0x05f1, B:217:0x060a, B:218:0x0611, B:223:0x061c, B:236:0x0664, B:287:0x07a8, B:288:0x07ae, B:131:0x03fc, B:144:0x0469), top: B:589:0x0257 }] */
    /* JADX WARN: Code duplicated, block: B:220:0x0617  */
    /* JADX WARN: Code duplicated, block: B:328:0x0840 A[Catch: all -> 0x0842, TryCatch #18 {all -> 0x0842, blocks: (B:315:0x0826, B:316:0x082b, B:332:0x0844, B:326:0x0839, B:328:0x0840, B:329:0x0841), top: B:498:0x07ae }] */
    /* JADX WARN: Code duplicated, block: B:329:0x0841 A[Catch: all -> 0x0842, TryCatch #18 {all -> 0x0842, blocks: (B:315:0x0826, B:316:0x082b, B:332:0x0844, B:326:0x0839, B:328:0x0840, B:329:0x0841), top: B:498:0x07ae }] */
    /* JADX WARN: Code duplicated, block: B:36:0x0163  */
    /* JADX WARN: Code duplicated, block: B:37:0x0165  */
    /* JADX WARN: Code duplicated, block: B:466:0x07e7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:47:0x019d  */
    /* JADX WARN: Code duplicated, block: B:485:0x07af A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:495:0x0298 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:519:0x0190 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:521:0x0595 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:534:0x05cd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:547:0x03cf A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:551:0x01e7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:597:0x05d3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:598:0x0825 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:599:0x093a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:601:0x0930 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:603:0x061c A[EDGE_INSN: B:603:0x061c->B:223:0x061c BREAK  A[LOOP:1: B:218:0x0611->B:221:0x0618], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:81:0x0265  */
    /* JADX WARN: Instruction removed from duplicated block: B:131:0x03fc, please report this as an issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v108 */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r10v9, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v3, types: [java.lang.Object, java.lang.String[]] */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v10 */
    /* JADX WARN: Type inference failed for: r12v103, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v106 */
    /* JADX WARN: Type inference failed for: r12v107 */
    /* JADX WARN: Type inference failed for: r12v108 */
    /* JADX WARN: Type inference failed for: r12v109 */
    /* JADX WARN: Type inference failed for: r12v11 */
    /* JADX WARN: Type inference failed for: r12v110 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v44 */
    /* JADX WARN: Type inference failed for: r12v45 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v52 */
    /* JADX WARN: Type inference failed for: r12v58 */
    /* JADX WARN: Type inference failed for: r12v59 */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r12v60 */
    /* JADX WARN: Type inference failed for: r12v62, types: [char[]] */
    /* JADX WARN: Type inference failed for: r12v67, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r12v76 */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v101 */
    /* JADX WARN: Type inference failed for: r9v136 */
    /* JADX WARN: Type inference failed for: r9v137 */
    /* JADX WARN: Type inference failed for: r9v138 */
    /* JADX WARN: Type inference failed for: r9v139 */
    /* JADX WARN: Type inference failed for: r9v140 */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v18 */
    /* JADX WARN: Type inference failed for: r9v19 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v35 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v50, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r9v58 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v65 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v83 */
    /* JADX WARN: Type inference failed for: r9v84 */
    /* JADX WARN: Type inference failed for: r9v88 */
    /* JADX WARN: Type inference failed for: r9v90 */
    /* JADX WARN: Type inference failed for: r9v94, types: [java.lang.reflect.AccessibleObject, java.lang.reflect.Method] */
    private static void CoroutineDebuggingKt(String str) throws Exception {
        Exception exc;
        ?? r12;
        ?? r9;
        boolean z;
        ?? r10;
        String str2;
        Object objNewInstance;
        BufferedInputStream bufferedInputStream;
        URL resource;
        InputStream inputStream;
        Throwable th;
        Object objAccessartificialFrame;
        BufferedOutputStream bufferedOutputStream;
        byte[] bArr;
        int i;
        Object objInvoke;
        Object objInvoke2;
        ClassLoader classLoader;
        Throwable th2;
        Throwable cause;
        String str3;
        Object objInvoke3;
        ClassLoader classLoader2;
        String str4;
        Object[] objArr;
        ?? r13;
        String str5 = str;
        ?? r2 = 0;
        Object[] objArr2 = new Object[1];
        c(Color.rgb(0, 0, 0) + 16777216, new char[]{23432, 23547, 50523, 28626, 28224, 5363, 63044, 14700, 14100, 15761, 5834, 42662, 159}, objArr2);
        String str6 = (String) objArr2[0];
        ?? r6 = 10;
        Object[] objArr3 = new Object[1];
        a(24763 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), new char[]{62065, 37576, 13076, 53365, 28815, 4575, 46592, 22370, 63395, 38112}, objArr3);
        String str7 = (String) objArr3[0];
        ?? declaredMethod = 0;
        Object[] objArr4 = new Object[1];
        a(51908 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), new char[]{62019, 14465, 26582, 37490, 55586}, objArr4);
        try {
            String[] strArrCoroutineDebuggingKt = asInterface.CoroutineDebuggingKt(asInterface.ArtificialStackFrames((byte[]) String.class.getMethod("getBytes", String.class).invoke(str5, (String) objArr4[0])));
            if (strArrCoroutineDebuggingKt == null) {
                strArrCoroutineDebuggingKt = new String[0];
            }
            int length = strArrCoroutineDebuggingKt.length;
            ?? r11 = new String[length + 1];
            System.arraycopy(strArrCoroutineDebuggingKt, 0, r11, 0, length);
            r11[length] = str5;
            int i2 = 0;
            while (i2 <= length) {
                ?? r14 = r11[i2];
                try {
                    Object[] objArr5 = new Object[1];
                    a(TextUtils.lastIndexOf("", '0', r2 == true ? 1 : 0) + 24360, new char[]{62009, 44373, 19513, 61207, 36587, 10746, 51352, 26726, 2906, 43560, 17855, 58581, 34727, 9881, 50714, 24879, '\n', 41972, 17115, 64918, 40296, 15443, 57125, 32500, 6619, 47351, 23445, 64357, 39483, 13598, 54507, 30668}, objArr5);
                    try {
                        Object[] objArr6 = {(String) objArr5[r2 == true ? 1 : 0]};
                        Class[] clsArr = new Class[1];
                        clsArr[r2 == true ? 1 : 0] = String.class;
                        Object objNewInstance2 = File.class.getDeclaredConstructor(clsArr).newInstance(objArr6);
                        try {
                            try {
                                Object[] objArr7 = new Object[1];
                                a((ViewConfiguration.getKeyRepeatDelay() >> 16) + 48049, new char[]{62069, 18886, 34074, 49490, 7328, 22538, 37956, 54180}, objArr7);
                                if (((Boolean) File.class.getMethod((String) objArr7[r2 == true ? 1 : 0], null).invoke(objNewInstance2, null)).booleanValue()) {
                                    ClassLoader classLoader3 = SoLoader.class.getClassLoader();
                                    if (i2 >= length) {
                                        r10 = str5;
                                    } else {
                                        r10 = r14;
                                    }
                                    Object[] objArr8 = {r10};
                                    byte b = r2 == true ? (byte) 1 : (byte) 0;
                                    byte b2 = (byte) (b + 1);
                                    Object[] objArr9 = new Object[1];
                                    b(b, b2, b2, objArr9);
                                    r2 = 0;
                                    Method declaredMethod2 = ClassLoader.class.getDeclaredMethod((String) objArr9[0], String.class);
                                    declaredMethod2.setAccessible(true);
                                    str2 = (String) declaredMethod2.invoke(classLoader3, objArr8);
                                    if (str2 == null) {
                                        Object objInvoke4 = Runtime.class.getMethod(str7, null).invoke(null, null);
                                        r13 = r14;
                                        if (i2 >= length) {
                                            r13 = str;
                                        }
                                        Object[] objArr10 = {r13};
                                        Object[] objArr11 = new Object[1];
                                        a(30631 - TextUtils.indexOf("", ""), new char[]{62074, 34270, 7481, 38023, 11462, 42044, 16286, 47093, 20303, 50875, 24297}, objArr11);
                                        Runtime.class.getMethod((String) objArr11[0], String.class).invoke(objInvoke4, objArr10);
                                        return;
                                    }
                                    Object[] objArr12 = new Object[1];
                                    objArr12[0] = 47;
                                    Object[] objArr13 = new Object[1];
                                    c(1 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), new char[]{36468, 36376, 56618, 30250, 30245, 55466, 9093, 8325, 12141, 9333, 55956, 27379, 54652, 28852, 37551}, objArr13);
                                    Object[] objArr14 = new Object[1];
                                    objArr14[0] = Integer.valueOf(((Integer) String.class.getMethod((String) objArr13[0], Integer.TYPE).invoke(str2, objArr12)).intValue() + 1);
                                    Object[] objArr15 = {objNewInstance2, String.class.getMethod(str6, Integer.TYPE).invoke(str2, objArr14)};
                                    Class[] clsArr2 = new Class[2];
                                    clsArr2[0] = File.class;
                                    clsArr2[1] = String.class;
                                    objNewInstance = File.class.getDeclaredConstructor(clsArr2).newInstance(objArr15);
                                    resource = SoLoader.class.getClassLoader().getResource(str2);
                                    if (resource == null) {
                                        objArr = new Object[1];
                                        c(View.MeasureSpec.getSize(0), new char[]{38087, 38052, 2779, 27401, 41434, 37401, 14622, 15803, 63637, 14657, 36903, 8278}, objArr);
                                        if (((Boolean) String.class.getMethod((String) objArr[0], CharSequence.class).invoke(str2, "!")).booleanValue()) {
                                            StringBuilder sb = new StringBuilder();
                                            Object[] objArr16 = new Object[1];
                                            a(41737 - (Process.myPid() >> 22), new char[]{62076, 20862, 46198, 6967, 32340, 56658, 8268, 34636, 60004}, objArr16);
                                            sb.append((String) objArr16[0]);
                                            sb.append(str2);
                                            String path = new URL(sb.toString()).getPath();
                                            Object[] objArr17 = new Object[1];
                                            c(MotionEvent.axisFromString("") + 1, new char[]{36468, 36376, 56618, 30250, 30245, 55466, 9093, 8325, 12141, 9333, 55956, 27379, 54652, 28852, 37551}, objArr17);
                                            ZipFile zipFile = new ZipFile((String) String.class.getMethod(str6, Integer.TYPE, Integer.TYPE).invoke(path, 5, Integer.valueOf(((Integer) String.class.getMethod((String) objArr17[0], String.class).invoke(path, "!/")).intValue())));
                                            Object[] objArr18 = new Object[1];
                                            c(ViewConfiguration.getScrollBarFadeDuration() >> 16, new char[]{36468, 36376, 56618, 30250, 30245, 55466, 9093, 8325, 12141, 9333, 55956, 27379, 54652, 28852, 37551}, objArr18);
                                            inputStream = zipFile.getInputStream(zipFile.getEntry((String) String.class.getMethod(str6, Integer.TYPE).invoke(String.class.getMethod(str6, Integer.TYPE).invoke(str2, Integer.valueOf(((Integer) String.class.getMethod((String) objArr18[0], String.class).invoke(str2, "!/")).intValue())), 2)));
                                        } else {
                                            inputStream = (InputStream) FileInputStream.class.getDeclaredConstructor(String.class).newInstance(str2);
                                        }
                                    } else {
                                        String path2 = resource.getPath();
                                        Object[] objArr19 = {"!/" + str2};
                                        Object[] objArr20 = new Object[1];
                                        c(Color.blue(0), new char[]{36468, 36376, 56618, 30250, 30245, 55466, 9093, 8325, 12141, 9333, 55956, 27379, 54652, 28852, 37551}, objArr20);
                                        int iIntValue = ((Integer) String.class.getMethod((String) objArr20[0], String.class).invoke(path2, objArr19)).intValue();
                                        Object[] objArr21 = new Object[2];
                                        objArr21[1] = Integer.valueOf(iIntValue);
                                        objArr21[0] = 5;
                                        Class[] clsArr3 = new Class[2];
                                        clsArr3[0] = Integer.TYPE;
                                        clsArr3[1] = Integer.TYPE;
                                        ZipFile zipFile2 = new ZipFile((String) String.class.getMethod(str6, clsArr3).invoke(path2, objArr21));
                                        inputStream = zipFile2.getInputStream(zipFile2.getEntry(str2));
                                    }
                                    bufferedInputStream = new BufferedInputStream(inputStream);
                                    Object[] objArr22 = {bufferedInputStream};
                                    objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-175194354);
                                    if (objAccessartificialFrame == null) {
                                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(Color.rgb(0, 0, 0) + 16777241, (char) Drawable.resolveOpacity(0, 0), (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 49, 1793849606, false, "CoroutineDebuggingKt", new Class[]{InputStream.class});
                                    }
                                    declaredMethod = (InputStream) ((Method) objAccessartificialFrame).invoke(null, objArr22);
                                    if (bufferedInputStream == declaredMethod) {
                                        declaredMethod.close();
                                        Object objInvoke5 = Runtime.class.getMethod(str7, null).invoke(null, null);
                                        Object[] objArr23 = {str2, SoLoader.class.getClassLoader()};
                                        Object[] objArr24 = new Object[1];
                                        a(18713 - View.getDefaultSize(0, 0), new char[]{62074, 47968, 24645, 10553}, objArr24);
                                        Method declaredMethod3 = Runtime.class.getDeclaredMethod((String) objArr24[0], String.class, ClassLoader.class);
                                        declaredMethod3.setAccessible(true);
                                        declaredMethod3.invoke(objInvoke5, objArr23);
                                        r9 = 0;
                                        r12 = 10;
                                    } else {
                                        Object[] objArr25 = {objNewInstance};
                                        Class[] clsArr4 = new Class[1];
                                        clsArr4[0] = File.class;
                                        OutputStream outputStream = (OutputStream) FileOutputStream.class.getDeclaredConstructor(clsArr4).newInstance(objArr25);
                                        bufferedOutputStream = new BufferedOutputStream(outputStream);
                                        bArr = new byte[1024];
                                        while (true) {
                                            i = declaredMethod.read(bArr);
                                            if (i >= 0) {
                                                break;
                                                break;
                                            }
                                            bufferedOutputStream.write(bArr, 0, i);
                                        }
                                        bufferedOutputStream.flush();
                                        Object[] objArr26 = new Object[1];
                                        c(ViewConfiguration.getEdgeSlop() >> 16, new char[]{8559, 8456, 65229, 16077, 21958, 7036, 35987, 26725, 6512}, objArr26);
                                        Object objInvoke6 = FileOutputStream.class.getMethod((String) objArr26[0], null).invoke(outputStream, null);
                                        Object[] objArr27 = new Object[1];
                                        a(23957 - TextUtils.getCapsMode("", 0, 0), new char[]{62053, 45050, 18770, 60106}, objArr27);
                                        r14 = 0;
                                        r14 = 0;
                                        r14 = 0;
                                        FileDescriptor.class.getMethod((String) objArr27[0], null).invoke(objInvoke6, null);
                                        bufferedOutputStream.close();
                                        declaredMethod.close();
                                        Object objInvoke7 = Runtime.class.getMethod(str7, null).invoke(null, null);
                                        r14 = new char[]{24335, 24424, 18049, 65252, 60810, 7844, 62165, 43084, 46303, 44215, 7343, 44225, 1034, 60192, 6757, 16709, 22086, 22888, 51232};
                                        Object[] objArr28 = new Object[1];
                                        c(View.combineMeasuredStates(0, 0), r14, objArr28);
                                        declaredMethod = 0;
                                        declaredMethod = 0;
                                        declaredMethod = 0;
                                        Object[] objArr29 = {File.class.getMethod((String) objArr28[0], null).invoke(objNewInstance, null), SoLoader.class.getClassLoader()};
                                        Object[] objArr30 = new Object[1];
                                        a((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 18712, new char[]{62074, 47968, 24645, 10553}, objArr30);
                                        r14 = (String) objArr30[0];
                                        declaredMethod = Runtime.class.getDeclaredMethod(r14, String.class, ClassLoader.class);
                                        declaredMethod.setAccessible(true);
                                        declaredMethod.invoke(objInvoke7, objArr29);
                                        r12 = 10;
                                        Object[] objArr31 = new Object[1];
                                        a(39499 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), new char[]{62066, 26680, 50924, 15506, 39758, 61700}, objArr31);
                                        r9 = 0;
                                        r9 = 0;
                                        ((Boolean) File.class.getMethod((String) objArr31[0], null).invoke(objNewInstance, null)).booleanValue();
                                    }
                                    exc = e;
                                    z = false;
                                    r12 = 10;
                                    r9 = z;
                                    if (i2 >= length) {
                                        throw exc;
                                    }
                                } else {
                                    try {
                                        Object[] objArr32 = new Object[1];
                                        a(56384 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), new char[]{62076, 11848, 18974, 26314, 33476, 48964, 56067, 63361, 5018, 19532, 26640, 33991, 41099, 56663}, objArr32);
                                        String str8 = (String) objArr32[r2 == true ? 1 : 0];
                                        try {
                                            Object[] objArr33 = {System.getProperty(str8, str8)};
                                            Class[] clsArr5 = new Class[1];
                                            clsArr5[r2 == true ? 1 : 0] = String.class;
                                            objNewInstance2 = File.class.getDeclaredConstructor(clsArr5).newInstance(objArr33);
                                            try {
                                                Object[] objArr34 = new Object[1];
                                                a(View.MeasureSpec.makeMeasureSpec(r2 == true ? 1 : 0, r2 == true ? 1 : 0) + 48049, new char[]{62069, 18886, 34074, 49490, 7328, 22538, 37956, 54180}, objArr34);
                                                if (!((Boolean) File.class.getMethod((String) objArr34[r2 == true ? 1 : 0], null).invoke(objNewInstance2, null)).booleanValue()) {
                                                    objNewInstance2 = Environment.getExternalStorageDirectory();
                                                }
                                                try {
                                                    ClassLoader classLoader4 = SoLoader.class.getClassLoader();
                                                    if (i2 >= length) {
                                                        r10 = str5;
                                                    } else {
                                                        r10 = r14;
                                                    }
                                                    try {
                                                        Object[] objArr35 = {r10};
                                                        byte b3 = r2 == true ? (byte) 1 : (byte) 0;
                                                        byte b4 = (byte) (b3 + 1);
                                                        try {
                                                            Object[] objArr36 = new Object[1];
                                                            b(b3, b4, b4, objArr36);
                                                            r2 = 0;
                                                            Method declaredMethod4 = ClassLoader.class.getDeclaredMethod((String) objArr36[0], String.class);
                                                            declaredMethod4.setAccessible(true);
                                                            str2 = (String) declaredMethod4.invoke(classLoader4, objArr35);
                                                            if (str2 == null) {
                                                                try {
                                                                    Object objInvoke8 = Runtime.class.getMethod(str7, null).invoke(null, null);
                                                                    r13 = r14;
                                                                    if (i2 >= length) {
                                                                        r13 = str;
                                                                    }
                                                                    try {
                                                                        Object[] objArr110 = {r13};
                                                                        Object[] objArr111 = new Object[1];
                                                                        a(30631 - TextUtils.indexOf("", ""), new char[]{62074, 34270, 7481, 38023, 11462, 42044, 16286, 47093, 20303, 50875, 24297}, objArr111);
                                                                        Runtime.class.getMethod((String) objArr111[0], String.class).invoke(objInvoke8, objArr110);
                                                                        return;
                                                                    } catch (Throwable th3) {
                                                                        Throwable cause2 = th3.getCause();
                                                                        if (cause2 == null) {
                                                                            throw th3;
                                                                        }
                                                                        throw cause2;
                                                                    }
                                                                } catch (Throwable th4) {
                                                                    Throwable cause3 = th4.getCause();
                                                                    if (cause3 == null) {
                                                                        throw th4;
                                                                    }
                                                                    throw cause3;
                                                                }
                                                            }
                                                            try {
                                                                Object[] objArr112 = new Object[1];
                                                                try {
                                                                    objArr112[0] = 47;
                                                                    Object[] objArr113 = new Object[1];
                                                                    c(1 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), new char[]{36468, 36376, 56618, 30250, 30245, 55466, 9093, 8325, 12141, 9333, 55956, 27379, 54652, 28852, 37551}, objArr113);
                                                                    try {
                                                                        Object[] objArr114 = new Object[1];
                                                                        try {
                                                                            objArr114[0] = Integer.valueOf(((Integer) String.class.getMethod((String) objArr113[0], Integer.TYPE).invoke(str2, objArr112)).intValue() + 1);
                                                                            try {
                                                                                Object[] objArr115 = {objNewInstance2, String.class.getMethod(str6, Integer.TYPE).invoke(str2, objArr114)};
                                                                                Class[] clsArr6 = new Class[2];
                                                                                try {
                                                                                    clsArr6[0] = File.class;
                                                                                    clsArr6[1] = String.class;
                                                                                    objNewInstance = File.class.getDeclaredConstructor(clsArr6).newInstance(objArr115);
                                                                                    try {
                                                                                        resource = SoLoader.class.getClassLoader().getResource(str2);
                                                                                        if (resource == null) {
                                                                                            try {
                                                                                                objArr = new Object[1];
                                                                                                c(View.MeasureSpec.getSize(0), new char[]{38087, 38052, 2779, 27401, 41434, 37401, 14622, 15803, 63637, 14657, 36903, 8278}, objArr);
                                                                                                if (((Boolean) String.class.getMethod((String) objArr[0], CharSequence.class).invoke(str2, "!")).booleanValue()) {
                                                                                                    try {
                                                                                                        StringBuilder sb2 = new StringBuilder();
                                                                                                        Object[] objArr116 = new Object[1];
                                                                                                        a(41737 - (Process.myPid() >> 22), new char[]{62076, 20862, 46198, 6967, 32340, 56658, 8268, 34636, 60004}, objArr116);
                                                                                                        sb2.append((String) objArr116[0]);
                                                                                                        sb2.append(str2);
                                                                                                        String path3 = new URL(sb2.toString()).getPath();
                                                                                                        try {
                                                                                                            Object[] objArr117 = new Object[1];
                                                                                                            c(MotionEvent.axisFromString("") + 1, new char[]{36468, 36376, 56618, 30250, 30245, 55466, 9093, 8325, 12141, 9333, 55956, 27379, 54652, 28852, 37551}, objArr117);
                                                                                                            try {
                                                                                                                ZipFile zipFile3 = new ZipFile((String) String.class.getMethod(str6, Integer.TYPE, Integer.TYPE).invoke(path3, 5, Integer.valueOf(((Integer) String.class.getMethod((String) objArr117[0], String.class).invoke(path3, "!/")).intValue())));
                                                                                                                try {
                                                                                                                    Object[] objArr118 = new Object[1];
                                                                                                                    c(ViewConfiguration.getScrollBarFadeDuration() >> 16, new char[]{36468, 36376, 56618, 30250, 30245, 55466, 9093, 8325, 12141, 9333, 55956, 27379, 54652, 28852, 37551}, objArr118);
                                                                                                                    try {
                                                                                                                        try {
                                                                                                                            inputStream = zipFile3.getInputStream(zipFile3.getEntry((String) String.class.getMethod(str6, Integer.TYPE).invoke(String.class.getMethod(str6, Integer.TYPE).invoke(str2, Integer.valueOf(((Integer) String.class.getMethod((String) objArr118[0], String.class).invoke(str2, "!/")).intValue())), 2)));
                                                                                                                        } catch (Throwable th5) {
                                                                                                                            Throwable cause4 = th5.getCause();
                                                                                                                            if (cause4 == null) {
                                                                                                                                throw th5;
                                                                                                                            }
                                                                                                                            throw cause4;
                                                                                                                        }
                                                                                                                    } catch (Throwable th6) {
                                                                                                                        Throwable cause5 = th6.getCause();
                                                                                                                        if (cause5 == null) {
                                                                                                                            throw th6;
                                                                                                                        }
                                                                                                                        throw cause5;
                                                                                                                    }
                                                                                                                } catch (Throwable th7) {
                                                                                                                    Throwable cause6 = th7.getCause();
                                                                                                                    if (cause6 == null) {
                                                                                                                        throw th7;
                                                                                                                    }
                                                                                                                    throw cause6;
                                                                                                                }
                                                                                                            } catch (Throwable th8) {
                                                                                                                Throwable cause7 = th8.getCause();
                                                                                                                if (cause7 == null) {
                                                                                                                    throw th8;
                                                                                                                }
                                                                                                                throw cause7;
                                                                                                            }
                                                                                                        } catch (Throwable th9) {
                                                                                                            Throwable cause8 = th9.getCause();
                                                                                                            if (cause8 == null) {
                                                                                                                throw th9;
                                                                                                            }
                                                                                                            throw cause8;
                                                                                                        }
                                                                                                    } catch (Exception e) {
                                                                                                        exc = e;
                                                                                                        z = false;
                                                                                                        r12 = 10;
                                                                                                        r9 = z;
                                                                                                        if (i2 >= length) {
                                                                                                            throw exc;
                                                                                                        }
                                                                                                    }
                                                                                                } else {
                                                                                                    try {
                                                                                                        inputStream = (InputStream) FileInputStream.class.getDeclaredConstructor(String.class).newInstance(str2);
                                                                                                    } catch (Throwable th10) {
                                                                                                        Throwable cause9 = th10.getCause();
                                                                                                        if (cause9 == null) {
                                                                                                            throw th10;
                                                                                                        }
                                                                                                        throw cause9;
                                                                                                    }
                                                                                                }
                                                                                            } catch (Throwable th11) {
                                                                                                Throwable cause10 = th11.getCause();
                                                                                                if (cause10 == null) {
                                                                                                    throw th11;
                                                                                                }
                                                                                                throw cause10;
                                                                                            }
                                                                                        } else {
                                                                                            String path4 = resource.getPath();
                                                                                            try {
                                                                                                Object[] objArr119 = {"!/" + str2};
                                                                                                try {
                                                                                                    Object[] objArr210 = new Object[1];
                                                                                                    c(Color.blue(0), new char[]{36468, 36376, 56618, 30250, 30245, 55466, 9093, 8325, 12141, 9333, 55956, 27379, 54652, 28852, 37551}, objArr210);
                                                                                                    try {
                                                                                                        int iIntValue2 = ((Integer) String.class.getMethod((String) objArr210[0], String.class).invoke(path4, objArr119)).intValue();
                                                                                                        try {
                                                                                                            Object[] objArr211 = new Object[2];
                                                                                                            objArr211[1] = Integer.valueOf(iIntValue2);
                                                                                                            try {
                                                                                                                objArr211[0] = 5;
                                                                                                                Class[] clsArr7 = new Class[2];
                                                                                                                clsArr7[0] = Integer.TYPE;
                                                                                                                clsArr7[1] = Integer.TYPE;
                                                                                                                ZipFile zipFile4 = new ZipFile((String) String.class.getMethod(str6, clsArr7).invoke(path4, objArr211));
                                                                                                                inputStream = zipFile4.getInputStream(zipFile4.getEntry(str2));
                                                                                                            } catch (Throwable th12) {
                                                                                                                th = th12;
                                                                                                                Throwable th13 = th;
                                                                                                                Throwable cause11 = th13.getCause();
                                                                                                                if (cause11 == null) {
                                                                                                                    throw th13;
                                                                                                                }
                                                                                                                throw cause11;
                                                                                                            }
                                                                                                        } catch (Throwable th14) {
                                                                                                            th = th14;
                                                                                                        }
                                                                                                    } catch (Throwable th15) {
                                                                                                        th = th15;
                                                                                                        Throwable th16 = th;
                                                                                                        Throwable cause12 = th16.getCause();
                                                                                                        if (cause12 == null) {
                                                                                                            throw th16;
                                                                                                        }
                                                                                                        throw cause12;
                                                                                                    }
                                                                                                } catch (Throwable th17) {
                                                                                                    th = th17;
                                                                                                }
                                                                                            } catch (Throwable th18) {
                                                                                                th = th18;
                                                                                            }
                                                                                        }
                                                                                        bufferedInputStream = new BufferedInputStream(inputStream);
                                                                                        try {
                                                                                            Object[] objArr212 = {bufferedInputStream};
                                                                                            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-175194354);
                                                                                            if (objAccessartificialFrame == null) {
                                                                                                try {
                                                                                                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(Color.rgb(0, 0, 0) + 16777241, (char) Drawable.resolveOpacity(0, 0), (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 49, 1793849606, false, "CoroutineDebuggingKt", new Class[]{InputStream.class});
                                                                                                } catch (Throwable th19) {
                                                                                                    th = th19;
                                                                                                    Throwable cause13 = th.getCause();
                                                                                                    if (cause13 == null) {
                                                                                                        throw th;
                                                                                                    }
                                                                                                    throw cause13;
                                                                                                }
                                                                                            }
                                                                                            declaredMethod = (InputStream) ((Method) objAccessartificialFrame).invoke(null, objArr212);
                                                                                            if (bufferedInputStream == declaredMethod) {
                                                                                                declaredMethod.close();
                                                                                                try {
                                                                                                    Object objInvoke9 = Runtime.class.getMethod(str7, null).invoke(null, null);
                                                                                                    try {
                                                                                                        try {
                                                                                                            try {
                                                                                                                Object[] objArr213 = {str2, SoLoader.class.getClassLoader()};
                                                                                                                Object[] objArr214 = new Object[1];
                                                                                                                a(18713 - View.getDefaultSize(0, 0), new char[]{62074, 47968, 24645, 10553}, objArr214);
                                                                                                                Method declaredMethod5 = Runtime.class.getDeclaredMethod((String) objArr214[0], String.class, ClassLoader.class);
                                                                                                                declaredMethod5.setAccessible(true);
                                                                                                                declaredMethod5.invoke(objInvoke9, objArr213);
                                                                                                            } catch (Throwable th20) {
                                                                                                                Throwable cause14 = th20.getCause();
                                                                                                                if (cause14 == null) {
                                                                                                                    throw th20;
                                                                                                                }
                                                                                                                throw cause14;
                                                                                                            }
                                                                                                        } catch (Exception unused) {
                                                                                                            if (Build.VERSION.SDK_INT <= 27) {
                                                                                                                try {
                                                                                                                    Object objInvoke10 = Runtime.class.getMethod(str7, null).invoke(null, null);
                                                                                                                    try {
                                                                                                                        Object[] objArr37 = {str2, SoLoader.class.getClassLoader()};
                                                                                                                        Object[] objArr38 = new Object[1];
                                                                                                                        a(28202 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), new char[]{62066, 40016, 11784, 47106, 19155, 54463}, objArr38);
                                                                                                                        Method declaredMethod6 = Runtime.class.getDeclaredMethod((String) objArr38[0], String.class, ClassLoader.class);
                                                                                                                        declaredMethod6.setAccessible(true);
                                                                                                                        declaredMethod6.invoke(objInvoke10, objArr37);
                                                                                                                    } catch (Throwable th21) {
                                                                                                                        Throwable cause15 = th21.getCause();
                                                                                                                        if (cause15 == null) {
                                                                                                                            throw th21;
                                                                                                                        }
                                                                                                                        throw cause15;
                                                                                                                    }
                                                                                                                } catch (Throwable th22) {
                                                                                                                    Throwable cause16 = th22.getCause();
                                                                                                                    if (cause16 == null) {
                                                                                                                        throw th22;
                                                                                                                    }
                                                                                                                    throw cause16;
                                                                                                                }
                                                                                                            } else {
                                                                                                                try {
                                                                                                                    objInvoke3 = Runtime.class.getMethod(str7, null).invoke(null, null);
                                                                                                                    classLoader2 = SoLoader.class.getClassLoader();
                                                                                                                    synchronized (objInvoke3) {
                                                                                                                        try {
                                                                                                                            Object[] objArr39 = {str2, classLoader2};
                                                                                                                            Object[] objArr40 = new Object[1];
                                                                                                                            a(8713 - Color.green(0), new char[]{62072, 53374, 46704, 37988, 31300, 22622, 15980, 7238, 57919, 49187}, objArr40);
                                                                                                                            Method declaredMethod7 = Runtime.class.getDeclaredMethod((String) objArr40[0], String.class, ClassLoader.class);
                                                                                                                            declaredMethod7.setAccessible(true);
                                                                                                                            str4 = (String) declaredMethod7.invoke(objInvoke3, objArr39);
                                                                                                                            if (str4 == null) {
                                                                                                                                throw new UnsatisfiedLinkError(str4);
                                                                                                                            }
                                                                                                                        } catch (Throwable th23) {
                                                                                                                            Throwable cause17 = th23.getCause();
                                                                                                                            if (cause17 == null) {
                                                                                                                                throw th23;
                                                                                                                            }
                                                                                                                            throw cause17;
                                                                                                                        }
                                                                                                                    }
                                                                                                                } catch (Throwable th24) {
                                                                                                                    Throwable cause18 = th24.getCause();
                                                                                                                    if (cause18 == null) {
                                                                                                                        throw th24;
                                                                                                                    }
                                                                                                                    throw cause18;
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    } catch (NoSuchMethodException unused2) {
                                                                                                        objInvoke3 = Runtime.class.getMethod(str7, null).invoke(null, null);
                                                                                                        classLoader2 = SoLoader.class.getClassLoader();
                                                                                                        synchronized (objInvoke3) {
                                                                                                            Object[] objArr310 = {str2, classLoader2};
                                                                                                            Object[] objArr41 = new Object[1];
                                                                                                            a(8713 - Color.green(0), new char[]{62072, 53374, 46704, 37988, 31300, 22622, 15980, 7238, 57919, 49187}, objArr41);
                                                                                                            Method declaredMethod8 = Runtime.class.getDeclaredMethod((String) objArr41[0], String.class, ClassLoader.class);
                                                                                                            declaredMethod8.setAccessible(true);
                                                                                                            str4 = (String) declaredMethod8.invoke(objInvoke3, objArr310);
                                                                                                            if (str4 == null) {
                                                                                                                throw new UnsatisfiedLinkError(str4);
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                    r9 = 0;
                                                                                                    r12 = 10;
                                                                                                } catch (Throwable th25) {
                                                                                                    Throwable cause19 = th25.getCause();
                                                                                                    if (cause19 == null) {
                                                                                                        throw th25;
                                                                                                    }
                                                                                                    throw cause19;
                                                                                                }
                                                                                            } else {
                                                                                                try {
                                                                                                    Object[] objArr215 = {objNewInstance};
                                                                                                    Class[] clsArr8 = new Class[1];
                                                                                                    try {
                                                                                                        clsArr8[0] = File.class;
                                                                                                        OutputStream outputStream2 = (OutputStream) FileOutputStream.class.getDeclaredConstructor(clsArr8).newInstance(objArr215);
                                                                                                        bufferedOutputStream = new BufferedOutputStream(outputStream2);
                                                                                                        bArr = new byte[1024];
                                                                                                        while (true) {
                                                                                                            i = declaredMethod.read(bArr);
                                                                                                            if (i >= 0) {
                                                                                                                break;
                                                                                                            } else {
                                                                                                                bufferedOutputStream.write(bArr, 0, i);
                                                                                                            }
                                                                                                        }
                                                                                                        bufferedOutputStream.flush();
                                                                                                        try {
                                                                                                            Object[] objArr216 = new Object[1];
                                                                                                            c(ViewConfiguration.getEdgeSlop() >> 16, new char[]{8559, 8456, 65229, 16077, 21958, 7036, 35987, 26725, 6512}, objArr216);
                                                                                                            try {
                                                                                                                Object objInvoke11 = FileOutputStream.class.getMethod((String) objArr216[0], null).invoke(outputStream2, null);
                                                                                                                try {
                                                                                                                    try {
                                                                                                                        Object[] objArr217 = new Object[1];
                                                                                                                        a(23957 - TextUtils.getCapsMode("", 0, 0), new char[]{62053, 45050, 18770, 60106}, objArr217);
                                                                                                                        try {
                                                                                                                            r14 = 0;
                                                                                                                            r14 = 0;
                                                                                                                            r14 = 0;
                                                                                                                            FileDescriptor.class.getMethod((String) objArr217[0], null).invoke(objInvoke11, null);
                                                                                                                            bufferedOutputStream.close();
                                                                                                                            declaredMethod.close();
                                                                                                                            try {
                                                                                                                                Object objInvoke12 = Runtime.class.getMethod(str7, null).invoke(null, null);
                                                                                                                                try {
                                                                                                                                    r14 = new char[]{24335, 24424, 18049, 65252, 60810, 7844, 62165, 43084, 46303, 44215, 7343, 44225, 1034, 60192, 6757, 16709, 22086, 22888, 51232};
                                                                                                                                    Object[] objArr218 = new Object[1];
                                                                                                                                    c(View.combineMeasuredStates(0, 0), r14, objArr218);
                                                                                                                                    declaredMethod = 0;
                                                                                                                                    declaredMethod = 0;
                                                                                                                                    declaredMethod = 0;
                                                                                                                                    try {
                                                                                                                                        try {
                                                                                                                                            try {
                                                                                                                                                try {
                                                                                                                                                    try {
                                                                                                                                                        Object[] objArr219 = {File.class.getMethod((String) objArr218[0], null).invoke(objNewInstance, null), SoLoader.class.getClassLoader()};
                                                                                                                                                        Object[] objArr311 = new Object[1];
                                                                                                                                                        a((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 18712, new char[]{62074, 47968, 24645, 10553}, objArr311);
                                                                                                                                                        r14 = (String) objArr311[0];
                                                                                                                                                        declaredMethod = Runtime.class.getDeclaredMethod(r14, String.class, ClassLoader.class);
                                                                                                                                                        declaredMethod.setAccessible(true);
                                                                                                                                                        declaredMethod.invoke(objInvoke12, objArr219);
                                                                                                                                                    } catch (Throwable th26) {
                                                                                                                                                        Throwable cause20 = th26.getCause();
                                                                                                                                                        if (cause20 == null) {
                                                                                                                                                            throw th26;
                                                                                                                                                        }
                                                                                                                                                        throw cause20;
                                                                                                                                                    }
                                                                                                                                                } catch (NoSuchMethodException unused3) {
                                                                                                                                                    try {
                                                                                                                                                        try {
                                                                                                                                                            objInvoke = Runtime.class.getMethod(str7, null).invoke(null, null);
                                                                                                                                                            try {
                                                                                                                                                                Object[] objArr42 = new Object[1];
                                                                                                                                                                c((-1) - ((byte) KeyEvent.getModifierMetaStateMask()), new char[]{24335, 24424, 18049, 65252, 60810, 7844, 62165, 43084, 46303, 44215, 7343, 44225, 1034, 60192, 6757, 16709, 22086, 22888, 51232}, objArr42);
                                                                                                                                                                try {
                                                                                                                                                                    objInvoke2 = File.class.getMethod((String) objArr42[0], null).invoke(objNewInstance, null);
                                                                                                                                                                    classLoader = SoLoader.class.getClassLoader();
                                                                                                                                                                    try {
                                                                                                                                                                        synchronized (objInvoke) {
                                                                                                                                                                            try {
                                                                                                                                                                                Object[] objArr43 = {objInvoke2, classLoader};
                                                                                                                                                                                try {
                                                                                                                                                                                    r12 = 10;
                                                                                                                                                                                    try {
                                                                                                                                                                                        Object[] objArr44 = new Object[1];
                                                                                                                                                                                        a(8713 - View.combineMeasuredStates(0, 0), new char[]{62072, 53374, 46704, 37988, 31300, 22622, 15980, 7238, 57919, 49187}, objArr44);
                                                                                                                                                                                        try {
                                                                                                                                                                                            String str9 = (String) objArr44[0];
                                                                                                                                                                                            Class[] clsArr9 = new Class[2];
                                                                                                                                                                                            clsArr9[0] = String.class;
                                                                                                                                                                                            clsArr9[1] = ClassLoader.class;
                                                                                                                                                                                            Method declaredMethod9 = Runtime.class.getDeclaredMethod(str9, clsArr9);
                                                                                                                                                                                            declaredMethod9.setAccessible(true);
                                                                                                                                                                                            str3 = (String) declaredMethod9.invoke(objInvoke, objArr43);
                                                                                                                                                                                            if (str3 == null) {
                                                                                                                                                                                                throw new UnsatisfiedLinkError(str3);
                                                                                                                                                                                            }
                                                                                                                                                                                            try {
                                                                                                                                                                                            } catch (Throwable th27) {
                                                                                                                                                                                                th = th27;
                                                                                                                                                                                                throw th;
                                                                                                                                                                                            }
                                                                                                                                                                                        } catch (Throwable th28) {
                                                                                                                                                                                            th = th28;
                                                                                                                                                                                            th2 = th;
                                                                                                                                                                                            cause = th2.getCause();
                                                                                                                                                                                            if (cause != null) {
                                                                                                                                                                                                throw th2;
                                                                                                                                                                                            }
                                                                                                                                                                                            throw cause;
                                                                                                                                                                                        }
                                                                                                                                                                                    } catch (Throwable th29) {
                                                                                                                                                                                        th = th29;
                                                                                                                                                                                    }
                                                                                                                                                                                } catch (Throwable th30) {
                                                                                                                                                                                    th = th30;
                                                                                                                                                                                    th2 = th;
                                                                                                                                                                                    cause = th2.getCause();
                                                                                                                                                                                    if (cause != null) {
                                                                                                                                                                                        throw th2;
                                                                                                                                                                                    }
                                                                                                                                                                                    throw cause;
                                                                                                                                                                                }
                                                                                                                                                                            } catch (Throwable th31) {
                                                                                                                                                                                th = th31;
                                                                                                                                                                            }
                                                                                                                                                                        }
                                                                                                                                                                    } catch (Throwable th32) {
                                                                                                                                                                        th = th32;
                                                                                                                                                                    }
                                                                                                                                                                } catch (Throwable th33) {
                                                                                                                                                                    th = th33;
                                                                                                                                                                    Throwable th34 = th;
                                                                                                                                                                    Throwable cause21 = th34.getCause();
                                                                                                                                                                    if (cause21 == null) {
                                                                                                                                                                        throw th34;
                                                                                                                                                                    }
                                                                                                                                                                    throw cause21;
                                                                                                                                                                }
                                                                                                                                                            } catch (Throwable th35) {
                                                                                                                                                                th = th35;
                                                                                                                                                            }
                                                                                                                                                        } catch (Exception e2) {
                                                                                                                                                            e = e2;
                                                                                                                                                            exc = e;
                                                                                                                                                            r9 = declaredMethod;
                                                                                                                                                            r12 = r14;
                                                                                                                                                            if (i2 >= length) {
                                                                                                                                                                throw exc;
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    } catch (Throwable th36) {
                                                                                                                                                        Throwable cause22 = th36.getCause();
                                                                                                                                                        if (cause22 == null) {
                                                                                                                                                            throw th36;
                                                                                                                                                        }
                                                                                                                                                        throw cause22;
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            } catch (Exception unused4) {
                                                                                                                                                if (Build.VERSION.SDK_INT <= 27) {
                                                                                                                                                    try {
                                                                                                                                                        Object objInvoke13 = Runtime.class.getMethod(str7, null).invoke(null, null);
                                                                                                                                                        try {
                                                                                                                                                            Object[] objArr45 = new Object[1];
                                                                                                                                                            c(KeyEvent.getDeadChar(0, 0), new char[]{24335, 24424, 18049, 65252, 60810, 7844, 62165, 43084, 46303, 44215, 7343, 44225, 1034, 60192, 6757, 16709, 22086, 22888, 51232}, objArr45);
                                                                                                                                                            try {
                                                                                                                                                                Object[] objArr46 = {File.class.getMethod((String) objArr45[0], null).invoke(objNewInstance, null), SoLoader.class.getClassLoader()};
                                                                                                                                                                Object[] objArr47 = new Object[1];
                                                                                                                                                                a(Color.alpha(0) + 28201, new char[]{62066, 40016, 11784, 47106, 19155, 54463}, objArr47);
                                                                                                                                                                Method declaredMethod10 = Runtime.class.getDeclaredMethod((String) objArr47[0], String.class, ClassLoader.class);
                                                                                                                                                                declaredMethod10.setAccessible(true);
                                                                                                                                                                declaredMethod10.invoke(objInvoke13, objArr46);
                                                                                                                                                            } catch (Throwable th37) {
                                                                                                                                                                Throwable cause23 = th37.getCause();
                                                                                                                                                                if (cause23 == null) {
                                                                                                                                                                    throw th37;
                                                                                                                                                                }
                                                                                                                                                                throw cause23;
                                                                                                                                                            }
                                                                                                                                                        } catch (Throwable th38) {
                                                                                                                                                            Throwable cause24 = th38.getCause();
                                                                                                                                                            if (cause24 == null) {
                                                                                                                                                                throw th38;
                                                                                                                                                            }
                                                                                                                                                            throw cause24;
                                                                                                                                                        }
                                                                                                                                                    } catch (Throwable th39) {
                                                                                                                                                        Throwable cause25 = th39.getCause();
                                                                                                                                                        if (cause25 == null) {
                                                                                                                                                            throw th39;
                                                                                                                                                        }
                                                                                                                                                        throw cause25;
                                                                                                                                                    }
                                                                                                                                                } else {
                                                                                                                                                    objInvoke = Runtime.class.getMethod(str7, null).invoke(null, null);
                                                                                                                                                    Object[] objArr48 = new Object[1];
                                                                                                                                                    c((-1) - ((byte) KeyEvent.getModifierMetaStateMask()), new char[]{24335, 24424, 18049, 65252, 60810, 7844, 62165, 43084, 46303, 44215, 7343, 44225, 1034, 60192, 6757, 16709, 22086, 22888, 51232}, objArr48);
                                                                                                                                                    objInvoke2 = File.class.getMethod((String) objArr48[0], null).invoke(objNewInstance, null);
                                                                                                                                                    classLoader = SoLoader.class.getClassLoader();
                                                                                                                                                    synchronized (objInvoke) {
                                                                                                                                                        Object[] objArr49 = {objInvoke2, classLoader};
                                                                                                                                                        r12 = 10;
                                                                                                                                                        Object[] objArr410 = new Object[1];
                                                                                                                                                        a(8713 - View.combineMeasuredStates(0, 0), new char[]{62072, 53374, 46704, 37988, 31300, 22622, 15980, 7238, 57919, 49187}, objArr410);
                                                                                                                                                        String str10 = (String) objArr410[0];
                                                                                                                                                        Class[] clsArr10 = new Class[2];
                                                                                                                                                        clsArr10[0] = String.class;
                                                                                                                                                        clsArr10[1] = ClassLoader.class;
                                                                                                                                                        Method declaredMethod11 = Runtime.class.getDeclaredMethod(str10, clsArr10);
                                                                                                                                                        declaredMethod11.setAccessible(true);
                                                                                                                                                        str3 = (String) declaredMethod11.invoke(objInvoke, objArr49);
                                                                                                                                                        if (str3 == null) {
                                                                                                                                                            throw new UnsatisfiedLinkError(str3);
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                                Object[] objArr312 = new Object[1];
                                                                                                                                                a(39499 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), new char[]{62066, 26680, 50924, 15506, 39758, 61700}, objArr312);
                                                                                                                                                r9 = 0;
                                                                                                                                                r9 = 0;
                                                                                                                                                ((Boolean) File.class.getMethod((String) objArr312[0], null).invoke(objNewInstance, null)).booleanValue();
                                                                                                                                                i2++;
                                                                                                                                                str5 = str;
                                                                                                                                                r2 = r9;
                                                                                                                                                r6 = r12;
                                                                                                                                                declaredMethod = 0;
                                                                                                                                            }
                                                                                                                                            ((Boolean) File.class.getMethod((String) objArr312[0], null).invoke(objNewInstance, null)).booleanValue();
                                                                                                                                        } catch (Throwable th40) {
                                                                                                                                            th = th40;
                                                                                                                                            Throwable th41 = th;
                                                                                                                                            try {
                                                                                                                                                Throwable cause26 = th41.getCause();
                                                                                                                                                if (cause26 == null) {
                                                                                                                                                    throw th41;
                                                                                                                                                }
                                                                                                                                                throw cause26;
                                                                                                                                            } catch (Exception unused5) {
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                        Object[] objArr313 = new Object[1];
                                                                                                                                        a(39499 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), new char[]{62066, 26680, 50924, 15506, 39758, 61700}, objArr313);
                                                                                                                                        r9 = 0;
                                                                                                                                        r9 = 0;
                                                                                                                                    } catch (Throwable th42) {
                                                                                                                                        th = th42;
                                                                                                                                        r9 = 0;
                                                                                                                                    }
                                                                                                                                    r12 = 10;
                                                                                                                                } catch (Throwable th43) {
                                                                                                                                    Throwable cause27 = th43.getCause();
                                                                                                                                    if (cause27 == null) {
                                                                                                                                        throw th43;
                                                                                                                                    }
                                                                                                                                    throw cause27;
                                                                                                                                }
                                                                                                                            } catch (Throwable th44) {
                                                                                                                                Throwable cause28 = th44.getCause();
                                                                                                                                if (cause28 == null) {
                                                                                                                                    throw th44;
                                                                                                                                }
                                                                                                                                throw cause28;
                                                                                                                            }
                                                                                                                        } catch (Throwable th45) {
                                                                                                                            th = th45;
                                                                                                                            Throwable th46 = th;
                                                                                                                            Throwable cause29 = th46.getCause();
                                                                                                                            if (cause29 == null) {
                                                                                                                                throw th46;
                                                                                                                            }
                                                                                                                            throw cause29;
                                                                                                                        }
                                                                                                                    } catch (Throwable th47) {
                                                                                                                        th = th47;
                                                                                                                    }
                                                                                                                } catch (Throwable th48) {
                                                                                                                    th = th48;
                                                                                                                }
                                                                                                            } catch (Throwable th49) {
                                                                                                                th = th49;
                                                                                                                Throwable th50 = th;
                                                                                                                Throwable cause30 = th50.getCause();
                                                                                                                if (cause30 == null) {
                                                                                                                    throw th50;
                                                                                                                }
                                                                                                                throw cause30;
                                                                                                            }
                                                                                                        } catch (Throwable th51) {
                                                                                                            th = th51;
                                                                                                        }
                                                                                                    } catch (Throwable th52) {
                                                                                                        th = th52;
                                                                                                        Throwable th53 = th;
                                                                                                        Throwable cause31 = th53.getCause();
                                                                                                        if (cause31 == null) {
                                                                                                            throw th53;
                                                                                                        }
                                                                                                        throw cause31;
                                                                                                    }
                                                                                                } catch (Throwable th54) {
                                                                                                    th = th54;
                                                                                                }
                                                                                            }
                                                                                        } catch (Throwable th55) {
                                                                                            th = th55;
                                                                                        }
                                                                                    } catch (Exception e3) {
                                                                                        e = e3;
                                                                                        declaredMethod = 0;
                                                                                        r14 = 10;
                                                                                        exc = e;
                                                                                        r9 = declaredMethod;
                                                                                        r12 = r14;
                                                                                        if (i2 >= length) {
                                                                                            throw exc;
                                                                                        }
                                                                                    }
                                                                                } catch (Throwable th56) {
                                                                                    th = th56;
                                                                                    Throwable th57 = th;
                                                                                    Throwable cause32 = th57.getCause();
                                                                                    if (cause32 == null) {
                                                                                        throw th57;
                                                                                    }
                                                                                    throw cause32;
                                                                                }
                                                                            } catch (Throwable th58) {
                                                                                th = th58;
                                                                            }
                                                                        } catch (Throwable th59) {
                                                                            th = th59;
                                                                            Throwable th60 = th;
                                                                            Throwable cause33 = th60.getCause();
                                                                            if (cause33 == null) {
                                                                                throw th60;
                                                                            }
                                                                            throw cause33;
                                                                        }
                                                                    } catch (Throwable th61) {
                                                                        th = th61;
                                                                    }
                                                                } catch (Throwable th62) {
                                                                    th = th62;
                                                                    Throwable th63 = th;
                                                                    Throwable cause34 = th63.getCause();
                                                                    if (cause34 == null) {
                                                                        throw th63;
                                                                    }
                                                                    throw cause34;
                                                                }
                                                            } catch (Throwable th64) {
                                                                th = th64;
                                                            }
                                                            exc = e;
                                                            z = false;
                                                        } catch (Throwable th65) {
                                                            th = th65;
                                                            Throwable th66 = th;
                                                            Throwable cause35 = th66.getCause();
                                                            if (cause35 == null) {
                                                                throw th66;
                                                            }
                                                            throw cause35;
                                                        }
                                                    } catch (Throwable th67) {
                                                        th = th67;
                                                    }
                                                } catch (Exception e4) {
                                                    e = e4;
                                                    declaredMethod = r2 == true ? 1 : 0;
                                                }
                                            } catch (Throwable th68) {
                                                Throwable cause36 = th68.getCause();
                                                if (cause36 == null) {
                                                    throw th68;
                                                }
                                                throw cause36;
                                            }
                                        } catch (Throwable th69) {
                                            Throwable cause37 = th69.getCause();
                                            if (cause37 == null) {
                                                throw th69;
                                            }
                                            throw cause37;
                                        }
                                    } catch (Exception e5) {
                                        exc = e5;
                                        z = r2 == true ? 1 : 0;
                                    }
                                    r12 = 10;
                                    r9 = z;
                                    if (i2 >= length) {
                                        throw exc;
                                    }
                                }
                            } catch (Throwable th70) {
                                th = th70;
                                boolean z2 = r2 == true ? 1 : 0;
                                Throwable th71 = th;
                                Throwable cause38 = th71.getCause();
                                if (cause38 == null) {
                                    throw th71;
                                }
                                throw cause38;
                            }
                        } catch (Throwable th72) {
                            th = th72;
                            boolean z3 = r2 == true ? 1 : 0;
                        }
                    } catch (Throwable th73) {
                        boolean z4 = r2 == true ? 1 : 0;
                        Throwable cause39 = th73.getCause();
                        if (cause39 == null) {
                            throw th73;
                        }
                        throw cause39;
                    }
                } catch (Exception e6) {
                    e = e6;
                    declaredMethod = r2 == true ? 1 : 0;
                    r14 = r6;
                }
                i2++;
                str5 = str;
                r2 = r9;
                r6 = r12;
                declaredMethod = 0;
            }
        } catch (Throwable th74) {
            Throwable cause40 = th74.getCause();
            if (cause40 == null) {
                throw th74;
            }
            throw cause40;
        }
    }

    /* JADX WARN: Code duplicated, block: B:134:0x067e A[Catch: all -> 0x06c2, DONT_GENERATE, TRY_ENTER, TRY_LEAVE, TryCatch #2 {, blocks: (B:134:0x067e, B:143:0x06b3, B:144:0x06b8, B:146:0x06ba, B:148:0x06c0, B:149:0x06c1, B:132:0x0644), top: B:168:0x0644, inners: #20 }] */
    /* JADX WARN: Code duplicated, block: B:143:0x06b3 A[Catch: all -> 0x06c2, TRY_ENTER, TryCatch #2 {, blocks: (B:134:0x067e, B:143:0x06b3, B:144:0x06b8, B:146:0x06ba, B:148:0x06c0, B:149:0x06c1, B:132:0x0644), top: B:168:0x0644, inners: #20 }] */
    /* JADX WARN: Code duplicated, block: B:168:0x0644 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:179:0x044a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:65:0x0483 A[Catch: all -> 0x0495, DONT_GENERATE, TRY_ENTER, TryCatch #16 {, blocks: (B:65:0x0483, B:67:0x0486, B:68:0x048b, B:70:0x048d, B:72:0x0493, B:73:0x0494, B:63:0x044a), top: B:179:0x044a, inners: #9 }] */
    /* JADX WARN: Code duplicated, block: B:67:0x0486 A[Catch: all -> 0x0495, TryCatch #16 {, blocks: (B:65:0x0483, B:67:0x0486, B:68:0x048b, B:70:0x048d, B:72:0x0493, B:73:0x0494, B:63:0x044a), top: B:179:0x044a, inners: #9 }] */
    private static void accessartificialFrame(String str) throws Throwable {
        InputStream inputStream;
        Object objInvoke;
        Object objInvoke2;
        ClassLoader classLoader;
        String str2;
        Object objInvoke3;
        ClassLoader classLoader2;
        String str3;
        Object[] objArr = new Object[1];
        a(24763 - TextUtils.getCapsMode("", 0, 0), new char[]{62065, 37576, 13076, 53365, 28815, 4575, 46592, 22370, 63395, 38112}, objArr);
        String str4 = (String) objArr[0];
        Object[] objArr2 = new Object[1];
        a(Color.rgb(0, 0, 0) + 16801575, new char[]{62009, 44373, 19513, 61207, 36587, 10746, 51352, 26726, 2906, 43560, 17855, 58581, 34727, 9881, 50714, 24879, '\n', 41972, 17115, 64918, 40296, 15443, 57125, 32500, 6619, 47351, 23445, 64357, 39483, 13598, 54507, 30668}, objArr2);
        try {
            Object objNewInstance = File.class.getDeclaredConstructor(String.class).newInstance((String) objArr2[0]);
            Object[] objArr3 = new Object[1];
            a(48048 - TextUtils.indexOf((CharSequence) "", '0'), new char[]{62069, 18886, 34074, 49490, 7328, 22538, 37956, 54180}, objArr3);
            if (!((Boolean) File.class.getMethod((String) objArr3[0], null).invoke(objNewInstance, null)).booleanValue()) {
                Object[] objArr4 = new Object[1];
                a(56382 - TextUtils.indexOf((CharSequence) "", '0'), new char[]{62076, 11848, 18974, 26314, 33476, 48964, 56067, 63361, 5018, 19532, 26640, 33991, 41099, 56663}, objArr4);
                String str5 = (String) objArr4[0];
                objNewInstance = File.class.getDeclaredConstructor(String.class).newInstance(System.getProperty(str5, str5));
                Object[] objArr5 = new Object[1];
                a((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 48049, new char[]{62069, 18886, 34074, 49490, 7328, 22538, 37956, 54180}, objArr5);
                if (!((Boolean) File.class.getMethod((String) objArr5[0], null).invoke(objNewInstance, null)).booleanValue()) {
                    objNewInstance = Environment.getExternalStorageDirectory();
                }
            }
            ClassLoader classLoader3 = SoLoader.class.getClassLoader();
            byte b = (byte) 1;
            byte b2 = (byte) (b - 1);
            Object[] objArr6 = new Object[1];
            b(b, b2, b2, objArr6);
            try {
                Object[] objArr7 = {(String) objArr6[0]};
                byte b3 = (byte) 0;
                byte b4 = (byte) (b3 + 1);
                Object[] objArr8 = new Object[1];
                b(b3, b4, b4, objArr8);
                Method declaredMethod = ClassLoader.class.getDeclaredMethod((String) objArr8[0], String.class);
                declaredMethod.setAccessible(true);
                String str6 = (String) declaredMethod.invoke(classLoader3, objArr7);
                if (str6 == null) {
                    Object[] objArr9 = new Object[1];
                    a(30631 - (ViewConfiguration.getEdgeSlop() >> 16), new char[]{62074, 34270, 7481, 38023, 11462, 42044, 16286, 47093, 20303, 50875, 24297}, objArr9);
                    Runtime.class.getMethod((String) objArr9[0], String.class).invoke(Runtime.class.getMethod(str4, null).invoke(null, null), str);
                    return;
                }
                Object[] objArr10 = new Object[1];
                c(ViewConfiguration.getTouchSlop() >> 8, new char[]{36468, 36376, 56618, 30250, 30245, 55466, 9093, 8325, 12141, 9333, 55956, 27379, 54652, 28852, 37551}, objArr10);
                Object[] objArr11 = {Integer.valueOf(((Integer) String.class.getMethod((String) objArr10[0], Integer.TYPE).invoke(str6, 47)).intValue() + 1)};
                Object[] objArr12 = new Object[1];
                c(ViewConfiguration.getMinimumFlingVelocity() >> 16, new char[]{23432, 23547, 50523, 28626, 28224, 5363, 63044, 14700, 14100, 15761, 5834, 42662, 159}, objArr12);
                Object objNewInstance2 = File.class.getDeclaredConstructor(File.class, String.class).newInstance(objNewInstance, String.class.getMethod((String) objArr12[0], Integer.TYPE).invoke(str6, objArr11));
                Object[] objArr13 = new Object[1];
                c(Color.alpha(0), new char[]{38087, 38052, 2779, 27401, 41434, 37401, 14622, 15803, 63637, 14657, 36903, 8278}, objArr13);
                if (((Boolean) String.class.getMethod((String) objArr13[0], CharSequence.class).invoke(str6, "!")).booleanValue()) {
                    StringBuilder sb = new StringBuilder();
                    Object[] objArr14 = new Object[1];
                    a(ExpandableListView.getPackedPositionType(0L) + 41737, new char[]{62076, 20862, 46198, 6967, 32340, 56658, 8268, 34636, 60004}, objArr14);
                    sb.append((String) objArr14[0]);
                    sb.append(str6);
                    String path = new URL(sb.toString()).getPath();
                    Object[] objArr15 = new Object[1];
                    c((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) - 1, new char[]{36468, 36376, 56618, 30250, 30245, 55466, 9093, 8325, 12141, 9333, 55956, 27379, 54652, 28852, 37551}, objArr15);
                    Object[] objArr16 = {5, Integer.valueOf(((Integer) String.class.getMethod((String) objArr15[0], String.class).invoke(path, "!/")).intValue())};
                    Object[] objArr17 = new Object[1];
                    c(ViewConfiguration.getFadingEdgeLength() >> 16, new char[]{23432, 23547, 50523, 28626, 28224, 5363, 63044, 14700, 14100, 15761, 5834, 42662, 159}, objArr17);
                    ZipFile zipFile = new ZipFile((String) String.class.getMethod((String) objArr17[0], Integer.TYPE, Integer.TYPE).invoke(path, objArr16));
                    Object[] objArr18 = new Object[1];
                    c((-1) - ExpandableListView.getPackedPositionChild(0L), new char[]{36468, 36376, 56618, 30250, 30245, 55466, 9093, 8325, 12141, 9333, 55956, 27379, 54652, 28852, 37551}, objArr18);
                    Object[] objArr19 = {Integer.valueOf(((Integer) String.class.getMethod((String) objArr18[0], String.class).invoke(str6, "!/")).intValue())};
                    Object[] objArr20 = new Object[1];
                    c(TextUtils.getOffsetBefore("", 0), new char[]{23432, 23547, 50523, 28626, 28224, 5363, 63044, 14700, 14100, 15761, 5834, 42662, 159}, objArr20);
                    Object objInvoke4 = String.class.getMethod((String) objArr20[0], Integer.TYPE).invoke(str6, objArr19);
                    Object[] objArr21 = {2};
                    Object[] objArr22 = new Object[1];
                    c(Color.red(0), new char[]{23432, 23547, 50523, 28626, 28224, 5363, 63044, 14700, 14100, 15761, 5834, 42662, 159}, objArr22);
                    inputStream = zipFile.getInputStream(zipFile.getEntry((String) String.class.getMethod((String) objArr22[0], Integer.TYPE).invoke(objInvoke4, objArr21)));
                } else {
                    inputStream = (InputStream) FileInputStream.class.getDeclaredConstructor(String.class).newInstance(str6);
                }
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                bufferedInputStream.skip(208L);
                bufferedInputStream.skip(5L);
                InputStream inputStreamArtificialStackFrames = ArtificialStackFrames(bufferedInputStream, '2' - AndroidCharacter.getMirror('0'), new byte[]{-78, -38, -57, 0, 116, Ascii.CAN, -117, 86}, (ViewConfiguration.getTouchSlop() >> 8) + 3, (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 1285627985);
                if (bufferedInputStream == inputStreamArtificialStackFrames) {
                    inputStreamArtificialStackFrames.close();
                    try {
                        try {
                            Object objInvoke5 = Runtime.class.getMethod(str4, null).invoke(null, null);
                            try {
                                try {
                                    Object[] objArr23 = {str6, SoLoader.class.getClassLoader()};
                                    Object[] objArr24 = new Object[1];
                                    a(18713 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), new char[]{62074, 47968, 24645, 10553}, objArr24);
                                    Method declaredMethod2 = Runtime.class.getDeclaredMethod((String) objArr24[0], String.class, ClassLoader.class);
                                    declaredMethod2.setAccessible(true);
                                    declaredMethod2.invoke(objInvoke5, objArr23);
                                    return;
                                } catch (Throwable th) {
                                    Throwable cause = th.getCause();
                                    if (cause == null) {
                                        throw th;
                                    }
                                    throw cause;
                                }
                            } catch (NoSuchMethodException unused) {
                                objInvoke3 = Runtime.class.getMethod(str4, null).invoke(null, null);
                                classLoader2 = SoLoader.class.getClassLoader();
                                synchronized (objInvoke3) {
                                    try {
                                        Object[] objArr25 = new Object[1];
                                        a((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 8713, new char[]{62072, 53374, 46704, 37988, 31300, 22622, 15980, 7238, 57919, 49187}, objArr25);
                                        Method declaredMethod3 = Runtime.class.getDeclaredMethod((String) objArr25[0], String.class, ClassLoader.class);
                                        declaredMethod3.setAccessible(true);
                                        str3 = (String) declaredMethod3.invoke(objInvoke3, str6, classLoader2);
                                        if (str3 == null) {
                                            throw new UnsatisfiedLinkError(str3);
                                        }
                                    } catch (Throwable th2) {
                                        Throwable cause2 = th2.getCause();
                                        if (cause2 == null) {
                                            throw th2;
                                        }
                                        throw cause2;
                                    }
                                }
                                return;
                            }
                        } catch (Exception unused2) {
                            if (Build.VERSION.SDK_INT <= 27) {
                                try {
                                    Object objInvoke6 = Runtime.class.getMethod(str4, null).invoke(null, null);
                                    try {
                                        Object[] objArr26 = {str6, SoLoader.class.getClassLoader()};
                                        Object[] objArr27 = new Object[1];
                                        a(28201 - (ViewConfiguration.getDoubleTapTimeout() >> 16), new char[]{62066, 40016, 11784, 47106, 19155, 54463}, objArr27);
                                        Method declaredMethod4 = Runtime.class.getDeclaredMethod((String) objArr27[0], String.class, ClassLoader.class);
                                        declaredMethod4.setAccessible(true);
                                        declaredMethod4.invoke(objInvoke6, objArr26);
                                        return;
                                    } catch (Throwable th3) {
                                        Throwable cause3 = th3.getCause();
                                        if (cause3 == null) {
                                            throw th3;
                                        }
                                        throw cause3;
                                    }
                                } catch (Throwable th4) {
                                    Throwable cause4 = th4.getCause();
                                    if (cause4 == null) {
                                        throw th4;
                                    }
                                    throw cause4;
                                }
                            }
                            objInvoke3 = Runtime.class.getMethod(str4, null).invoke(null, null);
                            classLoader2 = SoLoader.class.getClassLoader();
                            synchronized (objInvoke3) {
                                Object[] objArr28 = new Object[1];
                                a((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 8713, new char[]{62072, 53374, 46704, 37988, 31300, 22622, 15980, 7238, 57919, 49187}, objArr28);
                                Method declaredMethod5 = Runtime.class.getDeclaredMethod((String) objArr28[0], String.class, ClassLoader.class);
                                declaredMethod5.setAccessible(true);
                                str3 = (String) declaredMethod5.invoke(objInvoke3, str6, classLoader2);
                                if (str3 == null) {
                                    throw new UnsatisfiedLinkError(str3);
                                }
                                return;
                            }
                        }
                    } catch (Throwable th5) {
                        Throwable cause5 = th5.getCause();
                        if (cause5 == null) {
                            throw th5;
                        }
                        throw cause5;
                    }
                }
                OutputStream outputStream = (OutputStream) FileOutputStream.class.getDeclaredConstructor(File.class).newInstance(objNewInstance2);
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
                byte[] bArr = new byte[1024];
                while (true) {
                    int i = inputStreamArtificialStackFrames.read(bArr);
                    if (i < 0) {
                        break;
                    } else {
                        bufferedOutputStream.write(bArr, 0, i);
                    }
                }
                bufferedOutputStream.flush();
                Object[] objArr29 = new Object[1];
                c((-1) - TextUtils.lastIndexOf("", '0', 0, 0), new char[]{8559, 8456, 65229, 16077, 21958, 7036, 35987, 26725, 6512}, objArr29);
                Object objInvoke7 = FileOutputStream.class.getMethod((String) objArr29[0], null).invoke(outputStream, null);
                Object[] objArr30 = new Object[1];
                a(View.MeasureSpec.getMode(0) + 23957, new char[]{62053, 45050, 18770, 60106}, objArr30);
                FileDescriptor.class.getMethod((String) objArr30[0], null).invoke(objInvoke7, null);
                bufferedOutputStream.close();
                inputStreamArtificialStackFrames.close();
                try {
                    try {
                        try {
                            Object objInvoke8 = Runtime.class.getMethod(str4, null).invoke(null, null);
                            try {
                                Object[] objArr31 = new Object[1];
                                c(ViewConfiguration.getJumpTapTimeout() >> 16, new char[]{24335, 24424, 18049, 65252, 60810, 7844, 62165, 43084, 46303, 44215, 7343, 44225, 1034, 60192, 6757, 16709, 22086, 22888, 51232}, objArr31);
                                try {
                                    Object[] objArr32 = {File.class.getMethod((String) objArr31[0], null).invoke(objNewInstance2, null), SoLoader.class.getClassLoader()};
                                    Object[] objArr33 = new Object[1];
                                    a(Color.argb(0, 0, 0, 0) + 18713, new char[]{62074, 47968, 24645, 10553}, objArr33);
                                    Method declaredMethod6 = Runtime.class.getDeclaredMethod((String) objArr33[0], String.class, ClassLoader.class);
                                    declaredMethod6.setAccessible(true);
                                    declaredMethod6.invoke(objInvoke8, objArr32);
                                } catch (Throwable th6) {
                                    Throwable cause6 = th6.getCause();
                                    if (cause6 == null) {
                                        throw th6;
                                    }
                                    throw cause6;
                                }
                            } catch (Throwable th7) {
                                Throwable cause7 = th7.getCause();
                                if (cause7 == null) {
                                    throw th7;
                                }
                                throw cause7;
                            }
                        } catch (NoSuchMethodException unused3) {
                            objInvoke = Runtime.class.getMethod(str4, null).invoke(null, null);
                            Object[] objArr34 = new Object[1];
                            c(TextUtils.indexOf("", "", 0, 0), new char[]{24335, 24424, 18049, 65252, 60810, 7844, 62165, 43084, 46303, 44215, 7343, 44225, 1034, 60192, 6757, 16709, 22086, 22888, 51232}, objArr34);
                            objInvoke2 = File.class.getMethod((String) objArr34[0], null).invoke(objNewInstance2, null);
                            classLoader = SoLoader.class.getClassLoader();
                            synchronized (objInvoke) {
                                try {
                                    Object[] objArr35 = {objInvoke2, classLoader};
                                    Object[] objArr36 = new Object[1];
                                    a(8713 - ((Process.getThreadPriority(0) + 20) >> 6), new char[]{62072, 53374, 46704, 37988, 31300, 22622, 15980, 7238, 57919, 49187}, objArr36);
                                    Method declaredMethod7 = Runtime.class.getDeclaredMethod((String) objArr36[0], String.class, ClassLoader.class);
                                    declaredMethod7.setAccessible(true);
                                    str2 = (String) declaredMethod7.invoke(objInvoke, objArr35);
                                    if (str2 == null) {
                                        throw new UnsatisfiedLinkError(str2);
                                    }
                                } catch (Throwable th8) {
                                    Throwable cause8 = th8.getCause();
                                    if (cause8 == null) {
                                        throw th8;
                                    }
                                    throw cause8;
                                }
                            }
                        }
                    } catch (Exception unused4) {
                        if (Build.VERSION.SDK_INT <= 27) {
                            try {
                                Object objInvoke9 = Runtime.class.getMethod(str4, null).invoke(null, null);
                                try {
                                    Object[] objArr37 = new Object[1];
                                    c(View.MeasureSpec.getMode(0), new char[]{24335, 24424, 18049, 65252, 60810, 7844, 62165, 43084, 46303, 44215, 7343, 44225, 1034, 60192, 6757, 16709, 22086, 22888, 51232}, objArr37);
                                    try {
                                        Object[] objArr38 = {File.class.getMethod((String) objArr37[0], null).invoke(objNewInstance2, null), SoLoader.class.getClassLoader()};
                                        Object[] objArr39 = new Object[1];
                                        a(28201 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), new char[]{62066, 40016, 11784, 47106, 19155, 54463}, objArr39);
                                        Method declaredMethod8 = Runtime.class.getDeclaredMethod((String) objArr39[0], String.class, ClassLoader.class);
                                        declaredMethod8.setAccessible(true);
                                        declaredMethod8.invoke(objInvoke9, objArr38);
                                    } catch (Throwable th9) {
                                        Throwable cause9 = th9.getCause();
                                        if (cause9 == null) {
                                            throw th9;
                                        }
                                        throw cause9;
                                    }
                                } catch (Throwable th10) {
                                    Throwable cause10 = th10.getCause();
                                    if (cause10 == null) {
                                        throw th10;
                                    }
                                    throw cause10;
                                }
                            } catch (Throwable th11) {
                                Throwable cause11 = th11.getCause();
                                if (cause11 == null) {
                                    throw th11;
                                }
                                throw cause11;
                            }
                        } else {
                            objInvoke = Runtime.class.getMethod(str4, null).invoke(null, null);
                            Object[] objArr310 = new Object[1];
                            c(TextUtils.indexOf("", "", 0, 0), new char[]{24335, 24424, 18049, 65252, 60810, 7844, 62165, 43084, 46303, 44215, 7343, 44225, 1034, 60192, 6757, 16709, 22086, 22888, 51232}, objArr310);
                            objInvoke2 = File.class.getMethod((String) objArr310[0], null).invoke(objNewInstance2, null);
                            classLoader = SoLoader.class.getClassLoader();
                            synchronized (objInvoke) {
                                Object[] objArr311 = {objInvoke2, classLoader};
                                Object[] objArr312 = new Object[1];
                                a(8713 - ((Process.getThreadPriority(0) + 20) >> 6), new char[]{62072, 53374, 46704, 37988, 31300, 22622, 15980, 7238, 57919, 49187}, objArr312);
                                Method declaredMethod9 = Runtime.class.getDeclaredMethod((String) objArr312[0], String.class, ClassLoader.class);
                                declaredMethod9.setAccessible(true);
                                str2 = (String) declaredMethod9.invoke(objInvoke, objArr311);
                                if (str2 == null) {
                                    throw new UnsatisfiedLinkError(str2);
                                }
                            }
                        }
                    }
                    try {
                        Object[] objArr40 = new Object[1];
                        a(39499 - TextUtils.getOffsetAfter("", 0), new char[]{62066, 26680, 50924, 15506, 39758, 61700}, objArr40);
                        ((Boolean) File.class.getMethod((String) objArr40[0], null).invoke(objNewInstance2, null)).booleanValue();
                    } catch (Throwable th12) {
                        try {
                            Throwable cause12 = th12.getCause();
                            if (cause12 == null) {
                                throw th12;
                            }
                            throw cause12;
                        } catch (Exception unused5) {
                        }
                    }
                } catch (Throwable th13) {
                    Throwable cause13 = th13.getCause();
                    if (cause13 == null) {
                        throw th13;
                    }
                    throw cause13;
                }
            } catch (Throwable th14) {
                Throwable cause14 = th14.getCause();
                if (cause14 == null) {
                    throw th14;
                }
                throw cause14;
            }
        } catch (Throwable th15) {
            Throwable cause15 = th15.getCause();
            if (cause15 == null) {
                throw th15;
            }
            throw cause15;
        }
    }
}
