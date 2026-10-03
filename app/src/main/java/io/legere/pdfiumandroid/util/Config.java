package io.legere.pdfiumandroid.util;

import ch.qos.logback.core.CoreConstants;
import io.legere.pdfiumandroid.DefaultLogger;
import io.legere.pdfiumandroid.LoggerInterface;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class Config {
    private final AlreadyClosedBehavior alreadyClosedBehavior;
    private final LoggerInterface logger;

    public Config() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ Config copy$default(Config config, LoggerInterface loggerInterface, AlreadyClosedBehavior alreadyClosedBehavior, int i, Object obj) {
        if ((i & 1) != 0) {
            loggerInterface = config.logger;
        }
        if ((i & 2) != 0) {
            alreadyClosedBehavior = config.alreadyClosedBehavior;
        }
        return config.copy(loggerInterface, alreadyClosedBehavior);
    }

    public final LoggerInterface component1() {
        return this.logger;
    }

    public final AlreadyClosedBehavior component2() {
        return this.alreadyClosedBehavior;
    }

    public final Config copy(@NotNull LoggerInterface logger, @NotNull AlreadyClosedBehavior alreadyClosedBehavior) {
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(alreadyClosedBehavior, "alreadyClosedBehavior");
        return new Config(logger, alreadyClosedBehavior);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Config)) {
            return false;
        }
        Config config = (Config) obj;
        return Intrinsics.areEqual(this.logger, config.logger) && this.alreadyClosedBehavior == config.alreadyClosedBehavior;
    }

    public int hashCode() {
        return (this.logger.hashCode() * 31) + this.alreadyClosedBehavior.hashCode();
    }

    public String toString() {
        return "Config(logger=" + this.logger + ", alreadyClosedBehavior=" + this.alreadyClosedBehavior + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public Config(@NotNull LoggerInterface logger, @NotNull AlreadyClosedBehavior alreadyClosedBehavior) {
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(alreadyClosedBehavior, "alreadyClosedBehavior");
        this.logger = logger;
        this.alreadyClosedBehavior = alreadyClosedBehavior;
    }

    public /* synthetic */ Config(LoggerInterface loggerInterface, AlreadyClosedBehavior alreadyClosedBehavior, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new DefaultLogger() : loggerInterface, (i & 2) != 0 ? AlreadyClosedBehavior.EXCEPTION : alreadyClosedBehavior);
    }

    public final LoggerInterface getLogger() {
        return this.logger;
    }

    public final AlreadyClosedBehavior getAlreadyClosedBehavior() {
        return this.alreadyClosedBehavior;
    }
}
