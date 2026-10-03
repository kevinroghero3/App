package com.swmansion.rnscreens.gamma.tabs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class TabScreenFragment extends Fragment {
    private final TabScreen tabScreen;

    public final TabScreen getTabScreen$react_native_screens_release() {
        return this.tabScreen;
    }

    public TabScreenFragment(@NotNull TabScreen tabScreen) {
        Intrinsics.checkNotNullParameter(tabScreen, "tabScreen");
        this.tabScreen = tabScreen;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return this.tabScreen;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        this.tabScreen.getEventEmitter$react_native_screens_release().emitOnWillAppear();
        super.onStart();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        this.tabScreen.getEventEmitter$react_native_screens_release().emitOnDidAppear();
        super.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        this.tabScreen.getEventEmitter$react_native_screens_release().emitOnWillDisappear();
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        this.tabScreen.getEventEmitter$react_native_screens_release().emitOnDidDisappear();
        super.onStop();
    }
}
