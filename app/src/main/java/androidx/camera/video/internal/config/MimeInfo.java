package androidx.camera.video.internal.config;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes2.dex */
public abstract class MimeInfo {

    public static abstract class Builder<B> {
        public abstract MimeInfo build();

        protected abstract B setMimeType(@NonNull String str);

        public abstract B setProfile(int i);
    }

    public abstract String getMimeType();

    public abstract int getProfile();
}
