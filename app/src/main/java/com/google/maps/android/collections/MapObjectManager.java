package com.google.maps.android.collections;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.gms.maps.GoogleMap;
import com.google.maps.android.collections.MapObjectManager.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes3.dex */
public abstract class MapObjectManager<O, C extends Collection> {
    protected final GoogleMap mMap;
    private final Map<String, C> mNamedCollections = new HashMap();
    protected final Map<O, C> mAllObjects = new HashMap();

    public abstract C newCollection();

    protected abstract void removeObjectFromMap(O o2);

    abstract void setListenersOnUiThread();

    public MapObjectManager(@NonNull GoogleMap googleMap) {
        this.mMap = googleMap;
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.google.maps.android.collections.MapObjectManager.1
            @Override // java.lang.Runnable
            public void run() {
                MapObjectManager.this.setListenersOnUiThread();
            }
        });
    }

    public C newCollection(String str) {
        if (this.mNamedCollections.get(str) != null) {
            throw new IllegalArgumentException("collection id is not unique: " + str);
        }
        C c = (C) newCollection();
        this.mNamedCollections.put(str, c);
        return c;
    }

    public C getCollection(String str) {
        return this.mNamedCollections.get(str);
    }

    public boolean remove(O o2) {
        C c = this.mAllObjects.get(o2);
        return c != null && c.remove(o2);
    }

    public class Collection {
        private final Set<O> mObjects = new LinkedHashSet();

        public Collection() {
        }

        protected void add(O o2) {
            this.mObjects.add(o2);
            MapObjectManager.this.mAllObjects.put(o2, this);
        }

        protected boolean remove(O o2) {
            if (!this.mObjects.remove(o2)) {
                return false;
            }
            MapObjectManager.this.mAllObjects.remove(o2);
            MapObjectManager.this.removeObjectFromMap(o2);
            return true;
        }

        public void clear() {
            for (O o2 : this.mObjects) {
                MapObjectManager.this.removeObjectFromMap(o2);
                MapObjectManager.this.mAllObjects.remove(o2);
            }
            this.mObjects.clear();
        }

        protected java.util.Collection<O> getObjects() {
            return Collections.unmodifiableCollection(this.mObjects);
        }
    }
}
