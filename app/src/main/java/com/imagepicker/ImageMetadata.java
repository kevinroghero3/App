package com.imagepicker;

import android.content.Context;
import android.net.Uri;
import androidx.exifinterface.media.ExifInterface;
import io.sentry.android.core.SentryLogcatAdapter;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public class ImageMetadata extends Metadata {
    @Override // com.imagepicker.Metadata
    public int getHeight() {
        return 0;
    }

    @Override // com.imagepicker.Metadata
    public int getWidth() {
        return 0;
    }

    public ImageMetadata(Uri uri, Context context) {
        try {
            InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
            try {
                String attribute = new ExifInterface(inputStreamOpenInputStream).getAttribute(ExifInterface.TAG_DATETIME);
                if (attribute != null) {
                    this.datetime = getDateTimeInUTC(attribute, "yyyy:MM:dd HH:mm:ss");
                }
                if (inputStreamOpenInputStream != null) {
                    inputStreamOpenInputStream.close();
                }
            } catch (Throwable th) {
                if (inputStreamOpenInputStream != null) {
                    try {
                        inputStreamOpenInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (Exception e) {
            SentryLogcatAdapter.e("RNIP", "Could not load image metadata: " + e.getMessage());
        }
    }

    @Override // com.imagepicker.Metadata
    public String getDateTime() {
        return this.datetime;
    }
}
