package androidx.core.os;

import android.os.OutcomeReceiver;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class OutcomeReceiverKt {
    public static final <R, E extends Throwable> OutcomeReceiver asOutcomeReceiver(@NotNull Continuation<? super R> continuation) {
        return OutcomeReceiverKt$$ExternalSyntheticApiModelOutline0.m(new ContinuationOutcomeReceiver(continuation));
    }
}
