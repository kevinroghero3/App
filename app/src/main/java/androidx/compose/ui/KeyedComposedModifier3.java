package androidx.compose.ui;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
final class KeyedComposedModifier3 extends ComposedModifier {
    private final String fqName;
    private final Object key1;
    private final Object key2;
    private final Object key3;

    public final String getFqName() {
        return this.fqName;
    }

    public final Object getKey1() {
        return this.key1;
    }

    public final Object getKey2() {
        return this.key2;
    }

    public final Object getKey3() {
        return this.key3;
    }

    public KeyedComposedModifier3(@NotNull String str, @Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @NotNull Function1<? super InspectorInfo, Unit> function1, @NotNull Function3<? super Modifier, ? super Composer, ? super Integer, ? extends Modifier> function3) {
        super(function1, function3);
        this.fqName = str;
        this.key1 = obj;
        this.key2 = obj2;
        this.key3 = obj3;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof KeyedComposedModifier3) {
            KeyedComposedModifier3 keyedComposedModifier3 = (KeyedComposedModifier3) obj;
            if (Intrinsics.areEqual(this.fqName, keyedComposedModifier3.fqName) && Intrinsics.areEqual(this.key1, keyedComposedModifier3.key1) && Intrinsics.areEqual(this.key2, keyedComposedModifier3.key2) && Intrinsics.areEqual(this.key3, keyedComposedModifier3.key3)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = this.fqName.hashCode();
        Object obj = this.key1;
        int iHashCode2 = obj != null ? obj.hashCode() : 0;
        Object obj2 = this.key2;
        int iHashCode3 = obj2 != null ? obj2.hashCode() : 0;
        Object obj3 = this.key3;
        return (((((iHashCode * 31) + iHashCode2) * 31) + iHashCode3) * 31) + (obj3 != null ? obj3.hashCode() : 0);
    }
}
