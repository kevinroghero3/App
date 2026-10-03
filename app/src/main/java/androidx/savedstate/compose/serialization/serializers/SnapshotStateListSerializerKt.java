package androidx.savedstate.compose.serialization.serializers;

import androidx.exifinterface.media.ExifInterface;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.reflect.KType;
import kotlinx.serialization.SerializersKt;

/* JADX INFO: loaded from: classes4.dex */
public final class SnapshotStateListSerializerKt {
    public static final /* synthetic */ <T> SnapshotStateListSerializer<T> SnapshotStateListSerializer() {
        Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
        return new SnapshotStateListSerializer<>(SerializersKt.serializer((KType) null));
    }
}
