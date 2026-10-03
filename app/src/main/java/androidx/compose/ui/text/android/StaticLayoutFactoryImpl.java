package androidx.compose.ui.text.android;

import android.text.StaticLayout;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
interface StaticLayoutFactoryImpl {
    StaticLayout create(@NotNull StaticLayoutParams staticLayoutParams);

    boolean isFallbackLineSpacingEnabled(@NotNull StaticLayout staticLayout, boolean z);
}
