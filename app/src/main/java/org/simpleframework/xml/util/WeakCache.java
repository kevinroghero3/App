package org.simpleframework.xml.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes6.dex */
public class WeakCache<T> implements Cache<T> {
    private WeakCache<T>.SegmentList list;

    public WeakCache() {
        this(10);
    }

    public WeakCache(int i) {
        this.list = new SegmentList(i);
    }

    @Override // org.simpleframework.xml.util.Cache
    public boolean isEmpty() {
        Iterator<WeakCache<T>.Segment> it2 = this.list.iterator();
        while (it2.hasNext()) {
            if (!it2.next().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override // org.simpleframework.xml.util.Cache
    public void cache(Object obj, T t) {
        map(obj).cache(obj, t);
    }

    @Override // org.simpleframework.xml.util.Cache
    public T take(Object obj) {
        return map(obj).take(obj);
    }

    @Override // org.simpleframework.xml.util.Cache
    public T fetch(Object obj) {
        return map(obj).fetch(obj);
    }

    @Override // org.simpleframework.xml.util.Cache
    public boolean contains(Object obj) {
        return map(obj).contains(obj);
    }

    private WeakCache<T>.Segment map(Object obj) {
        return this.list.get(obj);
    }

    class SegmentList implements Iterable<WeakCache<T>.Segment> {
        private List<WeakCache<T>.Segment> list = new ArrayList();
        private int size;

        public SegmentList(int i) {
            this.size = i;
            create(i);
        }

        @Override // java.lang.Iterable
        public Iterator<WeakCache<T>.Segment> iterator() {
            return this.list.iterator();
        }

        public WeakCache<T>.Segment get(Object obj) {
            int iSegment = segment(obj);
            if (iSegment < this.size) {
                return this.list.get(iSegment);
            }
            return null;
        }

        private void create(int i) {
            while (i > 0) {
                this.list.add(new Segment());
                i--;
            }
        }

        private int segment(Object obj) {
            return Math.abs(obj.hashCode() % this.size);
        }
    }

    class Segment extends WeakHashMap<Object, T> {
        private Segment() {
        }

        public void cache(Object obj, T t) {
            synchronized (this) {
                put(obj, t);
            }
        }

        public T fetch(Object obj) {
            T t;
            synchronized (this) {
                t = get(obj);
            }
            return t;
        }

        public T take(Object obj) {
            T tRemove;
            synchronized (this) {
                tRemove = remove(obj);
            }
            return tRemove;
        }

        public boolean contains(Object obj) {
            boolean zContainsKey;
            synchronized (this) {
                zContainsKey = containsKey(obj);
            }
            return zContainsKey;
        }
    }
}
