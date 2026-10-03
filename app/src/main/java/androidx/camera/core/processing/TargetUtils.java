package androidx.camera.core.processing;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.Quirks$$ExternalSyntheticBackport0;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class TargetUtils {
    public static int getNumberOfTargets(int i) {
        int i2 = 0;
        while (i != 0) {
            i2 += i & 1;
            i >>= 1;
        }
        return i2;
    }

    public static boolean isSuperset(int i, int i2) {
        return (i & i2) == i2;
    }

    private TargetUtils() {
    }

    public static void checkSupportedTargets(@NonNull Collection<Integer> collection, int i) {
        Preconditions.checkArgument(collection.contains(Integer.valueOf(i)), String.format(Locale.US, "Effects target %s is not in the supported list %s.", getHumanReadableName(i), getHumanReadableNames(collection)));
    }

    private static String getHumanReadableNames(@NonNull Collection<Integer> collection) {
        ArrayList arrayList = new ArrayList();
        Iterator<Integer> it2 = collection.iterator();
        while (it2.hasNext()) {
            arrayList.add(getHumanReadableName(it2.next().intValue()));
        }
        return "[" + Quirks$$ExternalSyntheticBackport0.m(", ", arrayList) + "]";
    }

    public static String getHumanReadableName(int i) {
        ArrayList arrayList = new ArrayList();
        if ((i & 4) != 0) {
            arrayList.add("IMAGE_CAPTURE");
        }
        if ((i & 1) != 0) {
            arrayList.add("PREVIEW");
        }
        if ((i & 2) != 0) {
            arrayList.add("VIDEO_CAPTURE");
        }
        return Quirks$$ExternalSyntheticBackport0.m("|", arrayList);
    }
}
