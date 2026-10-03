package com.swmansion.rnscreens.gamma.helpers;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.facebook.react.ReactRootView;
import com.swmansion.rnscreens.gamma.common.FragmentProviding;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class FragmentManagerHelper {
    public static final FragmentManagerHelper INSTANCE = new FragmentManagerHelper();

    private FragmentManagerHelper() {
    }

    public final FragmentManager findFragmentManagerForView(@NotNull ViewGroup view) {
        boolean z;
        Intrinsics.checkNotNullParameter(view, "view");
        ViewParent parent = view;
        while (true) {
            z = parent instanceof ReactRootView;
            if (z || (parent instanceof FragmentProviding) || parent.getParent() == null) {
                break;
            }
            parent = parent.getParent();
        }
        if (!(parent instanceof FragmentProviding)) {
            if (!z) {
                throw new IllegalStateException(("[RNScreens] Expected parent to be a ReactRootView, instead found: " + parent.getClass().getName()).toString());
            }
            return resolveFragmentManagerForReactRootView((ReactRootView) parent);
        }
        Fragment fragment = ((FragmentProviding) parent).getFragment();
        if (fragment == null) {
            throw new IllegalStateException(("[RNScreens] Parent fragment providing view " + parent + " returned nullish fragment").toString());
        }
        return fragment.getChildFragmentManager();
    }

    private final FragmentManager resolveFragmentManagerForReactRootView(ReactRootView reactRootView) {
        boolean z;
        Context context = reactRootView.getContext();
        while (true) {
            z = context instanceof FragmentActivity;
            if (z || !(context instanceof ContextWrapper)) {
                break;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        if (!z) {
            throw new IllegalStateException("[RNScreens] In order to use react-native-screens components your app's activity need to extend ReactActivity");
        }
        FragmentActivity fragmentActivity = (FragmentActivity) context;
        if (fragmentActivity.getSupportFragmentManager().getFragments().isEmpty()) {
            return fragmentActivity.getSupportFragmentManager();
        }
        try {
            return FragmentManager.findFragment(reactRootView).getChildFragmentManager();
        } catch (IllegalStateException unused) {
            return fragmentActivity.getSupportFragmentManager();
        }
    }
}
