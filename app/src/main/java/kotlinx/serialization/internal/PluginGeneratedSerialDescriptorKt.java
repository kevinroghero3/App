package kotlinx.serialization.internal;

import java.util.Arrays;
import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorKt;
import kotlinx.serialization.descriptors.SerialKind;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public final class PluginGeneratedSerialDescriptorKt {
    public static final /* synthetic */ <SD extends SerialDescriptor> boolean equalsImpl(SD sd, Object obj, Function1<? super SD, Boolean> typeParamsAreEqual) {
        Intrinsics.checkNotNullParameter(sd, "<this>");
        Intrinsics.checkNotNullParameter(typeParamsAreEqual, "typeParamsAreEqual");
        if (sd == obj) {
            return true;
        }
        Intrinsics.reifiedOperationMarker(3, "SD");
        if (!(obj instanceof SerialDescriptor)) {
            return false;
        }
        SerialDescriptor serialDescriptor = (SerialDescriptor) obj;
        if (!Intrinsics.areEqual(sd.getSerialName(), serialDescriptor.getSerialName()) || !typeParamsAreEqual.invoke(obj).booleanValue() || sd.getElementsCount() != serialDescriptor.getElementsCount()) {
            return false;
        }
        int elementsCount = sd.getElementsCount();
        for (int i = 0; i < elementsCount; i++) {
            if (!Intrinsics.areEqual(sd.getElementDescriptor(i).getSerialName(), serialDescriptor.getElementDescriptor(i).getSerialName()) || !Intrinsics.areEqual(sd.getElementDescriptor(i).getKind(), serialDescriptor.getElementDescriptor(i).getKind())) {
                return false;
            }
        }
        return true;
    }

    public static final int hashCodeImpl(@NotNull SerialDescriptor serialDescriptor, @NotNull SerialDescriptor[] typeParams) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(typeParams, "typeParams");
        int iHashCode = serialDescriptor.getSerialName().hashCode();
        int iHashCode2 = Arrays.hashCode(typeParams);
        Iterable<SerialDescriptor> elementDescriptors = SerialDescriptorKt.getElementDescriptors(serialDescriptor);
        Iterator<SerialDescriptor> it2 = elementDescriptors.iterator();
        int iHashCode3 = 1;
        int i = 1;
        while (true) {
            int iHashCode4 = 0;
            if (!it2.hasNext()) {
                break;
            }
            String serialName = it2.next().getSerialName();
            if (serialName != null) {
                iHashCode4 = serialName.hashCode();
            }
            i = (i * 31) + iHashCode4;
        }
        Iterator<SerialDescriptor> it3 = elementDescriptors.iterator();
        while (it3.hasNext()) {
            SerialKind kind = it3.next().getKind();
            iHashCode3 = (iHashCode3 * 31) + (kind != null ? kind.hashCode() : 0);
        }
        return (((((iHashCode * 31) + iHashCode2) * 31) + i) * 31) + iHashCode3;
    }
}
