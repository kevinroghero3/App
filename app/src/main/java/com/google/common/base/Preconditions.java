package com.google.common.base;

import android.graphics.Color;
import android.graphics.PointF;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.facebook.imageutils.JfifUtil;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.internal.sql.SqlDateTypeAdapter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.Random;
import javax.annotation.CheckForNull;
import o.ArtificialStackFrames;
import o.onRelationshipValidationResult;

/* JADX INFO: loaded from: classes2.dex */
@ElementTypesAreNonnullByDefault
public final class Preconditions {
    private static final byte[] $$c = {96, -63, 33, 4};
    private static final int $$d = 219;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$a = {Ascii.GS, Ascii.VT, Ascii.VT, -116, -11, -2, Ascii.FF};
    private static final int $$b = 6;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static long onPostMessage = 6713230418849359530L;

    /* JADX WARN: Code duplicated, block: B:10:0x0028  */
    /* JADX WARN: Code duplicated, block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0028 -> B:11:0x002a). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0028
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$e(short r5, int r6, byte r7) {
        /*
            int r6 = r6 * 3
            int r6 = 3 - r6
            int r5 = r5 * 2
            int r5 = 111 - r5
            byte[] r0 = com.google.common.base.Preconditions.$$c
            int r7 = r7 * 2
            int r1 = 1 - r7
            byte[] r1 = new byte[r1]
            r2 = 0
            int r7 = 0 - r7
            if (r0 != 0) goto L18
            r3 = r7
            r4 = r2
            goto L2a
        L18:
            r3 = r2
        L19:
            int r6 = r6 + 1
            byte r4 = (byte) r5
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r7) goto L28
            java.lang.String r5 = new java.lang.String
            r5.<init>(r1, r2)
            return r5
        L28:
            r3 = r0[r6]
        L2a:
            int r5 = r5 + r3
            r3 = r4
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.base.Preconditions.$$e(short, int, byte):java.lang.String");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0026  */
    /* JADX WARN: Code duplicated, block: B:8:0x001e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0026 -> B:11:0x002e). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0026
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void b(short r6, short r7, byte r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = com.google.common.base.Preconditions.$$a
            int r6 = r6 * 2
            int r6 = r6 + 109
            int r7 = r7 * 3
            int r7 = r7 + 4
            int r8 = r8 * 3
            int r1 = r8 + 4
            byte[] r1 = new byte[r1]
            int r8 = r8 + 3
            r2 = 0
            if (r0 != 0) goto L18
            r3 = r7
            r4 = r2
            goto L2e
        L18:
            r3 = r2
        L19:
            byte r4 = (byte) r6
            r1[r3] = r4
            if (r3 != r8) goto L26
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L26:
            int r3 = r3 + 1
            r4 = r0[r7]
            r5 = r3
            r3 = r7
            r7 = r4
            r4 = r5
        L2e:
            int r7 = -r7
            int r6 = r6 + r7
            int r7 = r3 + 1
            int r6 = r6 + (-3)
            r3 = r4
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.base.Preconditions.b(short, short, byte, java.lang.Object[]):void");
    }

    private static void a(int i, char[] cArr, Object[] objArr) throws Throwable {
        int i2 = 2 % 2;
        onRelationshipValidationResult onrelationshipvalidationresult = new onRelationshipValidationResult();
        char[] cArrAccessartificialFrame = onRelationshipValidationResult.accessartificialFrame(onPostMessage ^ 2573525503365829440L, cArr, i);
        onrelationshipvalidationresult.e = 4;
        while (onrelationshipvalidationresult.e < cArrAccessartificialFrame.length) {
            onrelationshipvalidationresult.d = onrelationshipvalidationresult.e - 4;
            int i3 = onrelationshipvalidationresult.e;
            try {
                Object[] objArr2 = {Long.valueOf(cArrAccessartificialFrame[onrelationshipvalidationresult.e] ^ cArrAccessartificialFrame[onrelationshipvalidationresult.e % 4]), Long.valueOf(onrelationshipvalidationresult.d), Long.valueOf(onPostMessage)};
                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(797310229);
                if (objAccessartificialFrame == null) {
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(27 - Color.red(0), (char) (ExpandableListView.getPackedPositionGroup(0L) + 30690), 188 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), -1327449315, false, "k", new Class[]{Long.TYPE, Long.TYPE, Long.TYPE});
                }
                cArrAccessartificialFrame[i3] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                Object[] objArr3 = {onrelationshipvalidationresult, onrelationshipvalidationresult};
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(321542193);
                if (objAccessartificialFrame2 == null) {
                    byte b = (byte) 0;
                    byte b2 = b;
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(33 - ExpandableListView.getPackedPositionGroup(0L), (char) (ViewConfiguration.getKeyRepeatDelay() >> 16), 1483 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), -1940971975, false, $$e(b, b2, b2), new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame2).invoke(null, objArr3);
                int i4 = $11 + 1;
                $10 = i4 % 128;
                int i5 = i4 % 2;
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }
        String str = new String(cArrAccessartificialFrame, 4, cArrAccessartificialFrame.length - 4);
        int i6 = $11 + 61;
        $10 = i6 % 128;
        int i7 = i6 % 2;
        objArr[0] = str;
    }

    private Preconditions() {
    }

    public static void checkArgument(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkArgument(boolean z, @CheckForNull Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static void checkArgument(boolean z, String str, @CheckForNull Object... objArr) {
        if (!z) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, objArr));
        }
    }

    public static void checkArgument(boolean z, String str, char c) {
        if (!z) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Character.valueOf(c)));
        }
    }

    public static void checkArgument(boolean z, String str, int i) {
        if (!z) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Integer.valueOf(i)));
        }
    }

    public static void checkArgument(boolean z, String str, long j) {
        if (!z) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Long.valueOf(j)));
        }
    }

    public static void checkArgument(boolean z, String str, @CheckForNull Object obj) {
        if (!z) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, obj));
        }
    }

    public static void checkArgument(boolean z, String str, char c, char c2) {
        if (!z) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Character.valueOf(c), Character.valueOf(c2)));
        }
    }

    public static void checkArgument(boolean z, String str, char c, int i) {
        if (!z) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Character.valueOf(c), Integer.valueOf(i)));
        }
    }

    public static void checkArgument(boolean z, String str, char c, long j) {
        if (!z) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Character.valueOf(c), Long.valueOf(j)));
        }
    }

    public static void checkArgument(boolean z, String str, char c, @CheckForNull Object obj) {
        if (!z) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Character.valueOf(c), obj));
        }
    }

    public static void checkArgument(boolean z, String str, int i, char c) {
        if (!z) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Integer.valueOf(i), Character.valueOf(c)));
        }
    }

    public static void checkArgument(boolean z, String str, int i, int i2) {
        if (!z) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Integer.valueOf(i), Integer.valueOf(i2)));
        }
    }

    public static void checkArgument(boolean z, String str, int i, long j) {
        if (!z) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Integer.valueOf(i), Long.valueOf(j)));
        }
    }

    public static void checkArgument(boolean z, String str, int i, @CheckForNull Object obj) {
        if (!z) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Integer.valueOf(i), obj));
        }
    }

    public static void checkArgument(boolean z, String str, long j, char c) {
        if (!z) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Long.valueOf(j), Character.valueOf(c)));
        }
    }

    public static void checkArgument(boolean z, String str, long j, int i) {
        if (!z) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Long.valueOf(j), Integer.valueOf(i)));
        }
    }

    public static void checkArgument(boolean z, String str, long j, long j2) {
        if (!z) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Long.valueOf(j), Long.valueOf(j2)));
        }
    }

    public static void checkArgument(boolean z, String str, long j, @CheckForNull Object obj) {
        if (!z) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Long.valueOf(j), obj));
        }
    }

    public static void checkArgument(boolean z, String str, @CheckForNull Object obj, char c) {
        if (!z) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, obj, Character.valueOf(c)));
        }
    }

    public static void checkArgument(boolean z, String str, @CheckForNull Object obj, int i) {
        if (!z) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, obj, Integer.valueOf(i)));
        }
    }

    public static void checkArgument(boolean z, String str, @CheckForNull Object obj, long j) {
        if (!z) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, obj, Long.valueOf(j)));
        }
    }

    public static void checkArgument(boolean z, String str, @CheckForNull Object obj, @CheckForNull Object obj2) {
        if (!z) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, obj, obj2));
        }
    }

    public static void checkArgument(boolean z, String str, @CheckForNull Object obj, @CheckForNull Object obj2, @CheckForNull Object obj3) {
        if (!z) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, obj, obj2, obj3));
        }
    }

    public static void checkArgument(boolean z, String str, @CheckForNull Object obj, @CheckForNull Object obj2, @CheckForNull Object obj3, @CheckForNull Object obj4) {
        if (!z) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, obj, obj2, obj3, obj4));
        }
    }

    public static void checkState(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    public static void checkState(boolean z, @CheckForNull Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static void checkState(boolean z, @CheckForNull String str, @CheckForNull Object... objArr) {
        if (!z) {
            throw new IllegalStateException(Strings.lenientFormat(str, objArr));
        }
    }

    public static void checkState(boolean z, String str, char c) {
        if (!z) {
            throw new IllegalStateException(Strings.lenientFormat(str, Character.valueOf(c)));
        }
    }

    public static void checkState(boolean z, String str, int i) {
        if (!z) {
            throw new IllegalStateException(Strings.lenientFormat(str, Integer.valueOf(i)));
        }
    }

    public static void checkState(boolean z, String str, long j) {
        if (!z) {
            throw new IllegalStateException(Strings.lenientFormat(str, Long.valueOf(j)));
        }
    }

    public static void checkState(boolean z, String str, @CheckForNull Object obj) {
        if (!z) {
            throw new IllegalStateException(Strings.lenientFormat(str, obj));
        }
    }

    public static void checkState(boolean z, String str, char c, char c2) {
        if (!z) {
            throw new IllegalStateException(Strings.lenientFormat(str, Character.valueOf(c), Character.valueOf(c2)));
        }
    }

    public static void checkState(boolean z, String str, char c, int i) {
        if (!z) {
            throw new IllegalStateException(Strings.lenientFormat(str, Character.valueOf(c), Integer.valueOf(i)));
        }
    }

    public static void checkState(boolean z, String str, char c, long j) {
        if (!z) {
            throw new IllegalStateException(Strings.lenientFormat(str, Character.valueOf(c), Long.valueOf(j)));
        }
    }

    public static void checkState(boolean z, String str, char c, @CheckForNull Object obj) {
        if (!z) {
            throw new IllegalStateException(Strings.lenientFormat(str, Character.valueOf(c), obj));
        }
    }

    public static void checkState(boolean z, String str, int i, char c) {
        if (!z) {
            throw new IllegalStateException(Strings.lenientFormat(str, Integer.valueOf(i), Character.valueOf(c)));
        }
    }

    public static void checkState(boolean z, String str, int i, int i2) {
        if (!z) {
            throw new IllegalStateException(Strings.lenientFormat(str, Integer.valueOf(i), Integer.valueOf(i2)));
        }
    }

    public static void checkState(boolean z, String str, int i, long j) {
        if (!z) {
            throw new IllegalStateException(Strings.lenientFormat(str, Integer.valueOf(i), Long.valueOf(j)));
        }
    }

    public static void checkState(boolean z, String str, int i, @CheckForNull Object obj) {
        if (!z) {
            throw new IllegalStateException(Strings.lenientFormat(str, Integer.valueOf(i), obj));
        }
    }

    public static void checkState(boolean z, String str, long j, char c) {
        if (!z) {
            throw new IllegalStateException(Strings.lenientFormat(str, Long.valueOf(j), Character.valueOf(c)));
        }
    }

    public static void checkState(boolean z, String str, long j, int i) {
        if (!z) {
            throw new IllegalStateException(Strings.lenientFormat(str, Long.valueOf(j), Integer.valueOf(i)));
        }
    }

    public static void checkState(boolean z, String str, long j, long j2) {
        if (!z) {
            throw new IllegalStateException(Strings.lenientFormat(str, Long.valueOf(j), Long.valueOf(j2)));
        }
    }

    public static void checkState(boolean z, String str, long j, @CheckForNull Object obj) {
        if (!z) {
            throw new IllegalStateException(Strings.lenientFormat(str, Long.valueOf(j), obj));
        }
    }

    public static void checkState(boolean z, String str, @CheckForNull Object obj, char c) {
        if (!z) {
            throw new IllegalStateException(Strings.lenientFormat(str, obj, Character.valueOf(c)));
        }
    }

    public static void checkState(boolean z, String str, @CheckForNull Object obj, int i) {
        if (!z) {
            throw new IllegalStateException(Strings.lenientFormat(str, obj, Integer.valueOf(i)));
        }
    }

    public static void checkState(boolean z, String str, @CheckForNull Object obj, long j) {
        if (!z) {
            throw new IllegalStateException(Strings.lenientFormat(str, obj, Long.valueOf(j)));
        }
    }

    public static void checkState(boolean z, String str, @CheckForNull Object obj, @CheckForNull Object obj2) {
        if (!z) {
            throw new IllegalStateException(Strings.lenientFormat(str, obj, obj2));
        }
    }

    public static void checkState(boolean z, String str, @CheckForNull Object obj, @CheckForNull Object obj2, @CheckForNull Object obj3) {
        if (!z) {
            throw new IllegalStateException(Strings.lenientFormat(str, obj, obj2, obj3));
        }
    }

    public static void checkState(boolean z, String str, @CheckForNull Object obj, @CheckForNull Object obj2, @CheckForNull Object obj3, @CheckForNull Object obj4) {
        if (!z) {
            throw new IllegalStateException(Strings.lenientFormat(str, obj, obj2, obj3, obj4));
        }
    }

    public static <T> T checkNotNull(@CheckForNull T t) {
        t.getClass();
        return t;
    }

    public static <T> T checkNotNull(@CheckForNull T t, @CheckForNull Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static <T> T checkNotNull(@CheckForNull T t, String str, @CheckForNull Object... objArr) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Strings.lenientFormat(str, objArr));
    }

    public static <T> T checkNotNull(@CheckForNull T t, String str, char c) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Character.valueOf(c)));
    }

    public static <T> T checkNotNull(@CheckForNull T t, String str, int i) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Integer.valueOf(i)));
    }

    public static <T> T checkNotNull(@CheckForNull T t, String str, long j) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Long.valueOf(j)));
    }

    public static <T> T checkNotNull(@CheckForNull T t, String str, @CheckForNull Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Strings.lenientFormat(str, obj));
    }

    public static <T> T checkNotNull(@CheckForNull T t, String str, char c, char c2) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Character.valueOf(c), Character.valueOf(c2)));
    }

    public static <T> T checkNotNull(@CheckForNull T t, String str, char c, int i) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Character.valueOf(c), Integer.valueOf(i)));
    }

    public static <T> T checkNotNull(@CheckForNull T t, String str, char c, long j) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Character.valueOf(c), Long.valueOf(j)));
    }

    public static <T> T checkNotNull(@CheckForNull T t, String str, char c, @CheckForNull Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Character.valueOf(c), obj));
    }

    public static <T> T checkNotNull(@CheckForNull T t, String str, int i, char c) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Integer.valueOf(i), Character.valueOf(c)));
    }

    public static <T> T checkNotNull(@CheckForNull T t, String str, int i, int i2) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Integer.valueOf(i), Integer.valueOf(i2)));
    }

    public static <T> T checkNotNull(@CheckForNull T t, String str, int i, long j) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Integer.valueOf(i), Long.valueOf(j)));
    }

    public static <T> T checkNotNull(@CheckForNull T t, String str, int i, @CheckForNull Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Integer.valueOf(i), obj));
    }

    public static <T> T checkNotNull(@CheckForNull T t, String str, long j, char c) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Long.valueOf(j), Character.valueOf(c)));
    }

    public static <T> T checkNotNull(@CheckForNull T t, String str, long j, int i) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Long.valueOf(j), Integer.valueOf(i)));
    }

    public static <T> T checkNotNull(@CheckForNull T t, String str, long j, long j2) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Long.valueOf(j), Long.valueOf(j2)));
    }

    public static <T> T checkNotNull(@CheckForNull T t, String str, long j, @CheckForNull Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Long.valueOf(j), obj));
    }

    public static <T> T checkNotNull(@CheckForNull T t, String str, @CheckForNull Object obj, char c) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Strings.lenientFormat(str, obj, Character.valueOf(c)));
    }

    public static <T> T checkNotNull(@CheckForNull T t, String str, @CheckForNull Object obj, int i) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Strings.lenientFormat(str, obj, Integer.valueOf(i)));
    }

    public static <T> T checkNotNull(@CheckForNull T t, String str, @CheckForNull Object obj, long j) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Strings.lenientFormat(str, obj, Long.valueOf(j)));
    }

    public static <T> T checkNotNull(@CheckForNull T t, String str, @CheckForNull Object obj, @CheckForNull Object obj2) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Strings.lenientFormat(str, obj, obj2));
    }

    public static <T> T checkNotNull(@CheckForNull T t, String str, @CheckForNull Object obj, @CheckForNull Object obj2, @CheckForNull Object obj3) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Strings.lenientFormat(str, obj, obj2, obj3));
    }

    public static <T> T checkNotNull(@CheckForNull T t, String str, @CheckForNull Object obj, @CheckForNull Object obj2, @CheckForNull Object obj3, @CheckForNull Object obj4) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Strings.lenientFormat(str, obj, obj2, obj3, obj4));
    }

    public static int checkElementIndex(int i, int i2) {
        return checkElementIndex(i, i2, FirebaseAnalytics.Param.INDEX);
    }

    public static int checkElementIndex(int i, int i2, String str) {
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException(badElementIndex(i, i2, str));
        }
        return i;
    }

    private static String badElementIndex(int i, int i2, String str) {
        if (i < 0) {
            return Strings.lenientFormat("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        if (i2 < 0) {
            StringBuilder sb = new StringBuilder(26);
            sb.append("negative size: ");
            sb.append(i2);
            throw new IllegalArgumentException(sb.toString());
        }
        return Strings.lenientFormat("%s (%s) must be less than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
    }

    public static int checkPositionIndex(int i, int i2) {
        return checkPositionIndex(i, i2, FirebaseAnalytics.Param.INDEX);
    }

    public static int checkPositionIndex(int i, int i2, String str) {
        if (i < 0 || i > i2) {
            throw new IndexOutOfBoundsException(badPositionIndex(i, i2, str));
        }
        return i;
    }

    private static String badPositionIndex(int i, int i2, String str) {
        if (i < 0) {
            return Strings.lenientFormat("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        if (i2 < 0) {
            StringBuilder sb = new StringBuilder(26);
            sb.append("negative size: ");
            sb.append(i2);
            throw new IllegalArgumentException(sb.toString());
        }
        return Strings.lenientFormat("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
    }

    public static void checkPositionIndexes(int i, int i2, int i3) {
        if (i < 0 || i2 < i || i2 > i3) {
            throw new IndexOutOfBoundsException(badPositionIndexes(i, i2, i3));
        }
    }

    private static String badPositionIndexes(int i, int i2, int i3) {
        if (i < 0 || i > i3) {
            return badPositionIndex(i, i3, "start index");
        }
        if (i2 < 0 || i2 > i3) {
            return badPositionIndex(i2, i3, "end index");
        }
        return Strings.lenientFormat("end index (%s) must not be less than start index (%s)", Integer.valueOf(i2), Integer.valueOf(i));
    }

    /* JADX WARN: Code duplicated, block: B:101:0x070f A[Catch: Exception -> 0x088c, TRY_ENTER, TRY_LEAVE, TryCatch #1 {Exception -> 0x088c, blocks: (B:90:0x06a3, B:93:0x06d0, B:96:0x06d8, B:98:0x0701, B:101:0x070f, B:105:0x071c, B:108:0x0741, B:110:0x076a, B:113:0x0778, B:117:0x086f, B:121:0x0875, B:122:0x087b, B:103:0x0717, B:124:0x087d, B:125:0x0883, B:126:0x0884, B:128:0x0888, B:109:0x074b, B:97:0x06e2), top: B:143:0x06a3, inners: #0, #5 }] */
    /* JADX WARN: Code duplicated, block: B:103:0x0717 A[Catch: Exception -> 0x088c, TRY_ENTER, TryCatch #1 {Exception -> 0x088c, blocks: (B:90:0x06a3, B:93:0x06d0, B:96:0x06d8, B:98:0x0701, B:101:0x070f, B:105:0x071c, B:108:0x0741, B:110:0x076a, B:113:0x0778, B:117:0x086f, B:121:0x0875, B:122:0x087b, B:103:0x0717, B:124:0x087d, B:125:0x0883, B:126:0x0884, B:128:0x0888, B:109:0x074b, B:97:0x06e2), top: B:143:0x06a3, inners: #0, #5 }] */
    /* JADX WARN: Code duplicated, block: B:105:0x071c A[Catch: Exception -> 0x088c, TryCatch #1 {Exception -> 0x088c, blocks: (B:90:0x06a3, B:93:0x06d0, B:96:0x06d8, B:98:0x0701, B:101:0x070f, B:105:0x071c, B:108:0x0741, B:110:0x076a, B:113:0x0778, B:117:0x086f, B:121:0x0875, B:122:0x087b, B:103:0x0717, B:124:0x087d, B:125:0x0883, B:126:0x0884, B:128:0x0888, B:109:0x074b, B:97:0x06e2), top: B:143:0x06a3, inners: #0, #5 }] */
    /* JADX WARN: Code duplicated, block: B:107:0x073f  */
    /* JADX WARN: Code duplicated, block: B:108:0x0741 A[Catch: Exception -> 0x088c, TRY_LEAVE, TryCatch #1 {Exception -> 0x088c, blocks: (B:90:0x06a3, B:93:0x06d0, B:96:0x06d8, B:98:0x0701, B:101:0x070f, B:105:0x071c, B:108:0x0741, B:110:0x076a, B:113:0x0778, B:117:0x086f, B:121:0x0875, B:122:0x087b, B:103:0x0717, B:124:0x087d, B:125:0x0883, B:126:0x0884, B:128:0x0888, B:109:0x074b, B:97:0x06e2), top: B:143:0x06a3, inners: #0, #5 }] */
    /* JADX WARN: Code duplicated, block: B:113:0x0778 A[Catch: Exception -> 0x088c, TRY_ENTER, TRY_LEAVE, TryCatch #1 {Exception -> 0x088c, blocks: (B:90:0x06a3, B:93:0x06d0, B:96:0x06d8, B:98:0x0701, B:101:0x070f, B:105:0x071c, B:108:0x0741, B:110:0x076a, B:113:0x0778, B:117:0x086f, B:121:0x0875, B:122:0x087b, B:103:0x0717, B:124:0x087d, B:125:0x0883, B:126:0x0884, B:128:0x0888, B:109:0x074b, B:97:0x06e2), top: B:143:0x06a3, inners: #0, #5 }] */
    /* JADX WARN: Code duplicated, block: B:117:0x086f A[Catch: Exception -> 0x088c, TRY_ENTER, TRY_LEAVE, TryCatch #1 {Exception -> 0x088c, blocks: (B:90:0x06a3, B:93:0x06d0, B:96:0x06d8, B:98:0x0701, B:101:0x070f, B:105:0x071c, B:108:0x0741, B:110:0x076a, B:113:0x0778, B:117:0x086f, B:121:0x0875, B:122:0x087b, B:103:0x0717, B:124:0x087d, B:125:0x0883, B:126:0x0884, B:128:0x0888, B:109:0x074b, B:97:0x06e2), top: B:143:0x06a3, inners: #0, #5 }] */
    /* JADX WARN: Code duplicated, block: B:126:0x0884 A[Catch: Exception -> 0x088c, TRY_LEAVE, TryCatch #1 {Exception -> 0x088c, blocks: (B:90:0x06a3, B:93:0x06d0, B:96:0x06d8, B:98:0x0701, B:101:0x070f, B:105:0x071c, B:108:0x0741, B:110:0x076a, B:113:0x0778, B:117:0x086f, B:121:0x0875, B:122:0x087b, B:103:0x0717, B:124:0x087d, B:125:0x0883, B:126:0x0884, B:128:0x0888, B:109:0x074b, B:97:0x06e2), top: B:143:0x06a3, inners: #0, #5 }] */
    /* JADX WARN: Code duplicated, block: B:93:0x06d0 A[Catch: Exception -> 0x088c, TRY_ENTER, TryCatch #1 {Exception -> 0x088c, blocks: (B:90:0x06a3, B:93:0x06d0, B:96:0x06d8, B:98:0x0701, B:101:0x070f, B:105:0x071c, B:108:0x0741, B:110:0x076a, B:113:0x0778, B:117:0x086f, B:121:0x0875, B:122:0x087b, B:103:0x0717, B:124:0x087d, B:125:0x0883, B:126:0x0884, B:128:0x0888, B:109:0x074b, B:97:0x06e2), top: B:143:0x06a3, inners: #0, #5 }] */
    /* JADX WARN: Code duplicated, block: B:95:0x06d6  */
    /* JADX WARN: Code duplicated, block: B:96:0x06d8 A[Catch: Exception -> 0x088c, TRY_LEAVE, TryCatch #1 {Exception -> 0x088c, blocks: (B:90:0x06a3, B:93:0x06d0, B:96:0x06d8, B:98:0x0701, B:101:0x070f, B:105:0x071c, B:108:0x0741, B:110:0x076a, B:113:0x0778, B:117:0x086f, B:121:0x0875, B:122:0x087b, B:103:0x0717, B:124:0x087d, B:125:0x0883, B:126:0x0884, B:128:0x0888, B:109:0x074b, B:97:0x06e2), top: B:143:0x06a3, inners: #0, #5 }] */
    public static Object[] coroutineCreation(int i, int i2) throws Throwable {
        Object[] objArr;
        int[] iArr;
        char c;
        int i3;
        int i4;
        int iINotificationSideChannel;
        int i5;
        Object[] objArr2;
        int i6;
        String line;
        File file;
        int i7;
        FileReader fileReader;
        BufferedReader bufferedReader;
        boolean zEquals;
        int i8;
        File file2;
        FileReader fileReader2;
        BufferedReader bufferedReader2;
        boolean zEquals2;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15 = 2 % 2;
        try {
            String[] strArr = new String[2];
            int i16 = -(ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1));
            int i17 = artificialFrame;
            int i18 = (i17 ^ 91) + ((i17 & 91) << 1);
            int i19 = i18 % 128;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i19;
            int i20 = i18 % 2;
            int i21 = (i16 * (-433)) - 216;
            int i22 = ~i16;
            int i23 = ~i;
            int i24 = ~((i22 ^ i23) | (i22 & i23));
            int i25 = ~(((-2) ^ i) | ((-2) & i));
            int i26 = ((i24 ^ i25) | (i25 & i24)) * JfifUtil.MARKER_EOI;
            int i27 = ((i21 | i26) << 1) - (i26 ^ i21);
            int i28 = ~((i22 & (-2)) | (i22 ^ (-2)));
            int i29 = (~i16) | i;
            int i30 = (i19 ^ 3) + ((i19 & 3) << 1);
            artificialFrame = i30 % 128;
            int i31 = i30 % 2;
            int i32 = ~i29;
            if (i31 == 0) {
                i11 = i27 >>> (JfifUtil.MARKER_EOI >> (i28 | i32));
            } else {
                int i33 = ((i28 & i32) | (i28 ^ i32)) * JfifUtil.MARKER_EOI;
                i11 = ((i27 & i33) << 1) + (i27 ^ i33);
            }
            int i34 = ~i;
            int i35 = JfifUtil.MARKER_EOI * ((~(((-2) & i34) | ((-2) ^ i34))) | i16);
            int i36 = (i11 & i35) + (i11 | i35);
            Object[] objArr3 = new Object[1];
            a(i36, new char[]{32645, 32748, 16621, 62836, 44759, 50503, 59939, 43087, 52490, 52216, 60876, 13049, 53424, 9637, 46512, 6809, 63763, 31841, 23678, 25389, 8529, 21506, 25799}, objArr3);
            strArr[0] = (String) objArr3[0];
            Object[] objArr4 = new Object[1];
            a((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) - 1, new char[]{45994, 46045, 6266, 44529, 35216, 57901, 21624, 25707, 38278, 30130, 51851, 35986, 7317, 32050, 37616, 42201, 13616, 9453, 31547, 56675, 60783, 3202}, objArr4);
            strArr[1] = (String) objArr4[0];
            int i37 = artificialFrame + 63;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i37 % 128;
            int i38 = i37 % 2;
            int i39 = 0;
            while (true) {
                if (i39 >= 2) {
                    objArr = new Object[]{new int[]{i}, new int[]{i}, new int[1], null};
                    int i40 = ~i;
                    int i41 = 714950381 | i40;
                    int i42 = (-1011743426) + (i41 * 495) + (((~i41) | 177554977) * 495);
                    int iINotificationSideChannel2 = SqlDateTypeAdapter.AnonymousClass1.INotificationSideChannel();
                    int i43 = (i42 * JfifUtil.MARKER_SOFn) + 191;
                    int i44 = -(-((~((i42 ^ iINotificationSideChannel2) | (i42 & iINotificationSideChannel2))) * 191));
                    int i45 = ((i43 | i44) << 1) - (i43 ^ i44);
                    int i46 = ~(((-1) ^ i42) | i42);
                    int i47 = ~((~iINotificationSideChannel2) | i42);
                    int i48 = -(-(((i47 & i46) | (i46 ^ i47)) * 191));
                    int i49 = (i45 & i48) + (i48 | i45);
                    int i50 = i49 * 375;
                    int i51 = -(-(i2 * (-747)));
                    int i52 = (i50 ^ i51) + ((i50 & i51) << 1);
                    int i53 = ~i49;
                    int i54 = ~(i53 | i2);
                    int i55 = ~((i40 & i49) | (i40 ^ i49));
                    int i56 = i52 + (((i55 & i54) | (i54 ^ i55)) * (-374));
                    int i57 = artificialFrame + 25;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i57 % 128;
                    if (i57 % 2 != 0) {
                        int i58 = i56 * (748 / (~((~i2) | i49)));
                        int i59 = ~i2;
                        int i60 = ~((i59 & i53) | (i53 ^ i59));
                        int i61 = ~(i23 | i49);
                        i12 = i58 >>> (374 % ((i60 & i61) | (i60 ^ i61)));
                    } else {
                        int i62 = ~i2;
                        int i63 = (~((i62 ^ i49) | (i62 & i49))) * 748;
                        int i64 = ~((i62 & i53) | (i53 ^ i62));
                        int i65 = ~(i23 | i49);
                        i12 = (((i56 ^ i63) + ((i56 & i63) << 1)) - (~(-(-(((i64 & i65) | (i64 ^ i65)) * 374))))) - 1;
                    }
                    int i66 = i12 ^ (i12 << 13);
                    int i67 = i66 >>> 17;
                    int i68 = ((~i66) & i67) | ((~i67) & i66);
                    int i69 = i68 << 5;
                    ((int[]) objArr[2])[0] = ((~i68) & i69) | ((~i69) & i68);
                    break;
                }
                String str = strArr[i39];
                int iRed = Color.red(0);
                char[] cArr = {14314, 14219, 40068, 10496, 26370, 3250, 61651, 57389, 4479, 53535, 9242, 10327, 39125, 63949, 31752, 'U', 45431, 40964, 38331, 31182};
                int i70 = getARTIFICIAL_FRAME_PACKAGE_NAME + 21;
                artificialFrame = i70 % 128;
                int i71 = i70 % 2;
                Object[] objArr5 = new Object[1];
                a(iRed, cArr, objArr5);
                Class<?> cls = Class.forName((String) objArr5[0]);
                if (!(!((Boolean) cls.getMethod(str, new Class[0]).invoke(cls, null)).booleanValue())) {
                    int i72 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                    int i73 = ((i72 | 27) << 1) - (i72 ^ 27);
                    artificialFrame = i73 % 128;
                    int i74 = i73 % 2;
                    int i75 = ~i;
                    int i76 = (i & (-2)) | (i75 & 1);
                    objArr = new Object[4];
                    int i77 = (i72 & 125) + (i72 | 125);
                    int i78 = i77 % 128;
                    artificialFrame = i78;
                    if (i77 % 2 == 0) {
                        objArr[1] = new int[1];
                        objArr[1] = new int[0];
                        objArr[4] = new int[1];
                    } else {
                        objArr[0] = new int[1];
                        objArr[1] = new int[1];
                        objArr[2] = new int[1];
                    }
                    ((int[]) objArr[0])[0] = i;
                    ((int[]) objArr[1])[0] = i76;
                    objArr[3] = null;
                    int i79 = (-221413010) + (((~((-425427281) | i75)) | 5833024) * 168) + ((~((-5833025) | i)) * 168) + (((~((-553196495) | i75)) | 547363470 | (~((-419594257) | i))) * 168) + 16;
                    int i80 = (i78 & 67) + (i78 | 67);
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i80 % 128;
                    if (i80 % 2 != 0) {
                        int i81 = i2 * i79;
                        i13 = i81 ^ (i81 >> 45);
                        i14 = i13 / 71;
                    } else {
                        int i82 = ((i2 | i79) << 1) - (i2 ^ i79);
                        int i83 = i82 << 13;
                        i13 = ((~i82) & i83) | ((~i83) & i82);
                        i14 = i13 >>> 17;
                    }
                    int i84 = i13 ^ i14;
                    int i85 = i84 << 5;
                    ((int[]) objArr[2])[0] = (i84 | i85) & (~(i84 & i85));
                    break;
                }
                int i86 = (i39 ^ (-100)) + ((i39 & (-100)) << 1);
                i39 = (i86 ^ 101) + ((i86 & 101) << 1);
            }
        } catch (Exception unused) {
            objArr = new Object[]{new int[]{i}, new int[]{(~(i & 2)) & (i | 2)}, new int[1], null};
            int i87 = ~((~((int) Runtime.getRuntime().freeMemory())) | 507033691);
            int i88 = ((35657752 | i87) * (-374)) + 1228779084 + ((i87 | 471375939) * 374);
            int i89 = -(-((i88 & 16) + (i88 | 16)));
            int i90 = (i2 ^ i89) + ((i89 & i2) << 1);
            int i91 = (i90 << 13) ^ i90;
            int i92 = i91 >>> 17;
            int i93 = ((~i91) & i92) | ((~i92) & i91);
            int i94 = i93 << 5;
            ((int[]) objArr[2])[0] = ((~i93) & i94) | ((~i94) & i93);
        }
        if (i != ((int[]) objArr[1])[0]) {
            return objArr;
        }
        try {
            Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(590025679);
            if (objAccessartificialFrame == null) {
                int scrollBarSize = 9 - (ViewConfiguration.getScrollBarSize() >> 8);
                char doubleTapTimeout = (char) (64610 - (ViewConfiguration.getDoubleTapTimeout() >> 16));
                int i95 = (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 1805;
                byte b = (byte) 0;
                byte b2 = b;
                Object[] objArr6 = new Object[1];
                b(b, b2, b2, objArr6);
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(scrollBarSize, doubleTapTimeout, i95, -1135716921, false, (String) objArr6[0], new Class[0]);
            }
            long jLongValue = ((Long) ((Method) objAccessartificialFrame).invoke(null, null)).longValue();
            long j = 103988010;
            long j2 = -1;
            long j3 = jLongValue ^ j2;
            long jNextInt = ((((long) new Random().nextInt(115232520)) ^ j2) | jLongValue) ^ j2;
            long j4 = j ^ j2;
            long j5 = (((long) (-1939)) * j) + (((long) 971) * jLongValue) + (((long) (-970)) * (((j3 | j) ^ j2) | jNextInt)) + (((long) 1940) * ((j4 | jLongValue) ^ j2)) + (((long) 970) * (jNextInt | ((j4 | j3) ^ j2))) + ((long) 236220024);
            int iMyPid = Process.myPid();
            int i96 = ((int) (j5 >> 32)) & (1704617878 + (((~((-1763698273) | iMyPid)) | 1091945056) * 305) + (((~((~iMyPid) | (-1763698273))) | 1094042612) * 305));
            int i97 = ~((int) SystemClock.uptimeMillis());
            int i98 = ~((-1318855965) | i97);
            int i99 = ((int) j5) & (755545945 + (((-118370446) | i98) * 764) + (((~(i97 | (-118370446))) | 16912513) * (-1528)) + ((1234310545 | i98) * 764));
            if (((i96 & i99) | (i96 ^ i99)) == 1) {
                int i100 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                int i101 = i100 + 43;
                artificialFrame = i101 % 128;
                int i102 = i101 % 2;
                int[] iArr2 = new int[1];
                int[] iArr3 = {(~(i & 10)) & (i | 10)};
                int i103 = i100 + 79;
                int i104 = i103 % 128;
                artificialFrame = i104;
                int i105 = i103 % 2;
                Object[] objArr7 = {new int[]{i}, iArr3, iArr2, null};
                int i106 = ~i;
                int i107 = (((~((-815829057) | i106)) * 130) - 37553314) + (((~((-815829057) | i)) | 84019360) * 130);
                int i108 = i104 + 17;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i108 % 128;
                if (i108 % 2 != 0) {
                    int i109 = ~(((-17) ^ i107) | ((-17) & i107));
                    i10 = ((-31600) / (i107 + 989)) >> (988 >>> ((i109 & i) | (i ^ i109)));
                } else {
                    int i110 = -(-(i107 * 989));
                    int i111 = (((-31600) | i110) << 1) - (i110 ^ (-31600));
                    int i112 = ~(((-17) ^ i107) | ((-17) & i107));
                    i10 = (((i112 & i) | (i ^ i112)) * 988) + i111;
                }
                int i113 = ~i107;
                int i114 = ~((i113 & 16) | (i113 ^ 16));
                int i115 = ~((~i) | 16);
                int i116 = -(-(((i114 & i115) | (i114 ^ i115)) * (-1976)));
                int i117 = i2 + (i10 & i116) + (i10 | i116) + (((~((i106 & i107) | (i106 ^ i107))) | (~(((-17) ^ i107) | ((-17) & i107))) | (~((~i107) | i))) * 988);
                int i118 = i117 << 13;
                int i119 = (i117 | i118) & (~(i117 & i118));
                int i120 = i119 >>> 17;
                int i121 = ((~i119) & i120) | ((~i120) & i119);
                int i122 = i121 << 5;
                iArr2[0] = ((~i121) & i122) | ((~i122) & i121);
                int i123 = (i104 ^ 53) + ((i104 & 53) << 1);
                getARTIFICIAL_FRAME_PACKAGE_NAME = i123 % 128;
                int i124 = i123 % 2;
                i6 = 1;
                objArr2 = objArr7;
            } else {
                Object[] objArr8 = new Object[4];
                int[] iArr4 = new int[1];
                objArr8[0] = iArr4;
                int[] iArr5 = new int[1];
                objArr8[1] = iArr5;
                objArr8[2] = new int[1];
                int i125 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                int i126 = ((i125 | 9) << 1) - (i125 ^ 9);
                artificialFrame = i126 % 128;
                if (i126 % 2 == 0) {
                    iArr5[0] = i;
                    iArr = iArr5;
                    c = 1;
                    i3 = 1;
                } else {
                    iArr4[0] = i;
                    iArr = iArr5;
                    c = 0;
                    i3 = 0;
                }
                iArr[c] = i;
                objArr8[3] = null;
                int i127 = ~i;
                int i128 = 1669747082 + ((8921639 | i127) * 1324) + (((~(814244471 | i)) | (~(164379303 | i))) * (-1324)) + 381528544;
                int i129 = i3 * (-830);
                int i130 = -(-(i128 * 832));
                int i131 = (i129 ^ i130) + ((i129 & i130) << 1);
                int i132 = ~i128;
                int i133 = ~((i127 & i132) | (i132 ^ i127));
                int i134 = (i3 ^ i128) | (i3 & i128);
                int i135 = ~((i134 & i) | (i134 ^ i));
                int i136 = -(-(((i133 & i135) | (i133 ^ i135)) * (-831)));
                int i137 = (i131 & i136) + (i136 | i131);
                int i138 = i125 + 73;
                artificialFrame = i138 % 128;
                int i139 = i138 % 2;
                int i140 = (i132 ^ i3) | (i132 & i3);
                int i141 = (-1662) * (~((i140 & i) | (i140 ^ i)));
                int i142 = (i137 & i141) + (i141 | i137);
                int i143 = (~((i3 & i) | (i3 ^ i))) | (~((~i3) | (~i)));
                int i144 = i125 + 99;
                artificialFrame = i144 % 128;
                int i145 = i144 % 2;
                int i146 = ~((i128 ^ i) | (i128 & i));
                if (i145 == 0) {
                    int i147 = -(831 >>> ((i143 & i146) | (i143 ^ i146)));
                    i4 = ((i142 | i147) << 1) - (i142 ^ i147);
                    iINotificationSideChannel = SqlDateTypeAdapter.AnonymousClass1.INotificationSideChannel();
                    int i148 = (-665) >>> i4;
                    int i149 = -(334 / i2);
                    i5 = (((i148 ^ i149) + ((i148 & i149) << 1)) - (~(-((-333) >> (~i4))))) - 1;
                } else {
                    int i150 = -(-(((i143 & i146) | (i143 ^ i146)) * 831));
                    i4 = (i142 ^ i150) + ((i142 & i150) << 1);
                    iINotificationSideChannel = SqlDateTypeAdapter.AnonymousClass1.INotificationSideChannel();
                    int i151 = i4 * (-665);
                    int i152 = i2 * 334;
                    i5 = (((i151 ^ i152) + ((i151 & i152) << 1)) - (~(-(-((~i4) * (-333)))))) - 1;
                }
                int i153 = ~i4;
                int i154 = ~iINotificationSideChannel;
                int i155 = ~((i153 & i154) | (i153 ^ i154));
                int i156 = ~((i2 ^ iINotificationSideChannel) | (i2 & iINotificationSideChannel));
                int i157 = 333 * ((i155 & i156) | (i155 ^ i156));
                int i158 = (i5 & i157) + (i157 | i5);
                int i159 = ~i4;
                int i160 = ~((iINotificationSideChannel & i159) | (i159 ^ iINotificationSideChannel));
                int i161 = ~((i154 ^ i2) | (i154 & i2));
                int i162 = ((i160 & i161) | (i160 ^ i161)) * 333;
                int i163 = ((i158 | i162) << 1) - (i162 ^ i158);
                int i164 = i163 << 13;
                int i165 = (i164 & (~i163)) | ((~i164) & i163);
                int i166 = i165 >>> 17;
                int i167 = (i165 | i166) & (~(i165 & i166));
                int i168 = i167 << 5;
                ((int[]) objArr8[2])[0] = ((~i167) & i168) | ((~i168) & i167);
                objArr2 = objArr8;
                i6 = 1;
            }
            int[] iArr6 = (int[]) objArr2[i6];
            int i169 = artificialFrame;
            int i170 = ((i169 | 39) << i6) - (i169 ^ 39);
            getARTIFICIAL_FRAME_PACKAGE_NAME = i170 % 128;
            int i171 = i170 % 2;
            if (i != iArr6[0]) {
                int i172 = i169 + 119;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i172 % 128;
                if (i172 % 2 == 0) {
                    return objArr2;
                }
                Object obj = null;
                obj.hashCode();
                throw null;
            }
            try {
                Object[] objArr9 = new Object[1];
                a(Color.blue(0), new char[]{48887, 48856, 19675, 63810, 1591, 28058, 6642, 26992, 49442, 14399, 17710, 49451, 4553, 10628, 7551, 59678, 14443, 28764, 62617, 37116, 57392, 22654, 52279, 47123, 35038, 41098, 42050, 24663, 45920, 36654, 32656, 6116, 23325, 55083, 22334, 16135, 963, 16302, 12119, 59059, 10878, 1642, 1774, 36587}, objArr9);
                File file3 = new File((String) objArr9[0]);
                int i173 = getARTIFICIAL_FRAME_PACKAGE_NAME + 83;
                artificialFrame = i173 % 128;
                int i174 = i173 % 2;
                try {
                    if (file3.canRead()) {
                        FileReader fileReader3 = new FileReader(file3);
                        BufferedReader bufferedReader3 = new BufferedReader(fileReader3);
                        int i175 = getARTIFICIAL_FRAME_PACKAGE_NAME + 11;
                        artificialFrame = i175 % 128;
                        try {
                            if (i175 % 2 == 0) {
                                bufferedReader3.readLine();
                                KeyEvent.getModifierMetaStateMask();
                                throw null;
                            }
                            line = bufferedReader3.readLine();
                            int i176 = -((byte) KeyEvent.getModifierMetaStateMask());
                            Object[] objArr10 = new Object[1];
                            a(((-1) ^ i176) + (i176 << 1), new char[]{7714, 7756, 41278, 5307, 57256, 46092, 14627}, objArr10);
                            if (line.equals((String) objArr10[0])) {
                                fileReader3.close();
                                bufferedReader3.close();
                                int i177 = artificialFrame;
                                int i178 = (i177 & 11) + (i177 | 11);
                                getARTIFICIAL_FRAME_PACKAGE_NAME = i178 % 128;
                                int i179 = i178 % 2;
                            } else {
                                fileReader3.close();
                                bufferedReader3.close();
                            }
                            Object[] objArr11 = new Object[1];
                            a(KeyEvent.keyCodeFromString(""), new char[]{60531, 60508, 28936, 50322, 46648, 56734, 63282, 15288, 64693, 55011, 62775, 12284, 17232, 5149, 44407, 1928, 27385, 19844, 17553, 32313, 45820, 26084, 31800, 22223, 55898, 40281, 5185, 36538, 57830, 45756, 53149, 63791, 2439, 60143, 59184}, objArr11);
                            file = new File((String) objArr11[0]);
                            int i180 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                            i7 = (i180 ^ 121) + ((i180 & 121) << 1);
                            artificialFrame = i7 % 128;
                            if (i7 % 2 != 0) {
                                file.canRead();
                                try {
                                    throw null;
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                            if (!file.canRead()) {
                                fileReader = new FileReader(file);
                                bufferedReader = new BufferedReader(fileReader);
                                try {
                                    String line2 = bufferedReader.readLine();
                                    Object[] objArr12 = new Object[1];
                                    a(ViewConfiguration.getMaximumFlingVelocity() >> 16, new char[]{38321, 38272, 21374, 49901, 30586}, objArr12);
                                    zEquals = line2.equals((String) objArr12[0]);
                                    fileReader.close();
                                    i8 = artificialFrame + 57;
                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i8 % 128;
                                    if (i8 % 2 != 0) {
                                        bufferedReader.close();
                                        int i181 = 74 / 0;
                                    } else {
                                        bufferedReader.close();
                                    }
                                    if (zEquals) {
                                        Object[] objArr13 = new Object[1];
                                        a(Process.myPid() >> 22, new char[]{59967, 59920, 35795, 15946, 10416, 17181, 35738, 15800, 1578, 43607, 27561, 21315, 17665, 61068, 13304, 31606, 27811, 46932, 55838, 660, 46328, 40822, 58032, 10875, 56342, 26498, 35525, 62015, 59304, 18470, 20736, 34187, 4038, 4146, 31157, 44399, 22296, 63654, 459, 29895}, objArr13);
                                        file2 = new File((String) objArr13[0]);
                                        if (!file2.canRead()) {
                                            fileReader2 = new FileReader(file2);
                                            bufferedReader2 = new BufferedReader(fileReader2);
                                            try {
                                                String line3 = bufferedReader2.readLine();
                                                Object[] objArr14 = new Object[1];
                                                a((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), new char[]{38321, 38272, 21374, 49901, 30586}, objArr14);
                                                zEquals2 = line3.equals((String) objArr14[0]);
                                                fileReader2.close();
                                                i9 = getARTIFICIAL_FRAME_PACKAGE_NAME + 85;
                                                artificialFrame = i9 % 128;
                                                if (i9 % 2 != 0) {
                                                    bufferedReader2.close();
                                                    throw null;
                                                }
                                                bufferedReader2.close();
                                                if (zEquals2 && line != null) {
                                                    int i182 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                                    int i183 = ((i182 | 45) << 1) - (i182 ^ 45);
                                                    artificialFrame = i183 % 128;
                                                    int i184 = i183 % 2;
                                                    int i185 = ~i;
                                                    Object[] objArr15 = {new int[]{i}, new int[]{(i & (-21)) | (i185 & 20)}, new int[1], line};
                                                    int iFreeMemory = (int) Runtime.getRuntime().freeMemory();
                                                    int i186 = ((((~((-690132204) | iFreeMemory)) | 671126728) * (-566)) - 1415737522) + ((~(iFreeMemory | (-19005476))) * 566);
                                                    int iINotificationSideChannel3 = SqlDateTypeAdapter.AnonymousClass1.INotificationSideChannel();
                                                    int i187 = i186 * (-219);
                                                    int i188 = (3536 & i187) + (i187 | 3536);
                                                    int i189 = ~i186;
                                                    int i190 = ~(((-17) & i189) | ((-17) ^ i189));
                                                    int i191 = ~iINotificationSideChannel3;
                                                    int i192 = (i191 & 16) | (i191 ^ 16);
                                                    int i193 = ~((i192 & i186) | (i192 ^ i186));
                                                    int i194 = i188 + (((i190 & i193) | (i190 ^ i193)) * 220);
                                                    int i195 = ~iINotificationSideChannel3;
                                                    int i196 = -(-(((~((i195 & i186) | (i195 ^ i186))) | 16) * (-440)));
                                                    int i197 = ((i194 | i196) << 1) - (i196 ^ i194);
                                                    int i198 = (i186 ^ 16) | (i186 & 16);
                                                    int i199 = (i197 - (~(-(-(((iINotificationSideChannel3 & i198) | (i198 ^ iINotificationSideChannel3)) * 220))))) - 1;
                                                    int i200 = i199 * (-129);
                                                    int i201 = i2 * 131;
                                                    int i202 = ((i200 | i201) << 1) - (i200 ^ i201);
                                                    int i203 = ~i2;
                                                    int i204 = (i203 & i185) | (i203 ^ i185);
                                                    int i205 = i202 + ((~((i204 & i199) | (i204 ^ i199))) * 130);
                                                    int i206 = ~i2;
                                                    int i207 = -(-((~((i206 ^ i199) | (i206 & i199))) * (-260)));
                                                    int i208 = (i205 ^ i207) + ((i207 & i205) << 1);
                                                    int i209 = ~i199;
                                                    int i210 = ~((i2 & i209) | (i209 ^ i2));
                                                    int i211 = ~((i206 & i199) | (i206 ^ i199) | i);
                                                    int i212 = ((i211 & i210) | (i210 ^ i211)) * 130;
                                                    int i213 = (i208 ^ i212) + ((i212 & i208) << 1);
                                                    int i214 = (i213 << 13) ^ i213;
                                                    int i215 = i214 >>> 17;
                                                    int i216 = ((~i214) & i215) | ((~i215) & i214);
                                                    int i217 = i216 << 5;
                                                    ((int[]) objArr15[2])[0] = ((~i216) & i217) | ((~i217) & i216);
                                                    return objArr15;
                                                }
                                            } catch (Throwable th2) {
                                                fileReader2.close();
                                                bufferedReader2.close();
                                                throw th2;
                                            }
                                        }
                                    }
                                } catch (Throwable th3) {
                                    fileReader.close();
                                    bufferedReader.close();
                                    throw th3;
                                }
                            }
                            int i218 = artificialFrame + 45;
                            getARTIFICIAL_FRAME_PACKAGE_NAME = i218 % 128;
                            int i219 = i218 % 2;
                            Object[] objArr16 = {new int[]{i}, new int[]{i}, new int[1], null};
                            int iUptimeMillis = (int) SystemClock.uptimeMillis();
                            int i220 = ~iUptimeMillis;
                            int i221 = (-120974004) + (((~((-14900901) | i220)) | 963722874) * 519) + (((~(i220 | (-8536197))) | (~(972259070 | iUptimeMillis))) * (-519)) + (((~(iUptimeMillis | 963722874)) | 14900900) * 519);
                            int i222 = ((i221 << 1) - i221) + i2;
                            int i223 = i222 << 13;
                            int i224 = ((~i222) & i223) | ((~i223) & i222);
                            int i225 = i224 ^ (i224 >>> 17);
                            int i226 = i225 << 5;
                            ((int[]) objArr16[2])[0] = (i225 | i226) & (~(i225 & i226));
                            return objArr16;
                        } catch (Throwable th4) {
                            fileReader3.close();
                            bufferedReader3.close();
                            throw th4;
                        }
                    }
                    Object[] objArr17 = new Object[1];
                    a(KeyEvent.keyCodeFromString(""), new char[]{60531, 60508, 28936, 50322, 46648, 56734, 63282, 15288, 64693, 55011, 62775, 12284, 17232, 5149, 44407, 1928, 27385, 19844, 17553, 32313, 45820, 26084, 31800, 22223, 55898, 40281, 5185, 36538, 57830, 45756, 53149, 63791, 2439, 60143, 59184}, objArr17);
                    file = new File((String) objArr17[0]);
                    int i1810 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                    i7 = (i1810 ^ 121) + ((i1810 & 121) << 1);
                    artificialFrame = i7 % 128;
                    if (i7 % 2 != 0) {
                        file.canRead();
                        throw null;
                    }
                    if (!file.canRead()) {
                        fileReader = new FileReader(file);
                        bufferedReader = new BufferedReader(fileReader);
                        String line4 = bufferedReader.readLine();
                        Object[] objArr18 = new Object[1];
                        a(ViewConfiguration.getMaximumFlingVelocity() >> 16, new char[]{38321, 38272, 21374, 49901, 30586}, objArr18);
                        zEquals = line4.equals((String) objArr18[0]);
                        fileReader.close();
                        i8 = artificialFrame + 57;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i8 % 128;
                        if (i8 % 2 != 0) {
                            bufferedReader.close();
                            int i1811 = 74 / 0;
                        } else {
                            bufferedReader.close();
                        }
                        if (zEquals) {
                            Object[] objArr19 = new Object[1];
                            a(Process.myPid() >> 22, new char[]{59967, 59920, 35795, 15946, 10416, 17181, 35738, 15800, 1578, 43607, 27561, 21315, 17665, 61068, 13304, 31606, 27811, 46932, 55838, 660, 46328, 40822, 58032, 10875, 56342, 26498, 35525, 62015, 59304, 18470, 20736, 34187, 4038, 4146, 31157, 44399, 22296, 63654, 459, 29895}, objArr19);
                            file2 = new File((String) objArr19[0]);
                            if (!file2.canRead()) {
                                fileReader2 = new FileReader(file2);
                                bufferedReader2 = new BufferedReader(fileReader2);
                                String line5 = bufferedReader2.readLine();
                                Object[] objArr110 = new Object[1];
                                a((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), new char[]{38321, 38272, 21374, 49901, 30586}, objArr110);
                                zEquals2 = line5.equals((String) objArr110[0]);
                                fileReader2.close();
                                i9 = getARTIFICIAL_FRAME_PACKAGE_NAME + 85;
                                artificialFrame = i9 % 128;
                                if (i9 % 2 != 0) {
                                    bufferedReader2.close();
                                    throw null;
                                }
                                bufferedReader2.close();
                                if (zEquals2) {
                                    int i1812 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                    int i1813 = ((i1812 | 45) << 1) - (i1812 ^ 45);
                                    artificialFrame = i1813 % 128;
                                    int i1814 = i1813 % 2;
                                    int i1815 = ~i;
                                    Object[] objArr111 = {new int[]{i}, new int[]{(i & (-21)) | (i1815 & 20)}, new int[1], line};
                                    int iFreeMemory2 = (int) Runtime.getRuntime().freeMemory();
                                    int i1816 = ((((~((-690132204) | iFreeMemory2)) | 671126728) * (-566)) - 1415737522) + ((~(iFreeMemory2 | (-19005476))) * 566);
                                    int iINotificationSideChannel4 = SqlDateTypeAdapter.AnonymousClass1.INotificationSideChannel();
                                    int i1817 = i1816 * (-219);
                                    int i1818 = (3536 & i1817) + (i1817 | 3536);
                                    int i1819 = ~i1816;
                                    int i1910 = ~(((-17) & i1819) | ((-17) ^ i1819));
                                    int i1911 = ~iINotificationSideChannel4;
                                    int i1912 = (i1911 & 16) | (i1911 ^ 16);
                                    int i1913 = ~((i1912 & i1816) | (i1912 ^ i1816));
                                    int i1914 = i1818 + (((i1910 & i1913) | (i1910 ^ i1913)) * 220);
                                    int i1915 = ~iINotificationSideChannel4;
                                    int i1916 = -(-(((~((i1915 & i1816) | (i1915 ^ i1816))) | 16) * (-440)));
                                    int i1917 = ((i1914 | i1916) << 1) - (i1916 ^ i1914);
                                    int i1918 = (i1816 ^ 16) | (i1816 & 16);
                                    int i1919 = (i1917 - (~(-(-(((iINotificationSideChannel4 & i1918) | (i1918 ^ iINotificationSideChannel4)) * 220))))) - 1;
                                    int i2010 = i1919 * (-129);
                                    int i2011 = i2 * 131;
                                    int i2012 = ((i2010 | i2011) << 1) - (i2010 ^ i2011);
                                    int i2013 = ~i2;
                                    int i2014 = (i2013 & i1815) | (i2013 ^ i1815);
                                    int i2015 = i2012 + ((~((i2014 & i1919) | (i2014 ^ i1919))) * 130);
                                    int i2016 = ~i2;
                                    int i2017 = -(-((~((i2016 ^ i1919) | (i2016 & i1919))) * (-260)));
                                    int i2018 = (i2015 ^ i2017) + ((i2017 & i2015) << 1);
                                    int i2019 = ~i1919;
                                    int i2110 = ~((i2 & i2019) | (i2019 ^ i2));
                                    int i2111 = ~((i2016 & i1919) | (i2016 ^ i1919) | i);
                                    int i2112 = ((i2111 & i2110) | (i2110 ^ i2111)) * 130;
                                    int i2113 = (i2018 ^ i2112) + ((i2112 & i2018) << 1);
                                    int i2114 = (i2113 << 13) ^ i2113;
                                    int i2115 = i2114 >>> 17;
                                    int i2116 = ((~i2114) & i2115) | ((~i2115) & i2114);
                                    int i2117 = i2116 << 5;
                                    ((int[]) objArr111[2])[0] = ((~i2116) & i2117) | ((~i2117) & i2116);
                                    return objArr111;
                                }
                            }
                        }
                    }
                } catch (Exception unused2) {
                }
            } catch (Exception unused3) {
            }
            line = null;
            int i2118 = artificialFrame + 45;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i2118 % 128;
            int i2119 = i2118 % 2;
            Object[] objArr112 = {new int[]{i}, new int[]{i}, new int[1], null};
            int iUptimeMillis2 = (int) SystemClock.uptimeMillis();
            int i227 = ~iUptimeMillis2;
            int i228 = (-120974004) + (((~((-14900901) | i227)) | 963722874) * 519) + (((~(i227 | (-8536197))) | (~(972259070 | iUptimeMillis2))) * (-519)) + (((~(iUptimeMillis2 | 963722874)) | 14900900) * 519);
            int i229 = ((i228 << 1) - i228) + i2;
            int i2210 = i229 << 13;
            int i2211 = ((~i229) & i2210) | ((~i2210) & i229);
            int i2212 = i2211 ^ (i2211 >>> 17);
            int i2213 = i2212 << 5;
            ((int[]) objArr112[2])[0] = (i2212 | i2213) & (~(i2212 & i2213));
            return objArr112;
        } catch (Throwable th5) {
            Throwable cause = th5.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th5;
        }
    }
}
