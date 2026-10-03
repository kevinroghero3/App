package androidx.work;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes4.dex */
public final class WorkQuery {
    private final List<UUID> mIds;
    private final List<WorkInfo.State> mStates;
    private final List<String> mTags;
    private final List<String> mUniqueWorkNames;

    WorkQuery(@NonNull Builder builder) {
        this.mIds = builder.mIds;
        this.mUniqueWorkNames = builder.mUniqueWorkNames;
        this.mTags = builder.mTags;
        this.mStates = builder.mStates;
    }

    public List<UUID> getIds() {
        return this.mIds;
    }

    public List<String> getUniqueWorkNames() {
        return this.mUniqueWorkNames;
    }

    public List<String> getTags() {
        return this.mTags;
    }

    public List<WorkInfo.State> getStates() {
        return this.mStates;
    }

    public static WorkQuery fromIds(@NonNull List<UUID> list) {
        return Builder.fromIds(list).build();
    }

    public static WorkQuery fromIds(@NonNull UUID... uuidArr) {
        return fromIds((List<UUID>) Arrays.asList(uuidArr));
    }

    public static WorkQuery fromTags(@NonNull List<String> list) {
        return Builder.fromTags(list).build();
    }

    public static WorkQuery fromTags(@NonNull String... strArr) {
        return fromTags((List<String>) Arrays.asList(strArr));
    }

    public static WorkQuery fromUniqueWorkNames(@NonNull String... strArr) {
        return Builder.fromUniqueWorkNames(Arrays.asList(strArr)).build();
    }

    public static WorkQuery fromUniqueWorkNames(@NonNull List<String> list) {
        return Builder.fromUniqueWorkNames(list).build();
    }

    public static WorkQuery fromStates(@NonNull List<WorkInfo.State> list) {
        return Builder.fromStates(list).build();
    }

    public static WorkQuery fromStates(@NonNull WorkInfo.State... stateArr) {
        return Builder.fromStates(Arrays.asList(stateArr)).build();
    }

    public static final class Builder {
        List<UUID> mIds = new ArrayList();
        List<String> mUniqueWorkNames = new ArrayList();
        List<String> mTags = new ArrayList();
        List<WorkInfo.State> mStates = new ArrayList();

        private Builder() {
        }

        public static Builder fromIds(@NonNull List<UUID> list) {
            Builder builder = new Builder();
            builder.addIds(list);
            return builder;
        }

        public static Builder fromUniqueWorkNames(@NonNull List<String> list) {
            Builder builder = new Builder();
            builder.addUniqueWorkNames(list);
            return builder;
        }

        public static Builder fromTags(@NonNull List<String> list) {
            Builder builder = new Builder();
            builder.addTags(list);
            return builder;
        }

        public static Builder fromStates(@NonNull List<WorkInfo.State> list) {
            Builder builder = new Builder();
            builder.addStates(list);
            return builder;
        }

        public Builder addIds(@NonNull List<UUID> list) {
            this.mIds.addAll(list);
            return this;
        }

        public Builder addUniqueWorkNames(@NonNull List<String> list) {
            this.mUniqueWorkNames.addAll(list);
            return this;
        }

        public Builder addTags(@NonNull List<String> list) {
            this.mTags.addAll(list);
            return this;
        }

        public Builder addStates(@NonNull List<WorkInfo.State> list) {
            this.mStates.addAll(list);
            return this;
        }

        public WorkQuery build() {
            if (this.mIds.isEmpty() && this.mUniqueWorkNames.isEmpty() && this.mTags.isEmpty() && this.mStates.isEmpty()) {
                throw new IllegalArgumentException("Must specify ids, uniqueNames, tags or states when building a WorkQuery");
            }
            return new WorkQuery(this);
        }
    }
}
