package com.facebook.soloader;

import android.content.res.AssetManager;
import android.graphics.Color;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.os.StrictMode;
import android.os.SystemClock;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.salesforce.marketingcloud.analytics.stats.b;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;
import java.util.zip.ZipFile;
import javax.annotation.Nullable;
import o.ArtificialStackFrames;
import o.artificialFrame;
import o.asInterface;
import o.getDefaultImpl;
import o.onMessageChannelReady;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes.dex */
public class DirectSplitSoSource extends SoSource {
    private static int artificialFrame = 1;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME;
    protected final String mSplitName;
    private static char[] validateRelationship = {56177, 56132, 56135, 55988, 55986, 55995, 56178, 55984, 55996, 55979, 55989, 55990, 55978, 55999, 56133, 55985, 56137, 55998, 55987, 56156, 56134, 55983};
    private static int warmup = -1044260064;
    private static boolean requestPostMessageChannelWithExtras = true;
    private static boolean ICustomTabsServiceDefault = true;
    private static int[] ICustomTabsCallbackStub = {1384685357, -91631543, 1204503532, -360088967, -698682881, -823384590, -1996489822, -1464384661, 854115040, 2113820672, 421462913, -1299312136, 564914375, 485670247, 148341195, 563485366, 1487881181, -304748633};

    @Nullable
    protected Manifest mManifest = null;

    @Nullable
    protected Set<String> mLibs = null;

    public DirectSplitSoSource(String str) {
        this.mSplitName = str;
    }

    Manifest getManifest() {
        Manifest manifest = this.mManifest;
        if (manifest != null) {
            return manifest;
        }
        throw new IllegalStateException("prepare not called");
    }

