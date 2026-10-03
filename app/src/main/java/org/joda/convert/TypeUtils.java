package org.joda.convert;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import ch.qos.logback.classic.spi.CallerData;
import io.sentry.profilemeasurements.ProfileMeasurement;
import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes6.dex */
final class TypeUtils {
    private static final String EXTENDS = "? extends ";
    private static final Map<String, Class<?>> PRIMITIVES;
    private static final String SUPER = "? super ";

    static {
        HashMap map = new HashMap();
        map.put(ProfileMeasurement.UNIT_BYTES, Byte.TYPE);
        map.put("short", Short.TYPE);
        map.put("int", Integer.TYPE);
        map.put("long", Long.TYPE);
        map.put(TypedValues.Custom.S_BOOLEAN, Boolean.TYPE);
        map.put("char", Character.TYPE);
        map.put(TypedValues.Custom.S_FLOAT, Float.TYPE);
        map.put("double", Double.TYPE);
        PRIMITIVES = Collections.unmodifiableMap(map);
    }

    private TypeUtils() {
    }

    static Type parse(String str) {
        try {
            return doParse(str);
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    private static Type doParse(String str) throws Exception {
        Object objDoParse;
        Class<?> cls = PRIMITIVES.get(str);
        if (cls != null) {
            return cls;
        }
        int iIndexOf = str.indexOf(60);
        if (iIndexOf < 0) {
            return StringConvert.loadType(str);
        }
        int iLastIndexOf = str.lastIndexOf(62);
        Class<?> clsLoadType = StringConvert.loadType(str.substring(0, iIndexOf));
        List<String> listSplit = split(str.substring(iIndexOf + 1, iLastIndexOf));
        ArrayList arrayList = new ArrayList();
        for (String str2 : listSplit) {
            if (str2.startsWith(EXTENDS)) {
                objDoParse = wildExtendsType(doParse(str2.substring(10)));
            } else if (str2.startsWith(SUPER)) {
                objDoParse = wildSuperType(doParse(str2.substring(8)));
            } else if (str2.equals(CallerData.NA)) {
                objDoParse = wildExtendsType(Object.class);
            } else if (str2.endsWith(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI)) {
                objDoParse = Array.newInstance(StringConvert.loadType(str2.substring(0, str2.length() - 2)), 0).getClass();
            } else if (str2.startsWith("[L") && str2.endsWith(";")) {
                objDoParse = Array.newInstance(StringConvert.loadType(str2.substring(2, str2.length() - 1)), 0).getClass();
            } else {
                objDoParse = doParse(str2);
            }
            arrayList.add(objDoParse);
        }
        return newParameterizedType(clsLoadType, (Type[]) arrayList.toArray(new Type[arrayList.size()]));
    }

    private static List<String> split(String str) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < str.length(); i3++) {
            if (str.charAt(i3) == ',' && i2 == 0) {
                arrayList.add(str.substring(i, i3).trim());
                i = i3 + 1;
            } else if (str.charAt(i3) == '<') {
                i2++;
            } else if (str.charAt(i3) == '>') {
                i2--;
            }
        }
        arrayList.add(str.substring(i).trim());
        return arrayList;
    }

    private static Type wildExtendsType(Type type) throws Exception {
        return Types.subtypeOf(type);
    }

    private static Type wildSuperType(Type type) throws Exception {
        return Types.supertypeOf(type);
    }

    private static ParameterizedType newParameterizedType(Class<?> cls, Type... typeArr) throws Exception {
        return Types.newParameterizedType(cls, typeArr);
    }
}
