package it.aep_italia.vts.sdk.utils.ciphers;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class StorageCipherFactory {
    private static final a e = a.RSA_ECB_PKCS1Padding;
    private static final d f = d.AES_CBC_PKCS7Padding;
    private final a a;
    private final d b;
    private final a c;
    private final d d;

    public StorageCipherFactory(SharedPreferences sharedPreferences, Map<String, Object> map) {
        a aVar = e;
        this.a = a.valueOf(sharedPreferences.getString("VtsSecureSAlgorithmKey", aVar.name()));
        d dVar = f;
        this.b = d.valueOf(sharedPreferences.getString("VtsSecureSAlgorithmStorage", dVar.name()));
        a aVarValueOf = a.valueOf(a(map, "keyCipherAlgorithm", aVar.name()));
        int i = aVarValueOf.b;
        int i2 = Build.VERSION.SDK_INT;
        this.c = i <= i2 ? aVarValueOf : aVar;
        d dVarValueOf = d.valueOf(a(map, "storageCipherAlgorithm", dVar.name()));
        this.d = dVarValueOf.b <= i2 ? dVarValueOf : dVar;
    }

    private String a(Map<String, Object> map, String str, String str2) {
        Object obj = map.get(str);
        return obj != null ? obj.toString() : str2;
    }

    public StorageCipher getCurrentStorageCipher(Context context) throws Exception {
        return this.d.a.a(context, this.c.a.a(context));
    }

    public StorageCipher getSavedStorageCipher(Context context) throws Exception {
        return this.b.a.a(context, this.a.a.a(context));
    }

    public void removeCurrentAlgorithms(SharedPreferences.Editor editor) {
        editor.remove("VtsSecureSAlgorithmKey");
        editor.remove("VtsSecureSAlgorithmStorage");
    }

    public boolean requiresReEncryption() {
        return (this.a == this.c && this.b == this.d) ? false : true;
    }

    public void storeCurrentAlgorithms(SharedPreferences.Editor editor) {
        editor.putString("VtsSecureSAlgorithmKey", this.c.name());
        editor.putString("VtsSecureSAlgorithmStorage", this.d.name());
    }
}
