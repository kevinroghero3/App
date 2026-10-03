package it.aep_italia.vts.sdk.dto.soap.responses;

import android.os.Process;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.google.common.base.Ascii;
import it.aep_italia.vts.sdk.dto.soap.VtsSoapEnvelope;
import it.aep_italia.vts.sdk.dto.soap.VtsSoapHeader;
import java.lang.reflect.Method;
import o.ArtificialStackFrames;
import o.artificialFrame;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

/* JADX INFO: loaded from: classes6.dex */
@Root(name = "Envelope")
public class VtsSoapInitSessionResponse extends VtsSoapEnvelope implements VtsSoapResponse {

    @Element(name = "ErrorStr", required = false)
    @Path("soap:Body/vtsr:vts_InitSessionResponse/vtsr:vts_InitSessionResult")
    private String b;

    @Element(name = "RetCode")
    @Path("soap:Body/vtsr:vts_InitSessionResponse/vtsr:vts_InitSessionResult")
    private Integer c;

    @Element(name = "SessionID", required = false)
    @Path("soap:Body/vtsr:vts_InitSessionResponse/vtsr:vts_InitSessionResult")
    private String d;
    private static final byte[] $$c = {111, -52, 8, -63};
    private static final int $$d = 1;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$a = {110, -7, -8, 89, Ascii.VT, 2, -12};
    private static final int $$b = 236;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static int[] ICustomTabsCallbackStub = {-1113756268, 1350963866, 765503131, 2053003102, 144877495, 2025856581, 1663221578, -2122368732, -1966223253, 923257134, 1216566651, 95126227, -1597007402, -1931012592, -1960923086, -1352254221, -1595191136, 2118941330};

