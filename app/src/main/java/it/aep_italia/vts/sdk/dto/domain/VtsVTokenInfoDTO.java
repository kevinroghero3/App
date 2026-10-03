package it.aep_italia.vts.sdk.dto.domain;

import ch.qos.logback.core.CoreConstants;
import it.aep_italia.vts.sdk.domain.enums.VtsObjectType;
import it.aep_italia.vts.sdk.domain.enums.VtsObjectTypeFormat;
import it.aep_italia.vts.sdk.domain.enums.VtsVTokenStatus;
import it.aep_italia.vts.sdk.errors.VtsError;
import it.aep_italia.vts.sdk.errors.VtsException;
import it.aep_italia.vts.sdk.utils.DateUtils;
import it.aep_italia.vts.sdk.utils.StringUtils;
import java.io.Serializable;
import java.util.Date;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Transient;

/* JADX INFO: loaded from: classes6.dex */
public class VtsVTokenInfoDTO implements Serializable {
    private static final long serialVersionUID = 7949547935705423375L;

    @Attribute(name = "GroupUID", required = false)
    private Integer groupUID;

    @Attribute(name = "LastVTokenUpdate")
    private String lastVTokenUpdate;

    @Attribute(name = "ObjectType", required = false)
    private Integer objectType;

    @Attribute(name = "ObjectTypeFormat", required = false)
    private Integer objectTypeFormat;

    @Attribute(name = "SignatureCount")
    private int signatureCount;

    @Transient
    private byte[] tokenContents;

    @Attribute(name = "VTokenStatus", required = false)
    private Integer vTokenStatus;

    @Attribute(name = "VTokenUID")
    private String vTokenUID;

    public Integer getGroupUID() {
        return this.groupUID;
    }

    public String getLastVTokenUpdate() {
        return this.lastVTokenUpdate;
    }

    public Date getLastVTokenUpdateAsDate() {
        try {
            return DateUtils.fromServerDateTimeString(this.lastVTokenUpdate);
        } catch (Exception unused) {
            return DateUtils.fromISO8601(this.lastVTokenUpdate);
        }
    }

    public Integer getObjectType() {
        return this.objectType;
    }

    public Integer getObjectTypeFormat() {
        return this.objectTypeFormat;
    }

    public int getSignatureCount() {
        return this.signatureCount;
    }

    public byte[] getTokenContents() {
        return this.tokenContents;
    }

    public Integer getVTokenStatus() {
        return this.vTokenStatus;
    }

    public String getVTokenUID() {
        return this.vTokenUID;
    }

    public long getVTokenUIDAsLong() throws VtsException {
        String str = this.vTokenUID;
        if (str == null) {
            return 0L;
        }
        try {
            return StringUtils.unsignedHexStringToSignedLong(str);
        } catch (Exception e) {
            throw new VtsException(VtsError.INVALID_PARAMETER, e);
        }
    }

    public VtsObjectType getVtsObjectType() throws VtsException {
        Integer num = this.objectType;
        if (num == null) {
            return null;
        }
        try {
            return VtsObjectType.parse(num.intValue());
        } catch (Exception e) {
            throw new VtsException(VtsError.INVALID_PARAMETER, e);
        }
    }

    public VtsObjectTypeFormat getVtsObjectTypeFormat() throws VtsException {
        Integer num = this.objectTypeFormat;
        if (num == null) {
            return null;
        }
        try {
            return VtsObjectTypeFormat.parse(num.intValue());
        } catch (Exception e) {
            throw new VtsException(VtsError.INVALID_PARAMETER, e);
        }
    }

    public VtsVTokenStatus getVtsVTokenStatus() throws VtsException {
        Integer num = this.vTokenStatus;
        if (num == null) {
            return null;
        }
        try {
            return VtsVTokenStatus.parse(num.intValue());
        } catch (Exception e) {
            throw new VtsException(VtsError.INVALID_PARAMETER, e);
        }
    }

    public void setGroupUID(Integer num) {
        this.groupUID = num;
    }

    public void setLastVTokenUpdate(String str) {
        this.lastVTokenUpdate = str;
    }

    public void setObjectType(Integer num) {
        this.objectType = num;
    }

    public void setObjectTypeFormat(Integer num) {
        this.objectTypeFormat = num;
    }

    public void setSignatureCount(int i) {
        this.signatureCount = i;
    }

    public void setTokenContents(byte[] bArr) {
        this.tokenContents = bArr;
    }

    public void setVTokenStatus(Integer num) {
        this.vTokenStatus = num;
    }

    public void setVTokenUID(String str) {
        this.vTokenUID = str;
    }

    public String toString() {
        return "VtsVTokenInfoDTO{vTokenUID='" + this.vTokenUID + CoreConstants.SINGLE_QUOTE_CHAR + ", lastVTokenUpdate='" + this.lastVTokenUpdate + CoreConstants.SINGLE_QUOTE_CHAR + ", signatureCount=" + this.signatureCount + ", objectType=" + this.objectType + ", objectTypeFormat=" + this.objectTypeFormat + ", vTokenStatus=" + this.vTokenStatus + ", groupUID=" + this.groupUID + CoreConstants.CURLY_RIGHT;
    }
}
