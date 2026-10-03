package kotlin.reflect;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface KType extends KAnnotatedElement {

    /* JADX INFO: loaded from: classes6.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void getArguments$annotations() {
        }

        public static /* synthetic */ void getClassifier$annotations() {
        }
    }

    List<KTypeProjection> getArguments();

    KClassifier getClassifier();

    boolean isMarkedNullable();
}
