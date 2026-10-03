package app.notifee.core;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.service.notification.StatusBarNotification;
import androidx.annotation.NonNull;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.app.RemoteInput;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.internal.view.SupportMenu;
import androidx.core.text.HtmlCompat;
import androidx.work.Data;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.ExistingWorkPolicy;
import androidx.work.ListenableWorker;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;
import app.notifee.core.event.NotificationEvent;
import app.notifee.core.interfaces.MethodCallResult;
import app.notifee.core.model.NotificationAndroidActionModel;
import app.notifee.core.model.NotificationAndroidModel;
import app.notifee.core.model.NotificationAndroidPressActionModel;
import app.notifee.core.model.NotificationAndroidStyleModel;
import app.notifee.core.model.NotificationModel;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.heanoria.library.reactnative.locationenabler.AndroidLocationEnablerModule;
import com.henninghall.date_picker.props.DateProp;
import com.transistorsoft.locationmanager.config.TSNotification;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import n.o.t.i.f.e.e.e;
import n.o.t.i.f.e.e.f;
import n.o.t.i.f.e.e.h;
import n.o.t.i.f.e.e.i;
import n.o.t.i.f.e.e.j;
import n.o.t.i.f.e.e.l;
import n.o.t.i.f.e.e.n;
import n.o.t.i.f.e.e.q;

/* JADX INFO: loaded from: classes4.dex */
public class c {
    public static final ExecutorService a = Executors.newCachedThreadPool();

    public static Object a(Task task) throws Exception {
        app.notifee.core.database.a.a(e.a).a();
        return null;
    }

    public static Object b(int i) throws Exception {
        NotificationManagerCompat notificationManagerCompatFrom = NotificationManagerCompat.from(e.a);
        if (i == 1 || i == 0) {
            notificationManagerCompatFrom.cancelAll();
        }
        if (i != 2 && i != 0) {
            return null;
        }
        WorkManager workManager = WorkManager.getInstance(e.a);
        workManager.cancelAllWorkByTag("app.notifee.core.NotificationManager.TRIGGER");
        workManager.pruneWork();
        return null;
    }

    public static Void a(int i, List list, Task task) throws Exception {
        if (i == 1) {
            return null;
        }
        app.notifee.core.database.a.a(e.a).a((List<String>) list);
        return null;
    }

    public static Object a(List list, int i, String str) throws Exception {
        WorkManager workManager = WorkManager.getInstance(e.a);
        NotificationManagerCompat notificationManagerCompatFrom = NotificationManagerCompat.from(e.a);
        Iterator it2 = list.iterator();
        while (true) {
            Integer numValueOf = null;
            if (!it2.hasNext()) {
                return null;
            }
            String str2 = (String) it2.next();
            Logger.i("NotificationManager", "Removing notification with id " + str2);
            if (i != 2) {
                if (str != null && str2.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                    try {
                        numValueOf = Integer.valueOf(Integer.parseInt(str2));
                    } catch (Exception unused) {
                        Logger.e("NotificationManager", "cancelAllNotificationsWithIds -> Failed to parse id as integer  " + str2);
                    }
                    if (numValueOf != null) {
                        notificationManagerCompatFrom.cancel(str, numValueOf.intValue());
                    }
                }
                notificationManagerCompatFrom.cancel(str, str2.hashCode());
            }
            if (i != 1) {
                Logger.i("NotificationManager", "Removing notification with id " + str2);
                workManager.cancelUniqueWork("trigger:" + str2);
                workManager.pruneWork();
                PendingIntent pendingIntentA = b.a(str2);
                AlarmManager alarmManagerA = n.o.t.i.f.e.e.a.a();
                if (pendingIntentA != null) {
                    alarmManagerA.cancel(pendingIntentA);
                }
            }
        }
    }

