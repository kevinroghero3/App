package com.transistorsoft.locationmanager.config;

import android.util.Log;
import com.transistorsoft.locationmanager.logger.TSLog;
import io.sentry.protocol.SentryThread;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class TSNotification extends a implements IModule {
    public static final String NAME = "notification";
    static final String p = "";
    static final String q = "Location Service activated";
    static final Integer r = -1;
    static final String s = "TSLocationManager";
    private Map<String, Object> c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private Integer i;
    private String j;
    private String k;
    private String l;
    private Map<String, String> m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private List<String> f105n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private Boolean f106o;

    public TSNotification() {
        super(NAME);
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.f105n = null;
        this.f106o = null;
        applyDefaults();
    }

    public void addAction(String str) {
        this.f105n.add(str);
    }

    public void addString(String str, String str2) {
        this.m.put(str, str2);
    }

    @Override // com.transistorsoft.locationmanager.config.IModule
    public void applyDefaults() {
        if (this.e == null) {
            this.e = "";
        }
        if (this.f == null) {
            this.f = "Location Service activated";
        }
        if (this.i == null) {
            this.i = r;
        }
        if (this.j == null) {
            this.j = "";
        }
        if (this.g == null) {
            this.g = "";
        }
        if (this.h == null) {
            this.h = "";
        }
        if (this.k == null) {
            this.k = "TSLocationManager";
        }
        if (this.l == null) {
            this.l = "";
        }
        if (this.d == null) {
            this.d = "";
        }
        if (this.m == null) {
            this.m = new HashMap();
        }
        if (this.f105n == null) {
            this.f105n = new ArrayList();
        }
        if (this.f106o == null) {
            this.f106o = Boolean.FALSE;
        }
    }

    public boolean equals(TSNotification tSNotification) {
        List<String> list;
        Map<String, String> map;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        Integer num;
        String str6;
        String str7;
        Boolean bool;
        String str8 = this.d;
        return str8 != null && str8.equals(tSNotification.getLayout()) && (list = this.f105n) != null && list.containsAll(tSNotification.getActions()) && (map = this.m) != null && map.equals(tSNotification.getStrings()) && (str = this.e) != null && str.equals(tSNotification.getTitle()) && (str2 = this.f) != null && str2.equals(tSNotification.getText()) && (str3 = this.k) != null && str3.equals(tSNotification.getChannelName()) && (str4 = this.l) != null && str4.equals(tSNotification.getChannelId()) && (str5 = this.j) != null && str5.equals(tSNotification.getColor()) && (num = this.i) != null && num.equals(tSNotification.getPriority()) && (str6 = this.g) != null && str6.equals(tSNotification.getSmallIcon()) && (str7 = this.h) != null && str7.equals(tSNotification.getLargeIcon()) && (bool = this.f106o) != null && bool.equals(tSNotification.getSticky());
    }

    public List<String> getActions() {
        return this.f105n;
    }

    public String getChannelId() {
        return this.l;
    }

    public String getChannelName() {
        return this.k;
    }

    public String getColor() {
        return this.j;
    }

    @Override // com.transistorsoft.locationmanager.config.a
    public /* bridge */ /* synthetic */ List getDirtyFields() {
        return super.getDirtyFields();
    }

    public String getLargeIcon() {
        return this.h;
    }

    public String getLayout() {
        return this.d;
    }

    public Map<String, Object> getPreviousValues() {
        return this.c;
    }

    public Integer getPriority() {
        return this.i;
    }

    public String getSmallIcon() {
        return this.g;
    }

    public Boolean getSticky() {
        return this.f106o;
    }

    public String getString(String str) {
        if (this.m.containsKey(str)) {
            return this.m.get(str);
        }
        return null;
    }

    public Map<String, String> getStrings() {
        return this.m;
    }

    public String getText() {
        return this.f;
    }

    public String getTitle() {
        return this.e;
    }

    public void setChannelId(String str) {
        this.l = str;
    }

    public void setChannelName(String str) {
        this.k = str;
    }

    public void setColor(String str) {
        this.j = str;
    }

    public void setLargeIcon(String str) {
        this.h = str;
    }

    public void setLayout(String str) {
        this.d = str;
    }

    public void setPriority(Integer num) {
        this.i = num;
    }

    public void setSmallIcon(String str) {
        this.g = str;
    }

    public void setSticky(Boolean bool) {
        this.f106o = bool;
    }

    public void setText(String str) {
        this.f = str;
    }

    public void setTitle(String str) {
        this.e = str;
    }

    @Override // com.transistorsoft.locationmanager.config.IModule
    public JSONObject toJson(boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            jSONObject.put("layout", this.d);
            jSONObject.put("title", this.e);
            jSONObject.put("text", this.f);
            jSONObject.put("color", this.j);
            jSONObject.put("channelName", this.k);
            jSONObject.put("channelId", this.l);
            jSONObject.put("smallIcon", this.g);
            jSONObject.put("largeIcon", this.h);
            jSONObject.put(SentryThread.JsonKeys.PRIORITY, this.i);
            jSONObject.put("sticky", this.f106o);
            for (Map.Entry<String, String> entry : this.m.entrySet()) {
                jSONObject2.put(entry.getKey(), entry.getValue());
            }
            jSONObject.put("strings", jSONObject2);
            Iterator<String> it2 = this.f105n.iterator();
            while (it2.hasNext()) {
                jSONArray.put(it2.next());
            }
            jSONObject.put("actions", jSONArray);
        } catch (JSONException e) {
            Log.i("TSLocationManager", TSLog.error(e.getMessage()));
            TSLog.logger.error(TSLog.error(e.getMessage()), (Throwable) e);
            e.printStackTrace();
        }
        return jSONObject;
    }

    public Map<String, Object> toMap() {
        HashMap map = new HashMap();
        map.put("layout", this.d);
        map.put("title", this.e);
        map.put("text", this.f);
        map.put("color", this.j);
        map.put("channelName", this.k);
        map.put("channelId", this.l);
        map.put("smallIcon", this.g);
        map.put("largeIcon", this.h);
        map.put(SentryThread.JsonKeys.PRIORITY, this.i);
        map.put("strings", this.m);
        map.put("actions", this.f105n);
        map.put("sticky", this.f106o);
        return map;
    }

    public boolean update(TSNotification tSNotification) {
        this.c = toMap();
        a();
        if (tSNotification.getTitle() != null && !tSNotification.getTitle().equals(this.e)) {
            this.e = tSNotification.getTitle();
            a("title");
        }
        if (tSNotification.getText() != null && !tSNotification.getText().equals(this.f)) {
            this.f = tSNotification.getText();
            a("text");
        }
        if (tSNotification.getLayout() != null && !tSNotification.getLayout().equals(this.d)) {
            this.d = tSNotification.getLayout();
            a("layout");
        }
        if (tSNotification.getColor() != null && !tSNotification.getColor().equals(this.j)) {
            this.j = tSNotification.getColor();
            a("color");
        }
        if (tSNotification.getSmallIcon() != null && !tSNotification.getSmallIcon().equals(this.g)) {
            this.g = tSNotification.getSmallIcon();
            a("smallIcon");
        }
        if (tSNotification.getLargeIcon() != null && !tSNotification.getLargeIcon().equals(this.h)) {
            this.h = tSNotification.getLargeIcon();
            a("largeIcon");
        }
        if (tSNotification.getPriority() != null && !tSNotification.getPriority().equals(this.i)) {
            this.i = tSNotification.getPriority();
            a(SentryThread.JsonKeys.PRIORITY);
        }
        if (tSNotification.getSticky() != null && !tSNotification.getSticky().equals(this.f106o)) {
            this.f106o = tSNotification.getSticky();
            a("sticky");
        }
        if (tSNotification.getActions() != null && (!this.f105n.containsAll(tSNotification.getActions()) || tSNotification.getActions().size() != this.f105n.size())) {
            this.f105n = tSNotification.getActions();
            a("actions");
        }
        if (tSNotification.getStrings() != null && !tSNotification.getStrings().equals(this.m)) {
            this.m = tSNotification.getStrings();
            a("strings");
        }
        if (tSNotification.getChannelName() != null && !tSNotification.getChannelName().equals(this.k)) {
            this.k = tSNotification.getChannelName();
            a("channelName");
        }
        if (tSNotification.getChannelId() != null && !tSNotification.getChannelId().equals(this.l)) {
            this.l = tSNotification.getChannelId();
            a("channelId");
        }
        return !getDirtyFields().isEmpty();
    }

    public TSNotification(JSONObject jSONObject, boolean z) throws JSONException {
        super(NAME);
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.f105n = null;
        this.f106o = null;
        if (jSONObject.has("layout")) {
            this.d = jSONObject.getString("layout");
        }
        if (jSONObject.has("title")) {
            this.e = jSONObject.getString("title");
        }
        if (jSONObject.has("text")) {
            this.f = jSONObject.getString("text");
        }
        if (jSONObject.has("smallIcon")) {
            this.g = jSONObject.getString("smallIcon");
        }
        if (jSONObject.has("largeIcon")) {
            this.h = jSONObject.getString("largeIcon");
        }
        if (jSONObject.has(SentryThread.JsonKeys.PRIORITY)) {
            this.i = Integer.valueOf(jSONObject.getInt(SentryThread.JsonKeys.PRIORITY));
        }
        if (jSONObject.has("color")) {
            this.j = jSONObject.getString("color");
        }
        if (jSONObject.has("channelName")) {
            this.k = jSONObject.getString("channelName");
        }
        if (jSONObject.has("channelId")) {
            this.l = jSONObject.getString("channelId");
        }
        if (jSONObject.has("strings")) {
            this.m = new HashMap();
            JSONObject jSONObject2 = jSONObject.getJSONObject("strings");
            Iterator<String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                addString(next, jSONObject2.getString(next));
            }
        }
        if (jSONObject.has("actions")) {
            this.f105n = new ArrayList();
            JSONArray jSONArray = jSONObject.getJSONArray("actions");
            for (int i = 0; i < jSONArray.length(); i++) {
                addAction(jSONArray.getString(i));
            }
        }
        if (jSONObject.has("sticky")) {
            this.f106o = Boolean.valueOf(jSONObject.getBoolean("sticky"));
        }
        if (z) {
            applyDefaults();
        }
    }
}
