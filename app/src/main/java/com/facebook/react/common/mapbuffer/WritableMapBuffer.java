package com.facebook.react.common.mapbuffer;

import android.graphics.Color;
import android.graphics.ImageFormat;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import ch.qos.logback.core.net.SyslogConstants;
import com.facebook.imageutils.JfifUtil;
import com.google.android.gms.internal.stats.zzd;
import com.google.common.base.Ascii;
import com.salesforce.marketingcloud.analytics.stats.b;
import com.transistorsoft.locationmanager.location.TSLocationManager;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.ranges.IntRange;
import o.ArtificialStackFrames;
import o.onPostMessage;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class WritableMapBuffer implements MapBuffer {
    private static final Companion Companion = new Companion(null);
    private final SparseArray<Object> values = new SparseArray<>();

    public final WritableMapBuffer put(int i, boolean z) {
        return putInternal(i, Boolean.valueOf(z));
    }

    public final WritableMapBuffer put(int i, int i2) {
        return putInternal(i, Integer.valueOf(i2));
    }

    public final WritableMapBuffer put(int i, long j) {
        return putInternal(i, Long.valueOf(j));
    }

    public final WritableMapBuffer put(int i, double d) {
        return putInternal(i, Double.valueOf(d));
    }

    public final WritableMapBuffer put(int i, @NotNull String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return putInternal(i, value);
    }

    public final WritableMapBuffer put(int i, @NotNull MapBuffer value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return putInternal(i, value);
    }

    private final WritableMapBuffer putInternal(int i, Object obj) {
        IntRange kEY_RANGE$ReactAndroid_release = MapBuffer.Companion.getKEY_RANGE$ReactAndroid_release();
        int first = kEY_RANGE$ReactAndroid_release.getFirst();
        if (i > kEY_RANGE$ReactAndroid_release.getLast() || first > i) {
            throw new IllegalArgumentException("Only integers in [0;65535] range are allowed for keys.");
        }
        this.values.put(i, obj);
        return this;
    }

    @Override // com.facebook.react.common.mapbuffer.MapBuffer
    public int getCount() {
        return this.values.size();
    }

    @Override // com.facebook.react.common.mapbuffer.MapBuffer
    public boolean contains(int i) {
        return this.values.get(i) != null;
    }

    @Override // com.facebook.react.common.mapbuffer.MapBuffer
    public int getKeyOffset(int i) {
        return this.values.indexOfKey(i);
    }

    @Override // com.facebook.react.common.mapbuffer.MapBuffer
    public MapBuffer.Entry entryAt(int i) {
        return new MapBufferEntry(i);
    }

    @Override // com.facebook.react.common.mapbuffer.MapBuffer
    public MapBuffer.DataType getType(int i) {
        Object obj = this.values.get(i);
        if (obj == null) {
            throw new IllegalArgumentException(("Key not found: " + i).toString());
        }
        return dataType(obj, i);
    }

    @Override // com.facebook.react.common.mapbuffer.MapBuffer
    public boolean getBoolean(int i) {
        Object obj = this.values.get(i);
        if (obj == null) {
            throw new IllegalArgumentException(("Key not found: " + i).toString());
        }
        if (!(obj instanceof Boolean)) {
            throw new IllegalStateException(("Expected " + Boolean.class + " for key: " + i + ", found " + obj.getClass() + " instead.").toString());
        }
        return ((Boolean) obj).booleanValue();
    }

    @Override // com.facebook.react.common.mapbuffer.MapBuffer
    public int getInt(int i) {
        Object obj = this.values.get(i);
        if (obj == null) {
            throw new IllegalArgumentException(("Key not found: " + i).toString());
        }
        if (!(obj instanceof Integer)) {
            throw new IllegalStateException(("Expected " + Integer.class + " for key: " + i + ", found " + obj.getClass() + " instead.").toString());
        }
        return ((Number) obj).intValue();
    }

    @Override // com.facebook.react.common.mapbuffer.MapBuffer
    public long getLong(int i) {
        Object obj = this.values.get(i);
        if (obj == null) {
            throw new IllegalArgumentException(("Key not found: " + i).toString());
        }
        if (!(obj instanceof Long)) {
            throw new IllegalStateException(("Expected " + Long.class + " for key: " + i + ", found " + obj.getClass() + " instead.").toString());
        }
        return ((Number) obj).longValue();
    }

    @Override // com.facebook.react.common.mapbuffer.MapBuffer
    public double getDouble(int i) {
        Object obj = this.values.get(i);
        if (obj == null) {
            throw new IllegalArgumentException(("Key not found: " + i).toString());
        }
        if (!(obj instanceof Double)) {
            throw new IllegalStateException(("Expected " + Double.class + " for key: " + i + ", found " + obj.getClass() + " instead.").toString());
        }
        return ((Number) obj).doubleValue();
    }

    @Override // com.facebook.react.common.mapbuffer.MapBuffer
    public String getString(int i) {
        Object obj = this.values.get(i);
        if (obj == null) {
            throw new IllegalArgumentException(("Key not found: " + i).toString());
        }
        if (!(obj instanceof String)) {
            throw new IllegalStateException(("Expected " + String.class + " for key: " + i + ", found " + obj.getClass() + " instead.").toString());
        }
        return (String) obj;
    }

    @Override // com.facebook.react.common.mapbuffer.MapBuffer
    public MapBuffer getMapBuffer(int i) {
        Object obj = this.values.get(i);
        if (obj == null) {
            throw new IllegalArgumentException(("Key not found: " + i).toString());
        }
        if (!(obj instanceof MapBuffer)) {
            throw new IllegalStateException(("Expected " + MapBuffer.class + " for key: " + i + ", found " + obj.getClass() + " instead.").toString());
        }
        return (MapBuffer) obj;
    }

    @Override // com.facebook.react.common.mapbuffer.MapBuffer
    public List<MapBuffer> getMapBufferList(int i) {
        Object obj = this.values.get(i);
        if (obj == null) {
            throw new IllegalArgumentException(("Key not found: " + i).toString());
        }
        if (!(obj instanceof List)) {
            throw new IllegalStateException(("Expected " + List.class + " for key: " + i + ", found " + obj.getClass() + " instead.").toString());
        }
        return (List) obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final /* synthetic */ <T> T verifyValue(int i, Object obj) {
        if (obj == 0) {
            throw new IllegalArgumentException(("Key not found: " + i).toString());
        }
        Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
        if (obj != 0) {
            return obj;
        }
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        throw new IllegalStateException(("Expected " + Object.class + " for key: " + i + ", found " + obj.getClass() + " instead.").toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MapBuffer.DataType dataType(Object obj, int i) {
        if (obj instanceof Boolean) {
            return MapBuffer.DataType.BOOL;
        }
        if (obj instanceof Integer) {
            return MapBuffer.DataType.INT;
        }
        if (obj instanceof Long) {
            return MapBuffer.DataType.LONG;
        }
        if (obj instanceof Double) {
            return MapBuffer.DataType.DOUBLE;
        }
        if (obj instanceof String) {
            return MapBuffer.DataType.STRING;
        }
        if (obj instanceof MapBuffer) {
            return MapBuffer.DataType.MAP;
        }
        throw new IllegalStateException("Key " + i + " has value of unknown type: " + obj.getClass());
    }

    /* JADX INFO: renamed from: com.facebook.react.common.mapbuffer.WritableMapBuffer$iterator$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Iterator<MapBuffer.Entry>, KMappedMarker {
        private int count;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        AnonymousClass1() {
        }

        public final int getCount() {
            return this.count;
        }

        public final void setCount(int i) {
            this.count = i;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.count < WritableMapBuffer.this.values.size();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public MapBuffer.Entry next() {
            WritableMapBuffer writableMapBuffer = WritableMapBuffer.this;
            int i = this.count;
            this.count = i + 1;
            return writableMapBuffer.new MapBufferEntry(i);
        }
    }

    @Override // java.lang.Iterable
    public Iterator<MapBuffer.Entry> iterator() {
        return new AnonymousClass1();
    }

    public final class MapBufferEntry implements MapBuffer.Entry {
        private final int index;
        private final int key;
        private final MapBuffer.DataType type;
        private static final byte[] $$c = {110, 48, -111, -89};
        private static final int $$d = JfifUtil.MARKER_SOI;
        private static int $10 = 0;
        private static int $11 = 1;
        private static final byte[] $$a = {72, -88, 5, 32, -11, -2, Ascii.FF};
        private static final int $$b = 74;
        private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
        private static int artificialFrame = 1;
        private static char[] IPostMessageService = {38184, 38041, 38048, 38043, 38038, 38038, 38059, 38058, 38041, 38046, 38045, 38038, 38041, 38049, 38064, 38057, 38038, 38046, 38048, 38300, 38373, 38351, 38372, 38379, 38364, 38356, 38353, 38360, 38361, 38356, 38347, 38355, 38362, 38353, 38353, 38356, 38357, 38356, 38243, 38245, 38248, 38238, 38241, 38249, 38264, 38163, 38268, 38235, 38270, 38147, 38246, 38240, 38236, 38386, 38147, 38238, 38238, 38147, 38151, 38252, 38249, 38244, 38251, 38252, 38151, 38155, 38256, 38257, 38249, 38246, 38153, 38147, 38241, 38251, 38258, 38254, 38249, 38250, 38153, 38155, 38248, 38241, 38242, 38249, 38251, 38243, 38251, 38251, 38241, 38251, 38258, 38256, 38249, 38279, 38352, 38353, 38312, 38384, 38350, 38351, 38358, 38390, 38382, 38345, 38345, 38382, 38386, 38359, 38356, 38351, 38358, 38359, 38386, 38389, 38354, 38348, 38358, 38365, 38363, 38365, 38365, 38358, 38360, 38366, 38360, 38359, 38363, 38311, 38312, 38382, 38345, 38345, 38382, 38386, 38359, 38356, 38351, 38358, 38359, 38386, 38390, 38363, 38364, 38356, 38353, 38388, 38382, 38348, 38358, 38365, 38361, 38356, 38357, 38388, 38382, 38348, 38358, 38365, 38361, 38356, 38357, 38364, 38360, 38353};

        /* JADX WARN: Code duplicated, block: B:10:0x0029  */
        /* JADX WARN: Code duplicated, block: B:8:0x0023  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0029 -> B:11:0x002f). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0029
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        private static java.lang.String $$e(int r6, byte r7, int r8) {
            /*
                int r7 = r7 * 3
                int r7 = r7 + 65
                byte[] r0 = com.facebook.react.common.mapbuffer.WritableMapBuffer.MapBufferEntry.$$c
                int r8 = r8 * 3
                int r8 = 3 - r8
                int r6 = r6 * 4
                int r1 = 1 - r6
                byte[] r1 = new byte[r1]
                r2 = 0
                int r6 = 0 - r6
                if (r0 != 0) goto L19
                r3 = r8
                r4 = r2
                r8 = r6
                goto L2f
            L19:
                r3 = r2
            L1a:
                byte r4 = (byte) r7
                int r8 = r8 + 1
                r1[r3] = r4
                int r4 = r3 + 1
                if (r3 != r6) goto L29
                java.lang.String r6 = new java.lang.String
                r6.<init>(r1, r2)
                return r6
            L29:
                r3 = r0[r8]
                r5 = r8
                r8 = r7
                r7 = r3
                r3 = r5
            L2f:
                int r7 = -r7
                int r7 = r7 + r8
                r8 = r3
                r3 = r4
                goto L1a
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.common.mapbuffer.WritableMapBuffer.MapBufferEntry.$$e(int, byte, int):java.lang.String");
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
                int r7 = r7 * 4
                int r7 = r7 + 4
                int r8 = r8 * 2
                int r8 = 109 - r8
                int r9 = r9 * 4
                int r9 = 4 - r9
                byte[] r0 = com.facebook.react.common.mapbuffer.WritableMapBuffer.MapBufferEntry.$$a
                byte[] r1 = new byte[r9]
                r2 = 0
                if (r0 != 0) goto L17
                r8 = r7
                r3 = r9
                r4 = r2
                goto L2c
            L17:
                r3 = r2
                r6 = r8
                r8 = r7
                r7 = r6
            L1b:
                int r4 = r3 + 1
                byte r5 = (byte) r7
                r1[r3] = r5
                if (r4 != r9) goto L2a
                java.lang.String r7 = new java.lang.String
                r7.<init>(r1, r2)
                r10[r2] = r7
                return
            L2a:
                r3 = r0[r8]
            L2c:
                int r3 = -r3
                int r7 = r7 + r3
                int r8 = r8 + 1
                int r7 = r7 + (-3)
                r3 = r4
                goto L1b
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.common.mapbuffer.WritableMapBuffer.MapBufferEntry.b(int, byte, int, java.lang.Object[]):void");
        }

        public MapBufferEntry(int i) {
            this.index = i;
            this.key = WritableMapBuffer.this.values.keyAt(i);
            Object objValueAt = WritableMapBuffer.this.values.valueAt(i);
            Intrinsics.checkNotNullExpressionValue(objValueAt, "valueAt(...)");
            this.type = WritableMapBuffer.this.dataType(objValueAt, getKey());
        }

        @Override // com.facebook.react.common.mapbuffer.MapBuffer.Entry
        public int getKey() {
            return this.key;
        }

        @Override // com.facebook.react.common.mapbuffer.MapBuffer.Entry
        public MapBuffer.DataType getType() {
            return this.type;
        }

        @Override // com.facebook.react.common.mapbuffer.MapBuffer.Entry
        public boolean getBooleanValue() {
            int key = getKey();
            Object objValueAt = WritableMapBuffer.this.values.valueAt(this.index);
            if (objValueAt == null) {
                throw new IllegalArgumentException(("Key not found: " + key).toString());
            }
            if (!(objValueAt instanceof Boolean)) {
                throw new IllegalStateException(("Expected " + Boolean.class + " for key: " + key + ", found " + objValueAt.getClass() + " instead.").toString());
            }
            return ((Boolean) objValueAt).booleanValue();
        }

        @Override // com.facebook.react.common.mapbuffer.MapBuffer.Entry
        public int getIntValue() {
            int key = getKey();
            Object objValueAt = WritableMapBuffer.this.values.valueAt(this.index);
            if (objValueAt == null) {
                throw new IllegalArgumentException(("Key not found: " + key).toString());
            }
            if (!(objValueAt instanceof Integer)) {
                throw new IllegalStateException(("Expected " + Integer.class + " for key: " + key + ", found " + objValueAt.getClass() + " instead.").toString());
            }
            return ((Number) objValueAt).intValue();
        }

        @Override // com.facebook.react.common.mapbuffer.MapBuffer.Entry
        public long getLongValue() {
            int key = getKey();
            Object objValueAt = WritableMapBuffer.this.values.valueAt(this.index);
            if (objValueAt == null) {
                throw new IllegalArgumentException(("Key not found: " + key).toString());
            }
            if (!(objValueAt instanceof Long)) {
                throw new IllegalStateException(("Expected " + Long.class + " for key: " + key + ", found " + objValueAt.getClass() + " instead.").toString());
            }
            return ((Number) objValueAt).longValue();
        }

        @Override // com.facebook.react.common.mapbuffer.MapBuffer.Entry
        public double getDoubleValue() {
            int key = getKey();
            Object objValueAt = WritableMapBuffer.this.values.valueAt(this.index);
            if (objValueAt == null) {
                throw new IllegalArgumentException(("Key not found: " + key).toString());
            }
            if (!(objValueAt instanceof Double)) {
                throw new IllegalStateException(("Expected " + Double.class + " for key: " + key + ", found " + objValueAt.getClass() + " instead.").toString());
            }
            return ((Number) objValueAt).doubleValue();
        }

        @Override // com.facebook.react.common.mapbuffer.MapBuffer.Entry
        public String getStringValue() {
            int key = getKey();
            Object objValueAt = WritableMapBuffer.this.values.valueAt(this.index);
            if (objValueAt == null) {
                throw new IllegalArgumentException(("Key not found: " + key).toString());
            }
            if (!(objValueAt instanceof String)) {
                throw new IllegalStateException(("Expected " + String.class + " for key: " + key + ", found " + objValueAt.getClass() + " instead.").toString());
            }
            return (String) objValueAt;
        }

        @Override // com.facebook.react.common.mapbuffer.MapBuffer.Entry
        public MapBuffer getMapBufferValue() {
            int key = getKey();
            Object objValueAt = WritableMapBuffer.this.values.valueAt(this.index);
            if (objValueAt == null) {
                throw new IllegalArgumentException(("Key not found: " + key).toString());
            }
            if (!(objValueAt instanceof MapBuffer)) {
                throw new IllegalStateException(("Expected " + MapBuffer.class + " for key: " + key + ", found " + objValueAt.getClass() + " instead.").toString());
            }
            return (MapBuffer) objValueAt;
        }

        private static void a(byte[] bArr, int[] iArr, boolean z, Object[] objArr) throws Throwable {
            char[] cArr;
            int i;
            int i2 = 2 % 2;
            onPostMessage onpostmessage = new onPostMessage();
            int i3 = 0;
            int i4 = iArr[0];
            int i5 = 1;
            int i6 = iArr[1];
            int i7 = iArr[2];
            int i8 = iArr[3];
            char[] cArr2 = IPostMessageService;
            long j = 0;
            if (cArr2 != null) {
                int length = cArr2.length;
                char[] cArr3 = new char[length];
                int i9 = 0;
                while (i9 < length) {
                    try {
                        Object[] objArr2 = new Object[i5];
                        objArr2[i3] = Integer.valueOf(cArr2[i9]);
                        Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1782207618);
                        if (objAccessartificialFrame == null) {
                            int offsetBefore = 11 - TextUtils.getOffsetBefore("", i3);
                            char offsetBefore2 = (char) TextUtils.getOffsetBefore("", i3);
                            int packedPositionGroup = ExpandableListView.getPackedPositionGroup(j) + 1562;
                            byte b = (byte) i3;
                            byte b2 = b;
                            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(offsetBefore, offsetBefore2, packedPositionGroup, 178318710, false, $$e(b, b2, b2), new Class[]{Integer.TYPE});
                        }
                        cArr3[i9] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                        i9++;
                        i3 = 0;
                        i5 = 1;
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
            char[] cArr4 = new char[i6];
            System.arraycopy(cArr2, i4, cArr4, 0, i6);
            if (bArr != null) {
                char[] cArr5 = new char[i6];
                onpostmessage.a = 0;
                char c = 0;
                while (onpostmessage.a < i6) {
                    if (bArr[onpostmessage.a] == 1) {
                        int i10 = onpostmessage.a;
                        Object[] objArr3 = {Integer.valueOf(cArr4[onpostmessage.a]), Integer.valueOf(c)};
                        Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1378437083);
                        if (objAccessartificialFrame2 == null) {
                            byte b3 = (byte) 0;
                            byte b4 = (byte) (b3 + 1);
                            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(23 - View.MeasureSpec.makeMeasureSpec(0, 0), (char) (MotionEvent.axisFromString("") + 1), 2441 - KeyEvent.normalizeMetaState(0), -850656813, false, $$e(b3, b4, (byte) (b4 - 1)), new Class[]{Integer.TYPE, Integer.TYPE});
                        }
                        cArr5[i10] = ((Character) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).charValue();
                    } else {
                        int i11 = onpostmessage.a;
                        Object[] objArr4 = {Integer.valueOf(cArr4[onpostmessage.a]), Integer.valueOf(c)};
                        Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-314759072);
                        if (objAccessartificialFrame3 == null) {
                            byte b5 = (byte) 0;
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(11 - Color.argb(0, 0, 0, 0), (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 1563, 1918398056, false, $$e(b5, (byte) (b5 | 19), b5), new Class[]{Integer.TYPE, Integer.TYPE});
                        }
                        cArr5[i11] = ((Character) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).charValue();
                    }
                    c = cArr5[onpostmessage.a];
                    Object[] objArr5 = {onpostmessage, onpostmessage};
                    Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(898481158);
                    if (objAccessartificialFrame4 == null) {
                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(22 - (ViewConfiguration.getJumpTapTimeout() >> 16), (char) (29363 - ExpandableListView.getPackedPositionGroup(0L)), (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + JfifUtil.MARKER_SOI, -1427572210, false, "F", new Class[]{Object.class, Object.class});
                    }
                    ((Method) objAccessartificialFrame4).invoke(null, objArr5);
                }
                cArr4 = cArr5;
            }
            if (i8 > 0) {
                char[] cArr6 = new char[i6];
                System.arraycopy(cArr4, 0, cArr6, 0, i6);
                int i12 = i6 - i8;
                System.arraycopy(cArr6, 0, cArr4, i12, i8);
                System.arraycopy(cArr6, i8, cArr4, 0, i12);
            }
            if (z) {
                int i13 = $10 + 101;
                $11 = i13 % 128;
                if (i13 % 2 == 0) {
                    cArr = new char[i6];
                    i = 1;
                } else {
                    cArr = new char[i6];
                    i = 0;
                }
                while (true) {
                    onpostmessage.a = i;
                    if (onpostmessage.a >= i6) {
                        break;
                    }
                    int i14 = $11 + 81;
                    $10 = i14 % 128;
                    int i15 = i14 % 2;
                    cArr[onpostmessage.a] = cArr4[(i6 - onpostmessage.a) - 1];
                    i = onpostmessage.a + 1;
                }
                cArr4 = cArr;
            }
            if (i7 > 0) {
                int i16 = 0;
                while (true) {
                    onpostmessage.a = i16;
                    if (onpostmessage.a >= i6) {
                        break;
                    }
                    int i17 = $10 + 115;
                    $11 = i17 % 128;
                    int i18 = i17 % 2;
                    cArr4[onpostmessage.a] = (char) (cArr4[onpostmessage.a] - iArr[2]);
                    i16 = onpostmessage.a + 1;
                }
            }
            objArr[0] = new String(cArr4);
        }

        /* JADX WARN: Code duplicated, block: B:112:0x07f0  */
        /* JADX WARN: Code duplicated, block: B:113:0x07f1 A[Catch: Exception -> 0x084a, TRY_LEAVE, TryCatch #2 {Exception -> 0x084a, blocks: (B:99:0x07ad, B:102:0x07dc, B:104:0x07e3, B:113:0x07f1, B:119:0x082d, B:122:0x0837, B:126:0x0843, B:127:0x0849, B:110:0x07ea, B:115:0x0807, B:118:0x0829, B:121:0x0834), top: B:152:0x07ad, inners: #1 }] */
        /* JADX WARN: Code duplicated, block: B:118:0x0829 A[Catch: all -> 0x0842, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x0842, blocks: (B:115:0x0807, B:118:0x0829, B:121:0x0834), top: B:151:0x0807, outer: #2 }] */
        /* JADX WARN: Code duplicated, block: B:121:0x0834 A[Catch: all -> 0x0842, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x0842, blocks: (B:115:0x0807, B:118:0x0829, B:121:0x0834), top: B:151:0x0807, outer: #2 }] */
        /* JADX WARN: Code duplicated, block: B:132:0x0851  */
        /* JADX WARN: Code duplicated, block: B:134:0x0860  */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r11v13 */
        /* JADX WARN: Type inference failed for: r11v7 */
        /* JADX WARN: Type inference failed for: r11v8, types: [boolean] */
        /* JADX WARN: Type inference failed for: r7v84 */
        /* JADX WARN: Type inference failed for: r7v95 */
        public static Object[] coroutineCreation(int i, int i2) throws Throwable {
            Object[] objArr;
            String str;
            String line;
            int i3;
            byte[] bArr;
            ?? r11;
            int[] iArr;
            boolean zEquals;
            int i4;
            int i5;
            FileReader fileReader;
            BufferedReader bufferedReader;
            String line2;
            String str2;
            int i6;
            String line3;
            byte[] bArr2;
            char c;
            int[] iArr2;
            int i7;
            int i8;
            String str3;
            Object obj;
            int i9;
            int i10;
            int i11;
            int i12;
            int i13 = 2 % 2;
            try {
                Object[] objArr2 = new Object[1];
                a(new byte[]{1, 1, 0, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 1, 1}, new int[]{0, 19, 187, 17}, true, objArr2);
                Object[] objArr3 = new Object[1];
                a(new byte[]{0, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1}, new int[]{19, 18, 0, 11}, false, objArr3);
                String[] strArr = {(String) objArr2[0], (String) objArr3[0]};
                int i14 = 0;
                while (true) {
                    if (i14 >= 2) {
                        objArr = new Object[4];
                        int[] iArr3 = new int[1];
                        int i15 = artificialFrame;
                        int i16 = (i15 ^ 83) + ((i15 & 83) << 1);
                        int i17 = i16 % 128;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i17;
                        int i18 = i16 % 2;
                        objArr[0] = iArr3;
                        int[] iArr4 = new int[1];
                        objArr[1] = iArr4;
                        objArr[2] = new int[1];
                        int i19 = (i17 ^ b.f40o) + ((i17 & b.f40o) << 1);
                        artificialFrame = i19 % 128;
                        int i20 = i19 % 2;
                        iArr3[0] = i;
                        iArr4[0] = i;
                        objArr[3] = null;
                        int i21 = i17 + 17;
                        artificialFrame = i21 % 128;
                        int i22 = i21 % 2;
                        int iMyPid = Process.myPid();
                        int i23 = (-307010882) + (((~((-486940193) | (~iMyPid))) | (~(491683582 | iMyPid))) * (-272)) + (((~((-486948589) | iMyPid)) | 8396) * (-272)) + (((~(iMyPid | 486948588)) | 491675186) * 272);
                        int i24 = (i2 & i23) + (i2 | i23);
                        int i25 = artificialFrame + 123;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i25 % 128;
                        if (i25 % 2 != 0) {
                            int i26 = i24 << 2;
                            int i27 = (i24 | i26) & (~(i24 & i26));
                            int i28 = i27 * 116;
                            i8 = ((~i27) & i28) | ((~i28) & i27);
                        } else {
                            int i29 = i24 << 13;
                            int i30 = (i24 | i29) & (~(i24 & i29));
                            i8 = i30 ^ (i30 >>> 17);
                        }
                        int i31 = i8 << 5;
                        ((int[]) objArr[2])[0] = ((~i8) & i31) | ((~i31) & i8);
                        break;
                    }
                    int i32 = getARTIFICIAL_FRAME_PACKAGE_NAME + 113;
                    artificialFrame = i32 % 128;
                    if (i32 % 2 == 0) {
                        str3 = strArr[i14];
                        Object[] objArr4 = new Object[1];
                        a(new byte[]{1, 0, 1, 0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1}, new int[]{37, 16, 115, 3}, true, objArr4);
                        obj = objArr4[0];
                    } else {
                        str3 = strArr[i14];
                        Object[] objArr5 = new Object[1];
                        a(new byte[]{1, 0, 1, 0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1}, new int[]{37, 16, 115, 3}, true, objArr5);
                        obj = objArr5[0];
                    }
                    Class<?> cls = Class.forName((String) obj);
                    if (((Boolean) cls.getMethod(str3, new Class[0]).invoke(cls, null)).booleanValue()) {
                        int i33 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                        int i34 = (i33 & 25) + (i33 | 25);
                        int i35 = i34 % 128;
                        artificialFrame = i35;
                        if (i34 % 2 == 0) {
                            i9 = i ^ 1;
                            objArr = new Object[4];
                            objArr[0] = new int[1];
                        } else {
                            i9 = i ^ 1;
                            objArr = new Object[4];
                            objArr[0] = new int[1];
                        }
                        int[] iArr5 = new int[1];
                        objArr[1] = iArr5;
                        objArr[2] = new int[1];
                        ((int[]) objArr[0])[0] = i;
                        iArr5[0] = i9;
                        int i36 = i35 + b.f40o;
                        int i37 = i36 % 128;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i37;
                        if (i36 % 2 != 0) {
                            objArr[2] = null;
                            int i38 = (-2014000914) + (((~((-244108304) | i)) | 176472079) * 104) + ((~((~i) | 802151695)) * (-104)) + ((734515471 | i) * 104);
                            i10 = ((i38 | 16) << 1) - (i38 ^ 16);
                        } else {
                            objArr[3] = null;
                            int i39 = ~i;
                            i10 = 1180270408 + (((~(775669637 | i39)) | 4120) * (-108)) + (((~(i39 | 202954137)) | (~((-202954138) | i)) | 572719620) * 54) + ((i | 572719620) * 54) + 16;
                        }
                        int i40 = i10 * 758;
                        int i41 = -(-(i2 * (-756)));
                        int i42 = ((i40 | i41) << 1) - (i40 ^ i41);
                        int i43 = ((~i) | i10) * (-757);
                        int i44 = ((i42 | i43) << 1) - (i43 ^ i42);
                        int i45 = ~i2;
                        int i46 = (i45 ^ i10) | (i45 & i10);
                        int i47 = (~((i46 & i) | (i46 ^ i))) * 1514;
                        int i48 = (i44 ^ i47) + ((i44 & i47) << 1);
                        int i49 = ~i10;
                        int i50 = ~i2;
                        int i51 = ~((i49 ^ i50) | (i49 & i50));
                        int i52 = (i37 & 117) + (i37 | 117);
                        artificialFrame = i52 % 128;
                        if (i52 % 2 == 0) {
                            int i53 = (~(i45 | (~i))) | i51;
                            int i54 = (i10 & i2) | (i10 ^ i2);
                            int i55 = ~((i54 & i) | (i54 ^ i));
                            int i56 = -(-(757 >> ((i55 & i53) | (i53 ^ i55))));
                            i11 = ((i48 | i56) << 1) - (i56 ^ i48);
                            i12 = i11 - 98;
                        } else {
                            int i57 = ~i;
                            int i58 = (~((i45 ^ i57) | (i45 & i57))) | i51;
                            int i59 = i10 | i2;
                            int i60 = ~((i59 & i) | (i59 ^ i));
                            int i61 = -(-(((i60 & i58) | (i58 ^ i60)) * 757));
                            i11 = (i48 ^ i61) + ((i61 & i48) << 1);
                            i12 = i11 << 13;
                        }
                        int i62 = (i12 | i11) & (~(i11 & i12));
                        int i63 = i62 >>> 17;
                        int i64 = ((~i62) & i63) | ((~i63) & i62);
                        int i65 = i64 << 5;
                        ((int[]) objArr[2])[0] = (i64 | i65) & (~(i64 & i65));
                        break;
                    }
                    i14 = ((i14 | 1) << 1) - (i14 ^ 1);
                }
            } catch (Exception unused) {
                int i66 = ~i;
                objArr = new Object[]{new int[]{i}, new int[]{(i & (-3)) | (i66 & 2)}, new int[1], null};
                int iUptimeMillis = (int) SystemClock.uptimeMillis();
                int i67 = ~iUptimeMillis;
                int i68 = 185978664 + (((~(i67 | (-74620814))) | 1053244588) * (-1042)) + (((-74620814) | iUptimeMillis) * 521) + (((~(iUptimeMillis | (-1053244589))) | 981803040 | (~(i67 | (-3179266)))) * 521);
                int i69 = i68 * (-753);
                int i70 = ((12080 | i69) << 1) - (i69 ^ 12080);
                int i71 = ~((-17) | i68);
                int i72 = ~(((-17) ^ i) | ((-17) & i));
                int i73 = (i70 - (~(-(-((((i72 & i71) | (i71 ^ i72)) | (~(i68 | i))) * (-754)))))) - 1;
                int i74 = ((-17) ^ i68) | ((-17) & i68);
                int i75 = ~((i74 & i) | (i74 ^ i));
                int i76 = ~((i66 ^ 16) | (i66 & 16) | i68);
                int i77 = -(-(((i75 & i76) | (i75 ^ i76)) * (-754)));
                int i78 = (i73 & i77) + (i77 | i73);
                int i79 = -(-((((-17) ^ i66) | (i66 & (-17))) * 754));
                int i80 = (i78 ^ i79) + ((i79 & i78) << 1);
                int iRequestPostMessageChannelWithExtras = zzd.requestPostMessageChannelWithExtras();
                int i81 = ((i80 * 46) - (~(i2 * 46))) - 1;
                int i82 = ~i2;
                int i83 = ~iRequestPostMessageChannelWithExtras;
                int i84 = ~(i82 | i83);
                int i85 = (i81 - (~(((i80 ^ i84) | (i84 & i80)) * (-90)))) - 1;
                int i86 = ~((i82 & iRequestPostMessageChannelWithExtras) | (i82 ^ iRequestPostMessageChannelWithExtras));
                int i87 = ~(i80 | i2);
                int i88 = i85 + (((i86 ^ i87) | (i86 & i87)) * (-45));
                int i89 = ~i2;
                int i90 = ~i80;
                int i91 = ~((i90 ^ iRequestPostMessageChannelWithExtras) | (iRequestPostMessageChannelWithExtras & i90));
                int i92 = (i91 & i89) | (i89 ^ i91);
                int i93 = ~((i80 & i83) | (i83 ^ i80));
                int i94 = (i88 - (~(((i92 & i93) | (i92 ^ i93)) * 45))) - 1;
                int i95 = i94 << 13;
                int i96 = (i95 | i94) & (~(i94 & i95));
                int i97 = i96 >>> 17;
                int i98 = (i96 | i97) & (~(i96 & i97));
                int i99 = i98 << 5;
                ((int[]) objArr[2])[0] = (i98 | i99) & (~(i98 & i99));
            }
            if (i == ((int[]) objArr[1])[0]) {
                try {
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(590025679);
                    if (objAccessartificialFrame == null) {
                        int bitsPerPixel = ImageFormat.getBitsPerPixel(0) + 10;
                        char cIndexOf = (char) (64609 - TextUtils.indexOf((CharSequence) "", '0', 0));
                        int iGreen = 1806 - Color.green(0);
                        byte b = (byte) 0;
                        byte b2 = b;
                        Object[] objArr6 = new Object[1];
                        b(b, b2, b2, objArr6);
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(bitsPerPixel, cIndexOf, iGreen, -1135716921, false, (String) objArr6[0], new Class[0]);
                    }
                    long jLongValue = ((Long) ((Method) objAccessartificialFrame).invoke(null, null)).longValue();
                    int i100 = artificialFrame;
                    int i101 = (i100 & 81) + (i100 | 81);
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i101 % 128;
                    int i102 = i101 % 2;
                    long j = -1212777495;
                    long j2 = -406;
                    long j3 = -1;
                    long j4 = jLongValue ^ j3;
                    long jUptimeMillis = (int) SystemClock.uptimeMillis();
                    long j5 = jUptimeMillis ^ j3;
                    long j6 = (((long) (-405)) * j) + (((long) 407) * jLongValue) + ((((j4 | jUptimeMillis) ^ j3) | (((j5 | j) | jLongValue) ^ j3)) * j2) + (j2 * (((j4 | j5) | j) ^ j3)) + (((long) 406) * (((jUptimeMillis | (j ^ j3)) ^ j3) | (j3 ^ (j5 | jLongValue)))) + ((long) 1552985529);
                    int i103 = 362304178 + (((~((-1064048892) | i)) | (-1065237760)) * (-502));
                    int i104 = ~i;
                    int i105 = ((int) (j6 >> 32)) & (i103 + ((~((-692060241) | i104)) * (-502)) + (((-1064048892) | (~((-373177520) | i))) * TypedValues.PositionType.TYPE_DRAWPATH));
                    int iMyUid = Process.myUid();
                    int i106 = ~iMyUid;
                    int i107 = ((int) j6) & (625219510 + (((~(i106 | (-20834414))) | 2910252 | (~(1434316157 | iMyUid))) * 717) + (((~(iMyUid | (-20834414))) | (~(i106 | 1434316157)) | 2910252) * 717));
                    long j7 = (i105 & i107) | (i105 ^ i107);
                    int i108 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                    int i109 = (i108 & 33) + (i108 | 33);
                    artificialFrame = i109 % 128;
                    int i110 = i109 % 2;
                    if (((int) j7) == 1) {
                        Object[] objArr7 = {new int[]{i}, new int[]{(~(i & 10)) & (i | 10)}, new int[1], null};
                        int iMaxMemory = (int) Runtime.getRuntime().maxMemory();
                        int i111 = 29494467 + (((~(iMaxMemory | 565530844)) | 413092930) * 191) + (((~((~iMaxMemory) | 565530844)) | 403311618) * 191);
                        int iRequestPostMessageChannelWithExtras2 = zzd.requestPostMessageChannelWithExtras();
                        int i112 = i111 * (-445);
                        int i113 = ((-7120) & i112) + (i112 | (-7120));
                        int i114 = ~i111;
                        int i115 = ~(((-17) ^ i114) | ((-17) & i114));
                        int i116 = ~i111;
                        int i117 = ~iRequestPostMessageChannelWithExtras2;
                        int i118 = (i113 - (~(-(-((i115 | (~((i117 & i116) | (i116 ^ i117)))) * 446))))) - 1;
                        int i119 = ~(i111 | (-17));
                        int i120 = (i114 & 16) | (i114 ^ 16);
                        int i121 = ~((iRequestPostMessageChannelWithExtras2 & i120) | (i120 ^ iRequestPostMessageChannelWithExtras2));
                        int i122 = (i118 - (~(((i121 & i119) | (i119 ^ i121)) * 446))) - 1;
                        int i123 = -(-((~(((-17) & i116) | ((-17) ^ i116))) * 446));
                        int i124 = (i122 & i123) + (i123 | i122);
                        int iRequestPostMessageChannelWithExtras3 = zzd.requestPostMessageChannelWithExtras();
                        int i125 = i124 * (-830);
                        int i126 = i2 * 832;
                        int i127 = (i125 ^ i126) + ((i125 & i126) << 1);
                        int i128 = ~i2;
                        int i129 = ~iRequestPostMessageChannelWithExtras3;
                        int i130 = ~((i129 & i128) | (i128 ^ i129));
                        int i131 = i124 | i2;
                        int i132 = ~((i131 & iRequestPostMessageChannelWithExtras3) | (i131 ^ iRequestPostMessageChannelWithExtras3));
                        int i133 = ((i130 & i132) | (i130 ^ i132)) * (-831);
                        int i134 = i128 | i124;
                        int i135 = (i127 ^ i133) + ((i133 & i127) << 1) + ((~((i134 & iRequestPostMessageChannelWithExtras3) | (i134 ^ iRequestPostMessageChannelWithExtras3))) * (-1662));
                        int i136 = ~i124;
                        int i137 = ~iRequestPostMessageChannelWithExtras3;
                        int i138 = (~((i124 & iRequestPostMessageChannelWithExtras3) | (i124 ^ iRequestPostMessageChannelWithExtras3))) | (~((i136 & i137) | (i136 ^ i137)));
                        int i139 = ~((iRequestPostMessageChannelWithExtras3 & i2) | (i2 ^ iRequestPostMessageChannelWithExtras3));
                        int i140 = -(-(((i139 & i138) | (i138 ^ i139)) * 831));
                        int i141 = (i135 ^ i140) + ((i140 & i135) << 1);
                        int i142 = i141 << 13;
                        int i143 = (i142 & (~i141)) | ((~i142) & i141);
                        int i144 = i143 >>> 17;
                        int i145 = ((~i143) & i144) | ((~i144) & i143);
                        int i146 = i145 << 5;
                        ((int[]) objArr7[2])[0] = (i145 | i146) & (~(i145 & i146));
                        objArr = objArr7;
                    } else {
                        Object[] objArr8 = {new int[]{i}, new int[]{i}, new int[1], null};
                        int iMyTid = Process.myTid();
                        int i147 = (-2014000914) + (((~((-141101110) | iMyTid)) | 6881313) * 104) + ((~((~iMyTid) | 971742461)) * (-104)) + ((iMyTid | 837522665) * 104);
                        int i148 = (i2 & i147) + (i2 | i147);
                        int i149 = i148 << 13;
                        int i150 = (i148 | i149) & (~(i148 & i149));
                        int i151 = i150 >>> 17;
                        int i152 = ((~i150) & i151) | ((~i151) & i150);
                        int i153 = i152 << 5;
                        ((int[]) objArr8[2])[0] = (i152 | i153) & (~(i152 & i153));
                        int i154 = getARTIFICIAL_FRAME_PACKAGE_NAME + 15;
                        artificialFrame = i154 % 128;
                        int i155 = i154 % 2;
                        objArr = objArr8;
                    }
                    int[] iArr6 = (int[]) objArr[1];
                    int i156 = artificialFrame;
                    int i157 = ((i156 | 69) << 1) - (i156 ^ 69);
                    int i158 = i157 % 128;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i158;
                    int i159 = i157 % 2;
                    if (i != iArr6[0]) {
                        int i160 = i158 + 117;
                        artificialFrame = i160 % 128;
                        if (i160 % 2 == 0) {
                            Object obj2 = null;
                            obj2.hashCode();
                            throw null;
                        }
                    } else {
                        try {
                            Object[] objArr9 = new Object[1];
                            a(new byte[]{0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 1, 1, 0, 1, 1, 0, 1, 0, 0, 1}, new int[]{53, 40, 107, 0}, false, objArr9);
                            File file = new File((String) objArr9[0]);
                            if (!(!file.canRead())) {
                                FileReader fileReader2 = new FileReader(file);
                                BufferedReader bufferedReader2 = new BufferedReader(fileReader2);
                                int i161 = ((~((1028360078 & i) | (1028360078 ^ i))) | (-1073448879)) * 1504;
                                int i162 = ((-1891886682) ^ i161) + ((i161 & (-1891886682)) << 1);
                                int i163 = -(-((~(((-45088801) & i) | ((-45088801) ^ i))) * (-1504)));
                                int i164 = ((i162 | i163) << 1) - (i163 ^ i162);
                                int i165 = (i164 ^ (-444890688)) + (((-444890688) & i164) << 1);
                                int i166 = ~i;
                                int i167 = ~((2145385919 & i166) | (2145385919 ^ i166));
                                int i168 = ~(((-1808530735) & i) | ((-1808530735) ^ i));
                                int i169 = (-1171127367) + (((i167 & i168) | (i167 ^ i168)) * 520);
                                int i170 = ~((i166 & 1808530734) | (1808530734 ^ i166));
                                int i171 = ((-1449122976) & i) | ((-1449122976) ^ i);
                                int i172 = ~i171;
                                int i173 = -(-(((i170 & i172) | (i170 ^ i172)) * (-1040)));
                                int i174 = (i169 & i173) + (i173 | i169);
                                int i175 = ~((1449122975 & i104) | (1449122975 ^ i104));
                                try {
                                    if (i165 > i174 + (((i175 & 336855185) | (i175 ^ 336855185) | (~i171)) * 520)) {
                                        line3 = bufferedReader2.readLine();
                                        bArr2 = new byte[]{0, 1, 1};
                                        iArr2 = new int[]{93, 3, 0, 0};
                                        int i176 = 84 / 0;
                                        i7 = 1;
                                        c = 0;
                                    } else {
                                        line3 = bufferedReader2.readLine();
                                        bArr2 = new byte[]{0, 1, 1};
                                        c = 0;
                                        iArr2 = new int[]{93, 3, 0, 0};
                                        i7 = 1;
                                    }
                                    Object[] objArr10 = new Object[i7];
                                    a(bArr2, iArr2, i7, objArr10);
                                    if (line3.equals((String) objArr10[c])) {
                                        fileReader2.close();
                                        bufferedReader2.close();
                                        int i177 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                        int i178 = (i177 & 27) + (i177 | 27);
                                        artificialFrame = i178 % 128;
                                        if (i178 % 2 == 0) {
                                            int i179 = 2 % 5;
                                        }
                                        str = null;
                                    } else {
                                        int i180 = artificialFrame;
                                        int i181 = ((i180 | 89) << 1) - (i180 ^ 89);
                                        getARTIFICIAL_FRAME_PACKAGE_NAME = i181 % 128;
                                        int i182 = i181 % 2;
                                        fileReader2.close();
                                        bufferedReader2.close();
                                        str = line3;
                                    }
                                } catch (Throwable th) {
                                    fileReader2.close();
                                    bufferedReader2.close();
                                    throw th;
                                }
                            } else {
                                int i183 = artificialFrame;
                                int i184 = ((i183 | 3) << 1) - (i183 ^ 3);
                                getARTIFICIAL_FRAME_PACKAGE_NAME = i184 % 128;
                                int i185 = i184 % 2;
                                str = null;
                            }
                        } catch (Exception unused2) {
                        }
                        try {
                            Object[] objArr11 = new Object[1];
                            a(new byte[]{1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1}, new int[]{96, 31, 0, 0}, false, objArr11);
                            File file2 = new File((String) objArr11[0]);
                            if (file2.canRead()) {
                                FileReader fileReader3 = new FileReader(file2);
                                BufferedReader bufferedReader3 = new BufferedReader(fileReader3);
                                int i186 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                int i187 = ((i186 | 13) << 1) - (i186 ^ 13);
                                artificialFrame = i187 % 128;
                                try {
                                    if (i187 % 2 == 0) {
                                        line = bufferedReader3.readLine();
                                        bArr = new byte[]{1};
                                        iArr = new int[]{127, 1, 0, 0};
                                        int i188 = 67 / 0;
                                        i3 = 1;
                                        r11 = 0;
                                    } else {
                                        line = bufferedReader3.readLine();
                                        i3 = 1;
                                        r11 = 0;
                                        bArr = new byte[]{1};
                                        iArr = new int[]{127, 1, 0, 0};
                                    }
                                    Object[] objArr12 = new Object[i3];
                                    a(bArr, iArr, r11, objArr12);
                                    boolean zEquals2 = line.equals((String) objArr12[r11]);
                                    fileReader3.close();
                                    bufferedReader3.close();
                                    if (zEquals2) {
                                        try {
                                            Object[] objArr13 = new Object[1];
                                            a(new byte[]{1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 0, 1}, new int[]{128, 36, 0, 0}, false, objArr13);
                                            File file3 = new File((String) objArr13[0]);
                                            int i189 = artificialFrame;
                                            int i190 = ((i189 | b.f40o) << 1) - (i189 ^ b.f40o);
                                            getARTIFICIAL_FRAME_PACKAGE_NAME = i190 % 128;
                                            if (i190 % 2 != 0) {
                                                int i191 = 79 / 0;
                                                if (file3.canRead()) {
                                                    fileReader = new FileReader(file3);
                                                    bufferedReader = new BufferedReader(fileReader);
                                                    int i192 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                                    int i193 = (i192 & 7) + (i192 | 7);
                                                    artificialFrame = i193 % 128;
                                                    int i194 = i193 % 2;
                                                    try {
                                                        line2 = bufferedReader.readLine();
                                                        Object[] objArr14 = new Object[1];
                                                        a(new byte[]{1}, new int[]{127, 1, 0, 0}, false, objArr14);
                                                        str2 = (String) objArr14[0];
                                                        i6 = getARTIFICIAL_FRAME_PACKAGE_NAME + 39;
                                                        artificialFrame = i6 % 128;
                                                        if (i6 % 2 != 0) {
                                                            line2.equals(str2);
                                                            fileReader.close();
                                                            bufferedReader.close();
                                                            Object obj3 = null;
                                                            obj3.hashCode();
                                                            throw null;
                                                        }
                                                        zEquals = line2.equals(str2);
                                                        fileReader.close();
                                                        bufferedReader.close();
                                                    } catch (Throwable th2) {
                                                        fileReader.close();
                                                        bufferedReader.close();
                                                        throw th2;
                                                    }
                                                } else {
                                                    zEquals = false;
                                                }
                                                if (!(!zEquals)) {
                                                    int i195 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                                    int i196 = ((i195 | AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY) << 1) - (i195 ^ AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY);
                                                    artificialFrame = i196 % 128;
                                                    int i197 = i196 % 2;
                                                    if (str != null) {
                                                        objArr = new Object[]{new int[]{i}, new int[]{(i & (-21)) | (i104 & 20)}, new int[1], str};
                                                        int elapsedCpuTime = (int) Process.getElapsedCpuTime();
                                                        int i198 = (((-507046658) + (((~((-882111810) | elapsedCpuTime)) | 75539777) * 1504)) + ((~(elapsedCpuTime | (-806572033))) * (-1504))) - 457004480;
                                                        int i199 = (i198 & 16) + (16 | i198);
                                                        int iRequestPostMessageChannelWithExtras4 = zzd.requestPostMessageChannelWithExtras();
                                                        int i200 = i199 * 70;
                                                        int i201 = i2 * (-68);
                                                        int i202 = (i200 ^ i201) + ((i200 & i201) << 1);
                                                        int i203 = ~i199;
                                                        int i204 = ~i2;
                                                        int i205 = ~((i203 & i204) | (i203 ^ i204) | iRequestPostMessageChannelWithExtras4);
                                                        int i206 = (i199 ^ i2) | (i199 & i2);
                                                        int i207 = ~((i206 & iRequestPostMessageChannelWithExtras4) | (i206 ^ iRequestPostMessageChannelWithExtras4));
                                                        int i208 = (i202 - (~(-(-(((i205 & i207) | (i205 ^ i207)) * 69))))) - 1;
                                                        int i209 = ~i199;
                                                        int i210 = ~((i209 ^ i2) | (i209 & i2));
                                                        int i211 = ~((i209 & iRequestPostMessageChannelWithExtras4) | (i209 ^ iRequestPostMessageChannelWithExtras4));
                                                        int i212 = (i211 & i210) | (i210 ^ i211);
                                                        int i213 = ~((iRequestPostMessageChannelWithExtras4 & i2) | (i2 ^ iRequestPostMessageChannelWithExtras4));
                                                        int i214 = (i208 - (~(-(-(((i213 & i212) | (i212 ^ i213)) * (-69)))))) - 1;
                                                        int i215 = -(-((~(i199 | (~i2))) * 69));
                                                        int i216 = (i214 ^ i215) + ((i215 & i214) << 1);
                                                        int i217 = (i216 << 13) ^ i216;
                                                        int i218 = i217 >>> 17;
                                                        int i219 = ((~i217) & i218) | ((~i218) & i217);
                                                        int i220 = i219 << 5;
                                                        ((int[]) objArr[2])[0] = ((~i219) & i220) | ((~i220) & i219);
                                                        int i221 = artificialFrame;
                                                        i4 = i221 & 79;
                                                        i5 = i221 | 79;
                                                    }
                                                }
                                            } else {
                                                if (file3.canRead()) {
                                                    fileReader = new FileReader(file3);
                                                    bufferedReader = new BufferedReader(fileReader);
                                                    int i1910 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                                    int i1911 = (i1910 & 7) + (i1910 | 7);
                                                    artificialFrame = i1911 % 128;
                                                    int i1912 = i1911 % 2;
                                                    line2 = bufferedReader.readLine();
                                                    Object[] objArr15 = new Object[1];
                                                    a(new byte[]{1}, new int[]{127, 1, 0, 0}, false, objArr15);
                                                    str2 = (String) objArr15[0];
                                                    i6 = getARTIFICIAL_FRAME_PACKAGE_NAME + 39;
                                                    artificialFrame = i6 % 128;
                                                    if (i6 % 2 != 0) {
                                                        line2.equals(str2);
                                                        fileReader.close();
                                                        bufferedReader.close();
                                                        Object obj4 = null;
                                                        obj4.hashCode();
                                                        throw null;
                                                    }
                                                    zEquals = line2.equals(str2);
                                                    fileReader.close();
                                                    bufferedReader.close();
                                                } else {
                                                    zEquals = false;
                                                }
                                                if (!(!zEquals)) {
                                                    int i1913 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                                    int i1914 = ((i1913 | AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY) << 1) - (i1913 ^ AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY);
                                                    artificialFrame = i1914 % 128;
                                                    int i1915 = i1914 % 2;
                                                    if (str != null) {
                                                        objArr = new Object[]{new int[]{i}, new int[]{(i & (-21)) | (i104 & 20)}, new int[1], str};
                                                        int elapsedCpuTime2 = (int) Process.getElapsedCpuTime();
                                                        int i1916 = (((-507046658) + (((~((-882111810) | elapsedCpuTime2)) | 75539777) * 1504)) + ((~(elapsedCpuTime2 | (-806572033))) * (-1504))) - 457004480;
                                                        int i1917 = (i1916 & 16) + (16 | i1916);
                                                        int iRequestPostMessageChannelWithExtras5 = zzd.requestPostMessageChannelWithExtras();
                                                        int i2010 = i1917 * 70;
                                                        int i2011 = i2 * (-68);
                                                        int i2012 = (i2010 ^ i2011) + ((i2010 & i2011) << 1);
                                                        int i2013 = ~i1917;
                                                        int i2014 = ~i2;
                                                        int i2015 = ~((i2013 & i2014) | (i2013 ^ i2014) | iRequestPostMessageChannelWithExtras5);
                                                        int i2016 = (i1917 ^ i2) | (i1917 & i2);
                                                        int i2017 = ~((i2016 & iRequestPostMessageChannelWithExtras5) | (i2016 ^ iRequestPostMessageChannelWithExtras5));
                                                        int i2018 = (i2012 - (~(-(-(((i2015 & i2017) | (i2015 ^ i2017)) * 69))))) - 1;
                                                        int i2019 = ~i1917;
                                                        int i2110 = ~((i2019 ^ i2) | (i2019 & i2));
                                                        int i2111 = ~((i2019 & iRequestPostMessageChannelWithExtras5) | (i2019 ^ iRequestPostMessageChannelWithExtras5));
                                                        int i2112 = (i2111 & i2110) | (i2110 ^ i2111);
                                                        int i2113 = ~((iRequestPostMessageChannelWithExtras5 & i2) | (i2 ^ iRequestPostMessageChannelWithExtras5));
                                                        int i2114 = (i2018 - (~(-(-(((i2113 & i2112) | (i2112 ^ i2113)) * (-69)))))) - 1;
                                                        int i2115 = -(-((~(i1917 | (~i2))) * 69));
                                                        int i2116 = (i2114 ^ i2115) + ((i2115 & i2114) << 1);
                                                        int i2117 = (i2116 << 13) ^ i2116;
                                                        int i2118 = i2117 >>> 17;
                                                        int i2119 = ((~i2117) & i2118) | ((~i2118) & i2117);
                                                        int i222 = i2119 << 5;
                                                        ((int[]) objArr[2])[0] = ((~i2119) & i222) | ((~i222) & i2119);
                                                        int i223 = artificialFrame;
                                                        i4 = i223 & 79;
                                                        i5 = i223 | 79;
                                                    }
                                                }
                                            }
                                        } catch (Exception unused3) {
                                            zEquals = false;
                                        }
                                    }
                                } catch (Throwable th3) {
                                    fileReader3.close();
                                    bufferedReader3.close();
                                    throw th3;
                                }
                            }
                        } catch (Exception unused4) {
                        }
                        objArr = new Object[]{new int[]{i}, new int[]{i}, new int[1], null};
                        int i224 = ~new Random().nextInt(1299240819);
                        int i225 = 1967809726 + (((~(i224 | 283436587)) | (-972027644)) * (-160)) + (((~(i224 | (-695187188))) | 283436587) * SyslogConstants.LOG_LOCAL4);
                        int i226 = -(-(i225 * TSLocationManager.LOCATION_ERROR_TIMEOUT));
                        int i227 = (((i226 << 1) - i226) - (~(-(-(((~(~i225)) | (~i)) * (-814)))))) - 1;
                        int i228 = ~i225;
                        int i229 = ~((i228 & i104) | (i228 ^ i104));
                        int i230 = ~(((-1) ^ i225) | i225);
                        int i231 = (i229 & i230) | (i229 ^ i230);
                        int i232 = ~i;
                        int i233 = (i227 - (~(-(-(((i231 & i232) | (i231 ^ i232)) * 407))))) - 1;
                        int i234 = ~(((-1) ^ i225) | i225);
                        int i235 = ~(((-1) ^ i) | i);
                        int i236 = (i234 & i235) | (i234 ^ i235);
                        int i237 = ~(i | i225);
                        int i238 = (i2 - (~((i233 - (~(-(-(((i236 & i237) | (i236 ^ i237)) * 407))))) - 1))) - 1;
                        int i239 = i238 ^ (i238 << 13);
                        int i240 = i239 >>> 17;
                        int i241 = ((~i239) & i240) | ((~i240) & i239);
                        int i242 = i241 << 5;
                        ((int[]) objArr[2])[0] = (i241 | i242) & (~(i241 & i242));
                    }
                    int i243 = artificialFrame + 65;
                    getARTIFICIAL_FRAME_PACKAGE_NAME = i243 % 128;
                    int i244 = i243 % 2;
                    return objArr;
                } catch (Throwable th4) {
                    Throwable cause = th4.getCause();
                    if (cause != null) {
                        throw cause;
                    }
                    throw th4;
                }
            }
            int i245 = artificialFrame;
            i4 = i245 ^ 99;
            i5 = (i245 & 99) << 1;
            int i246 = i4 + i5;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i246 % 128;
            int i247 = i246 % 2;
            int i248 = artificialFrame + 65;
            getARTIFICIAL_FRAME_PACKAGE_NAME = i248 % 128;
            int i249 = i248 % 2;
            return objArr;
        }
    }

    private final int[] getKeys() {
        int size = this.values.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = this.values.keyAt(i);
        }
        return iArr;
    }

    private final Object[] getValues() {
        int size = this.values.size();
        Object[] objArr = new Object[size];
        for (int i = 0; i < size; i++) {
            Object objValueAt = this.values.valueAt(i);
            Intrinsics.checkNotNullExpressionValue(objValueAt, "valueAt(...)");
            objArr[i] = objValueAt;
        }
        return objArr;
    }

    static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        MapBufferSoLoader.staticInit();
    }
}
