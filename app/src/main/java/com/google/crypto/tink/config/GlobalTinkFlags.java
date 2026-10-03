package com.google.crypto.tink.config;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public final class GlobalTinkFlags {
    public static final TinkFlag validateKeysetsOnParsing = new TinkFlagImpl(false);

    static class TinkFlagImpl implements TinkFlag {
        private final AtomicBoolean b;

        TinkFlagImpl(boolean z) {
            this.b = new AtomicBoolean(z);
        }

        @Override // com.google.crypto.tink.config.TinkFlag
        public boolean getValue() {
            return this.b.get();
        }

        @Override // com.google.crypto.tink.config.TinkFlag
        public void setValue(boolean z) {
            this.b.set(z);
        }
    }

    private GlobalTinkFlags() {
    }
}
