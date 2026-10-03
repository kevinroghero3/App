package com.nfcblocker;

import android.app.Activity;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.cardemulation.CardEmulation;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import io.sentry.android.core.SentryLogcatAdapter;

/* JADX INFO: loaded from: classes3.dex */
@ReactModule(name = NfcBlockerModule.NAME)
public class NfcBlockerModule extends ReactContextBaseJavaModule implements NfcAdapter.ReaderCallback, LifecycleEventListener {
    public static final String NAME = "NfcBlocker";
    private CardEmulation cardEmulation;
    private long lastResume;
    private NfcAdapter nfcAdapter;
    private String nfcToken;
    private boolean readerModeEnabled;

    @Override // android.nfc.NfcAdapter.ReaderCallback
    public void onTagDiscovered(Tag tag) {
    }

    public NfcBlockerModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.readerModeEnabled = false;
        this.lastResume = 0L;
        NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(reactApplicationContext);
        this.nfcAdapter = defaultAdapter;
        if (defaultAdapter != null) {
            this.cardEmulation = CardEmulation.getInstance(defaultAdapter);
        }
        reactApplicationContext.addLifecycleEventListener(this);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    private void tryEnable() {
        NfcAdapter nfcAdapter;
        Activity currentActivity = getCurrentActivity();
        if (Build.VERSION.SDK_INT >= 35 && (nfcAdapter = this.nfcAdapter) != null) {
            try {
                nfcAdapter.setObserveModeEnabled(true);
            } catch (Exception e) {
                SentryLogcatAdapter.e(NAME, "tryEnable: setObserveModeEnabled error", e);
            }
        }
        if (currentActivity == null || this.nfcAdapter == null) {
            Log.i(NAME, "tryEnable skipped: activity or adapter null");
            return;
        }
        if (this.readerModeEnabled) {
            Log.i(NAME, "tryEnable skipped: already enabled");
            return;
        }
        try {
            this.nfcAdapter.enableReaderMode(currentActivity, this, 415, new Bundle());
            this.readerModeEnabled = true;
        } catch (Exception e2) {
            SentryLogcatAdapter.e(NAME, "enableReaderMode ERROR", e2);
        }
    }

    private void tryDisable() {
        NfcAdapter nfcAdapter;
        NfcAdapter nfcAdapter2;
        Activity currentActivity = getCurrentActivity();
        if (Build.VERSION.SDK_INT >= 35 && (nfcAdapter2 = this.nfcAdapter) != null) {
            try {
                nfcAdapter2.setObserveModeEnabled(false);
            } catch (Exception e) {
                SentryLogcatAdapter.e(NAME, "tryDisable: setObserveModeEnabled error", e);
            }
        }
        if (currentActivity == null || (nfcAdapter = this.nfcAdapter) == null) {
            Log.i(NAME, "tryDisable skipped: activity or adapter null");
            return;
        }
        if (!this.readerModeEnabled) {
            Log.i(NAME, "tryDisable skipped: already disabled");
            return;
        }
        try {
            nfcAdapter.disableReaderMode(currentActivity);
            this.readerModeEnabled = false;
        } catch (Exception e2) {
            SentryLogcatAdapter.e(NAME, "disableReaderMode ERROR", e2);
        }
    }

    @ReactMethod
    public void setNfcToken(@Nullable String str) {
        if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(str)) {
            str = null;
        }
        this.nfcToken = str;
        if (str != null) {
            tryDisable();
        } else {
            tryEnable();
        }
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostResume() {
        this.lastResume = System.currentTimeMillis();
        tryEnable();
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostPause() {
        tryDisable();
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostDestroy() {
        tryDisable();
    }
}
