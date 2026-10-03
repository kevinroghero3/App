package androidx.compose.ui.modifier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.SpreadBuilder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public final class ModifierLocalModifierNodeKt {
    public static final ModifierLocalMap modifierLocalMapOf() {
        return EmptyMap.INSTANCE;
    }

    public static final <T> ModifierLocalMap modifierLocalMapOf(@NotNull ModifierLocal<T> modifierLocal) {
        return new SingleLocalMap(modifierLocal);
    }

    public static final <T> ModifierLocalMap modifierLocalMapOf(@NotNull Pair<? extends ModifierLocal<T>, ? extends T> pair) {
        SingleLocalMap singleLocalMap = new SingleLocalMap(pair.getFirst());
        singleLocalMap.mo2632set$ui_release(pair.getFirst(), pair.getSecond());
        return singleLocalMap;
    }

    public static final ModifierLocalMap modifierLocalMapOf(@NotNull ModifierLocal<?> modifierLocal, @NotNull ModifierLocal<?> modifierLocal2, @NotNull ModifierLocal<?>... modifierLocalArr) {
        Pair pair = TuplesKt.to(modifierLocal, null);
        SpreadBuilder spreadBuilder = new SpreadBuilder(2);
        spreadBuilder.add(TuplesKt.to(modifierLocal2, null));
        ArrayList arrayList = new ArrayList(modifierLocalArr.length);
        for (ModifierLocal<?> modifierLocal3 : modifierLocalArr) {
            arrayList.add(TuplesKt.to(modifierLocal3, null));
        }
        spreadBuilder.addSpread(arrayList.toArray(new Pair[0]));
        return new MultiLocalMap(pair, (Pair[]) spreadBuilder.toArray(new Pair[spreadBuilder.size()]));
    }

    public static final ModifierLocalMap modifierLocalMapOf(@NotNull Pair<? extends ModifierLocal<?>, ? extends Object> pair, @NotNull Pair<? extends ModifierLocal<?>, ? extends Object> pair2, @NotNull Pair<? extends ModifierLocal<?>, ? extends Object>... pairArr) {
        SpreadBuilder spreadBuilder = new SpreadBuilder(2);
        spreadBuilder.add(pair2);
        spreadBuilder.addSpread(pairArr);
        return new MultiLocalMap(pair, (Pair[]) spreadBuilder.toArray(new Pair[spreadBuilder.size()]));
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use a different overloaded version of this function")
    public static final /* synthetic */ ModifierLocalMap modifierLocalMapOf(ModifierLocal... modifierLocalArr) {
        int length = modifierLocalArr.length;
        if (length == 0) {
            return EmptyMap.INSTANCE;
        }
        if (length == 1) {
            return new SingleLocalMap((ModifierLocal) ArraysKt___ArraysKt.first(modifierLocalArr));
        }
        Pair pair = TuplesKt.to(ArraysKt___ArraysKt.first(modifierLocalArr), null);
        List listDrop = ArraysKt___ArraysKt.drop(modifierLocalArr, 1);
        ArrayList arrayList = new ArrayList(listDrop.size());
        int size = listDrop.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(TuplesKt.to((ModifierLocal) listDrop.get(i), null));
        }
        Pair[] pairArr = (Pair[]) arrayList.toArray(new Pair[0]);
        return new MultiLocalMap(pair, (Pair[]) Arrays.copyOf(pairArr, pairArr.length));
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use a different overloaded version of this function")
    public static final /* synthetic */ ModifierLocalMap modifierLocalMapOf(Pair... pairArr) {
        int length = pairArr.length;
        if (length == 0) {
            return EmptyMap.INSTANCE;
        }
        if (length == 1) {
            return new MultiLocalMap((Pair) ArraysKt___ArraysKt.first(pairArr), new Pair[0]);
        }
        Pair pair = (Pair) ArraysKt___ArraysKt.first(pairArr);
        Pair[] pairArr2 = (Pair[]) ArraysKt___ArraysKt.drop(pairArr, 1).toArray(new Pair[0]);
        return new MultiLocalMap(pair, (Pair[]) Arrays.copyOf(pairArr2, pairArr2.length));
    }
}
