package kotlinx.serialization.internal;

import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
@ExperimentalSerializationApi
public final class UShortArraySerializer extends PrimitiveArraySerializer<UShort, UShortArray, UShortArrayBuilder> implements KSerializer<UShortArray> {
    public static final UShortArraySerializer INSTANCE = new UShortArraySerializer();

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public /* synthetic */ int collectionSize(Object obj) {
        return m7109collectionSizerL5Bavg(((UShortArray) obj).m5820unboximpl());
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    public /* synthetic */ UShortArray empty() {
        return UShortArray.m5804boximpl(m7110emptyamswpOA());
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public /* synthetic */ Object toBuilder(Object obj) {
        return m7111toBuilderrL5Bavg(((UShortArray) obj).m5820unboximpl());
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    public /* synthetic */ void writeContent(CompositeEncoder compositeEncoder, UShortArray uShortArray, int i) {
        m7112writeContenteny0XGE(compositeEncoder, uShortArray.m5820unboximpl(), i);
    }

    private UShortArraySerializer() {
        super(BuiltinSerializersKt.serializer(UShort.Companion));
    }

    /* JADX INFO: renamed from: collectionSize-rL5Bavg, reason: not valid java name */
    protected int m7109collectionSizerL5Bavg(@NotNull short[] collectionSize) {
        Intrinsics.checkNotNullParameter(collectionSize, "$this$collectionSize");
        return UShortArray.m5812getSizeimpl(collectionSize);
    }

    /* JADX INFO: renamed from: toBuilder-rL5Bavg, reason: not valid java name */
    protected UShortArrayBuilder m7111toBuilderrL5Bavg(@NotNull short[] toBuilder) {
        Intrinsics.checkNotNullParameter(toBuilder, "$this$toBuilder");
        return new UShortArrayBuilder(toBuilder, null);
    }

    /* JADX INFO: renamed from: empty-amswpOA, reason: not valid java name */
    protected short[] m7110emptyamswpOA() {
        return UShortArray.m5805constructorimpl(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    public void readElement(@NotNull CompositeDecoder decoder, int i, @NotNull UShortArrayBuilder builder, boolean z) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        Intrinsics.checkNotNullParameter(builder, "builder");
        builder.m7107appendxj2QHRw$kotlinx_serialization_core(UShort.m5753constructorimpl(decoder.decodeInlineElement(getDescriptor(), i).decodeShort()));
    }

    /* JADX INFO: renamed from: writeContent-eny0XGE, reason: not valid java name */
    protected void m7112writeContenteny0XGE(@NotNull CompositeEncoder encoder, @NotNull short[] content, int i) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(content, "content");
        for (int i2 = 0; i2 < i; i2++) {
            encoder.encodeInlineElement(getDescriptor(), i2).encodeShort(UShortArray.m5811getMh2AYeg(content, i2));
        }
    }
}
