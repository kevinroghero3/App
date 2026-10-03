package com.facebook.appevents.gps.topics;

import ch.qos.logback.core.CoreConstants;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class TopicData {
    private final long modelVersion;
    private final long taxonomyVersion;
    private final int topicId;

    public static /* synthetic */ TopicData copy$default(TopicData topicData, long j, long j2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = topicData.taxonomyVersion;
        }
        long j3 = j;
        if ((i2 & 2) != 0) {
            j2 = topicData.modelVersion;
        }
        long j4 = j2;
        if ((i2 & 4) != 0) {
            i = topicData.topicId;
        }
        return topicData.copy(j3, j4, i);
    }

    public final long component1() {
        return this.taxonomyVersion;
    }

    public final long component2() {
        return this.modelVersion;
    }

    public final int component3() {
        return this.topicId;
    }

    public final TopicData copy(long j, long j2, int i) {
        return new TopicData(j, j2, i);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TopicData)) {
            return false;
        }
        TopicData topicData = (TopicData) obj;
        return this.taxonomyVersion == topicData.taxonomyVersion && this.modelVersion == topicData.modelVersion && this.topicId == topicData.topicId;
    }

    public int hashCode() {
        return (((Long.hashCode(this.taxonomyVersion) * 31) + Long.hashCode(this.modelVersion)) * 31) + Integer.hashCode(this.topicId);
    }

    public String toString() {
        return "TopicData(taxonomyVersion=" + this.taxonomyVersion + ", modelVersion=" + this.modelVersion + ", topicId=" + this.topicId + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public TopicData(long j, long j2, int i) {
        this.taxonomyVersion = j;
        this.modelVersion = j2;
        this.topicId = i;
    }

    public final long getTaxonomyVersion() {
        return this.taxonomyVersion;
    }

    public final long getModelVersion() {
        return this.modelVersion;
    }

    public final int getTopicId() {
        return this.topicId;
    }
}
