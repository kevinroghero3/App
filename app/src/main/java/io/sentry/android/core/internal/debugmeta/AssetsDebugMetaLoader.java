package io.sentry.android.core.internal.debugmeta;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import io.sentry.ILogger;
import io.sentry.SentryLevel;
import io.sentry.android.core.ContextUtils;
import io.sentry.internal.debugmeta.IDebugMetaLoader;
import io.sentry.util.DebugMetaPropertiesApplier;
import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import o.ArtificialStackFrames;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public final class AssetsDebugMetaLoader implements IDebugMetaLoader {
    private static int artificialFrame = 1;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME;
    private final Context context;
    private final ILogger logger;

    public AssetsDebugMetaLoader(@NotNull Context context, @NotNull ILogger iLogger) {
        this.context = ContextUtils.getApplicationContext(context);
        this.logger = iLogger;
    }

    @Override // io.sentry.internal.debugmeta.IDebugMetaLoader
    public List<Properties> loadDebugMeta() throws Throwable {
        int i = 2 % 2;
        try {
            try {
                Object[] objArr = {this.context.getAssets(), DebugMetaPropertiesApplier.DEBUG_META_PROPERTIES_FILENAME};
                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-982065286);
                if (objAccessartificialFrame == null) {
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(TextUtils.getTrimmedLength("") + 12, (char) (7116 - (ViewConfiguration.getScrollBarFadeDuration() >> 16)), 37 - (KeyEvent.getMaxKeyCode() >> 16), 1511233906, false, "accessartificialFrame", new Class[]{AssetManager.class, String.class});
                }
                BufferedInputStream bufferedInputStream = new BufferedInputStream((InputStream) ((Method) objAccessartificialFrame).invoke(null, objArr));
                try {
                    Properties properties = new Properties();
                    properties.load(bufferedInputStream);
                    List<Properties> listSingletonList = Collections.singletonList(properties);
                    bufferedInputStream.close();
                    return listSingletonList;
                } catch (Throwable th) {
                    try {
                        bufferedInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                Throwable cause = th3.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th3;
            }
        } catch (FileNotFoundException unused) {
            this.logger.log(SentryLevel.INFO, "%s file was not found.", DebugMetaPropertiesApplier.DEBUG_META_PROPERTIES_FILENAME);
            return null;
        } catch (IOException e) {
            this.logger.log(SentryLevel.ERROR, "Error getting Proguard UUIDs.", e);
            return null;
        } catch (RuntimeException e2) {
            this.logger.log(SentryLevel.ERROR, e2, "%s file is malformed.", DebugMetaPropertiesApplier.DEBUG_META_PROPERTIES_FILENAME);
            int i2 = artificialFrame + 73;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i2 % 128;
            int i3 = i2 % 2;
            return null;
        }
    }
}
