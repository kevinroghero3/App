package org.joda.convert;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

/* JADX INFO: loaded from: classes6.dex */
final class ConstructorFromStringConverter<T> implements TypedFromStringConverter<T> {
    private final Constructor<T> fromString;

    ConstructorFromStringConverter(Class<T> cls, Constructor<T> constructor) {
        if (cls.isInterface() || Modifier.isAbstract(cls.getModifiers()) || cls.isLocalClass() || cls.isMemberClass()) {
            throw new IllegalArgumentException("FromString constructor must be on an instantiable class: " + constructor);
        }
        if (constructor.getDeclaringClass() != cls) {
            throw new IllegalStateException("FromString constructor must be defined on specified class: " + constructor);
        }
        this.fromString = constructor;
    }

    @Override // org.joda.convert.FromStringConverter
    public T convertFromString(Class<? extends T> cls, String str) {
        try {
            return this.fromString.newInstance(str);
        } catch (IllegalAccessException unused) {
            throw new IllegalStateException("Constructor is not accessible: " + this.fromString);
        } catch (InstantiationException unused2) {
            throw new IllegalStateException("Constructor is not valid: " + this.fromString);
        } catch (InvocationTargetException e) {
            if (e.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e.getCause());
            }
            throw new RuntimeException(e.getMessage(), e.getCause());
        }
    }

    @Override // org.joda.convert.TypedFromStringConverter
    public Class<?> getEffectiveType() {
        return this.fromString.getDeclaringClass();
    }
}
