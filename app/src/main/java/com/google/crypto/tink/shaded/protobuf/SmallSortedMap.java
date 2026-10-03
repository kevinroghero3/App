package com.google.crypto.tink.shaded.protobuf;

import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ExpandableListView;
import com.google.common.base.Ascii;
import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import o.ArtificialStackFrames;
import o.onRelationshipValidationResult;

/* JADX INFO: loaded from: classes3.dex */
class SmallSortedMap<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    static final int DEFAULT_FIELD_MAP_ARRAY_SIZE = 16;
    private Object[] entries;
    private int entriesSize;
    private boolean isImmutable;
    private volatile SmallSortedMap<K, V>.EntrySet lazyEntrySet;
    private Map<K, V> overflowEntries;
    private Map<K, V> overflowEntriesDescending;

    public class DescendingEntrySet extends SmallSortedMap<K, V>.EntrySet {
        private static final byte[] $$c = {85, 48, 73, -84};
        private static final int $$d = 219;
        private static int $10 = 0;
        private static int $11 = 1;
        private static final byte[] $$a = {96, -63, 33, 4, Ascii.VT, 2, -12};
        private static final int $$b = 183;
        private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
        private static int artificialFrame = 1;
        private static long onPostMessage = 2624856381276269867L;

        private static String $$e(int i, int i2, int i3) {
            int i4 = 111 - (i3 * 3);
            int i5 = i2 * 3;
            byte[] bArr = $$c;
            int i6 = 3 - (i * 2);
            byte[] bArr2 = new byte[i5 + 1];
            int i7 = -1;
            if (bArr == null) {
                i4 = i5 + i4;
            }
            while (true) {
                i7++;
                bArr2[i7] = (byte) i4;
                if (i7 == i5) {
                    return new String(bArr2, 0);
                }
                i6++;
                i4 += bArr[i6];
            }
        }

        /* JADX WARN: Code duplicated, block: B:10:0x0028  */
        /* JADX WARN: Code duplicated, block: B:8:0x0020  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0028 -> B:11:0x002a). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0028
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        private static void b(byte r5, short r6, byte r7, java.lang.Object[] r8) {
            /*
                int r6 = r6 * 2
                int r0 = 4 - r6
                int r7 = r7 * 3
                int r7 = r7 + 109
                byte[] r1 = com.google.crypto.tink.shaded.protobuf.SmallSortedMap.DescendingEntrySet.$$a
                int r5 = r5 * 4
                int r5 = 4 - r5
                byte[] r0 = new byte[r0]
                int r6 = 3 - r6
                r2 = 0
                if (r1 != 0) goto L18
                r3 = r5
                r4 = r2
                goto L2a
            L18:
                r3 = r2
            L19:
                byte r4 = (byte) r7
                r0[r3] = r4
                int r4 = r3 + 1
                if (r3 != r6) goto L28
                java.lang.String r5 = new java.lang.String
                r5.<init>(r0, r2)
                r8[r2] = r5
                return
            L28:
                r3 = r1[r5]
            L2a:
                int r5 = r5 + 1
                int r7 = r7 + r3
                int r7 = r7 + (-3)
                r3 = r4
                goto L19
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.SmallSortedMap.DescendingEntrySet.b(byte, short, byte, java.lang.Object[]):void");
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
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(28 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), (char) (30690 - KeyEvent.normalizeMetaState(0)), View.combineMeasuredStates(0, 0) + 188, -1327449315, false, "k", new Class[]{Long.TYPE, Long.TYPE, Long.TYPE});
                    }
                    cArrAccessartificialFrame[i3] = ((Character) ((java.lang.reflect.Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                    Object[] objArr3 = {onrelationshipvalidationresult, onrelationshipvalidationresult};
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(321542193);
                    if (objAccessartificialFrame2 == null) {
                        byte b = (byte) 0;
                        byte b2 = b;
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(ExpandableListView.getPackedPositionChild(0L) + 34, (char) View.MeasureSpec.getSize(0), TextUtils.indexOf((CharSequence) "", '0') + 1484, -1940971975, false, $$e(b, b2, b2), new Class[]{Object.class, Object.class});
                    }
                    ((java.lang.reflect.Method) objAccessartificialFrame2).invoke(null, objArr3);
                    int i4 = $10 + 33;
                    $11 = i4 % 128;
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
            int i6 = $11 + 117;
            $10 = i6 % 128;
            int i7 = i6 % 2;
            objArr[0] = str;
        }

        private DescendingEntrySet() {
            super();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.SmallSortedMap.EntrySet, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new DescendingEntryIterator();
        }

        /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
            java.util.NoSuchElementException
            	at java.base/java.util.TreeMap.key(Unknown Source)
            	at java.base/java.util.TreeMap.lastKey(Unknown Source)
            	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
            	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
            	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
            */
        public static java.lang.Object[] coroutineCreation(int r32, int r33) {
            /*
                Method dump skipped, instruction units count: 2759
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.SmallSortedMap.DescendingEntrySet.coroutineCreation(int, int):java.lang.Object[]");
        }
    }

    static <FieldDescriptorT extends FieldSet.FieldDescriptorLite<FieldDescriptorT>> SmallSortedMap<FieldDescriptorT, Object> newFieldMap() {
        return (SmallSortedMap<FieldDescriptorT, Object>) new SmallSortedMap<FieldDescriptorT, Object>() { // from class: com.google.crypto.tink.shaded.protobuf.SmallSortedMap.1
            @Override // com.google.crypto.tink.shaded.protobuf.SmallSortedMap, java.util.AbstractMap, java.util.Map
            public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
                return super.put((Comparable) obj, obj2);
            }

            @Override // com.google.crypto.tink.shaded.protobuf.SmallSortedMap
            public void makeImmutable() {
                if (!isImmutable()) {
                    for (int i = 0; i < getNumArrayEntries(); i++) {
                        Map.Entry<FieldDescriptorT, Object> arrayEntryAt = getArrayEntryAt(i);
                        if (((FieldSet.FieldDescriptorLite) arrayEntryAt.getKey()).isRepeated()) {
                            arrayEntryAt.setValue(Collections.unmodifiableList((List) arrayEntryAt.getValue()));
                        }
                    }
                    for (Map.Entry<FieldDescriptorT, Object> entry : getOverflowEntries()) {
                        if (((FieldSet.FieldDescriptorLite) entry.getKey()).isRepeated()) {
                            entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                        }
                    }
                }
                super.makeImmutable();
            }
        };
    }

    static <K extends Comparable<K>, V> SmallSortedMap<K, V> newInstanceForTest() {
        return new SmallSortedMap<>();
    }

    private SmallSortedMap() {
        this.overflowEntries = Collections.emptyMap();
        this.overflowEntriesDescending = Collections.emptyMap();
    }

    public void makeImmutable() {
        Map<K, V> mapUnmodifiableMap;
        Map<K, V> mapUnmodifiableMap2;
        if (this.isImmutable) {
            return;
        }
        if (this.overflowEntries.isEmpty()) {
            mapUnmodifiableMap = Collections.emptyMap();
        } else {
            mapUnmodifiableMap = Collections.unmodifiableMap(this.overflowEntries);
        }
        this.overflowEntries = mapUnmodifiableMap;
        if (this.overflowEntriesDescending.isEmpty()) {
            mapUnmodifiableMap2 = Collections.emptyMap();
        } else {
            mapUnmodifiableMap2 = Collections.unmodifiableMap(this.overflowEntriesDescending);
        }
        this.overflowEntriesDescending = mapUnmodifiableMap2;
        this.isImmutable = true;
    }

    public boolean isImmutable() {
        return this.isImmutable;
    }

    public int getNumArrayEntries() {
        return this.entriesSize;
    }

    public Map.Entry<K, V> getArrayEntryAt(int i) {
        if (i >= this.entriesSize) {
            throw new ArrayIndexOutOfBoundsException(i);
        }
        return (Entry) this.entries[i];
    }

    public int getNumOverflowEntries() {
        return this.overflowEntries.size();
    }

    public Iterable<Map.Entry<K, V>> getOverflowEntries() {
        if (this.overflowEntries.isEmpty()) {
            return Collections.emptySet();
        }
        return this.overflowEntries.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.entriesSize + this.overflowEntries.size();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return binarySearchInArray(comparable) >= 0 || this.overflowEntries.containsKey(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iBinarySearchInArray = binarySearchInArray(comparable);
        if (iBinarySearchInArray >= 0) {
            return (V) ((Entry) this.entries[iBinarySearchInArray]).getValue();
        }
        return this.overflowEntries.get(comparable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        checkMutable();
        int iBinarySearchInArray = binarySearchInArray(k);
        if (iBinarySearchInArray >= 0) {
            return (V) ((Entry) this.entries[iBinarySearchInArray]).setValue(v);
        }
        ensureEntryArrayMutable();
        int i = -(iBinarySearchInArray + 1);
        if (i >= 16) {
            return getOverflowEntriesMutable().put(k, v);
        }
        int i2 = this.entriesSize;
        if (i2 == 16) {
            Entry entry = (Entry) this.entries[15];
            this.entriesSize = i2 - 1;
            getOverflowEntriesMutable().put(entry.getKey(), entry.getValue());
        }
        Object[] objArr = this.entries;
        System.arraycopy(objArr, i, objArr, i + 1, (objArr.length - i) - 1);
        this.entries[i] = new Entry(k, v);
        this.entriesSize++;
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        checkMutable();
        if (this.entriesSize != 0) {
            this.entries = null;
            this.entriesSize = 0;
        }
        if (this.overflowEntries.isEmpty()) {
            return;
        }
        this.overflowEntries.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        checkMutable();
        Comparable comparable = (Comparable) obj;
        int iBinarySearchInArray = binarySearchInArray(comparable);
        if (iBinarySearchInArray >= 0) {
            return removeArrayEntryAt(iBinarySearchInArray);
        }
        if (this.overflowEntries.isEmpty()) {
            return null;
        }
        return this.overflowEntries.remove(comparable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public V removeArrayEntryAt(int i) {
        checkMutable();
        V v = (V) ((Entry) this.entries[i]).getValue();
        Object[] objArr = this.entries;
        System.arraycopy(objArr, i + 1, objArr, i, (this.entriesSize - i) - 1);
        this.entriesSize--;
        if (!this.overflowEntries.isEmpty()) {
            Iterator<Map.Entry<K, V>> it2 = getOverflowEntriesMutable().entrySet().iterator();
            this.entries[this.entriesSize] = new Entry(this, it2.next());
            this.entriesSize++;
            it2.remove();
        }
        return v;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x001f  */
    /* JADX WARN: Code duplicated, block: B:15:0x0038  */
    /* JADX WARN: Code duplicated, block: B:20:0x0036 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:21:0x0033 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:22:0x003b A[SYNTHETIC] */
    private int binarySearchInArray(K k) {
        int i;
        int iCompareTo;
        int i2 = this.entriesSize;
        int i3 = i2 - 1;
        if (i3 < 0) {
            i2 = 0;
            while (i2 <= i3) {
                i = (i2 + i3) / 2;
                iCompareTo = k.compareTo(((Entry) this.entries[i]).getKey());
                if (iCompareTo < 0) {
                    i3 = i - 1;
                } else {
                    if (iCompareTo > 0) {
                        return i;
                    }
                    i2 = i + 1;
                }
            }
        } else {
            int iCompareTo2 = k.compareTo(((Entry) this.entries[i3]).getKey());
            if (iCompareTo2 <= 0) {
                if (iCompareTo2 == 0) {
                    return i3;
                }
                i2 = 0;
                while (i2 <= i3) {
                    i = (i2 + i3) / 2;
                    iCompareTo = k.compareTo(((Entry) this.entries[i]).getKey());
                    if (iCompareTo < 0) {
                        i3 = i - 1;
                    } else {
                        if (iCompareTo > 0) {
                            return i;
                        }
                        i2 = i + 1;
                    }
                }
            }
        }
        return -(i2 + 1);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.lazyEntrySet == null) {
            this.lazyEntrySet = new EntrySet();
        }
        return this.lazyEntrySet;
    }

    Set<Map.Entry<K, V>> descendingEntrySet() {
        return new DescendingEntrySet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkMutable() {
        if (this.isImmutable) {
            throw new UnsupportedOperationException();
        }
    }

    private SortedMap<K, V> getOverflowEntriesMutable() {
        checkMutable();
        if (this.overflowEntries.isEmpty() && !(this.overflowEntries instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.overflowEntries = treeMap;
            this.overflowEntriesDescending = treeMap.descendingMap();
        }
        return (SortedMap) this.overflowEntries;
    }

    private void ensureEntryArrayMutable() {
        checkMutable();
        if (this.entries == null) {
            this.entries = new Object[16];
        }
    }

    class Entry implements Map.Entry<K, V>, Comparable<SmallSortedMap<K, V>.Entry> {
        private final K key;
        private V value;

        Entry(SmallSortedMap smallSortedMap, Map.Entry<K, V> entry) {
            this(entry.getKey(), entry.getValue());
        }

        Entry(K k, V v) {
            this.key = k;
            this.value = v;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.value;
        }

        @Override // java.lang.Comparable
        public int compareTo(SmallSortedMap<K, V>.Entry entry) {
            return getKey().compareTo(entry.getKey());
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            SmallSortedMap.this.checkMutable();
            V v2 = this.value;
            this.value = v;
            return v2;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return equals(this.key, entry.getKey()) && equals(this.value, entry.getValue());
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k = this.key;
            int iHashCode = k == null ? 0 : k.hashCode();
            V v = this.value;
            return iHashCode ^ (v != null ? v.hashCode() : 0);
        }

        public String toString() {
            return this.key + "=" + this.value;
        }

        private boolean equals(Object obj, Object obj2) {
            if (obj == null) {
                return obj2 == null;
            }
            return obj.equals(obj2);
        }
    }

    class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        private EntrySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new EntryIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return SmallSortedMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = SmallSortedMap.this.get(entry.getKey());
            Object value = entry.getValue();
            return obj2 == value || (obj2 != null && obj2.equals(value));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(Map.Entry<K, V> entry) {
            if (contains(entry)) {
                return false;
            }
            SmallSortedMap.this.put((Comparable) entry.getKey(), (Object) entry.getValue());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            if (!contains(entry)) {
                return false;
            }
            SmallSortedMap.this.remove(entry.getKey());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            SmallSortedMap.this.clear();
        }
    }

    class EntryIterator implements Iterator<Map.Entry<K, V>> {
        private Iterator<Map.Entry<K, V>> lazyOverflowIterator;
        private boolean nextCalledBeforeRemove;
        private int pos;

        private EntryIterator() {
            this.pos = -1;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.pos + 1 >= SmallSortedMap.this.entriesSize) {
                return !SmallSortedMap.this.overflowEntries.isEmpty() && getOverflowIterator().hasNext();
            }
            return true;
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            this.nextCalledBeforeRemove = true;
            int i = this.pos + 1;
            this.pos = i;
            if (i < SmallSortedMap.this.entriesSize) {
                return (Entry) SmallSortedMap.this.entries[this.pos];
            }
            return getOverflowIterator().next();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.nextCalledBeforeRemove) {
                throw new IllegalStateException("remove() was called before next()");
            }
            this.nextCalledBeforeRemove = false;
            SmallSortedMap.this.checkMutable();
            if (this.pos < SmallSortedMap.this.entriesSize) {
                SmallSortedMap smallSortedMap = SmallSortedMap.this;
                int i = this.pos;
                this.pos = i - 1;
                smallSortedMap.removeArrayEntryAt(i);
                return;
            }
            getOverflowIterator().remove();
        }

        private Iterator<Map.Entry<K, V>> getOverflowIterator() {
            if (this.lazyOverflowIterator == null) {
                this.lazyOverflowIterator = SmallSortedMap.this.overflowEntries.entrySet().iterator();
            }
            return this.lazyOverflowIterator;
        }
    }

    class DescendingEntryIterator implements Iterator<Map.Entry<K, V>> {
        private Iterator<Map.Entry<K, V>> lazyOverflowIterator;
        private int pos;

        private DescendingEntryIterator() {
            this.pos = SmallSortedMap.this.entriesSize;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            int i = this.pos;
            return (i > 0 && i <= SmallSortedMap.this.entriesSize) || getOverflowIterator().hasNext();
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            if (!getOverflowIterator().hasNext()) {
                Object[] objArr = SmallSortedMap.this.entries;
                int i = this.pos - 1;
                this.pos = i;
                return (Entry) objArr[i];
            }
            return getOverflowIterator().next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        private Iterator<Map.Entry<K, V>> getOverflowIterator() {
            if (this.lazyOverflowIterator == null) {
                this.lazyOverflowIterator = SmallSortedMap.this.overflowEntriesDescending.entrySet().iterator();
            }
            return this.lazyOverflowIterator;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SmallSortedMap)) {
            return super.equals(obj);
        }
        SmallSortedMap smallSortedMap = (SmallSortedMap) obj;
        int size = size();
        if (size != smallSortedMap.size()) {
            return false;
        }
        int numArrayEntries = getNumArrayEntries();
        if (numArrayEntries != smallSortedMap.getNumArrayEntries()) {
            return entrySet().equals(smallSortedMap.entrySet());
        }
        for (int i = 0; i < numArrayEntries; i++) {
            if (!getArrayEntryAt(i).equals(smallSortedMap.getArrayEntryAt(i))) {
                return false;
            }
        }
        if (numArrayEntries != size) {
            return this.overflowEntries.equals(smallSortedMap.overflowEntries);
        }
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int numArrayEntries = getNumArrayEntries();
        int iHashCode = 0;
        for (int i = 0; i < numArrayEntries; i++) {
            iHashCode += this.entries[i].hashCode();
        }
        return getNumOverflowEntries() > 0 ? iHashCode + this.overflowEntries.hashCode() : iHashCode;
    }
}
