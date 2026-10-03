package com.reactnativecommunity.cameraroll;

import android.webkit.MimeTypeMap;

/* JADX INFO: loaded from: classes6.dex */
public class Utils {
    public static String getMimeType(String str) {
        int iLastIndexOf = str.lastIndexOf(46);
        String strSubstring = iLastIndexOf >= 0 ? str.substring(iLastIndexOf + 1) : null;
        if (strSubstring != null) {
            return MimeTypeMap.getSingleton().getMimeTypeFromExtension(strSubstring);
        }
        return null;
    }

    public static String getExtension(String str) {
        return MimeTypeMap.getSingleton().getExtensionFromMimeType(str);
    }
}
