package com.google.crypto.tink.signature.internal;

import com.google.crypto.tink.KeysetHandleInterface;
import com.google.crypto.tink.PublicKeySign;
import com.google.crypto.tink.internal.MonitoringAnnotations;
import com.google.crypto.tink.internal.MonitoringClient;
import com.google.crypto.tink.internal.MonitoringUtil;
import com.google.crypto.tink.internal.MutableMonitoringRegistry;
import com.google.crypto.tink.internal.PrimitiveWrapper;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes3.dex */
public final class WrappedPublicKeySign {

    static class PublicKeySignWithId {
        final int id;
        final PublicKeySign publicKeySign;

        PublicKeySignWithId(PublicKeySign publicKeySign, int i) {
            this.publicKeySign = publicKeySign;
            this.id = i;
        }
    }

    static class PublicKeySignImpl implements PublicKeySign {
        private final MonitoringClient.Logger logger;
        private final PublicKeySignWithId primary;

        PublicKeySignImpl(PublicKeySignWithId publicKeySignWithId, MonitoringClient.Logger logger) {
            this.primary = publicKeySignWithId;
            this.logger = logger;
        }

        @Override // com.google.crypto.tink.PublicKeySign
        public byte[] sign(byte[] bArr) throws GeneralSecurityException {
            try {
                byte[] bArrSign = this.primary.publicKeySign.sign(bArr);
                this.logger.log(this.primary.id, bArr.length);
                return bArrSign;
            } catch (GeneralSecurityException e) {
                this.logger.logFailure();
                throw e;
            }
        }
    }

    public static PublicKeySign create(KeysetHandleInterface keysetHandleInterface, PrimitiveWrapper.PrimitiveFactory<PublicKeySign> primitiveFactory) throws GeneralSecurityException {
        MonitoringClient.Logger loggerCreateLogger;
        MonitoringAnnotations monitoringAnnotations = (MonitoringAnnotations) keysetHandleInterface.getAnnotationsOrNull(MonitoringAnnotations.class);
        if (monitoringAnnotations != null && !monitoringAnnotations.isEmpty()) {
            loggerCreateLogger = MutableMonitoringRegistry.globalInstance().getMonitoringClient().createLogger(keysetHandleInterface, monitoringAnnotations, "public_key_sign", "sign");
        } else {
            loggerCreateLogger = MonitoringUtil.DO_NOTHING_LOGGER;
        }
        return new PublicKeySignImpl(new PublicKeySignWithId(primitiveFactory.create(keysetHandleInterface.getPrimary()), keysetHandleInterface.getPrimary().getId()), loggerCreateLogger);
    }

    private WrappedPublicKeySign() {
    }
}
