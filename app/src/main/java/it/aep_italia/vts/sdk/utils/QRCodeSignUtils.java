package it.aep_italia.vts.sdk.utils;

import com.google.common.base.Ascii;
import it.aep_italia.vts.sdk.core.VtsLog;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.io.encoding.Base64;
import okio.Utf8;

/* JADX INFO: loaded from: classes6.dex */
public class QRCodeSignUtils {
    private static final byte[][] c;
    int a = 32;
    byte[] b = {-82, -82, -82, -82, -82, -82, -82, -82, -82, -82, -82, -82, -82, -82, -82, -82};

    static {
        byte[] bArr = new byte[16];
        // fill-array-data instruction
        bArr[0] = 22;
        bArr[1] = -126;
        bArr[2] = 29;
        bArr[3] = -45;
        bArr[4] = 66;
        bArr[5] = 127;
        bArr[6] = -26;
        bArr[7] = -85;
        bArr[8] = -44;
        bArr[9] = -29;
        bArr[10] = -37;
        bArr[11] = 12;
        bArr[12] = 102;
        bArr[13] = -19;
        bArr[14] = -45;
        bArr[15] = 33;
        c = new byte[][]{new byte[]{-2, 99, 112, -48, 39, 85, 87, 17, -95, 43, 55, 8, Ascii.SUB, Ascii.VT, -18, 50}, new byte[]{-36, 77, -61, 58, Ascii.DLE, -82, -55, 38, -5, Ascii.GS, -51, -50, -10, 102, 79, 84}, new byte[]{-2, Ascii.VT, 92, 127, -67, 44, -13, -86, 39, -103, -90, -30, 37, 106, -18, -62}, new byte[]{34, -29, 97, -66, 47, -87, -4, Ascii.DC4, -91, 127, 105, -25, -77, 83, -20, -4}, new byte[]{-101, -11, -5, 115, 35, -37, 98, -53, -96, Ascii.CR, 43, -14, -28, 95, 77, Ascii.SO}, new byte[]{-35, -69, -114, 32, -4, -107, -24, 115, -86, -122, -29, Ascii.ETB, -82, Ascii.ETB, 5, -95}, new byte[]{100, -101, -82, 59, -58, 9, Ascii.CAN, 3, 94, 17, Ascii.NAK, -100, 8, Base64.padSymbol, -104, -127}, new byte[]{32, -32, 66, -99, -73, -103, 102, -33, -4, 59, -86, 85, 117, -112, -123, 98}, new byte[]{33, -44, -41, 49, -58, 2, Ascii.GS, 90, -112, -17, -103, 35, 17, -102, 107, -113}, new byte[]{-96, -45, 6, 50, -119, -79, 43, -123, 96, -40, -55, -88, 68, 8, -95, 109}, new byte[]{-3, -65, -39, -128, -51, -81, -92, 118, -51, 76, -50, -109, 1, 74, 32, Ascii.GS}, new byte[]{-72, 119, -83, 8, -100, 5, -113, 2, 120, Ascii.DC2, Utf8.REPLACEMENT_BYTE, -109, 126, -80, -94, Ascii.DLE}, new byte[]{-33, 96, -94, Ascii.VT, -96, -6, 114, 34, 103, 77, 39, 109, -96, -128, 39, -87}, new byte[]{99, -68, -103, 50, -4, -111, Ascii.GS, -19, 77, -19, 66, 127, -54, -71, Ascii.FF, 10}, bArr, new byte[]{Ascii.DLE, 103, -11, 46, 102, -2, 74, -18, 56, -45, -62, 97, 93, 36, 102, 66}, new byte[]{67, -53, Ascii.RS, 118, -127, -59, -106, -48, Ascii.DLE, -40, 59, Ascii.ESC, Ascii.SYN, -103, -19, 62}, new byte[]{122, 52, 10, 48, 81, -78, 51, -58, -18, -42, -59, -29, -32, 38, 94, 59}, new byte[]{-100, -118, -5, -44, 56, 45, -7, -31, -60, -35, -30, -65, 108, -34, Ascii.SI, -61}, new byte[]{57, 51, -80, Ascii.US, 73, 1, -57, 5, 114, 55, 41, -70, Ascii.DC2, -12, Ascii.CAN, -41}, new byte[]{44, 45, 116, -123, -81, 36, Ascii.SO, 108, 72, 81, -111, -61, 106, -117, 35, -59}, new byte[]{121, -7, -21, 5, -43, 6, 68, -77, Ascii.ESC, -51, -17, 71, 80, -45, 0, 114}, new byte[]{54, -69, 17, Utf8.REPLACEMENT_BYTE, 109, -26, 47, 74, -8, -86, 44, 71, 105, 124, -125, 36}, new byte[]{40, -75, 103, -33, 5, -70, 42, -41, Ascii.ESC, -93, 83, 95, -21, -104, -23, 76}, new byte[]{-55, -6, 95, -19, -93, -128, 77, -34, 54, -98, -31, Base64.padSymbol, -73, 49, Ascii.VT, -28}};
    }

