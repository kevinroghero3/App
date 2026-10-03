package org.parceler;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;

/* JADX INFO: loaded from: classes6.dex */
public final class InjectionUtil {
    public static final String CALL_CONSTRUCTOR_METHOD = "callConstructor";
    public static final String CALL_METHOD_METHOD = "callMethod";
    public static final String GET_FIELD_METHOD = "getField";
    public static final String SET_FIELD_METHOD = "setField";

    public static final class GenericType<T> {
    }

    private InjectionUtil() {
    }

    public static <T> T getField(Class<T> cls, Class<?> cls2, Object obj, String str) {
        try {
            return (T) AccessController.doPrivileged(new GetFieldPrivilegedAction(cls2.getDeclaredField(str), obj));
        } catch (NoSuchFieldException e) {
            throw new ParcelerRuntimeException("NoSuchFieldException Exception during field injection: " + str + " in " + obj.getClass(), (Exception) e);
        } catch (PrivilegedActionException e2) {
            throw new ParcelerRuntimeException("PrivilegedActionException Exception during field injection", (Exception) e2);
        } catch (Exception e3) {
            throw new ParcelerRuntimeException("Exception during field injection", e3);
        }
    }

    public static <T> T getField(GenericType<T> genericType, Class<?> cls, Object obj, String str) {
        return (T) getField(Object.class, cls, obj, str);
    }

    static final class GetFieldPrivilegedAction<T> extends AccessibleElementPrivilegedAction<T, Field> {
        private final Object target;

        private GetFieldPrivilegedAction(Field field, Object obj) {
            super(field);
            this.target = obj;
        }

        @Override // org.parceler.InjectionUtil.AccessibleElementPrivilegedAction
        public T run(Field field) throws IllegalAccessException {
            return (T) field.get(this.target);
        }
    }

    public static void setField(Class<?> cls, Object obj, String str, Object obj2) {
        try {
            AccessController.doPrivileged(new SetFieldPrivilegedAction(cls.getDeclaredField(str), obj, obj2));
        } catch (NoSuchFieldException e) {
            throw new ParcelerRuntimeException("NoSuchFieldException Exception during field injection: " + str + " in " + obj.getClass(), (Exception) e);
        } catch (PrivilegedActionException e2) {
            throw new ParcelerRuntimeException("PrivilegedActionException Exception during field injection", (Exception) e2);
        } catch (Exception e3) {
            throw new ParcelerRuntimeException("Exception during field injection", e3);
        }
    }

    static final class SetFieldPrivilegedAction extends AccessibleElementPrivilegedAction<Void, Field> {
        private final Object target;
        private final Object value;

        private SetFieldPrivilegedAction(Field field, Object obj, Object obj2) {
            super(field);
            this.target = obj;
            this.value = obj2;
        }

        @Override // org.parceler.InjectionUtil.AccessibleElementPrivilegedAction
        public Void run(Field field) throws IllegalAccessException {
            field.set(this.target, this.value);
            return null;
        }
    }

    public static <T> T callMethod(Class<T> cls, Class<?> cls2, Object obj, String str, Class[] clsArr, Object[] objArr) {
        try {
            return (T) AccessController.doPrivileged(new SetMethodPrivilegedAction(cls2.getDeclaredMethod(str, clsArr), obj, objArr));
        } catch (NoSuchMethodException e) {
            throw new ParcelerRuntimeException("Exception during method injection: NoSuchFieldException", (Exception) e);
        } catch (PrivilegedActionException e2) {
            throw new ParcelerRuntimeException("PrivilegedActionException Exception during field injection", (Exception) e2);
        } catch (Exception e3) {
            throw new ParcelerRuntimeException("Exception during field injection", e3);
        }
    }

    public static <T> T callMethod(GenericType<T> genericType, Class<?> cls, Object obj, String str, Class[] clsArr, Object[] objArr) {
        return (T) callMethod(Object.class, cls, obj, str, clsArr, objArr);
    }

    static final class SetMethodPrivilegedAction<T> extends AccessibleElementPrivilegedAction<T, Method> {
        private final Object[] args;
        private final Object target;

        private SetMethodPrivilegedAction(Method method, Object obj, Object[] objArr) {
            super(method);
            this.target = obj;
            this.args = objArr;
        }

        @Override // org.parceler.InjectionUtil.AccessibleElementPrivilegedAction
        public T run(Method method) throws IllegalAccessException, InvocationTargetException {
            return (T) method.invoke(this.target, this.args);
        }
    }

    public static <T> T callConstructor(Class<T> cls, Class[] clsArr, Object[] objArr) {
        try {
            return (T) AccessController.doPrivileged(new SetConstructorPrivilegedAction(cls.getDeclaredConstructor(clsArr), objArr));
        } catch (NoSuchMethodException e) {
            throw new ParcelerRuntimeException("Exception during method injection: NoSuchMethodException", (Exception) e);
        } catch (PrivilegedActionException e2) {
            throw new ParcelerRuntimeException("PrivilegedActionException Exception during field injection", (Exception) e2);
        } catch (Exception e3) {
            throw new ParcelerRuntimeException("Exception during field injection", e3);
        }
    }

    public static <T> T callConstructor(GenericType<T> genericType, Class[] clsArr, Object[] objArr) {
        return (T) callConstructor(Object.class, clsArr, objArr);
    }

    static final class SetConstructorPrivilegedAction<T> extends AccessibleElementPrivilegedAction<T, Constructor> {
        private final Object[] args;

        private SetConstructorPrivilegedAction(Constructor constructor, Object[] objArr) {
            super(constructor);
            this.args = objArr;
        }

        @Override // org.parceler.InjectionUtil.AccessibleElementPrivilegedAction
        public T run(Constructor constructor) throws IllegalAccessException, InstantiationException, InvocationTargetException {
            return (T) constructor.newInstance(this.args);
        }
    }

    static abstract class AccessibleElementPrivilegedAction<T, E extends AccessibleObject> implements PrivilegedExceptionAction<T> {
        private final E accessible;

        public abstract T run(E e) throws Exception;

        protected AccessibleElementPrivilegedAction(E e) {
            this.accessible = e;
        }

        @Override // java.security.PrivilegedExceptionAction
        public T run() throws Exception {
            boolean zIsAccessible = this.accessible.isAccessible();
            this.accessible.setAccessible(true);
            T tRun = run(this.accessible);
            this.accessible.setAccessible(zIsAccessible);
            return tRun;
        }
    }
}
