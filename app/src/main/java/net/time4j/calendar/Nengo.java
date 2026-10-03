package net.time4j.calendar;

import androidx.core.text.util.LocalePreferences;
import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.net.SyslogConstants;
import com.salesforce.marketingcloud.analytics.stats.b;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.io.StreamCorruptedException;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.text.Typography;
import net.time4j.PlainDate;
import net.time4j.base.ResourceLoader;
import net.time4j.engine.AttributeKey;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.CalendarDate;
import net.time4j.engine.CalendarEra;
import net.time4j.engine.ChronoCondition;
import net.time4j.engine.ChronoDisplay;
import net.time4j.engine.ChronoException;
import net.time4j.engine.EpochDays;
import net.time4j.format.Attributes;
import net.time4j.format.CalendarText;
import net.time4j.format.Leniency;
import net.time4j.format.TextElement;
import net.time4j.format.TextWidth;
import net.time4j.format.expert.Iso8601Format;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: classes6.dex */
public final class Nengo implements CalendarEra, Serializable {
    private static final Map<String, Nengo> CHINESE_TO_NENGO;
    private static final byte COURT_NORTHERN = 1;
    private static final byte COURT_SOUTHERN = -1;
    private static final byte COURT_STANDARD = 0;
    public static final Nengo HEISEI;
    private static final Map<String, Nengo> KANJI_TO_NENGO;
    private static final TST KOREAN_TO_NENGO;
    public static final Nengo MEIJI;
    private static final String[] MODERN_KEYS;
    private static final Nengo[] MODERN_NENGOS;
    private static final Nengo NENGO_KENMU;
    private static final Nengo NENGO_OEI;
    public static final Nengo NEWEST;
    private static final String NEW_ERA_PROPERTY = "net.time4j.calendar.japanese.supplemental.era";
    private static final Nengo[] NORTHERN_NENGOS;
    private static final Nengo[] OFFICIAL_NENGOS;
    public static final Nengo REIWA;
    private static final TST ROMAJI_TO_NENGO;
    private static final TST RUSSIAN_TO_NENGO;
    public static final AttributeKey<Selector> SELECTOR;
    public static final Nengo SHOWA;
    public static final Nengo TAISHO;
    private static final long serialVersionUID = 5696395761628504723L;
    private final transient String chinese;
    private final byte court;
    private final int index;
    private final transient String kanji;
    private final transient String korean;
    private final transient int relgregyear;
    private final transient String romaji;
    private final transient String russian;
    private final transient long start;

