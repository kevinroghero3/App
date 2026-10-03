package com.google.android.gms.maps.internal;

import android.os.IInterface;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.VisibleRegion;

/* JADX INFO: loaded from: classes2.dex */
public interface IProjectionDelegate extends IInterface {
    LatLng fromScreenLocation(@NonNull IObjectWrapper iObjectWrapper) throws RemoteException;

    VisibleRegion getVisibleRegion() throws RemoteException;

    IObjectWrapper toScreenLocation(@NonNull LatLng latLng) throws RemoteException;

    IObjectWrapper toScreenLocationWithAltitude(@NonNull LatLng latLng, float f) throws RemoteException;
}
