package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import android.util.Base64;
import androidx.annotation.NonNull;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.gms.common.R;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes4.dex */
public class StringResourceValueReader {
    private static int artificialFrame = 1;
    private static byte extraCallback = -124;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME;
    private final Resources zza;
    private final String zzb;

    public StringResourceValueReader(@NonNull Context context) {
        Preconditions.checkNotNull(context);
        Resources resources = context.getResources();
        this.zza = resources;
        this.zzb = resources.getResourcePackageName(R.string.common_google_play_services_unknown_issue);
    }

    public String getString(@NonNull String str) {
        int i = 2 % 2;
        int identifier = this.zza.getIdentifier(str, TypedValues.Custom.S_STRING, this.zzb);
        if (identifier == 0) {
            int i2 = artificialFrame + 115;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i2 % 128;
            int i3 = i2 % 2;
            return null;
        }
        String string = this.zza.getString(identifier);
        if (!(!string.startsWith(".,.%"))) {
            int i4 = artificialFrame + 97;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i4 % 128;
            int i5 = i4 % 2;
            Object[] objArr = new Object[1];
            a(string.substring(4), objArr);
            string = ((String) objArr[0]).intern();
            int i6 = getARTIFICIAL_FRAME_PACKAGE_NAME + 81;
            artificialFrame = i6 % 128;
            if (i6 % 2 == 0) {
                int i7 = 5 % 5;
            }
        }
        return string;
    }

    private void a(String str, Object[] objArr) {
        byte[] bArrDecode = Base64.decode(str, 0);
        byte[] bArr = new byte[bArrDecode.length];
        for (int i = 0; i < bArrDecode.length; i++) {
            bArr[i] = (byte) (bArrDecode[(bArrDecode.length - i) - 1] ^ extraCallback);
        }
        objArr[0] = new String(bArr, StandardCharsets.UTF_8);
    }
}
