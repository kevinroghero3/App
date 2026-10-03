package org.simpleframework.xml.core;

/* JADX INFO: loaded from: classes6.dex */
interface Instance {
    Object getInstance() throws Exception;

    Class getType();

    boolean isReference();

    Object setInstance(Object obj) throws Exception;
}
