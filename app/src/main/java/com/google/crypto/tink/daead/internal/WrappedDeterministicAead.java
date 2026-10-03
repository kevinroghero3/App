package com.google.crypto.tink.daead.internal;

import com.google.crypto.tink.DeterministicAead;
import com.google.crypto.tink.Key;
import com.google.crypto.tink.KeyStatus;
import com.google.crypto.tink.KeysetHandleInterface;
import com.google.crypto.tink.daead.DeterministicAeadKey;
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
public final class WrappedDeterministicAead {

    static class DeterministicAeadWithId {
        public final DeterministicAead daead;
        public final int id;

        public DeterministicAeadWithId(DeterministicAead deterministicAead, int i) {
            this.daead = deterministicAead;
            this.id = i;
        }
    }

    private static Bytes getOutputPrefix(Key key) throws GeneralSecurityException {
        if (key instanceof DeterministicAeadKey) {
            return ((DeterministicAeadKey) key).getOutputPrefix();
        }
        if (key instanceof LegacyProtoKey) {
            return ((LegacyProtoKey) key).getOutputPrefix();
        }
        throw new GeneralSecurityException("Cannot get output prefix for key of class " + key.getClass().getName() + " with parameters " + key.getParameters());
    }

    static class WrappedDeterministicAeadImpl implements DeterministicAead {
        private final PrefixMap<DeterministicAeadWithId> allDaeads;
        private final MonitoringClient.Logger decLogger;
        private final MonitoringClient.Logger encLogger;
        private final DeterministicAeadWithId primary;

        WrappedDeterministicAeadImpl(DeterministicAeadWithId deterministicAeadWithId, PrefixMap<DeterministicAeadWithId> prefixMap, MonitoringClient.Logger logger, MonitoringClient.Logger logger2) {
            this.primary = deterministicAeadWithId;
            this.allDaeads = prefixMap;
            this.encLogger = logger;
            this.decLogger = logger2;
        }

        @Override // com.google.crypto.tink.DeterministicAead
        public byte[] encryptDeterministically(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
            try {
                byte[] bArrEncryptDeterministically = this.primary.daead.encryptDeterministically(bArr, bArr2);
                this.encLogger.log(this.primary.id, bArr.length);
                return bArrEncryptDeterministically;
            } catch (GeneralSecurityException e) {
                this.encLogger.logFailure();
                throw e;
            }
        }

        @Override // com.google.crypto.tink.DeterministicAead
        public byte[] decryptDeterministically(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
            for (DeterministicAeadWithId deterministicAeadWithId : this.allDaeads.getAllWithMatchingPrefix(bArr)) {
                try {
                    byte[] bArrDecryptDeterministically = deterministicAeadWithId.daead.decryptDeterministically(bArr, bArr2);
                    this.decLogger.log(deterministicAeadWithId.id, bArr.length);
                    return bArrDecryptDeterministically;
                } catch (GeneralSecurityException unused) {
                }
            }
            this.decLogger.logFailure();
            throw new GeneralSecurityException("decryption failed");
        }
    }

    public static DeterministicAead create(KeysetHandleInterface keysetHandleInterface, PrimitiveWrapper.PrimitiveFactory<DeterministicAead> primitiveFactory) throws GeneralSecurityException {
        MonitoringClient.Logger loggerCreateLogger;
        MonitoringClient.Logger loggerCreateLogger2;
        PrefixMap.Builder builder = new PrefixMap.Builder();
        for (int i = 0; i < keysetHandleInterface.size(); i++) {
            KeysetHandleInterface.Entry at = keysetHandleInterface.getAt(i);
            if (at.getStatus().equals(KeyStatus.ENABLED)) {
                builder.put(getOutputPrefix(at.getKey()), new DeterministicAeadWithId(primitiveFactory.create(at), at.getId()));
            }
        }
        MonitoringAnnotations monitoringAnnotations = (MonitoringAnnotations) keysetHandleInterface.getAnnotationsOrNull(MonitoringAnnotations.class);
        if (monitoringAnnotations != null && !monitoringAnnotations.isEmpty()) {
            MonitoringClient monitoringClient = MutableMonitoringRegistry.globalInstance().getMonitoringClient();
            loggerCreateLogger = monitoringClient.createLogger(keysetHandleInterface, monitoringAnnotations, "daead", "encrypt");
            loggerCreateLogger2 = monitoringClient.createLogger(keysetHandleInterface, monitoringAnnotations, "daead", "decrypt");
        } else {
            loggerCreateLogger = MonitoringUtil.DO_NOTHING_LOGGER;
            loggerCreateLogger2 = loggerCreateLogger;
        }
        return new WrappedDeterministicAeadImpl(new DeterministicAeadWithId(primitiveFactory.create(keysetHandleInterface.getPrimary()), keysetHandleInterface.getPrimary().getId()), builder.build(), loggerCreateLogger, loggerCreateLogger2);
    }

    private WrappedDeterministicAead() {
    }
}
