package com.facebook.internal;

import android.content.Context;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
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
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.recyclerview.widget.ItemTouchHelper;
import ch.qos.logback.core.CoreConstants;
import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import com.facebook.imageutils.JfifUtil;
import com.google.common.base.Ascii;
import io.sentry.instrumentation.file.SentryFileInputStream;
import io.sentry.instrumentation.file.SentryFileOutputStream;
import io.sentry.rrweb.RRWebEventType;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.security.InvalidParameterException;
import java.util.Date;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
import o.ArtificialStackFrames;
import o.artificialFrame;
import o.asBinder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* JADX INFO: loaded from: classes4.dex */
public final class FileLruCache {
    private static final String HEADER_CACHEKEY_KEY = "key";
    private static final String HEADER_CACHE_CONTENT_TAG_KEY = "tag";
    private final Condition condition;
    private final File directory;
    private boolean isTrimInProgress;
    private boolean isTrimPending;
    private final AtomicLong lastClearCacheTime;
    private final Limits limits;
    private final ReentrantLock lock;
    private final String tag;
    public static final Companion Companion = new Companion(null);
    private static final String TAG = FileLruCache.class.getSimpleName();
    private static final AtomicLong bufferIndex = new AtomicLong();

    interface StreamCloseCallback {
        void onClose();
    }

    public final InputStream get(@NotNull String key) throws IOException {
        Intrinsics.checkNotNullParameter(key, "key");
        return get$default(this, key, null, 2, null);
    }

    public final OutputStream openPutStream(@NotNull String key) throws IOException {
        Intrinsics.checkNotNullParameter(key, "key");
        return openPutStream$default(this, key, null, 2, null);
    }

