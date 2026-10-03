package com.mrousavy.camera.core;

import android.media.Image;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageProxy;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.vision.barcode.BarcodeScanner;
import com.google.mlkit.vision.barcode.BarcodeScannerOptions;
import com.google.mlkit.vision.barcode.BarcodeScanning;
import com.google.mlkit.vision.barcode.common.Barcode;
import com.google.mlkit.vision.common.InputImage;
import com.mrousavy.camera.core.types.CodeType;
import io.sentry.android.core.SentryLogcatAdapter;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class CodeScannerPipeline implements Closeable, ImageAnalysis.Analyzer {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "CodeScannerPipeline";
    private final CameraSession.Callback callback;
    private final CameraConfiguration.CodeScanner configuration;
    private final BarcodeScanner scanner;

    public CodeScannerPipeline(@NotNull CameraConfiguration.CodeScanner configuration, @NotNull CameraSession.Callback callback) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.configuration = configuration;
        this.callback = callback;
        List<CodeType> codeTypes = configuration.getCodeTypes();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(codeTypes, 10));
        Iterator<T> it2 = codeTypes.iterator();
        while (it2.hasNext()) {
            arrayList.add(Integer.valueOf(((CodeType) it2.next()).toBarcodeType()));
        }
        BarcodeScannerOptions.Builder builder = new BarcodeScannerOptions.Builder();
        int iIntValue = ((Number) arrayList.get(0)).intValue();
        int[] intArray = CollectionsKt___CollectionsKt.toIntArray(arrayList);
        BarcodeScannerOptions barcodeScannerOptionsBuild = builder.setBarcodeFormats(iIntValue, Arrays.copyOf(intArray, intArray.length)).build();
        Intrinsics.checkNotNullExpressionValue(barcodeScannerOptionsBuild, "build(...)");
        this.scanner = BarcodeScanning.getClient(barcodeScannerOptionsBuild);
    }

    public final CameraSession.Callback getCallback() {
        return this.callback;
    }

    public final CameraConfiguration.CodeScanner getConfiguration() {
        return this.configuration;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // androidx.camera.core.ImageAnalysis.Analyzer
    public void analyze(@NotNull final ImageProxy imageProxy) throws InvalidImageTypeError {
        Intrinsics.checkNotNullParameter(imageProxy, "imageProxy");
        Image image = imageProxy.getImage();
        if (image == null) {
            throw new InvalidImageTypeError();
        }
        try {
            final InputImage inputImageFromMediaImage = InputImage.fromMediaImage(image, imageProxy.getImageInfo().getRotationDegrees());
            Intrinsics.checkNotNullExpressionValue(inputImageFromMediaImage, "fromMediaImage(...)");
            Task<List<Barcode>> taskProcess = this.scanner.process(inputImageFromMediaImage);
            final Function1 function1 = new Function1() { // from class: com.mrousavy.camera.core.CodeScannerPipeline$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return CodeScannerPipeline.analyze$lambda$1(this.f$0, inputImageFromMediaImage, (List) obj);
                }
            };
            taskProcess.addOnSuccessListener(new OnSuccessListener() { // from class: com.mrousavy.camera.core.CodeScannerPipeline$$ExternalSyntheticLambda1
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    function1.invoke(obj);
                }
            }).addOnFailureListener(new OnFailureListener() { // from class: com.mrousavy.camera.core.CodeScannerPipeline$$ExternalSyntheticLambda2
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    CodeScannerPipeline.analyze$lambda$3(this.f$0, exc);
                }
            }).addOnCompleteListener(new OnCompleteListener() { // from class: com.mrousavy.camera.core.CodeScannerPipeline$$ExternalSyntheticLambda3
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    CodeScannerPipeline.analyze$lambda$4(imageProxy, task);
                }
            });
        } catch (Throwable th) {
            SentryLogcatAdapter.e(TAG, "Failed to process Image!", th);
            imageProxy.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit analyze$lambda$1(CodeScannerPipeline codeScannerPipeline, InputImage inputImage, List list) {
        Intrinsics.checkNotNull(list);
        if (!list.isEmpty()) {
            codeScannerPipeline.callback.onCodeScanned(list, new CodeScannerFrame(inputImage.getWidth(), inputImage.getHeight()));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void analyze$lambda$3(CodeScannerPipeline codeScannerPipeline, Exception error) {
        Intrinsics.checkNotNullParameter(error, "error");
        SentryLogcatAdapter.e(TAG, "Failed to process Image!", error);
        codeScannerPipeline.callback.onError(error);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void analyze$lambda$4(ImageProxy imageProxy, Task it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        imageProxy.close();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.scanner.close();
    }
}
