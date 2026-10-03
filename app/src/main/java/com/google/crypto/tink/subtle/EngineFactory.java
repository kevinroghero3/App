package com.google.crypto.tink.subtle;

import com.google.android.gms.security.ProviderInstaller;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.subtle.EngineWrapper;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.Provider;
import java.security.Security;
import java.security.Signature;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;

/* JADX INFO: loaded from: classes3.dex */
public final class EngineFactory<T_WRAPPER extends EngineWrapper<JcePrimitiveT>, JcePrimitiveT> {
    private final Policy<JcePrimitiveT> policy;
    public static final EngineFactory<EngineWrapper.TCipher, Cipher> CIPHER = new EngineFactory<>(new EngineWrapper.TCipher());
    public static final EngineFactory<EngineWrapper.TMac, Mac> MAC = new EngineFactory<>(new EngineWrapper.TMac());
    public static final EngineFactory<EngineWrapper.TSignature, Signature> SIGNATURE = new EngineFactory<>(new EngineWrapper.TSignature());
    public static final EngineFactory<EngineWrapper.TMessageDigest, MessageDigest> MESSAGE_DIGEST = new EngineFactory<>(new EngineWrapper.TMessageDigest());
    public static final EngineFactory<EngineWrapper.TKeyAgreement, KeyAgreement> KEY_AGREEMENT = new EngineFactory<>(new EngineWrapper.TKeyAgreement());
    public static final EngineFactory<EngineWrapper.TKeyPairGenerator, KeyPairGenerator> KEY_PAIR_GENERATOR = new EngineFactory<>(new EngineWrapper.TKeyPairGenerator());
    public static final EngineFactory<EngineWrapper.TKeyFactory, KeyFactory> KEY_FACTORY = new EngineFactory<>(new EngineWrapper.TKeyFactory());

    interface Policy<JcePrimitiveT> {
        JcePrimitiveT getInstance(String str) throws GeneralSecurityException;

        JcePrimitiveT getInstance(String str, List<Provider> list) throws GeneralSecurityException;
    }

    static class DefaultPolicy<JcePrimitiveT> implements Policy<JcePrimitiveT> {
        private final EngineWrapper<JcePrimitiveT> jceFactory;

        private DefaultPolicy(EngineWrapper<JcePrimitiveT> engineWrapper) {
            this.jceFactory = engineWrapper;
        }

        @Override // com.google.crypto.tink.subtle.EngineFactory.Policy
        public JcePrimitiveT getInstance(String str) throws GeneralSecurityException {
            return this.jceFactory.getInstance(str, null);
        }

        @Override // com.google.crypto.tink.subtle.EngineFactory.Policy
        public JcePrimitiveT getInstance(String str, List<Provider> list) throws GeneralSecurityException {
            Iterator<Provider> it2 = list.iterator();
            while (it2.hasNext()) {
                try {
                    return this.jceFactory.getInstance(str, it2.next());
                } catch (Exception unused) {
                }
            }
            return getInstance(str);
        }
    }

    static class FipsPolicy<JcePrimitiveT> implements Policy<JcePrimitiveT> {
        private final EngineWrapper<JcePrimitiveT> jceFactory;

        private FipsPolicy(EngineWrapper<JcePrimitiveT> engineWrapper) {
            this.jceFactory = engineWrapper;
        }

        @Override // com.google.crypto.tink.subtle.EngineFactory.Policy
        public JcePrimitiveT getInstance(String str) throws GeneralSecurityException {
            Iterator<Provider> it2 = EngineFactory.toProviderList(ProviderInstaller.PROVIDER_NAME, "AndroidOpenSSL", "Conscrypt").iterator();
            Exception exc = null;
            while (it2.hasNext()) {
                try {
                    return this.jceFactory.getInstance(str, it2.next());
                } catch (Exception e) {
                    if (exc == null) {
                        exc = e;
                    }
                }
            }
            throw new GeneralSecurityException("No good Provider found.", exc);
        }

        @Override // com.google.crypto.tink.subtle.EngineFactory.Policy
        public JcePrimitiveT getInstance(String str, List<Provider> list) throws GeneralSecurityException {
            return getInstance(str);
        }
    }

    static class AndroidPolicy<JcePrimitiveT> implements Policy<JcePrimitiveT> {
        private final EngineWrapper<JcePrimitiveT> jceFactory;

        private AndroidPolicy(EngineWrapper<JcePrimitiveT> engineWrapper) {
            this.jceFactory = engineWrapper;
        }

        @Override // com.google.crypto.tink.subtle.EngineFactory.Policy
        public JcePrimitiveT getInstance(String str) throws GeneralSecurityException {
            Iterator<Provider> it2 = EngineFactory.toProviderList(ProviderInstaller.PROVIDER_NAME, "AndroidOpenSSL").iterator();
            Exception exc = null;
            while (it2.hasNext()) {
                try {
                    return this.jceFactory.getInstance(str, it2.next());
                } catch (Exception e) {
                    if (exc == null) {
                        exc = e;
                    }
                }
            }
            return this.jceFactory.getInstance(str, null);
        }

        @Override // com.google.crypto.tink.subtle.EngineFactory.Policy
        public JcePrimitiveT getInstance(String str, List<Provider> list) throws GeneralSecurityException {
            return getInstance(str);
        }
    }

    public static List<Provider> toProviderList(String... strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            Provider provider = Security.getProvider(str);
            if (provider != null) {
                arrayList.add(provider);
            }
        }
        return arrayList;
    }

    public EngineFactory(T_WRAPPER t_wrapper) {
        if (TinkFipsUtil.useOnlyFips()) {
            this.policy = new FipsPolicy(t_wrapper);
        } else if (SubtleUtil.isAndroid()) {
            this.policy = new AndroidPolicy(t_wrapper);
        } else {
            this.policy = new DefaultPolicy(t_wrapper);
        }
    }

    public JcePrimitiveT getInstance(String str) throws GeneralSecurityException {
        return this.policy.getInstance(str);
    }

    JcePrimitiveT getInstance(String str, List<Provider> list) throws GeneralSecurityException {
        return this.policy.getInstance(str, list);
    }
}
