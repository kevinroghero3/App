package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes5.dex */
public interface VisibilityAnimatorProvider {
    Animator createAppear(@NonNull ViewGroup viewGroup, @NonNull View view);

    Animator createDisappear(@NonNull ViewGroup viewGroup, @NonNull View view);
}
