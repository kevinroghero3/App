package it.aep_italia.vts.sdk.internal.wallet;

import android.content.Context;
import it.aep_italia.vts.sdk.core.VtsLog;
import it.aep_italia.vts.sdk.core.VtsSdk;
import it.aep_italia.vts.sdk.domain.VtsVToken;
import it.aep_italia.vts.sdk.domain.enums.VtsObjectType;
import it.aep_italia.vts.sdk.domain.enums.VtsObjectTypeFormat;
import it.aep_italia.vts.sdk.dto.utils.VtsWalletFileDTO;
import it.aep_italia.vts.sdk.errors.VtsError;
import it.aep_italia.vts.sdk.errors.VtsException;
import it.aep_italia.vts.sdk.internal.VtsVTokenByteParser;
import it.aep_italia.vts.sdk.internal.wallet.enums.VtsWalletEncryptionType;
import it.aep_italia.vts.sdk.internal.wallet.enums.VtsWalletFileType;
import it.aep_italia.vts.sdk.utils.ByteUtils;
import it.aep_italia.vts.sdk.utils.DeviceUtils;
import it.aep_italia.vts.sdk.utils.QRCodeSignUtils;
import it.aep_italia.vts.sdk.utils.StringUtils;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.apache.commons.lang3.CharEncoding;

/* JADX INFO: loaded from: classes6.dex */
public class VtsWallet {
    private static final VtsVTokenByteParser g = new VtsVTokenByteParser();
    private int a;
    private int b;
    private long c;
    private int d;
    private VtsWalletEncryptionType e;
    private List<VtsWalletFile> f = new ArrayList();

    private byte[] a(VtsVToken vtsVToken, byte[] bArr, boolean z) {
        byte[] bArrLongToBytes = ByteUtils.longToBytes(vtsVToken.getUID(), 0);
        byte[] bArrLongToBytes2 = ByteUtils.longToBytes(vtsVToken.getSystemType(), 6);
        byte[] bArrLongToBytes3 = ByteUtils.longToBytes(vtsVToken.getSystemSubType(), 6);
        byte[] bArrLongToBytes4 = ByteUtils.longToBytes(vtsVToken.getObjectUID(), 0);
        byte[] bArrLongToBytes5 = ByteUtils.longToBytes(vtsVToken.getObjectType().value(), 7);
        byte[] bArrLongToBytes6 = ByteUtils.longToBytes(vtsVToken.getPayloadSize(), 6);
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        byte[] bArrLongToBytes7 = ByteUtils.longToBytes(vtsVToken.getDeviceUID(), 0);
        byte[] bArrLongToBytes8 = ByteUtils.longToBytes(jCurrentTimeMillis, 4);
        byte[] bArr2 = new byte[12];
        if (z) {
            bArr2[0] = 86;
            bArr2[1] = 84;
            bArr2[2] = 83;
            bArr2[3] = 81;
            bArr2[4] = 1;
            bArr2[5] = 2;
            bArr2[6] = 0;
            bArr2[7] = 0;
            bArr2[8] = 0;
            bArr2[9] = 0;
            bArr2[10] = 0;
            bArr2[11] = 0;
        } else {
            bArr2[0] = 86;
            bArr2[1] = 84;
            bArr2[2] = 83;
            bArr2[3] = 81;
            bArr2[4] = 1;
            bArr2[5] = 0;
            bArr2[6] = 0;
            bArr2[7] = 0;
            bArr2[8] = 0;
            bArr2[9] = 0;
            bArr2[10] = 0;
            bArr2[11] = 0;
        }
        return a(bArr2, bArrLongToBytes8, bArrLongToBytes, bArrLongToBytes2, bArrLongToBytes3, bArrLongToBytes7, bArrLongToBytes4, bArrLongToBytes5, bArrLongToBytes6, bArr, new byte[]{0, 0, 0, 0, 0, 0});
    }

    public static VtsWallet createNew(VtsSdk vtsSdk) {
        VtsWallet vtsWallet = new VtsWallet();
        vtsWallet.setVersion(1);
        vtsWallet.setDirEntryVersion(1);
        vtsWallet.setDeviceUID(vtsSdk.getDeviceUID());
        vtsWallet.setEncryptionType(VtsWalletEncryptionType.AES_256);
        return vtsWallet;
    }

