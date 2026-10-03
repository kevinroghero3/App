package kotlinx.coroutines.internal;

import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: classes6.dex */
public final class FastServiceLoaderKt {
    private static final boolean ANDROID_DETECTED = false;

    public static final boolean getANDROID_DETECTED() {
        return true;
    }

    static {
        Object objM5472constructorimpl;
        try {
            Result.Companion companion = Result.Companion;
            objM5472constructorimpl = Result.m5472constructorimpl(Class.forName("android.os.Build"));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            objM5472constructorimpl = Result.m5472constructorimpl(ResultKt.createFailure(th));
        }
        Result.m5479isSuccessimpl(objM5472constructorimpl);
    }
}
