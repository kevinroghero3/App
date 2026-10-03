package androidx.compose.runtime.changelist;

import androidx.compose.runtime.Anchor;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.PreconditionsKt;
import androidx.compose.runtime.RememberManager;
import androidx.compose.runtime.SlotWriter;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class FixupList extends OperationsDebugStringFormattable {
    public static final int $stable = 8;
    private final Operations operations = new Operations();
    private final Operations pendingOperations = new Operations();

    public final int getSize() {
        return this.operations.getSize();
    }

    public final boolean isEmpty() {
        return this.operations.isEmpty();
    }

    public final boolean isNotEmpty() {
        return this.operations.isNotEmpty();
    }

    public final void clear() {
        this.pendingOperations.clear();
        this.operations.clear();
    }

    public final void executeAndFlushAllPendingFixups(@NotNull Applier<?> applier, @NotNull SlotWriter slotWriter, @NotNull RememberManager rememberManager) {
        if (!this.pendingOperations.isEmpty()) {
            ComposerKt.composeImmediateRuntimeError("FixupList has pending fixup operations that were not realized. Were there mismatched insertNode() and endNodeInsert() calls?");
        }
        this.operations.executeAndFlushAllPendingOperations(applier, slotWriter, rememberManager);
    }

    public final void createAndInsertNode(@NotNull Function0<? extends Object> function0, int i, @NotNull Anchor anchor) {
        FixupList fixupList = this;
        Operations operations = fixupList.operations;
        Operation.InsertNodeFixup insertNodeFixup = Operation.InsertNodeFixup.INSTANCE;
        operations.pushOp(insertNodeFixup);
        Operations operationsM745constructorimpl = Operations.WriteScope.m745constructorimpl(operations);
        Operations.WriteScope.m751setObjectDKhxnng(operationsM745constructorimpl, Operation.ObjectParameter.m713constructorimpl(0), function0);
        Operations.WriteScope.m750setIntA6tL2VI(operationsM745constructorimpl, Operation.IntParameter.m702constructorimpl(0), i);
        int i2 = 1;
        Operations.WriteScope.m751setObjectDKhxnng(operationsM745constructorimpl, Operation.ObjectParameter.m713constructorimpl(1), anchor);
        if (operations.pushedIntMask != operations.createExpectedArgMask(insertNodeFixup.getInts()) || operations.pushedObjectMask != operations.createExpectedArgMask(insertNodeFixup.getObjects())) {
            StringBuilder sb = new StringBuilder();
            int ints = insertNodeFixup.getInts();
            int i3 = 0;
            int i4 = 0;
            while (i4 < ints) {
                if (((i2 << i4) & operations.pushedIntMask) != 0) {
                    if (i3 > 0) {
                        sb.append(", ");
                    }
                    sb.append(insertNodeFixup.mo674intParamNamew8GmfQM(Operation.IntParameter.m702constructorimpl(i4)));
                    i3++;
                }
                i4++;
                i2 = 1;
            }
            String string = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
            StringBuilder sb2 = new StringBuilder();
            int objects = insertNodeFixup.getObjects();
            int i5 = 0;
            int i6 = 0;
            while (i6 < objects) {
                if (((1 << i6) & operations.pushedObjectMask) != 0) {
                    if (i3 > 0) {
                        sb2.append(", ");
                    }
                    sb2.append(insertNodeFixup.mo675objectParamName31yXWZQ(Operation.ObjectParameter.m713constructorimpl(i6)));
                    i5++;
                }
                i6++;
                operations = operations;
            }
            String string2 = sb2.toString();
            Intrinsics.checkNotNullExpressionValue(string2, "StringBuilder().apply(builderAction).toString()");
            PreconditionsKt.throwIllegalStateException("Error while pushing " + insertNodeFixup + ". Not all arguments were provided. Missing " + i3 + " int arguments (" + string + ") and " + i5 + " object arguments (" + string2 + ").");
            fixupList = this;
        }
        Operations operations2 = fixupList.pendingOperations;
        Operation.PostInsertNodeFixup postInsertNodeFixup = Operation.PostInsertNodeFixup.INSTANCE;
        operations2.pushOp(postInsertNodeFixup);
        Operations operationsM745constructorimpl2 = Operations.WriteScope.m745constructorimpl(operations2);
        Operations.WriteScope.m750setIntA6tL2VI(operationsM745constructorimpl2, Operation.IntParameter.m702constructorimpl(0), i);
        Operations.WriteScope.m751setObjectDKhxnng(operationsM745constructorimpl2, Operation.ObjectParameter.m713constructorimpl(0), anchor);
        if (operations2.pushedIntMask == operations2.createExpectedArgMask(postInsertNodeFixup.getInts()) && operations2.pushedObjectMask == operations2.createExpectedArgMask(postInsertNodeFixup.getObjects())) {
            return;
        }
        StringBuilder sb3 = new StringBuilder();
        int ints2 = postInsertNodeFixup.getInts();
        int i7 = 0;
        for (int i8 = 0; i8 < ints2; i8++) {
            if (((1 << i8) & operations2.pushedIntMask) != 0) {
                if (i7 > 0) {
                    sb3.append(", ");
                }
                sb3.append(postInsertNodeFixup.mo674intParamNamew8GmfQM(Operation.IntParameter.m702constructorimpl(i8)));
                i7++;
            }
        }
        String string3 = sb3.toString();
        Intrinsics.checkNotNullExpressionValue(string3, "StringBuilder().apply(builderAction).toString()");
        StringBuilder sb4 = new StringBuilder();
        int objects2 = postInsertNodeFixup.getObjects();
        int i9 = 0;
        int i10 = 0;
        while (i10 < objects2) {
            if (((1 << i10) & operations2.pushedObjectMask) != 0) {
                if (i7 > 0) {
                    sb4.append(", ");
                }
                sb4.append(postInsertNodeFixup.mo675objectParamName31yXWZQ(Operation.ObjectParameter.m713constructorimpl(i10)));
                i9++;
            }
            i10++;
            operations2 = operations2;
        }
        String string4 = sb4.toString();
        Intrinsics.checkNotNullExpressionValue(string4, "StringBuilder().apply(builderAction).toString()");
        PreconditionsKt.throwIllegalStateException("Error while pushing " + postInsertNodeFixup + ". Not all arguments were provided. Missing " + i7 + " int arguments (" + string3 + ") and " + i9 + " object arguments (" + string4 + ").");
    }

    public final void endNodeInsert() {
        if (!this.pendingOperations.isNotEmpty()) {
            ComposerKt.composeImmediateRuntimeError("Cannot end node insertion, there are no pending operations that can be realized.");
        }
        this.pendingOperations.popInto(this.operations);
    }

    public final <V, T> void updateNode(V v, @NotNull Function2<? super T, ? super V, Unit> function2) {
        Operations operations = this.operations;
        Operation.UpdateNode updateNode = Operation.UpdateNode.INSTANCE;
        operations.pushOp(updateNode);
        Operations operationsM745constructorimpl = Operations.WriteScope.m745constructorimpl(operations);
        Operations.WriteScope.m751setObjectDKhxnng(operationsM745constructorimpl, Operation.ObjectParameter.m713constructorimpl(0), v);
        int iM713constructorimpl = Operation.ObjectParameter.m713constructorimpl(1);
        Intrinsics.checkNotNull(function2, "null cannot be cast to non-null type @[ExtensionFunctionType] kotlin.Function2<kotlin.Any?, kotlin.Any?, kotlin.Unit>");
        Operations.WriteScope.m751setObjectDKhxnng(operationsM745constructorimpl, iM713constructorimpl, (Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function2, 2));
        if (operations.pushedIntMask == operations.createExpectedArgMask(updateNode.getInts()) && operations.pushedObjectMask == operations.createExpectedArgMask(updateNode.getObjects())) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        int ints = updateNode.getInts();
        int i = 0;
        for (int i2 = 0; i2 < ints; i2++) {
            if (((1 << i2) & operations.pushedIntMask) != 0) {
                if (i > 0) {
                    sb.append(", ");
                }
                sb.append(updateNode.mo674intParamNamew8GmfQM(Operation.IntParameter.m702constructorimpl(i2)));
                i++;
            }
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        StringBuilder sb2 = new StringBuilder();
        int objects = updateNode.getObjects();
        int i3 = 0;
        for (int i4 = 0; i4 < objects; i4++) {
            if (((1 << i4) & operations.pushedObjectMask) != 0) {
                if (i > 0) {
                    sb2.append(", ");
                }
                sb2.append(updateNode.mo675objectParamName31yXWZQ(Operation.ObjectParameter.m713constructorimpl(i4)));
                i3++;
            }
        }
        String string2 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(string2, "StringBuilder().apply(builderAction).toString()");
        PreconditionsKt.throwIllegalStateException("Error while pushing " + updateNode + ". Not all arguments were provided. Missing " + i + " int arguments (" + string + ") and " + i3 + " object arguments (" + string2 + ").");
    }

    @Override // androidx.compose.runtime.changelist.OperationsDebugStringFormattable
    public String toDebugString(@NotNull String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("FixupList instance containing " + getSize() + " operations");
        if (sb.length() > 0) {
            sb.append(":\n" + this.operations.toDebugString(str));
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
