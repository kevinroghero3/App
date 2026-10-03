package io.invertase.firebase.analytics;

import com.facebook.react.bridge.Promise;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class ReactNativeFirebaseAnalyticsModule$$ExternalSyntheticLambda1 implements OnCompleteListener {
    public static int getCallingPackage;
    public static int getCurrentControllerInfo;
    public final /* synthetic */ Promise f$0;

    public /* synthetic */ ReactNativeFirebaseAnalyticsModule$$ExternalSyntheticLambda1(Promise promise) {
        this.f$0 = promise;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task task) {
        ReactNativeFirebaseAnalyticsModule.lambda$setConsent$10(this.f$0, task);
    }

    public static int MediaBrowserCompatMediaBrowserImplApi211() {
        int i = getCurrentControllerInfo;
        int i2 = i % 8053084;
        getCurrentControllerInfo = i + 1;
        if (i2 != 0) {
            return getCallingPackage;
        }
        int i3 = (int) Runtime.getRuntime().totalMemory();
        getCallingPackage = i3;
        return i3;
    }
}
