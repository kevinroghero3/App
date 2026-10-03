package androidx.navigation.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.window.DialogProperties;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavDestinationBuilder;
import androidx.navigation.NavDestinationDsl;
import androidx.navigation.NavType;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
@NavDestinationDsl
public final class DialogNavigatorDestinationBuilder extends NavDestinationBuilder<DialogNavigator.Destination> {
    public static final int $stable = 8;
    private final Function3<NavBackStackEntry, Composer, Integer, Unit> content;
    private final DialogNavigator dialogNavigator;
    private final DialogProperties dialogProperties;

    /* JADX WARN: Multi-variable type inference failed */
    public DialogNavigatorDestinationBuilder(@NotNull DialogNavigator dialogNavigator, @NotNull String str, @NotNull DialogProperties dialogProperties, @NotNull Function3<? super NavBackStackEntry, ? super Composer, ? super Integer, Unit> function3) {
        super(dialogNavigator, str);
        this.dialogNavigator = dialogNavigator;
        this.dialogProperties = dialogProperties;
        this.content = function3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DialogNavigatorDestinationBuilder(@NotNull DialogNavigator dialogNavigator, @NotNull KClass<?> kClass, @NotNull Map<KType, NavType<?>> map, @NotNull DialogProperties dialogProperties, @NotNull Function3<? super NavBackStackEntry, ? super Composer, ? super Integer, Unit> function3) {
        super(dialogNavigator, kClass, map);
        this.dialogNavigator = dialogNavigator;
        this.dialogProperties = dialogProperties;
        this.content = function3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.navigation.NavDestinationBuilder
    public DialogNavigator.Destination instantiateDestination() {
        return new DialogNavigator.Destination(this.dialogNavigator, this.dialogProperties, this.content);
    }
}
