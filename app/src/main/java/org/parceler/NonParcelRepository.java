package org.parceler;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import com.google.common.base.Ascii;
import com.salesforce.marketingcloud.analytics.stats.b;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import o.ArtificialStackFrames;
import o.onNavigationEvent;
import org.parceler.converter.ArrayListParcelConverter;
import org.parceler.converter.BooleanArrayParcelConverter;
import org.parceler.converter.CharArrayParcelConverter;
import org.parceler.converter.CollectionParcelConverter;
import org.parceler.converter.HashMapParcelConverter;
import org.parceler.converter.HashSetParcelConverter;
import org.parceler.converter.LinkedHashMapParcelConverter;
import org.parceler.converter.LinkedHashSetParcelConverter;
import org.parceler.converter.LinkedListParcelConverter;
import org.parceler.converter.NullableParcelConverter;
import org.parceler.converter.SparseArrayParcelConverter;
import org.parceler.converter.TreeMapParcelConverter;
import org.parceler.converter.TreeSetParcelConverter;

/* JADX INFO: loaded from: classes3.dex */
final class NonParcelRepository implements Repository<Parcels.ParcelableFactory> {
    private static final NonParcelRepository INSTANCE = new NonParcelRepository();
    private final Map<Class, Parcels.ParcelableFactory> parcelableCollectionFactories;

    private NonParcelRepository() {
        HashMap map = new HashMap();
        this.parcelableCollectionFactories = map;
        map.put(Collection.class, new CollectionParcelableFactory());
        map.put(List.class, new ListParcelableFactory());
        map.put(ArrayList.class, new ListParcelableFactory());
        map.put(Set.class, new SetParcelableFactory());
        map.put(HashSet.class, new SetParcelableFactory());
        map.put(TreeSet.class, new TreeSetParcelableFactory());
        map.put(SparseArray.class, new SparseArrayParcelableFactory());
        map.put(Map.class, new MapParcelableFactory());
        map.put(HashMap.class, new MapParcelableFactory());
        map.put(TreeMap.class, new TreeMapParcelableFactory());
        map.put(Integer.class, new IntegerParcelableFactory());
        map.put(Long.class, new LongParcelableFactory());
        map.put(Double.class, new DoubleParcelableFactory());
        map.put(Float.class, new FloatParcelableFactory());
        map.put(Byte.class, new ByteParcelableFactory());
        map.put(String.class, new StringParcelableFactory());
        map.put(Character.class, new CharacterParcelableFactory());
        map.put(Boolean.class, new BooleanParcelableFactory());
        map.put(byte[].class, new ByteArrayParcelableFactory());
        map.put(char[].class, new CharArrayParcelableFactory());
        map.put(boolean[].class, new BooleanArrayParcelableFactory());
        map.put(IBinder.class, new IBinderParcelableFactory());
        map.put(Bundle.class, new BundleParcelableFactory());
        map.put(SparseBooleanArray.class, new SparseBooleanArrayParcelableFactory());
        map.put(LinkedList.class, new LinkedListParcelableFactory());
        map.put(LinkedHashMap.class, new LinkedHashMapParcelableFactory());
        map.put(SortedMap.class, new TreeMapParcelableFactory());
        map.put(SortedSet.class, new TreeSetParcelableFactory());
        map.put(LinkedHashSet.class, new LinkedHashSetParcelableFactory());
    }

    public static NonParcelRepository getInstance() {
        return INSTANCE;
    }

    @Override // org.parceler.Repository
    public Map<Class, Parcels.ParcelableFactory> get() {
        return this.parcelableCollectionFactories;
    }

    static class ListParcelableFactory implements Parcels.ParcelableFactory<List> {
        private ListParcelableFactory() {
        }

        @Override // org.parceler.Parcels.ParcelableFactory
        public Parcelable buildParcelable(List list) {
            return new ListParcelable(list);
        }
    }

    static class CharacterParcelableFactory implements Parcels.ParcelableFactory<Character> {
        private CharacterParcelableFactory() {
        }

        @Override // org.parceler.Parcels.ParcelableFactory
        public Parcelable buildParcelable(Character ch2) {
            return new CharacterParcelable(ch2);
        }
    }

    static class BooleanParcelableFactory implements Parcels.ParcelableFactory<Boolean> {
        private BooleanParcelableFactory() {
        }

        @Override // org.parceler.Parcels.ParcelableFactory
        public Parcelable buildParcelable(Boolean bool) {
            return new BooleanParcelable(bool.booleanValue());
        }
    }

    static class ByteArrayParcelableFactory implements Parcels.ParcelableFactory<byte[]> {
        private ByteArrayParcelableFactory() {
        }

        @Override // org.parceler.Parcels.ParcelableFactory
        public Parcelable buildParcelable(byte[] bArr) {
            return new ByteArrayParcelable(bArr);
        }
    }

    static class CharArrayParcelableFactory implements Parcels.ParcelableFactory<char[]> {
        private CharArrayParcelableFactory() {
        }

        @Override // org.parceler.Parcels.ParcelableFactory
        public Parcelable buildParcelable(char[] cArr) {
            return new CharArrayParcelable(cArr);
        }
    }

    static class BooleanArrayParcelableFactory implements Parcels.ParcelableFactory<boolean[]> {
        private BooleanArrayParcelableFactory() {
        }

        @Override // org.parceler.Parcels.ParcelableFactory
        public Parcelable buildParcelable(boolean[] zArr) {
            return new BooleanArrayParcelable(zArr);
        }
    }

    static class IBinderParcelableFactory implements Parcels.ParcelableFactory<IBinder> {
        private IBinderParcelableFactory() {
        }

        @Override // org.parceler.Parcels.ParcelableFactory
        public Parcelable buildParcelable(IBinder iBinder) {
            return new IBinderParcelable(iBinder);
        }
    }

    public static class MapParcelableFactory implements Parcels.ParcelableFactory<Map> {
        private static final byte[] $$c = {10, -69, -10, 57};
        private static final int $$d = 153;
        private static int $10 = 0;
        private static int $11 = 1;
        private static final byte[] $$a = {46, 73, -9, 38, 9, -20, Ascii.FS, -26, -18, 10, -5, -11, 2, 19, -39, 6, -6, Ascii.ESC, -46, 8, -6, -15, 2, -4, Ascii.CR, -24, -13, -7, -12, Ascii.FF, -4, -50, -14, -31, -17, -4, 38, -49, -3, -8, 10, -24, Ascii.US, -22, -22, 10, -7, -12, -2, -22, Ascii.DLE, -18, 9, -20, 44, -35, -20, -9, 6, -11, -4, 0, -10, 2, Ascii.GS, -46, 8, -6, -15, 2, -4, 50};
        private static final int $$b = 173;
        private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
        private static int artificialFrame = 1;
        private static int setDefaultImpl = -260893955;

