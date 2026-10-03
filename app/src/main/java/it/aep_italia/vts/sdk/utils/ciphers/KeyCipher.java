package it.aep_italia.vts.sdk.utils.ciphers;

import java.security.Key;

/* JADX INFO: loaded from: classes6.dex */
public interface KeyCipher {
    Key unwrap(byte[] bArr, String str) throws Exception;

    byte[] wrap(Key key) throws Exception;
}
