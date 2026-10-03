package com.henninghall.date_picker;

import ch.qos.logback.core.rolling.helper.DateTokenConverter;
import com.facebook.appevents.UserDataStore;
import com.facebook.hermes.intl.Constants;
import com.salesforce.marketingcloud.push.g;
import java.util.EnumMap;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public class Formats {
    public static EnumMap<Format, String> defaultFormat = mapOf("EEE, MMM d", DateTokenConverter.CONVERTER_KEY, "y");
    private static HashMap<String, EnumMap<Format, String>> map = new HashMap<String, EnumMap<Format, String>>() { // from class: com.henninghall.date_picker.Formats.1
        {
            put("af", Formats.mapOf("EEE d MMM", DateTokenConverter.CONVERTER_KEY, "y"));
            put("am", Formats.mapOf("EEE፣ MMM d", DateTokenConverter.CONVERTER_KEY, "y"));
            put("ar", Formats.mapOf("EEE، d MMM", DateTokenConverter.CONVERTER_KEY, "y"));
            put("ar_DZ", Formats.mapOf("EEE، d MMM", DateTokenConverter.CONVERTER_KEY, "y"));
            put("ar_EG", Formats.mapOf("EEE، d MMM", DateTokenConverter.CONVERTER_KEY, "y"));
            put("az", Formats.mapOf("d MMM, EEE", DateTokenConverter.CONVERTER_KEY, "y"));
            put("be", Formats.mapOf("EEE, d MMM", DateTokenConverter.CONVERTER_KEY, "y"));
            put("bg", Formats.mapOf("EEE, d.MM", DateTokenConverter.CONVERTER_KEY, "y 'г'."));
            put("bn", Formats.mapOf("EEE d MMM", DateTokenConverter.CONVERTER_KEY, "y"));
            put("br", Formats.mapOf("EEE d MMM", DateTokenConverter.CONVERTER_KEY, "y"));
            put("bs", Formats.mapOf("EEE, d. MMM", "d.", "y."));
            put("ca", Formats.mapOf("EEE, d MMM", DateTokenConverter.CONVERTER_KEY, "y"));
            put("chr", Formats.mapOf("EEE, MMM d", DateTokenConverter.CONVERTER_KEY, "y"));
            put("cs", Formats.mapOf("EEE d. M.", "d.", "y"));
            put("cy", Formats.mapOf("EEE, d MMM", DateTokenConverter.CONVERTER_KEY, "y"));
            put("da", Formats.mapOf("EEE d. MMM", "d.", "y"));
            put("de", Formats.mapOf("EEE, d. MMM", DateTokenConverter.CONVERTER_KEY, "y"));
            put("de_AT", Formats.mapOf("EEE, d. MMM", DateTokenConverter.CONVERTER_KEY, "y"));
            put("de_CH", Formats.mapOf("EEE, d. MMM", DateTokenConverter.CONVERTER_KEY, "y"));
            put("el", Formats.mapOf("EEE, d MMM", DateTokenConverter.CONVERTER_KEY, "y"));
            put("en", Formats.mapOf("EEE, MMM d", DateTokenConverter.CONVERTER_KEY, "y"));
            put("en_AU", Formats.mapOf("EEE, d MMM", DateTokenConverter.CONVERTER_KEY, "y"));
            put("en_CA", Formats.mapOf("EEE, MMM d", DateTokenConverter.CONVERTER_KEY, "y"));
            put("en_GB", Formats.mapOf("EEE, d MMM", DateTokenConverter.CONVERTER_KEY, "y"));
            put("en_IE", Formats.mapOf("EEE, d MMM", DateTokenConverter.CONVERTER_KEY, "y"));
            put("en_IN", Formats.mapOf("EEE, d MMM", DateTokenConverter.CONVERTER_KEY, "y"));
            put("en_SG", Formats.mapOf("EEE, d MMM", DateTokenConverter.CONVERTER_KEY, "y"));
            put("en_US", Formats.mapOf("EEE, MMM d", DateTokenConverter.CONVERTER_KEY, "y"));
            put("en_ZA", Formats.mapOf("EEE, dd MMM", DateTokenConverter.CONVERTER_KEY, "y"));
            put("es", Formats.mapOf("EEE, d MMM", DateTokenConverter.CONVERTER_KEY, "y"));
            put("es_419", Formats.mapOf("EEE, d MMM", DateTokenConverter.CONVERTER_KEY, "y"));
            put("es_ES", Formats.mapOf("EEE, d MMM", DateTokenConverter.CONVERTER_KEY, "y"));
            put("es_MX", Formats.mapOf("EEE d 'de' MMM", DateTokenConverter.CONVERTER_KEY, "y"));
            put("es_US", Formats.mapOf("EEE, d 'de' MMM", DateTokenConverter.CONVERTER_KEY, "y"));
            put("et", Formats.mapOf("EEE, d. MMM", DateTokenConverter.CONVERTER_KEY, "y"));
            put("eu", Formats.mapOf("MMM d, EEE", DateTokenConverter.CONVERTER_KEY, "y"));
            put("fa", Formats.mapOf("EEE d LLL", DateTokenConverter.CONVERTER_KEY, "y"));
            put("fi", Formats.mapOf("EEE d. MMM", DateTokenConverter.CONVERTER_KEY, "y"));
            put("fil", Formats.mapOf("EEE, MMM d", DateTokenConverter.CONVERTER_KEY, "y"));
            put("fr", Formats.mapOf("EEE d MMM", DateTokenConverter.CONVERTER_KEY, "y"));
            put("fr_CA", Formats.mapOf("EEE d MMM", DateTokenConverter.CONVERTER_KEY, "y"));
            put("ga", Formats.mapOf("EEE d MMM", DateTokenConverter.CONVERTER_KEY, "y"));
            put("gl", Formats.mapOf("EEE, d 'de' MMM", DateTokenConverter.CONVERTER_KEY, "y"));
            put("gsw", Formats.mapOf("EEE d. MMM", DateTokenConverter.CONVERTER_KEY, "y"));
            put("gu", Formats.mapOf("EEE, d MMM", DateTokenConverter.CONVERTER_KEY, "y"));
            put("haw", Formats.mapOf("EEE, d MMM", DateTokenConverter.CONVERTER_KEY, "y"));
            put("he", Formats.mapOf("EEE, d בMMM", DateTokenConverter.CONVERTER_KEY, "y"));
            put("hi", Formats.mapOf("EEE, d MMM", DateTokenConverter.CONVERTER_KEY, "y"));
            put("hr", Formats.mapOf("EEE, d. MMM", "d.", "y."));
            put("hu", Formats.mapOf("MMM d., EEE", DateTokenConverter.CONVERTER_KEY, "y."));
            put("hy", Formats.mapOf("d MMM, EEE", DateTokenConverter.CONVERTER_KEY, "y"));
            put("id", Formats.mapOf("EEE, d MMM", DateTokenConverter.CONVERTER_KEY, "y"));
            put("in", Formats.mapOf("EEE, d MMM", DateTokenConverter.CONVERTER_KEY, "y"));
            put("is", Formats.mapOf("EEE, d. MMM", DateTokenConverter.CONVERTER_KEY, "y"));
            put(g.h, Formats.mapOf("EEE d MMM", DateTokenConverter.CONVERTER_KEY, "y"));
            put("iw", Formats.mapOf("EEE, d בMMM", DateTokenConverter.CONVERTER_KEY, "y"));
            put("ja", Formats.mapOf("M月d日 EEE", "d日", "y年"));
            put("ka", Formats.mapOf("EEE, d MMM", DateTokenConverter.CONVERTER_KEY, "y"));
            put("kk", Formats.mapOf("d MMM, EEE", DateTokenConverter.CONVERTER_KEY, "y"));
            put("km", Formats.mapOf("EEE d MMM", DateTokenConverter.CONVERTER_KEY, "y"));
            put(Constants.COLLATION_EXTENSION_PARAM_NUMERIC_SHORT, Formats.mapOf("EEE, d MMM", DateTokenConverter.CONVERTER_KEY, "y"));
            put("ko", Formats.mapOf("MMM d일 EEE", "d일", "y년"));
            put("ky", Formats.mapOf("d-MMM, EEE", DateTokenConverter.CONVERTER_KEY, "y"));
            put("lb", Formats.mapOf("EEE d MMM", DateTokenConverter.CONVERTER_KEY, "y"));
            put(UserDataStore.LAST_NAME, Formats.mapOf("EEE d MMM", DateTokenConverter.CONVERTER_KEY, "y"));
            put("lo", Formats.mapOf("EEE d MMM", DateTokenConverter.CONVERTER_KEY, "y"));
            put("lt", Formats.mapOf("MM-dd, EEE", "dd", "y"));
            put("lv", Formats.mapOf("EEE, d. MMM", DateTokenConverter.CONVERTER_KEY, "y. 'g'."));
            put("mk", Formats.mapOf("EEE, d MMM", DateTokenConverter.CONVERTER_KEY, "y"));
            put("ml", Formats.mapOf("MMM d, EEE", DateTokenConverter.CONVERTER_KEY, "y"));
            put("mn", Formats.mapOf("MMM'ын' d. EEE", DateTokenConverter.CONVERTER_KEY, "y"));
            put("mo", Formats.mapOf("EEE, d MMM", DateTokenConverter.CONVERTER_KEY, "y"));
            put("mr", Formats.mapOf("EEE, d MMM", DateTokenConverter.CONVERTER_KEY, "y"));
            put("ms", Formats.mapOf("EEE, d MMM", DateTokenConverter.CONVERTER_KEY, "y"));
            put("mt", Formats.mapOf("EEE, d 'ta'’ MMM", DateTokenConverter.CONVERTER_KEY, "y"));
            put("my", Formats.mapOf("MMM d၊ EEE", DateTokenConverter.CONVERTER_KEY, "y"));
            put("nb", Formats.mapOf("EEE d. MMM", "d.", "y"));
            put("ne", Formats.mapOf("MMM d, EEE", DateTokenConverter.CONVERTER_KEY, "y"));
            put("nl", Formats.mapOf("EEE d MMM", DateTokenConverter.CONVERTER_KEY, "y"));
            put("nn", Formats.mapOf("EEE d. MMM", "d.", "y"));
            put("no", Formats.mapOf("EEE d. MMM", "d.", "y"));
            put("no_NO", Formats.mapOf("EEE d. MMM", "d.", "y"));
            put("or", Formats.mapOf("EEE, MMM d", DateTokenConverter.CONVERTER_KEY, "y"));
            put("pa", Formats.mapOf("EEE, d MMM", DateTokenConverter.CONVERTER_KEY, "y"));
            put("pl", Formats.mapOf("EEE, d MMM", DateTokenConverter.CONVERTER_KEY, "y"));
            put("pt", Formats.mapOf("EEE, d 'de' MMM", DateTokenConverter.CONVERTER_KEY, "y"));
            put("pt_BR", Formats.mapOf("EEE, d 'de' MMM", DateTokenConverter.CONVERTER_KEY, "y"));
            put("pt_PT", Formats.mapOf("EEE, d/MM", DateTokenConverter.CONVERTER_KEY, "y"));
            put("ro", Formats.mapOf("EEE, d MMM", DateTokenConverter.CONVERTER_KEY, "y"));
            put("ru", Formats.mapOf("ccc, d MMM", DateTokenConverter.CONVERTER_KEY, "y"));
            put("sh", Formats.mapOf("EEE d. MMM", DateTokenConverter.CONVERTER_KEY, "y."));
            put("si", Formats.mapOf("MMM d EEE", DateTokenConverter.CONVERTER_KEY, "y"));
            put("sk", Formats.mapOf("EEE d. M.", "d.", "y"));
            put("sl", Formats.mapOf("EEE, d. MMM", "d.", "y"));
            put("sq", Formats.mapOf("EEE, d MMM", DateTokenConverter.CONVERTER_KEY, "y"));
            put("sr", Formats.mapOf("EEE d. MMM", DateTokenConverter.CONVERTER_KEY, "y."));
            put("sr_Latn", Formats.mapOf("EEE d. MMM", DateTokenConverter.CONVERTER_KEY, "y."));
            put("sv", Formats.mapOf("EEE d MMM", DateTokenConverter.CONVERTER_KEY, "y"));
            put("sw", Formats.mapOf("EEE, d MMM", DateTokenConverter.CONVERTER_KEY, "y"));
            put("ta", Formats.mapOf("MMM d, EEE", DateTokenConverter.CONVERTER_KEY, "y"));
            put("te", Formats.mapOf("d MMM, EEE", DateTokenConverter.CONVERTER_KEY, "y"));
            put("th", Formats.mapOf("EEE d MMM", DateTokenConverter.CONVERTER_KEY, "y"));
            put("tl", Formats.mapOf("EEE, MMM d", DateTokenConverter.CONVERTER_KEY, "y"));
            put("tr", Formats.mapOf("d MMMM EEE", DateTokenConverter.CONVERTER_KEY, "y"));
            put("uk", Formats.mapOf("EEE, d MMM", DateTokenConverter.CONVERTER_KEY, "y"));
            put("ur", Formats.mapOf("EEE، d MMM", DateTokenConverter.CONVERTER_KEY, "y"));
            put("uz", Formats.mapOf("EEE, d-MMM", DateTokenConverter.CONVERTER_KEY, "y"));
            put("vi", Formats.mapOf("EEE, d MMM", DateTokenConverter.CONVERTER_KEY, "y"));
            put("zh", Formats.mapOf("M月d日EEE", "d日", "y年"));
            put("zh_CN", Formats.mapOf("M月d日EEE", "d日", "y年"));
            put("zh_HK", Formats.mapOf("M月d日EEE", "d日", "y年"));
            put("zh_TW", Formats.mapOf("M月d日 EEE", "d日", "y年"));
            put("zu", Formats.mapOf("EEE, MMM d", DateTokenConverter.CONVERTER_KEY, "y"));
            put("en_ISO", Formats.mapOf("EEE, MMM d", DateTokenConverter.CONVERTER_KEY, "y"));
            put("en_MY", Formats.mapOf("EEE, d MMM", DateTokenConverter.CONVERTER_KEY, "y"));
            put("fr_CH", Formats.mapOf("EEE d MMM", DateTokenConverter.CONVERTER_KEY, "y"));
            put("it_CH", Formats.mapOf("EEE d MMM", DateTokenConverter.CONVERTER_KEY, "y"));
            put("ps", Formats.mapOf("MMM d, EEE", DateTokenConverter.CONVERTER_KEY, "y"));
        }
    };

    public enum Format {
        MMMEd,
        d,
        y
    }

    public static String get(String str, Format format) throws FormatNotFoundException {
        try {
            return map.get(str).get(format).replaceAll(",", "");
        } catch (NullPointerException unused) {
            throw new FormatNotFoundException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static EnumMap<Format, String> mapOf(String str, String str2, String str3) {
        return new EnumMap<Format, String>(Format.class, str, str2, str3) { // from class: com.henninghall.date_picker.Formats.2
            final /* synthetic */ String val$MMMed;
            final /* synthetic */ String val$d;
            final /* synthetic */ String val$y;

            {
                this.val$MMMed = str;
                this.val$d = str2;
                this.val$y = str3;
                put(Format.MMMEd, str);
                put(Format.d, str2);
                put(Format.y, str3);
            }
        };
    }

    static class FormatNotFoundException extends Exception {
        FormatNotFoundException() {
        }
    }
}
