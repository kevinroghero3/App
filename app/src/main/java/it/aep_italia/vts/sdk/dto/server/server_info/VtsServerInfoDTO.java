package it.aep_italia.vts.sdk.dto.server.server_info;

import it.aep_italia.vts.sdk.core.VtsLog;
import it.aep_italia.vts.sdk.utils.StringUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Transient;

/* JADX INFO: loaded from: classes6.dex */
public class VtsServerInfoDTO {

    @ElementList(entry = "SdkParameter", name = "SdkParameters", required = false)
    private List<VtsServerNamedValueDTO> a;

    @ElementList(entry = "DeviceStatistic", name = "DeviceStatistics", required = false)
    private List<VtsServerNamedValueDTO> b;

    @Element(name = "UserData", required = false)
    private VtsServerUserDataDTO c;

    @Transient
    private byte[] d;

    private String a(String str, String str2) {
        List<VtsServerNamedValueDTO> list;
        if (!StringUtils.isBlank(str) && (list = this.a) != null && !list.isEmpty()) {
            for (VtsServerNamedValueDTO vtsServerNamedValueDTO : this.a) {
                if (str.equalsIgnoreCase(vtsServerNamedValueDTO.getName())) {
                    return vtsServerNamedValueDTO.getValue();
                }
            }
        }
        return str2;
    }

    public boolean getBooleanParameter(String str, boolean z) {
        String strA = a(str, null);
        if (strA != null) {
            try {
                return Boolean.parseBoolean(strA);
            } catch (Exception unused) {
            }
        }
        VtsLog.v("No boolean SDK parameter with name \"%s\" found.", str);
        return z;
    }

    public List<VtsServerNamedValueDTO> getDeviceStatistics() {
        return this.b;
    }

    public long getHexParameter(String str, long j) {
        String strA = a(str, null);
        if (strA != null) {
            try {
                return StringUtils.unsignedHexStringToSignedLong(strA);
            } catch (Exception unused) {
            }
        }
        VtsLog.v("No hex SDK parameter with name \"%s\" found.", str);
        return j;
    }

    public long getNumericParameter(String str, long j) {
        String strA = a(str, null);
        if (strA != null) {
            try {
                return Long.parseLong(strA, 10);
            } catch (Exception unused) {
            }
        }
        VtsLog.d("No numeric SDK parameter with name \"%s\" found.", str);
        return j;
    }

    public List<VtsServerNamedValueDTO> getSdkParameters() {
        return this.a;
    }

    public Map<String, String> getStatistics() {
        HashMap map = new HashMap();
        List<VtsServerNamedValueDTO> list = this.b;
        if (list != null && !list.isEmpty()) {
            for (VtsServerNamedValueDTO vtsServerNamedValueDTO : this.b) {
                map.put(vtsServerNamedValueDTO.getName(), vtsServerNamedValueDTO.getValue());
            }
        }
        return Collections.unmodifiableMap(map);
    }

    public VtsServerUserDataDTO getUserData() {
        return this.c;
    }

    public byte[] getUserPhoto() {
        return this.d;
    }

    public void setDeviceStatistics(List<VtsServerNamedValueDTO> list) {
        this.b = list;
    }

    public void setSdkParameters(List<VtsServerNamedValueDTO> list) {
        this.a = list;
    }

    public void setUserData(VtsServerUserDataDTO vtsServerUserDataDTO) {
        this.c = vtsServerUserDataDTO;
    }

    public void setUserPhoto(byte[] bArr) {
        this.d = bArr;
    }
}
