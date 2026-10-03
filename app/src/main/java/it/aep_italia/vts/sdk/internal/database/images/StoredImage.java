package it.aep_italia.vts.sdk.internal.database.images;

/* JADX INFO: loaded from: classes6.dex */
public class StoredImage implements Comparable<StoredImage> {
    private long a;
    private int b;
    private long c;
    private long d;
    private int e;

    public StoredImage(long j, int i, long j2, long j3, int i2) {
        this.a = j;
        this.b = i;
        this.c = j2;
        this.d = j3;
        this.e = i2;
    }

    @Override // java.lang.Comparable
    public int compareTo(StoredImage storedImage) {
        if (storedImage == null) {
            return 1;
        }
        return (int) Math.signum(storedImage.d - this.d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.a == ((StoredImage) obj).a;
    }

    public int getByteSize() {
        return this.b;
    }

    public long getDownloadDate() {
        return this.c;
    }

    public int getSignatureCount() {
        return this.e;
    }

    public long getUsageDate() {
        return this.d;
    }

    public long getVTokenUID() {
        return this.a;
    }

    public int hashCode() {
        long j = this.a;
        return (int) (j ^ (j >>> 32));
    }

    public void setUsageDate(long j) {
        this.d = j;
    }
}
