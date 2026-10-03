package com.hitachiapp.utils;

import android.app.Activity;
import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;
import com.google.common.net.HttpHeaders;
import com.hitachiapp.MainActivity;
import com.hitachiapp.exceptions.AppDebuggableException;
import com.hitachiapp.exceptions.AppHookedException;
import com.hitachiapp.exceptions.ErrorCodes;
import com.hitachiapp.exceptions.RunningOnEmulatorException;
import com.hitachiapp.exceptions.RunningOnRootedDeviceException;
import com.hitachiapp.exceptions.SignedWithInvalidKeyException;
import io.sentry.android.core.SentryLogcatAdapter;
import java.lang.reflect.Constructor;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__IndentKt;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public final class ScrtyManager {
    public static final ScrtyManager INSTANCE = new ScrtyManager();
    private static final String TAG = "[SECURITY]";

    private ScrtyManager() {
    }

    private final void showAlert(final ErrorCodes errorCodes, final Activity activity) {
        String strTrimIndent = StringsKt__IndentKt.trimIndent("\n                App will be terminated due to a security issue.\n                (Error Code: " + errorCodes.code + ")\n                ");
        SentryLogcatAdapter.e(TAG, "Error code: " + errorCodes.code);
        if (activity instanceof MainActivity) {
            new AlertDialog.Builder(activity).setTitle("Error").setMessage(strTrimIndent).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: com.hitachiapp.utils.ScrtyManager$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    ScrtyManager.showAlert$lambda$0(activity, errorCodes, dialogInterface, i);
                }
            }).setCancelable(false).create().show();
        } else {
            System.exit(errorCodes.code);
            throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showAlert$lambda$0(Activity activity, ErrorCodes errorCodes, DialogInterface dialogInterface, int i) {
        ((MainActivity) activity).finish();
        System.exit(errorCodes.code);
        throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
    }

    public static final void dbgCallback(long j, long j2) throws Throwable {
        try {
            Constructor declaredConstructor = AppDebuggableException.class.getDeclaredConstructor(null);
            declaredConstructor.setAccessible(true);
            throw ((Throwable) declaredConstructor.newInstance(null));
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    public static final void hkCallback(long j, long j2) throws Throwable {
        try {
            Constructor declaredConstructor = AppHookedException.class.getDeclaredConstructor(null);
            declaredConstructor.setAccessible(true);
            throw ((Throwable) declaredConstructor.newInstance(null));
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    public static final void mltrCallback(long j, long j2) throws Throwable {
        try {
            Constructor declaredConstructor = RunningOnEmulatorException.class.getDeclaredConstructor(null);
            declaredConstructor.setAccessible(true);
            throw ((Throwable) declaredConstructor.newInstance(null));
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    public static final void rtCallback(long j, long j2) throws Throwable {
        try {
            Constructor declaredConstructor = RunningOnRootedDeviceException.class.getDeclaredConstructor(null);
            declaredConstructor.setAccessible(true);
            throw ((Throwable) declaredConstructor.newInstance(null));
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    public static final void crtfcttmprCallback(long j, long j2) throws Throwable {
        try {
            Constructor declaredConstructor = SignedWithInvalidKeyException.class.getDeclaredConstructor(null);
            declaredConstructor.setAccessible(true);
            throw ((Throwable) declaredConstructor.newInstance(null));
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    @JvmStatic
    public static final void showSecurityWarning(@Nullable MainActivity mainActivity) {
        Intrinsics.checkNotNull(mainActivity);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(mainActivity).setTitle(HttpHeaders.WARNING).setMessage("Security checks are currently disabled, do not distribute this app to external users").setPositiveButton("Ok", new DialogInterface.OnClickListener() { // from class: com.hitachiapp.utils.ScrtyManager$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        }).create();
        Intrinsics.checkNotNullExpressionValue(alertDialogCreate, "create(...)");
        alertDialogCreate.show();
    }
}
