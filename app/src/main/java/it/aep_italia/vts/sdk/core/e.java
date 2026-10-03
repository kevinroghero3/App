package it.aep_italia.vts.sdk.core;

import it.aep_italia.vts.sdk.R;
import it.aep_italia.vts.sdk.VtsSdkConfiguration;
import it.aep_italia.vts.sdk.domain.VtsContract;
import it.aep_italia.vts.sdk.domain.VtsServer;
import it.aep_italia.vts.sdk.domain.VtsVToken;
import it.aep_italia.vts.sdk.domain.enums.VtsObjectType;
import it.aep_italia.vts.sdk.dto.domain.VtsVTokenDTO;
import it.aep_italia.vts.sdk.dto.server.server_info.VtsServerInfoDTO;
import it.aep_italia.vts.sdk.dto.server.server_list.VtsAuthorizedAppDTO;
import it.aep_italia.vts.sdk.dto.server.server_list.VtsServerDTO;
import it.aep_italia.vts.sdk.dto.server.server_list.VtsServerListDTO;
import it.aep_italia.vts.sdk.dto.utils.VtsContractListDTO;
import it.aep_italia.vts.sdk.dto.utils.VtsUserDataDTO;
import it.aep_italia.vts.sdk.dto.utils.VtsWalletFileDTO;
import it.aep_italia.vts.sdk.errors.VtsError;
import it.aep_italia.vts.sdk.errors.VtsException;
import it.aep_italia.vts.sdk.internal.VtsWellKnownStrings;
import it.aep_italia.vts.sdk.internal.wallet.VtsWallet;
import it.aep_italia.vts.sdk.internal.wallet.enums.VtsWalletFileType;
import it.aep_italia.vts.sdk.internal.wallet.io.VtsWalletByteParser;
import it.aep_italia.vts.sdk.internal.wallet.io.VtsWalletByteSerializer;
import it.aep_italia.vts.sdk.utils.CryptoUtils;
import it.aep_italia.vts.sdk.utils.SerializationUtils;
import it.aep_italia.vts.sdk.utils.StreamUtils;
import it.aep_italia.vts.sdk.utils.StringUtils;
import it.aep_italia.vts.sdk.utils.ValidationUtils;
import it.aep_italia.vts.sdk.vtsAepConfigServer.VtsAepConfigServer;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes6.dex */
final class e {
    private static ReentrantReadWriteLock g = new ReentrantReadWriteLock();
    private static int h = 0;
    private boolean b;
    private VtsSdk d;
    private File e;
    private File f;
    private int a = h;
    private VtsWallet c = null;

    e(VtsSdk vtsSdk) throws VtsException {
        this.d = vtsSdk;
        this.e = new File(vtsSdk.getContext().getFilesDir(), String.format("%s.dat", "wallet"));
        this.f = new File(vtsSdk.getContext().getFilesDir(), String.format("%s.dat.bak", "wallet"));
    }

    private int a(VtsWallet vtsWallet, long j) throws VtsException {
        int iIndexOf = vtsWallet.indexOf(VtsWalletFileType.VTOKEN, null, null, Long.valueOf(j), null);
        if (iIndexOf >= 0) {
            return iIndexOf;
        }
        throw new VtsException(VtsError.VTOKEN_NOT_FOUND, "No token with UID %s found.", StringUtils.toFullHexString(Long.valueOf(j)));
    }

    private int a(VtsWallet vtsWallet, String str) throws VtsException {
        int iIndexOf = vtsWallet.indexOf(null, null, a(str), null, null);
        if (iIndexOf >= 0) {
            return iIndexOf;
        }
        throw new VtsException(VtsError.FILE_NOT_FOUND, "No file with name %s found.", str);
    }

    private String a(long j) {
        return String.format(Locale.ITALY, "VTK_%s.xml", StringUtils.toFullHexString(Long.valueOf(j)));
    }

    private String a(String str) {
        if (str == null) {
            return null;
        }
        return str.replace("${ST}", String.valueOf(this.d.getSystemType())).replace("${SST}", String.valueOf(this.d.getSystemSubType()));
    }

