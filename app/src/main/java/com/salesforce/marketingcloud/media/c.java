package com.salesforce.marketingcloud.media;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import androidx.collection.LruCache;
import androidx.core.graphics.BitmapCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;

/* JADX INFO: loaded from: classes3.dex */
public class c {
    private final LruCache<String, b> a;

    class a extends LruCache<String, b> {
        a(int i) {
            super(i);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.collection.LruCache
        public int sizeOf(String str, b bVar) {
            return bVar.b;
        }
    }

    static final class b {
        final Bitmap a;
        final int b;

        b(Bitmap bitmap, int i) {
            this.a = bitmap;
            this.b = i;
        }
    }

    c(Context context) {
        this.a = new a(a(context));
    }

    private static int a(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        int iMin = Math.min((int) ((((long) ((context.getApplicationInfo().flags & 1048576) != 0 ? activityManager.getLargeMemoryClass() : activityManager.getMemoryClass())) * 1048576) / 2), AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
        return activityManager.isLowRamDevice() ? iMin / 2 : iMin;
    }

    Bitmap a(String str) {
        b bVar = this.a.get(str);
        if (bVar != null) {
            return bVar.a;
        }
        return null;
    }

    void a(String str, Bitmap bitmap) {
        if (str == null || bitmap == null) {
            return;
        }
        int allocationByteCount = BitmapCompat.getAllocationByteCount(bitmap);
        if (allocationByteCount > this.a.maxSize()) {
            this.a.remove(str);
        } else {
            this.a.put(str, new b(bitmap, allocationByteCount));
        }
    }

    void a() {
        this.a.evictAll();
    }
}
