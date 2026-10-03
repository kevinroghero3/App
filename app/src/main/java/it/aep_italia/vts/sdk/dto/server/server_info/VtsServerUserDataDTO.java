package it.aep_italia.vts.sdk.dto.server.server_info;

import it.aep_italia.vts.sdk.dto.utils.VtsUserDataDTO;
import it.aep_italia.vts.sdk.utils.DateUtils;
import it.aep_italia.vts.sdk.utils.StringUtils;
import org.simpleframework.xml.Attribute;

/* JADX INFO: loaded from: classes6.dex */
public class VtsServerUserDataDTO {

    @Attribute(name = "HolderId", required = false)
    private String a;

    @Attribute(name = "FirstName", required = false)
    private String b;

    @Attribute(name = "LastName", required = false)
    private String c;

    @Attribute(name = "BirthDate", required = false)
    private String d;

    @Attribute(name = "PhoneNumber", required = false)
    private String e;

    @Attribute(name = "Sex", required = false)
    private String f;

    @Attribute(name = "FiscalCode", required = false)
    private String g;

    @Attribute(name = "EMail", required = false)
    private String h;

    @Attribute(name = "PhotoImage", required = false)
    private String i;

    @Attribute(name = "UserPassword", required = false)
    private String j;

    @Attribute(name = "UserId", required = false)
    private String k;

    public VtsServerUserDataDTO() {
    }

    public VtsServerUserDataDTO(VtsUserDataDTO vtsUserDataDTO) {
        if (vtsUserDataDTO == null) {
            return;
        }
        setFirstName(vtsUserDataDTO.getFirstName());
        setLastName(vtsUserDataDTO.getLastName());
        setBirthDate(DateUtils.toServerDateString(vtsUserDataDTO.getBirthDate()));
        setPhoneNumber(vtsUserDataDTO.getPhoneNumber());
        if (vtsUserDataDTO.getSex() != null) {
            setSex(vtsUserDataDTO.getSex().value());
        }
        setFiscalCode(vtsUserDataDTO.getFiscalCode());
        setEmail(vtsUserDataDTO.getEmail());
        setUserPassword(vtsUserDataDTO.getUserPassword());
        setHolderID(vtsUserDataDTO.getHolderID());
        setUserId(vtsUserDataDTO.getUserId());
        setUserPassword(vtsUserDataDTO.getUserPassword());
        setPhotoImage("JPG");
    }

    public String getBirthDate() {
        return this.d;
    }

    public String getEmail() {
        return this.h;
    }

    public String getFirstName() {
        return this.b;
    }

    public String getFiscalCode() {
        return this.g;
    }

    public String getHolderID() {
        return this.a;
    }

    public String getLastName() {
        return this.c;
    }

    public String getPhoneNumber() {
        return this.e;
    }

    public String getPhotoImage() {
        return this.i;
    }

    public String getSex() {
        return this.f;
    }

    public String getUserId() {
        return this.k;
    }

    public String getUserPassword() {
        return this.j;
    }

    public void setBirthDate(String str) {
        this.d = str;
    }

    public void setEmail(String str) {
        this.h = str;
    }

    public void setFirstName(String str) {
        this.b = str;
    }

    public void setFiscalCode(String str) {
        this.g = str;
    }

    public void setHolderID(String str) {
        this.a = str;
    }

    public void setLastName(String str) {
        this.c = str;
    }

    public void setPhoneNumber(String str) {
        this.e = str;
    }

    public void setPhotoImage(String str) {
        this.i = str;
    }

    public void setSex(String str) {
        this.f = str;
    }

    public void setUserId(String str) {
        this.k = str;
    }

    public void setUserPassword(String str) {
        this.j = str;
    }

    public VtsUserDataDTO toUserDataDTO() {
        VtsUserDataDTO vtsUserDataDTO = new VtsUserDataDTO();
        if (!StringUtils.isBlank(this.b)) {
            vtsUserDataDTO.setFirstName(this.b);
        }
        if (!StringUtils.isBlank(this.c)) {
            vtsUserDataDTO.setLastName(this.c);
        }
        if (!StringUtils.isBlank(this.d)) {
            vtsUserDataDTO.setBirthDate(DateUtils.fromServerDateString(this.d));
        }
        if (!StringUtils.isBlank(this.e)) {
            vtsUserDataDTO.setPhoneNumber(this.e);
        }
        if (!StringUtils.isBlank(this.f)) {
            vtsUserDataDTO.setSex(VtsUserDataDTO.Gender.parse(this.f));
        }
        if (!StringUtils.isBlank(this.g)) {
            vtsUserDataDTO.setFiscalCode(this.g);
        }
        if (!StringUtils.isBlank(this.h)) {
            vtsUserDataDTO.setEmail(this.h);
        }
        if (!StringUtils.isBlank(this.j)) {
            vtsUserDataDTO.setUserPassword(this.j);
        }
        if (!StringUtils.isBlank(this.k)) {
            vtsUserDataDTO.setUserId(this.k);
        }
        if (!StringUtils.isBlank(this.a)) {
            vtsUserDataDTO.setHolderID(this.a);
        }
        return vtsUserDataDTO;
    }
}
