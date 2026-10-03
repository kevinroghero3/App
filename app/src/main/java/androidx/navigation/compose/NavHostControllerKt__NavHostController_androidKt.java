package androidx.navigation.compose;

import android.content.Context;
import android.os.Bundle;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.navigation.NavDestination;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigator;
import java.util.Arrays;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
final /* synthetic */ class NavHostControllerKt__NavHostController_androidKt {
    public static final NavHostController rememberNavController(@NotNull Navigator<? extends NavDestination>[] navigatorArr, @Nullable Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-342848815, i, -1, "androidx.navigation.compose.rememberNavController (NavHostController.android.kt:33)");
        }
        final Context context = (Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        Object[] objArrCopyOf = Arrays.copyOf(navigatorArr, navigatorArr.length);
        Saver<NavHostController, ?> saverNavControllerSaver$NavHostControllerKt__NavHostController_androidKt = NavControllerSaver$NavHostControllerKt__NavHostController_androidKt(context);
        boolean zChangedInstance = composer.changedInstance(context);
        Object objRememberedValue = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new Function0() { // from class: androidx.navigation.compose.NavHostControllerKt__NavHostController_androidKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return NavHostControllerKt__NavHostController_androidKt.createNavController$NavHostControllerKt__NavHostController_androidKt(context);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        NavHostController navHostController = (NavHostController) RememberSaveableKt.m755rememberSaveable(objArrCopyOf, (Saver) saverNavControllerSaver$NavHostControllerKt__NavHostController_androidKt, (String) null, (Function0) objRememberedValue, composer, 0, 4);
        for (Navigator<? extends NavDestination> navigator : navigatorArr) {
            navHostController.getNavigatorProvider().addNavigator(navigator);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return navHostController;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NavHostController createNavController$NavHostControllerKt__NavHostController_androidKt(Context context) {
        NavHostController navHostController = new NavHostController(context);
        navHostController.getNavigatorProvider().addNavigator(new ComposeNavGraphNavigator(navHostController.getNavigatorProvider()));
        navHostController.getNavigatorProvider().addNavigator(new ComposeNavigator());
        navHostController.getNavigatorProvider().addNavigator(new DialogNavigator());
        return navHostController;
    }

    private static final Saver<NavHostController, ?> NavControllerSaver$NavHostControllerKt__NavHostController_androidKt(final Context context) {
        return SaverKt.Saver(new Function2() { // from class: androidx.navigation.compose.NavHostControllerKt__NavHostController_androidKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return NavHostControllerKt__NavHostController_androidKt.NavControllerSaver$lambda$4$NavHostControllerKt__NavHostController_androidKt((SaverScope) obj, (NavHostController) obj2);
            }
        }, new Function1() { // from class: androidx.navigation.compose.NavHostControllerKt__NavHostController_androidKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NavHostControllerKt__NavHostController_androidKt.NavControllerSaver$lambda$6$NavHostControllerKt__NavHostController_androidKt(context, (Bundle) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bundle NavControllerSaver$lambda$4$NavHostControllerKt__NavHostController_androidKt(SaverScope saverScope, NavHostController navHostController) {
        return navHostController.saveState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NavHostController NavControllerSaver$lambda$6$NavHostControllerKt__NavHostController_androidKt(Context context, Bundle bundle) {
        NavHostController navHostControllerCreateNavController$NavHostControllerKt__NavHostController_androidKt = createNavController$NavHostControllerKt__NavHostController_androidKt(context);
        navHostControllerCreateNavController$NavHostControllerKt__NavHostController_androidKt.restoreState(bundle);
        return navHostControllerCreateNavController$NavHostControllerKt__NavHostController_androidKt;
    }
}
