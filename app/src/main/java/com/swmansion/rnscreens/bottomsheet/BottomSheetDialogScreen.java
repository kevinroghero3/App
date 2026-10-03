package com.swmansion.rnscreens.bottomsheet;

import android.content.Context;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.swmansion.rnscreens.ScreenModalFragment;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public final class BottomSheetDialogScreen extends BottomSheetDialog {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = Reflection.getOrCreateKotlinClass(BottomSheetDialogScreen.class).getSimpleName();
    private final WeakReference<ScreenModalFragment> fragmentRef;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BottomSheetDialogScreen(@NotNull Context context, @NotNull ScreenModalFragment fragment) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.fragmentRef = new WeakReference<>(fragment);
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialog, android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        ScreenModalFragment screenModalFragment = this.fragmentRef.get();
        Intrinsics.checkNotNull(screenModalFragment);
        screenModalFragment.dismissFromContainer();
        show();
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getTAG() {
            return BottomSheetDialogScreen.TAG;
        }
    }
}
