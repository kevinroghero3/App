package it.aep_italia.vts.sdk.internal.wallet.io;

import android.content.Context;
import it.aep_italia.vts.sdk.domain.enums.VtsObjectType;
import it.aep_italia.vts.sdk.errors.VtsError;
import it.aep_italia.vts.sdk.errors.VtsException;
import it.aep_italia.vts.sdk.internal.VtsVTokenByteParser;
import it.aep_italia.vts.sdk.internal.wallet.VtsWallet;
import it.aep_italia.vts.sdk.internal.wallet.VtsWalletFile;
import it.aep_italia.vts.sdk.internal.wallet.enums.VtsWalletEncryptionType;
import it.aep_italia.vts.sdk.internal.wallet.enums.VtsWalletFileType;
import it.aep_italia.vts.sdk.utils.ByteUtils;
import it.aep_italia.vts.sdk.utils.CryptoUtils;
import it.aep_italia.vts.sdk.utils.StreamUtils;
import it.aep_italia.vts.sdk.utils.ValidationUtils;
import java.io.ByteArrayInputStream;
import java.nio.charset.Charset;
import org.apache.commons.lang3.CharEncoding;

/* JADX INFO: loaded from: classes6.dex */
public final class VtsWalletByteParser {
    private static final VtsVTokenByteParser b = new VtsVTokenByteParser();
    private Context a;

    public VtsWalletByteParser(Context context) {
        this.a = context;
    }

    private int a(VtsWallet vtsWallet, ByteArrayInputStream byteArrayInputStream) {
        boolean z = byteArrayInputStream.available() >= 32;
        VtsError vtsError = VtsError.COULD_NOT_DESERIALIZE_WALLET;
        ValidationUtils.assertTrue(z, vtsError, "Expected at least 32 bytes, got %d", Integer.valueOf(byteArrayInputStream.available()));
        try {
            int i = StreamUtils.readInt(byteArrayInputStream);
            int iByteToInt = ByteUtils.byteToInt((byte) byteArrayInputStream.read());
            VtsWalletEncryptionType vtsWalletEncryptionType = VtsWalletEncryptionType.parse(byteArrayInputStream.read());
            int iByteToInt2 = ByteUtils.byteToInt((byte) byteArrayInputStream.read());
            byteArrayInputStream.read();
            long j = StreamUtils.readLong(byteArrayInputStream);
            short s = StreamUtils.readShort(byteArrayInputStream);
            byteArrayInputStream.read();
            int i2 = StreamUtils.readInt(byteArrayInputStream);
            int i3 = StreamUtils.readInt(byteArrayInputStream);
            int i4 = StreamUtils.readInt(byteArrayInputStream);
            byteArrayInputStream.read();
            ValidationUtils.assertTrue(i == 1095061590, vtsError, "Invalid MagicNumber", new Object[0]);
            ValidationUtils.assertTrue(iByteToInt == 1, vtsError, "Unsupported Version", new Object[0]);
            ValidationUtils.assertTrue(iByteToInt2 == 1, vtsError, "Unsupported DirEntryVersion", new Object[0]);
            ValidationUtils.assertTrue(s >= 0, vtsError, "Invalid FileCount", new Object[0]);
            ValidationUtils.assertTrue(i2 >= 0, vtsError, "Invalid DirectorySize", new Object[0]);
            ValidationUtils.assertTrue(i3 >= 0, vtsError, "Invalid DataFileSize", new Object[0]);
            ValidationUtils.assertTrue(i4 >= 0, vtsError, "Invalid lastUpdate", new Object[0]);
            ValidationUtils.assertTrue(s * 58 == i2, vtsError, "Invalid DirectorySize", new Object[0]);
            vtsWallet.setVersion(iByteToInt);
            vtsWallet.setEncryptionType(vtsWalletEncryptionType);
            vtsWallet.setDirEntryVersion(iByteToInt2);
            vtsWallet.setDeviceUID(j);
            vtsWallet.setLastUpdate(i4);
            return s;
        } catch (Exception e) {
            throw new VtsException(VtsError.COULD_NOT_DESERIALIZE_WALLET, e);
        }
    }

    private static String a(byte[] bArr) {
        int i = 0;
        while (i < bArr.length) {
            if (bArr[i] == 0) {
                return i == 0 ? "" : new String(bArr, 0, i, Charset.forName(CharEncoding.UTF_8));
            }
            i++;
        }
        return new String(bArr, Charset.forName(CharEncoding.UTF_8));
    }

