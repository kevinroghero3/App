package org.joda.convert;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import io.sentry.profilemeasurements.ProfileMeasurement;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Iterator;
import java.util.SimpleTimeZone;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.joda.convert.factory.BooleanArrayStringConverterFactory;
import org.joda.convert.factory.BooleanObjectArrayStringConverterFactory;
import org.joda.convert.factory.ByteObjectArrayStringConverterFactory;
import org.joda.convert.factory.CharObjectArrayStringConverterFactory;
import org.joda.convert.factory.NumericArrayStringConverterFactory;
import org.joda.convert.factory.NumericObjectArrayStringConverterFactory;

/* JADX INFO: loaded from: classes6.dex */
public final class StringConvert {
    private static final TypedStringConverter<?> CACHED_NULL;
    public static final StringConvert INSTANCE;
    static final boolean LOG;
    private final CopyOnWriteArrayList<StringConverterFactory> factories;
    private final ConcurrentMap<Class<?>, FromStringConverter<?>> fromStrings;
    private final ConcurrentMap<Class<?>, TypedStringConverter<?>> registered;

    static {
        String property;
        try {
            property = System.getProperty("org.joda.convert.debug");
        } catch (SecurityException unused) {
            property = null;
        }
        LOG = "true".equalsIgnoreCase(property);
        CACHED_NULL = new TypedStringConverter<Object>() { // from class: org.joda.convert.StringConvert.1
            @Override // org.joda.convert.FromStringConverter
            public Object convertFromString(Class<? extends Object> cls, String str) {
                return null;
            }

            @Override // org.joda.convert.ToStringConverter
            public String convertToString(Object obj) {
                return null;
            }

            @Override // org.joda.convert.TypedStringConverter, org.joda.convert.TypedFromStringConverter
            public Class<?> getEffectiveType() {
                return null;
            }
        };
        INSTANCE = new StringConvert();
    }

    public static StringConvert create() {
        return new StringConvert(true, NumericArrayStringConverterFactory.INSTANCE, NumericObjectArrayStringConverterFactory.INSTANCE, CharObjectArrayStringConverterFactory.INSTANCE, ByteObjectArrayStringConverterFactory.INSTANCE, BooleanArrayStringConverterFactory.INSTANCE, BooleanObjectArrayStringConverterFactory.INSTANCE);
    }

    public StringConvert() {
        this(true, new StringConverterFactory[0]);
    }

    public StringConvert(boolean z, StringConverterFactory... stringConverterFactoryArr) {
        this.factories = new CopyOnWriteArrayList<>();
        this.registered = new ConcurrentHashMap();
        this.fromStrings = new ConcurrentHashMap();
        if (stringConverterFactoryArr == null) {
            throw new IllegalArgumentException("StringConverterFactory array must not be null");
        }
        for (StringConverterFactory stringConverterFactory : stringConverterFactoryArr) {
            if (stringConverterFactory == null) {
                throw new IllegalArgumentException("StringConverterFactory array must not contain a null element");
            }
        }
        if (z) {
            for (JDKStringConverter jDKStringConverter : JDKStringConverter.values()) {
                this.registered.put(jDKStringConverter.getType(), jDKStringConverter);
            }
            this.registered.put(Boolean.TYPE, JDKStringConverter.BOOLEAN);
            this.registered.put(Byte.TYPE, JDKStringConverter.BYTE);
            this.registered.put(Short.TYPE, JDKStringConverter.SHORT);
            this.registered.put(Integer.TYPE, JDKStringConverter.INTEGER);
            this.registered.put(Long.TYPE, JDKStringConverter.LONG);
            this.registered.put(Float.TYPE, JDKStringConverter.FLOAT);
            this.registered.put(Double.TYPE, JDKStringConverter.DOUBLE);
            this.registered.put(Character.TYPE, JDKStringConverter.CHARACTER);
            tryRegisterGuava();
            tryRegisterJava8Optionals();
            tryRegisterTimeZone();
            tryRegisterJava8();
            tryRegisterThreeTenBackport();
            tryRegisterThreeTenOld();
        }
        if (stringConverterFactoryArr.length > 0) {
            this.factories.addAll(Arrays.asList(stringConverterFactoryArr));
        }
        this.factories.add(AnnotationStringConverterFactory.INSTANCE);
        if (z) {
            this.factories.add(EnumStringConverterFactory.INSTANCE);
            this.factories.add(TypeStringConverterFactory.INSTANCE);
        }
    }

