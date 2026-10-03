package kotlinx.coroutines.channels;

import android.graphics.Color;
import android.os.SystemClock;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import ch.qos.logback.core.CoreConstants;
import com.facebook.internal.AnalyticsEvents;
import com.google.common.base.Ascii;
import java.lang.reflect.Method;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o.ArtificialStackFrames;
import o.onNavigationEvent;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
@JvmInline
public final class ChannelResult<T> {
    public static final Companion Companion = new Companion(null);
    private static final Failed failed = new Failed();
    private final Object holder;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ ChannelResult m7003boximpl(Object obj) {
        return new ChannelResult(obj);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static <T> Object m7004constructorimpl(@Nullable Object obj) {
        return obj;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m7005equalsimpl(Object obj, Object obj2) {
        return (obj2 instanceof ChannelResult) && Intrinsics.areEqual(obj, ((ChannelResult) obj2).m7015unboximpl());
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m7006equalsimpl0(Object obj, Object obj2) {
        return Intrinsics.areEqual(obj, obj2);
    }

    public static /* synthetic */ void getHolder$annotations() {
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m7010hashCodeimpl(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public boolean equals(Object obj) {
        return m7005equalsimpl(this.holder, obj);
    }

    public int hashCode() {
        return m7010hashCodeimpl(this.holder);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ Object m7015unboximpl() {
        return this.holder;
    }

    public static final class Closed extends Failed {
        public final Throwable cause;
        private static final byte[] $$c = {Ascii.SYN, 117, 37, -99};
        private static final int $$d = 85;
        private static int $10 = 0;
        private static int $11 = 1;
        private static final byte[] $$a = {Ascii.SYN, -120, 37, 108, -9, Ascii.DC4, -28, Ascii.SUB, Ascii.DC2, -10, 5, Ascii.VT, -2, -19, 39, -6, 6, -27, 46, -8, 6, Ascii.SI, -2, 4, -13, Ascii.CAN, Ascii.CR, 7, Ascii.FF, -12, 4, Ascii.US, 17, 4, -38, 49, 3, 8, -10, Ascii.CAN, -31, Ascii.SYN, Ascii.SYN, -10, 7, Ascii.FF, 2, Ascii.SYN, -16, Ascii.DC2, -9, Ascii.DC4, -44, 35, Ascii.DC4, 9, -6, Ascii.VT, 4, 0, 10, -2, -29, 46, -8, 6, Ascii.SI, -2, 4, -50, 50, Ascii.SO};
        private static final int $$b = 142;
        private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
        private static int artificialFrame = 1;
        private static int setDefaultImpl = -260893996;

        /* JADX WARN: Code duplicated, block: B:10:0x0025  */
        /* JADX WARN: Code duplicated, block: B:8:0x001f  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x002a). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0025
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        private static java.lang.String $$e(byte r7, int r8, byte r9) {
            /*
                int r8 = r8 + 4
                int r7 = r7 * 3
                int r7 = r7 + 1
                int r9 = r9 * 2
                int r9 = 116 - r9
                byte[] r0 = kotlinx.coroutines.channels.ChannelResult.Closed.$$c
                byte[] r1 = new byte[r7]
                r2 = 0
                if (r0 != 0) goto L15
                r3 = r9
                r4 = r2
                r9 = r8
                goto L2a
            L15:
                r3 = r2
            L16:
                int r8 = r8 + 1
                int r4 = r3 + 1
                byte r5 = (byte) r9
                r1[r3] = r5
                if (r4 != r7) goto L25
                java.lang.String r7 = new java.lang.String
                r7.<init>(r1, r2)
                return r7
            L25:
                r3 = r0[r8]
                r6 = r9
                r9 = r8
                r8 = r6
            L2a:
                int r8 = r8 + r3
                r3 = r4
                r6 = r9
                r9 = r8
                r8 = r6
                goto L16
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelResult.Closed.$$e(byte, int, byte):java.lang.String");
        }

        /* JADX WARN: Code duplicated, block: B:10:0x0023  */
        /* JADX WARN: Code duplicated, block: B:8:0x001b  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x002a). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0023
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        private static void a(byte r6, int r7, int r8, java.lang.Object[] r9) {
            /*
                int r0 = r7 + 2
                int r6 = r6 + 66
                byte[] r1 = kotlinx.coroutines.channels.ChannelResult.Closed.$$a
                int r8 = 69 - r8
                byte[] r0 = new byte[r0]
                int r7 = r7 + 1
                r2 = 0
                if (r1 != 0) goto L13
                r4 = r7
                r6 = r8
                r3 = r2
                goto L2a
            L13:
                r3 = r2
            L14:
                byte r4 = (byte) r6
                int r8 = r8 + 1
                r0[r3] = r4
                if (r3 != r7) goto L23
                java.lang.String r6 = new java.lang.String
                r6.<init>(r0, r2)
                r9[r2] = r6
                return
            L23:
                int r3 = r3 + 1
                r4 = r1[r8]
                r5 = r8
                r8 = r6
                r6 = r5
            L2a:
                int r8 = r8 + r4
                int r8 = r8 + (-5)
                r5 = r8
                r8 = r6
                r6 = r5
                goto L14
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelResult.Closed.a(byte, int, int, java.lang.Object[]):void");
        }

        private static void b(boolean z, int i, int i2, int i3, char[] cArr, Object[] objArr) throws Throwable {
            int i4 = 2 % 2;
            onNavigationEvent onnavigationevent = new onNavigationEvent();
            char[] cArr2 = new char[i3];
            onnavigationevent.d = 0;
            while (onnavigationevent.d < i3) {
                onnavigationevent.c = cArr[onnavigationevent.d];
                cArr2[onnavigationevent.d] = (char) (i2 + onnavigationevent.c);
                int i5 = onnavigationevent.d;
                try {
                    Object[] objArr2 = {Integer.valueOf(cArr2[i5]), Integer.valueOf(setDefaultImpl)};
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(465886069);
                    if (objAccessartificialFrame == null) {
                        byte b = (byte) 0;
                        byte b2 = (byte) (b - 1);
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(Color.green(0) + 22, (char) ((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 1), 1775 - Gravity.getAbsoluteGravity(0, 0), -2069783171, false, $$e(b, b2, (byte) (-b2)), new Class[]{Integer.TYPE, Integer.TYPE});
                    }
                    cArr2[i5] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                    try {
                        Object[] objArr3 = {onnavigationevent, onnavigationevent};
                        Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1257606387);
                        if (objAccessartificialFrame2 == null) {
                            byte b3 = (byte) 0;
                            byte b4 = (byte) (b3 - 1);
                            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 36, (char) (56277 - (ViewConfiguration.getScrollBarFadeDuration() >> 16)), 1260 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), 711931141, false, $$e(b3, b4, (byte) (b4 + 1)), new Class[]{Object.class, Object.class});
                        }
                        ((Method) objAccessartificialFrame2).invoke(null, objArr3);
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause == null) {
                            throw th;
                        }
                        throw cause;
                    }
                } catch (Throwable th2) {
                    Throwable cause2 = th2.getCause();
                    if (cause2 == null) {
                        throw th2;
                    }
                    throw cause2;
                }
            }
            if (i > 0) {
                onnavigationevent.b = i;
                char[] cArr3 = new char[i3];
                System.arraycopy(cArr2, 0, cArr3, 0, i3);
                System.arraycopy(cArr3, 0, cArr2, i3 - onnavigationevent.b, onnavigationevent.b);
                System.arraycopy(cArr3, onnavigationevent.b, cArr2, 0, i3 - onnavigationevent.b);
            }
            if (z) {
                char[] cArr4 = new char[i3];
                onnavigationevent.d = 0;
                while (onnavigationevent.d < i3) {
                    int i6 = $11 + 49;
                    $10 = i6 % 128;
                    if (i6 % 2 != 0) {
                        cArr4[onnavigationevent.d] = cArr2[onnavigationevent.d * i3];
                        try {
                            Object[] objArr4 = {onnavigationevent, onnavigationevent};
                            Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1257606387);
                            if (objAccessartificialFrame3 == null) {
                                byte b5 = (byte) 0;
                                byte b6 = (byte) (b5 - 1);
                                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(36 - MotionEvent.axisFromString(""), (char) ((ViewConfiguration.getDoubleTapTimeout() >> 16) + 56277), 1259 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), 711931141, false, $$e(b5, b6, (byte) (b6 + 1)), new Class[]{Object.class, Object.class});
                            }
                            ((Method) objAccessartificialFrame3).invoke(null, objArr4);
                        } catch (Throwable th3) {
                            Throwable cause3 = th3.getCause();
                            if (cause3 == null) {
                                throw th3;
                            }
                            throw cause3;
                        }
                    } else {
                        cArr4[onnavigationevent.d] = cArr2[(i3 - onnavigationevent.d) - 1];
                        Object[] objArr5 = {onnavigationevent, onnavigationevent};
                        Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1257606387);
                        if (objAccessartificialFrame4 == null) {
                            byte b7 = (byte) 0;
                            byte b8 = (byte) (b7 - 1);
                            objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 36, (char) (56278 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1))), 1259 - View.getDefaultSize(0, 0), 711931141, false, $$e(b7, b8, (byte) (b8 + 1)), new Class[]{Object.class, Object.class});
                        }
                        ((Method) objAccessartificialFrame4).invoke(null, objArr5);
                    }
                    int i7 = $11 + 63;
                    $10 = i7 % 128;
                    int i8 = i7 % 2;
                }
                int i9 = $10 + 67;
                $11 = i9 % 128;
                int i10 = i9 % 2;
                cArr2 = cArr4;
            }
            objArr[0] = new String(cArr2);
        }

        public Closed(@Nullable Throwable th) {
            this.cause = th;
        }

        public boolean equals(@Nullable Object obj) {
            return (obj instanceof Closed) && Intrinsics.areEqual(this.cause, ((Closed) obj).cause);
        }

        public int hashCode() {
            Throwable th = this.cause;
            if (th != null) {
                return th.hashCode();
            }
            return 0;
        }

        @Override // kotlinx.coroutines.channels.ChannelResult.Failed
        public String toString() {
            return "Closed(" + this.cause + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        /* JADX WARN: Code duplicated, block: B:29:0x060c  */
        /* JADX WARN: Code duplicated, block: B:31:0x0612  */
        /* JADX WARN: Code duplicated, block: B:33:0x0638  */
        /* JADX WARN: Code duplicated, block: B:34:0x063a  */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x0927, code lost:
        
            if (r0 == 1) goto L61;
         */
        /* JADX WARN: Code restructure failed: missing block: B:92:0x0b09, code lost:
        
            if (r0.equals((java.lang.String) r3[0]) != false) goto L93;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static java.lang.Object[] CoroutineDebuggingKt(android.content.Context r35, int r36, int r37, int r38) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 3457
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelResult.Closed.CoroutineDebuggingKt(android.content.Context, int, int, int):java.lang.Object[]");
        }
    }

    private /* synthetic */ ChannelResult(Object obj) {
        this.holder = obj;
    }

    /* JADX INFO: renamed from: isSuccess-impl, reason: not valid java name */
    public static final boolean m7013isSuccessimpl(Object obj) {
        return !(obj instanceof Failed);
    }

    /* JADX INFO: renamed from: isFailure-impl, reason: not valid java name */
    public static final boolean m7012isFailureimpl(Object obj) {
        return obj instanceof Failed;
    }

    /* JADX INFO: renamed from: isClosed-impl, reason: not valid java name */
    public static final boolean m7011isClosedimpl(Object obj) {
        return obj instanceof Closed;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getOrNull-impl, reason: not valid java name */
    public static final T m7008getOrNullimpl(Object obj) {
        if (obj instanceof Failed) {
            return null;
        }
        return obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getOrThrow-impl, reason: not valid java name */
    public static final T m7009getOrThrowimpl(Object obj) throws Throwable {
        Throwable th;
        if (!(obj instanceof Failed)) {
            return obj;
        }
        if ((obj instanceof Closed) && (th = ((Closed) obj).cause) != null) {
            throw th;
        }
        throw new IllegalStateException(("Trying to call 'getOrThrow' on a failed channel result: " + obj).toString());
    }

    /* JADX INFO: renamed from: exceptionOrNull-impl, reason: not valid java name */
    public static final Throwable m7007exceptionOrNullimpl(Object obj) {
        Closed closed = obj instanceof Closed ? (Closed) obj : null;
        if (closed != null) {
            return closed.cause;
        }
        return null;
    }

    public static class Failed {
        public String toString() {
            return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_FAILED;
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: success-JP2dKIU, reason: not valid java name */
        public final <E> Object m7018successJP2dKIU(E e) {
            return ChannelResult.m7004constructorimpl(e);
        }

        /* JADX INFO: renamed from: failure-PtdJZtk, reason: not valid java name */
        public final <E> Object m7017failurePtdJZtk() {
            return ChannelResult.m7004constructorimpl(ChannelResult.failed);
        }

        /* JADX INFO: renamed from: closed-JP2dKIU, reason: not valid java name */
        public final <E> Object m7016closedJP2dKIU(@Nullable Throwable th) {
            return ChannelResult.m7004constructorimpl(new Closed(th));
        }
    }

    public String toString() {
        return m7014toStringimpl(this.holder);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m7014toStringimpl(Object obj) {
        if (obj instanceof Closed) {
            return ((Closed) obj).toString();
        }
        return "Value(" + obj + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }
}
