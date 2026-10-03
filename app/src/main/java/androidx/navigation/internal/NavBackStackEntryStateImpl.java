package androidx.navigation.internal;

import android.os.Bundle;
import androidx.core.os.BundleKt;
import androidx.lifecycle.Lifecycle;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavControllerViewModel;
import androidx.navigation.NavDestination;
import androidx.savedstate.SavedStateReader;
import androidx.savedstate.SavedStateWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class NavBackStackEntryStateImpl {
    public static final Companion Companion = new Companion(null);
    public static final String KEY_ARGS = "nav-entry-state:args";
    public static final String KEY_DESTINATION_ID = "nav-entry-state:destination-id";
    public static final String KEY_ID = "nav-entry-state:id";
    public static final String KEY_SAVED_STATE = "nav-entry-state:saved-state";
    private final Bundle args;
    private final int destinationId;
    private final String id;
    private final Bundle savedState;

    public final String getId$navigation_runtime_release() {
        return this.id;
    }

    public final int getDestinationId$navigation_runtime_release() {
        return this.destinationId;
    }

    public final Bundle getArgs$navigation_runtime_release() {
        return this.args;
    }

    public final Bundle getSavedState$navigation_runtime_release() {
        return this.savedState;
    }

    public NavBackStackEntryStateImpl(@NotNull NavBackStackEntry entry, int i) {
        Pair[] pairArr;
        Intrinsics.checkNotNullParameter(entry, "entry");
        this.id = entry.getId();
        this.destinationId = i;
        this.args = entry.getArguments();
        Map mapEmptyMap = MapsKt__MapsKt.emptyMap();
        if (mapEmptyMap.isEmpty()) {
            pairArr = new Pair[0];
        } else {
            ArrayList arrayList = new ArrayList(mapEmptyMap.size());
            for (Map.Entry entry2 : mapEmptyMap.entrySet()) {
                arrayList.add(TuplesKt.to((String) entry2.getKey(), entry2.getValue()));
            }
            pairArr = (Pair[]) arrayList.toArray(new Pair[0]);
        }
        Bundle bundleBundleOf = BundleKt.bundleOf((Pair[]) Arrays.copyOf(pairArr, pairArr.length));
        SavedStateWriter.m4111constructorimpl(bundleBundleOf);
        this.savedState = bundleBundleOf;
        entry.saveState(bundleBundleOf);
    }

    public NavBackStackEntryStateImpl(@NotNull Bundle state) {
        Intrinsics.checkNotNullParameter(state, "state");
        this.id = SavedStateReader.m4096getStringimpl(SavedStateReader.m4025constructorimpl(state), KEY_ID);
        this.destinationId = SavedStateReader.m4056getIntimpl(SavedStateReader.m4025constructorimpl(state), KEY_DESTINATION_ID);
        this.args = SavedStateReader.m4082getSavedStateimpl(SavedStateReader.m4025constructorimpl(state), KEY_ARGS);
        this.savedState = SavedStateReader.m4082getSavedStateimpl(SavedStateReader.m4025constructorimpl(state), KEY_SAVED_STATE);
    }

    public final NavBackStackEntry instantiate(@NotNull NavContext context, @NotNull NavDestination destination, @Nullable Bundle bundle, @NotNull Lifecycle.State hostLifecycleState, @Nullable NavControllerViewModel navControllerViewModel) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(hostLifecycleState, "hostLifecycleState");
        return NavBackStackEntry.Companion.create(context, destination, bundle, hostLifecycleState, navControllerViewModel, this.id, this.savedState);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final Bundle writeToState$navigation_runtime_release() {
        Pair[] pairArr;
        Pair[] pairArr2;
        Map mapEmptyMap = MapsKt__MapsKt.emptyMap();
        if (mapEmptyMap.isEmpty()) {
            pairArr = new Pair[0];
        } else {
            ArrayList arrayList = new ArrayList(mapEmptyMap.size());
            for (Map.Entry entry : mapEmptyMap.entrySet()) {
                arrayList.add(TuplesKt.to((String) entry.getKey(), entry.getValue()));
            }
            pairArr = (Pair[]) arrayList.toArray(new Pair[0]);
        }
        Bundle bundleBundleOf = BundleKt.bundleOf((Pair[]) Arrays.copyOf(pairArr, pairArr.length));
        Bundle bundleM4111constructorimpl = SavedStateWriter.m4111constructorimpl(bundleBundleOf);
        SavedStateWriter.m4144putStringimpl(bundleM4111constructorimpl, KEY_ID, this.id);
        SavedStateWriter.m4128putIntimpl(bundleM4111constructorimpl, KEY_DESTINATION_ID, this.destinationId);
        Bundle bundleBundleOf2 = this.args;
        if (bundleBundleOf2 == null) {
            Map mapEmptyMap2 = MapsKt__MapsKt.emptyMap();
            if (mapEmptyMap2.isEmpty()) {
                pairArr2 = new Pair[0];
            } else {
                ArrayList arrayList2 = new ArrayList(mapEmptyMap2.size());
                for (Map.Entry entry2 : mapEmptyMap2.entrySet()) {
                    arrayList2.add(TuplesKt.to((String) entry2.getKey(), entry2.getValue()));
                }
                pairArr2 = (Pair[]) arrayList2.toArray(new Pair[0]);
            }
            bundleBundleOf2 = BundleKt.bundleOf((Pair[]) Arrays.copyOf(pairArr2, pairArr2.length));
            SavedStateWriter.m4111constructorimpl(bundleBundleOf2);
        }
        SavedStateWriter.m4138putSavedStateimpl(bundleM4111constructorimpl, KEY_ARGS, bundleBundleOf2);
        SavedStateWriter.m4138putSavedStateimpl(bundleM4111constructorimpl, KEY_SAVED_STATE, this.savedState);
        return bundleBundleOf;
    }
}
