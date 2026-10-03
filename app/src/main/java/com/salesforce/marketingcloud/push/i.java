package com.salesforce.marketingcloud.push;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.webkit.URLUtil;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import com.salesforce.marketingcloud.R;
import com.salesforce.marketingcloud.media.o;
import com.salesforce.marketingcloud.media.q;
import com.salesforce.marketingcloud.notifications.NotificationMessage;
import com.salesforce.marketingcloud.push.data.RichFeatures;
import com.salesforce.marketingcloud.push.data.Template;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class i {
    private static o b;
    public static final i a = new i();
    private static final String c = com.salesforce.marketingcloud.g.a("RichFeatureRenderer");

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
            return "Unable to load notification large icon " + this.b;
        }
    }

    static final class b extends Lambda implements Function0<String> {
        final /* synthetic */ NotificationMessage b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(NotificationMessage notificationMessage) {
            super(0);
            this.b = notificationMessage;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return "Unable to load notification image " + this.b.mediaUrl;
        }
    }

    private i() {
    }

    public final o a() {
        return b;
    }

    public final String b() {
        return c;
    }

    public final void a(@Nullable o oVar) {
        b = oVar;
    }

    public final void a(@NotNull Context context, @NotNull NotificationMessage message, @NotNull NotificationCompat.Builder builder) {
        Template viewTemplate;
        com.salesforce.marketingcloud.push.buttons.a buttons;
        RemoteViews remoteViewsA;
        String largeIcon;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(builder, "builder");
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), a(message));
        remoteViews.setViewVisibility(R.id.mcsdk_push_alert, 0);
        remoteViews.setTextViewText(R.id.mcsdk_push_alert, message.alert);
        remoteViews.setViewVisibility(R.id.mcsdk_push_title, 0);
        remoteViews.setTextViewText(R.id.mcsdk_push_title, message.title);
        RichFeatures richFeatures = message.richFeatures;
        if (richFeatures != null && (largeIcon = richFeatures.getLargeIcon()) != null) {
            i iVar = a;
            if (iVar.a(message.richFeatures)) {
                remoteViews.setViewVisibility(R.id.mcsdk_push_large_icon, 0);
                if (URLUtil.isValidUrl(largeIcon)) {
                    try {
                        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.notification_large_icon_width);
                        int i = R.id.mcsdk_push_large_icon;
                        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(q.a.a(largeIcon), dimensionPixelSize, dimensionPixelSize, false);
                        Intrinsics.checkNotNullExpressionValue(bitmapCreateScaledBitmap, "createScaledBitmap(...)");
                        remoteViews.setImageViewBitmap(i, iVar.a(bitmapCreateScaledBitmap, context.getResources().getDimensionPixelSize(R.dimen.mcsdk_push_carousel_image_radius)));
                    } catch (com.salesforce.marketingcloud.push.a e) {
                        com.salesforce.marketingcloud.g.a.b(c, e, new a(largeIcon));
                    }
                } else {
                    int i2 = R.id.mcsdk_push_large_icon;
                    Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(context.getResources(), q.a.a(context, largeIcon));
                    Intrinsics.checkNotNullExpressionValue(bitmapDecodeResource, "decodeResource(...)");
                    remoteViews.setImageViewBitmap(i2, iVar.a(bitmapDecodeResource, context.getResources().getDimensionPixelSize(R.dimen.mcsdk_push_carousel_image_radius)));
                }
            }
        }
        String str = message.mediaUrl;
        if (str != null && str.length() != 0) {
            remoteViews.setViewVisibility(R.id.mcsdk_big_image, 0);
            String str2 = message.alert;
            try {
                Bitmap bitmapA = a(q.a.a(message.mediaUrl), context.getResources().getDimensionPixelSize(R.dimen.mcsdk_push_carousel_image_radius));
                remoteViews.setImageViewBitmap(R.id.mcsdk_big_image, bitmapA);
                builder.setStyle(new NotificationCompat.BigPictureStyle().bigPicture(bitmapA).setSummaryText(str2));
            } catch (com.salesforce.marketingcloud.push.a e2) {
                com.salesforce.marketingcloud.g.a.b(c, e2, new b(message));
                str2 = message.mediaAltText;
                remoteViews.setViewVisibility(R.id.mcsdk_big_image, 8);
            } finally {
                builder.setContentText(str2);
                builder.setTicker(str2);
            }
        }
        RichFeatures richFeatures2 = message.richFeatures;
        if (richFeatures2 != null && (buttons = richFeatures2.getButtons()) != null) {
            if (com.salesforce.marketingcloud.push.buttons.a.f.a(buttons)) {
                remoteViewsA = remoteViews;
            } else {
                remoteViewsA = k.a.C0107a.a(k.a.a, Template.Type.RichButtons, context, message, null, 8, null).a(remoteViews, buttons);
                builder.setCustomBigContentView(remoteViewsA);
            }
            if (remoteViewsA != null) {
                remoteViews = remoteViewsA;
            }
        }
        RichFeatures richFeatures3 = message.richFeatures;
        if (richFeatures3 == null || (viewTemplate = richFeatures3.getViewTemplate()) == null) {
            return;
        }
        builder.setStyle(new NotificationCompat.BigPictureStyle());
        builder.setCustomBigContentView(k.a.a.a(viewTemplate.f(), context, message, b).a(remoteViews, viewTemplate));
    }

    private final int a(NotificationMessage notificationMessage) {
        if (notificationMessage.mediaUrl == null) {
            RichFeatures richFeatures = notificationMessage.richFeatures;
            if ((richFeatures != null ? richFeatures.getViewTemplate() : null) == null) {
                return R.layout.mcsdk_push_custom_button_layout;
            }
        }
        return R.layout.mcsdk_push_layout;
    }

    private final boolean a(RichFeatures richFeatures) {
        return richFeatures.getViewTemplate() == null;
    }

    public final Bitmap a(@NotNull Bitmap bitmap, int i) {
        Intrinsics.checkNotNullParameter(bitmap, "<this>");
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-1);
        float f = i;
        canvas.drawRoundRect(rectF, f, f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return bitmapCreateBitmap;
    }
}
