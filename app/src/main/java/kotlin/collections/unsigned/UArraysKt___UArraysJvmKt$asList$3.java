package kotlin.collections.unsigned;

import java.util.RandomAccess;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt___ArraysKt;

/* JADX INFO: loaded from: classes.dex */
public final class UArraysKt___UArraysJvmKt$asList$3 extends AbstractList<UByte> implements RandomAccess {
    final /* synthetic */ byte[] $this_asList;

    UArraysKt___UArraysJvmKt$asList$3(byte[] bArr) {
        this.$this_asList = bArr;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        if (obj instanceof UByte) {
            return m6000contains7apg3OU(((UByte) obj).m5540unboximpl());
        }
        return false;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public /* synthetic */ Object get(int i) {
        return UByte.m5484boximpl(m6001getw2LRezQ(i));
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (obj instanceof UByte) {
            return m6002indexOf7apg3OU(((UByte) obj).m5540unboximpl());
        }
        return -1;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        if (obj instanceof UByte) {
            return m6003lastIndexOf7apg3OU(((UByte) obj).m5540unboximpl());
        }
        return -1;
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public int getSize() {
        return UByteArray.m5549getSizeimpl(this.$this_asList);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return UByteArray.m5551isEmptyimpl(this.$this_asList);
    }

    /* JADX INFO: renamed from: contains-7apg3OU, reason: not valid java name */
    public boolean m6000contains7apg3OU(byte b) {
        return UByteArray.m5544contains7apg3OU(this.$this_asList, b);
    }

    /* JADX INFO: renamed from: get-w2LRezQ, reason: not valid java name */
    public byte m6001getw2LRezQ(int i) {
        return UByteArray.m5548getw2LRezQ(this.$this_asList, i);
    }

    /* JADX INFO: renamed from: indexOf-7apg3OU, reason: not valid java name */
    public int m6002indexOf7apg3OU(byte b) {
        return ArraysKt___ArraysKt.indexOf(this.$this_asList, b);
    }

    /* JADX INFO: renamed from: lastIndexOf-7apg3OU, reason: not valid java name */
    public int m6003lastIndexOf7apg3OU(byte b) {
        return ArraysKt___ArraysKt.lastIndexOf(this.$this_asList, b);
    }
}
