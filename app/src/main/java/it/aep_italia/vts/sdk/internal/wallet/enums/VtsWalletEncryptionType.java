package it.aep_italia.vts.sdk.internal.wallet.enums;

/* JADX INFO: loaded from: classes6.dex */
public enum VtsWalletEncryptionType {
    NONE(0),
    AES_256(1);

    private int value;

    VtsWalletEncryptionType(int i) {
        this.value = i;
    }

    public static VtsWalletEncryptionType parse(int i) throws IllegalArgumentException {
        for (VtsWalletEncryptionType vtsWalletEncryptionType : values()) {
            if (vtsWalletEncryptionType.value() == i) {
                return vtsWalletEncryptionType;
            }
        }
        throw new IllegalArgumentException("Unrecognized EncryptionType value " + i);
    }

    public int value() {
        return this.value;
    }
}
