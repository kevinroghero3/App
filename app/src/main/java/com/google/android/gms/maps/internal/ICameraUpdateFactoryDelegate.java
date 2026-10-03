package com.google.android.gms.maps.internal;

import android.os.IInterface;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

/* JADX INFO: loaded from: classes2.dex */
public interface ICameraUpdateFactoryDelegate extends IInterface {
    IObjectWrapper newCameraPosition(@NonNull CameraPosition cameraPosition) throws RemoteException;

    IObjectWrapper newLatLng(@NonNull LatLng latLng) throws RemoteException;

    IObjectWrapper newLatLngBounds(@NonNull LatLngBounds latLngBounds, int i) throws RemoteException;

    IObjectWrapper newLatLngBoundsWithSize(@NonNull LatLngBounds latLngBounds, int i, int i2, int i3) throws RemoteException;

    IObjectWrapper newLatLngZoom(@NonNull LatLng latLng, float f) throws RemoteException;

    IObjectWrapper scrollBy(float f, float f2) throws RemoteException;

    IObjectWrapper zoomBy(float f) throws RemoteException;

    IObjectWrapper zoomByWithFocus(float f, int i, int i2) throws RemoteException;

    IObjectWrapper zoomIn() throws RemoteException;

    IObjectWrapper zoomOut() throws RemoteException;

    IObjectWrapper zoomTo(float f) throws RemoteException;
}
