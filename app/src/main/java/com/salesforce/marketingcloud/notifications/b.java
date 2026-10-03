package com.salesforce.marketingcloud.notifications;

import android.app.NotificationChannel;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Base64;
import android.webkit.URLUtil;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.browser.trusted.NotificationApiHelperForO$$ExternalSyntheticApiModelOutline4;
import androidx.core.app.NotificationCompat;
import app.notifee.core.a$$ExternalSyntheticApiModelOutline30;
import com.salesforce.marketingcloud.R;
import com.salesforce.marketingcloud.g;
import com.salesforce.marketingcloud.media.o;
import com.salesforce.marketingcloud.media.q;
import com.salesforce.marketingcloud.push.data.RichFeatures;
import com.salesforce.marketingcloud.push.f;
import com.salesforce.marketingcloud.push.i;
import com.salesforce.marketingcloud.util.j;
import com.transistorsoft.locationmanager.config.TSNotification;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes3.dex */
class b implements NotificationManager.NotificationBuilder {
    private static int artificialFrame = 1;
    private static byte extraCallback = -124;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME;
    final int a;
    private final NotificationManager.NotificationLaunchIntentProvider b;
    private final NotificationManager.NotificationBuilder c;
    private final NotificationManager.NotificationChannelIdProvider d;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[NotificationMessage.Sound.values().length];
            a = iArr;
            try {
                iArr[NotificationMessage.Sound.CUSTOM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[NotificationMessage.Sound.DEFAULT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[NotificationMessage.Sound.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public b(@DrawableRes int i, @Nullable NotificationManager.NotificationLaunchIntentProvider notificationLaunchIntentProvider, @Nullable NotificationManager.NotificationBuilder notificationBuilder, @Nullable NotificationManager.NotificationChannelIdProvider notificationChannelIdProvider) {
        this.b = notificationLaunchIntentProvider;
        this.c = notificationBuilder;
        this.d = notificationChannelIdProvider;
        this.a = i;
    }

    static NotificationCompat.Builder a(Context context, NotificationMessage notificationMessage, String str, int i) {
        boolean z;
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, str);
        if (context.getApplicationInfo().icon > 0) {
            builder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), context.getApplicationInfo().icon));
        }
        if (i > 0) {
            builder.setSmallIcon(i);
        }
        String str2 = notificationMessage.title;
        if (str2 != null) {
            builder.setContentTitle(str2);
        }
        String str3 = notificationMessage.alert;
        try {
            try {
                if (TextUtils.isEmpty(notificationMessage.mediaUrl)) {
                    z = false;
                } else {
                    builder.setStyle(new NotificationCompat.BigPictureStyle().bigPicture(q.a.a(notificationMessage.mediaUrl)).setSummaryText(str3));
                    z = true;
                }
            } catch (com.salesforce.marketingcloud.push.a e) {
                String str4 = NotificationManager.d;
                g.b(str4, e, "Unable to load notification image %s", notificationMessage.mediaUrl);
                String str5 = notificationMessage.mediaAltText;
                if (str5 == null || TextUtils.getTrimmedLength(str5) <= 0) {
                    g.a(str4, "mediaAltText is null or blank, keep original alert text", new Object[0]);
                } else {
                    str3 = notificationMessage.mediaAltText;
                    g.a(str4, "Using mediaAltText as alert text", new Object[0]);
                }
                builder.setStyle(new NotificationCompat.BigTextStyle().bigText(str3).setBigContentTitle(notificationMessage.title));
            }
            builder.setContentText(str3);
            builder.setTicker(str3);
            builder.setOnlyAlertOnce(true);
            builder.setAutoCancel(true);
            RichFeatures richFeatures = notificationMessage.richFeatures;
            if (richFeatures != null) {
                String largeIcon = richFeatures.getLargeIcon();
                if (largeIcon != null) {
                    if (URLUtil.isValidUrl(largeIcon)) {
                        try {
                            int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.mcsdk_push_large_icon_size);
                            builder.setLargeIcon(Bitmap.createScaledBitmap(a(largeIcon), dimensionPixelSize, dimensionPixelSize, false));
                        } catch (com.salesforce.marketingcloud.push.a e2) {
                            g.b(NotificationManager.d, e2, "Unable to load notification large icon: %s", largeIcon);
                        }
                    } else {
                        builder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), q.a.a(context, largeIcon)));
                    }
                }
                String smallIcon = richFeatures.getSmallIcon();
                if (smallIcon != null) {
                    builder.setSmallIcon(q.a.a(context, smallIcon));
                }
                com.salesforce.marketingcloud.push.buttons.a buttons = richFeatures.getButtons();
                if (buttons != null && com.salesforce.marketingcloud.push.buttons.a.a(buttons)) {
                    com.salesforce.marketingcloud.push.b bVar = new com.salesforce.marketingcloud.push.b(context, notificationMessage);
                    for (com.salesforce.marketingcloud.push.buttons.a.c cVar : buttons.k()) {
                        builder.addAction(new NotificationCompat.Action(0, cVar.p().n(), bVar.a((com.salesforce.marketingcloud.push.data.a[]) cVar.h().toArray(new com.salesforce.marketingcloud.push.data.a[0]), com.salesforce.marketingcloud.analytics.stats.b.f40o, cVar.d(), cVar.p().n())));
                    }
                }
                i.a.a(context, notificationMessage, builder);
            } else if (!z) {
                builder.setStyle(new NotificationCompat.BigTextStyle().bigText(str3).setBigContentTitle(notificationMessage.title));
            }
            int i2 = a.a[notificationMessage.sound.ordinal()];
            if (i2 == 1) {
                String str6 = notificationMessage.soundName;
                if (str6 != null) {
                    builder.setSound(q.a.a(context, str6, Settings.System.DEFAULT_NOTIFICATION_URI));
                } else {
                    builder.setSound(null);
                }
            } else if (i2 == 2) {
                builder.setSound(Settings.System.DEFAULT_NOTIFICATION_URI);
            } else if (i2 == 3) {
                builder.setSound(null);
                g.a(NotificationManager.d, "No sound was set for notification.", new Object[0]);
            }
            return builder;
        } catch (Throwable th) {
            builder.setContentText(str3);
            builder.setTicker(str3);
            throw th;
        }
    }

    PendingIntent c(Context context, @NonNull NotificationMessage notificationMessage) {
        try {
            NotificationManager.NotificationLaunchIntentProvider notificationLaunchIntentProvider = this.b;
            if (notificationLaunchIntentProvider != null) {
                return notificationLaunchIntentProvider.getNotificationPendingIntent(context, notificationMessage);
            }
        } catch (IllegalArgumentException e) {
            g.b(NotificationManager.d, e, "Missing FLAG_IMMUTABLE or FLAG_MUTABLE flag in PendingIntent", new Object[0]);
        }
        int iA = j.a(134217728);
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
        if (launchIntentForPackage == null) {
            return null;
        }
        Intent intentA = NotificationManager.a(launchIntentForPackage, notificationMessage);
        intentA.addFlags(134217728);
        return PendingIntent.getActivity(context, notificationMessage.notificationId(), intentA, iA);
    }

    @Override // com.salesforce.marketingcloud.notifications.NotificationManager.NotificationBuilder
    public NotificationCompat.Builder setupNotificationBuilder(@NonNull Context context, @NonNull NotificationMessage notificationMessage) throws f {
        NotificationCompat.Builder builderA;
        NotificationManager.NotificationBuilder notificationBuilder = this.c;
        if (notificationBuilder != null) {
            try {
                builderA = notificationBuilder.setupNotificationBuilder(context, notificationMessage);
            } catch (Exception e) {
                g.b(NotificationManager.d, e, "Custom notification builder threw an exception.  Using default notification builder.", new Object[0]);
                builderA = null;
            }
        } else {
            builderA = null;
        }
        if (builderA == null) {
            builderA = a(context, notificationMessage, b(context, notificationMessage), this.a);
            PendingIntent pendingIntentC = c(context, notificationMessage);
            if (pendingIntentC != null) {
                builderA.setContentIntent(NotificationManager.redirectIntentForAnalytics(context, pendingIntentC, notificationMessage, true));
            }
        }
        return builderA;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0029  */
    /* JADX WARN: Code duplicated, block: B:13:0x003b  */
    /* JADX WARN: Code duplicated, block: B:15:0x0047  */
    /* JADX WARN: Code duplicated, block: B:16:0x005c  */
    static String b(Context context, boolean z) {
        android.app.NotificationManager notificationManager;
        String string;
        int i;
        int i2 = 2 % 2;
        if (j.c() && (notificationManager = (android.app.NotificationManager) context.getSystemService(TSNotification.NAME)) != null) {
            if (notificationManager.getNotificationChannel(NotificationManager.DEFAULT_CHANNEL_ID) != null) {
                int i3 = getARTIFICIAL_FRAME_PACKAGE_NAME + 119;
                artificialFrame = i3 % 128;
                int i4 = i3 % 2;
                if (!(!z)) {
                    a$$ExternalSyntheticApiModelOutline30.m();
                    string = context.getString(R.string.mcsdk_default_notification_channel_name);
                    if (string.startsWith(".,.%")) {
                        i = getARTIFICIAL_FRAME_PACKAGE_NAME + 23;
                        artificialFrame = i % 128;
                        if (i % 2 == 0) {
                            Object[] objArr = new Object[1];
                            e(string.substring(4), objArr);
                            string = ((String) objArr[0]).intern();
                            int i5 = 25 / 0;
                        } else {
                            Object[] objArr2 = new Object[1];
                            e(string.substring(4), objArr2);
                            string = ((String) objArr2[0]).intern();
                        }
                    }
                    NotificationChannel notificationChannelM = NotificationApiHelperForO$$ExternalSyntheticApiModelOutline4.m(NotificationManager.DEFAULT_CHANNEL_ID, string, 3);
                    notificationChannelM.enableLights(false);
                    notificationChannelM.enableVibration(false);
                    notificationChannelM.setShowBadge(true);
                    notificationChannelM.setLockscreenVisibility(0);
                    notificationManager.createNotificationChannel(notificationChannelM);
                }
            } else {
                a$$ExternalSyntheticApiModelOutline30.m();
                string = context.getString(R.string.mcsdk_default_notification_channel_name);
                if (string.startsWith(".,.%")) {
                    i = getARTIFICIAL_FRAME_PACKAGE_NAME + 23;
                    artificialFrame = i % 128;
                    if (i % 2 == 0) {
                        Object[] objArr3 = new Object[1];
                        e(string.substring(4), objArr3);
                        string = ((String) objArr3[0]).intern();
                        int i6 = 25 / 0;
                    } else {
                        Object[] objArr4 = new Object[1];
                        e(string.substring(4), objArr4);
                        string = ((String) objArr4[0]).intern();
                    }
                }
                NotificationChannel notificationChannelM2 = NotificationApiHelperForO$$ExternalSyntheticApiModelOutline4.m(NotificationManager.DEFAULT_CHANNEL_ID, string, 3);
                notificationChannelM2.enableLights(false);
                notificationChannelM2.enableVibration(false);
                notificationChannelM2.setShowBadge(true);
                notificationChannelM2.setLockscreenVisibility(0);
                notificationManager.createNotificationChannel(notificationChannelM2);
            }
        }
        return NotificationManager.DEFAULT_CHANNEL_ID;
    }

    String b(Context context, NotificationMessage notificationMessage) {
        String notificationChannelId;
        NotificationManager.NotificationChannelIdProvider notificationChannelIdProvider = this.d;
        if (notificationChannelIdProvider != null) {
            try {
                notificationChannelId = notificationChannelIdProvider.getNotificationChannelId(context, notificationMessage);
            } catch (Exception e) {
                g.b(NotificationManager.d, e, "Exception thrown while app determined channel id for notification message.", new Object[0]);
                notificationChannelId = null;
            }
        } else {
            notificationChannelId = null;
        }
        if (notificationChannelId != null) {
            return notificationChannelId;
        }
        b(context, false);
        return NotificationManager.DEFAULT_CHANNEL_ID;
    }

    private static void e(String str, Object[] objArr) {
        byte[] bArrDecode = Base64.decode(str, 0);
        byte[] bArr = new byte[bArrDecode.length];
        for (int i = 0; i < bArrDecode.length; i++) {
            bArr[i] = (byte) (bArrDecode[(bArrDecode.length - i) - 1] ^ extraCallback);
        }
        objArr[0] = new String(bArr, StandardCharsets.UTF_8);
    }

    private static Bitmap a(@NonNull String str) throws com.salesforce.marketingcloud.push.a {
        Bitmap bitmapA;
        String str2 = NotificationManager.d;
        g.a(str2, "Fetching Large Icon: " + str, new Object[0]);
        o oVarA = i.a.a();
        String str3 = str + "\n";
        if (oVarA != null && (bitmapA = oVarA.a(str3)) != null) {
            g.a(str2, "Large Icon found in cache. Returning cached bitmap.", new Object[0]);
            return bitmapA;
        }
        g.a(str2, "Downloading Large Icon from network: " + str, new Object[0]);
        Bitmap bitmapA2 = q.a.a(str);
        if (oVarA != null) {
            g.a(str2, "Updating memory cache with downloaded Large Icon.", new Object[0]);
            oVarA.a(str3, bitmapA2);
        } else {
            g.b(str2, "ImageHandler is null. Unable to cache the downloaded image.", new Object[0]);
        }
        return bitmapA2;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0044  */
    /* JADX WARN: Code duplicated, block: B:9:0x0021  */
    static String a(Context context, boolean z) {
        android.app.NotificationManager notificationManager;
        String string;
        int i = 2 % 2;
        int i2 = getARTIFICIAL_FRAME_PACKAGE_NAME + 73;
        artificialFrame = i2 % 128;
        if (i2 % 2 == 0) {
            int i3 = 11 / 0;
            if (j.c()) {
                notificationManager = (android.app.NotificationManager) context.getSystemService(TSNotification.NAME);
                if (notificationManager != null && (notificationManager.getNotificationChannel(NotificationManager.DEFAULT_FOREGROUND_CHANNEL_ID) == null || z)) {
                    a$$ExternalSyntheticApiModelOutline30.m();
                    string = context.getString(R.string.mcsdk_foreground_notification_channel_name);
                    if (string.startsWith(".,.%")) {
                        int i4 = getARTIFICIAL_FRAME_PACKAGE_NAME + 31;
                        artificialFrame = i4 % 128;
                        int i5 = i4 % 2;
                        Object[] objArr = new Object[1];
                        e(string.substring(4), objArr);
                        string = ((String) objArr[0]).intern();
                    }
                    NotificationChannel notificationChannelM = NotificationApiHelperForO$$ExternalSyntheticApiModelOutline4.m(NotificationManager.DEFAULT_FOREGROUND_CHANNEL_ID, string, 3);
                    notificationChannelM.enableLights(false);
                    notificationChannelM.enableVibration(false);
                    notificationChannelM.setShowBadge(false);
                    notificationChannelM.setSound(null, null);
                    notificationChannelM.setLockscreenVisibility(0);
                    notificationManager.createNotificationChannel(notificationChannelM);
                }
            }
        } else if (j.c()) {
            notificationManager = (android.app.NotificationManager) context.getSystemService(TSNotification.NAME);
            if (notificationManager != null) {
                a$$ExternalSyntheticApiModelOutline30.m();
                string = context.getString(R.string.mcsdk_foreground_notification_channel_name);
                if (string.startsWith(".,.%")) {
                    int i6 = getARTIFICIAL_FRAME_PACKAGE_NAME + 31;
                    artificialFrame = i6 % 128;
                    int i7 = i6 % 2;
                    Object[] objArr2 = new Object[1];
                    e(string.substring(4), objArr2);
                    string = ((String) objArr2[0]).intern();
                }
                NotificationChannel notificationChannelM2 = NotificationApiHelperForO$$ExternalSyntheticApiModelOutline4.m(NotificationManager.DEFAULT_FOREGROUND_CHANNEL_ID, string, 3);
                notificationChannelM2.enableLights(false);
                notificationChannelM2.enableVibration(false);
                notificationChannelM2.setShowBadge(false);
                notificationChannelM2.setSound(null, null);
                notificationChannelM2.setLockscreenVisibility(0);
                notificationManager.createNotificationChannel(notificationChannelM2);
            }
        }
        return NotificationManager.DEFAULT_FOREGROUND_CHANNEL_ID;
    }

    String a(Context context, NotificationMessage notificationMessage) {
        String notificationChannelId;
        NotificationManager.NotificationChannelIdProvider notificationChannelIdProvider = this.d;
        if (notificationChannelIdProvider != null) {
            try {
                notificationChannelId = notificationChannelIdProvider.getNotificationChannelId(context, notificationMessage);
            } catch (Exception e) {
                g.b(NotificationManager.d, e, "Exception thrown while app determined channel id for notification message.", new Object[0]);
                notificationChannelId = null;
            }
        } else {
            notificationChannelId = null;
        }
        if (notificationChannelId != null) {
            return notificationChannelId;
        }
        a(context, false);
        return NotificationManager.DEFAULT_FOREGROUND_CHANNEL_ID;
    }
}
