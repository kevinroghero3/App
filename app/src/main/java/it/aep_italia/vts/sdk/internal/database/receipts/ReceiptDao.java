package it.aep_italia.vts.sdk.internal.database.receipts;

import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public interface ReceiptDao {
    void deleteByReceiptUID(long j);

    void deleteReceipts(Collection<StoredReceipt> collection);

    StoredReceipt readByContractID(long j);

    List<StoredReceipt> readByGroupUID(int i);

    StoredReceipt readByReceiptUID(long j);

    void saveReceipt(StoredReceipt storedReceipt);
}
