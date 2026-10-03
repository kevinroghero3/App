package com.google.crypto.tink.mac.internal;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.KeyStatus;
import com.google.crypto.tink.KeysetHandleInterface;
import com.google.crypto.tink.Mac;
import com.google.crypto.tink.internal.LegacyProtoKey;
import com.google.crypto.tink.internal.MonitoringAnnotations;
import com.google.crypto.tink.internal.MonitoringClient;
import com.google.crypto.tink.internal.MonitoringUtil;
import com.google.crypto.tink.internal.MutableMonitoringRegistry;
import com.google.crypto.tink.internal.PrefixMap;
import com.google.crypto.tink.internal.PrimitiveWrapper;
import com.google.crypto.tink.mac.MacKey;
import com.google.crypto.tink.util.Bytes;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes2.dex */
public final class WrappedMac {

    static class MacWithId {
        public final int id;
        public final Mac mac;

        public MacWithId(Mac mac, int i) {
            this.mac = mac;
            this.id = i;
        }
    }

    private static Bytes getOutputPrefix(Key key) throws GeneralSecurityException {
        if (key instanceof MacKey) {
            return ((MacKey) key).getOutputPrefix();
        }
        if (key instanceof LegacyProtoKey) {
            return ((LegacyProtoKey) key).getOutputPrefix();
        }
        throw new GeneralSecurityException("Cannot get output prefix for key of class " + key.getClass().getName() + " with parameters " + key.getParameters());
    }

    static class WrappedMacImpl implements Mac {
        private final PrefixMap<MacWithId> allMacs;
        private final MonitoringClient.Logger computeLogger;
        private final MacWithId primary;
        private final MonitoringClient.Logger verifyLogger;

        private WrappedMacImpl(MacWithId macWithId, PrefixMap<MacWithId> prefixMap, MonitoringClient.Logger logger, MonitoringClient.Logger logger2) {
            this.primary = macWithId;
            this.allMacs = prefixMap;
            this.computeLogger = logger;
            this.verifyLogger = logger2;
        }

        @Override // com.google.crypto.tink.Mac
        public byte[] computeMac(byte[] bArr) throws GeneralSecurityException {
            try {
                byte[] bArrComputeMac = this.primary.mac.computeMac(bArr);
                this.computeLogger.log(this.primary.id, bArr.length);
                return bArrComputeMac;
            } catch (GeneralSecurityException e) {
                this.computeLogger.logFailure();
                throw e;
            }
        }

        @Override // com.google.crypto.tink.Mac
        public void verifyMac(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
            for (MacWithId macWithId : this.allMacs.getAllWithMatchingPrefix(bArr)) {
                try {
                    macWithId.mac.verifyMac(bArr, bArr2);
                    this.verifyLogger.log(macWithId.id, bArr2.length);
                    return;
                } catch (GeneralSecurityException unused) {
                }
            }
            this.verifyLogger.logFailure();
            throw new GeneralSecurityException("invalid MAC");
        }
    }

    public static Mac create(KeysetHandleInterface keysetHandleInterface, PrimitiveWrapper.PrimitiveFactory<Mac> primitiveFactory) throws GeneralSecurityException {
        MonitoringClient.Logger logger;
        MonitoringClient.Logger loggerCreateLogger;
        PrefixMap.Builder builder = new PrefixMap.Builder();
        for (int i = 0; i < keysetHandleInterface.size(); i++) {
            KeysetHandleInterface.Entry at = keysetHandleInterface.getAt(i);
            if (at.getStatus().equals(KeyStatus.ENABLED)) {
                builder.put(getOutputPrefix(at.getKey()), new MacWithId(primitiveFactory.create(at), at.getId()));
            }
        }
        MonitoringAnnotations monitoringAnnotations = (MonitoringAnnotations) keysetHandleInterface.getAnnotationsOrNull(MonitoringAnnotations.class);
        if (monitoringAnnotations != null && !monitoringAnnotations.isEmpty()) {
            MonitoringClient monitoringClient = MutableMonitoringRegistry.globalInstance().getMonitoringClient();
            MonitoringClient.Logger loggerCreateLogger2 = monitoringClient.createLogger(keysetHandleInterface, monitoringAnnotations, "mac", "compute");
            loggerCreateLogger = monitoringClient.createLogger(keysetHandleInterface, monitoringAnnotations, "mac", "verify");
            logger = loggerCreateLogger2;
        } else {
            logger = MonitoringUtil.DO_NOTHING_LOGGER;
            loggerCreateLogger = logger;
        }
        return new WrappedMacImpl(new MacWithId(primitiveFactory.create(keysetHandleInterface.getPrimary()), keysetHandleInterface.getPrimary().getId()), builder.build(), logger, loggerCreateLogger);
    }

    private WrappedMac() {
    }
}
