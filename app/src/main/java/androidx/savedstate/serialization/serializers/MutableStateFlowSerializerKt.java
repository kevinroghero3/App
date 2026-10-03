package androidx.savedstate.serialization.serializers;

import androidx.exifinterface.media.ExifInterface;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.reflect.KType;
import kotlinx.serialization.SerializersKt;

/* JADX INFO: loaded from: classes4.dex */
public final class MutableStateFlowSerializerKt {
    public static final /* synthetic */ <T> MutableStateFlowSerializer<T> MutableStateFlowSerializer() {
        Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
        return new MutableStateFlowSerializer<>(SerializersKt.serializer((KType) null));
    }
}
