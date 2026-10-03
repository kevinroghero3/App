package it.aep_italia.vts.sdk.internal.wallet.enums;

/* JADX INFO: loaded from: classes6.dex */
public enum VtsWalletFileType {
    EMPTY(0),
    VTOKEN(1),
    GENERIC_FILE(2);

    private int value;

    VtsWalletFileType(int i) {
        this.value = i;
    }

    public static VtsWalletFileType parse(int i) throws IllegalArgumentException {
        for (VtsWalletFileType vtsWalletFileType : values()) {
            if (vtsWalletFileType.value() == i) {
                return vtsWalletFileType;
            }
        }
        throw new IllegalArgumentException("Unrecognized FileType value " + i);
    }

    public int value() {
        return this.value;
    }
}
