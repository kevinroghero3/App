package com.salesforce.marketingcloud.media;

import android.graphics.Bitmap;
import com.facebook.share.internal.ShareConstants;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Locale;
import javax.net.ssl.HttpsURLConnection;

/* JADX INFO: loaded from: classes3.dex */
public class r extends v {
    private static final String b = com.salesforce.marketingcloud.g.a("NetworkRequestHandler");
    private final s a;

    public r(s sVar) {
        this.a = sVar;
    }

    @Override // com.salesforce.marketingcloud.media.v
    public boolean a(t tVar) {
        try {
            String lowerCase = tVar.a.getScheme().toLowerCase(Locale.ENGLISH);
            return "http".equalsIgnoreCase(lowerCase) || "https".equalsIgnoreCase(lowerCase);
        } catch (Exception e) {
            com.salesforce.marketingcloud.g.a(b, e, "Unable to get scheme from request.", new Object[0]);
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.net.HttpURLConnection, java.net.URLConnection, javax.net.ssl.HttpsURLConnection] */
    @Override // com.salesforce.marketingcloud.media.v
    public void a(o oVar, t tVar, v.a aVar) throws Throwable {
        ?? r2;
        String string = tVar.a.toString();
        Bitmap bitmapA = a(string, tVar);
        if (bitmapA != null) {
            aVar.a(new v.b(bitmapA, o.b.DISK));
            return;
        }
        com.salesforce.marketingcloud.g.a(ShareConstants.IMAGE_URL, "Starting network request for image", new Object[0]);
        HttpURLConnection.setFollowRedirects(true);
        ?? r0 = 0;
        ?? r1 = 0;
        try {
            try {
                r2 = (HttpsURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(string).openConnection()));
                try {
                    r2.setUseCaches(false);
                    r2.setConnectTimeout(30000);
                    r2.setRequestMethod("GET");
                    InputStream inputStream = r2.getInputStream();
                    if (t.b.c(tVar.d)) {
                        byte[] bArrA = com.salesforce.marketingcloud.util.e.a(inputStream);
                        com.salesforce.marketingcloud.util.e.a((Closeable) inputStream);
                        this.a.a(string, new ByteArrayInputStream(bArrA));
                        inputStream = new ByteArrayInputStream(bArrA);
                    }
                    Bitmap bitmapA2 = v.a(inputStream, tVar);
                    com.salesforce.marketingcloud.util.e.a((Closeable) inputStream);
                    v.b bVar = new v.b(bitmapA2, o.b.NETWORK);
                    aVar.a(bVar);
                    r2.disconnect();
                    r0 = bVar;
                } catch (Exception e) {
                    e = e;
                    r1 = r2;
                    com.salesforce.marketingcloud.g.b(ShareConstants.IMAGE_URL, e, "Image network error for URL: %s", string);
                    aVar.a(e);
                    r0 = r1;
                    if (r1 != 0) {
                        r1.disconnect();
                        r0 = r1;
                    }
                } catch (Throwable th) {
                    th = th;
                    if (r2 != 0) {
                        r2.disconnect();
                    }
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
            r2 = r0;
        }
    }

    private Bitmap a(String str, t tVar) throws IOException {
        InputStream inputStreamA = this.a.a(str);
        Bitmap bitmapA = null;
        if (inputStreamA == null) {
            return null;
        }
        try {
            bitmapA = v.a(inputStreamA, tVar);
            com.salesforce.marketingcloud.util.e.a((Closeable) inputStreamA);
            return bitmapA;
        } catch (Exception e) {
            com.salesforce.marketingcloud.g.a(b, e, "Failed to decode cache into Bitmap.", new Object[0]);
            return bitmapA;
        }
    }
}
