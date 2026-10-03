package com.google.firebase.iid.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public interface FirebaseInstanceIdInternal {

    /* JADX INFO: loaded from: classes.dex */
    public interface NewTokenListener {
        void onNewToken(String str);
    }

    void addNewTokenListener(NewTokenListener newTokenListener);

    void deleteToken(@NonNull String str, @NonNull String str2) throws IOException;

    String getId();

    String getToken();

    Task<String> getTokenTask();
}
