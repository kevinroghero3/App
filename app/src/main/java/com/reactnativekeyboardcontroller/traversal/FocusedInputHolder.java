package com.reactnativekeyboardcontroller.traversal;

import android.widget.EditText;
import com.reactnativekeyboardcontroller.extensions.EditTextKt;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class FocusedInputHolder {
    public static final FocusedInputHolder INSTANCE = new FocusedInputHolder();
    private static WeakReference<EditText> input;

    private FocusedInputHolder() {
    }

    public final void set(@NotNull EditText textInput) {
        Intrinsics.checkNotNullParameter(textInput, "textInput");
        input = new WeakReference<>(textInput);
    }

    public final EditText get() {
        WeakReference<EditText> weakReference = input;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public final void focus() {
        EditText editText;
        WeakReference<EditText> weakReference = input;
        if (weakReference == null || (editText = weakReference.get()) == null) {
            return;
        }
        EditTextKt.focus(editText);
    }
}
