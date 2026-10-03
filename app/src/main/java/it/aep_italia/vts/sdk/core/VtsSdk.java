package it.aep_italia.vts.sdk.core;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.graphics.Bitmap;
import android.util.Base64;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import it.aep_italia.vts.sdk.VtsSdkConfiguration;
import it.aep_italia.vts.sdk.domain.VtsContract;
import it.aep_italia.vts.sdk.domain.VtsOperator;
import it.aep_italia.vts.sdk.domain.VtsPspPaymentRedirect;
import it.aep_italia.vts.sdk.domain.VtsServer;
import it.aep_italia.vts.sdk.domain.VtsSystem;
import it.aep_italia.vts.sdk.domain.VtsVToken;
import it.aep_italia.vts.sdk.domain.enums.VtsObjectType;
import it.aep_italia.vts.sdk.domain.enums.VtsVTokenStatus;
import it.aep_italia.vts.sdk.domain.payments.VtsCreditCardPayment;
import it.aep_italia.vts.sdk.dto.domain.VtsVTokenDTO;
import it.aep_italia.vts.sdk.dto.server.server_info.VtsServerInfoDTO;
import it.aep_italia.vts.sdk.dto.server.server_info.VtsServerNamedValueDTO;
import it.aep_italia.vts.sdk.dto.soap.functions.responses.GetOperatorsOutput;
import it.aep_italia.vts.sdk.dto.utils.VtsUserDataDTO;
import it.aep_italia.vts.sdk.dto.utils.VtsWalletFileDTO;
import it.aep_italia.vts.sdk.errors.VtsError;
import it.aep_italia.vts.sdk.errors.VtsException;
import it.aep_italia.vts.sdk.internal.Version;
import it.aep_italia.vts.sdk.internal.VtsWellKnownStrings;
import it.aep_italia.vts.sdk.internal.database.SharedDatabase;
import it.aep_italia.vts.sdk.internal.database.properties.StoredProperty;
import it.aep_italia.vts.sdk.utils.BitmapUtils;
import it.aep_italia.vts.sdk.utils.DateUtils;
import it.aep_italia.vts.sdk.utils.DeviceUtils;
import it.aep_italia.vts.sdk.utils.ListenableFuture;
import it.aep_italia.vts.sdk.utils.StringUtils;
import it.aep_italia.vts.sdk.utils.ValidationUtils;
import java.security.MessageDigest;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes6.dex */
public final class VtsSdk {
    public static final Version SDK_VERSION = Version.of(2, 9, 123);
    private int a;
    private int b;
    private String c;
    private String d;
    private Context e;
    private VtsSdkConfiguration f;
    private VtsConnection g;
    private SbeConnection h;
    private VtsImageManager i;
    private VtsReceiptManager j;
    private e k;
    private VtsCartManager l;
    private VtsCardManager m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private AtomicInteger f129n;

    class a implements Runnable {
        final /* synthetic */ List a;
        final /* synthetic */ VtsConnection b;
        final /* synthetic */ VtsVTokenStatus c;

        a(List list, VtsConnection vtsConnection, VtsVTokenStatus vtsVTokenStatus) {
            this.a = list;
            this.b = vtsConnection;
            this.c = vtsVTokenStatus;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (Long l : this.a) {
                VtsLog.i("Changing status of receipt %s to DELETED...", StringUtils.toFullHexString(l));
                try {
                    this.b.a(l.longValue(), this.c);
                } catch (VtsException e) {
                    VtsLog.e(e, "Could not change VToken status", new Object[0]);
                }
            }
        }
    }

