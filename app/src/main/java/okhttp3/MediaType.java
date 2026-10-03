package okhttp3;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class MediaType {
    private static final String QUOTED = "\"([^\"]*)\"";
    private static final String TOKEN = "([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)";
    private final String charset;
    private final String mediaType;
    private final String subtype;
    private final String type;
    public static final Companion Companion = new Companion(null);
    private static final Pattern TYPE_SUBTYPE = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
    private static final Pattern PARAMETER = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    @JvmStatic
    public static final MediaType get(@NotNull String str) {
        return Companion.get(str);
    }

    @JvmStatic
    public static final MediaType parse(@NotNull String str) {
        return Companion.parse(str);
    }

    public final Charset charset() {
        return charset$default(this, null, 1, null);
    }

    private MediaType(String str, String str2, String str3, String str4) {
        this.mediaType = str;
        this.type = str2;
        this.subtype = str3;
        this.charset = str4;
    }

    public /* synthetic */ MediaType(String str, String str2, String str3, String str4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4);
    }

    public final String type() {
        return this.type;
    }

    public final String subtype() {
        return this.subtype;
    }

    public static /* synthetic */ Charset charset$default(MediaType mediaType, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = null;
        }
        return mediaType.charset(charset);
    }

    public final Charset charset(@Nullable Charset charset) {
        try {
            String str = this.charset;
            return str != null ? Charset.forName(str) : charset;
        } catch (IllegalArgumentException unused) {
            return charset;
        }
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "type", imports = {}))
    /* JADX INFO: renamed from: -deprecated_type, reason: not valid java name */
    public final String m7192deprecated_type() {
        return this.type;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "subtype", imports = {}))
    /* JADX INFO: renamed from: -deprecated_subtype, reason: not valid java name */
    public final String m7191deprecated_subtype() {
        return this.subtype;
    }

    public String toString() {
        return this.mediaType;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof MediaType) && Intrinsics.areEqual(((MediaType) obj).mediaType, this.mediaType);
    }

    public int hashCode() {
        return this.mediaType.hashCode();
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final MediaType get(@NotNull String toMediaType) {
            Intrinsics.checkParameterIsNotNull(toMediaType, "$this$toMediaType");
            Matcher matcher = MediaType.TYPE_SUBTYPE.matcher(toMediaType);
            if (!matcher.lookingAt()) {
                throw new IllegalArgumentException(("No subtype found for: \"" + toMediaType + '\"').toString());
            }
            String strGroup = matcher.group(1);
            Intrinsics.checkExpressionValueIsNotNull(strGroup, "typeSubtype.group(1)");
            Locale locale = Locale.US;
            Intrinsics.checkExpressionValueIsNotNull(locale, "Locale.US");
            if (strGroup == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String lowerCase = strGroup.toLowerCase(locale);
            Intrinsics.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            String strGroup2 = matcher.group(2);
            Intrinsics.checkExpressionValueIsNotNull(strGroup2, "typeSubtype.group(2)");
            Intrinsics.checkExpressionValueIsNotNull(locale, "Locale.US");
            if (strGroup2 != null) {
                String lowerCase2 = strGroup2.toLowerCase(locale);
                Intrinsics.checkExpressionValueIsNotNull(lowerCase2, "(this as java.lang.String).toLowerCase(locale)");
                Matcher matcher2 = MediaType.PARAMETER.matcher(toMediaType);
                int iEnd = matcher.end();
                String str = null;
                while (iEnd < toMediaType.length()) {
                    matcher2.region(iEnd, toMediaType.length());
                    if (!matcher2.lookingAt()) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Parameter is not formatted correctly: \"");
                        String strSubstring = toMediaType.substring(iEnd);
                        Intrinsics.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.String).substring(startIndex)");
                        sb.append(strSubstring);
                        sb.append("\" for: \"");
                        sb.append(toMediaType);
                        sb.append('\"');
                        throw new IllegalArgumentException(sb.toString().toString());
                    }
                    String strGroup3 = matcher2.group(1);
                    if (strGroup3 == null || !StringsKt__StringsJVMKt.equals(strGroup3, "charset", true)) {
                        iEnd = matcher2.end();
                    } else {
                        String strGroup4 = matcher2.group(2);
                        if (strGroup4 == null) {
                            strGroup4 = matcher2.group(3);
                            Intrinsics.checkExpressionValueIsNotNull(strGroup4, "parameter.group(3)");
                        } else if (StringsKt__StringsJVMKt.startsWith$default(strGroup4, "'", false, 2, null) && StringsKt__StringsJVMKt.endsWith$default(strGroup4, "'", false, 2, null) && strGroup4.length() > 2) {
                            strGroup4 = strGroup4.substring(1, strGroup4.length() - 1);
                            Intrinsics.checkExpressionValueIsNotNull(strGroup4, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        }
                        if (str != null && !StringsKt__StringsJVMKt.equals(strGroup4, str, true)) {
                            throw new IllegalArgumentException(("Multiple charsets defined: \"" + str + "\" and: \"" + strGroup4 + "\" for: \"" + toMediaType + '\"').toString());
                        }
                        str = strGroup4;
                        iEnd = matcher2.end();
                    }
                }
                return new MediaType(toMediaType, lowerCase, lowerCase2, str, null);
            }
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }

        @JvmStatic
        public final MediaType parse(@NotNull String toMediaTypeOrNull) {
            Intrinsics.checkParameterIsNotNull(toMediaTypeOrNull, "$this$toMediaTypeOrNull");
            try {
                return get(toMediaTypeOrNull);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "mediaType.toMediaType()", imports = {"okhttp3.MediaType.Companion.toMediaType"}))
        /* JADX INFO: renamed from: -deprecated_get, reason: not valid java name */
        public final MediaType m7193deprecated_get(@NotNull String mediaType) {
            Intrinsics.checkParameterIsNotNull(mediaType, "mediaType");
            return get(mediaType);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "mediaType.toMediaTypeOrNull()", imports = {"okhttp3.MediaType.Companion.toMediaTypeOrNull"}))
        /* JADX INFO: renamed from: -deprecated_parse, reason: not valid java name */
        public final MediaType m7194deprecated_parse(@NotNull String mediaType) {
            Intrinsics.checkParameterIsNotNull(mediaType, "mediaType");
            return parse(mediaType);
        }
    }
}