    public static NotificationCompat.Builder b(NotificationAndroidModel notificationAndroidModel, NotificationModel notificationModel, Task task) throws Exception {
        PendingIntent pendingIntentA;
        Bitmap bitmap;
        NotificationCompat.Builder builder = (NotificationCompat.Builder) task.getResult();
        ArrayList<NotificationAndroidActionModel> actions = notificationAndroidModel.getActions();
        if (actions == null) {
            return builder;
        }
        for (NotificationAndroidActionModel notificationAndroidActionModel : actions) {
            if (e.a.getApplicationInfo().targetSdkVersion >= 31 && Build.VERSION.SDK_INT >= 31) {
                pendingIntentA = j.a(notificationModel.b().intValue(), notificationAndroidActionModel.getPressAction().toBundle(), 2, new String[]{TSNotification.NAME, "pressAction"}, notificationModel.toBundle(), notificationAndroidActionModel.getPressAction().toBundle());
            } else {
                pendingIntentA = ReceiverService.a("app.notifee.core.ReceiverService.ACTION_PRESS_INTENT", new String[]{TSNotification.NAME, "pressAction"}, notificationModel.toBundle(), notificationAndroidActionModel.getPressAction().toBundle());
            }
            String icon = notificationAndroidActionModel.getIcon();
            if (icon != null) {
                try {
                    bitmap = (Bitmap) Tasks.await(n.a(notificationAndroidActionModel.getIcon()), 10L, TimeUnit.SECONDS);
                } catch (TimeoutException e) {
                    Logger.e("NotificationManager", "Timeout occurred whilst trying to retrieve an action icon: " + icon, (Exception) e);
                    bitmap = null;
                } catch (Exception e2) {
                    Logger.e("NotificationManager", "An error occurred whilst trying to retrieve an action icon: " + icon, e2);
                    bitmap = null;
                }
            } else {
                bitmap = null;
            }
            NotificationCompat.Action.Builder builder2 = new NotificationCompat.Action.Builder(bitmap != null ? IconCompat.createWithAdaptiveBitmap(bitmap) : null, HtmlCompat.fromHtml(notificationAndroidActionModel.getTitle(), 0), pendingIntentA);
            RemoteInput remoteInput = notificationAndroidActionModel.getRemoteInput(builder2);
            if (remoteInput != null) {
                builder2.addRemoteInput(remoteInput);
            }
            builder.addAction(builder2.build());
        }
        return builder;
    }

