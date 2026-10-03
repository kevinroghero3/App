package com.facebook.cache.common;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
public interface WriterCallback {
    void write(OutputStream outputStream) throws IOException;
}
