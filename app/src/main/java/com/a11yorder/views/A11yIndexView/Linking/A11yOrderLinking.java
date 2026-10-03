package com.a11yorder.views.A11yIndexView.Linking;

import android.view.View;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class A11yOrderLinking {
    private static A11yOrderLinking instance;
    private final Map<String, LinkingQueue> relationships = new HashMap();

    private A11yOrderLinking() {
    }

    public static A11yOrderLinking getInstance() {
        A11yOrderLinking a11yOrderLinking;
        synchronized (A11yOrderLinking.class) {
            if (instance == null) {
                instance = new A11yOrderLinking();
            }
            a11yOrderLinking = instance;
        }
        return a11yOrderLinking;
    }

    public void refreshIndexes(View view, String str, int i) {
        LinkingQueue linkingQueue = this.relationships.get(str);
        if (linkingQueue != null) {
            linkingQueue.refreshIndexes(view, i);
        }
    }

    public void addViewRelationship(View view, String str, int i) {
        LinkingQueue linkingQueue = this.relationships.get(str);
        if (linkingQueue == null) {
            linkingQueue = new LinkingQueue();
            this.relationships.put(str, linkingQueue);
        }
        linkingQueue.addPosition(view, i);
    }

    public void removeRelationship(String str, int i) {
        LinkingQueue linkingQueue = this.relationships.get(str);
        if (linkingQueue == null) {
            return;
        }
        linkingQueue.removeFromOrder(i);
    }
}
