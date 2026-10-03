package io.invertase.firebase.interfaces;

import com.facebook.react.bridge.WritableMap;

/* JADX INFO: loaded from: classes3.dex */
public interface NativeEvent {
    WritableMap getEventBody();

    String getEventName();

    String getFirebaseAppName();
}
