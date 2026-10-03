package com.google.crypto.tink.internal;

import com.google.crypto.tink.subtle.Base64;
import java.io.BufferedReader;
import java.io.IOException;
import java.security.spec.EncodedKeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public final class PemUtil {
    private static final String BEGIN = "-----BEGIN ";
    private static final String END = "-----END ";
    private static final String MARKER = "-----";
    private static final String PRIVATE_KEY = "PRIVATE KEY";
    private static final String PUBLIC_KEY = "PUBLIC KEY";

    @Nullable
    public static EncodedKeySpec parsePemToKeySpec(BufferedReader bufferedReader) {
        String strSubstring;
        int iIndexOf;
        try {
            String line = bufferedReader.readLine();
            while (line != null && !line.startsWith(BEGIN)) {
                line = bufferedReader.readLine();
            }
            if (line == null || (iIndexOf = (strSubstring = line.trim().substring(11)).indexOf(MARKER)) < 0) {
                return null;
            }
            String strSubstring2 = strSubstring.substring(0, iIndexOf);
            String str = END + strSubstring2 + MARKER;
            StringBuilder sb = new StringBuilder();
            while (true) {
                String line2 = bufferedReader.readLine();
                if (line2 == null) {
                    break;
                }
                if (line2.indexOf(":") <= 0) {
                    if (line2.contains(str)) {
                        break;
                    }
                    sb.append(line2);
                }
            }
            byte[] bArrDecode = Base64.decode(sb.toString(), 0);
            if (strSubstring2.contains(PUBLIC_KEY)) {
                return new X509EncodedKeySpec(bArrDecode);
            }
            if (strSubstring2.contains(PRIVATE_KEY)) {
                return new PKCS8EncodedKeySpec(bArrDecode);
            }
            return null;
        } catch (IOException unused) {
        }
    }

    private PemUtil() {
    }
}
