package kotlinx.serialization.descriptors;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlinx.serialization.ExperimentalSerializationApi;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public interface SerialDescriptor {
    List<Annotation> getAnnotations();

    @ExperimentalSerializationApi
    List<Annotation> getElementAnnotations(int i);

    @ExperimentalSerializationApi
    SerialDescriptor getElementDescriptor(int i);

    @ExperimentalSerializationApi
    int getElementIndex(@NotNull String str);

    @ExperimentalSerializationApi
    String getElementName(int i);

    int getElementsCount();

    SerialKind getKind();

    String getSerialName();

    @ExperimentalSerializationApi
    boolean isElementOptional(int i);

    boolean isInline();

    boolean isNullable();

    /* JADX INFO: loaded from: classes6.dex */
    public static final class DefaultImpls {
        @ExperimentalSerializationApi
        public static /* synthetic */ void getAnnotations$annotations() {
        }

        @ExperimentalSerializationApi
        public static /* synthetic */ void getElementsCount$annotations() {
        }

        @ExperimentalSerializationApi
        public static /* synthetic */ void getKind$annotations() {
        }

        @ExperimentalSerializationApi
        public static /* synthetic */ void getSerialName$annotations() {
        }

        public static boolean isInline(@NotNull SerialDescriptor serialDescriptor) {
            return false;
        }

        public static boolean isNullable(@NotNull SerialDescriptor serialDescriptor) {
            return false;
        }

        @ExperimentalSerializationApi
        public static /* synthetic */ void isNullable$annotations() {
        }

        public static List<Annotation> getAnnotations(@NotNull SerialDescriptor serialDescriptor) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
    }
}
