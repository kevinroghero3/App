package com.transistorsoft.locationmanager.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.util.Base64;
import android.widget.RemoteViews;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.browser.trusted.NotificationApiHelperForO$$ExternalSyntheticApiModelOutline4;
import androidx.core.app.NotificationCompat;
import com.transistorsoft.locationmanager.adapter.TSConfig;
import com.transistorsoft.locationmanager.config.TSNotification;
import com.transistorsoft.locationmanager.logger.TSLog;
import com.transistorsoft.locationmanager.notification.TSLocalNotification;
import com.transistorsoft.locationmanager.util.Util;
import com.transistorsoft.tslocationmanager.R;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes.dex */
public class ForegroundNotification {
    public static final String NOTIFICATION_ACTION = "notificationaction";
    public static final int NOTIFICATION_ID = 9942585;
    static final String a = "default";
    private static int artificialFrame = 1;
    static final String b = "notificationButtonPause";
    private static final AtomicLong c;
    private static byte extraCallback;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME;

    static {
        accessartificialFrame();
        c = new AtomicLong(0L);
    }

    static void a(long j) {
        c.set(j);
    }

    public static Notification build(Context context) {
        NotificationCompat.Builder builderBuild = TSLocalNotification.build(context);
        builderBuild.setOnlyAlertOnce(true);
        builderBuild.setSound(null);
        AtomicLong atomicLong = c;
        if (atomicLong.get() > 0) {
            builderBuild.setWhen(atomicLong.get());
        }
        if (TSConfig.isLoaded()) {
            TSConfig tSConfig = TSConfig.getInstance(context);
            builderBuild.setPriority(tSConfig.getNotification().getPriority().intValue());
            b(context, builderBuild);
            if (!tSConfig.getNotification().getLayout().isEmpty()) {
                a(context, builderBuild);
            }
        } else {
            c(context, builderBuild);
        }
        Notification notificationBuild = builderBuild.build();
        notificationBuild.flags |= 98;
        return notificationBuild;
    }

