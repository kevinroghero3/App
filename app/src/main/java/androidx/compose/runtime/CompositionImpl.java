package androidx.compose.runtime;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import androidx.collection.MutableIntList;
import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ObjectIntMap;
import androidx.collection.ScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.runtime.changelist.ChangeList;
import androidx.compose.runtime.collection.ScatterSetWrapper;
import androidx.compose.runtime.collection.ScopeMap;
import androidx.compose.runtime.snapshots.ReaderKind;
import androidx.compose.runtime.snapshots.StateObject;
import androidx.compose.runtime.snapshots.StateObjectImpl;
import androidx.compose.runtime.tooling.CompositionObserver;
import androidx.compose.runtime.tooling.CompositionObserverHandle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.KotlinNothingValueException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class CompositionImpl implements ControlledComposition, ReusableComposition, RecomposeScopeOwner, CompositionServices {
    public static final int $stable = 8;
    private final CoroutineContext _recomposeContext;
    private final Set<RememberObserver> abandonSet;
    private final Applier<?> applier;
    private final ChangeList changes;
    private Function2<? super Composer, ? super Integer, Unit> composable;
    private final ComposerImpl composer;
    private final MutableScatterSet<RecomposeScopeImpl> conditionallyInvalidatedScopes;
    private final ScopeMap<Object, DerivedState<?>> derivedStates;
    private boolean disposed;
    private final MutableScatterSet<RecomposeScopeImpl> invalidatedScopes;
    private CompositionImpl invalidationDelegate;
    private int invalidationDelegateGroup;
    private ScopeMap<RecomposeScopeImpl, Object> invalidations;
    private final boolean isRoot;
    private final ChangeList lateChanges;
    private final Object lock;
    private final ScopeMap<Object, RecomposeScopeImpl> observations;
    private final ScopeMap<Object, RecomposeScopeImpl> observationsProcessed;
    private final CompositionObserverHolder observerHolder;
    private final CompositionContext parent;
    private boolean pendingInvalidScopes;
    private final AtomicReference<Object> pendingModifications;
    private final SlotTable slotTable;

    private static /* synthetic */ void getAbandonSet$annotations() {
    }

    public static /* synthetic */ void getPendingInvalidScopes$runtime_release$annotations() {
    }

    public static /* synthetic */ void getSlotTable$runtime_release$annotations() {
    }

    public CompositionImpl(@NotNull CompositionContext compositionContext, @NotNull Applier<?> applier, @Nullable CoroutineContext coroutineContext) {
        this.parent = compositionContext;
        this.applier = applier;
        this.pendingModifications = new AtomicReference<>(null);
        this.lock = new Object();
        Set<RememberObserver> setAsMutableSet = new MutableScatterSet(0, 1, null).asMutableSet();
        this.abandonSet = setAsMutableSet;
        SlotTable slotTable = new SlotTable();
        if (compositionContext.getCollectingCallByInformation$runtime_release()) {
            slotTable.collectCalledByInformation();
        }
        if (compositionContext.getCollectingSourceInformation$runtime_release()) {
            slotTable.collectSourceInformation();
        }
        this.slotTable = slotTable;
        this.observations = new ScopeMap<>();
        this.invalidatedScopes = new MutableScatterSet<>(0, 1, null);
        this.conditionallyInvalidatedScopes = new MutableScatterSet<>(0, 1, null);
        this.derivedStates = new ScopeMap<>();
        ChangeList changeList = new ChangeList();
        this.changes = changeList;
        ChangeList changeList2 = new ChangeList();
        this.lateChanges = changeList2;
        this.observationsProcessed = new ScopeMap<>();
        this.invalidations = new ScopeMap<>();
        this.observerHolder = new CompositionObserverHolder(null, false, 3, null);
        ComposerImpl composerImpl = new ComposerImpl(applier, compositionContext, slotTable, setAsMutableSet, changeList, changeList2, this);
        compositionContext.registerComposer$runtime_release(composerImpl);
        this.composer = composerImpl;
        this._recomposeContext = coroutineContext;
        this.isRoot = compositionContext instanceof Recomposer;
        this.composable = ComposableSingletons$CompositionKt.INSTANCE.m626getLambda1$runtime_release();
    }

    public /* synthetic */ CompositionImpl(CompositionContext compositionContext, Applier applier, CoroutineContext coroutineContext, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(compositionContext, applier, (i & 4) != 0 ? null : coroutineContext);
    }

    public final SlotTable getSlotTable$runtime_release() {
        return this.slotTable;
    }

    public final Set<Object> getObservedObjects$runtime_release() {
        return this.observations.getMap().asMap().keySet();
    }

    public final Set<Object> getDerivedStateDependencies$runtime_release() {
        return this.derivedStates.getMap().asMap().keySet();
    }

    public final List<RecomposeScopeImpl> getConditionalScopes$runtime_release() {
        return CollectionsKt___CollectionsKt.toList(this.conditionallyInvalidatedScopes.asSet());
    }

    public final boolean getPendingInvalidScopes$runtime_release() {
        return this.pendingInvalidScopes;
    }

    public final void setPendingInvalidScopes$runtime_release(boolean z) {
        this.pendingInvalidScopes = z;
    }

    public final CompositionObserverHolder getObserverHolder$runtime_release() {
        return this.observerHolder;
    }

    public final CoroutineContext getRecomposeContext() {
        CoroutineContext coroutineContext = this._recomposeContext;
        return coroutineContext == null ? this.parent.getRecomposeCoroutineContext$runtime_release() : coroutineContext;
    }

    public final boolean isRoot() {
        return this.isRoot;
    }

    private final boolean getAreChildrenComposing() {
        return this.composer.getAreChildrenComposing$runtime_release();
    }

    public final Function2<Composer, Integer, Unit> getComposable() {
        return this.composable;
    }

    public final void setComposable(@NotNull Function2<? super Composer, ? super Integer, Unit> function2) {
        this.composable = function2;
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public boolean isComposing() {
        return this.composer.isComposing$runtime_release();
    }

    @Override // androidx.compose.runtime.Composition
    public boolean isDisposed() {
        return this.disposed;
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public boolean getHasPendingChanges() {
        boolean hasPendingChanges$runtime_release;
        synchronized (this.lock) {
            hasPendingChanges$runtime_release = this.composer.getHasPendingChanges$runtime_release();
        }
        return hasPendingChanges$runtime_release;
    }

    @Override // androidx.compose.runtime.Composition
    public void setContent(@NotNull Function2<? super Composer, ? super Integer, Unit> function2) {
        composeInitial(function2);
    }

    @Override // androidx.compose.runtime.ReusableComposition
    public void setContentWithReuse(@NotNull Function2<? super Composer, ? super Integer, Unit> function2) {
        this.composer.startReuseFromRoot();
        composeInitial(function2);
        this.composer.endReuseFromRoot();
    }

    private final void composeInitial(Function2<? super Composer, ? super Integer, Unit> function2) {
        if (this.disposed) {
            PreconditionsKt.throwIllegalStateException("The composition is disposed");
        }
        this.composable = function2;
        this.parent.composeInitial$runtime_release(this, function2);
    }

    public final CompositionObserverHandle observe$runtime_release(@NotNull final CompositionObserver compositionObserver) {
        synchronized (this.lock) {
            this.observerHolder.setObserver(compositionObserver);
            this.observerHolder.setRoot(true);
            Unit unit = Unit.INSTANCE;
        }
        return new CompositionObserverHandle() { // from class: androidx.compose.runtime.CompositionImpl$observe$2
            @Override // androidx.compose.runtime.tooling.CompositionObserverHandle
            public void dispose() {
                Object obj = this.this$0.lock;
                CompositionImpl compositionImpl = this.this$0;
                CompositionObserver compositionObserver2 = compositionObserver;
                synchronized (obj) {
                    if (Intrinsics.areEqual(compositionImpl.getObserverHolder$runtime_release().getObserver(), compositionObserver2)) {
                        compositionImpl.getObserverHolder$runtime_release().setObserver(null);
                        compositionImpl.getObserverHolder$runtime_release().setRoot(false);
                    }
                    Unit unit2 = Unit.INSTANCE;
                }
            }
        };
    }

    public final void invalidateGroupsWithKey(int i) {
        List<RecomposeScopeImpl> listInvalidateGroupsWithKey$runtime_release;
        synchronized (this.lock) {
            listInvalidateGroupsWithKey$runtime_release = this.slotTable.invalidateGroupsWithKey$runtime_release(i);
        }
        if (listInvalidateGroupsWithKey$runtime_release != null) {
            int size = listInvalidateGroupsWithKey$runtime_release.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (listInvalidateGroupsWithKey$runtime_release.get(i2).invalidateForResult(null) != InvalidationResult.IGNORED) {
                }
            }
            return;
        }
        if (this.composer.forceRecomposeScopes$runtime_release()) {
            this.parent.invalidate$runtime_release(this);
        }
    }

    private final void drainPendingModificationsForCompositionLocked() {
        Object andSet = this.pendingModifications.getAndSet(CompositionKt.PendingApplyNoModifications);
        if (andSet != null) {
            if (Intrinsics.areEqual(andSet, CompositionKt.PendingApplyNoModifications)) {
                ComposerKt.composeRuntimeError("pending composition has not been applied");
                throw new KotlinNothingValueException();
            }
            if (andSet instanceof Set) {
                addPendingInvalidationsLocked((Set<? extends Object>) andSet, true);
                return;
            }
            if (!(andSet instanceof Object[])) {
                ComposerKt.composeRuntimeError("corrupt pendingModifications drain: " + this.pendingModifications);
                throw new KotlinNothingValueException();
            }
            for (Set<? extends Object> set : (Set[]) andSet) {
                addPendingInvalidationsLocked(set, true);
            }
        }
    }

    private final void drainPendingModificationsLocked() {
        Object andSet = this.pendingModifications.getAndSet(null);
        if (Intrinsics.areEqual(andSet, CompositionKt.PendingApplyNoModifications)) {
            return;
        }
        if (andSet instanceof Set) {
            addPendingInvalidationsLocked((Set<? extends Object>) andSet, false);
            return;
        }
        if (andSet instanceof Object[]) {
            for (Set<? extends Object> set : (Set[]) andSet) {
                addPendingInvalidationsLocked(set, false);
            }
            return;
        }
        if (andSet == null) {
            ComposerKt.composeRuntimeError("calling recordModificationsOf and applyChanges concurrently is not supported");
            throw new KotlinNothingValueException();
        }
        ComposerKt.composeRuntimeError("corrupt pendingModifications drain: " + this.pendingModifications);
        throw new KotlinNothingValueException();
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void composeContent(@NotNull Function2<? super Composer, ? super Integer, Unit> function2) throws Exception {
        try {
            synchronized (this.lock) {
                drainPendingModificationsForCompositionLocked();
                ScopeMap<RecomposeScopeImpl, Object> scopeMapTakeInvalidations = takeInvalidations();
                try {
                    CompositionObserver compositionObserverObserver = observer();
                    if (compositionObserverObserver != null) {
                        Map<RecomposeScopeImpl, Set<Object>> mapAsMap = scopeMapTakeInvalidations.asMap();
                        Intrinsics.checkNotNull(mapAsMap, "null cannot be cast to non-null type kotlin.collections.Map<androidx.compose.runtime.RecomposeScope, kotlin.collections.Set<kotlin.Any>?>");
                        compositionObserverObserver.onBeginComposition(this, mapAsMap);
                    }
                    this.composer.composeContent$runtime_release(scopeMapTakeInvalidations, function2);
                    if (compositionObserverObserver != null) {
                        compositionObserverObserver.onEndComposition(this);
                        Unit unit = Unit.INSTANCE;
                    }
                } catch (Exception e) {
                    this.invalidations = scopeMapTakeInvalidations;
                    throw e;
                }
            }
        } catch (Throwable th) {
            try {
                if (!this.abandonSet.isEmpty()) {
                    new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
                }
                throw th;
            } catch (Exception e2) {
                abandonChanges();
                throw e2;
            }
        }
    }

    @Override // androidx.compose.runtime.Composition
    public void dispose() {
        synchronized (this.lock) {
            if (this.composer.isComposing$runtime_release()) {
                PreconditionsKt.throwIllegalStateException("Composition is disposed while composing. If dispose is triggered by a call in @Composable function, consider wrapping it with SideEffect block.");
            }
            if (!this.disposed) {
                this.disposed = true;
                this.composable = ComposableSingletons$CompositionKt.INSTANCE.m627getLambda2$runtime_release();
                ChangeList deferredChanges$runtime_release = this.composer.getDeferredChanges$runtime_release();
                if (deferredChanges$runtime_release != null) {
                    applyChangesInLocked(deferredChanges$runtime_release);
                }
                boolean z = this.slotTable.getGroupsSize() > 0;
                if (z || !this.abandonSet.isEmpty()) {
                    RememberEventDispatcher rememberEventDispatcher = new RememberEventDispatcher(this.abandonSet);
                    if (z) {
                        this.applier.onBeginChanges();
                        SlotWriter slotWriterOpenWriter = this.slotTable.openWriter();
                        try {
                            ComposerKt.removeCurrentGroup(slotWriterOpenWriter, rememberEventDispatcher);
                            Unit unit = Unit.INSTANCE;
                            slotWriterOpenWriter.close(true);
                            this.applier.clear();
                            this.applier.onEndChanges();
                            rememberEventDispatcher.dispatchRememberObservers();
                        } catch (Throwable th) {
                            slotWriterOpenWriter.close(false);
                            throw th;
                        }
                    }
                    rememberEventDispatcher.dispatchAbandons();
                }
                this.composer.dispose$runtime_release();
            }
            Unit unit2 = Unit.INSTANCE;
        }
        this.parent.unregisterComposition$runtime_release(this);
    }

    @Override // androidx.compose.runtime.Composition
    public boolean getHasInvalidations() {
        boolean z;
        synchronized (this.lock) {
            z = this.invalidations.getSize() > 0;
        }
        return z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.runtime.ControlledComposition
    public void recordModificationsOf(@NotNull Set<? extends Object> set) {
        Object obj;
        Object objPlus;
        do {
            obj = this.pendingModifications.get();
            if (obj == null || Intrinsics.areEqual(obj, CompositionKt.PendingApplyNoModifications)) {
                objPlus = set;
            } else if (obj instanceof Set) {
                objPlus = new Set[]{obj, set};
            } else {
                if (!(obj instanceof Object[])) {
                    throw new IllegalStateException(("corrupt pendingModifications: " + this.pendingModifications).toString());
                }
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.collections.Set<kotlin.Any>>");
                objPlus = ArraysKt___ArraysJvmKt.plus((Set<? extends Object>[]) obj, set);
            }
        } while (!PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.pendingModifications, obj, objPlus));
        if (obj == null) {
            synchronized (this.lock) {
                drainPendingModificationsLocked();
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void prepareCompose(@NotNull Function0<Unit> function0) {
        this.composer.prepareCompose$runtime_release(function0);
    }

    private final void addPendingInvalidationsLocked(Object obj, boolean z) {
        Object obj2 = this.observations.getMap().get(obj);
        if (obj2 == null) {
            return;
        }
        if (obj2 instanceof MutableScatterSet) {
            MutableScatterSet mutableScatterSet = (MutableScatterSet) obj2;
            Object[] objArr = mutableScatterSet.elements;
            long[] jArr = mutableScatterSet.metadata;
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
                            RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) objArr[(i << 3) + i3];
                            if (!this.observationsProcessed.remove(obj, recomposeScopeImpl) && recomposeScopeImpl.invalidateForResult(obj) != InvalidationResult.IGNORED) {
                                if (recomposeScopeImpl.isConditional() && !z) {
                                    this.conditionallyInvalidatedScopes.add(recomposeScopeImpl);
                                } else {
                                    this.invalidatedScopes.add(recomposeScopeImpl);
                                }
                            }
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
        } else {
            RecomposeScopeImpl recomposeScopeImpl2 = (RecomposeScopeImpl) obj2;
            if (this.observationsProcessed.remove(obj, recomposeScopeImpl2) || recomposeScopeImpl2.invalidateForResult(obj) == InvalidationResult.IGNORED) {
                return;
            }
            if (recomposeScopeImpl2.isConditional() && !z) {
                this.conditionallyInvalidatedScopes.add(recomposeScopeImpl2);
            } else {
                this.invalidatedScopes.add(recomposeScopeImpl2);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00e7 A[PHI: r24 r25 r26
  0x00e7: PHI (r24v6 long[]) = (r24v5 long[]), (r24v9 long[]) binds: [B:38:0x00e5, B:35:0x00cd] A[DONT_GENERATE, DONT_INLINE]
  0x00e7: PHI (r25v4 int) = (r25v3 int), (r25v7 int) binds: [B:38:0x00e5, B:35:0x00cd] A[DONT_GENERATE, DONT_INLINE]
  0x00e7: PHI (r26v4 int) = (r26v3 int), (r26v7 int) binds: [B:38:0x00e5, B:35:0x00cd] A[DONT_GENERATE, DONT_INLINE]] */
    private final void cleanUpDerivedStateObservations() {
        long[] jArr;
        int i;
        long[] jArr2;
        int i2;
        int i3;
        int i4;
        Object[] objArr;
        Object[] objArr2;
        MutableScatterMap<Object, Object> map = this.derivedStates.getMap();
        long[] jArr3 = map.metadata;
        int length = jArr3.length - 2;
        long j = 255;
        char c = 7;
        long j2 = -9187201950435737472L;
        int i5 = 8;
        if (length >= 0) {
            int i6 = 0;
            while (true) {
                long j3 = jArr3[i6];
                if ((((~j3) << c) & j3 & j2) != j2) {
                    int i7 = 8 - ((~(i6 - length)) >>> 31);
                    int i8 = 0;
                    while (i8 < i7) {
                        if ((j3 & j) < 128) {
                            int i9 = (i6 << 3) + i8;
                            Object obj = map.keys[i9];
                            Object obj2 = map.values[i9];
                            if (obj2 instanceof MutableScatterSet) {
                                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap.removeScopeIf$lambda$2>");
                                MutableScatterSet mutableScatterSet = (MutableScatterSet) obj2;
                                Object[] objArr3 = mutableScatterSet.elements;
                                long[] jArr4 = mutableScatterSet.metadata;
                                int length2 = jArr4.length - 2;
                                if (length2 >= 0) {
                                    jArr2 = jArr3;
                                    i2 = length;
                                    int i10 = 0;
                                    while (true) {
                                        long j4 = jArr4[i10];
                                        long[] jArr5 = jArr4;
                                        i3 = i6;
                                        if ((((~j4) << c) & j4 & (-9187201950435737472L)) != -9187201950435737472L) {
                                            int i11 = 8 - ((~(i10 - length2)) >>> 31);
                                            int i12 = 0;
                                            while (i12 < i11) {
                                                if ((j4 & 255) < 128) {
                                                    int i13 = (i10 << 3) + i12;
                                                    objArr2 = objArr3;
                                                    if (!this.observations.contains((DerivedState) objArr3[i13])) {
                                                        mutableScatterSet.removeElementAt(i13);
                                                    }
                                                } else {
                                                    objArr2 = objArr3;
                                                }
                                                j4 >>= 8;
                                                i12++;
                                                objArr3 = objArr2;
                                            }
                                            objArr = objArr3;
                                            if (i11 != 8) {
                                                break;
                                            }
                                        } else {
                                            objArr = objArr3;
                                        }
                                        if (i10 == length2) {
                                            break;
                                        }
                                        i10++;
                                        i6 = i3;
                                        jArr4 = jArr5;
                                        objArr3 = objArr;
                                        c = 7;
                                    }
                                } else {
                                    jArr2 = jArr3;
                                    i2 = length;
                                    i3 = i6;
                                }
                                if (mutableScatterSet.isEmpty()) {
                                    map.removeValueAt(i9);
                                }
                            } else {
                                jArr2 = jArr3;
                                i2 = length;
                                i3 = i6;
                                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap.removeScopeIf$lambda$2");
                                if (!this.observations.contains((DerivedState) obj2)) {
                                    map.removeValueAt(i9);
                                }
                            }
                            i4 = 8;
                        } else {
                            jArr2 = jArr3;
                            i2 = length;
                            i3 = i6;
                            i4 = i5;
                        }
                        j3 >>= i4;
                        i8++;
                        i5 = i4;
                        jArr3 = jArr2;
                        length = i2;
                        i6 = i3;
                        j = 255;
                        c = 7;
                    }
                    jArr = jArr3;
                    int i14 = length;
                    int i15 = i6;
                    if (i7 != i5) {
                        break;
                    }
                    length = i14;
                    i = i15;
                } else {
                    jArr = jArr3;
                    i = i6;
                }
                if (i == length) {
                    break;
                }
                i6 = i + 1;
                jArr3 = jArr;
                j = 255;
                c = 7;
                j2 = -9187201950435737472L;
                i5 = 8;
            }
        }
        if (!this.conditionallyInvalidatedScopes.isNotEmpty()) {
            return;
        }
        MutableScatterSet<RecomposeScopeImpl> mutableScatterSet2 = this.conditionallyInvalidatedScopes;
        Object[] objArr4 = mutableScatterSet2.elements;
        long[] jArr6 = mutableScatterSet2.metadata;
        int length3 = jArr6.length - 2;
        if (length3 < 0) {
            return;
        }
        int i16 = 0;
        while (true) {
            long j5 = jArr6[i16];
            if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i17 = 8 - ((~(i16 - length3)) >>> 31);
                for (int i18 = 0; i18 < i17; i18++) {
                    if ((j5 & 255) < 128) {
                        int i19 = (i16 << 3) + i18;
                        if (!((RecomposeScopeImpl) objArr4[i19]).isConditional()) {
                            mutableScatterSet2.removeElementAt(i19);
                        }
                    }
                    j5 >>= 8;
                }
                if (i17 != 8) {
                    return;
                }
            }
            if (i16 == length3) {
                return;
            } else {
                i16++;
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition, androidx.compose.runtime.RecomposeScopeOwner
    public void recordReadOf(@NotNull Object obj) {
        RecomposeScopeImpl currentRecomposeScope$runtime_release;
        long[] jArr;
        int i;
        if (getAreChildrenComposing() || (currentRecomposeScope$runtime_release = this.composer.getCurrentRecomposeScope$runtime_release()) == null) {
            return;
        }
        currentRecomposeScope$runtime_release.setUsed(true);
        if (currentRecomposeScope$runtime_release.recordRead(obj)) {
            return;
        }
        if (obj instanceof StateObjectImpl) {
            ReaderKind.Companion companion = ReaderKind.Companion;
            ((StateObjectImpl) obj).m773recordReadInh_f27i8$runtime_release(ReaderKind.m760constructorimpl(1));
        }
        this.observations.add(obj, currentRecomposeScope$runtime_release);
        if (obj instanceof DerivedState) {
            DerivedState<?> derivedState = (DerivedState) obj;
            DerivedState.Record<?> currentRecord = derivedState.getCurrentRecord();
            this.derivedStates.removeScope(obj);
            ObjectIntMap<StateObject> dependencies = currentRecord.getDependencies();
            Object[] objArr = dependencies.keys;
            long[] jArr2 = dependencies.metadata;
            int length = jArr2.length - 2;
            if (length >= 0) {
                int i2 = 0;
                while (true) {
                    long j = jArr2[i2];
                    if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i3 = 8;
                        int i4 = 8 - ((~(i2 - length)) >>> 31);
                        int i5 = 0;
                        while (i5 < i4) {
                            if ((j & 255) < 128) {
                                StateObject stateObject = (StateObject) objArr[(i2 << 3) + i5];
                                if (stateObject instanceof StateObjectImpl) {
                                    ReaderKind.Companion companion2 = ReaderKind.Companion;
                                    ((StateObjectImpl) stateObject).m773recordReadInh_f27i8$runtime_release(ReaderKind.m760constructorimpl(1));
                                }
                                this.derivedStates.add(stateObject, obj);
                                i = 8;
                            } else {
                                jArr2 = jArr2;
                                i = i3;
                            }
                            j >>= i;
                            i5++;
                            i3 = i;
                            jArr2 = jArr2;
                        }
                        jArr = jArr2;
                        if (i4 != i3) {
                            break;
                        }
                    } else {
                        jArr = jArr2;
                    }
                    if (i2 == length) {
                        break;
                    }
                    i2++;
                    jArr2 = jArr;
                }
            }
            currentRecomposeScope$runtime_release.recordDerivedStateValue(derivedState, currentRecord.getCurrentValue());
        }
    }

    private final void invalidateScopeOfLocked(Object obj) {
        Object obj2 = this.observations.getMap().get(obj);
        if (obj2 == null) {
            return;
        }
        if (obj2 instanceof MutableScatterSet) {
            MutableScatterSet mutableScatterSet = (MutableScatterSet) obj2;
            Object[] objArr = mutableScatterSet.elements;
            long[] jArr = mutableScatterSet.metadata;
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
                            RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) objArr[(i << 3) + i3];
                            if (recomposeScopeImpl.invalidateForResult(obj) == InvalidationResult.IMMINENT) {
                                this.observationsProcessed.add(obj, recomposeScopeImpl);
                            }
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
        } else {
            RecomposeScopeImpl recomposeScopeImpl2 = (RecomposeScopeImpl) obj2;
            if (recomposeScopeImpl2.invalidateForResult(obj) == InvalidationResult.IMMINENT) {
                this.observationsProcessed.add(obj, recomposeScopeImpl2);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0058 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:21:0x005a A[Catch: all -> 0x0066, LOOP:0: B:11:0x0023->B:21:0x005a, LOOP_END, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0012, B:8:0x0016, B:11:0x0023, B:13:0x0033, B:15:0x003f, B:17:0x0048, B:18:0x0052, B:21:0x005a, B:22:0x005d, B:23:0x0062), top: B:29:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:32:0x0062 A[EDGE_INSN: B:32:0x0062->B:23:0x0062 BREAK  A[LOOP:0: B:11:0x0023->B:21:0x005a], SYNTHETIC] */
    @Override // androidx.compose.runtime.ControlledComposition
    public void recordWriteOf(@NotNull Object obj) {
        synchronized (this.lock) {
            invalidateScopeOfLocked(obj);
            Object obj2 = this.derivedStates.getMap().get(obj);
            if (obj2 != null) {
                if (!(obj2 instanceof MutableScatterSet)) {
                    invalidateScopeOfLocked((DerivedState) obj2);
                } else {
                    MutableScatterSet mutableScatterSet = (MutableScatterSet) obj2;
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
                                        invalidateScopeOfLocked((DerivedState) objArr[(i << 3) + i3]);
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
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public boolean recompose() {
        boolean zRecompose$runtime_release;
        synchronized (this.lock) {
            drainPendingModificationsForCompositionLocked();
            try {
                ScopeMap<RecomposeScopeImpl, Object> scopeMapTakeInvalidations = takeInvalidations();
                try {
                    CompositionObserver compositionObserverObserver = observer();
                    if (compositionObserverObserver != null) {
                        Map<RecomposeScopeImpl, Set<Object>> mapAsMap = scopeMapTakeInvalidations.asMap();
                        Intrinsics.checkNotNull(mapAsMap, "null cannot be cast to non-null type kotlin.collections.Map<androidx.compose.runtime.RecomposeScope, kotlin.collections.Set<kotlin.Any>?>");
                        compositionObserverObserver.onBeginComposition(this, mapAsMap);
                    }
                    zRecompose$runtime_release = this.composer.recompose$runtime_release(scopeMapTakeInvalidations);
                    if (!zRecompose$runtime_release) {
                        drainPendingModificationsLocked();
                    }
                    if (compositionObserverObserver != null) {
                        compositionObserverObserver.onEndComposition(this);
                    }
                } catch (Exception e) {
                    this.invalidations = scopeMapTakeInvalidations;
                    throw e;
                }
            } catch (Throwable th) {
                try {
                    if (!this.abandonSet.isEmpty()) {
                        new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
                    }
                    throw th;
                } catch (Exception e2) {
                    abandonChanges();
                    throw e2;
                }
            }
        }
        return zRecompose$runtime_release;
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void disposeUnusedMovableContent(@NotNull MovableContentState movableContentState) {
        RememberEventDispatcher rememberEventDispatcher = new RememberEventDispatcher(this.abandonSet);
        SlotWriter slotWriterOpenWriter = movableContentState.getSlotTable$runtime_release().openWriter();
        try {
            ComposerKt.removeCurrentGroup(slotWriterOpenWriter, rememberEventDispatcher);
            Unit unit = Unit.INSTANCE;
            slotWriterOpenWriter.close(true);
            rememberEventDispatcher.dispatchRememberObservers();
        } catch (Throwable th) {
            slotWriterOpenWriter.close(false);
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:102:0x01da  */
    private final void applyChangesInLocked(ChangeList changeList) throws Throwable {
        RememberEventDispatcher rememberEventDispatcher;
        long[] jArr;
        int i;
        RememberEventDispatcher rememberEventDispatcher2;
        long[] jArr2;
        int i2;
        int i3;
        char c;
        long j;
        int i4;
        boolean zIsEmpty;
        long[] jArr3;
        long[] jArr4;
        CompositionImpl compositionImpl = this;
        RememberEventDispatcher rememberEventDispatcher3 = new RememberEventDispatcher(compositionImpl.abandonSet);
        try {
            if (changeList.isEmpty()) {
                if (compositionImpl.lateChanges.isEmpty()) {
                    rememberEventDispatcher3.dispatchAbandons();
                    return;
                }
                return;
            }
            Trace trace = Trace.INSTANCE;
            Object objBeginSection = trace.beginSection("Compose:applyChanges");
            compositionImpl.applier.onBeginChanges();
            SlotWriter slotWriterOpenWriter = compositionImpl.slotTable.openWriter();
            int i5 = 0;
            try {
                changeList.executeAndFlushAllPendingChanges(compositionImpl.applier, slotWriterOpenWriter, rememberEventDispatcher3);
                Unit unit = Unit.INSTANCE;
                slotWriterOpenWriter.close(true);
                compositionImpl.applier.onEndChanges();
                trace.endSection(objBeginSection);
                rememberEventDispatcher3.dispatchRememberObservers();
                rememberEventDispatcher3.dispatchSideEffects();
                if (compositionImpl.pendingInvalidScopes) {
                    try {
                        try {
                            Object objBeginSection2 = trace.beginSection("Compose:unobserve");
                            try {
                                compositionImpl.pendingInvalidScopes = false;
                                MutableScatterMap<Object, Object> map = compositionImpl.observations.getMap();
                                long[] jArr5 = map.metadata;
                                int length = jArr5.length - 2;
                                if (length >= 0) {
                                    int i6 = 0;
                                    while (true) {
                                        long j2 = jArr5[i6];
                                        char c2 = 7;
                                        long j3 = -9187201950435737472L;
                                        if ((((~j2) << 7) & j2 & (-9187201950435737472L)) != -9187201950435737472L) {
                                            int i7 = 8;
                                            int i8 = 8 - ((~(i6 - length)) >>> 31);
                                            int i9 = i5;
                                            while (i9 < i8) {
                                                if ((j2 & 255) < 128) {
                                                    int i10 = (i6 << 3) + i9;
                                                    Object obj = map.keys[i10];
                                                    Object obj2 = map.values[i10];
                                                    if (obj2 instanceof MutableScatterSet) {
                                                        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap.removeScopeIf$lambda$2>");
                                                        MutableScatterSet mutableScatterSet = (MutableScatterSet) obj2;
                                                        Object[] objArr = mutableScatterSet.elements;
                                                        long[] jArr6 = mutableScatterSet.metadata;
                                                        int length2 = jArr6.length - 2;
                                                        if (length2 >= 0) {
                                                            rememberEventDispatcher2 = rememberEventDispatcher3;
                                                            jArr2 = jArr5;
                                                            int i11 = 0;
                                                            while (true) {
                                                                try {
                                                                    long j4 = jArr6[i11];
                                                                    i2 = length;
                                                                    i3 = i6;
                                                                    c = 7;
                                                                    j = -9187201950435737472L;
                                                                    if ((((~j4) << 7) & j4 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                                        int i12 = 8 - ((~(i11 - length2)) >>> 31);
                                                                        int i13 = 0;
                                                                        while (i13 < i12) {
                                                                            if ((j4 & 255) < 128) {
                                                                                jArr4 = jArr6;
                                                                                int i14 = (i11 << 3) + i13;
                                                                                if (!((RecomposeScopeImpl) objArr[i14]).getValid()) {
                                                                                    mutableScatterSet.removeElementAt(i14);
                                                                                }
                                                                            } else {
                                                                                jArr4 = jArr6;
                                                                            }
                                                                            j4 >>= 8;
                                                                            i13++;
                                                                            jArr6 = jArr4;
                                                                        }
                                                                        jArr3 = jArr6;
                                                                        if (i12 != 8) {
                                                                            break;
                                                                        }
                                                                    } else {
                                                                        jArr3 = jArr6;
                                                                    }
                                                                    if (i11 == length2) {
                                                                        break;
                                                                    }
                                                                    i11++;
                                                                    length = i2;
                                                                    i6 = i3;
                                                                    jArr6 = jArr3;
                                                                } catch (Throwable th) {
                                                                    th = th;
                                                                    Trace.INSTANCE.endSection(objBeginSection2);
                                                                    throw th;
                                                                }
                                                            }
                                                        } else {
                                                            rememberEventDispatcher2 = rememberEventDispatcher3;
                                                            jArr2 = jArr5;
                                                            i2 = length;
                                                            i3 = i6;
                                                            j = -9187201950435737472L;
                                                            c = 7;
                                                        }
                                                        zIsEmpty = mutableScatterSet.isEmpty();
                                                    } else {
                                                        rememberEventDispatcher2 = rememberEventDispatcher3;
                                                        jArr2 = jArr5;
                                                        i2 = length;
                                                        i3 = i6;
                                                        c = c2;
                                                        j = -9187201950435737472L;
                                                        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap.removeScopeIf$lambda$2");
                                                        zIsEmpty = !((RecomposeScopeImpl) obj2).getValid();
                                                    }
                                                    if (zIsEmpty) {
                                                        map.removeValueAt(i10);
                                                    }
                                                    i4 = 8;
                                                } else {
                                                    rememberEventDispatcher2 = rememberEventDispatcher3;
                                                    jArr2 = jArr5;
                                                    i2 = length;
                                                    i3 = i6;
                                                    c = c2;
                                                    j = j3;
                                                    i4 = i7;
                                                }
                                                j2 >>= i4;
                                                i9++;
                                                i7 = i4;
                                                j3 = j;
                                                c2 = c;
                                                jArr5 = jArr2;
                                                rememberEventDispatcher3 = rememberEventDispatcher2;
                                                length = i2;
                                                i6 = i3;
                                            }
                                            rememberEventDispatcher = rememberEventDispatcher3;
                                            jArr = jArr5;
                                            int i15 = length;
                                            int i16 = i6;
                                            if (i8 != i7) {
                                                break;
                                            }
                                            length = i15;
                                            i = i16;
                                        } else {
                                            rememberEventDispatcher = rememberEventDispatcher3;
                                            jArr = jArr5;
                                            i = i6;
                                        }
                                        if (i == length) {
                                            break;
                                        }
                                        i6 = i + 1;
                                        jArr5 = jArr;
                                        rememberEventDispatcher3 = rememberEventDispatcher;
                                        i5 = 0;
                                    }
                                } else {
                                    rememberEventDispatcher = rememberEventDispatcher3;
                                }
                                cleanUpDerivedStateObservations();
                                Unit unit2 = Unit.INSTANCE;
                                Trace.INSTANCE.endSection(objBeginSection2);
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            rememberEventDispatcher3 = rememberEventDispatcher3;
                            compositionImpl = this;
                            if (compositionImpl.lateChanges.isEmpty()) {
                                rememberEventDispatcher3.dispatchAbandons();
                            }
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        compositionImpl = this;
                        if (compositionImpl.lateChanges.isEmpty()) {
                            rememberEventDispatcher3.dispatchAbandons();
                        }
                        throw th;
                    }
                } else {
                    rememberEventDispatcher = rememberEventDispatcher3;
                }
                if (this.lateChanges.isEmpty()) {
                    rememberEventDispatcher.dispatchAbandons();
                    return;
                }
                return;
            } catch (Throwable th5) {
                try {
                    slotWriterOpenWriter.close(false);
                    throw th5;
                } catch (Throwable th6) {
                    th = th6;
                    try {
                        Trace.INSTANCE.endSection(objBeginSection);
                        throw th;
                    } catch (Throwable th7) {
                        th = th7;
                    }
                }
            }
        } catch (Throwable th8) {
            th = th8;
            rememberEventDispatcher3 = rememberEventDispatcher3;
        }
        if (compositionImpl.lateChanges.isEmpty()) {
            rememberEventDispatcher3.dispatchAbandons();
        }
        throw th;
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void applyChanges() {
        synchronized (this.lock) {
            try {
                applyChangesInLocked(this.changes);
                drainPendingModificationsLocked();
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                try {
                    if (!this.abandonSet.isEmpty()) {
                        new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
                    }
                    throw th;
                } catch (Exception e) {
                    abandonChanges();
                    throw e;
                }
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void applyLateChanges() {
        synchronized (this.lock) {
            try {
                if (this.lateChanges.isNotEmpty()) {
                    applyChangesInLocked(this.lateChanges);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                try {
                    if (!this.abandonSet.isEmpty()) {
                        new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
                    }
                    throw th;
                } catch (Exception e) {
                    abandonChanges();
                    throw e;
                }
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void changesApplied() {
        synchronized (this.lock) {
            try {
                this.composer.changesApplied$runtime_release();
                if (!this.abandonSet.isEmpty()) {
                    new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                try {
                    if (!this.abandonSet.isEmpty()) {
                        new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
                    }
                    throw th;
                } catch (Exception e) {
                    abandonChanges();
                    throw e;
                }
            }
        }
    }

    private final <T> T guardInvalidationsLocked(Function1<? super ScopeMap<RecomposeScopeImpl, Object>, ? extends T> function1) throws Exception {
        ScopeMap<RecomposeScopeImpl, Object> scopeMapTakeInvalidations = takeInvalidations();
        try {
            return function1.invoke(scopeMapTakeInvalidations);
        } catch (Exception e) {
            this.invalidations = scopeMapTakeInvalidations;
            throw e;
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void abandonChanges() {
        this.pendingModifications.set(null);
        this.changes.clear();
        this.lateChanges.clear();
        if (this.abandonSet.isEmpty()) {
            return;
        }
        new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void invalidateAll() {
        synchronized (this.lock) {
            for (Object obj : this.slotTable.getSlots()) {
                RecomposeScopeImpl recomposeScopeImpl = obj instanceof RecomposeScopeImpl ? (RecomposeScopeImpl) obj : null;
                if (recomposeScopeImpl != null) {
                    recomposeScopeImpl.invalidate();
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void verifyConsistent() {
        synchronized (this.lock) {
            if (!isComposing()) {
                this.composer.verifyConsistent$runtime_release();
                this.slotTable.verifyWellFormed();
                validateRecomposeScopeAnchors(this.slotTable);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public <R> R delegateInvalidations(@Nullable ControlledComposition controlledComposition, int i, @NotNull Function0<? extends R> function0) {
        if (controlledComposition != null && !Intrinsics.areEqual(controlledComposition, this) && i >= 0) {
            this.invalidationDelegate = (CompositionImpl) controlledComposition;
            this.invalidationDelegateGroup = i;
            try {
                return function0.invoke();
            } finally {
                this.invalidationDelegate = null;
                this.invalidationDelegateGroup = 0;
            }
        }
        return function0.invoke();
    }

    @Override // androidx.compose.runtime.RecomposeScopeOwner
    public InvalidationResult invalidate(@NotNull RecomposeScopeImpl recomposeScopeImpl, @Nullable Object obj) {
        CompositionImpl compositionImpl;
        if (recomposeScopeImpl.getDefaultsInScope()) {
            recomposeScopeImpl.setDefaultsInvalid(true);
        }
        Anchor anchor = recomposeScopeImpl.getAnchor();
        if (anchor == null || !anchor.getValid()) {
            return InvalidationResult.IGNORED;
        }
        if (!this.slotTable.ownsAnchor(anchor)) {
            synchronized (this.lock) {
                compositionImpl = this.invalidationDelegate;
            }
            if (compositionImpl != null && compositionImpl.tryImminentInvalidation(recomposeScopeImpl, obj)) {
                return InvalidationResult.IMMINENT;
            }
            return InvalidationResult.IGNORED;
        }
        if (!recomposeScopeImpl.getCanRecompose()) {
            return InvalidationResult.IGNORED;
        }
        return invalidateChecked(recomposeScopeImpl, anchor, obj);
    }

    @Override // androidx.compose.runtime.RecomposeScopeOwner
    public void recomposeScopeReleased(@NotNull RecomposeScopeImpl recomposeScopeImpl) {
        this.pendingInvalidScopes = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.runtime.CompositionServices
    public <T> T getCompositionService(@NotNull CompositionServiceKey<T> compositionServiceKey) {
        if (Intrinsics.areEqual(compositionServiceKey, CompositionKt.getCompositionImplServiceKey())) {
            return this;
        }
        return null;
    }

    private final boolean tryImminentInvalidation(RecomposeScopeImpl recomposeScopeImpl, Object obj) {
        return isComposing() && this.composer.tryImminentInvalidation$runtime_release(recomposeScopeImpl, obj);
    }

    /* JADX WARN: Code duplicated, block: B:45:0x00a0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:46:0x00a2 A[Catch: all -> 0x00c8, LOOP:0: B:31:0x0063->B:46:0x00a2, LOOP_END, TryCatch #0 {, blocks: (B:4:0x000b, B:6:0x0010, B:12:0x001f, B:14:0x0025, B:17:0x0029, B:19:0x002f, B:21:0x003a, B:23:0x003e, B:24:0x0047, B:26:0x0053, B:28:0x0057, B:31:0x0063, B:33:0x0073, B:35:0x007f, B:37:0x0089, B:42:0x0098, B:46:0x00a2, B:47:0x00a5, B:50:0x00aa), top: B:63:0x000b }] */
    /* JADX WARN: Code duplicated, block: B:50:0x00aa A[Catch: all -> 0x00c8, EDGE_INSN: B:50:0x00aa->B:51:0x00af BREAK  A[LOOP:0: B:31:0x0063->B:46:0x00a2], TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x000b, B:6:0x0010, B:12:0x001f, B:14:0x0025, B:17:0x0029, B:19:0x002f, B:21:0x003a, B:23:0x003e, B:24:0x0047, B:26:0x0053, B:28:0x0057, B:31:0x0063, B:33:0x0073, B:35:0x007f, B:37:0x0089, B:42:0x0098, B:46:0x00a2, B:47:0x00a5, B:50:0x00aa), top: B:63:0x000b }] */
    /* JADX WARN: Code duplicated, block: B:66:0x00aa A[SYNTHETIC] */
    private final InvalidationResult invalidateChecked(RecomposeScopeImpl recomposeScopeImpl, Anchor anchor, Object obj) {
        int i;
        synchronized (this.lock) {
            CompositionImpl compositionImpl = this.invalidationDelegate;
            CompositionImpl compositionImpl2 = null;
            if (compositionImpl != null) {
                if (!this.slotTable.groupContainsAnchor(this.invalidationDelegateGroup, anchor)) {
                    compositionImpl = null;
                }
                compositionImpl2 = compositionImpl;
            }
            if (compositionImpl2 == null) {
                if (tryImminentInvalidation(recomposeScopeImpl, obj)) {
                    return InvalidationResult.IMMINENT;
                }
                CompositionObserver compositionObserverObserver = observer();
                if (obj == null) {
                    this.invalidations.set(recomposeScopeImpl, ScopeInvalidated.INSTANCE);
                } else if (compositionObserverObserver == null && !(obj instanceof DerivedState)) {
                    this.invalidations.set(recomposeScopeImpl, ScopeInvalidated.INSTANCE);
                } else {
                    Object obj2 = this.invalidations.getMap().get(recomposeScopeImpl);
                    if (obj2 == null) {
                        this.invalidations.add(recomposeScopeImpl, obj);
                        break;
                    }
                    if (!(obj2 instanceof MutableScatterSet)) {
                        if (obj2 != ScopeInvalidated.INSTANCE) {
                            this.invalidations.add(recomposeScopeImpl, obj);
                            break;
                        }
                    } else {
                        MutableScatterSet mutableScatterSet = (MutableScatterSet) obj2;
                        Object[] objArr = mutableScatterSet.elements;
                        long[] jArr = mutableScatterSet.metadata;
                        int length = jArr.length - 2;
                        if (length < 0) {
                            this.invalidations.add(recomposeScopeImpl, obj);
                            break;
                        }
                        int i2 = 0;
                        loop0: while (true) {
                            long j = jArr[i2];
                            if ((((~j) << 7) & j & (-9187201950435737472L)) == -9187201950435737472L) {
                                if (i2 == length) {
                                    this.invalidations.add(recomposeScopeImpl, obj);
                                    break;
                                }
                                i2++;
                            } else {
                                int i3 = 8;
                                int i4 = 8 - ((~(i2 - length)) >>> 31);
                                int i5 = 0;
                                while (i5 < i4) {
                                    if ((j & 255) >= 128) {
                                        i = i3;
                                    } else {
                                        if (objArr[(i2 << 3) + i5] == ScopeInvalidated.INSTANCE) {
                                            break loop0;
                                        }
                                        i = 8;
                                    }
                                    j >>= i;
                                    i5++;
                                    i3 = i;
                                }
                                if (i4 == i3) {
                                    if (i2 == length) {
                                        i2++;
                                    }
                                }
                                this.invalidations.add(recomposeScopeImpl, obj);
                                break;
                            }
                        }
                    }
                }
            }
            if (compositionImpl2 != null) {
                return compositionImpl2.invalidateChecked(recomposeScopeImpl, anchor, obj);
            }
            this.parent.invalidate$runtime_release(this);
            return isComposing() ? InvalidationResult.DEFERRED : InvalidationResult.SCHEDULED;
        }
    }

    public final void removeObservation$runtime_release(@NotNull Object obj, @NotNull RecomposeScopeImpl recomposeScopeImpl) {
        this.observations.remove(obj, recomposeScopeImpl);
    }

    public final void removeDerivedStateObservation$runtime_release(@NotNull DerivedState<?> derivedState) {
        if (this.observations.contains(derivedState)) {
            return;
        }
        this.derivedStates.removeScope(derivedState);
    }

    private final ScopeMap<RecomposeScopeImpl, Object> takeInvalidations() {
        ScopeMap<RecomposeScopeImpl, Object> scopeMap = this.invalidations;
        this.invalidations = new ScopeMap<>();
        return scopeMap;
    }

    private final void validateRecomposeScopeAnchors(SlotTable slotTable) {
        Object[] slots = slotTable.getSlots();
        ArrayList arrayList = new ArrayList();
        for (Object obj : slots) {
            RecomposeScopeImpl recomposeScopeImpl = obj instanceof RecomposeScopeImpl ? (RecomposeScopeImpl) obj : null;
            if (recomposeScopeImpl != null) {
                arrayList.add(recomposeScopeImpl);
            }
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            RecomposeScopeImpl recomposeScopeImpl2 = (RecomposeScopeImpl) arrayList.get(i);
            Anchor anchor = recomposeScopeImpl2.getAnchor();
            if (anchor != null && !slotTable.slotsOf$runtime_release(anchor.toIndexFor(slotTable)).contains(recomposeScopeImpl2)) {
                PreconditionsKt.throwIllegalStateException("Misaligned anchor " + anchor + " in scope " + recomposeScopeImpl2 + " encountered, scope found at " + ArraysKt___ArraysKt.indexOf((RecomposeScopeImpl[]) slotTable.getSlots(), recomposeScopeImpl2));
            }
        }
    }

    private final <T> T trackAbandonedValues(Function0<? extends T> function0) {
        try {
            T tInvoke = function0.invoke();
            InlineMarker.finallyStart(1);
            return tInvoke;
        } finally {
            InlineMarker.finallyStart(1);
            if (!this.abandonSet.isEmpty()) {
                new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
            }
            InlineMarker.finallyEnd(1);
        }
    }

    private final CompositionObserver observer() {
        CompositionObserverHolder compositionObserverHolder = this.observerHolder;
        if (compositionObserverHolder.getRoot()) {
            return compositionObserverHolder.getObserver();
        }
        CompositionObserverHolder observerHolder$runtime_release = this.parent.getObserverHolder$runtime_release();
        CompositionObserver observer = observerHolder$runtime_release != null ? observerHolder$runtime_release.getObserver() : null;
        if (!Intrinsics.areEqual(observer, compositionObserverHolder.getObserver())) {
            compositionObserverHolder.setObserver(observer);
        }
        return observer;
    }

    @Override // androidx.compose.runtime.ReusableComposition
    public void deactivate() {
        synchronized (this.lock) {
            boolean z = this.slotTable.getGroupsSize() > 0;
            if (z || !this.abandonSet.isEmpty()) {
                Trace trace = Trace.INSTANCE;
                Object objBeginSection = trace.beginSection("Compose:deactivate");
                try {
                    RememberEventDispatcher rememberEventDispatcher = new RememberEventDispatcher(this.abandonSet);
                    if (z) {
                        this.applier.onBeginChanges();
                        SlotWriter slotWriterOpenWriter = this.slotTable.openWriter();
                        try {
                            ComposerKt.deactivateCurrentGroup(slotWriterOpenWriter, rememberEventDispatcher);
                            Unit unit = Unit.INSTANCE;
                            slotWriterOpenWriter.close(true);
                            this.applier.onEndChanges();
                            rememberEventDispatcher.dispatchRememberObservers();
                        } catch (Throwable th) {
                            slotWriterOpenWriter.close(false);
                            throw th;
                        }
                    }
                    rememberEventDispatcher.dispatchAbandons();
                    Unit unit2 = Unit.INSTANCE;
                    trace.endSection(objBeginSection);
                } catch (Throwable th2) {
                    Trace.INSTANCE.endSection(objBeginSection);
                    throw th2;
                }
            }
            this.observations.clear();
            this.derivedStates.clear();
            this.invalidations.clear();
            this.changes.clear();
            this.lateChanges.clear();
            this.composer.deactivate$runtime_release();
            Unit unit3 = Unit.INSTANCE;
        }
    }

    public final int composerStacksSizes$runtime_release() {
        return this.composer.stacksSize$runtime_release();
    }

    /* JADX INFO: loaded from: classes3.dex */
    static final class RememberEventDispatcher implements RememberManager {
        private final Set<RememberObserver> abandoning;
        private MutableScatterSet<ComposeNodeLifecycleCallback> releasing;
        private final List<RememberObserver> remembering = new ArrayList();
        private final List<Object> leaving = new ArrayList();
        private final List<Function0<Unit>> sideEffects = new ArrayList();
        private final List<Object> pending = new ArrayList();
        private final MutableIntList priorities = new MutableIntList(0, 1, null);
        private final MutableIntList afters = new MutableIntList(0, 1, null);

        public RememberEventDispatcher(@NotNull Set<RememberObserver> set) {
            this.abandoning = set;
        }

        @Override // androidx.compose.runtime.RememberManager
        public void remembering(@NotNull RememberObserver rememberObserver) {
            this.remembering.add(rememberObserver);
        }

        @Override // androidx.compose.runtime.RememberManager
        public void forgetting(@NotNull RememberObserver rememberObserver, int i, int i2, int i3) {
            recordLeaving(rememberObserver, i, i2, i3);
        }

        @Override // androidx.compose.runtime.RememberManager
        public void sideEffect(@NotNull Function0<Unit> function0) {
            this.sideEffects.add(function0);
        }

        @Override // androidx.compose.runtime.RememberManager
        public void deactivating(@NotNull ComposeNodeLifecycleCallback composeNodeLifecycleCallback, int i, int i2, int i3) {
            recordLeaving(composeNodeLifecycleCallback, i, i2, i3);
        }

        @Override // androidx.compose.runtime.RememberManager
        public void releasing(@NotNull ComposeNodeLifecycleCallback composeNodeLifecycleCallback, int i, int i2, int i3) {
            MutableScatterSet<ComposeNodeLifecycleCallback> mutableScatterSetMutableScatterSetOf = this.releasing;
            if (mutableScatterSetMutableScatterSetOf == null) {
                mutableScatterSetMutableScatterSetOf = ScatterSetKt.mutableScatterSetOf();
                this.releasing = mutableScatterSetMutableScatterSetOf;
            }
            mutableScatterSetMutableScatterSetOf.plusAssign(composeNodeLifecycleCallback);
            recordLeaving(composeNodeLifecycleCallback, i, i2, i3);
        }

        public final void dispatchRememberObservers() {
            processPendingLeaving(Integer.MIN_VALUE);
            if (!this.leaving.isEmpty()) {
                Object objBeginSection = Trace.INSTANCE.beginSection("Compose:onForgotten");
                try {
                    MutableScatterSet<ComposeNodeLifecycleCallback> mutableScatterSet = this.releasing;
                    for (int size = this.leaving.size() - 1; -1 < size; size--) {
                        Object obj = this.leaving.get(size);
                        if (obj instanceof RememberObserver) {
                            this.abandoning.remove(obj);
                            ((RememberObserver) obj).onForgotten();
                        }
                        if (obj instanceof ComposeNodeLifecycleCallback) {
                            if (mutableScatterSet != null && mutableScatterSet.contains((ComposeNodeLifecycleCallback) obj)) {
                                ((ComposeNodeLifecycleCallback) obj).onRelease();
                            } else {
                                ((ComposeNodeLifecycleCallback) obj).onDeactivate();
                            }
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                    Trace.INSTANCE.endSection(objBeginSection);
                } catch (Throwable th) {
                    Trace.INSTANCE.endSection(objBeginSection);
                    throw th;
                }
            }
            if (this.remembering.isEmpty()) {
                return;
            }
            Object objBeginSection2 = Trace.INSTANCE.beginSection("Compose:onRemembered");
            try {
                List<RememberObserver> list = this.remembering;
                int size2 = list.size();
                for (int i = 0; i < size2; i++) {
                    RememberObserver rememberObserver = list.get(i);
                    this.abandoning.remove(rememberObserver);
                    rememberObserver.onRemembered();
                }
                Unit unit2 = Unit.INSTANCE;
            } finally {
                Trace.INSTANCE.endSection(objBeginSection2);
            }
        }

        public final void dispatchSideEffects() {
            if (this.sideEffects.isEmpty()) {
                return;
            }
            Object objBeginSection = Trace.INSTANCE.beginSection("Compose:sideeffects");
            try {
                List<Function0<Unit>> list = this.sideEffects;
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    list.get(i).invoke();
                }
                this.sideEffects.clear();
                Unit unit = Unit.INSTANCE;
            } finally {
                Trace.INSTANCE.endSection(objBeginSection);
            }
        }

        public final void dispatchAbandons() {
            if (this.abandoning.isEmpty()) {
                return;
            }
            Object objBeginSection = Trace.INSTANCE.beginSection("Compose:abandons");
            try {
                Iterator<RememberObserver> it2 = this.abandoning.iterator();
                while (it2.hasNext()) {
                    RememberObserver next = it2.next();
                    it2.remove();
                    next.onAbandoned();
                }
                Unit unit = Unit.INSTANCE;
            } finally {
                Trace.INSTANCE.endSection(objBeginSection);
            }
        }

        private final void recordLeaving(Object obj, int i, int i2, int i3) {
            processPendingLeaving(i);
            if (i3 >= 0 && i3 < i) {
                this.pending.add(obj);
                this.priorities.add(i2);
                this.afters.add(i3);
                return;
            }
            this.leaving.add(obj);
        }

        private final void processPendingLeaving(int i) {
            if (this.pending.isEmpty()) {
                return;
            }
            int i2 = 0;
            List listMutableListOf = null;
            MutableIntList mutableIntList = null;
            MutableIntList mutableIntList2 = null;
            int i3 = 0;
            while (i3 < this.afters.getSize()) {
                if (i <= this.afters.get(i3)) {
                    Object objRemove = this.pending.remove(i3);
                    int iRemoveAt = this.afters.removeAt(i3);
                    int iRemoveAt2 = this.priorities.removeAt(i3);
                    if (listMutableListOf == null) {
                        listMutableListOf = CollectionsKt__CollectionsKt.mutableListOf(objRemove);
                        mutableIntList2 = new MutableIntList(0, 1, null);
                        mutableIntList2.add(iRemoveAt);
                        mutableIntList = new MutableIntList(0, 1, null);
                        mutableIntList.add(iRemoveAt2);
                    } else {
                        Intrinsics.checkNotNull(mutableIntList, "null cannot be cast to non-null type androidx.collection.MutableIntList");
                        Intrinsics.checkNotNull(mutableIntList2, "null cannot be cast to non-null type androidx.collection.MutableIntList");
                        listMutableListOf.add(objRemove);
                        mutableIntList2.add(iRemoveAt);
                        mutableIntList.add(iRemoveAt2);
                    }
                } else {
                    i3++;
                }
            }
            if (listMutableListOf != null) {
                Intrinsics.checkNotNull(mutableIntList, "null cannot be cast to non-null type androidx.collection.MutableIntList");
                Intrinsics.checkNotNull(mutableIntList2, "null cannot be cast to non-null type androidx.collection.MutableIntList");
                int size = listMutableListOf.size();
                while (i2 < size - 1) {
                    int i4 = i2 + 1;
                    int size2 = listMutableListOf.size();
                    for (int i5 = i4; i5 < size2; i5++) {
                        int i6 = mutableIntList2.get(i2);
                        int i7 = mutableIntList2.get(i5);
                        if (i6 < i7 || (i7 == i6 && mutableIntList.get(i2) < mutableIntList.get(i5))) {
                            CompositionKt.swap(listMutableListOf, i2, i5);
                            CompositionKt.swap(mutableIntList, i2, i5);
                            CompositionKt.swap(mutableIntList2, i2, i5);
                        }
                    }
                    i2 = i4;
                }
                this.leaving.addAll(listMutableListOf);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0057 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:21:0x0059 A[LOOP:0: B:7:0x0016->B:21:0x0059, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:34:0x007d A[SYNTHETIC] */
    @Override // androidx.compose.runtime.ControlledComposition
    public boolean observesAnyOf(@NotNull Set<? extends Object> set) {
        if (set instanceof ScatterSetWrapper) {
            ScatterSet set$runtime_release = ((ScatterSetWrapper) set).getSet$runtime_release();
            Object[] objArr = set$runtime_release.elements;
            long[] jArr = set$runtime_release.metadata;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i = 0;
                loop0: while (true) {
                    long j = jArr[i];
                    if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i2 = 8 - ((~(i - length)) >>> 31);
                        for (int i3 = 0; i3 < i2; i3++) {
                            if ((255 & j) < 128) {
                                Object obj = objArr[(i << 3) + i3];
                                if (this.observations.contains(obj) || this.derivedStates.contains(obj)) {
                                    break loop0;
                                }
                            }
                            j >>= 8;
                        }
                        if (i2 == 8) {
                            if (i != length) {
                                i++;
                            }
                        }
                    } else if (i != length) {
                        i++;
                    }
                }
                return true;
            }
        } else {
            for (Object obj2 : set) {
                if (this.observations.contains(obj2) || this.derivedStates.contains(obj2)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:117:0x028d A[PHI: r16 r25 r26 r34 r35
  0x028d: PHI (r16v16 long[]) = (r16v15 long[]), (r16v15 long[]), (r16v17 long[]) binds: [B:114:0x0285, B:116:0x028b, B:111:0x026f] A[DONT_GENERATE, DONT_INLINE]
  0x028d: PHI (r25v12 int) = (r25v11 int), (r25v11 int), (r25v14 int) binds: [B:114:0x0285, B:116:0x028b, B:111:0x026f] A[DONT_GENERATE, DONT_INLINE]
  0x028d: PHI (r26v13 long) = (r26v12 long), (r26v12 long), (r26v15 long) binds: [B:114:0x0285, B:116:0x028b, B:111:0x026f] A[DONT_GENERATE, DONT_INLINE]
  0x028d: PHI (r34v20 java.lang.String) = (r34v19 java.lang.String), (r34v19 java.lang.String), (r34v21 java.lang.String) binds: [B:114:0x0285, B:116:0x028b, B:111:0x026f] A[DONT_GENERATE, DONT_INLINE]
  0x028d: PHI (r35v13 int) = (r35v12 int), (r35v12 int), (r35v15 int) binds: [B:114:0x0285, B:116:0x028b, B:111:0x026f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:181:0x00d4 A[EDGE_INSN: B:181:0x00d4->B:37:0x00d4 BREAK  A[LOOP:2: B:23:0x0074->B:34:0x00b8], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:222:0x0112 A[EDGE_INSN: B:222:0x0112->B:217:0x0112 BREAK  A[LOOP:13: B:59:0x0147->B:70:0x0183], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:33:0x00b6 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:34:0x00b8 A[LOOP:2: B:23:0x0074->B:34:0x00b8, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:69:0x0181 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:70:0x0183 A[LOOP:13: B:59:0x0147->B:70:0x0183, LOOP_END] */
    private final void addPendingInvalidationsLocked(Set<? extends Object> set, boolean z) {
        String str;
        long[] jArr;
        int i;
        String str2;
        long[] jArr2;
        int i2;
        int i3;
        int i4;
        boolean zContains;
        Object[] objArr;
        long[] jArr3;
        Object[] objArr2;
        long[] jArr4;
        String str3;
        long[] jArr5;
        int i5;
        String str4;
        long[] jArr6;
        int i6;
        int i7;
        long j;
        long[] jArr7;
        Object[] objArr3;
        long[] jArr8;
        Object[] objArr4;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        char c = 7;
        long j2 = -9187201950435737472L;
        int i14 = 8;
        if (set instanceof ScatterSetWrapper) {
            ScatterSet set$runtime_release = ((ScatterSetWrapper) set).getSet$runtime_release();
            Object[] objArr5 = set$runtime_release.elements;
            long[] jArr9 = set$runtime_release.metadata;
            int length = jArr9.length - 2;
            if (length >= 0) {
                int i15 = 0;
                while (true) {
                    long j3 = jArr9[i15];
                    if ((((~j3) << c) & j3 & j2) != j2) {
                        int i16 = 8 - ((~(i15 - length)) >>> 31);
                        int i17 = 0;
                        while (i17 < i16) {
                            if ((j3 & 255) < 128) {
                                Object obj = objArr5[(i15 << 3) + i17];
                                if (obj instanceof RecomposeScopeImpl) {
                                    ((RecomposeScopeImpl) obj).invalidateForResult(null);
                                } else {
                                    addPendingInvalidationsLocked(obj, z);
                                    Object obj2 = this.derivedStates.getMap().get(obj);
                                    if (obj2 != null) {
                                        if (obj2 instanceof MutableScatterSet) {
                                            MutableScatterSet mutableScatterSet = (MutableScatterSet) obj2;
                                            Object[] objArr6 = mutableScatterSet.elements;
                                            long[] jArr10 = mutableScatterSet.metadata;
                                            int length2 = jArr10.length - 2;
                                            if (length2 >= 0) {
                                                i11 = length;
                                                i12 = i15;
                                                int i18 = 0;
                                                while (true) {
                                                    long j4 = jArr10[i18];
                                                    i9 = i16;
                                                    i10 = i17;
                                                    if ((((~j4) << c) & j4 & (-9187201950435737472L)) == -9187201950435737472L) {
                                                        if (i18 != length2) {
                                                            break;
                                                            break;
                                                        }
                                                        i18++;
                                                        i16 = i9;
                                                        i17 = i10;
                                                        c = 7;
                                                    } else {
                                                        int i19 = 8 - ((~(i18 - length2)) >>> 31);
                                                        for (int i20 = 0; i20 < i19; i20++) {
                                                            if ((j4 & 255) < 128) {
                                                                addPendingInvalidationsLocked((DerivedState) objArr6[(i18 << 3) + i20], z);
                                                            }
                                                            j4 >>= 8;
                                                        }
                                                        if (i19 != 8) {
                                                            break;
                                                        }
                                                        if (i18 != length2) {
                                                            break;
                                                        }
                                                        i18++;
                                                        i16 = i9;
                                                        i17 = i10;
                                                        c = 7;
                                                    }
                                                }
                                            }
                                        } else {
                                            i9 = i16;
                                            i10 = i17;
                                            i11 = length;
                                            i12 = i15;
                                            addPendingInvalidationsLocked((DerivedState) obj2, z);
                                        }
                                    }
                                    i13 = 8;
                                }
                                i9 = i16;
                                i10 = i17;
                                i11 = length;
                                i12 = i15;
                                i13 = 8;
                            } else {
                                i9 = i16;
                                i10 = i17;
                                i11 = length;
                                i12 = i15;
                                i13 = i14;
                            }
                            j3 >>= i13;
                            i17 = i10 + 1;
                            length = i11;
                            i14 = i13;
                            i15 = i12;
                            i16 = i9;
                            c = 7;
                        }
                        int i21 = length;
                        i8 = i15;
                        if (i16 != i14) {
                            break;
                        } else {
                            length = i21;
                        }
                    } else {
                        i8 = i15;
                    }
                    if (i8 == length) {
                        break;
                    }
                    i15 = i8 + 1;
                    c = 7;
                    j2 = -9187201950435737472L;
                    i14 = 8;
                }
            }
        } else {
            for (Object obj3 : set) {
                if (obj3 instanceof RecomposeScopeImpl) {
                    ((RecomposeScopeImpl) obj3).invalidateForResult(null);
                } else {
                    addPendingInvalidationsLocked(obj3, z);
                    Object obj4 = this.derivedStates.getMap().get(obj3);
                    if (obj4 != null) {
                        if (obj4 instanceof MutableScatterSet) {
                            MutableScatterSet mutableScatterSet2 = (MutableScatterSet) obj4;
                            Object[] objArr7 = mutableScatterSet2.elements;
                            long[] jArr11 = mutableScatterSet2.metadata;
                            int length3 = jArr11.length - 2;
                            if (length3 >= 0) {
                                int i22 = 0;
                                while (true) {
                                    long j5 = jArr11[i22];
                                    if ((((~j5) << 7) & j5 & (-9187201950435737472L)) == -9187201950435737472L) {
                                        if (i22 != length3) {
                                            break;
                                            break;
                                        }
                                        i22++;
                                    } else {
                                        int i23 = 8 - ((~(i22 - length3)) >>> 31);
                                        for (int i24 = 0; i24 < i23; i24++) {
                                            if ((j5 & 255) < 128) {
                                                addPendingInvalidationsLocked((DerivedState) objArr7[(i22 << 3) + i24], z);
                                            }
                                            j5 >>= 8;
                                        }
                                        if (i23 != 8) {
                                            break;
                                        } else if (i22 != length3) {
                                            break;
                                        } else {
                                            i22++;
                                        }
                                    }
                                }
                            }
                        } else {
                            addPendingInvalidationsLocked((DerivedState) obj4, z);
                        }
                    }
                }
            }
        }
        MutableScatterSet<RecomposeScopeImpl> mutableScatterSet3 = this.conditionallyInvalidatedScopes;
        MutableScatterSet<RecomposeScopeImpl> mutableScatterSet4 = this.invalidatedScopes;
        String str5 = "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap.removeScopeIf$lambda$2>";
        if (z && mutableScatterSet3.isNotEmpty()) {
            MutableScatterMap<Object, Object> map = this.observations.getMap();
            long[] jArr12 = map.metadata;
            int length4 = jArr12.length - 2;
            if (length4 >= 0) {
                int i25 = 0;
                while (true) {
                    long j6 = jArr12[i25];
                    if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i26 = 8 - ((~(i25 - length4)) >>> 31);
                        int i27 = 0;
                        while (i27 < i26) {
                            if ((j6 & 255) < 128) {
                                int i28 = (i25 << 3) + i27;
                                Object obj5 = map.keys[i28];
                                Object obj6 = map.values[i28];
                                if (obj6 instanceof MutableScatterSet) {
                                    Intrinsics.checkNotNull(obj6, str5);
                                    MutableScatterSet mutableScatterSet5 = (MutableScatterSet) obj6;
                                    Object[] objArr8 = mutableScatterSet5.elements;
                                    jArr6 = jArr12;
                                    long[] jArr13 = mutableScatterSet5.metadata;
                                    str4 = str5;
                                    int length5 = jArr13.length - 2;
                                    if (length5 >= 0) {
                                        i6 = length4;
                                        i7 = i25;
                                        int i29 = 0;
                                        while (true) {
                                            long j7 = jArr13[i29];
                                            j = j6;
                                            if ((((~j7) << 7) & j7 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                int i30 = 8 - ((~(i29 - length5)) >>> 31);
                                                int i31 = 0;
                                                while (i31 < i30) {
                                                    if ((j7 & 255) < 128) {
                                                        jArr8 = jArr13;
                                                        int i32 = (i29 << 3) + i31;
                                                        objArr4 = objArr8;
                                                        RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) objArr8[i32];
                                                        if (mutableScatterSet3.contains(recomposeScopeImpl) || mutableScatterSet4.contains(recomposeScopeImpl)) {
                                                            mutableScatterSet5.removeElementAt(i32);
                                                        }
                                                    } else {
                                                        jArr8 = jArr13;
                                                        objArr4 = objArr8;
                                                    }
                                                    j7 >>= 8;
                                                    i31++;
                                                    jArr13 = jArr8;
                                                    objArr8 = objArr4;
                                                }
                                                jArr7 = jArr13;
                                                objArr3 = objArr8;
                                                if (i30 != 8) {
                                                    break;
                                                }
                                            } else {
                                                jArr7 = jArr13;
                                                objArr3 = objArr8;
                                            }
                                            if (i29 == length5) {
                                                break;
                                            }
                                            i29++;
                                            j6 = j;
                                            jArr13 = jArr7;
                                            objArr8 = objArr3;
                                        }
                                    } else {
                                        i6 = length4;
                                        i7 = i25;
                                        j = j6;
                                    }
                                    if (mutableScatterSet5.isEmpty()) {
                                        map.removeValueAt(i28);
                                    }
                                } else {
                                    str4 = str5;
                                    jArr6 = jArr12;
                                    i6 = length4;
                                    i7 = i25;
                                    j = j6;
                                    Intrinsics.checkNotNull(obj6, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap.removeScopeIf$lambda$2");
                                    RecomposeScopeImpl recomposeScopeImpl2 = (RecomposeScopeImpl) obj6;
                                    if (mutableScatterSet3.contains(recomposeScopeImpl2) || mutableScatterSet4.contains(recomposeScopeImpl2)) {
                                        map.removeValueAt(i28);
                                    }
                                }
                            } else {
                                str4 = str5;
                                jArr6 = jArr12;
                                i6 = length4;
                                i7 = i25;
                                j = j6;
                            }
                            j6 = j >> 8;
                            i27++;
                            str5 = str4;
                            length4 = i6;
                            jArr12 = jArr6;
                            i25 = i7;
                        }
                        str3 = str5;
                        jArr5 = jArr12;
                        int i33 = length4;
                        int i34 = i25;
                        if (i26 != 8) {
                            break;
                        }
                        length4 = i33;
                        i5 = i34;
                    } else {
                        str3 = str5;
                        jArr5 = jArr12;
                        i5 = i25;
                    }
                    if (i5 == length4) {
                        break;
                    }
                    i25 = i5 + 1;
                    str5 = str3;
                    jArr12 = jArr5;
                }
            }
            mutableScatterSet3.clear();
            cleanUpDerivedStateObservations();
            return;
        }
        String str6 = "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap.removeScopeIf$lambda$2>";
        if (mutableScatterSet4.isNotEmpty()) {
            MutableScatterMap<Object, Object> map2 = this.observations.getMap();
            long[] jArr14 = map2.metadata;
            int length6 = jArr14.length - 2;
            if (length6 >= 0) {
                int i35 = 0;
                while (true) {
                    long j8 = jArr14[i35];
                    if ((((~j8) << 7) & j8 & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i36 = 8 - ((~(i35 - length6)) >>> 31);
                        int i37 = 0;
                        while (i37 < i36) {
                            if ((j8 & 255) < 128) {
                                int i38 = (i35 << 3) + i37;
                                Object obj7 = map2.keys[i38];
                                Object obj8 = map2.values[i38];
                                if (obj8 instanceof MutableScatterSet) {
                                    String str7 = str6;
                                    Intrinsics.checkNotNull(obj8, str7);
                                    MutableScatterSet mutableScatterSet6 = (MutableScatterSet) obj8;
                                    Object[] objArr9 = mutableScatterSet6.elements;
                                    long[] jArr15 = mutableScatterSet6.metadata;
                                    int length7 = jArr15.length - 2;
                                    if (length7 >= 0) {
                                        jArr2 = jArr14;
                                        i2 = length6;
                                        i3 = i35;
                                        int i39 = 0;
                                        while (true) {
                                            long j9 = jArr15[i39];
                                            str2 = str7;
                                            i4 = i36;
                                            if ((((~j9) << 7) & j9 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                int i40 = 8 - ((~(i39 - length7)) >>> 31);
                                                int i41 = 0;
                                                while (i41 < i40) {
                                                    if ((j9 & 255) < 128) {
                                                        jArr4 = jArr15;
                                                        int i42 = (i39 << 3) + i41;
                                                        objArr2 = objArr9;
                                                        if (mutableScatterSet4.contains((RecomposeScopeImpl) objArr9[i42])) {
                                                            mutableScatterSet6.removeElementAt(i42);
                                                        }
                                                    } else {
                                                        objArr2 = objArr9;
                                                        jArr4 = jArr15;
                                                    }
                                                    j9 >>= 8;
                                                    i41++;
                                                    jArr15 = jArr4;
                                                    objArr9 = objArr2;
                                                }
                                                objArr = objArr9;
                                                jArr3 = jArr15;
                                                if (i40 != 8) {
                                                    break;
                                                }
                                            } else {
                                                objArr = objArr9;
                                                jArr3 = jArr15;
                                            }
                                            if (i39 == length7) {
                                                break;
                                            }
                                            i39++;
                                            i36 = i4;
                                            str7 = str2;
                                            jArr15 = jArr3;
                                            objArr9 = objArr;
                                        }
                                    } else {
                                        jArr2 = jArr14;
                                        i2 = length6;
                                        i3 = i35;
                                        str2 = str7;
                                        i4 = i36;
                                    }
                                    zContains = mutableScatterSet6.isEmpty();
                                } else {
                                    str2 = str6;
                                    jArr2 = jArr14;
                                    i2 = length6;
                                    i3 = i35;
                                    i4 = i36;
                                    Intrinsics.checkNotNull(obj8, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap.removeScopeIf$lambda$2");
                                    zContains = mutableScatterSet4.contains((RecomposeScopeImpl) obj8);
                                }
                                if (zContains) {
                                    map2.removeValueAt(i38);
                                }
                            } else {
                                str2 = str6;
                                jArr2 = jArr14;
                                i2 = length6;
                                i3 = i35;
                                i4 = i36;
                            }
                            j8 >>= 8;
                            i37++;
                            length6 = i2;
                            i35 = i3;
                            jArr14 = jArr2;
                            i36 = i4;
                            str6 = str2;
                        }
                        str = str6;
                        jArr = jArr14;
                        int i43 = length6;
                        int i44 = i35;
                        if (i36 != 8) {
                            break;
                        }
                        length6 = i43;
                        i = i44;
                    } else {
                        str = str6;
                        jArr = jArr14;
                        i = i35;
                    }
                    if (i == length6) {
                        break;
                    }
                    i35 = i + 1;
                    jArr14 = jArr;
                    str6 = str;
                }
            }
            cleanUpDerivedStateObservations();
            mutableScatterSet4.clear();
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void insertMovableContent(@NotNull List<Pair<MovableContentStateReference, MovableContentStateReference>> list) throws Exception {
        int size = list.size();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= size) {
                z = true;
                break;
            } else if (!Intrinsics.areEqual(list.get(i).getFirst().getComposition$runtime_release(), this)) {
                break;
            } else {
                i++;
            }
        }
        ComposerKt.runtimeCheck(z);
        try {
            this.composer.insertMovableContentReferences(list);
            Unit unit = Unit.INSTANCE;
        } catch (Throwable th) {
            try {
                if (!this.abandonSet.isEmpty()) {
                    new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
                }
                throw th;
            } catch (Exception e) {
                abandonChanges();
                throw e;
            }
        }
    }

    private final <T> T guardChanges(Function0<? extends T> function0) throws Exception {
        try {
            try {
                T tInvoke = function0.invoke();
                InlineMarker.finallyStart(1);
                return tInvoke;
            } finally {
                InlineMarker.finallyStart(1);
                if (!this.abandonSet.isEmpty()) {
                    new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
                }
                InlineMarker.finallyEnd(1);
            }
        } catch (Exception e) {
            abandonChanges();
            throw e;
        }
    }
}
