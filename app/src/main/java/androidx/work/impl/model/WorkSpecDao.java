package androidx.work.impl.model;

import androidx.lifecycle.LiveData;
import androidx.work.Data;
import androidx.work.WorkInfo;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public interface WorkSpecDao {
    void delete(@NotNull String str);

    List<WorkSpec> getAllEligibleWorkSpecsForScheduling(int i);

    List<String> getAllUnfinishedWork();

    List<String> getAllWorkSpecIds();

    LiveData<List<String>> getAllWorkSpecIdsLiveData();

    List<WorkSpec> getEligibleWorkForScheduling(int i);

    List<Data> getInputsFromPrerequisites(@NotNull String str);

    List<WorkSpec> getRecentlyCompletedWork(long j);

    List<WorkSpec> getRunningWork();

    LiveData<Long> getScheduleRequestedAtLiveData(@NotNull String str);

    List<WorkSpec> getScheduledWork();

    WorkInfo.State getState(@NotNull String str);

    List<String> getUnfinishedWorkWithName(@NotNull String str);

    List<String> getUnfinishedWorkWithTag(@NotNull String str);

    WorkSpec getWorkSpec(@NotNull String str);

    List<WorkSpec.IdAndState> getWorkSpecIdAndStatesForName(@NotNull String str);

    WorkSpec.WorkInfoPojo getWorkStatusPojoForId(@NotNull String str);

    List<WorkSpec.WorkInfoPojo> getWorkStatusPojoForIds(@NotNull List<String> list);

    List<WorkSpec.WorkInfoPojo> getWorkStatusPojoForName(@NotNull String str);

    List<WorkSpec.WorkInfoPojo> getWorkStatusPojoForTag(@NotNull String str);

    LiveData<List<WorkSpec.WorkInfoPojo>> getWorkStatusPojoLiveDataForIds(@NotNull List<String> list);

    LiveData<List<WorkSpec.WorkInfoPojo>> getWorkStatusPojoLiveDataForName(@NotNull String str);

    LiveData<List<WorkSpec.WorkInfoPojo>> getWorkStatusPojoLiveDataForTag(@NotNull String str);

    boolean hasUnfinishedWork();

    void incrementGeneration(@NotNull String str);

    void incrementPeriodCount(@NotNull String str);

    int incrementWorkSpecRunAttemptCount(@NotNull String str);

    void insertWorkSpec(@NotNull WorkSpec workSpec);

    int markWorkSpecScheduled(@NotNull String str, long j);

    void pruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast();

    int resetScheduledState();

    int resetWorkSpecRunAttemptCount(@NotNull String str);

    void setLastEnqueuedTime(@NotNull String str, long j);

    void setOutput(@NotNull String str, @NotNull Data data);

    int setState(@NotNull WorkInfo.State state, @NotNull String str);

    void updateWorkSpec(@NotNull WorkSpec workSpec);
}
