package io.sentry.android.replay.viewhierarchy;

import android.graphics.Rect;
import android.view.View;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsConfigurationKt;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.TextUnit;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.SentryReplayOptions;
import io.sentry.android.replay.SentryReplayModifiers;
import io.sentry.android.replay.util.ComposeTextLayout;
import io.sentry.android.replay.util.NodesKt;
import io.sentry.android.replay.util.TextAttributes;
import io.sentry.android.replay.util.ViewsKt;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public final class ComposeViewHierarchyNode {
    private static WeakReference<LayoutCoordinates> _rootCoordinates;
    private static boolean semanticsRetrievalErrorLogged;
    public static final ComposeViewHierarchyNode INSTANCE = new ComposeViewHierarchyNode();
    private static final Lazy getSemanticsConfigurationMethod$delegate = LazyKt__LazyJVMKt.lazy(new Function0<Method>() { // from class: io.sentry.android.replay.viewhierarchy.ComposeViewHierarchyNode$getSemanticsConfigurationMethod$2
        @Override // kotlin.jvm.functions.Function0
        public final Method invoke() {
            try {
                Method declaredMethod = LayoutNode.class.getDeclaredMethod("getSemanticsConfiguration", null);
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (Throwable unused) {
                return null;
            }
        }
    });
    public static final int $stable = 8;

    private static /* synthetic */ void get_rootCoordinates$annotations() {
    }

    private ComposeViewHierarchyNode() {
    }

    private final Method getGetSemanticsConfigurationMethod() {
        return (Method) getSemanticsConfigurationMethod$delegate.getValue();
    }

    @JvmStatic
    public static final SemanticsConfiguration retrieveSemanticsConfiguration$sentry_android_replay_release(@NotNull LayoutNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        Method getSemanticsConfigurationMethod = INSTANCE.getGetSemanticsConfigurationMethod();
        if (getSemanticsConfigurationMethod != null) {
            return (SemanticsConfiguration) getSemanticsConfigurationMethod.invoke(node, null);
        }
        return node.getCollapsedSemantics$ui_release();
    }

    private final String getProxyClassName(boolean z, SemanticsConfiguration semanticsConfiguration) {
        if (z) {
            return SentryReplayOptions.IMAGE_VIEW_CLASS_NAME;
        }
        if (semanticsConfiguration != null) {
            SemanticsProperties semanticsProperties = SemanticsProperties.INSTANCE;
            if (semanticsConfiguration.contains(semanticsProperties.getText()) || semanticsConfiguration.contains(SemanticsActions.INSTANCE.getSetText()) || semanticsConfiguration.contains(semanticsProperties.getEditableText())) {
                return "android.widget.TextView";
            }
        }
        return AndroidComposeViewAccessibilityDelegateCompat.ClassName;
    }

    private final boolean shouldMask(SemanticsConfiguration semanticsConfiguration, boolean z, SentryOptions sentryOptions) {
        String str = semanticsConfiguration != null ? (String) SemanticsConfigurationKt.getOrNull(semanticsConfiguration, SentryReplayModifiers.INSTANCE.getSentryPrivacy()) : null;
        if (Intrinsics.areEqual(str, "unmask")) {
            return false;
        }
        if (Intrinsics.areEqual(str, "mask")) {
            return true;
        }
        String proxyClassName = getProxyClassName(z, semanticsConfiguration);
        if (sentryOptions.getSessionReplay().getUnmaskViewClasses().contains(proxyClassName)) {
            return false;
        }
        return sentryOptions.getSessionReplay().getMaskViewClasses().contains(proxyClassName);
    }

    private final ViewHierarchyNode fromComposeNode(LayoutNode layoutNode, ViewHierarchyNode viewHierarchyNode, int i, boolean z, SentryOptions sentryOptions) {
        TextLayoutInput layoutInput;
        TextStyle style;
        TextLayoutInput layoutInput2;
        TextStyle style2;
        AccessibilityAction accessibilityAction;
        Function1 function1;
        if (!layoutNode.isPlaced() || !layoutNode.isAttached()) {
            return null;
        }
        if (z) {
            _rootCoordinates = new WeakReference<>(LayoutCoordinatesKt.findRootCoordinates(layoutNode.getCoordinates()));
        }
        LayoutCoordinates coordinates = layoutNode.getCoordinates();
        WeakReference<LayoutCoordinates> weakReference = _rootCoordinates;
        Rect rectBoundsInWindow = NodesKt.boundsInWindow(coordinates, weakReference != null ? weakReference.get() : null);
        try {
            SemanticsConfiguration semanticsConfigurationRetrieveSemanticsConfiguration$sentry_android_replay_release = retrieveSemanticsConfiguration$sentry_android_replay_release(layoutNode);
            boolean z2 = !layoutNode.getOuterCoordinator$ui_release().isTransparent() && (semanticsConfigurationRetrieveSemanticsConfiguration$sentry_android_replay_release == null || !semanticsConfigurationRetrieveSemanticsConfiguration$sentry_android_replay_release.contains(SemanticsProperties.INSTANCE.getInvisibleToUser())) && rectBoundsInWindow.height() > 0 && rectBoundsInWindow.width() > 0;
            boolean z3 = (semanticsConfigurationRetrieveSemanticsConfiguration$sentry_android_replay_release != null && semanticsConfigurationRetrieveSemanticsConfiguration$sentry_android_replay_release.contains(SemanticsActions.INSTANCE.getSetText())) || (semanticsConfigurationRetrieveSemanticsConfiguration$sentry_android_replay_release != null && semanticsConfigurationRetrieveSemanticsConfiguration$sentry_android_replay_release.contains(SemanticsProperties.INSTANCE.getEditableText()));
            if ((semanticsConfigurationRetrieveSemanticsConfiguration$sentry_android_replay_release != null && semanticsConfigurationRetrieveSemanticsConfiguration$sentry_android_replay_release.contains(SemanticsProperties.INSTANCE.getText())) || z3) {
                boolean z4 = z2 && shouldMask(semanticsConfigurationRetrieveSemanticsConfiguration$sentry_android_replay_release, false, sentryOptions);
                if (viewHierarchyNode != null) {
                    viewHierarchyNode.setImportantForCaptureToAncestors(true);
                }
                ArrayList arrayList = new ArrayList();
                if (semanticsConfigurationRetrieveSemanticsConfiguration$sentry_android_replay_release != null && (accessibilityAction = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsConfigurationRetrieveSemanticsConfiguration$sentry_android_replay_release, SemanticsActions.INSTANCE.getGetTextLayoutResult())) != null && (function1 = (Function1) accessibilityAction.getAction()) != null) {
                }
                TextAttributes textAttributesFindTextAttributes = NodesKt.findTextAttributes(layoutNode);
                Color colorM5437component1QN2ZGVo = textAttributesFindTextAttributes.m5437component1QN2ZGVo();
                boolean zComponent2 = textAttributesFindTextAttributes.component2();
                TextLayoutResult textLayoutResult = (TextLayoutResult) CollectionsKt___CollectionsKt.firstOrNull((List) arrayList);
                Color colorM1159boximpl = (textLayoutResult == null || (layoutInput2 = textLayoutResult.getLayoutInput()) == null || (style2 = layoutInput2.getStyle()) == null) ? null : Color.m1159boximpl(style2.m3165getColor0d7_KjU());
                if (colorM1159boximpl == null || colorM1159boximpl.m1179unboximpl() != Color.Companion.m1205getUnspecified0d7_KjU()) {
                    colorM5437component1QN2ZGVo = colorM1159boximpl;
                }
                TextUnit textUnitM3833boximpl = (textLayoutResult == null || (layoutInput = textLayoutResult.getLayoutInput()) == null || (style = layoutInput.getStyle()) == null) ? null : TextUnit.m3833boximpl(style.m3166getFontSizeXSAIIZE());
                return new ViewHierarchyNode.TextViewHierarchyNode((textLayoutResult == null || z3 || (textUnitM3833boximpl != null ? TextUnit.m3840equalsimpl0(textUnitM3833boximpl.m3852unboximpl(), TextUnit.Companion.m3854getUnspecifiedXSAIIZE()) : false)) ? null : new ComposeTextLayout(textLayoutResult, zComponent2), colorM5437component1QN2ZGVo != null ? Integer.valueOf(ViewsKt.toOpaque(ColorKt.m1223toArgb8_81llA(colorM5437component1QN2ZGVo.m1179unboximpl()))) : null, 0, 0, rectBoundsInWindow.left, rectBoundsInWindow.top, layoutNode.getWidth(), layoutNode.getHeight(), viewHierarchyNode != null ? viewHierarchyNode.getElevation() : 0.0f, i, viewHierarchyNode, z4, true, z2, rectBoundsInWindow, 12, null);
            }
            Painter painterFindPainter = NodesKt.findPainter(layoutNode);
            if (painterFindPainter != null) {
                boolean z5 = z2 && shouldMask(semanticsConfigurationRetrieveSemanticsConfiguration$sentry_android_replay_release, true, sentryOptions);
                if (viewHierarchyNode != null) {
                    viewHierarchyNode.setImportantForCaptureToAncestors(true);
                }
                return new ViewHierarchyNode.ImageViewHierarchyNode(rectBoundsInWindow.left, rectBoundsInWindow.top, layoutNode.getWidth(), layoutNode.getHeight(), viewHierarchyNode != null ? viewHierarchyNode.getElevation() : 0.0f, i, viewHierarchyNode, z5 && NodesKt.isMaskable(painterFindPainter), true, z2, rectBoundsInWindow);
            }
            return new ViewHierarchyNode.GenericViewHierarchyNode(rectBoundsInWindow.left, rectBoundsInWindow.top, layoutNode.getWidth(), layoutNode.getHeight(), viewHierarchyNode != null ? viewHierarchyNode.getElevation() : 0.0f, i, viewHierarchyNode, z2 && shouldMask(semanticsConfigurationRetrieveSemanticsConfiguration$sentry_android_replay_release, false, sentryOptions), false, z2, rectBoundsInWindow);
        } catch (Throwable th) {
            if (!semanticsRetrievalErrorLogged) {
                semanticsRetrievalErrorLogged = true;
                sentryOptions.getLogger().log(SentryLevel.ERROR, th, "Error retrieving semantics information from Compose tree. Most likely you're using\nan unsupported version of androidx.compose.ui:ui. The supported\nversion range is 1.5.0 - 1.8.0.\nIf you're using a newer version, please open a github issue with the version\nyou're using, so we can add support for it.", new Object[0]);
            }
            return new ViewHierarchyNode.GenericViewHierarchyNode(rectBoundsInWindow.left, rectBoundsInWindow.top, layoutNode.getWidth(), layoutNode.getHeight(), viewHierarchyNode != null ? viewHierarchyNode.getElevation() : 0.0f, i, viewHierarchyNode, true, false, !layoutNode.getOuterCoordinator$ui_release().isTransparent() && rectBoundsInWindow.height() > 0 && rectBoundsInWindow.width() > 0, rectBoundsInWindow);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean fromView(@NotNull View view, @Nullable ViewHierarchyNode viewHierarchyNode, @NotNull SentryOptions options) {
        LayoutNode root;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(options, "options");
        String name = view.getClass().getName();
        Intrinsics.checkNotNullExpressionValue(name, "view::class.java.name");
        if (!StringsKt__StringsKt.contains$default((CharSequence) name, (CharSequence) "AndroidComposeView", false, 2, (Object) null) || viewHierarchyNode == null) {
            return false;
        }
        try {
            Owner owner = view instanceof Owner ? (Owner) view : null;
            if (owner != null && (root = owner.getRoot()) != null) {
                traverse(root, viewHierarchyNode, true, options);
                return true;
            }
            return false;
        } catch (Throwable th) {
            options.getLogger().log(SentryLevel.ERROR, th, "Error traversing Compose tree. Most likely you're using an unsupported version of\nandroidx.compose.ui:ui. The minimum supported version is 1.5.0. If it's a newer\nversion, please open a github issue with the version you're using, so we can add\nsupport for it.", new Object[0]);
            return false;
        }
    }

    private final void traverse(LayoutNode layoutNode, ViewHierarchyNode viewHierarchyNode, boolean z, SentryOptions sentryOptions) {
        List<LayoutNode> children$ui_release = layoutNode.getChildren$ui_release();
        if (children$ui_release.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList(children$ui_release.size());
        int size = children$ui_release.size();
        for (int i = 0; i < size; i++) {
            LayoutNode layoutNode2 = children$ui_release.get(i);
            ViewHierarchyNode viewHierarchyNodeFromComposeNode = fromComposeNode(layoutNode2, viewHierarchyNode, i, z, sentryOptions);
            if (viewHierarchyNodeFromComposeNode != null) {
                arrayList.add(viewHierarchyNodeFromComposeNode);
                traverse(layoutNode2, viewHierarchyNodeFromComposeNode, false, sentryOptions);
            }
        }
        viewHierarchyNode.setChildren(arrayList);
    }
}
