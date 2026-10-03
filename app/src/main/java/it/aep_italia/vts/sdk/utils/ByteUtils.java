package it.aep_italia.vts.sdk.utils;

import com.facebook.appevents.AppEventsConstants;
import java.util.Arrays;
import java.util.Locale;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes6.dex */
public class ByteUtils {
    public static String byteToHexString(byte b) {
        int iByteToInt = byteToInt(b);
        String upperCase = Long.toHexString(iByteToInt).toUpperCase(Locale.ITALY);
        if (iByteToInt >= 16) {
            return upperCase;
        }
        return '0' + upperCase;
    }

    public static int byteToInt(byte b) {
        return b < 0 ? b + 256 : b;
    }

    public static String bytesToHexString(byte[] bArr) {
        return bytesToHexString(bArr, org.apache.commons.lang3.StringUtils.SPACE);
    }

    public static String bytesToHexString(byte[] bArr, int i, int i2, String str) {
        if (bArr == null) {
            return null;
        }
        if (bArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int i3 = 0;
        while (true) {
            int i4 = i3 + i;
            if (i4 >= bArr.length || i3 >= i2) {
                break;
            }
            sb.append(byteToHexString(bArr[i4]));
            if (i4 < bArr.length - 1) {
                sb.append(str);
            }
            i3++;
        }
        return sb.toString();
    }

    public static String bytesToHexString(byte[] bArr, String str) {
        if (bArr == null) {
            return null;
        }
        return bytesToHexString(bArr, 0, bArr.length, str);
    }

    public static int bytesToInt(byte[] bArr) {
        return bytesToInt(bArr, 0);
    }

    public static int bytesToInt(byte[] bArr, int i) {
        if (bArr == null || bArr.length <= i) {
            return 0;
        }
        int iMax = Math.max(0, i);
        int i2 = 0;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            int length = (bArr.length - i3) - 1;
            if (iMax <= length) {
                i2 |= (bArr[length] & 255) << (i3 * 8);
            }
        }
        return i2;
    }

    public static long bytesToLong(byte[] bArr) {
        return bytesToLong(bArr, 0);
    }

    public static long bytesToLong(byte[] bArr, int i) {
        long j = 0;
        if (bArr != null && bArr.length != 0) {
            int iMax = Math.max(0, i);
            for (int i2 = 0; i2 < bArr.length; i2++) {
                int length = (bArr.length - i2) - 1;
                if (iMax <= length) {
                    j |= (((long) bArr[length]) & 255) << (i2 * 8);
                }
            }
        }
        return j;
    }

    public static byte[] extract(byte[] bArr, int i, int i2) {
        if (bArr == null || i < 0 || i2 < 0) {
            return null;
        }
        int iMax = Math.max(0, Math.min(i2, bArr.length - i));
        return iMax == 0 ? new byte[0] : Arrays.copyOfRange(bArr, i, iMax + i);
    }

    public static byte[] longToBytes(long j, int i) {
        int iMin = 8 - Math.min(8, Math.max(0, i));
        byte[] bArr = new byte[iMin];
        for (int i2 = 0; i2 < iMin; i2++) {
            bArr[(iMin - i2) - 1] = (byte) ((j >> (i2 * 8)) & 255);
        }
        return bArr;
    }

    public static byte stringToByte(String str) {
        if (str == null) {
            return (byte) 0;
        }
        String strReplaceAll = str.replaceAll(org.apache.commons.lang3.StringUtils.SPACE, "");
        if (strReplaceAll.length() != 2) {
            throw new IllegalArgumentException("Input string must be exactly two characters long.");
        }
        if (Pattern.matches("^[0-9a-fA-F]+$", strReplaceAll)) {
            return (byte) (Integer.parseInt(strReplaceAll, 16) & 255);
        }
        throw new IllegalArgumentException("Expected a hexadecimal string, got: \"" + strReplaceAll + "\".");
    }

    public static byte[] stringToBytes(String str) {
        if (str == null) {
            return null;
        }
        String strReplaceAll = str.replaceAll(org.apache.commons.lang3.StringUtils.SPACE, "");
        int i = 0;
        if (strReplaceAll.length() == 0) {
            return new byte[0];
        }
        if (!Pattern.matches("^[0-9a-fA-F]+$", strReplaceAll)) {
            throw new IllegalArgumentException("String must be in hexadecimal format.");
        }
        if (strReplaceAll.length() % 2 == 1) {
            strReplaceAll = '0' + strReplaceAll;
        }
        int length = strReplaceAll.length() / 2;
        byte[] bArr = new byte[length];
        int i2 = 0;
        while (i < length) {
            int i3 = i * 2;
            bArr[i2] = (byte) (Integer.parseInt(strReplaceAll.substring(i3, i3 + 2), 16) & 255);
            i++;
            i2++;
        }
        return bArr;
    }

    public static String toString(byte b) {
        String upperCase = Integer.toHexString(b & 255).toUpperCase();
        if (upperCase.length() != 1) {
            return upperCase;
        }
        return AppEventsConstants.EVENT_PARAM_VALUE_NO + upperCase;
    }

    public static String toString(byte[] bArr) {
        return toString(bArr, org.apache.commons.lang3.StringUtils.SPACE);
    }

    public static String toString(byte[] bArr, int i, int i2, String str) {
        if (bArr == null) {
            return null;
        }
        if (bArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int i3 = 0;
        while (true) {
            int i4 = i3 + i;
            if (i4 >= bArr.length || i3 >= i2) {
                break;
            }
            sb.append(toString(bArr[i4]));
            if (i4 < bArr.length - 1) {
                sb.append(str);
            }
            i3++;
        }
        return sb.toString();
    }

    public static String toString(byte[] bArr, String str) {
        return toString(bArr, 0, bArr.length, str);
    }
}
