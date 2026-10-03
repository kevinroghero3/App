package com.google.crypto.tink;

/* JADX INFO: loaded from: classes2.dex */
public interface KeysetHandleInterface {

    public interface Entry {
        int getId();

        Key getKey();

        KeyStatus getStatus();

        boolean isPrimary();
    }

    <T extends Annotations> T getAnnotationsOrNull(Class<T> cls);

    Entry getAt(int i);

    Entry getPrimary();

    int size();
}
