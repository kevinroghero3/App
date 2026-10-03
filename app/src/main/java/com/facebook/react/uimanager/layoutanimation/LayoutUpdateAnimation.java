package com.facebook.react.uimanager.layoutanimation;

import android.view.View;
import android.view.animation.Animation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public final class LayoutUpdateAnimation extends AbstractLayoutAnimation {
    private static final Companion Companion = new Companion(null);
    private static final boolean USE_TRANSLATE_ANIMATION = false;

    @Override // com.facebook.react.uimanager.layoutanimation.AbstractLayoutAnimation
    /* JADX INFO: renamed from: isValid$ReactAndroid_release, reason: merged with bridge method [inline-methods] */
    public boolean isValid() {
        return this.mDurationMs > 0;
    }

    @Override // com.facebook.react.uimanager.layoutanimation.AbstractLayoutAnimation
    /* JADX INFO: renamed from: createAnimationImpl$ReactAndroid_release, reason: merged with bridge method [inline-methods] */
    public Animation createAnimationImpl(@NotNull View view, int i, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(view, "view");
        boolean z = (((int) view.getX()) == i && ((int) view.getY()) == i2) ? false : true;
        boolean z2 = (view.getWidth() == i3 && view.getHeight() == i4) ? false : true;
        if (z || z2) {
            return new PositionAndSizeAnimation(view, i, i2, i3, i4);
        }
        return null;
    }

    static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
