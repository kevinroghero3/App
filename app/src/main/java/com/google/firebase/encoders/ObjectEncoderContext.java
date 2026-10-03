package com.google.firebase.encoders;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public interface ObjectEncoderContext {
    ObjectEncoderContext add(@NonNull FieldDescriptor fieldDescriptor, double d) throws IOException;

    ObjectEncoderContext add(@NonNull FieldDescriptor fieldDescriptor, float f) throws IOException;

    ObjectEncoderContext add(@NonNull FieldDescriptor fieldDescriptor, int i) throws IOException;

    ObjectEncoderContext add(@NonNull FieldDescriptor fieldDescriptor, long j) throws IOException;

    ObjectEncoderContext add(@NonNull FieldDescriptor fieldDescriptor, @Nullable Object obj) throws IOException;

    ObjectEncoderContext add(@NonNull FieldDescriptor fieldDescriptor, boolean z) throws IOException;

    @Deprecated
    ObjectEncoderContext add(@NonNull String str, double d) throws IOException;

    @Deprecated
    ObjectEncoderContext add(@NonNull String str, int i) throws IOException;

    @Deprecated
    ObjectEncoderContext add(@NonNull String str, long j) throws IOException;

    @Deprecated
    ObjectEncoderContext add(@NonNull String str, @Nullable Object obj) throws IOException;

    @Deprecated
    ObjectEncoderContext add(@NonNull String str, boolean z) throws IOException;

    ObjectEncoderContext inline(@Nullable Object obj) throws IOException;

    ObjectEncoderContext nested(@NonNull FieldDescriptor fieldDescriptor) throws IOException;

    ObjectEncoderContext nested(@NonNull String str) throws IOException;
}
