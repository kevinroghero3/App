package o;

import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import com.google.common.base.Ascii;
import java.io.BufferedInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes6.dex */
public class extraCallbackWithResult extends FilterInputStream {
    private static final short setSubscription = (short) ((Math.sqrt(5.0d) - 1.0d) * Math.pow(2.0d, 15.0d));
    private int IPostMessageServiceStubProxy;
    private final int MediaBrowserCompatSubscriptionCallbackStubApi26;
    private byte[] c;
    private final int createSubscriptionCallback;
    private byte[] d;
    private byte[] e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f148n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f149o;

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    public extraCallbackWithResult(InputStream inputStream, int[] iArr, int i, byte[] bArr, int i2, int i3) throws IOException {
        this(inputStream, iArr, i, bArr, i2, i3, 100, 100);
    }

    public extraCallbackWithResult(InputStream inputStream, int[] iArr, int i, byte[] bArr, int i2, int i3, int i4, int i5) throws IOException {
        super(new BufferedInputStream(inputStream, 4096));
        this.i = Integer.MAX_VALUE;
        this.IPostMessageServiceStubProxy = 1;
        this.c = new byte[8];
        this.e = new byte[8];
        this.d = new byte[8];
        this.j = 8;
        this.f = 8;
        this.h = Math.min(Math.max(i2, 5), 16);
        this.g = i3;
        if (i3 == 3) {
            System.arraycopy(bArr, 0, this.e, 0, 8);
        }
        accessartificialFrame((((long) iArr[1]) & 4294967295L) | ((((long) iArr[0]) & 4294967295L) << 32), i);
        this.MediaBrowserCompatSubscriptionCallbackStubApi26 = i4;
        this.createSubscriptionCallback = i5;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        c();
        int i = this.j;
        if (i >= this.f) {
            return -1;
        }
        byte[] bArr = this.c;
        this.j = i + 1;
        return bArr[i] & 255;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = i + i2;
        for (int i4 = i; i4 < i3; i4++) {
            c();
            int i5 = this.j;
            if (i5 >= this.f) {
                if (i4 == i) {
                    return -1;
                }
                return i2 - (i3 - i4);
            }
            byte[] bArr2 = this.c;
            this.j = i5 + 1;
            bArr[i4] = bArr2[i5];
        }
        return i2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        long j2 = 0;
        while (j2 < j && read() != -1) {
            j2++;
        }
        return j2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        c();
        return this.f - this.j;
    }

    private void accessartificialFrame(long j, int i) {
        if (i == 0) {
            c(j);
            return;
        }
        int i2 = (int) j;
        this.f149o = i2;
        this.k = i2 * i;
        this.f148n = i ^ i2;
        this.l = (int) (j >> 32);
    }

    private void c(long j) {
        this.f149o = (int) j;
        long j2 = j >> 3;
        short s = setSubscription;
        this.k = (int) ((((long) s) * j2) >> 32);
        this.f148n = (int) (j >> 32);
        this.l = (int) (j2 + ((long) s));
    }

    private void e() {
        if (this.g == 3) {
            byte[] bArr = this.c;
            System.arraycopy(bArr, 0, this.d, 0, bArr.length);
        }
        byte[] bArr2 = this.c;
        int i = ((bArr2[0] << Ascii.CAN) & ViewCompat.MEASURED_STATE_MASK) + ((bArr2[1] << Ascii.DLE) & 16711680) + ((bArr2[2] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) + (bArr2[3] & 255);
        int i2 = ((-16777216) & (bArr2[4] << Ascii.CAN)) + (16711680 & (bArr2[5] << Ascii.DLE)) + (65280 & (bArr2[6] << 8)) + (bArr2[7] & 255);
        int i3 = 0;
        while (true) {
            int i4 = this.h;
            if (i3 >= i4) {
                break;
            }
            short s = setSubscription;
            i2 -= ((((i4 - i3) * s) + i) ^ ((i << 4) + this.f148n)) ^ ((i >>> 5) + this.l);
            i -= (((i2 << 4) + this.f149o) ^ ((s * (i4 - i3)) + i2)) ^ ((i2 >>> 5) + this.k);
            i3++;
        }
        byte[] bArr3 = this.c;
        bArr3[0] = (byte) (i >> 24);
        bArr3[1] = (byte) (i >> 16);
        bArr3[2] = (byte) (i >> 8);
        bArr3[3] = (byte) i;
        bArr3[4] = (byte) (i2 >> 24);
        bArr3[5] = (byte) (i2 >> 16);
        bArr3[6] = (byte) (i2 >> 8);
        bArr3[7] = (byte) i2;
        if (this.g == 3) {
            b();
            byte[] bArr4 = this.d;
            System.arraycopy(bArr4, 0, this.e, 0, bArr4.length);
        }
    }

    private void b() {
        for (int i = 0; i < 8; i++) {
            byte[] bArr = this.c;
            bArr[i] = (byte) (bArr[i] ^ this.e[i]);
        }
    }

    private int c() throws IOException {
        if (this.i == Integer.MAX_VALUE) {
            this.i = this.in.read();
        }
        if (this.j == 8) {
            byte[] bArr = this.c;
            int i = this.i;
            bArr[0] = (byte) i;
            if (i < 0) {
                throw new IllegalStateException("unexpected block size");
            }
            int i2 = 1;
            do {
                int i3 = this.in.read(this.c, i2, 8 - i2);
                if (i3 <= 0) {
                    break;
                }
                i2 += i3;
            } while (i2 < 8);
            if (i2 < 8) {
                throw new IllegalStateException("unexpected block size");
            }
            int i4 = this.MediaBrowserCompatSubscriptionCallbackStubApi26;
            if (i4 == this.createSubscriptionCallback) {
                e();
            } else {
                if (this.IPostMessageServiceStubProxy <= i4) {
                    e();
                }
                a();
            }
            int i5 = this.in.read();
            this.i = i5;
            this.j = 0;
            this.f = i5 < 0 ? 8 - (this.c[7] & 255) : 8;
        }
        return this.f;
    }

    private void a() {
        int i = this.IPostMessageServiceStubProxy;
        if (i < this.createSubscriptionCallback) {
            this.IPostMessageServiceStubProxy = i + 1;
        } else {
            this.IPostMessageServiceStubProxy = 1;
        }
    }
}
