package o;

/* JADX INFO: loaded from: classes3.dex */
public class artificialFrame {
    public int b;
    public int c;
    public int e;

    public static void coroutineBoundary(int[] iArr) {
        for (int i = 0; i < iArr.length / 2; i++) {
            int i2 = iArr[i];
            iArr[i] = iArr[(iArr.length - i) - 1];
            iArr[(iArr.length - i) - 1] = i2;
        }
    }

    public static int coroutineBoundary(int i) {
        _BOUNDARY _boundary = _BOUNDARY.MediaBrowserCompatApi21;
        return ((_boundary.MediaBrowserCompatSubscriptionCallbackStubApi21[0][(i >>> 24) & 255] + _boundary.MediaBrowserCompatSubscriptionCallbackStubApi21[1][(i >>> 16) & 255]) ^ _boundary.MediaBrowserCompatSubscriptionCallbackStubApi21[2][(i >>> 8) & 255]) + _boundary.MediaBrowserCompatSubscriptionCallbackStubApi21[3][i & 255];
    }
}
