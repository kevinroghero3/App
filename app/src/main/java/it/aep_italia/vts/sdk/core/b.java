package it.aep_italia.vts.sdk.core;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.webkit.URLUtil;
import com.google.common.net.HttpHeaders;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.google.firebase.sessions.settings.RemoteSettings;
import it.aep_italia.vts.sdk.VtsSdkConfiguration;
import it.aep_italia.vts.sdk.domain.VtsAuthorizedApp;
import it.aep_italia.vts.sdk.domain.VtsServer;
import it.aep_italia.vts.sdk.dto.soap.VtsSoapReturnCode;
import it.aep_italia.vts.sdk.dto.soap.functions.VtsSoapFunctionPayload;
import it.aep_italia.vts.sdk.dto.soap.requests.VtsSoapCloseSessionRequest;
import it.aep_italia.vts.sdk.dto.soap.requests.VtsSoapInitSessionInput;
import it.aep_italia.vts.sdk.dto.soap.requests.VtsSoapInitSessionRequest;
import it.aep_italia.vts.sdk.dto.soap.requests.VtsSoapRequestFunctionRequest;
import it.aep_italia.vts.sdk.dto.soap.responses.VtsSoapCloseSessionResponse;
import it.aep_italia.vts.sdk.dto.soap.responses.VtsSoapInitSessionResponse;
import it.aep_italia.vts.sdk.dto.soap.responses.VtsSoapRequestFunctionResponse;
import it.aep_italia.vts.sdk.errors.VtsError;
import it.aep_italia.vts.sdk.errors.VtsException;
import it.aep_italia.vts.sdk.internal.database.SharedDatabase;
import it.aep_italia.vts.sdk.internal.database.properties.PropertyDao;
import it.aep_italia.vts.sdk.internal.database.properties.StoredProperty;
import it.aep_italia.vts.sdk.utils.ByteUtils;
import it.aep_italia.vts.sdk.utils.DateUtils;
import it.aep_italia.vts.sdk.utils.DeviceUtils;
import it.aep_italia.vts.sdk.utils.SerializationUtils;
import it.aep_italia.vts.sdk.utils.StreamUtils;
import it.aep_italia.vts.sdk.utils.StringUtils;
import it.aep_italia.vts.sdk.utils.ValidationUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Date;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import org.apache.commons.lang3.CharEncoding;

/* JADX INFO: loaded from: classes6.dex */
final class b {
    private VtsSdk a;
    private String b;
    private String c;
    private URL d;
    private String e;
    private String f;
    private Long g;
    private final Object h = new Object();

    b(VtsConnection vtsConnection) {
        ValidationUtils.assertNonNull(vtsConnection, VtsError.COULD_NOT_INITIALIZE_HANDLER, "No connection provided", new Object[0]);
        this.a = vtsConnection.getSdk();
        a(false);
        ValidationUtils.assertNonBlank(this.b, VtsError.COULD_NOT_RESOLVE_SERVER, "Selected server does not expose any validation connection URI", new Object[0]);
        VtsLog.d("Server URL: %s", this.b);
    }

