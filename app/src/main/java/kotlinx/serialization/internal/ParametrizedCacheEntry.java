package kotlinx.serialization.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;
import kotlinx.serialization.KSerializer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
final class ParametrizedCacheEntry<T> {
    private final ConcurrentHashMap<List<KTypeWrapper>, Result<KSerializer<T>>> serializers = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: computeIfAbsent-gIAlu-s, reason: not valid java name */
    public final Object m7080computeIfAbsentgIAlus(@NotNull List<? extends KType> types, @NotNull Function0<? extends KSerializer<T>> producer) {
        Object objM5472constructorimpl;
        Intrinsics.checkNotNullParameter(types, "types");
        Intrinsics.checkNotNullParameter(producer, "producer");
        List<? extends KType> list = types;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList.add(new KTypeWrapper((KType) it2.next()));
        }
        ConcurrentHashMap concurrentHashMap = this.serializers;
        Object objM5471boximpl = concurrentHashMap.get(arrayList);
        if (objM5471boximpl == null) {
            try {
                Result.Companion companion = Result.Companion;
                objM5472constructorimpl = Result.m5472constructorimpl(producer.invoke());
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                objM5472constructorimpl = Result.m5472constructorimpl(ResultKt.createFailure(th));
            }
            objM5471boximpl = Result.m5471boximpl(objM5472constructorimpl);
            Object objPutIfAbsent = concurrentHashMap.putIfAbsent(arrayList, objM5471boximpl);
            if (objPutIfAbsent != null) {
                objM5471boximpl = objPutIfAbsent;
            }
        }
        Intrinsics.checkNotNullExpressionValue(objM5471boximpl, "getOrPut(...)");
        return ((Result) objM5471boximpl).m5481unboximpl();
    }
}
