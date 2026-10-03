package com.hitachiapp.services;

import java.util.Random;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class CustomFirebaseMessagingService$$ExternalSyntheticLambda0 implements Function0 {
    public static int MediaControllerCompatApi21Callback;
    public static int MediaControllerCompatApi21PlaybackInfo;
    public final /* synthetic */ CustomFirebaseMessagingService f$0;

    public /* synthetic */ CustomFirebaseMessagingService$$ExternalSyntheticLambda0(CustomFirebaseMessagingService customFirebaseMessagingService) {
        this.f$0 = customFirebaseMessagingService;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return CustomFirebaseMessagingService.providers_delegate$lambda$0(this.f$0);
    }

    public static int MediaBrowserCompatCustomActionResultReceiver() {
        int i = MediaControllerCompatApi21PlaybackInfo;
        int i2 = i % 8771209;
        MediaControllerCompatApi21PlaybackInfo = i + 1;
        if (i2 != 0) {
            return MediaControllerCompatApi21Callback;
        }
        int iNextInt = new Random().nextInt(1100873975);
        MediaControllerCompatApi21Callback = iNextInt;
        return iNextInt;
    }
}