    private VtsSoapInitSessionInput a() throws VtsException {
        try {
            Context context = this.a.getContext();
            String hexString = Long.toHexString(this.a.getDeviceUID());
            String deviceSubType = DeviceUtils.getDeviceSubType();
            VtsSdkConfiguration sdkConfiguration = this.a.getSdkConfiguration();
            X509Certificate x509CertificateC = c();
            if (VtsLog.isEnabled(VtsLog.Level.INFO)) {
                VtsLog.i("VtsSdk SystemType: %s", Integer.valueOf(this.a.getSystemType()));
                VtsLog.i("VtsSdk SystemSubType: %s", Integer.valueOf(this.a.getSystemSubType()));
                VtsLog.i("VtsSdk DeviceUID: %s", hexString);
                VtsLog.i("VtsSdkConfiguration ApplicationKeyID: %s", sdkConfiguration.getApplicationKeyID());
                VtsLog.i("VtsSdkConfiguration ApplicationName: %s", sdkConfiguration.getApplicationName());
                VtsLog.i("VtsSdkConfiguration ApplicationVersion: %s", sdkConfiguration.getApplicationVersion());
                Object serialNumber = "NO CERTIFICATE";
                VtsLog.i("VtsSdkConfiguration Application Certificate Subject: %s", x509CertificateC == null ? "NO CERTIFICATE" : x509CertificateC.getSubjectDN());
                VtsLog.i("VtsSdkConfiguration Application Certificate Issuer: %s", x509CertificateC == null ? "NO CERTIFICATE" : x509CertificateC.getIssuerDN());
                if (x509CertificateC != null) {
                    serialNumber = x509CertificateC.getSerialNumber();
                }
                VtsLog.i("VtsSdkConfiguration Application Certificate Serial Number: %s", serialNumber);
            }
            VtsSoapInitSessionInput vtsSoapInitSessionInput = new VtsSoapInitSessionInput(this.a.getSystemType(), this.a.getSystemSubType(), hexString, deviceSubType, x509CertificateC);
            vtsSoapInitSessionInput.setIdleTimeoutSec(this.a.getSdkConfiguration().getSessionIdleTimeout());
            vtsSoapInitSessionInput.setImei(DeviceUtils.getIMEI(context));
            vtsSoapInitSessionInput.setImsi(DeviceUtils.getIMSI(context));
            vtsSoapInitSessionInput.setLocalIpv4Address(DeviceUtils.getLocalIpv4Address());
            vtsSoapInitSessionInput.setLocalIpv6Address(DeviceUtils.getLocalIpv6Address());
            vtsSoapInitSessionInput.setPhoneNumber(DeviceUtils.getPhoneNumber(context));
            vtsSoapInitSessionInput.setSimid(DeviceUtils.getSIMID(context));
            vtsSoapInitSessionInput.setApplicationKeyID(sdkConfiguration.getApplicationKeyID());
            vtsSoapInitSessionInput.setApplicationName(sdkConfiguration.getApplicationName());
            vtsSoapInitSessionInput.setApplicationVersion(sdkConfiguration.getApplicationVersion());
            vtsSoapInitSessionInput.setApplicationSignature(this.a.a());
            return vtsSoapInitSessionInput;
        } catch (Exception e) {
            throw new VtsException(VtsError.COULD_NOT_INITIALIZE_SESSION, e);
        }
    }

    private <T> T a(Object obj, Class<T> cls) throws Throwable {
        byte[] bArrSerializeToXmlBytes = SerializationUtils.serializeToXmlBytes(obj);
        VtsLog.Level level = VtsLog.Level.TRACE;
        if (VtsLog.isEnabled(level)) {
            VtsLog.t("[%s] Full request body: %s", f(), new String(bArrSerializeToXmlBytes));
        }
        byte[] bArrA = a(bArrSerializeToXmlBytes);
        if (VtsLog.isEnabled(level)) {
            VtsLog.t("[%s] Full response body: %s", f(), new String(bArrA, StandardCharsets.ISO_8859_1).replaceAll("(?s)(DataOutBin>).+?(</[^<>+]*DataOutBin>)", "$1(omitted)$2"));
        }
        return (T) SerializationUtils.deserializeFromXml(bArrA, (Class) cls);
    }

    private String a(String str) throws Exception {
        if (StringUtils.isBlank(str)) {
            return null;
        }
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(this.e.getBytes(Charset.forName(CharEncoding.ISO_8859_1)));
        return ByteUtils.bytesToHexString(messageDigest.digest(), "");
    }

