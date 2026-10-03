package com.facebook.imagepipeline.memory;

import android.graphics.Bitmap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.imageutils.BitmapUtil;

/* JADX INFO: loaded from: classes4.dex */
public class BitmapCounter {
    private int mCount;
    private final int mMaxCount;
    private final int mMaxSize;
    private long mSize;
    private final ResourceReleaser<Bitmap> mUnpooledBitmapsReleaser;

    public BitmapCounter(int i, int i2) {
        Preconditions.checkArgument(Boolean.valueOf(i > 0));
        Preconditions.checkArgument(Boolean.valueOf(i2 > 0));
        this.mMaxCount = i;
        this.mMaxSize = i2;
        this.mUnpooledBitmapsReleaser = new ResourceReleaser<Bitmap>() { // from class: com.facebook.imagepipeline.memory.BitmapCounter.1
            @Override // com.facebook.common.references.ResourceReleaser
            public void release(Bitmap bitmap) {
                try {
                    BitmapCounter.this.decrease(bitmap);
                } finally {
                    bitmap.recycle();
                }
            }
        };
    }

    public boolean increase(Bitmap bitmap) {
        synchronized (this) {
            int sizeInBytes = BitmapUtil.getSizeInBytes(bitmap);
            int i = this.mCount;
            if (i < this.mMaxCount) {
                long j = this.mSize + ((long) sizeInBytes);
                if (j <= this.mMaxSize) {
                    this.mCount = i + 1;
                    this.mSize = j;
                    return true;
                }
            }
            return false;
        }
    }

    public void decrease(Bitmap bitmap) {
        synchronized (this) {
            int sizeInBytes = BitmapUtil.getSizeInBytes(bitmap);
            Preconditions.checkArgument(this.mCount > 0, "No bitmaps registered.");
            long j = sizeInBytes;
            long j2 = this.mSize;
            Preconditions.checkArgument(j <= j2, "Bitmap size bigger than the total registered size: %d, %d", Integer.valueOf(sizeInBytes), Long.valueOf(j2));
            this.mSize -= j;
            this.mCount--;
        }
    }

    public int getCount() {
        int i;
        synchronized (this) {
            i = this.mCount;
        }
        return i;
    }

    public long getSize() {
        long j;
        synchronized (this) {
            j = this.mSize;
        }
        return j;
    }

    public int getMaxCount() {
        int i;
        synchronized (this) {
            i = this.mMaxCount;
        }
        return i;
    }

    public int getMaxSize() {
        int i;
        synchronized (this) {
            i = this.mMaxSize;
        }
        return i;
    }

    public ResourceReleaser<Bitmap> getReleaser() {
        return this.mUnpooledBitmapsReleaser;
    }
}
