package it.aep_italia.vts.sdk;

import android.content.Context;
import it.aep_italia.vts.sdk.errors.VtsError;
import it.aep_italia.vts.sdk.errors.VtsException;
import it.aep_italia.vts.sdk.utils.SerializationUtils;
import it.aep_italia.vts.sdk.utils.StreamUtils;
import java.io.InputStream;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/* JADX INFO: loaded from: classes6.dex */
@Root(name = "VtsSdkConfig")
public class VtsSdkConfiguration {

    @Element(name = "ApplicationKeyID")
    private String a;

    @Element(name = "ApplicationName")
    private String b;

    @Element(name = "ApplicationVersion")
    private String c;

    @Element(name = "ConnectTimeout")
    private int d;

    @Element(name = "ReadTimeout")
    private int e;

    @Element(name = "SessionIdleTimeout")
    private int f;

    @Element(name = "UserLangType")
    private String g;

    @Element(name = "ErrorMessageLangType")
    private String h;

    @Element(name = "SynchronizationDisabled")
    private boolean i;

    @Element(name = "SynchronizationRetryDelay")
    private int j;

    @Element(name = "SynchronizeUseExactTimes")
    private boolean k;

    @Element(name = "SynchronizeImagesReceiptsOnWiFiOnly")
    private boolean l;

    @Element(name = "MobileSyncDailyLimit")
    private int m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Element(name = "DataOnExternal")
    private boolean f127n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Element(name = "ImagesCleanupDisabled")
    private boolean f128o;

    @Element(name = "ImagesCleanupSpaceThreshold")
    private int p;

    @Element(name = "LoggingNonDebug")
    private boolean q;

    @Element(name = "LoggingMinLevel")
    private String r;

    @Element(name = "LoggingUseXml")
    private boolean s;

    public VtsSdkConfiguration(Context context, int i) throws VtsException {
        InputStream inputStreamOpenRawResource = null;
        try {
            try {
                inputStreamOpenRawResource = context.getResources().openRawResource(i);
                SerializationUtils.deserializeFromXml(StreamUtils.extractAllAndClose(inputStreamOpenRawResource), this);
                StreamUtils.closeSilently(inputStreamOpenRawResource);
            } catch (Exception e) {
                throw new VtsException(VtsError.COULD_NOT_DESERIALIZE_FILE, e);
            }
        } catch (Throwable th) {
            StreamUtils.closeSilently(inputStreamOpenRawResource);
            throw th;
        }
    }

    public boolean dataOnExternal() {
        return this.f127n;
    }

    public String getApplicationKeyID() {
        return this.a;
    }

    public String getApplicationName() {
        return this.b;
    }

    public String getApplicationVersion() {
        return this.c;
    }

    public int getConnectTimeout() {
        return this.d;
    }

    public String getErrorMessageLangType() {
        return this.h;
    }

    public int getImagesCleanupSpaceThreshold() {
        return this.p;
    }

    public String getLoggingMinlevel() {
        return this.r;
    }

    public int getMobileSyncDailyLimit() {
        return this.m;
    }

    public int getReadTimeout() {
        return this.e;
    }

    public int getSessionIdleTimeout() {
        return this.f;
    }

    public int getSynchronizationRetryDelay() {
        return this.j;
    }

    public String getUserLangType() {
        return this.g;
    }

    public boolean imagesCleanupDisabled() {
        return this.f128o;
    }

    public boolean isSynchronizationDisabled() {
        return this.i;
    }

    public boolean loggingNonDebug() {
        return this.q;
    }

    public boolean loggingUseXml() {
        return this.s;
    }

    public void setApplicationKeyID(String str) {
        this.a = str;
    }

    public void setApplicationName(String str) {
        this.b = str;
    }

    public void setApplicationVersion(String str) {
        this.c = str;
    }

    public void setConnectTimeout(int i) {
        this.d = i;
    }

    public void setErrorMessageLangType(String str) {
        this.h = str;
    }

    public void setReadTimeout(int i) {
        this.e = i;
    }

    public void setSessionIdleTimeout(int i) {
        this.f = i;
    }

    public void setUserLangType(String str) {
        this.g = str;
    }

    public boolean synchronizeImagesReceiptsOnWiFiOnly() {
        return this.l;
    }

    public boolean synchronizeUseExactTimes() {
        return this.k;
    }
}
