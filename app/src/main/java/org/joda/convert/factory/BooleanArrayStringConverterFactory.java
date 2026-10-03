package org.joda.convert.factory;

import org.joda.convert.StringConverter;
import org.joda.convert.StringConverterFactory;
import org.joda.convert.TypedStringConverter;

/* JADX INFO: loaded from: classes6.dex */
public final class BooleanArrayStringConverterFactory implements StringConverterFactory {
    public static final StringConverterFactory INSTANCE = new BooleanArrayStringConverterFactory();

    private BooleanArrayStringConverterFactory() {
    }

    @Override // org.joda.convert.StringConverterFactory
    public StringConverter<?> findConverter(Class<?> cls) {
        if (cls == boolean[].class) {
            return BooleanArrayStringConverter.INSTANCE;
        }
        return null;
    }

    public String toString() {
        return BooleanArrayStringConverterFactory.class.getSimpleName();
    }

    enum BooleanArrayStringConverter implements TypedStringConverter<boolean[]> {
        INSTANCE { // from class: org.joda.convert.factory.BooleanArrayStringConverterFactory.BooleanArrayStringConverter.1
            @Override // org.joda.convert.FromStringConverter
            public /* bridge */ /* synthetic */ Object convertFromString(Class cls, String str) {
                return convertFromString((Class<? extends boolean[]>) cls, str);
            }

            @Override // org.joda.convert.ToStringConverter
            public String convertToString(boolean[] zArr) {
                if (zArr.length == 0) {
                    return "";
                }
                StringBuilder sb = new StringBuilder(zArr.length);
                for (boolean z : zArr) {
                    sb.append(z ? 'T' : 'F');
                }
                return sb.toString();
            }

            @Override // org.joda.convert.FromStringConverter
            public boolean[] convertFromString(Class<? extends boolean[]> cls, String str) {
                if (str.length() == 0) {
                    return BooleanArrayStringConverter.EMPTY;
                }
                int length = str.length();
                boolean[] zArr = new boolean[length];
                for (int i = 0; i < length; i++) {
                    char cCharAt = str.charAt(i);
                    if (cCharAt == 'T') {
                        zArr[i] = true;
                    } else if (cCharAt == 'F') {
                        zArr[i] = false;
                    } else {
                        throw new IllegalArgumentException("Invalid boolean[] string, must consist only of 'T' and 'F'");
                    }
                }
                return zArr;
            }

            @Override // org.joda.convert.TypedStringConverter, org.joda.convert.TypedFromStringConverter
            public Class<?> getEffectiveType() {
                return boolean[].class;
            }
        };

        private static final boolean[] EMPTY = new boolean[0];
    }
}
