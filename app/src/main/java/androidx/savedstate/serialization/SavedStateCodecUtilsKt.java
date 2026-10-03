package androidx.savedstate.serialization;

import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* JADX INFO: loaded from: classes4.dex */
public final class SavedStateCodecUtilsKt {
    private static final SerialDescriptor booleanArrayDescriptor;
    private static final SerialDescriptor charArrayDescriptor;
    private static final SerialDescriptor doubleArrayDescriptor;
    private static final SerialDescriptor floatArrayDescriptor;
    private static final SerialDescriptor intArrayDescriptor;
    private static final SerialDescriptor intListDescriptor = BuiltinSerializersKt.ListSerializer(BuiltinSerializersKt.serializer(IntCompanionObject.INSTANCE)).getDescriptor();
    private static final SerialDescriptor longArrayDescriptor;
    private static final SerialDescriptor stringArrayDescriptor;
    private static final SerialDescriptor stringListDescriptor;

    public static /* synthetic */ void getStringArrayDescriptor$annotations() {
    }

    static {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        stringListDescriptor = BuiltinSerializersKt.ListSerializer(BuiltinSerializersKt.serializer(stringCompanionObject)).getDescriptor();
        booleanArrayDescriptor = BuiltinSerializersKt.BooleanArraySerializer().getDescriptor();
        charArrayDescriptor = BuiltinSerializersKt.CharArraySerializer().getDescriptor();
        doubleArrayDescriptor = BuiltinSerializersKt.DoubleArraySerializer().getDescriptor();
        floatArrayDescriptor = BuiltinSerializersKt.FloatArraySerializer().getDescriptor();
        intArrayDescriptor = BuiltinSerializersKt.IntArraySerializer().getDescriptor();
        longArrayDescriptor = BuiltinSerializersKt.LongArraySerializer().getDescriptor();
        stringArrayDescriptor = BuiltinSerializersKt.ArraySerializer(Reflection.getOrCreateKotlinClass(String.class), BuiltinSerializersKt.serializer(stringCompanionObject)).getDescriptor();
    }

    public static final SerialDescriptor getIntListDescriptor() {
        return intListDescriptor;
    }

    public static final SerialDescriptor getStringListDescriptor() {
        return stringListDescriptor;
    }

    public static final SerialDescriptor getBooleanArrayDescriptor() {
        return booleanArrayDescriptor;
    }

    public static final SerialDescriptor getCharArrayDescriptor() {
        return charArrayDescriptor;
    }

    public static final SerialDescriptor getDoubleArrayDescriptor() {
        return doubleArrayDescriptor;
    }

    public static final SerialDescriptor getFloatArrayDescriptor() {
        return floatArrayDescriptor;
    }

    public static final SerialDescriptor getIntArrayDescriptor() {
        return intArrayDescriptor;
    }

    public static final SerialDescriptor getLongArrayDescriptor() {
        return longArrayDescriptor;
    }

    public static final SerialDescriptor getStringArrayDescriptor() {
        return stringArrayDescriptor;
    }
}
