package com.facebook.gamingservices.internal;

/* JADX INFO: loaded from: classes4.dex */
public enum TournamentSortOrder {
    LowerIsBetter("LOWER_IS_BETTER"),
    HigherIsBetter("HIGHER_IS_BETTER");

    private final String rawValue;

    TournamentSortOrder(String str) {
        this.rawValue = str;
    }

    public final String getRawValue() {
        return this.rawValue;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.rawValue;
    }
}
