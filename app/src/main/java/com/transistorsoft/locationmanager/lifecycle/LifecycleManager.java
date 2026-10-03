package com.transistorsoft.locationmanager.lifecycle;

import android.os.Handler;
import android.os.Looper;
import android.view.accessibility.AccessibilityWindowInfo;
import androidx.annotation.NonNull;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.transistorsoft.locationmanager.logger.TSLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class LifecycleManager implements DefaultLifecycleObserver, Runnable {
    private static LifecycleManager i;
    private Runnable d;
    private final List<OnHeadlessChangeCallback> a = new ArrayList();
    private final List<OnStateChangeCallback> b = new ArrayList();
    private final AtomicBoolean e = new AtomicBoolean(true);
    private final AtomicBoolean f = new AtomicBoolean(true);
    private final AtomicBoolean g = new AtomicBoolean(false);
    private final AtomicBoolean h = new AtomicBoolean(false);
    private final Handler c = new Handler(Looper.getMainLooper());

    /* JADX INFO: loaded from: classes3.dex */
    public interface OnHeadlessChangeCallback {
        void onChange(boolean z);
    }

    /* JADX INFO: loaded from: classes3.dex */
    public interface OnStateChangeCallback {
        void onChange(boolean z);
    }

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LifecycleManager.this.g.set(true);
            LifecycleManager.this.a();
        }
    }

    private LifecycleManager() {
        onHeadlessChange(new OnHeadlessChangeCallback() { // from class: com.transistorsoft.locationmanager.lifecycle.LifecycleManager$$ExternalSyntheticLambda0
            @Override // com.transistorsoft.locationmanager.lifecycle.LifecycleManager.OnHeadlessChangeCallback
            public final void onChange(boolean z) {
                LifecycleManager.b(z);
            }
        });
    }

    public static LifecycleManager getInstance() {
        if (i == null) {
            i = b();
        }
        return i;
    }

    public boolean isBackground() {
        return this.e.get();
    }

    public boolean isHeadless() {
        return this.f.get();
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onCreate(@NonNull LifecycleOwner lifecycleOwner) {
        TSLog.logger.debug("☯️  onCreate");
        a aVar = new a();
        this.d = aVar;
        this.c.postDelayed(aVar, 50L);
        this.f.set(true);
        this.e.set(true);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onDestroy(@NonNull LifecycleOwner lifecycleOwner) {
        TSLog.logger.debug("☯️  onDestroy");
        this.e.set(true);
        this.f.set(true);
    }

    public void onHeadlessChange(OnHeadlessChangeCallback onHeadlessChangeCallback) {
        if (this.g.get()) {
            onHeadlessChangeCallback.onChange(this.f.get());
            return;
        }
        synchronized (this.a) {
            this.a.add(onHeadlessChangeCallback);
        }
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onPause(@NonNull LifecycleOwner lifecycleOwner) {
        TSLog.logger.debug("☯️  onPause");
        this.e.set(true);
        a(false);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onResume(@NonNull LifecycleOwner lifecycleOwner) {
        TSLog.logger.debug("☯️  onResume");
        if (this.h.get()) {
            return;
        }
        this.e.set(false);
        this.f.set(false);
        a(true);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onStart(@NonNull LifecycleOwner lifecycleOwner) {
        TSLog.logger.debug("☯️  onStart");
        if (this.h.get()) {
            return;
        }
        Runnable runnable = this.d;
        if (runnable != null) {
            this.c.removeCallbacks(runnable);
        }
        this.g.set(true);
        this.f.set(false);
        this.e.set(false);
        a();
    }

    public void onStateChange(OnStateChangeCallback onStateChangeCallback) {
        synchronized (this.b) {
            this.b.add(onStateChangeCallback);
        }
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onStop(@NonNull LifecycleOwner lifecycleOwner) {
        TSLog.logger.debug("☯️  onStop");
        if (this.h.compareAndSet(true, false)) {
            return;
        }
        this.e.set(true);
    }

    public void pause() {
        this.h.set(true);
    }

    public void resume() {
        this.h.set(false);
    }

    @Override // java.lang.Runnable
    public void run() {
        ProcessLifecycleOwner.get().getLifecycle().addObserver(this);
    }

    public void setHeadless(boolean z) {
        this.f.set(z);
        if (this.f.get()) {
            TSLog.logger.debug(TSLog.header("☯️  HeadlessMode? " + this.f));
        }
        Runnable runnable = this.d;
        if (runnable != null) {
            this.c.removeCallbacks(runnable);
            this.g.set(true);
            a();
        }
    }

    private boolean a(List<AccessibilityWindowInfo> list) {
        Iterator<AccessibilityWindowInfo> it2 = list.iterator();
        while (it2.hasNext()) {
            if (it2.next().getType() == 5) {
                return true;
            }
        }
        return false;
    }

    private static LifecycleManager b() {
        LifecycleManager lifecycleManager;
        synchronized (LifecycleManager.class) {
            if (i == null) {
                i = new LifecycleManager();
            }
            lifecycleManager = i;
        }
        return lifecycleManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(boolean z) {
        if (z) {
            TSLog.logger.debug(TSLog.header("☯️  HeadlessMode? " + z));
        }
    }

    private void a(boolean z) {
        synchronized (this.b) {
            Iterator<OnStateChangeCallback> it2 = this.b.iterator();
            while (it2.hasNext()) {
                it2.next().onChange(z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        Runnable runnable = this.d;
        if (runnable != null) {
            this.c.removeCallbacks(runnable);
            this.d = null;
        }
        synchronized (this.a) {
            Iterator<OnHeadlessChangeCallback> it2 = this.a.iterator();
            while (it2.hasNext()) {
                it2.next().onChange(this.f.get());
            }
            this.a.clear();
        }
    }
}
