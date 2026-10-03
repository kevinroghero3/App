package com.captureprotection.utils;

import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import com.facebook.react.bridge.ReactApplicationContext;
import java.util.Locale;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class FileUtils {
    public static final Companion Companion = new Companion(null);

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean isImageUri(@Nullable Uri uri) {
            String string;
            if (uri == null || (string = uri.toString()) == null) {
                return false;
            }
            return new Regex(MediaStore.Images.Media.EXTERNAL_CONTENT_URI + "/[0-9]+").matches(string);
        }

        /* JADX WARN: Code duplicated, block: B:12:0x004b  */
        public final boolean isScreenshotFile(@NotNull ReactApplicationContext reactContext, @NotNull Uri uri) throws Throwable {
            boolean z;
            Intrinsics.checkNotNullParameter(reactContext, "reactContext");
            Intrinsics.checkNotNullParameter(uri, "uri");
            Cursor cursor = null;
            try {
                Cursor cursorQuery = reactContext.getContentResolver().query(uri, new String[]{"_data"}, null, null, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            String string = cursorQuery.getString(cursorQuery.getColumnIndex("_data"));
                            if (string != null) {
                                Locale ROOT = Locale.ROOT;
                                Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
                                String lowerCase = string.toLowerCase(ROOT);
                                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                                z = StringsKt__StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) "screenshots", false, 2, (Object) null);
                            }
                            cursorQuery.close();
                            return z;
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor = cursorQuery;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return false;
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }
}