        /* JADX WARN: Code duplicated, block: B:10:0x0025  */
        /* JADX WARN: Code duplicated, block: B:8:0x001f  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x002c). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0025
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        private static java.lang.String $$e(short r6, short r7, int r8) {
            /*
                byte[] r0 = org.parceler.NonParcelRepository.MapParcelableFactory.$$c
                int r7 = r7 * 2
                int r7 = 116 - r7
                int r8 = r8 * 4
                int r8 = 3 - r8
                int r6 = r6 * 4
                int r1 = r6 + 1
                byte[] r1 = new byte[r1]
                r2 = 0
                if (r0 != 0) goto L17
                r7 = r6
                r3 = r8
                r4 = r2
                goto L2c
            L17:
                r3 = r2
            L18:
                byte r4 = (byte) r7
                r1[r3] = r4
                int r4 = r3 + 1
                if (r3 != r6) goto L25
                java.lang.String r6 = new java.lang.String
                r6.<init>(r1, r2)
                return r6
            L25:
                int r8 = r8 + 1
                r3 = r0[r8]
                r5 = r3
                r3 = r8
                r8 = r5
            L2c:
                int r7 = r7 + r8
                r8 = r3
                r3 = r4
                goto L18
            */
            throw new UnsupportedOperationException("Method not decompiled: org.parceler.NonParcelRepository.MapParcelableFactory.$$e(short, short, int):java.lang.String");
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
        private static void a(short r6, int r7, int r8, java.lang.Object[] r9) {
            /*
                byte[] r0 = org.parceler.NonParcelRepository.MapParcelableFactory.$$a
                int r1 = r7 + 2
                int r6 = 70 - r6
                int r8 = 115 - r8
                byte[] r1 = new byte[r1]
                int r7 = r7 + 1
                r2 = 0
                if (r0 != 0) goto L13
                r4 = r8
                r3 = r2
                r8 = r6
                goto L2a
            L13:
                r3 = r2
            L14:
                int r6 = r6 + 1
                byte r4 = (byte) r8
                r1[r3] = r4
                if (r3 != r7) goto L23
                java.lang.String r6 = new java.lang.String
                r6.<init>(r1, r2)
                r9[r2] = r6
                return
            L23:
                r4 = r0[r6]
                int r3 = r3 + 1
                r5 = r8
                r8 = r6
                r6 = r5
            L2a:
                int r4 = -r4
                int r6 = r6 + r4
                int r6 = r6 + (-5)
                r5 = r8
                r8 = r6
                r6 = r5
                goto L14
            */
            throw new UnsupportedOperationException("Method not decompiled: org.parceler.NonParcelRepository.MapParcelableFactory.a(short, int, int, java.lang.Object[]):void");
        }

