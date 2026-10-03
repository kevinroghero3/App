package com.google.protobuf;

import android.graphics.Color;
import android.graphics.ImageFormat;
import android.os.Process;
import android.os.SystemClock;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import ch.qos.logback.core.net.SyslogConstants;
import com.facebook.imageutils.JfifUtil;
import com.google.common.base.Ascii;
import com.google.common.primitives.ImmutableIntArray;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import o.ArtificialStackFrames;
import o.onPostMessage;

/* JADX INFO: loaded from: classes6.dex */
final class RopeByteString extends ByteString {
    static final int[] minLengthByDepth = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, SyslogConstants.LOG_LOCAL2, 233, 377, TypedValues.MotionType.TYPE_QUANTIZE_MOTIONSTEPS, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296, 433494437, 701408733, 1134903170, 1836311903, Integer.MAX_VALUE};
    private static final long serialVersionUID = 1;
    private final ByteString left;
    private final int leftLength;
    private final ByteString right;
    private final int totalLength;
    private final int treeDepth;

    private RopeByteString(ByteString byteString, ByteString byteString2) {
        this.left = byteString;
        this.right = byteString2;
        int size = byteString.size();
        this.leftLength = size;
        this.totalLength = size + byteString2.size();
        this.treeDepth = Math.max(byteString.getTreeDepth(), byteString2.getTreeDepth()) + 1;
    }

    static ByteString concatenate(ByteString byteString, ByteString byteString2) {
        if (byteString2.size() == 0) {
            return byteString;
        }
        if (byteString.size() == 0) {
            return byteString2;
        }
        int size = byteString.size() + byteString2.size();
        if (size < 128) {
            return concatenateBytes(byteString, byteString2);
        }
        if (byteString instanceof RopeByteString) {
            RopeByteString ropeByteString = (RopeByteString) byteString;
            if (ropeByteString.right.size() + byteString2.size() < 128) {
                return new RopeByteString(ropeByteString.left, concatenateBytes(ropeByteString.right, byteString2));
            }
            if (ropeByteString.left.getTreeDepth() > ropeByteString.right.getTreeDepth() && ropeByteString.getTreeDepth() > byteString2.getTreeDepth()) {
                return new RopeByteString(ropeByteString.left, new RopeByteString(ropeByteString.right, byteString2));
            }
        }
        if (size >= minLength(Math.max(byteString.getTreeDepth(), byteString2.getTreeDepth()) + 1)) {
            return new RopeByteString(byteString, byteString2);
        }
        return new Balancer().balance(byteString, byteString2);
    }

    public static final class PieceIterator implements Iterator<ByteString.LeafByteString> {
        private final ArrayDeque<RopeByteString> breadCrumbs;
        private ByteString.LeafByteString next;
        private static final byte[] $$c = {115, -32, -105, -45};
        private static final int $$d = 42;
        private static int $10 = 0;
        private static int $11 = 1;
        private static final byte[] $$a = {79, -66, -116, -33, -11, -2, Ascii.FF};
        private static final int $$b = 95;
        private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
        private static int artificialFrame = 1;
        private static char[] IPostMessageService = {38399, 38358, 38365, 38350, 38342, 38339, 38346, 38347, 38342, 38359, 38360, 38339, 38339, 38344, 38349, 38342, 38341, 38349, 38347, 38276, 38355, 38362, 38353, 38353, 38356, 38357, 38377, 38373, 38351, 38372, 38379, 38364, 38356, 38353, 38360, 38361, 38356, 38367, 38265, 38263, 38261, 38256, 38260, 38266, 38167, 38162, 38255, 38160, 38183, 38156, 38269, 38261, 38258, 38282, 38359, 38356, 38351, 38358, 38359, 38386, 38390, 38363, 38364, 38356, 38353, 38388, 38382, 38348, 38358, 38365, 38361, 38356, 38357, 38388, 38390, 38355, 38348, 38349, 38356, 38358, 38350, 38358, 38358, 38348, 38358, 38365, 38363, 38356, 38383, 38382, 38345, 38345, 38382, 38279, 38352, 38353, 38356, 38254, 38255, 38154, 38157, 38250, 38244, 38254, 38261, 38259, 38261, 38261, 38254, 38256, 38262, 38256, 38255, 38259, 38158, 38152, 38246, 38247, 38254, 38158, 38150, 38241, 38241, 38150, 38154, 38255, 38252, 38299, 38278, 38382, 38386, 38359, 38356, 38351, 38358, 38359, 38386, 38390, 38363, 38364, 38356, 38353, 38388, 38382, 38348, 38358, 38365, 38361, 38356, 38357, 38388, 38382, 38348, 38358, 38365, 38361, 38356, 38357, 38364, 38360, 38353, 38385, 38382, 38345};

        /* JADX WARN: Code duplicated, block: B:10:0x0025  */
        /* JADX WARN: Code duplicated, block: B:8:0x001f  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x002c). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0025
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        private static java.lang.String $$e(short r6, int r7, int r8) {
            /*
                byte[] r0 = com.google.protobuf.RopeByteString.PieceIterator.$$c
                int r6 = r6 * 3
                int r6 = 1 - r6
                int r7 = r7 + 4
                int r8 = r8 * 3
                int r8 = r8 + 65
                byte[] r1 = new byte[r6]
                r2 = 0
                if (r0 != 0) goto L15
                r3 = r6
                r8 = r7
                r4 = r2
                goto L2c
            L15:
                r3 = r2
            L16:
                byte r4 = (byte) r8
                r1[r3] = r4
                int r3 = r3 + 1
                int r7 = r7 + 1
                if (r3 != r6) goto L25
                java.lang.String r6 = new java.lang.String
                r6.<init>(r1, r2)
                return r6
            L25:
                r4 = r0[r7]
                r5 = r8
                r8 = r7
                r7 = r4
                r4 = r3
                r3 = r5
            L2c:
                int r7 = -r7
                int r7 = r7 + r3
                r3 = r4
                r5 = r8
                r8 = r7
                r7 = r5
                goto L16
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.RopeByteString.PieceIterator.$$e(short, int, int):java.lang.String");
        }

        /* JADX WARN: Code duplicated, block: B:10:0x0027  */
        /* JADX WARN: Code duplicated, block: B:8:0x001f  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x002e). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0027
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        private static void a(int r6, byte r7, short r8, java.lang.Object[] r9) {
            /*
                int r8 = r8 * 3
                int r8 = r8 + 109
                byte[] r0 = com.google.protobuf.RopeByteString.PieceIterator.$$a
                int r7 = r7 * 2
                int r7 = 4 - r7
                int r6 = r6 * 3
                int r1 = r6 + 4
                byte[] r1 = new byte[r1]
                int r6 = r6 + 3
                r2 = 0
                if (r0 != 0) goto L19
                r4 = r8
                r3 = r2
                r8 = r7
                goto L2e
            L19:
                r3 = r2
            L1a:
                byte r4 = (byte) r8
                r1[r3] = r4
                if (r3 != r6) goto L27
                java.lang.String r6 = new java.lang.String
                r6.<init>(r1, r2)
                r9[r2] = r6
                return
            L27:
                r4 = r0[r7]
                int r3 = r3 + 1
                r5 = r8
                r8 = r7
                r7 = r5
            L2e:
                int r4 = -r4
                int r7 = r7 + r4
                int r7 = r7 + (-3)
                int r8 = r8 + 1
                r5 = r8
                r8 = r7
                r7 = r5
                goto L1a
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.RopeByteString.PieceIterator.a(int, byte, short, java.lang.Object[]):void");
        }

        private static void b(byte[] bArr, int[] iArr, boolean z, Object[] objArr) throws Throwable {
            int i;
            byte b;
            char[] cArr;
            char c;
            int i2 = 2;
            int i3 = 2 % 2;
            onPostMessage onpostmessage = new onPostMessage();
            int i4 = 0;
            int i5 = iArr[0];
            int i6 = 1;
            int i7 = iArr[1];
            int i8 = iArr[2];
            int i9 = iArr[3];
            char[] cArr2 = IPostMessageService;
            if (cArr2 != null) {
                int length = cArr2.length;
                char[] cArr3 = new char[length];
                int i10 = 0;
                while (i10 < length) {
                    int i11 = $10 + 5;
                    $11 = i11 % 128;
                    if (i11 % i2 == 0) {
                        try {
                            Object[] objArr2 = new Object[i6];
                            objArr2[i4] = Integer.valueOf(cArr2[i10]);
                            Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1782207618);
                            if (objAccessartificialFrame == null) {
                                int iLastIndexOf = 10 - TextUtils.lastIndexOf("", '0', i4, i4);
                                char defaultSize = (char) View.getDefaultSize(i4, i4);
                                int iRed = Color.red(i4) + 1562;
                                byte b2 = (byte) i4;
                                byte b3 = (byte) (b2 - 1);
                                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(iLastIndexOf, defaultSize, iRed, 178318710, false, $$e(b2, b3, (byte) (b3 + 1)), new Class[]{Integer.TYPE});
                            }
                            cArr3[i10] = ((Character) ((java.lang.reflect.Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                        } catch (Throwable th) {
                            Throwable cause = th.getCause();
                            if (cause == null) {
                                throw th;
                            }
                            throw cause;
                        }
                    } else {
                        Object[] objArr3 = {Integer.valueOf(cArr2[i10])};
                        Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1782207618);
                        if (objAccessartificialFrame2 == null) {
                            byte b4 = (byte) 0;
                            byte b5 = (byte) (b4 - 1);
                            objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(MotionEvent.axisFromString("") + 12, (char) View.MeasureSpec.makeMeasureSpec(0, 0), 1562 - View.MeasureSpec.getMode(0), 178318710, false, $$e(b4, b5, (byte) (b5 + 1)), new Class[]{Integer.TYPE});
                        }
                        cArr3[i10] = ((Character) ((java.lang.reflect.Method) objAccessartificialFrame2).invoke(null, objArr3)).charValue();
                        i10++;
                    }
                    i2 = 2;
                    i4 = 0;
                    i6 = 1;
                }
                cArr2 = cArr3;
            }
            char[] cArr4 = new char[i7];
            System.arraycopy(cArr2, i5, cArr4, 0, i7);
            if (bArr != null) {
                int i12 = $11 + 101;
                $10 = i12 % 128;
                if (i12 % 2 != 0) {
                    cArr = new char[i7];
                    b = 1;
                    onpostmessage.a = 1;
                    c = 1;
                } else {
                    b = 1;
                    cArr = new char[i7];
                    onpostmessage.a = 0;
                    c = 0;
                }
                while (onpostmessage.a < i7) {
                    if (bArr[onpostmessage.a] == b) {
                        int i13 = $10 + 45;
                        $11 = i13 % 128;
                        int i14 = i13 % 2;
                        int i15 = onpostmessage.a;
                        Object[] objArr4 = {Integer.valueOf(cArr4[onpostmessage.a]), Integer.valueOf(c)};
                        Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(1378437083);
                        if (objAccessartificialFrame3 == null) {
                            byte b6 = (byte) 0;
                            byte b7 = (byte) (b6 - 1);
                            objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(TextUtils.indexOf("", "") + 23, (char) Color.green(0), 2441 - ExpandableListView.getPackedPositionGroup(0L), -850656813, false, $$e(b6, b7, (byte) (-b7)), new Class[]{Integer.TYPE, Integer.TYPE});
                        }
                        cArr[i15] = ((Character) ((java.lang.reflect.Method) objAccessartificialFrame3).invoke(null, objArr4)).charValue();
                    } else {
                        int i16 = onpostmessage.a;
                        Object[] objArr5 = {Integer.valueOf(cArr4[onpostmessage.a]), Integer.valueOf(c)};
                        Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-314759072);
                        if (objAccessartificialFrame4 == null) {
                            byte b8 = (byte) 0;
                            byte b9 = (byte) (b8 - 1);
                            objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(11 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16), 1561 - ImageFormat.getBitsPerPixel(0), 1918398056, false, $$e(b8, b9, (byte) (b9 & 19)), new Class[]{Integer.TYPE, Integer.TYPE});
                        }
                        cArr[i16] = ((Character) ((java.lang.reflect.Method) objAccessartificialFrame4).invoke(null, objArr5)).charValue();
                        int i17 = $11 + 67;
                        $10 = i17 % 128;
                        int i18 = i17 % 2;
                    }
                    c = cArr[onpostmessage.a];
                    Object[] objArr6 = {onpostmessage, onpostmessage};
                    Object objAccessartificialFrame5 = ArtificialStackFrames.accessartificialFrame(898481158);
                    if (objAccessartificialFrame5 == null) {
                        objAccessartificialFrame5 = ArtificialStackFrames.coroutineCreation(23 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (char) (Process.getGidForName("") + 29364), 215 - ExpandableListView.getPackedPositionGroup(0L), -1427572210, false, "F", new Class[]{Object.class, Object.class});
                    }
                    ((java.lang.reflect.Method) objAccessartificialFrame5).invoke(null, objArr6);
                    b = 1;
                }
                cArr4 = cArr;
            }
            if (i9 > 0) {
                int i19 = $10 + 113;
                $11 = i19 % 128;
                if (i19 % 2 == 0) {
                    char[] cArr5 = new char[i7];
                    System.arraycopy(cArr4, 1, cArr5, 1, i7);
                    System.arraycopy(cArr5, 1, cArr4, i7 << i9, i9);
                    System.arraycopy(cArr5, i9, cArr4, 1, i7 / i9);
                    i = 0;
                } else {
                    char[] cArr6 = new char[i7];
                    i = 0;
                    System.arraycopy(cArr4, 0, cArr6, 0, i7);
                    int i20 = i7 - i9;
                    System.arraycopy(cArr6, 0, cArr4, i20, i9);
                    System.arraycopy(cArr6, i9, cArr4, 0, i20);
                }
            } else {
                i = 0;
            }
            if (z) {
                char[] cArr7 = new char[i7];
                while (true) {
                    onpostmessage.a = i;
                    if (onpostmessage.a >= i7) {
                        break;
                    }
                    cArr7[onpostmessage.a] = cArr4[(i7 - onpostmessage.a) - 1];
                    i = onpostmessage.a + 1;
                }
                cArr4 = cArr7;
            }
            if (i8 > 0) {
                int i21 = 0;
                while (true) {
                    onpostmessage.a = i21;
                    if (onpostmessage.a >= i7) {
                        break;
                    }
                    cArr4[onpostmessage.a] = (char) (cArr4[onpostmessage.a] - iArr[2]);
                    i21 = onpostmessage.a + 1;
                }
            }
            objArr[0] = new String(cArr4);
        }

        private PieceIterator(ByteString byteString) {
            if (byteString instanceof RopeByteString) {
                RopeByteString ropeByteString = (RopeByteString) byteString;
                ArrayDeque<RopeByteString> arrayDeque = new ArrayDeque<>(ropeByteString.getTreeDepth());
                this.breadCrumbs = arrayDeque;
                arrayDeque.push(ropeByteString);
                this.next = getLeafByLeft(ropeByteString.left);
                return;
            }
            this.breadCrumbs = null;
            this.next = (ByteString.LeafByteString) byteString;
        }

        private ByteString.LeafByteString getLeafByLeft(ByteString byteString) {
            while (byteString instanceof RopeByteString) {
                RopeByteString ropeByteString = (RopeByteString) byteString;
                this.breadCrumbs.push(ropeByteString);
                byteString = ropeByteString.left;
            }
            return (ByteString.LeafByteString) byteString;
        }

        private ByteString.LeafByteString getNextNonEmptyLeaf() {
            ByteString.LeafByteString leafByLeft;
            do {
                ArrayDeque<RopeByteString> arrayDeque = this.breadCrumbs;
                if (arrayDeque == null || arrayDeque.isEmpty()) {
                    return null;
                }
                leafByLeft = getLeafByLeft(this.breadCrumbs.pop().right);
            } while (leafByLeft.isEmpty());
            return leafByLeft;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.next != null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public ByteString.LeafByteString next() {
            ByteString.LeafByteString leafByteString = this.next;
            if (leafByteString == null) {
                throw new NoSuchElementException();
            }
            this.next = getNextNonEmptyLeaf();
            return leafByteString;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        /* JADX WARN: Code duplicated, block: B:104:0x07a9 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:105:0x07ab A[Catch: Exception -> 0x0909, TRY_ENTER, TryCatch #2 {Exception -> 0x0909, blocks: (B:96:0x06c7, B:99:0x06f2, B:101:0x071b, B:105:0x07ab, B:108:0x07d4, B:112:0x080e, B:114:0x0819, B:126:0x08f5, B:127:0x08fb, B:131:0x0902, B:132:0x0908, B:100:0x06fc, B:109:0x07de), top: B:151:0x06c7, inners: #0, #1 }] */
        /* JADX WARN: Code duplicated, block: B:107:0x07d2  */
        /* JADX WARN: Code duplicated, block: B:108:0x07d4 A[Catch: Exception -> 0x0909, TRY_LEAVE, TryCatch #2 {Exception -> 0x0909, blocks: (B:96:0x06c7, B:99:0x06f2, B:101:0x071b, B:105:0x07ab, B:108:0x07d4, B:112:0x080e, B:114:0x0819, B:126:0x08f5, B:127:0x08fb, B:131:0x0902, B:132:0x0908, B:100:0x06fc, B:109:0x07de), top: B:151:0x06c7, inners: #0, #1 }] */
        /* JADX WARN: Code duplicated, block: B:112:0x080e A[Catch: Exception -> 0x0909, TRY_ENTER, TRY_LEAVE, TryCatch #2 {Exception -> 0x0909, blocks: (B:96:0x06c7, B:99:0x06f2, B:101:0x071b, B:105:0x07ab, B:108:0x07d4, B:112:0x080e, B:114:0x0819, B:126:0x08f5, B:127:0x08fb, B:131:0x0902, B:132:0x0908, B:100:0x06fc, B:109:0x07de), top: B:151:0x06c7, inners: #0, #1 }] */
        /* JADX WARN: Code duplicated, block: B:114:0x0819 A[Catch: Exception -> 0x0909, TRY_ENTER, TRY_LEAVE, TryCatch #2 {Exception -> 0x0909, blocks: (B:96:0x06c7, B:99:0x06f2, B:101:0x071b, B:105:0x07ab, B:108:0x07d4, B:112:0x080e, B:114:0x0819, B:126:0x08f5, B:127:0x08fb, B:131:0x0902, B:132:0x0908, B:100:0x06fc, B:109:0x07de), top: B:151:0x06c7, inners: #0, #1 }] */
        /* JADX WARN: Code duplicated, block: B:128:0x08fc  */
        /* JADX WARN: Code duplicated, block: B:32:0x011b  */
        /* JADX WARN: Code duplicated, block: B:34:0x0131 A[Catch: Exception -> 0x0261, TryCatch #7 {Exception -> 0x0261, blocks: (B:5:0x001f, B:9:0x0033, B:11:0x0068, B:14:0x007f, B:16:0x00a4, B:19:0x00b9, B:21:0x00c5, B:36:0x0182, B:29:0x00d8, B:33:0x0124, B:35:0x014e, B:34:0x0131, B:27:0x00cc, B:37:0x018d, B:40:0x01a6, B:43:0x01c1, B:47:0x0215, B:51:0x0259, B:41:0x01af, B:10:0x004d), top: B:159:0x001f }] */
        /* JADX WARN: Code duplicated, block: B:98:0x06f0  */
        /* JADX WARN: Code duplicated, block: B:99:0x06f2 A[Catch: Exception -> 0x0909, TRY_LEAVE, TryCatch #2 {Exception -> 0x0909, blocks: (B:96:0x06c7, B:99:0x06f2, B:101:0x071b, B:105:0x07ab, B:108:0x07d4, B:112:0x080e, B:114:0x0819, B:126:0x08f5, B:127:0x08fb, B:131:0x0902, B:132:0x0908, B:100:0x06fc, B:109:0x07de), top: B:151:0x06c7, inners: #0, #1 }] */
        public static Object[] coroutineCreation(int i, int i2) throws Throwable {
            Object[] objArr;
            int i3;
            int i4;
            char c;
            String line;
            File file;
            FileReader fileReader;
            BufferedReader bufferedReader;
            boolean zEquals;
            int i5;
            int i6;
            int i7;
            int i8;
            File file2;
            FileReader fileReader2;
            BufferedReader bufferedReader2;
            boolean zEquals2;
            int i9;
            char c2;
            char c3;
            char c4;
            int i10;
            int i11;
            Object[] objArr2;
            int i12;
            byte[] bArr;
            int[] iArr;
            boolean z;
            int i13;
            int i14;
            int i15;
            int i16;
            int i17;
            int i18;
            int i19 = 2 % 2;
            int i20 = artificialFrame;
            int i21 = (i20 ^ 29) + ((i20 & 29) << 1);
            getARTIFICIAL_FRAME_PACKAGE_NAME = i21 % 128;
            if (i21 % 2 != 0) {
                throw null;
            }
            try {
                String[] strArr = new String[2];
                byte[] bArr2 = {1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1};
                int i22 = i20 + 57;
                getARTIFICIAL_FRAME_PACKAGE_NAME = i22 % 128;
                if (i22 % 2 != 0) {
                    Object[] objArr3 = new Object[1];
                    b(bArr2, new int[]{0, 19, 14, 18}, true, objArr3);
                    strArr[0] = (String) objArr3[0];
                    bArr = new byte[]{1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1};
                    iArr = new int[]{19, 18, 0, 0};
                    z = true;
                } else {
                    Object[] objArr4 = new Object[1];
                    b(bArr2, new int[]{0, 19, 14, 18}, false, objArr4);
                    strArr[0] = (String) objArr4[0];
                    bArr = new byte[]{1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1};
                    iArr = new int[]{19, 18, 0, 0};
                    z = false;
                }
                Object[] objArr5 = new Object[1];
                b(bArr, iArr, z, objArr5);
                strArr[1] = (String) objArr5[0];
                int i23 = getARTIFICIAL_FRAME_PACKAGE_NAME + 49;
                artificialFrame = i23 % 128;
                int i24 = i23 % 2;
                int i25 = 0;
                while (true) {
                    if (i25 < 2) {
                        String str = strArr[i25];
                        Object[] objArr6 = new Object[1];
                        b(new byte[]{0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0}, new int[]{37, 16, 95, 0}, false, objArr6);
                        String str2 = (String) objArr6[0];
                        int i26 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                        int i27 = ((i26 | 121) << 1) - (i26 ^ 121);
                        artificialFrame = i27 % 128;
                        int i28 = i27 % 2;
                        Class<?> cls = Class.forName(str2);
                        java.lang.reflect.Method method = cls.getMethod(str, new Class[0]);
                        int i29 = getARTIFICIAL_FRAME_PACKAGE_NAME + 113;
                        artificialFrame = i29 % 128;
                        if (i29 % 2 == 0) {
                            boolean zBooleanValue = ((Boolean) method.invoke(cls, null)).booleanValue();
                            int i30 = 53 / 0;
                            if (zBooleanValue) {
                                int[] iArr2 = new int[1];
                                objArr = new Object[]{new int[]{i}, new int[]{i ^ 1}, iArr2, null};
                                int i31 = (((~((-285345797) | i)) | 606097434) * TypedValues.PositionType.TYPE_TRANSITION_EASING) + 1042164328;
                                i14 = ~i;
                                i15 = i31 + ((~((-285345797) | i14)) * TypedValues.PositionType.TYPE_TRANSITION_EASING);
                                int i32 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                i16 = ((i32 | 45) << 1) - (i32 ^ 45);
                                artificialFrame = i16 % 128;
                                if (i16 % 2 == 0) {
                                    int i33 = -i15;
                                    i17 = 1572 / ((i33 ^ 530) + ((i33 & 530) << 1));
                                    i18 = 529 >>> ((~((i14 ^ 16) | (i14 & 16))) | (~(i15 | 16)));
                                } else {
                                    int i34 = i15 * 530;
                                    i17 = ((9538 | i34) << 1) - (i34 ^ 9538);
                                    int i35 = ~((i14 ^ 16) | (i14 & 16));
                                    int i36 = ~((i15 ^ 16) | (i15 & 16));
                                    i18 = ((i35 ^ i36) | (i35 & i36)) * 529;
                                }
                                int i37 = -(-i18);
                                int i38 = (i17 & i37) + (i37 | i17);
                                int i39 = ~i15;
                                int i40 = ~((16 ^ i) | (16 & i));
                                int i41 = -(-(i38 + (((i39 & i40) | (i39 ^ i40)) * 529)));
                                int i42 = (i2 & i41) + (i41 | i2);
                                int i43 = i42 << 13;
                                int i44 = (i43 | i42) & (~(i42 & i43));
                                int i45 = i44 >>> 17;
                                int i46 = ((~i44) & i45) | ((~i45) & i44);
                                int i47 = i46 << 5;
                                iArr2[0] = ((~i46) & i47) | ((~i47) & i46);
                            } else {
                                i25 = ((i25 | 1) << 1) - (i25 ^ 1);
                            }
                        } else if (((Boolean) method.invoke(cls, null)).booleanValue()) {
                            int[] iArr3 = new int[1];
                            objArr = new Object[]{new int[]{i}, new int[]{i ^ 1}, iArr3, null};
                            int i310 = (((~((-285345797) | i)) | 606097434) * TypedValues.PositionType.TYPE_TRANSITION_EASING) + 1042164328;
                            i14 = ~i;
                            i15 = i310 + ((~((-285345797) | i14)) * TypedValues.PositionType.TYPE_TRANSITION_EASING);
                            int i311 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                            i16 = ((i311 | 45) << 1) - (i311 ^ 45);
                            artificialFrame = i16 % 128;
                            if (i16 % 2 == 0) {
                                int i312 = -i15;
                                i17 = 1572 / ((i312 ^ 530) + ((i312 & 530) << 1));
                                i18 = 529 >>> ((~((i14 ^ 16) | (i14 & 16))) | (~(i15 | 16)));
                            } else {
                                int i313 = i15 * 530;
                                i17 = ((9538 | i313) << 1) - (i313 ^ 9538);
                                int i314 = ~((i14 ^ 16) | (i14 & 16));
                                int i315 = ~((i15 ^ 16) | (i15 & 16));
                                i18 = ((i314 ^ i315) | (i314 & i315)) * 529;
                            }
                            int i316 = -(-i18);
                            int i317 = (i17 & i316) + (i316 | i17);
                            int i318 = ~i15;
                            int i48 = ~((16 ^ i) | (16 & i));
                            int i49 = -(-(i317 + (((i318 & i48) | (i318 ^ i48)) * 529)));
                            int i410 = (i2 & i49) + (i49 | i2);
                            int i411 = i410 << 13;
                            int i412 = (i411 | i410) & (~(i410 & i411));
                            int i413 = i412 >>> 17;
                            int i414 = ((~i412) & i413) | ((~i413) & i412);
                            int i415 = i414 << 5;
                            iArr3[0] = ((~i414) & i415) | ((~i415) & i414);
                        } else {
                            i25 = ((i25 | 1) << 1) - (i25 ^ 1);
                        }
                    } else {
                        objArr = new Object[4];
                        int[] iArr4 = new int[1];
                        objArr[0] = iArr4;
                        int[] iArr5 = new int[1];
                        objArr[1] = iArr5;
                        objArr[2] = new int[1];
                        int i50 = artificialFrame + 35;
                        int i51 = i50 % 128;
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i51;
                        if (i50 % 2 != 0) {
                            iArr4[0] = i;
                            iArr5[1] = i;
                        } else {
                            iArr4[0] = i;
                            iArr5[0] = i;
                        }
                        int i52 = (i51 & 115) + (i51 | 115);
                        artificialFrame = i52 % 128;
                        int i53 = i52 % 2;
                        objArr[3] = null;
                        int iNextInt = new Random().nextInt(750365666);
                        int i54 = 1804268702 + ((iNextInt | 798216047) * (-50));
                        int i55 = ~((-176213296) | iNextInt);
                        int i56 = ~iNextInt;
                        int i57 = i54 + ((i55 | (~((-4194433) | i56))) * 50) + (((~(i56 | 798216047)) | (~((-180407728) | i56)) | 4194432) * 50);
                        int i58 = i57 * (-743);
                        int i59 = artificialFrame;
                        int i60 = (i59 & 93) + (i59 | 93);
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i60 % 128;
                        if (i60 % 2 != 0) {
                            int i61 = ~i57;
                            int i62 = ~i;
                            i13 = i58 >>> ((-744) / (((i61 ^ i62) | (i61 & i62)) | (~(i57 | i))));
                        } else {
                            i13 = i58 + (((~i57) | (~i) | (~((i57 ^ i) | (i57 & i)))) * (-744));
                        }
                        int i63 = 744 * (~i);
                        int i64 = (i13 & i63) + (i13 | i63) + (((i57 ^ i) | (i57 & i)) * 744);
                        int i65 = ((i2 | i64) << 1) - (i64 ^ i2);
                        int i66 = (i59 ^ 75) + ((i59 & 75) << 1);
                        getARTIFICIAL_FRAME_PACKAGE_NAME = i66 % 128;
                        int i67 = i66 % 2;
                        int i68 = i65 << 13;
                        int i69 = (i65 | i68) & (~(i65 & i68));
                        int i70 = i69 >>> 17;
                        int i71 = (i69 | i70) & (~(i69 & i70));
                        int i72 = i71 << 5;
                        ((int[]) objArr[2])[0] = (i71 | i72) & (~(i71 & i72));
                    }
                    if (i == ((int[]) objArr[1])[0]) {
                        try {
                            Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(590025679);
                            if (objAccessartificialFrame == null) {
                                int defaultSize = View.getDefaultSize(0, 0) + 9;
                                char keyRepeatTimeout = (char) ((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 64610);
                                int mirror = AndroidCharacter.getMirror('0') + 1758;
                                byte b = (byte) 0;
                                byte b2 = b;
                                Object[] objArr7 = new Object[1];
                                a(b, b2, b2, objArr7);
                                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(defaultSize, keyRepeatTimeout, mirror, -1135716921, false, (String) objArr7[0], new Class[0]);
                            }
                            long jLongValue = ((Long) ((java.lang.reflect.Method) objAccessartificialFrame).invoke(null, null)).longValue();
                            long j = -1183003202;
                            long j2 = 130;
                            long j3 = -1;
                            long j4 = jLongValue ^ j3;
                            long j5 = i;
                            long j6 = (((long) (-129)) * j) + (((long) 131) * jLongValue) + ((((j4 | (j5 ^ j3)) | j) ^ j3) * j2);
                            long j7 = j4 | j;
                            long j8 = j6 + (((long) (-260)) * (j7 ^ j3)) + (j2 * ((((j ^ j3) | jLongValue) ^ j3) | ((j7 | j5) ^ j3))) + ((long) 1523211236);
                            int iNextInt2 = new Random().nextInt(1710879713);
                            int i73 = ~iNextInt2;
                            int i74 = ((int) (j8 >> 32)) & ((-1788177110) + ((4802564 | i73) * (-192)) + (((~((-1404078036) | i73)) | 28345811) * (-384)) + (((~(iNextInt2 | 1408880599)) | (~(i73 | (-1375732225))) | (~((-28345812) | iNextInt2))) * JfifUtil.MARKER_SOFn));
                            int startUptimeMillis = (int) Process.getStartUptimeMillis();
                            int i75 = ((int) j8) & (484646344 + (((~((-1440388210) | startUptimeMillis)) | 1415189600) * 345) + (((~((-1440388210) | (~startUptimeMillis))) | 2163076) * 345) + ((~(startUptimeMillis | (-1415189601))) * 345));
                            if (((i74 & i75) | (i74 ^ i75)) == 1) {
                                int i76 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                int i77 = i76 + 9;
                                artificialFrame = i77 % 128;
                                if (i77 % 2 == 0) {
                                    i11 = (i & (-55)) | ((~i) & 54);
                                    Object[] objArr8 = new Object[5];
                                    c4 = 0;
                                    objArr8[0] = new int[0];
                                    i10 = 1;
                                    objArr8[1] = new int[1];
                                    objArr2 = objArr8;
                                } else {
                                    c4 = 0;
                                    i10 = 1;
                                    i11 = i ^ 10;
                                    objArr2 = new Object[4];
                                    objArr2[0] = new int[1];
                                    objArr2[1] = new int[1];
                                }
                                objArr2[2] = new int[i10];
                                ((int[]) objArr2[c4])[c4] = i;
                                ((int[]) objArr2[i10])[c4] = i11;
                                int i78 = (i76 & 43) + (i76 | 43);
                                artificialFrame = i78 % 128;
                                if (i78 % 2 == 0) {
                                    objArr2[3] = null;
                                    i12 = ((((-1695882534) + (((~((~i) | (-725642768))) | 184561167) * 446)) + (((~((-541081601) | i)) | 68419840) * 446)) + 709901858) % 16;
                                } else {
                                    objArr2[3] = null;
                                    int iUptimeMillis = (int) SystemClock.uptimeMillis();
                                    int i79 = (~((-184487180) | iUptimeMillis)) | 173342723;
                                    i12 = 912536318 + (i79 * 992) + ((i79 | (~((~iUptimeMillis) | 805281051))) * (-496)) + ((iUptimeMillis | 794136595) * 496) + 16;
                                }
                                int i80 = i12 * 471;
                                int i81 = -(-(i2 * 471));
                                int i82 = (i80 & i81) + (i80 | i81);
                                int i83 = ((i12 ^ i2) | (i12 & i2)) * (-470);
                                int i84 = (i82 ^ i83) + ((i83 & i82) << 1);
                                int i85 = ~i12;
                                int i86 = ~i2;
                                int i87 = ~((i85 & i86) | (i85 ^ i86));
                                int i88 = ~i2;
                                int i89 = ~((i88 ^ i) | (i88 & i));
                                int i90 = (i87 & i89) | (i87 ^ i89);
                                int i91 = ~i;
                                int i92 = i84 + ((i90 | (~((i91 & i12) | (i91 ^ i12) | i2))) * (-470));
                                int i93 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                int i94 = (i93 ^ 55) + ((i93 & 55) << 1);
                                artificialFrame = i94 % 128;
                                int i95 = i94 % 2;
                                int i96 = (i88 ^ i12) | (i88 & i12);
                                int i97 = ~((i96 & i) | (i96 ^ i));
                                int i98 = ~i;
                                int i99 = (i12 & i98) | (i98 ^ i12);
                                int i100 = ~((i99 & i2) | (i99 ^ i2));
                                int i101 = (i92 - (~(470 * ((i100 & i97) | (i97 ^ i100))))) - 1;
                                int i102 = i101 << 13;
                                int i103 = (i102 | i101) & (~(i101 & i102));
                                int i104 = i103 >>> 17;
                                int i105 = ((~i103) & i104) | ((~i104) & i103);
                                int i106 = i105 << 5;
                                ((int[]) objArr2[2])[0] = ((~i105) & i106) | ((~i106) & i105);
                                c = 0;
                                objArr = objArr2;
                            } else {
                                int i107 = getARTIFICIAL_FRAME_PACKAGE_NAME + 105;
                                artificialFrame = i107 % 128;
                                int i108 = i107 % 2;
                                Object[] objArr9 = {new int[]{i}, new int[]{i}, new int[1], null};
                                int i109 = ~i;
                                int i110 = (-958088776) + (((~((-315212392) | i109)) | (~((-663411384) | i109))) * (-867)) + (((~((-315212392) | i)) | 42517031 | (~((-663411384) | i))) * (-1734)) + (((~(i109 | (-42517032))) | (~((-272695361) | i)) | (~((-620894353) | i))) * 867);
                                int iICustomTabsServiceStubProxy = ImmutableIntArray.Builder.ICustomTabsServiceStubProxy();
                                int i111 = (i110 * 273) + (i2 * (-271));
                                int i112 = ~i110;
                                int i113 = ~i2;
                                int i114 = (i113 & i112) | (i112 ^ i113) | (~iICustomTabsServiceStubProxy);
                                int i115 = artificialFrame;
                                int i116 = (i115 & 13) + (i115 | 13);
                                getARTIFICIAL_FRAME_PACKAGE_NAME = i116 % 128;
                                if (i116 % 2 != 0) {
                                    int i117 = ~i114;
                                    int i118 = ~((i110 ^ i2) | (i110 & i2) | iICustomTabsServiceStubProxy);
                                    i3 = i111 / ((-272) % ((i117 & i118) | (i117 ^ i118)));
                                    i112 = ~i110;
                                    i4 = (i112 ^ i2) | (i112 & i2);
                                } else {
                                    int i119 = (i110 ^ i2) | (i110 & i2);
                                    i3 = i111 + (((~i114) | (~((i119 & iICustomTabsServiceStubProxy) | (i119 ^ iICustomTabsServiceStubProxy)))) * (-272));
                                    int i120 = ~i110;
                                    i4 = (i120 & i2) | (i120 ^ i2);
                                }
                                int i121 = ~i4;
                                int i122 = ~((i112 & iICustomTabsServiceStubProxy) | (i112 ^ iICustomTabsServiceStubProxy));
                                int i123 = (-272) * ((i122 & i121) | (i121 ^ i122));
                                int i124 = ~((iICustomTabsServiceStubProxy & i110) | (i110 ^ iICustomTabsServiceStubProxy));
                                int i125 = ((((i3 | i123) << 1) - (i3 ^ i123)) - (~(-(-(((i124 & i2) | (i2 ^ i124)) * 272))))) - 1;
                                int i126 = i125 << 13;
                                int i127 = (i126 & (~i125)) | ((~i126) & i125);
                                int i128 = i127 >>> 17;
                                int i129 = (i127 | i128) & (~(i127 & i128));
                                int i130 = i129 << 5;
                                int i131 = ((~i129) & i130) | ((~i130) & i129);
                                c = 0;
                                ((int[]) objArr9[2])[0] = i131;
                                objArr = objArr9;
                            }
                            if (i != ((int[]) objArr[1])[c]) {
                                int i132 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                                int i133 = ((i132 | 7) << 1) - (i132 ^ 7);
                                artificialFrame = i133 % 128;
                                int i134 = i133 % 2;
                            } else {
                                try {
                                    Object[] objArr10 = new Object[1];
                                    b(new byte[]{1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 1, 1, 0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0}, new int[]{53, 40, 0, 35}, false, objArr10);
                                    File file3 = new File((String) objArr10[0]);
                                    int i135 = getARTIFICIAL_FRAME_PACKAGE_NAME + 9;
                                    artificialFrame = i135 % 128;
                                    int i136 = i135 % 2;
                                    try {
                                        if (file3.canRead()) {
                                            FileReader fileReader3 = new FileReader(file3);
                                            BufferedReader bufferedReader3 = new BufferedReader(fileReader3);
                                            try {
                                                line = bufferedReader3.readLine();
                                                Object[] objArr11 = new Object[1];
                                                b(new byte[]{0, 0, 1}, new int[]{93, 3, 0, 1}, false, objArr11);
                                                if (line.equals((String) objArr11[0])) {
                                                    fileReader3.close();
                                                    bufferedReader3.close();
                                                } else {
                                                    int i137 = artificialFrame + 75;
                                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i137 % 128;
                                                    int i138 = i137 % 2;
                                                    fileReader3.close();
                                                    bufferedReader3.close();
                                                }
                                                Object[] objArr12 = new Object[1];
                                                b(new byte[]{0, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1}, new int[]{96, 31, 104, 18}, false, objArr12);
                                                file = new File((String) objArr12[0]);
                                                if (!file.canRead()) {
                                                    fileReader = new FileReader(file);
                                                    bufferedReader = new BufferedReader(fileReader);
                                                    try {
                                                        String line2 = bufferedReader.readLine();
                                                        Object[] objArr13 = new Object[1];
                                                        b(new byte[]{1}, new int[]{127, 1, 24, 1}, false, objArr13);
                                                        zEquals = line2.equals((String) objArr13[0]);
                                                        fileReader.close();
                                                        bufferedReader.close();
                                                        int iICustomTabsServiceStubProxy2 = ImmutableIntArray.Builder.ICustomTabsServiceStubProxy();
                                                        int i139 = ~((164802194 & iICustomTabsServiceStubProxy2) | (164802194 ^ iICustomTabsServiceStubProxy2));
                                                        int i140 = ((i139 & (-1004449720)) | ((-1004449720) ^ i139)) * (-283);
                                                        i5 = (((((-46252298) & i140) + (i140 | (-46252298))) - (-81722806)) - (~(-(-((~((iICustomTabsServiceStubProxy2 & (-839647526)) | ((-839647526) ^ iICustomTabsServiceStubProxy2))) * 283))))) - 1;
                                                        int i141 = ~i;
                                                        int i142 = ~((-1447313414) | i141);
                                                        int i143 = ~((2139029239 & i) | (2139029239 ^ i));
                                                        int i144 = (i142 & i143) | (i142 ^ i143);
                                                        int i145 = ~(((-688962163) & i) | ((-688962163) ^ i));
                                                        int i146 = -(-(((i144 & i145) | (i144 ^ i145)) * 765));
                                                        int i147 = ((1044577847 | i146) << 1) - (i146 ^ 1044577847);
                                                        int i148 = ((~((i141 & 691715826) | (691715826 ^ i141))) | 1447313413) * 1530;
                                                        i6 = ((i147 | i148) << 1) - (i148 ^ i147);
                                                        i7 = ~(691715826 | i);
                                                        int i149 = ~i;
                                                        i8 = ~((i149 & (-2136275576)) | ((-2136275576) ^ i149) | (-691715827));
                                                        if (i5 <= i6 + (((i7 & i8) | (i7 ^ i8)) * 765)) {
                                                            Object obj = null;
                                                            obj.hashCode();
                                                            throw null;
                                                        }
                                                        if (zEquals) {
                                                            Object[] objArr14 = new Object[1];
                                                            b(new byte[]{1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0}, new int[]{128, 36, 0, 33}, false, objArr14);
                                                            file2 = new File((String) objArr14[0]);
                                                            if (!file2.canRead()) {
                                                                fileReader2 = new FileReader(file2);
                                                                bufferedReader2 = new BufferedReader(fileReader2);
                                                                try {
                                                                    String line3 = bufferedReader2.readLine();
                                                                    Object[] objArr15 = new Object[1];
                                                                    b(new byte[]{1}, new int[]{127, 1, 24, 1}, false, objArr15);
                                                                    zEquals2 = line3.equals((String) objArr15[0]);
                                                                    int i150 = artificialFrame;
                                                                    i9 = ((i150 | 97) << 1) - (i150 ^ 97);
                                                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i9 % 128;
                                                                    if (i9 % 2 != 0) {
                                                                        fileReader2.close();
                                                                        bufferedReader2.close();
                                                                        int i151 = 38 / 0;
                                                                    } else {
                                                                        fileReader2.close();
                                                                        bufferedReader2.close();
                                                                    }
                                                                    if (!zEquals2 && line != null) {
                                                                        int i152 = (~(i & 20)) & (i | 20);
                                                                        int i153 = artificialFrame;
                                                                        int i154 = ((i153 | 117) << 1) - (i153 ^ 117);
                                                                        getARTIFICIAL_FRAME_PACKAGE_NAME = i154 % 128;
                                                                        if (i154 % 2 != 0) {
                                                                            Object[] objArr16 = new Object[3];
                                                                            objArr16[1] = new int[1];
                                                                            c2 = 0;
                                                                            objArr16[0] = new int[0];
                                                                            objArr = objArr16;
                                                                            c3 = 5;
                                                                        } else {
                                                                            c2 = 0;
                                                                            Object[] objArr17 = new Object[4];
                                                                            objArr17[0] = new int[1];
                                                                            objArr17[1] = new int[1];
                                                                            objArr = objArr17;
                                                                            c3 = 2;
                                                                        }
                                                                        objArr[c3] = new int[1];
                                                                        int[] iArr6 = (int[]) objArr[c2];
                                                                        int i155 = i153 + 83;
                                                                        int i156 = i155 % 128;
                                                                        getARTIFICIAL_FRAME_PACKAGE_NAME = i156;
                                                                        int i157 = i155 % 2;
                                                                        iArr6[c2] = i;
                                                                        ((int[]) objArr[1])[c2] = i152;
                                                                        objArr[3] = line;
                                                                        int i158 = ~i;
                                                                        int i159 = (-1508821074) + (((~((-146918417) | i158)) | 8437760 | (~((-831705359) | i158))) * (-1136)) + (((~((-146918417) | i)) | (~((-831705359) | i)) | (~(970186014 | i158))) * (-568)) + (((~(i158 | 831705358)) | (~(146918416 | i158)) | (~(i | (-8437761)))) * 568);
                                                                        int i160 = (i159 ^ 16) + ((16 & i159) << 1);
                                                                        int i161 = (i2 ^ i160) + ((i160 & i2) << 1);
                                                                        int i162 = i161 << 13;
                                                                        int i163 = (i162 & (~i161)) | ((~i162) & i161);
                                                                        int i164 = i163 >>> 17;
                                                                        int i165 = ((~i163) & i164) | ((~i164) & i163);
                                                                        int i166 = i156 + 21;
                                                                        artificialFrame = i166 % 128;
                                                                        if (i166 % 2 == 0) {
                                                                            int i167 = i165 - 2;
                                                                            ((int[]) objArr[5])[0] = (i165 | i167) & (~(i165 & i167));
                                                                        } else {
                                                                            int i168 = i165 << 5;
                                                                            ((int[]) objArr[2])[0] = ((~i165) & i168) | ((~i168) & i165);
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
                                                objArr = new Object[]{new int[]{i}, new int[]{i}, new int[1], null};
                                                int iUptimeMillis2 = (int) SystemClock.uptimeMillis();
                                                int i169 = ((1417061850 + (((-445160993) | (~iUptimeMillis2)) * (-490))) + (((~(iUptimeMillis2 | (-449420925))) | 4259932) * 490)) - 1611359230;
                                                int iICustomTabsServiceStubProxy3 = ImmutableIntArray.Builder.ICustomTabsServiceStubProxy();
                                                int i170 = ~(((-1) ^ i169) | i169);
                                                int i171 = ~iICustomTabsServiceStubProxy3;
                                                int i172 = ~(i171 | i169);
                                                int i173 = ((-(-(i169 * 185))) - (~(-(-(((i170 & i172) | (i170 ^ i172)) * SyslogConstants.LOG_LOCAL7))))) - 1;
                                                int i174 = ~(~i169);
                                                int i175 = ((iICustomTabsServiceStubProxy3 & i174) | (iICustomTabsServiceStubProxy3 ^ i174)) * (-184);
                                                int i176 = ((i173 | i175) << 1) - (i175 ^ i173);
                                                int i177 = (~(((-1) ^ i171) | i171)) * SyslogConstants.LOG_LOCAL7;
                                                int i178 = ((i176 | i177) << 1) - (i177 ^ i176);
                                                int iICustomTabsServiceStubProxy4 = ImmutableIntArray.Builder.ICustomTabsServiceStubProxy();
                                                int i179 = i178 * 193;
                                                int i180 = -(-(i2 * 193));
                                                int i181 = (i179 ^ i180) + ((i179 & i180) << 1);
                                                int i182 = ~iICustomTabsServiceStubProxy4;
                                                int i183 = ~i178;
                                                int i184 = ~((i183 ^ i2) | (i183 & i2));
                                                int i185 = -(-(((i182 & i184) | (i182 ^ i184)) * (-192)));
                                                int i186 = (i181 ^ i185) + ((i185 & i181) << 1);
                                                int i187 = ~i178;
                                                int i188 = ~i2;
                                                int i189 = ~((i187 & i188) | (i187 ^ i188));
                                                int i190 = ~i2;
                                                int i191 = ~iICustomTabsServiceStubProxy4;
                                                int i192 = (i189 | (~(i190 | i191))) * (-384);
                                                int i193 = ((i186 | i192) << 1) - (i192 ^ i186);
                                                int i194 = (i183 ^ i190) | (i183 & i190);
                                                int i195 = (i188 ^ i191) | (i188 & i191);
                                                int i196 = (~((i194 & iICustomTabsServiceStubProxy4) | (i194 ^ iICustomTabsServiceStubProxy4))) | (~((i195 & i178) | (i195 ^ i178)));
                                                int i197 = (i178 & i2) | (i178 ^ i2);
                                                int i198 = (i193 - (~(((~((iICustomTabsServiceStubProxy4 & i197) | (i197 ^ iICustomTabsServiceStubProxy4))) | i196) * JfifUtil.MARKER_SOFn))) - 1;
                                                int i199 = i198 << 13;
                                                int i200 = (i199 & (~i198)) | ((~i199) & i198);
                                                int i201 = i200 >>> 17;
                                                int i202 = (i200 | i201) & (~(i200 & i201));
                                                int i203 = i202 << 5;
                                                ((int[]) objArr[2])[0] = ((~i202) & i203) | ((~i203) & i202);
                                            } catch (Throwable th3) {
                                                fileReader3.close();
                                                bufferedReader3.close();
                                                throw th3;
                                            }
                                        } else {
                                            int i204 = getARTIFICIAL_FRAME_PACKAGE_NAME + 1;
                                            artificialFrame = i204 % 128;
                                            int i205 = i204 % 2;
                                        }
                                        Object[] objArr18 = new Object[1];
                                        b(new byte[]{0, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1}, new int[]{96, 31, 104, 18}, false, objArr18);
                                        file = new File((String) objArr18[0]);
                                        if (!file.canRead()) {
                                            fileReader = new FileReader(file);
                                            bufferedReader = new BufferedReader(fileReader);
                                            String line4 = bufferedReader.readLine();
                                            Object[] objArr19 = new Object[1];
                                            b(new byte[]{1}, new int[]{127, 1, 24, 1}, false, objArr19);
                                            zEquals = line4.equals((String) objArr19[0]);
                                            fileReader.close();
                                            bufferedReader.close();
                                            int iICustomTabsServiceStubProxy5 = ImmutableIntArray.Builder.ICustomTabsServiceStubProxy();
                                            int i1310 = ~((164802194 & iICustomTabsServiceStubProxy5) | (164802194 ^ iICustomTabsServiceStubProxy5));
                                            int i1410 = ((i1310 & (-1004449720)) | ((-1004449720) ^ i1310)) * (-283);
                                            i5 = (((((-46252298) & i1410) + (i1410 | (-46252298))) - (-81722806)) - (~(-(-((~((iICustomTabsServiceStubProxy5 & (-839647526)) | ((-839647526) ^ iICustomTabsServiceStubProxy5))) * 283))))) - 1;
                                            int i1411 = ~i;
                                            int i1412 = ~((-1447313414) | i1411);
                                            int i1413 = ~((2139029239 & i) | (2139029239 ^ i));
                                            int i1414 = (i1412 & i1413) | (i1412 ^ i1413);
                                            int i1415 = ~(((-688962163) & i) | ((-688962163) ^ i));
                                            int i1416 = -(-(((i1414 & i1415) | (i1414 ^ i1415)) * 765));
                                            int i1417 = ((1044577847 | i1416) << 1) - (i1416 ^ 1044577847);
                                            int i1418 = ((~((i1411 & 691715826) | (691715826 ^ i1411))) | 1447313413) * 1530;
                                            i6 = ((i1417 | i1418) << 1) - (i1418 ^ i1417);
                                            i7 = ~(691715826 | i);
                                            int i1419 = ~i;
                                            i8 = ~((i1419 & (-2136275576)) | ((-2136275576) ^ i1419) | (-691715827));
                                            if (i5 <= i6 + (((i7 & i8) | (i7 ^ i8)) * 765)) {
                                                Object obj2 = null;
                                                obj2.hashCode();
                                                throw null;
                                            }
                                            if (zEquals) {
                                                Object[] objArr110 = new Object[1];
                                                b(new byte[]{1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0}, new int[]{128, 36, 0, 33}, false, objArr110);
                                                file2 = new File((String) objArr110[0]);
                                                if (!file2.canRead()) {
                                                    fileReader2 = new FileReader(file2);
                                                    bufferedReader2 = new BufferedReader(fileReader2);
                                                    String line5 = bufferedReader2.readLine();
                                                    Object[] objArr111 = new Object[1];
                                                    b(new byte[]{1}, new int[]{127, 1, 24, 1}, false, objArr111);
                                                    zEquals2 = line5.equals((String) objArr111[0]);
                                                    int i1510 = artificialFrame;
                                                    i9 = ((i1510 | 97) << 1) - (i1510 ^ 97);
                                                    getARTIFICIAL_FRAME_PACKAGE_NAME = i9 % 128;
                                                    if (i9 % 2 != 0) {
                                                        fileReader2.close();
                                                        bufferedReader2.close();
                                                        int i1511 = 38 / 0;
                                                    } else {
                                                        fileReader2.close();
                                                        bufferedReader2.close();
                                                    }
                                                    if (!zEquals2) {
                                                    }
                                                }
                                            }
                                        }
                                    } catch (Exception unused) {
                                    }
                                } catch (Exception unused2) {
                                }
                                line = null;
                                objArr = new Object[]{new int[]{i}, new int[]{i}, new int[1], null};
                                int iUptimeMillis3 = (int) SystemClock.uptimeMillis();
                                int i1610 = ((1417061850 + (((-445160993) | (~iUptimeMillis3)) * (-490))) + (((~(iUptimeMillis3 | (-449420925))) | 4259932) * 490)) - 1611359230;
                                int iICustomTabsServiceStubProxy6 = ImmutableIntArray.Builder.ICustomTabsServiceStubProxy();
                                int i1710 = ~(((-1) ^ i1610) | i1610);
                                int i1711 = ~iICustomTabsServiceStubProxy6;
                                int i1712 = ~(i1711 | i1610);
                                int i1713 = ((-(-(i1610 * 185))) - (~(-(-(((i1710 & i1712) | (i1710 ^ i1712)) * SyslogConstants.LOG_LOCAL7))))) - 1;
                                int i1714 = ~(~i1610);
                                int i1715 = ((iICustomTabsServiceStubProxy6 & i1714) | (iICustomTabsServiceStubProxy6 ^ i1714)) * (-184);
                                int i1716 = ((i1713 | i1715) << 1) - (i1715 ^ i1713);
                                int i1717 = (~(((-1) ^ i1711) | i1711)) * SyslogConstants.LOG_LOCAL7;
                                int i1718 = ((i1716 | i1717) << 1) - (i1717 ^ i1716);
                                int iICustomTabsServiceStubProxy7 = ImmutableIntArray.Builder.ICustomTabsServiceStubProxy();
                                int i1719 = i1718 * 193;
                                int i1810 = -(-(i2 * 193));
                                int i1811 = (i1719 ^ i1810) + ((i1719 & i1810) << 1);
                                int i1812 = ~iICustomTabsServiceStubProxy7;
                                int i1813 = ~i1718;
                                int i1814 = ~((i1813 ^ i2) | (i1813 & i2));
                                int i1815 = -(-(((i1812 & i1814) | (i1812 ^ i1814)) * (-192)));
                                int i1816 = (i1811 ^ i1815) + ((i1815 & i1811) << 1);
                                int i1817 = ~i1718;
                                int i1818 = ~i2;
                                int i1819 = ~((i1817 & i1818) | (i1817 ^ i1818));
                                int i1910 = ~i2;
                                int i1911 = ~iICustomTabsServiceStubProxy7;
                                int i1912 = (i1819 | (~(i1910 | i1911))) * (-384);
                                int i1913 = ((i1816 | i1912) << 1) - (i1912 ^ i1816);
                                int i1914 = (i1813 ^ i1910) | (i1813 & i1910);
                                int i1915 = (i1818 ^ i1911) | (i1818 & i1911);
                                int i1916 = (~((i1914 & iICustomTabsServiceStubProxy7) | (i1914 ^ iICustomTabsServiceStubProxy7))) | (~((i1915 & i1718) | (i1915 ^ i1718)));
                                int i1917 = (i1718 & i2) | (i1718 ^ i2);
                                int i1918 = (i1913 - (~(((~((iICustomTabsServiceStubProxy7 & i1917) | (i1917 ^ iICustomTabsServiceStubProxy7))) | i1916) * JfifUtil.MARKER_SOFn))) - 1;
                                int i1919 = i1918 << 13;
                                int i206 = (i1919 & (~i1918)) | ((~i1919) & i1918);
                                int i207 = i206 >>> 17;
                                int i208 = (i206 | i207) & (~(i206 & i207));
                                int i209 = i208 << 5;
                                ((int[]) objArr[2])[0] = ((~i208) & i209) | ((~i209) & i208);
                            }
                        } catch (Throwable th4) {
                            Throwable cause = th4.getCause();
                            if (cause != null) {
                                throw cause;
                            }
                            throw th4;
                        }
                    }
                    int i210 = getARTIFICIAL_FRAME_PACKAGE_NAME;
                    int i211 = (i210 & 21) + (i210 | 21);
                    artificialFrame = i211 % 128;
                    if (i211 % 2 == 0) {
                        int i212 = 51 / 0;
                    }
                    return objArr;
                }
            } catch (Exception unused3) {
                objArr = new Object[]{new int[]{i}, new int[]{(~(i & 2)) & (i | 2)}, new int[1], null};
                int iMaxMemory = (int) Runtime.getRuntime().maxMemory();
                int i213 = ~iMaxMemory;
                int i214 = 1834823886 + (((~(277190921 | i213)) | 701432853) * (-328)) + ((iMaxMemory | 701432853) * 164) + (((~(iMaxMemory | (-277190922))) | 8716289 | (~(i213 | 969907485))) * 164);
                int i215 = (i214 ^ 16) + ((i214 & 16) << 1);
                int i216 = ~i;
                int i217 = (i215 * 758) + (i2 * (-756)) + (((i216 & i215) | (i215 ^ i216)) * (-757));
                int i218 = ~i2;
                int i219 = (i218 ^ i215) | (i218 & i215);
                int i220 = -(-((~((i219 & i) | (i219 ^ i))) * 1514));
                int i221 = (i217 ^ i220) + ((i217 & i220) << 1);
                int i222 = ~i215;
                int i223 = ~((i222 & i218) | (i222 ^ i218));
                int i224 = ~i;
                int i225 = ~((i218 & i224) | (i218 ^ i224));
                int i226 = (i215 & i2) | (i215 ^ i2);
                int i227 = ((~((i226 & i) | (i226 ^ i))) | (i223 & i225) | (i223 ^ i225)) * 757;
                int i228 = (i221 & i227) + (i227 | i221);
                int i229 = i228 << 13;
                int i230 = (i229 | i228) & (~(i228 & i229));
                int i231 = i230 >>> 17;
                int i232 = (i230 | i231) & (~(i230 & i231));
                int i233 = i232 << 5;
                ((int[]) objArr[2])[0] = (i232 | i233) & (~(i232 & i233));
            }
        }
    }

    private static ByteString concatenateBytes(ByteString byteString, ByteString byteString2) {
        int size = byteString.size();
        int size2 = byteString2.size();
        byte[] bArr = new byte[size + size2];
        byteString.copyTo(bArr, 0, 0, size);
        byteString2.copyTo(bArr, 0, size, size2);
        return ByteString.wrap(bArr);
    }

    static RopeByteString newInstanceForTest(ByteString byteString, ByteString byteString2) {
        return new RopeByteString(byteString, byteString2);
    }

    static int minLength(int i) {
        int[] iArr = minLengthByDepth;
        if (i >= iArr.length) {
            return Integer.MAX_VALUE;
        }
        return iArr[i];
    }

    @Override // com.google.protobuf.ByteString
    public byte byteAt(int i) {
        ByteString.checkIndex(i, this.totalLength);
        return internalByteAt(i);
    }

    @Override // com.google.protobuf.ByteString
    byte internalByteAt(int i) {
        int i2 = this.leftLength;
        if (i < i2) {
            return this.left.internalByteAt(i);
        }
        return this.right.internalByteAt(i - i2);
    }

    @Override // com.google.protobuf.ByteString
    public int size() {
        return this.totalLength;
    }

    @Override // com.google.protobuf.ByteString, java.lang.Iterable
    /* JADX INFO: renamed from: iterator */
    public Iterator<Byte> iterator2() {
        return new ByteString.AbstractByteIterator() { // from class: com.google.protobuf.RopeByteString.1
            ByteString.ByteIterator current = nextPiece();
            final PieceIterator pieces;

            {
                this.pieces = new PieceIterator(RopeByteString.this);
            }

            /* JADX WARN: Type inference failed for: r0v5, types: [com.google.protobuf.ByteString$ByteIterator] */
            private ByteString.ByteIterator nextPiece() {
                if (this.pieces.hasNext()) {
                    return this.pieces.next().iterator2();
                }
                return null;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.current != null;
            }

            @Override // com.google.protobuf.ByteString.ByteIterator
            public byte nextByte() {
                ByteString.ByteIterator byteIterator = this.current;
                if (byteIterator == null) {
                    throw new NoSuchElementException();
                }
                byte bNextByte = byteIterator.nextByte();
                if (!this.current.hasNext()) {
                    this.current = nextPiece();
                }
                return bNextByte;
            }
        };
    }

    @Override // com.google.protobuf.ByteString
    protected int getTreeDepth() {
        return this.treeDepth;
    }

    @Override // com.google.protobuf.ByteString
    protected boolean isBalanced() {
        return this.totalLength >= minLength(this.treeDepth);
    }

    @Override // com.google.protobuf.ByteString
    public ByteString substring(int i, int i2) {
        int iCheckRange = ByteString.checkRange(i, i2, this.totalLength);
        if (iCheckRange == 0) {
            return ByteString.EMPTY;
        }
        if (iCheckRange == this.totalLength) {
            return this;
        }
        int i3 = this.leftLength;
        if (i2 <= i3) {
            return this.left.substring(i, i2);
        }
        if (i >= i3) {
            return this.right.substring(i - i3, i2 - i3);
        }
        return new RopeByteString(this.left.substring(i), this.right.substring(0, i2 - this.leftLength));
    }

    @Override // com.google.protobuf.ByteString
    protected void copyToInternal(byte[] bArr, int i, int i2, int i3) {
        int i4 = this.leftLength;
        if (i + i3 <= i4) {
            this.left.copyToInternal(bArr, i, i2, i3);
        } else {
            if (i >= i4) {
                this.right.copyToInternal(bArr, i - i4, i2, i3);
                return;
            }
            int i5 = i4 - i;
            this.left.copyToInternal(bArr, i, i2, i5);
            this.right.copyToInternal(bArr, 0, i2 + i5, i3 - i5);
        }
    }

    @Override // com.google.protobuf.ByteString
    public void copyTo(ByteBuffer byteBuffer) {
        this.left.copyTo(byteBuffer);
        this.right.copyTo(byteBuffer);
    }

    @Override // com.google.protobuf.ByteString
    public ByteBuffer asReadOnlyByteBuffer() {
        return ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
    }

    @Override // com.google.protobuf.ByteString
    public List<ByteBuffer> asReadOnlyByteBufferList() {
        ArrayList arrayList = new ArrayList();
        PieceIterator pieceIterator = new PieceIterator(this);
        while (pieceIterator.hasNext()) {
            arrayList.add(pieceIterator.next().asReadOnlyByteBuffer());
        }
        return arrayList;
    }

    @Override // com.google.protobuf.ByteString
    public void writeTo(OutputStream outputStream) throws IOException {
        this.left.writeTo(outputStream);
        this.right.writeTo(outputStream);
    }

    @Override // com.google.protobuf.ByteString
    void writeToInternal(OutputStream outputStream, int i, int i2) throws IOException {
        int i3 = this.leftLength;
        if (i + i2 <= i3) {
            this.left.writeToInternal(outputStream, i, i2);
        } else {
            if (i >= i3) {
                this.right.writeToInternal(outputStream, i - i3, i2);
                return;
            }
            int i4 = i3 - i;
            this.left.writeToInternal(outputStream, i, i4);
            this.right.writeToInternal(outputStream, 0, i2 - i4);
        }
    }

    @Override // com.google.protobuf.ByteString
    void writeTo(ByteOutput byteOutput) throws IOException {
        this.left.writeTo(byteOutput);
        this.right.writeTo(byteOutput);
    }

    @Override // com.google.protobuf.ByteString
    void writeToReverse(ByteOutput byteOutput) throws IOException {
        this.right.writeToReverse(byteOutput);
        this.left.writeToReverse(byteOutput);
    }

    @Override // com.google.protobuf.ByteString
    protected String toStringInternal(Charset charset) {
        return new String(toByteArray(), charset);
    }

    @Override // com.google.protobuf.ByteString
    public boolean isValidUtf8() {
        int iPartialIsValidUtf8 = this.left.partialIsValidUtf8(0, 0, this.leftLength);
        ByteString byteString = this.right;
        return byteString.partialIsValidUtf8(iPartialIsValidUtf8, 0, byteString.size()) == 0;
    }

    @Override // com.google.protobuf.ByteString
    protected int partialIsValidUtf8(int i, int i2, int i3) {
        int i4 = this.leftLength;
        if (i2 + i3 <= i4) {
            return this.left.partialIsValidUtf8(i, i2, i3);
        }
        if (i2 >= i4) {
            return this.right.partialIsValidUtf8(i, i2 - i4, i3);
        }
        int i5 = i4 - i2;
        return this.right.partialIsValidUtf8(this.left.partialIsValidUtf8(i, i2, i5), 0, i3 - i5);
    }

    @Override // com.google.protobuf.ByteString
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ByteString)) {
            return false;
        }
        ByteString byteString = (ByteString) obj;
        if (this.totalLength != byteString.size()) {
            return false;
        }
        if (this.totalLength == 0) {
            return true;
        }
        int iPeekCachedHashCode = peekCachedHashCode();
        int iPeekCachedHashCode2 = byteString.peekCachedHashCode();
        if (iPeekCachedHashCode == 0 || iPeekCachedHashCode2 == 0 || iPeekCachedHashCode == iPeekCachedHashCode2) {
            return equalsFragments(byteString);
        }
        return false;
    }

    private boolean equalsFragments(ByteString byteString) {
        boolean zEqualsRange;
        ByteString.LeafByteString next;
        PieceIterator pieceIterator = new PieceIterator(this);
        ByteString.LeafByteString next2 = pieceIterator.next();
        PieceIterator pieceIterator2 = new PieceIterator(byteString);
        ByteString.LeafByteString next3 = pieceIterator2.next();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int size = next2.size() - i;
            int size2 = next3.size() - i2;
            int iMin = Math.min(size, size2);
            if (i == 0) {
                zEqualsRange = next2.equalsRange(next3, i2, iMin);
            } else {
                zEqualsRange = next3.equalsRange(next2, i, iMin);
            }
            if (!zEqualsRange) {
                return false;
            }
            i3 += iMin;
            int i4 = this.totalLength;
            if (i3 >= i4) {
                if (i3 == i4) {
                    return true;
                }
                throw new IllegalStateException();
            }
            if (iMin == size) {
                next = pieceIterator.next();
                i = 0;
            } else {
                i += iMin;
            }
            if (iMin == size2) {
                next2 = next2;
                next2 = next;
                next3 = pieceIterator2.next();
                i2 = 0;
            } else {
                next2 = next2;
                next2 = next;
                i2 += iMin;
            }
        }
    }

    @Override // com.google.protobuf.ByteString
    protected int partialHash(int i, int i2, int i3) {
        int i4 = this.leftLength;
        if (i2 + i3 <= i4) {
            return this.left.partialHash(i, i2, i3);
        }
        if (i2 >= i4) {
            return this.right.partialHash(i, i2 - i4, i3);
        }
        int i5 = i4 - i2;
        return this.right.partialHash(this.left.partialHash(i, i2, i5), 0, i3 - i5);
    }

    @Override // com.google.protobuf.ByteString
    public CodedInputStream newCodedInput() {
        return CodedInputStream.newInstance((Iterable<ByteBuffer>) asReadOnlyByteBufferList(), true);
    }

    @Override // com.google.protobuf.ByteString
    public InputStream newInput() {
        return new RopeInputStream();
    }

    static class Balancer {
        private final ArrayDeque<ByteString> prefixesStack;

        private Balancer() {
            this.prefixesStack = new ArrayDeque<>();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ByteString balance(ByteString byteString, ByteString byteString2) {
            doBalance(byteString);
            doBalance(byteString2);
            ByteString byteStringPop = this.prefixesStack.pop();
            while (!this.prefixesStack.isEmpty()) {
                byteStringPop = new RopeByteString(this.prefixesStack.pop(), byteStringPop);
            }
            return byteStringPop;
        }

        private void doBalance(ByteString byteString) {
            if (byteString.isBalanced()) {
                insert(byteString);
                return;
            }
            if (byteString instanceof RopeByteString) {
                RopeByteString ropeByteString = (RopeByteString) byteString;
                doBalance(ropeByteString.left);
                doBalance(ropeByteString.right);
            } else {
                throw new IllegalArgumentException("Has a new type of ByteString been created? Found " + byteString.getClass());
            }
        }

        private void insert(ByteString byteString) {
            int depthBinForLength = getDepthBinForLength(byteString.size());
            int iMinLength = RopeByteString.minLength(depthBinForLength + 1);
            if (this.prefixesStack.isEmpty() || this.prefixesStack.peek().size() >= iMinLength) {
                this.prefixesStack.push(byteString);
                return;
            }
            int iMinLength2 = RopeByteString.minLength(depthBinForLength);
            ByteString byteStringPop = this.prefixesStack.pop();
            while (true) {
                if (this.prefixesStack.isEmpty() || this.prefixesStack.peek().size() >= iMinLength2) {
                    break;
                } else {
                    byteStringPop = new RopeByteString(this.prefixesStack.pop(), byteStringPop);
                }
            }
            RopeByteString ropeByteString = new RopeByteString(byteStringPop, byteString);
            while (!this.prefixesStack.isEmpty()) {
                if (this.prefixesStack.peek().size() >= RopeByteString.minLength(getDepthBinForLength(ropeByteString.size()) + 1)) {
                    break;
                } else {
                    ropeByteString = new RopeByteString(this.prefixesStack.pop(), ropeByteString);
                }
            }
            this.prefixesStack.push(ropeByteString);
        }

        private int getDepthBinForLength(int i) {
            int iBinarySearch = Arrays.binarySearch(RopeByteString.minLengthByDepth, i);
            return iBinarySearch < 0 ? (-(iBinarySearch + 1)) - 1 : iBinarySearch;
        }
    }

    Object writeReplace() {
        return ByteString.wrap(toByteArray());
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("RopeByteStream instances are not to be serialized directly");
    }

    class RopeInputStream extends InputStream {
        private ByteString.LeafByteString currentPiece;
        private int currentPieceIndex;
        private int currentPieceOffsetInRope;
        private int currentPieceSize;
        private int mark;
        private PieceIterator pieceIterator;

        @Override // java.io.InputStream
        public boolean markSupported() {
            return true;
        }

        public RopeInputStream() {
            initialize();
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            bArr.getClass();
            if (i < 0 || i2 < 0 || i2 > bArr.length - i) {
                throw new IndexOutOfBoundsException();
            }
            int skipInternal = readSkipInternal(bArr, i, i2);
            if (skipInternal != 0) {
                return skipInternal;
            }
            if (i2 > 0 || availableInternal() == 0) {
                return -1;
            }
            return skipInternal;
        }

        @Override // java.io.InputStream
        public long skip(long j) {
            if (j < 0) {
                throw new IndexOutOfBoundsException();
            }
            if (j > 2147483647L) {
                j = 2147483647L;
            }
            return readSkipInternal(null, 0, (int) j);
        }

        private int readSkipInternal(byte[] bArr, int i, int i2) {
            int i3 = i2;
            while (i3 > 0) {
                advanceIfCurrentPieceFullyRead();
                if (this.currentPiece == null) {
                    break;
                }
                int iMin = Math.min(this.currentPieceSize - this.currentPieceIndex, i3);
                if (bArr != null) {
                    this.currentPiece.copyTo(bArr, this.currentPieceIndex, i, iMin);
                    i += iMin;
                }
                this.currentPieceIndex += iMin;
                i3 -= iMin;
            }
            return i2 - i3;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            advanceIfCurrentPieceFullyRead();
            ByteString.LeafByteString leafByteString = this.currentPiece;
            if (leafByteString == null) {
                return -1;
            }
            int i = this.currentPieceIndex;
            this.currentPieceIndex = i + 1;
            return leafByteString.byteAt(i) & 255;
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            return availableInternal();
        }

        @Override // java.io.InputStream
        public void mark(int i) {
            this.mark = this.currentPieceOffsetInRope + this.currentPieceIndex;
        }

        @Override // java.io.InputStream
        public void reset() {
            synchronized (this) {
                initialize();
                readSkipInternal(null, 0, this.mark);
            }
        }

        private void initialize() {
            PieceIterator pieceIterator = new PieceIterator(RopeByteString.this);
            this.pieceIterator = pieceIterator;
            ByteString.LeafByteString next = pieceIterator.next();
            this.currentPiece = next;
            this.currentPieceSize = next.size();
            this.currentPieceIndex = 0;
            this.currentPieceOffsetInRope = 0;
        }

        private void advanceIfCurrentPieceFullyRead() {
            if (this.currentPiece != null) {
                int i = this.currentPieceIndex;
                int i2 = this.currentPieceSize;
                if (i == i2) {
                    this.currentPieceOffsetInRope += i2;
                    this.currentPieceIndex = 0;
                    if (this.pieceIterator.hasNext()) {
                        ByteString.LeafByteString next = this.pieceIterator.next();
                        this.currentPiece = next;
                        this.currentPieceSize = next.size();
                    } else {
                        this.currentPiece = null;
                        this.currentPieceSize = 0;
                    }
                }
            }
        }

        private int availableInternal() {
            return RopeByteString.this.size() - (this.currentPieceOffsetInRope + this.currentPieceIndex);
        }
    }
}
