package androidx.compose.ui.platform;

import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequencesKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public interface InspectableValue {
    default String getNameFallback() {
        return null;
    }

    default Object getValueOverride() {
        return null;
    }

    public static final class DefaultImpls {
        @Deprecated
        public static Sequence<ValueElement> getInspectableElements(@NotNull InspectableValue inspectableValue) {
            return InspectableValue.super.getInspectableElements();
        }

        @Deprecated
        public static String getNameFallback(@NotNull InspectableValue inspectableValue) {
            return InspectableValue.super.getNameFallback();
        }

        @Deprecated
        public static Object getValueOverride(@NotNull InspectableValue inspectableValue) {
            return InspectableValue.super.getValueOverride();
        }
    }

    default Sequence<ValueElement> getInspectableElements() {
        return SequencesKt__SequencesKt.emptySequence();
    }
}
