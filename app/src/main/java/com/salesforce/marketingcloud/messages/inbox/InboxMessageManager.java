package com.salesforce.marketingcloud.messages.inbox;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.salesforce.marketingcloud.g;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface InboxMessageManager {
    public static final String TAG = g.a("InboxMessageManager");

    /* JADX INFO: loaded from: classes3.dex */
    public interface InboxRefreshListener {
        void onRefreshComplete(boolean z);
    }

    /* JADX INFO: loaded from: classes3.dex */
    public interface InboxResponseListener {
        void onInboxMessagesChanged(@NonNull List<InboxMessage> list);
    }

    void deleteMessage(@NonNull InboxMessage inboxMessage);

    void deleteMessage(@NonNull String str);

    void disableInbox();

    void enableInbox();

    int getDeletedMessageCount();

    List<InboxMessage> getDeletedMessages();

    int getMessageCount();

    List<InboxMessage> getMessages();

    int getReadMessageCount();

    List<InboxMessage> getReadMessages();

    int getUnreadMessageCount();

    List<InboxMessage> getUnreadMessages();

    boolean isInboxEnabled();

    void markAllMessagesDeleted();

    void markAllMessagesRead();

    void refreshInbox(@Nullable InboxRefreshListener inboxRefreshListener);

    void registerInboxResponseListener(@NonNull InboxResponseListener inboxResponseListener);

    void setMessageRead(@NonNull InboxMessage inboxMessage);

    void setMessageRead(@NonNull String str);

    void unregisterInboxResponseListener(@NonNull InboxResponseListener inboxResponseListener);
}
