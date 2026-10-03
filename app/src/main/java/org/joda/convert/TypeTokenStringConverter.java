package org.joda.convert;

import com.google.common.reflect.TypeToken;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes6.dex */
final class TypeTokenStringConverter implements TypedStringConverter<Object> {
    static final Class<?> TYPE_TOKEN_CLASS;
    static final Method TYPE_TOKEN_METHOD_OF;

    static {
        try {
            TYPE_TOKEN_CLASS = TypeToken.class;
            TYPE_TOKEN_METHOD_OF = TypeToken.class.getDeclaredMethod("of", Type.class);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    TypeTokenStringConverter() {
    }

    @Override // org.joda.convert.ToStringConverter
    public String convertToString(Object obj) {
        return obj.toString();
    }

    @Override // org.joda.convert.FromStringConverter
    public Object convertFromString(Class<?> cls, String str) {
        try {
            return TYPE_TOKEN_METHOD_OF.invoke(null, TypeUtils.parse(str));
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override // org.joda.convert.TypedStringConverter, org.joda.convert.TypedFromStringConverter
    public Class<?> getEffectiveType() {
        return TYPE_TOKEN_CLASS;
    }
}
