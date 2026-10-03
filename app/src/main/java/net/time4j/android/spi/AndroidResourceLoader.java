package net.time4j.android.spi;

import android.content.Context;
import android.text.format.DateFormat;
import com.transistorsoft.locationmanager.logger.TSLog;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.Set;
import net.time4j.android.AssetLocation;
import net.time4j.base.ResourceLoader;
import net.time4j.calendar.service.GenericTextProviderSPI;
import net.time4j.calendar.service.KoreanExtension;
import net.time4j.engine.ChronoExtension;
import net.time4j.format.DisplayMode;
import net.time4j.format.FormatPatternProvider;
import net.time4j.format.NumberSymbolProvider;
import net.time4j.format.PluralProvider;
import net.time4j.format.TextProvider;
import net.time4j.format.UnitPatternProvider;
import net.time4j.format.WeekdataProvider;
import net.time4j.format.internal.ExtendedPatterns;
import net.time4j.i18n.DefaultPluralProviderSPI;
import net.time4j.i18n.HistoricExtension;
import net.time4j.i18n.IsoTextProviderSPI;
import net.time4j.i18n.SymbolProviderSPI;
import net.time4j.i18n.UnitPatternProviderSPI;
import net.time4j.i18n.WeekdataProviderSPI;
import net.time4j.scale.LeapSecondProvider;
import net.time4j.scale.TickProvider;
import net.time4j.tz.ZoneModelProvider;
import net.time4j.tz.ZoneNameProvider;
import net.time4j.tz.spi.TimezoneRepositoryProviderSPI;
import net.time4j.tz.spi.ZoneNameProviderSPI;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: classes3.dex */
public class AndroidResourceLoader extends ResourceLoader {
    private static final Set<String> MODULES;
    private static final Map<Class<?>, Iterable<?>> PROVIDERS;
    private static int artificialFrame = 1;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME;
    private Context context = null;
    private AssetLocation assetLocation = null;
    private List<FormatPatternProvider> patterns = Collections.emptyList();

    /* JADX WARN: Multi-variable type inference failed */
    private static <T> T cast(Object obj) {
        return obj;
    }

    static {
        HashMap map = new HashMap();
        AnonymousClass1 anonymousClass1 = null;
        map.put(TextProvider.class, new LazyTextdata(anonymousClass1));
        map.put(ZoneModelProvider.class, new LazyZoneRules(anonymousClass1));
        map.put(ZoneNameProvider.class, new LazyZoneNames(anonymousClass1));
        map.put(LeapSecondProvider.class, new LazyLeapseconds(anonymousClass1));
        map.put(ChronoExtension.class, new LazyExtensions(anonymousClass1));
        map.put(NumberSymbolProvider.class, new LazyNumberSymbols(anonymousClass1));
        map.put(PluralProvider.class, new LazyPluraldata(anonymousClass1));
        map.put(UnitPatternProvider.class, Collections.singleton(new UnitPatternProviderSPI()));
        map.put(WeekdataProvider.class, new LazyWeekdata(anonymousClass1));
        map.put(TickProvider.class, Collections.singleton(new AndroidTickerSPI()));
        PROVIDERS = Collections.unmodifiableMap(map);
        HashSet hashSet = new HashSet();
        hashSet.add("i18n");
        hashSet.add("calendar");
        hashSet.add("olson");
        hashSet.add("tzdata");
        MODULES = Collections.unmodifiableSet(hashSet);
    }

    public void init(Context context, AssetLocation assetLocation) {
        if (context == null) {
            throw new NullPointerException("Missing Android-context.");
        }
        this.context = context;
        this.assetLocation = assetLocation;
        this.patterns = Collections.singletonList(new AndroidFormatPatterns(this, null));
    }

