package com.google.maps.android.collections;

import androidx.annotation.NonNull;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class CircleManager extends MapObjectManager<Circle, Collection> implements GoogleMap.OnCircleClickListener {
    @Override // com.google.maps.android.collections.MapObjectManager
    public /* bridge */ /* synthetic */ MapObjectManager.Collection getCollection(String str) {
        return super.getCollection(str);
    }

    @Override // com.google.maps.android.collections.MapObjectManager
    public /* bridge */ /* synthetic */ MapObjectManager.Collection newCollection(String str) {
        return super.newCollection(str);
    }

    @Override // com.google.maps.android.collections.MapObjectManager
    public /* bridge */ /* synthetic */ boolean remove(Circle circle) {
        return super.remove(circle);
    }

    public CircleManager(@NonNull GoogleMap googleMap) {
        super(googleMap);
    }

    @Override // com.google.maps.android.collections.MapObjectManager
    void setListenersOnUiThread() {
        GoogleMap googleMap = this.mMap;
        if (googleMap != null) {
            googleMap.setOnCircleClickListener(this);
        }
    }

    @Override // com.google.maps.android.collections.MapObjectManager
    public Collection newCollection() {
        return new Collection();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.maps.android.collections.MapObjectManager
    public void removeObjectFromMap(Circle circle) {
        circle.remove();
    }

    @Override // com.google.android.gms.maps.GoogleMap.OnCircleClickListener
    public void onCircleClick(@NonNull Circle circle) {
        Collection collection = (Collection) this.mAllObjects.get(circle);
        if (collection == null || collection.mCircleClickListener == null) {
            return;
        }
        collection.mCircleClickListener.onCircleClick(circle);
    }

    public class Collection extends MapObjectManager.Collection {
        private GoogleMap.OnCircleClickListener mCircleClickListener;

        public Collection() {
            super();
        }

        public Circle addCircle(CircleOptions circleOptions) {
            Circle circleAddCircle = CircleManager.this.mMap.addCircle(circleOptions);
            super.add(circleAddCircle);
            return circleAddCircle;
        }

        public void addAll(java.util.Collection<CircleOptions> collection) {
            Iterator<CircleOptions> it2 = collection.iterator();
            while (it2.hasNext()) {
                addCircle(it2.next());
            }
        }

        public void addAll(java.util.Collection<CircleOptions> collection, boolean z) {
            Iterator<CircleOptions> it2 = collection.iterator();
            while (it2.hasNext()) {
                addCircle(it2.next()).setVisible(z);
            }
        }

        public void showAll() {
            Iterator<Circle> it2 = getCircles().iterator();
            while (it2.hasNext()) {
                it2.next().setVisible(true);
            }
        }

        public void hideAll() {
            Iterator<Circle> it2 = getCircles().iterator();
            while (it2.hasNext()) {
                it2.next().setVisible(false);
            }
        }

        public boolean remove(Circle circle) {
            return super.remove(circle);
        }

        public java.util.Collection<Circle> getCircles() {
            return getObjects();
        }

        public void setOnCircleClickListener(GoogleMap.OnCircleClickListener onCircleClickListener) {
            this.mCircleClickListener = onCircleClickListener;
        }
    }
}
