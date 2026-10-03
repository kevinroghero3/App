package com.google.firebase.encoders;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public interface ValueEncoderContext {
    ValueEncoderContext add(double d) throws IOException;

    ValueEncoderContext add(float f) throws IOException;

    ValueEncoderContext add(int i) throws IOException;

    ValueEncoderContext add(long j) throws IOException;

    ValueEncoderContext add(@Nullable String str) throws IOException;

    ValueEncoderContext add(boolean z) throws IOException;

    ValueEncoderContext add(@NonNull byte[] bArr) throws IOException;
}
