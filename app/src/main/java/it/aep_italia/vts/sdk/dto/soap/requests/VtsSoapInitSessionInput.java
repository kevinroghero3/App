package it.aep_italia.vts.sdk.dto.soap.requests;

import it.aep_italia.vts.sdk.core.VtsSdk;
import it.aep_italia.vts.sdk.dto.soap.VtsSoapEnvelope;
import it.aep_italia.vts.sdk.errors.VtsError;
import it.aep_italia.vts.sdk.errors.VtsException;
import it.aep_italia.vts.sdk.utils.ValidationUtils;
import java.security.cert.X509Certificate;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

/* JADX INFO: loaded from: classes6.dex */
@NamespaceList({@Namespace(prefix = "vts", reference = VtsSoapEnvelope.NAMESPACE_AEP)})
@Root(name = "vts:VTS_InitSessionInput")
public class VtsSoapInitSessionInput {

    @Attribute(name = "SystemType")
    @Path("vts:Body/vts:ConnectionRequest")
    private int b;

    @Attribute(name = "SystemSubType")
    @Path("vts:Body/vts:ConnectionRequest")
    private int c;

    @Attribute(name = "DeviceSubType")
    @Path("vts:Body/vts:DeviceInfo")
    private String f;

    @Attribute(name = "DeviceUID")
    @Path("vts:Body/vts:DeviceInfo")
    private String g;

    @Attribute(name = "IMEI", required = false)
    @Path("vts:Body/vts:DeviceInfo")
    private String h;

    @Attribute(name = "IMSI", required = false)
    @Path("vts:Body/vts:DeviceInfo")
    private String i;

    @Attribute(name = "SIMID", required = false)
    @Path("vts:Body/vts:DeviceInfo")
    private String j;

    @Attribute(name = "PhoneNumber", required = false)
    @Path("vts:Body/vts:DeviceInfo")
    private String k;

    @Attribute(name = "LocalIpv4Address", required = false)
    @Path("vts:Body/vts:DeviceInfo")
    private String l;

    @Attribute(name = "LocalIpv6Address", required = false)
    @Path("vts:Body/vts:DeviceInfo")
    private String m;

    @Attribute(name = "ApplicationKeyId")
    @Path("vts:Body/vts:ApplicationInfo")
    private String r;

    @Attribute(name = "ApplicationName")
    @Path("vts:Body/vts:ApplicationInfo")
    private String s;

    @Attribute(name = "ApplicationVersion")
    @Path("vts:Body/vts:ApplicationInfo")
    private String t;

    @Attribute(name = "ApplicationSignature")
    @Path("vts:Body/vts:ApplicationInfo")
    private String u;

    @Attribute(name = "Version")
    @Path("vts:Header")
    private int a = 1;

    @Attribute(name = "DeviceClass")
    @Path("vts:Body/vts:ConnectionRequest")
    private String d = "SMART";

    @Attribute(name = "DeviceType")
    @Path("vts:Body/vts:DeviceInfo")
    private String e = "SMART";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Attribute(name = "AuthenticationScheme")
    @Path("vts:Body/vts:Authentication")
    private final String f142n = "none";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Attribute(name = "IdleTimeoutSec")
    @Path("vts:Body/vts:ClientPreferences")
    private int f143o = 60;

    @Attribute(name = "UserLangType")
    @Path("vts:Body/vts:ClientPreferences")
    private final String p = "IT";

    @Attribute(name = "ErrorMsgLangType")
    @Path("vts:Body/vts:ClientPreferences")
    private String q = "IT";

    @Attribute(name = "SdkVersion")
    @Path("vts:Body/vts:ApplicationInfo")
    private String v = VtsSdk.SDK_VERSION.getFullString();

    @Attribute(name = "ApplicationSignatureSubjectDN")
    @Path("vts:Body/vts:ApplicationInfo")
    private String w = "";

