package com.captureprotection;

import android.app.Activity;
import android.util.Log;
import io.sentry.android.core.SentryLogcatAdapter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class Reflection {
    public static final Companion Companion = new Companion(null);
    private static final String NAME = "CaptureProtection_Reflection";

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Class getMethod$lambda$0(Class it2) {
            Intrinsics.checkNotNullParameter(it2, "it");
            return it2.getSuperclass();
        }

        public final Method getMethod(@Nullable Class<?> cls, @NotNull String methodName) {
            Object next;
            Intrinsics.checkNotNullParameter(methodName, "methodName");
            try {
                Iterator it2 = SequencesKt___SequencesKt.flatMap(SequencesKt__SequencesKt.generateSequence(cls, (Function1<? super Class<?>, ? extends Class<?>>) ((Function1<? super Object, ? extends Object>) new Function1() { // from class: com.captureprotection.Reflection$Companion$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Reflection.Companion.getMethod$lambda$0((Class) obj);
                    }
                })), new Function1() { // from class: com.captureprotection.Reflection$Companion$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Reflection.Companion.getMethod$lambda$1((Class) obj);
                    }
                }).iterator();
                while (it2.hasNext()) {
                    next = it2.next();
                    if (Intrinsics.areEqual(((Method) next).getName(), methodName)) {
                        return (Method) next;
                    }
                }
                next = null;
                return (Method) next;
            } catch (Exception e) {
                SentryLogcatAdapter.e(Reflection.NAME, "Exception: " + methodName + " -> " + e.getLocalizedMessage());
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Sequence getMethod$lambda$1(Class it2) {
            Intrinsics.checkNotNullParameter(it2, "it");
            Method[] declaredMethods = it2.getDeclaredMethods();
            Intrinsics.checkNotNullExpressionValue(declaredMethods, "getDeclaredMethods(...)");
            return ArraysKt___ArraysKt.asSequence(declaredMethods);
        }

        public final Object createScreenCaptureCallback(@NotNull final Function0<Unit> onCapturedAction) {
            Class<?> cls;
            Intrinsics.checkNotNullParameter(onCapturedAction, "onCapturedAction");
            Class<?>[] declaredClasses = Activity.class.getDeclaredClasses();
            if (declaredClasses == null || declaredClasses.length == 0) {
                SentryLogcatAdapter.e("CaptureProtection", "No declared classes found in Activity.");
                return null;
            }
            int length = declaredClasses.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    cls = null;
                    break;
                }
                cls = declaredClasses[i];
                if (Intrinsics.areEqual(cls.getSimpleName(), "ScreenCaptureCallback")) {
                    break;
                }
                i++;
            }
            if (cls == null || !cls.isInterface()) {
                SentryLogcatAdapter.e("CaptureProtection", "ScreenCaptureCallback interface not found or is not an interface.");
                return null;
            }
            return Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new InvocationHandler() { // from class: com.captureprotection.Reflection$Companion$$ExternalSyntheticLambda0
                @Override // java.lang.reflect.InvocationHandler
                public final Object invoke(Object obj, Method method, Object[] objArr) {
                    return Reflection.Companion.createScreenCaptureCallback$lambda$4(onCapturedAction, obj, method, objArr);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Object createScreenCaptureCallback$lambda$4(Function0 function0, Object obj, Method method, Object[] objArr) {
            if (Intrinsics.areEqual(method.getName(), "onScreenCaptured")) {
                try {
                    Log.d("CaptureProtection", "=> capture onScreenCaptured add event");
                    function0.invoke();
                } catch (Exception e) {
                    SentryLogcatAdapter.e("CaptureProtection", "onScreenCaptured has raised Exception: " + e.getLocalizedMessage());
                }
                return null;
            }
            Class<?> returnType = method.getReturnType();
            if (Intrinsics.areEqual(returnType, Boolean.TYPE)) {
                return Boolean.FALSE;
            }
            if (Intrinsics.areEqual(returnType, Integer.TYPE)) {
                return 0;
            }
            if (Intrinsics.areEqual(returnType, Float.TYPE)) {
                return Float.valueOf(0.0f);
            }
            if (Intrinsics.areEqual(returnType, Double.TYPE)) {
                return Double.valueOf(0.0d);
            }
            if (Intrinsics.areEqual(returnType, Long.TYPE)) {
                return 0L;
            }
            if (Intrinsics.areEqual(returnType, Short.TYPE)) {
                return (short) 0;
            }
            if (Intrinsics.areEqual(returnType, Byte.TYPE)) {
                return (byte) 0;
            }
            return Intrinsics.areEqual(returnType, Character.TYPE) ? (char) 0 : null;
        }
    }
}
