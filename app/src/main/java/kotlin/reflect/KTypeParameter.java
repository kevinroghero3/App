package kotlin.reflect;

import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public interface KTypeParameter extends KClassifier {
    String getName();

    List<KType> getUpperBounds();

    KVariance getVariance();

    boolean isReified();
}
