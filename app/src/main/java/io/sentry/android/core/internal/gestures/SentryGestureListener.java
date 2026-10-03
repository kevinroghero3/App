package io.sentry.android.core.internal.gestures;

import android.app.Activity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import com.facebook.react.uimanager.ViewProps;
import io.sentry.Breadcrumb;
import io.sentry.Hint;
import io.sentry.IScope;
import io.sentry.IScopes;
import io.sentry.ITransaction;
import io.sentry.Scope;
import io.sentry.ScopeCallback;
import io.sentry.SentryLevel;
import io.sentry.SpanStatus;
import io.sentry.TransactionContext;
import io.sentry.TransactionOptions;
import io.sentry.TypeCheckHint;
import io.sentry.android.core.SentryAndroidOptions;
import io.sentry.internal.gestures.UiElement;
import io.sentry.protocol.TransactionNameSource;
import io.sentry.util.TracingUtils;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public final class SentryGestureListener implements GestureDetector.OnGestureListener {
    private static final String TRACE_ORIGIN = "auto.ui.gesture_listener";
    static final String UI_ACTION = "ui.action";
    private final WeakReference<Activity> activityRef;
    private final SentryAndroidOptions options;
    private final IScopes scopes;
    private UiElement activeUiElement = null;
    private ITransaction activeTransaction = null;
    private GestureType activeEventType = GestureType.Unknown;
    private final ScrollState scrollState = new ScrollState(null);

    enum GestureType {
        Click,
        Scroll,
        Swipe,
        Unknown
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }

    public SentryGestureListener(@NotNull Activity activity, @NotNull IScopes iScopes, @NotNull SentryAndroidOptions sentryAndroidOptions) {
        this.activityRef = new WeakReference<>(activity);
        this.scopes = iScopes;
        this.options = sentryAndroidOptions;
    }

    public void onUp(@NotNull MotionEvent motionEvent) {
        View viewEnsureWindowDecorView = ensureWindowDecorView("onUp");
        UiElement uiElement = this.scrollState.target;
        if (viewEnsureWindowDecorView == null || uiElement == null) {
            return;
        }
        if (this.scrollState.type == GestureType.Unknown) {
            this.options.getLogger().log(SentryLevel.DEBUG, "Unable to define scroll type. No breadcrumb captured.", new Object[0]);
            return;
        }
        addBreadcrumb(uiElement, this.scrollState.type, Collections.singletonMap("direction", this.scrollState.calculateDirection(motionEvent)), motionEvent);
        startTracing(uiElement, this.scrollState.type);
        this.scrollState.reset();
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(@Nullable MotionEvent motionEvent) {
        if (motionEvent == null) {
            return false;
        }
        this.scrollState.reset();
        this.scrollState.startX = motionEvent.getX();
        this.scrollState.startY = motionEvent.getY();
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(@Nullable MotionEvent motionEvent) {
        View viewEnsureWindowDecorView = ensureWindowDecorView("onSingleTapUp");
        if (viewEnsureWindowDecorView != null && motionEvent != null) {
            UiElement uiElementFindTarget = ViewUtils.findTarget(this.options, viewEnsureWindowDecorView, motionEvent.getX(), motionEvent.getY(), UiElement.Type.CLICKABLE);
            if (uiElementFindTarget == null) {
                this.options.getLogger().log(SentryLevel.DEBUG, "Unable to find click target. No breadcrumb captured.", new Object[0]);
                return false;
            }
            GestureType gestureType = GestureType.Click;
            addBreadcrumb(uiElementFindTarget, gestureType, Collections.emptyMap(), motionEvent);
            startTracing(uiElementFindTarget, gestureType);
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(@Nullable MotionEvent motionEvent, @Nullable MotionEvent motionEvent2, float f, float f2) {
        View viewEnsureWindowDecorView = ensureWindowDecorView("onScroll");
        if (viewEnsureWindowDecorView != null && motionEvent != null && this.scrollState.type == GestureType.Unknown) {
            UiElement uiElementFindTarget = ViewUtils.findTarget(this.options, viewEnsureWindowDecorView, motionEvent.getX(), motionEvent.getY(), UiElement.Type.SCROLLABLE);
            if (uiElementFindTarget == null) {
                this.options.getLogger().log(SentryLevel.DEBUG, "Unable to find scroll target. No breadcrumb captured.", new Object[0]);
                this.scrollState.type = GestureType.Scroll;
                return false;
            }
            this.options.getLogger().log(SentryLevel.DEBUG, "Scroll target found: " + uiElementFindTarget.getIdentifier(), new Object[0]);
            this.scrollState.setTarget(uiElementFindTarget);
            this.scrollState.type = GestureType.Scroll;
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(@Nullable MotionEvent motionEvent, @Nullable MotionEvent motionEvent2, float f, float f2) {
        this.scrollState.type = GestureType.Swipe;
        return false;
    }

    private void addBreadcrumb(@NotNull UiElement uiElement, @NotNull GestureType gestureType, @NotNull Map<String, Object> map, @NotNull MotionEvent motionEvent) {
        if (this.options.isEnableUserInteractionBreadcrumbs()) {
            String gestureType2 = getGestureType(gestureType);
            Hint hint = new Hint();
            hint.set(TypeCheckHint.ANDROID_MOTION_EVENT, motionEvent);
            hint.set(TypeCheckHint.ANDROID_VIEW, uiElement.getView());
            this.scopes.addBreadcrumb(Breadcrumb.userInteraction(gestureType2, uiElement.getResourceName(), uiElement.getClassName(), uiElement.getTag(), map), hint);
        }
    }

    private void startTracing(@NotNull UiElement uiElement, @NotNull GestureType gestureType) {
        boolean z = gestureType == GestureType.Click || !(gestureType == this.activeEventType && uiElement.equals(this.activeUiElement));
        if (!this.options.isTracingEnabled() || !this.options.isEnableUserInteractionTracing()) {
            if (z) {
                if (this.options.isEnableAutoTraceIdGeneration()) {
                    TracingUtils.startNewTrace(this.scopes);
                }
                this.activeUiElement = uiElement;
                this.activeEventType = gestureType;
                return;
            }
            return;
        }
        Activity activity = this.activityRef.get();
        if (activity == null) {
            this.options.getLogger().log(SentryLevel.DEBUG, "Activity is null, no transaction captured.", new Object[0]);
            return;
        }
        String identifier = uiElement.getIdentifier();
        ITransaction iTransaction = this.activeTransaction;
        if (iTransaction != null) {
            if (!z && !iTransaction.isFinished()) {
                this.options.getLogger().log(SentryLevel.DEBUG, "The view with id: " + identifier + " already has an ongoing transaction assigned. Rescheduling finish", new Object[0]);
                if (this.options.getIdleTimeout() != null) {
                    this.activeTransaction.scheduleFinish();
                    return;
                }
                return;
            }
            stopTracing(SpanStatus.OK);
        }
        String str = getActivityName(activity) + "." + identifier;
        String str2 = "ui.action." + getGestureType(gestureType);
        TransactionOptions transactionOptions = new TransactionOptions();
        transactionOptions.setWaitForChildren(true);
        long deadlineTimeout = this.options.getDeadlineTimeout();
        transactionOptions.setDeadlineTimeout(deadlineTimeout <= 0 ? null : Long.valueOf(deadlineTimeout));
        transactionOptions.setIdleTimeout(this.options.getIdleTimeout());
        transactionOptions.setTrimEnd(true);
        transactionOptions.setOrigin("auto.ui.gesture_listener." + uiElement.getOrigin());
        final ITransaction iTransactionStartTransaction = this.scopes.startTransaction(new TransactionContext(str, TransactionNameSource.COMPONENT, str2), transactionOptions);
        this.scopes.configureScope(new ScopeCallback() { // from class: io.sentry.android.core.internal.gestures.SentryGestureListener$$ExternalSyntheticLambda3
            @Override // io.sentry.ScopeCallback
            public final void run(IScope iScope) {
                this.f$0.lambda$startTracing$0(iTransactionStartTransaction, iScope);
            }
        });
        this.activeTransaction = iTransactionStartTransaction;
        this.activeUiElement = uiElement;
        this.activeEventType = gestureType;
    }

    void stopTracing(@NotNull SpanStatus spanStatus) {
        ITransaction iTransaction = this.activeTransaction;
        if (iTransaction != null) {
            if (iTransaction.getStatus() == null) {
                this.activeTransaction.finish(spanStatus);
            } else {
                this.activeTransaction.finish();
            }
        }
        this.scopes.configureScope(new ScopeCallback() { // from class: io.sentry.android.core.internal.gestures.SentryGestureListener$$ExternalSyntheticLambda1
            @Override // io.sentry.ScopeCallback
            public final void run(IScope iScope) {
                this.f$0.lambda$stopTracing$1(iScope);
            }
        });
        this.activeTransaction = null;
        if (this.activeUiElement != null) {
            this.activeUiElement = null;
        }
        this.activeEventType = GestureType.Unknown;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: renamed from: clearScope, reason: merged with bridge method [inline-methods] */
    public void lambda$stopTracing$1(@NotNull final IScope iScope) {
        iScope.withTransaction(new Scope.IWithTransaction() { // from class: io.sentry.android.core.internal.gestures.SentryGestureListener$$ExternalSyntheticLambda2
            @Override // io.sentry.Scope.IWithTransaction
            public final void accept(ITransaction iTransaction) {
                this.f$0.lambda$clearScope$2(iScope, iTransaction);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$clearScope$2(IScope iScope, ITransaction iTransaction) {
        if (iTransaction == this.activeTransaction) {
            iScope.clearTransaction();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: renamed from: applyScope, reason: merged with bridge method [inline-methods] */
    public void lambda$startTracing$0(@NotNull final IScope iScope, @NotNull final ITransaction iTransaction) {
        iScope.withTransaction(new Scope.IWithTransaction() { // from class: io.sentry.android.core.internal.gestures.SentryGestureListener$$ExternalSyntheticLambda0
            @Override // io.sentry.Scope.IWithTransaction
            public final void accept(ITransaction iTransaction2) {
                this.f$0.lambda$applyScope$3(iScope, iTransaction, iTransaction2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$applyScope$3(IScope iScope, ITransaction iTransaction, ITransaction iTransaction2) {
        if (iTransaction2 == null) {
            iScope.setTransaction(iTransaction);
        } else {
            this.options.getLogger().log(SentryLevel.DEBUG, "Transaction '%s' won't be bound to the Scope since there's one already in there.", iTransaction.getName());
        }
    }

    private String getActivityName(@NotNull Activity activity) {
        return activity.getClass().getSimpleName();
    }

    private View ensureWindowDecorView(@NotNull String str) {
        Activity activity = this.activityRef.get();
        if (activity == null) {
            this.options.getLogger().log(SentryLevel.DEBUG, "Activity is null in " + str + ". No breadcrumb captured.", new Object[0]);
            return null;
        }
        Window window = activity.getWindow();
        if (window == null) {
            this.options.getLogger().log(SentryLevel.DEBUG, "Window is null in " + str + ". No breadcrumb captured.", new Object[0]);
            return null;
        }
        View decorView = window.getDecorView();
        if (decorView != null) {
            return decorView;
        }
        this.options.getLogger().log(SentryLevel.DEBUG, "DecorView is null in " + str + ". No breadcrumb captured.", new Object[0]);
        return null;
    }

    /* JADX INFO: renamed from: io.sentry.android.core.internal.gestures.SentryGestureListener$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$sentry$android$core$internal$gestures$SentryGestureListener$GestureType;

        static {
            int[] iArr = new int[GestureType.values().length];
            $SwitchMap$io$sentry$android$core$internal$gestures$SentryGestureListener$GestureType = iArr;
            try {
                iArr[GestureType.Click.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$sentry$android$core$internal$gestures$SentryGestureListener$GestureType[GestureType.Scroll.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$sentry$android$core$internal$gestures$SentryGestureListener$GestureType[GestureType.Swipe.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$sentry$android$core$internal$gestures$SentryGestureListener$GestureType[GestureType.Unknown.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private static String getGestureType(@NotNull GestureType gestureType) {
        int i = AnonymousClass1.$SwitchMap$io$sentry$android$core$internal$gestures$SentryGestureListener$GestureType[gestureType.ordinal()];
        if (i == 1) {
            return "click";
        }
        if (i == 2) {
            return ViewProps.SCROLL;
        }
        if (i == 3) {
            return "swipe";
        }
        return "unknown";
    }

    static final class ScrollState {
        private float startX;
        private float startY;
        private UiElement target;
        private GestureType type;

        private ScrollState() {
            this.type = GestureType.Unknown;
            this.startX = 0.0f;
            this.startY = 0.0f;
        }

        /* synthetic */ ScrollState(AnonymousClass1 anonymousClass1) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTarget(@NotNull UiElement uiElement) {
            this.target = uiElement;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String calculateDirection(MotionEvent motionEvent) {
            float x = motionEvent.getX() - this.startX;
            float y = motionEvent.getY() - this.startY;
            if (Math.abs(x) > Math.abs(y)) {
                if (x > 0.0f) {
                    return ViewProps.RIGHT;
                }
                return "left";
            }
            if (y > 0.0f) {
                return "down";
            }
            return "up";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void reset() {
            this.target = null;
            this.type = GestureType.Unknown;
            this.startX = 0.0f;
            this.startY = 0.0f;
        }
    }
}
