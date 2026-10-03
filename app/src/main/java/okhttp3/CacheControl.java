package okhttp3;

import com.google.common.net.HttpHeaders;
import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import net.openid.appauth.RegistrationRequest;
import okhttp3.internal.Util;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public final class CacheControl {
    private String headerValue;
    private final boolean immutable;
    private final boolean isPrivate;
    private final boolean isPublic;
    private final int maxAgeSeconds;
    private final int maxStaleSeconds;
    private final int minFreshSeconds;
    private final boolean mustRevalidate;
    private final boolean noCache;
    private final boolean noStore;
    private final boolean noTransform;
    private final boolean onlyIfCached;
    private final int sMaxAgeSeconds;
    public static final Companion Companion = new Companion(null);
    public static final CacheControl FORCE_NETWORK = new Builder().noCache().build();
    public static final CacheControl FORCE_CACHE = new Builder().onlyIfCached().maxStale(Integer.MAX_VALUE, TimeUnit.SECONDS).build();

    @JvmStatic
    public static final CacheControl parse(@NotNull Headers headers) {
        return Companion.parse(headers);
    }

    private CacheControl(boolean z, boolean z2, int i, int i2, boolean z3, boolean z4, boolean z5, int i3, int i4, boolean z6, boolean z7, boolean z8, String str) {
        this.noCache = z;
        this.noStore = z2;
        this.maxAgeSeconds = i;
        this.sMaxAgeSeconds = i2;
        this.isPrivate = z3;
        this.isPublic = z4;
        this.mustRevalidate = z5;
        this.maxStaleSeconds = i3;
        this.minFreshSeconds = i4;
        this.onlyIfCached = z6;
        this.noTransform = z7;
        this.immutable = z8;
        this.headerValue = str;
    }

    public /* synthetic */ CacheControl(boolean z, boolean z2, int i, int i2, boolean z3, boolean z4, boolean z5, int i3, int i4, boolean z6, boolean z7, boolean z8, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, z2, i, i2, z3, z4, z5, i3, i4, z6, z7, z8, str);
    }

    public final boolean noCache() {
        return this.noCache;
    }

    public final boolean noStore() {
        return this.noStore;
    }

    public final int maxAgeSeconds() {
        return this.maxAgeSeconds;
    }

    public final int sMaxAgeSeconds() {
        return this.sMaxAgeSeconds;
    }

    public final boolean isPrivate() {
        return this.isPrivate;
    }

    public final boolean isPublic() {
        return this.isPublic;
    }

    public final boolean mustRevalidate() {
        return this.mustRevalidate;
    }

    public final int maxStaleSeconds() {
        return this.maxStaleSeconds;
    }

    public final int minFreshSeconds() {
        return this.minFreshSeconds;
    }

    public final boolean onlyIfCached() {
        return this.onlyIfCached;
    }

    public final boolean noTransform() {
        return this.noTransform;
    }

    public final boolean immutable() {
        return this.immutable;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "noCache", imports = {}))
    /* JADX INFO: renamed from: -deprecated_noCache, reason: not valid java name */
    public final boolean m7134deprecated_noCache() {
        return this.noCache;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "noStore", imports = {}))
    /* JADX INFO: renamed from: -deprecated_noStore, reason: not valid java name */
    public final boolean m7135deprecated_noStore() {
        return this.noStore;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "maxAgeSeconds", imports = {}))
    /* JADX INFO: renamed from: -deprecated_maxAgeSeconds, reason: not valid java name */
    public final int m7130deprecated_maxAgeSeconds() {
        return this.maxAgeSeconds;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "sMaxAgeSeconds", imports = {}))
    /* JADX INFO: renamed from: -deprecated_sMaxAgeSeconds, reason: not valid java name */
    public final int m7138deprecated_sMaxAgeSeconds() {
        return this.sMaxAgeSeconds;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "mustRevalidate", imports = {}))
    /* JADX INFO: renamed from: -deprecated_mustRevalidate, reason: not valid java name */
    public final boolean m7133deprecated_mustRevalidate() {
        return this.mustRevalidate;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "maxStaleSeconds", imports = {}))
    /* JADX INFO: renamed from: -deprecated_maxStaleSeconds, reason: not valid java name */
    public final int m7131deprecated_maxStaleSeconds() {
        return this.maxStaleSeconds;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "minFreshSeconds", imports = {}))
    /* JADX INFO: renamed from: -deprecated_minFreshSeconds, reason: not valid java name */
    public final int m7132deprecated_minFreshSeconds() {
        return this.minFreshSeconds;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "onlyIfCached", imports = {}))
    /* JADX INFO: renamed from: -deprecated_onlyIfCached, reason: not valid java name */
    public final boolean m7137deprecated_onlyIfCached() {
        return this.onlyIfCached;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "noTransform", imports = {}))
    /* JADX INFO: renamed from: -deprecated_noTransform, reason: not valid java name */
    public final boolean m7136deprecated_noTransform() {
        return this.noTransform;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "immutable", imports = {}))
    /* JADX INFO: renamed from: -deprecated_immutable, reason: not valid java name */
    public final boolean m7129deprecated_immutable() {
        return this.immutable;
    }

    public String toString() {
        String str = this.headerValue;
        if (str != null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        if (this.noCache) {
            sb.append("no-cache, ");
        }
        if (this.noStore) {
            sb.append("no-store, ");
        }
        if (this.maxAgeSeconds != -1) {
            sb.append("max-age=");
            sb.append(this.maxAgeSeconds);
            sb.append(", ");
        }
        if (this.sMaxAgeSeconds != -1) {
            sb.append("s-maxage=");
            sb.append(this.sMaxAgeSeconds);
            sb.append(", ");
        }
        if (this.isPrivate) {
            sb.append("private, ");
        }
        if (this.isPublic) {
            sb.append("public, ");
        }
        if (this.mustRevalidate) {
            sb.append("must-revalidate, ");
        }
        if (this.maxStaleSeconds != -1) {
            sb.append("max-stale=");
            sb.append(this.maxStaleSeconds);
            sb.append(", ");
        }
        if (this.minFreshSeconds != -1) {
            sb.append("min-fresh=");
            sb.append(this.minFreshSeconds);
            sb.append(", ");
        }
        if (this.onlyIfCached) {
            sb.append("only-if-cached, ");
        }
        if (this.noTransform) {
            sb.append("no-transform, ");
        }
        if (this.immutable) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        String string = sb.toString();
        Intrinsics.checkExpressionValueIsNotNull(string, "StringBuilder().apply(builderAction).toString()");
        this.headerValue = string;
        return string;
    }

    public static final class Builder {
        private boolean immutable;
        private int maxAgeSeconds = -1;
        private int maxStaleSeconds = -1;
        private int minFreshSeconds = -1;
        private boolean noCache;
        private boolean noStore;
        private boolean noTransform;
        private boolean onlyIfCached;

        private final int clampToInt(long j) {
            if (j > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            return (int) j;
        }

        public final Builder noCache() {
            this.noCache = true;
            return this;
        }

        public final Builder noStore() {
            this.noStore = true;
            return this;
        }

        public final Builder maxAge(int i, @NotNull TimeUnit timeUnit) {
            Intrinsics.checkParameterIsNotNull(timeUnit, "timeUnit");
            if (i < 0) {
                throw new IllegalArgumentException(("maxAge < 0: " + i).toString());
            }
            this.maxAgeSeconds = clampToInt(timeUnit.toSeconds(i));
            return this;
        }

        public final Builder maxStale(int i, @NotNull TimeUnit timeUnit) {
            Intrinsics.checkParameterIsNotNull(timeUnit, "timeUnit");
            if (i < 0) {
                throw new IllegalArgumentException(("maxStale < 0: " + i).toString());
            }
            this.maxStaleSeconds = clampToInt(timeUnit.toSeconds(i));
            return this;
        }

        public final Builder minFresh(int i, @NotNull TimeUnit timeUnit) {
            Intrinsics.checkParameterIsNotNull(timeUnit, "timeUnit");
            if (i < 0) {
                throw new IllegalArgumentException(("minFresh < 0: " + i).toString());
            }
            this.minFreshSeconds = clampToInt(timeUnit.toSeconds(i));
            return this;
        }

        public final Builder onlyIfCached() {
            this.onlyIfCached = true;
            return this;
        }

        public final Builder noTransform() {
            this.noTransform = true;
            return this;
        }

        public final Builder immutable() {
            this.immutable = true;
            return this;
        }

        public final CacheControl build() {
            return new CacheControl(this.noCache, this.noStore, this.maxAgeSeconds, -1, false, false, false, this.maxStaleSeconds, this.minFreshSeconds, this.onlyIfCached, this.noTransform, this.immutable, null, null);
        }
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Code duplicated, block: B:15:0x004b  */
        /* JADX WARN: Code duplicated, block: B:17:0x005e  */
        /* JADX WARN: Code duplicated, block: B:19:0x006c  */
        /* JADX WARN: Code duplicated, block: B:34:0x00cd  */
        /* JADX WARN: Code duplicated, block: B:38:0x00dc  */
        /* JADX WARN: Code duplicated, block: B:39:0x00de  */
        /* JADX WARN: Code duplicated, block: B:41:0x00e6  */
        /* JADX WARN: Code duplicated, block: B:42:0x00e8  */
        /* JADX WARN: Code duplicated, block: B:44:0x00f0  */
        /* JADX WARN: Code duplicated, block: B:46:0x00f8  */
        /* JADX WARN: Code duplicated, block: B:48:0x0101  */
        /* JADX WARN: Code duplicated, block: B:49:0x0106  */
        /* JADX WARN: Code duplicated, block: B:51:0x010e  */
        /* JADX WARN: Code duplicated, block: B:52:0x0110  */
        /* JADX WARN: Code duplicated, block: B:54:0x0118  */
        /* JADX WARN: Code duplicated, block: B:55:0x011b  */
        /* JADX WARN: Code duplicated, block: B:57:0x0123  */
        /* JADX WARN: Code duplicated, block: B:58:0x0126  */
        /* JADX WARN: Code duplicated, block: B:60:0x012e  */
        /* JADX WARN: Code duplicated, block: B:62:0x0137  */
        /* JADX WARN: Code duplicated, block: B:64:0x013f  */
        /* JADX WARN: Code duplicated, block: B:65:0x0145  */
        /* JADX WARN: Code duplicated, block: B:67:0x014e  */
        /* JADX WARN: Code duplicated, block: B:68:0x0151  */
        /* JADX WARN: Code duplicated, block: B:70:0x0159  */
        /* JADX WARN: Code duplicated, block: B:71:0x015c  */
        /* JADX WARN: Code duplicated, block: B:73:0x0164  */
        /* JADX WARN: Code duplicated, block: B:84:0x016e A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:94:0x0166 A[SYNTHETIC] */
        @JvmStatic
        public final CacheControl parse(@NotNull Headers headers) {
            int i;
            int iIndexOfElement;
            String strSubstring;
            String string;
            int i2;
            int iIndexOfElement2;
            String string2;
            byte b;
            Headers headers2 = headers;
            Intrinsics.checkParameterIsNotNull(headers2, "headers");
            int size = headers.size();
            boolean z = true;
            boolean z2 = true;
            int i3 = 0;
            String str = null;
            boolean z3 = false;
            boolean z4 = false;
            int nonNegativeInt = -1;
            int nonNegativeInt2 = -1;
            boolean z5 = false;
            boolean z6 = false;
            boolean z7 = false;
            int nonNegativeInt3 = -1;
            int nonNegativeInt4 = -1;
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            while (i3 < size) {
                String strName = headers2.name(i3);
                String strValue = headers2.value(i3);
                if (!StringsKt__StringsJVMKt.equals(strName, HttpHeaders.CACHE_CONTROL, z)) {
                    if (!StringsKt__StringsJVMKt.equals(strName, HttpHeaders.PRAGMA, z)) {
                        continue;
                    }
                    i3++;
                    headers2 = headers;
                    z = z;
                    size = size;
                } else {
                    if (str == null) {
                        str = strValue;
                    }
                    i = 0;
                    while (i < strValue.length()) {
                        iIndexOfElement = indexOfElement(strValue, "=,;", i);
                        strSubstring = strValue.substring(i, iIndexOfElement);
                        Intrinsics.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        if (strSubstring != null) {
                            throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
                        }
                        string = StringsKt__StringsKt.trim((CharSequence) strSubstring).toString();
                        if (iIndexOfElement != strValue.length()) {
                            i2 = size;
                            if (strValue.charAt(iIndexOfElement) == ',' && strValue.charAt(iIndexOfElement) != ';') {
                                int iIndexOfNonWhitespace = Util.indexOfNonWhitespace(strValue, iIndexOfElement + 1);
                                if (iIndexOfNonWhitespace < strValue.length() && strValue.charAt(iIndexOfNonWhitespace) == '\"') {
                                    int i4 = iIndexOfNonWhitespace + 1;
                                    int iIndexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) strValue, '\"', i4, false, 4, (Object) null);
                                    string2 = strValue.substring(i4, iIndexOf$default);
                                    Intrinsics.checkExpressionValueIsNotNull(string2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                    iIndexOfElement2 = iIndexOf$default + 1;
                                } else {
                                    iIndexOfElement2 = indexOfElement(strValue, ",;", iIndexOfNonWhitespace);
                                    String strSubstring2 = strValue.substring(iIndexOfNonWhitespace, iIndexOfElement2);
                                    Intrinsics.checkExpressionValueIsNotNull(strSubstring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                    if (strSubstring2 == null) {
                                        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
                                    }
                                    string2 = StringsKt__StringsKt.trim((CharSequence) strSubstring2).toString();
                                }
                            }
                            if (StringsKt__StringsJVMKt.equals("no-cache", string, true)) {
                                z3 = true;
                            } else if (StringsKt__StringsJVMKt.equals("no-store", string, true)) {
                                z4 = true;
                            } else {
                                if (StringsKt__StringsJVMKt.equals("max-age", string, true)) {
                                    b = -1;
                                    nonNegativeInt = Util.toNonNegativeInt(string2, -1);
                                } else {
                                    b = -1;
                                    if (StringsKt__StringsJVMKt.equals("s-maxage", string, true)) {
                                        nonNegativeInt2 = Util.toNonNegativeInt(string2, -1);
                                    } else if (StringsKt__StringsJVMKt.equals("private", string, true)) {
                                        z5 = true;
                                    } else if (StringsKt__StringsJVMKt.equals(RegistrationRequest.SUBJECT_TYPE_PUBLIC, string, true)) {
                                        z6 = true;
                                    } else if (StringsKt__StringsJVMKt.equals("must-revalidate", string, true)) {
                                        z7 = true;
                                    } else if (StringsKt__StringsJVMKt.equals("max-stale", string, true)) {
                                        nonNegativeInt3 = Util.toNonNegativeInt(string2, Integer.MAX_VALUE);
                                    } else if (StringsKt__StringsJVMKt.equals("min-fresh", string, true)) {
                                        nonNegativeInt4 = Util.toNonNegativeInt(string2, -1);
                                    } else if (StringsKt__StringsJVMKt.equals("only-if-cached", string, true)) {
                                        z8 = true;
                                    } else if (StringsKt__StringsJVMKt.equals("no-transform", string, true)) {
                                        z9 = true;
                                    } else if (StringsKt__StringsJVMKt.equals("immutable", string, true)) {
                                        z10 = true;
                                    }
                                    i = iIndexOfElement2;
                                    z = true;
                                    size = i2;
                                }
                                i = iIndexOfElement2;
                                z = true;
                                size = i2;
                            }
                            i = iIndexOfElement2;
                            z = true;
                            size = i2;
                        } else {
                            i2 = size;
                        }
                        iIndexOfElement2 = iIndexOfElement + 1;
                        string2 = null;
                        if (StringsKt__StringsJVMKt.equals("no-cache", string, true)) {
                            z3 = true;
                        } else if (StringsKt__StringsJVMKt.equals("no-store", string, true)) {
                            z4 = true;
                        } else {
                            if (StringsKt__StringsJVMKt.equals("max-age", string, true)) {
                                b = -1;
                                nonNegativeInt = Util.toNonNegativeInt(string2, -1);
                            } else {
                                b = -1;
                                if (StringsKt__StringsJVMKt.equals("s-maxage", string, true)) {
                                    nonNegativeInt2 = Util.toNonNegativeInt(string2, -1);
                                } else if (StringsKt__StringsJVMKt.equals("private", string, true)) {
                                    z5 = true;
                                } else if (StringsKt__StringsJVMKt.equals(RegistrationRequest.SUBJECT_TYPE_PUBLIC, string, true)) {
                                    z6 = true;
                                } else if (StringsKt__StringsJVMKt.equals("must-revalidate", string, true)) {
                                    z7 = true;
                                } else if (StringsKt__StringsJVMKt.equals("max-stale", string, true)) {
                                    nonNegativeInt3 = Util.toNonNegativeInt(string2, Integer.MAX_VALUE);
                                } else if (StringsKt__StringsJVMKt.equals("min-fresh", string, true)) {
                                    nonNegativeInt4 = Util.toNonNegativeInt(string2, -1);
                                } else if (StringsKt__StringsJVMKt.equals("only-if-cached", string, true)) {
                                    z8 = true;
                                } else if (StringsKt__StringsJVMKt.equals("no-transform", string, true)) {
                                    z9 = true;
                                } else if (StringsKt__StringsJVMKt.equals("immutable", string, true)) {
                                    z10 = true;
                                }
                                i = iIndexOfElement2;
                                z = true;
                                size = i2;
                            }
                            i = iIndexOfElement2;
                            z = true;
                            size = i2;
                        }
                        i = iIndexOfElement2;
                        z = true;
                        size = i2;
                    }
                    i3++;
                    headers2 = headers;
                    z = z;
                    size = size;
                }
                z2 = false;
                i = 0;
                while (i < strValue.length()) {
                    iIndexOfElement = indexOfElement(strValue, "=,;", i);
                    strSubstring = strValue.substring(i, iIndexOfElement);
                    Intrinsics.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    if (strSubstring != null) {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
                    }
                    string = StringsKt__StringsKt.trim((CharSequence) strSubstring).toString();
                    if (iIndexOfElement != strValue.length()) {
                        i2 = size;
                        if (strValue.charAt(iIndexOfElement) == ',') {
                        }
                        if (StringsKt__StringsJVMKt.equals("no-cache", string, true)) {
                            z3 = true;
                        } else if (StringsKt__StringsJVMKt.equals("no-store", string, true)) {
                            z4 = true;
                        } else {
                            if (StringsKt__StringsJVMKt.equals("max-age", string, true)) {
                                b = -1;
                                nonNegativeInt = Util.toNonNegativeInt(string2, -1);
                            } else {
                                b = -1;
                                if (StringsKt__StringsJVMKt.equals("s-maxage", string, true)) {
                                    nonNegativeInt2 = Util.toNonNegativeInt(string2, -1);
                                } else if (StringsKt__StringsJVMKt.equals("private", string, true)) {
                                    z5 = true;
                                } else if (StringsKt__StringsJVMKt.equals(RegistrationRequest.SUBJECT_TYPE_PUBLIC, string, true)) {
                                    z6 = true;
                                } else if (StringsKt__StringsJVMKt.equals("must-revalidate", string, true)) {
                                    z7 = true;
                                } else if (StringsKt__StringsJVMKt.equals("max-stale", string, true)) {
                                    nonNegativeInt3 = Util.toNonNegativeInt(string2, Integer.MAX_VALUE);
                                } else if (StringsKt__StringsJVMKt.equals("min-fresh", string, true)) {
                                    nonNegativeInt4 = Util.toNonNegativeInt(string2, -1);
                                } else if (StringsKt__StringsJVMKt.equals("only-if-cached", string, true)) {
                                    z8 = true;
                                } else if (StringsKt__StringsJVMKt.equals("no-transform", string, true)) {
                                    z9 = true;
                                } else if (StringsKt__StringsJVMKt.equals("immutable", string, true)) {
                                    z10 = true;
                                }
                                i = iIndexOfElement2;
                                z = true;
                                size = i2;
                            }
                            i = iIndexOfElement2;
                            z = true;
                            size = i2;
                        }
                        i = iIndexOfElement2;
                        z = true;
                        size = i2;
                    } else {
                        i2 = size;
                    }
                    iIndexOfElement2 = iIndexOfElement + 1;
                    string2 = null;
                    if (StringsKt__StringsJVMKt.equals("no-cache", string, true)) {
                        z3 = true;
                    } else if (StringsKt__StringsJVMKt.equals("no-store", string, true)) {
                        z4 = true;
                    } else {
                        if (StringsKt__StringsJVMKt.equals("max-age", string, true)) {
                            b = -1;
                            nonNegativeInt = Util.toNonNegativeInt(string2, -1);
                        } else {
                            b = -1;
                            if (StringsKt__StringsJVMKt.equals("s-maxage", string, true)) {
                                nonNegativeInt2 = Util.toNonNegativeInt(string2, -1);
                            } else if (StringsKt__StringsJVMKt.equals("private", string, true)) {
                                z5 = true;
                            } else if (StringsKt__StringsJVMKt.equals(RegistrationRequest.SUBJECT_TYPE_PUBLIC, string, true)) {
                                z6 = true;
                            } else if (StringsKt__StringsJVMKt.equals("must-revalidate", string, true)) {
                                z7 = true;
                            } else if (StringsKt__StringsJVMKt.equals("max-stale", string, true)) {
                                nonNegativeInt3 = Util.toNonNegativeInt(string2, Integer.MAX_VALUE);
                            } else if (StringsKt__StringsJVMKt.equals("min-fresh", string, true)) {
                                nonNegativeInt4 = Util.toNonNegativeInt(string2, -1);
                            } else if (StringsKt__StringsJVMKt.equals("only-if-cached", string, true)) {
                                z8 = true;
                            } else if (StringsKt__StringsJVMKt.equals("no-transform", string, true)) {
                                z9 = true;
                            } else if (StringsKt__StringsJVMKt.equals("immutable", string, true)) {
                                z10 = true;
                            }
                            i = iIndexOfElement2;
                            z = true;
                            size = i2;
                        }
                        i = iIndexOfElement2;
                        z = true;
                        size = i2;
                    }
                    i = iIndexOfElement2;
                    z = true;
                    size = i2;
                }
                i3++;
                headers2 = headers;
                z = z;
                size = size;
            }
            return new CacheControl(z3, z4, nonNegativeInt, nonNegativeInt2, z5, z6, z7, nonNegativeInt3, nonNegativeInt4, z8, z9, z10, !z2 ? null : str, null);
        }

        static /* synthetic */ int indexOfElement$default(Companion companion, String str, String str2, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                i = 0;
            }
            return companion.indexOfElement(str, str2, i);
        }

        private final int indexOfElement(@NotNull String str, String str2, int i) {
            int length = str.length();
            while (i < length) {
                if (StringsKt__StringsKt.contains$default((CharSequence) str2, str.charAt(i), false, 2, (Object) null)) {
                    return i;
                }
                i++;
            }
            return str.length();
        }
    }
}
