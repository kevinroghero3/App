package com.salesforce.marketingcloud.push;

import android.os.Handler;
import android.os.Looper;
import com.salesforce.marketingcloud.media.o;
import com.salesforce.marketingcloud.notifications.NotificationMessage;
import com.salesforce.marketingcloud.push.data.RichFeatures;
import com.salesforce.marketingcloud.push.data.Template;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class h {
    public static final a c = new a(null);
    private static final String d = com.salesforce.marketingcloud.g.a("RichFeaturePreloader");
    private static final long e = 2000;
    private static final long f = 15;
    private final o a;
    private final Handler b;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a() {
            return h.d;
        }

        private a() {
        }
    }

    static final class b extends Lambda implements Function0<String> {
        public static final b b = new b();

        b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return "Pre loading first image with high priority";
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    public static final class c implements com.salesforce.marketingcloud.media.f {
        final /* synthetic */ CountDownLatch a;
        final /* synthetic */ String b;

        static final class a extends Lambda implements Function0<String> {
            final /* synthetic */ String b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(String str) {
                super(0);
                this.b = str;
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final String invoke() {
                return "Pre loading first image failed " + this.b;
            }
        }

        c(CountDownLatch countDownLatch, String str) {
            this.a = countDownLatch;
            this.b = str;
        }

        @Override // com.salesforce.marketingcloud.media.f
        public void a() {
            this.a.countDown();
        }

        @Override // com.salesforce.marketingcloud.media.f
        public void a(@NotNull Exception e) {
            Intrinsics.checkNotNullParameter(e, "e");
            com.salesforce.marketingcloud.g.a.a(h.c.a(), e, new a(this.b));
            this.a.countDown();
        }
    }

    static final class d extends Lambda implements Function0<String> {
        public static final d b = new d();

        d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return "Starting BatchLoad for remaining images with delay 2000";
        }
    }

    public h(@NotNull o imageHandler) {
        Intrinsics.checkNotNullParameter(imageHandler, "imageHandler");
        this.a = imageHandler;
        this.b = new Handler(Looper.getMainLooper());
    }

    public final void b(@Nullable NotificationMessage notificationMessage) {
        com.salesforce.marketingcloud.push.carousel.a aVarA = a(notificationMessage);
        if (aVarA == null) {
            return;
        }
        List<String> listA = a(aVarA);
        if (listA.isEmpty()) {
            return;
        }
        a((String) CollectionsKt___CollectionsKt.first((List) listA), CollectionsKt___CollectionsKt.drop(listA, 1));
    }

    private final com.salesforce.marketingcloud.push.carousel.a a(NotificationMessage notificationMessage) {
        Template viewTemplate;
        RichFeatures richFeatures;
        if (notificationMessage == null || (richFeatures = notificationMessage.richFeatures) == null || (viewTemplate = richFeatures.getViewTemplate()) == null || viewTemplate.f() != Template.Type.CarouselFull) {
            viewTemplate = null;
        }
        if (viewTemplate instanceof com.salesforce.marketingcloud.push.carousel.a) {
            return (com.salesforce.marketingcloud.push.carousel.a) viewTemplate;
        }
        return null;
    }

    private final List<String> a(com.salesforce.marketingcloud.push.carousel.a aVar) {
        List<com.salesforce.marketingcloud.push.carousel.a.C0095a> listL = aVar.l();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it2 = listL.iterator();
        while (it2.hasNext()) {
            com.salesforce.marketingcloud.push.data.b bVarP = ((com.salesforce.marketingcloud.push.carousel.a.C0095a) it2.next()).p();
            String strO = bVarP != null ? bVarP.o() : null;
            if (strO != null) {
                arrayList.add(strO);
            }
        }
        return arrayList;
    }

    private final void a(String str, List<String> list) {
        com.salesforce.marketingcloud.g.d(com.salesforce.marketingcloud.g.a, d, null, b.b, 2, null);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        this.a.b(str).a(o.c.HIGH).a(new c(countDownLatch, str));
        a(list, countDownLatch);
    }

    private final void a(final List<String> list, CountDownLatch countDownLatch) {
        if (!list.isEmpty()) {
            this.b.postDelayed(new Runnable() { // from class: com.salesforce.marketingcloud.push.h$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    h.a(this.f$0, list);
                }
            }, e);
        }
        try {
            countDownLatch.await(f, TimeUnit.SECONDS);
        } catch (InterruptedException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(h this$0, List remainingUrls) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(remainingUrls, "$remainingUrls");
        com.salesforce.marketingcloud.g.d(com.salesforce.marketingcloud.g.a, d, null, d.b, 2, null);
        this$0.a.a((List<String>) remainingUrls).a(null, false);
    }
}
