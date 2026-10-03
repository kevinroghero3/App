package androidx.room;

/* JADX INFO: loaded from: classes4.dex */
public final class FtsOptions {
    public static final FtsOptions INSTANCE = new FtsOptions();
    public static final String TOKENIZER_ICU = "icu";
    public static final String TOKENIZER_PORTER = "porter";
    public static final String TOKENIZER_SIMPLE = "simple";
    public static final String TOKENIZER_UNICODE61 = "unicode61";

    /* JADX INFO: loaded from: classes.dex */
    public enum MatchInfo {
        FTS3,
        FTS4
    }

    /* JADX INFO: loaded from: classes.dex */
    public enum Order {
        ASC,
        DESC
    }

    private FtsOptions() {
    }
}
