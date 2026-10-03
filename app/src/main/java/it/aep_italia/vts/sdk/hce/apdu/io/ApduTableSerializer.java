package it.aep_italia.vts.sdk.hce.apdu.io;

import it.aep_italia.vts.sdk.errors.VtsError;
import it.aep_italia.vts.sdk.errors.VtsException;
import it.aep_italia.vts.sdk.hce.apdu.ApduRequestMessage;
import it.aep_italia.vts.sdk.hce.apdu.ApduResponseMessage;
import it.aep_italia.vts.sdk.utils.ByteUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface;

/* JADX INFO: loaded from: classes6.dex */
public class ApduTableSerializer {
    private MessageDigest a;
    private int b;
    private boolean c;

    public ApduTableSerializer() {
        this(65535, true);
    }

    public ApduTableSerializer(int i, boolean z) {
        try {
            this.b = i;
            this.c = z;
            this.a = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException unused) {
        }
    }

    private String a(String str, int i) {
        return new String(new char[i]).replace(WebViewProviderFactoryBoundaryInterface.MULTI_COOKIE_VALUE_SEPARATOR, str);
    }

    private String a(byte[] bArr) {
        return ByteUtils.toString(this.a.digest(bArr), StringUtils.SPACE);
    }

    private List<String> a(byte[] bArr, int i) {
        ArrayList arrayList = new ArrayList();
        if (bArr != null && bArr.length != 0) {
            if (bArr.length <= this.b) {
                arrayList.add(ByteUtils.toString(bArr));
                return arrayList;
            }
            int i2 = 0;
            while (i2 < bArr.length) {
                int iMin = Math.min(this.b, bArr.length - i2);
                String string = ByteUtils.toString(bArr, i2, iMin, StringUtils.SPACE);
                if (i2 > 0 && i > 0) {
                    string = a(StringUtils.SPACE, i) + string;
                }
                arrayList.add(string);
                i2 += iMin;
            }
        }
        return arrayList;
    }

    public String serialize(ApduRequestMessage apduRequestMessage) throws VtsException {
        if (apduRequestMessage == null) {
            throw new VtsException(VtsError.COULD_NOT_SERIALIZE_APDU, "Input message cannot be null.", new Object[0]);
        }
        List<String> listA = a(apduRequestMessage.getData(), 6);
        StringBuilder sb = new StringBuilder();
        int length = apduRequestMessage.getLc().length;
        int length2 = apduRequestMessage.getLe().length;
        int length3 = apduRequestMessage.getData().length;
        sb.append("CLA:  ");
        sb.append(ByteUtils.toString(apduRequestMessage.getCLA()));
        sb.append("\nINS:  ");
        sb.append(ByteUtils.toString(apduRequestMessage.getINS()));
        sb.append("\nP1:   ");
        sb.append(ByteUtils.toString(apduRequestMessage.getP1()));
        sb.append("\nP2:   ");
        sb.append(ByteUtils.toString(apduRequestMessage.getP2()));
        sb.append("\nLc:   ");
        sb.append(ByteUtils.toString(apduRequestMessage.getLc()));
        sb.append("\nLe:   ");
        sb.append(length2 == 0 ? "(none)" : ByteUtils.toString(apduRequestMessage.getLe()));
        sb.append("\n------");
        sb.append("\nData: ");
        sb.append(listA.size() == 0 ? "(empty)" : listA.get(0));
        if (listA.size() > 1) {
            for (int i = 1; i < listA.size(); i++) {
                sb.append('\n');
                sb.append(listA.get(i));
            }
        }
        sb.append("\n------");
        sb.append("\nAPDU length: ");
        sb.append(length + 4 + length3 + length2);
        sb.append("\nData length: ");
        sb.append(length3);
        if (this.c) {
            sb.append("\nData MD5:    ");
            sb.append(a(apduRequestMessage.getData()));
        }
        return sb.toString();
    }

    public String serialize(ApduResponseMessage apduResponseMessage) throws VtsException {
        if (apduResponseMessage == null) {
            throw new VtsException(VtsError.COULD_NOT_SERIALIZE_APDU, "Input message cannot be null.", new Object[0]);
        }
        List<String> listA = a(apduResponseMessage.getData(), 6);
        StringBuilder sb = new StringBuilder();
        sb.append("SW1:  ");
        sb.append(ByteUtils.toString(apduResponseMessage.getSW1()));
        sb.append("\nSW2:  ");
        sb.append(ByteUtils.toString(apduResponseMessage.getSW2()));
        sb.append("\n------");
        sb.append("\nData: ");
        sb.append(listA.size() == 0 ? "(empty)" : listA.get(0));
        if (listA.size() > 1) {
            for (int i = 1; i < listA.size(); i++) {
                sb.append('\n');
                sb.append(listA.get(i));
            }
        }
        sb.append("\n------");
        sb.append("\nAPDU length: ");
        sb.append(apduResponseMessage.getData().length + 2);
        sb.append("\nData length: ");
        sb.append(apduResponseMessage.getData().length);
        if (this.c) {
            sb.append("\nData MD5: ");
            sb.append(a(apduResponseMessage.getData()));
        }
        return sb.toString();
    }
}
