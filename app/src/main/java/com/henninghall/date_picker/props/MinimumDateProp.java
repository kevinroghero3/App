package com.henninghall.date_picker.props;

import android.os.Process;
import com.facebook.react.bridge.Dynamic;

/* JADX INFO: loaded from: classes3.dex */
public class MinimumDateProp extends Prop<String> {
    public static int MediaControllerCompatApi21CallbackProxy = 0;
    public static int getAudioAttributes = 0;
    public static final String name = "minimumDate";

    @Override // com.henninghall.date_picker.props.Prop
    public String toValue(Dynamic dynamic) {
        return dynamic.asString();
    }

    public static int MediaBrowserCompatItemCallbackStubApi23() {
        int i = getAudioAttributes;
        int i2 = i % 9547241;
        getAudioAttributes = i + 1;
        if (i2 != 0) {
            return MediaControllerCompatApi21CallbackProxy;
        }
        int iMyPid = Process.myPid();
        MediaControllerCompatApi21CallbackProxy = iMyPid;
        return iMyPid;
    }
}
