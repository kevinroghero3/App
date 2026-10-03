package androidx.webkit.internal;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewConfiguration;
import com.google.firebase.sessions.settings.RemoteSettings;
import io.sentry.instrumentation.file.SentryFileInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.zip.GZIPInputStream;
import o.ArtificialStackFrames;

/* JADX INFO: loaded from: classes4.dex */
public class AssetHelper {
    public static final String DEFAULT_MIME_TYPE = "text/plain";
    private static int artificialFrame = 1;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME;
    private final Context mContext;

    public AssetHelper(Context context) {
        this.mContext = context;
    }

    private static InputStream handleSvgzStream(String str, InputStream inputStream) throws IOException {
        return str.endsWith(".svgz") ? new GZIPInputStream(inputStream) : inputStream;
    }

    private static String removeLeadingSlash(String str) {
        return (str.length() <= 1 || str.charAt(0) != '/') ? str : str.substring(1);
    }

    private int getFieldId(String str, String str2) {
        return this.mContext.getResources().getIdentifier(str2, str, this.mContext.getPackageName());
    }

    private int getValueType(int i) {
        TypedValue typedValue = new TypedValue();
        this.mContext.getResources().getValue(i, typedValue, true);
        return typedValue.type;
    }

    public InputStream openResource(String str) throws Resources.NotFoundException, IOException {
        String strRemoveLeadingSlash = removeLeadingSlash(str);
        String[] strArrSplit = strRemoveLeadingSlash.split(RemoteSettings.FORWARD_SLASH_STRING, -1);
        if (strArrSplit.length != 2) {
            throw new IllegalArgumentException("Incorrect resource path: " + strRemoveLeadingSlash);
        }
        String str2 = strArrSplit[0];
        String strSubstring = strArrSplit[1];
        int iLastIndexOf = strSubstring.lastIndexOf(46);
        if (iLastIndexOf != -1) {
            strSubstring = strSubstring.substring(0, iLastIndexOf);
        }
        int fieldId = getFieldId(str2, strSubstring);
        int valueType = getValueType(fieldId);
        if (valueType != 3) {
            throw new IOException(String.format("Expected %s resource to be of TYPE_STRING but was %d", strRemoveLeadingSlash, Integer.valueOf(valueType)));
        }
        return handleSvgzStream(strRemoveLeadingSlash, this.mContext.getResources().openRawResource(fieldId));
    }

    public InputStream openAsset(String str) throws Throwable {
        String strRemoveLeadingSlash;
        InputStream inputStream;
        int i = 2 % 2;
        int i2 = artificialFrame + 1;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i2 % 128;
        if (i2 % 2 != 0) {
            strRemoveLeadingSlash = removeLeadingSlash(str);
            try {
                Object[] objArr = {this.mContext.getAssets(), strRemoveLeadingSlash};
                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-982065286);
                if (objAccessartificialFrame == null) {
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 12, (char) (View.getDefaultSize(0, 0) + 7116), (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 37, 1511233906, false, "accessartificialFrame", new Class[]{AssetManager.class, String.class});
                }
                inputStream = (InputStream) ((Method) objAccessartificialFrame).invoke(null, objArr);
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        } else {
            strRemoveLeadingSlash = removeLeadingSlash(str);
            try {
                Object[] objArr2 = {this.mContext.getAssets(), strRemoveLeadingSlash};
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-982065286);
                if (objAccessartificialFrame2 == null) {
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getWindowTouchSlop() >> 8) + 12, (char) (Color.blue(0) + 7116), TextUtils.lastIndexOf("", '0') + 38, 1511233906, false, "accessartificialFrame", new Class[]{AssetManager.class, String.class});
                }
                inputStream = (InputStream) ((Method) objAccessartificialFrame2).invoke(null, objArr2);
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 != null) {
                    throw cause2;
                }
                throw th2;
            }
        }
        return handleSvgzStream(strRemoveLeadingSlash, inputStream);
    }

    public static InputStream openFile(File file) throws IOException {
        return handleSvgzStream(file.getPath(), SentryFileInputStream.Factory.create(new FileInputStream(file), file));
    }

    public static File getCanonicalFileIfChild(File file, String str) throws IOException {
        String canonicalDirPath = getCanonicalDirPath(file);
        String canonicalPath = new File(file, str).getCanonicalPath();
        if (canonicalPath.startsWith(canonicalDirPath)) {
            return new File(canonicalPath);
        }
        return null;
    }

    public static String getCanonicalDirPath(File file) throws IOException {
        String canonicalPath = file.getCanonicalPath();
        if (canonicalPath.endsWith(RemoteSettings.FORWARD_SLASH_STRING)) {
            return canonicalPath;
        }
        return canonicalPath + RemoteSettings.FORWARD_SLASH_STRING;
    }

    public static File getDataDir(Context context) {
        return ApiHelperForN.getDataDir(context);
    }

    public static String guessMimeType(String str) {
        String mimeFromFileName = MimeUtil.getMimeFromFileName(str);
        return mimeFromFileName == null ? DEFAULT_MIME_TYPE : mimeFromFileName;
    }
}
