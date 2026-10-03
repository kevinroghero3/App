package androidx.savedstate.serialization;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.modules.SerializersModule;
import kotlinx.serialization.modules.SerializersModuleKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class SavedStateConfiguration {
    public static final Companion Companion = new Companion(null);
    public static final SavedStateConfiguration DEFAULT = new SavedStateConfiguration(null, 0, false, 7, null);
    private final int classDiscriminatorMode;
    private final boolean encodeDefaults;
    private final SerializersModule serializersModule;

    public /* synthetic */ SavedStateConfiguration(SerializersModule serializersModule, int i, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(serializersModule, i, z);
    }

    private SavedStateConfiguration(SerializersModule serializersModule, int i, boolean z) {
        this.serializersModule = serializersModule;
        this.classDiscriminatorMode = i;
        this.encodeDefaults = z;
    }

    /* synthetic */ SavedStateConfiguration(SerializersModule serializersModule, int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? SavedStateConfigurationKt.DEFAULT_SERIALIZERS_MODULE : serializersModule, (i2 & 2) != 0 ? 2 : i, (i2 & 4) != 0 ? false : z);
    }

    public final SerializersModule getSerializersModule() {
        return this.serializersModule;
    }

    public final int getClassDiscriminatorMode() {
        return this.classDiscriminatorMode;
    }

    public final boolean getEncodeDefaults() {
        return this.encodeDefaults;
    }

    public static final class Builder {
        private int classDiscriminatorMode;
        private boolean encodeDefaults;
        private SerializersModule serializersModule;

        public static /* synthetic */ void getClassDiscriminatorMode$annotations() {
        }

        public static /* synthetic */ void getEncodeDefaults$annotations() {
        }

        public Builder(@NotNull SavedStateConfiguration configuration) {
            Intrinsics.checkNotNullParameter(configuration, "configuration");
            this.serializersModule = configuration.getSerializersModule();
            this.encodeDefaults = configuration.getEncodeDefaults();
            this.classDiscriminatorMode = configuration.getClassDiscriminatorMode();
        }

        public final SerializersModule getSerializersModule() {
            return this.serializersModule;
        }

        public final void setSerializersModule(@NotNull SerializersModule serializersModule) {
            Intrinsics.checkNotNullParameter(serializersModule, "<set-?>");
            this.serializersModule = serializersModule;
        }

        public final boolean getEncodeDefaults() {
            return this.encodeDefaults;
        }

        public final void setEncodeDefaults(boolean z) {
            this.encodeDefaults = z;
        }

        public final int getClassDiscriminatorMode() {
            return this.classDiscriminatorMode;
        }

        public final void setClassDiscriminatorMode(int i) {
            this.classDiscriminatorMode = i;
        }

        public final SavedStateConfiguration build$savedstate_release() {
            return new SavedStateConfiguration(SerializersModuleKt.overwriteWith(SavedStateConfigurationKt.DEFAULT_SERIALIZERS_MODULE, this.serializersModule), this.classDiscriminatorMode, this.encodeDefaults, null);
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
