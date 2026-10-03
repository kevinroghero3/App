package org.joda.convert;

/* JADX INFO: loaded from: classes6.dex */
final class EnumStringConverterFactory implements StringConverterFactory {
    static final StringConverterFactory INSTANCE = new EnumStringConverterFactory();

    private EnumStringConverterFactory() {
    }

    @Override // org.joda.convert.StringConverterFactory
    public StringConverter<?> findConverter(Class<?> cls) {
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass == Enum.class) {
            return new EnumStringConverter(cls);
        }
        if (superclass == null || superclass.getSuperclass() != Enum.class) {
            return null;
        }
        return new EnumStringConverter(superclass);
    }

    public String toString() {
        return EnumStringConverterFactory.class.getSimpleName();
    }

    static final class EnumStringConverter implements TypedStringConverter<Enum<?>> {
        private final Class<?> effectiveType;

        @Override // org.joda.convert.FromStringConverter
        public /* bridge */ /* synthetic */ Object convertFromString(Class cls, String str) {
            return convertFromString((Class<? extends Enum<?>>) cls, str);
        }

        EnumStringConverter(Class<?> cls) {
            this.effectiveType = cls;
        }

        @Override // org.joda.convert.ToStringConverter
        public String convertToString(Enum<?> r1) {
            return r1.name();
        }

        @Override // org.joda.convert.FromStringConverter
        public Enum<?> convertFromString(Class<? extends Enum<?>> cls, String str) {
            return RenameHandler.INSTANCE.lookupEnum(cls, str);
        }

        @Override // org.joda.convert.TypedStringConverter, org.joda.convert.TypedFromStringConverter
        public Class<?> getEffectiveType() {
            return this.effectiveType;
        }
    }
}
