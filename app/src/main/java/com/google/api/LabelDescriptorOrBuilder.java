package com.google.api;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes5.dex */
public interface LabelDescriptorOrBuilder extends MessageLiteOrBuilder {
    String getDescription();

    ByteString getDescriptionBytes();

    String getKey();

    ByteString getKeyBytes();

    LabelDescriptor.ValueType getValueType();

    int getValueTypeValue();
}
