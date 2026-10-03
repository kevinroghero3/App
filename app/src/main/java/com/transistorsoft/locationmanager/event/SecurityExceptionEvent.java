package com.transistorsoft.locationmanager.event;

/* JADX INFO: loaded from: classes.dex */
public class SecurityExceptionEvent {
    public int action;
    public SecurityException exception;

    public SecurityExceptionEvent(SecurityException securityException, Integer num) {
        this.action = num.intValue();
        this.exception = securityException;
    }
}
