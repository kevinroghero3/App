package com.google.mlkit.vision.common.internal;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.Image;
import android.net.Uri;
import android.provider.MediaStore;
import androidx.annotation.NonNull;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.vision.common.InputImage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public class ImageUtils {
    private static final GmsLogger zza = new GmsLogger("MLKitImageUtils", "");
    private static final ImageUtils zzb = new ImageUtils();

    private ImageUtils() {
    }

    public static ImageUtils getInstance() {
        return zzb;
    }

    public IObjectWrapper getImageDataWrapper(@NonNull InputImage inputImage) throws MlKitException {
        int format = inputImage.getFormat();
        if (format == -1) {
            return ObjectWrapper.wrap((Bitmap) Preconditions.checkNotNull(inputImage.getBitmapInternal()));
        }
        if (format != 17) {
            if (format == 35) {
                return ObjectWrapper.wrap(inputImage.getMediaImage());
            }
            if (format != 842094169) {
                throw new MlKitException("Unsupported image format: " + inputImage.getFormat(), 3);
            }
        }
        return ObjectWrapper.wrap((ByteBuffer) Preconditions.checkNotNull(inputImage.getByteBuffer()));
    }

    public int getMobileVisionImageFormat(@NonNull InputImage inputImage) {
        return inputImage.getFormat();
    }

    public int getMobileVisionImageSize(@NonNull InputImage inputImage) {
        if (inputImage.getFormat() == -1) {
            return ((Bitmap) Preconditions.checkNotNull(inputImage.getBitmapInternal())).getAllocationByteCount();
        }
        if (inputImage.getFormat() == 17 || inputImage.getFormat() == 842094169) {
            return ((ByteBuffer) Preconditions.checkNotNull(inputImage.getByteBuffer())).limit();
        }
        if (inputImage.getFormat() != 35) {
            return 0;
        }
        return (((Image.Plane[]) Preconditions.checkNotNull(inputImage.getPlanes()))[0].getBuffer().limit() * 3) / 2;
    }

    public Matrix getUprightRotationMatrix(int i, int i2, int i3) {
        if (i3 == 0) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.postTranslate((-i) / 2.0f, (-i2) / 2.0f);
        matrix.postRotate(i3 * 90);
        int i4 = i3 % 2;
        int i5 = i4 != 0 ? i2 : i;
        if (i4 == 0) {
            i = i2;
        }
        matrix.postTranslate(i5 / 2.0f, i / 2.0f);
        return matrix;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0068  */
    /* JADX WARN: Code duplicated, block: B:32:0x0069 A[Catch: FileNotFoundException -> 0x00cb, TryCatch #5 {FileNotFoundException -> 0x00cb, blocks: (B:3:0x0002, B:5:0x0008, B:7:0x0016, B:33:0x006f, B:34:0x0084, B:45:0x00b4, B:47:0x00be, B:36:0x0089, B:37:0x008d, B:38:0x0094, B:39:0x0098, B:40:0x009f, B:41:0x00a3, B:42:0x00a9, B:32:0x0069, B:29:0x0057, B:49:0x00c3, B:50:0x00ca), top: B:65:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:35:0x0087  */
    /* JADX WARN: Code duplicated, block: B:36:0x0089 A[Catch: FileNotFoundException -> 0x00cb, TryCatch #5 {FileNotFoundException -> 0x00cb, blocks: (B:3:0x0002, B:5:0x0008, B:7:0x0016, B:33:0x006f, B:34:0x0084, B:45:0x00b4, B:47:0x00be, B:36:0x0089, B:37:0x008d, B:38:0x0094, B:39:0x0098, B:40:0x009f, B:41:0x00a3, B:42:0x00a9, B:32:0x0069, B:29:0x0057, B:49:0x00c3, B:50:0x00ca), top: B:65:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:37:0x008d A[Catch: FileNotFoundException -> 0x00cb, TryCatch #5 {FileNotFoundException -> 0x00cb, blocks: (B:3:0x0002, B:5:0x0008, B:7:0x0016, B:33:0x006f, B:34:0x0084, B:45:0x00b4, B:47:0x00be, B:36:0x0089, B:37:0x008d, B:38:0x0094, B:39:0x0098, B:40:0x009f, B:41:0x00a3, B:42:0x00a9, B:32:0x0069, B:29:0x0057, B:49:0x00c3, B:50:0x00ca), top: B:65:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:38:0x0094 A[Catch: FileNotFoundException -> 0x00cb, TryCatch #5 {FileNotFoundException -> 0x00cb, blocks: (B:3:0x0002, B:5:0x0008, B:7:0x0016, B:33:0x006f, B:34:0x0084, B:45:0x00b4, B:47:0x00be, B:36:0x0089, B:37:0x008d, B:38:0x0094, B:39:0x0098, B:40:0x009f, B:41:0x00a3, B:42:0x00a9, B:32:0x0069, B:29:0x0057, B:49:0x00c3, B:50:0x00ca), top: B:65:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x0098 A[Catch: FileNotFoundException -> 0x00cb, TryCatch #5 {FileNotFoundException -> 0x00cb, blocks: (B:3:0x0002, B:5:0x0008, B:7:0x0016, B:33:0x006f, B:34:0x0084, B:45:0x00b4, B:47:0x00be, B:36:0x0089, B:37:0x008d, B:38:0x0094, B:39:0x0098, B:40:0x009f, B:41:0x00a3, B:42:0x00a9, B:32:0x0069, B:29:0x0057, B:49:0x00c3, B:50:0x00ca), top: B:65:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x009f A[Catch: FileNotFoundException -> 0x00cb, TryCatch #5 {FileNotFoundException -> 0x00cb, blocks: (B:3:0x0002, B:5:0x0008, B:7:0x0016, B:33:0x006f, B:34:0x0084, B:45:0x00b4, B:47:0x00be, B:36:0x0089, B:37:0x008d, B:38:0x0094, B:39:0x0098, B:40:0x009f, B:41:0x00a3, B:42:0x00a9, B:32:0x0069, B:29:0x0057, B:49:0x00c3, B:50:0x00ca), top: B:65:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x00a3 A[Catch: FileNotFoundException -> 0x00cb, TryCatch #5 {FileNotFoundException -> 0x00cb, blocks: (B:3:0x0002, B:5:0x0008, B:7:0x0016, B:33:0x006f, B:34:0x0084, B:45:0x00b4, B:47:0x00be, B:36:0x0089, B:37:0x008d, B:38:0x0094, B:39:0x0098, B:40:0x009f, B:41:0x00a3, B:42:0x00a9, B:32:0x0069, B:29:0x0057, B:49:0x00c3, B:50:0x00ca), top: B:65:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:42:0x00a9 A[Catch: FileNotFoundException -> 0x00cb, TryCatch #5 {FileNotFoundException -> 0x00cb, blocks: (B:3:0x0002, B:5:0x0008, B:7:0x0016, B:33:0x006f, B:34:0x0084, B:45:0x00b4, B:47:0x00be, B:36:0x0089, B:37:0x008d, B:38:0x0094, B:39:0x0098, B:40:0x009f, B:41:0x00a3, B:42:0x00a9, B:32:0x0069, B:29:0x0057, B:49:0x00c3, B:50:0x00ca), top: B:65:0x0002 }] */
    public final Bitmap zza(@NonNull ContentResolver contentResolver, @NonNull Uri uri) throws IOException {
        ExifInterface exifInterface;
        Matrix matrix;
        Matrix matrix2;
        Bitmap bitmapCreateBitmap;
        try {
            Bitmap bitmap = MediaStore.Images.Media.getBitmap(contentResolver, uri);
            if (bitmap == null) {
                throw new IOException("The image Uri could not be resolved.");
            }
            int attributeInt = 0;
            if ("content".equals(uri.getScheme()) || "file".equals(uri.getScheme())) {
                try {
                    InputStream inputStreamOpenInputStream = contentResolver.openInputStream(uri);
                    if (inputStreamOpenInputStream != null) {
                        try {
                            exifInterface = new ExifInterface(inputStreamOpenInputStream);
                        } catch (Throwable th) {
                            try {
                                inputStreamOpenInputStream.close();
                            } catch (Throwable th2) {
                                try {
                                    Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                                } catch (Exception unused) {
                                }
                            }
                            throw th;
                        }
                    } else {
                        exifInterface = null;
                    }
                    if (inputStreamOpenInputStream != null) {
                        try {
                            inputStreamOpenInputStream.close();
                        } catch (IOException e) {
                            e = e;
                            zza.e("MLKitImageUtils", "failed to open file to read rotation meta data: ".concat(String.valueOf(uri)), e);
                        }
                    }
                } catch (IOException e2) {
                    e = e2;
                    exifInterface = null;
                    zza.e("MLKitImageUtils", "failed to open file to read rotation meta data: ".concat(String.valueOf(uri)), e);
                    if (exifInterface == null) {
                        attributeInt = exifInterface.getAttributeInt(ExifInterface.TAG_ORIENTATION, 1);
                    }
                    matrix = new Matrix();
                    int width = bitmap.getWidth();
                    int height = bitmap.getHeight();
                    switch (attributeInt) {
                        case 2:
                            matrix = new Matrix();
                            matrix.postScale(-1.0f, 1.0f);
                            matrix2 = matrix;
                            break;
                        case 3:
                            matrix.postRotate(180.0f);
                            matrix2 = matrix;
                            break;
                        case 4:
                            matrix.postScale(1.0f, -1.0f);
                            matrix2 = matrix;
                            break;
                        case 5:
                            matrix.postRotate(90.0f);
                            matrix.postScale(-1.0f, 1.0f);
                            matrix2 = matrix;
                            break;
                        case 6:
                            matrix.postRotate(90.0f);
                            matrix2 = matrix;
                            break;
                        case 7:
                            matrix.postRotate(-90.0f);
                            matrix.postScale(-1.0f, 1.0f);
                            matrix2 = matrix;
                            break;
                        case 8:
                            matrix.postRotate(-90.0f);
                            matrix2 = matrix;
                            break;
                        default:
                            matrix2 = null;
                            break;
                    }
                    return matrix2 == null ? bitmap : bitmap;
                }
                if (exifInterface == null) {
                    attributeInt = exifInterface.getAttributeInt(ExifInterface.TAG_ORIENTATION, 1);
                }
            }
            matrix = new Matrix();
            int width2 = bitmap.getWidth();
            int height2 = bitmap.getHeight();
            switch (attributeInt) {
                case 2:
                    matrix = new Matrix();
                    matrix.postScale(-1.0f, 1.0f);
                    matrix2 = matrix;
                    break;
                case 3:
                    matrix.postRotate(180.0f);
                    matrix2 = matrix;
                    break;
                case 4:
                    matrix.postScale(1.0f, -1.0f);
                    matrix2 = matrix;
                    break;
                case 5:
                    matrix.postRotate(90.0f);
                    matrix.postScale(-1.0f, 1.0f);
                    matrix2 = matrix;
                    break;
                case 6:
                    matrix.postRotate(90.0f);
                    matrix2 = matrix;
                    break;
                case 7:
                    matrix.postRotate(-90.0f);
                    matrix.postScale(-1.0f, 1.0f);
                    matrix2 = matrix;
                    break;
                case 8:
                    matrix.postRotate(-90.0f);
                    matrix2 = matrix;
                    break;
                default:
                    matrix2 = null;
                    break;
            }
            if (matrix2 == null && bitmap != (bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, width2, height2, matrix2, true))) {
                bitmap.recycle();
                return bitmapCreateBitmap;
            }
        } catch (FileNotFoundException e3) {
            zza.e("MLKitImageUtils", "Could not open file: ".concat(String.valueOf(uri)), e3);
            throw e3;
        }
    }
}
