package androidx.camera.video;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes2.dex */
public class FallbackStrategy {
    static final int FALLBACK_RULE_HIGHER = 2;
    static final int FALLBACK_RULE_HIGHER_OR_LOWER = 1;
    static final int FALLBACK_RULE_LOWER = 4;
    static final int FALLBACK_RULE_LOWER_OR_HIGHER = 3;
    static final int FALLBACK_RULE_NONE = 0;
    static final FallbackStrategy NONE = new AutoValue_FallbackStrategy_RuleStrategy(Quality.NONE, 0);

    private FallbackStrategy() {
    }

    public static FallbackStrategy higherQualityOrLowerThan(@NonNull Quality quality) {
        return new AutoValue_FallbackStrategy_RuleStrategy(quality, 1);
    }

    public static FallbackStrategy higherQualityThan(@NonNull Quality quality) {
        return new AutoValue_FallbackStrategy_RuleStrategy(quality, 2);
    }

    public static FallbackStrategy lowerQualityOrHigherThan(@NonNull Quality quality) {
        return new AutoValue_FallbackStrategy_RuleStrategy(quality, 3);
    }

    public static FallbackStrategy lowerQualityThan(@NonNull Quality quality) {
        return new AutoValue_FallbackStrategy_RuleStrategy(quality, 4);
    }

    static abstract class RuleStrategy extends FallbackStrategy {
        abstract Quality getFallbackQuality();

        abstract int getFallbackRule();

        RuleStrategy() {
            super();
        }
    }
}
