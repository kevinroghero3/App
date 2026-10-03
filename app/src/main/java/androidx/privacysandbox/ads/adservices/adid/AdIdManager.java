package androidx.privacysandbox.ads.adservices.adid;

import android.content.Context;
import androidx.core.os.OutcomeReceiverKt;
import androidx.privacysandbox.ads.adservices.internal.AdServicesInfo;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AdIdManager {
    public static final Companion Companion = new Companion(null);

    @JvmStatic
    public static final AdIdManager obtain(@NotNull Context context) {
        return Companion.obtain(context);
    }

    public abstract Object getAdId(@NotNull Continuation<? super AdId> continuation);

    static final class Api33Ext4Impl extends AdIdManager {
        private final android.adservices.adid.AdIdManager mAdIdManager;

        public Api33Ext4Impl(@NotNull android.adservices.adid.AdIdManager mAdIdManager) {
            Intrinsics.checkNotNullParameter(mAdIdManager, "mAdIdManager");
            this.mAdIdManager = mAdIdManager;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public Api33Ext4Impl(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Object systemService = context.getSystemService((Class<Object>) AdIdManager$Api33Ext4Impl$$ExternalSyntheticApiModelOutline3.m());
            Intrinsics.checkNotNullExpressionValue(systemService, "context.getSystemService…:class.java\n            )");
            this(AdIdManager$Api33Ext4Impl$$ExternalSyntheticApiModelOutline4.m(systemService));
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        @Override // androidx.privacysandbox.ads.adservices.adid.AdIdManager
        public Object getAdId(@NotNull Continuation<? super AdId> continuation) {
            AdIdManager$Api33Ext4Impl$getAdId$1 adIdManager$Api33Ext4Impl$getAdId$1;
            Api33Ext4Impl api33Ext4Impl;
            if (continuation instanceof AdIdManager$Api33Ext4Impl$getAdId$1) {
                adIdManager$Api33Ext4Impl$getAdId$1 = (AdIdManager$Api33Ext4Impl$getAdId$1) continuation;
                int i = adIdManager$Api33Ext4Impl$getAdId$1.label;
                if ((i & Integer.MIN_VALUE) != 0) {
                    adIdManager$Api33Ext4Impl$getAdId$1.label = i - Integer.MIN_VALUE;
                } else {
                    adIdManager$Api33Ext4Impl$getAdId$1 = new AdIdManager$Api33Ext4Impl$getAdId$1(this, continuation);
                }
            } else {
                adIdManager$Api33Ext4Impl$getAdId$1 = new AdIdManager$Api33Ext4Impl$getAdId$1(this, continuation);
            }
            Object adIdAsyncInternal = adIdManager$Api33Ext4Impl$getAdId$1.result;
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = adIdManager$Api33Ext4Impl$getAdId$1.label;
            if (i2 == 0) {
                ResultKt.throwOnFailure(adIdAsyncInternal);
                adIdManager$Api33Ext4Impl$getAdId$1.L$0 = this;
                adIdManager$Api33Ext4Impl$getAdId$1.label = 1;
                adIdAsyncInternal = getAdIdAsyncInternal(adIdManager$Api33Ext4Impl$getAdId$1);
                if (adIdAsyncInternal == coroutine_suspended) {
                    return coroutine_suspended;
                }
                api33Ext4Impl = this;
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                api33Ext4Impl = (Api33Ext4Impl) adIdManager$Api33Ext4Impl$getAdId$1.L$0;
                ResultKt.throwOnFailure(adIdAsyncInternal);
            }
            return api33Ext4Impl.convertResponse(AdIdManager$Api33Ext4Impl$$ExternalSyntheticApiModelOutline2.m(adIdAsyncInternal));
        }

        private final AdId convertResponse(android.adservices.adid.AdId adId) {
            String adId2 = adId.getAdId();
            Intrinsics.checkNotNullExpressionValue(adId2, "response.adId");
            return new AdId(adId2, adId.isLimitAdTrackingEnabled());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Object getAdIdAsyncInternal(Continuation<? super android.adservices.adid.AdId> continuation) {
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
            cancellableContinuationImpl.initCancellability();
            this.mAdIdManager.getAdId(new AdIdManager$Api33Ext4Impl$$ExternalSyntheticLambda6(), OutcomeReceiverKt.asOutcomeReceiver(cancellableContinuationImpl));
            Object result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return result;
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final AdIdManager obtain(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (AdServicesInfo.INSTANCE.version() >= 4) {
                return new Api33Ext4Impl(context);
            }
            return null;
        }
    }
}
