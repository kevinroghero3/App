package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class Quirks {
    private final List<Quirk> mQuirks;

    public Quirks(@NonNull List<Quirk> list) {
        this.mQuirks = new ArrayList(list);
    }

    public <T extends Quirk> T get(@NonNull Class<T> cls) {
        Iterator<Quirk> it2 = this.mQuirks.iterator();
        while (it2.hasNext()) {
            T t = (T) it2.next();
            if (t.getClass() == cls) {
                return t;
            }
        }
        return null;
    }

    public <T extends Quirk> List<T> getAll(@NonNull Class<T> cls) {
        ArrayList arrayList = new ArrayList();
        for (Quirk quirk : this.mQuirks) {
            if (cls.isAssignableFrom(quirk.getClass())) {
                arrayList.add(quirk);
            }
        }
        return arrayList;
    }

    public boolean contains(@NonNull Class<? extends Quirk> cls) {
        Iterator<Quirk> it2 = this.mQuirks.iterator();
        while (it2.hasNext()) {
            if (cls.isAssignableFrom(it2.next().getClass())) {
                return true;
            }
        }
        return false;
    }

    public void addQuirkForTesting(@NonNull Quirk quirk) {
        this.mQuirks.add(quirk);
    }

    public static String toString(@NonNull Quirks quirks) {
        ArrayList arrayList = new ArrayList();
        Iterator<Quirk> it2 = quirks.mQuirks.iterator();
        while (it2.hasNext()) {
            arrayList.add(it2.next().getClass().getSimpleName());
        }
        return Quirks$$ExternalSyntheticBackport0.m(" | ", arrayList);
    }
}
