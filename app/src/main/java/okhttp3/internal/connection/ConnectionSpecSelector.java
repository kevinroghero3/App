package okhttp3.internal.connection;

import ch.qos.logback.core.CoreConstants;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ConnectionSpec;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class ConnectionSpecSelector {
    private final List<ConnectionSpec> connectionSpecs;
    private boolean isFallback;
    private boolean isFallbackPossible;
    private int nextModeIndex;

    public ConnectionSpecSelector(@NotNull List<ConnectionSpec> connectionSpecs) {
        Intrinsics.checkParameterIsNotNull(connectionSpecs, "connectionSpecs");
        this.connectionSpecs = connectionSpecs;
    }

    public final ConnectionSpec configureSecureSocket(@NotNull SSLSocket sslSocket) throws IOException, CloneNotSupportedException {
        ConnectionSpec connectionSpec;
        Intrinsics.checkParameterIsNotNull(sslSocket, "sslSocket");
        int i = this.nextModeIndex;
        int size = this.connectionSpecs.size();
        while (true) {
            if (i >= size) {
                connectionSpec = null;
                break;
            }
            connectionSpec = this.connectionSpecs.get(i);
            if (connectionSpec.isCompatible(sslSocket)) {
                this.nextModeIndex = i + 1;
                break;
            }
            i++;
        }
        if (connectionSpec == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unable to find acceptable protocols. isFallback=");
            sb.append(this.isFallback);
            sb.append(CoreConstants.COMMA_CHAR);
            sb.append(" modes=");
            sb.append(this.connectionSpecs);
            sb.append(CoreConstants.COMMA_CHAR);
            sb.append(" supported protocols=");
            String[] enabledProtocols = sslSocket.getEnabledProtocols();
            if (enabledProtocols == null) {
                Intrinsics.throwNpe();
            }
            String string = Arrays.toString(enabledProtocols);
            Intrinsics.checkExpressionValueIsNotNull(string, "java.util.Arrays.toString(this)");
            sb.append(string);
            throw new UnknownServiceException(sb.toString());
        }
        this.isFallbackPossible = isFallbackPossible(sslSocket);
        connectionSpec.apply$okhttp(sslSocket, this.isFallback);
        return connectionSpec;
    }

    public final boolean connectionFailed(@NotNull IOException e) {
        Intrinsics.checkParameterIsNotNull(e, "e");
        this.isFallback = true;
        return (!this.isFallbackPossible || (e instanceof ProtocolException) || (e instanceof InterruptedIOException) || ((e instanceof SSLHandshakeException) && (e.getCause() instanceof CertificateException)) || (e instanceof SSLPeerUnverifiedException) || !(e instanceof SSLException)) ? false : true;
    }

    private final boolean isFallbackPossible(SSLSocket sSLSocket) {
        int size = this.connectionSpecs.size();
        for (int i = this.nextModeIndex; i < size; i++) {
            if (this.connectionSpecs.get(i).isCompatible(sSLSocket)) {
                return true;
            }
        }
        return false;
    }
}
