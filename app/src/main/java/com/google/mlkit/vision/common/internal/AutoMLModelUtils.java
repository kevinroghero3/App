package com.google.mlkit.vision.common.internal;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.mlkit.common.internal.model.ModelUtils;
import com.google.mlkit.common.model.LocalModel;
import com.google.mlkit.common.sdkinternal.Constants;
import io.sentry.instrumentation.file.SentryFileInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import o.ArtificialStackFrames;
import org.apache.commons.lang3.CharEncoding;

/* JADX INFO: loaded from: classes5.dex */
public class AutoMLModelUtils {
    private static int artificialFrame = 1;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME;

    private AutoMLModelUtils() {
    }

    public static String[] getModelAndLabelFilePaths(@NonNull Context context, @NonNull LocalModel localModel, boolean z) throws Throwable {
        String string;
        String string2 = z ? (String) Preconditions.checkNotNull(localModel.getAssetFilePath()) : (String) Preconditions.checkNotNull(localModel.getAbsoluteFilePath());
        if (localModel.isManifestFile()) {
            ModelUtils.AutoMLManifest manifestFile = ModelUtils.parseManifestFile(string2, z, context);
            if (manifestFile == null) {
                throw new IOException("Failed to parse manifest file.");
            }
            Preconditions.checkState(Constants.AUTOML_IMAGE_LABELING_MODEL_TYPE.equals(manifestFile.getModelType()), "Model type should be: %s.", Constants.AUTOML_IMAGE_LABELING_MODEL_TYPE);
            string2 = new File(new File(string2).getParent(), manifestFile.getModelFile()).toString();
            string = new File(new File(string2).getParent(), manifestFile.getLabelsFile()).toString();
        } else {
            string = "";
        }
        return new String[]{string2, string};
    }

    public static List<String> readLabelsFile(@NonNull Context context, @NonNull String str, boolean z) throws Throwable {
        InputStream inputStreamCreate;
        int i = 2 % 2;
        ArrayList arrayList = new ArrayList();
        if (z) {
            int i2 = artificialFrame + 119;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i2 % 128;
            try {
                if (i2 % 2 != 0) {
                    Object[] objArr = {context.getAssets(), str};
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-982065286);
                    if (objAccessartificialFrame == null) {
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(12 - (KeyEvent.getMaxKeyCode() >> 16), (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 7115), 38 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), 1511233906, false, "accessartificialFrame", new Class[]{AssetManager.class, String.class});
                    }
                    throw null;
                }
                Object[] objArr2 = {context.getAssets(), str};
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-982065286);
                if (objAccessartificialFrame2 == null) {
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(13 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (char) ((KeyEvent.getMaxKeyCode() >> 16) + 7116), 37 - (ViewConfiguration.getScrollDefaultDelay() >> 16), 1511233906, false, "accessartificialFrame", new Class[]{AssetManager.class, String.class});
                }
                inputStreamCreate = (InputStream) ((Method) objAccessartificialFrame2).invoke(null, objArr2);
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        } else {
            File file = new File(str);
            inputStreamCreate = SentryFileInputStream.Factory.create(new FileInputStream(file), file);
        }
        InputStream inputStream = inputStreamCreate;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, CharEncoding.UTF_8));
            String line = bufferedReader.readLine();
            int i3 = getARTIFICIAL_FRAME_PACKAGE_NAME + 97;
            artificialFrame = i3 % 128;
            int i4 = i3 % 2;
            while (line != null) {
                arrayList.add(line);
                line = bufferedReader.readLine();
                int i5 = getARTIFICIAL_FRAME_PACKAGE_NAME + 69;
                artificialFrame = i5 % 128;
                int i6 = i5 % 2;
            }
            if (inputStream != null) {
                inputStream.close();
            }
            return arrayList;
        } catch (Throwable th2) {
            if (inputStream == null) {
                throw th2;
            }
            int i7 = artificialFrame + 79;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i7 % 128;
            int i8 = i7 % 2;
            try {
                inputStream.close();
                throw th2;
            } catch (Throwable th3) {
                try {
                    Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th2, th3);
                    throw th2;
                } catch (Exception unused) {
                    throw th2;
                }
            }
        }
    }
}
