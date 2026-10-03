package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes.dex */
public interface TwoWayConverter<T, V extends AnimationVector> {
    Function1<V, T> getConvertFromVector();

    Function1<T, V> getConvertToVector();
}