    public static Task<NotificationCompat.Builder> a(final NotificationModel notificationModel) {
        final NotificationAndroidModel notificationAndroidModelA = notificationModel.a();
        c$$ExternalSyntheticLambda9 c__externalsyntheticlambda9 = new c$$ExternalSyntheticLambda9(notificationAndroidModelA, notificationModel);
        Continuation continuation = new Continuation() { // from class: app.notifee.core.c$$ExternalSyntheticLambda10
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return c.a(notificationAndroidModelA, task);
            }
        };
        Continuation continuation2 = new Continuation() { // from class: app.notifee.core.c$$ExternalSyntheticLambda11
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return c.a(notificationAndroidModelA, notificationModel, task);
            }
        };
        Continuation continuation3 = new Continuation() { // from class: app.notifee.core.c$$ExternalSyntheticLambda12
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return c.b(notificationAndroidModelA, notificationModel, task);
            }
        };
        Continuation continuation4 = new Continuation() { // from class: app.notifee.core.c$$ExternalSyntheticLambda13
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return c.b(notificationAndroidModelA, task);
            }
        };
        ExecutorService executorService = a;
        return Tasks.call(executorService, c__externalsyntheticlambda9).continueWith(executorService, continuation).continueWith(executorService, continuation3).continueWith(executorService, continuation4).continueWith(executorService, continuation2);
    }

    public static /* synthetic */ NotificationCompat.Builder b(NotificationAndroidModel notificationAndroidModel, Task task) throws Exception {
        Task<NotificationCompat.Style> styleTask;
        NotificationCompat.Style style;
        NotificationCompat.Builder builder = (NotificationCompat.Builder) task.getResult();
        NotificationAndroidStyleModel style2 = notificationAndroidModel.getStyle();
        if (style2 != null && (styleTask = style2.getStyleTask(a)) != null && (style = (NotificationCompat.Style) Tasks.await(styleTask)) != null) {
            builder.setStyle(style);
        }
        return builder;
    }

    public static Task<Void> b(final NotificationModel notificationModel, final Bundle bundle) {
        return a(notificationModel).continueWith(a, new Continuation() { // from class: app.notifee.core.c$$ExternalSyntheticLambda14
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return c.a(notificationModel, bundle, task);
            }
        });
    }

    public static List b() throws Exception {
        ArrayList arrayList = new ArrayList();
        for (StatusBarNotification statusBarNotification : ((NotificationManager) e.a.getSystemService(TSNotification.NAME)).getActiveNotifications()) {
            Notification notification = statusBarNotification.getNotification();
            Bundle bundle = notification.extras;
            Bundle bundle2 = new Bundle();
            Bundle bundle3 = bundle.getBundle("notifee.notification");
            Bundle bundle4 = bundle.getBundle("notifee.trigger");
            if (bundle3 == null) {
                bundle3 = new Bundle();
                bundle3.putString("id", "" + statusBarNotification.getId());
                Object obj = bundle.get(NotificationCompat.EXTRA_TITLE);
                if (obj != null) {
                    bundle3.putString("title", obj.toString());
                }
                Object obj2 = bundle.get(NotificationCompat.EXTRA_TEXT);
                if (obj2 != null) {
                    bundle3.putString("body", obj2.toString());
                }
                Object obj3 = bundle.get(NotificationCompat.EXTRA_SUB_TEXT);
                if (obj3 != null) {
                    bundle3.putString("subtitle", obj3.toString());
                }
                Bundle bundle5 = new Bundle();
                if (Build.VERSION.SDK_INT >= 26) {
                    bundle5.putString("channelId", notification.getChannelId());
                }
                bundle5.putString("tag", statusBarNotification.getTag());
                bundle5.putString("group", notification.getGroup());
                bundle3.putBundle("android", bundle5);
                bundle2.putString("id", "" + statusBarNotification.getId());
            } else {
                bundle2.putString("id", "" + bundle3.get("id"));
            }
            if (bundle4 != null) {
                bundle2.putBundle(com.salesforce.marketingcloud.messages.inbox.b.f71n, bundle4);
            }
            bundle2.putBundle(TSNotification.NAME, bundle3);
            bundle2.putString(DateProp.name, "" + statusBarNotification.getPostTime());
            arrayList.add(bundle2);
        }
        return arrayList;
    }

    public static void b(final MethodCallResult<List<Bundle>> methodCallResult) {
        new app.notifee.core.database.a(e.a).b().addOnCompleteListener(new OnCompleteListener() { // from class: app.notifee.core.c$$ExternalSyntheticLambda3
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                c.b(methodCallResult, task);
            }
        });
    }

    public static void b(MethodCallResult methodCallResult, Task task) {
        ArrayList arrayList = new ArrayList();
        if (task.isSuccessful()) {
            for (q qVar : (List) task.getResult()) {
                Bundle bundle = new Bundle();
                bundle.putBundle(TSNotification.NAME, l.a(qVar.b));
                bundle.putBundle(com.salesforce.marketingcloud.messages.inbox.b.f71n, l.a(qVar.c));
                arrayList.add(bundle);
            }
            methodCallResult.onComplete(null, arrayList);
            return;
        }
        methodCallResult.onComplete(task.getException(), arrayList);
    }

    public static NotificationCompat.Builder a(NotificationAndroidModel notificationAndroidModel, NotificationModel notificationModel) throws Exception {
        Bundle bundle;
        Boolean bool = Boolean.FALSE;
        NotificationCompat.Builder builder = new NotificationCompat.Builder(e.a, notificationAndroidModel.getChannelId());
        Bundle bundle2 = notificationModel.a.getBundle("data");
        if (bundle2 != null) {
            bundle = (Bundle) bundle2.clone();
        } else {
            bundle = new Bundle();
        }
        builder.setExtras(bundle);
        builder.setDeleteIntent(ReceiverService.a("app.notifee.core.ReceiverService.DELETE_INTENT", new String[]{TSNotification.NAME}, notificationModel.toBundle()));
        if (e.a.getApplicationInfo().targetSdkVersion >= 31 && Build.VERSION.SDK_INT >= 31) {
            builder.setContentIntent(j.a(notificationModel.b().intValue(), notificationAndroidModel.getPressAction(), 1, new String[]{TSNotification.NAME, "pressAction"}, notificationModel.toBundle(), notificationAndroidModel.getPressAction()));
        } else {
            builder.setContentIntent(ReceiverService.a("app.notifee.core.ReceiverService.PRESS_INTENT", new String[]{TSNotification.NAME, "pressAction"}, notificationModel.toBundle(), notificationAndroidModel.getPressAction()));
        }
        if (notificationModel.a.getString("title") != null) {
            builder.setContentTitle(HtmlCompat.fromHtml(notificationModel.a.getString("title"), 0));
        }
        if (notificationModel.a.getString("subtitle") != null) {
            builder.setSubText(HtmlCompat.fromHtml(notificationModel.a.getString("subtitle"), 0));
        }
        if (notificationModel.a.getString("body") != null) {
            builder.setContentText(HtmlCompat.fromHtml(notificationModel.a.getString("body"), 0));
        }
        if (notificationAndroidModel.getBadgeIconType() != null) {
            builder.setBadgeIconType(notificationAndroidModel.getBadgeIconType().intValue());
        }
        if (notificationAndroidModel.getCategory() != null) {
            builder.setCategory(notificationAndroidModel.getCategory());
        }
        if (notificationAndroidModel.getColor() != null) {
            builder.setColor(notificationAndroidModel.getColor().intValue());
        }
        builder.setColorized(notificationAndroidModel.getColorized().booleanValue());
        builder.setChronometerCountDown(notificationAndroidModel.getChronometerCountDown().booleanValue());
        if (notificationAndroidModel.getGroup() != null) {
            builder.setGroup(notificationAndroidModel.getGroup());
        }
        builder.setGroupAlertBehavior(notificationAndroidModel.getGroupAlertBehaviour());
        builder.setGroupSummary(notificationAndroidModel.getGroupSummary().booleanValue());
        if (notificationAndroidModel.getInputHistory() != null) {
            builder.setRemoteInputHistory(notificationAndroidModel.getInputHistory());
        }
        if (notificationAndroidModel.getLights() != null) {
            ArrayList<Integer> lights = notificationAndroidModel.getLights();
            builder.setLights(lights.get(0).intValue(), lights.get(1).intValue(), lights.get(2).intValue());
        }
        builder.setLocalOnly(notificationAndroidModel.getLocalOnly().booleanValue());
        if (notificationAndroidModel.getNumber() != null) {
            builder.setNumber(notificationAndroidModel.getNumber().intValue());
        }
        if (notificationAndroidModel.getSound() != null) {
            Uri uriC = n.c(notificationAndroidModel.getSound());
            if (uriC != null) {
                bool = Boolean.TRUE;
                builder.setSound(uriC);
            } else {
                Logger.w("NotificationManager", "Unable to retrieve sound for notification, sound was specified as: " + notificationAndroidModel.getSound());
            }
        }
        builder.setDefaults(notificationAndroidModel.getDefaults(bool).intValue());
        builder.setOngoing(notificationAndroidModel.getOngoing().booleanValue());
        builder.setOnlyAlertOnce(notificationAndroidModel.getOnlyAlertOnce().booleanValue());
        builder.setPriority(notificationAndroidModel.getPriority());
        NotificationAndroidModel.a progress = notificationAndroidModel.getProgress();
        if (progress != null) {
            builder.setProgress(progress.a, progress.b, progress.c);
        }
        if (notificationAndroidModel.getShortcutId() != null) {
            builder.setShortcutId(notificationAndroidModel.getShortcutId());
        }
        builder.setShowWhen(notificationAndroidModel.getShowTimestamp().booleanValue());
        Integer smallIcon = notificationAndroidModel.getSmallIcon();
        if (smallIcon != null) {
            Integer smallIconLevel = notificationAndroidModel.getSmallIconLevel();
            if (smallIconLevel != null) {
                builder.setSmallIcon(smallIcon.intValue(), smallIconLevel.intValue());
            } else {
                builder.setSmallIcon(smallIcon.intValue());
            }
        }
        if (notificationAndroidModel.getSortKey() != null) {
            builder.setSortKey(notificationAndroidModel.getSortKey());
        }
        if (notificationAndroidModel.getTicker() != null) {
            builder.setTicker(notificationAndroidModel.getTicker());
        }
        if (notificationAndroidModel.getTimeoutAfter() != null) {
            builder.setTimeoutAfter(notificationAndroidModel.getTimeoutAfter().longValue());
        }
        builder.setUsesChronometer(notificationAndroidModel.getShowChronometer().booleanValue());
        long[] vibrationPattern = notificationAndroidModel.getVibrationPattern();
        if (vibrationPattern.length > 0) {
            builder.setVibrate(vibrationPattern);
        }
        builder.setVisibility(notificationAndroidModel.getVisibility());
        long timestamp = notificationAndroidModel.getTimestamp();
        if (timestamp > -1) {
            builder.setWhen(timestamp);
        }
        builder.setAutoCancel(notificationAndroidModel.getAutoCancel().booleanValue());
        return builder;
    }

    public static NotificationCompat.Builder a(NotificationAndroidModel notificationAndroidModel, Task task) throws Exception {
        Bitmap bitmap;
        Bitmap bitmapCreateBitmap;
        Rect rect;
        float f;
        Rect rect2;
        NotificationCompat.Builder builder = (NotificationCompat.Builder) task.getResult();
        if (notificationAndroidModel.hasLargeIcon().booleanValue()) {
            String largeIcon = notificationAndroidModel.getLargeIcon();
            try {
                bitmap = (Bitmap) Tasks.await(n.a(largeIcon), 10L, TimeUnit.SECONDS);
            } catch (TimeoutException e) {
                Logger.e("NotificationManager", "Timeout occurred whilst trying to retrieve a largeIcon image: " + largeIcon, (Exception) e);
                bitmap = null;
            } catch (Exception e2) {
                Logger.e("NotificationManager", "An error occurred whilst trying to retrieve a largeIcon image: " + largeIcon, e2);
                bitmap = null;
            }
            if (bitmap != null) {
                if (notificationAndroidModel.getCircularLargeIcon().booleanValue()) {
                    int width = bitmap.getWidth();
                    int height = bitmap.getHeight();
                    if (width > height) {
                        bitmapCreateBitmap = Bitmap.createBitmap(height, height, Bitmap.Config.ARGB_8888);
                        int i = (width - height) / 2;
                        rect = new Rect(i, 0, i + height, height);
                        rect2 = new Rect(0, 0, height, height);
                        f = height / 2;
                    } else {
                        bitmapCreateBitmap = Bitmap.createBitmap(width, width, Bitmap.Config.ARGB_8888);
                        int i2 = (height - width) / 2;
                        rect = new Rect(0, i2, width, i2 + width);
                        f = width / 2;
                        rect2 = new Rect(0, 0, width, width);
                    }
                    Canvas canvas = new Canvas(bitmapCreateBitmap);
                    Paint paint = new Paint();
                    paint.setAntiAlias(true);
                    canvas.drawARGB(0, 0, 0, 0);
                    paint.setColor(SupportMenu.CATEGORY_MASK);
                    canvas.drawCircle(f, f, f, paint);
                    paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
                    canvas.drawBitmap(bitmap, rect, rect2, paint);
                    bitmap = bitmapCreateBitmap;
                }
                builder.setLargeIcon(bitmap);
            }
        }
        return builder;
    }

    public static NotificationCompat.Builder a(NotificationAndroidModel notificationAndroidModel, NotificationModel notificationModel, Task task) throws Exception {
        NotificationCompat.Builder builder = (NotificationCompat.Builder) task.getResult();
        if (notificationAndroidModel.hasFullScreenAction().booleanValue()) {
            NotificationAndroidPressActionModel fullScreenAction = notificationAndroidModel.getFullScreenAction();
            String launchActivity = fullScreenAction.getLaunchActivity();
            Class<?> clsA = h.a(launchActivity);
            if (clsA == null) {
                Logger.e("NotificationManager", String.format("Launch Activity for full-screen action does not exist ('%s').", launchActivity));
                return builder;
            }
            Intent intent = new Intent(e.a, clsA);
            if (fullScreenAction.getLaunchActivityFlags() != -1) {
                intent.addFlags(fullScreenAction.getLaunchActivityFlags());
            }
            if (fullScreenAction.getMainComponent() != null) {
                intent.putExtra("mainComponent", fullScreenAction.getMainComponent());
                intent.putExtra(TSNotification.NAME, notificationModel.toBundle());
                f.b(new i(fullScreenAction.getMainComponent()));
            }
            builder.setFullScreenIntent(PendingIntent.getActivity(e.a, notificationModel.b().intValue(), intent, 167772160), true);
        }
        return builder;
    }

    public static Task<Void> a(@NonNull final int i) {
        return Tasks.call(new Callable() { // from class: app.notifee.core.c$$ExternalSyntheticLambda15
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return c.b(i);
            }
        }).continueWith(a, new Continuation() { // from class: app.notifee.core.c$$ExternalSyntheticLambda16
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return c.a(i, task);
            }
        });
    }

    public static /* synthetic */ Void a(int i, Task task) throws Exception {
        if (i != 2 && i != 0) {
            return null;
        }
        task.continueWith(b.a()).addOnSuccessListener(new OnSuccessListener() { // from class: app.notifee.core.c$$ExternalSyntheticLambda8
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                ((Task) obj).continueWith(new Continuation() { // from class: app.notifee.core.c$$ExternalSyntheticLambda6
                    @Override // com.google.android.gms.tasks.Continuation
                    public final Object then(Task task2) {
                        return c.a(task2);
                    }
                });
            }
        });
        return null;
    }

    public static Task<Void> a(@NonNull final int i, @NonNull final List<String> list, final String str) {
        return Tasks.call(new Callable() { // from class: app.notifee.core.c$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return c.a(list, i, str);
            }
        }).continueWith(new Continuation() { // from class: app.notifee.core.c$$ExternalSyntheticLambda2
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return c.a(i, list, task);
            }
        });
    }

    public static Void a(NotificationModel notificationModel, Bundle bundle, Task task) throws Exception {
        NotificationCompat.Builder builder = (NotificationCompat.Builder) task.getResult();
        Bundle bundle2 = new Bundle();
        bundle2.putBundle("notifee.notification", notificationModel.toBundle());
        if (bundle != null) {
            bundle2.putBundle("notifee.trigger", bundle);
        }
        builder.addExtras(bundle2);
        Notification notificationBuild = builder.build();
        int iIntValue = notificationModel.b().intValue();
        NotificationAndroidModel notificationAndroidModelA = notificationModel.a();
        if (notificationAndroidModelA.getLoopSound().booleanValue()) {
            notificationBuild.flags |= 4;
        }
        if (notificationAndroidModelA.getFlags() != null && notificationAndroidModelA.getFlags().length > 0) {
            for (int i : notificationAndroidModelA.getFlags()) {
                notificationBuild.flags = i | notificationBuild.flags;
            }
        }
        if (notificationAndroidModelA.getLightUpScreen().booleanValue()) {
            PowerManager powerManager = (PowerManager) e.a.getSystemService("power");
            if (!powerManager.isInteractive()) {
                powerManager.newWakeLock(805306394, "Notifee:lock").acquire();
                powerManager.newWakeLock(1, "Notifee:cpuLock").acquire();
            }
        }
        if (notificationAndroidModelA.getAsForegroundService().booleanValue()) {
            Bundle bundle3 = notificationModel.toBundle();
            String str = ForegroundService.a;
            Intent intent = new Intent(e.a, (Class<?>) ForegroundService.class);
            intent.setAction("app.notifee.core.ForegroundService.START");
            intent.putExtra("hashCode", iIntValue);
            intent.putExtra(TSNotification.NAME, notificationBuild);
            intent.putExtra("notificationBundle", bundle3);
            if (Build.VERSION.SDK_INT >= 26) {
                e.a.startForegroundService(intent);
            } else {
                e.a.startService(intent);
            }
        } else {
            NotificationManagerCompat.from(e.a).notify(notificationAndroidModelA.getTag(), iIntValue, notificationBuild);
        }
        f.a(new NotificationEvent(3, notificationModel));
        return null;
    }

    public static Task<Void> a(final NotificationModel notificationModel, final Bundle bundle) {
        return Tasks.call(a, new Callable() { // from class: app.notifee.core.c$$ExternalSyntheticLambda7
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return c.a(bundle, notificationModel);
            }
        });
    }

    public static Void a(Bundle bundle, NotificationModel notificationModel) throws Exception {
        int iA = l.a(bundle.get("type"));
        if (iA == 0) {
            app.notifee.core.model.a aVar = new app.notifee.core.model.a(bundle);
            String str = "trigger:" + notificationModel.c();
            long jRound = 0;
            if (aVar.a.containsKey("timestamp")) {
                long jB = l.b(aVar.a.get("timestamp"));
                if (jB > 0) {
                    jRound = Math.round((jB - System.currentTimeMillis()) / 1000);
                }
            }
            int i = aVar.b;
            Data.Builder builderPutString = new Data.Builder().putString("workType", "app.notifee.core.NotificationManager.TRIGGER").putString("id", notificationModel.c());
            Boolean bool = aVar.d;
            app.notifee.core.database.a.a(e.a);
            app.notifee.core.database.a.b.a(new q(notificationModel.c(), l.a(notificationModel.toBundle()), l.a(bundle), bool));
            if (bool.booleanValue()) {
                b.a(notificationModel, aVar);
            } else {
                WorkManager workManager = WorkManager.getInstance(e.a);
                if (i == -1) {
                    OneTimeWorkRequest.Builder builder = new OneTimeWorkRequest.Builder(Worker.class);
                    builder.addTag("app.notifee.core.NotificationManager.TRIGGER");
                    builder.addTag(str);
                    builderPutString.putString("workRequestType", "OneTime");
                    builder.setInputData(builderPutString.build());
                    builder.setInitialDelay(jRound, TimeUnit.SECONDS);
                    workManager.enqueueUniqueWork(str, ExistingWorkPolicy.REPLACE, builder.build());
                } else {
                    PeriodicWorkRequest.Builder builder2 = new PeriodicWorkRequest.Builder((Class<? extends ListenableWorker>) Worker.class, aVar.b, aVar.c);
                    builder2.addTag("app.notifee.core.NotificationManager.TRIGGER");
                    builder2.addTag(str);
                    builder2.setInitialDelay(jRound, TimeUnit.SECONDS);
                    builderPutString.putString("workRequestType", "Periodic");
                    builder2.setInputData(builderPutString.build());
                    workManager.enqueueUniquePeriodicWork(str, ExistingPeriodicWorkPolicy.UPDATE, builder2.build());
                }
            }
        } else if (iA == 1) {
            String str2 = "trigger:" + notificationModel.c();
            WorkManager workManager2 = WorkManager.getInstance(e.a);
            Data.Builder builderPutString2 = new Data.Builder().putString("workType", "app.notifee.core.NotificationManager.TRIGGER").putString("workRequestType", "Periodic").putString("id", notificationModel.c());
            app.notifee.core.database.a.a(e.a);
            app.notifee.core.database.a.b.a(new q(notificationModel.c(), l.a(notificationModel.toBundle()), l.a(bundle), Boolean.FALSE));
            long jA = bundle.containsKey(AndroidLocationEnablerModule.LOCATION_INTERVAL_DURATION_PARAMS_KEY) ? l.a(bundle.get(AndroidLocationEnablerModule.LOCATION_INTERVAL_DURATION_PARAMS_KEY)) : -1;
            TimeUnit timeUnitValueOf = TimeUnit.SECONDS;
            if (bundle.containsKey("timeUnit")) {
                String string = bundle.getString("timeUnit");
                try {
                    timeUnitValueOf = TimeUnit.valueOf(string);
                } catch (IllegalArgumentException e) {
                    Logger.e("IntervalTriggerModel", "An error occurred whilst trying to convert interval time unit: " + string, (Exception) e);
                }
            }
            PeriodicWorkRequest.Builder builder3 = new PeriodicWorkRequest.Builder((Class<? extends ListenableWorker>) Worker.class, jA, timeUnitValueOf);
            TimeUnit timeUnitValueOf2 = TimeUnit.SECONDS;
            if (bundle.containsKey("timeUnit")) {
                String string2 = bundle.getString("timeUnit");
                try {
                    timeUnitValueOf2 = TimeUnit.valueOf(string2);
                } catch (IllegalArgumentException e2) {
                    Logger.e("IntervalTriggerModel", "An error occurred whilst trying to convert interval time unit: " + string2, (Exception) e2);
                }
            }
            PeriodicWorkRequest.Builder initialDelay = builder3.setInitialDelay(jA, timeUnitValueOf2);
            initialDelay.addTag("app.notifee.core.NotificationManager.TRIGGER");
            initialDelay.addTag(str2);
            initialDelay.setInputData(builderPutString2.build());
            workManager2.enqueueUniquePeriodicWork(str2, ExistingPeriodicWorkPolicy.UPDATE, initialDelay.build());
        }
        f.a(new NotificationEvent(7, notificationModel));
        return null;
    }

    public static Task<List<Bundle>> a() {
        return Tasks.call(new Callable() { // from class: app.notifee.core.c$$ExternalSyntheticLambda4
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return c.b();
            }
        });
    }

    public static void a(final MethodCallResult<List<String>> methodCallResult) {
        new app.notifee.core.database.a(e.a).b().addOnCompleteListener(new OnCompleteListener() { // from class: app.notifee.core.c$$ExternalSyntheticLambda5
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                c.a(methodCallResult, task);
            }
        });
    }

    public static void a(MethodCallResult methodCallResult, Task task) {
        ArrayList arrayList = new ArrayList();
        if (task.isSuccessful()) {
            Iterator it2 = ((List) task.getResult()).iterator();
            while (it2.hasNext()) {
                arrayList.add(((q) it2.next()).a);
            }
            methodCallResult.onComplete(null, arrayList);
            return;
        }
        methodCallResult.onComplete(task.getException(), null);
    }

    public static void a(final Data data, final CallbackToFutureAdapter.Completer<ListenableWorker.Result> completer) {
        final String string = data.getString("id");
        app.notifee.core.database.a aVar = new app.notifee.core.database.a(e.a);
        aVar.b(string).continueWithTask(a, new Continuation() { // from class: app.notifee.core.c$$ExternalSyntheticLambda17
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return c.a(data, completer, task);
            }
        }).addOnCompleteListener(new OnCompleteListener() { // from class: app.notifee.core.c$$ExternalSyntheticLambda18
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                c.a(completer, data, string, task);
            }
        });
    }

    public static Task a(Data data, CallbackToFutureAdapter.Completer completer, Task task) throws Exception {
        byte[] byteArray;
        q qVar = (q) task.getResult();
        if (qVar == null || (byteArray = qVar.b) == null) {
            byteArray = data.getByteArray(TSNotification.NAME);
            if (byteArray != null) {
                Logger.w("NotificationManager", "The trigger notification was created using an older version, please consider recreating the notification.");
            } else {
                Logger.w("NotificationManager", "Attempted to handle doScheduledWork but no notification data was found.");
                completer.set(ListenableWorker.Result.success());
                return null;
            }
        }
        NotificationModel notificationModel = new NotificationModel(l.a(byteArray));
        byte[] bArr = qVar.c;
        return b(notificationModel, bArr != null ? l.a(bArr) : null);
    }

    public static void a(CallbackToFutureAdapter.Completer completer, Data data, String str, Task task) {
        completer.set(ListenableWorker.Result.success());
        if (!task.isSuccessful()) {
            Logger.e("NotificationManager", "Failed to display notification", task.getException());
            return;
        }
        String string = data.getString("workRequestType");
        if (string == null || !string.equals("OneTime")) {
            return;
        }
        app.notifee.core.database.a.a(e.a).a(str);
    }
}
