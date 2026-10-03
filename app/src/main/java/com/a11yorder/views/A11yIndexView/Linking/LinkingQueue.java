package com.a11yorder.views.A11yIndexView.Linking;

import android.view.View;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.TreeMap;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes2.dex */
public class LinkingQueue {
    public NavigableSet<Integer> positions = new TreeSet();
    public NavigableMap<Integer, View> viewMap = new TreeMap();

    private void linkPosition(View view, View view2) {
        if (view == null || view2 == null) {
            return;
        }
        view.setNextFocusForwardId(view2.getId());
        view.setAccessibilityTraversalBefore(view2.getId());
    }

    private void addWithLinking(int i, View view) {
        this.viewMap.put(Integer.valueOf(i), view);
        Map.Entry<Integer, View> entryHigherEntry = this.viewMap.higherEntry(Integer.valueOf(i));
        Map.Entry<Integer, View> entryLowerEntry = this.viewMap.lowerEntry(Integer.valueOf(i));
        if (entryLowerEntry != null) {
            linkPosition(entryLowerEntry.getValue(), view);
        }
        if (entryHigherEntry != null) {
            linkPosition(view, entryHigherEntry.getValue());
        }
    }

    private void unlinkLast() {
        Map.Entry<Integer, View> entryLastEntry = this.viewMap.lastEntry();
        if (entryLastEntry != null) {
            entryLastEntry.getValue().setNextFocusForwardId(-1);
            entryLastEntry.getValue().setAccessibilityTraversalBefore(-1);
        }
    }

    private void reLinkWithRemove(int i) {
        Map.Entry<Integer, View> entryHigherEntry = this.viewMap.higherEntry(Integer.valueOf(i));
        Map.Entry<Integer, View> entryLowerEntry = this.viewMap.lowerEntry(Integer.valueOf(i));
        if (entryLowerEntry != null && entryHigherEntry != null) {
            linkPosition(entryLowerEntry.getValue(), entryHigherEntry.getValue());
        }
        boolean z = entryHigherEntry == null;
        this.viewMap.remove(Integer.valueOf(i));
        if (z) {
            unlinkLast();
        }
    }

    public void addPosition(View view, int i) {
        if (this.viewMap.get(Integer.valueOf(i)) == view) {
            return;
        }
        addWithLinking(i, view);
    }

    public void removeFromOrder(int i) {
        if (this.positions.contains(Integer.valueOf(i))) {
            reLinkWithRemove(i);
        }
    }

    public void refreshIndexes(View view, int i) {
        this.viewMap.put(Integer.valueOf(i), view);
        for (Map.Entry<Integer, View> entry : this.viewMap.entrySet()) {
            if (entry != null) {
                View value = entry.getValue();
                Map.Entry<Integer, View> entryHigherEntry = this.viewMap.higherEntry(entry.getKey());
                if (entryHigherEntry != null) {
                    linkPosition(value, entryHigherEntry.getValue());
                }
            }
        }
        unlinkLast();
    }
}
