package io.sentry.util;

import io.sentry.FilterString;
import io.sentry.SentryEvent;
import io.sentry.protocol.Message;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public final class ErrorUtils {
    public static boolean isIgnored(@Nullable List<FilterString> list, @NotNull SentryEvent sentryEvent) {
        if (sentryEvent == null || list == null || list.isEmpty()) {
            return false;
        }
        HashSet hashSet = new HashSet();
        Message message = sentryEvent.getMessage();
        if (message != null) {
            String message2 = message.getMessage();
            if (message2 != null) {
                hashSet.add(message2);
            }
            String formatted = message.getFormatted();
            if (formatted != null) {
                hashSet.add(formatted);
            }
        }
        Throwable throwable = sentryEvent.getThrowable();
        if (throwable != null) {
            hashSet.add(throwable.toString());
        }
        Iterator<FilterString> it2 = list.iterator();
        while (it2.hasNext()) {
            if (hashSet.contains(it2.next().getFilterString())) {
                return true;
            }
        }
        for (FilterString filterString : list) {
            Iterator it3 = hashSet.iterator();
            while (it3.hasNext()) {
                if (filterString.matches((String) it3.next())) {
                    return true;
                }
            }
        }
        return false;
    }
}
