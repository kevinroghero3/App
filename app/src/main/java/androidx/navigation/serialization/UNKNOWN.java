package androidx.navigation.serialization;

import android.os.Bundle;
import androidx.navigation.NavType;
import com.google.maps.android.BuildConfig;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class UNKNOWN extends NavType<String> {
    public static final UNKNOWN INSTANCE = new UNKNOWN();

    @Override // androidx.navigation.NavType
    public String get(@NotNull Bundle bundle, @NotNull String key) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(key, "key");
        return null;
    }

    @Override // androidx.navigation.NavType
    public void put(@NotNull Bundle bundle, @NotNull String key, @NotNull String value) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
    }

    private UNKNOWN() {
        super(false);
    }

    @Override // androidx.navigation.NavType
    public String getName() {
        return "unknown";
    }

    @Override // androidx.navigation.NavType
    public String parseValue(@NotNull String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return BuildConfig.TRAVIS;
    }
}
