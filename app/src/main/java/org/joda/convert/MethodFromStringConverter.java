package org.joda.convert;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* JADX INFO: loaded from: classes6.dex */
final class MethodFromStringConverter<T> implements TypedFromStringConverter<T> {
    private final Class<?> effectiveType;
    private final Method fromString;

    MethodFromStringConverter(Class<T> cls, Method method, Class<?> cls2) {
        if (!Modifier.isStatic(method.getModifiers())) {
            throw new IllegalStateException("FromString method must be static: " + method);
        }
        if (method.getParameterTypes().length != 1) {
            throw new IllegalStateException("FromString method must have one parameter: " + method);
        }
        Class<?> cls3 = method.getParameterTypes()[0];
        if (cls3 != String.class && cls3 != CharSequence.class) {
            throw new IllegalStateException("FromString method must take a String or CharSequence: " + method);
        }
        if (!method.getReturnType().isAssignableFrom(cls) && !cls.isAssignableFrom(method.getReturnType())) {
            throw new IllegalStateException("FromString method must return specified class or a supertype: " + method);
        }
        this.fromString = method;
        this.effectiveType = cls2;
    }

    @Override // org.joda.convert.FromStringConverter
    public T convertFromString(Class<? extends T> cls, String str) {
        try {
            return cls.cast(this.fromString.invoke(null, str));
        } catch (IllegalAccessException unused) {
            throw new IllegalStateException("Method is not accessible: " + this.fromString);
        } catch (InvocationTargetException e) {
            if (e.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e.getCause());
            }
            throw new RuntimeException(e.getMessage(), e.getCause());
        }
    }

    @Override // org.joda.convert.TypedFromStringConverter
    public Class<?> getEffectiveType() {
        return this.effectiveType;
    }
}
