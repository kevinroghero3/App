package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.animation.MotionSpec;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
interface MotionStrategy {
    void addAnimationListener(@NonNull Animator.AnimatorListener animatorListener);

    AnimatorSet createAnimator();

    MotionSpec getCurrentMotionSpec();

    int getDefaultMotionSpecResource();

    List<Animator.AnimatorListener> getListeners();

    MotionSpec getMotionSpec();

    void onAnimationCancel();

    void onAnimationEnd();

    void onAnimationStart(Animator animator);

    void onChange(@Nullable ExtendedFloatingActionButton.OnChangedCallback onChangedCallback);

    void performNow();

    void removeAnimationListener(@NonNull Animator.AnimatorListener animatorListener);

    void setMotionSpec(@Nullable MotionSpec motionSpec);

    boolean shouldCancel();
}
