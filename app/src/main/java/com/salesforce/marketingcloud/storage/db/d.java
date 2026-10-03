package com.salesforce.marketingcloud.storage.db;

import android.content.ContentValues;
import android.database.Cursor;
import androidx.exifinterface.media.ExifInterface;
import com.salesforce.marketingcloud.internal.o;
import com.salesforce.marketingcloud.location.LatLon;
import com.salesforce.marketingcloud.messages.Message;
import com.salesforce.marketingcloud.messages.Region;
import com.salesforce.marketingcloud.messages.inbox.InboxMessage;
import com.salesforce.marketingcloud.registration.Registration;
import com.salesforce.marketingcloud.util.Crypto;
import com.transistorsoft.locationmanager.geofence.TSGeofence;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    static final class a extends Lambda implements Function0<String> {
        public static final a b = new a();

        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return "Failed to read InboxMessage from our local storage.";
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
            return "Unable to read region from DB";
        }
    }

    static final class c extends Lambda implements Function0<String> {
        public static final c b = new c();

        c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return "Unable to create ContentValues for InboxMessage.  Update failed";
        }
    }

    private static final /* synthetic */ <T> T a(Cursor cursor, String str) {
        int columnIndex = cursor.getColumnIndex(str);
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
            T t = (T) cursor.getString(columnIndex);
            Intrinsics.reifiedOperationMarker(1, "T?");
            return t;
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
            T t2 = (T) Integer.valueOf(cursor.getInt(columnIndex));
            Intrinsics.reifiedOperationMarker(1, "T?");
            return t2;
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
            T t3 = (T) Double.valueOf(cursor.getDouble(columnIndex));
            Intrinsics.reifiedOperationMarker(1, "T?");
            return t3;
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
            T t4 = (T) Float.valueOf(cursor.getFloat(columnIndex));
            Intrinsics.reifiedOperationMarker(1, "T?");
            return t4;
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
            T t5 = (T) Long.valueOf(cursor.getLong(columnIndex));
            Intrinsics.reifiedOperationMarker(1, "T?");
            return t5;
        }
        if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
            throw new UnsupportedOperationException("Unsupported type");
        }
        T t6 = (T) Short.valueOf(cursor.getShort(columnIndex));
        Intrinsics.reifiedOperationMarker(1, "T?");
        return t6;
    }

    public static final Region c(@NotNull Cursor cursor, @NotNull Crypto crypto) {
        String string;
        String string2;
        String string3;
        Integer numValueOf;
        String string4;
        Integer numValueOf2;
        Integer numValueOf3;
        Integer numValueOf4;
        String string5;
        String string6;
        Integer numValueOf5;
        boolean z;
        Intrinsics.checkNotNullParameter(cursor, "cursor");
        Intrinsics.checkNotNullParameter(crypto, "crypto");
        try {
            int columnIndex = cursor.getColumnIndex("id");
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                string = cursor.getString(columnIndex);
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                string = (String) Integer.valueOf(cursor.getInt(columnIndex));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                string = (String) Double.valueOf(cursor.getDouble(columnIndex));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                string = (String) Float.valueOf(cursor.getFloat(columnIndex));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                string = (String) Long.valueOf(cursor.getLong(columnIndex));
            } else {
                if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                    throw new UnsupportedOperationException("Unsupported type");
                }
                string = (String) Short.valueOf(cursor.getShort(columnIndex));
            }
            String str = string;
            if (str == null) {
                throw new IllegalStateException("Required value was null.");
            }
            int columnIndex2 = cursor.getColumnIndex("latitude");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(String.class);
            if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class))) {
                string2 = cursor.getString(columnIndex2);
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                string2 = (String) Integer.valueOf(cursor.getInt(columnIndex2));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                string2 = (String) Double.valueOf(cursor.getDouble(columnIndex2));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                string2 = (String) Float.valueOf(cursor.getFloat(columnIndex2));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                string2 = (String) Long.valueOf(cursor.getLong(columnIndex2));
            } else {
                if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                    throw new UnsupportedOperationException("Unsupported type");
                }
                string2 = (String) Short.valueOf(cursor.getShort(columnIndex2));
            }
            String strDecString = crypto.decString(string2);
            if (strDecString == null) {
                throw new IllegalStateException("Required value was null.");
            }
            Intrinsics.checkNotNullExpressionValue(strDecString, "checkNotNull(...)");
            double d = Double.parseDouble(strDecString);
            int columnIndex3 = cursor.getColumnIndex("longitude");
            KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(String.class);
            if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(String.class))) {
                string3 = cursor.getString(columnIndex3);
            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                string3 = (String) Integer.valueOf(cursor.getInt(columnIndex3));
            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                string3 = (String) Double.valueOf(cursor.getDouble(columnIndex3));
            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                string3 = (String) Float.valueOf(cursor.getFloat(columnIndex3));
            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                string3 = (String) Long.valueOf(cursor.getLong(columnIndex3));
            } else {
                if (!Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                    throw new UnsupportedOperationException("Unsupported type");
                }
                string3 = (String) Short.valueOf(cursor.getShort(columnIndex3));
            }
            String strDecString2 = crypto.decString(string3);
            if (strDecString2 == null) {
                throw new IllegalStateException("Required value was null.");
            }
            Intrinsics.checkNotNullExpressionValue(strDecString2, "checkNotNull(...)");
            LatLon latLon = new LatLon(d, Double.parseDouble(strDecString2));
            int columnIndex4 = cursor.getColumnIndex(TSGeofence.FIELD_RADIUS);
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Integer.class);
            if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(String.class))) {
                numValueOf = (Integer) cursor.getString(columnIndex4);
            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                numValueOf = Integer.valueOf(cursor.getInt(columnIndex4));
            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                numValueOf = (Integer) Double.valueOf(cursor.getDouble(columnIndex4));
            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                numValueOf = (Integer) Float.valueOf(cursor.getFloat(columnIndex4));
            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                numValueOf = (Integer) Long.valueOf(cursor.getLong(columnIndex4));
            } else {
                if (!Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                    throw new UnsupportedOperationException("Unsupported type");
                }
                numValueOf = (Integer) Short.valueOf(cursor.getShort(columnIndex4));
            }
            if (numValueOf == null) {
                throw new IllegalStateException("Required value was null.");
            }
            int iIntValue = numValueOf.intValue();
            int columnIndex5 = cursor.getColumnIndex("beacon_guid");
            KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(String.class);
            if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(String.class))) {
                string4 = cursor.getString(columnIndex5);
            } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                string4 = (String) Integer.valueOf(cursor.getInt(columnIndex5));
            } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                string4 = (String) Double.valueOf(cursor.getDouble(columnIndex5));
            } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                string4 = (String) Float.valueOf(cursor.getFloat(columnIndex5));
            } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                string4 = (String) Long.valueOf(cursor.getLong(columnIndex5));
            } else {
                if (!Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                    throw new UnsupportedOperationException("Unsupported type");
                }
                string4 = (String) Short.valueOf(cursor.getShort(columnIndex5));
            }
            String strDecString3 = crypto.decString(string4);
            int columnIndex6 = cursor.getColumnIndex("beacon_major");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Integer.class);
            if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(String.class))) {
                numValueOf2 = (Integer) cursor.getString(columnIndex6);
            } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                numValueOf2 = Integer.valueOf(cursor.getInt(columnIndex6));
            } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                numValueOf2 = (Integer) Double.valueOf(cursor.getDouble(columnIndex6));
            } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                numValueOf2 = (Integer) Float.valueOf(cursor.getFloat(columnIndex6));
            } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                numValueOf2 = (Integer) Long.valueOf(cursor.getLong(columnIndex6));
            } else {
                if (!Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                    throw new UnsupportedOperationException("Unsupported type");
                }
                numValueOf2 = (Integer) Short.valueOf(cursor.getShort(columnIndex6));
            }
            int iIntValue2 = numValueOf2 != null ? numValueOf2.intValue() : 0;
            int columnIndex7 = cursor.getColumnIndex("beacon_minor");
            KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Integer.class);
            if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(String.class))) {
                numValueOf3 = (Integer) cursor.getString(columnIndex7);
            } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                numValueOf3 = Integer.valueOf(cursor.getInt(columnIndex7));
            } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                numValueOf3 = (Integer) Double.valueOf(cursor.getDouble(columnIndex7));
            } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                numValueOf3 = (Integer) Float.valueOf(cursor.getFloat(columnIndex7));
            } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                numValueOf3 = (Integer) Long.valueOf(cursor.getLong(columnIndex7));
            } else {
                if (!Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                    throw new UnsupportedOperationException("Unsupported type");
                }
                numValueOf3 = (Integer) Short.valueOf(cursor.getShort(columnIndex7));
            }
            int iIntValue3 = numValueOf3 != null ? numValueOf3.intValue() : 0;
            int columnIndex8 = cursor.getColumnIndex("location_type");
            KClass orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(Integer.class);
            if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(String.class))) {
                numValueOf4 = (Integer) cursor.getString(columnIndex8);
            } else if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                numValueOf4 = Integer.valueOf(cursor.getInt(columnIndex8));
            } else if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                numValueOf4 = (Integer) Double.valueOf(cursor.getDouble(columnIndex8));
            } else if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                numValueOf4 = (Integer) Float.valueOf(cursor.getFloat(columnIndex8));
            } else if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                numValueOf4 = (Integer) Long.valueOf(cursor.getLong(columnIndex8));
            } else {
                if (!Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                    throw new UnsupportedOperationException("Unsupported type");
                }
                numValueOf4 = (Integer) Short.valueOf(cursor.getShort(columnIndex8));
            }
            if (numValueOf4 == null) {
                throw new IllegalStateException("Required value was null.");
            }
            int iIntValue4 = numValueOf4.intValue();
            int columnIndex9 = cursor.getColumnIndex("name");
            KClass orCreateKotlinClass9 = Reflection.getOrCreateKotlinClass(String.class);
            if (Intrinsics.areEqual(orCreateKotlinClass9, Reflection.getOrCreateKotlinClass(String.class))) {
                string5 = cursor.getString(columnIndex9);
            } else if (Intrinsics.areEqual(orCreateKotlinClass9, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                string5 = (String) Integer.valueOf(cursor.getInt(columnIndex9));
            } else if (Intrinsics.areEqual(orCreateKotlinClass9, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                string5 = (String) Double.valueOf(cursor.getDouble(columnIndex9));
            } else if (Intrinsics.areEqual(orCreateKotlinClass9, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                string5 = (String) Float.valueOf(cursor.getFloat(columnIndex9));
            } else if (Intrinsics.areEqual(orCreateKotlinClass9, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                string5 = (String) Long.valueOf(cursor.getLong(columnIndex9));
            } else {
                if (!Intrinsics.areEqual(orCreateKotlinClass9, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                    throw new UnsupportedOperationException("Unsupported type");
                }
                string5 = (String) Short.valueOf(cursor.getShort(columnIndex9));
            }
            String strDecString4 = crypto.decString(string5);
            int columnIndex10 = cursor.getColumnIndex("description");
            KClass orCreateKotlinClass10 = Reflection.getOrCreateKotlinClass(String.class);
            if (Intrinsics.areEqual(orCreateKotlinClass10, Reflection.getOrCreateKotlinClass(String.class))) {
                string6 = cursor.getString(columnIndex10);
            } else if (Intrinsics.areEqual(orCreateKotlinClass10, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                string6 = (String) Integer.valueOf(cursor.getInt(columnIndex10));
            } else if (Intrinsics.areEqual(orCreateKotlinClass10, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                string6 = (String) Double.valueOf(cursor.getDouble(columnIndex10));
            } else if (Intrinsics.areEqual(orCreateKotlinClass10, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                string6 = (String) Float.valueOf(cursor.getFloat(columnIndex10));
            } else if (Intrinsics.areEqual(orCreateKotlinClass10, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                string6 = (String) Long.valueOf(cursor.getLong(columnIndex10));
            } else {
                if (!Intrinsics.areEqual(orCreateKotlinClass10, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                    throw new UnsupportedOperationException("Unsupported type");
                }
                string6 = (String) Short.valueOf(cursor.getShort(columnIndex10));
            }
            Region region = new Region(str, latLon, iIntValue, strDecString3, iIntValue2, iIntValue3, iIntValue4, strDecString4, crypto.decString(string6), null, 512, null);
            int columnIndex11 = cursor.getColumnIndex("is_inside");
            KClass orCreateKotlinClass11 = Reflection.getOrCreateKotlinClass(Integer.class);
            if (Intrinsics.areEqual(orCreateKotlinClass11, Reflection.getOrCreateKotlinClass(String.class))) {
                numValueOf5 = (Integer) cursor.getString(columnIndex11);
            } else if (Intrinsics.areEqual(orCreateKotlinClass11, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                numValueOf5 = Integer.valueOf(cursor.getInt(columnIndex11));
            } else if (Intrinsics.areEqual(orCreateKotlinClass11, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                numValueOf5 = (Integer) Double.valueOf(cursor.getDouble(columnIndex11));
            } else if (Intrinsics.areEqual(orCreateKotlinClass11, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                numValueOf5 = (Integer) Float.valueOf(cursor.getFloat(columnIndex11));
            } else if (Intrinsics.areEqual(orCreateKotlinClass11, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                numValueOf5 = (Integer) Long.valueOf(cursor.getLong(columnIndex11));
            } else {
                if (!Intrinsics.areEqual(orCreateKotlinClass11, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                    throw new UnsupportedOperationException("Unsupported type");
                }
                numValueOf5 = (Integer) Short.valueOf(cursor.getShort(columnIndex11));
            }
            if (numValueOf5 != null) {
                z = true;
                if (numValueOf5.intValue() == 1) {
                }
                region.setInside$sdk_release(z);
                return region;
            }
            z = false;
            region.setInside$sdk_release(z);
            return region;
        } catch (Exception e) {
            com.salesforce.marketingcloud.g gVar = com.salesforce.marketingcloud.g.a;
            String TAG = j.g;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            gVar.b(TAG, e, b.b);
            return null;
        }
    }

    public static final InboxMessage a(@NotNull Cursor cursor, @NotNull Crypto crypto) {
        String string;
        Integer numValueOf;
        Integer numValueOf2;
        Integer numValueOf3;
        Intrinsics.checkNotNullParameter(cursor, "cursor");
        Intrinsics.checkNotNullParameter(crypto, "crypto");
        try {
            int columnIndex = cursor.getColumnIndex("message_json");
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                string = cursor.getString(columnIndex);
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                string = (String) Integer.valueOf(cursor.getInt(columnIndex));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                string = (String) Double.valueOf(cursor.getDouble(columnIndex));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                string = (String) Float.valueOf(cursor.getFloat(columnIndex));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                string = (String) Long.valueOf(cursor.getLong(columnIndex));
            } else {
                if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                    throw new UnsupportedOperationException("Unsupported type");
                }
                string = (String) Short.valueOf(cursor.getShort(columnIndex));
            }
            String strDecString = crypto.decString(string);
            if (strDecString != null) {
                boolean z = false;
                InboxMessage inboxMessage = new InboxMessage(new JSONObject(strDecString), false, 2, null);
                int columnIndex2 = cursor.getColumnIndex("is_deleted");
                KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Integer.class);
                if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class))) {
                    numValueOf = (Integer) cursor.getString(columnIndex2);
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                    numValueOf = Integer.valueOf(cursor.getInt(columnIndex2));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    numValueOf = (Integer) Double.valueOf(cursor.getDouble(columnIndex2));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    numValueOf = (Integer) Float.valueOf(cursor.getFloat(columnIndex2));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    numValueOf = (Integer) Long.valueOf(cursor.getLong(columnIndex2));
                } else {
                    if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                        throw new UnsupportedOperationException("Unsupported type");
                    }
                    numValueOf = (Integer) Short.valueOf(cursor.getShort(columnIndex2));
                }
                inboxMessage.setDeleted(numValueOf != null && numValueOf.intValue() == 1);
                int columnIndex3 = cursor.getColumnIndex("is_read");
                KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Integer.class);
                if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(String.class))) {
                    numValueOf2 = (Integer) cursor.getString(columnIndex3);
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                    numValueOf2 = Integer.valueOf(cursor.getInt(columnIndex3));
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    numValueOf2 = (Integer) Double.valueOf(cursor.getDouble(columnIndex3));
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    numValueOf2 = (Integer) Float.valueOf(cursor.getFloat(columnIndex3));
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    numValueOf2 = (Integer) Long.valueOf(cursor.getLong(columnIndex3));
                } else {
                    if (!Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                        throw new UnsupportedOperationException("Unsupported type");
                    }
                    numValueOf2 = (Integer) Short.valueOf(cursor.getShort(columnIndex3));
                }
                inboxMessage.setRead(numValueOf2 != null && numValueOf2.intValue() == 1);
                int columnIndex4 = cursor.getColumnIndex("is_dirty");
                KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Integer.class);
                if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(String.class))) {
                    numValueOf3 = (Integer) cursor.getString(columnIndex4);
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                    numValueOf3 = Integer.valueOf(cursor.getInt(columnIndex4));
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    numValueOf3 = (Integer) Double.valueOf(cursor.getDouble(columnIndex4));
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    numValueOf3 = (Integer) Float.valueOf(cursor.getFloat(columnIndex4));
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    numValueOf3 = (Integer) Long.valueOf(cursor.getLong(columnIndex4));
                } else {
                    if (!Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                        throw new UnsupportedOperationException("Unsupported type");
                    }
                    numValueOf3 = (Integer) Short.valueOf(cursor.getShort(columnIndex4));
                }
                if (numValueOf3 != null && numValueOf3.intValue() == 1) {
                    z = true;
                }
                inboxMessage.setDirty$sdk_release(z);
                return inboxMessage;
            }
            throw new IllegalStateException("Required value was null.");
        } catch (Exception e) {
            com.salesforce.marketingcloud.g gVar = com.salesforce.marketingcloud.g.a;
            String TAG = g.f;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            gVar.b(TAG, e, a.b);
            return null;
        }
    }

    public static final Message b(@NotNull Cursor cursor, @NotNull Crypto crypto) {
        String string;
        String string2;
        String string3;
        String string4;
        String string5;
        String string6;
        String string7;
        String string8;
        Integer numValueOf;
        Integer numValueOf2;
        String string9;
        Integer numValueOf3;
        Integer numValueOf4;
        Integer numValueOf5;
        Integer numValueOf6;
        Integer numValueOf7;
        Integer numValueOf8;
        String string10;
        String string11;
        String string12;
        Integer numValueOf9;
        String string13;
        String string14;
        Integer numValueOf10;
        Integer numValueOf11;
        Intrinsics.checkNotNullParameter(cursor, "cursor");
        Intrinsics.checkNotNullParameter(crypto, "crypto");
        try {
            int columnIndex = cursor.getColumnIndex("id");
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                string = cursor.getString(columnIndex);
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                string = (String) Integer.valueOf(cursor.getInt(columnIndex));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                string = (String) Double.valueOf(cursor.getDouble(columnIndex));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                string = (String) Float.valueOf(cursor.getFloat(columnIndex));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                string = (String) Long.valueOf(cursor.getLong(columnIndex));
            } else {
                if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                    throw new UnsupportedOperationException("Unsupported type");
                }
                string = (String) Short.valueOf(cursor.getShort(columnIndex));
            }
            String str = string;
            if (str != null) {
                int columnIndex2 = cursor.getColumnIndex("title");
                KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(String.class);
                if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class))) {
                    string2 = cursor.getString(columnIndex2);
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                    string2 = (String) Integer.valueOf(cursor.getInt(columnIndex2));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    string2 = (String) Double.valueOf(cursor.getDouble(columnIndex2));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    string2 = (String) Float.valueOf(cursor.getFloat(columnIndex2));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    string2 = (String) Long.valueOf(cursor.getLong(columnIndex2));
                } else {
                    if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                        throw new UnsupportedOperationException("Unsupported type");
                    }
                    string2 = (String) Short.valueOf(cursor.getShort(columnIndex2));
                }
                String strDecString = crypto.decString(string2);
                int columnIndex3 = cursor.getColumnIndex("alert");
                KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(String.class);
                if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(String.class))) {
                    string3 = cursor.getString(columnIndex3);
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                    string3 = (String) Integer.valueOf(cursor.getInt(columnIndex3));
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    string3 = (String) Double.valueOf(cursor.getDouble(columnIndex3));
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    string3 = (String) Float.valueOf(cursor.getFloat(columnIndex3));
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    string3 = (String) Long.valueOf(cursor.getLong(columnIndex3));
                } else {
                    if (!Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                        throw new UnsupportedOperationException("Unsupported type");
                    }
                    string3 = (String) Short.valueOf(cursor.getShort(columnIndex3));
                }
                String strDecString2 = crypto.decString(string3);
                if (strDecString2 != null) {
                    Intrinsics.checkNotNullExpressionValue(strDecString2, "checkNotNull(...)");
                    int columnIndex4 = cursor.getColumnIndex("sound");
                    KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(String.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(String.class))) {
                        string4 = cursor.getString(columnIndex4);
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                        string4 = (String) Integer.valueOf(cursor.getInt(columnIndex4));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                        string4 = (String) Double.valueOf(cursor.getDouble(columnIndex4));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                        string4 = (String) Float.valueOf(cursor.getFloat(columnIndex4));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        string4 = (String) Long.valueOf(cursor.getLong(columnIndex4));
                    } else {
                        if (!Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                            throw new UnsupportedOperationException("Unsupported type");
                        }
                        string4 = (String) Short.valueOf(cursor.getShort(columnIndex4));
                    }
                    String str2 = string4;
                    int columnIndex5 = cursor.getColumnIndex(i.a.e);
                    KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(String.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(String.class))) {
                        string5 = cursor.getString(columnIndex5);
                    } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                        string5 = (String) Integer.valueOf(cursor.getInt(columnIndex5));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                        string5 = (String) Double.valueOf(cursor.getDouble(columnIndex5));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                        string5 = (String) Float.valueOf(cursor.getFloat(columnIndex5));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        string5 = (String) Long.valueOf(cursor.getLong(columnIndex5));
                    } else {
                        if (!Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                            throw new UnsupportedOperationException("Unsupported type");
                        }
                        string5 = (String) Short.valueOf(cursor.getShort(columnIndex5));
                    }
                    String strDecString3 = crypto.decString(string5);
                    int columnIndex6 = cursor.getColumnIndex(i.a.f);
                    KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(String.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(String.class))) {
                        string6 = cursor.getString(columnIndex6);
                    } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                        string6 = (String) Integer.valueOf(cursor.getInt(columnIndex6));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                        string6 = (String) Double.valueOf(cursor.getDouble(columnIndex6));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                        string6 = (String) Float.valueOf(cursor.getFloat(columnIndex6));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        string6 = (String) Long.valueOf(cursor.getLong(columnIndex6));
                    } else {
                        if (!Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                            throw new UnsupportedOperationException("Unsupported type");
                        }
                        string6 = (String) Short.valueOf(cursor.getShort(columnIndex6));
                    }
                    String strDecString4 = crypto.decString(string6);
                    Message.Media media = (strDecString3 == null && strDecString4 == null) ? null : new Message.Media(strDecString3, strDecString4);
                    int columnIndex7 = cursor.getColumnIndex("start_date");
                    KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(String.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(String.class))) {
                        string7 = cursor.getString(columnIndex7);
                    } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                        string7 = (String) Integer.valueOf(cursor.getInt(columnIndex7));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                        string7 = (String) Double.valueOf(cursor.getDouble(columnIndex7));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                        string7 = (String) Float.valueOf(cursor.getFloat(columnIndex7));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        string7 = (String) Long.valueOf(cursor.getLong(columnIndex7));
                    } else {
                        if (!Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                            throw new UnsupportedOperationException("Unsupported type");
                        }
                        string7 = (String) Short.valueOf(cursor.getShort(columnIndex7));
                    }
                    Date dateA = string7 != null ? o.a(string7) : null;
                    int columnIndex8 = cursor.getColumnIndex("end_date");
                    KClass orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(String.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(String.class))) {
                        string8 = cursor.getString(columnIndex8);
                    } else if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                        string8 = (String) Integer.valueOf(cursor.getInt(columnIndex8));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                        string8 = (String) Double.valueOf(cursor.getDouble(columnIndex8));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                        string8 = (String) Float.valueOf(cursor.getFloat(columnIndex8));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        string8 = (String) Long.valueOf(cursor.getLong(columnIndex8));
                    } else {
                        if (!Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                            throw new UnsupportedOperationException("Unsupported type");
                        }
                        string8 = (String) Short.valueOf(cursor.getShort(columnIndex8));
                    }
                    Date dateA2 = string8 != null ? o.a(string8) : null;
                    int columnIndex9 = cursor.getColumnIndex("message_type");
                    KClass orCreateKotlinClass9 = Reflection.getOrCreateKotlinClass(Integer.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass9, Reflection.getOrCreateKotlinClass(String.class))) {
                        numValueOf = (Integer) cursor.getString(columnIndex9);
                    } else if (Intrinsics.areEqual(orCreateKotlinClass9, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                        numValueOf = Integer.valueOf(cursor.getInt(columnIndex9));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass9, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                        numValueOf = (Integer) Double.valueOf(cursor.getDouble(columnIndex9));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass9, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                        numValueOf = (Integer) Float.valueOf(cursor.getFloat(columnIndex9));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass9, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        numValueOf = (Integer) Long.valueOf(cursor.getLong(columnIndex9));
                    } else {
                        if (!Intrinsics.areEqual(orCreateKotlinClass9, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                            throw new UnsupportedOperationException("Unsupported type");
                        }
                        numValueOf = (Integer) Short.valueOf(cursor.getShort(columnIndex9));
                    }
                    if (numValueOf != null) {
                        int iIntValue = numValueOf.intValue();
                        int columnIndex10 = cursor.getColumnIndex("content_type");
                        KClass orCreateKotlinClass10 = Reflection.getOrCreateKotlinClass(Integer.class);
                        if (Intrinsics.areEqual(orCreateKotlinClass10, Reflection.getOrCreateKotlinClass(String.class))) {
                            numValueOf2 = (Integer) cursor.getString(columnIndex10);
                        } else if (Intrinsics.areEqual(orCreateKotlinClass10, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                            numValueOf2 = Integer.valueOf(cursor.getInt(columnIndex10));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass10, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                            numValueOf2 = (Integer) Double.valueOf(cursor.getDouble(columnIndex10));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass10, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                            numValueOf2 = (Integer) Float.valueOf(cursor.getFloat(columnIndex10));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass10, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                            numValueOf2 = (Integer) Long.valueOf(cursor.getLong(columnIndex10));
                        } else {
                            if (!Intrinsics.areEqual(orCreateKotlinClass10, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                                throw new UnsupportedOperationException("Unsupported type");
                            }
                            numValueOf2 = (Integer) Short.valueOf(cursor.getShort(columnIndex10));
                        }
                        if (numValueOf2 != null) {
                            int iIntValue2 = numValueOf2.intValue();
                            int columnIndex11 = cursor.getColumnIndex("url");
                            KClass orCreateKotlinClass11 = Reflection.getOrCreateKotlinClass(String.class);
                            if (Intrinsics.areEqual(orCreateKotlinClass11, Reflection.getOrCreateKotlinClass(String.class))) {
                                string9 = cursor.getString(columnIndex11);
                            } else if (Intrinsics.areEqual(orCreateKotlinClass11, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                                string9 = (String) Integer.valueOf(cursor.getInt(columnIndex11));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass11, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                string9 = (String) Double.valueOf(cursor.getDouble(columnIndex11));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass11, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                string9 = (String) Float.valueOf(cursor.getFloat(columnIndex11));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass11, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                string9 = (String) Long.valueOf(cursor.getLong(columnIndex11));
                            } else {
                                if (!Intrinsics.areEqual(orCreateKotlinClass11, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                                    throw new UnsupportedOperationException("Unsupported type");
                                }
                                string9 = (String) Short.valueOf(cursor.getShort(columnIndex11));
                            }
                            String strDecString5 = crypto.decString(string9);
                            int columnIndex12 = cursor.getColumnIndex(i.a.w);
                            KClass orCreateKotlinClass12 = Reflection.getOrCreateKotlinClass(Integer.class);
                            if (Intrinsics.areEqual(orCreateKotlinClass12, Reflection.getOrCreateKotlinClass(String.class))) {
                                numValueOf3 = (Integer) cursor.getString(columnIndex12);
                            } else if (Intrinsics.areEqual(orCreateKotlinClass12, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                                numValueOf3 = Integer.valueOf(cursor.getInt(columnIndex12));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass12, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                numValueOf3 = (Integer) Double.valueOf(cursor.getDouble(columnIndex12));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass12, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                numValueOf3 = (Integer) Float.valueOf(cursor.getFloat(columnIndex12));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass12, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                numValueOf3 = (Integer) Long.valueOf(cursor.getLong(columnIndex12));
                            } else {
                                if (!Intrinsics.areEqual(orCreateKotlinClass12, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                                    throw new UnsupportedOperationException("Unsupported type");
                                }
                                numValueOf3 = (Integer) Short.valueOf(cursor.getShort(columnIndex12));
                            }
                            int iIntValue3 = numValueOf3 != null ? numValueOf3.intValue() : -1;
                            int columnIndex13 = cursor.getColumnIndex(i.a.v);
                            KClass orCreateKotlinClass13 = Reflection.getOrCreateKotlinClass(Integer.class);
                            if (Intrinsics.areEqual(orCreateKotlinClass13, Reflection.getOrCreateKotlinClass(String.class))) {
                                numValueOf4 = (Integer) cursor.getString(columnIndex13);
                            } else if (Intrinsics.areEqual(orCreateKotlinClass13, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                                numValueOf4 = Integer.valueOf(cursor.getInt(columnIndex13));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass13, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                numValueOf4 = (Integer) Double.valueOf(cursor.getDouble(columnIndex13));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass13, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                numValueOf4 = (Integer) Float.valueOf(cursor.getFloat(columnIndex13));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass13, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                numValueOf4 = (Integer) Long.valueOf(cursor.getLong(columnIndex13));
                            } else {
                                if (!Intrinsics.areEqual(orCreateKotlinClass13, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                                    throw new UnsupportedOperationException("Unsupported type");
                                }
                                numValueOf4 = (Integer) Short.valueOf(cursor.getShort(columnIndex13));
                            }
                            int iIntValue4 = numValueOf4 != null ? numValueOf4.intValue() : -1;
                            int columnIndex14 = cursor.getColumnIndex(i.a.u);
                            KClass orCreateKotlinClass14 = Reflection.getOrCreateKotlinClass(Integer.class);
                            if (Intrinsics.areEqual(orCreateKotlinClass14, Reflection.getOrCreateKotlinClass(String.class))) {
                                numValueOf5 = (Integer) cursor.getString(columnIndex14);
                            } else if (Intrinsics.areEqual(orCreateKotlinClass14, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                                numValueOf5 = Integer.valueOf(cursor.getInt(columnIndex14));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass14, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                numValueOf5 = (Integer) Double.valueOf(cursor.getDouble(columnIndex14));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass14, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                numValueOf5 = (Integer) Float.valueOf(cursor.getFloat(columnIndex14));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass14, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                numValueOf5 = (Integer) Long.valueOf(cursor.getLong(columnIndex14));
                            } else {
                                if (!Intrinsics.areEqual(orCreateKotlinClass14, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                                    throw new UnsupportedOperationException("Unsupported type");
                                }
                                numValueOf5 = (Integer) Short.valueOf(cursor.getShort(columnIndex14));
                            }
                            int iIntValue5 = numValueOf5 != null ? numValueOf5.intValue() : 0;
                            int columnIndex15 = cursor.getColumnIndex(i.a.t);
                            KClass orCreateKotlinClass15 = Reflection.getOrCreateKotlinClass(Integer.class);
                            if (Intrinsics.areEqual(orCreateKotlinClass15, Reflection.getOrCreateKotlinClass(String.class))) {
                                numValueOf6 = (Integer) cursor.getString(columnIndex15);
                            } else if (Intrinsics.areEqual(orCreateKotlinClass15, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                                numValueOf6 = Integer.valueOf(cursor.getInt(columnIndex15));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass15, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                numValueOf6 = (Integer) Double.valueOf(cursor.getDouble(columnIndex15));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass15, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                numValueOf6 = (Integer) Float.valueOf(cursor.getFloat(columnIndex15));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass15, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                numValueOf6 = (Integer) Long.valueOf(cursor.getLong(columnIndex15));
                            } else {
                                if (!Intrinsics.areEqual(orCreateKotlinClass15, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                                    throw new UnsupportedOperationException("Unsupported type");
                                }
                                numValueOf6 = (Integer) Short.valueOf(cursor.getShort(columnIndex15));
                            }
                            boolean z = numValueOf6 != null && numValueOf6.intValue() == 1;
                            int columnIndex16 = cursor.getColumnIndex(i.a.s);
                            KClass orCreateKotlinClass16 = Reflection.getOrCreateKotlinClass(Integer.class);
                            if (Intrinsics.areEqual(orCreateKotlinClass16, Reflection.getOrCreateKotlinClass(String.class))) {
                                numValueOf7 = (Integer) cursor.getString(columnIndex16);
                            } else if (Intrinsics.areEqual(orCreateKotlinClass16, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                                numValueOf7 = Integer.valueOf(cursor.getInt(columnIndex16));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass16, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                numValueOf7 = (Integer) Double.valueOf(cursor.getDouble(columnIndex16));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass16, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                numValueOf7 = (Integer) Float.valueOf(cursor.getFloat(columnIndex16));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass16, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                numValueOf7 = (Integer) Long.valueOf(cursor.getLong(columnIndex16));
                            } else {
                                if (!Intrinsics.areEqual(orCreateKotlinClass16, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                                    throw new UnsupportedOperationException("Unsupported type");
                                }
                                numValueOf7 = (Integer) Short.valueOf(cursor.getShort(columnIndex16));
                            }
                            int iIntValue6 = numValueOf7 != null ? numValueOf7.intValue() : -1;
                            int columnIndex17 = cursor.getColumnIndex(i.a.x);
                            KClass orCreateKotlinClass17 = Reflection.getOrCreateKotlinClass(Integer.class);
                            if (Intrinsics.areEqual(orCreateKotlinClass17, Reflection.getOrCreateKotlinClass(String.class))) {
                                numValueOf8 = (Integer) cursor.getString(columnIndex17);
                            } else if (Intrinsics.areEqual(orCreateKotlinClass17, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                                numValueOf8 = Integer.valueOf(cursor.getInt(columnIndex17));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass17, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                numValueOf8 = (Integer) Double.valueOf(cursor.getDouble(columnIndex17));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass17, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                numValueOf8 = (Integer) Float.valueOf(cursor.getFloat(columnIndex17));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass17, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                numValueOf8 = (Integer) Long.valueOf(cursor.getLong(columnIndex17));
                            } else {
                                if (!Intrinsics.areEqual(orCreateKotlinClass17, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                                    throw new UnsupportedOperationException("Unsupported type");
                                }
                                numValueOf8 = (Integer) Short.valueOf(cursor.getShort(columnIndex17));
                            }
                            int iIntValue7 = numValueOf8 != null ? numValueOf8.intValue() : 0;
                            int columnIndex18 = cursor.getColumnIndex(i.a.g);
                            KClass orCreateKotlinClass18 = Reflection.getOrCreateKotlinClass(String.class);
                            if (Intrinsics.areEqual(orCreateKotlinClass18, Reflection.getOrCreateKotlinClass(String.class))) {
                                string10 = cursor.getString(columnIndex18);
                            } else if (Intrinsics.areEqual(orCreateKotlinClass18, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                                string10 = (String) Integer.valueOf(cursor.getInt(columnIndex18));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass18, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                string10 = (String) Double.valueOf(cursor.getDouble(columnIndex18));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass18, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                string10 = (String) Float.valueOf(cursor.getFloat(columnIndex18));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass18, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                string10 = (String) Long.valueOf(cursor.getLong(columnIndex18));
                            } else {
                                if (!Intrinsics.areEqual(orCreateKotlinClass18, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                                    throw new UnsupportedOperationException("Unsupported type");
                                }
                                string10 = (String) Short.valueOf(cursor.getShort(columnIndex18));
                            }
                            String strDecString6 = crypto.decString(string10);
                            int columnIndex19 = cursor.getColumnIndex("keys");
                            KClass orCreateKotlinClass19 = Reflection.getOrCreateKotlinClass(String.class);
                            if (Intrinsics.areEqual(orCreateKotlinClass19, Reflection.getOrCreateKotlinClass(String.class))) {
                                string11 = cursor.getString(columnIndex19);
                            } else if (Intrinsics.areEqual(orCreateKotlinClass19, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                                string11 = (String) Integer.valueOf(cursor.getInt(columnIndex19));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass19, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                string11 = (String) Double.valueOf(cursor.getDouble(columnIndex19));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass19, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                string11 = (String) Float.valueOf(cursor.getFloat(columnIndex19));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass19, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                string11 = (String) Long.valueOf(cursor.getLong(columnIndex19));
                            } else {
                                if (!Intrinsics.areEqual(orCreateKotlinClass19, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                                    throw new UnsupportedOperationException("Unsupported type");
                                }
                                string11 = (String) Short.valueOf(cursor.getShort(columnIndex19));
                            }
                            String strDecString7 = crypto.decString(string11);
                            Map<String, String> mapB = strDecString7 != null ? com.salesforce.marketingcloud.util.j.b(strDecString7) : null;
                            int columnIndex20 = cursor.getColumnIndex("custom");
                            KClass orCreateKotlinClass20 = Reflection.getOrCreateKotlinClass(String.class);
                            if (Intrinsics.areEqual(orCreateKotlinClass20, Reflection.getOrCreateKotlinClass(String.class))) {
                                string12 = cursor.getString(columnIndex20);
                            } else if (Intrinsics.areEqual(orCreateKotlinClass20, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                                string12 = (String) Integer.valueOf(cursor.getInt(columnIndex20));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass20, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                string12 = (String) Double.valueOf(cursor.getDouble(columnIndex20));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass20, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                string12 = (String) Float.valueOf(cursor.getFloat(columnIndex20));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass20, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                string12 = (String) Long.valueOf(cursor.getLong(columnIndex20));
                            } else {
                                if (!Intrinsics.areEqual(orCreateKotlinClass20, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                                    throw new UnsupportedOperationException("Unsupported type");
                                }
                                string12 = (String) Short.valueOf(cursor.getShort(columnIndex20));
                            }
                            Message message = new Message(str, strDecString, strDecString2, str2, media, dateA, dateA2, iIntValue, iIntValue2, strDecString5, iIntValue3, iIntValue4, iIntValue5, z, iIntValue6, iIntValue7, strDecString6, mapB, crypto.decString(string12));
                            int columnIndex21 = cursor.getColumnIndex(i.a.y);
                            KClass orCreateKotlinClass21 = Reflection.getOrCreateKotlinClass(Integer.class);
                            if (Intrinsics.areEqual(orCreateKotlinClass21, Reflection.getOrCreateKotlinClass(String.class))) {
                                numValueOf9 = (Integer) cursor.getString(columnIndex21);
                            } else if (Intrinsics.areEqual(orCreateKotlinClass21, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                                numValueOf9 = Integer.valueOf(cursor.getInt(columnIndex21));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass21, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                numValueOf9 = (Integer) Double.valueOf(cursor.getDouble(columnIndex21));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass21, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                numValueOf9 = (Integer) Float.valueOf(cursor.getFloat(columnIndex21));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass21, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                numValueOf9 = (Integer) Long.valueOf(cursor.getLong(columnIndex21));
                            } else {
                                if (!Intrinsics.areEqual(orCreateKotlinClass21, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                                    throw new UnsupportedOperationException("Unsupported type");
                                }
                                numValueOf9 = (Integer) Short.valueOf(cursor.getShort(columnIndex21));
                            }
                            message.setNotificationId$sdk_release(numValueOf9 != null ? numValueOf9.intValue() : -1);
                            int columnIndex22 = cursor.getColumnIndex(i.a.q);
                            KClass orCreateKotlinClass22 = Reflection.getOrCreateKotlinClass(String.class);
                            if (Intrinsics.areEqual(orCreateKotlinClass22, Reflection.getOrCreateKotlinClass(String.class))) {
                                string13 = cursor.getString(columnIndex22);
                            } else if (Intrinsics.areEqual(orCreateKotlinClass22, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                                string13 = (String) Integer.valueOf(cursor.getInt(columnIndex22));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass22, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                string13 = (String) Double.valueOf(cursor.getDouble(columnIndex22));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass22, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                string13 = (String) Float.valueOf(cursor.getFloat(columnIndex22));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass22, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                string13 = (String) Long.valueOf(cursor.getLong(columnIndex22));
                            } else {
                                if (!Intrinsics.areEqual(orCreateKotlinClass22, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                                    throw new UnsupportedOperationException("Unsupported type");
                                }
                                string13 = (String) Short.valueOf(cursor.getShort(columnIndex22));
                            }
                            message.setLastShownDate$sdk_release(string13 != null ? o.a(string13) : null);
                            int columnIndex23 = cursor.getColumnIndex(i.a.r);
                            KClass orCreateKotlinClass23 = Reflection.getOrCreateKotlinClass(String.class);
                            if (Intrinsics.areEqual(orCreateKotlinClass23, Reflection.getOrCreateKotlinClass(String.class))) {
                                string14 = cursor.getString(columnIndex23);
                            } else if (Intrinsics.areEqual(orCreateKotlinClass23, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                                string14 = (String) Integer.valueOf(cursor.getInt(columnIndex23));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass23, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                string14 = (String) Double.valueOf(cursor.getDouble(columnIndex23));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass23, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                string14 = (String) Float.valueOf(cursor.getFloat(columnIndex23));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass23, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                string14 = (String) Long.valueOf(cursor.getLong(columnIndex23));
                            } else {
                                if (!Intrinsics.areEqual(orCreateKotlinClass23, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                                    throw new UnsupportedOperationException("Unsupported type");
                                }
                                string14 = (String) Short.valueOf(cursor.getShort(columnIndex23));
                            }
                            message.setNextAllowedShow$sdk_release(string14 != null ? o.a(string14) : null);
                            int columnIndex24 = cursor.getColumnIndex(i.a.f90o);
                            KClass orCreateKotlinClass24 = Reflection.getOrCreateKotlinClass(Integer.class);
                            if (Intrinsics.areEqual(orCreateKotlinClass24, Reflection.getOrCreateKotlinClass(String.class))) {
                                numValueOf10 = (Integer) cursor.getString(columnIndex24);
                            } else if (Intrinsics.areEqual(orCreateKotlinClass24, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                                numValueOf10 = Integer.valueOf(cursor.getInt(columnIndex24));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass24, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                numValueOf10 = (Integer) Double.valueOf(cursor.getDouble(columnIndex24));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass24, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                numValueOf10 = (Integer) Float.valueOf(cursor.getFloat(columnIndex24));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass24, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                numValueOf10 = (Integer) Long.valueOf(cursor.getLong(columnIndex24));
                            } else {
                                if (!Intrinsics.areEqual(orCreateKotlinClass24, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                                    throw new UnsupportedOperationException("Unsupported type");
                                }
                                numValueOf10 = (Integer) Short.valueOf(cursor.getShort(columnIndex24));
                            }
                            message.setPeriodShowCount$sdk_release(numValueOf10 != null ? numValueOf10.intValue() : 0);
                            int columnIndex25 = cursor.getColumnIndex(i.a.p);
                            KClass orCreateKotlinClass25 = Reflection.getOrCreateKotlinClass(Integer.class);
                            if (Intrinsics.areEqual(orCreateKotlinClass25, Reflection.getOrCreateKotlinClass(String.class))) {
                                numValueOf11 = (Integer) cursor.getString(columnIndex25);
                            } else if (Intrinsics.areEqual(orCreateKotlinClass25, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                                numValueOf11 = Integer.valueOf(cursor.getInt(columnIndex25));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass25, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                numValueOf11 = (Integer) Double.valueOf(cursor.getDouble(columnIndex25));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass25, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                numValueOf11 = (Integer) Float.valueOf(cursor.getFloat(columnIndex25));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass25, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                numValueOf11 = (Integer) Long.valueOf(cursor.getLong(columnIndex25));
                            } else {
                                if (!Intrinsics.areEqual(orCreateKotlinClass25, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                                    throw new UnsupportedOperationException("Unsupported type");
                                }
                                numValueOf11 = (Integer) Short.valueOf(cursor.getShort(columnIndex25));
                            }
                            message.setShowCount$sdk_release(numValueOf11 != null ? numValueOf11.intValue() : 0);
                            return message;
                        }
                        throw new IllegalStateException("Required value was null.");
                    }
                    throw new IllegalStateException("Required value was null.");
                }
                throw new IllegalStateException("Required value was null.");
            }
            throw new IllegalStateException("Required value was null.");
        } catch (Exception unused) {
            return null;
        }
    }

    public static final Registration d(@NotNull Cursor cursor, @NotNull Crypto crypto) throws Exception {
        Integer numValueOf;
        String string;
        String string2;
        String string3;
        String string4;
        String string5;
        String string6;
        Integer numValueOf2;
        Integer numValueOf3;
        Integer numValueOf4;
        String string7;
        Integer numValueOf5;
        Integer numValueOf6;
        String string8;
        String string9;
        String string10;
        String string11;
        String string12;
        String string13;
        String string14;
        Intrinsics.checkNotNullParameter(cursor, "cursor");
        Intrinsics.checkNotNullParameter(crypto, "crypto");
        int columnIndex = cursor.getColumnIndex("id");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Integer.class);
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
            numValueOf = (Integer) cursor.getString(columnIndex);
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
            numValueOf = Integer.valueOf(cursor.getInt(columnIndex));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
            numValueOf = (Integer) Double.valueOf(cursor.getDouble(columnIndex));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
            numValueOf = (Integer) Float.valueOf(cursor.getFloat(columnIndex));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
            numValueOf = (Integer) Long.valueOf(cursor.getLong(columnIndex));
        } else {
            if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                throw new UnsupportedOperationException("Unsupported type");
            }
            numValueOf = (Integer) Short.valueOf(cursor.getShort(columnIndex));
        }
        int iIntValue = numValueOf != null ? numValueOf.intValue() : 0;
        int columnIndex2 = cursor.getColumnIndex("uuid");
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(String.class);
        if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class))) {
            string = cursor.getString(columnIndex2);
        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
            string = (String) Integer.valueOf(cursor.getInt(columnIndex2));
        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
            string = (String) Double.valueOf(cursor.getDouble(columnIndex2));
        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
            string = (String) Float.valueOf(cursor.getFloat(columnIndex2));
        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
            string = (String) Long.valueOf(cursor.getLong(columnIndex2));
        } else {
            if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                throw new UnsupportedOperationException("Unsupported type");
            }
            string = (String) Short.valueOf(cursor.getShort(columnIndex2));
        }
        String str = string;
        if (str != null) {
            int columnIndex3 = cursor.getColumnIndex(k.a.s);
            KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(String.class);
            if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(String.class))) {
                string2 = cursor.getString(columnIndex3);
            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                string2 = (String) Integer.valueOf(cursor.getInt(columnIndex3));
            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                string2 = (String) Double.valueOf(cursor.getDouble(columnIndex3));
            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                string2 = (String) Float.valueOf(cursor.getFloat(columnIndex3));
            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                string2 = (String) Long.valueOf(cursor.getLong(columnIndex3));
            } else {
                if (!Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                    throw new UnsupportedOperationException("Unsupported type");
                }
                string2 = (String) Short.valueOf(cursor.getShort(columnIndex3));
            }
            String strDecString = crypto.decString(string2);
            int columnIndex4 = cursor.getColumnIndex(k.a.p);
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(String.class);
            if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(String.class))) {
                string3 = cursor.getString(columnIndex4);
            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                string3 = (String) Integer.valueOf(cursor.getInt(columnIndex4));
            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                string3 = (String) Double.valueOf(cursor.getDouble(columnIndex4));
            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                string3 = (String) Float.valueOf(cursor.getFloat(columnIndex4));
            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                string3 = (String) Long.valueOf(cursor.getLong(columnIndex4));
            } else {
                if (!Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                    throw new UnsupportedOperationException("Unsupported type");
                }
                string3 = (String) Short.valueOf(cursor.getShort(columnIndex4));
            }
            String str2 = string3;
            if (str2 != null) {
                int columnIndex5 = cursor.getColumnIndex(k.a.f92o);
                KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(String.class);
                if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(String.class))) {
                    string4 = cursor.getString(columnIndex5);
                } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                    string4 = (String) Integer.valueOf(cursor.getInt(columnIndex5));
                } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    string4 = (String) Double.valueOf(cursor.getDouble(columnIndex5));
                } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    string4 = (String) Float.valueOf(cursor.getFloat(columnIndex5));
                } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    string4 = (String) Long.valueOf(cursor.getLong(columnIndex5));
                } else {
                    if (!Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                        throw new UnsupportedOperationException("Unsupported type");
                    }
                    string4 = (String) Short.valueOf(cursor.getShort(columnIndex5));
                }
                String strDecString2 = crypto.decString(string4);
                int columnIndex6 = cursor.getColumnIndex(k.a.r);
                KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(String.class);
                if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(String.class))) {
                    string5 = cursor.getString(columnIndex6);
                } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                    string5 = (String) Integer.valueOf(cursor.getInt(columnIndex6));
                } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    string5 = (String) Double.valueOf(cursor.getDouble(columnIndex6));
                } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    string5 = (String) Float.valueOf(cursor.getFloat(columnIndex6));
                } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    string5 = (String) Long.valueOf(cursor.getLong(columnIndex6));
                } else {
                    if (!Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                        throw new UnsupportedOperationException("Unsupported type");
                    }
                    string5 = (String) Short.valueOf(cursor.getShort(columnIndex6));
                }
                String str3 = string5;
                if (str3 != null) {
                    int columnIndex7 = cursor.getColumnIndex("app_version");
                    KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(String.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(String.class))) {
                        string6 = cursor.getString(columnIndex7);
                    } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                        string6 = (String) Integer.valueOf(cursor.getInt(columnIndex7));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                        string6 = (String) Double.valueOf(cursor.getDouble(columnIndex7));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                        string6 = (String) Float.valueOf(cursor.getFloat(columnIndex7));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        string6 = (String) Long.valueOf(cursor.getLong(columnIndex7));
                    } else {
                        if (!Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                            throw new UnsupportedOperationException("Unsupported type");
                        }
                        string6 = (String) Short.valueOf(cursor.getShort(columnIndex7));
                    }
                    String str4 = string6;
                    if (str4 != null) {
                        int columnIndex8 = cursor.getColumnIndex(k.a.f);
                        KClass orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(Integer.class);
                        if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(String.class))) {
                            numValueOf2 = (Integer) cursor.getString(columnIndex8);
                        } else if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                            numValueOf2 = Integer.valueOf(cursor.getInt(columnIndex8));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                            numValueOf2 = (Integer) Double.valueOf(cursor.getDouble(columnIndex8));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                            numValueOf2 = (Integer) Float.valueOf(cursor.getFloat(columnIndex8));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                            numValueOf2 = (Integer) Long.valueOf(cursor.getLong(columnIndex8));
                        } else {
                            if (!Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                                throw new UnsupportedOperationException("Unsupported type");
                            }
                            numValueOf2 = (Integer) Short.valueOf(cursor.getShort(columnIndex8));
                        }
                        boolean z = numValueOf2 != null && numValueOf2.intValue() == 1;
                        int columnIndex9 = cursor.getColumnIndex(k.a.k);
                        KClass orCreateKotlinClass9 = Reflection.getOrCreateKotlinClass(Integer.class);
                        if (Intrinsics.areEqual(orCreateKotlinClass9, Reflection.getOrCreateKotlinClass(String.class))) {
                            numValueOf3 = (Integer) cursor.getString(columnIndex9);
                        } else if (Intrinsics.areEqual(orCreateKotlinClass9, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                            numValueOf3 = Integer.valueOf(cursor.getInt(columnIndex9));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass9, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                            numValueOf3 = (Integer) Double.valueOf(cursor.getDouble(columnIndex9));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass9, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                            numValueOf3 = (Integer) Float.valueOf(cursor.getFloat(columnIndex9));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass9, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                            numValueOf3 = (Integer) Long.valueOf(cursor.getLong(columnIndex9));
                        } else {
                            if (!Intrinsics.areEqual(orCreateKotlinClass9, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                                throw new UnsupportedOperationException("Unsupported type");
                            }
                            numValueOf3 = (Integer) Short.valueOf(cursor.getShort(columnIndex9));
                        }
                        boolean z2 = numValueOf3 != null && numValueOf3.intValue() == 1;
                        int columnIndex10 = cursor.getColumnIndex(k.a.l);
                        KClass orCreateKotlinClass10 = Reflection.getOrCreateKotlinClass(Integer.class);
                        if (Intrinsics.areEqual(orCreateKotlinClass10, Reflection.getOrCreateKotlinClass(String.class))) {
                            numValueOf4 = (Integer) cursor.getString(columnIndex10);
                        } else if (Intrinsics.areEqual(orCreateKotlinClass10, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                            numValueOf4 = Integer.valueOf(cursor.getInt(columnIndex10));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass10, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                            numValueOf4 = (Integer) Double.valueOf(cursor.getDouble(columnIndex10));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass10, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                            numValueOf4 = (Integer) Float.valueOf(cursor.getFloat(columnIndex10));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass10, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                            numValueOf4 = (Integer) Long.valueOf(cursor.getLong(columnIndex10));
                        } else {
                            if (!Intrinsics.areEqual(orCreateKotlinClass10, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                                throw new UnsupportedOperationException("Unsupported type");
                            }
                            numValueOf4 = (Integer) Short.valueOf(cursor.getShort(columnIndex10));
                        }
                        boolean z3 = numValueOf4 != null && numValueOf4.intValue() == 1;
                        int columnIndex11 = cursor.getColumnIndex(k.a.i);
                        KClass orCreateKotlinClass11 = Reflection.getOrCreateKotlinClass(String.class);
                        if (Intrinsics.areEqual(orCreateKotlinClass11, Reflection.getOrCreateKotlinClass(String.class))) {
                            string7 = cursor.getString(columnIndex11);
                        } else if (Intrinsics.areEqual(orCreateKotlinClass11, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                            string7 = (String) Integer.valueOf(cursor.getInt(columnIndex11));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass11, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                            string7 = (String) Double.valueOf(cursor.getDouble(columnIndex11));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass11, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                            string7 = (String) Float.valueOf(cursor.getFloat(columnIndex11));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass11, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                            string7 = (String) Long.valueOf(cursor.getLong(columnIndex11));
                        } else {
                            if (!Intrinsics.areEqual(orCreateKotlinClass11, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                                throw new UnsupportedOperationException("Unsupported type");
                            }
                            string7 = (String) Short.valueOf(cursor.getShort(columnIndex11));
                        }
                        if (string7 != null) {
                            int columnIndex12 = cursor.getColumnIndex(k.a.j);
                            KClass orCreateKotlinClass12 = Reflection.getOrCreateKotlinClass(Integer.class);
                            if (Intrinsics.areEqual(orCreateKotlinClass12, Reflection.getOrCreateKotlinClass(String.class))) {
                                numValueOf5 = (Integer) cursor.getString(columnIndex12);
                            } else if (Intrinsics.areEqual(orCreateKotlinClass12, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                                numValueOf5 = Integer.valueOf(cursor.getInt(columnIndex12));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass12, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                numValueOf5 = (Integer) Double.valueOf(cursor.getDouble(columnIndex12));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass12, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                numValueOf5 = (Integer) Float.valueOf(cursor.getFloat(columnIndex12));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass12, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                numValueOf5 = (Integer) Long.valueOf(cursor.getLong(columnIndex12));
                            } else {
                                if (!Intrinsics.areEqual(orCreateKotlinClass12, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                                    throw new UnsupportedOperationException("Unsupported type");
                                }
                                numValueOf5 = (Integer) Short.valueOf(cursor.getShort(columnIndex12));
                            }
                            boolean z4 = numValueOf5 != null && numValueOf5.intValue() == 1;
                            int columnIndex13 = cursor.getColumnIndex("timezone");
                            KClass orCreateKotlinClass13 = Reflection.getOrCreateKotlinClass(Integer.class);
                            if (Intrinsics.areEqual(orCreateKotlinClass13, Reflection.getOrCreateKotlinClass(String.class))) {
                                numValueOf6 = (Integer) cursor.getString(columnIndex13);
                            } else if (Intrinsics.areEqual(orCreateKotlinClass13, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                                numValueOf6 = Integer.valueOf(cursor.getInt(columnIndex13));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass13, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                numValueOf6 = (Integer) Double.valueOf(cursor.getDouble(columnIndex13));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass13, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                numValueOf6 = (Integer) Float.valueOf(cursor.getFloat(columnIndex13));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass13, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                numValueOf6 = (Integer) Long.valueOf(cursor.getLong(columnIndex13));
                            } else {
                                if (!Intrinsics.areEqual(orCreateKotlinClass13, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                                    throw new UnsupportedOperationException("Unsupported type");
                                }
                                numValueOf6 = (Integer) Short.valueOf(cursor.getShort(columnIndex13));
                            }
                            if (numValueOf6 != null) {
                                int iIntValue2 = numValueOf6.intValue();
                                int columnIndex14 = cursor.getColumnIndex(k.a.c);
                                KClass orCreateKotlinClass14 = Reflection.getOrCreateKotlinClass(String.class);
                                if (Intrinsics.areEqual(orCreateKotlinClass14, Reflection.getOrCreateKotlinClass(String.class))) {
                                    string8 = cursor.getString(columnIndex14);
                                } else if (Intrinsics.areEqual(orCreateKotlinClass14, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                                    string8 = (String) Integer.valueOf(cursor.getInt(columnIndex14));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass14, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                    string8 = (String) Double.valueOf(cursor.getDouble(columnIndex14));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass14, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                    string8 = (String) Float.valueOf(cursor.getFloat(columnIndex14));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass14, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                    string8 = (String) Long.valueOf(cursor.getLong(columnIndex14));
                                } else {
                                    if (!Intrinsics.areEqual(orCreateKotlinClass14, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                                        throw new UnsupportedOperationException("Unsupported type");
                                    }
                                    string8 = (String) Short.valueOf(cursor.getShort(columnIndex14));
                                }
                                String strDecString3 = crypto.decString(string8);
                                int columnIndex15 = cursor.getColumnIndex("platform");
                                KClass orCreateKotlinClass15 = Reflection.getOrCreateKotlinClass(String.class);
                                if (Intrinsics.areEqual(orCreateKotlinClass15, Reflection.getOrCreateKotlinClass(String.class))) {
                                    string9 = cursor.getString(columnIndex15);
                                } else if (Intrinsics.areEqual(orCreateKotlinClass15, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                                    string9 = (String) Integer.valueOf(cursor.getInt(columnIndex15));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass15, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                    string9 = (String) Double.valueOf(cursor.getDouble(columnIndex15));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass15, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                    string9 = (String) Float.valueOf(cursor.getFloat(columnIndex15));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass15, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                    string9 = (String) Long.valueOf(cursor.getLong(columnIndex15));
                                } else {
                                    if (!Intrinsics.areEqual(orCreateKotlinClass15, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                                        throw new UnsupportedOperationException("Unsupported type");
                                    }
                                    string9 = (String) Short.valueOf(cursor.getShort(columnIndex15));
                                }
                                if (string9 != null) {
                                    int columnIndex16 = cursor.getColumnIndex(k.a.m);
                                    KClass orCreateKotlinClass16 = Reflection.getOrCreateKotlinClass(String.class);
                                    String str5 = string9;
                                    if (Intrinsics.areEqual(orCreateKotlinClass16, Reflection.getOrCreateKotlinClass(String.class))) {
                                        string10 = cursor.getString(columnIndex16);
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass16, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                                        string10 = (String) Integer.valueOf(cursor.getInt(columnIndex16));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass16, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                        string10 = (String) Double.valueOf(cursor.getDouble(columnIndex16));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass16, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                        string10 = (String) Float.valueOf(cursor.getFloat(columnIndex16));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass16, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                        string10 = (String) Long.valueOf(cursor.getLong(columnIndex16));
                                    } else {
                                        if (!Intrinsics.areEqual(orCreateKotlinClass16, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                                            throw new UnsupportedOperationException("Unsupported type");
                                        }
                                        string10 = (String) Short.valueOf(cursor.getShort(columnIndex16));
                                    }
                                    if (string10 != null) {
                                        int columnIndex17 = cursor.getColumnIndex(k.a.d);
                                        KClass orCreateKotlinClass17 = Reflection.getOrCreateKotlinClass(String.class);
                                        String str6 = string10;
                                        if (Intrinsics.areEqual(orCreateKotlinClass17, Reflection.getOrCreateKotlinClass(String.class))) {
                                            string11 = cursor.getString(columnIndex17);
                                        } else if (Intrinsics.areEqual(orCreateKotlinClass17, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                                            string11 = (String) Integer.valueOf(cursor.getInt(columnIndex17));
                                        } else if (Intrinsics.areEqual(orCreateKotlinClass17, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                            string11 = (String) Double.valueOf(cursor.getDouble(columnIndex17));
                                        } else if (Intrinsics.areEqual(orCreateKotlinClass17, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                            string11 = (String) Float.valueOf(cursor.getFloat(columnIndex17));
                                        } else if (Intrinsics.areEqual(orCreateKotlinClass17, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                            string11 = (String) Long.valueOf(cursor.getLong(columnIndex17));
                                        } else {
                                            if (!Intrinsics.areEqual(orCreateKotlinClass17, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                                                throw new UnsupportedOperationException("Unsupported type");
                                            }
                                            string11 = (String) Short.valueOf(cursor.getShort(columnIndex17));
                                        }
                                        String strDecString4 = crypto.decString(string11);
                                        if (strDecString4 != null) {
                                            Intrinsics.checkNotNullExpressionValue(strDecString4, "checkNotNull(...)");
                                            int columnIndex18 = cursor.getColumnIndex("locale");
                                            KClass orCreateKotlinClass18 = Reflection.getOrCreateKotlinClass(String.class);
                                            if (Intrinsics.areEqual(orCreateKotlinClass18, Reflection.getOrCreateKotlinClass(String.class))) {
                                                string12 = cursor.getString(columnIndex18);
                                            } else if (Intrinsics.areEqual(orCreateKotlinClass18, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                                                string12 = (String) Integer.valueOf(cursor.getInt(columnIndex18));
                                            } else if (Intrinsics.areEqual(orCreateKotlinClass18, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                                string12 = (String) Double.valueOf(cursor.getDouble(columnIndex18));
                                            } else if (Intrinsics.areEqual(orCreateKotlinClass18, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                                string12 = (String) Float.valueOf(cursor.getFloat(columnIndex18));
                                            } else if (Intrinsics.areEqual(orCreateKotlinClass18, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                                string12 = (String) Long.valueOf(cursor.getLong(columnIndex18));
                                            } else {
                                                if (!Intrinsics.areEqual(orCreateKotlinClass18, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                                                    throw new UnsupportedOperationException("Unsupported type");
                                                }
                                                string12 = (String) Short.valueOf(cursor.getShort(columnIndex18));
                                            }
                                            if (string12 != null) {
                                                int columnIndex19 = cursor.getColumnIndex("tags");
                                                KClass orCreateKotlinClass19 = Reflection.getOrCreateKotlinClass(String.class);
                                                String str7 = string12;
                                                if (Intrinsics.areEqual(orCreateKotlinClass19, Reflection.getOrCreateKotlinClass(String.class))) {
                                                    string13 = cursor.getString(columnIndex19);
                                                } else if (Intrinsics.areEqual(orCreateKotlinClass19, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                                                    string13 = (String) Integer.valueOf(cursor.getInt(columnIndex19));
                                                } else if (Intrinsics.areEqual(orCreateKotlinClass19, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                                    string13 = (String) Double.valueOf(cursor.getDouble(columnIndex19));
                                                } else if (Intrinsics.areEqual(orCreateKotlinClass19, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                                    string13 = (String) Float.valueOf(cursor.getFloat(columnIndex19));
                                                } else if (Intrinsics.areEqual(orCreateKotlinClass19, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                                    string13 = (String) Long.valueOf(cursor.getLong(columnIndex19));
                                                } else {
                                                    if (!Intrinsics.areEqual(orCreateKotlinClass19, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                                                        throw new UnsupportedOperationException("Unsupported type");
                                                    }
                                                    string13 = (String) Short.valueOf(cursor.getShort(columnIndex19));
                                                }
                                                String strDecString5 = crypto.decString(string13);
                                                if (strDecString5 != null) {
                                                    Set<String> setC = com.salesforce.marketingcloud.util.j.c(strDecString5);
                                                    Intrinsics.checkNotNullExpressionValue(setC, "deserializeTags(...)");
                                                    int columnIndex20 = cursor.getColumnIndex("attributes");
                                                    KClass orCreateKotlinClass20 = Reflection.getOrCreateKotlinClass(String.class);
                                                    if (Intrinsics.areEqual(orCreateKotlinClass20, Reflection.getOrCreateKotlinClass(String.class))) {
                                                        string14 = cursor.getString(columnIndex20);
                                                    } else if (Intrinsics.areEqual(orCreateKotlinClass20, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                                                        string14 = (String) Integer.valueOf(cursor.getInt(columnIndex20));
                                                    } else if (Intrinsics.areEqual(orCreateKotlinClass20, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                                        string14 = (String) Double.valueOf(cursor.getDouble(columnIndex20));
                                                    } else if (Intrinsics.areEqual(orCreateKotlinClass20, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                                        string14 = (String) Float.valueOf(cursor.getFloat(columnIndex20));
                                                    } else if (Intrinsics.areEqual(orCreateKotlinClass20, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                                        string14 = (String) Long.valueOf(cursor.getLong(columnIndex20));
                                                    } else {
                                                        if (!Intrinsics.areEqual(orCreateKotlinClass20, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                                                            throw new UnsupportedOperationException("Unsupported type");
                                                        }
                                                        string14 = (String) Short.valueOf(cursor.getShort(columnIndex20));
                                                    }
                                                    String strDecString6 = crypto.decString(string14);
                                                    if (strDecString6 != null) {
                                                        Map<String, String> mapB = com.salesforce.marketingcloud.util.j.b(strDecString6);
                                                        Intrinsics.checkNotNullExpressionValue(mapB, "deserializeKeys(...)");
                                                        return new Registration(iIntValue, str, strDecString, str2, strDecString2, str3, str4, z, z2, z3, string7, z4, iIntValue2, strDecString3, str5, str6, strDecString4, str7, setC, mapB);
                                                    }
                                                    throw new IllegalStateException("Required value was null.");
                                                }
                                                throw new IllegalStateException("Required value was null.");
                                            }
                                            throw new IllegalStateException("Required value was null.");
                                        }
                                        throw new IllegalStateException("Required value was null.");
                                    }
                                    throw new IllegalStateException("Required value was null.");
                                }
                                throw new IllegalStateException("Required value was null.");
                            }
                            throw new IllegalStateException("Required value was null.");
                        }
                        throw new IllegalStateException("Required value was null.");
                    }
                    throw new IllegalStateException("Required value was null.");
                }
                throw new IllegalStateException("Required value was null.");
            }
            throw new IllegalStateException("Required value was null.");
        }
        throw new IllegalStateException("Required value was null.");
    }

    public static final ContentValues a(@NotNull InboxMessage message, @NotNull Crypto crypto) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(crypto, "crypto");
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", message.id);
            Date date = message.startDateUtc;
            contentValues.put("start_date", date != null ? Long.valueOf(date.getTime()) : null);
            Date date2 = message.endDateUtc;
            contentValues.put("end_date", date2 != null ? Long.valueOf(date2.getTime()) : null);
            contentValues.put("is_read", Integer.valueOf(message.getRead() ? 1 : 0));
            contentValues.put("is_deleted", Integer.valueOf(message.getDeleted() ? 1 : 0));
            contentValues.put("message_type", message.messageType);
            contentValues.put("message_hash", message.getMessageHash$sdk_release());
            contentValues.put("message_json", crypto.encString(message.toJson$sdk_release().toString()));
            if (message.getDirty$sdk_release()) {
                contentValues.put("is_dirty", (Integer) 1);
            }
            return contentValues;
        } catch (Exception e) {
            com.salesforce.marketingcloud.g gVar = com.salesforce.marketingcloud.g.a;
            String TAG = g.f;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            gVar.b(TAG, e, c.b);
            return null;
        }
    }

    public static final String b(@NotNull Cursor cursor, @NotNull String columnName) {
        Intrinsics.checkNotNullParameter(cursor, "cursor");
        Intrinsics.checkNotNullParameter(columnName, "columnName");
        return cursor.getString(cursor.getColumnIndex(columnName));
    }
}
