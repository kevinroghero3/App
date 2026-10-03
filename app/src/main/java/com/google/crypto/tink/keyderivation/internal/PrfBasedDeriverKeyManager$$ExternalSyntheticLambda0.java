package com.google.crypto.tink.keyderivation.internal;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.internal.PrimitiveConstructor;
import com.google.crypto.tink.keyderivation.PrfBasedKeyDerivationKey;
import java.util.Random;

/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class PrfBasedDeriverKeyManager$$ExternalSyntheticLambda0 implements PrimitiveConstructor.PrimitiveConstructionFunction {
    public static int MediaBrowserCompatMediaBrowserImpl;
    public static int MediaBrowserCompatMediaBrowserImplApi21;

    @Override // com.google.crypto.tink.internal.PrimitiveConstructor.PrimitiveConstructionFunction
    public final Object constructPrimitive(Key key) {
        return PrfBasedKeyDeriver.create((PrfBasedKeyDerivationKey) key);
    }

    public static int ITrustedWebActivityCallback() {
        int i = MediaBrowserCompatMediaBrowserImpl;
        int i2 = i % 6384727;
        MediaBrowserCompatMediaBrowserImpl = i + 1;
        if (i2 != 0) {
            return MediaBrowserCompatMediaBrowserImplApi21;
        }
        int iNextInt = new Random().nextInt(512001821);
        MediaBrowserCompatMediaBrowserImplApi21 = iNextInt;
        return iNextInt;
    }
}
