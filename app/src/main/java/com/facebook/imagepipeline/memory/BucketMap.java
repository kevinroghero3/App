package com.facebook.imagepipeline.memory;

import android.util.SparseArray;
import java.util.LinkedList;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public class BucketMap<T> {

    @Nullable
    LinkedEntry<T> mHead;
    protected final SparseArray<LinkedEntry<T>> mMap = new SparseArray<>();

    @Nullable
    LinkedEntry<T> mTail;

    static class LinkedEntry<I> {
        int key;

        @Nullable
        LinkedEntry<I> next;

        @Nullable
        LinkedEntry<I> prev;
        LinkedList<I> value;

        private LinkedEntry(@Nullable LinkedEntry<I> linkedEntry, int i, LinkedList<I> linkedList, @Nullable LinkedEntry<I> linkedEntry2) {
            this.prev = linkedEntry;
            this.key = i;
            this.value = linkedList;
            this.next = linkedEntry2;
        }

        public String toString() {
            return "LinkedEntry(key: " + this.key + ")";
        }
    }

    @Nullable
    public T acquire(int i) {
        synchronized (this) {
            LinkedEntry<T> linkedEntry = this.mMap.get(i);
            if (linkedEntry == null) {
                return null;
            }
            T tPollFirst = linkedEntry.value.pollFirst();
            moveToFront(linkedEntry);
            return tPollFirst;
        }
    }

    public void release(int i, T t) {
        synchronized (this) {
            LinkedEntry<T> linkedEntry = this.mMap.get(i);
            if (linkedEntry == null) {
                linkedEntry = new LinkedEntry<>(null, i, new LinkedList(), null);
                this.mMap.put(i, linkedEntry);
            }
            linkedEntry.value.addLast(t);
            moveToFront(linkedEntry);
        }
    }

    int valueCount() {
        int size;
        synchronized (this) {
            size = 0;
            for (LinkedEntry linkedEntry = this.mHead; linkedEntry != null; linkedEntry = linkedEntry.next) {
                LinkedList<I> linkedList = linkedEntry.value;
                if (linkedList != 0) {
                    size += linkedList.size();
                }
            }
        }
        return size;
    }

    private void prune(LinkedEntry<T> linkedEntry) {
        synchronized (this) {
            LinkedEntry linkedEntry2 = (LinkedEntry<T>) linkedEntry.prev;
            LinkedEntry linkedEntry3 = (LinkedEntry<T>) linkedEntry.next;
            if (linkedEntry2 != null) {
                linkedEntry2.next = linkedEntry3;
            }
            if (linkedEntry3 != null) {
                linkedEntry3.prev = linkedEntry2;
            }
            linkedEntry.prev = null;
            linkedEntry.next = null;
            if (linkedEntry == this.mHead) {
                this.mHead = linkedEntry3;
            }
            if (linkedEntry == this.mTail) {
                this.mTail = linkedEntry2;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void moveToFront(LinkedEntry<T> linkedEntry) {
        if (this.mHead == linkedEntry) {
            return;
        }
        prune(linkedEntry);
        LinkedEntry<T> linkedEntry2 = this.mHead;
        if (linkedEntry2 == 0) {
            this.mHead = linkedEntry;
            this.mTail = linkedEntry;
        } else {
            linkedEntry.next = linkedEntry2;
            linkedEntry2.prev = linkedEntry;
            this.mHead = linkedEntry;
        }
    }

    @Nullable
    public T removeFromEnd() {
        synchronized (this) {
            LinkedEntry<T> linkedEntry = this.mTail;
            if (linkedEntry == null) {
                return null;
            }
            T tPollLast = linkedEntry.value.pollLast();
            maybePrune(linkedEntry);
            return tPollLast;
        }
    }

    private void maybePrune(LinkedEntry<T> linkedEntry) {
        if (linkedEntry == null || !linkedEntry.value.isEmpty()) {
            return;
        }
        prune(linkedEntry);
        this.mMap.remove(linkedEntry.key);
    }
}
