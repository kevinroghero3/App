package androidx.savedstate.compose.serialization.serializers;

import androidx.exifinterface.media.ExifInterface;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.reflect.KType;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;

/* JADX INFO: loaded from: classes4.dex */
public final class SnapshotStateMapSerializerKt {
    public static final /* synthetic */ <K, V> SnapshotStateMapSerializer<K, V> SnapshotStateMapSerializer() {
        Intrinsics.reifiedOperationMarker(6, "K");
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
        KSerializer<Object> kSerializerSerializer = SerializersKt.serializer((KType) null);
        Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
        return new SnapshotStateMapSerializer<>(kSerializerSerializer, SerializersKt.serializer((KType) null));
    }
}
