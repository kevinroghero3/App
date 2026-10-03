package com.ReactNativeBlobUtil;

import android.content.res.AssetManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.SystemClock;
import android.util.Base64;
import android.view.KeyEvent;
import android.view.View;
import androidx.core.app.NotificationCompat;
import ch.qos.logback.core.pattern.parser.Parser;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.uimanager.ViewProps;
import io.sentry.instrumentation.file.SentryFileInputStream;
import io.sentry.instrumentation.file.SentryFileOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.UUID;
import net.openid.appauth.ResponseTypeValues;
import o.ArtificialStackFrames;
import org.apache.commons.lang3.CharEncoding;

/* JADX INFO: loaded from: classes4.dex */
public class ReactNativeBlobUtilStream {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static int artificialFrame = 1;
    private static final HashMap<String, ReactNativeBlobUtilStream> fileStreams = new HashMap<>();
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME;
    private final DeviceEventManagerModule.RCTDeviceEventEmitter emitter;
    private String encoding = ReactNativeBlobUtilConst.RNFB_RESPONSE_BASE64;
    private OutputStream writeStreamInstance = null;

    ReactNativeBlobUtilStream(ReactApplicationContext reactApplicationContext) {
        this.emitter = (DeviceEventManagerModule.RCTDeviceEventEmitter) reactApplicationContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class);
    }

    /* JADX WARN: Code duplicated, block: B:100:0x024d  */
    /* JADX WARN: Code duplicated, block: B:102:0x0263 A[Catch: Exception -> 0x02b0, FileNotFoundException -> 0x02d0, TryCatch #13 {FileNotFoundException -> 0x02d0, Exception -> 0x02b0, blocks: (B:108:0x0276, B:109:0x027b, B:93:0x0231, B:94:0x0235, B:95:0x0239, B:101:0x0254, B:104:0x026e, B:102:0x0263, B:111:0x0280, B:113:0x0288, B:114:0x0289, B:116:0x028b, B:118:0x0293, B:119:0x0294, B:121:0x0296, B:123:0x029e, B:124:0x029f, B:129:0x02a8, B:131:0x02ae, B:132:0x02af, B:11:0x003d, B:75:0x01af, B:62:0x0151, B:88:0x01f8), top: B:144:0x003d, inners: #5, #6, #10, #12 }] */
    /* JADX WARN: Code duplicated, block: B:10:0x003a A[PHI: r9
  0x003a: PHI (r9v7 java.lang.String) = (r9v4 java.lang.String), (r9v9 java.lang.String) binds: [B:8:0x002d, B:5:0x0026] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:157:0x0199 A[EDGE_INSN: B:157:0x0199->B:71:0x0199 BREAK  A[LOOP:0: B:66:0x0183->B:159:0x0183], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:158:0x0194 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:160:0x0183 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:162:0x01e9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:163:0x019f A[EDGE_INSN: B:163:0x019f->B:72:0x019f BREAK  A[LOOP:1: B:78:0x01cf->B:164:0x01cf], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:165:0x01cf A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:168:0x0276 A[EDGE_INSN: B:168:0x0276->B:108:0x0276 BREAK  A[LOOP:3: B:95:0x0239->B:171:0x0239], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:169:0x0274 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:170:0x026e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:172:0x0239 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:65:0x0171 A[Catch: Exception -> 0x02a0, FileNotFoundException -> 0x02a4, TRY_ENTER, TryCatch #12 {FileNotFoundException -> 0x02a4, Exception -> 0x02a0, blocks: (B:26:0x0096, B:65:0x0171, B:66:0x0183, B:68:0x018a, B:70:0x0194, B:71:0x0199, B:77:0x01cd, B:78:0x01cf, B:80:0x01d5, B:82:0x01dc, B:83:0x01e4, B:85:0x01e9, B:91:0x0217, B:34:0x0104, B:36:0x010a, B:37:0x010b, B:39:0x010d, B:41:0x0113, B:42:0x0114, B:43:0x0115, B:45:0x011b, B:46:0x011e, B:59:0x0132, B:60:0x0141, B:53:0x0126, B:55:0x012c, B:56:0x012d), top: B:156:0x0066 }] */
    /* JADX WARN: Code duplicated, block: B:68:0x018a A[Catch: Exception -> 0x02a0, FileNotFoundException -> 0x02a4, TryCatch #12 {FileNotFoundException -> 0x02a4, Exception -> 0x02a0, blocks: (B:26:0x0096, B:65:0x0171, B:66:0x0183, B:68:0x018a, B:70:0x0194, B:71:0x0199, B:77:0x01cd, B:78:0x01cf, B:80:0x01d5, B:82:0x01dc, B:83:0x01e4, B:85:0x01e9, B:91:0x0217, B:34:0x0104, B:36:0x010a, B:37:0x010b, B:39:0x010d, B:41:0x0113, B:42:0x0114, B:43:0x0115, B:45:0x011b, B:46:0x011e, B:59:0x0132, B:60:0x0141, B:53:0x0126, B:55:0x012c, B:56:0x012d), top: B:156:0x0066 }] */
    /* JADX WARN: Code duplicated, block: B:73:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:77:0x01cd A[Catch: Exception -> 0x02a0, FileNotFoundException -> 0x02a4, TRY_ENTER, TryCatch #12 {FileNotFoundException -> 0x02a4, Exception -> 0x02a0, blocks: (B:26:0x0096, B:65:0x0171, B:66:0x0183, B:68:0x018a, B:70:0x0194, B:71:0x0199, B:77:0x01cd, B:78:0x01cf, B:80:0x01d5, B:82:0x01dc, B:83:0x01e4, B:85:0x01e9, B:91:0x0217, B:34:0x0104, B:36:0x010a, B:37:0x010b, B:39:0x010d, B:41:0x0113, B:42:0x0114, B:43:0x0115, B:45:0x011b, B:46:0x011e, B:59:0x0132, B:60:0x0141, B:53:0x0126, B:55:0x012c, B:56:0x012d), top: B:156:0x0066 }] */
    /* JADX WARN: Code duplicated, block: B:80:0x01d5 A[Catch: Exception -> 0x02a0, FileNotFoundException -> 0x02a4, TryCatch #12 {FileNotFoundException -> 0x02a4, Exception -> 0x02a0, blocks: (B:26:0x0096, B:65:0x0171, B:66:0x0183, B:68:0x018a, B:70:0x0194, B:71:0x0199, B:77:0x01cd, B:78:0x01cf, B:80:0x01d5, B:82:0x01dc, B:83:0x01e4, B:85:0x01e9, B:91:0x0217, B:34:0x0104, B:36:0x010a, B:37:0x010b, B:39:0x010d, B:41:0x0113, B:42:0x0114, B:43:0x0115, B:45:0x011b, B:46:0x011e, B:59:0x0132, B:60:0x0141, B:53:0x0126, B:55:0x012c, B:56:0x012d), top: B:156:0x0066 }] */
    /* JADX WARN: Code duplicated, block: B:82:0x01dc A[Catch: Exception -> 0x02a0, FileNotFoundException -> 0x02a4, LOOP:2: B:81:0x01da->B:82:0x01dc, LOOP_END, TryCatch #12 {FileNotFoundException -> 0x02a4, Exception -> 0x02a0, blocks: (B:26:0x0096, B:65:0x0171, B:66:0x0183, B:68:0x018a, B:70:0x0194, B:71:0x0199, B:77:0x01cd, B:78:0x01cf, B:80:0x01d5, B:82:0x01dc, B:83:0x01e4, B:85:0x01e9, B:91:0x0217, B:34:0x0104, B:36:0x010a, B:37:0x010b, B:39:0x010d, B:41:0x0113, B:42:0x0114, B:43:0x0115, B:45:0x011b, B:46:0x011e, B:59:0x0132, B:60:0x0141, B:53:0x0126, B:55:0x012c, B:56:0x012d), top: B:156:0x0066 }] */
    /* JADX WARN: Code duplicated, block: B:87:0x01ee  */
    /* JADX WARN: Code duplicated, block: B:91:0x0217 A[Catch: Exception -> 0x02a0, FileNotFoundException -> 0x02a4, TRY_ENTER, TRY_LEAVE, TryCatch #12 {FileNotFoundException -> 0x02a4, Exception -> 0x02a0, blocks: (B:26:0x0096, B:65:0x0171, B:66:0x0183, B:68:0x018a, B:70:0x0194, B:71:0x0199, B:77:0x01cd, B:78:0x01cf, B:80:0x01d5, B:82:0x01dc, B:83:0x01e4, B:85:0x01e9, B:91:0x0217, B:34:0x0104, B:36:0x010a, B:37:0x010b, B:39:0x010d, B:41:0x0113, B:42:0x0114, B:43:0x0115, B:45:0x011b, B:46:0x011e, B:59:0x0132, B:60:0x0141, B:53:0x0126, B:55:0x012c, B:56:0x012d), top: B:156:0x0066 }] */
    /* JADX WARN: Code duplicated, block: B:94:0x0235 A[Catch: Exception -> 0x02b0, FileNotFoundException -> 0x02d0, TryCatch #13 {FileNotFoundException -> 0x02d0, Exception -> 0x02b0, blocks: (B:108:0x0276, B:109:0x027b, B:93:0x0231, B:94:0x0235, B:95:0x0239, B:101:0x0254, B:104:0x026e, B:102:0x0263, B:111:0x0280, B:113:0x0288, B:114:0x0289, B:116:0x028b, B:118:0x0293, B:119:0x0294, B:121:0x0296, B:123:0x029e, B:124:0x029f, B:129:0x02a8, B:131:0x02ae, B:132:0x02af, B:11:0x003d, B:75:0x01af, B:62:0x0151, B:88:0x01f8), top: B:144:0x003d, inners: #5, #6, #10, #12 }] */
    /* JADX WARN: Code duplicated, block: B:97:0x023f  */
    /* JADX WARN: Code duplicated, block: B:99:0x024b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:9:0x002f A[PHI: r9
  0x002f: PHI (r9v5 java.lang.String) = (r9v4 java.lang.String), (r9v9 java.lang.String) binds: [B:8:0x002d, B:5:0x0026] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Instruction removed from duplicated block: B:91:0x0217, please report this as an issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 17, insn: 0x02a1: MOVE (r6 I:??[OBJECT, ARRAY]) = (r17 I:??[OBJECT, ARRAY]), block:B:126:0x02a1 */
    /* JADX WARN: Not initialized variable reg: 17, insn: 0x02a4: MOVE (r6 I:??[OBJECT, ARRAY]) = (r17 I:??[OBJECT, ARRAY]), block:B:127:0x02a4 */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v27, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v32, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v33, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v38, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v41, types: [int] */
    /* JADX WARN: Type inference failed for: r6v44, types: [java.lang.reflect.Method] */
    void readStream(String str, String str2, int i, int i2, String str3, ReactApplicationContext reactApplicationContext) {
        String strNormalizePath;
        String str4;
        Object obj;
        Object obj2;
        String str5;
        InputStream inputStreamCreate;
        int i3;
        Object[] objArr;
        byte[] bArr;
        int i4;
        int i5;
        int i6;
        byte[] bArr2;
        int i7;
        WritableArray writableArrayCreateArray;
        int i8;
        BufferedReader bufferedReader;
        char[] cArr;
        int i9;
        String strBooleanValue = "error";
        int i10 = 2 % 2;
        int i11 = getARTIFICIAL_FRAME_PACKAGE_NAME + 73;
        artificialFrame = i11 % 128;
        if (i11 % 2 == 0) {
            strNormalizePath = ReactNativeBlobUtilUtils.normalizePath(str);
            int i12 = 78 / 0;
            if (strNormalizePath != null) {
                int i13 = artificialFrame + 7;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i13 % 128;
                int i14 = i13 % 2;
                str4 = strNormalizePath;
            } else {
                str4 = strNormalizePath;
                strNormalizePath = str;
            }
        } else {
            strNormalizePath = ReactNativeBlobUtilUtils.normalizePath(str);
            if (strNormalizePath != null) {
                int i15 = artificialFrame + 7;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i15 % 128;
                int i16 = i15 % 2;
                str4 = strNormalizePath;
            } else {
                str4 = strNormalizePath;
                strNormalizePath = str;
            }
        }
        try {
            try {
                int i17 = ((Boolean) String.class.getMethod("equalsIgnoreCase", String.class).invoke(str2, ReactNativeBlobUtilConst.RNFB_RESPONSE_BASE64)).booleanValue() ^ true ? 4096 : 4095;
                if (i > 0) {
                    i17 = i;
                }
                try {
                    try {
                        if (str4 != null) {
                            try {
                                str5 = "error";
                                try {
                                    if (((Boolean) String.class.getMethod("startsWith", String.class).invoke(strNormalizePath, ReactNativeBlobUtilConst.FILE_PREFIX_BUNDLE_ASSET)).booleanValue()) {
                                        int i18 = getARTIFICIAL_FRAME_PACKAGE_NAME + 69;
                                        artificialFrame = i18 % 128;
                                        if (i18 % 2 == 0) {
                                            ReactNativeBlobUtilImpl.RCTContext.getAssets();
                                            Object obj3 = null;
                                            try {
                                                obj3.hashCode();
                                                throw null;
                                            } catch (Throwable th) {
                                                throw th;
                                            }
                                        }
                                        try {
                                            try {
                                                Object[] objArr2 = {ReactNativeBlobUtilImpl.RCTContext.getAssets(), (String) String.class.getMethod(Parser.REPLACE_CONVERTER_WORD, CharSequence.class, CharSequence.class).invoke(strNormalizePath, ReactNativeBlobUtilConst.FILE_PREFIX_BUNDLE_ASSET, "")};
                                                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-982065286);
                                                if (objAccessartificialFrame == null) {
                                                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(Color.blue(0) + 12, (char) ((KeyEvent.getMaxKeyCode() >> 16) + 7116), View.MeasureSpec.getSize(0) + 37, 1511233906, false, "accessartificialFrame", new Class[]{AssetManager.class, String.class});
                                                }
                                                inputStreamCreate = (InputStream) ((Method) objAccessartificialFrame).invoke(null, objArr2);
                                            } catch (Throwable th2) {
                                                Throwable cause = th2.getCause();
                                                if (cause == null) {
                                                    throw th2;
                                                }
                                                throw cause;
                                            }
                                        } catch (Throwable th3) {
                                            Throwable cause2 = th3.getCause();
                                            if (cause2 == null) {
                                                throw th3;
                                            }
                                            throw cause2;
                                        }
                                    }
                                    strBooleanValue = ReactNativeBlobUtilConst.RNFB_RESPONSE_UTF8;
                                    strBooleanValue = ((Boolean) String.class.getMethod("equalsIgnoreCase", String.class).invoke(str2, ReactNativeBlobUtilConst.RNFB_RESPONSE_UTF8)).booleanValue();
                                    i3 = -1;
                                    if (strBooleanValue != 0) {
                                        strBooleanValue = "ascii";
                                        int i19 = artificialFrame + 51;
                                        getARTIFICIAL_FRAME_PACKAGE_NAME = i19 % 128;
                                        int i20 = i19 % 2;
                                        try {
                                            strBooleanValue = ((Boolean) String.class.getMethod("equalsIgnoreCase", String.class).invoke(str2, "ascii")).booleanValue();
                                            if (strBooleanValue != 0) {
                                                bArr2 = new byte[i17];
                                                while (true) {
                                                    i7 = inputStreamCreate.read(bArr2);
                                                    if (i7 != -1) {
                                                        break;
                                                    }
                                                    writableArrayCreateArray = Arguments.createArray();
                                                    for (i8 = 0; i8 < i7; i8++) {
                                                        writableArrayCreateArray.pushInt(bArr2[i8]);
                                                    }
                                                    emitStreamEvent(str3, "data", writableArrayCreateArray);
                                                    if (i2 > 0) {
                                                        SystemClock.sleep(i2);
                                                    }
                                                }
                                            } else {
                                                int i21 = artificialFrame + 33;
                                                getARTIFICIAL_FRAME_PACKAGE_NAME = i21 % 128;
                                                strBooleanValue = i21 % 2;
                                                try {
                                                    objArr = new Object[]{ReactNativeBlobUtilConst.RNFB_RESPONSE_BASE64};
                                                    strBooleanValue = String.class.getMethod("equalsIgnoreCase", String.class);
                                                    if (!((Boolean) strBooleanValue.invoke(str2, objArr)).booleanValue()) {
                                                        emitStreamEvent(str3, str5, "EINVAL", "Unrecognized encoding `" + str2 + "`, should be one of `base64`, `utf8`, `ascii`");
                                                    } else {
                                                        bArr = new byte[i17];
                                                        while (true) {
                                                            i4 = inputStreamCreate.read(bArr);
                                                            if (i4 != i3) {
                                                                break;
                                                            }
                                                            i5 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                                            i6 = i5 + 105;
                                                            artificialFrame = i6 % 128;
                                                            if (i6 % 2 != 0) {
                                                                throw null;
                                                            }
                                                            if (i4 < i17) {
                                                                int i22 = i5 + 29;
                                                                artificialFrame = i22 % 128;
                                                                int i23 = i22 % 2;
                                                                byte[] bArr3 = new byte[i4];
                                                                System.arraycopy(bArr, 0, bArr3, 0, i4);
                                                                emitStreamEvent(str3, "data", Base64.encodeToString(bArr3, 2));
                                                            } else {
                                                                emitStreamEvent(str3, "data", Base64.encodeToString(bArr, 2));
                                                            }
                                                            if (i2 > 0) {
                                                                SystemClock.sleep(i2);
                                                                i3 = -1;
                                                            }
                                                        }
                                                        emitStreamEvent(str3, ViewProps.END, "");
                                                    }
                                                } catch (Throwable th4) {
                                                    Throwable cause3 = th4.getCause();
                                                    if (cause3 == null) {
                                                        throw th4;
                                                    }
                                                    throw cause3;
                                                }
                                            }
                                            inputStreamCreate.close();
                                            return;
                                        } catch (Throwable th5) {
                                            Throwable cause4 = th5.getCause();
                                            if (cause4 == null) {
                                                throw th5;
                                            }
                                            throw cause4;
                                        }
                                    }
                                    InputStreamReader inputStreamReader = new InputStreamReader(inputStreamCreate, Charset.forName(CharEncoding.UTF_8));
                                    bufferedReader = new BufferedReader(inputStreamReader, i17);
                                    cArr = new char[i17];
                                    while (true) {
                                        i9 = bufferedReader.read(cArr, 0, i17);
                                        if (i9 != -1) {
                                            break;
                                        }
                                        emitStreamEvent(str3, "data", new String(cArr, 0, i9));
                                        if (i2 > 0) {
                                            SystemClock.sleep(i2);
                                        }
                                    }
                                    bufferedReader.close();
                                    inputStreamReader.close();
                                    emitStreamEvent(str3, ViewProps.END, "");
                                    inputStreamCreate.close();
                                    return;
                                } catch (Throwable th6) {
                                    th = th6;
                                    Throwable cause5 = th.getCause();
                                    if (cause5 == null) {
                                        throw th;
                                    }
                                    throw cause5;
                                }
                            } catch (Throwable th7) {
                                th = th7;
                            }
                        } else {
                            str5 = "error";
                        }
                        strBooleanValue = ((Boolean) String.class.getMethod("equalsIgnoreCase", String.class).invoke(str2, ReactNativeBlobUtilConst.RNFB_RESPONSE_UTF8)).booleanValue();
                        i3 = -1;
                        if (strBooleanValue != 0) {
                            strBooleanValue = "ascii";
                            int i110 = artificialFrame + 51;
                            getARTIFICIAL_FRAME_PACKAGE_NAME = i110 % 128;
                            int i24 = i110 % 2;
                            strBooleanValue = ((Boolean) String.class.getMethod("equalsIgnoreCase", String.class).invoke(str2, "ascii")).booleanValue();
                            if (strBooleanValue != 0) {
                                bArr2 = new byte[i17];
                                while (true) {
                                    i7 = inputStreamCreate.read(bArr2);
                                    if (i7 != -1) {
                                        break;
                                        break;
                                    }
                                    writableArrayCreateArray = Arguments.createArray();
                                    while (i8 < i7) {
                                        writableArrayCreateArray.pushInt(bArr2[i8]);
                                    }
                                    emitStreamEvent(str3, "data", writableArrayCreateArray);
                                    if (i2 > 0) {
                                        SystemClock.sleep(i2);
                                    }
                                }
                            } else {
                                int i25 = artificialFrame + 33;
                                getARTIFICIAL_FRAME_PACKAGE_NAME = i25 % 128;
                                strBooleanValue = i25 % 2;
                                objArr = new Object[]{ReactNativeBlobUtilConst.RNFB_RESPONSE_BASE64};
                                strBooleanValue = String.class.getMethod("equalsIgnoreCase", String.class);
                                if (!((Boolean) strBooleanValue.invoke(str2, objArr)).booleanValue()) {
                                    emitStreamEvent(str3, str5, "EINVAL", "Unrecognized encoding `" + str2 + "`, should be one of `base64`, `utf8`, `ascii`");
                                } else {
                                    bArr = new byte[i17];
                                    while (true) {
                                        i4 = inputStreamCreate.read(bArr);
                                        if (i4 != i3) {
                                            break;
                                            break;
                                        }
                                        i5 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                        i6 = i5 + 105;
                                        artificialFrame = i6 % 128;
                                        if (i6 % 2 != 0) {
                                            throw null;
                                        }
                                        if (i4 < i17) {
                                            int i26 = i5 + 29;
                                            artificialFrame = i26 % 128;
                                            int i27 = i26 % 2;
                                            byte[] bArr4 = new byte[i4];
                                            System.arraycopy(bArr, 0, bArr4, 0, i4);
                                            emitStreamEvent(str3, "data", Base64.encodeToString(bArr4, 2));
                                        } else {
                                            emitStreamEvent(str3, "data", Base64.encodeToString(bArr, 2));
                                        }
                                        if (i2 > 0) {
                                            SystemClock.sleep(i2);
                                            i3 = -1;
                                        }
                                    }
                                    emitStreamEvent(str3, ViewProps.END, "");
                                }
                            }
                            inputStreamCreate.close();
                            return;
                        }
                        InputStreamReader inputStreamReader2 = new InputStreamReader(inputStreamCreate, Charset.forName(CharEncoding.UTF_8));
                        bufferedReader = new BufferedReader(inputStreamReader2, i17);
                        cArr = new char[i17];
                        while (true) {
                            i9 = bufferedReader.read(cArr, 0, i17);
                            if (i9 != -1) {
                                break;
                                break;
                            } else {
                                emitStreamEvent(str3, "data", new String(cArr, 0, i9));
                                if (i2 > 0) {
                                    SystemClock.sleep(i2);
                                }
                            }
                        }
                        bufferedReader.close();
                        inputStreamReader2.close();
                        emitStreamEvent(str3, ViewProps.END, "");
                        inputStreamCreate.close();
                        return;
                    } catch (Throwable th8) {
                        Throwable cause6 = th8.getCause();
                        if (cause6 == null) {
                            throw th8;
                        }
                        throw cause6;
                    }
                    if (str4 == null) {
                        inputStreamCreate = ReactNativeBlobUtilImpl.RCTContext.getContentResolver().openInputStream(Uri.parse(strNormalizePath));
                    } else {
                        File file = new File(strNormalizePath);
                        inputStreamCreate = SentryFileInputStream.Factory.create(new FileInputStream(file), file);
                    }
                    strBooleanValue = ReactNativeBlobUtilConst.RNFB_RESPONSE_UTF8;
                } catch (FileNotFoundException unused) {
                    strBooleanValue = obj2;
                    emitStreamEvent(str3, strBooleanValue, "ENOENT", "No such file '" + strNormalizePath + "'");
                } catch (Exception e) {
                    e = e;
                    strBooleanValue = obj;
                    emitStreamEvent(str3, strBooleanValue, "EUNSPECIFIED", "Failed to convert data to " + str2 + " encoded string. This might be because this encoding cannot be used for this data.");
                    e.printStackTrace();
                }
            } catch (FileNotFoundException unused2) {
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th9) {
            Throwable cause7 = th9.getCause();
            if (cause7 == null) {
                throw th9;
            }
            throw cause7;
        }
    }

    void writeStream(String str, String str2, boolean z, Callback callback) {
        OutputStream outputStreamCreate;
        String strNormalizePath = ReactNativeBlobUtilUtils.normalizePath(str);
        if (strNormalizePath != null) {
            str = strNormalizePath;
        }
        try {
            File file = new File(str);
            File parentFile = file.getParentFile();
            if (strNormalizePath != null && !file.exists()) {
                if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
                    callback.invoke("ENOTDIR", "Failed to create parent directory of '" + str + "'");
                    return;
                }
                if (!file.createNewFile()) {
                    callback.invoke("ENOENT", "File '" + str + "' does not exist and could not be created");
                    return;
                }
            } else if (file.isDirectory()) {
                callback.invoke("EISDIR", "Expecting a file but '" + str + "' is a directory");
                return;
            }
            if (strNormalizePath != null && str.startsWith(ReactNativeBlobUtilConst.FILE_PREFIX_BUNDLE_ASSET)) {
                outputStreamCreate = ReactNativeBlobUtilImpl.RCTContext.getAssets().openFd(str.replace(ReactNativeBlobUtilConst.FILE_PREFIX_BUNDLE_ASSET, "")).createOutputStream();
            } else if (strNormalizePath == null) {
                outputStreamCreate = ReactNativeBlobUtilImpl.RCTContext.getContentResolver().openOutputStream(Uri.parse(str));
            } else {
                outputStreamCreate = SentryFileOutputStream.Factory.create(new FileOutputStream(str, z), str, z);
            }
            this.encoding = str2;
            String string = UUID.randomUUID().toString();
            fileStreams.put(string, this);
            this.writeStreamInstance = outputStreamCreate;
            callback.invoke(null, null, string);
        } catch (Exception e) {
            callback.invoke("EUNSPECIFIED", "Failed to create write stream at path `" + str + "`; " + e.getLocalizedMessage());
        }
    }

    static void writeChunk(String str, String str2, Callback callback) {
        ReactNativeBlobUtilStream reactNativeBlobUtilStream = fileStreams.get(str);
        try {
            reactNativeBlobUtilStream.writeStreamInstance.write(ReactNativeBlobUtilUtils.stringToBytes(str2, reactNativeBlobUtilStream.encoding));
            callback.invoke(new Object[0]);
        } catch (Exception e) {
            callback.invoke(e.getLocalizedMessage());
        }
    }

    static void writeArrayChunk(String str, ReadableArray readableArray, Callback callback) {
        try {
            OutputStream outputStream = fileStreams.get(str).writeStreamInstance;
            byte[] bArr = new byte[readableArray.size()];
            for (int i = 0; i < readableArray.size(); i++) {
                bArr[i] = (byte) readableArray.getInt(i);
            }
            outputStream.write(bArr);
            callback.invoke(new Object[0]);
        } catch (Exception e) {
            callback.invoke(e.getLocalizedMessage());
        }
    }

    static void closeStream(String str, Callback callback) {
        try {
            HashMap<String, ReactNativeBlobUtilStream> map = fileStreams;
            OutputStream outputStream = map.get(str).writeStreamInstance;
            map.remove(str);
            outputStream.close();
            callback.invoke(new Object[0]);
        } catch (Exception e) {
            callback.invoke(e.getLocalizedMessage());
        }
    }

    private void emitStreamEvent(String str, String str2, String str3) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString(NotificationCompat.CATEGORY_EVENT, str2);
        writableMapCreateMap.putString("detail", str3);
        writableMapCreateMap.putString("streamId", str);
        this.emitter.emit(ReactNativeBlobUtilConst.EVENT_FILESYSTEM, writableMapCreateMap);
    }

    private void emitStreamEvent(String str, String str2, WritableArray writableArray) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString(NotificationCompat.CATEGORY_EVENT, str2);
        writableMapCreateMap.putArray("detail", writableArray);
        writableMapCreateMap.putString("streamId", str);
        this.emitter.emit(ReactNativeBlobUtilConst.EVENT_FILESYSTEM, writableMapCreateMap);
    }

    private void emitStreamEvent(String str, String str2, String str3, String str4) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString(NotificationCompat.CATEGORY_EVENT, str2);
        writableMapCreateMap.putString(ResponseTypeValues.CODE, str3);
        writableMapCreateMap.putString("detail", str4);
        writableMapCreateMap.putString("streamId", str);
        this.emitter.emit(ReactNativeBlobUtilConst.EVENT_FILESYSTEM, writableMapCreateMap);
    }
}
