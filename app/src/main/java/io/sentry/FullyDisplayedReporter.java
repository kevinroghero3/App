package io.sentry;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class FullyDisplayedReporter {
    private static final FullyDisplayedReporter instance = new FullyDisplayedReporter();
    private final List<FullyDisplayedReporterListener> listeners = new CopyOnWriteArrayList();

    /* JADX INFO: loaded from: classes6.dex */
    public interface FullyDisplayedReporterListener {
        void onFullyDrawn();
    }

    private FullyDisplayedReporter() {
    }

    public static FullyDisplayedReporter getInstance() {
        return instance;
    }

    public void registerFullyDrawnListener(@NotNull FullyDisplayedReporterListener fullyDisplayedReporterListener) {
        this.listeners.add(fullyDisplayedReporterListener);
    }

    public void reportFullyDrawn() {
        Iterator<FullyDisplayedReporterListener> it2 = this.listeners.iterator();
        this.listeners.clear();
        while (it2.hasNext()) {
            it2.next().onFullyDrawn();
        }
    }
}
