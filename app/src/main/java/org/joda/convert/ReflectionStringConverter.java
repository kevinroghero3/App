package org.joda.convert;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes6.dex */
final class ReflectionStringConverter<T> implements TypedStringConverter<T> {
    private final Class<T> cls;
    final TypedFromStringConverter<T> fromString;
    private final Method toString;

    ReflectionStringConverter(Class<T> cls, Method method, TypedFromStringConverter<T> typedFromStringConverter) {
        if (method.getParameterTypes().length != 0) {
            throw new IllegalStateException("ToString method must have no parameters: " + method);
        }
        if (method.getReturnType() != String.class) {
            throw new IllegalStateException("ToString method must return a String: " + method);
        }
        this.cls = cls;
        this.toString = method;
        this.fromString = typedFromStringConverter;
    }

    @Override // org.joda.convert.ToStringConverter
    public String convertToString(T t) {
        try {
            return (String) this.toString.invoke(t, null);
        } catch (IllegalAccessException unused) {
            throw new IllegalStateException("Method is not accessible: " + this.toString);
        } catch (InvocationTargetException e) {
            if (e.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e.getCause());
            }
            throw new RuntimeException(e.getMessage(), e.getCause());
        }
    }

    @Override // org.joda.convert.FromStringConverter
    public T convertFromString(Class<? extends T> cls, String str) {
        return this.fromString.convertFromString(cls, str);
    }

    @Override // org.joda.convert.TypedStringConverter, org.joda.convert.TypedFromStringConverter
    public Class<?> getEffectiveType() {
        return this.fromString.getEffectiveType();
    }

    public String toString() {
        return "RefectionStringConverter[" + this.cls.getSimpleName() + "]";
    }
}
