package com.salesforce.marketingcloud.tozny;

import androidx.exifinterface.media.ExifInterface;
import java.security.Provider;

/* JADX INFO: loaded from: classes6.dex */
class AesCbcWithIntegrity$PrngFixes$LinuxPRNGSecureRandomProvider extends Provider {
    public AesCbcWithIntegrity$PrngFixes$LinuxPRNGSecureRandomProvider() {
        super("LinuxPRNG", 1.0d, "A Linux-specific random number provider that uses /dev/urandom");
        put("SecureRandom.SHA1PRNG", AesCbcWithIntegrity$PrngFixes$LinuxPRNGSecureRandom.class.getName());
        put("SecureRandom.SHA1PRNG ImplementedIn", ExifInterface.TAG_SOFTWARE);
    }
}
