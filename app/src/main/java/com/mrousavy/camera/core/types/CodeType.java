package com.mrousavy.camera.core.types;

import com.mrousavy.camera.core.CodeTypeNotSupportedError;
import com.mrousavy.camera.core.InvalidTypeScriptUnionError;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public enum CodeType implements JSUnionValue {
    CODE_128("code-128"),
    CODE_39("code-39"),
    CODE_93("code-93"),
    CODABAR("codabar"),
    EAN_13("ean-13"),
    EAN_8("ean-8"),
    ITF("itf"),
    UPC_E("upc-e"),
    UPC_A("upc-a"),
    QR("qr"),
    PDF_417("pdf-417"),
    AZTEC("aztec"),
    DATA_MATRIX("data-matrix"),
    UNKNOWN("unknown");

    private final String unionValue;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    public static final Companion Companion = new Companion(null);

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CodeType.values().length];
            try {
                iArr[CodeType.CODE_128.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CodeType.CODE_39.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CodeType.CODE_93.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[CodeType.CODABAR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[CodeType.EAN_13.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[CodeType.EAN_8.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[CodeType.ITF.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[CodeType.UPC_E.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[CodeType.UPC_A.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[CodeType.QR.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[CodeType.PDF_417.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[CodeType.AZTEC.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[CodeType.DATA_MATRIX.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[CodeType.UNKNOWN.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static EnumEntries<CodeType> getEntries() {
        return $ENTRIES;
    }

    CodeType(String str) {
        this.unionValue = str;
    }

    @Override // com.mrousavy.camera.core.types.JSUnionValue
    public String getUnionValue() {
        return this.unionValue;
    }

    public final int toBarcodeType() throws CodeTypeNotSupportedError {
        switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 4;
            case 4:
                return 8;
            case 5:
                return 32;
            case 6:
                return 64;
            case 7:
                return 128;
            case 8:
                return 1024;
            case 9:
                return 512;
            case 10:
                return 256;
            case 11:
                return 2048;
            case 12:
                return 4096;
            case 13:
                return 16;
            case 14:
                throw new CodeTypeNotSupportedError(getUnionValue());
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final class Companion implements JSUnionValue.Companion<CodeType> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CodeType fromBarcodeType(int i) {
            if (i == 1) {
                return CodeType.CODE_128;
            }
            if (i == 2) {
                return CodeType.CODE_39;
            }
            switch (i) {
                case 4:
                    return CodeType.CODE_93;
                case 8:
                    return CodeType.CODABAR;
                case 16:
                    return CodeType.DATA_MATRIX;
                case 32:
                    return CodeType.EAN_13;
                case 64:
                    return CodeType.EAN_8;
                case 128:
                    return CodeType.ITF;
                case 256:
                    return CodeType.QR;
                case 512:
                    return CodeType.UPC_A;
                case 1024:
                    return CodeType.UPC_E;
                case 2048:
                    return CodeType.PDF_417;
                case 4096:
                    return CodeType.AZTEC;
                default:
                    return CodeType.UNKNOWN;
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        @Override // com.mrousavy.camera.core.types.JSUnionValue.Companion
        public CodeType fromUnionValue(@Nullable String str) throws InvalidTypeScriptUnionError {
            if (str != null) {
                switch (str.hashCode()) {
                    case -1310519683:
                        if (str.equals("ean-13")) {
                            return CodeType.EAN_13;
                        }
                        break;
                    case -869195177:
                        if (str.equals("code-128")) {
                            return CodeType.CODE_128;
                        }
                        break;
                    case -720296449:
                        if (str.equals("pdf-417")) {
                            return CodeType.PDF_417;
                        }
                        break;
                    case 3617:
                        if (str.equals("qr")) {
                            return CodeType.QR;
                        }
                        break;
                    case 104603:
                        if (str.equals("itf")) {
                            return CodeType.ITF;
                        }
                        break;
                    case 93330745:
                        if (str.equals("aztec")) {
                            return CodeType.AZTEC;
                        }
                        break;
                    case 96272509:
                        if (str.equals("ean-8")) {
                            return CodeType.EAN_8;
                        }
                        break;
                    case 111485180:
                        if (str.equals("upc-a")) {
                            return CodeType.UPC_A;
                        }
                        break;
                    case 111485184:
                        if (str.equals("upc-e")) {
                            return CodeType.UPC_E;
                        }
                        break;
                    case 941726090:
                        if (str.equals("codabar")) {
                            return CodeType.CODABAR;
                        }
                        break;
                    case 941792838:
                        if (str.equals("code-39")) {
                            return CodeType.CODE_39;
                        }
                        break;
                    case 941793018:
                        if (str.equals("code-93")) {
                            return CodeType.CODE_93;
                        }
                        break;
                    case 1350827844:
                        if (str.equals("data-matrix")) {
                            return CodeType.DATA_MATRIX;
                        }
                        break;
                }
            }
            if (str == null) {
                str = "(null)";
            }
            throw new InvalidTypeScriptUnionError("codeType", str);
        }
    }
}
