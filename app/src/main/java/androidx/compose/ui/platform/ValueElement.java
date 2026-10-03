package androidx.compose.ui.platform;

import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class ValueElement {
    public static final int $stable = 8;
    private final String name;
    private final Object value;

    public static /* synthetic */ ValueElement copy$default(ValueElement valueElement, String str, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            str = valueElement.name;
        }
        if ((i & 2) != 0) {
            obj = valueElement.value;
        }
        return valueElement.copy(str, obj);
    }

    public final String component1() {
        return this.name;
    }

    public final Object component2() {
        return this.value;
    }

    public final ValueElement copy(@NotNull String str, @Nullable Object obj) {
        return new ValueElement(str, obj);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ValueElement)) {
            return false;
        }
        ValueElement valueElement = (ValueElement) obj;
        return Intrinsics.areEqual(this.name, valueElement.name) && Intrinsics.areEqual(this.value, valueElement.value);
    }

    public int hashCode() {
        int iHashCode = this.name.hashCode();
        Object obj = this.value;
        return (iHashCode * 31) + (obj == null ? 0 : obj.hashCode());
    }

    public String toString() {
        return "ValueElement(name=" + this.name + ", value=" + this.value + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public ValueElement(@NotNull String str, @Nullable Object obj) {
        this.name = str;
        this.value = obj;
    }

    public final String getName() {
        return this.name;
    }

    public final Object getValue() {
        return this.value;
    }
}
