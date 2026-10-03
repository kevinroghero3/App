package com.facebook.soloader;

import android.graphics.Color;
import android.graphics.ImageFormat;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.os.StrictMode;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.common.base.Ascii;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.zip.ZipFile;
import javax.annotation.Nullable;
import o.ArtificialStackFrames;
import o.ICustomTabsCallbackDefault;
import o.asBinder;
import o.asInterface;

/* JADX INFO: loaded from: classes.dex */
public class SystemLoadWrapperSoSource extends SoSource {
    private static final byte[] INotificationSideChannelDefault = {47, 75, -118, 7, 1, 3, -12, -26, Ascii.ESC, -9, Ascii.SO, -19, Ascii.SI, 5};
    private static final int INotificationSideChannelStub = FacebookRequestErrorClassification.EC_INVALID_TOKEN;
    private static long extraCommand = -3275981476477547241L;
    private static long coroutineBoundary = -899883803867009716L;
    private static int accessartificialFrame = -1151259316;
    private static char CoroutineDebuggingKt = 55929;

    @Override // com.facebook.soloader.SoSource
    @Nullable
    public File unpackLibrary(String str) throws IOException {
        return null;
    }

    @Override // com.facebook.soloader.SoSource
    public int loadLibrary(String str, int i, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        try {
            CoroutineDebuggingKt(str.substring(3, str.length() - 3));
            return 1;
        } catch (Exception e) {
            LogUtil.e(SoLoader.TAG, "Error loading library: " + str, e);
            return 0;
        }
    }

    @Override // com.facebook.soloader.SoSource
    @Nullable
    public String getLibraryPath(String str) throws IOException {
        String classLoaderLdLoadLibrary = SysUtil.getClassLoaderLdLoadLibrary();
        if (TextUtils.isEmpty(classLoaderLdLoadLibrary)) {
            return null;
        }
        for (String str2 : classLoaderLdLoadLibrary.split(":")) {
            if (SysUtil.isDisabledExtractNativeLibs(SoLoader.sApplicationContext) && str2.contains(".apk!")) {
                return str2 + File.separator + str;
            }
            File file = new File(str2, str);
            if (file.exists()) {
                return file.getCanonicalPath();
            }
        }
        return null;
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        asBinder asbinder = new asBinder();
        asbinder.c = i;
        int length = cArr.length;
        long[] jArr = new long[length];
        asbinder.d = 0;
        while (asbinder.d < cArr.length) {
            jArr[asbinder.d] = (((long) cArr[asbinder.d]) ^ (((long) asbinder.d) * ((long) asbinder.c))) ^ (extraCommand ^ (-2360974883025274865L));
            asbinder.d++;
        }
        char[] cArr2 = new char[length];
        asbinder.d = 0;
        while (asbinder.d < cArr.length) {
            cArr2[asbinder.d] = (char) jArr[asbinder.d];
            asbinder.d++;
        }
        objArr[0] = new String(cArr2);
    }

    @Override // com.facebook.soloader.SoSource
    public String getName() {
        return "SystemLoadWrapperSoSource";
    }

    @Override // com.facebook.soloader.SoSource
    public String toString() {
        return getName() + "[" + SysUtil.getClassLoaderLdLoadLibrary() + "]";
    }

