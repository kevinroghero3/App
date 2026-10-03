package com.facebook.react.uimanager;

import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes2.dex */
public final class ReactRootViewTagGenerator {
    private static final int ROOT_VIEW_TAG_INCREMENT = 10;
    public static final ReactRootViewTagGenerator INSTANCE = new ReactRootViewTagGenerator();
    private static int nextRootViewTag = 1;

    private ReactRootViewTagGenerator() {
    }

    @JvmStatic
    public static final int getNextRootViewTag() {
        int i;
        synchronized (ReactRootViewTagGenerator.class) {
            i = nextRootViewTag;
            nextRootViewTag = i + 10;
        }
        return i;
    }
}
