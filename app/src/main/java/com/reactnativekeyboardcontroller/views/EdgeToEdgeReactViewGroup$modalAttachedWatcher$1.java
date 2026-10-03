package com.reactnativekeyboardcontroller.views;

import com.reactnativekeyboardcontroller.listeners.KeyboardAnimationCallback;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes3.dex */
final /* synthetic */ class EdgeToEdgeReactViewGroup$modalAttachedWatcher$1 extends FunctionReferenceImpl implements Function0<KeyboardAnimationCallback> {
    EdgeToEdgeReactViewGroup$modalAttachedWatcher$1(Object obj) {
        super(0, obj, EdgeToEdgeReactViewGroup.class, "getKeyboardCallback", "getKeyboardCallback()Lcom/reactnativekeyboardcontroller/listeners/KeyboardAnimationCallback;", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final KeyboardAnimationCallback invoke() {
        return ((EdgeToEdgeReactViewGroup) this.receiver).getKeyboardCallback();
    }
}
