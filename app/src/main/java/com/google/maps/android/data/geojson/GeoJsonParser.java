package com.google.maps.android.data.geojson;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.maps.android.data.Geometry;
import io.sentry.android.core.SentryLogcatAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class GeoJsonParser {
    private static final String BOUNDING_BOX = "bbox";
    private static final String FEATURE = "Feature";
    private static final String FEATURE_COLLECTION = "FeatureCollection";
    private static final String FEATURE_COLLECTION_ARRAY = "features";
    private static final String FEATURE_GEOMETRY = "geometry";
    private static final String FEATURE_ID = "id";
    private static final String GEOMETRY_COLLECTION = "GeometryCollection";
    private static final String GEOMETRY_COLLECTION_ARRAY = "geometries";
    private static final String GEOMETRY_COORDINATES_ARRAY = "coordinates";
    private static final String LINESTRING = "LineString";
    private static final String LOG_TAG = "GeoJsonParser";
    private static final String MULTILINESTRING = "MultiLineString";
    private static final String MULTIPOINT = "MultiPoint";
    private static final String MULTIPOLYGON = "MultiPolygon";
    private static final String POINT = "Point";
    private static final String POLYGON = "Polygon";
    private static final String PROPERTIES = "properties";
    private final JSONObject mGeoJsonFile;
    private final ArrayList<GeoJsonFeature> mGeoJsonFeatures = new ArrayList<>();
    private LatLngBounds mBoundingBox = null;

    static class LatLngAlt {
        public final Double altitude;
        public final LatLng latLng;

        LatLngAlt(LatLng latLng, Double d) {
            this.latLng = latLng;
            this.altitude = d;
        }
    }

    public GeoJsonParser(JSONObject jSONObject) {
        this.mGeoJsonFile = jSONObject;
        parseGeoJson();
    }

    private static boolean isGeometry(String str) {
        return str.matches("Point|MultiPoint|LineString|MultiLineString|Polygon|MultiPolygon|GeometryCollection");
    }

    private static GeoJsonFeature parseFeature(JSONObject jSONObject) {
        HashMap<String, String> map = new HashMap<>();
        try {
            String string = jSONObject.has("id") ? jSONObject.getString("id") : null;
            LatLngBounds boundingBox = jSONObject.has(BOUNDING_BOX) ? parseBoundingBox(jSONObject.getJSONArray(BOUNDING_BOX)) : null;
            Geometry geometry = (!jSONObject.has(FEATURE_GEOMETRY) || jSONObject.isNull(FEATURE_GEOMETRY)) ? null : parseGeometry(jSONObject.getJSONObject(FEATURE_GEOMETRY));
            if (jSONObject.has(PROPERTIES) && !jSONObject.isNull(PROPERTIES)) {
                map = parseProperties(jSONObject.getJSONObject(PROPERTIES));
            }
            return new GeoJsonFeature(geometry, string, map, boundingBox);
        } catch (JSONException unused) {
            SentryLogcatAdapter.w(LOG_TAG, "Feature could not be successfully parsed " + jSONObject.toString());
            return null;
        }
    }

    private static LatLngBounds parseBoundingBox(JSONArray jSONArray) throws JSONException {
        return new LatLngBounds(new LatLng(jSONArray.getDouble(1), jSONArray.getDouble(0)), new LatLng(jSONArray.getDouble(3), jSONArray.getDouble(2)));
    }

    public static Geometry parseGeometry(JSONObject jSONObject) {
        JSONArray jSONArray;
        try {
            String string = jSONObject.getString("type");
            if (string.equals(GEOMETRY_COLLECTION)) {
                jSONArray = jSONObject.getJSONArray(GEOMETRY_COLLECTION_ARRAY);
            } else {
                if (!isGeometry(string)) {
                    return null;
                }
                jSONArray = jSONObject.getJSONArray(GEOMETRY_COORDINATES_ARRAY);
            }
            return createGeometry(string, jSONArray);
        } catch (JSONException unused) {
            return null;
        }
    }

    private static GeoJsonFeature parseGeometryToFeature(JSONObject jSONObject) {
        Geometry geometry = parseGeometry(jSONObject);
        if (geometry != null) {
            return new GeoJsonFeature(geometry, null, new HashMap(), null);
        }
        SentryLogcatAdapter.w(LOG_TAG, "Geometry could not be parsed");
        return null;
    }

    private static HashMap<String, String> parseProperties(JSONObject jSONObject) throws JSONException {
        HashMap<String, String> map = new HashMap<>();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            map.put(next, jSONObject.isNull(next) ? null : jSONObject.getString(next));
        }
        return map;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:33:0x0058  */
    private static Geometry createGeometry(String str, JSONArray jSONArray) throws JSONException {
        str.hashCode();
        switch (str) {
            case "MultiPolygon":
                return createMultiPolygon(jSONArray);
            case "MultiPoint":
                return createMultiPoint(jSONArray);
            case "MultiLineString":
                return createMultiLineString(jSONArray);
            case "Point":
                return createPoint(jSONArray);
            case "Polygon":
                return createPolygon(jSONArray);
            case "LineString":
                return createLineString(jSONArray);
            case "GeometryCollection":
                return createGeometryCollection(jSONArray);
            default:
                return null;
        }
    }

    private static GeoJsonPoint createPoint(JSONArray jSONArray) throws JSONException {
        LatLngAlt coordinate = parseCoordinate(jSONArray);
        return new GeoJsonPoint(coordinate.latLng, coordinate.altitude);
    }

    private static GeoJsonMultiPoint createMultiPoint(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(createPoint(jSONArray.getJSONArray(i)));
        }
        return new GeoJsonMultiPoint(arrayList);
    }

    private static GeoJsonLineString createLineString(JSONArray jSONArray) throws JSONException {
        ArrayList<LatLngAlt> coordinatesArray = parseCoordinatesArray(jSONArray);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (LatLngAlt latLngAlt : coordinatesArray) {
            arrayList.add(latLngAlt.latLng);
            Double d = latLngAlt.altitude;
            if (d != null) {
                arrayList2.add(d);
            }
        }
        return new GeoJsonLineString(arrayList, arrayList2);
    }

    private static GeoJsonMultiLineString createMultiLineString(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(createLineString(jSONArray.getJSONArray(i)));
        }
        return new GeoJsonMultiLineString(arrayList);
    }

    private static GeoJsonPolygon createPolygon(JSONArray jSONArray) throws JSONException {
        return new GeoJsonPolygon(parseCoordinatesArrays(jSONArray));
    }

    private static GeoJsonMultiPolygon createMultiPolygon(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(createPolygon(jSONArray.getJSONArray(i)));
        }
        return new GeoJsonMultiPolygon(arrayList);
    }

    private static GeoJsonGeometryCollection createGeometryCollection(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            Geometry geometry = parseGeometry(jSONArray.getJSONObject(i));
            if (geometry != null) {
                arrayList.add(geometry);
            }
        }
        return new GeoJsonGeometryCollection(arrayList);
    }

    private static LatLngAlt parseCoordinate(JSONArray jSONArray) throws JSONException {
        return new LatLngAlt(new LatLng(jSONArray.getDouble(1), jSONArray.getDouble(0)), jSONArray.length() < 3 ? null : Double.valueOf(jSONArray.getDouble(2)));
    }

    private static ArrayList<LatLngAlt> parseCoordinatesArray(JSONArray jSONArray) throws JSONException {
        ArrayList<LatLngAlt> arrayList = new ArrayList<>();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(parseCoordinate(jSONArray.getJSONArray(i)));
        }
        return arrayList;
    }

    private static ArrayList<ArrayList<LatLng>> parseCoordinatesArrays(JSONArray jSONArray) throws JSONException {
        ArrayList<ArrayList<LatLng>> arrayList = new ArrayList<>();
        for (int i = 0; i < jSONArray.length(); i++) {
            ArrayList<LatLngAlt> coordinatesArray = parseCoordinatesArray(jSONArray.getJSONArray(i));
            ArrayList<LatLng> arrayList2 = new ArrayList<>();
            Iterator<LatLngAlt> it2 = coordinatesArray.iterator();
            while (it2.hasNext()) {
                arrayList2.add(it2.next().latLng);
            }
            arrayList.add(arrayList2);
        }
        return arrayList;
    }

    private void parseGeoJson() {
        try {
            String string = this.mGeoJsonFile.getString("type");
            if (string.equals(FEATURE)) {
                GeoJsonFeature feature = parseFeature(this.mGeoJsonFile);
                if (feature != null) {
                    this.mGeoJsonFeatures.add(feature);
                }
            } else if (string.equals(FEATURE_COLLECTION)) {
                this.mGeoJsonFeatures.addAll(parseFeatureCollection(this.mGeoJsonFile));
            } else if (isGeometry(string)) {
                GeoJsonFeature geometryToFeature = parseGeometryToFeature(this.mGeoJsonFile);
                if (geometryToFeature != null) {
                    this.mGeoJsonFeatures.add(geometryToFeature);
                }
            } else {
                SentryLogcatAdapter.w(LOG_TAG, "GeoJSON file could not be parsed.");
            }
        } catch (JSONException unused) {
            SentryLogcatAdapter.w(LOG_TAG, "GeoJSON file could not be parsed.");
        }
    }

    private ArrayList<GeoJsonFeature> parseFeatureCollection(JSONObject jSONObject) {
        ArrayList<GeoJsonFeature> arrayList = new ArrayList<>();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray(FEATURE_COLLECTION_ARRAY);
            if (jSONObject.has(BOUNDING_BOX)) {
                this.mBoundingBox = parseBoundingBox(jSONObject.getJSONArray(BOUNDING_BOX));
            }
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    if (jSONObject2.getString("type").equals(FEATURE)) {
                        GeoJsonFeature feature = parseFeature(jSONObject2);
                        if (feature != null) {
                            arrayList.add(feature);
                        } else {
                            SentryLogcatAdapter.w(LOG_TAG, "Index of Feature in Feature Collection that could not be created: " + i);
                        }
                    }
                } catch (JSONException unused) {
                    SentryLogcatAdapter.w(LOG_TAG, "Index of Feature in Feature Collection that could not be created: " + i);
                }
            }
            return arrayList;
        } catch (JSONException unused2) {
            SentryLogcatAdapter.w(LOG_TAG, "Feature Collection could not be created.");
            return arrayList;
        }
    }

    public ArrayList<GeoJsonFeature> getFeatures() {
        return this.mGeoJsonFeatures;
    }

    public LatLngBounds getBoundingBox() {
        return this.mBoundingBox;
    }
}
