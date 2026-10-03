package org.joda.convert.factory;

import ch.qos.logback.core.CoreConstants;
import java.util.Arrays;
import org.joda.convert.StringConverter;
import org.joda.convert.StringConverterFactory;
import org.joda.convert.TypedStringConverter;

/* JADX INFO: loaded from: classes6.dex */
public final class NumericArrayStringConverterFactory implements StringConverterFactory {
    public static final StringConverterFactory INSTANCE = new NumericArrayStringConverterFactory();

    private NumericArrayStringConverterFactory() {
    }

    @Override // org.joda.convert.StringConverterFactory
    public StringConverter<?> findConverter(Class<?> cls) {
        if (!cls.isArray() || !cls.getComponentType().isPrimitive()) {
            return null;
        }
        if (cls == long[].class) {
            return LongArrayStringConverter.INSTANCE;
        }
        if (cls == int[].class) {
            return IntArrayStringConverter.INSTANCE;
        }
        if (cls == short[].class) {
            return ShortArrayStringConverter.INSTANCE;
        }
        if (cls == double[].class) {
            return DoubleArrayStringConverter.INSTANCE;
        }
        if (cls == float[].class) {
            return FloatArrayStringConverter.INSTANCE;
        }
        return null;
    }

    public String toString() {
        return NumericArrayStringConverterFactory.class.getSimpleName();
    }

    enum LongArrayStringConverter implements TypedStringConverter<long[]> {
        INSTANCE { // from class: org.joda.convert.factory.NumericArrayStringConverterFactory.LongArrayStringConverter.1
            @Override // org.joda.convert.FromStringConverter
            public /* bridge */ /* synthetic */ Object convertFromString(Class cls, String str) {
                return convertFromString((Class<? extends long[]>) cls, str);
            }

            @Override // org.joda.convert.ToStringConverter
            public String convertToString(long[] jArr) {
                if (jArr.length == 0) {
                    return "";
                }
                StringBuilder sb = new StringBuilder(jArr.length * 8);
                sb.append(jArr[0]);
                for (int i = 1; i < jArr.length; i++) {
                    sb.append(CoreConstants.COMMA_CHAR);
                    sb.append(jArr[i]);
                }
                return sb.toString();
            }

            @Override // org.joda.convert.FromStringConverter
            public long[] convertFromString(Class<? extends long[]> cls, String str) {
                if (str.length() == 0) {
                    return LongArrayStringConverter.EMPTY;
                }
                int iIndexOf = str.indexOf(44);
                long[] jArr = new long[(str.length() / 2) + 1];
                int i = 0;
                int i2 = 0;
                while (iIndexOf >= 0) {
                    jArr[i] = Long.parseLong(str.substring(i2, iIndexOf));
                    i2 = iIndexOf + 1;
                    iIndexOf = str.indexOf(44, i2);
                    i++;
                }
                jArr[i] = Long.parseLong(str.substring(i2, str.length()));
                return Arrays.copyOf(jArr, i + 1);
            }

            @Override // org.joda.convert.TypedStringConverter, org.joda.convert.TypedFromStringConverter
            public Class<?> getEffectiveType() {
                return long[].class;
            }
        };

        private static final long[] EMPTY = new long[0];
    }

    enum IntArrayStringConverter implements TypedStringConverter<int[]> {
        INSTANCE { // from class: org.joda.convert.factory.NumericArrayStringConverterFactory.IntArrayStringConverter.1
            @Override // org.joda.convert.FromStringConverter
            public /* bridge */ /* synthetic */ Object convertFromString(Class cls, String str) {
                return convertFromString((Class<? extends int[]>) cls, str);
            }

            @Override // org.joda.convert.ToStringConverter
            public String convertToString(int[] iArr) {
                if (iArr.length == 0) {
                    return "";
                }
                StringBuilder sb = new StringBuilder(iArr.length * 6);
                sb.append(iArr[0]);
                for (int i = 1; i < iArr.length; i++) {
                    sb.append(CoreConstants.COMMA_CHAR);
                    sb.append(iArr[i]);
                }
                return sb.toString();
            }

            @Override // org.joda.convert.FromStringConverter
            public int[] convertFromString(Class<? extends int[]> cls, String str) {
                if (str.length() == 0) {
                    return IntArrayStringConverter.EMPTY;
                }
                int iIndexOf = str.indexOf(44);
                int[] iArr = new int[(str.length() / 2) + 1];
                int i = 0;
                int i2 = 0;
                while (iIndexOf >= 0) {
                    iArr[i] = Integer.parseInt(str.substring(i2, iIndexOf));
                    i2 = iIndexOf + 1;
                    iIndexOf = str.indexOf(44, i2);
                    i++;
                }
                iArr[i] = Integer.parseInt(str.substring(i2, str.length()));
                return Arrays.copyOf(iArr, i + 1);
            }

            @Override // org.joda.convert.TypedStringConverter, org.joda.convert.TypedFromStringConverter
            public Class<?> getEffectiveType() {
                return int[].class;
            }
        };

        private static final int[] EMPTY = new int[0];
    }

