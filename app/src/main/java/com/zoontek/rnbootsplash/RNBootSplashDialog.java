package com.zoontek.rnbootsplash;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Window;
import androidx.annotation.StyleRes;
import kotlin.Deprecated;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class RNBootSplashDialog extends Dialog {
    private final boolean fade;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RNBootSplashDialog(@NotNull Activity activity, @StyleRes int i, boolean z) {
        super(activity, i);
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.fade = z;
        setOwnerActivity(activity);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
    }

    @Override // android.app.Dialog
    @Deprecated(message = "Deprecated in favor of OnBackPressedCallback")
    public void onBackPressed() {
        Activity ownerActivity = getOwnerActivity();
        if (ownerActivity != null) {
            ownerActivity.moveTaskToBack(true);
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        if (isShowing()) {
            try {
                Result.Companion companion = Result.Companion;
                super.dismiss();
                Result.m5472constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                Result.m5472constructorimpl(ResultKt.createFailure(th));
            }
        }
    }

    public final void dismiss(@NotNull final Function0<Unit> callback) {
        Object objM5472constructorimpl;
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (isShowing()) {
            setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.zoontek.rnbootsplash.RNBootSplashDialog$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    callback.invoke();
                }
            });
            try {
                Result.Companion companion = Result.Companion;
                super.dismiss();
                objM5472constructorimpl = Result.m5472constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                objM5472constructorimpl = Result.m5472constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m5475exceptionOrNullimpl(objM5472constructorimpl) != null) {
                callback.invoke();
            }
            Result.m5471boximpl(objM5472constructorimpl);
            return;
        }
        callback.invoke();
    }

    @Override // android.app.Dialog
    public void show() {
        if (isShowing()) {
            return;
        }
        try {
            Result.Companion companion = Result.Companion;
            super.show();
            Result.m5472constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.m5472constructorimpl(ResultKt.createFailure(th));
        }
    }

    public final void show(@NotNull final Function0<Unit> callback) {
        Object objM5472constructorimpl;
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!isShowing()) {
            setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.zoontek.rnbootsplash.RNBootSplashDialog$$ExternalSyntheticLambda1
                @Override // android.content.DialogInterface.OnShowListener
                public final void onShow(DialogInterface dialogInterface) {
                    callback.invoke();
                }
            });
            try {
                Result.Companion companion = Result.Companion;
                super.show();
                objM5472constructorimpl = Result.m5472constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                objM5472constructorimpl = Result.m5472constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m5475exceptionOrNullimpl(objM5472constructorimpl) != null) {
                callback.invoke();
            }
            Result.m5471boximpl(objM5472constructorimpl);
            return;
        }
        callback.invoke();
    }

    @Override // android.app.Dialog
    protected void onCreate(@Nullable Bundle bundle) {
        Window window = getWindow();
        if (window != null) {
            window.setLayout(-1, -1);
            window.setWindowAnimations(this.fade ? R.style.BootSplashFadeOutAnimation : R.style.BootSplashNoAnimation);
            if (RNBootSplashModuleImpl.INSTANCE.isSamsungOneUI4()) {
                window.setBackgroundDrawableResource(R.drawable.compat_splash_screen_oneui_4);
            }
        }
        super.onCreate(bundle);
    }
}