    public static void onUpdateChannelId(Context context) {
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }
        Map<String, Object> previousValues = TSConfig.getInstance(context).getNotification().getPreviousValues();
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(TSNotification.NAME);
        createNotificationChannel(context, false);
        if (AbstractService.a()) {
            notificationManager.notify(NOTIFICATION_ID, build(context));
        }
        if (previousValues != null) {
            String strA = (String) previousValues.get("channelId");
            if (strA.isEmpty()) {
                strA = a(context);
            }
            if (notificationManager.getNotificationChannel(strA) != null) {
                try {
                    notificationManager.deleteNotificationChannel(strA);
                } catch (SecurityException e) {
                    TSLog.logger.error(TSLog.error(e.getMessage()));
                }
            }
        }
    }

    public static void onUpdateChannelName(Context context) {
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }
        TSConfig tSConfig = TSConfig.getInstance(context);
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(TSNotification.NAME);
        TSNotification notification = tSConfig.getNotification();
        String channelId = notification.getChannelId();
        if (channelId.isEmpty()) {
            channelId = a(context);
        }
        NotificationChannel notificationChannel = notificationManager.getNotificationChannel(channelId);
        if (notificationChannel != null) {
            notificationChannel.setName(notification.getChannelName());
        }
    }

    private static void c(Context context, NotificationCompat.Builder builder) {
        String string;
        int i = 2 % 2;
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        int i2 = applicationInfo.labelRes;
        if (i2 == 0) {
            int i3 = artificialFrame + 59;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i3 % 128;
            if (i3 % 2 != 0) {
                applicationInfo.nonLocalizedLabel.toString();
                throw null;
            }
            string = applicationInfo.nonLocalizedLabel.toString();
            int i4 = artificialFrame + 101;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i4 % 128;
            int i5 = i4 % 2;
        } else {
            String string2 = context.getString(i2);
            if (!(!string2.startsWith(".,.%"))) {
                Object[] objArr = new Object[1];
                d(string2.substring(4), objArr);
                string2 = ((String) objArr[0]).intern();
            }
            string = string2;
        }
        builder.setContentTitle(string);
        builder.setSmallIcon(TSLocalNotification.getSmallIcon(context));
    }

    private static void d(String str, Object[] objArr) {
        byte[] bArrDecode = Base64.decode(str, 0);
        byte[] bArr = new byte[bArrDecode.length];
        for (int i = 0; i < bArrDecode.length; i++) {
            bArr[i] = (byte) (bArrDecode[(bArrDecode.length - i) - 1] ^ extraCallback);
        }
        objArr[0] = new String(bArr, StandardCharsets.UTF_8);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x004d  */
    /* JADX WARN: Code duplicated, block: B:12:0x0054  */
    /* JADX WARN: Code duplicated, block: B:14:0x0060  */
    /* JADX WARN: Code duplicated, block: B:16:0x006c  */
    /* JADX WARN: Code duplicated, block: B:17:0x0081  */
    /* JADX WARN: Code duplicated, block: B:18:0x0094 A[PHI: r5
  0x0094: PHI (r5v5 java.lang.String) = (r5v4 java.lang.String), (r5v10 java.lang.String) binds: [B:13:0x005e, B:16:0x006c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:9:0x0049 A[PHI: r1 r4 r5
  0x0049: PHI (r1v11 com.transistorsoft.locationmanager.config.TSNotification) = 
  (r1v5 com.transistorsoft.locationmanager.config.TSNotification)
  (r1v13 com.transistorsoft.locationmanager.config.TSNotification)
 binds: [B:8:0x0047, B:5:0x002c] A[DONT_GENERATE, DONT_INLINE]
  0x0049: PHI (r4v2 com.transistorsoft.locationmanager.config.TSNotification) = 
  (r4v0 com.transistorsoft.locationmanager.config.TSNotification)
  (r4v3 com.transistorsoft.locationmanager.config.TSNotification)
 binds: [B:8:0x0047, B:5:0x002c] A[DONT_GENERATE, DONT_INLINE]
  0x0049: PHI (r5v3 android.content.pm.ApplicationInfo) = (r5v0 android.content.pm.ApplicationInfo), (r5v11 android.content.pm.ApplicationInfo) binds: [B:8:0x0047, B:5:0x002c] A[DONT_GENERATE, DONT_INLINE]] */
    private static void b(Context context, NotificationCompat.Builder builder) {
        TSNotification notification;
        ApplicationInfo applicationInfo;
        TSNotification notification2;
        String title;
        int i;
        String string;
        int i2;
        int i3 = 2 % 2;
        int i4 = getARTIFICIAL_FRAME_PACKAGE_NAME + 17;
        artificialFrame = i4 % 128;
        if (i4 % 2 == 0) {
            TSConfig tSConfig = TSConfig.getInstance(context);
            notification = tSConfig.getNotification();
            applicationInfo = context.getApplicationInfo();
            notification2 = tSConfig.getNotification();
            title = notification2.getTitle();
            int i5 = 26 / 0;
            if (!(!title.isEmpty())) {
                i = applicationInfo.labelRes;
                if (i == 0) {
                    title = applicationInfo.nonLocalizedLabel.toString();
                } else {
                    string = context.getString(i);
                    if (string.startsWith(".,.%")) {
                        i2 = getARTIFICIAL_FRAME_PACKAGE_NAME + 101;
                        artificialFrame = i2 % 128;
                        if (i2 % 2 == 0) {
                            Object[] objArr = new Object[1];
                            d(string.substring(4), objArr);
                            string = ((String) objArr[0]).intern();
                            int i6 = 84 / 0;
                            title = string;
                        } else {
                            Object[] objArr2 = new Object[1];
                            d(string.substring(4), objArr2);
                            title = ((String) objArr2[0]).intern();
                        }
                    } else {
                        title = string;
                    }
                }
            }
        } else {
            TSConfig tSConfig2 = TSConfig.getInstance(context);
            notification = tSConfig2.getNotification();
            applicationInfo = context.getApplicationInfo();
            notification2 = tSConfig2.getNotification();
            title = notification2.getTitle();
            if (title.isEmpty()) {
                i = applicationInfo.labelRes;
                if (i == 0) {
                    title = applicationInfo.nonLocalizedLabel.toString();
                } else {
                    string = context.getString(i);
                    if (string.startsWith(".,.%")) {
                        i2 = getARTIFICIAL_FRAME_PACKAGE_NAME + 101;
                        artificialFrame = i2 % 128;
                        if (i2 % 2 == 0) {
                            Object[] objArr3 = new Object[1];
                            d(string.substring(4), objArr3);
                            string = ((String) objArr3[0]).intern();
                            int i7 = 84 / 0;
                            title = string;
                        } else {
                            Object[] objArr4 = new Object[1];
                            d(string.substring(4), objArr4);
                            title = ((String) objArr4[0]).intern();
                        }
                    } else {
                        title = string;
                    }
                }
            }
        }
        builder.setContentTitle(title);
        builder.setContentText(notification2.getText());
        builder.setStyle(new NotificationCompat.BigTextStyle().bigText(notification2.getText()));
        builder.setSmallIcon(TSLocalNotification.getSmallIcon(context));
        String largeIcon = notification2.getLargeIcon();
        if (!largeIcon.isEmpty()) {
            Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(context.getResources(), context.getResources().getIdentifier(largeIcon, null, context.getPackageName()));
            if (bitmapDecodeResource != null) {
                int i8 = artificialFrame + AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i8 % 128;
                int i9 = i8 % 2;
                builder.setLargeIcon(bitmapDecodeResource);
            } else {
                TSLog.logger.warn("Failed to find notificationLargeIcon: " + largeIcon);
            }
        }
        String color = notification.getColor();
        if (color.isEmpty()) {
            return;
        }
        builder.setColor(Color.parseColor(color));
    }

    public static void createNotificationChannel(Context context, boolean z) {
        NotificationManager notificationManager;
        String channelName;
        int i = 2 % 2;
        if (Build.VERSION.SDK_INT >= 26 && (notificationManager = (NotificationManager) context.getSystemService(TSNotification.NAME)) != null) {
            int i2 = artificialFrame + 99;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i2 % 128;
            int i3 = i2 % 2;
            String strA = a(context);
            if (context.getApplicationInfo().labelRes != 0) {
                int i4 = getARTIFICIAL_FRAME_PACKAGE_NAME + 41;
                artificialFrame = i4 % 128;
                if (i4 % 2 == 0) {
                    context.getString(context.getApplicationInfo().labelRes).startsWith(".,.%");
                    throw null;
                }
                channelName = context.getString(context.getApplicationInfo().labelRes);
                if (channelName.startsWith(".,.%")) {
                    int i5 = getARTIFICIAL_FRAME_PACKAGE_NAME + 93;
                    artificialFrame = i5 % 128;
                    if (i5 % 2 == 0) {
                        Object[] objArr = new Object[1];
                        d(channelName.substring(4), objArr);
                        ((String) objArr[0]).intern();
                        throw null;
                    }
                    Object[] objArr2 = new Object[1];
                    d(channelName.substring(4), objArr2);
                    channelName = ((String) objArr2[0]).intern();
                }
            } else {
                channelName = "TSLocationManager";
            }
            if (!(!TSConfig.isLoaded())) {
                TSNotification notification = TSConfig.getInstance(context).getNotification();
                if (!notification.getChannelName().isEmpty()) {
                    channelName = notification.getChannelName();
                    int i6 = getARTIFICIAL_FRAME_PACKAGE_NAME + 29;
                    artificialFrame = i6 % 128;
                    int i7 = i6 % 2;
                }
                if (!notification.getChannelId().isEmpty()) {
                    strA = notification.getChannelId();
                    int i8 = getARTIFICIAL_FRAME_PACKAGE_NAME + 43;
                    artificialFrame = i8 % 128;
                    int i9 = i8 % 2;
                }
            }
            if (notificationManager.getNotificationChannel(strA) == null || z) {
                NotificationChannel notificationChannelM = NotificationApiHelperForO$$ExternalSyntheticApiModelOutline4.m(strA, channelName, 1);
                notificationChannelM.setShowBadge(false);
                notificationChannelM.enableLights(false);
                notificationChannelM.setSound(null, null);
                notificationChannelM.enableVibration(false);
                notificationChannelM.setLockscreenVisibility(-1);
                TSLog.logger.debug(notificationChannelM.toString());
                notificationManager.createNotificationChannel(notificationChannelM);
            }
        }
    }

    private static void a(Context context, NotificationCompat.Builder builder) {
        int identifier;
        String string;
        int i = 2 % 2;
        int i2 = getARTIFICIAL_FRAME_PACKAGE_NAME + 71;
        artificialFrame = i2 % 128;
        Object obj = null;
        if (i2 % 2 == 0) {
            TSConfig tSConfig = TSConfig.getInstance(context);
            context.getApplicationInfo();
            tSConfig.getNotification().getLayout().equalsIgnoreCase("default");
            obj.hashCode();
            throw null;
        }
        TSConfig tSConfig2 = TSConfig.getInstance(context);
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        TSNotification notification = tSConfig2.getNotification();
        String layout = notification.getLayout();
        if (layout.equalsIgnoreCase("default")) {
            int i3 = artificialFrame + 101;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i3 % 128;
            if (i3 % 2 != 0) {
                int i4 = R.layout.tslocationmanager_notification_layout;
                obj.hashCode();
                throw null;
            }
            identifier = R.layout.tslocationmanager_notification_layout;
        } else {
            identifier = context.getResources().getIdentifier(layout, "layout", context.getPackageName());
        }
        if (identifier == 0) {
            TSLog.logger.error(TSLog.error("Could not find custom notification layout '" + notification.getLayout() + "' in app/src/main/res/layout"));
            b(context, builder);
            return;
        }
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), identifier);
        if (identifier == R.layout.tslocationmanager_notification_layout) {
            int i5 = getARTIFICIAL_FRAME_PACKAGE_NAME + 89;
            artificialFrame = i5 % 128;
            if (i5 % 2 == 0) {
                a(context, remoteViews, b);
                int i6 = 38 / 0;
            } else {
                a(context, remoteViews, b);
            }
            int i7 = getARTIFICIAL_FRAME_PACKAGE_NAME + 115;
            artificialFrame = i7 % 128;
            int i8 = i7 % 2;
        }
        int identifier2 = context.getResources().getIdentifier("applicationName", "id", context.getPackageName());
        if (identifier2 != 0) {
            int i9 = applicationInfo.labelRes;
            if (i9 == 0) {
                string = applicationInfo.nonLocalizedLabel.toString();
            } else {
                string = context.getString(i9);
                if (string.startsWith(".,.%")) {
                    Object[] objArr = new Object[1];
                    d(string.substring(4), objArr);
                    string = ((String) objArr[0]).intern();
                }
            }
            remoteViews.setTextViewText(identifier2, string);
        }
        int identifier3 = context.getResources().getIdentifier("notificationSmallIcon", "id", context.getPackageName());
        if (identifier3 != 0) {
            remoteViews.setImageViewResource(identifier3, TSLocalNotification.getSmallIcon(context));
        }
        String largeIcon = notification.getLargeIcon();
        if (!largeIcon.isEmpty()) {
            Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(context.getResources(), context.getResources().getIdentifier(largeIcon, null, context.getPackageName()));
            if (bitmapDecodeResource != null) {
                int identifier4 = context.getResources().getIdentifier("notificationLargeIcon", "id", context.getPackageName());
                if (identifier4 != 0) {
                    remoteViews.setImageViewBitmap(identifier4, bitmapDecodeResource);
                }
            } else {
                TSLog.logger.warn("Failed to find notificationLargeIcon: " + largeIcon);
            }
        }
        if (context.getResources().getIdentifier("notificationTitle", "id", context.getPackageName()) != 0) {
            int i10 = artificialFrame + 1;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i10 % 128;
            if (i10 % 2 != 0) {
                notification.getTitle().isEmpty();
                throw null;
            }
            String title = notification.getTitle();
            if (title.isEmpty()) {
                int i11 = applicationInfo.labelRes;
                if (i11 == 0) {
                    title = applicationInfo.nonLocalizedLabel.toString();
                } else {
                    title = context.getString(i11);
                    if (title.startsWith(".,.%")) {
                        int i12 = getARTIFICIAL_FRAME_PACKAGE_NAME + 93;
                        artificialFrame = i12 % 128;
                        int i13 = i12 % 2;
                        Object[] objArr2 = new Object[1];
                        d(title.substring(4), objArr2);
                        title = ((String) objArr2[0]).intern();
                    }
                }
            }
            a(context, remoteViews, "notificationTitle", title);
        }
        if (context.getResources().getIdentifier("notificationText", "id", context.getPackageName()) != 0) {
            int i14 = getARTIFICIAL_FRAME_PACKAGE_NAME + 87;
            artificialFrame = i14 % 128;
            int i15 = i14 % 2;
            a(context, remoteViews, "notificationText", notification.getText());
        }
        Map<String, String> strings = notification.getStrings();
        if (!strings.isEmpty()) {
            Iterator<Map.Entry<String, String>> it2 = strings.entrySet().iterator();
            while (it2.hasNext()) {
                int i16 = getARTIFICIAL_FRAME_PACKAGE_NAME + 91;
                artificialFrame = i16 % 128;
                if (i16 % 2 == 0) {
                    Map.Entry<String, String> next = it2.next();
                    a(context, remoteViews, next.getKey().toString(), next.getValue().toString());
                    throw null;
                }
                Map.Entry<String, String> next2 = it2.next();
                a(context, remoteViews, next2.getKey().toString(), next2.getValue().toString());
            }
        }
        List<String> actions = notification.getActions();
        if (!actions.isEmpty()) {
            Iterator<String> it3 = actions.iterator();
            while (it3.hasNext()) {
                a(context, remoteViews, it3.next());
            }
        }
        builder.setSmallIcon(TSLocalNotification.getSmallIcon(context));
        builder.setCustomBigContentView(remoteViews);
        if (Build.VERSION.SDK_INT >= 26) {
            builder.setContent(remoteViews);
        }
    }

    private static void a(Context context, RemoteViews remoteViews, String str, String str2) {
        int identifier = context.getResources().getIdentifier(str, "id", context.getPackageName());
        if (identifier != 0) {
            remoteViews.setTextViewText(identifier, str2);
            return;
        }
        TSLog.logger.warn(TSLog.warn("Failed to find TextView resource: " + str));
    }

    private static void a(Context context, RemoteViews remoteViews, String str) {
        PendingIntent service;
        int identifier = context.getResources().getIdentifier(str, "id", context.getPackageName());
        if (identifier != 0) {
            Intent intent = new Intent(context, (Class<?>) TrackingService.class);
            intent.setAction("notificationaction");
            intent.putExtra("id", str);
            if (Build.VERSION.SDK_INT >= 26) {
                service = PendingIntent.getForegroundService(context, identifier, intent, Util.getPendingIntentFlags(134217728));
            } else {
                service = PendingIntent.getService(context, identifier, intent, 134217728);
            }
            remoteViews.setOnClickPendingIntent(identifier, service);
            return;
        }
        TSLog.logger.warn(TSLog.warn("Failed to find Button resource in notification_layout for notification-action: " + str));
    }

    static String a(Context context) {
        return context.getPackageName() + "TSLocationManager";
    }

    static void accessartificialFrame() {
        extraCallback = (byte) -124;
    }
}
