package it.aep_italia.vts.sdk.dto.domain.token;

import org.simpleframework.xml.Attribute;

/* JADX INFO: loaded from: classes6.dex */
public class VtsVTokenHeaderDTO {

    @Attribute(name = "TokenType")
    private int a;

    @Attribute(name = "Attribute")
    private int b;

    @Attribute(name = "SignatureType")
    private int c;

    @Attribute(name = "SignatureKeyId")
    private int d;

    @Attribute(name = "EncryptionType")
    private int e;

    @Attribute(name = "EncryptionKeyId")
    private int f;

    @Attribute(name = "SystemType")
    private int g;

    @Attribute(name = "SystemSubType")
    private int h;

    @Attribute(name = "TokenUid")
    private String i;

    @Attribute(name = "ObjectUid")
    private String j;

    @Attribute(name = "DeviceUid")
    private String k;

    @Attribute(name = "GroupUid")
    private String l;

    @Attribute(name = "ObjectType")
    private int m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Attribute(name = "ObjectTypeFormat")
    private int f134n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Attribute(name = "SignatureCount")
    private int f135o;

    public int getAttributes() {
        return this.b;
    }

    public String getDeviceUID() {
        return this.k;
    }

    public int getEncryptionKeyID() {
        return this.f;
    }

    public int getEncryptionType() {
        return this.e;
    }

    public String getGroupUID() {
        return this.l;
    }

    public int getObjectType() {
        return this.m;
    }

    public int getObjectTypeFormat() {
        return this.f134n;
    }

    public String getObjectUID() {
        return this.j;
    }

    public int getSignatureCount() {
        return this.f135o;
    }

    public int getSignatureKeyID() {
        return this.d;
    }

    public int getSignatureType() {
        return this.c;
    }

    public int getSystemSubType() {
        return this.h;
    }

    public int getSystemType() {
        return this.g;
    }

    public int getTokenType() {
        return this.a;
    }

    public String getTokenUID() {
        return this.i;
    }

    public void setAttributes(int i) {
        this.b = i;
    }

    public void setDeviceUID(String str) {
        this.k = str;
    }

    public void setEncryptionKeyID(int i) {
        this.f = i;
    }

    public void setEncryptionType(int i) {
        this.e = i;
    }

    public void setGroupUID(String str) {
        this.l = str;
    }

    public void setObjectType(int i) {
        this.m = i;
    }

    public void setObjectTypeFormat(int i) {
        this.f134n = i;
    }

    public void setObjectUID(String str) {
        this.j = str;
    }

    public void setSignatureCount(int i) {
        this.f135o = i;
    }

    public void setSignatureKeyID(int i) {
        this.d = i;
    }

    public void setSignatureType(int i) {
        this.c = i;
    }

    public void setSystemSubType(int i) {
        this.h = i;
    }

    public void setSystemType(int i) {
        this.g = i;
    }

    public void setTokenType(int i) {
        this.a = i;
    }

    public void setTokenUID(String str) {
        this.i = str;
    }
}
