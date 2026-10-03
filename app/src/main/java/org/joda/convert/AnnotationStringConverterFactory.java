package org.joda.convert;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes6.dex */
final class AnnotationStringConverterFactory implements StringConverterFactory {
    static final AnnotationStringConverterFactory INSTANCE = new AnnotationStringConverterFactory();

    private AnnotationStringConverterFactory() {
    }

    @Override // org.joda.convert.StringConverterFactory
    public StringConverter<?> findConverter(Class<?> cls) {
        return findAnnotatedConverter(cls);
    }

    private <T> StringConverter<T> findAnnotatedConverter(Class<T> cls) {
        Method methodFindToStringMethod = findToStringMethod(cls);
        if (methodFindToStringMethod == null) {
            return null;
        }
        TypedFromStringConverter<T> typedFromStringConverterFindAnnotatedFromStringConverter = findAnnotatedFromStringConverter(cls);
        if (typedFromStringConverterFindAnnotatedFromStringConverter == null) {
            throw new IllegalStateException("Class annotated with @ToString but not with @FromString: " + cls.getName());
        }
        return new ReflectionStringConverter(cls, methodFindToStringMethod, typedFromStringConverterFindAnnotatedFromStringConverter);
    }

    <T> TypedFromStringConverter<T> findFromStringConverter(Class<T> cls) {
        return findAnnotatedFromStringConverter(cls);
    }

    private <T> TypedFromStringConverter<T> findAnnotatedFromStringConverter(Class<T> cls) {
        TypedFromStringConverter<T> typedFromStringConverterFindFromStringConstructor = findFromStringConstructor(cls);
        TypedFromStringConverter<T> typedFromStringConverterFindFromStringMethod = findFromStringMethod(cls, typedFromStringConverterFindFromStringConstructor == null);
        if (typedFromStringConverterFindFromStringConstructor == null || typedFromStringConverterFindFromStringMethod == null) {
            return typedFromStringConverterFindFromStringConstructor != null ? typedFromStringConverterFindFromStringConstructor : typedFromStringConverterFindFromStringMethod;
        }
        throw new IllegalStateException("Both method and constructor are annotated with @FromString: " + cls.getName());
    }

    private Method findToStringMethod(Class<?> cls) {
        Method method = null;
        Class<?> superclass = cls;
        while (true) {
            if (superclass == null || method != null) {
                break;
            }
            for (Method method2 : superclass.getDeclaredMethods()) {
                if (!method2.isBridge() && !method2.isSynthetic() && ((ToString) method2.getAnnotation(ToString.class)) != null) {
                    if (method != null) {
                        throw new IllegalStateException("Two methods are annotated with @ToString: " + cls.getName());
                    }
                    method = method2;
                }
            }
            superclass = superclass.getSuperclass();
        }
        if (method == null) {
            for (Class<?> cls2 : eliminateEnumSubclass(cls).getInterfaces()) {
                for (Method method3 : cls2.getDeclaredMethods()) {
                    if (!method3.isBridge() && !method3.isSynthetic() && ((ToString) method3.getAnnotation(ToString.class)) != null) {
                        if (method != null) {
                            throw new IllegalStateException("Two methods are annotated with @ToString on interfaces: " + cls.getName());
                        }
                        method = method3;
                    }
                }
            }
        }
        return method;
    }

    private <T> TypedFromStringConverter<T> findFromStringConstructor(Class<T> cls) {
        Constructor<T> declaredConstructor;
        try {
            try {
                declaredConstructor = cls.getDeclaredConstructor(String.class);
            } catch (NoSuchMethodException unused) {
                declaredConstructor = cls.getDeclaredConstructor(CharSequence.class);
            }
            if (((FromString) declaredConstructor.getAnnotation(FromString.class)) == null) {
                return null;
            }
            return new ConstructorFromStringConverter(cls, declaredConstructor);
        } catch (NoSuchMethodException unused2) {
            return null;
        }
    }

    private <T> TypedFromStringConverter<T> findFromStringMethod(Class<T> cls, boolean z) {
        for (Class<T> superclass = cls; superclass != null; superclass = superclass.getSuperclass()) {
            Method methodFindFromString = findFromString(superclass);
            if (methodFindFromString != null) {
                return new MethodFromStringConverter(cls, methodFindFromString, superclass);
            }
            if (!z) {
                break;
            }
        }
        MethodFromStringConverter methodFromStringConverter = null;
        if (z) {
            for (Class<?> cls2 : eliminateEnumSubclass(cls).getInterfaces()) {
                Method methodFindFromString2 = findFromString(cls2);
                if (methodFindFromString2 != null) {
                    if (methodFromStringConverter != null) {
                        throw new IllegalStateException("Two different interfaces are annotated with @FromString or @FromStringFactory: " + cls.getName());
                    }
                    methodFromStringConverter = new MethodFromStringConverter(cls, methodFindFromString2, cls2);
                }
            }
        }
        return methodFromStringConverter;
    }

    private Method findFromString(Class<?> cls) {
        Method method = null;
        for (Method method2 : cls.getDeclaredMethods()) {
            if (!method2.isBridge() && !method2.isSynthetic() && ((FromString) method2.getAnnotation(FromString.class)) != null) {
                if (method != null) {
                    throw new IllegalStateException("Two methods are annotated with @FromString: " + cls.getName());
                }
                method = method2;
            }
        }
        FromStringFactory fromStringFactory = (FromStringFactory) cls.getAnnotation(FromStringFactory.class);
        if (fromStringFactory != null) {
            if (method != null) {
                throw new IllegalStateException("Class annotated with @FromString and @FromStringFactory: " + cls.getName());
            }
            for (Method method3 : fromStringFactory.factory().getDeclaredMethods()) {
                if (!method3.isBridge() && !method3.isSynthetic() && cls.isAssignableFrom(method3.getReturnType()) && ((FromString) method3.getAnnotation(FromString.class)) != null) {
                    if (method != null) {
                        throw new IllegalStateException("Two methods are annotated with @FromString on the factory: " + fromStringFactory.factory().getName());
                    }
                    method = method3;
                }
            }
        }
        return method;
    }

    private Class<?> eliminateEnumSubclass(Class<?> cls) {
        Class<? super Object> superclass = cls.getSuperclass();
        return (superclass == null || superclass.getSuperclass() != Enum.class) ? cls : superclass;
    }

    public String toString() {
        return AnnotationStringConverterFactory.class.getSimpleName();
    }
}
