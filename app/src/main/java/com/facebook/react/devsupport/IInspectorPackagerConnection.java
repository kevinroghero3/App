package com.facebook.react.devsupport;

/* JADX INFO: loaded from: classes2.dex */
interface IInspectorPackagerConnection {
    void closeQuietly();

    void connect();

    void sendEventToAllConnections(String str);
}
