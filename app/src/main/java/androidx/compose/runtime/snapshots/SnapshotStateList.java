package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.PreconditionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableList;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public final class SnapshotStateList<T> implements StateObject, List<T>, RandomAccess, KMutableList {
    public static final int $stable = 0;
    private StateRecord firstStateRecord;

    public static /* synthetic */ void getDebuggerDisplayValue$annotations() {
    }

    public static /* synthetic */ void getReadable$runtime_release$annotations() {
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) CollectionToArray.toArray(this, tArr);
    }

    public SnapshotStateList() {
        PersistentList persistentListPersistentListOf = ExtensionsKt.persistentListOf();
        StateListStateRecord stateListStateRecord = new StateListStateRecord(persistentListPersistentListOf);
        if (Snapshot.Companion.isInSnapshot()) {
            StateListStateRecord stateListStateRecord2 = new StateListStateRecord(persistentListPersistentListOf);
            stateListStateRecord2.setSnapshotId$runtime_release(1);
            stateListStateRecord.setNext$runtime_release(stateListStateRecord2);
        }
        this.firstStateRecord = stateListStateRecord;
    }

    @Override // java.util.List
    public final T remove(int i) {
        return removeAt(i);
    }

    @Override // java.util.List, java.util.Collection
    public final int size() {
        return getSize();
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public StateRecord getFirstStateRecord() {
        return this.firstStateRecord;
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public void prependStateRecord(@NotNull StateRecord stateRecord) {
        stateRecord.setNext$runtime_release(getFirstStateRecord());
        Intrinsics.checkNotNull(stateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        this.firstStateRecord = (StateListStateRecord) stateRecord;
    }

    public final List<T> toList() {
        return getReadable$runtime_release().getList$runtime_release();
    }

    public final StateListStateRecord<T> getReadable$runtime_release() {
        StateRecord firstStateRecord = getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        return (StateListStateRecord) SnapshotKt.readable((StateListStateRecord) firstStateRecord, this);
    }

    /* JADX INFO: loaded from: classes4.dex */
    public static final class StateListStateRecord<T> extends StateRecord {
        public static final int $stable = 8;
        private PersistentList<? extends T> list;
        private int modification;
        private int structuralChange;

        public final PersistentList<T> getList$runtime_release() {
            return this.list;
        }

        public final void setList$runtime_release(@NotNull PersistentList<? extends T> persistentList) {
            this.list = persistentList;
        }

        public StateListStateRecord(@NotNull PersistentList<? extends T> persistentList) {
            this.list = persistentList;
        }

        public final int getModification$runtime_release() {
            return this.modification;
        }

        public final void setModification$runtime_release(int i) {
            this.modification = i;
        }

        public final int getStructuralChange$runtime_release() {
            return this.structuralChange;
        }

        public final void setStructuralChange$runtime_release(int i) {
            this.structuralChange = i;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public void assign(@NotNull StateRecord stateRecord) {
            synchronized (SnapshotStateListKt.sync) {
                Intrinsics.checkNotNull(stateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord.assign$lambda$0>");
                this.list = ((StateListStateRecord) stateRecord).list;
                this.modification = ((StateListStateRecord) stateRecord).modification;
                this.structuralChange = ((StateListStateRecord) stateRecord).structuralChange;
                Unit unit = Unit.INSTANCE;
            }
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public StateRecord create() {
            return new StateListStateRecord(this.list);
        }
    }

    public int getSize() {
        return getReadable$runtime_release().getList$runtime_release().size();
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        return getReadable$runtime_release().getList$runtime_release().contains(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(@NotNull Collection<? extends Object> collection) {
        return getReadable$runtime_release().getList$runtime_release().containsAll(collection);
    }

    @Override // java.util.List
    public T get(int i) {
        return getReadable$runtime_release().getList$runtime_release().get(i);
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        return getReadable$runtime_release().getList$runtime_release().indexOf(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return getReadable$runtime_release().getList$runtime_release().isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        return listIterator();
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        return getReadable$runtime_release().getList$runtime_release().lastIndexOf(obj);
    }

    @Override // java.util.List
    public ListIterator<T> listIterator() {
        return new StateListIterator(this, 0);
    }

    @Override // java.util.List
    public ListIterator<T> listIterator(int i) {
        return new StateListIterator(this, i);
    }

    @Override // java.util.List
    public List<T> subList(int i, int i2) {
        if (i < 0 || i > i2 || i2 > size()) {
            PreconditionsKt.throwIllegalArgumentException("fromIndex or toIndex are out of bounds");
        }
        return new SubList(this, i, i2);
    }

    public String toString() {
        StateRecord firstStateRecord = getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        return "SnapshotStateList(value=" + ((StateListStateRecord) SnapshotKt.current((StateListStateRecord) firstStateRecord)).getList$runtime_release() + ")@" + hashCode();
    }

    @Override // java.util.List
    public boolean addAll(final int i, @NotNull final Collection<? extends T> collection) {
        return mutateBoolean(new Function1<List<T>, Boolean>() { // from class: androidx.compose.runtime.snapshots.SnapshotStateList.addAll.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(@NotNull List<T> list) {
                return Boolean.valueOf(list.addAll(i, collection));
            }
        });
    }

    public T removeAt(int i) {
        int modification$runtime_release;
        PersistentList<T> list$runtime_release;
        Snapshot current;
        boolean z;
        T t = get(i);
        do {
            synchronized (SnapshotStateListKt.sync) {
                StateRecord firstStateRecord = getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) firstStateRecord);
                modification$runtime_release = stateListStateRecord.getModification$runtime_release();
                list$runtime_release = stateListStateRecord.getList$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList<T> persistentListRemoveAt = list$runtime_release.removeAt(i);
            if (Intrinsics.areEqual(persistentListRemoveAt, list$runtime_release)) {
                break;
            }
            StateRecord firstStateRecord2 = getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            StateListStateRecord stateListStateRecord2 = (StateListStateRecord) firstStateRecord2;
            SnapshotKt.getSnapshotInitializer();
            synchronized (SnapshotKt.getLock()) {
                current = Snapshot.Companion.getCurrent();
                StateListStateRecord stateListStateRecord3 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord2, this, current);
                synchronized (SnapshotStateListKt.sync) {
                    if (stateListStateRecord3.getModification$runtime_release() == modification$runtime_release) {
                        stateListStateRecord3.setList$runtime_release(persistentListRemoveAt);
                        z = true;
                        stateListStateRecord3.setStructuralChange$runtime_release(stateListStateRecord3.getStructuralChange$runtime_release() + 1);
                        stateListStateRecord3.setModification$runtime_release(stateListStateRecord3.getModification$runtime_release() + 1);
                    } else {
                        z = false;
                    }
                }
            }
            SnapshotKt.notifyWrite(current, this);
        } while (!z);
        return t;
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(@NotNull final Collection<? extends Object> collection) {
        return mutateBoolean(new Function1<List<T>, Boolean>() { // from class: androidx.compose.runtime.snapshots.SnapshotStateList.retainAll.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(@NotNull List<T> list) {
                return Boolean.valueOf(list.retainAll(collection));
            }
        });
    }

    @Override // java.util.List
    public T set(int i, T t) {
        int modification$runtime_release;
        PersistentList<T> list$runtime_release;
        Snapshot current;
        boolean z;
        T t2 = get(i);
        do {
            synchronized (SnapshotStateListKt.sync) {
                StateRecord firstStateRecord = getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) firstStateRecord);
                modification$runtime_release = stateListStateRecord.getModification$runtime_release();
                list$runtime_release = stateListStateRecord.getList$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList<T> persistentList = list$runtime_release.set(i, t);
            if (Intrinsics.areEqual(persistentList, list$runtime_release)) {
                break;
            }
            StateRecord firstStateRecord2 = getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            StateListStateRecord stateListStateRecord2 = (StateListStateRecord) firstStateRecord2;
            SnapshotKt.getSnapshotInitializer();
            synchronized (SnapshotKt.getLock()) {
                current = Snapshot.Companion.getCurrent();
                StateListStateRecord stateListStateRecord3 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord2, this, current);
                synchronized (SnapshotStateListKt.sync) {
                    if (stateListStateRecord3.getModification$runtime_release() == modification$runtime_release) {
                        stateListStateRecord3.setList$runtime_release(persistentList);
                        z = true;
                        stateListStateRecord3.setModification$runtime_release(stateListStateRecord3.getModification$runtime_release() + 1);
                    } else {
                        z = false;
                    }
                }
            }
            SnapshotKt.notifyWrite(current, this);
        } while (!z);
        return t2;
    }

    public final int retainAllInRange$runtime_release(@NotNull Collection<? extends T> collection, int i, int i2) {
        int modification$runtime_release;
        PersistentList<T> list$runtime_release;
        Snapshot current;
        boolean z;
        int size = size();
        do {
            synchronized (SnapshotStateListKt.sync) {
                StateRecord firstStateRecord = getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) firstStateRecord);
                modification$runtime_release = stateListStateRecord.getModification$runtime_release();
                list$runtime_release = stateListStateRecord.getList$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList.Builder<T> builder = list$runtime_release.builder();
            builder.subList(i, i2).retainAll(collection);
            PersistentList<T> persistentListBuild = builder.build();
            if (Intrinsics.areEqual(persistentListBuild, list$runtime_release)) {
                break;
            }
            StateRecord firstStateRecord2 = getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            StateListStateRecord stateListStateRecord2 = (StateListStateRecord) firstStateRecord2;
            SnapshotKt.getSnapshotInitializer();
            synchronized (SnapshotKt.getLock()) {
                current = Snapshot.Companion.getCurrent();
                StateListStateRecord stateListStateRecord3 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord2, this, current);
                synchronized (SnapshotStateListKt.sync) {
                    if (stateListStateRecord3.getModification$runtime_release() == modification$runtime_release) {
                        stateListStateRecord3.setList$runtime_release(persistentListBuild);
                        z = true;
                        stateListStateRecord3.setModification$runtime_release(stateListStateRecord3.getModification$runtime_release() + 1);
                        stateListStateRecord3.setStructuralChange$runtime_release(stateListStateRecord3.getStructuralChange$runtime_release() + 1);
                    } else {
                        z = false;
                    }
                }
            }
            SnapshotKt.notifyWrite(current, this);
        } while (!z);
        return size - size();
    }

    private final <R> R writable(Function1<? super StateListStateRecord<T>, ? extends R> function1) {
        Snapshot current;
        R rInvoke;
        StateRecord firstStateRecord = getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        StateListStateRecord stateListStateRecord = (StateListStateRecord) firstStateRecord;
        SnapshotKt.getSnapshotInitializer();
        synchronized (SnapshotKt.getLock()) {
            try {
                current = Snapshot.Companion.getCurrent();
                rInvoke = function1.invoke(SnapshotKt.writableRecord(stateListStateRecord, this, current));
                InlineMarker.finallyStart(1);
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                throw th;
            }
        }
        InlineMarker.finallyEnd(1);
        SnapshotKt.notifyWrite(current, this);
        return rInvoke;
    }

    private final <R> R withCurrent(Function1<? super StateListStateRecord<T>, ? extends R> function1) {
        StateRecord firstStateRecord = getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        return function1.invoke(SnapshotKt.current((StateListStateRecord) firstStateRecord));
    }

    private final <R> R mutate(Function1<? super List<T>, ? extends R> function1) {
        int modification$runtime_release;
        PersistentList<T> list$runtime_release;
        R rInvoke;
        Snapshot current;
        boolean z;
        do {
            synchronized (SnapshotStateListKt.sync) {
                try {
                    StateRecord firstStateRecord = getFirstStateRecord();
                    Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                    StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) firstStateRecord);
                    modification$runtime_release = stateListStateRecord.getModification$runtime_release();
                    list$runtime_release = stateListStateRecord.getList$runtime_release();
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                } catch (Throwable th) {
                    InlineMarker.finallyStart(1);
                    InlineMarker.finallyEnd(1);
                    throw th;
                }
            }
            InlineMarker.finallyEnd(1);
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList.Builder<T> builder = list$runtime_release.builder();
            rInvoke = function1.invoke(builder);
            PersistentList<T> persistentListBuild = builder.build();
            if (Intrinsics.areEqual(persistentListBuild, list$runtime_release)) {
                break;
            }
            StateRecord firstStateRecord2 = getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            StateListStateRecord stateListStateRecord2 = (StateListStateRecord) firstStateRecord2;
            SnapshotKt.getSnapshotInitializer();
            synchronized (SnapshotKt.getLock()) {
                try {
                    current = Snapshot.Companion.getCurrent();
                    StateListStateRecord stateListStateRecord3 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord2, this, current);
                    synchronized (SnapshotStateListKt.sync) {
                        try {
                            if (stateListStateRecord3.getModification$runtime_release() == modification$runtime_release) {
                                stateListStateRecord3.setList$runtime_release(persistentListBuild);
                                stateListStateRecord3.setModification$runtime_release(stateListStateRecord3.getModification$runtime_release() + 1);
                                stateListStateRecord3.setStructuralChange$runtime_release(stateListStateRecord3.getStructuralChange$runtime_release() + 1);
                                z = true;
                            } else {
                                z = false;
                            }
                            InlineMarker.finallyStart(1);
                        } catch (Throwable th2) {
                            InlineMarker.finallyStart(1);
                            InlineMarker.finallyEnd(1);
                            throw th2;
                        }
                    }
                    InlineMarker.finallyEnd(1);
                    InlineMarker.finallyStart(1);
                } catch (Throwable th3) {
                    InlineMarker.finallyStart(1);
                    InlineMarker.finallyEnd(1);
                    throw th3;
                }
            }
            InlineMarker.finallyEnd(1);
            SnapshotKt.notifyWrite(current, this);
        } while (!z);
        return rInvoke;
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0097 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean conditionalUpdate(boolean r10, kotlin.jvm.functions.Function1<? super androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList<? extends T>, ? extends androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList<? extends T>> r11) {
        /*
            r9 = this;
        L0:
            java.lang.Object r0 = androidx.compose.runtime.snapshots.SnapshotStateListKt.access$getSync$p()
            monitor-enter(r0)
            r1 = 1
            androidx.compose.runtime.snapshots.StateRecord r2 = r9.getFirstStateRecord()     // Catch: java.lang.Throwable -> La0
            java.lang.String r3 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2, r3)     // Catch: java.lang.Throwable -> La0
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r2 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r2     // Catch: java.lang.Throwable -> La0
            androidx.compose.runtime.snapshots.StateRecord r2 = androidx.compose.runtime.snapshots.SnapshotKt.current(r2)     // Catch: java.lang.Throwable -> La0
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r2 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r2     // Catch: java.lang.Throwable -> La0
            int r3 = r2.getModification$runtime_release()     // Catch: java.lang.Throwable -> La0
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r2 = r2.getList$runtime_release()     // Catch: java.lang.Throwable -> La0
            kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> La0
            kotlin.jvm.internal.InlineMarker.finallyStart(r1)
            monitor-exit(r0)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r1)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            java.lang.Object r0 = r11.invoke(r2)
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r0 = (androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList) r0
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r2)
            r4 = 0
            if (r2 == 0) goto L3a
            r1 = r4
            goto L8d
        L3a:
            androidx.compose.runtime.snapshots.StateRecord r2 = r9.getFirstStateRecord()
            java.lang.String r5 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2, r5)
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r2 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r2
            androidx.compose.runtime.snapshots.SnapshotKt.getSnapshotInitializer()
            java.lang.Object r5 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()
            monitor-enter(r5)
            androidx.compose.runtime.snapshots.Snapshot$Companion r6 = androidx.compose.runtime.snapshots.Snapshot.Companion     // Catch: java.lang.Throwable -> L97
            androidx.compose.runtime.snapshots.Snapshot r6 = r6.getCurrent()     // Catch: java.lang.Throwable -> L97
            androidx.compose.runtime.snapshots.StateRecord r2 = androidx.compose.runtime.snapshots.SnapshotKt.writableRecord(r2, r9, r6)     // Catch: java.lang.Throwable -> L97
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r2 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r2     // Catch: java.lang.Throwable -> L97
            java.lang.Object r7 = androidx.compose.runtime.snapshots.SnapshotStateListKt.access$getSync$p()     // Catch: java.lang.Throwable -> L97
            monitor-enter(r7)     // Catch: java.lang.Throwable -> L97
            int r8 = r2.getModification$runtime_release()     // Catch: java.lang.Throwable -> L8e
            if (r8 != r3) goto L7a
            r2.setList$runtime_release(r0)     // Catch: java.lang.Throwable -> L8e
            if (r10 == 0) goto L71
            int r0 = r2.getStructuralChange$runtime_release()     // Catch: java.lang.Throwable -> L8e
            int r0 = r0 + r1
            r2.setStructuralChange$runtime_release(r0)     // Catch: java.lang.Throwable -> L8e
        L71:
            int r0 = r2.getModification$runtime_release()     // Catch: java.lang.Throwable -> L8e
            int r0 = r0 + r1
            r2.setModification$runtime_release(r0)     // Catch: java.lang.Throwable -> L8e
            r4 = r1
        L7a:
            kotlin.jvm.internal.InlineMarker.finallyStart(r1)     // Catch: java.lang.Throwable -> L97
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L97
            kotlin.jvm.internal.InlineMarker.finallyEnd(r1)     // Catch: java.lang.Throwable -> L97
            kotlin.jvm.internal.InlineMarker.finallyStart(r1)
            monitor-exit(r5)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r1)
            androidx.compose.runtime.snapshots.SnapshotKt.notifyWrite(r6, r9)
            if (r4 == 0) goto L0
        L8d:
            return r1
        L8e:
            r10 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r1)     // Catch: java.lang.Throwable -> L97
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L97
            kotlin.jvm.internal.InlineMarker.finallyEnd(r1)     // Catch: java.lang.Throwable -> L97
            throw r10     // Catch: java.lang.Throwable -> L97
        L97:
            r10 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r1)
            monitor-exit(r5)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r1)
            throw r10
        La0:
            r10 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r1)
            monitor-exit(r0)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r1)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotStateList.conditionalUpdate(boolean, kotlin.jvm.functions.Function1):boolean");
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x009b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ boolean conditionalUpdate$default(androidx.compose.runtime.snapshots.SnapshotStateList r7, boolean r8, kotlin.jvm.functions.Function1 r9, int r10, java.lang.Object r11) {
        /*
            r11 = 1
            r10 = r10 & r11
            if (r10 == 0) goto L5
            r8 = r11
        L5:
            java.lang.Object r10 = androidx.compose.runtime.snapshots.SnapshotStateListKt.access$getSync$p()
            monitor-enter(r10)
            androidx.compose.runtime.snapshots.StateRecord r0 = r7.getFirstStateRecord()     // Catch: java.lang.Throwable -> La4
            java.lang.String r1 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r1)     // Catch: java.lang.Throwable -> La4
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r0 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r0     // Catch: java.lang.Throwable -> La4
            androidx.compose.runtime.snapshots.StateRecord r0 = androidx.compose.runtime.snapshots.SnapshotKt.current(r0)     // Catch: java.lang.Throwable -> La4
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r0 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r0     // Catch: java.lang.Throwable -> La4
            int r1 = r0.getModification$runtime_release()     // Catch: java.lang.Throwable -> La4
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r0 = r0.getList$runtime_release()     // Catch: java.lang.Throwable -> La4
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> La4
            kotlin.jvm.internal.InlineMarker.finallyStart(r11)
            monitor-exit(r10)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r11)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            java.lang.Object r10 = r9.invoke(r0)
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r10 = (androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList) r10
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r10, r0)
            r2 = 0
            if (r0 == 0) goto L3e
            r11 = r2
            goto L91
        L3e:
            androidx.compose.runtime.snapshots.StateRecord r0 = r7.getFirstStateRecord()
            java.lang.String r3 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r3)
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r0 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r0
            androidx.compose.runtime.snapshots.SnapshotKt.getSnapshotInitializer()
            java.lang.Object r3 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()
            monitor-enter(r3)
            androidx.compose.runtime.snapshots.Snapshot$Companion r4 = androidx.compose.runtime.snapshots.Snapshot.Companion     // Catch: java.lang.Throwable -> L9b
            androidx.compose.runtime.snapshots.Snapshot r4 = r4.getCurrent()     // Catch: java.lang.Throwable -> L9b
            androidx.compose.runtime.snapshots.StateRecord r0 = androidx.compose.runtime.snapshots.SnapshotKt.writableRecord(r0, r7, r4)     // Catch: java.lang.Throwable -> L9b
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r0 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r0     // Catch: java.lang.Throwable -> L9b
            java.lang.Object r5 = androidx.compose.runtime.snapshots.SnapshotStateListKt.access$getSync$p()     // Catch: java.lang.Throwable -> L9b
            monitor-enter(r5)     // Catch: java.lang.Throwable -> L9b
            int r6 = r0.getModification$runtime_release()     // Catch: java.lang.Throwable -> L92
            if (r6 != r1) goto L7e
            r0.setList$runtime_release(r10)     // Catch: java.lang.Throwable -> L92
            if (r8 == 0) goto L75
            int r10 = r0.getStructuralChange$runtime_release()     // Catch: java.lang.Throwable -> L92
            int r10 = r10 + r11
            r0.setStructuralChange$runtime_release(r10)     // Catch: java.lang.Throwable -> L92
        L75:
            int r10 = r0.getModification$runtime_release()     // Catch: java.lang.Throwable -> L92
            int r10 = r10 + r11
            r0.setModification$runtime_release(r10)     // Catch: java.lang.Throwable -> L92
            r2 = r11
        L7e:
            kotlin.jvm.internal.InlineMarker.finallyStart(r11)     // Catch: java.lang.Throwable -> L9b
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L9b
            kotlin.jvm.internal.InlineMarker.finallyEnd(r11)     // Catch: java.lang.Throwable -> L9b
            kotlin.jvm.internal.InlineMarker.finallyStart(r11)
            monitor-exit(r3)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r11)
            androidx.compose.runtime.snapshots.SnapshotKt.notifyWrite(r4, r7)
            if (r2 == 0) goto L5
        L91:
            return r11
        L92:
            r7 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r11)     // Catch: java.lang.Throwable -> L9b
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L9b
            kotlin.jvm.internal.InlineMarker.finallyEnd(r11)     // Catch: java.lang.Throwable -> L9b
            throw r7     // Catch: java.lang.Throwable -> L9b
        L9b:
            r7 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r11)
            monitor-exit(r3)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r11)
            throw r7
        La4:
            r7 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r11)
            monitor-exit(r10)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r11)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotStateList.conditionalUpdate$default(androidx.compose.runtime.snapshots.SnapshotStateList, boolean, kotlin.jvm.functions.Function1, int, java.lang.Object):boolean");
    }

    public final int getStructure$runtime_release() {
        StateRecord firstStateRecord = getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        return ((StateListStateRecord) SnapshotKt.current((StateListStateRecord) firstStateRecord)).getStructuralChange$runtime_release();
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x007b */
    @Override // java.util.List, java.util.Collection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean add(T r10) {
        /*
            r9 = this;
        L0:
            java.lang.Object r0 = androidx.compose.runtime.snapshots.SnapshotStateListKt.access$getSync$p()
            monitor-enter(r0)
            androidx.compose.runtime.snapshots.StateRecord r1 = r9.getFirstStateRecord()     // Catch: java.lang.Throwable -> L7e
            java.lang.String r2 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1, r2)     // Catch: java.lang.Throwable -> L7e
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r1 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r1     // Catch: java.lang.Throwable -> L7e
            androidx.compose.runtime.snapshots.StateRecord r1 = androidx.compose.runtime.snapshots.SnapshotKt.current(r1)     // Catch: java.lang.Throwable -> L7e
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r1 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r1     // Catch: java.lang.Throwable -> L7e
            int r2 = r1.getModification$runtime_release()     // Catch: java.lang.Throwable -> L7e
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r1 = r1.getList$runtime_release()     // Catch: java.lang.Throwable -> L7e
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L7e
            monitor-exit(r0)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r0 = r1.add(r10)
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            r3 = 0
            if (r1 == 0) goto L30
            goto L77
        L30:
            androidx.compose.runtime.snapshots.StateRecord r1 = r9.getFirstStateRecord()
            java.lang.String r4 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1, r4)
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r1 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r1
            androidx.compose.runtime.snapshots.SnapshotKt.getSnapshotInitializer()
            java.lang.Object r4 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()
            monitor-enter(r4)
            androidx.compose.runtime.snapshots.Snapshot$Companion r5 = androidx.compose.runtime.snapshots.Snapshot.Companion     // Catch: java.lang.Throwable -> L7b
            androidx.compose.runtime.snapshots.Snapshot r5 = r5.getCurrent()     // Catch: java.lang.Throwable -> L7b
            androidx.compose.runtime.snapshots.StateRecord r1 = androidx.compose.runtime.snapshots.SnapshotKt.writableRecord(r1, r9, r5)     // Catch: java.lang.Throwable -> L7b
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r1 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r1     // Catch: java.lang.Throwable -> L7b
            java.lang.Object r6 = androidx.compose.runtime.snapshots.SnapshotStateListKt.access$getSync$p()     // Catch: java.lang.Throwable -> L7b
            monitor-enter(r6)     // Catch: java.lang.Throwable -> L7b
            int r7 = r1.getModification$runtime_release()     // Catch: java.lang.Throwable -> L78
            r8 = 1
            if (r7 != r2) goto L6f
            r1.setList$runtime_release(r0)     // Catch: java.lang.Throwable -> L78
            int r0 = r1.getStructuralChange$runtime_release()     // Catch: java.lang.Throwable -> L78
            int r0 = r0 + r8
            r1.setStructuralChange$runtime_release(r0)     // Catch: java.lang.Throwable -> L78
            int r0 = r1.getModification$runtime_release()     // Catch: java.lang.Throwable -> L78
            int r0 = r0 + r8
            r1.setModification$runtime_release(r0)     // Catch: java.lang.Throwable -> L78
            r3 = r8
        L6f:
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L7b
            monitor-exit(r4)
            androidx.compose.runtime.snapshots.SnapshotKt.notifyWrite(r5, r9)
            if (r3 == 0) goto L0
            r3 = r8
        L77:
            return r3
        L78:
            r10 = move-exception
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L7b
            throw r10     // Catch: java.lang.Throwable -> L7b
        L7b:
            r10 = move-exception
            monitor-exit(r4)
            throw r10
        L7e:
            r10 = move-exception
            monitor-exit(r0)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotStateList.add(java.lang.Object):boolean");
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x007a */
    @Override // java.util.List
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void add(int r8, T r9) {
        /*
            r7 = this;
        L0:
            java.lang.Object r0 = androidx.compose.runtime.snapshots.SnapshotStateListKt.access$getSync$p()
            monitor-enter(r0)
            androidx.compose.runtime.snapshots.StateRecord r1 = r7.getFirstStateRecord()     // Catch: java.lang.Throwable -> L7d
            java.lang.String r2 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1, r2)     // Catch: java.lang.Throwable -> L7d
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r1 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r1     // Catch: java.lang.Throwable -> L7d
            androidx.compose.runtime.snapshots.StateRecord r1 = androidx.compose.runtime.snapshots.SnapshotKt.current(r1)     // Catch: java.lang.Throwable -> L7d
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r1 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r1     // Catch: java.lang.Throwable -> L7d
            int r2 = r1.getModification$runtime_release()     // Catch: java.lang.Throwable -> L7d
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r1 = r1.getList$runtime_release()     // Catch: java.lang.Throwable -> L7d
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L7d
            monitor-exit(r0)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r0 = r1.add(r8, r9)
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r1 == 0) goto L2f
            goto L76
        L2f:
            androidx.compose.runtime.snapshots.StateRecord r1 = r7.getFirstStateRecord()
            java.lang.String r3 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1, r3)
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r1 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r1
            androidx.compose.runtime.snapshots.SnapshotKt.getSnapshotInitializer()
            java.lang.Object r3 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()
            monitor-enter(r3)
            androidx.compose.runtime.snapshots.Snapshot$Companion r4 = androidx.compose.runtime.snapshots.Snapshot.Companion     // Catch: java.lang.Throwable -> L7a
            androidx.compose.runtime.snapshots.Snapshot r4 = r4.getCurrent()     // Catch: java.lang.Throwable -> L7a
            androidx.compose.runtime.snapshots.StateRecord r1 = androidx.compose.runtime.snapshots.SnapshotKt.writableRecord(r1, r7, r4)     // Catch: java.lang.Throwable -> L7a
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r1 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r1     // Catch: java.lang.Throwable -> L7a
            java.lang.Object r5 = androidx.compose.runtime.snapshots.SnapshotStateListKt.access$getSync$p()     // Catch: java.lang.Throwable -> L7a
            monitor-enter(r5)     // Catch: java.lang.Throwable -> L7a
            int r6 = r1.getModification$runtime_release()     // Catch: java.lang.Throwable -> L77
            if (r6 != r2) goto L6e
            r1.setList$runtime_release(r0)     // Catch: java.lang.Throwable -> L77
            int r0 = r1.getStructuralChange$runtime_release()     // Catch: java.lang.Throwable -> L77
            r2 = 1
            int r0 = r0 + r2
            r1.setStructuralChange$runtime_release(r0)     // Catch: java.lang.Throwable -> L77
            int r0 = r1.getModification$runtime_release()     // Catch: java.lang.Throwable -> L77
            int r0 = r0 + r2
            r1.setModification$runtime_release(r0)     // Catch: java.lang.Throwable -> L77
            goto L6f
        L6e:
            r2 = 0
        L6f:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L7a
            monitor-exit(r3)
            androidx.compose.runtime.snapshots.SnapshotKt.notifyWrite(r4, r7)
            if (r2 == 0) goto L0
        L76:
            return
        L77:
            r8 = move-exception
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L7a
            throw r8     // Catch: java.lang.Throwable -> L7a
        L7a:
            r8 = move-exception
            monitor-exit(r3)
            throw r8
        L7d:
            r8 = move-exception
            monitor-exit(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotStateList.add(int, java.lang.Object):void");
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x007b */
    @Override // java.util.List, java.util.Collection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean addAll(@org.jetbrains.annotations.NotNull java.util.Collection<? extends T> r10) {
        /*
            r9 = this;
        L0:
            java.lang.Object r0 = androidx.compose.runtime.snapshots.SnapshotStateListKt.access$getSync$p()
            monitor-enter(r0)
            androidx.compose.runtime.snapshots.StateRecord r1 = r9.getFirstStateRecord()     // Catch: java.lang.Throwable -> L7e
            java.lang.String r2 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1, r2)     // Catch: java.lang.Throwable -> L7e
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r1 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r1     // Catch: java.lang.Throwable -> L7e
            androidx.compose.runtime.snapshots.StateRecord r1 = androidx.compose.runtime.snapshots.SnapshotKt.current(r1)     // Catch: java.lang.Throwable -> L7e
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r1 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r1     // Catch: java.lang.Throwable -> L7e
            int r2 = r1.getModification$runtime_release()     // Catch: java.lang.Throwable -> L7e
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r1 = r1.getList$runtime_release()     // Catch: java.lang.Throwable -> L7e
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L7e
            monitor-exit(r0)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r0 = r1.addAll(r10)
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            r3 = 0
            if (r1 == 0) goto L30
            goto L77
        L30:
            androidx.compose.runtime.snapshots.StateRecord r1 = r9.getFirstStateRecord()
            java.lang.String r4 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1, r4)
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r1 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r1
            androidx.compose.runtime.snapshots.SnapshotKt.getSnapshotInitializer()
            java.lang.Object r4 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()
            monitor-enter(r4)
            androidx.compose.runtime.snapshots.Snapshot$Companion r5 = androidx.compose.runtime.snapshots.Snapshot.Companion     // Catch: java.lang.Throwable -> L7b
            androidx.compose.runtime.snapshots.Snapshot r5 = r5.getCurrent()     // Catch: java.lang.Throwable -> L7b
            androidx.compose.runtime.snapshots.StateRecord r1 = androidx.compose.runtime.snapshots.SnapshotKt.writableRecord(r1, r9, r5)     // Catch: java.lang.Throwable -> L7b
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r1 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r1     // Catch: java.lang.Throwable -> L7b
            java.lang.Object r6 = androidx.compose.runtime.snapshots.SnapshotStateListKt.access$getSync$p()     // Catch: java.lang.Throwable -> L7b
            monitor-enter(r6)     // Catch: java.lang.Throwable -> L7b
            int r7 = r1.getModification$runtime_release()     // Catch: java.lang.Throwable -> L78
            r8 = 1
            if (r7 != r2) goto L6f
            r1.setList$runtime_release(r0)     // Catch: java.lang.Throwable -> L78
            int r0 = r1.getStructuralChange$runtime_release()     // Catch: java.lang.Throwable -> L78
            int r0 = r0 + r8
            r1.setStructuralChange$runtime_release(r0)     // Catch: java.lang.Throwable -> L78
            int r0 = r1.getModification$runtime_release()     // Catch: java.lang.Throwable -> L78
            int r0 = r0 + r8
            r1.setModification$runtime_release(r0)     // Catch: java.lang.Throwable -> L78
            r3 = r8
        L6f:
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L7b
            monitor-exit(r4)
            androidx.compose.runtime.snapshots.SnapshotKt.notifyWrite(r5, r9)
            if (r3 == 0) goto L0
            r3 = r8
        L77:
            return r3
        L78:
            r10 = move-exception
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L7b
            throw r10     // Catch: java.lang.Throwable -> L7b
        L7b:
            r10 = move-exception
            monitor-exit(r4)
            throw r10
        L7e:
            r10 = move-exception
            monitor-exit(r0)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotStateList.addAll(java.util.Collection):boolean");
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        Snapshot current;
        StateRecord firstStateRecord = getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        StateListStateRecord stateListStateRecord = (StateListStateRecord) firstStateRecord;
        SnapshotKt.getSnapshotInitializer();
        synchronized (SnapshotKt.getLock()) {
            current = Snapshot.Companion.getCurrent();
            StateListStateRecord stateListStateRecord2 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord, this, current);
            synchronized (SnapshotStateListKt.sync) {
                stateListStateRecord2.setList$runtime_release(ExtensionsKt.persistentListOf());
                stateListStateRecord2.setModification$runtime_release(stateListStateRecord2.getModification$runtime_release() + 1);
                stateListStateRecord2.setStructuralChange$runtime_release(stateListStateRecord2.getStructuralChange$runtime_release() + 1);
            }
        }
        SnapshotKt.notifyWrite(current, this);
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x007b */
    @Override // java.util.List, java.util.Collection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean remove(java.lang.Object r10) {
        /*
            r9 = this;
        L0:
            java.lang.Object r0 = androidx.compose.runtime.snapshots.SnapshotStateListKt.access$getSync$p()
            monitor-enter(r0)
            androidx.compose.runtime.snapshots.StateRecord r1 = r9.getFirstStateRecord()     // Catch: java.lang.Throwable -> L7e
            java.lang.String r2 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1, r2)     // Catch: java.lang.Throwable -> L7e
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r1 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r1     // Catch: java.lang.Throwable -> L7e
            androidx.compose.runtime.snapshots.StateRecord r1 = androidx.compose.runtime.snapshots.SnapshotKt.current(r1)     // Catch: java.lang.Throwable -> L7e
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r1 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r1     // Catch: java.lang.Throwable -> L7e
            int r2 = r1.getModification$runtime_release()     // Catch: java.lang.Throwable -> L7e
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r1 = r1.getList$runtime_release()     // Catch: java.lang.Throwable -> L7e
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L7e
            monitor-exit(r0)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r0 = r1.remove(r10)
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            r3 = 0
            if (r1 == 0) goto L30
            goto L77
        L30:
            androidx.compose.runtime.snapshots.StateRecord r1 = r9.getFirstStateRecord()
            java.lang.String r4 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1, r4)
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r1 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r1
            androidx.compose.runtime.snapshots.SnapshotKt.getSnapshotInitializer()
            java.lang.Object r4 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()
            monitor-enter(r4)
            androidx.compose.runtime.snapshots.Snapshot$Companion r5 = androidx.compose.runtime.snapshots.Snapshot.Companion     // Catch: java.lang.Throwable -> L7b
            androidx.compose.runtime.snapshots.Snapshot r5 = r5.getCurrent()     // Catch: java.lang.Throwable -> L7b
            androidx.compose.runtime.snapshots.StateRecord r1 = androidx.compose.runtime.snapshots.SnapshotKt.writableRecord(r1, r9, r5)     // Catch: java.lang.Throwable -> L7b
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r1 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r1     // Catch: java.lang.Throwable -> L7b
            java.lang.Object r6 = androidx.compose.runtime.snapshots.SnapshotStateListKt.access$getSync$p()     // Catch: java.lang.Throwable -> L7b
            monitor-enter(r6)     // Catch: java.lang.Throwable -> L7b
            int r7 = r1.getModification$runtime_release()     // Catch: java.lang.Throwable -> L78
            r8 = 1
            if (r7 != r2) goto L6f
            r1.setList$runtime_release(r0)     // Catch: java.lang.Throwable -> L78
            int r0 = r1.getStructuralChange$runtime_release()     // Catch: java.lang.Throwable -> L78
            int r0 = r0 + r8
            r1.setStructuralChange$runtime_release(r0)     // Catch: java.lang.Throwable -> L78
            int r0 = r1.getModification$runtime_release()     // Catch: java.lang.Throwable -> L78
            int r0 = r0 + r8
            r1.setModification$runtime_release(r0)     // Catch: java.lang.Throwable -> L78
            r3 = r8
        L6f:
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L7b
            monitor-exit(r4)
            androidx.compose.runtime.snapshots.SnapshotKt.notifyWrite(r5, r9)
            if (r3 == 0) goto L0
            r3 = r8
        L77:
            return r3
        L78:
            r10 = move-exception
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L7b
            throw r10     // Catch: java.lang.Throwable -> L7b
        L7b:
            r10 = move-exception
            monitor-exit(r4)
            throw r10
        L7e:
            r10 = move-exception
            monitor-exit(r0)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotStateList.remove(java.lang.Object):boolean");
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x007b */
    @Override // java.util.List, java.util.Collection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean removeAll(@org.jetbrains.annotations.NotNull java.util.Collection<? extends java.lang.Object> r10) {
        /*
            r9 = this;
        L0:
            java.lang.Object r0 = androidx.compose.runtime.snapshots.SnapshotStateListKt.access$getSync$p()
            monitor-enter(r0)
            androidx.compose.runtime.snapshots.StateRecord r1 = r9.getFirstStateRecord()     // Catch: java.lang.Throwable -> L7e
            java.lang.String r2 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1, r2)     // Catch: java.lang.Throwable -> L7e
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r1 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r1     // Catch: java.lang.Throwable -> L7e
            androidx.compose.runtime.snapshots.StateRecord r1 = androidx.compose.runtime.snapshots.SnapshotKt.current(r1)     // Catch: java.lang.Throwable -> L7e
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r1 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r1     // Catch: java.lang.Throwable -> L7e
            int r2 = r1.getModification$runtime_release()     // Catch: java.lang.Throwable -> L7e
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r1 = r1.getList$runtime_release()     // Catch: java.lang.Throwable -> L7e
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L7e
            monitor-exit(r0)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r0 = r1.removeAll(r10)
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            r3 = 0
            if (r1 == 0) goto L30
            goto L77
        L30:
            androidx.compose.runtime.snapshots.StateRecord r1 = r9.getFirstStateRecord()
            java.lang.String r4 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1, r4)
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r1 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r1
            androidx.compose.runtime.snapshots.SnapshotKt.getSnapshotInitializer()
            java.lang.Object r4 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()
            monitor-enter(r4)
            androidx.compose.runtime.snapshots.Snapshot$Companion r5 = androidx.compose.runtime.snapshots.Snapshot.Companion     // Catch: java.lang.Throwable -> L7b
            androidx.compose.runtime.snapshots.Snapshot r5 = r5.getCurrent()     // Catch: java.lang.Throwable -> L7b
            androidx.compose.runtime.snapshots.StateRecord r1 = androidx.compose.runtime.snapshots.SnapshotKt.writableRecord(r1, r9, r5)     // Catch: java.lang.Throwable -> L7b
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r1 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r1     // Catch: java.lang.Throwable -> L7b
            java.lang.Object r6 = androidx.compose.runtime.snapshots.SnapshotStateListKt.access$getSync$p()     // Catch: java.lang.Throwable -> L7b
            monitor-enter(r6)     // Catch: java.lang.Throwable -> L7b
            int r7 = r1.getModification$runtime_release()     // Catch: java.lang.Throwable -> L78
            r8 = 1
            if (r7 != r2) goto L6f
            r1.setList$runtime_release(r0)     // Catch: java.lang.Throwable -> L78
            int r0 = r1.getStructuralChange$runtime_release()     // Catch: java.lang.Throwable -> L78
            int r0 = r0 + r8
            r1.setStructuralChange$runtime_release(r0)     // Catch: java.lang.Throwable -> L78
            int r0 = r1.getModification$runtime_release()     // Catch: java.lang.Throwable -> L78
            int r0 = r0 + r8
            r1.setModification$runtime_release(r0)     // Catch: java.lang.Throwable -> L78
            r3 = r8
        L6f:
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L7b
            monitor-exit(r4)
            androidx.compose.runtime.snapshots.SnapshotKt.notifyWrite(r5, r9)
            if (r3 == 0) goto L0
            r3 = r8
        L77:
            return r3
        L78:
            r10 = move-exception
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L7b
            throw r10     // Catch: java.lang.Throwable -> L7b
        L7b:
            r10 = move-exception
            monitor-exit(r4)
            throw r10
        L7e:
            r10 = move-exception
            monitor-exit(r0)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotStateList.removeAll(java.util.Collection):boolean");
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0084 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void removeRange(int r8, int r9) {
        /*
            r7 = this;
        L0:
            java.lang.Object r0 = androidx.compose.runtime.snapshots.SnapshotStateListKt.access$getSync$p()
            monitor-enter(r0)
            androidx.compose.runtime.snapshots.StateRecord r1 = r7.getFirstStateRecord()     // Catch: java.lang.Throwable -> L88
            java.lang.String r2 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1, r2)     // Catch: java.lang.Throwable -> L88
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r1 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r1     // Catch: java.lang.Throwable -> L88
            androidx.compose.runtime.snapshots.StateRecord r1 = androidx.compose.runtime.snapshots.SnapshotKt.current(r1)     // Catch: java.lang.Throwable -> L88
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r1 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r1     // Catch: java.lang.Throwable -> L88
            int r2 = r1.getModification$runtime_release()     // Catch: java.lang.Throwable -> L88
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r1 = r1.getList$runtime_release()     // Catch: java.lang.Throwable -> L88
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L88
            monitor-exit(r0)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList$Builder r0 = r1.builder()
            java.util.List r3 = r0.subList(r8, r9)
            r3.clear()
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r0 = r0.build()
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r1 != 0) goto L87
            androidx.compose.runtime.snapshots.StateRecord r1 = r7.getFirstStateRecord()
            java.lang.String r3 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1, r3)
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r1 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r1
            androidx.compose.runtime.snapshots.SnapshotKt.getSnapshotInitializer()
            java.lang.Object r3 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()
            monitor-enter(r3)
            androidx.compose.runtime.snapshots.Snapshot$Companion r4 = androidx.compose.runtime.snapshots.Snapshot.Companion     // Catch: java.lang.Throwable -> L84
            androidx.compose.runtime.snapshots.Snapshot r4 = r4.getCurrent()     // Catch: java.lang.Throwable -> L84
            androidx.compose.runtime.snapshots.StateRecord r1 = androidx.compose.runtime.snapshots.SnapshotKt.writableRecord(r1, r7, r4)     // Catch: java.lang.Throwable -> L84
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r1 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r1     // Catch: java.lang.Throwable -> L84
            java.lang.Object r5 = androidx.compose.runtime.snapshots.SnapshotStateListKt.access$getSync$p()     // Catch: java.lang.Throwable -> L84
            monitor-enter(r5)     // Catch: java.lang.Throwable -> L84
            int r6 = r1.getModification$runtime_release()     // Catch: java.lang.Throwable -> L81
            if (r6 != r2) goto L78
            r1.setList$runtime_release(r0)     // Catch: java.lang.Throwable -> L81
            int r0 = r1.getModification$runtime_release()     // Catch: java.lang.Throwable -> L81
            r2 = 1
            int r0 = r0 + r2
            r1.setModification$runtime_release(r0)     // Catch: java.lang.Throwable -> L81
            int r0 = r1.getStructuralChange$runtime_release()     // Catch: java.lang.Throwable -> L81
            int r0 = r0 + r2
            r1.setStructuralChange$runtime_release(r0)     // Catch: java.lang.Throwable -> L81
            goto L79
        L78:
            r2 = 0
        L79:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L84
            monitor-exit(r3)
            androidx.compose.runtime.snapshots.SnapshotKt.notifyWrite(r4, r7)
            if (r2 == 0) goto L0
            goto L87
        L81:
            r8 = move-exception
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L84
            throw r8     // Catch: java.lang.Throwable -> L84
        L84:
            r8 = move-exception
            monitor-exit(r3)
            throw r8
        L87:
            return
        L88:
            r8 = move-exception
            monitor-exit(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotStateList.removeRange(int, int):void");
    }

    public final List<T> getDebuggerDisplayValue() {
        StateRecord firstStateRecord = getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        return ((StateListStateRecord) SnapshotKt.current((StateListStateRecord) firstStateRecord)).getList$runtime_release();
    }

    private final boolean mutateBoolean(Function1<? super List<T>, Boolean> function1) {
        int modification$runtime_release;
        PersistentList<T> list$runtime_release;
        Boolean boolInvoke;
        Snapshot current;
        boolean z;
        do {
            synchronized (SnapshotStateListKt.sync) {
                StateRecord firstStateRecord = getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) firstStateRecord);
                modification$runtime_release = stateListStateRecord.getModification$runtime_release();
                list$runtime_release = stateListStateRecord.getList$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList.Builder<T> builder = list$runtime_release.builder();
            boolInvoke = function1.invoke(builder);
            PersistentList<T> persistentListBuild = builder.build();
            if (Intrinsics.areEqual(persistentListBuild, list$runtime_release)) {
                break;
            }
            StateRecord firstStateRecord2 = getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            StateListStateRecord stateListStateRecord2 = (StateListStateRecord) firstStateRecord2;
            SnapshotKt.getSnapshotInitializer();
            synchronized (SnapshotKt.getLock()) {
                current = Snapshot.Companion.getCurrent();
                StateListStateRecord stateListStateRecord3 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord2, this, current);
                synchronized (SnapshotStateListKt.sync) {
                    if (stateListStateRecord3.getModification$runtime_release() == modification$runtime_release) {
                        stateListStateRecord3.setList$runtime_release(persistentListBuild);
                        z = true;
                        stateListStateRecord3.setModification$runtime_release(stateListStateRecord3.getModification$runtime_release() + 1);
                        stateListStateRecord3.setStructuralChange$runtime_release(stateListStateRecord3.getStructuralChange$runtime_release() + 1);
                    } else {
                        z = false;
                    }
                }
            }
            SnapshotKt.notifyWrite(current, this);
        } while (!z);
        return boolInvoke.booleanValue();
    }

    private final void update(boolean z, Function1<? super PersistentList<? extends T>, ? extends PersistentList<? extends T>> function1) {
        int modification$runtime_release;
        PersistentList<T> list$runtime_release;
        Snapshot current;
        boolean z2;
        do {
            synchronized (SnapshotStateListKt.sync) {
                try {
                    StateRecord firstStateRecord = getFirstStateRecord();
                    Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                    StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) firstStateRecord);
                    modification$runtime_release = stateListStateRecord.getModification$runtime_release();
                    list$runtime_release = stateListStateRecord.getList$runtime_release();
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                } catch (Throwable th) {
                    InlineMarker.finallyStart(1);
                    InlineMarker.finallyEnd(1);
                    throw th;
                }
            }
            InlineMarker.finallyEnd(1);
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList<? extends T> persistentListInvoke = function1.invoke(list$runtime_release);
            if (Intrinsics.areEqual(persistentListInvoke, list$runtime_release)) {
                return;
            }
            StateRecord firstStateRecord2 = getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            StateListStateRecord stateListStateRecord2 = (StateListStateRecord) firstStateRecord2;
            SnapshotKt.getSnapshotInitializer();
            synchronized (SnapshotKt.getLock()) {
                try {
                    current = Snapshot.Companion.getCurrent();
                    StateListStateRecord stateListStateRecord3 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord2, this, current);
                    synchronized (SnapshotStateListKt.sync) {
                        try {
                            if (stateListStateRecord3.getModification$runtime_release() == modification$runtime_release) {
                                stateListStateRecord3.setList$runtime_release(persistentListInvoke);
                                if (z) {
                                    stateListStateRecord3.setStructuralChange$runtime_release(stateListStateRecord3.getStructuralChange$runtime_release() + 1);
                                }
                                stateListStateRecord3.setModification$runtime_release(stateListStateRecord3.getModification$runtime_release() + 1);
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            InlineMarker.finallyStart(1);
                        } catch (Throwable th2) {
                            InlineMarker.finallyStart(1);
                            InlineMarker.finallyEnd(1);
                            throw th2;
                        }
                    }
                    InlineMarker.finallyEnd(1);
                    InlineMarker.finallyStart(1);
                } catch (Throwable th3) {
                    InlineMarker.finallyStart(1);
                    InlineMarker.finallyEnd(1);
                    throw th3;
                }
            }
            InlineMarker.finallyEnd(1);
            SnapshotKt.notifyWrite(current, this);
        } while (!z2);
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x009b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ void update$default(androidx.compose.runtime.snapshots.SnapshotStateList r6, boolean r7, kotlin.jvm.functions.Function1 r8, int r9, java.lang.Object r10) {
        /*
            r10 = 1
            r9 = r9 & r10
            if (r9 == 0) goto L5
            r7 = r10
        L5:
            java.lang.Object r9 = androidx.compose.runtime.snapshots.SnapshotStateListKt.access$getSync$p()
            monitor-enter(r9)
            androidx.compose.runtime.snapshots.StateRecord r0 = r6.getFirstStateRecord()     // Catch: java.lang.Throwable -> La4
            java.lang.String r1 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r1)     // Catch: java.lang.Throwable -> La4
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r0 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r0     // Catch: java.lang.Throwable -> La4
            androidx.compose.runtime.snapshots.StateRecord r0 = androidx.compose.runtime.snapshots.SnapshotKt.current(r0)     // Catch: java.lang.Throwable -> La4
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r0 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r0     // Catch: java.lang.Throwable -> La4
            int r1 = r0.getModification$runtime_release()     // Catch: java.lang.Throwable -> La4
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r0 = r0.getList$runtime_release()     // Catch: java.lang.Throwable -> La4
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> La4
            kotlin.jvm.internal.InlineMarker.finallyStart(r10)
            monitor-exit(r9)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r10)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            java.lang.Object r9 = r8.invoke(r0)
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r9 = (androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList) r9
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r9, r0)
            if (r0 == 0) goto L3c
            goto L91
        L3c:
            androidx.compose.runtime.snapshots.StateRecord r0 = r6.getFirstStateRecord()
            java.lang.String r2 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r2)
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r0 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r0
            androidx.compose.runtime.snapshots.SnapshotKt.getSnapshotInitializer()
            java.lang.Object r2 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()
            monitor-enter(r2)
            androidx.compose.runtime.snapshots.Snapshot$Companion r3 = androidx.compose.runtime.snapshots.Snapshot.Companion     // Catch: java.lang.Throwable -> L9b
            androidx.compose.runtime.snapshots.Snapshot r3 = r3.getCurrent()     // Catch: java.lang.Throwable -> L9b
            androidx.compose.runtime.snapshots.StateRecord r0 = androidx.compose.runtime.snapshots.SnapshotKt.writableRecord(r0, r6, r3)     // Catch: java.lang.Throwable -> L9b
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r0 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r0     // Catch: java.lang.Throwable -> L9b
            java.lang.Object r4 = androidx.compose.runtime.snapshots.SnapshotStateListKt.access$getSync$p()     // Catch: java.lang.Throwable -> L9b
            monitor-enter(r4)     // Catch: java.lang.Throwable -> L9b
            int r5 = r0.getModification$runtime_release()     // Catch: java.lang.Throwable -> L92
            if (r5 != r1) goto L7d
            r0.setList$runtime_release(r9)     // Catch: java.lang.Throwable -> L92
            if (r7 == 0) goto L73
            int r9 = r0.getStructuralChange$runtime_release()     // Catch: java.lang.Throwable -> L92
            int r9 = r9 + r10
            r0.setStructuralChange$runtime_release(r9)     // Catch: java.lang.Throwable -> L92
        L73:
            int r9 = r0.getModification$runtime_release()     // Catch: java.lang.Throwable -> L92
            int r9 = r9 + r10
            r0.setModification$runtime_release(r9)     // Catch: java.lang.Throwable -> L92
            r9 = r10
            goto L7e
        L7d:
            r9 = 0
        L7e:
            kotlin.jvm.internal.InlineMarker.finallyStart(r10)     // Catch: java.lang.Throwable -> L9b
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L9b
            kotlin.jvm.internal.InlineMarker.finallyEnd(r10)     // Catch: java.lang.Throwable -> L9b
            kotlin.jvm.internal.InlineMarker.finallyStart(r10)
            monitor-exit(r2)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r10)
            androidx.compose.runtime.snapshots.SnapshotKt.notifyWrite(r3, r6)
            if (r9 == 0) goto L5
        L91:
            return
        L92:
            r6 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r10)     // Catch: java.lang.Throwable -> L9b
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L9b
            kotlin.jvm.internal.InlineMarker.finallyEnd(r10)     // Catch: java.lang.Throwable -> L9b
            throw r6     // Catch: java.lang.Throwable -> L9b
        L9b:
            r6 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r10)
            monitor-exit(r2)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r10)
            throw r6
        La4:
            r6 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r10)
            monitor-exit(r9)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r10)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotStateList.update$default(androidx.compose.runtime.snapshots.SnapshotStateList, boolean, kotlin.jvm.functions.Function1, int, java.lang.Object):void");
    }
}
