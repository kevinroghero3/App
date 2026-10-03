package o;

import com.google.common.base.Ascii;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: classes3.dex */
public class getDefaultImpl {
    private static int MediaDescriptionCompat;
    private static final byte[] getMediaDescription = {5, Ascii.FF, -27, -23, 3, 5, -10, -24, Ascii.GS, -7, Ascii.DLE, -17, 17, 7, -21, 5, -21, 8, 33, -79, 83, 2, -12, Ascii.VT, -19, 1, 10, -7, -69, 65, 17, -15, 5, 1, Ascii.VT, -15, -2, 17, 1, -3, -13, -69, 70, 9, 6, -7, -10, -68, 70, 9, 3, -82, 78, -13, 19, -11, Ascii.CR, -17, -69, 76, -3, -7, Ascii.DLE, -17, 17, 7, -63, -26};
    private static final int getIconUri = 230;

    public static String coroutineCreation(int i) {
        return null;
    }

    public static String getARTIFICIAL_FRAME_PACKAGE_NAME(int i) {
        return null;
    }

    public static String CoroutineDebuggingKt(Class cls, String str) {
        try {
            int iCoroutineDebuggingKt = CoroutineDebuggingKt(str.getBytes(StandardCharsets.UTF_8));
            String strCoroutineCreation = coroutineCreation(iCoroutineDebuggingKt);
            if (strCoroutineCreation == null) {
                byte[] bArr = getMediaDescription;
                byte b = bArr[25];
                Object[] objArr = new Object[1];
                a((byte) (b - 1), (byte) (-b), bArr[0], objArr);
                Method declaredMethod = ClassLoader.class.getDeclaredMethod((String) objArr[0], String.class);
                declaredMethod.setAccessible(true);
                return (String) declaredMethod.invoke(getDefaultImpl.class.getClassLoader(), str);
            }
            int iCoroutineCreation = coroutineCreation(cls, str, strCoroutineCreation);
            int i = iCoroutineDebuggingKt ^ iCoroutineCreation;
            String artificial_frame_package_name = getARTIFICIAL_FRAME_PACKAGE_NAME(i);
            if (artificial_frame_package_name != null) {
                return artificial_frame_package_name;
            }
            byte[] bArr2 = getMediaDescription;
            byte b2 = bArr2[25];
            Object[] objArr2 = new Object[1];
            a((byte) (b2 - 1), (byte) (-b2), bArr2[0], objArr2);
            Method declaredMethod2 = ClassLoader.class.getDeclaredMethod((String) objArr2[0], String.class);
            declaredMethod2.setAccessible(true);
            Object objInvoke = declaredMethod2.invoke(getDefaultImpl.class.getClassLoader(), str);
            if (objInvoke == null) {
                StringBuilder sb = new StringBuilder();
                Object[] objArr3 = new Object[1];
                a(bArr2[18], bArr2[43], bArr2[21], objArr3);
                sb.append((String) objArr3[0]);
                sb.append(str);
                byte b3 = (byte) 58;
                Object[] objArr4 = new Object[1];
                a(b3, bArr2[56], (byte) (bArr2[25] - 1), objArr4);
                sb.append((String) objArr4[0]);
                sb.append(strCoroutineCreation);
                Object[] objArr5 = new Object[1];
                a(b3, bArr2[56], (byte) (bArr2[25] - 1), objArr5);
                sb.append((String) objArr5[0]);
                sb.append(i);
                Object[] objArr6 = new Object[1];
                a(b3, bArr2[56], (byte) (bArr2[25] - 1), objArr6);
                sb.append((String) objArr6[0]);
                sb.append(iCoroutineCreation);
                Object[] objArr7 = new Object[1];
                a((byte) 61, bArr2[56], (byte) (bArr2[25] - 1), objArr7);
                sb.append((String) objArr7[0]);
                throw new RuntimeException(sb.toString());
            }
            return (String) objInvoke;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static int coroutineCreation(Class cls, String str, String str2) throws NoSuchMethodException, IOException {
        byte[] bArr = getMediaDescription;
        byte b = bArr[25];
        Object[] objArr = new Object[1];
        a((byte) (b - 1), (byte) (-b), bArr[0], objArr);
        Method declaredMethod = ClassLoader.class.getDeclaredMethod((String) objArr[0], String.class);
        declaredMethod.setAccessible(true);
        String str3 = (String) declaredMethod.invoke(cls.getClassLoader(), str2);
        if (str3 == null) {
            StringBuilder sb = new StringBuilder();
            Object[] objArr2 = new Object[1];
            a((byte) (-bArr[7]), bArr[56], (byte) 25, objArr2);
            sb.append((String) objArr2[0]);
            sb.append(str);
            throw new IllegalArgumentException(sb.toString());
        }
        InputStream fileInputStream = null;
        try {
            Object[] objArr3 = new Object[1];
            a((byte) (-bArr[28]), (byte) (-bArr[66]), (byte) (bArr[25] - 1), objArr3);
            if (str3.contains((String) objArr3[0])) {
                int iLastIndexOf = str3.lastIndexOf(33);
                String strSubstring = str3.substring(0, iLastIndexOf);
                String strSubstring2 = str3.substring(iLastIndexOf + 1);
                Object[] objArr4 = new Object[1];
                a((byte) 55, (byte) (-bArr[66]), (byte) (bArr[25] - 1), objArr4);
                if (strSubstring2.startsWith((String) objArr4[0])) {
                    strSubstring2 = strSubstring2.substring(1);
                }
                ZipFile zipFile = new ZipFile(strSubstring);
                fileInputStream = zipFile.getInputStream(zipFile.getEntry(strSubstring2));
            } else {
                fileInputStream = new FileInputStream(str3);
            }
            fileInputStream.skip(4L);
            int i = fileInputStream.read() == 1 ? 4 : 8;
            fileInputStream.skip(i + 19 + i + i + 16);
            return (fileInputStream.read() << 24) | (fileInputStream.read() << 16) | (fileInputStream.read() << 8) | fileInputStream.read();
        } finally {
            if (fileInputStream != null) {
                fileInputStream.close();
            }
        }
    }

    private static int CoroutineDebuggingKt(byte[] bArr) {
        int i = MediaDescriptionCompat;
        for (byte b : bArr) {
            i = (i ^ b) * 16777619;
        }
        return i;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0022  */
    /* JADX WARN: Code duplicated, block: B:8:0x001a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0022 -> B:11:0x002a). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0022
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void a(byte r6, byte r7, short r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = o.getDefaultImpl.getMediaDescription
            int r6 = 102 - r6
            int r8 = r8 * 2
            int r1 = r8 + 1
            int r7 = r7 + 4
            byte[] r1 = new byte[r1]
            r2 = 0
            if (r0 != 0) goto L12
            r3 = r7
            r4 = r2
            goto L2a
        L12:
            r3 = r2
        L13:
            int r7 = r7 + 1
            byte r4 = (byte) r6
            r1[r3] = r4
            if (r3 != r8) goto L22
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L22:
            int r3 = r3 + 1
            r4 = r0[r7]
            r5 = r3
            r3 = r7
            r7 = r4
            r4 = r5
        L2a:
            int r6 = r6 + r7
            r7 = r3
            r3 = r4
            goto L13
        */
        throw new UnsupportedOperationException("Method not decompiled: o.getDefaultImpl.a(byte, byte, short, java.lang.Object[]):void");
    }
}
