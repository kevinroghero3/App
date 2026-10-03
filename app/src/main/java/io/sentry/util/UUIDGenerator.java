package io.sentry.util;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.util.UUID;
import okio.Utf8;

/* JADX INFO: loaded from: classes3.dex */
public final class UUIDGenerator {
    public static long randomHalfLengthUUID() {
        byte[] bArr = new byte[8];
        SentryRandom.current().nextBytes(bArr);
        byte b = (byte) (bArr[6] & Ascii.SI);
        bArr[6] = b;
        bArr[6] = (byte) (b | SignedBytes.MAX_POWER_OF_TWO);
        long j = 0;
        for (int i = 0; i < 8; i++) {
            j = (j << 8) | ((long) (bArr[i] & 255));
        }
        return j;
    }

    public static UUID randomUUID() {
        byte[] bArr = new byte[16];
        SentryRandom.current().nextBytes(bArr);
        byte b = (byte) (bArr[6] & Ascii.SI);
        bArr[6] = b;
        bArr[6] = (byte) (b | SignedBytes.MAX_POWER_OF_TWO);
        byte b2 = (byte) (bArr[8] & Utf8.REPLACEMENT_BYTE);
        bArr[8] = b2;
        bArr[8] = (byte) (b2 | (-128));
        long j = 0;
        long j2 = 0;
        for (int i = 0; i < 8; i++) {
            j2 = (j2 << 8) | ((long) (bArr[i] & 255));
        }
        for (int i2 = 8; i2 < 16; i2++) {
            j = (j << 8) | ((long) (bArr[i2] & 255));
        }
        return new UUID(j2, j);
    }
}
