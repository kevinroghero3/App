package com.google.mlkit.common.internal.model;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.net.Uri;
import android.telephony.cdma.CdmaCellLocation;
import android.view.KeyEvent;
import android.widget.ExpandableListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.mlkit_common.zzh;
import com.google.android.gms.internal.mlkit_common.zzi;
import com.google.android.gms.internal.mlkit_common.zzu;
import com.google.mlkit.common.model.LocalModel;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;
import io.sentry.instrumentation.file.SentryFileInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import o.ArtificialStackFrames;

/* JADX INFO: loaded from: classes5.dex */
public class ModelUtils {
    private static int artificialFrame = 1;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME;
    private static final GmsLogger zza = new GmsLogger("ModelUtils", "");

    public static abstract class AutoMLManifest {
        public abstract String getLabelsFile();

        public abstract String getModelFile();

        public abstract String getModelType();
    }

    public static abstract class ModelLoggingInfo {
        static ModelLoggingInfo zza(long j, @Nullable String str, boolean z) {
            return new AutoValue_ModelUtils_ModelLoggingInfo(j, zzu.zzb(str), z);
        }

        public abstract String getHash();

        public abstract long getSize();

        public abstract boolean isManifestModel();
    }

    private ModelUtils() {
    }

    public static String getSHA256(@NonNull File file) {
        try {
            FileInputStream fileInputStreamCreate = SentryFileInputStream.Factory.create(new FileInputStream(file), file);
            try {
                String strZzc = zzc(fileInputStreamCreate);
                fileInputStreamCreate.close();
                return strZzc;
            } catch (Throwable th) {
                try {
                    fileInputStreamCreate.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException e) {
            zza.e("ModelUtils", "Failed to create FileInputStream for model: ".concat(e.toString()));
            return null;
        }
    }

    public static boolean zza(@NonNull File file, @NonNull String str) {
        String sha256 = getSHA256(file);
        zza.d("ModelUtils", "Calculated hash value is: ".concat(String.valueOf(sha256)));
        return str.equals(sha256);
    }

    private static String zzb(Context context, String str, boolean z) throws Throwable {
        AutoMLManifest manifestFile = parseManifestFile(str, z, context);
        if (manifestFile != null) {
            return new File(new File(str).getParent(), manifestFile.getModelFile()).toString();
        }
        zza.e("ModelUtils", "Failed to parse manifest file.");
        return null;
    }

    private static String zzc(InputStream inputStream) {
        int i;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] bArr = new byte[1048576];
            while (true) {
                int i2 = inputStream.read(bArr);
                if (i2 == -1) {
                    break;
                }
                messageDigest.update(bArr, 0, i2);
            }
            byte[] bArrDigest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : bArrDigest) {
                String hexString = Integer.toHexString(b & 255);
                if (hexString.length() == 1) {
                    sb.append('0');
                }
                sb.append(hexString);
            }
            return sb.toString();
        } catch (IOException unused) {
            zza.e("ModelUtils", "Failed to read model file");
            return null;
        } catch (NoSuchAlgorithmException unused2) {
            zza.e("ModelUtils", "Do not have SHA-256 algorithm");
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x007a, code lost:
    
        if (new java.io.File(r18).exists() == false) goto L70;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.mlkit.common.internal.model.ModelUtils.AutoMLManifest parseManifestFile(@androidx.annotation.NonNull java.lang.String r18, boolean r19, @androidx.annotation.NonNull android.content.Context r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 462
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.mlkit.common.internal.model.ModelUtils.parseManifestFile(java.lang.String, boolean, android.content.Context):com.google.mlkit.common.internal.model.ModelUtils$AutoMLManifest");
    }

    /* JADX WARN: Code duplicated, block: B:145:0x01ae A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:158:? A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v5 */
    public static ModelLoggingInfo getModelLoggingInfo(@NonNull Context context, @NonNull LocalModel localModel) throws Throwable {
        long length;
        String string;
        InputStream inputStream;
        Throwable th;
        InputStream inputStreamZzb;
        String strZzc;
        int i = 2 % 2;
        int i2 = artificialFrame + 37;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i2 % 128;
        Object obj = null;
        ?? r3 = 0;
        if (i2 % 2 != 0) {
            localModel.getAssetFilePath();
            localModel.getAbsoluteFilePath();
            localModel.getUri();
            obj.hashCode();
            throw null;
        }
        String assetFilePath = localModel.getAssetFilePath();
        String absoluteFilePath = localModel.getAbsoluteFilePath();
        Uri uri = localModel.getUri();
        if (assetFilePath != null) {
            if (localModel.isManifestFile() && (assetFilePath = zzb(context, assetFilePath, true)) == null) {
                return null;
            }
            try {
                AssetFileDescriptor assetFileDescriptorOpenFd = context.getAssets().openFd(assetFilePath);
                try {
                    length = assetFileDescriptorOpenFd.getLength();
                    assetFileDescriptorOpenFd.close();
                } catch (Throwable th2) {
                    if (assetFileDescriptorOpenFd == null) {
                        throw th2;
                    }
                    try {
                        assetFileDescriptorOpenFd.close();
                        throw th2;
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                        throw th2;
                    }
                }
            } catch (IOException e) {
                zza.e("ModelUtils", "Failed to open model file", e);
                return null;
            }
        } else if (absoluteFilePath != null) {
            if (localModel.isManifestFile() && (absoluteFilePath = zzb(context, absoluteFilePath, false)) == null) {
                return null;
            }
            length = new File(absoluteFilePath).length();
        } else {
            if (uri == null) {
                zza.e("ModelUtils", "Local model doesn't have any valid path.");
                return null;
            }
            try {
                AssetFileDescriptor assetFileDescriptorZza = zzi.zza(context, uri, "r");
                try {
                    length = assetFileDescriptorZza.getLength();
                    assetFileDescriptorZza.close();
                } catch (Throwable th4) {
                    if (assetFileDescriptorZza == null) {
                        throw th4;
                    }
                    try {
                        assetFileDescriptorZza.close();
                        throw th4;
                    } catch (Throwable th5) {
                        th4.addSuppressed(th5);
                        throw th4;
                    }
                }
            } catch (IOException e2) {
                zza.e("ModelUtils", "Failed to open model file", e2);
                return null;
            }
        }
        SharedPrefManager sharedPrefManager = (SharedPrefManager) MlKitContext.getInstance().get(SharedPrefManager.class);
        if (assetFilePath != null) {
            string = assetFilePath;
        } else {
            string = absoluteFilePath != null ? absoluteFilePath : ((Uri) Preconditions.checkNotNull(uri)).toString();
        }
        String strZzb = sharedPrefManager.zzb(string, length);
        if (strZzb != null) {
            int i3 = artificialFrame + 73;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i3 % 128;
            if (i3 % 2 == 0) {
                return ModelLoggingInfo.zza(length, strZzb, localModel.isManifestFile());
            }
            int i4 = 73 / 0;
            return ModelLoggingInfo.zza(length, strZzb, localModel.isManifestFile());
        }
        try {
            try {
                if (assetFilePath != null) {
                    try {
                        Object[] objArr = {context.getAssets(), assetFilePath};
                        Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-982065286);
                        if (objAccessartificialFrame == null) {
                            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(11 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), (char) (7116 - KeyEvent.normalizeMetaState(0)), (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + 37, 1511233906, false, "accessartificialFrame", new Class[]{AssetManager.class, String.class});
                        }
                        inputStreamZzb = (InputStream) ((Method) objAccessartificialFrame).invoke(null, objArr);
                    } catch (Throwable th6) {
                        Throwable cause = th6.getCause();
                        if (cause != null) {
                            throw cause;
                        }
                        throw th6;
                    }
                } else if (absoluteFilePath != null) {
                    File file = new File(absoluteFilePath);
                    inputStreamZzb = SentryFileInputStream.Factory.create(new FileInputStream(file), file);
                } else {
                    Uri uri2 = (Uri) Preconditions.checkNotNull(uri);
                    int i5 = zzi.zza;
                    inputStreamZzb = zzi.zzb(context, uri2, zzh.zza);
                }
                inputStream = inputStreamZzb;
                try {
                    if (inputStream != null) {
                        int i6 = artificialFrame + 27;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i6 % 128;
                        if (i6 % 2 != 0) {
                            zzc(inputStream);
                            throw null;
                        }
                        strZzc = zzc(inputStream);
                    } else {
                        strZzc = null;
                    }
                    if (strZzc != null) {
                        int i7 = artificialFrame + 105;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i7 % 128;
                        int i8 = i7 % 2;
                        sharedPrefManager.zzc(string, length, strZzc);
                    }
                    ModelLoggingInfo modelLoggingInfoZza = ModelLoggingInfo.zza(length, strZzc, localModel.isManifestFile());
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e3) {
                            zza.e("ModelUtils", "Failed to close model file", e3);
                        }
                    }
                    return modelLoggingInfoZza;
                } catch (IOException e4) {
                    e = e4;
                    zza.e("ModelUtils", "Failed to open model file", e);
                    if (inputStream != null) {
                        int i9 = getARTIFICIAL_FRAME_PACKAGE_NAME + 33;
                        artificialFrame = i9 % 128;
                        try {
                            if (i9 % 2 == 0) {
                                inputStream.close();
                                try {
                                    throw null;
                                } catch (Throwable th7) {
                                    throw th7;
                                }
                            }
                            inputStream.close();
                        } catch (IOException e5) {
                            zza.e("ModelUtils", "Failed to close model file", e5);
                        }
                    }
                    return null;
                }
            } catch (IOException e6) {
                e = e6;
                inputStream = null;
            } catch (Throwable th8) {
                th = th8;
                th = th;
                if (r3 != 0) {
                    throw th;
                }
                try {
                    r3.close();
                    throw th;
                } catch (IOException e7) {
                    zza.e("ModelUtils", "Failed to close model file", e7);
                    throw th;
                }
            }
        } catch (Throwable th9) {
            th = th9;
            r3 = assetFilePath;
            th = th;
            if (r3 != 0) {
                throw th;
            }
            r3.close();
            throw th;
        }
    }
}
