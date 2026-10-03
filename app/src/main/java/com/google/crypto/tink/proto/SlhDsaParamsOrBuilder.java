package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes5.dex */
public interface SlhDsaParamsOrBuilder extends MessageLiteOrBuilder {
    SlhDsaHashType getHashType();

    int getHashTypeValue();

    int getKeySize();

    SlhDsaSignatureType getSigType();

    int getSigTypeValue();
}
