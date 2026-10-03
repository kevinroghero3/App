package com.google.android.gms.internal.mlkit_vision_barcode;

import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Process;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.google.common.base.Ascii;
import java.lang.reflect.Method;
import kotlin.io.encoding.Base64;
import o.ArtificialStackFrames;
import o.asBinder;
import o.onRelationshipValidationResult;
import okio.Utf8;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbz extends zzce {
    final /* synthetic */ zzci zza;
    private static final byte[] $$c = {Base64.padSymbol, 55, -5, -17};
    private static final int $$f = 137;
    private static int $10 = 0;
    private static int $11 = 1;
    private static final byte[] $$a = {84, -77, Utf8.REPLACEMENT_BYTE, -18, Ascii.FF, 6, -27, Ascii.SYN, Ascii.SUB, -4, Ascii.FF, 0, 8, 2, 8};
    private static final int $$b = 82;
    private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
    private static int artificialFrame = 1;
    private static long extraCommand = 170503296495187379L;
    private static long onPostMessage = 2192670157715340963L;

    /* JADX WARN: Code duplicated, block: B:10:0x0025  */
    /* JADX WARN: Code duplicated, block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x002d). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0025
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$g(int r7, short r8, byte r9) {
        /*
            int r9 = r9 + 4
            int r7 = r7 * 7
            int r7 = 118 - r7
            byte[] r0 = com.google.android.gms.internal.mlkit_vision_barcode.zzbz.$$c
            int r8 = r8 * 2
            int r8 = r8 + 1
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L14
            r3 = r9
            r4 = r2
            goto L2d
        L14:
            r3 = r2
        L15:
            r6 = r9
            r9 = r7
            r7 = r6
            int r4 = r3 + 1
            byte r5 = (byte) r9
            r1[r3] = r5
            if (r4 != r8) goto L25
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            return r7
        L25:
            int r7 = r7 + 1
            r3 = r0[r7]
            r6 = r9
            r9 = r7
            r7 = r3
            r3 = r6
        L2d:
            int r7 = -r7
            int r7 = r7 + r3
            r3 = r4
            goto L15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_barcode.zzbz.$$g(int, short, byte):java.lang.String");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzbz(zzci zzciVar) {
        super(zzciVar, null);
        this.zza = zzciVar;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0029  */
    /* JADX WARN: Code duplicated, block: B:8:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0029 -> B:11:0x0032). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0029
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void c(int r6, short r7, int r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = com.google.android.gms.internal.mlkit_vision_barcode.zzbz.$$a
            int r6 = r6 * 5
            int r1 = r6 + 4
            int r8 = r8 * 8
            int r8 = 12 - r8
            int r7 = r7 * 3
            int r7 = r7 + 112
            byte[] r1 = new byte[r1]
            int r6 = r6 + 3
            r2 = 0
            if (r0 != 0) goto L18
            r3 = r8
            r4 = r2
            goto L32
        L18:
            r3 = r2
        L19:
            r5 = r8
            r8 = r7
            r7 = r5
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r6) goto L29
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L29:
            int r3 = r3 + 1
            r4 = r0[r7]
            r5 = r8
            r8 = r7
            r7 = r4
            r4 = r3
            r3 = r5
        L32:
            int r8 = r8 + 1
            int r3 = r3 + r7
            int r7 = r3 + (-7)
            r3 = r4
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_barcode.zzbz.c(int, short, int, java.lang.Object[]):void");
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzce
    final Object zza(int i) {
        return zzci.zzg(this.zza, i);
    }

    private static void b(int i, char[] cArr, Object[] objArr) throws Throwable {
        int i2 = 2 % 2;
        onRelationshipValidationResult onrelationshipvalidationresult = new onRelationshipValidationResult();
        char[] cArrAccessartificialFrame = onRelationshipValidationResult.accessartificialFrame(onPostMessage ^ 2573525503365829440L, cArr, i);
        onrelationshipvalidationresult.e = 4;
        int i3 = $11 + 117;
        $10 = i3 % 128;
        int i4 = i3 % 2;
        while (onrelationshipvalidationresult.e < cArrAccessartificialFrame.length) {
            int i5 = $11 + 17;
            $10 = i5 % 128;
            int i6 = i5 % 2;
            onrelationshipvalidationresult.d = onrelationshipvalidationresult.e - 4;
            int i7 = onrelationshipvalidationresult.e;
            try {
                Object[] objArr2 = {Long.valueOf(cArrAccessartificialFrame[onrelationshipvalidationresult.e] ^ cArrAccessartificialFrame[onrelationshipvalidationresult.e % 4]), Long.valueOf(onrelationshipvalidationresult.d), Long.valueOf(onPostMessage)};
                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(797310229);
                if (objAccessartificialFrame == null) {
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(TextUtils.lastIndexOf("", '0', 0, 0) + 28, (char) (AndroidCharacter.getMirror('0') + 30642), 189 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), -1327449315, false, "k", new Class[]{Long.TYPE, Long.TYPE, Long.TYPE});
                }
                cArrAccessartificialFrame[i7] = ((Character) ((Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                Object[] objArr3 = {onrelationshipvalidationresult, onrelationshipvalidationresult};
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(321542193);
                if (objAccessartificialFrame2 == null) {
                    int i8 = (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 32;
                    char cMyPid = (char) (Process.myPid() >> 22);
                    int keyRepeatDelay = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 1483;
                    byte b = (byte) ($$f & 7);
                    byte b2 = (byte) (b - 1);
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(i8, cMyPid, keyRepeatDelay, -1940971975, false, $$g(b, b2, (byte) (b2 - 1)), new Class[]{Object.class, Object.class});
                }
                ((Method) objAccessartificialFrame2).invoke(null, objArr3);
                int i9 = $11 + 73;
                $10 = i9 % 128;
                if (i9 % 2 != 0) {
                    int i10 = 5 / 5;
                }
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }
        objArr[0] = new String(cArrAccessartificialFrame, 4, cArrAccessartificialFrame.length - 4);
    }

    private static void a(int i, char[] cArr, Object[] objArr) throws Throwable {
        int i2 = 2 % 2;
        asBinder asbinder = new asBinder();
        asbinder.c = i;
        int length = cArr.length;
        long[] jArr = new long[length];
        asbinder.d = 0;
        int i3 = $11 + 45;
        $10 = i3 % 128;
        int i4 = i3 % 2;
        while (asbinder.d < cArr.length) {
            int i5 = asbinder.d;
            try {
                Object[] objArr2 = {Integer.valueOf(cArr[asbinder.d]), asbinder, asbinder};
                Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1562553046);
                if (objAccessartificialFrame == null) {
                    byte b = (byte) 0;
                    byte b2 = b;
                    objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(11 - KeyEvent.getDeadChar(0, 0), (char) ((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 1), 1407 - Color.green(0), 1035473698, false, $$g(b, b2, (byte) (b2 - 1)), new Class[]{Integer.TYPE, Object.class, Object.class});
                }
                jArr[i5] = ((Long) ((Method) objAccessartificialFrame).invoke(null, objArr2)).longValue() ^ (extraCommand ^ (-2360974883025274865L));
                Object[] objArr3 = {asbinder, asbinder};
                Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1981632360);
                if (objAccessartificialFrame2 == null) {
                    objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getKeyRepeatDelay() >> 16) + 8, (char) (ViewConfiguration.getScrollBarSize() >> 8), 249 - (ViewConfiguration.getKeyRepeatDelay() >> 16), 378009232, false, "w", new Class[]{Object.class, Object.class});
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
        char[] cArr2 = new char[length];
        asbinder.d = 0;
        while (asbinder.d < cArr.length) {
            int i6 = $10 + 65;
            $11 = i6 % 128;
            int i7 = i6 % 2;
            cArr2[asbinder.d] = (char) jArr[asbinder.d];
            Object[] objArr4 = {asbinder, asbinder};
            Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-1981632360);
            if (objAccessartificialFrame3 == null) {
                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(7 - ((byte) KeyEvent.getModifierMetaStateMask()), (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), Drawable.resolveOpacity(0, 0) + 249, 378009232, false, "w", new Class[]{Object.class, Object.class});
            }
            ((Method) objAccessartificialFrame3).invoke(null, objArr4);
        }
        objArr[0] = new String(cArr2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v199, types: [java.lang.reflect.Method] */
    /* JADX WARN: Type inference failed for: r10v205, types: [java.nio.LongBuffer] */
    /* JADX WARN: Type inference failed for: r10v378, types: [java.lang.reflect.Field] */
    /* JADX WARN: Type inference failed for: r10v382, types: [java.lang.reflect.Field] */
    /* JADX WARN: Type inference failed for: r13v189, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r1v397, types: [java.lang.reflect.Method] */
    /* JADX WARN: Type inference failed for: r28v0 */
    /* JADX WARN: Type inference failed for: r28v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r28v13 */
    /* JADX WARN: Type inference failed for: r28v14 */
    /* JADX WARN: Type inference failed for: r28v2 */
    /* JADX WARN: Type inference failed for: r28v23 */
    /* JADX WARN: Type inference failed for: r28v24 */
    /* JADX WARN: Type inference failed for: r28v25 */
    /* JADX WARN: Type inference failed for: r28v27, types: [char] */
    /* JADX WARN: Type inference failed for: r28v28 */
    /* JADX WARN: Type inference failed for: r28v29 */
    /* JADX WARN: Type inference failed for: r28v30 */
    /* JADX WARN: Type inference failed for: r28v31 */
    /* JADX WARN: Type inference failed for: r28v32 */
    /* JADX WARN: Type inference failed for: r28v33 */
    /* JADX WARN: Type inference failed for: r28v34 */
    /* JADX WARN: Type inference failed for: r28v35 */
    /* JADX WARN: Type inference failed for: r28v36 */
    /* JADX WARN: Type inference failed for: r28v37 */
    /* JADX WARN: Type inference failed for: r28v4 */
    /* JADX WARN: Type inference failed for: r28v5 */
    /* JADX WARN: Type inference failed for: r28v6, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r28v7 */
    /* JADX WARN: Type inference failed for: r28v8 */
    /* JADX WARN: Type inference failed for: r29v1 */
    /* JADX WARN: Type inference failed for: r29v10 */
    /* JADX WARN: Type inference failed for: r29v103 */
    /* JADX WARN: Type inference failed for: r29v104 */
    /* JADX WARN: Type inference failed for: r29v105 */
    /* JADX WARN: Type inference failed for: r29v107, types: [int] */
    /* JADX WARN: Type inference failed for: r29v11 */
    /* JADX WARN: Type inference failed for: r29v110 */
    /* JADX WARN: Type inference failed for: r29v111 */
    /* JADX WARN: Type inference failed for: r29v112 */
    /* JADX WARN: Type inference failed for: r29v113 */
    /* JADX WARN: Type inference failed for: r29v114 */
    /* JADX WARN: Type inference failed for: r29v115 */
    /* JADX WARN: Type inference failed for: r29v116 */
    /* JADX WARN: Type inference failed for: r29v117 */
    /* JADX WARN: Type inference failed for: r29v118 */
    /* JADX WARN: Type inference failed for: r29v119 */
    /* JADX WARN: Type inference failed for: r29v120 */
    /* JADX WARN: Type inference failed for: r29v121 */
    /* JADX WARN: Type inference failed for: r29v122 */
    /* JADX WARN: Type inference failed for: r29v123 */
    /* JADX WARN: Type inference failed for: r29v124 */
    /* JADX WARN: Type inference failed for: r29v125 */
    /* JADX WARN: Type inference failed for: r29v126 */
    /* JADX WARN: Type inference failed for: r29v127 */
    /* JADX WARN: Type inference failed for: r29v128 */
    /* JADX WARN: Type inference failed for: r29v129 */
    /* JADX WARN: Type inference failed for: r29v13 */
    /* JADX WARN: Type inference failed for: r29v130 */
    /* JADX WARN: Type inference failed for: r29v131 */
    /* JADX WARN: Type inference failed for: r29v132 */
    /* JADX WARN: Type inference failed for: r29v133 */
    /* JADX WARN: Type inference failed for: r29v14 */
    /* JADX WARN: Type inference failed for: r29v2 */
    /* JADX WARN: Type inference failed for: r29v22 */
    /* JADX WARN: Type inference failed for: r29v23 */
    /* JADX WARN: Type inference failed for: r29v3 */
    /* JADX WARN: Type inference failed for: r29v30, types: [int] */
    /* JADX WARN: Type inference failed for: r29v31 */
    /* JADX WARN: Type inference failed for: r29v36 */
    /* JADX WARN: Type inference failed for: r29v39 */
    /* JADX WARN: Type inference failed for: r29v4 */
    /* JADX WARN: Type inference failed for: r29v43 */
    /* JADX WARN: Type inference failed for: r29v44 */
    /* JADX WARN: Type inference failed for: r29v45 */
    /* JADX WARN: Type inference failed for: r29v5 */
    /* JADX WARN: Type inference failed for: r29v52 */
    /* JADX WARN: Type inference failed for: r29v56 */
    /* JADX WARN: Type inference failed for: r29v57 */
    /* JADX WARN: Type inference failed for: r29v58 */
    /* JADX WARN: Type inference failed for: r29v7 */
    /* JADX WARN: Type inference failed for: r29v71 */
    /* JADX WARN: Type inference failed for: r29v72 */
    /* JADX WARN: Type inference failed for: r29v73 */
    /* JADX WARN: Type inference failed for: r29v74 */
    /* JADX WARN: Type inference failed for: r29v75 */
    /* JADX WARN: Type inference failed for: r29v76 */
    /* JADX WARN: Type inference failed for: r29v77 */
    /* JADX WARN: Type inference failed for: r29v78 */
    /* JADX WARN: Type inference failed for: r29v79 */
    /* JADX WARN: Type inference failed for: r29v8 */
    /* JADX WARN: Type inference failed for: r29v80 */
    /* JADX WARN: Type inference failed for: r29v81 */
    /* JADX WARN: Type inference failed for: r29v82 */
    /* JADX WARN: Type inference failed for: r29v83 */
    /* JADX WARN: Type inference failed for: r29v84 */
    /* JADX WARN: Type inference failed for: r29v88 */
    /* JADX WARN: Type inference failed for: r29v9 */
    /* JADX WARN: Type inference failed for: r29v91 */
    /* JADX WARN: Type inference failed for: r29v92 */
    /* JADX WARN: Type inference failed for: r29v93 */
    /* JADX WARN: Type inference failed for: r29v94 */
    /* JADX WARN: Type inference failed for: r29v95 */
    /* JADX WARN: Type inference failed for: r29v96 */
    /* JADX WARN: Type inference failed for: r29v98 */
    /* JADX WARN: Type inference failed for: r2v201, types: [java.nio.LongBuffer[]] */
    /* JADX WARN: Type inference failed for: r4v357, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r4v358 */
    /* JADX WARN: Type inference failed for: r4v359 */
    /* JADX WARN: Type inference failed for: r4v360, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v362, types: [java.io.InputStream, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v463 */
    /* JADX WARN: Type inference failed for: r4v464 */
    /* JADX WARN: Type inference failed for: r5v195, types: [java.lang.Object, java.nio.LongBuffer] */
    /* JADX WARN: Type inference failed for: r5v59, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v423, types: [java.lang.reflect.Constructor] */
    /* JADX WARN: Type inference failed for: r6v436, types: [java.lang.reflect.Field] */
    /* JADX WARN: Type inference failed for: r7v389, types: [java.lang.reflect.Field] */
    /* JADX WARN: Type inference failed for: r7v398, types: [java.lang.reflect.Method] */
    /* JADX WARN: Type inference failed for: r9v160 */
    /* JADX WARN: Type inference failed for: r9v161 */
    /* JADX WARN: Type inference failed for: r9v221 */
    /* JADX WARN: Type inference failed for: r9v222 */
    /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
        java.util.NoSuchElementException
        	at java.base/java.util.TreeMap.key(Unknown Source)
        	at java.base/java.util.TreeMap.lastKey(Unknown Source)
        	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
        	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
        	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
        */
    public static java.lang.Object[] accessartificialFrame(android.content.Context r43, java.lang.String[] r44, int r45, int r46, int r47) {
        /*
            Method dump skipped, instruction units count: 15204
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_barcode.zzbz.accessartificialFrame(android.content.Context, java.lang.String[], int, int, int):java.lang.Object[]");
    }
}
