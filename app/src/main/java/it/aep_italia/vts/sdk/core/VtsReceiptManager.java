package it.aep_italia.vts.sdk.core;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.core.content.FileProvider;
import androidx.webkit.internal.AssetHelper;
import it.aep_italia.vts.sdk.domain.VtsContract;
import it.aep_italia.vts.sdk.domain.enums.VtsObjectTypeFormat;
import it.aep_italia.vts.sdk.domain.enums.VtsReceiptType;
import it.aep_italia.vts.sdk.dto.domain.VtsVTokenInfoDTO;
import it.aep_italia.vts.sdk.dto.utils.VtsReceiptDTO;
import it.aep_italia.vts.sdk.errors.VtsError;
import it.aep_italia.vts.sdk.errors.VtsException;
import it.aep_italia.vts.sdk.internal.database.SharedDatabase;
import it.aep_italia.vts.sdk.internal.database.receipts.ReceiptDao;
import it.aep_italia.vts.sdk.internal.database.receipts.StoredReceipt;
import it.aep_italia.vts.sdk.utils.ByteUtils;
import it.aep_italia.vts.sdk.utils.ListenableFuture;
import it.aep_italia.vts.sdk.utils.StreamUtils;
import it.aep_italia.vts.sdk.utils.StringUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public final class VtsReceiptManager {
    private VtsSdk a;

    class a implements Runnable {
        final /* synthetic */ Map a;
        final /* synthetic */ ListenableFuture b;

        a(Map map, ListenableFuture listenableFuture) {
            this.a = map;
            this.b = listenableFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i = 0;
            for (Long l : this.a.keySet()) {
                Long l2 = (Long) this.a.get(l);
                l2.longValue();
                try {
                    VtsReceiptManager.this.a(l.longValue(), l2);
                    i++;
                } catch (VtsException e) {
                    VtsLog.e(e, "Receipt could not be downloaded", new Object[0]);
                }
            }
            this.b.setResultOnUiThread(Integer.valueOf(i));
        }
    }

    static /* synthetic */ class b {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[VtsReceiptType.values().length];
            b = iArr;
            try {
                iArr[VtsReceiptType.PDF.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[VtsReceiptType.XML.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[VtsReceiptType.TEXT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[VtsObjectTypeFormat.values().length];
            a = iArr2;
            try {
                iArr2[VtsObjectTypeFormat.PDF.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[VtsObjectTypeFormat.PLAINTEXT.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[VtsObjectTypeFormat.XML.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    VtsReceiptManager(VtsSdk vtsSdk) {
        this.a = vtsSdk;
    }

    private VtsReceiptType a(VtsObjectTypeFormat vtsObjectTypeFormat) {
        if (vtsObjectTypeFormat == null) {
            return null;
        }
        int i = b.a[vtsObjectTypeFormat.ordinal()];
        if (i == 1) {
            return VtsReceiptType.PDF;
        }
        if (i == 2) {
            return VtsReceiptType.TEXT;
        }
        if (i != 3) {
            return null;
        }
        return VtsReceiptType.XML;
    }

    private ReceiptDao a() {
        return SharedDatabase.getInstance(this.a).receiptDao();
    }

    private File a(long j, VtsReceiptType vtsReceiptType) {
        String fullHexString = StringUtils.toFullHexString(Long.valueOf(j));
        Locale locale = Locale.ITALY;
        int systemType = this.a.getSystemType();
        int systemSubType = this.a.getSystemSubType();
        return new File(b(), String.format(locale, "%d_%d_%s%s", Integer.valueOf(systemType), Integer.valueOf(systemSubType), fullHexString, a(vtsReceiptType)));
    }

    private String a(VtsReceiptType vtsReceiptType) {
        if (vtsReceiptType == null) {
            return "";
        }
        int i = b.b[vtsReceiptType.ordinal()];
        if (i == 1) {
            return ".pdf";
        }
        if (i != 2) {
            return i != 3 ? "" : ".txt";
        }
        return ".xml";
    }

    private void a(VtsVTokenInfoDTO vtsVTokenInfoDTO, Long l) throws IOException {
        long vTokenUIDAsLong = vtsVTokenInfoDTO.getVTokenUIDAsLong();
        if (vTokenUIDAsLong > 0) {
            byte[] tokenContents = vtsVTokenInfoDTO.getTokenContents();
            if (l == null) {
                l = Long.valueOf(ByteUtils.bytesToLong(ByteUtils.extract(tokenContents, 31, 8)));
                VtsLog.d("Attempting to save receipt with unknown contract ID; the receipt's ObjectUID (%s) will be used instead.", StringUtils.toFullHexString(l));
            }
            VtsReceiptType vtsReceiptTypeA = a(VtsObjectTypeFormat.parse(tokenContents[40]));
            int iBytesToInt = ByteUtils.bytesToInt(ByteUtils.extract(tokenContents, 45, 4));
            VtsLog.i("Receipt with UID %s has GroupUID %d, ContractID %s, and ReceiptType %s", StringUtils.toFullHexString(Long.valueOf(vtsVTokenInfoDTO.getVTokenUIDAsLong())), Integer.valueOf(iBytesToInt), StringUtils.toFullHexString(l), vtsReceiptTypeA.name());
            StreamUtils.writeAndClose(tokenContents, 57, tokenContents.length - 57, new FileOutputStream(a(vTokenUIDAsLong, vtsReceiptTypeA)));
            a().saveReceipt(new StoredReceipt(vTokenUIDAsLong, l.longValue(), iBytesToInt, vtsReceiptTypeA.value()));
        }
    }

    private File b() {
        File externalFilesDir = this.a.getSdkConfiguration().dataOnExternal() ? this.a.getContext().getExternalFilesDir("receipts") : new File(this.a.getContext().getFilesDir(), "receipts");
        if (!externalFilesDir.exists()) {
            externalFilesDir.mkdir();
        }
        if (!externalFilesDir.exists()) {
            externalFilesDir.mkdirs();
        }
        return externalFilesDir;
    }

    private String b(VtsReceiptType vtsReceiptType) {
        if (vtsReceiptType == null) {
            return null;
        }
        int i = b.b[vtsReceiptType.ordinal()];
        if (i == 1) {
            return "application/pdf";
        }
        if (i == 2) {
            return "text/xml";
        }
        if (i != 3) {
            return null;
        }
        return AssetHelper.DEFAULT_MIME_TYPE;
    }

    ListenableFuture<Integer> a(Map<Long, Long> map) throws VtsException {
        ListenableFuture<Integer> listenableFuture = new ListenableFuture<>();
        new Thread(new a(map, listenableFuture)).start();
        return listenableFuture;
    }

    List<Long> a(List<VtsContract> list, Integer num) throws VtsException {
        if (list == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<VtsContract> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList.add(Long.toString(it2.next().getUID()));
        }
        this.a.a("VtsReceiptmanager#removeReceiptForContracts", StringUtils.stringifyParams("ContractIDs", arrayList, "GroupUID", num));
        ReceiptDao receiptDaoA = a();
        HashSet<StoredReceipt> hashSet = new HashSet();
        Iterator<VtsContract> it3 = list.iterator();
        while (it3.hasNext()) {
            StoredReceipt byContractID = receiptDaoA.readByContractID(it3.next().getUID());
            if (byContractID != null) {
                hashSet.add(byContractID);
            }
        }
        if (num != null) {
            hashSet.addAll(receiptDaoA.readByGroupUID(num.intValue()));
        }
        ArrayList arrayList2 = new ArrayList();
        for (StoredReceipt storedReceipt : hashSet) {
            VtsLog.i("Deleting receipt with UID %s...", StringUtils.toFullHexString(Long.valueOf(storedReceipt.getReceiptUID())));
            try {
                a(storedReceipt.getReceiptUID(), VtsReceiptType.parse(storedReceipt.getType())).delete();
            } catch (Exception e) {
                VtsLog.e(e, "Could not delete receipt from filesystem", new Object[0]);
            }
            arrayList2.add(Long.valueOf(storedReceipt.getReceiptUID()));
        }
        receiptDaoA.deleteReceipts(hashSet);
        return arrayList2;
    }

    boolean a(long j) {
        return a().readByReceiptUID(j) != null;
    }

    byte[] a(long j, Long l) throws VtsException {
        this.a.a("VtsReceiptmanager#downloadReceiptSynchronously", StringUtils.stringifyParams("ReceiptUID", Long.valueOf(j), "ContractID", l));
        VtsLog.i("Downloading receipt with UID %s for contract %s...", StringUtils.toFullHexString(Long.valueOf(j)), l == null ? "(missing)" : StringUtils.toFullHexString(l));
        VtsConnection vtsConnectionE = null;
        try {
            try {
                vtsConnectionE = this.a.e();
                VtsVTokenInfoDTO vtsVTokenInfoDTOA = vtsConnectionE.a(j);
                a(vtsVTokenInfoDTOA, l);
                VtsLog.i("Receipt with UID %s downloaded and saved successfully.", StringUtils.toFullHexString(Long.valueOf(j)));
                try {
                    vtsConnectionE.closeConnection();
                } catch (Exception e) {
                    VtsLog.e(e, "Could not close connection", new Object[0]);
                }
                return vtsVTokenInfoDTOA.getTokenContents();
            } catch (Exception e2) {
                VtsLog.e(e2, "Could not download receipt", new Object[0]);
                a().deleteByReceiptUID(j);
                throw new VtsException(VtsError.COULD_NOT_DOWNLOAD_RECEIPT, e2);
            }
        } catch (Throwable th) {
            if (vtsConnectionE != null) {
                try {
                    vtsConnectionE.closeConnection();
                } catch (Exception e3) {
                    VtsLog.e(e3, "Could not close connection", new Object[0]);
                }
            }
            throw th;
        }
    }

    public boolean hasReceipt(long j) {
        return a().readByContractID(j) != null;
    }

    public VtsReceiptDTO loadReceipt(long j) {
        this.a.a("VtsReceiptmanager#loadReceipt", StringUtils.stringifyParams("ContractID", Long.valueOf(j)));
        StoredReceipt byContractID = a().readByContractID(j);
        if (byContractID == null) {
            return null;
        }
        try {
            return new VtsReceiptDTO(VtsReceiptType.parse(byContractID.getType()), StreamUtils.extractAllAndClose(new FileInputStream(a(byContractID.getReceiptUID(), VtsReceiptType.parse(byContractID.getType())))));
        } catch (Exception e) {
            VtsLog.e(e, "Could not load receipt from disk", new Object[0]);
            throw new VtsException(VtsError.COULD_NOT_LOAD_RECEIPT, e);
        }
    }

    public File loadReceiptFile(long j) {
        this.a.a("VtsReceiptmanager#loadReceipt", StringUtils.stringifyParams("ContractID", Long.valueOf(j)));
        StoredReceipt byContractID = a().readByContractID(j);
        if (byContractID == null) {
            return null;
        }
        try {
            return a(byContractID.getReceiptUID(), VtsReceiptType.parse(byContractID.getType()));
        } catch (Exception e) {
            VtsLog.e(e, "Could not load receipt from disk", new Object[0]);
            throw new VtsException(VtsError.COULD_NOT_LOAD_RECEIPT, e);
        }
    }

    public Intent openReceipt(long j) {
        this.a.a("VtsReceiptmanager#openReceipt", StringUtils.stringifyParams("ContractID", Long.valueOf(j)));
        StoredReceipt byContractID = a().readByContractID(j);
        if (byContractID == null) {
            return null;
        }
        try {
            VtsReceiptType vtsReceiptType = VtsReceiptType.parse(byContractID.getType());
            String strB = b(VtsReceiptType.parse(byContractID.getType()));
            if (strB == null) {
                return null;
            }
            Context context = this.a.getContext();
            Uri uriForFile = FileProvider.getUriForFile(context, context.getApplicationContext().getPackageName() + ".it.aep_italia.vts.sdk.provider", a(byContractID.getReceiptUID(), vtsReceiptType));
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(uriForFile, strB);
            intent.setFlags(1);
            return intent;
        } catch (Exception e) {
            VtsLog.e(e, "Could not load receipt from disk", new Object[0]);
            return null;
        }
    }
}
