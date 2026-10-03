package org.joda.time.tz;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.joda.time.DateTimeUtils;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultNameProvider implements NameProvider {
    private HashMap<Locale, Map<String, Map<String, Object>>> iByLocaleCache = createCache();
    private HashMap<Locale, Map<String, Map<Boolean, Object>>> iByLocaleCache2 = createCache();

    @Override // org.joda.time.tz.NameProvider
    public String getShortName(Locale locale, String str, String str2) {
        String[] nameSet = getNameSet(locale, str, str2);
        if (nameSet == null) {
            return null;
        }
        return nameSet[0];
    }

    @Override // org.joda.time.tz.NameProvider
    public String getName(Locale locale, String str, String str2) {
        String[] nameSet = getNameSet(locale, str, str2);
        if (nameSet == null) {
            return null;
        }
        return nameSet[1];
    }

    private String[] getNameSet(Locale locale, String str, String str2) {
        String[] strArr;
        synchronized (this) {
            String[] strArr2 = null;
            if (locale == null || str == null || str2 == null) {
                return null;
            }
            Map map = this.iByLocaleCache.get(locale);
            if (map == null) {
                HashMap<Locale, Map<String, Map<String, Object>>> map2 = this.iByLocaleCache;
                HashMap mapCreateCache = createCache();
                map2.put(locale, mapCreateCache);
                map = mapCreateCache;
            }
            Map mapCreateCache2 = (Map) map.get(str);
            if (mapCreateCache2 == null) {
                mapCreateCache2 = createCache();
                map.put(str, mapCreateCache2);
                String[][] zoneStrings = DateTimeUtils.getDateFormatSymbols(Locale.ENGLISH).getZoneStrings();
                int length = zoneStrings.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        strArr = null;
                        break;
                    }
                    strArr = zoneStrings[i];
                    if (strArr != null && strArr.length >= 5 && str.equals(strArr[0])) {
                        break;
                    }
                    i++;
                }
                for (String[] strArr3 : DateTimeUtils.getDateFormatSymbols(locale).getZoneStrings()) {
                    if (strArr3 != null && strArr3.length >= 5 && str.equals(strArr3[0])) {
                        strArr2 = strArr3;
                        break;
                    }
                }
                if (strArr != null && strArr2 != null) {
                    mapCreateCache2.put(strArr[2], new String[]{strArr2[2], strArr2[1]});
                    if (strArr[2].equals(strArr[4])) {
                        mapCreateCache2.put(strArr[4] + "-Summer", new String[]{strArr2[4], strArr2[3]});
                    } else {
                        mapCreateCache2.put(strArr[4], new String[]{strArr2[4], strArr2[3]});
                    }
                }
            }
            return (String[]) mapCreateCache2.get(str2);
        }
    }

    public String getShortName(Locale locale, String str, String str2, boolean z) {
        String[] nameSet = getNameSet(locale, str, str2, z);
        if (nameSet == null) {
            return null;
        }
        return nameSet[0];
    }

    public String getName(Locale locale, String str, String str2, boolean z) {
        String[] nameSet = getNameSet(locale, str, str2, z);
        if (nameSet == null) {
            return null;
        }
        return nameSet[1];
    }

    private String[] getNameSet(Locale locale, String str, String str2, boolean z) {
        String[] strArr;
        synchronized (this) {
            String[] strArr2 = null;
            if (locale == null || str == null || str2 == null) {
                return null;
            }
            if (str.startsWith("Etc/")) {
                str = str.substring(4);
            }
            Map<String, Map<Boolean, Object>> map = this.iByLocaleCache2.get(locale);
            if (map == null) {
                HashMap<Locale, Map<String, Map<Boolean, Object>>> map2 = this.iByLocaleCache2;
                HashMap mapCreateCache = createCache();
                map2.put(locale, mapCreateCache);
                map = mapCreateCache;
            }
            Map<Boolean, Object> mapCreateCache2 = map.get(str);
            if (mapCreateCache2 == null) {
                mapCreateCache2 = createCache();
                map.put(str, mapCreateCache2);
                String[][] zoneStrings = DateTimeUtils.getDateFormatSymbols(Locale.ENGLISH).getZoneStrings();
                int length = zoneStrings.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        strArr = null;
                        break;
                    }
                    strArr = zoneStrings[i];
                    if (strArr != null && strArr.length >= 5 && str.equals(strArr[0])) {
                        break;
                    }
                    i++;
                }
                for (String[] strArr3 : DateTimeUtils.getDateFormatSymbols(locale).getZoneStrings()) {
                    if (strArr3 != null && strArr3.length >= 5 && str.equals(strArr3[0])) {
                        strArr2 = strArr3;
                        break;
                    }
                }
                if (strArr != null && strArr2 != null) {
                    mapCreateCache2.put(Boolean.TRUE, new String[]{strArr2[2], strArr2[1]});
                    mapCreateCache2.put(Boolean.FALSE, new String[]{strArr2[4], strArr2[3]});
                }
            }
            return (String[]) mapCreateCache2.get(Boolean.valueOf(z));
        }
    }

    private HashMap createCache() {
        return new HashMap(7);
    }
}
