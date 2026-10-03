package androidx.compose.runtime.snapshots;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import androidx.collection.MutableObjectIntMap;
import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ObjectIntMap;
import androidx.collection.ScatterSet;
import androidx.compose.runtime.ActualJvm_jvmKt;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DerivedState;
import androidx.compose.runtime.DerivedStateObserver;
import androidx.compose.runtime.PreconditionsKt;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.collection.ScatterSetWrapper;
import androidx.compose.runtime.collection.ScopeMap;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Deprecated;
import kotlin.KotlinNothingValueException;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public final class SnapshotStateObserver {
    public static final int $stable = 8;
    private ObserverHandle applyUnsubscribe;
    private ObservedScopeMap currentMap;
    private boolean isPaused;
    private final Function1<Function0<Unit>, Unit> onChangedExecutor;
    private boolean sendingNotifications;
    private final AtomicReference<Object> pendingChanges = new AtomicReference<>(null);
    private final Function2<Set<? extends Object>, Snapshot, Unit> applyObserver = new Function2<Set<? extends Object>, Snapshot, Unit>() { // from class: androidx.compose.runtime.snapshots.SnapshotStateObserver$applyObserver$1
        {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Set<? extends Object> set, Snapshot snapshot) {
            invoke2(set, snapshot);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull Set<? extends Object> set, @NotNull Snapshot snapshot) {
            this.this$0.addChanges(set);
            if (this.this$0.drainChanges()) {
                this.this$0.sendNotifications();
            }
        }
    };
    private final Function1<Object, Unit> readObserver = new Function1<Object, Unit>() { // from class: androidx.compose.runtime.snapshots.SnapshotStateObserver$readObserver$1
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
            invoke2(obj);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull Object obj) {
            if (this.this$0.isPaused) {
                return;
            }
            MutableVector mutableVector = this.this$0.observedScopeMaps;
            SnapshotStateObserver snapshotStateObserver = this.this$0;
            synchronized (mutableVector) {
                SnapshotStateObserver.ObservedScopeMap observedScopeMap = snapshotStateObserver.currentMap;
                Intrinsics.checkNotNull(observedScopeMap);
                observedScopeMap.recordRead(obj);
                Unit unit = Unit.INSTANCE;
            }
        }
    };
    private final MutableVector<ObservedScopeMap> observedScopeMaps = new MutableVector<>(new ObservedScopeMap[16], 0);
    private long currentMapThreadId = -1;

    /* JADX WARN: Multi-variable type inference failed */
    public SnapshotStateObserver(@NotNull Function1<? super Function0<Unit>, Unit> function1) {
        this.onChangedExecutor = function1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean drainChanges() {
        boolean z;
        synchronized (this.observedScopeMaps) {
            z = this.sendingNotifications;
        }
        if (z) {
            return false;
        }
        boolean z2 = false;
        while (true) {
            Set<? extends Object> setRemoveChanges = removeChanges();
            if (setRemoveChanges == null) {
                return z2;
            }
            synchronized (this.observedScopeMaps) {
                MutableVector<ObservedScopeMap> mutableVector = this.observedScopeMaps;
                int size = mutableVector.getSize();
                if (size > 0) {
                    ObservedScopeMap[] content = mutableVector.getContent();
                    int i = 0;
                    do {
                        z2 = content[i].recordInvalidation(setRemoveChanges) || z2;
                        i++;
                    } while (i < size);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendNotifications() {
        this.onChangedExecutor.invoke(new Function0<Unit>() { // from class: androidx.compose.runtime.snapshots.SnapshotStateObserver.sendNotifications.1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                do {
                    MutableVector mutableVector = SnapshotStateObserver.this.observedScopeMaps;
                    SnapshotStateObserver snapshotStateObserver = SnapshotStateObserver.this;
                    synchronized (mutableVector) {
                        if (!snapshotStateObserver.sendingNotifications) {
                            snapshotStateObserver.sendingNotifications = true;
                            try {
                                MutableVector mutableVector2 = snapshotStateObserver.observedScopeMaps;
                                int size = mutableVector2.getSize();
                                if (size > 0) {
                                    Object[] content = mutableVector2.getContent();
                                    int i = 0;
                                    do {
                                        ((ObservedScopeMap) content[i]).notifyInvalidatedScopes();
                                        i++;
                                    } while (i < size);
                                }
                                snapshotStateObserver.sendingNotifications = false;
                            } catch (Throwable th) {
                                snapshotStateObserver.sendingNotifications = false;
                                throw th;
                            }
                        }
                        Unit unit = Unit.INSTANCE;
                    }
                } while (SnapshotStateObserver.this.drainChanges());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void addChanges(Set<? extends Object> set) {
        Object obj;
        List listPlus;
        do {
            obj = this.pendingChanges.get();
            if (obj == null) {
                listPlus = set;
            } else if (obj instanceof Set) {
                listPlus = CollectionsKt__CollectionsKt.listOf((Object[]) new Set[]{obj, set});
            } else {
                if (!(obj instanceof List)) {
                    report();
                    throw new KotlinNothingValueException();
                }
                listPlus = CollectionsKt___CollectionsKt.plus((Collection) obj, (Iterable) CollectionsKt__CollectionsJVMKt.listOf(set));
            }
        } while (!PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.pendingChanges, obj, listPlus));
    }

    private final Set<Object> removeChanges() {
        Object obj;
        Object objSubList;
        Set<Object> set;
        do {
            obj = this.pendingChanges.get();
            objSubList = null;
            if (obj == null) {
                return null;
            }
            if (obj instanceof Set) {
                set = (Set) obj;
            } else if (obj instanceof List) {
                List list = (List) obj;
                Set<Object> set2 = (Set) list.get(0);
                if (list.size() == 2) {
                    objSubList = list.get(1);
                } else if (list.size() > 2) {
                    objSubList = list.subList(1, list.size());
                }
                set = set2;
            } else {
                report();
                throw new KotlinNothingValueException();
            }
        } while (!PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.pendingChanges, obj, objSubList));
        return set;
    }

    private final Void report() {
        ComposerKt.composeRuntimeError("Unexpected notification");
        throw new KotlinNothingValueException();
    }

    private final void forEachScopeMap(Function1<? super ObservedScopeMap, Unit> function1) {
        synchronized (this.observedScopeMaps) {
            try {
                MutableVector<ObservedScopeMap> mutableVector = this.observedScopeMaps;
                int size = mutableVector.getSize();
                if (size > 0) {
                    ObservedScopeMap[] content = mutableVector.getContent();
                    int i = 0;
                    do {
                        function1.invoke(content[i]);
                        i++;
                    } while (i < size);
                }
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
            } finally {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
            }
        }
    }

    private final void removeScopeMapIf(Function1<? super ObservedScopeMap, Boolean> function1) {
        synchronized (this.observedScopeMaps) {
            try {
                MutableVector<ObservedScopeMap> mutableVector = this.observedScopeMaps;
                int size = mutableVector.getSize();
                int i = 0;
                for (int i2 = 0; i2 < size; i2++) {
                    if (function1.invoke(mutableVector.getContent()[i2]).booleanValue()) {
                        i++;
                    } else if (i > 0) {
                        mutableVector.getContent()[i2 - i] = mutableVector.getContent()[i2];
                    }
                }
                int i3 = size - i;
                ArraysKt___ArraysJvmKt.fill(mutableVector.getContent(), (Object) null, i3, size);
                mutableVector.setSize(i3);
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
            } finally {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
            }
        }
    }

    public final <T> void observeReads(@NotNull T t, @NotNull Function1<? super T, Unit> function1, @NotNull Function0<Unit> function0) {
        ObservedScopeMap observedScopeMapEnsureMap;
        synchronized (this.observedScopeMaps) {
            observedScopeMapEnsureMap = ensureMap(function1);
        }
        boolean z = this.isPaused;
        ObservedScopeMap observedScopeMap = this.currentMap;
        long j = this.currentMapThreadId;
        if (j != -1 && j != ActualJvm_jvmKt.currentThreadId()) {
            PreconditionsKt.throwIllegalArgumentException("Detected multithreaded access to SnapshotStateObserver: previousThreadId=" + j + "), currentThread={id=" + ActualJvm_jvmKt.currentThreadId() + ", name=" + ActualJvm_jvmKt.currentThreadName() + "}. Note that observation on multiple threads in layout/draw is not supported. Make sure your measure/layout/draw for each Owner (AndroidComposeView) is executed on the same thread.");
        }
        try {
            this.isPaused = false;
            this.currentMap = observedScopeMapEnsureMap;
            this.currentMapThreadId = ActualJvm_jvmKt.currentThreadId();
            observedScopeMapEnsureMap.observe(t, this.readObserver, function0);
        } finally {
            this.currentMap = observedScopeMap;
            this.isPaused = z;
            this.currentMapThreadId = j;
        }
    }

    @Deprecated(message = "Replace with Snapshot.withoutReadObservation()", replaceWith = @ReplaceWith(expression = "Snapshot.withoutReadObservation(block)", imports = {"androidx.compose.runtime.snapshots.Snapshot"}))
    public final void withNoObservations(@NotNull Function0<Unit> function0) {
        boolean z = this.isPaused;
        this.isPaused = true;
        try {
            function0.invoke();
        } finally {
            this.isPaused = z;
        }
    }

    public final void start() {
        this.applyUnsubscribe = Snapshot.Companion.registerApplyObserver(this.applyObserver);
    }

    public final void stop() {
        ObserverHandle observerHandle = this.applyUnsubscribe;
        if (observerHandle != null) {
            observerHandle.dispose();
        }
    }

    public final void notifyChanges(@NotNull Set<? extends Object> set, @NotNull Snapshot snapshot) {
        this.applyObserver.invoke(set, snapshot);
    }

    private final <T> ObservedScopeMap ensureMap(Function1<? super T, Unit> function1) {
        ObservedScopeMap observedScopeMap;
        MutableVector<ObservedScopeMap> mutableVector = this.observedScopeMaps;
        int size = mutableVector.getSize();
        if (size <= 0) {
            observedScopeMap = null;
            break;
        }
        ObservedScopeMap[] content = mutableVector.getContent();
        int i = 0;
        while (true) {
            observedScopeMap = content[i];
            if (observedScopeMap.getOnChanged() == function1) {
                break;
            }
            i++;
            if (i >= size) {
                observedScopeMap = null;
                break;
            }
        }
        ObservedScopeMap observedScopeMap2 = observedScopeMap;
        if (observedScopeMap2 != null) {
            return observedScopeMap2;
        }
        Intrinsics.checkNotNull(function1, "null cannot be cast to non-null type kotlin.Function1<kotlin.Any, kotlin.Unit>");
        ObservedScopeMap observedScopeMap3 = new ObservedScopeMap((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function1, 1));
        this.observedScopeMaps.add(observedScopeMap3);
        return observedScopeMap3;
    }

    static final class ObservedScopeMap {
        private Object currentScope;
        private MutableObjectIntMap<Object> currentScopeReads;
        private int deriveStateScopeCount;
        private final MutableScatterSet<Object> invalidated;
        private final Function1<Object, Unit> onChanged;
        private final MutableScatterMap<Object, MutableObjectIntMap<Object>> scopeToValues;
        private int currentToken = -1;
        private final ScopeMap<Object, Object> valueToScopes = new ScopeMap<>();
        private final MutableVector<DerivedState<?>> statesToReread = new MutableVector<>(new DerivedState[16], 0);
        private final DerivedStateObserver derivedStateObserver = new DerivedStateObserver() { // from class: androidx.compose.runtime.snapshots.SnapshotStateObserver$ObservedScopeMap$derivedStateObserver$1
            @Override // androidx.compose.runtime.DerivedStateObserver
            public void start(@NotNull DerivedState<?> derivedState) {
                this.this$0.deriveStateScopeCount++;
            }

            @Override // androidx.compose.runtime.DerivedStateObserver
            public void done(@NotNull DerivedState<?> derivedState) {
                this.this$0.deriveStateScopeCount--;
            }
        };
        private final ScopeMap<Object, DerivedState<?>> dependencyToDerivedStates = new ScopeMap<>();
        private final HashMap<DerivedState<?>, Object> recordedDerivedStateValues = new HashMap<>();

        public ObservedScopeMap(@NotNull Function1<Object, Unit> function1) {
            this.onChanged = function1;
            int i = 0;
            int i2 = 1;
            DefaultConstructorMarker defaultConstructorMarker = null;
            this.scopeToValues = new MutableScatterMap<>(i, i2, defaultConstructorMarker);
            this.invalidated = new MutableScatterSet<>(i, i2, defaultConstructorMarker);
        }

        public final Function1<Object, Unit> getOnChanged() {
            return this.onChanged;
        }

        public final DerivedStateObserver getDerivedStateObserver() {
            return this.derivedStateObserver;
        }

        public final void recordRead(@NotNull Object obj) {
            Object obj2 = this.currentScope;
            Intrinsics.checkNotNull(obj2);
            int i = this.currentToken;
            MutableObjectIntMap<Object> mutableObjectIntMap = this.currentScopeReads;
            if (mutableObjectIntMap == null) {
                mutableObjectIntMap = new MutableObjectIntMap<>(0, 1, null);
                this.currentScopeReads = mutableObjectIntMap;
                this.scopeToValues.set(obj2, mutableObjectIntMap);
                Unit unit = Unit.INSTANCE;
            }
            recordRead(obj, i, obj2, mutableObjectIntMap);
        }

        /* JADX WARN: Code duplicated, block: B:25:0x008b A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:26:0x008d A[LOOP:0: B:11:0x003b->B:26:0x008d, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:36:0x0091 A[EDGE_INSN: B:36:0x0091->B:27:0x0091 BREAK  A[LOOP:0: B:11:0x003b->B:26:0x008d], SYNTHETIC] */
        private final void recordRead(Object obj, int i, Object obj2, MutableObjectIntMap<Object> mutableObjectIntMap) {
            int i2;
            int i3;
            if (this.deriveStateScopeCount > 0) {
                return;
            }
            int iPut = mutableObjectIntMap.put(obj, i, -1);
            if (!(obj instanceof DerivedState) || iPut == i) {
                i2 = -1;
            } else {
                DerivedState.Record currentRecord = ((DerivedState) obj).getCurrentRecord();
                this.recordedDerivedStateValues.put(obj, currentRecord.getCurrentValue());
                ObjectIntMap<StateObject> dependencies = currentRecord.getDependencies();
                ScopeMap<Object, DerivedState<?>> scopeMap = this.dependencyToDerivedStates;
                scopeMap.removeScope(obj);
                Object[] objArr = dependencies.keys;
                long[] jArr = dependencies.metadata;
                int length = jArr.length - 2;
                if (length >= 0) {
                    int i4 = 0;
                    while (true) {
                        long j = jArr[i4];
                        if ((((~j) << 7) & j & (-9187201950435737472L)) == -9187201950435737472L) {
                            if (i4 != length) {
                                break;
                                break;
                            }
                            i4++;
                        } else {
                            int i5 = 8;
                            int i6 = 8 - ((~(i4 - length)) >>> 31);
                            int i7 = 0;
                            while (i7 < i6) {
                                if ((j & 255) < 128) {
                                    StateObject stateObject = (StateObject) objArr[(i4 << 3) + i7];
                                    if (stateObject instanceof StateObjectImpl) {
                                        ReaderKind.Companion companion = ReaderKind.Companion;
                                        ((StateObjectImpl) stateObject).m773recordReadInh_f27i8$runtime_release(ReaderKind.m760constructorimpl(2));
                                    }
                                    scopeMap.add(stateObject, obj);
                                    i3 = 8;
                                } else {
                                    i3 = i5;
                                }
                                j >>= i3;
                                i7++;
                                i5 = i3;
                            }
                            if (i6 != i5) {
                                break;
                            } else if (i4 != length) {
                                break;
                            } else {
                                i4++;
                            }
                        }
                    }
                }
                i2 = -1;
            }
            if (iPut == i2) {
                if (obj instanceof StateObjectImpl) {
                    ReaderKind.Companion companion2 = ReaderKind.Companion;
                    ((StateObjectImpl) obj).m773recordReadInh_f27i8$runtime_release(ReaderKind.m760constructorimpl(2));
                }
                this.valueToScopes.add(obj, obj2);
            }
        }

        public final void observe(@NotNull Object obj, @NotNull Function1<Object, Unit> function1, @NotNull Function0<Unit> function0) {
            Object obj2 = this.currentScope;
            MutableObjectIntMap<Object> mutableObjectIntMap = this.currentScopeReads;
            int i = this.currentToken;
            this.currentScope = obj;
            this.currentScopeReads = this.scopeToValues.get(obj);
            if (this.currentToken == -1) {
                this.currentToken = SnapshotKt.currentSnapshot().getId();
            }
            DerivedStateObserver derivedStateObserver = this.derivedStateObserver;
            MutableVector<DerivedStateObserver> mutableVectorDerivedStateObservers = SnapshotStateKt.derivedStateObservers();
            try {
                mutableVectorDerivedStateObservers.add(derivedStateObserver);
                Snapshot.Companion.observe(function1, null, function0);
                mutableVectorDerivedStateObservers.removeAt(mutableVectorDerivedStateObservers.getSize() - 1);
                Object obj3 = this.currentScope;
                Intrinsics.checkNotNull(obj3);
                clearObsoleteStateReads(obj3);
                this.currentScope = obj2;
                this.currentScopeReads = mutableObjectIntMap;
                this.currentToken = i;
            } catch (Throwable th) {
                mutableVectorDerivedStateObservers.removeAt(mutableVectorDerivedStateObservers.getSize() - 1);
                throw th;
            }
        }

        private final void clearObsoleteStateReads(Object obj) {
            int i = this.currentToken;
            MutableObjectIntMap<Object> mutableObjectIntMap = this.currentScopeReads;
            if (mutableObjectIntMap == null) {
                return;
            }
            long[] jArr = mutableObjectIntMap.metadata;
            int length = jArr.length - 2;
            if (length < 0) {
                return;
            }
            int i2 = 0;
            while (true) {
                long j = jArr[i2];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i3 = 8 - ((~(i2 - length)) >>> 31);
                    for (int i4 = 0; i4 < i3; i4++) {
                        if ((255 & j) < 128) {
                            int i5 = (i2 << 3) + i4;
                            Object obj2 = mutableObjectIntMap.keys[i5];
                            boolean z = mutableObjectIntMap.values[i5] != i;
                            if (z) {
                                removeObservation(obj, obj2);
                            }
                            if (z) {
                                mutableObjectIntMap.removeValueAt(i5);
                            }
                        }
                        j >>= 8;
                    }
                    if (i3 != 8) {
                        return;
                    }
                }
                if (i2 == length) {
                    return;
                } else {
                    i2++;
                }
            }
        }

        public final void clearScopeObservations(@NotNull Object obj) {
            MutableObjectIntMap<Object> mutableObjectIntMapRemove = this.scopeToValues.remove(obj);
            if (mutableObjectIntMapRemove == null) {
                return;
            }
            Object[] objArr = mutableObjectIntMapRemove.keys;
            int[] iArr = mutableObjectIntMapRemove.values;
            long[] jArr = mutableObjectIntMapRemove.metadata;
            int length = jArr.length - 2;
            if (length < 0) {
                return;
            }
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            int i4 = (i << 3) + i3;
                            Object obj2 = objArr[i4];
                            int i5 = iArr[i4];
                            removeObservation(obj, obj2);
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        return;
                    }
                }
                if (i == length) {
                    return;
                } else {
                    i++;
                }
            }
        }

        public final void removeScopeIf(@NotNull Function1<Object, Boolean> function1) {
            long[] jArr;
            int i;
            long[] jArr2;
            int i2;
            long j;
            int i3;
            long j2;
            int i4;
            MutableScatterMap<Object, MutableObjectIntMap<Object>> mutableScatterMap = this.scopeToValues;
            long[] jArr3 = mutableScatterMap.metadata;
            int length = jArr3.length - 2;
            if (length < 0) {
                return;
            }
            int i5 = 0;
            while (true) {
                long j3 = jArr3[i5];
                long j4 = -9187201950435737472L;
                if ((((~j3) << 7) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i6 = 8;
                    int i7 = 8 - ((~(i5 - length)) >>> 31);
                    int i8 = 0;
                    while (i8 < i7) {
                        if ((j3 & 255) < 128) {
                            int i9 = (i5 << 3) + i8;
                            Object obj = mutableScatterMap.keys[i9];
                            MutableObjectIntMap mutableObjectIntMap = (MutableObjectIntMap) mutableScatterMap.values[i9];
                            Boolean boolInvoke = function1.invoke(obj);
                            if (boolInvoke.booleanValue()) {
                                Object[] objArr = mutableObjectIntMap.keys;
                                int[] iArr = mutableObjectIntMap.values;
                                long[] jArr4 = mutableObjectIntMap.metadata;
                                int length2 = jArr4.length - 2;
                                if (length2 >= 0) {
                                    jArr2 = jArr3;
                                    i3 = i7;
                                    int i10 = 0;
                                    while (true) {
                                        long j5 = jArr4[i10];
                                        i2 = i5;
                                        j = j3;
                                        j2 = -9187201950435737472L;
                                        if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                                            int i11 = 8 - ((~(i10 - length2)) >>> 31);
                                            for (int i12 = 0; i12 < i11; i12++) {
                                                if ((j5 & 255) < 128) {
                                                    int i13 = (i10 << 3) + i12;
                                                    Object obj2 = objArr[i13];
                                                    int i14 = iArr[i13];
                                                    removeObservation(obj, obj2);
                                                }
                                                j5 >>= 8;
                                            }
                                            if (i11 != 8) {
                                                break;
                                            }
                                        }
                                        if (i10 == length2) {
                                            break;
                                        }
                                        i10++;
                                        i5 = i2;
                                        j3 = j;
                                    }
                                } else {
                                    jArr2 = jArr3;
                                    i2 = i5;
                                    j = j3;
                                    i3 = i7;
                                    j2 = -9187201950435737472L;
                                }
                            } else {
                                jArr2 = jArr3;
                                i2 = i5;
                                j = j3;
                                i3 = i7;
                                j2 = j4;
                            }
                            if (boolInvoke.booleanValue()) {
                                mutableScatterMap.removeValueAt(i9);
                            }
                            i4 = 8;
                        } else {
                            jArr2 = jArr3;
                            i2 = i5;
                            j = j3;
                            i3 = i7;
                            j2 = j4;
                            i4 = i6;
                        }
                        j3 = j >> i4;
                        i8++;
                        i6 = i4;
                        j4 = j2;
                        jArr3 = jArr2;
                        i7 = i3;
                        i5 = i2;
                    }
                    jArr = jArr3;
                    int i15 = i5;
                    if (i7 != i6) {
                        return;
                    } else {
                        i = i15;
                    }
                } else {
                    jArr = jArr3;
                    i = i5;
                }
                if (i == length) {
                    return;
                }
                i5 = i + 1;
                jArr3 = jArr;
            }
        }

        public final boolean hasScopeObservations() {
            return this.scopeToValues.isNotEmpty();
        }

        private final void removeObservation(Object obj, Object obj2) {
            this.valueToScopes.remove(obj2, obj);
            if (!(obj2 instanceof DerivedState) || this.valueToScopes.contains(obj2)) {
                return;
            }
            this.dependencyToDerivedStates.removeScope(obj2);
            this.recordedDerivedStateValues.remove(obj2);
        }

        public final void clear() {
            this.valueToScopes.clear();
            this.scopeToValues.clear();
            this.dependencyToDerivedStates.clear();
            this.recordedDerivedStateValues.clear();
        }

        /* JADX WARN: Code duplicated, block: B:144:0x03b1  */
        /* JADX WARN: Code duplicated, block: B:187:0x04ae  */
        /* JADX WARN: Code duplicated, block: B:222:0x05b1 A[DONT_INVERT, PHI: r20
  0x05b1: PHI (r20v11 boolean) = (r20v10 boolean), (r20v12 boolean) binds: [B:213:0x0585, B:221:0x05af] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:223:0x05b3 A[LOOP:18: B:212:0x0577->B:223:0x05b3, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:226:0x05c2  */
        /* JADX WARN: Code duplicated, block: B:229:0x05d7  */
        /* JADX WARN: Code duplicated, block: B:231:0x05db  */
        /* JADX WARN: Code duplicated, block: B:233:0x05e6  */
        /* JADX WARN: Code duplicated, block: B:236:0x05f8  */
        /* JADX WARN: Code duplicated, block: B:238:0x0604  */
        /* JADX WARN: Code duplicated, block: B:240:0x060e  */
        /* JADX WARN: Code duplicated, block: B:245:0x0627  */
        /* JADX WARN: Code duplicated, block: B:247:0x062f A[LOOP:16: B:234:0x05e7->B:247:0x062f, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:248:0x0632  */
        /* JADX WARN: Code duplicated, block: B:281:0x02ad A[EDGE_INSN: B:281:0x02ad->B:103:0x02ad BREAK  A[LOOP:8: B:88:0x024d->B:99:0x0289], SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:289:0x0652 A[EDGE_INSN: B:289:0x0652->B:251:0x0652 BREAK  A[LOOP:16: B:234:0x05e7->B:247:0x062f], SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:290:0x0652 A[EDGE_INSN: B:290:0x0652->B:251:0x0652 BREAK  A[LOOP:16: B:234:0x05e7->B:247:0x062f], SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:303:0x0618 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:305:0x05cb A[EDGE_INSN: B:305:0x05cb->B:227:0x05cb BREAK  A[LOOP:18: B:212:0x0577->B:223:0x05b3], SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:98:0x0287 A[DONT_INVERT, PHI: r20
  0x0287: PHI (r20v49 boolean) = (r20v48 boolean), (r20v50 boolean) binds: [B:89:0x025b, B:97:0x0285] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:99:0x0289 A[LOOP:8: B:88:0x024d->B:99:0x0289, LOOP_END] */
        public final boolean recordInvalidation(@NotNull Set<? extends Object> set) {
            boolean z;
            ScopeMap<Object, DerivedState<?>> scopeMap;
            Iterator it2;
            HashMap<DerivedState<?>, Object> map;
            Object obj;
            String str;
            Object obj2;
            Object[] objArr;
            long[] jArr;
            int length;
            int i;
            long j;
            int i2;
            int i3;
            Object obj3;
            HashMap<DerivedState<?>, Object> map2;
            long[] jArr2;
            Object[] objArr2;
            Iterator it3;
            HashMap<DerivedState<?>, Object> map3;
            Object obj4;
            ScopeMap<Object, DerivedState<?>> scopeMap2;
            long[] jArr3;
            Object[] objArr3;
            int i4;
            String str2;
            char c;
            long[] jArr4;
            long[] jArr5;
            ScopeMap<Object, DerivedState<?>> scopeMap3;
            HashMap<DerivedState<?>, Object> map4;
            ScopeMap<Object, Object> scopeMap4;
            Object[] objArr4;
            String str3;
            int i5;
            long[] jArr6;
            ScopeMap<Object, DerivedState<?>> scopeMap5;
            HashMap<DerivedState<?>, Object> map5;
            ScopeMap<Object, Object> scopeMap6;
            Object[] objArr5;
            String str4;
            int i6;
            long j2;
            int i7;
            int i8;
            int i9;
            int i10;
            Object obj5;
            Object obj6;
            HashMap<DerivedState<?>, Object> map6;
            long[] jArr7;
            Object[] objArr6;
            long[] jArr8;
            String str5;
            Object[] objArr7;
            int i11;
            Object obj7;
            char c2;
            long[] jArr9;
            ScopeMap<Object, DerivedState<?>> scopeMap7 = this.dependencyToDerivedStates;
            HashMap<DerivedState<?>, Object> map7 = this.recordedDerivedStateValues;
            ScopeMap<Object, Object> scopeMap8 = this.valueToScopes;
            MutableScatterSet<Object> mutableScatterSet = this.invalidated;
            char c3 = 7;
            int i12 = 8;
            String str6 = "null cannot be cast to non-null type androidx.compose.runtime.DerivedState<kotlin.Any?>";
            if (set instanceof ScatterSetWrapper) {
                ScatterSet set$runtime_release = ((ScatterSetWrapper) set).getSet$runtime_release();
                Object[] objArr8 = set$runtime_release.elements;
                long[] jArr10 = set$runtime_release.metadata;
                int length2 = jArr10.length - 2;
                if (length2 >= 0) {
                    int i13 = 0;
                    z = false;
                    while (true) {
                        long j3 = jArr10[i13];
                        if ((((~j3) << c3) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                            int i14 = 8 - ((~(i13 - length2)) >>> 31);
                            int i15 = 0;
                            while (i15 < i14) {
                                if ((j3 & 255) < 128) {
                                    Object obj8 = objArr8[(i13 << 3) + i15];
                                    if (obj8 instanceof StateObjectImpl) {
                                        ReaderKind.Companion companion = ReaderKind.Companion;
                                        jArr6 = jArr10;
                                        if (!((StateObjectImpl) obj8).m772isReadInh_f27i8$runtime_release(ReaderKind.m760constructorimpl(2))) {
                                        }
                                        i10 = 8;
                                        break;
                                        j3 = j2 >> i10;
                                        i15 = i9 + 1;
                                        objArr8 = objArr5;
                                        i12 = i10;
                                        map7 = map5;
                                        jArr10 = jArr6;
                                        scopeMap7 = scopeMap5;
                                        i13 = i7;
                                        i14 = i8;
                                        length2 = i6;
                                        str6 = str4;
                                        scopeMap8 = scopeMap6;
                                    } else {
                                        jArr6 = jArr10;
                                    }
                                    if (!scopeMap7.contains(obj8) || (obj6 = scopeMap7.getMap().get(obj8)) == null) {
                                        scopeMap5 = scopeMap7;
                                        map5 = map7;
                                        scopeMap6 = scopeMap8;
                                        objArr5 = objArr8;
                                        str4 = str6;
                                        i6 = length2;
                                        j2 = j3;
                                        i7 = i13;
                                        i8 = i14;
                                        i9 = i15;
                                        obj5 = obj8;
                                    } else if (obj6 instanceof MutableScatterSet) {
                                        MutableScatterSet mutableScatterSet2 = (MutableScatterSet) obj6;
                                        Object[] objArr9 = mutableScatterSet2.elements;
                                        long[] jArr11 = mutableScatterSet2.metadata;
                                        objArr5 = objArr8;
                                        int length3 = jArr11.length - 2;
                                        if (length3 >= 0) {
                                            scopeMap5 = scopeMap7;
                                            i7 = i13;
                                            i8 = i14;
                                            int i16 = 0;
                                            while (true) {
                                                long j4 = jArr11[i16];
                                                i6 = length2;
                                                j2 = j3;
                                                if ((((~j4) << 7) & j4 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                    int i17 = 8 - ((~(i16 - length3)) >>> 31);
                                                    int i18 = 0;
                                                    while (i18 < i17) {
                                                        if ((j4 & 255) < 128) {
                                                            DerivedState<?> derivedState = (DerivedState) objArr9[(i16 << 3) + i18];
                                                            Intrinsics.checkNotNull(derivedState, str6);
                                                            jArr8 = jArr11;
                                                            Object obj9 = map7.get(derivedState);
                                                            SnapshotMutationPolicy<?> policy = derivedState.getPolicy();
                                                            if (policy == null) {
                                                                policy = SnapshotStateKt.structuralEqualityPolicy();
                                                            }
                                                            objArr7 = objArr9;
                                                            str5 = str6;
                                                            if (policy.equivalent(derivedState.getCurrentRecord().getCurrentValue(), obj9)) {
                                                                map7 = map7;
                                                                scopeMap8 = scopeMap8;
                                                                i11 = i15;
                                                                obj7 = obj8;
                                                                this.statesToReread.add(derivedState);
                                                            } else {
                                                                Object obj10 = scopeMap8.getMap().get(derivedState);
                                                                if (obj10 != null) {
                                                                    if (obj10 instanceof MutableScatterSet) {
                                                                        MutableScatterSet mutableScatterSet3 = (MutableScatterSet) obj10;
                                                                        Object[] objArr10 = mutableScatterSet3.elements;
                                                                        long[] jArr12 = mutableScatterSet3.metadata;
                                                                        int length4 = jArr12.length - 2;
                                                                        if (length4 >= 0) {
                                                                            i11 = i15;
                                                                            obj7 = obj8;
                                                                            int i19 = 0;
                                                                            while (true) {
                                                                                long j5 = jArr12[i19];
                                                                                map7 = map7;
                                                                                scopeMap8 = scopeMap8;
                                                                                if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                                                    int i20 = 8 - ((~(i19 - length4)) >>> 31);
                                                                                    int i21 = 0;
                                                                                    while (i21 < i20) {
                                                                                        if ((j5 & 255) < 128) {
                                                                                            mutableScatterSet.add(objArr10[(i19 << 3) + i21]);
                                                                                            z = true;
                                                                                        }
                                                                                        j5 >>= 8;
                                                                                        i21++;
                                                                                        jArr12 = jArr12;
                                                                                    }
                                                                                    jArr9 = jArr12;
                                                                                    c2 = '\b';
                                                                                    if (i20 != 8) {
                                                                                        break;
                                                                                    }
                                                                                } else {
                                                                                    jArr9 = jArr12;
                                                                                }
                                                                                if (i19 != length4) {
                                                                                    i19++;
                                                                                    map7 = map7;
                                                                                    scopeMap8 = scopeMap8;
                                                                                    jArr12 = jArr9;
                                                                                }
                                                                            }
                                                                        }
                                                                        j4 >>= c2;
                                                                        i18++;
                                                                        jArr11 = jArr8;
                                                                        i15 = i11;
                                                                        objArr9 = objArr7;
                                                                        str6 = str5;
                                                                        obj8 = obj7;
                                                                        map7 = map7;
                                                                        scopeMap8 = scopeMap8;
                                                                    } else {
                                                                        map7 = map7;
                                                                        scopeMap8 = scopeMap8;
                                                                        i11 = i15;
                                                                        obj7 = obj8;
                                                                        mutableScatterSet.add(obj10);
                                                                        z = true;
                                                                    }
                                                                }
                                                            }
                                                            c2 = '\b';
                                                            j4 >>= c2;
                                                            i18++;
                                                            jArr11 = jArr8;
                                                            i15 = i11;
                                                            objArr9 = objArr7;
                                                            str6 = str5;
                                                            obj8 = obj7;
                                                            map7 = map7;
                                                            scopeMap8 = scopeMap8;
                                                        } else {
                                                            jArr8 = jArr11;
                                                            str5 = str6;
                                                            objArr7 = objArr9;
                                                        }
                                                        i11 = i15;
                                                        obj7 = obj8;
                                                        c2 = '\b';
                                                        j4 >>= c2;
                                                        i18++;
                                                        jArr11 = jArr8;
                                                        i15 = i11;
                                                        objArr9 = objArr7;
                                                        str6 = str5;
                                                        obj8 = obj7;
                                                        map7 = map7;
                                                        scopeMap8 = scopeMap8;
                                                    }
                                                    jArr7 = jArr11;
                                                    map6 = map7;
                                                    scopeMap6 = scopeMap8;
                                                    str4 = str6;
                                                    objArr6 = objArr9;
                                                    i9 = i15;
                                                    obj5 = obj8;
                                                    if (i17 != 8) {
                                                        break;
                                                    }
                                                } else {
                                                    jArr7 = jArr11;
                                                    map6 = map7;
                                                    scopeMap6 = scopeMap8;
                                                    str4 = str6;
                                                    objArr6 = objArr9;
                                                    i9 = i15;
                                                    obj5 = obj8;
                                                }
                                                if (i16 == length3) {
                                                    break;
                                                }
                                                i16++;
                                                length2 = i6;
                                                j3 = j2;
                                                jArr11 = jArr7;
                                                i15 = i9;
                                                objArr9 = objArr6;
                                                str6 = str4;
                                                obj8 = obj5;
                                                map7 = map6;
                                                scopeMap8 = scopeMap6;
                                            }
                                        } else {
                                            scopeMap5 = scopeMap7;
                                            map6 = map7;
                                            scopeMap6 = scopeMap8;
                                            str4 = str6;
                                            i6 = length2;
                                            j2 = j3;
                                            i7 = i13;
                                            i8 = i14;
                                            i9 = i15;
                                            obj5 = obj8;
                                        }
                                        map5 = map6;
                                    } else {
                                        scopeMap5 = scopeMap7;
                                        scopeMap6 = scopeMap8;
                                        objArr5 = objArr8;
                                        str4 = str6;
                                        i6 = length2;
                                        j2 = j3;
                                        i7 = i13;
                                        i8 = i14;
                                        i9 = i15;
                                        obj5 = obj8;
                                        DerivedState<?> derivedState2 = (DerivedState) obj6;
                                        map5 = map7;
                                        Object obj11 = map5.get(derivedState2);
                                        SnapshotMutationPolicy<?> policy2 = derivedState2.getPolicy();
                                        if (policy2 == null) {
                                            policy2 = SnapshotStateKt.structuralEqualityPolicy();
                                        }
                                        if (policy2.equivalent(derivedState2.getCurrentRecord().getCurrentValue(), obj11)) {
                                            this.statesToReread.add(derivedState2);
                                        } else {
                                            Object obj12 = scopeMap6.getMap().get(derivedState2);
                                            if (obj12 != null) {
                                                if (obj12 instanceof MutableScatterSet) {
                                                    MutableScatterSet mutableScatterSet4 = (MutableScatterSet) obj12;
                                                    Object[] objArr11 = mutableScatterSet4.elements;
                                                    long[] jArr13 = mutableScatterSet4.metadata;
                                                    int length5 = jArr13.length - 2;
                                                    if (length5 >= 0) {
                                                        int i22 = 0;
                                                        while (true) {
                                                            long j6 = jArr13[i22];
                                                            if ((((~j6) << 7) & j6 & (-9187201950435737472L)) == -9187201950435737472L) {
                                                                if (i22 != length5) {
                                                                    break;
                                                                    break;
                                                                }
                                                                i22++;
                                                            } else {
                                                                int i23 = 8 - ((~(i22 - length5)) >>> 31);
                                                                for (int i24 = 0; i24 < i23; i24++) {
                                                                    if ((j6 & 255) < 128) {
                                                                        mutableScatterSet.add(objArr11[(i22 << 3) + i24]);
                                                                        z = true;
                                                                    }
                                                                    j6 >>= 8;
                                                                }
                                                                if (i23 != 8) {
                                                                    break;
                                                                }
                                                                if (i22 != length5) {
                                                                    break;
                                                                }
                                                                i22++;
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    mutableScatterSet.add(obj12);
                                                    z = true;
                                                }
                                            }
                                        }
                                    }
                                    Object obj13 = scopeMap6.getMap().get(obj5);
                                    if (obj13 == null) {
                                        i10 = 8;
                                        break;
                                    }
                                    if (obj13 instanceof MutableScatterSet) {
                                        MutableScatterSet mutableScatterSet5 = (MutableScatterSet) obj13;
                                        Object[] objArr12 = mutableScatterSet5.elements;
                                        long[] jArr14 = mutableScatterSet5.metadata;
                                        int length6 = jArr14.length - 2;
                                        if (length6 >= 0) {
                                            int i25 = 0;
                                            while (true) {
                                                long j7 = jArr14[i25];
                                                if ((((~j7) << 7) & j7 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                    int i26 = 8 - ((~(i25 - length6)) >>> 31);
                                                    for (int i27 = 0; i27 < i26; i27++) {
                                                        if ((j7 & 255) < 128) {
                                                            mutableScatterSet.add(objArr12[(i25 << 3) + i27]);
                                                            z = true;
                                                        }
                                                        j7 >>= 8;
                                                    }
                                                    if (i26 != 8) {
                                                        i10 = 8;
                                                        break;
                                                    }
                                                }
                                                if (i25 != length6) {
                                                    i25++;
                                                }
                                            }
                                        }
                                    } else {
                                        mutableScatterSet.add(obj13);
                                        z = true;
                                    }
                                    i10 = 8;
                                    break;
                                    break;
                                    j3 = j2 >> i10;
                                    i15 = i9 + 1;
                                    objArr8 = objArr5;
                                    i12 = i10;
                                    map7 = map5;
                                    jArr10 = jArr6;
                                    scopeMap7 = scopeMap5;
                                    i13 = i7;
                                    i14 = i8;
                                    length2 = i6;
                                    str6 = str4;
                                    scopeMap8 = scopeMap6;
                                } else {
                                    jArr6 = jArr10;
                                }
                                scopeMap5 = scopeMap7;
                                map5 = map7;
                                scopeMap6 = scopeMap8;
                                objArr5 = objArr8;
                                str4 = str6;
                                i6 = length2;
                                j2 = j3;
                                i7 = i13;
                                i8 = i14;
                                i9 = i15;
                                i10 = 8;
                                break;
                                j3 = j2 >> i10;
                                i15 = i9 + 1;
                                objArr8 = objArr5;
                                i12 = i10;
                                map7 = map5;
                                jArr10 = jArr6;
                                scopeMap7 = scopeMap5;
                                i13 = i7;
                                i14 = i8;
                                length2 = i6;
                                str6 = str4;
                                scopeMap8 = scopeMap6;
                            }
                            jArr5 = jArr10;
                            scopeMap3 = scopeMap7;
                            map4 = map7;
                            scopeMap4 = scopeMap8;
                            objArr4 = objArr8;
                            str3 = str6;
                            int i28 = length2;
                            int i29 = i13;
                            if (i14 != i12) {
                                break;
                            }
                            i5 = i29;
                            length2 = i28;
                        } else {
                            jArr5 = jArr10;
                            scopeMap3 = scopeMap7;
                            map4 = map7;
                            scopeMap4 = scopeMap8;
                            objArr4 = objArr8;
                            str3 = str6;
                            i5 = i13;
                        }
                        if (i5 == length2) {
                            break;
                        }
                        i13 = i5 + 1;
                        objArr8 = objArr4;
                        map7 = map4;
                        jArr10 = jArr5;
                        scopeMap7 = scopeMap3;
                        str6 = str3;
                        scopeMap8 = scopeMap4;
                        c3 = 7;
                        i12 = 8;
                    }
                } else {
                    z = false;
                }
            } else {
                ScopeMap<Object, DerivedState<?>> scopeMap9 = scopeMap7;
                HashMap<DerivedState<?>, Object> map8 = map7;
                String str7 = "null cannot be cast to non-null type androidx.compose.runtime.DerivedState<kotlin.Any?>";
                Iterator it4 = set.iterator();
                z = false;
                while (it4.hasNext()) {
                    Object next = it4.next();
                    if (next instanceof StateObjectImpl) {
                        ReaderKind.Companion companion2 = ReaderKind.Companion;
                        if (((StateObjectImpl) next).m772isReadInh_f27i8$runtime_release(ReaderKind.m760constructorimpl(2))) {
                            scopeMap = scopeMap9;
                            if (scopeMap.contains(next) || (obj3 = scopeMap.getMap().get(next)) == null) {
                                it2 = it4;
                                map = map8;
                                obj = next;
                                scopeMap9 = scopeMap;
                                str = str7;
                            } else if (obj3 instanceof MutableScatterSet) {
                                MutableScatterSet mutableScatterSet6 = (MutableScatterSet) obj3;
                                Object[] objArr13 = mutableScatterSet6.elements;
                                long[] jArr15 = mutableScatterSet6.metadata;
                                int length7 = jArr15.length - 2;
                                if (length7 >= 0) {
                                    int i30 = 0;
                                    while (true) {
                                        long j8 = jArr15[i30];
                                        if ((((~j8) << 7) & j8 & (-9187201950435737472L)) != -9187201950435737472L) {
                                            int i31 = 8 - ((~(i30 - length7)) >>> 31);
                                            int i32 = 0;
                                            while (i32 < i31) {
                                                if ((j8 & 255) < 128) {
                                                    DerivedState<?> derivedState3 = (DerivedState) objArr13[(i30 << 3) + i32];
                                                    str2 = str7;
                                                    Intrinsics.checkNotNull(derivedState3, str2);
                                                    it3 = it4;
                                                    Object obj14 = map8.get(derivedState3);
                                                    SnapshotMutationPolicy<?> policy3 = derivedState3.getPolicy();
                                                    if (policy3 == null) {
                                                        policy3 = SnapshotStateKt.structuralEqualityPolicy();
                                                    }
                                                    scopeMap2 = scopeMap;
                                                    jArr3 = jArr15;
                                                    if (policy3.equivalent(derivedState3.getCurrentRecord().getCurrentValue(), obj14)) {
                                                        map3 = map8;
                                                        obj4 = next;
                                                        objArr3 = objArr13;
                                                        i4 = length7;
                                                        this.statesToReread.add(derivedState3);
                                                    } else {
                                                        Object obj15 = scopeMap8.getMap().get(derivedState3);
                                                        if (obj15 == null) {
                                                            map3 = map8;
                                                            obj4 = next;
                                                            objArr3 = objArr13;
                                                            i4 = length7;
                                                        } else if (obj15 instanceof MutableScatterSet) {
                                                            MutableScatterSet mutableScatterSet7 = (MutableScatterSet) obj15;
                                                            Object[] objArr14 = mutableScatterSet7.elements;
                                                            long[] jArr16 = mutableScatterSet7.metadata;
                                                            int length8 = jArr16.length - 2;
                                                            if (length8 >= 0) {
                                                                map3 = map8;
                                                                obj4 = next;
                                                                int i33 = 0;
                                                                while (true) {
                                                                    long j9 = jArr16[i33];
                                                                    objArr3 = objArr13;
                                                                    i4 = length7;
                                                                    if ((((~j9) << 7) & j9 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                                        int i34 = 8 - ((~(i33 - length8)) >>> 31);
                                                                        int i35 = 0;
                                                                        while (i35 < i34) {
                                                                            if ((j9 & 255) < 128) {
                                                                                mutableScatterSet.add(objArr14[(i33 << 3) + i35]);
                                                                                z = true;
                                                                            }
                                                                            j9 >>= 8;
                                                                            i35++;
                                                                            jArr16 = jArr16;
                                                                        }
                                                                        jArr4 = jArr16;
                                                                        c = '\b';
                                                                        if (i34 != 8) {
                                                                            break;
                                                                        }
                                                                    } else {
                                                                        jArr4 = jArr16;
                                                                    }
                                                                    if (i33 != length8) {
                                                                        i33++;
                                                                        objArr13 = objArr3;
                                                                        length7 = i4;
                                                                        jArr16 = jArr4;
                                                                    }
                                                                }
                                                            } else {
                                                                map3 = map8;
                                                                obj4 = next;
                                                                objArr3 = objArr13;
                                                                i4 = length7;
                                                            }
                                                        } else {
                                                            map3 = map8;
                                                            obj4 = next;
                                                            objArr3 = objArr13;
                                                            i4 = length7;
                                                            mutableScatterSet.add(obj15);
                                                            z = true;
                                                        }
                                                        j8 >>= c;
                                                        i32++;
                                                        it4 = it3;
                                                        str7 = str2;
                                                        next = obj4;
                                                        scopeMap = scopeMap2;
                                                        jArr15 = jArr3;
                                                        objArr13 = objArr3;
                                                        length7 = i4;
                                                        map8 = map3;
                                                    }
                                                } else {
                                                    it3 = it4;
                                                    map3 = map8;
                                                    obj4 = next;
                                                    scopeMap2 = scopeMap;
                                                    jArr3 = jArr15;
                                                    objArr3 = objArr13;
                                                    i4 = length7;
                                                    str2 = str7;
                                                }
                                                c = '\b';
                                                j8 >>= c;
                                                i32++;
                                                it4 = it3;
                                                str7 = str2;
                                                next = obj4;
                                                scopeMap = scopeMap2;
                                                jArr15 = jArr3;
                                                objArr13 = objArr3;
                                                length7 = i4;
                                                map8 = map3;
                                            }
                                            it2 = it4;
                                            map2 = map8;
                                            obj = next;
                                            scopeMap9 = scopeMap;
                                            jArr2 = jArr15;
                                            objArr2 = objArr13;
                                            int i36 = length7;
                                            str = str7;
                                            if (i31 != 8) {
                                                break;
                                            }
                                            length7 = i36;
                                        } else {
                                            it2 = it4;
                                            map2 = map8;
                                            obj = next;
                                            scopeMap9 = scopeMap;
                                            jArr2 = jArr15;
                                            objArr2 = objArr13;
                                            str = str7;
                                        }
                                        if (i30 == length7) {
                                            break;
                                        }
                                        i30++;
                                        it4 = it2;
                                        str7 = str;
                                        next = obj;
                                        scopeMap = scopeMap9;
                                        jArr15 = jArr2;
                                        objArr13 = objArr2;
                                        map8 = map2;
                                    }
                                } else {
                                    it2 = it4;
                                    map2 = map8;
                                    obj = next;
                                    scopeMap9 = scopeMap;
                                    str = str7;
                                }
                                map = map2;
                            } else {
                                it2 = it4;
                                obj = next;
                                scopeMap9 = scopeMap;
                                str = str7;
                                DerivedState<?> derivedState4 = (DerivedState) obj3;
                                map = map8;
                                Object obj16 = map.get(derivedState4);
                                SnapshotMutationPolicy<?> policy4 = derivedState4.getPolicy();
                                if (policy4 == null) {
                                    policy4 = SnapshotStateKt.structuralEqualityPolicy();
                                }
                                if (policy4.equivalent(derivedState4.getCurrentRecord().getCurrentValue(), obj16)) {
                                    this.statesToReread.add(derivedState4);
                                } else {
                                    Object obj17 = scopeMap8.getMap().get(derivedState4);
                                    if (obj17 != null) {
                                        if (obj17 instanceof MutableScatterSet) {
                                            MutableScatterSet mutableScatterSet8 = (MutableScatterSet) obj17;
                                            Object[] objArr15 = mutableScatterSet8.elements;
                                            long[] jArr17 = mutableScatterSet8.metadata;
                                            int length9 = jArr17.length - 2;
                                            if (length9 >= 0) {
                                                int i37 = 0;
                                                while (true) {
                                                    long j10 = jArr17[i37];
                                                    if ((((~j10) << 7) & j10 & (-9187201950435737472L)) == -9187201950435737472L) {
                                                        if (i37 != length9) {
                                                            break;
                                                            break;
                                                        }
                                                        i37++;
                                                    } else {
                                                        int i38 = 8 - ((~(i37 - length9)) >>> 31);
                                                        for (int i39 = 0; i39 < i38; i39++) {
                                                            if ((j10 & 255) < 128) {
                                                                mutableScatterSet.add(objArr15[(i37 << 3) + i39]);
                                                                z = true;
                                                            }
                                                            j10 >>= 8;
                                                        }
                                                        if (i38 != 8) {
                                                            break;
                                                        }
                                                        if (i37 != length9) {
                                                            break;
                                                        }
                                                        i37++;
                                                    }
                                                }
                                            }
                                        } else {
                                            mutableScatterSet.add(obj17);
                                            z = true;
                                        }
                                    }
                                }
                            }
                            obj2 = scopeMap8.getMap().get(obj);
                            if (obj2 != null) {
                                if (obj2 instanceof MutableScatterSet) {
                                    MutableScatterSet mutableScatterSet9 = (MutableScatterSet) obj2;
                                    objArr = mutableScatterSet9.elements;
                                    jArr = mutableScatterSet9.metadata;
                                    length = jArr.length - 2;
                                    if (length >= 0) {
                                        i = 0;
                                        while (true) {
                                            j = jArr[i];
                                            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                                                i2 = 8 - ((~(i - length)) >>> 31);
                                                for (i3 = 0; i3 < i2; i3++) {
                                                    if ((j & 255) < 128) {
                                                        mutableScatterSet.add(objArr[(i << 3) + i3]);
                                                        z = true;
                                                    }
                                                    j >>= 8;
                                                }
                                                if (i2 == 8) {
                                                    break;
                                                }
                                            }
                                            if (i != length) {
                                                break;
                                            }
                                            i++;
                                        }
                                    }
                                } else {
                                    mutableScatterSet.add(obj2);
                                    z = true;
                                }
                            }
                        } else {
                            it2 = it4;
                            map = map8;
                            str = str7;
                        }
                    } else {
                        scopeMap = scopeMap9;
                        if (scopeMap.contains(next)) {
                            it2 = it4;
                            map = map8;
                            obj = next;
                            scopeMap9 = scopeMap;
                            str = str7;
                        } else {
                            it2 = it4;
                            map = map8;
                            obj = next;
                            scopeMap9 = scopeMap;
                            str = str7;
                        }
                        obj2 = scopeMap8.getMap().get(obj);
                        if (obj2 != null) {
                            if (obj2 instanceof MutableScatterSet) {
                                MutableScatterSet mutableScatterSet10 = (MutableScatterSet) obj2;
                                objArr = mutableScatterSet10.elements;
                                jArr = mutableScatterSet10.metadata;
                                length = jArr.length - 2;
                                if (length >= 0) {
                                    i = 0;
                                    while (true) {
                                        j = jArr[i];
                                        if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                                            i2 = 8 - ((~(i - length)) >>> 31);
                                            while (i3 < i2) {
                                                if ((j & 255) < 128) {
                                                    mutableScatterSet.add(objArr[(i << 3) + i3]);
                                                    z = true;
                                                }
                                                j >>= 8;
                                            }
                                            if (i2 == 8) {
                                                break;
                                                break;
                                            }
                                        }
                                        if (i != length) {
                                            break;
                                            break;
                                        }
                                        i++;
                                    }
                                }
                            } else {
                                mutableScatterSet.add(obj2);
                                z = true;
                            }
                        }
                    }
                    map8 = map;
                    str7 = str;
                    it4 = it2;
                }
            }
            if (this.statesToReread.isNotEmpty()) {
                MutableVector<DerivedState<?>> mutableVector = this.statesToReread;
                int size = mutableVector.getSize();
                if (size > 0) {
                    DerivedState<?>[] content = mutableVector.getContent();
                    int i40 = 0;
                    do {
                        rereadDerivedState(content[i40]);
                        i40++;
                    } while (i40 < size);
                }
                this.statesToReread.clear();
            }
            return z;
        }

        public final void rereadDerivedState(@NotNull DerivedState<?> derivedState) {
            long[] jArr;
            int i;
            MutableObjectIntMap<Object> mutableObjectIntMap;
            MutableScatterMap<Object, MutableObjectIntMap<Object>> mutableScatterMap = this.scopeToValues;
            int id = SnapshotKt.currentSnapshot().getId();
            Object obj = this.valueToScopes.getMap().get(derivedState);
            if (obj == null) {
                return;
            }
            DefaultConstructorMarker defaultConstructorMarker = null;
            int i2 = 1;
            int i3 = 0;
            if (!(obj instanceof MutableScatterSet)) {
                MutableObjectIntMap<Object> mutableObjectIntMap2 = mutableScatterMap.get(obj);
                if (mutableObjectIntMap2 == null) {
                    mutableObjectIntMap2 = new MutableObjectIntMap<>(i3, i2, defaultConstructorMarker);
                    mutableScatterMap.set(obj, mutableObjectIntMap2);
                    Unit unit = Unit.INSTANCE;
                }
                recordRead(derivedState, id, obj, mutableObjectIntMap2);
                return;
            }
            MutableScatterSet mutableScatterSet = (MutableScatterSet) obj;
            Object[] objArr = mutableScatterSet.elements;
            long[] jArr2 = mutableScatterSet.metadata;
            int length = jArr2.length - 2;
            if (length < 0) {
                return;
            }
            int i4 = 0;
            while (true) {
                long j = jArr2[i4];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i5 = 8;
                    int i6 = 8 - ((~(i4 - length)) >>> 31);
                    int i7 = 0;
                    while (i7 < i6) {
                        if ((j & 255) < 128) {
                            Object obj2 = objArr[(i4 << 3) + i7];
                            MutableObjectIntMap<Object> mutableObjectIntMap3 = mutableScatterMap.get(obj2);
                            if (mutableObjectIntMap3 == null) {
                                mutableObjectIntMap = new MutableObjectIntMap<>(i3, i2, defaultConstructorMarker);
                                mutableScatterMap.set(obj2, mutableObjectIntMap);
                                Unit unit2 = Unit.INSTANCE;
                            } else {
                                mutableObjectIntMap = mutableObjectIntMap3;
                            }
                            recordRead(derivedState, id, obj2, mutableObjectIntMap);
                            i = 8;
                        } else {
                            i = i5;
                        }
                        j >>= i;
                        i7++;
                        i5 = i;
                        jArr2 = jArr2;
                    }
                    jArr = jArr2;
                    if (i6 != i5) {
                        return;
                    }
                } else {
                    jArr = jArr2;
                }
                if (i4 == length) {
                    return;
                }
                i4++;
                jArr2 = jArr;
            }
        }

        /* JADX WARN: Code duplicated, block: B:14:0x0044 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:15:0x0046 A[LOOP:0: B:5:0x0011->B:15:0x0046, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:19:0x0049 A[EDGE_INSN: B:19:0x0049->B:16:0x0049 BREAK  A[LOOP:0: B:5:0x0011->B:15:0x0046], SYNTHETIC] */
        public final void notifyInvalidatedScopes() {
            MutableScatterSet<Object> mutableScatterSet = this.invalidated;
            Function1<Object, Unit> function1 = this.onChanged;
            Object[] objArr = mutableScatterSet.elements;
            long[] jArr = mutableScatterSet.metadata;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i = 0;
                while (true) {
                    long j = jArr[i];
                    if ((((~j) << 7) & j & (-9187201950435737472L)) == -9187201950435737472L) {
                        if (i != length) {
                            break;
                            break;
                        }
                        i++;
                    } else {
                        int i2 = 8 - ((~(i - length)) >>> 31);
                        for (int i3 = 0; i3 < i2; i3++) {
                            if ((255 & j) < 128) {
                                function1.invoke(objArr[(i << 3) + i3]);
                            }
                            j >>= 8;
                        }
                        if (i2 != 8) {
                            break;
                        } else if (i != length) {
                            break;
                        } else {
                            i++;
                        }
                    }
                }
            }
            mutableScatterSet.clear();
        }
    }

    public final void clear(@NotNull Object obj) {
        synchronized (this.observedScopeMaps) {
            MutableVector<ObservedScopeMap> mutableVector = this.observedScopeMaps;
            int size = mutableVector.getSize();
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                ObservedScopeMap observedScopeMap = mutableVector.getContent()[i2];
                observedScopeMap.clearScopeObservations(obj);
                if (!observedScopeMap.hasScopeObservations()) {
                    i++;
                } else if (i > 0) {
                    mutableVector.getContent()[i2 - i] = mutableVector.getContent()[i2];
                }
            }
            int i3 = size - i;
            ArraysKt___ArraysJvmKt.fill(mutableVector.getContent(), (Object) null, i3, size);
            mutableVector.setSize(i3);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void clearIf(@NotNull Function1<Object, Boolean> function1) {
        synchronized (this.observedScopeMaps) {
            MutableVector<ObservedScopeMap> mutableVector = this.observedScopeMaps;
            int size = mutableVector.getSize();
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                ObservedScopeMap observedScopeMap = mutableVector.getContent()[i2];
                observedScopeMap.removeScopeIf(function1);
                if (!observedScopeMap.hasScopeObservations()) {
                    i++;
                } else if (i > 0) {
                    mutableVector.getContent()[i2 - i] = mutableVector.getContent()[i2];
                }
            }
            int i3 = size - i;
            ArraysKt___ArraysJvmKt.fill(mutableVector.getContent(), (Object) null, i3, size);
            mutableVector.setSize(i3);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void clear() {
        synchronized (this.observedScopeMaps) {
            MutableVector<ObservedScopeMap> mutableVector = this.observedScopeMaps;
            int size = mutableVector.getSize();
            if (size > 0) {
                ObservedScopeMap[] content = mutableVector.getContent();
                int i = 0;
                do {
                    content[i].clear();
                    i++;
                } while (i < size);
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}
