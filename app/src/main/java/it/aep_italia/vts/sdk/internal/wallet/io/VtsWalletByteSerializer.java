package it.aep_italia.vts.sdk.internal.wallet.io;

import android.content.Context;
import it.aep_italia.vts.sdk.errors.VtsError;
import it.aep_italia.vts.sdk.errors.VtsException;
import it.aep_italia.vts.sdk.internal.wallet.VtsWallet;
import it.aep_italia.vts.sdk.internal.wallet.VtsWalletFile;
import it.aep_italia.vts.sdk.internal.wallet.enums.VtsWalletEncryptionType;
import it.aep_italia.vts.sdk.internal.wallet.enums.VtsWalletFileType;
import it.aep_italia.vts.sdk.utils.ByteUtils;
import it.aep_italia.vts.sdk.utils.CryptoUtils;
import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;
import java.util.Iterator;
import org.apache.commons.lang3.CharEncoding;

/* JADX INFO: loaded from: classes6.dex */
public final class VtsWalletByteSerializer {
    private Context a;

    public VtsWalletByteSerializer(Context context) {
        this.a = context;
    }

    private void a(VtsWallet vtsWallet, ByteArrayOutputStream byteArrayOutputStream) {
        try {
            for (VtsWalletFile vtsWalletFile : vtsWallet.getFiles()) {
                int size = byteArrayOutputStream.size();
                String fileName = vtsWalletFile.getFileName();
                byte bValue = 0;
                if (fileName.length() > 32) {
                    fileName = fileName.substring(0, 32);
                }
                byteArrayOutputStream.write((byte) vtsWalletFile.getFileType().value());
                byteArrayOutputStream.write(fileName.getBytes(Charset.forName(CharEncoding.UTF_8)));
                if (fileName.length() < 32) {
                    byteArrayOutputStream.write(new byte[32 - fileName.length()]);
                }
                boolean z = vtsWalletFile.getFileType() == VtsWalletFileType.VTOKEN;
                long tokenGroupUID = 0;
                byteArrayOutputStream.write(ByteUtils.longToBytes(!z ? 0L : vtsWalletFile.getTokenUID(), 0));
                if (z) {
                    bValue = (byte) vtsWalletFile.getObjectType().value();
                }
                byteArrayOutputStream.write(bValue);
                if (z) {
                    tokenGroupUID = vtsWalletFile.getTokenGroupUID();
                }
                byteArrayOutputStream.write(ByteUtils.longToBytes(tokenGroupUID, 4));
                byteArrayOutputStream.write(ByteUtils.longToBytes(size + 32, 4));
                byteArrayOutputStream.write(ByteUtils.longToBytes(vtsWalletFile.getContents().length, 4));
                byteArrayOutputStream.write(ByteUtils.longToBytes(vtsWalletFile.getLastUpdate(), 4));
            }
        } catch (Exception e) {
            throw new VtsException(VtsError.COULD_NOT_SERIALIZE_WALLET, e);
        }
    }

    private void b(VtsWallet vtsWallet, ByteArrayOutputStream byteArrayOutputStream) {
        try {
            Iterator<VtsWalletFile> it2 = vtsWallet.getFiles().iterator();
            while (it2.hasNext()) {
                byteArrayOutputStream.write(it2.next().getContents());
            }
        } catch (Exception e) {
            throw new VtsException(VtsError.COULD_NOT_SERIALIZE_WALLET, e);
        }
    }

    private void c(VtsWallet vtsWallet, ByteArrayOutputStream byteArrayOutputStream) {
        try {
            Iterator<VtsWalletFile> it2 = vtsWallet.getFiles().iterator();
            int length = 0;
            while (it2.hasNext()) {
                length += it2.next().getContents().length;
            }
            byteArrayOutputStream.write(ByteUtils.longToBytes(1095061590L, 4));
            byteArrayOutputStream.write((byte) vtsWallet.getVersion());
            byteArrayOutputStream.write((byte) vtsWallet.getEncryptionType().value());
            byteArrayOutputStream.write((byte) vtsWallet.getDirEntryVersion());
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(ByteUtils.longToBytes(vtsWallet.getDeviceUID(), 0));
            byteArrayOutputStream.write(ByteUtils.longToBytes(vtsWallet.getFiles().size(), 6));
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(ByteUtils.longToBytes(vtsWallet.getFiles().size() * 58, 4));
            byteArrayOutputStream.write(ByteUtils.longToBytes(length, 4));
            byteArrayOutputStream.write(ByteUtils.longToBytes(vtsWallet.getLastUpdate(), 4));
            byteArrayOutputStream.write(0);
        } catch (Exception e) {
            throw new VtsException(VtsError.COULD_NOT_SERIALIZE_WALLET, e);
        }
    }

    public byte[] serializeWallet(VtsWallet vtsWallet) throws VtsException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        c(vtsWallet, byteArrayOutputStream);
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        a(vtsWallet, byteArrayOutputStream2);
        b(vtsWallet, byteArrayOutputStream2);
        byte[] byteArray = byteArrayOutputStream2.toByteArray();
        if (vtsWallet.getEncryptionType() == VtsWalletEncryptionType.AES_256) {
            try {
                byteArray = CryptoUtils.aesEncrypt(byteArray, VtsWallet.generateWalletKey(this.a));
            } catch (Exception e) {
                throw new VtsException(VtsError.COULD_NOT_SERIALIZE_WALLET, e);
            }
        }
        try {
            byteArrayOutputStream.write(byteArray);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e2) {
            throw new VtsException(VtsError.COULD_NOT_SERIALIZE_WALLET, e2);
        }
    }
}
