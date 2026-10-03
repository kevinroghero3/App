package com.salesforce.marketingcloud.sfmcsdk;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.facebook.react.animated.InterpolationAnimatedNode;
import com.google.common.base.Ascii;
import com.salesforce.marketingcloud.sfmcsdk.components.behaviors.BehaviorManagerImpl;
import com.salesforce.marketingcloud.sfmcsdk.components.events.Event;
import com.salesforce.marketingcloud.sfmcsdk.components.events.EventManager;
import com.salesforce.marketingcloud.sfmcsdk.components.identity.Identity;
import com.salesforce.marketingcloud.sfmcsdk.components.logging.LogLevel;
import com.salesforce.marketingcloud.sfmcsdk.components.logging.LogListener;
import com.salesforce.marketingcloud.sfmcsdk.components.logging.SFMCSdkLogger;
import com.salesforce.marketingcloud.sfmcsdk.components.utils.SdkExecutors;
import com.salesforce.marketingcloud.sfmcsdk.components.utils.SdkExecutorsKt;
import com.salesforce.marketingcloud.sfmcsdk.modules.Config;
import com.salesforce.marketingcloud.sfmcsdk.modules.Module;
import com.salesforce.marketingcloud.sfmcsdk.modules.ModuleIdentifier;
import com.salesforce.marketingcloud.sfmcsdk.modules.cdp.CdpModule;
import com.salesforce.marketingcloud.sfmcsdk.modules.cdp.CdpModuleConfig;
import com.salesforce.marketingcloud.sfmcsdk.modules.cdp.CdpModuleReadyListener;
import com.salesforce.marketingcloud.sfmcsdk.modules.push.PushModule;
import com.salesforce.marketingcloud.sfmcsdk.modules.push.PushModuleConfig;
import com.salesforce.marketingcloud.sfmcsdk.modules.push.PushModuleReadyListener;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.io.encoding.Base64;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt__StringsKt;
import o.ArtificialStackFrames;
import o._CREATION;
import org.apache.commons.lang3.CharEncoding;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class SFMCSdk {
    private static final Object SDK_LOCK;
    public static final String SDK_VERSION_NAME = "1.0.5";
    private static final String TAG = "~$SFMCSdk";
    private static final List<WhenReadyHandler> UNIFIED_SDK_INSTANCE_REQUESTS;
    private static final BehaviorManagerImpl behaviorManager;
    private static volatile InitializationState initializationState;
    private static SFMCSdk instance;
    private final SFMCSdkModuleConfig config;
    private final SdkExecutors executors;
    public Identity identity;
    private final List<Module> modules;
    public static final Companion Companion = new Companion(null);
    private static PushModule pushModule = new PushModule();
    private static CdpModule cdpModule = new CdpModule();

    /* JADX INFO: loaded from: classes3.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ModuleIdentifier.values().length];
            try {
                iArr[ModuleIdentifier.PUSH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ModuleIdentifier.CDP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ SFMCSdk(SFMCSdkModuleConfig sFMCSdkModuleConfig, DefaultConstructorMarker defaultConstructorMarker) {
        this(sFMCSdkModuleConfig);
    }

    @JvmStatic
    public static final void configure(@NotNull Context context, @NotNull SFMCSdkModuleConfig sFMCSdkModuleConfig) {
        Companion.configure(context, sFMCSdkModuleConfig);
    }

    @JvmStatic
    public static final void configure(@NotNull Context context, @NotNull SFMCSdkModuleConfig sFMCSdkModuleConfig, @Nullable Function1<? super InitializationStatus, Unit> function1) {
        Companion.configure(context, sFMCSdkModuleConfig, function1);
    }

    @JvmStatic
    public static final void requestSdk(@NotNull SFMCSdkReadyListener sFMCSdkReadyListener) {
        Companion.requestSdk(sFMCSdkReadyListener);
    }

    @JvmStatic
    public static final void setLogging(@NotNull LogLevel logLevel, @Nullable LogListener logListener) {
        Companion.setLogging(logLevel, logListener);
    }

    @JvmStatic
    public static final void track(@NotNull Event... eventArr) {
        Companion.track(eventArr);
    }

    private SFMCSdk(SFMCSdkModuleConfig sFMCSdkModuleConfig) {
        this.config = sFMCSdkModuleConfig;
        ExecutorService executorServiceNewCachedThreadPool = Executors.newCachedThreadPool();
        Intrinsics.checkNotNullExpressionValue(executorServiceNewCachedThreadPool, "newCachedThreadPool(...)");
        this.executors = new SdkExecutors(executorServiceNewCachedThreadPool, null, 2, null);
        this.modules = new ArrayList();
        Iterator<T> it2 = sFMCSdkModuleConfig.getConfigs$sfmcsdk_release().iterator();
        while (it2.hasNext()) {
            int i = WhenMappings.$EnumSwitchMapping$0[((Config) it2.next()).getModuleIdentifier().ordinal()];
            if (i == 1) {
                if (this.config.getPushModuleConfig() != null) {
                    this.modules.add(pushModule);
                }
            } else if (i == 2 && this.config.getCdpModuleConfig() != null) {
                this.modules.add(cdpModule);
            }
        }
    }

    public final SFMCSdkModuleConfig getConfig() {
        return this.config;
    }

    /* JADX INFO: loaded from: classes3.dex */
    public static final class Companion {

        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[InitializationState.values().length];
                try {
                    iArr[InitializationState.READY.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void configure(@NotNull Context context, @NotNull SFMCSdkModuleConfig config) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(config, "config");
            configure$default(this, context, config, null, 4, null);
        }

        private Companion() {
        }

        public final PushModule getPushModule$sfmcsdk_release() {
            return SFMCSdk.pushModule;
        }

        public final void setPushModule$sfmcsdk_release(@NotNull PushModule pushModule) {
            Intrinsics.checkNotNullParameter(pushModule, "<set-?>");
            SFMCSdk.pushModule = pushModule;
        }

        public final CdpModule getCdpModule$sfmcsdk_release() {
            return SFMCSdk.cdpModule;
        }

        public final void setCdpModule$sfmcsdk_release(@NotNull CdpModule cdpModule) {
            Intrinsics.checkNotNullParameter(cdpModule, "<set-?>");
            SFMCSdk.cdpModule = cdpModule;
        }

        public final BehaviorManagerImpl getBehaviorManager$sfmcsdk_release() {
            return SFMCSdk.behaviorManager;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void configure$default(Companion companion, Context context, SFMCSdkModuleConfig sFMCSdkModuleConfig, Function1 function1, int i, Object obj) {
            if ((i & 4) != 0) {
                function1 = null;
            }
            companion.configure(context, sFMCSdkModuleConfig, function1);
        }

        @JvmStatic
        public final void configure(@NotNull final Context context, @NotNull final SFMCSdkModuleConfig config, @Nullable final Function1<? super InitializationStatus, Unit> function1) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(config, "config");
            synchronized (SFMCSdk.SDK_LOCK) {
                SFMCSdk sFMCSdk = SFMCSdk.instance;
                if (sFMCSdk != null) {
                    InitializationState initializationState = SFMCSdk.initializationState;
                    InitializationState initializationState2 = InitializationState.READY;
                    if ((initializationState == initializationState2 || SFMCSdk.initializationState == InitializationState.INITIALIZING) && Intrinsics.areEqual(config, sFMCSdk.getConfig())) {
                        SFMCSdkLogger.INSTANCE.d(SFMCSdk.TAG, new Function0<String>() { // from class: com.salesforce.marketingcloud.sfmcsdk.SFMCSdk$Companion$configure$1$1$1
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return "SDK already initialized for config " + config;
                            }
                        });
                        if (SFMCSdk.initializationState == initializationState2 && function1 != null) {
                            function1.invoke(new SFMCSdkInitializationStatus(true));
                        }
                        return;
                    }
                }
                Companion companion = SFMCSdk.Companion;
                SFMCSdk.initializationState = InitializationState.INITIALIZING;
                SFMCSdkLogger.INSTANCE.d(SFMCSdk.TAG, new Function0<String>() { // from class: com.salesforce.marketingcloud.sfmcsdk.SFMCSdk$Companion$configure$1$2
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "~~ SFMCSdk v1.0.5 Initialization Started ~~";
                    }
                });
                new Thread(new Runnable() { // from class: com.salesforce.marketingcloud.sfmcsdk.SFMCSdk$Companion$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        SFMCSdk.Companion.configure$lambda$10$lambda$9(config, function1, context);
                    }
                }).start();
                SFMCSdk.SDK_LOCK.notifyAll();
                Unit unit = Unit.INSTANCE;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void configure$lambda$10$lambda$9(final SFMCSdkModuleConfig config, Function1 function1, Context context) {
            Intrinsics.checkNotNullParameter(config, "$config");
            Intrinsics.checkNotNullParameter(context, "$context");
            String name = Thread.currentThread().getName();
            Thread.currentThread().setName("SFMCSdk_Init");
            try {
                try {
                    if (SFMCSdk.instance != null) {
                        SFMCSdk.Companion.staticTearDown();
                    }
                    Companion companion = SFMCSdk.Companion;
                    SFMCSdk.instance = new SFMCSdk(config, null);
                    final long jCurrentTimeMillis = System.currentTimeMillis();
                    CountDownLatch countDownLatch = new CountDownLatch(config.getConfigs$sfmcsdk_release().size());
                    SFMCSdkLogger.INSTANCE.d(SFMCSdk.TAG, new Function0<String>() { // from class: com.salesforce.marketingcloud.sfmcsdk.SFMCSdk$Companion$configure$1$3$moduleInitLatch$1$1
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return "Initializing " + config.getConfigs$sfmcsdk_release().size() + " modules.";
                        }
                    });
                    for (final Config config2 : config.getConfigs$sfmcsdk_release()) {
                        SFMCSdkLogger.INSTANCE.d(SFMCSdk.TAG, new Function0<String>() { // from class: com.salesforce.marketingcloud.sfmcsdk.SFMCSdk$Companion$configure$1$3$2$1
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return "Module (" + config2.getModuleIdentifier() + ") init started. Current Version: " + config2.getVersion() + " && Max Supported Version: " + config2.getMAX_SUPPORTED_VERSION();
                            }
                        });
                        SFMCSdkComponents sFMCSdkComponents = new SFMCSdkComponents(context, config2.getModuleIdentifier().name(), config2.getModuleApplicationId(), SFMCSdk.Companion.getBehaviorManager$sfmcsdk_release().initIfNecessary$sfmcsdk_release(context), new EventManager(config2.getModuleIdentifier().name()));
                        SFMCSdk sFMCSdk = SFMCSdk.instance;
                        if (sFMCSdk != null && sFMCSdk.identity == null) {
                            sFMCSdk.setIdentity(Identity.Companion.getInstance());
                        }
                        if (config2 instanceof PushModuleConfig) {
                            SdkExecutorsKt.namedRunnable(new SdkExecutors(null, null, 3, null).getDiskIO(), config2.getModuleIdentifier().name(), new SFMCSdk$Companion$configure$1$3$2$3(context, config2, sFMCSdkComponents, countDownLatch));
                        } else if (config2 instanceof CdpModuleConfig) {
                            SdkExecutorsKt.namedRunnable(new SdkExecutors(null, null, 3, null).getDiskIO(), config2.getModuleIdentifier().name(), new SFMCSdk$Companion$configure$1$3$2$4(context, config2, sFMCSdkComponents, countDownLatch));
                        }
                    }
                    final boolean zAwait = countDownLatch.await(5L, TimeUnit.SECONDS);
                    SFMCSdkLogger sFMCSdkLogger = SFMCSdkLogger.INSTANCE;
                    sFMCSdkLogger.d(SFMCSdk.TAG, new Function0<String>() { // from class: com.salesforce.marketingcloud.sfmcsdk.SFMCSdk$Companion$configure$1$3$3$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            boolean z = zAwait;
                            StringBuilder sb = new StringBuilder();
                            sb.append("Module init latch time exceeded: ");
                            sb.append(!z);
                            return sb.toString();
                        }
                    });
                    Companion companion2 = SFMCSdk.Companion;
                    SFMCSdk.initializationState = InitializationState.READY;
                    sFMCSdkLogger.d(SFMCSdk.TAG, new Function0<String>() { // from class: com.salesforce.marketingcloud.sfmcsdk.SFMCSdk$Companion$configure$1$3$4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return "SFMC SDK Ready took " + (System.currentTimeMillis() - jCurrentTimeMillis) + "ms.";
                        }
                    });
                    synchronized (SFMCSdk.UNIFIED_SDK_INSTANCE_REQUESTS) {
                        for (final WhenReadyHandler whenReadyHandler : SFMCSdk.UNIFIED_SDK_INSTANCE_REQUESTS) {
                            try {
                                SFMCSdk sFMCSdk2 = SFMCSdk.instance;
                                if (sFMCSdk2 != null) {
                                    whenReadyHandler.deliverSdk(sFMCSdk2);
                                }
                            } catch (Exception e) {
                                SFMCSdkLogger.INSTANCE.e(SFMCSdk.TAG, e, new Function0<String>() { // from class: com.salesforce.marketingcloud.sfmcsdk.SFMCSdk$Companion$configure$1$3$5$1$2
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final String invoke() {
                                        return "Failure during requestSdk() delivery for " + whenReadyHandler + ".";
                                    }
                                });
                            }
                        }
                        SFMCSdk.UNIFIED_SDK_INSTANCE_REQUESTS.clear();
                        SFMCSdk.Companion.notifyInitializationStatusListener(function1, true);
                        Unit unit = Unit.INSTANCE;
                    }
                    Thread.currentThread().setName(name);
                    SFMCSdkLogger.INSTANCE.d(SFMCSdk.TAG, new Function0<String>() { // from class: com.salesforce.marketingcloud.sfmcsdk.SFMCSdk$Companion$configure$1$3$7
                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return "~~ SFMCSdk Initialization Complete ~~";
                        }
                    });
                } catch (Exception e2) {
                    Companion companion3 = SFMCSdk.Companion;
                    companion3.staticTearDown();
                    SFMCSdk.UNIFIED_SDK_INSTANCE_REQUESTS.clear();
                    companion3.notifyInitializationStatusListener(function1, false);
                    SFMCSdkLogger sFMCSdkLogger2 = SFMCSdkLogger.INSTANCE;
                    sFMCSdkLogger2.e(SFMCSdk.TAG, e2, new Function0<String>() { // from class: com.salesforce.marketingcloud.sfmcsdk.SFMCSdk$Companion$configure$1$3$6
                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return "An error occurred during SDK initialization.";
                        }
                    });
                    Thread.currentThread().setName(name);
                    sFMCSdkLogger2.d(SFMCSdk.TAG, new Function0<String>() { // from class: com.salesforce.marketingcloud.sfmcsdk.SFMCSdk$Companion$configure$1$3$7
                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return "~~ SFMCSdk Initialization Complete ~~";
                        }
                    });
                }
            } catch (Throwable th) {
                Thread.currentThread().setName(name);
                SFMCSdkLogger.INSTANCE.d(SFMCSdk.TAG, new Function0<String>() { // from class: com.salesforce.marketingcloud.sfmcsdk.SFMCSdk$Companion$configure$1$3$7
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "~~ SFMCSdk Initialization Complete ~~";
                    }
                });
                throw th;
            }
        }

        private final void notifyInitializationStatusListener(final Function1<? super InitializationStatus, Unit> function1, boolean z) {
            if (function1 != null) {
                try {
                    function1.invoke(new SFMCSdkInitializationStatus(z));
                } catch (Exception e) {
                    SFMCSdkLogger.INSTANCE.e(SFMCSdk.TAG, e, new Function0<String>() { // from class: com.salesforce.marketingcloud.sfmcsdk.SFMCSdk$Companion$notifyInitializationStatusListener$1
                        private static long _BOUNDARY;
                        private static char[] _CREATION;
                        private static final byte[] $$c = {Ascii.EM, 104, 41, -86};
                        private static final int $$d = 238;
                        private static int $10 = 0;
                        private static int $11 = 1;
                        private static final byte[] $$a = {71, Base64.padSymbol, 39, Base64.padSymbol, 2, -47, -11, -22, -1, 3, 8, -19, 19, 53, 52, -17, 5, 0, -17, Ascii.FF, -11, 8, -53, Ascii.CR, 1};
                        private static final int $$b = 47;
                        private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
                        private static int artificialFrame = 1;

                        /* JADX WARN: Code duplicated, block: B:10:0x0022  */
                        /* JADX WARN: Code duplicated, block: B:8:0x001c  */
                        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0022 -> B:11:0x0026). Please report as a decompilation issue!!! */
                        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0022
                            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                            */
                        private static java.lang.String $$e(byte r5, int r6, int r7) {
                            /*
                                int r7 = r7 * 3
                                int r0 = r7 + 1
                                int r5 = r5 * 2
                                int r5 = 3 - r5
                                byte[] r1 = com.salesforce.marketingcloud.sfmcsdk.SFMCSdk$Companion$notifyInitializationStatusListener$1.$$c
                                int r6 = 106 - r6
                                byte[] r0 = new byte[r0]
                                r2 = 0
                                if (r1 != 0) goto L14
                                r4 = r7
                                r3 = r2
                                goto L26
                            L14:
                                r3 = r2
                            L15:
                                byte r4 = (byte) r6
                                r0[r3] = r4
                                int r5 = r5 + 1
                                if (r3 != r7) goto L22
                                java.lang.String r5 = new java.lang.String
                                r5.<init>(r0, r2)
                                return r5
                            L22:
                                int r3 = r3 + 1
                                r4 = r1[r5]
                            L26:
                                int r4 = -r4
                                int r6 = r6 + r4
                                goto L15
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.sfmcsdk.SFMCSdk$Companion$notifyInitializationStatusListener$1.$$e(byte, int, int):java.lang.String");
                        }

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(0);
                        }

                        /* JADX WARN: Code duplicated, block: B:10:0x0021  */
                        /* JADX WARN: Code duplicated, block: B:8:0x0019  */
                        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0021 -> B:11:0x0027). Please report as a decompilation issue!!! */
                        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0021
                            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                            */
                        private static void b(int r7, byte r8, byte r9, java.lang.Object[] r10) {
                            /*
                                int r9 = 22 - r9
                                int r7 = r7 + 66
                                byte[] r0 = com.salesforce.marketingcloud.sfmcsdk.SFMCSdk$Companion$notifyInitializationStatusListener$1.$$a
                                int r8 = 4 - r8
                                byte[] r1 = new byte[r8]
                                r2 = 0
                                if (r0 != 0) goto L11
                                r3 = r9
                                r4 = r2
                                r9 = r8
                                goto L27
                            L11:
                                r3 = r2
                            L12:
                                int r4 = r3 + 1
                                byte r5 = (byte) r7
                                r1[r3] = r5
                                if (r4 != r8) goto L21
                                java.lang.String r7 = new java.lang.String
                                r7.<init>(r1, r2)
                                r10[r2] = r7
                                return
                            L21:
                                r3 = r0[r9]
                                r6 = r9
                                r9 = r7
                                r7 = r3
                                r3 = r6
                            L27:
                                int r7 = -r7
                                int r3 = r3 + 1
                                int r9 = r9 + r7
                                int r7 = r9 + (-2)
                                r9 = r3
                                r3 = r4
                                goto L12
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.sfmcsdk.SFMCSdk$Companion$notifyInitializationStatusListener$1.b(int, byte, byte, java.lang.Object[]):void");
                        }

                        /* JADX WARN: Code duplicated, block: B:35:0x01bd  */
                        /* JADX WARN: Code duplicated, block: B:36:0x01be  */
                        private static void a(char c, int i, int i2, Object[] objArr) throws Throwable {
                            Throwable cause;
                            int i3 = 2 % 2;
                            _CREATION _creation = new _CREATION();
                            long[] jArr = new long[i2];
                            _creation.b = 0;
                            int i4 = $11 + 125;
                            $10 = i4 % 128;
                            while (true) {
                                int i5 = i4 % 2;
                                if (_creation.b >= i2) {
                                    break;
                                }
                                int i6 = _creation.b;
                                try {
                                    Object[] objArr2 = {Integer.valueOf(_CREATION[i + i6])};
                                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-587087340);
                                    if (objAccessartificialFrame == null) {
                                        byte b = (byte) 0;
                                        byte b2 = (byte) (b + 2);
                                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(View.getDefaultSize(0, 0) + 8, (char) (TextUtils.getTrimmedLength("") + 9279), Color.alpha(0) + 1977, 1113883676, false, $$e(b, b2, (byte) (b2 - 2)), new Class[]{Integer.TYPE});
                                    }
                                    Object[] objArr3 = {Long.valueOf(((Long) ((Method) objAccessartificialFrame).invoke(null, objArr2)).longValue()), Long.valueOf(i6), Long.valueOf(_BOUNDARY), Integer.valueOf(c)};
                                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1715896821);
                                    if (objAccessartificialFrame2 == null) {
                                        byte b3 = (byte) 0;
                                        byte b4 = b3;
                                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(30 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), (char) (TextUtils.getOffsetBefore("", 0) + 49362), Color.rgb(0, 0, 0) + 16777900, -115095555, false, $$e(b3, b4, b4), new Class[]{Long.TYPE, Long.TYPE, Long.TYPE, Integer.TYPE});
                                    }
                                    jArr[i6] = ((Long) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).longValue();
                                    Object[] objArr4 = {_creation, _creation};
                                    Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-293902099);
                                    if (objAccessartificialFrame3 == null) {
                                        byte b5 = (byte) 0;
                                        byte b6 = (byte) (b5 + 3);
                                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getPressedStateDuration() >> 16) + 25, (char) (30068 - View.getDefaultSize(0, 0)), 815 - TextUtils.indexOf((CharSequence) "", '0', 0), 1897803493, false, $$e(b5, b6, (byte) (b6 - 3)), new Class[]{Object.class, Object.class});
                                    }
                                    ((Method) objAccessartificialFrame3).invoke(null, objArr4);
                                    i4 = $10 + 91;
                                    $11 = i4 % 128;
                                } catch (Throwable th) {
                                    cause = th.getCause();
                                    if (cause != null) {
                                        throw th;
                                    }
                                    throw cause;
                                }
                                cause = th.getCause();
                                if (cause != null) {
                                    throw th;
                                }
                                throw cause;
                            }
                            char[] cArr = new char[i2];
                            _creation.b = 0;
                            while (_creation.b < i2) {
                                int i7 = $10 + 117;
                                $11 = i7 % 128;
                                int i8 = i7 % 2;
                                cArr[_creation.b] = (char) jArr[_creation.b];
                                Object[] objArr5 = {_creation, _creation};
                                Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-293902099);
                                if (objAccessartificialFrame4 == null) {
                                    byte b7 = (byte) 0;
                                    byte b8 = (byte) (b7 + 3);
                                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(25 - KeyEvent.normalizeMetaState(0), (char) (30067 - TextUtils.indexOf((CharSequence) "", '0')), (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 816, 1897803493, false, $$e(b7, b8, (byte) (b8 - 3)), new Class[]{Object.class, Object.class});
                                }
                                ((Method) objAccessartificialFrame4).invoke(null, objArr5);
                            }
                            objArr[0] = new String(cArr);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return "Failed to delivery initialization state to listener " + function1 + ".";
                        }

                        static {
                            char[] cArr = new char[1959];
                            ByteBuffer.wrap("\u0019Ñ×\u0096\u0085\u0083s¬!á\u001f¥ÍÙ»Æiú'ô\u0015ïÃ\t±\u0006o=]7\u000b.ùZ·@eCSi\u0001}ÿ]¬\u0085\u009a\u009aH¿\u0006±ô£\u0019Ñ×\u0096\u0085\u0083s¬!á\u001f¥ÍÙ»Æiú'ô\u0015ïÃ\t±\u0006o=]&\u000b#ùN·WeyS~\u0001~ÿp¬\u0095\u009a\u009eHºÉw\u00070U%£\nñGÏ\u0003\u001d\u007fk`¹\\÷RÅI\u0013¯a ¿\u009b\u008d\u0083Û\u0095)ög÷ÀÏ\u000e\u009f\\\u0081ª·øÿÆ±\u0014ÇbÐ°õþàÌý\u001aKh\u0017¶\u0013\u0084$Ò0 FnE¼K\u008alØO&~u\u0089C\u0080\u0091´ß©-ª{Ý\u0019Ñ×\u0097\u0085\u0092s¹!á\u001f¦ÍÑ»\u0084iî'à\u0015éÃ\nt-ºkèn\u001eEL\u001drM #Ö;\u0004LJ\u001ex\b®éÜâTÔ\u009a\u0084È\u0087>¼lªRµ\u0080×ö\u0080$ÉjÑXÎ\u008e\u0010ü\u001d\"\u0002\u0010\u0017F.´OúV\u0019Ñ×\u0096\u0085\u0087s®!¯\u001fíÍ\u0098»Éiî'ç\u0015ïÃ\u0014±\bo\r\u0019\u008c×\u009d\u0085Ès¸!¡\u001f\u00adÍÂ»\u0084iì'÷\u0015âÃ\b±\u0001o\u000b]2\u000b\u0015ùP·WeRSE\u0001jÿl¬\u0085\u009aÛ/\u008bá\u009a³ÏE¿\u0017¦)ªûÅ\u008d\u0083_ë\u0011ð#åõ\u000f\u0087\u0006Y\fk5=\u0012ÏW\u0081PSUeB7mÉk\u009a\u0082¬ßç4)d{z\u008dLß_áB3>E`\u0097\u0017Ù\u001eë\u0001=°Oç\u0091î£ÑõÁ\u0007¹Iù\u009b°\u00ad\u0090\u0019\u009c×\u009b\u0085\u0081s´!¡\u001fº\u0019¢×³º\u0019tI&WÐa\u0082r¼on\u0013\u0018MÊ4\u00843¶ `\u009d\u0012ÈÌÏþó¨÷Z \u0014·ÆÃð¼¢£\\§\u000fK9\u000fëu¥uW`\u0001\u00063\u0014í\u0005\u009f2\u0019Ñ×\u0081\u0085\u009fs©!º\u001f§ÍÛ»\u0085iü'û\u0015èÃU±\u0000o\u0007];\u000b?ùh·\u007fe\u000bSj\u0001|ÿm¬\u0086\u0019Ñ×\u0081\u0085\u009fs©!º\u001f§ÍÛ»\u0085iò'û\u0015äÃU±\u0002o\u000b]4\u000b$ù[·_eSSL\u0001Cÿr¬\u0084\u009a\u0085H®\u0006üôµ¢ÕØ\u0082\u0016ÅDÐ²ÿà²Þÿ\f\u0080z\u0094¨¸æ¦Ô \u0002LpN®E\u0019\u008c×\u009d\u0085Ès¸!»\u001f«ÍÚ»Îi°'ú\u0015éÃ\t±\u001a\u0019\u0090×\u0097\u0085\u0087s©!«\u001fìÍØ»Ïiê\u0019Ñ×\u0082\u0085\u0094sµ!\u00ad\u001fíÍÐ»Ãiò'÷\u0015õÃ\u0003±\u001do\u0016]3\u000b'ùM\u0015wÛp\u0089l\u007fH-Z\u0013C\u0019\u008c×\u009d\u0085Èsª!¼\u001f\u00adÍÒ»ßiý'æ\u0015¨Ã\u0017±\u000fo\f]#\u000b,ù_·QeRSo\u0001|ÿg¬\u0084\\>\u00920À/6\u0004\u0019\u008e×\u0097\u0085\u0094s©!§\u001f±ÍÂ»\u0084ií'ë\u0015õÃT±\fo\u0006]x\u000b.ù[·PeSS}\u0001 ÿe¬\u0086\u009a\u009fHð\u0006´ô§¢Ñ\u0090ËNý<ñêúØ\u000b\u0096-D\u00142?à Þ&\u008cSzX({æ`\u0019\u008e×\u0097\u0085\u0094s©!§\u001f±ÍÂ»\u0084ií'ë\u0015õÃT±\fo\u0006]x\u000b.ù[·PeSS}\u0001 ÿe¬\u0086\u009a\u009fHð\u0006´ô§¢Ñ\u0090ËNý<ñêúØ\u000b\u0096-D\u00102?à Þ&\u008cYzX[è\u0095ñÇò1ÏcÁ]×\u008f¤ùâ+\u008be\u008dW\u0093\u00812ój-`\u001f\u001eIH»=õ6'5\u0011\u001bCF½\u0016îÿØ¢\nÛDÅ¶É\u0086#H:\u001a9ì\u0004¾\n\u0080\u001cRo$)ö@¸F\u008aX\\ù.¡ð«ÂÕ\u0094\u0083fö(ýúþÌÐ\u009e\u008d`Ý34\u0005i×\u001f\u0099\u001ek\bÄ\u008c\n\u0095X\u0096®«ü¥Â³\u0010Àf\u0086´ïúéÈ÷\u001eVl\u000e²\u0004\u0080zÖ,$YjR¸Q\u008e\u007fÜ\"\"rq\u009bGÆ\u0095±Û³)§\u0019\u008e×\u0097\u0085\u0094s©!§\u001f±ÍÂ»\u0084ií'ë\u0015õÃT±\fo\u0006]x\u000b.ù[·PeSS}\u0001 ÿp¬\u0099\u009aÄH³\u0006¼ô¥ö\u00068\u001ej\u0007\u009c,Î3ð*Ô5\u001afHp¾QìIÒ\t\u0000?v!¤\u001eê\u0003Ø\u000e\u000eû|ù\u0089ÙGÁ\u0015Øãó±ø\u008fæ]\u0082+\u0088ù»\u0019¹×\u0097\u0085\u0088s£!£\u001f\u00adÍÂ»Ãiñ'ü\u0019\u008b×\u009c\u0085\u008ds´!¡\u001fµÍØ\u0019\u009d×\u009a\u0085\u0094sµ!£\u001f«ÍÃ»Ç\u001c¹Ò¨\u0080ýv\u009f$\u0089\u001a\u0098Èç¾êlÈ\"Ó\u0010\u009dÆ+´>j!X\n\u000e\u001cün\u0019\u0088×\u0090\u0085\u0089s¢!ö\u001fôÍÆbÊ¬ÄþÛ\bìZïdø¶\u0086\u0019\u0099×\u0097\u0085\u0088s¿!¼\u001f«ÍÕ»õiæ'ª\u0015°\u0019\u0099×\u0097\u0085\u0088s¿!¼\u001f«ÍÕ»õiæ'ª\u0015°Ã%±XoV\bKÆZ\u0094\u000fbm0{\u000ejÜ\u0015ª\u0018x:6!\u0004oÒÐ Æ~ÁLô\u001aá\u0019\u008d×\u0096\u0085\u008d\u0019\u009b×\u009f\u0085\u0093s¶!¯\u001f¶ÍÙ»Ø\u0019¿×\u0082\u0085\u0096sú!\u009c\u001f·ÍØ»Þi÷'ÿ\u0015ãÃZ±\bo\r]$\u000bjù}·ZeTSu\u0001cÿgs\u001d½>ï \u0019\nK\u0003u\t§pÑ(\u0003oMt\u007fo©øÛ®\u0005µ7\u009da\u0084\u0093èÝ°\u000fâ9×kÞ\u0095\u0080Æ,ðp\"J¼êrÉ ×Öý\u0084ôºþh\u0087\u001eßÌ\u0098\u0082\u0083°\u0098f\u000f\u0014YÊBøj®s\\\u001f\u0012GÀ\u0015ö ¤)Zw\tÛ?\u0087í½£ØQ¥\u0007Û2\u0082ü\u0093®ÆX¼\n¡4¾æÜ\u0090ÓBñ\fî>í\u0012!Ü%\u008e2x\u0006*\u0010\u0014\u0013Æ}°zÿÆ1ÞcÇ\u0095ìÇ¸ùº\u0019\u008c×\u0093\u0085\u0088s¹!¦\u001f·\u0019\u008c×\u009d\u0085Èsª!¼\u001f\u00adÍÒ»ßiý'æ\u0015¨Ã\u0018±\u001co\u0003]8\u000b.\u0019\u008c×\u009d\u0085Ès±!«\u001f°ÍØ»Ïiò'¼\u0015÷Ã\u001f±\u0003o\u0017\u0019Ïyï·þå«\u0013ÊAÈ\u007fÂ\u00ad Û»\t\u0098\u0019Î\u001e\u0088Ð\u0099\u0082Ìt¼&¿\u0018¯ÊÞ¼Ên´ æ\u0012ðÄ\u0011¶\u000eh\u0013Z1\f:\u0019\u0098×\u0087\u0085\u008as¶!\u0091\u001fºÍ\u008e»\u009cB\u0087\u008c\u0096ÞÃ(³z°D \u0096ÑàÅ2»|ÿNä\u0098\u001fê\u00024\f\u0006/P1¢GìP>C\be\u0019\u0099×\u0097\u0085\u0088s¿!¼\u001f«ÍÕ»\u0085ií'ö\u0015íÃU±\to\u0007]8\u000b/ùL·[eE\u0019\u0099×\u0097\u0085\u0088s¿!¼\u001f«ÍÕ»õiæ'ª\u0015°ÃU±\u001do\u0006]=\u000b\u0015ùF·\ne\u0010S5\u0001iÿg¬\u0098\u009a\u008fH¬\u0006»ô¥¢å\u0090ÖN\u009a< ÿd1jcu\u0095BÇAùV+(]x\u008f\u0004Á\u0000ó\u0014%àWÿ\u0089ú»ôíÄ\u001f§Q¤\u0083ôµ\u0080ç\u0096\u0019\u0091Jn|e®JàL\u0019\u0099×\u0097\u0085\u0088s¿!¼\u001f«ÍÕ»\u0085iè'ð\u0015éÃ\u0002±VoT]&\u000beùH·PeISb\u00016ÿ4¬\u0086\u0019\u0099×\u009d\u0085\u0089s½!¢\u001f§Í\u0099»Ùiú'ù\u0015ÙÃ\u001d±\u001eo\n]9\u000b$ù[·me^S\"\u00018ÿ-¬\u0091\u009a\u008fH°\u0006·ô´¢Ó\u0090ÍNý<îê²ØH«\u008ce\u009d7ÈÁ¸\u0093¡\u00ad\u00ad\u007fÂ\tÆÛñ\u0095ó§âq\u001f\u0003\u001cJß\u0084ÎÖ\u009b ëròLþ\u009e\u0091è\u0090: t F²\u0090Lâ\u0013<S\u000epXpª\u0001ä\u00056[\u0000/R4¬?ÿÂÉÜ\u001bÿUñ§çñ\u0080Ã\u0093\u001d\u0085\u0019¿×\u009c\u0085\u0082s¨!¡\u001f«ÍÒ»\u0087iæ'ª\u0015°ºmt|&)ÐY\u0082Z¼Jn;\u0018/ÊQ\u0084\u0017¶\u000e`è\u0012ÿÌïþÖ¨ÒZñ\u0014ºÆ£\u0085\u0087K\u009a\u0019\u0098ï£½î=6ó=¡.W\u000f\u0005A;\u0010éa\u009fhM\u0011\u0003B1Bç¶\u0095ºKîy\u0087/\u0099Ýð\u0093ãAô\u0094&Z>\b\"þ\u0006¬I\u0092\u0003@h6-äZªZ\u0098FN½<¬â®Ð\u0086\u0086\u0090\u0019\u008f×\u0097\u0085\u008bs¯!à\u001f±ÍÐ»\u0084iø'ó\u0015íÃ\u001f±1o\u0001]7\u000b'ù[·@eG{yµaç}\u0011YC\u0016}G¯&Ùr\u000b\u0004E\u0007w\u0014¡ÓÓü\rñ?ÎiÏ\u009b¡Õ°\u0007©\u0019\u008c×\u009d\u0085Ès±!«\u001f°ÍØ»Ïiò'¼\u0015çÃ\u0014±\no\u0010]9\u000b#ùZ·\u001ceWS\u007f\u0001cÿw¬\u0092\u0019\u008c×\u009d\u0085Ès¸!¡\u001f\u00adÍÂ»\u0084iï'÷\u0015ëÃ\u000f±@o\u0003] \u000b.ùa·\\eGSw\u0001k\"öìç¾²HÏ\u001aÐ$Õöâ\u0080²R\u0091\u001c\u0081.\u0090ød\u008a:T~fE0^Â#\u008c-^.h\u0010:\u0006Ä\u0011\u0097â¡ä\u0004CÊR\u0098\u0007ne<s\u0002bÐ\u001d¦\u0010t2:)\bgÞ×¬ÔrÄ@õ\u0016áäßª\u009bx\u0080N»\u001c¦â¨±K\u0087UUc\u001btég¿\u0001\u0019\u008c×\u009d\u0085Ès©!·\u001f±ÍÂ»Ïió'¼\u0015äÃ\u000f±\u0007o\u000e]2\u000bdùX·[eHS}\u0001kÿp¬\u0086\u009a\u0098H·\u0006¼ô²ö^8Oj\u001a\u009c{Îeðc\"\u0010T\u001d\u0086!È\u001fú1,Ð^È\u0080\u009e²æäí\u0016\u0085X\u008c\u008a\u0090¼æîº\u0010¹CJu_§iér\u001bdM\u001a\u007f\u0015¡\u001eÓ0'ÕéÄ»\u0091Mõ\u001fò!õó\u008b\u0085\u009cWµ\u0019å+½ýV\u008f^QWck5=Ç\u0001\u0089\u0002[\u0011m$?2Á)\u0092ß¤Ávî8åÊë\u0010ðÞá\u008c´zÐ(×\u0016ÐÄ®²¹`\u0090.±\u001c\u009eÊj¸yfsT\u0004\u0002Tð7¾'l6Z\u0002\b\\ö\u0018¥ã\u0093øAÅ\u000fËýÈ«¶\u0099 G·5\u0084ã\u0082J\u000e\u0019Ñ×\u0096\u0085\u0083s¬!á\u001f³ÍÓ»Çië'Í\u0015öÃ\u0013±\u001eo\u0007å\u0003+DyQ\u008f~Ý3ãc1\u000bG\u001b\u0095'Û%é ?\u0087MÞ\u0093Ñ¡÷÷ý\u0005\u008eK\u0081\u0099\u009a¯¬ý\u0083\u0003·PAfV´uúd\u0019Ñ×\u0096\u0085\u0083s¬!á\u001f±ÍÙ»Éiõ'÷\u0015òÃU±\to\u0007]8\u000b3ùZ\u0019Ñ×\u0096\u0085\u0083s¬!á\u001f±ÍÙ»Éiõ'÷\u0015òÃU±\u001fo\u0007];\u000b?ùZ*çä·¶©@\u009f\u0012×,\u0085þå\u0088ñZÝ\u0014û&Äð>\u00829\\7n\u0005\u0019Ñ×\u0081\u0085\u009fs©!º\u001f§ÍÛ»\u0085iò'û\u0015äÃU±\u0002o\u000b]4\u000b)ùa·_eGSv\u0001bÿm¬\u0095\u009aµHº\u0006·ô¤¢Ï\u0090ÉNý<çêïØ\u0013\u0096\u0007DH2)à!\u0095u[2\t'ÿ\b\u00adE\u0093\u0004Aa7zåe«Q\u0099RO\u00ad\u0019Ñ×\u0096\u0085\u0083s¬!á\u001f ÍÅ»ÞiÁ'æ\u0015ïÃ\u0017±\u000b\u0084ØJ\u009f\u0018\u008aî¥¼è\u0082¸PÐ&Àôüºþ\u0088û^\\,\u0005ò\u0018À+\u0096%dX*WøKÎv\u009cubo%\tëY¹GOq\u001db#\u007fñ\u0003\u0087]U*\u001b#)<ÿ\u008d\u008dÚSÓaì7ðÅ\u0095\u008b\u009eY\u0098o\u00ad=ºÃ¾\u0090K¦@tY:`Èp\u009e\u000b¬Xr\t\u0000!\u0019Ñ×\u0096\u0085\u0083s¬!á\u001f ÍÅ»Þiÿ'ñ\u0015åÃ\u001fK«\u0085ì×ù!Ös\u009bMÚ\u009f¿é¤;\u0083u\u0091G\u008e\u0091o\u0019Ñ×\u0096\u0085\u0083s¬!á\u001f ÍÅ»Þió'÷\u0015áÃ\u0014¸çv $µÒ\u009a\u0080×¾\u0096ló\u001aèÈÇ\u0086Ö´Ùb)ä©*îxû\u008eÔÜ\u0099âØ0½F¦\u0094\u0090Ú\u0087è\u008d>e=\"óe¡pW_\u0005\u0012;Sé6\u009f-M\u001d\u0003\u00061\u0014çà\u0095íKòVÃ\u0098\u0084Ê\u0091<¾nóP²\u0082×ôÌ&ÓhéZù\u008c\rØó\u0016´D¥²\u008cà\u008dÞÏ\fðzç¨ËæÞÔÈ\u00027p-®$\u009c\u0007ÊG82vh¤f\u0092\u0017ÀN>Sm [£\u0019Ñ×\u009f\u0085\u0088s®!á\u001fµÍß»Äiú'ý\u0015ñÃ\t±Ao ]%\u000b>ùm·ZeGSh\u0001kÿf¬°\u009a\u0085H²\u0006¶ô£¢Èþ\u00110BbT\u0094uÆmø-*\u001f\\\u0005\u008e.À=ò4$ÎVÝ\u0019Î×\u0094\u0085\u0080sú!ôªad26$À\u0005\u0092\u001d¬]~u\b\u007fÚB\u0094D¦\u0019p§\u0002¿Ü¢î\u0095¢ÔlÍ>ÊÈû\u009aï¤àv\u0098\u0000ÉÒ´\u009c°®§xS\nEÔFæh°oB]\f\fÞ\u0004 ÌîÅ¼ÚJÃ\u0018Ü&Ùô»\u0082«P¢\u001e¿,¬ú\n\u0088CVSÞ \u0010fBc´Hæ\u0010Ø^\n\"|?®\u0006à\u0002Ò(\u0004èvð¨÷\u009aÂÌØ>¼pí¢¯\u0094\u0086Æ\u0093\u0019\u009c×\u009e\u0085\u0093s¿!½\u001f¶Í×»Éiõ'áñF?\u0000m\u0005\u009b.Év÷8%NSH\u0081gÏqýb\u0019Ñ×\u0096\u0085\u0087s®!¯\u001fíÍÒ»Åié'ü\u0015êÃ\u0015±\u000fo\u0006]%\u000beù\u0010·VeVS5\u0001oÿr¬\u0086\u009a\u0099Hð\u0006ªô«¢Ö·vy%+3Ý\u0012\u008f\n±Jcr\u0015}ÇL\u0089\\»Om»\u001f¦\u0019¹×\u009d\u0085\u008as¾!¨\u001f«ÍÅ»Â\u0019Ñ×\u0096\u0085\u0087s®!¯\u001fíÍÛ»Ãií'ñ\u0015©Ã\n±\u001co\r]0\u000b#ùR·WeUS5\u0001mÿw¬\u0084\u009aÅHî\u0006ýô¥¢Õ\u0090ÃN\u008c<ûêãØ\u001d\u0096\u0000D\t2,à'Þ0\u008cBz\u0004(sæwÔk\u0085\u008fs\u0087!\u008f\u001f³".getBytes(CharEncoding.ISO_8859_1)).asCharBuffer().get(cArr, 0, 1959);
                            _CREATION = cArr;
                            _BOUNDARY = 1655663808064051186L;
                        }

                        /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
                            java.util.NoSuchElementException
                            	at java.base/java.util.TreeMap.key(Unknown Source)
                            	at java.base/java.util.TreeMap.lastKey(Unknown Source)
                            	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
                            	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
                            	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
                            */
                        public static java.lang.Object[] CoroutineDebuggingKt(android.content.Context r73, int r74, int r75, int r76) {
                            /*
                                Method dump skipped, instruction units count: 15474
                                To view this dump change 'Code comments level' option to 'DEBUG'
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.sfmcsdk.SFMCSdk$Companion$notifyInitializationStatusListener$1.CoroutineDebuggingKt(android.content.Context, int, int, int):java.lang.Object[]");
                        }
                    });
                }
            }
        }

        private final void staticTearDown() {
            SFMCSdk sFMCSdk = SFMCSdk.instance;
            if (sFMCSdk != null) {
                Iterator it2 = sFMCSdk.modules.iterator();
                while (it2.hasNext()) {
                    ((Module) it2.next()).tearDown();
                }
            }
            EventManager.Companion.staticTearDown$sfmcsdk_release();
            SFMCSdk.UNIFIED_SDK_INSTANCE_REQUESTS.clear();
            SFMCSdk.instance = null;
            SFMCSdk.initializationState = InitializationState.NONE;
        }

        @JvmStatic
        public final void requestSdk(@NotNull SFMCSdkReadyListener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            final WhenReadyHandler whenReadyHandler = new WhenReadyHandler(listener);
            synchronized (SFMCSdk.UNIFIED_SDK_INSTANCE_REQUESTS) {
                if (WhenMappings.$EnumSwitchMapping$0[SFMCSdk.initializationState.ordinal()] == 1) {
                    try {
                        SFMCSdk sFMCSdk = SFMCSdk.instance;
                        if (sFMCSdk != null) {
                            whenReadyHandler.deliverSdk(sFMCSdk);
                            Unit unit = Unit.INSTANCE;
                        }
                    } catch (Exception e) {
                        SFMCSdkLogger.INSTANCE.e(SFMCSdk.TAG, e, new Function0<String>() { // from class: com.salesforce.marketingcloud.sfmcsdk.SFMCSdk$Companion$requestSdk$1$2
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return "Failure during requestSdk() delivery for " + whenReadyHandler + ".";
                            }
                        });
                        Unit unit2 = Unit.INSTANCE;
                    }
                } else {
                    SFMCSdk.UNIFIED_SDK_INSTANCE_REQUESTS.add(whenReadyHandler);
                }
            }
        }

        @JvmStatic
        public final void track(@NotNull final Event... events) {
            Intrinsics.checkNotNullParameter(events, "events");
            requestSdk(new SFMCSdkReadyListener() { // from class: com.salesforce.marketingcloud.sfmcsdk.SFMCSdk$Companion$$ExternalSyntheticLambda0
                @Override // com.salesforce.marketingcloud.sfmcsdk.SFMCSdkReadyListener
                public final void ready(SFMCSdk sFMCSdk) {
                    SFMCSdk.Companion.track$lambda$16(events, sFMCSdk);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void track$lambda$16(Event[] events, SFMCSdk sdk) {
            Intrinsics.checkNotNullParameter(events, "$events");
            Intrinsics.checkNotNullParameter(sdk, "sdk");
            sdk.internalTrack((Event[]) Arrays.copyOf(events, events.length));
        }

        @JvmStatic
        public final void setLogging(@NotNull LogLevel level, @Nullable LogListener logListener) {
            Intrinsics.checkNotNullParameter(level, "level");
            SFMCSdkLogger sFMCSdkLogger = SFMCSdkLogger.INSTANCE;
            sFMCSdkLogger.setLogLevel(level);
            sFMCSdkLogger.setListener(logListener);
        }
    }

    static {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        Intrinsics.checkNotNullExpressionValue(executorServiceNewSingleThreadExecutor, "newSingleThreadExecutor(...)");
        behaviorManager = new BehaviorManagerImpl(executorServiceNewSingleThreadExecutor);
        initializationState = InitializationState.NONE;
        UNIFIED_SDK_INSTANCE_REQUESTS = new ArrayList();
        SDK_LOCK = new Object();
    }

    public final JSONObject getSdkState() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("sfmcSDKVersion", "1.0.5");
        for (Module module : this.modules) {
            jSONObject.put(module.getName(), module.getState());
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void internalTrack(final Event... eventArr) {
        if (eventArr != null) {
            try {
                SFMCSdkLogger.INSTANCE.d(TAG, new Function0<String>() { // from class: com.salesforce.marketingcloud.sfmcsdk.SFMCSdk$internalTrack$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        String str = "";
                        for (Event event : ArraysKt___ArraysKt.filterNotNull(eventArr)) {
                            String str2 = StringsKt__StringsKt.isBlank(str) ? "" : ", ";
                            str = str + str2 + Reflection.getOrCreateKotlinClass(event.getClass()).getSimpleName() + "( " + event.name() + " )";
                        }
                        return "Tracking events: " + ((Object) str);
                    }
                });
            } catch (Exception unused) {
            }
            EventManager.Companion.publish$sfmcsdk_release(this.executors, (Event[]) Arrays.copyOf(eventArr, eventArr.length));
        }
    }

    public final void mp(@NotNull PushModuleReadyListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        pushModule.requestModule(listener);
    }

    public final void cdp(@NotNull CdpModuleReadyListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        cdpModule.requestModule(listener);
    }

    public final Identity getIdentity() {
        Identity identity = this.identity;
        if (identity != null) {
            return identity;
        }
        Intrinsics.throwUninitializedPropertyAccessException(InterpolationAnimatedNode.EXTRAPOLATE_TYPE_IDENTITY);
        return null;
    }

    public final void setIdentity(@NotNull Identity identity) {
        Intrinsics.checkNotNullParameter(identity, "<set-?>");
        this.identity = identity;
    }
}