    @Override // net.time4j.base.ResourceLoader
    public URI locate(String str, Class<?> cls, String str2) {
        try {
            if (MODULES.contains(str)) {
                return new URI("net/time4j/" + str + '/' + str2);
            }
            URL resource = cls.getClassLoader().getResource(str2);
            if (resource != null) {
                return resource.toURI();
            }
            return null;
        } catch (URISyntaxException unused) {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001d, code lost:
    
        if (r11.isAbsolute() == false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x001f, code lost:
    
        r11 = (java.net.URLConnection) com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r11.toURL().openConnection());
        r11.setUseCaches(false);
        r11 = r11.getInputStream();
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0034, code lost:
    
        r0 = net.time4j.android.spi.AndroidResourceLoader.artificialFrame + 51;
        net.time4j.android.spi.AndroidResourceLoader.getARTIFICIAL_FRAME_PACKAGE_NAME = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x003d, code lost:
    
        if ((r0 % 2) == 0) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x003f, code lost:
    
        r12 = 28 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0042, code lost:
    
        return r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0043, code lost:
    
        r0 = r10.assetLocation;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0045, code lost:
    
        if (r0 == null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0047, code lost:
    
        r3 = net.time4j.android.spi.AndroidResourceLoader.artificialFrame + 65;
        net.time4j.android.spi.AndroidResourceLoader.getARTIFICIAL_FRAME_PACKAGE_NAME = r3 % 128;
        r3 = r3 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0050, code lost:
    
        r11 = r0.open(r11.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0058, code lost:
    
        r0 = net.time4j.android.spi.AndroidResourceLoader.artificialFrame + 101;
        net.time4j.android.spi.AndroidResourceLoader.getARTIFICIAL_FRAME_PACKAGE_NAME = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0061, code lost:
    
        if ((r0 % 2) == 0) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0063, code lost:
    
        r12 = 99 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0066, code lost:
    
        return r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0067, code lost:
    
        r0 = r10.context;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0069, code lost:
    
        if (r0 == null) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0073, code lost:
    
        r11 = new java.lang.Object[]{r0.getAssets(), r11.toString()};
        r0 = o.ArtificialStackFrames.accessartificialFrame(-982065286);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x007e, code lost:
    
        if (r0 != null) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0080, code lost:
    
        r0 = o.ArtificialStackFrames.coroutineCreation(((android.os.Process.getThreadPriority(0) + 20) >> 6) + 12, (char) (7115 - android.text.TextUtils.lastIndexOf("", '0', 0, 0)), (android.view.KeyEvent.getMaxKeyCode() >> 16) + 37, 1511233906, false, "accessartificialFrame", new java.lang.Class[]{android.content.res.AssetManager.class, java.lang.String.class});
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00ba, code lost:
    
        return (java.io.InputStream) ((java.lang.reflect.Method) r0).invoke(null, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00bb, code lost:
    
        r11 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00bc, code lost:
    
        r12 = r11.getCause();
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00c0, code lost:
    
        if (r12 != null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00c2, code lost:
    
        throw r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00c3, code lost:
    
        throw r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00cb, code lost:
    
        throw new java.lang.IllegalStateException("'ApplicationStarter.initialize(context)' must be called first at app start.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00cc, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0013, code lost:
    
        if (r11 == null) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0016, code lost:
    
        if (r11 == null) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0018, code lost:
    
        return null;
     */
    @Override // net.time4j.base.ResourceLoader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.io.InputStream load(java.net.URI r11, boolean r12) {
        /*
            Method dump skipped, instruction units count: 205
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: net.time4j.android.spi.AndroidResourceLoader.load(java.net.URI, boolean):java.io.InputStream");
    }

    @Override // net.time4j.base.ResourceLoader
    public <S> Iterable<S> services(Class<S> cls) {
        Iterable<?> iterable = PROVIDERS.get(cls);
        if (iterable == null) {
            if (cls == FormatPatternProvider.class) {
                iterable = this.patterns;
            } else {
                return ServiceLoader.load(cls, cls.getClassLoader());
            }
        }
        return (Iterable) cast(iterable);
    }

    class AndroidFormatPatterns implements ExtendedPatterns {
        private AndroidFormatPatterns() {
        }

        /* synthetic */ AndroidFormatPatterns(AndroidResourceLoader androidResourceLoader, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // net.time4j.format.FormatPatternProvider
        public String getDatePattern(DisplayMode displayMode, Locale locale) {
            return getDelegate().getDatePattern(displayMode, locale);
        }

        @Override // net.time4j.format.FormatPatternProvider
        public String getTimePattern(DisplayMode displayMode, Locale locale) {
            return getTimePattern(displayMode, locale, false);
        }

        @Override // net.time4j.format.internal.ExtendedPatterns
        public String getTimePattern(DisplayMode displayMode, Locale locale, boolean z) {
            String timePattern = getDelegate().getTimePattern(displayMode, locale, z);
            if (Locale.getDefault().equals(locale)) {
                DisplayMode displayMode2 = DisplayMode.SHORT;
                boolean z2 = (displayMode != displayMode2 ? getDelegate().getTimePattern(displayMode2, locale) : timePattern).indexOf(97) == -1;
                boolean zIs24HourFormat = DateFormat.is24HourFormat(AndroidResourceLoader.this.context);
                if (zIs24HourFormat != z2) {
                    if (zIs24HourFormat) {
                        return to24HourFormat(timePattern).replace(TSLog.TAB, StringUtils.SPACE).trim();
                    }
                    String str = locale.getLanguage().equals("en") ? "b" : "B";
                    int i = AnonymousClass1.$SwitchMap$net$time4j$format$DisplayMode[displayMode.ordinal()];
                    if (i == 1) {
                        return "h:mm:ss " + str + " zzzz";
                    }
                    if (i == 2) {
                        return "h:mm:ss " + str + " z";
                    }
                    if (i == 3) {
                        return "h:mm:ss " + str;
                    }
                    return "h:mm " + str;
                }
            }
            return timePattern;
        }

        @Override // net.time4j.format.FormatPatternProvider
        public String getDateTimePattern(DisplayMode displayMode, DisplayMode displayMode2, Locale locale) {
            return getDelegate().getDateTimePattern(displayMode, displayMode2, locale);
        }

        @Override // net.time4j.format.FormatPatternProvider
        public String getIntervalPattern(Locale locale) {
            return getDelegate().getIntervalPattern(locale);
        }

        private String to24HourFormat(String str) {
            int i;
            StringBuilder sb = new StringBuilder();
            int length = str.length();
            int i2 = 0;
            while (i2 < length) {
                char cCharAt = str.charAt(i2);
                if (cCharAt == '\'') {
                    sb.append(cCharAt);
                    while (true) {
                        i = i2 + 1;
                        if (i >= length) {
                            break;
                        }
                        char cCharAt2 = str.charAt(i);
                        if (cCharAt2 == '\'') {
                            sb.append(cCharAt2);
                            i2 += 2;
                            if (i2 >= length || str.charAt(i2) != '\'') {
                                break;
                            }
                        } else {
                            i2 = i;
                        }
                        sb.append(cCharAt2);
                    }
                    i2 = i;
                } else if (cCharAt == 'h') {
                    sb.append('H');
                } else if (cCharAt != 'a') {
                    sb.append(cCharAt);
                }
                i2++;
            }
            return sb.toString();
        }

        private ExtendedPatterns getDelegate() {
            return I18nDataHolder.ISODATA;
        }
    }

    /* JADX INFO: renamed from: net.time4j.android.spi.AndroidResourceLoader$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$net$time4j$format$DisplayMode;

        static {
            int[] iArr = new int[DisplayMode.values().length];
            $SwitchMap$net$time4j$format$DisplayMode = iArr;
            try {
                iArr[DisplayMode.FULL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$net$time4j$format$DisplayMode[DisplayMode.LONG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$net$time4j$format$DisplayMode[DisplayMode.MEDIUM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static final class LazyNumberSymbols implements Iterable<NumberSymbolProvider> {
        private LazyNumberSymbols() {
        }

        /* synthetic */ LazyNumberSymbols(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.lang.Iterable
        public Iterator<NumberSymbolProvider> iterator() {
            return I18nDataHolder.SYMBOLS.iterator();
        }
    }

    static final class LazyWeekdata implements Iterable<WeekdataProvider> {
        private LazyWeekdata() {
        }

        /* synthetic */ LazyWeekdata(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.lang.Iterable
        public Iterator<WeekdataProvider> iterator() {
            return I18nDataHolder.WEEKDATA.iterator();
        }
    }

    static final class LazyTextdata implements Iterable<TextProvider> {
        private LazyTextdata() {
        }

        /* synthetic */ LazyTextdata(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.lang.Iterable
        public Iterator<TextProvider> iterator() {
            return I18nDataHolder.TEXTDATA.iterator();
        }
    }

    static final class LazyZoneRules implements Iterable<ZoneModelProvider> {
        private LazyZoneRules() {
        }

        /* synthetic */ LazyZoneRules(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.lang.Iterable
        public Iterator<ZoneModelProvider> iterator() {
            return ZoneDataHolder.RULES.iterator();
        }
    }

    static final class LazyZoneNames implements Iterable<ZoneNameProvider> {
        private LazyZoneNames() {
        }

        /* synthetic */ LazyZoneNames(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.lang.Iterable
        public Iterator<ZoneNameProvider> iterator() {
            return ZoneDataHolder.NAMES.iterator();
        }
    }

    static final class LazyLeapseconds implements Iterable<LeapSecondProvider> {
        private LazyLeapseconds() {
        }

        /* synthetic */ LazyLeapseconds(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.lang.Iterable
        public Iterator<LeapSecondProvider> iterator() {
            return ZoneDataHolder.LEAPSECONDS.iterator();
        }
    }

    static final class LazyPluraldata implements Iterable<PluralProvider> {
        private LazyPluraldata() {
        }

        /* synthetic */ LazyPluraldata(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.lang.Iterable
        public Iterator<PluralProvider> iterator() {
            return StatelessIterables.PLURALS.iterator();
        }
    }

    static final class LazyExtensions implements Iterable<ChronoExtension> {
        private LazyExtensions() {
        }

        /* synthetic */ LazyExtensions(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.lang.Iterable
        public Iterator<ChronoExtension> iterator() {
            return StatelessIterables.EXTENSIONS.iterator();
        }
    }

    static final class I18nDataHolder {
        private static final IsoTextProviderSPI ISODATA;
        private static final Iterable<NumberSymbolProvider> SYMBOLS;
        private static final Iterable<TextProvider> TEXTDATA;
        private static final Iterable<WeekdataProvider> WEEKDATA;

        private I18nDataHolder() {
        }

        static {
            IsoTextProviderSPI isoTextProviderSPI = new IsoTextProviderSPI();
            ISODATA = isoTextProviderSPI;
            SYMBOLS = Collections.singleton(SymbolProviderSPI.INSTANCE);
            WEEKDATA = Collections.singletonList(new WeekdataProviderSPI());
            TEXTDATA = Collections.unmodifiableList(Arrays.asList(isoTextProviderSPI, new GenericTextProviderSPI()));
        }
    }

    static final class ZoneDataHolder {
        private static final Iterable<LeapSecondProvider> LEAPSECONDS;
        private static final Iterable<ZoneNameProvider> NAMES;
        private static final Iterable<ZoneModelProvider> RULES;

        private ZoneDataHolder() {
        }

        static {
            LeapSecondProvider leapSecondProvider;
            Set setSingleton = Collections.singleton(new TimezoneRepositoryProviderSPI());
            RULES = setSingleton;
            NAMES = Collections.singleton(new ZoneNameProviderSPI());
            Iterator it2 = setSingleton.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    leapSecondProvider = null;
                    break;
                }
                ZoneModelProvider zoneModelProvider = (ZoneModelProvider) it2.next();
                if (zoneModelProvider instanceof LeapSecondProvider) {
                    leapSecondProvider = (LeapSecondProvider) LeapSecondProvider.class.cast(zoneModelProvider);
                    break;
                }
            }
            if (leapSecondProvider == null) {
                LEAPSECONDS = Collections.emptyList();
            } else {
                LEAPSECONDS = Collections.singleton(leapSecondProvider);
            }
        }
    }

    static final class StatelessIterables {
        private static final Iterable<PluralProvider> PLURALS = Collections.singleton(new DefaultPluralProviderSPI());
        private static final Iterable<ChronoExtension> EXTENSIONS = Arrays.asList(new HistoricExtension(), new KoreanExtension());

        private StatelessIterables() {
        }
    }
}
