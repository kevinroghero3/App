package com.facebook.fresco.urimod;

import android.graphics.Color;
import android.net.Uri;
import android.os.Process;
import android.os.SystemClock;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.facebook.common.callercontext.ContextChain;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.fresco.vito.source.UriImageSource;
import com.google.common.base.Ascii;
import java.lang.reflect.Method;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o.ArtificialStackFrames;
import o.ICustomTabsCallbackDefault;
import o.asBinder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public interface UriModifierInterface {
    Uri modifyPrefetchUri(@NotNull Uri uri, @Nullable Object obj);

    ModificationResult modifyUri(@NotNull UriImageSource uriImageSource, @Nullable Dimensions dimensions, @Nullable ScalingUtils.ScaleType scaleType, @Nullable Object obj, @Nullable ContextChain contextChain, boolean z);

    void unregisterReverseFallbackUri(@NotNull Uri uri);

    /* JADX INFO: loaded from: classes4.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ ModificationResult modifyUri$default(UriModifierInterface uriModifierInterface, UriImageSource uriImageSource, Dimensions dimensions, ScalingUtils.ScaleType scaleType, Object obj, ContextChain contextChain, boolean z, int i, Object obj2) {
            if (obj2 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: modifyUri");
            }
            if ((i & 16) != 0) {
                contextChain = null;
            }
            ContextChain contextChain2 = contextChain;
            if ((i & 32) != 0) {
                z = false;
            }
            return uriModifierInterface.modifyUri(uriImageSource, dimensions, scaleType, obj, contextChain2, z);
        }
    }

    public static abstract class ModificationResult {
        private final String comment;

        public /* synthetic */ ModificationResult(String str, DefaultConstructorMarker defaultConstructorMarker) {
            this(str);
        }

        public abstract Integer getBestAllowlistedSize();

        private ModificationResult(String str) {
            this.comment = str;
        }

        public String toString() {
            return this.comment;
        }

        /* JADX INFO: loaded from: classes4.dex */
        public static final class Disabled extends ModificationResult {
            private final Integer bestAllowlistedSize;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Disabled(@NotNull String comment) {
                super("Disabled:" + comment, null);
                Intrinsics.checkNotNullParameter(comment, "comment");
            }

            @Override // com.facebook.fresco.urimod.UriModifierInterface.ModificationResult
            public Integer getBestAllowlistedSize() {
                return this.bestAllowlistedSize;
            }
        }

        public static abstract class Modified extends ModificationResult {
            private final Uri newUri;

            public /* synthetic */ Modified(Uri uri, String str, DefaultConstructorMarker defaultConstructorMarker) {
                this(uri, str);
            }

            /* JADX INFO: loaded from: classes4.dex */
            public static final class ModifiedToAllowlistedSize extends Modified {
                private final Integer bestAllowlistedSize;

                @Override // com.facebook.fresco.urimod.UriModifierInterface.ModificationResult
                public Integer getBestAllowlistedSize() {
                    return this.bestAllowlistedSize;
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public ModifiedToAllowlistedSize(@NotNull Uri newUrl, @Nullable Integer num) {
                    super(newUrl, "ModifiedToAllowlistedSize", null);
                    Intrinsics.checkNotNullParameter(newUrl, "newUrl");
                    this.bestAllowlistedSize = num;
                }
            }

            private Modified(Uri uri, String str) {
                super(str, null);
                this.newUri = uri;
            }

            public final Uri getNewUri() {
                return this.newUri;
            }

            public static final class ModifiedToMaxDimens extends Modified {
                private final Integer bestAllowlistedSize;
                private static final byte[] $$c = {35, -18, 33, -64};
                private static final int $$d = 11;
                private static int $10 = 0;
                private static int $11 = 1;
                private static final byte[] $$a = {111, -109, -75, Ascii.SYN, 50, Ascii.SO, -5, Ascii.SYN, -16, 3, Ascii.DC4, -50, Ascii.SYN, -3, 8, 32, 8, 6, Ascii.US, 5, Ascii.DLE, Ascii.DLE, 5, -9, 5, Ascii.VT, -2, Ascii.DC2, 3, -49, 10, 4, 1, -6, Ascii.GS, Ascii.ESC, Ascii.SYN, -16, 10, 2, 5, 10, Ascii.DC2, -9, Ascii.SO, -5, 0, -8, Ascii.DC4, 1, 36, 8, 3, 8, 5};
                private static final int $$b = 227;
                private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
                private static int artificialFrame = 1;
                private static long extraCommand = -6307145973597152985L;
                private static long coroutineBoundary = -1262659585534156242L;
                private static int accessartificialFrame = -1151259316;
                private static char CoroutineDebuggingKt = 11596;

                /* JADX WARN: Code duplicated, block: B:10:0x0025  */
                /* JADX WARN: Code duplicated, block: B:8:0x001f  */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x002a). Please report as a decompilation issue!!! */
                /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                    jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0025
                    	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                    	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                    	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                    */
                private static java.lang.String $$e(int r6, int r7, byte r8) {
                    /*
                        int r6 = r6 + 98
                        byte[] r0 = com.facebook.fresco.urimod.UriModifierInterface.ModificationResult.Modified.ModifiedToMaxDimens.$$c
                        int r8 = r8 + 4
                        int r7 = r7 * 4
                        int r1 = 1 - r7
                        byte[] r1 = new byte[r1]
                        r2 = 0
                        int r7 = 0 - r7
                        if (r0 != 0) goto L15
                        r3 = r7
                        r6 = r8
                        r4 = r2
                        goto L2a
                    L15:
                        r3 = r2
                    L16:
                        byte r4 = (byte) r6
                        int r8 = r8 + 1
                        r1[r3] = r4
                        int r4 = r3 + 1
                        if (r3 != r7) goto L25
                        java.lang.String r6 = new java.lang.String
                        r6.<init>(r1, r2)
                        return r6
                    L25:
                        r3 = r0[r8]
                        r5 = r8
                        r8 = r6
                        r6 = r5
                    L2a:
                        int r8 = r8 + r3
                        r3 = r4
                        r5 = r8
                        r8 = r6
                        r6 = r5
                        goto L16
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.fresco.urimod.UriModifierInterface.ModificationResult.Modified.ModifiedToMaxDimens.$$e(int, int, byte):java.lang.String");
                }

                /* JADX WARN: Code duplicated, block: B:10:0x0021  */
                /* JADX WARN: Code duplicated, block: B:8:0x0019  */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0021 -> B:11:0x0025). Please report as a decompilation issue!!! */
                /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                    jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0021
                    	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                    	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                    	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                    */
                private static void b(short r5, short r6, byte r7, java.lang.Object[] r8) {
                    /*
                        int r6 = 52 - r6
                        int r7 = 115 - r7
                        byte[] r0 = com.facebook.fresco.urimod.UriModifierInterface.ModificationResult.Modified.ModifiedToMaxDimens.$$a
                        int r5 = r5 + 2
                        byte[] r1 = new byte[r5]
                        r2 = 0
                        if (r0 != 0) goto L11
                        r4 = r7
                        r3 = r2
                        r7 = r5
                        goto L25
                    L11:
                        r3 = r2
                    L12:
                        byte r4 = (byte) r7
                        r1[r3] = r4
                        int r3 = r3 + 1
                        if (r3 != r5) goto L21
                        java.lang.String r5 = new java.lang.String
                        r5.<init>(r1, r2)
                        r8[r2] = r5
                        return
                    L21:
                        int r6 = r6 + 1
                        r4 = r0[r6]
                    L25:
                        int r7 = r7 + r4
                        int r7 = r7 + (-5)
                        goto L12
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.fresco.urimod.UriModifierInterface.ModificationResult.Modified.ModifiedToMaxDimens.b(short, short, byte, java.lang.Object[]):void");
                }

                @Override // com.facebook.fresco.urimod.UriModifierInterface.ModificationResult
                public Integer getBestAllowlistedSize() {
                    return this.bestAllowlistedSize;
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public ModifiedToMaxDimens(@NotNull Uri newUrl, @Nullable Integer num) {
                    super(newUrl, "ModifiedToMaxDimens", null);
                    Intrinsics.checkNotNullParameter(newUrl, "newUrl");
                    this.bestAllowlistedSize = num;
                }

                private static void a(int i, char[] cArr, Object[] objArr) throws Throwable {
                    int i2 = 2 % 2;
                    asBinder asbinder = new asBinder();
                    asbinder.c = i;
                    int length = cArr.length;
                    long[] jArr = new long[length];
                    asbinder.d = 0;
                    while (asbinder.d < cArr.length) {
                        int i3 = $11 + 37;
                        $10 = i3 % 128;
                        if (i3 % 2 != 0) {
                            int i4 = asbinder.d;
                            try {
                                Object[] objArr2 = {Integer.valueOf(cArr[asbinder.d]), asbinder, asbinder};
                                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1562553046);
                                if (objAccessartificialFrame == null) {
                                    byte b = (byte) 0;
                                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(TextUtils.indexOf((CharSequence) "", '0') + 12, (char) (TextUtils.lastIndexOf("", '0', 0, 0) + 1), 1407 - TextUtils.indexOf("", "", 0, 0), 1035473698, false, $$e((byte) 20, b, (byte) (b - 1)), new Class[]{Integer.TYPE, Object.class, Object.class});
                                }
                                jArr[i4] = ((Long) ((Method) objAccessartificialFrame).invoke(null, objArr2)).longValue() % (extraCommand / (-2360974883025274865L));
                                Object[] objArr3 = {asbinder, asbinder};
                                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1981632360);
                                if (objAccessartificialFrame2 == null) {
                                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(7 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), (char) (Process.getGidForName("") + 1), Color.red(0) + 249, 378009232, false, "w", new Class[]{Object.class, Object.class});
                                }
                                ((Method) objAccessartificialFrame2).invoke(null, objArr3);
                            } catch (Throwable th) {
                                Throwable cause = th.getCause();
                                if (cause == null) {
                                    throw th;
                                }
                                throw cause;
                            }
                        } else {
                            int i5 = asbinder.d;
                            Object[] objArr4 = {Integer.valueOf(cArr[asbinder.d]), asbinder, asbinder};
                            Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1562553046);
                            if (objAccessartificialFrame3 == null) {
                                byte b2 = (byte) 0;
                                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(11 - TextUtils.getTrimmedLength(""), (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16), (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 1406, 1035473698, false, $$e((byte) 20, b2, (byte) (b2 - 1)), new Class[]{Integer.TYPE, Object.class, Object.class});
                            }
                            jArr[i5] = ((Long) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).longValue() ^ (extraCommand ^ (-2360974883025274865L));
                            Object[] objArr5 = {asbinder, asbinder};
                            Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1981632360);
                            if (objAccessartificialFrame4 == null) {
                                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(TextUtils.indexOf("", "", 0) + 8, (char) TextUtils.indexOf("", "", 0, 0), (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 248, 378009232, false, "w", new Class[]{Object.class, Object.class});
                            }
                            ((Method) objAccessartificialFrame4).invoke(null, objArr5);
                        }
                    }
                    char[] cArr2 = new char[length];
                    asbinder.d = 0;
                    while (asbinder.d < cArr.length) {
                        int i6 = $11 + 23;
                        $10 = i6 % 128;
                        int i7 = i6 % 2;
                        cArr2[asbinder.d] = (char) jArr[asbinder.d];
                        Object[] objArr6 = {asbinder, asbinder};
                        Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1981632360);
                        if (objAccessartificialFrame5 == null) {
                            objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getJumpTapTimeout() >> 16) + 8, (char) View.resolveSizeAndState(0, 0, 0), AndroidCharacter.getMirror('0') + 201, 378009232, false, "w", new Class[]{Object.class, Object.class});
                        }
                        ((Method) objAccessartificialFrame5).invoke(null, objArr6);
                    }
                    objArr[0] = new String(cArr2);
                }

                private static void c(char[] cArr, char c, int i, char[] cArr2, char[] cArr3, Object[] objArr) throws Throwable {
                    char c2;
                    int i2 = 2 % 2;
                    ICustomTabsCallbackDefault iCustomTabsCallbackDefault = new ICustomTabsCallbackDefault();
                    int length = cArr2.length;
                    char[] cArr4 = new char[length];
                    int length2 = cArr3.length;
                    char[] cArr5 = new char[length2];
                    int i3 = 0;
                    System.arraycopy(cArr2, 0, cArr4, 0, length);
                    System.arraycopy(cArr3, 0, cArr5, 0, length2);
                    cArr4[0] = (char) (cArr4[0] ^ c);
                    cArr5[2] = (char) (cArr5[2] + ((char) i));
                    int length3 = cArr.length;
                    char[] cArr6 = new char[length3];
                    iCustomTabsCallbackDefault.a = 0;
                    int i4 = $11 + 97;
                    $10 = i4 % 128;
                    int i5 = i4 % 2;
                    while (iCustomTabsCallbackDefault.a < length3) {
                        int i6 = $11 + 33;
                        $10 = i6 % 128;
                        int i7 = i6 % 2;
                        try {
                            Object[] objArr2 = {iCustomTabsCallbackDefault};
                            Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-10548171);
                            if (objAccessartificialFrame == null) {
                                int size = View.MeasureSpec.getSize(i3) + 33;
                                char c3 = (char) ((-1) - (ExpandableListView.getPackedPositionForChild(i3, i3) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(i3, i3) == 0L ? 0 : -1)));
                                int mode = View.MeasureSpec.getMode(i3) + 1483;
                                byte b = (byte) ($$d & 5);
                                byte b2 = (byte) (b - 1);
                                String str$$e = $$e(b, b2, (byte) (b2 - 1));
                                Class[] clsArr = new Class[1];
                                clsArr[i3] = Object.class;
                                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(size, c3, mode, 1614432829, false, str$$e, clsArr);
                            }
                            int iIntValue = ((Integer) ((Method) objAccessartificialFrame).invoke(null, objArr2)).intValue();
                            Object[] objArr3 = {iCustomTabsCallbackDefault};
                            Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1818210492);
                            if (objAccessartificialFrame2 == null) {
                                int iMakeMeasureSpec = 32 - View.MeasureSpec.makeMeasureSpec(i3, i3);
                                char cAxisFromString = (char) (MotionEvent.axisFromString("") + 49169);
                                int maximumDrawingCacheSize = (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 899;
                                byte b3 = (byte) ($$d & 7);
                                byte b4 = (byte) (b3 - 3);
                                String str$$e2 = $$e(b3, b4, (byte) (b4 - 1));
                                Class[] clsArr2 = new Class[1];
                                clsArr2[i3] = Object.class;
                                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iMakeMeasureSpec, cAxisFromString, maximumDrawingCacheSize, 214239564, false, str$$e2, clsArr2);
                            }
                            int iIntValue2 = ((Integer) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).intValue();
                            int i8 = cArr4[iCustomTabsCallbackDefault.a % 4] * 32718;
                            Object[] objArr4 = new Object[3];
                            objArr4[2] = Integer.valueOf(cArr5[iIntValue]);
                            objArr4[1] = Integer.valueOf(i8);
                            objArr4[i3] = iCustomTabsCallbackDefault;
                            Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(1532285801);
                            if (objAccessartificialFrame3 == null) {
                                byte b5 = (byte) i3;
                                byte b6 = b5;
                                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getPressedStateDuration() >> 16) + 23, (char) (ViewConfiguration.getScrollDefaultDelay() >> 16), 2441 - View.MeasureSpec.makeMeasureSpec(i3, i3), -1003383455, false, $$e(b5, b6, (byte) (b6 - 1)), new Class[]{Object.class, Integer.TYPE, Integer.TYPE});
                            }
                            ((Method) objAccessartificialFrame3).invoke(null, objArr4);
                            Object[] objArr5 = {Integer.valueOf(cArr4[iIntValue2] * 32718), Integer.valueOf(cArr5[iIntValue])};
                            Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-950633141);
                            if (objAccessartificialFrame4 == null) {
                                int iMyPid = (Process.myPid() >> 22) + 20;
                                char gidForName = (char) (Process.getGidForName("") + 29755);
                                int scrollDefaultDelay = 1748 - (ViewConfiguration.getScrollDefaultDelay() >> 16);
                                c2 = 2;
                                byte b7 = (byte) ($$d >>> 2);
                                byte b8 = (byte) (b7 - 2);
                                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(iMyPid, gidForName, scrollDefaultDelay, 1479752515, false, $$e(b7, b8, (byte) (b8 - 1)), new Class[]{Integer.TYPE, Integer.TYPE});
                            } else {
                                c2 = 2;
                            }
                            cArr5[iIntValue2] = ((Character) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).charValue();
                            cArr4[iIntValue2] = iCustomTabsCallbackDefault.MediaBrowserCompatApi21ConnectionCallback;
                            cArr6[iCustomTabsCallbackDefault.a] = (char) (((((long) (cArr4[iIntValue2] ^ cArr[iCustomTabsCallbackDefault.a])) ^ (coroutineBoundary ^ (-899883803867009716L))) ^ ((long) ((int) (((long) accessartificialFrame) ^ (-899883803867009716L))))) ^ ((long) ((char) (((long) CoroutineDebuggingKt) ^ (-899883803867009716L)))));
                            iCustomTabsCallbackDefault.a++;
                            i3 = 0;
                        } catch (Throwable th) {
                            Throwable cause = th.getCause();
                            if (cause == null) {
                                throw th;
                            }
                            throw cause;
                        }
                    }
                    objArr[0] = new String(cArr6);
                }

                /* JADX WARN: Multi-variable search skipped. Vars limit reached: 7097 (expected less than 5000) */
                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r1v48, types: [java.lang.CharSequence] */
                /* JADX WARN: Type inference failed for: r1v52 */
                /* JADX WARN: Type inference failed for: r1v53 */
                /* JADX WARN: Type inference failed for: r1v54, types: [java.lang.CharSequence] */
                /* JADX WARN: Type inference failed for: r1v685 */
                /* JADX WARN: Type inference failed for: r1v925 */
                /* JADX WARN: Type inference failed for: r1v926 */
                /* JADX WARN: Type inference failed for: r2v375 */
                /* JADX WARN: Type inference failed for: r2v376, types: [java.lang.CharSequence] */
                /* JADX WARN: Type inference failed for: r2v392 */
                /* JADX WARN: Type inference failed for: r2v393 */
                /* JADX WARN: Type inference failed for: r2v396, types: [java.lang.CharSequence] */
                /* JADX WARN: Type inference failed for: r2v748 */
                /* JADX WARN: Type inference failed for: r2v749 */
                /* JADX WARN: Type inference failed for: r35v1 */
                /* JADX WARN: Type inference failed for: r36v10 */
                /* JADX WARN: Type inference failed for: r36v11 */
                /* JADX WARN: Type inference failed for: r36v12 */
                /* JADX WARN: Type inference failed for: r36v13 */
                /* JADX WARN: Type inference failed for: r36v14, types: [java.lang.String] */
                /* JADX WARN: Type inference failed for: r36v34 */
                /* JADX WARN: Type inference failed for: r36v35 */
                /* JADX WARN: Type inference failed for: r36v36 */
                /* JADX WARN: Type inference failed for: r36v40 */
                /* JADX WARN: Type inference failed for: r36v41 */
                /* JADX WARN: Type inference failed for: r36v42 */
                /* JADX WARN: Type inference failed for: r36v43 */
                /* JADX WARN: Type inference failed for: r36v44 */
                /* JADX WARN: Type inference failed for: r36v45 */
                /* JADX WARN: Type inference failed for: r36v46 */
                /* JADX WARN: Type inference failed for: r36v47 */
                /* JADX WARN: Type inference failed for: r36v48 */
                /* JADX WARN: Type inference failed for: r36v49 */
                /* JADX WARN: Type inference failed for: r36v5 */
                /* JADX WARN: Type inference failed for: r36v50 */
                /* JADX WARN: Type inference failed for: r36v6, types: [java.lang.String] */
                /* JADX WARN: Type inference failed for: r36v7 */
                /* JADX WARN: Type inference failed for: r36v8, types: [java.lang.String] */
                /* JADX WARN: Type inference failed for: r36v9 */
                /* JADX WARN: Type inference failed for: r3v196 */
                /* JADX WARN: Type inference failed for: r4v1354 */
                /* JADX WARN: Type inference failed for: r4v253, types: [java.util.regex.Pattern] */
                /* JADX WARN: Type inference failed for: r4v318 */
                /* JADX WARN: Type inference failed for: r4v319 */
                /* JADX WARN: Type inference failed for: r4v394, types: [java.lang.CharSequence] */
                /* JADX WARN: Type inference failed for: r5v251 */
                /* JADX WARN: Type inference failed for: r5v387 */
                /* JADX WARN: Type inference failed for: r5v388, types: [java.lang.CharSequence] */
                /* JADX WARN: Type inference failed for: r5v611 */
                /* JADX WARN: Type inference failed for: r5v612 */
                /* JADX WARN: Type inference failed for: r5v616, types: [java.lang.CharSequence] */
                /* JADX WARN: Type inference failed for: r5v923 */
                /* JADX WARN: Type inference failed for: r5v924 */
                /* JADX WARN: Type inference failed for: r8v397 */
                /* JADX WARN: Type inference failed for: r8v398 */
                /* JADX WARN: Type inference failed for: r8v444, types: [java.lang.CharSequence] */
                /* JADX WARN: Type inference failed for: r8v462 */
                /* JADX WARN: Type inference failed for: r8v463 */
                /* JADX WARN: Type inference failed for: r8v703, types: [java.lang.CharSequence] */
                /* JADX WARN: Type inference failed for: r8v904 */
                /* JADX WARN: Type inference failed for: r8v905 */
                /* JADX WARN: Type inference failed for: r9v129, types: [java.lang.Object[]] */
                /* JADX WARN: Type inference failed for: r9v130 */
                /* JADX WARN: Type inference failed for: r9v138 */
                /* JADX WARN: Type inference failed for: r9v144 */
                /* JADX WARN: Type inference failed for: r9v145 */
                /* JADX WARN: Type inference failed for: r9v146 */
                /* JADX WARN: Type inference failed for: r9v147 */
                /* JADX WARN: Type inference failed for: r9v148, types: [java.lang.CharSequence, java.lang.String] */
                /* JADX WARN: Type inference failed for: r9v149 */
                /* JADX WARN: Type inference failed for: r9v153 */
                /* JADX WARN: Type inference failed for: r9v452 */
                /* JADX WARN: Type inference failed for: r9v463 */
                /* JADX WARN: Type inference failed for: r9v464 */
                /* JADX WARN: Type inference failed for: r9v465, types: [java.lang.CharSequence] */
                /* JADX WARN: Type inference failed for: r9v466 */
                /* JADX WARN: Type inference failed for: r9v587 */
                /* JADX WARN: Type inference failed for: r9v588 */
                /* JADX WARN: Type inference failed for: r9v589 */
                /* JADX WARN: Type inference failed for: r9v590 */
                /* JADX WARN: Type inference failed for: r9v591 */
                /* JADX WARN: Type inference failed for: r9v592 */
                /* JADX WARN: Type inference failed for: r9v593 */
                /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
                    java.util.NoSuchElementException
                    	at java.base/java.util.TreeMap.key(Unknown Source)
                    	at java.base/java.util.TreeMap.lastKey(Unknown Source)
                    	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
                    	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
                    	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
                    */
                public static java.lang.Object[] accessartificialFrame$78cbbd35(int r72, int r73, java.lang.Object r74, int r75, boolean r76) throws java.lang.Throwable {
                    /*
                        Method dump skipped, instruction units count: 20442
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.fresco.urimod.UriModifierInterface.ModificationResult.Modified.ModifiedToMaxDimens.accessartificialFrame$78cbbd35(int, int, java.lang.Object, int, boolean):java.lang.Object[]");
                }
            }
        }

        /* JADX INFO: loaded from: classes4.dex */
        public static final class FallbackToOriginalUrl extends ModificationResult {
            private final Integer bestAllowlistedSize;

            public static /* synthetic */ FallbackToOriginalUrl copy$default(FallbackToOriginalUrl fallbackToOriginalUrl, Integer num, int i, Object obj) {
                if ((i & 1) != 0) {
                    num = fallbackToOriginalUrl.bestAllowlistedSize;
                }
                return fallbackToOriginalUrl.copy(num);
            }

            public final Integer component1() {
                return this.bestAllowlistedSize;
            }

            public final FallbackToOriginalUrl copy(@Nullable Integer num) {
                return new FallbackToOriginalUrl(num);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof FallbackToOriginalUrl) && Intrinsics.areEqual(this.bestAllowlistedSize, ((FallbackToOriginalUrl) obj).bestAllowlistedSize);
            }

            public int hashCode() {
                Integer num = this.bestAllowlistedSize;
                if (num == null) {
                    return 0;
                }
                return num.hashCode();
            }

            @Override // com.facebook.fresco.urimod.UriModifierInterface.ModificationResult
            public String toString() {
                return "FallbackToOriginalUrl(bestAllowlistedSize=" + this.bestAllowlistedSize + ")";
            }

            @Override // com.facebook.fresco.urimod.UriModifierInterface.ModificationResult
            public Integer getBestAllowlistedSize() {
                return this.bestAllowlistedSize;
            }

            public FallbackToOriginalUrl(@Nullable Integer num) {
                super("FallbackToOriginalUrl", null);
                this.bestAllowlistedSize = num;
            }
        }

        /* JADX INFO: loaded from: classes4.dex */
        public static final class Unmodified extends ModificationResult {
            private final Integer bestAllowlistedSize;
            private final String reason;

            public static /* synthetic */ Unmodified copy$default(Unmodified unmodified, String str, Integer num, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = unmodified.reason;
                }
                if ((i & 2) != 0) {
                    num = unmodified.bestAllowlistedSize;
                }
                return unmodified.copy(str, num);
            }

            public final String component1() {
                return this.reason;
            }

            public final Integer component2() {
                return this.bestAllowlistedSize;
            }

            public final Unmodified copy(@NotNull String reason, @Nullable Integer num) {
                Intrinsics.checkNotNullParameter(reason, "reason");
                return new Unmodified(reason, num);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Unmodified)) {
                    return false;
                }
                Unmodified unmodified = (Unmodified) obj;
                return Intrinsics.areEqual(this.reason, unmodified.reason) && Intrinsics.areEqual(this.bestAllowlistedSize, unmodified.bestAllowlistedSize);
            }

            public int hashCode() {
                int iHashCode = this.reason.hashCode();
                Integer num = this.bestAllowlistedSize;
                return (iHashCode * 31) + (num == null ? 0 : num.hashCode());
            }

            @Override // com.facebook.fresco.urimod.UriModifierInterface.ModificationResult
            public String toString() {
                return "Unmodified(reason=" + this.reason + ", bestAllowlistedSize=" + this.bestAllowlistedSize + ")";
            }

            @Override // com.facebook.fresco.urimod.UriModifierInterface.ModificationResult
            public Integer getBestAllowlistedSize() {
                return this.bestAllowlistedSize;
            }

            public final String getReason() {
                return this.reason;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Unmodified(@NotNull String reason, @Nullable Integer num) {
                super("Unmodified(reason='" + reason + "'", null);
                Intrinsics.checkNotNullParameter(reason, "reason");
                this.reason = reason;
                this.bestAllowlistedSize = num;
            }
        }

        /* JADX INFO: loaded from: classes4.dex */
        public static final class FallbackToMbpMemoryCache extends ModificationResult {
            private final Integer bestAllowlistedSize;
            private final String isBestSize;

            public static /* synthetic */ FallbackToMbpMemoryCache copy$default(FallbackToMbpMemoryCache fallbackToMbpMemoryCache, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = fallbackToMbpMemoryCache.isBestSize;
                }
                return fallbackToMbpMemoryCache.copy(str);
            }

            public final String component1() {
                return this.isBestSize;
            }

            public final FallbackToMbpMemoryCache copy(@NotNull String isBestSize) {
                Intrinsics.checkNotNullParameter(isBestSize, "isBestSize");
                return new FallbackToMbpMemoryCache(isBestSize);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof FallbackToMbpMemoryCache) && Intrinsics.areEqual(this.isBestSize, ((FallbackToMbpMemoryCache) obj).isBestSize);
            }

            public int hashCode() {
                return this.isBestSize.hashCode();
            }

            @Override // com.facebook.fresco.urimod.UriModifierInterface.ModificationResult
            public String toString() {
                return "FallbackToMbpMemoryCache(isBestSize=" + this.isBestSize + ")";
            }

            public final String isBestSize() {
                return this.isBestSize;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public FallbackToMbpMemoryCache(@NotNull String isBestSize) {
                super("FallbackToMbpMemoryCache(" + isBestSize, null);
                Intrinsics.checkNotNullParameter(isBestSize, "isBestSize");
                this.isBestSize = isBestSize;
            }

            @Override // com.facebook.fresco.urimod.UriModifierInterface.ModificationResult
            public Integer getBestAllowlistedSize() {
                return this.bestAllowlistedSize;
            }
        }

        /* JADX INFO: loaded from: classes4.dex */
        public static final class FallbackToMbpDiskCache extends ModificationResult {
            private final Integer bestAllowlistedSize;
            private final boolean isBestSize;

            public static /* synthetic */ FallbackToMbpDiskCache copy$default(FallbackToMbpDiskCache fallbackToMbpDiskCache, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    z = fallbackToMbpDiskCache.isBestSize;
                }
                return fallbackToMbpDiskCache.copy(z);
            }

            public final boolean component1() {
                return this.isBestSize;
            }

            public final FallbackToMbpDiskCache copy(boolean z) {
                return new FallbackToMbpDiskCache(z);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof FallbackToMbpDiskCache) && this.isBestSize == ((FallbackToMbpDiskCache) obj).isBestSize;
            }

            public int hashCode() {
                return Boolean.hashCode(this.isBestSize);
            }

            @Override // com.facebook.fresco.urimod.UriModifierInterface.ModificationResult
            public String toString() {
                return "FallbackToMbpDiskCache(isBestSize=" + this.isBestSize + ")";
            }

            public final boolean isBestSize() {
                return this.isBestSize;
            }

            public FallbackToMbpDiskCache(boolean z) {
                super("FallbackToMbpDiskCache(isBestSize=" + z, null);
                this.isBestSize = z;
            }

            @Override // com.facebook.fresco.urimod.UriModifierInterface.ModificationResult
            public Integer getBestAllowlistedSize() {
                return this.bestAllowlistedSize;
            }
        }
    }
}
