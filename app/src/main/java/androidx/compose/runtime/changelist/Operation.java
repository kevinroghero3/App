package androidx.compose.runtime.changelist;

import androidx.compose.runtime.Anchor;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposeNodeLifecycleCallback;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.ControlledComposition;
import androidx.compose.runtime.MovableContentState;
import androidx.compose.runtime.MovableContentStateReference;
import androidx.compose.runtime.OffsetApplier;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.RecomposeScopeOwner;
import androidx.compose.runtime.RememberManager;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.RememberObserverHolder;
import androidx.compose.runtime.SlotTable;
import androidx.compose.runtime.SlotWriter;
import androidx.compose.runtime.internal.IntRef;
import androidx.compose.runtime.internal.Utils_jvmKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import ch.qos.logback.core.CoreConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Unit;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.simpleframework.xml.strategy.Name;

/* JADX INFO: loaded from: classes.dex */
public abstract class Operation {
    public static final int $stable = 0;
    private final int ints;
    private final int objects;

    public /* synthetic */ Operation(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2);
    }

    public abstract void execute(@NotNull OperationArgContainer operationArgContainer, @NotNull Applier<?> applier, @NotNull SlotWriter slotWriter, @NotNull RememberManager rememberManager);

    private Operation(int i, int i2) {
        this.ints = i;
        this.objects = i2;
    }

    public /* synthetic */ Operation(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2, null);
    }

    public final int getInts() {
        return this.ints;
    }

    public final int getObjects() {
        return this.objects;
    }

    public final String getName() {
        String simpleName = Reflection.getOrCreateKotlinClass(getClass()).getSimpleName();
        return simpleName == null ? "" : simpleName;
    }

    /* JADX INFO: renamed from: intParamName-w8GmfQM, reason: not valid java name */
    public String mo674intParamNamew8GmfQM(int i) {
        return "IntParameter(" + i + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    /* JADX INFO: renamed from: objectParamName-31yXWZQ, reason: not valid java name */
    public String mo675objectParamName31yXWZQ(int i) {
        return "ObjectParameter(" + i + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public String toString() {
        return getName();
    }

    @JvmInline
    public static final class IntParameter {
        private final int offset;

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ IntParameter m701boximpl(int i) {
            return new IntParameter(i);
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        public static int m702constructorimpl(int i) {
            return i;
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m703equalsimpl(int i, Object obj) {
            return (obj instanceof IntParameter) && i == ((IntParameter) obj).m707unboximpl();
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m704equalsimpl0(int i, int i2) {
            return i == i2;
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m705hashCodeimpl(int i) {
            return Integer.hashCode(i);
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m706toStringimpl(int i) {
            return "IntParameter(offset=" + i + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public boolean equals(Object obj) {
            return m703equalsimpl(this.offset, obj);
        }

        public int hashCode() {
            return m705hashCodeimpl(this.offset);
        }

        public String toString() {
            return m706toStringimpl(this.offset);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
        public final /* synthetic */ int m707unboximpl() {
            return this.offset;
        }

        private /* synthetic */ IntParameter(int i) {
            this.offset = i;
        }

        public final int getOffset() {
            return this.offset;
        }
    }

    @JvmInline
    public static final class ObjectParameter<T> {
        private final int offset;

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ ObjectParameter m712boximpl(int i) {
            return new ObjectParameter(i);
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        public static <T> int m713constructorimpl(int i) {
            return i;
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m714equalsimpl(int i, Object obj) {
            return (obj instanceof ObjectParameter) && i == ((ObjectParameter) obj).m718unboximpl();
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m715equalsimpl0(int i, int i2) {
            return i == i2;
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m716hashCodeimpl(int i) {
            return Integer.hashCode(i);
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m717toStringimpl(int i) {
            return "ObjectParameter(offset=" + i + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public boolean equals(Object obj) {
            return m714equalsimpl(this.offset, obj);
        }

        public int hashCode() {
            return m716hashCodeimpl(this.offset);
        }

        public String toString() {
            return m717toStringimpl(this.offset);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
        public final /* synthetic */ int m718unboximpl() {
            return this.offset;
        }

        private /* synthetic */ ObjectParameter(int i) {
            this.offset = i;
        }

        public final int getOffset() {
            return this.offset;
        }
    }

    /* JADX INFO: loaded from: classes4.dex */
    public static final class Ups extends Operation {
        public static final int $stable = 0;
        public static final Ups INSTANCE = new Ups();

        private Ups() {
            super(1, 0, 2, null);
        }

        /* JADX INFO: renamed from: getCount-jn0FJLE, reason: not valid java name */
        public final int m737getCountjn0FJLE() {
            return IntParameter.m702constructorimpl(0);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        /* JADX INFO: renamed from: intParamName-w8GmfQM */
        public String mo674intParamNamew8GmfQM(int i) {
            return IntParameter.m704equalsimpl0(i, IntParameter.m702constructorimpl(0)) ? "count" : super.mo674intParamNamew8GmfQM(i);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(@NotNull OperationArgContainer operationArgContainer, @NotNull Applier<?> applier, @NotNull SlotWriter slotWriter, @NotNull RememberManager rememberManager) {
            int iMo738getIntw8GmfQM = operationArgContainer.mo738getIntw8GmfQM(IntParameter.m702constructorimpl(0));
            for (int i = 0; i < iMo738getIntw8GmfQM; i++) {
                applier.up();
            }
        }
    }

    /* JADX INFO: loaded from: classes4.dex */
    public static final class Downs extends Operation {
        public static final int $stable = 0;
        public static final Downs INSTANCE = new Downs();

        /* JADX WARN: Illegal instructions before constructor call */
        private Downs() {
            int i = 1;
            super(0, i, i, null);
        }

        /* JADX INFO: renamed from: getNodes-HpuvwBQ, reason: not valid java name */
        public final int m689getNodesHpuvwBQ() {
            return ObjectParameter.m713constructorimpl(0);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(@NotNull OperationArgContainer operationArgContainer, @NotNull Applier<?> applier, @NotNull SlotWriter slotWriter, @NotNull RememberManager rememberManager) {
            Intrinsics.checkNotNull(applier, "null cannot be cast to non-null type androidx.compose.runtime.Applier<kotlin.Any?>");
            for (Object obj : (Object[]) operationArgContainer.mo739getObject31yXWZQ(ObjectParameter.m713constructorimpl(0))) {
                applier.down(obj);
            }
        }

        @Override // androidx.compose.runtime.changelist.Operation
        /* JADX INFO: renamed from: objectParamName-31yXWZQ */
        public String mo675objectParamName31yXWZQ(int i) {
            return ObjectParameter.m715equalsimpl0(i, ObjectParameter.m713constructorimpl(0)) ? "nodes" : super.mo675objectParamName31yXWZQ(i);
        }
    }

    /* JADX INFO: loaded from: classes4.dex */
    public static final class AdvanceSlotsBy extends Operation {
        public static final int $stable = 0;
        public static final AdvanceSlotsBy INSTANCE = new AdvanceSlotsBy();

        private AdvanceSlotsBy() {
            super(1, 0, 2, null);
        }

        /* JADX INFO: renamed from: getDistance-jn0FJLE, reason: not valid java name */
        public final int m676getDistancejn0FJLE() {
            return IntParameter.m702constructorimpl(0);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        /* JADX INFO: renamed from: intParamName-w8GmfQM */
        public String mo674intParamNamew8GmfQM(int i) {
            return IntParameter.m704equalsimpl0(i, IntParameter.m702constructorimpl(0)) ? "distance" : super.mo674intParamNamew8GmfQM(i);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(@NotNull OperationArgContainer operationArgContainer, @NotNull Applier<?> applier, @NotNull SlotWriter slotWriter, @NotNull RememberManager rememberManager) {
            slotWriter.advanceBy(operationArgContainer.mo738getIntw8GmfQM(IntParameter.m702constructorimpl(0)));
        }
    }

    /* JADX INFO: loaded from: classes4.dex */
    public static final class SideEffect extends Operation {
        public static final int $stable = 0;
        public static final SideEffect INSTANCE = new SideEffect();

        /* JADX WARN: Illegal instructions before constructor call */
        private SideEffect() {
            int i = 1;
            super(0, i, i, null);
        }

        /* JADX INFO: renamed from: getEffect-HpuvwBQ, reason: not valid java name */
        public final int m727getEffectHpuvwBQ() {
            return ObjectParameter.m713constructorimpl(0);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        /* JADX INFO: renamed from: objectParamName-31yXWZQ */
        public String mo675objectParamName31yXWZQ(int i) {
            return ObjectParameter.m715equalsimpl0(i, ObjectParameter.m713constructorimpl(0)) ? "effect" : super.mo675objectParamName31yXWZQ(i);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(@NotNull OperationArgContainer operationArgContainer, @NotNull Applier<?> applier, @NotNull SlotWriter slotWriter, @NotNull RememberManager rememberManager) {
            rememberManager.sideEffect((Function0) operationArgContainer.mo739getObject31yXWZQ(ObjectParameter.m713constructorimpl(0)));
        }
    }

    /* JADX INFO: loaded from: classes4.dex */
    public static final class Remember extends Operation {
        public static final int $stable = 0;
        public static final Remember INSTANCE = new Remember();

        /* JADX WARN: Illegal instructions before constructor call */
        private Remember() {
            int i = 1;
            super(0, i, i, null);
        }

        /* JADX INFO: renamed from: getValue-HpuvwBQ, reason: not valid java name */
        public final int m724getValueHpuvwBQ() {
            return ObjectParameter.m713constructorimpl(0);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        /* JADX INFO: renamed from: objectParamName-31yXWZQ */
        public String mo675objectParamName31yXWZQ(int i) {
            return ObjectParameter.m715equalsimpl0(i, ObjectParameter.m713constructorimpl(0)) ? "value" : super.mo675objectParamName31yXWZQ(i);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(@NotNull OperationArgContainer operationArgContainer, @NotNull Applier<?> applier, @NotNull SlotWriter slotWriter, @NotNull RememberManager rememberManager) {
            rememberManager.remembering((RememberObserver) operationArgContainer.mo739getObject31yXWZQ(ObjectParameter.m713constructorimpl(0)));
        }
    }

    /* JADX INFO: loaded from: classes4.dex */
    public static final class AppendValue extends Operation {
        public static final int $stable = 0;
        public static final AppendValue INSTANCE = new AppendValue();

        private AppendValue() {
            super(0, 2, 1, null);
        }

        /* JADX INFO: renamed from: getAnchor-HpuvwBQ, reason: not valid java name */
        public final int m677getAnchorHpuvwBQ() {
            return ObjectParameter.m713constructorimpl(0);
        }

        /* JADX INFO: renamed from: getValue-HpuvwBQ, reason: not valid java name */
        public final int m678getValueHpuvwBQ() {
            return ObjectParameter.m713constructorimpl(1);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        /* JADX INFO: renamed from: objectParamName-31yXWZQ */
        public String mo675objectParamName31yXWZQ(int i) {
            if (ObjectParameter.m715equalsimpl0(i, ObjectParameter.m713constructorimpl(0))) {
                return "anchor";
            }
            return ObjectParameter.m715equalsimpl0(i, ObjectParameter.m713constructorimpl(1)) ? "value" : super.mo675objectParamName31yXWZQ(i);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(@NotNull OperationArgContainer operationArgContainer, @NotNull Applier<?> applier, @NotNull SlotWriter slotWriter, @NotNull RememberManager rememberManager) {
            Anchor anchor = (Anchor) operationArgContainer.mo739getObject31yXWZQ(ObjectParameter.m713constructorimpl(0));
            Object objMo739getObject31yXWZQ = operationArgContainer.mo739getObject31yXWZQ(ObjectParameter.m713constructorimpl(1));
            if (objMo739getObject31yXWZQ instanceof RememberObserverHolder) {
                rememberManager.remembering(((RememberObserverHolder) objMo739getObject31yXWZQ).getWrapped());
            }
            slotWriter.appendSlot(anchor, objMo739getObject31yXWZQ);
        }
    }

    /* JADX INFO: loaded from: classes4.dex */
    public static final class TrimParentValues extends Operation {
        public static final int $stable = 0;
        public static final TrimParentValues INSTANCE = new TrimParentValues();

        private TrimParentValues() {
            super(1, 0, 2, null);
        }

        /* JADX INFO: renamed from: getCount-jn0FJLE, reason: not valid java name */
        public final int m728getCountjn0FJLE() {
            return IntParameter.m702constructorimpl(0);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        /* JADX INFO: renamed from: intParamName-w8GmfQM */
        public String mo674intParamNamew8GmfQM(int i) {
            return IntParameter.m704equalsimpl0(i, IntParameter.m702constructorimpl(0)) ? "count" : super.mo674intParamNamew8GmfQM(i);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(@NotNull OperationArgContainer operationArgContainer, @NotNull Applier<?> applier, @NotNull SlotWriter slotWriter, @NotNull RememberManager rememberManager) {
            int iMo738getIntw8GmfQM = operationArgContainer.mo738getIntw8GmfQM(IntParameter.m702constructorimpl(0));
            int slotsSize = slotWriter.getSlotsSize();
            int parent = slotWriter.getParent();
            int iSlotsStartIndex$runtime_release = slotWriter.slotsStartIndex$runtime_release(parent);
            int iSlotsEndIndex$runtime_release = slotWriter.slotsEndIndex$runtime_release(parent);
            for (int iMax = Math.max(iSlotsStartIndex$runtime_release, iSlotsEndIndex$runtime_release - iMo738getIntw8GmfQM); iMax < iSlotsEndIndex$runtime_release; iMax++) {
                Object obj = slotWriter.slots[slotWriter.dataIndexToDataAddress(iMax)];
                if (obj instanceof RememberObserverHolder) {
                    rememberManager.forgetting(((RememberObserverHolder) obj).getWrapped(), slotsSize - iMax, -1, -1);
                } else if (obj instanceof RecomposeScopeImpl) {
                    ((RecomposeScopeImpl) obj).release();
                }
            }
            slotWriter.trimTailSlots(iMo738getIntw8GmfQM);
        }
    }

    /* JADX INFO: loaded from: classes4.dex */
    public static final class UpdateValue extends Operation {
        public static final int $stable = 0;
        public static final UpdateValue INSTANCE = new UpdateValue();

        /* JADX WARN: Illegal instructions before constructor call */
        private UpdateValue() {
            int i = 1;
            super(i, i, null);
        }

        /* JADX INFO: renamed from: getValue-HpuvwBQ, reason: not valid java name */
        public final int m736getValueHpuvwBQ() {
            return ObjectParameter.m713constructorimpl(0);
        }

        /* JADX INFO: renamed from: getGroupSlotIndex-jn0FJLE, reason: not valid java name */
        public final int m735getGroupSlotIndexjn0FJLE() {
            return IntParameter.m702constructorimpl(0);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        /* JADX INFO: renamed from: intParamName-w8GmfQM */
        public String mo674intParamNamew8GmfQM(int i) {
            return IntParameter.m704equalsimpl0(i, IntParameter.m702constructorimpl(0)) ? "groupSlotIndex" : super.mo674intParamNamew8GmfQM(i);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        /* JADX INFO: renamed from: objectParamName-31yXWZQ */
        public String mo675objectParamName31yXWZQ(int i) {
            return ObjectParameter.m715equalsimpl0(i, ObjectParameter.m713constructorimpl(0)) ? "value" : super.mo675objectParamName31yXWZQ(i);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(@NotNull OperationArgContainer operationArgContainer, @NotNull Applier<?> applier, @NotNull SlotWriter slotWriter, @NotNull RememberManager rememberManager) {
            Object objMo739getObject31yXWZQ = operationArgContainer.mo739getObject31yXWZQ(ObjectParameter.m713constructorimpl(0));
            int iMo738getIntw8GmfQM = operationArgContainer.mo738getIntw8GmfQM(IntParameter.m702constructorimpl(0));
            if (objMo739getObject31yXWZQ instanceof RememberObserverHolder) {
                rememberManager.remembering(((RememberObserverHolder) objMo739getObject31yXWZQ).getWrapped());
            }
            Object obj = slotWriter.set(iMo738getIntw8GmfQM, objMo739getObject31yXWZQ);
            if (obj instanceof RememberObserverHolder) {
                rememberManager.forgetting(((RememberObserverHolder) obj).getWrapped(), slotWriter.getSlotsSize() - slotWriter.slotIndexOfGroupSlotIndex(slotWriter.getCurrentGroup(), iMo738getIntw8GmfQM), -1, -1);
            } else if (obj instanceof RecomposeScopeImpl) {
                ((RecomposeScopeImpl) obj).release();
            }
        }
    }

    /* JADX INFO: loaded from: classes4.dex */
    public static final class UpdateAnchoredValue extends Operation {
        public static final int $stable = 0;
        public static final UpdateAnchoredValue INSTANCE = new UpdateAnchoredValue();

        private UpdateAnchoredValue() {
            super(1, 2, null);
        }

        /* JADX INFO: renamed from: getValue-HpuvwBQ, reason: not valid java name */
        public final int m731getValueHpuvwBQ() {
            return ObjectParameter.m713constructorimpl(0);
        }

        /* JADX INFO: renamed from: getAnchor-HpuvwBQ, reason: not valid java name */
        public final int m729getAnchorHpuvwBQ() {
            return ObjectParameter.m713constructorimpl(1);
        }

        /* JADX INFO: renamed from: getGroupSlotIndex-jn0FJLE, reason: not valid java name */
        public final int m730getGroupSlotIndexjn0FJLE() {
            return IntParameter.m702constructorimpl(0);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        /* JADX INFO: renamed from: intParamName-w8GmfQM */
        public String mo674intParamNamew8GmfQM(int i) {
            return IntParameter.m704equalsimpl0(i, IntParameter.m702constructorimpl(0)) ? "groupSlotIndex" : super.mo674intParamNamew8GmfQM(i);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        /* JADX INFO: renamed from: objectParamName-31yXWZQ */
        public String mo675objectParamName31yXWZQ(int i) {
            if (ObjectParameter.m715equalsimpl0(i, ObjectParameter.m713constructorimpl(0))) {
                return "value";
            }
            return ObjectParameter.m715equalsimpl0(i, ObjectParameter.m713constructorimpl(1)) ? "anchor" : super.mo675objectParamName31yXWZQ(i);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(@NotNull OperationArgContainer operationArgContainer, @NotNull Applier<?> applier, @NotNull SlotWriter slotWriter, @NotNull RememberManager rememberManager) {
            int iAnchorIndex;
            int slotsSize;
            Object objMo739getObject31yXWZQ = operationArgContainer.mo739getObject31yXWZQ(ObjectParameter.m713constructorimpl(0));
            Anchor anchor = (Anchor) operationArgContainer.mo739getObject31yXWZQ(ObjectParameter.m713constructorimpl(1));
            int iMo738getIntw8GmfQM = operationArgContainer.mo738getIntw8GmfQM(IntParameter.m702constructorimpl(0));
            if (objMo739getObject31yXWZQ instanceof RememberObserverHolder) {
                rememberManager.remembering(((RememberObserverHolder) objMo739getObject31yXWZQ).getWrapped());
            }
            int iAnchorIndex2 = slotWriter.anchorIndex(anchor);
            Object obj = slotWriter.set(iAnchorIndex2, iMo738getIntw8GmfQM, objMo739getObject31yXWZQ);
            if (obj instanceof RememberObserverHolder) {
                int slotsSize2 = slotWriter.getSlotsSize();
                int iSlotIndexOfGroupSlotIndex = slotWriter.slotIndexOfGroupSlotIndex(iAnchorIndex2, iMo738getIntw8GmfQM);
                RememberObserverHolder rememberObserverHolder = (RememberObserverHolder) obj;
                Anchor after = rememberObserverHolder.getAfter();
                if (after == null || !after.getValid()) {
                    iAnchorIndex = -1;
                    slotsSize = -1;
                } else {
                    iAnchorIndex = slotWriter.anchorIndex(after);
                    slotsSize = slotWriter.getSlotsSize() - slotWriter.slotsEndAllIndex$runtime_release(iAnchorIndex);
                }
                rememberManager.forgetting(rememberObserverHolder.getWrapped(), slotsSize2 - iSlotIndexOfGroupSlotIndex, iAnchorIndex, slotsSize);
                return;
            }
            if (obj instanceof RecomposeScopeImpl) {
                ((RecomposeScopeImpl) obj).release();
            }
        }
    }

    /* JADX INFO: loaded from: classes4.dex */
    public static final class UpdateAuxData extends Operation {
        public static final int $stable = 0;
        public static final UpdateAuxData INSTANCE = new UpdateAuxData();

        /* JADX WARN: Illegal instructions before constructor call */
        private UpdateAuxData() {
            int i = 1;
            super(0, i, i, null);
        }

        /* JADX INFO: renamed from: getData-HpuvwBQ, reason: not valid java name */
        public final int m732getDataHpuvwBQ() {
            return ObjectParameter.m713constructorimpl(0);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        /* JADX INFO: renamed from: objectParamName-31yXWZQ */
        public String mo675objectParamName31yXWZQ(int i) {
            return ObjectParameter.m715equalsimpl0(i, ObjectParameter.m713constructorimpl(0)) ? "data" : super.mo675objectParamName31yXWZQ(i);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(@NotNull OperationArgContainer operationArgContainer, @NotNull Applier<?> applier, @NotNull SlotWriter slotWriter, @NotNull RememberManager rememberManager) {
            slotWriter.updateAux(operationArgContainer.mo739getObject31yXWZQ(ObjectParameter.m713constructorimpl(0)));
        }
    }

    /* JADX INFO: loaded from: classes4.dex */
    public static final class EnsureRootGroupStarted extends Operation {
        public static final int $stable = 0;
        public static final EnsureRootGroupStarted INSTANCE = new EnsureRootGroupStarted();

        /* JADX WARN: Illegal instructions before constructor call */
        private EnsureRootGroupStarted() {
            int i = 0;
            super(i, i, 3, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(@NotNull OperationArgContainer operationArgContainer, @NotNull Applier<?> applier, @NotNull SlotWriter slotWriter, @NotNull RememberManager rememberManager) {
            slotWriter.ensureStarted(0);
        }
    }

    /* JADX INFO: loaded from: classes4.dex */
    public static final class EnsureGroupStarted extends Operation {
        public static final int $stable = 0;
        public static final EnsureGroupStarted INSTANCE = new EnsureGroupStarted();

        /* JADX WARN: Illegal instructions before constructor call */
        private EnsureGroupStarted() {
            int i = 1;
            super(0, i, i, null);
        }

        /* JADX INFO: renamed from: getAnchor-HpuvwBQ, reason: not valid java name */
        public final int m692getAnchorHpuvwBQ() {
            return ObjectParameter.m713constructorimpl(0);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        /* JADX INFO: renamed from: objectParamName-31yXWZQ */
        public String mo675objectParamName31yXWZQ(int i) {
            return ObjectParameter.m715equalsimpl0(i, ObjectParameter.m713constructorimpl(0)) ? "anchor" : super.mo675objectParamName31yXWZQ(i);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(@NotNull OperationArgContainer operationArgContainer, @NotNull Applier<?> applier, @NotNull SlotWriter slotWriter, @NotNull RememberManager rememberManager) {
            slotWriter.ensureStarted((Anchor) operationArgContainer.mo739getObject31yXWZQ(ObjectParameter.m713constructorimpl(0)));
        }
    }

    /* JADX INFO: loaded from: classes4.dex */
    public static final class RemoveCurrentGroup extends Operation {
        public static final int $stable = 0;
        public static final RemoveCurrentGroup INSTANCE = new RemoveCurrentGroup();

        /* JADX WARN: Illegal instructions before constructor call */
        private RemoveCurrentGroup() {
            int i = 0;
            super(i, i, 3, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(@NotNull OperationArgContainer operationArgContainer, @NotNull Applier<?> applier, @NotNull SlotWriter slotWriter, @NotNull RememberManager rememberManager) {
            ComposerKt.removeCurrentGroup(slotWriter, rememberManager);
        }
    }

    /* JADX INFO: loaded from: classes4.dex */
    public static final class MoveCurrentGroup extends Operation {
        public static final int $stable = 0;
        public static final MoveCurrentGroup INSTANCE = new MoveCurrentGroup();

        private MoveCurrentGroup() {
            super(1, 0, 2, null);
        }

        /* JADX INFO: renamed from: getOffset-jn0FJLE, reason: not valid java name */
        public final int m708getOffsetjn0FJLE() {
            return IntParameter.m702constructorimpl(0);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        /* JADX INFO: renamed from: intParamName-w8GmfQM */
        public String mo674intParamNamew8GmfQM(int i) {
            return IntParameter.m704equalsimpl0(i, IntParameter.m702constructorimpl(0)) ? TypedValues.CycleType.S_WAVE_OFFSET : super.mo674intParamNamew8GmfQM(i);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(@NotNull OperationArgContainer operationArgContainer, @NotNull Applier<?> applier, @NotNull SlotWriter slotWriter, @NotNull RememberManager rememberManager) {
            slotWriter.moveGroup(operationArgContainer.mo738getIntw8GmfQM(IntParameter.m702constructorimpl(0)));
        }
    }

    /* JADX INFO: loaded from: classes4.dex */
    public static final class EndCurrentGroup extends Operation {
        public static final int $stable = 0;
        public static final EndCurrentGroup INSTANCE = new EndCurrentGroup();

        /* JADX WARN: Illegal instructions before constructor call */
        private EndCurrentGroup() {
            int i = 0;
            super(i, i, 3, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(@NotNull OperationArgContainer operationArgContainer, @NotNull Applier<?> applier, @NotNull SlotWriter slotWriter, @NotNull RememberManager rememberManager) {
            slotWriter.endGroup();
        }
    }

    /* JADX INFO: loaded from: classes4.dex */
    public static final class SkipToEndOfCurrentGroup extends Operation {
        public static final int $stable = 0;
        public static final SkipToEndOfCurrentGroup INSTANCE = new SkipToEndOfCurrentGroup();

        /* JADX WARN: Illegal instructions before constructor call */
        private SkipToEndOfCurrentGroup() {
            int i = 0;
            super(i, i, 3, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(@NotNull OperationArgContainer operationArgContainer, @NotNull Applier<?> applier, @NotNull SlotWriter slotWriter, @NotNull RememberManager rememberManager) {
            slotWriter.skipToGroupEnd();
        }
    }

    /* JADX INFO: loaded from: classes4.dex */
    public static final class EndCompositionScope extends Operation {
        public static final int $stable = 0;
        public static final EndCompositionScope INSTANCE = new EndCompositionScope();

        private EndCompositionScope() {
            super(0, 2, 1, null);
        }

        /* JADX INFO: renamed from: getAction-HpuvwBQ, reason: not valid java name */
        public final int m690getActionHpuvwBQ() {
            return ObjectParameter.m713constructorimpl(0);
        }

        /* JADX INFO: renamed from: getComposition-HpuvwBQ, reason: not valid java name */
        public final int m691getCompositionHpuvwBQ() {
            return ObjectParameter.m713constructorimpl(1);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        /* JADX INFO: renamed from: objectParamName-31yXWZQ */
        public String mo675objectParamName31yXWZQ(int i) {
            if (ObjectParameter.m715equalsimpl0(i, ObjectParameter.m713constructorimpl(0))) {
                return "anchor";
            }
            return ObjectParameter.m715equalsimpl0(i, ObjectParameter.m713constructorimpl(1)) ? "composition" : super.mo675objectParamName31yXWZQ(i);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(@NotNull OperationArgContainer operationArgContainer, @NotNull Applier<?> applier, @NotNull SlotWriter slotWriter, @NotNull RememberManager rememberManager) {
            ((Function1) operationArgContainer.mo739getObject31yXWZQ(ObjectParameter.m713constructorimpl(0))).invoke((Composition) operationArgContainer.mo739getObject31yXWZQ(ObjectParameter.m713constructorimpl(1)));
        }
    }

    /* JADX INFO: loaded from: classes4.dex */
    public static final class UseCurrentNode extends Operation {
        public static final int $stable = 0;
        public static final UseCurrentNode INSTANCE = new UseCurrentNode();

        /* JADX WARN: Illegal instructions before constructor call */
        private UseCurrentNode() {
            int i = 0;
            super(i, i, 3, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(@NotNull OperationArgContainer operationArgContainer, @NotNull Applier<?> applier, @NotNull SlotWriter slotWriter, @NotNull RememberManager rememberManager) {
            Object current = applier.getCurrent();
            Intrinsics.checkNotNull(current, "null cannot be cast to non-null type androidx.compose.runtime.ComposeNodeLifecycleCallback");
            ((ComposeNodeLifecycleCallback) current).onReuse();
        }
    }

    /* JADX INFO: loaded from: classes4.dex */
    public static final class UpdateNode extends Operation {
        public static final int $stable = 0;
        public static final UpdateNode INSTANCE = new UpdateNode();

        private UpdateNode() {
            super(0, 2, 1, null);
        }

        /* JADX INFO: renamed from: getValue-HpuvwBQ, reason: not valid java name */
        public final int m734getValueHpuvwBQ() {
            return ObjectParameter.m713constructorimpl(0);
        }

        /* JADX INFO: renamed from: getBlock-HpuvwBQ, reason: not valid java name */
        public final int m733getBlockHpuvwBQ() {
            return ObjectParameter.m713constructorimpl(1);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        /* JADX INFO: renamed from: objectParamName-31yXWZQ */
        public String mo675objectParamName31yXWZQ(int i) {
            if (ObjectParameter.m715equalsimpl0(i, ObjectParameter.m713constructorimpl(0))) {
                return "value";
            }
            return ObjectParameter.m715equalsimpl0(i, ObjectParameter.m713constructorimpl(1)) ? "block" : super.mo675objectParamName31yXWZQ(i);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(@NotNull OperationArgContainer operationArgContainer, @NotNull Applier<?> applier, @NotNull SlotWriter slotWriter, @NotNull RememberManager rememberManager) {
            ((Function2) operationArgContainer.mo739getObject31yXWZQ(ObjectParameter.m713constructorimpl(1))).invoke(applier.getCurrent(), operationArgContainer.mo739getObject31yXWZQ(ObjectParameter.m713constructorimpl(0)));
        }
    }

    /* JADX INFO: loaded from: classes4.dex */
    public static final class RemoveNode extends Operation {
        public static final int $stable = 0;
        public static final RemoveNode INSTANCE = new RemoveNode();

        /* JADX WARN: Illegal instructions before constructor call */
        private RemoveNode() {
            int i = 2;
            super(i, 0, i, null);
        }

        /* JADX INFO: renamed from: getRemoveIndex-jn0FJLE, reason: not valid java name */
        public final int m726getRemoveIndexjn0FJLE() {
            return IntParameter.m702constructorimpl(0);
        }

        /* JADX INFO: renamed from: getCount-jn0FJLE, reason: not valid java name */
        public final int m725getCountjn0FJLE() {
            return IntParameter.m702constructorimpl(1);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        /* JADX INFO: renamed from: intParamName-w8GmfQM */
        public String mo674intParamNamew8GmfQM(int i) {
            if (IntParameter.m704equalsimpl0(i, IntParameter.m702constructorimpl(0))) {
                return "removeIndex";
            }
            return IntParameter.m704equalsimpl0(i, IntParameter.m702constructorimpl(1)) ? "count" : super.mo674intParamNamew8GmfQM(i);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(@NotNull OperationArgContainer operationArgContainer, @NotNull Applier<?> applier, @NotNull SlotWriter slotWriter, @NotNull RememberManager rememberManager) {
            applier.remove(operationArgContainer.mo738getIntw8GmfQM(IntParameter.m702constructorimpl(0)), operationArgContainer.mo738getIntw8GmfQM(IntParameter.m702constructorimpl(1)));
        }
    }

    /* JADX INFO: loaded from: classes4.dex */
    public static final class MoveNode extends Operation {
        public static final int $stable = 0;
        public static final MoveNode INSTANCE = new MoveNode();

        private MoveNode() {
            super(3, 0, 2, null);
        }

        /* JADX INFO: renamed from: getFrom-jn0FJLE, reason: not valid java name */
        public final int m710getFromjn0FJLE() {
            return IntParameter.m702constructorimpl(0);
        }

        /* JADX INFO: renamed from: getTo-jn0FJLE, reason: not valid java name */
        public final int m711getTojn0FJLE() {
            return IntParameter.m702constructorimpl(1);
        }

        /* JADX INFO: renamed from: getCount-jn0FJLE, reason: not valid java name */
        public final int m709getCountjn0FJLE() {
            return IntParameter.m702constructorimpl(2);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        /* JADX INFO: renamed from: intParamName-w8GmfQM */
        public String mo674intParamNamew8GmfQM(int i) {
            if (IntParameter.m704equalsimpl0(i, IntParameter.m702constructorimpl(0))) {
                return "from";
            }
            if (IntParameter.m704equalsimpl0(i, IntParameter.m702constructorimpl(1))) {
                return "to";
            }
            return IntParameter.m704equalsimpl0(i, IntParameter.m702constructorimpl(2)) ? "count" : super.mo674intParamNamew8GmfQM(i);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(@NotNull OperationArgContainer operationArgContainer, @NotNull Applier<?> applier, @NotNull SlotWriter slotWriter, @NotNull RememberManager rememberManager) {
            applier.move(operationArgContainer.mo738getIntw8GmfQM(IntParameter.m702constructorimpl(0)), operationArgContainer.mo738getIntw8GmfQM(IntParameter.m702constructorimpl(1)), operationArgContainer.mo738getIntw8GmfQM(IntParameter.m702constructorimpl(2)));
        }
    }

    /* JADX INFO: loaded from: classes4.dex */
    public static final class InsertSlots extends Operation {
        public static final int $stable = 0;
        public static final InsertSlots INSTANCE = new InsertSlots();

        private InsertSlots() {
            super(0, 2, 1, null);
        }

        /* JADX INFO: renamed from: getAnchor-HpuvwBQ, reason: not valid java name */
        public final int m696getAnchorHpuvwBQ() {
            return ObjectParameter.m713constructorimpl(0);
        }

        /* JADX INFO: renamed from: getFromSlotTable-HpuvwBQ, reason: not valid java name */
        public final int m697getFromSlotTableHpuvwBQ() {
            return ObjectParameter.m713constructorimpl(1);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        /* JADX INFO: renamed from: objectParamName-31yXWZQ */
        public String mo675objectParamName31yXWZQ(int i) {
            if (ObjectParameter.m715equalsimpl0(i, ObjectParameter.m713constructorimpl(0))) {
                return "anchor";
            }
            return ObjectParameter.m715equalsimpl0(i, ObjectParameter.m713constructorimpl(1)) ? "from" : super.mo675objectParamName31yXWZQ(i);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(@NotNull OperationArgContainer operationArgContainer, @NotNull Applier<?> applier, @NotNull SlotWriter slotWriter, @NotNull RememberManager rememberManager) {
            SlotTable slotTable = (SlotTable) operationArgContainer.mo739getObject31yXWZQ(ObjectParameter.m713constructorimpl(1));
            Anchor anchor = (Anchor) operationArgContainer.mo739getObject31yXWZQ(ObjectParameter.m713constructorimpl(0));
            slotWriter.beginInsert();
            slotWriter.moveFrom(slotTable, anchor.toIndexFor(slotTable), false);
            slotWriter.endInsert();
        }
    }

    /* JADX INFO: loaded from: classes4.dex */
    public static final class InsertSlotsWithFixups extends Operation {
        public static final int $stable = 0;
        public static final InsertSlotsWithFixups INSTANCE = new InsertSlotsWithFixups();

        private InsertSlotsWithFixups() {
            super(0, 3, 1, null);
        }

        /* JADX INFO: renamed from: getAnchor-HpuvwBQ, reason: not valid java name */
        public final int m698getAnchorHpuvwBQ() {
            return ObjectParameter.m713constructorimpl(0);
        }

        /* JADX INFO: renamed from: getFromSlotTable-HpuvwBQ, reason: not valid java name */
        public final int m700getFromSlotTableHpuvwBQ() {
            return ObjectParameter.m713constructorimpl(1);
        }

        /* JADX INFO: renamed from: getFixups-HpuvwBQ, reason: not valid java name */
        public final int m699getFixupsHpuvwBQ() {
            return ObjectParameter.m713constructorimpl(2);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        /* JADX INFO: renamed from: objectParamName-31yXWZQ */
        public String mo675objectParamName31yXWZQ(int i) {
            if (ObjectParameter.m715equalsimpl0(i, ObjectParameter.m713constructorimpl(0))) {
                return "anchor";
            }
            if (ObjectParameter.m715equalsimpl0(i, ObjectParameter.m713constructorimpl(1))) {
                return "from";
            }
            return ObjectParameter.m715equalsimpl0(i, ObjectParameter.m713constructorimpl(2)) ? "fixups" : super.mo675objectParamName31yXWZQ(i);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(@NotNull OperationArgContainer operationArgContainer, @NotNull Applier<?> applier, @NotNull SlotWriter slotWriter, @NotNull RememberManager rememberManager) {
            SlotTable slotTable = (SlotTable) operationArgContainer.mo739getObject31yXWZQ(ObjectParameter.m713constructorimpl(1));
            Anchor anchor = (Anchor) operationArgContainer.mo739getObject31yXWZQ(ObjectParameter.m713constructorimpl(0));
            FixupList fixupList = (FixupList) operationArgContainer.mo739getObject31yXWZQ(ObjectParameter.m713constructorimpl(2));
            SlotWriter slotWriterOpenWriter = slotTable.openWriter();
            try {
                fixupList.executeAndFlushAllPendingFixups(applier, slotWriterOpenWriter, rememberManager);
                Unit unit = Unit.INSTANCE;
                slotWriterOpenWriter.close(true);
                slotWriter.beginInsert();
                slotWriter.moveFrom(slotTable, anchor.toIndexFor(slotTable), false);
                slotWriter.endInsert();
            } catch (Throwable th) {
                slotWriterOpenWriter.close(false);
                throw th;
            }
        }
    }

    /* JADX INFO: loaded from: classes4.dex */
    public static final class InsertNodeFixup extends Operation {
        public static final int $stable = 0;
        public static final InsertNodeFixup INSTANCE = new InsertNodeFixup();

        private InsertNodeFixup() {
            super(1, 2, null);
        }

        /* JADX INFO: renamed from: getFactory-HpuvwBQ, reason: not valid java name */
        public final int m693getFactoryHpuvwBQ() {
            return ObjectParameter.m713constructorimpl(0);
        }

        /* JADX INFO: renamed from: getInsertIndex-jn0FJLE, reason: not valid java name */
        public final int m695getInsertIndexjn0FJLE() {
            return IntParameter.m702constructorimpl(0);
        }

        /* JADX INFO: renamed from: getGroupAnchor-HpuvwBQ, reason: not valid java name */
        public final int m694getGroupAnchorHpuvwBQ() {
            return ObjectParameter.m713constructorimpl(1);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        /* JADX INFO: renamed from: intParamName-w8GmfQM */
        public String mo674intParamNamew8GmfQM(int i) {
            return IntParameter.m704equalsimpl0(i, IntParameter.m702constructorimpl(0)) ? "insertIndex" : super.mo674intParamNamew8GmfQM(i);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        /* JADX INFO: renamed from: objectParamName-31yXWZQ */
        public String mo675objectParamName31yXWZQ(int i) {
            if (ObjectParameter.m715equalsimpl0(i, ObjectParameter.m713constructorimpl(0))) {
                return "factory";
            }
            return ObjectParameter.m715equalsimpl0(i, ObjectParameter.m713constructorimpl(1)) ? "groupAnchor" : super.mo675objectParamName31yXWZQ(i);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(@NotNull OperationArgContainer operationArgContainer, @NotNull Applier<?> applier, @NotNull SlotWriter slotWriter, @NotNull RememberManager rememberManager) {
            Object objInvoke = ((Function0) operationArgContainer.mo739getObject31yXWZQ(ObjectParameter.m713constructorimpl(0))).invoke();
            Anchor anchor = (Anchor) operationArgContainer.mo739getObject31yXWZQ(ObjectParameter.m713constructorimpl(1));
            int iMo738getIntw8GmfQM = operationArgContainer.mo738getIntw8GmfQM(IntParameter.m702constructorimpl(0));
            Intrinsics.checkNotNull(applier, "null cannot be cast to non-null type androidx.compose.runtime.Applier<kotlin.Any?>");
            slotWriter.updateNode(anchor, objInvoke);
            applier.insertTopDown(iMo738getIntw8GmfQM, objInvoke);
            applier.down(objInvoke);
        }
    }

    /* JADX INFO: loaded from: classes4.dex */
    public static final class PostInsertNodeFixup extends Operation {
        public static final int $stable = 0;
        public static final PostInsertNodeFixup INSTANCE = new PostInsertNodeFixup();

        /* JADX WARN: Illegal instructions before constructor call */
        private PostInsertNodeFixup() {
            int i = 1;
            super(i, i, null);
        }

        /* JADX INFO: renamed from: getInsertIndex-jn0FJLE, reason: not valid java name */
        public final int m720getInsertIndexjn0FJLE() {
            return IntParameter.m702constructorimpl(0);
        }

        /* JADX INFO: renamed from: getGroupAnchor-HpuvwBQ, reason: not valid java name */
        public final int m719getGroupAnchorHpuvwBQ() {
            return ObjectParameter.m713constructorimpl(0);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        /* JADX INFO: renamed from: intParamName-w8GmfQM */
        public String mo674intParamNamew8GmfQM(int i) {
            return IntParameter.m704equalsimpl0(i, IntParameter.m702constructorimpl(0)) ? "insertIndex" : super.mo674intParamNamew8GmfQM(i);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        /* JADX INFO: renamed from: objectParamName-31yXWZQ */
        public String mo675objectParamName31yXWZQ(int i) {
            return ObjectParameter.m715equalsimpl0(i, ObjectParameter.m713constructorimpl(0)) ? "groupAnchor" : super.mo675objectParamName31yXWZQ(i);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(@NotNull OperationArgContainer operationArgContainer, @NotNull Applier<?> applier, @NotNull SlotWriter slotWriter, @NotNull RememberManager rememberManager) {
            Anchor anchor = (Anchor) operationArgContainer.mo739getObject31yXWZQ(ObjectParameter.m713constructorimpl(0));
            int iMo738getIntw8GmfQM = operationArgContainer.mo738getIntw8GmfQM(IntParameter.m702constructorimpl(0));
            applier.up();
            Intrinsics.checkNotNull(applier, "null cannot be cast to non-null type androidx.compose.runtime.Applier<kotlin.Any?>");
            applier.insertBottomUp(iMo738getIntw8GmfQM, slotWriter.node(anchor));
        }
    }

    /* JADX INFO: loaded from: classes4.dex */
    public static final class DeactivateCurrentGroup extends Operation {
        public static final int $stable = 0;
        public static final DeactivateCurrentGroup INSTANCE = new DeactivateCurrentGroup();

        /* JADX WARN: Illegal instructions before constructor call */
        private DeactivateCurrentGroup() {
            int i = 0;
            super(i, i, 3, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(@NotNull OperationArgContainer operationArgContainer, @NotNull Applier<?> applier, @NotNull SlotWriter slotWriter, @NotNull RememberManager rememberManager) {
            ComposerKt.deactivateCurrentGroup(slotWriter, rememberManager);
        }
    }

    /* JADX INFO: loaded from: classes4.dex */
    public static final class ResetSlots extends Operation {
        public static final int $stable = 0;
        public static final ResetSlots INSTANCE = new ResetSlots();

        /* JADX WARN: Illegal instructions before constructor call */
        private ResetSlots() {
            int i = 0;
            super(i, i, 3, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(@NotNull OperationArgContainer operationArgContainer, @NotNull Applier<?> applier, @NotNull SlotWriter slotWriter, @NotNull RememberManager rememberManager) {
            slotWriter.reset();
        }
    }

    /* JADX INFO: loaded from: classes4.dex */
    public static final class DetermineMovableContentNodeIndex extends Operation {
        public static final int $stable = 0;
        public static final DetermineMovableContentNodeIndex INSTANCE = new DetermineMovableContentNodeIndex();

        private DetermineMovableContentNodeIndex() {
            super(0, 2, 1, null);
        }

        /* JADX INFO: renamed from: getEffectiveNodeIndexOut-HpuvwBQ, reason: not valid java name */
        public final int m688getEffectiveNodeIndexOutHpuvwBQ() {
            return ObjectParameter.m713constructorimpl(0);
        }

        /* JADX INFO: renamed from: getAnchor-HpuvwBQ, reason: not valid java name */
        public final int m687getAnchorHpuvwBQ() {
            return ObjectParameter.m713constructorimpl(1);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        /* JADX INFO: renamed from: objectParamName-31yXWZQ */
        public String mo675objectParamName31yXWZQ(int i) {
            if (ObjectParameter.m715equalsimpl0(i, ObjectParameter.m713constructorimpl(0))) {
                return "effectiveNodeIndexOut";
            }
            return ObjectParameter.m715equalsimpl0(i, ObjectParameter.m713constructorimpl(1)) ? "anchor" : super.mo675objectParamName31yXWZQ(i);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(@NotNull OperationArgContainer operationArgContainer, @NotNull Applier<?> applier, @NotNull SlotWriter slotWriter, @NotNull RememberManager rememberManager) {
            IntRef intRef = (IntRef) operationArgContainer.mo739getObject31yXWZQ(ObjectParameter.m713constructorimpl(0));
            Anchor anchor = (Anchor) operationArgContainer.mo739getObject31yXWZQ(ObjectParameter.m713constructorimpl(1));
            Intrinsics.checkNotNull(applier, "null cannot be cast to non-null type androidx.compose.runtime.Applier<kotlin.Any?>");
            intRef.setElement(OperationKt.positionToInsert(slotWriter, anchor, applier));
        }
    }

    /* JADX INFO: loaded from: classes4.dex */
    public static final class CopyNodesToNewAnchorLocation extends Operation {
        public static final int $stable = 0;
        public static final CopyNodesToNewAnchorLocation INSTANCE = new CopyNodesToNewAnchorLocation();

        private CopyNodesToNewAnchorLocation() {
            super(0, 2, 1, null);
        }

        /* JADX INFO: renamed from: getEffectiveNodeIndex-HpuvwBQ, reason: not valid java name */
        public final int m681getEffectiveNodeIndexHpuvwBQ() {
            return ObjectParameter.m713constructorimpl(0);
        }

        /* JADX INFO: renamed from: getNodes-HpuvwBQ, reason: not valid java name */
        public final int m682getNodesHpuvwBQ() {
            return ObjectParameter.m713constructorimpl(1);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        /* JADX INFO: renamed from: objectParamName-31yXWZQ */
        public String mo675objectParamName31yXWZQ(int i) {
            if (ObjectParameter.m715equalsimpl0(i, ObjectParameter.m713constructorimpl(0))) {
                return "effectiveNodeIndex";
            }
            return ObjectParameter.m715equalsimpl0(i, ObjectParameter.m713constructorimpl(1)) ? "nodes" : super.mo675objectParamName31yXWZQ(i);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(@NotNull OperationArgContainer operationArgContainer, @NotNull Applier<?> applier, @NotNull SlotWriter slotWriter, @NotNull RememberManager rememberManager) {
            int element = ((IntRef) operationArgContainer.mo739getObject31yXWZQ(ObjectParameter.m713constructorimpl(0))).getElement();
            List list = (List) operationArgContainer.mo739getObject31yXWZQ(ObjectParameter.m713constructorimpl(1));
            int size = list.size();
            for (int i = 0; i < size; i++) {
                Object obj = list.get(i);
                Intrinsics.checkNotNull(applier, "null cannot be cast to non-null type androidx.compose.runtime.Applier<kotlin.Any?>");
                int i2 = element + i;
                applier.insertBottomUp(i2, obj);
                applier.insertTopDown(i2, obj);
            }
        }
    }

    /* JADX INFO: loaded from: classes4.dex */
    public static final class CopySlotTableToAnchorLocation extends Operation {
        public static final int $stable = 0;
        public static final CopySlotTableToAnchorLocation INSTANCE = new CopySlotTableToAnchorLocation();

        private CopySlotTableToAnchorLocation() {
            super(0, 4, 1, null);
        }

        /* JADX INFO: renamed from: getResolvedState-HpuvwBQ, reason: not valid java name */
        public final int m685getResolvedStateHpuvwBQ() {
            return ObjectParameter.m713constructorimpl(0);
        }

        /* JADX INFO: renamed from: getParentCompositionContext-HpuvwBQ, reason: not valid java name */
        public final int m684getParentCompositionContextHpuvwBQ() {
            return ObjectParameter.m713constructorimpl(1);
        }

        /* JADX INFO: renamed from: getFrom-HpuvwBQ, reason: not valid java name */
        public final int m683getFromHpuvwBQ() {
            return ObjectParameter.m713constructorimpl(2);
        }

        /* JADX INFO: renamed from: getTo-HpuvwBQ, reason: not valid java name */
        public final int m686getToHpuvwBQ() {
            return ObjectParameter.m713constructorimpl(3);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        /* JADX INFO: renamed from: objectParamName-31yXWZQ */
        public String mo675objectParamName31yXWZQ(int i) {
            if (ObjectParameter.m715equalsimpl0(i, ObjectParameter.m713constructorimpl(0))) {
                return "resolvedState";
            }
            if (ObjectParameter.m715equalsimpl0(i, ObjectParameter.m713constructorimpl(1))) {
                return "resolvedCompositionContext";
            }
            if (ObjectParameter.m715equalsimpl0(i, ObjectParameter.m713constructorimpl(2))) {
                return "from";
            }
            return ObjectParameter.m715equalsimpl0(i, ObjectParameter.m713constructorimpl(3)) ? "to" : super.mo675objectParamName31yXWZQ(i);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(@NotNull OperationArgContainer operationArgContainer, @NotNull Applier<?> applier, @NotNull SlotWriter slotWriter, @NotNull RememberManager rememberManager) {
            MovableContentStateReference movableContentStateReference = (MovableContentStateReference) operationArgContainer.mo739getObject31yXWZQ(ObjectParameter.m713constructorimpl(2));
            MovableContentStateReference movableContentStateReference2 = (MovableContentStateReference) operationArgContainer.mo739getObject31yXWZQ(ObjectParameter.m713constructorimpl(3));
            CompositionContext compositionContext = (CompositionContext) operationArgContainer.mo739getObject31yXWZQ(ObjectParameter.m713constructorimpl(1));
            MovableContentState movableContentStateMovableContentStateResolve$runtime_release = (MovableContentState) operationArgContainer.mo739getObject31yXWZQ(ObjectParameter.m713constructorimpl(0));
            if (movableContentStateMovableContentStateResolve$runtime_release == null && (movableContentStateMovableContentStateResolve$runtime_release = compositionContext.movableContentStateResolve$runtime_release(movableContentStateReference)) == null) {
                ComposerKt.composeRuntimeError("Could not resolve state for movable content");
                throw new KotlinNothingValueException();
            }
            List<Anchor> listMoveIntoGroupFrom = slotWriter.moveIntoGroupFrom(1, movableContentStateMovableContentStateResolve$runtime_release.getSlotTable$runtime_release(), 2);
            RecomposeScopeImpl.Companion companion = RecomposeScopeImpl.Companion;
            ControlledComposition composition$runtime_release = movableContentStateReference2.getComposition$runtime_release();
            Intrinsics.checkNotNull(composition$runtime_release, "null cannot be cast to non-null type androidx.compose.runtime.RecomposeScopeOwner");
            companion.adoptAnchoredScopes$runtime_release(slotWriter, listMoveIntoGroupFrom, (RecomposeScopeOwner) composition$runtime_release);
        }
    }

    /* JADX INFO: loaded from: classes4.dex */
    public static final class EndMovableContentPlacement extends Operation {
        public static final int $stable = 0;
        public static final EndMovableContentPlacement INSTANCE = new EndMovableContentPlacement();

        /* JADX WARN: Illegal instructions before constructor call */
        private EndMovableContentPlacement() {
            int i = 0;
            super(i, i, 3, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(@NotNull OperationArgContainer operationArgContainer, @NotNull Applier<?> applier, @NotNull SlotWriter slotWriter, @NotNull RememberManager rememberManager) {
            Intrinsics.checkNotNull(applier, "null cannot be cast to non-null type androidx.compose.runtime.Applier<kotlin.Any?>");
            OperationKt.positionToParentOf(slotWriter, applier, 0);
            slotWriter.endGroup();
        }
    }

    /* JADX INFO: loaded from: classes4.dex */
    public static final class ReleaseMovableGroupAtCurrent extends Operation {
        public static final int $stable = 0;
        public static final ReleaseMovableGroupAtCurrent INSTANCE = new ReleaseMovableGroupAtCurrent();

        private ReleaseMovableGroupAtCurrent() {
            super(0, 3, 1, null);
        }

        /* JADX INFO: renamed from: getComposition-HpuvwBQ, reason: not valid java name */
        public final int m721getCompositionHpuvwBQ() {
            return ObjectParameter.m713constructorimpl(0);
        }

        /* JADX INFO: renamed from: getParentCompositionContext-HpuvwBQ, reason: not valid java name */
        public final int m722getParentCompositionContextHpuvwBQ() {
            return ObjectParameter.m713constructorimpl(1);
        }

        /* JADX INFO: renamed from: getReference-HpuvwBQ, reason: not valid java name */
        public final int m723getReferenceHpuvwBQ() {
            return ObjectParameter.m713constructorimpl(2);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        /* JADX INFO: renamed from: objectParamName-31yXWZQ */
        public String mo675objectParamName31yXWZQ(int i) {
            if (ObjectParameter.m715equalsimpl0(i, ObjectParameter.m713constructorimpl(0))) {
                return "composition";
            }
            if (ObjectParameter.m715equalsimpl0(i, ObjectParameter.m713constructorimpl(1))) {
                return "parentCompositionContext";
            }
            return ObjectParameter.m715equalsimpl0(i, ObjectParameter.m713constructorimpl(2)) ? Name.REFER : super.mo675objectParamName31yXWZQ(i);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(@NotNull OperationArgContainer operationArgContainer, @NotNull Applier<?> applier, @NotNull SlotWriter slotWriter, @NotNull RememberManager rememberManager) {
            OperationKt.releaseMovableGroupAtCurrent((ControlledComposition) operationArgContainer.mo739getObject31yXWZQ(ObjectParameter.m713constructorimpl(0)), (CompositionContext) operationArgContainer.mo739getObject31yXWZQ(ObjectParameter.m713constructorimpl(1)), (MovableContentStateReference) operationArgContainer.mo739getObject31yXWZQ(ObjectParameter.m713constructorimpl(2)), slotWriter);
        }
    }

    /* JADX INFO: loaded from: classes4.dex */
    public static final class ApplyChangeList extends Operation {
        public static final int $stable = 0;
        public static final ApplyChangeList INSTANCE = new ApplyChangeList();

        private ApplyChangeList() {
            super(0, 2, 1, null);
        }

        /* JADX INFO: renamed from: getChanges-HpuvwBQ, reason: not valid java name */
        public final int m679getChangesHpuvwBQ() {
            return ObjectParameter.m713constructorimpl(0);
        }

        /* JADX INFO: renamed from: getEffectiveNodeIndex-HpuvwBQ, reason: not valid java name */
        public final int m680getEffectiveNodeIndexHpuvwBQ() {
            return ObjectParameter.m713constructorimpl(1);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        /* JADX INFO: renamed from: objectParamName-31yXWZQ */
        public String mo675objectParamName31yXWZQ(int i) {
            if (ObjectParameter.m715equalsimpl0(i, ObjectParameter.m713constructorimpl(0))) {
                return "changes";
            }
            return ObjectParameter.m715equalsimpl0(i, ObjectParameter.m713constructorimpl(1)) ? "effectiveNodeIndex" : super.mo675objectParamName31yXWZQ(i);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(@NotNull OperationArgContainer operationArgContainer, @NotNull Applier<?> applier, @NotNull SlotWriter slotWriter, @NotNull RememberManager rememberManager) {
            IntRef intRef = (IntRef) operationArgContainer.mo739getObject31yXWZQ(ObjectParameter.m713constructorimpl(1));
            int element = intRef != null ? intRef.getElement() : 0;
            ChangeList changeList = (ChangeList) operationArgContainer.mo739getObject31yXWZQ(ObjectParameter.m713constructorimpl(0));
            if (element > 0) {
                applier = new OffsetApplier(applier, element);
            }
            changeList.executeAndFlushAllPendingChanges(applier, slotWriter, rememberManager);
        }
    }

    /* JADX INFO: loaded from: classes4.dex */
    public static final class TestOperation extends Operation {
        public static final int $stable = 8;
        private final Function3<Applier<?>, SlotWriter, RememberManager, Unit> block;
        private final List<IntParameter> intParams;
        private final List<ObjectParameter<Object>> objParams;

        public TestOperation() {
            this(0, 0, null, 7, null);
        }

        public /* synthetic */ TestOperation(int i, int i2, Function3 function3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2, (i3 & 4) != 0 ? new Function3<Applier<?>, SlotWriter, RememberManager, Unit>() { // from class: androidx.compose.runtime.changelist.Operation.TestOperation.1
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull Applier<?> applier, @NotNull SlotWriter slotWriter, @NotNull RememberManager rememberManager) {
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
                    invoke2(applier, slotWriter, rememberManager);
                    return Unit.INSTANCE;
                }
            } : function3);
        }

        public final Function3<Applier<?>, SlotWriter, RememberManager, Unit> getBlock() {
            return this.block;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public TestOperation(int i, int i2, @NotNull Function3<? super Applier<?>, ? super SlotWriter, ? super RememberManager, Unit> function3) {
            super(i, i2, null);
            this.block = function3;
            ArrayList arrayList = new ArrayList(i);
            for (int i3 = 0; i3 < i; i3++) {
                arrayList.add(IntParameter.m701boximpl(IntParameter.m702constructorimpl(i3)));
            }
            this.intParams = arrayList;
            ArrayList arrayList2 = new ArrayList(i2);
            for (int i4 = 0; i4 < i2; i4++) {
                arrayList2.add(ObjectParameter.m712boximpl(ObjectParameter.m713constructorimpl(i4)));
            }
            this.objParams = arrayList2;
        }

        public final List<IntParameter> getIntParams() {
            return this.intParams;
        }

        public final List<ObjectParameter<Object>> getObjParams() {
            return this.objParams;
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(@NotNull OperationArgContainer operationArgContainer, @NotNull Applier<?> applier, @NotNull SlotWriter slotWriter, @NotNull RememberManager rememberManager) {
            this.block.invoke(applier, slotWriter, rememberManager);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public String toString() {
            return "TestOperation(ints = " + getInts() + ", objects = " + getObjects() + ")@" + Utils_jvmKt.identityHashCode(this);
        }
    }
}
