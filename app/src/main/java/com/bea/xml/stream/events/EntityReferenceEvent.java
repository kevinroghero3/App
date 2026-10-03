package com.bea.xml.stream.events;

import android.graphics.Color;
import android.telephony.cdma.CdmaCellLocation;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.salesforce.marketingcloud.analytics.stats.b;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Method;
import javax.xml.stream.events.EntityDeclaration;
import javax.xml.stream.events.EntityReference;
import kotlin.io.encoding.Base64;
import o.ArtificialStackFrames;
import o.ICustomTabsCallback;
import o.artificialFrame;
import okio.Utf8;

/* JADX INFO: loaded from: classes4.dex */
public class EntityReferenceEvent extends BaseEvent implements EntityReference {
    private static short[] ICustomTabsService;
    private EntityDeclaration ed;
    private String name;
    private String replacementText;
    private static final byte[] $$c = {Ascii.DC4, 17, 111, Ascii.ESC};
    private static final int $$d = 177;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$a = {4, Ascii.VT, 101, -73, -12, -6, Ascii.ESC, -22, -26, 4, -12, 0, -8, -2, -8};
    private static final int $$b = 43;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static int onTransact = -1671845500;
    private static int mayLaunchUrl = -81862515;
    private static int getInterfaceDescriptor = -971363414;
    private static byte[] ICustomTabsCallbackStubProxy = {-122, -21, Ascii.EM, -26, Ascii.ETB, -43, Base64.padSymbol, Ascii.US, Ascii.EM, -59, -8, 89, -32, Ascii.GS, -90, 43, Ascii.CR, -13, 17, 112, 116, -121, 107, 126, 115, -101, -98, 110, -106, 76, -73, 121, 119, 112, -40, 104, 102, -102, -112, 127, -109, -97, 40, -96, -122, 120, -102, -114, 54, -63, 57, -39, 53, 49, 17, -31, 59, -54, 117, -73, 70, -73, -121, -55, 37, 46, -47, 33, -45, -58, -51, Ascii.SUB, -37, 45, 39, -97, Ascii.NAK, 51, -51, 47, -118, -57, 59, 42, -33, 48, -63, -108, 51, 56, -48, 44, -64, 60, -62, 53, -63, 34, -36, -36, 47, -60, -45, -55, 51, -38, 6, 51, 56, 48, -120, 120, -56, -58, 58, 48, -33, 51, Utf8.REPLACEMENT_BYTE, -120, 0, 38, -40, 58, -118, -11, -9, -15, Ascii.CAN, Ascii.CR, 1, 119, -66, -122, 112, 125, -116, 80, -85, -124, 102, -117, -113, 118, -120, -128, 119, 120, 87, -70, 122, -117, 116, -78, SignedBytes.MAX_POWER_OF_TWO, -68, 109, -113, 90, -92, 80, -87, 80, -116, 116, -86, 91, -122, -59, 39, -54, -50, 55, -55, -63, 54, 57, Ascii.SYN, -22, -59, 39, -37, 57, -61, Base64.padSymbol, -54, -103, 126, 123, -123, 123, -124, 124, -115, 127, 121, 120, 120, 123, -123, 123, -126, 126, -123, 123, -128, 112, -125, 125, -123, -122, Ascii.SUB, -24, Ascii.ETB, -26, 36, -54, -26, -20, 32, 3, -88, 17, -20, 87, -38, -4, 2, -32, 117, Utf8.REPLACEMENT_BYTE, -33, -53, -125, -103, -97, 67, 126, -89, -103, 109, -107, 94, -83, -117, 117, -105, -119, 97, 111, 98, 102, -107, 107, -102, -102, 53, -38, 56, -49, 54, -27, -36, 115, -49, -64, 56, -49, 54, -59, -4, 3, 50, 51, 52, -57, Utf8.REPLACEMENT_BYTE, -60, -112, 96, -109, 107, -98, 96, 121, -123, -109, 107, -101, 101, 111, 124, 79, -84, -112, 47, -41, 107, 100, -100, 107, -110, 97, 88, -89, -106, -105, -112, 99, -101, 96, -125, 44, -35, 0, -63, -37, 35, -45, 45, 39, 52, -7, 42, -37, -109, -23, Ascii.CAN, -59, 4, Ascii.RS, -26, Ascii.SYN, -24, -30, -15, -62, 33, Ascii.GS, -94, 90, -26, -23, 17, -26, Ascii.US, -20, -43, 42, Ascii.ESC, Ascii.SUB, Ascii.GS, -18, Ascii.SYN, -19, -113, -31, Ascii.FS, Ascii.DC2, -18, -4, Ascii.FS, -24, 17, Ascii.EM, -98, Ascii.SUB, Ascii.NAK, -27, -27, 62, -60, -27, Ascii.GS, -11, Ascii.ESC, Ascii.NAK, 3, 4, -82, Ascii.RS, Ascii.DLE, -20, -26, 9, -27, -23, 94, -42, -16, Ascii.SO, -20, -99, -56, -58, 58, 40, -56, 60, -59, 45, Ascii.RS, -6, -58, 121, -127, Base64.padSymbol, 50, -54, Base64.padSymbol, -60, 55, Ascii.SO, -15, -64, -63, -58, 53, -51, 54, -117, Ascii.VT, 4, -12, -12, Ascii.SI, 117, 104, -106, -108};
    private static int[] ICustomTabsCallbackStub = {1805843757, -1229511886, 741392311, -1057246335, -936869333, -57784905, 716423465, 1035310119, 1824015281, 1951790417, 1148387942, -1718543858, -752853633, 994799941, 145773944, -664981017, -317675113, 499958803};

