package com.salesforce.marketingcloud.registration;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Size;
import com.salesforce.marketingcloud.g;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public interface RegistrationManager {
    public static final String a = g.a("RegistrationManager");
    public static final String b = "Android";
    public static final int c = 128;

    /* JADX INFO: loaded from: classes3.dex */
    public interface Editor {
        Editor addTag(@NonNull String str);

        Editor addTags(@NonNull Iterable<String> iterable);

        Editor addTags(@NonNull String... strArr);

        Editor clearAttribute(@NonNull String str);

        Editor clearAttributes(@NonNull Iterable<String> iterable);

        Editor clearAttributes(@NonNull String... strArr);

        Editor clearTags();

        boolean commit();

        Editor removeTag(@NonNull String str);

        Editor removeTags(@NonNull Iterable<String> iterable);

        Editor removeTags(@NonNull String... strArr);

        Editor setAttribute(@NonNull @Size(max = 128, min = 1) String str, @NonNull String str2);

        Editor setContactKey(@NonNull @Size(min = 1) String str);

        Editor setSignedString(@Nullable @Size(min = 1) String str);
    }

    /* JADX INFO: loaded from: classes3.dex */
    public interface RegistrationEventListener {
        void onRegistrationReceived(@NonNull Registration registration);
    }

    Editor edit();

    Map<String, String> getAttributes();

    String getContactKey();

    String getDeviceId();

    String getSignedString();

    String getSystemToken();

    Set<String> getTags();

    void registerForRegistrationEvents(@NonNull RegistrationEventListener registrationEventListener);

    void unregisterForRegistrationEvents(@NonNull RegistrationEventListener registrationEventListener);
}
