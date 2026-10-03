package org.joda.convert;

import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes6.dex */
final class TypeStringConverterFactory implements StringConverterFactory {
    static final TypeStringConverterFactory INSTANCE = new TypeStringConverterFactory();

    private TypeStringConverterFactory() {
    }

    @Override // org.joda.convert.StringConverterFactory
    public StringConverter<?> findConverter(Class<?> cls) {
        if (!Type.class.isAssignableFrom(cls) || cls == Class.class) {
            return null;
        }
        return new TypeStringConverter(cls);
    }

    public String toString() {
        return TypeStringConverterFactory.class.getSimpleName();
    }

    static final class TypeStringConverter implements TypedStringConverter<Type> {
        private final Class<?> effectiveType;

        @Override // org.joda.convert.FromStringConverter
        public /* bridge */ /* synthetic */ Object convertFromString(Class cls, String str) {
            return convertFromString((Class<? extends Type>) cls, str);
        }

        TypeStringConverter(Class<?> cls) {
            this.effectiveType = cls;
        }

        @Override // org.joda.convert.ToStringConverter
        public String convertToString(Type type) {
            try {
                return Types.toString(type);
            } catch (Exception unused) {
                return type.toString();
            }
        }

        @Override // org.joda.convert.FromStringConverter
        public Type convertFromString(Class<? extends Type> cls, String str) {
            return TypeUtils.parse(str);
        }

        @Override // org.joda.convert.TypedStringConverter, org.joda.convert.TypedFromStringConverter
        public Class<?> getEffectiveType() {
            return this.effectiveType;
        }
    }
}
