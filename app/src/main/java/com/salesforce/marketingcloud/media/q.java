package com.salesforce.marketingcloud.media;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.net.Uri;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import ch.qos.logback.core.net.SyslogConstants;
import com.facebook.imageutils.JfifUtil;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.google.firebase.sessions.settings.RemoteSettings;
import io.sentry.android.core.ActivityFramesTracker$$ExternalSyntheticLambda1;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsKt;
import o.ArtificialStackFrames;
import o.extraCallback;
import o.onMessageChannelReady;
import okhttp3.internal.ws.WebSocketProtocol;
import org.apache.commons.lang3.CharUtils;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class q {
    public static final q a = new q();
    private static final String b = com.salesforce.marketingcloud.g.a("MediaProvider");

    static final class b extends Lambda implements Function0<String> {
        final /* synthetic */ int b;
        final /* synthetic */ int c;
        final /* synthetic */ float d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(int i, int i2, float f) {
            super(0);
            this.b = i;
            this.c = i2;
            this.d = f;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return "scaleBitmapToFit Width target dimension targetWidth:" + this.b + " targetHeight:" + this.c + " for aspectRatio " + this.d;
        }
    }

    static final class c extends Lambda implements Function0<String> {
        final /* synthetic */ int b;
        final /* synthetic */ int c;
        final /* synthetic */ float d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(int i, int i2, float f) {
            super(0);
            this.b = i;
            this.c = i2;
            this.d = f;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return "scaleBitmapToFit Height target dimension targetWidth:" + this.b + " targetHeight:" + this.c + " for aspectRatio " + this.d;
        }
    }

    private q() {
    }

    private final String b(String str) {
        if (str == null || StringsKt__StringsKt.lastIndexOf$default((CharSequence) str, '.', 0, false, 6, (Object) null) <= 0) {
            Intrinsics.checkNotNull(str);
            return str;
        }
        String strSubstring = str.substring(0, StringsKt__StringsKt.lastIndexOf$default((CharSequence) str, '.', 0, false, 6, (Object) null));
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    public final Uri a(@NotNull Context context, @NotNull String name, @NotNull Uri defaultSoundUri) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(defaultSoundUri, "defaultSoundUri");
        int identifier = context.getResources().getIdentifier(b(name), "raw", context.getPackageName());
        if (identifier <= 0) {
            return defaultSoundUri;
        }
        Uri uri = Uri.parse("android.resource://" + context.getPackageName() + RemoteSettings.FORWARD_SLASH_STRING + identifier);
        Intrinsics.checkNotNullExpressionValue(uri, "parse(...)");
        return uri;
    }

    public final int a(@NotNull Context context, @NotNull String iconName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(iconName, "iconName");
        int identifier = context.getResources().getIdentifier(b(iconName), "drawable", context.getPackageName());
        return identifier > 0 ? identifier : context.getApplicationInfo().icon;
    }

    public final Bitmap a(@NotNull Bitmap bitmap, int i, int i2) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        com.salesforce.marketingcloud.g gVar = com.salesforce.marketingcloud.g.a;
        String str = b;
        com.salesforce.marketingcloud.g.a(gVar, str, null, new a(bitmap), 2, null);
        float width = bitmap.getWidth() / bitmap.getHeight();
        int i3 = (int) (i * width);
        if (i3 > i2) {
            int i4 = (int) (i2 / width);
            com.salesforce.marketingcloud.g.a(gVar, str, null, new b(i2, i4, width), 2, null);
            Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, i2, i4, true);
            Intrinsics.checkNotNull(bitmapCreateScaledBitmap);
            return bitmapCreateScaledBitmap;
        }
        com.salesforce.marketingcloud.g.a(gVar, str, null, new c(i3, i, width), 2, null);
        Bitmap bitmapCreateScaledBitmap2 = Bitmap.createScaledBitmap(bitmap, i3, i, true);
        Intrinsics.checkNotNull(bitmapCreateScaledBitmap2);
        return bitmapCreateScaledBitmap2;
    }

    public final Bitmap a(@NotNull String src) throws com.salesforce.marketingcloud.push.a {
        Intrinsics.checkNotNullParameter(src, "src");
        try {
            URLConnection uRLConnection = (URLConnection) FirebasePerfUrlConnection.instrument(new URL(src).openConnection());
            Intrinsics.checkNotNull(uRLConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
            HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnection;
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setDoInput(true);
            int i = 8000;
            httpURLConnection.setReadTimeout(com.salesforce.marketingcloud.util.j.d() ? 8000 : 20000);
            if (!com.salesforce.marketingcloud.util.j.d()) {
                i = 20000;
            }
            httpURLConnection.setConnectTimeout(i);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();
            BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int i2 = bufferedInputStream.read(bArr);
                if (i2 != -1) {
                    byteArrayOutputStream.write(bArr, 0, i2);
                } else {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
                    Intrinsics.checkNotNullExpressionValue(bitmapDecodeByteArray, "decodeByteArray(...)");
                    return bitmapDecodeByteArray;
                }
            }
        } catch (Exception e) {
            Log.e(b, "Unable to download image " + src, e);
            throw new com.salesforce.marketingcloud.push.a(src);
        }
    }

    public static final class a extends Lambda implements Function0<String> {
        final /* synthetic */ Bitmap b;
        private static final byte[] $$a = {109, -105, -81, -102};
        private static final int $$b = 71;
        private static int $10 = 0;
        private static int $11 = 1;
        private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
        private static int artificialFrame = 1;
        private static char[] validateRelationship = {56164, 56173, 56144, 56150, 56088, 56147, 56161, 56163, 56145, 56156, 56165, 56146, 56149, 56166, 56081, 56094, 56182, 56190, 56152, 56158, 56154, 56162, 56159, 56067, 56167, 56155, 56184, 56153, 56069, 56160, 56085, 56064, 56179, 56172};
        private static int warmup = -1044259890;
        private static boolean requestPostMessageChannelWithExtras = true;
        private static boolean ICustomTabsServiceDefault = true;
        private static char[] ArtificialStackFrames = {39064, 39067, 44366, 39070, 44353, 44393, 44349, 44400, 44386, 44398, 44395, 39065, 44409, 44334, 44391, 44399, 44387, 44397, 44371, 44320, 44354, 44355, 44356, 39071, 44365, 44402, 44373, 44385, 44405, 44367, 44388, 44368, 44403, 44389, 44404, 44332};
        private static char coroutineCreation = 39068;

        private static String $$c(int i, short s, int i2) {
            int i3 = i + 66;
            int i4 = i2 * 4;
            byte[] bArr = $$a;
            int i5 = 4 - (s * 2);
            byte[] bArr2 = new byte[1 - i4];
            int i6 = 0 - i4;
            int i7 = -1;
            if (bArr == null) {
                i3 = (-i3) + i6;
                i5++;
                i7 = -1;
            }
            while (true) {
                int i8 = i7 + 1;
                bArr2[i8] = (byte) i3;
                if (i8 == i6) {
                    return new String(bArr2, 0);
                }
                i3 = (-bArr[i5]) + i3;
                i5++;
                i7 = i8;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Bitmap bitmap) {
            super(0);
            this.b = bitmap;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return "scaleBitmapToFit default bitmap W:" + this.b.getWidth() + "  H:" + this.b.getHeight();
        }

        private static void c(int i, byte[] bArr, char[] cArr, int[] iArr, Object[] objArr) throws Throwable {
            int i2;
            int i3;
            char[] cArr2;
            int length;
            char[] cArr3;
            int i4;
            int i5 = 2 % 2;
            onMessageChannelReady onmessagechannelready = new onMessageChannelReady();
            char[] cArr4 = validateRelationship;
            int i6 = 1;
            int i7 = 0;
            if (cArr4 != null) {
                int i8 = $10 + 35;
                $11 = i8 % 128;
                if (i8 % 2 == 0) {
                    length = cArr4.length;
                    cArr3 = new char[length];
                    i4 = 1;
                } else {
                    length = cArr4.length;
                    cArr3 = new char[length];
                    i4 = 0;
                }
                while (i4 < length) {
                    try {
                        Object[] objArr2 = new Object[i6];
                        objArr2[i7] = Integer.valueOf(cArr4[i4]);
                        Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(115862995);
                        if (objAccessartificialFrame == null) {
                            byte b = (byte) i7;
                            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(25 - Process.getGidForName(""), (char) (ViewConfiguration.getWindowTouchSlop() >> 8), 1041 - (ViewConfiguration.getWindowTouchSlop() >> 8), -1719489573, false, $$c((byte) 55, b, b), new Class[]{Integer.TYPE});
                        }
                        cArr3[i4] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                        i4++;
                        i6 = 1;
                        i7 = 0;
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause == null) {
                            throw th;
                        }
                        throw cause;
                    }
                }
                cArr4 = cArr3;
            }
            try {
                Object[] objArr3 = {Integer.valueOf(warmup)};
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1820173622);
                if (objAccessartificialFrame2 == null) {
                    int iLastIndexOf = TextUtils.lastIndexOf("", '0', 0) + 16;
                    char cKeyCodeFromString = (char) (KeyEvent.keyCodeFromString("") + 20488);
                    int i9 = 2148 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                    byte b2 = (byte) ($$b & 1);
                    byte b3 = (byte) (b2 - 1);
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(iLastIndexOf, cKeyCodeFromString, i9, 216472770, false, $$c(b2, b3, b3), new Class[]{Integer.TYPE});
                }
                int iIntValue = ((Integer) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).intValue();
                int i10 = -2083387879;
                if (ICustomTabsServiceDefault) {
                    int i11 = $10 + 69;
                    $11 = i11 % 128;
                    if (i11 % 2 == 0) {
                        onmessagechannelready.c = bArr.length;
                        cArr2 = new char[onmessagechannelready.c];
                        i3 = 0;
                    } else {
                        i3 = 0;
                        onmessagechannelready.c = bArr.length;
                        cArr2 = new char[onmessagechannelready.c];
                    }
                    onmessagechannelready.a = i3;
                    while (onmessagechannelready.a < onmessagechannelready.c) {
                        int i12 = $11 + 69;
                        $10 = i12 % 128;
                        int i13 = i12 % 2;
                        cArr2[onmessagechannelready.a] = (char) (cArr4[bArr[(onmessagechannelready.c - 1) - onmessagechannelready.a] + i] - iIntValue);
                        Object[] objArr4 = {onmessagechannelready, onmessagechannelready};
                        Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(i10);
                        if (objAccessartificialFrame3 == null) {
                            byte b4 = (byte) 0;
                            byte b5 = b4;
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 21, (char) (59174 - TextUtils.getCapsMode("", 0, 0)), (ViewConfiguration.getScrollBarSize() >> 8) + 1943, 481771537, false, $$c(b4, b5, b5), new Class[]{Object.class, Object.class});
                        }
                        ((Method) objAccessartificialFrame3).invoke(null, objArr4);
                        i10 = -2083387879;
                    }
                    objArr[0] = new String(cArr2);
                    return;
                }
                if (!requestPostMessageChannelWithExtras) {
                    onmessagechannelready.c = iArr.length;
                    char[] cArr5 = new char[onmessagechannelready.c];
                    onmessagechannelready.a = 0;
                    int i14 = $11 + 53;
                    $10 = i14 % 128;
                    int i15 = i14 % 2;
                    while (onmessagechannelready.a < onmessagechannelready.c) {
                        int i16 = $11 + 93;
                        $10 = i16 % 128;
                        if (i16 % 2 != 0) {
                            cArr5[onmessagechannelready.a] = (char) (cArr4[iArr[(onmessagechannelready.c >> 1) % onmessagechannelready.a] >>> i] * iIntValue);
                            int i17 = onmessagechannelready.a;
                            i2 = 0;
                        } else {
                            cArr5[onmessagechannelready.a] = (char) (cArr4[iArr[(onmessagechannelready.c - 1) - onmessagechannelready.a] - i] - iIntValue);
                            i2 = onmessagechannelready.a + 1;
                        }
                        onmessagechannelready.a = i2;
                    }
                    objArr[0] = new String(cArr5);
                    return;
                }
                onmessagechannelready.c = cArr.length;
                char[] cArr6 = new char[onmessagechannelready.c];
                onmessagechannelready.a = 0;
                while (onmessagechannelready.a < onmessagechannelready.c) {
                    int i18 = $11 + 99;
                    $10 = i18 % 128;
                    if (i18 % 2 != 0) {
                        cArr6[onmessagechannelready.a] = (char) (cArr4[cArr[onmessagechannelready.c << onmessagechannelready.a] / i] - iIntValue);
                        Object[] objArr5 = {onmessagechannelready, onmessagechannelready};
                        Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-2083387879);
                        if (objAccessartificialFrame4 == null) {
                            byte b6 = (byte) 0;
                            byte b7 = b6;
                            objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(20 - TextUtils.lastIndexOf("", '0'), (char) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 59173), KeyEvent.keyCodeFromString("") + 1943, 481771537, false, $$c(b6, b7, b7), new Class[]{Object.class, Object.class});
                        }
                        ((Method) objAccessartificialFrame4).invoke(null, objArr5);
                    } else {
                        cArr6[onmessagechannelready.a] = (char) (cArr4[cArr[(onmessagechannelready.c - 1) - onmessagechannelready.a] - i] - iIntValue);
                        Object[] objArr6 = {onmessagechannelready, onmessagechannelready};
                        Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-2083387879);
                        if (objAccessartificialFrame5 == null) {
                            byte b8 = (byte) 0;
                            byte b9 = b8;
                            objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 20, (char) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 59173), 1943 - KeyEvent.getDeadChar(0, 0), 481771537, false, $$c(b8, b9, b9), new Class[]{Object.class, Object.class});
                        }
                        ((Method) objAccessartificialFrame5).invoke(null, objArr6);
                    }
                }
                String str = new String(cArr6);
                int i19 = $10 + 19;
                $11 = i19 % 128;
                int i20 = i19 % 2;
                objArr[0] = str;
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 == null) {
                    throw th2;
                }
                throw cause2;
            }
        }

        private static void d(byte b, int i, char[] cArr, Object[] objArr) throws Throwable {
            int i2;
            Object obj;
            int i3 = 2 % 2;
            extraCallback extracallback = new extraCallback();
            char[] cArr2 = ArtificialStackFrames;
            int i4 = 31;
            int i5 = -1819279892;
            long j = 0;
            Object obj2 = null;
            if (cArr2 != null) {
                int i6 = $11;
                int i7 = i6 + 47;
                $10 = i7 % 128;
                int i8 = i7 % 2;
                int length = cArr2.length;
                char[] cArr3 = new char[length];
                int i9 = i6 + 119;
                $10 = i9 % 128;
                int i10 = i9 % 2;
                int i11 = 0;
                while (i11 < length) {
                    try {
                        Object[] objArr2 = {Integer.valueOf(cArr2[i11])};
                        Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(i5);
                        if (objAccessartificialFrame == null) {
                            byte b2 = (byte) i4;
                            byte b3 = (byte) 0;
                            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation((Process.getElapsedCpuTime() > j ? 1 : (Process.getElapsedCpuTime() == j ? 0 : -1)) + 14, (char) (TextUtils.indexOf("", "", 0, 0) + 20488), 2147 - MotionEvent.axisFromString(""), 216710116, false, $$c(b2, b3, b3), new Class[]{Integer.TYPE});
                        }
                        cArr3[i11] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                        i11++;
                        i4 = 31;
                        i5 = -1819279892;
                        j = 0;
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause == null) {
                            throw th;
                        }
                        throw cause;
                    }
                }
                cArr2 = cArr3;
            }
            Object[] objArr3 = {Integer.valueOf(coroutineCreation)};
            Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1819279892);
            float f = 0.0f;
            if (objAccessartificialFrame2 == null) {
                byte b4 = (byte) 0;
                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 15, (char) (20489 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))), 2149 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), 216710116, false, $$c((byte) 31, b4, b4), new Class[]{Integer.TYPE});
            }
            char cCharValue = ((Character) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).charValue();
            char[] cArr4 = new char[i];
            if (i % 2 != 0) {
                int i12 = $10 + 51;
                $11 = i12 % 128;
                if (i12 % 2 == 0) {
                    i2 = i + WebSocketProtocol.PAYLOAD_SHORT;
                    cArr4[i2] = (char) (cArr[i2] + b);
                } else {
                    i2 = i - 1;
                    cArr4[i2] = (char) (cArr[i2] - b);
                }
            } else {
                i2 = i;
            }
            if (i2 > 1) {
                extracallback.a = 0;
                while (extracallback.a < i2) {
                    int i13 = $10 + 123;
                    $11 = i13 % 128;
                    int i14 = i13 % 2;
                    extracallback.createBrowser = cArr[extracallback.a];
                    extracallback.c = cArr[extracallback.a + 1];
                    if (extracallback.createBrowser == extracallback.c) {
                        int i15 = $11 + 23;
                        $10 = i15 % 128;
                        if (i15 % 2 != 0) {
                            cArr4[extracallback.a] = (char) (extracallback.createBrowser << b);
                            cArr4[extracallback.a] = (char) (extracallback.c >> b);
                        } else {
                            cArr4[extracallback.a] = (char) (extracallback.createBrowser - b);
                            cArr4[extracallback.a + 1] = (char) (extracallback.c - b);
                        }
                        obj = obj2;
                    } else {
                        Object[] objArr4 = {extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), extracallback};
                        Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1894223152);
                        if (objAccessartificialFrame3 == null) {
                            byte b5 = (byte) 0;
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(46 - View.resolveSize(0, 0), (char) ((PointF.length(f, f) > f ? 1 : (PointF.length(f, f) == f ? 0 : -1)) + 58859), 2464 - (ViewConfiguration.getPressedStateDuration() >> 16), 276640984, false, $$c((byte) 36, b5, b5), new Class[]{Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class});
                        }
                        if (((Integer) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).intValue() == extracallback.g) {
                            try {
                                Object[] objArr5 = {extracallback, extracallback, Integer.valueOf(cCharValue), Integer.valueOf(cCharValue), extracallback, extracallback, Integer.valueOf(cCharValue), Integer.valueOf(cCharValue), extracallback, Integer.valueOf(cCharValue), extracallback};
                                Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1361113423);
                                if (objAccessartificialFrame4 == null) {
                                    byte b6 = (byte) 0;
                                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(Color.blue(0) + 24, (char) (Process.myPid() >> 22), 792 - ExpandableListView.getPackedPositionType(0L), -834291897, false, $$c((byte) 39, b6, b6), new Class[]{Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Integer.TYPE, Object.class});
                                }
                                obj = null;
                                int iIntValue = ((Integer) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).intValue();
                                int i16 = (extracallback.d * cCharValue) + extracallback.g;
                                cArr4[extracallback.a] = cArr2[iIntValue];
                                cArr4[extracallback.a + 1] = cArr2[i16];
                            } catch (Throwable th2) {
                                Throwable cause2 = th2.getCause();
                                if (cause2 == null) {
                                    throw th2;
                                }
                                throw cause2;
                            }
                        } else {
                            obj = null;
                            if (extracallback.b == extracallback.d) {
                                extracallback.j = ((extracallback.j + cCharValue) - 1) % cCharValue;
                                extracallback.g = ((extracallback.g + cCharValue) - 1) % cCharValue;
                                int i17 = (extracallback.b * cCharValue) + extracallback.j;
                                int i18 = (extracallback.d * cCharValue) + extracallback.g;
                                cArr4[extracallback.a] = cArr2[i17];
                                cArr4[extracallback.a + 1] = cArr2[i18];
                            } else {
                                int i19 = (extracallback.b * cCharValue) + extracallback.g;
                                int i20 = (extracallback.d * cCharValue) + extracallback.j;
                                cArr4[extracallback.a] = cArr2[i19];
                                cArr4[extracallback.a + 1] = cArr2[i20];
                            }
                        }
                    }
                    extracallback.a += 2;
                    obj2 = obj;
                    f = 0.0f;
                }
            }
            for (int i21 = 0; i21 < i; i21++) {
                cArr4[i21] = (char) (cArr4[i21] ^ 13722);
            }
            objArr[0] = new String(cArr4);
        }

        public static Object[] coroutineBoundary(Context context, int i, int i2) {
            int iMyPid;
            int i3;
            int i4;
            int i5;
            int i6;
            int i7;
            int doubleTapTimeout;
            int i8;
            String str;
            Object obj;
            int iArgb;
            int i9;
            int i10 = 2;
            int i11 = 2 % 2;
            int i12 = getARTIFICIAL_FRAME_PACKAGE_NAME;
            int i13 = (i12 & 33) + (i12 | 33);
            artificialFrame = i13 % 128;
            if (i13 % 2 == 0) {
                throw null;
            }
            if (context == null) {
                Object[] objArr = {new int[]{i}, new int[]{i}, new int[1], null};
                int i14 = i12 + 51;
                artificialFrame = i14 % 128;
                int i15 = i14 % 2;
                int i16 = ~((int) SystemClock.elapsedRealtime());
                int i17 = (-1328408130) + (((~(i16 | 179938723)) | (-800847868)) * (-160)) + (((~(i16 | (-798685052))) | 179938723) * SyslogConstants.LOG_LOCAL4);
                int i18 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                int i19 = ((i18 | 21) << 1) - (i18 ^ 21);
                artificialFrame = i19 % 128;
                int i20 = i19 % 2 == 0 ? (371 % i17) << (371 << i2) : (i17 * 371) + (i2 * 371);
                int i21 = ~i2;
                int i22 = ~i;
                int i23 = ~((i21 & i22) | (i21 ^ i22));
                int i24 = ~i17;
                int i25 = ~((i24 & i) | (i24 ^ i));
                int i26 = i20 + ((-370) * ((i23 & i25) | (i23 ^ i25)));
                int i27 = ~i17;
                int i28 = ~i;
                int i29 = ~((i27 & i28) | (i27 ^ i28));
                int i30 = ~i2;
                int i31 = (i & i30) | (i30 ^ i);
                int i32 = ((i18 | 61) << 1) - (i18 ^ 61);
                artificialFrame = i32 % 128;
                int i33 = i32 % 2;
                int i34 = ~i31;
                int i35 = (i34 & i29) | (i29 ^ i34);
                int i36 = (i2 & i17) | (i17 ^ i2);
                int i37 = ~i36;
                int i38 = -(-((-370) * ((i35 & i37) | (i35 ^ i37))));
                int i39 = (i26 ^ i38) + ((i38 & i26) << 1);
                int i40 = -(-((~i36) * 370));
                int i41 = (i39 ^ i40) + ((i40 & i39) << 1);
                int i42 = i41 << 13;
                int i43 = (i42 | i41) & (~(i41 & i42));
                int i44 = i43 >>> 17;
                int i45 = ((~i43) & i44) | ((~i44) & i43);
                ((int[]) objArr[2])[0] = i45 ^ (i45 << 5);
                return objArr;
            }
            try {
                int i46 = -ExpandableListView.getPackedPositionGroup(0L);
                Object[] objArr2 = new Object[1];
                c(((i46 | 127) << 1) - (i46 ^ 127), new byte[]{-107, -126, -108, -117, -120, -109, -117, -118, -110, -112, -112, -113, -111, -123, -112, -112, -113, -124, -123, -114, -116, -119, -126, -123, -115, -116, -117, -118, -119, -120, -121, -122, -123, -124, -126, -125, -126, -127}, null, null, objArr2);
                Object[] objArr3 = (Object[]) Array.newInstance(Class.forName((String) objArr2[0]), 2);
                int packedPositionChild = ExpandableListView.getPackedPositionChild(0L);
                int iL = ActivityFramesTracker$$ExternalSyntheticLambda1.l();
                int i47 = ~packedPositionChild;
                int i48 = ((packedPositionChild * (-755)) - 55870) + ((~((i47 & (-75)) | (i47 ^ (-75)))) * 1512);
                int i49 = ~packedPositionChild;
                int i50 = ~((i49 & (-75)) | (i49 ^ (-75)));
                int i51 = (packedPositionChild & 74) | (packedPositionChild ^ 74);
                int i52 = ~((i51 ^ iL) | (i51 & iL));
                int i53 = i48 + (((i50 & i52) | (i50 ^ i52)) * (-756));
                int i54 = ~iL;
                int i55 = ((i51 & i54) | (i51 ^ i54)) * 756;
                int i56 = -(ViewConfiguration.getScrollBarFadeDuration() >> 16);
                int i57 = i56 * 367;
                int i58 = (i57 & 11377) + (i57 | 11377) + (((i56 ^ 31) | (i56 & 31)) * (-366));
                int i59 = ~((-32) | i);
                int i60 = (i58 - (~(-(-(((i59 & i56) | (i56 ^ i59)) * (-366)))))) - 1;
                int i61 = ~i56;
                int i62 = ~((i61 & 31) | (i61 ^ 31));
                int i63 = i56 | (-32);
                int i64 = ~((i63 & i) | (i63 ^ i));
                int i65 = -(-(((i64 & i62) | (i62 ^ i64)) * 366));
                Object[] objArr4 = new Object[1];
                d((byte) ((i53 ^ i55) + ((i55 & i53) << 1)), (i60 & i65) + (i65 | i60), new char[]{20, 3, '\n', 0, 6, '!', 27, CharUtils.CR, 0, '#', 20, 23, ' ', '\t', 26, 16, 5, '#', '\n', 0, 6, '!', 27, CharUtils.CR, 0, '#', '!', 23, '\b', 24, 13842}, objArr4);
                String str2 = (String) objArr4[0];
                int i66 = artificialFrame + 79;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i66 % 128;
                int i67 = i66 % 2;
                try {
                    int i68 = -Color.blue(0);
                    int i69 = (i68 * 319) - 40259;
                    int i70 = ~i68;
                    int i71 = ~((i70 & i) | (i70 ^ i));
                    int i72 = (((-128) ^ i71) | (i71 & (-128))) * (-318);
                    int i73 = (i69 & i72) + (i69 | i72);
                    int i74 = ((-128) ^ i) | ((-128) & i);
                    int i75 = ~i74;
                    int i76 = ~i;
                    int i77 = (i76 ^ i68) | (i76 & i68);
                    int i78 = ~((i77 ^ 127) | (i77 & 127));
                    int i79 = i73 + (((i75 ^ i78) | (i75 & i78)) * TypedValues.AttributesType.TYPE_PIVOT_TARGET);
                    int i80 = ~i;
                    int i81 = ((-128) ^ i80) | ((-128) & i80);
                    int i82 = ~((i81 ^ i68) | (i81 & i68));
                    int i83 = ~((i68 ^ 127) | (i68 & 127) | i);
                    int i84 = -(-(((i82 ^ i83) | (i83 & i82)) * TypedValues.AttributesType.TYPE_PIVOT_TARGET));
                    Object[] objArr5 = new Object[1];
                    c((i79 ^ i84) + ((i79 & i84) << 1), new byte[]{-107, -126, -108, -117, -120, -109, -117, -118, -110, -112, -112, -113, -111, -123, -112, -112, -113, -124, -123, -114, -116, -119, -126, -123, -115, -116, -117, -118, -119, -120, -121, -122, -123, -124, -126, -125, -126, -127}, null, null, objArr5);
                    Object objNewInstance = Class.forName((String) objArr5[0]).getDeclaredConstructor(String.class).newInstance(str2);
                    int i85 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                    int i86 = (i85 & 105) + (i85 | 105);
                    artificialFrame = i86 % 128;
                    if (i86 % 2 == 0) {
                        objArr3[0] = objNewInstance;
                        int iMyPid2 = Process.myPid();
                        iMyPid = ((iMyPid2 | com.salesforce.marketingcloud.analytics.stats.b.i) << 1) - (iMyPid2 ^ com.salesforce.marketingcloud.analytics.stats.b.i);
                        i3 = (-523) << iMyPid;
                        i4 = 94;
                    } else {
                        objArr3[0] = objNewInstance;
                        iMyPid = Process.myPid() >> 22;
                        i3 = iMyPid * (-523);
                        i4 = 8;
                    }
                    int i87 = (i3 - (~(-(-(263 * i4))))) - 1;
                    int i88 = ~iMyPid;
                    int i89 = ~(i88 | i4);
                    int i90 = ~i4;
                    int i91 = ~((i90 ^ iMyPid) | (i90 & iMyPid));
                    int i92 = (i89 ^ i91) | (i89 & i91);
                    int i93 = ~((i90 ^ i) | (i90 & i));
                    int i94 = (i92 ^ i93) | (i92 & i93);
                    int i95 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                    int i96 = ((i95 | 39) << 1) - (i95 ^ 39);
                    artificialFrame = i96 % 128;
                    if (i96 % 2 == 0) {
                        int i97 = -(~((~i4) | iMyPid));
                        i5 = (i87 << (i94 + 262)) + (i97 ^ (-786)) + ((i97 & (-786)) << 1);
                        i6 = i90 ^ i80;
                        i7 = i90 & i80;
                    } else {
                        int i98 = i87 + (i94 * 262);
                        int i99 = ~i4;
                        i5 = ((~((i99 & iMyPid) | (i99 ^ iMyPid))) * (-786)) + i98;
                        i6 = i90 ^ i76;
                        i7 = i90 & i76;
                    }
                    int i100 = ~(i6 | i7);
                    int i101 = ~(i88 | i4);
                    int i102 = (i100 & i101) | (i100 ^ i101);
                    int i103 = ~(i90 | iMyPid);
                    int i104 = 262 * ((i102 & i103) | (i102 ^ i103));
                    Object[] objArr6 = new Object[1];
                    d((byte) ((i5 ^ i104) + ((i5 & i104) << 1)), 30 - (~(-(-(ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1))))), new char[]{18, '\t', 24, 20, 5, '#', '\n', 0, 6, '!', 27, CharUtils.CR, 0, '#', '!', 23, 0, '\b', 3, '\n', 31, 24, 17, 3, 31, 18, 21, '\"', '\n', 26, 13829}, objArr6);
                    String str3 = (String) objArr6[0];
                    int i105 = artificialFrame + 91;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i105 % 128;
                    int i106 = i105 % 2;
                    try {
                        Object[] objArr7 = {str3};
                        int i107 = -(CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1));
                        Object[] objArr8 = new Object[1];
                        c((i107 ^ 127) + ((i107 & 127) << 1), new byte[]{-107, -126, -108, -117, -120, -109, -117, -118, -110, -112, -112, -113, -111, -123, -112, -112, -113, -124, -123, -114, -116, -119, -126, -123, -115, -116, -117, -118, -119, -120, -121, -122, -123, -124, -126, -125, -126, -127}, null, null, objArr8);
                        Class<?> cls = Class.forName((String) objArr8[0]);
                        Class<?>[] clsArr = new Class[1];
                        int i108 = getARTIFICIAL_FRAME_PACKAGE_NAME + 107;
                        artificialFrame = i108 % 128;
                        int i109 = i108 % 2;
                        clsArr[0] = String.class;
                        objArr3[1] = cls.getDeclaredConstructor(clsArr).newInstance(objArr7);
                        try {
                            char mirror = AndroidCharacter.getMirror('0');
                            Object[] objArr9 = new Object[1];
                            c((mirror & 'O') + (mirror | 'O'), new byte[]{-116, -124, -121, -116, -109, -105, -104, -123, -116, -109, -121, -116, -109, -105, -120, -123, -106, -117, -105, -118, -106, -109, -126}, null, null, objArr9);
                            Class<?> cls2 = Class.forName((String) objArr9[0]);
                            int i110 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                            int i111 = (i110 & com.salesforce.marketingcloud.analytics.stats.b.f40o) + (i110 | com.salesforce.marketingcloud.analytics.stats.b.f40o);
                            artificialFrame = i111 % 128;
                            if (i111 % 2 == 0) {
                                int doubleTapTimeout2 = ViewConfiguration.getDoubleTapTimeout();
                                doubleTapTimeout = ((doubleTapTimeout2 | 82) << 1) - (doubleTapTimeout2 ^ 82);
                                i8 = 96;
                            } else {
                                doubleTapTimeout = ViewConfiguration.getDoubleTapTimeout() >> 16;
                                i8 = 77;
                            }
                            int i112 = doubleTapTimeout * 714;
                            int i113 = -(-(i8 * (-712)));
                            int i114 = (i112 ^ i113) + ((i112 & i113) << 1);
                            int i115 = ~doubleTapTimeout;
                            int i116 = ~((i115 & i76) | (i115 ^ i76));
                            int i117 = ~doubleTapTimeout;
                            int i118 = ~((i117 & i8) | (i117 ^ i8));
                            int i119 = (i116 & i118) | (i116 ^ i118);
                            int i120 = ~i8;
                            int i121 = ~((i120 & doubleTapTimeout) | (i120 ^ doubleTapTimeout) | i);
                            int i122 = i114 + (((i119 & i121) | (i119 ^ i121)) * (-713));
                            int i123 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                            int i124 = (i123 & 77) + (i123 | 77);
                            artificialFrame = i124 % 128;
                            int i125 = i124 % 2;
                            int i126 = i8 ^ (-1);
                            int i127 = (doubleTapTimeout & i126) | (i126 ^ doubleTapTimeout);
                            int i128 = -(-(1426 * (~((i127 & i) | (i127 ^ i)))));
                            int i129 = ~i8;
                            byte b = (byte) ((((i122 & i128) + (i128 | i122)) - (~(-(-((~((i129 & i80) | (i129 ^ i80))) * 713))))) - 1);
                            int i130 = -(ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
                            int i131 = (i130 & 18) + (i130 | 18);
                            char[] cArr = {15, ' ', '#', ' ', 28, 15, '\t', 28, 15, ' ', 25, 28, 15, '!', 15, ' ', 13877};
                            int i132 = getARTIFICIAL_FRAME_PACKAGE_NAME + 13;
                            artificialFrame = i132 % 128;
                            if (i132 % 2 == 0) {
                                Object[] objArr10 = new Object[1];
                                d(b, i131, cArr, objArr10);
                                Object obj2 = null;
                                cls2.getMethod((String) objArr10[0], null).invoke(context, null);
                                obj2.hashCode();
                                throw null;
                            }
                            Object[] objArr11 = new Object[1];
                            d(b, i131, cArr, objArr11);
                            Object objInvoke = cls2.getMethod((String) objArr11[0], null).invoke(context, null);
                            try {
                                int i133 = -(ViewConfiguration.getEdgeSlop() >> 16);
                                int i134 = artificialFrame;
                                int i135 = i134 + 117;
                                getARTIFICIAL_FRAME_PACKAGE_NAME = i135 % 128;
                                int i136 = i135 % 2;
                                int i137 = ((-128) ^ i133) | ((-128) & i133);
                                int i138 = ((i133 * 624) - 78994) + ((~(i137 | i)) * 623);
                                int i139 = ~i133;
                                int i140 = ~((i139 & 127) | (i139 ^ 127));
                                int i141 = ((i140 & i76) | (i76 ^ i140)) * (-623);
                                int i142 = (i138 & i141) + (i138 | i141);
                                int i143 = ~i137;
                                int i144 = ~i74;
                                int i145 = (i143 & i144) | (i143 ^ i144);
                                int i146 = i134 + 125;
                                getARTIFICIAL_FRAME_PACKAGE_NAME = i146 % 128;
                                if (i146 % 2 != 0) {
                                    int i147 = ~((i133 & i) | (i133 ^ i));
                                    int i148 = -(623 >> ((i147 & i145) | (i145 ^ i147)));
                                    Object[] objArr12 = new Object[1];
                                    c(((i142 | i148) << 1) - (i148 ^ i142), new byte[]{-116, -124, -121, -116, -109, -105, -104, -123, -116, -109, -121, -116, -109, -105, -120, -123, -106, -117, -105, -118, -106, -109, -126}, null, null, objArr12);
                                    str = (String) objArr12[0];
                                } else {
                                    int i149 = ~(i133 | i);
                                    int i150 = i145 ^ i149;
                                    Object[] objArr13 = new Object[1];
                                    c((i142 - (~(((i149 & i145) | i150) * 623))) - 1, new byte[]{-116, -124, -121, -116, -109, -105, -104, -123, -116, -109, -121, -116, -109, -105, -120, -123, -106, -117, -105, -118, -106, -109, -126}, null, null, objArr13);
                                    str = (String) objArr13[0];
                                }
                                Class<?> cls3 = Class.forName(str);
                                int i151 = artificialFrame;
                                int i152 = (i151 & 101) + (i151 | 101);
                                getARTIFICIAL_FRAME_PACKAGE_NAME = i152 % 128;
                                int i153 = i152 % 2;
                                int i154 = -(ViewConfiguration.getTouchSlop() >> 8);
                                Object[] objArr14 = new Object[1];
                                c((i154 ^ 127) + ((i154 & 127) << 1), new byte[]{-121, -100, -126, -101, -121, -103, -126, -102, -120, -126, -110, -116, -121, -103}, null, null, objArr14);
                                Object objInvoke2 = cls3.getMethod((String) objArr14[0], null).invoke(context, null);
                                int i155 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                int i156 = (i155 ^ 81) + ((i155 & 81) << 1);
                                artificialFrame = i156 % 128;
                                int i157 = i156 % 2;
                                try {
                                    Object[] objArr15 = {objInvoke2, 64};
                                    Object[] objArr16 = new Object[1];
                                    d((byte) (32 - View.resolveSizeAndState(0, 0, 0)), 32 - (~(-(ViewConfiguration.getEdgeSlop() >> 16))), new char[]{'!', 15, 31, 24, 17, 3, 31, '\f', 17, 16, '\n', '!', 3, 15, 31, 16, 11, CharUtils.CR, 19, 1, 28, 15, '\t', 28, 15, ' ', 25, 28, 15, '!', 15, ' ', 13832}, objArr16);
                                    Class<?> cls4 = Class.forName((String) objArr16[0]);
                                    int threadPriority = Process.getThreadPriority(0);
                                    int i158 = ((threadPriority ^ 20) + ((threadPriority & 20) << 1)) >> 6;
                                    int i159 = artificialFrame;
                                    int i160 = (i159 & 99) + (i159 | 99);
                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i160 % 128;
                                    int i161 = i160 % 2;
                                    int i162 = i158 * 677;
                                    int i163 = (i162 & (-85725)) + (i162 | (-85725));
                                    int i164 = i158 | i;
                                    int i165 = i163 + (((i164 & (-128)) | (i164 ^ (-128))) * (-676));
                                    int i166 = ~(((-128) ^ i158) | ((-128) & i158));
                                    int i167 = ~(i80 | i158);
                                    int i168 = -(-(((i166 & i167) | (i166 ^ i167)) * 676));
                                    int i169 = ((i165 | i168) << 1) - (i168 ^ i165);
                                    int i170 = ~i158;
                                    int i171 = ~((i170 & (-128)) | (i170 ^ (-128)));
                                    int i172 = ~(((-128) & i76) | ((-128) ^ i76));
                                    int i173 = (i171 & i172) | (i171 ^ i172);
                                    int i174 = ~((i158 & 127) | (i158 ^ 127) | i);
                                    Object[] objArr17 = new Object[1];
                                    c((i169 - (~(((i174 & i173) | (i173 ^ i174)) * 676))) - 1, new byte[]{-105, -98, -109, -99, -121, -103, -126, -102, -120, -126, -110, -116, -121, -103}, null, null, objArr17);
                                    Object objInvoke3 = cls4.getMethod((String) objArr17[0], String.class, Integer.TYPE).invoke(objInvoke, objArr15);
                                    int i175 = getARTIFICIAL_FRAME_PACKAGE_NAME + 101;
                                    artificialFrame = i175 % 128;
                                    int i176 = i175 % 2;
                                    int i177 = -View.resolveSizeAndState(0, 0, 0);
                                    int iL2 = ActivityFramesTracker$$ExternalSyntheticLambda1.l();
                                    int i178 = i177 * (-183);
                                    int i179 = (i178 ^ 23495) + ((i178 & 23495) << 1);
                                    int i180 = ~i177;
                                    int i181 = (i179 - (~(-(-(((i180 & 127) | (i180 ^ 127)) * (-368)))))) - 1;
                                    int i182 = (i177 ^ (-128)) | (i177 & (-128));
                                    int i183 = ~iL2;
                                    int i184 = -(-(((i182 & i183) | (i182 ^ i183)) * SyslogConstants.LOG_LOCAL7));
                                    int i185 = ((i181 | i184) << 1) - (i184 ^ i181);
                                    int i186 = ~((~i177) | (-128));
                                    int i187 = ~iL2;
                                    int i188 = (~((i187 & i177) | (i187 ^ i177))) | i186;
                                    int i189 = ~((i177 & 127) | (i177 ^ 127));
                                    Object[] objArr18 = new Object[1];
                                    c(i185 + (((i189 & i188) | (i188 ^ i189)) * SyslogConstants.LOG_LOCAL7), new byte[]{-105, -98, -109, -99, -121, -103, -126, -102, -120, -126, -110, -123, -100, -108, -123, -116, -109, -121, -116, -109, -105, -120, -123, -106, -117, -105, -118, -106, -109, -126}, null, null, objArr18);
                                    Class<?> cls5 = Class.forName((String) objArr18[0]);
                                    int i190 = -MotionEvent.axisFromString("");
                                    int iL3 = ActivityFramesTracker$$ExternalSyntheticLambda1.l();
                                    int i191 = i190 * (-115);
                                    int i192 = getARTIFICIAL_FRAME_PACKAGE_NAME + 93;
                                    artificialFrame = i192 % 128;
                                    int i193 = i192 % 2;
                                    int i194 = (i191 & (-10925)) + (i191 | (-10925));
                                    int i195 = ~iL3;
                                    int i196 = (i195 & i190) | (i195 ^ i190);
                                    int i197 = i194 + ((~((i196 & 95) | (i196 ^ 95))) * (-116)) + (((i190 ^ iL3) | (i190 & iL3)) * 116);
                                    int i198 = ~i190;
                                    int i199 = ~((i198 & (-96)) | (i198 ^ (-96)));
                                    int i200 = ~((iL3 & (-96)) | ((-96) ^ iL3));
                                    int i201 = ((i199 & i200) | (i199 ^ i200)) * 116;
                                    byte b2 = (byte) ((i197 & i201) + (i201 | i197));
                                    int i202 = -(ViewConfiguration.getScrollBarSize() >> 8);
                                    int i203 = i202 * 165;
                                    int i204 = (i203 & (-1630)) + (i203 | (-1630));
                                    int i205 = ~((i80 ^ 10) | (i80 & 10));
                                    int i206 = i204 + (((i205 & i202) | (i202 ^ i205)) * (-328));
                                    int i207 = -(-(((i202 ^ i) | (i202 & i)) * 164));
                                    int i208 = (i206 ^ i207) + ((i207 & i206) << 1);
                                    int i209 = ~i202;
                                    int i210 = getARTIFICIAL_FRAME_PACKAGE_NAME + 47;
                                    artificialFrame = i210 % 128;
                                    int i211 = i210 % 2;
                                    int i212 = ~(i209 | (-11));
                                    int i213 = ~(((-11) & i) | ((-11) ^ i));
                                    int i214 = (i212 & i213) | (i212 ^ i213);
                                    int i215 = (i202 & i80) | (i80 ^ i202);
                                    int i216 = ~((i215 & 10) | (i215 ^ 10));
                                    int i217 = -(-(164 * ((i216 & i214) | (i214 ^ i216))));
                                    int i218 = (i208 & i217) + (i217 | i208);
                                    Object[] objArr19 = new Object[1];
                                    d(b2, i218, new char[]{'#', 2, 15, '\b', 28, '!', 29, 26, '\"', '!'}, objArr19);
                                    Object[] objArr20 = (Object[]) cls5.getField((String) objArr19[0]).get(objInvoke3);
                                    int length = objArr20.length;
                                    int i219 = artificialFrame + 15;
                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i219 % 128;
                                    int i220 = i219 % 2;
                                    int i221 = 0;
                                    while (i221 < length) {
                                        int i222 = getARTIFICIAL_FRAME_PACKAGE_NAME + 31;
                                        artificialFrame = i222 % 128;
                                        if (i222 % i10 == 0) {
                                            obj = objArr20[i221];
                                            iArgb = Color.argb(1, 0, 0, 0);
                                            i9 = 16;
                                        } else {
                                            obj = objArr20[i221];
                                            iArgb = Color.argb(0, 0, 0, 0);
                                            i9 = 127;
                                        }
                                        Object[] objArr21 = new Object[1];
                                        c(i9 + iArgb, new byte[]{-97, -112, -113, -123, -111}, null, null, objArr21);
                                        String str4 = (String) objArr21[0];
                                        int i223 = artificialFrame + 71;
                                        getARTIFICIAL_FRAME_PACKAGE_NAME = i223 % 128;
                                        if (i223 % i10 != 0) {
                                            int i224 = 3 % 4;
                                        }
                                        try {
                                            Object[] objArr22 = {str4};
                                            int i225 = -(ViewConfiguration.getScrollBarSize() >> 8);
                                            int i226 = -(-(i225 * 530));
                                            int i227 = ((i226 | 1058) << 1) - (i226 ^ 1058);
                                            int i228 = ((i227 | 67310) << 1) - (67310 ^ i227);
                                            int i229 = -(-(((~(i76 | i225)) | (~(i225 | 127))) * 529));
                                            int i230 = ((i228 | i229) << 1) - (i229 ^ i228);
                                            int i231 = ~((i225 & i) | (i225 ^ i));
                                            Object[] objArr23 = new Object[1];
                                            c(i230 + (((i231 & (-128)) | ((-128) ^ i231)) * 529), new byte[]{-115, -118, -105, -116, -120, -126, -96, -121, -116, -126, -120, -117, -98, -117, -116, -118, -121, -104, -123, -116, -118, -121, -120, -123, -115, -116, -117, -118, -119, -120, -121, -122, -123, -126, -125, -126, -127}, null, null, objArr23);
                                            Class<?> cls6 = Class.forName((String) objArr23[0]);
                                            int i232 = -(-(ViewConfiguration.getMinimumFlingVelocity() >> 16));
                                            Object[] objArr24 = new Object[1];
                                            c(((i232 | 127) << 1) - (i232 ^ 127), new byte[]{-121, -120, -109, -126, -116, -122, -109, -99, -116, -121, -103}, null, null, objArr24);
                                            Object objInvoke4 = cls6.getMethod((String) objArr24[0], String.class).invoke(null, objArr22);
                                            try {
                                                int i233 = -View.MeasureSpec.makeMeasureSpec(0, 0);
                                                int i234 = ~i233;
                                                int i235 = ~((i234 & i76) | (i234 ^ i76));
                                                int i236 = ~((-128) | i);
                                                int i237 = (((i233 * (-433)) - 27432) - (~(((i235 & i236) | (i235 ^ i236)) * JfifUtil.MARKER_EOI))) - 1;
                                                int i238 = ~i233;
                                                int i239 = -(-(((~((i238 & i) | (i238 ^ i))) | (~((i238 ^ (-128)) | (i238 & (-128))))) * JfifUtil.MARKER_EOI));
                                                int i240 = (i237 ^ i239) + ((i237 & i239) << 1);
                                                int i241 = ~(((-128) ^ i76) | ((-128) & i76));
                                                int i242 = ((i233 & i241) | (i233 ^ i241)) * JfifUtil.MARKER_EOI;
                                                Object[] objArr25 = new Object[1];
                                                c(((i240 | i242) << 1) - (i242 ^ i240), new byte[]{-121, -118, -119, -116, -126, -109, -103, -117, -95, -123, -100, -108, -123, -116, -109, -121, -116, -109, -105, -120, -123, -106, -117, -105, -118, -106, -109, -126}, null, null, objArr25);
                                                Class<?> cls7 = Class.forName((String) objArr25[0]);
                                                int i243 = -KeyEvent.keyCodeFromString("");
                                                int i244 = -View.resolveSizeAndState(0, 0, 0);
                                                Object[] objArr26 = objArr20;
                                                Object[] objArr27 = new Object[1];
                                                d((byte) ((i243 & 95) + (i243 | 95)), (i244 & 11) + (i244 | 11), new char[]{'!', 16, 18, 14, '#', '\"', 1, 28, 26, 28, 13890}, objArr27);
                                                try {
                                                    Object[] objArr28 = {new ByteArrayInputStream((byte[]) cls7.getMethod((String) objArr27[0], null).invoke(obj, null))};
                                                    int i245 = -(-View.combineMeasuredStates(0, 0));
                                                    Object[] objArr29 = new Object[1];
                                                    c(((i245 | 127) << 1) - (i245 ^ 127), new byte[]{-115, -118, -105, -116, -120, -126, -96, -121, -116, -126, -120, -117, -98, -117, -116, -118, -121, -104, -123, -116, -118, -121, -120, -123, -115, -116, -117, -118, -119, -120, -121, -122, -123, -126, -125, -126, -127}, null, null, objArr29);
                                                    Class<?> cls8 = Class.forName((String) objArr29[0]);
                                                    int packedPositionChild2 = ExpandableListView.getPackedPositionChild(0L);
                                                    int i246 = (((packedPositionChild2 * (-1335)) - 85376) - (~(-(-(((~(packedPositionChild2 | i)) | (-129)) * (-668)))))) - 1;
                                                    int i247 = -(-(((~((-129) | i)) | packedPositionChild2) * 1336));
                                                    int i248 = (packedPositionChild2 & i) | (packedPositionChild2 ^ i);
                                                    Object[] objArr30 = new Object[1];
                                                    c((((i246 | i247) << 1) - (i246 ^ i247)) + (((i248 & (-129)) | (i248 ^ (-129))) * 668), new byte[]{-121, -116, -126, -120, -117, -98, -117, -116, -118, -121, -104, -121, -116, -126, -118, -121, -109, -121, -103}, null, null, objArr30);
                                                    Object objInvoke5 = cls8.getMethod((String) objArr30[0], InputStream.class).invoke(objInvoke4, objArr28);
                                                    int length2 = objArr3.length;
                                                    int i249 = 0;
                                                    while (i249 < 2) {
                                                        Object obj3 = objArr3[i249];
                                                        try {
                                                            int i250 = -(-Drawable.resolveOpacity(0, 0));
                                                            Object[] objArr31 = new Object[1];
                                                            c(((i250 | 127) << 1) - (i250 ^ 127), new byte[]{-121, -116, -126, -120, -117, -98, -117, -116, -118, -121, -104, -97, -112, -113, -111, -123, -116, -118, -121, -120, -123, -115, -116, -117, -118, -119, -120, -121, -122, -123, -126, -125, -126, -127}, null, null, objArr31);
                                                            Class<?> cls9 = Class.forName((String) objArr31[0]);
                                                            int mode = View.MeasureSpec.getMode(0);
                                                            int iL4 = ActivityFramesTracker$$ExternalSyntheticLambda1.l();
                                                            int i251 = ~mode;
                                                            Object[] objArr32 = objArr3;
                                                            int i252 = mode | 127;
                                                            int i253 = ((mode * 273) - 34417) + (((~((~iL4) | (i251 ^ (-128)) | (i251 & (-128)))) | (~((i252 ^ iL4) | (i252 & iL4)))) * (-272));
                                                            int i254 = ~mode;
                                                            int i255 = ~((i254 & 127) | (i254 ^ 127));
                                                            int i256 = ~((i251 & iL4) | (i251 ^ iL4));
                                                            int i257 = -(-(((i255 & i256) | (i255 ^ i256)) * (-272)));
                                                            Object[] objArr33 = new Object[1];
                                                            c((((i253 ^ i257) + ((i257 & i253) << 1)) - (~(-(-(((~((mode ^ iL4) | (iL4 & mode))) | 127) * 272))))) - 1, new byte[]{-107, -126, -108, -117, -120, -109, -117, -118, -110, -112, -112, -113, -111, -116, -120, -121, -127, -94, -119, -95, -116, -121, -103}, null, null, objArr33);
                                                            if (obj3.equals(cls9.getMethod((String) objArr33[0], null).invoke(objInvoke5, null))) {
                                                                Object[] objArr34 = {new int[]{i}, new int[]{(i & (-2)) | (i80 & 1)}, new int[1], null};
                                                                int elapsedCpuTime = (int) Process.getElapsedCpuTime();
                                                                int i258 = ~elapsedCpuTime;
                                                                int i259 = (-958088776) + (((~((-370701970) | i258)) | (~((-607921806) | i258))) * (-867)) + (((~((-370701970) | elapsedCpuTime)) | 68691585 | (~((-607921806) | elapsedCpuTime))) * (-1734)) + (((~(elapsedCpuTime | (-539230221))) | (~(i258 | (-68691586))) | (~((-302010385) | elapsedCpuTime))) * 867);
                                                                int iL5 = ActivityFramesTracker$$ExternalSyntheticLambda1.l();
                                                                int i260 = (-880) + (i259 * (-55)) + (((~(iL5 | 16)) | i259) * 56) + ((~((i259 ^ 16) | (i259 & 16))) * (-56));
                                                                int i261 = ~iL5;
                                                                int i262 = ~((i261 & i259) | (i261 ^ i259));
                                                                int i263 = -(-(((i262 & 16) | (i262 ^ 16)) * 56));
                                                                int i264 = (i260 & i263) + (i263 | i260);
                                                                int i265 = i264 * (-1335);
                                                                int i266 = i2 * (-667);
                                                                int i267 = ((i265 | i266) << 1) - (i265 ^ i266);
                                                                int i268 = ~i2;
                                                                int i269 = ~((i264 ^ i) | (i264 & i));
                                                                int i270 = (i267 - (~(-(-(((i268 & i269) | (i268 ^ i269)) * (-668)))))) - 1;
                                                                int i271 = ~i2;
                                                                int i272 = ((~((i271 ^ i) | (i271 & i))) | i264) * 1336;
                                                                int i273 = (i270 ^ i272) + ((i270 & i272) << 1);
                                                                int i274 = (i271 | i264 | i) * 668;
                                                                int i275 = (i273 ^ i274) + ((i274 & i273) << 1);
                                                                int i276 = i275 << 13;
                                                                int i277 = (i276 | i275) & (~(i275 & i276));
                                                                int i278 = i277 >>> 17;
                                                                int i279 = (i277 | i278) & (~(i277 & i278));
                                                                int i280 = i279 << 5;
                                                                ((int[]) objArr34[2])[0] = ((~i279) & i280) | ((~i280) & i279);
                                                                return objArr34;
                                                            }
                                                            int i281 = (i249 ^ (-96)) + ((i249 & (-96)) << 1);
                                                            i249 = ((i281 | 97) << 1) - (i281 ^ 97);
                                                            objArr3 = objArr32;
                                                        } catch (Throwable th) {
                                                            Throwable cause = th.getCause();
                                                            if (cause != null) {
                                                                throw cause;
                                                            }
                                                            throw th;
                                                        }
                                                    }
                                                    i221 = (i221 & 1) + (i221 | 1);
                                                    objArr20 = objArr26;
                                                    i10 = 2;
                                                } catch (Throwable th2) {
                                                    Throwable cause2 = th2.getCause();
                                                    if (cause2 != null) {
                                                        throw cause2;
                                                    }
                                                    throw th2;
                                                }
                                            } catch (Throwable th3) {
                                                Throwable cause3 = th3.getCause();
                                                if (cause3 != null) {
                                                    throw cause3;
                                                }
                                                throw th3;
                                            }
                                        } catch (Throwable th4) {
                                            Throwable cause4 = th4.getCause();
                                            if (cause4 != null) {
                                                throw cause4;
                                            }
                                            throw th4;
                                        }
                                    }
                                    Object[] objArr35 = new Object[4];
                                    objArr35[0] = new int[]{i};
                                    int[] iArr = new int[1];
                                    objArr35[1] = iArr;
                                    objArr35[2] = new int[1];
                                    int i282 = artificialFrame;
                                    int i283 = ((i282 | 85) << 1) - (i282 ^ 85);
                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i283 % 128;
                                    if (i283 % 2 != 0) {
                                        iArr[1] = i;
                                        objArr35[3] = null;
                                    } else {
                                        iArr[0] = i;
                                        objArr35[3] = null;
                                    }
                                    int i284 = (int) Runtime.getRuntime().totalMemory();
                                    int i285 = (((~((~i284) | 1073590265)) * 130) - 1936283422) + (((~(i284 | 1073590265)) | 71828120) * 130);
                                    int i286 = ((i2 | i285) << 1) - (i2 ^ i285);
                                    int i287 = i286 ^ (i286 << 13);
                                    int i288 = i287 >>> 17;
                                    int i289 = ((~i287) & i288) | ((~i288) & i287);
                                    int i290 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                    int i291 = (i290 & 89) + (i290 | 89);
                                    artificialFrame = i291 % 128;
                                    int i292 = i291 % 2;
                                    int i293 = i289 << 5;
                                    ((int[]) objArr35[2])[0] = (i289 | i293) & (~(i289 & i293));
                                    return objArr35;
                                } catch (Throwable th5) {
                                    Throwable cause5 = th5.getCause();
                                    if (cause5 != null) {
                                        throw cause5;
                                    }
                                    throw th5;
                                }
                            } catch (Throwable th6) {
                                Throwable cause6 = th6.getCause();
                                if (cause6 != null) {
                                    throw cause6;
                                }
                                throw th6;
                            }
                        } catch (Throwable th7) {
                            Throwable cause7 = th7.getCause();
                            if (cause7 != null) {
                                throw cause7;
                            }
                            throw th7;
                        }
                    } catch (Throwable th8) {
                        Throwable cause8 = th8.getCause();
                        if (cause8 != null) {
                            throw cause8;
                        }
                        throw th8;
                    }
                } catch (Throwable th9) {
                    Throwable cause9 = th9.getCause();
                    if (cause9 != null) {
                        throw cause9;
                    }
                    throw th9;
                }
            } catch (Throwable unused) {
            }
        }
    }
}
