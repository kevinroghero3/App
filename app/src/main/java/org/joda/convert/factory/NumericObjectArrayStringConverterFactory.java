package org.joda.convert.factory;

import ch.qos.logback.core.CoreConstants;
import java.util.Arrays;
import org.joda.convert.StringConverter;
import org.joda.convert.StringConverterFactory;
import org.joda.convert.TypedStringConverter;

/* JADX INFO: loaded from: classes6.dex */
public final class NumericObjectArrayStringConverterFactory implements StringConverterFactory {
    public static final StringConverterFactory INSTANCE = new NumericObjectArrayStringConverterFactory();

    private NumericObjectArrayStringConverterFactory() {
    }

    @Override // org.joda.convert.StringConverterFactory
    public StringConverter<?> findConverter(Class<?> cls) {
        if (!cls.isArray()) {
            return null;
        }
        if (cls == Long[].class) {
            return LongArrayStringConverter.INSTANCE;
        }
        if (cls == Integer[].class) {
            return IntArrayStringConverter.INSTANCE;
        }
        if (cls == Short[].class) {
            return ShortArrayStringConverter.INSTANCE;
        }
        if (cls == Double[].class) {
            return DoubleArrayStringConverter.INSTANCE;
        }
        if (cls == Float[].class) {
            return FloatArrayStringConverter.INSTANCE;
        }
        return null;
    }

    public String toString() {
        return NumericObjectArrayStringConverterFactory.class.getSimpleName();
    }

    enum LongArrayStringConverter implements TypedStringConverter<Long[]> {
        INSTANCE { // from class: org.joda.convert.factory.NumericObjectArrayStringConverterFactory.LongArrayStringConverter.1
            @Override // org.joda.convert.FromStringConverter
            public /* bridge */ /* synthetic */ Object convertFromString(Class cls, String str) {
                return convertFromString((Class<? extends Long[]>) cls, str);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // org.joda.convert.ToStringConverter
            public String convertToString(Long[] lArr) {
                Object obj;
                if (lArr.length == 0) {
                    return "";
                }
                StringBuilder sb = new StringBuilder(lArr.length * 8);
                Object[] objArr = lArr[0];
                if (objArr == 0) {
                    obj = objArr;
                    obj = "-";
                }
                obj = objArr;
                sb.append(obj);
                for (int i = 1; i < lArr.length; i++) {
                    sb.append(CoreConstants.COMMA_CHAR);
                    Object obj2 = lArr[i];
                    if (obj2 == 0) {
                        obj2 = "-";
                    }
                    sb.append(obj2);
                }
                return sb.toString();
            }

            @Override // org.joda.convert.FromStringConverter
            public Long[] convertFromString(Class<? extends Long[]> cls, String str) {
                if (str.length() == 0) {
                    return LongArrayStringConverter.EMPTY;
                }
                int iIndexOf = str.indexOf(44);
                Long[] lArr = new Long[(str.length() / 2) + 1];
                int i = 0;
                int i2 = 0;
                while (true) {
                    Long lValueOf = null;
                    if (iIndexOf < 0) {
                        break;
                    }
                    String strSubstring = str.substring(i, iIndexOf);
                    if (!strSubstring.equals("-")) {
                        lValueOf = Long.valueOf(strSubstring);
                    }
                    lArr[i2] = lValueOf;
                    i = iIndexOf + 1;
                    iIndexOf = str.indexOf(44, i);
                    i2++;
                }
                String strSubstring2 = str.substring(i, str.length());
                lArr[i2] = strSubstring2.equals("-") ? null : Long.valueOf(strSubstring2);
                return (Long[]) Arrays.copyOf(lArr, i2 + 1);
            }

            @Override // org.joda.convert.TypedStringConverter, org.joda.convert.TypedFromStringConverter
            public Class<?> getEffectiveType() {
                return Long[].class;
            }
        };

        private static final Long[] EMPTY = new Long[0];
    }

