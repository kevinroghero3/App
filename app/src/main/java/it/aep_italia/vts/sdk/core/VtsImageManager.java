package it.aep_italia.vts.sdk.core;

import io.sentry.protocol.DebugMeta;
import it.aep_italia.vts.sdk.VtsSdkConfiguration;
import it.aep_italia.vts.sdk.domain.enums.VtsObjectType;
import it.aep_italia.vts.sdk.domain.enums.VtsObjectTypeFormat;
import it.aep_italia.vts.sdk.dto.domain.VtsVTokenInfoDTO;
import it.aep_italia.vts.sdk.errors.VtsError;
import it.aep_italia.vts.sdk.errors.VtsException;
import it.aep_italia.vts.sdk.internal.VtsWellKnownStrings;
import it.aep_italia.vts.sdk.internal.database.SharedDatabase;
import it.aep_italia.vts.sdk.internal.database.images.ImageDao;
import it.aep_italia.vts.sdk.internal.database.images.StoredImage;
import it.aep_italia.vts.sdk.utils.ByteUtils;
import it.aep_italia.vts.sdk.utils.DateUtils;
import it.aep_italia.vts.sdk.utils.DeviceUtils;
import it.aep_italia.vts.sdk.utils.ListenableFuture;
import it.aep_italia.vts.sdk.utils.StreamUtils;
import it.aep_italia.vts.sdk.utils.StringUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes6.dex */
public final class VtsImageManager {
    private VtsSdk a;
    private Map<Long, CountDownLatch> b = new ConcurrentHashMap();
    private Map<Long, Long> c = new ConcurrentHashMap();

    class a implements Runnable {
        final /* synthetic */ long a;
        final /* synthetic */ boolean b;
        final /* synthetic */ ListenableFuture c;

        a(long j, boolean z, ListenableFuture listenableFuture) {
            this.a = j;
            this.b = z;
            this.c = listenableFuture;
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            try {
                this.c.setResultOnUiThread(VtsImageManager.this.downloadImageSynchronously(this.a, this.b));
            } catch (VtsException unused) {
                this.c.setResultOnUiThread(null);
            }
        }
    }

