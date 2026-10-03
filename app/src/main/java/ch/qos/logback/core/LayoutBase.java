package ch.qos.logback.core;

import androidx.webkit.internal.AssetHelper;
import ch.qos.logback.core.spi.ContextAwareBase;

/* JADX INFO: loaded from: classes2.dex */
public abstract class LayoutBase<E> extends ContextAwareBase implements Layout<E> {
    String fileFooter;
    String fileHeader;
    String presentationFooter;
    String presentationHeader;
    public boolean started;

    public String getContentType() {
        return AssetHelper.DEFAULT_MIME_TYPE;
    }

    @Override // ch.qos.logback.core.spi.ContextAwareBase, ch.qos.logback.core.spi.ContextAware
    public Context getContext() {
        return this.context;
    }

    @Override // ch.qos.logback.core.Layout
    public String getFileFooter() {
        return this.fileFooter;
    }

    @Override // ch.qos.logback.core.Layout
    public String getFileHeader() {
        return this.fileHeader;
    }

    @Override // ch.qos.logback.core.Layout
    public String getPresentationFooter() {
        return this.presentationFooter;
    }

    @Override // ch.qos.logback.core.Layout
    public String getPresentationHeader() {
        return this.presentationHeader;
    }

    @Override // ch.qos.logback.core.spi.LifeCycle
    public boolean isStarted() {
        return this.started;
    }

    @Override // ch.qos.logback.core.spi.ContextAwareBase, ch.qos.logback.core.spi.ContextAware
    public void setContext(Context context) {
        this.context = context;
    }

    public void setFileFooter(String str) {
        this.fileFooter = str;
    }

    public void setFileHeader(String str) {
        this.fileHeader = str;
    }

    public void setPresentationFooter(String str) {
        this.presentationFooter = str;
    }

    public void setPresentationHeader(String str) {
        this.presentationHeader = str;
    }

    public void start() {
        this.started = true;
    }

    @Override // ch.qos.logback.core.spi.LifeCycle
    public void stop() {
        this.started = false;
    }
}