    enum IntArrayStringConverter implements TypedStringConverter<Integer[]> {
        INSTANCE { // from class: org.joda.convert.factory.NumericObjectArrayStringConverterFactory.IntArrayStringConverter.1
            @Override // org.joda.convert.FromStringConverter
            public /* bridge */ /* synthetic */ Object convertFromString(Class cls, String str) {
                return convertFromString((Class<? extends Integer[]>) cls, str);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // org.joda.convert.ToStringConverter
            public String convertToString(Integer[] numArr) {
                Object obj;
                if (numArr.length == 0) {
                    return "";
                }
                StringBuilder sb = new StringBuilder(numArr.length * 6);
                Object[] objArr = numArr[0];
                if (objArr == 0) {
                    obj = objArr;
                    obj = "-";
                }
                obj = objArr;
                sb.append(obj);
                for (int i = 1; i < numArr.length; i++) {
                    sb.append(CoreConstants.COMMA_CHAR);
                    Object obj2 = numArr[i];
                    if (obj2 == 0) {
                        obj2 = "-";
                    }
                    sb.append(obj2);
                }
                return sb.toString();
            }

            @Override // org.joda.convert.FromStringConverter
            public Integer[] convertFromString(Class<? extends Integer[]> cls, String str) {
                if (str.length() == 0) {
                    return IntArrayStringConverter.EMPTY;
                }
                int iIndexOf = str.indexOf(44);
                Integer[] numArr = new Integer[(str.length() / 2) + 1];
                int i = 0;
                int i2 = 0;
                while (true) {
                    Integer numValueOf = null;
                    if (iIndexOf < 0) {
                        break;
                    }
                    String strSubstring = str.substring(i, iIndexOf);
                    if (!strSubstring.equals("-")) {
                        numValueOf = Integer.valueOf(strSubstring);
                    }
                    numArr[i2] = numValueOf;
                    i = iIndexOf + 1;
                    iIndexOf = str.indexOf(44, i);
                    i2++;
                }
                String strSubstring2 = str.substring(i, str.length());
                numArr[i2] = strSubstring2.equals("-") ? null : Integer.valueOf(strSubstring2);
                return (Integer[]) Arrays.copyOf(numArr, i2 + 1);
            }

            @Override // org.joda.convert.TypedStringConverter, org.joda.convert.TypedFromStringConverter
            public Class<?> getEffectiveType() {
                return Integer[].class;
            }
        };

        private static final Integer[] EMPTY = new Integer[0];
    }

    enum ShortArrayStringConverter implements TypedStringConverter<Short[]> {
        INSTANCE { // from class: org.joda.convert.factory.NumericObjectArrayStringConverterFactory.ShortArrayStringConverter.1
            @Override // org.joda.convert.FromStringConverter
            public /* bridge */ /* synthetic */ Object convertFromString(Class cls, String str) {
                return convertFromString((Class<? extends Short[]>) cls, str);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // org.joda.convert.ToStringConverter
            public String convertToString(Short[] shArr) {
                Object obj;
                if (shArr.length == 0) {
                    return "";
                }
                StringBuilder sb = new StringBuilder(shArr.length * 3);
                Object[] objArr = shArr[0];
                if (objArr == 0) {
                    obj = objArr;
                    obj = "-";
                }
                obj = objArr;
                sb.append(obj);
                for (int i = 1; i < shArr.length; i++) {
                    sb.append(CoreConstants.COMMA_CHAR);
                    Object obj2 = shArr[i];
                    if (obj2 == 0) {
                        obj2 = "-";
                    }
                    sb.append(obj2);
                }
                return sb.toString();
            }

            @Override // org.joda.convert.FromStringConverter
            public Short[] convertFromString(Class<? extends Short[]> cls, String str) {
                if (str.length() == 0) {
                    return ShortArrayStringConverter.EMPTY;
                }
                int iIndexOf = str.indexOf(44);
                Short[] shArr = new Short[(str.length() / 2) + 1];
                int i = 0;
                int i2 = 0;
                while (true) {
                    Short shValueOf = null;
                    if (iIndexOf < 0) {
                        break;
                    }
                    String strSubstring = str.substring(i, iIndexOf);
                    if (!strSubstring.equals("-")) {
                        shValueOf = Short.valueOf(strSubstring);
                    }
                    shArr[i2] = shValueOf;
                    i = iIndexOf + 1;
                    iIndexOf = str.indexOf(44, i);
                    i2++;
                }
                String strSubstring2 = str.substring(i, str.length());
                shArr[i2] = strSubstring2.equals("-") ? null : Short.valueOf(strSubstring2);
                return (Short[]) Arrays.copyOf(shArr, i2 + 1);
            }

            @Override // org.joda.convert.TypedStringConverter, org.joda.convert.TypedFromStringConverter
            public Class<?> getEffectiveType() {
                return Short[].class;
            }
        };

        private static final Short[] EMPTY = new Short[0];
    }

