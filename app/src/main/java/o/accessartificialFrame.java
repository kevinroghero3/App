package o;

import java.io.BufferedInputStream;
import java.io.InputStream;

/* JADX INFO: loaded from: classes6.dex */
public class accessartificialFrame extends BufferedInputStream {
    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    public accessartificialFrame(InputStream inputStream) {
        super(inputStream);
    }
}
