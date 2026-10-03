package o;

import java.io.BufferedInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes6.dex */
public class TopicBuilder extends FilterInputStream {
    private long[] MediaBrowserCompatSubscriptionCallback;
    private int d;
    private int g;
    private byte[] getCallbacks;
    private long[] getOptionsList;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f145n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f146o;
    private short onChildrenLoaded;
    private final int putCallback;
    private final int removeSubscription;
    private final int unregisterCallbackMessenger;

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    public TopicBuilder(InputStream inputStream, int i, int i2, short s, int i3, int i4) throws IOException {
        this(inputStream, i, i2, s, i3, i4, 100, 100);
    }

    public TopicBuilder(InputStream inputStream, int i, int i2, short s, int i3, int i4, int i5, int i6) throws IOException {
        super(new BufferedInputStream(inputStream, 4096));
        this.d = 1;
        this.g = Integer.MAX_VALUE;
        int iMin = Math.min(Math.max((int) s, 4), 8);
        this.unregisterCallbackMessenger = iMin;
        this.getCallbacks = new byte[iMin];
        this.MediaBrowserCompatSubscriptionCallback = new long[4];
        this.getOptionsList = new long[4];
        this.f146o = iMin;
        this.f145n = iMin;
        this.MediaBrowserCompatSubscriptionCallback = getARTIFICIAL_FRAME_PACKAGE_NAME.coroutineBoundary(i ^ i4, iMin ^ i4);
        this.getOptionsList = getARTIFICIAL_FRAME_PACKAGE_NAME.coroutineBoundary(i2 ^ i4, i3 ^ i4);
        this.removeSubscription = i5;
        this.putCallback = i6;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        e();
        int i = this.f146o;
        if (i >= this.f145n) {
            return -1;
        }
        byte[] bArr = this.getCallbacks;
        this.f146o = i + 1;
        return bArr[i] & 255;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = i + i2;
        for (int i4 = i; i4 < i3; i4++) {
            e();
            int i5 = this.f146o;
            if (i5 >= this.f145n) {
                if (i4 == i) {
                    return -1;
                }
                return i2 - (i3 - i4);
            }
            byte[] bArr2 = this.getCallbacks;
            this.f146o = i5 + 1;
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
        e();
        return this.f145n - this.f146o;
    }

    private void a() {
        getARTIFICIAL_FRAME_PACKAGE_NAME.accessartificialFrame(this.MediaBrowserCompatSubscriptionCallback, this.getOptionsList, this.onChildrenLoaded);
        for (int i = 0; i < this.unregisterCallbackMessenger; i++) {
            byte[] bArr = this.getCallbacks;
            bArr[i] = (byte) (((long) bArr[i]) ^ ((this.MediaBrowserCompatSubscriptionCallback[this.onChildrenLoaded] >> (i * 8)) & 255));
        }
        this.onChildrenLoaded = (short) ((this.onChildrenLoaded + 1) % 4);
    }

    private int e() throws IOException {
        int i;
        if (this.g == Integer.MAX_VALUE) {
            this.g = this.in.read();
        }
        if (this.f146o == this.unregisterCallbackMessenger) {
            byte[] bArr = this.getCallbacks;
            int i2 = this.g;
            bArr[0] = (byte) i2;
            if (i2 < 0) {
                throw new IllegalStateException("unexpected block size");
            }
            int i3 = 1;
            do {
                int i4 = this.in.read(this.getCallbacks, i3, this.unregisterCallbackMessenger - i3);
                if (i4 <= 0) {
                    break;
                }
                i3 += i4;
            } while (i3 < this.unregisterCallbackMessenger);
            if (i3 < this.unregisterCallbackMessenger) {
                throw new IllegalStateException("unexpected block size");
            }
            int i5 = this.removeSubscription;
            if (i5 == this.putCallback) {
                a();
            } else {
                if (this.d <= i5) {
                    a();
                }
                b();
            }
            int i6 = this.in.read();
            this.g = i6;
            this.f146o = 0;
            if (i6 < 0) {
                int i7 = this.unregisterCallbackMessenger;
                i = i7 - (this.getCallbacks[i7 - 1] & 255);
            } else {
                i = this.unregisterCallbackMessenger;
            }
            this.f145n = i;
        }
        return this.f145n;
    }

    private void b() {
        int i = this.d;
        if (i < this.putCallback) {
            this.d = i + 1;
        } else {
            this.d = 1;
        }
    }
}
