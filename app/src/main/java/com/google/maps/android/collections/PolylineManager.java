package com.google.maps.android.collections;

import androidx.annotation.NonNull;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class PolylineManager extends MapObjectManager<Polyline, Collection> implements GoogleMap.OnPolylineClickListener {
    @Override // com.google.maps.android.collections.MapObjectManager
    public /* bridge */ /* synthetic */ MapObjectManager.Collection getCollection(String str) {
        return super.getCollection(str);
    }

    @Override // com.google.maps.android.collections.MapObjectManager
    public /* bridge */ /* synthetic */ MapObjectManager.Collection newCollection(String str) {
        return super.newCollection(str);
    }

    @Override // com.google.maps.android.collections.MapObjectManager
    public /* bridge */ /* synthetic */ boolean remove(Polyline polyline) {
        return super.remove(polyline);
    }

    public PolylineManager(@NonNull GoogleMap googleMap) {
        super(googleMap);
    }

    @Override // com.google.maps.android.collections.MapObjectManager
    void setListenersOnUiThread() {
        GoogleMap googleMap = this.mMap;
        if (googleMap != null) {
            googleMap.setOnPolylineClickListener(this);
        }
    }

    @Override // com.google.maps.android.collections.MapObjectManager
    public Collection newCollection() {
        return new Collection();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.maps.android.collections.MapObjectManager
    public void removeObjectFromMap(Polyline polyline) {
        polyline.remove();
    }

    @Override // com.google.android.gms.maps.GoogleMap.OnPolylineClickListener
    public void onPolylineClick(@NonNull Polyline polyline) {
        Collection collection = (Collection) this.mAllObjects.get(polyline);
        if (collection == null || collection.mPolylineClickListener == null) {
            return;
        }
        collection.mPolylineClickListener.onPolylineClick(polyline);
    }

    public class Collection extends MapObjectManager.Collection {
        private GoogleMap.OnPolylineClickListener mPolylineClickListener;

        public Collection() {
            super();
        }

        public Polyline addPolyline(PolylineOptions polylineOptions) {
            Polyline polylineAddPolyline = PolylineManager.this.mMap.addPolyline(polylineOptions);
            super.add(polylineAddPolyline);
            return polylineAddPolyline;
        }

        public void addAll(java.util.Collection<PolylineOptions> collection) {
            Iterator<PolylineOptions> it2 = collection.iterator();
            while (it2.hasNext()) {
                addPolyline(it2.next());
            }
        }

        public void addAll(java.util.Collection<PolylineOptions> collection, boolean z) {
            Iterator<PolylineOptions> it2 = collection.iterator();
            while (it2.hasNext()) {
                addPolyline(it2.next()).setVisible(z);
            }
        }

        public void showAll() {
            Iterator<Polyline> it2 = getPolylines().iterator();
            while (it2.hasNext()) {
                it2.next().setVisible(true);
            }
        }

        public void hideAll() {
            Iterator<Polyline> it2 = getPolylines().iterator();
            while (it2.hasNext()) {
                it2.next().setVisible(false);
            }
        }

        public boolean remove(Polyline polyline) {
            return super.remove(polyline);
        }

        public java.util.Collection<Polyline> getPolylines() {
            return getObjects();
        }

        public void setOnPolylineClickListener(GoogleMap.OnPolylineClickListener onPolylineClickListener) {
            this.mPolylineClickListener = onPolylineClickListener;
        }
    }
}
