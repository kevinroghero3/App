package androidx.camera.core.imagecapture;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.DngCreator;
import androidx.annotation.NonNull;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.processing.Operation;
import io.sentry.instrumentation.file.SentryFileOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class DngImage2Disk implements Operation<In, ImageCapture.OutputFileResults> {
    private DngCreator mDngCreator;

    static int computeExifOrientation(int i) {
        if (i == 0) {
            return 1;
        }
        if (i == 90) {
            return 6;
        }
        if (i != 180) {
            return i != 270 ? 0 : 8;
        }
        return 3;
    }

    public DngImage2Disk(@NonNull CameraCharacteristics cameraCharacteristics, @NonNull CaptureResult captureResult) {
        this(new DngCreator(cameraCharacteristics, captureResult));
    }

    DngImage2Disk(@NonNull DngCreator dngCreator) {
        this.mDngCreator = dngCreator;
    }

    @Override // androidx.camera.core.processing.Operation
    public ImageCapture.OutputFileResults apply(@NonNull In in) throws ImageCaptureException {
        ImageCapture.OutputFileOptions outputFileOptions = in.getOutputFileOptions();
        File fileCreateTempFile = FileUtil.createTempFile(outputFileOptions);
        writeImageToFile(fileCreateTempFile, in.getImageProxy(), in.getRotationDegrees());
        return new ImageCapture.OutputFileResults(FileUtil.moveFileToTarget(fileCreateTempFile, outputFileOptions), 32);
    }

    private void writeImageToFile(@NonNull File file, @NonNull ImageProxy imageProxy, int i) throws ImageCaptureException {
        try {
            try {
                FileOutputStream fileOutputStreamCreate = SentryFileOutputStream.Factory.create(new FileOutputStream(file), file);
                try {
                    this.mDngCreator.setOrientation(computeExifOrientation(i));
                    this.mDngCreator.writeImage(fileOutputStreamCreate, imageProxy.getImage());
                    fileOutputStreamCreate.close();
                    imageProxy.close();
                } catch (Throwable th) {
                    try {
                        fileOutputStreamCreate.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (IOException e) {
                throw new ImageCaptureException(1, "Failed to write to temp file", e);
            } catch (IllegalArgumentException e2) {
                throw new ImageCaptureException(1, "Image with an unsupported format was used", e2);
            } catch (IllegalStateException e3) {
                throw new ImageCaptureException(1, "Not enough metadata information has been set to write a well-formatted DNG file", e3);
            }
        } catch (Throwable th3) {
            imageProxy.close();
            throw th3;
        }
    }

    static abstract class In {
        abstract ImageProxy getImageProxy();

        abstract ImageCapture.OutputFileOptions getOutputFileOptions();

        abstract int getRotationDegrees();

        In() {
        }

        static In of(@NonNull ImageProxy imageProxy, int i, @NonNull ImageCapture.OutputFileOptions outputFileOptions) {
            return new AutoValue_DngImage2Disk_In(imageProxy, i, outputFileOptions);
        }
    }
}
