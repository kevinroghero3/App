package androidx.compose.runtime;

import kotlinx.coroutines.flow.Flow;

/* JADX INFO: loaded from: classes.dex */
public interface RecomposerInfo {
    long getChangeCount();

    boolean getHasPendingWork();

    Flow<Recomposer.State> getState();
}
