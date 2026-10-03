package com.swmansion.gesturehandler.react;

import android.util.SparseArray;
import android.view.View;
import com.facebook.react.bridge.UiThreadUtil;
import com.swmansion.gesturehandler.core.GestureHandler;
import com.swmansion.gesturehandler.core.GestureHandlerRegistry;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class RNGestureHandlerRegistry implements GestureHandlerRegistry {
    private final SparseArray<GestureHandler> handlers = new SparseArray<>();
    private final SparseArray<Integer> attachedTo = new SparseArray<>();
    private final SparseArray<ArrayList<GestureHandler>> handlersForView = new SparseArray<>();

    public final void registerHandler(@NotNull GestureHandler handler) {
        synchronized (this) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            this.handlers.put(handler.getTag(), handler);
        }
    }

    public final GestureHandler getHandler(int i) {
        GestureHandler gestureHandler;
        synchronized (this) {
            gestureHandler = this.handlers.get(i);
        }
        return gestureHandler;
    }

    public final boolean attachHandlerToView(int i, int i2, int i3) {
        boolean z;
        synchronized (this) {
            GestureHandler gestureHandler = this.handlers.get(i);
            if (gestureHandler != null) {
                detachHandler(gestureHandler);
                gestureHandler.setActionType(i3);
                registerHandlerForViewWithTag(i2, gestureHandler);
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    private final void registerHandlerForViewWithTag(int i, GestureHandler gestureHandler) {
        synchronized (this) {
            if (this.attachedTo.get(gestureHandler.getTag()) != null) {
                throw new IllegalStateException(("Handler " + gestureHandler + " already attached").toString());
            }
            this.attachedTo.put(gestureHandler.getTag(), Integer.valueOf(i));
            ArrayList<GestureHandler> arrayList = this.handlersForView.get(i);
            if (arrayList == null) {
                ArrayList<GestureHandler> arrayList2 = new ArrayList<>(1);
                arrayList2.add(gestureHandler);
                this.handlersForView.put(i, arrayList2);
            } else {
                synchronized (arrayList) {
                    arrayList.add(gestureHandler);
                }
            }
        }
    }

    private final void detachHandler(final GestureHandler gestureHandler) {
        synchronized (this) {
            Integer num = this.attachedTo.get(gestureHandler.getTag());
            if (num != null) {
                this.attachedTo.remove(gestureHandler.getTag());
                ArrayList<GestureHandler> arrayList = this.handlersForView.get(num.intValue());
                if (arrayList != null) {
                    synchronized (arrayList) {
                        arrayList.remove(gestureHandler);
                    }
                    if (arrayList.size() == 0) {
                        this.handlersForView.remove(num.intValue());
                    }
                }
            }
            if (gestureHandler.getView() != null) {
                UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.swmansion.gesturehandler.react.RNGestureHandlerRegistry$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        gestureHandler.cancel();
                    }
                });
            }
        }
    }

    public final void dropHandler(int i) {
        synchronized (this) {
            GestureHandler gestureHandler = this.handlers.get(i);
            if (gestureHandler != null) {
                detachHandler(gestureHandler);
                this.handlers.remove(i);
            }
        }
    }

    public final void dropAllHandlers() {
        synchronized (this) {
            this.handlers.clear();
            this.attachedTo.clear();
            this.handlersForView.clear();
        }
    }

    public final ArrayList<GestureHandler> getHandlersForViewWithTag(int i) {
        ArrayList<GestureHandler> arrayList;
        synchronized (this) {
            arrayList = this.handlersForView.get(i);
        }
        return arrayList;
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandlerRegistry
    public ArrayList<GestureHandler> getHandlersForView(@NotNull View view) {
        ArrayList<GestureHandler> handlersForViewWithTag;
        synchronized (this) {
            Intrinsics.checkNotNullParameter(view, "view");
            handlersForViewWithTag = getHandlersForViewWithTag(view.getId());
        }
        return handlersForViewWithTag;
    }
}