    private void a(VtsWallet vtsWallet, ByteArrayInputStream byteArrayInputStream, int i) {
        int i2 = i * 58;
        ValidationUtils.assertTrue(byteArrayInputStream.available() >= i2, VtsError.COULD_NOT_DESERIALIZE_WALLET, "Expected at least %d bytes, got %d", Integer.valueOf(i2), Integer.valueOf(byteArrayInputStream.available()));
        for (int i3 = 0; i3 < i; i3++) {
            try {
                VtsWalletFileType vtsWalletFileType = VtsWalletFileType.parse(ByteUtils.byteToInt((byte) byteArrayInputStream.read()));
                String strA = a(StreamUtils.extract(byteArrayInputStream, 32));
                long j = StreamUtils.readLong(byteArrayInputStream);
                VtsObjectType vtsObjectType = VtsObjectType.parse(ByteUtils.byteToInt((byte) byteArrayInputStream.read()));
                int i4 = StreamUtils.readInt(byteArrayInputStream);
                int i5 = StreamUtils.readInt(byteArrayInputStream);
                int i6 = StreamUtils.readInt(byteArrayInputStream);
                int i7 = StreamUtils.readInt(byteArrayInputStream);
                boolean z = i5 >= 0;
                VtsError vtsError = VtsError.COULD_NOT_DESERIALIZE_WALLET;
                ValidationUtils.assertTrue(z, vtsError, "Invalid FileOffset", new Object[0]);
                ValidationUtils.assertTrue(strA.length() > 0, vtsError, "Invalid FileName", new Object[0]);
                ValidationUtils.assertTrue(i6 >= 0, vtsError, "Invalid FileSize", new Object[0]);
                VtsWalletFile vtsWalletFile = new VtsWalletFile();
                vtsWalletFile.setFileType(vtsWalletFileType);
                vtsWalletFile.setFileName(strA);
                vtsWalletFile.setTokenUID(j);
                vtsWalletFile.setObjectType(vtsObjectType);
                vtsWalletFile.setTokenGroupUID(i4);
                vtsWalletFile.setLastUpdate(i7);
                vtsWalletFile.setContents(new byte[i6]);
                vtsWallet.getFiles().add(vtsWalletFile);
            } catch (Exception e) {
                throw new VtsException(VtsError.COULD_NOT_DESERIALIZE_WALLET, e);
            }
        }
    }

    private void b(VtsWallet vtsWallet, ByteArrayInputStream byteArrayInputStream, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            try {
                VtsWalletFile vtsWalletFile = vtsWallet.getFiles().get(i2);
                int length = vtsWalletFile.getContents().length;
                ValidationUtils.assertTrue(byteArrayInputStream.available() >= length, VtsError.COULD_NOT_DESERIALIZE_WALLET, "Expected at least %d bytes, got %d", Integer.valueOf(length), Integer.valueOf(byteArrayInputStream.available()));
                byteArrayInputStream.read(vtsWalletFile.getContents(), 0, length);
            } catch (Exception e) {
                throw new VtsException(VtsError.COULD_NOT_DESERIALIZE_WALLET, e);
            }
        }
    }

    public VtsWallet parseWallet(byte[] bArr) throws VtsException {
        ValidationUtils.assertNonNull(bArr, VtsError.COULD_NOT_DESERIALIZE_WALLET, "Wallet data cannot be null", new Object[0]);
        VtsWallet vtsWallet = new VtsWallet();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            try {
                int iA = a(vtsWallet, byteArrayInputStream);
                if (vtsWallet.getEncryptionType() == VtsWalletEncryptionType.AES_256) {
                    try {
                        byteArrayInputStream = new ByteArrayInputStream(CryptoUtils.aesDecrypt(byteArrayInputStream, VtsWallet.generateWalletKey(this.a)));
                    } catch (Exception e) {
                        throw new VtsException(VtsError.COULD_NOT_DESERIALIZE_WALLET, e);
                    }
                }
                a(vtsWallet, byteArrayInputStream, iA);
                b(vtsWallet, byteArrayInputStream, iA);
                StreamUtils.closeSilently(byteArrayInputStream);
                return vtsWallet;
            } catch (Exception e2) {
                throw new VtsException(VtsError.COULD_NOT_DESERIALIZE_WALLET, e2);
            }
        } catch (Throwable th) {
            StreamUtils.closeSilently(byteArrayInputStream);
            throw th;
        }
    }
}