    /* JADX WARN: Code duplicated, block: B:10:0x0024  */
    /* JADX WARN: Code duplicated, block: B:8:0x001e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0024 -> B:11:0x002c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0024
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$e(int r6, int r7, byte r8) {
        /*
            int r8 = r8 * 2
            int r8 = 3 - r8
            int r7 = r7 * 2
            int r0 = r7 + 1
            byte[] r1 = it.aep_italia.vts.sdk.dto.soap.responses.VtsSoapInitSessionResponse.$$c
            int r6 = r6 * 6
            int r6 = r6 + 109
            byte[] r0 = new byte[r0]
            r2 = 0
            if (r1 != 0) goto L16
            r3 = r8
            r4 = r2
            goto L2c
        L16:
            r3 = r2
        L17:
            int r8 = r8 + 1
            byte r4 = (byte) r6
            r0[r3] = r4
            if (r3 != r7) goto L24
            java.lang.String r6 = new java.lang.String
            r6.<init>(r0, r2)
            return r6
        L24:
            r4 = r1[r8]
            int r3 = r3 + 1
            r5 = r3
            r3 = r8
            r8 = r4
            r4 = r5
        L2c:
            int r8 = -r8
            int r6 = r6 + r8
            r8 = r3
            r3 = r4
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: it.aep_italia.vts.sdk.dto.soap.responses.VtsSoapInitSessionResponse.$$e(int, int, byte):java.lang.String");
    }

    protected VtsSoapInitSessionResponse() {
        super(new VtsSoapHeader(null, null));
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0027  */
    /* JADX WARN: Code duplicated, block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x002b). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0027
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void f(int r5, short r6, short r7, java.lang.Object[] r8) {
        /*
            int r7 = r7 * 4
            int r7 = 4 - r7
            int r5 = r5 * 4
            int r0 = r5 + 4
            byte[] r1 = it.aep_italia.vts.sdk.dto.soap.responses.VtsSoapInitSessionResponse.$$a
            int r6 = r6 * 4
            int r6 = r6 + 109
            byte[] r0 = new byte[r0]
            int r5 = r5 + 3
            r2 = 0
            if (r1 != 0) goto L19
            r6 = r5
            r4 = r7
            r3 = r2
            goto L2b
        L19:
            r3 = r2
        L1a:
            byte r4 = (byte) r6
            r0[r3] = r4
            if (r3 != r5) goto L27
            java.lang.String r5 = new java.lang.String
            r5.<init>(r0, r2)
            r8[r2] = r5
            return
        L27:
            r4 = r1[r7]
            int r3 = r3 + 1
        L2b:
            int r7 = r7 + 1
            int r6 = r6 + r4
            int r6 = r6 + (-3)
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: it.aep_italia.vts.sdk.dto.soap.responses.VtsSoapInitSessionResponse.f(int, short, short, java.lang.Object[]):void");
    }

    @Override // it.aep_italia.vts.sdk.dto.soap.responses.VtsSoapResponse
    public String getDataOutBin() {
        return null;
    }

    @Override // it.aep_italia.vts.sdk.dto.soap.responses.VtsSoapResponse
    public String getDataOutXml() {
        return null;
    }

    @Override // it.aep_italia.vts.sdk.dto.soap.responses.VtsSoapResponse
    public String getErrorString() {
        return this.b;
    }

    @Override // it.aep_italia.vts.sdk.dto.soap.responses.VtsSoapResponse
    public Integer getReturnCode() {
        return this.c;
    }

    public String getSessionID() {
        return this.d;
    }

    public void setErrorString(String str) {
        this.b = str;
    }

    public void setReturnCode(Integer num) {
        this.c = num;
    }

    public void setSessionID(String str) {
        this.d = str;
    }

    private static void e(int i, int[] iArr, Object[] objArr) throws Throwable {
        int i2 = 2 % 2;
        artificialFrame artificialframe = new artificialFrame();
        char[] cArr = new char[4];
        char[] cArr2 = new char[iArr.length * 2];
        int[] iArr2 = ICustomTabsCallbackStub;
        int i3 = -1780896814;
        char c = '0';
        int i4 = 1;
        int i5 = 0;
        if (iArr2 != null) {
            int i6 = $10 + 77;
            int i7 = i6 % 128;
            $11 = i7;
            int i8 = i6 % 2;
            int length = iArr2.length;
            int[] iArr3 = new int[length];
            int i9 = i7 + 107;
            $10 = i9 % 128;
            int i10 = i9 % 2;
            int i11 = 0;
            while (i11 < length) {
                try {
                    Object[] objArr2 = new Object[1];
                    objArr2[i5] = Integer.valueOf(iArr2[i11]);
                    Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(i3);
                    if (objAccessartificialFrame == null) {
                        int iLastIndexOf = 10 - TextUtils.lastIndexOf("", c, i5);
                        char cMyTid = (char) (Process.myTid() >> 22);
                        int iLastIndexOf2 = TextUtils.lastIndexOf("", c, i5) + 1563;
                        byte b = (byte) ($$d - 1);
                        byte b2 = b;
                        objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(iLastIndexOf, cMyTid, iLastIndexOf2, 180153818, false, $$e(b, b2, b2), new Class[]{Integer.TYPE});
                    }
                    iArr3[i11] = ((Integer) ((Method) objAccessartificialFrame).invoke(null, objArr2)).intValue();
                    i11++;
                    i3 = -1780896814;
                    c = '0';
                    i5 = 0;
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
            iArr2 = iArr3;
        }
        int length2 = iArr2.length;
        int[] iArr4 = new int[length2];
        int[] iArr5 = ICustomTabsCallbackStub;
        if (iArr5 != null) {
            int length3 = iArr5.length;
            int[] iArr6 = new int[length3];
            int i12 = 0;
            while (i12 < length3) {
                Object[] objArr3 = new Object[i4];
                objArr3[0] = Integer.valueOf(iArr5[i12]);
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1780896814);
                if (objAccessartificialFrame2 == null) {
                    int packedPositionType = ExpandableListView.getPackedPositionType(0L) + 11;
                    char cLastIndexOf = (char) (TextUtils.lastIndexOf("", '0') + i4);
                    int iIndexOf = TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 1563;
                    byte b3 = (byte) ($$d - 1);
                    byte b4 = b3;
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(packedPositionType, cLastIndexOf, iIndexOf, 180153818, false, $$e(b3, b4, b4), new Class[]{Integer.TYPE});
                }
                iArr6[i12] = ((Integer) ((Method) objAccessartificialFrame2).invoke(null, objArr3)).intValue();
                i12++;
                int i13 = $10 + 1;
                $11 = i13 % 128;
                int i14 = i13 % 2;
                iArr5 = iArr5;
                i4 = 1;
            }
            iArr5 = iArr6;
        }
        System.arraycopy(iArr5, 0, iArr4, 0, length2);
        artificialframe.e = 0;
        while (artificialframe.e < iArr.length) {
            cArr[0] = (char) (iArr[artificialframe.e] >> 16);
            cArr[1] = (char) iArr[artificialframe.e];
            cArr[2] = (char) (iArr[artificialframe.e + 1] >> 16);
            cArr[3] = (char) iArr[artificialframe.e + 1];
            artificialframe.c = (cArr[0] << 16) + cArr[1];
            artificialframe.b = (cArr[2] << 16) + cArr[3];
            artificialFrame.coroutineBoundary(iArr4);
            for (int i15 = 0; i15 < 16; i15++) {
                artificialframe.c ^= iArr4[i15];
                Object[] objArr4 = {artificialframe, Integer.valueOf(artificialFrame.coroutineBoundary(artificialframe.c)), artificialframe, artificialframe};
                Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1540318455);
                if (objAccessartificialFrame3 == null) {
                    int modifierMetaStateMask = 25 - ((byte) KeyEvent.getModifierMetaStateMask());
                    char tapTimeout = (char) (ViewConfiguration.getTapTimeout() >> 16);
                    int edgeSlop = (ViewConfiguration.getEdgeSlop() >> 16) + 1041;
                    byte b5 = (byte) $$d;
                    byte b6 = (byte) (b5 - 1);
                    objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(modifierMetaStateMask, tapTimeout, edgeSlop, 995482881, false, $$e(b5, b6, b6), new Class[]{Object.class, Integer.TYPE, Object.class, Object.class});
                }
                int iIntValue = ((Integer) ((Method) objAccessartificialFrame3).invoke(null, objArr4)).intValue();
                artificialframe.c = artificialframe.b;
                artificialframe.b = iIntValue;
            }
            int i16 = artificialframe.c;
            artificialframe.c = artificialframe.b;
            artificialframe.b = i16;
            artificialframe.b ^= iArr4[16];
            artificialframe.c ^= iArr4[17];
            int i17 = artificialframe.c;
            int i18 = artificialframe.b;
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
                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(37 - (ViewConfiguration.getWindowTouchSlop() >> 8), (char) (28010 - Gravity.getAbsoluteGravity(0, 0)), 306 - (ViewConfiguration.getDoubleTapTimeout() >> 16), -818175402, false, "q", new Class[]{Object.class, Object.class});
            }
            ((Method) objAccessartificialFrame4).invoke(null, objArr5);
        }
        objArr[0] = new String(cArr2, 0, i);
    }

    /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
        java.util.NoSuchElementException
        	at java.base/java.util.TreeMap.key(Unknown Source)
        	at java.base/java.util.TreeMap.lastKey(Unknown Source)
        	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
        	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
        	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
        */
    public static java.lang.Object[] _CREATION(int r37, int r38) {
        /*
            Method dump skipped, instruction units count: 2810
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: it.aep_italia.vts.sdk.dto.soap.responses.VtsSoapInitSessionResponse._CREATION(int, int):java.lang.Object[]");
    }
}
