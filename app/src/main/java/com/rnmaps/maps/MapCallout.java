package com.rnmaps.maps;

import android.content.Context;
import com.facebook.react.views.view.ReactViewGroup;

/* JADX INFO: loaded from: classes3.dex */
public class MapCallout extends ReactViewGroup {
    public int height;
    private boolean tooltip;
    public int width;

    public MapCallout(Context context) {
        super(context);
        this.tooltip = false;
    }

    public void setTooltip(boolean z) {
        this.tooltip = z;
    }

    public boolean getTooltip() {
        return this.tooltip;
    }
}