    public VtsSdk(Context context, int i, int i2, String str, VtsSdkConfiguration vtsSdkConfiguration) throws VtsException {
        VtsError vtsError = VtsError.INVALID_PARAMETER;
        ValidationUtils.assertNonNull(context, vtsError, "Context cannot be null", new Object[0]);
        ValidationUtils.assertNonNull(vtsSdkConfiguration, vtsError, "Configuration cannot be null", new Object[0]);
        VtsLog.i("Initializing VTS SDK, sdkVersion=%s, preferredServerId=%s, systemType=%d, systemSubType=%d", SDK_VERSION, str, Integer.valueOf(i), Integer.valueOf(i2));
        this.e = context;
        this.a = i;
        this.b = i2;
        this.c = str;
        this.f = vtsSdkConfiguration;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            Signature[] signatureArr = packageInfo.signatures;
            if (signatureArr == null || signatureArr.length <= 0) {
                return;
            }
            MessageDigest messageDigest = MessageDigest.getInstance("SHA256");
            messageDigest.update(packageInfo.signatures[0].toByteArray());
            this.d = Base64.encodeToString(messageDigest.digest(), 0).trim();
        } catch (Exception unused) {
            this.d = "";
        }
    }

    String a() {
        return this.d;
    }

    void a(String str) {
        a(str, null);
    }

    void a(String str, String str2) {
        if (StringUtils.isBlank(str2)) {
            VtsLog.dt("VtsCallLog", "%s", str);
        } else {
            VtsLog.dt("VtsCallLog", "%s (%s)", str, str2);
        }
    }

    byte[] a(long j) throws VtsException {
        a("VtsSdk#loadRawByVTokenUID", StringUtils.stringifyParams("VTokenUID", Long.valueOf(j)));
        return d().b(j);
    }

    public void activateTokenByUID(long j) throws VtsException {
        a("VtsSdk#activateTokenByUID", StringUtils.stringifyParams("VTokenUID", Long.valueOf(j)));
        if (!hasVToken(j)) {
            throw new VtsException(VtsError.VTOKEN_NOT_FOUND, "Could not find requested VToken", new Object[0]);
        }
        VtsLog.d("Activating token with UID %s", StringUtils.toFullHexString(Long.valueOf(j)));
        SharedDatabase.getInstance(this).propertyDao().putValue(StoredProperty.ACTIVE_VTOKEN, j);
    }

    AtomicInteger b() {
        if (this.f129n == null) {
            this.f129n = new AtomicInteger(0);
        }
        return this.f129n;
    }

    VtsServerInfoDTO c() {
        return d().e();
    }

    e d() {
        if (this.k == null) {
            this.k = new e(this);
        }
        return this.k;
    }

    public void deactivateToken() throws VtsException {
        a("VtsSdk#deactivateToken");
        VtsLog.d("Deactivating token (if present)", new Object[0]);
        SharedDatabase.getInstance(this).propertyDao().removeValue(StoredProperty.ACTIVE_VTOKEN);
    }

    public void deleteVTokenByUID(long j) throws VtsException {
        a("VtsSdk#deleteVTokenByUID", StringUtils.stringifyParams("VTokenUID", Long.valueOf(j)));
        deleteVTokenByUID(j, VtsVTokenStatus.DELETED);
    }

    public void deleteVTokenByUID(long j, VtsVTokenStatus vtsVTokenStatus) throws VtsException {
        a("VtsSdk#deleteVTokenByUID", StringUtils.stringifyParams("VTokenUID", Long.valueOf(j)));
        e eVarD = d();
        VtsReceiptManager receiptManager = getReceiptManager();
        if (eVarD.e(j)) {
            VtsVToken vTokenByUID = getVTokenByUID(j);
            List<VtsContract> listF = eVarD.f(j);
            VtsConnection vtsConnectionOpenConnection = openConnection();
            vtsConnectionOpenConnection.a(j, vtsVTokenStatus);
            eVarD.i(j);
            eVarD.h(j);
            List<Long> listA = receiptManager.a(listF, Integer.valueOf(vTokenByUID.getGroupUID()));
            if (getActiveVToken() == j) {
                deactivateToken();
            }
            if (listA == null || listA.size() <= 0) {
                return;
            }
            new Thread(new a(listA, vtsConnectionOpenConnection, vtsVTokenStatus)).start();
        }
    }

    VtsConnection e() throws VtsException {
        VtsConnection vtsConnection;
        synchronized (this) {
            a("VtsSdk#openNewConnection");
            vtsConnection = new VtsConnection(this);
        }
        return vtsConnection;
    }

    public long getActiveVToken() throws VtsException {
        a("VtsSdk#getActiveVToken");
        Long value = SharedDatabase.getInstance(this).propertyDao().getValue(StoredProperty.ACTIVE_VTOKEN);
        if (value == null) {
            return 0L;
        }
        return value.longValue();
    }

    public VtsCardManager getCardManager() {
        VtsCardManager vtsCardManager;
        synchronized (this) {
            if (this.m == null) {
                this.m = new VtsCardManager(this);
            }
            vtsCardManager = this.m;
        }
        return vtsCardManager;
    }

    public VtsCartManager getCartManager() {
        VtsCartManager vtsCartManager;
        synchronized (this) {
            if (this.l == null) {
                this.l = new VtsCartManager(this);
            }
            vtsCartManager = this.l;
        }
        return vtsCartManager;
    }

    public Context getContext() {
        return this.e;
    }

    public List<VtsContract> getContractsByVTokenUID(long j) throws VtsException {
        a("VtsSdk#getContractsByVTokenUID", StringUtils.stringifyParams("VTokenUID", Long.valueOf(j)));
        if (!hasVToken(j)) {
            throw new VtsException(VtsError.VTOKEN_NOT_FOUND, "Could not find requested VToken", new Object[0]);
        }
        List<VtsContract> listF = d().f(j);
        if (listF != null) {
            return listF;
        }
        throw new VtsException(VtsError.VTOKEN_NOT_FOUND, "Could not find VToken contracts", new Object[0]);
    }

    public VtsServer getCurrentServer() {
        List<VtsServer> listF = d().f();
        if (listF == null) {
            return null;
        }
        for (VtsServer vtsServer : listF) {
            if (StringUtils.isBlank(this.c) || this.c.equals(vtsServer.getId())) {
                vtsServer.searchSystem(this.a, this.b);
                return vtsServer;
            }
        }
        return null;
    }

    public long getDataDownloadedToday() {
        StoredProperty property = SharedDatabase.getInstance(this).propertyDao().getProperty(StoredProperty.DOWNLOAD_COUNTER);
        if (property == null) {
            return 0L;
        }
        if (property.getLastUpdated() < DateUtils.getLastLocalMidnight()) {
            return 0L;
        }
        return property.getValue();
    }

    public Set<String> getDefaultServerIDs() {
        HashSet hashSet = new HashSet();
        Iterator<VtsServer> it2 = d().f().iterator();
        while (it2.hasNext()) {
            hashSet.add(it2.next().getId());
        }
        return hashSet;
    }

    public Map<String, String> getDeviceStatistics() {
        VtsServerInfoDTO vtsServerInfoDTOC = c();
        return vtsServerInfoDTOC != null ? vtsServerInfoDTOC.getStatistics() : Collections.unmodifiableMap(new HashMap());
    }

    public long getDeviceUID() {
        return DeviceUtils.getDeviceUID(this.e);
    }

    public String getDeviceUIDHex() {
        return DeviceUtils.getDeviceUIDHex(this.e);
    }

    public VtsImageManager getImageManager() {
        VtsImageManager vtsImageManager;
        synchronized (this) {
            if (this.i == null) {
                this.i = new VtsImageManager(this);
            }
            vtsImageManager = this.i;
        }
        return vtsImageManager;
    }

    public VtsOperator getOperator(int i) throws VtsException {
        for (VtsOperator vtsOperator : getOperatorList()) {
            if (i == vtsOperator.getOperatorID()) {
                return vtsOperator;
            }
        }
        return null;
    }

    public String getOperatorDescription(int i) throws VtsException {
        VtsOperator operator = getOperator(i);
        if (operator == null) {
            return null;
        }
        return operator.getDescription();
    }

    public List<VtsOperator> getOperatorList() throws VtsException {
        return ((GetOperatorsOutput) d().a(VtsWellKnownStrings.FILE_OPERATOR_LIST, GetOperatorsOutput.class)).buildOperators();
    }

    public String getPreferredServerId() {
        return this.c;
    }

    public VtsPspPaymentRedirect getPspPaymentUrl(String str, int i, String str2) throws VtsException {
        a("VtsSdk#getPspPaymentUrl", StringUtils.stringifyParams("PspType", str));
        return openConnection().a(str, VtsCreditCardPayment.CardPaymentMode.CLIENT_SIDE, i, str2, "");
    }

    public VtsPspPaymentRedirect getPspPaymentUrl(String str, VtsCreditCardPayment.CardPaymentMode cardPaymentMode, int i, String str2, String str3) throws VtsException {
        a("VtsSdk#getPspPaymentUrl", StringUtils.stringifyParams("PspType", str));
        return openConnection().a(str, cardPaymentMode, i, str2, str3);
    }

    public VtsReceiptManager getReceiptManager() {
        VtsReceiptManager vtsReceiptManager;
        synchronized (this) {
            if (this.j == null) {
                this.j = new VtsReceiptManager(this);
            }
            vtsReceiptManager = this.j;
        }
        return vtsReceiptManager;
    }

    public VtsSdkConfiguration getSdkConfiguration() {
        return this.f;
    }

    public List<VtsServer> getServerList() throws VtsException {
        return d().f();
    }

    public String getSystemDescription(int i, int i2) throws VtsException {
        VtsSystem vtsSystemSearchSystem;
        VtsServer currentServer = getCurrentServer();
        if (currentServer == null || (vtsSystemSearchSystem = currentServer.searchSystem(i, i2)) == null) {
            return null;
        }
        return vtsSystemSearchSystem.getDescription();
    }

    public int getSystemSubType() {
        return this.b;
    }

    public int getSystemType() {
        return this.a;
    }

    public VtsUserDataDTO getUserData() {
        a("VtsSdk#getUserData");
        return d().g();
    }

    public byte[] getUserPhoto() {
        return getImageManager().loadUserPhoto();
    }

    public VtsVToken getVTokenByUID(long j) throws VtsException {
        a("VtsSdk#getVTokenByUID", StringUtils.stringifyParams("VTokenUID", Long.valueOf(j)));
        return d().d(j);
    }

    public VtsVTokenDTO getVTokenInfo(long j) throws VtsException {
        a("VtsSdk#getVTokenInfo", StringUtils.stringifyParams("VTokenUID", Long.valueOf(j)));
        if (hasVToken(j)) {
            return d().g(j);
        }
        throw new VtsException(VtsError.VTOKEN_NOT_FOUND, "Could not find requested VToken", new Object[0]);
    }

    public List<Long> getVTokenList() throws VtsException {
        a("VtsSdk#getVTokenList");
        return d().h();
    }

    public List<Long> getVTokenListByGroupUID(int i) throws VtsException {
        a("VtsSdk#getVTokenListByGroupUID", StringUtils.stringifyParams("GroupUID", Integer.valueOf(i)));
        return d().a(i);
    }

    public List<Long> getVTokenListByObjectType(VtsObjectType vtsObjectType) throws VtsException {
        a("VtsSdk#getVTokenListByObjectType", StringUtils.stringifyParams("ObjectType", vtsObjectType));
        return d().a(vtsObjectType);
    }

    public Bitmap getVTokenQRData(long j, int i, int i2) throws Exception {
        return getVTokenQRData(j, i, i2, false);
    }

    public Bitmap getVTokenQRData(long j, int i, int i2, boolean z) throws Exception {
        a("VtsSdk#getVTokenQRData", StringUtils.stringifyParams("VTokenUID", Long.valueOf(j)));
        if (!hasVToken(j)) {
            throw new VtsException(VtsError.VTOKEN_NOT_FOUND, "Could not find requested VToken", new Object[0]);
        }
        VtsServerInfoDTO vtsServerInfoDTOC = c();
        return BitmapUtils.generateQrCode(d().a(j, vtsServerInfoDTOC.getNumericParameter(VtsWellKnownStrings.QR_CODE_FORMAT, 1L), vtsServerInfoDTOC.getNumericParameter(VtsWellKnownStrings.QR_CODE_SIGNATURE_TYPE, 0L), vtsServerInfoDTOC.getNumericParameter(VtsWellKnownStrings.QR_CODE_SIGNATURE_KEY, 0L), vtsServerInfoDTOC.getNumericParameter(VtsWellKnownStrings.QR_CODE_SIGNATURE_KEY_VTID, 0L), z), ErrorCorrectionLevel.L, 512, i, i2);
    }

    public String getVTokenQRData(long j) {
        return getVTokenQRData(j, false);
    }

    public String getVTokenQRData(long j, boolean z) {
        a("VtsSdk#getVTokenQRData", StringUtils.stringifyParams("VTokenUID", Long.valueOf(j)));
        if (!hasVToken(j)) {
            throw new VtsException(VtsError.VTOKEN_NOT_FOUND, "Could not find requested VToken", new Object[0]);
        }
        VtsServerInfoDTO vtsServerInfoDTOC = c();
        return d().a(j, vtsServerInfoDTOC.getNumericParameter(VtsWellKnownStrings.QR_CODE_FORMAT, 1L), vtsServerInfoDTOC.getNumericParameter(VtsWellKnownStrings.QR_CODE_SIGNATURE_TYPE, 0L), vtsServerInfoDTOC.getNumericParameter(VtsWellKnownStrings.QR_CODE_SIGNATURE_KEY, 0L), vtsServerInfoDTOC.getNumericParameter(VtsWellKnownStrings.QR_CODE_SIGNATURE_KEY_VTID, 0L), z);
    }

    public String getVersion() {
        return SDK_VERSION.getFullString();
    }

    public Bitmap getWalletCryptoQRData(String str, int i, int i2) throws Exception {
        return BitmapUtils.generateQrCode(str, ErrorCorrectionLevel.L, 512, i, i2);
    }

    public boolean hasVToken(long j) throws VtsException {
        a("VtsSdk#hasVToken", StringUtils.stringifyParams("VTokenUID", Long.valueOf(j)));
        return d().e(j);
    }

    public void initialize() throws VtsException {
        a("VtsSdk#initialize");
        if (isInitialized()) {
            return;
        }
        new c(this, false).a();
    }

    public boolean isDebug() {
        if (this.f.getApplicationKeyID().equals("iQkhe5Go8ORom8VMGsTLI5FXb0dn78Wx")) {
            return true;
        }
        return c().getBooleanParameter(VtsWellKnownStrings.PARAM_DEBUG_MODE, false);
    }

    public boolean isExplorerEnabled() {
        return isDebug() && c().getBooleanParameter(VtsWellKnownStrings.PARAM_EXPLORER_ENABLED, false);
    }

    public boolean isInitialized() {
        return d().i();
    }

    public List<VtsWalletFileDTO> loadWalletDetails() throws VtsException {
        return d().d();
    }

    public VtsConnection openConnection() throws VtsException {
        VtsConnection vtsConnection;
        synchronized (this) {
            a("VtsSdk#openConnection");
            VtsConnection vtsConnection2 = this.g;
            if (vtsConnection2 == null || vtsConnection2.isExpired()) {
                this.g = new VtsConnection(this);
            }
            vtsConnection = this.g;
        }
        return vtsConnection;
    }

    public SbeConnection openSbeConnection() {
        synchronized (this) {
            SbeConnection sbeConnection = this.h;
            if (sbeConnection != null) {
                return sbeConnection;
            }
            for (VtsServerNamedValueDTO vtsServerNamedValueDTO : c().getSdkParameters()) {
                if (vtsServerNamedValueDTO.getName().equals("SbeConnectionEnabled") && vtsServerNamedValueDTO.getValue().equals("true")) {
                    SbeConnection sbeConnection2 = new SbeConnection(this);
                    this.h = sbeConnection2;
                    return sbeConnection2;
                }
            }
            return null;
        }
    }

    public void setPreferredServerId(String str) {
        a("VtsSdk#setPreferredServerId", StringUtils.stringifyParams("PreferredServerID", str));
        this.c = str;
    }

    public void setSystemSubType(int i) {
        a("VtsSdk#setSystemSubType", StringUtils.stringifyParams("SystemSubType", Integer.valueOf(i)));
        this.b = i;
    }

    public void setSystemType(int i) {
        a("VtsSdk#setSystemType", StringUtils.stringifyParams("SystemType", Integer.valueOf(i)));
        this.a = i;
    }

    public ListenableFuture<Throwable> setUserData(VtsUserDataDTO vtsUserDataDTO, boolean z) {
        a("VtsSdk#setUserData", StringUtils.stringifyParams("UserData", vtsUserDataDTO, "SendToServer", Boolean.valueOf(z)));
        e eVarD = d();
        if (vtsUserDataDTO == null) {
            eVarD.d(VtsWellKnownStrings.FILE_USER_DATA);
        } else {
            eVarD.a(VtsWellKnownStrings.FILE_USER_DATA, vtsUserDataDTO);
        }
        return !z ? ListenableFuture.createFulfilled() : openConnection().b(vtsUserDataDTO, null);
    }

    public ListenableFuture<Throwable> setUserPhoto(byte[] bArr, boolean z) {
        getImageManager().saveUserPhoto(bArr);
        return !z ? ListenableFuture.createFulfilled() : openConnection().b(null, bArr);
    }

    public int vtsSendMail(String str, String str2, String str3) throws VtsException {
        return this.g.vtsSendMail(str, str2, str3);
    }
}
