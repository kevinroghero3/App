package io.sentry.android.replay.gestures;

import android.view.MotionEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public interface TouchRecorderCallback {
    void onTouchEvent(@NotNull MotionEvent motionEvent);
}
