package com.google.crypto.tink.jwt;

import com.google.crypto.tink.KeysetHandleInterface;
import com.google.crypto.tink.internal.MonitoringAnnotations;
import com.google.crypto.tink.internal.MonitoringClient;
import com.google.crypto.tink.internal.MonitoringUtil;
import com.google.crypto.tink.internal.MutableMonitoringRegistry;
import com.google.crypto.tink.internal.MutablePrimitiveRegistry;
import com.google.crypto.tink.internal.PrimitiveRegistry;
import com.google.crypto.tink.internal.PrimitiveWrapper;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes5.dex */
class JwtPublicKeySignWrapper implements PrimitiveWrapper<JwtPublicKeySign, JwtPublicKeySign> {
    private static final JwtPublicKeySignWrapper WRAPPER = new JwtPublicKeySignWrapper();

    JwtPublicKeySignWrapper() {
    }

    @Immutable
    static class WrappedJwtPublicKeySign implements JwtPublicKeySign {
        private final MonitoringClient.Logger logger;
        private final JwtPublicKeySign primary;
        private final int primaryKeyId;

        WrappedJwtPublicKeySign(KeysetHandleInterface keysetHandleInterface, PrimitiveWrapper.PrimitiveFactory<JwtPublicKeySign> primitiveFactory) throws GeneralSecurityException {
            this.primary = primitiveFactory.create(keysetHandleInterface.getPrimary());
            this.primaryKeyId = keysetHandleInterface.getPrimary().getId();
            MonitoringAnnotations monitoringAnnotations = (MonitoringAnnotations) keysetHandleInterface.getAnnotationsOrNull(MonitoringAnnotations.class);
            if (monitoringAnnotations != null && !monitoringAnnotations.isEmpty()) {
                this.logger = MutableMonitoringRegistry.globalInstance().getMonitoringClient().createLogger(keysetHandleInterface, monitoringAnnotations, "jwtsign", "sign");
            } else {
                this.logger = MonitoringUtil.DO_NOTHING_LOGGER;
            }
        }

        @Override // com.google.crypto.tink.jwt.JwtPublicKeySign
        public String signAndEncode(RawJwt rawJwt) throws GeneralSecurityException {
            try {
                String strSignAndEncode = this.primary.signAndEncode(rawJwt);
                this.logger.log(this.primaryKeyId, 1L);
                return strSignAndEncode;
            } catch (GeneralSecurityException e) {
                this.logger.logFailure();
                throw e;
            }
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.crypto.tink.internal.PrimitiveWrapper
    public JwtPublicKeySign wrap(KeysetHandleInterface keysetHandleInterface, PrimitiveWrapper.PrimitiveFactory<JwtPublicKeySign> primitiveFactory) throws GeneralSecurityException {
        return new WrappedJwtPublicKeySign(keysetHandleInterface, primitiveFactory);
    }

    @Override // com.google.crypto.tink.internal.PrimitiveWrapper
    public Class<JwtPublicKeySign> getPrimitiveClass() {
        return JwtPublicKeySign.class;
    }

    @Override // com.google.crypto.tink.internal.PrimitiveWrapper
    public Class<JwtPublicKeySign> getInputPrimitiveClass() {
        return JwtPublicKeySign.class;
    }

    public static void register() throws GeneralSecurityException {
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveWrapper(WRAPPER);
    }

    public static void registerToInternalPrimitiveRegistry(PrimitiveRegistry.Builder builder) throws GeneralSecurityException {
        builder.registerPrimitiveWrapper(WRAPPER);
    }
}
