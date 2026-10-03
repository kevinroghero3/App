package com.salesforce.marketingcloud.sfmcsdk.modules;

import android.content.Context;
import com.salesforce.marketingcloud.sfmcsdk.InitializationState;
import com.salesforce.marketingcloud.sfmcsdk.SFMCSdkComponents;
import com.salesforce.marketingcloud.sfmcsdk.components.identity.ModuleIdentity;
import com.salesforce.marketingcloud.sfmcsdk.components.logging.SFMCSdkLogger;
import com.salesforce.marketingcloud.sfmcsdk.components.utils.NamedRunnable;
import com.salesforce.marketingcloud.sfmcsdk.modules.cdp.CdpModuleInterface;
import com.salesforce.marketingcloud.sfmcsdk.modules.push.PushModule;
import com.salesforce.marketingcloud.sfmcsdk.modules.push.PushModuleInterface;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.NotImplementedError;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Module {
    private final List<ModuleReadyHandler> MODULE_INSTANCE_REQUESTS = new ArrayList();
    private InitializationState initializationState = InitializationState.NONE;
    private ModuleInterface module;

    /* JADX INFO: loaded from: classes6.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[InitializationState.values().length];
            try {
                iArr[InitializationState.READY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[InitializationState.NONE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[InitializationState.ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    protected static /* synthetic */ void getMODULE_INSTANCE_REQUESTS$annotations() {
    }

    public abstract String getName();

    protected final List<ModuleReadyHandler> getMODULE_INSTANCE_REQUESTS() {
        return this.MODULE_INSTANCE_REQUESTS;
    }

    protected final InitializationState getInitializationState() {
        return this.initializationState;
    }

    protected final void setInitializationState(@NotNull InitializationState initializationState) {
        Intrinsics.checkNotNullParameter(initializationState, "<set-?>");
        this.initializationState = initializationState;
    }

    protected final ModuleInterface getModule() {
        return this.module;
    }

    protected final void setModule(@Nullable ModuleInterface moduleInterface) {
        this.module = moduleInterface;
    }

    public final void requestModule(@NotNull ModuleReadyListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        final ModuleReadyHandler moduleReadyHandler = new ModuleReadyHandler(listener);
        synchronized (this.MODULE_INSTANCE_REQUESTS) {
            if (WhenMappings.$EnumSwitchMapping$0[this.initializationState.ordinal()] == 1) {
                try {
                    ModuleInterface moduleInterface = this.module;
                    if (moduleInterface != null) {
                        moduleReadyHandler.deliverModule(moduleInterface);
                        Unit unit = Unit.INSTANCE;
                    }
                } catch (Exception e) {
                    SFMCSdkLogger.INSTANCE.e(PushModule.TAG, e, new Function0<String>() { // from class: com.salesforce.marketingcloud.sfmcsdk.modules.Module$requestModule$1$2
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return "Failure during requestPush() delivery for " + moduleReadyHandler + ".";
                        }
                    });
                    Unit unit2 = Unit.INSTANCE;
                }
            } else {
                this.MODULE_INSTANCE_REQUESTS.add(moduleReadyHandler);
            }
        }
    }

    public final void tearDown() {
        this.MODULE_INSTANCE_REQUESTS.clear();
        this.module = null;
        this.initializationState = InitializationState.NONE;
    }

    public final ModuleIdentity getIdentity() {
        ModuleIdentity moduleIdentity;
        ModuleInterface moduleInterface = this.module;
        if (moduleInterface != null && (moduleIdentity = moduleInterface.getModuleIdentity()) != null) {
            return moduleIdentity;
        }
        throw new NotImplementedError("An operation is not implemented: Your module must implement getIdentity().");
    }

    public final JSONObject getState() throws JSONException {
        JSONObject jSONObjectPut;
        ModuleInterface moduleInterface = this.module;
        if (moduleInterface == null || (jSONObjectPut = moduleInterface.getState()) == null) {
            JSONObject jSONObject = new JSONObject();
            int i = WhenMappings.$EnumSwitchMapping$0[this.initializationState.ordinal()];
            if (i == 2) {
                jSONObjectPut = jSONObject.put("INITIALIZATION_STATUS", "NOT IMPLEMENTED OR NOT INITIALIZED");
            } else if (i == 3) {
                jSONObjectPut = jSONObject.put("INITIALIZATION_STATUS", "ERROR");
            } else {
                jSONObjectPut = jSONObject.put("INITIALIZATION_STATUS", "NOT READY");
            }
            Intrinsics.checkNotNullExpressionValue(jSONObjectPut, "run(...)");
        }
        return jSONObjectPut;
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.sfmcsdk.modules.Module$initModule$1, reason: invalid class name */
    public static final class AnonymousClass1 extends NamedRunnable {
        final /* synthetic */ SFMCSdkComponents $components;
        final /* synthetic */ Config $config;
        final /* synthetic */ Context $context;
        final /* synthetic */ ModuleReadyListener $listener;

        /* JADX INFO: renamed from: com.salesforce.marketingcloud.sfmcsdk.modules.Module$initModule$1$WhenMappings */
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

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Config config, Context context, SFMCSdkComponents sFMCSdkComponents, ModuleReadyListener moduleReadyListener, String str, Object[] objArr) {
            super(str, objArr);
            this.$config = config;
            this.$context = context;
            this.$components = sFMCSdkComponents;
            this.$listener = moduleReadyListener;
        }

        @Override // com.salesforce.marketingcloud.sfmcsdk.components.utils.NamedRunnable
        public void execute() {
            Module.this.setInitializationState(InitializationState.INITIALIZING);
            SFMCSdkLogger sFMCSdkLogger = SFMCSdkLogger.INSTANCE;
            String name = getName();
            final Config config = this.$config;
            sFMCSdkLogger.d(name, new Function0<String>() { // from class: com.salesforce.marketingcloud.sfmcsdk.modules.Module$initModule$1$execute$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "~~ " + config.getModuleIdentifier().name() + " Module Initialization Started ~~";
                }
            });
            final Config config2 = this.$config;
            Context context = this.$context;
            SFMCSdkComponents sFMCSdkComponents = this.$components;
            final Module module = Module.this;
            final ModuleReadyListener moduleReadyListener = this.$listener;
            config2.init(context, sFMCSdkComponents, new ModuleReadyListener() { // from class: com.salesforce.marketingcloud.sfmcsdk.modules.Module$initModule$1$$ExternalSyntheticLambda0
                @Override // com.salesforce.marketingcloud.sfmcsdk.modules.ModuleReadyListener
                public final void ready(ModuleInterface moduleInterface) {
                    Module.AnonymousClass1.execute$lambda$2(this.f$0, module, config2, moduleReadyListener, moduleInterface);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void execute$lambda$2(AnonymousClass1 this$0, Module this$1, final Config config, ModuleReadyListener listener, final ModuleInterface it2) {
            ModuleInterface moduleInterface;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            Intrinsics.checkNotNullParameter(config, "$config");
            Intrinsics.checkNotNullParameter(listener, "$listener");
            Intrinsics.checkNotNullParameter(it2, "it");
            SFMCSdkLogger.INSTANCE.d(this$0.getName(), new Function0<String>() { // from class: com.salesforce.marketingcloud.sfmcsdk.modules.Module$initModule$1$execute$2$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "~~ " + config.getModuleIdentifier().name() + " Module Initialization Completed ~~";
                }
            });
            int i = WhenMappings.$EnumSwitchMapping$0[config.getModuleIdentifier().ordinal()];
            if (i == 1) {
                moduleInterface = (PushModuleInterface) it2;
            } else {
                if (i != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                moduleInterface = (CdpModuleInterface) it2;
            }
            this$1.setModule(moduleInterface);
            listener.ready(it2);
            this$1.setInitializationState(InitializationState.READY);
            synchronized (this$1.getMODULE_INSTANCE_REQUESTS()) {
                for (final ModuleReadyHandler moduleReadyHandler : this$1.getMODULE_INSTANCE_REQUESTS()) {
                    try {
                        moduleReadyHandler.deliverModule(it2);
                    } catch (Exception e) {
                        SFMCSdkLogger.INSTANCE.e(PushModule.TAG, e, new Function0<String>() { // from class: com.salesforce.marketingcloud.sfmcsdk.modules.Module$initModule$1$execute$2$2$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return "Failure during module " + it2 + " delivery for " + moduleReadyHandler + ".";
                            }
                        });
                    }
                }
                this$1.getMODULE_INSTANCE_REQUESTS().clear();
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final void initModule(@NotNull Context context, @NotNull Config config, @NotNull SFMCSdkComponents components, @NotNull ModuleReadyListener listener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(components, "components");
        Intrinsics.checkNotNullParameter(listener, "listener");
        try {
            components.getExecutors().getDiskIO().execute(new AnonymousClass1(config, context, components, listener, config.getModuleIdentifier().name() + "_init_thread", new Object[0]));
        } catch (Error e) {
            SFMCSdkLogger.INSTANCE.w(getName(), e, new Function0<String>() { // from class: com.salesforce.marketingcloud.sfmcsdk.modules.Module.initModule.3
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "An error occurred while initializing module " + Module.this;
                }
            });
        } catch (Exception e2) {
            SFMCSdkLogger.INSTANCE.w(getName(), e2, new Function0<String>() { // from class: com.salesforce.marketingcloud.sfmcsdk.modules.Module.initModule.2
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "An exception occurred while initializing module " + Module.this;
                }
            });
        }
    }
}
