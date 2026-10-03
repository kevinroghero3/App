package com.reactnativekeyboardcontroller.modal;

import com.reactnativekeyboardcontroller.constants.Keyboard;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes3.dex */
public final class ModalAttachedWatcherKt {
    private static final String TAG = Reflection.getOrCreateKotlinClass(ModalAttachedWatcher.class).getQualifiedName();
    private static final boolean areEventsComingFromOwnWindow = !Keyboard.INSTANCE.getIS_ANIMATION_EMULATED();
}
