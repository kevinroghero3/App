package com.facebook.react.animated;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AnimatedNode {
    public static final Companion Companion = new Companion(null);
    public static final int DEFAULT_ANIMATED_NODE_CHILD_COUNT = 1;
    public static final int INITIAL_BFS_COLOR = 0;
    public int BFSColor;
    public int activeIncomingNodes;
    public List<AnimatedNode> children;
    public int tag = -1;

    public void onAttachedToNode(@NotNull AnimatedNode parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
    }

    public void onDetachedFromNode(@NotNull AnimatedNode parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
    }

    public abstract String prettyPrint();

    public void update() {
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final void addChild(@NotNull AnimatedNode child) {
        Intrinsics.checkNotNullParameter(child, "child");
        List arrayList = this.children;
        if (arrayList == null) {
            arrayList = new ArrayList(1);
            this.children = arrayList;
        }
        arrayList.add(child);
        child.onAttachedToNode(this);
    }

    public final void removeChild(@NotNull AnimatedNode child) {
        Intrinsics.checkNotNullParameter(child, "child");
        List<AnimatedNode> list = this.children;
        if (list == null) {
            return;
        }
        child.onDetachedFromNode(this);
        list.remove(child);
    }

    public final String prettyPrintWithChildren() {
        String str;
        List<AnimatedNode> list = this.children;
        String strJoinToString$default = list != null ? CollectionsKt___CollectionsKt.joinToString$default(list, StringUtils.SPACE, null, null, 0, null, null, 62, null) : null;
        String strPrettyPrint = prettyPrint();
        if (strJoinToString$default == null || StringsKt__StringsKt.isBlank(strJoinToString$default)) {
            str = "";
        } else {
            str = " children: " + strJoinToString$default;
        }
        return strPrettyPrint + str;
    }
}
