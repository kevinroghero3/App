package it.aep_italia.vts.sdk.dto.utils;

import ch.qos.logback.core.CoreConstants;
import it.aep_italia.vts.sdk.utils.DateUtils;
import java.util.Date;

/* JADX INFO: loaded from: classes6.dex */
public class VtsUserDataDTO {
    public String birthDate;
    public String email;
    public String firstName;
    public String fiscalCode;
    public String holderID;
    public String lastName;
    public String phoneNumber;
    public String sex;
    public String userId;
    public String userPassword;

    public enum Gender {
        MALE("M"),
        FEMALE("F");

        private String value;

        Gender(String str) {
            this.value = str;
        }

        public static Gender parse(String str) {
            for (Gender gender : values()) {
                if (gender.value.equals(str)) {
                    return gender;
                }
            }
            return null;
        }

        public String value() {
            return this.value;
        }
    }

    public Date getBirthDate() {
        return DateUtils.fromServerDateString(this.birthDate);
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

    public String getHolderID() {
        return this.holderID;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public Gender getSex() {
        String str = this.sex;
        if (str == null) {
            return null;
        }
        return Gender.parse(str);
    }

    public String getUserId() {
        return this.userId;
    }

    public String getUserPassword() {
        return this.userPassword;
    }

    public void setBirthDate(Date date) {
        this.birthDate = DateUtils.toServerDateString(date);
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

    public void setHolderID(String str) {
        this.holderID = str;
    }

    public void setLastName(String str) {
        this.lastName = str;
    }

    public void setPhoneNumber(String str) {
        this.phoneNumber = str;
    }

    public void setSex(Gender gender) {
        this.sex = gender == null ? null : gender.value;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public void setUserPassword(String str) {
        this.userPassword = str;
    }

    public String toString() {
        return "VtsUserDataDTO{firstName='" + this.firstName + CoreConstants.SINGLE_QUOTE_CHAR + ", lastName='" + this.lastName + CoreConstants.SINGLE_QUOTE_CHAR + ", birthDate='" + this.birthDate + CoreConstants.SINGLE_QUOTE_CHAR + ", phoneNumber='" + this.phoneNumber + CoreConstants.SINGLE_QUOTE_CHAR + ", sex='" + this.sex + CoreConstants.SINGLE_QUOTE_CHAR + ", fiscalCode='" + this.fiscalCode + CoreConstants.SINGLE_QUOTE_CHAR + ", email='" + this.email + CoreConstants.SINGLE_QUOTE_CHAR + ", password='(omitted)', holderID='" + this.holderID + CoreConstants.SINGLE_QUOTE_CHAR + ", userId='" + this.userId + CoreConstants.SINGLE_QUOTE_CHAR + CoreConstants.CURLY_RIGHT;
    }
}
