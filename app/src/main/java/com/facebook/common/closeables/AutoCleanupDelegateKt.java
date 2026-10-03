package com.facebook.common.closeables;

import java.io.Closeable;
import java.io.IOException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class AutoCleanupDelegateKt {
    private static final Function1<Closeable, Unit> closeableCleanupFunction = new Function1() { // from class: com.facebook.common.closeables.AutoCleanupDelegateKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return AutoCleanupDelegateKt.closeableCleanupFunction$lambda$0((Closeable) obj);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit closeableCleanupFunction$lambda$0(Closeable it2) throws IOException {
        Intrinsics.checkNotNullParameter(it2, "it");
        it2.close();
        return Unit.INSTANCE;
    }
}
