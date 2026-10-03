package com.google.common.collect;

import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.google.common.base.Ascii;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.RandomAccess;
import java.util.Set;
import javax.annotation.CheckForNull;
import o.ArtificialStackFrames;
import o._CREATION;
import org.apache.commons.lang3.CharEncoding;

/* JADX INFO: loaded from: classes5.dex */
@ElementTypesAreNonnullByDefault
public final class Iterables {
    private static long _BOUNDARY;
    private static char[] _CREATION;
    private static final byte[] $$c = {52, -20, 7, -120};
    private static final int $$d = 56;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$a = {65, Ascii.SYN, 92, -30, 2, -47, -11, -22, -1, 3, Ascii.FF, -11, 8, 0, -17, 8, -19, 19, 52, -17, 5, 53, -53, Ascii.CR, 1};
    private static final int $$b = 203;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;

    /* JADX WARN: Code duplicated, block: B:10:0x0022  */
    /* JADX WARN: Code duplicated, block: B:8:0x001c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0022 -> B:11:0x0027). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0022
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$e(byte r7, short r8, byte r9) {
        /*
            int r9 = r9 * 2
            int r9 = r9 + 1
            byte[] r0 = com.google.common.collect.Iterables.$$c
            int r8 = 106 - r8
            int r7 = r7 * 2
            int r7 = 4 - r7
            byte[] r1 = new byte[r9]
            r2 = 0
            if (r0 != 0) goto L14
            r3 = r9
            r4 = r2
            goto L27
        L14:
            r3 = r2
        L15:
            int r4 = r3 + 1
            byte r5 = (byte) r8
            r1[r3] = r5
            if (r4 != r9) goto L22
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            return r7
        L22:
            r3 = r0[r7]
            r6 = r3
            r3 = r8
            r8 = r6
        L27:
            int r8 = -r8
            int r8 = r8 + r3
            int r7 = r7 + 1
            r3 = r4
            goto L15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.Iterables.$$e(byte, short, byte):java.lang.String");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0024  */
    /* JADX WARN: Code duplicated, block: B:8:0x001c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0024 -> B:11:0x0029). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0024
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void a(int r7, int r8, short r9, java.lang.Object[] r10) {
        /*
            int r7 = 22 - r7
            byte[] r0 = com.google.common.collect.Iterables.$$a
            int r8 = 4 - r8
            int r9 = r9 + 66
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L11
            r9 = r7
            r3 = r8
            r4 = r2
            goto L29
        L11:
            r3 = r2
        L12:
            r6 = r9
            r9 = r7
            r7 = r6
            int r4 = r3 + 1
            byte r5 = (byte) r7
            r1[r3] = r5
            if (r4 != r8) goto L24
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L24:
            r3 = r0[r9]
            r6 = r9
            r9 = r7
            r7 = r6
        L29:
            int r3 = -r3
            int r7 = r7 + 1
            int r9 = r9 + r3
            int r9 = r9 + (-2)
            r3 = r4
            goto L12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.Iterables.a(int, int, short, java.lang.Object[]):void");
    }

    private Iterables() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> Iterable<T> unmodifiableIterable(Iterable<? extends T> iterable) {
        Preconditions.checkNotNull(iterable);
        return ((iterable instanceof UnmodifiableIterable) || (iterable instanceof ImmutableCollection)) ? iterable : new UnmodifiableIterable(iterable);
    }

    @Deprecated
    public static <E> Iterable<E> unmodifiableIterable(ImmutableCollection<E> immutableCollection) {
        return (Iterable) Preconditions.checkNotNull(immutableCollection);
    }

    static final class UnmodifiableIterable<T> extends FluentIterable<T> {
        private final Iterable<? extends T> iterable;

        private UnmodifiableIterable(Iterable<? extends T> iterable) {
            this.iterable = iterable;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return Iterators.unmodifiableIterator(this.iterable.iterator());
        }

        @Override // com.google.common.collect.FluentIterable
        public String toString() {
            return this.iterable.toString();
        }
    }

    private static void b(char c, int i, int i2, Object[] objArr) throws Throwable {
        int i3 = 2 % 2;
        _CREATION _creation = new _CREATION();
        long[] jArr = new long[i2];
        _creation.b = 0;
        while (_creation.b < i2) {
            int i4 = $11 + 79;
            $10 = i4 % 128;
            if (i4 % 2 != 0) {
                int i5 = _creation.b;
                try {
                    Object[] objArr2 = {Integer.valueOf(_CREATION[i * i5])};
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-587087340);
                    if (objAccessartificialFrame == null) {
                        byte b = (byte) 0;
                        byte b2 = (byte) (b + 2);
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(AndroidCharacter.getMirror('0') - '(', (char) (9278 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))), 1977 - ExpandableListView.getPackedPositionType(0L), 1113883676, false, $$e(b, b2, (byte) (b2 - 2)), new Class[]{Integer.TYPE});
                    }
                    try {
                        Object[] objArr3 = {Long.valueOf(((Long) ((Method) objAccessartificialFrame).invoke(null, objArr2)).longValue()), Long.valueOf(i5), Long.valueOf(_BOUNDARY), Integer.valueOf(c)};
                        Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1715896821);
                        if (objAccessartificialFrame2 == null) {
                            byte b3 = (byte) 0;
                            byte b4 = b3;
                            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(((byte) KeyEvent.getModifierMetaStateMask()) + Ascii.US, (char) (49363 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))), TextUtils.indexOf((CharSequence) "", '0', 0) + 685, -115095555, false, $$e(b3, b4, b4), new Class[]{Long.TYPE, Long.TYPE, Long.TYPE, Integer.TYPE});
                        }
                        jArr[i5] = ((Long) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).longValue();
                        try {
                            Object[] objArr4 = {_creation, _creation};
                            Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-293902099);
                            if (objAccessartificialFrame3 == null) {
                                byte b5 = (byte) 0;
                                byte b6 = (byte) (b5 + 3);
                                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(25 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), (char) (TextUtils.indexOf((CharSequence) "", '0') + 30069), (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 815, 1897803493, false, $$e(b5, b6, (byte) (b6 - 3)), new Class[]{Object.class, Object.class});
                            }
                            ((Method) objAccessartificialFrame3).invoke(null, objArr4);
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
                } catch (Throwable th3) {
                    Throwable cause3 = th3.getCause();
                    if (cause3 == null) {
                        throw th3;
                    }
                    throw cause3;
                }
            } else {
                int i6 = _creation.b;
                try {
                    Object[] objArr5 = {Integer.valueOf(_CREATION[i + i6])};
                    Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-587087340);
                    if (objAccessartificialFrame4 == null) {
                        byte b7 = (byte) 0;
                        byte b8 = (byte) (b7 + 2);
                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(8 - (ViewConfiguration.getDoubleTapTimeout() >> 16), (char) (TextUtils.lastIndexOf("", '0', 0) + 9280), 1977 - (ViewConfiguration.getDoubleTapTimeout() >> 16), 1113883676, false, $$e(b7, b8, (byte) (b8 - 2)), new Class[]{Integer.TYPE});
                    }
                    Object[] objArr6 = {Long.valueOf(((Long) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).longValue()), Long.valueOf(i6), Long.valueOf(_BOUNDARY), Integer.valueOf(c)};
                    Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(1715896821);
                    if (objAccessartificialFrame5 == null) {
                        byte b9 = (byte) 0;
                        byte b10 = b9;
                        objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(29 - TextUtils.lastIndexOf("", '0', 0), (char) (49362 - TextUtils.getOffsetBefore("", 0)), 684 - View.resolveSizeAndState(0, 0, 0), -115095555, false, $$e(b9, b10, b10), new Class[]{Long.TYPE, Long.TYPE, Long.TYPE, Integer.TYPE});
                    }
                    jArr[i6] = ((Long) ((Method) objAccessartificialFrame5).invoke(null, objArr6)).longValue();
                    Object[] objArr7 = {_creation, _creation};
                    Object objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(-293902099);
                    if (objAccessartificialFrame6 == null) {
                        byte b11 = (byte) 0;
                        byte b12 = (byte) (b11 + 3);
                        objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 24, (char) ((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 30069), 816 - View.MeasureSpec.getMode(0), 1897803493, false, $$e(b11, b12, (byte) (b12 - 3)), new Class[]{Object.class, Object.class});
                    }
                    ((Method) objAccessartificialFrame6).invoke(null, objArr7);
                } catch (Throwable th4) {
                    Throwable cause4 = th4.getCause();
                    if (cause4 == null) {
                        throw th4;
                    }
                    throw cause4;
                }
            }
        }
        char[] cArr = new char[i2];
        _creation.b = 0;
        int i7 = $10 + 25;
        $11 = i7 % 128;
        int i8 = i7 % 2;
        while (_creation.b < i2) {
            cArr[_creation.b] = (char) jArr[_creation.b];
            Object[] objArr8 = {_creation, _creation};
            Object objAccessartificialFrame7 = ArtificialStackFrames.accessartificialFrame(-293902099);
            if (objAccessartificialFrame7 == null) {
                byte b13 = (byte) 0;
                byte b14 = (byte) (b13 + 3);
                objAccessartificialFrame7 = ArtificialStackFrames.coroutineCreation(25 - Drawable.resolveOpacity(0, 0), (char) (30068 - (ViewConfiguration.getPressedStateDuration() >> 16)), 816 - (ViewConfiguration.getEdgeSlop() >> 16), 1897803493, false, $$e(b13, b14, (byte) (b14 - 3)), new Class[]{Object.class, Object.class});
            }
            ((Method) objAccessartificialFrame7).invoke(null, objArr8);
        }
        objArr[0] = new String(cArr);
    }

    public static int size(Iterable<?> iterable) {
        if (iterable instanceof Collection) {
            return ((Collection) iterable).size();
        }
        return Iterators.size(iterable.iterator());
    }

    public static boolean contains(Iterable<? extends Object> iterable, @CheckForNull Object obj) {
        if (iterable instanceof Collection) {
            return Collections2.safeContains((Collection) iterable, obj);
        }
        return Iterators.contains(iterable.iterator(), obj);
    }

    public static boolean removeAll(Iterable<?> iterable, Collection<?> collection) {
        if (iterable instanceof Collection) {
            return ((Collection) iterable).removeAll((Collection) Preconditions.checkNotNull(collection));
        }
        return Iterators.removeAll(iterable.iterator(), collection);
    }

    public static boolean retainAll(Iterable<?> iterable, Collection<?> collection) {
        if (iterable instanceof Collection) {
            return ((Collection) iterable).retainAll((Collection) Preconditions.checkNotNull(collection));
        }
        return Iterators.retainAll(iterable.iterator(), collection);
    }

    public static <T> boolean removeIf(Iterable<T> iterable, Predicate<? super T> predicate) {
        if ((iterable instanceof RandomAccess) && (iterable instanceof List)) {
            return removeIfFromRandomAccessList((List) iterable, (Predicate) Preconditions.checkNotNull(predicate));
        }
        return Iterators.removeIf(iterable.iterator(), predicate);
    }

    private static <T> boolean removeIfFromRandomAccessList(List<T> list, Predicate<? super T> predicate) {
        int i = 0;
        int i2 = 0;
        while (i < list.size()) {
            T t = list.get(i);
            if (!predicate.apply(t)) {
                if (i > i2) {
                    try {
                        list.set(i2, t);
                    } catch (IllegalArgumentException unused) {
                        slowRemoveIfForRemainingElements(list, predicate, i2, i);
                        return true;
                    } catch (UnsupportedOperationException unused2) {
                        slowRemoveIfForRemainingElements(list, predicate, i2, i);
                        return true;
                    }
                }
                i2++;
            }
            i++;
        }
        list.subList(i2, list.size()).clear();
        return i != i2;
    }

    private static <T> void slowRemoveIfForRemainingElements(List<T> list, Predicate<? super T> predicate, int i, int i2) {
        for (int size = list.size() - 1; size > i2; size--) {
            if (predicate.apply(list.get(size))) {
                list.remove(size);
            }
        }
        while (true) {
            i2--;
            if (i2 < i) {
                return;
            } else {
                list.remove(i2);
            }
        }
    }

    @CheckForNull
    static <T> T removeFirstMatching(Iterable<T> iterable, Predicate<? super T> predicate) {
        Preconditions.checkNotNull(predicate);
        Iterator<T> it2 = iterable.iterator();
        while (it2.hasNext()) {
            T next = it2.next();
            if (predicate.apply(next)) {
                it2.remove();
                return next;
            }
        }
        return null;
    }

    public static boolean elementsEqual(Iterable<?> iterable, Iterable<?> iterable2) {
        if ((iterable instanceof Collection) && (iterable2 instanceof Collection) && ((Collection) iterable).size() != ((Collection) iterable2).size()) {
            return false;
        }
        return Iterators.elementsEqual(iterable.iterator(), iterable2.iterator());
    }

    public static String toString(Iterable<?> iterable) {
        return Iterators.toString(iterable.iterator());
    }

    @ParametricNullness
    public static <T> T getOnlyElement(Iterable<T> iterable) {
        return (T) Iterators.getOnlyElement(iterable.iterator());
    }

    @ParametricNullness
    public static <T> T getOnlyElement(Iterable<? extends T> iterable, @ParametricNullness T t) {
        return (T) Iterators.getOnlyElement(iterable.iterator(), t);
    }

    public static <T> T[] toArray(Iterable<? extends T> iterable, Class<T> cls) {
        return (T[]) toArray(iterable, ObjectArrays.newArray(cls, 0));
    }

    static <T> T[] toArray(Iterable<? extends T> iterable, T[] tArr) {
        return (T[]) castOrCopyToCollection(iterable).toArray(tArr);
    }

    static Object[] toArray(Iterable<?> iterable) {
        return castOrCopyToCollection(iterable).toArray();
    }

    private static <E> Collection<E> castOrCopyToCollection(Iterable<E> iterable) {
        if (iterable instanceof Collection) {
            return (Collection) iterable;
        }
        return Lists.newArrayList(iterable.iterator());
    }

    public static <T> boolean addAll(Collection<T> collection, Iterable<? extends T> iterable) {
        if (iterable instanceof Collection) {
            return collection.addAll((Collection) iterable);
        }
        return Iterators.addAll(collection, ((Iterable) Preconditions.checkNotNull(iterable)).iterator());
    }

    public static int frequency(Iterable<?> iterable, @CheckForNull Object obj) {
        if (iterable instanceof Multiset) {
            return ((Multiset) iterable).count(obj);
        }
        if (iterable instanceof Set) {
            return ((Set) iterable).contains(obj) ? 1 : 0;
        }
        return Iterators.frequency(iterable.iterator(), obj);
    }

    public static <T> Iterable<T> cycle(final Iterable<T> iterable) {
        Preconditions.checkNotNull(iterable);
        return new FluentIterable<T>() { // from class: com.google.common.collect.Iterables.1
            @Override // java.lang.Iterable
            public Iterator<T> iterator() {
                return Iterators.cycle(iterable);
            }

            @Override // com.google.common.collect.FluentIterable
            public String toString() {
                return String.valueOf(iterable.toString()).concat(" (cycled)");
            }
        };
    }

    @SafeVarargs
    public static <T> Iterable<T> cycle(T... tArr) {
        return cycle(Lists.newArrayList(tArr));
    }

    public static <T> Iterable<T> concat(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        return FluentIterable.concat(iterable, iterable2);
    }

    public static <T> Iterable<T> concat(Iterable<? extends T> iterable, Iterable<? extends T> iterable2, Iterable<? extends T> iterable3) {
        return FluentIterable.concat(iterable, iterable2, iterable3);
    }

    public static <T> Iterable<T> concat(Iterable<? extends T> iterable, Iterable<? extends T> iterable2, Iterable<? extends T> iterable3, Iterable<? extends T> iterable4) {
        return FluentIterable.concat(iterable, iterable2, iterable3, iterable4);
    }

    @SafeVarargs
    public static <T> Iterable<T> concat(Iterable<? extends T>... iterableArr) {
        return FluentIterable.concat(iterableArr);
    }

    public static <T> Iterable<T> concat(Iterable<? extends Iterable<? extends T>> iterable) {
        return FluentIterable.concat(iterable);
    }

    public static <T> Iterable<List<T>> partition(final Iterable<T> iterable, final int i) {
        Preconditions.checkNotNull(iterable);
        Preconditions.checkArgument(i > 0);
        return new FluentIterable<List<T>>() { // from class: com.google.common.collect.Iterables.2
            @Override // java.lang.Iterable
            public Iterator<List<T>> iterator() {
                return Iterators.partition(iterable.iterator(), i);
            }
        };
    }

    public static <T> Iterable<List<T>> paddedPartition(final Iterable<T> iterable, final int i) {
        Preconditions.checkNotNull(iterable);
        Preconditions.checkArgument(i > 0);
        return new FluentIterable<List<T>>() { // from class: com.google.common.collect.Iterables.3
            @Override // java.lang.Iterable
            public Iterator<List<T>> iterator() {
                return Iterators.paddedPartition(iterable.iterator(), i);
            }
        };
    }

    public static <T> Iterable<T> filter(final Iterable<T> iterable, final Predicate<? super T> predicate) {
        Preconditions.checkNotNull(iterable);
        Preconditions.checkNotNull(predicate);
        return new FluentIterable<T>() { // from class: com.google.common.collect.Iterables.4
            @Override // java.lang.Iterable
            public Iterator<T> iterator() {
                return Iterators.filter(iterable.iterator(), predicate);
            }
        };
    }

    public static <T> Iterable<T> filter(Iterable<?> iterable, Class<T> cls) {
        Preconditions.checkNotNull(iterable);
        Preconditions.checkNotNull(cls);
        return filter(iterable, Predicates.instanceOf(cls));
    }

    public static <T> boolean any(Iterable<T> iterable, Predicate<? super T> predicate) {
        return Iterators.any(iterable.iterator(), predicate);
    }

    public static <T> boolean all(Iterable<T> iterable, Predicate<? super T> predicate) {
        return Iterators.all(iterable.iterator(), predicate);
    }

    @ParametricNullness
    public static <T> T find(Iterable<T> iterable, Predicate<? super T> predicate) {
        return (T) Iterators.find(iterable.iterator(), predicate);
    }

    @CheckForNull
    public static <T> T find(Iterable<? extends T> iterable, Predicate<? super T> predicate, @CheckForNull T t) {
        return (T) Iterators.find(iterable.iterator(), predicate, t);
    }

    public static <T> Optional<T> tryFind(Iterable<T> iterable, Predicate<? super T> predicate) {
        return Iterators.tryFind(iterable.iterator(), predicate);
    }

    public static <T> int indexOf(Iterable<T> iterable, Predicate<? super T> predicate) {
        return Iterators.indexOf(iterable.iterator(), predicate);
    }

    public static <F, T> Iterable<T> transform(final Iterable<F> iterable, final Function<? super F, ? extends T> function) {
        Preconditions.checkNotNull(iterable);
        Preconditions.checkNotNull(function);
        return new FluentIterable<T>() { // from class: com.google.common.collect.Iterables.5
            @Override // java.lang.Iterable
            public Iterator<T> iterator() {
                return Iterators.transform(iterable.iterator(), function);
            }
        };
    }

    @ParametricNullness
    public static <T> T get(Iterable<T> iterable, int i) {
        Preconditions.checkNotNull(iterable);
        if (iterable instanceof List) {
            return (T) ((List) iterable).get(i);
        }
        return (T) Iterators.get(iterable.iterator(), i);
    }

    @ParametricNullness
    public static <T> T get(Iterable<? extends T> iterable, int i, @ParametricNullness T t) {
        Preconditions.checkNotNull(iterable);
        Iterators.checkNonnegative(i);
        if (iterable instanceof List) {
            List listCast = Lists.cast(iterable);
            return i < listCast.size() ? (T) listCast.get(i) : t;
        }
        Iterator<? extends T> it2 = iterable.iterator();
        Iterators.advance(it2, i);
        return (T) Iterators.getNext(it2, t);
    }

    @ParametricNullness
    public static <T> T getFirst(Iterable<? extends T> iterable, @ParametricNullness T t) {
        return (T) Iterators.getNext(iterable.iterator(), t);
    }

    @ParametricNullness
    public static <T> T getLast(Iterable<T> iterable) {
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.isEmpty()) {
                throw new NoSuchElementException();
            }
            return (T) getLastInNonemptyList(list);
        }
        return (T) Iterators.getLast(iterable.iterator());
    }

    @ParametricNullness
    public static <T> T getLast(Iterable<? extends T> iterable, @ParametricNullness T t) {
        if (iterable instanceof Collection) {
            if (((Collection) iterable).isEmpty()) {
                return t;
            }
            if (iterable instanceof List) {
                return (T) getLastInNonemptyList(Lists.cast(iterable));
            }
        }
        return (T) Iterators.getLast(iterable.iterator(), t);
    }

    @ParametricNullness
    private static <T> T getLastInNonemptyList(List<T> list) {
        return list.get(list.size() - 1);
    }

    public static <T> Iterable<T> skip(final Iterable<T> iterable, final int i) {
        Preconditions.checkNotNull(iterable);
        Preconditions.checkArgument(i >= 0, "number to skip cannot be negative");
        return new FluentIterable<T>() { // from class: com.google.common.collect.Iterables.6
            @Override // java.lang.Iterable
            public Iterator<T> iterator() {
                Iterable iterable2 = iterable;
                if (iterable2 instanceof List) {
                    List list = (List) iterable2;
                    return list.subList(Math.min(list.size(), i), list.size()).iterator();
                }
                final Iterator<T> it2 = iterable2.iterator();
                Iterators.advance(it2, i);
                return new Iterator<T>(this) { // from class: com.google.common.collect.Iterables.6.1
                    boolean atStart = true;

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return it2.hasNext();
                    }

                    @Override // java.util.Iterator
                    @ParametricNullness
                    public T next() {
                        T t = (T) it2.next();
                        this.atStart = false;
                        return t;
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        CollectPreconditions.checkRemove(!this.atStart);
                        it2.remove();
                    }
                };
            }
        };
    }

    public static <T> Iterable<T> limit(final Iterable<T> iterable, final int i) {
        Preconditions.checkNotNull(iterable);
        Preconditions.checkArgument(i >= 0, "limit is negative");
        return new FluentIterable<T>() { // from class: com.google.common.collect.Iterables.7
            @Override // java.lang.Iterable
            public Iterator<T> iterator() {
                return Iterators.limit(iterable.iterator(), i);
            }
        };
    }

    public static <T> Iterable<T> consumingIterable(final Iterable<T> iterable) {
        Preconditions.checkNotNull(iterable);
        return new FluentIterable<T>() { // from class: com.google.common.collect.Iterables.8
            @Override // java.lang.Iterable
            public Iterator<T> iterator() {
                Iterable iterable2 = iterable;
                if (iterable2 instanceof Queue) {
                    return new ConsumingQueueIterator((Queue) iterable2);
                }
                return Iterators.consumingIterator(iterable2.iterator());
            }

            @Override // com.google.common.collect.FluentIterable
            public String toString() {
                return "Iterables.consumingIterable(...)";
            }
        };
    }

    public static boolean isEmpty(Iterable<?> iterable) {
        if (iterable instanceof Collection) {
            return ((Collection) iterable).isEmpty();
        }
        return !iterable.iterator().hasNext();
    }

    public static <T> Iterable<T> mergeSorted(Iterable<? extends Iterable<? extends T>> iterable, Comparator<? super T> comparator) {
        Preconditions.checkNotNull(iterable, "iterables");
        Preconditions.checkNotNull(comparator, "comparator");
        return new UnmodifiableIterable(new AnonymousClass9(iterable, comparator));
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.google.common.collect.Iterables$9, reason: invalid class name */
    public class AnonymousClass9<T> extends FluentIterable<T> {
        public static int MediaBrowserCompatConnectionCallback;
        public static int unsubscribe;
        final /* synthetic */ Comparator val$comparator;
        final /* synthetic */ Iterable val$iterables;