    private X509Certificate a(HttpsURLConnection httpsURLConnection) {
        if (httpsURLConnection == null) {
            return null;
        }
        try {
            return (X509Certificate) httpsURLConnection.getServerCertificates()[0];
        } catch (SSLPeerUnverifiedException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void a(int i) {
        PropertyDao propertyDao = SharedDatabase.getInstance(this.a).propertyDao();
        StoredProperty property = propertyDao.getProperty(StoredProperty.DOWNLOAD_COUNTER);
        if (property == null) {
            property = new StoredProperty(StoredProperty.DOWNLOAD_COUNTER, 0L);
        }
        long value = property.getLastUpdated() >= DateUtils.getLastLocalMidnight() ? property.getValue() : 0L;
        double d = value / 1048576.0d;
        long j = value + ((long) i);
        VtsLog.v("[%s] Updating daily data download counter from %.2f to %.2f MB (+%d bytes)...", f(), Double.valueOf(d), Double.valueOf(j / 1048576.0d), Integer.valueOf(i));
        property.setValueAndUpdate(j);
        propertyDao.putValue(property);
    }

    private void a(boolean z) {
        VtsServer currentServer = this.a.getCurrentServer();
        VtsSdkConfiguration sdkConfiguration = this.a.getSdkConfiguration();
        boolean z2 = false;
        for (VtsAuthorizedApp vtsAuthorizedApp : currentServer.getAuthorizedApps()) {
            if (vtsAuthorizedApp.getApplicationKeyId().equals(sdkConfiguration.getApplicationKeyID()) && vtsAuthorizedApp.isConnectEnable()) {
                VtsLog.d("[%s] authorized to connect.", vtsAuthorizedApp.getApplicationKeyId());
                z2 = true;
            }
        }
        if (!z2) {
            throw new VtsException(VtsError.INVALID_CONFIGURATION, "Unable to connect to this server.", new Object[0]);
        }
        String serverUriSSL = !z ? currentServer.getServerUriSSL() : null;
        if (StringUtils.isBlank(serverUriSSL)) {
            serverUriSSL = currentServer.getServerUri();
        }
        this.c = currentServer.getServerURISSLCertCN();
        if (StringUtils.isBlank(serverUriSSL)) {
            return;
        }
        try {
            this.b = serverUriSSL;
            this.d = new URL(this.b);
        } catch (MalformedURLException e) {
            throw new VtsException(VtsError.INVALID_CONFIGURATION, e);
        }
    }

    private static byte[] a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[65535];
        while (true) {
            int i = inputStream.read(bArr);
            if (i == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, i);
        }
    }

    /* JADX WARN: Code duplicated, block: B:51:0x014e A[Catch: all -> 0x01a8, TryCatch #2 {all -> 0x01a8, blocks: (B:49:0x0139, B:51:0x014e, B:53:0x0159, B:54:0x0173, B:58:0x018d, B:57:0x0186, B:61:0x0198, B:62:0x019f, B:63:0x01a0, B:64:0x01a7), top: B:70:0x0139, inners: #9 }] */
    /* JADX WARN: Code duplicated, block: B:53:0x0159 A[Catch: all -> 0x01a8, TRY_LEAVE, TryCatch #2 {all -> 0x01a8, blocks: (B:49:0x0139, B:51:0x014e, B:53:0x0159, B:54:0x0173, B:58:0x018d, B:57:0x0186, B:61:0x0198, B:62:0x019f, B:63:0x01a0, B:64:0x01a7), top: B:70:0x0139, inners: #9 }] */
    /* JADX WARN: Code duplicated, block: B:61:0x0198 A[Catch: all -> 0x01a8, TRY_ENTER, TryCatch #2 {all -> 0x01a8, blocks: (B:49:0x0139, B:51:0x014e, B:53:0x0159, B:54:0x0173, B:58:0x018d, B:57:0x0186, B:61:0x0198, B:62:0x019f, B:63:0x01a0, B:64:0x01a7), top: B:70:0x0139, inners: #9 }] */
    /* JADX WARN: Code duplicated, block: B:63:0x01a0 A[Catch: all -> 0x01a8, TryCatch #2 {all -> 0x01a8, blocks: (B:49:0x0139, B:51:0x014e, B:53:0x0159, B:54:0x0173, B:58:0x018d, B:57:0x0186, B:61:0x0198, B:62:0x019f, B:63:0x01a0, B:64:0x01a7), top: B:70:0x0139, inners: #9 }] */
    /* JADX WARN: Not initialized variable reg: 5, insn: 0x0130: MOVE (r3 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]), block:B:42:0x012f */
    private byte[] a(byte[] bArr) throws Throwable {
        OutputStream outputStream;
        String str;
        X509Certificate x509CertificateA;
        boolean zIsOnWiFiNetwork = DeviceUtils.isOnWiFiNetwork(this.a.getContext());
        OutputStream outputStream2 = null;
        InputStream inputStream = null;
        outputStream2 = null;
        try {
            try {
                VtsLog.d("Opening HTTP connection… URL='%s'", this.d.toString());
                HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(this.d.openConnection()));
                VtsLog.d("HTTP Connection successfully opened", new Object[0]);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setConnectTimeout(this.a.getSdkConfiguration().getConnectTimeout());
                httpURLConnection.setReadTimeout(this.a.getSdkConfiguration().getReadTimeout());
                httpURLConnection.setFixedLengthStreamingMode(bArr.length);
                httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, "application/soap+xml");
                httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT_ENCODING, "gzip, identity");
                httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT_CHARSET, "utf-8");
                OutputStream outputStream3 = httpURLConnection.getOutputStream();
                try {
                    try {
                        if ((httpURLConnection instanceof HttpsURLConnection) && (x509CertificateA = a((HttpsURLConnection) httpURLConnection)) != null) {
                            String name = x509CertificateA.getSubjectX500Principal().getName();
                            String str2 = this.c;
                            if (str2 != null && !name.contains(str2)) {
                                VtsLog.e("[ %s ] authorized connection with ssl certificate.", name);
                                throw new VtsException(VtsError.SSL_CERT_CN_ERROR, "SSL MISMATCH CERTIFICATE", new Object[0]);
                            }
                        }
                        outputStream3.write(bArr);
                        StreamUtils.closeSilently(outputStream3);
                        InputStream errorStream = httpURLConnection.getErrorStream();
                        if (errorStream == null) {
                            errorStream = httpURLConnection.getInputStream();
                        } else {
                            try {
                                VtsLog.e("HTTP Error during call. HttpResponseCode=%d, HttpResponseSize=%d, HttpResponseMsg=’%s’, ErrorStreamBase64=’%s’", Integer.valueOf(httpURLConnection.getResponseCode()), Integer.valueOf(httpURLConnection.getContentLength()), httpURLConnection.getResponseMessage(), SerializationUtils.toBase64String(a(errorStream)));
                            } catch (IOException e) {
                                throw e;
                            }
                        }
                        byte[] bArrExtractAllAndClose = StreamUtils.extractAllAndClose(errorStream);
                        VtsLog.i("HTTP Call executed. HttpResponseCode=%d, HttpResponseSize=%d, HttpResponseMsg=’%s’", Integer.valueOf(httpURLConnection.getResponseCode()), Integer.valueOf(httpURLConnection.getContentLength()), httpURLConnection.getResponseMessage());
                        if (!zIsOnWiFiNetwork) {
                            a(httpURLConnection.getContentLength());
                        }
                        StreamUtils.closeSilently(outputStream3);
                        StreamUtils.closeSilently(errorStream);
                        return bArrExtractAllAndClose;
                    } catch (SocketException | SocketTimeoutException | SSLHandshakeException e2) {
                        e = e2;
                        outputStream2 = outputStream3;
                        try {
                            VtsLog.e(e, "[ Connection Exception ] - %s", e.getLocalizedMessage());
                            str = this.b;
                            if (URLUtil.isHttpsUrl(str)) {
                                throw new VtsException(VtsError.REQUEST_FAILED, e);
                            }
                            a(true);
                            if (!URLUtil.isHttpsUrl(this.b)) {
                                throw new VtsException(VtsError.REQUEST_FAILED, e);
                            }
                            VtsLog.e(e, "[%s] Request attempt failed", f());
                            VtsLog.i("[%s] Request on the VTS Server's SSL endpoint failed, falling back to the plaintext endpoint...", f());
                            try {
                                Charset charset = StandardCharsets.UTF_8;
                                bArr = new String(bArr, charset).replace(str, this.b).getBytes(charset);
                            } catch (Exception e3) {
                                VtsLog.e(e3, "Could not replace WS addressing URL", new Object[0]);
                            }
                            byte[] bArrA = a(bArr);
                            StreamUtils.closeSilently(outputStream2);
                            StreamUtils.closeSilently((InputStream) 0);
                            return bArrA;
                        } catch (Throwable th) {
                            th = th;
                            StreamUtils.closeSilently(outputStream2);
                            StreamUtils.closeSilently(inputStream);
                            throw th;
                        }
                    }
                } catch (Exception e4) {
                    e = e4;
                    throw new VtsException(VtsError.REQUEST_FAILED, e);
                }
            } catch (SocketException e5) {
                e = e5;
                VtsLog.e(e, "[ Connection Exception ] - %s", e.getLocalizedMessage());
                str = this.b;
                if (URLUtil.isHttpsUrl(str)) {
                    throw new VtsException(VtsError.REQUEST_FAILED, e);
                }
                a(true);
                if (!URLUtil.isHttpsUrl(this.b)) {
                    throw new VtsException(VtsError.REQUEST_FAILED, e);
                }
                VtsLog.e(e, "[%s] Request attempt failed", f());
                VtsLog.i("[%s] Request on the VTS Server's SSL endpoint failed, falling back to the plaintext endpoint...", f());
                Charset charset2 = StandardCharsets.UTF_8;
                bArr = new String(bArr, charset2).replace(str, this.b).getBytes(charset2);
                byte[] bArrA2 = a(bArr);
                StreamUtils.closeSilently(outputStream2);
                StreamUtils.closeSilently((InputStream) 0);
                return bArrA2;
            } catch (SocketTimeoutException e6) {
                e = e6;
                VtsLog.e(e, "[ Connection Exception ] - %s", e.getLocalizedMessage());
                str = this.b;
                if (URLUtil.isHttpsUrl(str)) {
                    throw new VtsException(VtsError.REQUEST_FAILED, e);
                }
                a(true);
                if (!URLUtil.isHttpsUrl(this.b)) {
                    throw new VtsException(VtsError.REQUEST_FAILED, e);
                }
                VtsLog.e(e, "[%s] Request attempt failed", f());
                VtsLog.i("[%s] Request on the VTS Server's SSL endpoint failed, falling back to the plaintext endpoint...", f());
                Charset charset3 = StandardCharsets.UTF_8;
                bArr = new String(bArr, charset3).replace(str, this.b).getBytes(charset3);
                byte[] bArrA3 = a(bArr);
                StreamUtils.closeSilently(outputStream2);
                StreamUtils.closeSilently((InputStream) 0);
                return bArrA3;
            } catch (SSLHandshakeException e7) {
                e = e7;
                VtsLog.e(e, "[ Connection Exception ] - %s", e.getLocalizedMessage());
                str = this.b;
                if (URLUtil.isHttpsUrl(str)) {
                    throw new VtsException(VtsError.REQUEST_FAILED, e);
                }
                a(true);
                if (!URLUtil.isHttpsUrl(this.b)) {
                    throw new VtsException(VtsError.REQUEST_FAILED, e);
                }
                VtsLog.e(e, "[%s] Request attempt failed", f());
                VtsLog.i("[%s] Request on the VTS Server's SSL endpoint failed, falling back to the plaintext endpoint...", f());
                Charset charset4 = StandardCharsets.UTF_8;
                bArr = new String(bArr, charset4).replace(str, this.b).getBytes(charset4);
                byte[] bArrA4 = a(bArr);
                StreamUtils.closeSilently(outputStream2);
                StreamUtils.closeSilently((InputStream) 0);
                return bArrA4;
            } catch (Exception e8) {
                e = e8;
            } catch (Throwable th2) {
                th = th2;
                inputStream = null;
                StreamUtils.closeSilently(outputStream2);
                StreamUtils.closeSilently(inputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
            outputStream2 = outputStream;
            StreamUtils.closeSilently(outputStream2);
            StreamUtils.closeSilently(inputStream);
            throw th;
        }
    }

    private X509Certificate c() throws PackageManager.NameNotFoundException {
        PackageInfo packageInfo = this.a.getContext().getPackageManager().getPackageInfo(this.a.getContext().getPackageName(), 64);
        this.a.getContext().getPackageManager().getInstalledPackages(64);
        if (VtsLog.isEnabled(VtsLog.Level.INFO)) {
            VtsLog.i("VtsSdkConfiguration PackageName: %s", packageInfo.packageName);
        }
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr.length <= 0) {
            return null;
        }
        try {
            return (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(signatureArr[0].toByteArray()));
        } catch (CertificateException unused) {
            return null;
        }
    }

    private int d() {
        return this.a.getSdkConfiguration().getSessionIdleTimeout() * 1000;
    }

    private VtsSoapInitSessionResponse g() throws VtsException {
        VtsSoapInitSessionResponse vtsSoapInitSessionResponse;
        synchronized (this) {
            VtsLog.d("Starting new InitSession request...", new Object[0]);
            try {
                VtsSoapInitSessionInput vtsSoapInitSessionInputA = a();
                if (VtsLog.isEnabled(VtsLog.Level.INFO)) {
                    VtsLog.i("InitSession request start DataInXml: %s", SerializationUtils.serializeToXmlBase64(vtsSoapInitSessionInputA));
                }
                vtsSoapInitSessionResponse = (VtsSoapInitSessionResponse) a(new VtsSoapInitSessionRequest(this.b, vtsSoapInitSessionInputA), VtsSoapInitSessionResponse.class);
                if (vtsSoapInitSessionResponse == null) {
                    VtsLog.w("Session initialization request returned null response, aborting.", new Object[0]);
                    throw new IOException("Null response");
                }
                if (vtsSoapInitSessionResponse.getReturnCode() == null || vtsSoapInitSessionResponse.getReturnCode().intValue() != 0 || vtsSoapInitSessionResponse.getSessionID() == null) {
                    VtsLog.w("Session initialization request failed, aborting: " + vtsSoapInitSessionResponse.getErrorString(), new Object[0]);
                    throw new IOException("Could not initialize session: " + vtsSoapInitSessionResponse.getErrorString());
                }
                this.e = vtsSoapInitSessionResponse.getSessionID();
                this.g = Long.valueOf(new Date().getTime() + ((long) d()));
                String strA = a(vtsSoapInitSessionResponse.getSessionID());
                if (strA == null) {
                    this.f = null;
                } else {
                    this.f = strA.substring(0, 4) + RemoteSettings.FORWARD_SLASH_STRING + this.a.b().getAndAdd(1);
                }
                VtsLog.d("InitSession completed successfully. Received the following session ID: %s", this.e);
                VtsLog.v("SessionID MD5: " + this.f, new Object[0]);
            } catch (Exception e) {
                VtsLog.e(e, "InitSession request failed.", new Object[0]);
                throw new VtsException(VtsError.COULD_NOT_INITIALIZE_SESSION, e);
            }
        }
        return vtsSoapInitSessionResponse;
    }

    private void h() {
        synchronized (this) {
            if (!j()) {
                if (this.e != null) {
                    VtsLog.d("[%s] Previous session has expired, initiating a new session.", f());
                }
                g();
            }
        }
    }

    private boolean j() {
        Long l;
        return (this.e == null || (l = this.g) == null || l.longValue() < new Date().getTime() + 5000) ? false : true;
    }

    VtsSoapRequestFunctionResponse a(VtsSoapFunctionPayload vtsSoapFunctionPayload, byte[] bArr) throws VtsException {
        VtsSoapRequestFunctionResponse vtsSoapRequestFunctionResponse;
        synchronized (this.h) {
            ValidationUtils.assertNonNull(vtsSoapFunctionPayload, VtsError.COULD_NOT_REQUEST_FUNCTION, "Payload cannot be null", new Object[0]);
            h();
            VtsLog.d("[%s] Starting new RequestFunction request (function %s)...", f(), vtsSoapFunctionPayload.getFunctionName());
            try {
                if (VtsLog.isEnabled(VtsLog.Level.INFO)) {
                    VtsLog.i("[%s] %s request start DataInXml: %s", f(), vtsSoapFunctionPayload.getFunctionName(), SerializationUtils.serializeToXmlBase64(vtsSoapFunctionPayload));
                }
                vtsSoapRequestFunctionResponse = (VtsSoapRequestFunctionResponse) a(new VtsSoapRequestFunctionRequest(this.b, this.e, vtsSoapFunctionPayload, bArr), VtsSoapRequestFunctionResponse.class);
                this.g = Long.valueOf(new Date().getTime() + ((long) d()));
                VtsLog.d("[%s] RequestFunction request completed (function %s).", f(), vtsSoapFunctionPayload.getFunctionName());
                if (vtsSoapRequestFunctionResponse.getReturnCode().intValue() == VtsSoapReturnCode.INVALID_SESSION.value()) {
                    this.g = Long.valueOf(new Date().getTime() - 10000);
                }
            } catch (Exception e) {
                VtsLog.e(e, "[%s] RequestFunction request failed.", f());
                throw new VtsException(VtsError.COULD_NOT_INITIALIZE_SESSION, e);
            }
        }
        return vtsSoapRequestFunctionResponse;
    }

    VtsSoapCloseSessionResponse b() throws VtsException {
        synchronized (this) {
            try {
                try {
                    if (this.e == null) {
                        this.e = null;
                        this.g = null;
                        return null;
                    }
                    VtsLog.d("[%s] Starting new CloseSession request...", f());
                    VtsLog.d("[%s] Using the following SessionID: %s", f(), this.e);
                    VtsSoapCloseSessionResponse vtsSoapCloseSessionResponse = (VtsSoapCloseSessionResponse) a(new VtsSoapCloseSessionRequest(this.b, this.e), VtsSoapCloseSessionResponse.class);
                    VtsLog.d("[%s] CloseSession request completed.", f());
                    this.e = null;
                    this.g = null;
                    return vtsSoapCloseSessionResponse;
                } catch (Exception e) {
                    VtsLog.e(e, "[%s] CloseSession request failed.", f());
                    throw new VtsException(VtsError.COULD_NOT_CLOSE_SESSION, e);
                }
            } catch (Throwable th) {
                this.e = null;
                this.g = null;
                throw th;
            }
            this.e = null;
            this.g = null;
            throw th;
        }
    }

    String e() {
        return this.e;
    }

    String f() {
        String str = this.f;
        if (str == null) {
            str = RemoteSettings.FORWARD_SLASH_STRING;
        }
        return str + RemoteSettings.FORWARD_SLASH_STRING + Thread.currentThread().getId();
    }

    boolean i() {
        return (this.g == null || j()) ? false : true;
    }
}
