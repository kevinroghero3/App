package o;

import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import com.google.common.base.Ascii;
import java.io.BufferedInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class coroutineBoundary extends FilterInputStream {
    private final int MediaBrowserCompatServiceBinderWrapper;
    private byte[] MediaBrowserCompatSubscription;
    private final int addSubscription;
    private int[] getCallback;
    private byte[] getCallbacks;
    private final int getMediaItem;
    private int i;
    private int l;
    private int m;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f147o;
    private int p;
    private _BOUNDARY registerCallbackMessenger;
    private byte[] sendRequest;

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    public coroutineBoundary(InputStream inputStream, int[] iArr, byte[] bArr, int i, boolean z, int i2) throws IOException {
        this(inputStream, iArr, bArr, i, z, i2, 100, 100);
    }

    public coroutineBoundary(InputStream inputStream, int[] iArr, byte[] bArr, int i, boolean z, int i2, int i3, int i4) throws IOException {
        super(new BufferedInputStream(inputStream, 4096));
        this.i = 1;
        this.l = Integer.MAX_VALUE;
        int iMin = Math.min(Math.max(i, 3), 16);
        this.addSubscription = iMin;
        this.sendRequest = new byte[8];
        byte[] bArr2 = new byte[8];
        this.getCallbacks = bArr2;
        this.MediaBrowserCompatSubscription = new byte[8];
        this.getCallback = new int[2];
        this.m = 8;
        this.f147o = 8;
        this.p = i2;
        if (i2 == 2) {
            System.arraycopy(bArr, 0, bArr2, 0, 8);
        }
        this.registerCallbackMessenger = new _BOUNDARY(iArr, iMin, true, z);
        this.getMediaItem = i3;
        this.MediaBrowserCompatServiceBinderWrapper = i4;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        b();
        int i = this.m;
        if (i >= this.f147o) {
            return -1;
        }
        byte[] bArr = this.sendRequest;
        this.m = i + 1;
        return bArr[i] & 255;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = i + i2;
        for (int i4 = i; i4 < i3; i4++) {
            b();
            int i5 = this.m;
            if (i5 >= this.f147o) {
                if (i4 == i) {
                    return -1;
                }
                return i2 - (i3 - i4);
            }
            byte[] bArr2 = this.sendRequest;
            this.m = i5 + 1;
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
        b();
        return this.f147o - this.m;
    }

    private void c() {
        if (this.p == 2) {
            byte[] bArr = this.sendRequest;
            System.arraycopy(bArr, 0, this.MediaBrowserCompatSubscription, 0, bArr.length);
        }
        byte[] bArr2 = this.sendRequest;
        coroutineCreation.coroutineBoundary(((bArr2[0] << Ascii.CAN) & ViewCompat.MEASURED_STATE_MASK) + ((bArr2[1] << Ascii.DLE) & 16711680) + ((bArr2[2] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) + (bArr2[3] & 255), ((-16777216) & (bArr2[4] << Ascii.CAN)) + (16711680 & (bArr2[5] << Ascii.DLE)) + (65280 & (bArr2[6] << 8)) + (bArr2[7] & 255), false, this.addSubscription, this.registerCallbackMessenger.applyOptions, this.registerCallbackMessenger.MediaBrowserCompatSubscriptionCallbackStubApi21, this.getCallback);
        int[] iArr = this.getCallback;
        int i = iArr[0];
        int i2 = iArr[1];
        byte[] bArr3 = this.sendRequest;
        bArr3[0] = (byte) (i >> 24);
        bArr3[1] = (byte) (i >> 16);
        bArr3[2] = (byte) (i >> 8);
        bArr3[3] = (byte) i;
        bArr3[4] = (byte) (i2 >> 24);
        bArr3[5] = (byte) (i2 >> 16);
        bArr3[6] = (byte) (i2 >> 8);
        bArr3[7] = (byte) i2;
        if (this.p == 2) {
            a();
            byte[] bArr4 = this.MediaBrowserCompatSubscription;
            System.arraycopy(bArr4, 0, this.getCallbacks, 0, bArr4.length);
        }
    }

    private void a() {
        for (int i = 0; i < 8; i++) {
            byte[] bArr = this.sendRequest;
            bArr[i] = (byte) (bArr[i] ^ this.getCallbacks[i]);
        }
    }

    private int b() throws IOException {
        if (this.l == Integer.MAX_VALUE) {
            this.l = this.in.read();
        }
        if (this.m == 8) {
            byte[] bArr = this.sendRequest;
            int i = this.l;
            bArr[0] = (byte) i;
            if (i < 0) {
                throw new IllegalStateException("unexpected block size");
            }
            int i2 = 1;
            do {
                int i3 = this.in.read(this.sendRequest, i2, 8 - i2);
                if (i3 <= 0) {
                    break;
                }
                i2 += i3;
            } while (i2 < 8);
            if (i2 < 8) {
                throw new IllegalStateException("unexpected block size");
            }
            int i4 = this.getMediaItem;
            if (i4 == this.MediaBrowserCompatServiceBinderWrapper) {
                c();
            } else {
                if (this.i <= i4) {
                    c();
                }
                e();
            }
            int i5 = this.in.read();
            this.l = i5;
            this.m = 0;
            this.f147o = i5 < 0 ? 8 - (this.sendRequest[7] & 255) : 8;
        }
        return this.f147o;
    }

    private void e() {
        int i = this.i;
        if (i < this.MediaBrowserCompatServiceBinderWrapper) {
            this.i = i + 1;
        } else {
            this.i = 1;
        }
    }
}
