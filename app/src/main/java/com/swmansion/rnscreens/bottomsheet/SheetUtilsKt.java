package com.swmansion.rnscreens.bottomsheet;

import android.view.View;
import com.swmansion.rnscreens.Screen;
import com.swmansion.rnscreens.ScreenContentWrapper;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public final class SheetUtilsKt {
    public static final boolean isSheetFitToContents(@NotNull Screen screen) {
        Intrinsics.checkNotNullParameter(screen, "<this>");
        return screen.getStackPresentation() == Screen.StackPresentation.FORM_SHEET && screen.getSheetDetents().size() == 1 && ((Number) CollectionsKt___CollectionsKt.first((List) screen.getSheetDetents())).doubleValue() == -1.0d;
    }

    public static final boolean usesFormSheetPresentation(@NotNull Screen screen) {
        Intrinsics.checkNotNullParameter(screen, "<this>");
        return screen.getStackPresentation() == Screen.StackPresentation.FORM_SHEET;
    }

    public static final boolean requiresEnterTransitionPostponing(@NotNull Screen screen) {
        ScreenContentWrapper contentWrapper;
        Intrinsics.checkNotNullParameter(screen, "<this>");
        if (usesFormSheetPresentation(screen)) {
            return (isLaidOutOrHasCachedLayout(screen) && (contentWrapper = screen.getContentWrapper()) != null && isLaidOutOrHasCachedLayout(contentWrapper)) ? false : true;
        }
        return false;
    }

    public static final boolean isLaidOutOrHasCachedLayout(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return view.isLaidOut() || view.getHeight() > 0 || view.getWidth() > 0;
    }
}
