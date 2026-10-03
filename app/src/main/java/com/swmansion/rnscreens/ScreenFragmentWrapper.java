package com.swmansion.rnscreens;

import android.app.Activity;
import com.facebook.react.bridge.ReactContext;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public interface ScreenFragmentWrapper extends FragmentHolder, ScreenEventDispatcher {
    void addChildScreenContainer(@NotNull ScreenContainer screenContainer);

    List<ScreenContainer> getChildScreenContainers();

    Screen getScreen();

    boolean isTranslucent();

    void onContainerUpdate();

    void onViewAnimationEnd();

    void onViewAnimationStart();

    void removeChildScreenContainer(@NotNull ScreenContainer screenContainer);

    void setScreen(@NotNull Screen screen);

    Activity tryGetActivity();

    ReactContext tryGetContext();
}
