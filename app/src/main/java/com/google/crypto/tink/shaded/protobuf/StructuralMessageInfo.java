package com.google.crypto.tink.shaded.protobuf;

import android.content.Context;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import ch.qos.logback.core.net.SyslogConstants;
import com.facebook.hermes.intl.UnicodeExtensionKeys;
import com.google.common.base.Ascii;
import com.salesforce.marketingcloud.analytics.stats.b;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import o.ArtificialStackFrames;
import o.artificialFrame;
import o.build;

/* JADX INFO: loaded from: classes3.dex */
@CheckReturnValue
public final class StructuralMessageInfo implements MessageInfo {
    private final int[] checkInitialized;
    private final MessageLite defaultInstance;
    private final FieldInfo[] fields;
    private final boolean messageSetWireFormat;
    private final ProtoSyntax syntax;
    private static final byte[] $$a = {Ascii.DC4, 17, 111, Ascii.ESC};
    private static final int $$b = 240;
    private static int $10 = 0;
    private static int $11 = 1;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static char TopicBuilder = 65270;
    private static char ICustomTabsCallback = 48974;
    private static char extraCallbackWithResult = 38875;
    private static char onMessageChannelReady = 7342;
    private static int[] ICustomTabsCallbackStub = {-1896187158, 413905622, -1599141816, 1270264502, -884538541, 1972994421, -975038978, -217411502, 1501965536, -894350164, 1074692403, 1096190096, -981093584, 2108766100, 885362875, 332957365, -466342090, 1083231090};

    /* JADX WARN: Code duplicated, block: B:10:0x0023  */
    /* JADX WARN: Code duplicated, block: B:8:0x001d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x002b). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0023
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$c(int r6, byte r7, byte r8) {
        /*
            int r6 = r6 * 3
            int r0 = r6 + 1
            int r7 = r7 * 3
            int r7 = 3 - r7
            int r8 = 115 - r8
            byte[] r1 = com.google.crypto.tink.shaded.protobuf.StructuralMessageInfo.$$a
            byte[] r0 = new byte[r0]
            r2 = 0
            if (r1 != 0) goto L15
            r3 = r8
            r4 = r2
            r8 = r7
            goto L2b
        L15:
            r3 = r2
        L16:
            byte r4 = (byte) r8
            r0[r3] = r4
            int r4 = r3 + 1
            if (r3 != r6) goto L23
            java.lang.String r6 = new java.lang.String
            r6.<init>(r0, r2)
            return r6
        L23:
            int r7 = r7 + 1
            r3 = r1[r7]
            r5 = r8
            r8 = r7
            r7 = r3
            r3 = r5
        L2b:
            int r7 = r7 + r3
            r3 = r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.StructuralMessageInfo.$$c(int, byte, byte):java.lang.String");
    }

    StructuralMessageInfo(ProtoSyntax protoSyntax, boolean z, int[] iArr, FieldInfo[] fieldInfoArr, Object obj) {
        this.syntax = protoSyntax;
        this.messageSetWireFormat = z;
        this.checkInitialized = iArr;
        this.fields = fieldInfoArr;
        this.defaultInstance = (MessageLite) Internal.checkNotNull(obj, "defaultInstance");
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageInfo
    public ProtoSyntax getSyntax() {
        return this.syntax;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageInfo
    public boolean isMessageSetWireFormat() {
        return this.messageSetWireFormat;
    }

    public int[] getCheckInitialized() {
        return this.checkInitialized;
    }

    public FieldInfo[] getFields() {
        return this.fields;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageInfo
    public MessageLite getDefaultInstance() {
        return this.defaultInstance;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(int i) {
        return new Builder(i);
    }

    /* JADX INFO: loaded from: classes5.dex */
    public static final class Builder {
        private int[] checkInitialized;
        private Object defaultInstance;
        private final List<FieldInfo> fields;
        private boolean messageSetWireFormat;
        private ProtoSyntax syntax;
        private boolean wasBuilt;

        public Builder() {
            this.checkInitialized = null;
            this.fields = new ArrayList();
        }

        public Builder(int i) {
            this.checkInitialized = null;
            this.fields = new ArrayList(i);
        }

        public void withDefaultInstance(Object obj) {
            this.defaultInstance = obj;
        }

        public void withSyntax(ProtoSyntax protoSyntax) {
            this.syntax = (ProtoSyntax) Internal.checkNotNull(protoSyntax, "syntax");
        }

        public void withMessageSetWireFormat(boolean z) {
            this.messageSetWireFormat = z;
        }

        public void withCheckInitialized(int[] iArr) {
            this.checkInitialized = iArr;
        }

        public void withField(FieldInfo fieldInfo) {
            if (this.wasBuilt) {
                throw new IllegalStateException("Builder can only build once");
            }
            this.fields.add(fieldInfo);
        }

        public StructuralMessageInfo build() {
            if (this.wasBuilt) {
                throw new IllegalStateException("Builder can only build once");
            }
            if (this.syntax == null) {
                throw new IllegalStateException("Must specify a proto syntax");
            }
            this.wasBuilt = true;
            Collections.sort(this.fields);
            return new StructuralMessageInfo(this.syntax, this.messageSetWireFormat, this.checkInitialized, (FieldInfo[]) this.fields.toArray(new FieldInfo[0]), this.defaultInstance);
        }
    }

