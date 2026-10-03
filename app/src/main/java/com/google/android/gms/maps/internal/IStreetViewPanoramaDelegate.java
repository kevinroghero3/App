package com.google.android.gms.maps.internal;

import android.os.IInterface;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.maps.model.StreetViewPanoramaLocation;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;
import com.google.android.gms.maps.model.StreetViewSource;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public interface IStreetViewPanoramaDelegate extends IInterface {
    void animateTo(@NonNull StreetViewPanoramaCamera streetViewPanoramaCamera, long j) throws RemoteException;

    void enablePanning(boolean z) throws RemoteException;

    void enableStreetNames(boolean z) throws RemoteException;

    void enableUserNavigation(boolean z) throws RemoteException;

    void enableZoom(boolean z) throws RemoteException;

    StreetViewPanoramaCamera getPanoramaCamera() throws RemoteException;

    StreetViewPanoramaLocation getStreetViewPanoramaLocation() throws RemoteException;

    boolean isPanningGesturesEnabled() throws RemoteException;

    boolean isStreetNamesEnabled() throws RemoteException;

    boolean isUserNavigationEnabled() throws RemoteException;

    boolean isZoomGesturesEnabled() throws RemoteException;

    IObjectWrapper orientationToPoint(@NonNull StreetViewPanoramaOrientation streetViewPanoramaOrientation) throws RemoteException;

    StreetViewPanoramaOrientation pointToOrientation(@NonNull IObjectWrapper iObjectWrapper) throws RemoteException;

    void setOnStreetViewPanoramaCameraChangeListener(@Nullable zzbl zzblVar) throws RemoteException;

    void setOnStreetViewPanoramaChangeListener(@Nullable zzbn zzbnVar) throws RemoteException;

    void setOnStreetViewPanoramaClickListener(@Nullable zzbp zzbpVar) throws RemoteException;

    void setOnStreetViewPanoramaLongClickListener(@Nullable zzbr zzbrVar) throws RemoteException;

    void setPosition(@NonNull LatLng latLng) throws RemoteException;

    void setPositionWithID(@NonNull String str) throws RemoteException;

    void setPositionWithRadius(@NonNull LatLng latLng, int i) throws RemoteException;

    void setPositionWithRadiusAndSource(@NonNull LatLng latLng, int i, @Nullable StreetViewSource streetViewSource) throws RemoteException;

    void setPositionWithSource(@NonNull LatLng latLng, @Nullable StreetViewSource streetViewSource) throws RemoteException;
}
