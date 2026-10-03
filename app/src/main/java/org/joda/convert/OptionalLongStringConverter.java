package org.joda.convert;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes6.dex */
final class OptionalLongStringConverter implements TypedStringConverter<Object> {
    private static final Object EMPTY;
    private static final Method METHOD_GET;
    private static final Method METHOD_IS_PRESENT;
    private static final Method METHOD_OF;
    private static final Class<?> TYPE;

    static {
        try {
            Class<?> cls = Class.forName("java.util.OptionalLong");
            TYPE = cls;
            EMPTY = cls.getDeclaredMethod("empty", null).invoke(null, null);
            METHOD_OF = cls.getDeclaredMethod("of", Long.TYPE);
            METHOD_IS_PRESENT = cls.getDeclaredMethod("isPresent", null);
            METHOD_GET = cls.getDeclaredMethod("getAsLong", null);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    OptionalLongStringConverter() {
    }

    @Override // org.joda.convert.ToStringConverter
    public String convertToString(Object obj) {
        try {
            return Boolean.TRUE.equals(METHOD_IS_PRESENT.invoke(obj, null)) ? String.valueOf(METHOD_GET.invoke(obj, null)) : "";
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override // org.joda.convert.FromStringConverter
    public Object convertFromString(Class<? extends Object> cls, String str) {
        if ("".equals(str)) {
            return EMPTY;
        }
        try {
            return METHOD_OF.invoke(null, Long.valueOf(Long.parseLong(str)));
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override // org.joda.convert.TypedStringConverter, org.joda.convert.TypedFromStringConverter
    public Class<?> getEffectiveType() {
        return TYPE;
    }
}
