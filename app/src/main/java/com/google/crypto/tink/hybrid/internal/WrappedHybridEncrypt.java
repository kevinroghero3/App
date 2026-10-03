package com.google.crypto.tink.hybrid.internal;

import com.google.crypto.tink.HybridEncrypt;
import com.google.crypto.tink.KeysetHandleInterface;
import com.google.crypto.tink.internal.MonitoringAnnotations;
import com.google.crypto.tink.internal.MonitoringClient;
import com.google.crypto.tink.internal.MonitoringUtil;
import com.google.crypto.tink.internal.MutableMonitoringRegistry;
import com.google.crypto.tink.internal.PrimitiveWrapper;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes2.dex */
public final class WrappedHybridEncrypt {

    static class HybridEncryptWithId {
        public final HybridEncrypt hybridEncrypt;
        public final int id;

        public HybridEncryptWithId(HybridEncrypt hybridEncrypt, int i) {
            this.hybridEncrypt = hybridEncrypt;
            this.id = i;
        }
    }

    static class WrappedHybridEncryptImpl implements HybridEncrypt {
        private final MonitoringClient.Logger encLogger;
        private final HybridEncryptWithId primary;

        WrappedHybridEncryptImpl(HybridEncryptWithId hybridEncryptWithId, MonitoringClient.Logger logger) {
            this.primary = hybridEncryptWithId;
            this.encLogger = logger;
        }

        @Override // com.google.crypto.tink.HybridEncrypt
        public byte[] encrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
            HybridEncrypt hybridEncrypt = this.primary.hybridEncrypt;
            if (hybridEncrypt == null) {
                this.encLogger.logFailure();
                throw new GeneralSecurityException("keyset without primary key");
            }
            try {
                byte[] bArrEncrypt = hybridEncrypt.encrypt(bArr, bArr2);
                this.encLogger.log(this.primary.id, bArr.length);
                return bArrEncrypt;
            } catch (GeneralSecurityException e) {
                this.encLogger.logFailure();
                throw e;
            }
        }
    }

    public static HybridEncrypt create(KeysetHandleInterface keysetHandleInterface, PrimitiveWrapper.PrimitiveFactory<HybridEncrypt> primitiveFactory) throws GeneralSecurityException {
        MonitoringClient.Logger loggerCreateLogger;
        MonitoringAnnotations monitoringAnnotations = (MonitoringAnnotations) keysetHandleInterface.getAnnotationsOrNull(MonitoringAnnotations.class);
        if (monitoringAnnotations != null && !monitoringAnnotations.isEmpty()) {
            loggerCreateLogger = MutableMonitoringRegistry.globalInstance().getMonitoringClient().createLogger(keysetHandleInterface, monitoringAnnotations, "hybrid_encrypt", "encrypt");
        } else {
            loggerCreateLogger = MonitoringUtil.DO_NOTHING_LOGGER;
        }
        KeysetHandleInterface.Entry primary = keysetHandleInterface.getPrimary();
        return new WrappedHybridEncryptImpl(new HybridEncryptWithId(primitiveFactory.create(primary), primary.getId()), loggerCreateLogger);
    }

    private WrappedHybridEncrypt() {
    }
}
