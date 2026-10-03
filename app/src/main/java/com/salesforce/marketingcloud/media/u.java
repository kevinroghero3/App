package com.salesforce.marketingcloud.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Looper;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import com.facebook.share.internal.ShareConstants;

/* JADX INFO: loaded from: classes3.dex */
public class u {
    private final o a;
    private final t.a b;
    private boolean c;

    public u(o oVar, Uri uri) {
        this.a = oVar;
        this.b = new t.a(uri);
    }

    public u a(o.c cVar) {
        this.b.a(cVar);
        return this;
    }

    public u b() {
        this.b.c();
        return this;
    }

    public void c() {
        a((f) null);
    }

    public u d() {
        this.c = true;
        return this;
    }

    public u a(t.b bVar, t.b... bVarArr) {
        this.b.a(bVar, bVarArr);
        return this;
    }

    public u a(float f, float f2, @ColorInt int i) {
        this.b.a(f, f2, i);
        return this;
    }

    public u a() {
        this.b.b();
        return this;
    }

    public u a(int i, int i2) {
        this.b.a(i, i2);
        return this;
    }

    public void a(f fVar) {
        long jNanoTime = System.nanoTime();
        if (!this.b.d()) {
            this.b.a(o.c.NORMAL);
        }
        t tVarA = a(jNanoTime);
        if (t.b.a(tVarA.d) && this.a.a(tVarA.b) != null) {
            com.salesforce.marketingcloud.g.a(ShareConstants.IMAGE_URL, "onSuccess - Loaded from: MEMORY", new Object[0]);
            if (fVar != null) {
                fVar.a();
                return;
            }
            return;
        }
        this.a.a((a) new j(this.a, tVarA, fVar));
    }

    public void a(ImageView imageView) {
        a(imageView, (f) null);
    }

    public void a(ImageView imageView, f fVar) {
        Bitmap bitmapA;
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            if (!this.b.d()) {
                this.b.a(o.c.HIGH);
            }
            if (this.c) {
                int width = imageView.getWidth();
                int height = imageView.getHeight();
                if (width != 0 && height != 0) {
                    this.b.a(width, height);
                } else {
                    this.a.a(imageView, new g(this, imageView, fVar));
                    return;
                }
            }
            t tVarA = a(System.nanoTime());
            if (t.b.a(tVarA.d) && (bitmapA = this.a.a(tVarA.b)) != null) {
                v.b bVar = new v.b(bitmapA, o.b.MEMORY);
                l.a(imageView, this.a.a, bVar);
                com.salesforce.marketingcloud.g.a(ShareConstants.IMAGE_URL, "onSuccess - Loaded from: %s", bVar.c());
                if (fVar != null) {
                    fVar.a();
                    return;
                }
                return;
            }
            this.a.a((a) new p(this.a, new w(imageView), tVarA, fVar));
            return;
        }
        throw new IllegalStateException("TODO");
    }

    private t a(long j) {
        t tVarA = this.b.a();
        tVarA.l = j;
        return tVarA;
    }
}
