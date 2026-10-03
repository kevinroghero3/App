package it.aep_italia.vts.sdk.core;

import android.content.Context;
import android.content.SharedPreferences;
import android.security.keystore.KeyGenParameterSpec;
import android.util.Base64;
import androidx.security.crypto.EncryptedSharedPreferences;
import androidx.security.crypto.MasterKey;
import com.google.android.gms.stats.CodePackage;
import it.aep_italia.vts.sdk.utils.ciphers.StorageCipher;
import it.aep_italia.vts.sdk.utils.ciphers.StorageCipherFactory;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class VtsSecureStorage {
    private final Context c;
    private SharedPreferences e;
    private StorageCipher f;
    private StorageCipherFactory g;
    public Map<String, Object> options;
    private final String a = "VtsSecureStorageAndroid";
    protected String ELEMENT_PREFERENCES_KEY_PREFIX = "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIHNlY3VyZSBzdG9yYWdlCg";
    private String d = "VtsSecureStorage";
    private final Charset b = StandardCharsets.UTF_8;

    public VtsSecureStorage(Context context) {
        this.c = context.getApplicationContext();
    }

    private SharedPreferences a(Context context) throws GeneralSecurityException, IOException {
        return EncryptedSharedPreferences.create(context, this.d, new MasterKey.Builder(context).setKeyGenParameterSpec(new KeyGenParameterSpec.Builder(MasterKey.DEFAULT_MASTER_KEY_ALIAS, 3).setEncryptionPaddings("NoPadding").setBlockModes(CodePackage.GCM).setKeySize(256).build()).build(), EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV, EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM);
    }

    private String a(String str) throws Exception {
        if (str.isEmpty()) {
            return "";
        }
        return new String(this.f.decrypt(Base64.decode(str, 0)), this.b);
    }

    private void a() {
        if (this.options.containsKey("sharedPreferencesName") && !((String) this.options.get("sharedPreferencesName")).isEmpty()) {
            this.d = (String) this.options.get("sharedPreferencesName");
        }
        if (this.options.containsKey("preferencesKeyPrefix") && !((String) this.options.get("preferencesKeyPrefix")).isEmpty()) {
            this.ELEMENT_PREFERENCES_KEY_PREFIX = (String) this.options.get("preferencesKeyPrefix");
        }
        SharedPreferences sharedPreferences = this.c.getSharedPreferences(this.d, 0);
        if (this.f == null) {
            try {
                a(sharedPreferences);
            } catch (Exception e) {
                VtsLog.e("VtsSecureStorageAndroid", "StorageCipher initialization failed", e);
            }
        }
        if (!b()) {
            this.e = sharedPreferences;
            return;
        }
        try {
            this.e = a(this.c);
        } catch (Exception e2) {
            VtsLog.e("VtsSecureStorageAndroid", "EncryptedSharedPreferences initialization failed", e2);
        }
        a(sharedPreferences, this.e);
    }

    private void a(SharedPreferences sharedPreferences) throws Exception {
        StorageCipher currentStorageCipher;
        this.g = new StorageCipherFactory(sharedPreferences, this.options);
        if (b()) {
            currentStorageCipher = this.g.getSavedStorageCipher(this.c);
        } else {
            if (this.g.requiresReEncryption()) {
                a(this.g, sharedPreferences);
                return;
            }
            currentStorageCipher = this.g.getCurrentStorageCipher(this.c);
        }
        this.f = currentStorageCipher;
    }

    private void a(SharedPreferences sharedPreferences, SharedPreferences sharedPreferences2) {
        try {
            for (Map.Entry<String, ?> entry : sharedPreferences.getAll().entrySet()) {
                Object value = entry.getValue();
                String key = entry.getKey();
                if ((value instanceof String) && key.contains(this.ELEMENT_PREFERENCES_KEY_PREFIX)) {
                    sharedPreferences2.edit().putString(key, a((String) value)).apply();
                    sharedPreferences.edit().remove(key).apply();
                }
            }
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            this.g.removeCurrentAlgorithms(editorEdit);
            editorEdit.apply();
        } catch (Exception e) {
            VtsLog.e("VtsSecureStorageAndroid", "Data migration failed", e);
        }
    }

    private void a(StorageCipherFactory storageCipherFactory, SharedPreferences sharedPreferences) throws Exception {
        try {
            this.f = storageCipherFactory.getSavedStorageCipher(this.c);
            HashMap map = new HashMap();
            for (Map.Entry<String, ?> entry : sharedPreferences.getAll().entrySet()) {
                Object value = entry.getValue();
                String key = entry.getKey();
                if ((value instanceof String) && key.contains(this.ELEMENT_PREFERENCES_KEY_PREFIX)) {
                    map.put(key, a((String) value));
                }
            }
            this.f = storageCipherFactory.getCurrentStorageCipher(this.c);
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            for (Map.Entry entry2 : map.entrySet()) {
                editorEdit.putString((String) entry2.getKey(), Base64.encodeToString(this.f.encrypt(((String) entry2.getValue()).getBytes(this.b)), 0));
            }
            storageCipherFactory.storeCurrentAlgorithms(editorEdit);
            editorEdit.apply();
        } catch (Exception e) {
            VtsLog.e("VtsSecureStorageAndroid", "re-encryption failed", e);
            this.f = storageCipherFactory.getSavedStorageCipher(this.c);
        }
    }

    private boolean b() {
        return this.options.containsKey("encryptedSharedPreferences") && this.options.get("encryptedSharedPreferences").equals("true");
    }

    public boolean containsKey(String str) {
        a();
        return this.e.contains(str);
    }

    public void delete(String str) {
        a();
        SharedPreferences.Editor editorEdit = this.e.edit();
        editorEdit.remove(str);
        editorEdit.apply();
    }

    public String read(String str) throws Exception {
        a();
        String string = this.e.getString(str, "");
        return b() ? string : a(string);
    }

    public Map<String, String> readAll() throws Exception {
        a();
        Map<String, ?> all = this.e.getAll();
        HashMap map = new HashMap();
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            if (entry.getKey().contains(this.ELEMENT_PREFERENCES_KEY_PREFIX)) {
                String strReplaceFirst = entry.getKey().replaceFirst(this.ELEMENT_PREFERENCES_KEY_PREFIX + '_', "");
                boolean zB = b();
                String strA = (String) entry.getValue();
                if (!zB) {
                    strA = a(strA);
                }
                map.put(strReplaceFirst, strA);
            }
        }
        return map;
    }

    public void write(String str, String str2) throws Exception {
        a();
        SharedPreferences.Editor editorEdit = this.e.edit();
        if (!b()) {
            str2 = Base64.encodeToString(this.f.encrypt(str2.getBytes(this.b)), 0);
        }
        editorEdit.putString(str, str2);
        editorEdit.apply();
    }
}
