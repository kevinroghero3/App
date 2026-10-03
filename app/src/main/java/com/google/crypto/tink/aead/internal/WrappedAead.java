package com.google.crypto.tink.aead.internal;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.Key;
import com.google.crypto.tink.KeyStatus;
import com.google.crypto.tink.KeysetHandleInterface;
import com.google.crypto.tink.aead.AeadKey;
import com.google.crypto.tink.internal.LegacyProtoKey;
import com.google.crypto.tink.internal.MonitoringAnnotations;
import com.google.crypto.tink.internal.MonitoringClient;
import com.google.crypto.tink.internal.MonitoringUtil;
import com.google.crypto.tink.internal.MutableMonitoringRegistry;
import com.google.crypto.tink.internal.PrefixMap;
import com.google.crypto.tink.internal.PrimitiveWrapper;
import com.google.crypto.tink.util.Bytes;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes2.dex */
public final class WrappedAead {

    static final class AeadWithId {
        public final Aead aead;
        public final int id;

        public AeadWithId(Aead aead, int i) {
            this.aead = aead;
            this.id = i;
        }
    }

    private static Bytes getOutputPrefix(Key key) throws GeneralSecurityException {
        if (key instanceof AeadKey) {
            return ((AeadKey) key).getOutputPrefix();
        }
        if (key instanceof LegacyProtoKey) {
            return ((LegacyProtoKey) key).getOutputPrefix();
        }
        throw new GeneralSecurityException("Cannot get output prefix for key of class " + key.getClass().getName() + " with parameters " + key.getParameters());
    }

    static class WrappedAeadImpl implements Aead {
        private final PrefixMap<AeadWithId> allAeads;
        private final MonitoringClient.Logger decLogger;
        private final MonitoringClient.Logger encLogger;
        private final AeadWithId primary;

        private WrappedAeadImpl(AeadWithId aeadWithId, PrefixMap<AeadWithId> prefixMap, MonitoringClient.Logger logger, MonitoringClient.Logger logger2) {
            this.primary = aeadWithId;
            this.allAeads = prefixMap;
            this.encLogger = logger;
            this.decLogger = logger2;
        }

        @Override // com.google.crypto.tink.Aead
        public byte[] encrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
            try {
                byte[] bArrEncrypt = this.primary.aead.encrypt(bArr, bArr2);
                this.encLogger.log(this.primary.id, bArr.length);
                return bArrEncrypt;
            } catch (GeneralSecurityException e) {
                this.encLogger.logFailure();
                throw e;
            }
        }

        @Override // com.google.crypto.tink.Aead
        public byte[] decrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
            for (AeadWithId aeadWithId : this.allAeads.getAllWithMatchingPrefix(bArr)) {
                try {
                    byte[] bArrDecrypt = aeadWithId.aead.decrypt(bArr, bArr2);
                    this.decLogger.log(aeadWithId.id, bArr.length);
                    return bArrDecrypt;
                } catch (GeneralSecurityException unused) {
                }
            }
            this.decLogger.logFailure();
            throw new GeneralSecurityException("decryption failed");
        }
    }

    public static Aead create(KeysetHandleInterface keysetHandleInterface, PrimitiveWrapper.PrimitiveFactory<Aead> primitiveFactory) throws GeneralSecurityException {
        MonitoringClient.Logger logger;
        MonitoringClient.Logger loggerCreateLogger;
        PrefixMap.Builder builder = new PrefixMap.Builder();
        for (int i = 0; i < keysetHandleInterface.size(); i++) {
            KeysetHandleInterface.Entry at = keysetHandleInterface.getAt(i);
            if (at.getStatus().equals(KeyStatus.ENABLED)) {
                builder.put(getOutputPrefix(at.getKey()), new AeadWithId(primitiveFactory.create(at), at.getId()));
            }
        }
        MonitoringAnnotations monitoringAnnotations = (MonitoringAnnotations) keysetHandleInterface.getAnnotationsOrNull(MonitoringAnnotations.class);
        if (monitoringAnnotations != null && !monitoringAnnotations.isEmpty()) {
            MonitoringClient monitoringClient = MutableMonitoringRegistry.globalInstance().getMonitoringClient();
            MonitoringClient.Logger loggerCreateLogger2 = monitoringClient.createLogger(keysetHandleInterface, monitoringAnnotations, "aead", "encrypt");
            loggerCreateLogger = monitoringClient.createLogger(keysetHandleInterface, monitoringAnnotations, "aead", "decrypt");
            logger = loggerCreateLogger2;
        } else {
            logger = MonitoringUtil.DO_NOTHING_LOGGER;
            loggerCreateLogger = logger;
        }
        return new WrappedAeadImpl(new AeadWithId(primitiveFactory.create(keysetHandleInterface.getPrimary()), keysetHandleInterface.getPrimary().getId()), builder.build(), logger, loggerCreateLogger);
    }

    private WrappedAead() {
    }
}
