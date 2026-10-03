package androidx.activity.compose;

import androidx.activity.BackEventCompat;
import androidx.activity.OnBackPressedCallback;
import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
final class OnBackInstance {
    private final Channel<BackEventCompat> channel = ChannelKt.Channel$default(-2, BufferOverflow.SUSPEND, null, 4, null);
    private boolean isPredictiveBack;
    private final Job job;

    public OnBackInstance(@NotNull CoroutineScope coroutineScope, boolean z, @NotNull Function2<? super Flow<BackEventCompat>, ? super Continuation<? super Unit>, ? extends Object> function2, @NotNull OnBackPressedCallback onBackPressedCallback) {
        this.isPredictiveBack = z;
        this.job = BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new OnBackInstance$job$1(onBackPressedCallback, function2, this, null), 3, null);
    }

    public final boolean isPredictiveBack() {
        return this.isPredictiveBack;
    }

    public final void setPredictiveBack(boolean z) {
        this.isPredictiveBack = z;
    }

    public final Channel<BackEventCompat> getChannel() {
        return this.channel;
    }

    public final Job getJob() {
        return this.job;
    }

    /* JADX INFO: renamed from: send-JP2dKIU, reason: not valid java name */
    public final Object m7sendJP2dKIU(@NotNull BackEventCompat backEventCompat) {
        return this.channel.mo6988trySendJP2dKIU(backEventCompat);
    }

    public final boolean close() {
        return SendChannel.DefaultImpls.close$default(this.channel, null, 1, null);
    }

    public final void cancel() {
        this.channel.cancel(new CancellationException("onBack cancelled"));
        Job.DefaultImpls.cancel$default(this.job, (CancellationException) null, 1, (Object) null);
    }
}