    @Override // com.facebook.soloader.SoSource
    protected void prepare(int i) throws Throwable {
        int i2 = 2 % 2;
        try {
            Object[] objArr = {SoLoader.sApplicationContext.getAssets(), this.mSplitName + ".soloader-manifest"};
            Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-982065286);
            if (objAccessartificialFrame == null) {
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(12 - (KeyEvent.getMaxKeyCode() >> 16), (char) (7115 - MotionEvent.axisFromString("")), ExpandableListView.getPackedPositionGroup(0L) + 37, 1511233906, false, "accessartificialFrame", new Class[]{AssetManager.class, String.class});
            }
            InputStream inputStream = (InputStream) ((Method) objAccessartificialFrame).invoke(null, objArr);
            try {
                this.mManifest = Manifest.read(inputStream);
                if (inputStream != null) {
                    int i3 = artificialFrame + b.f40o;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i3 % 128;
                    if (i3 % 2 == 0) {
                        inputStream.close();
                    } else {
                        throw null;
                    }
                }
                this.mLibs = new HashSet(this.mManifest.libs);
                int i4 = getARTIFICIAL_FRAME_PACKAGE_NAME + 73;
                artificialFrame = i4 % 128;
                if (i4 % 2 == 0) {
                    int i5 = 82 / 0;
                }
            } finally {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable th) {
                        th.addSuppressed(th);
                    }
                }
            }
        } catch (Throwable th2) {
            Throwable cause = th2.getCause();
            if (cause == null) {
                throw th2;
            }
            throw cause;
        }
    }

    @Override // com.facebook.soloader.SoSource
    public int loadLibrary(String str, int i, StrictMode.ThreadPolicy threadPolicy) {
        Set<String> set = this.mLibs;
        if (set == null) {
            throw new IllegalStateException("prepare not called");
        }
        if (set.contains(str)) {
            return loadLibraryImpl(str, i);
        }
        return 0;
    }

    protected int loadLibraryImpl(String str, int i) throws Exception {
        String libraryPath = getLibraryPath(str);
        libraryPath.getClass();
        coroutineCreation(libraryPath);
        return 1;
    }

    @Override // com.facebook.soloader.SoSource
    @Nullable
    public File unpackLibrary(String str) {
        return getSoFileByName(str);
    }

    @Override // com.facebook.soloader.SoSource
    @Nullable
    protected File getSoFileByName(String str) {
        String libraryPath = getLibraryPath(str);
        if (libraryPath == null) {
            return null;
        }
        return new File(libraryPath);
    }

    private static void a(int i, int[] iArr, Object[] objArr) {
        artificialFrame artificialframe = new artificialFrame();
        char[] cArr = new char[4];
        char[] cArr2 = new char[iArr.length * 2];
        int[] iArr2 = ICustomTabsCallbackStub;
        if (iArr2 != null) {
            int length = iArr2.length;
            int[] iArr3 = new int[length];
            for (int i2 = 0; i2 < length; i2++) {
                iArr3[i2] = (int) (((long) iArr2[i2]) ^ 8786114107090493297L);
            }
            iArr2 = iArr3;
        }
        int length2 = iArr2.length;
        int[] iArr4 = new int[length2];
        int[] iArr5 = ICustomTabsCallbackStub;
        if (iArr5 != null) {
            int length3 = iArr5.length;
            int[] iArr6 = new int[length3];
            for (int i3 = 0; i3 < length3; i3++) {
                iArr6[i3] = (int) (((long) iArr5[i3]) ^ 8786114107090493297L);
            }
            iArr5 = iArr6;
        }
        System.arraycopy(iArr5, 0, iArr4, 0, length2);
        artificialframe.e = 0;
        while (artificialframe.e < iArr.length) {
            cArr[0] = (char) (iArr[artificialframe.e] >> 16);
            cArr[1] = (char) iArr[artificialframe.e];
            cArr[2] = (char) (iArr[artificialframe.e + 1] >> 16);
            cArr[3] = (char) iArr[artificialframe.e + 1];
            artificialframe.c = (cArr[0] << 16) + cArr[1];
            artificialframe.b = (cArr[2] << 16) + cArr[3];
            artificialFrame.coroutineBoundary(iArr4);
            for (int i4 = 0; i4 < 16; i4++) {
                artificialframe.c ^= iArr4[i4];
                artificialframe.b = artificialFrame.coroutineBoundary(artificialframe.c) ^ artificialframe.b;
                int i5 = artificialframe.c;
                artificialframe.c = artificialframe.b;
                artificialframe.b = i5;
            }
            int i6 = artificialframe.c;
            artificialframe.c = artificialframe.b;
            artificialframe.b = i6;
            artificialframe.b ^= iArr4[16];
            artificialframe.c ^= iArr4[17];
            int i7 = artificialframe.c;
            int i8 = artificialframe.b;
            cArr[0] = (char) (artificialframe.c >>> 16);
            cArr[1] = (char) artificialframe.c;
            cArr[2] = (char) (artificialframe.b >>> 16);
            cArr[3] = (char) artificialframe.b;
            artificialFrame.coroutineBoundary(iArr4);
            cArr2[artificialframe.e * 2] = cArr[0];
            cArr2[(artificialframe.e * 2) + 1] = cArr[1];
            cArr2[(artificialframe.e * 2) + 2] = cArr[2];
            cArr2[(artificialframe.e * 2) + 3] = cArr[3];
            artificialframe.e += 2;
        }
        objArr[0] = new String(cArr2, 0, i);
    }

    @Override // com.facebook.soloader.SoSource
    @Nullable
    public String getLibraryPath(String str) {
        Set<String> set = this.mLibs;
        if (set == null || this.mManifest == null) {
            throw new IllegalStateException("prepare not called");
        }
        if (!set.contains(str)) {
            return null;
        }
        return getSplitPath(this.mSplitName) + "!/lib/" + this.mManifest.arch + RemoteSettings.FORWARD_SLASH_STRING + str;
    }

    static String getSplitPath(String str) {
        if ("base".equals(str)) {
            return SoLoader.sApplicationContext.getApplicationInfo().sourceDir;
        }
        String[] strArr = SoLoader.sApplicationContext.getApplicationInfo().splitSourceDirs;
        if (strArr == null) {
            throw new IllegalStateException("No splits avaiable");
        }
        String str2 = "split_" + str + ".apk";
        for (String str3 : strArr) {
            if (str3.endsWith(str2)) {
                return str3;
            }
        }
        throw new IllegalStateException("Could not find " + str + " split");
    }

    private static void b(char[] cArr, byte[] bArr, int i, int[] iArr, Object[] objArr) {
        onMessageChannelReady onmessagechannelready = new onMessageChannelReady();
        char[] cArr2 = validateRelationship;
        if (cArr2 != null) {
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            for (int i2 = 0; i2 < length; i2++) {
                cArr3[i2] = (char) (((long) cArr2[i2]) ^ (-6087945323684963397L));
            }
            cArr2 = cArr3;
        }
        int i3 = (int) ((-6087945323684963397L) ^ ((long) warmup));
        if (ICustomTabsServiceDefault) {
            onmessagechannelready.c = bArr.length;
            char[] cArr4 = new char[onmessagechannelready.c];
            onmessagechannelready.a = 0;
            while (onmessagechannelready.a < onmessagechannelready.c) {
                cArr4[onmessagechannelready.a] = (char) (cArr2[bArr[(onmessagechannelready.c - 1) - onmessagechannelready.a] + i] - i3);
                onmessagechannelready.a++;
            }
            objArr[0] = new String(cArr4);
            return;
        }
        if (requestPostMessageChannelWithExtras) {
            onmessagechannelready.c = cArr.length;
            char[] cArr5 = new char[onmessagechannelready.c];
            onmessagechannelready.a = 0;
            while (onmessagechannelready.a < onmessagechannelready.c) {
                cArr5[onmessagechannelready.a] = (char) (cArr2[cArr[(onmessagechannelready.c - 1) - onmessagechannelready.a] - i] - i3);
                onmessagechannelready.a++;
            }
            objArr[0] = new String(cArr5);
            return;
        }
        onmessagechannelready.c = iArr.length;
        char[] cArr6 = new char[onmessagechannelready.c];
        onmessagechannelready.a = 0;
        while (onmessagechannelready.a < onmessagechannelready.c) {
            cArr6[onmessagechannelready.a] = (char) (cArr2[iArr[(onmessagechannelready.c - 1) - onmessagechannelready.a] - i] - i3);
            onmessagechannelready.a++;
        }
        objArr[0] = new String(cArr6);
    }

    @Override // com.facebook.soloader.SoSource
    @Nullable
    public String[] getLibraryDependencies(String str) {
        Set<String> set = this.mLibs;
        if (set == null) {
            throw new IllegalStateException("prepare not called");
        }
        if (set.contains(str)) {
            return new String[0];
        }
        return null;
    }

    @Override // com.facebook.soloader.SoSource
    public String[] getSoSourceAbis() {
        Manifest manifest = this.mManifest;
        if (manifest == null) {
            throw new IllegalStateException("prepare not called");
        }
        return new String[]{manifest.arch};
    }

    @Override // com.facebook.soloader.SoSource
    public String getName() {
        return "DirectSplitSoSource";
    }

    /* JADX WARN: Code duplicated, block: B:117:0x034d  */
    /* JADX WARN: Code duplicated, block: B:120:0x038c A[Catch: Exception -> 0x0280, TRY_ENTER, TRY_LEAVE, TryCatch #78 {Exception -> 0x0280, blocks: (B:43:0x01ee, B:49:0x0258, B:75:0x028e, B:84:0x02d5, B:86:0x02db, B:87:0x02dc, B:120:0x038c, B:124:0x0404, B:129:0x045e, B:205:0x058e, B:221:0x05f1, B:225:0x0602, B:230:0x063f, B:232:0x0645, B:233:0x0646, B:235:0x0648, B:237:0x064f, B:238:0x0650, B:240:0x065c, B:241:0x0662, B:256:0x06c0, B:258:0x06c2, B:260:0x06c9, B:261:0x06ca, B:131:0x0469, B:133:0x0470, B:134:0x0471, B:136:0x0473, B:138:0x047a, B:139:0x047b, B:141:0x047d, B:143:0x0484, B:144:0x0485, B:146:0x0487, B:148:0x048e, B:149:0x048f, B:151:0x0491, B:153:0x0498, B:154:0x0499, B:159:0x04b6, B:161:0x04bc, B:162:0x04bd, B:164:0x04bf, B:166:0x04c6, B:167:0x04c7, B:89:0x02de, B:91:0x02e5, B:92:0x02e6, B:53:0x0261, B:55:0x0268, B:56:0x0269, B:58:0x026b, B:60:0x0272, B:61:0x0273, B:63:0x0275, B:65:0x027c, B:66:0x027d, B:48:0x0231, B:128:0x0441, B:46:0x021c, B:127:0x0428, B:44:0x01fe, B:125:0x040b, B:123:0x03db, B:121:0x03be, B:155:0x049a, B:244:0x06a1, B:246:0x06ad, B:247:0x06b2, B:249:0x06b4, B:251:0x06bb, B:252:0x06bc, B:242:0x0663, B:118:0x034f, B:239:0x0651, B:80:0x02a4, B:77:0x0296), top: B:789:0x01ee, inners: #24, #26, #29, #35, #37, #43, #48, #51, #64, #65, #66, #68, #81, #85 }] */
    /* JADX WARN: Code duplicated, block: B:168:0x04c8 A[Catch: Exception -> 0x0ac0, TRY_ENTER, TRY_LEAVE, TryCatch #52 {Exception -> 0x0ac0, blocks: (B:115:0x033f, B:193:0x0530, B:262:0x06cb, B:270:0x06e5, B:271:0x06ec, B:168:0x04c8, B:192:0x0523), top: B:744:0x033f }] */
    /* JADX WARN: Code duplicated, block: B:196:0x0540  */
    /* JADX WARN: Code duplicated, block: B:205:0x058e A[Catch: Exception -> 0x0280, TRY_ENTER, TRY_LEAVE, TryCatch #78 {Exception -> 0x0280, blocks: (B:43:0x01ee, B:49:0x0258, B:75:0x028e, B:84:0x02d5, B:86:0x02db, B:87:0x02dc, B:120:0x038c, B:124:0x0404, B:129:0x045e, B:205:0x058e, B:221:0x05f1, B:225:0x0602, B:230:0x063f, B:232:0x0645, B:233:0x0646, B:235:0x0648, B:237:0x064f, B:238:0x0650, B:240:0x065c, B:241:0x0662, B:256:0x06c0, B:258:0x06c2, B:260:0x06c9, B:261:0x06ca, B:131:0x0469, B:133:0x0470, B:134:0x0471, B:136:0x0473, B:138:0x047a, B:139:0x047b, B:141:0x047d, B:143:0x0484, B:144:0x0485, B:146:0x0487, B:148:0x048e, B:149:0x048f, B:151:0x0491, B:153:0x0498, B:154:0x0499, B:159:0x04b6, B:161:0x04bc, B:162:0x04bd, B:164:0x04bf, B:166:0x04c6, B:167:0x04c7, B:89:0x02de, B:91:0x02e5, B:92:0x02e6, B:53:0x0261, B:55:0x0268, B:56:0x0269, B:58:0x026b, B:60:0x0272, B:61:0x0273, B:63:0x0275, B:65:0x027c, B:66:0x027d, B:48:0x0231, B:128:0x0441, B:46:0x021c, B:127:0x0428, B:44:0x01fe, B:125:0x040b, B:123:0x03db, B:121:0x03be, B:155:0x049a, B:244:0x06a1, B:246:0x06ad, B:247:0x06b2, B:249:0x06b4, B:251:0x06bb, B:252:0x06bc, B:242:0x0663, B:118:0x034f, B:239:0x0651, B:80:0x02a4, B:77:0x0296), top: B:789:0x01ee, inners: #24, #26, #29, #35, #37, #43, #48, #51, #64, #65, #66, #68, #81, #85 }] */
    /* JADX WARN: Code duplicated, block: B:262:0x06cb A[Catch: Exception -> 0x0ac0, TRY_ENTER, TRY_LEAVE, TryCatch #52 {Exception -> 0x0ac0, blocks: (B:115:0x033f, B:193:0x0530, B:262:0x06cb, B:270:0x06e5, B:271:0x06ec, B:168:0x04c8, B:192:0x0523), top: B:744:0x033f }] */
    /* JADX WARN: Code duplicated, block: B:273:0x06f2  */
    /* JADX WARN: Code duplicated, block: B:41:0x01e5  */
    /* JADX WARN: Code duplicated, block: B:421:0x0952 A[Catch: Exception -> 0x0b90, TryCatch #67 {Exception -> 0x0b90, blocks: (B:419:0x094c, B:421:0x0952, B:422:0x0953), top: B:772:0x094c }] */
    /* JADX WARN: Code duplicated, block: B:422:0x0953 A[Catch: Exception -> 0x0b90, TRY_LEAVE, TryCatch #67 {Exception -> 0x0b90, blocks: (B:419:0x094c, B:421:0x0952, B:422:0x0953), top: B:772:0x094c }] */
    /* JADX WARN: Code duplicated, block: B:447:0x0990 A[Catch: all -> 0x0992, TryCatch #53 {all -> 0x0992, blocks: (B:426:0x095e, B:427:0x0963, B:451:0x0994, B:445:0x0989, B:447:0x0990, B:448:0x0991), top: B:746:0x08d1 }] */
    /* JADX WARN: Code duplicated, block: B:448:0x0991 A[Catch: all -> 0x0992, TryCatch #53 {all -> 0x0992, blocks: (B:426:0x095e, B:427:0x0963, B:451:0x0994, B:445:0x0989, B:447:0x0990, B:448:0x0991), top: B:746:0x08d1 }] */
    /* JADX WARN: Code duplicated, block: B:470:0x09c0 A[Catch: Exception -> 0x0b81, TryCatch #87 {Exception -> 0x0b81, blocks: (B:531:0x0a65, B:533:0x0a6b, B:534:0x0a6c, B:452:0x0995, B:468:0x09b9, B:470:0x09c0, B:471:0x09c1, B:476:0x09cf, B:478:0x09d8, B:479:0x09d9, B:492:0x09f9, B:494:0x0a02, B:495:0x0a03, B:509:0x0a1f, B:511:0x0a28, B:512:0x0a29, B:522:0x0a44, B:524:0x0a4f, B:525:0x0a50, B:551:0x0a94, B:553:0x0a9e, B:554:0x0a9f, B:562:0x0ab3, B:564:0x0abe, B:565:0x0abf, B:581:0x0ae8, B:583:0x0af2, B:584:0x0af3, B:594:0x0b0e, B:596:0x0b19, B:597:0x0b1a, B:607:0x0b35, B:609:0x0b40, B:610:0x0b41, B:617:0x0b65, B:619:0x0b6c, B:620:0x0b6d, B:622:0x0b6f, B:624:0x0b7f, B:625:0x0b80, B:13:0x0121), top: B:705:0x0121, inners: #32 }] */
    /* JADX WARN: Code duplicated, block: B:471:0x09c1 A[Catch: Exception -> 0x0b81, TryCatch #87 {Exception -> 0x0b81, blocks: (B:531:0x0a65, B:533:0x0a6b, B:534:0x0a6c, B:452:0x0995, B:468:0x09b9, B:470:0x09c0, B:471:0x09c1, B:476:0x09cf, B:478:0x09d8, B:479:0x09d9, B:492:0x09f9, B:494:0x0a02, B:495:0x0a03, B:509:0x0a1f, B:511:0x0a28, B:512:0x0a29, B:522:0x0a44, B:524:0x0a4f, B:525:0x0a50, B:551:0x0a94, B:553:0x0a9e, B:554:0x0a9f, B:562:0x0ab3, B:564:0x0abe, B:565:0x0abf, B:581:0x0ae8, B:583:0x0af2, B:584:0x0af3, B:594:0x0b0e, B:596:0x0b19, B:597:0x0b1a, B:607:0x0b35, B:609:0x0b40, B:610:0x0b41, B:617:0x0b65, B:619:0x0b6c, B:620:0x0b6d, B:622:0x0b6f, B:624:0x0b7f, B:625:0x0b80, B:13:0x0121), top: B:705:0x0121, inners: #32 }] */
    /* JADX WARN: Code duplicated, block: B:494:0x0a02 A[Catch: Exception -> 0x0b81, TryCatch #87 {Exception -> 0x0b81, blocks: (B:531:0x0a65, B:533:0x0a6b, B:534:0x0a6c, B:452:0x0995, B:468:0x09b9, B:470:0x09c0, B:471:0x09c1, B:476:0x09cf, B:478:0x09d8, B:479:0x09d9, B:492:0x09f9, B:494:0x0a02, B:495:0x0a03, B:509:0x0a1f, B:511:0x0a28, B:512:0x0a29, B:522:0x0a44, B:524:0x0a4f, B:525:0x0a50, B:551:0x0a94, B:553:0x0a9e, B:554:0x0a9f, B:562:0x0ab3, B:564:0x0abe, B:565:0x0abf, B:581:0x0ae8, B:583:0x0af2, B:584:0x0af3, B:594:0x0b0e, B:596:0x0b19, B:597:0x0b1a, B:607:0x0b35, B:609:0x0b40, B:610:0x0b41, B:617:0x0b65, B:619:0x0b6c, B:620:0x0b6d, B:622:0x0b6f, B:624:0x0b7f, B:625:0x0b80, B:13:0x0121), top: B:705:0x0121, inners: #32 }] */
    /* JADX WARN: Code duplicated, block: B:495:0x0a03 A[Catch: Exception -> 0x0b81, TryCatch #87 {Exception -> 0x0b81, blocks: (B:531:0x0a65, B:533:0x0a6b, B:534:0x0a6c, B:452:0x0995, B:468:0x09b9, B:470:0x09c0, B:471:0x09c1, B:476:0x09cf, B:478:0x09d8, B:479:0x09d9, B:492:0x09f9, B:494:0x0a02, B:495:0x0a03, B:509:0x0a1f, B:511:0x0a28, B:512:0x0a29, B:522:0x0a44, B:524:0x0a4f, B:525:0x0a50, B:551:0x0a94, B:553:0x0a9e, B:554:0x0a9f, B:562:0x0ab3, B:564:0x0abe, B:565:0x0abf, B:581:0x0ae8, B:583:0x0af2, B:584:0x0af3, B:594:0x0b0e, B:596:0x0b19, B:597:0x0b1a, B:607:0x0b35, B:609:0x0b40, B:610:0x0b41, B:617:0x0b65, B:619:0x0b6c, B:620:0x0b6d, B:622:0x0b6f, B:624:0x0b7f, B:625:0x0b80, B:13:0x0121), top: B:705:0x0121, inners: #32 }] */
    /* JADX WARN: Code duplicated, block: B:511:0x0a28 A[Catch: Exception -> 0x0b81, TryCatch #87 {Exception -> 0x0b81, blocks: (B:531:0x0a65, B:533:0x0a6b, B:534:0x0a6c, B:452:0x0995, B:468:0x09b9, B:470:0x09c0, B:471:0x09c1, B:476:0x09cf, B:478:0x09d8, B:479:0x09d9, B:492:0x09f9, B:494:0x0a02, B:495:0x0a03, B:509:0x0a1f, B:511:0x0a28, B:512:0x0a29, B:522:0x0a44, B:524:0x0a4f, B:525:0x0a50, B:551:0x0a94, B:553:0x0a9e, B:554:0x0a9f, B:562:0x0ab3, B:564:0x0abe, B:565:0x0abf, B:581:0x0ae8, B:583:0x0af2, B:584:0x0af3, B:594:0x0b0e, B:596:0x0b19, B:597:0x0b1a, B:607:0x0b35, B:609:0x0b40, B:610:0x0b41, B:617:0x0b65, B:619:0x0b6c, B:620:0x0b6d, B:622:0x0b6f, B:624:0x0b7f, B:625:0x0b80, B:13:0x0121), top: B:705:0x0121, inners: #32 }] */
    /* JADX WARN: Code duplicated, block: B:512:0x0a29 A[Catch: Exception -> 0x0b81, TryCatch #87 {Exception -> 0x0b81, blocks: (B:531:0x0a65, B:533:0x0a6b, B:534:0x0a6c, B:452:0x0995, B:468:0x09b9, B:470:0x09c0, B:471:0x09c1, B:476:0x09cf, B:478:0x09d8, B:479:0x09d9, B:492:0x09f9, B:494:0x0a02, B:495:0x0a03, B:509:0x0a1f, B:511:0x0a28, B:512:0x0a29, B:522:0x0a44, B:524:0x0a4f, B:525:0x0a50, B:551:0x0a94, B:553:0x0a9e, B:554:0x0a9f, B:562:0x0ab3, B:564:0x0abe, B:565:0x0abf, B:581:0x0ae8, B:583:0x0af2, B:584:0x0af3, B:594:0x0b0e, B:596:0x0b19, B:597:0x0b1a, B:607:0x0b35, B:609:0x0b40, B:610:0x0b41, B:617:0x0b65, B:619:0x0b6c, B:620:0x0b6d, B:622:0x0b6f, B:624:0x0b7f, B:625:0x0b80, B:13:0x0121), top: B:705:0x0121, inners: #32 }] */
    /* JADX WARN: Code duplicated, block: B:51:0x025e  */
    /* JADX WARN: Code duplicated, block: B:524:0x0a4f A[Catch: Exception -> 0x0b81, TryCatch #87 {Exception -> 0x0b81, blocks: (B:531:0x0a65, B:533:0x0a6b, B:534:0x0a6c, B:452:0x0995, B:468:0x09b9, B:470:0x09c0, B:471:0x09c1, B:476:0x09cf, B:478:0x09d8, B:479:0x09d9, B:492:0x09f9, B:494:0x0a02, B:495:0x0a03, B:509:0x0a1f, B:511:0x0a28, B:512:0x0a29, B:522:0x0a44, B:524:0x0a4f, B:525:0x0a50, B:551:0x0a94, B:553:0x0a9e, B:554:0x0a9f, B:562:0x0ab3, B:564:0x0abe, B:565:0x0abf, B:581:0x0ae8, B:583:0x0af2, B:584:0x0af3, B:594:0x0b0e, B:596:0x0b19, B:597:0x0b1a, B:607:0x0b35, B:609:0x0b40, B:610:0x0b41, B:617:0x0b65, B:619:0x0b6c, B:620:0x0b6d, B:622:0x0b6f, B:624:0x0b7f, B:625:0x0b80, B:13:0x0121), top: B:705:0x0121, inners: #32 }] */
    /* JADX WARN: Code duplicated, block: B:525:0x0a50 A[Catch: Exception -> 0x0b81, TryCatch #87 {Exception -> 0x0b81, blocks: (B:531:0x0a65, B:533:0x0a6b, B:534:0x0a6c, B:452:0x0995, B:468:0x09b9, B:470:0x09c0, B:471:0x09c1, B:476:0x09cf, B:478:0x09d8, B:479:0x09d9, B:492:0x09f9, B:494:0x0a02, B:495:0x0a03, B:509:0x0a1f, B:511:0x0a28, B:512:0x0a29, B:522:0x0a44, B:524:0x0a4f, B:525:0x0a50, B:551:0x0a94, B:553:0x0a9e, B:554:0x0a9f, B:562:0x0ab3, B:564:0x0abe, B:565:0x0abf, B:581:0x0ae8, B:583:0x0af2, B:584:0x0af3, B:594:0x0b0e, B:596:0x0b19, B:597:0x0b1a, B:607:0x0b35, B:609:0x0b40, B:610:0x0b41, B:617:0x0b65, B:619:0x0b6c, B:620:0x0b6d, B:622:0x0b6f, B:624:0x0b7f, B:625:0x0b80, B:13:0x0121), top: B:705:0x0121, inners: #32 }] */
    /* JADX WARN: Code duplicated, block: B:533:0x0a6b A[Catch: Exception -> 0x0b81, TryCatch #87 {Exception -> 0x0b81, blocks: (B:531:0x0a65, B:533:0x0a6b, B:534:0x0a6c, B:452:0x0995, B:468:0x09b9, B:470:0x09c0, B:471:0x09c1, B:476:0x09cf, B:478:0x09d8, B:479:0x09d9, B:492:0x09f9, B:494:0x0a02, B:495:0x0a03, B:509:0x0a1f, B:511:0x0a28, B:512:0x0a29, B:522:0x0a44, B:524:0x0a4f, B:525:0x0a50, B:551:0x0a94, B:553:0x0a9e, B:554:0x0a9f, B:562:0x0ab3, B:564:0x0abe, B:565:0x0abf, B:581:0x0ae8, B:583:0x0af2, B:584:0x0af3, B:594:0x0b0e, B:596:0x0b19, B:597:0x0b1a, B:607:0x0b35, B:609:0x0b40, B:610:0x0b41, B:617:0x0b65, B:619:0x0b6c, B:620:0x0b6d, B:622:0x0b6f, B:624:0x0b7f, B:625:0x0b80, B:13:0x0121), top: B:705:0x0121, inners: #32 }] */
    /* JADX WARN: Code duplicated, block: B:534:0x0a6c A[Catch: Exception -> 0x0b81, TryCatch #87 {Exception -> 0x0b81, blocks: (B:531:0x0a65, B:533:0x0a6b, B:534:0x0a6c, B:452:0x0995, B:468:0x09b9, B:470:0x09c0, B:471:0x09c1, B:476:0x09cf, B:478:0x09d8, B:479:0x09d9, B:492:0x09f9, B:494:0x0a02, B:495:0x0a03, B:509:0x0a1f, B:511:0x0a28, B:512:0x0a29, B:522:0x0a44, B:524:0x0a4f, B:525:0x0a50, B:551:0x0a94, B:553:0x0a9e, B:554:0x0a9f, B:562:0x0ab3, B:564:0x0abe, B:565:0x0abf, B:581:0x0ae8, B:583:0x0af2, B:584:0x0af3, B:594:0x0b0e, B:596:0x0b19, B:597:0x0b1a, B:607:0x0b35, B:609:0x0b40, B:610:0x0b41, B:617:0x0b65, B:619:0x0b6c, B:620:0x0b6d, B:622:0x0b6f, B:624:0x0b7f, B:625:0x0b80, B:13:0x0121), top: B:705:0x0121, inners: #32 }] */
    /* JADX WARN: Code duplicated, block: B:553:0x0a9e A[Catch: Exception -> 0x0b81, TryCatch #87 {Exception -> 0x0b81, blocks: (B:531:0x0a65, B:533:0x0a6b, B:534:0x0a6c, B:452:0x0995, B:468:0x09b9, B:470:0x09c0, B:471:0x09c1, B:476:0x09cf, B:478:0x09d8, B:479:0x09d9, B:492:0x09f9, B:494:0x0a02, B:495:0x0a03, B:509:0x0a1f, B:511:0x0a28, B:512:0x0a29, B:522:0x0a44, B:524:0x0a4f, B:525:0x0a50, B:551:0x0a94, B:553:0x0a9e, B:554:0x0a9f, B:562:0x0ab3, B:564:0x0abe, B:565:0x0abf, B:581:0x0ae8, B:583:0x0af2, B:584:0x0af3, B:594:0x0b0e, B:596:0x0b19, B:597:0x0b1a, B:607:0x0b35, B:609:0x0b40, B:610:0x0b41, B:617:0x0b65, B:619:0x0b6c, B:620:0x0b6d, B:622:0x0b6f, B:624:0x0b7f, B:625:0x0b80, B:13:0x0121), top: B:705:0x0121, inners: #32 }] */
    /* JADX WARN: Code duplicated, block: B:554:0x0a9f A[Catch: Exception -> 0x0b81, TryCatch #87 {Exception -> 0x0b81, blocks: (B:531:0x0a65, B:533:0x0a6b, B:534:0x0a6c, B:452:0x0995, B:468:0x09b9, B:470:0x09c0, B:471:0x09c1, B:476:0x09cf, B:478:0x09d8, B:479:0x09d9, B:492:0x09f9, B:494:0x0a02, B:495:0x0a03, B:509:0x0a1f, B:511:0x0a28, B:512:0x0a29, B:522:0x0a44, B:524:0x0a4f, B:525:0x0a50, B:551:0x0a94, B:553:0x0a9e, B:554:0x0a9f, B:562:0x0ab3, B:564:0x0abe, B:565:0x0abf, B:581:0x0ae8, B:583:0x0af2, B:584:0x0af3, B:594:0x0b0e, B:596:0x0b19, B:597:0x0b1a, B:607:0x0b35, B:609:0x0b40, B:610:0x0b41, B:617:0x0b65, B:619:0x0b6c, B:620:0x0b6d, B:622:0x0b6f, B:624:0x0b7f, B:625:0x0b80, B:13:0x0121), top: B:705:0x0121, inners: #32 }] */
    /* JADX WARN: Code duplicated, block: B:564:0x0abe A[Catch: Exception -> 0x0b81, TryCatch #87 {Exception -> 0x0b81, blocks: (B:531:0x0a65, B:533:0x0a6b, B:534:0x0a6c, B:452:0x0995, B:468:0x09b9, B:470:0x09c0, B:471:0x09c1, B:476:0x09cf, B:478:0x09d8, B:479:0x09d9, B:492:0x09f9, B:494:0x0a02, B:495:0x0a03, B:509:0x0a1f, B:511:0x0a28, B:512:0x0a29, B:522:0x0a44, B:524:0x0a4f, B:525:0x0a50, B:551:0x0a94, B:553:0x0a9e, B:554:0x0a9f, B:562:0x0ab3, B:564:0x0abe, B:565:0x0abf, B:581:0x0ae8, B:583:0x0af2, B:584:0x0af3, B:594:0x0b0e, B:596:0x0b19, B:597:0x0b1a, B:607:0x0b35, B:609:0x0b40, B:610:0x0b41, B:617:0x0b65, B:619:0x0b6c, B:620:0x0b6d, B:622:0x0b6f, B:624:0x0b7f, B:625:0x0b80, B:13:0x0121), top: B:705:0x0121, inners: #32 }] */
    /* JADX WARN: Code duplicated, block: B:565:0x0abf A[Catch: Exception -> 0x0b81, TryCatch #87 {Exception -> 0x0b81, blocks: (B:531:0x0a65, B:533:0x0a6b, B:534:0x0a6c, B:452:0x0995, B:468:0x09b9, B:470:0x09c0, B:471:0x09c1, B:476:0x09cf, B:478:0x09d8, B:479:0x09d9, B:492:0x09f9, B:494:0x0a02, B:495:0x0a03, B:509:0x0a1f, B:511:0x0a28, B:512:0x0a29, B:522:0x0a44, B:524:0x0a4f, B:525:0x0a50, B:551:0x0a94, B:553:0x0a9e, B:554:0x0a9f, B:562:0x0ab3, B:564:0x0abe, B:565:0x0abf, B:581:0x0ae8, B:583:0x0af2, B:584:0x0af3, B:594:0x0b0e, B:596:0x0b19, B:597:0x0b1a, B:607:0x0b35, B:609:0x0b40, B:610:0x0b41, B:617:0x0b65, B:619:0x0b6c, B:620:0x0b6d, B:622:0x0b6f, B:624:0x0b7f, B:625:0x0b80, B:13:0x0121), top: B:705:0x0121, inners: #32 }] */
    /* JADX WARN: Code duplicated, block: B:583:0x0af2 A[Catch: Exception -> 0x0b81, TryCatch #87 {Exception -> 0x0b81, blocks: (B:531:0x0a65, B:533:0x0a6b, B:534:0x0a6c, B:452:0x0995, B:468:0x09b9, B:470:0x09c0, B:471:0x09c1, B:476:0x09cf, B:478:0x09d8, B:479:0x09d9, B:492:0x09f9, B:494:0x0a02, B:495:0x0a03, B:509:0x0a1f, B:511:0x0a28, B:512:0x0a29, B:522:0x0a44, B:524:0x0a4f, B:525:0x0a50, B:551:0x0a94, B:553:0x0a9e, B:554:0x0a9f, B:562:0x0ab3, B:564:0x0abe, B:565:0x0abf, B:581:0x0ae8, B:583:0x0af2, B:584:0x0af3, B:594:0x0b0e, B:596:0x0b19, B:597:0x0b1a, B:607:0x0b35, B:609:0x0b40, B:610:0x0b41, B:617:0x0b65, B:619:0x0b6c, B:620:0x0b6d, B:622:0x0b6f, B:624:0x0b7f, B:625:0x0b80, B:13:0x0121), top: B:705:0x0121, inners: #32 }] */
    /* JADX WARN: Code duplicated, block: B:584:0x0af3 A[Catch: Exception -> 0x0b81, TryCatch #87 {Exception -> 0x0b81, blocks: (B:531:0x0a65, B:533:0x0a6b, B:534:0x0a6c, B:452:0x0995, B:468:0x09b9, B:470:0x09c0, B:471:0x09c1, B:476:0x09cf, B:478:0x09d8, B:479:0x09d9, B:492:0x09f9, B:494:0x0a02, B:495:0x0a03, B:509:0x0a1f, B:511:0x0a28, B:512:0x0a29, B:522:0x0a44, B:524:0x0a4f, B:525:0x0a50, B:551:0x0a94, B:553:0x0a9e, B:554:0x0a9f, B:562:0x0ab3, B:564:0x0abe, B:565:0x0abf, B:581:0x0ae8, B:583:0x0af2, B:584:0x0af3, B:594:0x0b0e, B:596:0x0b19, B:597:0x0b1a, B:607:0x0b35, B:609:0x0b40, B:610:0x0b41, B:617:0x0b65, B:619:0x0b6c, B:620:0x0b6d, B:622:0x0b6f, B:624:0x0b7f, B:625:0x0b80, B:13:0x0121), top: B:705:0x0121, inners: #32 }] */
    /* JADX WARN: Code duplicated, block: B:683:0x0910 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:731:0x08d2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:73:0x028b  */
    /* JADX WARN: Code duplicated, block: B:75:0x028e A[Catch: Exception -> 0x0280, TRY_LEAVE, TryCatch #78 {Exception -> 0x0280, blocks: (B:43:0x01ee, B:49:0x0258, B:75:0x028e, B:84:0x02d5, B:86:0x02db, B:87:0x02dc, B:120:0x038c, B:124:0x0404, B:129:0x045e, B:205:0x058e, B:221:0x05f1, B:225:0x0602, B:230:0x063f, B:232:0x0645, B:233:0x0646, B:235:0x0648, B:237:0x064f, B:238:0x0650, B:240:0x065c, B:241:0x0662, B:256:0x06c0, B:258:0x06c2, B:260:0x06c9, B:261:0x06ca, B:131:0x0469, B:133:0x0470, B:134:0x0471, B:136:0x0473, B:138:0x047a, B:139:0x047b, B:141:0x047d, B:143:0x0484, B:144:0x0485, B:146:0x0487, B:148:0x048e, B:149:0x048f, B:151:0x0491, B:153:0x0498, B:154:0x0499, B:159:0x04b6, B:161:0x04bc, B:162:0x04bd, B:164:0x04bf, B:166:0x04c6, B:167:0x04c7, B:89:0x02de, B:91:0x02e5, B:92:0x02e6, B:53:0x0261, B:55:0x0268, B:56:0x0269, B:58:0x026b, B:60:0x0272, B:61:0x0273, B:63:0x0275, B:65:0x027c, B:66:0x027d, B:48:0x0231, B:128:0x0441, B:46:0x021c, B:127:0x0428, B:44:0x01fe, B:125:0x040b, B:123:0x03db, B:121:0x03be, B:155:0x049a, B:244:0x06a1, B:246:0x06ad, B:247:0x06b2, B:249:0x06b4, B:251:0x06bb, B:252:0x06bc, B:242:0x0663, B:118:0x034f, B:239:0x0651, B:80:0x02a4, B:77:0x0296), top: B:789:0x01ee, inners: #24, #26, #29, #35, #37, #43, #48, #51, #64, #65, #66, #68, #81, #85 }] */
    /* JADX WARN: Code duplicated, block: B:765:0x0663 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:767:0x049a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:769:0x06a1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:79:0x02a3  */
    /* JADX WARN: Code duplicated, block: B:801:0x0296 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:846:0x06ad A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:847:0x095a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:848:0x0b9d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:850:0x0b90 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:852:0x06ff A[EDGE_INSN: B:852:0x06ff->B:278:0x06ff BREAK  A[LOOP:1: B:271:0x06ec->B:853:?], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:93:0x02e7  */
    /* JADX WARN: Instruction removed from duplicated block: B:168:0x04c8, please report this as an issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v10 */
    /* JADX WARN: Type inference failed for: r14v109, types: [java.lang.reflect.Method] */
    /* JADX WARN: Type inference failed for: r14v11 */
    /* JADX WARN: Type inference failed for: r14v117 */
    /* JADX WARN: Type inference failed for: r14v118 */
    /* JADX WARN: Type inference failed for: r14v12 */
    /* JADX WARN: Type inference failed for: r14v123 */
    /* JADX WARN: Type inference failed for: r14v124 */
    /* JADX WARN: Type inference failed for: r14v125 */
    /* JADX WARN: Type inference failed for: r14v126 */
    /* JADX WARN: Type inference failed for: r14v15, types: [int] */
    /* JADX WARN: Type inference failed for: r14v16 */
    /* JADX WARN: Type inference failed for: r14v17 */
    /* JADX WARN: Type inference failed for: r14v19, types: [java.lang.reflect.Constructor] */
    /* JADX WARN: Type inference failed for: r14v20 */
    /* JADX WARN: Type inference failed for: r14v22 */
    /* JADX WARN: Type inference failed for: r14v23 */
    /* JADX WARN: Type inference failed for: r14v24 */
    /* JADX WARN: Type inference failed for: r14v32 */
    /* JADX WARN: Type inference failed for: r14v33 */
    /* JADX WARN: Type inference failed for: r14v52 */
    /* JADX WARN: Type inference failed for: r14v73 */
    /* JADX WARN: Type inference failed for: r14v74 */
    /* JADX WARN: Type inference failed for: r14v75 */
    /* JADX WARN: Type inference failed for: r14v82 */
    /* JADX WARN: Type inference failed for: r14v9 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v3, types: [char[], int[], java.lang.Class[], java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r3v10, types: [java.lang.reflect.Method] */
    /* JADX WARN: Type inference failed for: r3v72, types: [java.lang.reflect.Method] */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 6 */
    private static void coroutineCreation(String str) throws Exception {
        ?? pressedStateDuration;
        String str2;
        Exception exc;
        ?? r14;
        String strCoroutineDebuggingKt;
        Exception e;
        ?? r15;
        Throwable th;
        Throwable cause;
        Object objNewInstance;
        BufferedInputStream bufferedInputStream;
        URL resource;
        Throwable th2;
        Throwable cause2;
        Throwable th3;
        Throwable cause3;
        InputStream inputStream;
        Throwable th4;
        Throwable cause4;
        Object objAccessartificialFrame;
        InputStream inputStream2;
        BufferedOutputStream bufferedOutputStream;
        Throwable th5;
        Throwable cause5;
        byte[] bArr;
        int i;
        Throwable th6;
        Throwable cause6;
        Throwable th7;
        Throwable cause7;
        Object objInvoke;
        Throwable th8;
        Throwable cause8;
        Object objInvoke2;
        ClassLoader classLoader;
        Throwable th9;
        Throwable cause9;
        String str3;
        Throwable th10;
        Throwable cause10;
        Object objInvoke3;
        ClassLoader classLoader2;
        String str4;
        Object[] objArr;
        String str5 = str;
        int i2 = 1;
        Object[] objArr2 = new Object[1];
        a(';' - AndroidCharacter.getMirror('0'), new int[]{1339050181, 1969813344, 162784018, -2038436619, -2041873739, -1604879318}, objArr2);
        int i3 = 0;
        String str6 = (String) objArr2[0];
        int i4 = 8;
        Object[] objArr3 = new Object[1];
        a((ViewConfiguration.getTouchSlop() >> 8) + 9, new int[]{-1434757402, 1186152345, -755563254, -148207570, 1421297986, -127092786}, objArr3);
        String str7 = (String) objArr3[0];
        Object[] objArr4 = new Object[1];
        a((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 11, new int[]{416664702, -396993441, 1303750133, -284668714, -1386638344, -496647572}, objArr4);
        String str8 = (String) objArr4[0];
        Object[] objArr5 = new Object[1];
        ?? r2 = 0;
        b(null, new byte[]{-127}, (Process.myPid() >> 22) + 127, null, objArr5);
        try {
            Object objInvoke4 = String.class.getMethod(str7, Integer.TYPE, Integer.TYPE).invoke(str5, Integer.valueOf(((Integer) String.class.getMethod(str6, String.class).invoke(str5, (String) objArr5[0])).intValue() + 4), Integer.valueOf(((Integer) String.class.getMethod("length", null).invoke(str5, null)).intValue() - 3));
            Object[] objArr6 = new Object[1];
            a(5 - (Process.myTid() >> 22), new int[]{1902145530, 144881107, -1253875370, -2012633532}, objArr6);
            String[] strArrCoroutineDebuggingKt = asInterface.CoroutineDebuggingKt(asInterface.ArtificialStackFrames((byte[]) String.class.getMethod("getBytes", String.class).invoke(objInvoke4, (String) objArr6[0])));
            if (strArrCoroutineDebuggingKt == null) {
                strArrCoroutineDebuggingKt = new String[0];
            }
            int length = strArrCoroutineDebuggingKt.length;
            String[] strArr = new String[length + 1];
            System.arraycopy(strArrCoroutineDebuggingKt, 0, strArr, 0, length);
            strArr[length] = str5;
            int i5 = 0;
            while (i5 <= length) {
                String str9 = strArr[i5];
                try {
                    pressedStateDuration = (ViewConfiguration.getPressedStateDuration() >> 16) + 127;
                    Object[] objArr7 = new Object[i2];
                    b(r2, new byte[]{-113, -112, -113, -114, -123, -118, -121, -122, -113, -114, -115, -116, -122, -117, -118, -119, -120, -121, -124, -122, -123, -127, -125, -124, -125, -126, -127, -125, -124, -125, -126, -127}, pressedStateDuration, r2, objArr7);
                    try {
                        try {
                            Object[] objArr8 = {(String) objArr7[i3]};
                            Class[] clsArr = new Class[i2];
                            clsArr[i3] = String.class;
                            pressedStateDuration = File.class.getDeclaredConstructor(clsArr);
                            Object objNewInstance2 = pressedStateDuration.newInstance(objArr8);
                            try {
                                byte[] bArr2 = new byte[i4];
                                // fill-array-data instruction
                                bArr2[0] = -122;
                                bArr2[1] = -124;
                                bArr2[2] = -114;
                                bArr2[3] = -116;
                                bArr2[4] = -111;
                                bArr2[5] = -123;
                                bArr2[6] = -125;
                                bArr2[7] = -113;
                                try {
                                    Object[] objArr9 = new Object[i2];
                                    b(r2, bArr2, (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 127, r2, objArr9);
                                    try {
                                        if (((Boolean) File.class.getMethod((String) objArr9[0], r2).invoke(objNewInstance2, r2)).booleanValue()) {
                                            if (i5 >= length) {
                                                byte[] bArr3 = new byte[i2];
                                                bArr3[0] = -127;
                                                Object[] objArr10 = new Object[i2];
                                                b(r2, bArr3, Color.red(0) + 127, r2, objArr10);
                                                Object[] objArr11 = {(String) objArr10[0]};
                                                Class[] clsArr2 = new Class[i2];
                                                clsArr2[0] = String.class;
                                                int iIntValue = ((Integer) String.class.getMethod(str6, clsArr2).invoke(str5, objArr11)).intValue() + 4;
                                                int iIntValue2 = ((Integer) String.class.getMethod("length", r2).invoke(str5, r2)).intValue() - 3;
                                                Object[] objArr12 = new Object[2];
                                                objArr12[i2] = Integer.valueOf(iIntValue2);
                                                objArr12[0] = Integer.valueOf(iIntValue);
                                                strCoroutineDebuggingKt = getDefaultImpl.CoroutineDebuggingKt(DirectSplitSoSource.class, (String) String.class.getMethod(str7, Integer.TYPE, Integer.TYPE).invoke(str5, objArr12));
                                                if (strCoroutineDebuggingKt == null) {
                                                    strCoroutineDebuggingKt = str5;
                                                }
                                            } else {
                                                strCoroutineDebuggingKt = str9;
                                            }
                                            if (i5 < length) {
                                                strCoroutineDebuggingKt = getDefaultImpl.CoroutineDebuggingKt(DirectSplitSoSource.class, strCoroutineDebuggingKt);
                                            }
                                            if (strCoroutineDebuggingKt == null) {
                                                Object objInvoke5 = Runtime.class.getMethod(str8, null).invoke(null, null);
                                                if (i5 >= length) {
                                                    str9 = str5;
                                                }
                                                Object[] objArr13 = new Object[1];
                                                b(null, new byte[]{-106, -116, -125, -116, -107, -114, -108, -126, -125, -112, -119}, MotionEvent.axisFromString("") + 128, null, objArr13);
                                                Runtime.class.getMethod((String) objArr13[0], String.class).invoke(objInvoke5, str9);
                                                return;
                                            }
                                            Object[] objArr14 = new Object[1];
                                            objArr14[0] = 47;
                                            Class[] clsArr3 = new Class[1];
                                            clsArr3[0] = Integer.TYPE;
                                            Object[] objArr15 = new Object[1];
                                            objArr15[0] = Integer.valueOf(((Integer) String.class.getMethod(str6, clsArr3).invoke(strCoroutineDebuggingKt, objArr14)).intValue() + 1);
                                            Class[] clsArr4 = new Class[1];
                                            clsArr4[0] = Integer.TYPE;
                                            Object[] objArr16 = {objNewInstance2, String.class.getMethod(str7, clsArr4).invoke(strCoroutineDebuggingKt, objArr15)};
                                            Class[] clsArr5 = new Class[2];
                                            clsArr5[0] = File.class;
                                            clsArr5[1] = String.class;
                                            objNewInstance = File.class.getDeclaredConstructor(clsArr5).newInstance(objArr16);
                                            resource = DirectSplitSoSource.class.getClassLoader().getResource(strCoroutineDebuggingKt);
                                            if (resource == null) {
                                                objArr = new Object[1];
                                                b(null, new byte[]{-117, -123, -114, -125, -124, -123, -112, -113}, 127 - ((Process.getThreadPriority(0) + 20) >> 6), null, objArr);
                                                if (((Boolean) String.class.getMethod((String) objArr[0], CharSequence.class).invoke(strCoroutineDebuggingKt, "!")).booleanValue()) {
                                                    StringBuilder sb = new StringBuilder();
                                                    Object[] objArr17 = new Object[1];
                                                    a(9 - Color.blue(0), new int[]{792246998, -13278780, 610332598, 1151625392, 538961869, -1592169096}, objArr17);
                                                    sb.append((String) objArr17[0]);
                                                    sb.append(strCoroutineDebuggingKt);
                                                    String path = new URL(sb.toString()).getPath();
                                                    ZipFile zipFile = new ZipFile((String) String.class.getMethod(str7, Integer.TYPE, Integer.TYPE).invoke(path, 5, Integer.valueOf(((Integer) String.class.getMethod(str6, String.class).invoke(path, "!/")).intValue())));
                                                    inputStream = zipFile.getInputStream(zipFile.getEntry((String) String.class.getMethod(str7, Integer.TYPE).invoke(String.class.getMethod(str7, Integer.TYPE).invoke(strCoroutineDebuggingKt, Integer.valueOf(((Integer) String.class.getMethod(str6, String.class).invoke(strCoroutineDebuggingKt, "!/")).intValue())), 2)));
                                                } else {
                                                    inputStream = (InputStream) FileInputStream.class.getDeclaredConstructor(String.class).newInstance(strCoroutineDebuggingKt);
                                                }
                                            } else {
                                                String path2 = resource.getPath();
                                                Object[] objArr18 = {"!/" + strCoroutineDebuggingKt};
                                                Class[] clsArr6 = new Class[1];
                                                clsArr6[0] = String.class;
                                                Object[] objArr19 = new Object[2];
                                                objArr19[1] = Integer.valueOf(((Integer) String.class.getMethod(str6, clsArr6).invoke(path2, objArr18)).intValue());
                                                objArr19[0] = 5;
                                                Class[] clsArr7 = new Class[2];
                                                clsArr7[0] = Integer.TYPE;
                                                clsArr7[1] = Integer.TYPE;
                                                ZipFile zipFile2 = new ZipFile((String) String.class.getMethod(str7, clsArr7).invoke(path2, objArr19));
                                                inputStream = zipFile2.getInputStream(zipFile2.getEntry(strCoroutineDebuggingKt));
                                            }
                                            bufferedInputStream = new BufferedInputStream(inputStream);
                                            Object[] objArr20 = {bufferedInputStream};
                                            objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-175194354);
                                            if (objAccessartificialFrame == null) {
                                                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(25 - View.combineMeasuredStates(0, 0), (char) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) - 1), 49 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), 1793849606, false, "CoroutineDebuggingKt", new Class[]{InputStream.class});
                                            }
                                            inputStream2 = (InputStream) ((Method) objAccessartificialFrame).invoke(null, objArr20);
                                            if (bufferedInputStream == inputStream2) {
                                                inputStream2.close();
                                                Object objInvoke6 = Runtime.class.getMethod(str8, null).invoke(null, null);
                                                Object[] objArr21 = {strCoroutineDebuggingKt, DirectSplitSoSource.class.getClassLoader()};
                                                Object[] objArr22 = new Object[1];
                                                a(4 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), new int[]{-1129597954, -221457042}, objArr22);
                                                Method declaredMethod = Runtime.class.getDeclaredMethod((String) objArr22[0], String.class, ClassLoader.class);
                                                declaredMethod.setAccessible(true);
                                                declaredMethod.invoke(objInvoke6, objArr21);
                                                str2 = str6;
                                                i2 = 0;
                                                i4 = 1;
                                                r14 = 0;
                                            } else {
                                                Object[] objArr23 = {objNewInstance};
                                                Class[] clsArr8 = new Class[1];
                                                clsArr8[0] = File.class;
                                                OutputStream outputStream = (OutputStream) FileOutputStream.class.getDeclaredConstructor(clsArr8).newInstance(objArr23);
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
                                                str2 = str6;
                                                Object[] objArr24 = new Object[1];
                                                a(View.MeasureSpec.getMode(0) + 5, new int[]{51827145, -747333205, -903845071, -262640914}, objArr24);
                                                Object objInvoke7 = FileOutputStream.class.getMethod((String) objArr24[0], null).invoke(outputStream, null);
                                                Object[] objArr25 = new Object[1];
                                                b(null, new byte[]{-113, -123, -106, -117}, 128 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), null, objArr25);
                                                FileDescriptor.class.getMethod((String) objArr25[0], null).invoke(objInvoke7, null);
                                                bufferedOutputStream.close();
                                                inputStream2.close();
                                                Object objInvoke8 = Runtime.class.getMethod(str8, null).invoke(null, null);
                                                Object[] objArr26 = new Object[1];
                                                a(View.combineMeasuredStates(0, 0) + 15, new int[]{603290398, 476923074, -1028958470, -1776496744, 1332184677, -423609601, 1387527132, 1708308371}, objArr26);
                                                Object[] objArr27 = {File.class.getMethod((String) objArr26[0], null).invoke(objNewInstance, null), DirectSplitSoSource.class.getClassLoader()};
                                                Object[] objArr28 = new Object[1];
                                                a((ViewConfiguration.getKeyRepeatDelay() >> 16) + 4, new int[]{-1129597954, -221457042}, objArr28);
                                                Method declaredMethod2 = Runtime.class.getDeclaredMethod((String) objArr28[0], String.class, ClassLoader.class);
                                                declaredMethod2.setAccessible(true);
                                                declaredMethod2.invoke(objInvoke8, objArr27);
                                                i4 = 1;
                                                Object[] objArr29 = new Object[1];
                                                r14 = 0;
                                                r14 = 0;
                                                r14 = 0;
                                                b(null, new byte[]{-122, -124, -122, -119, -122, -126}, 127 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), null, objArr29);
                                                i2 = 0;
                                                ((Boolean) File.class.getMethod((String) objArr29[0], null).invoke(objNewInstance, null)).booleanValue();
                                            }
                                            e = e;
                                            exc = e;
                                            str2 = str6;
                                            i2 = 0;
                                            i4 = 1;
                                            r15 = 0;
                                            r14 = r15;
                                            if (i5 < length) {
                                                throw exc;
                                            }
                                        } else {
                                            try {
                                                Object[] objArr30 = new Object[i2];
                                                b(r2, new byte[]{-116, -114, -126, -120, -109, -124, -121, -112, -114, -121, -125, -115, -125, -110}, (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + WebSocketProtocol.PAYLOAD_SHORT, r2, objArr30);
                                                String str10 = (String) objArr30[0];
                                                try {
                                                    Object[] objArr31 = {System.getProperty(str10, str10)};
                                                    Class[] clsArr9 = new Class[i2];
                                                    clsArr9[0] = String.class;
                                                    objNewInstance2 = File.class.getDeclaredConstructor(clsArr9).newInstance(objArr31);
                                                    try {
                                                        Object[] objArr32 = new Object[i2];
                                                        b(r2, new byte[]{-122, -124, -114, -116, -111, -123, -125, -113}, 127 - ExpandableListView.getPackedPositionType(0L), r2, objArr32);
                                                        if (!((Boolean) File.class.getMethod((String) objArr32[0], r2).invoke(objNewInstance2, r2)).booleanValue()) {
                                                            objNewInstance2 = Environment.getExternalStorageDirectory();
                                                        }
                                                        if (i5 >= length) {
                                                            try {
                                                                byte[] bArr4 = new byte[i2];
                                                                bArr4[0] = -127;
                                                                try {
                                                                    Object[] objArr110 = new Object[i2];
                                                                    b(r2, bArr4, Color.red(0) + 127, r2, objArr110);
                                                                    try {
                                                                        Object[] objArr111 = {(String) objArr110[0]};
                                                                        Class[] clsArr10 = new Class[i2];
                                                                        clsArr10[0] = String.class;
                                                                        int iIntValue3 = ((Integer) String.class.getMethod(str6, clsArr10).invoke(str5, objArr111)).intValue() + 4;
                                                                        try {
                                                                            int iIntValue4 = ((Integer) String.class.getMethod("length", r2).invoke(str5, r2)).intValue() - 3;
                                                                            try {
                                                                                Object[] objArr112 = new Object[2];
                                                                                objArr112[i2] = Integer.valueOf(iIntValue4);
                                                                                objArr112[0] = Integer.valueOf(iIntValue3);
                                                                                strCoroutineDebuggingKt = getDefaultImpl.CoroutineDebuggingKt(DirectSplitSoSource.class, (String) String.class.getMethod(str7, Integer.TYPE, Integer.TYPE).invoke(str5, objArr112));
                                                                                if (strCoroutineDebuggingKt == null) {
                                                                                    strCoroutineDebuggingKt = str5;
                                                                                }
                                                                            } catch (Throwable th11) {
                                                                                Throwable cause11 = th11.getCause();
                                                                                if (cause11 == null) {
                                                                                    throw th11;
                                                                                }
                                                                                throw cause11;
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
                                                                } catch (Exception e2) {
                                                                    e = e2;
                                                                    exc = e;
                                                                    str2 = str6;
                                                                }
                                                            } catch (Exception e3) {
                                                                e = e3;
                                                                exc = e;
                                                                str2 = str6;
                                                            }
                                                        } else {
                                                            strCoroutineDebuggingKt = str9;
                                                        }
                                                        if (i5 < length) {
                                                            strCoroutineDebuggingKt = getDefaultImpl.CoroutineDebuggingKt(DirectSplitSoSource.class, strCoroutineDebuggingKt);
                                                        }
                                                        if (strCoroutineDebuggingKt == null) {
                                                            try {
                                                                Object objInvoke9 = Runtime.class.getMethod(str8, null).invoke(null, null);
                                                                if (i5 >= length) {
                                                                    str9 = str5;
                                                                }
                                                                try {
                                                                    Object[] objArr113 = new Object[1];
                                                                    b(null, new byte[]{-106, -116, -125, -116, -107, -114, -108, -126, -125, -112, -119}, MotionEvent.axisFromString("") + 128, null, objArr113);
                                                                    Runtime.class.getMethod((String) objArr113[0], String.class).invoke(objInvoke9, str9);
                                                                    return;
                                                                } catch (Throwable th14) {
                                                                    Throwable cause14 = th14.getCause();
                                                                    if (cause14 == null) {
                                                                        throw th14;
                                                                    }
                                                                    throw cause14;
                                                                }
                                                            } catch (Throwable th15) {
                                                                Throwable cause15 = th15.getCause();
                                                                if (cause15 == null) {
                                                                    throw th15;
                                                                }
                                                                throw cause15;
                                                            }
                                                        }
                                                        try {
                                                            Object[] objArr114 = new Object[1];
                                                            try {
                                                                objArr114[0] = 47;
                                                                Class[] clsArr11 = new Class[1];
                                                                try {
                                                                    clsArr11[0] = Integer.TYPE;
                                                                    try {
                                                                        try {
                                                                            Object[] objArr115 = new Object[1];
                                                                            try {
                                                                                objArr115[0] = Integer.valueOf(((Integer) String.class.getMethod(str6, clsArr11).invoke(strCoroutineDebuggingKt, objArr114)).intValue() + 1);
                                                                                Class[] clsArr12 = new Class[1];
                                                                                try {
                                                                                    clsArr12[0] = Integer.TYPE;
                                                                                    try {
                                                                                        try {
                                                                                            Object[] objArr116 = {objNewInstance2, String.class.getMethod(str7, clsArr12).invoke(strCoroutineDebuggingKt, objArr115)};
                                                                                            try {
                                                                                                Class[] clsArr13 = new Class[2];
                                                                                                try {
                                                                                                    clsArr13[0] = File.class;
                                                                                                    try {
                                                                                                        clsArr13[1] = String.class;
                                                                                                        objNewInstance = File.class.getDeclaredConstructor(clsArr13).newInstance(objArr116);
                                                                                                        try {
                                                                                                            resource = DirectSplitSoSource.class.getClassLoader().getResource(strCoroutineDebuggingKt);
                                                                                                            if (resource == null) {
                                                                                                                try {
                                                                                                                    objArr = new Object[1];
                                                                                                                    b(null, new byte[]{-117, -123, -114, -125, -124, -123, -112, -113}, 127 - ((Process.getThreadPriority(0) + 20) >> 6), null, objArr);
                                                                                                                    if (((Boolean) String.class.getMethod((String) objArr[0], CharSequence.class).invoke(strCoroutineDebuggingKt, "!")).booleanValue()) {
                                                                                                                        StringBuilder sb2 = new StringBuilder();
                                                                                                                        Object[] objArr117 = new Object[1];
                                                                                                                        a(9 - Color.blue(0), new int[]{792246998, -13278780, 610332598, 1151625392, 538961869, -1592169096}, objArr117);
                                                                                                                        sb2.append((String) objArr117[0]);
                                                                                                                        sb2.append(strCoroutineDebuggingKt);
                                                                                                                        String path3 = new URL(sb2.toString()).getPath();
                                                                                                                        try {
                                                                                                                            try {
                                                                                                                                ZipFile zipFile3 = new ZipFile((String) String.class.getMethod(str7, Integer.TYPE, Integer.TYPE).invoke(path3, 5, Integer.valueOf(((Integer) String.class.getMethod(str6, String.class).invoke(path3, "!/")).intValue())));
                                                                                                                                try {
                                                                                                                                    try {
                                                                                                                                        try {
                                                                                                                                            inputStream = zipFile3.getInputStream(zipFile3.getEntry((String) String.class.getMethod(str7, Integer.TYPE).invoke(String.class.getMethod(str7, Integer.TYPE).invoke(strCoroutineDebuggingKt, Integer.valueOf(((Integer) String.class.getMethod(str6, String.class).invoke(strCoroutineDebuggingKt, "!/")).intValue())), 2)));
                                                                                                                                        } catch (Throwable th16) {
                                                                                                                                            Throwable cause16 = th16.getCause();
                                                                                                                                            if (cause16 == null) {
                                                                                                                                                throw th16;
                                                                                                                                            }
                                                                                                                                            throw cause16;
                                                                                                                                        }
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
                                                                                                                    } else {
                                                                                                                        try {
                                                                                                                            inputStream = (InputStream) FileInputStream.class.getDeclaredConstructor(String.class).newInstance(strCoroutineDebuggingKt);
                                                                                                                        } catch (Throwable th21) {
                                                                                                                            Throwable cause21 = th21.getCause();
                                                                                                                            if (cause21 == null) {
                                                                                                                                throw th21;
                                                                                                                            }
                                                                                                                            throw cause21;
                                                                                                                        }
                                                                                                                    }
                                                                                                                } catch (Throwable th22) {
                                                                                                                    Throwable cause22 = th22.getCause();
                                                                                                                    if (cause22 == null) {
                                                                                                                        throw th22;
                                                                                                                    }
                                                                                                                    throw cause22;
                                                                                                                }
                                                                                                            } else {
                                                                                                                String path4 = resource.getPath();
                                                                                                                try {
                                                                                                                    Object[] objArr118 = {"!/" + strCoroutineDebuggingKt};
                                                                                                                    try {
                                                                                                                        Class[] clsArr14 = new Class[1];
                                                                                                                        try {
                                                                                                                            clsArr14[0] = String.class;
                                                                                                                            try {
                                                                                                                                Object[] objArr119 = new Object[2];
                                                                                                                                try {
                                                                                                                                    try {
                                                                                                                                        objArr119[1] = Integer.valueOf(((Integer) String.class.getMethod(str6, clsArr14).invoke(path4, objArr118)).intValue());
                                                                                                                                        try {
                                                                                                                                            objArr119[0] = 5;
                                                                                                                                            try {
                                                                                                                                                Class[] clsArr15 = new Class[2];
                                                                                                                                                clsArr15[0] = Integer.TYPE;
                                                                                                                                                try {
                                                                                                                                                    clsArr15[1] = Integer.TYPE;
                                                                                                                                                    ZipFile zipFile4 = new ZipFile((String) String.class.getMethod(str7, clsArr15).invoke(path4, objArr119));
                                                                                                                                                    inputStream = zipFile4.getInputStream(zipFile4.getEntry(strCoroutineDebuggingKt));
                                                                                                                                                } catch (Throwable th23) {
                                                                                                                                                    th = th23;
                                                                                                                                                    th3 = th;
                                                                                                                                                    cause3 = th3.getCause();
                                                                                                                                                    if (cause3 == null) {
                                                                                                                                                        throw th3;
                                                                                                                                                    }
                                                                                                                                                    throw cause3;
                                                                                                                                                }
                                                                                                                                            } catch (Throwable th24) {
                                                                                                                                                th = th24;
                                                                                                                                                th3 = th;
                                                                                                                                                cause3 = th3.getCause();
                                                                                                                                                if (cause3 == null) {
                                                                                                                                                    throw th3;
                                                                                                                                                }
                                                                                                                                                throw cause3;
                                                                                                                                            }
                                                                                                                                        } catch (Throwable th25) {
                                                                                                                                            th = th25;
                                                                                                                                            th3 = th;
                                                                                                                                            cause3 = th3.getCause();
                                                                                                                                            if (cause3 == null) {
                                                                                                                                                throw th3;
                                                                                                                                            }
                                                                                                                                            throw cause3;
                                                                                                                                        }
                                                                                                                                    } catch (Throwable th26) {
                                                                                                                                        th = th26;
                                                                                                                                    }
                                                                                                                                } catch (Throwable th27) {
                                                                                                                                    th = th27;
                                                                                                                                }
                                                                                                                            } catch (Throwable th28) {
                                                                                                                                th = th28;
                                                                                                                            }
                                                                                                                        } catch (Throwable th29) {
                                                                                                                            th = th29;
                                                                                                                            th2 = th;
                                                                                                                            cause2 = th2.getCause();
                                                                                                                            if (cause2 != null) {
                                                                                                                                throw th2;
                                                                                                                            }
                                                                                                                            throw cause2;
                                                                                                                        }
                                                                                                                    } catch (Throwable th30) {
                                                                                                                        th = th30;
                                                                                                                        th2 = th;
                                                                                                                        cause2 = th2.getCause();
                                                                                                                        if (cause2 != null) {
                                                                                                                            throw th2;
                                                                                                                        }
                                                                                                                        throw cause2;
                                                                                                                    }
                                                                                                                } catch (Throwable th31) {
                                                                                                                    th = th31;
                                                                                                                }
                                                                                                            }
                                                                                                            bufferedInputStream = new BufferedInputStream(inputStream);
                                                                                                            try {
                                                                                                                Object[] objArr210 = {bufferedInputStream};
                                                                                                                objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-175194354);
                                                                                                                if (objAccessartificialFrame == null) {
                                                                                                                    try {
                                                                                                                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(25 - View.combineMeasuredStates(0, 0), (char) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) - 1), 49 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), 1793849606, false, "CoroutineDebuggingKt", new Class[]{InputStream.class});
                                                                                                                    } catch (Throwable th32) {
                                                                                                                        th4 = th32;
                                                                                                                        cause4 = th4.getCause();
                                                                                                                        if (cause4 != null) {
                                                                                                                            throw th4;
                                                                                                                        }
                                                                                                                        throw cause4;
                                                                                                                    }
                                                                                                                }
                                                                                                                try {
                                                                                                                    inputStream2 = (InputStream) ((Method) objAccessartificialFrame).invoke(null, objArr210);
                                                                                                                    if (bufferedInputStream == inputStream2) {
                                                                                                                        inputStream2.close();
                                                                                                                        try {
                                                                                                                            Object objInvoke10 = Runtime.class.getMethod(str8, null).invoke(null, null);
                                                                                                                            try {
                                                                                                                                try {
                                                                                                                                    try {
                                                                                                                                        Object[] objArr211 = {strCoroutineDebuggingKt, DirectSplitSoSource.class.getClassLoader()};
                                                                                                                                        Object[] objArr212 = new Object[1];
                                                                                                                                        a(4 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), new int[]{-1129597954, -221457042}, objArr212);
                                                                                                                                        Method declaredMethod3 = Runtime.class.getDeclaredMethod((String) objArr212[0], String.class, ClassLoader.class);
                                                                                                                                        declaredMethod3.setAccessible(true);
                                                                                                                                        declaredMethod3.invoke(objInvoke10, objArr211);
                                                                                                                                    } catch (Throwable th33) {
                                                                                                                                        Throwable cause23 = th33.getCause();
                                                                                                                                        if (cause23 == null) {
                                                                                                                                            throw th33;
                                                                                                                                        }
                                                                                                                                        throw cause23;
                                                                                                                                    }
                                                                                                                                } catch (Exception unused) {
                                                                                                                                    if (Build.VERSION.SDK_INT <= 27) {
                                                                                                                                        try {
                                                                                                                                            Object objInvoke11 = Runtime.class.getMethod(str8, null).invoke(null, null);
                                                                                                                                            try {
                                                                                                                                                Object[] objArr33 = {strCoroutineDebuggingKt, DirectSplitSoSource.class.getClassLoader()};
                                                                                                                                                Object[] objArr34 = new Object[1];
                                                                                                                                                b(null, new byte[]{-126, -125, -112, -108, -112, -126}, 127 - Color.alpha(0), null, objArr34);
                                                                                                                                                Method declaredMethod4 = Runtime.class.getDeclaredMethod((String) objArr34[0], String.class, ClassLoader.class);
                                                                                                                                                declaredMethod4.setAccessible(true);
                                                                                                                                                declaredMethod4.invoke(objInvoke11, objArr33);
                                                                                                                                            } catch (Throwable th34) {
                                                                                                                                                Throwable cause24 = th34.getCause();
                                                                                                                                                if (cause24 == null) {
                                                                                                                                                    throw th34;
                                                                                                                                                }
                                                                                                                                                throw cause24;
                                                                                                                                            }
                                                                                                                                        } catch (Throwable th35) {
                                                                                                                                            Throwable cause25 = th35.getCause();
                                                                                                                                            if (cause25 == null) {
                                                                                                                                                throw th35;
                                                                                                                                            }
                                                                                                                                            throw cause25;
                                                                                                                                        }
                                                                                                                                    } else {
                                                                                                                                        try {
                                                                                                                                            objInvoke3 = Runtime.class.getMethod(str8, null).invoke(null, null);
                                                                                                                                            classLoader2 = DirectSplitSoSource.class.getClassLoader();
                                                                                                                                            synchronized (objInvoke3) {
                                                                                                                                                try {
                                                                                                                                                    Object[] objArr35 = {strCoroutineDebuggingKt, classLoader2};
                                                                                                                                                    Object[] objArr36 = new Object[1];
                                                                                                                                                    b(null, new byte[]{-126, -125, -112, -108, -122, -115, -114, -124, -125, -123}, (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + WebSocketProtocol.PAYLOAD_SHORT, null, objArr36);
                                                                                                                                                    Method declaredMethod5 = Runtime.class.getDeclaredMethod((String) objArr36[0], String.class, ClassLoader.class);
                                                                                                                                                    declaredMethod5.setAccessible(true);
                                                                                                                                                    str4 = (String) declaredMethod5.invoke(objInvoke3, objArr35);
                                                                                                                                                    if (str4 == null) {
                                                                                                                                                        throw new UnsatisfiedLinkError(str4);
                                                                                                                                                    }
                                                                                                                                                } catch (Throwable th36) {
                                                                                                                                                    Throwable cause26 = th36.getCause();
                                                                                                                                                    if (cause26 == null) {
                                                                                                                                                        throw th36;
                                                                                                                                                    }
                                                                                                                                                    throw cause26;
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        } catch (Throwable th37) {
                                                                                                                                            Throwable cause27 = th37.getCause();
                                                                                                                                            if (cause27 == null) {
                                                                                                                                                throw th37;
                                                                                                                                            }
                                                                                                                                            throw cause27;
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            } catch (NoSuchMethodException unused2) {
                                                                                                                                objInvoke3 = Runtime.class.getMethod(str8, null).invoke(null, null);
                                                                                                                                classLoader2 = DirectSplitSoSource.class.getClassLoader();
                                                                                                                                synchronized (objInvoke3) {
                                                                                                                                    Object[] objArr37 = {strCoroutineDebuggingKt, classLoader2};
                                                                                                                                    Object[] objArr38 = new Object[1];
                                                                                                                                    b(null, new byte[]{-126, -125, -112, -108, -122, -115, -114, -124, -125, -123}, (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + WebSocketProtocol.PAYLOAD_SHORT, null, objArr38);
                                                                                                                                    Method declaredMethod6 = Runtime.class.getDeclaredMethod((String) objArr38[0], String.class, ClassLoader.class);
                                                                                                                                    declaredMethod6.setAccessible(true);
                                                                                                                                    str4 = (String) declaredMethod6.invoke(objInvoke3, objArr37);
                                                                                                                                    if (str4 == null) {
                                                                                                                                        throw new UnsatisfiedLinkError(str4);
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                            str2 = str6;
                                                                                                                            i2 = 0;
                                                                                                                            i4 = 1;
                                                                                                                            r14 = 0;
                                                                                                                        } catch (Throwable th38) {
                                                                                                                            Throwable cause28 = th38.getCause();
                                                                                                                            if (cause28 == null) {
                                                                                                                                throw th38;
                                                                                                                            }
                                                                                                                            throw cause28;
                                                                                                                        }
                                                                                                                    } else {
                                                                                                                        try {
                                                                                                                            Object[] objArr213 = {objNewInstance};
                                                                                                                            try {
                                                                                                                                Class[] clsArr16 = new Class[1];
                                                                                                                                try {
                                                                                                                                    clsArr16[0] = File.class;
                                                                                                                                    OutputStream outputStream2 = (OutputStream) FileOutputStream.class.getDeclaredConstructor(clsArr16).newInstance(objArr213);
                                                                                                                                    bufferedOutputStream = new BufferedOutputStream(outputStream2);
                                                                                                                                    bArr = new byte[1024];
                                                                                                                                    while (true) {
                                                                                                                                        i = inputStream2.read(bArr);
                                                                                                                                        if (i >= 0) {
                                                                                                                                            break;
                                                                                                                                        }
                                                                                                                                        try {
                                                                                                                                            bufferedOutputStream.write(bArr, 0, i);
                                                                                                                                        } catch (Exception e4) {
                                                                                                                                            exc = e4;
                                                                                                                                            str2 = str6;
                                                                                                                                            i2 = 0;
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                    try {
                                                                                                                                        bufferedOutputStream.flush();
                                                                                                                                        try {
                                                                                                                                            str2 = str6;
                                                                                                                                            try {
                                                                                                                                                try {
                                                                                                                                                    Object[] objArr214 = new Object[1];
                                                                                                                                                    a(View.MeasureSpec.getMode(0) + 5, new int[]{51827145, -747333205, -903845071, -262640914}, objArr214);
                                                                                                                                                    try {
                                                                                                                                                        try {
                                                                                                                                                            Object objInvoke12 = FileOutputStream.class.getMethod((String) objArr214[0], null).invoke(outputStream2, null);
                                                                                                                                                            try {
                                                                                                                                                                try {
                                                                                                                                                                    Object[] objArr215 = new Object[1];
                                                                                                                                                                    try {
                                                                                                                                                                        b(null, new byte[]{-113, -123, -106, -117}, 128 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), null, objArr215);
                                                                                                                                                                        try {
                                                                                                                                                                            FileDescriptor.class.getMethod((String) objArr215[0], null).invoke(objInvoke12, null);
                                                                                                                                                                            try {
                                                                                                                                                                                bufferedOutputStream.close();
                                                                                                                                                                                inputStream2.close();
                                                                                                                                                                                try {
                                                                                                                                                                                    Object objInvoke13 = Runtime.class.getMethod(str8, null).invoke(null, null);
                                                                                                                                                                                    try {
                                                                                                                                                                                        try {
                                                                                                                                                                                            Object[] objArr216 = new Object[1];
                                                                                                                                                                                            a(View.combineMeasuredStates(0, 0) + 15, new int[]{603290398, 476923074, -1028958470, -1776496744, 1332184677, -423609601, 1387527132, 1708308371}, objArr216);
                                                                                                                                                                                            try {
                                                                                                                                                                                                try {
                                                                                                                                                                                                    Object[] objArr217 = {File.class.getMethod((String) objArr216[0], null).invoke(objNewInstance, null), DirectSplitSoSource.class.getClassLoader()};
                                                                                                                                                                                                    try {
                                                                                                                                                                                                        Object[] objArr218 = new Object[1];
                                                                                                                                                                                                        a((ViewConfiguration.getKeyRepeatDelay() >> 16) + 4, new int[]{-1129597954, -221457042}, objArr218);
                                                                                                                                                                                                        Method declaredMethod7 = Runtime.class.getDeclaredMethod((String) objArr218[0], String.class, ClassLoader.class);
                                                                                                                                                                                                        declaredMethod7.setAccessible(true);
                                                                                                                                                                                                        declaredMethod7.invoke(objInvoke13, objArr217);
                                                                                                                                                                                                    } catch (Throwable th39) {
                                                                                                                                                                                                        th = th39;
                                                                                                                                                                                                        Throwable th40 = th;
                                                                                                                                                                                                        Throwable cause29 = th40.getCause();
                                                                                                                                                                                                        if (cause29 == null) {
                                                                                                                                                                                                            throw th40;
                                                                                                                                                                                                        }
                                                                                                                                                                                                        throw cause29;
                                                                                                                                                                                                    }
                                                                                                                                                                                                } catch (Throwable th41) {
                                                                                                                                                                                                    th = th41;
                                                                                                                                                                                                }
                                                                                                                                                                                            } catch (Exception unused3) {
                                                                                                                                                                                                try {
                                                                                                                                                                                                    if (Build.VERSION.SDK_INT <= 27) {
                                                                                                                                                                                                        try {
                                                                                                                                                                                                            Object objInvoke14 = Runtime.class.getMethod(str8, null).invoke(null, null);
                                                                                                                                                                                                            try {
                                                                                                                                                                                                                try {
                                                                                                                                                                                                                    Object[] objArr39 = new Object[1];
                                                                                                                                                                                                                    a(16 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), new int[]{603290398, 476923074, -1028958470, -1776496744, 1332184677, -423609601, 1387527132, 1708308371}, objArr39);
                                                                                                                                                                                                                    try {
                                                                                                                                                                                                                        try {
                                                                                                                                                                                                                            Object[] objArr40 = {File.class.getMethod((String) objArr39[0], null).invoke(objNewInstance, null), DirectSplitSoSource.class.getClassLoader()};
                                                                                                                                                                                                                            Object[] objArr41 = new Object[1];
                                                                                                                                                                                                                            b(null, new byte[]{-126, -125, -112, -108, -112, -126}, TextUtils.lastIndexOf("", '0') + 128, null, objArr41);
                                                                                                                                                                                                                            Method declaredMethod8 = Runtime.class.getDeclaredMethod((String) objArr41[0], String.class, ClassLoader.class);
                                                                                                                                                                                                                            declaredMethod8.setAccessible(true);
                                                                                                                                                                                                                            declaredMethod8.invoke(objInvoke14, objArr40);
                                                                                                                                                                                                                        } catch (Throwable th42) {
                                                                                                                                                                                                                            Throwable cause30 = th42.getCause();
                                                                                                                                                                                                                            if (cause30 == null) {
                                                                                                                                                                                                                                throw th42;
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                            throw cause30;
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                    } catch (NoSuchMethodException unused4) {
                                                                                                                                                                                                                        objInvoke = Runtime.class.getMethod(str8, null).invoke(null, null);
                                                                                                                                                                                                                        try {
                                                                                                                                                                                                                            Object[] objArr42 = new Object[1];
                                                                                                                                                                                                                            a(14 - TextUtils.lastIndexOf("", '0'), new int[]{603290398, 476923074, -1028958470, -1776496744, 1332184677, -423609601, 1387527132, 1708308371}, objArr42);
                                                                                                                                                                                                                            objInvoke2 = File.class.getMethod((String) objArr42[0], null).invoke(objNewInstance, null);
                                                                                                                                                                                                                            try {
                                                                                                                                                                                                                                classLoader = DirectSplitSoSource.class.getClassLoader();
                                                                                                                                                                                                                                synchronized (objInvoke) {
                                                                                                                                                                                                                                    try {
                                                                                                                                                                                                                                        Object[] objArr43 = {objInvoke2, classLoader};
                                                                                                                                                                                                                                        try {
                                                                                                                                                                                                                                            try {
                                                                                                                                                                                                                                                Object[] objArr44 = new Object[1];
                                                                                                                                                                                                                                                try {
                                                                                                                                                                                                                                                    b(null, new byte[]{-126, -125, -112, -108, -122, -115, -114, -124, -125, -123}, TextUtils.lastIndexOf("", '0', 0) + 128, null, objArr44);
                                                                                                                                                                                                                                                    String str11 = (String) objArr44[0];
                                                                                                                                                                                                                                                    try {
                                                                                                                                                                                                                                                        Class[] clsArr17 = new Class[2];
                                                                                                                                                                                                                                                        clsArr17[0] = String.class;
                                                                                                                                                                                                                                                        try {
                                                                                                                                                                                                                                                            clsArr17[1] = ClassLoader.class;
                                                                                                                                                                                                                                                            Method declaredMethod9 = Runtime.class.getDeclaredMethod(str11, clsArr17);
                                                                                                                                                                                                                                                            declaredMethod9.setAccessible(true);
                                                                                                                                                                                                                                                            try {
                                                                                                                                                                                                                                                                str3 = (String) declaredMethod9.invoke(objInvoke, objArr43);
                                                                                                                                                                                                                                                                if (str3 == null) {
                                                                                                                                                                                                                                                                    throw new UnsatisfiedLinkError(str3);
                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                try {
                                                                                                                                                                                                                                                                } catch (Throwable th43) {
                                                                                                                                                                                                                                                                    th = th43;
                                                                                                                                                                                                                                                                    throw th;
                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                            } catch (Throwable th44) {
                                                                                                                                                                                                                                                                th = th44;
                                                                                                                                                                                                                                                                th9 = th;
                                                                                                                                                                                                                                                                cause9 = th9.getCause();
                                                                                                                                                                                                                                                                if (cause9 != null) {
                                                                                                                                                                                                                                                                    throw th9;
                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                throw cause9;
                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                        } catch (Throwable th45) {
                                                                                                                                                                                                                                                            th = th45;
                                                                                                                                                                                                                                                            th9 = th;
                                                                                                                                                                                                                                                            cause9 = th9.getCause();
                                                                                                                                                                                                                                                            if (cause9 != null) {
                                                                                                                                                                                                                                                                throw th9;
                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                            throw cause9;
                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                    } catch (Throwable th46) {
                                                                                                                                                                                                                                                        th = th46;
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                } catch (Throwable th47) {
                                                                                                                                                                                                                                                    th = th47;
                                                                                                                                                                                                                                                    th9 = th;
                                                                                                                                                                                                                                                    cause9 = th9.getCause();
                                                                                                                                                                                                                                                    if (cause9 != null) {
                                                                                                                                                                                                                                                        throw th9;
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                    throw cause9;
                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                            } catch (Throwable th48) {
                                                                                                                                                                                                                                                th = th48;
                                                                                                                                                                                                                                                th9 = th;
                                                                                                                                                                                                                                                cause9 = th9.getCause();
                                                                                                                                                                                                                                                if (cause9 != null) {
                                                                                                                                                                                                                                                    throw th9;
                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                throw cause9;
                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                        } catch (Throwable th49) {
                                                                                                                                                                                                                                            th = th49;
                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                    } catch (Throwable th50) {
                                                                                                                                                                                                                                        th = th50;
                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                }
                                                                                                                                                                                                                            } catch (Exception e5) {
                                                                                                                                                                                                                                e = e5;
                                                                                                                                                                                                                                i2 = 0;
                                                                                                                                                                                                                                i4 = 1;
                                                                                                                                                                                                                                pressedStateDuration = 0;
                                                                                                                                                                                                                                exc = e;
                                                                                                                                                                                                                                r14 = pressedStateDuration;
                                                                                                                                                                                                                                if (i5 < length) {
                                                                                                                                                                                                                                    throw exc;
                                                                                                                                                                                                                                }
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                        } catch (Throwable th51) {
                                                                                                                                                                                                                            th = th51;
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                    } catch (Exception e6) {
                                                                                                                                                                                                                        e = e6;
                                                                                                                                                                                                                        exc = e;
                                                                                                                                                                                                                        i2 = 0;
                                                                                                                                                                                                                        i4 = 1;
                                                                                                                                                                                                                        r15 = 0;
                                                                                                                                                                                                                        r14 = r15;
                                                                                                                                                                                                                        if (i5 < length) {
                                                                                                                                                                                                                            throw exc;
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                        i5++;
                                                                                                                                                                                                                        str5 = str;
                                                                                                                                                                                                                        i3 = i2;
                                                                                                                                                                                                                        i2 = i4;
                                                                                                                                                                                                                        r2 = r14;
                                                                                                                                                                                                                        str6 = str2;
                                                                                                                                                                                                                        i4 = 8;
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                } catch (Throwable th52) {
                                                                                                                                                                                                                    th = th52;
                                                                                                                                                                                                                    Throwable th53 = th;
                                                                                                                                                                                                                    Throwable cause31 = th53.getCause();
                                                                                                                                                                                                                    if (cause31 == null) {
                                                                                                                                                                                                                        throw th53;
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                    throw cause31;
                                                                                                                                                                                                                }
                                                                                                                                                                                                            } catch (Throwable th54) {
                                                                                                                                                                                                                th = th54;
                                                                                                                                                                                                            }
                                                                                                                                                                                                        } catch (Throwable th55) {
                                                                                                                                                                                                            Throwable cause32 = th55.getCause();
                                                                                                                                                                                                            if (cause32 == null) {
                                                                                                                                                                                                                throw th55;
                                                                                                                                                                                                            }
                                                                                                                                                                                                            throw cause32;
                                                                                                                                                                                                        }
                                                                                                                                                                                                    }
                                                                                                                                                                                                } catch (NoSuchMethodException unused5) {
                                                                                                                                                                                                } catch (Exception e7) {
                                                                                                                                                                                                    e = e7;
                                                                                                                                                                                                }
                                                                                                                                                                                                try {
                                                                                                                                                                                                    objInvoke = Runtime.class.getMethod(str8, null).invoke(null, null);
                                                                                                                                                                                                    try {
                                                                                                                                                                                                        try {
                                                                                                                                                                                                            Object[] objArr45 = new Object[1];
                                                                                                                                                                                                            a(14 - TextUtils.lastIndexOf("", '0'), new int[]{603290398, 476923074, -1028958470, -1776496744, 1332184677, -423609601, 1387527132, 1708308371}, objArr45);
                                                                                                                                                                                                            try {
                                                                                                                                                                                                                try {
                                                                                                                                                                                                                    objInvoke2 = File.class.getMethod((String) objArr45[0], null).invoke(objNewInstance, null);
                                                                                                                                                                                                                    classLoader = DirectSplitSoSource.class.getClassLoader();
                                                                                                                                                                                                                    try {
                                                                                                                                                                                                                        synchronized (objInvoke) {
                                                                                                                                                                                                                            Object[] objArr46 = {objInvoke2, classLoader};
                                                                                                                                                                                                                            Object[] objArr47 = new Object[1];
                                                                                                                                                                                                                            b(null, new byte[]{-126, -125, -112, -108, -122, -115, -114, -124, -125, -123}, TextUtils.lastIndexOf("", '0', 0) + 128, null, objArr47);
                                                                                                                                                                                                                            String str12 = (String) objArr47[0];
                                                                                                                                                                                                                            Class[] clsArr18 = new Class[2];
                                                                                                                                                                                                                            clsArr18[0] = String.class;
                                                                                                                                                                                                                            clsArr18[1] = ClassLoader.class;
                                                                                                                                                                                                                            Method declaredMethod10 = Runtime.class.getDeclaredMethod(str12, clsArr18);
                                                                                                                                                                                                                            declaredMethod10.setAccessible(true);
                                                                                                                                                                                                                            str3 = (String) declaredMethod10.invoke(objInvoke, objArr46);
                                                                                                                                                                                                                            if (str3 == null) {
                                                                                                                                                                                                                                throw new UnsatisfiedLinkError(str3);
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                        i4 = 1;
                                                                                                                                                                                                                        Object[] objArr219 = new Object[1];
                                                                                                                                                                                                                        r14 = 0;
                                                                                                                                                                                                                        r14 = 0;
                                                                                                                                                                                                                        r14 = 0;
                                                                                                                                                                                                                        b(null, new byte[]{-122, -124, -122, -119, -122, -126}, 127 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), null, objArr219);
                                                                                                                                                                                                                        i2 = 0;
                                                                                                                                                                                                                        ((Boolean) File.class.getMethod((String) objArr219[0], null).invoke(objNewInstance, null)).booleanValue();
                                                                                                                                                                                                                        i5++;
                                                                                                                                                                                                                        str5 = str;
                                                                                                                                                                                                                        i3 = i2;
                                                                                                                                                                                                                        i2 = i4;
                                                                                                                                                                                                                        r2 = r14;
                                                                                                                                                                                                                        str6 = str2;
                                                                                                                                                                                                                        i4 = 8;
                                                                                                                                                                                                                    } catch (Throwable th56) {
                                                                                                                                                                                                                        th = th56;
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                } catch (Throwable th57) {
                                                                                                                                                                                                                    th = th57;
                                                                                                                                                                                                                    th8 = th;
                                                                                                                                                                                                                    cause8 = th8.getCause();
                                                                                                                                                                                                                    if (cause8 == null) {
                                                                                                                                                                                                                        throw th8;
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                    throw cause8;
                                                                                                                                                                                                                }
                                                                                                                                                                                                            } catch (Throwable th58) {
                                                                                                                                                                                                                th = th58;
                                                                                                                                                                                                                th8 = th;
                                                                                                                                                                                                                cause8 = th8.getCause();
                                                                                                                                                                                                                if (cause8 == null) {
                                                                                                                                                                                                                    throw th8;
                                                                                                                                                                                                                }
                                                                                                                                                                                                                throw cause8;
                                                                                                                                                                                                            }
                                                                                                                                                                                                        } catch (Throwable th59) {
                                                                                                                                                                                                            th = th59;
                                                                                                                                                                                                            th8 = th;
                                                                                                                                                                                                            cause8 = th8.getCause();
                                                                                                                                                                                                            if (cause8 == null) {
                                                                                                                                                                                                                throw th8;
                                                                                                                                                                                                            }
                                                                                                                                                                                                            throw cause8;
                                                                                                                                                                                                        }
                                                                                                                                                                                                    } catch (Throwable th60) {
                                                                                                                                                                                                        th = th60;
                                                                                                                                                                                                    }
                                                                                                                                                                                                } catch (Throwable th61) {
                                                                                                                                                                                                    Throwable cause33 = th61.getCause();
                                                                                                                                                                                                    if (cause33 == null) {
                                                                                                                                                                                                        throw th61;
                                                                                                                                                                                                    }
                                                                                                                                                                                                    throw cause33;
                                                                                                                                                                                                }
                                                                                                                                                                                            }
                                                                                                                                                                                        } catch (Throwable th62) {
                                                                                                                                                                                            Throwable cause34 = th62.getCause();
                                                                                                                                                                                            if (cause34 == null) {
                                                                                                                                                                                                throw th62;
                                                                                                                                                                                            }
                                                                                                                                                                                            throw cause34;
                                                                                                                                                                                        }
                                                                                                                                                                                    } catch (Exception unused6) {
                                                                                                                                                                                    }
                                                                                                                                                                                    try {
                                                                                                                                                                                        i4 = 1;
                                                                                                                                                                                        try {
                                                                                                                                                                                            Object[] objArr2110 = new Object[1];
                                                                                                                                                                                            r14 = 0;
                                                                                                                                                                                            r14 = 0;
                                                                                                                                                                                            r14 = 0;
                                                                                                                                                                                            try {
                                                                                                                                                                                                b(null, new byte[]{-122, -124, -122, -119, -122, -126}, 127 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), null, objArr2110);
                                                                                                                                                                                                i2 = 0;
                                                                                                                                                                                                try {
                                                                                                                                                                                                    ((Boolean) File.class.getMethod((String) objArr2110[0], null).invoke(objNewInstance, null)).booleanValue();
                                                                                                                                                                                                } catch (Throwable th63) {
                                                                                                                                                                                                    th = th63;
                                                                                                                                                                                                    th10 = th;
                                                                                                                                                                                                    try {
                                                                                                                                                                                                        cause10 = th10.getCause();
                                                                                                                                                                                                        if (cause10 != null) {
                                                                                                                                                                                                            throw th10;
                                                                                                                                                                                                        }
                                                                                                                                                                                                        throw cause10;
                                                                                                                                                                                                    } catch (Exception unused7) {
                                                                                                                                                                                                    }
                                                                                                                                                                                                }
                                                                                                                                                                                            } catch (Throwable th64) {
                                                                                                                                                                                                th = th64;
                                                                                                                                                                                                i2 = 0;
                                                                                                                                                                                            }
                                                                                                                                                                                        } catch (Throwable th65) {
                                                                                                                                                                                            th = th65;
                                                                                                                                                                                            i2 = 0;
                                                                                                                                                                                            r14 = 0;
                                                                                                                                                                                            th10 = th;
                                                                                                                                                                                            cause10 = th10.getCause();
                                                                                                                                                                                            if (cause10 != null) {
                                                                                                                                                                                                throw th10;
                                                                                                                                                                                            }
                                                                                                                                                                                            throw cause10;
                                                                                                                                                                                        }
                                                                                                                                                                                    } catch (Throwable th66) {
                                                                                                                                                                                        th = th66;
                                                                                                                                                                                        i2 = 0;
                                                                                                                                                                                        i4 = 1;
                                                                                                                                                                                    }
                                                                                                                                                                                } catch (Throwable th67) {
                                                                                                                                                                                    Throwable cause35 = th67.getCause();
                                                                                                                                                                                    if (cause35 == null) {
                                                                                                                                                                                        throw th67;
                                                                                                                                                                                    }
                                                                                                                                                                                    throw cause35;
                                                                                                                                                                                }
                                                                                                                                                                            } catch (Exception e8) {
                                                                                                                                                                                e = e8;
                                                                                                                                                                                pressedStateDuration = 0;
                                                                                                                                                                                i2 = 0;
                                                                                                                                                                                i4 = 1;
                                                                                                                                                                                exc = e;
                                                                                                                                                                                r14 = pressedStateDuration;
                                                                                                                                                                                if (i5 < length) {
                                                                                                                                                                                    throw exc;
                                                                                                                                                                                }
                                                                                                                                                                            }
                                                                                                                                                                        } catch (Throwable th68) {
                                                                                                                                                                            th = th68;
                                                                                                                                                                            th7 = th;
                                                                                                                                                                            cause7 = th7.getCause();
                                                                                                                                                                            if (cause7 != null) {
                                                                                                                                                                                throw th7;
                                                                                                                                                                            }
                                                                                                                                                                            throw cause7;
                                                                                                                                                                        }
                                                                                                                                                                    } catch (Throwable th69) {
                                                                                                                                                                        th = th69;
                                                                                                                                                                    }
                                                                                                                                                                } catch (Throwable th70) {
                                                                                                                                                                    th = th70;
                                                                                                                                                                    th7 = th;
                                                                                                                                                                    cause7 = th7.getCause();
                                                                                                                                                                    if (cause7 != null) {
                                                                                                                                                                        throw th7;
                                                                                                                                                                    }
                                                                                                                                                                    throw cause7;
                                                                                                                                                                }
                                                                                                                                                            } catch (Throwable th71) {
                                                                                                                                                                th = th71;
                                                                                                                                                            }
                                                                                                                                                        } catch (Throwable th72) {
                                                                                                                                                            th = th72;
                                                                                                                                                            th6 = th;
                                                                                                                                                            cause6 = th6.getCause();
                                                                                                                                                            if (cause6 != null) {
                                                                                                                                                                throw th6;
                                                                                                                                                            }
                                                                                                                                                            throw cause6;
                                                                                                                                                        }
                                                                                                                                                    } catch (Throwable th73) {
                                                                                                                                                        th = th73;
                                                                                                                                                        th6 = th;
                                                                                                                                                        cause6 = th6.getCause();
                                                                                                                                                        if (cause6 != null) {
                                                                                                                                                            throw th6;
                                                                                                                                                        }
                                                                                                                                                        throw cause6;
                                                                                                                                                    }
                                                                                                                                                } catch (Throwable th74) {
                                                                                                                                                    th = th74;
                                                                                                                                                    th6 = th;
                                                                                                                                                    cause6 = th6.getCause();
                                                                                                                                                    if (cause6 != null) {
                                                                                                                                                        throw th6;
                                                                                                                                                    }
                                                                                                                                                    throw cause6;
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
                                                                                                                                        }
                                                                                                                                    } catch (Exception e9) {
                                                                                                                                        e = e9;
                                                                                                                                        str2 = str6;
                                                                                                                                        i2 = 0;
                                                                                                                                        i4 = 1;
                                                                                                                                        pressedStateDuration = 0;
                                                                                                                                        exc = e;
                                                                                                                                        r14 = pressedStateDuration;
                                                                                                                                        if (i5 < length) {
                                                                                                                                            throw exc;
                                                                                                                                        }
                                                                                                                                        i5++;
                                                                                                                                        str5 = str;
                                                                                                                                        i3 = i2;
                                                                                                                                        i2 = i4;
                                                                                                                                        r2 = r14;
                                                                                                                                        str6 = str2;
                                                                                                                                        i4 = 8;
                                                                                                                                    }
                                                                                                                                } catch (Throwable th77) {
                                                                                                                                    th = th77;
                                                                                                                                    th5 = th;
                                                                                                                                    cause5 = th5.getCause();
                                                                                                                                    if (cause5 != null) {
                                                                                                                                        throw th5;
                                                                                                                                    }
                                                                                                                                    throw cause5;
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
                                                                                                                    }
                                                                                                                } catch (Throwable th80) {
                                                                                                                    th = th80;
                                                                                                                    th4 = th;
                                                                                                                    cause4 = th4.getCause();
                                                                                                                    if (cause4 != null) {
                                                                                                                        throw th4;
                                                                                                                    }
                                                                                                                    throw cause4;
                                                                                                                }
                                                                                                            } catch (Throwable th81) {
                                                                                                                th = th81;
                                                                                                            }
                                                                                                        } catch (Exception e10) {
                                                                                                            e = e10;
                                                                                                            str2 = str6;
                                                                                                        }
                                                                                                    } catch (Throwable th82) {
                                                                                                        th = th82;
                                                                                                        th = th;
                                                                                                        cause = th.getCause();
                                                                                                        if (cause == null) {
                                                                                                            throw th;
                                                                                                        }
                                                                                                        throw cause;
                                                                                                    }
                                                                                                } catch (Throwable th83) {
                                                                                                    th = th83;
                                                                                                    th = th;
                                                                                                    cause = th.getCause();
                                                                                                    if (cause == null) {
                                                                                                        throw th;
                                                                                                    }
                                                                                                    throw cause;
                                                                                                }
                                                                                            } catch (Throwable th84) {
                                                                                                th = th84;
                                                                                                th = th;
                                                                                                cause = th.getCause();
                                                                                                if (cause == null) {
                                                                                                    throw th;
                                                                                                }
                                                                                                throw cause;
                                                                                            }
                                                                                        } catch (Throwable th85) {
                                                                                            th = th85;
                                                                                        }
                                                                                    } catch (Throwable th86) {
                                                                                        th = th86;
                                                                                        Throwable th87 = th;
                                                                                        Throwable cause36 = th87.getCause();
                                                                                        if (cause36 == null) {
                                                                                            throw th87;
                                                                                        }
                                                                                        throw cause36;
                                                                                    }
                                                                                } catch (Throwable th88) {
                                                                                    th = th88;
                                                                                }
                                                                            } catch (Throwable th89) {
                                                                                th = th89;
                                                                            }
                                                                        } catch (Throwable th90) {
                                                                            th = th90;
                                                                        }
                                                                    } catch (Throwable th91) {
                                                                        th = th91;
                                                                        Throwable th92 = th;
                                                                        Throwable cause37 = th92.getCause();
                                                                        if (cause37 == null) {
                                                                            throw th92;
                                                                        }
                                                                        throw cause37;
                                                                    }
                                                                } catch (Throwable th93) {
                                                                    th = th93;
                                                                }
                                                            } catch (Throwable th94) {
                                                                th = th94;
                                                            }
                                                        } catch (Throwable th95) {
                                                            th = th95;
                                                        }
                                                        e = e2;
                                                        exc = e;
                                                        str2 = str6;
                                                        i2 = 0;
                                                        i4 = 1;
                                                        r15 = 0;
                                                    } catch (Throwable th96) {
                                                        Throwable cause38 = th96.getCause();
                                                        if (cause38 == null) {
                                                            throw th96;
                                                        }
                                                        throw cause38;
                                                    }
                                                } catch (Throwable th97) {
                                                    Throwable cause39 = th97.getCause();
                                                    if (cause39 == null) {
                                                        throw th97;
                                                    }
                                                    throw cause39;
                                                }
                                            } catch (Exception e11) {
                                                exc = e11;
                                                r15 = r2;
                                                str2 = str6;
                                                i4 = i2;
                                                i2 = 0;
                                            }
                                            r14 = r15;
                                            if (i5 < length) {
                                                throw exc;
                                            }
                                        }
                                        i5++;
                                        str5 = str;
                                        i3 = i2;
                                        i2 = i4;
                                        r2 = r14;
                                        str6 = str2;
                                        i4 = 8;
                                    } catch (Throwable th98) {
                                        th = th98;
                                        Throwable th99 = th;
                                        Throwable cause40 = th99.getCause();
                                        if (cause40 == null) {
                                            throw th99;
                                        }
                                        throw cause40;
                                    }
                                } catch (Throwable th100) {
                                    th = th100;
                                }
                            } catch (Throwable th101) {
                                th = th101;
                            }
                        } catch (Exception e12) {
                            e = e12;
                        }
                    } catch (Throwable th102) {
                        Throwable cause41 = th102.getCause();
                        if (cause41 == null) {
                            throw th102;
                        }
                        throw cause41;
                    }
                } catch (Exception e13) {
                    e = e13;
                    pressedStateDuration = r2;
                    str2 = str6;
                    i4 = i2;
                    i2 = i3;
                }
            }
        } catch (Throwable th103) {
            Throwable cause42 = th103.getCause();
            if (cause42 == null) {
                throw th103;
            }
            throw cause42;
        }
    }
}
