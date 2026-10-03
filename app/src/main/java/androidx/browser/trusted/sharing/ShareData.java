package androidx.browser.trusted.sharing;

import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class ShareData {
    public static final String KEY_TEXT = "androidx.browser.trusted.sharing.KEY_TEXT";
    public static final String KEY_TITLE = "androidx.browser.trusted.sharing.KEY_TITLE";
    public static final String KEY_URIS = "androidx.browser.trusted.sharing.KEY_URIS";
    public final String text;
    public final String title;
    public final List<Uri> uris;

    public ShareData(@Nullable String str, @Nullable String str2, @Nullable List<Uri> list) {
        this.title = str;
        this.text = str2;
        this.uris = list;
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putString("androidx.browser.trusted.sharing.KEY_TITLE", this.title);
        bundle.putString("androidx.browser.trusted.sharing.KEY_TEXT", this.text);
        if (this.uris != null) {
            bundle.putParcelableArrayList(KEY_URIS, new ArrayList<>(this.uris));
        }
        return bundle;
    }

    public static ShareData fromBundle(@NonNull Bundle bundle) {
        return new ShareData(bundle.getString("androidx.browser.trusted.sharing.KEY_TITLE"), bundle.getString("androidx.browser.trusted.sharing.KEY_TEXT"), bundle.getParcelableArrayList(KEY_URIS));
    }
}
