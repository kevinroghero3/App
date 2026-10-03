package com.facebook.internal.logging.dumpsys;

import java.io.PrintWriter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public interface EndToEndDumper {
    public static final Companion Companion = Companion.$$INSTANCE;

    boolean maybeDump(@NotNull String str, @NotNull PrintWriter printWriter, @Nullable String[] strArr);

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static EndToEndDumper instance;

        private Companion() {
        }

        public final EndToEndDumper getInstance() {
            return instance;
        }

        public final void setInstance(@Nullable EndToEndDumper endToEndDumper) {
            instance = endToEndDumper;
        }
    }
}