    private void tryRegisterGuava() {
        try {
            Class<?> returnType = Class.class.getMethod("getModule", null).getReturnType();
            Object objInvoke = Class.class.getMethod("getModule", null).invoke(StringConvert.class, null);
            Object objInvoke2 = objInvoke.getClass().getMethod("getLayer", null).invoke(objInvoke, null);
            if (objInvoke2 != null) {
                Object objInvoke3 = objInvoke2.getClass().getMethod("findModule", String.class).invoke(objInvoke2, "com.google.common");
                if (((Boolean) objInvoke3.getClass().getMethod("isPresent", null).invoke(objInvoke3, null)).booleanValue()) {
                    returnType.getMethod("addReads", returnType).invoke(objInvoke, objInvoke3.getClass().getMethod("get", null).invoke(objInvoke3, null));
                }
            }
        } catch (Throwable th) {
            if (LOG) {
                System.err.println("tryRegisterGuava1: " + th);
            }
        }
        try {
            loadType("com.google.common.reflect.TypeToken");
            TypedStringConverter<?> typedStringConverter = (TypedStringConverter) loadType("org.joda.convert.TypeTokenStringConverter").getDeclaredConstructor(null).newInstance(null);
            this.registered.put(typedStringConverter.getEffectiveType(), typedStringConverter);
        } catch (Throwable th2) {
            if (LOG) {
                System.err.println("tryRegisterGuava2: " + th2);
            }
        }
    }

    private void tryRegisterJava8Optionals() {
        try {
            loadType("java.util.OptionalInt");
            TypedStringConverter<?> typedStringConverter = (TypedStringConverter) loadType("org.joda.convert.OptionalIntStringConverter").getDeclaredConstructor(null).newInstance(null);
            this.registered.put(typedStringConverter.getEffectiveType(), typedStringConverter);
            TypedStringConverter<?> typedStringConverter2 = (TypedStringConverter) loadType("org.joda.convert.OptionalLongStringConverter").getDeclaredConstructor(null).newInstance(null);
            this.registered.put(typedStringConverter2.getEffectiveType(), typedStringConverter2);
            TypedStringConverter<?> typedStringConverter3 = (TypedStringConverter) loadType("org.joda.convert.OptionalDoubleStringConverter").getDeclaredConstructor(null).newInstance(null);
            this.registered.put(typedStringConverter3.getEffectiveType(), typedStringConverter3);
        } catch (Throwable th) {
            if (LOG) {
                System.err.println("tryRegisterOptionals: " + th);
            }
        }
    }

    private void tryRegisterTimeZone() {
        try {
            this.registered.put(SimpleTimeZone.class, JDKStringConverter.TIME_ZONE);
        } catch (Throwable th) {
            if (LOG) {
                System.err.println("tryRegisterTimeZone1: " + th);
            }
        }
        try {
            this.registered.put(TimeZone.getDefault().getClass(), JDKStringConverter.TIME_ZONE);
        } catch (Throwable th2) {
            if (LOG) {
                System.err.println("tryRegisterTimeZone2: " + th2);
            }
        }
        try {
            this.registered.put(TimeZone.getTimeZone("Europe/London").getClass(), JDKStringConverter.TIME_ZONE);
        } catch (Throwable th3) {
            if (LOG) {
                System.err.println("tryRegisterTimeZone3: " + th3);
            }
        }
    }

    private void tryRegisterJava8() {
        try {
            tryRegister("java.time.Instant", "parse");
            tryRegister("java.time.Duration", "parse");
            tryRegister("java.time.LocalDate", "parse");
            tryRegister("java.time.LocalTime", "parse");
            tryRegister("java.time.LocalDateTime", "parse");
            tryRegister("java.time.OffsetTime", "parse");
            tryRegister("java.time.OffsetDateTime", "parse");
            tryRegister("java.time.ZonedDateTime", "parse");
            tryRegister("java.time.Year", "parse");
            tryRegister("java.time.YearMonth", "parse");
            tryRegister("java.time.MonthDay", "parse");
            tryRegister("java.time.Period", "parse");
            tryRegister("java.time.ZoneOffset", "of");
            tryRegister("java.time.ZoneId", "of");
            tryRegister("java.time.ZoneRegion", "of");
        } catch (Throwable th) {
            if (LOG) {
                System.err.println("tryRegisterJava8: " + th);
            }
        }
    }

