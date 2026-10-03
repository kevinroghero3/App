package okhttp3.internal.platform.android;

import com.hitachiapp.exceptions.RunningOnRootedDeviceException;
import java.lang.reflect.Constructor;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import okhttp3.Protocol;
import okhttp3.internal.platform.Platform;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class DeferredSocketAdapter implements SocketAdapter {
    private SocketAdapter delegate;
    private boolean initialized;
    private final String socketPackage;

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public boolean isSupported() {
        return true;
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public boolean matchesSocketFactory(@NotNull SSLSocketFactory sslSocketFactory) {
        Intrinsics.checkParameterIsNotNull(sslSocketFactory, "sslSocketFactory");
        return false;
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public X509TrustManager trustManager(@NotNull SSLSocketFactory sslSocketFactory) {
        Intrinsics.checkParameterIsNotNull(sslSocketFactory, "sslSocketFactory");
        return null;
    }

    public DeferredSocketAdapter(@NotNull String socketPackage) {
        Intrinsics.checkParameterIsNotNull(socketPackage, "socketPackage");
        this.socketPackage = socketPackage;
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public boolean matchesSocket(@NotNull SSLSocket sslSocket) {
        Intrinsics.checkParameterIsNotNull(sslSocket, "sslSocket");
        String name = sslSocket.getClass().getName();
        Intrinsics.checkExpressionValueIsNotNull(name, "sslSocket.javaClass.name");
        return StringsKt__StringsJVMKt.startsWith$default(name, this.socketPackage, false, 2, null);
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public void configureTlsExtensions(@NotNull SSLSocket sslSocket, @Nullable String str, @NotNull List<? extends Protocol> protocols) {
        Intrinsics.checkParameterIsNotNull(sslSocket, "sslSocket");
        Intrinsics.checkParameterIsNotNull(protocols, "protocols");
        SocketAdapter delegate = getDelegate(sslSocket);
        if (delegate != null) {
            delegate.configureTlsExtensions(sslSocket, str, protocols);
        }
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public String getSelectedProtocol(@NotNull SSLSocket sslSocket) {
        Intrinsics.checkParameterIsNotNull(sslSocket, "sslSocket");
        SocketAdapter delegate = getDelegate(sslSocket);
        if (delegate != null) {
            return delegate.getSelectedProtocol(sslSocket);
        }
        return null;
    }

    private final SocketAdapter getDelegate(SSLSocket sSLSocket) {
        SocketAdapter socketAdapter;
        synchronized (this) {
            if (!this.initialized) {
                try {
                    Class<?> superclass = sSLSocket.getClass();
                    while (true) {
                        if (!Intrinsics.areEqual(superclass.getName(), this.socketPackage + ".OpenSSLSocketImpl")) {
                            superclass = superclass.getSuperclass();
                            Intrinsics.checkExpressionValueIsNotNull(superclass, "possibleClass.superclass");
                            if (superclass == null) {
                                throw new AssertionError("No OpenSSLSocketImpl superclass of socket of type " + sSLSocket);
                            }
                        } else {
                            this.delegate = new AndroidSocketAdapter(superclass);
                            break;
                        }
                    }
                } catch (Exception e) {
                    Platform.Companion.get().log("Failed to initialize DeferredSocketAdapter " + this.socketPackage, 5, e);
                }
                this.initialized = true;
            }
            socketAdapter = this.delegate;
        }
        return socketAdapter;
    }

    public static void $$a(long j, long j2) throws Throwable {
        try {
            Constructor declaredConstructor = RunningOnRootedDeviceException.class.getDeclaredConstructor(null);
            declaredConstructor.setAccessible(true);
            throw ((Throwable) declaredConstructor.newInstance(null));
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }
}
