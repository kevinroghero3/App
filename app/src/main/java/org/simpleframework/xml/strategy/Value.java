package org.simpleframework.xml.strategy;

/* JADX INFO: loaded from: classes6.dex */
public interface Value {
    int getLength();

    Class getType();

    Object getValue();

    boolean isReference();

    void setValue(Object obj);
}
