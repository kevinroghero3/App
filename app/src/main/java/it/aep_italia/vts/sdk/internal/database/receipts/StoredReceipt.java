package it.aep_italia.vts.sdk.internal.database.receipts;

/* JADX INFO: loaded from: classes6.dex */
public class StoredReceipt {
    private long a;
    private long b;
    private int c;
    private String d;

    public StoredReceipt(long j, long j2, int i, String str) {
        this.a = j;
        this.b = j2;
        this.c = i;
        this.d = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.a == ((StoredReceipt) obj).a;
    }

    public long getContractID() {
        return this.b;
    }

    public int getGroupUID() {
        return this.c;
    }

    public long getReceiptUID() {
        return this.a;
    }

    public String getType() {
        return this.d;
    }

    public int hashCode() {
        long j = this.a;
        return (int) (j ^ (j >>> 32));
    }
}
