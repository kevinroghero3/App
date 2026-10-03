package com.google.android.material.color.utilities;

import android.os.Process;
import java.util.function.Function;

/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class MaterialDynamicColors$$ExternalSyntheticLambda131 implements Function {
    public static int getSessionToken;
    public static int sendCustomAction;
    public final /* synthetic */ MaterialDynamicColors f$0;

    public /* synthetic */ MaterialDynamicColors$$ExternalSyntheticLambda131(MaterialDynamicColors materialDynamicColors) {
        this.f$0 = materialDynamicColors;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return this.f$0.lambda$error$93((DynamicScheme) obj);
    }

    public static int ICustomTabsServiceDefault() {
        int i = sendCustomAction;
        int i2 = i % 5568457;
        sendCustomAction = i + 1;
        if (i2 != 0) {
            return getSessionToken;
        }
        int elapsedCpuTime = (int) Process.getElapsedCpuTime();
        getSessionToken = elapsedCpuTime;
        return elapsedCpuTime;
    }
}
