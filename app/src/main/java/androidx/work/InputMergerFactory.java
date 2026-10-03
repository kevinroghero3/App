package androidx.work;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes2.dex */
public abstract class InputMergerFactory {
    public abstract InputMerger createInputMerger(@NonNull String str);

    public final InputMerger createInputMergerWithDefaultFallback(@NonNull String str) {
        InputMerger inputMergerCreateInputMerger = createInputMerger(str);
        return inputMergerCreateInputMerger == null ? InputMerger.fromClassName(str) : inputMergerCreateInputMerger;
    }

    public static InputMergerFactory getDefaultInputMergerFactory() {
        return new InputMergerFactory() { // from class: androidx.work.InputMergerFactory.1
            @Override // androidx.work.InputMergerFactory
            public InputMerger createInputMerger(@NonNull String str) {
                return null;
            }
        };
    }
}
