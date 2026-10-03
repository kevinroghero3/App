package com.facebook.react.uimanager;

import com.facebook.react.common.ClearableSynchronizedPool;
import com.facebook.yoga.YogaNode;
import com.hitachiapp.exceptions.AppDebuggableException;
import java.lang.reflect.Constructor;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes2.dex */
public final class YogaNodePool {
    public static final YogaNodePool INSTANCE = new YogaNodePool();
    private static final Lazy pool$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new Function0() { // from class: com.facebook.react.uimanager.YogaNodePool$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return YogaNodePool.pool_delegate$lambda$0();
        }

        public static void $$a(long j, long j2) throws Throwable {
            try {
                Constructor declaredConstructor = AppDebuggableException.class.getDeclaredConstructor(null);
                declaredConstructor.setAccessible(true);
                throw ((Throwable) declaredConstructor.newInstance(null));
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }
    });

    private YogaNodePool() {
    }

    private final ClearableSynchronizedPool<YogaNode> getPool() {
        return (ClearableSynchronizedPool) pool$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ClearableSynchronizedPool pool_delegate$lambda$0() {
        return new ClearableSynchronizedPool(1024);
    }

    @JvmStatic
    public static final ClearableSynchronizedPool<YogaNode> get() {
        return INSTANCE.getPool();
    }
}
