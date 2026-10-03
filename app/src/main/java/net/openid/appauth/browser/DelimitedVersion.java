package net.openid.appauth.browser;

import androidx.annotation.NonNull;
import com.facebook.appevents.AppEventsConstants;

/* JADX INFO: loaded from: classes3.dex */
public class DelimitedVersion implements Comparable<DelimitedVersion> {
    private static final long BIT_MASK_32 = -1;
    private static final int PRIME_HASH_FACTOR = 92821;
    private final long[] mNumericParts;

    private int compareLongs(long j, long j2) {
        if (j < j2) {
            return -1;
        }
        return j > j2 ? 1 : 0;
    }

    public DelimitedVersion(long[] jArr) {
        this.mNumericParts = jArr;
    }

    public String toString() {
        if (this.mNumericParts.length == 0) {
            return AppEventsConstants.EVENT_PARAM_VALUE_NO;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.mNumericParts[0]);
        for (int i = 1; i < this.mNumericParts.length; i++) {
            sb.append('.');
            sb.append(this.mNumericParts[i]);
        }
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && (obj instanceof DelimitedVersion) && compareTo((DelimitedVersion) obj) == 0;
    }

    public int hashCode() {
        int i = 0;
        for (long j : this.mNumericParts) {
            i = (i * PRIME_HASH_FACTOR) + ((int) j);
        }
        return i;
    }

    @Override // java.lang.Comparable
    public int compareTo(@NonNull DelimitedVersion delimitedVersion) {
        long[] jArr;
        int i = 0;
        while (true) {
            jArr = this.mNumericParts;
            if (i >= jArr.length) {
                break;
            }
            long[] jArr2 = delimitedVersion.mNumericParts;
            if (i >= jArr2.length) {
                break;
            }
            int iCompareLongs = compareLongs(jArr[i], jArr2[i]);
            if (iCompareLongs != 0) {
                return iCompareLongs;
            }
            i++;
        }
        return compareLongs(jArr.length, delimitedVersion.mNumericParts.length);
    }

    public static DelimitedVersion parse(String str) {
        if (str == null) {
            return new DelimitedVersion(new long[0]);
        }
        String[] strArrSplit = str.split("[^0-9]+");
        long[] jArr = new long[strArrSplit.length];
        int i = 0;
        for (String str2 : strArrSplit) {
            if (!str2.isEmpty()) {
                jArr[i] = Long.parseLong(str2);
                i++;
            }
        }
        while (true) {
            int i2 = i - 1;
            if (i2 < 0 || jArr[i2] > 0) {
                break;
            }
            i = i2;
        }
        long[] jArr2 = new long[i];
        System.arraycopy(jArr, 0, jArr2, 0, i);
        return new DelimitedVersion(jArr2);
    }
}
