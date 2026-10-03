package it.aep_italia.vts.sdk.domain;

import it.aep_italia.vts.sdk.errors.VtsError;
import it.aep_italia.vts.sdk.utils.ValidationUtils;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes6.dex */
public class VtsGenericRequest {
    private String a;
    private String b;
    private byte[] c;

    public static final class Builder {
        private String a;
        private String b;
        private byte[] c;

        public VtsGenericRequest build() {
            return new VtsGenericRequest(this);
        }

        public Builder dataInBin(String str) {
            this.c = str == null ? null : str.getBytes(StandardCharsets.UTF_8);
            return this;
        }

        public Builder dataInBin(byte[] bArr) {
            this.c = bArr;
            return this;
        }

        public Builder dataInXml(String str) {
            this.b = str;
            return this;
        }

        public Builder dataInXml(byte[] bArr) {
            this.b = new String(bArr, StandardCharsets.UTF_8);
            return this;
        }

        public Builder functionName(String str) {
            this.a = str;
            return this;
        }
    }

    private VtsGenericRequest(Builder builder) {
        String str = builder.a;
        VtsError vtsError = VtsError.INVALID_PARAMETER;
        ValidationUtils.assertNonBlank(str, vtsError, "Function name cannot be empty", new Object[0]);
        ValidationUtils.assertNonBlank(builder.b, vtsError, "XML input name cannot be empty", new Object[0]);
        this.a = builder.a;
        this.b = builder.b;
        this.c = builder.c;
    }

    public byte[] getDataInBin() {
        return this.c;
    }

    public String getDataInXml() {
        return this.b;
    }

    public String getFunctionName() {
        return this.a;
    }
}
