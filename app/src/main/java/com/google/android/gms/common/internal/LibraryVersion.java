package com.google.android.gms.common.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.util.IOUtils;
import java.io.Closeable;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class LibraryVersion {
    private static final GmsLogger zza = new GmsLogger("LibraryVersion", "");
    private static final LibraryVersion zzb = new LibraryVersion();
    private final ConcurrentHashMap zzc = new ConcurrentHashMap();

    protected LibraryVersion() {
    }

    public static LibraryVersion getInstance() {
        return zzb;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.util.Properties] */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v8, types: [java.io.InputStream] */
    @Deprecated
    public String getVersion(@NonNull String str) throws Throwable {
        String str2;
        ?? resourceAsStream;
        Preconditions.checkNotEmpty(str, "Please provide a valid libraryName");
        if (this.zzc.containsKey(str)) {
            return (String) this.zzc.get(str);
        }
        ?? properties = new Properties();
        String property = null;
        property = null;
        property = null;
        ?? r3 = 0;
        try {
            try {
                resourceAsStream = LibraryVersion.class.getResourceAsStream(String.format("/%s.properties", str));
                try {
                    if (resourceAsStream != 0) {
                        properties.load(resourceAsStream);
                        property = properties.getProperty("version", null);
                        zza.v("LibraryVersion", str + " version is " + property);
                    } else {
                        zza.w("LibraryVersion", "Failed to get app version for libraryName: " + str);
                    }
                } catch (IOException e) {
                    e = e;
                    str2 = property;
                    r3 = resourceAsStream;
                    zza.e("LibraryVersion", "Failed to get app version for libraryName: " + str, e);
                    String str3 = str2;
                    resourceAsStream = r3;
                    property = str3;
                } catch (Throwable th) {
                    th = th;
                    if (resourceAsStream != 0) {
                        IOUtils.closeQuietly((Closeable) resourceAsStream);
                    }
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
                str2 = null;
            }
            if (resourceAsStream != 0) {
                IOUtils.closeQuietly((Closeable) resourceAsStream);
            }
            if (property == null) {
                zza.d("LibraryVersion", ".properties file is dropped during release process. Failure to read app version is expected during Google internal testing where locally-built libraries are used");
                property = "UNKNOWN";
            }
            this.zzc.put(str, property);
            return property;
        } catch (Throwable th2) {
            th = th2;
            resourceAsStream = property;
        }
    }
}