    private void a(VtsWallet vtsWallet) throws VtsException {
        char c;
        if (this.b) {
            return;
        }
        try {
            vtsWallet.setLastUpdate((int) (new Date().getTime() / 1000));
            byte[] bArrSerializeWallet = new VtsWalletByteSerializer(this.d.getContext()).serializeWallet(vtsWallet);
            c = 1;
            h++;
            try {
                this.f.delete();
                StreamUtils.writeAndClose(bArrSerializeWallet, new FileOutputStream(this.f));
                c = 3;
                this.e.delete();
                try {
                    if (!this.f.renameTo(this.e)) {
                        throw new VtsException(VtsError.COULD_NOT_SAVE_WALLET, "Could not rename backup wallet", new Object[0]);
                    }
                    this.a = h;
                } catch (IOException e) {
                    e = e;
                    c = 4;
                    VtsLog.e(e, "Could not save wallet", new Object[0]);
                    if (c > 0 && c < 4) {
                        this.f.delete();
                    }
                    throw new VtsException(VtsError.COULD_NOT_SAVE_WALLET, e);
                }
            } catch (IOException e2) {
                e = e2;
            }
        } catch (IOException e3) {
            e = e3;
            c = 0;
        }
    }

    private void a(boolean z) {
        if (this.b) {
            return;
        }
        if (z) {
            g.writeLock().lock();
        } else {
            g.readLock().lock();
        }
    }

    private void a(boolean z, boolean z2) {
        if (!this.b || z2) {
            if (z) {
                g.writeLock().unlock();
            } else {
                g.readLock().unlock();
            }
        }
    }

    private String c(long j) {
        return String.format(Locale.ITALY, "GIC_%s.xml", StringUtils.toFullHexString(Long.valueOf(j)));
    }

    private VtsWallet j() throws VtsException {
        try {
            VtsWallet vtsWallet = this.c;
            if (vtsWallet != null && this.a == h) {
                return vtsWallet;
            }
            k();
            this.a = h;
            VtsWallet wallet = new VtsWalletByteParser(this.d.getContext()).parseWallet(StreamUtils.extractAllAndClose(new FileInputStream(this.e)));
            this.c = wallet;
            return wallet;
        } catch (IOException e) {
            VtsLog.e(e, "Could not load wallet", new Object[0]);
            throw new VtsException(VtsError.COULD_NOT_LOAD_WALLET, e);
        }
    }

    private void k() throws IOException {
        if (this.f.exists()) {
            VtsLog.w("Found a backup wallet. Discarding the current wallet and restoring the backup.", new Object[0]);
            this.e.delete();
            this.f.renameTo(this.e);
            h++;
            VtsLog.i("Backup wallet successfully restored.", new Object[0]);
            return;
        }
        if (this.e.exists()) {
            return;
        }
        VtsLog.i("No wallet found, creating a new one...", new Object[0]);
        VtsWallet vtsWalletCreateNew = VtsWallet.createNew(this.d);
        this.c = vtsWalletCreateNew;
        a(vtsWalletCreateNew);
    }

    <T> T a(String str, Class<T> cls) throws VtsException {
        try {
            a(false);
            VtsWallet vtsWalletJ = j();
            return (T) SerializationUtils.deserializeFromXml(vtsWalletJ.getFileContents(a(vtsWalletJ, str)), (Class) cls);
        } finally {
            a(false, false);
        }
    }

    String a(long j, long j2, long j3, long j4, long j5, boolean z) throws VtsException {
        try {
            a(false);
            VtsWallet vtsWalletJ = j();
            return vtsWalletJ.getVTokenQRData(a(vtsWalletJ, j), j2, j3, j4, j5, z);
        } finally {
            a(false, false);
        }
    }

    List<Long> a(int i) throws VtsException {
        try {
            a(false);
            return j().getUIDList(null, Integer.valueOf(i));
        } finally {
            a(false, false);
        }
    }

    List<Long> a(int i, int i2) throws VtsException {
        try {
            a(false);
            List<Long> uIDList = j().getUIDList(null, null);
            Iterator<Long> it2 = uIDList.iterator();
            while (it2.hasNext()) {
                try {
                    VtsVToken vtsVTokenD = d(it2.next().longValue());
                    if (vtsVTokenD.getSystemType() != i || vtsVTokenD.getSystemSubType() != i2) {
                        it2.remove();
                    }
                } catch (Exception unused) {
                }
            }
            return uIDList;
        } finally {
            a(false, false);
        }
    }

    List<Long> a(VtsObjectType vtsObjectType) throws VtsException {
        try {
            a(false);
            return j().getUIDList(vtsObjectType, null);
        } finally {
            a(false, false);
        }
    }

    public void a() {
        if (this.b) {
            VtsLog.d("Cancelling transactional mode...", new Object[0]);
            this.b = false;
            this.a = h - 1;
            a(true, true);
        }
    }

