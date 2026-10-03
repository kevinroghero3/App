package com.transistorsoft.locationmanager.config;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Process;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.core.app.ActivityCompat;
import com.transistorsoft.locationmanager.activity.TSLocationManagerActivity;
import com.transistorsoft.locationmanager.logger.TSLog;
import com.transistorsoft.tslocationmanager.R;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class TSBackgroundPermissionRationale extends com.transistorsoft.locationmanager.config.a implements IModule {
    public static final String NAME = "backgroundPermissionRationale";
    private static int artificialFrame = 1;
    private static byte extraCallback = 0;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static final String k = "applicationName";
    private static final String l = "backgroundPermissionOptionLabel";
    private static final List<String> m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final String f103n = "Allow all the time";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final String f104o = "Allow {applicationName} to access this device's location even when closed or not in use?";
    private static final String p = "[CHANGEME] This app collects location data for FEATURE X and FEATURE Y.";
    private static final String q = "Change to \"{backgroundPermissionOptionLabel}\"";
    private static final String r = "title";
    private static final String s = "message";
    private static final String t = "positiveAction";
    private static final String u = "negativeAction";
    private String c;
    private String d;
    private String e;
    private String f;
    private Dialog g;
    private CompletionHandler h;
    private TSLocationManagerActivity.CompletionHandler i;
    private final AtomicBoolean j;

    public interface CompletionHandler {
        void onClickCancel();

        void onClickOk();
    }

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TSBackgroundPermissionRationale.this.a(view);
        }
    }

    static {
        accessartificialFrame();
        ArrayList arrayList = new ArrayList();
        m = arrayList;
        arrayList.add(k);
        arrayList.add(l);
    }

    public TSBackgroundPermissionRationale() {
        super(NAME);
        this.j = new AtomicBoolean(false);
        applyDefaults();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b() {
    }

    @Override // com.transistorsoft.locationmanager.config.IModule
    public void applyDefaults() {
        if (this.c == null) {
            this.c = f104o;
        }
        if (this.d == null) {
            this.d = p;
        }
        if (this.e == null) {
            this.e = q;
        }
        if (this.f == null) {
            this.f = "";
        }
    }

    public boolean equals(TSBackgroundPermissionRationale tSBackgroundPermissionRationale) {
        String str;
        String str2;
        String str3;
        String str4 = this.c;
        return str4 != null && str4.equals(tSBackgroundPermissionRationale.getTitle()) && (str = this.d) != null && str.equals(tSBackgroundPermissionRationale.getMessage()) && (str2 = this.e) != null && str2.equals(tSBackgroundPermissionRationale.getPositiveAction()) && (str3 = this.f) != null && str3.equals(tSBackgroundPermissionRationale.getNegativeAction());
    }

    @Override // com.transistorsoft.locationmanager.config.a
    public /* bridge */ /* synthetic */ List getDirtyFields() {
        return super.getDirtyFields();
    }

    public String getMessage() {
        return this.d;
    }

    public String getNegativeAction() {
        return this.f;
    }

    public String getPositiveAction() {
        return this.e;
    }

    public String getTitle() {
        return this.c;
    }

    public void onStartActivity(Activity activity, TSLocationManagerActivity.CompletionHandler completionHandler) {
        if (!this.j.get()) {
            completionHandler.onComplete();
            return;
        }
        this.i = completionHandler;
        Dialog dialog = new Dialog(activity, R.style.PermissionRationaleDialog);
        this.g = dialog;
        dialog.setContentView(R.layout.tslocationmanager_permission_rationale_layout);
        this.g.setCancelable(false);
        ((TextView) this.g.findViewById(R.id.title)).setText(a(activity, this.c));
        ((TextView) this.g.findViewById(R.id.message)).setText(a(activity, this.d));
        Button button = (Button) this.g.findViewById(R.id.btn_positive_action);
        button.setText(a(activity, this.e));
        a aVar = new a();
        button.setOnClickListener(aVar);
        Button button2 = (Button) this.g.findViewById(R.id.btn_negative_action);
        if (!this.f.isEmpty()) {
            button2.setText(a(activity, this.f));
        }
        button2.setOnClickListener(aVar);
        this.g.show();
    }

    public void setMessage(String str) {
        this.d = str;
    }

    public void setNegativeAction(String str) {
        this.f = str;
    }

    public void setPositiveAction(String str) {
        this.e = str;
    }

    public void setTitle(String str) {
        this.c = str;
    }

    public boolean shouldShow(Activity activity) {
        if (activity == null || this.j.get()) {
            return false;
        }
        return ActivityCompat.shouldShowRequestPermissionRationale(activity, TSLocationManagerActivity.ACCESS_BACKGROUND_LOCATION);
    }

    public void show(Activity activity, CompletionHandler completionHandler) {
        if (activity == null || this.j.get()) {
            return;
        }
        this.j.set(true);
        this.h = completionHandler;
        onStartActivity(activity, new TSLocationManagerActivity.CompletionHandler() { // from class: com.transistorsoft.locationmanager.config.TSBackgroundPermissionRationale$$ExternalSyntheticLambda1
            @Override // com.transistorsoft.locationmanager.activity.TSLocationManagerActivity.CompletionHandler
            public final void onComplete() {
                TSBackgroundPermissionRationale.b();
            }
        });
    }

    public void stop() {
        Dialog dialog = this.g;
        if (dialog != null) {
            dialog.dismiss();
        }
        this.j.set(false);
        this.g = null;
        this.h = null;
        this.i = null;
    }

    @Override // com.transistorsoft.locationmanager.config.IModule
    public JSONObject toJson(boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("title", this.c);
            jSONObject.put("message", this.d);
            jSONObject.put(t, this.e);
            jSONObject.put(u, this.f);
        } catch (JSONException e) {
            TSLog.logger.error(TSLog.error(e.getMessage()), (Throwable) e);
            e.printStackTrace();
        }
        return jSONObject;
    }

    public Map<String, Object> toMap() {
        HashMap map = new HashMap();
        map.put("title", this.c);
        map.put("message", this.d);
        map.put(t, this.e);
        map.put(u, this.f);
        return map;
    }

    public boolean update(TSBackgroundPermissionRationale tSBackgroundPermissionRationale) {
        a();
        if (tSBackgroundPermissionRationale.getTitle() != null && !tSBackgroundPermissionRationale.getTitle().equals(this.c)) {
            this.c = tSBackgroundPermissionRationale.getTitle();
            a("title");
        }
        if (tSBackgroundPermissionRationale.getMessage() != null && !tSBackgroundPermissionRationale.getMessage().equals(this.d)) {
            this.d = tSBackgroundPermissionRationale.getMessage();
            a("message");
        }
        if (tSBackgroundPermissionRationale.getPositiveAction() != null && !tSBackgroundPermissionRationale.getPositiveAction().equals(this.e)) {
            this.e = tSBackgroundPermissionRationale.getPositiveAction();
            a(t);
        }
        if (tSBackgroundPermissionRationale.getNegativeAction() != null && !tSBackgroundPermissionRationale.getNegativeAction().equals(this.f)) {
            this.f = tSBackgroundPermissionRationale.getNegativeAction();
            a(u);
        }
        return !getDirtyFields().isEmpty();
    }

    public TSBackgroundPermissionRationale(JSONObject jSONObject, boolean z) throws JSONException {
        super(NAME);
        this.j = new AtomicBoolean(false);
        if (jSONObject.has("title")) {
            this.c = jSONObject.getString("title");
        }
        if (jSONObject.has("message")) {
            this.d = jSONObject.getString("message");
        }
        if (jSONObject.has(t)) {
            this.e = jSONObject.getString(t);
        }
        if (jSONObject.has(u)) {
            this.f = jSONObject.getString(u);
        }
        if (z) {
            applyDefaults();
        }
    }

    private static String a(Context context, String str) {
        String string;
        int i = 2 % 2;
        PackageManager packageManager = context.getPackageManager();
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        for (String str2 : m) {
            int i2 = artificialFrame + 23;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i2 % 128;
            int i3 = i2 % 2;
            if (str2.equals(k)) {
                int i4 = applicationInfo.labelRes;
                if (i4 == 0) {
                    int i5 = artificialFrame + 117;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i5 % 128;
                    int i6 = i5 % 2;
                    string = applicationInfo.nonLocalizedLabel.toString();
                    int i7 = artificialFrame + 113;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i7 % 128;
                    int i8 = i7 % 2;
                } else {
                    string = context.getString(i4);
                    if (string.startsWith(".,.%")) {
                        Object[] objArr = new Object[1];
                        v(string.substring(4), objArr);
                        string = ((String) objArr[0]).intern();
                    }
                }
            } else if (!str2.equals(l)) {
                string = null;
            } else if (Build.VERSION.SDK_INT >= 30) {
                string = packageManager.getBackgroundPermissionOptionLabel().toString();
            } else {
                TSLog.logger.warn(TSLog.warn("backgroundPermissionRationale attempted to apply template tag backgroundPermissionOptionLabel but this is only available with compileSdkVersion >= 30"));
                int i9 = getARTIFICIAL_FRAME_PACKAGE_NAME + 97;
                artificialFrame = i9 % 128;
                int i10 = i9 % 2;
                string = f103n;
            }
            if (string != null) {
                str = str.replaceAll("\\{" + str2 + "\\}", string);
            }
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view) {
        this.j.set(false);
        Dialog dialog = this.g;
        if (dialog != null) {
            dialog.dismiss();
        }
        TSLocationManagerActivity.CompletionHandler completionHandler = this.i;
        if (completionHandler != null) {
            completionHandler.onComplete();
        }
        if (this.h != null) {
            if (view.getId() == R.id.btn_positive_action) {
                this.h.onClickOk();
            } else {
                this.h.onClickCancel();
            }
        }
        stop();
    }

    private static void v(String str, Object[] objArr) {
        byte[] bArrDecode = Base64.decode(str, 0);
        byte[] bArr = new byte[bArrDecode.length];
        for (int i = 0; i < bArrDecode.length; i++) {
            bArr[i] = (byte) (bArrDecode[(bArrDecode.length - i) - 1] ^ extraCallback);
        }
        objArr[0] = new String(bArr, StandardCharsets.UTF_8);
    }

    /* JADX INFO: loaded from: classes6.dex */
    public static class Builder {
        public static int ensureClassLoader;
        public static int fromMediaSession;
        private String a;
        private String b;
        private String c;
        private String d;

        public TSBackgroundPermissionRationale build() {
            TSBackgroundPermissionRationale tSBackgroundPermissionRationale = new TSBackgroundPermissionRationale();
            tSBackgroundPermissionRationale.c = this.a;
            tSBackgroundPermissionRationale.d = this.b;
            tSBackgroundPermissionRationale.e = this.c;
            tSBackgroundPermissionRationale.f = this.d;
            return tSBackgroundPermissionRationale;
        }

        public Builder setMessage(String str) {
            this.b = str;
            return this;
        }

        public Builder setNegativeAction(String str) {
            this.d = str;
            return this;
        }

        public Builder setPositiveAction(String str) {
            this.c = str;
            return this;
        }

        public Builder setTitle(String str) {
            this.a = str;
            return this;
        }

        public static int MediaBrowserCompatMediaBrowserImplApi21() {
            int i = fromMediaSession;
            int i2 = i % 5191635;
            fromMediaSession = i + 1;
            if (i2 != 0) {
                return ensureClassLoader;
            }
            int elapsedCpuTime = (int) Process.getElapsedCpuTime();
            ensureClassLoader = elapsedCpuTime;
            return elapsedCpuTime;
        }
    }

    static void accessartificialFrame() {
        extraCallback = (byte) -124;
    }
}
