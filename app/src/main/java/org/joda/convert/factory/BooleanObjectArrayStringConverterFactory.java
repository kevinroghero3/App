package org.joda.convert.factory;

import ch.qos.logback.core.CoreConstants;
import org.joda.convert.StringConverter;
import org.joda.convert.StringConverterFactory;
import org.joda.convert.TypedStringConverter;

/* JADX INFO: loaded from: classes6.dex */
public final class BooleanObjectArrayStringConverterFactory implements StringConverterFactory {
    public static final StringConverterFactory INSTANCE = new BooleanObjectArrayStringConverterFactory();

    private BooleanObjectArrayStringConverterFactory() {
    }

    @Override // org.joda.convert.StringConverterFactory
    public StringConverter<?> findConverter(Class<?> cls) {
        if (cls == Boolean[].class) {
            return BooleanArrayStringConverter.INSTANCE;
        }
        return null;
    }

    public String toString() {
        return BooleanObjectArrayStringConverterFactory.class.getSimpleName();
    }

    enum BooleanArrayStringConverter implements TypedStringConverter<Boolean[]> {
        INSTANCE { // from class: org.joda.convert.factory.BooleanObjectArrayStringConverterFactory.BooleanArrayStringConverter.1
            @Override // org.joda.convert.FromStringConverter
            public /* bridge */ /* synthetic */ Object convertFromString(Class cls, String str) {
                return convertFromString((Class<? extends Boolean[]>) cls, str);
            }

            @Override // org.joda.convert.ToStringConverter
            public String convertToString(Boolean[] boolArr) {
                if (boolArr.length == 0) {
                    return "";
                }
                StringBuilder sb = new StringBuilder(boolArr.length);
                for (Boolean bool : boolArr) {
                    sb.append(bool == null ? CoreConstants.DASH_CHAR : bool.booleanValue() ? 'T' : 'F');
                }
                return sb.toString();
            }

            @Override // org.joda.convert.FromStringConverter
            public Boolean[] convertFromString(Class<? extends Boolean[]> cls, String str) {
                if (str.length() == 0) {
                    return BooleanArrayStringConverter.EMPTY;
                }
                int length = str.length();
                Boolean[] boolArr = new Boolean[length];
                for (int i = 0; i < length; i++) {
                    char cCharAt = str.charAt(i);
                    if (cCharAt == 'T') {
                        boolArr[i] = Boolean.TRUE;
                    } else if (cCharAt == 'F') {
                        boolArr[i] = Boolean.FALSE;
                    } else if (cCharAt == '-') {
                        boolArr[i] = null;
                    } else {
                        throw new IllegalArgumentException("Invalid Boolean[] string, must consist only of 'T', 'F' and '-'");
                    }
                }
                return boolArr;
            }

            @Override // org.joda.convert.TypedStringConverter, org.joda.convert.TypedFromStringConverter
            public Class<?> getEffectiveType() {
                return Boolean[].class;
            }
        };

        private static final Boolean[] EMPTY = new Boolean[0];
    }
}
