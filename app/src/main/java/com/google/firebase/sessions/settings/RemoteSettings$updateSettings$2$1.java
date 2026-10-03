package com.google.firebase.sessions.settings;

import android.util.Log;
import ch.qos.logback.core.net.SyslogConstants;
import io.sentry.android.core.SentryLogcatAdapter;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joda.time.DateTimeConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@DebugMetadata(c = "com.google.firebase.sessions.settings.RemoteSettings$updateSettings$2$1", f = "RemoteSettings.kt", i = {0, 0, 0, 1, 1, 2}, l = {125, 128, 131, 133, 134, SyslogConstants.LOG_LOCAL1}, m = "invokeSuspend", n = {"sessionSamplingRate", "sessionTimeoutSeconds", "cacheDuration", "sessionSamplingRate", "cacheDuration", "cacheDuration"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$0"})
final class RemoteSettings$updateSettings$2$1 extends SuspendLambda implements Function2<JSONObject, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ RemoteSettings this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RemoteSettings$updateSettings$2$1(RemoteSettings remoteSettings, Continuation<? super RemoteSettings$updateSettings$2$1> continuation) {
        super(2, continuation);
        this.this$0 = remoteSettings;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        RemoteSettings$updateSettings$2$1 remoteSettings$updateSettings$2$1 = new RemoteSettings$updateSettings$2$1(this.this$0, continuation);
        remoteSettings$updateSettings$2$1.L$0 = obj;
        return remoteSettings$updateSettings$2$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(@NotNull JSONObject jSONObject, @Nullable Continuation<? super Unit> continuation) {
        return ((RemoteSettings$updateSettings$2$1) create(jSONObject, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:45:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:47:0x0112 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:51:0x011a  */
    /* JADX WARN: Code duplicated, block: B:53:0x0133 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:56:0x013a  */
    /* JADX WARN: Code duplicated, block: B:58:0x0153 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:60:0x0157  */
    /* JADX WARN: Code duplicated, block: B:62:0x015a  */
    /* JADX WARN: Code duplicated, block: B:64:0x0176 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:67:0x0194 A[RETURN] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v12, types: [T, java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r1v5, types: [T, java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r2v4, types: [T, java.lang.Double] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(@NotNull Object obj) throws JSONException {
        Ref.ObjectRef objectRef;
        Ref.ObjectRef objectRef2;
        Boolean bool;
        Ref.ObjectRef objectRef3;
        Ref.ObjectRef objectRef4;
        Ref.ObjectRef objectRef5;
        Ref.ObjectRef objectRef6;
        Ref.ObjectRef objectRef7;
        SettingsCache settingsCache;
        Integer num;
        SettingsCache settingsCache2;
        Double d;
        Unit unit;
        SettingsCache settingsCache3;
        Integer num2;
        SettingsCache settingsCache4;
        Integer numBoxInt;
        SettingsCache settingsCache5;
        Long lBoxLong;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                JSONObject jSONObject = (JSONObject) this.L$0;
                Log.d(RemoteSettings.TAG, "Fetched settings: " + jSONObject);
                Ref.ObjectRef objectRef8 = new Ref.ObjectRef();
                objectRef = new Ref.ObjectRef();
                objectRef2 = new Ref.ObjectRef();
                if (jSONObject.has("app_quality")) {
                    Object obj2 = jSONObject.get("app_quality");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type org.json.JSONObject");
                    JSONObject jSONObject2 = (JSONObject) obj2;
                    try {
                        bool = jSONObject2.has("sessions_enabled") ? (Boolean) jSONObject2.get("sessions_enabled") : null;
                        try {
                            if (jSONObject2.has("sampling_rate")) {
                                objectRef8.element = (Double) jSONObject2.get("sampling_rate");
                            }
                            if (jSONObject2.has("session_timeout_seconds")) {
                                objectRef.element = (Integer) jSONObject2.get("session_timeout_seconds");
                            }
                            if (jSONObject2.has("cache_duration")) {
                                objectRef2.element = (Integer) jSONObject2.get("cache_duration");
                            }
                        } catch (JSONException e) {
                            e = e;
                            SentryLogcatAdapter.e(RemoteSettings.TAG, "Error parsing the configs remotely fetched: ", e);
                        }
                    } catch (JSONException e2) {
                        e = e2;
                        bool = null;
                    }
                    break;
                } else {
                    bool = null;
                }
                if (bool != null) {
                    SettingsCache settingsCache6 = this.this$0.settingsCache;
                    this.L$0 = objectRef8;
                    this.L$1 = objectRef;
                    this.L$2 = objectRef2;
                    this.label = 1;
                    if (settingsCache6.updateSettingsEnabled(bool, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    objectRef4 = objectRef8;
                    objectRef5 = objectRef;
                    objectRef6 = objectRef2;
                    objectRef2 = objectRef6;
                    objectRef = objectRef5;
                    objectRef3 = objectRef4;
                } else {
                    objectRef3 = objectRef8;
                }
                if (((Integer) objectRef.element) != null) {
                    settingsCache = this.this$0.settingsCache;
                    num = (Integer) objectRef.element;
                    this.L$0 = objectRef3;
                    this.L$1 = objectRef2;
                    this.L$2 = null;
                    this.label = 2;
                    if (settingsCache.updateSessionRestartTimeout(num, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                objectRef7 = objectRef2;
                if (((Double) objectRef3.element) != null) {
                    settingsCache2 = this.this$0.settingsCache;
                    d = (Double) objectRef3.element;
                    this.L$0 = objectRef7;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.label = 3;
                    if (settingsCache2.updateSamplingRate(d, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                if (((Integer) objectRef7.element) != null) {
                    settingsCache3 = this.this$0.settingsCache;
                    num2 = (Integer) objectRef7.element;
                    this.L$0 = null;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.label = 4;
                    if (settingsCache3.updateSessionCacheDuration(num2, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    settingsCache4 = this.this$0.settingsCache;
                    numBoxInt = Boxing.boxInt(DateTimeConstants.SECONDS_PER_DAY);
                    this.L$0 = null;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.label = 5;
                    if (settingsCache4.updateSessionCacheDuration(numBoxInt, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                settingsCache5 = this.this$0.settingsCache;
                lBoxLong = Boxing.boxLong(System.currentTimeMillis());
                this.L$0 = null;
                this.L$1 = null;
                this.L$2 = null;
                this.label = 6;
                if (settingsCache5.updateSessionCacheUpdatedTime(lBoxLong, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 1:
                objectRef6 = (Ref.ObjectRef) this.L$2;
                objectRef5 = (Ref.ObjectRef) this.L$1;
                objectRef4 = (Ref.ObjectRef) this.L$0;
                ResultKt.throwOnFailure(obj);
                objectRef2 = objectRef6;
                objectRef = objectRef5;
                objectRef3 = objectRef4;
                if (((Integer) objectRef.element) != null) {
                    settingsCache = this.this$0.settingsCache;
                    num = (Integer) objectRef.element;
                    this.L$0 = objectRef3;
                    this.L$1 = objectRef2;
                    this.L$2 = null;
                    this.label = 2;
                    if (settingsCache.updateSessionRestartTimeout(num, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                objectRef7 = objectRef2;
                if (((Double) objectRef3.element) != null) {
                    settingsCache2 = this.this$0.settingsCache;
                    d = (Double) objectRef3.element;
                    this.L$0 = objectRef7;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.label = 3;
                    if (settingsCache2.updateSamplingRate(d, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                if (((Integer) objectRef7.element) != null) {
                    settingsCache3 = this.this$0.settingsCache;
                    num2 = (Integer) objectRef7.element;
                    this.L$0 = null;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.label = 4;
                    if (settingsCache3.updateSessionCacheDuration(num2, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    settingsCache4 = this.this$0.settingsCache;
                    numBoxInt = Boxing.boxInt(DateTimeConstants.SECONDS_PER_DAY);
                    this.L$0 = null;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.label = 5;
                    if (settingsCache4.updateSessionCacheDuration(numBoxInt, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                settingsCache5 = this.this$0.settingsCache;
                lBoxLong = Boxing.boxLong(System.currentTimeMillis());
                this.L$0 = null;
                this.L$1 = null;
                this.L$2 = null;
                this.label = 6;
                if (settingsCache5.updateSessionCacheUpdatedTime(lBoxLong, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 2:
                objectRef7 = (Ref.ObjectRef) this.L$1;
                objectRef3 = (Ref.ObjectRef) this.L$0;
                ResultKt.throwOnFailure(obj);
                if (((Double) objectRef3.element) != null) {
                    settingsCache2 = this.this$0.settingsCache;
                    d = (Double) objectRef3.element;
                    this.L$0 = objectRef7;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.label = 3;
                    if (settingsCache2.updateSamplingRate(d, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                if (((Integer) objectRef7.element) != null) {
                    settingsCache3 = this.this$0.settingsCache;
                    num2 = (Integer) objectRef7.element;
                    this.L$0 = null;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.label = 4;
                    if (settingsCache3.updateSessionCacheDuration(num2, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    settingsCache4 = this.this$0.settingsCache;
                    numBoxInt = Boxing.boxInt(DateTimeConstants.SECONDS_PER_DAY);
                    this.L$0 = null;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.label = 5;
                    if (settingsCache4.updateSessionCacheDuration(numBoxInt, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                settingsCache5 = this.this$0.settingsCache;
                lBoxLong = Boxing.boxLong(System.currentTimeMillis());
                this.L$0 = null;
                this.L$1 = null;
                this.L$2 = null;
                this.label = 6;
                if (settingsCache5.updateSessionCacheUpdatedTime(lBoxLong, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 3:
                objectRef7 = (Ref.ObjectRef) this.L$0;
                ResultKt.throwOnFailure(obj);
                if (((Integer) objectRef7.element) != null) {
                    settingsCache3 = this.this$0.settingsCache;
                    num2 = (Integer) objectRef7.element;
                    this.L$0 = null;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.label = 4;
                    if (settingsCache3.updateSessionCacheDuration(num2, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    settingsCache4 = this.this$0.settingsCache;
                    numBoxInt = Boxing.boxInt(DateTimeConstants.SECONDS_PER_DAY);
                    this.L$0 = null;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.label = 5;
                    if (settingsCache4.updateSessionCacheDuration(numBoxInt, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                settingsCache5 = this.this$0.settingsCache;
                lBoxLong = Boxing.boxLong(System.currentTimeMillis());
                this.L$0 = null;
                this.L$1 = null;
                this.L$2 = null;
                this.label = 6;
                if (settingsCache5.updateSessionCacheUpdatedTime(lBoxLong, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 4:
                ResultKt.throwOnFailure(obj);
                unit = Unit.INSTANCE;
                if (unit == null) {
                    settingsCache4 = this.this$0.settingsCache;
                    numBoxInt = Boxing.boxInt(DateTimeConstants.SECONDS_PER_DAY);
                    this.L$0 = null;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.label = 5;
                    if (settingsCache4.updateSessionCacheDuration(numBoxInt, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                settingsCache5 = this.this$0.settingsCache;
                lBoxLong = Boxing.boxLong(System.currentTimeMillis());
                this.L$0 = null;
                this.L$1 = null;
                this.L$2 = null;
                this.label = 6;
                if (settingsCache5.updateSessionCacheUpdatedTime(lBoxLong, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 5:
                ResultKt.throwOnFailure(obj);
                settingsCache5 = this.this$0.settingsCache;
                lBoxLong = Boxing.boxLong(System.currentTimeMillis());
                this.L$0 = null;
                this.L$1 = null;
                this.L$2 = null;
                this.label = 6;
                if (settingsCache5.updateSessionCacheUpdatedTime(lBoxLong, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 6:
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