    private static void b(char[] cArr, int i, char[] cArr2, char c, char[] cArr3, Object[] objArr) {
        ICustomTabsCallbackDefault iCustomTabsCallbackDefault = new ICustomTabsCallbackDefault();
        int length = cArr2.length;
        char[] cArr4 = new char[length];
        int length2 = cArr.length;
        char[] cArr5 = new char[length2];
        System.arraycopy(cArr2, 0, cArr4, 0, length);
        System.arraycopy(cArr, 0, cArr5, 0, length2);
        cArr4[0] = (char) (cArr4[0] ^ c);
        cArr5[2] = (char) (cArr5[2] + ((char) i));
        int length3 = cArr3.length;
        char[] cArr6 = new char[length3];
        iCustomTabsCallbackDefault.a = 0;
        while (iCustomTabsCallbackDefault.a < length3) {
            int i2 = (iCustomTabsCallbackDefault.a + 2) % 4;
            int i3 = (iCustomTabsCallbackDefault.a + 3) % 4;
            iCustomTabsCallbackDefault.MediaBrowserCompatApi21ConnectionCallback = (char) (((cArr4[iCustomTabsCallbackDefault.a % 4] * 32718) + cArr5[i2]) % 65535);
            cArr5[i3] = (char) (((cArr4[i3] * 32718) + cArr5[i2]) / 65535);
            cArr4[i3] = iCustomTabsCallbackDefault.MediaBrowserCompatApi21ConnectionCallback;
            cArr6[iCustomTabsCallbackDefault.a] = (char) (((((long) (cArr4[i3] ^ cArr3[iCustomTabsCallbackDefault.a])) ^ (coroutineBoundary ^ (-899883803867009716L))) ^ ((long) ((int) (((long) accessartificialFrame) ^ (-899883803867009716L))))) ^ ((long) ((char) (((long) CoroutineDebuggingKt) ^ (-899883803867009716L)))));
            iCustomTabsCallbackDefault.a++;
        }
        objArr[0] = new String(cArr6);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0029  */
    /* JADX WARN: Code duplicated, block: B:8:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0029 -> B:11:0x0030). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0029
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void c(short r6, short r7, byte r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 * 2
            int r7 = 3 - r7
            byte[] r0 = com.facebook.soloader.SystemLoadWrapperSoSource.INotificationSideChannelDefault
            int r6 = r6 * 3
            int r6 = r6 + 11
            int r8 = r8 * 4
            int r8 = r8 + 102
            byte[] r1 = new byte[r6]
            r2 = 0
            if (r0 != 0) goto L17
            r3 = r8
            r4 = r2
            r8 = r7
            goto L30
        L17:
            r3 = r2
        L18:
            byte r4 = (byte) r8
            r1[r3] = r4
            int r3 = r3 + 1
            int r7 = r7 + 1
            if (r3 != r6) goto L29
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L29:
            r4 = r0[r7]
            r5 = r8
            r8 = r7
            r7 = r4
            r4 = r3
            r3 = r5
        L30:
            int r3 = r3 + r7
            int r7 = r3 + 2
            r3 = r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.SystemLoadWrapperSoSource.c(short, short, byte, java.lang.Object[]):void");
    }

    /* JADX WARN: Code duplicated, block: B:158:0x0484  */
    /* JADX WARN: Code duplicated, block: B:173:0x050d  */
    /* JADX WARN: Code duplicated, block: B:180:0x054e A[Catch: Exception -> 0x047a, TRY_ENTER, TRY_LEAVE, TryCatch #33 {Exception -> 0x047a, blocks: (B:98:0x0313, B:101:0x032a, B:105:0x039c, B:109:0x040b, B:180:0x054e, B:196:0x05c6, B:200:0x05d7, B:205:0x062c, B:207:0x0632, B:208:0x0633, B:210:0x0635, B:212:0x063c, B:213:0x063d, B:215:0x0649, B:216:0x064f, B:231:0x06a5, B:233:0x06a7, B:235:0x06ae, B:236:0x06af, B:246:0x06d7, B:286:0x0835, B:291:0x088a, B:296:0x08e2, B:298:0x08e8, B:299:0x08e9, B:301:0x08eb, B:303:0x08f2, B:304:0x08f3, B:306:0x08f5, B:308:0x08fc, B:309:0x08fd, B:111:0x0416, B:113:0x041d, B:114:0x041e, B:116:0x0420, B:118:0x0427, B:119:0x0428, B:121:0x042a, B:123:0x0431, B:124:0x0432, B:126:0x0434, B:128:0x043b, B:129:0x043c, B:131:0x043e, B:133:0x0445, B:134:0x0446, B:141:0x0464, B:143:0x046a, B:144:0x046b, B:149:0x0471, B:151:0x0478, B:152:0x0479, B:219:0x068a, B:221:0x0692, B:222:0x0697, B:224:0x0699, B:226:0x06a0, B:227:0x06a1, B:217:0x0650, B:214:0x063e, B:106:0x03a3, B:104:0x037b, B:102:0x0347, B:137:0x0449, B:108:0x03f0, B:107:0x03d7), top: B:573:0x0313, inners: #3, #4, #6, #14, #21, #41, #69, #77 }] */
    /* JADX WARN: Code duplicated, block: B:237:0x06b0 A[Catch: Exception -> 0x0a92, TRY_ENTER, TRY_LEAVE, TryCatch #31 {Exception -> 0x0a92, blocks: (B:170:0x04fd, B:237:0x06b0, B:242:0x06c9, B:243:0x06d0, B:248:0x06db, B:264:0x0762, B:159:0x0486, B:169:0x04f0), top: B:569:0x04fd }] */
    /* JADX WARN: Code duplicated, block: B:245:0x06d6  */
    /* JADX WARN: Code duplicated, block: B:377:0x0a20 A[Catch: Exception -> 0x0b28, TryCatch #54 {Exception -> 0x0b28, blocks: (B:414:0x0a6a, B:416:0x0a70, B:417:0x0a71, B:363:0x0a08, B:375:0x0a19, B:377:0x0a20, B:378:0x0a21, B:380:0x0a23, B:382:0x0a2d, B:383:0x0a2e, B:390:0x0a37, B:392:0x0a40, B:393:0x0a41, B:400:0x0a4a, B:402:0x0a53, B:403:0x0a54, B:408:0x0a5a, B:410:0x0a63, B:411:0x0a64, B:422:0x0a77, B:424:0x0a80, B:425:0x0a81, B:430:0x0a87, B:432:0x0a90, B:433:0x0a91, B:442:0x0aa3, B:444:0x0aac, B:445:0x0aad, B:450:0x0ab7, B:452:0x0ac0, B:453:0x0ac1, B:458:0x0acb, B:460:0x0ad4, B:461:0x0ad5, B:469:0x0ae4, B:471:0x0aed, B:472:0x0aee, B:483:0x0b0f, B:485:0x0b16, B:486:0x0b17, B:488:0x0b19, B:490:0x0b26, B:491:0x0b27, B:310:0x08fe, B:14:0x00a0), top: B:515:0x08fe, inners: #2, #72 }] */
    /* JADX WARN: Code duplicated, block: B:378:0x0a21 A[Catch: Exception -> 0x0b28, TryCatch #54 {Exception -> 0x0b28, blocks: (B:414:0x0a6a, B:416:0x0a70, B:417:0x0a71, B:363:0x0a08, B:375:0x0a19, B:377:0x0a20, B:378:0x0a21, B:380:0x0a23, B:382:0x0a2d, B:383:0x0a2e, B:390:0x0a37, B:392:0x0a40, B:393:0x0a41, B:400:0x0a4a, B:402:0x0a53, B:403:0x0a54, B:408:0x0a5a, B:410:0x0a63, B:411:0x0a64, B:422:0x0a77, B:424:0x0a80, B:425:0x0a81, B:430:0x0a87, B:432:0x0a90, B:433:0x0a91, B:442:0x0aa3, B:444:0x0aac, B:445:0x0aad, B:450:0x0ab7, B:452:0x0ac0, B:453:0x0ac1, B:458:0x0acb, B:460:0x0ad4, B:461:0x0ad5, B:469:0x0ae4, B:471:0x0aed, B:472:0x0aee, B:483:0x0b0f, B:485:0x0b16, B:486:0x0b17, B:488:0x0b19, B:490:0x0b26, B:491:0x0b27, B:310:0x08fe, B:14:0x00a0), top: B:515:0x08fe, inners: #2, #72 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x01ba  */
    /* JADX WARN: Code duplicated, block: B:46:0x01bd  */
    /* JADX WARN: Code duplicated, block: B:471:0x0aed A[Catch: Exception -> 0x0b28, TryCatch #54 {Exception -> 0x0b28, blocks: (B:414:0x0a6a, B:416:0x0a70, B:417:0x0a71, B:363:0x0a08, B:375:0x0a19, B:377:0x0a20, B:378:0x0a21, B:380:0x0a23, B:382:0x0a2d, B:383:0x0a2e, B:390:0x0a37, B:392:0x0a40, B:393:0x0a41, B:400:0x0a4a, B:402:0x0a53, B:403:0x0a54, B:408:0x0a5a, B:410:0x0a63, B:411:0x0a64, B:422:0x0a77, B:424:0x0a80, B:425:0x0a81, B:430:0x0a87, B:432:0x0a90, B:433:0x0a91, B:442:0x0aa3, B:444:0x0aac, B:445:0x0aad, B:450:0x0ab7, B:452:0x0ac0, B:453:0x0ac1, B:458:0x0acb, B:460:0x0ad4, B:461:0x0ad5, B:469:0x0ae4, B:471:0x0aed, B:472:0x0aee, B:483:0x0b0f, B:485:0x0b16, B:486:0x0b17, B:488:0x0b19, B:490:0x0b26, B:491:0x0b27, B:310:0x08fe, B:14:0x00a0), top: B:515:0x08fe, inners: #2, #72 }] */
    /* JADX WARN: Code duplicated, block: B:472:0x0aee A[Catch: Exception -> 0x0b28, TryCatch #54 {Exception -> 0x0b28, blocks: (B:414:0x0a6a, B:416:0x0a70, B:417:0x0a71, B:363:0x0a08, B:375:0x0a19, B:377:0x0a20, B:378:0x0a21, B:380:0x0a23, B:382:0x0a2d, B:383:0x0a2e, B:390:0x0a37, B:392:0x0a40, B:393:0x0a41, B:400:0x0a4a, B:402:0x0a53, B:403:0x0a54, B:408:0x0a5a, B:410:0x0a63, B:411:0x0a64, B:422:0x0a77, B:424:0x0a80, B:425:0x0a81, B:430:0x0a87, B:432:0x0a90, B:433:0x0a91, B:442:0x0aa3, B:444:0x0aac, B:445:0x0aad, B:450:0x0ab7, B:452:0x0ac0, B:453:0x0ac1, B:458:0x0acb, B:460:0x0ad4, B:461:0x0ad5, B:469:0x0ae4, B:471:0x0aed, B:472:0x0aee, B:483:0x0b0f, B:485:0x0b16, B:486:0x0b17, B:488:0x0b19, B:490:0x0b26, B:491:0x0b27, B:310:0x08fe, B:14:0x00a0), top: B:515:0x08fe, inners: #2, #72 }] */
    /* JADX WARN: Code duplicated, block: B:517:0x068a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:543:0x01f0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:561:0x0243 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:573:0x0313 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:57:0x01fd  */
    /* JADX WARN: Code duplicated, block: B:588:0x0449 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:599:0x0994 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:616:0x0956 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:639:0x0650 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:656:0x0692 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:657:0x09f0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:658:0x0b49 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:661:0x0b3e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:662:0x06db A[EDGE_INSN: B:662:0x06db->B:248:0x06db BREAK  A[LOOP:1: B:243:0x06d0->B:246:0x06d7], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:93:0x02bc  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v28 */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v89 */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v61, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v63 */
    /* JADX WARN: Type inference failed for: r13v64 */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v11, types: [java.lang.reflect.Constructor] */
    /* JADX WARN: Type inference failed for: r14v14 */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX WARN: Type inference failed for: r14v4 */
    /* JADX WARN: Type inference failed for: r14v41, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r14v42 */
    /* JADX WARN: Type inference failed for: r14v44 */
    /* JADX WARN: Type inference failed for: r14v47 */
    /* JADX WARN: Type inference failed for: r14v48 */
    /* JADX WARN: Type inference failed for: r14v49 */
    /* JADX WARN: Type inference failed for: r14v50, types: [char[]] */
    /* JADX WARN: Type inference failed for: r14v52 */
    /* JADX WARN: Type inference failed for: r14v6, types: [int] */
    /* JADX WARN: Type inference failed for: r14v66 */
    /* JADX WARN: Type inference failed for: r14v7 */
    /* JADX WARN: Type inference failed for: r14v72 */
    /* JADX WARN: Type inference failed for: r14v73 */
    /* JADX WARN: Type inference failed for: r14v8 */
    /* JADX WARN: Type inference failed for: r14v9 */
    /* JADX WARN: Type inference failed for: r15v3, types: [java.lang.Class[]] */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r16v10 */
    /* JADX WARN: Type inference failed for: r16v12 */
    /* JADX WARN: Type inference failed for: r16v13 */
    /* JADX WARN: Type inference failed for: r16v14 */
    /* JADX WARN: Type inference failed for: r16v15 */
    /* JADX WARN: Type inference failed for: r16v16 */
    /* JADX WARN: Type inference failed for: r16v17 */
    /* JADX WARN: Type inference failed for: r16v18 */
    /* JADX WARN: Type inference failed for: r16v19 */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r16v20 */
    /* JADX WARN: Type inference failed for: r16v21 */
    /* JADX WARN: Type inference failed for: r16v22 */
    /* JADX WARN: Type inference failed for: r16v23 */
    /* JADX WARN: Type inference failed for: r16v3 */
    /* JADX WARN: Type inference failed for: r16v4 */
    /* JADX WARN: Type inference failed for: r16v5 */
    /* JADX WARN: Type inference failed for: r16v6 */
    /* JADX WARN: Type inference failed for: r16v7 */
    /* JADX WARN: Type inference failed for: r16v8, types: [java.lang.Class<java.lang.String>] */
    /* JADX WARN: Type inference failed for: r16v9 */
    /* JADX WARN: Type inference failed for: r20v1 */
    /* JADX WARN: Type inference failed for: r20v13 */
    /* JADX WARN: Type inference failed for: r20v14 */
    /* JADX WARN: Type inference failed for: r20v2 */
    /* JADX WARN: Type inference failed for: r20v24 */
    /* JADX WARN: Type inference failed for: r20v25 */
    /* JADX WARN: Type inference failed for: r20v26 */
    /* JADX WARN: Type inference failed for: r20v27 */
    /* JADX WARN: Type inference failed for: r20v28 */
    /* JADX WARN: Type inference failed for: r20v3 */
    /* JADX WARN: Type inference failed for: r20v30 */
    /* JADX WARN: Type inference failed for: r20v31 */
    /* JADX WARN: Type inference failed for: r20v37 */
    /* JADX WARN: Type inference failed for: r20v38 */
    /* JADX WARN: Type inference failed for: r20v39 */
    /* JADX WARN: Type inference failed for: r20v4 */
    /* JADX WARN: Type inference failed for: r20v40 */
    /* JADX WARN: Type inference failed for: r20v41 */
    /* JADX WARN: Type inference failed for: r20v45 */
    /* JADX WARN: Type inference failed for: r20v46 */
    /* JADX WARN: Type inference failed for: r20v47 */
    /* JADX WARN: Type inference failed for: r20v5 */
    /* JADX WARN: Type inference failed for: r20v6 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v125 */
    /* JADX WARN: Type inference failed for: r2v131 */
    /* JADX WARN: Type inference failed for: r2v132 */
    /* JADX WARN: Type inference failed for: r2v133 */
    /* JADX WARN: Type inference failed for: r2v148 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v33 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v64 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v86 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v105 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v110 */
    /* JADX WARN: Type inference failed for: r5v115 */
    /* JADX WARN: Type inference failed for: r5v116 */
    /* JADX WARN: Type inference failed for: r5v117 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v45, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v49 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v61 */
    /* JADX WARN: Type inference failed for: r5v72 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v81 */
    /* JADX WARN: Type inference failed for: r5v82 */
    /* JADX WARN: Type inference failed for: r5v83 */
    /* JADX WARN: Type inference failed for: r5v85 */
    /* JADX WARN: Type inference failed for: r5v92 */
    /* JADX WARN: Type inference failed for: r5v96, types: [java.lang.reflect.AccessibleObject, java.lang.reflect.Method] */
    /* JADX WARN: Type inference failed for: r8v35, types: [java.lang.reflect.Method] */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 5 */
    private static void CoroutineDebuggingKt(String str) throws Exception {
        ?? size;
        ?? r20;
        ?? r16;
        ?? Invoke;
        Exception exc;
        ?? r2;
        ?? r14;
        ?? r3;
        Throwable th;
        Throwable cause;
        String str2;
        Object objNewInstance;
        BufferedInputStream bufferedInputStream;
        URL resource;
        InputStream inputStream;
        ?? r4;
        Throwable th2;
        Object objAccessartificialFrame;
        InputStream inputStream2;
        BufferedOutputStream bufferedOutputStream;
        byte[] bArr;
        int i;
        Object objInvoke;
        Throwable th3;
        Throwable cause2;
        Object objInvoke2;
        ClassLoader classLoader;
        String str3;
        Object objInvoke3;
        ClassLoader classLoader2;
        String str4;
        Object[] objArr;
        Object[] objArr2;
        ?? r13;
        ?? r21;
        ?? r17;
        ?? r5 = 0;
        Object[] objArr3 = new Object[1];
        a(33378 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), new char[]{30059, 63244, 29112, 62024, 31976, 65167, 31543, 58833, 26231}, objArr3);
        ?? r6 = 0;
        String str5 = (String) objArr3[0];
        Object[] objArr4 = new Object[1];
        a(18898 - MotionEvent.axisFromString(""), new char[]{30079, 15534, 59082, 43059, 21025, 1129, 53150, 29108, 15341, 60694}, objArr4);
        String str6 = (String) objArr4[0];
        Object[] objArr5 = new Object[1];
        a(50821 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), new char[]{30029, 46025, 63572, 9914, 28468}, objArr5);
        try {
            String[] strArrCoroutineDebuggingKt = asInterface.CoroutineDebuggingKt(asInterface.ArtificialStackFrames((byte[]) String.class.getMethod("getBytes", String.class).invoke(str, (String) objArr5[0])));
            if (strArrCoroutineDebuggingKt == null) {
                strArrCoroutineDebuggingKt = new String[0];
            }
            int length = strArrCoroutineDebuggingKt.length;
            String[] strArr = new String[length + 1];
            System.arraycopy(strArrCoroutineDebuggingKt, 0, strArr, 0, length);
            strArr[length] = str;
            int i2 = 0;
            ?? r12 = strArr;
            while (i2 <= length) {
                ?? r15 = r12[i2];
                try {
                    size = View.MeasureSpec.getSize(r6 == true ? 1 : 0) + 41113;
                    try {
                        Object[] objArr6 = new Object[1];
                        a(size, new char[]{30007, 54757, 13387, 38055, 63261, 22474, 46826, 4438, 29092, 53272, 12493, 37861, 62033, 21161, 48488, 7583, 31972, 57156, 16297, 40486, 65182, 23011, 47191, 6340, 31525, 56263, 15079, 34133, 58829, 17454, 42137, 2044}, objArr6);
                        try {
                            Object[] objArr7 = {(String) objArr6[r6 == true ? 1 : 0]};
                            ?? r18 = new Class[1];
                            r16 = String.class;
                            r18[r6 == true ? 1 : 0] = r16;
                            size = File.class.getDeclaredConstructor(r18);
                            Object objNewInstance2 = size.newInstance(objArr7);
                            try {
                                try {
                                    Object[] objArr8 = new Object[1];
                                    char[] cArr = {18388, 42986, 3978, 50367, 31605, 19673, 22088, 38690};
                                    b(new char[]{0, 0, 0, 0}, View.MeasureSpec.makeMeasureSpec(r6 == true ? 1 : 0, r6 == true ? 1 : 0), new char[]{46087, 43654, 21023, 37835}, (char) (CdmaCellLocation.convertQuartSecToDecDegrees(r6 == true ? 1 : 0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(r6 == true ? 1 : 0) == 0.0d ? 0 : -1)), cArr, objArr8);
                                    r6 = 0;
                                    char[] cArr2 = cArr;
                                    if (((Boolean) File.class.getMethod((String) objArr8[0], null).invoke(objNewInstance2, null)).booleanValue()) {
                                        ClassLoader classLoader3 = SystemLoadWrapperSoSource.class.getClassLoader();
                                        if (i2 >= length) {
                                            r3 = str;
                                        } else {
                                            r3 = r15;
                                        }
                                        Object[] objArr9 = {r3};
                                        byte b = (byte) (INotificationSideChannelDefault[4] - 1);
                                        byte b2 = b;
                                        r16 = r12;
                                        Object[] objArr10 = new Object[1];
                                        c(b, b2, b2, objArr10);
                                        Method declaredMethod = ClassLoader.class.getDeclaredMethod((String) objArr10[0], String.class);
                                        declaredMethod.setAccessible(true);
                                        str2 = (String) declaredMethod.invoke(classLoader3, objArr9);
                                        if (str2 == null) {
                                            Object objInvoke4 = Runtime.class.getMethod(str6, null).invoke(null, null);
                                            r13 = r15;
                                            if (i2 >= length) {
                                                r13 = str;
                                            }
                                            Object[] objArr11 = new Object[1];
                                            a(19138 - MotionEvent.axisFromString(""), new char[]{30068, 16308, 57599, 38197, 24152, 190, 46568, 32319, 9057, 54705, 40703}, objArr11);
                                            Runtime.class.getMethod((String) objArr11[0], String.class).invoke(objInvoke4, r13);
                                            return;
                                        }
                                        Object[] objArr12 = new Object[1];
                                        boolean z = false;
                                        objArr12[0] = 47;
                                        Object[] objArr13 = new Object[1];
                                        a(821 - Color.blue(0), new char[]{30068, 30284, 29441, 31987, 31109, 25983, 26178, 25358, 27848, 27018, 21868}, objArr13);
                                        z = false;
                                        Object[] objArr14 = new Object[1];
                                        objArr14[0] = Integer.valueOf(((Integer) String.class.getMethod((String) objArr13[0], Integer.TYPE).invoke(str2, objArr12)).intValue() + 1);
                                        Object[] objArr15 = {objNewInstance2, String.class.getMethod(str5, Integer.TYPE).invoke(str2, objArr14)};
                                        Class[] clsArr = new Class[2];
                                        clsArr[0] = File.class;
                                        clsArr[1] = String.class;
                                        objNewInstance = File.class.getDeclaredConstructor(clsArr).newInstance(objArr15);
                                        resource = SystemLoadWrapperSoSource.class.getClassLoader().getResource(str2);
                                        if (resource == null) {
                                            objArr = new Object[]{"!"};
                                            r20 = i2;
                                            objArr2 = new Object[1];
                                            b(new char[]{0, 0, 0, 0}, (Process.getThreadPriority(0) + 20) >> 6, new char[]{42954, 27492, 25236, 4842}, (char) View.resolveSize(0, 0), new char[]{30982, 45788, 45896, 17992, 18580, 27150, 36878, 63857}, objArr2);
                                            if (((Boolean) String.class.getMethod((String) objArr2[0], CharSequence.class).invoke(str2, objArr)).booleanValue()) {
                                                StringBuilder sb = new StringBuilder();
                                                Object[] objArr16 = new Object[1];
                                                a(39228 - ImageFormat.getBitsPerPixel(0), new char[]{30066, 60484, 18192, 48789, 4490, 35648, 57882, 17878, 48330}, objArr16);
                                                sb.append((String) objArr16[0]);
                                                sb.append(str2);
                                                String path = new URL(sb.toString()).getPath();
                                                Object[] objArr17 = new Object[1];
                                                a(TextUtils.getTrimmedLength("") + 821, new char[]{30068, 30284, 29441, 31987, 31109, 25983, 26178, 25358, 27848, 27018, 21868}, objArr17);
                                                ZipFile zipFile = new ZipFile((String) String.class.getMethod(str5, Integer.TYPE, Integer.TYPE).invoke(path, 5, Integer.valueOf(((Integer) String.class.getMethod((String) objArr17[0], String.class).invoke(path, "!/")).intValue())));
                                                Object[] objArr18 = new Object[1];
                                                a((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 821, new char[]{30068, 30284, 29441, 31987, 31109, 25983, 26178, 25358, 27848, 27018, 21868}, objArr18);
                                                inputStream = zipFile.getInputStream(zipFile.getEntry((String) String.class.getMethod(str5, Integer.TYPE).invoke(String.class.getMethod(str5, Integer.TYPE).invoke(str2, Integer.valueOf(((Integer) String.class.getMethod((String) objArr18[0], String.class).invoke(str2, "!/")).intValue())), 2)));
                                                r20 = r20;
                                            } else {
                                                inputStream = (InputStream) FileInputStream.class.getDeclaredConstructor(String.class).newInstance(str2);
                                                r20 = r20;
                                            }
                                        } else {
                                            r20 = i2;
                                            String path2 = resource.getPath();
                                            Object[] objArr19 = {"!/" + str2};
                                            Object[] objArr20 = new Object[1];
                                            a((KeyEvent.getMaxKeyCode() >> 16) + 821, new char[]{30068, 30284, 29441, 31987, 31109, 25983, 26178, 25358, 27848, 27018, 21868}, objArr20);
                                            Object[] objArr21 = new Object[2];
                                            objArr21[1] = Integer.valueOf(((Integer) String.class.getMethod((String) objArr20[0], String.class).invoke(path2, objArr19)).intValue());
                                            objArr21[0] = 5;
                                            Class[] clsArr2 = new Class[2];
                                            clsArr2[0] = Integer.TYPE;
                                            clsArr2[1] = Integer.TYPE;
                                            ZipFile zipFile2 = new ZipFile((String) String.class.getMethod(str5, clsArr2).invoke(path2, objArr21));
                                            inputStream = zipFile2.getInputStream(zipFile2.getEntry(str2));
                                        }
                                        bufferedInputStream = new BufferedInputStream(inputStream);
                                        Object[] objArr22 = {bufferedInputStream};
                                        objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-175194354);
                                        if (objAccessartificialFrame == null) {
                                            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(View.resolveSize(0, 0) + 25, (char) ((-1) - Process.getGidForName("")), ExpandableListView.getPackedPositionType(0L) + 49, 1793849606, false, "CoroutineDebuggingKt", new Class[]{InputStream.class});
                                        }
                                        inputStream2 = (InputStream) ((Method) objAccessartificialFrame).invoke(null, objArr22);
                                        if (bufferedInputStream == inputStream2) {
                                            inputStream2.close();
                                            Object objInvoke5 = Runtime.class.getMethod(str6, null).invoke(null, null);
                                            Object[] objArr23 = {str2, SystemLoadWrapperSoSource.class.getClassLoader()};
                                            Object[] objArr24 = new Object[1];
                                            b(new char[]{0, 0, 0, 0}, (-1) - MotionEvent.axisFromString(""), new char[]{3972, 51770, 7888, 20067}, (char) (View.combineMeasuredStates(0, 0) + 25374), new char[]{63357, 64414, 47022, 43345}, objArr24);
                                            Method declaredMethod2 = Runtime.class.getDeclaredMethod((String) objArr24[0], String.class, ClassLoader.class);
                                            declaredMethod2.setAccessible(true);
                                            declaredMethod2.invoke(objInvoke5, objArr23);
                                            r2 = r20 == true ? 1 : 0;
                                            Invoke = 0;
                                            r14 = 0;
                                        } else {
                                            Object[] objArr25 = {objNewInstance};
                                            Class[] clsArr3 = new Class[1];
                                            clsArr3[0] = File.class;
                                            OutputStream outputStream = (OutputStream) FileOutputStream.class.getDeclaredConstructor(clsArr3).newInstance(objArr25);
                                            bufferedOutputStream = new BufferedOutputStream(outputStream);
                                            bArr = new byte[1024];
                                            while (true) {
                                                i = inputStream2.read(bArr);
                                                if (i >= 0) {
                                                    break;
                                                    break;
                                                }
                                                bufferedOutputStream.write(bArr, 0, i);
                                            }
                                            bufferedOutputStream.flush();
                                            Object[] objArr26 = new Object[1];
                                            b(new char[]{0, 0, 0, 0}, TextUtils.getOffsetBefore("", 0) + 931932185, new char[]{6424, 35880, 63799, 30414}, (char) (Process.getGidForName("") + 52986), new char[]{7871, 54825, 19506, 32011, 29710}, objArr26);
                                            Invoke = FileOutputStream.class.getMethod((String) objArr26[0], null).invoke(outputStream, null);
                                            size = new Object[1];
                                            b(new char[]{0, 0, 0, 0}, KeyEvent.normalizeMetaState(0), new char[]{18422, 12660, 16011, 31790}, (char) (KeyEvent.keyCodeFromString("") + 11838), new char[]{31993, 22858, 27577, 25712}, size);
                                            FileDescriptor.class.getMethod((String) size[0], null).invoke(Invoke, null);
                                            bufferedOutputStream.close();
                                            inputStream2.close();
                                            Object objInvoke6 = Runtime.class.getMethod(str6, null).invoke(null, null);
                                            Object[] objArr27 = new Object[1];
                                            b(new char[]{0, 0, 0, 0}, 1214790420 - View.getDefaultSize(0, 0), new char[]{5293, 26683, 18760, 30317}, (char) (TextUtils.indexOf("", "", 0, 0) + 27977), new char[]{24116, 25842, 58913, 34267, 28657, 3896, 27549, 29484, 56308, 36061, 43014, 24075, 44043, 20572, 36237}, objArr27);
                                            Invoke = 0;
                                            Invoke = 0;
                                            Object[] objArr28 = {File.class.getMethod((String) objArr27[0], null).invoke(objNewInstance, null), SystemLoadWrapperSoSource.class.getClassLoader()};
                                            size = new char[]{63357, 64414, 47022, 43345};
                                            Object[] objArr29 = new Object[1];
                                            b(new char[]{0, 0, 0, 0}, (-1) - TextUtils.indexOf((CharSequence) "", '0', 0, 0), new char[]{3972, 51770, 7888, 20067}, (char) ((KeyEvent.getMaxKeyCode() >> 16) + 25374), size, objArr29);
                                            Invoke = Runtime.class.getDeclaredMethod((String) objArr29[0], String.class, ClassLoader.class);
                                            Invoke.setAccessible(true);
                                            Invoke.invoke(objInvoke6, objArr28);
                                            r14 = 0;
                                            Object[] objArr30 = new Object[1];
                                            b(new char[]{0, 0, 0, 0}, TextUtils.getTrimmedLength(""), new char[]{44076, 24450, 63280, 54675}, (char) (37879 - TextUtils.getTrimmedLength("")), new char[]{53322, 1466, 42160, 59582, 30139, 44728}, objArr30);
                                            Invoke = 0;
                                            Invoke = 0;
                                            ((Boolean) File.class.getMethod((String) objArr30[0], null).invoke(objNewInstance, null)).booleanValue();
                                            r2 = r20 == true ? 1 : 0;
                                        }
                                        Invoke = 0;
                                        r14 = 0;
                                        r2 = r4;
                                        r16 = r17;
                                        r20 = r21;
                                        if (r2 < length) {
                                            throw exc;
                                        }
                                    } else {
                                        try {
                                            Object[] objArr31 = new Object[1];
                                            cArr = new char[]{41645, 6794, 28110, 32681, 37505, 16346, 36577, 20693, 35093, 57249, 1763, 14398, 4292, 29198};
                                            b(new char[]{0, 0, 0, 0}, ViewConfiguration.getFadingEdgeLength() >> 16, new char[]{47659, 20176, 51384, 22126}, (char) (28360 - Gravity.getAbsoluteGravity(0, 0)), cArr, objArr31);
                                            String str7 = (String) objArr31[0];
                                            try {
                                                objNewInstance2 = File.class.getDeclaredConstructor(String.class).newInstance(System.getProperty(str7, str7));
                                                try {
                                                    Object[] objArr32 = new Object[1];
                                                    cArr = new char[]{18388, 42986, 3978, 50367, 31605, 19673, 22088, 38690};
                                                    b(new char[]{0, 0, 0, 0}, ((byte) KeyEvent.getModifierMetaStateMask()) + 1, new char[]{46087, 43654, 21023, 37835}, (char) TextUtils.getCapsMode("", 0, 0), cArr, objArr32);
                                                    cArr2 = cArr;
                                                    if (!((Boolean) File.class.getMethod((String) objArr32[0], null).invoke(objNewInstance2, null)).booleanValue()) {
                                                        objNewInstance2 = Environment.getExternalStorageDirectory();
                                                        cArr2 = cArr;
                                                    }
                                                    try {
                                                        ClassLoader classLoader4 = SystemLoadWrapperSoSource.class.getClassLoader();
                                                        if (i2 >= length) {
                                                            r3 = str;
                                                        } else {
                                                            r3 = r15;
                                                        }
                                                        try {
                                                            Object[] objArr33 = {r3};
                                                            byte b3 = (byte) (INotificationSideChannelDefault[4] - 1);
                                                            byte b4 = b3;
                                                            r16 = r12;
                                                            try {
                                                                Object[] objArr110 = new Object[1];
                                                                c(b3, b4, b4, objArr110);
                                                                try {
                                                                    Method declaredMethod3 = ClassLoader.class.getDeclaredMethod((String) objArr110[0], String.class);
                                                                    declaredMethod3.setAccessible(true);
                                                                    str2 = (String) declaredMethod3.invoke(classLoader4, objArr33);
                                                                    if (str2 == null) {
                                                                        try {
                                                                            Object objInvoke7 = Runtime.class.getMethod(str6, null).invoke(null, null);
                                                                            r13 = r15;
                                                                            if (i2 >= length) {
                                                                                r13 = str;
                                                                            }
                                                                            try {
                                                                                try {
                                                                                    Object[] objArr111 = new Object[1];
                                                                                    a(19138 - MotionEvent.axisFromString(""), new char[]{30068, 16308, 57599, 38197, 24152, 190, 46568, 32319, 9057, 54705, 40703}, objArr111);
                                                                                    Runtime.class.getMethod((String) objArr111[0], String.class).invoke(objInvoke7, r13);
                                                                                    return;
                                                                                } catch (Exception e) {
                                                                                    exc = e;
                                                                                    r4 = i2;
                                                                                    r17 = r16;
                                                                                    r21 = cArr2;
                                                                                }
                                                                            } catch (Throwable th4) {
                                                                                Throwable cause3 = th4.getCause();
                                                                                if (cause3 == null) {
                                                                                    throw th4;
                                                                                }
                                                                                throw cause3;
                                                                            }
                                                                        } catch (Throwable th5) {
                                                                            Throwable cause4 = th5.getCause();
                                                                            if (cause4 == null) {
                                                                                throw th5;
                                                                            }
                                                                            throw cause4;
                                                                        }
                                                                    } else {
                                                                        try {
                                                                            Object[] objArr112 = new Object[1];
                                                                            boolean z2 = false;
                                                                            try {
                                                                                objArr112[0] = 47;
                                                                                Object[] objArr113 = new Object[1];
                                                                                a(821 - Color.blue(0), new char[]{30068, 30284, 29441, 31987, 31109, 25983, 26178, 25358, 27848, 27018, 21868}, objArr113);
                                                                                z2 = false;
                                                                                try {
                                                                                    Object[] objArr114 = new Object[1];
                                                                                    try {
                                                                                        objArr114[0] = Integer.valueOf(((Integer) String.class.getMethod((String) objArr113[0], Integer.TYPE).invoke(str2, objArr112)).intValue() + 1);
                                                                                        try {
                                                                                            Object[] objArr115 = {objNewInstance2, String.class.getMethod(str5, Integer.TYPE).invoke(str2, objArr114)};
                                                                                            Class[] clsArr4 = new Class[2];
                                                                                            try {
                                                                                                clsArr4[0] = File.class;
                                                                                                clsArr4[1] = String.class;
                                                                                                objNewInstance = File.class.getDeclaredConstructor(clsArr4).newInstance(objArr115);
                                                                                                try {
                                                                                                    resource = SystemLoadWrapperSoSource.class.getClassLoader().getResource(str2);
                                                                                                    if (resource == null) {
                                                                                                        try {
                                                                                                            objArr = new Object[]{"!"};
                                                                                                            r20 = i2;
                                                                                                            try {
                                                                                                                objArr2 = new Object[1];
                                                                                                                b(new char[]{0, 0, 0, 0}, (Process.getThreadPriority(0) + 20) >> 6, new char[]{42954, 27492, 25236, 4842}, (char) View.resolveSize(0, 0), new char[]{30982, 45788, 45896, 17992, 18580, 27150, 36878, 63857}, objArr2);
                                                                                                                if (((Boolean) String.class.getMethod((String) objArr2[0], CharSequence.class).invoke(str2, objArr)).booleanValue()) {
                                                                                                                    try {
                                                                                                                        StringBuilder sb2 = new StringBuilder();
                                                                                                                        try {
                                                                                                                            Object[] objArr116 = new Object[1];
                                                                                                                            a(39228 - ImageFormat.getBitsPerPixel(0), new char[]{30066, 60484, 18192, 48789, 4490, 35648, 57882, 17878, 48330}, objArr116);
                                                                                                                            sb2.append((String) objArr116[0]);
                                                                                                                            sb2.append(str2);
                                                                                                                            String path3 = new URL(sb2.toString()).getPath();
                                                                                                                            try {
                                                                                                                                Object[] objArr117 = new Object[1];
                                                                                                                                a(TextUtils.getTrimmedLength("") + 821, new char[]{30068, 30284, 29441, 31987, 31109, 25983, 26178, 25358, 27848, 27018, 21868}, objArr117);
                                                                                                                                try {
                                                                                                                                    ZipFile zipFile3 = new ZipFile((String) String.class.getMethod(str5, Integer.TYPE, Integer.TYPE).invoke(path3, 5, Integer.valueOf(((Integer) String.class.getMethod((String) objArr117[0], String.class).invoke(path3, "!/")).intValue())));
                                                                                                                                    try {
                                                                                                                                        Object[] objArr118 = new Object[1];
                                                                                                                                        a((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 821, new char[]{30068, 30284, 29441, 31987, 31109, 25983, 26178, 25358, 27848, 27018, 21868}, objArr118);
                                                                                                                                        try {
                                                                                                                                            try {
                                                                                                                                                inputStream = zipFile3.getInputStream(zipFile3.getEntry((String) String.class.getMethod(str5, Integer.TYPE).invoke(String.class.getMethod(str5, Integer.TYPE).invoke(str2, Integer.valueOf(((Integer) String.class.getMethod((String) objArr118[0], String.class).invoke(str2, "!/")).intValue())), 2)));
                                                                                                                                                r20 = r20;
                                                                                                                                            } catch (Throwable th6) {
                                                                                                                                                Throwable cause5 = th6.getCause();
                                                                                                                                                if (cause5 == null) {
                                                                                                                                                    throw th6;
                                                                                                                                                }
                                                                                                                                                throw cause5;
                                                                                                                                            }
                                                                                                                                        } catch (Throwable th7) {
                                                                                                                                            Throwable cause6 = th7.getCause();
                                                                                                                                            if (cause6 == null) {
                                                                                                                                                throw th7;
                                                                                                                                            }
                                                                                                                                            throw cause6;
                                                                                                                                        }
                                                                                                                                    } catch (Throwable th8) {
                                                                                                                                        Throwable cause7 = th8.getCause();
                                                                                                                                        if (cause7 == null) {
                                                                                                                                            throw th8;
                                                                                                                                        }
                                                                                                                                        throw cause7;
                                                                                                                                    }
                                                                                                                                } catch (Throwable th9) {
                                                                                                                                    Throwable cause8 = th9.getCause();
                                                                                                                                    if (cause8 == null) {
                                                                                                                                        throw th9;
                                                                                                                                    }
                                                                                                                                    throw cause8;
                                                                                                                                }
                                                                                                                            } catch (Throwable th10) {
                                                                                                                                Throwable cause9 = th10.getCause();
                                                                                                                                if (cause9 == null) {
                                                                                                                                    throw th10;
                                                                                                                                }
                                                                                                                                throw cause9;
                                                                                                                            }
                                                                                                                        } catch (Exception e2) {
                                                                                                                            e = e2;
                                                                                                                            exc = e;
                                                                                                                            r4 = r20;
                                                                                                                            r17 = r16;
                                                                                                                            r21 = r20;
                                                                                                                            Invoke = 0;
                                                                                                                            r14 = 0;
                                                                                                                            r2 = r4;
                                                                                                                            r16 = r17;
                                                                                                                            r20 = r21;
                                                                                                                            if (r2 < length) {
                                                                                                                                throw exc;
                                                                                                                            }
                                                                                                                        }
                                                                                                                    } catch (Exception e3) {
                                                                                                                        e = e3;
                                                                                                                        exc = e;
                                                                                                                        r4 = r20;
                                                                                                                        r17 = r16;
                                                                                                                        r21 = r20;
                                                                                                                        Invoke = 0;
                                                                                                                        r14 = 0;
                                                                                                                        r2 = r4;
                                                                                                                        r16 = r17;
                                                                                                                        r20 = r21;
                                                                                                                        if (r2 < length) {
                                                                                                                            throw exc;
                                                                                                                        }
                                                                                                                    }
                                                                                                                } else {
                                                                                                                    try {
                                                                                                                        inputStream = (InputStream) FileInputStream.class.getDeclaredConstructor(String.class).newInstance(str2);
                                                                                                                        r20 = r20;
                                                                                                                    } catch (Throwable th11) {
                                                                                                                        Throwable cause10 = th11.getCause();
                                                                                                                        if (cause10 == null) {
                                                                                                                            throw th11;
                                                                                                                        }
                                                                                                                        throw cause10;
                                                                                                                    }
                                                                                                                }
                                                                                                            } catch (Throwable th12) {
                                                                                                                th = th12;
                                                                                                                Throwable th13 = th;
                                                                                                                Throwable cause11 = th13.getCause();
                                                                                                                if (cause11 == null) {
                                                                                                                    throw th13;
                                                                                                                }
                                                                                                                throw cause11;
                                                                                                            }
                                                                                                        } catch (Throwable th14) {
                                                                                                            th = th14;
                                                                                                        }
                                                                                                    } else {
                                                                                                        r20 = i2;
                                                                                                        String path4 = resource.getPath();
                                                                                                        try {
                                                                                                            Object[] objArr119 = {"!/" + str2};
                                                                                                            Object[] objArr210 = new Object[1];
                                                                                                            a((KeyEvent.getMaxKeyCode() >> 16) + 821, new char[]{30068, 30284, 29441, 31987, 31109, 25983, 26178, 25358, 27848, 27018, 21868}, objArr210);
                                                                                                            try {
                                                                                                                try {
                                                                                                                    Object[] objArr211 = new Object[2];
                                                                                                                    objArr211[1] = Integer.valueOf(((Integer) String.class.getMethod((String) objArr210[0], String.class).invoke(path4, objArr119)).intValue());
                                                                                                                    try {
                                                                                                                        objArr211[0] = 5;
                                                                                                                        Class[] clsArr5 = new Class[2];
                                                                                                                        clsArr5[0] = Integer.TYPE;
                                                                                                                        clsArr5[1] = Integer.TYPE;
                                                                                                                        ZipFile zipFile4 = new ZipFile((String) String.class.getMethod(str5, clsArr5).invoke(path4, objArr211));
                                                                                                                        inputStream = zipFile4.getInputStream(zipFile4.getEntry(str2));
                                                                                                                    } catch (Throwable th15) {
                                                                                                                        th = th15;
                                                                                                                        Throwable th16 = th;
                                                                                                                        Throwable cause12 = th16.getCause();
                                                                                                                        if (cause12 == null) {
                                                                                                                            throw th16;
                                                                                                                        }
                                                                                                                        throw cause12;
                                                                                                                    }
                                                                                                                } catch (Throwable th17) {
                                                                                                                    th = th17;
                                                                                                                }
                                                                                                            } catch (Throwable th18) {
                                                                                                                th = th18;
                                                                                                                Throwable th19 = th;
                                                                                                                Throwable cause13 = th19.getCause();
                                                                                                                if (cause13 == null) {
                                                                                                                    throw th19;
                                                                                                                }
                                                                                                                throw cause13;
                                                                                                            }
                                                                                                        } catch (Throwable th20) {
                                                                                                            th = th20;
                                                                                                        }
                                                                                                    }
                                                                                                    try {
                                                                                                        bufferedInputStream = new BufferedInputStream(inputStream);
                                                                                                        try {
                                                                                                            Object[] objArr212 = {bufferedInputStream};
                                                                                                            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-175194354);
                                                                                                            if (objAccessartificialFrame == null) {
                                                                                                                try {
                                                                                                                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(View.resolveSize(0, 0) + 25, (char) ((-1) - Process.getGidForName("")), ExpandableListView.getPackedPositionType(0L) + 49, 1793849606, false, "CoroutineDebuggingKt", new Class[]{InputStream.class});
                                                                                                                } catch (Throwable th21) {
                                                                                                                    th2 = th21;
                                                                                                                    Throwable cause14 = th2.getCause();
                                                                                                                    if (cause14 == null) {
                                                                                                                        throw th2;
                                                                                                                    }
                                                                                                                    throw cause14;
                                                                                                                }
                                                                                                            }
                                                                                                            inputStream2 = (InputStream) ((Method) objAccessartificialFrame).invoke(null, objArr212);
                                                                                                            if (bufferedInputStream == inputStream2) {
                                                                                                                inputStream2.close();
                                                                                                                try {
                                                                                                                    Object objInvoke8 = Runtime.class.getMethod(str6, null).invoke(null, null);
                                                                                                                    try {
                                                                                                                        try {
                                                                                                                            try {
                                                                                                                                Object[] objArr213 = {str2, SystemLoadWrapperSoSource.class.getClassLoader()};
                                                                                                                                Object[] objArr214 = new Object[1];
                                                                                                                                b(new char[]{0, 0, 0, 0}, (-1) - MotionEvent.axisFromString(""), new char[]{3972, 51770, 7888, 20067}, (char) (View.combineMeasuredStates(0, 0) + 25374), new char[]{63357, 64414, 47022, 43345}, objArr214);
                                                                                                                                Method declaredMethod4 = Runtime.class.getDeclaredMethod((String) objArr214[0], String.class, ClassLoader.class);
                                                                                                                                declaredMethod4.setAccessible(true);
                                                                                                                                declaredMethod4.invoke(objInvoke8, objArr213);
                                                                                                                            } catch (NoSuchMethodException unused) {
                                                                                                                                try {
                                                                                                                                    objInvoke3 = Runtime.class.getMethod(str6, null).invoke(null, null);
                                                                                                                                    classLoader2 = SystemLoadWrapperSoSource.class.getClassLoader();
                                                                                                                                    synchronized (objInvoke3) {
                                                                                                                                        try {
                                                                                                                                            Object[] objArr34 = {str2, classLoader2};
                                                                                                                                            Object[] objArr35 = new Object[1];
                                                                                                                                            a(View.resolveSize(0, 0) + 37463, new char[]{30070, 59182, 20930, 49780, 15410, 44750, 7006, 29974, 59329, 20595}, objArr35);
                                                                                                                                            Method declaredMethod5 = Runtime.class.getDeclaredMethod((String) objArr35[0], String.class, ClassLoader.class);
                                                                                                                                            declaredMethod5.setAccessible(true);
                                                                                                                                            str4 = (String) declaredMethod5.invoke(objInvoke3, objArr34);
                                                                                                                                            if (str4 == null) {
                                                                                                                                                throw new UnsatisfiedLinkError(str4);
                                                                                                                                            }
                                                                                                                                        } catch (Throwable th22) {
                                                                                                                                            Throwable cause15 = th22.getCause();
                                                                                                                                            if (cause15 == null) {
                                                                                                                                                throw th22;
                                                                                                                                            }
                                                                                                                                            throw cause15;
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                } catch (Throwable th23) {
                                                                                                                                    Throwable cause16 = th23.getCause();
                                                                                                                                    if (cause16 == null) {
                                                                                                                                        throw th23;
                                                                                                                                    }
                                                                                                                                    throw cause16;
                                                                                                                                }
                                                                                                                            }
                                                                                                                            r2 = r20 == true ? 1 : 0;
                                                                                                                            Invoke = 0;
                                                                                                                            r14 = 0;
                                                                                                                        } catch (Throwable th24) {
                                                                                                                            Throwable cause17 = th24.getCause();
                                                                                                                            if (cause17 == null) {
                                                                                                                                throw th24;
                                                                                                                            }
                                                                                                                            throw cause17;
                                                                                                                        }
                                                                                                                    } catch (Exception unused2) {
                                                                                                                        if (Build.VERSION.SDK_INT <= 27) {
                                                                                                                            try {
                                                                                                                                Object objInvoke9 = Runtime.class.getMethod(str6, null).invoke(null, null);
                                                                                                                                try {
                                                                                                                                    Object[] objArr36 = {str2, SystemLoadWrapperSoSource.class.getClassLoader()};
                                                                                                                                    Object[] objArr37 = new Object[1];
                                                                                                                                    b(new char[]{0, 0, 0, 0}, View.resolveSizeAndState(0, 0, 0), new char[]{26553, 12745, 39207, 56335}, (char) (3993 - View.resolveSize(0, 0)), new char[]{10986, 47663, 57773, 20061, 9490, 62433}, objArr37);
                                                                                                                                    Method declaredMethod6 = Runtime.class.getDeclaredMethod((String) objArr37[0], String.class, ClassLoader.class);
                                                                                                                                    declaredMethod6.setAccessible(true);
                                                                                                                                    declaredMethod6.invoke(objInvoke9, objArr36);
                                                                                                                                } catch (Throwable th25) {
                                                                                                                                    Throwable cause18 = th25.getCause();
                                                                                                                                    if (cause18 == null) {
                                                                                                                                        throw th25;
                                                                                                                                    }
                                                                                                                                    throw cause18;
                                                                                                                                }
                                                                                                                            } catch (Throwable th26) {
                                                                                                                                Throwable cause19 = th26.getCause();
                                                                                                                                if (cause19 == null) {
                                                                                                                                    throw th26;
                                                                                                                                }
                                                                                                                                throw cause19;
                                                                                                                            }
                                                                                                                        } else {
                                                                                                                            objInvoke3 = Runtime.class.getMethod(str6, null).invoke(null, null);
                                                                                                                            classLoader2 = SystemLoadWrapperSoSource.class.getClassLoader();
                                                                                                                            synchronized (objInvoke3) {
                                                                                                                                Object[] objArr38 = {str2, classLoader2};
                                                                                                                                Object[] objArr39 = new Object[1];
                                                                                                                                a(View.resolveSize(0, 0) + 37463, new char[]{30070, 59182, 20930, 49780, 15410, 44750, 7006, 29974, 59329, 20595}, objArr39);
                                                                                                                                Method declaredMethod7 = Runtime.class.getDeclaredMethod((String) objArr39[0], String.class, ClassLoader.class);
                                                                                                                                declaredMethod7.setAccessible(true);
                                                                                                                                str4 = (String) declaredMethod7.invoke(objInvoke3, objArr38);
                                                                                                                                if (str4 == null) {
                                                                                                                                    throw new UnsatisfiedLinkError(str4);
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                } catch (Throwable th27) {
                                                                                                                    Throwable cause20 = th27.getCause();
                                                                                                                    if (cause20 == null) {
                                                                                                                        throw th27;
                                                                                                                    }
                                                                                                                    throw cause20;
                                                                                                                }
                                                                                                            } else {
                                                                                                                try {
                                                                                                                    Object[] objArr215 = {objNewInstance};
                                                                                                                    Class[] clsArr6 = new Class[1];
                                                                                                                    try {
                                                                                                                        clsArr6[0] = File.class;
                                                                                                                        OutputStream outputStream2 = (OutputStream) FileOutputStream.class.getDeclaredConstructor(clsArr6).newInstance(objArr215);
                                                                                                                        bufferedOutputStream = new BufferedOutputStream(outputStream2);
                                                                                                                        bArr = new byte[1024];
                                                                                                                        while (true) {
                                                                                                                            i = inputStream2.read(bArr);
                                                                                                                            if (i >= 0) {
                                                                                                                                break;
                                                                                                                            } else {
                                                                                                                                bufferedOutputStream.write(bArr, 0, i);
                                                                                                                            }
                                                                                                                        }
                                                                                                                        bufferedOutputStream.flush();
                                                                                                                        try {
                                                                                                                            try {
                                                                                                                                Object[] objArr216 = new Object[1];
                                                                                                                                b(new char[]{0, 0, 0, 0}, TextUtils.getOffsetBefore("", 0) + 931932185, new char[]{6424, 35880, 63799, 30414}, (char) (Process.getGidForName("") + 52986), new char[]{7871, 54825, 19506, 32011, 29710}, objArr216);
                                                                                                                                try {
                                                                                                                                    Invoke = FileOutputStream.class.getMethod((String) objArr216[0], null).invoke(outputStream2, null);
                                                                                                                                    try {
                                                                                                                                        try {
                                                                                                                                            size = new Object[1];
                                                                                                                                            b(new char[]{0, 0, 0, 0}, KeyEvent.normalizeMetaState(0), new char[]{18422, 12660, 16011, 31790}, (char) (KeyEvent.keyCodeFromString("") + 11838), new char[]{31993, 22858, 27577, 25712}, size);
                                                                                                                                            try {
                                                                                                                                                FileDescriptor.class.getMethod((String) size[0], null).invoke(Invoke, null);
                                                                                                                                                bufferedOutputStream.close();
                                                                                                                                                inputStream2.close();
                                                                                                                                                try {
                                                                                                                                                    Object objInvoke10 = Runtime.class.getMethod(str6, null).invoke(null, null);
                                                                                                                                                    try {
                                                                                                                                                        try {
                                                                                                                                                            Object[] objArr217 = new Object[1];
                                                                                                                                                            b(new char[]{0, 0, 0, 0}, 1214790420 - View.getDefaultSize(0, 0), new char[]{5293, 26683, 18760, 30317}, (char) (TextUtils.indexOf("", "", 0, 0) + 27977), new char[]{24116, 25842, 58913, 34267, 28657, 3896, 27549, 29484, 56308, 36061, 43014, 24075, 44043, 20572, 36237}, objArr217);
                                                                                                                                                            Invoke = 0;
                                                                                                                                                            Invoke = 0;
                                                                                                                                                            try {
                                                                                                                                                                try {
                                                                                                                                                                    Object[] objArr218 = {File.class.getMethod((String) objArr217[0], null).invoke(objNewInstance, null), SystemLoadWrapperSoSource.class.getClassLoader()};
                                                                                                                                                                    size = new char[]{63357, 64414, 47022, 43345};
                                                                                                                                                                    Object[] objArr219 = new Object[1];
                                                                                                                                                                    b(new char[]{0, 0, 0, 0}, (-1) - TextUtils.indexOf((CharSequence) "", '0', 0, 0), new char[]{3972, 51770, 7888, 20067}, (char) ((KeyEvent.getMaxKeyCode() >> 16) + 25374), size, objArr219);
                                                                                                                                                                    Invoke = Runtime.class.getDeclaredMethod((String) objArr219[0], String.class, ClassLoader.class);
                                                                                                                                                                    Invoke.setAccessible(true);
                                                                                                                                                                    Invoke.invoke(objInvoke10, objArr218);
                                                                                                                                                                } catch (Throwable th28) {
                                                                                                                                                                    Throwable cause21 = th28.getCause();
                                                                                                                                                                    if (cause21 == null) {
                                                                                                                                                                        throw th28;
                                                                                                                                                                    }
                                                                                                                                                                    throw cause21;
                                                                                                                                                                }
                                                                                                                                                            } catch (Exception unused3) {
                                                                                                                                                                if (Build.VERSION.SDK_INT <= 27) {
                                                                                                                                                                    try {
                                                                                                                                                                        Object objInvoke11 = Runtime.class.getMethod(str6, null).invoke(null, null);
                                                                                                                                                                        try {
                                                                                                                                                                            Object[] objArr40 = new Object[1];
                                                                                                                                                                            b(new char[]{0, 0, 0, 0}, Color.red(0) + 1214790420, new char[]{5293, 26683, 18760, 30317}, (char) (27977 - (ViewConfiguration.getDoubleTapTimeout() >> 16)), new char[]{24116, 25842, 58913, 34267, 28657, 3896, 27549, 29484, 56308, 36061, 43014, 24075, 44043, 20572, 36237}, objArr40);
                                                                                                                                                                            try {
                                                                                                                                                                                Object[] objArr41 = {File.class.getMethod((String) objArr40[0], null).invoke(objNewInstance, null), SystemLoadWrapperSoSource.class.getClassLoader()};
                                                                                                                                                                                Object[] objArr42 = new Object[1];
                                                                                                                                                                                b(new char[]{0, 0, 0, 0}, ViewConfiguration.getFadingEdgeLength() >> 16, new char[]{26553, 12745, 39207, 56335}, (char) (3993 - View.resolveSize(0, 0)), new char[]{10986, 47663, 57773, 20061, 9490, 62433}, objArr42);
                                                                                                                                                                                Method declaredMethod8 = Runtime.class.getDeclaredMethod((String) objArr42[0], String.class, ClassLoader.class);
                                                                                                                                                                                declaredMethod8.setAccessible(true);
                                                                                                                                                                                declaredMethod8.invoke(objInvoke11, objArr41);
                                                                                                                                                                            } catch (Throwable th29) {
                                                                                                                                                                                Throwable cause22 = th29.getCause();
                                                                                                                                                                                if (cause22 == null) {
                                                                                                                                                                                    throw th29;
                                                                                                                                                                                }
                                                                                                                                                                                throw cause22;
                                                                                                                                                                            }
                                                                                                                                                                        } catch (Throwable th30) {
                                                                                                                                                                            Throwable cause23 = th30.getCause();
                                                                                                                                                                            if (cause23 == null) {
                                                                                                                                                                                throw th30;
                                                                                                                                                                            }
                                                                                                                                                                            throw cause23;
                                                                                                                                                                        }
                                                                                                                                                                    } catch (Throwable th31) {
                                                                                                                                                                        Throwable cause24 = th31.getCause();
                                                                                                                                                                        if (cause24 == null) {
                                                                                                                                                                            throw th31;
                                                                                                                                                                        }
                                                                                                                                                                        throw cause24;
                                                                                                                                                                    }
                                                                                                                                                                } else {
                                                                                                                                                                    try {
                                                                                                                                                                        try {
                                                                                                                                                                            objInvoke = Runtime.class.getMethod(str6, null).invoke(null, null);
                                                                                                                                                                            try {
                                                                                                                                                                                try {
                                                                                                                                                                                    size = 0;
                                                                                                                                                                                    r14 = 0;
                                                                                                                                                                                    try {
                                                                                                                                                                                        Object[] objArr43 = new Object[1];
                                                                                                                                                                                        b(new char[]{0, 0, 0, 0}, View.combineMeasuredStates(0, 0) + 1214790420, new char[]{5293, 26683, 18760, 30317}, (char) (27978 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))), new char[]{24116, 25842, 58913, 34267, 28657, 3896, 27549, 29484, 56308, 36061, 43014, 24075, 44043, 20572, 36237}, objArr43);
                                                                                                                                                                                        try {
                                                                                                                                                                                            objInvoke2 = File.class.getMethod((String) objArr43[0], null).invoke(objNewInstance, null);
                                                                                                                                                                                            try {
                                                                                                                                                                                                classLoader = SystemLoadWrapperSoSource.class.getClassLoader();
                                                                                                                                                                                                try {
                                                                                                                                                                                                    synchronized (objInvoke) {
                                                                                                                                                                                                        try {
                                                                                                                                                                                                            Object[] objArr44 = {objInvoke2, classLoader};
                                                                                                                                                                                                            boolean z3 = false;
                                                                                                                                                                                                            try {
                                                                                                                                                                                                                Object[] objArr45 = new Object[1];
                                                                                                                                                                                                                a(37463 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)), new char[]{30070, 59182, 20930, 49780, 15410, 44750, 7006, 29974, 59329, 20595}, objArr45);
                                                                                                                                                                                                                z3 = false;
                                                                                                                                                                                                                String str8 = (String) objArr45[0];
                                                                                                                                                                                                                Class[] clsArr7 = new Class[2];
                                                                                                                                                                                                                clsArr7[0] = String.class;
                                                                                                                                                                                                                clsArr7[1] = ClassLoader.class;
                                                                                                                                                                                                                Method declaredMethod9 = Runtime.class.getDeclaredMethod(str8, clsArr7);
                                                                                                                                                                                                                declaredMethod9.setAccessible(true);
                                                                                                                                                                                                                str3 = (String) declaredMethod9.invoke(objInvoke, objArr44);
                                                                                                                                                                                                                if (str3 == null) {
                                                                                                                                                                                                                    throw new UnsatisfiedLinkError(str3);
                                                                                                                                                                                                                }
                                                                                                                                                                                                                try {
                                                                                                                                                                                                                } catch (Throwable th32) {
                                                                                                                                                                                                                    th = th32;
                                                                                                                                                                                                                    throw th;
                                                                                                                                                                                                                }
                                                                                                                                                                                                            } catch (Throwable th33) {
                                                                                                                                                                                                                th = th33;
                                                                                                                                                                                                                Throwable th34 = th;
                                                                                                                                                                                                                Throwable cause25 = th34.getCause();
                                                                                                                                                                                                                if (cause25 == null) {
                                                                                                                                                                                                                    throw th34;
                                                                                                                                                                                                                }
                                                                                                                                                                                                                throw cause25;
                                                                                                                                                                                                            }
                                                                                                                                                                                                        } catch (Throwable th35) {
                                                                                                                                                                                                            th = th35;
                                                                                                                                                                                                        }
                                                                                                                                                                                                    }
                                                                                                                                                                                                } catch (Throwable th36) {
                                                                                                                                                                                                    th = th36;
                                                                                                                                                                                                }
                                                                                                                                                                                            } catch (Exception e4) {
                                                                                                                                                                                                e = e4;
                                                                                                                                                                                                Invoke = 0;
                                                                                                                                                                                                exc = e;
                                                                                                                                                                                                r2 = r20;
                                                                                                                                                                                                Invoke = Invoke;
                                                                                                                                                                                                r14 = size;
                                                                                                                                                                                                r16 = r16;
                                                                                                                                                                                                r20 = r20;
                                                                                                                                                                                                if (r2 < length) {
                                                                                                                                                                                                    throw exc;
                                                                                                                                                                                                }
                                                                                                                                                                                            }
                                                                                                                                                                                        } catch (Throwable th37) {
                                                                                                                                                                                            th = th37;
                                                                                                                                                                                            th3 = th;
                                                                                                                                                                                            cause2 = th3.getCause();
                                                                                                                                                                                            if (cause2 != null) {
                                                                                                                                                                                                throw th3;
                                                                                                                                                                                            }
                                                                                                                                                                                            throw cause2;
                                                                                                                                                                                        }
                                                                                                                                                                                    } catch (Throwable th38) {
                                                                                                                                                                                        th = th38;
                                                                                                                                                                                    }
                                                                                                                                                                                } catch (Throwable th39) {
                                                                                                                                                                                    th = th39;
                                                                                                                                                                                    th3 = th;
                                                                                                                                                                                    cause2 = th3.getCause();
                                                                                                                                                                                    if (cause2 != null) {
                                                                                                                                                                                        throw th3;
                                                                                                                                                                                    }
                                                                                                                                                                                    throw cause2;
                                                                                                                                                                                }
                                                                                                                                                                            } catch (Throwable th40) {
                                                                                                                                                                                th = th40;
                                                                                                                                                                            }
                                                                                                                                                                        } catch (Exception e5) {
                                                                                                                                                                            e = e5;
                                                                                                                                                                        }
                                                                                                                                                                    } catch (Throwable th41) {
                                                                                                                                                                        Throwable cause26 = th41.getCause();
                                                                                                                                                                        if (cause26 == null) {
                                                                                                                                                                            throw th41;
                                                                                                                                                                        }
                                                                                                                                                                        throw cause26;
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                                Object[] objArr310 = new Object[1];
                                                                                                                                                                b(new char[]{0, 0, 0, 0}, TextUtils.getTrimmedLength(""), new char[]{44076, 24450, 63280, 54675}, (char) (37879 - TextUtils.getTrimmedLength("")), new char[]{53322, 1466, 42160, 59582, 30139, 44728}, objArr310);
                                                                                                                                                                Invoke = 0;
                                                                                                                                                                Invoke = 0;
                                                                                                                                                                ((Boolean) File.class.getMethod((String) objArr310[0], null).invoke(objNewInstance, null)).booleanValue();
                                                                                                                                                                r2 = r20 == true ? 1 : 0;
                                                                                                                                                                i2 = r2 + 1;
                                                                                                                                                                r6 = Invoke;
                                                                                                                                                                r5 = r14;
                                                                                                                                                                r12 = r16;
                                                                                                                                                            }
                                                                                                                                                            r14 = 0;
                                                                                                                                                        } catch (NoSuchMethodException unused4) {
                                                                                                                                                            objInvoke = Runtime.class.getMethod(str6, null).invoke(null, null);
                                                                                                                                                            size = 0;
                                                                                                                                                            r14 = 0;
                                                                                                                                                            Object[] objArr46 = new Object[1];
                                                                                                                                                            b(new char[]{0, 0, 0, 0}, View.combineMeasuredStates(0, 0) + 1214790420, new char[]{5293, 26683, 18760, 30317}, (char) (27978 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))), new char[]{24116, 25842, 58913, 34267, 28657, 3896, 27549, 29484, 56308, 36061, 43014, 24075, 44043, 20572, 36237}, objArr46);
                                                                                                                                                            objInvoke2 = File.class.getMethod((String) objArr46[0], null).invoke(objNewInstance, null);
                                                                                                                                                            classLoader = SystemLoadWrapperSoSource.class.getClassLoader();
                                                                                                                                                            synchronized (objInvoke) {
                                                                                                                                                                Object[] objArr47 = {objInvoke2, classLoader};
                                                                                                                                                                boolean z4 = false;
                                                                                                                                                                Object[] objArr48 = new Object[1];
                                                                                                                                                                a(37463 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)), new char[]{30070, 59182, 20930, 49780, 15410, 44750, 7006, 29974, 59329, 20595}, objArr48);
                                                                                                                                                                z4 = false;
                                                                                                                                                                String str9 = (String) objArr48[0];
                                                                                                                                                                Class[] clsArr8 = new Class[2];
                                                                                                                                                                clsArr8[0] = String.class;
                                                                                                                                                                clsArr8[1] = ClassLoader.class;
                                                                                                                                                                Method declaredMethod10 = Runtime.class.getDeclaredMethod(str9, clsArr8);
                                                                                                                                                                declaredMethod10.setAccessible(true);
                                                                                                                                                                str3 = (String) declaredMethod10.invoke(objInvoke, objArr47);
                                                                                                                                                                if (str3 == null) {
                                                                                                                                                                    throw new UnsatisfiedLinkError(str3);
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                        try {
                                                                                                                                                            Object[] objArr311 = new Object[1];
                                                                                                                                                            b(new char[]{0, 0, 0, 0}, TextUtils.getTrimmedLength(""), new char[]{44076, 24450, 63280, 54675}, (char) (37879 - TextUtils.getTrimmedLength("")), new char[]{53322, 1466, 42160, 59582, 30139, 44728}, objArr311);
                                                                                                                                                            Invoke = 0;
                                                                                                                                                            Invoke = 0;
                                                                                                                                                            try {
                                                                                                                                                                ((Boolean) File.class.getMethod((String) objArr311[0], null).invoke(objNewInstance, null)).booleanValue();
                                                                                                                                                                r2 = r20 == true ? 1 : 0;
                                                                                                                                                            } catch (Throwable th42) {
                                                                                                                                                                th = th42;
                                                                                                                                                                Throwable th43 = th;
                                                                                                                                                                try {
                                                                                                                                                                    Throwable cause27 = th43.getCause();
                                                                                                                                                                    if (cause27 == null) {
                                                                                                                                                                        throw th43;
                                                                                                                                                                    }
                                                                                                                                                                    throw cause27;
                                                                                                                                                                } catch (Exception unused5) {
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                        } catch (Throwable th44) {
                                                                                                                                                            th = th44;
                                                                                                                                                            Invoke = 0;
                                                                                                                                                        }
                                                                                                                                                    } catch (Throwable th45) {
                                                                                                                                                        Throwable cause28 = th45.getCause();
                                                                                                                                                        if (cause28 == null) {
                                                                                                                                                            throw th45;
                                                                                                                                                        }
                                                                                                                                                        throw cause28;
                                                                                                                                                    }
                                                                                                                                                } catch (Throwable th46) {
                                                                                                                                                    Throwable cause29 = th46.getCause();
                                                                                                                                                    if (cause29 == null) {
                                                                                                                                                        throw th46;
                                                                                                                                                    }
                                                                                                                                                    throw cause29;
                                                                                                                                                }
                                                                                                                                            } catch (Throwable th47) {
                                                                                                                                                th = th47;
                                                                                                                                                Throwable th48 = th;
                                                                                                                                                Throwable cause30 = th48.getCause();
                                                                                                                                                if (cause30 == null) {
                                                                                                                                                    throw th48;
                                                                                                                                                }
                                                                                                                                                throw cause30;
                                                                                                                                            }
                                                                                                                                        } catch (Throwable th49) {
                                                                                                                                            th = th49;
                                                                                                                                        }
                                                                                                                                    } catch (Throwable th50) {
                                                                                                                                        th = th50;
                                                                                                                                    }
                                                                                                                                } catch (Throwable th51) {
                                                                                                                                    th = th51;
                                                                                                                                    Throwable th52 = th;
                                                                                                                                    Throwable cause31 = th52.getCause();
                                                                                                                                    if (cause31 == null) {
                                                                                                                                        throw th52;
                                                                                                                                    }
                                                                                                                                    throw cause31;
                                                                                                                                }
                                                                                                                            } catch (Throwable th53) {
                                                                                                                                th = th53;
                                                                                                                            }
                                                                                                                        } catch (Throwable th54) {
                                                                                                                            th = th54;
                                                                                                                        }
                                                                                                                    } catch (Throwable th55) {
                                                                                                                        th = th55;
                                                                                                                        Throwable th56 = th;
                                                                                                                        Throwable cause32 = th56.getCause();
                                                                                                                        if (cause32 == null) {
                                                                                                                            throw th56;
                                                                                                                        }
                                                                                                                        throw cause32;
                                                                                                                    }
                                                                                                                } catch (Throwable th57) {
                                                                                                                    th = th57;
                                                                                                                }
                                                                                                            }
                                                                                                        } catch (Throwable th58) {
                                                                                                            th2 = th58;
                                                                                                        }
                                                                                                    } catch (Exception e6) {
                                                                                                        e = e6;
                                                                                                        r16 = r16;
                                                                                                        r20 = r20;
                                                                                                        Invoke = 0;
                                                                                                        size = 0;
                                                                                                        exc = e;
                                                                                                        r2 = r20;
                                                                                                        Invoke = Invoke;
                                                                                                        r14 = size;
                                                                                                        r16 = r16;
                                                                                                        r20 = r20;
                                                                                                        if (r2 < length) {
                                                                                                            throw exc;
                                                                                                        }
                                                                                                        i2 = r2 + 1;
                                                                                                        r6 = Invoke;
                                                                                                        r5 = r14;
                                                                                                        r12 = r16;
                                                                                                    }
                                                                                                } catch (Exception e7) {
                                                                                                    e = e7;
                                                                                                    r20 = i2;
                                                                                                    r16 = r16;
                                                                                                }
                                                                                            } catch (Throwable th59) {
                                                                                                th = th59;
                                                                                                Throwable th60 = th;
                                                                                                Throwable cause33 = th60.getCause();
                                                                                                if (cause33 == null) {
                                                                                                    throw th60;
                                                                                                }
                                                                                                throw cause33;
                                                                                            }
                                                                                        } catch (Throwable th61) {
                                                                                            th = th61;
                                                                                        }
                                                                                    } catch (Throwable th62) {
                                                                                        th = th62;
                                                                                        Throwable th63 = th;
                                                                                        Throwable cause34 = th63.getCause();
                                                                                        if (cause34 == null) {
                                                                                            throw th63;
                                                                                        }
                                                                                        throw cause34;
                                                                                    }
                                                                                } catch (Throwable th64) {
                                                                                    th = th64;
                                                                                }
                                                                            } catch (Throwable th65) {
                                                                                th = th65;
                                                                                Throwable th66 = th;
                                                                                Throwable cause35 = th66.getCause();
                                                                                if (cause35 == null) {
                                                                                    throw th66;
                                                                                }
                                                                                throw cause35;
                                                                            }
                                                                        } catch (Throwable th67) {
                                                                            th = th67;
                                                                        }
                                                                    }
                                                                } catch (Throwable th68) {
                                                                    th = th68;
                                                                    th = th;
                                                                    cause = th.getCause();
                                                                    if (cause != null) {
                                                                        throw th;
                                                                    }
                                                                    throw cause;
                                                                }
                                                            } catch (Throwable th69) {
                                                                th = th69;
                                                                th = th;
                                                                cause = th.getCause();
                                                                if (cause != null) {
                                                                    throw th;
                                                                }
                                                                throw cause;
                                                            }
                                                        } catch (Throwable th70) {
                                                            th = th70;
                                                        }
                                                    } catch (Exception e8) {
                                                        e = e8;
                                                        r20 = i2;
                                                        r16 = r12;
                                                    }
                                                } catch (Throwable th71) {
                                                    Throwable cause36 = th71.getCause();
                                                    if (cause36 == null) {
                                                        throw th71;
                                                    }
                                                    throw cause36;
                                                }
                                            } catch (Throwable th72) {
                                                Throwable cause37 = th72.getCause();
                                                if (cause37 == null) {
                                                    throw th72;
                                                }
                                                throw cause37;
                                            }
                                        } catch (Exception e9) {
                                            exc = e9;
                                            r4 = i2;
                                            r17 = r12;
                                            r21 = cArr;
                                        }
                                        Invoke = 0;
                                        r14 = 0;
                                        r2 = r4;
                                        r16 = r17;
                                        r20 = r21;
                                        if (r2 < length) {
                                            throw exc;
                                        }
                                    }
                                } catch (Throwable th73) {
                                    th = th73;
                                    Throwable th74 = th;
                                    Throwable cause38 = th74.getCause();
                                    if (cause38 == null) {
                                        throw th74;
                                    }
                                    throw cause38;
                                }
                            } catch (Throwable th75) {
                                th = th75;
                            }
                        } catch (Throwable th76) {
                            boolean z5 = r6 == true ? 1 : 0;
                            Throwable cause39 = th76.getCause();
                            if (cause39 == null) {
                                throw th76;
                            }
                            throw cause39;
                        }
                    } catch (Exception e10) {
                        e = e10;
                        size = r5;
                        r20 = i2;
                        r16 = r12;
                        Invoke = r6 == true ? 1 : 0;
                    }
                } catch (Exception e11) {
                    e = e11;
                    size = r5;
                    r20 = i2;
                    r16 = r12;
                    Invoke = r6 == true ? 1 : 0;
                }
                i2 = r2 + 1;
                r6 = Invoke;
                r5 = r14;
                r12 = r16;
            }
        } catch (Throwable th77) {
            Throwable cause40 = th77.getCause();
            if (cause40 == null) {
                throw th77;
            }
            throw cause40;
        }
    }
}
