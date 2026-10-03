package net.openid.appauth;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: classes3.dex */
final class AsciiStringListUtil {
    private AsciiStringListUtil() {
        throw new IllegalStateException("This type is not intended to be instantiated");
    }

    public static String iterableToString(@Nullable Iterable<String> iterable) {
        if (iterable == null) {
            return null;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (String str : iterable) {
            Preconditions.checkArgument(!TextUtils.isEmpty(str), "individual scopes cannot be null or empty");
            linkedHashSet.add(str);
        }
        if (linkedHashSet.isEmpty()) {
            return null;
        }
        return TextUtils.join(StringUtils.SPACE, linkedHashSet);
    }

    public static Set<String> stringToSet(@Nullable String str) {
        if (str == null) {
            return null;
        }
        List listAsList = Arrays.asList(TextUtils.split(str, StringUtils.SPACE));
        LinkedHashSet linkedHashSet = new LinkedHashSet(listAsList.size());
        linkedHashSet.addAll(listAsList);
        return linkedHashSet;
    }
}
