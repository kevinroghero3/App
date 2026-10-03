package com.emeraldsanto.encryptedstorage;

import android.content.SharedPreferences;
import androidx.security.crypto.EncryptedSharedPreferences;
import androidx.security.crypto.MasterKey;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import io.sentry.android.core.SentryLogcatAdapter;

/* JADX INFO: loaded from: classes2.dex */
public class RNEncryptedStorageModule extends ReactContextBaseJavaModule {
    private static final String NATIVE_MODULE_NAME = "RNEncryptedStorage";
    private static final String SHARED_PREFERENCES_FILENAME = "RN_ENCRYPTED_STORAGE_SHARED_PREF";
    private SharedPreferences sharedPreferences;

    public RNEncryptedStorageModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        try {
            this.sharedPreferences = EncryptedSharedPreferences.create(reactApplicationContext, SHARED_PREFERENCES_FILENAME, new MasterKey.Builder(reactApplicationContext).setKeyScheme(MasterKey.KeyScheme.AES256_GCM).build(), EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV, EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM);
        } catch (Exception e) {
            SentryLogcatAdapter.e(NATIVE_MODULE_NAME, "Failed to create encrypted shared preferences! Failing back to standard SharedPreferences", e);
            this.sharedPreferences = reactApplicationContext.getSharedPreferences(SHARED_PREFERENCES_FILENAME, 0);
        }
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NATIVE_MODULE_NAME;
    }

    @ReactMethod
    public void setItem(String str, String str2, Promise promise) {
        SharedPreferences sharedPreferences = this.sharedPreferences;
        if (sharedPreferences == null) {
            promise.reject(new NullPointerException("Could not initialize SharedPreferences"));
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString(str, str2);
        if (editorEdit.commit()) {
            promise.resolve(str2);
        } else {
            promise.reject(new Exception(String.format("An error occurred while saving %s", str)));
        }
    }

    @ReactMethod
    public void getItem(String str, Promise promise) {
        SharedPreferences sharedPreferences = this.sharedPreferences;
        if (sharedPreferences == null) {
            promise.reject(new NullPointerException("Could not initialize SharedPreferences"));
        } else {
            promise.resolve(sharedPreferences.getString(str, null));
        }
    }

    @ReactMethod
    public void removeItem(String str, Promise promise) {
        SharedPreferences sharedPreferences = this.sharedPreferences;
        if (sharedPreferences == null) {
            promise.reject(new NullPointerException("Could not initialize SharedPreferences"));
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.remove(str);
        if (editorEdit.commit()) {
            promise.resolve(str);
        } else {
            promise.reject(new Exception(String.format("An error occured while removing %s", str)));
        }
    }

    @ReactMethod
    public void clear(Promise promise) {
        SharedPreferences sharedPreferences = this.sharedPreferences;
        if (sharedPreferences == null) {
            promise.reject(new NullPointerException("Could not initialize SharedPreferences"));
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.clear();
        if (editorEdit.commit()) {
            promise.resolve(null);
        } else {
            promise.reject(new Exception("An error occured while clearing SharedPreferences"));
        }
    }
}
