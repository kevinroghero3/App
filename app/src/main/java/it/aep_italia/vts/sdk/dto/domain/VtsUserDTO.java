package it.aep_italia.vts.sdk.dto.domain;

import org.simpleframework.xml.Attribute;

/* JADX INFO: loaded from: classes6.dex */
public class VtsUserDTO {

    @Attribute(name = "BirthDate")
    public String birthDate;

    @Attribute(name = "EMail")
    public String email;

    @Attribute(name = "FirstName")
    public String firstName;

    @Attribute(name = "FiscalCode")
    public String fiscalCode;

    @Attribute(name = "HolderId")
    public String holderId;

    @Attribute(name = "LastName")
    public String lastName;

    @Attribute(name = "PhoneNumber")
    public String phoneNumber;

    @Attribute(name = "PhotoImage")
    public String photoImage;

    @Attribute(name = "PhotoImageSize")
    public String photoImageSize;

    @Attribute(name = "Sex")
    public String sex;

    @Attribute(name = "UserId")
    public int userId;

    @Attribute(name = "UserPassword")
    public String userPassword;

    public String getBirthDate() {
        return this.birthDate;
    }

    public String getEmail() {
        return this.email;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getFiscalCode() {
        return this.fiscalCode;
    }

    public String getHolderId() {
        return this.holderId;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getPhotoImage() {
        return this.photoImage;
    }

    public String getPhotoImageSize() {
        return this.photoImageSize;
    }

    public String getSex() {
        return this.sex;
    }

    public int getUserId() {
        return this.userId;
    }

    public String getUserPassword() {
        return this.userPassword;
    }

    public void setBirthDate(String str) {
        this.birthDate = str;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public void setFirstName(String str) {
        this.firstName = str;
    }

    public void setFiscalCode(String str) {
        this.fiscalCode = str;
    }

    public void setHolderId(String str) {
        this.holderId = str;
    }

    public void setLastName(String str) {
        this.lastName = str;
    }

    public void setPhoneNumber(String str) {
        this.phoneNumber = str;
    }

    public void setPhotoImage(String str) {
        this.photoImage = str;
    }

    public void setPhotoImageSize(String str) {
        this.photoImageSize = str;
    }

    public void setSex(String str) {
        this.sex = str;
    }

    public void setUserId(int i) {
        this.userId = i;
    }

    public void setUserPassword(String str) {
        this.userPassword = str;
    }
}
