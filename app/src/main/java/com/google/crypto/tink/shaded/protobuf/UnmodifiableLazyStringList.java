package com.google.crypto.tink.shaded.protobuf;

import android.graphics.Color;
import android.media.AudioTrack;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.facebook.imageutils.JfifUtil;
import java.util.AbstractList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import o.ArtificialStackFrames;
import o.onMessageChannelReady;
import o.onPostMessage;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class UnmodifiableLazyStringList extends AbstractList<String> implements LazyStringList, RandomAccess {
    private final LazyStringList list;

    @Override // com.google.crypto.tink.shaded.protobuf.LazyStringList
    public LazyStringList getUnmodifiableView() {
        return this;
    }

    public UnmodifiableLazyStringList(LazyStringList lazyStringList) {
        this.list = lazyStringList;
    }

    @Override // java.util.AbstractList, java.util.List
    public String get(int i) {
        return this.list.get(i);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.LazyStringList
    public Object getRaw(int i) {
        return this.list.getRaw(i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.list.size();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.LazyStringList
    public ByteString getByteString(int i) {
        return this.list.getByteString(i);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.LazyStringList
    public void add(ByteString byteString) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.LazyStringList
    public void set(int i, ByteString byteString) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.LazyStringList
    public boolean addAllByteString(Collection<? extends ByteString> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.LazyStringList
    public byte[] getByteArray(int i) {
        return this.list.getByteArray(i);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.LazyStringList
    public void add(byte[] bArr) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.LazyStringList
    public void set(int i, byte[] bArr) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.LazyStringList
    public boolean addAllByteArray(Collection<byte[]> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<String> listIterator(int i) {
        return new ListIterator<String>(this, i) { // from class: com.google.crypto.tink.shaded.protobuf.UnmodifiableLazyStringList.1
            ListIterator<String> iter;
            final /* synthetic */ UnmodifiableLazyStringList this$0;
            final /* synthetic */ int val$index;

            {
                this.val$index = i;
                this.this$0 = this;
                this.iter = this.list.listIterator(i);
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public boolean hasNext() {
                return this.iter.hasNext();
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public String next() {
                return this.iter.next();
            }

            @Override // java.util.ListIterator
            public boolean hasPrevious() {
                return this.iter.hasPrevious();
            }

            @Override // java.util.ListIterator
            public String previous() {
                return this.iter.previous();
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return this.iter.nextIndex();
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return this.iter.previousIndex();
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }

            @Override // java.util.ListIterator
            public void set(String str) {
                throw new UnsupportedOperationException();
            }

            @Override // java.util.ListIterator
            public void add(String str) {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<String> iterator() {
        return new Iterator<String>() { // from class: com.google.crypto.tink.shaded.protobuf.UnmodifiableLazyStringList.2
            Iterator<String> iter;
            private static final byte[] $$a = {52, -111, -122, 98};
            private static final int $$b = 93;
            private static int $10 = 0;
            private static int $11 = 1;
            private static int getARTIFICIAL_FRAME_PACKAGE_NAME = 0;
            private static int artificialFrame = 1;
            private static char[] IPostMessageService = {38287, 38362, 38356, 38361, 38359, 38355, 38361, 38359, 38356, 38354, 38366, 38399, 38287, 38285, 38393, 38396, 38288, 38287, 38285, 38377, 38380, 38388, 38353, 38347, 38356, 38392, 38380, 38345, 38353, 38354, 38348, 38355, 38363, 38355, 38383, 38380, 38355, 38356, 38285, 38390, 38391, 38358, 38353, 38350, 38355, 38358, 38350, 38382, 38279, 38374, 38353, 38350, 38355, 38353, 38345, 38357, 38360, 38358, 38356, 38351, 38355, 38374, 38157, 38151, 38161, 38171, 38161, 38156, 38157, 38159, 38157, 38172, 38168, 38153, 38153, 38280, 38357, 38357, 38372, 38376, 38361, 38363, 38361, 38360, 38365, 38375, 38272, 38386, 38353, 38384, 38382, 38350, 38358, 38355, 38350, 38353, 38358, 38391, 38390, 38361, 38355, 38351, 38356, 38358, 38360, 38277, 38347, 38357, 38360, 38357, 38359, 38353, 38348, 38355, 38356, 38312, 38286, 38285, 38283, 38391, 38287, 38357, 38348, 38351, 38372, 38369, 38355, 38361, 38361, 38363, 38359, 38312, 38391, 38358, 38353, 38350, 38355, 38358, 38350, 38382, 38384, 38353, 38386, 38399, 38369, 38359, 38357, 38360, 38357, 38347, 38348, 38356, 38364, 38360, 38358, 38356, 38351, 38355, 38361, 38207, 38377, 38179, 38181, 38194, 38196, 38377, 38174, 38179, 38190, 38181, 38178, 38196, 38194, 38180, 38377, 38198, 38177, 38198, 38189, 38194, 38179, 38198, 38196, 38190, 38193, 38190, 38179, 38181, 38194, 38356, 38366, 38375, 38370};
            private static char[] validateRelationship = {56126, 56107, 56260, 56120, 56075, 56093, 56079, 56074, 56080, 56281, 56125, 56092, 56095, 56076, 56082, 56277, 56106, 56108, 56110, 56077, 56105, 56088, 56094, 56086, 56116, 56084, 56267, 56073, 56087, 56067, 56078, 56064, 56083, 56115, 56127, 56097, 56268, 56265, 56085};
            private static int warmup = -1044259847;
            private static boolean requestPostMessageChannelWithExtras = true;
            private static boolean ICustomTabsServiceDefault = true;

            private static String $$c(int i, short s, int i2) {
                int i3 = i * 3;
                int i4 = 4 - (i2 * 2);
                byte[] bArr = $$a;
                int i5 = 122 - s;
                byte[] bArr2 = new byte[1 - i3];
                int i6 = 0 - i3;
                int i7 = -1;
                if (bArr == null) {
                    i5 = (-i5) + i6;
                    i4++;
                    i7 = -1;
                }
                while (true) {
                    int i8 = i7 + 1;
                    bArr2[i8] = (byte) i5;
                    if (i8 == i6) {
                        return new String(bArr2, 0);
                    }
                    i5 = (-bArr[i4]) + i5;
                    i4++;
                    i7 = i8;
                }
            }

            {
                this.iter = UnmodifiableLazyStringList.this.list.iterator();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.iter.hasNext();
            }

            @Override // java.util.Iterator
            public String next() {
                return this.iter.next();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }

            private static void b(char[] cArr, byte[] bArr, int i, int[] iArr, Object[] objArr) throws Throwable {
                int i2 = 2;
                int i3 = 2 % 2;
                onMessageChannelReady onmessagechannelready = new onMessageChannelReady();
                char[] cArr2 = validateRelationship;
                int i4 = 1;
                int i5 = 0;
                if (cArr2 != null) {
                    int i6 = $10;
                    int i7 = i6 + 43;
                    $11 = i7 % 128;
                    int i8 = i7 % 2;
                    int length = cArr2.length;
                    char[] cArr3 = new char[length];
                    int i9 = i6 + 21;
                    $11 = i9 % 128;
                    int i10 = i9 % 2;
                    int i11 = 0;
                    while (i11 < length) {
                        int i12 = $11 + 59;
                        $10 = i12 % 128;
                        int i13 = i12 % i2;
                        try {
                            Object[] objArr2 = new Object[i4];
                            objArr2[i5] = Integer.valueOf(cArr2[i11]);
                            Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(115862995);
                            if (objAccessartificialFrame == null) {
                                int longPressTimeout = (ViewConfiguration.getLongPressTimeout() >> 16) + 26;
                                char cKeyCodeFromString = (char) KeyEvent.keyCodeFromString("");
                                int mode = View.MeasureSpec.getMode(i5) + 1041;
                                byte b = (byte) i5;
                                byte b2 = (byte) (b + 1);
                                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation(longPressTimeout, cKeyCodeFromString, mode, -1719489573, false, $$c(b, b2, (byte) (b2 - 1)), new Class[]{Integer.TYPE});
                            }
                            cArr3[i11] = ((Character) ((java.lang.reflect.Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                            i11++;
                            int i14 = $10 + 57;
                            $11 = i14 % 128;
                            if (i14 % 2 == 0) {
                                int i15 = 5 / 5;
                            }
                            i2 = 2;
                            i4 = 1;
                            i5 = 0;
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
                try {
                    Object[] objArr3 = {Integer.valueOf(warmup)};
                    Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(-1820173622);
                    if (objAccessartificialFrame2 == null) {
                        byte b3 = (byte) 0;
                        objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getFadingEdgeLength() >> 16) + 15, (char) (KeyEvent.getDeadChar(0, 0) + 20488), 2148 - (ViewConfiguration.getScrollBarSize() >> 8), 216472770, false, $$c(b3, (byte) (b3 | 55), b3), new Class[]{Integer.TYPE});
                    }
                    int iIntValue = ((Integer) ((java.lang.reflect.Method) objAccessartificialFrame2).invoke(null, objArr3)).intValue();
                    int i16 = 59174;
                    if (ICustomTabsServiceDefault) {
                        onmessagechannelready.c = bArr.length;
                        char[] cArr4 = new char[onmessagechannelready.c];
                        onmessagechannelready.a = 0;
                        while (onmessagechannelready.a < onmessagechannelready.c) {
                            cArr4[onmessagechannelready.a] = (char) (cArr2[bArr[(onmessagechannelready.c - 1) - onmessagechannelready.a] + i] - iIntValue);
                            Object[] objArr4 = {onmessagechannelready, onmessagechannelready};
                            Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-2083387879);
                            if (objAccessartificialFrame3 == null) {
                                byte b4 = (byte) 0;
                                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation(21 - KeyEvent.normalizeMetaState(0), (char) (TextUtils.indexOf("", "", 0) + i16), 1943 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), 481771537, false, $$c(b4, (byte) (b4 | 56), b4), new Class[]{Object.class, Object.class});
                            }
                            ((java.lang.reflect.Method) objAccessartificialFrame3).invoke(null, objArr4);
                            i16 = 59174;
                        }
                        objArr[0] = new String(cArr4);
                        return;
                    }
                    if (requestPostMessageChannelWithExtras) {
                        onmessagechannelready.c = cArr.length;
                        char[] cArr5 = new char[onmessagechannelready.c];
                        onmessagechannelready.a = 0;
                        while (onmessagechannelready.a < onmessagechannelready.c) {
                            int i17 = $11 + 101;
                            $10 = i17 % 128;
                            int i18 = i17 % 2;
                            cArr5[onmessagechannelready.a] = (char) (cArr2[cArr[(onmessagechannelready.c - 1) - onmessagechannelready.a] - i] - iIntValue);
                            Object[] objArr5 = {onmessagechannelready, onmessagechannelready};
                            Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(-2083387879);
                            if (objAccessartificialFrame4 == null) {
                                byte b5 = (byte) 0;
                                objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation(21 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), (char) ((ViewConfiguration.getEdgeSlop() >> 16) + 59174), 1943 - KeyEvent.normalizeMetaState(0), 481771537, false, $$c(b5, (byte) (b5 | 56), b5), new Class[]{Object.class, Object.class});
                            }
                            ((java.lang.reflect.Method) objAccessartificialFrame4).invoke(null, objArr5);
                        }
                        objArr[0] = new String(cArr5);
                        return;
                    }
                    int i19 = 0;
                    onmessagechannelready.c = iArr.length;
                    char[] cArr6 = new char[onmessagechannelready.c];
                    while (true) {
                        onmessagechannelready.a = i19;
                        if (onmessagechannelready.a >= onmessagechannelready.c) {
                            objArr[0] = new String(cArr6);
                            return;
                        }
                        int i20 = $10 + 71;
                        $11 = i20 % 128;
                        if (i20 % 2 == 0) {
                            int i21 = onmessagechannelready.a;
                            int i22 = onmessagechannelready.c;
                            cArr6[i21] = (char) (cArr2[iArr[onmessagechannelready.a] >> i] / iIntValue);
                            int i23 = onmessagechannelready.a;
                            i19 = 0;
                        } else {
                            cArr6[onmessagechannelready.a] = (char) (cArr2[iArr[(onmessagechannelready.c - 1) - onmessagechannelready.a] - i] - iIntValue);
                            i19 = onmessagechannelready.a + 1;
                        }
                    }
                } catch (Throwable th2) {
                    Throwable cause2 = th2.getCause();
                    if (cause2 == null) {
                        throw th2;
                    }
                    throw cause2;
                }
            }

            private static void a(byte[] bArr, int[] iArr, boolean z, Object[] objArr) throws Throwable {
                int i = 2 % 2;
                onPostMessage onpostmessage = new onPostMessage();
                int i2 = iArr[0];
                byte b = 1;
                int i3 = iArr[1];
                int i4 = iArr[2];
                int i5 = iArr[3];
                char[] cArr = IPostMessageService;
                if (cArr != null) {
                    int length = cArr.length;
                    char[] cArr2 = new char[length];
                    for (int i6 = 0; i6 < length; i6++) {
                        try {
                            Object[] objArr2 = {Integer.valueOf(cArr[i6])};
                            Object objAccessartificialFrame = ArtificialStackFrames.accessartificialFrame(-1782207618);
                            if (objAccessartificialFrame == null) {
                                byte b2 = (byte) 0;
                                objAccessartificialFrame = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 10, (char) KeyEvent.getDeadChar(0, 0), (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + 1562, 178318710, false, $$c(b2, (byte) (b2 | 57), b2), new Class[]{Integer.TYPE});
                            }
                            cArr2[i6] = ((Character) ((java.lang.reflect.Method) objAccessartificialFrame).invoke(null, objArr2)).charValue();
                        } catch (Throwable th) {
                            Throwable cause = th.getCause();
                            if (cause == null) {
                                throw th;
                            }
                            throw cause;
                        }
                    }
                    cArr = cArr2;
                }
                char[] cArr3 = new char[i3];
                System.arraycopy(cArr, i2, cArr3, 0, i3);
                if (bArr != null) {
                    int i7 = $10 + 27;
                    $11 = i7 % 128;
                    int i8 = i7 % 2;
                    char[] cArr4 = new char[i3];
                    onpostmessage.a = 0;
                    char c = 0;
                    while (onpostmessage.a < i3) {
                        if (bArr[onpostmessage.a] == b) {
                            int i9 = onpostmessage.a;
                            char c2 = cArr3[onpostmessage.a];
                            Object[] objArr3 = new Object[2];
                            objArr3[b] = Integer.valueOf(c);
                            objArr3[0] = Integer.valueOf(c2);
                            Object objAccessartificialFrame2 = ArtificialStackFrames.accessartificialFrame(1378437083);
                            if (objAccessartificialFrame2 == null) {
                                int trimmedLength = TextUtils.getTrimmedLength("") + 23;
                                char cArgb = (char) Color.argb(0, 0, 0, 0);
                                int i10 = 2442 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1));
                                byte b3 = (byte) 0;
                                String str$$c = $$c(b3, (byte) (b3 | 54), b3);
                                Class[] clsArr = new Class[2];
                                clsArr[0] = Integer.TYPE;
                                clsArr[b] = Integer.TYPE;
                                objAccessartificialFrame2 = ArtificialStackFrames.coroutineCreation(trimmedLength, cArgb, i10, -850656813, false, str$$c, clsArr);
                            }
                            cArr4[i9] = ((Character) ((java.lang.reflect.Method) objAccessartificialFrame2).invoke(null, objArr3)).charValue();
                        } else {
                            int i11 = onpostmessage.a;
                            char c3 = cArr3[onpostmessage.a];
                            Object[] objArr4 = new Object[2];
                            objArr4[b] = Integer.valueOf(c);
                            objArr4[0] = Integer.valueOf(c3);
                            Object objAccessartificialFrame3 = ArtificialStackFrames.accessartificialFrame(-314759072);
                            if (objAccessartificialFrame3 == null) {
                                byte b4 = (byte) 0;
                                byte b5 = b4;
                                objAccessartificialFrame3 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getWindowTouchSlop() >> 8) + 11, (char) (TextUtils.lastIndexOf("", '0') + b), 1561 - TextUtils.lastIndexOf("", '0'), 1918398056, false, $$c(b4, b5, b5), new Class[]{Integer.TYPE, Integer.TYPE});
                            }
                            cArr4[i11] = ((Character) ((java.lang.reflect.Method) objAccessartificialFrame3).invoke(null, objArr4)).charValue();
                        }
                        c = cArr4[onpostmessage.a];
                        Object[] objArr5 = {onpostmessage, onpostmessage};
                        Object objAccessartificialFrame4 = ArtificialStackFrames.accessartificialFrame(898481158);
                        if (objAccessartificialFrame4 == null) {
                            objAccessartificialFrame4 = ArtificialStackFrames.coroutineCreation((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 21, (char) (29363 - (ViewConfiguration.getMinimumFlingVelocity() >> 16)), TextUtils.getCapsMode("", 0, 0) + JfifUtil.MARKER_RST7, -1427572210, false, "F", new Class[]{Object.class, Object.class});
                        }
                        ((java.lang.reflect.Method) objAccessartificialFrame4).invoke(null, objArr5);
                        b = 1;
                    }
                    cArr3 = cArr4;
                }
                if (i5 > 0) {
                    char[] cArr5 = new char[i3];
                    System.arraycopy(cArr3, 0, cArr5, 0, i3);
                    int i12 = i3 - i5;
                    System.arraycopy(cArr5, 0, cArr3, i12, i5);
                    System.arraycopy(cArr5, i5, cArr3, 0, i12);
                }
                if (z) {
                    char[] cArr6 = new char[i3];
                    onpostmessage.a = 0;
                    while (onpostmessage.a < i3) {
                        cArr6[onpostmessage.a] = cArr3[(i3 - onpostmessage.a) - 1];
                        onpostmessage.a++;
                        int i13 = $11 + 41;
                        $10 = i13 % 128;
                        if (i13 % 2 != 0) {
                            int i14 = 3 / 3;
                        }
                    }
                    cArr3 = cArr6;
                }
                if (i4 > 0) {
                    int i15 = $11 + 125;
                    $10 = i15 % 128;
                    int i16 = i15 % 2;
                    onpostmessage.a = 0;
                    while (onpostmessage.a < i3) {
                        cArr3[onpostmessage.a] = (char) (cArr3[onpostmessage.a] - iArr[2]);
                        onpostmessage.a++;
                    }
                }
                objArr[0] = new String(cArr3);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r6v0 */
            /* JADX WARN: Type inference failed for: r6v49 */
            /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
                java.util.NoSuchElementException
                	at java.base/java.util.TreeMap.key(Unknown Source)
                	at java.base/java.util.TreeMap.lastKey(Unknown Source)
                	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
                	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
                	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
                */
            public static java.lang.Object[] accessartificialFrame(android.content.Context r24, int r25, int r26) {
                /*
                    Method dump skipped, instruction units count: 2568
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.UnmodifiableLazyStringList.AnonymousClass2.accessartificialFrame(android.content.Context, int, int):java.lang.Object[]");
            }
        };
    }

    @Override // com.google.crypto.tink.shaded.protobuf.LazyStringList
    public List<?> getUnderlyingElements() {
        return this.list.getUnderlyingElements();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.LazyStringList
    public void mergeFrom(LazyStringList lazyStringList) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.LazyStringList
    public List<byte[]> asByteArrayList() {
        return Collections.unmodifiableList(this.list.asByteArrayList());
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ProtocolStringList
    public List<ByteString> asByteStringList() {
        return Collections.unmodifiableList(this.list.asByteStringList());
    }
}
