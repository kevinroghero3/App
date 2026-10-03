package com.reactnativepagerview;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class ViewPagerAdapter extends RecyclerView.Adapter<ViewPagerViewHolder> {
    private final ArrayList<View> childrenViews = new ArrayList<>();

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewPagerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return ViewPagerViewHolder.Companion.create(parent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull ViewPagerViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        FrameLayout container = holder.getContainer();
        View childAt = getChildAt(i);
        holder.setIsRecyclable(false);
        if (container.getChildCount() > 0) {
            container.removeAllViews();
        }
        if (childAt.getParent() != null) {
            ViewParent parent = childAt.getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.widget.FrameLayout");
            ((FrameLayout) parent).removeView(childAt);
        }
        container.addView(childAt);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.childrenViews.size();
    }

    public final void addChild(@NotNull View child, int i) {
        Intrinsics.checkNotNullParameter(child, "child");
        this.childrenViews.add(i, child);
        notifyItemInserted(i);
    }

    public final View getChildAt(int i) {
        View view = this.childrenViews.get(i);
        Intrinsics.checkNotNullExpressionValue(view, "get(...)");
        return view;
    }

    public final void removeChild(@NotNull View child) {
        Intrinsics.checkNotNullParameter(child, "child");
        int iIndexOf = this.childrenViews.indexOf(child);
        if (iIndexOf > -1) {
            removeChildAt(iIndexOf);
        }
    }

    public final void removeAll() {
        int size = this.childrenViews.size();
        int i = 1;
        if (1 <= size) {
            while (true) {
                View view = this.childrenViews.get(i - 1);
                Intrinsics.checkNotNullExpressionValue(view, "get(...)");
                View view2 = view;
                ViewParent parent = view2.getParent();
                if ((parent != null ? parent.getParent() : null) != null) {
                    ViewParent parent2 = view2.getParent().getParent();
                    Intrinsics.checkNotNull(parent2, "null cannot be cast to non-null type android.view.ViewGroup");
                    Object parent3 = view2.getParent();
                    Intrinsics.checkNotNull(parent3, "null cannot be cast to non-null type android.view.View");
                    ((ViewGroup) parent2).removeView((View) parent3);
                }
                if (i == size) {
                    break;
                } else {
                    i++;
                }
            }
        }
        int size2 = this.childrenViews.size();
        this.childrenViews.clear();
        notifyItemRangeRemoved(0, size2);
    }

    public final void removeChildAt(int i) {
        if (i < 0 || i >= this.childrenViews.size()) {
            return;
        }
        this.childrenViews.remove(i);
        notifyItemRemoved(i);
    }
}
