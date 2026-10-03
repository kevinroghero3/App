package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes5.dex */
public interface MlDsaPublicKeyOrBuilder extends MessageLiteOrBuilder {
    ByteString getKeyValue();

    MlDsaParams getParams();

    int getVersion();

    boolean hasParams();
}
