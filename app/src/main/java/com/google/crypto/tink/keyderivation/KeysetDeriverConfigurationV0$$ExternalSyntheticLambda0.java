package com.google.crypto.tink.keyderivation;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.internal.PrimitiveConstructor;
import com.google.crypto.tink.prf.HkdfPrfKey;
import com.google.crypto.tink.subtle.prf.HkdfStreamingPrf;

/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class KeysetDeriverConfigurationV0$$ExternalSyntheticLambda0 implements PrimitiveConstructor.PrimitiveConstructionFunction {
    @Override // com.google.crypto.tink.internal.PrimitiveConstructor.PrimitiveConstructionFunction
    public final Object constructPrimitive(Key key) {
        return HkdfStreamingPrf.create((HkdfPrfKey) key);
    }
}
