package com.salesforce.marketingcloud.push;

import android.content.Context;
import android.widget.RemoteViews;
import com.salesforce.marketingcloud.media.o;
import com.salesforce.marketingcloud.notifications.NotificationMessage;
import com.salesforce.marketingcloud.push.data.Template;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public interface k<T extends Template> {

    public static final class a {
        public static final C0107a a = new C0107a(null);

        /* JADX INFO: renamed from: com.salesforce.marketingcloud.push.k$a$a, reason: collision with other inner class name */
        public static final class C0107a {

            /* JADX INFO: renamed from: com.salesforce.marketingcloud.push.k$a$a$a, reason: collision with other inner class name */
            public final /* synthetic */ class C0108a {
                public static final /* synthetic */ int[] a;

                static {
                    int[] iArr = new int[Template.Type.values().length];
                    try {
                        iArr[Template.Type.CarouselFull.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[Template.Type.RichButtons.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    a = iArr;
                }
            }

            public /* synthetic */ C0107a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public static /* synthetic */ k a(C0107a c0107a, Template.Type type, Context context, NotificationMessage notificationMessage, o oVar, int i, Object obj) {
                if ((i & 8) != 0) {
                    oVar = null;
                }
                return c0107a.a(type, context, notificationMessage, oVar);
            }

            private C0107a() {
            }

            public final k<Template> a(@NotNull Template.Type type, @NotNull Context context, @NotNull NotificationMessage message, @Nullable o oVar) {
                Intrinsics.checkNotNullParameter(type, "type");
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(message, "message");
                int i = C0108a.a[type.ordinal()];
                if (i == 1) {
                    return new com.salesforce.marketingcloud.push.carousel.d(new com.salesforce.marketingcloud.push.carousel.b(context, message), context, oVar);
                }
                if (i == 2) {
                    return new com.salesforce.marketingcloud.push.buttons.c(context, new b(context, message));
                }
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    RemoteViews a(@NotNull RemoteViews remoteViews, @NotNull T t);
}
