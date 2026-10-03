package androidx.work.impl.constraints.controllers;

import androidx.work.impl.constraints.ConstraintListener;
import androidx.work.impl.constraints.trackers.ConstraintTracker;
import androidx.work.impl.model.WorkSpec;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ConstraintController<T> implements ConstraintListener<T> {
    private OnConstraintUpdatedCallback callback;
    private T currentValue;
    private final List<String> matchingWorkSpecIds;
    private final List<WorkSpec> matchingWorkSpecs;
    private final ConstraintTracker<T> tracker;

    public interface OnConstraintUpdatedCallback {
        void onConstraintMet(@NotNull List<WorkSpec> list);

        void onConstraintNotMet(@NotNull List<WorkSpec> list);
    }

    public abstract boolean hasConstraint(@NotNull WorkSpec workSpec);

    public abstract boolean isConstrained(T t);

    public ConstraintController(@NotNull ConstraintTracker<T> tracker) {
        Intrinsics.checkNotNullParameter(tracker, "tracker");
        this.tracker = tracker;
        this.matchingWorkSpecs = new ArrayList();
        this.matchingWorkSpecIds = new ArrayList();
    }

    public final OnConstraintUpdatedCallback getCallback() {
        return this.callback;
    }

    public final void setCallback(@Nullable OnConstraintUpdatedCallback onConstraintUpdatedCallback) {
        if (this.callback != onConstraintUpdatedCallback) {
            this.callback = onConstraintUpdatedCallback;
            updateCallback(onConstraintUpdatedCallback, this.currentValue);
        }
    }

    public final void replace(@NotNull Iterable<WorkSpec> workSpecs) {
        Intrinsics.checkNotNullParameter(workSpecs, "workSpecs");
        this.matchingWorkSpecs.clear();
        this.matchingWorkSpecIds.clear();
        List<WorkSpec> list = this.matchingWorkSpecs;
        for (WorkSpec workSpec : workSpecs) {
            if (hasConstraint(workSpec)) {
                list.add(workSpec);
            }
        }
        List<WorkSpec> list2 = this.matchingWorkSpecs;
        List<String> list3 = this.matchingWorkSpecIds;
        Iterator<T> it2 = list2.iterator();
        while (it2.hasNext()) {
            list3.add(((WorkSpec) it2.next()).id);
        }
        if (this.matchingWorkSpecs.isEmpty()) {
            this.tracker.removeListener(this);
        } else {
            this.tracker.addListener(this);
        }
        updateCallback(this.callback, this.currentValue);
    }

    public final void reset() {
        if (this.matchingWorkSpecs.isEmpty()) {
            return;
        }
        this.matchingWorkSpecs.clear();
        this.tracker.removeListener(this);
    }

    public final boolean isWorkSpecConstrained(@NotNull String workSpecId) {
        Intrinsics.checkNotNullParameter(workSpecId, "workSpecId");
        T t = this.currentValue;
        return t != null && isConstrained(t) && this.matchingWorkSpecIds.contains(workSpecId);
    }

    private final void updateCallback(OnConstraintUpdatedCallback onConstraintUpdatedCallback, T t) {
        if (this.matchingWorkSpecs.isEmpty() || onConstraintUpdatedCallback == null) {
            return;
        }
        if (t == null || isConstrained(t)) {
            onConstraintUpdatedCallback.onConstraintNotMet(this.matchingWorkSpecs);
        } else {
            onConstraintUpdatedCallback.onConstraintMet(this.matchingWorkSpecs);
        }
    }

    @Override // androidx.work.impl.constraints.ConstraintListener
    public void onConstraintChanged(T t) {
        this.currentValue = t;
        updateCallback(this.callback, t);
    }
}
