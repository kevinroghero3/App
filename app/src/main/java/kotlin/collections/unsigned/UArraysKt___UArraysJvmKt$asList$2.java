package kotlin.collections.unsigned;

import java.util.RandomAccess;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt___ArraysKt;

/* JADX INFO: loaded from: classes.dex */
public final class UArraysKt___UArraysJvmKt$asList$2 extends AbstractList<ULong> implements RandomAccess {
    final /* synthetic */ long[] $this_asList;

    UArraysKt___UArraysJvmKt$asList$2(long[] jArr) {
        this.$this_asList = jArr;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        if (obj instanceof ULong) {
            return m5996containsVKZWuLQ(((ULong) obj).m5698unboximpl());
        }
        return false;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public /* synthetic */ Object get(int i) {
        return ULong.m5640boximpl(m5997getsVKNKU(i));
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (obj instanceof ULong) {
            return m5998indexOfVKZWuLQ(((ULong) obj).m5698unboximpl());
        }
        return -1;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        if (obj instanceof ULong) {
            return m5999lastIndexOfVKZWuLQ(((ULong) obj).m5698unboximpl());
        }
        return -1;
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public int getSize() {
        return ULongArray.m5707getSizeimpl(this.$this_asList);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return ULongArray.m5709isEmptyimpl(this.$this_asList);
    }

    /* JADX INFO: renamed from: contains-VKZWuLQ, reason: not valid java name */
    public boolean m5996containsVKZWuLQ(long j) {
        return ULongArray.m5702containsVKZWuLQ(this.$this_asList, j);
    }

    /* JADX INFO: renamed from: get-s-VKNKU, reason: not valid java name */
    public long m5997getsVKNKU(int i) {
        return ULongArray.m5706getsVKNKU(this.$this_asList, i);
    }

    /* JADX INFO: renamed from: indexOf-VKZWuLQ, reason: not valid java name */
    public int m5998indexOfVKZWuLQ(long j) {
        return ArraysKt___ArraysKt.indexOf(this.$this_asList, j);
    }

    /* JADX INFO: renamed from: lastIndexOf-VKZWuLQ, reason: not valid java name */
    public int m5999lastIndexOfVKZWuLQ(long j) {
        return ArraysKt___ArraysKt.lastIndexOf(this.$this_asList, j);
    }
}