    private void tryRegisterThreeTenBackport() {
        try {
            tryRegister("org.threeten.bp.Instant", "parse");
            tryRegister("org.threeten.bp.Duration", "parse");
            tryRegister("org.threeten.bp.LocalDate", "parse");
            tryRegister("org.threeten.bp.LocalTime", "parse");
            tryRegister("org.threeten.bp.LocalDateTime", "parse");
            tryRegister("org.threeten.bp.OffsetTime", "parse");
            tryRegister("org.threeten.bp.OffsetDateTime", "parse");
            tryRegister("org.threeten.bp.ZonedDateTime", "parse");
            tryRegister("org.threeten.bp.Year", "parse");
            tryRegister("org.threeten.bp.YearMonth", "parse");
            tryRegister("org.threeten.bp.MonthDay", "parse");
            tryRegister("org.threeten.bp.Period", "parse");
            tryRegister("org.threeten.bp.ZoneOffset", "of");
            tryRegister("org.threeten.bp.ZoneId", "of");
            tryRegister("org.threeten.bp.ZoneRegion", "of");
        } catch (Throwable th) {
            if (LOG) {
                System.err.println("tryRegisterThreeTenBackport: " + th);
            }
        }
    }

    private void tryRegisterThreeTenOld() {
        try {
            tryRegister("javax.time.Instant", "parse");
            tryRegister("javax.time.Duration", "parse");
            tryRegister("javax.time.calendar.LocalDate", "parse");
            tryRegister("javax.time.calendar.LocalTime", "parse");
            tryRegister("javax.time.calendar.LocalDateTime", "parse");
            tryRegister("javax.time.calendar.OffsetDate", "parse");
            tryRegister("javax.time.calendar.OffsetTime", "parse");
            tryRegister("javax.time.calendar.OffsetDateTime", "parse");
            tryRegister("javax.time.calendar.ZonedDateTime", "parse");
            tryRegister("javax.time.calendar.Year", "parse");
            tryRegister("javax.time.calendar.YearMonth", "parse");
            tryRegister("javax.time.calendar.MonthDay", "parse");
            tryRegister("javax.time.calendar.Period", "parse");
            tryRegister("javax.time.calendar.ZoneOffset", "of");
            tryRegister("javax.time.calendar.ZoneId", "of");
            tryRegister("javax.time.calendar.TimeZone", "of");
        } catch (Throwable th) {
            if (LOG) {
                System.err.println("tryRegisterThreeTenOld: " + th);
            }
        }
    }

    private void tryRegister(String str, String str2) throws ClassNotFoundException {
        registerMethods(loadType(str), InAppPurchaseConstants.METHOD_TO_STRING, str2);
    }

    public String convertToString(Object obj) {
        if (obj == null) {
            return null;
        }
        return findConverterNoGenerics(obj.getClass()).convertToString(obj);
    }

