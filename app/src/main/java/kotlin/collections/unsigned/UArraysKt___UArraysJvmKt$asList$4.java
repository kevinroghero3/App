package kotlin.collections.unsigned;

import java.util.RandomAccess;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt___ArraysKt;

/* JADX INFO: loaded from: classes.dex */
public final class UArraysKt___UArraysJvmKt$asList$4 extends AbstractList<UShort> implements RandomAccess {
    final /* synthetic */ short[] $this_asList;

    UArraysKt___UArraysJvmKt$asList$4(short[] sArr) {
        this.$this_asList = sArr;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        if (obj instanceof UShort) {
            return m6004containsxj2QHRw(((UShort) obj).m5803unboximpl());
        }
        return false;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public /* synthetic */ Object get(int i) {
        return UShort.m5747boximpl(m6005getMh2AYeg(i));
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (obj instanceof UShort) {
            return m6006indexOfxj2QHRw(((UShort) obj).m5803unboximpl());
        }
        return -1;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        if (obj instanceof UShort) {
            return m6007lastIndexOfxj2QHRw(((UShort) obj).m5803unboximpl());
        }
        return -1;
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public int getSize() {
        return UShortArray.m5812getSizeimpl(this.$this_asList);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return UShortArray.m5814isEmptyimpl(this.$this_asList);
    }

    /* JADX INFO: renamed from: contains-xj2QHRw, reason: not valid java name */
    public boolean m6004containsxj2QHRw(short s) {
        return UShortArray.m5807containsxj2QHRw(this.$this_asList, s);
    }

    /* JADX INFO: renamed from: get-Mh2AYeg, reason: not valid java name */
    public short m6005getMh2AYeg(int i) {
        return UShortArray.m5811getMh2AYeg(this.$this_asList, i);
    }

    /* JADX INFO: renamed from: indexOf-xj2QHRw, reason: not valid java name */
    public int m6006indexOfxj2QHRw(short s) {
        return ArraysKt___ArraysKt.indexOf(this.$this_asList, s);
    }

    /* JADX INFO: renamed from: lastIndexOf-xj2QHRw, reason: not valid java name */
    public int m6007lastIndexOfxj2QHRw(short s) {
        return ArraysKt___ArraysKt.lastIndexOf(this.$this_asList, s);
    }
}
