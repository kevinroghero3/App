package io.sentry.util;

import io.sentry.Baggage;
import io.sentry.BaggageHeader;
import io.sentry.FilterString;
import io.sentry.IScope;
import io.sentry.IScopes;
import io.sentry.ISpan;
import io.sentry.NoOpLogger;
import io.sentry.PropagationContext;
import io.sentry.Scope;
import io.sentry.ScopeCallback;
import io.sentry.SentryOptions;
import io.sentry.SentryTraceHeader;
import io.sentry.TracesSamplingDecision;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class TracingUtils {
    public static void startNewTrace(@NotNull IScopes iScopes) {
        iScopes.configureScope(new ScopeCallback() { // from class: io.sentry.util.TracingUtils$$ExternalSyntheticLambda5
            @Override // io.sentry.ScopeCallback
            public final void run(IScope iScope) {
                TracingUtils.lambda$startNewTrace$1(iScope);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$startNewTrace$1(final IScope iScope) {
        iScope.withPropagationContext(new Scope.IWithPropagationContext() { // from class: io.sentry.util.TracingUtils$$ExternalSyntheticLambda2
            @Override // io.sentry.Scope.IWithPropagationContext
            public final void accept(PropagationContext propagationContext) {
                TracingUtils.lambda$startNewTrace$0(iScope, propagationContext);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$startNewTrace$0(IScope iScope, PropagationContext propagationContext) {
        iScope.setPropagationContext(new PropagationContext());
    }

    public static void setTrace(@NotNull IScopes iScopes, @NotNull final PropagationContext propagationContext) {
        iScopes.configureScope(new ScopeCallback() { // from class: io.sentry.util.TracingUtils$$ExternalSyntheticLambda0
            @Override // io.sentry.ScopeCallback
            public final void run(IScope iScope) {
                TracingUtils.lambda$setTrace$3(propagationContext, iScope);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$setTrace$3(final PropagationContext propagationContext, final IScope iScope) {
        iScope.withPropagationContext(new Scope.IWithPropagationContext() { // from class: io.sentry.util.TracingUtils$$ExternalSyntheticLambda1
            @Override // io.sentry.Scope.IWithPropagationContext
            public final void accept(PropagationContext propagationContext2) {
                iScope.setPropagationContext(propagationContext);
            }
        });
    }

    public static TracingHeaders traceIfAllowed(@NotNull IScopes iScopes, @NotNull String str, @Nullable List<String> list, @Nullable ISpan iSpan) {
        SentryOptions options = iScopes.getOptions();
        if (options.isTraceSampling() && shouldAttachTracingHeaders(str, options)) {
            return trace(iScopes, list, iSpan);
        }
        return null;
    }

    public static TracingHeaders trace(@NotNull IScopes iScopes, @Nullable List<String> list, @Nullable ISpan iSpan) {
        final SentryOptions options = iScopes.getOptions();
        if (iSpan != null && !iSpan.isNoOp()) {
            return new TracingHeaders(iSpan.toSentryTrace(), iSpan.toBaggageHeader(list));
        }
        final PropagationContextHolder propagationContextHolder = new PropagationContextHolder();
        iScopes.configureScope(new ScopeCallback() { // from class: io.sentry.util.TracingUtils$$ExternalSyntheticLambda4
            @Override // io.sentry.ScopeCallback
            public final void run(IScope iScope) {
                TracingUtils.lambda$trace$4(propagationContextHolder, options, iScope);
            }
        });
        if (propagationContextHolder.propagationContext == null) {
            return null;
        }
        PropagationContext propagationContext = propagationContextHolder.propagationContext;
        return new TracingHeaders(new SentryTraceHeader(propagationContext.getTraceId(), propagationContext.getSpanId(), propagationContext.isSampled()), BaggageHeader.fromBaggageAndOutgoingHeader(propagationContext.getBaggage(), list));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$trace$4(PropagationContextHolder propagationContextHolder, SentryOptions sentryOptions, IScope iScope) {
        propagationContextHolder.propagationContext = maybeUpdateBaggage(iScope, sentryOptions);
    }

    public static PropagationContext maybeUpdateBaggage(@NotNull final IScope iScope, @NotNull final SentryOptions sentryOptions) {
        return iScope.withPropagationContext(new Scope.IWithPropagationContext() { // from class: io.sentry.util.TracingUtils$$ExternalSyntheticLambda3
            @Override // io.sentry.Scope.IWithPropagationContext
            public final void accept(PropagationContext propagationContext) {
                TracingUtils.lambda$maybeUpdateBaggage$5(iScope, sentryOptions, propagationContext);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$maybeUpdateBaggage$5(IScope iScope, SentryOptions sentryOptions, PropagationContext propagationContext) {
        Baggage baggage = propagationContext.getBaggage();
        if (baggage.isMutable()) {
            baggage.setValuesFromScope(iScope, sentryOptions);
            baggage.freeze();
        }
    }

    private static boolean shouldAttachTracingHeaders(@NotNull String str, @NotNull SentryOptions sentryOptions) {
        return PropagationTargetsUtils.contain(sentryOptions.getTracePropagationTargets(), str);
    }

    /* JADX INFO: loaded from: classes6.dex */
    static final class PropagationContextHolder {
        private PropagationContext propagationContext;

        private PropagationContextHolder() {
            this.propagationContext = null;
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    public static final class TracingHeaders {
        private final BaggageHeader baggageHeader;
        private final SentryTraceHeader sentryTraceHeader;

        public TracingHeaders(@NotNull SentryTraceHeader sentryTraceHeader, @Nullable BaggageHeader baggageHeader) {
            this.sentryTraceHeader = sentryTraceHeader;
            this.baggageHeader = baggageHeader;
        }

        public SentryTraceHeader getSentryTraceHeader() {
            return this.sentryTraceHeader;
        }

        public BaggageHeader getBaggageHeader() {
            return this.baggageHeader;
        }
    }

    public static boolean isIgnored(@Nullable List<FilterString> list, @Nullable String str) {
        if (str != null && list != null && !list.isEmpty()) {
            Iterator<FilterString> it2 = list.iterator();
            while (it2.hasNext()) {
                if (it2.next().getFilterString().equalsIgnoreCase(str)) {
                    return true;
                }
            }
            Iterator<FilterString> it3 = list.iterator();
            while (it3.hasNext()) {
                try {
                    if (it3.next().matches(str)) {
                        return true;
                    }
                } catch (Throwable unused) {
                }
            }
        }
        return false;
    }

    public static Baggage ensureBaggage(@Nullable Baggage baggage, @Nullable TracesSamplingDecision tracesSamplingDecision) {
        return ensureBaggage(baggage, tracesSamplingDecision == null ? null : tracesSamplingDecision.getSampled(), tracesSamplingDecision == null ? null : tracesSamplingDecision.getSampleRate(), tracesSamplingDecision != null ? tracesSamplingDecision.getSampleRand() : null);
    }

    public static Baggage ensureBaggage(@Nullable Baggage baggage, @Nullable Boolean bool, @Nullable Double d, @Nullable Double d2) {
        if (baggage == null) {
            baggage = new Baggage(NoOpLogger.getInstance());
        }
        if (baggage.getSampleRand() == null) {
            Double sampleRate = baggage.getSampleRate();
            if (sampleRate != null) {
                d = sampleRate;
            }
            baggage.setSampleRand(SampleRateUtils.backfilledSampleRand(d2, d, bool));
        }
        if (baggage.isMutable() && baggage.isShouldFreeze()) {
            baggage.freeze();
        }
        return baggage;
    }
}
