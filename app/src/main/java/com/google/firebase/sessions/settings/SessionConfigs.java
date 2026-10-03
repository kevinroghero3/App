package com.google.firebase.sessions.settings;

import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public final class SessionConfigs {
    private final Integer cacheDuration;
    private final Long cacheUpdatedTime;
    private final Boolean sessionEnabled;
    private final Integer sessionRestartTimeout;
    private final Double sessionSamplingRate;

    public static /* synthetic */ SessionConfigs copy$default(SessionConfigs sessionConfigs, Boolean bool, Double d, Integer num, Integer num2, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = sessionConfigs.sessionEnabled;
        }
        if ((i & 2) != 0) {
            d = sessionConfigs.sessionSamplingRate;
        }
        Double d2 = d;
        if ((i & 4) != 0) {
            num = sessionConfigs.sessionRestartTimeout;
        }
        Integer num3 = num;
        if ((i & 8) != 0) {
            num2 = sessionConfigs.cacheDuration;
        }
        Integer num4 = num2;
        if ((i & 16) != 0) {
            l = sessionConfigs.cacheUpdatedTime;
        }
        return sessionConfigs.copy(bool, d2, num3, num4, l);
    }

    public final Boolean component1() {
        return this.sessionEnabled;
    }

    public final Double component2() {
        return this.sessionSamplingRate;
    }

    public final Integer component3() {
        return this.sessionRestartTimeout;
    }

    public final Integer component4() {
        return this.cacheDuration;
    }

    public final Long component5() {
        return this.cacheUpdatedTime;
    }

    public final SessionConfigs copy(@Nullable Boolean bool, @Nullable Double d, @Nullable Integer num, @Nullable Integer num2, @Nullable Long l) {
        return new SessionConfigs(bool, d, num, num2, l);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SessionConfigs)) {
            return false;
        }
        SessionConfigs sessionConfigs = (SessionConfigs) obj;
        return Intrinsics.areEqual(this.sessionEnabled, sessionConfigs.sessionEnabled) && Intrinsics.areEqual((Object) this.sessionSamplingRate, (Object) sessionConfigs.sessionSamplingRate) && Intrinsics.areEqual(this.sessionRestartTimeout, sessionConfigs.sessionRestartTimeout) && Intrinsics.areEqual(this.cacheDuration, sessionConfigs.cacheDuration) && Intrinsics.areEqual(this.cacheUpdatedTime, sessionConfigs.cacheUpdatedTime);
    }

    public int hashCode() {
        Boolean bool = this.sessionEnabled;
        int iHashCode = bool == null ? 0 : bool.hashCode();
        Double d = this.sessionSamplingRate;
        int iHashCode2 = d == null ? 0 : d.hashCode();
        Integer num = this.sessionRestartTimeout;
        int iHashCode3 = num == null ? 0 : num.hashCode();
        Integer num2 = this.cacheDuration;
        int iHashCode4 = num2 == null ? 0 : num2.hashCode();
        Long l = this.cacheUpdatedTime;
        return (((((((iHashCode * 31) + iHashCode2) * 31) + iHashCode3) * 31) + iHashCode4) * 31) + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        return "SessionConfigs(sessionEnabled=" + this.sessionEnabled + ", sessionSamplingRate=" + this.sessionSamplingRate + ", sessionRestartTimeout=" + this.sessionRestartTimeout + ", cacheDuration=" + this.cacheDuration + ", cacheUpdatedTime=" + this.cacheUpdatedTime + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public SessionConfigs(@Nullable Boolean bool, @Nullable Double d, @Nullable Integer num, @Nullable Integer num2, @Nullable Long l) {
        this.sessionEnabled = bool;
        this.sessionSamplingRate = d;
        this.sessionRestartTimeout = num;
        this.cacheDuration = num2;
        this.cacheUpdatedTime = l;
    }

    public final Boolean getSessionEnabled() {
        return this.sessionEnabled;
    }

    public final Double getSessionSamplingRate() {
        return this.sessionSamplingRate;
    }

    public final Integer getSessionRestartTimeout() {
        return this.sessionRestartTimeout;
    }

    public final Integer getCacheDuration() {
        return this.cacheDuration;
    }

    public final Long getCacheUpdatedTime() {
        return this.cacheUpdatedTime;
    }
}