    static /* synthetic */ class b {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[VtsObjectType.values().length];
            b = iArr;
            try {
                iArr[VtsObjectType.BACK_COP_IMAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[VtsObjectType.CRYPTOGRAM_OR_QR_CODE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[VtsObjectType.FRONT_COP_IMAGE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[VtsObjectType.GENERIC_IMAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                b[VtsObjectType.USER_PICTURE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr2 = new int[VtsObjectTypeFormat.values().length];
            a = iArr2;
            try {
                iArr2[VtsObjectTypeFormat.BMP.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[VtsObjectTypeFormat.JPEG.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[VtsObjectTypeFormat.PNG.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    VtsImageManager(VtsSdk vtsSdk) {
        this.a = vtsSdk;
    }

    private File a(long j) {
        String fullHexString = StringUtils.toFullHexString(Long.valueOf(j));
        return new File(b(), String.format(Locale.ITALY, "%d_%d_%s.image", Integer.valueOf(this.a.getSystemType()), Integer.valueOf(this.a.getSystemSubType()), fullHexString));
    }

    private void a(VtsVTokenInfoDTO vtsVTokenInfoDTO, byte[] bArr) throws VtsException {
        synchronized (this) {
            try {
                long jUnsignedHexStringToSignedLong = StringUtils.unsignedHexStringToSignedLong(vtsVTokenInfoDTO.getVTokenUID());
                long time = new Date().getTime();
                StoredImage storedImage = new StoredImage(jUnsignedHexStringToSignedLong, bArr.length, time, time, vtsVTokenInfoDTO.getSignatureCount());
                c().saveImage(storedImage);
                this.c.put(Long.valueOf(jUnsignedHexStringToSignedLong), Long.valueOf(storedImage.getDownloadDate()));
                StreamUtils.writeAndClose(bArr, new FileOutputStream(a(jUnsignedHexStringToSignedLong)));
            } catch (Exception e) {
                throw new VtsException(VtsError.COULD_NOT_SAVE_IMAGE, e);
            }
        }
    }

    private boolean a(VtsVTokenInfoDTO vtsVTokenInfoDTO) throws VtsException {
        int i;
        int i2 = b.a[vtsVTokenInfoDTO.getVtsObjectTypeFormat().ordinal()];
        return i2 == 1 || i2 == 2 || i2 == 3 || (i = b.b[vtsVTokenInfoDTO.getVtsObjectType().ordinal()]) == 1 || i == 2 || i == 3 || i == 4 || i == 5;
    }

    private File b() {
        File externalFilesDir = this.a.getSdkConfiguration().dataOnExternal() ? this.a.getContext().getExternalFilesDir(DebugMeta.JsonKeys.IMAGES) : new File(this.a.getContext().getFilesDir(), DebugMeta.JsonKeys.IMAGES);
        if (!externalFilesDir.exists()) {
            externalFilesDir.mkdirs();
        }
        return externalFilesDir;
    }

    private boolean b(VtsVTokenInfoDTO vtsVTokenInfoDTO) throws Exception {
        try {
            StoredImage byVTokenUID = c().readByVTokenUID(StringUtils.unsignedHexStringToSignedLong(vtsVTokenInfoDTO.getVTokenUID()));
            return (byVTokenUID == null || byVTokenUID.getSignatureCount() == vtsVTokenInfoDTO.getSignatureCount()) ? false : true;
        } catch (Exception e) {
            if (e instanceof VtsException) {
                throw e;
            }
            throw new VtsException(VtsError.SYNCHRONIZATION_FAILED, e);
        }
    }

    private byte[] b(long j) throws VtsException {
        File fileA = a(j);
        if (!fileA.exists()) {
            return null;
        }
        try {
            byte[] bArrExtractAllAndClose = StreamUtils.extractAllAndClose(new FileInputStream(fileA));
            if (j == 0) {
                return bArrExtractAllAndClose;
            }
            long time = new Date().getTime();
            Long l = this.c.get(Long.valueOf(j));
            if (l == null || time - l.longValue() >= TimeUnit.HOURS.toMillis(1L)) {
                try {
                    ImageDao imageDaoC = c();
                    StoredImage byVTokenUID = imageDaoC.readByVTokenUID(j);
                    if (byVTokenUID != null) {
                        byVTokenUID.setUsageDate(new Date().getTime());
                        imageDaoC.updateImage(byVTokenUID);
                    }
                } catch (Exception e) {
                    VtsLog.e(e, "Could not update image metadata", new Object[0]);
                }
            }
            this.c.put(Long.valueOf(j), Long.valueOf(time));
            return bArrExtractAllAndClose;
        } catch (Exception e2) {
            throw new VtsException(VtsError.COULD_NOT_LOAD_IMAGE, e2);
        }
    }

    private ImageDao c() {
        return SharedDatabase.getInstance(this.a).imageDao();
    }

    private void c(long j) {
        this.c.remove(Long.valueOf(j));
        a(j).delete();
    }

    private void c(VtsVTokenInfoDTO vtsVTokenInfoDTO) throws Exception {
        VtsLog.d("Synchronizing image %s...", vtsVTokenInfoDTO.getVTokenUID());
        try {
            downloadImageSynchronously(vtsVTokenInfoDTO.getVTokenUIDAsLong(), true);
            VtsLog.d("Synchronization of image %s completed.", vtsVTokenInfoDTO.getVTokenUID());
        } catch (Exception e) {
            VtsLog.e(e, "Synchronization of image %s failed.", vtsVTokenInfoDTO.getVTokenUID());
            throw e;
        }
    }

    void a() {
        VtsSdkConfiguration sdkConfiguration = this.a.getSdkConfiguration();
        if (sdkConfiguration.imagesCleanupDisabled()) {
            return;
        }
        ImageDao imageDaoC = c();
        double totalSize = (((double) imageDaoC.readTotalSize()) / 1024.0d) / 1024.0d;
        if (totalSize <= sdkConfiguration.getImagesCleanupSpaceThreshold()) {
            return;
        }
        VtsLog.d("Starting image cleanup (current size: %.2f megabytes)...", Double.valueOf(totalSize));
        List<StoredImage> byNotUsedSince = imageDaoC.readByNotUsedSince(new Date().getTime() - TimeUnit.DAYS.toMillis(this.a.c().getNumericParameter(VtsWellKnownStrings.PARAM_IMAGE_TTL, 7L)));
        int i = 0;
        for (StoredImage storedImage : byNotUsedSince) {
            VtsLog.d("Removing image %s (last used: %s)...", StringUtils.toFullHexString(Long.valueOf(storedImage.getVTokenUID())), DateUtils.toHumanShort(new Date(storedImage.getUsageDate())));
            c(storedImage.getVTokenUID());
            i++;
        }
        imageDaoC.deleteImages(byNotUsedSince);
        VtsLog.d("Image cleanup completed, removed %d images.", Integer.valueOf(i));
    }

    void a(List<VtsVTokenInfoDTO> list) throws Exception {
        VtsLog.d("Starting image synchronization...", new Object[0]);
        ArrayList<VtsVTokenInfoDTO> arrayList = new ArrayList();
        int i = 0;
        for (VtsVTokenInfoDTO vtsVTokenInfoDTO : list) {
            if (StringUtils.isHexNumber(vtsVTokenInfoDTO.getVTokenUID()) && a(vtsVTokenInfoDTO)) {
                i++;
                if (b(vtsVTokenInfoDTO)) {
                    arrayList.add(vtsVTokenInfoDTO);
                }
            }
        }
        VtsLog.d("Found %d images, %d of them need synchronization (will skip %d).", Integer.valueOf(i), Integer.valueOf(arrayList.size()), Integer.valueOf(i - arrayList.size()));
        int i2 = 0;
        for (VtsVTokenInfoDTO vtsVTokenInfoDTO2 : arrayList) {
            if (!DeviceUtils.isOnWiFiNetwork(this.a.getContext())) {
                double dataDownloadedToday = (this.a.getDataDownloadedToday() / 1024.0d) / 1024.0d;
                int mobileSyncDailyLimit = this.a.getSdkConfiguration().getMobileSyncDailyLimit();
                VtsLog.d("Current data download limit: %.2f / %d MB", Double.valueOf(dataDownloadedToday), Integer.valueOf(mobileSyncDailyLimit));
                if (dataDownloadedToday >= mobileSyncDailyLimit) {
                    VtsLog.i("Daily download limit reached, stopping image synchronization.", new Object[0]);
                    break;
                }
            }
            try {
                c(vtsVTokenInfoDTO2);
            } catch (VtsException e) {
                VtsLog.e(e, "Synchronization of image %s failed.", vtsVTokenInfoDTO2.getVTokenUID());
                i2++;
            }
        }
        if (i2 > 0) {
            VtsLog.d("Failed to synchronize %d images.", Integer.valueOf(i2));
        }
    }

    public ListenableFuture<byte[]> downloadImageAsynchronously(long j, boolean z) throws VtsException {
        ListenableFuture<byte[]> listenableFuture = new ListenableFuture<>();
        new Thread(new a(j, z, listenableFuture)).start();
        return listenableFuture;
    }

    /* JADX WARN: Code duplicated, block: B:51:0x00ec A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [it.aep_italia.vts.sdk.core.VtsConnection] */
    /* JADX WARN: Type inference failed for: r2v6 */
    public byte[] downloadImageSynchronously(long j, boolean z) throws Throwable {
        Exception e;
        VtsConnection vtsConnectionE;
        String fullHexString = StringUtils.toFullHexString(Long.valueOf(j));
        this.a.a("VtsImageManager#downloadImageSynchronously", StringUtils.stringifyParams("ImageUID", Long.valueOf(j), "BypassCache", Boolean.valueOf(z)));
        if (hasImage(j) && !z) {
            VtsLog.d("Image %s has been found in cache, skipping download.", fullHexString);
            return b(j);
        }
        CountDownLatch countDownLatch = this.b.get(Long.valueOf(j));
        ?? r2 = 0;
        if (countDownLatch != null) {
            VtsLog.d("Image %s is already being downloaded, deferring download.", fullHexString);
            try {
                countDownLatch.await();
                return b(j);
            } catch (InterruptedException unused) {
                return null;
            }
        }
        VtsLog.d("Downloading image %s...", fullHexString);
        CountDownLatch countDownLatch2 = new CountDownLatch(1);
        Map<Long, CountDownLatch> map = this.b;
        Long lValueOf = Long.valueOf(j);
        map.put(lValueOf, countDownLatch2);
        try {
            try {
                vtsConnectionE = this.a.e();
                try {
                    VtsVTokenInfoDTO vtsVTokenInfoDTOA = vtsConnectionE.a(j);
                    if (vtsVTokenInfoDTOA.getTokenContents() != null) {
                        byte[] tokenContents = vtsVTokenInfoDTOA.getTokenContents();
                        byte[] bArrExtract = ByteUtils.extract(tokenContents, 57, tokenContents.length);
                        a(vtsVTokenInfoDTOA, bArrExtract);
                        VtsLog.d("Successfully downloaded image %s.", fullHexString);
                        try {
                            vtsConnectionE.closeConnection();
                        } catch (Exception e2) {
                            VtsLog.e(e2, "Could not close connection", new Object[0]);
                        }
                        countDownLatch2.countDown();
                        this.b.remove(Long.valueOf(j));
                        return bArrExtract;
                    }
                    try {
                        vtsConnectionE.closeConnection();
                    } catch (Exception e3) {
                        VtsLog.e(e3, "Could not close connection", new Object[0]);
                    }
                } catch (Exception e4) {
                    e = e4;
                    VtsLog.e(e, "Could not download image %s", fullHexString);
                    if (vtsConnectionE != null) {
                        try {
                            vtsConnectionE.closeConnection();
                        } catch (Exception e5) {
                            VtsLog.e(e5, "Could not close connection", new Object[0]);
                        }
                    }
                }
            } catch (Exception e6) {
                e = e6;
                vtsConnectionE = null;
            } catch (Throwable th) {
                th = th;
                if (r2 != 0) {
                    try {
                        r2.closeConnection();
                    } catch (Exception e7) {
                        VtsLog.e(e7, "Could not close connection", new Object[0]);
                    }
                }
                countDownLatch2.countDown();
                this.b.remove(Long.valueOf(j));
                throw th;
            }
            countDownLatch2.countDown();
            this.b.remove(Long.valueOf(j));
            return null;
        } catch (Throwable th2) {
            th = th2;
            r2 = lValueOf;
            if (r2 != 0) {
                r2.closeConnection();
            }
            countDownLatch2.countDown();
            this.b.remove(Long.valueOf(j));
            throw th;
        }
    }

    public boolean hasImage(long j) {
        try {
            return a(j).exists();
        } catch (Exception unused) {
            return false;
        }
    }

    public byte[] loadUserPhoto() throws VtsException {
        this.a.a("VtsImageManager#loadUserPhoto");
        if (hasImage(0L)) {
            return b(0L);
        }
        return null;
    }

    public void saveUserPhoto(byte[] bArr) throws VtsException {
        this.a.a("VtsImageManager#saveUserPhoto", StringUtils.stringifyParams("Data", bArr));
        if (bArr == null) {
            c(0L);
            return;
        }
        try {
            StreamUtils.writeAndClose(bArr, new FileOutputStream(a(0L)));
        } catch (Exception e) {
            throw new VtsException(VtsError.COULD_NOT_SAVE_IMAGE, e);
        }
    }
}
