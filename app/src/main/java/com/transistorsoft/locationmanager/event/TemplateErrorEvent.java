package com.transistorsoft.locationmanager.event;

/* JADX INFO: loaded from: classes.dex */
public class TemplateErrorEvent {
    private final String a;
    private final Exception b;

    public TemplateErrorEvent(String str, Exception exc) {
        this.a = str;
        this.b = exc;
    }

    public Exception getError() {
        return this.b;
    }

    public String getTemplateName() {
        return this.a;
    }
}
