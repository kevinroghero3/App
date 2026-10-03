package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.gms.common.R;
import com.google.android.gms.common.internal.Preconditions;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes5.dex */
public final class zzhi {
    private static int artificialFrame = 1;
    private static byte extraCallback = -124;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME;
    private final Resources zza;
    private final String zzb;

    public final String zza(String str) {
        int i = 2 % 2;
        int i2 = artificialFrame + 81;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i2 % 128;
        Object obj = null;
        if (i2 % 2 != 0) {
            this.zza.getIdentifier(str, TypedValues.Custom.S_STRING, this.zzb);
            obj.hashCode();
            throw null;
        }
        int identifier = this.zza.getIdentifier(str, TypedValues.Custom.S_STRING, this.zzb);
        if (identifier == 0) {
            int i3 = getARTIFICIAL_FRAME_PACKAGE_NAME + 105;
            artificialFrame = i3 % 128;
            if (i3 % 2 != 0) {
                return null;
            }
            obj.hashCode();
            throw null;
        }
        try {
            String string = this.zza.getString(identifier);
            if (!string.startsWith(".,.%")) {
                return string;
            }
            Object[] objArr = new Object[1];
            a(string.substring(4), objArr);
            return ((String) objArr[0]).intern();
        } catch (Resources.NotFoundException unused) {
            return null;
        }
    }

    public static String zza(Context context) {
        try {
            return context.getResources().getResourcePackageName(R.string.common_google_play_services_unknown_issue);
        } catch (Resources.NotFoundException unused) {
            return context.getPackageName();
        }
    }

    public zzhi(Context context, @Nullable String str) {
        Preconditions.checkNotNull(context);
        this.zza = context.getResources();
        if (!TextUtils.isEmpty(str)) {
            this.zzb = str;
        } else {
            this.zzb = zza(context);
        }
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
