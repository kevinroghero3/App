package com.google.crypto.tink.internal;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.Parameters;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public interface KeyCreator<ParametersT extends Parameters> {
    Key createKey(ParametersT parameterst, @Nullable Integer num) throws GeneralSecurityException;
}
