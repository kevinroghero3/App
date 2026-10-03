package ch.qos.logback.classic.net;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.net.ssl.ConfigurableSSLServerSocketFactory;
import ch.qos.logback.core.net.ssl.SSLParametersConfiguration;
import java.security.NoSuchAlgorithmException;
import javax.net.ServerSocketFactory;
import javax.net.ssl.SSLContext;

/* JADX INFO: loaded from: classes4.dex */
public class SimpleSSLSocketServer extends SimpleSocketServer {
    public static int onNavigationEvent;
    public static int onRelationshipValidationResult;
    private final ServerSocketFactory socketFactory;

    public SimpleSSLSocketServer(LoggerContext loggerContext, int i) throws NoSuchAlgorithmException {
        this(loggerContext, i, SSLContext.getDefault());
    }

    public SimpleSSLSocketServer(LoggerContext loggerContext, int i, SSLContext sSLContext) {
        super(loggerContext, i);
        if (sSLContext == null) {
            throw new NullPointerException("SSL context required");
        }
        SSLParametersConfiguration sSLParametersConfiguration = new SSLParametersConfiguration();
        sSLParametersConfiguration.setContext(loggerContext);
        this.socketFactory = new ConfigurableSSLServerSocketFactory(sSLParametersConfiguration, sSLContext.getServerSocketFactory());
    }

    public static void main(String[] strArr) throws Exception {
        SimpleSocketServer.doMain(SimpleSSLSocketServer.class, strArr);
    }

    @Override // ch.qos.logback.classic.net.SimpleSocketServer
    protected ServerSocketFactory getServerSocketFactory() {
        return this.socketFactory;
    }

    public static int CoroutineDebuggingKt() {
        int i = onNavigationEvent;
        int i2 = i % 5366134;
        onNavigationEvent = i + 1;
        if (i2 != 0) {
            return onRelationshipValidationResult;
        }
        int iFreeMemory = (int) Runtime.getRuntime().freeMemory();
        onRelationshipValidationResult = iFreeMemory;
        return iFreeMemory;
    }
}
