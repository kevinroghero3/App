package com.google.crypto.tink.jwt;

import com.google.crypto.tink.KeyStatus;
import com.google.crypto.tink.KeysetHandleInterface;
import com.google.crypto.tink.internal.MonitoringAnnotations;
import com.google.crypto.tink.internal.MonitoringClient;
import com.google.crypto.tink.internal.MonitoringUtil;
import com.google.crypto.tink.internal.MutableMonitoringRegistry;
import com.google.crypto.tink.internal.MutablePrimitiveRegistry;
import com.google.crypto.tink.internal.PrimitiveWrapper;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
class JwtMacWrapper implements PrimitiveWrapper<JwtMac, JwtMac> {
    private static final JwtMacWrapper WRAPPER = new JwtMacWrapper();

    static class JwtMacWithId {
        final int id;
        final JwtMac jwtMac;

        JwtMacWithId(JwtMac jwtMac, int i) {
            this.jwtMac = jwtMac;
            this.id = i;
        }
    }

    private static void validate(KeysetHandleInterface keysetHandleInterface) throws GeneralSecurityException {
        if (keysetHandleInterface.getPrimary() == null) {
            throw new GeneralSecurityException("Primitive set has no primary.");
        }
    }

    @Immutable
    static class WrappedJwtMac implements JwtMac {
        private final List<JwtMacWithId> allMacs;
        private final MonitoringClient.Logger computeLogger;
        private final JwtMacWithId primary;
        private final MonitoringClient.Logger verifyLogger;

        private WrappedJwtMac(JwtMacWithId jwtMacWithId, List<JwtMacWithId> list, MonitoringClient.Logger logger, MonitoringClient.Logger logger2) {
            this.primary = jwtMacWithId;
            this.allMacs = list;
            this.computeLogger = logger;
            this.verifyLogger = logger2;
        }

        @Override // com.google.crypto.tink.jwt.JwtMac
        public String computeMacAndEncode(RawJwt rawJwt) throws GeneralSecurityException {
            try {
                String strComputeMacAndEncode = this.primary.jwtMac.computeMacAndEncode(rawJwt);
                this.computeLogger.log(this.primary.id, 1L);
                return strComputeMacAndEncode;
            } catch (GeneralSecurityException e) {
                this.computeLogger.logFailure();
                throw e;
            }
        }

        @Override // com.google.crypto.tink.jwt.JwtMac
        public VerifiedJwt verifyMacAndDecode(String str, JwtValidator jwtValidator) throws GeneralSecurityException {
            GeneralSecurityException generalSecurityException = null;
            for (JwtMacWithId jwtMacWithId : this.allMacs) {
                try {
                    VerifiedJwt verifiedJwtVerifyMacAndDecode = jwtMacWithId.jwtMac.verifyMacAndDecode(str, jwtValidator);
                    this.verifyLogger.log(jwtMacWithId.id, 1L);
                    return verifiedJwtVerifyMacAndDecode;
                } catch (GeneralSecurityException e) {
                    if (e instanceof JwtInvalidException) {
                        generalSecurityException = e;
                    }
                }
            }
            this.verifyLogger.logFailure();
            if (generalSecurityException != null) {
                throw generalSecurityException;
            }
            throw new GeneralSecurityException("invalid MAC");
        }
    }

    JwtMacWrapper() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.crypto.tink.internal.PrimitiveWrapper
    public JwtMac wrap(KeysetHandleInterface keysetHandleInterface, PrimitiveWrapper.PrimitiveFactory<JwtMac> primitiveFactory) throws GeneralSecurityException {
        MonitoringClient.Logger loggerCreateLogger;
        MonitoringClient.Logger loggerCreateLogger2;
        validate(keysetHandleInterface);
        ArrayList arrayList = new ArrayList(keysetHandleInterface.size());
        for (int i = 0; i < keysetHandleInterface.size(); i++) {
            KeysetHandleInterface.Entry at = keysetHandleInterface.getAt(i);
            if (at.getStatus().equals(KeyStatus.ENABLED)) {
                arrayList.add(new JwtMacWithId(primitiveFactory.create(at), at.getId()));
            }
        }
        MonitoringAnnotations monitoringAnnotations = (MonitoringAnnotations) keysetHandleInterface.getAnnotationsOrNull(MonitoringAnnotations.class);
        if (monitoringAnnotations != null && !monitoringAnnotations.isEmpty()) {
            MonitoringClient monitoringClient = MutableMonitoringRegistry.globalInstance().getMonitoringClient();
            loggerCreateLogger = monitoringClient.createLogger(keysetHandleInterface, monitoringAnnotations, "jwtmac", "compute");
            loggerCreateLogger2 = monitoringClient.createLogger(keysetHandleInterface, monitoringAnnotations, "jwtmac", "verify");
        } else {
            loggerCreateLogger = MonitoringUtil.DO_NOTHING_LOGGER;
            loggerCreateLogger2 = loggerCreateLogger;
        }
        return new WrappedJwtMac(new JwtMacWithId(primitiveFactory.create(keysetHandleInterface.getPrimary()), keysetHandleInterface.getPrimary().getId()), arrayList, loggerCreateLogger, loggerCreateLogger2);
    }

    @Override // com.google.crypto.tink.internal.PrimitiveWrapper
    public Class<JwtMac> getPrimitiveClass() {
        return JwtMac.class;
    }

    @Override // com.google.crypto.tink.internal.PrimitiveWrapper
    public Class<JwtMac> getInputPrimitiveClass() {
        return JwtMac.class;
    }

    public static void register() throws GeneralSecurityException {
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveWrapper(WRAPPER);
    }
}
