package com.salesforce.marketingcloud.sfmcsdk.util;

import android.content.Context;
import com.salesforce.marketingcloud.sfmcsdk.components.http.RequestKt;
import com.salesforce.marketingcloud.sfmcsdk.components.logging.SFMCSdkLogger;
import java.io.BufferedReader;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt__FileReadWriteKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class FileUtilsKt {
    public static final String SDK_PACKAGE_PREFIX = "com.salesforce.marketingcloud";

    public static final String getFilenamePrefixForSFMCSdk(@NotNull String filename) {
        Intrinsics.checkNotNullParameter(filename, "filename");
        return "com.salesforce.marketingcloud_sfmcsdk_" + filename;
    }

    public static final String getFilenamePrefixForModule(@NotNull String moduleApplicationId) {
        Intrinsics.checkNotNullParameter(moduleApplicationId, "moduleApplicationId");
        return "com.salesforce.marketingcloud_" + moduleApplicationId;
    }

    public static final String getFilenamePrefixForModuleInstallation(@NotNull String moduleApplicationId, @NotNull String registrationId) {
        Intrinsics.checkNotNullParameter(moduleApplicationId, "moduleApplicationId");
        Intrinsics.checkNotNullParameter(registrationId, "registrationId");
        return getFilenamePrefixForModule(moduleApplicationId) + "_" + registrationId;
    }

    public static final String getFilenameForModuleInstallation(@NotNull String filename, @NotNull String moduleApplicationId, @NotNull String registrationId) {
        Intrinsics.checkNotNullParameter(filename, "filename");
        Intrinsics.checkNotNullParameter(moduleApplicationId, "moduleApplicationId");
        Intrinsics.checkNotNullParameter(registrationId, "registrationId");
        return getFilenamePrefixForModuleInstallation(moduleApplicationId, registrationId) + "_" + filename;
    }

    public static final void storeModuleKey(@NotNull Context context, @NotNull String moduleName, @NotNull String keyValue) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        Intrinsics.checkNotNullParameter(keyValue, "keyValue");
        try {
            FilesKt__FileReadWriteKt.writeText$default(new File(context.getNoBackupFilesDir(), moduleName), keyValue, null, 2, null);
        } catch (Exception unused) {
            SFMCSdkLogger.INSTANCE.e("~$SFMCSdkStorage", new Function0<String>() { // from class: com.salesforce.marketingcloud.sfmcsdk.util.FileUtilsKt.storeModuleKey.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Failed to write module key to file";
                }
            });
        }
    }

    public static final String retrieveModuleKey(@NotNull Context context, @NotNull String moduleApplicationId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(moduleApplicationId, "moduleApplicationId");
        try {
            File file = new File(context.getNoBackupFilesDir(), moduleApplicationId);
            if (file.exists()) {
                String text$default = FilesKt__FileReadWriteKt.readText$default(file, null, 1, null);
                if (!StringsKt__StringsKt.isBlank(text$default)) {
                    return text$default;
                }
            }
        } catch (Exception unused) {
            SFMCSdkLogger.INSTANCE.e("~$SFMCSdkStorage", new Function0<String>() { // from class: com.salesforce.marketingcloud.sfmcsdk.util.FileUtilsKt.retrieveModuleKey.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Caught exception trying to retrieve module key from file";
                }
            });
        }
        return null;
    }

    public static final void wipeModuleFiles(@NotNull Context context, @NotNull final String moduleApplicationId) {
        File[] fileArrListFiles;
        File[] fileArrListFiles2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(moduleApplicationId, "moduleApplicationId");
        try {
            File parentFile = context.getDatabasePath(moduleApplicationId).getParentFile();
            if (parentFile != null && parentFile.isDirectory() && (fileArrListFiles2 = parentFile.listFiles(new FilenameFilter() { // from class: com.salesforce.marketingcloud.sfmcsdk.util.FileUtilsKt$$ExternalSyntheticLambda0
                @Override // java.io.FilenameFilter
                public final boolean accept(File file, String str) {
                    return FileUtilsKt.wipeModuleFiles$lambda$0(moduleApplicationId, file, str);
                }
            })) != null) {
                for (final File file : fileArrListFiles2) {
                    SFMCSdkLogger.INSTANCE.w("~$SFMCSdkStorage", new Function0<String>() { // from class: com.salesforce.marketingcloud.sfmcsdk.util.FileUtilsKt$wipeModuleFiles$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return "Deleting Database File: " + file.getName();
                        }
                    });
                    file.delete();
                }
            }
        } catch (Exception unused) {
            SFMCSdkLogger.INSTANCE.w("~$SFMCSdkStorage", new Function0<String>() { // from class: com.salesforce.marketingcloud.sfmcsdk.util.FileUtilsKt.wipeModuleFiles.3
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Caught exception trying to delete database file";
                }
            });
        }
        try {
            File file2 = new File(context.getFilesDir().getParent() + "/shared_prefs");
            if (!file2.isDirectory() || (fileArrListFiles = file2.listFiles(new FilenameFilter() { // from class: com.salesforce.marketingcloud.sfmcsdk.util.FileUtilsKt$$ExternalSyntheticLambda1
                @Override // java.io.FilenameFilter
                public final boolean accept(File file3, String str) {
                    return FileUtilsKt.wipeModuleFiles$lambda$2(moduleApplicationId, file3, str);
                }
            })) == null) {
                return;
            }
            for (final File file3 : fileArrListFiles) {
                SFMCSdkLogger.INSTANCE.w("~$SFMCSdkStorage", new Function0<String>() { // from class: com.salesforce.marketingcloud.sfmcsdk.util.FileUtilsKt$wipeModuleFiles$5$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Deleting SharedPreferences File: " + file3.getName();
                    }
                });
                file3.delete();
            }
        } catch (Exception unused2) {
            SFMCSdkLogger.INSTANCE.w("~$SFMCSdkStorage", new Function0<String>() { // from class: com.salesforce.marketingcloud.sfmcsdk.util.FileUtilsKt.wipeModuleFiles.6
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Caught exception trying to delete SharedPreferences file";
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean wipeModuleFiles$lambda$0(String moduleApplicationId, File file, String str) {
        Intrinsics.checkNotNullParameter(moduleApplicationId, "$moduleApplicationId");
        Intrinsics.checkNotNull(str);
        return StringsKt__StringsJVMKt.startsWith$default(str, getFilenamePrefixForModule(moduleApplicationId), false, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean wipeModuleFiles$lambda$2(String moduleApplicationId, File file, String str) {
        Intrinsics.checkNotNullParameter(moduleApplicationId, "$moduleApplicationId");
        Intrinsics.checkNotNull(str);
        return StringsKt__StringsJVMKt.startsWith$default(str, getFilenamePrefixForModule(moduleApplicationId), false, 2, null);
    }

    public static final String readAll(@Nullable InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return null;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, RequestKt.getUTF_8()));
        try {
            StringBuilder sb = new StringBuilder();
            for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                sb.append(line);
                sb.append('\n');
            }
            String string = sb.toString();
            CloseableKt.closeFinally(bufferedReader, null);
            return string;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(bufferedReader, th);
                throw th2;
            }
        }
    }
}
