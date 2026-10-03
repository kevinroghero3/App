package io.sentry;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import ch.qos.logback.core.joran.action.TimestampAction;
import ch.qos.logback.core.net.SyslogConstants;
import com.google.common.base.Ascii;
import io.sentry.vendor.gson.stream.JsonReader;
import io.sentry.vendor.gson.stream.JsonToken;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import o.ArtificialStackFrames;
import o.onRelationshipValidationResult;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public final class JsonObjectReader implements ObjectReader {
    private final JsonReader jsonReader;
    private static final byte[] $$c = {106, -29, -101, -119};
    private static final int $$d = 32;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$a = {5, -37, 48, 84, Ascii.VT, 2, -12};
    private static final int $$b = 29;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static long onPostMessage = -7318129516431298491L;

    /* JADX WARN: Code duplicated, block: B:10:0x0022  */
    /* JADX WARN: Code duplicated, block: B:8:0x001c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0022 -> B:11:0x0028). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0022
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$e(short r5, int r6, int r7) {
        /*
            int r7 = r7 * 4
            int r7 = 3 - r7
            int r6 = r6 * 3
            int r0 = r6 + 1
            byte[] r1 = io.sentry.JsonObjectReader.$$c
            int r5 = r5 * 3
            int r5 = 111 - r5
            byte[] r0 = new byte[r0]
            r2 = 0
            if (r1 != 0) goto L16
            r4 = r6
            r3 = r2
            goto L28
        L16:
            r3 = r2
        L17:
            byte r4 = (byte) r5
            r0[r3] = r4
            if (r3 != r6) goto L22
            java.lang.String r5 = new java.lang.String
            r5.<init>(r0, r2)
            return r5
        L22:
            int r7 = r7 + 1
            r4 = r1[r7]
            int r3 = r3 + 1
        L28:
            int r4 = -r4
            int r5 = r5 + r4
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.JsonObjectReader.$$e(short, int, int):java.lang.String");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x002a  */
    /* JADX WARN: Code duplicated, block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x002c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x002a
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void b(int r7, byte r8, int r9, java.lang.Object[] r10) {
        /*
            int r8 = r8 + 4
            int r9 = r9 * 3
            int r9 = r9 + 109
            int r7 = r7 * 2
            int r7 = 4 - r7
            byte[] r0 = io.sentry.JsonObjectReader.$$a
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L15
            r3 = r7
            r9 = r8
            r5 = r2
            goto L2c
        L15:
            r3 = r2
            r6 = r9
            r9 = r8
            r8 = r6
        L19:
            byte r4 = (byte) r8
            int r5 = r3 + 1
            r1[r3] = r4
            int r9 = r9 + 1
            if (r5 != r7) goto L2a
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2a:
            r3 = r0[r9]
        L2c:
            int r8 = r8 + r3
            int r8 = r8 + (-3)
            r3 = r5
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.JsonObjectReader.b(int, byte, int, java.lang.Object[]):void");
    }

    public JsonObjectReader(Reader reader) {
        this.jsonReader = new JsonReader(reader);
    }

    @Override // io.sentry.ObjectReader
    public String nextStringOrNull() throws IOException {
        if (this.jsonReader.peek() == JsonToken.NULL) {
            this.jsonReader.nextNull();
            return null;
        }
        return this.jsonReader.nextString();
    }

    @Override // io.sentry.ObjectReader
    public Double nextDoubleOrNull() throws IOException {
        if (this.jsonReader.peek() == JsonToken.NULL) {
            this.jsonReader.nextNull();
            return null;
        }
        return Double.valueOf(this.jsonReader.nextDouble());
    }

    @Override // io.sentry.ObjectReader
    public Float nextFloatOrNull() throws IOException {
        if (this.jsonReader.peek() == JsonToken.NULL) {
            this.jsonReader.nextNull();
            return null;
        }
        return Float.valueOf(nextFloat());
    }

    @Override // io.sentry.ObjectReader
    public float nextFloat() throws IOException {
        return (float) this.jsonReader.nextDouble();
    }

    @Override // io.sentry.ObjectReader
    public Long nextLongOrNull() throws IOException {
        if (this.jsonReader.peek() == JsonToken.NULL) {
            this.jsonReader.nextNull();
            return null;
        }
        return Long.valueOf(this.jsonReader.nextLong());
    }

    private static void a(int i, char[] cArr, Object[] objArr) throws Throwable {
        int i2 = 2 % 2;
        onRelationshipValidationResult onrelationshipvalidationresult = new onRelationshipValidationResult();
        char[] cArrAccessartificialFrame = onRelationshipValidationResult.accessartificialFrame(onPostMessage ^ 2573525503365829440L, cArr, i);
        onrelationshipvalidationresult.e = 4;
        int i3 = $11 + 41;
        $10 = i3 % 128;
        if (i3 % 2 != 0) {
            int i4 = 3 / 5;
        }
        while (onrelationshipvalidationresult.e < cArrAccessartificialFrame.length) {
            onrelationshipvalidationresult.d = onrelationshipvalidationresult.e - 4;
            int i5 = onrelationshipvalidationresult.e;
            try {
                Object[] objArr2 = {Long.valueOf(cArrAccessartificialFrame[onrelationshipvalidationresult.e] ^ cArrAccessartificialFrame[onrelationshipvalidationresult.e % 4]), Long.valueOf(onrelationshipvalidationresult.d), Long.valueOf(onPostMessage)};
                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(797310229);
                if (objAccessartificialFrame == null) {
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(27 - (Process.myPid() >> 22), (char) (30690 - KeyEvent.getDeadChar(0, 0)), 188 - View.MeasureSpec.getSize(0), -1327449315, false, "k", new Class[]{Long.TYPE, Long.TYPE, Long.TYPE});
                }
                cArrAccessartificialFrame[i5] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                Object[] objArr3 = {onrelationshipvalidationresult, onrelationshipvalidationresult};
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(321542193);
                if (objAccessartificialFrame2 == null) {
                    byte b = (byte) 0;
                    byte b2 = b;
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(View.MeasureSpec.getSize(0) + 33, (char) Color.red(0), 1483 - TextUtils.getOffsetBefore("", 0), -1940971975, false, $$e(b, b2, b2), new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame2).invoke(null, objArr3);
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }
        String str = new String(cArrAccessartificialFrame, 4, cArrAccessartificialFrame.length - 4);
        int i6 = $10 + 35;
        $11 = i6 % 128;
        if (i6 % 2 == 0) {
            throw null;
        }
        objArr[0] = str;
    }

    @Override // io.sentry.ObjectReader
    public Integer nextIntegerOrNull() throws IOException {
        if (this.jsonReader.peek() == JsonToken.NULL) {
            this.jsonReader.nextNull();
            return null;
        }
        return Integer.valueOf(this.jsonReader.nextInt());
    }

    @Override // io.sentry.ObjectReader
    public Boolean nextBooleanOrNull() throws IOException {
        if (this.jsonReader.peek() == JsonToken.NULL) {
            this.jsonReader.nextNull();
            return null;
        }
        return Boolean.valueOf(this.jsonReader.nextBoolean());
    }

    @Override // io.sentry.ObjectReader
    public void nextUnknown(ILogger iLogger, Map<String, Object> map, String str) {
        try {
            map.put(str, nextObjectOrNull());
        } catch (Exception e) {
            iLogger.log(SentryLevel.ERROR, e, "Error deserializing unknown key: %s", str);
        }
    }

    @Override // io.sentry.ObjectReader
    public <T> List<T> nextListOrNull(@NotNull ILogger iLogger, @NotNull JsonDeserializer<T> jsonDeserializer) throws IOException {
        if (this.jsonReader.peek() == JsonToken.NULL) {
            this.jsonReader.nextNull();
            return null;
        }
        this.jsonReader.beginArray();
        ArrayList arrayList = new ArrayList();
        if (this.jsonReader.hasNext()) {
            do {
                try {
                    arrayList.add(jsonDeserializer.deserialize(this, iLogger));
                } catch (Exception e) {
                    iLogger.log(SentryLevel.WARNING, "Failed to deserialize object in list.", e);
                }
            } while (this.jsonReader.peek() == JsonToken.BEGIN_OBJECT);
        }
        this.jsonReader.endArray();
        return arrayList;
    }

    @Override // io.sentry.ObjectReader
    public <T> Map<String, T> nextMapOrNull(@NotNull ILogger iLogger, @NotNull JsonDeserializer<T> jsonDeserializer) throws IOException {
        if (this.jsonReader.peek() == JsonToken.NULL) {
            this.jsonReader.nextNull();
            return null;
        }
        this.jsonReader.beginObject();
        HashMap map = new HashMap();
        if (this.jsonReader.hasNext()) {
            while (true) {
                try {
                    map.put(this.jsonReader.nextName(), jsonDeserializer.deserialize(this, iLogger));
                } catch (Exception e) {
                    iLogger.log(SentryLevel.WARNING, "Failed to deserialize object in map.", e);
                }
                if (this.jsonReader.peek() != JsonToken.BEGIN_OBJECT && this.jsonReader.peek() != JsonToken.NAME) {
                    break;
                }
            }
        }
        this.jsonReader.endObject();
        return map;
    }

    @Override // io.sentry.ObjectReader
    public <T> Map<String, List<T>> nextMapOfListOrNull(@NotNull ILogger iLogger, @NotNull JsonDeserializer<T> jsonDeserializer) throws IOException {
        if (peek() == JsonToken.NULL) {
            nextNull();
            return null;
        }
        HashMap map = new HashMap();
        beginObject();
        if (hasNext()) {
            while (true) {
                String strNextName = nextName();
                List<T> listNextListOrNull = nextListOrNull(iLogger, jsonDeserializer);
                if (listNextListOrNull != null) {
                    map.put(strNextName, listNextListOrNull);
                }
                if (peek() != JsonToken.BEGIN_OBJECT && peek() != JsonToken.NAME) {
                    break;
                }
            }
        }
        endObject();
        return map;
    }

    @Override // io.sentry.ObjectReader
    public <T> T nextOrNull(@NotNull ILogger iLogger, @NotNull JsonDeserializer<T> jsonDeserializer) throws Exception {
        if (this.jsonReader.peek() == JsonToken.NULL) {
            this.jsonReader.nextNull();
            return null;
        }
        return jsonDeserializer.deserialize(this, iLogger);
    }

    @Override // io.sentry.ObjectReader
    public Date nextDateOrNull(ILogger iLogger) throws IOException {
        if (this.jsonReader.peek() == JsonToken.NULL) {
            this.jsonReader.nextNull();
            return null;
        }
        return ObjectReader.dateOrNull(this.jsonReader.nextString(), iLogger);
    }

    @Override // io.sentry.ObjectReader
    public TimeZone nextTimeZoneOrNull(ILogger iLogger) throws IOException {
        if (this.jsonReader.peek() == JsonToken.NULL) {
            this.jsonReader.nextNull();
            return null;
        }
        try {
            return TimeZone.getTimeZone(this.jsonReader.nextString());
        } catch (Exception e) {
            iLogger.log(SentryLevel.ERROR, "Error when deserializing TimeZone", e);
            return null;
        }
    }

    @Override // io.sentry.ObjectReader
    public Object nextObjectOrNull() throws IOException {
        return new JsonObjectDeserializer().deserialize(this);
    }

    @Override // io.sentry.ObjectReader
    public JsonToken peek() throws IOException {
        return this.jsonReader.peek();
    }

    @Override // io.sentry.ObjectReader
    public String nextName() throws IOException {
        return this.jsonReader.nextName();
    }

    @Override // io.sentry.ObjectReader
    public void beginObject() throws IOException {
        this.jsonReader.beginObject();
    }

    @Override // io.sentry.ObjectReader
    public void endObject() throws IOException {
        this.jsonReader.endObject();
    }

    @Override // io.sentry.ObjectReader
    public void beginArray() throws IOException {
        this.jsonReader.beginArray();
    }

    @Override // io.sentry.ObjectReader
    public void endArray() throws IOException {
        this.jsonReader.endArray();
    }

    @Override // io.sentry.ObjectReader
    public boolean hasNext() throws IOException {
        return this.jsonReader.hasNext();
    }

    @Override // io.sentry.ObjectReader
    public int nextInt() throws IOException {
        return this.jsonReader.nextInt();
    }

    @Override // io.sentry.ObjectReader
    public long nextLong() throws IOException {
        return this.jsonReader.nextLong();
    }

    @Override // io.sentry.ObjectReader
    public String nextString() throws IOException {
        return this.jsonReader.nextString();
    }

    @Override // io.sentry.ObjectReader
    public boolean nextBoolean() throws IOException {
        return this.jsonReader.nextBoolean();
    }

    @Override // io.sentry.ObjectReader
    public double nextDouble() throws IOException {
        return this.jsonReader.nextDouble();
    }

    @Override // io.sentry.ObjectReader
    public void nextNull() throws IOException {
        this.jsonReader.nextNull();
    }

    @Override // io.sentry.ObjectReader
    public void setLenient(boolean z) {
        this.jsonReader.setLenient(z);
    }

    @Override // io.sentry.ObjectReader
    public void skipValue() throws IOException {
        this.jsonReader.skipValue();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.jsonReader.close();
    }

    /* JADX WARN: Code duplicated, block: B:106:0x0768  */
    /* JADX WARN: Code duplicated, block: B:107:0x0774 A[Catch: Exception -> 0x07f4, TRY_ENTER, TRY_LEAVE, TryCatch #5 {Exception -> 0x07f4, blocks: (B:92:0x06f8, B:95:0x0753, B:97:0x075a, B:107:0x0774, B:117:0x07c3, B:121:0x07db, B:122:0x07e4, B:126:0x07ed, B:127:0x07f3, B:103:0x0761, B:108:0x077e, B:112:0x0795, B:115:0x07ac), top: B:178:0x06f8, inners: #4 }] */
    /* JADX WARN: Code duplicated, block: B:111:0x0794  */
    /* JADX WARN: Code duplicated, block: B:114:0x07ab  */
    /* JADX WARN: Code duplicated, block: B:115:0x07ac A[Catch: all -> 0x07ec, TRY_LEAVE, TryCatch #4 {all -> 0x07ec, blocks: (B:108:0x077e, B:112:0x0795, B:115:0x07ac), top: B:177:0x077e, outer: #5 }] */
    /* JADX WARN: Code duplicated, block: B:117:0x07c3 A[Catch: Exception -> 0x07f4, TRY_ENTER, TRY_LEAVE, TryCatch #5 {Exception -> 0x07f4, blocks: (B:92:0x06f8, B:95:0x0753, B:97:0x075a, B:107:0x0774, B:117:0x07c3, B:121:0x07db, B:122:0x07e4, B:126:0x07ed, B:127:0x07f3, B:103:0x0761, B:108:0x077e, B:112:0x0795, B:115:0x07ac), top: B:178:0x06f8, inners: #4 }] */
    /* JADX WARN: Code duplicated, block: B:119:0x07ca  */
    /* JADX WARN: Code duplicated, block: B:121:0x07db A[Catch: Exception -> 0x07f4, TRY_ENTER, TryCatch #5 {Exception -> 0x07f4, blocks: (B:92:0x06f8, B:95:0x0753, B:97:0x075a, B:107:0x0774, B:117:0x07c3, B:121:0x07db, B:122:0x07e4, B:126:0x07ed, B:127:0x07f3, B:103:0x0761, B:108:0x077e, B:112:0x0795, B:115:0x07ac), top: B:178:0x06f8, inners: #4 }] */
    /* JADX WARN: Code duplicated, block: B:122:0x07e4 A[Catch: Exception -> 0x07f4, TRY_LEAVE, TryCatch #5 {Exception -> 0x07f4, blocks: (B:92:0x06f8, B:95:0x0753, B:97:0x075a, B:107:0x0774, B:117:0x07c3, B:121:0x07db, B:122:0x07e4, B:126:0x07ed, B:127:0x07f3, B:103:0x0761, B:108:0x077e, B:112:0x0795, B:115:0x07ac), top: B:178:0x06f8, inners: #4 }] */
    /* JADX WARN: Code duplicated, block: B:131:0x0820  */
    /* JADX WARN: Code duplicated, block: B:132:0x0822 A[Catch: Exception -> 0x0a67, TRY_LEAVE, TryCatch #3 {Exception -> 0x0a67, blocks: (B:129:0x07f6, B:132:0x0822, B:136:0x0888, B:138:0x0890, B:141:0x08bc, B:143:0x08e4, B:157:0x0a58, B:158:0x0a5e, B:160:0x0a60, B:161:0x0a66, B:142:0x08c6, B:133:0x082c, B:135:0x0874), top: B:176:0x07f6, inners: #2, #7 }] */
    /* JADX WARN: Code duplicated, block: B:138:0x0890 A[Catch: Exception -> 0x0a67, TryCatch #3 {Exception -> 0x0a67, blocks: (B:129:0x07f6, B:132:0x0822, B:136:0x0888, B:138:0x0890, B:141:0x08bc, B:143:0x08e4, B:157:0x0a58, B:158:0x0a5e, B:160:0x0a60, B:161:0x0a66, B:142:0x08c6, B:133:0x082c, B:135:0x0874), top: B:176:0x07f6, inners: #2, #7 }] */
    /* JADX WARN: Code duplicated, block: B:140:0x08ba  */
    /* JADX WARN: Code duplicated, block: B:141:0x08bc A[Catch: Exception -> 0x0a67, TRY_LEAVE, TryCatch #3 {Exception -> 0x0a67, blocks: (B:129:0x07f6, B:132:0x0822, B:136:0x0888, B:138:0x0890, B:141:0x08bc, B:143:0x08e4, B:157:0x0a58, B:158:0x0a5e, B:160:0x0a60, B:161:0x0a66, B:142:0x08c6, B:133:0x082c, B:135:0x0874), top: B:176:0x07f6, inners: #2, #7 }] */
    /* JADX WARN: Code duplicated, block: B:145:0x08ec  */
    /* JADX WARN: Code duplicated, block: B:147:0x08f8  */
    /* JADX WARN: Code duplicated, block: B:149:0x0904  */
    /* JADX WARN: Code duplicated, block: B:150:0x091c  */
    /* JADX WARN: Code duplicated, block: B:153:0x099a  */
    /* JADX WARN: Code duplicated, block: B:154:0x09c0  */
    /* JADX WARN: Code duplicated, block: B:37:0x0107 A[Catch: Exception -> 0x01fa, TRY_ENTER, TryCatch #1 {Exception -> 0x01fa, blocks: (B:7:0x0022, B:10:0x0066, B:14:0x006e, B:17:0x008b, B:19:0x00b2, B:22:0x00c9, B:24:0x00cf, B:41:0x016a, B:32:0x00dc, B:34:0x00f5, B:37:0x0107, B:40:0x0164, B:38:0x010e, B:30:0x00d6, B:18:0x009f, B:42:0x0173, B:11:0x0069), top: B:173:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:38:0x010e A[Catch: Exception -> 0x01fa, TRY_LEAVE, TryCatch #1 {Exception -> 0x01fa, blocks: (B:7:0x0022, B:10:0x0066, B:14:0x006e, B:17:0x008b, B:19:0x00b2, B:22:0x00c9, B:24:0x00cf, B:41:0x016a, B:32:0x00dc, B:34:0x00f5, B:37:0x0107, B:40:0x0164, B:38:0x010e, B:30:0x00d6, B:18:0x009f, B:42:0x0173, B:11:0x0069), top: B:173:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:65:0x0431  */
    /* JADX WARN: Code duplicated, block: B:70:0x04ce  */
    /* JADX WARN: Code duplicated, block: B:71:0x0504  */
    /* JADX WARN: Code duplicated, block: B:76:0x060b  */
    /* JADX WARN: Code duplicated, block: B:78:0x0634  */
    /* JADX WARN: Code duplicated, block: B:81:0x067b  */
    /* JADX WARN: Code duplicated, block: B:82:0x0693  */
    public static Object[] coroutineCreation(int i, int i2) throws Throwable {
        Object[] objArr;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Object[] objArr2;
        int i8;
        int i9;
        int i10;
        int i_BOUNDARY;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        char c;
        String str;
        File file;
        FileReader fileReader;
        BufferedReader bufferedReader;
        boolean zEquals;
        File file2;
        FileReader fileReader2;
        BufferedReader bufferedReader2;
        boolean zEquals2;
        int i17;
        int i18;
        char c2;
        int i19;
        char c3;
        Object[] objArr3;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        FileReader fileReader3;
        BufferedReader bufferedReader3;
        String line;
        int i27;
        int i28;
        Object[] objArr4;
        int i29;
        Object[] objArr5;
        int i30;
        Object[] objArr6;
        int[] iArr;
        int i31;
        int i32;
        int i33;
        int i34;
        int i35;
        Class<?> cls;
        int i36;
        int i37;
        int[] iArr2;
        int[] iArr3;
        int i38;
        int i39 = 2 % 2;
        int i40 = artificialFrame;
        int i41 = i40 + 123;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i41 % 128;
        int i42 = i41 % 2;
        int i43 = i40 + 3;
        getARTIFICIAL_FRAME_PACKAGE_NAME = i43 % 128;
        try {
            String[] strArr = new String[i43 % 2 != 0 ? 3 : 2];
            int i44 = -(ViewConfiguration.getTapTimeout() >> 16);
            Object[] objArr7 = new Object[1];
            a(((i44 | 1) << 1) - (i44 ^ 1), new char[]{4658, 4699, 13970, 54756, 55273, 43535, 40516, 23038, 4519, 869, 17374, 13857, 2687, 52685, 53206, 49725, 46688, 45501, 31620, 20045, 8726, 9634, 59289}, objArr7);
            strArr[0] = (String) objArr7[0];
            int i45 = -Drawable.resolveOpacity(0, 0);
            Object[] objArr8 = new Object[1];
            a((i45 & 1) + (i45 | 1), new char[]{25811, 25764, 27758, 36618, 15676, 28222, 59566, 793, 64351, 51013, 43302, 61984, 31892, 38705, 9513, 1559, 49293, 60250, 37246, 35433, 21734, 32585}, objArr8);
            String str2 = (String) objArr8[0];
            int i46 = artificialFrame + 55;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i46 % 128;
            if (i46 % 2 != 0) {
                strArr[1] = str2;
            } else {
                strArr[1] = str2;
            }
            int i47 = 0;
            while (true) {
                if (i47 < 2) {
                    String str3 = strArr[i47];
                    int i48 = -(ViewConfiguration.getJumpTapTimeout() >> 16);
                    int i49 = (i48 & 1) + (i48 | 1);
                    int i50 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                    int i51 = (i50 & 13) + (i50 | 13);
                    artificialFrame = i51 % 128;
                    if (i51 % 2 == 0) {
                        Object[] objArr9 = new Object[1];
                        a(i49, new char[]{45522, 45491, 44472, 20179, 25177, 8348, 15785, 49864, 42039, 35297, 63053, 48364, 43413, 22246, 31275, 18578, 5515, 10907, 52740, 50381}, objArr9);
                        cls = Class.forName((String) objArr9[0]);
                        i36 = 1;
                    } else {
                        Object[] objArr10 = new Object[1];
                        a(i49, new char[]{45522, 45491, 44472, 20179, 25177, 8348, 15785, 49864, 42039, 35297, 63053, 48364, 43413, 22246, 31275, 18578, 5515, 10907, 52740, 50381}, objArr10);
                        cls = Class.forName((String) objArr10[0]);
                        i36 = 0;
                    }
                    Boolean bool = (Boolean) cls.getMethod(str3, new Class[i36]).invoke(cls, null);
                    int i52 = getARTIFICIAL_FRAME_PACKAGE_NAME + 83;
                    artificialFrame = i52 % 128;
                    if (i52 % 2 == 0) {
                        int i53 = 44 / 0;
                        if (bool.booleanValue()) {
                            i37 = i ^ 1;
                            objArr = new Object[4];
                            iArr2 = new int[1];
                            objArr[0] = iArr2;
                            iArr3 = new int[1];
                            objArr[1] = iArr3;
                            int[] iArr4 = new int[1];
                            objArr[2] = iArr4;
                            int i54 = getARTIFICIAL_FRAME_PACKAGE_NAME + 99;
                            int i55 = i54 % 128;
                            artificialFrame = i55;
                            int i56 = i54 % 2;
                            iArr2[0] = i;
                            i38 = ((i55 | 39) << 1) - (i55 ^ 39);
                            int i57 = i38 % 128;
                            getARTIFICIAL_FRAME_PACKAGE_NAME = i57;
                            if (i38 % 2 != 0) {
                                iArr2[0] = i37;
                                objArr[3] = null;
                            } else {
                                iArr3[0] = i37;
                                objArr[3] = null;
                            }
                            int i58 = (i57 ^ 83) + ((i57 & 83) << 1);
                            artificialFrame = i58 % 128;
                            int i59 = i58 % 2;
                            int i60 = ~i;
                            int i61 = (i2 - (~(((((-460247587) + (((~((-715823206) | i60)) | 536909892) * 98)) + ((((~(i60 | (-262800570))) | (-715823206)) | (~(262800569 | i))) * (-49))) + (((~((-715823206) | i)) | (-799710462)) * 49)) + 16))) - 1;
                            int i62 = i61 << 13;
                            int i63 = ((~i61) & i62) | ((~i62) & i61);
                            int i64 = i63 >>> 17;
                            int i65 = (i63 | i64) & (~(i63 & i64));
                            int i66 = i65 << 5;
                            iArr4[0] = (i65 | i66) & (~(i65 & i66));
                        } else {
                            i47 = ((i47 | 1) << 1) - (i47 ^ 1);
                        }
                    } else if (bool.booleanValue()) {
                        i37 = i ^ 1;
                        objArr = new Object[4];
                        iArr2 = new int[1];
                        objArr[0] = iArr2;
                        iArr3 = new int[1];
                        objArr[1] = iArr3;
                        int[] iArr5 = new int[1];
                        objArr[2] = iArr5;
                        int i510 = getARTIFICIAL_FRAME_PACKAGE_NAME + 99;
                        int i511 = i510 % 128;
                        artificialFrame = i511;
                        int i512 = i510 % 2;
                        iArr2[0] = i;
                        i38 = ((i511 | 39) << 1) - (i511 ^ 39);
                        int i513 = i38 % 128;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i513;
                        if (i38 % 2 != 0) {
                            iArr2[0] = i37;
                            objArr[3] = null;
                        } else {
                            iArr3[0] = i37;
                            objArr[3] = null;
                        }
                        int i514 = (i513 ^ 83) + ((i513 & 83) << 1);
                        artificialFrame = i514 % 128;
                        int i515 = i514 % 2;
                        int i67 = ~i;
                        int i68 = (i2 - (~(((((-460247587) + (((~((-715823206) | i67)) | 536909892) * 98)) + ((((~(i67 | (-262800570))) | (-715823206)) | (~(262800569 | i))) * (-49))) + (((~((-715823206) | i)) | (-799710462)) * 49)) + 16))) - 1;
                        int i69 = i68 << 13;
                        int i610 = ((~i68) & i69) | ((~i69) & i68);
                        int i611 = i610 >>> 17;
                        int i612 = (i610 | i611) & (~(i610 & i611));
                        int i613 = i612 << 5;
                        iArr5[0] = (i612 | i613) & (~(i612 & i613));
                    } else {
                        i47 = ((i47 | 1) << 1) - (i47 ^ 1);
                    }
                } else {
                    objArr = new Object[]{new int[]{i}, new int[]{i}, new int[1], null};
                    int i70 = ~((~i) | 187494762);
                    int i71 = (((544842 | i70) * (-374)) - 17398662) + ((i70 | 186949920) * 374);
                    int i_BOUNDARY2 = TimestampAction._BOUNDARY();
                    int i72 = ~i71;
                    int i73 = ~((~i2) | i72);
                    int i74 = ~(i72 | i_BOUNDARY2);
                    int i75 = (i73 ^ i74) | (i73 & i74);
                    int i76 = ~i2;
                    int i77 = (i71 * 881) + (i2 * 881) + ((i75 | (~((i76 ^ i_BOUNDARY2) | (i76 & i_BOUNDARY2)))) * (-880));
                    int i78 = ~i_BOUNDARY2;
                    int i79 = ~((i72 & i78) | (i72 ^ i78));
                    int i80 = (i79 & i2) | (i2 ^ i79);
                    int i81 = ~((i_BOUNDARY2 & i71) | (i71 ^ i_BOUNDARY2));
                    int i82 = (i77 - (~(-(-(((i80 ^ i81) | (i80 & i81)) * (-880)))))) - 1;
                    int i83 = -(-(i81 * 880));
                    int i84 = ((i82 | i83) << 1) - (i83 ^ i82);
                    int i85 = (i84 << 13) ^ i84;
                    int i86 = i85 >>> 17;
                    int i87 = ((~i85) & i86) | ((~i86) & i85);
                    ((int[]) objArr[2])[0] = i87 ^ (i87 << 5);
                }
                if (i != ((int[]) objArr[1])[0]) {
                    int i88 = getARTIFICIAL_FRAME_PACKAGE_NAME + 61;
                    artificialFrame = i88 % 128;
                    if (i88 % 2 != 0) {
                        return objArr;
                    }
                    int i89 = 32 / 0;
                    return objArr;
                }
                try {
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(590025679);
                    if (objAccessartificialFrame == null) {
                        int edgeSlop = (ViewConfiguration.getEdgeSlop() >> 16) + 9;
                        char c4 = (char) (64611 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)));
                        int i90 = 1807 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
                        byte b = (byte) 0;
                        byte b2 = (byte) (b - 1);
                        Object[] objArr11 = new Object[1];
                        b(b, b2, (byte) (b2 + 1), objArr11);
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(edgeSlop, c4, i90, -1135716921, false, (String) objArr11[0], new Class[0]);
                    }
                    long jLongValue = ((Long) ((Method) objAccessartificialFrame).invoke(null, null)).longValue();
                    long j = -581326916;
                    long j2 = -375;
                    long j3 = (j2 * j) + (j2 * jLongValue);
                    long j4 = 376;
                    long j5 = i;
                    long j6 = -1;
                    long j7 = j ^ j6;
                    long j8 = (j | jLongValue) ^ j6;
                    long j9 = j3 + ((j5 | ((j7 | (jLongValue ^ j6)) ^ j6) | j8) * j4) + (((long) (-376)) * ((((j5 ^ j6) | j) ^ j6) | j8)) + (j4 * (jLongValue | ((j7 | j5) ^ j6))) + ((long) 921534950);
                    int i91 = artificialFrame;
                    int i92 = (i91 & 5) + (i91 | 5);
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i92 % 128;
                    if (i92 % 2 != 0) {
                        int iMyPid = Process.myPid();
                        int i93 = ~iMyPid;
                        i3 = ((int) (j9 >>> 115)) & (501358106 + (((~(845637130 | i93)) | (-2012177995)) * 168) + ((~(2012177994 | iMyPid)) * 168) + (((~(iMyPid | (-1166540865))) | (~(i93 | 2012103754)) | 74240) * 168));
                        i4 = (int) j9;
                        int i94 = ~i;
                        i5 = (-1732272168) + (((~(866079953 | i94)) | 571146456) * (-933)) + (((~(i94 | 571146456)) | 294933505) * 933);
                        i6 = 303691280;
                    } else {
                        int iMyUid = Process.myUid();
                        int i95 = ~iMyUid;
                        i3 = ((int) (j9 >> 32)) & (1972008040 + (((~((-677742921) | i95)) | (~((-759483491) | i95))) * (-867)) + (((~((-677742921) | iMyUid)) | 675579968 | (~((-759483491) | iMyUid))) * (-1734)) + (((~(iMyUid | (-83903523))) | (~(i95 | (-675579969))) | (~((-2162953) | iMyUid))) * 867));
                        i4 = (int) j9;
                        int i96 = ~i;
                        i5 = 1453938690 + (((~(634533098 | i96)) | (-802693312)) * 519) + (((~(i96 | (-168296470))) | (~((-634396843) | i))) * (-519));
                        i6 = ((~((-802693312) | i)) | (-634533099)) * 519;
                    }
                    int i97 = i5 + i6;
                    int i98 = artificialFrame;
                    int i99 = (i98 ^ 75) + ((i98 & 75) << 1);
                    int i100 = i99 % 128;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i100;
                    int i101 = i4 & i97;
                    if (i99 % 2 == 0) {
                        int i102 = (i3 & i101) | (i3 ^ i101);
                        i7 = 1;
                        if (i102 == 1) {
                            int i103 = ~i;
                            i30 = (i & (-11)) | (i103 & 10);
                            objArr6 = new Object[4];
                            int[] iArr6 = new int[i7];
                            objArr6[0] = iArr6;
                            int[] iArr7 = new int[i7];
                            objArr6[i7] = iArr7;
                            objArr6[2] = new int[i7];
                            iArr6[0] = i;
                            iArr = iArr7;
                            int i_BOUNDARY3 = TimestampAction._BOUNDARY();
                            int i104 = ~i_BOUNDARY3;
                            int i105 = ~((174437059 ^ i104) | (174437059 & i104));
                            int i106 = 873495082 + (((i105 & 25183508) | (i105 ^ 25183508)) * 98);
                            int i107 = ~(i104 | 63239956);
                            int i108 = (i107 & 174437059) | (174437059 ^ i107);
                            int i109 = ~(((-63239957) & i_BOUNDARY3) | ((-63239957) ^ i_BOUNDARY3));
                            int i110 = -(-(((i108 & i109) | (i108 ^ i109)) * (-49)));
                            int i111 = ((i106 | i110) << 1) - (i110 ^ i106);
                            int i112 = ~(i_BOUNDARY3 | 174437059);
                            int i113 = ((i112 & 38056448) | (i112 ^ 38056448)) * 49;
                            i31 = (i111 & i113) + (i113 | i111);
                            i32 = 1183801686 + ((((-1073840167) & i103) | ((-1073840167) ^ i103)) * SyslogConstants.LOG_LOCAL7);
                            int i114 = ~((1073118552 & i103) | (i103 ^ 1073118552));
                            i33 = (i114 & 779237656) | (779237656 ^ i114);
                            if (i31 <= i32 + (((i33 & (-2146958719)) | (i33 ^ (-2146958719))) * SyslogConstants.LOG_LOCAL7)) {
                                iArr[1] = i30;
                                objArr6[2] = null;
                                int iElapsedRealtime = (int) SystemClock.elapsedRealtime();
                                int i115 = (-99018298) + (((~((-771247398) | iElapsedRealtime)) | (-207376378)) * (-318));
                                int i116 = ~((-207376378) | iElapsedRealtime);
                                int i117 = ~iElapsedRealtime;
                                i34 = i115 + ((i116 | (~(771510269 | i117))) * TypedValues.AttributesType.TYPE_PIVOT_TARGET);
                                i35 = ((~(iElapsedRealtime | 771510269)) | (~((-262873) | i117))) * TypedValues.AttributesType.TYPE_PIVOT_TARGET;
                            } else {
                                iArr[0] = i30;
                                objArr6[3] = null;
                                int startUptimeMillis = (int) Process.getStartUptimeMillis();
                                int i118 = ~startUptimeMillis;
                                i34 = (((~((-255438495) | i118)) | (~(startUptimeMillis | 723185280))) * 959) - 1423773573;
                                i35 = ((~(startUptimeMillis | (-255438495))) | (~(i118 | 723185280))) * 959;
                            }
                            int i119 = i34 + i35;
                            int i_BOUNDARY4 = TimestampAction._BOUNDARY();
                            int i120 = 14480 + (i119 * (-903));
                            int i121 = ~(((-17) ^ i_BOUNDARY4) | ((-17) & i_BOUNDARY4));
                            int i122 = ~i_BOUNDARY4;
                            int i123 = ~((i122 ^ i119) | (i122 & i119));
                            int i124 = ((i121 & i123) | (i121 ^ i123)) * (-1808);
                            int i125 = ((i120 | i124) << 1) - (i124 ^ i120);
                            int i126 = ~i119;
                            int i127 = ((-17) ^ i126) | ((-17) & i126);
                            int i128 = (i122 ^ 16) | (i122 & 16);
                            int i129 = -(-(((~((i127 & i_BOUNDARY4) | (i127 ^ i_BOUNDARY4))) | (~((i128 & i119) | (i128 ^ i119)))) * TypedValues.Custom.TYPE_BOOLEAN));
                            int i130 = (i125 ^ i129) + ((i129 & i125) << 1);
                            int i131 = ~(((-17) ^ i119) | (i119 & (-17)));
                            int i132 = ~((i_BOUNDARY4 & i126) | (i126 ^ i_BOUNDARY4));
                            int i133 = (i132 & i131) | (i131 ^ i132);
                            int i134 = ~(i122 | 16);
                            int i135 = i130 + (((i133 & i134) | (i133 ^ i134)) * TypedValues.Custom.TYPE_BOOLEAN);
                            int i136 = ~((~i2) | i103);
                            int i137 = ~((i135 ^ i) | (i135 & i));
                            int i138 = (((i135 * 960) + (i2 * (-1917))) - (~(((i136 & i137) | (i136 ^ i137)) * 959))) - 1;
                            int i139 = ~i2;
                            int i140 = i138 + (i139 * (-959));
                            int i141 = ~((i139 & i) | (i139 ^ i));
                            int i142 = ~((~i) | i135);
                            int i143 = i140 + (((i141 & i142) | (i141 ^ i142)) * 959);
                            int i144 = i143 << 13;
                            int i145 = (i143 | i144) & (~(i143 & i144));
                            int i146 = i145 ^ (i145 >>> 17);
                            int i147 = i146 << 5;
                            ((int[]) objArr6[2])[0] = ((~i146) & i147) | ((~i147) & i146);
                            c = 0;
                            objArr2 = objArr6;
                        } else {
                            int i148 = ((i100 | 59) << 1) - (i100 ^ 59);
                            artificialFrame = i148 % 128;
                            int i149 = i148 % 2;
                            objArr2 = new Object[]{new int[]{i}, new int[]{i}, new int[1], null};
                            int i150 = i100 + 105;
                            artificialFrame = i150 % 128;
                            i8 = i150 % 2;
                            i9 = ~i;
                            if (i8 == 0) {
                                i10 = 1133736195 + (((~((-215914916) | i9)) | 762708859) * (-602)) + (((~((-215914916) | i)) | 206962979 | (~(771660795 | i9))) * (-301)) + ((~(i9 | 762708859)) * 301);
                            } else {
                                i10 = ((((~(i9 | 330950804)) | ((~((-647672971) | i9)) | 604115978)) * (-397)) - 1447569894) + ((891509790 | i) * 397);
                            }
                            i_BOUNDARY = TimestampAction._BOUNDARY();
                            int i151 = i10 * 273;
                            int i152 = i2 * (-271);
                            i11 = ((i151 | i152) << 1) - (i151 ^ i152);
                            i12 = ~i10;
                            int i153 = ~i2;
                            int i154 = (i153 & i12) | (i12 ^ i153);
                            int i155 = ~i_BOUNDARY;
                            int i156 = (i154 & i155) | (i154 ^ i155);
                            int i157 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                            int i158 = (i157 ^ 101) + ((i157 & 101) << 1);
                            artificialFrame = i158 % 128;
                            i13 = i158 % 2;
                            i14 = ~i156;
                            if (i13 == 0) {
                                int i159 = (i10 ^ i2) | (i10 & i2);
                                int i160 = ~((i159 & i_BOUNDARY) | (i159 ^ i_BOUNDARY));
                                i15 = i11 >>> ((-272) / ((i14 & i160) | (i14 ^ i160)));
                                i16 = ~((i12 ^ i2) | (i12 & i2));
                            } else {
                                int i161 = i10 | i2;
                                int i162 = -(-((i14 | (~((i161 & i_BOUNDARY) | (i161 ^ i_BOUNDARY)))) * (-272)));
                                i15 = (i162 | i11) + (i11 & i162);
                                i16 = ~(i12 | i2);
                                i12 = ~i10;
                            }
                            int i163 = ~((i12 & i_BOUNDARY) | (i12 ^ i_BOUNDARY));
                            int i164 = (-272) * ((i163 & i16) | (i16 ^ i163));
                            int i165 = ((((i15 | i164) << 1) - (i15 ^ i164)) - (~(-(-(((~(i_BOUNDARY | i10)) | i2) * 272))))) - 1;
                            int i166 = i165 << 13;
                            int i167 = (i166 & (~i165)) | ((~i166) & i165);
                            int i168 = i167 ^ (i167 >>> 17);
                            int i169 = i168 << 5;
                            int i170 = (i168 | i169) & (~(i168 & i169));
                            c = 0;
                            ((int[]) objArr2[2])[0] = i170;
                        }
                    } else if (((i3 & i101) | (i3 ^ i101)) == 0) {
                        i7 = 1;
                        int i1010 = ~i;
                        i30 = (i & (-11)) | (i1010 & 10);
                        objArr6 = new Object[4];
                        int[] iArr8 = new int[i7];
                        objArr6[0] = iArr8;
                        int[] iArr9 = new int[i7];
                        objArr6[i7] = iArr9;
                        objArr6[2] = new int[i7];
                        iArr8[0] = i;
                        iArr = iArr9;
                        int i_BOUNDARY5 = TimestampAction._BOUNDARY();
                        int i1011 = ~i_BOUNDARY5;
                        int i1012 = ~((174437059 ^ i1011) | (174437059 & i1011));
                        int i1013 = 873495082 + (((i1012 & 25183508) | (i1012 ^ 25183508)) * 98);
                        int i1014 = ~(i1011 | 63239956);
                        int i1015 = (i1014 & 174437059) | (174437059 ^ i1014);
                        int i1016 = ~(((-63239957) & i_BOUNDARY5) | ((-63239957) ^ i_BOUNDARY5));
                        int i1110 = -(-(((i1015 & i1016) | (i1015 ^ i1016)) * (-49)));
                        int i1111 = ((i1013 | i1110) << 1) - (i1110 ^ i1013);
                        int i1112 = ~(i_BOUNDARY5 | 174437059);
                        int i1113 = ((i1112 & 38056448) | (i1112 ^ 38056448)) * 49;
                        i31 = (i1111 & i1113) + (i1113 | i1111);
                        i32 = 1183801686 + ((((-1073840167) & i1010) | ((-1073840167) ^ i1010)) * SyslogConstants.LOG_LOCAL7);
                        int i1114 = ~((1073118552 & i1010) | (i1010 ^ 1073118552));
                        i33 = (i1114 & 779237656) | (779237656 ^ i1114);
                        if (i31 <= i32 + (((i33 & (-2146958719)) | (i33 ^ (-2146958719))) * SyslogConstants.LOG_LOCAL7)) {
                            iArr[1] = i30;
                            objArr6[2] = null;
                            int iElapsedRealtime2 = (int) SystemClock.elapsedRealtime();
                            int i1115 = (-99018298) + (((~((-771247398) | iElapsedRealtime2)) | (-207376378)) * (-318));
                            int i1116 = ~((-207376378) | iElapsedRealtime2);
                            int i1117 = ~iElapsedRealtime2;
                            i34 = i1115 + ((i1116 | (~(771510269 | i1117))) * TypedValues.AttributesType.TYPE_PIVOT_TARGET);
                            i35 = ((~(iElapsedRealtime2 | 771510269)) | (~((-262873) | i1117))) * TypedValues.AttributesType.TYPE_PIVOT_TARGET;
                        } else {
                            iArr[0] = i30;
                            objArr6[3] = null;
                            int startUptimeMillis2 = (int) Process.getStartUptimeMillis();
                            int i1118 = ~startUptimeMillis2;
                            i34 = (((~((-255438495) | i1118)) | (~(startUptimeMillis2 | 723185280))) * 959) - 1423773573;
                            i35 = ((~(startUptimeMillis2 | (-255438495))) | (~(i1118 | 723185280))) * 959;
                        }
                        int i1119 = i34 + i35;
                        int i_BOUNDARY6 = TimestampAction._BOUNDARY();
                        int i1210 = 14480 + (i1119 * (-903));
                        int i1211 = ~(((-17) ^ i_BOUNDARY6) | ((-17) & i_BOUNDARY6));
                        int i1212 = ~i_BOUNDARY6;
                        int i1213 = ~((i1212 ^ i1119) | (i1212 & i1119));
                        int i1214 = ((i1211 & i1213) | (i1211 ^ i1213)) * (-1808);
                        int i1215 = ((i1210 | i1214) << 1) - (i1214 ^ i1210);
                        int i1216 = ~i1119;
                        int i1217 = ((-17) ^ i1216) | ((-17) & i1216);
                        int i1218 = (i1212 ^ 16) | (i1212 & 16);
                        int i1219 = -(-(((~((i1217 & i_BOUNDARY6) | (i1217 ^ i_BOUNDARY6))) | (~((i1218 & i1119) | (i1218 ^ i1119)))) * TypedValues.Custom.TYPE_BOOLEAN));
                        int i1310 = (i1215 ^ i1219) + ((i1219 & i1215) << 1);
                        int i1311 = ~(((-17) ^ i1119) | (i1119 & (-17)));
                        int i1312 = ~((i_BOUNDARY6 & i1216) | (i1216 ^ i_BOUNDARY6));
                        int i1313 = (i1312 & i1311) | (i1311 ^ i1312);
                        int i1314 = ~(i1212 | 16);
                        int i1315 = i1310 + (((i1313 & i1314) | (i1313 ^ i1314)) * TypedValues.Custom.TYPE_BOOLEAN);
                        int i1316 = ~((~i2) | i1010);
                        int i1317 = ~((i1315 ^ i) | (i1315 & i));
                        int i1318 = (((i1315 * 960) + (i2 * (-1917))) - (~(((i1316 & i1317) | (i1316 ^ i1317)) * 959))) - 1;
                        int i1319 = ~i2;
                        int i1410 = i1318 + (i1319 * (-959));
                        int i1411 = ~((i1319 & i) | (i1319 ^ i));
                        int i1412 = ~((~i) | i1315);
                        int i1413 = i1410 + (((i1411 & i1412) | (i1411 ^ i1412)) * 959);
                        int i1414 = i1413 << 13;
                        int i1415 = (i1413 | i1414) & (~(i1413 & i1414));
                        int i1416 = i1415 ^ (i1415 >>> 17);
                        int i1417 = i1416 << 5;
                        ((int[]) objArr6[2])[0] = ((~i1416) & i1417) | ((~i1417) & i1416);
                        c = 0;
                        objArr2 = objArr6;
                    } else {
                        int i1418 = ((i100 | 59) << 1) - (i100 ^ 59);
                        artificialFrame = i1418 % 128;
                        int i1419 = i1418 % 2;
                        objArr2 = new Object[]{new int[]{i}, new int[]{i}, new int[1], null};
                        int i1510 = i100 + 105;
                        artificialFrame = i1510 % 128;
                        i8 = i1510 % 2;
                        i9 = ~i;
                        if (i8 == 0) {
                            i10 = 1133736195 + (((~((-215914916) | i9)) | 762708859) * (-602)) + (((~((-215914916) | i)) | 206962979 | (~(771660795 | i9))) * (-301)) + ((~(i9 | 762708859)) * 301);
                        } else {
                            i10 = ((((~(i9 | 330950804)) | ((~((-647672971) | i9)) | 604115978)) * (-397)) - 1447569894) + ((891509790 | i) * 397);
                        }
                        i_BOUNDARY = TimestampAction._BOUNDARY();
                        int i1511 = i10 * 273;
                        int i1512 = i2 * (-271);
                        i11 = ((i1511 | i1512) << 1) - (i1511 ^ i1512);
                        i12 = ~i10;
                        int i1513 = ~i2;
                        int i1514 = (i1513 & i12) | (i12 ^ i1513);
                        int i1515 = ~i_BOUNDARY;
                        int i1516 = (i1514 & i1515) | (i1514 ^ i1515);
                        int i1517 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                        int i1518 = (i1517 ^ 101) + ((i1517 & 101) << 1);
                        artificialFrame = i1518 % 128;
                        i13 = i1518 % 2;
                        i14 = ~i1516;
                        if (i13 == 0) {
                            int i1519 = (i10 ^ i2) | (i10 & i2);
                            int i1610 = ~((i1519 & i_BOUNDARY) | (i1519 ^ i_BOUNDARY));
                            i15 = i11 >>> ((-272) / ((i14 & i1610) | (i14 ^ i1610)));
                            i16 = ~((i12 ^ i2) | (i12 & i2));
                        } else {
                            int i1611 = i10 | i2;
                            int i1612 = -(-((i14 | (~((i1611 & i_BOUNDARY) | (i1611 ^ i_BOUNDARY)))) * (-272)));
                            i15 = (i1612 | i11) + (i11 & i1612);
                            i16 = ~(i12 | i2);
                            i12 = ~i10;
                        }
                        int i1613 = ~((i12 & i_BOUNDARY) | (i12 ^ i_BOUNDARY));
                        int i1614 = (-272) * ((i1613 & i16) | (i16 ^ i1613));
                        int i1615 = ((((i15 | i1614) << 1) - (i15 ^ i1614)) - (~(-(-(((~(i_BOUNDARY | i10)) | i2) * 272))))) - 1;
                        int i1616 = i1615 << 13;
                        int i1617 = (i1616 & (~i1615)) | ((~i1616) & i1615);
                        int i1618 = i1617 ^ (i1617 >>> 17);
                        int i1619 = i1618 << 5;
                        int i171 = (i1618 | i1619) & (~(i1618 & i1619));
                        c = 0;
                        ((int[]) objArr2[2])[0] = i171;
                    }
                    if (i != ((int[]) objArr2[1])[c]) {
                        int i172 = getARTIFICIAL_FRAME_PACKAGE_NAME + 53;
                        artificialFrame = i172 % 128;
                        if (i172 % 2 == 0) {
                            throw null;
                        }
                    } else {
                        try {
                            int i173 = -View.MeasureSpec.makeMeasureSpec(0, 0);
                            int i174 = i173 * 866;
                            int i175 = (i174 & (-864)) + (i174 | (-864));
                            int i176 = ~i173;
                            int i177 = ~i;
                            int i178 = ~(i176 | i177);
                            int i179 = ((i178 & (-2)) | ((-2) ^ i178)) * (-865);
                            int i180 = (i175 ^ i179) + ((i179 & i175) << 1);
                            int i181 = (~((i173 ^ i) | (i173 & i))) * 865;
                            int i182 = (i180 & i181) + (i181 | i180);
                            int i183 = ~(((-2) ^ i177) | ((-2) & i177));
                            int i184 = ~(i173 | i177);
                            Object[] objArr12 = new Object[1];
                            a(i182 + (((i184 & i183) | (i183 ^ i184)) * 865), new char[]{58364, 58323, 55736, 15054, 53962, 32446, 28615, 46794, 5305, 55234, 18114, 58003, 64442, 8944, 51943, 5850, 18340, 24220, 32413, 39676, 54219, 51906, 58007, 3823, 24569, 18098, 38590, 45791, 44003, 62186, 6744, 9776, 14082, 28251, 36426, 43575, 33576, 39490, 12903, 56863, 3881, 5730, 42594, 17011}, objArr12);
                            File file3 = new File((String) objArr12[0]);
                            int i185 = artificialFrame + 47;
                            getARTIFICIAL_FRAME_PACKAGE_NAME = i185 % 128;
                            if (i185 % 2 != 0) {
                                int i186 = 75 / 0;
                                try {
                                    if (file3.canRead()) {
                                        fileReader3 = new FileReader(file3);
                                        bufferedReader3 = new BufferedReader(fileReader3);
                                        try {
                                            line = bufferedReader3.readLine();
                                            float maxVolume = AudioTrack.getMaxVolume();
                                            i27 = artificialFrame + 43;
                                            getARTIFICIAL_FRAME_PACKAGE_NAME = i27 % 128;
                                            i28 = (maxVolume > 0.0f ? 1 : (maxVolume == 0.0f ? 0 : -1));
                                            if (i27 % 2 != 0) {
                                                objArr5 = new Object[1];
                                                a(i28, new char[]{28228, 28202, 4336, 62362, 33580, 17750, 59347}, objArr5);
                                                if (line.equals((String) objArr5[0])) {
                                                    fileReader3.close();
                                                    bufferedReader3.close();
                                                } else {
                                                    int i187 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                                    i29 = (i187 ^ 13) + ((i187 & 13) << 1);
                                                    artificialFrame = i29 % 128;
                                                    if (i29 % 2 != 0) {
                                                        fileReader3.close();
                                                        bufferedReader3.close();
                                                        throw null;
                                                    }
                                                    fileReader3.close();
                                                    bufferedReader3.close();
                                                    str = line;
                                                }
                                                int iIndexOf = TextUtils.indexOf("", "", 0);
                                                Object[] objArr13 = new Object[1];
                                                a((iIndexOf & 1) + (iIndexOf | 1), new char[]{38539, 38564, 22414, 46331, 36916, 49189, 6908, 14520, 22092, 26949, 1057, 23583, 36560, 44172, 34837, 43031, 12997, 53409, 15471, 9314, 42740, 17597, 41058, 45160, 10894, 51332, 54343, 3177, 56982, 31901, 22703, 39072, 17003, 57466, 52414}, objArr13);
                                                file = new File((String) objArr13[0]);
                                                if (!file.canRead()) {
                                                    fileReader = new FileReader(file);
                                                    bufferedReader = new BufferedReader(fileReader);
                                                    try {
                                                        String line2 = bufferedReader.readLine();
                                                        int jumpTapTimeout = ViewConfiguration.getJumpTapTimeout() >> 16;
                                                        int i188 = ~jumpTapTimeout;
                                                        int i189 = ~(((-2) ^ i) | ((-2) & i));
                                                        int i190 = (jumpTapTimeout * (-947)) + 949 + (((i189 & i188) | (i188 ^ i189)) * (-948));
                                                        int i191 = i188 | (-2);
                                                        int i192 = ~i;
                                                        int i193 = -(-((~((i191 & i192) | (i191 ^ i192))) * (-948)));
                                                        int i194 = (i190 ^ i193) + ((i190 & i193) << 1);
                                                        int i195 = artificialFrame;
                                                        int i196 = (i195 ^ 117) + ((i195 & 117) << 1);
                                                        getARTIFICIAL_FRAME_PACKAGE_NAME = i196 % 128;
                                                        int i197 = i196 % 2;
                                                        int i198 = -(-(948 * (((-2) & jumpTapTimeout) | (jumpTapTimeout ^ (-2)))));
                                                        Object[] objArr14 = new Object[1];
                                                        a((i194 & i198) + (i198 | i194), new char[]{64993, 64976, 4418, 45481, 45093}, objArr14);
                                                        zEquals = line2.equals((String) objArr14[0]);
                                                        fileReader.close();
                                                        bufferedReader.close();
                                                        if (zEquals) {
                                                            int i199 = -(-Drawable.resolveOpacity(0, 0));
                                                            Object[] objArr15 = new Object[1];
                                                            a((i199 ^ 1) + ((i199 & 1) << 1), new char[]{62601, 62630, 65304, 7278, 51128, 59637, 30898, 36970, 459, 16777, 21424, 29912, 60623, 1104, 57237, 32913, 20689, 30780, 27631, 3255, 50366, 60514, 63461, 39076, 18572, 24594, 33740, 9364, 48278, 54346, 3901, 45180, 8292, 18666, 39732, 15484, 37966, 48354, 9998, 18504}, objArr15);
                                                            file2 = new File((String) objArr15[0]);
                                                            if (!file2.canRead()) {
                                                                fileReader2 = new FileReader(file2);
                                                                bufferedReader2 = new BufferedReader(fileReader2);
                                                                try {
                                                                    String line3 = bufferedReader2.readLine();
                                                                    Object[] objArr16 = new Object[1];
                                                                    a((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), new char[]{64993, 64976, 4418, 45481, 45093}, objArr16);
                                                                    zEquals2 = line3.equals((String) objArr16[0]);
                                                                    fileReader2.close();
                                                                    bufferedReader2.close();
                                                                    if (zEquals2) {
                                                                        i17 = artificialFrame;
                                                                        int i200 = i17 + 37;
                                                                        getARTIFICIAL_FRAME_PACKAGE_NAME = i200 % 128;
                                                                        int i201 = i200 % 2;
                                                                        if (str != null) {
                                                                            i18 = (i17 & 117) + (i17 | 117);
                                                                            getARTIFICIAL_FRAME_PACKAGE_NAME = i18 % 128;
                                                                            if (i18 % 2 != 0) {
                                                                                i19 = (i & (-90)) | ((~i) & 89);
                                                                                Object[] objArr17 = new Object[2];
                                                                                c2 = 1;
                                                                                objArr17[1] = new int[1];
                                                                                objArr17[1] = new int[1];
                                                                                objArr17[4] = new int[1];
                                                                                objArr3 = objArr17;
                                                                                c3 = 0;
                                                                            } else {
                                                                                c2 = 1;
                                                                                i19 = (~(i & 20)) & (i | 20);
                                                                                Object[] objArr18 = new Object[4];
                                                                                c3 = 0;
                                                                                objArr18[0] = new int[1];
                                                                                objArr18[1] = new int[1];
                                                                                objArr18[2] = new int[1];
                                                                                objArr3 = objArr18;
                                                                            }
                                                                            ((int[]) objArr3[c3])[c3] = i;
                                                                            ((int[]) objArr3[c2])[c3] = i19;
                                                                            objArr3[3] = str;
                                                                            int i202 = ~i;
                                                                            i20 = ((((~((-709434913) | i202)) | (~(i | 269188862))) * 959) - 310542209) + (((~(i202 | 269188862)) | (~(i | (-709434913)))) * 959);
                                                                            int i_BOUNDARY7 = TimestampAction._BOUNDARY();
                                                                            int i203 = i20 * (-1527);
                                                                            int i204 = ((12240 | i203) << 1) - (i203 ^ 12240);
                                                                            int i205 = ~i_BOUNDARY7;
                                                                            i21 = ~((i205 & 16) | (i205 ^ 16));
                                                                            i22 = i204 + (((i20 ^ i21) | (i20 & i21)) * 764);
                                                                            i23 = ~(((-17) ^ i20) | ((-17) & i20));
                                                                            int i206 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                                                            int i207 = (i206 ^ 73) + ((i206 & 73) << 1);
                                                                            artificialFrame = i207 % 128;
                                                                            i24 = i207 % 2;
                                                                            i25 = ~i_BOUNDARY7;
                                                                            if (i24 == 0) {
                                                                                int i208 = ~((i25 ^ i20) | (i25 & i20));
                                                                                int i209 = i22 / ((-1528) / ((i208 & i23) | (i23 ^ i208)));
                                                                                int i210 = ~((-17) | i20);
                                                                                int i211 = ~((~i20) | 16);
                                                                                int i212 = (i210 & i211) | (i210 ^ i211);
                                                                                int i213 = ~((i25 & 16) | (i25 ^ 16));
                                                                                i26 = i209 * (764 % ((i213 & i212) | (i212 ^ i213)));
                                                                            } else {
                                                                                int i214 = -(-(((~(i25 | i20)) | i23) * (-1528)));
                                                                                int i215 = (i22 ^ i214) + ((i214 & i22) << 1);
                                                                                int i216 = ~(((-17) ^ i20) | ((-17) & i20));
                                                                                int i217 = ~((~i20) | 16);
                                                                                int i218 = (i216 & i217) | (i216 ^ i217);
                                                                                int i219 = -(-(((i218 & i21) | (i218 ^ i21)) * 764));
                                                                                i26 = ((i215 | i219) << 1) - (i219 ^ i215);
                                                                            }
                                                                            int i_BOUNDARY8 = TimestampAction._BOUNDARY();
                                                                            int i220 = i26 * 765;
                                                                            int i221 = i2 * (-1527);
                                                                            int i222 = (i220 & i221) + (i220 | i221);
                                                                            int i223 = ~i_BOUNDARY8;
                                                                            int i224 = ~(i223 | i26);
                                                                            int i225 = ((i224 & i2) | (i2 ^ i224)) * 764;
                                                                            int i226 = (i222 ^ i225) + ((i225 & i222) << 1);
                                                                            int i227 = ~i26;
                                                                            int i228 = (i227 & i2) | (i227 ^ i2);
                                                                            int i229 = ~i228;
                                                                            int i230 = ~(i223 | i2);
                                                                            int i231 = i226 + (((i230 & i229) | (i229 ^ i230)) * (-1528));
                                                                            int i232 = ~i228;
                                                                            int i233 = ~i2;
                                                                            int i234 = ~((i233 & i26) | (i233 ^ i26));
                                                                            int i235 = (i232 & i234) | (i232 ^ i234);
                                                                            int i236 = ~i_BOUNDARY8;
                                                                            int i237 = ~((i236 & i26) | (i236 ^ i26));
                                                                            int i238 = ((i237 & i235) | (i235 ^ i237)) * 764;
                                                                            int i239 = ((i231 | i238) << 1) - (i238 ^ i231);
                                                                            int i240 = i239 << 13;
                                                                            int i241 = (i240 | i239) & (~(i239 & i240));
                                                                            int i242 = i241 >>> 17;
                                                                            int i243 = ((~i241) & i242) | ((~i242) & i241);
                                                                            int i244 = i243 << 5;
                                                                            ((int[]) objArr3[2])[0] = ((~i243) & i244) | ((~i244) & i243);
                                                                            int i245 = artificialFrame + 67;
                                                                            getARTIFICIAL_FRAME_PACKAGE_NAME = i245 % 128;
                                                                            int i246 = i245 % 2;
                                                                            return objArr3;
                                                                        }
                                                                    }
                                                                } catch (Throwable th) {
                                                                    fileReader2.close();
                                                                    bufferedReader2.close();
                                                                    throw th;
                                                                }
                                                            }
                                                        }
                                                    } catch (Throwable th2) {
                                                        fileReader.close();
                                                        bufferedReader.close();
                                                        throw th2;
                                                    }
                                                }
                                                objArr2 = new Object[]{new int[]{i}, new int[]{i}, new int[]{(i | i) & (~(i & i))}, null};
                                                int i247 = ~((-459455059) | i);
                                                int i248 = ~i;
                                                int i249 = (-1790284894) + ((i247 | (~(536083166 | i248))) * (-406)) + ((~((-16914451) | i248)) * (-406)) + (((~((-519168717) | i)) | (~(459455058 | i248))) * 406);
                                                int i250 = (-1) - (~(i249 * (-978)));
                                                int i251 = ~i249;
                                                int i252 = -(-((~((i248 & i251) | (i251 ^ i248))) * 979));
                                                int i253 = ((((i250 | i252) << 1) - (i250 ^ i252)) - (~(i * (-979)))) - 1;
                                                int i254 = ~i249;
                                                int i255 = ~((i254 & i) | (i254 ^ i));
                                                int i256 = ~(~i);
                                                int i257 = -(-(((i256 & i255) | (i255 ^ i256)) * 979));
                                                int i258 = -(-((i253 & i257) + (i257 | i253)));
                                                int i259 = (i2 ^ i258) + ((i258 & i2) << 1);
                                                int i260 = i259 << 13;
                                                int i261 = (i260 & (~i259)) | ((~i260) & i259);
                                                int i262 = i261 >>> 17;
                                                int i263 = ((~i261) & i262) | ((~i262) & i261);
                                                int i264 = i263 << 5;
                                            } else {
                                                objArr4 = new Object[1];
                                                a(i28, new char[]{28228, 28202, 4336, 62362, 33580, 17750, 59347}, objArr4);
                                                if (line.equals((String) objArr4[0])) {
                                                    fileReader3.close();
                                                    bufferedReader3.close();
                                                } else {
                                                    int i1810 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                                    i29 = (i1810 ^ 13) + ((i1810 & 13) << 1);
                                                    artificialFrame = i29 % 128;
                                                    if (i29 % 2 != 0) {
                                                        fileReader3.close();
                                                        bufferedReader3.close();
                                                        throw null;
                                                    }
                                                    fileReader3.close();
                                                    bufferedReader3.close();
                                                    str = line;
                                                }
                                                int iIndexOf2 = TextUtils.indexOf("", "", 0);
                                                Object[] objArr19 = new Object[1];
                                                a((iIndexOf2 & 1) + (iIndexOf2 | 1), new char[]{38539, 38564, 22414, 46331, 36916, 49189, 6908, 14520, 22092, 26949, 1057, 23583, 36560, 44172, 34837, 43031, 12997, 53409, 15471, 9314, 42740, 17597, 41058, 45160, 10894, 51332, 54343, 3177, 56982, 31901, 22703, 39072, 17003, 57466, 52414}, objArr19);
                                                file = new File((String) objArr19[0]);
                                                if (!file.canRead()) {
                                                    fileReader = new FileReader(file);
                                                    bufferedReader = new BufferedReader(fileReader);
                                                    String line4 = bufferedReader.readLine();
                                                    int jumpTapTimeout2 = ViewConfiguration.getJumpTapTimeout() >> 16;
                                                    int i1811 = ~jumpTapTimeout2;
                                                    int i1812 = ~(((-2) ^ i) | ((-2) & i));
                                                    int i1910 = (jumpTapTimeout2 * (-947)) + 949 + (((i1812 & i1811) | (i1811 ^ i1812)) * (-948));
                                                    int i1911 = i1811 | (-2);
                                                    int i1912 = ~i;
                                                    int i1913 = -(-((~((i1911 & i1912) | (i1911 ^ i1912))) * (-948)));
                                                    int i1914 = (i1910 ^ i1913) + ((i1910 & i1913) << 1);
                                                    int i1915 = artificialFrame;
                                                    int i1916 = (i1915 ^ 117) + ((i1915 & 117) << 1);
                                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i1916 % 128;
                                                    int i1917 = i1916 % 2;
                                                    int i1918 = -(-(948 * (((-2) & jumpTapTimeout2) | (jumpTapTimeout2 ^ (-2)))));
                                                    Object[] objArr110 = new Object[1];
                                                    a((i1914 & i1918) + (i1918 | i1914), new char[]{64993, 64976, 4418, 45481, 45093}, objArr110);
                                                    zEquals = line4.equals((String) objArr110[0]);
                                                    fileReader.close();
                                                    bufferedReader.close();
                                                    if (zEquals) {
                                                        int i1919 = -(-Drawable.resolveOpacity(0, 0));
                                                        Object[] objArr111 = new Object[1];
                                                        a((i1919 ^ 1) + ((i1919 & 1) << 1), new char[]{62601, 62630, 65304, 7278, 51128, 59637, 30898, 36970, 459, 16777, 21424, 29912, 60623, 1104, 57237, 32913, 20689, 30780, 27631, 3255, 50366, 60514, 63461, 39076, 18572, 24594, 33740, 9364, 48278, 54346, 3901, 45180, 8292, 18666, 39732, 15484, 37966, 48354, 9998, 18504}, objArr111);
                                                        file2 = new File((String) objArr111[0]);
                                                        if (!file2.canRead()) {
                                                            fileReader2 = new FileReader(file2);
                                                            bufferedReader2 = new BufferedReader(fileReader2);
                                                            String line5 = bufferedReader2.readLine();
                                                            Object[] objArr112 = new Object[1];
                                                            a((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), new char[]{64993, 64976, 4418, 45481, 45093}, objArr112);
                                                            zEquals2 = line5.equals((String) objArr112[0]);
                                                            fileReader2.close();
                                                            bufferedReader2.close();
                                                            if (zEquals2) {
                                                                i17 = artificialFrame;
                                                                int i2010 = i17 + 37;
                                                                getARTIFICIAL_FRAME_PACKAGE_NAME = i2010 % 128;
                                                                int i2011 = i2010 % 2;
                                                                if (str != null) {
                                                                    i18 = (i17 & 117) + (i17 | 117);
                                                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i18 % 128;
                                                                    if (i18 % 2 != 0) {
                                                                        i19 = (i & (-90)) | ((~i) & 89);
                                                                        Object[] objArr113 = new Object[2];
                                                                        c2 = 1;
                                                                        objArr113[1] = new int[1];
                                                                        objArr113[1] = new int[1];
                                                                        objArr113[4] = new int[1];
                                                                        objArr3 = objArr113;
                                                                        c3 = 0;
                                                                    } else {
                                                                        c2 = 1;
                                                                        i19 = (~(i & 20)) & (i | 20);
                                                                        Object[] objArr114 = new Object[4];
                                                                        c3 = 0;
                                                                        objArr114[0] = new int[1];
                                                                        objArr114[1] = new int[1];
                                                                        objArr114[2] = new int[1];
                                                                        objArr3 = objArr114;
                                                                    }
                                                                    ((int[]) objArr3[c3])[c3] = i;
                                                                    ((int[]) objArr3[c2])[c3] = i19;
                                                                    objArr3[3] = str;
                                                                    int i2012 = ~i;
                                                                    i20 = ((((~((-709434913) | i2012)) | (~(i | 269188862))) * 959) - 310542209) + (((~(i2012 | 269188862)) | (~(i | (-709434913)))) * 959);
                                                                    int i_BOUNDARY9 = TimestampAction._BOUNDARY();
                                                                    int i2013 = i20 * (-1527);
                                                                    int i2014 = ((12240 | i2013) << 1) - (i2013 ^ 12240);
                                                                    int i2015 = ~i_BOUNDARY9;
                                                                    i21 = ~((i2015 & 16) | (i2015 ^ 16));
                                                                    i22 = i2014 + (((i20 ^ i21) | (i20 & i21)) * 764);
                                                                    i23 = ~(((-17) ^ i20) | ((-17) & i20));
                                                                    int i2016 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                                                    int i2017 = (i2016 ^ 73) + ((i2016 & 73) << 1);
                                                                    artificialFrame = i2017 % 128;
                                                                    i24 = i2017 % 2;
                                                                    i25 = ~i_BOUNDARY9;
                                                                    if (i24 == 0) {
                                                                        int i2018 = ~((i25 ^ i20) | (i25 & i20));
                                                                        int i2019 = i22 / ((-1528) / ((i2018 & i23) | (i23 ^ i2018)));
                                                                        int i2110 = ~((-17) | i20);
                                                                        int i2111 = ~((~i20) | 16);
                                                                        int i2112 = (i2110 & i2111) | (i2110 ^ i2111);
                                                                        int i2113 = ~((i25 & 16) | (i25 ^ 16));
                                                                        i26 = i2019 * (764 % ((i2113 & i2112) | (i2112 ^ i2113)));
                                                                    } else {
                                                                        int i2114 = -(-(((~(i25 | i20)) | i23) * (-1528)));
                                                                        int i2115 = (i22 ^ i2114) + ((i2114 & i22) << 1);
                                                                        int i2116 = ~(((-17) ^ i20) | ((-17) & i20));
                                                                        int i2117 = ~((~i20) | 16);
                                                                        int i2118 = (i2116 & i2117) | (i2116 ^ i2117);
                                                                        int i2119 = -(-(((i2118 & i21) | (i2118 ^ i21)) * 764));
                                                                        i26 = ((i2115 | i2119) << 1) - (i2119 ^ i2115);
                                                                    }
                                                                    int i_BOUNDARY10 = TimestampAction._BOUNDARY();
                                                                    int i2210 = i26 * 765;
                                                                    int i2211 = i2 * (-1527);
                                                                    int i2212 = (i2210 & i2211) + (i2210 | i2211);
                                                                    int i2213 = ~i_BOUNDARY10;
                                                                    int i2214 = ~(i2213 | i26);
                                                                    int i2215 = ((i2214 & i2) | (i2 ^ i2214)) * 764;
                                                                    int i2216 = (i2212 ^ i2215) + ((i2215 & i2212) << 1);
                                                                    int i2217 = ~i26;
                                                                    int i2218 = (i2217 & i2) | (i2217 ^ i2);
                                                                    int i2219 = ~i2218;
                                                                    int i2310 = ~(i2213 | i2);
                                                                    int i2311 = i2216 + (((i2310 & i2219) | (i2219 ^ i2310)) * (-1528));
                                                                    int i2312 = ~i2218;
                                                                    int i2313 = ~i2;
                                                                    int i2314 = ~((i2313 & i26) | (i2313 ^ i26));
                                                                    int i2315 = (i2312 & i2314) | (i2312 ^ i2314);
                                                                    int i2316 = ~i_BOUNDARY10;
                                                                    int i2317 = ~((i2316 & i26) | (i2316 ^ i26));
                                                                    int i2318 = ((i2317 & i2315) | (i2315 ^ i2317)) * 764;
                                                                    int i2319 = ((i2311 | i2318) << 1) - (i2318 ^ i2311);
                                                                    int i2410 = i2319 << 13;
                                                                    int i2411 = (i2410 | i2319) & (~(i2319 & i2410));
                                                                    int i2412 = i2411 >>> 17;
                                                                    int i2413 = ((~i2411) & i2412) | ((~i2412) & i2411);
                                                                    int i2414 = i2413 << 5;
                                                                    ((int[]) objArr3[2])[0] = ((~i2413) & i2414) | ((~i2414) & i2413);
                                                                    int i2415 = artificialFrame + 67;
                                                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i2415 % 128;
                                                                    int i2416 = i2415 % 2;
                                                                    return objArr3;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                                objArr2 = new Object[]{new int[]{i}, new int[]{i}, new int[]{(i263 | i264) & (~(i263 & i264))}, null};
                                                int i2417 = ~((-459455059) | i);
                                                int i2418 = ~i;
                                                int i2419 = (-1790284894) + ((i2417 | (~(536083166 | i2418))) * (-406)) + ((~((-16914451) | i2418)) * (-406)) + (((~((-519168717) | i)) | (~(459455058 | i2418))) * 406);
                                                int i2510 = (-1) - (~(i2419 * (-978)));
                                                int i2511 = ~i2419;
                                                int i2512 = -(-((~((i2418 & i2511) | (i2511 ^ i2418))) * 979));
                                                int i2513 = ((((i2510 | i2512) << 1) - (i2510 ^ i2512)) - (~(i * (-979)))) - 1;
                                                int i2514 = ~i2419;
                                                int i2515 = ~((i2514 & i) | (i2514 ^ i));
                                                int i2516 = ~(~i);
                                                int i2517 = -(-(((i2516 & i2515) | (i2515 ^ i2516)) * 979));
                                                int i2518 = -(-((i2513 & i2517) + (i2517 | i2513)));
                                                int i2519 = (i2 ^ i2518) + ((i2518 & i2) << 1);
                                                int i265 = i2519 << 13;
                                                int i266 = (i265 & (~i2519)) | ((~i265) & i2519);
                                                int i267 = i266 >>> 17;
                                                int i268 = ((~i266) & i267) | ((~i267) & i266);
                                                int i269 = i268 << 5;
                                            }
                                        } catch (Throwable th3) {
                                            fileReader3.close();
                                            bufferedReader3.close();
                                            throw th3;
                                        }
                                    } else {
                                        int i270 = artificialFrame + 125;
                                        getARTIFICIAL_FRAME_PACKAGE_NAME = i270 % 128;
                                        int i271 = i270 % 2;
                                    }
                                    int iIndexOf3 = TextUtils.indexOf("", "", 0);
                                    Object[] objArr115 = new Object[1];
                                    a((iIndexOf3 & 1) + (iIndexOf3 | 1), new char[]{38539, 38564, 22414, 46331, 36916, 49189, 6908, 14520, 22092, 26949, 1057, 23583, 36560, 44172, 34837, 43031, 12997, 53409, 15471, 9314, 42740, 17597, 41058, 45160, 10894, 51332, 54343, 3177, 56982, 31901, 22703, 39072, 17003, 57466, 52414}, objArr115);
                                    file = new File((String) objArr115[0]);
                                    if (!file.canRead()) {
                                        fileReader = new FileReader(file);
                                        bufferedReader = new BufferedReader(fileReader);
                                        String line6 = bufferedReader.readLine();
                                        int jumpTapTimeout3 = ViewConfiguration.getJumpTapTimeout() >> 16;
                                        int i1813 = ~jumpTapTimeout3;
                                        int i1814 = ~(((-2) ^ i) | ((-2) & i));
                                        int i19110 = (jumpTapTimeout3 * (-947)) + 949 + (((i1814 & i1813) | (i1813 ^ i1814)) * (-948));
                                        int i19111 = i1813 | (-2);
                                        int i19112 = ~i;
                                        int i19113 = -(-((~((i19111 & i19112) | (i19111 ^ i19112))) * (-948)));
                                        int i19114 = (i19110 ^ i19113) + ((i19110 & i19113) << 1);
                                        int i19115 = artificialFrame;
                                        int i19116 = (i19115 ^ 117) + ((i19115 & 117) << 1);
                                        getARTIFICIAL_FRAME_PACKAGE_NAME = i19116 % 128;
                                        int i19117 = i19116 % 2;
                                        int i19118 = -(-(948 * (((-2) & jumpTapTimeout3) | (jumpTapTimeout3 ^ (-2)))));
                                        Object[] objArr116 = new Object[1];
                                        a((i19114 & i19118) + (i19118 | i19114), new char[]{64993, 64976, 4418, 45481, 45093}, objArr116);
                                        zEquals = line6.equals((String) objArr116[0]);
                                        fileReader.close();
                                        bufferedReader.close();
                                        if (zEquals) {
                                            int i19119 = -(-Drawable.resolveOpacity(0, 0));
                                            Object[] objArr117 = new Object[1];
                                            a((i19119 ^ 1) + ((i19119 & 1) << 1), new char[]{62601, 62630, 65304, 7278, 51128, 59637, 30898, 36970, 459, 16777, 21424, 29912, 60623, 1104, 57237, 32913, 20689, 30780, 27631, 3255, 50366, 60514, 63461, 39076, 18572, 24594, 33740, 9364, 48278, 54346, 3901, 45180, 8292, 18666, 39732, 15484, 37966, 48354, 9998, 18504}, objArr117);
                                            file2 = new File((String) objArr117[0]);
                                            if (!file2.canRead()) {
                                                fileReader2 = new FileReader(file2);
                                                bufferedReader2 = new BufferedReader(fileReader2);
                                                String line7 = bufferedReader2.readLine();
                                                Object[] objArr118 = new Object[1];
                                                a((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), new char[]{64993, 64976, 4418, 45481, 45093}, objArr118);
                                                zEquals2 = line7.equals((String) objArr118[0]);
                                                fileReader2.close();
                                                bufferedReader2.close();
                                                if (zEquals2) {
                                                    i17 = artificialFrame;
                                                    int i20110 = i17 + 37;
                                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i20110 % 128;
                                                    int i20111 = i20110 % 2;
                                                    if (str != null) {
                                                        i18 = (i17 & 117) + (i17 | 117);
                                                        getARTIFICIAL_FRAME_PACKAGE_NAME = i18 % 128;
                                                        if (i18 % 2 != 0) {
                                                            i19 = (i & (-90)) | ((~i) & 89);
                                                            Object[] objArr119 = new Object[2];
                                                            c2 = 1;
                                                            objArr119[1] = new int[1];
                                                            objArr119[1] = new int[1];
                                                            objArr119[4] = new int[1];
                                                            objArr3 = objArr119;
                                                            c3 = 0;
                                                        } else {
                                                            c2 = 1;
                                                            i19 = (~(i & 20)) & (i | 20);
                                                            Object[] objArr1110 = new Object[4];
                                                            c3 = 0;
                                                            objArr1110[0] = new int[1];
                                                            objArr1110[1] = new int[1];
                                                            objArr1110[2] = new int[1];
                                                            objArr3 = objArr1110;
                                                        }
                                                        ((int[]) objArr3[c3])[c3] = i;
                                                        ((int[]) objArr3[c2])[c3] = i19;
                                                        objArr3[3] = str;
                                                        int i20112 = ~i;
                                                        i20 = ((((~((-709434913) | i20112)) | (~(i | 269188862))) * 959) - 310542209) + (((~(i20112 | 269188862)) | (~(i | (-709434913)))) * 959);
                                                        int i_BOUNDARY11 = TimestampAction._BOUNDARY();
                                                        int i20113 = i20 * (-1527);
                                                        int i20114 = ((12240 | i20113) << 1) - (i20113 ^ 12240);
                                                        int i20115 = ~i_BOUNDARY11;
                                                        i21 = ~((i20115 & 16) | (i20115 ^ 16));
                                                        i22 = i20114 + (((i20 ^ i21) | (i20 & i21)) * 764);
                                                        i23 = ~(((-17) ^ i20) | ((-17) & i20));
                                                        int i20116 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                                        int i20117 = (i20116 ^ 73) + ((i20116 & 73) << 1);
                                                        artificialFrame = i20117 % 128;
                                                        i24 = i20117 % 2;
                                                        i25 = ~i_BOUNDARY11;
                                                        if (i24 == 0) {
                                                            int i20118 = ~((i25 ^ i20) | (i25 & i20));
                                                            int i20119 = i22 / ((-1528) / ((i20118 & i23) | (i23 ^ i20118)));
                                                            int i21110 = ~((-17) | i20);
                                                            int i21111 = ~((~i20) | 16);
                                                            int i21112 = (i21110 & i21111) | (i21110 ^ i21111);
                                                            int i21113 = ~((i25 & 16) | (i25 ^ 16));
                                                            i26 = i20119 * (764 % ((i21113 & i21112) | (i21112 ^ i21113)));
                                                        } else {
                                                            int i21114 = -(-(((~(i25 | i20)) | i23) * (-1528)));
                                                            int i21115 = (i22 ^ i21114) + ((i21114 & i22) << 1);
                                                            int i21116 = ~(((-17) ^ i20) | ((-17) & i20));
                                                            int i21117 = ~((~i20) | 16);
                                                            int i21118 = (i21116 & i21117) | (i21116 ^ i21117);
                                                            int i21119 = -(-(((i21118 & i21) | (i21118 ^ i21)) * 764));
                                                            i26 = ((i21115 | i21119) << 1) - (i21119 ^ i21115);
                                                        }
                                                        int i_BOUNDARY12 = TimestampAction._BOUNDARY();
                                                        int i22110 = i26 * 765;
                                                        int i22111 = i2 * (-1527);
                                                        int i22112 = (i22110 & i22111) + (i22110 | i22111);
                                                        int i22113 = ~i_BOUNDARY12;
                                                        int i22114 = ~(i22113 | i26);
                                                        int i22115 = ((i22114 & i2) | (i2 ^ i22114)) * 764;
                                                        int i22116 = (i22112 ^ i22115) + ((i22115 & i22112) << 1);
                                                        int i22117 = ~i26;
                                                        int i22118 = (i22117 & i2) | (i22117 ^ i2);
                                                        int i22119 = ~i22118;
                                                        int i23110 = ~(i22113 | i2);
                                                        int i23111 = i22116 + (((i23110 & i22119) | (i22119 ^ i23110)) * (-1528));
                                                        int i23112 = ~i22118;
                                                        int i23113 = ~i2;
                                                        int i23114 = ~((i23113 & i26) | (i23113 ^ i26));
                                                        int i23115 = (i23112 & i23114) | (i23112 ^ i23114);
                                                        int i23116 = ~i_BOUNDARY12;
                                                        int i23117 = ~((i23116 & i26) | (i23116 ^ i26));
                                                        int i23118 = ((i23117 & i23115) | (i23115 ^ i23117)) * 764;
                                                        int i23119 = ((i23111 | i23118) << 1) - (i23118 ^ i23111);
                                                        int i24110 = i23119 << 13;
                                                        int i24111 = (i24110 | i23119) & (~(i23119 & i24110));
                                                        int i24112 = i24111 >>> 17;
                                                        int i24113 = ((~i24111) & i24112) | ((~i24112) & i24111);
                                                        int i24114 = i24113 << 5;
                                                        ((int[]) objArr3[2])[0] = ((~i24113) & i24114) | ((~i24114) & i24113);
                                                        int i24115 = artificialFrame + 67;
                                                        getARTIFICIAL_FRAME_PACKAGE_NAME = i24115 % 128;
                                                        int i24116 = i24115 % 2;
                                                        return objArr3;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } catch (Exception unused) {
                                }
                                str = null;
                                objArr2 = new Object[]{new int[]{i}, new int[]{i}, new int[]{(i268 | i269) & (~(i268 & i269))}, null};
                                int i24117 = ~((-459455059) | i);
                                int i24118 = ~i;
                                int i24119 = (-1790284894) + ((i24117 | (~(536083166 | i24118))) * (-406)) + ((~((-16914451) | i24118)) * (-406)) + (((~((-519168717) | i)) | (~(459455058 | i24118))) * 406);
                                int i25110 = (-1) - (~(i24119 * (-978)));
                                int i25111 = ~i24119;
                                int i25112 = -(-((~((i24118 & i25111) | (i25111 ^ i24118))) * 979));
                                int i25113 = ((((i25110 | i25112) << 1) - (i25110 ^ i25112)) - (~(i * (-979)))) - 1;
                                int i25114 = ~i24119;
                                int i25115 = ~((i25114 & i) | (i25114 ^ i));
                                int i25116 = ~(~i);
                                int i25117 = -(-(((i25116 & i25115) | (i25115 ^ i25116)) * 979));
                                int i25118 = -(-((i25113 & i25117) + (i25117 | i25113)));
                                int i25119 = (i2 ^ i25118) + ((i25118 & i2) << 1);
                                int i2610 = i25119 << 13;
                                int i2611 = (i2610 & (~i25119)) | ((~i2610) & i25119);
                                int i2612 = i2611 >>> 17;
                                int i2613 = ((~i2611) & i2612) | ((~i2612) & i2611);
                                int i2614 = i2613 << 5;
                            } else {
                                if (!file3.canRead()) {
                                    int i272 = artificialFrame + 125;
                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i272 % 128;
                                    int i273 = i272 % 2;
                                } else {
                                    fileReader3 = new FileReader(file3);
                                    bufferedReader3 = new BufferedReader(fileReader3);
                                    line = bufferedReader3.readLine();
                                    float maxVolume2 = AudioTrack.getMaxVolume();
                                    i27 = artificialFrame + 43;
                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i27 % 128;
                                    i28 = (maxVolume2 > 0.0f ? 1 : (maxVolume2 == 0.0f ? 0 : -1));
                                    if (i27 % 2 != 0) {
                                        objArr5 = new Object[1];
                                        a(i28, new char[]{28228, 28202, 4336, 62362, 33580, 17750, 59347}, objArr5);
                                        if (line.equals((String) objArr5[0])) {
                                            fileReader3.close();
                                            bufferedReader3.close();
                                        } else {
                                            int i1815 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                            i29 = (i1815 ^ 13) + ((i1815 & 13) << 1);
                                            artificialFrame = i29 % 128;
                                            if (i29 % 2 != 0) {
                                                fileReader3.close();
                                                bufferedReader3.close();
                                                throw null;
                                            }
                                            fileReader3.close();
                                            bufferedReader3.close();
                                            str = line;
                                        }
                                        int iIndexOf4 = TextUtils.indexOf("", "", 0);
                                        Object[] objArr1111 = new Object[1];
                                        a((iIndexOf4 & 1) + (iIndexOf4 | 1), new char[]{38539, 38564, 22414, 46331, 36916, 49189, 6908, 14520, 22092, 26949, 1057, 23583, 36560, 44172, 34837, 43031, 12997, 53409, 15471, 9314, 42740, 17597, 41058, 45160, 10894, 51332, 54343, 3177, 56982, 31901, 22703, 39072, 17003, 57466, 52414}, objArr1111);
                                        file = new File((String) objArr1111[0]);
                                        if (!file.canRead()) {
                                            fileReader = new FileReader(file);
                                            bufferedReader = new BufferedReader(fileReader);
                                            String line8 = bufferedReader.readLine();
                                            int jumpTapTimeout4 = ViewConfiguration.getJumpTapTimeout() >> 16;
                                            int i1816 = ~jumpTapTimeout4;
                                            int i1817 = ~(((-2) ^ i) | ((-2) & i));
                                            int i191110 = (jumpTapTimeout4 * (-947)) + 949 + (((i1817 & i1816) | (i1816 ^ i1817)) * (-948));
                                            int i191111 = i1816 | (-2);
                                            int i191112 = ~i;
                                            int i191113 = -(-((~((i191111 & i191112) | (i191111 ^ i191112))) * (-948)));
                                            int i191114 = (i191110 ^ i191113) + ((i191110 & i191113) << 1);
                                            int i191115 = artificialFrame;
                                            int i191116 = (i191115 ^ 117) + ((i191115 & 117) << 1);
                                            getARTIFICIAL_FRAME_PACKAGE_NAME = i191116 % 128;
                                            int i191117 = i191116 % 2;
                                            int i191118 = -(-(948 * (((-2) & jumpTapTimeout4) | (jumpTapTimeout4 ^ (-2)))));
                                            Object[] objArr1112 = new Object[1];
                                            a((i191114 & i191118) + (i191118 | i191114), new char[]{64993, 64976, 4418, 45481, 45093}, objArr1112);
                                            zEquals = line8.equals((String) objArr1112[0]);
                                            fileReader.close();
                                            bufferedReader.close();
                                            if (zEquals) {
                                                int i191119 = -(-Drawable.resolveOpacity(0, 0));
                                                Object[] objArr1113 = new Object[1];
                                                a((i191119 ^ 1) + ((i191119 & 1) << 1), new char[]{62601, 62630, 65304, 7278, 51128, 59637, 30898, 36970, 459, 16777, 21424, 29912, 60623, 1104, 57237, 32913, 20689, 30780, 27631, 3255, 50366, 60514, 63461, 39076, 18572, 24594, 33740, 9364, 48278, 54346, 3901, 45180, 8292, 18666, 39732, 15484, 37966, 48354, 9998, 18504}, objArr1113);
                                                file2 = new File((String) objArr1113[0]);
                                                if (!file2.canRead()) {
                                                    fileReader2 = new FileReader(file2);
                                                    bufferedReader2 = new BufferedReader(fileReader2);
                                                    String line9 = bufferedReader2.readLine();
                                                    Object[] objArr1114 = new Object[1];
                                                    a((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), new char[]{64993, 64976, 4418, 45481, 45093}, objArr1114);
                                                    zEquals2 = line9.equals((String) objArr1114[0]);
                                                    fileReader2.close();
                                                    bufferedReader2.close();
                                                    if (zEquals2) {
                                                        i17 = artificialFrame;
                                                        int i201110 = i17 + 37;
                                                        getARTIFICIAL_FRAME_PACKAGE_NAME = i201110 % 128;
                                                        int i201111 = i201110 % 2;
                                                        if (str != null) {
                                                            i18 = (i17 & 117) + (i17 | 117);
                                                            getARTIFICIAL_FRAME_PACKAGE_NAME = i18 % 128;
                                                            if (i18 % 2 != 0) {
                                                                i19 = (i & (-90)) | ((~i) & 89);
                                                                Object[] objArr1115 = new Object[2];
                                                                c2 = 1;
                                                                objArr1115[1] = new int[1];
                                                                objArr1115[1] = new int[1];
                                                                objArr1115[4] = new int[1];
                                                                objArr3 = objArr1115;
                                                                c3 = 0;
                                                            } else {
                                                                c2 = 1;
                                                                i19 = (~(i & 20)) & (i | 20);
                                                                Object[] objArr1116 = new Object[4];
                                                                c3 = 0;
                                                                objArr1116[0] = new int[1];
                                                                objArr1116[1] = new int[1];
                                                                objArr1116[2] = new int[1];
                                                                objArr3 = objArr1116;
                                                            }
                                                            ((int[]) objArr3[c3])[c3] = i;
                                                            ((int[]) objArr3[c2])[c3] = i19;
                                                            objArr3[3] = str;
                                                            int i201112 = ~i;
                                                            i20 = ((((~((-709434913) | i201112)) | (~(i | 269188862))) * 959) - 310542209) + (((~(i201112 | 269188862)) | (~(i | (-709434913)))) * 959);
                                                            int i_BOUNDARY13 = TimestampAction._BOUNDARY();
                                                            int i201113 = i20 * (-1527);
                                                            int i201114 = ((12240 | i201113) << 1) - (i201113 ^ 12240);
                                                            int i201115 = ~i_BOUNDARY13;
                                                            i21 = ~((i201115 & 16) | (i201115 ^ 16));
                                                            i22 = i201114 + (((i20 ^ i21) | (i20 & i21)) * 764);
                                                            i23 = ~(((-17) ^ i20) | ((-17) & i20));
                                                            int i201116 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                                            int i201117 = (i201116 ^ 73) + ((i201116 & 73) << 1);
                                                            artificialFrame = i201117 % 128;
                                                            i24 = i201117 % 2;
                                                            i25 = ~i_BOUNDARY13;
                                                            if (i24 == 0) {
                                                                int i201118 = ~((i25 ^ i20) | (i25 & i20));
                                                                int i201119 = i22 / ((-1528) / ((i201118 & i23) | (i23 ^ i201118)));
                                                                int i211110 = ~((-17) | i20);
                                                                int i211111 = ~((~i20) | 16);
                                                                int i211112 = (i211110 & i211111) | (i211110 ^ i211111);
                                                                int i211113 = ~((i25 & 16) | (i25 ^ 16));
                                                                i26 = i201119 * (764 % ((i211113 & i211112) | (i211112 ^ i211113)));
                                                            } else {
                                                                int i211114 = -(-(((~(i25 | i20)) | i23) * (-1528)));
                                                                int i211115 = (i22 ^ i211114) + ((i211114 & i22) << 1);
                                                                int i211116 = ~(((-17) ^ i20) | ((-17) & i20));
                                                                int i211117 = ~((~i20) | 16);
                                                                int i211118 = (i211116 & i211117) | (i211116 ^ i211117);
                                                                int i211119 = -(-(((i211118 & i21) | (i211118 ^ i21)) * 764));
                                                                i26 = ((i211115 | i211119) << 1) - (i211119 ^ i211115);
                                                            }
                                                            int i_BOUNDARY14 = TimestampAction._BOUNDARY();
                                                            int i221110 = i26 * 765;
                                                            int i221111 = i2 * (-1527);
                                                            int i221112 = (i221110 & i221111) + (i221110 | i221111);
                                                            int i221113 = ~i_BOUNDARY14;
                                                            int i221114 = ~(i221113 | i26);
                                                            int i221115 = ((i221114 & i2) | (i2 ^ i221114)) * 764;
                                                            int i221116 = (i221112 ^ i221115) + ((i221115 & i221112) << 1);
                                                            int i221117 = ~i26;
                                                            int i221118 = (i221117 & i2) | (i221117 ^ i2);
                                                            int i221119 = ~i221118;
                                                            int i231110 = ~(i221113 | i2);
                                                            int i231111 = i221116 + (((i231110 & i221119) | (i221119 ^ i231110)) * (-1528));
                                                            int i231112 = ~i221118;
                                                            int i231113 = ~i2;
                                                            int i231114 = ~((i231113 & i26) | (i231113 ^ i26));
                                                            int i231115 = (i231112 & i231114) | (i231112 ^ i231114);
                                                            int i231116 = ~i_BOUNDARY14;
                                                            int i231117 = ~((i231116 & i26) | (i231116 ^ i26));
                                                            int i231118 = ((i231117 & i231115) | (i231115 ^ i231117)) * 764;
                                                            int i231119 = ((i231111 | i231118) << 1) - (i231118 ^ i231111);
                                                            int i241110 = i231119 << 13;
                                                            int i241111 = (i241110 | i231119) & (~(i231119 & i241110));
                                                            int i241112 = i241111 >>> 17;
                                                            int i241113 = ((~i241111) & i241112) | ((~i241112) & i241111);
                                                            int i241114 = i241113 << 5;
                                                            ((int[]) objArr3[2])[0] = ((~i241113) & i241114) | ((~i241114) & i241113);
                                                            int i241115 = artificialFrame + 67;
                                                            getARTIFICIAL_FRAME_PACKAGE_NAME = i241115 % 128;
                                                            int i241116 = i241115 % 2;
                                                            return objArr3;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        objArr2 = new Object[]{new int[]{i}, new int[]{i}, new int[]{(i2613 | i2614) & (~(i2613 & i2614))}, null};
                                        int i241117 = ~((-459455059) | i);
                                        int i241118 = ~i;
                                        int i241119 = (-1790284894) + ((i241117 | (~(536083166 | i241118))) * (-406)) + ((~((-16914451) | i241118)) * (-406)) + (((~((-519168717) | i)) | (~(459455058 | i241118))) * 406);
                                        int i251110 = (-1) - (~(i241119 * (-978)));
                                        int i251111 = ~i241119;
                                        int i251112 = -(-((~((i241118 & i251111) | (i251111 ^ i241118))) * 979));
                                        int i251113 = ((((i251110 | i251112) << 1) - (i251110 ^ i251112)) - (~(i * (-979)))) - 1;
                                        int i251114 = ~i241119;
                                        int i251115 = ~((i251114 & i) | (i251114 ^ i));
                                        int i251116 = ~(~i);
                                        int i251117 = -(-(((i251116 & i251115) | (i251115 ^ i251116)) * 979));
                                        int i251118 = -(-((i251113 & i251117) + (i251117 | i251113)));
                                        int i251119 = (i2 ^ i251118) + ((i251118 & i2) << 1);
                                        int i2615 = i251119 << 13;
                                        int i2616 = (i2615 & (~i251119)) | ((~i2615) & i251119);
                                        int i2617 = i2616 >>> 17;
                                        int i2618 = ((~i2616) & i2617) | ((~i2617) & i2616);
                                        int i2619 = i2618 << 5;
                                    } else {
                                        objArr4 = new Object[1];
                                        a(i28, new char[]{28228, 28202, 4336, 62362, 33580, 17750, 59347}, objArr4);
                                        if (line.equals((String) objArr4[0])) {
                                            fileReader3.close();
                                            bufferedReader3.close();
                                        } else {
                                            int i1818 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                            i29 = (i1818 ^ 13) + ((i1818 & 13) << 1);
                                            artificialFrame = i29 % 128;
                                            if (i29 % 2 != 0) {
                                                fileReader3.close();
                                                bufferedReader3.close();
                                                throw null;
                                            }
                                            fileReader3.close();
                                            bufferedReader3.close();
                                            str = line;
                                        }
                                        int iIndexOf5 = TextUtils.indexOf("", "", 0);
                                        Object[] objArr1117 = new Object[1];
                                        a((iIndexOf5 & 1) + (iIndexOf5 | 1), new char[]{38539, 38564, 22414, 46331, 36916, 49189, 6908, 14520, 22092, 26949, 1057, 23583, 36560, 44172, 34837, 43031, 12997, 53409, 15471, 9314, 42740, 17597, 41058, 45160, 10894, 51332, 54343, 3177, 56982, 31901, 22703, 39072, 17003, 57466, 52414}, objArr1117);
                                        file = new File((String) objArr1117[0]);
                                        if (!file.canRead()) {
                                            fileReader = new FileReader(file);
                                            bufferedReader = new BufferedReader(fileReader);
                                            String line10 = bufferedReader.readLine();
                                            int jumpTapTimeout5 = ViewConfiguration.getJumpTapTimeout() >> 16;
                                            int i1819 = ~jumpTapTimeout5;
                                            int i18110 = ~(((-2) ^ i) | ((-2) & i));
                                            int i1911110 = (jumpTapTimeout5 * (-947)) + 949 + (((i18110 & i1819) | (i1819 ^ i18110)) * (-948));
                                            int i1911111 = i1819 | (-2);
                                            int i1911112 = ~i;
                                            int i1911113 = -(-((~((i1911111 & i1911112) | (i1911111 ^ i1911112))) * (-948)));
                                            int i1911114 = (i1911110 ^ i1911113) + ((i1911110 & i1911113) << 1);
                                            int i1911115 = artificialFrame;
                                            int i1911116 = (i1911115 ^ 117) + ((i1911115 & 117) << 1);
                                            getARTIFICIAL_FRAME_PACKAGE_NAME = i1911116 % 128;
                                            int i1911117 = i1911116 % 2;
                                            int i1911118 = -(-(948 * (((-2) & jumpTapTimeout5) | (jumpTapTimeout5 ^ (-2)))));
                                            Object[] objArr1118 = new Object[1];
                                            a((i1911114 & i1911118) + (i1911118 | i1911114), new char[]{64993, 64976, 4418, 45481, 45093}, objArr1118);
                                            zEquals = line10.equals((String) objArr1118[0]);
                                            fileReader.close();
                                            bufferedReader.close();
                                            if (zEquals) {
                                                int i1911119 = -(-Drawable.resolveOpacity(0, 0));
                                                Object[] objArr1119 = new Object[1];
                                                a((i1911119 ^ 1) + ((i1911119 & 1) << 1), new char[]{62601, 62630, 65304, 7278, 51128, 59637, 30898, 36970, 459, 16777, 21424, 29912, 60623, 1104, 57237, 32913, 20689, 30780, 27631, 3255, 50366, 60514, 63461, 39076, 18572, 24594, 33740, 9364, 48278, 54346, 3901, 45180, 8292, 18666, 39732, 15484, 37966, 48354, 9998, 18504}, objArr1119);
                                                file2 = new File((String) objArr1119[0]);
                                                if (!file2.canRead()) {
                                                    fileReader2 = new FileReader(file2);
                                                    bufferedReader2 = new BufferedReader(fileReader2);
                                                    String line11 = bufferedReader2.readLine();
                                                    Object[] objArr11110 = new Object[1];
                                                    a((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), new char[]{64993, 64976, 4418, 45481, 45093}, objArr11110);
                                                    zEquals2 = line11.equals((String) objArr11110[0]);
                                                    fileReader2.close();
                                                    bufferedReader2.close();
                                                    if (zEquals2) {
                                                        i17 = artificialFrame;
                                                        int i2011110 = i17 + 37;
                                                        getARTIFICIAL_FRAME_PACKAGE_NAME = i2011110 % 128;
                                                        int i2011111 = i2011110 % 2;
                                                        if (str != null) {
                                                            i18 = (i17 & 117) + (i17 | 117);
                                                            getARTIFICIAL_FRAME_PACKAGE_NAME = i18 % 128;
                                                            if (i18 % 2 != 0) {
                                                                i19 = (i & (-90)) | ((~i) & 89);
                                                                Object[] objArr11111 = new Object[2];
                                                                c2 = 1;
                                                                objArr11111[1] = new int[1];
                                                                objArr11111[1] = new int[1];
                                                                objArr11111[4] = new int[1];
                                                                objArr3 = objArr11111;
                                                                c3 = 0;
                                                            } else {
                                                                c2 = 1;
                                                                i19 = (~(i & 20)) & (i | 20);
                                                                Object[] objArr11112 = new Object[4];
                                                                c3 = 0;
                                                                objArr11112[0] = new int[1];
                                                                objArr11112[1] = new int[1];
                                                                objArr11112[2] = new int[1];
                                                                objArr3 = objArr11112;
                                                            }
                                                            ((int[]) objArr3[c3])[c3] = i;
                                                            ((int[]) objArr3[c2])[c3] = i19;
                                                            objArr3[3] = str;
                                                            int i2011112 = ~i;
                                                            i20 = ((((~((-709434913) | i2011112)) | (~(i | 269188862))) * 959) - 310542209) + (((~(i2011112 | 269188862)) | (~(i | (-709434913)))) * 959);
                                                            int i_BOUNDARY15 = TimestampAction._BOUNDARY();
                                                            int i2011113 = i20 * (-1527);
                                                            int i2011114 = ((12240 | i2011113) << 1) - (i2011113 ^ 12240);
                                                            int i2011115 = ~i_BOUNDARY15;
                                                            i21 = ~((i2011115 & 16) | (i2011115 ^ 16));
                                                            i22 = i2011114 + (((i20 ^ i21) | (i20 & i21)) * 764);
                                                            i23 = ~(((-17) ^ i20) | ((-17) & i20));
                                                            int i2011116 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                                            int i2011117 = (i2011116 ^ 73) + ((i2011116 & 73) << 1);
                                                            artificialFrame = i2011117 % 128;
                                                            i24 = i2011117 % 2;
                                                            i25 = ~i_BOUNDARY15;
                                                            if (i24 == 0) {
                                                                int i2011118 = ~((i25 ^ i20) | (i25 & i20));
                                                                int i2011119 = i22 / ((-1528) / ((i2011118 & i23) | (i23 ^ i2011118)));
                                                                int i2111110 = ~((-17) | i20);
                                                                int i2111111 = ~((~i20) | 16);
                                                                int i2111112 = (i2111110 & i2111111) | (i2111110 ^ i2111111);
                                                                int i2111113 = ~((i25 & 16) | (i25 ^ 16));
                                                                i26 = i2011119 * (764 % ((i2111113 & i2111112) | (i2111112 ^ i2111113)));
                                                            } else {
                                                                int i2111114 = -(-(((~(i25 | i20)) | i23) * (-1528)));
                                                                int i2111115 = (i22 ^ i2111114) + ((i2111114 & i22) << 1);
                                                                int i2111116 = ~(((-17) ^ i20) | ((-17) & i20));
                                                                int i2111117 = ~((~i20) | 16);
                                                                int i2111118 = (i2111116 & i2111117) | (i2111116 ^ i2111117);
                                                                int i2111119 = -(-(((i2111118 & i21) | (i2111118 ^ i21)) * 764));
                                                                i26 = ((i2111115 | i2111119) << 1) - (i2111119 ^ i2111115);
                                                            }
                                                            int i_BOUNDARY16 = TimestampAction._BOUNDARY();
                                                            int i2211110 = i26 * 765;
                                                            int i2211111 = i2 * (-1527);
                                                            int i2211112 = (i2211110 & i2211111) + (i2211110 | i2211111);
                                                            int i2211113 = ~i_BOUNDARY16;
                                                            int i2211114 = ~(i2211113 | i26);
                                                            int i2211115 = ((i2211114 & i2) | (i2 ^ i2211114)) * 764;
                                                            int i2211116 = (i2211112 ^ i2211115) + ((i2211115 & i2211112) << 1);
                                                            int i2211117 = ~i26;
                                                            int i2211118 = (i2211117 & i2) | (i2211117 ^ i2);
                                                            int i2211119 = ~i2211118;
                                                            int i2311110 = ~(i2211113 | i2);
                                                            int i2311111 = i2211116 + (((i2311110 & i2211119) | (i2211119 ^ i2311110)) * (-1528));
                                                            int i2311112 = ~i2211118;
                                                            int i2311113 = ~i2;
                                                            int i2311114 = ~((i2311113 & i26) | (i2311113 ^ i26));
                                                            int i2311115 = (i2311112 & i2311114) | (i2311112 ^ i2311114);
                                                            int i2311116 = ~i_BOUNDARY16;
                                                            int i2311117 = ~((i2311116 & i26) | (i2311116 ^ i26));
                                                            int i2311118 = ((i2311117 & i2311115) | (i2311115 ^ i2311117)) * 764;
                                                            int i2311119 = ((i2311111 | i2311118) << 1) - (i2311118 ^ i2311111);
                                                            int i2411110 = i2311119 << 13;
                                                            int i2411111 = (i2411110 | i2311119) & (~(i2311119 & i2411110));
                                                            int i2411112 = i2411111 >>> 17;
                                                            int i2411113 = ((~i2411111) & i2411112) | ((~i2411112) & i2411111);
                                                            int i2411114 = i2411113 << 5;
                                                            ((int[]) objArr3[2])[0] = ((~i2411113) & i2411114) | ((~i2411114) & i2411113);
                                                            int i2411115 = artificialFrame + 67;
                                                            getARTIFICIAL_FRAME_PACKAGE_NAME = i2411115 % 128;
                                                            int i2411116 = i2411115 % 2;
                                                            return objArr3;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        objArr2 = new Object[]{new int[]{i}, new int[]{i}, new int[]{(i2618 | i2619) & (~(i2618 & i2619))}, null};
                                        int i2411117 = ~((-459455059) | i);
                                        int i2411118 = ~i;
                                        int i2411119 = (-1790284894) + ((i2411117 | (~(536083166 | i2411118))) * (-406)) + ((~((-16914451) | i2411118)) * (-406)) + (((~((-519168717) | i)) | (~(459455058 | i2411118))) * 406);
                                        int i2511110 = (-1) - (~(i2411119 * (-978)));
                                        int i2511111 = ~i2411119;
                                        int i2511112 = -(-((~((i2411118 & i2511111) | (i2511111 ^ i2411118))) * 979));
                                        int i2511113 = ((((i2511110 | i2511112) << 1) - (i2511110 ^ i2511112)) - (~(i * (-979)))) - 1;
                                        int i2511114 = ~i2411119;
                                        int i2511115 = ~((i2511114 & i) | (i2511114 ^ i));
                                        int i2511116 = ~(~i);
                                        int i2511117 = -(-(((i2511116 & i2511115) | (i2511115 ^ i2511116)) * 979));
                                        int i2511118 = -(-((i2511113 & i2511117) + (i2511117 | i2511113)));
                                        int i2511119 = (i2 ^ i2511118) + ((i2511118 & i2) << 1);
                                        int i26110 = i2511119 << 13;
                                        int i26111 = (i26110 & (~i2511119)) | ((~i26110) & i2511119);
                                        int i26112 = i26111 >>> 17;
                                        int i26113 = ((~i26111) & i26112) | ((~i26112) & i26111);
                                        int i26114 = i26113 << 5;
                                    }
                                }
                                str = null;
                                int iIndexOf6 = TextUtils.indexOf("", "", 0);
                                Object[] objArr11113 = new Object[1];
                                a((iIndexOf6 & 1) + (iIndexOf6 | 1), new char[]{38539, 38564, 22414, 46331, 36916, 49189, 6908, 14520, 22092, 26949, 1057, 23583, 36560, 44172, 34837, 43031, 12997, 53409, 15471, 9314, 42740, 17597, 41058, 45160, 10894, 51332, 54343, 3177, 56982, 31901, 22703, 39072, 17003, 57466, 52414}, objArr11113);
                                file = new File((String) objArr11113[0]);
                                if (!file.canRead()) {
                                    fileReader = new FileReader(file);
                                    bufferedReader = new BufferedReader(fileReader);
                                    String line12 = bufferedReader.readLine();
                                    int jumpTapTimeout6 = ViewConfiguration.getJumpTapTimeout() >> 16;
                                    int i18111 = ~jumpTapTimeout6;
                                    int i18112 = ~(((-2) ^ i) | ((-2) & i));
                                    int i19111110 = (jumpTapTimeout6 * (-947)) + 949 + (((i18112 & i18111) | (i18111 ^ i18112)) * (-948));
                                    int i19111111 = i18111 | (-2);
                                    int i19111112 = ~i;
                                    int i19111113 = -(-((~((i19111111 & i19111112) | (i19111111 ^ i19111112))) * (-948)));
                                    int i19111114 = (i19111110 ^ i19111113) + ((i19111110 & i19111113) << 1);
                                    int i19111115 = artificialFrame;
                                    int i19111116 = (i19111115 ^ 117) + ((i19111115 & 117) << 1);
                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i19111116 % 128;
                                    int i19111117 = i19111116 % 2;
                                    int i19111118 = -(-(948 * (((-2) & jumpTapTimeout6) | (jumpTapTimeout6 ^ (-2)))));
                                    Object[] objArr11114 = new Object[1];
                                    a((i19111114 & i19111118) + (i19111118 | i19111114), new char[]{64993, 64976, 4418, 45481, 45093}, objArr11114);
                                    zEquals = line12.equals((String) objArr11114[0]);
                                    fileReader.close();
                                    bufferedReader.close();
                                    if (zEquals) {
                                        int i19111119 = -(-Drawable.resolveOpacity(0, 0));
                                        Object[] objArr11115 = new Object[1];
                                        a((i19111119 ^ 1) + ((i19111119 & 1) << 1), new char[]{62601, 62630, 65304, 7278, 51128, 59637, 30898, 36970, 459, 16777, 21424, 29912, 60623, 1104, 57237, 32913, 20689, 30780, 27631, 3255, 50366, 60514, 63461, 39076, 18572, 24594, 33740, 9364, 48278, 54346, 3901, 45180, 8292, 18666, 39732, 15484, 37966, 48354, 9998, 18504}, objArr11115);
                                        file2 = new File((String) objArr11115[0]);
                                        if (!file2.canRead()) {
                                            fileReader2 = new FileReader(file2);
                                            bufferedReader2 = new BufferedReader(fileReader2);
                                            String line13 = bufferedReader2.readLine();
                                            Object[] objArr11116 = new Object[1];
                                            a((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), new char[]{64993, 64976, 4418, 45481, 45093}, objArr11116);
                                            zEquals2 = line13.equals((String) objArr11116[0]);
                                            fileReader2.close();
                                            bufferedReader2.close();
                                            if (zEquals2) {
                                                i17 = artificialFrame;
                                                int i20111110 = i17 + 37;
                                                getARTIFICIAL_FRAME_PACKAGE_NAME = i20111110 % 128;
                                                int i20111111 = i20111110 % 2;
                                                if (str != null) {
                                                    i18 = (i17 & 117) + (i17 | 117);
                                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i18 % 128;
                                                    if (i18 % 2 != 0) {
                                                        i19 = (i & (-90)) | ((~i) & 89);
                                                        Object[] objArr11117 = new Object[2];
                                                        c2 = 1;
                                                        objArr11117[1] = new int[1];
                                                        objArr11117[1] = new int[1];
                                                        objArr11117[4] = new int[1];
                                                        objArr3 = objArr11117;
                                                        c3 = 0;
                                                    } else {
                                                        c2 = 1;
                                                        i19 = (~(i & 20)) & (i | 20);
                                                        Object[] objArr11118 = new Object[4];
                                                        c3 = 0;
                                                        objArr11118[0] = new int[1];
                                                        objArr11118[1] = new int[1];
                                                        objArr11118[2] = new int[1];
                                                        objArr3 = objArr11118;
                                                    }
                                                    ((int[]) objArr3[c3])[c3] = i;
                                                    ((int[]) objArr3[c2])[c3] = i19;
                                                    objArr3[3] = str;
                                                    int i20111112 = ~i;
                                                    i20 = ((((~((-709434913) | i20111112)) | (~(i | 269188862))) * 959) - 310542209) + (((~(i20111112 | 269188862)) | (~(i | (-709434913)))) * 959);
                                                    int i_BOUNDARY17 = TimestampAction._BOUNDARY();
                                                    int i20111113 = i20 * (-1527);
                                                    int i20111114 = ((12240 | i20111113) << 1) - (i20111113 ^ 12240);
                                                    int i20111115 = ~i_BOUNDARY17;
                                                    i21 = ~((i20111115 & 16) | (i20111115 ^ 16));
                                                    i22 = i20111114 + (((i20 ^ i21) | (i20 & i21)) * 764);
                                                    i23 = ~(((-17) ^ i20) | ((-17) & i20));
                                                    int i20111116 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                                    int i20111117 = (i20111116 ^ 73) + ((i20111116 & 73) << 1);
                                                    artificialFrame = i20111117 % 128;
                                                    i24 = i20111117 % 2;
                                                    i25 = ~i_BOUNDARY17;
                                                    if (i24 == 0) {
                                                        int i20111118 = ~((i25 ^ i20) | (i25 & i20));
                                                        int i20111119 = i22 / ((-1528) / ((i20111118 & i23) | (i23 ^ i20111118)));
                                                        int i21111110 = ~((-17) | i20);
                                                        int i21111111 = ~((~i20) | 16);
                                                        int i21111112 = (i21111110 & i21111111) | (i21111110 ^ i21111111);
                                                        int i21111113 = ~((i25 & 16) | (i25 ^ 16));
                                                        i26 = i20111119 * (764 % ((i21111113 & i21111112) | (i21111112 ^ i21111113)));
                                                    } else {
                                                        int i21111114 = -(-(((~(i25 | i20)) | i23) * (-1528)));
                                                        int i21111115 = (i22 ^ i21111114) + ((i21111114 & i22) << 1);
                                                        int i21111116 = ~(((-17) ^ i20) | ((-17) & i20));
                                                        int i21111117 = ~((~i20) | 16);
                                                        int i21111118 = (i21111116 & i21111117) | (i21111116 ^ i21111117);
                                                        int i21111119 = -(-(((i21111118 & i21) | (i21111118 ^ i21)) * 764));
                                                        i26 = ((i21111115 | i21111119) << 1) - (i21111119 ^ i21111115);
                                                    }
                                                    int i_BOUNDARY18 = TimestampAction._BOUNDARY();
                                                    int i22111110 = i26 * 765;
                                                    int i22111111 = i2 * (-1527);
                                                    int i22111112 = (i22111110 & i22111111) + (i22111110 | i22111111);
                                                    int i22111113 = ~i_BOUNDARY18;
                                                    int i22111114 = ~(i22111113 | i26);
                                                    int i22111115 = ((i22111114 & i2) | (i2 ^ i22111114)) * 764;
                                                    int i22111116 = (i22111112 ^ i22111115) + ((i22111115 & i22111112) << 1);
                                                    int i22111117 = ~i26;
                                                    int i22111118 = (i22111117 & i2) | (i22111117 ^ i2);
                                                    int i22111119 = ~i22111118;
                                                    int i23111110 = ~(i22111113 | i2);
                                                    int i23111111 = i22111116 + (((i23111110 & i22111119) | (i22111119 ^ i23111110)) * (-1528));
                                                    int i23111112 = ~i22111118;
                                                    int i23111113 = ~i2;
                                                    int i23111114 = ~((i23111113 & i26) | (i23111113 ^ i26));
                                                    int i23111115 = (i23111112 & i23111114) | (i23111112 ^ i23111114);
                                                    int i23111116 = ~i_BOUNDARY18;
                                                    int i23111117 = ~((i23111116 & i26) | (i23111116 ^ i26));
                                                    int i23111118 = ((i23111117 & i23111115) | (i23111115 ^ i23111117)) * 764;
                                                    int i23111119 = ((i23111111 | i23111118) << 1) - (i23111118 ^ i23111111);
                                                    int i24111110 = i23111119 << 13;
                                                    int i24111111 = (i24111110 | i23111119) & (~(i23111119 & i24111110));
                                                    int i24111112 = i24111111 >>> 17;
                                                    int i24111113 = ((~i24111111) & i24111112) | ((~i24111112) & i24111111);
                                                    int i24111114 = i24111113 << 5;
                                                    ((int[]) objArr3[2])[0] = ((~i24111113) & i24111114) | ((~i24111114) & i24111113);
                                                    int i24111115 = artificialFrame + 67;
                                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i24111115 % 128;
                                                    int i24111116 = i24111115 % 2;
                                                    return objArr3;
                                                }
                                            }
                                        }
                                    }
                                }
                                objArr2 = new Object[]{new int[]{i}, new int[]{i}, new int[]{(i26113 | i26114) & (~(i26113 & i26114))}, null};
                                int i24111117 = ~((-459455059) | i);
                                int i24111118 = ~i;
                                int i24111119 = (-1790284894) + ((i24111117 | (~(536083166 | i24111118))) * (-406)) + ((~((-16914451) | i24111118)) * (-406)) + (((~((-519168717) | i)) | (~(459455058 | i24111118))) * 406);
                                int i25111110 = (-1) - (~(i24111119 * (-978)));
                                int i25111111 = ~i24111119;
                                int i25111112 = -(-((~((i24111118 & i25111111) | (i25111111 ^ i24111118))) * 979));
                                int i25111113 = ((((i25111110 | i25111112) << 1) - (i25111110 ^ i25111112)) - (~(i * (-979)))) - 1;
                                int i25111114 = ~i24111119;
                                int i25111115 = ~((i25111114 & i) | (i25111114 ^ i));
                                int i25111116 = ~(~i);
                                int i25111117 = -(-(((i25111116 & i25111115) | (i25111115 ^ i25111116)) * 979));
                                int i25111118 = -(-((i25111113 & i25111117) + (i25111117 | i25111113)));
                                int i25111119 = (i2 ^ i25111118) + ((i25111118 & i2) << 1);
                                int i26115 = i25111119 << 13;
                                int i26116 = (i26115 & (~i25111119)) | ((~i26115) & i25111119);
                                int i26117 = i26116 >>> 17;
                                int i26118 = ((~i26116) & i26117) | ((~i26117) & i26116);
                                int i26119 = i26118 << 5;
                            }
                        } catch (Exception unused2) {
                        }
                    }
                    return objArr2;
                } catch (Throwable th4) {
                    Throwable cause = th4.getCause();
                    if (cause != null) {
                        throw cause;
                    }
                    throw th4;
                }
            }
        } catch (Exception unused3) {
            objArr = new Object[]{new int[]{i}, new int[]{i ^ 2}, new int[1], null};
            int startElapsedRealtime = (int) Process.getStartElapsedRealtime();
            int i274 = ~startElapsedRealtime;
            int i275 = ~(172505987 | i274);
            int i276 = 1138659294 + ((805584920 | i275) * (-712)) + (((~(startElapsedRealtime | 978090907)) | (~(i274 | (-805584921)))) * (-712)) + (((-806117788) | i275) * 712);
            int i277 = i276 * (-163);
            int i278 = ((2640 | i277) << 1) - (i277 ^ 2640);
            int i279 = ~i;
            int i280 = -(-(((~((i279 & i276) | (i279 ^ i276))) | 16) * (-328)));
            int i281 = ((i278 | i280) << 1) - (i280 ^ i278);
            int i282 = ((i ^ 16) | (i & 16)) * 164;
            int i283 = (i281 ^ i282) + ((i282 & i281) << 1);
            int i284 = ~i276;
            int i285 = ~(((-17) ^ i284) | ((-17) & i284));
            int i286 = ~((i284 & i) | (i284 ^ i));
            int i287 = (i286 & i285) | (i285 ^ i286);
            int i288 = (~i) | 16;
            int i289 = (i2 - (~((i283 - (~((i287 | (~((i288 & i276) | (i288 ^ i276)))) * 164))) - 1))) - 1;
            int i290 = i289 << 13;
            int i291 = (i289 | i290) & (~(i289 & i290));
            int i292 = i291 >>> 17;
            int i293 = (i291 | i292) & (~(i291 & i292));
            int i294 = i293 << 5;
            ((int[]) objArr[2])[0] = ((~i293) & i294) | ((~i294) & i293);
        }
    }
}
