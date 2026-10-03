package com.facebook.react.devsupport;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.EditText;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class DoubleTapReloadRecognizer {
    private static final Companion Companion = new Companion(null);
    private static final long DOUBLE_TAP_DELAY = 200;
    private boolean doRefresh;

    public final boolean didDoubleTapR(int i, @Nullable View view) {
        if (i == 46 && !(view instanceof EditText)) {
            if (this.doRefresh) {
                this.doRefresh = false;
                return true;
            }
            this.doRefresh = true;
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.facebook.react.devsupport.DoubleTapReloadRecognizer$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.doRefresh = false;
                }
            }, DOUBLE_TAP_DELAY);
        }
        return false;
    }

    static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
