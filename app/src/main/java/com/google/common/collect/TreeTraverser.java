package com.google.common.collect;

import android.graphics.Color;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.common.base.Ascii;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.lang.reflect.Method;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Queue;
import javax.annotation.CheckForNull;
import o.ArtificialStackFrames;
import o.ICustomTabsCallbackDefault;
import o.artificialFrame;

/* JADX INFO: loaded from: classes5.dex */
@ElementTypesAreNonnullByDefault
@Deprecated
public abstract class TreeTraverser<T> {
    public abstract Iterable<T> children(T t);

    @Deprecated
    public static <T> TreeTraverser<T> using(final Function<T, ? extends Iterable<T>> function) {
        Preconditions.checkNotNull(function);
        return new TreeTraverser<T>() { // from class: com.google.common.collect.TreeTraverser.1
            @Override // com.google.common.collect.TreeTraverser
            public Iterable<T> children(T t) {
                return (Iterable) function.apply(t);
            }
        };
    }

    @Deprecated
    public final FluentIterable<T> preOrderTraversal(final T t) {
        Preconditions.checkNotNull(t);
        return new FluentIterable<T>() { // from class: com.google.common.collect.TreeTraverser.2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Iterable
            public UnmodifiableIterator<T> iterator() {
                return TreeTraverser.this.preOrderIterator(t);
            }
        };
    }

    public final class BreadthFirstIterator extends UnmodifiableIterator<T> implements PeekingIterator<T> {
        private final Queue<T> queue;
        private static final byte[] $$a = {4, -122, -75, -94};
        private static final int $$b = FacebookRequestErrorClassification.EC_INVALID_TOKEN;
        private static int $10 = 0;
        private static int $11 = 1;
        private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
        private static int artificialFrame = 1;
        private static int[] ICustomTabsCallbackStub = {680828348, -1329043613, -547381513, 779194275, 602669400, 110641360, -1341485710, 773475169, 1804355451, 921082549, -128241882, -813006420, 1142981124, -1339135976, 872342937, -496945902, 587567400, -569632190};
        private static long coroutineBoundary = -899883803867009716L;
        private static int accessartificialFrame = -1151259316;
        private static char CoroutineDebuggingKt = 27619;

