package com.facebook.datasource;

/* JADX INFO: loaded from: classes4.dex */
public final class SuccessfulVoidDataSource extends AbstractDataSource<Void> {
    public static final SuccessfulVoidDataSource INSTANCE;

    private SuccessfulVoidDataSource() {
    }

    static {
        SuccessfulVoidDataSource successfulVoidDataSource = new SuccessfulVoidDataSource();
        INSTANCE = successfulVoidDataSource;
        successfulVoidDataSource.setResult(null, true);
    }
}