    public String convertToString(Class<?> cls, Object obj) {
        if (obj == null) {
            return null;
        }
        return findConverterNoGenerics(cls).convertToString(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T convertFromString(Class<T> cls, String str) {
        if (str == null) {
            return null;
        }
        return findFromStringConverter(cls).convertFromString(cls, str);
    }

    public boolean isConvertible(Class<?> cls) {
        if (cls != null) {
            try {
                if (findConverterQuiet(cls) != null) {
                    return true;
                }
            } catch (RuntimeException unused) {
            }
        }
        return false;
    }

    public <T> StringConverter<T> findConverter(Class<T> cls) {
        return findTypedConverter(cls);
    }

    public StringConverter<Object> findConverterNoGenerics(Class<?> cls) {
        return findTypedConverterNoGenerics(cls);
    }

    public <T> TypedStringConverter<T> findTypedConverter(Class<T> cls) {
        TypedStringConverter<T> typedStringConverterFindConverterQuiet = findConverterQuiet(cls);
        if (typedStringConverterFindConverterQuiet != null) {
            return typedStringConverterFindConverterQuiet;
        }
        throw new IllegalStateException("No registered converter found: " + cls);
    }

    public TypedStringConverter<Object> findTypedConverterNoGenerics(Class<?> cls) {
        TypedStringConverter<Object> typedStringConverterFindConverterQuiet = findConverterQuiet(cls);
        if (typedStringConverterFindConverterQuiet != null) {
            return typedStringConverterFindConverterQuiet;
        }
        throw new IllegalStateException("No registered converter found: " + cls);
    }

    public <T> FromStringConverter<T> findFromStringConverter(Class<T> cls) {
        TypedStringConverter<T> typedStringConverterFindConverterQuiet = findConverterQuiet(cls);
        if (typedStringConverterFindConverterQuiet != null) {
            return typedStringConverterFindConverterQuiet;
        }
        FromStringConverter<T> fromStringConverter = (FromStringConverter) this.fromStrings.get(cls);
        if (fromStringConverter != null) {
            return fromStringConverter;
        }
        throw new IllegalStateException("No registered converter found: " + cls);
    }

    private <T> TypedStringConverter<T> findConverterQuiet(Class<T> cls) {
        if (cls == null) {
            throw new IllegalArgumentException("Class must not be null");
        }
        TypedStringConverter<T> typedStringConverterLookupConverter = (TypedStringConverter) this.registered.get(cls);
        TypedStringConverter<?> typedStringConverter = CACHED_NULL;
        if (typedStringConverterLookupConverter == typedStringConverter) {
            return null;
        }
        if (typedStringConverterLookupConverter == null) {
            try {
                typedStringConverterLookupConverter = lookupConverter(cls);
                if (typedStringConverterLookupConverter == null) {
                    this.registered.putIfAbsent(cls, typedStringConverter);
                    TypedFromStringConverter<T> typedFromStringConverterFindFromStringConverter = AnnotationStringConverterFactory.INSTANCE.findFromStringConverter(cls);
                    if (typedFromStringConverterFindFromStringConverter != null) {
                        this.fromStrings.put(cls, typedFromStringConverterFindFromStringConverter);
                    }
                    return null;
                }
                this.registered.putIfAbsent(cls, typedStringConverterLookupConverter);
            } catch (RuntimeException e) {
                this.registered.putIfAbsent(cls, CACHED_NULL);
                throw e;
            }
        }
        return typedStringConverterLookupConverter;
    }

    private <T> TypedStringConverter<T> lookupConverter(Class<T> cls) {
        Iterator<StringConverterFactory> it2 = this.factories.iterator();
        while (it2.hasNext()) {
            StringConverter<?> stringConverterFindConverter = it2.next().findConverter(cls);
            if (stringConverterFindConverter != null) {
                return TypedAdapter.adapt(cls, stringConverterFindConverter);
            }
        }
        return null;
    }

    public void registerFactory(StringConverterFactory stringConverterFactory) {
        if (stringConverterFactory == null) {
            throw new IllegalArgumentException("Factory must not be null");
        }
        if (this == INSTANCE) {
            throw new IllegalStateException("Global singleton cannot be extended");
        }
        this.factories.add(0, stringConverterFactory);
    }

    public <T> void register(Class<T> cls, StringConverter<T> stringConverter) {
        if (cls == null) {
            throw new IllegalArgumentException("Class must not be null");
        }
        if (stringConverter == null) {
            throw new IllegalArgumentException("StringConverter must not be null");
        }
        if (this == INSTANCE) {
            throw new IllegalStateException("Global singleton cannot be extended");
        }
        this.registered.put(cls, TypedAdapter.adapt(cls, stringConverter));
    }

    public <T> void register(final Class<T> cls, final ToStringConverter<T> toStringConverter, final FromStringConverter<T> fromStringConverter) {
        if (fromStringConverter == null || toStringConverter == null) {
            throw new IllegalArgumentException("Converters must not be null");
        }
        register(cls, new TypedStringConverter<T>() { // from class: org.joda.convert.StringConvert.2
            @Override // org.joda.convert.ToStringConverter
            public String convertToString(T t) {
                return toStringConverter.convertToString(t);
            }

            @Override // org.joda.convert.FromStringConverter
            public T convertFromString(Class<? extends T> cls2, String str) {
                return (T) fromStringConverter.convertFromString(cls2, str);
            }

            @Override // org.joda.convert.TypedStringConverter, org.joda.convert.TypedFromStringConverter
            public Class<?> getEffectiveType() {
                return cls;
            }
        });
    }

    public <T> void registerMethods(Class<T> cls, String str, String str2) {
        if (cls == null) {
            throw new IllegalArgumentException("Class must not be null");
        }
        if (str == null || str2 == null) {
            throw new IllegalArgumentException("Method names must not be null");
        }
        if (this == INSTANCE) {
            throw new IllegalStateException("Global singleton cannot be extended");
        }
        this.registered.putIfAbsent(cls, new ReflectionStringConverter(cls, findToStringMethod(cls, str), new MethodFromStringConverter(cls, findFromStringMethod(cls, str2), cls)));
    }

    public <T> void registerMethodConstructor(Class<T> cls, String str) {
        if (cls == null) {
            throw new IllegalArgumentException("Class must not be null");
        }
        if (str == null) {
            throw new IllegalArgumentException("Method name must not be null");
        }
        if (this == INSTANCE) {
            throw new IllegalStateException("Global singleton cannot be extended");
        }
        this.registered.putIfAbsent(cls, new ReflectionStringConverter(cls, findToStringMethod(cls, str), new ConstructorFromStringConverter(cls, findFromStringConstructorByType(cls))));
    }

    private Method findToStringMethod(Class<?> cls, String str) {
        try {
            Method method = cls.getMethod(str, null);
            if (!Modifier.isStatic(method.getModifiers())) {
                return method;
            }
            throw new IllegalArgumentException("Method must not be static: " + str);
        } catch (NoSuchMethodException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private Method findFromStringMethod(Class<?> cls, String str) {
        Method method;
        try {
            try {
                method = cls.getMethod(str, String.class);
            } catch (NoSuchMethodException unused) {
                method = cls.getMethod(str, CharSequence.class);
            }
            if (Modifier.isStatic(method.getModifiers())) {
                return method;
            }
            throw new IllegalArgumentException("Method must be static: " + str);
        } catch (NoSuchMethodException e) {
            throw new IllegalArgumentException("Method not found", e);
        }
    }

    private <T> Constructor<T> findFromStringConstructorByType(Class<T> cls) {
        try {
            try {
                return cls.getDeclaredConstructor(String.class);
            } catch (NoSuchMethodException unused) {
                return cls.getDeclaredConstructor(CharSequence.class);
            }
        } catch (NoSuchMethodException e) {
            throw new IllegalArgumentException("Constructor not found", e);
        }
    }

    static Class<?> loadType(String str) throws ClassNotFoundException {
        try {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            return (contextClassLoader == null || str.startsWith("[")) ? Class.forName(str) : contextClassLoader.loadClass(str);
        } catch (ClassNotFoundException e) {
            return loadPrimitiveType(str, e);
        }
    }

    private static Class<?> loadPrimitiveType(String str, ClassNotFoundException classNotFoundException) throws ClassNotFoundException {
        if (str.equals("int")) {
            return Integer.TYPE;
        }
        if (str.equals("long")) {
            return Long.TYPE;
        }
        if (str.equals("double")) {
            return Double.TYPE;
        }
        if (str.equals(TypedValues.Custom.S_BOOLEAN)) {
            return Boolean.TYPE;
        }
        if (str.equals("short")) {
            return Short.TYPE;
        }
        if (str.equals(ProfileMeasurement.UNIT_BYTES)) {
            return Byte.TYPE;
        }
        if (str.equals("char")) {
            return Character.TYPE;
        }
        if (str.equals(TypedValues.Custom.S_FLOAT)) {
            return Float.TYPE;
        }
        if (str.equals("void")) {
            return Void.TYPE;
        }
        throw classNotFoundException;
    }

    public String toString() {
        return StringConvert.class.getSimpleName();
    }
}