        AnonymousClass9(Iterable iterable, Comparator comparator) {
            this.val$iterables = iterable;
            this.val$comparator = comparator;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return Iterators.mergeSorted(Iterables.transform(this.val$iterables, Iterables.toIterator()), this.val$comparator);
        }

        public static int updateVisuals() {
            int i = unsubscribe;
            int i2 = i % 5508379;
            unsubscribe = i + 1;
            if (i2 != 0) {
                return MediaBrowserCompatConnectionCallback;
            }
            int i3 = (int) Runtime.getRuntime().totalMemory();
            MediaBrowserCompatConnectionCallback = i3;
            return i3;
        }
    }

    static <T> Function<Iterable<? extends T>, Iterator<? extends T>> toIterator() {
        return new Function<Iterable<? extends T>, Iterator<? extends T>>() { // from class: com.google.common.collect.Iterables.10
            @Override // com.google.common.base.Function
            public Iterator<? extends T> apply(Iterable<? extends T> iterable) {
                return iterable.iterator();
            }
        };
    }

    static {
        char[] cArr = new char[1959];
        ByteBuffer.wrap("\u0019Ñ`!êít¹ÿ=y>ÃóM\u008fÔB^\u000bØÙ\"\u0084\u00adR7Þ±¥8o\u0082*\fç\u0096½\u0011l\u009b\u0011åöo\u009föCp\u0017úÞEeøo\u0081\u009f\u000bS\u0095\u0007\u001e\u0083\u0098\u0080\"M¬15ü¿µ9gÃ:LìÖ`P\nÙÜc\u0080íNw9ðÅz¬\u0004e\u008e1\u0017ù\u0091¬°\u0085ÉuC¹ÝíViÐjj§äÛ}\u0016÷_q\u008d\u008bÐ\u0004\u0006\u009e\u008a\u0018ã\u0091&+t¥¢f»\u001f\\\u0095\u009b\u000bÖ\u0080W\u0006^¼\u00992í«9!k§¿]²Ò7H\u0084ÎÂG\u0005ýBs\u0096éÁn\u001däW\u009a¡\u0010ç\u0089-\u000fh\u0085²:\u0018°T\u0019Ñ` êüt¬ÿ=y=ÃûMÍÔV^\u001fØß\"\u0087Ûá¢\u0010(Ì¶\u009c=\r»\u001a\u0001Å\u008f¾\u00168\u009c-\u001aòà¨oz\u0019Ñ`6êìt¬ÿsy+ÃøMÌÔt^+Øý\"\u0098\u00adL7ä±\u00808j\u0082:\fô\u0019Ñ`!êét»ÿsyvÃ²M\u0080ÔV^\u0018ØÙ\"\u0099\u00ad\\7î\u0004R}ô÷xisâ£dèÞ6P\u0013É\u008aCÖÅ\n?[°\u008b*6¬~%\u008a\u009fþ\u0011.\u008br\f\u009e\u0086Øø\u0019rAëÜ\u0019\u008c`*ê¦t\u00adÿ}y6ÃèMÍÔT^\bØÔ\"\u0085\u00adU7è± 8T\u0082 \fð\u0096¬\u0011@\u009b\u0006åÇo\u009fö\u0001O®6I¼\u008e\"Ã©\u0019/C\u0095\u008e\u001b³\u00825\b{\u008e\u00adt§û)a\u0097çÙn\u001aÔSZÄÀÔG\u000f\u0019\u009c`,êït¡ÿ}y!Ý·¤\u0011dè\u001d\u000f\u0097È\t\u0085\u0082_\u0004\u0005¾È0õ©}#=¥ç_áÐmJÝÌ\u0090EGÿ!qáëÌlHæ>\u0098ý\u0012 \u008b'\r,\u0087ë8W²\n4Á®\u0087'A\u0019Ñ`6êñt¼ÿfy<ÃñMÌÔD^\u0004ØÞ\"Ø\u00adT7ä±©8~\u0082\u0018\fØ\u0096õ\u0011o\u009b\u0010åÆo\u009c\u0019Ñ`6êñt¼ÿfy<ÃñMÌÔJ^\u0004ØÒ\"Ø\u00adV7è±¦8e\u0082+\fø\u0096\u00ad\u0011I\u009b/åÙo\u009eö\\p\u0006ú\u0093EsÏ(\u0019Ñ`!êít¹ÿ=y7ÃùM\u008eÔS^\nØÅ\"\u0092\u00adI7õ\u0019\u008c`*ê¦t\u00adÿgy0ÃðM\u0087Ô\b^\u0005Øß\"\u0084\u00adN\u0019\u0090` êét¼ÿwywÃòM\u0086ÔRZª#N©\u00817Û¼\n:\r\u0080\u0081\u000eñ\u00971\u001ds\u009b¸aõî2t\u008eòÚ{\u001dÁF\u0019\u0090` êåtºÿay?\u0019\u008c`*ê¦t¿ÿ`y6ÃøM\u0096ÔE^\u0019Ø\u009e\"\u009a\u00ad[7ï±±8m\u0082/\fö\u0096¬\u0011j\u009b\u0010åÌo\u009e\u0019\u0099` êæt¶\u0019\u008e` êút¼ÿ{y*ÃèMÍÔU^\u0014ØÃ\"Ù\u00adX7å±ê8o\u0082+\f÷\u0096\u00ad\u0011x\u009bLåÎo\u009cöFpXúÛEaÏ,IïÓ\u008eZs¤+.ë¨º3Z½\n\u0007Ü\u0081\u009d\bY\u0092ñ\u001c£g\u007fW0.\u009e¤D:\u0002±Å7\u0094\u008dV\u0003s\u009aë\u0010ª\u0096}lgãæy[ÿTvÑÌ\u0095BIØ\u0013_ÆÕò«p!\"¸ø>æ´e\u000bß\u0081\u0092\u0007Q\u009d0\u0014Íê\u0095`Uæ\u0004}àó´IbÏ#FíÜO;§B\tÈÓV\u0095ÝR[\u0003áÁoäö||=úê\u0000ð\u008fq\u0015Ì\u0093Ã\u001aF \u0002.Þ´\u00843Q¹eÇòMªÔ4R<Øåg@\u0019\u008e` êút¼ÿ{y*ÃèMÍÔU^\u0014ØÃ\"Ù\u00adX7å±ê8o\u0082+\f÷\u0096\u00ad\u0011x\u009bLåÛo\u0083ö\u001dp\u001aúÜEcF®?\u0000µÚ+\u009c [&\n\u009cÈ\u0012í\u008bu\u00014\u0087ã}ùòxhÅîÊgOÝ\u000bS×É\u008dNXÄlºû0£©=/;¥þ\u001aC\u0019\u008e` êút¼ÿ{y*ÃèMÍÔU^\u0014ØÃ\"Ù\u00adX7å±ê8o\u0082+\f÷\u0096\u00ad\u0011x\u009bLåÛo\u0083ö\u001dp\u001búÓEc\u0019\u0088`'êçt·ÿay?Ùq \u0095*Z´\u0000?Ñ¹Ö\u0003Q\u008d,\u0014â\u009e¸\u0018|â2mé®\u0092×=]ýÃ\u00adHoÎ6tãú\u008acH\tppéú/d\u007fï¶iÿÓ!]CÄ\u0080NÊòh\u008bÈ\u0001\u0000\u009fB\u0014\u009e\u0092Í(\u0011Qí(]¢\u008a<Ð·\u000f1@\u008b\u0099\u0005þ\u0019\u008c`*ê¦t¿ÿ`y6ÃøM\u0096ÔE^\u0019Ø\u009e\"\u0093\u00ad_7÷±\u00ad8h\u0082+à¸\u0099\u0017\u0013×\u008d\u0087\u0006\u001a\u0080_:ÜQi(Ð¢\u0016<Z·\u00901À\u008b\u000f\u0019\u0099` êætªÿ`y0ÃÿM¼Ô^^UØ\u0086÷\u009c\u008e%\u0004ã\u009a¯\u0011e\u00975-ú£¹:[°P6\u0083Ì\u00adC\tÙ°\u0019\u008c`*ê¦t¿ÿ`y6ÃøM\u0096ÔE^\u0019Ø\u009e\"\u009a\u00adU7å±¡8g\u0019\u008d`!êã\u0019\u009b`(êýt£ÿsy-ÃóM\u0091\u0019¿`5êøtïÿ@y,ÃòM\u0097ÔO^\u0000ØÕ\"×\u00ad\\7î±¶8+\u0082\r\fý\u0096ª\u0011p\u009b\u000fåÌ\u0019¿`+êìt½ÿ}y0ÃøMÃÔu^)Øû\"×\u00adX7ô±\u00ad8g\u0082:\fµ\u0096¾\u0011p\u009b\u0010å\u0089o\u0094ö\u000bp@Æó¿g5 «ñ 1¦|\u001c´\u0092\u008f\u000b9\u0081e\u0007·ý\u009br\u0014è¸náç+]vÓùIòÎ<D\\:Å°Ø)G¯\f%®\u009az\u0010?¶lÏÊEFÛGP\u0093ÖËl\u0018ât{§ñÿw5\u0019\u0099`*êät«ÿty0ÃïM\u008b1{HÔÂ\u0014\\D×ÙQ\u009c°½É\u0015C×Ý\u009dVKÐ\u001d×\u008d®+$§º¾1a·7\rù\u0083\u0097\u001aD\u0090\u0018\u0016\u009fì\u0094cIùá\u007f«ön\u009f{æÝlQòSy\u0080ÿÜE\u0005ËqR½Ø´^6¤e+ ±\u0003\u0019Ïqj\bÌ\u0082@\u001cZ\u0097\u0091\u0011Ü«\u000f%w¼¥\u0019Î\u0089hðÎzBäIo\u0083éÔS\u0014ÝcDìÎùH&²|=º§\u0010!C¨\u009b\u0019\u0098`0êät£ÿMy!Ã¤MÕ\u0019\u008c`*ê¦t\u00adÿgy0ÃðM\u0087Ô\b^\u000bØÙ\"\u0099\u00ad]7ä±¶8{\u0082<\fü\u0096¶\u0011k\u0000\u0094y-óëm§æm`=ÚòTÁÍXG\u0004ÁÖ;Õ´P.é¨§!c\u009b1\u0015ñ\u008f¶\u0019\u0099` êætªÿ`y0ÃÿM¼Ô^^UØ\u0086\"Ø\u00adI7å±¯8T\u00826\f\u00ad\u0096î\u00110\u009b\u0005åÌo\u0082öVp\u0004úÔEcÏ\u0018IòÓéZ\"\u0019\u0099` êætªÿ`y0ÃÿMÌÔA^\u0002Øß\"\u0090\u00adV7ä±\u009b8x\u0082*\fþ\u0096÷\u0011x\u009b\u0007åÇo\u0089öAp\u001fúÞ\u0019\u0099` êætªÿ`y0ÃÿMÌÔP^\u000fØß\"\u008f\u00ad\u00027·±´8$\u00828\f÷\u0096·\u0011g\u009bZå\u009fo\u009c05I\u0086ÃK]\u0004ÖÒP\u0090ê\u001fd<ýîwªñC\u000b<\u0084æ\u001eE\u0098\u0007\u0011É«\u0087%f¿\f8\u008b²øÌ*F'ßúY´ÓtlÞæ\u0082`Eú\"sÀ\u008dÏ\u0007\u0004Ô®\u00ad\b'\u0084¹\u008f2_´\u0014\u000eÊ\u0080\u00ad\u0019k\u0093.\u0015öï°`j¡ÁØgRëÌàG0Á{{¥õÇl\u0006æA`\u009a\u009aß\u0015Y\u008f®\tü\u0080/:o´¼.»©4#F]\u008a×ÆN\u001bÈIB\u0080ý?wcñ©kè\u0019¿`+êìt½ÿ}y0ÃøMÎÔ^^UØ\u0086\u0019\u008c`*ê¦t\u00adÿgy0ÃðM\u0087Ô\b^\tØÙ\"\u0084\u00adJ7í±¥8r\u0082`\fü\u0096¼tê\r@\u0087\u009b\u0019Û\u0092_\u0019\u0097`+êát»ÿ<y*ÃêM\u0080Ô\b^\u001cØÕ\"\u009a\u00adO7¬±´8y\u0082!\få\u0096«äÓ\u009d|\u0017¹\u0089æ\u0002`\u0084m>·°\u0091)\u0017£P%\u0085ßÅP\rÊ¸LáÅ$·\rÎ¢DgÚ8Q¾×¨mxãOzÂð\u008evY\u008c\u0010\u0003ç\u0099`\u001f'\u0096ä,©¢e8;\u0019\u008f` êåtºÿ<y*ÃúMÍÔJ^\u000eØÔ\"¨\u00ad^7ä±ª8x\u0082'\fá\u0096¡\u0019\u008c`*ê¦t¤ÿwy+ÃòM\u0086ÔJ^CØÑ\"\u0099\u00ad^7ó±«8b\u0082*\f»\u0096©\u0011z\u009b\u000fåÜo\u0088Z±#\u0017©\u009b7\u0090¼@:\u000b\u0080Õ\u000eð\u0097j\u001d5\u009bàa¿î)tÝò\u008f{RÁ,OÆÕ\u0084ROØ:¤\u008cÝ*W¦É BvÄ4~²ð\u0081iSã\u0004eÜ\u009f\u0093\u0010\u0014\u008aç\f\u00ad\u0085e?)±ð+ª¬o&\u0010XÀÒ\u0082KG\u0019\u008c`*ê¦t¿ÿ`y6ÃøM\u0096ÔE^\u0019Ø\u009e\"\u0095\u00adO7è±¨8o\u0082`\fó\u0096±\u0011q\u009b\u0005åÌo\u009eöCp\u0004úÔEnÏ3ë\u009c\u0092:\u0018¶\u0086¬\r{\u008b:1ø¿\u0096&[¬S*ÂÐ\u0092_CÅýC°Ê5p8þìd¦ãhi\u0017\u0017Ë\u009d\u008c\u0004Q\u0082\u000f\bÃ·d\u0019\u008c`*ê¦t¼ÿky*ÃèM\u0086ÔK^2ØÕ\"\u008f\u00adN7¯±¦8~\u0082'\fù\u0096¼\u00111\u009b\u0004åÀo\u0082öTp\u0013úÏEpÏ5IãÓ¿Z`\u0019\u008c`*ê¦t¹ÿwy7ÃøM\u008cÔT^CØÒ\"\u0082\u00adS7í± 8%\u0082(\fü\u0096¶\u0011x\u009b\u0007åÛo\u009cöAp\u001fúÓEt´\u008dÍ+G§Ù¸RvÔ6nùà\u008dyUó3uÕ\u008f\u009a\u0000P\u009aí\u001cë\u0095h/:¡ý;µ¼z6MHÎÂ\u0084[\\Ý\u0010WÙèsb6äù~¹÷{\t.(\u007f,~U\u008eßBA\u0016Ê\u0092L\u0087öVx!áük\u009dío\u00171\u0098å\u0002K`¢\u0019R\u0093\u009e\rÊ\u0086N\u0000Yº\u00804ó\u00ad>'{¡·[«Ô+N\u0093ÈÄA\u001dû_u\u0087ïÅh\bâN\u009c½\u0016ú\u008f.\t|\u0083ª\u0019Ñ`!êít¹ÿ=y*ÃóM\u0080ÔM^\bØÄ\"Ø\u00ad]7ä±ª8r\u0082*\u0019Ñ`!êít¹ÿ=y*ÃóM\u0080ÔM^\bØÄ\"Ø\u00adK7ä±©8~\u0082*\u0019Ñ`6êñt¼ÿ=y(ÃùM\u008eÔS^2ØÄ\"\u0085\u00ad[7â±¡\u0006\u0081\u007ffõ¡kìà6flÜ¡R\u009cË\u001aATÇ\u0082=\u0088²\u0006(¸®ö'8\u009dA\u0013¨\u0089é\u000e#\u0084^ú\u0096pßé<oBå\u0088Z2ÐbV½ÌÞE5»n1£·À,V¢L\u0018\u008dÊÀ³09ü§¨,,ª*\u0010þ\u009e\u0086\u0007h\u008d\u001b\u000bÑñ\u0095\u0019Ñ`!êít¹ÿ=y;ÃïM\u0097Ôy^\u0019ØÙ\"\u009a\u00ad_Ð·©G#\u008b½ß6[°L\n\u0095\u0084æ\u001d+\u0097n\u0011¢ë¾d>þ\u0094xÖñ\u000bKGÅ\u009f_ÚØ\u001cRv,«Ûî¢\t(Î¶\u0083=Y»\u0003\u0001Î\u008fó\u0016u\u009c;\u001aíàçoiõ×s\u0099úV@\u0002ÎÞT\u0081ÓOY1'ò\u00ad¶4~²\u00168è\u0087Q\r\u0011\u008b\u009b\u0011\u009d\u0098DÁ\u0082¸r2¾¬ê'n¡h\u001b¼\u0095Ä\f\u0014\u0086]\u0000\u0080úÁ\u0019Ñ`!êít¹ÿ=y;ÃïM\u0097ÔA^\u0014ØÂ\"\u0098<eE\u0095ÏYQ\rÚ\u0089\\\u008fæ[h#ñÿ{¼ýc\u0007-\u0019Ñ`!êít¹ÿ=y;ÃïM\u0097ÔI^\u001fØÙ\"\u0092\u0019Ñ`!êít¹ÿ=y;ÃïM\u0097ÔP^\u0000ØÃ\"\u0090\u0019Ñ`!êít¹ÿ=y;ÃïM\u0097ÔV^\nØÑ\"\u009e\u00adJ7â\u0019Ñ`!êít¹ÿ=y;ÃïM\u0097Ôy^\u0004ØÝ\"\u0092\u0019Ñ`!êét»ÿsyvÃøM\u008cÔQ^\u0003ØÜ\"\u0098\u00ad[7å±·8$\u0082`\fí\u0096º\u00110\u009b\u0000åÚo\u0098öX\u0019Ñ`(êæt»ÿ=y.ÃõM\u008dÔB^\u0002ØÇ\"\u0084\u00ad\u00157Ã±·8\u007f\u0082\u001d\fý\u0096¹\u0011m\u009b\u0007åÍoªö\\p\u001aúÙEeÏ5\u0019Ñ`5êút ÿqyvÃõM\u008cÔV^\u0002ØÂ\"\u0083\u00adI\u0001õx\u0018òÕlÔç\u0013\u0019Ñ`5êút ÿqyvÃïM\u0086ÔJ^\u000bØ\u009f\"\u009a\u00ad[7ñ±·\u0019\u0099`7êét£ÿ~y6ÃÿMÍÔA^\u0002ØÜ\"\u0093\u00ad\\7è±·8c\u0082`\fæ\u0096·fè\u001fV\u0095\u0090\u000bò\u0080$\u0006f¼µ2Æ«>!d§¾]£Ò3H\u0094ñè\u0088\u0019\u0002Å\u009c\u0095\u0017\u0004\u0091\r+À¥¾<v¶50ÖÊ\u00adElßÜY\u0098ÐQj\u0004ä\u0082~\u0099ùKs7\u0019\u009c`)êýtªÿay-ÃýM\u0080ÔM^\u001e\u0019Ñ` êüt¬ÿ=y4ÃóM\u0096ÔH^\u0019ØÃ\u0019Ñ`!êét»ÿsyvÃøM\u008cÔQ^\u0003ØÜ\"\u0098\u00ad[7å±·8$\u0082`\fñ\u0096¨\u00110\u009b\u0003åÙo\u009cö@pXúÅEmÏ+\u0019Ñ`5êút ÿqyvÃÿM\u0093ÔS^\u0004ØÞ\"\u0091\u00adU\u0019¹`*êät«ÿty0ÃïM\u008b\u0019Ñ`!êét»ÿsyvÃñM\u008aÔU^\u000eØ\u009f\"\u0087\u00adH7î±¢8b\u0082\"\fð\u0096«\u00110\u009b\u0001åÜo\u009eö\u001cpFú\u0092EcÏ(IçÓÿZy¤2.ý¨\u00973G½\u0019\u0007Û\u0081\u008b\bH\u0092\u00ad\u001c«ghá=kâõ³|LÆ\u0001".getBytes(CharEncoding.ISO_8859_1)).asCharBuffer().get(cArr, 0, 1959);
        _CREATION = cArr;
        _BOUNDARY = 8514226523693146181L;
    }

    /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
        java.util.NoSuchElementException
        	at java.base/java.util.TreeMap.key(Unknown Source)
        	at java.base/java.util.TreeMap.lastKey(Unknown Source)
        	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
        	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
        	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
        */
    public static java.lang.Object[] CoroutineDebuggingKt(android.content.Context r78, int r79, int r80, int r81) {
        /*
            Method dump skipped, instruction units count: 15330
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.Iterables.CoroutineDebuggingKt(android.content.Context, int, int, int):java.lang.Object[]");
    }
}
