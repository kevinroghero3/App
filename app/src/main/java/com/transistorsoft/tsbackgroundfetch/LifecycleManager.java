package com.transistorsoft.tsbackgroundfetch;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ProcessLifecycleOwner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public class LifecycleManager implements DefaultLifecycleObserver, Runnable {
    private static LifecycleManager sInstance;
    private Runnable mHeadlessChangeEvent;
    private final List<OnHeadlessChangeCallback> mHeadlessChangeCallbacks = new ArrayList();
    private final List<OnStateChangeCallback> mStateChangeCallbacks = new ArrayList();
    private final AtomicBoolean mIsBackground = new AtomicBoolean(true);
    private final AtomicBoolean mIsHeadless = new AtomicBoolean(true);
    private final AtomicBoolean mStarted = new AtomicBoolean(false);
    private final AtomicBoolean mPaused = new AtomicBoolean(false);
    private final Handler mHandler = new Handler(Looper.getMainLooper());

    public interface OnHeadlessChangeCallback {
        void onChange(boolean z);
    }

    public interface OnStateChangeCallback {
        void onChange(boolean z);
    }

    public static LifecycleManager getInstance() {
        if (sInstance == null) {
            sInstance = getInstanceSynchronized();
        }
        return sInstance;
    }

    private static LifecycleManager getInstanceSynchronized() {
        LifecycleManager lifecycleManager;
        synchronized (LifecycleManager.class) {
            if (sInstance == null) {
                sInstance = new LifecycleManager();
            }
            lifecycleManager = sInstance;
        }
        return lifecycleManager;
    }

    private LifecycleManager() {
        onHeadlessChange(new OnHeadlessChangeCallback() { // from class: com.transistorsoft.tsbackgroundfetch.LifecycleManager$$ExternalSyntheticLambda0
            @Override // com.transistorsoft.tsbackgroundfetch.LifecycleManager.OnHeadlessChangeCallback
            public final void onChange(boolean z) {
                LifecycleManager.lambda$new$0(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$new$0(boolean z) {
        if (z) {
            Log.d(BackgroundFetch.TAG, "☯️  HeadlessMode? " + z);
        }
    }

    public void pause() {
        this.mPaused.set(true);
    }

    public void resume() {
        this.mPaused.set(false);
    }

    public boolean isBackground() {
        return this.mIsBackground.get();
    }

    public boolean isHeadless() {
        return this.mIsHeadless.get();
    }

    public void setHeadless(boolean z) {
        this.mIsHeadless.set(z);
        if (this.mIsHeadless.get()) {
            Log.d(BackgroundFetch.TAG, "☯️  HeadlessMode? " + this.mIsHeadless);
        }
        Runnable runnable = this.mHeadlessChangeEvent;
        if (runnable != null) {
            this.mHandler.removeCallbacks(runnable);
            this.mStarted.set(true);
            fireHeadlessChangeListeners();
        }
    }

    public void onHeadlessChange(OnHeadlessChangeCallback onHeadlessChangeCallback) {
        if (this.mStarted.get()) {
            onHeadlessChangeCallback.onChange(this.mIsHeadless.get());
            return;
        }
        synchronized (this.mHeadlessChangeCallbacks) {
            this.mHeadlessChangeCallbacks.add(onHeadlessChangeCallback);
        }
    }

    public void onStateChange(OnStateChangeCallback onStateChangeCallback) {
        synchronized (this.mStateChangeCallbacks) {
            this.mStateChangeCallbacks.add(onStateChangeCallback);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        ProcessLifecycleOwner.get().getLifecycle().addObserver(this);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onCreate(@NonNull LifecycleOwner lifecycleOwner) {
        Log.d(BackgroundFetch.TAG, "☯️  onCreate");
        Runnable runnable = new Runnable() { // from class: com.transistorsoft.tsbackgroundfetch.LifecycleManager.1
            @Override // java.lang.Runnable
            public void run() {
                LifecycleManager.this.mStarted.set(true);
                LifecycleManager.this.fireHeadlessChangeListeners();
            }
        };
        this.mHeadlessChangeEvent = runnable;
        this.mHandler.postDelayed(runnable, 50L);
        this.mIsHeadless.set(true);
        this.mIsBackground.set(true);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onStart(@NonNull LifecycleOwner lifecycleOwner) {
        Log.d(BackgroundFetch.TAG, "☯️  onStart");
        if (this.mPaused.get()) {
            return;
        }
        Runnable runnable = this.mHeadlessChangeEvent;
        if (runnable != null) {
            this.mHandler.removeCallbacks(runnable);
        }
        this.mStarted.set(true);
        this.mIsHeadless.set(false);
        this.mIsBackground.set(false);
        fireHeadlessChangeListeners();
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onDestroy(@NonNull LifecycleOwner lifecycleOwner) {
        Log.d(BackgroundFetch.TAG, "☯️  onDestroy");
        this.mIsBackground.set(true);
        this.mIsHeadless.set(true);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onStop(@NonNull LifecycleOwner lifecycleOwner) {
        Log.d(BackgroundFetch.TAG, "☯️  onStop");
        if (this.mPaused.compareAndSet(true, false)) {
            return;
        }
        this.mIsBackground.set(true);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onPause(@NonNull LifecycleOwner lifecycleOwner) {
        Log.d(BackgroundFetch.TAG, "☯️  onPause");
        this.mIsBackground.set(true);
        fireStateChangeListeners(false);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onResume(@NonNull LifecycleOwner lifecycleOwner) {
        Log.d(BackgroundFetch.TAG, "☯️  onResume");
        if (this.mPaused.get()) {
            return;
        }
        this.mIsBackground.set(false);
        this.mIsHeadless.set(false);
        fireStateChangeListeners(true);
    }

    private void fireStateChangeListeners(boolean z) {
        synchronized (this.mStateChangeCallbacks) {
            Iterator<OnStateChangeCallback> it2 = this.mStateChangeCallbacks.iterator();
            while (it2.hasNext()) {
                it2.next().onChange(z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fireHeadlessChangeListeners() {
        Runnable runnable = this.mHeadlessChangeEvent;
        if (runnable != null) {
            this.mHandler.removeCallbacks(runnable);
            this.mHeadlessChangeEvent = null;
        }
        synchronized (this.mHeadlessChangeCallbacks) {
            Iterator<OnHeadlessChangeCallback> it2 = this.mHeadlessChangeCallbacks.iterator();
            while (it2.hasNext()) {
                it2.next().onChange(this.mIsHeadless.get());
            }
            this.mHeadlessChangeCallbacks.clear();
        }
    }
}
