package o;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes6.dex */
public class setDefaultImpl extends FilterInputStream {
    private long MediaBrowserCompatApi23ItemCallback;
    private final long MediaBrowserCompatApi26SubscriptionCallbackProxy;
    private int counter;

    public setDefaultImpl(InputStream inputStream, long j, long j2) {
        super(inputStream);
        this.MediaBrowserCompatApi23ItemCallback = 0L;
        this.counter = 0;
        this.MediaBrowserCompatApi26SubscriptionCallbackProxy = (j2 << 1) | 1;
        INotificationSideChannelStub();
        this.MediaBrowserCompatApi23ItemCallback += j;
        INotificationSideChannelStub();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int iINotificationSideChannelStub = this.in.read();
        if (iINotificationSideChannelStub == -1) {
            return -1;
        }
        if (this.counter == 0) {
            iINotificationSideChannelStub = (byte) (((byte) iINotificationSideChannelStub) ^ ((byte) (INotificationSideChannelStub() & 255)));
        }
        int i = this.counter + 1;
        this.counter = i;
        if (i == 8) {
            this.counter = 0;
        }
        return iINotificationSideChannelStub & 255;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        if (i2 <= this.counter + 8) {
            while (i3 < i2) {
                int i4 = read();
                if (i4 == -1) {
                    return -1;
                }
                bArr[i + i3] = (byte) i4;
                i3++;
            }
            return i2;
        }
        int i5 = i;
        int i6 = i2;
        while (this.counter > 0) {
            byte b = (byte) read();
            if (b == -1) {
                return -1;
            }
            bArr[i5] = b;
            i5++;
            i6--;
        }
        int i7 = i6 / 8;
        byte[] bArr2 = new byte[8];
        for (int i8 = 0; i8 < i7; i8++) {
            int i9 = this.in.read(bArr2, 0, 8);
            if (i9 == -1) {
                return i5 - i;
            }
            bArr2[0] = (byte) (((byte) (INotificationSideChannelStub() & 255)) ^ bArr2[0]);
            System.arraycopy(bArr2, 0, bArr, i5, i9);
            i5 += i9;
            if (i9 < 8) {
                return i5 - i;
            }
        }
        int i10 = i6 - (i7 * 8);
        while (i3 < i10) {
            int i11 = read();
            if (i11 == -1) {
                return -1;
            }
            bArr[i5] = (byte) i11;
            i3++;
        }
        return i2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        for (long j2 = 0; j2 < j; j2++) {
            read();
        }
        return j;
    }

    private int INotificationSideChannelStub() {
        long j = this.MediaBrowserCompatApi23ItemCallback;
        this.MediaBrowserCompatApi23ItemCallback = (6364136223846793005L * j) + this.MediaBrowserCompatApi26SubscriptionCallbackProxy;
        int i = (int) (((j >>> 18) ^ j) >>> 27);
        int i2 = (int) (j >>> 59);
        return (i << ((-i2) & 31)) | (i >>> i2);
    }
}
