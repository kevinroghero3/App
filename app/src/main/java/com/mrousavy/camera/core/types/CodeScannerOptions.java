package com.mrousavy.camera.core.types;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.mrousavy.camera.core.InvalidTypeScriptUnionError;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class CodeScannerOptions {
    public static final Companion Companion = new Companion(null);
    private final List<CodeType> codeTypes;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CodeScannerOptions copy$default(CodeScannerOptions codeScannerOptions, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = codeScannerOptions.codeTypes;
        }
        return codeScannerOptions.copy(list);
    }

    public final List<CodeType> component1() {
        return this.codeTypes;
    }

    public final CodeScannerOptions copy(@NotNull List<? extends CodeType> codeTypes) {
        Intrinsics.checkNotNullParameter(codeTypes, "codeTypes");
        return new CodeScannerOptions(codeTypes);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof CodeScannerOptions) && Intrinsics.areEqual(this.codeTypes, ((CodeScannerOptions) obj).codeTypes);
    }

    public int hashCode() {
        return this.codeTypes.hashCode();
    }

    public String toString() {
        return "CodeScannerOptions(codeTypes=" + this.codeTypes + ")";
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CodeScannerOptions fromJSValue(@NotNull ReadableMap value) throws InvalidTypeScriptUnionError {
            Intrinsics.checkNotNullParameter(value, "value");
            ReadableArray array = value.getArray("codeTypes");
            if (array == null) {
                throw new InvalidTypeScriptUnionError("codeScanner", value.toString());
            }
            ArrayList<Object> arrayList = array.toArrayList();
            ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
            for (Object obj : arrayList) {
                CodeType.Companion companion = CodeType.Companion;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                arrayList2.add(companion.fromUnionValue((String) obj));
            }
            return new CodeScannerOptions(arrayList2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CodeScannerOptions(@NotNull List<? extends CodeType> codeTypes) {
        Intrinsics.checkNotNullParameter(codeTypes, "codeTypes");
        this.codeTypes = codeTypes;
    }

    public final List<CodeType> getCodeTypes() {
        return this.codeTypes;
    }
}
