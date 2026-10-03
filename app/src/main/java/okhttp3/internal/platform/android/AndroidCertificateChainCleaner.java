package okhttp3.internal.platform.android;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.tls.CertificateChainCleaner;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class AndroidCertificateChainCleaner extends CertificateChainCleaner {
    public static final Companion Companion = new Companion(null);
    private final Method checkServerTrusted;
    private final X509TrustManager trustManager;
    private final Object x509TrustManagerExtensions;

    public AndroidCertificateChainCleaner(@NotNull X509TrustManager trustManager, @NotNull Object x509TrustManagerExtensions, @NotNull Method checkServerTrusted) {
        Intrinsics.checkParameterIsNotNull(trustManager, "trustManager");
        Intrinsics.checkParameterIsNotNull(x509TrustManagerExtensions, "x509TrustManagerExtensions");
        Intrinsics.checkParameterIsNotNull(checkServerTrusted, "checkServerTrusted");
        this.trustManager = trustManager;
        this.x509TrustManagerExtensions = x509TrustManagerExtensions;
        this.checkServerTrusted = checkServerTrusted;
    }

    @Override // okhttp3.internal.tls.CertificateChainCleaner
    public List<Certificate> clean(@NotNull List<? extends Certificate> chain, @NotNull String hostname) throws SSLPeerUnverifiedException {
        Intrinsics.checkParameterIsNotNull(chain, "chain");
        Intrinsics.checkParameterIsNotNull(hostname, "hostname");
        try {
            Object[] array = chain.toArray(new X509Certificate[0]);
            if (array != null) {
                Object objInvoke = this.checkServerTrusted.invoke(this.x509TrustManagerExtensions, (X509Certificate[]) array, "RSA", hostname);
                if (objInvoke != null) {
                    return (List) objInvoke;
                }
                throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<java.security.cert.Certificate>");
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        } catch (InvocationTargetException e2) {
            SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e2.getMessage());
            sSLPeerUnverifiedException.initCause(e2);
            throw sSLPeerUnverifiedException;
        }
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof AndroidCertificateChainCleaner) && ((AndroidCertificateChainCleaner) obj).trustManager == this.trustManager;
    }

    public int hashCode() {
        return System.identityHashCode(this.trustManager);
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AndroidCertificateChainCleaner build(@NotNull X509TrustManager trustManager) {
            Intrinsics.checkParameterIsNotNull(trustManager, "trustManager");
            try {
                Class<?> cls = Class.forName("android.net.http.X509TrustManagerExtensions");
                Object extensions = cls.getConstructor(X509TrustManager.class).newInstance(trustManager);
                Method checkServerTrusted = cls.getMethod("checkServerTrusted", X509Certificate[].class, String.class, String.class);
                Intrinsics.checkExpressionValueIsNotNull(extensions, "extensions");
                Intrinsics.checkExpressionValueIsNotNull(checkServerTrusted, "checkServerTrusted");
                return new AndroidCertificateChainCleaner(trustManager, extensions, checkServerTrusted);
            } catch (Exception unused) {
                return null;
            }
        }
    }
}
