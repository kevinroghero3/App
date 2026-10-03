package ch.qos.logback.core.joran;

import ch.qos.logback.core.Context;
import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.joran.event.SaxEvent;
import ch.qos.logback.core.joran.event.SaxEventRecorder;
import ch.qos.logback.core.joran.spi.DefaultNestedComponentRegistry;
import ch.qos.logback.core.joran.spi.ElementPath;
import ch.qos.logback.core.joran.spi.InterpretationContext;
import ch.qos.logback.core.joran.spi.Interpreter;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.joran.spi.RuleStore;
import ch.qos.logback.core.joran.spi.SimpleRuleStore;
import ch.qos.logback.core.joran.util.ConfigurationWatchListUtil;
import ch.qos.logback.core.spi.ContextAwareBase;
import ch.qos.logback.core.status.StatusUtil;
import ch.qos.logback.core.util.CloseUtil;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import io.sentry.instrumentation.file.SentryFileInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import org.xml.sax.InputSource;

/* JADX INFO: loaded from: classes2.dex */
public abstract class GenericConfigurator extends ContextAwareBase {
    public Interpreter interpreter;

    private final void doConfigure(InputSource inputSource) throws JoranException {
        long jCurrentTimeMillis = System.currentTimeMillis();
        SaxEventRecorder saxEventRecorder = new SaxEventRecorder(this.context);
        saxEventRecorder.recordEvents(inputSource);
        doConfigure(saxEventRecorder.getSaxEventList());
        if (new StatusUtil(this.context).noXMLParsingErrorsOccurred(jCurrentTimeMillis)) {
            addInfo("Registering current configuration as safe fallback point");
            registerSafeConfiguration(saxEventRecorder.getSaxEventList());
        }
    }

    public static void informContextOfURLUsedForConfiguration(Context context, URL url) {
        ConfigurationWatchListUtil.setMainWatchURL(context, url);
    }

    protected void addDefaultNestedComponentRegistryRules(DefaultNestedComponentRegistry defaultNestedComponentRegistry) {
    }

    protected abstract void addImplicitRules(Interpreter interpreter);

    protected abstract void addInstanceRules(RuleStore ruleStore);

    public void buildInterpreter() {
        SimpleRuleStore simpleRuleStore = new SimpleRuleStore(this.context);
        addInstanceRules(simpleRuleStore);
        Interpreter interpreter = new Interpreter(this.context, simpleRuleStore, initialElementPath());
        this.interpreter = interpreter;
        InterpretationContext interpretationContext = interpreter.getInterpretationContext();
        interpretationContext.setContext(this.context);
        addImplicitRules(this.interpreter);
        addDefaultNestedComponentRegistryRules(interpretationContext.getDefaultNestedComponentRegistry());
    }

    public final void doConfigure(File file) throws JoranException {
        FileInputStream fileInputStreamCreate = null;
        try {
            try {
                URL url = file.toURI().toURL();
                informContextOfURLUsedForConfiguration(getContext(), url);
                fileInputStreamCreate = SentryFileInputStream.Factory.create(new FileInputStream(file), file);
                doConfigure(fileInputStreamCreate, url.toExternalForm());
                CloseUtil.closeQuietly(fileInputStreamCreate);
            } catch (IOException e) {
                String str = "Could not open [" + file.getPath() + "].";
                addError(str, e);
                throw new JoranException(str, e);
            }
        } catch (Throwable th) {
            CloseUtil.closeQuietly(fileInputStreamCreate);
            throw th;
        }
    }

    public final void doConfigure(InputStream inputStream) throws JoranException {
        try {
            doConfigure(new InputSource(inputStream));
            try {
                inputStream.close();
            } catch (IOException e) {
                addError("Could not close the stream", e);
                throw new JoranException("Could not close the stream", e);
            }
        } catch (Throwable th) {
            try {
                inputStream.close();
                throw th;
            } catch (IOException e2) {
                addError("Could not close the stream", e2);
                throw new JoranException("Could not close the stream", e2);
            }
        }
    }

    public final void doConfigure(InputStream inputStream, String str) throws JoranException {
        InputSource inputSource = new InputSource(inputStream);
        inputSource.setSystemId(str);
        doConfigure(inputSource);
    }

    public final void doConfigure(String str) throws JoranException {
        doConfigure(new File(str));
    }

    public final void doConfigure(URL url) throws JoranException {
        InputStream inputStream = null;
        try {
            try {
                informContextOfURLUsedForConfiguration(getContext(), url);
                URLConnection uRLConnection = (URLConnection) FirebasePerfUrlConnection.instrument(url.openConnection());
                uRLConnection.setUseCaches(false);
                inputStream = uRLConnection.getInputStream();
                doConfigure(inputStream, url.toExternalForm());
                CloseUtil.closeQuietly(inputStream);
            } catch (IOException e) {
                String str = "Could not open URL [" + url + "].";
                addError(str, e);
                throw new JoranException(str, e);
            }
        } catch (Throwable th) {
            CloseUtil.closeQuietly(inputStream);
            throw th;
        }
    }

    public void doConfigure(List<SaxEvent> list) throws JoranException {
        buildInterpreter();
        synchronized (this.context.getConfigurationLock()) {
            this.interpreter.getEventPlayer().play(list);
        }
    }

    protected ElementPath initialElementPath() {
        return new ElementPath();
    }

    public List<SaxEvent> recallSafeConfiguration() {
        return (List) this.context.getObject(CoreConstants.SAFE_JORAN_CONFIGURATION);
    }

    public void registerSafeConfiguration(List<SaxEvent> list) {
        this.context.putObject(CoreConstants.SAFE_JORAN_CONFIGURATION, list);
    }
}
