package com.facebook.soloader;

import android.graphics.ImageFormat;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.os.SystemClock;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import io.sentry.instrumentation.file.SentryFileInputStream;
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
import java.math.BigInteger;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.zip.ZipFile;
import javax.annotation.Nullable;
import o.ArtificialStackFrames;
import o.asBinder;
import o.asInterface;
import o.build;
import o.getDefaultImpl;

/* JADX INFO: loaded from: classes.dex */
public class SoFileLoaderImpl implements SoFileLoader {
    private static char ICustomTabsCallback = 32314;
    private static final String TAG = "SoFileLoaderImpl";
    private static char TopicBuilder = 4681;
    private static char extraCallbackWithResult = 46047;
    private static long extraCommand = -9088272968526929569L;
    private static char onMessageChannelReady = 43436;

    @Nullable
    private final Runtime mRuntime = null;

    @Nullable
    private final Method mNativeLoadRuntimeMethod = null;

    @Nullable
    private final String mLocalLdLibraryPath = null;

    @Nullable
    private final String mLocalLdLibraryPathNoZips = null;

    private static void b(int i, char[] cArr, Object[] objArr) {
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

    @Override // com.facebook.soloader.SoFileLoader
    public void loadBytes(String str, ElfByteChannel elfByteChannel, int i) {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002c, code lost:
    
        if (r2 == null) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002e, code lost:
    
        com.facebook.soloader.LogUtil.e(com.facebook.soloader.SoFileLoaderImpl.TAG, "Error when loading library: " + r2 + ", library hash is " + getLibHash(r7) + ", LD_LIBRARY_PATH is " + r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0058, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:?, code lost:
    
        return;
     */
    @Override // com.facebook.soloader.SoFileLoader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void load(java.lang.String r7, int r8) throws java.lang.Exception {
        /*
            Method dump skipped, instruction units count: 212
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.SoFileLoaderImpl.load(java.lang.String, int):void");
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        build buildVar = new build();
        char[] cArr2 = new char[cArr.length];
        buildVar.c = 0;
        char[] cArr3 = new char[2];
        while (buildVar.c < cArr.length) {
            cArr3[0] = cArr[buildVar.c];
            cArr3[1] = cArr[buildVar.c + 1];
            int i2 = 58224;
            for (int i3 = 0; i3 < 16; i3++) {
                char c = cArr3[1];
                char c2 = cArr3[0];
                char c3 = (char) (c - (((c2 + i2) ^ ((c2 << 4) + ((char) (((long) extraCallbackWithResult) ^ (-4408183324873663413L))))) ^ ((c2 >>> 5) + ((char) (((long) onMessageChannelReady) ^ (-4408183324873663413L))))));
                cArr3[1] = c3;
                cArr3[0] = (char) (c2 - (((c3 >>> 5) + ((char) (((long) ICustomTabsCallback) ^ (-4408183324873663413L)))) ^ ((c3 + i2) ^ ((c3 << 4) + ((char) (((long) TopicBuilder) ^ (-4408183324873663413L)))))));
                i2 -= 40503;
            }
            cArr2[buildVar.c] = cArr3[0];
            cArr2[buildVar.c + 1] = cArr3[1];
            buildVar.c += 2;
        }
        objArr[0] = new String(cArr2, 0, i);
    }

    private String getLibHash(String str) {
        try {
            File file = new File(str);
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            FileInputStream fileInputStreamCreate = SentryFileInputStream.Factory.create(new FileInputStream(file), file);
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int i = fileInputStreamCreate.read(bArr);
                    if (i > 0) {
                        messageDigest.update(bArr, 0, i);
                    } else {
                        String str2 = String.format("%32x", new BigInteger(1, messageDigest.digest()));
                        fileInputStreamCreate.close();
                        return str2;
                    }
                }
            } catch (Throwable th) {
                try {
                    fileInputStreamCreate.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException | SecurityException | NoSuchAlgorithmException e) {
            return e.toString();
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x02ee  */
    /* JADX WARN: Code duplicated, block: B:121:0x0354  */
    /* JADX WARN: Code duplicated, block: B:124:0x0390 A[Catch: Exception -> 0x028d, TRY_ENTER, TRY_LEAVE, TryCatch #75 {Exception -> 0x028d, blocks: (B:46:0x01ed, B:49:0x01ff, B:55:0x0261, B:82:0x0296, B:91:0x02dc, B:93:0x02e2, B:94:0x02e3, B:124:0x0390, B:128:0x03ac, B:132:0x040f, B:137:0x0469, B:233:0x05f3, B:237:0x0604, B:242:0x0641, B:244:0x0647, B:245:0x0648, B:247:0x064a, B:249:0x0651, B:250:0x0652, B:252:0x065e, B:253:0x0664, B:268:0x06bf, B:270:0x06c1, B:272:0x06c8, B:273:0x06c9, B:289:0x06f7, B:339:0x07e1, B:344:0x0816, B:349:0x0855, B:351:0x085b, B:352:0x085c, B:354:0x085e, B:356:0x0865, B:357:0x0866, B:359:0x0868, B:361:0x086f, B:362:0x0870, B:139:0x0474, B:141:0x047b, B:142:0x047c, B:144:0x047e, B:146:0x0485, B:147:0x0486, B:149:0x0488, B:151:0x048f, B:152:0x0490, B:154:0x0492, B:156:0x0499, B:157:0x049a, B:159:0x049c, B:161:0x04a3, B:162:0x04a4, B:169:0x04c4, B:171:0x04ca, B:172:0x04cb, B:174:0x04cd, B:176:0x04d4, B:177:0x04d5, B:96:0x02e5, B:98:0x02ec, B:99:0x02ed, B:59:0x026a, B:61:0x0271, B:62:0x0272, B:64:0x0274, B:66:0x027b, B:67:0x027c, B:69:0x027e, B:71:0x0285, B:72:0x0286, B:54:0x023a, B:136:0x044c, B:52:0x0224, B:135:0x0433, B:50:0x0208, B:133:0x0416, B:131:0x03e6, B:129:0x03c9, B:256:0x06a2, B:258:0x06ac, B:259:0x06b1, B:261:0x06b3, B:263:0x06ba, B:264:0x06bb, B:254:0x0665, B:251:0x0653, B:165:0x04a8, B:122:0x0356, B:87:0x02ac, B:84:0x029e), top: B:767:0x01ed, inners: #33, #35, #36, #45, #46, #51, #54, #57, #68, #72, #74, #79, #85, #89 }] */
    /* JADX WARN: Code duplicated, block: B:178:0x04d6 A[Catch: Exception -> 0x0a56, TRY_ENTER, TRY_LEAVE, TryCatch #96 {Exception -> 0x0a56, blocks: (B:119:0x0346, B:199:0x053e, B:277:0x06cf, B:285:0x06e9, B:286:0x06f0, B:291:0x06fb, B:375:0x08a3, B:376:0x08a9, B:178:0x04d6, B:198:0x0531), top: B:805:0x0346 }] */
    /* JADX WARN: Code duplicated, block: B:202:0x054e  */
    /* JADX WARN: Code duplicated, block: B:276:0x06ce  */
    /* JADX WARN: Code duplicated, block: B:288:0x06f6  */
    /* JADX WARN: Code duplicated, block: B:422:0x0931 A[Catch: Exception -> 0x0aea, TryCatch #3 {Exception -> 0x0aea, blocks: (B:420:0x092b, B:422:0x0931, B:423:0x0932), top: B:632:0x092b }] */
    /* JADX WARN: Code duplicated, block: B:423:0x0932 A[Catch: Exception -> 0x0aea, TRY_LEAVE, TryCatch #3 {Exception -> 0x0aea, blocks: (B:420:0x092b, B:422:0x0931, B:423:0x0932), top: B:632:0x092b }] */
    /* JADX WARN: Code duplicated, block: B:446:0x0966 A[Catch: all -> 0x0968, TryCatch #32 {all -> 0x0968, blocks: (B:427:0x093f, B:428:0x0944, B:450:0x096a, B:444:0x095e, B:446:0x0966, B:447:0x0967), top: B:683:0x08a9 }] */
    /* JADX WARN: Code duplicated, block: B:447:0x0967 A[Catch: all -> 0x0968, TryCatch #32 {all -> 0x0968, blocks: (B:427:0x093f, B:428:0x0944, B:450:0x096a, B:444:0x095e, B:446:0x0966, B:447:0x0967), top: B:683:0x08a9 }] */
    /* JADX WARN: Code duplicated, block: B:464:0x098a A[Catch: Exception -> 0x0ade, TryCatch #10 {Exception -> 0x0ade, blocks: (B:522:0x0a1b, B:524:0x0a21, B:525:0x0a22, B:451:0x096b, B:462:0x0983, B:464:0x098a, B:465:0x098b, B:470:0x099d, B:472:0x09a4, B:473:0x09a5, B:488:0x09c7, B:490:0x09ce, B:491:0x09cf, B:502:0x09e8, B:504:0x09ef, B:505:0x09f0, B:513:0x09fb, B:515:0x0a07, B:516:0x0a08, B:536:0x0a30, B:538:0x0a3c, B:539:0x0a3d, B:547:0x0a48, B:549:0x0a54, B:550:0x0a55, B:560:0x0a6a, B:562:0x0a76, B:563:0x0a77, B:573:0x0a86, B:575:0x0a92, B:576:0x0a93, B:586:0x0aa2, B:588:0x0aae, B:589:0x0aaf, B:597:0x0ac5, B:599:0x0acc, B:600:0x0acd, B:602:0x0acf, B:604:0x0adc, B:605:0x0add, B:13:0x011c), top: B:642:0x011c, inners: #80 }] */
    /* JADX WARN: Code duplicated, block: B:465:0x098b A[Catch: Exception -> 0x0ade, TryCatch #10 {Exception -> 0x0ade, blocks: (B:522:0x0a1b, B:524:0x0a21, B:525:0x0a22, B:451:0x096b, B:462:0x0983, B:464:0x098a, B:465:0x098b, B:470:0x099d, B:472:0x09a4, B:473:0x09a5, B:488:0x09c7, B:490:0x09ce, B:491:0x09cf, B:502:0x09e8, B:504:0x09ef, B:505:0x09f0, B:513:0x09fb, B:515:0x0a07, B:516:0x0a08, B:536:0x0a30, B:538:0x0a3c, B:539:0x0a3d, B:547:0x0a48, B:549:0x0a54, B:550:0x0a55, B:560:0x0a6a, B:562:0x0a76, B:563:0x0a77, B:573:0x0a86, B:575:0x0a92, B:576:0x0a93, B:586:0x0aa2, B:588:0x0aae, B:589:0x0aaf, B:597:0x0ac5, B:599:0x0acc, B:600:0x0acd, B:602:0x0acf, B:604:0x0adc, B:605:0x0add, B:13:0x011c), top: B:642:0x011c, inners: #80 }] */
    /* JADX WARN: Code duplicated, block: B:490:0x09ce A[Catch: Exception -> 0x0ade, TryCatch #10 {Exception -> 0x0ade, blocks: (B:522:0x0a1b, B:524:0x0a21, B:525:0x0a22, B:451:0x096b, B:462:0x0983, B:464:0x098a, B:465:0x098b, B:470:0x099d, B:472:0x09a4, B:473:0x09a5, B:488:0x09c7, B:490:0x09ce, B:491:0x09cf, B:502:0x09e8, B:504:0x09ef, B:505:0x09f0, B:513:0x09fb, B:515:0x0a07, B:516:0x0a08, B:536:0x0a30, B:538:0x0a3c, B:539:0x0a3d, B:547:0x0a48, B:549:0x0a54, B:550:0x0a55, B:560:0x0a6a, B:562:0x0a76, B:563:0x0a77, B:573:0x0a86, B:575:0x0a92, B:576:0x0a93, B:586:0x0aa2, B:588:0x0aae, B:589:0x0aaf, B:597:0x0ac5, B:599:0x0acc, B:600:0x0acd, B:602:0x0acf, B:604:0x0adc, B:605:0x0add, B:13:0x011c), top: B:642:0x011c, inners: #80 }] */
    /* JADX WARN: Code duplicated, block: B:491:0x09cf A[Catch: Exception -> 0x0ade, TryCatch #10 {Exception -> 0x0ade, blocks: (B:522:0x0a1b, B:524:0x0a21, B:525:0x0a22, B:451:0x096b, B:462:0x0983, B:464:0x098a, B:465:0x098b, B:470:0x099d, B:472:0x09a4, B:473:0x09a5, B:488:0x09c7, B:490:0x09ce, B:491:0x09cf, B:502:0x09e8, B:504:0x09ef, B:505:0x09f0, B:513:0x09fb, B:515:0x0a07, B:516:0x0a08, B:536:0x0a30, B:538:0x0a3c, B:539:0x0a3d, B:547:0x0a48, B:549:0x0a54, B:550:0x0a55, B:560:0x0a6a, B:562:0x0a76, B:563:0x0a77, B:573:0x0a86, B:575:0x0a92, B:576:0x0a93, B:586:0x0aa2, B:588:0x0aae, B:589:0x0aaf, B:597:0x0ac5, B:599:0x0acc, B:600:0x0acd, B:602:0x0acf, B:604:0x0adc, B:605:0x0add, B:13:0x011c), top: B:642:0x011c, inners: #80 }] */
    /* JADX WARN: Code duplicated, block: B:504:0x09ef A[Catch: Exception -> 0x0ade, TryCatch #10 {Exception -> 0x0ade, blocks: (B:522:0x0a1b, B:524:0x0a21, B:525:0x0a22, B:451:0x096b, B:462:0x0983, B:464:0x098a, B:465:0x098b, B:470:0x099d, B:472:0x09a4, B:473:0x09a5, B:488:0x09c7, B:490:0x09ce, B:491:0x09cf, B:502:0x09e8, B:504:0x09ef, B:505:0x09f0, B:513:0x09fb, B:515:0x0a07, B:516:0x0a08, B:536:0x0a30, B:538:0x0a3c, B:539:0x0a3d, B:547:0x0a48, B:549:0x0a54, B:550:0x0a55, B:560:0x0a6a, B:562:0x0a76, B:563:0x0a77, B:573:0x0a86, B:575:0x0a92, B:576:0x0a93, B:586:0x0aa2, B:588:0x0aae, B:589:0x0aaf, B:597:0x0ac5, B:599:0x0acc, B:600:0x0acd, B:602:0x0acf, B:604:0x0adc, B:605:0x0add, B:13:0x011c), top: B:642:0x011c, inners: #80 }] */
    /* JADX WARN: Code duplicated, block: B:505:0x09f0 A[Catch: Exception -> 0x0ade, TryCatch #10 {Exception -> 0x0ade, blocks: (B:522:0x0a1b, B:524:0x0a21, B:525:0x0a22, B:451:0x096b, B:462:0x0983, B:464:0x098a, B:465:0x098b, B:470:0x099d, B:472:0x09a4, B:473:0x09a5, B:488:0x09c7, B:490:0x09ce, B:491:0x09cf, B:502:0x09e8, B:504:0x09ef, B:505:0x09f0, B:513:0x09fb, B:515:0x0a07, B:516:0x0a08, B:536:0x0a30, B:538:0x0a3c, B:539:0x0a3d, B:547:0x0a48, B:549:0x0a54, B:550:0x0a55, B:560:0x0a6a, B:562:0x0a76, B:563:0x0a77, B:573:0x0a86, B:575:0x0a92, B:576:0x0a93, B:586:0x0aa2, B:588:0x0aae, B:589:0x0aaf, B:597:0x0ac5, B:599:0x0acc, B:600:0x0acd, B:602:0x0acf, B:604:0x0adc, B:605:0x0add, B:13:0x011c), top: B:642:0x011c, inners: #80 }] */
    /* JADX WARN: Code duplicated, block: B:515:0x0a07 A[Catch: Exception -> 0x0ade, TryCatch #10 {Exception -> 0x0ade, blocks: (B:522:0x0a1b, B:524:0x0a21, B:525:0x0a22, B:451:0x096b, B:462:0x0983, B:464:0x098a, B:465:0x098b, B:470:0x099d, B:472:0x09a4, B:473:0x09a5, B:488:0x09c7, B:490:0x09ce, B:491:0x09cf, B:502:0x09e8, B:504:0x09ef, B:505:0x09f0, B:513:0x09fb, B:515:0x0a07, B:516:0x0a08, B:536:0x0a30, B:538:0x0a3c, B:539:0x0a3d, B:547:0x0a48, B:549:0x0a54, B:550:0x0a55, B:560:0x0a6a, B:562:0x0a76, B:563:0x0a77, B:573:0x0a86, B:575:0x0a92, B:576:0x0a93, B:586:0x0aa2, B:588:0x0aae, B:589:0x0aaf, B:597:0x0ac5, B:599:0x0acc, B:600:0x0acd, B:602:0x0acf, B:604:0x0adc, B:605:0x0add, B:13:0x011c), top: B:642:0x011c, inners: #80 }] */
    /* JADX WARN: Code duplicated, block: B:516:0x0a08 A[Catch: Exception -> 0x0ade, TryCatch #10 {Exception -> 0x0ade, blocks: (B:522:0x0a1b, B:524:0x0a21, B:525:0x0a22, B:451:0x096b, B:462:0x0983, B:464:0x098a, B:465:0x098b, B:470:0x099d, B:472:0x09a4, B:473:0x09a5, B:488:0x09c7, B:490:0x09ce, B:491:0x09cf, B:502:0x09e8, B:504:0x09ef, B:505:0x09f0, B:513:0x09fb, B:515:0x0a07, B:516:0x0a08, B:536:0x0a30, B:538:0x0a3c, B:539:0x0a3d, B:547:0x0a48, B:549:0x0a54, B:550:0x0a55, B:560:0x0a6a, B:562:0x0a76, B:563:0x0a77, B:573:0x0a86, B:575:0x0a92, B:576:0x0a93, B:586:0x0aa2, B:588:0x0aae, B:589:0x0aaf, B:597:0x0ac5, B:599:0x0acc, B:600:0x0acd, B:602:0x0acf, B:604:0x0adc, B:605:0x0add, B:13:0x011c), top: B:642:0x011c, inners: #80 }] */
    /* JADX WARN: Code duplicated, block: B:524:0x0a21 A[Catch: Exception -> 0x0ade, TryCatch #10 {Exception -> 0x0ade, blocks: (B:522:0x0a1b, B:524:0x0a21, B:525:0x0a22, B:451:0x096b, B:462:0x0983, B:464:0x098a, B:465:0x098b, B:470:0x099d, B:472:0x09a4, B:473:0x09a5, B:488:0x09c7, B:490:0x09ce, B:491:0x09cf, B:502:0x09e8, B:504:0x09ef, B:505:0x09f0, B:513:0x09fb, B:515:0x0a07, B:516:0x0a08, B:536:0x0a30, B:538:0x0a3c, B:539:0x0a3d, B:547:0x0a48, B:549:0x0a54, B:550:0x0a55, B:560:0x0a6a, B:562:0x0a76, B:563:0x0a77, B:573:0x0a86, B:575:0x0a92, B:576:0x0a93, B:586:0x0aa2, B:588:0x0aae, B:589:0x0aaf, B:597:0x0ac5, B:599:0x0acc, B:600:0x0acd, B:602:0x0acf, B:604:0x0adc, B:605:0x0add, B:13:0x011c), top: B:642:0x011c, inners: #80 }] */
    /* JADX WARN: Code duplicated, block: B:525:0x0a22 A[Catch: Exception -> 0x0ade, TryCatch #10 {Exception -> 0x0ade, blocks: (B:522:0x0a1b, B:524:0x0a21, B:525:0x0a22, B:451:0x096b, B:462:0x0983, B:464:0x098a, B:465:0x098b, B:470:0x099d, B:472:0x09a4, B:473:0x09a5, B:488:0x09c7, B:490:0x09ce, B:491:0x09cf, B:502:0x09e8, B:504:0x09ef, B:505:0x09f0, B:513:0x09fb, B:515:0x0a07, B:516:0x0a08, B:536:0x0a30, B:538:0x0a3c, B:539:0x0a3d, B:547:0x0a48, B:549:0x0a54, B:550:0x0a55, B:560:0x0a6a, B:562:0x0a76, B:563:0x0a77, B:573:0x0a86, B:575:0x0a92, B:576:0x0a93, B:586:0x0aa2, B:588:0x0aae, B:589:0x0aaf, B:597:0x0ac5, B:599:0x0acc, B:600:0x0acd, B:602:0x0acf, B:604:0x0adc, B:605:0x0add, B:13:0x011c), top: B:642:0x011c, inners: #80 }] */
    /* JADX WARN: Code duplicated, block: B:538:0x0a3c A[Catch: Exception -> 0x0ade, TryCatch #10 {Exception -> 0x0ade, blocks: (B:522:0x0a1b, B:524:0x0a21, B:525:0x0a22, B:451:0x096b, B:462:0x0983, B:464:0x098a, B:465:0x098b, B:470:0x099d, B:472:0x09a4, B:473:0x09a5, B:488:0x09c7, B:490:0x09ce, B:491:0x09cf, B:502:0x09e8, B:504:0x09ef, B:505:0x09f0, B:513:0x09fb, B:515:0x0a07, B:516:0x0a08, B:536:0x0a30, B:538:0x0a3c, B:539:0x0a3d, B:547:0x0a48, B:549:0x0a54, B:550:0x0a55, B:560:0x0a6a, B:562:0x0a76, B:563:0x0a77, B:573:0x0a86, B:575:0x0a92, B:576:0x0a93, B:586:0x0aa2, B:588:0x0aae, B:589:0x0aaf, B:597:0x0ac5, B:599:0x0acc, B:600:0x0acd, B:602:0x0acf, B:604:0x0adc, B:605:0x0add, B:13:0x011c), top: B:642:0x011c, inners: #80 }] */
    /* JADX WARN: Code duplicated, block: B:539:0x0a3d A[Catch: Exception -> 0x0ade, TryCatch #10 {Exception -> 0x0ade, blocks: (B:522:0x0a1b, B:524:0x0a21, B:525:0x0a22, B:451:0x096b, B:462:0x0983, B:464:0x098a, B:465:0x098b, B:470:0x099d, B:472:0x09a4, B:473:0x09a5, B:488:0x09c7, B:490:0x09ce, B:491:0x09cf, B:502:0x09e8, B:504:0x09ef, B:505:0x09f0, B:513:0x09fb, B:515:0x0a07, B:516:0x0a08, B:536:0x0a30, B:538:0x0a3c, B:539:0x0a3d, B:547:0x0a48, B:549:0x0a54, B:550:0x0a55, B:560:0x0a6a, B:562:0x0a76, B:563:0x0a77, B:573:0x0a86, B:575:0x0a92, B:576:0x0a93, B:586:0x0aa2, B:588:0x0aae, B:589:0x0aaf, B:597:0x0ac5, B:599:0x0acc, B:600:0x0acd, B:602:0x0acf, B:604:0x0adc, B:605:0x0add, B:13:0x011c), top: B:642:0x011c, inners: #80 }] */
    /* JADX WARN: Code duplicated, block: B:549:0x0a54 A[Catch: Exception -> 0x0ade, TryCatch #10 {Exception -> 0x0ade, blocks: (B:522:0x0a1b, B:524:0x0a21, B:525:0x0a22, B:451:0x096b, B:462:0x0983, B:464:0x098a, B:465:0x098b, B:470:0x099d, B:472:0x09a4, B:473:0x09a5, B:488:0x09c7, B:490:0x09ce, B:491:0x09cf, B:502:0x09e8, B:504:0x09ef, B:505:0x09f0, B:513:0x09fb, B:515:0x0a07, B:516:0x0a08, B:536:0x0a30, B:538:0x0a3c, B:539:0x0a3d, B:547:0x0a48, B:549:0x0a54, B:550:0x0a55, B:560:0x0a6a, B:562:0x0a76, B:563:0x0a77, B:573:0x0a86, B:575:0x0a92, B:576:0x0a93, B:586:0x0aa2, B:588:0x0aae, B:589:0x0aaf, B:597:0x0ac5, B:599:0x0acc, B:600:0x0acd, B:602:0x0acf, B:604:0x0adc, B:605:0x0add, B:13:0x011c), top: B:642:0x011c, inners: #80 }] */
    /* JADX WARN: Code duplicated, block: B:550:0x0a55 A[Catch: Exception -> 0x0ade, TryCatch #10 {Exception -> 0x0ade, blocks: (B:522:0x0a1b, B:524:0x0a21, B:525:0x0a22, B:451:0x096b, B:462:0x0983, B:464:0x098a, B:465:0x098b, B:470:0x099d, B:472:0x09a4, B:473:0x09a5, B:488:0x09c7, B:490:0x09ce, B:491:0x09cf, B:502:0x09e8, B:504:0x09ef, B:505:0x09f0, B:513:0x09fb, B:515:0x0a07, B:516:0x0a08, B:536:0x0a30, B:538:0x0a3c, B:539:0x0a3d, B:547:0x0a48, B:549:0x0a54, B:550:0x0a55, B:560:0x0a6a, B:562:0x0a76, B:563:0x0a77, B:573:0x0a86, B:575:0x0a92, B:576:0x0a93, B:586:0x0aa2, B:588:0x0aae, B:589:0x0aaf, B:597:0x0ac5, B:599:0x0acc, B:600:0x0acd, B:602:0x0acf, B:604:0x0adc, B:605:0x0add, B:13:0x011c), top: B:642:0x011c, inners: #80 }] */
    /* JADX WARN: Code duplicated, block: B:562:0x0a76 A[Catch: Exception -> 0x0ade, TryCatch #10 {Exception -> 0x0ade, blocks: (B:522:0x0a1b, B:524:0x0a21, B:525:0x0a22, B:451:0x096b, B:462:0x0983, B:464:0x098a, B:465:0x098b, B:470:0x099d, B:472:0x09a4, B:473:0x09a5, B:488:0x09c7, B:490:0x09ce, B:491:0x09cf, B:502:0x09e8, B:504:0x09ef, B:505:0x09f0, B:513:0x09fb, B:515:0x0a07, B:516:0x0a08, B:536:0x0a30, B:538:0x0a3c, B:539:0x0a3d, B:547:0x0a48, B:549:0x0a54, B:550:0x0a55, B:560:0x0a6a, B:562:0x0a76, B:563:0x0a77, B:573:0x0a86, B:575:0x0a92, B:576:0x0a93, B:586:0x0aa2, B:588:0x0aae, B:589:0x0aaf, B:597:0x0ac5, B:599:0x0acc, B:600:0x0acd, B:602:0x0acf, B:604:0x0adc, B:605:0x0add, B:13:0x011c), top: B:642:0x011c, inners: #80 }] */
    /* JADX WARN: Code duplicated, block: B:563:0x0a77 A[Catch: Exception -> 0x0ade, TryCatch #10 {Exception -> 0x0ade, blocks: (B:522:0x0a1b, B:524:0x0a21, B:525:0x0a22, B:451:0x096b, B:462:0x0983, B:464:0x098a, B:465:0x098b, B:470:0x099d, B:472:0x09a4, B:473:0x09a5, B:488:0x09c7, B:490:0x09ce, B:491:0x09cf, B:502:0x09e8, B:504:0x09ef, B:505:0x09f0, B:513:0x09fb, B:515:0x0a07, B:516:0x0a08, B:536:0x0a30, B:538:0x0a3c, B:539:0x0a3d, B:547:0x0a48, B:549:0x0a54, B:550:0x0a55, B:560:0x0a6a, B:562:0x0a76, B:563:0x0a77, B:573:0x0a86, B:575:0x0a92, B:576:0x0a93, B:586:0x0aa2, B:588:0x0aae, B:589:0x0aaf, B:597:0x0ac5, B:599:0x0acc, B:600:0x0acd, B:602:0x0acf, B:604:0x0adc, B:605:0x0add, B:13:0x011c), top: B:642:0x011c, inners: #80 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x0267  */
    /* JADX WARN: Code duplicated, block: B:599:0x0acc A[Catch: Exception -> 0x0ade, TryCatch #10 {Exception -> 0x0ade, blocks: (B:522:0x0a1b, B:524:0x0a21, B:525:0x0a22, B:451:0x096b, B:462:0x0983, B:464:0x098a, B:465:0x098b, B:470:0x099d, B:472:0x09a4, B:473:0x09a5, B:488:0x09c7, B:490:0x09ce, B:491:0x09cf, B:502:0x09e8, B:504:0x09ef, B:505:0x09f0, B:513:0x09fb, B:515:0x0a07, B:516:0x0a08, B:536:0x0a30, B:538:0x0a3c, B:539:0x0a3d, B:547:0x0a48, B:549:0x0a54, B:550:0x0a55, B:560:0x0a6a, B:562:0x0a76, B:563:0x0a77, B:573:0x0a86, B:575:0x0a92, B:576:0x0a93, B:586:0x0aa2, B:588:0x0aae, B:589:0x0aaf, B:597:0x0ac5, B:599:0x0acc, B:600:0x0acd, B:602:0x0acf, B:604:0x0adc, B:605:0x0add, B:13:0x011c), top: B:642:0x011c, inners: #80 }] */
    /* JADX WARN: Code duplicated, block: B:600:0x0acd A[Catch: Exception -> 0x0ade, TryCatch #10 {Exception -> 0x0ade, blocks: (B:522:0x0a1b, B:524:0x0a21, B:525:0x0a22, B:451:0x096b, B:462:0x0983, B:464:0x098a, B:465:0x098b, B:470:0x099d, B:472:0x09a4, B:473:0x09a5, B:488:0x09c7, B:490:0x09ce, B:491:0x09cf, B:502:0x09e8, B:504:0x09ef, B:505:0x09f0, B:513:0x09fb, B:515:0x0a07, B:516:0x0a08, B:536:0x0a30, B:538:0x0a3c, B:539:0x0a3d, B:547:0x0a48, B:549:0x0a54, B:550:0x0a55, B:560:0x0a6a, B:562:0x0a76, B:563:0x0a77, B:573:0x0a86, B:575:0x0a92, B:576:0x0a93, B:586:0x0aa2, B:588:0x0aae, B:589:0x0aaf, B:597:0x0ac5, B:599:0x0acc, B:600:0x0acd, B:602:0x0acf, B:604:0x0adc, B:605:0x0add, B:13:0x011c), top: B:642:0x011c, inners: #80 }] */
    /* JADX WARN: Code duplicated, block: B:716:0x0590 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:765:0x04a8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:767:0x01ed A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:792:0x029e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:80:0x0293  */
    /* JADX WARN: Code duplicated, block: B:821:0x0af5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:823:0x0aea A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:825:0x06fb A[EDGE_INSN: B:825:0x06fb->B:291:0x06fb BREAK  A[LOOP:1: B:286:0x06f0->B:289:0x06f7], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:82:0x0296 A[Catch: Exception -> 0x028d, TRY_LEAVE, TryCatch #75 {Exception -> 0x028d, blocks: (B:46:0x01ed, B:49:0x01ff, B:55:0x0261, B:82:0x0296, B:91:0x02dc, B:93:0x02e2, B:94:0x02e3, B:124:0x0390, B:128:0x03ac, B:132:0x040f, B:137:0x0469, B:233:0x05f3, B:237:0x0604, B:242:0x0641, B:244:0x0647, B:245:0x0648, B:247:0x064a, B:249:0x0651, B:250:0x0652, B:252:0x065e, B:253:0x0664, B:268:0x06bf, B:270:0x06c1, B:272:0x06c8, B:273:0x06c9, B:289:0x06f7, B:339:0x07e1, B:344:0x0816, B:349:0x0855, B:351:0x085b, B:352:0x085c, B:354:0x085e, B:356:0x0865, B:357:0x0866, B:359:0x0868, B:361:0x086f, B:362:0x0870, B:139:0x0474, B:141:0x047b, B:142:0x047c, B:144:0x047e, B:146:0x0485, B:147:0x0486, B:149:0x0488, B:151:0x048f, B:152:0x0490, B:154:0x0492, B:156:0x0499, B:157:0x049a, B:159:0x049c, B:161:0x04a3, B:162:0x04a4, B:169:0x04c4, B:171:0x04ca, B:172:0x04cb, B:174:0x04cd, B:176:0x04d4, B:177:0x04d5, B:96:0x02e5, B:98:0x02ec, B:99:0x02ed, B:59:0x026a, B:61:0x0271, B:62:0x0272, B:64:0x0274, B:66:0x027b, B:67:0x027c, B:69:0x027e, B:71:0x0285, B:72:0x0286, B:54:0x023a, B:136:0x044c, B:52:0x0224, B:135:0x0433, B:50:0x0208, B:133:0x0416, B:131:0x03e6, B:129:0x03c9, B:256:0x06a2, B:258:0x06ac, B:259:0x06b1, B:261:0x06b3, B:263:0x06ba, B:264:0x06bb, B:254:0x0665, B:251:0x0653, B:165:0x04a8, B:122:0x0356, B:87:0x02ac, B:84:0x029e), top: B:767:0x01ed, inners: #33, #35, #36, #45, #46, #51, #54, #57, #68, #72, #74, #79, #85, #89 }] */
    /* JADX WARN: Code duplicated, block: B:86:0x02ab  */
    /* JADX WARN: Instruction removed from duplicated block: B:178:0x04d6, please report this as an issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v101 */
    /* JADX WARN: Type inference failed for: r10v102 */
    /* JADX WARN: Type inference failed for: r10v103 */
    /* JADX WARN: Type inference failed for: r10v107 */
    /* JADX WARN: Type inference failed for: r10v108 */
    /* JADX WARN: Type inference failed for: r10v109 */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v120 */
    /* JADX WARN: Type inference failed for: r10v121 */
    /* JADX WARN: Type inference failed for: r10v123 */
    /* JADX WARN: Type inference failed for: r10v124 */
    /* JADX WARN: Type inference failed for: r10v125 */
    /* JADX WARN: Type inference failed for: r10v126 */
    /* JADX WARN: Type inference failed for: r10v127 */
    /* JADX WARN: Type inference failed for: r10v128 */
    /* JADX WARN: Type inference failed for: r10v13 */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v16, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v19 */
    /* JADX WARN: Type inference failed for: r10v36 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v53 */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r10v72 */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r11v111 */
    /* JADX WARN: Type inference failed for: r11v125 */
    /* JADX WARN: Type inference failed for: r11v126 */
    /* JADX WARN: Type inference failed for: r11v127 */
    /* JADX WARN: Type inference failed for: r11v128 */
    /* JADX WARN: Type inference failed for: r11v129 */
    /* JADX WARN: Type inference failed for: r11v151, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r11v169 */
    /* JADX WARN: Type inference failed for: r11v178 */
    /* JADX WARN: Type inference failed for: r11v179 */
    /* JADX WARN: Type inference failed for: r11v18 */
    /* JADX WARN: Type inference failed for: r11v180 */
    /* JADX WARN: Type inference failed for: r11v181 */
    /* JADX WARN: Type inference failed for: r11v182 */
    /* JADX WARN: Type inference failed for: r11v183 */
    /* JADX WARN: Type inference failed for: r11v184 */
    /* JADX WARN: Type inference failed for: r11v185 */
    /* JADX WARN: Type inference failed for: r11v19 */
    /* JADX WARN: Type inference failed for: r11v20 */
    /* JADX WARN: Type inference failed for: r11v21 */
    /* JADX WARN: Type inference failed for: r11v22 */
    /* JADX WARN: Type inference failed for: r11v28, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v30 */
    /* JADX WARN: Type inference failed for: r11v32, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v36, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v53 */
    /* JADX WARN: Type inference failed for: r11v55, types: [java.lang.ClassLoader] */
    /* JADX WARN: Type inference failed for: r11v57, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r11v73, types: [java.util.zip.ZipFile] */
    /* JADX WARN: Type inference failed for: r11v89 */
    /* JADX WARN: Type inference failed for: r12v111, types: [java.lang.reflect.Method] */
    /* JADX WARN: Type inference failed for: r12v14, types: [java.lang.reflect.Method] */
    /* JADX WARN: Type inference failed for: r1v73, types: [java.lang.reflect.Method] */
    /* JADX WARN: Type inference failed for: r1v96, types: [java.lang.reflect.Method] */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v24, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v87, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v88 */
    /* JADX WARN: Type inference failed for: r2v89 */
    /* JADX WARN: Type inference failed for: r5v13, types: [java.lang.reflect.Method] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v20, types: [java.lang.reflect.Method] */
    /* JADX WARN: Type inference failed for: r9v3, types: [java.lang.Object, java.lang.String[]] */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 6 */
    private static void coroutineCreation(String str) throws Exception {
        ?? NewInstance;
        Exception exc;
        ?? r11;
        ?? r10;
        Throwable th;
        Throwable cause;
        String strCoroutineDebuggingKt;
        ?? CoroutineDebuggingKt;
        ?? r12;
        int i;
        ?? r13;
        Throwable th2;
        Throwable cause2;
        Object objNewInstance;
        BufferedInputStream bufferedInputStream;
        URL resource;
        Throwable th3;
        Throwable cause3;
        Throwable th4;
        Throwable cause4;
        InputStream inputStream;
        Throwable th5;
        Throwable cause5;
        Object objAccessartificialFrame;
        InputStream inputStream2;
        BufferedOutputStream bufferedOutputStream;
        Throwable th6;
        Throwable cause6;
        byte[] bArr;
        int i2;
        Throwable th7;
        Throwable cause7;
        Throwable th8;
        Throwable cause8;
        Throwable th9;
        Throwable cause9;
        Throwable th10;
        Throwable cause10;
        Throwable th11;
        Throwable cause11;
        Object[] objArr;
        File externalStorageDirectory;
        String str2 = str;
        int i3 = 1;
        Object[] objArr2 = new Object[1];
        a(10 - ((byte) KeyEvent.getModifierMetaStateMask()), new char[]{57328, 39403, 60715, 12266, 14223, 40579, 52984, 11861, 35620, 8615, 4060, 15450}, objArr2);
        ?? r2 = 0;
        String str3 = (String) objArr2[0];
        Object[] objArr3 = new Object[1];
        b((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 29034, new char[]{22819, 10316, 48096, 3352, 40064, 28207, 61775, 16609, 53887}, objArr3);
        String str4 = (String) objArr3[0];
        Object[] objArr4 = new Object[1];
        a((ViewConfiguration.getTapTimeout() >> 16) + 10, new char[]{64197, 52566, 46705, 35843, 17202, 16307, 32722, 8534, 8231, 16688}, objArr4);
        String str5 = (String) objArr4[0];
        Object[] objArr5 = new Object[1];
        b(24247 - (KeyEvent.getMaxKeyCode() >> 16), new char[]{22911}, objArr5);
        try {
            Object objInvoke = String.class.getMethod(str4, Integer.TYPE, Integer.TYPE).invoke(str2, Integer.valueOf(((Integer) String.class.getMethod(str3, String.class).invoke(str2, (String) objArr5[0])).intValue() + 4), Integer.valueOf(((Integer) String.class.getMethod("length", null).invoke(str2, null)).intValue() - 3));
            Object[] objArr6 = new Object[1];
            b(15602 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), new char[]{22789, 26101, 8436, 61358, 43692}, objArr6);
            String[] strArrCoroutineDebuggingKt = asInterface.CoroutineDebuggingKt(asInterface.ArtificialStackFrames((byte[]) String.class.getMethod("getBytes", String.class).invoke(objInvoke, (String) objArr6[0])));
            if (strArrCoroutineDebuggingKt == null) {
                strArrCoroutineDebuggingKt = new String[0];
            }
            int length = strArrCoroutineDebuggingKt.length;
            ?? r9 = new String[length + 1];
            System.arraycopy(strArrCoroutineDebuggingKt, 0, r9, 0, length);
            r9[length] = str2;
            int i4 = 0;
            while (i4 <= length) {
                ?? r14 = r9[i4];
                try {
                    Object[] objArr7 = new Object[i3];
                    a(32 - ((Process.getThreadPriority(r2) + 20) >> 6), new char[]{9539, 9132, 36375, 41973, 11483, 9011, 65235, 38986, 55528, 29524, 25123, 58685, 33616, 24386, 4145, 61756, 19816, 23314, 16359, 40494, 4029, 10155, 1480, 50167, 1207, 4363, 17202, 16307, 1480, 50167, 52696, 33643}, objArr7);
                    NewInstance = (String) objArr7[r2];
                    try {
                        try {
                            Class[] clsArr = new Class[i3];
                            clsArr[r2] = String.class;
                            NewInstance = File.class.getDeclaredConstructor(clsArr).newInstance(NewInstance);
                            try {
                                try {
                                    Object[] objArr8 = new Object[i3];
                                    b(25866 - TextUtils.indexOf((CharSequence) "", '0', (int) r2), new char[]{22835, 15418, 37672, 30246, 52494, 40974, 1894, 39544}, objArr8);
                                    try {
                                        boolean zBooleanValue = ((Boolean) File.class.getMethod((String) objArr8[r2], null).invoke(NewInstance, null)).booleanValue();
                                        ?? r15 = NewInstance;
                                        if (zBooleanValue) {
                                            if (i4 >= length) {
                                                r15 = externalStorageDirectory;
                                                int iIndexOf = TextUtils.indexOf("", "", (int) r2) + 24247;
                                                char[] cArr = new char[i3];
                                                cArr[r2] = 22911;
                                                Object[] objArr9 = new Object[i3];
                                                b(iIndexOf, cArr, objArr9);
                                                Object[] objArr10 = {(String) objArr9[r2]};
                                                Class[] clsArr2 = new Class[i3];
                                                clsArr2[r2] = String.class;
                                                int iIntValue = ((Integer) String.class.getMethod(str3, clsArr2).invoke(str2, objArr10)).intValue() + 4;
                                                Object[] objArr11 = new Object[2];
                                                objArr11[i3] = Integer.valueOf(((Integer) String.class.getMethod("length", null).invoke(str2, null)).intValue() - 3);
                                                objArr11[0] = Integer.valueOf(iIntValue);
                                                strCoroutineDebuggingKt = getDefaultImpl.CoroutineDebuggingKt(SoFileLoaderImpl.class, (String) String.class.getMethod(str4, Integer.TYPE, Integer.TYPE).invoke(str2, objArr11));
                                                CoroutineDebuggingKt = strCoroutineDebuggingKt;
                                                if (strCoroutineDebuggingKt == null) {
                                                    CoroutineDebuggingKt = str2;
                                                }
                                            } else {
                                                CoroutineDebuggingKt = r14;
                                            }
                                            if (i4 < length) {
                                                r15 = externalStorageDirectory;
                                                CoroutineDebuggingKt = getDefaultImpl.CoroutineDebuggingKt(SoFileLoaderImpl.class, CoroutineDebuggingKt);
                                            }
                                            if (CoroutineDebuggingKt == 0) {
                                                Object objInvoke2 = Runtime.class.getMethod(str5, null).invoke(null, null);
                                                r13 = r14;
                                                if (i4 >= length) {
                                                    r13 = str2;
                                                }
                                                Object[] objArr12 = new Object[1];
                                                b(MotionEvent.axisFromString("") + 8538, new char[]{22844, 30822, 7043, 15679, 56440, 65412, 37156, 45133, 21497, 29955, 5203}, objArr12);
                                                Runtime.class.getMethod((String) objArr12[0], String.class).invoke(objInvoke2, r13);
                                                return;
                                            }
                                            Object[] objArr13 = new Object[1];
                                            objArr13[0] = 47;
                                            Class[] clsArr3 = new Class[1];
                                            clsArr3[0] = Integer.TYPE;
                                            Object[] objArr14 = new Object[1];
                                            objArr14[0] = Integer.valueOf(((Integer) String.class.getMethod(str3, clsArr3).invoke(CoroutineDebuggingKt, objArr13)).intValue() + 1);
                                            Class[] clsArr4 = new Class[1];
                                            clsArr4[0] = Integer.TYPE;
                                            Object[] objArr15 = {r15, String.class.getMethod(str4, clsArr4).invoke(CoroutineDebuggingKt, objArr14)};
                                            Class[] clsArr5 = new Class[2];
                                            clsArr5[0] = File.class;
                                            clsArr5[1] = String.class;
                                            objNewInstance = File.class.getDeclaredConstructor(clsArr5).newInstance(objArr15);
                                            resource = SoFileLoaderImpl.class.getClassLoader().getResource(CoroutineDebuggingKt);
                                            if (resource == null) {
                                                objArr = new Object[1];
                                                b((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 48448, new char[]{22835, 58494, 9148, 28391, 44085, 60284, 14008, 30180}, objArr);
                                                if (((Boolean) String.class.getMethod((String) objArr[0], CharSequence.class).invoke(CoroutineDebuggingKt, "!")).booleanValue()) {
                                                    ?? sb = new StringBuilder();
                                                    Object[] objArr16 = new Object[1];
                                                    a(8 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), new char[]{14205, 32745, 60794, 39436, 19019, 15134, 26290, 5840, 12953, 32234}, objArr16);
                                                    sb.append((String) objArr16[0]);
                                                    sb.append(CoroutineDebuggingKt);
                                                    String path = new URL(sb.toString()).getPath();
                                                    ZipFile zipFile = new ZipFile((String) String.class.getMethod(str4, Integer.TYPE, Integer.TYPE).invoke(path, 5, Integer.valueOf(((Integer) String.class.getMethod(str3, String.class).invoke(path, "!/")).intValue())));
                                                    inputStream = zipFile.getInputStream(zipFile.getEntry((String) String.class.getMethod(str4, Integer.TYPE).invoke(String.class.getMethod(str4, Integer.TYPE).invoke(CoroutineDebuggingKt, Integer.valueOf(((Integer) String.class.getMethod(str3, String.class).invoke(CoroutineDebuggingKt, "!/")).intValue())), 2)));
                                                } else {
                                                    inputStream = (InputStream) FileInputStream.class.getDeclaredConstructor(String.class).newInstance(CoroutineDebuggingKt);
                                                }
                                            } else {
                                                String path2 = resource.getPath();
                                                Object[] objArr17 = {"!/" + CoroutineDebuggingKt};
                                                Class[] clsArr6 = new Class[1];
                                                clsArr6[0] = String.class;
                                                Object[] objArr18 = new Object[2];
                                                objArr18[1] = Integer.valueOf(((Integer) String.class.getMethod(str3, clsArr6).invoke(path2, objArr17)).intValue());
                                                objArr18[0] = 5;
                                                Class[] clsArr7 = new Class[2];
                                                clsArr7[0] = Integer.TYPE;
                                                clsArr7[1] = Integer.TYPE;
                                                ?? zipFile2 = new ZipFile((String) String.class.getMethod(str4, clsArr7).invoke(path2, objArr18));
                                                inputStream = zipFile2.getInputStream(zipFile2.getEntry(CoroutineDebuggingKt));
                                            }
                                            bufferedInputStream = new BufferedInputStream(inputStream);
                                            Object[] objArr19 = {bufferedInputStream};
                                            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-175194354);
                                            if (objAccessartificialFrame == null) {
                                                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation('I' - AndroidCharacter.getMirror('0'), (char) View.MeasureSpec.makeMeasureSpec(0, 0), View.getDefaultSize(0, 0) + 49, 1793849606, false, "CoroutineDebuggingKt", new Class[]{InputStream.class});
                                            }
                                            inputStream2 = (InputStream) ((Method) objAccessartificialFrame).invoke(null, objArr19);
                                            if (bufferedInputStream == inputStream2) {
                                                inputStream2.close();
                                                Object objInvoke3 = Runtime.class.getMethod(str5, null).invoke(null, null);
                                                Object[] objArr20 = {CoroutineDebuggingKt, SoFileLoaderImpl.class.getClassLoader()};
                                                Object[] objArr21 = new Object[1];
                                                a(((byte) KeyEvent.getModifierMetaStateMask()) + 5, new char[]{45833, 40960, 7428, 22390}, objArr21);
                                                Method declaredMethod = Runtime.class.getDeclaredMethod((String) objArr21[0], String.class, ClassLoader.class);
                                                declaredMethod.setAccessible(true);
                                                declaredMethod.invoke(objInvoke3, objArr20);
                                                r10 = 0;
                                                r11 = 1;
                                            } else {
                                                Object[] objArr22 = {objNewInstance};
                                                Class[] clsArr8 = new Class[1];
                                                clsArr8[0] = File.class;
                                                OutputStream outputStream = (OutputStream) FileOutputStream.class.getDeclaredConstructor(clsArr8).newInstance(objArr22);
                                                bufferedOutputStream = new BufferedOutputStream(outputStream);
                                                bArr = new byte[1024];
                                                while (true) {
                                                    i2 = inputStream2.read(bArr);
                                                    if (i2 >= 0) {
                                                        break;
                                                        break;
                                                    }
                                                    bufferedOutputStream.write(bArr, 0, i2);
                                                }
                                                bufferedOutputStream.flush();
                                                Object[] objArr23 = new Object[1];
                                                a(TextUtils.lastIndexOf("", '0') + 6, new char[]{64197, 52566, 3923, 20496, 61602, 59337}, objArr23);
                                                Object objInvoke4 = FileOutputStream.class.getMethod((String) objArr23[0], null).invoke(outputStream, null);
                                                Object[] objArr24 = new Object[1];
                                                b(KeyEvent.getDeadChar(0, 0) + 38393, new char[]{22819, 52432, 29388, 39128}, objArr24);
                                                FileDescriptor.class.getMethod((String) objArr24[0], null).invoke(objInvoke4, null);
                                                bufferedOutputStream.close();
                                                inputStream2.close();
                                                Object objInvoke5 = Runtime.class.getMethod(str5, null).invoke(null, null);
                                                Object[] objArr25 = new Object[1];
                                                a(15 - (ViewConfiguration.getPressedStateDuration() >> 16), new char[]{64197, 52566, 61446, 59135, 18966, 11697, 53056, 48663, 35220, 42543, 4772, 59884, 36375, 41973, 34824, 18695}, objArr25);
                                                Object[] objArr26 = {File.class.getMethod((String) objArr25[0], null).invoke(objNewInstance, null), SoFileLoaderImpl.class.getClassLoader()};
                                                Object[] objArr27 = new Object[1];
                                                a(4 - ((Process.getThreadPriority(0) + 20) >> 6), new char[]{45833, 40960, 7428, 22390}, objArr27);
                                                Method declaredMethod2 = Runtime.class.getDeclaredMethod((String) objArr27[0], String.class, ClassLoader.class);
                                                declaredMethod2.setAccessible(true);
                                                declaredMethod2.invoke(objInvoke5, objArr26);
                                                r11 = 1;
                                                r11 = 1;
                                                r11 = 1;
                                                r11 = 1;
                                                Object[] objArr28 = new Object[1];
                                                b(49409 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), new char[]{22836, 38964, 56126, 6710, 23840, 39984}, objArr28);
                                                r10 = 0;
                                                r10 = 0;
                                                r10 = 0;
                                                ((Boolean) File.class.getMethod((String) objArr28[0], null).invoke(objNewInstance, null)).booleanValue();
                                            }
                                            e = e;
                                            exc = e;
                                            r12 = 0;
                                            i = 1;
                                            r10 = r12;
                                            r11 = i;
                                            if (i4 < length) {
                                                throw exc;
                                            }
                                        } else {
                                            try {
                                                try {
                                                    Object[] objArr29 = new Object[i3];
                                                    b((TypedValue.complexToFraction(r2, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(r2, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 62401, new char[]{22842, 43760, 48804, 33394, 38522, 39932, 61369, 62265, 50988, 51444, 56490, 8319, 13365, 14831}, objArr29);
                                                    String str6 = (String) objArr29[r2];
                                                    try {
                                                        Object[] objArr30 = {System.getProperty(str6, str6)};
                                                        Class[] clsArr9 = new Class[i3];
                                                        clsArr9[r2] = String.class;
                                                        Object objNewInstance2 = File.class.getDeclaredConstructor(clsArr9).newInstance(objArr30);
                                                        try {
                                                            Object[] objArr31 = new Object[i3];
                                                            b(25867 - TextUtils.getOffsetAfter("", r2), new char[]{22835, 15418, 37672, 30246, 52494, 40974, 1894, 39544}, objArr31);
                                                            boolean zBooleanValue2 = ((Boolean) File.class.getMethod((String) objArr31[r2], null).invoke(objNewInstance2, null)).booleanValue();
                                                            r15 = objNewInstance2;
                                                            if (!zBooleanValue2) {
                                                                externalStorageDirectory = Environment.getExternalStorageDirectory();
                                                            }
                                                            if (i4 >= length) {
                                                                try {
                                                                    r15 = externalStorageDirectory;
                                                                    int iIndexOf2 = TextUtils.indexOf("", "", (int) r2) + 24247;
                                                                    try {
                                                                        char[] cArr2 = new char[i3];
                                                                        cArr2[r2] = 22911;
                                                                        Object[] objArr32 = new Object[i3];
                                                                        b(iIndexOf2, cArr2, objArr32);
                                                                        try {
                                                                            Object[] objArr110 = {(String) objArr32[r2]};
                                                                            Class[] clsArr10 = new Class[i3];
                                                                            clsArr10[r2] = String.class;
                                                                            int iIntValue2 = ((Integer) String.class.getMethod(str3, clsArr10).invoke(str2, objArr110)).intValue() + 4;
                                                                            try {
                                                                                try {
                                                                                    Object[] objArr111 = new Object[2];
                                                                                    objArr111[i3] = Integer.valueOf(((Integer) String.class.getMethod("length", null).invoke(str2, null)).intValue() - 3);
                                                                                    objArr111[0] = Integer.valueOf(iIntValue2);
                                                                                    strCoroutineDebuggingKt = getDefaultImpl.CoroutineDebuggingKt(SoFileLoaderImpl.class, (String) String.class.getMethod(str4, Integer.TYPE, Integer.TYPE).invoke(str2, objArr111));
                                                                                    CoroutineDebuggingKt = strCoroutineDebuggingKt;
                                                                                    if (strCoroutineDebuggingKt == null) {
                                                                                        CoroutineDebuggingKt = str2;
                                                                                    }
                                                                                } catch (Throwable th12) {
                                                                                    Throwable cause12 = th12.getCause();
                                                                                    if (cause12 == null) {
                                                                                        throw th12;
                                                                                    }
                                                                                    throw cause12;
                                                                                }
                                                                            } catch (Throwable th13) {
                                                                                Throwable cause13 = th13.getCause();
                                                                                if (cause13 == null) {
                                                                                    throw th13;
                                                                                }
                                                                                throw cause13;
                                                                            }
                                                                        } catch (Throwable th14) {
                                                                            Throwable cause14 = th14.getCause();
                                                                            if (cause14 == null) {
                                                                                throw th14;
                                                                            }
                                                                            throw cause14;
                                                                        }
                                                                    } catch (Exception e) {
                                                                        e = e;
                                                                        exc = e;
                                                                        r12 = 0;
                                                                        i = 1;
                                                                        r10 = r12;
                                                                        r11 = i;
                                                                        if (i4 < length) {
                                                                            throw exc;
                                                                        }
                                                                        i4++;
                                                                        str2 = str;
                                                                        r2 = r10;
                                                                        i3 = r11;
                                                                    }
                                                                } catch (Exception e2) {
                                                                    e = e2;
                                                                }
                                                            } else {
                                                                CoroutineDebuggingKt = r14;
                                                            }
                                                            if (i4 < length) {
                                                                r15 = externalStorageDirectory;
                                                                CoroutineDebuggingKt = getDefaultImpl.CoroutineDebuggingKt(SoFileLoaderImpl.class, CoroutineDebuggingKt);
                                                            }
                                                            if (CoroutineDebuggingKt == 0) {
                                                                try {
                                                                    Object objInvoke6 = Runtime.class.getMethod(str5, null).invoke(null, null);
                                                                    r13 = r14;
                                                                    if (i4 >= length) {
                                                                        r13 = str2;
                                                                    }
                                                                    try {
                                                                        Object[] objArr112 = new Object[1];
                                                                        b(MotionEvent.axisFromString("") + 8538, new char[]{22844, 30822, 7043, 15679, 56440, 65412, 37156, 45133, 21497, 29955, 5203}, objArr112);
                                                                        Runtime.class.getMethod((String) objArr112[0], String.class).invoke(objInvoke6, r13);
                                                                        return;
                                                                    } catch (Throwable th15) {
                                                                        Throwable cause15 = th15.getCause();
                                                                        if (cause15 == null) {
                                                                            throw th15;
                                                                        }
                                                                        throw cause15;
                                                                    }
                                                                } catch (Throwable th16) {
                                                                    Throwable cause16 = th16.getCause();
                                                                    if (cause16 == null) {
                                                                        throw th16;
                                                                    }
                                                                    throw cause16;
                                                                }
                                                            }
                                                            try {
                                                                Object[] objArr113 = new Object[1];
                                                                try {
                                                                    objArr113[0] = 47;
                                                                    Class[] clsArr11 = new Class[1];
                                                                    try {
                                                                        clsArr11[0] = Integer.TYPE;
                                                                        try {
                                                                            try {
                                                                                Object[] objArr114 = new Object[1];
                                                                                try {
                                                                                    objArr114[0] = Integer.valueOf(((Integer) String.class.getMethod(str3, clsArr11).invoke(CoroutineDebuggingKt, objArr113)).intValue() + 1);
                                                                                    Class[] clsArr12 = new Class[1];
                                                                                    try {
                                                                                        clsArr12[0] = Integer.TYPE;
                                                                                        try {
                                                                                            try {
                                                                                                Object[] objArr115 = {r15, String.class.getMethod(str4, clsArr12).invoke(CoroutineDebuggingKt, objArr114)};
                                                                                                Class[] clsArr13 = new Class[2];
                                                                                                try {
                                                                                                    clsArr13[0] = File.class;
                                                                                                    try {
                                                                                                        clsArr13[1] = String.class;
                                                                                                        objNewInstance = File.class.getDeclaredConstructor(clsArr13).newInstance(objArr115);
                                                                                                        try {
                                                                                                            resource = SoFileLoaderImpl.class.getClassLoader().getResource(CoroutineDebuggingKt);
                                                                                                            if (resource == null) {
                                                                                                                try {
                                                                                                                    objArr = new Object[1];
                                                                                                                    b((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 48448, new char[]{22835, 58494, 9148, 28391, 44085, 60284, 14008, 30180}, objArr);
                                                                                                                    if (((Boolean) String.class.getMethod((String) objArr[0], CharSequence.class).invoke(CoroutineDebuggingKt, "!")).booleanValue()) {
                                                                                                                        ?? sb2 = new StringBuilder();
                                                                                                                        try {
                                                                                                                            Object[] objArr116 = new Object[1];
                                                                                                                            a(8 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), new char[]{14205, 32745, 60794, 39436, 19019, 15134, 26290, 5840, 12953, 32234}, objArr116);
                                                                                                                            sb2.append((String) objArr116[0]);
                                                                                                                            sb2.append(CoroutineDebuggingKt);
                                                                                                                            String path3 = new URL(sb2.toString()).getPath();
                                                                                                                            try {
                                                                                                                                try {
                                                                                                                                    ZipFile zipFile3 = new ZipFile((String) String.class.getMethod(str4, Integer.TYPE, Integer.TYPE).invoke(path3, 5, Integer.valueOf(((Integer) String.class.getMethod(str3, String.class).invoke(path3, "!/")).intValue())));
                                                                                                                                    try {
                                                                                                                                        try {
                                                                                                                                            try {
                                                                                                                                                inputStream = zipFile3.getInputStream(zipFile3.getEntry((String) String.class.getMethod(str4, Integer.TYPE).invoke(String.class.getMethod(str4, Integer.TYPE).invoke(CoroutineDebuggingKt, Integer.valueOf(((Integer) String.class.getMethod(str3, String.class).invoke(CoroutineDebuggingKt, "!/")).intValue())), 2)));
                                                                                                                                            } catch (Throwable th17) {
                                                                                                                                                Throwable cause17 = th17.getCause();
                                                                                                                                                if (cause17 == null) {
                                                                                                                                                    throw th17;
                                                                                                                                                }
                                                                                                                                                throw cause17;
                                                                                                                                            }
                                                                                                                                        } catch (Throwable th18) {
                                                                                                                                            Throwable cause18 = th18.getCause();
                                                                                                                                            if (cause18 == null) {
                                                                                                                                                throw th18;
                                                                                                                                            }
                                                                                                                                            throw cause18;
                                                                                                                                        }
                                                                                                                                    } catch (Throwable th19) {
                                                                                                                                        Throwable cause19 = th19.getCause();
                                                                                                                                        if (cause19 == null) {
                                                                                                                                            throw th19;
                                                                                                                                        }
                                                                                                                                        throw cause19;
                                                                                                                                    }
                                                                                                                                } catch (Throwable th20) {
                                                                                                                                    Throwable cause20 = th20.getCause();
                                                                                                                                    if (cause20 == null) {
                                                                                                                                        throw th20;
                                                                                                                                    }
                                                                                                                                    throw cause20;
                                                                                                                                }
                                                                                                                            } catch (Throwable th21) {
                                                                                                                                Throwable cause21 = th21.getCause();
                                                                                                                                if (cause21 == null) {
                                                                                                                                    throw th21;
                                                                                                                                }
                                                                                                                                throw cause21;
                                                                                                                            }
                                                                                                                        } catch (Exception e3) {
                                                                                                                            e = e3;
                                                                                                                            exc = e;
                                                                                                                            r12 = 0;
                                                                                                                            i = 1;
                                                                                                                            r10 = r12;
                                                                                                                            r11 = i;
                                                                                                                            if (i4 < length) {
                                                                                                                                throw exc;
                                                                                                                            }
                                                                                                                        }
                                                                                                                    } else {
                                                                                                                        try {
                                                                                                                            inputStream = (InputStream) FileInputStream.class.getDeclaredConstructor(String.class).newInstance(CoroutineDebuggingKt);
                                                                                                                        } catch (Throwable th22) {
                                                                                                                            Throwable cause22 = th22.getCause();
                                                                                                                            if (cause22 == null) {
                                                                                                                                throw th22;
                                                                                                                            }
                                                                                                                            throw cause22;
                                                                                                                        }
                                                                                                                    }
                                                                                                                } catch (Throwable th23) {
                                                                                                                    Throwable cause23 = th23.getCause();
                                                                                                                    if (cause23 == null) {
                                                                                                                        throw th23;
                                                                                                                    }
                                                                                                                    throw cause23;
                                                                                                                }
                                                                                                            } else {
                                                                                                                String path4 = resource.getPath();
                                                                                                                try {
                                                                                                                    Object[] objArr117 = {"!/" + CoroutineDebuggingKt};
                                                                                                                    try {
                                                                                                                        Class[] clsArr14 = new Class[1];
                                                                                                                        try {
                                                                                                                            clsArr14[0] = String.class;
                                                                                                                            try {
                                                                                                                                Object[] objArr118 = new Object[2];
                                                                                                                                try {
                                                                                                                                    objArr118[1] = Integer.valueOf(((Integer) String.class.getMethod(str3, clsArr14).invoke(path4, objArr117)).intValue());
                                                                                                                                    try {
                                                                                                                                        objArr118[0] = 5;
                                                                                                                                        Class[] clsArr15 = new Class[2];
                                                                                                                                        clsArr15[0] = Integer.TYPE;
                                                                                                                                        try {
                                                                                                                                            clsArr15[1] = Integer.TYPE;
                                                                                                                                            ?? zipFile4 = new ZipFile((String) String.class.getMethod(str4, clsArr15).invoke(path4, objArr118));
                                                                                                                                            inputStream = zipFile4.getInputStream(zipFile4.getEntry(CoroutineDebuggingKt));
                                                                                                                                        } catch (Throwable th24) {
                                                                                                                                            th = th24;
                                                                                                                                            th4 = th;
                                                                                                                                            cause4 = th4.getCause();
                                                                                                                                            if (cause4 != null) {
                                                                                                                                                throw th4;
                                                                                                                                            }
                                                                                                                                            throw cause4;
                                                                                                                                        }
                                                                                                                                    } catch (Throwable th25) {
                                                                                                                                        th = th25;
                                                                                                                                        th4 = th;
                                                                                                                                        cause4 = th4.getCause();
                                                                                                                                        if (cause4 != null) {
                                                                                                                                            throw th4;
                                                                                                                                        }
                                                                                                                                        throw cause4;
                                                                                                                                    }
                                                                                                                                } catch (Throwable th26) {
                                                                                                                                    th = th26;
                                                                                                                                }
                                                                                                                            } catch (Throwable th27) {
                                                                                                                                th = th27;
                                                                                                                            }
                                                                                                                        } catch (Throwable th28) {
                                                                                                                            th = th28;
                                                                                                                            th3 = th;
                                                                                                                            cause3 = th3.getCause();
                                                                                                                            if (cause3 != null) {
                                                                                                                                throw th3;
                                                                                                                            }
                                                                                                                            throw cause3;
                                                                                                                        }
                                                                                                                    } catch (Throwable th29) {
                                                                                                                        th = th29;
                                                                                                                        th3 = th;
                                                                                                                        cause3 = th3.getCause();
                                                                                                                        if (cause3 != null) {
                                                                                                                            throw th3;
                                                                                                                        }
                                                                                                                        throw cause3;
                                                                                                                    }
                                                                                                                } catch (Throwable th30) {
                                                                                                                    th = th30;
                                                                                                                }
                                                                                                            }
                                                                                                            bufferedInputStream = new BufferedInputStream(inputStream);
                                                                                                            try {
                                                                                                                Object[] objArr119 = {bufferedInputStream};
                                                                                                                objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-175194354);
                                                                                                                if (objAccessartificialFrame == null) {
                                                                                                                    try {
                                                                                                                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation('I' - AndroidCharacter.getMirror('0'), (char) View.MeasureSpec.makeMeasureSpec(0, 0), View.getDefaultSize(0, 0) + 49, 1793849606, false, "CoroutineDebuggingKt", new Class[]{InputStream.class});
                                                                                                                    } catch (Throwable th31) {
                                                                                                                        th5 = th31;
                                                                                                                        cause5 = th5.getCause();
                                                                                                                        if (cause5 != null) {
                                                                                                                            throw th5;
                                                                                                                        }
                                                                                                                        throw cause5;
                                                                                                                    }
                                                                                                                }
                                                                                                                try {
                                                                                                                    inputStream2 = (InputStream) ((Method) objAccessartificialFrame).invoke(null, objArr119);
                                                                                                                    if (bufferedInputStream == inputStream2) {
                                                                                                                        try {
                                                                                                                            inputStream2.close();
                                                                                                                            try {
                                                                                                                                try {
                                                                                                                                    Object objInvoke7 = Runtime.class.getMethod(str5, null).invoke(null, null);
                                                                                                                                    try {
                                                                                                                                        try {
                                                                                                                                            Object[] objArr210 = {CoroutineDebuggingKt, SoFileLoaderImpl.class.getClassLoader()};
                                                                                                                                            try {
                                                                                                                                                Object[] objArr211 = new Object[1];
                                                                                                                                                a(((byte) KeyEvent.getModifierMetaStateMask()) + 5, new char[]{45833, 40960, 7428, 22390}, objArr211);
                                                                                                                                                Method declaredMethod3 = Runtime.class.getDeclaredMethod((String) objArr211[0], String.class, ClassLoader.class);
                                                                                                                                                declaredMethod3.setAccessible(true);
                                                                                                                                                declaredMethod3.invoke(objInvoke7, objArr210);
                                                                                                                                            } catch (Throwable th32) {
                                                                                                                                                th = th32;
                                                                                                                                                Throwable th33 = th;
                                                                                                                                                Throwable cause24 = th33.getCause();
                                                                                                                                                if (cause24 == null) {
                                                                                                                                                    throw th33;
                                                                                                                                                }
                                                                                                                                                throw cause24;
                                                                                                                                            }
                                                                                                                                        } catch (Throwable th34) {
                                                                                                                                            th = th34;
                                                                                                                                        }
                                                                                                                                    } catch (Exception unused) {
                                                                                                                                        try {
                                                                                                                                            if (Build.VERSION.SDK_INT <= 27) {
                                                                                                                                                try {
                                                                                                                                                    Object objInvoke8 = Runtime.class.getMethod(str5, null).invoke(null, null);
                                                                                                                                                    try {
                                                                                                                                                        Object[] objArr33 = {CoroutineDebuggingKt, SoFileLoaderImpl.class.getClassLoader()};
                                                                                                                                                        Object[] objArr34 = new Object[1];
                                                                                                                                                        a(ImageFormat.getBitsPerPixel(0) + 7, new char[]{43056, 43849, 55342, 17876, 7428, 22390}, objArr34);
                                                                                                                                                        Method declaredMethod4 = Runtime.class.getDeclaredMethod((String) objArr34[0], String.class, ClassLoader.class);
                                                                                                                                                        declaredMethod4.setAccessible(true);
                                                                                                                                                        declaredMethod4.invoke(objInvoke8, objArr33);
                                                                                                                                                    } catch (Throwable th35) {
                                                                                                                                                        Throwable cause25 = th35.getCause();
                                                                                                                                                        if (cause25 == null) {
                                                                                                                                                            throw th35;
                                                                                                                                                        }
                                                                                                                                                        throw cause25;
                                                                                                                                                    }
                                                                                                                                                } catch (Throwable th36) {
                                                                                                                                                    Throwable cause26 = th36.getCause();
                                                                                                                                                    if (cause26 == null) {
                                                                                                                                                        throw th36;
                                                                                                                                                    }
                                                                                                                                                    throw cause26;
                                                                                                                                                }
                                                                                                                                            } else {
                                                                                                                                                try {
                                                                                                                                                    Object objInvoke9 = Runtime.class.getMethod(str5, null).invoke(null, null);
                                                                                                                                                    ClassLoader classLoader = SoFileLoaderImpl.class.getClassLoader();
                                                                                                                                                    synchronized (objInvoke9) {
                                                                                                                                                        try {
                                                                                                                                                            Object[] objArr35 = {CoroutineDebuggingKt, classLoader};
                                                                                                                                                            Object[] objArr36 = new Object[1];
                                                                                                                                                            a(11 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), new char[]{9623, 49016, 32722, 8534, 64954, 27567, 55342, 17876, 7428, 22390}, objArr36);
                                                                                                                                                            Method declaredMethod5 = Runtime.class.getDeclaredMethod((String) objArr36[0], String.class, ClassLoader.class);
                                                                                                                                                            declaredMethod5.setAccessible(true);
                                                                                                                                                            String str7 = (String) declaredMethod5.invoke(objInvoke9, objArr35);
                                                                                                                                                            if (str7 != null) {
                                                                                                                                                                throw new UnsatisfiedLinkError(str7);
                                                                                                                                                            }
                                                                                                                                                        } catch (Throwable th37) {
                                                                                                                                                            Throwable cause27 = th37.getCause();
                                                                                                                                                            if (cause27 == null) {
                                                                                                                                                                throw th37;
                                                                                                                                                            }
                                                                                                                                                            throw cause27;
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                } catch (Throwable th38) {
                                                                                                                                                    Throwable cause28 = th38.getCause();
                                                                                                                                                    if (cause28 == null) {
                                                                                                                                                        throw th38;
                                                                                                                                                    }
                                                                                                                                                    throw cause28;
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        } catch (NoSuchMethodException unused2) {
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                } catch (Throwable th39) {
                                                                                                                                    Throwable cause29 = th39.getCause();
                                                                                                                                    if (cause29 == null) {
                                                                                                                                        throw th39;
                                                                                                                                    }
                                                                                                                                    throw cause29;
                                                                                                                                }
                                                                                                                            } catch (Exception unused3) {
                                                                                                                            }
                                                                                                                            r10 = 0;
                                                                                                                            r11 = 1;
                                                                                                                        } catch (Exception e4) {
                                                                                                                            e = e4;
                                                                                                                            exc = e;
                                                                                                                            r12 = 0;
                                                                                                                            i = 1;
                                                                                                                            r10 = r12;
                                                                                                                            r11 = i;
                                                                                                                            if (i4 < length) {
                                                                                                                                throw exc;
                                                                                                                            }
                                                                                                                        }
                                                                                                                    } else {
                                                                                                                        try {
                                                                                                                            Object[] objArr212 = {objNewInstance};
                                                                                                                            try {
                                                                                                                                Class[] clsArr16 = new Class[1];
                                                                                                                                try {
                                                                                                                                    clsArr16[0] = File.class;
                                                                                                                                    OutputStream outputStream2 = (OutputStream) FileOutputStream.class.getDeclaredConstructor(clsArr16).newInstance(objArr212);
                                                                                                                                    bufferedOutputStream = new BufferedOutputStream(outputStream2);
                                                                                                                                    bArr = new byte[1024];
                                                                                                                                    while (true) {
                                                                                                                                        i2 = inputStream2.read(bArr);
                                                                                                                                        if (i2 >= 0) {
                                                                                                                                            break;
                                                                                                                                        } else {
                                                                                                                                            bufferedOutputStream.write(bArr, 0, i2);
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                    bufferedOutputStream.flush();
                                                                                                                                    try {
                                                                                                                                        try {
                                                                                                                                            Object[] objArr213 = new Object[1];
                                                                                                                                            a(TextUtils.lastIndexOf("", '0') + 6, new char[]{64197, 52566, 3923, 20496, 61602, 59337}, objArr213);
                                                                                                                                            try {
                                                                                                                                                try {
                                                                                                                                                    Object objInvoke10 = FileOutputStream.class.getMethod((String) objArr213[0], null).invoke(outputStream2, null);
                                                                                                                                                    try {
                                                                                                                                                        try {
                                                                                                                                                            try {
                                                                                                                                                                Object[] objArr214 = new Object[1];
                                                                                                                                                                b(KeyEvent.getDeadChar(0, 0) + 38393, new char[]{22819, 52432, 29388, 39128}, objArr214);
                                                                                                                                                                try {
                                                                                                                                                                    try {
                                                                                                                                                                        FileDescriptor.class.getMethod((String) objArr214[0], null).invoke(objInvoke10, null);
                                                                                                                                                                        try {
                                                                                                                                                                            bufferedOutputStream.close();
                                                                                                                                                                            inputStream2.close();
                                                                                                                                                                            try {
                                                                                                                                                                                Object objInvoke11 = Runtime.class.getMethod(str5, null).invoke(null, null);
                                                                                                                                                                                try {
                                                                                                                                                                                    try {
                                                                                                                                                                                        Object[] objArr215 = new Object[1];
                                                                                                                                                                                        a(15 - (ViewConfiguration.getPressedStateDuration() >> 16), new char[]{64197, 52566, 61446, 59135, 18966, 11697, 53056, 48663, 35220, 42543, 4772, 59884, 36375, 41973, 34824, 18695}, objArr215);
                                                                                                                                                                                        try {
                                                                                                                                                                                            try {
                                                                                                                                                                                                Object[] objArr216 = {File.class.getMethod((String) objArr215[0], null).invoke(objNewInstance, null), SoFileLoaderImpl.class.getClassLoader()};
                                                                                                                                                                                                try {
                                                                                                                                                                                                    Object[] objArr217 = new Object[1];
                                                                                                                                                                                                    a(4 - ((Process.getThreadPriority(0) + 20) >> 6), new char[]{45833, 40960, 7428, 22390}, objArr217);
                                                                                                                                                                                                    Method declaredMethod6 = Runtime.class.getDeclaredMethod((String) objArr217[0], String.class, ClassLoader.class);
                                                                                                                                                                                                    declaredMethod6.setAccessible(true);
                                                                                                                                                                                                    declaredMethod6.invoke(objInvoke11, objArr216);
                                                                                                                                                                                                } catch (Throwable th40) {
                                                                                                                                                                                                    th = th40;
                                                                                                                                                                                                    Throwable th41 = th;
                                                                                                                                                                                                    Throwable cause30 = th41.getCause();
                                                                                                                                                                                                    if (cause30 == null) {
                                                                                                                                                                                                        throw th41;
                                                                                                                                                                                                    }
                                                                                                                                                                                                    throw cause30;
                                                                                                                                                                                                }
                                                                                                                                                                                            } catch (Throwable th42) {
                                                                                                                                                                                                th = th42;
                                                                                                                                                                                            }
                                                                                                                                                                                        } catch (Exception unused4) {
                                                                                                                                                                                            try {
                                                                                                                                                                                                if (Build.VERSION.SDK_INT <= 27) {
                                                                                                                                                                                                    try {
                                                                                                                                                                                                        Object objInvoke12 = Runtime.class.getMethod(str5, null).invoke(null, null);
                                                                                                                                                                                                        try {
                                                                                                                                                                                                            Object[] objArr37 = new Object[1];
                                                                                                                                                                                                            a(15 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), new char[]{64197, 52566, 61446, 59135, 18966, 11697, 53056, 48663, 35220, 42543, 4772, 59884, 36375, 41973, 34824, 18695}, objArr37);
                                                                                                                                                                                                            try {
                                                                                                                                                                                                                Object[] objArr38 = {File.class.getMethod((String) objArr37[0], null).invoke(objNewInstance, null), SoFileLoaderImpl.class.getClassLoader()};
                                                                                                                                                                                                                Object[] objArr39 = new Object[1];
                                                                                                                                                                                                                a((ViewConfiguration.getJumpTapTimeout() >> 16) + 6, new char[]{43056, 43849, 55342, 17876, 7428, 22390}, objArr39);
                                                                                                                                                                                                                Method declaredMethod7 = Runtime.class.getDeclaredMethod((String) objArr39[0], String.class, ClassLoader.class);
                                                                                                                                                                                                                declaredMethod7.setAccessible(true);
                                                                                                                                                                                                                declaredMethod7.invoke(objInvoke12, objArr38);
                                                                                                                                                                                                            } catch (Throwable th43) {
                                                                                                                                                                                                                Throwable cause31 = th43.getCause();
                                                                                                                                                                                                                if (cause31 == null) {
                                                                                                                                                                                                                    throw th43;
                                                                                                                                                                                                                }
                                                                                                                                                                                                                throw cause31;
                                                                                                                                                                                                            }
                                                                                                                                                                                                        } catch (Throwable th44) {
                                                                                                                                                                                                            Throwable cause32 = th44.getCause();
                                                                                                                                                                                                            if (cause32 == null) {
                                                                                                                                                                                                                throw th44;
                                                                                                                                                                                                            }
                                                                                                                                                                                                            throw cause32;
                                                                                                                                                                                                        }
                                                                                                                                                                                                    } catch (Throwable th45) {
                                                                                                                                                                                                        Throwable cause33 = th45.getCause();
                                                                                                                                                                                                        if (cause33 == null) {
                                                                                                                                                                                                            throw th45;
                                                                                                                                                                                                        }
                                                                                                                                                                                                        throw cause33;
                                                                                                                                                                                                    }
                                                                                                                                                                                                } else {
                                                                                                                                                                                                    try {
                                                                                                                                                                                                        Object objInvoke13 = Runtime.class.getMethod(str5, null).invoke(null, null);
                                                                                                                                                                                                        try {
                                                                                                                                                                                                            try {
                                                                                                                                                                                                                Object[] objArr40 = new Object[1];
                                                                                                                                                                                                                a((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 14, new char[]{64197, 52566, 61446, 59135, 18966, 11697, 53056, 48663, 35220, 42543, 4772, 59884, 36375, 41973, 34824, 18695}, objArr40);
                                                                                                                                                                                                                try {
                                                                                                                                                                                                                    try {
                                                                                                                                                                                                                        Object objInvoke14 = File.class.getMethod((String) objArr40[0], null).invoke(objNewInstance, null);
                                                                                                                                                                                                                        ClassLoader classLoader2 = SoFileLoaderImpl.class.getClassLoader();
                                                                                                                                                                                                                        try {
                                                                                                                                                                                                                            synchronized (objInvoke13) {
                                                                                                                                                                                                                                try {
                                                                                                                                                                                                                                    Object[] objArr41 = {objInvoke14, classLoader2};
                                                                                                                                                                                                                                    try {
                                                                                                                                                                                                                                        try {
                                                                                                                                                                                                                                            try {
                                                                                                                                                                                                                                                Object[] objArr42 = new Object[1];
                                                                                                                                                                                                                                                a(TextUtils.getOffsetBefore("", 0) + 10, new char[]{9623, 49016, 32722, 8534, 64954, 27567, 55342, 17876, 7428, 22390}, objArr42);
                                                                                                                                                                                                                                                try {
                                                                                                                                                                                                                                                    String str8 = (String) objArr42[0];
                                                                                                                                                                                                                                                    Class[] clsArr17 = new Class[2];
                                                                                                                                                                                                                                                    clsArr17[0] = String.class;
                                                                                                                                                                                                                                                    try {
                                                                                                                                                                                                                                                        clsArr17[1] = ClassLoader.class;
                                                                                                                                                                                                                                                        Method declaredMethod8 = Runtime.class.getDeclaredMethod(str8, clsArr17);
                                                                                                                                                                                                                                                        declaredMethod8.setAccessible(true);
                                                                                                                                                                                                                                                        String str9 = (String) declaredMethod8.invoke(objInvoke13, objArr41);
                                                                                                                                                                                                                                                        if (str9 != null) {
                                                                                                                                                                                                                                                            throw new UnsatisfiedLinkError(str9);
                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                        try {
                                                                                                                                                                                                                                                        } catch (Throwable th46) {
                                                                                                                                                                                                                                                            th = th46;
                                                                                                                                                                                                                                                            throw th;
                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                    } catch (Throwable th47) {
                                                                                                                                                                                                                                                        th = th47;
                                                                                                                                                                                                                                                        th10 = th;
                                                                                                                                                                                                                                                        cause10 = th10.getCause();
                                                                                                                                                                                                                                                        if (cause10 == null) {
                                                                                                                                                                                                                                                            throw th10;
                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                        throw cause10;
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                } catch (Throwable th48) {
                                                                                                                                                                                                                                                    th = th48;
                                                                                                                                                                                                                                                    th10 = th;
                                                                                                                                                                                                                                                    cause10 = th10.getCause();
                                                                                                                                                                                                                                                    if (cause10 == null) {
                                                                                                                                                                                                                                                        throw th10;
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                    throw cause10;
                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                            } catch (Throwable th49) {
                                                                                                                                                                                                                                                th = th49;
                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                        } catch (Throwable th50) {
                                                                                                                                                                                                                                            th = th50;
                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                    } catch (Throwable th51) {
                                                                                                                                                                                                                                        th = th51;
                                                                                                                                                                                                                                        th10 = th;
                                                                                                                                                                                                                                        cause10 = th10.getCause();
                                                                                                                                                                                                                                        if (cause10 == null) {
                                                                                                                                                                                                                                            throw th10;
                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                        throw cause10;
                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                } catch (Throwable th52) {
                                                                                                                                                                                                                                    th = th52;
                                                                                                                                                                                                                                }
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                        } catch (Throwable th53) {
                                                                                                                                                                                                                            th = th53;
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                    } catch (Throwable th54) {
                                                                                                                                                                                                                        th = th54;
                                                                                                                                                                                                                        th9 = th;
                                                                                                                                                                                                                        cause9 = th9.getCause();
                                                                                                                                                                                                                        if (cause9 == null) {
                                                                                                                                                                                                                            throw th9;
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                        throw cause9;
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                } catch (Throwable th55) {
                                                                                                                                                                                                                    th = th55;
                                                                                                                                                                                                                    th9 = th;
                                                                                                                                                                                                                    cause9 = th9.getCause();
                                                                                                                                                                                                                    if (cause9 == null) {
                                                                                                                                                                                                                        throw th9;
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                    throw cause9;
                                                                                                                                                                                                                }
                                                                                                                                                                                                            } catch (Throwable th56) {
                                                                                                                                                                                                                th = th56;
                                                                                                                                                                                                                th9 = th;
                                                                                                                                                                                                                cause9 = th9.getCause();
                                                                                                                                                                                                                if (cause9 == null) {
                                                                                                                                                                                                                    throw th9;
                                                                                                                                                                                                                }
                                                                                                                                                                                                                throw cause9;
                                                                                                                                                                                                            }
                                                                                                                                                                                                        } catch (Throwable th57) {
                                                                                                                                                                                                            th = th57;
                                                                                                                                                                                                        }
                                                                                                                                                                                                    } catch (Throwable th58) {
                                                                                                                                                                                                        Throwable cause34 = th58.getCause();
                                                                                                                                                                                                        if (cause34 == null) {
                                                                                                                                                                                                            throw th58;
                                                                                                                                                                                                        }
                                                                                                                                                                                                        throw cause34;
                                                                                                                                                                                                    }
                                                                                                                                                                                                }
                                                                                                                                                                                            } catch (NoSuchMethodException unused5) {
                                                                                                                                                                                            }
                                                                                                                                                                                            try {
                                                                                                                                                                                                r11 = 1;
                                                                                                                                                                                                r11 = 1;
                                                                                                                                                                                                r11 = 1;
                                                                                                                                                                                                r11 = 1;
                                                                                                                                                                                                try {
                                                                                                                                                                                                    Object[] objArr218 = new Object[1];
                                                                                                                                                                                                    b(49409 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), new char[]{22836, 38964, 56126, 6710, 23840, 39984}, objArr218);
                                                                                                                                                                                                    r10 = 0;
                                                                                                                                                                                                    r10 = 0;
                                                                                                                                                                                                    r10 = 0;
                                                                                                                                                                                                    try {
                                                                                                                                                                                                        try {
                                                                                                                                                                                                            ((Boolean) File.class.getMethod((String) objArr218[0], null).invoke(objNewInstance, null)).booleanValue();
                                                                                                                                                                                                            i4++;
                                                                                                                                                                                                            str2 = str;
                                                                                                                                                                                                            r2 = r10;
                                                                                                                                                                                                            i3 = r11;
                                                                                                                                                                                                        } catch (Throwable th59) {
                                                                                                                                                                                                            th = th59;
                                                                                                                                                                                                            th11 = th;
                                                                                                                                                                                                            try {
                                                                                                                                                                                                                cause11 = th11.getCause();
                                                                                                                                                                                                                if (cause11 != null) {
                                                                                                                                                                                                                    throw th11;
                                                                                                                                                                                                                }
                                                                                                                                                                                                                throw cause11;
                                                                                                                                                                                                            } catch (Exception unused6) {
                                                                                                                                                                                                            }
                                                                                                                                                                                                        }
                                                                                                                                                                                                    } catch (Throwable th60) {
                                                                                                                                                                                                        th = th60;
                                                                                                                                                                                                        th11 = th;
                                                                                                                                                                                                        cause11 = th11.getCause();
                                                                                                                                                                                                        if (cause11 != null) {
                                                                                                                                                                                                            throw th11;
                                                                                                                                                                                                        }
                                                                                                                                                                                                        throw cause11;
                                                                                                                                                                                                    }
                                                                                                                                                                                                } catch (Throwable th61) {
                                                                                                                                                                                                    th = th61;
                                                                                                                                                                                                    r10 = 0;
                                                                                                                                                                                                }
                                                                                                                                                                                            } catch (Throwable th62) {
                                                                                                                                                                                                th = th62;
                                                                                                                                                                                                r10 = 0;
                                                                                                                                                                                                r11 = 1;
                                                                                                                                                                                            }
                                                                                                                                                                                        }
                                                                                                                                                                                    } catch (Throwable th63) {
                                                                                                                                                                                        Throwable cause35 = th63.getCause();
                                                                                                                                                                                        if (cause35 == null) {
                                                                                                                                                                                            throw th63;
                                                                                                                                                                                        }
                                                                                                                                                                                        throw cause35;
                                                                                                                                                                                    }
                                                                                                                                                                                } catch (Exception unused7) {
                                                                                                                                                                                }
                                                                                                                                                                                try {
                                                                                                                                                                                    r11 = 1;
                                                                                                                                                                                    r11 = 1;
                                                                                                                                                                                    r11 = 1;
                                                                                                                                                                                    r11 = 1;
                                                                                                                                                                                    Object[] objArr219 = new Object[1];
                                                                                                                                                                                    b(49409 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), new char[]{22836, 38964, 56126, 6710, 23840, 39984}, objArr219);
                                                                                                                                                                                    r10 = 0;
                                                                                                                                                                                    r10 = 0;
                                                                                                                                                                                    r10 = 0;
                                                                                                                                                                                    ((Boolean) File.class.getMethod((String) objArr219[0], null).invoke(objNewInstance, null)).booleanValue();
                                                                                                                                                                                } catch (Throwable th64) {
                                                                                                                                                                                    th = th64;
                                                                                                                                                                                    r10 = 0;
                                                                                                                                                                                    r11 = 1;
                                                                                                                                                                                }
                                                                                                                                                                            } catch (Throwable th65) {
                                                                                                                                                                                Throwable cause36 = th65.getCause();
                                                                                                                                                                                if (cause36 == null) {
                                                                                                                                                                                    throw th65;
                                                                                                                                                                                }
                                                                                                                                                                                throw cause36;
                                                                                                                                                                            }
                                                                                                                                                                        } catch (Exception e5) {
                                                                                                                                                                            e = e5;
                                                                                                                                                                            r14 = 0;
                                                                                                                                                                            NewInstance = 1;
                                                                                                                                                                            exc = e;
                                                                                                                                                                            r10 = r14;
                                                                                                                                                                            r11 = NewInstance;
                                                                                                                                                                            if (i4 < length) {
                                                                                                                                                                                throw exc;
                                                                                                                                                                            }
                                                                                                                                                                        }
                                                                                                                                                                    } catch (Throwable th66) {
                                                                                                                                                                        th = th66;
                                                                                                                                                                        th8 = th;
                                                                                                                                                                        cause8 = th8.getCause();
                                                                                                                                                                        if (cause8 == null) {
                                                                                                                                                                            throw th8;
                                                                                                                                                                        }
                                                                                                                                                                        throw cause8;
                                                                                                                                                                    }
                                                                                                                                                                } catch (Throwable th67) {
                                                                                                                                                                    th = th67;
                                                                                                                                                                    th8 = th;
                                                                                                                                                                    cause8 = th8.getCause();
                                                                                                                                                                    if (cause8 == null) {
                                                                                                                                                                        throw th8;
                                                                                                                                                                    }
                                                                                                                                                                    throw cause8;
                                                                                                                                                                }
                                                                                                                                                            } catch (Throwable th68) {
                                                                                                                                                                th = th68;
                                                                                                                                                                th8 = th;
                                                                                                                                                                cause8 = th8.getCause();
                                                                                                                                                                if (cause8 == null) {
                                                                                                                                                                    throw th8;
                                                                                                                                                                }
                                                                                                                                                                throw cause8;
                                                                                                                                                            }
                                                                                                                                                        } catch (Throwable th69) {
                                                                                                                                                            th = th69;
                                                                                                                                                        }
                                                                                                                                                    } catch (Throwable th70) {
                                                                                                                                                        th = th70;
                                                                                                                                                    }
                                                                                                                                                } catch (Throwable th71) {
                                                                                                                                                    th = th71;
                                                                                                                                                    th7 = th;
                                                                                                                                                    cause7 = th7.getCause();
                                                                                                                                                    if (cause7 == null) {
                                                                                                                                                        throw th7;
                                                                                                                                                    }
                                                                                                                                                    throw cause7;
                                                                                                                                                }
                                                                                                                                            } catch (Throwable th72) {
                                                                                                                                                th = th72;
                                                                                                                                                th7 = th;
                                                                                                                                                cause7 = th7.getCause();
                                                                                                                                                if (cause7 == null) {
                                                                                                                                                    throw th7;
                                                                                                                                                }
                                                                                                                                                throw cause7;
                                                                                                                                            }
                                                                                                                                        } catch (Throwable th73) {
                                                                                                                                            th = th73;
                                                                                                                                            th7 = th;
                                                                                                                                            cause7 = th7.getCause();
                                                                                                                                            if (cause7 == null) {
                                                                                                                                                throw th7;
                                                                                                                                            }
                                                                                                                                            throw cause7;
                                                                                                                                        }
                                                                                                                                    } catch (Throwable th74) {
                                                                                                                                        th = th74;
                                                                                                                                    }
                                                                                                                                } catch (Throwable th75) {
                                                                                                                                    th = th75;
                                                                                                                                    th6 = th;
                                                                                                                                    cause6 = th6.getCause();
                                                                                                                                    if (cause6 != null) {
                                                                                                                                        throw th6;
                                                                                                                                    }
                                                                                                                                    throw cause6;
                                                                                                                                }
                                                                                                                            } catch (Throwable th76) {
                                                                                                                                th = th76;
                                                                                                                                th6 = th;
                                                                                                                                cause6 = th6.getCause();
                                                                                                                                if (cause6 != null) {
                                                                                                                                    throw th6;
                                                                                                                                }
                                                                                                                                throw cause6;
                                                                                                                            }
                                                                                                                        } catch (Throwable th77) {
                                                                                                                            th = th77;
                                                                                                                        }
                                                                                                                    }
                                                                                                                } catch (Throwable th78) {
                                                                                                                    th = th78;
                                                                                                                    th5 = th;
                                                                                                                    cause5 = th5.getCause();
                                                                                                                    if (cause5 != null) {
                                                                                                                        throw th5;
                                                                                                                    }
                                                                                                                    throw cause5;
                                                                                                                }
                                                                                                            } catch (Throwable th79) {
                                                                                                                th = th79;
                                                                                                            }
                                                                                                        } catch (Exception e6) {
                                                                                                            e = e6;
                                                                                                            r14 = 0;
                                                                                                            NewInstance = 1;
                                                                                                            exc = e;
                                                                                                            r10 = r14;
                                                                                                            r11 = NewInstance;
                                                                                                            if (i4 < length) {
                                                                                                                throw exc;
                                                                                                            }
                                                                                                        }
                                                                                                    } catch (Throwable th80) {
                                                                                                        th = th80;
                                                                                                        th2 = th;
                                                                                                        cause2 = th2.getCause();
                                                                                                        if (cause2 != null) {
                                                                                                            throw th2;
                                                                                                        }
                                                                                                        throw cause2;
                                                                                                    }
                                                                                                } catch (Throwable th81) {
                                                                                                    th = th81;
                                                                                                    th2 = th;
                                                                                                    cause2 = th2.getCause();
                                                                                                    if (cause2 != null) {
                                                                                                        throw th2;
                                                                                                    }
                                                                                                    throw cause2;
                                                                                                }
                                                                                            } catch (Throwable th82) {
                                                                                                th = th82;
                                                                                            }
                                                                                        } catch (Throwable th83) {
                                                                                            th = th83;
                                                                                            Throwable th84 = th;
                                                                                            Throwable cause37 = th84.getCause();
                                                                                            if (cause37 == null) {
                                                                                                throw th84;
                                                                                            }
                                                                                            throw cause37;
                                                                                        }
                                                                                    } catch (Throwable th85) {
                                                                                        th = th85;
                                                                                    }
                                                                                } catch (Throwable th86) {
                                                                                    th = th86;
                                                                                }
                                                                            } catch (Throwable th87) {
                                                                                th = th87;
                                                                            }
                                                                        } catch (Throwable th88) {
                                                                            th = th88;
                                                                            Throwable th89 = th;
                                                                            Throwable cause38 = th89.getCause();
                                                                            if (cause38 == null) {
                                                                                throw th89;
                                                                            }
                                                                            throw cause38;
                                                                        }
                                                                    } catch (Throwable th90) {
                                                                        th = th90;
                                                                    }
                                                                } catch (Throwable th91) {
                                                                    th = th91;
                                                                }
                                                            } catch (Throwable th92) {
                                                                th = th92;
                                                            }
                                                            e = e2;
                                                            exc = e;
                                                            r12 = 0;
                                                            i = 1;
                                                        } catch (Throwable th93) {
                                                            Throwable cause39 = th93.getCause();
                                                            if (cause39 == null) {
                                                                throw th93;
                                                            }
                                                            throw cause39;
                                                        }
                                                    } catch (Throwable th94) {
                                                        Throwable cause40 = th94.getCause();
                                                        if (cause40 == null) {
                                                            throw th94;
                                                        }
                                                        throw cause40;
                                                    }
                                                } catch (Exception e7) {
                                                    r11 = i3;
                                                    exc = e7;
                                                    r10 = r2;
                                                    if (i4 < length) {
                                                        throw exc;
                                                    }
                                                }
                                            } catch (Exception e8) {
                                                exc = e8;
                                                r12 = r2;
                                                i = i3;
                                            }
                                            r10 = r12;
                                            r11 = i;
                                            if (i4 < length) {
                                                throw exc;
                                            }
                                        }
                                    } catch (Throwable th95) {
                                        th = th95;
                                        th = th;
                                        cause = th.getCause();
                                        if (cause != null) {
                                            throw th;
                                        }
                                        throw cause;
                                    }
                                } catch (Throwable th96) {
                                    th = th96;
                                    th = th;
                                    cause = th.getCause();
                                    if (cause != null) {
                                        throw th;
                                    }
                                    throw cause;
                                }
                            } catch (Throwable th97) {
                                th = th97;
                            }
                        } catch (Throwable th98) {
                            Throwable cause41 = th98.getCause();
                            if (cause41 == null) {
                                throw th98;
                            }
                            throw cause41;
                        }
                    } catch (Exception e9) {
                        e = e9;
                    }
                } catch (Exception e10) {
                    e = e10;
                    r14 = r2;
                    NewInstance = i3;
                }
                i4++;
                str2 = str;
                r2 = r10;
                i3 = r11;
            }
        } catch (Throwable th99) {
            Throwable cause42 = th99.getCause();
            if (cause42 == null) {
                throw th99;
            }
            throw cause42;
        }
    }
}
