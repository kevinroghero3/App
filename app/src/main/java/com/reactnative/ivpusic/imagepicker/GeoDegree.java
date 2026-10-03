package com.reactnative.ivpusic.imagepicker;

import android.media.ExifInterface;
import com.google.firebase.sessions.settings.RemoteSettings;

/* JADX INFO: loaded from: classes3.dex */
public class GeoDegree {
    Float latitude;
    Float longitude;

    public GeoDegree(ExifInterface exifInterface) {
        String attribute = exifInterface.getAttribute(androidx.exifinterface.media.ExifInterface.TAG_GPS_LATITUDE);
        String attribute2 = exifInterface.getAttribute(androidx.exifinterface.media.ExifInterface.TAG_GPS_LATITUDE_REF);
        String attribute3 = exifInterface.getAttribute(androidx.exifinterface.media.ExifInterface.TAG_GPS_LONGITUDE);
        String attribute4 = exifInterface.getAttribute(androidx.exifinterface.media.ExifInterface.TAG_GPS_LONGITUDE_REF);
        if (attribute == null || attribute2 == null || attribute3 == null || attribute4 == null) {
            return;
        }
        if (attribute2.equals("N")) {
            this.latitude = convertToDegree(attribute);
        } else {
            this.latitude = Float.valueOf(0.0f - convertToDegree(attribute).floatValue());
        }
        if (attribute4.equals(androidx.exifinterface.media.ExifInterface.LONGITUDE_EAST)) {
            this.longitude = convertToDegree(attribute3);
        } else {
            this.longitude = Float.valueOf(0.0f - convertToDegree(attribute3).floatValue());
        }
    }

    private Float convertToDegree(String str) {
        String[] strArrSplit = str.split(",", 3);
        String[] strArrSplit2 = strArrSplit[0].split(RemoteSettings.FORWARD_SLASH_STRING, 2);
        double dDoubleValue = Double.valueOf(strArrSplit2[0]).doubleValue() / Double.valueOf(strArrSplit2[1]).doubleValue();
        String[] strArrSplit3 = strArrSplit[1].split(RemoteSettings.FORWARD_SLASH_STRING, 2);
        double dDoubleValue2 = Double.valueOf(strArrSplit3[0]).doubleValue() / Double.valueOf(strArrSplit3[1]).doubleValue();
        String[] strArrSplit4 = strArrSplit[2].split(RemoteSettings.FORWARD_SLASH_STRING, 2);
        return Float.valueOf((float) (dDoubleValue + (dDoubleValue2 / 60.0d) + ((Double.valueOf(strArrSplit4[0]).doubleValue() / Double.valueOf(strArrSplit4[1]).doubleValue()) / 3600.0d)));
    }

    public Float getLatitude() {
        return this.latitude;
    }

    public Float getLongitude() {
        return this.longitude;
    }
}
