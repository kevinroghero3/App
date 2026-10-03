package androidx.work.multiprocess;

import androidx.annotation.NonNull;
import androidx.work.OneTimeWorkRequest;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public abstract class RemoteWorkContinuation {
    protected abstract RemoteWorkContinuation combineInternal(@NonNull List<RemoteWorkContinuation> list);

    public abstract ListenableFuture<Void> enqueue();

    public abstract RemoteWorkContinuation then(@NonNull List<OneTimeWorkRequest> list);

    protected RemoteWorkContinuation() {
    }

    public final RemoteWorkContinuation then(@NonNull OneTimeWorkRequest oneTimeWorkRequest) {
        return then(Collections.singletonList(oneTimeWorkRequest));
    }

    public static RemoteWorkContinuation combine(@NonNull List<RemoteWorkContinuation> list) {
        return list.get(0).combineInternal(list);
    }
}
