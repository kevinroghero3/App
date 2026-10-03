package org.joda.convert;

import com.facebook.hermes.intl.Constants;
import java.io.File;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes6.dex */
enum JDKStringConverter implements TypedStringConverter<Object> {
    STRING(String.class) { // from class: org.joda.convert.JDKStringConverter.1
        @Override // org.joda.convert.FromStringConverter
        public Object convertFromString(Class<?> cls, String str) {
            return str;
        }
    },
    CHAR_SEQUENCE(CharSequence.class) { // from class: org.joda.convert.JDKStringConverter.2
        @Override // org.joda.convert.FromStringConverter
        public Object convertFromString(Class<?> cls, String str) {
            return str;
        }
    },
    STRING_BUFFER(StringBuffer.class) { // from class: org.joda.convert.JDKStringConverter.3
        @Override // org.joda.convert.FromStringConverter
        public Object convertFromString(Class<?> cls, String str) {
            return new StringBuffer(str);
        }
    },
    STRING_BUILDER(StringBuilder.class) { // from class: org.joda.convert.JDKStringConverter.4
        @Override // org.joda.convert.FromStringConverter
        public Object convertFromString(Class<?> cls, String str) {
            return new StringBuilder(str);
        }
    },
    LONG(Long.class) { // from class: org.joda.convert.JDKStringConverter.5
        @Override // org.joda.convert.FromStringConverter
        public Object convertFromString(Class<?> cls, String str) {
            return Long.valueOf(str);
        }
    },
    INTEGER(Integer.class) { // from class: org.joda.convert.JDKStringConverter.6
        @Override // org.joda.convert.FromStringConverter
        public Object convertFromString(Class<?> cls, String str) {
            return Integer.valueOf(str);
        }
    },
    SHORT(Short.class) { // from class: org.joda.convert.JDKStringConverter.7
        @Override // org.joda.convert.FromStringConverter
        public Object convertFromString(Class<?> cls, String str) {
            return Short.valueOf(str);
        }
    },
    BYTE(Byte.class) { // from class: org.joda.convert.JDKStringConverter.8
        @Override // org.joda.convert.FromStringConverter
        public Object convertFromString(Class<?> cls, String str) {
            return Byte.valueOf(str);
        }
    },
    BYTE_ARRAY(byte[].class) { // from class: org.joda.convert.JDKStringConverter.9
        @Override // org.joda.convert.JDKStringConverter, org.joda.convert.ToStringConverter
        public String convertToString(Object obj) {
            return JDKStringConverter.printBase64Binary((byte[]) obj);
        }

        @Override // org.joda.convert.FromStringConverter
        public Object convertFromString(Class<?> cls, String str) {
            return JDKStringConverter.parseBase64Binary(str);
        }
    },
    CHARACTER(Character.class) { // from class: org.joda.convert.JDKStringConverter.10
        @Override // org.joda.convert.FromStringConverter
        public Object convertFromString(Class<?> cls, String str) {
            if (str.length() != 1) {
                throw new IllegalArgumentException("Character value must be a string length 1");
            }
            return Character.valueOf(str.charAt(0));
        }
    },
    CHAR_ARRAY(char[].class) { // from class: org.joda.convert.JDKStringConverter.11
        @Override // org.joda.convert.JDKStringConverter, org.joda.convert.ToStringConverter
        public String convertToString(Object obj) {
            return new String((char[]) obj);
        }

        @Override // org.joda.convert.FromStringConverter
        public Object convertFromString(Class<?> cls, String str) {
            return str.toCharArray();
        }
    },
    BOOLEAN(Boolean.class) { // from class: org.joda.convert.JDKStringConverter.12
        @Override // org.joda.convert.FromStringConverter
        public Object convertFromString(Class<?> cls, String str) {
            if ("true".equalsIgnoreCase(str)) {
                return Boolean.TRUE;
            }
            if (Constants.CASEFIRST_FALSE.equalsIgnoreCase(str)) {
                return Boolean.FALSE;
            }
            throw new IllegalArgumentException("Boolean value must be 'true' or 'false', case insensitive");
        }
    },
    DOUBLE(Double.class) { // from class: org.joda.convert.JDKStringConverter.13
        @Override // org.joda.convert.FromStringConverter
        public Object convertFromString(Class<?> cls, String str) {
            return Double.valueOf(str);
        }
    },
    FLOAT(Float.class) { // from class: org.joda.convert.JDKStringConverter.14
        @Override // org.joda.convert.FromStringConverter
        public Object convertFromString(Class<?> cls, String str) {
            return Float.valueOf(str);
        }
    },
    BIG_INTEGER(BigInteger.class) { // from class: org.joda.convert.JDKStringConverter.15
        @Override // org.joda.convert.FromStringConverter
        public Object convertFromString(Class<?> cls, String str) {
            return new BigInteger(str);
        }
    },
    BIG_DECIMAL(BigDecimal.class) { // from class: org.joda.convert.JDKStringConverter.16
        @Override // org.joda.convert.FromStringConverter
        public Object convertFromString(Class<?> cls, String str) {
            return new BigDecimal(str);
        }
    },
    ATOMIC_LONG(AtomicLong.class) { // from class: org.joda.convert.JDKStringConverter.17
        @Override // org.joda.convert.FromStringConverter
        public Object convertFromString(Class<?> cls, String str) {
            return new AtomicLong(Long.parseLong(str));
        }
    },
    ATOMIC_INTEGER(AtomicInteger.class) { // from class: org.joda.convert.JDKStringConverter.18
        @Override // org.joda.convert.FromStringConverter
        public Object convertFromString(Class<?> cls, String str) {
            return new AtomicInteger(Integer.parseInt(str));
        }
    },
    ATOMIC_BOOLEAN(AtomicBoolean.class) { // from class: org.joda.convert.JDKStringConverter.19
        @Override // org.joda.convert.FromStringConverter
        public Object convertFromString(Class<?> cls, String str) {
            if ("true".equalsIgnoreCase(str)) {
                return new AtomicBoolean(true);
            }
            if (Constants.CASEFIRST_FALSE.equalsIgnoreCase(str)) {
                return new AtomicBoolean(false);
            }
            throw new IllegalArgumentException("Boolean value must be 'true' or 'false', case insensitive");
        }
    },
    LOCALE(Locale.class) { // from class: org.joda.convert.JDKStringConverter.20
        @Override // org.joda.convert.FromStringConverter
        public Object convertFromString(Class<?> cls, String str) {
            String[] strArrSplit = str.split("_", 3);
            int length = strArrSplit.length;
            if (length == 1) {
                return new Locale(strArrSplit[0]);
            }
            if (length == 2) {
                return new Locale(strArrSplit[0], strArrSplit[1]);
            }
            if (length == 3) {
                return new Locale(strArrSplit[0], strArrSplit[1], strArrSplit[2]);
            }
            throw new IllegalArgumentException("Unable to parse Locale: " + str);
        }
    },
    CLASS(Class.class) { // from class: org.joda.convert.JDKStringConverter.21
        @Override // org.joda.convert.JDKStringConverter, org.joda.convert.ToStringConverter
        public String convertToString(Object obj) {
            return ((Class) obj).getName();
        }

        @Override // org.joda.convert.FromStringConverter
        public Object convertFromString(Class<?> cls, String str) {
            try {
                return RenameHandler.INSTANCE.lookupType(str);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException("Unable to create type: " + str, e);
            }
        }
    },
    PACKAGE(Package.class) { // from class: org.joda.convert.JDKStringConverter.22
        @Override // org.joda.convert.JDKStringConverter, org.joda.convert.ToStringConverter
        public String convertToString(Object obj) {
            return ((Package) obj).getName();
        }

        @Override // org.joda.convert.FromStringConverter
        public Object convertFromString(Class<?> cls, String str) {
            return Package.getPackage(str);
        }
    },
    CURRENCY(Currency.class) { // from class: org.joda.convert.JDKStringConverter.23
        @Override // org.joda.convert.FromStringConverter
        public Object convertFromString(Class<?> cls, String str) {
            return Currency.getInstance(str);
        }
    },
    TIME_ZONE(TimeZone.class) { // from class: org.joda.convert.JDKStringConverter.24
        @Override // org.joda.convert.JDKStringConverter, org.joda.convert.ToStringConverter
        public String convertToString(Object obj) {
            return ((TimeZone) obj).getID();
        }

        @Override // org.joda.convert.FromStringConverter
        public Object convertFromString(Class<?> cls, String str) {
            return TimeZone.getTimeZone(str);
        }
    },
    UUID(UUID.class) { // from class: org.joda.convert.JDKStringConverter.25
        @Override // org.joda.convert.FromStringConverter
        public Object convertFromString(Class<?> cls, String str) {
            return UUID.fromString(str);
        }
    },
    URL(URL.class) { // from class: org.joda.convert.JDKStringConverter.26
        @Override // org.joda.convert.FromStringConverter
        public Object convertFromString(Class<?> cls, String str) {
            try {
                return new URL(str);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e.getMessage(), e);
            }
        }
    },
    URI(URI.class) { // from class: org.joda.convert.JDKStringConverter.27
        @Override // org.joda.convert.FromStringConverter
        public Object convertFromString(Class<?> cls, String str) {
            return URI.create(str);
        }
    },
    INET_ADDRESS(InetAddress.class) { // from class: org.joda.convert.JDKStringConverter.28
        @Override // org.joda.convert.JDKStringConverter, org.joda.convert.ToStringConverter
        public String convertToString(Object obj) {
            return ((InetAddress) obj).getHostAddress();
        }

        @Override // org.joda.convert.FromStringConverter
        public Object convertFromString(Class<?> cls, String str) {
            try {
                return InetAddress.getByName(str);
            } catch (UnknownHostException e) {
                throw new RuntimeException(e);
            }
        }
    },
    FILE(File.class) { // from class: org.joda.convert.JDKStringConverter.29
        @Override // org.joda.convert.FromStringConverter
        public Object convertFromString(Class<?> cls, String str) {
            return new File(str);
        }
    },
    DATE(Date.class) { // from class: org.joda.convert.JDKStringConverter.30
        @Override // org.joda.convert.JDKStringConverter, org.joda.convert.ToStringConverter
        public String convertToString(Object obj) {
            String str = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").format(obj);
            return str.substring(0, 26) + ":" + str.substring(26);
        }

        @Override // org.joda.convert.FromStringConverter
        public Object convertFromString(Class<?> cls, String str) {
            if (str.length() != 29) {
                throw new IllegalArgumentException("Unable to parse date: " + str);
            }
            try {
                return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").parseObject(str.substring(0, 26) + str.substring(27));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
    },
    CALENDAR(Calendar.class) { // from class: org.joda.convert.JDKStringConverter.31
        @Override // org.joda.convert.JDKStringConverter, org.joda.convert.ToStringConverter
        public String convertToString(Object obj) {
            if (!(obj instanceof GregorianCalendar)) {
                throw new RuntimeException("Unable to convert calendar as it is not a GregorianCalendar");
            }
            GregorianCalendar gregorianCalendar = (GregorianCalendar) obj;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
            simpleDateFormat.setCalendar(gregorianCalendar);
            String str = simpleDateFormat.format(gregorianCalendar.getTime());
            return str.substring(0, 26) + ":" + str.substring(26) + "[" + gregorianCalendar.getTimeZone().getID() + "]";
        }

        @Override // org.joda.convert.FromStringConverter
        public Object convertFromString(Class<?> cls, String str) {
            if (str.length() < 31 || str.charAt(26) != ':' || str.charAt(29) != '[' || str.charAt(str.length() - 1) != ']') {
                throw new IllegalArgumentException("Unable to parse date: " + str);
            }
            TimeZone timeZone = TimeZone.getTimeZone(str.substring(30, str.length() - 1));
            String str2 = str.substring(0, 26) + str.substring(27, 29);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
            GregorianCalendar gregorianCalendar = new GregorianCalendar(timeZone);
            gregorianCalendar.setTimeInMillis(0L);
            simpleDateFormat.setCalendar(gregorianCalendar);
            try {
                simpleDateFormat.parseObject(str2);
                return simpleDateFormat.getCalendar();
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
    };

    private static final int MASK_6BIT = 63;
    private static final int MASK_8BIT = 255;
    private Class<?> type;
    private static String base64Str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=";
    private static char[] base64Array = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".toCharArray();

    JDKStringConverter(Class cls) {
        this.type = cls;
    }

    Class<?> getType() {
        return this.type;
    }

    @Override // org.joda.convert.TypedStringConverter, org.joda.convert.TypedFromStringConverter
    public Class<?> getEffectiveType() {
        return this.type;
    }

    @Override // org.joda.convert.ToStringConverter
    public String convertToString(Object obj) {
        return obj.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String printBase64Binary(byte[] bArr) {
        int i;
        int length = bArr.length;
        char[] cArr = new char[((length + 2) / 3) * 4];
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3 += 3) {
            int i4 = length - i3;
            if (i4 >= 3) {
                int i5 = ((bArr[i3] & 255) << 16) | ((bArr[i3 + 1] & 255) << 8) | (bArr[i3 + 2] & 255);
                char[] cArr2 = base64Array;
                cArr[i2] = cArr2[(i5 >>> 18) & 63];
                cArr[i2 + 1] = cArr2[(i5 >>> 12) & 63];
                cArr[i2 + 2] = cArr2[(i5 >>> 6) & 63];
                cArr[i2 + 3] = cArr2[i5 & 63];
                i2 += 4;
            } else {
                if (i4 == 2) {
                    int i6 = ((bArr[i3] & 255) << 16) | ((bArr[i3 + 1] & 255) << 8);
                    char[] cArr3 = base64Array;
                    cArr[i2] = cArr3[(i6 >>> 18) & 63];
                    cArr[i2 + 1] = cArr3[(i6 >>> 12) & 63];
                    cArr[i2 + 2] = cArr3[(i6 >>> 6) & 63];
                    i = i2 + 4;
                    cArr[i2 + 3] = '=';
                } else {
                    int i7 = (bArr[i3] & 255) << 16;
                    char[] cArr4 = base64Array;
                    cArr[i2] = cArr4[(i7 >>> 18) & 63];
                    cArr[i2 + 1] = cArr4[(i7 >>> 12) & 63];
                    cArr[i2 + 2] = '=';
                    i = i2 + 4;
                    cArr[i2 + 3] = '=';
                }
                i2 = i;
            }
        }
        return new String(cArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] parseBase64Binary(String str) {
        if (str.length() % 4 != 0) {
            throw new IllegalArgumentException("Invalid Base64 string");
        }
        int length = (str.length() * 3) / 4;
        byte[] bArr = new byte[length];
        char[] charArray = str.toCharArray();
        int i = 0;
        int i2 = 0;
        while (i < charArray.length) {
            int i3 = i + 4;
            int iIndexOf = (base64Str.indexOf(charArray[i + 3]) & 63) | ((base64Str.indexOf(charArray[i]) & 63) << 18) | ((base64Str.indexOf(charArray[i + 1]) & 63) << 12) | ((base64Str.indexOf(charArray[i + 2]) & 63) << 6);
            bArr[i2] = (byte) ((iIndexOf >>> 16) & 255);
            bArr[i2 + 1] = (byte) ((iIndexOf >>> 8) & 255);
            bArr[i2 + 2] = (byte) (iIndexOf & 255);
            i2 += 3;
            i = i3;
        }
        if (str.endsWith("==")) {
            int i4 = length - 2;
            byte[] bArr2 = new byte[i4];
            System.arraycopy(bArr, 0, bArr2, 0, i4);
            return bArr2;
        }
        if (!str.endsWith("=")) {
            return bArr;
        }
        int i5 = length - 1;
        byte[] bArr3 = new byte[i5];
        System.arraycopy(bArr, 0, bArr3, 0, i5);
        return bArr3;
    }
}