    public FileLruCache(@NotNull String tag, @NotNull Limits limits) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(limits, "limits");
        this.tag = tag;
        this.limits = limits;
        File file = new File(FacebookSdk.getCacheDir(), tag);
        this.directory = file;
        ReentrantLock reentrantLock = new ReentrantLock();
        this.lock = reentrantLock;
        this.condition = reentrantLock.newCondition();
        this.lastClearCacheTime = new AtomicLong(0L);
        if (file.mkdirs() || file.isDirectory()) {
            BufferFile.INSTANCE.deleteAll(file);
        }
    }

    public final long sizeInBytesForTest() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        while (true) {
            try {
                if (!this.isTrimPending && !this.isTrimInProgress) {
                    break;
                }
                try {
                    this.condition.await();
                } catch (InterruptedException unused) {
                }
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
        Unit unit = Unit.INSTANCE;
        reentrantLock.unlock();
        File[] fileArrListFiles = this.directory.listFiles();
        long length = 0;
        if (fileArrListFiles != null) {
            for (File file : fileArrListFiles) {
                length += file.length();
            }
        }
        return length;
    }

    public static /* synthetic */ InputStream get$default(FileLruCache fileLruCache, String str, String str2, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            str2 = null;
        }
        return fileLruCache.get(str, str2);
    }

    public final InputStream get(@NotNull String key, @Nullable String str) throws IOException {
        Intrinsics.checkNotNullParameter(key, "key");
        File file = new File(this.directory, Utility.md5hash(key));
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(SentryFileInputStream.Factory.create(new FileInputStream(file), file), 8192);
            try {
                JSONObject header = StreamHeader.INSTANCE.readHeader(bufferedInputStream);
                if (header == null) {
                    bufferedInputStream.close();
                    return null;
                }
                if (!Intrinsics.areEqual(header.optString("key"), key)) {
                    bufferedInputStream.close();
                    return null;
                }
                String strOptString = header.optString("tag", null);
                if (str == null && !Intrinsics.areEqual(str, strOptString)) {
                    bufferedInputStream.close();
                    return null;
                }
                long time = new Date().getTime();
                Logger.Companion companion = Logger.Companion;
                LoggingBehavior loggingBehavior = LoggingBehavior.CACHE;
                String TAG2 = TAG;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                companion.log(loggingBehavior, TAG2, "Setting lastModified to " + Long.valueOf(time) + " for " + file.getName());
                file.setLastModified(time);
                return bufferedInputStream;
            } catch (Throwable th) {
                bufferedInputStream.close();
                throw th;
            }
        } catch (IOException unused) {
            return null;
        }
    }

    public static /* synthetic */ OutputStream openPutStream$default(FileLruCache fileLruCache, String str, String str2, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            str2 = null;
        }
        return fileLruCache.openPutStream(str, str2);
    }

    public final OutputStream openPutStream(@NotNull final String key, @Nullable String str) throws IOException {
        Intrinsics.checkNotNullParameter(key, "key");
        final File fileNewFile = BufferFile.INSTANCE.newFile(this.directory);
        fileNewFile.delete();
        if (!fileNewFile.createNewFile()) {
            throw new IOException("Could not create file at " + fileNewFile.getAbsolutePath());
        }
        try {
            FileOutputStream fileOutputStreamCreate = SentryFileOutputStream.Factory.create(new FileOutputStream(fileNewFile), fileNewFile);
            final long jCurrentTimeMillis = System.currentTimeMillis();
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new CloseCallbackOutputStream(fileOutputStreamCreate, new StreamCloseCallback() { // from class: com.facebook.internal.FileLruCache$openPutStream$renameToTargetCallback$1
                @Override // com.facebook.internal.FileLruCache.StreamCloseCallback
                public void onClose() {
                    if (jCurrentTimeMillis >= this.lastClearCacheTime.get()) {
                        this.renameToTargetAndTrim(key, fileNewFile);
                    } else {
                        fileNewFile.delete();
                    }
                }
            }), 8192);
            try {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("key", key);
                    if (!Utility.isNullOrEmpty(str)) {
                        jSONObject.put("tag", str);
                    }
                    StreamHeader.INSTANCE.writeHeader(bufferedOutputStream, jSONObject);
                    return bufferedOutputStream;
                } catch (JSONException e) {
                    Logger.Companion companion = Logger.Companion;
                    LoggingBehavior loggingBehavior = LoggingBehavior.CACHE;
                    String TAG2 = TAG;
                    Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                    companion.log(loggingBehavior, 5, TAG2, "Error creating JSON header for cache file: " + e);
                    throw new IOException(e.getMessage());
                }
            } catch (Throwable th) {
                bufferedOutputStream.close();
                throw th;
            }
        } catch (FileNotFoundException e2) {
            Logger.Companion companion2 = Logger.Companion;
            LoggingBehavior loggingBehavior2 = LoggingBehavior.CACHE;
            String TAG3 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
            companion2.log(loggingBehavior2, 5, TAG3, "Error creating buffer output stream: " + e2);
            throw new IOException(e2.getMessage());
        }
    }

    public final void clearCache() {
        final File[] fileArrListFiles = this.directory.listFiles(BufferFile.INSTANCE.excludeBufferFiles());
        this.lastClearCacheTime.set(System.currentTimeMillis());
        if (fileArrListFiles != null) {
            FacebookSdk.getExecutor().execute(new Runnable() { // from class: com.facebook.internal.FileLruCache$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    FileLruCache.clearCache$lambda$1(fileArrListFiles);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void clearCache$lambda$1(File[] filesToDelete) {
        Intrinsics.checkNotNullExpressionValue(filesToDelete, "filesToDelete");
        for (File file : filesToDelete) {
            file.delete();
        }
    }

    public final String getLocation() {
        String path = this.directory.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "directory.path");
        return path;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renameToTargetAndTrim(String str, File file) {
        if (!file.renameTo(new File(this.directory, Utility.md5hash(str)))) {
            file.delete();
        }
        postTrim();
    }

    public final InputStream interceptAndPut(@NotNull String key, @NotNull InputStream input) throws IOException {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(input, "input");
        return new CopyingInputStream(input, openPutStream$default(this, key, null, 2, null));
    }

    public String toString() {
        return "{FileLruCache: tag:" + this.tag + " file:" + this.directory.getName() + CoreConstants.CURLY_RIGHT;
    }

    private final void postTrim() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (!this.isTrimPending) {
                this.isTrimPending = true;
                FacebookSdk.getExecutor().execute(new Runnable() { // from class: com.facebook.internal.FileLruCache$$ExternalSyntheticLambda1
                    private static final byte[] $$a = {67, 87, 59, -10};
                    private static final int $$b = 235;
                    private static int $10 = 0;
                    private static int $11 = 1;
                    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
                    private static int artificialFrame = 1;
                    private static long extraCommand = -3716519263496967737L;
                    private static int[] ICustomTabsCallbackStub = {-925000931, -576668110, -1408815946, -1381017846, 671601710, -1514948636, 1317581484, 171907459, -124723235, -2136939581, 102652235, -138675467, 681093675, 1338388877, -409378529, 1635905923, 1394885714, -1900585388};

                    /* JADX WARN: Code duplicated, block: B:10:0x0025  */
                    /* JADX WARN: Code duplicated, block: B:8:0x001f  */
                    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x0027). Please report as a decompilation issue!!! */
                    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0025
                        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                        */
                    private static java.lang.String $$c(short r6, int r7, short r8) {
                        /*
                            byte[] r0 = com.facebook.internal.FileLruCache$$ExternalSyntheticLambda1.$$a
                            int r6 = r6 * 4
                            int r6 = r6 + 1
                            int r8 = r8 * 3
                            int r8 = 118 - r8
                            int r7 = r7 * 2
                            int r7 = r7 + 4
                            byte[] r1 = new byte[r6]
                            r2 = 0
                            if (r0 != 0) goto L17
                            r3 = r8
                            r4 = r2
                            r8 = r6
                            goto L27
                        L17:
                            r3 = r2
                        L18:
                            int r4 = r3 + 1
                            byte r5 = (byte) r8
                            r1[r3] = r5
                            if (r4 != r6) goto L25
                            java.lang.String r6 = new java.lang.String
                            r6.<init>(r1, r2)
                            return r6
                        L25:
                            r3 = r0[r7]
                        L27:
                            int r8 = r8 + r3
                            int r7 = r7 + 1
                            r3 = r4
                            goto L18
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.FileLruCache$$ExternalSyntheticLambda1.$$c(short, int, short):java.lang.String");
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        FileLruCache.postTrim$lambda$3$lambda$2(this.f$0);
                    }

                    private static void a(int i, char[] cArr, Object[] objArr) throws Throwable {
                        int i2 = 2 % 2;
                        asBinder asbinder = new asBinder();
                        asbinder.c = i;
                        int length = cArr.length;
                        long[] jArr = new long[length];
                        asbinder.d = 0;
                        int i3 = $11 + 55;
                        $10 = i3 % 128;
                        int i4 = i3 % 2;
                        while (asbinder.d < cArr.length) {
                            int i5 = asbinder.d;
                            try {
                                Object[] objArr2 = {Integer.valueOf(cArr[asbinder.d]), asbinder, asbinder};
                                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1562553046);
                                if (objAccessartificialFrame == null) {
                                    byte b = (byte) 0;
                                    byte b2 = b;
                                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(12 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), (char) (1 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1))), 1407 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), 1035473698, false, $$c(b, b2, b2), new Class[]{Integer.TYPE, Object.class, Object.class});
                                }
                                jArr[i5] = ((Long) ((Method) objAccessartificialFrame).invoke(null, objArr2)).longValue() ^ (extraCommand ^ (-2360974883025274865L));
                                Object[] objArr3 = {asbinder, asbinder};
                                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1981632360);
                                if (objAccessartificialFrame2 == null) {
                                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(TextUtils.indexOf((CharSequence) "", '0', 0) + 9, (char) TextUtils.indexOf("", ""), ((byte) KeyEvent.getModifierMetaStateMask()) + 250, 378009232, false, "w", new Class[]{Object.class, Object.class});
                                }
                                ((Method) objAccessartificialFrame2).invoke(null, objArr3);
                            } catch (Throwable th) {
                                Throwable cause = th.getCause();
                                if (cause == null) {
                                    throw th;
                                }
                                throw cause;
                            }
                        }
                        char[] cArr2 = new char[length];
                        asbinder.d = 0;
                        while (asbinder.d < cArr.length) {
                            int i6 = $10 + 85;
                            $11 = i6 % 128;
                            int i7 = i6 % 2;
                            cArr2[asbinder.d] = (char) jArr[asbinder.d];
                            Object[] objArr4 = {asbinder, asbinder};
                            Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1981632360);
                            if (objAccessartificialFrame3 == null) {
                                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 8, (char) View.MeasureSpec.getSize(0), TextUtils.lastIndexOf("", '0', 0) + ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 378009232, false, "w", new Class[]{Object.class, Object.class});
                            }
                            ((Method) objAccessartificialFrame3).invoke(null, objArr4);
                        }
                        objArr[0] = new String(cArr2);
                    }

                    private static void b(int i, int[] iArr, Object[] objArr) throws Throwable {
                        int length;
                        int[] iArr2;
                        int i2;
                        int i3 = 2 % 2;
                        artificialFrame artificialframe = new artificialFrame();
                        char[] cArr = new char[4];
                        char[] cArr2 = new char[iArr.length * 2];
                        int[] iArr3 = ICustomTabsCallbackStub;
                        int i4 = -1780896814;
                        int i5 = 1;
                        int i6 = 0;
                        if (iArr3 != null) {
                            int i7 = $11 + 35;
                            $10 = i7 % 128;
                            if (i7 % 2 != 0) {
                                length = iArr3.length;
                                iArr2 = new int[length];
                                i2 = 1;
                            } else {
                                length = iArr3.length;
                                iArr2 = new int[length];
                                i2 = 0;
                            }
                            while (i2 < length) {
                                try {
                                    Object[] objArr2 = new Object[1];
                                    objArr2[i6] = Integer.valueOf(iArr3[i2]);
                                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(i4);
                                    if (objAccessartificialFrame == null) {
                                        byte b = (byte) i6;
                                        byte b2 = b;
                                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(10 - MotionEvent.axisFromString(""), (char) Color.argb(i6, i6, i6, i6), 1562 - View.resolveSizeAndState(i6, i6, i6), 180153818, false, $$c(b, b2, (byte) (b2 + 3)), new Class[]{Integer.TYPE});
                                    }
                                    iArr2[i2] = ((Integer) ((Method) objAccessartificialFrame).invoke(null, objArr2)).intValue();
                                    i2++;
                                    i4 = -1780896814;
                                    i6 = 0;
                                } catch (Throwable th) {
                                    Throwable cause = th.getCause();
                                    if (cause == null) {
                                        throw th;
                                    }
                                    throw cause;
                                }
                            }
                            iArr3 = iArr2;
                        }
                        int length2 = iArr3.length;
                        int[] iArr4 = new int[length2];
                        int[] iArr5 = ICustomTabsCallbackStub;
                        long j = 0;
                        if (iArr5 != null) {
                            int length3 = iArr5.length;
                            int[] iArr6 = new int[length3];
                            int i8 = 0;
                            while (i8 < length3) {
                                Object[] objArr3 = new Object[i5];
                                objArr3[0] = Integer.valueOf(iArr5[i8]);
                                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1780896814);
                                if (objAccessartificialFrame2 == null) {
                                    byte b3 = (byte) 0;
                                    byte b4 = b3;
                                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getGlobalActionKeyTimeout() > j ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == j ? 0 : -1)) + 10, (char) View.MeasureSpec.getSize(0), 1562 - (Process.myTid() >> 22), 180153818, false, $$c(b3, b4, (byte) (b4 + 3)), new Class[]{Integer.TYPE});
                                }
                                iArr6[i8] = ((Integer) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).intValue();
                                i8++;
                                iArr5 = iArr5;
                                i5 = 1;
                                j = 0;
                            }
                            iArr5 = iArr6;
                        }
                        System.arraycopy(iArr5, 0, iArr4, 0, length2);
                        artificialframe.e = 0;
                        while (artificialframe.e < iArr.length) {
                            int i9 = $11 + 117;
                            $10 = i9 % 128;
                            int i10 = i9 % 2;
                            cArr[0] = (char) (iArr[artificialframe.e] >> 16);
                            cArr[1] = (char) iArr[artificialframe.e];
                            cArr[2] = (char) (iArr[artificialframe.e + 1] >> 16);
                            cArr[3] = (char) iArr[artificialframe.e + 1];
                            artificialframe.c = (cArr[0] << 16) + cArr[1];
                            artificialframe.b = (cArr[2] << 16) + cArr[3];
                            artificialFrame.coroutineBoundary(iArr4);
                            int i11 = 0;
                            while (i11 < 16) {
                                int i12 = $11 + 41;
                                $10 = i12 % 128;
                                if (i12 % 2 != 0) {
                                    artificialframe.c ^= iArr4[i11];
                                    Object[] objArr4 = {artificialframe, Integer.valueOf(artificialFrame.coroutineBoundary(artificialframe.c)), artificialframe, artificialframe};
                                    Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1540318455);
                                    if (objAccessartificialFrame3 == null) {
                                        byte b5 = (byte) 0;
                                        byte b6 = b5;
                                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(((Process.getThreadPriority(0) + 20) >> 6) + 26, (char) ExpandableListView.getPackedPositionGroup(0L), View.MeasureSpec.makeMeasureSpec(0, 0) + 1041, 995482881, false, $$c(b5, b6, (byte) (b6 + 1)), new Class[]{Object.class, Integer.TYPE, Object.class, Object.class});
                                    }
                                    int iIntValue = ((Integer) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).intValue();
                                    artificialframe.c = artificialframe.b;
                                    artificialframe.b = iIntValue;
                                    i11 += 113;
                                } else {
                                    artificialframe.c ^= iArr4[i11];
                                    Object[] objArr5 = {artificialframe, Integer.valueOf(artificialFrame.coroutineBoundary(artificialframe.c)), artificialframe, artificialframe};
                                    Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1540318455);
                                    if (objAccessartificialFrame4 == null) {
                                        byte b7 = (byte) 0;
                                        byte b8 = b7;
                                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(25 - TextUtils.lastIndexOf("", '0', 0, 0), (char) TextUtils.getCapsMode("", 0, 0), 1041 - View.getDefaultSize(0, 0), 995482881, false, $$c(b7, b8, (byte) (b8 + 1)), new Class[]{Object.class, Integer.TYPE, Object.class, Object.class});
                                    }
                                    int iIntValue2 = ((Integer) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).intValue();
                                    artificialframe.c = artificialframe.b;
                                    artificialframe.b = iIntValue2;
                                    i11++;
                                }
                            }
                            int i13 = artificialframe.c;
                            artificialframe.c = artificialframe.b;
                            artificialframe.b = i13;
                            artificialframe.b ^= iArr4[16];
                            artificialframe.c ^= iArr4[17];
                            int i14 = artificialframe.c;
                            int i15 = artificialframe.b;
                            cArr[0] = (char) (artificialframe.c >>> 16);
                            cArr[1] = (char) artificialframe.c;
                            cArr[2] = (char) (artificialframe.b >>> 16);
                            cArr[3] = (char) artificialframe.b;
                            artificialFrame.coroutineBoundary(iArr4);
                            cArr2[artificialframe.e * 2] = cArr[0];
                            cArr2[(artificialframe.e * 2) + 1] = cArr[1];
                            cArr2[(artificialframe.e * 2) + 2] = cArr[2];
                            cArr2[(artificialframe.e * 2) + 3] = cArr[3];
                            Object[] objArr6 = {artificialframe, artificialframe};
                            Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(1348396126);
                            if (objAccessartificialFrame5 == null) {
                                objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 36, (char) (TextUtils.getOffsetBefore("", 0) + 28010), Drawable.resolveOpacity(0, 0) + 306, -818175402, false, "q", new Class[]{Object.class, Object.class});
                            }
                            ((Method) objAccessartificialFrame5).invoke(null, objArr6);
                        }
                        objArr[0] = new String(cArr2, 0, i);
                    }

                    public static Object[] accessartificialFrame(Context context, int i, int i2) {
                        Object[] objArr;
                        char c;
                        Object[] objArr2;
                        Object obj;
                        Object obj2;
                        int i3;
                        int i4;
                        Object[] objArr3;
                        Method method;
                        Class<?> cls;
                        String str;
                        Class<?>[] clsArr;
                        char c2;
                        int i5;
                        int i6;
                        int i7;
                        int i8;
                        int i9;
                        int i10;
                        int i11;
                        String str2 = "";
                        int i12 = 2;
                        int i13 = 2 % 2;
                        int i14 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                        int i15 = (i14 & 97) + (i14 | 97);
                        artificialFrame = i15 % 128;
                        if (i15 % 2 == 0) {
                            throw null;
                        }
                        if (context == null) {
                            int[] iArr = new int[1];
                            Object[] objArr4 = {new int[]{i}, new int[]{i}, iArr, null};
                            int i16 = ~i;
                            int i17 = (-120974004) + (((~((-776415958) | i16)) | 202207817) * 519) + (((~((-574752917) | i16)) | (~(776960733 | i))) * (-519)) + (((~(i | 202207817)) | 776415957) * 519);
                            int i18 = i14 + 73;
                            int i19 = i18 % 128;
                            artificialFrame = i19;
                            if (i18 % 2 == 0) {
                                int i20 = -((-565) - i17);
                                i11 = (567 & i20) + (i20 | 567);
                            } else {
                                i11 = (-1) - (~(-(-(i17 * (-565)))));
                            }
                            int i21 = ~(((-1) ^ i17) | i17);
                            int i22 = ~(((-1) ^ i) | i);
                            int i23 = -(-((-566) * ((i21 & i22) | (i21 ^ i22))));
                            int i24 = ((i11 | i23) << 1) - (i23 ^ i11);
                            int i25 = -(-((~(~i17)) * 566));
                            int i26 = ((i24 | i25) << 1) - (i25 ^ i24);
                            int i27 = ~i17;
                            int i28 = i26 + ((~(i27 | ((-1) ^ i27) | i)) * 566);
                            int i29 = i19 + 39;
                            getARTIFICIAL_FRAME_PACKAGE_NAME = i29 % 128;
                            int i30 = i29 % 2;
                            int i31 = ~((i28 ^ i2) | (i28 & i2));
                            int i32 = ~(i28 | i);
                            int i33 = (i31 & i32) | (i31 ^ i32);
                            int i34 = ~(i2 | i);
                            int i35 = (((i28 * (-743)) + (i2 * (-743))) - (~(((i33 & i34) | (i33 ^ i34)) * (-744)))) - 1;
                            int i36 = ~((~i28) | (~i2));
                            int i37 = ((i16 & i36) | (i16 ^ i36)) * 744;
                            int i38 = (i35 ^ i37) + ((i37 & i35) << 1);
                            int i39 = i2 | i28;
                            int i40 = (i & i39) | (i39 ^ i);
                            int i41 = (i19 & 11) + (i19 | 11);
                            getARTIFICIAL_FRAME_PACKAGE_NAME = i41 % 128;
                            int i42 = i41 % 2;
                            int i43 = 744 * i40;
                            int i44 = ((i38 | i43) << 1) - (i43 ^ i38);
                            int i45 = i44 << 13;
                            int i46 = ((~i44) & i45) | ((~i45) & i44);
                            int i47 = i46 >>> 17;
                            int i48 = ((~i46) & i47) | ((~i47) & i46);
                            int i49 = i48 << 5;
                            iArr[0] = (i48 | i49) & (~(i48 & i49));
                            return objArr4;
                        }
                        try {
                            Object[] objArr5 = new Object[1];
                            a((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 18803, new char[]{20898, 6362, 50008, 36336, 29820, 16089, 59657, 21384, 6707, 50358, 36804, 30288, 8408, 60262, 21932, 7188, 50829, 45343, 31670, 8815, 60748, 22418, 7706, 51373, 45870, 32171, 9299, 61145, 22892, 927, 51904, 46412, 32710, 9848, 37095, 23297, 1413, 52283}, objArr5);
                            String str3 = (String) objArr5[0];
                            int i50 = artificialFrame;
                            int i51 = (i50 ^ 1) + ((i50 & 1) << 1);
                            getARTIFICIAL_FRAME_PACKAGE_NAME = i51 % 128;
                            if (i51 % 2 != 0) {
                                objArr = (Object[]) Array.newInstance(Class.forName(str3), 2);
                                c = 1;
                            } else {
                                objArr = (Object[]) Array.newInstance(Class.forName(str3), 2);
                                c = 0;
                            }
                            Object[] objArr6 = new Object[1];
                            a(Color.red(0) + 52561, new char[]{20875, 40151, 52055, 13946, 25826, 21305, 40540, 52368, 15145, 26229, 21698, 33783, 52833, 15543, 27603, 22032, 34036, 62438, 15943, 27786, 23538, 34313, 62796, 9184, 28217, 23877, 35806, 62976, 9513, 5040, 24293}, objArr6);
                            String str4 = (String) objArr6[0];
                            int i52 = getARTIFICIAL_FRAME_PACKAGE_NAME + 43;
                            artificialFrame = i52 % 128;
                            try {
                                if (i52 % 2 == 0) {
                                    objArr2 = new Object[0];
                                    objArr2[1] = str4;
                                    Object[] objArr7 = new Object[1];
                                    a(23251 >> View.combineMeasuredStates(1, 1), new char[]{20898, 6362, 50008, 36336, 29820, 16089, 59657, 21384, 6707, 50358, 36804, 30288, 8408, 60262, 21932, 7188, 50829, 45343, 31670, 8815, 60748, 22418, 7706, 51373, 45870, 32171, 9299, 61145, 22892, 927, 51904, 46412, 32710, 9848, 37095, 23297, 1413, 52283}, objArr7);
                                    obj = objArr7[0];
                                } else {
                                    objArr2 = new Object[]{str4};
                                    Object[] objArr8 = new Object[1];
                                    a(View.combineMeasuredStates(0, 0) + 18803, new char[]{20898, 6362, 50008, 36336, 29820, 16089, 59657, 21384, 6707, 50358, 36804, 30288, 8408, 60262, 21932, 7188, 50829, 45343, 31670, 8815, 60748, 22418, 7706, 51373, 45870, 32171, 9299, 61145, 22892, 927, 51904, 46412, 32710, 9848, 37095, 23297, 1413, 52283}, objArr8);
                                    obj = objArr8[0];
                                }
                                objArr[c] = Class.forName((String) obj).getDeclaredConstructor(String.class).newInstance(objArr2);
                                int i53 = -(ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1));
                                int i54 = i53 * (-167);
                                int i55 = (i54 ^ (-5344)) + ((i54 & (-5344)) << 1);
                                int i56 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                int i57 = (i56 & 73) + (i56 | 73);
                                int i58 = i57 % 128;
                                artificialFrame = i58;
                                int i59 = i57 % 2;
                                int i60 = ~i53;
                                int i61 = ~((i60 ^ (-33)) | (i60 & (-33)));
                                int i62 = ~i;
                                int i63 = ~((-33) | i62);
                                int i64 = -(-(((i61 ^ i63) | (i63 & i61)) * 168));
                                int i65 = (i55 & i64) + (i64 | i55);
                                int i66 = ~i53;
                                int i67 = (i66 ^ (-33)) | (i66 & (-33));
                                int i68 = (~((i67 ^ i) | (i67 & i))) * 168;
                                int i69 = (i65 ^ i68) + ((i68 & i65) << 1);
                                int i70 = (~(i66 | 32)) | (~((i60 ^ i62) | (i60 & i62)));
                                int i71 = i58 + 13;
                                getARTIFICIAL_FRAME_PACKAGE_NAME = i71 % 128;
                                if (i71 % 2 != 0) {
                                    int i72 = ~((i53 & (-33)) | ((-33) ^ i53) | i);
                                    Object[] objArr9 = new Object[1];
                                    b(i69 + (168 / ((i72 & i70) | (i70 ^ i72))), new int[]{1476163700, -411257383, 759378897, 1726876273, 2130382293, 1202638140, -1506783724, 553272257, -379144550, 1039622360, 1586491758, -796651089, 619372216, -1854826300, 1829877900, 1158564835}, objArr9);
                                    obj2 = objArr9[0];
                                } else {
                                    int i73 = -(-(((~((i53 & (-33)) | ((-33) ^ i53) | i)) | i70) * 168));
                                    Object[] objArr10 = new Object[1];
                                    b((i69 ^ i73) + ((i69 & i73) << 1), new int[]{1476163700, -411257383, 759378897, 1726876273, 2130382293, 1202638140, -1506783724, 553272257, -379144550, 1039622360, 1586491758, -796651089, 619372216, -1854826300, 1829877900, 1158564835}, objArr10);
                                    obj2 = objArr10[0];
                                }
                                try {
                                    Object[] objArr11 = new Object[1];
                                    a(Color.green(0) + 18803, new char[]{20898, 6362, 50008, 36336, 29820, 16089, 59657, 21384, 6707, 50358, 36804, 30288, 8408, 60262, 21932, 7188, 50829, 45343, 31670, 8815, 60748, 22418, 7706, 51373, 45870, 32171, 9299, 61145, 22892, 927, 51904, 46412, 32710, 9848, 37095, 23297, 1413, 52283}, objArr11);
                                    objArr[1] = Class.forName((String) objArr11[0]).getDeclaredConstructor(String.class).newInstance((String) obj2);
                                    int i74 = artificialFrame;
                                    int i75 = (i74 & AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY) + (i74 | AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY);
                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i75 % 128;
                                    int i76 = i75 % 2;
                                    try {
                                        Object[] objArr12 = new Object[1];
                                        a((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 36696, new char[]{20905, 57087, 20254, 65457, 27843, 40220, 3514, 47753, 11107, 23430, 51420, 31087, 59777, 5667, 34658, 14289, 42011, 54606, 17892, 61991, 25433, 37885, 26}, objArr12);
                                        Class<?> cls2 = Class.forName((String) objArr12[0]);
                                        int i77 = -(ViewConfiguration.getPressedStateDuration() >> 16);
                                        int i78 = (i77 * 829) + 41115913;
                                        int i79 = ~i77;
                                        int i80 = ~((i79 ^ (-49598)) | (i79 & (-49598)));
                                        int i81 = ~i;
                                        int i82 = (i81 ^ i77) | (i81 & i77);
                                        int i83 = -(-(((~((i82 ^ 49597) | (i82 & 49597))) | i80) * (-828)));
                                        int i84 = ((i78 | i83) << 1) - (i83 ^ i78);
                                        int i85 = i77 | 49597;
                                        int i86 = ((i85 & i81) | (i85 ^ i81)) * (-828);
                                        int i87 = (i84 ^ i86) + ((i86 & i84) << 1);
                                        int i88 = -(-((~((i77 ^ 49597) | (i77 & 49597))) * 828));
                                        Object[] objArr13 = new Object[1];
                                        a(((i87 | i88) << 1) - (i88 ^ i87), new char[]{20911, 36880, 53958, 5295, 22365, 39194, 56269, 7554, 23623, 40456, 49383, 694, 17786, 34608, 51705, 3006, 19050}, objArr13);
                                        Object objInvoke = cls2.getMethod((String) objArr13[0], null).invoke(context, null);
                                        int i89 = artificialFrame;
                                        int i90 = (i89 ^ 107) + ((i89 & 107) << 1);
                                        getARTIFICIAL_FRAME_PACKAGE_NAME = i90 % 128;
                                        int i91 = i90 % 2;
                                        try {
                                            int i92 = -(ViewConfiguration.getDoubleTapTimeout() >> 16);
                                            int iMediaBrowserCompatMediaBrowserImplApi217 = RRWebEventType.Deserializer.MediaBrowserCompatMediaBrowserImplApi217();
                                            int i93 = (i92 * (-500)) - 18348500;
                                            int i94 = ~(((-36698) ^ i92) | ((-36698) & i92));
                                            int i95 = ~i92;
                                            int i96 = i95 | 36697;
                                            int i97 = artificialFrame + 117;
                                            getARTIFICIAL_FRAME_PACKAGE_NAME = i97 % 128;
                                            if (i97 % 2 != 0) {
                                                int i98 = ~((i96 ^ iMediaBrowserCompatMediaBrowserImplApi217) | (i96 & iMediaBrowserCompatMediaBrowserImplApi217));
                                                i3 = i93 - (TypedValues.PositionType.TYPE_TRANSITION_EASING >> ((i94 ^ i98) | (i98 & i94)));
                                                i4 = ~i92;
                                            } else {
                                                int i99 = ~(i96 | iMediaBrowserCompatMediaBrowserImplApi217);
                                                int i100 = -(-(((i99 & i94) | (i94 ^ i99)) * TypedValues.PositionType.TYPE_TRANSITION_EASING));
                                                i3 = (i93 & i100) + (i100 | i93);
                                                i4 = i95;
                                            }
                                            int i101 = -(-(1002 * (~(i4 | (-36698)))));
                                            int i102 = (i3 & i101) + (i101 | i3);
                                            int i103 = ~iMediaBrowserCompatMediaBrowserImplApi217;
                                            int i104 = -(-((~((i103 & i95) | (i95 ^ i103) | 36697)) * TypedValues.PositionType.TYPE_TRANSITION_EASING));
                                            int i105 = ((i102 | i104) << 1) - (i104 ^ i102);
                                            Object[] objArr14 = new Object[1];
                                            a(i105, new char[]{20905, 57087, 20254, 65457, 27843, 40220, 3514, 47753, 11107, 23430, 51420, 31087, 59777, 5667, 34658, 14289, 42011, 54606, 17892, 61991, 25433, 37885, 26}, objArr14);
                                            Class<?> cls3 = Class.forName((String) objArr14[0]);
                                            int i106 = getARTIFICIAL_FRAME_PACKAGE_NAME + 13;
                                            artificialFrame = i106 % 128;
                                            if (i106 % 2 == 0) {
                                                Object[] objArr15 = new Object[1];
                                                a(53197 >>> (ViewConfiguration.getDoubleTapTimeout() % 69), new char[]{20911, 40544, 52774, 16127, 28317, 24234, 36717, 65330, 12231, 8088, 20356, 48230, 60473, 56516}, objArr15);
                                                method = cls3.getMethod((String) objArr15[0], null);
                                                objArr3 = null;
                                            } else {
                                                Object[] objArr16 = new Object[1];
                                                a(53197 - (ViewConfiguration.getDoubleTapTimeout() >> 16), new char[]{20911, 40544, 52774, 16127, 28317, 24234, 36717, 65330, 12231, 8088, 20356, 48230, 60473, 56516}, objArr16);
                                                objArr3 = null;
                                                method = cls3.getMethod((String) objArr16[0], null);
                                            }
                                            try {
                                                Object[] objArr17 = {method.invoke(context, objArr3), 64};
                                                int iIndexOf = TextUtils.indexOf((CharSequence) "", '0', 0, 0);
                                                int i107 = artificialFrame;
                                                int i108 = ((i107 | 59) << 1) - (i107 ^ 59);
                                                getARTIFICIAL_FRAME_PACKAGE_NAME = i108 % 128;
                                                if (i108 % 2 != 0) {
                                                    Object[] objArr18 = new Object[1];
                                                    b(32 / iIndexOf, new int[]{421357970, -1828304861, -1685463884, 1646916254, -1353928794, 1759502779, 957377787, 1401540880, -1321239568, 907971967, 832496209, 1863970770, -64134686, -2060038085, 1053919384, 965855839, 611310991, 1557463661}, objArr18);
                                                    cls = Class.forName((String) objArr18[0]);
                                                    int i109 = -(SystemClock.uptimeMillis() > 1L ? 1 : (SystemClock.uptimeMillis() == 1L ? 0 : -1));
                                                    Object[] objArr19 = new Object[1];
                                                    b((i109 ^ 86) + ((i109 & 86) << 1), new int[]{-968709898, 2138391638, 832496209, 1863970770, -63752682, -1102432843, 1715239481, -218595872}, objArr19);
                                                    str = (String) objArr19[0];
                                                    clsArr = new Class[2];
                                                    c2 = 1;
                                                } else {
                                                    Object[] objArr20 = new Object[1];
                                                    b(31 - (~(-iIndexOf)), new int[]{421357970, -1828304861, -1685463884, 1646916254, -1353928794, 1759502779, 957377787, 1401540880, -1321239568, 907971967, 832496209, 1863970770, -64134686, -2060038085, 1053919384, 965855839, 611310991, 1557463661}, objArr20);
                                                    cls = Class.forName((String) objArr20[0]);
                                                    Object[] objArr21 = new Object[1];
                                                    b(15 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), new int[]{-968709898, 2138391638, 832496209, 1863970770, -63752682, -1102432843, 1715239481, -218595872}, objArr21);
                                                    str = (String) objArr21[0];
                                                    clsArr = new Class[2];
                                                    c2 = 0;
                                                }
                                                clsArr[c2] = String.class;
                                                clsArr[1] = Integer.TYPE;
                                                Object objInvoke2 = cls.getMethod(str, clsArr).invoke(objInvoke, objArr17);
                                                int i110 = 29 - (~(-(-TextUtils.indexOf("", "", 0))));
                                                int i111 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                                int i112 = (i111 ^ 51) + ((i111 & 51) << 1);
                                                artificialFrame = i112 % 128;
                                                int i113 = i112 % 2;
                                                Object[] objArr22 = new Object[1];
                                                b(i110, new int[]{421357970, -1828304861, -1685463884, 1646916254, -1353928794, 1759502779, 957377787, 1401540880, -1321239568, 907971967, 832496209, 1863970770, -63752682, -1102432843, 1715239481, -218595872}, objArr22);
                                                Class<?> cls4 = Class.forName((String) objArr22[0]);
                                                int i114 = -TextUtils.indexOf((CharSequence) "", '0', 0);
                                                int i115 = i114 * 483;
                                                int i116 = ((i115 | 2178) << 1) - (i115 ^ 2178);
                                                int i117 = ~i114;
                                                int i118 = ~((i117 & (-10)) | (i117 ^ (-10)));
                                                int i119 = ~i114;
                                                int i120 = ~((i119 ^ i62) | (i119 & i62));
                                                int i121 = ((i118 & i120) | (i118 ^ i120)) * (-241);
                                                int i122 = (i116 ^ i121) + ((i121 & i116) << 1);
                                                int i123 = -(-(((i114 ^ 9) | (i114 & 9)) * (-482)));
                                                int i124 = (i119 ^ i81) | (i119 & i81);
                                                int i125 = (i122 ^ i123) + ((i123 & i122) << 1) + (((~((i114 & (-10)) | ((-10) ^ i114))) | (~((i124 & 9) | (i124 ^ 9)))) * 241);
                                                int[] iArr2 = {87620849, -1785562427, 1916144947, -155301881, -898853039, -1799524937};
                                                int i126 = artificialFrame + 117;
                                                getARTIFICIAL_FRAME_PACKAGE_NAME = i126 % 128;
                                                int i127 = i126 % 2;
                                                Object[] objArr23 = new Object[1];
                                                b(i125, iArr2, objArr23);
                                                Object[] objArr24 = (Object[]) cls4.getField((String) objArr23[0]).get(objInvoke2);
                                                int length = objArr24.length;
                                                int i128 = 0;
                                                while (i128 < length) {
                                                    int i129 = getARTIFICIAL_FRAME_PACKAGE_NAME + 21;
                                                    artificialFrame = i129 % 128;
                                                    int i130 = i129 % i12;
                                                    Object obj3 = objArr24[i128];
                                                    int i131 = -(ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1));
                                                    int i132 = (i131 * 141) - 7336026;
                                                    int iMediaBrowserCompatMediaBrowserImplApi218 = RRWebEventType.Deserializer.MediaBrowserCompatMediaBrowserImplApi217();
                                                    int i133 = ((-2008022368) & iMediaBrowserCompatMediaBrowserImplApi218) | (iMediaBrowserCompatMediaBrowserImplApi218 ^ (-2008022368));
                                                    int i134 = (-1248112093) + (((i133 ^ 1946182733) | (i133 & 1946182733)) * 614);
                                                    int i135 = ~iMediaBrowserCompatMediaBrowserImplApi218;
                                                    int i136 = ~((1988453709 ^ i135) | (1988453709 & i135));
                                                    int i137 = (i136 ^ (-2008022368)) | (i136 & (-2008022368));
                                                    int i138 = ~((i135 ^ 1965751391) | (i135 & 1965751391));
                                                    int i139 = i134 + (((i137 ^ i138) | (i137 & i138)) * (-1228));
                                                    int i140 = ~iMediaBrowserCompatMediaBrowserImplApi218;
                                                    int i141 = ~(((-19568659) & i140) | ((-19568659) ^ i140));
                                                    int i142 = (i140 ^ (-1988453710)) | (i140 & (-1988453710));
                                                    int i143 = ~((i142 & 1965751391) | (i142 ^ 1965751391));
                                                    int i144 = ((i143 & i141) | (i141 ^ i143)) * 614;
                                                    int i145 = ((i139 | i144) << 1) - (i144 ^ i139);
                                                    int iMediaBrowserCompatMediaBrowserImplApi219 = RRWebEventType.Deserializer.MediaBrowserCompatMediaBrowserImplApi217();
                                                    int i146 = ~(1492793133 | (~iMediaBrowserCompatMediaBrowserImplApi219));
                                                    int i147 = -(-((((-503197457) ^ i146) | (i146 & (-503197457))) * (-865)));
                                                    int i148 = ((-944603036) ^ i147) + ((i147 & (-944603036)) << 1);
                                                    int i149 = -(-((~(((-1492793134) ^ iMediaBrowserCompatMediaBrowserImplApi219) | ((-1492793134) & iMediaBrowserCompatMediaBrowserImplApi219))) * 865));
                                                    int i150 = (i148 ^ i149) + ((i148 & i149) << 1);
                                                    int i151 = ~iMediaBrowserCompatMediaBrowserImplApi219;
                                                    if (i145 <= (i150 - (~(((~((i151 ^ (-1492793134)) | (i151 & (-1492793134)))) | (~(((-503197457) ^ i151) | ((-503197457) & i151)))) * 865))) - 1) {
                                                        i5 = i132 >>> (140 % ((i ^ 26294) | (i & 26294)));
                                                        int i152 = ~i131;
                                                        i6 = (i152 & 26294) | (i152 ^ 26294);
                                                    } else {
                                                        int i153 = -(-(((i ^ 26294) | (i & 26294)) * 140));
                                                        i5 = ((i132 | i153) << 1) - (i132 ^ i153);
                                                        i6 = (~i131) | 26294;
                                                    }
                                                    int i154 = ~i6;
                                                    int i155 = ~(i62 | 26294);
                                                    int i156 = (i5 - (~(-(-((-280) * ((i154 & i155) | (i154 ^ i155))))))) - 1;
                                                    int i157 = ~(((-26295) & i131) | ((-26295) ^ i131));
                                                    int i158 = ~((i62 ^ i131) | (i62 & i131));
                                                    int i159 = ~i131;
                                                    int i160 = -(-(((~((i159 & 26294) | (i159 ^ 26294) | i)) | (i157 & i158) | (i157 ^ i158)) * 140));
                                                    Object[] objArr25 = new Object[1];
                                                    a(((i156 | i160) << 1) - (i160 ^ i156), new char[]{20880, 14163, 40087, 26087, 52005}, objArr25);
                                                    try {
                                                        Object[] objArr26 = {(String) objArr25[0]};
                                                        Object[] objArr27 = new Object[1];
                                                        a(43038 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), new char[]{20898, 63924, 388, 43518, 61842, 6442, 41219, 51552, 4437, 47295, 49283, 26755, 45293, 55455, 24637, 34846, 53354, 30801, 33772, 11180, 29673, 39899, 9154, 19258, 37654, 15220, 17241, 60070, 12944, 23268, 58088, 2602, 21003, 64001, 637, 43597, 62885}, objArr27);
                                                        Class<?> cls5 = Class.forName((String) objArr27[0]);
                                                        int i161 = (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1));
                                                        int iMediaBrowserCompatMediaBrowserImplApi2110 = RRWebEventType.Deserializer.MediaBrowserCompatMediaBrowserImplApi217();
                                                        int i162 = i161 * (-500);
                                                        int i163 = ((i162 | (-3801000)) << 1) - (i162 ^ (-3801000));
                                                        int i164 = ~((-7603) | i161);
                                                        int i165 = ~i161;
                                                        Object[] objArr28 = objArr24;
                                                        int i166 = (i165 ^ 7602) | (i165 & 7602);
                                                        int i167 = i163 + (((~((i166 & iMediaBrowserCompatMediaBrowserImplApi2110) | (i166 ^ iMediaBrowserCompatMediaBrowserImplApi2110))) | i164) * TypedValues.PositionType.TYPE_TRANSITION_EASING);
                                                        int i168 = ~i161;
                                                        int i169 = i167 + ((~((i168 ^ (-7603)) | (i168 & (-7603)))) * 1002);
                                                        int i170 = i168 | (~iMediaBrowserCompatMediaBrowserImplApi2110);
                                                        int i171 = (~((i170 & 7602) | (i170 ^ 7602))) * TypedValues.PositionType.TYPE_TRANSITION_EASING;
                                                        Object[] objArr29 = new Object[1];
                                                        a(((i169 | i171) << 1) - (i169 ^ i171), new char[]{20911, 19486, 27354, 2200, 10090, 50628, 58254, 40524, 48190, 23264, 31059}, objArr29);
                                                        Object objInvoke3 = cls5.getMethod((String) objArr29[0], String.class).invoke(null, objArr26);
                                                        try {
                                                            Object[] objArr30 = new Object[1];
                                                            b(((byte) KeyEvent.getModifierMetaStateMask()) + Ascii.GS, new int[]{421357970, -1828304861, -1685463884, 1646916254, -1353928794, 1759502779, 957377787, 1401540880, -1265537005, 1228957062, 963721851, 1434019982, -1889462346, 249608533}, objArr30);
                                                            Class<?> cls6 = Class.forName((String) objArr30[0]);
                                                            int capsMode = TextUtils.getCapsMode(str2, 0, 0);
                                                            int i172 = (capsMode * 784) - 14985466;
                                                            int i173 = ((i172 | 15005412) << 1) - (i172 ^ 15005412);
                                                            int i174 = getARTIFICIAL_FRAME_PACKAGE_NAME + 79;
                                                            artificialFrame = i174 % 128;
                                                            int i175 = i174 % 2;
                                                            int i176 = ~capsMode;
                                                            int i177 = (i176 & i62) | (i176 ^ i62);
                                                            int i178 = (-783) * (~((i177 & 19163) | (i177 ^ 19163)));
                                                            int i179 = (i173 ^ i178) + ((i178 & i173) << 1);
                                                            int i180 = ~capsMode;
                                                            int i181 = ~((i81 ^ 19163) | (i81 & 19163));
                                                            int i182 = -(-(((i180 & i181) | (i180 ^ i181)) * 783));
                                                            Object[] objArr31 = new Object[1];
                                                            a((i179 ^ i182) + ((i179 & i182) << 1), new char[]{20924, 7036, 50236, 45344, 31440, 10218, 37035, 23111, 1890, 61466, 48447}, objArr31);
                                                            try {
                                                                Object[] objArr32 = {new ByteArrayInputStream((byte[]) cls6.getMethod((String) objArr31[0], null).invoke(obj3, null))};
                                                                char mirror = AndroidCharacter.getMirror('0');
                                                                Object[] objArr33 = new Object[1];
                                                                a((mirror & 42989) + (mirror | 42989), new char[]{20898, 63924, 388, 43518, 61842, 6442, 41219, 51552, 4437, 47295, 49283, 26755, 45293, 55455, 24637, 34846, 53354, 30801, 33772, 11180, 29673, 39899, 9154, 19258, 37654, 15220, 17241, 60070, 12944, 23268, 58088, 2602, 21003, 64001, 637, 43597, 62885}, objArr33);
                                                                Class<?> cls7 = Class.forName((String) objArr33[0]);
                                                                int offsetAfter = TextUtils.getOffsetAfter(str2, 0);
                                                                int i183 = offsetAfter * 141;
                                                                int i184 = (i183 & (-2641)) + (i183 | (-2641));
                                                                int i185 = ~offsetAfter;
                                                                int i186 = ~((i185 & 19) | (i185 ^ 19));
                                                                int i187 = ~offsetAfter;
                                                                int i188 = getARTIFICIAL_FRAME_PACKAGE_NAME + 125;
                                                                String str5 = str2;
                                                                int i189 = i188 % 128;
                                                                artificialFrame = i189;
                                                                int i190 = length;
                                                                if (i188 % 2 == 0) {
                                                                    i7 = ~((i187 ^ i) | (i187 & i));
                                                                    i8 = i184 >> ((-280) % ((i186 ^ i7) | (i186 & i7)));
                                                                } else {
                                                                    i7 = ~((i187 ^ i) | (i187 & i));
                                                                    int i191 = (i186 | i7) * (-280);
                                                                    i8 = ((i184 | i191) << 1) - (i191 ^ i184);
                                                                }
                                                                int i192 = ~(((-20) & i) | ((-20) ^ i));
                                                                int i193 = i8 + (((i192 & i7) | (i7 ^ i192)) * 140);
                                                                int i194 = (i187 ^ (-20)) | (i187 & (-20));
                                                                int i195 = (i194 & i) | (i194 ^ i);
                                                                int i196 = ((i189 | 17) << 1) - (i189 ^ 17);
                                                                getARTIFICIAL_FRAME_PACKAGE_NAME = i196 % 128;
                                                                if (i196 % 2 != 0) {
                                                                    throw null;
                                                                }
                                                                int i197 = ~i195;
                                                                int i198 = (i187 ^ i62) | (i187 & i62);
                                                                int i199 = ~((i198 & 19) | (i198 ^ 19));
                                                                int i200 = (i197 & i199) | (i197 ^ i199);
                                                                int i201 = (-20) | i81;
                                                                int i202 = ~((i201 & offsetAfter) | (i201 ^ offsetAfter));
                                                                Object[] objArr34 = new Object[1];
                                                                b(i193 + (((i200 & i202) | (i200 ^ i202)) * 140), new int[]{-1900015952, 1057795627, -306062201, -1005731552, 2044312693, -1793245063, 1938144390, 1750327830, -1308859824, 2041265925}, objArr34);
                                                                Object objInvoke4 = cls7.getMethod((String) objArr34[0], InputStream.class).invoke(objInvoke3, objArr32);
                                                                int length2 = objArr.length;
                                                                int i203 = 0;
                                                                while (i203 < 2) {
                                                                    Object obj4 = objArr[i203];
                                                                    int i204 = getARTIFICIAL_FRAME_PACKAGE_NAME + 59;
                                                                    artificialFrame = i204 % 128;
                                                                    int i205 = i204 % 2;
                                                                    try {
                                                                        int i206 = -View.resolveSize(0, 0);
                                                                        int iMediaBrowserCompatMediaBrowserImplApi2111 = RRWebEventType.Deserializer.MediaBrowserCompatMediaBrowserImplApi217();
                                                                        int i207 = i206 * (-919);
                                                                        int i208 = (i207 ^ (-40912961)) + ((i207 & (-40912961)) << 1);
                                                                        int i209 = ~i206;
                                                                        int i210 = ((-44520) & i209) | (i209 ^ (-44520));
                                                                        int i211 = ~((i210 & iMediaBrowserCompatMediaBrowserImplApi2111) | (i210 ^ iMediaBrowserCompatMediaBrowserImplApi2111));
                                                                        int i212 = ~iMediaBrowserCompatMediaBrowserImplApi2111;
                                                                        int i213 = ((-44520) ^ i212) | ((-44520) & i212);
                                                                        int i214 = ~((i213 ^ i206) | (i213 & i206));
                                                                        int i215 = ((i211 ^ i214) | (i211 & i214)) * 920;
                                                                        int i216 = ((i208 | i215) << 1) - (i215 ^ i208);
                                                                        int i217 = ~i206;
                                                                        int i218 = ~((-44520) | i217);
                                                                        int i219 = ~(i209 | i212);
                                                                        int i220 = ((i218 ^ i219) | (i219 & i218)) * 920;
                                                                        int i221 = (i216 & i220) + (i220 | i216);
                                                                        int i222 = (i217 ^ (-44520)) | (i217 & (-44520));
                                                                        int i223 = ~((i222 & i212) | (i222 ^ i212));
                                                                        int i224 = (i217 & 44519) | (i217 ^ 44519);
                                                                        int i225 = ~((i224 & iMediaBrowserCompatMediaBrowserImplApi2111) | (i224 ^ iMediaBrowserCompatMediaBrowserImplApi2111));
                                                                        int i226 = (i206 & (-44520)) | ((-44520) ^ i206);
                                                                        int i227 = -(-(((~((i226 & iMediaBrowserCompatMediaBrowserImplApi2111) | (i226 ^ iMediaBrowserCompatMediaBrowserImplApi2111))) | (i223 & i225) | (i223 ^ i225)) * 920));
                                                                        Object[] objArr35 = new Object[1];
                                                                        a((i221 ^ i227) + ((i227 & i221) << 1), new char[]{20898, 64590, 2672, 22556, 59002, 13368, 17095, 37114, 16005, 19621, 39591, 10577, 30565, 34141, 54025, 24868, 36810, 56811, 27608, 47541, 51185, 4619, 41003, 52810, 7173, 43573, 63690, 1788, 21738, 57994, 12473, 24400, 60764, 15210}, objArr35);
                                                                        Class<?> cls8 = Class.forName((String) objArr35[0]);
                                                                        int bitsPerPixel = ImageFormat.getBitsPerPixel(0);
                                                                        int iMediaBrowserCompatMediaBrowserImplApi2112 = RRWebEventType.Deserializer.MediaBrowserCompatMediaBrowserImplApi217();
                                                                        int i228 = (((bitsPerPixel * 141) - 6696) - (~(-(-(((iMediaBrowserCompatMediaBrowserImplApi2112 ^ 24) | (iMediaBrowserCompatMediaBrowserImplApi2112 & 24)) * 140))))) - 1;
                                                                        int i229 = ~((~bitsPerPixel) | 24);
                                                                        int i230 = ~iMediaBrowserCompatMediaBrowserImplApi2112;
                                                                        int i231 = (i228 - (~(-(-((i229 | (~(i230 | 24))) * (-280)))))) - 1;
                                                                        int i232 = ~(((-25) & bitsPerPixel) | ((-25) ^ bitsPerPixel));
                                                                        int i233 = ~(i230 | bitsPerPixel);
                                                                        int i234 = (i232 & i233) | (i232 ^ i233);
                                                                        int i235 = ~bitsPerPixel;
                                                                        int i236 = (i235 & 24) | (i235 ^ 24);
                                                                        int i237 = ~((iMediaBrowserCompatMediaBrowserImplApi2112 & i236) | (i236 ^ iMediaBrowserCompatMediaBrowserImplApi2112));
                                                                        int i238 = -(-(((i237 & i234) | (i234 ^ i237)) * 140));
                                                                        Object[] objArr36 = new Object[1];
                                                                        b((i231 & i238) + (i238 | i231), new int[]{1898355871, -530999580, -1003880575, 1208098302, -1849420469, 1487299941, 1130127931, 1862382178, -293787847, 1169622367, 1440411272, 99573109}, objArr36);
                                                                        if (obj4.equals(cls8.getMethod((String) objArr36[0], null).invoke(objInvoke4, null))) {
                                                                            int i239 = (i & (-2)) | (i62 & 1);
                                                                            Object[] objArr37 = new Object[4];
                                                                            int[] iArr3 = new int[1];
                                                                            objArr37[0] = iArr3;
                                                                            int[] iArr4 = new int[1];
                                                                            objArr37[1] = iArr4;
                                                                            objArr37[2] = new int[1];
                                                                            int i240 = artificialFrame;
                                                                            int i241 = (i240 & 121) + (i240 | 121);
                                                                            getARTIFICIAL_FRAME_PACKAGE_NAME = i241 % 128;
                                                                            int i242 = i241 % 2;
                                                                            iArr3[0] = i;
                                                                            iArr4[0] = i239;
                                                                            objArr37[3] = null;
                                                                            int i243 = (i240 & 3) + (i240 | 3);
                                                                            getARTIFICIAL_FRAME_PACKAGE_NAME = i243 % 128;
                                                                            if (i243 % 2 != 0) {
                                                                                i9 = (((((~((-1039216987) | i)) | 26218522) * (-283)) - 191469092) + ((~((-1012998465) | i)) * 283)) << 16;
                                                                                i10 = 193 >> i9;
                                                                            } else {
                                                                                int iUptimeMillis = (int) SystemClock.uptimeMillis();
                                                                                int i244 = ((((~((-166282228) | iUptimeMillis)) | 964827864) * 398) - 970596076) + (((~((~iUptimeMillis) | (-166282228))) | 964827864) * 398);
                                                                                i9 = (i244 ^ 16) + ((i244 & 16) << 1);
                                                                                i10 = i9 * 193;
                                                                            }
                                                                            int i245 = i10 + (i2 * 193);
                                                                            int i246 = ~i9;
                                                                            int i247 = ~((i246 ^ i2) | (i246 & i2));
                                                                            int i248 = ((i247 & i81) | (i81 ^ i247)) * (-192);
                                                                            int i249 = (i245 ^ i248) + ((i245 & i248) << 1);
                                                                            int i250 = ~i9;
                                                                            int i251 = ~i2;
                                                                            int i252 = i249 + (((~(i250 | i251)) | (~((i251 ^ i62) | (i251 & i62)))) * (-384));
                                                                            int i253 = ~((i246 ^ i251) | (i246 & i251) | i);
                                                                            int i254 = ~i2;
                                                                            int i255 = (i254 & i62) | (i254 ^ i62);
                                                                            int i256 = i253 | (~((i255 & i9) | (i255 ^ i9)));
                                                                            int i257 = (i9 & i2) | (i9 ^ i2);
                                                                            int i258 = ~((i257 & i) | (i257 ^ i));
                                                                            int i259 = ((i258 & i256) | (i256 ^ i258)) * JfifUtil.MARKER_SOFn;
                                                                            int i260 = ((i252 | i259) << 1) - (i259 ^ i252);
                                                                            int i261 = i260 << 13;
                                                                            int i262 = (i261 | i260) & (~(i260 & i261));
                                                                            int i263 = i262 >>> 17;
                                                                            int i264 = ((~i262) & i263) | ((~i263) & i262);
                                                                            ((int[]) objArr37[2])[0] = i264 ^ (i264 << 5);
                                                                            return objArr37;
                                                                        }
                                                                        int i265 = ((i203 | (-10)) << 1) - (i203 ^ (-10));
                                                                        i203 = (i265 ^ 11) + ((i265 & 11) << 1);
                                                                        int i266 = artificialFrame;
                                                                        int i267 = ((i266 | 3) << 1) - (i266 ^ 3);
                                                                        getARTIFICIAL_FRAME_PACKAGE_NAME = i267 % 128;
                                                                        if (i267 % 2 != 0) {
                                                                            int i268 = 4 / 4;
                                                                        }
                                                                    } catch (Throwable th) {
                                                                        Throwable cause = th.getCause();
                                                                        if (cause != null) {
                                                                            throw cause;
                                                                        }
                                                                        throw th;
                                                                    }
                                                                }
                                                                i128++;
                                                                objArr24 = objArr28;
                                                                str2 = str5;
                                                                length = i190;
                                                                i12 = 2;
                                                            } catch (Throwable th2) {
                                                                Throwable cause2 = th2.getCause();
                                                                if (cause2 != null) {
                                                                    throw cause2;
                                                                }
                                                                throw th2;
                                                            }
                                                        } catch (Throwable th3) {
                                                            Throwable cause3 = th3.getCause();
                                                            if (cause3 != null) {
                                                                throw cause3;
                                                            }
                                                            throw th3;
                                                        }
                                                    } catch (Throwable th4) {
                                                        Throwable cause4 = th4.getCause();
                                                        if (cause4 != null) {
                                                            throw cause4;
                                                        }
                                                        throw th4;
                                                    }
                                                    Object[] objArr38 = {new int[]{i}, new int[]{i}, new int[1], null};
                                                    int i269 = ~(459172912 | i);
                                                    int i270 = 1837131488 + ((77598926 | i269) * (-814)) + ((i269 | (~((~i) | (-519450863))) | 17320976) * 407) + (((~(i | 519450862)) | (~((-459172913) | i)) | 17320976) * 407);
                                                    int iMediaBrowserCompatMediaBrowserImplApi2113 = RRWebEventType.Deserializer.MediaBrowserCompatMediaBrowserImplApi217();
                                                    int i271 = i270 * (-167);
                                                    int i272 = -(-(i2 * (-167)));
                                                    int i273 = ((i271 | i272) << 1) - (i271 ^ i272);
                                                    int i274 = ~i270;
                                                    int i275 = ~i2;
                                                    int i276 = (i274 & i275) | (i274 ^ i275);
                                                    int i277 = ~i276;
                                                    int i278 = ~iMediaBrowserCompatMediaBrowserImplApi2113;
                                                    int i279 = (i277 | (~((i275 ^ i278) | (i275 & i278)))) * 168;
                                                    int i280 = (((i273 ^ i279) + ((i273 & i279) << 1)) - (~(-(-((~((i276 & iMediaBrowserCompatMediaBrowserImplApi2113) | (i276 ^ iMediaBrowserCompatMediaBrowserImplApi2113))) * 168))))) - 1;
                                                    int i281 = ~i270;
                                                    int i282 = ~(i281 | i278);
                                                    int i283 = ~((i2 & i281) | (i281 ^ i2));
                                                    int i284 = (i283 & i282) | (i282 ^ i283);
                                                    int i285 = (i275 ^ i270) | (i275 & i270);
                                                    int i286 = ~((iMediaBrowserCompatMediaBrowserImplApi2113 & i285) | (i285 ^ iMediaBrowserCompatMediaBrowserImplApi2113));
                                                    int i287 = (i280 - (~(-(-(((i286 & i284) | (i284 ^ i286)) * 168))))) - 1;
                                                    int i288 = (i287 << 13) ^ i287;
                                                    int i289 = i288 >>> 17;
                                                    int i290 = (i288 | i289) & (~(i288 & i289));
                                                    int i291 = i290 << 5;
                                                    ((int[]) objArr38[2])[0] = (i290 | i291) & (~(i290 & i291));
                                                    int i292 = artificialFrame + 47;
                                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i292 % 128;
                                                    int i293 = i292 % 2;
                                                    return objArr38;
                                                }
                                            } catch (Throwable th5) {
                                                Throwable cause5 = th5.getCause();
                                                if (cause5 != null) {
                                                    throw cause5;
                                                }
                                                throw th5;
                                            }
                                        } catch (Throwable th6) {
                                            Throwable cause6 = th6.getCause();
                                            if (cause6 != null) {
                                                throw cause6;
                                            }
                                            throw th6;
                                        }
                                    } catch (Throwable th7) {
                                        Throwable cause7 = th7.getCause();
                                        if (cause7 != null) {
                                            throw cause7;
                                        }
                                        throw th7;
                                    }
                                } catch (Throwable th8) {
                                    Throwable cause8 = th8.getCause();
                                    if (cause8 != null) {
                                        throw cause8;
                                    }
                                    throw th8;
                                }
                            } catch (Throwable th9) {
                                Throwable cause9 = th9.getCause();
                                if (cause9 != null) {
                                    throw cause9;
                                }
                                throw th9;
                            }
                        } catch (Throwable unused) {
                        }
                        Object[] objArr39 = {new int[]{i}, new int[]{i}, new int[1], null};
                        int i2610 = ~(459172912 | i);
                        int i2710 = 1837131488 + ((77598926 | i2610) * (-814)) + ((i2610 | (~((~i) | (-519450863))) | 17320976) * 407) + (((~(i | 519450862)) | (~((-459172913) | i)) | 17320976) * 407);
                        int iMediaBrowserCompatMediaBrowserImplApi2114 = RRWebEventType.Deserializer.MediaBrowserCompatMediaBrowserImplApi217();
                        int i2711 = i2710 * (-167);
                        int i2712 = -(-(i2 * (-167)));
                        int i2713 = ((i2711 | i2712) << 1) - (i2711 ^ i2712);
                        int i2714 = ~i2710;
                        int i2715 = ~i2;
                        int i2716 = (i2714 & i2715) | (i2714 ^ i2715);
                        int i2717 = ~i2716;
                        int i2718 = ~iMediaBrowserCompatMediaBrowserImplApi2114;
                        int i2719 = (i2717 | (~((i2715 ^ i2718) | (i2715 & i2718)))) * 168;
                        int i2810 = (((i2713 ^ i2719) + ((i2713 & i2719) << 1)) - (~(-(-((~((i2716 & iMediaBrowserCompatMediaBrowserImplApi2114) | (i2716 ^ iMediaBrowserCompatMediaBrowserImplApi2114))) * 168))))) - 1;
                        int i2811 = ~i2710;
                        int i2812 = ~(i2811 | i2718);
                        int i2813 = ~((i2 & i2811) | (i2811 ^ i2));
                        int i2814 = (i2813 & i2812) | (i2812 ^ i2813);
                        int i2815 = (i2715 ^ i2710) | (i2715 & i2710);
                        int i2816 = ~((iMediaBrowserCompatMediaBrowserImplApi2114 & i2815) | (i2815 ^ iMediaBrowserCompatMediaBrowserImplApi2114));
                        int i2817 = (i2810 - (~(-(-(((i2816 & i2814) | (i2814 ^ i2816)) * 168))))) - 1;
                        int i2818 = (i2817 << 13) ^ i2817;
                        int i2819 = i2818 >>> 17;
                        int i294 = (i2818 | i2819) & (~(i2818 & i2819));
                        int i295 = i294 << 5;
                        ((int[]) objArr39[2])[0] = (i294 | i295) & (~(i294 & i295));
                        int i296 = artificialFrame + 47;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i296 % 128;
                        int i297 = i296 % 2;
                        return objArr39;
                    }
                });
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void postTrim$lambda$3$lambda$2(FileLruCache this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.trim();
    }

    private final void trim() {
        long j;
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            this.isTrimPending = false;
            this.isTrimInProgress = true;
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            try {
                Logger.Companion companion = Logger.Companion;
                LoggingBehavior loggingBehavior = LoggingBehavior.CACHE;
                String TAG2 = TAG;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                companion.log(loggingBehavior, TAG2, "trim started");
                PriorityQueue priorityQueue = new PriorityQueue();
                File[] fileArrListFiles = this.directory.listFiles(BufferFile.INSTANCE.excludeBufferFiles());
                long length = 0;
                if (fileArrListFiles != null) {
                    int length2 = fileArrListFiles.length;
                    int i = 0;
                    j = 0;
                    while (i < length2) {
                        File file = fileArrListFiles[i];
                        Intrinsics.checkNotNullExpressionValue(file, "file");
                        ModifiedFile modifiedFile = new ModifiedFile(file);
                        priorityQueue.add(modifiedFile);
                        Logger.Companion companion2 = Logger.Companion;
                        LoggingBehavior loggingBehavior2 = LoggingBehavior.CACHE;
                        String TAG3 = TAG;
                        Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
                        companion2.log(loggingBehavior2, TAG3, "  trim considering time=" + Long.valueOf(modifiedFile.getModified()) + " name=" + modifiedFile.getFile().getName());
                        length += file.length();
                        j++;
                        i++;
                        fileArrListFiles = fileArrListFiles;
                    }
                } else {
                    j = 0;
                }
                while (true) {
                    if (length <= this.limits.getByteCount() && j <= this.limits.getFileCount()) {
                        ReentrantLock reentrantLock2 = this.lock;
                        reentrantLock2.lock();
                        try {
                            this.isTrimInProgress = false;
                            this.condition.signalAll();
                            Unit unit2 = Unit.INSTANCE;
                            return;
                        } finally {
                            reentrantLock2.unlock();
                        }
                    }
                    File file2 = ((ModifiedFile) priorityQueue.remove()).getFile();
                    Logger.Companion companion3 = Logger.Companion;
                    LoggingBehavior loggingBehavior3 = LoggingBehavior.CACHE;
                    String TAG4 = TAG;
                    Intrinsics.checkNotNullExpressionValue(TAG4, "TAG");
                    companion3.log(loggingBehavior3, TAG4, "  trim removing " + file2.getName());
                    length -= file2.length();
                    j--;
                    file2.delete();
                }
            } catch (Throwable th) {
                ReentrantLock reentrantLock3 = this.lock;
                reentrantLock3.lock();
                try {
                    this.isTrimInProgress = false;
                    this.condition.signalAll();
                    Unit unit3 = Unit.INSTANCE;
                    throw th;
                } finally {
                    reentrantLock3.unlock();
                }
            }
        } catch (Throwable th2) {
            reentrantLock.unlock();
            throw th2;
        }
    }

    static final class BufferFile {
        private static final String FILE_NAME_PREFIX = "buffer";
        public static final BufferFile INSTANCE = new BufferFile();
        private static final FilenameFilter filterExcludeBufferFiles = new FilenameFilter() { // from class: com.facebook.internal.FileLruCache$BufferFile$$ExternalSyntheticLambda0
            @Override // java.io.FilenameFilter
            public final boolean accept(File file, String str) {
                return FileLruCache.BufferFile.filterExcludeBufferFiles$lambda$0(file, str);
            }
        };
        private static final FilenameFilter filterExcludeNonBufferFiles = new FileLruCache$BufferFile$$ExternalSyntheticLambda1();

        private BufferFile() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean filterExcludeBufferFiles$lambda$0(File file, String filename) {
            Intrinsics.checkNotNullExpressionValue(filename, "filename");
            return !StringsKt__StringsJVMKt.startsWith$default(filename, FILE_NAME_PREFIX, false, 2, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean filterExcludeNonBufferFiles$lambda$1(File file, String filename) {
            Intrinsics.checkNotNullExpressionValue(filename, "filename");
            return StringsKt__StringsJVMKt.startsWith$default(filename, FILE_NAME_PREFIX, false, 2, null);
        }

        public final void deleteAll(@NotNull File root) {
            Intrinsics.checkNotNullParameter(root, "root");
            File[] fileArrListFiles = root.listFiles(excludeNonBufferFiles());
            if (fileArrListFiles != null) {
                for (File file : fileArrListFiles) {
                    file.delete();
                }
            }
        }

        public final FilenameFilter excludeBufferFiles() {
            return filterExcludeBufferFiles;
        }

        public final FilenameFilter excludeNonBufferFiles() {
            return filterExcludeNonBufferFiles;
        }

        public final File newFile(@Nullable File file) {
            return new File(file, FILE_NAME_PREFIX + FileLruCache.bufferIndex.incrementAndGet());
        }
    }

    static final class StreamHeader {
        private static final int HEADER_VERSION = 0;
        public static final StreamHeader INSTANCE = new StreamHeader();

        private StreamHeader() {
        }

        public final void writeHeader(@NotNull OutputStream stream, @NotNull JSONObject header) throws IOException {
            Intrinsics.checkNotNullParameter(stream, "stream");
            Intrinsics.checkNotNullParameter(header, "header");
            String string = header.toString();
            Intrinsics.checkNotNullExpressionValue(string, "header.toString()");
            byte[] bytes = string.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            stream.write(0);
            stream.write((bytes.length >> 16) & 255);
            stream.write((bytes.length >> 8) & 255);
            stream.write(bytes.length & 255);
            stream.write(bytes);
        }

        public final JSONObject readHeader(@NotNull InputStream stream) throws IOException {
            Intrinsics.checkNotNullParameter(stream, "stream");
            if (stream.read() != 0) {
                return null;
            }
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < 3; i3++) {
                int i4 = stream.read();
                if (i4 == -1) {
                    Logger.Companion companion = Logger.Companion;
                    LoggingBehavior loggingBehavior = LoggingBehavior.CACHE;
                    String TAG = FileLruCache.Companion.getTAG();
                    Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                    companion.log(loggingBehavior, TAG, "readHeader: stream.read returned -1 while reading header size");
                    return null;
                }
                i2 = (i2 << 8) + (i4 & 255);
            }
            byte[] bArr = new byte[i2];
            while (i < i2) {
                int i5 = stream.read(bArr, i, i2 - i);
                if (i5 < 1) {
                    Logger.Companion companion2 = Logger.Companion;
                    LoggingBehavior loggingBehavior2 = LoggingBehavior.CACHE;
                    String TAG2 = FileLruCache.Companion.getTAG();
                    Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                    companion2.log(loggingBehavior2, TAG2, "readHeader: stream.read stopped at " + Integer.valueOf(i) + " when expected " + i2);
                    return null;
                }
                i += i5;
            }
            try {
                Object objNextValue = new JSONTokener(new String(bArr, Charsets.UTF_8)).nextValue();
                if (!(objNextValue instanceof JSONObject)) {
                    Logger.Companion companion3 = Logger.Companion;
                    LoggingBehavior loggingBehavior3 = LoggingBehavior.CACHE;
                    String TAG3 = FileLruCache.Companion.getTAG();
                    Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
                    companion3.log(loggingBehavior3, TAG3, "readHeader: expected JSONObject, got " + objNextValue.getClass().getCanonicalName());
                    return null;
                }
                return (JSONObject) objNextValue;
            } catch (JSONException e) {
                throw new IOException(e.getMessage());
            }
        }
    }

    static final class CloseCallbackOutputStream extends OutputStream {
        private final StreamCloseCallback callback;
        private final OutputStream innerStream;

        public CloseCallbackOutputStream(@NotNull OutputStream innerStream, @NotNull StreamCloseCallback callback) {
            Intrinsics.checkNotNullParameter(innerStream, "innerStream");
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.innerStream = innerStream;
            this.callback = callback;
        }

        public final StreamCloseCallback getCallback() {
            return this.callback;
        }

        public final OutputStream getInnerStream() {
            return this.innerStream;
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            try {
                this.innerStream.close();
            } finally {
                this.callback.onClose();
            }
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() throws IOException {
            this.innerStream.flush();
        }

        @Override // java.io.OutputStream
        public void write(@NotNull byte[] buffer, int i, int i2) throws IOException {
            Intrinsics.checkNotNullParameter(buffer, "buffer");
            this.innerStream.write(buffer, i, i2);
        }

        @Override // java.io.OutputStream
        public void write(@NotNull byte[] buffer) throws IOException {
            Intrinsics.checkNotNullParameter(buffer, "buffer");
            this.innerStream.write(buffer);
        }

        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
            this.innerStream.write(i);
        }
    }

    static final class CopyingInputStream extends InputStream {
        private final InputStream input;
        private final OutputStream output;

        @Override // java.io.InputStream
        public boolean markSupported() {
            return false;
        }

        public final InputStream getInput() {
            return this.input;
        }

        public final OutputStream getOutput() {
            return this.output;
        }

        public CopyingInputStream(@NotNull InputStream input, @NotNull OutputStream output) {
            Intrinsics.checkNotNullParameter(input, "input");
            Intrinsics.checkNotNullParameter(output, "output");
            this.input = input;
            this.output = output;
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            return this.input.available();
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            try {
                this.input.close();
            } finally {
                this.output.close();
            }
        }

        @Override // java.io.InputStream
        public void mark(int i) {
            throw new UnsupportedOperationException();
        }

        @Override // java.io.InputStream
        public int read(@NotNull byte[] buffer) throws IOException {
            Intrinsics.checkNotNullParameter(buffer, "buffer");
            int i = this.input.read(buffer);
            if (i > 0) {
                this.output.write(buffer, 0, i);
            }
            return i;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            int i = this.input.read();
            if (i >= 0) {
                this.output.write(i);
            }
            return i;
        }

        @Override // java.io.InputStream
        public int read(@NotNull byte[] buffer, int i, int i2) throws IOException {
            Intrinsics.checkNotNullParameter(buffer, "buffer");
            int i3 = this.input.read(buffer, i, i2);
            if (i3 > 0) {
                this.output.write(buffer, i, i3);
            }
            return i3;
        }

        @Override // java.io.InputStream
        public void reset() {
            synchronized (this) {
                throw new UnsupportedOperationException();
            }
        }

        @Override // java.io.InputStream
        public long skip(long j) throws IOException {
            byte[] bArr = new byte[1024];
            long j2 = 0;
            while (j2 < j) {
                int i = read(bArr, 0, (int) Math.min(j - j2, 1024));
                if (i < 0) {
                    return j2;
                }
                j2 += (long) i;
            }
            return j2;
        }
    }

    public static final class Limits {
        private int byteCount = 1048576;
        private int fileCount = 1024;

        public final int getByteCount() {
            return this.byteCount;
        }

        public final void setByteCount(int i) {
            if (i < 0) {
                throw new InvalidParameterException("Cache byte-count limit must be >= 0");
            }
            this.byteCount = i;
        }

        public final int getFileCount() {
            return this.fileCount;
        }

        public final void setFileCount(int i) {
            if (i < 0) {
                throw new InvalidParameterException("Cache file count limit must be >= 0");
            }
            this.fileCount = i;
        }
    }

    static final class ModifiedFile implements Comparable<ModifiedFile> {
        public static final Companion Companion = new Companion(null);
        private static final int HASH_MULTIPLIER = 37;
        private static final int HASH_SEED = 29;
        private final File file;
        private final long modified;

        public ModifiedFile(@NotNull File file) {
            Intrinsics.checkNotNullParameter(file, "file");
            this.file = file;
            this.modified = file.lastModified();
        }

        public final File getFile() {
            return this.file;
        }

        public final long getModified() {
            return this.modified;
        }

        @Override // java.lang.Comparable
        public int compareTo(@NotNull ModifiedFile another) {
            Intrinsics.checkNotNullParameter(another, "another");
            long j = this.modified;
            long j2 = another.modified;
            if (j < j2) {
                return -1;
            }
            if (j > j2) {
                return 1;
            }
            return this.file.compareTo(another.file);
        }

        public boolean equals(@Nullable Object obj) {
            return (obj instanceof ModifiedFile) && compareTo((ModifiedFile) obj) == 0;
        }

        public int hashCode() {
            return ((this.file.hashCode() + 1073) * 37) + ((int) (this.modified % ((long) Integer.MAX_VALUE)));
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getTAG() {
            return FileLruCache.TAG;
        }
    }
}
