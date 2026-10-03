package app.notifee.core.model;

import android.graphics.Bitmap;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import androidx.core.app.Person;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.text.HtmlCompat;
import app.notifee.core.Logger;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.salesforce.marketingcloud.storage.db.i;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import n.o.t.i.f.e.e.l;
import n.o.t.i.f.e.e.n;

/* JADX INFO: loaded from: classes4.dex */
public class NotificationAndroidStyleModel {
    private static final String TAG = "NotificationAndroidStyle";
    private Bundle mNotificationAndroidStyleBundle;

    private NotificationAndroidStyleModel(Bundle bundle) {
        this.mNotificationAndroidStyleBundle = bundle;
    }

    public static NotificationAndroidStyleModel fromBundle(Bundle bundle) {
        return new NotificationAndroidStyleModel(bundle);
    }

    private Task<NotificationCompat.Style> getBigPictureStyleTask(Executor executor) {
        return Tasks.call(executor, new Callable() { // from class: app.notifee.core.model.NotificationAndroidStyleModel$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.lambda$getBigPictureStyleTask$1();
            }
        });
    }

    private NotificationCompat.BigTextStyle getBigTextStyle() {
        NotificationCompat.BigTextStyle bigTextStyle = new NotificationCompat.BigTextStyle();
        if (this.mNotificationAndroidStyleBundle.containsKey("text")) {
            bigTextStyle = bigTextStyle.bigText(HtmlCompat.fromHtml(this.mNotificationAndroidStyleBundle.getString("text"), 0));
        }
        if (this.mNotificationAndroidStyleBundle.containsKey("title")) {
            bigTextStyle = bigTextStyle.setBigContentTitle(HtmlCompat.fromHtml(this.mNotificationAndroidStyleBundle.getString("title"), 0));
        }
        return this.mNotificationAndroidStyleBundle.containsKey("summary") ? bigTextStyle.setSummaryText(HtmlCompat.fromHtml(this.mNotificationAndroidStyleBundle.getString("summary"), 0)) : bigTextStyle;
    }

    private NotificationCompat.InboxStyle getInboxStyle() {
        NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
        if (this.mNotificationAndroidStyleBundle.containsKey("title")) {
            inboxStyle = inboxStyle.setBigContentTitle(HtmlCompat.fromHtml(this.mNotificationAndroidStyleBundle.getString("title"), 0));
        }
        if (this.mNotificationAndroidStyleBundle.containsKey("summary")) {
            inboxStyle = inboxStyle.setSummaryText(HtmlCompat.fromHtml(this.mNotificationAndroidStyleBundle.getString("summary"), 0));
        }
        ArrayList<String> stringArrayList = this.mNotificationAndroidStyleBundle.getStringArrayList("lines");
        int i = 0;
        while (true) {
            Objects.requireNonNull(stringArrayList);
            if (i >= stringArrayList.size()) {
                return inboxStyle;
            }
            inboxStyle = inboxStyle.addLine(HtmlCompat.fromHtml(stringArrayList.get(i), 0));
            i++;
        }
    }

    private Task<NotificationCompat.Style> getMessagingStyleTask(final Executor executor) {
        return Tasks.call(executor, new Callable() { // from class: app.notifee.core.model.NotificationAndroidStyleModel$$ExternalSyntheticLambda2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.lambda$getMessagingStyleTask$2(executor);
            }
        });
    }

    private static Task<Person> getPerson(Executor executor, final Bundle bundle) {
        return Tasks.call(executor, new Callable() { // from class: app.notifee.core.model.NotificationAndroidStyleModel$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return NotificationAndroidStyleModel.lambda$getPerson$0(bundle);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public NotificationCompat.Style lambda$getBigPictureStyleTask$1() throws Exception {
        String string;
        Bitmap bitmap;
        NotificationCompat.BigPictureStyle bigPictureStyle = new NotificationCompat.BigPictureStyle();
        Bitmap bitmap2 = null;
        if (this.mNotificationAndroidStyleBundle.containsKey("picture")) {
            String string2 = this.mNotificationAndroidStyleBundle.getString("picture");
            Objects.requireNonNull(string2);
            try {
                bitmap = (Bitmap) Tasks.await(n.a(string2), 10L, TimeUnit.SECONDS);
            } catch (TimeoutException e) {
                Logger.e(TAG, "Timeout occurred whilst trying to retrieve a big picture style image: " + string2, (Exception) e);
                bitmap = null;
            } catch (Exception e2) {
                Logger.e(TAG, "An error occurred whilst trying to retrieve a big picture style image: " + string2, e2);
                bitmap = null;
            }
            if (bitmap != null) {
                bigPictureStyle.bigPicture(bitmap);
            }
        }
        if (this.mNotificationAndroidStyleBundle.containsKey("largeIcon")) {
            string = this.mNotificationAndroidStyleBundle.getString("largeIcon");
            if (string == null) {
                bigPictureStyle.bigLargeIcon((Bitmap) null);
            }
        } else {
            string = null;
        }
        if (string != null) {
            try {
                bitmap2 = (Bitmap) Tasks.await(n.a(string), 10L, TimeUnit.SECONDS);
            } catch (TimeoutException e3) {
                Logger.e(TAG, "Timeout occurred whilst trying to retrieve a big picture style large icon: " + string, (Exception) e3);
            } catch (Exception e4) {
                Logger.e(TAG, "An error occurred whilst trying to retrieve a big picture style large icon: " + string, e4);
            }
            if (bitmap2 != null) {
                bigPictureStyle.bigLargeIcon(bitmap2);
            }
        }
        if (this.mNotificationAndroidStyleBundle.containsKey("title")) {
            bigPictureStyle = bigPictureStyle.setBigContentTitle(HtmlCompat.fromHtml(this.mNotificationAndroidStyleBundle.getString("title"), 0));
        }
        return this.mNotificationAndroidStyleBundle.containsKey("summary") ? bigPictureStyle.setSummaryText(HtmlCompat.fromHtml(this.mNotificationAndroidStyleBundle.getString("summary"), 0)) : bigPictureStyle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public NotificationCompat.Style lambda$getMessagingStyleTask$2(Executor executor) throws Exception {
        Person person;
        Bundle bundle = this.mNotificationAndroidStyleBundle.getBundle("person");
        Objects.requireNonNull(bundle);
        NotificationCompat.MessagingStyle messagingStyle = new NotificationCompat.MessagingStyle((Person) Tasks.await(getPerson(executor, bundle), 20L, TimeUnit.SECONDS));
        if (this.mNotificationAndroidStyleBundle.containsKey("title")) {
            messagingStyle = messagingStyle.setConversationTitle(HtmlCompat.fromHtml(this.mNotificationAndroidStyleBundle.getString("title"), 0));
        }
        if (this.mNotificationAndroidStyleBundle.containsKey("group")) {
            messagingStyle = messagingStyle.setGroupConversation(this.mNotificationAndroidStyleBundle.getBoolean("group"));
        }
        ArrayList parcelableArrayList = this.mNotificationAndroidStyleBundle.getParcelableArrayList(i.e);
        int i = 0;
        while (true) {
            Objects.requireNonNull(parcelableArrayList);
            if (i >= parcelableArrayList.size()) {
                return messagingStyle;
            }
            Bundle bundle2 = (Bundle) parcelableArrayList.get(i);
            long jB = l.b(bundle2.get("timestamp"));
            if (bundle2.containsKey("person")) {
                Bundle bundle3 = bundle2.getBundle("person");
                Objects.requireNonNull(bundle3);
                person = (Person) Tasks.await(getPerson(executor, bundle3), 20L, TimeUnit.SECONDS);
            } else {
                person = null;
            }
            messagingStyle = messagingStyle.addMessage(HtmlCompat.fromHtml(bundle2.getString("text"), 0), jB, person);
            i++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Person lambda$getPerson$0(Bundle bundle) throws Exception {
        Bitmap bitmap;
        Person.Builder builder = new Person.Builder();
        builder.setName(bundle.getString("name"));
        if (bundle.containsKey("id")) {
            builder.setKey(bundle.getString("id"));
        }
        if (bundle.containsKey("bot")) {
            builder.setBot(bundle.getBoolean("bot"));
        }
        if (bundle.containsKey("important")) {
            builder.setImportant(bundle.getBoolean("important"));
        }
        if (bundle.containsKey("icon")) {
            String string = bundle.getString("icon");
            Objects.requireNonNull(string);
            try {
                bitmap = (Bitmap) Tasks.await(n.a(string), 10L, TimeUnit.SECONDS);
            } catch (TimeoutException e) {
                Logger.e(TAG, "Timeout occurred whilst trying to retrieve a person icon: " + string, (Exception) e);
                bitmap = null;
            } catch (Exception e2) {
                Logger.e(TAG, "An error occurred whilst trying to retrieve a person icon: " + string, e2);
                bitmap = null;
            }
            if (bitmap != null) {
                builder.setIcon(IconCompat.createWithAdaptiveBitmap(bitmap));
            }
        }
        if (bundle.containsKey("uri")) {
            builder.setUri(bundle.getString("uri"));
        }
        return builder.build();
    }

    public Task<NotificationCompat.Style> getStyleTask(Executor executor) {
        int iA = l.a(this.mNotificationAndroidStyleBundle.get("type"));
        if (iA == 0) {
            return getBigPictureStyleTask(executor);
        }
        if (iA == 1) {
            return Tasks.forResult(getBigTextStyle());
        }
        if (iA == 2) {
            return Tasks.forResult(getInboxStyle());
        }
        if (iA != 3) {
            return null;
        }
        return getMessagingStyleTask(executor);
    }

    public Bundle toBundle() {
        return (Bundle) this.mNotificationAndroidStyleBundle.clone();
    }
}
