package androidx.dynamicanimation.animation;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public final class DynamicAnimationKt {
    public static final FlingAnimation flingAnimationOf(@NotNull Function1<? super Float, Unit> setter, @NotNull Function0<Float> getter) {
        Intrinsics.checkParameterIsNotNull(setter, "setter");
        Intrinsics.checkParameterIsNotNull(getter, "getter");
        return new FlingAnimation(createFloatValueHolder(setter, getter));
    }

    public static /* synthetic */ SpringAnimation springAnimationOf$default(Function1 function1, Function0 function0, float f, int i, Object obj) {
        if ((i & 4) != 0) {
            f = FloatCompanionObject.INSTANCE.getNaN();
        }
        return springAnimationOf(function1, function0, f);
    }

    public static final SpringAnimation springAnimationOf(@NotNull Function1<? super Float, Unit> setter, @NotNull Function0<Float> getter, float f) {
        Intrinsics.checkParameterIsNotNull(setter, "setter");
        Intrinsics.checkParameterIsNotNull(getter, "getter");
        FloatValueHolder floatValueHolderCreateFloatValueHolder = createFloatValueHolder(setter, getter);
        if (Float.isNaN(f)) {
            return new SpringAnimation(floatValueHolderCreateFloatValueHolder);
        }
        return new SpringAnimation(floatValueHolderCreateFloatValueHolder, f);
    }

    public static final SpringAnimation withSpringForceProperties(@NotNull SpringAnimation withSpringForceProperties, @NotNull Function1<? super SpringForce, Unit> func) {
        Intrinsics.checkParameterIsNotNull(withSpringForceProperties, "$this$withSpringForceProperties");
        Intrinsics.checkParameterIsNotNull(func, "func");
        if (withSpringForceProperties.getSpring() == null) {
            withSpringForceProperties.setSpring(new SpringForce());
        }
        SpringForce spring = withSpringForceProperties.getSpring();
        Intrinsics.checkExpressionValueIsNotNull(spring, "spring");
        func.invoke(spring);
        return withSpringForceProperties;
    }

    private static final FloatValueHolder createFloatValueHolder(final Function1<? super Float, Unit> function1, final Function0<Float> function0) {
        return new FloatValueHolder() { // from class: androidx.dynamicanimation.animation.DynamicAnimationKt.createFloatValueHolder.1
            @Override // androidx.dynamicanimation.animation.FloatValueHolder
            public float getValue() {
                return ((Number) function0.invoke()).floatValue();
            }

            @Override // androidx.dynamicanimation.animation.FloatValueHolder
            public void setValue(float f) {
                function1.invoke(Float.valueOf(f));
            }
        };
    }
}
