package androidx.browser.trusted;

import android.content.pm.PackageManager;
import androidx.annotation.NonNull;
import io.sentry.android.core.SentryLogcatAdapter;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class Token {
    private static final String TAG = "Token";
    private final TokenContents mContents;

    public static Token create(@NonNull String str, @NonNull PackageManager packageManager) {
        List<byte[]> fingerprintsForPackage = PackageIdentityUtils.getFingerprintsForPackage(str, packageManager);
        if (fingerprintsForPackage == null) {
            return null;
        }
        try {
            return new Token(TokenContents.create(str, fingerprintsForPackage));
        } catch (IOException e) {
            SentryLogcatAdapter.e(TAG, "Exception when creating token.", e);
            return null;
        }
    }

    public static Token deserialize(@NonNull byte[] bArr) {
        return new Token(TokenContents.deserialize(bArr));
    }

    private Token(@NonNull TokenContents tokenContents) {
        this.mContents = tokenContents;
    }

    public byte[] serialize() {
        return this.mContents.serialize();
    }

    public boolean matches(@NonNull String str, @NonNull PackageManager packageManager) {
        return PackageIdentityUtils.packageMatchesToken(str, packageManager, this.mContents);
    }
}