    /* JADX WARN: Code duplicated, block: B:10:0x0025  */
    /* JADX WARN: Code duplicated, block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x002b). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0025
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$e(byte r7, short r8, int r9) {
        /*
            int r7 = r7 * 4
            int r7 = r7 + 1
            byte[] r0 = com.bea.xml.stream.events.EntityReferenceEvent.$$c
            int r8 = r8 * 3
            int r8 = 3 - r8
            int r9 = 117 - r9
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L15
            r3 = r7
            r9 = r8
            r5 = r2
            goto L2b
        L15:
            r3 = r2
        L16:
            byte r4 = (byte) r9
            int r5 = r3 + 1
            r1[r3] = r4
            int r8 = r8 + 1
            if (r5 != r7) goto L25
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            return r7
        L25:
            r3 = r0[r8]
            r6 = r9
            r9 = r8
            r8 = r3
            r3 = r6
        L2b:
            int r8 = -r8
            int r8 = r8 + r3
            r3 = r5
            r6 = r9
            r9 = r8
            r8 = r6
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bea.xml.stream.events.EntityReferenceEvent.$$e(byte, short, int):java.lang.String");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0026  */
    /* JADX WARN: Code duplicated, block: B:8:0x001e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0026 -> B:11:0x0028). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0026
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void b(byte r6, int r7, short r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 * 3
            int r6 = r6 + 112
            int r8 = r8 * 5
            int r8 = r8 + 4
            int r7 = r7 * 8
            int r7 = 12 - r7
            byte[] r0 = com.bea.xml.stream.events.EntityReferenceEvent.$$a
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L16
            r3 = r8
            r5 = r2
            goto L28
        L16:
            r3 = r2
        L17:
            byte r4 = (byte) r6
            int r5 = r3 + 1
            r1[r3] = r4
            if (r5 != r8) goto L26
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L26:
            r3 = r0[r7]
        L28:
            int r3 = -r3
            int r6 = r6 + r3
            int r6 = r6 + (-7)
            int r7 = r7 + 1
            r3 = r5
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bea.xml.stream.events.EntityReferenceEvent.b(byte, int, short, java.lang.Object[]):void");
    }

    public String getBaseURI() {
        return null;
    }

    @Override // com.bea.xml.stream.events.BaseEvent, javax.xml.stream.Location
    public String getPublicId() {
        return null;
    }

    @Override // com.bea.xml.stream.events.BaseEvent, javax.xml.stream.Location
    public String getSystemId() {
        return null;
    }

    public EntityReferenceEvent() {
        init();
    }

    public EntityReferenceEvent(String str, EntityDeclaration entityDeclaration) {
        init();
        this.name = str;
        this.ed = entityDeclaration;
    }

    public String getReplacementText() {
        return this.ed.getReplacementText();
    }

    @Override // javax.xml.stream.events.EntityReference
    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setReplacementText(String str) {
        this.replacementText = str;
    }

    @Override // javax.xml.stream.events.EntityReference
    public EntityDeclaration getDeclaration() {
        return this.ed;
    }

    protected void init() {
        setEventType(9);
    }

    @Override // com.bea.xml.stream.events.BaseEvent
    protected void doWriteAsEncodedUnicode(Writer writer) throws IOException {
        writer.write(38);
        writer.write(getName());
        writer.write(59);
    }

    @Override // com.bea.xml.stream.events.BaseEvent
    public String toString() {
        String replacementText = getReplacementText();
        if (replacementText == null) {
            replacementText = "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("&");
        stringBuffer.append(getName());
        stringBuffer.append(":='");
        stringBuffer.append(replacementText);
        stringBuffer.append("'");
        return stringBuffer.toString();
    }

    private static void c(int i, int[] iArr, Object[] objArr) throws Throwable {
        int i2;
        int i3 = 2;
        int i4 = 2 % 2;
        artificialFrame artificialframe = new artificialFrame();
        char[] cArr = new char[4];
        char[] cArr2 = new char[iArr.length * 2];
        int[] iArr2 = ICustomTabsCallbackStub;
        int i5 = -1780896814;
        int i6 = 16;
        int i7 = 1;
        int i8 = 0;
        if (iArr2 != null) {
            int length = iArr2.length;
            int[] iArr3 = new int[length];
            int i9 = 0;
            while (i9 < length) {
                int i10 = $10 + 93;
                $11 = i10 % 128;
                if (i10 % i3 == 0) {
                    try {
                        Object[] objArr2 = {Integer.valueOf(iArr2[i9])};
                        Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(i5);
                        if (objAccessartificialFrame == null) {
                            byte b = (byte) 0;
                            byte b2 = b;
                            objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(11 - (ViewConfiguration.getKeyRepeatTimeout() >> i6), (char) Color.alpha(0), ExpandableListView.getPackedPositionGroup(0L) + 1562, 180153818, false, $$e(b, b2, (byte) (b2 | 8)), new Class[]{Integer.TYPE});
                        }
                        iArr3[i9] = ((Integer) ((Method) objAccessartificialFrame).invoke(null, objArr2)).intValue();
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause == null) {
                            throw th;
                        }
                        throw cause;
                    }
                } else {
                    Object[] objArr3 = {Integer.valueOf(iArr2[i9])};
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1780896814);
                    if (objAccessartificialFrame2 == null) {
                        byte b3 = (byte) 0;
                        byte b4 = b3;
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(11 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), (char) View.resolveSizeAndState(0, 0, 0), 1562 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), 180153818, false, $$e(b3, b4, (byte) (b4 | 8)), new Class[]{Integer.TYPE});
                    }
                    iArr3[i9] = ((Integer) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).intValue();
                }
                i9++;
                i3 = 2;
                i5 = -1780896814;
                i6 = 16;
            }
            int i11 = $11 + 23;
            $10 = i11 % 128;
            int i12 = i11 % 2;
            iArr2 = iArr3;
        }
        int length2 = iArr2.length;
        int[] iArr4 = new int[length2];
        int[] iArr5 = ICustomTabsCallbackStub;
        char c = '0';
        if (iArr5 != null) {
            int length3 = iArr5.length;
            int[] iArr6 = new int[length3];
            int i13 = 0;
            while (i13 < length3) {
                int i14 = $11 + 19;
                $10 = i14 % 128;
                if (i14 % 2 != 0) {
                    Object[] objArr4 = new Object[i7];
                    objArr4[i8] = Integer.valueOf(iArr5[i13]);
                    Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1780896814);
                    if (objAccessartificialFrame3 == null) {
                        byte b5 = (byte) i8;
                        byte b6 = b5;
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(View.combineMeasuredStates(i8, i8) + 11, (char) ('0' - AndroidCharacter.getMirror(c)), KeyEvent.keyCodeFromString("") + 1562, 180153818, false, $$e(b5, b6, (byte) (b6 | 8)), new Class[]{Integer.TYPE});
                    }
                    iArr6[i13] = ((Integer) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).intValue();
                    i13 = 0;
                } else {
                    length3 = length3;
                    Object[] objArr5 = {Integer.valueOf(iArr5[i13])};
                    Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-1780896814);
                    if (objAccessartificialFrame4 == null) {
                        byte b7 = (byte) 0;
                        byte b8 = b7;
                        objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(11 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), (char) (ViewConfiguration.getEdgeSlop() >> 16), 1561 - TextUtils.indexOf((CharSequence) "", '0', 0), 180153818, false, $$e(b7, b8, (byte) (b8 | 8)), new Class[]{Integer.TYPE});
                    }
                    iArr6[i13] = ((Integer) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).intValue();
                    i13++;
                }
                length3 = length3;
                c = '0';
                i7 = 1;
                i8 = 0;
            }
            i2 = i8;
            iArr5 = iArr6;
        } else {
            i2 = 0;
        }
        System.arraycopy(iArr5, i2, iArr4, i2, length2);
        artificialframe.e = i2;
        while (artificialframe.e < iArr.length) {
            cArr[i2] = (char) (iArr[artificialframe.e] >> 16);
            cArr[1] = (char) iArr[artificialframe.e];
            cArr[2] = (char) (iArr[artificialframe.e + 1] >> 16);
            cArr[3] = (char) iArr[artificialframe.e + 1];
            artificialframe.c = (cArr[0] << 16) + cArr[1];
            artificialframe.b = (cArr[2] << 16) + cArr[3];
            artificialFrame.coroutineBoundary(iArr4);
            int i15 = 0;
            for (int i16 = 16; i15 < i16; i16 = 16) {
                int i17 = $11 + 105;
                $10 = i17 % 128;
                int i18 = i17 % 2;
                artificialframe.c ^= iArr4[i15];
                Object[] objArr6 = {artificialframe, Integer.valueOf(artificialFrame.coroutineBoundary(artificialframe.c)), artificialframe, artificialframe};
                Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(-1540318455);
                if (objAccessartificialFrame5 == null) {
                    byte b9 = (byte) 0;
                    byte b10 = b9;
                    objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(26 - KeyEvent.keyCodeFromString(""), (char) Color.blue(0), 1040 - TextUtils.lastIndexOf("", '0'), 995482881, false, $$e(b9, b10, (byte) (b10 + 2)), new Class[]{Object.class, Integer.TYPE, Object.class, Object.class});
                }
                int iIntValue = ((Integer) ((Method) objAccessartificialFrame5).invoke(null, objArr6)).intValue();
                artificialframe.c = artificialframe.b;
                artificialframe.b = iIntValue;
                i15++;
            }
            int i19 = artificialframe.c;
            artificialframe.c = artificialframe.b;
            artificialframe.b = i19;
            artificialframe.b ^= iArr4[16];
            artificialframe.c ^= iArr4[17];
            int i20 = artificialframe.c;
            int i21 = artificialframe.b;
            cArr[0] = (char) (artificialframe.c >>> 16);
            cArr[1] = (char) artificialframe.c;
            cArr[2] = (char) (artificialframe.b >>> 16);
            cArr[3] = (char) artificialframe.b;
            artificialFrame.coroutineBoundary(iArr4);
            cArr2[artificialframe.e * 2] = cArr[0];
            cArr2[(artificialframe.e * 2) + 1] = cArr[1];
            cArr2[(artificialframe.e * 2) + 2] = cArr[2];
            cArr2[(artificialframe.e * 2) + 3] = cArr[3];
            Object[] objArr7 = {artificialframe, artificialframe};
            Object objAccessartificialFrame6 = ArtificialStackFrames.accessartificialFrame(1348396126);
            if (objAccessartificialFrame6 == null) {
                objAccessartificialFrame6 = ArtificialStackFrames.coroutineCreation(36 - TextUtils.lastIndexOf("", '0'), (char) (28010 - (ViewConfiguration.getKeyRepeatTimeout() >> 16)), (ViewConfiguration.getScrollBarSize() >> 8) + 306, -818175402, false, "q", new Class[]{Object.class, Object.class});
            }
            ((Method) objAccessartificialFrame6).invoke(null, objArr7);
            i2 = 0;
        }
        objArr[0] = new String(cArr2, 0, i);
    }

    private static void a(int i, byte b, int i2, short s, int i3, Object[] objArr) throws Throwable {
        boolean z;
        int i4 = 2;
        int i5 = 2 % 2;
        ICustomTabsCallback iCustomTabsCallback = new ICustomTabsCallback();
        StringBuilder sb = new StringBuilder();
        try {
            Object[] objArr2 = {Integer.valueOf(i2), Integer.valueOf(mayLaunchUrl)};
            Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1991297565);
            if (objAccessartificialFrame == null) {
                byte b2 = (byte) 0;
                byte b3 = b2;
                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getEdgeSlop() >> 16) + 40, (char) ((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 36241), View.resolveSizeAndState(0, 0, 0) + 2342, 371880939, false, $$e(b2, b3, (byte) (b3 + 5)), new Class[]{Integer.TYPE, Integer.TYPE});
            }
            int iIntValue = ((Integer) ((Method) objAccessartificialFrame).invoke(null, objArr2)).intValue();
            if (iIntValue == -1) {
                int i6 = $10 + 117;
                $11 = i6 % 128;
                int i7 = i6 % 2;
                z = true;
            } else {
                z = false;
            }
            if (z) {
                int i8 = $10 + 39;
                int i9 = i8 % 128;
                $11 = i9;
                int i10 = i8 % 2;
                byte[] bArr = ICustomTabsCallbackStubProxy;
                if (bArr != null) {
                    int i11 = i9 + 91;
                    $10 = i11 % 128;
                    int i12 = i11 % 2;
                    int length = bArr.length;
                    byte[] bArr2 = new byte[length];
                    int i13 = 0;
                    while (i13 < length) {
                        int i14 = $10 + 21;
                        $11 = i14 % 128;
                        int i15 = i14 % i4;
                        Object[] objArr3 = {Integer.valueOf(bArr[i13])};
                        Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1557994855);
                        if (objAccessartificialFrame2 == null) {
                            byte b4 = (byte) 0;
                            byte b5 = b4;
                            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 44, (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 1), 1215 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), 1011328145, false, $$e(b4, b5, b5), new Class[]{Integer.TYPE});
                        }
                        bArr2[i13] = ((Byte) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).byteValue();
                        i13++;
                        i4 = 2;
                    }
                    bArr = bArr2;
                }
                if (bArr != null) {
                    byte[] bArr3 = ICustomTabsCallbackStubProxy;
                    Object[] objArr4 = {Integer.valueOf(i3), Integer.valueOf(onTransact)};
                    Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1991297565);
                    if (objAccessartificialFrame3 == null) {
                        byte b6 = (byte) 0;
                        byte b7 = b6;
                        objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(39 - TextUtils.indexOf((CharSequence) "", '0', 0), (char) ((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 36241), 2342 - ExpandableListView.getPackedPositionGroup(0L), 371880939, false, $$e(b6, b7, (byte) (b7 + 5)), new Class[]{Integer.TYPE, Integer.TYPE});
                    }
                    iIntValue = (byte) (((byte) (((long) bArr3[((Integer) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).intValue()]) ^ (-4629754035390455669L))) + ((int) (((long) mayLaunchUrl) ^ (-4629754035390455669L))));
                } else {
                    iIntValue = (short) (((short) (((long) ICustomTabsService[i3 + ((int) (((long) onTransact) ^ (-4629754035390455669L)))]) ^ (-4629754035390455669L))) + ((int) (((long) mayLaunchUrl) ^ (-4629754035390455669L))));
                }
            }
            if (iIntValue > 0) {
                int i16 = $10 + 101;
                $11 = i16 % 128;
                int i17 = i16 % 2;
                iCustomTabsCallback.c = ((i3 + iIntValue) - 2) + ((int) (((long) onTransact) ^ (-4629754035390455669L))) + (!z ? 0 : 1);
                Object[] objArr5 = {iCustomTabsCallback, Integer.valueOf(i), Integer.valueOf(getInterfaceDescriptor), sb};
                Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(216546027);
                if (objAccessartificialFrame4 == null) {
                    objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(40 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), (char) (ViewConfiguration.getScrollBarSize() >> 8), 4066 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)), -1819443997, false, "x", new Class[]{Object.class, Integer.TYPE, Integer.TYPE, Object.class});
                }
                ((StringBuilder) ((Method) objAccessartificialFrame4).invoke(null, objArr5)).append(iCustomTabsCallback.createConnectionCallback);
                iCustomTabsCallback.createBrowser = iCustomTabsCallback.createConnectionCallback;
                byte[] bArr4 = ICustomTabsCallbackStubProxy;
                if (bArr4 != null) {
                    int i18 = $10 + b.f40o;
                    $11 = i18 % 128;
                    int i19 = i18 % 2;
                    int length2 = bArr4.length;
                    byte[] bArr5 = new byte[length2];
                    for (int i20 = 0; i20 < length2; i20++) {
                        bArr5[i20] = (byte) (((long) bArr4[i20]) ^ (-4629754035390455669L));
                    }
                    bArr4 = bArr5;
                }
                boolean z2 = bArr4 != null;
                iCustomTabsCallback.a = 1;
                while (iCustomTabsCallback.a < iIntValue) {
                    if (z2) {
                        int i21 = $10 + 41;
                        $11 = i21 % 128;
                        int i22 = i21 % 2;
                        byte[] bArr6 = ICustomTabsCallbackStubProxy;
                        int i23 = iCustomTabsCallback.c;
                        iCustomTabsCallback.c = i23 - 1;
                        iCustomTabsCallback.createConnectionCallback = (char) (iCustomTabsCallback.createBrowser + (((byte) (((byte) (((long) bArr6[i23]) ^ (-4629754035390455669L))) + s)) ^ b));
                    } else {
                        short[] sArr = ICustomTabsService;
                        int i24 = iCustomTabsCallback.c;
                        iCustomTabsCallback.c = i24 - 1;
                        iCustomTabsCallback.createConnectionCallback = (char) (iCustomTabsCallback.createBrowser + (((short) (((short) (((long) sArr[i24]) ^ (-4629754035390455669L))) + s)) ^ b));
                    }
                    sb.append(iCustomTabsCallback.createConnectionCallback);
                    iCustomTabsCallback.createBrowser = iCustomTabsCallback.createConnectionCallback;
                    iCustomTabsCallback.a++;
                }
            }
            objArr[0] = sb.toString();
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 159681. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    public static java.lang.Object[] accessartificialFrame(android.content.Context r49, java.lang.String[] r50, int r51, int r52, int r53) {
        /*
            Method dump skipped, instruction units count: 15968
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bea.xml.stream.events.EntityReferenceEvent.accessartificialFrame(android.content.Context, java.lang.String[], int, int, int):java.lang.Object[]");
    }
}