    public static byte[] generateWalletKey(Context context) {
        byte[] bArrLongToBytes = ByteUtils.longToBytes(DeviceUtils.getDeviceUID(context), 0);
        byte[] bArr = new byte[16];
        System.arraycopy(new byte[]{65, 69, 80, 86, 119, 101, 100, 107}, 0, bArr, 0, 8);
        System.arraycopy(bArrLongToBytes, 0, bArr, 8, 8);
        return bArr;
    }

    byte[] a(byte[]... bArr) {
        int length = 0;
        for (byte[] bArr2 : bArr) {
            length += bArr2.length;
        }
        byte[] bArr3 = new byte[length];
        int length2 = 0;
        for (int i = 0; i < bArr.length; i++) {
            byte[] bArr4 = bArr[i];
            System.arraycopy(bArr4, 0, bArr3, length2, bArr4.length);
            length2 += bArr[i].length;
        }
        return bArr3;
    }

    public long getDeviceUID() {
        return this.c;
    }

    public int getDirEntryVersion() {
        return this.b;
    }

    public VtsWalletEncryptionType getEncryptionType() {
        return this.e;
    }

    public byte[] getFileContents(int i) {
        if (i < 0 || i >= this.f.size()) {
            throw new VtsException(VtsError.INVALID_PARAMETER);
        }
        return this.f.get(i).getContents();
    }

