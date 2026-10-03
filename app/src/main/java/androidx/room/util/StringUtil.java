package androidx.room.util;

import androidx.room.Room;
import ch.qos.logback.classic.spi.CallerData;
import ch.qos.logback.core.CoreConstants;
import io.sentry.android.core.SentryLogcatAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class StringUtil {
    public static final String[] EMPTY_STRING_ARRAY = new String[0];

    public static /* synthetic */ void getEMPTY_STRING_ARRAY$annotations() {
    }

    public static final StringBuilder newStringBuilder() {
        return new StringBuilder();
    }

    public static final void appendPlaceholders(@NotNull StringBuilder builder, int i) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        for (int i2 = 0; i2 < i; i2++) {
            builder.append(CallerData.NA);
            if (i2 < i - 1) {
                builder.append(",");
            }
        }
    }

    public static final List<Integer> splitToIntList(@Nullable String str) {
        List listSplit$default;
        Integer numValueOf;
        if (str == null || (listSplit$default = StringsKt__StringsKt.split$default((CharSequence) str, new char[]{CoreConstants.COMMA_CHAR}, false, 0, 6, (Object) null)) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it2 = listSplit$default.iterator();
        while (it2.hasNext()) {
            try {
                numValueOf = Integer.valueOf(Integer.parseInt((String) it2.next()));
            } catch (NumberFormatException e) {
                SentryLogcatAdapter.e(Room.LOG_TAG, "Malformed integer list", e);
                numValueOf = null;
            }
            if (numValueOf != null) {
                arrayList.add(numValueOf);
            }
        }
        return arrayList;
    }

    public static final String joinIntoString(@Nullable List<Integer> list) {
        if (list != null) {
            return CollectionsKt___CollectionsKt.joinToString$default(list, ",", null, null, 0, null, null, 62, null);
        }
        return null;
    }
}
