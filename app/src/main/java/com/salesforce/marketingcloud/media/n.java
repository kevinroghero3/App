package com.salesforce.marketingcloud.media;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import com.facebook.share.internal.ShareConstants;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
public class n implements Runnable {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final String f63n = "ImageHandler-";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final String f64o = "ImageHandler-Idle";
    private static final ThreadLocal<StringBuilder> p = new a();
    private static final v q = new b();
    final o b;
    final h c;
    final String d;
    final v e;
    final com.salesforce.marketingcloud.media.c f;
    t g;
    com.salesforce.marketingcloud.media.a h;
    List<com.salesforce.marketingcloud.media.a> i;
    v.b j;
    Future<?> k;
    Exception l;
    o.c m;

    class a extends ThreadLocal<StringBuilder> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public StringBuilder initialValue() {
            return new StringBuilder(n.f63n);
        }
    }

    class b extends v {
        b() {
        }

        @Override // com.salesforce.marketingcloud.media.v
        public boolean a(t tVar) {
            return true;
        }

        @Override // com.salesforce.marketingcloud.media.v
        public void a(o oVar, t tVar, v.a aVar) throws IOException {
            aVar.a(new k(tVar));
        }
    }

    n(o oVar, h hVar, com.salesforce.marketingcloud.media.c cVar, com.salesforce.marketingcloud.media.a aVar, v vVar) {
        this.b = oVar;
        this.c = hVar;
        this.f = cVar;
        this.h = aVar;
        this.d = aVar.c();
        this.g = aVar.e();
        this.e = vVar;
        this.m = aVar.d();
    }

    static n a(o oVar, h hVar, com.salesforce.marketingcloud.media.c cVar, com.salesforce.marketingcloud.media.a aVar) {
        t tVarE = aVar.e();
        List<v> listA = oVar.a();
        int size = listA.size();
        for (int i = 0; i < size; i++) {
            v vVar = listA.get(i);
            if (vVar.a(tVarE)) {
                return new n(oVar, hVar, cVar, aVar, vVar);
            }
        }
        return new n(oVar, hVar, cVar, aVar, q);
    }

    static Bitmap b(t tVar, Bitmap bitmap) {
        int i;
        int i2;
        int i3;
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        float f11;
        float f12;
        int i4;
        int i5;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        int i6 = 0;
        if (tVar.d()) {
            int i7 = tVar.e;
            int i8 = tVar.f;
            if (tVar.g) {
                if (i7 != 0) {
                    f9 = i7;
                    f10 = width;
                } else {
                    f9 = i8;
                    f10 = height;
                }
                float f13 = f9 / f10;
                if (i8 != 0) {
                    f11 = i8;
                    f12 = height;
                } else {
                    f11 = i7;
                    f12 = width;
                }
                float f14 = f11 / f12;
                if (f13 > f14) {
                    int iCeil = (int) Math.ceil(height * (f14 / f13));
                    f14 = i8 / iCeil;
                    i5 = 0;
                    i6 = (height - iCeil) / 2;
                    height = iCeil;
                } else {
                    if (f13 < f14) {
                        int iCeil2 = (int) Math.ceil(width * (f13 / f14));
                        i5 = (width - iCeil2) / 2;
                        width = iCeil2;
                        f13 = i7 / iCeil2;
                    } else {
                        i4 = 0;
                        f13 = f14;
                    }
                    matrix.preScale(f13, f14);
                    i = width;
                    i2 = height;
                    i3 = i6;
                    i6 = i4;
                }
                i4 = i5;
                matrix.preScale(f13, f14);
                i = width;
                i2 = height;
                i3 = i6;
                i6 = i4;
            } else {
                if (tVar.h) {
                    if (i7 != 0) {
                        f5 = i7;
                        f6 = width;
                    } else {
                        f5 = i8;
                        f6 = height;
                    }
                    float f15 = f5 / f6;
                    if (i8 != 0) {
                        f7 = i8;
                        f8 = height;
                    } else {
                        f7 = i7;
                        f8 = width;
                    }
                    float f16 = f7 / f8;
                    if (f15 >= f16) {
                        f15 = f16;
                    }
                    matrix.preScale(f15, f15);
                } else if ((i7 != 0 || i8 != 0) && (i7 != width || i8 != height)) {
                    if (i7 != 0) {
                        f = i7;
                        f2 = width;
                    } else {
                        f = i8;
                        f2 = height;
                    }
                    float f17 = f / f2;
                    if (i8 != 0) {
                        f3 = i8;
                        f4 = height;
                    } else {
                        f3 = i7;
                        f4 = width;
                    }
                    matrix.preScale(f17, f3 / f4);
                }
                i = width;
                i2 = height;
                i3 = 0;
            }
        } else {
            i = width;
            i2 = height;
            i3 = 0;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, i6, i3, i, i2, matrix, true);
        if (bitmapCreateBitmap == bitmap) {
            return bitmap;
        }
        bitmap.recycle();
        return bitmapCreateBitmap;
    }

    public com.salesforce.marketingcloud.media.a c() {
        return this.h;
    }

    public List<com.salesforce.marketingcloud.media.a> d() {
        return this.i;
    }

    public t e() {
        return this.g;
    }

    public Exception f() {
        return this.l;
    }

    public o g() {
        return this.b;
    }

    public String h() {
        return this.d;
    }

    public v.b i() {
        return this.j;
    }

    boolean j() {
        Future<?> future = this.k;
        return future != null && future.isCancelled();
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            try {
                a(this.g);
                v.b bVarB = b();
                this.j = bVarB;
                if (bVarB.d()) {
                    com.salesforce.marketingcloud.g.a(ShareConstants.IMAGE_URL, "onSuccess - Loaded from: %s", this.j.c());
                    this.c.b(this);
                } else {
                    this.c.c(this);
                }
            } catch (Exception e) {
                this.l = e;
                this.c.c(this);
            }
        } finally {
            Thread.currentThread().setName(f64o);
        }
    }

    class c implements v.a {
        final /* synthetic */ AtomicReference a;
        final /* synthetic */ CountDownLatch b;
        final /* synthetic */ AtomicReference c;

        c(AtomicReference atomicReference, CountDownLatch countDownLatch, AtomicReference atomicReference2) {
            this.a = atomicReference;
            this.b = countDownLatch;
            this.c = atomicReference2;
        }

        @Override // com.salesforce.marketingcloud.media.v.a
        public void a(v.b bVar) {
            this.a.set(bVar);
            this.b.countDown();
        }

        @Override // com.salesforce.marketingcloud.media.v.a
        public void a(Throwable th) {
            this.c.set(th);
            this.b.countDown();
        }
    }

    static void a(t tVar) {
        String strB = tVar.b();
        StringBuilder sb = p.get();
        sb.ensureCapacity(strB.length() + 13);
        sb.replace(13, sb.length(), strB);
        Thread.currentThread().setName(sb.toString());
    }

    static Bitmap a(t tVar, Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f = tVar.i;
        float f2 = tVar.j;
        float f3 = width;
        float f4 = height;
        RectF rectF = new RectF(0.0f, 0.0f, f3, f4);
        RectF rectF2 = new RectF(0.0f, 0.0f, f3, f4);
        Paint paint = new Paint();
        Paint paint2 = new Paint();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        paint.setAntiAlias(true);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint.setShader(new BitmapShader(bitmap, tileMode, tileMode));
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setAntiAlias(true);
        if (f2 > 0.0f) {
            paint2.setStrokeWidth(f2);
            paint2.setColor(tVar.k);
            float f5 = f2 / 2.0f;
            rectF2.inset(f5, f5);
            float fFloor = (float) Math.floor(f5);
            rectF.inset(fFloor, fFloor);
        }
        if (f > 0.0f) {
            canvas.drawRoundRect(rectF, f, f, paint);
            if (f2 > 0.0f) {
                canvas.drawRoundRect(rectF2, f, f, paint2);
            }
        } else {
            canvas.drawRect(rectF, paint);
            if (f2 > 0.0f) {
                canvas.drawRect(rectF2, paint2);
            }
        }
        if (bitmap == bitmapCreateBitmap) {
            return bitmap;
        }
        bitmap.recycle();
        return bitmapCreateBitmap;
    }

    v.b b() throws IOException {
        Bitmap bitmapA;
        if (t.b.a(this.g.d) && (bitmapA = this.f.a(this.d)) != null) {
            return new v.b(bitmapA, o.b.MEMORY);
        }
        AtomicReference atomicReference = new AtomicReference();
        AtomicReference atomicReference2 = new AtomicReference();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        try {
            this.e.a(this.b, this.g, new c(atomicReference, countDownLatch, atomicReference2));
            countDownLatch.await();
            Throwable th = (Throwable) atomicReference2.get();
            if (th == null) {
                v.b bVar = (v.b) atomicReference.get();
                if (!bVar.d()) {
                    return bVar;
                }
                Bitmap bitmapA2 = bVar.a();
                if (!this.g.e()) {
                    return bVar;
                }
                if (this.g.d()) {
                    bitmapA2 = b(this.g, bitmapA2);
                }
                if (this.g.c()) {
                    bitmapA2 = a(this.g, bitmapA2);
                }
                return new v.b(bitmapA2, bVar.c());
            }
            throw new RuntimeException(th);
        } catch (InterruptedException e) {
            throw new InterruptedIOException(e.getMessage());
        }
    }

    boolean a() {
        Future<?> future;
        if (this.h != null) {
            return false;
        }
        List<com.salesforce.marketingcloud.media.a> list = this.i;
        return (list == null || list.isEmpty()) && (future = this.k) != null && future.cancel(false);
    }

    public void a(com.salesforce.marketingcloud.media.a aVar) {
        if (this.h == null) {
            this.h = aVar;
            return;
        }
        if (this.i == null) {
            this.i = new ArrayList();
        }
        this.i.add(aVar);
        o.c cVarD = aVar.d();
        if (cVarD.ordinal() > this.m.ordinal()) {
            this.m = cVarD;
        }
    }

    public void b(com.salesforce.marketingcloud.media.a aVar) {
        if (this.h == aVar) {
            this.h = null;
            return;
        }
        List<com.salesforce.marketingcloud.media.a> list = this.i;
        if (list != null) {
            list.remove(aVar);
        }
    }
}
