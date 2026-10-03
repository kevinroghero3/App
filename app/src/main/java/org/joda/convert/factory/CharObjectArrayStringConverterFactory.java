package org.joda.convert.factory;

import ch.qos.logback.core.CoreConstants;
import java.util.Arrays;
import org.joda.convert.StringConverter;
import org.joda.convert.StringConverterFactory;
import org.joda.convert.TypedStringConverter;

/* JADX INFO: loaded from: classes6.dex */
public final class CharObjectArrayStringConverterFactory implements StringConverterFactory {
    public static final StringConverterFactory INSTANCE = new CharObjectArrayStringConverterFactory();

    private CharObjectArrayStringConverterFactory() {
    }

    @Override // org.joda.convert.StringConverterFactory
    public StringConverter<?> findConverter(Class<?> cls) {
        if (cls == Character[].class) {
            return CharecterArrayStringConverter.INSTANCE;
        }
        return null;
    }

    public String toString() {
        return CharObjectArrayStringConverterFactory.class.getSimpleName();
    }

    enum CharecterArrayStringConverter implements TypedStringConverter<Character[]> {
        INSTANCE { // from class: org.joda.convert.factory.CharObjectArrayStringConverterFactory.CharecterArrayStringConverter.1
            @Override // org.joda.convert.FromStringConverter
            public /* bridge */ /* synthetic */ Object convertFromString(Class cls, String str) {
                return convertFromString((Class<? extends Character[]>) cls, str);
            }

            @Override // org.joda.convert.ToStringConverter
            public String convertToString(Character[] chArr) {
                if (chArr.length == 0) {
                    return "";
                }
                StringBuilder sb = new StringBuilder(chArr.length * 8);
                for (Character ch2 : chArr) {
                    if (ch2 == null) {
                        sb.append("\\-");
                    } else {
                        char cCharValue = ch2.charValue();
                        if (cCharValue == '\\') {
                            sb.append("\\\\");
                        } else {
                            sb.append(cCharValue);
                        }
                    }
                }
                return sb.toString();
            }

            @Override // org.joda.convert.FromStringConverter
            public Character[] convertFromString(Class<? extends Character[]> cls, String str) {
                if (str.length() == 0) {
                    return CharecterArrayStringConverter.EMPTY;
                }
                Character[] chArr = new Character[str.length()];
                int i = 0;
                int i2 = 0;
                while (true) {
                    int iIndexOf = str.indexOf(92);
                    if (iIndexOf >= 0) {
                        int i3 = 0;
                        while (i3 < iIndexOf) {
                            chArr[i2] = Character.valueOf(str.charAt(i3));
                            i3++;
                            i2++;
                        }
                        int i4 = iIndexOf + 1;
                        if (str.charAt(i4) == '\\') {
                            chArr[i2] = Character.valueOf(CoreConstants.ESCAPE_CHAR);
                        } else if (str.charAt(i4) == '-') {
                            chArr[i2] = null;
                        } else {
                            throw new IllegalArgumentException("Invalid Character[] string, incorrect escape");
                        }
                        i2++;
                        str = str.substring(iIndexOf + 2);
                    } else {
                        while (i < str.length()) {
                            chArr[i2] = Character.valueOf(str.charAt(i));
                            i++;
                            i2++;
                        }
                        return (Character[]) Arrays.copyOf(chArr, i2);
                    }
                }
            }

            @Override // org.joda.convert.TypedStringConverter, org.joda.convert.TypedFromStringConverter
            public Class<?> getEffectiveType() {
                return Character[].class;
            }
        };

        private static final Character[] EMPTY = new Character[0];
    }
}
