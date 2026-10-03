package com.facebook.fresco.ui.common;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public class BaseControllerListener2<INFO> implements ControllerListener2<INFO> {
    public static final Companion Companion = new Companion(null);
    private static final ControllerListener2<?> NO_OP_LISTENER = new BaseControllerListener2();

    @JvmStatic
    public static final <I> ControllerListener2<I> getNoOpListener() {
        return Companion.getNoOpListener();
    }

    @Override // com.facebook.fresco.ui.common.ControllerListener2
    public void onEmptyEvent(@Nullable Object obj) {
    }

    @Override // com.facebook.fresco.ui.common.ControllerListener2
    public void onFailure(@NotNull String id, @Nullable Throwable th, @Nullable ControllerListener2.Extras extras) {
        Intrinsics.checkNotNullParameter(id, "id");
    }

    @Override // com.facebook.fresco.ui.common.ControllerListener2
    public void onFinalImageSet(@NotNull String id, @Nullable INFO info, @Nullable ControllerListener2.Extras extras) {
        Intrinsics.checkNotNullParameter(id, "id");
    }

    @Override // com.facebook.fresco.ui.common.ControllerListener2
    public void onIntermediateImageFailed(@NotNull String id) {
        Intrinsics.checkNotNullParameter(id, "id");
    }

    @Override // com.facebook.fresco.ui.common.ControllerListener2
    public void onIntermediateImageSet(@NotNull String id, @Nullable INFO info) {
        Intrinsics.checkNotNullParameter(id, "id");
    }

    @Override // com.facebook.fresco.ui.common.ControllerListener2
    public void onRelease(@NotNull String id, @Nullable ControllerListener2.Extras extras) {
        Intrinsics.checkNotNullParameter(id, "id");
    }

    @Override // com.facebook.fresco.ui.common.ControllerListener2
    public void onSubmit(@NotNull String id, @Nullable Object obj, @Nullable ControllerListener2.Extras extras) {
        Intrinsics.checkNotNullParameter(id, "id");
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final <I> ControllerListener2<I> getNoOpListener() {
            ControllerListener2<I> controllerListener2 = BaseControllerListener2.NO_OP_LISTENER;
            Intrinsics.checkNotNull(controllerListener2, "null cannot be cast to non-null type com.facebook.fresco.ui.common.ControllerListener2<I of com.facebook.fresco.ui.common.BaseControllerListener2.Companion.getNoOpListener>");
            return controllerListener2;
        }
    }
}
