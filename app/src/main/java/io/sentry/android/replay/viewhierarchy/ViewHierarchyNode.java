package io.sentry.android.replay.viewhierarchy;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.view.View;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TextView;
import ch.qos.logback.core.CoreConstants;
import io.sentry.SentryOptions;
import io.sentry.android.replay.R;
import io.sentry.android.replay.util.AndroidTextLayout;
import io.sentry.android.replay.util.TextLayout;
import io.sentry.android.replay.util.ViewsKt;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public abstract class ViewHierarchyNode {
    private static final String SENTRY_MASK_TAG = "sentry-mask";
    private static final String SENTRY_UNMASK_TAG = "sentry-unmask";
    private List<? extends ViewHierarchyNode> children;
    private final int distance;
    private final float elevation;
    private final int height;
    private boolean isImportantForContentCapture;
    private final boolean isVisible;
    private final ViewHierarchyNode parent;
    private final boolean shouldMask;
    private final Rect visibleRect;
    private final int width;
    private final float x;
    private final float y;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public /* synthetic */ ViewHierarchyNode(float f, float f2, int i, int i2, float f3, int i3, ViewHierarchyNode viewHierarchyNode, boolean z, boolean z2, boolean z3, Rect rect, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, i, i2, f3, i3, viewHierarchyNode, z, z2, z3, rect);
    }

    private ViewHierarchyNode(float f, float f2, int i, int i2, float f3, int i3, ViewHierarchyNode viewHierarchyNode, boolean z, boolean z2, boolean z3, Rect rect) {
        this.x = f;
        this.y = f2;
        this.width = i;
        this.height = i2;
        this.elevation = f3;
        this.distance = i3;
        this.parent = viewHierarchyNode;
        this.shouldMask = z;
        this.isImportantForContentCapture = z2;
        this.isVisible = z3;
        this.visibleRect = rect;
    }

    public /* synthetic */ ViewHierarchyNode(float f, float f2, int i, int i2, float f3, int i3, ViewHierarchyNode viewHierarchyNode, boolean z, boolean z2, boolean z3, Rect rect, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, i, i2, f3, i3, (i4 & 64) != 0 ? null : viewHierarchyNode, (i4 & 128) != 0 ? false : z, (i4 & 256) != 0 ? false : z2, (i4 & 512) != 0 ? false : z3, (i4 & 1024) != 0 ? null : rect, null);
    }

    public final float getX() {
        return this.x;
    }

    public final float getY() {
        return this.y;
    }

    public final int getWidth() {
        return this.width;
    }

    public final int getHeight() {
        return this.height;
    }

    public final float getElevation() {
        return this.elevation;
    }

    public final int getDistance() {
        return this.distance;
    }

    public final ViewHierarchyNode getParent() {
        return this.parent;
    }

    public final boolean getShouldMask() {
        return this.shouldMask;
    }

    public final boolean isImportantForContentCapture() {
        return this.isImportantForContentCapture;
    }

    public final void setImportantForContentCapture(boolean z) {
        this.isImportantForContentCapture = z;
    }

    public final boolean isVisible() {
        return this.isVisible;
    }

    public final Rect getVisibleRect() {
        return this.visibleRect;
    }

    public final List<ViewHierarchyNode> getChildren() {
        return this.children;
    }

    public final void setChildren(@Nullable List<? extends ViewHierarchyNode> list) {
        this.children = list;
    }

    public static final class GenericViewHierarchyNode extends ViewHierarchyNode {
        public static final int $stable = 0;

        public /* synthetic */ GenericViewHierarchyNode(float f, float f2, int i, int i2, float f3, int i3, ViewHierarchyNode viewHierarchyNode, boolean z, boolean z2, boolean z3, Rect rect, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this(f, f2, i, i2, f3, i3, (i4 & 64) != 0 ? null : viewHierarchyNode, (i4 & 128) != 0 ? false : z, (i4 & 256) != 0 ? false : z2, (i4 & 512) != 0 ? false : z3, (i4 & 1024) != 0 ? null : rect);
        }

        public GenericViewHierarchyNode(float f, float f2, int i, int i2, float f3, int i3, @Nullable ViewHierarchyNode viewHierarchyNode, boolean z, boolean z2, boolean z3, @Nullable Rect rect) {
            super(f, f2, i, i2, f3, i3, viewHierarchyNode, z, z2, z3, rect, null);
        }
    }

    public static final class TextViewHierarchyNode extends ViewHierarchyNode {
        public static final int $stable = 8;
        private final Integer dominantColor;
        private final TextLayout layout;
        private final int paddingLeft;
        private final int paddingTop;

        public /* synthetic */ TextViewHierarchyNode(TextLayout textLayout, Integer num, int i, int i2, float f, float f2, int i3, int i4, float f3, int i5, ViewHierarchyNode viewHierarchyNode, boolean z, boolean z2, boolean z3, Rect rect, int i6, DefaultConstructorMarker defaultConstructorMarker) {
            this((i6 & 1) != 0 ? null : textLayout, (i6 & 2) != 0 ? null : num, (i6 & 4) != 0 ? 0 : i, (i6 & 8) != 0 ? 0 : i2, f, f2, i3, i4, f3, i5, (i6 & 1024) != 0 ? null : viewHierarchyNode, (i6 & 2048) != 0 ? false : z, (i6 & 4096) != 0 ? false : z2, (i6 & 8192) != 0 ? false : z3, (i6 & 16384) != 0 ? null : rect);
        }

        public final TextLayout getLayout() {
            return this.layout;
        }

        public final Integer getDominantColor() {
            return this.dominantColor;
        }

        public final int getPaddingLeft() {
            return this.paddingLeft;
        }

        public final int getPaddingTop() {
            return this.paddingTop;
        }

        public TextViewHierarchyNode(@Nullable TextLayout textLayout, @Nullable Integer num, int i, int i2, float f, float f2, int i3, int i4, float f3, int i5, @Nullable ViewHierarchyNode viewHierarchyNode, boolean z, boolean z2, boolean z3, @Nullable Rect rect) {
            super(f, f2, i3, i4, f3, i5, viewHierarchyNode, z, z2, z3, rect, null);
            this.layout = textLayout;
            this.dominantColor = num;
            this.paddingLeft = i;
            this.paddingTop = i2;
        }
    }

    public static final class ImageViewHierarchyNode extends ViewHierarchyNode {
        public static final int $stable = 0;

        public /* synthetic */ ImageViewHierarchyNode(float f, float f2, int i, int i2, float f3, int i3, ViewHierarchyNode viewHierarchyNode, boolean z, boolean z2, boolean z3, Rect rect, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this(f, f2, i, i2, f3, i3, (i4 & 64) != 0 ? null : viewHierarchyNode, (i4 & 128) != 0 ? false : z, (i4 & 256) != 0 ? false : z2, (i4 & 512) != 0 ? false : z3, (i4 & 1024) != 0 ? null : rect);
        }

        public ImageViewHierarchyNode(float f, float f2, int i, int i2, float f3, int i3, @Nullable ViewHierarchyNode viewHierarchyNode, boolean z, boolean z2, boolean z3, @Nullable Rect rect) {
            super(f, f2, i, i2, f3, i3, viewHierarchyNode, z, z2, z3, rect, null);
        }
    }

    public final void setImportantForCaptureToAncestors(boolean z) {
        for (ViewHierarchyNode viewHierarchyNode = this.parent; viewHierarchyNode != null; viewHierarchyNode = viewHierarchyNode.parent) {
            viewHierarchyNode.isImportantForContentCapture = z;
        }
    }

    public final void traverse(@NotNull Function1<? super ViewHierarchyNode, Boolean> callback) {
        List<? extends ViewHierarchyNode> list;
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!callback.invoke(this).booleanValue() || (list = this.children) == null) {
            return;
        }
        Intrinsics.checkNotNull(list);
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            ((ViewHierarchyNode) it2.next()).traverse(callback);
        }
    }

    public final boolean isObscured(@NotNull final ViewHierarchyNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        if (this.parent != null) {
            throw new IllegalArgumentException("This method should be called on the root node of the view hierarchy.");
        }
        if (node.visibleRect == null) {
            return false;
        }
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        traverse(new Function1<ViewHierarchyNode, Boolean>() { // from class: io.sentry.android.replay.viewhierarchy.ViewHierarchyNode.isObscured.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(@NotNull ViewHierarchyNode otherNode) {
                Intrinsics.checkNotNullParameter(otherNode, "otherNode");
                if (otherNode.getVisibleRect() == null || booleanRef.element) {
                    return Boolean.FALSE;
                }
                if (!otherNode.isVisible() || !otherNode.isImportantForContentCapture() || !otherNode.getVisibleRect().contains(node.getVisibleRect())) {
                    return Boolean.FALSE;
                }
                if (otherNode.getElevation() > node.getElevation()) {
                    booleanRef.element = true;
                    return Boolean.FALSE;
                }
                if (otherNode.getElevation() == node.getElevation()) {
                    LCAResult lCAResultFindLCA = this.findLCA(node, otherNode);
                    ViewHierarchyNode viewHierarchyNodeComponent1 = lCAResultFindLCA.component1();
                    ViewHierarchyNode viewHierarchyNodeComponent2 = lCAResultFindLCA.component2();
                    ViewHierarchyNode viewHierarchyNodeComponent3 = lCAResultFindLCA.component3();
                    if (!Intrinsics.areEqual(viewHierarchyNodeComponent1, otherNode) && viewHierarchyNodeComponent3 != null && viewHierarchyNodeComponent2 != null) {
                        booleanRef.element = viewHierarchyNodeComponent3.getDistance() > viewHierarchyNodeComponent2.getDistance();
                        return Boolean.valueOf(!booleanRef.element);
                    }
                }
                return Boolean.TRUE;
            }
        });
        return booleanRef.element;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LCAResult findLCA(ViewHierarchyNode viewHierarchyNode, ViewHierarchyNode viewHierarchyNode2) {
        ViewHierarchyNode viewHierarchyNode3 = null;
        ViewHierarchyNode viewHierarchyNode4 = Intrinsics.areEqual(this, viewHierarchyNode) ? this : null;
        ViewHierarchyNode viewHierarchyNode5 = Intrinsics.areEqual(this, viewHierarchyNode2) ? this : null;
        List<? extends ViewHierarchyNode> list = this.children;
        if (list != null) {
            Intrinsics.checkNotNull(list);
            for (ViewHierarchyNode viewHierarchyNode6 : list) {
                LCAResult lCAResultFindLCA = viewHierarchyNode6.findLCA(viewHierarchyNode, viewHierarchyNode2);
                if (lCAResultFindLCA.getLca() != null) {
                    return lCAResultFindLCA;
                }
                if (lCAResultFindLCA.getNodeSubtree() != null) {
                    viewHierarchyNode4 = viewHierarchyNode6;
                }
                if (lCAResultFindLCA.getOtherNodeSubtree() != null) {
                    viewHierarchyNode5 = viewHierarchyNode6;
                }
            }
        }
        if (viewHierarchyNode4 != null && viewHierarchyNode5 != null) {
            viewHierarchyNode3 = this;
        }
        return new LCAResult(viewHierarchyNode3, viewHierarchyNode4, viewHierarchyNode5);
    }

    static final class LCAResult {
        private final ViewHierarchyNode lca;
        private ViewHierarchyNode nodeSubtree;
        private ViewHierarchyNode otherNodeSubtree;

        public static /* synthetic */ LCAResult copy$default(LCAResult lCAResult, ViewHierarchyNode viewHierarchyNode, ViewHierarchyNode viewHierarchyNode2, ViewHierarchyNode viewHierarchyNode3, int i, Object obj) {
            if ((i & 1) != 0) {
                viewHierarchyNode = lCAResult.lca;
            }
            if ((i & 2) != 0) {
                viewHierarchyNode2 = lCAResult.nodeSubtree;
            }
            if ((i & 4) != 0) {
                viewHierarchyNode3 = lCAResult.otherNodeSubtree;
            }
            return lCAResult.copy(viewHierarchyNode, viewHierarchyNode2, viewHierarchyNode3);
        }

        public final ViewHierarchyNode component1() {
            return this.lca;
        }

        public final ViewHierarchyNode component2() {
            return this.nodeSubtree;
        }

        public final ViewHierarchyNode component3() {
            return this.otherNodeSubtree;
        }

        public final LCAResult copy(@Nullable ViewHierarchyNode viewHierarchyNode, @Nullable ViewHierarchyNode viewHierarchyNode2, @Nullable ViewHierarchyNode viewHierarchyNode3) {
            return new LCAResult(viewHierarchyNode, viewHierarchyNode2, viewHierarchyNode3);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LCAResult)) {
                return false;
            }
            LCAResult lCAResult = (LCAResult) obj;
            return Intrinsics.areEqual(this.lca, lCAResult.lca) && Intrinsics.areEqual(this.nodeSubtree, lCAResult.nodeSubtree) && Intrinsics.areEqual(this.otherNodeSubtree, lCAResult.otherNodeSubtree);
        }

        public int hashCode() {
            ViewHierarchyNode viewHierarchyNode = this.lca;
            int iHashCode = viewHierarchyNode == null ? 0 : viewHierarchyNode.hashCode();
            ViewHierarchyNode viewHierarchyNode2 = this.nodeSubtree;
            int iHashCode2 = viewHierarchyNode2 == null ? 0 : viewHierarchyNode2.hashCode();
            ViewHierarchyNode viewHierarchyNode3 = this.otherNodeSubtree;
            return (((iHashCode * 31) + iHashCode2) * 31) + (viewHierarchyNode3 != null ? viewHierarchyNode3.hashCode() : 0);
        }

        public String toString() {
            return "LCAResult(lca=" + this.lca + ", nodeSubtree=" + this.nodeSubtree + ", otherNodeSubtree=" + this.otherNodeSubtree + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public LCAResult(@Nullable ViewHierarchyNode viewHierarchyNode, @Nullable ViewHierarchyNode viewHierarchyNode2, @Nullable ViewHierarchyNode viewHierarchyNode3) {
            this.lca = viewHierarchyNode;
            this.nodeSubtree = viewHierarchyNode2;
            this.otherNodeSubtree = viewHierarchyNode3;
        }

        public final ViewHierarchyNode getLca() {
            return this.lca;
        }

        public final ViewHierarchyNode getNodeSubtree() {
            return this.nodeSubtree;
        }

        public final void setNodeSubtree(@Nullable ViewHierarchyNode viewHierarchyNode) {
            this.nodeSubtree = viewHierarchyNode;
        }

        public final ViewHierarchyNode getOtherNodeSubtree() {
            return this.otherNodeSubtree;
        }

        public final void setOtherNodeSubtree(@Nullable ViewHierarchyNode viewHierarchyNode) {
            this.otherNodeSubtree = viewHierarchyNode;
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        private final boolean isAssignableFrom(Class<?> cls, Set<String> set) {
            while (cls != null) {
                if (set.contains(cls.getName())) {
                    return true;
                }
                cls = cls.getSuperclass();
            }
            return false;
        }

        /* JADX WARN: Code duplicated, block: B:13:0x0028  */
        /* JADX WARN: Code duplicated, block: B:16:0x0037  */
        /* JADX WARN: Code duplicated, block: B:18:0x003f  */
        /* JADX WARN: Code duplicated, block: B:19:0x0042  */
        /* JADX WARN: Code duplicated, block: B:21:0x0045  */
        /* JADX WARN: Code duplicated, block: B:26:0x0059  */
        /* JADX WARN: Code duplicated, block: B:29:0x0068  */
        /* JADX WARN: Code duplicated, block: B:31:0x006e  */
        /* JADX WARN: Code duplicated, block: B:35:0x0083 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:38:0x009b A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:39:0x009c  */
        private final boolean shouldMask(View view, SentryOptions sentryOptions) {
            Object tag;
            String str;
            Class<?> cls;
            Set<String> unmaskViewClasses;
            ViewParent parent;
            String lowerCase;
            Object tag2 = view.getTag();
            String str2 = tag2 instanceof String ? (String) tag2 : null;
            if (str2 != null) {
                String lowerCase2 = str2.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                if (lowerCase2 == null || !StringsKt__StringsKt.contains$default((CharSequence) lowerCase2, (CharSequence) ViewHierarchyNode.SENTRY_UNMASK_TAG, false, 2, (Object) null)) {
                    if (!Intrinsics.areEqual(view.getTag(R.id.sentry_privacy), "unmask")) {
                        tag = view.getTag();
                        if (tag instanceof String) {
                            str = (String) tag;
                        } else {
                            str = null;
                        }
                        if (str != null) {
                            lowerCase = str.toLowerCase(Locale.ROOT);
                            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                            if (lowerCase != null || !StringsKt__StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) ViewHierarchyNode.SENTRY_MASK_TAG, false, 2, (Object) null)) {
                                if (!Intrinsics.areEqual(view.getTag(R.id.sentry_privacy), "mask")) {
                                    if (!isMaskContainer(view, sentryOptions) && view.getParent() != null) {
                                        parent = view.getParent();
                                        Intrinsics.checkNotNullExpressionValue(parent, "this.parent");
                                        if (isUnmaskContainer(parent, sentryOptions)) {
                                            return false;
                                        }
                                    }
                                    cls = view.getClass();
                                    unmaskViewClasses = sentryOptions.getSessionReplay().getUnmaskViewClasses();
                                    Intrinsics.checkNotNullExpressionValue(unmaskViewClasses, "options.sessionReplay.unmaskViewClasses");
                                    if (isAssignableFrom(cls, unmaskViewClasses)) {
                                        return false;
                                    }
                                    Class<?> cls2 = view.getClass();
                                    Set<String> maskViewClasses = sentryOptions.getSessionReplay().getMaskViewClasses();
                                    Intrinsics.checkNotNullExpressionValue(maskViewClasses, "options.sessionReplay.maskViewClasses");
                                    return isAssignableFrom(cls2, maskViewClasses);
                                }
                            }
                        } else if (!Intrinsics.areEqual(view.getTag(R.id.sentry_privacy), "mask")) {
                            if (!isMaskContainer(view, sentryOptions)) {
                                parent = view.getParent();
                                Intrinsics.checkNotNullExpressionValue(parent, "this.parent");
                                if (isUnmaskContainer(parent, sentryOptions)) {
                                    return false;
                                }
                            }
                            cls = view.getClass();
                            unmaskViewClasses = sentryOptions.getSessionReplay().getUnmaskViewClasses();
                            Intrinsics.checkNotNullExpressionValue(unmaskViewClasses, "options.sessionReplay.unmaskViewClasses");
                            if (isAssignableFrom(cls, unmaskViewClasses)) {
                                return false;
                            }
                            Class<?> cls3 = view.getClass();
                            Set<String> maskViewClasses2 = sentryOptions.getSessionReplay().getMaskViewClasses();
                            Intrinsics.checkNotNullExpressionValue(maskViewClasses2, "options.sessionReplay.maskViewClasses");
                            return isAssignableFrom(cls3, maskViewClasses2);
                        }
                        return true;
                    }
                }
            } else if (!Intrinsics.areEqual(view.getTag(R.id.sentry_privacy), "unmask")) {
                tag = view.getTag();
                if (tag instanceof String) {
                    str = (String) tag;
                } else {
                    str = null;
                }
                if (str != null) {
                    lowerCase = str.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                    if (lowerCase != null) {
                        if (!Intrinsics.areEqual(view.getTag(R.id.sentry_privacy), "mask")) {
                            if (!isMaskContainer(view, sentryOptions)) {
                                parent = view.getParent();
                                Intrinsics.checkNotNullExpressionValue(parent, "this.parent");
                                if (isUnmaskContainer(parent, sentryOptions)) {
                                    return false;
                                }
                            }
                            cls = view.getClass();
                            unmaskViewClasses = sentryOptions.getSessionReplay().getUnmaskViewClasses();
                            Intrinsics.checkNotNullExpressionValue(unmaskViewClasses, "options.sessionReplay.unmaskViewClasses");
                            if (isAssignableFrom(cls, unmaskViewClasses)) {
                                return false;
                            }
                            Class<?> cls4 = view.getClass();
                            Set<String> maskViewClasses3 = sentryOptions.getSessionReplay().getMaskViewClasses();
                            Intrinsics.checkNotNullExpressionValue(maskViewClasses3, "options.sessionReplay.maskViewClasses");
                            return isAssignableFrom(cls4, maskViewClasses3);
                        }
                    } else if (!Intrinsics.areEqual(view.getTag(R.id.sentry_privacy), "mask")) {
                        if (!isMaskContainer(view, sentryOptions)) {
                            parent = view.getParent();
                            Intrinsics.checkNotNullExpressionValue(parent, "this.parent");
                            if (isUnmaskContainer(parent, sentryOptions)) {
                                return false;
                            }
                        }
                        cls = view.getClass();
                        unmaskViewClasses = sentryOptions.getSessionReplay().getUnmaskViewClasses();
                        Intrinsics.checkNotNullExpressionValue(unmaskViewClasses, "options.sessionReplay.unmaskViewClasses");
                        if (isAssignableFrom(cls, unmaskViewClasses)) {
                            return false;
                        }
                        Class<?> cls5 = view.getClass();
                        Set<String> maskViewClasses4 = sentryOptions.getSessionReplay().getMaskViewClasses();
                        Intrinsics.checkNotNullExpressionValue(maskViewClasses4, "options.sessionReplay.maskViewClasses");
                        return isAssignableFrom(cls5, maskViewClasses4);
                    }
                } else if (!Intrinsics.areEqual(view.getTag(R.id.sentry_privacy), "mask")) {
                    if (!isMaskContainer(view, sentryOptions)) {
                        parent = view.getParent();
                        Intrinsics.checkNotNullExpressionValue(parent, "this.parent");
                        if (isUnmaskContainer(parent, sentryOptions)) {
                            return false;
                        }
                    }
                    cls = view.getClass();
                    unmaskViewClasses = sentryOptions.getSessionReplay().getUnmaskViewClasses();
                    Intrinsics.checkNotNullExpressionValue(unmaskViewClasses, "options.sessionReplay.unmaskViewClasses");
                    if (isAssignableFrom(cls, unmaskViewClasses)) {
                        return false;
                    }
                    Class<?> cls6 = view.getClass();
                    Set<String> maskViewClasses5 = sentryOptions.getSessionReplay().getMaskViewClasses();
                    Intrinsics.checkNotNullExpressionValue(maskViewClasses5, "options.sessionReplay.maskViewClasses");
                    return isAssignableFrom(cls6, maskViewClasses5);
                }
                return true;
            }
            return false;
        }

        private final boolean isUnmaskContainer(ViewParent viewParent, SentryOptions sentryOptions) {
            String unmaskViewContainerClass = sentryOptions.getSessionReplay().getUnmaskViewContainerClass();
            if (unmaskViewContainerClass == null) {
                return false;
            }
            return Intrinsics.areEqual(viewParent.getClass().getName(), unmaskViewContainerClass);
        }

        private final boolean isMaskContainer(View view, SentryOptions sentryOptions) {
            String maskViewContainerClass = sentryOptions.getSessionReplay().getMaskViewContainerClass();
            if (maskViewContainerClass == null) {
                return false;
            }
            return Intrinsics.areEqual(view.getClass().getName(), maskViewContainerClass);
        }

        public final ViewHierarchyNode fromView(@NotNull View view, @Nullable ViewHierarchyNode viewHierarchyNode, int i, @NotNull SentryOptions options) {
            Drawable drawable;
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(options, "options");
            Pair<Boolean, Rect> pairIsVisibleToUser = ViewsKt.isVisibleToUser(view);
            boolean zBooleanValue = pairIsVisibleToUser.component1().booleanValue();
            Rect rectComponent2 = pairIsVisibleToUser.component2();
            boolean z = zBooleanValue && shouldMask(view, options);
            if (view instanceof TextView) {
                if (viewHierarchyNode != null) {
                    viewHierarchyNode.setImportantForCaptureToAncestors(true);
                }
                TextView textView = (TextView) view;
                Layout layout = textView.getLayout();
                return new TextViewHierarchyNode(layout != null ? new AndroidTextLayout(layout) : null, Integer.valueOf(ViewsKt.toOpaque(textView.getCurrentTextColor())), textView.getTotalPaddingLeft(), ViewsKt.getTotalPaddingTopSafe(textView), textView.getX(), textView.getY(), textView.getWidth(), textView.getHeight(), (viewHierarchyNode != null ? viewHierarchyNode.getElevation() : 0.0f) + textView.getElevation(), i, viewHierarchyNode, z, true, zBooleanValue, rectComponent2);
            }
            if (view instanceof ImageView) {
                if (viewHierarchyNode != null) {
                    viewHierarchyNode.setImportantForCaptureToAncestors(true);
                }
                ImageView imageView = (ImageView) view;
                float x = imageView.getX();
                float y = imageView.getY();
                int width = imageView.getWidth();
                int height = imageView.getHeight();
                float elevation = viewHierarchyNode != null ? viewHierarchyNode.getElevation() : 0.0f;
                return new ImageViewHierarchyNode(x, y, width, height, imageView.getElevation() + elevation, i, viewHierarchyNode, z && (drawable = imageView.getDrawable()) != null && ViewsKt.isMaskable(drawable), true, zBooleanValue, rectComponent2);
            }
            return new GenericViewHierarchyNode(view.getX(), view.getY(), view.getWidth(), view.getHeight(), (viewHierarchyNode != null ? viewHierarchyNode.getElevation() : 0.0f) + view.getElevation(), i, viewHierarchyNode, z, false, zBooleanValue, rectComponent2);
        }
    }
}
