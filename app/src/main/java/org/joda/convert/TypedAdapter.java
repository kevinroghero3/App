package org.joda.convert;

/* JADX INFO: loaded from: classes6.dex */
final class TypedAdapter<T> implements TypedStringConverter<T> {
    private final StringConverter<T> conv;
    private final Class<?> effectiveType;

    static <R> TypedStringConverter<R> adapt(Class<R> cls, StringConverter<R> stringConverter) {
        if (stringConverter instanceof TypedStringConverter) {
            return (TypedStringConverter) stringConverter;
        }
        return new TypedAdapter(stringConverter, cls);
    }

    private TypedAdapter(StringConverter<T> stringConverter, Class<?> cls) {
        this.conv = stringConverter;
        this.effectiveType = cls;
    }

    @Override // org.joda.convert.ToStringConverter
    public String convertToString(T t) {
        return this.conv.convertToString(t);
    }

    @Override // org.joda.convert.FromStringConverter
    public T convertFromString(Class<? extends T> cls, String str) {
        return this.conv.convertFromString(cls, str);
    }

    @Override // org.joda.convert.TypedStringConverter, org.joda.convert.TypedFromStringConverter
    public Class<?> getEffectiveType() {
        return this.effectiveType;
    }

    public String toString() {
        return "TypedAdapter:" + this.conv.toString();
    }
}
