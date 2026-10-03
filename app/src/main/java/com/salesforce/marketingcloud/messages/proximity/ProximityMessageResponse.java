package com.salesforce.marketingcloud.messages.proximity;

import com.salesforce.marketingcloud.g;
import com.salesforce.marketingcloud.location.LatLon;
import com.salesforce.marketingcloud.messages.MessageResponse;
import com.salesforce.marketingcloud.messages.Region;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class ProximityMessageResponse implements MessageResponse {
    public final List<Region> beacons;
    private final LatLon refreshCenter;
    private final int refreshRadius;

    static final class a extends Lambda implements Function0<String> {
        public static final a b = new a();

        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return "Unable to parse Region from proximity message payload.";
        }
    }

    public ProximityMessageResponse(@NotNull LatLon refreshCenter, int i, @NotNull List<Region> beacons) {
        Intrinsics.checkNotNullParameter(refreshCenter, "refreshCenter");
        Intrinsics.checkNotNullParameter(beacons, "beacons");
        this.refreshCenter = refreshCenter;
        this.refreshRadius = i;
        this.beacons = beacons;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "beacons", imports = {}))
    public final List<Region> beacons() {
        return this.beacons;
    }

    @Override // com.salesforce.marketingcloud.messages.MessageResponse
    public LatLon getRefreshCenter() {
        return this.refreshCenter;
    }

    @Override // com.salesforce.marketingcloud.messages.MessageResponse
    public int getRefreshRadius() {
        return this.refreshRadius;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to getter", replaceWith = @ReplaceWith(expression = "getRefreshCenter()", imports = {}))
    public final LatLon refreshCenter() {
        return getRefreshCenter();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to getter", replaceWith = @ReplaceWith(expression = "getRefreshRadius()", imports = {}))
    public final int refreshRadius() {
        return getRefreshRadius();
    }

    public ProximityMessageResponse(@NotNull JSONObject json) throws JSONException {
        List listEmptyList;
        Region region;
        JSONObject jSONObject;
        Intrinsics.checkNotNullParameter(json, "json");
        LatLon latLonA = com.salesforce.marketingcloud.messages.a.a(json);
        int iB = com.salesforce.marketingcloud.messages.a.b(json);
        JSONArray jSONArrayOptJSONArray = json.optJSONArray("beacons");
        if (jSONArrayOptJSONArray != null) {
            IntRange intRangeUntil = RangesKt___RangesKt.until(0, jSONArrayOptJSONArray.length());
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(intRangeUntil, 10));
            Iterator<Integer> it2 = intRangeUntil.iterator();
            while (it2.hasNext()) {
                int iNextInt = ((IntIterator) it2).nextInt();
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(JSONObject.class);
                if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JSONObject.class))) {
                    jSONObject = jSONArrayOptJSONArray.getJSONObject(iNextInt);
                    if (jSONObject == null) {
                        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                    }
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                    jSONObject = (JSONObject) Integer.valueOf(jSONArrayOptJSONArray.getInt(iNextInt));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    jSONObject = (JSONObject) Double.valueOf(jSONArrayOptJSONArray.getDouble(iNextInt));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    jSONObject = (JSONObject) Long.valueOf(jSONArrayOptJSONArray.getLong(iNextInt));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    jSONObject = (JSONObject) Boolean.valueOf(jSONArrayOptJSONArray.getBoolean(iNextInt));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                    Object string = jSONArrayOptJSONArray.getString(iNextInt);
                    if (string == null) {
                        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                    }
                    jSONObject = (JSONObject) string;
                } else {
                    Object obj = jSONArrayOptJSONArray.get(iNextInt);
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                    }
                    jSONObject = (JSONObject) obj;
                }
                arrayList.add(jSONObject);
            }
            listEmptyList = new ArrayList();
            Iterator it3 = arrayList.iterator();
            while (it3.hasNext()) {
                try {
                    region = new Region((JSONObject) it3.next());
                } catch (Exception e) {
                    g.a.b(Region.Companion.getTAG$sdk_release(), e, a.b);
                    region = null;
                }
                if (region != null) {
                    listEmptyList.add(region);
                }
            }
        } else {
            listEmptyList = CollectionsKt__CollectionsKt.emptyList();
        }
        this(latLonA, iB, listEmptyList);
    }
}
