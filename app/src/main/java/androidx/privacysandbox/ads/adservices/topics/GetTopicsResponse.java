package androidx.privacysandbox.ads.adservices.topics;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class GetTopicsResponse {
    private final List<Topic> topics;

    public GetTopicsResponse(@NotNull List<Topic> topics) {
        Intrinsics.checkNotNullParameter(topics, "topics");
        this.topics = topics;
    }

    public final List<Topic> getTopics() {
        return this.topics;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetTopicsResponse)) {
            return false;
        }
        GetTopicsResponse getTopicsResponse = (GetTopicsResponse) obj;
        if (this.topics.size() != getTopicsResponse.topics.size()) {
            return false;
        }
        return Intrinsics.areEqual(new HashSet(this.topics), new HashSet(getTopicsResponse.topics));
    }

    public int hashCode() {
        return Objects.hash(this.topics);
    }

    public String toString() {
        return "Topics=" + this.topics;
    }
}
