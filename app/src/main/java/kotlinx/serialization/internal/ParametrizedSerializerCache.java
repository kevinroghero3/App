package kotlinx.serialization.internal;

import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public interface ParametrizedSerializerCache<T> {
    /* JADX INFO: renamed from: get-gIAlu-s */
    Object mo7075getgIAlus(@NotNull KClass<Object> kClass, @NotNull List<? extends KType> list);

    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: renamed from: get-gIAlu-s$default, reason: not valid java name */
        public static /* synthetic */ Object m7081getgIAlus$default(ParametrizedSerializerCache parametrizedSerializerCache, KClass kClass, List list, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: get-gIAlu-s");
            }
            if ((i & 2) != 0) {
                list = CollectionsKt__CollectionsKt.emptyList();
            }
            return parametrizedSerializerCache.mo7075getgIAlus(kClass, list);
        }
    }
}
