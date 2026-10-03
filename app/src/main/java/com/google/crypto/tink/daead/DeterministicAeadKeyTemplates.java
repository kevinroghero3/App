package com.google.crypto.tink.daead;

import com.google.crypto.tink.proto.AesSivKeyFormat;
import com.google.crypto.tink.proto.KeyTemplate;
import com.google.crypto.tink.proto.OutputPrefixType;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public final class DeterministicAeadKeyTemplates {
    public static final KeyTemplate AES256_SIV = createAesSivKeyTemplate(64);

    public static KeyTemplate createAesSivKeyTemplate(int i) {
        return KeyTemplate.newBuilder().setValue(AesSivKeyFormat.newBuilder().setKeySize(i).build().toByteString()).setTypeUrl(AesSivKeyManager.getKeyType()).setOutputPrefixType(OutputPrefixType.TINK).build();
    }

    private DeterministicAeadKeyTemplates() {
    }
}
