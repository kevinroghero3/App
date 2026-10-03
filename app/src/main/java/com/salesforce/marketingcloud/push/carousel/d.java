package com.salesforce.marketingcloud.push.carousel;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.DisplayMetrics;
import android.widget.RemoteViews;
import androidx.compose.ui.graphics.BlendModeColorFilterHelper$$ExternalSyntheticApiModelOutline2;
import androidx.compose.ui.graphics.BlendModeColorFilterHelper$$ExternalSyntheticApiModelOutline3;
import com.salesforce.marketingcloud.R;
import com.salesforce.marketingcloud.media.u;
import com.salesforce.marketingcloud.push.data.Style;
import java.util.Collection;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements com.salesforce.marketingcloud.push.k<com.salesforce.marketingcloud.push.carousel.a> {
    private final com.salesforce.marketingcloud.push.carousel.b a;
    private final Context b;
    private final com.salesforce.marketingcloud.media.o c;
    private final String d;
    private final com.salesforce.marketingcloud.push.style.a.b e;

    static final class a extends Lambda implements Function0<String> {
        final /* synthetic */ Ref.IntRef b;
        final /* synthetic */ Ref.IntRef c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Ref.IntRef intRef, Ref.IntRef intRef2) {
            super(0);
            this.b = intRef;
            this.c = intRef2;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return "safe dimension::imageHeight " + this.b.element + " , imageWidth " + this.c.element;
        }
    }

    static final class b extends Lambda implements Function0<String> {
        final /* synthetic */ Ref.IntRef b;
        final /* synthetic */ Ref.IntRef c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Ref.IntRef intRef, Ref.IntRef intRef2) {
            super(0);
            this.b = intRef;
            this.c = intRef2;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return "ratio adjusted safe dimension::imageHeight " + this.b.element + " , imageWidth " + this.c.element;
        }
    }

    static final class c extends Lambda implements Function0<String> {
        final /* synthetic */ int b;
        final /* synthetic */ int c;
        final /* synthetic */ int d;
        final /* synthetic */ int e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(int i, int i2, int i3, int i4) {
            super(0);
            this.b = i;
            this.c = i2;
            this.d = i3;
            this.e = i4;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return " getCarouselImageHeight captionsOnly" + this.b + " subCaptionOnly" + this.c + " captionWithSubCaption" + this.d + " noCaptionSubCaption " + this.e + StringUtils.SPACE;
        }
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.push.carousel.d$d, reason: collision with other inner class name */
    static final class C0097d extends Lambda implements Function0<String> {
        final /* synthetic */ Ref.IntRef b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0097d(Ref.IntRef intRef) {
            super(0);
            this.b = intRef;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return " captionWithSubCaption enter:" + this.b.element;
        }
    }

    static final class e extends Lambda implements Function0<String> {
        final /* synthetic */ Ref.IntRef b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(Ref.IntRef intRef) {
            super(0);
            this.b = intRef;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return "noCaptionSubCaption :" + this.b.element;
        }
    }

    static final class f extends Lambda implements Function0<String> {
        final /* synthetic */ Ref.IntRef b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(Ref.IntRef intRef) {
            super(0);
            this.b = intRef;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return "captionsOnly :" + this.b.element;
        }
    }

    static final class g extends Lambda implements Function0<String> {
        final /* synthetic */ Ref.IntRef b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(Ref.IntRef intRef) {
            super(0);
            this.b = intRef;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return "subCaptionOnly :" + this.b.element;
        }
    }

    static final class h extends Lambda implements Function0<String> {
        final /* synthetic */ int b;
        final /* synthetic */ int c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(int i, int i2) {
            super(0);
            this.b = i;
            this.c = i2;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return "captionsOnly :" + this.b + " and subCaptionOnly " + this.c;
        }
    }

    static final class i extends Lambda implements Function0<String> {
        final /* synthetic */ DisplayMetrics b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(DisplayMetrics displayMetrics) {
            super(0);
            this.b = displayMetrics;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return "displayMetrics " + this.b;
        }
    }

    static final class j extends Lambda implements Function0<String> {
        final /* synthetic */ DisplayMetrics b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(DisplayMetrics displayMetrics) {
            super(0);
            this.b = displayMetrics;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return "displayMetrics DPI " + this.b.densityDpi;
        }
    }

    static final class k extends Lambda implements Function0<String> {
        final /* synthetic */ Ref.IntRef b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        k(Ref.IntRef intRef) {
            super(0);
            this.b = intRef;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return "API > 31 decorationWidth " + this.b.element;
        }
    }

    static final class l extends Lambda implements Function0<String> {
        final /* synthetic */ Ref.IntRef b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        l(Ref.IntRef intRef) {
            super(0);
            this.b = intRef;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return "API < 31 decorationWidth " + this.b.element;
        }
    }

    static final class m extends Lambda implements Function0<String> {
        final /* synthetic */ Bitmap b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        m(Bitmap bitmap) {
            super(0);
            this.b = bitmap;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return "getScaledBitmapFromDrawable default bitmap W:" + this.b.getWidth() + "  H:" + this.b.getHeight();
        }
    }

    static final class n extends Lambda implements Function0<String> {
        final /* synthetic */ Bitmap b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        n(Bitmap bitmap) {
            super(0);
            this.b = bitmap;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return "getScaledBitmapFromDrawable scaled bitmap W:" + this.b.getWidth() + "  H:" + this.b.getHeight();
        }
    }

    public static final class o implements com.salesforce.marketingcloud.media.f {
        final /* synthetic */ com.salesforce.marketingcloud.push.carousel.a.C0095a b;

        static final class a extends Lambda implements Function0<String> {
            final /* synthetic */ com.salesforce.marketingcloud.push.carousel.a.C0095a b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(com.salesforce.marketingcloud.push.carousel.a.C0095a c0095a) {
                super(0);
                this.b = c0095a;
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final String invoke() {
                return "Preloading of the image failed. " + this.b.p().o();
            }
        }

        o(com.salesforce.marketingcloud.push.carousel.a.C0095a c0095a) {
            this.b = c0095a;
        }

        @Override // com.salesforce.marketingcloud.media.f
        public void a() {
        }

        @Override // com.salesforce.marketingcloud.media.f
        public void a(@Nullable Exception exc) {
            com.salesforce.marketingcloud.g.a.a(d.this.d, exc, new a(this.b));
        }
    }

    static final class p extends Lambda implements Function0<String> {
        final /* synthetic */ com.salesforce.marketingcloud.push.carousel.a.C0095a b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        p(com.salesforce.marketingcloud.push.carousel.a.C0095a c0095a) {
            super(0);
            this.b = c0095a;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return "Failed to load image from URL: " + this.b.p().o();
        }
    }

    static final class q extends Lambda implements Function0<String> {
        public static final q b = new q();

        q() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return "Not applying alignment on subTitle due to Android Version <= 11";
        }
    }

    static final class r extends Lambda implements Function0<String> {
        public static final r b = new r();

        r() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return "Not applying alignment on title due to Android Version <= 11";
        }
    }

    public d(@NotNull com.salesforce.marketingcloud.push.carousel.b intentProvider, @NotNull Context context, @Nullable com.salesforce.marketingcloud.media.o oVar) {
        Intrinsics.checkNotNullParameter(intentProvider, "intentProvider");
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = intentProvider;
        this.b = context;
        this.c = oVar;
        this.d = com.salesforce.marketingcloud.g.a("CarouselRenderer");
        this.e = new com.salesforce.marketingcloud.push.style.a.b(context);
    }

    @Override // com.salesforce.marketingcloud.push.k
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public RemoteViews a(@NotNull RemoteViews remoteViews, @NotNull com.salesforce.marketingcloud.push.carousel.a template) {
        Intrinsics.checkNotNullParameter(remoteViews, "remoteViews");
        Intrinsics.checkNotNullParameter(template, "template");
        if (template.l().isEmpty() || template.m() < 0 || template.m() >= template.l().size()) {
            throw new IllegalArgumentException("Carousel template must have at least one item");
        }
        com.salesforce.marketingcloud.push.carousel.a.C0095a c0095a = template.l().get(template.m());
        remoteViews.setViewVisibility(R.id.mcsdk_push_carousel, 0);
        c(remoteViews, c0095a);
        b(remoteViews, c0095a);
        b(remoteViews, c0095a, template);
        d(remoteViews, template);
        c(remoteViews, template);
        a(remoteViews, c0095a);
        return remoteViews;
    }

    public final void c(@NotNull RemoteViews remoteViews, @NotNull com.salesforce.marketingcloud.push.carousel.a.C0095a item) {
        CharSequence charSequenceN;
        Style.Alignment alignmentE;
        Intrinsics.checkNotNullParameter(remoteViews, "remoteViews");
        Intrinsics.checkNotNullParameter(item, "item");
        if (item.r() == null) {
            remoteViews.setViewVisibility(R.id.mcsdk_carousel_title, 4);
            return;
        }
        remoteViews.setViewVisibility(R.id.mcsdk_carousel_title, 0);
        int i2 = R.id.mcsdk_carousel_title;
        Style.b bVarA = this.e.a(item.r(), Style.FontStyle.B).a();
        if (bVarA == null || (charSequenceN = bVarA.o()) == null) {
            charSequenceN = item.r().n();
        }
        remoteViews.setTextViewText(i2, charSequenceN);
        if (Build.VERSION.SDK_INT < 31) {
            Style.b bVarA2 = item.r().a();
            if ((bVarA2 != null ? bVarA2.e() : null) != null) {
                com.salesforce.marketingcloud.g.a.e(this.d, (Throwable) null, r.b);
                return;
            }
            return;
        }
        Style.b bVarA3 = item.r().a();
        if (bVarA3 == null || (alignmentE = bVarA3.e()) == null) {
            return;
        }
        remoteViews.setInt(R.id.mcsdk_carousel_title, "setGravity", alignmentE.toGravity());
    }

    public final void d(@NotNull RemoteViews remoteViews, @NotNull com.salesforce.marketingcloud.push.carousel.a template) {
        Intrinsics.checkNotNullParameter(remoteViews, "remoteViews");
        Intrinsics.checkNotNullParameter(template, "template");
        remoteViews.removeAllViews(R.id.mcsdk_dot_container);
        if (template.l().size() <= 1) {
            remoteViews.setViewVisibility(R.id.mcsdk_dot_container, 4);
            return;
        }
        int i2 = 0;
        remoteViews.setViewVisibility(R.id.mcsdk_dot_container, 0);
        int size = template.l().size();
        while (i2 < size) {
            RemoteViews remoteViews2 = new RemoteViews(this.b.getPackageName(), R.layout.mcsdk_dot_view);
            remoteViews2.setImageViewResource(R.id.mcsdk_dot_image, i2 == template.m() ? R.drawable.mcsdk_dot_selected : R.drawable.mcsdk_dot_unselected);
            remoteViews.addView(R.id.mcsdk_dot_container, remoteViews2);
            i2++;
        }
    }

    private final void a(com.salesforce.marketingcloud.push.carousel.a.C0095a c0095a, RemoteViews remoteViews) {
        Unit unit;
        remoteViews.setViewVisibility(R.id.mcsdk_carousel_image, 8);
        com.salesforce.marketingcloud.push.data.c cVarN = c0095a.p().n();
        if (cVarN != null) {
            remoteViews.setViewVisibility(R.id.mcsdk_carousel_alt_text, 0);
            remoteViews.setTextViewText(R.id.mcsdk_carousel_alt_text, cVarN.n());
            remoteViews.setViewVisibility(R.id.mcsdk_carousel_placeholder, 8);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            remoteViews.setViewVisibility(R.id.mcsdk_carousel_placeholder, 0);
            remoteViews.setViewVisibility(R.id.mcsdk_carousel_alt_text, 8);
        }
    }

    public final void b(@NotNull RemoteViews remoteViews, @NotNull com.salesforce.marketingcloud.push.carousel.a.C0095a item) {
        CharSequence charSequenceN;
        Style.Alignment alignmentE;
        Intrinsics.checkNotNullParameter(remoteViews, "remoteViews");
        Intrinsics.checkNotNullParameter(item, "item");
        if (item.q() != null) {
            remoteViews.setViewVisibility(R.id.mcsdk_carousel_subtitle, 0);
            int i2 = R.id.mcsdk_carousel_subtitle;
            Style.b bVarA = ((com.salesforce.marketingcloud.push.data.c) com.salesforce.marketingcloud.push.style.a.a(this.e, item.q(), null, 2, null)).a();
            if (bVarA == null || (charSequenceN = bVarA.o()) == null) {
                charSequenceN = item.q().n();
            }
            remoteViews.setTextViewText(i2, charSequenceN);
            if (Build.VERSION.SDK_INT >= 31) {
                Style.b bVarA2 = item.q().a();
                if (bVarA2 == null || (alignmentE = bVarA2.e()) == null) {
                    return;
                }
                remoteViews.setInt(R.id.mcsdk_carousel_subtitle, "setGravity", alignmentE.toGravity());
                return;
            }
            Style.b bVarA3 = item.q().a();
            if ((bVarA3 != null ? bVarA3.e() : null) != null) {
                com.salesforce.marketingcloud.g.a.e(this.d, (Throwable) null, q.b);
                return;
            }
            return;
        }
        remoteViews.setViewVisibility(R.id.mcsdk_carousel_subtitle, 4);
    }

    public final void c(@NotNull RemoteViews remoteViews, @NotNull com.salesforce.marketingcloud.push.carousel.a template) {
        Intrinsics.checkNotNullParameter(remoteViews, "remoteViews");
        Intrinsics.checkNotNullParameter(template, "template");
        if (template.l().size() == 1) {
            remoteViews.setViewVisibility(R.id.mcsdk_carousel_previous, 4);
            remoteViews.setViewVisibility(R.id.mcsdk_carousel_previous_unselected, 4);
            remoteViews.setViewVisibility(R.id.mcsdk_carousel_next, 4);
            remoteViews.setViewVisibility(R.id.mcsdk_carousel_next_unselected, 4);
            return;
        }
        remoteViews.setOnClickPendingIntent(R.id.mcsdk_carousel_previous, this.a.a(com.salesforce.marketingcloud.push.carousel.b.m, template));
        remoteViews.setOnClickPendingIntent(R.id.mcsdk_carousel_next, this.a.a(com.salesforce.marketingcloud.push.carousel.b.l, template));
        remoteViews.setOnClickPendingIntent(R.id.mcsdk_carousel_next_unselected, null);
        remoteViews.setOnClickPendingIntent(R.id.mcsdk_carousel_previous_unselected, null);
        int iM = template.m();
        if (iM == 0) {
            remoteViews.setViewVisibility(R.id.mcsdk_carousel_previous, 4);
            remoteViews.setViewVisibility(R.id.mcsdk_carousel_previous_unselected, 0);
            remoteViews.setViewVisibility(R.id.mcsdk_carousel_next, 0);
            remoteViews.setViewVisibility(R.id.mcsdk_carousel_next_unselected, 8);
            return;
        }
        if (iM == template.l().size() - 1) {
            remoteViews.setViewVisibility(R.id.mcsdk_carousel_previous, 0);
            remoteViews.setViewVisibility(R.id.mcsdk_carousel_previous_unselected, 8);
            remoteViews.setViewVisibility(R.id.mcsdk_carousel_next, 4);
            remoteViews.setViewVisibility(R.id.mcsdk_carousel_next_unselected, 0);
            return;
        }
        remoteViews.setViewVisibility(R.id.mcsdk_carousel_previous, 0);
        remoteViews.setViewVisibility(R.id.mcsdk_carousel_previous_unselected, 8);
        remoteViews.setViewVisibility(R.id.mcsdk_carousel_next, 0);
        remoteViews.setViewVisibility(R.id.mcsdk_carousel_next_unselected, 8);
    }

    public final Bitmap a(@NotNull Drawable background, int i2, int i3) {
        Intrinsics.checkNotNullParameter(background, "background");
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        background.setBounds(0, 0, i2, i3);
        background.draw(canvas);
        com.salesforce.marketingcloud.g gVar = com.salesforce.marketingcloud.g.a;
        com.salesforce.marketingcloud.g.a(gVar, this.d, null, new m(bitmapCreateBitmap), 2, null);
        Bitmap bitmapA = com.salesforce.marketingcloud.media.q.a.a(bitmapCreateBitmap, i3, i2);
        com.salesforce.marketingcloud.g.a(gVar, this.d, null, new n(bitmapA), 2, null);
        return bitmapA;
    }

    public final void a(@NotNull RemoteViews remoteViews, @NotNull com.salesforce.marketingcloud.push.carousel.a.C0095a item) {
        Intrinsics.checkNotNullParameter(remoteViews, "remoteViews");
        Intrinsics.checkNotNullParameter(item, "item");
        List<com.salesforce.marketingcloud.push.data.a> listH = item.h();
        if (listH != null) {
            remoteViews.setOnClickPendingIntent(R.id.mcsdk_push_carousel, this.a.a((com.salesforce.marketingcloud.push.data.a[]) listH.toArray(new com.salesforce.marketingcloud.push.data.a[0]), com.salesforce.marketingcloud.analytics.stats.b.f39n, item.d(), null));
        }
    }

    public final void b(@NotNull RemoteViews remoteViews, @NotNull com.salesforce.marketingcloud.push.carousel.a.C0095a item, @NotNull com.salesforce.marketingcloud.push.carousel.a template) {
        Bitmap bitmapA;
        u uVarB;
        u uVarA;
        Intrinsics.checkNotNullParameter(remoteViews, "remoteViews");
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(template, "template");
        Pair<Integer, Integer> pairA = a(remoteViews, item, template);
        int iIntValue = pairA.component1().intValue();
        int iIntValue2 = pairA.component2().intValue();
        Drawable drawable = this.b.getResources().getDrawable(R.drawable.mcsdk_carousel_bg, this.b.getTheme());
        Style styleA = item.p().a();
        Bitmap bitmapA2 = null;
        if ((styleA != null ? styleA.i() : null) != null) {
            if (Build.VERSION.SDK_INT >= 29) {
                BlendModeColorFilterHelper$$ExternalSyntheticApiModelOutline3.m();
                drawable.setColorFilter(BlendModeColorFilterHelper$$ExternalSyntheticApiModelOutline2.m(Color.parseColor(item.p().a().i()), BlendMode.SRC_ATOP));
            } else {
                drawable.setColorFilter(new PorterDuffColorFilter(Color.parseColor(item.p().a().i()), PorterDuff.Mode.SRC_ATOP));
            }
            Intrinsics.checkNotNull(drawable);
            bitmapA = a(drawable, iIntValue2, iIntValue);
            remoteViews.setImageViewBitmap(R.id.mcsdk_carousel_bg, bitmapA);
        } else {
            Style styleA2 = template.a();
            if ((styleA2 != null ? styleA2.i() : null) != null) {
                if (Build.VERSION.SDK_INT >= 29) {
                    BlendModeColorFilterHelper$$ExternalSyntheticApiModelOutline3.m();
                    drawable.setColorFilter(BlendModeColorFilterHelper$$ExternalSyntheticApiModelOutline2.m(Color.parseColor(template.a().i()), BlendMode.SRC_ATOP));
                } else {
                    drawable.setColorFilter(new PorterDuffColorFilter(Color.parseColor(template.a().i()), PorterDuff.Mode.SRC_ATOP));
                }
                Intrinsics.checkNotNull(drawable);
                bitmapA = a(drawable, iIntValue2, iIntValue);
                remoteViews.setImageViewBitmap(R.id.mcsdk_carousel_bg, bitmapA);
            } else {
                bitmapA = null;
            }
        }
        if (bitmapA == null) {
            Intrinsics.checkNotNull(drawable);
            bitmapA = a(drawable, iIntValue2, iIntValue);
            remoteViews.setImageViewBitmap(R.id.mcsdk_carousel_bg, bitmapA);
        }
        try {
            remoteViews.setViewVisibility(R.id.mcsdk_carousel_image, 0);
            remoteViews.setViewVisibility(R.id.mcsdk_carousel_placeholder, 8);
            remoteViews.setViewVisibility(R.id.mcsdk_carousel_alt_text, 8);
            com.salesforce.marketingcloud.media.o oVar = this.c;
            if (oVar != null) {
                bitmapA2 = oVar.a(item.p().o() + "\n");
            }
            if (bitmapA2 == null) {
                a(item, remoteViews);
                com.salesforce.marketingcloud.media.o oVar2 = this.c;
                if (oVar2 == null || (uVarB = oVar2.b(item.p().o())) == null || (uVarA = uVarB.a(com.salesforce.marketingcloud.media.o.c.HIGH)) == null) {
                    return;
                }
                uVarA.a(new o(item));
                return;
            }
            Bitmap bitmapA3 = com.salesforce.marketingcloud.media.q.a.a(bitmapA2, iIntValue, iIntValue2);
            if (a(bitmapA, bitmapA3)) {
                remoteViews.setImageViewBitmap(R.id.mcsdk_carousel_image, com.salesforce.marketingcloud.push.i.a.a(bitmapA3, this.b.getResources().getDimensionPixelSize(R.dimen.mcsdk_push_carousel_image_radius)));
            } else {
                remoteViews.setImageViewBitmap(R.id.mcsdk_carousel_image, bitmapA3);
            }
        } catch (Exception e2) {
            com.salesforce.marketingcloud.g.a.b(this.d, e2, new p(item));
            a(item, remoteViews);
        }
    }

    public final boolean a(@NotNull Bitmap backgroundImage, @NotNull Bitmap foregroundImage) {
        Intrinsics.checkNotNullParameter(backgroundImage, "backgroundImage");
        Intrinsics.checkNotNullParameter(foregroundImage, "foregroundImage");
        int dimensionPixelSize = this.b.getResources().getDimensionPixelSize(R.dimen.mcsdk_push_carousel_image_radius);
        if (foregroundImage.getWidth() > backgroundImage.getWidth() || foregroundImage.getHeight() > backgroundImage.getHeight()) {
            return true;
        }
        return Math.sqrt((double) ((foregroundImage.getWidth() * foregroundImage.getWidth()) + (foregroundImage.getHeight() * foregroundImage.getHeight()))) > Math.sqrt((double) ((backgroundImage.getWidth() * backgroundImage.getWidth()) + (backgroundImage.getHeight() * backgroundImage.getHeight()))) - (((double) (dimensionPixelSize * 2)) * Math.sqrt(2.0d));
    }

    public final Pair<Integer, Integer> a(@NotNull RemoteViews remoteViews, @NotNull com.salesforce.marketingcloud.push.carousel.a.C0095a item, @NotNull com.salesforce.marketingcloud.push.carousel.a template) {
        Intrinsics.checkNotNullParameter(remoteViews, "remoteViews");
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(template, "template");
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = a();
        Ref.IntRef intRef2 = new Ref.IntRef();
        intRef2.element = a(remoteViews, template);
        com.salesforce.marketingcloud.g gVar = com.salesforce.marketingcloud.g.a;
        com.salesforce.marketingcloud.g.a(gVar, this.d, null, new a(intRef2, intRef), 2, null);
        int i2 = intRef.element / 2;
        int i3 = intRef2.element;
        if (i2 < i3) {
            intRef2.element = i2;
            intRef.element = i2 * 2;
        } else {
            intRef.element = i3 * 2;
        }
        com.salesforce.marketingcloud.g.a(gVar, this.d, null, new b(intRef2, intRef), 2, null);
        return new Pair<>(Integer.valueOf(intRef2.element), Integer.valueOf(intRef.element));
    }

    public final int a(@NotNull RemoteViews remoteViews, @NotNull com.salesforce.marketingcloud.push.carousel.a template) {
        int i2;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(remoteViews, "remoteViews");
        Intrinsics.checkNotNullParameter(template, "template");
        int dimensionPixelSize = this.b.getResources().getDimensionPixelSize(R.dimen.mcsdk_push_carousel_image_height);
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = dimensionPixelSize;
        List<com.salesforce.marketingcloud.push.carousel.a.C0095a> listL = template.l();
        boolean z = listL instanceof Collection;
        int i5 = 0;
        if (z && listL.isEmpty()) {
            i2 = 0;
        } else {
            i2 = 0;
            for (com.salesforce.marketingcloud.push.carousel.a.C0095a c0095a : listL) {
                if (c0095a.r() != null && c0095a.q() == null && (i2 = i2 + 1) < 0) {
                    CollectionsKt__CollectionsKt.throwCountOverflow();
                }
            }
        }
        if (z && listL.isEmpty()) {
            i3 = 0;
        } else {
            i3 = 0;
            for (com.salesforce.marketingcloud.push.carousel.a.C0095a c0095a2 : listL) {
                if (c0095a2.r() == null && c0095a2.q() != null && (i3 = i3 + 1) < 0) {
                    CollectionsKt__CollectionsKt.throwCountOverflow();
                }
            }
        }
        if (z && listL.isEmpty()) {
            i4 = 0;
        } else {
            i4 = 0;
            for (com.salesforce.marketingcloud.push.carousel.a.C0095a c0095a3 : listL) {
                if (c0095a3.r() != null && c0095a3.q() != null && (i4 = i4 + 1) < 0) {
                    CollectionsKt__CollectionsKt.throwCountOverflow();
                }
            }
        }
        if (!z || !listL.isEmpty()) {
            for (com.salesforce.marketingcloud.push.carousel.a.C0095a c0095a4 : listL) {
                if (c0095a4.r() == null && c0095a4.q() == null && (i5 = i5 + 1) < 0) {
                    CollectionsKt__CollectionsKt.throwCountOverflow();
                }
            }
        }
        com.salesforce.marketingcloud.g gVar = com.salesforce.marketingcloud.g.a;
        com.salesforce.marketingcloud.g.a(gVar, this.d, null, new c(i2, i3, i4, i5), 2, null);
        if (i4 > 0) {
            com.salesforce.marketingcloud.g.a(gVar, this.d, null, new C0097d(intRef), 2, null);
        } else if (i5 == listL.size()) {
            intRef.element += this.b.getResources().getDimensionPixelSize(R.dimen.mcsdk_push_carousel_image_height_addendum) * 2;
            remoteViews.setViewVisibility(R.id.mcsdk_carousel_title, 8);
            remoteViews.setViewVisibility(R.id.mcsdk_carousel_subtitle, 8);
            com.salesforce.marketingcloud.g.a(gVar, this.d, null, new e(intRef), 2, null);
        } else {
            int i6 = i2 + i5;
            if (i6 == listL.size()) {
                intRef.element += this.b.getResources().getDimensionPixelSize(R.dimen.mcsdk_push_carousel_image_height_addendum);
                remoteViews.setViewVisibility(R.id.mcsdk_carousel_subtitle, 8);
                com.salesforce.marketingcloud.g.a(gVar, this.d, null, new f(intRef), 2, null);
            } else if (i5 + i3 == listL.size()) {
                intRef.element += this.b.getResources().getDimensionPixelSize(R.dimen.mcsdk_push_carousel_image_height_addendum);
                remoteViews.setViewVisibility(R.id.mcsdk_carousel_title, 8);
                com.salesforce.marketingcloud.g.a(gVar, this.d, null, new g(intRef), 2, null);
            } else if (i6 + i3 == listL.size()) {
                com.salesforce.marketingcloud.g.a(gVar, this.d, null, new h(i2, i3), 2, null);
            }
        }
        return intRef.element;
    }

    private final int a() {
        Ref.IntRef intRef = new Ref.IntRef();
        DisplayMetrics displayMetrics = this.b.getResources().getDisplayMetrics();
        com.salesforce.marketingcloud.g gVar = com.salesforce.marketingcloud.g.a;
        com.salesforce.marketingcloud.g.a(gVar, this.d, null, new i(displayMetrics), 2, null);
        com.salesforce.marketingcloud.g.a(gVar, this.d, null, new j(displayMetrics), 2, null);
        if (Build.VERSION.SDK_INT >= 31) {
            int dimensionPixelSize = this.b.getResources().getDimensionPixelSize(R.dimen.mcsdk_push_android_notification_padding);
            intRef.element = (dimensionPixelSize * 2) + this.b.getResources().getDimensionPixelSize(R.dimen.mcsdk_push_android_notification_margin) + this.b.getResources().getDimensionPixelSize(R.dimen.mcsdk_push_android_notification_pillar_margin);
            com.salesforce.marketingcloud.g.a(gVar, this.d, null, new k(intRef), 2, null);
        } else {
            intRef.element = this.b.getResources().getDimensionPixelSize(R.dimen.mcsdk_push_android_notification_padding) * 2;
            com.salesforce.marketingcloud.g.a(gVar, this.d, null, new l(intRef), 2, null);
        }
        int i2 = displayMetrics.widthPixels - intRef.element;
        return i2 - (i2 % 2);
    }
}
