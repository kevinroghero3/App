package com.google.crypto.tink.signature.internal;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.KeyStatus;
import com.google.crypto.tink.KeysetHandleInterface;
import com.google.crypto.tink.PublicKeyVerify;
import com.google.crypto.tink.internal.LegacyProtoKey;
import com.google.crypto.tink.internal.MonitoringAnnotations;
import com.google.crypto.tink.internal.MonitoringClient;
import com.google.crypto.tink.internal.MonitoringUtil;
import com.google.crypto.tink.internal.MutableMonitoringRegistry;
import com.google.crypto.tink.internal.PrefixMap;
import com.google.crypto.tink.internal.PrimitiveWrapper;
import com.google.crypto.tink.signature.SignaturePublicKey;
import com.google.crypto.tink.util.Bytes;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes3.dex */
public final class WrappedPublicKeyVerify {

    static class PublicKeyVerifyWithId {
        final int id;
        final PublicKeyVerify publicKeyVerify;

        PublicKeyVerifyWithId(PublicKeyVerify publicKeyVerify, int i) {
            this.publicKeyVerify = publicKeyVerify;
            this.id = i;
        }
    }

    private static Bytes getOutputPrefix(Key key) throws GeneralSecurityException {
        if (key instanceof SignaturePublicKey) {
            return ((SignaturePublicKey) key).getOutputPrefix();
        }
        if (key instanceof LegacyProtoKey) {
            return ((LegacyProtoKey) key).getOutputPrefix();
        }
        throw new GeneralSecurityException("Cannot get output prefix for key of class " + key.getClass().getName() + " with parameters " + key.getParameters());
    }

    static class PublicKeyVerifyImpl implements PublicKeyVerify {
        private final PrefixMap<PublicKeyVerifyWithId> allPublicKeyVerifys;
        private final MonitoringClient.Logger monitoringLogger;

        PublicKeyVerifyImpl(PrefixMap<PublicKeyVerifyWithId> prefixMap, MonitoringClient.Logger logger) {
            this.allPublicKeyVerifys = prefixMap;
            this.monitoringLogger = logger;
        }

        @Override // com.google.crypto.tink.PublicKeyVerify
        public void verify(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
            for (PublicKeyVerifyWithId publicKeyVerifyWithId : this.allPublicKeyVerifys.getAllWithMatchingPrefix(bArr)) {
                try {
                    publicKeyVerifyWithId.publicKeyVerify.verify(bArr, bArr2);
                    this.monitoringLogger.log(publicKeyVerifyWithId.id, bArr2.length);
                    return;
                } catch (GeneralSecurityException unused) {
                }
            }
            this.monitoringLogger.logFailure();
            throw new GeneralSecurityException("invalid signature");
        }
    }

    public static PublicKeyVerify create(KeysetHandleInterface keysetHandleInterface, PrimitiveWrapper.PrimitiveFactory<PublicKeyVerify> primitiveFactory) throws GeneralSecurityException {
        MonitoringClient.Logger loggerCreateLogger;
        PrefixMap.Builder builder = new PrefixMap.Builder();
        for (int i = 0; i < keysetHandleInterface.size(); i++) {
            KeysetHandleInterface.Entry at = keysetHandleInterface.getAt(i);
            if (at.getStatus().equals(KeyStatus.ENABLED)) {
                builder.put(getOutputPrefix(at.getKey()), new PublicKeyVerifyWithId(primitiveFactory.create(at), at.getId()));
            }
        }
        MonitoringAnnotations monitoringAnnotations = (MonitoringAnnotations) keysetHandleInterface.getAnnotationsOrNull(MonitoringAnnotations.class);
        if (monitoringAnnotations != null && !monitoringAnnotations.isEmpty()) {
            loggerCreateLogger = MutableMonitoringRegistry.globalInstance().getMonitoringClient().createLogger(keysetHandleInterface, monitoringAnnotations, "public_key_verify", "verify");
        } else {
            loggerCreateLogger = MonitoringUtil.DO_NOTHING_LOGGER;
        }
        return new PublicKeyVerifyImpl(builder.build(), loggerCreateLogger);
    }

    private WrappedPublicKeyVerify() {
    }
}
