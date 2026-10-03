package androidx.navigation.serialization;

import androidx.navigation.CollectionNavType;
import androidx.navigation.NavType;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.AbstractEncoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.modules.SerializersModule;
import kotlinx.serialization.modules.SerializersModuleBuildersKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class RouteEncoder<T> extends AbstractEncoder {
    private int elementIndex;
    private final Map<String, List<String>> map;
    private final KSerializer<T> serializer;
    private final SerializersModule serializersModule;
    private final Map<String, NavType<Object>> typeMap;

    /* JADX WARN: Multi-variable type inference failed */
    public RouteEncoder(@NotNull KSerializer<T> serializer, @NotNull Map<String, ? extends NavType<Object>> typeMap) {
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(typeMap, "typeMap");
        this.serializer = serializer;
        this.typeMap = typeMap;
        this.serializersModule = SerializersModuleBuildersKt.EmptySerializersModule();
        this.map = new LinkedHashMap();
        this.elementIndex = -1;
    }

    @Override // kotlinx.serialization.encoding.Encoder, kotlinx.serialization.encoding.CompositeEncoder
    public SerializersModule getSerializersModule() {
        return this.serializersModule;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Map<String, List<String>> encodeToArgMap(@NotNull Object value) {
        Intrinsics.checkNotNullParameter(value, "value");
        super.encodeSerializableValue(this.serializer, value);
        return MapsKt__MapsKt.toMap(this.map);
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public <T> void encodeSerializableValue(@NotNull SerializationStrategy<? super T> serializer, T t) {
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        internalEncodeValue(t);
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder
    public boolean encodeElement(@NotNull SerialDescriptor descriptor, int i) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        this.elementIndex = i;
        return true;
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder
    public void encodeValue(@NotNull Object value) {
        Intrinsics.checkNotNullParameter(value, "value");
        internalEncodeValue(value);
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void encodeNull() {
        internalEncodeValue(null);
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public Encoder encodeInline(@NotNull SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (RouteSerializerKt.isValueClass(descriptor)) {
            this.elementIndex = 0;
        }
        return super.encodeInline(descriptor);
    }

    private final void internalEncodeValue(Object obj) {
        List<String> listListOf;
        String elementName = this.serializer.getDescriptor().getElementName(this.elementIndex);
        NavType<Object> navType = this.typeMap.get(elementName);
        if (navType == null) {
            throw new IllegalStateException(("Cannot find NavType for argument " + elementName + ". Please provide NavType through typeMap.").toString());
        }
        if (navType instanceof CollectionNavType) {
            listListOf = ((CollectionNavType) navType).serializeAsValues(obj);
        } else {
            listListOf = CollectionsKt__CollectionsJVMKt.listOf(navType.serializeAsValue(obj));
        }
        this.map.put(elementName, listListOf);
    }
}
