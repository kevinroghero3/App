package org.joda.convert.factory;

import ch.qos.logback.core.CoreConstants;
import com.google.common.base.Ascii;
import org.joda.convert.StringConverter;
import org.joda.convert.StringConverterFactory;
import org.joda.convert.TypedStringConverter;

/* JADX INFO: loaded from: classes6.dex */
public final class ByteObjectArrayStringConverterFactory implements StringConverterFactory {
    public static final StringConverterFactory INSTANCE = new ByteObjectArrayStringConverterFactory();

    private ByteObjectArrayStringConverterFactory() {
    }

    @Override // org.joda.convert.StringConverterFactory
    public StringConverter<?> findConverter(Class<?> cls) {
        if (cls == Byte[].class) {
            return ByteArrayStringConverter.INSTANCE;
        }
        return null;
    }

    public String toString() {
        return ByteObjectArrayStringConverterFactory.class.getSimpleName();
    }

    enum ByteArrayStringConverter implements TypedStringConverter<Byte[]> {
        INSTANCE { // from class: org.joda.convert.factory.ByteObjectArrayStringConverterFactory.ByteArrayStringConverter.1
            @Override // org.joda.convert.FromStringConverter
            public /* bridge */ /* synthetic */ Object convertFromString(Class cls, String str) {
                return convertFromString((Class<? extends Byte[]>) cls, str);
            }

            @Override // org.joda.convert.ToStringConverter
            public String convertToString(Byte[] bArr) {
                if (bArr.length == 0) {
                    return "";
                }
                StringBuilder sb = new StringBuilder(bArr.length);
                for (Byte b : bArr) {
                    if (b == null) {
                        sb.append(CoreConstants.DASH_CHAR);
                        sb.append(CoreConstants.DASH_CHAR);
                    } else {
                        byte bByteValue = b.byteValue();
                        sb.append(ByteArrayStringConverter.HEX.charAt((bByteValue & 240) >>> 4));
                        sb.append(ByteArrayStringConverter.HEX.charAt(bByteValue & Ascii.SI));
                    }
                }
                return sb.toString();
            }

            @Override // org.joda.convert.FromStringConverter
            public Byte[] convertFromString(Class<? extends Byte[]> cls, String str) {
                if (str.length() == 0) {
                    return ByteArrayStringConverter.EMPTY;
                }
                if (str.length() % 2 == 1) {
                    throw new IllegalArgumentException("Invalid Byte[] string");
                }
                int length = str.length() / 2;
                Byte[] bArr = new Byte[length];
                for (int i = 0; i < length; i++) {
                    int i2 = i * 2;
                    String strSubstring = str.substring(i2, i2 + 2);
                    if (strSubstring.equals("--")) {
                        bArr[i] = null;
                    } else {
                        bArr[i] = Byte.valueOf((byte) Integer.parseInt(strSubstring, 16));
                    }
                }
                return bArr;
            }

            @Override // org.joda.convert.TypedStringConverter, org.joda.convert.TypedFromStringConverter
            public Class<?> getEffectiveType() {
                return Byte[].class;
            }
        };

        private static final Byte[] EMPTY = new Byte[0];
        private static final String HEX = "0123456789ABCDEF";
    }
}
