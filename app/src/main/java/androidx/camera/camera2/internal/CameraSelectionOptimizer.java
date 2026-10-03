package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCharacteristics;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.camera2.internal.compat.CameraManagerCompat;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.CameraUnavailableException;
import androidx.camera.core.InitializationException;
import androidx.camera.core.impl.CameraInfoInternal;
import com.facebook.appevents.AppEventsConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
class CameraSelectionOptimizer {
    private CameraSelectionOptimizer() {
    }

    static List<String> getSelectedAvailableCameraIds(@NonNull Camera2CameraFactory camera2CameraFactory, @Nullable CameraSelector cameraSelector) throws InitializationException {
        String strDecideSkippedCameraIdByHeuristic;
        try {
            ArrayList arrayList = new ArrayList();
            List<String> listAsList = Arrays.asList(camera2CameraFactory.getCameraManager().getCameraIdList());
            if (cameraSelector == null) {
                Iterator it2 = listAsList.iterator();
                while (it2.hasNext()) {
                    arrayList.add((String) it2.next());
                }
                return arrayList;
            }
            try {
                strDecideSkippedCameraIdByHeuristic = decideSkippedCameraIdByHeuristic(camera2CameraFactory.getCameraManager(), cameraSelector.getLensFacing(), listAsList);
            } catch (IllegalStateException unused) {
                strDecideSkippedCameraIdByHeuristic = null;
            }
            ArrayList arrayList2 = new ArrayList();
            for (String str : listAsList) {
                if (!str.equals(strDecideSkippedCameraIdByHeuristic)) {
                    arrayList2.add(camera2CameraFactory.getCameraInfo(str));
                }
            }
            Iterator<CameraInfo> it3 = cameraSelector.filter(arrayList2).iterator();
            while (it3.hasNext()) {
                arrayList.add(((CameraInfoInternal) it3.next()).getCameraId());
            }
            return arrayList;
        } catch (CameraAccessExceptionCompat e) {
            throw new InitializationException(CameraUnavailableExceptionHelper.createFrom(e));
        } catch (CameraUnavailableException e2) {
            throw new InitializationException(e2);
        }
    }

    private static String decideSkippedCameraIdByHeuristic(CameraManagerCompat cameraManagerCompat, Integer num, List<String> list) throws CameraAccessExceptionCompat {
        if (num == null || !list.contains(AppEventsConstants.EVENT_PARAM_VALUE_NO) || !list.contains(AppEventsConstants.EVENT_PARAM_VALUE_YES)) {
            return null;
        }
        if (num.intValue() == 1) {
            if (((Integer) cameraManagerCompat.getCameraCharacteristicsCompat(AppEventsConstants.EVENT_PARAM_VALUE_NO).get(CameraCharacteristics.LENS_FACING)).intValue() == 1) {
                return AppEventsConstants.EVENT_PARAM_VALUE_YES;
            }
            return null;
        }
        if (num.intValue() == 0 && ((Integer) cameraManagerCompat.getCameraCharacteristicsCompat(AppEventsConstants.EVENT_PARAM_VALUE_YES).get(CameraCharacteristics.LENS_FACING)).intValue() == 0) {
            return AppEventsConstants.EVENT_PARAM_VALUE_NO;
        }
        return null;
    }
}
