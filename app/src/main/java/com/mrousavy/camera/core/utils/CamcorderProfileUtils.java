package com.mrousavy.camera.core.utils;

import android.media.CamcorderProfile;
import android.media.EncoderProfiles;
import android.os.Build;
import android.util.Size;
import io.sentry.android.core.SentryLogcatAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class CamcorderProfileUtils {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "CamcorderProfileUtils";

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        private final int getResolutionForCamcorderProfileQuality(int i) {
            switch (i) {
                case 2:
                    return 25344;
                case 3:
                    return 101376;
                case 4:
                    return 345600;
                case 5:
                    return 921600;
                case 6:
                    return 2073600;
                case 7:
                    return 76800;
                case 8:
                    return 8294400;
                case 9:
                    return 307200;
                case 10:
                    return 8847360;
                case 11:
                    return 3686400;
                case 12:
                    return 2211840;
                case 13:
                    return 33177600;
                default:
                    throw new Error("Invalid CamcorderProfile \"" + i + "\"!");
            }
        }

        private final int findClosestCamcorderProfileQuality(String str, Size size, boolean z) {
            boolean zHasProfile;
            int width = size.getWidth() * size.getHeight();
            Integer intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(str);
            IntRange intRange = new IntRange(2, 13);
            ArrayList arrayList = new ArrayList();
            for (Integer num : intRange) {
                int iIntValue = num.intValue();
                if (intOrNull != null) {
                    zHasProfile = CamcorderProfile.hasProfile(intOrNull.intValue(), iIntValue);
                } else {
                    zHasProfile = CamcorderProfile.hasProfile(iIntValue);
                }
                if (zHasProfile) {
                    arrayList.add(num);
                }
            }
            if (!z) {
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : arrayList) {
                    if (CamcorderProfileUtils.Companion.getResolutionForCamcorderProfileQuality(((Number) obj).intValue()) <= width) {
                        arrayList2.add(obj);
                    }
                }
                arrayList = arrayList2;
            }
            Iterator it2 = arrayList.iterator();
            if (!it2.hasNext()) {
                throw new NoSuchElementException();
            }
            Object next = it2.next();
            if (it2.hasNext()) {
                int iAbs = Math.abs(CamcorderProfileUtils.Companion.getResolutionForCamcorderProfileQuality(((Number) next).intValue()) - width);
                do {
                    Object next2 = it2.next();
                    int iAbs2 = Math.abs(CamcorderProfileUtils.Companion.getResolutionForCamcorderProfileQuality(((Number) next2).intValue()) - width);
                    if (iAbs > iAbs2) {
                        next = next2;
                        iAbs = iAbs2;
                    }
                } while (it2.hasNext());
            }
            return ((Number) next).intValue();
        }

        public final Size getMaximumVideoSize(@NotNull String cameraId) {
            EncoderProfiles all;
            Object next;
            Intrinsics.checkNotNullParameter(cameraId, "cameraId");
            try {
                if (Build.VERSION.SDK_INT >= 31 && (all = CamcorderProfile.getAll(cameraId, 1)) != null) {
                    List videoProfiles = all.getVideoProfiles();
                    Intrinsics.checkNotNullExpressionValue(videoProfiles, "getVideoProfiles(...)");
                    Iterator it2 = CollectionsKt___CollectionsKt.filterNotNull(videoProfiles).iterator();
                    if (it2.hasNext()) {
                        next = it2.next();
                        if (it2.hasNext()) {
                            EncoderProfiles.VideoProfile videoProfileM = CamcorderProfileUtils$Companion$$ExternalSyntheticApiModelOutline2.m(next);
                            int width = videoProfileM.getWidth() * videoProfileM.getHeight();
                            do {
                                Object next2 = it2.next();
                                EncoderProfiles.VideoProfile videoProfileM2 = CamcorderProfileUtils$Companion$$ExternalSyntheticApiModelOutline2.m(next2);
                                int width2 = videoProfileM2.getWidth() * videoProfileM2.getHeight();
                                if (width < width2) {
                                    next = next2;
                                    width = width2;
                                }
                            } while (it2.hasNext());
                        }
                    } else {
                        next = null;
                    }
                    EncoderProfiles.VideoProfile videoProfileM3 = CamcorderProfileUtils$Companion$$ExternalSyntheticApiModelOutline2.m(next);
                    if (videoProfileM3 != null) {
                        return new Size(videoProfileM3.getWidth(), videoProfileM3.getHeight());
                    }
                }
                Integer intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(cameraId);
                if (intOrNull == null) {
                    return null;
                }
                CamcorderProfile camcorderProfile = CamcorderProfile.get(intOrNull.intValue(), 1);
                return new Size(camcorderProfile.videoFrameWidth, camcorderProfile.videoFrameHeight);
            } catch (Throwable th) {
                SentryLogcatAdapter.e(CamcorderProfileUtils.TAG, "Failed to get maximum video size for Camera ID " + cameraId + "! " + th.getMessage(), th);
                return null;
            }
        }

        public final Integer getMaximumFps(@NotNull String cameraId, @NotNull Size size) {
            EncoderProfiles all;
            Intrinsics.checkNotNullParameter(cameraId, "cameraId");
            Intrinsics.checkNotNullParameter(size, "size");
            try {
                int iFindClosestCamcorderProfileQuality = findClosestCamcorderProfileQuality(cameraId, size, false);
                if (Build.VERSION.SDK_INT >= 31 && (all = CamcorderProfile.getAll(cameraId, iFindClosestCamcorderProfileQuality)) != null) {
                    List videoProfiles = all.getVideoProfiles();
                    Intrinsics.checkNotNullExpressionValue(videoProfiles, "getVideoProfiles(...)");
                    Iterator it2 = videoProfiles.iterator();
                    if (!it2.hasNext()) {
                        throw new NoSuchElementException();
                    }
                    Integer numValueOf = Integer.valueOf(CamcorderProfileUtils$Companion$$ExternalSyntheticApiModelOutline2.m(it2.next()).getFrameRate());
                    while (it2.hasNext()) {
                        Integer numValueOf2 = Integer.valueOf(CamcorderProfileUtils$Companion$$ExternalSyntheticApiModelOutline2.m(it2.next()).getFrameRate());
                        if (numValueOf.compareTo(numValueOf2) < 0) {
                            numValueOf = numValueOf2;
                        }
                    }
                    Integer num = numValueOf;
                    return numValueOf;
                }
                Integer intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(cameraId);
                if (intOrNull != null) {
                    return Integer.valueOf(CamcorderProfile.get(intOrNull.intValue(), iFindClosestCamcorderProfileQuality).videoFrameRate);
                }
                return null;
            } catch (Throwable th) {
                SentryLogcatAdapter.e(CamcorderProfileUtils.TAG, "Failed to get maximum FPS for Camera ID " + cameraId + "! " + th.getMessage(), th);
                return null;
            }
        }

        public final Integer getRecommendedBitRate(@NotNull String cameraId, @NotNull Size videoSize) {
            EncoderProfiles all;
            Intrinsics.checkNotNullParameter(cameraId, "cameraId");
            Intrinsics.checkNotNullParameter(videoSize, "videoSize");
            try {
                int iFindClosestCamcorderProfileQuality = findClosestCamcorderProfileQuality(cameraId, videoSize, true);
                if (Build.VERSION.SDK_INT >= 31 && (all = CamcorderProfile.getAll(cameraId, iFindClosestCamcorderProfileQuality)) != null) {
                    List videoProfiles = all.getVideoProfiles();
                    Intrinsics.checkNotNullExpressionValue(videoProfiles, "getVideoProfiles(...)");
                    Iterator it2 = videoProfiles.iterator();
                    if (!it2.hasNext()) {
                        throw new NoSuchElementException();
                    }
                    Integer numValueOf = Integer.valueOf(CamcorderProfileUtils$Companion$$ExternalSyntheticApiModelOutline2.m(it2.next()).getBitrate());
                    while (it2.hasNext()) {
                        Integer numValueOf2 = Integer.valueOf(CamcorderProfileUtils$Companion$$ExternalSyntheticApiModelOutline2.m(it2.next()).getBitrate());
                        if (numValueOf.compareTo(numValueOf2) < 0) {
                            numValueOf = numValueOf2;
                        }
                    }
                    Integer num = numValueOf;
                    return numValueOf;
                }
                Integer intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(cameraId);
                if (intOrNull != null) {
                    return Integer.valueOf(CamcorderProfile.get(intOrNull.intValue(), iFindClosestCamcorderProfileQuality).videoBitRate);
                }
                return null;
            } catch (Throwable th) {
                SentryLogcatAdapter.e(CamcorderProfileUtils.TAG, "Failed to get recommended video bit-rate for Camera ID " + cameraId + "! " + th.getMessage(), th);
                return null;
            }
        }
    }
}
