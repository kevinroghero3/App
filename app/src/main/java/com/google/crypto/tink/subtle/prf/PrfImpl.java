package com.google.crypto.tink.subtle.prf;

import com.google.crypto.tink.prf.Prf;
import com.google.errorprone.annotations.Immutable;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes3.dex */
@Immutable
public class PrfImpl implements Prf {
    private final StreamingPrf prfStreamer;

    private PrfImpl(StreamingPrf streamingPrf) {
        this.prfStreamer = streamingPrf;
    }

    public static PrfImpl wrap(StreamingPrf streamingPrf) {
        return new PrfImpl(streamingPrf);
    }

    private static byte[] readBytesFromStream(InputStream inputStream, int i) throws GeneralSecurityException {
        try {
            byte[] bArr = new byte[i];
            int i2 = 0;
            while (i2 < i) {
                int i3 = inputStream.read(bArr, i2, i - i2);
                if (i3 <= 0) {
                    throw new GeneralSecurityException("Provided StreamingPrf terminated before providing requested number of bytes.");
                }
                i2 += i3;
            }
            return bArr;
        } catch (IOException e) {
            throw new GeneralSecurityException(e);
        }
    }

    @Override // com.google.crypto.tink.prf.Prf
    public byte[] compute(byte[] bArr, int i) throws GeneralSecurityException {
        if (bArr == null) {
            throw new GeneralSecurityException("Invalid input provided.");
        }
        if (i <= 0) {
            throw new GeneralSecurityException("Invalid outputLength specified.");
        }
        return readBytesFromStream(this.prfStreamer.computePrf(bArr), i);
    }
}