    private static void a(int i, char[] cArr, Object[] objArr) throws Throwable {
        int i2 = 2 % 2;
        build buildVar = new build();
        char[] cArr2 = new char[cArr.length];
        int i3 = 0;
        buildVar.c = 0;
        char[] cArr3 = new char[2];
        while (buildVar.c < cArr.length) {
            cArr3[i3] = cArr[buildVar.c];
            cArr3[1] = cArr[buildVar.c + 1];
            int i4 = 58224;
            int i5 = i3;
            while (i5 < 16) {
                int i6 = $11 + 95;
                $10 = i6 % 128;
                int i7 = i6 % 2;
                char c = cArr3[1];
                char c2 = cArr3[i3];
                char[] cArr4 = cArr3;
                try {
                    Object[] objArr2 = {Integer.valueOf(c), Integer.valueOf((c2 + i4) ^ ((c2 << 4) + ((char) (((long) extraCallbackWithResult) ^ (-4408183324873663413L))))), Integer.valueOf(c2 >>> 5), Integer.valueOf(onMessageChannelReady)};
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1585798252);
                    if (objAccessartificialFrame == null) {
                        byte b = (byte) 0;
                        byte b2 = b;
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(28 - (Process.myTid() >> 22), (char) ((ViewConfiguration.getLongPressTimeout() >> 16) + 17263), (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 1067, 1042277788, false, $$c(b, b2, (byte) (b2 | 7)), new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE});
                    }
                    char cCharValue = ((Character) ((java.lang.reflect.Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                    cArr4[1] = cCharValue;
                    Object[] objArr3 = {Integer.valueOf(cArr4[0]), Integer.valueOf((cCharValue + i4) ^ ((cCharValue << 4) + ((char) (((long) TopicBuilder) ^ (-4408183324873663413L))))), Integer.valueOf(cCharValue >>> 5), Integer.valueOf(ICustomTabsCallback)};
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1585798252);
                    if (objAccessartificialFrame2 == null) {
                        byte b3 = (byte) 0;
                        byte b4 = b3;
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(27 - TextUtils.lastIndexOf("", '0', 0, 0), (char) (17262 - ExpandableListView.getPackedPositionChild(0L)), 1067 - TextUtils.getOffsetAfter("", 0), 1042277788, false, $$c(b3, b4, (byte) (b4 | 7)), new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE});
                    }
                    cArr4[0] = ((Character) ((java.lang.reflect.Method) objAccessartificialFrame2).invoke(null, objArr3)).charValue();
                    i4 -= 40503;
                    i5++;
                    cArr3 = cArr4;
                    i3 = 0;
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
            char[] cArr5 = cArr3;
            cArr2[buildVar.c] = cArr5[0];
            cArr2[buildVar.c + 1] = cArr5[1];
            Object[] objArr4 = {buildVar, buildVar};
            Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1010141908);
            if (objAccessartificialFrame3 == null) {
                byte b5 = (byte) 0;
                byte b6 = b5;
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(25 - View.MeasureSpec.makeMeasureSpec(0, 0), (char) ((ViewConfiguration.getScrollDefaultDelay() >> 16) + 63928), (ViewConfiguration.getDoubleTapTimeout() >> 16) + 486, 1554985764, false, $$c(b5, b6, (byte) (b6 + 5)), new Class[]{Object.class, Object.class});
            }
            ((java.lang.reflect.Method) objAccessartificialFrame3).invoke(null, objArr4);
            cArr3 = cArr5;
            i3 = 0;
        }
        String str = new String(cArr2, 0, i);
        int i8 = $10 + 85;
        $11 = i8 % 128;
        if (i8 % 2 != 0) {
            objArr[0] = str;
        } else {
            Object obj = null;
            obj.hashCode();
            throw null;
        }
    }

    private static void b(int i, int[] iArr, Object[] objArr) throws Throwable {
        int length;
        int[] iArr2;
        int i2 = 2 % 2;
        artificialFrame artificialframe = new artificialFrame();
        char[] cArr = new char[4];
        char[] cArr2 = new char[iArr.length * 2];
        int[] iArr3 = ICustomTabsCallbackStub;
        long j = 0;
        int i3 = -1780896814;
        int i4 = 1;
        int i5 = 0;
        if (iArr3 != null) {
            int i6 = $10 + 59;
            $11 = i6 % 128;
            if (i6 % 2 == 0) {
                length = iArr3.length;
                iArr2 = new int[length];
            } else {
                length = iArr3.length;
                iArr2 = new int[length];
            }
            int i7 = 0;
            while (i7 < length) {
                try {
                    Object[] objArr2 = {Integer.valueOf(iArr3[i7])};
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(i3);
                    if (objAccessartificialFrame == null) {
                        int tapTimeout = 11 - (ViewConfiguration.getTapTimeout() >> 16);
                        char c = (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                        int i8 = 1563 - (SystemClock.elapsedRealtimeNanos() > j ? 1 : (SystemClock.elapsedRealtimeNanos() == j ? 0 : -1));
                        byte b = (byte) 0;
                        byte b2 = b;
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(tapTimeout, c, i8, 180153818, false, $$c(b, b2, (byte) (b2 | 6)), new Class[]{Integer.TYPE});
                    }
                    iArr2[i7] = ((Integer) ((java.lang.reflect.Method) objAccessartificialFrame).invoke(null, objArr2)).intValue();
                    i7++;
                    j = 0;
                    i3 = -1780896814;
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
            iArr3 = iArr2;
        }
        int length2 = iArr3.length;
        int[] iArr4 = new int[length2];
        int[] iArr5 = ICustomTabsCallbackStub;
        if (iArr5 != null) {
            int length3 = iArr5.length;
            int[] iArr6 = new int[length3];
            int i9 = 0;
            while (i9 < length3) {
                Object[] objArr3 = new Object[i4];
                objArr3[i5] = Integer.valueOf(iArr5[i9]);
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1780896814);
                if (objAccessartificialFrame2 == null) {
                    int modifierMetaStateMask = ((byte) KeyEvent.getModifierMetaStateMask()) + Ascii.FF;
                    char fadingEdgeLength = (char) (ViewConfiguration.getFadingEdgeLength() >> 16);
                    int threadPriority = ((Process.getThreadPriority(i5) + 20) >> 6) + 1562;
                    byte b3 = (byte) i5;
                    byte b4 = b3;
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(modifierMetaStateMask, fadingEdgeLength, threadPriority, 180153818, false, $$c(b3, b4, (byte) (b4 | 6)), new Class[]{Integer.TYPE});
                }
                iArr6[i9] = ((Integer) ((java.lang.reflect.Method) objAccessartificialFrame2).invoke(null, objArr3)).intValue();
                i9++;
                i4 = 1;
                i5 = 0;
            }
            iArr5 = iArr6;
        }
        int i10 = i5;
        System.arraycopy(iArr5, i10, iArr4, i10, length2);
        artificialframe.e = i10;
        while (artificialframe.e < iArr.length) {
            int i11 = $11 + 105;
            $10 = i11 % 128;
            int i12 = i11 % 2;
            cArr[0] = (char) (iArr[artificialframe.e] >> 16);
            cArr[1] = (char) iArr[artificialframe.e];
            cArr[2] = (char) (iArr[artificialframe.e + 1] >> 16);
            cArr[3] = (char) iArr[artificialframe.e + 1];
            artificialframe.c = (cArr[0] << 16) + cArr[1];
            artificialframe.b = (cArr[2] << 16) + cArr[3];
            artificialFrame.coroutineBoundary(iArr4);
            int i13 = 0;
            for (int i14 = 16; i13 < i14; i14 = 16) {
                int i15 = $10 + 31;
                $11 = i15 % 128;
                int i16 = i15 % 2;
                artificialframe.c ^= iArr4[i13];
                Object[] objArr4 = {artificialframe, Integer.valueOf(artificialFrame.coroutineBoundary(artificialframe.c)), artificialframe, artificialframe};
                Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1540318455);
                if (objAccessartificialFrame3 == null) {
                    byte b5 = (byte) 0;
                    byte b6 = b5;
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 27, (char) (ViewConfiguration.getFadingEdgeLength() >> 16), (ViewConfiguration.getWindowTouchSlop() >> 8) + 1041, 995482881, false, $$c(b5, b6, b6), new Class[]{Object.class, Integer.TYPE, Object.class, Object.class});
                }
                int iIntValue = ((Integer) ((java.lang.reflect.Method) objAccessartificialFrame3).invoke(null, objArr4)).intValue();
                artificialframe.c = artificialframe.b;
                artificialframe.b = iIntValue;
                i13++;
            }
            int i17 = artificialframe.c;
            artificialframe.c = artificialframe.b;
            artificialframe.b = i17;
            artificialframe.b ^= iArr4[16];
            artificialframe.c ^= iArr4[17];
            int i18 = artificialframe.c;
            int i19 = artificialframe.b;
            cArr[0] = (char) (artificialframe.c >>> 16);
            cArr[1] = (char) artificialframe.c;
            cArr[2] = (char) (artificialframe.b >>> 16);
            cArr[3] = (char) artificialframe.b;
            artificialFrame.coroutineBoundary(iArr4);
            cArr2[artificialframe.e * 2] = cArr[0];
            cArr2[(artificialframe.e * 2) + 1] = cArr[1];
            cArr2[(artificialframe.e * 2) + 2] = cArr[2];
            cArr2[(artificialframe.e * 2) + 3] = cArr[3];
            Object[] objArr5 = {artificialframe, artificialframe};
            Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(1348396126);
            if (objAccessartificialFrame4 == null) {
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getTouchSlop() >> 8) + 37, (char) (28010 - Color.argb(0, 0, 0, 0)), 305 - ImageFormat.getBitsPerPixel(0), -818175402, false, "q", new Class[]{Object.class, Object.class});
            }
            ((java.lang.reflect.Method) objAccessartificialFrame4).invoke(null, objArr5);
        }
        objArr[0] = new String(cArr2, 0, i);
    }

    public static Object[] accessartificialFrame(Context context, int i, int i2) {
        int i3;
        int i4;
        Class<?> cls;
        int i5;
        int[] iArr;
        Class<?> cls2;
        int threadPriority;
        int i6;
        int i7;
        Object objInvoke;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        char c;
        int i14;
        int i15 = 2;
        int i16 = 2 % 2;
        int i17 = 1;
        if (context == null) {
            int[] iArr2 = new int[1];
            Object[] objArr = {new int[]{i}, new int[]{i}, iArr2, null};
            int i18 = ~i;
            int i19 = -(-(((((~((-866373727) | i18)) | 44089408) * (-241)) - 527575842) + (((~(i18 | (-822284319))) | 68160640) * 241)));
            int i20 = ((i2 | i19) << 1) - (i19 ^ i2);
            int i21 = i20 << 13;
            int i22 = (i21 & (~i20)) | ((~i21) & i20);
            int i23 = i22 >>> 17;
            int i24 = (i22 | i23) & (~(i22 & i23));
            int i25 = i24 << 5;
            iArr2[0] = ((~i24) & i25) | ((~i25) & i24);
            int i26 = getARTIFICIAL_FRAME_PACKAGE_NAME + 89;
            artificialFrame = i26 % 128;
            int i27 = i26 % 2;
            return objArr;
        }
        try {
            int iIndexOf = TextUtils.indexOf((CharSequence) "", '0');
            int i28 = iIndexOf * (-501);
            int i29 = (i28 ^ 19617) + ((i28 & 19617) << 1);
            int i30 = ~(((-40) ^ i) | ((-40) & i));
            int i31 = ~((iIndexOf ^ 39) | (iIndexOf & 39));
            int i32 = ((i30 & i31) | (i30 ^ i31)) * (-502);
            int i33 = (i29 ^ i32) + ((i29 & i32) << 1);
            int i34 = ~i;
            int i35 = ((-40) & i34) | ((-40) ^ i34);
            int i36 = -(-((~((i35 & iIndexOf) | (i35 ^ iIndexOf))) * (-502)));
            int i37 = (i33 & i36) + (i36 | i33);
            int i38 = ~iIndexOf;
            int i39 = ~((i38 & i) | (i38 ^ i));
            Object[] objArr2 = new Object[1];
            a(i37 + (((i39 & (-40)) | ((-40) ^ i39)) * TypedValues.PositionType.TYPE_DRAWPATH), new char[]{30537, 63068, 34439, 25753, 61988, 19402, 48877, 11963, 47567, 23988, 43232, 36637, 26575, 25512, 20027, 4519, 9317, 64457, 13073, 45728, 28205, 63802, 56576, 40445, 47422, 12820, 22448, 46365, 20139, 41736, 43232, 36637, 5619, 55856, 55287, 61445, 41091, 55299}, objArr2);
            Object[] objArr3 = (Object[]) Array.newInstance(Class.forName((String) objArr2[0]), 2);
            int i40 = -TextUtils.getOffsetBefore("", 0);
            Object[] objArr4 = new Object[1];
            a(((i40 | 31) << 1) - (i40 ^ 31), new char[]{9485, 20760, 5560, 14151, 37350, 21586, 25322, 54386, 23175, 28470, 45436, 30588, 37172, 19638, 21647, 23366, 49063, 62489, 5560, 14151, 37350, 21586, 25322, 54386, 23175, 28470, 38571, 64285, 23891, 6460, 38355, 48356}, objArr4);
            try {
                Object[] objArr5 = {(String) objArr4[0]};
                Object[] objArr6 = new Object[1];
                a((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 38, new char[]{30537, 63068, 34439, 25753, 61988, 19402, 48877, 11963, 47567, 23988, 43232, 36637, 26575, 25512, 20027, 4519, 9317, 64457, 13073, 45728, 28205, 63802, 56576, 40445, 47422, 12820, 22448, 46365, 20139, 41736, 43232, 36637, 5619, 55856, 55287, 61445, 41091, 55299}, objArr6);
                String str = (String) objArr6[0];
                int i41 = artificialFrame + 69;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i41 % 128;
                int i42 = i41 % 2;
                objArr3[0] = Class.forName(str).getDeclaredConstructor(String.class).newInstance(objArr5);
                int i43 = -KeyEvent.getDeadChar(0, 0);
                int i44 = artificialFrame;
                int i45 = i44 + 79;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i45 % 128;
                if (i45 % 2 != 0) {
                    i3 = (-183) >>> i43;
                    i4 = 30;
                } else {
                    i3 = i43 * (-183);
                    i4 = 5735;
                }
                int i46 = -(-i4);
                int i47 = (i3 & i46) + (i3 | i46);
                int i48 = ~i43;
                int i49 = (i47 - (~(-(-(((i48 ^ 31) | (i48 & 31)) * (-368)))))) - 1;
                int i50 = (i44 & 101) + (i44 | 101);
                getARTIFICIAL_FRAME_PACKAGE_NAME = i50 % 128;
                int i51 = i50 % 2;
                int i52 = (i43 ^ (-32)) | (i43 & (-32));
                int i53 = -(-(SyslogConstants.LOG_LOCAL7 * ((i52 & i34) | (i52 ^ i34))));
                int i54 = ((i49 | i53) << 1) - (i53 ^ i49);
                int i55 = ~((i48 ^ (-32)) | (i48 & (-32)));
                int i56 = ~i;
                int i57 = ~(i56 | i43);
                int i58 = (i55 & i57) | (i55 ^ i57);
                int i59 = ~(i43 | 31);
                int i60 = -(-(((i59 & i58) | (i58 ^ i59)) * SyslogConstants.LOG_LOCAL7));
                Object[] objArr7 = new Object[1];
                b(((i54 | i60) << 1) - (i60 ^ i54), new int[]{-1788552038, 546152230, 1085637355, -930520472, -1961008651, -652014915, -289671467, 1025735429, -158686655, 1252227408, -912814006, -1284309933, 185411119, 1058940695, 1095117178, 463535656}, objArr7);
                try {
                    Object[] objArr8 = {(String) objArr7[0]};
                    int i61 = -(ViewConfiguration.getScrollBarFadeDuration() >> 16);
                    Object[] objArr9 = new Object[1];
                    a((i61 & 38) + (i61 | 38), new char[]{30537, 63068, 34439, 25753, 61988, 19402, 48877, 11963, 47567, 23988, 43232, 36637, 26575, 25512, 20027, 4519, 9317, 64457, 13073, 45728, 28205, 63802, 56576, 40445, 47422, 12820, 22448, 46365, 20139, 41736, 43232, 36637, 5619, 55856, 55287, 61445, 41091, 55299}, objArr9);
                    objArr3[1] = Class.forName((String) objArr9[0]).getDeclaredConstructor(String.class).newInstance(objArr8);
                    try {
                        Object[] objArr10 = new Object[1];
                        b((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 22, new int[]{1500050484, 2130926284, 1408738461, -1414629063, -808211555, -1108890614, 694586134, -570322936, -1535692153, -828851785, -1741848822, -1944582317}, objArr10);
                        String str2 = (String) objArr10[0];
                        int i62 = artificialFrame + 69;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i62 % 128;
                        if (i62 % 2 != 0) {
                            cls = Class.forName(str2);
                            i5 = (ViewConfiguration.getScrollFriction() > 2.0f ? 1 : (ViewConfiguration.getScrollFriction() == 2.0f ? 0 : -1)) * 8;
                            iArr = new int[10];
                        } else {
                            cls = Class.forName(str2);
                            int i63 = -(ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1));
                            i5 = ((i63 & 18) << 1) + (i63 ^ 18);
                            iArr = new int[10];
                        }
                        // fill-array-data instruction
                        iArr[0] = 1361072318;
                        iArr[1] = 1470184980;
                        iArr[2] = -293191604;
                        iArr[3] = -2037000151;
                        iArr[4] = -1654146417;
                        iArr[5] = 683045002;
                        iArr[6] = -603855954;
                        iArr[7] = -1787376801;
                        iArr[8] = 770422308;
                        iArr[9] = 1169568286;
                        Object[] objArr11 = new Object[1];
                        b(i5, iArr, objArr11);
                        Object objInvoke2 = cls.getMethod((String) objArr11[0], null).invoke(context, null);
                        try {
                            int iBlue = Color.blue(0);
                            int i64 = iBlue * (-494);
                            int i65 = (((i64 | (-11362)) << 1) - (i64 ^ (-11362))) + ((~((iBlue ^ 23) | (iBlue & 23))) * (-495)) + (((iBlue ^ i56) | (iBlue & i56)) * 495);
                            int i66 = ~((~iBlue) | (-24));
                            int i67 = iBlue | i34;
                            int i68 = getARTIFICIAL_FRAME_PACKAGE_NAME + AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
                            artificialFrame = i68 % 128;
                            if (i68 % 2 == 0) {
                                int i69 = ~i67;
                                Object[] objArr12 = new Object[1];
                                b(i65 * (495 >> ((i69 & i66) | (i66 ^ i69))), new int[]{1500050484, 2130926284, 1408738461, -1414629063, -808211555, -1108890614, 694586134, -570322936, -1535692153, -828851785, -1741848822, -1944582317}, objArr12);
                                cls2 = Class.forName((String) objArr12[0]);
                                threadPriority = Process.getThreadPriority(1);
                                i6 = 76;
                                i7 = b.i;
                            } else {
                                int i70 = ~i67;
                                int i71 = ((i70 & i66) | (i66 ^ i70)) * 495;
                                Object[] objArr13 = new Object[1];
                                b((i65 ^ i71) + ((i71 & i65) << 1), new int[]{1500050484, 2130926284, 1408738461, -1414629063, -808211555, -1108890614, 694586134, -570322936, -1535692153, -828851785, -1741848822, -1944582317}, objArr13);
                                cls2 = Class.forName((String) objArr13[0]);
                                threadPriority = Process.getThreadPriority(0);
                                i6 = 14;
                                i7 = 20;
                            }
                            int i72 = getARTIFICIAL_FRAME_PACKAGE_NAME + 25;
                            int i73 = i72 % 128;
                            artificialFrame = i73;
                            int i74 = i72 % 2;
                            int i75 = ((((i7 * (-494)) + (threadPriority * (-494))) - (~(-(-((~((i7 ^ threadPriority) | (i7 & threadPriority))) * (-495)))))) - 1) + ((i7 | i34) * 495);
                            int i76 = ~i7;
                            int i77 = ~threadPriority;
                            int i78 = ~((i76 ^ i77) | (i76 & i77));
                            int i79 = ~((i34 ^ i7) | (i7 & i34));
                            int i80 = -(-((i75 + (((i78 & i79) | (i78 ^ i79)) * 495)) >> 6));
                            int i81 = (i6 & i80) + (i80 | i6);
                            char[] cArr = {49303, 43240, 38282, 49634, 27375, 27756, 18400, 47318, 49303, 43240, 49688, 2363, 17426, 23074};
                            int i82 = i73 + 101;
                            getARTIFICIAL_FRAME_PACKAGE_NAME = i82 % 128;
                            if (i82 % 2 != 0) {
                                Object[] objArr14 = new Object[1];
                                a(i81, cArr, objArr14);
                                objInvoke = cls2.getMethod((String) objArr14[0], null).invoke(context, null);
                                i8 = 91;
                            } else {
                                Object[] objArr15 = new Object[1];
                                a(i81, cArr, objArr15);
                                objInvoke = cls2.getMethod((String) objArr15[0], null).invoke(context, null);
                                i8 = 64;
                            }
                            int i83 = artificialFrame;
                            int i84 = (i83 ^ 11) + ((i83 & 11) << 1);
                            getARTIFICIAL_FRAME_PACKAGE_NAME = i84 % 128;
                            int i85 = i84 % 2;
                            try {
                                Object[] objArr16 = {objInvoke, Integer.valueOf(i8)};
                                int i86 = -View.MeasureSpec.getSize(0);
                                int iExtraCallbackWithResult = UnicodeExtensionKeys.AnonymousClass2.extraCallbackWithResult();
                                int i87 = i86 * 69;
                                int i88 = (i87 ^ (-2211)) + ((i87 & (-2211)) << 1);
                                int i89 = ~i86;
                                int i90 = i89 | (-34);
                                int i91 = ~iExtraCallbackWithResult;
                                int i92 = ~((i90 & i91) | (i90 ^ i91));
                                int i93 = ~((i86 & 33) | (i86 ^ 33));
                                int i94 = (i93 & i92) | (i92 ^ i93);
                                int i95 = ~(iExtraCallbackWithResult | 33);
                                int i96 = -(-(((i94 & i95) | (i94 ^ i95)) * (-68)));
                                int i97 = (i88 & i96) + (i96 | i88);
                                int i98 = (i89 ^ i91) | (i89 & i91);
                                int i99 = -(-((~((i98 & 33) | (i98 ^ 33))) * (-68)));
                                int i100 = ((i97 | i99) << 1) - (i99 ^ i97);
                                int i101 = ~(((-34) & i91) | ((-34) ^ i91));
                                Object[] objArr17 = new Object[1];
                                b(i100 + (((i101 & i89) | (i89 ^ i101)) * 68), new int[]{1500050484, 2130926284, 1408738461, -1414629063, -808211555, -1108890614, 694586134, -570322936, -1249245126, 95512221, -293191604, -2037000151, -1654146417, 683045002, -603855954, -1787376801, 770422308, 1169568286}, objArr17);
                                Class<?> cls3 = Class.forName((String) objArr17[0]);
                                int i102 = -(ViewConfiguration.getScrollDefaultDelay() >> 16);
                                int iExtraCallbackWithResult2 = UnicodeExtensionKeys.AnonymousClass2.extraCallbackWithResult();
                                int i103 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                int i104 = (i103 & 11) + (i103 | 11);
                                artificialFrame = i104 % 128;
                                int i105 = i104 % 2;
                                int i106 = ~i102;
                                int i107 = ~iExtraCallbackWithResult2;
                                int i108 = ~((i106 & i107) | (i106 ^ i107));
                                int i109 = ((i102 * 934) - 13048) + (((i108 & (-15)) | ((-15) ^ i108)) * (-933));
                                int i110 = ~((~iExtraCallbackWithResult2) | (-15));
                                int i111 = ~(((-15) & i102) | ((-15) ^ i102));
                                int i112 = ((i110 & i111) | (i110 ^ i111)) * 933;
                                int i113 = (i109 ^ i112) + ((i112 & i109) << 1) + ((~((i102 & 14) | (i102 ^ 14))) * 933);
                                Object[] objArr18 = new Object[1];
                                b(i113, new int[]{1361072318, 1470184980, -293191604, -2037000151, 284756968, 1922074486, -1041310310, 1132478295}, objArr18);
                                Object objInvoke3 = cls3.getMethod((String) objArr18[0], String.class, Integer.TYPE).invoke(objInvoke2, objArr16);
                                int i114 = -(ViewConfiguration.getScrollBarFadeDuration() >> 16);
                                int i115 = artificialFrame;
                                int i116 = (i115 & 25) + (i115 | 25);
                                int i117 = i116 % 128;
                                getARTIFICIAL_FRAME_PACKAGE_NAME = i117;
                                int i118 = i116 % 2;
                                int i119 = (i114 * 51) - 1470;
                                int i120 = -(-((i114 | i) * (-50)));
                                int i121 = (i119 & i120) + (i119 | i120);
                                int i122 = ~i114;
                                int i123 = (i122 & (-31)) | (i122 ^ (-31));
                                int i124 = ~((i123 & i) | (i123 ^ i));
                                int i125 = i117 + 125;
                                artificialFrame = i125 % 128;
                                int i126 = i125 % 2;
                                int i127 = ((-31) ^ i34) | ((-31) & i34);
                                int i128 = i121 + (50 * (i124 | (~((i127 & i114) | (i127 ^ i114)))));
                                int i129 = ~((-31) | i56);
                                int i130 = ~(((-31) & i114) | ((-31) ^ i114));
                                int i131 = -(-(((~(i114 | i34)) | (i130 & i129) | (i129 ^ i130)) * 50));
                                int i132 = ((i128 | i131) << 1) - (i131 ^ i128);
                                Object[] objArr19 = new Object[1];
                                b(i132, new int[]{1500050484, 2130926284, 1408738461, -1414629063, -808211555, -1108890614, 694586134, -570322936, -1249245126, 95512221, -293191604, -2037000151, 284756968, 1922074486, -1041310310, 1132478295}, objArr19);
                                String str3 = (String) objArr19[0];
                                int i133 = artificialFrame;
                                int i134 = ((i133 | 11) << 1) - (i133 ^ 11);
                                getARTIFICIAL_FRAME_PACKAGE_NAME = i134 % 128;
                                int i135 = i134 % 2;
                                Class<?> cls4 = Class.forName(str3);
                                int i136 = -(-(Process.myPid() >> 22));
                                Object[] objArr20 = new Object[1];
                                b(((i136 | 10) << 1) - (i136 ^ 10), new int[]{1925867073, 1472219311, -1556188308, 861911375, -1885261904, 228833240}, objArr20);
                                Object[] objArr21 = (Object[]) cls4.getField((String) objArr20[0]).get(objInvoke3);
                                int length = objArr21.length;
                                int i137 = 0;
                                while (i137 < length) {
                                    Object obj = objArr21[i137];
                                    int i138 = (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1));
                                    int i139 = artificialFrame;
                                    int i140 = ((i139 | 31) << i17) - (i139 ^ 31);
                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i140 % 128;
                                    if (i140 % i15 != 0) {
                                        Object obj2 = null;
                                        obj2.hashCode();
                                        throw null;
                                    }
                                    int i141 = 960 * i138;
                                    int i142 = (i141 ^ (-7668)) + ((i141 & (-7668)) << i17);
                                    int i143 = i139 + 97;
                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i143 % 128;
                                    if (i143 % i15 != 0) {
                                        Object obj3 = null;
                                        obj3.hashCode();
                                        throw null;
                                    }
                                    int i144 = ~(((-5) & i56) | ((-5) ^ i56));
                                    int i145 = ((i138 ^ i) | (i138 & i)) ^ (-1);
                                    int i146 = (i142 - (~(959 * ((i144 ^ i145) | (i144 & i145))))) - i17;
                                    int i147 = (i146 & 4795) + (i146 | 4795);
                                    int i148 = ~(((-5) & i) | ((-5) ^ i));
                                    int i149 = ((i139 | 61) << i17) - (i139 ^ 61);
                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i149 % 128;
                                    int i150 = i149 % i15;
                                    int i151 = ~((i138 & i34) | (i34 ^ i138));
                                    int i152 = 959 * ((i151 & i148) | (i148 ^ i151));
                                    int i153 = (i147 ^ i152) + ((i152 & i147) << i17);
                                    Object[] objArr22 = new Object[i17];
                                    b(i153, new int[]{1423179755, -1295780395, -1116481274, -1915067667}, objArr22);
                                    try {
                                        Object[] objArr23 = {(String) objArr22[0]};
                                        int packedPositionType = ExpandableListView.getPackedPositionType(0L);
                                        int i154 = (((packedPositionType * (-1975)) + 36593) - (~(((~((~packedPositionType) | 37)) | i) * 988))) - i17;
                                        int i155 = ((~((i56 ^ packedPositionType) | (i56 & packedPositionType))) | (~(((-38) ^ packedPositionType) | ((-38) & packedPositionType)))) * (-1976);
                                        int i156 = (i154 & i155) + (i155 | i154);
                                        int i157 = ~packedPositionType;
                                        int i158 = ~((i157 & 37) | (i157 ^ 37));
                                        int i159 = ((-38) ^ i) | ((-38) & i);
                                        int i160 = ~i159;
                                        int i161 = (i158 & i160) | (i158 ^ i160);
                                        int i162 = ~((i56 ^ 37) | (i56 & 37));
                                        int i163 = ((i161 & i162) | (i161 ^ i162)) * 988;
                                        Object[] objArr24 = new Object[i17];
                                        a(((i156 | i163) << i17) - (i163 ^ i156), new char[]{30537, 63068, 34439, 25753, 60088, 57629, 57307, 28103, 3701, 24809, 59921, 21035, 10731, 52395, 21134, 10742, 15334, 13358, 2709, 44169, 2173, 39099, 52358, 57491, 28549, 58432, 40969, 29739, 57093, 65091, 52390, 59069, 52325, 36757, 7171, 64214, 5678, 37862}, objArr24);
                                        Class<?> cls5 = Class.forName((String) objArr24[0]);
                                        int i164 = -Gravity.getAbsoluteGravity(0, 0);
                                        Object[] objArr25 = new Object[i17];
                                        b((i164 ^ 11) + ((i164 & 11) << i17), new int[]{32826790, -199570860, -980188970, 1012341770, 1118686024, -1425949099}, objArr25);
                                        String str4 = (String) objArr25[0];
                                        Class<?>[] clsArr = new Class[i17];
                                        clsArr[0] = String.class;
                                        Object objInvoke4 = cls5.getMethod(str4, clsArr).invoke(null, objArr23);
                                        UnicodeExtensionKeys.AnonymousClass2.extraCallbackWithResult();
                                        UnicodeExtensionKeys.AnonymousClass2.extraCallbackWithResult();
                                        try {
                                            Object[] objArr26 = new Object[i17];
                                            a((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 27, new char[]{37893, 37733, 41521, 38462, 10980, 8929, 48594, 63552, 53446, 2273, 31367, 55214, 55198, 4490, 59323, 11044, 18021, 47147, 2731, 3607, 61425, 25802, 22680, 40338, 17922, 42626, 45825, 12791}, objArr26);
                                            Class<?> cls6 = Class.forName((String) objArr26[0]);
                                            int i165 = -Color.rgb(0, 0, 0);
                                            Object[] objArr27 = objArr21;
                                            Object[] objArr28 = new Object[i17];
                                            a(((i165 | (-16777205)) << 1) - (i165 ^ (-16777205)), new char[]{7643, 2030, 21005, 6922, 57093, 65091, 41705, 15903, 9026, 24669, 5678, 37862}, objArr28);
                                            try {
                                                Object[] objArr29 = {new ByteArrayInputStream((byte[]) cls6.getMethod((String) objArr28[0], null).invoke(obj, null))};
                                                int i166 = -View.resolveSizeAndState(0, 0, 0);
                                                int i167 = ((-38) ^ i56) | ((-38) & i56);
                                                int i168 = ~((i167 & i166) | (i167 ^ i166));
                                                int i169 = ~((i166 ^ 37) | (i166 & 37) | i);
                                                int i170 = (((i166 * 989) - 36519) - (~(((i168 ^ i169) | (i168 & i169)) * 988))) - i17;
                                                int i171 = ((i166 ^ (-38)) | (i166 & (-38))) * (-988);
                                                int i172 = ((i170 | i171) << i17) - (i170 ^ i171);
                                                int i173 = ~i166;
                                                int i174 = (~((i173 & (-38)) | (i173 ^ (-38)))) | (~i159);
                                                int i175 = i166 | i34;
                                                int i176 = ~((i175 & 37) | (i175 ^ 37));
                                                int i177 = ((i176 & i174) | (i174 ^ i176)) * 988;
                                                Object[] objArr30 = new Object[i17];
                                                a(((i172 | i177) << i17) - (i177 ^ i172), new char[]{30537, 63068, 34439, 25753, 60088, 57629, 57307, 28103, 3701, 24809, 59921, 21035, 10731, 52395, 21134, 10742, 15334, 13358, 2709, 44169, 2173, 39099, 52358, 57491, 28549, 58432, 40969, 29739, 57093, 65091, 52390, 59069, 52325, 36757, 7171, 64214, 5678, 37862}, objArr30);
                                                Class<?> cls7 = Class.forName((String) objArr30[0]);
                                                int i178 = (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                                                int iExtraCallbackWithResult3 = UnicodeExtensionKeys.AnonymousClass2.extraCallbackWithResult();
                                                int i179 = ~i178;
                                                int i180 = (((i178 * (-167)) - 3173) - (~(-(-(((~(((-20) ^ iExtraCallbackWithResult3) | ((-20) & iExtraCallbackWithResult3))) | (~((i179 ^ (-20)) | (i179 & (-20))))) * 336))))) - i17;
                                                int i181 = ((~(i178 | 19)) | (~((i178 ^ iExtraCallbackWithResult3) | (i178 & iExtraCallbackWithResult3)))) * (-168);
                                                int i182 = (i180 & i181) + (i181 | i180);
                                                int i183 = ~iExtraCallbackWithResult3;
                                                int i184 = ~((i183 & i178) | (i183 ^ i178));
                                                Object[] objArr31 = new Object[i17];
                                                a(i182 + ((((-20) & i184) | ((-20) ^ i184)) * 168), new char[]{49303, 43240, 568, 36929, 9026, 24669, 57093, 65091, 7349, 20831, 15334, 13358, 22278, 54585, 32615, 17816, 32918, 57136, 6436, 63800}, objArr31);
                                                String str5 = (String) objArr31[0];
                                                Class<?>[] clsArr2 = new Class[i17];
                                                clsArr2[0] = InputStream.class;
                                                Object objInvoke5 = cls7.getMethod(str5, clsArr2).invoke(objInvoke4, objArr29);
                                                int length2 = objArr3.length;
                                                int i185 = 0;
                                                while (i185 < 2) {
                                                    Object obj4 = objArr3[i185];
                                                    int i186 = artificialFrame + 89;
                                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i186 % 128;
                                                    int i187 = i186 % 2;
                                                    try {
                                                        int i188 = -View.MeasureSpec.makeMeasureSpec(0, 0);
                                                        int i189 = i188 * (-919);
                                                        int i190 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                                        int i191 = i190 + 61;
                                                        artificialFrame = i191 % 128;
                                                        if (i191 % 2 == 0) {
                                                            i9 = i189 + 31246;
                                                            int i192 = (~i188) | (-35);
                                                            i10 = ~((i192 ^ i) | (i192 & i));
                                                            int i193 = ((-35) ^ i56) | ((-35) & i56);
                                                            i11 = (i193 ^ i188) | (i193 & i188);
                                                        } else {
                                                            i9 = ((i189 | (-31246)) << i17) - (i189 ^ (-31246));
                                                            int i194 = ~i188;
                                                            i10 = ~((i194 & (-35)) | (i194 ^ (-35)) | i);
                                                            int i195 = ((-35) ^ i34) | ((-35) & i34);
                                                            i11 = (i195 ^ i188) | (i195 & i188);
                                                        }
                                                        int i196 = ~i11;
                                                        int i197 = i190 + AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
                                                        artificialFrame = i197 % 128;
                                                        if (i197 % 2 == 0) {
                                                            int i198 = i9 << (920 / ((i10 ^ i196) | (i10 & i196)));
                                                            int i199 = ~i188;
                                                            i12 = i198 % (((~((i199 & i34) | (i199 ^ i34))) | (~((i199 ^ (-35)) | (i199 & (-35))))) * 920);
                                                        } else {
                                                            int i200 = (i9 - (~(920 * (i10 | i196)))) - 1;
                                                            int i201 = ~i188;
                                                            int i202 = ~((i201 & (-35)) | (i201 ^ (-35)));
                                                            int i203 = ~i188;
                                                            int i204 = ~((i203 & i34) | (i203 ^ i34));
                                                            int i205 = ((i202 & i204) | (i202 ^ i204)) * 920;
                                                            i12 = ((i200 | i205) << 1) - (i205 ^ i200);
                                                        }
                                                        int i206 = ~i188;
                                                        int i207 = (i206 ^ (-35)) | (i206 & (-35));
                                                        int i208 = ~((i207 & i56) | (i207 ^ i56));
                                                        int i209 = (i206 & 34) | (i206 ^ 34);
                                                        int i210 = ~((i209 & i) | (i209 ^ i));
                                                        int i211 = (i210 & i208) | (i208 ^ i210);
                                                        int i212 = i188 | (-35);
                                                        int i213 = ~((i212 & i) | (i212 ^ i));
                                                        int i214 = -(-(920 * ((i213 & i211) | (i211 ^ i213))));
                                                        Object[] objArr32 = new Object[1];
                                                        a((i12 ^ i214) + ((i12 & i214) << 1), new char[]{30537, 63068, 34439, 25753, 60088, 57629, 57307, 28103, 3701, 24809, 59921, 21035, 10731, 52395, 21134, 10742, 15334, 13358, 47422, 12820, 22448, 46365, 19083, 43352, 2173, 39099, 52358, 57491, 28549, 58432, 40969, 29739, 57093, 65091}, objArr32);
                                                        Class<?> cls8 = Class.forName((String) objArr32[0]);
                                                        int threadPriority2 = Process.getThreadPriority(0);
                                                        int iExtraCallbackWithResult4 = UnicodeExtensionKeys.AnonymousClass2.extraCallbackWithResult();
                                                        int i215 = -(-(threadPriority2 * (-978)));
                                                        int i216 = ((19600 | i215) << 1) - (i215 ^ 19600);
                                                        int i217 = ~threadPriority2;
                                                        int i218 = ~iExtraCallbackWithResult4;
                                                        int i219 = ~((i217 ^ i218) | (i217 & i218));
                                                        int i220 = getARTIFICIAL_FRAME_PACKAGE_NAME + b.i;
                                                        int i221 = length;
                                                        artificialFrame = i220 % 128;
                                                        int i222 = i220 % 2;
                                                        int i223 = (i216 - (~(979 * i219))) - 1;
                                                        int i224 = -(-(((20 ^ iExtraCallbackWithResult4) | (20 & iExtraCallbackWithResult4)) * (-979)));
                                                        int i225 = ~threadPriority2;
                                                        int i226 = ~((i225 & iExtraCallbackWithResult4) | (i225 ^ iExtraCallbackWithResult4));
                                                        int i227 = ~iExtraCallbackWithResult4;
                                                        int i228 = ~((i227 & 20) | (i227 ^ 20));
                                                        int i229 = -((((((i223 | i224) << 1) - (i223 ^ i224)) - (~(-(-(((i226 & i228) | (i226 ^ i228)) * 979))))) - 1) >> 6);
                                                        Object[] objArr33 = new Object[1];
                                                        a((i229 & 23) + (i229 | 23), new char[]{49303, 43240, 4965, 20184, 7503, 8970, 30822, 7038, 52325, 36757, 16072, 65475, 56576, 40445, 4137, 31904, 31964, 2229, 18723, 7671, 14852, 44451, 15565, 45007}, objArr33);
                                                        if (obj4.equals(cls8.getMethod((String) objArr33[0], null).invoke(objInvoke5, null))) {
                                                            int i230 = (~(i & 1)) & (i | 1);
                                                            Object[] objArr34 = new Object[4];
                                                            int i231 = artificialFrame + 31;
                                                            int i232 = i231 % 128;
                                                            getARTIFICIAL_FRAME_PACKAGE_NAME = i232;
                                                            if (i231 % 2 != 0) {
                                                                objArr34[0] = new int[1];
                                                                objArr34[0] = new int[0];
                                                                objArr34[4] = new int[0];
                                                                i13 = 1;
                                                                c = 0;
                                                            } else {
                                                                i13 = 1;
                                                                c = 0;
                                                                objArr34[0] = new int[1];
                                                                objArr34[1] = new int[1];
                                                                objArr34[2] = new int[1];
                                                            }
                                                            ((int[]) objArr34[c])[c] = i;
                                                            ((int[]) objArr34[i13])[c] = i230;
                                                            objArr34[3] = null;
                                                            int i233 = ((i232 | 55) << i13) - (i232 ^ 55);
                                                            artificialFrame = i233 % 128;
                                                            if (i233 % 2 == 0) {
                                                                i14 = i2 / (((((-1102353370) + (((~(508750742 | i34)) | 469873032) * (-328))) + ((i | 469873032) * 164)) + ((((~((-508750743) | i)) | 469803392) | (~(508820382 | i34))) * 164)) * 16);
                                                            } else {
                                                                int i234 = 202212253 + (((~((-76873768) | i34)) | (~((-287343761) | i)) | (~((-537532481) | i))) * 765) + (((~((-364217528) | i34)) | 76873767) * 1530) + (((~((-364217528) | i)) | (~((-537532481) | i34))) * 765);
                                                                i14 = (i2 - (~(-(-((i234 ^ 16) + ((i234 & 16) << 1)))))) - 1;
                                                            }
                                                            int i235 = i14 << 13;
                                                            int i236 = ((~i14) & i235) | ((~i235) & i14);
                                                            int i237 = i236 >>> 17;
                                                            int i238 = (i236 | i237) & (~(i236 & i237));
                                                            int i239 = i238 << 5;
                                                            ((int[]) objArr34[2])[0] = ((~i238) & i239) | ((~i239) & i238);
                                                            return objArr34;
                                                        }
                                                        i185++;
                                                        length = i221;
                                                        i17 = 1;
                                                    } catch (Throwable th) {
                                                        Throwable cause = th.getCause();
                                                        if (cause != null) {
                                                            throw cause;
                                                        }
                                                        throw th;
                                                    }
                                                }
                                                i137 = (i137 ^ 1) + ((i137 & 1) << 1);
                                                objArr21 = objArr27;
                                                length = length;
                                                i15 = 2;
                                                i17 = 1;
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
        Object[] objArr35 = {new int[]{i}, new int[]{i}, new int[1], null};
        int iMyTid = Process.myTid();
        int i240 = (-872584314) + ((~((~iMyTid) | 905678845)) * (-116)) + ((609815989 | iMyTid) * 116) + (((~(iMyTid | (-368807786))) | 72944929) * 116);
        int iExtraCallbackWithResult5 = UnicodeExtensionKeys.AnonymousClass2.extraCallbackWithResult();
        int i241 = i240 * (-1187);
        int i242 = ~(((-1) ^ i240) | i240);
        int i243 = ~iExtraCallbackWithResult5;
        int i244 = ~((i243 & i240) | (i243 ^ i240));
        int i245 = -(-(((i242 & i244) | (i242 ^ i244)) * (-1188)));
        int i246 = ((i241 | i245) << 1) - (i241 ^ i245);
        int i247 = ~(((-1) ^ i240) | i240);
        int i248 = ~i240;
        int i249 = i247 | (~(i248 | iExtraCallbackWithResult5));
        int i250 = ~iExtraCallbackWithResult5;
        int i251 = (i249 | (~i250)) * 594;
        int i252 = (i246 ^ i251) + ((i251 & i246) << 1);
        int i253 = ~((i248 ^ i250) | (i248 & i250));
        int i254 = ~i248;
        int i255 = (i253 & i254) | (i253 ^ i254);
        int i256 = ~i250;
        int i257 = -(-(((i256 & i255) | (i255 ^ i256)) * 594));
        int i258 = (i252 ^ i257) + ((i257 & i252) << 1);
        int i259 = ((i258 * (-375)) - (~(-(-(i2 * (-375)))))) - 1;
        int i260 = ~i258;
        int i261 = ~i2;
        int i262 = ~((i260 & i261) | (i260 ^ i261));
        int i263 = (i262 & i) | (i ^ i262);
        int i264 = ~((i258 ^ i2) | (i258 & i2));
        int i265 = (i259 - (~(((i263 & i264) | (i263 ^ i264)) * 376))) - 1;
        int i266 = ~i;
        int i267 = ~((i266 & i258) | (i266 ^ i258));
        int i268 = ~i258;
        int i269 = ~((i & i268) | (i268 ^ i));
        int i270 = ((i265 + (((i267 & i264) | (i267 ^ i264)) * (-376))) - (~(-(-(((i269 & i2) | (i2 ^ i269)) * 376))))) - 1;
        int i271 = i270 << 13;
        int i272 = (i271 & (~i270)) | ((~i271) & i270);
        int i273 = i272 >>> 17;
        int i274 = ((~i272) & i273) | ((~i273) & i272);
        int i275 = i274 << 5;
        ((int[]) objArr35[2])[0] = (i274 | i275) & (~(i274 & i275));
        return objArr35;
    }
}