        /* JADX WARN: Code duplicated, block: B:10:0x0023  */
        /* JADX WARN: Code duplicated, block: B:8:0x001d  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x002a). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0023
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        private static java.lang.String $$c(int r6, short r7, short r8) {
            /*
                int r8 = r8 + 98
                byte[] r0 = com.google.common.collect.TreeTraverser.BreadthFirstIterator.$$a
                int r6 = r6 * 2
                int r6 = 4 - r6
                int r7 = r7 * 3
                int r1 = 1 - r7
                byte[] r1 = new byte[r1]
                r2 = 0
                int r7 = 0 - r7
                if (r0 != 0) goto L17
                r4 = r8
                r3 = r2
                r8 = r6
                goto L2a
            L17:
                r3 = r2
            L18:
                byte r4 = (byte) r8
                r1[r3] = r4
                if (r3 != r7) goto L23
                java.lang.String r6 = new java.lang.String
                r6.<init>(r1, r2)
                return r6
            L23:
                r4 = r0[r6]
                int r3 = r3 + 1
                r5 = r8
                r8 = r6
                r6 = r5
            L2a:
                int r6 = r6 + r4
                int r8 = r8 + 1
                r5 = r8
                r8 = r6
                r6 = r5
                goto L18
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.TreeTraverser.BreadthFirstIterator.$$c(int, short, short):java.lang.String");
        }

        private static void b(char[] cArr, char c, int i, char[] cArr2, char[] cArr3, Object[] objArr) throws Throwable {
            int i2 = 2 % 2;
            ICustomTabsCallbackDefault iCustomTabsCallbackDefault = new ICustomTabsCallbackDefault();
            int length = cArr2.length;
            char[] cArr4 = new char[length];
            int length2 = cArr3.length;
            char[] cArr5 = new char[length2];
            System.arraycopy(cArr2, 0, cArr4, 0, length);
            System.arraycopy(cArr3, 0, cArr5, 0, length2);
            cArr4[0] = (char) (cArr4[0] ^ c);
            cArr5[2] = (char) (cArr5[2] + ((char) i));
            int length3 = cArr.length;
            char[] cArr6 = new char[length3];
            iCustomTabsCallbackDefault.a = 0;
            while (iCustomTabsCallbackDefault.a < length3) {
                int i3 = $11 + 73;
                $10 = i3 % 128;
                int i4 = i3 % 2;
                try {
                    Object[] objArr2 = {iCustomTabsCallbackDefault};
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-10548171);
                    if (objAccessartificialFrame == null) {
                        byte b = (byte) 0;
                        byte b2 = b;
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(33 - (ViewConfiguration.getTouchSlop() >> 8), (char) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) - 1), (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 1483, 1614432829, false, $$c(b, b2, (byte) (b2 + 1)), new Class[]{Object.class});
                    }
                    int iIntValue = ((Integer) ((Method) objAccessartificialFrame).invoke(null, objArr2)).intValue();
                    Object[] objArr3 = {iCustomTabsCallbackDefault};
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1818210492);
                    if (objAccessartificialFrame2 == null) {
                        byte b3 = (byte) 0;
                        byte b4 = b3;
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(32 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (char) ((ViewConfiguration.getJumpTapTimeout() >> 16) + 49168), Process.getGidForName("") + 900, 214239564, false, $$c(b3, b4, (byte) (b4 + 3)), new Class[]{Object.class});
                    }
                    int iIntValue2 = ((Integer) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).intValue();
                    Object[] objArr4 = {iCustomTabsCallbackDefault, Integer.valueOf(cArr4[iCustomTabsCallbackDefault.a % 4] * 32718), Integer.valueOf(cArr5[iIntValue])};
                    Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(1532285801);
                    if (objAccessartificialFrame3 == null) {
                        byte b5 = (byte) 0;
                        byte b6 = b5;
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(23 - Color.green(0), (char) (ViewConfiguration.getPressedStateDuration() >> 16), KeyEvent.getDeadChar(0, 0) + 2441, -1003383455, false, $$c(b5, b6, b6), new Class[]{Object.class, Integer.TYPE, Integer.TYPE});
                    }
                    ((Method) objAccessartificialFrame3).invoke(null, objArr4);
                    Object[] objArr5 = {Integer.valueOf(cArr4[iIntValue2] * 32718), Integer.valueOf(cArr5[iIntValue])};
                    Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-950633141);
                    if (objAccessartificialFrame4 == null) {
                        byte b7 = (byte) 0;
                        byte b8 = b7;
                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(20 - View.MeasureSpec.getMode(0), (char) (29754 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1))), 1748 - View.MeasureSpec.makeMeasureSpec(0, 0), 1479752515, false, $$c(b7, b8, (byte) (b8 + 2)), new Class[]{Integer.TYPE, Integer.TYPE});
                    }
                    cArr5[iIntValue2] = ((Character) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).charValue();
                    cArr4[iIntValue2] = iCustomTabsCallbackDefault.MediaBrowserCompatApi21ConnectionCallback;
                    cArr6[iCustomTabsCallbackDefault.a] = (char) (((((long) (cArr4[iIntValue2] ^ cArr[iCustomTabsCallbackDefault.a])) ^ (coroutineBoundary ^ (-899883803867009716L))) ^ ((long) ((int) (((long) accessartificialFrame) ^ (-899883803867009716L))))) ^ ((long) ((char) (((long) CoroutineDebuggingKt) ^ (-899883803867009716L)))));
                    iCustomTabsCallbackDefault.a++;
                    int i5 = $11 + 3;
                    $10 = i5 % 128;
                    int i6 = i5 % 2;
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
            String str = new String(cArr6);
            int i7 = $10 + 123;
            $11 = i7 % 128;
            if (i7 % 2 != 0) {
                objArr[0] = str;
            } else {
                Object obj = null;
                obj.hashCode();
                throw null;
            }
        }

        private static void a(int i, int[] iArr, Object[] objArr) throws Throwable {
            int length;
            int[] iArr2;
            int i2;
            int i3 = 2;
            int i4 = 2 % 2;
            artificialFrame artificialframe = new artificialFrame();
            char[] cArr = new char[4];
            char[] cArr2 = new char[iArr.length * 2];
            int[] iArr3 = ICustomTabsCallbackStub;
            char c = '0';
            int i5 = -1780896814;
            int i6 = 1;
            int i7 = 0;
            if (iArr3 != null) {
                int i8 = $10 + 47;
                $11 = i8 % 128;
                if (i8 % 2 == 0) {
                    length = iArr3.length;
                    iArr2 = new int[length];
                    i2 = 1;
                } else {
                    length = iArr3.length;
                    iArr2 = new int[length];
                    i2 = 0;
                }
                while (i2 < length) {
                    int i9 = $10 + 125;
                    $11 = i9 % 128;
                    if (i9 % i3 == 0) {
                        try {
                            Object[] objArr2 = {Integer.valueOf(iArr3[i2])};
                            Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(i5);
                            if (objAccessartificialFrame == null) {
                                byte b = (byte) 0;
                                byte b2 = b;
                                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(11 - View.MeasureSpec.makeMeasureSpec(0, 0), (char) (TextUtils.indexOf("", c) + 1), Color.argb(0, 0, 0, 0) + 1562, 180153818, false, $$c(b, b2, (byte) (b2 | Ascii.VT)), new Class[]{Integer.TYPE});
                            }
                            iArr2[i2] = ((Integer) ((Method) objAccessartificialFrame).invoke(null, objArr2)).intValue();
                        } catch (Throwable th) {
                            Throwable cause = th.getCause();
                            if (cause == null) {
                                throw th;
                            }
                            throw cause;
                        }
                    } else {
                        Object[] objArr3 = {Integer.valueOf(iArr3[i2])};
                        Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1780896814);
                        if (objAccessartificialFrame2 == null) {
                            byte b3 = (byte) 0;
                            byte b4 = b3;
                            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(TextUtils.lastIndexOf("", '0', 0) + 12, (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) - 1), (ViewConfiguration.getJumpTapTimeout() >> 16) + 1562, 180153818, false, $$c(b3, b4, (byte) (b4 | Ascii.VT)), new Class[]{Integer.TYPE});
                        }
                        iArr2[i2] = ((Integer) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).intValue();
                        i2++;
                    }
                    i3 = 2;
                    c = '0';
                    i5 = -1780896814;
                }
                int i10 = $10 + 121;
                $11 = i10 % 128;
                if (i10 % 2 == 0) {
                    int i11 = 2 / 3;
                }
                iArr3 = iArr2;
            }
            int length2 = iArr3.length;
            int[] iArr4 = new int[length2];
            int[] iArr5 = ICustomTabsCallbackStub;
            float f = 0.0f;
            if (iArr5 != null) {
                int length3 = iArr5.length;
                int[] iArr6 = new int[length3];
                int i12 = 0;
                while (i12 < length3) {
                    try {
                        Object[] objArr4 = new Object[i6];
                        objArr4[i7] = Integer.valueOf(iArr5[i12]);
                        Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1780896814);
                        if (objAccessartificialFrame3 == null) {
                            int minimumFlingVelocity = (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 11;
                            char c2 = (char) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) - 1);
                            int i13 = (TypedValue.complexToFraction(i7, f, f) > f ? 1 : (TypedValue.complexToFraction(i7, f, f) == f ? 0 : -1)) + 1562;
                            byte b5 = (byte) i7;
                            byte b6 = b5;
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(minimumFlingVelocity, c2, i13, 180153818, false, $$c(b5, b6, (byte) (b6 | Ascii.VT)), new Class[]{Integer.TYPE});
                        }
                        iArr6[i12] = ((Integer) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).intValue();
                        i12++;
                        f = 0.0f;
                        i6 = 1;
                        i7 = 0;
                    } catch (Throwable th2) {
                        Throwable cause2 = th2.getCause();
                        if (cause2 == null) {
                            throw th2;
                        }
                        throw cause2;
                    }
                }
                iArr5 = iArr6;
            }
            int i14 = i7;
            System.arraycopy(iArr5, i14, iArr4, i14, length2);
            artificialframe.e = i14;
            while (artificialframe.e < iArr.length) {
                int i15 = $10 + 5;
                $11 = i15 % 128;
                int i16 = i15 % 2;
                cArr[0] = (char) (iArr[artificialframe.e] >> 16);
                cArr[1] = (char) iArr[artificialframe.e];
                cArr[2] = (char) (iArr[artificialframe.e + 1] >> 16);
                cArr[3] = (char) iArr[artificialframe.e + 1];
                artificialframe.c = (cArr[0] << 16) + cArr[1];
                artificialframe.b = (cArr[2] << 16) + cArr[3];
                artificialFrame.coroutineBoundary(iArr4);
                int i17 = 0;
                for (int i18 = 16; i17 < i18; i18 = 16) {
                    artificialframe.c ^= iArr4[i17];
                    Object[] objArr5 = {artificialframe, Integer.valueOf(artificialFrame.coroutineBoundary(artificialframe.c)), artificialframe, artificialframe};
                    Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1540318455);
                    if (objAccessartificialFrame4 == null) {
                        byte b7 = (byte) 0;
                        byte b8 = b7;
                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(27 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), (char) View.resolveSizeAndState(0, 0, 0), 1089 - AndroidCharacter.getMirror('0'), 995482881, false, $$c(b7, b8, (byte) (b8 | 17)), new Class[]{Object.class, Integer.TYPE, Object.class, Object.class});
                    }
                    int iIntValue = ((Integer) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).intValue();
                    artificialframe.c = artificialframe.b;
                    artificialframe.b = iIntValue;
                    i17++;
                }
                int i19 = artificialframe.c;
                artificialframe.c = artificialframe.b;
                artificialframe.b = i19;
                artificialframe.b ^= iArr4[16];
                artificialframe.c ^= iArr4[17];
                int i20 = artificialframe.c;
                int i21 = artificialframe.b;
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
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(38 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), (char) (28011 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))), 306 - Color.red(0), -818175402, false, "q", new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame5).invoke(null, objArr6);
            }
            objArr[0] = new String(cArr2, 0, i);
        }

        BreadthFirstIterator(T t) {
            ArrayDeque arrayDeque = new ArrayDeque();
            this.queue = arrayDeque;
            arrayDeque.add(t);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.queue.isEmpty();
        }

        @Override // com.google.common.collect.PeekingIterator
        public T peek() {
            return this.queue.element();
        }

        @Override // java.util.Iterator, com.google.common.collect.PeekingIterator
        public T next() {
            T tRemove = this.queue.remove();
            Iterables.addAll(this.queue, TreeTraverser.this.children(tRemove));
            return tRemove;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r8v0 */
        /* JADX WARN: Type inference failed for: r8v1 */
        /* JADX WARN: Type inference failed for: r8v105 */
        /* JADX WARN: Type inference failed for: r8v106 */
        /* JADX WARN: Type inference failed for: r8v113, types: [java.lang.Object, java.lang.String] */
        /* JADX WARN: Type inference failed for: r8v116, types: [int] */
        /* JADX WARN: Type inference failed for: r8v132 */
        /* JADX WARN: Type inference failed for: r8v138 */
        /* JADX WARN: Type inference failed for: r8v150, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r8v155, types: [int] */
        /* JADX WARN: Type inference failed for: r8v171, types: [java.lang.Class] */
        /* JADX WARN: Type inference failed for: r8v180 */
        /* JADX WARN: Type inference failed for: r8v189 */
        /* JADX WARN: Type inference failed for: r8v190 */
        /* JADX WARN: Type inference failed for: r8v191 */
        /* JADX WARN: Type inference failed for: r8v192 */
        /* JADX WARN: Type inference failed for: r8v193 */
        /* JADX WARN: Type inference failed for: r8v2 */
        /* JADX WARN: Type inference failed for: r8v4 */
        /* JADX WARN: Type inference failed for: r8v45, types: [char[]] */
        /* JADX WARN: Type inference failed for: r8v94 */
        /* JADX WARN: Type inference failed for: r8v95 */
        /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
            java.util.NoSuchElementException
            	at java.base/java.util.TreeMap.key(Unknown Source)
            	at java.base/java.util.TreeMap.lastKey(Unknown Source)
            	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
            	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
            	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
            */
        public static java.lang.Object[] accessartificialFrame(android.content.Context r29, int r30, int r31) {
            /*
                Method dump skipped, instruction units count: 4358
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.TreeTraverser.BreadthFirstIterator.accessartificialFrame(android.content.Context, int, int):java.lang.Object[]");
        }
    }

    UnmodifiableIterator<T> preOrderIterator(T t) {
        return new PreOrderIterator(t);
    }

    final class PreOrderIterator extends UnmodifiableIterator<T> {
        private final Deque<Iterator<T>> stack;

        PreOrderIterator(T t) {
            ArrayDeque arrayDeque = new ArrayDeque();
            this.stack = arrayDeque;
            arrayDeque.addLast(Iterators.singletonIterator(Preconditions.checkNotNull(t)));
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.stack.isEmpty();
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // java.util.Iterator
        public T next() {
            Iterator<T> last = this.stack.getLast();
            T t = (T) Preconditions.checkNotNull(last.next());
            if (!last.hasNext()) {
                this.stack.removeLast();
            }
            Iterator<T> it2 = TreeTraverser.this.children(t).iterator();
            if (it2.hasNext()) {
                this.stack.addLast(it2);
            }
            return t;
        }
    }

    @Deprecated
    public final FluentIterable<T> postOrderTraversal(final T t) {
        Preconditions.checkNotNull(t);
        return new FluentIterable<T>() { // from class: com.google.common.collect.TreeTraverser.3
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Iterable
            public UnmodifiableIterator<T> iterator() {
                return TreeTraverser.this.postOrderIterator(t);
            }
        };
    }

    UnmodifiableIterator<T> postOrderIterator(T t) {
        return new PostOrderIterator(t);
    }

    static final class PostOrderNode<T> {
        final Iterator<T> childIterator;
        final T root;

        PostOrderNode(T t, Iterator<T> it2) {
            this.root = (T) Preconditions.checkNotNull(t);
            this.childIterator = (Iterator) Preconditions.checkNotNull(it2);
        }
    }

    final class PostOrderIterator extends AbstractIterator<T> {
        private final ArrayDeque<PostOrderNode<T>> stack;

        PostOrderIterator(T t) {
            ArrayDeque<PostOrderNode<T>> arrayDeque = new ArrayDeque<>();
            this.stack = arrayDeque;
            arrayDeque.addLast(expand(t));
        }

        @Override // com.google.common.collect.AbstractIterator
        @CheckForNull
        protected T computeNext() {
            while (!this.stack.isEmpty()) {
                PostOrderNode<T> last = this.stack.getLast();
                if (last.childIterator.hasNext()) {
                    this.stack.addLast(expand(last.childIterator.next()));
                } else {
                    this.stack.removeLast();
                    return last.root;
                }
            }
            return endOfData();
        }

        private PostOrderNode<T> expand(T t) {
            return new PostOrderNode<>(t, TreeTraverser.this.children(t).iterator());
        }
    }

    @Deprecated
    public final FluentIterable<T> breadthFirstTraversal(final T t) {
        Preconditions.checkNotNull(t);
        return new FluentIterable<T>() { // from class: com.google.common.collect.TreeTraverser.4
            @Override // java.lang.Iterable
            public UnmodifiableIterator<T> iterator() {
                return new BreadthFirstIterator(t);
            }
        };
    }
}
