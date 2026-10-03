package net.time4j.format;

import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import net.time4j.base.ResourceLoader;

/* JADX INFO: loaded from: classes3.dex */
public abstract class PluralRules {
    private static final Map<String, PluralRules> CARDINAL_MAP;
    private static final PluralRules FALLBACK_CARDINAL_ENGLISH;
    private static final PluralRules FALLBACK_CARDINAL_OTHER;
    private static final PluralRules FALLBACK_ORDINAL_ENGLISH;
    private static final PluralRules FALLBACK_ORDINAL_OTHER;
    private static final Map<String, PluralRules> ORDINAL_MAP;

    public abstract PluralCategory getCategory(long j);

    public abstract NumberType getNumberType();

    static {
        NumberType numberType = NumberType.CARDINALS;
        boolean z = true;
        AnonymousClass1 anonymousClass1 = null;
        FALLBACK_CARDINAL_ENGLISH = new FallbackRules(numberType, z, anonymousClass1);
        boolean z2 = false;
        FALLBACK_CARDINAL_OTHER = new FallbackRules(numberType, z2, anonymousClass1);
        NumberType numberType2 = NumberType.ORDINALS;
        FALLBACK_ORDINAL_ENGLISH = new FallbackRules(numberType2, z, anonymousClass1);
        FALLBACK_ORDINAL_OTHER = new FallbackRules(numberType2, z2, anonymousClass1);
        CARDINAL_MAP = new ConcurrentHashMap();
        ORDINAL_MAP = new ConcurrentHashMap();
    }

    public static PluralRules of(Locale locale, NumberType numberType) {
        Map<String, PluralRules> ruleMap = getRuleMap(numberType);
        PluralRules pluralRules = null;
        if (!ruleMap.isEmpty()) {
            pluralRules = locale.getCountry().equals("") ? null : ruleMap.get(toKey(locale));
            if (pluralRules == null) {
                pluralRules = ruleMap.get(locale.getLanguage());
            }
        }
        return pluralRules == null ? Holder.PROVIDER.load(locale, numberType) : pluralRules;
    }

    public static void register(Locale locale, PluralRules pluralRules) {
        Map<String, PluralRules> ruleMap = getRuleMap(pluralRules.getNumberType());
        String language = locale.getLanguage();
        if (!locale.getCountry().equals("")) {
            language = toKey(locale);
        }
        ruleMap.put(language, pluralRules);
    }

    /* JADX INFO: renamed from: net.time4j.format.PluralRules$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$net$time4j$format$NumberType;

        static {
            int[] iArr = new int[NumberType.values().length];
            $SwitchMap$net$time4j$format$NumberType = iArr;
            try {
                iArr[NumberType.CARDINALS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$net$time4j$format$NumberType[NumberType.ORDINALS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private static Map<String, PluralRules> getRuleMap(NumberType numberType) {
        int i = AnonymousClass1.$SwitchMap$net$time4j$format$NumberType[numberType.ordinal()];
        if (i == 1) {
            return CARDINAL_MAP;
        }
        if (i == 2) {
            return ORDINAL_MAP;
        }
        throw new UnsupportedOperationException(numberType.name());
    }

    private static String toKey(Locale locale) {
        return locale.getLanguage() + '_' + locale.getCountry();
    }

    static class FallbackRules extends PluralRules {
        private final boolean english;
        private final NumberType numType;

        /* synthetic */ FallbackRules(NumberType numberType, boolean z, AnonymousClass1 anonymousClass1) {
            this(numberType, z);
        }

        private FallbackRules(NumberType numberType, boolean z) {
            this.numType = numberType;
            this.english = z;
        }

        @Override // net.time4j.format.PluralRules
        public PluralCategory getCategory(long j) {
            int i = AnonymousClass1.$SwitchMap$net$time4j$format$NumberType[this.numType.ordinal()];
            if (i == 1) {
                return j == 1 ? PluralCategory.ONE : PluralCategory.OTHER;
            }
            if (i == 2) {
                if (this.english) {
                    long j2 = j % 10;
                    long j3 = j % 100;
                    if (j2 == 1 && j3 != 11) {
                        return PluralCategory.ONE;
                    }
                    if (j2 == 2 && j3 != 12) {
                        return PluralCategory.TWO;
                    }
                    if (j2 == 3 && j3 != 13) {
                        return PluralCategory.FEW;
                    }
                }
                return PluralCategory.OTHER;
            }
            throw new UnsupportedOperationException(this.numType.name());
        }

        @Override // net.time4j.format.PluralRules
        public NumberType getNumberType() {
            return this.numType;
        }
    }

    static class FallbackProvider implements PluralProvider {
        private FallbackProvider() {
        }

        /* synthetic */ FallbackProvider(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // net.time4j.format.PluralProvider
        public PluralRules load(Locale locale, NumberType numberType) {
            boolean zEquals = locale.getLanguage().equals("en");
            int i = AnonymousClass1.$SwitchMap$net$time4j$format$NumberType[numberType.ordinal()];
            if (i == 1) {
                return zEquals ? PluralRules.FALLBACK_CARDINAL_ENGLISH : PluralRules.FALLBACK_CARDINAL_OTHER;
            }
            if (i == 2) {
                return zEquals ? PluralRules.FALLBACK_ORDINAL_ENGLISH : PluralRules.FALLBACK_ORDINAL_OTHER;
            }
            throw new UnsupportedOperationException(numberType.name());
        }
    }

    static class Holder {
        private static final PluralProvider PROVIDER;

        private Holder() {
        }

        static {
            Iterator it2 = ResourceLoader.getInstance().services(PluralProvider.class).iterator();
            AnonymousClass1 anonymousClass1 = null;
            PluralProvider fallbackProvider = it2.hasNext() ? (PluralProvider) it2.next() : null;
            if (fallbackProvider == null) {
                fallbackProvider = new FallbackProvider(anonymousClass1);
            }
            PROVIDER = fallbackProvider;
        }
    }
}
