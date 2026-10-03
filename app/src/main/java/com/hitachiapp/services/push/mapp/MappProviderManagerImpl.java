package com.hitachiapp.services.push.mapp;

import com.facebook.common.callercontext.ContextChain;
import com.google.firebase.messaging.RemoteMessage;
import com.hitachiapp.services.push.core.ExternalPushProvider;
import java.lang.reflect.Method;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import timber.log.Timber;

/* JADX INFO: loaded from: classes6.dex */
public final class MappProviderManagerImpl implements ExternalPushProvider {
    public static final MappProviderManagerImpl INSTANCE = new MappProviderManagerImpl();
    private static final String name = "Mapp";

    private MappProviderManagerImpl() {
    }

    @Override // com.hitachiapp.services.push.core.ExternalPushProvider
    public String getName() {
        return name;
    }

    @Override // com.hitachiapp.services.push.core.ExternalPushProvider
    public boolean canHandle(@NotNull RemoteMessage remoteMessage) {
        Intrinsics.checkNotNullParameter(remoteMessage, "remoteMessage");
        Timber.tag(MappPushSdkBootstrap.INSTANCE.getName()).d("MappProviderManagerImpl.canHandle invoked...", new Object[0]);
        return remoteMessage.getData().containsKey(ContextChain.TAG_PRODUCT);
    }

    @Override // com.hitachiapp.services.push.core.ExternalPushProvider
    public boolean handleMessage(@NotNull RemoteMessage remoteMessage) {
        Object objM5472constructorimpl;
        Intrinsics.checkNotNullParameter(remoteMessage, "remoteMessage");
        Timber.tag(MappPushSdkBootstrap.INSTANCE.getName()).d("MappProviderManagerImpl.handleMessage invoked...", new Object[0]);
        try {
            Result.Companion companion = Result.Companion;
            Class<?> cls = Class.forName("com.appoxee.Appoxee");
            Object objInvoke = cls.getMethod("instance", null).invoke(null, null);
            if (objInvoke != null) {
                waitUntilReady(objInvoke);
            }
            cls.getMethod("setRemoteMessage", RemoteMessage.class).invoke(objInvoke, remoteMessage);
            String str = remoteMessage.getData().get("push_title");
            if (str == null) {
                str = "Mapp Notification";
            }
            String str2 = remoteMessage.getData().get("alert");
            String str3 = "";
            if (str2 == null) {
                RemoteMessage.Notification notification = remoteMessage.getNotification();
                String body = notification != null ? notification.getBody() : null;
                str2 = body == null ? "" : body;
            }
            String str4 = remoteMessage.getData().get("url");
            if (str4 != null) {
                str3 = str4;
            }
            Timber.tag(getName()).d("Mapp notification - Title: " + str + ", Body: " + str2 + ", URL: " + str3, new Object[0]);
            Timber.tag(getName()).d("Appoxee SDK handled message successfully", new Object[0]);
            objM5472constructorimpl = Result.m5472constructorimpl(Boolean.TRUE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            objM5472constructorimpl = Result.m5472constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM5475exceptionOrNullimpl = Result.m5475exceptionOrNullimpl(objM5472constructorimpl);
        if (thM5475exceptionOrNullimpl != null) {
            Timber.tag(INSTANCE.getName()).e(thM5475exceptionOrNullimpl, "Mapp handleMessage failed", new Object[0]);
        }
        Boolean bool = Boolean.FALSE;
        if (Result.m5478isFailureimpl(objM5472constructorimpl)) {
            objM5472constructorimpl = bool;
        }
        return ((Boolean) objM5472constructorimpl).booleanValue();
    }

    @Override // com.hitachiapp.services.push.core.ExternalPushProvider
    public void onNewToken(@NotNull String token) {
        Object objM5472constructorimpl;
        Intrinsics.checkNotNullParameter(token, "token");
        Timber.tag(MappPushSdkBootstrap.INSTANCE.getName()).d("MappProviderManagerImpl.onNewToken invoked...", new Object[0]);
        try {
            Result.Companion companion = Result.Companion;
            Class<?> cls = Class.forName("com.appoxee.Appoxee");
            Object objInvoke = cls.getMethod("instance", null).invoke(null, null);
            if (objInvoke != null) {
                waitUntilReady(objInvoke);
            }
            objM5472constructorimpl = Result.m5472constructorimpl(cls.getMethod("setPushToken", String.class).invoke(objInvoke, token));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            objM5472constructorimpl = Result.m5472constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM5475exceptionOrNullimpl = Result.m5475exceptionOrNullimpl(objM5472constructorimpl);
        if (thM5475exceptionOrNullimpl != null) {
            Timber.tag("MappProvider").d("Mapp onNewToken skipped: " + thM5475exceptionOrNullimpl.getMessage(), new Object[0]);
        }
    }

    private final void waitUntilReady(Object obj) {
        Timber.tag(MappPushSdkBootstrap.INSTANCE.getName()).d("MappProviderManagerImpl.waitUntilReady invoked...", new Object[0]);
        try {
            Result.Companion companion = Result.Companion;
            Method method = obj.getClass().getMethod("isReady", null);
            for (int i = 15; i > 0; i--) {
                Object objInvoke = method.invoke(obj, null);
                if (Intrinsics.areEqual(objInvoke instanceof Boolean ? (Boolean) objInvoke : null, Boolean.TRUE)) {
                    return;
                }
                Thread.sleep(300L);
            }
            Result.m5472constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.m5472constructorimpl(ResultKt.createFailure(th));
        }
    }
}
