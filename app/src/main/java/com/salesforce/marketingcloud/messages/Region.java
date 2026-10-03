package com.salesforce.marketingcloud.messages;

import android.os.Parcel;
import android.os.Parcelable;
import com.salesforce.marketingcloud.g;
import com.salesforce.marketingcloud.internal.o;
import com.salesforce.marketingcloud.location.LatLon;
import com.salesforce.marketingcloud.storage.db.i;
import com.transistorsoft.locationmanager.geofence.TSGeofence;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.annotation.AnnotationRetention;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class Region implements Parcelable, Comparable<Region> {
    public static final String MAGIC_REGION_ID = "~~m@g1c_f3nc3~~";
    public static final int REGION_TYPE_FENCE = 1;
    public static final int REGION_TYPE_PROXIMITY = 3;
    public final LatLon center;
    public final String description;
    public final String id;
    private boolean isInside;
    public final int major;
    public final List<Message> messages;
    public final int minor;
    public final String name;
    public final String proximityUuid;
    public final int radius;
    public final int regionType;
    public static final Companion Companion = new Companion(null);
    public static final Parcelable.Creator<Region> CREATOR = new c();
    private static final String TAG = g.a("Region");

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String getTAG$sdk_release() {
            return Region.TAG;
        }

        public final Region magicFence$sdk_release(@NotNull LatLon center, int i) {
            Intrinsics.checkNotNullParameter(center, "center");
            return new Region(Region.MAGIC_REGION_ID, center, i, null, 0, 0, -1, null, null, null, 952, null);
        }

        private Companion() {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface RegionType {
    }

    static final class a extends Lambda implements Function0<String> {
        public static final a b = new a();

        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return "Unable to parse Message from region payload.";
        }
    }

    static final class b extends Lambda implements Function0<String> {
        public static final b b = new b();

        b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return "Unable to parse region messages.";
        }
    }

    public static final class c implements Parcelable.Creator<Region> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Region createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            LatLon latLonCreateFromParcel = LatLon.CREATOR.createFromParcel(parcel);
            int i = parcel.readInt();
            String string2 = parcel.readString();
            int i2 = parcel.readInt();
            int i3 = parcel.readInt();
            int i4 = parcel.readInt();
            String string3 = parcel.readString();
            String string4 = parcel.readString();
            int i5 = parcel.readInt();
            ArrayList arrayList = new ArrayList(i5);
            for (int i6 = 0; i6 != i5; i6++) {
                arrayList.add(Message.CREATOR.createFromParcel(parcel));
            }
            return new Region(string, latLonCreateFromParcel, i, string2, i2, i3, i4, string3, string4, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Region[] newArray(int i) {
            return new Region[i];
        }
    }

    public Region(@NotNull String id, @NotNull LatLon center, int i, @Nullable String str, int i2, int i3, int i4, @Nullable String str2, @Nullable String str3, @NotNull List<Message> messages) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(center, "center");
        Intrinsics.checkNotNullParameter(messages, "messages");
        this.id = id;
        this.center = center;
        this.radius = i;
        this.proximityUuid = str;
        this.major = i2;
        this.minor = i3;
        this.regionType = i4;
        this.name = str2;
        this.description = str3;
        this.messages = messages;
    }

    public static /* synthetic */ void isInside$sdk_release$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "center", imports = {}))
    public final LatLon center() {
        return this.center;
    }

    public final String component1() {
        return this.id;
    }

    public final List<Message> component10() {
        return this.messages;
    }

    public final LatLon component2() {
        return this.center;
    }

    public final int component3() {
        return this.radius;
    }

    public final String component4() {
        return this.proximityUuid;
    }

    public final int component5() {
        return this.major;
    }

    public final int component6() {
        return this.minor;
    }

    public final int component7() {
        return this.regionType;
    }

    public final String component8() {
        return this.name;
    }

    public final String component9() {
        return this.description;
    }

    public final Region copy(@NotNull String id, @NotNull LatLon center, int i, @Nullable String str, int i2, int i3, int i4, @Nullable String str2, @Nullable String str3, @NotNull List<Message> messages) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(center, "center");
        Intrinsics.checkNotNullParameter(messages, "messages");
        return new Region(id, center, i, str, i2, i3, i4, str2, str3, messages);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "description", imports = {}))
    public final String description() {
        return this.description;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Region)) {
            return false;
        }
        Region region = (Region) obj;
        return Intrinsics.areEqual(this.id, region.id) && Intrinsics.areEqual(this.center, region.center) && this.radius == region.radius && Intrinsics.areEqual(this.proximityUuid, region.proximityUuid) && this.major == region.major && this.minor == region.minor && this.regionType == region.regionType && Intrinsics.areEqual(this.name, region.name) && Intrinsics.areEqual(this.description, region.description) && Intrinsics.areEqual(this.messages, region.messages);
    }

    public int hashCode() {
        int iHashCode = this.id.hashCode();
        int iHashCode2 = this.center.hashCode();
        int iHashCode3 = Integer.hashCode(this.radius);
        String str = this.proximityUuid;
        int iHashCode4 = str == null ? 0 : str.hashCode();
        int iHashCode5 = Integer.hashCode(this.major);
        int iHashCode6 = Integer.hashCode(this.minor);
        int iHashCode7 = Integer.hashCode(this.regionType);
        String str2 = this.name;
        int iHashCode8 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.description;
        return (((((((((((((((((iHashCode * 31) + iHashCode2) * 31) + iHashCode3) * 31) + iHashCode4) * 31) + iHashCode5) * 31) + iHashCode6) * 31) + iHashCode7) * 31) + iHashCode8) * 31) + (str3 != null ? str3.hashCode() : 0)) * 31) + this.messages.hashCode();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "id", imports = {}))
    public final String id() {
        return this.id;
    }

    public final boolean isInside$sdk_release() {
        return this.isInside;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "major", imports = {}))
    public final int major() {
        return this.major;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = i.e, imports = {}))
    public final List<Message> messages() {
        return this.messages;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "minor", imports = {}))
    public final int minor() {
        return this.minor;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "name", imports = {}))
    public final String name() {
        return this.name;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "proximityUuid", imports = {}))
    public final String proximityUuid() {
        return this.proximityUuid;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = TSGeofence.FIELD_RADIUS, imports = {}))
    public final int radius() {
        return this.radius;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "regionType", imports = {}))
    public final int regionType() {
        return this.regionType;
    }

    public final void setInside$sdk_release(boolean z) {
        this.isInside = z;
    }

    public String toString() {
        return "Region(id=" + this.id + ", center=" + this.center + ", radius=" + this.radius + ", proximityUuid=" + this.proximityUuid + ", major=" + this.major + ", minor=" + this.minor + ", regionType=" + this.regionType + ", name=" + this.name + ", description=" + this.description + ", messages=" + this.messages + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeString(this.id);
        this.center.writeToParcel(out, i);
        out.writeInt(this.radius);
        out.writeString(this.proximityUuid);
        out.writeInt(this.major);
        out.writeInt(this.minor);
        out.writeInt(this.regionType);
        out.writeString(this.name);
        out.writeString(this.description);
        List<Message> list = this.messages;
        out.writeInt(list.size());
        Iterator<Message> it2 = list.iterator();
        while (it2.hasNext()) {
            it2.next().writeToParcel(out, i);
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(@NotNull Region other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return this.id.compareTo(other.id);
    }

    public /* synthetic */ Region(String str, LatLon latLon, int i, String str2, int i2, int i3, int i4, String str3, String str4, List list, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, latLon, i, (i5 & 8) != 0 ? null : str2, (i5 & 16) != 0 ? 0 : i2, (i5 & 32) != 0 ? 0 : i3, i4, (i5 & 128) != 0 ? null : str3, (i5 & 256) != 0 ? null : str4, (i5 & 512) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list);
    }

    public Region(@NotNull JSONObject json) throws JSONException {
        List listEmptyList;
        Message message;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        Class<JSONObject> cls = JSONObject.class;
        Intrinsics.checkNotNullParameter(json, "json");
        String string = json.getString("id");
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        JSONObject jSONObject3 = json.getJSONObject("center");
        Intrinsics.checkNotNullExpressionValue(jSONObject3, "getJSONObject(...)");
        LatLon latLon = new LatLon(jSONObject3);
        int iOptInt = json.optInt(TSGeofence.FIELD_RADIUS);
        String strOptString = json.optString("proximityUuid");
        Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
        String strB = o.b(strOptString);
        int iOptInt2 = json.optInt("major");
        int iOptInt3 = json.optInt("minor");
        int i = json.getInt("locationType");
        String strOptString2 = json.optString("name");
        Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
        String strB2 = o.b(strOptString2);
        String strOptString3 = json.optString("description");
        Intrinsics.checkNotNullExpressionValue(strOptString3, "optString(...)");
        String strB3 = o.b(strOptString3);
        try {
            JSONArray jSONArrayOptJSONArray = json.optJSONArray(i.e);
            if (jSONArrayOptJSONArray != null) {
                IntRange intRangeUntil = RangesKt___RangesKt.until(0, jSONArrayOptJSONArray.length());
                ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(intRangeUntil, 10));
                Iterator<Integer> it2 = intRangeUntil.iterator();
                while (it2.hasNext()) {
                    int iNextInt = ((IntIterator) it2).nextInt();
                    KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(cls);
                    Class<JSONObject> cls2 = cls;
                    if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls))) {
                        jSONObject = jSONArrayOptJSONArray.getJSONObject(iNextInt);
                        if (jSONObject == null) {
                            throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                        }
                    } else {
                        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                            jSONObject2 = (JSONObject) Integer.valueOf(jSONArrayOptJSONArray.getInt(iNextInt));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                            jSONObject2 = (JSONObject) Double.valueOf(jSONArrayOptJSONArray.getDouble(iNextInt));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                            jSONObject2 = (JSONObject) Long.valueOf(jSONArrayOptJSONArray.getLong(iNextInt));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                            jSONObject2 = (JSONObject) Boolean.valueOf(jSONArrayOptJSONArray.getBoolean(iNextInt));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                            Object string2 = jSONArrayOptJSONArray.getString(iNextInt);
                            if (string2 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                            }
                            jSONObject = (JSONObject) string2;
                        } else {
                            Object obj = jSONArrayOptJSONArray.get(iNextInt);
                            if (obj == null) {
                                throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                            }
                            jSONObject = (JSONObject) obj;
                        }
                        jSONObject = jSONObject2;
                    }
                    arrayList.add(jSONObject);
                    cls = cls2;
                }
                ArrayList arrayList2 = new ArrayList();
                Iterator it3 = arrayList.iterator();
                while (it3.hasNext()) {
                    try {
                        message = new Message((JSONObject) it3.next());
                    } catch (Exception e) {
                        g.a.b(TAG, e, a.b);
                        message = null;
                    }
                    if (message != null) {
                        arrayList2.add(message);
                    }
                }
                listEmptyList = new ArrayList();
                for (Object obj2 : arrayList2) {
                    if (com.salesforce.marketingcloud.messages.b.a((Message) obj2)) {
                        listEmptyList.add(obj2);
                    }
                }
            } else {
                listEmptyList = CollectionsKt__CollectionsKt.emptyList();
            }
        } catch (JSONException e2) {
            g.a.b(TAG, e2, b.b);
            listEmptyList = CollectionsKt__CollectionsKt.emptyList();
        }
        this(string, latLon, iOptInt, strB, iOptInt2, iOptInt3, i, strB2, strB3, listEmptyList);
    }
}
