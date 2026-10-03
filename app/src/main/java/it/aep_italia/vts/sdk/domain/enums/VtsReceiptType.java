package it.aep_italia.vts.sdk.domain.enums;

/* JADX INFO: loaded from: classes6.dex */
public enum VtsReceiptType {
    NONE("NONE"),
    TEXT("TEXT"),
    XML("XML"),
    PDF("PDF");

    private String value;

    VtsReceiptType(String str) {
        this.value = str;
    }

    public static VtsReceiptType parse(String str) {
        for (VtsReceiptType vtsReceiptType : values()) {
            if (vtsReceiptType.value.equals(str)) {
                return vtsReceiptType;
            }
        }
        return null;
    }

    public String value() {
        return this.value;
    }
}
