package androidx.savedstate;

import android.os.Bundle;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
final /* synthetic */ class SavedStateKt__SavedStateKt {
    public static final <T> T read(@NotNull Bundle bundle, @NotNull Function1<? super SavedStateReader, ? extends T> block) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        return block.invoke(SavedStateReader.m4024boximpl(SavedStateReader.m4025constructorimpl(bundle)));
    }

    public static final <T> T write(@NotNull Bundle bundle, @NotNull Function1<? super SavedStateWriter, ? extends T> block) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        return block.invoke(SavedStateWriter.m4109boximpl(SavedStateWriter.m4111constructorimpl(bundle)));
    }
}
