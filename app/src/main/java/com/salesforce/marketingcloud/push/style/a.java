package com.salesforce.marketingcloud.push.style;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.TypedValue;
import androidx.core.graphics.ColorUtils;
import com.salesforce.marketingcloud.g;
import com.salesforce.marketingcloud.push.data.Style;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public interface a<T> {
    public static final C0109a a = C0109a.a;
    public static final float b = 3.0f;
    public static final String c = "#333333";

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.push.style.a$a, reason: collision with other inner class name */
    public static final class C0109a {
        public static final float b = 3.0f;
        public static final String c = "#333333";
        static final /* synthetic */ C0109a a = new C0109a();
        private static final String d = g.a("ViewStyler");

        private C0109a() {
        }

        public final String a() {
            return d;
        }
    }

    public static final class b implements a<com.salesforce.marketingcloud.push.data.c> {
        private final Context d;

        /* JADX INFO: renamed from: com.salesforce.marketingcloud.push.style.a$b$a, reason: collision with other inner class name */
        public final /* synthetic */ class C0110a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[Style.FontStyle.values().length];
                try {
                    iArr[Style.FontStyle.B.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[Style.FontStyle.I.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[Style.FontStyle.R.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                a = iArr;
            }
        }

        /* JADX INFO: renamed from: com.salesforce.marketingcloud.push.style.a$b$b, reason: collision with other inner class name */
        static final class C0111b extends Lambda implements Function0<String> {
            public static final C0111b b = new C0111b();

            C0111b() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final String invoke() {
                return "ignore fontColor in dark mode as it fails contrast checks";
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
                return "Failed to apply style to text.";
            }
        }

        public b(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.d = context;
        }

        @Override // com.salesforce.marketingcloud.push.style.a
        public com.salesforce.marketingcloud.push.data.c a(@NotNull com.salesforce.marketingcloud.push.data.c t, @NotNull Style.FontStyle defaultStyle) {
            Style.b bVar;
            Style.FontStyle fontStyleB;
            Style.Size sizeC;
            String strG;
            Intrinsics.checkNotNullParameter(t, "t");
            Intrinsics.checkNotNullParameter(defaultStyle, "defaultStyle");
            SpannableString spannableString = new SpannableString(t.n());
            try {
                Style.b bVarA = t.a();
                if (bVarA != null && (strG = bVarA.g()) != null) {
                    int color = Color.parseColor(strG);
                    if (!a() || a(color, Color.parseColor("#333333")) > 3.0d) {
                        spannableString.setSpan(new ForegroundColorSpan(color), 0, spannableString.length(), 0);
                    } else {
                        g.a(g.a, a.a.a(), null, C0111b.b, 2, null);
                    }
                }
                Style.b bVarA2 = t.a();
                if (bVarA2 == null || (fontStyleB = bVarA2.b()) == null) {
                    fontStyleB = defaultStyle;
                }
                int i = C0110a.a[fontStyleB.ordinal()];
                if (i == 1) {
                    spannableString.setSpan(new StyleSpan(1), 0, spannableString.length(), 0);
                } else if (i == 2) {
                    spannableString.setSpan(new StyleSpan(2), 0, spannableString.length(), 0);
                }
                Style.b bVarA3 = t.a();
                if (bVarA3 != null && (sizeC = bVarA3.c()) != null) {
                    spannableString.setSpan(new AbsoluteSizeSpan((int) TypedValue.applyDimension(2, sizeC.toSP(), this.d.getResources().getDisplayMetrics())), 0, spannableString.length(), 0);
                }
            } catch (Exception e) {
                g.a.b(a.a.a(), e, c.b);
            }
            Style.b bVarA4 = t.a();
            if (bVarA4 == null || (bVar = Style.b.a(bVarA4, null, null, null, null, null, spannableString, 31, null)) == null) {
                bVar = new Style.b(null, null, null, null, null, spannableString, 31, null);
            }
            return com.salesforce.marketingcloud.push.data.c.a(t, null, bVar, null, 5, null);
        }

        private final boolean a() {
            return (this.d.getResources().getConfiguration().uiMode & 48) == 32;
        }

        private final double a(int i, int i2) {
            double dCalculateLuminance = ColorUtils.calculateLuminance(i);
            double dCalculateLuminance2 = ColorUtils.calculateLuminance(i2);
            return dCalculateLuminance > dCalculateLuminance2 ? (dCalculateLuminance + 0.05d) / (dCalculateLuminance2 + 0.05d) : (dCalculateLuminance2 + 0.05d) / (dCalculateLuminance + 0.05d);
        }
    }

    static /* synthetic */ Object a(a aVar, Object obj, Style.FontStyle fontStyle, int i, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: apply");
        }
        if ((i & 2) != 0) {
            fontStyle = Style.FontStyle.R;
        }
        return aVar.a(obj, fontStyle);
    }

    T a(T t, @NotNull Style.FontStyle fontStyle);
}
