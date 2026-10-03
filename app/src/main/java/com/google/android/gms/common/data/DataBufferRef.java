package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: loaded from: classes4.dex */
public abstract class DataBufferRef {
    protected final DataHolder mDataHolder;
    protected int mDataRow;
    private int zaa;

    public DataBufferRef(@NonNull DataHolder dataHolder, int i) {
        this.mDataHolder = (DataHolder) Preconditions.checkNotNull(dataHolder);
        zaa(i);
    }

    protected void copyToBuffer(@NonNull String str, @NonNull CharArrayBuffer charArrayBuffer) {
        this.mDataHolder.zac(str, this.mDataRow, this.zaa, charArrayBuffer);
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof DataBufferRef)) {
            return false;
        }
        DataBufferRef dataBufferRef = (DataBufferRef) obj;
        return Objects.equal(Integer.valueOf(dataBufferRef.mDataRow), Integer.valueOf(this.mDataRow)) && Objects.equal(Integer.valueOf(dataBufferRef.zaa), Integer.valueOf(this.zaa)) && dataBufferRef.mDataHolder == this.mDataHolder;
    }

    protected boolean getBoolean(@NonNull String str) {
        return this.mDataHolder.getBoolean(str, this.mDataRow, this.zaa);
    }

    protected byte[] getByteArray(@NonNull String str) {
        return this.mDataHolder.getByteArray(str, this.mDataRow, this.zaa);
    }

    protected int getDataRow() {
        return this.mDataRow;
    }

    protected double getDouble(@NonNull String str) {
        return this.mDataHolder.zaa(str, this.mDataRow, this.zaa);
    }

    protected float getFloat(@NonNull String str) {
        return this.mDataHolder.zab(str, this.mDataRow, this.zaa);
    }

    protected int getInteger(@NonNull String str) {
        return this.mDataHolder.getInteger(str, this.mDataRow, this.zaa);
    }

    protected long getLong(@NonNull String str) {
        return this.mDataHolder.getLong(str, this.mDataRow, this.zaa);
    }

    protected String getString(@NonNull String str) {
        return this.mDataHolder.getString(str, this.mDataRow, this.zaa);
    }

    public boolean hasColumn(@NonNull String str) {
        return this.mDataHolder.hasColumn(str);
    }

    protected boolean hasNull(@NonNull String str) {
        return this.mDataHolder.hasNull(str, this.mDataRow, this.zaa);
    }

    public int hashCode() {
        int i = this.mDataRow;
        int i2 = this.zaa;
        return Objects.hashCode(Integer.valueOf(i), Integer.valueOf(i2), this.mDataHolder);
    }

    public boolean isDataValid() {
        return !this.mDataHolder.isClosed();
    }

    protected Uri parseUri(@NonNull String str) {
        String string = this.mDataHolder.getString(str, this.mDataRow, this.zaa);
        if (string == null) {
            return null;
        }
        return Uri.parse(string);
    }

    protected final void zaa(int i) {
        Preconditions.checkState(i >= 0 && i < this.mDataHolder.getCount());
        this.mDataRow = i;
        this.zaa = this.mDataHolder.getWindowIndex(i);
    }
}
