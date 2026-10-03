package com.facebook.fresco.vito.renderer;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import com.facebook.fresco.vito.renderer.util.ColorUtils;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class ImageRenderer {
    public static final ImageRenderer INSTANCE = new ImageRenderer();

    private ImageRenderer() {
    }

    public static /* synthetic */ Function1 createImageDataModelRenderCommand$default(ImageRenderer imageRenderer, ImageDataModel imageDataModel, Shape shape, Paint paint, Matrix matrix, int i, Object obj) {
        if ((i & 8) != 0) {
            matrix = null;
        }
        return imageRenderer.createImageDataModelRenderCommand(imageDataModel, shape, paint, matrix);
    }

    public final Function1<Canvas, Unit> createImageDataModelRenderCommand(@NotNull ImageDataModel model, @NotNull Shape shape, @NotNull Paint paint, @Nullable Matrix matrix) {
        C03141 c03141;
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(paint, "paint");
        if (!(model instanceof BitmapImageDataModel)) {
            if (!(model instanceof ColorIntImageDataModel)) {
                if (!(model instanceof DrawableImageDataModel)) {
                    throw new NoWhenBranchMatchedException();
                }
                DrawableImageDataModel drawableImageDataModel = (DrawableImageDataModel) model;
                return shape instanceof RectShape ? new C03131(drawableImageDataModel, matrix, shape, paint) : new AnonymousClass2(drawableImageDataModel, paint, matrix, shape);
            }
            paint.setColor(ColorUtils.Companion.multiplyColorAlpha(((ColorIntImageDataModel) model).getColorInt(), paint.getAlpha()));
            c03141 = new C03141(shape, paint);
        } else {
            BitmapImageDataModel bitmapImageDataModel = (BitmapImageDataModel) model;
            if (shape instanceof RectShape) {
                return new AnonymousClass1(matrix, bitmapImageDataModel.getBitmap(), paint);
            }
            if (shape instanceof CircleShape) {
                if (!bitmapImageDataModel.isBitmapCircular()) {
                    Bitmap bitmap = bitmapImageDataModel.getBitmap();
                    Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                    paint.setShader(new BitmapShader(bitmap, tileMode, tileMode));
                    paint.getShader().setLocalMatrix(matrix);
                    c03141 = new C03141(shape, paint);
                } else {
                    return new AnonymousClass1(matrix, bitmapImageDataModel.getBitmap(), paint);
                }
            } else {
                Bitmap bitmap2 = bitmapImageDataModel.getBitmap();
                Shader.TileMode tileMode2 = Shader.TileMode.CLAMP;
                paint.setShader(new BitmapShader(bitmap2, tileMode2, tileMode2));
                paint.getShader().setLocalMatrix(matrix);
                c03141 = new C03141(shape, paint);
            }
        }
        return c03141;
    }

    public static /* synthetic */ Function1 createRenderCommand$default(ImageRenderer imageRenderer, BitmapImageDataModel bitmapImageDataModel, Shape shape, Paint paint, Matrix matrix, int i, Object obj) {
        if ((i & 4) != 0) {
            matrix = null;
        }
        Intrinsics.checkNotNullParameter(bitmapImageDataModel, "<this>");
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(paint, "paint");
        if (!(shape instanceof RectShape)) {
            if (shape instanceof CircleShape) {
                if (!bitmapImageDataModel.isBitmapCircular()) {
                    Bitmap bitmap = bitmapImageDataModel.getBitmap();
                    Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                    paint.setShader(new BitmapShader(bitmap, tileMode, tileMode));
                    paint.getShader().setLocalMatrix(matrix);
                    return new C03141(shape, paint);
                }
                return new AnonymousClass1(matrix, bitmapImageDataModel.getBitmap(), paint);
            }
            Bitmap bitmap2 = bitmapImageDataModel.getBitmap();
            Shader.TileMode tileMode2 = Shader.TileMode.CLAMP;
            paint.setShader(new BitmapShader(bitmap2, tileMode2, tileMode2));
            paint.getShader().setLocalMatrix(matrix);
            return new C03141(shape, paint);
        }
        return new AnonymousClass1(matrix, bitmapImageDataModel.getBitmap(), paint);
    }

    public final Function1<Canvas, Unit> createRenderCommand(@NotNull BitmapImageDataModel bitmapImageDataModel, @NotNull Shape shape, @NotNull Paint paint, @Nullable Matrix matrix) {
        C03141 c03141;
        Intrinsics.checkNotNullParameter(bitmapImageDataModel, "<this>");
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(paint, "paint");
        if (!(shape instanceof RectShape)) {
            if (shape instanceof CircleShape) {
                if (!bitmapImageDataModel.isBitmapCircular()) {
                    Bitmap bitmap = bitmapImageDataModel.getBitmap();
                    Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                    paint.setShader(new BitmapShader(bitmap, tileMode, tileMode));
                    paint.getShader().setLocalMatrix(matrix);
                    c03141 = new C03141(shape, paint);
                } else {
                    return new AnonymousClass1(matrix, bitmapImageDataModel.getBitmap(), paint);
                }
            } else {
                Bitmap bitmap2 = bitmapImageDataModel.getBitmap();
                Shader.TileMode tileMode2 = Shader.TileMode.CLAMP;
                paint.setShader(new BitmapShader(bitmap2, tileMode2, tileMode2));
                paint.getShader().setLocalMatrix(matrix);
                c03141 = new C03141(shape, paint);
            }
            return c03141;
        }
        return new AnonymousClass1(matrix, bitmapImageDataModel.getBitmap(), paint);
    }

    public final Function1<Canvas, Unit> createRenderCommand(@NotNull ColorIntImageDataModel colorIntImageDataModel, @NotNull Shape shape, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(colorIntImageDataModel, "<this>");
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(paint, "paint");
        paint.setColor(ColorUtils.Companion.multiplyColorAlpha(colorIntImageDataModel.getColorInt(), paint.getAlpha()));
        return new C03141(shape, paint);
    }

    public static /* synthetic */ Function1 createRenderCommand$default(ImageRenderer imageRenderer, DrawableImageDataModel drawableImageDataModel, Shape shape, Paint paint, Matrix matrix, int i, Object obj) {
        if ((i & 4) != 0) {
            matrix = null;
        }
        Intrinsics.checkNotNullParameter(drawableImageDataModel, "<this>");
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(paint, "paint");
        return shape instanceof RectShape ? new C03131(drawableImageDataModel, matrix, shape, paint) : new AnonymousClass2(drawableImageDataModel, paint, matrix, shape);
    }

    /* JADX INFO: renamed from: com.facebook.fresco.vito.renderer.ImageRenderer$createRenderCommand$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03131 implements Function1<Canvas, Unit> {
        final /* synthetic */ Matrix $imageTransformation;
        final /* synthetic */ Paint $paint;
        final /* synthetic */ Shape $shape;
        final /* synthetic */ DrawableImageDataModel $this_createRenderCommand;

        public C03131(DrawableImageDataModel drawableImageDataModel, Matrix matrix, Shape shape, Paint paint) {
            this.$this_createRenderCommand = drawableImageDataModel;
            this.$imageTransformation = matrix;
            this.$shape = shape;
            this.$paint = paint;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Canvas canvas) {
            invoke2(canvas);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Canvas canvas) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            if (this.$this_createRenderCommand.getWidth() > 0 && this.$this_createRenderCommand.getHeight() > 0) {
                this.$this_createRenderCommand.getDrawable().setBounds(0, 0, this.$this_createRenderCommand.getWidth(), this.$this_createRenderCommand.getHeight());
                canvas.concat(this.$imageTransformation);
            } else {
                this.$this_createRenderCommand.getDrawable().setBounds((int) ((RectShape) this.$shape).getRect().left, (int) ((RectShape) this.$shape).getRect().top, (int) ((RectShape) this.$shape).getRect().right, (int) ((RectShape) this.$shape).getRect().bottom);
            }
            if (!Intrinsics.areEqual(this.$this_createRenderCommand.getDrawable().getColorFilter(), this.$paint.getColorFilter())) {
                this.$this_createRenderCommand.getDrawable().setColorFilter(this.$paint.getColorFilter());
            }
            this.$this_createRenderCommand.getDrawable().setAlpha(this.$paint.getAlpha());
            this.$this_createRenderCommand.getDrawable().draw(canvas);
        }
    }

    public final Function1<Canvas, Unit> createRenderCommand(@NotNull DrawableImageDataModel drawableImageDataModel, @NotNull Shape shape, @NotNull Paint paint, @Nullable Matrix matrix) {
        Intrinsics.checkNotNullParameter(drawableImageDataModel, "<this>");
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(paint, "paint");
        return shape instanceof RectShape ? new C03131(drawableImageDataModel, matrix, shape, paint) : new AnonymousClass2(drawableImageDataModel, paint, matrix, shape);
    }

    /* JADX INFO: renamed from: com.facebook.fresco.vito.renderer.ImageRenderer$createRenderCommand$2, reason: invalid class name */
    public static final class AnonymousClass2 implements Function1<Canvas, Unit> {
        final /* synthetic */ Matrix $imageTransformation;
        final /* synthetic */ Paint $paint;
        final /* synthetic */ Shape $shape;
        final /* synthetic */ DrawableImageDataModel $this_createRenderCommand;

        public AnonymousClass2(DrawableImageDataModel drawableImageDataModel, Paint paint, Matrix matrix, Shape shape) {
            this.$this_createRenderCommand = drawableImageDataModel;
            this.$paint = paint;
            this.$imageTransformation = matrix;
            this.$shape = shape;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Canvas canvas) {
            invoke2(canvas);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Canvas canvas) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            this.$this_createRenderCommand.getDrawable().setBounds(0, 0, this.$this_createRenderCommand.getWidth(), this.$this_createRenderCommand.getHeight());
            if (this.$this_createRenderCommand.getDrawable().getColorFilter() != null) {
                this.$this_createRenderCommand.getDrawable().setColorFilter(null);
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(this.$this_createRenderCommand.getWidth(), this.$this_createRenderCommand.getHeight(), Bitmap.Config.ARGB_8888);
            Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
            this.$this_createRenderCommand.getDrawable().draw(new Canvas(bitmapCreateBitmap));
            ImageRenderer imageRenderer = ImageRenderer.INSTANCE;
            Paint paint = this.$paint;
            Matrix matrix = this.$imageTransformation;
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            paint.setShader(new BitmapShader(bitmapCreateBitmap, tileMode, tileMode));
            paint.getShader().setLocalMatrix(matrix);
            this.$shape.draw(canvas, this.$paint);
        }
    }

    /* JADX INFO: renamed from: com.facebook.fresco.vito.renderer.ImageRenderer$bitmapRenderCommand$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Function1<Canvas, Unit> {
        final /* synthetic */ Bitmap $bitmap;
        final /* synthetic */ Matrix $imageTransformation;
        final /* synthetic */ Paint $paint;

        public AnonymousClass1(Matrix matrix, Bitmap bitmap, Paint paint) {
            this.$imageTransformation = matrix;
            this.$bitmap = bitmap;
            this.$paint = paint;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Canvas canvas) {
            invoke2(canvas);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Canvas canvas) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            canvas.concat(this.$imageTransformation);
            canvas.drawBitmap(this.$bitmap, 0.0f, 0.0f, this.$paint);
        }
    }

    public final Function1<Canvas, Unit> bitmapRenderCommand(@NotNull Paint paint, @NotNull Bitmap bitmap, @Nullable Matrix matrix) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        return new AnonymousClass1(matrix, bitmap, paint);
    }

    /* JADX INFO: renamed from: com.facebook.fresco.vito.renderer.ImageRenderer$paintRenderCommand$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03141 implements Function1<Canvas, Unit> {
        final /* synthetic */ Paint $paint;
        final /* synthetic */ Shape $shape;

        public C03141(Shape shape, Paint paint) {
            this.$shape = shape;
            this.$paint = paint;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Canvas canvas) {
            invoke2(canvas);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Canvas canvas) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            this.$shape.draw(canvas, this.$paint);
        }
    }

    public final Function1<Canvas, Unit> paintRenderCommand(@NotNull Shape shape, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(paint, "paint");
        return new C03141(shape, paint);
    }

    public static /* synthetic */ Paint setBitmap$default(ImageRenderer imageRenderer, Paint paint, Bitmap bitmap, Matrix matrix, int i, Object obj) {
        if ((i & 2) != 0) {
            matrix = null;
        }
        Intrinsics.checkNotNullParameter(paint, "<this>");
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint.setShader(new BitmapShader(bitmap, tileMode, tileMode));
        paint.getShader().setLocalMatrix(matrix);
        return paint;
    }

    public final Paint setBitmap(@NotNull Paint paint, @NotNull Bitmap bitmap, @Nullable Matrix matrix) {
        Intrinsics.checkNotNullParameter(paint, "<this>");
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint.setShader(new BitmapShader(bitmap, tileMode, tileMode));
        paint.getShader().setLocalMatrix(matrix);
        return paint;
    }
}
