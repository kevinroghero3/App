package androidx.compose.ui.res;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.util.Base64;
import androidx.annotation.ArrayRes;
import androidx.annotation.PluralsRes;
import androidx.annotation.StringRes;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import com.salesforce.marketingcloud.analytics.stats.b;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Locale;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class StringResources_androidKt {
    private static int artificialFrame = 1;
    private static byte extraCallback = -124;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME;

    private static void a(String str, Object[] objArr) {
        byte[] bArrDecode = Base64.decode(str, 0);
        byte[] bArr = new byte[bArrDecode.length];
        for (int i = 0; i < bArrDecode.length; i++) {
            bArr[i] = (byte) (bArrDecode[(bArrDecode.length - i) - 1] ^ extraCallback);
        }
        objArr[0] = new String(bArr, StandardCharsets.UTF_8);
    }

    public static final String stringResource(@StringRes int i, @Nullable Composer composer, int i2) {
        int i3 = 2 % 2;
        int i4 = getARTIFICIAL_FRAME_PACKAGE_NAME + b.i;
        artificialFrame = i4 % 128;
        Object obj = null;
        if (i4 % 2 == 0) {
            ComposerKt.isTraceInProgress();
            throw null;
        }
        if (ComposerKt.isTraceInProgress()) {
            int i5 = getARTIFICIAL_FRAME_PACKAGE_NAME + 11;
            artificialFrame = i5 % 128;
            if (i5 % 2 == 0) {
                ComposerKt.traceEventStart(1223887937, i2, -1, "androidx.compose.ui.res.stringResource (StringResources.android.kt:32)");
                obj.hashCode();
                throw null;
            }
            ComposerKt.traceEventStart(1223887937, i2, -1, "androidx.compose.ui.res.stringResource (StringResources.android.kt:32)");
        }
        String string = Resources_androidKt.resources(composer, 0).getString(i);
        if (string.startsWith(".,.%")) {
            Object[] objArr = new Object[1];
            a(string.substring(4), objArr);
            string = ((String) objArr[0]).intern();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return string;
    }

    public static final String stringResource(@StringRes int i, @NotNull Object[] objArr, @Nullable Composer composer, int i2) {
        Locale locale;
        int i3 = 2 % 2;
        int i4 = getARTIFICIAL_FRAME_PACKAGE_NAME + 123;
        artificialFrame = i4 % 128;
        if (i4 % 2 != 0) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2071230100, i2, -1, "androidx.compose.ui.res.stringResource (StringResources.android.kt:46)");
            }
            Resources resources = Resources_androidKt.resources(composer, 0);
            Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
            Configuration configuration = resources.getConfiguration();
            if (Build.VERSION.SDK_INT >= 24) {
                int i5 = artificialFrame + 19;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i5 % 128;
                int i6 = i5 % 2;
                locale = configuration.getLocales().get(0);
            } else {
                locale = configuration.locale;
            }
            String string = resources.getString(i);
            if (!(!string.startsWith(".,.%"))) {
                int i7 = artificialFrame + 47;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i7 % 128;
                int i8 = i7 % 2;
                Object[] objArr2 = new Object[1];
                a(string.substring(4), objArr2);
                string = ((String) objArr2[0]).intern();
            }
            String str = String.format(locale, string, objArrCopyOf);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                int i9 = artificialFrame + 5;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i9 % 128;
                int i10 = i9 % 2;
            }
            return str;
        }
        ComposerKt.isTraceInProgress();
        throw null;
    }

    public static final String[] stringArrayResource(@ArrayRes int i, @Nullable Composer composer, int i2) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1562162650, i2, -1, "androidx.compose.ui.res.stringArrayResource (StringResources.android.kt:59)");
        }
        String[] stringArray = Resources_androidKt.resources(composer, 0).getStringArray(i);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return stringArray;
    }

    public static final String pluralStringResource(@PluralsRes int i, int i2, @Nullable Composer composer, int i3) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1784741530, i3, -1, "androidx.compose.ui.res.pluralStringResource (StringResources.android.kt:73)");
        }
        String quantityString = Resources_androidKt.resources(composer, 0).getQuantityString(i, i2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return quantityString;
    }

    public static final String pluralStringResource(@PluralsRes int i, int i2, @NotNull Object[] objArr, @Nullable Composer composer, int i3) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(523207213, i3, -1, "androidx.compose.ui.res.pluralStringResource (StringResources.android.kt:88)");
        }
        String quantityString = Resources_androidKt.resources(composer, 0).getQuantityString(i, i2, Arrays.copyOf(objArr, objArr.length));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return quantityString;
    }
}