    public List<VtsWalletFileDTO> getFileInfo() throws VtsException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.f.size(); i++) {
            VtsWalletFile vtsWalletFile = this.f.get(i);
            VtsWalletFileDTO vtsWalletFileDTO = new VtsWalletFileDTO();
            vtsWalletFileDTO.setContents(vtsWalletFile.getContents());
            vtsWalletFileDTO.setFileName(vtsWalletFile.getFileName());
            vtsWalletFileDTO.setFileType(vtsWalletFile.getFileType().name());
            vtsWalletFileDTO.setLastUpdate(vtsWalletFile.getLastUpdateAsDate());
            vtsWalletFileDTO.setObjectType(vtsWalletFile.getObjectType().name());
            vtsWalletFileDTO.setTokenGroupUID(vtsWalletFile.getTokenGroupUID());
            vtsWalletFileDTO.setTokenUID(vtsWalletFile.getTokenUID());
            if (vtsWalletFile.getFileType() == VtsWalletFileType.VTOKEN) {
                vtsWalletFileDTO.setObjectTypeFormat(VtsObjectTypeFormat.parse(ByteUtils.bytesToInt(ByteUtils.extract(getFileContents(i), 40, 1))).name());
                vtsWalletFileDTO.setSignatureCount(Integer.valueOf(getVToken(i).getSignatureCount()));
            }
            arrayList.add(vtsWalletFileDTO);
        }
        return arrayList;
    }

    public List<VtsWalletFile> getFiles() {
        return this.f;
    }

    public int getLastUpdate() {
        return this.d;
    }

    public List<Long> getUIDList(VtsObjectType vtsObjectType, Integer num) {
        ArrayList arrayList = new ArrayList();
        for (VtsWalletFile vtsWalletFile : this.f) {
            if (vtsWalletFile.getFileType() == VtsWalletFileType.VTOKEN && (vtsObjectType == null || vtsObjectType == vtsWalletFile.getObjectType())) {
                if (num == null || num.intValue() == vtsWalletFile.getTokenGroupUID()) {
                    arrayList.add(Long.valueOf(vtsWalletFile.getTokenUID()));
                }
            }
        }
        return arrayList;
    }

    public VtsVToken getVToken(int i) {
        VtsVToken token = g.parseToken(getFileContents(i));
        token.setLastUpdate(this.f.get(i).getLastUpdateAsDate());
        return token;
    }

    public String getVTokenQRData(int i, long j, long j2, long j3, long j4, boolean z) throws VtsException {
        byte[] fileContents = getFileContents(i);
        VtsVTokenByteParser vtsVTokenByteParser = g;
        int payloadSize = vtsVTokenByteParser.parseToken(fileContents).getPayloadSize();
        vtsVTokenByteParser.parseToken(fileContents).getObjectType();
        byte[] bArrExtract = ByteUtils.extract(fileContents, 57, payloadSize);
        QRCodeSignUtils qRCodeSignUtils = new QRCodeSignUtils();
        try {
            VtsLog.d("New QR Code requested... QRCodeType=Static, QRCodeAttributes=0x01, QRCodeFormat=%d, SignatureType=%d, SignatureKey=%d", Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3));
            if (j == 1) {
                if (j2 > 0) {
                    bArrExtract = qRCodeSignUtils.makeSignature(bArrExtract, j2, j3);
                }
                return new String(bArrExtract, Charset.forName(CharEncoding.ISO_8859_1));
            }
            if (j == 2) {
                if (j2 > 0) {
                    qRCodeSignUtils.makeSignature(bArrExtract, j2, j3);
                }
                return new String((byte[]) null, Charset.forName(CharEncoding.ISO_8859_1));
            }
            if (j == 3) {
                if (j2 > 0) {
                    qRCodeSignUtils.makeSignature(bArrExtract, j2, j3);
                }
                return new String((byte[]) null, Charset.forName(CharEncoding.ISO_8859_1));
            }
            try {
                if (j != 4) {
                    return new String(bArrExtract, Charset.forName(CharEncoding.ISO_8859_1));
                }
                byte[] bArrA = a(vtsVTokenByteParser.parseToken(fileContents), bArrExtract, z);
                if (j2 > 0) {
                    bArrA = qRCodeSignUtils.makeSignature(bArrA, j2, j3);
                }
                return new String(bArrA, Charset.forName(CharEncoding.ISO_8859_1));
            } catch (Exception unused) {
                return new String(bArrExtract, Charset.forName(CharEncoding.ISO_8859_1));
            }
        } catch (Exception unused2) {
        }
    }

    public int getVersion() {
        return this.a;
    }

    public int indexOf(VtsWalletFileType vtsWalletFileType, VtsObjectType vtsObjectType, String str, Long l, Integer num) {
        for (int i = 0; i < this.f.size(); i++) {
            VtsWalletFile vtsWalletFile = this.f.get(i);
            if ((vtsWalletFileType == null || vtsWalletFileType == vtsWalletFile.getFileType()) && ((vtsObjectType == null || vtsObjectType == vtsWalletFile.getObjectType()) && ((str == null || str.equals(vtsWalletFile.getFileName())) && ((l == null || l.longValue() == vtsWalletFile.getTokenUID()) && (num == null || num.intValue() == vtsWalletFile.getTokenGroupUID()))))) {
                return i;
            }
        }
        return -1;
    }

    public void saveFile(String str, VtsWalletFileType vtsWalletFileType, VtsObjectType vtsObjectType, long j, int i, byte[] bArr, Date date) throws VtsException {
        Iterator<VtsWalletFile> it2 = this.f.iterator();
        while (it2.hasNext()) {
            if (it2.next().getFileName().equals(str)) {
                it2.remove();
            }
        }
        VtsWalletFile vtsWalletFile = new VtsWalletFile();
        vtsWalletFile.setFileName(str);
        vtsWalletFile.setFileType(vtsWalletFileType);
        vtsWalletFile.setObjectType(vtsObjectType);
        vtsWalletFile.setTokenUID(j);
        vtsWalletFile.setTokenGroupUID(i);
        vtsWalletFile.setContents(bArr);
        if (date == null) {
            date = new Date();
        }
        vtsWalletFile.setLastUpdate((int) (date.getTime() / 1000));
        this.f.add(vtsWalletFile);
    }

    public long saveVToken(byte[] bArr, Date date) throws VtsException {
        VtsVToken token = g.parseToken(bArr);
        saveFile(String.format(Locale.ITALY, "VTK_%s.bin", StringUtils.toFullHexString(Long.valueOf(token.getUID()))), VtsWalletFileType.VTOKEN, token.getObjectType(), token.getUID(), token.getGroupUID(), bArr, date);
        return token.getUID();
    }

    public void setDeviceUID(long j) {
        this.c = j;
    }

    public void setDirEntryVersion(int i) {
        this.b = i;
    }

    public void setEncryptionType(VtsWalletEncryptionType vtsWalletEncryptionType) {
        this.e = vtsWalletEncryptionType;
    }

    public void setFiles(List<VtsWalletFile> list) {
        this.f = list;
    }

    public void setLastUpdate(int i) {
        this.d = i;
    }

    public void setVersion(int i) {
        this.a = i;
    }
}
