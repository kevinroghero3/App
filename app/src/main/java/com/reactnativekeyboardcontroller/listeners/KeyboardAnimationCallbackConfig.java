package com.reactnativekeyboardcontroller.listeners;

import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class KeyboardAnimationCallbackConfig {
    private final int deferredInsetTypes;
    private final int dispatchMode;
    private boolean hasTranslucentNavigationBar;
    private final int persistentInsetTypes;

    public static /* synthetic */ KeyboardAnimationCallbackConfig copy$default(KeyboardAnimationCallbackConfig keyboardAnimationCallbackConfig, int i, int i2, int i3, boolean z, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = keyboardAnimationCallbackConfig.persistentInsetTypes;
        }
        if ((i4 & 2) != 0) {
            i2 = keyboardAnimationCallbackConfig.deferredInsetTypes;
        }
        if ((i4 & 4) != 0) {
            i3 = keyboardAnimationCallbackConfig.dispatchMode;
        }
        if ((i4 & 8) != 0) {
            z = keyboardAnimationCallbackConfig.hasTranslucentNavigationBar;
        }
        return keyboardAnimationCallbackConfig.copy(i, i2, i3, z);
    }

    public final int component1() {
        return this.persistentInsetTypes;
    }

    public final int component2() {
        return this.deferredInsetTypes;
    }

    public final int component3() {
        return this.dispatchMode;
    }

    public final boolean component4() {
        return this.hasTranslucentNavigationBar;
    }

    public final KeyboardAnimationCallbackConfig copy(int i, int i2, int i3, boolean z) {
        return new KeyboardAnimationCallbackConfig(i, i2, i3, z);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KeyboardAnimationCallbackConfig)) {
            return false;
        }
        KeyboardAnimationCallbackConfig keyboardAnimationCallbackConfig = (KeyboardAnimationCallbackConfig) obj;
        return this.persistentInsetTypes == keyboardAnimationCallbackConfig.persistentInsetTypes && this.deferredInsetTypes == keyboardAnimationCallbackConfig.deferredInsetTypes && this.dispatchMode == keyboardAnimationCallbackConfig.dispatchMode && this.hasTranslucentNavigationBar == keyboardAnimationCallbackConfig.hasTranslucentNavigationBar;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.persistentInsetTypes) * 31) + Integer.hashCode(this.deferredInsetTypes)) * 31) + Integer.hashCode(this.dispatchMode)) * 31) + Boolean.hashCode(this.hasTranslucentNavigationBar);
    }

    public String toString() {
        return "KeyboardAnimationCallbackConfig(persistentInsetTypes=" + this.persistentInsetTypes + ", deferredInsetTypes=" + this.deferredInsetTypes + ", dispatchMode=" + this.dispatchMode + ", hasTranslucentNavigationBar=" + this.hasTranslucentNavigationBar + ")";
    }

    public KeyboardAnimationCallbackConfig(int i, int i2, int i3, boolean z) {
        this.persistentInsetTypes = i;
        this.deferredInsetTypes = i2;
        this.dispatchMode = i3;
        this.hasTranslucentNavigationBar = z;
    }

    public /* synthetic */ KeyboardAnimationCallbackConfig(int i, int i2, int i3, boolean z, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, (i4 & 4) != 0 ? 0 : i3, z);
    }

    public final int getPersistentInsetTypes() {
        return this.persistentInsetTypes;
    }

    public final int getDeferredInsetTypes() {
        return this.deferredInsetTypes;
    }

    public final int getDispatchMode() {
        return this.dispatchMode;
    }

    public final boolean getHasTranslucentNavigationBar() {
        return this.hasTranslucentNavigationBar;
    }

    public final void setHasTranslucentNavigationBar(boolean z) {
        this.hasTranslucentNavigationBar = z;
    }
}
