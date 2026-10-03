package com.facebook.drawee.backends.pipeline.info;

import com.facebook.common.logging.FLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public class ForwardingImageOriginListener implements ImageOriginListener {
    private static final String TAG = "ForwardingImageOriginListener";
    private final List<ImageOriginListener> mImageOriginListeners;

    public ForwardingImageOriginListener(Set<ImageOriginListener> set) {
        this.mImageOriginListeners = new ArrayList(set);
    }

    public ForwardingImageOriginListener(ImageOriginListener... imageOriginListenerArr) {
        ArrayList arrayList = new ArrayList(imageOriginListenerArr.length);
        this.mImageOriginListeners = arrayList;
        Collections.addAll(arrayList, imageOriginListenerArr);
    }

    public void addImageOriginListener(ImageOriginListener imageOriginListener) {
        synchronized (this) {
            this.mImageOriginListeners.add(imageOriginListener);
        }
    }

    public void removeImageOriginListener(ImageOriginListener imageOriginListener) {
        synchronized (this) {
            this.mImageOriginListeners.remove(imageOriginListener);
        }
    }

    @Override // com.facebook.drawee.backends.pipeline.info.ImageOriginListener
    public void onImageLoaded(String str, int i, boolean z, @Nullable String str2) {
        synchronized (this) {
            int size = this.mImageOriginListeners.size();
            for (int i2 = 0; i2 < size; i2++) {
                ImageOriginListener imageOriginListener = this.mImageOriginListeners.get(i2);
                if (imageOriginListener != null) {
                    try {
                        imageOriginListener.onImageLoaded(str, i, z, str2);
                    } catch (Exception e) {
                        FLog.e(TAG, "InternalListener exception in onImageLoaded", e);
                    }
                }
            }
        }
    }
}
