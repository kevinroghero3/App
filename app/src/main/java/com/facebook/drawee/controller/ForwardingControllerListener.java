package com.facebook.drawee.controller;

import android.graphics.drawable.Animatable;
import com.facebook.fresco.ui.common.DimensionsInfo;
import com.facebook.fresco.ui.common.OnDrawControllerListener;
import io.sentry.android.core.SentryLogcatAdapter;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public class ForwardingControllerListener<INFO> implements ControllerListener<INFO>, OnDrawControllerListener<INFO> {
    private static final String TAG = "FdingControllerListener";
    private final List<ControllerListener<? super INFO>> mListeners = new ArrayList(2);

    public static <INFO> ForwardingControllerListener<INFO> create() {
        return new ForwardingControllerListener<>();
    }

    public static <INFO> ForwardingControllerListener<INFO> of(ControllerListener<? super INFO> controllerListener) {
        ForwardingControllerListener<INFO> forwardingControllerListenerCreate = create();
        forwardingControllerListenerCreate.addListener(controllerListener);
        return forwardingControllerListenerCreate;
    }

    public static <INFO> ForwardingControllerListener<INFO> of(ControllerListener<? super INFO> controllerListener, ControllerListener<? super INFO> controllerListener2) {
        ForwardingControllerListener<INFO> forwardingControllerListenerCreate = create();
        forwardingControllerListenerCreate.addListener(controllerListener);
        forwardingControllerListenerCreate.addListener(controllerListener2);
        return forwardingControllerListenerCreate;
    }

    public void addListener(ControllerListener<? super INFO> controllerListener) {
        synchronized (this) {
            this.mListeners.add(controllerListener);
        }
    }

    public void removeListener(ControllerListener<? super INFO> controllerListener) {
        synchronized (this) {
            int iIndexOf = this.mListeners.indexOf(controllerListener);
            if (iIndexOf != -1) {
                this.mListeners.set(iIndexOf, null);
            }
        }
    }

    public void clearListeners() {
        synchronized (this) {
            this.mListeners.clear();
        }
    }

    private void onException(String str, Throwable th) {
        synchronized (this) {
            SentryLogcatAdapter.e(TAG, str, th);
        }
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public void onSubmit(String str, Object obj) {
        synchronized (this) {
            int size = this.mListeners.size();
            for (int i = 0; i < size; i++) {
                try {
                    ControllerListener<? super INFO> controllerListener = this.mListeners.get(i);
                    if (controllerListener != null) {
                        controllerListener.onSubmit(str, obj);
                    }
                } catch (Exception e) {
                    onException("InternalListener exception in onSubmit", e);
                }
            }
        }
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public void onFinalImageSet(String str, @Nullable INFO info, @Nullable Animatable animatable) {
        synchronized (this) {
            int size = this.mListeners.size();
            for (int i = 0; i < size; i++) {
                try {
                    ControllerListener<? super INFO> controllerListener = this.mListeners.get(i);
                    if (controllerListener != null) {
                        controllerListener.onFinalImageSet(str, info, animatable);
                    }
                } catch (Exception e) {
                    onException("InternalListener exception in onFinalImageSet", e);
                }
            }
        }
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public void onIntermediateImageSet(String str, @Nullable INFO info) {
        int size = this.mListeners.size();
        for (int i = 0; i < size; i++) {
            try {
                ControllerListener<? super INFO> controllerListener = this.mListeners.get(i);
                if (controllerListener != null) {
                    controllerListener.onIntermediateImageSet(str, info);
                }
            } catch (Exception e) {
                onException("InternalListener exception in onIntermediateImageSet", e);
            }
        }
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public void onIntermediateImageFailed(String str, Throwable th) {
        int size = this.mListeners.size();
        for (int i = 0; i < size; i++) {
            try {
                ControllerListener<? super INFO> controllerListener = this.mListeners.get(i);
                if (controllerListener != null) {
                    controllerListener.onIntermediateImageFailed(str, th);
                }
            } catch (Exception e) {
                onException("InternalListener exception in onIntermediateImageFailed", e);
            }
        }
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public void onFailure(String str, Throwable th) {
        synchronized (this) {
            int size = this.mListeners.size();
            for (int i = 0; i < size; i++) {
                try {
                    ControllerListener<? super INFO> controllerListener = this.mListeners.get(i);
                    if (controllerListener != null) {
                        controllerListener.onFailure(str, th);
                    }
                } catch (Exception e) {
                    onException("InternalListener exception in onFailure", e);
                }
            }
        }
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public void onRelease(String str) {
        synchronized (this) {
            int size = this.mListeners.size();
            for (int i = 0; i < size; i++) {
                try {
                    ControllerListener<? super INFO> controllerListener = this.mListeners.get(i);
                    if (controllerListener != null) {
                        controllerListener.onRelease(str);
                    }
                } catch (Exception e) {
                    onException("InternalListener exception in onRelease", e);
                }
            }
        }
    }

    @Override // com.facebook.fresco.ui.common.OnDrawControllerListener
    public void onImageDrawn(String str, INFO info, DimensionsInfo dimensionsInfo) {
        int size = this.mListeners.size();
        for (int i = 0; i < size; i++) {
            try {
                ControllerListener<? super INFO> controllerListener = this.mListeners.get(i);
                if (controllerListener instanceof OnDrawControllerListener) {
                    ((OnDrawControllerListener) controllerListener).onImageDrawn(str, info, dimensionsInfo);
                }
            } catch (Exception e) {
                onException("InternalListener exception in onImageDrawn", e);
            }
        }
    }
}