    void a(VtsVTokenDTO vtsVTokenDTO, long j) throws VtsException {
        ValidationUtils.assertNonNull(vtsVTokenDTO, VtsError.COULD_NOT_SAVE_WALLET, "VToken info cannot be null", new Object[0]);
        try {
            a(true);
            VtsWallet vtsWalletJ = j();
            a(c(j), VtsWalletFileType.GENERIC_FILE, VtsObjectType.NONE, j, 0, SerializationUtils.serializeToXmlBytes(vtsVTokenDTO));
            a(vtsWalletJ);
        } finally {
            a(true, false);
        }
    }

    void a(VtsContractListDTO vtsContractListDTO, long j) throws VtsException {
        VtsError vtsError = VtsError.COULD_NOT_SAVE_WALLET;
        ValidationUtils.assertNonNull(vtsContractListDTO, vtsError, "Contracts cannot be null", new Object[0]);
        ValidationUtils.assertNonNull(vtsContractListDTO.getContracts(), vtsError, "Contracts cannot be null", new Object[0]);
        try {
            a(true);
            VtsWallet vtsWalletJ = j();
            a(a(j), VtsWalletFileType.GENERIC_FILE, VtsObjectType.NONE, j, 0, SerializationUtils.serializeToXmlBytes(vtsContractListDTO));
            a(vtsWalletJ);
        } finally {
            a(true, false);
        }
    }

    void a(String str, VtsWalletFileType vtsWalletFileType, VtsObjectType vtsObjectType, long j, int i, byte[] bArr) throws VtsException {
        try {
            a(true);
            VtsWallet vtsWalletJ = j();
            vtsWalletJ.saveFile(a(str), vtsWalletFileType, vtsObjectType, j, i, bArr, null);
            a(vtsWalletJ);
        } finally {
            a(true, false);
        }
    }

    void a(String str, Object obj) {
        a(str, SerializationUtils.serializeToXmlBytes(obj));
    }

    void a(String str, byte[] bArr) {
        a(str, VtsWalletFileType.GENERIC_FILE, VtsObjectType.NONE, 0L, 0, bArr);
    }

    void a(byte[] bArr) throws VtsException {
        a(bArr, (Date) null);
    }

    void a(byte[] bArr, Date date) throws VtsException {
        ValidationUtils.assertNonNull(bArr, VtsError.COULD_NOT_SAVE_WALLET, "VToken cannot be null", new Object[0]);
        try {
            a(true);
            VtsWallet vtsWalletJ = j();
            vtsWalletJ.saveVToken(bArr, date);
            a(vtsWalletJ);
        } finally {
            a(true, false);
        }
    }

    public void b() {
        if (this.b) {
            VtsLog.d("Committing transactional mode...", new Object[0]);
            this.b = false;
            try {
                a(j());
            } finally {
                a(true, true);
            }
        }
    }

    byte[] b(long j) throws VtsException {
        try {
            a(false);
            VtsWallet vtsWalletJ = j();
            return vtsWalletJ.getFileContents(a(vtsWalletJ, j));
        } finally {
            a(false, false);
        }
    }

    byte[] b(String str) throws VtsException {
        try {
            a(false);
            VtsWallet vtsWalletJ = j();
            return vtsWalletJ.getFileContents(a(vtsWalletJ, str));
        } finally {
            a(false, false);
        }
    }

    boolean c(String str) throws VtsException {
        try {
            a(false);
            if (this.c != null || this.e.exists()) {
                return j().indexOf(null, null, a(str), null, null) != -1;
            }
            return false;
        } finally {
            a(false, false);
        }
    }

    byte[][] c() {
        try {
            try {
                a(false);
                long numericParameter = e().getNumericParameter(VtsWellKnownStrings.PARAM_NFC_KEYS_VTOKEN, 0L);
                byte[][] keys = CryptoUtils.readKeys(numericParameter != 0 ? new ByteArrayInputStream(b(numericParameter)) : this.d.getContext().getResources().openRawResource(R.raw.aep_aes_keys));
                a(false, false);
                return keys;
            } catch (IOException e) {
                throw new VtsException(VtsError.COULD_NOT_READ_FILE, e);
            }
        } catch (Throwable th) {
            a(false, false);
            throw th;
        }
    }

    VtsVToken d(long j) throws VtsException {
        try {
            a(false);
            VtsWallet vtsWalletJ = j();
            return vtsWalletJ.getVToken(a(vtsWalletJ, j));
        } finally {
            a(false, false);
        }
    }

    List<VtsWalletFileDTO> d() throws VtsException {
        try {
            a(false);
            return !this.d.isExplorerEnabled() ? new ArrayList() : j().getFileInfo();
        } finally {
            a(false, false);
        }
    }