    /* JADX WARN: Code duplicated, block: B:100:0x0247  */
    /* JADX WARN: Code duplicated, block: B:124:0x02eb  */
    /* JADX WARN: Code duplicated, block: B:153:0x014d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:156:0x01ef A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:157:0x020f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:159:0x024f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:165:0x024f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:18:0x0087  */
    /* JADX WARN: Code duplicated, block: B:25:0x00a1 A[Catch: EOFException -> 0x00ca, IOException -> 0x0188, TRY_ENTER, TRY_LEAVE, TryCatch #3 {IOException -> 0x0188, blocks: (B:4:0x0041, B:7:0x0050, B:9:0x0057, B:11:0x0071, B:13:0x0077, B:15:0x007d, B:19:0x0089, B:22:0x0096, B:25:0x00a1, B:41:0x0107, B:43:0x010c, B:48:0x011a, B:50:0x0125, B:51:0x0131, B:53:0x0137, B:55:0x013f, B:57:0x014d, B:58:0x016c, B:30:0x00d7, B:32:0x00ee), top: B:137:0x0041 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:35:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:36:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:38:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:39:0x0103  */
    /* JADX WARN: Code duplicated, block: B:43:0x010c A[Catch: EOFException -> 0x0116, IOException -> 0x0188, TryCatch #3 {IOException -> 0x0188, blocks: (B:4:0x0041, B:7:0x0050, B:9:0x0057, B:11:0x0071, B:13:0x0077, B:15:0x007d, B:19:0x0089, B:22:0x0096, B:25:0x00a1, B:41:0x0107, B:43:0x010c, B:48:0x011a, B:50:0x0125, B:51:0x0131, B:53:0x0137, B:55:0x013f, B:57:0x014d, B:58:0x016c, B:30:0x00d7, B:32:0x00ee), top: B:137:0x0041 }] */
    /* JADX WARN: Code duplicated, block: B:48:0x011a A[Catch: EOFException -> 0x0116, IOException -> 0x0188, TryCatch #3 {IOException -> 0x0188, blocks: (B:4:0x0041, B:7:0x0050, B:9:0x0057, B:11:0x0071, B:13:0x0077, B:15:0x007d, B:19:0x0089, B:22:0x0096, B:25:0x00a1, B:41:0x0107, B:43:0x010c, B:48:0x011a, B:50:0x0125, B:51:0x0131, B:53:0x0137, B:55:0x013f, B:57:0x014d, B:58:0x016c, B:30:0x00d7, B:32:0x00ee), top: B:137:0x0041 }] */
    /* JADX WARN: Code duplicated, block: B:50:0x0125 A[Catch: EOFException -> 0x0116, IOException -> 0x0188, TryCatch #3 {IOException -> 0x0188, blocks: (B:4:0x0041, B:7:0x0050, B:9:0x0057, B:11:0x0071, B:13:0x0077, B:15:0x007d, B:19:0x0089, B:22:0x0096, B:25:0x00a1, B:41:0x0107, B:43:0x010c, B:48:0x011a, B:50:0x0125, B:51:0x0131, B:53:0x0137, B:55:0x013f, B:57:0x014d, B:58:0x016c, B:30:0x00d7, B:32:0x00ee), top: B:137:0x0041 }] */
    /* JADX WARN: Code duplicated, block: B:53:0x0137 A[Catch: EOFException -> 0x0116, IOException -> 0x0188, TRY_LEAVE, TryCatch #3 {IOException -> 0x0188, blocks: (B:4:0x0041, B:7:0x0050, B:9:0x0057, B:11:0x0071, B:13:0x0077, B:15:0x007d, B:19:0x0089, B:22:0x0096, B:25:0x00a1, B:41:0x0107, B:43:0x010c, B:48:0x011a, B:50:0x0125, B:51:0x0131, B:53:0x0137, B:55:0x013f, B:57:0x014d, B:58:0x016c, B:30:0x00d7, B:32:0x00ee), top: B:137:0x0041 }] */
    /* JADX WARN: Code duplicated, block: B:71:0x019d  */
    /* JADX WARN: Code duplicated, block: B:73:0x01b0  */
    /* JADX WARN: Code duplicated, block: B:75:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:77:0x01cd  */
    /* JADX WARN: Code duplicated, block: B:78:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:80:0x01e3  */
    /* JADX WARN: Code duplicated, block: B:82:0x01ed  */
    /* JADX WARN: Code duplicated, block: B:85:0x01f7  */
    /* JADX WARN: Code duplicated, block: B:87:0x0202  */
    /* JADX WARN: Code duplicated, block: B:89:0x020c  */
    /* JADX WARN: Code duplicated, block: B:92:0x0217  */
    /* JADX WARN: Code duplicated, block: B:94:0x0222  */
    /* JADX WARN: Code duplicated, block: B:95:0x0227  */
    /* JADX WARN: Code duplicated, block: B:97:0x0232  */
    /* JADX WARN: Code duplicated, block: B:98:0x023c  */
    static {
        ArrayList arrayList;
        Nengo nengo;
        Nengo nengo2;
        String property;
        Nengo nengo3;
        String[] strArrSplit;
        int length;
        String strHepburn;
        int i;
        PlainDate date;
        String str;
        String strCapitalize;
        String str2;
        String str3;
        String[] strArrSplit2;
        String str4;
        String str5;
        DataInputStream dataInputStream;
        Nengo nengo4;
        Nengo nengo5;
        short s;
        int i2;
        String utf;
        String utf2;
        String utf3;
        String utf4;
        byte b;
        byte b2;
        TST tst;
        ArrayList arrayList2;
        int i3;
        String str6;
        DataInputStream dataInputStream2;
        String str7;
        String str8;
        Nengo nengo6;
        Nengo nengo7;
        Iterator it2;
        ArrayList arrayList3 = new ArrayList(256);
        ArrayList arrayList4 = new ArrayList(16);
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        AnonymousClass1 anonymousClass1 = null;
        TST tst2 = new TST(anonymousClass1);
        TST tst3 = new TST(anonymousClass1);
        TST tst4 = new TST(anonymousClass1);
        InputStream inputStreamLoad = ResourceLoader.getInstance().load(ResourceLoader.getInstance().locate("calendar", Nengo.class, "data/nengo.data"), true);
        if (inputStreamLoad == null) {
            try {
                try {
                    inputStreamLoad = ResourceLoader.getInstance().load(Nengo.class, "data/nengo.data", true);
                    try {
                        dataInputStream = new DataInputStream(inputStreamLoad);
                        nengo = null;
                        nengo2 = null;
                        while (true) {
                            try {
                                s = dataInputStream.readShort();
                                i2 = dataInputStream.readInt();
                                utf = dataInputStream.readUTF();
                                utf2 = dataInputStream.readUTF();
                                utf3 = dataInputStream.readUTF();
                                utf4 = dataInputStream.readUTF();
                                nengo4 = nengo;
                                try {
                                    b = dataInputStream.readByte();
                                    nengo5 = nengo2;
                                    try {
                                        b2 = dataInputStream.readByte();
                                        tst = tst4;
                                        try {
                                            arrayList2 = new ArrayList(b2);
                                            i3 = 0;
                                            while (i3 < b2) {
                                                byte b3 = b2;
                                                try {
                                                    arrayList2.add(dataInputStream.readUTF());
                                                    i3++;
                                                    b2 = b3;
                                                } catch (EOFException unused) {
                                                    arrayList = arrayList4;
                                                    nengo = nengo4;
                                                    nengo2 = nengo5;
                                                    tst4 = tst;
                                                    property = System.getProperty(NEW_ERA_PROPERTY);
                                                    if (property != null) {
                                                        strArrSplit = property.split(",");
                                                        length = strArrSplit.length;
                                                        strHepburn = null;
                                                        i = 0;
                                                        date = null;
                                                        str = null;
                                                        strCapitalize = null;
                                                        str2 = null;
                                                        str3 = null;
                                                        while (i < length) {
                                                            int i4 = length;
                                                            String[] strArr = strArrSplit;
                                                            strArrSplit2 = strArrSplit[i].split("=");
                                                            Nengo nengo8 = nengo;
                                                            if (strArrSplit2.length != 2) {
                                                                if (strArrSplit2[0].equals("name")) {
                                                                    strHepburn = hepburn(strArrSplit2[1], 0);
                                                                } else if (strArrSplit2[0].equals("kanji")) {
                                                                    str5 = strArrSplit2[1];
                                                                    if (str5.length() == 2) {
                                                                        throw new IllegalArgumentException("Japanese kanji must be of length 2.");
                                                                    }
                                                                    str2 = str5;
                                                                } else if (strArrSplit2[0].equals(LocalePreferences.CalendarType.CHINESE)) {
                                                                    str4 = strArrSplit2[1];
                                                                    if (str4.length() == 2) {
                                                                        throw new IllegalArgumentException("Chinese kanji must be of length 2.");
                                                                    }
                                                                    str3 = str4;
                                                                } else if (strArrSplit2[0].equals("korean")) {
                                                                    str = strArrSplit2[1];
                                                                } else if (strArrSplit2[0].equals("russian")) {
                                                                    strCapitalize = capitalize(strArrSplit2[1], 0);
                                                                } else if (strArrSplit2[0].equals("since")) {
                                                                    try {
                                                                        date = Iso8601Format.parseDate(strArrSplit2[1]);
                                                                    } catch (ParseException unused2) {
                                                                    }
                                                                }
                                                            }
                                                            i++;
                                                            length = i4;
                                                            strArrSplit = strArr;
                                                            nengo = nengo8;
                                                        }
                                                        nengo3 = nengo;
                                                        if (strHepburn == null) {
                                                        }
                                                        throw new IllegalStateException("Invalid syntax: " + property);
                                                    }
                                                    nengo3 = nengo;
                                                    Nengo[] nengoArr = (Nengo[]) arrayList3.toArray(new Nengo[arrayList3.size()]);
                                                    OFFICIAL_NENGOS = nengoArr;
                                                    NORTHERN_NENGOS = (Nengo[]) arrayList.toArray(new Nengo[arrayList.size()]);
                                                    NENGO_KENMU = nengo3;
                                                    NENGO_OEI = nengo2;
                                                    KANJI_TO_NENGO = Collections.unmodifiableMap(map);
                                                    CHINESE_TO_NENGO = Collections.unmodifiableMap(map2);
                                                    KOREAN_TO_NENGO = tst2;
                                                    RUSSIAN_TO_NENGO = tst3;
                                                    ROMAJI_TO_NENGO = tst4;
                                                    Nengo nengo9 = nengoArr[223];
                                                    MEIJI = nengo9;
                                                    Nengo nengo10 = nengoArr[224];
                                                    TAISHO = nengo10;
                                                    Nengo nengo11 = nengoArr[225];
                                                    SHOWA = nengo11;
                                                    Nengo nengo12 = nengoArr[226];
                                                    HEISEI = nengo12;
                                                    Nengo nengo13 = nengoArr[227];
                                                    REIWA = nengo13;
                                                    NEWEST = nengoArr[nengoArr.length - 1];
                                                    SELECTOR = Attributes.createKey("NENGO_SELECTOR", Selector.class);
                                                    MODERN_KEYS = new String[]{"reiwa", "heisei", "showa", "taisho", "meiji"};
                                                    MODERN_NENGOS = new Nengo[]{nengo13, nengo12, nengo11, nengo10, nengo9};
                                                }
                                            }
                                            str6 = (String) arrayList2.get(0);
                                            try {
                                                if (b == 1) {
                                                    str7 = utf3;
                                                    dataInputStream2 = dataInputStream;
                                                    str8 = utf;
                                                    Nengo nengo14 = new Nengo(s, i2, str8, utf2, str7, utf4, str6, b, arrayList4.size());
                                                    arrayList4.add(nengo14);
                                                    arrayList = arrayList4;
                                                    nengo7 = nengo14;
                                                    nengo = nengo4;
                                                } else {
                                                    dataInputStream2 = dataInputStream;
                                                    str7 = utf3;
                                                    str8 = utf;
                                                    arrayList = arrayList4;
                                                    try {
                                                        nengo6 = new Nengo(s, i2, str8, utf2, str7, utf4, str6, b, arrayList3.size());
                                                        arrayList3.add(nengo6);
                                                        if (s == 1334) {
                                                            nengo = nengo6;
                                                        } else {
                                                            if (s == 1394) {
                                                                nengo2 = nengo6;
                                                                nengo7 = nengo2;
                                                                nengo = nengo4;
                                                            } else {
                                                                nengo = nengo4;
                                                            }
                                                            if (nengo7.court == 1 || nengo7.relgregyear != 1334) {
                                                                map.put(str8, nengo7);
                                                                if (map2.put(utf2, nengo7) != null) {
                                                                    tst4 = tst;
                                                                    throw new IllegalStateException(nengo7.relgregyear + StringUtils.SPACE + nengo7.chinese);
                                                                }
                                                                tst2.insert(str7, nengo7);
                                                                tst3.insert(utf4, nengo7);
                                                                it2 = arrayList2.iterator();
                                                                while (it2.hasNext()) {
                                                                    tst4 = tst;
                                                                    try {
                                                                        tst4.insert((String) it2.next(), nengo7);
                                                                        tst = tst4;
                                                                    } catch (EOFException unused3) {
                                                                    }
                                                                }
                                                            }
                                                            tst4 = tst;
                                                            dataInputStream = dataInputStream2;
                                                            arrayList4 = arrayList;
                                                        }
                                                        nengo7 = nengo6;
                                                    } catch (EOFException unused4) {
                                                        tst4 = tst;
                                                        nengo = nengo4;
                                                        nengo2 = nengo5;
                                                    }
                                                }
                                                if (nengo7.court == 1) {
                                                    map.put(str8, nengo7);
                                                    if (map2.put(utf2, nengo7) != null) {
                                                        tst4 = tst;
                                                        throw new IllegalStateException(nengo7.relgregyear + StringUtils.SPACE + nengo7.chinese);
                                                    }
                                                    tst2.insert(str7, nengo7);
                                                    tst3.insert(utf4, nengo7);
                                                    it2 = arrayList2.iterator();
                                                    while (it2.hasNext()) {
                                                        tst4 = tst;
                                                        tst4.insert((String) it2.next(), nengo7);
                                                        tst = tst4;
                                                    }
                                                } else {
                                                    map.put(str8, nengo7);
                                                    if (map2.put(utf2, nengo7) != null) {
                                                        tst4 = tst;
                                                        throw new IllegalStateException(nengo7.relgregyear + StringUtils.SPACE + nengo7.chinese);
                                                    }
                                                    tst2.insert(str7, nengo7);
                                                    tst3.insert(utf4, nengo7);
                                                    it2 = arrayList2.iterator();
                                                    while (it2.hasNext()) {
                                                        tst4 = tst;
                                                        tst4.insert((String) it2.next(), nengo7);
                                                        tst = tst4;
                                                    }
                                                }
                                                tst4 = tst;
                                                dataInputStream = dataInputStream2;
                                                arrayList4 = arrayList;
                                            } catch (EOFException unused5) {
                                                tst4 = tst;
                                            }
                                            nengo2 = nengo5;
                                        } catch (EOFException unused6) {
                                            arrayList = arrayList4;
                                        }
                                    } catch (EOFException unused7) {
                                        arrayList = arrayList4;
                                    }
                                } catch (EOFException unused8) {
                                    arrayList = arrayList4;
                                    nengo = nengo4;
                                }
                            } catch (EOFException unused9) {
                                arrayList = arrayList4;
                                nengo4 = nengo;
                                nengo5 = nengo2;
                            }
                        }
                    } catch (EOFException unused10) {
                        arrayList = arrayList4;
                        nengo = null;
                        nengo2 = null;
                    }
                } catch (EOFException unused11) {
                    arrayList = arrayList4;
                    nengo = null;
                    nengo2 = null;
                }
            } catch (IOException e) {
                throw new IllegalStateException("Invalid nengo data.", e);
            }
        } else {
            dataInputStream = new DataInputStream(inputStreamLoad);
            nengo = null;
            nengo2 = null;
            while (true) {
                s = dataInputStream.readShort();
                i2 = dataInputStream.readInt();
                utf = dataInputStream.readUTF();
                utf2 = dataInputStream.readUTF();
                utf3 = dataInputStream.readUTF();
                utf4 = dataInputStream.readUTF();
                nengo4 = nengo;
                b = dataInputStream.readByte();
                nengo5 = nengo2;
                b2 = dataInputStream.readByte();
                tst = tst4;
                arrayList2 = new ArrayList(b2);
                i3 = 0;
                while (i3 < b2) {
                    byte b4 = b2;
                    arrayList2.add(dataInputStream.readUTF());
                    i3++;
                    b2 = b4;
                }
                str6 = (String) arrayList2.get(0);
                if (b == 1) {
                    str7 = utf3;
                    dataInputStream2 = dataInputStream;
                    str8 = utf;
                    Nengo nengo15 = new Nengo(s, i2, str8, utf2, str7, utf4, str6, b, arrayList4.size());
                    arrayList4.add(nengo15);
                    arrayList = arrayList4;
                    nengo7 = nengo15;
                    nengo = nengo4;
                } else {
                    dataInputStream2 = dataInputStream;
                    str7 = utf3;
                    str8 = utf;
                    arrayList = arrayList4;
                    nengo6 = new Nengo(s, i2, str8, utf2, str7, utf4, str6, b, arrayList3.size());
                    arrayList3.add(nengo6);
                    if (s == 1334) {
                        nengo = nengo6;
                    } else {
                        if (s == 1394) {
                            nengo2 = nengo6;
                            nengo7 = nengo2;
                            nengo = nengo4;
                        } else {
                            nengo = nengo4;
                        }
                        if (nengo7.court == 1) {
                            map.put(str8, nengo7);
                            if (map2.put(utf2, nengo7) != null) {
                                tst4 = tst;
                                throw new IllegalStateException(nengo7.relgregyear + StringUtils.SPACE + nengo7.chinese);
                            }
                            tst2.insert(str7, nengo7);
                            tst3.insert(utf4, nengo7);
                            it2 = arrayList2.iterator();
                            while (it2.hasNext()) {
                                tst4 = tst;
                                tst4.insert((String) it2.next(), nengo7);
                                tst = tst4;
                            }
                        } else {
                            map.put(str8, nengo7);
                            if (map2.put(utf2, nengo7) != null) {
                                tst4 = tst;
                                throw new IllegalStateException(nengo7.relgregyear + StringUtils.SPACE + nengo7.chinese);
                            }
                            tst2.insert(str7, nengo7);
                            tst3.insert(utf4, nengo7);
                            it2 = arrayList2.iterator();
                            while (it2.hasNext()) {
                                tst4 = tst;
                                tst4.insert((String) it2.next(), nengo7);
                                tst = tst4;
                            }
                        }
                        tst4 = tst;
                        dataInputStream = dataInputStream2;
                        arrayList4 = arrayList;
                    }
                    nengo7 = nengo6;
                }
                nengo2 = nengo5;
                if (nengo7.court == 1) {
                    map.put(str8, nengo7);
                    if (map2.put(utf2, nengo7) != null) {
                        tst4 = tst;
                        throw new IllegalStateException(nengo7.relgregyear + StringUtils.SPACE + nengo7.chinese);
                    }
                    tst2.insert(str7, nengo7);
                    tst3.insert(utf4, nengo7);
                    it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        tst4 = tst;
                        tst4.insert((String) it2.next(), nengo7);
                        tst = tst4;
                    }
                } else {
                    map.put(str8, nengo7);
                    if (map2.put(utf2, nengo7) != null) {
                        tst4 = tst;
                        throw new IllegalStateException(nengo7.relgregyear + StringUtils.SPACE + nengo7.chinese);
                    }
                    tst2.insert(str7, nengo7);
                    tst3.insert(utf4, nengo7);
                    it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        tst4 = tst;
                        tst4.insert((String) it2.next(), nengo7);
                        tst = tst4;
                    }
                }
                tst4 = tst;
                dataInputStream = dataInputStream2;
                arrayList4 = arrayList;
            }
        }
        property = System.getProperty(NEW_ERA_PROPERTY);
        if (property != null) {
            strArrSplit = property.split(",");
            length = strArrSplit.length;
            strHepburn = null;
            i = 0;
            date = null;
            str = null;
            strCapitalize = null;
            str2 = null;
            str3 = null;
            while (i < length) {
                int i5 = length;
                String[] strArr2 = strArrSplit;
                strArrSplit2 = strArrSplit[i].split("=");
                Nengo nengo16 = nengo;
                if (strArrSplit2.length != 2) {
                    if (strArrSplit2[0].equals("name")) {
                        strHepburn = hepburn(strArrSplit2[1], 0);
                    } else if (strArrSplit2[0].equals("kanji")) {
                        str5 = strArrSplit2[1];
                        if (str5.length() == 2) {
                            throw new IllegalArgumentException("Japanese kanji must be of length 2.");
                        }
                        str2 = str5;
                    } else if (strArrSplit2[0].equals(LocalePreferences.CalendarType.CHINESE)) {
                        str4 = strArrSplit2[1];
                        if (str4.length() == 2) {
                            throw new IllegalArgumentException("Chinese kanji must be of length 2.");
                        }
                        str3 = str4;
                    } else if (strArrSplit2[0].equals("korean")) {
                        str = strArrSplit2[1];
                    } else if (strArrSplit2[0].equals("russian")) {
                        strCapitalize = capitalize(strArrSplit2[1], 0);
                    } else if (strArrSplit2[0].equals("since")) {
                        date = Iso8601Format.parseDate(strArrSplit2[1]);
                    }
                }
                i++;
                length = i5;
                strArrSplit = strArr2;
                nengo = nengo16;
            }
            nengo3 = nengo;
            if (strHepburn == null && str2 != null && date != null) {
                Nengo nengo17 = (Nengo) arrayList3.get(arrayList3.size() - 1);
                if (!date.isAfter((CalendarDate) nengo17.getStart())) {
                    throw new IllegalStateException("New Japanese era must be after last defined nengo: " + nengo17.romaji);
                }
                String str9 = str3 == null ? str2 : str3;
                String str10 = str == null ? strHepburn : str;
                String str11 = strCapitalize == null ? strHepburn : strCapitalize;
                String str12 = str2;
                Nengo nengo18 = new Nengo(date.getYear(), date.getDaysSinceEpochUTC(), str12, str9, str10, str11, strHepburn, (byte) 0, arrayList3.size());
                arrayList3.add(nengo18);
                map.put(str12, nengo18);
                map2.put(str9, nengo18);
                tst2.insert(str10, nengo18);
                tst3.insert(str11, nengo18);
                tst4.insert(strHepburn, nengo18);
            } else {
                throw new IllegalStateException("Invalid syntax: " + property);
            }
        } else {
            nengo3 = nengo;
        }
        Nengo[] nengoArr2 = (Nengo[]) arrayList3.toArray(new Nengo[arrayList3.size()]);
        OFFICIAL_NENGOS = nengoArr2;
        NORTHERN_NENGOS = (Nengo[]) arrayList.toArray(new Nengo[arrayList.size()]);
        NENGO_KENMU = nengo3;
        NENGO_OEI = nengo2;
        KANJI_TO_NENGO = Collections.unmodifiableMap(map);
        CHINESE_TO_NENGO = Collections.unmodifiableMap(map2);
        KOREAN_TO_NENGO = tst2;
        RUSSIAN_TO_NENGO = tst3;
        ROMAJI_TO_NENGO = tst4;
        Nengo nengo19 = nengoArr2[223];
        MEIJI = nengo19;
        Nengo nengo110 = nengoArr2[224];
        TAISHO = nengo110;
        Nengo nengo111 = nengoArr2[225];
        SHOWA = nengo111;
        Nengo nengo112 = nengoArr2[226];
        HEISEI = nengo112;
        Nengo nengo113 = nengoArr2[227];
        REIWA = nengo113;
        NEWEST = nengoArr2[nengoArr2.length - 1];
        SELECTOR = Attributes.createKey("NENGO_SELECTOR", Selector.class);
        MODERN_KEYS = new String[]{"reiwa", "heisei", "showa", "taisho", "meiji"};
        MODERN_NENGOS = new Nengo[]{nengo113, nengo112, nengo111, nengo110, nengo19};
    }

    private Nengo(int i, long j, String str, String str2, String str3, String str4, String str5, byte b, int i2) {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Missing kanji.");
        }
        if (str5.isEmpty()) {
            throw new IllegalArgumentException("Missing latin transcription.");
        }
        if (b > 1 || b < -1) {
            throw new IllegalArgumentException("Undefined court byte: " + ((int) b));
        }
        this.relgregyear = i;
        this.start = j;
        this.kanji = str;
        this.chinese = str2;
        this.korean = str3;
        this.russian = str4;
        this.romaji = str5;
        this.court = b;
        this.index = i2;
    }

    public static Nengo ofRelatedGregorianYear(int i) {
        return ofRelatedGregorianYear(i, Selector.OFFICIAL);
    }

    /* JADX INFO: renamed from: net.time4j.calendar.Nengo$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$net$time4j$calendar$Nengo$Selector;

        static {
            int[] iArr = new int[Selector.values().length];
            $SwitchMap$net$time4j$calendar$Nengo$Selector = iArr;
            try {
                iArr[Selector.OFFICIAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$net$time4j$calendar$Nengo$Selector[Selector.MODERN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$net$time4j$calendar$Nengo$Selector[Selector.NORTHERN_COURT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$net$time4j$calendar$Nengo$Selector[Selector.SOUTHERN_COURT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$net$time4j$calendar$Nengo$Selector[Selector.EDO_PERIOD.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$net$time4j$calendar$Nengo$Selector[Selector.AZUCHI_MOMOYAMA_PERIOD.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$net$time4j$calendar$Nengo$Selector[Selector.MUROMACHI_PERIOD.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$net$time4j$calendar$Nengo$Selector[Selector.KAMAKURA_PERIOD.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$net$time4j$calendar$Nengo$Selector[Selector.HEIAN_PERIOD.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$net$time4j$calendar$Nengo$Selector[Selector.NARA_PERIOD.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$net$time4j$calendar$Nengo$Selector[Selector.ASUKA_PERIOD.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    public static Nengo ofRelatedGregorianYear(int i, Selector selector) {
        Nengo nengo;
        Nengo nengo2;
        if (i >= 701) {
            int i2 = AnonymousClass1.$SwitchMap$net$time4j$calendar$Nengo$Selector[selector.ordinal()];
            if (i2 != 1) {
                if (i2 == 2) {
                    int length = OFFICIAL_NENGOS.length - 1;
                    int lowerBound = getLowerBound(selector);
                    while (true) {
                        if (length >= lowerBound) {
                            nengo2 = OFFICIAL_NENGOS[length];
                            if (nengo2.relgregyear <= i) {
                                nengo = nengo2;
                            } else {
                                length--;
                            }
                        }
                    }
                } else if (i2 != 3) {
                    if (i2 != 4) {
                        int lowerBound2 = getLowerBound(selector);
                        int upperBound = getUpperBound(selector);
                        Nengo[] nengoArr = OFFICIAL_NENGOS;
                        if (i >= nengoArr[lowerBound2].relgregyear && i <= nengoArr[upperBound + 1].relgregyear) {
                            while (true) {
                                if (upperBound >= lowerBound2) {
                                    nengo2 = OFFICIAL_NENGOS[upperBound];
                                    if (nengo2.relgregyear <= i) {
                                        nengo = nengo2;
                                    } else {
                                        upperBound--;
                                    }
                                }
                            }
                        }
                    } else if (i >= 1334 && i <= 1393) {
                        int i3 = NENGO_OEI.index - 1;
                        while (true) {
                            nengo = OFFICIAL_NENGOS[i3];
                            if (nengo.court == -1) {
                                if (nengo.relgregyear <= i) {
                                    break;
                                }
                                i3--;
                            }
                        }
                    }
                } else {
                    if (i < 1332 || i > 1394) {
                        break;
                    }
                    int length2 = NORTHERN_NENGOS.length - 1;
                    while (true) {
                        if (length2 >= 0) {
                            nengo = NORTHERN_NENGOS[length2];
                            if (nengo.relgregyear <= i) {
                                break;
                            }
                            length2--;
                        }
                    }
                }
            } else {
                if (i >= 1873) {
                    return ofRelatedGregorianYear(i, Selector.MODERN);
                }
                int length3 = OFFICIAL_NENGOS.length - 1;
                int i4 = 0;
                while (i4 <= length3) {
                    int i5 = (i4 + length3) >> 1;
                    if (OFFICIAL_NENGOS[i5].getFirstRelatedGregorianYear() <= i) {
                        i4 = i5 + 1;
                    } else {
                        length3 = i5 - 1;
                    }
                }
                if (i4 != 0) {
                    return OFFICIAL_NENGOS[i4 - 1];
                }
            }
            nengo = null;
            break;
        } else {
            nengo = null;
            break;
        }
        if (nengo != null) {
            return nengo;
        }
        throw new IllegalArgumentException("Could not find nengo for year=" + i + ", selector=" + selector + ".");
    }

    public static Nengo ofKanji(String str) {
        Nengo nengo = KANJI_TO_NENGO.get(str);
        if (nengo != null) {
            return nengo;
        }
        throw new IllegalArgumentException("Could not find any nengo for Japanese kanji: " + str);
    }

    public static List<Nengo> parseRomaji(String str) {
        String strHepburn = hepburn(str, 0);
        TST tst = ROMAJI_TO_NENGO;
        return tst.find(tst.longestPrefixOf(strHepburn, 0));
    }

    public static List<Nengo> list() {
        return list(Selector.OFFICIAL);
    }

    public static List<Nengo> list(Selector selector) {
        List listAsList;
        int i = AnonymousClass1.$SwitchMap$net$time4j$calendar$Nengo$Selector[selector.ordinal()];
        if (i == 1) {
            listAsList = Arrays.asList(OFFICIAL_NENGOS);
        } else if (i == 3) {
            listAsList = Arrays.asList(NORTHERN_NENGOS);
        } else {
            int lowerBound = getLowerBound(selector);
            int upperBound = getUpperBound(selector);
            listAsList = new ArrayList((upperBound - lowerBound) + 1);
            while (lowerBound <= upperBound) {
                listAsList.add(OFFICIAL_NENGOS[lowerBound]);
                lowerBound++;
            }
        }
        return Collections.unmodifiableList(listAsList);
    }

    public boolean matches(Selector selector) {
        return selector.test(this);
    }

    public int getFirstRelatedGregorianYear() {
        return this.relgregyear;
    }

    public PlainDate getStart() {
        return PlainDate.of(this.start, EpochDays.UTC);
    }

    public boolean isModern() {
        return this.index >= MEIJI.index;
    }

    public String getDisplayName(Locale locale) {
        return getDisplayName(locale, TextWidth.WIDE);
    }

    public String getDisplayName(Locale locale, TextWidth textWidth) {
        String str;
        if (locale.getLanguage().isEmpty()) {
            return this.romaji;
        }
        int i = this.index;
        if (i < MEIJI.index || i > NEWEST.index || locale.getLanguage().equals("ru")) {
            if (locale.getLanguage().equals("ja")) {
                return this.kanji;
            }
            if (locale.getLanguage().equals("zh")) {
                return this.chinese;
            }
            if (locale.getLanguage().equals("ko")) {
                return this.korean;
            }
            if (locale.getLanguage().equals("ru")) {
                return "Период " + this.russian;
            }
            return this.romaji;
        }
        int i2 = 0;
        while (true) {
            Nengo[] nengoArr = MODERN_NENGOS;
            if (i2 >= nengoArr.length) {
                str = null;
                break;
            }
            if (equals(nengoArr[i2])) {
                str = MODERN_KEYS[i2];
                break;
            }
            i2++;
        }
        if (str == null) {
            throw new IllegalStateException("Modern nengos need an update.");
        }
        if (textWidth == TextWidth.NARROW) {
            str = str + "_n";
        }
        return CalendarText.getInstance("japanese", locale).getTextForms().get(str);
    }

    public Nengo findNext() {
        if (this.court == 1) {
            int i = this.index;
            Nengo[] nengoArr = NORTHERN_NENGOS;
            if (i == nengoArr.length - 1) {
                return NENGO_OEI;
            }
            return nengoArr[i + 1];
        }
        int i2 = this.index;
        Nengo[] nengoArr2 = OFFICIAL_NENGOS;
        if (i2 == nengoArr2.length - 1) {
            return null;
        }
        return nengoArr2[i2 + 1];
    }

    public Nengo findPrevious() {
        if (this.court == 1) {
            int i = this.index;
            if (i == 0) {
                return OFFICIAL_NENGOS[NENGO_KENMU.index - 1];
            }
            return NORTHERN_NENGOS[i - 1];
        }
        int i2 = this.index;
        if (i2 == 0) {
            return null;
        }
        return OFFICIAL_NENGOS[i2 - 1];
    }

    @Override // net.time4j.engine.CalendarEra
    public String name() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.romaji);
        sb.append(" (");
        Nengo nengoFindNext = findNext();
        if (nengoFindNext != null) {
            sb.append(this.relgregyear);
            sb.append(CoreConstants.DASH_CHAR);
            sb.append(nengoFindNext.relgregyear);
        } else {
            sb.append("since ");
            sb.append(this.relgregyear);
        }
        sb.append(CoreConstants.RIGHT_PARENTHESIS_CHAR);
        return sb.toString();
    }

    int getValue() {
        int length;
        int i;
        if (matches(Selector.NORTHERN_COURT)) {
            length = (this.index - NORTHERN_NENGOS.length) + NENGO_OEI.index;
            i = SHOWA.index;
        } else {
            length = this.index;
            i = SHOWA.index;
        }
        return (length - i) + 1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Nengo)) {
            return false;
        }
        Nengo nengo = (Nengo) obj;
        return this.relgregyear == nengo.relgregyear && this.start == nengo.start && this.kanji.equals(nengo.kanji) && this.romaji.equals(nengo.romaji) && this.court == nengo.court;
    }

    public int hashCode() {
        long j = this.start;
        return (int) (j ^ (j >>> 32));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.romaji);
        sb.append(' ');
        sb.append(this.kanji);
        sb.append(' ');
        Nengo nengoFindNext = findNext();
        if (nengoFindNext != null) {
            sb.append(this.relgregyear);
            sb.append(CoreConstants.DASH_CHAR);
            sb.append(nengoFindNext.relgregyear);
        } else {
            sb.append("since ");
            sb.append(this.relgregyear);
        }
        if (this.court != 0) {
            sb.append(" (");
            sb.append(this.court == 1 ? 'N' : 'S');
            sb.append(CoreConstants.RIGHT_PARENTHESIS_CHAR);
        }
        return sb.toString();
    }

    long getStartAsDaysSinceEpochUTC() {
        return this.start;
    }

    int getIndexOfficial() {
        return this.index;
    }

    static Nengo ofIndexOfficial(int i) {
        return OFFICIAL_NENGOS[i];
    }

    static String hepburn(CharSequence charSequence, int i) {
        int iMin = Math.min(charSequence.length(), i + 32);
        StringBuilder sb = null;
        for (int i2 = i; i2 < iMin; i2++) {
            char cCharAt = charSequence.charAt(i2);
            char lowerCase = 333;
            char upperCase = 332;
            char c = 363;
            char c2 = 362;
            if (i2 == i) {
                if (cCharAt != 212 && cCharAt != 244 && cCharAt != 333) {
                    upperCase = Character.toUpperCase(cCharAt);
                }
                if (cCharAt != 219 && cCharAt != 251 && cCharAt != 363) {
                    c2 = upperCase;
                }
            } else {
                if (cCharAt != 212 && cCharAt != 244 && cCharAt != 332) {
                    lowerCase = Character.toLowerCase(cCharAt);
                }
                if (cCharAt != 219 && cCharAt != 251 && cCharAt != 362) {
                    c = lowerCase;
                }
                c2 = c;
            }
            if (cCharAt == '\'') {
                c2 = Typography.rightSingleQuote;
            }
            if (cCharAt == ' ') {
                c2 = CoreConstants.DASH_CHAR;
            }
            if (sb != null || c2 != cCharAt) {
                if (sb == null) {
                    sb = new StringBuilder(32);
                    sb.append(charSequence.subSequence(i, i2));
                }
                sb.append(c2);
            }
        }
        return sb == null ? charSequence.subSequence(i, iMin).toString() : sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String capitalize(CharSequence charSequence, int i) {
        int iMin = Math.min(charSequence.length(), i + 32);
        StringBuilder sb = null;
        int i2 = i;
        boolean z = true;
        while (i2 < iMin) {
            char cCharAt = charSequence.charAt(i2);
            char upperCase = z ? Character.toUpperCase(cCharAt) : Character.toLowerCase(cCharAt);
            boolean z2 = cCharAt == ' ';
            if (sb != null || upperCase != cCharAt) {
                if (sb == null) {
                    sb = new StringBuilder(32);
                    sb.append(charSequence.subSequence(i, i2));
                }
                sb.append(upperCase);
            }
            i2++;
            z = z2;
        }
        return sb == null ? charSequence.subSequence(i, iMin).toString() : sb.toString();
    }

    private static int getUpperBound(Selector selector) {
        switch (AnonymousClass1.$SwitchMap$net$time4j$calendar$Nengo$Selector[selector.ordinal()]) {
            case 3:
                return NORTHERN_NENGOS.length - 1;
            case 4:
                return NENGO_KENMU.index + 8;
            case 5:
                return MEIJI.index - 1;
            case 6:
                return 187;
            case 7:
                return SyslogConstants.LOG_LOCAL7;
            case 8:
                return NENGO_KENMU.index - 1;
            case 9:
                return 102;
            case 10:
                return 14;
            case 11:
                return 2;
            default:
                return OFFICIAL_NENGOS.length - 1;
        }
    }

    private static int getLowerBound(Selector selector) {
        switch (AnonymousClass1.$SwitchMap$net$time4j$calendar$Nengo$Selector[selector.ordinal()]) {
            case 2:
                return MEIJI.index;
            case 3:
            default:
                return 0;
            case 4:
                return NENGO_KENMU.index;
            case 5:
                return 188;
            case 6:
                return 185;
            case 7:
                return NENGO_KENMU.index + 1;
            case 8:
                return b.i;
            case 9:
                return 15;
            case 10:
                return 3;
        }
    }

    private static Nengo of(int i, boolean z) {
        return z ? NORTHERN_NENGOS[i] : OFFICIAL_NENGOS[i];
    }

    private Object readResolve() throws ObjectStreamException {
        try {
            int i = this.index;
            boolean z = true;
            if (this.court != 1) {
                z = false;
            }
            return of(i, z);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new StreamCorruptedException();
        }
    }

    public enum Selector implements ChronoCondition<Nengo> {
        OFFICIAL { // from class: net.time4j.calendar.Nengo.Selector.1
            @Override // net.time4j.engine.ChronoCondition
            public boolean test(Nengo nengo) {
                return nengo.court != 1;
            }
        },
        MODERN { // from class: net.time4j.calendar.Nengo.Selector.2
            @Override // net.time4j.engine.ChronoCondition
            public boolean test(Nengo nengo) {
                return nengo.index >= Nengo.MEIJI.index;
            }
        },
        EDO_PERIOD { // from class: net.time4j.calendar.Nengo.Selector.3
            @Override // net.time4j.engine.ChronoCondition
            public boolean test(Nengo nengo) {
                return nengo.relgregyear >= 1603 && nengo.relgregyear < 1868;
            }
        },
        AZUCHI_MOMOYAMA_PERIOD { // from class: net.time4j.calendar.Nengo.Selector.4
            @Override // net.time4j.engine.ChronoCondition
            public boolean test(Nengo nengo) {
                return nengo.relgregyear >= 1573 && nengo.relgregyear < 1603;
            }
        },
        MUROMACHI_PERIOD { // from class: net.time4j.calendar.Nengo.Selector.5
            @Override // net.time4j.engine.ChronoCondition
            public boolean test(Nengo nengo) {
                return nengo.relgregyear >= 1336 && nengo.relgregyear < 1573 && nengo.court != 1;
            }
        },
        NORTHERN_COURT { // from class: net.time4j.calendar.Nengo.Selector.6
            @Override // net.time4j.engine.ChronoCondition
            public boolean test(Nengo nengo) {
                return nengo.court == 1;
            }
        },
        SOUTHERN_COURT { // from class: net.time4j.calendar.Nengo.Selector.7
            @Override // net.time4j.engine.ChronoCondition
            public boolean test(Nengo nengo) {
                return nengo.court == -1;
            }
        },
        KAMAKURA_PERIOD { // from class: net.time4j.calendar.Nengo.Selector.8
            @Override // net.time4j.engine.ChronoCondition
            public boolean test(Nengo nengo) {
                return nengo.relgregyear >= 1185 && nengo.relgregyear < 1332;
            }
        },
        HEIAN_PERIOD { // from class: net.time4j.calendar.Nengo.Selector.9
            @Override // net.time4j.engine.ChronoCondition
            public boolean test(Nengo nengo) {
                return nengo.relgregyear >= 794 && nengo.relgregyear < 1185;
            }
        },
        NARA_PERIOD { // from class: net.time4j.calendar.Nengo.Selector.10
            @Override // net.time4j.engine.ChronoCondition
            public boolean test(Nengo nengo) {
                return nengo.relgregyear >= 710 && nengo.relgregyear < 794;
            }
        },
        ASUKA_PERIOD { // from class: net.time4j.calendar.Nengo.Selector.11
            @Override // net.time4j.engine.ChronoCondition
            public boolean test(Nengo nengo) {
                return nengo.relgregyear >= 538 && nengo.relgregyear < 710;
            }
        };

        /* synthetic */ Selector(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    static class Element implements TextElement<Nengo>, Serializable {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        static final Element SINGLETON = new Element();
        private static final long serialVersionUID = -1099321098836107792L;

        @Override // net.time4j.engine.ChronoElement
        public char getSymbol() {
            return 'G';
        }

        @Override // net.time4j.engine.ChronoElement
        public boolean isDateElement() {
            return true;
        }

        @Override // net.time4j.engine.ChronoElement
        public boolean isLenient() {
            return false;
        }

        @Override // net.time4j.engine.ChronoElement
        public boolean isTimeElement() {
            return false;
        }

        private Element() {
        }

        @Override // net.time4j.format.TextElement
        public void print(ChronoDisplay chronoDisplay, Appendable appendable, AttributeQuery attributeQuery) throws IOException, ChronoException {
            appendable.append(((Nengo) chronoDisplay.get(this)).getDisplayName((Locale) attributeQuery.get(Attributes.LANGUAGE, Locale.ROOT), (TextWidth) attributeQuery.get(Attributes.TEXT_WIDTH, TextWidth.WIDE)));
        }

        /* JADX WARN: Code duplicated, block: B:59:0x0128  */
        @Override // net.time4j.format.TextElement
        public Nengo parse(CharSequence charSequence, ParsePosition parsePosition, AttributeQuery attributeQuery) {
            int length;
            Nengo nengo;
            String strLongestPrefixOf;
            int i;
            String strLongestPrefixOf2;
            Locale locale = (Locale) attributeQuery.get(Attributes.LANGUAGE, Locale.ROOT);
            TextWidth textWidth = (TextWidth) attributeQuery.get(Attributes.TEXT_WIDTH, TextWidth.WIDE);
            Map<String, String> textForms = CalendarText.getInstance("japanese", locale).getTextForms();
            int index = parsePosition.getIndex();
            if (index >= charSequence.length()) {
                parsePosition.setErrorIndex(index);
                return null;
            }
            String strCapitalize = locale.getLanguage().equals("ru") ? Nengo.capitalize(charSequence, index) : Nengo.hepburn(charSequence, index);
            int i2 = 0;
            while (true) {
                if (i2 >= Nengo.MODERN_KEYS.length) {
                    length = 0;
                    nengo = null;
                    break;
                }
                String str = Nengo.MODERN_KEYS[i2];
                TextWidth textWidth2 = TextWidth.NARROW;
                if (textWidth == textWidth2) {
                    str = str + "_n";
                }
                String str2 = textForms.get(str);
                if (strCapitalize.startsWith(str2)) {
                    nengo = Nengo.MODERN_NENGOS[i2];
                    length = str2.length();
                    if (textWidth == textWidth2 || nengo == Nengo.SHOWA) {
                        break;
                        break;
                    }
                    parsePosition.setIndex(index + length);
                    return nengo;
                }
                i2++;
            }
            if (strCapitalize.length() < 2) {
                if (nengo != null) {
                    parsePosition.setIndex(index + 1);
                }
                return nengo;
            }
            List<Nengo> listEmptyList = Collections.emptyList();
            if (locale.getLanguage().equals("ja")) {
                int i3 = strCapitalize.length() >= 4 ? 4 : 2;
                strLongestPrefixOf = strCapitalize.substring(0, i3);
                Nengo nengo2 = (Nengo) Nengo.KANJI_TO_NENGO.get(strLongestPrefixOf);
                if (nengo2 == null && i3 == 4) {
                    strLongestPrefixOf = strCapitalize.substring(0, 2);
                    nengo2 = (Nengo) Nengo.KANJI_TO_NENGO.get(strLongestPrefixOf);
                }
                if (nengo2 != null) {
                    if (nengo2 == nengo) {
                        nengo = null;
                    }
                    listEmptyList = Collections.singletonList(nengo2);
                } else {
                    strLongestPrefixOf = null;
                }
                i = 0;
                strLongestPrefixOf2 = strLongestPrefixOf;
            } else {
                if (locale.getLanguage().equals("zh")) {
                    int i4 = strCapitalize.length() >= 4 ? 4 : 2;
                    strLongestPrefixOf = strCapitalize.substring(0, i4);
                    Nengo nengo3 = (Nengo) Nengo.CHINESE_TO_NENGO.get(strLongestPrefixOf);
                    if (nengo3 == null && i4 == 4) {
                        String strSubstring = strCapitalize.substring(0, 2);
                        nengo3 = (Nengo) Nengo.CHINESE_TO_NENGO.get(strSubstring);
                        strLongestPrefixOf = strSubstring;
                    }
                    if (nengo3 != null) {
                        if (nengo3 == nengo) {
                            nengo = null;
                        }
                        listEmptyList = Collections.singletonList(nengo3);
                    } else {
                        strLongestPrefixOf = null;
                    }
                } else if (locale.getLanguage().equals("ko")) {
                    strLongestPrefixOf = Nengo.KOREAN_TO_NENGO.longestPrefixOf(strCapitalize, index);
                    listEmptyList = Nengo.KOREAN_TO_NENGO.find(strLongestPrefixOf);
                } else if (!locale.getLanguage().equals("ru")) {
                    strLongestPrefixOf = Nengo.ROMAJI_TO_NENGO.longestPrefixOf(strCapitalize, index);
                    listEmptyList = Nengo.ROMAJI_TO_NENGO.find(strLongestPrefixOf);
                } else {
                    if (strCapitalize.startsWith("Период ")) {
                        i = 7;
                        strCapitalize = strCapitalize.substring(7);
                    } else {
                        i = 0;
                    }
                    strLongestPrefixOf2 = Nengo.RUSSIAN_TO_NENGO.longestPrefixOf(strCapitalize, index);
                    listEmptyList = Nengo.RUSSIAN_TO_NENGO.find(strLongestPrefixOf2);
                }
                i = 0;
                strLongestPrefixOf2 = strLongestPrefixOf;
            }
            int size = listEmptyList.size();
            if (size == 0 || strLongestPrefixOf2 == null) {
                if (nengo == null) {
                    return null;
                }
                parsePosition.setIndex(index + length);
                return nengo;
            }
            int length2 = strLongestPrefixOf2.length() + i;
            if (length < length2) {
                nengo = null;
            } else if (length > length2) {
                parsePosition.setIndex(index + length);
                return nengo;
            }
            if (size == 1) {
                Nengo nengo4 = listEmptyList.get(0);
                if (nengo == null || nengo4 == nengo) {
                    parsePosition.setIndex(index + length2);
                    return nengo4;
                }
            }
            Selector selector = (Selector) attributeQuery.get(Nengo.SELECTOR, Selector.OFFICIAL);
            ArrayList arrayList = new ArrayList(listEmptyList);
            if (nengo != null && !arrayList.contains(nengo)) {
                arrayList.add(nengo);
            }
            Collections.sort(arrayList, new Comparator<Nengo>() { // from class: net.time4j.calendar.Nengo.Element.1
                @Override // java.util.Comparator
                public int compare(Nengo nengo5, Nengo nengo6) {
                    if (nengo5.start < nengo6.start) {
                        return 1;
                    }
                    return nengo5.start == nengo6.start ? 0 : -1;
                }
            });
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                if (!((Nengo) it2.next()).matches(selector)) {
                    it2.remove();
                }
            }
            if (arrayList.size() == 1) {
                parsePosition.setIndex(index + length2);
                return (Nengo) arrayList.get(0);
            }
            if (arrayList.size() <= 1 || ((Leniency) attributeQuery.get(Attributes.LENIENCY, Leniency.SMART)).isStrict()) {
                return null;
            }
            parsePosition.setIndex(index + length2);
            return (Nengo) arrayList.get(0);
        }

        @Override // net.time4j.engine.ChronoElement
        public String name() {
            return "ERA";
        }

        @Override // net.time4j.engine.ChronoElement
        public Class<Nengo> getType() {
            return Nengo.class;
        }

        @Override // java.util.Comparator
        public int compare(ChronoDisplay chronoDisplay, ChronoDisplay chronoDisplay2) {
            Nengo nengo = (Nengo) chronoDisplay.get(this);
            Nengo nengo2 = (Nengo) chronoDisplay2.get(this);
            if (nengo.start < nengo2.start) {
                return -1;
            }
            if (nengo.start > nengo2.start) {
                return 1;
            }
            if (nengo.court == 1) {
                return nengo2.court == 1 ? 0 : 1;
            }
            return nengo2.court == 1 ? -1 : 0;
        }

        @Override // net.time4j.engine.ChronoElement
        public Nengo getDefaultMinimum() {
            return Nengo.OFFICIAL_NENGOS[0];
        }

        @Override // net.time4j.engine.ChronoElement
        public Nengo getDefaultMaximum() {
            return Nengo.OFFICIAL_NENGOS[Nengo.OFFICIAL_NENGOS.length - 1];
        }

        @Override // net.time4j.engine.ChronoElement
        public String getDisplayName(Locale locale) {
            String str = CalendarText.getIsoInstance(locale).getTextForms().get("L_era");
            return str == null ? name() : str;
        }

        private Object readResolve() throws ObjectStreamException {
            return SINGLETON;
        }
    }

    static class TST {
        private Node root;

        private TST() {
            this.root = null;
        }

        /* synthetic */ TST(AnonymousClass1 anonymousClass1) {
            this();
        }

        List<Nengo> find(String str) {
            if (str == null || str.length() == 0) {
                return Collections.emptyList();
            }
            Node nodeFind = find(this.root, str, 0);
            if (nodeFind == null) {
                return Collections.emptyList();
            }
            return Collections.unmodifiableList(nodeFind.nengos);
        }

        private static Node find(Node node, String str, int i) {
            if (node == null) {
                return null;
            }
            char cCharAt = str.charAt(i);
            if (cCharAt < node.c) {
                return find(node.left, str, i);
            }
            if (cCharAt > node.c) {
                return find(node.right, str, i);
            }
            return i < str.length() + (-1) ? find(node.mid, str, i + 1) : node;
        }

        void insert(String str, Nengo nengo) {
            if (str.isEmpty()) {
                throw new IllegalArgumentException("Empty key cannot be inserted.");
            }
            this.root = insert(this.root, str, nengo, 0);
        }

        private static Node insert(Node node, String str, Nengo nengo, int i) {
            char cCharAt = str.charAt(i);
            if (node == null) {
                node = new Node(null);
                node.c = cCharAt;
            }
            if (cCharAt < node.c) {
                node.left = insert(node.left, str, nengo, i);
            } else if (cCharAt <= node.c) {
                if (i < str.length() - 1) {
                    node.mid = insert(node.mid, str, nengo, i + 1);
                } else {
                    if (node.nengos == null) {
                        node.nengos = new ArrayList();
                    }
                    node.nengos.add(nengo);
                }
            } else {
                node.right = insert(node.right, str, nengo, i);
            }
            return node;
        }

        String longestPrefixOf(CharSequence charSequence, int i) {
            Node node = this.root;
            int length = charSequence.length();
            int i2 = i;
            int i3 = i2;
            while (node != null && i2 < length) {
                char cCharAt = charSequence.charAt(i2);
                if (cCharAt < node.c) {
                    node = node.left;
                } else if (cCharAt > node.c) {
                    node = node.right;
                } else {
                    i2++;
                    if (node.nengos != null) {
                        i3 = i2;
                    }
                    node = node.mid;
                }
            }
            if (i >= i3) {
                return null;
            }
            return charSequence.subSequence(i, i3).toString();
        }
    }

    static class Node {
        private char c;
        private Node left;
        private Node mid;
        private List<Nengo> nengos;
        private Node right;

        private Node() {
            this.c = (char) 0;
            this.left = null;
            this.mid = null;
            this.right = null;
            this.nengos = null;
        }

        /* synthetic */ Node(AnonymousClass1 anonymousClass1) {
            this();
        }
    }
}
