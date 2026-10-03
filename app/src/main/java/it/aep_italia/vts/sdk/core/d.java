package it.aep_italia.vts.sdk.core;

import android.content.Context;
import it.aep_italia.vts.sdk.domain.VtsContract;
import it.aep_italia.vts.sdk.domain.VtsSynchronization;
import it.aep_italia.vts.sdk.domain.enums.VtsObjectType;
import it.aep_italia.vts.sdk.domain.enums.VtsObjectTypeFormat;
import it.aep_italia.vts.sdk.domain.enums.VtsVTokenStatus;
import it.aep_italia.vts.sdk.dto.domain.VtsSynchronizationDTO;
import it.aep_italia.vts.sdk.dto.domain.VtsVTokenDTO;
import it.aep_italia.vts.sdk.dto.domain.VtsVTokenInfoDTO;
import it.aep_italia.vts.sdk.dto.domain.token.payload.VtsVTokenPayloadContractDTO;
import it.aep_italia.vts.sdk.dto.soap.functions.requests.GetVTokenListInput;
import it.aep_italia.vts.sdk.dto.utils.VtsContractListDTO;
import it.aep_italia.vts.sdk.errors.VtsError;
import it.aep_italia.vts.sdk.errors.VtsException;
import it.aep_italia.vts.sdk.internal.VtsVTokenByteParser;
import it.aep_italia.vts.sdk.utils.DateUtils;
import it.aep_italia.vts.sdk.utils.DeviceUtils;
import it.aep_italia.vts.sdk.utils.ListenableFuture;
import it.aep_italia.vts.sdk.utils.SerializationUtils;
import it.aep_italia.vts.sdk.utils.StringUtils;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
final class d {
    private final VtsSyncService a;
    private VtsSdk b;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[VtsObjectTypeFormat.values().length];
            a = iArr;
            try {
                iArr[VtsObjectTypeFormat.BMP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[VtsObjectTypeFormat.JPEG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[VtsObjectTypeFormat.PNG.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public d(VtsSyncService vtsSyncService, VtsSdk vtsSdk) {
        this.a = vtsSyncService;
        this.b = vtsSdk;
    }

    private int a(long j) throws VtsException {
        e eVarD = this.b.d();
        if (eVarD.e(j)) {
            return eVarD.d(j).getSignatureCount();
        }
        return -1;
    }

    static VtsSynchronizationDTO a(Context context) {
        try {
            String string = context.getSharedPreferences("it.aep_italia.vts.nfc.PREFS", 0).getString("it.aep_italia.vts.nfc.SYNC_DETAILS", null);
            if (StringUtils.isBlank(string)) {
                return null;
            }
            return (VtsSynchronizationDTO) SerializationUtils.deserializeFromXml(string, VtsSynchronizationDTO.class);
        } catch (Exception e) {
            VtsLog.e(e, "getLastSynchronization() Could not load last synchronization details", new Object[0]);
            return null;
        }
    }

    private List<VtsVTokenInfoDTO> a(VtsConnection vtsConnection) {
        VtsLog.d("getVTokenList() STARTS", new Object[0]);
        List<VtsVTokenInfoDTO> listA = vtsConnection.a(this.b.getDeviceUID(), GetVTokenListInput.ListType.ALL, VtsVTokenStatus.ACTIVE);
        Iterator<VtsVTokenInfoDTO> it2 = listA.iterator();
        while (it2.hasNext()) {
            VtsVTokenInfoDTO next = it2.next();
            if (next.getVTokenStatus() == null || !StringUtils.isHexNumber(next.getVTokenUID())) {
                it2.remove();
            }
        }
        VtsLog.i("getVTokenList() Read %d VTokens from the server.", Integer.valueOf(listA.size()));
        VtsLog.d("getVTokenList() CMPLETE", new Object[0]);
        return listA;
    }

    private List<VtsVTokenInfoDTO> a(List<VtsVTokenInfoDTO> list, VtsConnection vtsConnection) throws Exception {
        VtsLog.d("synchronizeTokens() STARTS", new Object[0]);
        VtsReceiptManager receiptManager = this.b.getReceiptManager();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (VtsVTokenInfoDTO vtsVTokenInfoDTO : list) {
            if (d(vtsVTokenInfoDTO)) {
                if (!receiptManager.a(vtsVTokenInfoDTO.getVTokenUIDAsLong())) {
                    arrayList3.add(vtsVTokenInfoDTO);
                }
            } else if (!c(vtsVTokenInfoDTO)) {
                int iB = b(vtsVTokenInfoDTO);
                if (iB < 0) {
                    arrayList.add(vtsVTokenInfoDTO);
                } else if (iB > 0) {
                    arrayList2.add(vtsVTokenInfoDTO);
                }
            }
        }
        VtsLog.d("synchronizeTokens() Found %d VTokens to download ( %d Receipts ) and %d VTokens to upload. Starting Download and Upload phase...", Integer.valueOf(arrayList.size()), Integer.valueOf(arrayList3.size()), Integer.valueOf(arrayList2.size()));
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            a((VtsVTokenInfoDTO) it2.next(), vtsConnection);
        }
        Iterator it3 = arrayList2.iterator();
        while (it3.hasNext()) {
            b((VtsVTokenInfoDTO) it3.next(), vtsConnection);
        }
        VtsLog.i("synchronizeTokens() Download and Upload phase COMPLETE. Downloaded %d VTokens ( %d Receipts ) and uploaded %d VTokens.", Integer.valueOf(arrayList.size()), Integer.valueOf(arrayList3.size()), Integer.valueOf(arrayList2.size()));
        VtsLog.d("synchronizeTokens() COMPLETE", new Object[0]);
        return arrayList3;
    }

    private void a(VtsSynchronization.Status status, Date date, Date date2, Throwable th) {
        String message;
        if (th == null) {
            message = null;
        } else {
            try {
                message = th.getMessage();
            } catch (Exception e) {
                VtsLog.e(e, "updateStatus() Could not persist last synchronization details", new Object[0]);
                return;
            }
        }
        VtsSynchronizationDTO vtsSynchronizationDTO = new VtsSynchronizationDTO();
        vtsSynchronizationDTO.setStatus(status.name());
        vtsSynchronizationDTO.setStartDate(DateUtils.toISO8601(date));
        vtsSynchronizationDTO.setEndDate(DateUtils.toISO8601(date2));
        vtsSynchronizationDTO.setErrorMessage(SerializationUtils.toBase64String(message));
        this.a.getSharedPreferences("it.aep_italia.vts.nfc.PREFS", 0).edit().putString("it.aep_italia.vts.nfc.SYNC_DETAILS", SerializationUtils.serializeToXml(vtsSynchronizationDTO)).commit();
    }

    /* JADX WARN: Code duplicated, block: B:34:0x009f  */
    /* JADX WARN: Code duplicated, block: B:39:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:53:0x00ca A[SYNTHETIC] */
    private void a(VtsVTokenInfoDTO vtsVTokenInfoDTO) {
        VtsContract vtsContract;
        double dataDownloadedToday;
        int mobileSyncDailyLimit;
        VtsLog.d("downloadReceipt() STARTS", new Object[0]);
        VtsReceiptManager receiptManager = this.b.getReceiptManager();
        if (vtsVTokenInfoDTO.getGroupUID() == null) {
            return;
        }
        List<Long> vTokenListByGroupUID = this.b.getVTokenListByGroupUID(vtsVTokenInfoDTO.getGroupUID().intValue());
        if (vTokenListByGroupUID.size() == 0) {
            return;
        }
        for (Long l : vTokenListByGroupUID) {
            VtsObjectType objectType = this.b.getVTokenByUID(l.longValue()).getObjectType();
            if (objectType == VtsObjectType.SINGLE_RIDE_TICKET || objectType == VtsObjectType.SMART_TICKET_OR_COP_MIFARE_UL || objectType == VtsObjectType.MAGNETIC_STRIPE_TICKET || objectType == VtsObjectType.CRYPTOGRAM_OR_QR_CODE || objectType == VtsObjectType.GTML2_GTT_CARD) {
                VtsLog.d("downloadReceipt() Scenario 1: Smart ticket case, downloading single contract receipt.", new Object[0]);
                vtsContract = this.b.getContractsByVTokenUID(l.longValue()).get(0);
                if (!DeviceUtils.isOnWiFiNetwork(this.b.getContext())) {
                    dataDownloadedToday = (this.b.getDataDownloadedToday() / 1024.0d) / 1024.0d;
                    mobileSyncDailyLimit = this.b.getSdkConfiguration().getMobileSyncDailyLimit();
                    VtsLog.d("downloadReceipt() Current data download limit: %.2f / %d MB", Double.valueOf(dataDownloadedToday), Integer.valueOf(mobileSyncDailyLimit));
                    if (dataDownloadedToday >= mobileSyncDailyLimit) {
                        VtsLog.i("downloadReceipt() FAILED: Daily download limit reached, stopping receipt synchronization.", new Object[0]);
                        break;
                    }
                }
                receiptManager.a(vtsVTokenInfoDTO.getVTokenUIDAsLong(), vtsContract != null ? Long.valueOf(vtsContract.getUID()) : null);
            } else if (objectType == VtsObjectType.CALYPSO_SMARTCARD || objectType == VtsObjectType.MIFARE_1K_SMARTCARD || objectType == VtsObjectType.INNOVATRON_CD97_SMARTCARD) {
                VtsLog.d("downloadReceipt() Scenario 2: Smart card case, contract receipt download will be resolved later.", new Object[0]);
                vtsContract = null;
                if (!DeviceUtils.isOnWiFiNetwork(this.b.getContext())) {
                    dataDownloadedToday = (this.b.getDataDownloadedToday() / 1024.0d) / 1024.0d;
                    mobileSyncDailyLimit = this.b.getSdkConfiguration().getMobileSyncDailyLimit();
                    VtsLog.d("downloadReceipt() Current data download limit: %.2f / %d MB", Double.valueOf(dataDownloadedToday), Integer.valueOf(mobileSyncDailyLimit));
                    if (dataDownloadedToday >= mobileSyncDailyLimit) {
                        VtsLog.i("downloadReceipt() FAILED: Daily download limit reached, stopping receipt synchronization.", new Object[0]);
                        break;
                    }
                }
                receiptManager.a(vtsVTokenInfoDTO.getVTokenUIDAsLong(), vtsContract != null ? Long.valueOf(vtsContract.getUID()) : null);
            } else {
                VtsLog.d("downloadReceipt() Scenario 3: No receipt associated with this token type", new Object[0]);
            }
        }
        VtsLog.d("downloadReceipt() COMPLETE", new Object[0]);
    }

    private void a(VtsVTokenInfoDTO vtsVTokenInfoDTO, VtsConnection vtsConnection) {
        VtsLog.d("downloadVToken() STARTS", new Object[0]);
        long jUnsignedHexStringToSignedLong = StringUtils.unsignedHexStringToSignedLong(vtsVTokenInfoDTO.getVTokenUID());
        String fullHexString = StringUtils.toFullHexString(Long.valueOf(jUnsignedHexStringToSignedLong));
        try {
            int iA = a(jUnsignedHexStringToSignedLong);
            VtsLog.d("downloadVToken() Downloading single VToken %s (LocalSignatureCount: %s, RemoteSignatureCount: %d)...", fullHexString, iA < 0 ? "N/A" : Integer.toString(iA), Integer.valueOf(vtsVTokenInfoDTO.getSignatureCount()));
            VtsVTokenInfoDTO vtsVTokenInfoDTOA = vtsConnection.a(jUnsignedHexStringToSignedLong);
            if (vtsVTokenInfoDTOA.getTokenContents() == null) {
                throw new VtsException(VtsError.SYNCHRONIZATION_FAILED, "Null response", new Object[0]);
            }
            VtsObjectType objectType = new VtsVTokenByteParser().parseToken(vtsVTokenInfoDTOA.getTokenContents()).getObjectType();
            boolean z = objectType == VtsObjectType.CALYPSO_SMARTCARD || objectType == VtsObjectType.MIFARE_1K_SMARTCARD || objectType == VtsObjectType.INNOVATRON_CD97_SMARTCARD;
            VtsLog.d("downloadVToken() Downloading InfoCard for VToken %s...", fullHexString);
            VtsVTokenDTO vtsVTokenDTOA = vtsConnection.a(vtsVTokenInfoDTOA.getTokenContents(), objectType, false, true, true, false);
            if (vtsVTokenDTOA == null || vtsVTokenDTOA.getPayload() == null) {
                throw new VtsException(VtsError.SYNCHRONIZATION_FAILED, "downloadVToken() FAILED: Null contract list detected !", new Object[0]);
            }
            VtsVTokenDTO vtsVTokenDTO = z ? vtsVTokenDTOA : null;
            ArrayList<VtsVTokenPayloadContractDTO> contracts = vtsVTokenDTOA.getPayload().getContracts();
            if (!z && contracts.isEmpty()) {
                throw new VtsException(VtsError.SYNCHRONIZATION_FAILED, "downloadVToken() FAILED: No contracts found !", new Object[0]);
            }
            byte[] tokenContents = vtsVTokenInfoDTOA.getTokenContents();
            ArrayList arrayList = new ArrayList();
            Iterator<VtsVTokenPayloadContractDTO> it2 = contracts.iterator();
            while (it2.hasNext()) {
                arrayList.add(VtsContract.fromDto(it2.next(), vtsVTokenInfoDTO.getVTokenUIDAsLong()));
            }
            VtsContractListDTO vtsContractListDTO = new VtsContractListDTO((ArrayList<VtsContract>) arrayList);
            e eVarD = this.b.d();
            try {
                eVarD.l();
                eVarD.a(tokenContents, vtsVTokenInfoDTOA.getLastVTokenUpdateAsDate());
                eVarD.a(vtsContractListDTO, jUnsignedHexStringToSignedLong);
                if (vtsVTokenDTO != null) {
                    eVarD.a(vtsVTokenDTO, jUnsignedHexStringToSignedLong);
                }
                eVarD.b();
                VtsLog.i("downloadVToken() VToken %s download COMPLETE ( LocalSignatureCount: %s, RemoteSignatureCount: %d )", fullHexString, iA >= 0 ? Integer.toString(iA) : "N/A", Integer.valueOf(vtsVTokenInfoDTO.getSignatureCount()));
            } catch (Exception e) {
                eVarD.a();
                throw e;
            }
        } catch (Exception e2) {
            VtsLog.e(e2, "downloadVToken() VToken %s download FAILED", fullHexString);
        }
        VtsLog.d("downloadVToken() COMPLETE", new Object[0]);
    }

    /* JADX WARN: Code duplicated, block: B:24:0x00a9 A[Catch: all -> 0x00c3, TRY_LEAVE, TryCatch #2 {all -> 0x00c3, blocks: (B:4:0x0024, B:5:0x0044, B:7:0x0065, B:8:0x006e, B:22:0x009d, B:24:0x00a9), top: B:44:0x0017 }] */
    /* JADX WARN: Code duplicated, block: B:26:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:33:0x00c7  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v2, types: [it.aep_italia.vts.sdk.core.VtsConnection] */
    /* JADX WARN: Type inference failed for: r5v3 */
    private void a(ListenableFuture<Throwable> listenableFuture) throws Throwable {
        Exception e;
        VtsConnection vtsConnectionE;
        boolean z;
        VtsLog.i("VtsSyncHandler.synchronizeWallet() Function Starts", new Object[0]);
        Date date = new Date();
        VtsSynchronization.Status status = VtsSynchronization.Status.IN_PROGRESS;
        ?? r5 = 0;
        a(status, date, null, null);
        try {
            try {
                VtsLog.i("VtsSyncHandler.synchronizeWallet() -------[ Opening Connection to VTSS ]-----------", new Object[0]);
                vtsConnectionE = this.b.e();
                try {
                    VtsLog.i("VtsSyncHandler.synchronizeWallet() -------[ Get VToken list ]-----------", new Object[0]);
                    List<VtsVTokenInfoDTO> listA = a(vtsConnectionE);
                    VtsLog.i("VtsSyncHandler.synchronizeWallet() -------[ Remove extraneous VTokens ]-----------", new Object[0]);
                    b(listA);
                    VtsLog.i("VtsSyncHandler.synchronizeWallet() -------[ VToken synchronization ]-----------", new Object[0]);
                    List<VtsVTokenInfoDTO> listA2 = a(listA, vtsConnectionE);
                    try {
                        a(VtsSynchronization.Status.SUCCESS, date, new Date(), null);
                        VtsLog.i("VtsSyncHandler.synchronizeWallet() -------[ Downloading receipts ]-----------", new Object[0]);
                        a(listA2);
                        VtsLog.i("VtsSyncHandler.synchronizeWallet() -------[ Image synchronization ]-----------", new Object[0]);
                        if (a()) {
                            this.b.getImageManager().a(listA);
                        }
                        VtsLog.i("VtsSyncHandler.synchronizeWallet() -------[ Image cleanup ]-----------", new Object[0]);
                        this.b.getImageManager().a();
                        listenableFuture.setResult(null);
                        if (vtsConnectionE != null) {
                            VtsLog.i("VtsSyncHandler.synchronizeWallet() -------[ Closing Connection to VTSS ]-----------", new Object[0]);
                            try {
                                vtsConnectionE.closeConnection();
                            } catch (Exception unused) {
                            }
                        }
                        VtsLog.i("VtsSyncHandler.synchronizeWallet() Function Ends", new Object[0]);
                    } catch (Exception e2) {
                        e = e2;
                        z = true;
                        VtsLog.e(e, "VtsSyncHandler.synchronizeWallet() Wallet synchronization FAILED", new Object[0]);
                        listenableFuture.setResult(e);
                        if (!z) {
                            a(VtsSynchronization.Status.ERROR, date, new Date(), e);
                        }
                        if (vtsConnectionE != null) {
                            VtsLog.i("VtsSyncHandler.synchronizeWallet() -------[ Closing Connection to VTSS ]-----------", new Object[0]);
                            try {
                                vtsConnectionE.closeConnection();
                            } catch (Exception unused2) {
                            }
                        }
                        VtsLog.i("VtsSyncHandler.synchronizeWallet() Function Ends", new Object[0]);
                    }
                } catch (Exception e3) {
                    e = e3;
                    z = false;
                    VtsLog.e(e, "VtsSyncHandler.synchronizeWallet() Wallet synchronization FAILED", new Object[0]);
                    listenableFuture.setResult(e);
                    if (!z) {
                        a(VtsSynchronization.Status.ERROR, date, new Date(), e);
                    }
                    if (vtsConnectionE != null) {
                        VtsLog.i("VtsSyncHandler.synchronizeWallet() -------[ Closing Connection to VTSS ]-----------", new Object[0]);
                        vtsConnectionE.closeConnection();
                    }
                    VtsLog.i("VtsSyncHandler.synchronizeWallet() Function Ends", new Object[0]);
                }
            } catch (Exception e4) {
                e = e4;
                vtsConnectionE = null;
            } catch (Throwable th) {
                th = th;
                if (r5 != 0) {
                    VtsLog.i("VtsSyncHandler.synchronizeWallet() -------[ Closing Connection to VTSS ]-----------", new Object[0]);
                    try {
                        r5.closeConnection();
                    } catch (Exception unused3) {
                    }
                }
                VtsLog.i("VtsSyncHandler.synchronizeWallet() Function Ends", new Object[0]);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            r5 = status;
            if (r5 != 0) {
                VtsLog.i("VtsSyncHandler.synchronizeWallet() -------[ Closing Connection to VTSS ]-----------", new Object[0]);
                r5.closeConnection();
            }
            VtsLog.i("VtsSyncHandler.synchronizeWallet() Function Ends", new Object[0]);
            throw th;
        }
    }

    private void a(List<VtsVTokenInfoDTO> list) {
        if (a()) {
            Iterator<VtsVTokenInfoDTO> it2 = list.iterator();
            while (it2.hasNext()) {
                a(it2.next());
            }
        }
    }

    private boolean a() {
        if (this.b.getSdkConfiguration().synchronizeImagesReceiptsOnWiFiOnly()) {
            return DeviceUtils.isOnWiFiNetwork(this.b.getContext());
        }
        return true;
    }

    private int b(VtsVTokenInfoDTO vtsVTokenInfoDTO) throws Exception {
        try {
            return (int) Math.signum(Math.max(0, a(vtsVTokenInfoDTO.getVTokenUIDAsLong())) - vtsVTokenInfoDTO.getSignatureCount());
        } catch (Exception e) {
            if (e instanceof VtsException) {
                throw e;
            }
            throw new VtsException(VtsError.SYNCHRONIZATION_FAILED, e);
        }
    }

    private void b(VtsVTokenInfoDTO vtsVTokenInfoDTO, VtsConnection vtsConnection) {
        VtsLog.d("uploadVToken() STARTS", new Object[0]);
        long jUnsignedHexStringToSignedLong = StringUtils.unsignedHexStringToSignedLong(vtsVTokenInfoDTO.getVTokenUID());
        String fullHexString = StringUtils.toFullHexString(Long.valueOf(jUnsignedHexStringToSignedLong));
        int iA = a(jUnsignedHexStringToSignedLong);
        String string = "N/A";
        VtsLog.d("uploadVToken() Uploading VToken %s (LocalSignatureCount: %s, RemoteSignatureCount: %d)...", fullHexString, iA < 0 ? "N/A" : Integer.toString(iA), Integer.valueOf(vtsVTokenInfoDTO.getSignatureCount()));
        try {
            vtsConnection.a(vtsVTokenInfoDTO);
            if (iA >= 0) {
                string = Integer.toString(iA);
            }
            VtsLog.i("uploadVToken() VToken %s upload COMPLETE (LocalSignatureCount: %s, RemoteSignatureCount: %d)...", fullHexString, string, Integer.valueOf(vtsVTokenInfoDTO.getSignatureCount()));
        } catch (Exception e) {
            VtsLog.e(e, "Upload of VToken %s failed.", fullHexString);
        }
        VtsLog.d("uploadVToken() COMPLETE", new Object[0]);
    }

    private void b(List<VtsVTokenInfoDTO> list) {
        VtsLog.d("removeExtraneousVTokens() STARTS", new Object[0]);
        e eVarD = this.b.d();
        this.b.getReceiptManager();
        this.b.getImageManager();
        int systemType = this.b.getSystemType();
        int systemSubType = this.b.getSystemSubType();
        VtsLog.d("removeExtraneousVTokens() Loading VToken IDs from local Wallet (systemType=%d and systemSubType=%d)...", Integer.valueOf(systemType), Integer.valueOf(systemSubType));
        List<Long> listA = eVarD.a(systemType, systemSubType);
        VtsLog.d("removeExtraneousVTokens() Local Wallet VToken IDs loaded, VTokenCount=%d", Integer.valueOf(listA.size()));
        ArrayList arrayList = new ArrayList();
        Iterator<VtsVTokenInfoDTO> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList.add(Long.valueOf(it2.next().getVTokenUIDAsLong()));
        }
        for (Long l : listA) {
            if (!arrayList.contains(l)) {
                VtsLog.i("removeExtraneousVTokens() Local VToken %s not found on VTS Server, deleting VToken from local wallet...", Long.toHexString(l.longValue()));
                try {
                    eVarD.l();
                    eVarD.h(l.longValue());
                    eVarD.i(l.longValue());
                    eVarD.b();
                } catch (Exception e) {
                    VtsLog.e(e, "removeExtraneousVTokens()  Could not delete VToken from wallet.", new Object[0]);
                    eVarD.a();
                }
            }
        }
        VtsLog.d("removeExtraneousVTokens() COMPLETE", new Object[0]);
    }

    private boolean c(VtsVTokenInfoDTO vtsVTokenInfoDTO) {
        if (vtsVTokenInfoDTO.getVtsObjectTypeFormat() == null) {
            return false;
        }
        int i = a.a[vtsVTokenInfoDTO.getVtsObjectTypeFormat().ordinal()];
        return i == 1 || i == 2 || i == 3;
    }

    private boolean d(VtsVTokenInfoDTO vtsVTokenInfoDTO) {
        return vtsVTokenInfoDTO.getVtsObjectType() == VtsObjectType.VTOKEN_RECEIPT;
    }

    ListenableFuture<Throwable> b() throws Throwable {
        ListenableFuture<Throwable> listenableFuture = new ListenableFuture<>();
        try {
            VtsLog.i("synchronousRun() Starts", new Object[0]);
            a(listenableFuture);
            VtsLog.i("synchronousRun() Complete", new Object[0]);
        } catch (VtsException e) {
            VtsLog.e("synchronousRun() Failed", e);
        }
        return listenableFuture;
    }
}
