package com.google.firebase.perf;

import androidx.annotation.NonNull;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public interface FirebasePerformanceAttributable {
    public static final int MAX_ATTRIBUTE_KEY_LENGTH = 40;
    public static final int MAX_ATTRIBUTE_VALUE_LENGTH = 100;
    public static final int MAX_TRACE_CUSTOM_ATTRIBUTES = 5;
    public static final int MAX_TRACE_NAME_LENGTH = 100;

    String getAttribute(@NonNull String str);

    Map<String, String> getAttributes();

    void putAttribute(@NonNull String str, @NonNull String str2);

    void removeAttribute(@NonNull String str);
}
