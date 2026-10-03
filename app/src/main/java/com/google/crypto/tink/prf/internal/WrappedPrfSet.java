package com.google.crypto.tink.prf.internal;

import com.google.crypto.tink.KeyStatus;
import com.google.crypto.tink.KeysetHandleInterface;
import com.google.crypto.tink.internal.LegacyProtoKey;
import com.google.crypto.tink.internal.MonitoringAnnotations;
import com.google.crypto.tink.internal.MonitoringClient;
import com.google.crypto.tink.internal.MonitoringUtil;
import com.google.crypto.tink.internal.MutableMonitoringRegistry;
import com.google.crypto.tink.internal.PrimitiveWrapper;
import com.google.crypto.tink.prf.Prf;
import com.google.crypto.tink.prf.PrfSet;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@Immutable
public final class WrappedPrfSet {

    static class WrappedPrfSetImpl extends PrfSet {
        private final Map<Integer, Prf> keyIdToPrfMap;
        private final int primaryKeyId;

        @Immutable
        static class PrfWithMonitoring implements Prf {
            private final int keyId;
            private final MonitoringClient.Logger logger;
            private final Prf prf;

            @Override // com.google.crypto.tink.prf.Prf
            public byte[] compute(byte[] bArr, int i) throws GeneralSecurityException {
                try {
                    byte[] bArrCompute = this.prf.compute(bArr, i);
                    this.logger.log(this.keyId, bArr.length);
                    return bArrCompute;
                } catch (GeneralSecurityException e) {
                    this.logger.logFailure();
                    throw e;
                }
            }

            public PrfWithMonitoring(Prf prf, int i, MonitoringClient.Logger logger) {
                this.prf = prf;
                this.keyId = i;
                this.logger = logger;
            }
        }

        private WrappedPrfSetImpl(Map<Integer, Prf> map, int i) {
            this.keyIdToPrfMap = map;
            this.primaryKeyId = i;
        }

        @Override // com.google.crypto.tink.prf.PrfSet
        public int getPrimaryId() {
            return this.primaryKeyId;
        }

        @Override // com.google.crypto.tink.prf.PrfSet
        public Map<Integer, Prf> getPrfs() throws GeneralSecurityException {
            return this.keyIdToPrfMap;
        }
    }

    public static PrfSet create(KeysetHandleInterface keysetHandleInterface, PrimitiveWrapper.PrimitiveFactory<Prf> primitiveFactory) throws GeneralSecurityException {
        MonitoringClient.Logger loggerCreateLogger;
        MonitoringAnnotations monitoringAnnotations = (MonitoringAnnotations) keysetHandleInterface.getAnnotationsOrNull(MonitoringAnnotations.class);
        if (monitoringAnnotations != null && !monitoringAnnotations.isEmpty()) {
            loggerCreateLogger = MutableMonitoringRegistry.globalInstance().getMonitoringClient().createLogger(keysetHandleInterface, monitoringAnnotations, "prf", "compute");
        } else {
            loggerCreateLogger = MonitoringUtil.DO_NOTHING_LOGGER;
        }
        HashMap map = new HashMap();
        for (int i = 0; i < keysetHandleInterface.size(); i++) {
            KeysetHandleInterface.Entry at = keysetHandleInterface.getAt(i);
            if (at.getStatus().equals(KeyStatus.ENABLED)) {
                if ((at.getKey() instanceof LegacyProtoKey) && ((LegacyProtoKey) at.getKey()).getOutputPrefix().size() != 0) {
                    throw new GeneralSecurityException("Cannot build PrfSet with keys with non-empty output prefix");
                }
                Prf prfCreate = primitiveFactory.create(at);
                int id = at.getId();
                map.put(Integer.valueOf(id), new WrappedPrfSetImpl.PrfWithMonitoring(prfCreate, at.getId(), loggerCreateLogger));
            }
        }
        return new WrappedPrfSetImpl(map, keysetHandleInterface.getPrimary().getId());
    }

    private WrappedPrfSet() {
    }
}
