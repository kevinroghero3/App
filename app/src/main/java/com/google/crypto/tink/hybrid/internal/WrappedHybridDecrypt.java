package com.google.crypto.tink.hybrid.internal;

import com.google.crypto.tink.HybridDecrypt;
import com.google.crypto.tink.Key;
import com.google.crypto.tink.KeyStatus;
import com.google.crypto.tink.KeysetHandleInterface;
import com.google.crypto.tink.hybrid.HybridPrivateKey;
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
public class WrappedHybridDecrypt {

    static class HybridDecryptWithId {
        public final HybridDecrypt hybridDecrypt;
        public final int id;

        public HybridDecryptWithId(HybridDecrypt hybridDecrypt, int i) {
            this.hybridDecrypt = hybridDecrypt;
            this.id = i;
        }
    }

    private static Bytes getOutputPrefix(Key key) throws GeneralSecurityException {
        if (key instanceof HybridPrivateKey) {
            return ((HybridPrivateKey) key).getOutputPrefix();
        }
        if (key instanceof LegacyProtoKey) {
            return ((LegacyProtoKey) key).getOutputPrefix();
        }
        throw new GeneralSecurityException("Cannot get output prefix for key of class " + key.getClass().getName() + " with parameters " + key.getParameters());
    }

    static class WrappedHybridDecryptImpl implements HybridDecrypt {
        private final PrefixMap<HybridDecryptWithId> allHybridDecrypts;
        private final MonitoringClient.Logger decLogger;

        WrappedHybridDecryptImpl(PrefixMap<HybridDecryptWithId> prefixMap, MonitoringClient.Logger logger) {
            this.allHybridDecrypts = prefixMap;
            this.decLogger = logger;
        }

        @Override // com.google.crypto.tink.HybridDecrypt
        public byte[] decrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
            for (HybridDecryptWithId hybridDecryptWithId : this.allHybridDecrypts.getAllWithMatchingPrefix(bArr)) {
                try {
                    byte[] bArrDecrypt = hybridDecryptWithId.hybridDecrypt.decrypt(bArr, bArr2);
                    this.decLogger.log(hybridDecryptWithId.id, bArr.length);
                    return bArrDecrypt;
                } catch (GeneralSecurityException unused) {
                }
            }
            this.decLogger.logFailure();
            throw new GeneralSecurityException("decryption failed");
        }
    }

    private WrappedHybridDecrypt() {
    }

    public static HybridDecrypt create(KeysetHandleInterface keysetHandleInterface, PrimitiveWrapper.PrimitiveFactory<HybridDecrypt> primitiveFactory) throws GeneralSecurityException {
        MonitoringClient.Logger loggerCreateLogger;
        PrefixMap.Builder builder = new PrefixMap.Builder();
        for (int i = 0; i < keysetHandleInterface.size(); i++) {
            KeysetHandleInterface.Entry at = keysetHandleInterface.getAt(i);
            if (at.getStatus().equals(KeyStatus.ENABLED)) {
                builder.put(getOutputPrefix(at.getKey()), new HybridDecryptWithId(primitiveFactory.create(at), at.getId()));
            }
        }
        MonitoringAnnotations monitoringAnnotations = (MonitoringAnnotations) keysetHandleInterface.getAnnotationsOrNull(MonitoringAnnotations.class);
        if (monitoringAnnotations != null && !monitoringAnnotations.isEmpty()) {
            loggerCreateLogger = MutableMonitoringRegistry.globalInstance().getMonitoringClient().createLogger(keysetHandleInterface, monitoringAnnotations, "hybrid_decrypt", "decrypt");
        } else {
            loggerCreateLogger = MonitoringUtil.DO_NOTHING_LOGGER;
        }
        return new WrappedHybridDecryptImpl(builder.build(), loggerCreateLogger);
    }
}
