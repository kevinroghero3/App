package com.salesforce.marketingcloud.media;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public abstract class v {

    public interface a {
        void a(b bVar);

        void a(Throwable th);
    }

    public static final class b {
        private final o.b a;
        private final Bitmap b;
        private final Drawable c;

        public b(Bitmap bitmap, o.b bVar) {
            this(bitmap, null, bVar);
        }

        public Bitmap a() {
            return this.b;
        }

        public Drawable b() {
            return this.c;
        }

        public o.b c() {
            return this.a;
        }

        public boolean d() {
            return this.b != null;
        }

        public boolean e() {
            return this.c != null;
        }

        public b(Drawable drawable, o.b bVar) {
            this(null, drawable, bVar);
        }

        private b(Bitmap bitmap, Drawable drawable, o.b bVar) {
            this.b = bitmap;
            this.c = drawable;
            this.a = bVar;
        }
    }

    private static void a(int i, int i2, BitmapFactory.Options options) {
        a(i, i2, options.outWidth, options.outHeight, options);
    }

    static BitmapFactory.Options b(t tVar) {
        if (!tVar.d()) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        return options;
    }

    public abstract void a(o oVar, t tVar, a aVar) throws IOException;

    public abstract boolean a(t tVar);

    static void a(int i, int i2, int i3, int i4, BitmapFactory.Options options) {
        int iMin;
        double dFloor;
        if (i4 > i2 || i3 > i) {
            if (i2 == 0) {
                dFloor = Math.floor(i3 / i);
            } else if (i == 0) {
                dFloor = Math.floor(i4 / i2);
            } else {
                iMin = Math.min((int) Math.floor(i4 / i2), (int) Math.floor(i3 / i));
            }
            iMin = (int) dFloor;
        } else {
            iMin = 1;
        }
        options.inSampleSize = iMin;
        options.inJustDecodeBounds = false;
    }

    static boolean a(BitmapFactory.Options options) {
        return options != null && options.inJustDecodeBounds;
    }

    static Bitmap a(InputStream inputStream, t tVar) throws IOException {
        BitmapFactory.Options optionsB = b(tVar);
        boolean zA = a(optionsB);
        byte[] bArrA = com.salesforce.marketingcloud.util.e.a(inputStream);
        if (zA) {
            BitmapFactory.decodeStream(new ByteArrayInputStream(bArrA), null, optionsB);
            a(tVar.e, tVar.f, optionsB);
        }
        Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(new ByteArrayInputStream(bArrA), null, optionsB);
        if (bitmapDecodeStream != null) {
            return bitmapDecodeStream;
        }
        throw new IOException("Failed to decode bitmap");
    }
}