    enum ShortArrayStringConverter implements TypedStringConverter<short[]> {
        INSTANCE { // from class: org.joda.convert.factory.NumericArrayStringConverterFactory.ShortArrayStringConverter.1
            @Override // org.joda.convert.FromStringConverter
            public /* bridge */ /* synthetic */ Object convertFromString(Class cls, String str) {
                return convertFromString((Class<? extends short[]>) cls, str);
            }

            @Override // org.joda.convert.ToStringConverter
            public String convertToString(short[] sArr) {
                if (sArr.length == 0) {
                    return "";
                }
                StringBuilder sb = new StringBuilder(sArr.length * 3);
                sb.append((int) sArr[0]);
                for (int i = 1; i < sArr.length; i++) {
                    sb.append(CoreConstants.COMMA_CHAR);
                    sb.append((int) sArr[i]);
                }
                return sb.toString();
            }

            @Override // org.joda.convert.FromStringConverter
            public short[] convertFromString(Class<? extends short[]> cls, String str) {
                if (str.length() == 0) {
                    return ShortArrayStringConverter.EMPTY;
                }
                int iIndexOf = str.indexOf(44);
                short[] sArr = new short[(str.length() / 2) + 1];
                int i = 0;
                int i2 = 0;
                while (iIndexOf >= 0) {
                    sArr[i] = Short.parseShort(str.substring(i2, iIndexOf));
                    i2 = iIndexOf + 1;
                    iIndexOf = str.indexOf(44, i2);
                    i++;
                }
                sArr[i] = Short.parseShort(str.substring(i2, str.length()));
                return Arrays.copyOf(sArr, i + 1);
            }

            @Override // org.joda.convert.TypedStringConverter, org.joda.convert.TypedFromStringConverter
            public Class<?> getEffectiveType() {
                return short[].class;
            }
        };

        private static final short[] EMPTY = new short[0];
    }

    enum DoubleArrayStringConverter implements TypedStringConverter<double[]> {
        INSTANCE { // from class: org.joda.convert.factory.NumericArrayStringConverterFactory.DoubleArrayStringConverter.1
            @Override // org.joda.convert.FromStringConverter
            public /* bridge */ /* synthetic */ Object convertFromString(Class cls, String str) {
                return convertFromString((Class<? extends double[]>) cls, str);
            }

            @Override // org.joda.convert.ToStringConverter
            public String convertToString(double[] dArr) {
                if (dArr.length == 0) {
                    return "";
                }
                StringBuilder sb = new StringBuilder(dArr.length * 8);
                sb.append(dArr[0]);
                for (int i = 1; i < dArr.length; i++) {
                    sb.append(CoreConstants.COMMA_CHAR);
                    sb.append(dArr[i]);
                }
                return sb.toString();
            }

            @Override // org.joda.convert.FromStringConverter
            public double[] convertFromString(Class<? extends double[]> cls, String str) {
                if (str.length() == 0) {
                    return DoubleArrayStringConverter.EMPTY;
                }
                int iIndexOf = str.indexOf(44);
                double[] dArr = new double[(str.length() / 2) + 1];
                int i = 0;
                int i2 = 0;
                while (iIndexOf >= 0) {
                    dArr[i] = Double.parseDouble(str.substring(i2, iIndexOf));
                    i2 = iIndexOf + 1;
                    iIndexOf = str.indexOf(44, i2);
                    i++;
                }
                dArr[i] = Double.parseDouble(str.substring(i2, str.length()));
                return Arrays.copyOf(dArr, i + 1);
            }

            @Override // org.joda.convert.TypedStringConverter, org.joda.convert.TypedFromStringConverter
            public Class<?> getEffectiveType() {
                return double[].class;
            }
        };

        private static final double[] EMPTY = new double[0];
    }

    enum FloatArrayStringConverter implements TypedStringConverter<float[]> {
        INSTANCE { // from class: org.joda.convert.factory.NumericArrayStringConverterFactory.FloatArrayStringConverter.1
            @Override // org.joda.convert.FromStringConverter
            public /* bridge */ /* synthetic */ Object convertFromString(Class cls, String str) {
                return convertFromString((Class<? extends float[]>) cls, str);
            }

            @Override // org.joda.convert.ToStringConverter
            public String convertToString(float[] fArr) {
                if (fArr.length == 0) {
                    return "";
                }
                StringBuilder sb = new StringBuilder(fArr.length * 8);
                sb.append(fArr[0]);
                for (int i = 1; i < fArr.length; i++) {
                    sb.append(CoreConstants.COMMA_CHAR);
                    sb.append(fArr[i]);
                }
                return sb.toString();
            }

            @Override // org.joda.convert.FromStringConverter
            public float[] convertFromString(Class<? extends float[]> cls, String str) {
                if (str.length() == 0) {
                    return FloatArrayStringConverter.EMPTY;
                }
                int iIndexOf = str.indexOf(44);
                float[] fArr = new float[(str.length() / 2) + 1];
                int i = 0;
                int i2 = 0;
                while (iIndexOf >= 0) {
                    fArr[i] = Float.parseFloat(str.substring(i2, iIndexOf));
                    i2 = iIndexOf + 1;
                    iIndexOf = str.indexOf(44, i2);
                    i++;
                }
                fArr[i] = Float.parseFloat(str.substring(i2, str.length()));
                return Arrays.copyOf(fArr, i + 1);
            }

            @Override // org.joda.convert.TypedStringConverter, org.joda.convert.TypedFromStringConverter
            public Class<?> getEffectiveType() {
                return float[].class;
            }
        };

        private static final float[] EMPTY = new float[0];
    }
}
