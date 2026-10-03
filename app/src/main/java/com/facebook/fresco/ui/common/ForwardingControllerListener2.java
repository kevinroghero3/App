package com.facebook.fresco.ui.common;

import io.sentry.android.core.SentryLogcatAdapter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public class ForwardingControllerListener2<I> extends BaseControllerListener2<I> {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "FwdControllerListener2";
    private final List<ControllerListener2<I>> listeners = new ArrayList(2);

    public final void addListener(@NotNull ControllerListener2<I> listener) {
        synchronized (this) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.listeners.add(listener);
        }
    }

    public final void removeListener(@NotNull ControllerListener2<I> listener) {
        synchronized (this) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.listeners.remove(listener);
        }
    }

    public final void removeAllListeners() {
        synchronized (this) {
            this.listeners.clear();
        }
    }

    private final void forEachListener(String str, Function1<? super ControllerListener2<I>, Unit> function1) {
        int size = this.listeners.size();
        for (int i = 0; i < size; i++) {
            try {
                try {
                    function1.invoke(this.listeners.get(i));
                    Unit unit = Unit.INSTANCE;
                } catch (Exception e) {
                    SentryLogcatAdapter.e(TAG, "InternalListener exception in " + str, e);
                }
            } catch (IndexOutOfBoundsException unused) {
                return;
            }
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // com.facebook.fresco.ui.common.BaseControllerListener2, com.facebook.fresco.ui.common.ControllerListener2
    public void onSubmit(@NotNull String id, @Nullable Object obj, @Nullable ControllerListener2.Extras extras) {
        Intrinsics.checkNotNullParameter(id, "id");
        int size = this.listeners.size();
        for (int i = 0; i < size; i++) {
            try {
                try {
                    this.listeners.get(i).onSubmit(id, obj, extras);
                    Unit unit = Unit.INSTANCE;
                } catch (Exception e) {
                    SentryLogcatAdapter.e(TAG, "InternalListener exception in onSubmit", e);
                }
            } catch (IndexOutOfBoundsException unused) {
                return;
            }
        }
    }

    @Override // com.facebook.fresco.ui.common.BaseControllerListener2, com.facebook.fresco.ui.common.ControllerListener2
    public void onFinalImageSet(@NotNull String id, @Nullable I i, @Nullable ControllerListener2.Extras extras) {
        Intrinsics.checkNotNullParameter(id, "id");
        int size = this.listeners.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                try {
                    this.listeners.get(i2).onFinalImageSet(id, i, extras);
                    Unit unit = Unit.INSTANCE;
                } catch (Exception e) {
                    SentryLogcatAdapter.e(TAG, "InternalListener exception in onFinalImageSet", e);
                }
            } catch (IndexOutOfBoundsException unused) {
                return;
            }
        }
    }

    @Override // com.facebook.fresco.ui.common.BaseControllerListener2, com.facebook.fresco.ui.common.ControllerListener2
    public void onFailure(@NotNull String id, @Nullable Throwable th, @Nullable ControllerListener2.Extras extras) {
        Intrinsics.checkNotNullParameter(id, "id");
        int size = this.listeners.size();
        for (int i = 0; i < size; i++) {
            try {
                try {
                    this.listeners.get(i).onFailure(id, th, extras);
                    Unit unit = Unit.INSTANCE;
                } catch (Exception e) {
                    SentryLogcatAdapter.e(TAG, "InternalListener exception in onFailure", e);
                }
            } catch (IndexOutOfBoundsException unused) {
                return;
            }
        }
    }

    @Override // com.facebook.fresco.ui.common.BaseControllerListener2, com.facebook.fresco.ui.common.ControllerListener2
    public void onRelease(@NotNull String id, @Nullable ControllerListener2.Extras extras) {
        Intrinsics.checkNotNullParameter(id, "id");
        int size = this.listeners.size();
        for (int i = 0; i < size; i++) {
            try {
                try {
                    this.listeners.get(i).onRelease(id, extras);
                    Unit unit = Unit.INSTANCE;
                } catch (Exception e) {
                    SentryLogcatAdapter.e(TAG, "InternalListener exception in onRelease", e);
                }
            } catch (IndexOutOfBoundsException unused) {
                return;
            }
        }
    }

    @Override // com.facebook.fresco.ui.common.BaseControllerListener2, com.facebook.fresco.ui.common.ControllerListener2
    public void onIntermediateImageSet(@NotNull String id, @Nullable I i) {
        Intrinsics.checkNotNullParameter(id, "id");
        int size = this.listeners.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                try {
                    this.listeners.get(i2).onIntermediateImageSet(id, i);
                    Unit unit = Unit.INSTANCE;
                } catch (Exception e) {
                    SentryLogcatAdapter.e(TAG, "InternalListener exception in onIntermediateImageSet", e);
                }
            } catch (IndexOutOfBoundsException unused) {
                return;
            }
        }
    }

    @Override // com.facebook.fresco.ui.common.BaseControllerListener2, com.facebook.fresco.ui.common.ControllerListener2
    public void onIntermediateImageFailed(@NotNull String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        int size = this.listeners.size();
        for (int i = 0; i < size; i++) {
            try {
                try {
                    this.listeners.get(i).onIntermediateImageFailed(id);
                    Unit unit = Unit.INSTANCE;
                } catch (Exception e) {
                    SentryLogcatAdapter.e(TAG, "InternalListener exception in onIntermediateImageFailed", e);
                }
            } catch (IndexOutOfBoundsException unused) {
                return;
            }
        }
    }

    @Override // com.facebook.fresco.ui.common.BaseControllerListener2, com.facebook.fresco.ui.common.ControllerListener2
    public void onEmptyEvent(@Nullable Object obj) {
        int size = this.listeners.size();
        for (int i = 0; i < size; i++) {
            try {
                try {
                    this.listeners.get(i).onEmptyEvent(obj);
                    Unit unit = Unit.INSTANCE;
                } catch (Exception e) {
                    SentryLogcatAdapter.e(TAG, "InternalListener exception in onEmptyEvent", e);
                }
            } catch (IndexOutOfBoundsException unused) {
                return;
            }
        }
    }
}
