package com.google.crypto.tink.streamingaead.internal;

import com.google.crypto.tink.StreamingAead;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.security.GeneralSecurityException;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
final class StreamingAeadHelper implements StreamingAead {
    private final List<StreamingAead> allPrimitives;
    private final StreamingAead primary;

    public StreamingAeadHelper(List<StreamingAead> list, StreamingAead streamingAead) throws GeneralSecurityException {
        this.allPrimitives = list;
        this.primary = streamingAead;
    }

    @Override // com.google.crypto.tink.StreamingAead
    public WritableByteChannel newEncryptingChannel(WritableByteChannel writableByteChannel, byte[] bArr) throws GeneralSecurityException, IOException {
        return this.primary.newEncryptingChannel(writableByteChannel, bArr);
    }

    @Override // com.google.crypto.tink.StreamingAead
    public ReadableByteChannel newDecryptingChannel(ReadableByteChannel readableByteChannel, byte[] bArr) throws GeneralSecurityException, IOException {
        return new ReadableByteChannelDecrypter(this.allPrimitives, readableByteChannel, bArr);
    }

    @Override // com.google.crypto.tink.StreamingAead
    public SeekableByteChannel newSeekableDecryptingChannel(SeekableByteChannel seekableByteChannel, byte[] bArr) throws GeneralSecurityException, IOException {
        return new SeekableByteChannelDecrypter(this.allPrimitives, seekableByteChannel, bArr);
    }

    @Override // com.google.crypto.tink.StreamingAead
    public InputStream newDecryptingStream(InputStream inputStream, byte[] bArr) throws GeneralSecurityException, IOException {
        return new InputStreamDecrypter(this.allPrimitives, inputStream, bArr);
    }

    @Override // com.google.crypto.tink.StreamingAead
    public OutputStream newEncryptingStream(OutputStream outputStream, byte[] bArr) throws GeneralSecurityException, IOException {
        return this.primary.newEncryptingStream(outputStream, bArr);
    }
}
