package com.google.android.material.datepicker;

import android.content.Context;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes5.dex */
public class SmoothCalendarLayoutManager extends LinearLayoutManager {
    private static final float MILLISECONDS_PER_INCH = 100.0f;
    public static int MediaBrowserCompatCallbackHandler;
    public static int handleMessage;

    SmoothCalendarLayoutManager(Context context, int i, boolean z) {
        super(context, i, z);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext()) { // from class: com.google.android.material.datepicker.SmoothCalendarLayoutManager.1
            @Override // androidx.recyclerview.widget.LinearSmoothScroller
            public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                return 100.0f / displayMetrics.densityDpi;
            }
        };
        linearSmoothScroller.setTargetPosition(i);
        startSmoothScroll(linearSmoothScroller);
    }

    public static int validateRelationship() {
        int i = MediaBrowserCompatCallbackHandler;
        int i2 = i % 5699519;
        MediaBrowserCompatCallbackHandler = i + 1;
        if (i2 != 0) {
            return handleMessage;
        }
        int iElapsedRealtime = (int) SystemClock.elapsedRealtime();
        handleMessage = iElapsedRealtime;
        return iElapsedRealtime;
    }
}
