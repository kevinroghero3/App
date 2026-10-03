package androidx.compose.animation;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.LookaheadScope;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Deprecated;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public interface SharedTransitionScope extends LookaheadScope {

    public interface OverlayClip {
        Path getClipPath(@NotNull SharedContentState sharedContentState, @NotNull Rect rect, @NotNull LayoutDirection layoutDirection, @NotNull Density density);
    }

    OverlayClip OverlayClip(@NotNull Shape shape);

    boolean isTransitionActive();

    SharedContentState rememberSharedContentState(@NotNull Object obj, @Nullable Composer composer, int i);

    Modifier renderInSharedTransitionScopeOverlay(@NotNull Modifier modifier, @NotNull Function0<Boolean> function0, float f, @NotNull Function2<? super LayoutDirection, ? super Density, ? extends Path> function2);

    Modifier sharedBounds(@NotNull Modifier modifier, @NotNull SharedContentState sharedContentState, @NotNull AnimatedVisibilityScope animatedVisibilityScope, @NotNull EnterTransition enterTransition, @NotNull ExitTransition exitTransition, @NotNull BoundsTransform boundsTransform, @NotNull ResizeMode resizeMode, @NotNull PlaceHolderSize placeHolderSize, boolean z, float f, @NotNull OverlayClip overlayClip);

    Modifier sharedElement(@NotNull Modifier modifier, @NotNull SharedContentState sharedContentState, @NotNull AnimatedVisibilityScope animatedVisibilityScope, @NotNull BoundsTransform boundsTransform, @NotNull PlaceHolderSize placeHolderSize, boolean z, float f, @NotNull OverlayClip overlayClip);

    Modifier sharedElementWithCallerManagedVisibility(@NotNull Modifier modifier, @NotNull SharedContentState sharedContentState, boolean z, @NotNull BoundsTransform boundsTransform, @NotNull PlaceHolderSize placeHolderSize, boolean z2, float f, @NotNull OverlayClip overlayClip);

    Modifier skipToLookaheadSize(@NotNull Modifier modifier);

    public interface PlaceHolderSize {
        public static final Companion Companion = Companion.$$INSTANCE;

        /* JADX INFO: renamed from: calculateSize-JyjRU_E, reason: not valid java name */
        long mo270calculateSizeJyjRU_E(long j, long j2);

        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            private static final PlaceHolderSize animatedSize = new PlaceHolderSize() { // from class: androidx.compose.animation.SharedTransitionScope$PlaceHolderSize$Companion$animatedSize$1
                @Override // androidx.compose.animation.SharedTransitionScope.PlaceHolderSize
                /* JADX INFO: renamed from: calculateSize-JyjRU_E */
                public final long mo270calculateSizeJyjRU_E(long j, long j2) {
                    return j2;
                }
            };
            private static final PlaceHolderSize contentSize = new PlaceHolderSize() { // from class: androidx.compose.animation.SharedTransitionScope$PlaceHolderSize$Companion$contentSize$1
                @Override // androidx.compose.animation.SharedTransitionScope.PlaceHolderSize
                /* JADX INFO: renamed from: calculateSize-JyjRU_E */
                public final long mo270calculateSizeJyjRU_E(long j, long j2) {
                    return j;
                }
            };

            private Companion() {
            }

            public final PlaceHolderSize getAnimatedSize() {
                return animatedSize;
            }

            public final PlaceHolderSize getContentSize() {
                return contentSize;
            }
        }
    }

    public interface ResizeMode {
        public static final Companion Companion = Companion.$$INSTANCE;

        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            private static final ResizeMode RemeasureToBounds = RemeasureImpl.INSTANCE;

            private Companion() {
            }

            public final ResizeMode getRemeasureToBounds() {
                return RemeasureToBounds;
            }

            public static /* synthetic */ ResizeMode ScaleToBounds$default(Companion companion, ContentScale contentScale, Alignment alignment, int i, Object obj) {
                if ((i & 1) != 0) {
                    contentScale = ContentScale.Companion.getFillWidth();
                }
                if ((i & 2) != 0) {
                    alignment = Alignment.Companion.getCenter();
                }
                return companion.ScaleToBounds(contentScale, alignment);
            }

            public final ResizeMode ScaleToBounds(@NotNull ContentScale contentScale, @NotNull Alignment alignment) {
                return SharedTransitionScopeKt.ScaleToBoundsCached(contentScale, alignment);
            }
        }
    }

    static /* synthetic */ EnterTransition scaleInSharedContentToBounds$default(SharedTransitionScope sharedTransitionScope, ContentScale contentScale, Alignment alignment, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: scaleInSharedContentToBounds");
        }
        if ((i & 1) != 0) {
            contentScale = ContentScale.Companion.getFit();
        }
        if ((i & 2) != 0) {
            alignment = Alignment.Companion.getCenter();
        }
        return sharedTransitionScope.scaleInSharedContentToBounds(contentScale, alignment);
    }

    @Deprecated(message = "This EnterTransition has been deprecated. Please replace the usage with resizeMode = ScaleToBounds(...) in sharedBounds to achieve the scale-to-bounds effect.")
    default EnterTransition scaleInSharedContentToBounds(@NotNull ContentScale contentScale, @NotNull Alignment alignment) {
        return EnterExitTransitionKt.withEffect(EnterTransition.Companion.getNone(), new ContentScaleTransitionEffect(contentScale, alignment));
    }

    static /* synthetic */ ExitTransition scaleOutSharedContentToBounds$default(SharedTransitionScope sharedTransitionScope, ContentScale contentScale, Alignment alignment, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: scaleOutSharedContentToBounds");
        }
        if ((i & 1) != 0) {
            contentScale = ContentScale.Companion.getFit();
        }
        if ((i & 2) != 0) {
            alignment = Alignment.Companion.getCenter();
        }
        return sharedTransitionScope.scaleOutSharedContentToBounds(contentScale, alignment);
    }

    @Deprecated(message = "This ExitTransition has been deprecated.  Please replace the usage with resizeMode = ScaleToBounds(...) in sharedBounds to achieve the scale-to-bounds effect.")
    default ExitTransition scaleOutSharedContentToBounds(@NotNull ContentScale contentScale, @NotNull Alignment alignment) {
        return EnterExitTransitionKt.withEffect(ExitTransition.Companion.getNone(), new ContentScaleTransitionEffect(contentScale, alignment));
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ Modifier renderInSharedTransitionScopeOverlay$default(SharedTransitionScope sharedTransitionScope, Modifier modifier, Function0 function0, float f, Function2 function2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: renderInSharedTransitionScopeOverlay");
        }
        if ((i & 1) != 0) {
            function0 = new Function0<Boolean>() { // from class: androidx.compose.animation.SharedTransitionScope.renderInSharedTransitionScopeOverlay.1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Boolean invoke() {
                    return Boolean.valueOf(SharedTransitionScope.this.isTransitionActive());
                }
            };
        }
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        if ((i & 4) != 0) {
            function2 = SharedTransitionScopeKt.DefaultClipInOverlayDuringTransition;
        }
        return sharedTransitionScope.renderInSharedTransitionScopeOverlay(modifier, function0, f, function2);
    }

    static /* synthetic */ Modifier sharedElement$default(SharedTransitionScope sharedTransitionScope, Modifier modifier, SharedContentState sharedContentState, AnimatedVisibilityScope animatedVisibilityScope, BoundsTransform boundsTransform, PlaceHolderSize placeHolderSize, boolean z, float f, OverlayClip overlayClip, int i, Object obj) {
        if (obj == null) {
            return sharedTransitionScope.sharedElement(modifier, sharedContentState, animatedVisibilityScope, (i & 4) != 0 ? SharedTransitionScopeKt.DefaultBoundsTransform : boundsTransform, (i & 8) != 0 ? PlaceHolderSize.Companion.getContentSize() : placeHolderSize, (i & 16) != 0 ? true : z, (i & 32) != 0 ? 0.0f : f, (i & 64) != 0 ? SharedTransitionScopeKt.ParentClip : overlayClip);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sharedElement");
    }

    static /* synthetic */ Modifier sharedBounds$default(SharedTransitionScope sharedTransitionScope, Modifier modifier, SharedContentState sharedContentState, AnimatedVisibilityScope animatedVisibilityScope, EnterTransition enterTransition, ExitTransition exitTransition, BoundsTransform boundsTransform, ResizeMode resizeMode, PlaceHolderSize placeHolderSize, boolean z, float f, OverlayClip overlayClip, int i, Object obj) {
        if (obj == null) {
            return sharedTransitionScope.sharedBounds(modifier, sharedContentState, animatedVisibilityScope, (i & 4) != 0 ? EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null) : enterTransition, (i & 8) != 0 ? EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null) : exitTransition, (i & 16) != 0 ? SharedTransitionScopeKt.DefaultBoundsTransform : boundsTransform, (i & 32) != 0 ? ResizeMode.Companion.ScaleToBounds(ContentScale.Companion.getFillWidth(), Alignment.Companion.getCenter()) : resizeMode, (i & 64) != 0 ? PlaceHolderSize.Companion.getContentSize() : placeHolderSize, (i & 128) != 0 ? true : z, (i & 256) != 0 ? 0.0f : f, (i & 512) != 0 ? SharedTransitionScopeKt.ParentClip : overlayClip);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sharedBounds");
    }

    static /* synthetic */ Modifier sharedElementWithCallerManagedVisibility$default(SharedTransitionScope sharedTransitionScope, Modifier modifier, SharedContentState sharedContentState, boolean z, BoundsTransform boundsTransform, PlaceHolderSize placeHolderSize, boolean z2, float f, OverlayClip overlayClip, int i, Object obj) {
        if (obj == null) {
            return sharedTransitionScope.sharedElementWithCallerManagedVisibility(modifier, sharedContentState, z, (i & 4) != 0 ? SharedTransitionScopeKt.DefaultBoundsTransform : boundsTransform, (i & 8) != 0 ? PlaceHolderSize.Companion.getContentSize() : placeHolderSize, (i & 16) != 0 ? true : z2, (i & 32) != 0 ? 0.0f : f, (i & 64) != 0 ? SharedTransitionScopeKt.ParentClip : overlayClip);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sharedElementWithCallerManagedVisibility");
    }

    public static final class SharedContentState {
        public static final int $stable = 8;
        private final MutableState internalState$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        private final Object key;

        public SharedContentState(@NotNull Object obj) {
            this.key = obj;
        }

        public final Object getKey() {
            return this.key;
        }

        public final boolean isMatchFound() {
            SharedElement sharedElement;
            SharedElementInternalState internalState$animation_release = getInternalState$animation_release();
            if (internalState$animation_release == null || (sharedElement = internalState$animation_release.getSharedElement()) == null) {
                return false;
            }
            return sharedElement.getFoundMatch();
        }

        public final Path getClipPathInOverlay() {
            return getNonNullInternalState().getClipPathInOverlay$animation_release();
        }

        public final SharedContentState getParentSharedContentState() {
            SharedElementInternalState parentState = getNonNullInternalState().getParentState();
            if (parentState != null) {
                return parentState.getUserState();
            }
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final SharedElementInternalState getInternalState$animation_release() {
            return (SharedElementInternalState) this.internalState$delegate.getValue();
        }

        public final void setInternalState$animation_release(@Nullable SharedElementInternalState sharedElementInternalState) {
            this.internalState$delegate.setValue(sharedElementInternalState);
        }

        private final SharedElementInternalState getNonNullInternalState() {
            SharedElementInternalState internalState$animation_release = getInternalState$animation_release();
            if (internalState$animation_release != null) {
                return internalState$animation_release;
            }
            throw new IllegalArgumentException("Error: SharedContentState has not been added to a sharedElement/sharedBoundsmodifier yet. Therefore the internal state has not bee initialized.");
        }
    }
}
