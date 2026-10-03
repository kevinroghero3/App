package com.facebook.common.references;

import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import java.util.IdentityHashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public class SharedReference<T> {
    private static final Map<Object, Integer> sLiveObjects = new IdentityHashMap();
    private int mRefCount;

    @Nullable
    private final ResourceReleaser<T> mResourceReleaser;

    @Nullable
    private T mValue;

    public SharedReference(T t, @Nullable ResourceReleaser<T> resourceReleaser, boolean z) {
        this.mValue = (T) Preconditions.checkNotNull(t);
        this.mResourceReleaser = resourceReleaser;
        this.mRefCount = 1;
        if (z) {
            addLiveReference(t);
        }
    }

    public SharedReference(T t, ResourceReleaser<T> resourceReleaser) {
        this(t, resourceReleaser, false);
    }

    private static void addLiveReference(Object obj) {
        Map<Object, Integer> map = sLiveObjects;
        synchronized (map) {
            Integer num = map.get(obj);
            if (num == null) {
                map.put(obj, 1);
            } else {
                map.put(obj, Integer.valueOf(num.intValue() + 1));
            }
        }
    }

    private static void removeLiveReference(Object obj) {
        Map<Object, Integer> map = sLiveObjects;
        synchronized (map) {
            Integer num = map.get(obj);
            if (num == null) {
                FLog.wtf("SharedReference", "No entry in sLiveObjects for value of type %s", obj.getClass());
            } else if (num.intValue() == 1) {
                map.remove(obj);
            } else {
                map.put(obj, Integer.valueOf(num.intValue() - 1));
            }
        }
    }

    @Nullable
    public T get() {
        T t;
        synchronized (this) {
            t = this.mValue;
        }
        return t;
    }

    public boolean isValid() {
        boolean z;
        synchronized (this) {
            z = this.mRefCount > 0;
        }
        return z;
    }

    public static boolean isValid(@Nullable SharedReference<?> sharedReference) {
        return sharedReference != null && sharedReference.isValid();
    }

    public void addReference() {
        synchronized (this) {
            ensureValid();
            this.mRefCount++;
        }
    }

    public boolean addReferenceIfValid() {
        synchronized (this) {
            if (!isValid()) {
                return false;
            }
            addReference();
            return true;
        }
    }

    public boolean deleteReferenceIfValid() {
        synchronized (this) {
            if (!isValid()) {
                return false;
            }
            deleteReference();
            return true;
        }
    }

    public void deleteReference() {
        T t;
        if (decreaseRefCount() == 0) {
            synchronized (this) {
                t = this.mValue;
                this.mValue = null;
            }
            if (t != null) {
                ResourceReleaser<T> resourceReleaser = this.mResourceReleaser;
                if (resourceReleaser != null) {
                    resourceReleaser.release(t);
                }
                removeLiveReference(t);
            }
        }
    }

    private int decreaseRefCount() {
        int i;
        synchronized (this) {
            ensureValid();
            Preconditions.checkArgument(Boolean.valueOf(this.mRefCount > 0));
            i = this.mRefCount - 1;
            this.mRefCount = i;
        }
        return i;
    }

    private void ensureValid() {
        if (!isValid(this)) {
            throw new NullReferenceException();
        }
    }

    public int getRefCountTestOnly() {
        int i;
        synchronized (this) {
            i = this.mRefCount;
        }
        return i;
    }

    public static class NullReferenceException extends RuntimeException {
        public NullReferenceException() {
            super("Null shared reference");
        }
    }

    public static String reportData() {
        return Objects.toStringHelper("SharedReference").add("live_objects_count", sLiveObjects.size()).toString();
    }
}
