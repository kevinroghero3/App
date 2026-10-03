package com.salesforce.marketingcloud.push;

import com.salesforce.marketingcloud.push.buttons.RichButtonsParser;
import com.salesforce.marketingcloud.push.carousel.CarouselParser;
import com.salesforce.marketingcloud.push.data.Template;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public interface j<T extends Template> {

    public static final class a {
        public static final C0105a a = new C0105a(null);

        /* JADX INFO: renamed from: com.salesforce.marketingcloud.push.j$a$a, reason: collision with other inner class name */
        public static final class C0105a {

            /* JADX INFO: renamed from: com.salesforce.marketingcloud.push.j$a$a$a, reason: collision with other inner class name */
            public final /* synthetic */ class C0106a {
                public static final /* synthetic */ int[] a;

                static {
                    int[] iArr = new int[Template.Type.values().length];
                    try {
                        iArr[Template.Type.RichButtons.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[Template.Type.CarouselFull.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    a = iArr;
                }
            }

            public /* synthetic */ C0105a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final j<?> a(@NotNull Template.Type type) {
                Intrinsics.checkNotNullParameter(type, "type");
                int i = C0106a.a[type.ordinal()];
                if (i == 1) {
                    return new RichButtonsParser();
                }
                if (i != 2) {
                    return null;
                }
                return new CarouselParser();
            }

            private C0105a() {
            }
        }
    }

    String hydrate(@NotNull Template template);

    T parse(@NotNull String str);
}
