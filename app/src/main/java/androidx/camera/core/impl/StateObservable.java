package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public abstract class StateObservable<T> implements Observable<T> {
    private static final int INITIAL_VERSION = 0;
    private final AtomicReference<Object> mState;
    private final Object mLock = new Object();
    private int mVersion = 0;
    private boolean mUpdating = false;
    private final Map<Observable.Observer<? super T>, ObserverWrapper<T>> mWrapperMap = new HashMap();
    private final CopyOnWriteArraySet<ObserverWrapper<T>> mNotifySet = new CopyOnWriteArraySet<>();

    StateObservable(@Nullable Object obj, boolean z) {
        if (z) {
            Preconditions.checkArgument(obj instanceof Throwable, "Initial errors must be Throwable");
            this.mState = new AtomicReference<>(ErrorWrapper.wrap((Throwable) obj));
        } else {
            this.mState = new AtomicReference<>(obj);
        }
    }

    void updateState(@Nullable T t) {
        updateStateInternal(t);
    }

    void updateStateAsError(@NonNull Throwable th) {
        updateStateInternal(ErrorWrapper.wrap(th));
    }

    private void updateStateInternal(@Nullable Object obj) {
        Iterator<ObserverWrapper<T>> it2;
        int i;
        synchronized (this.mLock) {
            if (Objects.equals(this.mState.getAndSet(obj), obj)) {
                return;
            }
            int i2 = this.mVersion + 1;
            this.mVersion = i2;
            if (this.mUpdating) {
                return;
            }
            this.mUpdating = true;
            Iterator<ObserverWrapper<T>> it3 = this.mNotifySet.iterator();
            while (true) {
                if (it3.hasNext()) {
                    it3.next().update(i2);
                } else {
                    synchronized (this.mLock) {
                        if (this.mVersion == i2) {
                            this.mUpdating = false;
                            return;
                        } else {
                            it2 = this.mNotifySet.iterator();
                            i = this.mVersion;
                        }
                    }
                    it3 = it2;
                    i2 = i;
                }
            }
        }
    }

    @Override // androidx.camera.core.impl.Observable
    public ListenableFuture<T> fetchData() {
        Object obj = this.mState.get();
        if (obj instanceof ErrorWrapper) {
            return Futures.immediateFailedFuture(((ErrorWrapper) obj).getError());
        }
        return Futures.immediateFuture(obj);
    }

    @Override // androidx.camera.core.impl.Observable
    public void addObserver(@NonNull Executor executor, @NonNull Observable.Observer<? super T> observer) {
        ObserverWrapper<T> observerWrapper;
        synchronized (this.mLock) {
            removeObserverLocked(observer);
            observerWrapper = new ObserverWrapper<>(this.mState, executor, observer);
            this.mWrapperMap.put(observer, observerWrapper);
            this.mNotifySet.add(observerWrapper);
        }
        observerWrapper.update(0);
    }

    @Override // androidx.camera.core.impl.Observable
    public void removeObserver(@NonNull Observable.Observer<? super T> observer) {
        synchronized (this.mLock) {
            removeObserverLocked(observer);
        }
    }

    public void removeObservers() {
        synchronized (this.mLock) {
            Iterator it2 = new HashSet(this.mWrapperMap.keySet()).iterator();
            while (it2.hasNext()) {
                removeObserverLocked((Observable.Observer) it2.next());
            }
        }
    }

    private void removeObserverLocked(@NonNull Observable.Observer<? super T> observer) {
        ObserverWrapper<T> observerWrapperRemove = this.mWrapperMap.remove(observer);
        if (observerWrapperRemove != null) {
            observerWrapperRemove.close();
            this.mNotifySet.remove(observerWrapperRemove);
        }
    }

    static final class ObserverWrapper<T> implements Runnable {
        private static final Object NOT_SET = new Object();
        private static final int NO_VERSION = -1;
        private final Executor mExecutor;
        private final Observable.Observer<? super T> mObserver;
        private final AtomicReference<Object> mStateRef;
        private final AtomicBoolean mActive = new AtomicBoolean(true);
        private Object mLastState = NOT_SET;
        private int mLatestSignalledVersion = -1;
        private boolean mWrapperUpdating = false;

        ObserverWrapper(@NonNull AtomicReference<Object> atomicReference, @NonNull Executor executor, @NonNull Observable.Observer<? super T> observer) {
            this.mStateRef = atomicReference;
            this.mExecutor = executor;
            this.mObserver = observer;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this) {
                if (!this.mActive.get()) {
                    this.mWrapperUpdating = false;
                    return;
                }
                Object obj = this.mStateRef.get();
                int i = this.mLatestSignalledVersion;
                while (true) {
                    if (!Objects.equals(this.mLastState, obj)) {
                        this.mLastState = obj;
                        if (obj instanceof ErrorWrapper) {
                            this.mObserver.onError(((ErrorWrapper) obj).getError());
                        } else {
                            this.mObserver.onNewData(obj);
                        }
                    }
                    synchronized (this) {
                        if (i == this.mLatestSignalledVersion || !this.mActive.get()) {
                            break;
                            break;
                        } else {
                            obj = this.mStateRef.get();
                            i = this.mLatestSignalledVersion;
                        }
                    }
                }
                this.mWrapperUpdating = false;
            }
        }

        void update(int i) {
            synchronized (this) {
                if (this.mActive.get()) {
                    if (i <= this.mLatestSignalledVersion) {
                        return;
                    }
                    this.mLatestSignalledVersion = i;
                    if (this.mWrapperUpdating) {
                        return;
                    }
                    this.mWrapperUpdating = true;
                    try {
                        this.mExecutor.execute(this);
                    } catch (Throwable unused) {
                        synchronized (this) {
                            this.mWrapperUpdating = false;
                        }
                    }
                }
            }
        }

        void close() {
            this.mActive.set(false);
        }
    }

    static abstract class ErrorWrapper {
        public abstract Throwable getError();

        ErrorWrapper() {
        }

        static ErrorWrapper wrap(@NonNull Throwable th) {
            return new AutoValue_StateObservable_ErrorWrapper(th);
        }
    }
}