    void d(String str) throws VtsException {
        try {
            a(true);
            VtsWallet vtsWalletJ = j();
            int iIndexOf = vtsWalletJ.indexOf(null, null, a(str), null, null);
            if (iIndexOf != -1) {
                vtsWalletJ.getFiles().remove(iIndexOf);
                a(vtsWalletJ);
            }
        } finally {
            a(true, false);
        }
    }

    VtsServerInfoDTO e() {
        try {
            a(false);
            String strA = a(VtsWellKnownStrings.FILE_SERVER_INFO);
            return !c(strA) ? new VtsServerInfoDTO() : (VtsServerInfoDTO) a(strA, VtsServerInfoDTO.class);
        } finally {
            a(false, false);
        }
    }

    boolean e(long j) throws VtsException {
        try {
            a(false);
            return j().indexOf(VtsWalletFileType.VTOKEN, null, null, Long.valueOf(j), null) != -1;
        } finally {
            a(false, false);
        }
    }

    List<VtsServer> f() {
        try {
            try {
                a(false);
                VtsServerInfoDTO vtsServerInfoDTOE = e();
                VtsSdkConfiguration sdkConfiguration = this.d.getSdkConfiguration();
                long hexParameter = vtsServerInfoDTOE.getHexParameter(VtsWellKnownStrings.PARAM_SERVER_LIST_VTOKEN, 0L);
                VtsServerListDTO vtsServerListDTO = (VtsServerListDTO) SerializationUtils.deserializeFromXml((hexParameter == 0 || !e(hexParameter)) ? StreamUtils.extractAllAndClose(new ByteArrayInputStream(SerializationUtils.fromBase64String(VtsAepConfigServer.getAepConfigServer()).getBytes(StandardCharsets.UTF_8))) : b(hexParameter), VtsServerListDTO.class);
                ArrayList arrayList = new ArrayList();
                for (VtsServerDTO vtsServerDTO : vtsServerListDTO.getServers()) {
                    Iterator<VtsAuthorizedAppDTO> it2 = vtsServerDTO.getAuthApps().iterator();
                    while (it2.hasNext()) {
                        if (it2.next().getApplicationKeyId().equals(sdkConfiguration.getApplicationKeyID())) {
                            arrayList.add(VtsServer.fromDto(vtsServerDTO));
                        }
                    }
                }
                a(false, false);
                return arrayList;
            } catch (IOException e) {
                throw new VtsException(VtsError.COULD_NOT_READ_FILE, e);
            }
        } catch (Throwable th) {
            a(false, false);
            throw th;
        }
    }

    List<VtsContract> f(long j) throws VtsException {
        String strA = a(j);
        return !c(strA) ? new ArrayList() : ((VtsContractListDTO) SerializationUtils.deserializeFromXml(b(strA), VtsContractListDTO.class)).getContracts();
    }

    VtsVTokenDTO g(long j) throws VtsException {
        String strC = c(j);
        if (c(strC)) {
            return (VtsVTokenDTO) SerializationUtils.deserializeFromXml(b(strC), VtsVTokenDTO.class);
        }
        return null;
    }

    VtsUserDataDTO g() {
        try {
            a(false);
            if (c(VtsWellKnownStrings.FILE_USER_DATA)) {
                return (VtsUserDataDTO) a(VtsWellKnownStrings.FILE_USER_DATA, VtsUserDataDTO.class);
            }
            return null;
        } finally {
            a(false, false);
        }
    }

    List<Long> h() throws VtsException {
        try {
            a(false);
            return j().getUIDList(null, null);
        } finally {
            a(false, false);
        }
    }

    void h(long j) throws VtsException {
        d(a(j));
        d(c(j));
    }

    void i(long j) throws VtsException {
        try {
            a(true);
            VtsWallet vtsWalletJ = j();
            int iIndexOf = vtsWalletJ.indexOf(VtsWalletFileType.VTOKEN, null, null, Long.valueOf(j), null);
            if (iIndexOf != -1) {
                vtsWalletJ.getFiles().remove(iIndexOf);
                a(vtsWalletJ);
            }
        } finally {
            a(true, false);
        }
    }

    boolean i() throws VtsException {
        try {
            a(false);
            return j().getFiles().size() > 0 && c(VtsWellKnownStrings.FILE_OPERATOR_LIST);
        } finally {
            a(false, false);
        }
    }

    public void l() {
        if (this.b) {
            return;
        }
        a(true);
        this.b = true;
        VtsLog.d("Entering transactional mode...", new Object[0]);
    }
}
