package com.google.mlkit.common.sdkinternal.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.mlkit.common.model.RemoteModel;
import java.io.File;

/* JADX INFO: loaded from: classes5.dex */
public interface ModelValidator {

    public static class ValidationResult {
        public static final ValidationResult VALID = new ValidationResult(ErrorCode.OK, null);
        private final ErrorCode zza;
        private final String zzb;

        public enum ErrorCode {
            OK,
            TFLITE_VERSION_INCOMPATIBLE,
            MODEL_FORMAT_INVALID
        }

        public ValidationResult(@NonNull ErrorCode errorCode, @Nullable String str) {
            this.zza = errorCode;
            this.zzb = str;
        }

        public ErrorCode getErrorCode() {
            return this.zza;
        }

        public String getErrorMessage() {
            return this.zzb;
        }

        public boolean isValid() {
            return this.zza == ErrorCode.OK;
        }
    }

    ValidationResult validateModel(@NonNull File file, @NonNull RemoteModel remoteModel);
}
