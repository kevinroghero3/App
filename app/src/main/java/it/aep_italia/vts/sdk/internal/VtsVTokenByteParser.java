package it.aep_italia.vts.sdk.internal;

import it.aep_italia.vts.sdk.domain.VtsVToken;
import it.aep_italia.vts.sdk.domain.VtsValidation;
import it.aep_italia.vts.sdk.domain.enums.VtsObjectType;
import it.aep_italia.vts.sdk.domain.enums.VtsObjectTypeFormat;
import it.aep_italia.vts.sdk.domain.enums.VtsVTokenClassID;
import it.aep_italia.vts.sdk.domain.enums.VtsVTokenType;
import it.aep_italia.vts.sdk.errors.VtsError;
import it.aep_italia.vts.sdk.errors.VtsException;
import it.aep_italia.vts.sdk.utils.ByteUtils;
import it.aep_italia.vts.sdk.utils.StreamUtils;
import it.aep_italia.vts.sdk.utils.ValidationUtils;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

/* JADX INFO: loaded from: classes6.dex */
public final class VtsVTokenByteParser {
    private int a(VtsVToken vtsVToken, ByteArrayInputStream byteArrayInputStream) {
        boolean z = byteArrayInputStream.available() >= 57;
        VtsError vtsError = VtsError.COULD_NOT_DESERIALIZE_TOKEN;
        ValidationUtils.assertTrue(z, vtsError, "Expected at least 57 bytes, got %d", Integer.valueOf(byteArrayInputStream.available()));
        try {
            byteArrayInputStream.skip(4L);
            vtsVToken.setUID(StreamUtils.readLong(byteArrayInputStream));
            vtsVToken.setTokenType(VtsVTokenType.parse(byteArrayInputStream.read()));
            vtsVToken.setVersion(ByteUtils.byteToInt((byte) byteArrayInputStream.read()));
            short s = StreamUtils.readShort(byteArrayInputStream);
            vtsVToken.setExpired((s & 1) > 0);
            vtsVToken.setPublic((s & 2) > 0);
            vtsVToken.setSystem((s & 4) > 0);
            vtsVToken.setRequiresGeneration((s & 16) > 0);
            byteArrayInputStream.skip(4L);
            vtsVToken.setSystemType(StreamUtils.readShort(byteArrayInputStream));
            vtsVToken.setSystemSubType(ByteUtils.byteToInt((byte) byteArrayInputStream.read()));
            vtsVToken.setDeviceUID(StreamUtils.readLong(byteArrayInputStream));
            vtsVToken.setObjectUID(StreamUtils.readLong(byteArrayInputStream));
            vtsVToken.setObjectType(VtsObjectType.parse(byteArrayInputStream.read()));
            vtsVToken.setObjectTypeFormat(VtsObjectTypeFormat.parse(byteArrayInputStream.read()));
            vtsVToken.setSignatureCount(StreamUtils.readInt(byteArrayInputStream));
            vtsVToken.setGroupUID(StreamUtils.readInt(byteArrayInputStream));
            vtsVToken.setPayloadSize(StreamUtils.readInt(byteArrayInputStream));
            short s2 = StreamUtils.readShort(byteArrayInputStream);
            byteArrayInputStream.skip(vtsVToken.getPayloadSize() + 2);
            ValidationUtils.assertTrue(byteArrayInputStream.available() >= s2, vtsError, "Expected at least %d bytes, got %d", Integer.valueOf(s2), Integer.valueOf(byteArrayInputStream.available()));
            return s2;
        } catch (Exception e) {
            throw new VtsException(VtsError.COULD_NOT_DESERIALIZE_TOKEN, e);
        }
    }

    private void b(VtsVToken vtsVToken, ByteArrayInputStream byteArrayInputStream) {
        if (vtsVToken.getTokenType() == VtsVTokenType.SNAPSHOT) {
            return;
        }
        ValidationUtils.assertTrue(byteArrayInputStream.available() >= 40, VtsError.COULD_NOT_DESERIALIZE_TOKEN, "Expected at least 40 bytes, got %d", Integer.valueOf(byteArrayInputStream.available()));
        Calendar calendar = Calendar.getInstance();
        calendar.set(2016, 0, 1, 0, 0, 0);
        long time = calendar.getTime().getTime();
        try {
            VtsValidation vtsValidation = new VtsValidation();
            byteArrayInputStream.skip(1L);
            int iByteToInt = ByteUtils.byteToInt((byte) byteArrayInputStream.read());
            vtsValidation.setExpired((iByteToInt & 1) > 0);
            vtsValidation.setValidated((iByteToInt & 2) > 0);
            vtsValidation.setMinutesToGoValid((iByteToInt & 4) > 0);
            vtsValidation.setRidesToGoValid((iByteToInt & 8) > 0);
            int i = StreamUtils.readInt(byteArrayInputStream);
            if (i > 0) {
                vtsValidation.setFirstValidation(new Date((((long) i) * 60000) + time));
            }
            int i2 = StreamUtils.readInt(byteArrayInputStream);
            if (i2 > 0) {
                vtsValidation.setLastValidation(new Date(time + (((long) i2) * 60000)));
            }
            vtsValidation.setContractID(StreamUtils.readLong(byteArrayInputStream));
            vtsValidation.setOperatorID(ByteUtils.byteToInt((byte) byteArrayInputStream.read()));
            vtsValidation.setClassID(VtsVTokenClassID.parse(ByteUtils.byteToInt((byte) byteArrayInputStream.read())));
            vtsValidation.setEquipmentID(StreamUtils.readShort(byteArrayInputStream));
            vtsValidation.setRideID(StreamUtils.readInt(byteArrayInputStream));
            vtsValidation.setNodeID(StreamUtils.readInt(byteArrayInputStream));
            vtsValidation.setStopID(StreamUtils.readInt(byteArrayInputStream));
            vtsValidation.setMinutesToGo(StreamUtils.readShort(byteArrayInputStream));
            vtsValidation.setRidesToGo(ByteUtils.byteToInt((byte) byteArrayInputStream.read()));
            vtsVToken.setValidation(vtsValidation);
        } catch (IOException e) {
            throw new VtsException(VtsError.COULD_NOT_DESERIALIZE_TOKEN, e);
        }
    }

    public VtsVToken parseToken(byte[] bArr) throws VtsException {
        ValidationUtils.assertNonNull(bArr, VtsError.COULD_NOT_DESERIALIZE_TOKEN, "Data cannot be null", new Object[0]);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            VtsVToken vtsVToken = new VtsVToken();
            if (a(vtsVToken, byteArrayInputStream) > 0) {
                b(vtsVToken, byteArrayInputStream);
            }
            return vtsVToken;
        } finally {
            StreamUtils.closeSilently(byteArrayInputStream);
        }
    }
}