    @Attribute(name = "ApplicationSignatureIssuerDN")
    @Path("vts:Body/vts:ApplicationInfo")
    private String x = "";

    @Attribute(name = "ApplicationSignatureSerialNumber")
    @Path("vts:Body/vts:ApplicationInfo")
    private String y = "";

    public VtsSoapInitSessionInput(int i, int i2, String str, String str2, X509Certificate x509Certificate) throws VtsException {
        VtsError vtsError = VtsError.INVALID_PARAMETER;
        ValidationUtils.assertNonBlank(str, vtsError, "DeviceUID cannot be null", new Object[0]);
        ValidationUtils.assertNonBlank(str2, vtsError, "DeviceSubType cannot be null", new Object[0]);
        setSystemType(i);
        setSystemSubType(i2);
        setDeviceUID(str);
        setDeviceSubType(str2);
        setApplicationSignatureSubjectDN(x509Certificate.getSubjectDN().toString());
        setApplicationSignatureIssueDN(x509Certificate.getIssuerDN().toString());
        setApplicationSignatureSerialNumber(x509Certificate.getSerialNumber().toString());
    }

    public String getApplicationKeyID() {
        return this.r;
    }

    public String getApplicationName() {
        return this.s;
    }

    public String getApplicationSignature() {
        return this.u;
    }

    public String getApplicationSignatureIssueDN() {
        return this.x;
    }

    public String getApplicationSignatureSerialNumber() {
        return this.y;
    }

    public String getApplicationSignatureSubjectDN() {
        return this.w;
    }

    public String getApplicationVersion() {
        return this.t;
    }

    public String getAuthenticationScheme() {
        return "none";
    }

    public String getDeviceClass() {
        return this.d;
    }

    public String getDeviceSubType() {
        return this.f;
    }

    public String getDeviceType() {
        return this.e;
    }

    public String getDeviceUID() {
        return this.g;
    }

    public String getErrorMsgLangType() {
        return this.q;
    }

    public int getIdleTimeoutSec() {
        return this.f143o;
    }

    public String getImei() {
        return this.h;
    }

    public String getImsi() {
        return this.i;
    }

    public String getLocalIpv4Address() {
        return this.l;
    }

    public String getLocalIpv6Address() {
        return this.m;
    }

    public String getPhoneNumber() {
        return this.k;
    }

    public String getSimid() {
        return this.j;
    }

    public int getSystemSubType() {
        return this.c;
    }

    public int getSystemType() {
        return this.b;
    }

    public String getUserLangType() {
        return "IT";
    }

    public int getVersion() {
        return this.a;
    }

    public void setApplicationKeyID(String str) {
        this.r = str;
    }

    public void setApplicationName(String str) {
        this.s = str;
    }

    public void setApplicationSignature(String str) {
        this.u = str;
    }

    public void setApplicationSignatureIssueDN(String str) {
        this.x = str;
    }

    public void setApplicationSignatureSerialNumber(String str) {
        this.y = str;
    }

    public void setApplicationSignatureSubjectDN(String str) {
        this.w = str;
    }

    public void setApplicationVersion(String str) {
        this.t = str;
    }

    public void setDeviceSubType(String str) {
        this.f = str;
    }

    public void setDeviceUID(String str) {
        this.g = str;
    }

    public void setIdleTimeoutSec(int i) {
        this.f143o = i;
    }

    public void setImei(String str) {
        this.h = str;
    }

    public void setImsi(String str) {
        this.i = str;
    }

    public void setLocalIpv4Address(String str) {
        this.l = str;
    }

    public void setLocalIpv6Address(String str) {
        this.m = str;
    }

    public void setPhoneNumber(String str) {
        this.k = str;
    }

    public void setSimid(String str) {
        this.j = str;
    }

    public void setSystemSubType(int i) {
        this.c = i;
    }

    public void setSystemType(int i) {
        this.b = i;
    }
}