    public byte[] makeSignature(byte[] bArr, long j, long j2) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            VtsLog.d("Calculating QRCode signature\", SignatureType=%d, SignatureKey=%d", Long.valueOf(j), Long.valueOf(j2));
            byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 0, bArr.length - 6);
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            byteArrayOutputStream2.write(bArrCopyOfRange);
            byteArrayOutputStream2.write((byte) j);
            int i = (int) j2;
            byteArrayOutputStream2.write((byte) i);
            byte[] byteArray = byteArrayOutputStream2.toByteArray();
            byte[] bArr2 = new byte[this.a + 1];
            Arrays.fill(bArr2, Ascii.SUB);
            byte[] bArr3 = new byte[(this.a * 2) + 1];
            byte[] bArrSha1Encrypt = sha1Encrypt(bArr2, byteArray);
            StringBuilder sb = new StringBuilder();
            int i2 = 0;
            while (i2 < this.a) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(i2 > 0 ? String.format(" %02X", Byte.valueOf(bArrSha1Encrypt[i2])) : String.format("%02X", Byte.valueOf(bArrSha1Encrypt[i2])));
                sb.append(sb2.toString());
                i2++;
            }
            VtsLog.d("SHA1 QRCode Digest calculated. Encrypting it (AES).... DigestStr=%s, DigestLen=20, AesDigestLen=%d", sb, Integer.valueOf(bArrSha1Encrypt.length));
            byte[] bArrSelectVtsKey = selectVtsKey(i, 16);
            StringBuilder sb3 = new StringBuilder();
            for (byte b : bArrSelectVtsKey) {
                sb3.append(ByteUtils.byteToHexString(b));
                sb3.append(org.apache.commons.lang3.StringUtils.SPACE);
            }
            System.out.println(String.format("Performing AES Encryption.. SelectKeyStr=%s", sb3.toString().trim()));
            vtsAes128Encrypt(bArrSelectVtsKey, bArrSha1Encrypt, this.a, bArr3);
            byte[] bArrCopyOfRange2 = Arrays.copyOfRange(bArr3, 0, 32);
            StringBuilder sb4 = new StringBuilder();
            for (byte b2 : bArrCopyOfRange2) {
                sb4.append(ByteUtils.byteToHexString(b2));
                sb4.append(org.apache.commons.lang3.StringUtils.SPACE);
            }
            VtsLog.d("QRCode Digest Encrypted (AES). Calculating Signature... EncryptedDigestStr=%s", sb4.toString().trim());
            byte[] bArr4 = new byte[4];
            int i3 = 0;
            for (int i4 = 0; i4 < 8; i4++) {
                int i5 = 0;
                while (i5 < 4) {
                    bArr4[i5] = (byte) (bArr4[i5] ^ bArrCopyOfRange2[i3]);
                    i5++;
                    i3++;
                }
            }
            StringBuilder sb5 = new StringBuilder();
            for (int i6 = 0; i6 < 4; i6++) {
                sb5.append(ByteUtils.byteToHexString(bArr4[i6]));
                sb5.append(org.apache.commons.lang3.StringUtils.SPACE);
            }
            VtsLog.d("QRCode Signature computed, SignatureStr=%s", sb5.toString().trim());
            byteArrayOutputStream.write(byteArray);
            byteArrayOutputStream.write(bArr4[0]);
            byteArrayOutputStream.write(bArr4[1]);
            byteArrayOutputStream.write(bArr4[2]);
            byteArrayOutputStream.write(bArr4[3]);
            StringBuilder sb6 = new StringBuilder();
            for (byte b3 : byteArrayOutputStream.toByteArray()) {
                sb6.append(ByteUtils.byteToHexString(b3));
                sb6.append(org.apache.commons.lang3.StringUtils.SPACE);
            }
            VtsLog.d("QRCode Signature computed, Complete Token Signed HEX=%s", sb6.toString().trim());
        } catch (Exception unused) {
        }
        return byteArrayOutputStream.toByteArray();
    }

    public byte[] selectVtsKey(int i, int i2) {
        if (i2 != 16) {
            VtsLog.d("ERROR reason=\"Invalid Key size\", KeySize=%d, ExpectedKeySize=%d, RetCode=%d", Integer.valueOf(i2), 16, -1);
            return null;
        }
        if (i < 0 || i >= 25) {
            VtsLog.d("ERROR reason=\"Invalid Key index\", KeyIndex=%d, MaxKeys=%d, RetCode=%d", Integer.valueOf(i), 25, -1);
            return null;
        }
        byte[] bArr = new byte[16];
        System.arraycopy(c[i], 0, bArr, 0, 16);
        return bArr;
    }

    public byte[] sha1Encrypt(byte[] bArr, byte[] bArr2) throws Exception {
        System.out.println(String.format("reason=\"Calculating SHA1 QRCode Digest...\", QRCodeBuffer=%s, QRCodeBufferLen=%d", Arrays.toString(bArr2), Integer.valueOf(bArr2.length)));
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
        messageDigest.update((byte) -1);
        byte[] bArrDigest = messageDigest.digest(bArr2);
        System.arraycopy(bArrDigest, 0, bArr, 0, bArrDigest.length);
        byte[] bArrDigest2 = messageDigest.digest(bArr2);
        System.arraycopy(bArrDigest2, 0, bArr, 0, bArrDigest2.length);
        return bArr;
    }

    public void vtsAes128Encrypt(byte[] bArr, byte[] bArr2, long j, byte[] bArr3) {
        byte[] bArr4 = new byte[16];
        System.arraycopy(this.b, 0, bArr4, 0, 16);
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            cipher.init(1, secretKeySpec, new IvParameterSpec(bArr4));
            cipher.doFinal(bArr2, 0, this.a, bArr3);
        } catch (Exception unused) {
        }
    }
}