    enum DoubleArrayStringConverter implements TypedStringConverter<Double[]> {
        INSTANCE { // from class: org.joda.convert.factory.NumericObjectArrayStringConverterFactory.DoubleArrayStringConverter.1
            @Override // org.joda.convert.FromStringConverter
            public /* bridge */ /* synthetic */ Object convertFromString(Class cls, String str) {
                return convertFromString((Class<? extends Double[]>) cls, str);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // org.joda.convert.ToStringConverter
            public String convertToString(Double[] dArr) {
                Object obj;
                if (dArr.length == 0) {
                    return "";
                }
                StringBuilder sb = new StringBuilder(dArr.length * 8);
                Object[] objArr = dArr[0];
                if (objArr == 0) {
                    obj = objArr;
                    obj = "-";
                }
                obj = objArr;
                sb.append(obj);
                for (int i = 1; i < dArr.length; i++) {
                    sb.append(CoreConstants.COMMA_CHAR);
                    Object obj2 = dArr[i];
                    if (obj2 == 0) {
                        obj2 = "-";
                    }
                    sb.append(obj2);
                }
                return sb.toString();
            }

            @Override // org.joda.convert.FromStringConverter
            public Double[] convertFromString(Class<? extends Double[]> cls, String str) {
                if (str.length() == 0) {
                    return DoubleArrayStringConverter.EMPTY;
                }
                int iIndexOf = str.indexOf(44);
                Double[] dArr = new Double[(str.length() / 2) + 1];
                int i = 0;
                int i2 = 0;
                while (true) {
                    Double dValueOf = null;
                    if (iIndexOf < 0) {
                        break;
                    }
                    String strSubstring = str.substring(i, iIndexOf);
                    if (!strSubstring.equals("-")) {
                        dValueOf = Double.valueOf(strSubstring);
                    }
                    dArr[i2] = dValueOf;
                    i = iIndexOf + 1;
                    iIndexOf = str.indexOf(44, i);
                    i2++;
                }
                String strSubstring2 = str.substring(i, str.length());
                dArr[i2] = strSubstring2.equals("-") ? null : Double.valueOf(strSubstring2);
                return (Double[]) Arrays.copyOf(dArr, i2 + 1);
            }

            @Override // org.joda.convert.TypedStringConverter, org.joda.convert.TypedFromStringConverter
            public Class<?> getEffectiveType() {
                return Double[].class;
            }
        };

        private static final Double[] EMPTY = new Double[0];
    }

    enum FloatArrayStringConverter implements TypedStringConverter<Float[]> {
        INSTANCE { // from class: org.joda.convert.factory.NumericObjectArrayStringConverterFactory.FloatArrayStringConverter.1
            @Override // org.joda.convert.FromStringConverter
            public /* bridge */ /* synthetic */ Object convertFromString(Class cls, String str) {
                return convertFromString((Class<? extends Float[]>) cls, str);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // org.joda.convert.ToStringConverter
            public String convertToString(Float[] fArr) {
                Object obj;
                if (fArr.length == 0) {
                    return "";
                }
                StringBuilder sb = new StringBuilder(fArr.length * 8);
                Object[] objArr = fArr[0];
                if (objArr == 0) {
                    obj = objArr;
                    obj = "-";
                }
                obj = objArr;
                sb.append(obj);
                for (int i = 1; i < fArr.length; i++) {
                    sb.append(CoreConstants.COMMA_CHAR);
                    Object obj2 = fArr[i];
                    if (obj2 == 0) {
                        obj2 = "-";
                    }
                    sb.append(obj2);
                }
                return sb.toString();
            }

            @Override // org.joda.convert.FromStringConverter
            public Float[] convertFromString(Class<? extends Float[]> cls, String str) {
                if (str.length() == 0) {
                    return FloatArrayStringConverter.EMPTY;
                }
                int iIndexOf = str.indexOf(44);
                Float[] fArr = new Float[(str.length() / 2) + 1];
                int i = 0;
                int i2 = 0;
                while (true) {
                    Float fValueOf = null;
                    if (iIndexOf < 0) {
                        break;
                    }
                    String strSubstring = str.substring(i, iIndexOf);
                    if (!strSubstring.equals("-")) {
                        fValueOf = Float.valueOf(strSubstring);
                    }
                    fArr[i2] = fValueOf;
                    i = iIndexOf + 1;
                    iIndexOf = str.indexOf(44, i);
                    i2++;
                }
                String strSubstring2 = str.substring(i, str.length());
                fArr[i2] = strSubstring2.equals("-") ? null : Float.valueOf(strSubstring2);
                return (Float[]) Arrays.copyOf(fArr, i2 + 1);
            }

            @Override // org.joda.convert.TypedStringConverter, org.joda.convert.TypedFromStringConverter
            public Class<?> getEffectiveType() {
                return Float[].class;
            }
        };

        private static final Float[] EMPTY = new Float[0];
    }
}