        private static void b(boolean z, int i, int i2, int i3, char[] cArr, Object[] objArr) throws Throwable {
            int i4;
            char c;
            Object obj;
            int i5 = 2 % 2;
            onNavigationEvent onnavigationevent = new onNavigationEvent();
            char[] cArr2 = new char[i3];
            onnavigationevent.d = 0;
            int i6 = $11 + b.i;
            $10 = i6 % 128;
            int i7 = i6 % 2;
            while (true) {
                i4 = -1257606387;
                c = '0';
                obj = null;
                if (onnavigationevent.d >= i3) {
                    break;
                }
                onnavigationevent.c = cArr[onnavigationevent.d];
                cArr2[onnavigationevent.d] = (char) (i2 + onnavigationevent.c);
                int i8 = onnavigationevent.d;
                try {
                    Object[] objArr2 = {Integer.valueOf(cArr2[i8]), Integer.valueOf(setDefaultImpl)};
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(465886069);
                    if (objAccessartificialFrame == null) {
                        byte b = (byte) 0;
                        byte b2 = (byte) (b + 1);
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(23 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0')), TextUtils.indexOf((CharSequence) "", '0') + 1776, -2069783171, false, $$e(b, b2, (byte) (b2 - 1)), new Class[]{Integer.TYPE, Integer.TYPE});
                    }
                    cArr2[i8] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                    Object[] objArr3 = {onnavigationevent, onnavigationevent};
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1257606387);
                    if (objAccessartificialFrame2 == null) {
                        byte b3 = (byte) 0;
                        byte b4 = b3;
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(37 - KeyEvent.normalizeMetaState(0), (char) (56277 - (Process.myPid() >> 22)), (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 1258, 711931141, false, $$e(b3, b4, b4), new Class[]{Object.class, Object.class});
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
                int i9 = $11 + 73;
                $10 = i9 % 128;
                int i10 = i9 % 2;
                while (onnavigationevent.d < i3) {
                    cArr4[onnavigationevent.d] = cArr2[(i3 - onnavigationevent.d) - 1];
                    try {
                        Object[] objArr4 = {onnavigationevent, onnavigationevent};
                        Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(i4);
                        if (objAccessartificialFrame3 == null) {
                            byte b5 = (byte) 0;
                            byte b6 = b5;
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 36, (char) (56276 - TextUtils.lastIndexOf("", c)), 1259 - (ViewConfiguration.getTouchSlop() >> 8), 711931141, false, $$e(b5, b6, b6), new Class[]{Object.class, Object.class});
                        }
                        ((Method) objAccessartificialFrame3).invoke(null, objArr4);
                        i4 = -1257606387;
                        c = '0';
                    } catch (Throwable th2) {
                        Throwable cause2 = th2.getCause();
                        if (cause2 == null) {
                            throw th2;
                        }
                        throw cause2;
                    }
                }
                cArr2 = cArr4;
            }
            String str = new String(cArr2);
            int i11 = $10 + 21;
            $11 = i11 % 128;
            if (i11 % 2 != 0) {
                objArr[0] = str;
            } else {
                obj.hashCode();
                throw null;
            }
        }

        private MapParcelableFactory() {
        }

        @Override // org.parceler.Parcels.ParcelableFactory
        public Parcelable buildParcelable(Map map) {
            return new MapParcelable(map);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r18v0 */
        /* JADX WARN: Type inference failed for: r18v1 */
        /* JADX WARN: Type inference failed for: r18v11 */
        /* JADX WARN: Type inference failed for: r18v12 */
        /* JADX WARN: Type inference failed for: r18v14 */
        /* JADX WARN: Type inference failed for: r18v15 */
        /* JADX WARN: Type inference failed for: r18v16 */
        /* JADX WARN: Type inference failed for: r18v18 */
        /* JADX WARN: Type inference failed for: r18v19 */
        /* JADX WARN: Type inference failed for: r18v2 */
        /* JADX WARN: Type inference failed for: r18v20 */
        /* JADX WARN: Type inference failed for: r18v21 */
        /* JADX WARN: Type inference failed for: r18v22 */
        /* JADX WARN: Type inference failed for: r18v23 */
        /* JADX WARN: Type inference failed for: r18v24 */
        /* JADX WARN: Type inference failed for: r18v25 */
        /* JADX WARN: Type inference failed for: r18v26 */
        /* JADX WARN: Type inference failed for: r18v27 */
        /* JADX WARN: Type inference failed for: r18v28 */
        /* JADX WARN: Type inference failed for: r18v29 */
        /* JADX WARN: Type inference failed for: r18v3 */
        /* JADX WARN: Type inference failed for: r18v4 */
        /* JADX WARN: Type inference failed for: r18v5 */
        /* JADX WARN: Type inference failed for: r18v6 */
        /* JADX WARN: Type inference failed for: r18v7 */
        /* JADX WARN: Type inference failed for: r18v8 */
        /* JADX WARN: Type inference failed for: r18v9 */
        /* JADX WARN: Type inference failed for: r1v57 */
        /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
            java.util.NoSuchElementException
            	at java.base/java.util.TreeMap.key(Unknown Source)
            	at java.base/java.util.TreeMap.lastKey(Unknown Source)
            	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
            	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
            	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
            */
        public static java.lang.Object[] CoroutineDebuggingKt(android.content.Context r29, int r30, int r31, int r32) {
            /*
                Method dump skipped, instruction units count: 3231
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: org.parceler.NonParcelRepository.MapParcelableFactory.CoroutineDebuggingKt(android.content.Context, int, int, int):java.lang.Object[]");
        }
    }

    static class BundleParcelableFactory implements Parcels.ParcelableFactory<Bundle> {
        @Override // org.parceler.Parcels.ParcelableFactory
        public Parcelable buildParcelable(Bundle bundle) {
            return bundle;
        }

        private BundleParcelableFactory() {
        }
    }

    static class SparseBooleanArrayParcelableFactory implements Parcels.ParcelableFactory<SparseBooleanArray> {
        private SparseBooleanArrayParcelableFactory() {
        }

        @Override // org.parceler.Parcels.ParcelableFactory
        public Parcelable buildParcelable(SparseBooleanArray sparseBooleanArray) {
            return new SparseBooleanArrayParcelable(sparseBooleanArray);
        }
    }

    static class LinkedListParcelableFactory implements Parcels.ParcelableFactory<LinkedList> {
        private LinkedListParcelableFactory() {
        }

        @Override // org.parceler.Parcels.ParcelableFactory
        public Parcelable buildParcelable(LinkedList linkedList) {
            return new LinkedListParcelable(linkedList);
        }
    }

    static class LinkedHashMapParcelableFactory implements Parcels.ParcelableFactory<LinkedHashMap> {
        private LinkedHashMapParcelableFactory() {
        }

        @Override // org.parceler.Parcels.ParcelableFactory
        public Parcelable buildParcelable(LinkedHashMap linkedHashMap) {
            return new LinkedHashMapParcelable(linkedHashMap);
        }
    }

    static class LinkedHashSetParcelableFactory implements Parcels.ParcelableFactory<LinkedHashSet> {
        private LinkedHashSetParcelableFactory() {
        }

        @Override // org.parceler.Parcels.ParcelableFactory
        public Parcelable buildParcelable(LinkedHashSet linkedHashSet) {
            return new LinkedHashSetParcelable(linkedHashSet);
        }
    }

    static class SetParcelableFactory implements Parcels.ParcelableFactory<Set> {
        private SetParcelableFactory() {
        }

        @Override // org.parceler.Parcels.ParcelableFactory
        public Parcelable buildParcelable(Set set) {
            return new SetParcelable(set);
        }
    }

    static class TreeSetParcelableFactory implements Parcels.ParcelableFactory<Set> {
        private TreeSetParcelableFactory() {
        }

        @Override // org.parceler.Parcels.ParcelableFactory
        public Parcelable buildParcelable(Set set) {
            return new TreeSetParcelable(set);
        }
    }

    static class TreeMapParcelableFactory implements Parcels.ParcelableFactory<Map> {
        private TreeMapParcelableFactory() {
        }

        @Override // org.parceler.Parcels.ParcelableFactory
        public Parcelable buildParcelable(Map map) {
            return new TreeMapParcelable(map);
        }
    }

    static class CollectionParcelableFactory implements Parcels.ParcelableFactory<Collection> {
        private CollectionParcelableFactory() {
        }

        @Override // org.parceler.Parcels.ParcelableFactory
        public Parcelable buildParcelable(Collection collection) {
            return new CollectionParcelable(collection);
        }
    }

    static class SparseArrayParcelableFactory implements Parcels.ParcelableFactory<SparseArray> {
        private SparseArrayParcelableFactory() {
        }

        @Override // org.parceler.Parcels.ParcelableFactory
        public Parcelable buildParcelable(SparseArray sparseArray) {
            return new SparseArrayParcelable(sparseArray);
        }
    }

    static class IntegerParcelableFactory implements Parcels.ParcelableFactory<Integer> {
        private IntegerParcelableFactory() {
        }

        @Override // org.parceler.Parcels.ParcelableFactory
        public Parcelable buildParcelable(Integer num) {
            return new IntegerParcelable(num);
        }
    }

    static class LongParcelableFactory implements Parcels.ParcelableFactory<Long> {
        private LongParcelableFactory() {
        }

        @Override // org.parceler.Parcels.ParcelableFactory
        public Parcelable buildParcelable(Long l) {
            return new LongParcelable(l);
        }
    }

    static class DoubleParcelableFactory implements Parcels.ParcelableFactory<Double> {
        private DoubleParcelableFactory() {
        }

        @Override // org.parceler.Parcels.ParcelableFactory
        public Parcelable buildParcelable(Double d) {
            return new DoubleParcelable(d);
        }
    }

    static class FloatParcelableFactory implements Parcels.ParcelableFactory<Float> {
        private FloatParcelableFactory() {
        }

        @Override // org.parceler.Parcels.ParcelableFactory
        public Parcelable buildParcelable(Float f) {
            return new FloatParcelable(f);
        }
    }

    static class ByteParcelableFactory implements Parcels.ParcelableFactory<Byte> {
        private ByteParcelableFactory() {
        }

        @Override // org.parceler.Parcels.ParcelableFactory
        public Parcelable buildParcelable(Byte b) {
            return new ByteParcelable(b);
        }
    }

    static class StringParcelableFactory implements Parcels.ParcelableFactory<String> {
        private StringParcelableFactory() {
        }

        @Override // org.parceler.Parcels.ParcelableFactory
        public Parcelable buildParcelable(String str) {
            return new StringParcelable(str);
        }
    }

    static class ParcelableParcelableFactory implements Parcels.ParcelableFactory<Parcelable> {
        ParcelableParcelableFactory() {
        }

        @Override // org.parceler.Parcels.ParcelableFactory
        public Parcelable buildParcelable(Parcelable parcelable) {
            return new ParcelableParcelable(parcelable);
        }
    }

    public static final class ListParcelable extends ConverterParcelable<List> {
        private static final ArrayListParcelConverter CONVERTER = new ArrayListParcelConverter() { // from class: org.parceler.NonParcelRepository.ListParcelable.1
            @Override // org.parceler.converter.CollectionParcelConverter
            public Object itemFromParcel(android.os.Parcel parcel) {
                return Parcels.unwrap(parcel.readParcelable(ListParcelable.class.getClassLoader()));
            }

            @Override // org.parceler.converter.CollectionParcelConverter
            public void itemToParcel(Object obj, android.os.Parcel parcel) {
                parcel.writeParcelable(Parcels.wrap(obj), 0);
            }
        };
        public static final ListParcelableCreator CREATOR = new ListParcelableCreator();

        @Override // org.parceler.NonParcelRepository.ConverterParcelable, android.os.Parcelable
        public /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        @Override // org.parceler.NonParcelRepository.ConverterParcelable, android.os.Parcelable
        public /* bridge */ /* synthetic */ void writeToParcel(android.os.Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
        }

        public ListParcelable(android.os.Parcel parcel) {
            super(parcel, (TypeRangeParcelConverter) CONVERTER);
        }

        public ListParcelable(List list) {
            super(list, CONVERTER);
        }

        static final class ListParcelableCreator implements Parcelable.Creator<ListParcelable> {
            private ListParcelableCreator() {
            }

            @Override // android.os.Parcelable.Creator
            public ListParcelable createFromParcel(android.os.Parcel parcel) {
                return new ListParcelable(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public ListParcelable[] newArray(int i) {
                return new ListParcelable[i];
            }
        }
    }

    public static final class LinkedListParcelable extends ConverterParcelable<LinkedList> {
        private static final LinkedListParcelConverter CONVERTER = new LinkedListParcelConverter() { // from class: org.parceler.NonParcelRepository.LinkedListParcelable.1
            @Override // org.parceler.converter.CollectionParcelConverter
            public Object itemFromParcel(android.os.Parcel parcel) {
                return Parcels.unwrap(parcel.readParcelable(LinkedListParcelable.class.getClassLoader()));
            }

            @Override // org.parceler.converter.CollectionParcelConverter
            public void itemToParcel(Object obj, android.os.Parcel parcel) {
                parcel.writeParcelable(Parcels.wrap(obj), 0);
            }
        };
        public static final LinkedListParcelableCreator CREATOR = new LinkedListParcelableCreator();

        @Override // org.parceler.NonParcelRepository.ConverterParcelable, android.os.Parcelable
        public /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        @Override // org.parceler.NonParcelRepository.ConverterParcelable, android.os.Parcelable
        public /* bridge */ /* synthetic */ void writeToParcel(android.os.Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
        }

        public LinkedListParcelable(android.os.Parcel parcel) {
            super(parcel, (TypeRangeParcelConverter) CONVERTER);
        }

        public LinkedListParcelable(LinkedList linkedList) {
            super(linkedList, CONVERTER);
        }

        static final class LinkedListParcelableCreator implements Parcelable.Creator<LinkedListParcelable> {
            private LinkedListParcelableCreator() {
            }

            @Override // android.os.Parcelable.Creator
            public LinkedListParcelable createFromParcel(android.os.Parcel parcel) {
                return new LinkedListParcelable(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public LinkedListParcelable[] newArray(int i) {
                return new LinkedListParcelable[i];
            }
        }
    }

    public static final class MapParcelable extends ConverterParcelable<Map> {
        private static final HashMapParcelConverter CONVERTER = new HashMapParcelConverter() { // from class: org.parceler.NonParcelRepository.MapParcelable.1
            @Override // org.parceler.converter.MapParcelConverter
            public void mapKeyToParcel(Object obj, android.os.Parcel parcel) {
                parcel.writeParcelable(Parcels.wrap(obj), 0);
            }

            @Override // org.parceler.converter.MapParcelConverter
            public void mapValueToParcel(Object obj, android.os.Parcel parcel) {
                parcel.writeParcelable(Parcels.wrap(obj), 0);
            }

            @Override // org.parceler.converter.MapParcelConverter
            public Object mapKeyFromParcel(android.os.Parcel parcel) {
                return Parcels.unwrap(parcel.readParcelable(MapParcelable.class.getClassLoader()));
            }

            @Override // org.parceler.converter.MapParcelConverter
            public Object mapValueFromParcel(android.os.Parcel parcel) {
                return Parcels.unwrap(parcel.readParcelable(MapParcelable.class.getClassLoader()));
            }
        };
        public static final MapParcelableCreator CREATOR = new MapParcelableCreator();

        @Override // org.parceler.NonParcelRepository.ConverterParcelable, android.os.Parcelable
        public /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        @Override // org.parceler.NonParcelRepository.ConverterParcelable, android.os.Parcelable
        public /* bridge */ /* synthetic */ void writeToParcel(android.os.Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
        }

        public MapParcelable(android.os.Parcel parcel) {
            super(parcel, (TypeRangeParcelConverter) CONVERTER);
        }

        public MapParcelable(Map map) {
            super(map, CONVERTER);
        }

        static final class MapParcelableCreator implements Parcelable.Creator<MapParcelable> {
            private MapParcelableCreator() {
            }

            @Override // android.os.Parcelable.Creator
            public MapParcelable createFromParcel(android.os.Parcel parcel) {
                return new MapParcelable(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public MapParcelable[] newArray(int i) {
                return new MapParcelable[i];
            }
        }
    }

    public static final class LinkedHashMapParcelable extends ConverterParcelable<LinkedHashMap> {
        private static final LinkedHashMapParcelConverter CONVERTER = new LinkedHashMapParcelConverter() { // from class: org.parceler.NonParcelRepository.LinkedHashMapParcelable.1
            @Override // org.parceler.converter.MapParcelConverter
            public void mapKeyToParcel(Object obj, android.os.Parcel parcel) {
                parcel.writeParcelable(Parcels.wrap(obj), 0);
            }

            @Override // org.parceler.converter.MapParcelConverter
            public void mapValueToParcel(Object obj, android.os.Parcel parcel) {
                parcel.writeParcelable(Parcels.wrap(obj), 0);
            }

            @Override // org.parceler.converter.MapParcelConverter
            public Object mapKeyFromParcel(android.os.Parcel parcel) {
                return Parcels.unwrap(parcel.readParcelable(MapParcelable.class.getClassLoader()));
            }

            @Override // org.parceler.converter.MapParcelConverter
            public Object mapValueFromParcel(android.os.Parcel parcel) {
                return Parcels.unwrap(parcel.readParcelable(MapParcelable.class.getClassLoader()));
            }
        };
        public static final LinkedHashMapParcelableCreator CREATOR = new LinkedHashMapParcelableCreator();

        @Override // org.parceler.NonParcelRepository.ConverterParcelable, android.os.Parcelable
        public /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        @Override // org.parceler.NonParcelRepository.ConverterParcelable, android.os.Parcelable
        public /* bridge */ /* synthetic */ void writeToParcel(android.os.Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
        }

        public LinkedHashMapParcelable(android.os.Parcel parcel) {
            super(parcel, (TypeRangeParcelConverter) CONVERTER);
        }

        public LinkedHashMapParcelable(LinkedHashMap linkedHashMap) {
            super(linkedHashMap, CONVERTER);
        }

        static final class LinkedHashMapParcelableCreator implements Parcelable.Creator<LinkedHashMapParcelable> {
            private LinkedHashMapParcelableCreator() {
            }

            @Override // android.os.Parcelable.Creator
            public LinkedHashMapParcelable createFromParcel(android.os.Parcel parcel) {
                return new LinkedHashMapParcelable(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public LinkedHashMapParcelable[] newArray(int i) {
                return new LinkedHashMapParcelable[i];
            }
        }
    }

    public static final class TreeMapParcelable extends ConverterParcelable<Map> {
        private static final TreeMapParcelConverter CONVERTER = new TreeMapParcelConverter() { // from class: org.parceler.NonParcelRepository.TreeMapParcelable.1
            @Override // org.parceler.converter.MapParcelConverter
            public void mapKeyToParcel(Object obj, android.os.Parcel parcel) {
                parcel.writeParcelable(Parcels.wrap(obj), 0);
            }

            @Override // org.parceler.converter.MapParcelConverter
            public void mapValueToParcel(Object obj, android.os.Parcel parcel) {
                parcel.writeParcelable(Parcels.wrap(obj), 0);
            }

            @Override // org.parceler.converter.MapParcelConverter
            public Object mapKeyFromParcel(android.os.Parcel parcel) {
                return Parcels.unwrap(parcel.readParcelable(MapParcelable.class.getClassLoader()));
            }

            @Override // org.parceler.converter.MapParcelConverter
            public Object mapValueFromParcel(android.os.Parcel parcel) {
                return Parcels.unwrap(parcel.readParcelable(MapParcelable.class.getClassLoader()));
            }
        };
        public static final TreeMapParcelableCreator CREATOR = new TreeMapParcelableCreator();

        @Override // org.parceler.NonParcelRepository.ConverterParcelable, android.os.Parcelable
        public /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        @Override // org.parceler.NonParcelRepository.ConverterParcelable, android.os.Parcelable
        public /* bridge */ /* synthetic */ void writeToParcel(android.os.Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
        }

        public TreeMapParcelable(android.os.Parcel parcel) {
            super(parcel, (TypeRangeParcelConverter) CONVERTER);
        }

        public TreeMapParcelable(Map map) {
            super(map, CONVERTER);
        }

        static final class TreeMapParcelableCreator implements Parcelable.Creator<TreeMapParcelable> {
            private TreeMapParcelableCreator() {
            }

            @Override // android.os.Parcelable.Creator
            public TreeMapParcelable createFromParcel(android.os.Parcel parcel) {
                return new TreeMapParcelable(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public TreeMapParcelable[] newArray(int i) {
                return new TreeMapParcelable[i];
            }
        }
    }

    public static final class SetParcelable extends ConverterParcelable<Set> {
        private static final HashSetParcelConverter CONVERTER = new HashSetParcelConverter() { // from class: org.parceler.NonParcelRepository.SetParcelable.1
            @Override // org.parceler.converter.CollectionParcelConverter
            public Object itemFromParcel(android.os.Parcel parcel) {
                return Parcels.unwrap(parcel.readParcelable(SetParcelable.class.getClassLoader()));
            }

            @Override // org.parceler.converter.CollectionParcelConverter
            public void itemToParcel(Object obj, android.os.Parcel parcel) {
                parcel.writeParcelable(Parcels.wrap(obj), 0);
            }
        };
        public static final SetParcelableCreator CREATOR = new SetParcelableCreator();

        @Override // org.parceler.NonParcelRepository.ConverterParcelable, android.os.Parcelable
        public /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        @Override // org.parceler.NonParcelRepository.ConverterParcelable, android.os.Parcelable
        public /* bridge */ /* synthetic */ void writeToParcel(android.os.Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
        }

        public SetParcelable(android.os.Parcel parcel) {
            super(parcel, (TypeRangeParcelConverter) CONVERTER);
        }

        public SetParcelable(Set set) {
            super(set, CONVERTER);
        }

        static final class SetParcelableCreator implements Parcelable.Creator<SetParcelable> {
            private SetParcelableCreator() {
            }

            @Override // android.os.Parcelable.Creator
            public SetParcelable createFromParcel(android.os.Parcel parcel) {
                return new SetParcelable(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public SetParcelable[] newArray(int i) {
                return new SetParcelable[i];
            }
        }
    }

    public static final class TreeSetParcelable extends ConverterParcelable<Set> {
        private static final TreeSetParcelConverter CONVERTER = new TreeSetParcelConverter() { // from class: org.parceler.NonParcelRepository.TreeSetParcelable.1
            @Override // org.parceler.converter.CollectionParcelConverter
            public Object itemFromParcel(android.os.Parcel parcel) {
                return Parcels.unwrap(parcel.readParcelable(TreeSetParcelable.class.getClassLoader()));
            }

            @Override // org.parceler.converter.CollectionParcelConverter
            public void itemToParcel(Object obj, android.os.Parcel parcel) {
                parcel.writeParcelable(Parcels.wrap(obj), 0);
            }
        };
        public static final TreeSetParcelableCreator CREATOR = new TreeSetParcelableCreator();

        @Override // org.parceler.NonParcelRepository.ConverterParcelable, android.os.Parcelable
        public /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        @Override // org.parceler.NonParcelRepository.ConverterParcelable, android.os.Parcelable
        public /* bridge */ /* synthetic */ void writeToParcel(android.os.Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
        }

        public TreeSetParcelable(android.os.Parcel parcel) {
            super(parcel, (TypeRangeParcelConverter) CONVERTER);
        }

        public TreeSetParcelable(Set set) {
            super(set, CONVERTER);
        }

        static final class TreeSetParcelableCreator implements Parcelable.Creator<TreeSetParcelable> {
            private TreeSetParcelableCreator() {
            }

            @Override // android.os.Parcelable.Creator
            public TreeSetParcelable createFromParcel(android.os.Parcel parcel) {
                return new TreeSetParcelable(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public TreeSetParcelable[] newArray(int i) {
                return new TreeSetParcelable[i];
            }
        }
    }

    public static final class LinkedHashSetParcelable extends ConverterParcelable<LinkedHashSet> {
        private static final LinkedHashSetParcelConverter CONVERTER = new LinkedHashSetParcelConverter() { // from class: org.parceler.NonParcelRepository.LinkedHashSetParcelable.1
            @Override // org.parceler.converter.CollectionParcelConverter
            public Object itemFromParcel(android.os.Parcel parcel) {
                return Parcels.unwrap(parcel.readParcelable(LinkedHashSetParcelable.class.getClassLoader()));
            }

            @Override // org.parceler.converter.CollectionParcelConverter
            public void itemToParcel(Object obj, android.os.Parcel parcel) {
                parcel.writeParcelable(Parcels.wrap(obj), 0);
            }
        };
        public static final LinkedHashSetParcelableCreator CREATOR = new LinkedHashSetParcelableCreator();

        @Override // org.parceler.NonParcelRepository.ConverterParcelable, android.os.Parcelable
        public /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        @Override // org.parceler.NonParcelRepository.ConverterParcelable, android.os.Parcelable
        public /* bridge */ /* synthetic */ void writeToParcel(android.os.Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
        }

        public LinkedHashSetParcelable(android.os.Parcel parcel) {
            super(parcel, (TypeRangeParcelConverter) CONVERTER);
        }

        public LinkedHashSetParcelable(LinkedHashSet linkedHashSet) {
            super(linkedHashSet, CONVERTER);
        }

        static final class LinkedHashSetParcelableCreator implements Parcelable.Creator<LinkedHashSetParcelable> {
            private LinkedHashSetParcelableCreator() {
            }

            @Override // android.os.Parcelable.Creator
            public LinkedHashSetParcelable createFromParcel(android.os.Parcel parcel) {
                return new LinkedHashSetParcelable(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public LinkedHashSetParcelable[] newArray(int i) {
                return new LinkedHashSetParcelable[i];
            }
        }
    }

    public static final class CollectionParcelable extends ConverterParcelable<Collection> {
        private static final CollectionParcelConverter CONVERTER = new ArrayListParcelConverter() { // from class: org.parceler.NonParcelRepository.CollectionParcelable.1
            @Override // org.parceler.converter.CollectionParcelConverter
            public Object itemFromParcel(android.os.Parcel parcel) {
                return Parcels.unwrap(parcel.readParcelable(CollectionParcelable.class.getClassLoader()));
            }

            @Override // org.parceler.converter.CollectionParcelConverter
            public void itemToParcel(Object obj, android.os.Parcel parcel) {
                parcel.writeParcelable(Parcels.wrap(obj), 0);
            }
        };
        public static final CollectionParcelableCreator CREATOR = new CollectionParcelableCreator();

        @Override // org.parceler.NonParcelRepository.ConverterParcelable, android.os.Parcelable
        public /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        @Override // org.parceler.NonParcelRepository.ConverterParcelable, android.os.Parcelable
        public /* bridge */ /* synthetic */ void writeToParcel(android.os.Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
        }

        public CollectionParcelable(android.os.Parcel parcel) {
            super(parcel, (TypeRangeParcelConverter) CONVERTER);
        }

        public CollectionParcelable(Collection collection) {
            super(collection, CONVERTER);
        }

        static final class CollectionParcelableCreator implements Parcelable.Creator<CollectionParcelable> {
            private CollectionParcelableCreator() {
            }

            @Override // android.os.Parcelable.Creator
            public CollectionParcelable createFromParcel(android.os.Parcel parcel) {
                return new CollectionParcelable(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public CollectionParcelable[] newArray(int i) {
                return new CollectionParcelable[i];
            }
        }
    }

    public static final class SparseArrayParcelable extends ConverterParcelable<SparseArray> {
        private static final SparseArrayParcelConverter CONVERTER = new SparseArrayParcelConverter() { // from class: org.parceler.NonParcelRepository.SparseArrayParcelable.1
            @Override // org.parceler.converter.SparseArrayParcelConverter
            public Object itemFromParcel(android.os.Parcel parcel) {
                return Parcels.unwrap(parcel.readParcelable(SparseArrayParcelable.class.getClassLoader()));
            }

            @Override // org.parceler.converter.SparseArrayParcelConverter
            public void itemToParcel(Object obj, android.os.Parcel parcel) {
                parcel.writeParcelable(Parcels.wrap(obj), 0);
            }
        };
        public static final SparseArrayCreator CREATOR = new SparseArrayCreator();

        @Override // org.parceler.NonParcelRepository.ConverterParcelable, android.os.Parcelable
        public /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        @Override // org.parceler.NonParcelRepository.ConverterParcelable, android.os.Parcelable
        public /* bridge */ /* synthetic */ void writeToParcel(android.os.Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
        }

        public SparseArrayParcelable(android.os.Parcel parcel) {
            super(parcel, (TypeRangeParcelConverter) CONVERTER);
        }

        public SparseArrayParcelable(SparseArray sparseArray) {
            super(sparseArray, CONVERTER);
        }

        static final class SparseArrayCreator implements Parcelable.Creator<SparseArrayParcelable> {
            private SparseArrayCreator() {
            }

            @Override // android.os.Parcelable.Creator
            public SparseArrayParcelable createFromParcel(android.os.Parcel parcel) {
                return new SparseArrayParcelable(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public SparseArrayParcelable[] newArray(int i) {
                return new SparseArrayParcelable[i];
            }
        }
    }

    public static final class SparseBooleanArrayParcelable extends ConverterParcelable<SparseBooleanArray> {
        private static final NullableParcelConverter<SparseBooleanArray> CONVERTER = new NullableParcelConverter<SparseBooleanArray>() { // from class: org.parceler.NonParcelRepository.SparseBooleanArrayParcelable.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // org.parceler.converter.NullableParcelConverter
            public SparseBooleanArray nullSafeFromParcel(android.os.Parcel parcel) {
                return parcel.readSparseBooleanArray();
            }

            @Override // org.parceler.converter.NullableParcelConverter
            public void nullSafeToParcel(SparseBooleanArray sparseBooleanArray, android.os.Parcel parcel) {
                parcel.writeSparseBooleanArray(sparseBooleanArray);
            }
        };
        public static final SparseBooleanArrayCreator CREATOR = new SparseBooleanArrayCreator();

        @Override // org.parceler.NonParcelRepository.ConverterParcelable, android.os.Parcelable
        public /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        @Override // org.parceler.NonParcelRepository.ConverterParcelable, android.os.Parcelable
        public /* bridge */ /* synthetic */ void writeToParcel(android.os.Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
        }

        public SparseBooleanArrayParcelable(android.os.Parcel parcel) {
            super(parcel, (TypeRangeParcelConverter) CONVERTER);
        }

        public SparseBooleanArrayParcelable(SparseBooleanArray sparseBooleanArray) {
            super(sparseBooleanArray, CONVERTER);
        }

        static final class SparseBooleanArrayCreator implements Parcelable.Creator<SparseBooleanArrayParcelable> {
            private SparseBooleanArrayCreator() {
            }

            @Override // android.os.Parcelable.Creator
            public SparseBooleanArrayParcelable createFromParcel(android.os.Parcel parcel) {
                return new SparseBooleanArrayParcelable(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public SparseBooleanArrayParcelable[] newArray(int i) {
                return new SparseBooleanArrayParcelable[i];
            }
        }
    }

    public static final class IntegerParcelable extends ConverterParcelable<Integer> {
        private static final NullableParcelConverter<Integer> CONVERTER = new NullableParcelConverter<Integer>() { // from class: org.parceler.NonParcelRepository.IntegerParcelable.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // org.parceler.converter.NullableParcelConverter
            public Integer nullSafeFromParcel(android.os.Parcel parcel) {
                return Integer.valueOf(parcel.readInt());
            }

            @Override // org.parceler.converter.NullableParcelConverter
            public void nullSafeToParcel(Integer num, android.os.Parcel parcel) {
                parcel.writeInt(num.intValue());
            }
        };
        public static final IntegerParcelableCreator CREATOR = new IntegerParcelableCreator();

        @Override // org.parceler.NonParcelRepository.ConverterParcelable, android.os.Parcelable
        public /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        @Override // org.parceler.NonParcelRepository.ConverterParcelable, android.os.Parcelable
        public /* bridge */ /* synthetic */ void writeToParcel(android.os.Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
        }

        public IntegerParcelable(android.os.Parcel parcel) {
            super(parcel, (TypeRangeParcelConverter) CONVERTER);
        }

        public IntegerParcelable(Integer num) {
            super(num, CONVERTER);
        }

        static final class IntegerParcelableCreator implements Parcelable.Creator<IntegerParcelable> {
            private IntegerParcelableCreator() {
            }

            @Override // android.os.Parcelable.Creator
            public IntegerParcelable createFromParcel(android.os.Parcel parcel) {
                return new IntegerParcelable(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public IntegerParcelable[] newArray(int i) {
                return new IntegerParcelable[i];
            }
        }
    }

    public static final class LongParcelable extends ConverterParcelable<Long> {
        private static final NullableParcelConverter<Long> CONVERTER = new NullableParcelConverter<Long>() { // from class: org.parceler.NonParcelRepository.LongParcelable.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // org.parceler.converter.NullableParcelConverter
            public Long nullSafeFromParcel(android.os.Parcel parcel) {
                return Long.valueOf(parcel.readLong());
            }

            @Override // org.parceler.converter.NullableParcelConverter
            public void nullSafeToParcel(Long l, android.os.Parcel parcel) {
                parcel.writeLong(l.longValue());
            }
        };
        public static final LongParcelableCreator CREATOR = new LongParcelableCreator();

        @Override // org.parceler.NonParcelRepository.ConverterParcelable, android.os.Parcelable
        public /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        @Override // org.parceler.NonParcelRepository.ConverterParcelable, android.os.Parcelable
        public /* bridge */ /* synthetic */ void writeToParcel(android.os.Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
        }

        public LongParcelable(android.os.Parcel parcel) {
            super(parcel, (TypeRangeParcelConverter) CONVERTER);
        }

        public LongParcelable(Long l) {
            super(l, CONVERTER);
        }

        static final class LongParcelableCreator implements Parcelable.Creator<LongParcelable> {
            private LongParcelableCreator() {
            }

            @Override // android.os.Parcelable.Creator
            public LongParcelable createFromParcel(android.os.Parcel parcel) {
                return new LongParcelable(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public LongParcelable[] newArray(int i) {
                return new LongParcelable[i];
            }
        }
    }

    public static final class DoubleParcelable extends ConverterParcelable<Double> {
        private static final NullableParcelConverter<Double> CONVERTER = new NullableParcelConverter<Double>() { // from class: org.parceler.NonParcelRepository.DoubleParcelable.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // org.parceler.converter.NullableParcelConverter
            public Double nullSafeFromParcel(android.os.Parcel parcel) {
                return Double.valueOf(parcel.readDouble());
            }

            @Override // org.parceler.converter.NullableParcelConverter
            public void nullSafeToParcel(Double d, android.os.Parcel parcel) {
                parcel.writeDouble(d.doubleValue());
            }
        };
        public static final DoubleParcelableCreator CREATOR = new DoubleParcelableCreator();

        @Override // org.parceler.NonParcelRepository.ConverterParcelable, android.os.Parcelable
        public /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        @Override // org.parceler.NonParcelRepository.ConverterParcelable, android.os.Parcelable
        public /* bridge */ /* synthetic */ void writeToParcel(android.os.Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
        }

        public DoubleParcelable(android.os.Parcel parcel) {
            super(parcel, (TypeRangeParcelConverter) CONVERTER);
        }

        public DoubleParcelable(Double d) {
            super(d, CONVERTER);
        }

        static final class DoubleParcelableCreator implements Parcelable.Creator<DoubleParcelable> {
            private DoubleParcelableCreator() {
            }

            @Override // android.os.Parcelable.Creator
            public DoubleParcelable createFromParcel(android.os.Parcel parcel) {
                return new DoubleParcelable(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public DoubleParcelable[] newArray(int i) {
                return new DoubleParcelable[i];
            }
        }
    }

    public static final class FloatParcelable extends ConverterParcelable<Float> {
        private static final NullableParcelConverter<Float> CONVERTER = new NullableParcelConverter<Float>() { // from class: org.parceler.NonParcelRepository.FloatParcelable.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // org.parceler.converter.NullableParcelConverter
            public Float nullSafeFromParcel(android.os.Parcel parcel) {
                return Float.valueOf(parcel.readFloat());
            }

            @Override // org.parceler.converter.NullableParcelConverter
            public void nullSafeToParcel(Float f, android.os.Parcel parcel) {
                parcel.writeFloat(f.floatValue());
            }
        };
        public static final FloatParcelableCreator CREATOR = new FloatParcelableCreator();

        @Override // org.parceler.NonParcelRepository.ConverterParcelable, android.os.Parcelable
        public /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        @Override // org.parceler.NonParcelRepository.ConverterParcelable, android.os.Parcelable
        public /* bridge */ /* synthetic */ void writeToParcel(android.os.Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
        }

        public FloatParcelable(android.os.Parcel parcel) {
            super(parcel, (TypeRangeParcelConverter) CONVERTER);
        }

        public FloatParcelable(Float f) {
            super(f, CONVERTER);
        }

        static final class FloatParcelableCreator implements Parcelable.Creator<FloatParcelable> {
            private FloatParcelableCreator() {
            }

            @Override // android.os.Parcelable.Creator
            public FloatParcelable createFromParcel(android.os.Parcel parcel) {
                return new FloatParcelable(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public FloatParcelable[] newArray(int i) {
                return new FloatParcelable[i];
            }
        }
    }

    public static final class ByteParcelable extends ConverterParcelable<Byte> {
        private static final NullableParcelConverter<Byte> CONVERTER = new NullableParcelConverter<Byte>() { // from class: org.parceler.NonParcelRepository.ByteParcelable.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // org.parceler.converter.NullableParcelConverter
            public Byte nullSafeFromParcel(android.os.Parcel parcel) {
                return Byte.valueOf(parcel.readByte());
            }

            @Override // org.parceler.converter.NullableParcelConverter
            public void nullSafeToParcel(Byte b, android.os.Parcel parcel) {
                parcel.writeByte(b.byteValue());
            }
        };
        public static final ByteParcelableCreator CREATOR = new ByteParcelableCreator();

        @Override // org.parceler.NonParcelRepository.ConverterParcelable, android.os.Parcelable
        public /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        @Override // org.parceler.NonParcelRepository.ConverterParcelable, android.os.Parcelable
        public /* bridge */ /* synthetic */ void writeToParcel(android.os.Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
        }

        public ByteParcelable(android.os.Parcel parcel) {
            super(parcel, (TypeRangeParcelConverter) CONVERTER);
        }

        public ByteParcelable(Byte b) {
            super(b, CONVERTER);
        }

        static final class ByteParcelableCreator implements Parcelable.Creator<ByteParcelable> {
            private ByteParcelableCreator() {
            }

            @Override // android.os.Parcelable.Creator
            public ByteParcelable createFromParcel(android.os.Parcel parcel) {
                return new ByteParcelable(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public ByteParcelable[] newArray(int i) {
                return new ByteParcelable[i];
            }
        }
    }

    public static final class IBinderParcelable extends ConverterParcelable<IBinder> {
        private static final NullableParcelConverter<IBinder> CONVERTER = new NullableParcelConverter<IBinder>() { // from class: org.parceler.NonParcelRepository.IBinderParcelable.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // org.parceler.converter.NullableParcelConverter
            public IBinder nullSafeFromParcel(android.os.Parcel parcel) {
                return parcel.readStrongBinder();
            }

            @Override // org.parceler.converter.NullableParcelConverter
            public void nullSafeToParcel(IBinder iBinder, android.os.Parcel parcel) {
                parcel.writeStrongBinder(iBinder);
            }
        };
        public static final IBinderParcelableCreator CREATOR = new IBinderParcelableCreator();

        @Override // org.parceler.NonParcelRepository.ConverterParcelable, android.os.Parcelable
        public /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        @Override // org.parceler.NonParcelRepository.ConverterParcelable, android.os.Parcelable
        public /* bridge */ /* synthetic */ void writeToParcel(android.os.Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
        }

        public IBinderParcelable(android.os.Parcel parcel) {
            super(parcel, (TypeRangeParcelConverter) CONVERTER);
        }

        public IBinderParcelable(IBinder iBinder) {
            super(iBinder, CONVERTER);
        }

        static final class IBinderParcelableCreator implements Parcelable.Creator<IBinderParcelable> {
            private IBinderParcelableCreator() {
            }

            @Override // android.os.Parcelable.Creator
            public IBinderParcelable createFromParcel(android.os.Parcel parcel) {
                return new IBinderParcelable(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public IBinderParcelable[] newArray(int i) {
                return new IBinderParcelable[i];
            }
        }
    }

    public static final class ByteArrayParcelable extends ConverterParcelable<byte[]> {
        private static final NullableParcelConverter<byte[]> CONVERTER = new NullableParcelConverter<byte[]>() { // from class: org.parceler.NonParcelRepository.ByteArrayParcelable.1
            @Override // org.parceler.converter.NullableParcelConverter
            public byte[] nullSafeFromParcel(android.os.Parcel parcel) {
                return parcel.createByteArray();
            }

            @Override // org.parceler.converter.NullableParcelConverter
            public void nullSafeToParcel(byte[] bArr, android.os.Parcel parcel) {
                parcel.writeByteArray(bArr);
            }
        };
        public static final ByteArrayParcelableCreator CREATOR = new ByteArrayParcelableCreator();

        @Override // org.parceler.NonParcelRepository.ConverterParcelable, android.os.Parcelable
        public /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        @Override // org.parceler.NonParcelRepository.ConverterParcelable, android.os.Parcelable
        public /* bridge */ /* synthetic */ void writeToParcel(android.os.Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
        }

        public ByteArrayParcelable(android.os.Parcel parcel) {
            super(parcel, (TypeRangeParcelConverter) CONVERTER);
        }

        public ByteArrayParcelable(byte[] bArr) {
            super(bArr, CONVERTER);
        }

        static final class ByteArrayParcelableCreator implements Parcelable.Creator<ByteArrayParcelable> {
            private ByteArrayParcelableCreator() {
            }

            @Override // android.os.Parcelable.Creator
            public ByteArrayParcelable createFromParcel(android.os.Parcel parcel) {
                return new ByteArrayParcelable(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public ByteArrayParcelable[] newArray(int i) {
                return new ByteArrayParcelable[i];
            }
        }
    }

    public static final class BooleanArrayParcelable extends ConverterParcelable<boolean[]> {
        private static final BooleanArrayParcelConverter CONVERTER = new BooleanArrayParcelConverter();
        public static final BooleanArrayParcelableCreator CREATOR = new BooleanArrayParcelableCreator();

        @Override // org.parceler.NonParcelRepository.ConverterParcelable, android.os.Parcelable
        public /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        @Override // org.parceler.NonParcelRepository.ConverterParcelable, android.os.Parcelable
        public /* bridge */ /* synthetic */ void writeToParcel(android.os.Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
        }

        public BooleanArrayParcelable(android.os.Parcel parcel) {
            super(parcel, (TypeRangeParcelConverter) CONVERTER);
        }

        public BooleanArrayParcelable(boolean[] zArr) {
            super(zArr, CONVERTER);
        }

        static final class BooleanArrayParcelableCreator implements Parcelable.Creator<BooleanArrayParcelable> {
            private BooleanArrayParcelableCreator() {
            }

            @Override // android.os.Parcelable.Creator
            public BooleanArrayParcelable createFromParcel(android.os.Parcel parcel) {
                return new BooleanArrayParcelable(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public BooleanArrayParcelable[] newArray(int i) {
                return new BooleanArrayParcelable[i];
            }
        }
    }

    public static final class BooleanParcelable extends ConverterParcelable<Boolean> {
        private static final NullableParcelConverter<Boolean> CONVERTER = new NullableParcelConverter<Boolean>() { // from class: org.parceler.NonParcelRepository.BooleanParcelable.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // org.parceler.converter.NullableParcelConverter
            public Boolean nullSafeFromParcel(android.os.Parcel parcel) {
                return Boolean.valueOf(parcel.createBooleanArray()[0]);
            }

            @Override // org.parceler.converter.NullableParcelConverter
            public void nullSafeToParcel(Boolean bool, android.os.Parcel parcel) {
                parcel.writeBooleanArray(new boolean[]{bool.booleanValue()});
            }
        };
        public static final BooleanParcelableCreator CREATOR = new BooleanParcelableCreator();

        @Override // org.parceler.NonParcelRepository.ConverterParcelable, android.os.Parcelable
        public /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        @Override // org.parceler.NonParcelRepository.ConverterParcelable, android.os.Parcelable
        public /* bridge */ /* synthetic */ void writeToParcel(android.os.Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
        }

        public BooleanParcelable(android.os.Parcel parcel) {
            super(parcel, (TypeRangeParcelConverter) CONVERTER);
        }

        public BooleanParcelable(boolean z) {
            super(Boolean.valueOf(z), CONVERTER);
        }

        static final class BooleanParcelableCreator implements Parcelable.Creator<BooleanParcelable> {
            private BooleanParcelableCreator() {
            }

            @Override // android.os.Parcelable.Creator
            public BooleanParcelable createFromParcel(android.os.Parcel parcel) {
                return new BooleanParcelable(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public BooleanParcelable[] newArray(int i) {
                return new BooleanParcelable[i];
            }
        }
    }

    public static final class CharArrayParcelable extends ConverterParcelable<char[]> {
        private static final CharArrayParcelConverter CONVERTER = new CharArrayParcelConverter();
        public static final CharArrayParcelableCreator CREATOR = new CharArrayParcelableCreator();

        @Override // org.parceler.NonParcelRepository.ConverterParcelable, android.os.Parcelable
        public /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        @Override // org.parceler.NonParcelRepository.ConverterParcelable, android.os.Parcelable
        public /* bridge */ /* synthetic */ void writeToParcel(android.os.Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
        }

        public CharArrayParcelable(android.os.Parcel parcel) {
            super(parcel, (TypeRangeParcelConverter) CONVERTER);
        }

        public CharArrayParcelable(char[] cArr) {
            super(cArr, CONVERTER);
        }

        static final class CharArrayParcelableCreator implements Parcelable.Creator<CharArrayParcelable> {
            private CharArrayParcelableCreator() {
            }

            @Override // android.os.Parcelable.Creator
            public CharArrayParcelable createFromParcel(android.os.Parcel parcel) {
                return new CharArrayParcelable(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public CharArrayParcelable[] newArray(int i) {
                return new CharArrayParcelable[i];
            }
        }
    }

    public static final class CharacterParcelable extends ConverterParcelable<Character> {
        private static final NullableParcelConverter<Character> CONVERTER = new NullableParcelConverter<Character>() { // from class: org.parceler.NonParcelRepository.CharacterParcelable.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // org.parceler.converter.NullableParcelConverter
            public Character nullSafeFromParcel(android.os.Parcel parcel) {
                return Character.valueOf(parcel.createCharArray()[0]);
            }

            @Override // org.parceler.converter.NullableParcelConverter
            public void nullSafeToParcel(Character ch2, android.os.Parcel parcel) {
                parcel.writeCharArray(new char[]{ch2.charValue()});
            }
        };
        public static final CharacterParcelableCreator CREATOR = new CharacterParcelableCreator();

        @Override // org.parceler.NonParcelRepository.ConverterParcelable, android.os.Parcelable
        public /* bridge */ /* synthetic */ int describeContents() {
            return super.describeContents();
        }

        @Override // org.parceler.NonParcelRepository.ConverterParcelable, android.os.Parcelable
        public /* bridge */ /* synthetic */ void writeToParcel(android.os.Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
        }

        public CharacterParcelable(android.os.Parcel parcel) {
            super(parcel, (TypeRangeParcelConverter) CONVERTER);
        }

        public CharacterParcelable(Character ch2) {
            super(ch2, CONVERTER);
        }

        static final class CharacterParcelableCreator implements Parcelable.Creator<CharacterParcelable> {
            private CharacterParcelableCreator() {
            }

            @Override // android.os.Parcelable.Creator
            public CharacterParcelable createFromParcel(android.os.Parcel parcel) {
                return new CharacterParcelable(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public CharacterParcelable[] newArray(int i) {
                return new CharacterParcelable[i];
            }
        }
    }

    public static final class StringParcelable implements Parcelable, ParcelWrapper<String> {
        public static final StringParcelableCreator CREATOR = new StringParcelableCreator();
        private String contents;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        private StringParcelable(android.os.Parcel parcel) {
            this.contents = parcel.readString();
        }

        private StringParcelable(String str) {
            this.contents = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(android.os.Parcel parcel, int i) {
            parcel.writeString(this.contents);
        }

        @Override // org.parceler.ParcelWrapper
        public String getParcel() {
            return this.contents;
        }

        static final class StringParcelableCreator implements Parcelable.Creator<StringParcelable> {
            private StringParcelableCreator() {
            }

            @Override // android.os.Parcelable.Creator
            public StringParcelable createFromParcel(android.os.Parcel parcel) {
                return new StringParcelable(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public StringParcelable[] newArray(int i) {
                return new StringParcelable[i];
            }
        }
    }

    static class ConverterParcelable<T> implements Parcelable, ParcelWrapper<T> {
        private final TypeRangeParcelConverter<T, T> converter;
        private final T value;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        private ConverterParcelable(android.os.Parcel parcel, TypeRangeParcelConverter<T, T> typeRangeParcelConverter) {
            this(typeRangeParcelConverter.fromParcel(parcel), typeRangeParcelConverter);
        }

        private ConverterParcelable(T t, TypeRangeParcelConverter<T, T> typeRangeParcelConverter) {
            this.converter = typeRangeParcelConverter;
            this.value = t;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(android.os.Parcel parcel, int i) {
            this.converter.toParcel(this.value, parcel);
        }

        @Override // org.parceler.ParcelWrapper
        public T getParcel() {
            return this.value;
        }
    }

    public static final class ParcelableParcelable implements Parcelable, ParcelWrapper<Parcelable> {
        public static final ParcelableParcelableCreator CREATOR = new ParcelableParcelableCreator();
        private Parcelable parcelable;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        private ParcelableParcelable(android.os.Parcel parcel) {
            this.parcelable = parcel.readParcelable(ParcelableParcelable.class.getClassLoader());
        }

        private ParcelableParcelable(Parcelable parcelable) {
            this.parcelable = parcelable;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(android.os.Parcel parcel, int i) {
            parcel.writeParcelable(this.parcelable, i);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.parceler.ParcelWrapper
        public Parcelable getParcel() {
            return this.parcelable;
        }

        static final class ParcelableParcelableCreator implements Parcelable.Creator<ParcelableParcelable> {
            private ParcelableParcelableCreator() {
            }

            @Override // android.os.Parcelable.Creator
            public ParcelableParcelable createFromParcel(android.os.Parcel parcel) {
                return new ParcelableParcelable(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public ParcelableParcelable[] newArray(int i) {
                return new ParcelableParcelable[i];
            }
        }
    }
}
