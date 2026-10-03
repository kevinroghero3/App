package com.reactnativekeyboardcontroller.views.overlay;

import android.view.MotionEvent;
import android.view.ViewGroup;
import com.facebook.react.uimanager.JSPointerDispatcher;
import com.facebook.react.uimanager.events.EventDispatcher;
import java.lang.reflect.Method;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class JSPointerDispatcherCompat extends JSPointerDispatcher {
    public static final Companion Companion = new Companion(null);
    private static final String HANDLE_MOTION_EVENT = "handleMotionEvent";
    private static final int RN_72_PARAMS_COUNT = 3;
    private final Lazy handleMotionEventMethod$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JSPointerDispatcherCompat(@NotNull ViewGroup viewGroup) {
        super(viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        this.handleMotionEventMethod$delegate = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.reactnativekeyboardcontroller.views.overlay.JSPointerDispatcherCompat$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return JSPointerDispatcherCompat.handleMotionEventMethod_delegate$lambda$0();
            }
        });
    }

    private final Method getHandleMotionEventMethod() {
        return (Method) this.handleMotionEventMethod$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Method handleMotionEventMethod_delegate$lambda$0() {
        try {
            try {
                return JSPointerDispatcher.class.getMethod(HANDLE_MOTION_EVENT, MotionEvent.class, EventDispatcher.class, Boolean.TYPE);
            } catch (NoSuchMethodException unused) {
                return null;
            }
        } catch (NoSuchMethodException unused2) {
            return JSPointerDispatcher.class.getMethod(HANDLE_MOTION_EVENT, MotionEvent.class, EventDispatcher.class);
        }
    }

    public final void handleMotionEventCompat(@Nullable MotionEvent motionEvent, @Nullable EventDispatcher eventDispatcher, boolean z) {
        Method handleMotionEventMethod = getHandleMotionEventMethod();
        if (handleMotionEventMethod != null) {
            if (JSPointerDispatcherCompat$$ExternalSyntheticBackport0.m(handleMotionEventMethod) == 3) {
                handleMotionEventMethod.invoke(this, motionEvent, eventDispatcher, Boolean.valueOf(z));
            } else {
                handleMotionEventMethod.invoke(this, motionEvent, eventDispatcher);
            }
        }
    }

    /* JADX INFO: loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
